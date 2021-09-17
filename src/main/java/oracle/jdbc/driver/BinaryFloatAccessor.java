//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package oracle.jdbc.driver;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.SQLException;
import java.util.Map;
import oracle.sql.BINARY_FLOAT;
import oracle.sql.Datum;
import oracle.sql.NUMBER;

class BinaryFloatAccessor extends Accessor {
    static final int MAXLENGTH = 4;
    private final byte[] tmpBytes;
    private static final String _Copyright_2007_Oracle_All_Rights_Reserved_ = null;
    public static final String BUILD_DATE = "Thu_Apr_04_15:09:24_PDT_2013";
    public static final boolean TRACE = false;

    BinaryFloatAccessor(OracleStatement var1, int var2, short var3, int var4, boolean var5) throws SQLException {
        super(Representation.BINARY_FLOAT, var1, 4, var5);
        this.tmpBytes = new byte[this.representationMaxLength];
        this.init(var1, 100, 100, var3, var5);
        this.initForDataAccess(var4, var2, (String)null);
    }

    BinaryFloatAccessor(OracleStatement var1, int var2, boolean var3, int var4, int var5, int var6, int var7, int var8, short var9) throws SQLException {
        super(Representation.BINARY_FLOAT, var1, 4, false);
        this.tmpBytes = new byte[this.representationMaxLength];
        this.init(var1, 100, 100, var9, false);
        this.initForDescribe(100, var2, var3, var4, var5, var6, var7, var8, var9, (String)null);
        int var10 = var1.maxFieldSize;
        if (var10 > 0 && (var2 == 0 || var10 < var2)) {
            var2 = var10;
        }

        this.initForDataAccess(0, var2, (String)null);
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

    float getFloat(int var1) throws SQLException {
        if (this.isNull(var1)) {
            return 0.0F;
        } else {
            this.rowData.get(this.getOffset(var1), this.tmpBytes, 0, this.representationMaxLength);
            byte var2 = this.tmpBytes[0];
            byte var3 = this.tmpBytes[1];
            byte var4 = this.tmpBytes[2];
            byte var5 = this.tmpBytes[3];
            int var7;
            int var8;
            int var9;
            int var10;
            if ((var2 & 128) != 0) {
                var7 = var2 & 127;
                var8 = var3 & 255;
                var9 = var4 & 255;
                var10 = var5 & 255;
            } else {
                var7 = ~var2 & 255;
                var8 = ~var3 & 255;
                var9 = ~var4 & 255;
                var10 = ~var5 & 255;
            }

            int var6 = var7 << 24 | var8 << 16 | var9 << 8 | var10;
            return Float.intBitsToFloat(var6);
        }
    }

    String getString(int var1) throws SQLException {
        return this.isNull(var1) ? null : Float.toString(this.getFloat(var1));
    }

    Object getObject(int var1) throws SQLException {
        return this.isNull(var1) ? null : new Float(this.getFloat(var1));
    }

    Object getObject(int var1, Map var2) throws SQLException {
        return this.isNull(var1) ? null : new Float(this.getFloat(var1));
    }

    Datum getOracleObject(int var1) throws SQLException {
        return this.getBINARY_FLOAT(var1);
    }

    BINARY_FLOAT getBINARY_FLOAT(int var1) throws SQLException {
        return this.isNull(var1) ? null : new BINARY_FLOAT(this.rowData.get(this.getOffset(var1), this.getLength(var1)));
    }

    NUMBER getNUMBER(int var1) throws SQLException {
        return this.isNull(var1) ? null : new NUMBER(this.getFloat(var1));
    }

    BigInteger getBigInteger(int var1) throws SQLException {
        return this.isNull(var1) ? null : new BigInteger(this.getString(var1));
    }

    BigDecimal getBigDecimal(int var1) throws SQLException {
        return this.isNull(var1) ? null : new BigDecimal(this.getString(var1));
    }

    byte getByte(int var1) throws SQLException {
        return (byte)((int)this.getFloat(var1));
    }

    short getShort(int var1) throws SQLException {
        return (short)((int)this.getFloat(var1));
    }

    int getInt(int var1) throws SQLException {
        return (int)this.getFloat(var1);
    }

    long getLong(int var1) throws SQLException {
        return (long)this.getFloat(var1);
    }

    double getDouble(int var1) throws SQLException {
        return (double)this.getFloat(var1);
    }
}
