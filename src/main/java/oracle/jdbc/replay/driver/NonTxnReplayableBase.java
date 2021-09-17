package oracle.jdbc.replay.driver;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.DatabaseMetaData;
import java.sql.ParameterMetaData;
import java.sql.ResultSetMetaData;
import java.sql.RowId;
import java.sql.SQLData;
import java.sql.SQLException;
import java.sql.SQLInput;
import java.sql.SQLRecoverableException;
import java.sql.SQLXML;
import java.util.HashSet;
import oracle.jdbc.AdditionalDatabaseMetaData;
import oracle.jdbc.OracleParameterMetaData;
import oracle.jdbc.OracleResultSetMetaData;
import oracle.jdbc.OracleTypeMetaData;
import oracle.jdbc.proxy.annotation.GetCreator;
import oracle.jdbc.proxy.annotation.GetDelegate;
import oracle.jdbc.proxy.annotation.OnError;
import oracle.jdbc.proxy.annotation.Post;
import oracle.jdbc.proxy.annotation.Pre;
import oracle.jdbc.proxy.annotation.ProxyFor;
import oracle.jdbc.proxy.annotation.SetDelegate;
import oracle.jdbc.replay.ReplayableConnection;

@ProxyFor({DatabaseMetaData.class, ParameterMetaData.class, ResultSetMetaData.class, RowId.class, SQLData.class, SQLInput.class, SQLXML.class, AdditionalDatabaseMetaData.class, OracleParameterMetaData.class, OracleResultSetMetaData.class, OracleTypeMetaData.class, OracleTypeMetaData.Array.class, OracleTypeMetaData.Opaque.class, OracleTypeMetaData.Struct.class, oracle.jdbc.internal.OracleResultSetMetaData.class})
public abstract class NonTxnReplayableBase implements Replayable, InvocationHandler {
   protected FailoverManagerImpl failoverMngr;
   protected FailoverManagerImpl.CallHistoryEntry headSameProxy = null;
   protected FailoverManagerImpl.CallHistoryEntry tailSameProxy = null;
   protected FailoverManagerImpl.CallHistoryEntry replayingCallEntry = null;
   protected SQLRecoverableException originalError = null;
   protected static final int SVR_TXN_IN_REPLAY_ERROR_CODE1 = 603;
   protected static final int SVR_TXN_IN_REPLAY_ERROR_CODE2 = 29791;
   protected boolean isClosedAndNoReplay = false;
   private static final String _Copyright_2007_Oracle_All_Rights_Reserved_ = null;
   public static final String BUILD_DATE = "Thu_Apr_04_15:09:24_PDT_2013";

   @Pre
   protected void preForAll(Method var1, Object var2, Object... var3) {
      FailoverManagerImpl.ReplayLifecycle var4 = this.failoverMngr.getReplayLifecycle();
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
      if (var2 instanceof NonTxnReplayableBase) {
         NonTxnReplayableBase var3 = (NonTxnReplayableBase)var2;
         var3.setFailoverManager(this.getFailoverManager());
      }

      FailoverManagerImpl.ReplayLifecycle var4 = this.failoverMngr.getReplayLifecycle();
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
      this.failoverMngr.update(this, (FailoverManagerImpl.CallHistoryEntry)null, var2, "completed", 0L, -1L, var3);
   }

   protected void doPostWhenReplaying(Method var1, Object var2, SQLException var3) {
   }

   @OnError(SQLException.class)
   protected void onErrorVoidForAll(Method var1, SQLException var2) throws SQLException {
      this.onErrorForAll(var1, var2);
   }

