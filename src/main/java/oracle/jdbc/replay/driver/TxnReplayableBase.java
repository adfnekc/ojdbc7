package oracle.jdbc.replay.driver;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.BatchUpdateException;
import java.sql.SQLException;
import java.sql.SQLRecoverableException;
import java.util.HashSet;
import oracle.jdbc.internal.ACProxyable;
import oracle.jdbc.internal.AdditionalDatabaseMetaData;
import oracle.jdbc.internal.OracleConnection;
import oracle.jdbc.internal.OracleParameterMetaData;
import oracle.jdbc.internal.OracleResultSetMetaData;
import oracle.jdbc.internal.OracleRowId;
import oracle.jdbc.internal.OracleSavepoint;
import oracle.jdbc.internal.OracleTypeMetaData;
import oracle.jdbc.internal.ReplayContext;
import oracle.jdbc.proxy.annotation.GetCreator;
import oracle.jdbc.proxy.annotation.GetDelegate;
import oracle.jdbc.proxy.annotation.Methods;
import oracle.jdbc.proxy.annotation.OnError;
import oracle.jdbc.proxy.annotation.Post;
import oracle.jdbc.proxy.annotation.Pre;
import oracle.jdbc.proxy.annotation.ProxyAccess;
import oracle.jdbc.proxy.annotation.ProxyFor;
import oracle.jdbc.proxy.annotation.SetDelegate;
import oracle.jdbc.proxy.annotation.Signature;
import oracle.jdbc.replay.ReplayableConnection;

@ProxyFor({AdditionalDatabaseMetaData.class, OracleParameterMetaData.class, OracleRowId.class, OracleSavepoint.class, OracleTypeMetaData.class, OracleTypeMetaData.Array.class, OracleTypeMetaData.Opaque.class, OracleTypeMetaData.Struct.class, OracleResultSetMetaData.class})
@ProxyAccess(ACProxyable.class)
public abstract class TxnReplayableBase implements JDBCReplayable {
   protected TxnFailoverManagerImpl failoverMngr;
   protected TxnFailoverManagerImpl.CallHistoryEntry headSameProxy = null;
   protected TxnFailoverManagerImpl.CallHistoryEntry tailSameProxy = null;
   protected TxnFailoverManagerImpl.CallHistoryEntry replayingCallEntry = null;
   protected SQLRecoverableException originalError = null;
   protected static final int SVR_TXN_IN_REPLAY_ERROR_CODE1 = 603;
   protected static final int SVR_TXN_IN_REPLAY_ERROR_CODE2 = 29791;
   protected boolean isClosedAndNoReplay = false;
   protected boolean isCreatingCallReplayable = true;
   protected boolean isCurrentExecuteReplayable = true;
   protected TxnFailoverManagerImpl.CallHistoryEntry creatorCallEntry = null;
   protected long currentBindChecksum = 0L;
   private static final String PROXY_CLASS_SUFFIX = "$$$Proxy";
   protected String thisProxyNameInLog = "";
   private static final String _Copyright_2007_Oracle_All_Rights_Reserved_ = null;
   public static final String BUILD_DATE = "Thu_Apr_04_15:09:24_PDT_2013";

   protected TxnReplayableBase() {
      StringBuffer var1 = new StringBuffer(this.getClass().getName());
      int var2 = var1.indexOf("$$$Proxy");
      var1.delete(0, var2);
      var1.append("@");
      var1.append(Integer.toHexString(this.hashCode()));
      this.thisProxyNameInLog = var1.toString();
   }

   @Pre
   protected void preForAll(Method var1, Object var2, Object... var3) {
      TxnFailoverManagerImpl.ReplayLifecycle var4 = this.failoverMngr.getReplayLifecycle();
      switch(var4) {
      case ENABLED_NOT_REPLAYING:
         this.failoverMngr.record(this, var1, var3, "started");
      case INTERNALLY_FAILED:
      case ALWAYS_DISABLED:
      case INTERNALLY_DISABLED:
      case EXTERNALLY_DISABLED:
      case REPLAYING:
      case REPLAYING_CALLBACK:
      case REPLAYING_LASTCALL:
      default:
      }
   }

   @Post
   protected void postForAll(Method var1) {
      this.postForAll(var1, (Object)null);
   }

   @Post
   protected Object postForAll(Method var1, Object var2) {
      if (var2 instanceof TxnReplayableBase) {
         TxnReplayableBase var3 = (TxnReplayableBase)var2;
         var3.setFailoverManager(this.getFailoverManager());
      }

      TxnFailoverManagerImpl.ReplayLifecycle var4 = this.failoverMngr.getReplayLifecycle();
      switch(var4) {
      case ENABLED_NOT_REPLAYING:
      case REPLAYING_LASTCALL:
         this.doPostWhenRecording(var1, var2, (SQLException)null);
      case INTERNALLY_FAILED:
      case ALWAYS_DISABLED:
      case INTERNALLY_DISABLED:
      case EXTERNALLY_DISABLED:
      case REPLAYING_CALLBACK:
      default:
         break;
      case REPLAYING:
         this.doPostWhenReplaying(var1, var2, (SQLException)null);
      }

      return var2;
   }

