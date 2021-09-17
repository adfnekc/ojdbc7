package oracle.jdbc.replay.driver;

import java.io.InputStream;
import java.io.Reader;
import java.lang.reflect.Method;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLRecoverableException;
import java.sql.Statement;
import oracle.jdbc.OracleResultSet;
import oracle.jdbc.internal.OracleStatement;
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

@ProxyFor({ResultSet.class, OracleResultSet.class, oracle.jdbc.internal.OracleResultSet.class})
@ProxyResult(ProxyResultPolicy.CREATE)
public abstract class NonTxnReplayableResultSet extends NonTxnReplayableBase implements Replayable {
   private static final String _Copyright_2007_Oracle_All_Rights_Reserved_ = null;
   public static final String BUILD_DATE = "Thu_Apr_04_15:09:24_PDT_2013";

   @Pre
   protected void preForAll(Method var1, Object var2, Object... var3) {
      super.preForAll(var1, var2, var3);
   }

   @Pre
   @Methods(
      signatures = {@Signature(
   name = "deleteRow",
   args = {}
), @Signature(
   name = "insertRow",
   args = {}
), @Signature(
   name = "updateRow",
   args = {}
)}
   )
   protected void preForRowUpdates(Method var1, Object var2, Object... var3) {
      FailoverManagerImpl.ReplayLifecycle var4 = this.failoverMngr.getReplayLifecycle();
      if (var4 == FailoverManagerImpl.ReplayLifecycle.ENABLED_NOT_REPLAYING) {
         if (this.failoverMngr != null) {
            this.failoverMngr.disableReplayInternal(var1, 371, "Replay disabled because of active transaction", (SQLRecoverableException)null);
         }

      }
   }

   @Pre
   @Methods(
      signatures = {@Signature(
   name = "updateAsciiStream",
   args = {String.class, InputStream.class}
), @Signature(
   name = "updateAsciiStream",
   args = {String.class, InputStream.class, int.class}
), @Signature(
   name = "updateAsciiStream",
   args = {String.class, InputStream.class, long.class}
), @Signature(
   name = "updateBinaryStream",
   args = {String.class, InputStream.class}
), @Signature(
   name = "updateBinaryStream",
   args = {String.class, InputStream.class, int.class}
), @Signature(
   name = "updateBinaryStream",
   args = {String.class, InputStream.class, long.class}
), @Signature(
   name = "updateCharacterStream",
   args = {String.class, Reader.class}
), @Signature(
   name = "updateCharacterStream",
   args = {String.class, Reader.class, int.class}
), @Signature(
   name = "updateCharacterStream",
   args = {String.class, Reader.class, long.class}
), @Signature(
   name = "updateNCharacterStream",
   args = {String.class, Reader.class}
), @Signature(
   name = "updateNCharacterStream",
   args = {String.class, Reader.class, long.class}
), @Signature(
   name = "updateAsciiStream",
   args = {int.class, InputStream.class}
), @Signature(
   name = "updateAsciiStream",
   args = {int.class, InputStream.class, int.class}
), @Signature(
   name = "updateAsciiStream",
   args = {int.class, InputStream.class, long.class}
), @Signature(
   name = "updateBinaryStream",
   args = {int.class, InputStream.class}
), @Signature(
   name = "updateBinaryStream",
   args = {int.class, InputStream.class, int.class}
), @Signature(
   name = "updateBinaryStream",
   args = {int.class, InputStream.class, long.class}
), @Signature(
   name = "updateCharacterStream",
   args = {int.class, Reader.class}
), @Signature(
   name = "updateCharacterStream",
   args = {int.class, Reader.class, int.class}
), @Signature(
   name = "updateCharacterStream",
   args = {int.class, Reader.class, long.class}
), @Signature(
   name = "updateNCharacterStream",
   args = {int.class, Reader.class}
), @Signature(
   name = "updateNCharacterStream",
   args = {int.class, Reader.class, long.class}
)}
   )
   protected void preForUpdateStreams(Method var1, Object var2, Object... var3) {
      FailoverManagerImpl.ReplayLifecycle var4 = this.failoverMngr.getReplayLifecycle();
      if (var4 == FailoverManagerImpl.ReplayLifecycle.ENABLED_NOT_REPLAYING) {
         if (this.failoverMngr != null) {
            this.failoverMngr.disableReplayInternal(var1, 371, "Replay disabled because of active transaction", (SQLRecoverableException)null);
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
   name = "next",
   args = {}
)}
   )
   protected boolean postForNext(Method var1, boolean var2) {
      FailoverManagerImpl.ReplayLifecycle var3 = this.failoverMngr.getReplayLifecycle();
      switch(var3) {
      case ENABLED_NOT_REPLAYING:
      case REPLAYING_LASTCALL:
         this.doPostWhenRecordingNext(var1, var2, (SQLException)null);
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
      }
   }

