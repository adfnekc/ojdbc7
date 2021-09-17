//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package oracle.jdbc.pool;

import java.io.Serializable;
import java.sql.SQLException;
import javax.sql.ConnectionEvent;
import javax.sql.ConnectionEventListener;
import javax.sql.PooledConnection;

/** @deprecated */
class OracleConnectionCacheEventListener implements ConnectionEventListener, Serializable {
    static final int CONNECTION_CLOSED_EVENT = 101;
    static final int CONNECTION_ERROROCCURED_EVENT = 102;
    protected OracleImplicitConnectionCache implicitCache;
    private static final String _Copyright_2007_Oracle_All_Rights_Reserved_ = null;
    public static final String BUILD_DATE = "Thu_Apr_04_15:09:24_PDT_2013";
    public static final boolean TRACE = false;

    public OracleConnectionCacheEventListener() {
        this((OracleImplicitConnectionCache)null);
    }

    public OracleConnectionCacheEventListener(OracleImplicitConnectionCache var1) {
        this.implicitCache = null;
        this.implicitCache = var1;
    }

    public void connectionClosed(ConnectionEvent var1) {
        try {
            if (this.implicitCache != null) {
                this.implicitCache.reusePooledConnection((PooledConnection)var1.getSource());
            }
        } catch (SQLException var3) {
        }

    }

    public void connectionErrorOccurred(ConnectionEvent var1) {
        try {
            if (this.implicitCache != null) {
                this.implicitCache.closePooledConnection((PooledConnection)var1.getSource());
            }
        } catch (SQLException var3) {
        }

    }
}
