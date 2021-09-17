package oracle.jdbc.replay.driver;

import java.io.InputStream;
import java.io.Reader;
import java.lang.reflect.Method;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLRecoverableException;
import oracle.jdbc.internal.ACProxyable;
import oracle.jdbc.internal.OracleCallableStatement;
import oracle.jdbc.internal.OraclePreparedStatement;
import oracle.jdbc.internal.OracleStatement;
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

@ProxyFor({OracleCallableStatement.class, OraclePreparedStatement.class, OracleStatement.class})
@ProxyAccess(ACProxyable.class)
public abstract class TxnReplayableStatement extends TxnReplayableBase implements JDBCReplayable, OracleStatement.BindChecksumListener {
   private static final String _Copyright_2007_Oracle_All_Rights_Reserved_ = null;
   public static final String BUILD_DATE = "Thu_Apr_04_15:09:24_PDT_2013";

   protected TxnReplayableStatement() {
      this.thisProxyNameInLog = "STMT" + this.thisProxyNameInLog;
   }

   @Pre
   protected void preForAll(Method var1, Object var2, Object... var3) {
      super.preForAll(var1, var2, var3);
   }

   @Pre
   @Methods(
      signatures = {@Signature(
   name = "executeQuery",
   args = {}
), @Signature(
   name = "executeQuery",
   args = {String.class}
)}
   )
   protected void preForExecuteQuery(Method var1, Object var2, Object... var3) {
      this.preForAll(var1, var2, var3);
      TxnFailoverManagerImpl.ReplayLifecycle var4 = this.failoverMngr.getReplayLifecycle();
      switch(var4) {
      case ENABLED_NOT_REPLAYING:
      case REPLAYING:
      case REPLAYING_LASTCALL:
         try {
            OracleStatement var5 = (OracleStatement)this.getDelegate();
            var5.registerBindChecksumListener(this);
         } catch (SQLException var6) {
         }
      case INTERNALLY_FAILED:
      case ALWAYS_DISABLED:
      case INTERNALLY_DISABLED:
      case EXTERNALLY_DISABLED:
      case REPLAYING_CALLBACK:
      default:
      }
   }

   @Pre
   @Methods(
      signatures = {@Signature(
   name = "execute",
   args = {}
), @Signature(
   name = "execute",
   args = {String.class}
), @Signature(
   name = "execute",
   args = {String.class, int.class}
), @Signature(
   name = "execute",
   args = {String.class, int.class}
), @Signature(
   name = "execute",
   args = {String.class, String.class}
)}
   )
   protected void preForExecute(Method var1, Object var2, Object... var3) {
      this.preForAll(var1, var2, var3);
      TxnFailoverManagerImpl.ReplayLifecycle var4 = this.failoverMngr.getReplayLifecycle();
      switch(var4) {
      case ENABLED_NOT_REPLAYING:
      case REPLAYING:
      case REPLAYING_LASTCALL:
         try {
            OracleStatement var5 = (OracleStatement)this.getDelegate();
            var5.registerBindChecksumListener(this);
         } catch (SQLException var6) {
         }
      case INTERNALLY_FAILED:
      case ALWAYS_DISABLED:
      case INTERNALLY_DISABLED:
      case EXTERNALLY_DISABLED:
      case REPLAYING_CALLBACK:
      default:
      }
   }

   @Pre
   @Methods(
      signatures = {@Signature(
   name = "executeUpdate",
   args = {}
), @Signature(
   name = "executeUpdate",
   args = {String.class}
), @Signature(
   name = "executeUpdate",
   args = {String.class, int.class}
), @Signature(
   name = "executeUpdate",
   args = {String.class, int.class}
), @Signature(
   name = "executeUpdate",
   args = {String.class, String.class}
)}
   )
   protected void preForExecuteUpdate(Method var1, Object var2, Object... var3) {
      this.preForAll(var1, var2, var3);
      TxnFailoverManagerImpl.ReplayLifecycle var4 = this.failoverMngr.getReplayLifecycle();
      switch(var4) {
      case ENABLED_NOT_REPLAYING:
      case REPLAYING:
      case REPLAYING_LASTCALL:
         try {
            OracleStatement var5 = (OracleStatement)this.getDelegate();
            var5.registerBindChecksumListener(this);
         } catch (SQLException var6) {
         }
      case INTERNALLY_FAILED:
      case ALWAYS_DISABLED:
      case INTERNALLY_DISABLED:
      case EXTERNALLY_DISABLED:
      case REPLAYING_CALLBACK:
      default:
      }
   }

   @Pre
   @Methods(
      signatures = {@Signature(
   name = "sendBatch",
   args = {}
), @Signature(
   name = "executeBatch",
   args = {}
)}
   )
   protected void preForBatches(Method var1, Object var2, Object... var3) {
      this.preForAll(var1, var2, var3);
      TxnFailoverManagerImpl.ReplayLifecycle var4 = this.failoverMngr.getReplayLifecycle();
      switch(var4) {
      case ENABLED_NOT_REPLAYING:
      case REPLAYING:
      case REPLAYING_LASTCALL:
         try {
            OracleStatement var5 = (OracleStatement)this.getDelegate();
            var5.registerBindChecksumListener(this);
         } catch (SQLException var6) {
         }
      case INTERNALLY_FAILED:
      case ALWAYS_DISABLED:
      case INTERNALLY_DISABLED:
      case EXTERNALLY_DISABLED:
      case REPLAYING_CALLBACK:
      default:
      }
   }

