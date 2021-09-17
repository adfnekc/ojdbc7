//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package oracle.jdbc.pool;

import java.sql.SQLException;

/** @deprecated */
class OracleGravitateConnectionCacheThread extends Thread {
    protected OracleImplicitConnectionCache implicitCache = null;
    private static final String _Copyright_2007_Oracle_All_Rights_Reserved_ = null;
    public static final String BUILD_DATE = "Thu_Apr_04_15:09:24_PDT_2013";
    public static final boolean TRACE = false;

    OracleGravitateConnectionCacheThread(OracleImplicitConnectionCache var1) throws SQLException {
        this.implicitCache = var1;
    }

    public void run() {
        this.implicitCache.gravitateCache();
    }
}
