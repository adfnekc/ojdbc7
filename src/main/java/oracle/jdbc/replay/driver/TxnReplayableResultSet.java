package oracle.jdbc.replay.driver;

import java.io.InputStream;
import java.io.Reader;
import java.lang.reflect.Method;
import java.sql.SQLException;
import java.sql.SQLRecoverableException;
import oracle.jdbc.internal.ACProxyable;
import oracle.jdbc.internal.OracleResultSet;
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

@ProxyFor({OracleResultSet.class})
@ProxyAccess(ACProxyable.class)
public abstract class TxnReplayableResultSet extends TxnReplayableBase implements JDBCReplayable {
   private static final String _Copyright_2007_Oracle_All_Rights_Reserved_ = null;
   public static final String BUILD_DATE = "Thu_Apr_04_15:09:24_PDT_2013";

   protected TxnReplayableResultSet() {
      this.thisProxyNameInLog = "RSET" + this.thisProxyNameInLog;
   }

   @Pre
   protected void preForAll(Method var1, Object var2, Object... var3) {
      super.preForAll(var1, var2, var3);
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
      TxnFailoverManagerImpl.ReplayLifecycle var4 = this.failoverMngr.getReplayLifecycle();
      if (var4 == TxnFailoverManagerImpl.ReplayLifecycle.ENABLED_NOT_REPLAYING) {
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
         TxnFailoverManagerImpl.ReplayLifecycle var3 = this.failoverMngr.getReplayLifecycle();
         if (var2 instanceof SQLRecoverableException && var3 == TxnFailoverManagerImpl.ReplayLifecycle.ENABLED_NOT_REPLAYING) {
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

   public Object replayOneCall(TxnFailoverManagerImpl.CallHistoryEntry var1, SQLRecoverableException var2) throws SQLException {
      Object var3 = super.replayOneCall(var1, var2);
      return var3;
   }
}
