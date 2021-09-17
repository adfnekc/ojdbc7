//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package oracle.jdbc.driver;

import java.sql.SQLException;

class OutRawAccessor extends RawCommonAccessor {
    static final int MAXLENGTH = 32767;
    private static final String _Copyright_2007_Oracle_All_Rights_Reserved_ = null;
    public static final String BUILD_DATE = "Thu_Apr_04_15:09:24_PDT_2013";
    public static final boolean TRACE = false;

    OutRawAccessor(OracleStatement var1, int var2, short var3, int var4) throws SQLException {
        super(var1, 32767, true);
        this.init(var1, 23, 23, var3, true);
        this.initForDataAccess(var4, var2, (String)null);
    }
}
