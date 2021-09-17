//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package oracle.jdbc.driver;

import java.sql.SQLException;
import oracle.sql.CharacterSet;

class T2CVarcharAccessor extends VarcharAccessor {
    private static final String _Copyright_2007_Oracle_All_Rights_Reserved_ = null;
    public static final String BUILD_DATE = "Thu_Apr_04_15:09:24_PDT_2013";
    public static final boolean TRACE = false;

    T2CVarcharAccessor(OracleStatement var1, int var2, short var3, int var4, boolean var5) throws SQLException {
        super(var1, var2, var3, var4, var5);
    }

    byte[] getBytesInternal(int var1) throws SQLException {
        if (this.formOfUse == 2) {
            assert !this.isNull(var1);

            CharacterSet var2 = this.statement.connection.conversion.getCharacterSet(this.formOfUse);
            String var3 = this.rowData.getString(this.getOffset(var1), this.getLength(var1), var2);
            return DBConversion.stringToDriverCharBytes(var3, (short)var2.getOracleId());
        } else {
            return super.getBytesInternal(var1);
        }
    }
}
