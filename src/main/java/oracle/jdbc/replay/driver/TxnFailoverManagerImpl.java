package oracle.jdbc.replay.driver;

import java.lang.reflect.Method;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.SQLRecoverableException;
import java.sql.Statement;
import java.util.Arrays;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import oracle.jdbc.LogicalTransactionId;
import oracle.jdbc.LogicalTransactionIdEvent;
import oracle.jdbc.LogicalTransactionIdEventListener;
import oracle.jdbc.driver.DatabaseError;
import oracle.jdbc.internal.OracleConnection;
import oracle.jdbc.internal.ReplayContext;
import oracle.jdbc.replay.internal.ConnectionInitializationCallback;
import oracle.jdbc.replay.internal.OracleDataSource;

class TxnFailoverManagerImpl implements TxnFailoverManager, LogicalTransactionIdEventListener {
   private static final String MONITOR_TXN = "BEGIN DBMS_APP_CONT_PRVT.MONITOR_TXN; END;";
   private static final String BEGIN_REPLAY = "BEGIN DBMS_APP_CONT_PRVT.BEGIN_REPLAY; END;";
   private static final String END_REPLAY = "BEGIN DBMS_APP_CONT_PRVT.END_REPLAY; END;";
   private TxnFailoverManagerImpl.CallHistoryEntry head;
   private TxnFailoverManagerImpl.CallHistoryEntry tail;
   private TxnFailoverManagerImpl.ReplayLifecycle lifecycle;
   private static final int DIRECTIVE_ENQUEUE_CALL = 1;
   private static final int DIRECTIVE_REQ_SCOPE_CRSR = 2;
   private static final int DIRECTIVE_REPLAY_ENABLED = 4;
   private static final int DIRECTIVE_EMPTY_QUEUE = 8;
   private Object replayResult;
   private long requestStartTime;
   private long replayInitiationTimeout;
   private static final int REPLAY_RETRIES = 3;
   private int replayRetries;
   private LogicalTransactionId ltxid;
   private LogicalTransactionId oldLtxidForPrepareReplay;
   private ReplayContext[] replayContext;
   private ReplayContext cxtBeforePrepareReplay;
   private OracleDataSource replayDataSource;
   private TxnReplayableBase connectionProxy;
   private String connectionProxyName;
   private Method callCausingReplayError;
   private int replayErrorCode;
   private String replayErrorMessage;
   private boolean doNotAbortConn;
   private boolean isReplayInDynamicMode;
   private static final int QUEUE_NUMBER = 2;
   private static final int NOT_IN_QUEUE = -1;
   private static int activeQueues = 2;
   private static final int INIT_EMPTY_COUNT = 0;
   private static final int NA_EMPTY_COUNT = -1;
   private static final int REQ_SCOPE_EMPTY_COUNT = Integer.MAX_VALUE;
   private int[] queueEmptyCounts;
   boolean seenRoundtripCallInRequest;
   boolean didReplayingLastCallDisableReplay;
   short nestedLevelOfTopLevelCalls;
   private static final HashSet postExecuteGetCalls = new HashSet(Arrays.asList("getGeneratedKeys", "getMoreResults", "getResultSet", "getUpdateCount", "getMetaData", "getArray", "getBigDecimal", "getBlob", "getBoolean", "getByte", "getBytes", "getCharacterStream", "getClob", "getDate", "getDouble", "getFloat", "getInt", "getLong", "getNCharacterStream", "getNClob", "getNString", "getObject", "getRef", "getRowId", "getShort", "getSQLXML", "getString", "getTime", "getTimestamp", "getURL", "wasNull", "getReturnResultSet", "getARRAY", "getAsciiStream", "getBFILE", "getBfile", "getBinaryStream", "getBLOB", "getCHAR", "getCLOB", "getCursor", "getCustomDatum", "getORAData", "getAnyDataEmbeddedObject", "getDATE", "getNUMBER", "getOPAQUE", "getOracleObject", "getRAW", "getREF", "getROWID", "getSTRUCT", "getINTERVALYM", "getINTERVALDS", "getTIMESTAMP", "getTIMESTAMPTZ", "getTIMESTAMPLTZ", "getUnicodeStream", "getPlsqlIndexTable", "getOraclePlsqlIndexTable"));
   private static final String NULL_METHOD_NAME = "NULL METHOD";
   private static final ExecutorService executor = Executors.newSingleThreadExecutor(new ThreadFactory() {
      private static final String THREAD_NAME = "OJDBC-AC-WORKER-THREAD";

      public Thread newThread(Runnable var1) {
         Thread var2 = new Thread((ThreadGroup)null, var1, "OJDBC-AC-WORKER-THREAD");
         var2.setPriority(5);
         var2.setDaemon(true);
         return var2;
      }
   });
   private static final String PREPARE_REPLAY = "DECLARE PROCEDURE PREPARE_REPLAY_WRAPPER(ltxid IN RAW, is_replay IN NUMBER, ac IN NUMBER, fncode IN BINARY_INTEGER, sql_text IN VARCHAR2, is_committed OUT NUMBER, is_embedded OUT NUMBER) IS attempting_replay BOOLEAN; auto_commit BOOLEAN; committed BOOLEAN; embedded BOOLEAN; BEGIN if is_replay = 1 then attempting_replay := true; else attempting_replay := false; end if; if ac = 1 then auto_commit := true; else auto_commit := false; end if; DBMS_APP_CONT_PRVT.PREPARE_REPLAY(ltxid, attempting_replay, auto_commit, fncode, sql_text, committed, embedded); if committed then is_committed := 1; else is_committed := 0; end if; if embedded then is_embedded := 1; else is_embedded := 0; end if; END; BEGIN PREPARE_REPLAY_WRAPPER(?,?,?,?,?,?,?); END;";
   private static final String _Copyright_2007_Oracle_All_Rights_Reserved_ = null;
   public static final String BUILD_DATE = "Thu_Apr_04_15:09:24_PDT_2013";

