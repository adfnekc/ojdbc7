//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package oracle.jdbc.pool;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;
import javax.sql.ConnectionPoolDataSource;
import javax.sql.PooledConnection;
import oracle.jdbc.internal.OracleConnection;

public class OracleConnectionPoolDataSource extends OracleDataSource implements ConnectionPoolDataSource {
    private static final String _Copyright_2007_Oracle_All_Rights_Reserved_ = null;
    public static final String BUILD_DATE = "Thu_Apr_04_15:09:24_PDT_2013";
    public static final boolean TRACE = false;

    public OracleConnectionPoolDataSource() throws SQLException {
        this.dataSourceName = "OracleConnectionPoolDataSource";
        this.isOracleDataSource = false;
        this.connCachingEnabled = false;
        this.fastConnFailover = false;
    }

    public PooledConnection getPooledConnection() throws SQLException {
        String var1 = null;
        String var2 = null;
        synchronized(this) {
            var1 = this.user;
            var2 = this.password;
        }

        return this.getPooledConnection(var1, var2);
    }

    public PooledConnection getPooledConnection(String var1, String var2) throws SQLException {
        Connection var3 = this.getPhysicalConnection(var1, var2);
        OraclePooledConnection var4 = new OraclePooledConnection(var3);
        if (var2 == null) {
            var2 = this.password;
        }

        var4.setUserName(!var1.startsWith("\"") ? var1.toLowerCase() : var1, var2);
        return var4;
    }

    PooledConnection getPooledConnection(Properties var1) throws SQLException {
        Connection var2 = this.getPhysicalConnection(var1);
        OraclePooledConnection var3 = new OraclePooledConnection(var2);
        String var4 = var1.getProperty("user");
        if (var4 == null) {
            var4 = ((OracleConnection)var2).getUserName();
        }

        String var5 = var1.getProperty("password");
        if (var5 == null) {
            var5 = this.password;
        }

        var3.setUserName(!var4.startsWith("\"") ? var4.toLowerCase() : var4, var5);
        return var3;
    }

    protected Connection getPhysicalConnection() throws SQLException {
        return super.getConnection(this.user, this.password);
    }

    protected Connection getPhysicalConnection(String var1, String var2, String var3) throws SQLException {
        this.url = var1;
        return super.getConnection(var2, var3);
    }

    protected Connection getPhysicalConnection(String var1, String var2) throws SQLException {
        return super.getConnection(var1, var2);
    }
}
