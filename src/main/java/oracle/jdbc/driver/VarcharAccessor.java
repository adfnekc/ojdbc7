//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package oracle.jdbc.driver;

import java.sql.SQLException;
import oracle.jdbc.internal.OracleStatement.SqlKind;

class VarcharAccessor extends CharCommonAccessor {
    private static final String _Copyright_2007_Oracle_All_Rights_Reserved_ = null;
    public static final String BUILD_DATE = "Thu_Apr_04_15:09:24_PDT_2013";
    public static final boolean TRACE = false;

    VarcharAccessor(OracleStatement var1, int var2, short var3, int var4, boolean var5) throws SQLException {
        super(var1, var1.connection.getMaxSizeForVarchar(var1.sqlKind, var2, var1.connection.plsqlVarcharParameter4KOnly), var3, var5);
        this.init(var1, 1, 9, var2, var3, var4, var5, this.representationMaxLength);
    }

    VarcharAccessor(OracleStatement var1, int var2, boolean var3, int var4, int var5, int var6, int var7, int var8, short var9) throws SQLException {
        super(var1, var1.sqlKind == SqlKind.PLSQL_BLOCK ? var1.connection.maxVcsBytesPlsql : var1.connection.maxVarcharLength, var9, false);
        this.init(var1, 1, 9, var2, var3, var4, var5, var6, var7, var8, var9, this.representationMaxLength);
    }

    VarcharAccessor(OracleStatement var1, int var2, boolean var3, int var4, int var5, int var6, int var7, int var8, short var9, int var10) throws SQLException {
        this(var1, var2, var3, var4, var5, var6, var7, var8, var9);
        this.describeMaxLengthChars = var10;
    }
}
