//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package oracle.jdbc.pool;

/** @deprecated */
class OracleDatabaseInstance {
    String databaseUniqName = null;
    String instanceName = null;
    int percent = 0;
    int flag = 0;
    int attemptedConnRequestCount = 0;
    int numberOfConnectionsCount = 0;
    private static final String _Copyright_2007_Oracle_All_Rights_Reserved_ = null;
    public static final String BUILD_DATE = "Thu_Apr_04_15:09:24_PDT_2013";
    public static final boolean TRACE = false;

    OracleDatabaseInstance(String var1, String var2) {
        this.databaseUniqName = var1;
        this.instanceName = var2;
    }
}