   private TxnFailoverManagerImpl(TxnReplayableBase var1, OracleDataSource var2) throws SQLException {
      this.lifecycle = TxnFailoverManagerImpl.ReplayLifecycle.INTERNALLY_DISABLED;
      this.replayInitiationTimeout = 300L;
      this.replayRetries = 0;
      this.ltxid = null;
      this.oldLtxidForPrepareReplay = null;
      this.replayContext = null;
      this.replayDataSource = null;
      this.doNotAbortConn = false;
      this.isReplayInDynamicMode = true;
      this.queueEmptyCounts = new int[2];
      this.seenRoundtripCallInRequest = false;
      this.didReplayingLastCallDisableReplay = false;
      this.nestedLevelOfTopLevelCalls = 0;
      this.connectionProxy = var1;
      this.connectionProxyName = this.connectionProxy.thisProxyNameInLog;
      this.replayDataSource = var2;
      OracleConnection var3 = (OracleConnection)var1.getDelegate();
      this.ltxid = var3.getLogicalTransactionId();
      this.replayContext = null;
      activeQueues = 2;
      this.queueEmptyCounts = new int[2];

      for(int var4 = 0; var4 < activeQueues; ++var4) {
         this.queueEmptyCounts[var4] = 0;
      }

      var3.addLogicalTransactionIdEventListener(this);
   }

   static TxnFailoverManager getFailoverManager(TxnReplayableBase var0, OracleDataSource var1) throws SQLException {
      return new TxnFailoverManagerImpl(var0, var1);
   }

   private void append(TxnFailoverManagerImpl.CallHistoryEntry var1) {
      var1.prevEntry = this.tail;
      var1.nextEntry = null;
      if (this.tail != null) {
         this.tail.nextEntry = var1;
      }

      this.tail = var1;
      if (this.head == null) {
         this.head = var1;
      }

      JDBCReplayable var2 = (JDBCReplayable)var1.jdbcProxy;
      var2.addToSameProxyList(var1);
   }

   private void remove(TxnFailoverManagerImpl.CallHistoryEntry var1) {
      if (var1.nextEntry != null) {
         var1.nextEntry.prevEntry = var1.prevEntry;
      }

      if (var1.prevEntry != null) {
         var1.prevEntry.nextEntry = var1.nextEntry;
      }

      if (this.head == var1) {
         this.head = var1.nextEntry;
      }

      if (this.tail == var1) {
         this.tail = var1.prevEntry;
      }

      JDBCReplayable var2 = (JDBCReplayable)var1.jdbcProxy;
      var2.removeFromSameProxyList(var1);
   }

   TxnFailoverManagerImpl.CallHistoryEntry record(Object var1, Method var2, Object[] var3, String var4) {
      if (this.tail != null && this.tail.method != null && "started".equals(this.tail.callStatus)) {
         ++this.nestedLevelOfTopLevelCalls;
         return null;
      } else {
         synchronized(this) {
            TxnFailoverManagerImpl.CallHistoryEntry var6 = new TxnFailoverManagerImpl.CallHistoryEntry(var1, var2, var3, var4);
            this.append(var6);
            return var6;
         }
      }
   }

   private String dumpHistory() {
      String var1 = "Dump History: \n";
      if (this.head != null) {
         TxnFailoverManagerImpl.CallHistoryEntry var2 = this.head;

         while(true) {
            var1 = var1 + var2.toString();
            if (var2 == this.tail) {
               break;
            }

            var2 = var2.nextEntry;
         }
      }

      return var1;
   }

