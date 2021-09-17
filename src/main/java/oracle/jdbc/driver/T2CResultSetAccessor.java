//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package oracle.jdbc.driver;

import java.sql.SQLException;

class T2CResultSetAccessor extends ResultSetAccessor {
    private static final String _Copyright_2007_Oracle_All_Rights_Reserved_ = null;
    public static final String BUILD_DATE = "Thu_Apr_04_15:09:24_PDT_2013";
    public static final boolean TRACE = false;

    T2CResultSetAccessor(OracleStatement var1, int var2, short var3, int var4, boolean var5) throws SQLException {
        super(var1, var2 * 2, var3, var4, var5);
    }

    T2CResultSetAccessor(OracleStatement var1, int var2, boolean var3, int var4, int var5, int var6, int var7, int var8, short var9) throws SQLException {
        super(var1, var2 * 2, var3, var4, var5, var6, var7, var8, var9);
    }

    byte[] getBytes(int var1) throws SQLException {
        Object var2 = null;
        if (this.isNull(var1)) {
            return null;
        } else {
            int var3 = this.getLength(var1);
            byte var4 = ((T2CConnection)this.statement.connection).byteAlign;
            long var5 = this.getOffset(var1) + (long)(var4 - 1) & (long)(~(var4 - 1));
            this.rowData.setPosition(var5);
            byte[] var7 = this.rowData.getBytes(var3);
            return var7;
        }
    }
}
