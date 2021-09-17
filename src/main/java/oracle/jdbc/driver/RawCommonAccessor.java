//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package oracle.jdbc.driver;

import java.io.ByteArrayInputStream;
import java.io.CharArrayReader;
import java.io.InputStream;
import java.io.Reader;
import java.sql.SQLException;
import java.util.Map;
import oracle.jdbc.util.RepConversion;
import oracle.sql.Datum;
import oracle.sql.RAW;

class RawCommonAccessor extends Accessor {
    private static final String _Copyright_2007_Oracle_All_Rights_Reserved_ = null;
    public static final String BUILD_DATE = "Thu_Apr_04_15:09:24_PDT_2013";
    public static final boolean TRACE = false;

    RawCommonAccessor(OracleStatement var1, int var2, boolean var3) {
        super(Representation.RAW, var1, var2, var3);
    }

    void init(OracleStatement var1, int var2, int var3, int var4, short var5, int var6) throws SQLException {
        this.init(var1, var2, var3, var5, false);
        this.initForDataAccess(var6, var4, (String)null);
    }

    void init(OracleStatement var1, int var2, int var3, int var4, boolean var5, int var6, int var7, int var8, int var9, int var10, short var11) throws SQLException {
        this.init(var1, var2, var3, var11, false);
        this.initForDescribe(var2, var4, var5, var6, var7, var8, var9, var10, var11, (String)null);
        int var12 = var1.maxFieldSize;
        if (var12 > 0 && (var4 == 0 || var12 < var4)) {
            var4 = var12;
        }

        this.initForDataAccess(0, var4, (String)null);
    }

    String getString(int var1) throws SQLException {
        byte[] var2 = this.getBytes(var1);
        if (var2 == null) {
            return null;
        } else {
            int var3 = var2.length;
            return var3 == 0 ? null : RepConversion.bArray2String(var2);
        }
    }

    InputStream getAsciiStream(int var1) throws SQLException {
        byte[] var2 = this.getBytes(var1);
        if (var2 == null) {
            return null;
        } else {
            PhysicalConnection var3 = this.statement.connection;
            return var3.conversion.ConvertStream(new ByteArrayInputStream(var2), 2);
        }
    }

    InputStream getUnicodeStream(int var1) throws SQLException {
        byte[] var2 = this.getBytes(var1);
        if (var2 == null) {
            return null;
        } else {
            PhysicalConnection var3 = this.statement.connection;
            return var3.conversion.ConvertStream(new ByteArrayInputStream(var2), 3);
        }
    }

    Reader getCharacterStream(int var1) throws SQLException {
        byte[] var2 = this.getBytes(var1);
        if (var2 == null) {
            return null;
        } else {
            int var3 = var2.length;
            char[] var4 = new char[var3 << 1];
            DBConversion var10000 = this.statement.connection.conversion;
            int var5 = DBConversion.RAWBytesToHexChars(var2, var3, var4);
            return new CharArrayReader(var4, 0, var5);
        }
    }

    InputStream getBinaryStream(int var1) throws SQLException {
        byte[] var2 = this.getBytes(var1);
        return var2 == null ? null : new ByteArrayInputStream(var2);
    }

    Object getObject(int var1) throws SQLException {
        return this.getBytes(var1);
    }

    Object getObject(int var1, Map var2) throws SQLException {
        return this.getBytes(var1);
    }

    Datum getOracleObject(int var1) throws SQLException {
        return this.getRAW(var1);
    }

    RAW getRAW(int var1) throws SQLException {
        byte[] var2 = this.getBytes(var1);
        return var2 == null ? null : new RAW(var2);
    }
}