   void update(Object var1, TxnFailoverManagerImpl.CallHistoryEntry var2, Object var3, String var4, long var5, SQLException var7) {
      if (this.nestedLevelOfTopLevelCalls > 0) {
         --this.nestedLevelOfTopLevelCalls;
      } else {
         ReplayContext[] var8 = null;
         boolean var9 = false;
         ReplayContext[] var10 = null;
         short var11 = -1;
         int var12 = 0;
         boolean var13 = false;
         boolean var14 = false;
         boolean var34 = false;

         TxnFailoverManagerImpl.CallHistoryEntry var40;
         label511: {
            int var16;
            ReplayContext var17;
            int var10002;
            int var18;
            short var19;
            long var20;
            label512: {
               try {
                  var34 = true;
                  OracleConnection var15 = (OracleConnection)this.connectionProxy.getDelegate();
                  var8 = var15.getReplayContext();
                  var34 = false;
                  break label512;
               } catch (SQLException var36) {
                  var9 = true;
                  var34 = false;
               } finally {
                  if (var34) {
                     TxnFailoverManagerImpl.CallHistoryEntry var23 = var2 == null ? this.tail : var2;
                     if (!var9) {
                        if (var8 != null) {
                           this.replayContext = var8;
                           var10 = new ReplayContext[var8.length];
                           if (var8.length > 0) {
                              this.seenRoundtripCallInRequest = true;
                           }

                           for(int var24 = 0; var24 < var8.length; ++var24) {
                              ReplayContext var25 = var8[var24];
                              int var26 = (int)var25.getDirectives();
                              short var27 = var25.getQueue();
                              if ((var26 & 4) == 0) {
                                 var9 = true;
                                 if (this.lifecycle == TxnFailoverManagerImpl.ReplayLifecycle.REPLAYING_LASTCALL) {
                                    this.didReplayingLastCallDisableReplay = true;
                                 }

                                 long var28 = var25.getErrorCode();
                                 this.disableReplayInternal(var23.method, 384, "Replay disabled by server Continuity Management", (SQLRecoverableException)null);
                                 return;
                              }

                              if ((var26 & 8) == 8) {
                                 var10002 = this.queueEmptyCounts[var27]++;
                              }

                              assert (var26 & 1) == 1 || !var14 : "AC runtime: the server doesn't send ENQUEUE for all the RPCs of the same JDBC call";

                              if ((var26 & 1) == 1) {
                                 var10[var24] = var25;
                                 int var10000 = this.queueEmptyCounts[var27];
                                 var14 = true;
                              }

                              if ((var26 & 2) == 2) {
                                 var13 = true;
                              }
                           }
                        } else {
                           if (var23.replayContext != null) {
                              return;
                           }

                           boolean var38 = true;
                           boolean var39 = false;
                        }
                     } else {
                        this.disableReplayInternal(var23.method, 383, "Replay disabled because getting replay context failed", (SQLRecoverableException)null);
                     }

                  }
               }

               var40 = var2 == null ? this.tail : var2;
               if (!var9) {
                  if (var8 != null) {
                     this.replayContext = var8;
                     var10 = new ReplayContext[var8.length];
                     if (var8.length > 0) {
                        this.seenRoundtripCallInRequest = true;
                     }

                     var16 = 0;

                     while(true) {
                        if (var16 >= var8.length) {
                           break label511;
                        }

                        var17 = var8[var16];
                        var18 = (int)var17.getDirectives();
                        var19 = var17.getQueue();
                        if ((var18 & 4) == 0) {
                           var9 = true;
                           if (this.lifecycle == TxnFailoverManagerImpl.ReplayLifecycle.REPLAYING_LASTCALL) {
                              this.didReplayingLastCallDisableReplay = true;
                           }

                           var20 = var17.getErrorCode();
                           this.disableReplayInternal(var40.method, 384, "Replay disabled by server Continuity Management", (SQLRecoverableException)null);
                           return;
                        }

                        if ((var18 & 8) == 8) {
                           var10002 = this.queueEmptyCounts[var19]++;
                        }

                        assert (var18 & 1) == 1 || !var14 : "AC runtime: the server doesn't send ENQUEUE for all the RPCs of the same JDBC call";

                        if ((var18 & 1) == 1) {
                           var10[var16] = var17;
                           var11 = var19;
                           var12 = this.queueEmptyCounts[var19];
                           var14 = true;
                        }

                        if ((var18 & 2) == 2) {
                           var13 = true;
                        }

                        ++var16;
                     }
                  } else {
                     if (var40.replayContext != null) {
                        return;
                     }

                     var11 = -1;
                     var12 = 0;
                  }
               } else {
                  this.disableReplayInternal(var40.method, 383, "Replay disabled because getting replay context failed", (SQLRecoverableException)null);
               }
               break label511;
            }

            var40 = var2 == null ? this.tail : var2;
            if (!var9) {
               if (var8 != null) {
                  this.replayContext = var8;
                  var10 = new ReplayContext[var8.length];
                  if (var8.length > 0) {
                     this.seenRoundtripCallInRequest = true;
                  }

                  for(var16 = 0; var16 < var8.length; ++var16) {
                     var17 = var8[var16];
                     var18 = (int)var17.getDirectives();
                     var19 = var17.getQueue();
                     if ((var18 & 4) == 0) {
                        var9 = true;
                        if (this.lifecycle == TxnFailoverManagerImpl.ReplayLifecycle.REPLAYING_LASTCALL) {
                           this.didReplayingLastCallDisableReplay = true;
                        }

                        var20 = var17.getErrorCode();
                        this.disableReplayInternal(var40.method, 384, "Replay disabled by server Continuity Management", (SQLRecoverableException)null);
                        return;
                     }

                     if ((var18 & 8) == 8) {
                        var10002 = this.queueEmptyCounts[var19]++;
                     }

                     assert (var18 & 1) == 1 || !var14 : "AC runtime: the server doesn't send ENQUEUE for all the RPCs of the same JDBC call";

                     if ((var18 & 1) == 1) {
                        var10[var16] = var17;
                        var11 = var19;
                        var12 = this.queueEmptyCounts[var19];
                        var14 = true;
                     }

                     if ((var18 & 2) == 2) {
                        var13 = true;
                     }
                  }
               } else {
                  if (var40.replayContext != null) {
                     return;
                  }

                  var11 = -1;
                  var12 = 0;
               }
            } else {
               this.disableReplayInternal(var40.method, 383, "Replay disabled because getting replay context failed", (SQLRecoverableException)null);
            }
         }

         if (this.lifecycle != TxnFailoverManagerImpl.ReplayLifecycle.INTERNALLY_DISABLED && this.tail != null) {
            var40 = var2 == null ? this.tail : var2;
            synchronized(this) {
               if (var40 != null && var40.method != null) {
                  var40.method.getName();
               } else {
                  String var41 = "NULL METHOD";
               }

               var40.result = var3;
               var40.checksum = var5;
               ReplayContext[] var43;
               if (var10 != null) {
                  if (var40.replayContext == null) {
                     var40.replayContext = var10;
                  } else {
                     var43 = new ReplayContext[var40.replayContext.length + var10.length];
                     System.arraycopy(var40.replayContext, 0, var43, 0, var40.replayContext.length);
                     System.arraycopy(var10, 0, var43, var40.replayContext.length, var10.length);
                     var40.replayContext = var43;
                  }
               }

               var40.callException = var7;
               var40.queueId = var11;
               var40.queueEmptyCount = var12;
               var40.serverAsksToEnqueue = var14;
               var40.callStatus = var4;
               if (var10 != null) {
                  var43 = var10;
                  int var44 = var10.length;

                  for(int var45 = 0; var45 < var44; ++var45) {
                     ReplayContext var21 = var43[var45];
                     if (var21 == null) {
                     }
                  }
               }
            }

            if (!this.isSessionStateConsistencyDynamic() && var13) {
               TxnFailoverManagerImpl.CallHistoryEntry var42 = ((TxnReplayableResultSet)var40.jdbcProxy).creatorCallEntry;
               var42.queueEmptyCount = Integer.MAX_VALUE;
            }
         }

      }
   }