   protected void doPostWhenRecording(Method var1, Object var2, SQLException var3) {
      this.failoverMngr.update(this, (TxnFailoverManagerImpl.CallHistoryEntry)null, var2, "completed", this.currentBindChecksum, var3);
      this.currentBindChecksum = 0L;
   }

   protected void doPostWhenReplaying(Method var1, Object var2, SQLException var3) {
   }

   @OnError(SQLException.class)
   protected void onErrorVoidForAll(Method var1, SQLException var2) throws SQLException {
      this.onErrorForAll(var1, var2);
   }

   @OnError(SQLException.class)
   protected Object onErrorForAll(Method var1, SQLException var2) throws SQLException {
      TxnReplayableBase var3 = (TxnReplayableBase)this.failoverMngr.getConnectionProxy();
      if (var3.isClosedAndNoReplay) {
         throw var2;
      } else {
         if (var2 instanceof BatchUpdateException) {
            SQLException var4 = var2.getNextException();
            if (var4 != null && var4 instanceof SQLRecoverableException) {
               var2 = var4;
            }
         }

         TxnFailoverManagerImpl.ReplayLifecycle var5;
         if (var2 instanceof SQLRecoverableException) {
            var5 = this.failoverMngr.getReplayLifecycle();
            switch(var5) {
            case ENABLED_NOT_REPLAYING:
               this.failoverMngr.update(this, (TxnFailoverManagerImpl.CallHistoryEntry)null, (Object)null, "incomplete", this.currentBindChecksum, var2);
               this.currentBindChecksum = 0L;
            case ALWAYS_DISABLED:
            case INTERNALLY_DISABLED:
            case EXTERNALLY_DISABLED:
               return this.failoverMngr.handleOutage((SQLRecoverableException)var2);
            case REPLAYING_LASTCALL:
               this.failoverMngr.update(this, (TxnFailoverManagerImpl.CallHistoryEntry)null, (Object)null, "incomplete", this.currentBindChecksum, var2);
               this.currentBindChecksum = 0L;
            case INTERNALLY_FAILED:
            case REPLAYING:
            case REPLAYING_CALLBACK:
            default:
               throw var2;
            }
         } else {
            var5 = this.failoverMngr.getReplayLifecycle();
            switch(var5) {
            case ENABLED_NOT_REPLAYING:
            case REPLAYING_LASTCALL:
               this.doPostWhenRecording(var1, (Object)null, var2);
            case INTERNALLY_FAILED:
            case ALWAYS_DISABLED:
            case INTERNALLY_DISABLED:
            case EXTERNALLY_DISABLED:
            case REPLAYING:
            case REPLAYING_CALLBACK:
            default:
               throw var2;
            }
         }
      }
   }

   @Pre
   @Methods(
      signatures = {@Signature(
   name = "toString",
   args = {}
)}
   )
   protected void preForToString(Method var1, Object var2, Object... var3) {
   }

   @Post
   @Methods(
      signatures = {@Signature(
   name = "toString",
   args = {}
)}
   )
   protected String postForToString(Method var1, String var2) {
      return var2;
   }

   @GetDelegate
   protected abstract Object getDelegate();

   @SetDelegate
   protected abstract void setDelegate(Object var1);

   @GetCreator
   protected abstract Object getCreator();

