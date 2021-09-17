package oracle.jdbc.replay.driver;

import java.io.InputStream;
import java.io.Reader;
import java.lang.reflect.Method;
import java.sql.Array;
import java.sql.Blob;
import java.sql.CallableStatement;
import java.sql.Clob;
import java.sql.Connection;
import java.sql.NClob;
import java.sql.ParameterMetaData;
import java.sql.PreparedStatement;
import java.sql.Ref;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.RowId;
import java.sql.SQLException;
import java.sql.SQLRecoverableException;
import java.sql.SQLXML;
import java.sql.Statement;
import java.sql.Struct;
import java.util.EnumSet;
import oracle.jdbc.OracleCallableStatement;
import oracle.jdbc.OraclePreparedStatement;
import oracle.jdbc.OracleStatement;
import oracle.jdbc.internal.OracleConnection;
import oracle.jdbc.proxy.annotation.GetCreator;
import oracle.jdbc.proxy.annotation.GetDelegate;
import oracle.jdbc.proxy.annotation.Methods;
import oracle.jdbc.proxy.annotation.OnError;
import oracle.jdbc.proxy.annotation.Post;
import oracle.jdbc.proxy.annotation.Pre;
import oracle.jdbc.proxy.annotation.ProxyFor;
import oracle.jdbc.proxy.annotation.ProxyResult;
import oracle.jdbc.proxy.annotation.ProxyResultPolicy;
import oracle.jdbc.proxy.annotation.SetDelegate;
import oracle.jdbc.proxy.annotation.Signature;

@ProxyFor({CallableStatement.class, PreparedStatement.class, Statement.class, OracleCallableStatement.class, OraclePreparedStatement.class, OracleStatement.class, oracle.jdbc.internal.OracleCallableStatement.class, oracle.jdbc.internal.OraclePreparedStatement.class, oracle.jdbc.internal.OracleStatement.class})
public abstract class NonTxnReplayableStatement extends NonTxnReplayableBase implements Replayable {
   private static final String _Copyright_2007_Oracle_All_Rights_Reserved_ = null;
   public static final String BUILD_DATE = "Thu_Apr_04_15:09:24_PDT_2013";

