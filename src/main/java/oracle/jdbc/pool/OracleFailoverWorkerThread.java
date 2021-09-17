//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package oracle.jdbc.pool;

import java.sql.SQLException;

/** @deprecated */
class OracleFailoverWorkerThread extends Thread {
    protected OracleImplicitConnectionCache implicitCache = null;
    protected int eventType = 0;
    protected String eventServiceName = null;
    protected String instanceNameKey = null;
    protected String databaseNameKey = null;
    protected String hostNameKey = null;
    protected String status = null;
    protected int cardinality = 0;
    private static final String _Copyright_2007_Oracle_All_Rights_Reserved_ = null;
    public static final String BUILD_DATE = "Thu_Apr_04_15:09:24_PDT_2013";
    public static final boolean TRACE = false;

    OracleFailoverWorkerThread(OracleImplicitConnectionCache var1, int var2, String var3, String var4, String var5, String var6, int var7) throws SQLException {
        this.implicitCache = var1;
        this.eventType = var2;
        this.instanceNameKey = var3;
        this.databaseNameKey = var4;
        this.hostNameKey = var5;
        this.status = var6;
        this.cardinality = var7;
    }

    public void run() {
        try {
            if (this.status != null) {
                this.implicitCache.processFailoverEvent(this.eventType, this.instanceNameKey, this.databaseNameKey, this.hostNameKey, this.status, this.cardinality);
            }
        } catch (Exception var2) {
        }

    }
}