   public Object replayOneCall(TxnFailoverManagerImpl.CallHistoryEntry var1, SQLRecoverableException var2) throws SQLException {
      Object var3 = null;
      String var4 = ((TxnReplayableBase)var1.jdbcProxy).thisProxyNameInLog;

      int var9;
      try {
         ((JDBCReplayable)var1.jdbcProxy).setReplayingCallContext(var1, var2);
         if (var1.replayContext != null) {
            TxnReplayableBase var5 = (TxnReplayableBase)this.failoverMngr.getConnectionProxy();
            OracleConnection var15 = (OracleConnection)var5.getDelegate();
            var15.setReplayContext(var1.replayContext);
            ReplayContext[] var18 = var1.replayContext;
            int var21 = var18.length;

            for(var9 = 0; var9 < var21; ++var9) {
               ReplayContext var10 = var18[var9];
               if (var10 == null) {
               }
            }
         }

         Object var13 = var1.method.invoke(var1.jdbcProxy, var1.args);
         var3 = var13;
         if (var13 instanceof TxnReplayableBase) {
            TxnFailoverManagerImpl.ReplayLifecycle var16 = this.failoverMngr.getReplayLifecycle();
            if (var16 == TxnFailoverManagerImpl.ReplayLifecycle.REPLAYING && var13 != null && var1.result != null) {
               Object var20 = ((TxnReplayableBase)var13).getDelegate();
               ((TxnReplayableBase)var1.result).setDelegate(var20);
               var3 = var1.result;
            }
         }
      } catch (InvocationTargetException var11) {
         Object var6 = var11.getCause();
         SQLException var7;
         if (var6 instanceof BatchUpdateException) {
            var7 = ((BatchUpdateException)var6).getNextException();
            if (var7 != null && var7 instanceof SQLRecoverableException) {
               var6 = var7;
            }
         }

         if (var6 instanceof SQLRecoverableException) {
            SQLRecoverableException var17 = (SQLRecoverableException)var6;
            Throwable var19 = var17.getCause();
            if (var19 == null) {
               var9 = var17.getErrorCode();
               if (var9 == 603 && var17.getMessage().indexOf("ORA-29791") != -1) {
                  var2.setNextException(var17);
                  this.failoverMngr.disableReplayAndThrowException(var1.method, 390, "Replay failed because of active transaction during replay", var2);
               }
            }

            throw var17;
         }

         if (var6 instanceof SQLException) {
            var7 = (SQLException)var6;
            TxnFailoverManagerImpl.ReplayLifecycle var8 = this.failoverMngr.getReplayLifecycle();
            if (var7.getErrorCode() == 17290) {
               throw var7;
            }

            if (var8 == TxnFailoverManagerImpl.ReplayLifecycle.INTERNALLY_DISABLED && this.failoverMngr.didReplayingLastCallDisableReplay) {
               throw var7;
            }

            if (var1.callException != null && var7.getErrorCode() == var1.callException.getErrorCode()) {
               if (var8 == TxnFailoverManagerImpl.ReplayLifecycle.REPLAYING_LASTCALL) {
                  throw var7;
               }
            } else {
               var2.setNextException(var7);
               this.failoverMngr.disableReplayAndThrowException(var1.method, 389, "Replay failed because of error code or message mismatch", var2);
            }
         } else {
            this.failoverMngr.disableReplayAndThrowException(var1.method, 370, "Replay disabled", var2);
         }
      } catch (Throwable var12) {
         var12.printStackTrace();
         this.failoverMngr.disableReplayAndThrowException(var1.method, 370, "Replay disabled", var2);
      }

      TxnFailoverManagerImpl.ReplayLifecycle var14 = this.failoverMngr.getReplayLifecycle();
      switch(var14) {
      case INTERNALLY_FAILED:
      case INTERNALLY_DISABLED:
         this.failoverMngr.throwReplayExceptionInternal(0, (String)null, (SQLRecoverableException)null);
      default:
         return var3;
      }
   }

   public void addToSameProxyList(TxnFailoverManagerImpl.CallHistoryEntry var1) {
      var1.prevEntrySameProxy = this.tailSameProxy;
      var1.nextEntrySameProxy = null;
      if (this.tailSameProxy != null) {
         this.tailSameProxy.nextEntrySameProxy = var1;
      }

      this.tailSameProxy = var1;
      if (this.headSameProxy == null) {
         this.headSameProxy = var1;
      }

   }

   public void removeFromSameProxyList(TxnFailoverManagerImpl.CallHistoryEntry var1) {
      if (var1.nextEntrySameProxy != null) {
         var1.nextEntrySameProxy.prevEntrySameProxy = var1.prevEntrySameProxy;
      }

      if (var1.prevEntrySameProxy != null) {
         var1.prevEntrySameProxy.nextEntrySameProxy = var1.nextEntrySameProxy;
      }

      if (this.headSameProxy == var1) {
         this.headSameProxy = var1.nextEntrySameProxy;
      }

      if (this.tailSameProxy == var1) {
         this.tailSameProxy = var1.prevEntrySameProxy;
      }

   }

   public void purgeSameProxyList() {
      if (this.failoverMngr != null) {
         HashSet var1 = new HashSet();

         for(Object var2 = this; var2 != null && var2 instanceof TxnReplayableBase && !(var2 instanceof ReplayableConnection); var2 = ((TxnReplayableBase)var2).getCreator()) {
            var1.add(var2);
         }

         this.failoverMngr.purgeForSameProxy(var1, this.headSameProxy);
      }

   }

   public void setReplayingCallContext(TxnFailoverManagerImpl.CallHistoryEntry var1, SQLRecoverableException var2) {
      this.replayingCallEntry = var1;
      this.originalError = var2;
   }

   public synchronized void setFailoverManager(TxnFailoverManagerImpl var1) {
      this.failoverMngr = var1;
   }

   public synchronized TxnFailoverManagerImpl getFailoverManager() {
      return this.failoverMngr;
   }

   private boolean isReplayFailure(Throwable var1) {
      boolean var2 = false;
      if (var1 instanceof SQLException) {
         int var3 = ((SQLException)var1).getErrorCode();
         if (var3 >= 370 && var3 < 400) {
            var2 = true;
         }
      }

      return var2;
   }

   protected boolean assertThrowablesMatch(Throwable var1, Throwable var2) {
      boolean var3 = var2 == null ? false : var1.getClass().getName().equals(var2.getClass().getName());
      boolean var4;
      if (var1 instanceof SQLException && var3) {
         var4 = ((SQLException)var1).getErrorCode() == ((SQLException)var2).getErrorCode();
      } else if (var3) {
         String var5 = var1.getMessage();
         String var6 = var2.getMessage();
         var4 = var5 == null && var6 == null || var5 != null && var6 != null && var1.getMessage().equals(var2.getMessage());
      } else {
         var4 = false;
      }

      return var4;
   }

   public String toString() {
      return this.getDelegate().toString();
   }
}