   @Pre
   protected void preForAll(Method var1, Object var2, Object... var3) {
      super.preForAll(var1, var2, var3);
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
      FailoverManagerImpl.ReplayLifecycle var4 = this.failoverMngr.getReplayLifecycle();
      if (var4 == FailoverManagerImpl.ReplayLifecycle.ENABLED_NOT_REPLAYING) {
         try {
            oracle.jdbc.internal.OracleStatement var5 = (oracle.jdbc.internal.OracleStatement)this.getDelegate();
            oracle.jdbc.internal.OracleStatement.SqlKind var6 = var5.getSqlKind();
            if (!var6.isSELECT() && !var6.isPlsqlOrCall() && var6 != oracle.jdbc.internal.OracleStatement.SqlKind.ALTER_SESSION && var6 != oracle.jdbc.internal.OracleStatement.SqlKind.UNINITIALIZED) {
               if (var6.isDML()) {
                  if (this.failoverMngr != null) {
                     this.failoverMngr.disableReplayInternal(var1, 371, "Replay disabled because of active transaction", (SQLRecoverableException)null);
                  }
               } else if (var6.isOTHER() && this.failoverMngr != null) {
                  this.failoverMngr.disableReplayInternal(var1, 372, "Replay disabled because of nonreplayable call", (SQLRecoverableException)null);
               }
            } else {
               this.preForAll(var1, var2, var3);
            }
         } catch (SQLException var7) {
         }

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
      FailoverManagerImpl.ReplayLifecycle var4 = this.failoverMngr.getReplayLifecycle();
      if (var4 == FailoverManagerImpl.ReplayLifecycle.ENABLED_NOT_REPLAYING) {
         try {
            oracle.jdbc.internal.OracleStatement var5 = (oracle.jdbc.internal.OracleStatement)this.getDelegate();
            oracle.jdbc.internal.OracleStatement.SqlKind var6 = var5.getSqlKind();
            if (var6.isPlsqlOrCall()) {
               this.preForAll(var1, var2, var3);
            } else if (this.failoverMngr != null) {
               this.failoverMngr.disableReplayInternal(var1, 371, "Replay disabled because of active transaction", (SQLRecoverableException)null);
            }
         } catch (SQLException var7) {
         }

      }
   }

   @Pre
   @Methods(
      signatures = {@Signature(
   name = "executeBatch",
   args = {}
)}
   )
   protected void preForExecuteBatch(Method var1, Object var2, Object... var3) {
      FailoverManagerImpl.ReplayLifecycle var4 = this.failoverMngr.getReplayLifecycle();
      if (var4 == FailoverManagerImpl.ReplayLifecycle.ENABLED_NOT_REPLAYING) {
         if (this.failoverMngr != null) {
            this.failoverMngr.disableReplayInternal(var1, 372, "Replay disabled because of nonreplayable call", (SQLRecoverableException)null);
         }

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
   args = {int.class, InputStream.class}
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
   args = {String.class, InputStream.class}
)}
   )
   protected void preForSetStreams(Method var1, Object var2, Object... var3) {
      FailoverManagerImpl.ReplayLifecycle var4 = this.failoverMngr.getReplayLifecycle();
      if (var4 == FailoverManagerImpl.ReplayLifecycle.ENABLED_NOT_REPLAYING) {
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
      FailoverManagerImpl.ReplayLifecycle var4 = this.failoverMngr.getReplayLifecycle();
      if (var4 == FailoverManagerImpl.ReplayLifecycle.ENABLED_NOT_REPLAYING) {
         if ((var3[1] instanceof InputStream || var3[1] instanceof Reader) && this.failoverMngr != null) {
            this.failoverMngr.disableReplayInternal(var1, 372, "Replay disabled because of nonreplayable call", (SQLRecoverableException)null);
         }

      }
   }

   @Post
   protected Object postForAll(Method var1, Object var2) {
      return super.postForAll(var1, var2);
   }

   @Post
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
   protected boolean postForExecute(Method var1, boolean var2) {
      FailoverManagerImpl.ReplayLifecycle var3 = this.failoverMngr.getReplayLifecycle();
      switch(var3) {
      case ENABLED_NOT_REPLAYING:
      case REPLAYING_LASTCALL:
         this.doPostWhenRecordingExecutes(var1, var2, (SQLException)null);
      case INTERNALLY_FAILED:
      case ALWAYS_DISABLED:
      case INTERNALLY_DISABLED:
      case EXTERNALLY_DISABLED:
      case REPLAYING_CALLBACK:
      default:
         break;
      case REPLAYING:
         this.doPostWhenReplayingExecutes(var1, var2, (SQLException)null);
      }

      return var2;
   }

   @Post
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
   protected int postForExecuteUpdate(Method var1, int var2) {
      FailoverManagerImpl.ReplayLifecycle var3 = this.failoverMngr.getReplayLifecycle();
      switch(var3) {
      case ENABLED_NOT_REPLAYING:
      case REPLAYING_LASTCALL:
         this.doPostWhenRecordingExecutes(var1, var2, (SQLException)null);
      case INTERNALLY_FAILED:
      case ALWAYS_DISABLED:
      case INTERNALLY_DISABLED:
      case EXTERNALLY_DISABLED:
      case REPLAYING_CALLBACK:
      default:
         break;
      case REPLAYING:
         this.doPostWhenReplayingExecutes(var1, var2, (SQLException)null);
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
      if (var2 instanceof NonTxnReplayableBase) {
         NonTxnReplayableBase var3 = (NonTxnReplayableBase)var2;
         var3.setFailoverManager(this.getFailoverManager());
      }

      FailoverManagerImpl.ReplayLifecycle var4 = this.failoverMngr.getReplayLifecycle();
      switch(var4) {
      case ENABLED_NOT_REPLAYING:
      case REPLAYING_LASTCALL:
         this.doPostWhenRecordingExecutes(var1, var2, (SQLException)null);
      case INTERNALLY_FAILED:
      case ALWAYS_DISABLED:
      case INTERNALLY_DISABLED:
      case EXTERNALLY_DISABLED:
      case REPLAYING_CALLBACK:
      default:
         break;
      case REPLAYING:
         this.doPostWhenReplayingExecutes(var1, var2, (SQLException)null);
      }

      return var2;
   }

   @Post
   @Methods(
      signatures = {@Signature(
   name = "close",
   args = {}
)}
   )
   protected void postForClose(Method var1) {
      FailoverManagerImpl.ReplayLifecycle var2 = this.failoverMngr.getReplayLifecycle();
      switch(var2) {
      case ENABLED_NOT_REPLAYING:
         this.doPostWhenRecordingClose(var1, (SQLException)null);
      case REPLAYING_LASTCALL:
      case INTERNALLY_FAILED:
      case ALWAYS_DISABLED:
      case INTERNALLY_DISABLED:
      case EXTERNALLY_DISABLED:
      case REPLAYING_CALLBACK:
      case REPLAYING:
      default:
         this.isClosedAndNoReplay = true;
      }
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

   @OnError(SQLException.class)
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
   protected boolean onErrorForExecute(Method var1, SQLException var2) throws SQLException {
      if (this.isClosedAndNoReplay) {
         throw var2;
      } else {
         FailoverManagerImpl.ReplayLifecycle var3 = this.failoverMngr.getReplayLifecycle();
         if (var2 instanceof SQLRecoverableException && var3 == FailoverManagerImpl.ReplayLifecycle.ENABLED_NOT_REPLAYING) {
            try {
               oracle.jdbc.internal.OracleStatement var4 = (oracle.jdbc.internal.OracleStatement)this.getDelegate();
               oracle.jdbc.internal.OracleStatement.SqlKind var5 = var4.getSqlKind();
               if (var5.isPlsqlOrCall()) {
                  this.failoverMngr.disableReplayInternal(var1, 373, "Replay disabled because outage occurred during PL/SQL execution", (SQLRecoverableException)null);
               } else if (var5.isDML()) {
                  if (this.failoverMngr != null) {
                     this.failoverMngr.disableReplayInternal(var1, 371, "Replay disabled because of active transaction", (SQLRecoverableException)null);
                  }
               } else if (var5.isOTHER() && var5 != oracle.jdbc.internal.OracleStatement.SqlKind.ALTER_SESSION && this.failoverMngr != null) {
                  this.failoverMngr.disableReplayInternal(var1, 372, "Replay disabled because of nonreplayable call", (SQLRecoverableException)null);
               }
            } catch (SQLException var6) {
            }
         }

         return (Boolean)super.onErrorForAll(var1, var2);
      }
   }

   @GetDelegate
   protected abstract Object getDelegate();

   @SetDelegate
   protected abstract void setDelegate(Object var1);

   @GetCreator
   protected abstract Object getCreator();

   public void fillInChecksum(FailoverManagerImpl.CallHistoryEntry var1) throws SQLException {
      oracle.jdbc.internal.OracleStatement var2 = (oracle.jdbc.internal.OracleStatement)this.getDelegate();
      long var3 = var2.getChecksum();
      if (var1 != null && var1.method != null) {
         var1.method.getName();
      } else {
         String var10000 = "NULL METHOD";
      }

      this.failoverMngr.update(this, var1, var1.result, var1.callStatus, var3, var1.scn, var1.callException);
   }

   public Object replayOneCall(FailoverManagerImpl.CallHistoryEntry var1, SQLRecoverableException var2) throws SQLException {
      if (var1.scn != -1L) {
         oracle.jdbc.internal.OracleStatement var3 = (oracle.jdbc.internal.OracleStatement)this.getDelegate();
         var3.setSnapshotSCN(var1.scn);
         if (var1 != null && var1.method != null) {
            var1.method.getName();
         } else {
            String var10000 = "NULL METHOD";
         }
      }

      return super.replayOneCall(var1, var2);
   }

   protected void doPostWhenReplaying(Method var1, Object var2, SQLException var3) {
      try {
         FailoverManagerImpl.ReplayLifecycle var4 = this.failoverMngr.getReplayLifecycle();
         switch(var4) {
         case REPLAYING_LASTCALL:
         default:
            break;
         case REPLAYING:
            if (this.replayingCallEntry.checksum != 0L) {
               oracle.jdbc.internal.OracleStatement var5 = (oracle.jdbc.internal.OracleStatement)this.getDelegate();
               long var6 = var5.getChecksum();
               if (this.replayingCallEntry != null && this.replayingCallEntry.method != null) {
                  this.replayingCallEntry.method.getName();
               } else {
                  String var10000 = "NULL METHOD";
               }

               if (this.replayingCallEntry.checksum != var6) {
                  this.failoverMngr.disableReplayAndThrowException(this.replayingCallEntry.method, 388, "Replay failed because of checksum mismatch", this.originalError);
               }
            }
         }
      } catch (SQLException var9) {
      }

   }

   protected void doPostWhenReplayingExecutes(Method var1, Object var2, SQLException var3) {
      try {
         FailoverManagerImpl.ReplayLifecycle var4 = this.failoverMngr.getReplayLifecycle();
         switch(var4) {
         case REPLAYING_LASTCALL:
            oracle.jdbc.internal.OracleStatement var5 = (oracle.jdbc.internal.OracleStatement)this.getDelegate();
            oracle.jdbc.internal.OracleStatement.SqlKind var6 = var5.getSqlKind();
            if (var6.isPlsqlOrCall()) {
               this.failoverMngr.disableReplayInternal(this.replayingCallEntry.method, 373, "Replay disabled because outage occurred during PL/SQL execution", this.originalError);
            }
            break;
         case REPLAYING:
            this.doPostWhenReplaying(var1, var2, var3);
         }
      } catch (SQLException var7) {
      }

   }

   boolean okToPurgeSameProxyList() {
      boolean var1 = false;

      try {
         oracle.jdbc.internal.OracleStatement var2 = (oracle.jdbc.internal.OracleStatement)this.getDelegate();
         oracle.jdbc.internal.OracleStatement.SqlKind var3 = var2.getSqlKind();
         if (var3 == oracle.jdbc.internal.OracleStatement.SqlKind.UNINITIALIZED) {
            var1 = true;
         } else if (var3.isSELECT() && var3 != oracle.jdbc.internal.OracleStatement.SqlKind.SELECT_FOR_UPDATE) {
            for(FailoverManagerImpl.CallHistoryEntry var5 = this.headSameProxy; var5 != null; var5 = var5.nextEntrySameProxy) {
               String var4 = var5.method == null ? "NULL METHOD" : var5.method.getName();
               if (("execute".equals(var4) || "executeQuery".equals(var4)) && var5.scn > 0L) {
                  var1 = true;
                  break;
               }
            }
         }

         return var1;
      } catch (SQLException var9) {
         var1 = false;
         return var1;
      } finally {
         ;
      }
   }

   protected void doPostWhenRecordingClose(Method var1, SQLException var2) {
      if (this.okToPurgeSameProxyList()) {
         this.purgeSameProxyList();
      }

   }

   protected void doPostWhenRecordingExecutes(Method var1, Object var2, SQLException var3) {
      try {
         oracle.jdbc.internal.OracleStatement var4 = (oracle.jdbc.internal.OracleStatement)this.getDelegate();
         OracleConnection var5 = (OracleConnection)var4.getConnection();
         oracle.jdbc.internal.OracleStatement.SqlKind var6 = var4.getSqlKind();
         long var7 = 0L;
         long var9 = -1L;
         if (var1 == null) {
            String var10000 = "NULL METHOD";
         } else {
            var1.getName();
         }

         if (!var6.isSELECT() && !var6.isPlsqlOrCall() && var6 != oracle.jdbc.internal.OracleStatement.SqlKind.ALTER_SESSION) {
            this.failoverMngr.update(this, (FailoverManagerImpl.CallHistoryEntry)null, var2, "completed", var7, var9, var3);
            this.failoverMngr.disableReplayInternal(var1, 372, "Replay disabled because of nonreplayable call", (SQLRecoverableException)null);
         } else {
            EnumSet var12 = var5.getTransactionState();
            if (var12.contains(OracleConnection.TransactionState.TRANSACTION_INTENTION) || var12.contains(OracleConnection.TransactionState.TRANSACTION_STARTED) && !var12.contains(OracleConnection.TransactionState.TRANSACTION_READONLY)) {
               this.failoverMngr.disableReplayInternal(var1, 371, "Replay disabled because of transaction", (SQLRecoverableException)null);
            } else {
               var7 = 0L;
               if (!this.failoverMngr.isReplayInCurrentMode() && var6.isPlsqlOrCall()) {
                  this.failoverMngr.setReplayInCurrentMode();
               }

               var9 = this.failoverMngr.isReplayInCurrentMode() ? -1L : var5.getCurrentSCN();
            }

            if (this.failoverMngr.getReplayLifecycle() == FailoverManagerImpl.ReplayLifecycle.ENABLED_NOT_REPLAYING) {
               this.failoverMngr.update(this, (FailoverManagerImpl.CallHistoryEntry)null, var2, "completed", var7, var9, var3);
            }
         }
      } catch (SQLException var13) {
      }

   }

   @ProxyResult(ProxyResultPolicy.MANUAL)
   public Connection getConnection() throws SQLException {
      return (Connection)this.getCreator();
   }

   @ProxyResult(ProxyResultPolicy.MANUAL)
   public Object unwrap(Class var1) throws SQLException {
      return this.getDelegate();
   }

   @ProxyResult(ProxyResultPolicy.CREATE_CACHE)
   public abstract ResultSet executeQuery(String var1) throws SQLException;

   @ProxyResult(ProxyResultPolicy.CREATE_CACHE)
   public abstract ResultSet executeQuery() throws SQLException;

   @ProxyResult(ProxyResultPolicy.CREATE)
   public abstract ResultSetMetaData getMetaData() throws SQLException;

   @ProxyResult(ProxyResultPolicy.CREATE)
   public abstract ParameterMetaData getParameterMetaData() throws SQLException;

   @ProxyResult(ProxyResultPolicy.CREATE)
   public abstract Array getArray(int var1) throws SQLException;

   @ProxyResult(ProxyResultPolicy.CREATE)
   public abstract Array getArray(String var1) throws SQLException;

   @ProxyResult(ProxyResultPolicy.CREATE)
   public abstract Blob getBlob(int var1) throws SQLException;

   @ProxyResult(ProxyResultPolicy.CREATE)
   public abstract Blob getBlob(String var1) throws SQLException;

   @ProxyResult(ProxyResultPolicy.CREATE)
   public abstract Clob getClob(int var1) throws SQLException;

   @ProxyResult(ProxyResultPolicy.CREATE)
   public abstract Clob getClob(String var1) throws SQLException;

   @ProxyResult(ProxyResultPolicy.CREATE)
   public abstract NClob getNClob(int var1) throws SQLException;

   @ProxyResult(ProxyResultPolicy.CREATE)
   public abstract NClob getNClob(String var1) throws SQLException;

   @ProxyResult(ProxyResultPolicy.CREATE)
   public abstract Ref getRef(int var1) throws SQLException;

   @ProxyResult(ProxyResultPolicy.CREATE)
   public abstract Ref getRef(String var1) throws SQLException;

   @ProxyResult(ProxyResultPolicy.CREATE)
   public abstract RowId getRowId(int var1) throws SQLException;

   @ProxyResult(ProxyResultPolicy.CREATE)
   public abstract RowId getRowId(String var1) throws SQLException;

   @ProxyResult(ProxyResultPolicy.CREATE)
   public abstract Struct getStruct(int var1) throws SQLException;

   @ProxyResult(ProxyResultPolicy.CREATE)
   public abstract Struct getStruct(String var1) throws SQLException;

   @ProxyResult(ProxyResultPolicy.CREATE)
   public abstract SQLXML getSQLXML(int var1) throws SQLException;

   @ProxyResult(ProxyResultPolicy.CREATE)
   public abstract SQLXML getSQLXML(String var1) throws SQLException;
}
