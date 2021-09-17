//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package oracle.jdbc.pool;

import java.sql.SQLException;
import javax.sql.DataSource;
import javax.sql.PooledConnection;

public interface OracleConnectionCache extends DataSource {
    void reusePooledConnection(PooledConnection var1) throws SQLException;

    void closePooledConnection(PooledConnection var1) throws SQLException;

    void close() throws SQLException;
}
