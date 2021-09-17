package oracle.jdbc.replay;

import java.sql.SQLException;

public interface ReplayableConnection {
   void beginRequest() throws SQLException;

   void endRequest() throws SQLException;

   void disableReplay() throws SQLException;
}
