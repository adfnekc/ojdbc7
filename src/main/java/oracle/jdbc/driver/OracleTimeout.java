//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package oracle.jdbc.driver;

import java.sql.SQLException;

abstract class OracleTimeout {
    private static final String _Copyright_2007_Oracle_All_Rights_Reserved_ = null;
    public static final String BUILD_DATE = "Thu_Apr_04_15:09:24_PDT_2013";
    public static final boolean TRACE = false;

    OracleTimeout() {
    }

    static OracleTimeout newTimeout(String var0) throws SQLException {
        OracleTimeoutThreadPerVM var1 = new OracleTimeoutThreadPerVM(var0);
        return var1;
    }

    abstract void setTimeout(long var1, OracleStatement var3) throws SQLException;

    abstract void cancelTimeout() throws SQLException;

    abstract void close() throws SQLException;
}
