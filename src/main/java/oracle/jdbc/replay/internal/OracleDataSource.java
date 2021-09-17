package oracle.jdbc.replay.internal;

import java.sql.Connection;
import java.sql.SQLException;

public interface OracleDataSource extends oracle.jdbc.replay.OracleDataSource {
   Connection getConnectionNoProxy(String var1, String var2) throws SQLException;
}
