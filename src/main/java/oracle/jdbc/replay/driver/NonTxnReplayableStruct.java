package oracle.jdbc.replay.driver;

import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Struct;
import oracle.jdbc.OracleStruct;
import oracle.jdbc.proxy.annotation.GetCreator;
import oracle.jdbc.proxy.annotation.GetDelegate;
import oracle.jdbc.proxy.annotation.OnError;
import oracle.jdbc.proxy.annotation.Post;
import oracle.jdbc.proxy.annotation.Pre;
import oracle.jdbc.proxy.annotation.ProxyFor;
import oracle.jdbc.proxy.annotation.ProxyResult;
import oracle.jdbc.proxy.annotation.ProxyResultPolicy;
import oracle.jdbc.proxy.annotation.SetDelegate;

@ProxyFor({Struct.class, OracleStruct.class, oracle.jdbc.internal.OracleStruct.class})
public abstract class NonTxnReplayableStruct extends NonTxnReplayableBase implements Replayable {
   private static final String _Copyright_2007_Oracle_All_Rights_Reserved_ = null;
   public static final String BUILD_DATE = "Thu_Apr_04_15:09:24_PDT_2013";

   @Pre
   protected void preForAll(Method var1, Object var2, Object... var3) {
      super.preForAll(var1, var2, var3);
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
   public Connection getJavaSqlConnection() throws SQLException {
      return (Connection)this.getFailoverManager().getConnectionProxy();
   }
}