   @OnError(SQLException.class)
   protected Object onErrorForAll(Method var1, SQLException var2) throws SQLException {
      if (this.isClosedAndNoReplay) {
         throw var2;
      } else {
         FailoverManagerImpl.ReplayLifecycle var3;
         if (var2 instanceof SQLRecoverableException) {
            var3 = this.failoverMngr.getReplayLifecycle();
            switch(var3) {
            case ENABLED_NOT_REPLAYING:
            case ALWAYS_DISABLED:
            case INTERNALLY_DISABLED:
            case EXTERNALLY_DISABLED:
               return this.failoverMngr.replayAll((SQLRecoverableException)var2);
            case INTERNALLY_FAILED:
            case REPLAYING:
            case REPLAYING_CALLBACK:
            case REPLAYING_LASTCALL:
            default:
               throw var2;
            }
         } else {
            var3 = this.failoverMngr.getReplayLifecycle();
            switch(var3) {
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

   @GetDelegate
   protected abstract Object getDelegate();

   @SetDelegate
   protected abstract void setDelegate(Object var1);

   @GetCreator
   protected abstract Object getCreator();

   public void fillInChecksum(FailoverManagerImpl.CallHistoryEntry var1) throws SQLException {
   }

   public Object replayOneCall(FailoverManagerImpl.CallHistoryEntry var1, SQLRecoverableException var2) throws SQLException {
      Object var3 = null;

      try {
         ((Replayable)var1.jdbcProxy).setReplayingCallContext(var1, var2);
         Object var4 = var1.method.invoke(var1.jdbcProxy, var1.args);
         var3 = var4;
         if (var4 instanceof NonTxnReplayableBase) {
            FailoverManagerImpl.ReplayLifecycle var11 = this.failoverMngr.getReplayLifecycle();
            if (var11 == FailoverManagerImpl.ReplayLifecycle.REPLAYING && var4 != null && var1.result != null) {
               Object var13 = ((NonTxnReplayableBase)var4).getDelegate();
               ((NonTxnReplayableBase)var1.result).setDelegate(var13);
               var3 = var1.result;
            }
         }
      } catch (InvocationTargetException var8) {
         Throwable var5 = var8.getCause();
         if (var5 instanceof SQLRecoverableException) {
            SQLRecoverableException var12 = (SQLRecoverableException)var5;
            throw var12;
         }

         if (var5 instanceof SQLException) {
            SQLException var6 = (SQLException)var5;
            int var7 = var6.getErrorCode();
            if (var7 == 29791) {
               this.failoverMngr.disableReplayAndThrowException(var1.method, 390, "Replay failed because of active transaction during replay", var2);
            } else if (var1.callException == null || var7 != var1.callException.getErrorCode()) {
               this.failoverMngr.disableReplayAndThrowException(var1.method, 389, "Replay failed because of error code or message mismatch", var2);
            }
         } else {
            this.failoverMngr.disableReplayAndThrowException(var1.method, 370, "Replay disabled", var2);
         }
      } catch (Throwable var9) {
         var9.printStackTrace();
         this.failoverMngr.disableReplayAndThrowException(var1.method, 370, "Replay disabled", var2);
      }

      FailoverManagerImpl.ReplayLifecycle var10 = this.failoverMngr.getReplayLifecycle();
      switch(var10) {
      case INTERNALLY_FAILED:
      case INTERNALLY_DISABLED:
         this.failoverMngr.throwReplayExceptionInternal(0, (String)null, (SQLRecoverableException)null);
      default:
         return var3;
      }
   }

   public void addToSameProxyList(FailoverManagerImpl.CallHistoryEntry var1) {
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

   public void removeFromSameProxyList(FailoverManagerImpl.CallHistoryEntry var1) {
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

         for(Object var2 = this; var2 != null && var2 instanceof NonTxnReplayableBase && !(var2 instanceof ReplayableConnection); var2 = ((NonTxnReplayableBase)var2).getCreator()) {
            var1.add(var2);
         }

         this.failoverMngr.purgeForSameProxy(var1, this.headSameProxy);
      }

   }

   public void setReplayingCallContext(FailoverManagerImpl.CallHistoryEntry var1, SQLRecoverableException var2) {
      this.replayingCallEntry = var1;
      this.originalError = var2;
   }

   public synchronized void setFailoverManager(FailoverManagerImpl var1) {
      this.failoverMngr = var1;
   }

   public synchronized FailoverManagerImpl getFailoverManager() {
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
}
