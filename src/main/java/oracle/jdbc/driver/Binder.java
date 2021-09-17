//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package oracle.jdbc.driver;

import java.sql.SQLException;
import oracle.jdbc.internal.OracleConnection;

abstract class Binder {
    short type;
    int bytelen;
    private static final String _Copyright_2007_Oracle_All_Rights_Reserved_ = null;
    public static final String BUILD_DATE = "Thu_Apr_04_15:09:24_PDT_2013";
    public static final boolean TRACE = false;

    Binder() {
    }

    abstract Binder copyingBinder();

    abstract long bind(OraclePreparedStatement var1, int var2, int var3, int var4, byte[] var5, char[] var6, short[] var7, int var8, int var9, int var10, int var11, int var12, int var13, boolean var14, long var15) throws SQLException;

    public String toString() {
        return this.getClass() + " [type = " + this.type + ", bytelen = " + this.bytelen + "]";
    }

    protected OracleConnection getConnectionDuringExceptionHandling() {
        return null;
    }

    short updateInoutIndicatorValue(short var1) {
        return var1;
    }

    void lastBoundValueCleanup(OraclePreparedStatement var1, int var2) {
    }
}
