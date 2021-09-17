package oracle.jdbc.replay.driver;

import java.sql.SQLException;
import java.sql.SQLRecoverableException;
import oracle.jdbc.internal.OracleConnection;

public class EndReplayCallback implements OracleConnection.EndReplayCallback {
   TxnFailoverManagerImpl manager;
   OracleConnection connection;
   SQLRecoverableException origError;

   public EndReplayCallback(TxnFailoverManagerImpl var1, OracleConnection var2, SQLRecoverableException var3) {
      this.manager = var1;
      this.connection = var2;
      this.origError = var3;
   }

   public void executeCallback() throws SQLException {
      this.manager.endReplay(this.connection, this.origError);
   }
}
