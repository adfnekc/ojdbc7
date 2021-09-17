//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package oracle.jdbc.xa.client;

import java.sql.SQLException;
import oracle.jdbc.driver.DatabaseError;
import oracle.jdbc.driver.OracleCloseCallback;
import oracle.jdbc.internal.OracleConnection;

public class OracleXAHeteroCloseCallback implements OracleCloseCallback {
    private static final String _Copyright_2007_Oracle_All_Rights_Reserved_ = null;
    public static final String BUILD_DATE = "Thu_Apr_04_15:09:24_PDT_2013";
    public static final boolean TRACE = false;

    public OracleXAHeteroCloseCallback() {
    }

    public synchronized void beforeClose(OracleConnection var1, Object var2) {
    }

    public synchronized void afterClose(Object var1) {
        int var2 = ((OracleXAHeteroConnection)var1).getRmid();
        String var3 = ((OracleXAHeteroConnection)var1).getXaCloseString();

        try {
            int var4 = this.t2cDoXaClose(var3, var2, 0, 0);
            if (var4 != 0) {
                SQLException var5 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), -1 * var4);
                var5.fillInStackTrace();
                throw var5;
            }
        } catch (SQLException var6) {
        }

    }

    protected OracleConnection getConnectionDuringExceptionHandling() {
        return null;
    }

    private native int t2cDoXaClose(String var1, int var2, int var3, int var4);
}
