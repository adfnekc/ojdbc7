package oracle.jdbc.replay.driver;

import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLRecoverableException;
import java.sql.Statement;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import oracle.jdbc.driver.DatabaseError;
import oracle.jdbc.internal.OracleConnection;
import oracle.jdbc.replay.internal.ConnectionInitializationCallback;
import oracle.jdbc.replay.internal.OracleDataSource;

class FailoverManagerImpl implements FailoverManager {
   private static final String MONITOR_TXN = "BEGIN DBMS_APP_CONT_PRVT.MONITOR_TXN; END;";
   private static final String BEGIN_REPLAY = "BEGIN DBMS_APP_CONT_PRVT.BEGIN_REPLAY; END;";
   private static final String END_REPLAY = "BEGIN DBMS_APP_CONT_PRVT.END_REPLAY; END;";
   private FailoverManagerImpl.CallHistoryEntry head;
   private FailoverManagerImpl.CallHistoryEntry tail;
   private FailoverManagerImpl.ReplayLifecycle lifecycle;
   private boolean replayInCurrentMode;
   private Object replayResult;
   private long requestStartTime;
   private long replayInitiationTimeout;
   private static final int REPLAY_RETRIES = 3;
   private int replayRetries;
   private OracleDataSource replayDataSource;
   private NonTxnReplayableBase connectionProxy;
   private Method callCausingReplayError;
   private int replayErrorCode;
   private String replayErrorMessage;
   private static final ExecutorService executor = Executors.newSingleThreadExecutor(new ThreadFactory() {
      private static final String THREAD_NAME = "OJDBC-AC-WORKER-THREAD";

      public Thread newThread(Runnable var1) {
         Thread var2 = new Thread((ThreadGroup)null, var1, "OJDBC-AC-WORKER-THREAD");
         var2.setPriority(5);
         var2.setDaemon(true);
         return var2;
      }
   });
   private static final String _Copyright_2007_Oracle_All_Rights_Reserved_ = null;
   public static final String BUILD_DATE = "Thu_Apr_04_15:09:24_PDT_2013";

   private FailoverManagerImpl(NonTxnReplayableBase var1, OracleDataSource var2) throws SQLException {
      this.lifecycle = FailoverManagerImpl.ReplayLifecycle.INTERNALLY_DISABLED;
      this.replayInCurrentMode = false;
      this.replayInitiationTimeout = 900L;
      this.replayRetries = 0;
      this.replayDataSource = null;
      this.connectionProxy = var1;
      this.replayDataSource = var2;
      this.enableTxnMonitoring((OracleConnection)this.connectionProxy.getDelegate());
   }

   static FailoverManager getFailoverManager(NonTxnReplayableBase var0, OracleDataSource var1) throws SQLException {
      return new FailoverManagerImpl(var0, var1);
   }

   private void append(FailoverManagerImpl.CallHistoryEntry var1) {
      var1.prevEntry = this.tail;
      var1.nextEntry = null;
      if (this.tail != null) {
         this.tail.nextEntry = var1;
      }

      this.tail = var1;
      if (this.head == null) {
         this.head = var1;
      }

      Replayable var2 = (Replayable)var1.jdbcProxy;
      var2.addToSameProxyList(var1);
   }

   private void remove(FailoverManagerImpl.CallHistoryEntry var1) {
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

      Replayable var2 = (Replayable)var1.jdbcProxy;
      var2.removeFromSameProxyList(var1);
   }

   FailoverManagerImpl.CallHistoryEntry record(Object var1, Method var2, Object[] var3, String var4) {
      synchronized(this) {
         if (var2 == null) {
            String var10000 = "NULL METHOD";
         } else {
            var2.getName();
         }

         StringBuilder var7 = new StringBuilder();
         if (var3 != null && var3.length > 0) {
            for(int var8 = 0; var8 < var3.length - 1; ++var8) {
               var7.append(var3[var8]);
               var7.append(",");
            }

            var7.append(var3[var3.length - 1]);
         }

         FailoverManagerImpl.CallHistoryEntry var11 = new FailoverManagerImpl.CallHistoryEntry(var1, var2, var3, var4);
         this.append(var11);
         return var11;
      }
   }

   void update(Object var1, FailoverManagerImpl.CallHistoryEntry var2, Object var3, String var4, long var5, long var7, SQLException var9) {
      synchronized(this) {
         FailoverManagerImpl.CallHistoryEntry var11 = var2 == null ? this.tail : var2;
         if (var11 != null && var11.method != null) {
            var11.method.getName();
         } else {
            String var10000 = "NULL METHOD";
         }

         var11.result = var3;
         var11.checksum = var5;
         var11.scn = var7;
         var11.callException = var9;
         var11.callStatus = var4;
      }
   }