   synchronized void purge() {
      for(TxnFailoverManagerImpl.CallHistoryEntry var1 = this.head; var1 != null; var1 = var1.nextEntry) {
         this.remove(var1);
      }

   }

   synchronized void purgeForSameProxy(Set var1, TxnFailoverManagerImpl.CallHistoryEntry var2) {
      Object var10000;
      if (var2 == null) {
         var10000 = null;
      } else {
         var10000 = var2.jdbcProxy;
      }

      for(TxnFailoverManagerImpl.CallHistoryEntry var6 = var2; var6 != null; var6 = var6.nextEntrySameProxy) {
         Object var4 = var6.result;
         if (var4 != null && var4 instanceof JDBCReplayable && !var1.contains(var4)) {
            JDBCReplayable var5 = (JDBCReplayable)var4;
            var5.purgeSameProxyList();
            var1.add(var5);
         }

         this.remove(var6);
      }

   }

   synchronized boolean isEmpty() {
      return this.head == null;
   }

   Object handleOutage(SQLRecoverableException var1) throws SQLException {
      synchronized(this) {
         this.replayRetries = 0;

         label49:
         while(true) {
            TxnFailoverManagerImpl.ReplayLifecycle var4;
            try {
               Object var10000 = this.handleOutageInternal(var1, this.replayRetries);
               return var10000;
            } catch (SQLRecoverableException var6) {
               var4 = this.lifecycle;
               switch(var4) {
               case REPLAYING:
               case REPLAYING_CALLBACK:
               case REPLAYING_LASTCALL:
                  ++this.replayRetries;
               case ALWAYS_DISABLED:
               case INTERNALLY_DISABLED:
               case EXTERNALLY_DISABLED:
               case ENABLED_NOT_REPLAYING:
               case INTERNALLY_FAILED:
               }
            } catch (SQLException var7) {
               var4 = this.lifecycle;
               switch(var4) {
               case REPLAYING:
               case REPLAYING_CALLBACK:
               case ENABLED_NOT_REPLAYING:
               default:
                  break;
               case REPLAYING_LASTCALL:
                  break label49;
               case ALWAYS_DISABLED:
               case INTERNALLY_DISABLED:
               case EXTERNALLY_DISABLED:
                  if (this.didReplayingLastCallDisableReplay) {
                     throw var7;
                  }

                  this.throwOriginalExceptionWithReplayError(this.replayErrorCode, this.replayErrorMessage, var1);
                  break label49;
               case INTERNALLY_FAILED:
                  ++this.replayRetries;
                  this.lifecycle = TxnFailoverManagerImpl.ReplayLifecycle.REPLAYING;
               }
            }

            if (this.replayRetries > 3) {
               this.disableReplayAndThrowOriginalError((Method)null, 378, "Replay disabled because maximum number of retries is exceeded", var1);
               return null;
            }
         }

         this.lifecycle = TxnFailoverManagerImpl.ReplayLifecycle.ENABLED_NOT_REPLAYING;
         // todo throw var7;
         throw new SQLException("var7...");
      }
   }

