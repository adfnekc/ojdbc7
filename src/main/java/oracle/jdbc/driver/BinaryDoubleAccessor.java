//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package oracle.jdbc.driver;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.SQLException;
import java.util.Map;
import oracle.sql.BINARY_DOUBLE;
import oracle.sql.Datum;
import oracle.sql.NUMBER;

class BinaryDoubleAccessor extends Accessor {
    static final int MAXLENGTH = 8;
    private final byte[] tmpBytes;
    private static final String _Copyright_2007_Oracle_All_Rights_Reserved_ = null;
    public static final String BUILD_DATE = "Thu_Apr_04_15:09:24_PDT_2013";
    public static final boolean TRACE = false;

    BinaryDoubleAccessor(OracleStatement var1, int var2, short var3, int var4, boolean var5) throws SQLException {
        super(Representation.BINARY_DOUBLE, var1, 8, var5);
        this.tmpBytes = new byte[this.representationMaxLength];
        this.init(var1, 101, 101, var3, var5);
        this.initForDataAccess(var4, var2, (String)null);
    }

    BinaryDoubleAccessor(OracleStatement var1, int var2, boolean var3, int var4, int var5, int var6, int var7, int var8, short var9) throws SQLException {
        super(Representation.BINARY_DOUBLE, var1, 8, false);
        this.tmpBytes = new byte[this.representationMaxLength];
        this.init(var1, 101, 101, var9, false);
        this.initForDescribe(101, var2, var3, var4, var5, var6, var7, var8, var9, (String)null);
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

    double getDouble(int var1) throws SQLException {
        if (this.isNull(var1)) {
            return 0.0D;
        } else {
            this.rowData.get(this.getOffset(var1), this.tmpBytes, 0, this.representationMaxLength);
            byte var2 = this.tmpBytes[0];
            byte var3 = this.tmpBytes[1];
            byte var4 = this.tmpBytes[2];
            byte var5 = this.tmpBytes[3];
            byte var6 = this.tmpBytes[4];
            byte var7 = this.tmpBytes[5];
            byte var8 = this.tmpBytes[6];
            byte var9 = this.tmpBytes[7];
            int var14;
            int var15;
            int var16;
            int var17;
            int var18;
            int var19;
            int var20;
            int var21;
            if ((var2 & 128) != 0) {
                var14 = var2 & 127;
                var15 = var3 & 255;
                var16 = var4 & 255;
                var17 = var5 & 255;
                var18 = var6 & 255;
                var19 = var7 & 255;
                var20 = var8 & 255;
                var21 = var9 & 255;
            } else {
                var14 = ~var2 & 255;
                var15 = ~var3 & 255;
                var16 = ~var4 & 255;
                var17 = ~var5 & 255;
                var18 = ~var6 & 255;
                var19 = ~var7 & 255;
                var20 = ~var8 & 255;
                var21 = ~var9 & 255;
            }

            int var10 = var14 << 24 | var15 << 16 | var16 << 8 | var17;
            int var11 = var18 << 24 | var19 << 16 | var20 << 8 | var21;
            long var12 = (long)var10 << 32 | (long)var11 & 4294967295L;
            return Double.longBitsToDouble(var12);
        }
    }

    String getString(int var1) throws SQLException {
        return this.isNull(var1) ? null : Double.toString(this.getDouble(var1));
    }

    Object getObject(int var1) throws SQLException {
        return this.isNull(var1) ? null : new Double(this.getDouble(var1));
    }

    Object getObject(int var1, Map var2) throws SQLException {
        return new Double(this.getDouble(var1));
    }

    Datum getOracleObject(int var1) throws SQLException {
        return this.getBINARY_DOUBLE(var1);
    }

    BINARY_DOUBLE getBINARY_DOUBLE(int var1) throws SQLException {
        return this.isNull(var1) ? null : new BINARY_DOUBLE(this.rowData.get(this.getOffset(var1), this.getLength(var1)));
    }

    NUMBER getNUMBER(int var1) throws SQLException {
        return this.isNull(var1) ? null : new NUMBER(this.getDouble(var1));
    }

    BigInteger getBigInteger(int var1) throws SQLException {
        return this.isNull(var1) ? null : new BigInteger(this.getString(var1));
    }

    BigDecimal getBigDecimal(int var1) throws SQLException {
        return this.isNull(var1) ? null : new BigDecimal(this.getString(var1));
    }

    byte getByte(int var1) throws SQLException {
        return (byte)((int)this.getDouble(var1));
    }

    short getShort(int var1) throws SQLException {
        return (short)((int)this.getDouble(var1));
    }

    int getInt(int var1) throws SQLException {
        return (int)this.getDouble(var1);
    }

    long getLong(int var1) throws SQLException {
        return (long)this.getDouble(var1);
    }

    float getFloat(int var1) throws SQLException {
        return (float)this.getDouble(var1);
    }
}