   @OnError(SQLException.class)
   protected void onErrorVoidForAll(Method var1, SQLException var2) throws SQLException {
      this.onErrorForAll(var1, var2);
   }

   @OnError(SQLException.class)
   protected Object onErrorForAll(Method var1, SQLException var2) throws SQLException {
      return super.onErrorForAll(var1, var2);
   }

   @OnError(SQLException.class)
   @Methods(
      signatures = {@Signature(
   name = "last",
   args = {}
)}
   )
   protected boolean onErrorForLast(Method var1, SQLException var2) throws SQLException {
      if (this.isClosedAndNoReplay) {
         throw var2;
      } else {
         FailoverManagerImpl.ReplayLifecycle var3 = this.failoverMngr.getReplayLifecycle();
         if (var2 instanceof SQLRecoverableException && var3 == FailoverManagerImpl.ReplayLifecycle.ENABLED_NOT_REPLAYING) {
            this.failoverMngr.disableReplayInternal(var1, 372, "Replay disabled because of nonreplayable call", (SQLRecoverableException)null);
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
      OracleStatement var2 = (OracleStatement)((NonTxnReplayableBase)this.getCreator()).getDelegate();
      long var3 = var2.getChecksum();
      this.failoverMngr.update(this, var1, var1.result, var1.callStatus, var3, var1.scn, var1.callException);
   }

   public Object replayOneCall(FailoverManagerImpl.CallHistoryEntry var1, SQLRecoverableException var2) throws SQLException {
      Object var3 = super.replayOneCall(var1, var2);
      return var3;
   }

   protected void doPostWhenRecordingNext(Method var1, Object var2, SQLException var3) {
      long var6 = 0L;
      OracleStatement var8 = (OracleStatement)((NonTxnReplayableBase)this.getCreator()).getDelegate();

      try {
         var6 = var8.getChecksum();
      } catch (SQLException var10) {
         var6 = 0L;
      }

      this.failoverMngr.update(this, (FailoverManagerImpl.CallHistoryEntry)null, var2, "completed", var6, -1L, var3);
   }

   protected void doPostWhenRecordingClose(Method var1, SQLException var2) {
      NonTxnReplayableStatement var3 = (NonTxnReplayableStatement)this.getCreator();
      if (var3.okToPurgeSameProxyList()) {
         this.purgeSameProxyList();
      }

      this.isClosedAndNoReplay = true;
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
               OracleStatement var5 = (OracleStatement)((NonTxnReplayableBase)this.getCreator()).getDelegate();
               long var6 = var5.getChecksum();
               if (this.replayingCallEntry.checksum != var6) {
                  this.failoverMngr.disableReplayAndThrowException(this.replayingCallEntry.method, 388, "Replay failed because of checksum mismatch", this.originalError);
               }
            }
         }
      } catch (SQLException var8) {
      }

   }

   @ProxyResult(ProxyResultPolicy.MANUAL)
   public Statement getStatement() throws SQLException {
      return (Statement)this.getCreator();
   }

   @ProxyResult(ProxyResultPolicy.MANUAL)
   public Object unwrap(Class var1) throws SQLException {
      return this.getDelegate();
   }
}
