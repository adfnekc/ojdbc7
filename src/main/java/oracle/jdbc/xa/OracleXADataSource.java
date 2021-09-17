//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package oracle.jdbc.xa;

import java.sql.SQLException;
import java.util.Properties;
import javax.sql.XAConnection;
import javax.sql.XADataSource;
import oracle.jdbc.internal.OracleConnection;
import oracle.jdbc.pool.OracleConnectionPoolDataSource;
import oracle.jdbc.pool.OracleDataSource;

public abstract class OracleXADataSource extends OracleConnectionPoolDataSource implements XADataSource {
    protected boolean useNativeXA = false;
    private static final String _Copyright_2007_Oracle_All_Rights_Reserved_ = null;
    public static final String BUILD_DATE = "Thu_Apr_04_15:09:24_PDT_2013";
    public static final boolean TRACE = false;

    public OracleXADataSource() throws SQLException {
        this.dataSourceName = "OracleXADataSource";
    }

    public abstract XAConnection getXAConnection() throws SQLException;

    public abstract XAConnection getXAConnection(String var1, String var2) throws SQLException;

    public abstract XAConnection getXAConnection(Properties var1) throws SQLException;

    public synchronized void setURL(String var1) {
        super.setURL(var1);
        if (var1 != null) {
            if (var1.startsWith("jdbc:oracle:thin")) {
                this.useNativeXA = true;
            } else if (var1.startsWith("jdbc:oracle:oci") || var1.startsWith("jdbc:oracle:oci8")) {
                this.useNativeXA = false;
            }
        }

    }

    public synchronized void setNativeXA(boolean var1) {
        this.useNativeXA = var1;
    }

    public synchronized boolean getNativeXA() {
        return this.useNativeXA;
    }

    protected void copy(OracleDataSource var1) throws SQLException {
        super.copy(var1);
        ((OracleXADataSource)var1).useNativeXA = this.useNativeXA;
    }

    protected OracleConnection getConnectionDuringExceptionHandling() {
        return null;
    }
}