   synchronized Object handleOutageInternal(SQLRecoverableException var1, int var2) throws SQLException {
      this.didReplayingLastCallDisableReplay = false;
      TxnFailoverManagerImpl.ReplayLifecycle var3 = this.lifecycle;
      if (this.lifecycle != TxnFailoverManagerImpl.ReplayLifecycle.ENABLED_NOT_REPLAYING && this.lifecycle != TxnFailoverManagerImpl.ReplayLifecycle.REPLAYING && this.lifecycle != TxnFailoverManagerImpl.ReplayLifecycle.REPLAYING_LASTCALL && this.lifecycle != TxnFailoverManagerImpl.ReplayLifecycle.REPLAYING_CALLBACK) {
         if (this.replayErrorCode == 0) {
            this.doNotAbortConn = true;
            this.replayErrorCode = 370;
            this.replayErrorMessage = "Replay disabled";
         }

         this.throwReplayExceptionInternal(this.replayErrorCode, this.replayErrorMessage, var1);
      }

      OracleConnection var4 = (OracleConnection)this.connectionProxy.getDelegate();
      short var5 = var4.getExecutingRPCFunctionCode();
      String var6 = var4.getExecutingRPCSQL();
      ReplayContext var7 = var4.getLastReplayContext();
      if (var7 != null) {
         this.cxtBeforePrepareReplay = var7;
      }

      OracleConnection var8 = (OracleConnection)this.replayDataSource.getConnectionNoProxy(((TxnReplayableConnection)this.connectionProxy).originalUser, ((TxnReplayableConnection)this.connectionProxy).originalPasswd);
      if (var8 == null) {
         this.disableReplayAndThrowException((Method)null, 382, "Replay disabled because Failover_Retries is exceeded", var1);
      }

      this.connectionProxy.setDelegate(var8);
      var8.setChecksumMode(OracleConnection.ChecksumMode.CALCULATE_CHECKSUM_BINDS);
      this.oldLtxidForPrepareReplay = this.ltxid;
      this.ltxid = var8.getLogicalTransactionId();
      var8.addLogicalTransactionIdEventListener(this);
      String var9 = this.tail.method.getName();
      var8.setReplayContext(new ReplayContext[]{this.cxtBeforePrepareReplay});
      boolean var10 = this.prepareReplay(var8, var1, var5, var6);
      if (var10) {
         if (this.isSessionStateConsistencyDynamic()) {
            if (var9.equals("execute")) {
               return false;
            }

            if (var9.equals("commit")) {
               return null;
            }

            return null;
         }

         int var10002 = this.queueEmptyCounts[1]++;
      }

      long var11 = System.currentTimeMillis();
      if (this.requestStartTime + this.replayInitiationTimeout * 1000L < var11) {
         this.disableReplayAndThrowException((Method)null, 377, "Replay disabled because ReplayInitiationTimeout is exceeded", var1);
      }

      var8.getReplayContext();
      this.lifecycle = TxnFailoverManagerImpl.ReplayLifecycle.REPLAYING_CALLBACK;
      ConnectionInitializationCallback var13 = this.replayDataSource.getConnectionInitializationCallback();
      if (var13 != null) {
         try {
            var13.initialize((Connection)this.connectionProxy);
         } catch (SQLRecoverableException var15) {
            throw var15;
         } catch (SQLException var16) {
            this.disableReplayAndThrowException((Method)null, 379, "Replay disabled because Init callback failed", var1);
         }

         EnumSet var14 = var8.getTransactionState();
         if (var14.contains(OracleConnection.TransactionState.TRANSACTION_STARTED)) {
            this.disableReplayAndThrowException((Method)null, 380, "Replay disabled because of open transaction in Init callback", var1);
         }
      }

      this.lifecycle = TxnFailoverManagerImpl.ReplayLifecycle.REPLAYING;
      this.beginReplay(var8, var1);
      this.replayResult = this.replayAllBeforeLastCall(var1);
      if (this.tail.replayContext != null && this.tail.replayContext.length != 0) {
         var8.registerEndReplayCallback(new EndReplayCallback(this, var8, var1));
      } else {
         this.endReplay(var8, var1);
      }

      if (!var10) {
         if (this.tail != null) {
            this.replayResult = ((JDBCReplayable)this.tail.jdbcProxy).replayOneCall(this.tail, var1);
         }
      } else if (!this.isSessionStateConsistencyDynamic()) {
         this.tail.callStatus = "completed";
         this.tail.queueId = 1;
         this.tail.queueEmptyCount = this.queueEmptyCounts[1];
         this.tail.serverAsksToEnqueue = false;
         if (var9.equals("execute")) {
            this.replayResult = false;
         } else if (var9.equals("commit")) {
            this.replayResult = null;
         } else {
            this.replayResult = null;
         }
      }

      if (this.lifecycle == TxnFailoverManagerImpl.ReplayLifecycle.REPLAYING_LASTCALL) {
         this.lifecycle = TxnFailoverManagerImpl.ReplayLifecycle.ENABLED_NOT_REPLAYING;
      }

      return this.replayResult;
   }

   private synchronized Object replayAllBeforeLastCall(SQLRecoverableException var1) throws SQLException {
      Object var2 = null;

      for(TxnFailoverManagerImpl.CallHistoryEntry var3 = this.head; var3 != this.tail; var3 = var3.nextEntry) {
         String var4 = var3.method == null ? "NULL METHOD" : var3.method.getName();
         TxnReplayableBase var5 = (TxnReplayableBase)var3.jdbcProxy;
         String var6 = var5.thisProxyNameInLog;
         if ((!this.isSessionStateConsistencyDynamic() || var3.replayContext != null && !var3.serverAsksToEnqueue) && (this.isSessionStateConsistencyDynamic() || !var5.isCreatingCallReplayable || (var3.replayContext != null || postExecuteGetCalls.contains(var4)) && (var3.replayContext != null || !postExecuteGetCalls.contains(var4) || !var5.isCurrentExecuteReplayable) && (!var3.serverAsksToEnqueue || var3.replayContext == null || var3.queueId < 0 || var3.queueId >= this.queueEmptyCounts.length || var3.queueEmptyCount != this.queueEmptyCounts[var3.queueId]) && var3.queueEmptyCount != Integer.MAX_VALUE)) {
            if (!this.isSessionStateConsistencyDynamic() && var5 instanceof TxnReplayableStatement && var4.startsWith("execute")) {
               var5.isCurrentExecuteReplayable = false;
            }

            if (!this.isSessionStateConsistencyDynamic() && var3.result != null && var3.result instanceof TxnReplayableBase) {
               ((TxnReplayableBase)var3.result).isCreatingCallReplayable = false;
            }
         } else {
            var2 = var5.replayOneCall(var3, var1);
            if (!this.isSessionStateConsistencyDynamic() && var5 instanceof TxnReplayableStatement && var4.startsWith("execute")) {
               var5.isCurrentExecuteReplayable = true;
            }

            if (!this.isSessionStateConsistencyDynamic() && var3.result != null && var3.result instanceof TxnReplayableBase) {
               ((TxnReplayableBase)var3.result).isCreatingCallReplayable = true;
            }

            if (this.lifecycle != TxnFailoverManagerImpl.ReplayLifecycle.ENABLED_NOT_REPLAYING && this.lifecycle != TxnFailoverManagerImpl.ReplayLifecycle.REPLAYING && this.lifecycle != TxnFailoverManagerImpl.ReplayLifecycle.REPLAYING_LASTCALL && this.lifecycle != TxnFailoverManagerImpl.ReplayLifecycle.REPLAYING_CALLBACK) {
               this.throwReplayExceptionInternal(this.replayErrorCode, this.replayErrorMessage, var1);
            }
         }
      }

      return var2;
   }

   TxnFailoverManagerImpl.ReplayLifecycle getReplayLifecycle() {
      return this.lifecycle;
   }