   @Pre
   @Methods(
      signatures = {@Signature(
   name = "setAsciiStream",
   args = {String.class, InputStream.class}
), @Signature(
   name = "setAsciiStream",
   args = {String.class, InputStream.class, int.class}
), @Signature(
   name = "setAsciiStream",
   args = {String.class, InputStream.class, long.class}
), @Signature(
   name = "setBinaryStream",
   args = {String.class, InputStream.class}
), @Signature(
   name = "setBinaryStream",
   args = {String.class, InputStream.class, int.class}
), @Signature(
   name = "setBinaryStream",
   args = {String.class, InputStream.class, long.class}
), @Signature(
   name = "setCharacterStream",
   args = {String.class, Reader.class}
), @Signature(
   name = "setCharacterStream",
   args = {String.class, Reader.class, int.class}
), @Signature(
   name = "setCharacterStream",
   args = {String.class, Reader.class, long.class}
), @Signature(
   name = "setNCharacterStream",
   args = {String.class, Reader.class}
), @Signature(
   name = "setNCharacterStream",
   args = {String.class, Reader.class, long.class}
), @Signature(
   name = "setAsciiStream",
   args = {int.class, InputStream.class}
), @Signature(
   name = "setAsciiStream",
   args = {int.class, InputStream.class, int.class}
), @Signature(
   name = "setAsciiStream",
   args = {int.class, InputStream.class, long.class}
), @Signature(
   name = "setBinaryStream",
   args = {int.class, InputStream.class}
), @Signature(
   name = "setBinaryStream",
   args = {int.class, InputStream.class, int.class}
), @Signature(
   name = "setBinaryStream",
   args = {int.class, InputStream.class, long.class}
), @Signature(
   name = "setCharacterStream",
   args = {int.class, Reader.class}
), @Signature(
   name = "setCharacterStream",
   args = {int.class, Reader.class, int.class}
), @Signature(
   name = "setCharacterStream",
   args = {int.class, Reader.class, long.class}
), @Signature(
   name = "setNCharacterStream",
   args = {int.class, Reader.class}
), @Signature(
   name = "setNCharacterStream",
   args = {int.class, Reader.class, long.class}
), @Signature(
   name = "setUnicodeStream",
   args = {int.class, InputStream.class, int.class}
), @Signature(
   name = "setAsciiStreamAtName",
   args = {String.class, InputStream.class}
), @Signature(
   name = "setAsciiStreamAtName",
   args = {String.class, InputStream.class, int.class}
), @Signature(
   name = "setAsciiStreamAtName",
   args = {String.class, InputStream.class, long.class}
), @Signature(
   name = "setBinaryStreamAtName",
   args = {String.class, InputStream.class}
), @Signature(
   name = "setBinaryStreamAtName",
   args = {String.class, InputStream.class, int.class}
), @Signature(
   name = "setBinaryStreamAtName",
   args = {String.class, InputStream.class, long.class}
), @Signature(
   name = "setCharacterStreamAtName",
   args = {String.class, Reader.class}
), @Signature(
   name = "setCharacterStreamAtName",
   args = {String.class, Reader.class, int.class}
), @Signature(
   name = "setCharacterStreamAtName",
   args = {String.class, Reader.class, long.class}
), @Signature(
   name = "setNCharacterStreamAtName",
   args = {String.class, Reader.class}
), @Signature(
   name = "setNCharacterStreamAtName",
   args = {String.class, Reader.class, long.class}
), @Signature(
   name = "setUnicodeStreamAtName",
   args = {String.class, InputStream.class, int.class}
)}
   )
   protected void preForSetStreams(Method var1, Object var2, Object... var3) {
      TxnFailoverManagerImpl.ReplayLifecycle var4 = this.failoverMngr.getReplayLifecycle();
      if (var4 == TxnFailoverManagerImpl.ReplayLifecycle.ENABLED_NOT_REPLAYING) {
         if (this.failoverMngr != null) {
            this.failoverMngr.disableReplayInternal(var1, 372, "Replay disabled because of nonreplayable call", (SQLRecoverableException)null);
         }

      }
   }