   synchronized void purge() {
      for(FailoverManagerImpl.CallHistoryEntry var1 = this.head; var1 != null; var1 = var1.nextEntry) {
         this.remove(var1);
      }

   }

   synchronized void purgeForSameProxy(Set var1, FailoverManagerImpl.CallHistoryEntry var2) {
      Object var10000;
      if (var2 == null) {
         var10000 = null;
      } else {
         var10000 = var2.jdbcProxy;
      }

      for(FailoverManagerImpl.CallHistoryEntry var6 = var2; var6 != null; var6 = var6.nextEntrySameProxy) {
         Object var4 = var6.result;
         if (var4 != null && var4 instanceof Replayable && !var1.contains(var4)) {
            Replayable var5 = (Replayable)var4;
            var5.purgeSameProxyList();
            var1.add(var5);
         }

         this.remove(var6);
      }

   }

   synchronized boolean isEmpty() {
      return this.head == null;
   }

   void fillInAllChecksums() throws SQLException {
      synchronized(this) {
         HashSet var2 = new HashSet();

         for(FailoverManagerImpl.CallHistoryEntry var3 = this.tail.prevEntry; var3 != null; var3 = var3.prevEntry) {
            if (!var2.contains(var3.jdbcProxy)) {
               NonTxnReplayableBase var4 = (NonTxnReplayableBase)var3.jdbcProxy;
               var4.fillInChecksum(var3);
               var2.add(var3.jdbcProxy);
               if (var3.jdbcProxy instanceof ResultSet) {
                  var2.add(var4.getCreator());
               }
            }
         }

      }
   }