   void setDataSource(OracleDataSource var1) {
      this.replayDataSource = var1;
   }

   void setReplayInitiationTimeout(int var1) throws SQLException {
      this.replayInitiationTimeout = (long)var1;
   }

   boolean isSessionStateConsistencyDynamic() {
      return this.isReplayInDynamicMode;
   }

   void setSessionStateConsistency(boolean var1) throws SQLException {
      this.isReplayInDynamicMode = !var1;
   }

   synchronized void beginRequest() throws SQLException {
      if (this.lifecycle != TxnFailoverManagerImpl.ReplayLifecycle.ALWAYS_DISABLED) {
         if (this.lifecycle != TxnFailoverManagerImpl.ReplayLifecycle.INTERNALLY_DISABLED) {
            throw DatabaseError.createSqlException(391);
         } else {
            this.requestStartTime = System.currentTimeMillis();
            OracleConnection var1 = (OracleConnection)this.connectionProxy.getDelegate();
            var1.getReplayContext();
            if (this.isReplayInDynamicMode) {
               var1.setReplayOperations(EnumSet.of(OracleConnection.ReplayOperation.KPDSS_SESSSTATE_REQUEST_BEGIN, OracleConnection.ReplayOperation.KPDSS_SESSSTATE_APPCONT_ENABLED));
            } else {
               var1.setReplayOperations(EnumSet.of(OracleConnection.ReplayOperation.KPDSS_SESSSTATE_REQUEST_BEGIN, OracleConnection.ReplayOperation.KPDSS_SESSSTATE_STATIC, OracleConnection.ReplayOperation.KPDSS_SESSSTATE_APPCONT_ENABLED));
            }

            EnumSet var2 = var1.getTransactionState();
            if (var2.contains(OracleConnection.TransactionState.TRANSACTION_STARTED) && !var2.contains(OracleConnection.TransactionState.TRANSACTION_READONLY)) {
               SQLException var3 = DatabaseError.createSqlException(392);
               throw var3;
            } else {
               this.replayErrorCode = 0;
               this.replayErrorMessage = "";
               this.callCausingReplayError = null;
               this.seenRoundtripCallInRequest = false;
               var1.setChecksumMode(OracleConnection.ChecksumMode.CALCULATE_CHECKSUM_BINDS);
               this.lifecycle = TxnFailoverManagerImpl.ReplayLifecycle.ENABLED_NOT_REPLAYING;
            }
         }
      }
   }

   synchronized void endRequest() throws SQLException {
      OracleConnection var1 = (OracleConnection)this.connectionProxy.getDelegate();
      var1.setReplayOperations(EnumSet.of(OracleConnection.ReplayOperation.KPDSS_SESSSTATE_REQUEST_END));
      EnumSet var2 = var1.getTransactionState();
      if (var2.contains(OracleConnection.TransactionState.TRANSACTION_STARTED) && !var2.contains(OracleConnection.TransactionState.TRANSACTION_READONLY)) {
         try {
            var1.rollback();
         } catch (SQLException var4) {
         }

         SQLException var3 = DatabaseError.createSqlException(393);
         throw var3;
      } else if (this.lifecycle != TxnFailoverManagerImpl.ReplayLifecycle.ALWAYS_DISABLED) {
         if (this.lifecycle != TxnFailoverManagerImpl.ReplayLifecycle.INTERNALLY_DISABLED && this.lifecycle != TxnFailoverManagerImpl.ReplayLifecycle.EXTERNALLY_DISABLED) {
            this.disableReplayInternal((Method)null, 381, "Replay disabled after endRequest is called", (SQLRecoverableException)null);
         } else {
            this.lifecycle = TxnFailoverManagerImpl.ReplayLifecycle.INTERNALLY_DISABLED;
         }
      }
   }

   void disableReplay() throws SQLException {
      if (this.lifecycle != TxnFailoverManagerImpl.ReplayLifecycle.ALWAYS_DISABLED) {
         this.disableReplayInternal((Method)null, 370, "Replay disabled", (SQLRecoverableException)null);
         this.lifecycle = TxnFailoverManagerImpl.ReplayLifecycle.EXTERNALLY_DISABLED;
      }
   }

   void disableReplayInternal(Method var1, int var2, String var3, SQLRecoverableException var4) {
      TxnFailoverManagerImpl.ReplayLifecycle var5 = this.lifecycle;
      OracleConnection var6 = (OracleConnection)this.connectionProxy.getDelegate();
      if (this.lifecycle != TxnFailoverManagerImpl.ReplayLifecycle.ALWAYS_DISABLED) {
         this.lifecycle = TxnFailoverManagerImpl.ReplayLifecycle.INTERNALLY_DISABLED;
      }

      this.purge();
      this.replayErrorCode = var2;
      this.replayErrorMessage = var3;
      this.callCausingReplayError = var1;

      for(int var7 = 0; var7 < activeQueues; ++var7) {
         this.queueEmptyCounts[var7] = 0;
      }

      try {
         var6.setChecksumMode(OracleConnection.ChecksumMode.NO_CHECKSUM);
         if (!this.seenRoundtripCallInRequest) {
            if (!this.isReplayInDynamicMode) {
               var6.setReplayOperations(EnumSet.of(OracleConnection.ReplayOperation.KPDSS_SESSSTATE_REQUEST_BEGIN, OracleConnection.ReplayOperation.KPDSS_SESSSTATE_STATIC));
            } else {
               var6.setReplayOperations(EnumSet.of(OracleConnection.ReplayOperation.KPDSS_SESSSTATE_REQUEST_BEGIN));
            }
         } else if (!this.isReplayInDynamicMode) {
            var6.setReplayOperations(EnumSet.of(OracleConnection.ReplayOperation.KPDSS_SESSSTATE_STATIC));
         } else {
            var6.setReplayOperations(EnumSet.noneOf(OracleConnection.ReplayOperation.class));
         }
      } catch (SQLException var8) {
      }

   }

