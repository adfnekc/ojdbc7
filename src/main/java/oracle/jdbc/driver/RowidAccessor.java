//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package oracle.jdbc.driver;

import java.sql.SQLException;
import java.util.Map;
import oracle.sql.Datum;
import oracle.sql.ROWID;

class RowidAccessor extends Accessor {
    static final int MAXLENGTH = 4000;
    static final int EXTENDED_ROWID_MAX_LENGTH = 18;
    private static final String _Copyright_2007_Oracle_All_Rights_Reserved_ = null;
    public static final String BUILD_DATE = "Thu_Apr_04_15:09:24_PDT_2013";
    public static final boolean TRACE = false;

    RowidAccessor(OracleStatement var1, int var2, short var3, int var4, boolean var5) throws SQLException {
        super(Representation.ROWID, var1, 4000, var5);
        this.init(var1, 104, 9, var3, var5);
        this.initForDataAccess(var4, var2, (String)null);
    }

    RowidAccessor(OracleStatement var1, int var2, boolean var3, int var4, int var5, int var6, int var7, int var8, short var9) throws SQLException {
        super(Representation.ROWID, var1, 4000, false);
        this.init(var1, 104, 9, var9, false);
        this.initForDescribe(104, var2, var3, var4, var5, var6, var7, var8, var9, (String)null);
        this.initForDataAccess(0, var2, (String)null);
    }

    void initForDataAccess(int var1, int var2, String var3) throws SQLException {
        if (var1 != 0) {
            this.externalType = var1;
        }

        this.byteLength = this.representationMaxLength + 2;
    }

    String getString(int var1) throws SQLException {
        return this.isNull(var1) ? null : this.rowData.getString(this.getOffset(var1), this.getLength(var1), this.statement.connection.conversion.getCharacterSet((short)1));
    }

    Object getObject(int var1) throws SQLException {
        return this.getROWID(var1);
    }

    Datum getOracleObject(int var1) throws SQLException {
        return this.getROWID(var1);
    }

    ROWID getROWID(int var1) throws SQLException {
        byte[] var2 = this.getBytes(var1);
        return var2 == null ? null : new ROWID(var2);
    }

    Object getObject(int var1, Map var2) throws SQLException {
        return this.getROWID(var1);
    }
}