   @Pre
   @Methods(
      signatures = {@Signature(
   name = "setObject",
   args = {String.class, Object.class}
), @Signature(
   name = "setObject",
   args = {String.class, Object.class, int.class}
), @Signature(
   name = "setObject",
   args = {String.class, Object.class, int.class, int.class}
), @Signature(
   name = "setObject",
   args = {int.class, Object.class}
), @Signature(
   name = "setObject",
   args = {int.class, Object.class, int.class}
), @Signature(
   name = "setObject",
   args = {int.class, Object.class, int.class, int.class}
), @Signature(
   name = "setObjectAtName",
   args = {String.class, Object.class}
), @Signature(
   name = "setObjectAtName",
   args = {String.class, Object.class, int.class}
), @Signature(
   name = "setObjectAtName",
   args = {String.class, Object.class, int.class, int.class}
)}
   )
   protected void preForSetObjects(Method var1, Object var2, Object... var3) {
      TxnFailoverManagerImpl.ReplayLifecycle var4 = this.failoverMngr.getReplayLifecycle();
      if (var4 == TxnFailoverManagerImpl.ReplayLifecycle.ENABLED_NOT_REPLAYING) {
         if (!(var3[1] instanceof InputStream) && !(var3[1] instanceof Reader)) {
            this.preForAll(var1, var2, var3);
         } else if (this.failoverMngr != null) {
            this.failoverMngr.disableReplayInternal(var1, 372, "Replay disabled because of nonreplayable call", (SQLRecoverableException)null);
         }

      }
   }

   @Post
   protected void postForAll(Method var1) {
      this.postForAll(var1, (Object)null);
   }

   @Post
   protected Object postForAll(Method var1, Object var2) {
      return super.postForAll(var1, var2);
   }

   @Post
   @Methods(
      signatures = {@Signature(
   name = "getResultSet",
   args = {}
)}
   )
   protected ResultSet postForGetResultSet(Method var1, ResultSet var2) {
      this.postForAll(var1, var2);
      if (!this.failoverMngr.isSessionStateConsistencyDynamic()) {
         TxnFailoverManagerImpl.ReplayLifecycle var3 = this.failoverMngr.getReplayLifecycle();
         switch(var3) {
         case ENABLED_NOT_REPLAYING:
            for(TxnFailoverManagerImpl.CallHistoryEntry var4 = this.tailSameProxy; var4 != this.headSameProxy; var4 = var4.prevEntrySameProxy) {
               if ("execute".equals(var4.method.getName()) && var4.result instanceof Integer) {
                  ((TxnReplayableResultSet)var2).creatorCallEntry = var4;
               }
            }
         case REPLAYING:
         case REPLAYING_LASTCALL:
         case INTERNALLY_FAILED:
         case ALWAYS_DISABLED:
         case INTERNALLY_DISABLED:
         case EXTERNALLY_DISABLED:
         case REPLAYING_CALLBACK:
         }
      }

      return var2;
   }

   @Post
   @Methods(
      signatures = {@Signature(
   name = "executeQuery",
   args = {}
), @Signature(
   name = "executeQuery",
   args = {String.class}
)}
   )
   protected ResultSet postForExecuteQuery(Method var1, ResultSet var2) {
      this.postForAll(var1, var2);
      if (!this.failoverMngr.isSessionStateConsistencyDynamic()) {
         TxnFailoverManagerImpl.ReplayLifecycle var3 = this.failoverMngr.getReplayLifecycle();
         switch(var3) {
         case ENABLED_NOT_REPLAYING:
            ((TxnReplayableResultSet)var2).creatorCallEntry = this.tailSameProxy;
         case REPLAYING:
         case REPLAYING_LASTCALL:
         case INTERNALLY_FAILED:
         case ALWAYS_DISABLED:
         case INTERNALLY_DISABLED:
         case EXTERNALLY_DISABLED:
         case REPLAYING_CALLBACK:
         }
      }

      return var2;
   }

   @OnError(SQLException.class)
   protected void onErrorVoidForAll(Method var1, SQLException var2) throws SQLException {
      super.onErrorVoidForAll(var1, var2);
   }

   @OnError(SQLException.class)
   protected Object onErrorForAll(Method var1, SQLException var2) throws SQLException {
      return super.onErrorForAll(var1, var2);
   }

   @OnError(SQLException.class)
   @Methods(
      signatures = {@Signature(
   name = "close",
   args = {}
)}
   )
   protected void onErrorVoidForClose(Method var1, SQLException var2) throws SQLException {
      if (!(var2 instanceof SQLRecoverableException)) {
         super.onErrorVoidForAll(var1, var2);
      }
   }

   @GetDelegate
   protected abstract Object getDelegate();

   @SetDelegate
   protected abstract void setDelegate(Object var1);

   @GetCreator
   protected abstract Object getCreator();

   public boolean shouldContinue(long var1) {
      boolean var3 = true;
      TxnFailoverManagerImpl.CallHistoryEntry var4 = this.tailSameProxy;
      TxnFailoverManagerImpl.ReplayLifecycle var5 = this.failoverMngr.getReplayLifecycle();
      switch(var5) {
      case ENABLED_NOT_REPLAYING:
      case REPLAYING_LASTCALL:
         this.currentBindChecksum = var1;
         break;
      case REPLAYING:
         if (var4.checksum != 0L && var4.checksum != var1) {
            this.failoverMngr.disableReplayInternal(var4.method, 388, "Replay failed because of checksum mismatch", (SQLRecoverableException)null);
            var3 = false;
         }
      case INTERNALLY_FAILED:
      case ALWAYS_DISABLED:
      case INTERNALLY_DISABLED:
      case EXTERNALLY_DISABLED:
      case REPLAYING_CALLBACK:
      }

      var4 = null;
      return var3;
   }
}
