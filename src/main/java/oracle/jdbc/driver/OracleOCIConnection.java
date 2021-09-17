//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package oracle.jdbc.driver;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Properties;
import oracle.jdbc.pool.OracleOCIConnectionPool;

public abstract class OracleOCIConnection extends T2CConnection {
    OracleOCIConnectionPool ociConnectionPool;
    boolean isPool;
    boolean aliasing;
    private static final String _Copyright_2007_Oracle_All_Rights_Reserved_ = null;
    public static final String BUILD_DATE = "Thu_Apr_04_15:09:24_PDT_2013";
    public static final boolean TRACE = false;

    public OracleOCIConnection(String var1, Properties var2, Object var3) throws SQLException {
        this(var1, var2, (OracleDriverExtension)var3);
    }

    OracleOCIConnection(String var1, Properties var2, OracleDriverExtension var3) throws SQLException {
        super(var1, var2, var3);
        this.ociConnectionPool = null;
        this.isPool = false;
        this.aliasing = false;
    }

    public synchronized byte[] getConnectionId() throws SQLException {
        byte[] var1 = this.t2cGetConnectionId(this.m_nativeState);
        if (var1 == null) {
            SQLException var2 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 254, "Cannot create a ByteArray for the connectionId");
            var2.fillInStackTrace();
            throw var2;
        } else {
            this.aliasing = true;
            return var1;
        }
    }

    public synchronized void passwordChange(String var1, String var2, String var3) throws SQLException, IOException {
        this.ociPasswordChange(var1, var2, var3);
    }

    public synchronized void close() throws SQLException {
        if (this.lifecycle != 2 && this.lifecycle != 4 && !this.aliasing) {
            super.close();
            this.ociConnectionPool.connectionClosed((oracle.jdbc.oci.OracleOCIConnection)this);
        }
    }

    public synchronized void setConnectionPool(OracleOCIConnectionPool var1) {
        this.ociConnectionPool = var1;
    }

    public synchronized void setStmtCacheSize(int var1, boolean var2) throws SQLException {
        super.setStmtCacheSize(var1, var2);
    }
}