   void failReplayInternal(Method var1, int var2, String var3, SQLRecoverableException var4) {
      TxnFailoverManagerImpl.ReplayLifecycle var5 = this.lifecycle;
      if (this.lifecycle == TxnFailoverManagerImpl.ReplayLifecycle.REPLAYING || this.lifecycle == TxnFailoverManagerImpl.ReplayLifecycle.REPLAYING_CALLBACK || this.lifecycle == TxnFailoverManagerImpl.ReplayLifecycle.REPLAYING_LASTCALL) {
         this.lifecycle = TxnFailoverManagerImpl.ReplayLifecycle.INTERNALLY_FAILED;
      }

      this.replayErrorCode = var2;
      this.replayErrorMessage = var3;
      this.callCausingReplayError = var1;
   }

   void throwReplayExceptionInternal(int var1, String var2, SQLRecoverableException var3) throws SQLException {
      if (var1 != 0) {
         String var4 = this.callCausingReplayError == null ? "" : this.callCausingReplayError.getName();
         SQLException var5 = DatabaseError.createSqlException(this.replayErrorCode, var4);
         throw var5;
      }
   }

   void disableReplayAndThrowException(Method var1, int var2, String var3, SQLRecoverableException var4) throws SQLException {
      this.disableReplayInternal(var1, var2, var3, var4);
      this.throwReplayExceptionInternal(var2, var3, var4);
   }

   void disableReplayAndThrowOriginalError(Method var1, int var2, String var3, SQLRecoverableException var4) throws SQLException {
      this.disableReplayInternal(var1, var2, var3, var4);
      this.throwOriginalExceptionWithReplayError(var2, var3, var4);
   }

   void failReplayAndThrowException(Method var1, int var2, String var3, SQLRecoverableException var4) throws SQLException {
      this.failReplayInternal(var1, var2, var3, var4);
      this.throwReplayExceptionInternal(var2, var3, var4);
   }

   void throwOriginalExceptionWithReplayError(int var1, String var2, SQLRecoverableException var3) throws SQLRecoverableException {
      if (!this.doNotAbortConn) {
         this.killConnectionBeforeReplayDisabledException();
      }

      String var4 = this.callCausingReplayError == null ? "" : this.callCausingReplayError.getName();
      SQLException var5 = DatabaseError.createSqlException(this.replayErrorCode, var4);
      var3.setNextException(var5);
      throw var3;
   }

   void killConnectionBeforeReplayDisabledException() {
      final OracleConnection var1 = (OracleConnection)this.connectionProxy.getDelegate();

      try {
         var1.abort();
      } catch (SQLException var4) {
      }

      try {
         executor.submit(new Runnable() {
            public void run() {
               TxnFailoverManagerImpl.this.closePhysicalConnection(var1);
            }
         });
      } catch (Exception var3) {
      }

   }

   void enableTxnMonitoring(OracleConnection var1) throws SQLException {
      try {
         Statement var2 = var1.createStatement();
         var2.execute("BEGIN DBMS_APP_CONT_PRVT.MONITOR_TXN; END;");
         var2.close();
      } catch (SQLException var3) {
         this.disableReplayInternal((Method)null, 374, "Replay disabled because transaction monitoring failed to be enabled", (SQLRecoverableException)null);
         this.lifecycle = TxnFailoverManagerImpl.ReplayLifecycle.ALWAYS_DISABLED;
         throw DatabaseError.createSqlException(395);
      }
   }

   void beginReplay(OracleConnection var1, SQLRecoverableException var2) throws SQLException {
      try {
         Statement var3 = var1.createStatement();
         var3.execute("BEGIN DBMS_APP_CONT_PRVT.BEGIN_REPLAY; END;");
         var3.close();
         var1.setReplayingMode(true);
         this.lifecycle = TxnFailoverManagerImpl.ReplayLifecycle.REPLAYING;
      } catch (SQLException var4) {
         this.disableReplayAndThrowException((Method)null, 375, "Replay disabled because server begin_replay call failed", var2);
      }

   }

   void endReplay(OracleConnection var1, SQLRecoverableException var2) throws SQLException {
      try {
         Statement var3 = var1.createStatement();
         var3.execute("BEGIN DBMS_APP_CONT_PRVT.END_REPLAY; END;");
         var3.close();
         var1.setReplayingMode(false);
         var1.setReplayOperations(EnumSet.noneOf(OracleConnection.ReplayOperation.class));
         if (!this.isReplayInDynamicMode) {
            var1.setReplayOperations(EnumSet.of(OracleConnection.ReplayOperation.KPDSS_SESSSTATE_STATIC, OracleConnection.ReplayOperation.KPDSS_SESSSTATE_APPCONT_ENABLED));
         } else {
            var1.setReplayOperations(EnumSet.of(OracleConnection.ReplayOperation.KPDSS_SESSSTATE_APPCONT_ENABLED));
         }

         var1.getReplayContext();
         this.lifecycle = TxnFailoverManagerImpl.ReplayLifecycle.REPLAYING_LASTCALL;
      } catch (SQLException var4) {
         this.disableReplayAndThrowException((Method)null, 376, "Replay disabled because server end_replay call failed", var2);
      }

   }

