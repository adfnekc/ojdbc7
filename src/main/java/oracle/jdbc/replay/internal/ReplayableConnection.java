package oracle.jdbc.replay.internal;

import java.sql.SQLException;

public interface ReplayableConnection extends oracle.jdbc.replay.ReplayableConnection {
   void setReplayInitiationTimeout(int var1) throws SQLException;

   void initialize(OracleDataSource var1, String var2, String var3) throws SQLException;

   void setSessionStateConsistency(boolean var1) throws SQLException;
}
