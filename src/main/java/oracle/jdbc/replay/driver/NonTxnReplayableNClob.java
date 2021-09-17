package oracle.jdbc.replay.driver;

import java.lang.reflect.Method;
import java.sql.NClob;
import java.sql.SQLException;
import oracle.jdbc.OracleNClob;
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

@ProxyFor({NClob.class, OracleNClob.class, oracle.jdbc.internal.OracleNClob.class})
public abstract class NonTxnReplayableNClob extends NonTxnReplayableClob implements Replayable {
   private static final String _Copyright_2007_Oracle_All_Rights_Reserved_ = null;
   public static final String BUILD_DATE = "Thu_Apr_04_15:09:24_PDT_2013";

   @Pre
   protected void preForAll(Method var1, Object var2, Object... var3) {
      super.preForAll(var1, var2, var3);
   }

   @Pre
   @Methods(
      signatures = {@Signature(
   name = "setString",
   args = {long.class, String.class}
), @Signature(
   name = "setString",
   args = {long.class, String.class, int.class, int.class}
), @Signature(
   name = "truncate",
   args = {long.class}
)}
   )
   protected void preForClobWrites(Method var1, Object var2, Object... var3) {
      FailoverManagerImpl.ReplayLifecycle var4 = this.failoverMngr.getReplayLifecycle();
      if (var4 == FailoverManagerImpl.ReplayLifecycle.ENABLED_NOT_REPLAYING) {
         super.preForClobWrites(var1, var2, var3);
      }
   }

   @Post
   protected Object postForAll(Method var1, Object var2) {
      if (var2 instanceof NonTxnReplayableBase) {
         NonTxnReplayableBase var3 = (NonTxnReplayableBase)var2;
         var3.setFailoverManager(this.getFailoverManager());
      }

      return super.postForAll(var1, var2);
   }

   @OnError(SQLException.class)
   protected void onErrorVoidForAll(Method var1, SQLException var2) throws SQLException {
      super.onErrorVoidForAll(var1, var2);
   }

   @OnError(SQLException.class)
   protected Object onErrorForAll(Method var1, SQLException var2) throws SQLException {
      return super.onErrorForAll(var1, var2);
   }

   @GetDelegate
   protected abstract Object getDelegate();

   @SetDelegate
   protected abstract void setDelegate(Object var1);

   @GetCreator
   protected abstract Object getCreator();

   @ProxyResult(ProxyResultPolicy.MANUAL)
   public OracleConnection getInternalConnection() throws SQLException {
      oracle.jdbc.internal.OracleNClob var1 = (oracle.jdbc.internal.OracleNClob)this.getDelegate();
      return var1.getInternalConnection();
   }
}
