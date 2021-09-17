//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package oracle.jdbc.driver;

import java.sql.SQLException;
import oracle.jdbc.internal.OracleStatement.SqlKind;

class RawAccessor extends RawCommonAccessor {
    private static final String _Copyright_2007_Oracle_All_Rights_Reserved_ = null;
    public static final String BUILD_DATE = "Thu_Apr_04_15:09:24_PDT_2013";
    public static final boolean TRACE = false;

    RawAccessor(OracleStatement var1, int var2, short var3, int var4, boolean var5) throws SQLException {
        super(var1, var1.sqlKind == SqlKind.PLSQL_BLOCK ? Math.max(var1.connection.maxRawBytesPlsql, var2) : var1.connection.maxRawLength, var5);
        this.init(var1, 23, 15, var3, var5);
        this.initForDataAccess(var4, var2, (String)null);
    }

    RawAccessor(OracleStatement var1, int var2, boolean var3, int var4, int var5, int var6, int var7, int var8, short var9) throws SQLException {
        super(var1, var1.sqlKind == SqlKind.PLSQL_BLOCK ? var1.connection.maxRawBytesPlsql : var1.connection.maxRawLength, false);
        this.init(var1, 23, 15, var9, false);
        this.initForDescribe(23, var2, var3, var4, var5, var6, var7, var8, var9, (String)null);
        int var10 = var1.maxFieldSize;
        if (var10 > 0 && (var2 == 0 || var10 < var2)) {
            var2 = var10;
        }

        this.initForDataAccess(0, var2, (String)null);
    }

    void initForDataAccess(int var1, int var2, String var3) throws SQLException {
        super.initForDataAccess(var1, var2, var3);
        this.byteLength += 2;
    }
}