   Object replayAll(SQLRecoverableException var1) throws SQLException {
      synchronized(this) {
         this.replayRetries = 0;

         do {
            FailoverManagerImpl.ReplayLifecycle var4;
            try {
               Object var10000 = this.replayAllInternal(var1, this.replayRetries);
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
               case ALWAYS_DISABLED:
               case INTERNALLY_DISABLED:
               case EXTERNALLY_DISABLED:
                  this.throwOriginalExceptionWithReplayError(this.replayErrorCode, this.replayErrorMessage, var1);
               case REPLAYING_LASTCALL:
                  throw var7;
               case INTERNALLY_FAILED:
                  ++this.replayRetries;
                  this.lifecycle = FailoverManagerImpl.ReplayLifecycle.REPLAYING;
               }
            }
         } while(this.replayRetries <= 3);

         this.disableReplayAndThrowOriginalError((Method)null, 378, "Replay disabled because maximum number of retries is exceeded", var1);
         return null;
      }
   }

   synchronized Object replayAllInternal(SQLRecoverableException var1, int var2) throws SQLException {
      FailoverManagerImpl.ReplayLifecycle var3 = this.lifecycle;
      if (this.lifecycle != FailoverManagerImpl.ReplayLifecycle.ENABLED_NOT_REPLAYING && this.lifecycle != FailoverManagerImpl.ReplayLifecycle.REPLAYING && this.lifecycle != FailoverManagerImpl.ReplayLifecycle.REPLAYING_LASTCALL && this.lifecycle != FailoverManagerImpl.ReplayLifecycle.REPLAYING_CALLBACK) {
         this.throwReplayExceptionInternal(this.replayErrorCode, this.replayErrorMessage, var1);
      }

      OracleConnection var4 = (OracleConnection)this.replayDataSource.getConnectionNoProxy(((NonTxnReplayableConnection)this.connectionProxy).originalUser, ((NonTxnReplayableConnection)this.connectionProxy).originalPasswd);
      if (var4 == null) {
         this.disableReplayAndThrowException((Method)null, 382, "Replay disabled because Failover_Retries is exceeded", var1);
      }

      long var5 = System.currentTimeMillis();
      if (this.requestStartTime + this.replayInitiationTimeout * 1000L < var5) {
         this.disableReplayAndThrowException((Method)null, 377, "Replay disabled because ReplayInitiationTimeout is exceeded", var1);
      }

      this.connectionProxy.setDelegate(var4);
      var4.setChecksumMode(OracleConnection.ChecksumMode.CALCULATE_CHECKSUM_ALL);
      this.lifecycle = FailoverManagerImpl.ReplayLifecycle.REPLAYING_CALLBACK;
      ConnectionInitializationCallback var7 = this.replayDataSource.getConnectionInitializationCallback();
      if (var7 != null) {
         try {
            var7.initialize((Connection)this.connectionProxy);
         } catch (SQLException var9) {
            this.disableReplayAndThrowException((Method)null, 379, "Replay disabled because Init callback failed", var1);
         }

         EnumSet var8 = var4.getTransactionState();
         if (var8.contains(OracleConnection.TransactionState.TRANSACTION_STARTED)) {
            this.disableReplayAndThrowException((Method)null, 380, "Replay disabled because of open transaction in Init callback", var1);
         }
      }

      this.lifecycle = FailoverManagerImpl.ReplayLifecycle.REPLAYING;
      if (var2 == 0) {
         this.fillInAllChecksums();
      }

      this.beginReplay(var4, var1);
      this.replayResult = this.replayAllBeforeLastCall(var1);
      this.endReplay(var4, var1);
      if (this.tail != null) {
         this.replayResult = ((Replayable)this.tail.jdbcProxy).replayOneCall(this.tail, var1);
      }

      this.lifecycle = FailoverManagerImpl.ReplayLifecycle.ENABLED_NOT_REPLAYING;
      return this.replayResult;
   }

   private synchronized Object replayAllBeforeLastCall(SQLRecoverableException var1) throws SQLException {
      Object var2 = null;

      for(FailoverManagerImpl.CallHistoryEntry var3 = this.head; var3 != this.tail; var3 = var3.nextEntry) {
         Replayable var4 = (Replayable)var3.jdbcProxy;
         var2 = var4.replayOneCall(var3, var1);
         if (this.lifecycle != FailoverManagerImpl.ReplayLifecycle.ENABLED_NOT_REPLAYING && this.lifecycle != FailoverManagerImpl.ReplayLifecycle.REPLAYING && this.lifecycle != FailoverManagerImpl.ReplayLifecycle.REPLAYING_LASTCALL && this.lifecycle != FailoverManagerImpl.ReplayLifecycle.REPLAYING_CALLBACK) {
            this.throwReplayExceptionInternal(this.replayErrorCode, this.replayErrorMessage, var1);
         }
      }

      return var2;
   }

   boolean isReplayInCurrentMode() {
      return this.replayInCurrentMode;
   }

   void setReplayInCurrentMode() {
      this.replayInCurrentMode = true;
   }

   FailoverManagerImpl.ReplayLifecycle getReplayLifecycle() {
      return this.lifecycle;
   }

   void setDataSource(OracleDataSource var1) {
      this.replayDataSource = var1;
   }

   void setReplayInitiationTimeout(int var1) throws SQLException {
      this.replayInitiationTimeout = (long)var1;
   }

   void beginRequest() throws SQLException {
      if (this.lifecycle != FailoverManagerImpl.ReplayLifecycle.ALWAYS_DISABLED) {
         if (this.lifecycle != FailoverManagerImpl.ReplayLifecycle.INTERNALLY_DISABLED) {
            throw DatabaseError.createSqlException(391);
         } else {
            this.requestStartTime = System.currentTimeMillis();
            OracleConnection var1 = (OracleConnection)this.connectionProxy.getDelegate();
            EnumSet var2 = var1.getTransactionState();
            if (var2.contains(OracleConnection.TransactionState.TRANSACTION_STARTED) && !var2.contains(OracleConnection.TransactionState.TRANSACTION_READONLY)) {
               SQLException var3 = DatabaseError.createSqlException(392);
               throw var3;
            } else {
               this.replayErrorCode = 0;
               this.replayErrorMessage = "";
               this.callCausingReplayError = null;
               var1.setChecksumMode(OracleConnection.ChecksumMode.CALCULATE_CHECKSUM_ALL);
               this.lifecycle = FailoverManagerImpl.ReplayLifecycle.ENABLED_NOT_REPLAYING;
            }
         }
      }
   }

   void endRequest() throws SQLException {
      OracleConnection var1 = (OracleConnection)this.connectionProxy.getDelegate();
      EnumSet var2 = var1.getTransactionState();
      if (var2.contains(OracleConnection.TransactionState.TRANSACTION_STARTED) && !var2.contains(OracleConnection.TransactionState.TRANSACTION_READONLY)) {
         try {
            var1.rollback();
         } catch (SQLException var4) {
         }

         SQLException var3 = DatabaseError.createSqlException(393);
         throw var3;
      } else if (this.lifecycle != FailoverManagerImpl.ReplayLifecycle.ALWAYS_DISABLED) {
         if (this.lifecycle != FailoverManagerImpl.ReplayLifecycle.INTERNALLY_DISABLED && this.lifecycle != FailoverManagerImpl.ReplayLifecycle.EXTERNALLY_DISABLED) {
            this.disableReplayInternal((Method)null, 381, "Replay disabled after endRequest is called", (SQLRecoverableException)null);
         } else {
            this.lifecycle = FailoverManagerImpl.ReplayLifecycle.INTERNALLY_DISABLED;
         }
      }
   }

   void disableReplay() throws SQLException {
      if (this.lifecycle != FailoverManagerImpl.ReplayLifecycle.ALWAYS_DISABLED) {
         this.disableReplayInternal((Method)null, 370, "Replay disabled", (SQLRecoverableException)null);
         this.lifecycle = FailoverManagerImpl.ReplayLifecycle.EXTERNALLY_DISABLED;
      }
   }

   void disableReplayInternal(Method var1, int var2, String var3, SQLRecoverableException var4) {
      FailoverManagerImpl.ReplayLifecycle var5 = this.lifecycle;
      OracleConnection var6 = (OracleConnection)this.connectionProxy.getDelegate();
      if (this.lifecycle != FailoverManagerImpl.ReplayLifecycle.ALWAYS_DISABLED) {
         this.lifecycle = FailoverManagerImpl.ReplayLifecycle.INTERNALLY_DISABLED;
      }

      this.purge();
      this.replayErrorCode = var2;
      this.replayErrorMessage = var3;
      this.callCausingReplayError = var1;

      try {
         var6.setChecksumMode(OracleConnection.ChecksumMode.NO_CHECKSUM);
      } catch (SQLException var8) {
      }

   }

   void failReplayInternal(Method var1, int var2, String var3, SQLRecoverableException var4) {
      FailoverManagerImpl.ReplayLifecycle var5 = this.lifecycle;
      if (this.lifecycle == FailoverManagerImpl.ReplayLifecycle.REPLAYING || this.lifecycle == FailoverManagerImpl.ReplayLifecycle.REPLAYING_CALLBACK || this.lifecycle == FailoverManagerImpl.ReplayLifecycle.REPLAYING_LASTCALL) {
         this.lifecycle = FailoverManagerImpl.ReplayLifecycle.INTERNALLY_FAILED;
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
      this.killConnectionBeforeReplayDisabledException();
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
               FailoverManagerImpl.this.closePhysicalConnection(var1);
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
         this.lifecycle = FailoverManagerImpl.ReplayLifecycle.ALWAYS_DISABLED;
         throw DatabaseError.createSqlException(395);
      }
   }

   void beginReplay(OracleConnection var1, SQLRecoverableException var2) throws SQLException {
      try {
         Statement var3 = var1.createStatement();
         var3.execute("BEGIN DBMS_APP_CONT_PRVT.BEGIN_REPLAY; END;");
         var3.close();
         this.lifecycle = FailoverManagerImpl.ReplayLifecycle.REPLAYING;
      } catch (SQLException var4) {
         this.disableReplayAndThrowException((Method)null, 375, "Replay disabled because server begin_replay call failed", var2);
      }

   }

   void endReplay(OracleConnection var1, SQLRecoverableException var2) throws SQLException {
      try {
         Statement var3 = var1.createStatement();
         var3.execute("BEGIN DBMS_APP_CONT_PRVT.END_REPLAY; END;");
         var3.close();
         this.lifecycle = FailoverManagerImpl.ReplayLifecycle.REPLAYING_LASTCALL;
      } catch (SQLException var4) {
         this.disableReplayAndThrowException((Method)null, 376, "Replay disabled because server end_replay call failed", var2);
      }

   }

   Replayable getConnectionProxy() {
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
      long scn;
      long checksum;
      SQLException callException;
      FailoverManagerImpl.CallHistoryEntry nextEntry = null;
      FailoverManagerImpl.CallHistoryEntry prevEntry = null;
      FailoverManagerImpl.CallHistoryEntry nextEntrySameProxy = null;
      FailoverManagerImpl.CallHistoryEntry prevEntrySameProxy = null;

      CallHistoryEntry(Object var1, Method var2, Object[] var3, String var4) {
         this.jdbcProxy = var1;
         this.method = var2;
         this.args = var3;
         this.result = null;
         this.callStatus = var4;
      }
   }
}