   boolean prepareReplay(OracleConnection var1, SQLRecoverableException var2, short var3, String var4) throws SQLException {
      boolean var5 = false;
      boolean var6 = false;

      try {
         if (!this.isReplayInDynamicMode) {
            var1.setReplayOperations(EnumSet.of(OracleConnection.ReplayOperation.KPDSS_SESSSTATE_REQUEST_END, OracleConnection.ReplayOperation.KPDSS_SESSSTATE_STATIC));
         }

         CallableStatement var7 = var1.prepareCall("DECLARE PROCEDURE PREPARE_REPLAY_WRAPPER(ltxid IN RAW, is_replay IN NUMBER, ac IN NUMBER, fncode IN BINARY_INTEGER, sql_text IN VARCHAR2, is_committed OUT NUMBER, is_embedded OUT NUMBER) IS attempting_replay BOOLEAN; auto_commit BOOLEAN; committed BOOLEAN; embedded BOOLEAN; BEGIN if is_replay = 1 then attempting_replay := true; else attempting_replay := false; end if; if ac = 1 then auto_commit := true; else auto_commit := false; end if; DBMS_APP_CONT_PRVT.PREPARE_REPLAY(ltxid, attempting_replay, auto_commit, fncode, sql_text, committed, embedded); if committed then is_committed := 1; else is_committed := 0; end if; if embedded then is_embedded := 1; else is_embedded := 0; end if; END; BEGIN PREPARE_REPLAY_WRAPPER(?,?,?,?,?,?,?); END;");
         var7.setBytes(1, this.oldLtxidForPrepareReplay.getBytes());
         var7.setInt(2, this.seenRoundtripCallInRequest ? 1 : 0);
         var7.setInt(3, var1.getAutoCommit() ? 1 : 0);
         var7.setInt(4, var3);
         var7.setString(5, var4);
         var7.registerOutParameter(6, -7);
         var7.registerOutParameter(7, -7);
         var7.execute();
         var5 = var7.getBoolean(6);
         var6 = var7.getBoolean(7);
         var7.close();
      } catch (SQLException var8) {
         var8.printStackTrace();
         this.disableReplayAndThrowException((Method)null, 385, "Replay disabled because server prepare_replay call failed", var2);
      }

      if (!var6) {
         return var5;
      } else {
         this.disableReplayAndThrowException((Method)null, 386, "Replay disabled because of embedded commit", var2);
         return false;
      }
   }

   JDBCReplayable getConnectionProxy() {
      return this.connectionProxy;
   }

   private boolean isReplayFailure(SQLException var1) {
      boolean var2 = false;
      if (var1 instanceof SQLException) {
         int var3 = var1.getErrorCode();
         if (var3 >= 370 && var3 < 400) {
            var2 = true;
         }
      }

      return var2;
   }

   private void closePhysicalConnection(Connection var1) {
      try {
         var1.close();
      } catch (SQLException var3) {
      }

   }

   LogicalTransactionId getLogicalTransactionId() {
      return this.ltxid;
   }

   void setLogicalTransactionId(LogicalTransactionId var1) {
      this.ltxid = var1;
   }

   public void onLogicalTransactionIdEvent(LogicalTransactionIdEvent var1) {
      LogicalTransactionId var2 = var1.getLogicalTransactionId();
      this.setLogicalTransactionId(var2);
   }

   ReplayContext[] getReplayContext() {
      return this.replayContext;
   }

   void setReplayContext(ReplayContext[] var1) {
      this.replayContext = var1;
   }

   void addActiveQueues(int var1) {
      int var2 = (var1 + 1 - this.queueEmptyCounts.length) / 2 * 2;
      int var3 = this.queueEmptyCounts.length + var2;
      int[] var4 = new int[var3];
      System.arraycopy(this.queueEmptyCounts, 0, var4, 0, this.queueEmptyCounts.length);

      int var5;
      for(var5 = this.queueEmptyCounts.length; var5 <= var1; ++var5) {
         var4[var5] = 0;
      }

      for(var5 = var1 + 1; var5 <= var3; ++var5) {
         var4[var5] = 0;
      }

      synchronized(this) {
         this.queueEmptyCounts = var4;
         activeQueues = var3;
      }
   }

   static enum ReplayLifecycle {
      ENABLED_NOT_REPLAYING,
      INTERNALLY_FAILED,
      INTERNALLY_DISABLED,
      ALWAYS_DISABLED,
      EXTERNALLY_DISABLED,
      REPLAYING_CALLBACK,
      REPLAYING,
      REPLAYING_LASTCALL;
   }

   static class CallHistoryEntry {
      Object jdbcProxy;
      Method method;
      Object[] args;
      Object result;
      String callStatus;
      long checksum;
      boolean openAcrossPurge;
      int queueId;
      int queueEmptyCount;
      ReplayContext[] replayContext;
      boolean serverAsksToEnqueue;
      SQLException callException;
      TxnFailoverManagerImpl.CallHistoryEntry nextEntry = null;
      TxnFailoverManagerImpl.CallHistoryEntry prevEntry = null;
      TxnFailoverManagerImpl.CallHistoryEntry nextEntrySameProxy = null;
      TxnFailoverManagerImpl.CallHistoryEntry prevEntrySameProxy = null;

      CallHistoryEntry(Object var1, Method var2, Object[] var3, String var4) {
         this.jdbcProxy = var1;
         this.method = var2;
         this.args = var3;
         this.result = null;
         this.callStatus = var4;
         this.openAcrossPurge = false;
      }

      public String toString() {
         String var1 = "CallHistoryEntry: method.getName()=" + this.method.getName() + ", queueId=" + this.queueId + ", queueEmptyCount=" + this.queueEmptyCount + ", serverAsksToEnqueue=" + this.serverAsksToEnqueue + ", replayContext=" + this.replayContext;
         if (this.replayContext != null) {
            for(int var2 = 0; var2 < this.replayContext.length; ++var2) {
               var1 = var1 + this.replayContext[var2];
            }
         }

         return var1 + "\n";
      }
   }
}
