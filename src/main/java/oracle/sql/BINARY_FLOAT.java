//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package oracle.sql;

import java.math.BigDecimal;
import java.sql.SQLException;
import oracle.jdbc.driver.DatabaseError;
import oracle.jdbc.internal.OracleConnection;

public class BINARY_FLOAT extends Datum {
    static final long serialVersionUID = -4231112037190700631L;
    private static final String _Copyright_2007_Oracle_All_Rights_Reserved_ = null;
    public static final String BUILD_DATE = "Thu_Apr_04_15:09:24_PDT_2013";
    public static final boolean TRACE = false;

    public BINARY_FLOAT() {
    }

    public BINARY_FLOAT(byte[] var1) {
        super(var1);
    }

    public BINARY_FLOAT(float var1) {
        super(floatToCanonicalFormatBytes(var1));
    }

    public BINARY_FLOAT(Float var1) {
        super(floatToCanonicalFormatBytes(var1));
    }

    public BINARY_FLOAT(String var1) throws SQLException {
        this(stringToFloat(var1));
    }

    public BINARY_FLOAT(Boolean var1) {
        this((float)(var1 ? 1 : 0));
    }

    public Object toJdbc() throws SQLException {
        return new Float(canonicalFormatBytesToFloat(this.getBytes()));
    }

    public boolean isConvertibleTo(Class var1) {
        String var2 = var1.getName();
        return var2.compareTo("java.lang.String") == 0 || var2.compareTo("java.lang.Float") == 0;
    }

    public String stringValue() {
        String var1 = Float.toString(canonicalFormatBytesToFloat(this.getBytes()));
        return var1;
    }

    public float floatValue() throws SQLException {
        return canonicalFormatBytesToFloat(this.getBytes());
    }

    public double doubleValue() throws SQLException {
        return (double)this.floatValue();
    }

    public BigDecimal bigDecimalValue() throws SQLException {
        return new BigDecimal((double)this.floatValue());
    }

    private static float stringToFloat(String var0) throws SQLException {
        try {
            return Float.valueOf(var0);
        } catch (NumberFormatException var3) {
            SQLException var2 = DatabaseError.createSqlException((OracleConnection)null, 59);
            var2.fillInStackTrace();
            throw var2;
        }
    }

    public Object makeJdbcArray(int var1) {
        return new Float[var1];
    }

    static byte[] floatToCanonicalFormatBytes(float var0) {
        float var1 = var0;
        if (var0 == 0.0F) {
            var1 = 0.0F;
        } else if (var0 != var0) {
            var1 = (float) (0.0F / 0.0);
        }

        int var2 = Float.floatToIntBits(var1);
        byte[] var3 = new byte[4];
        int var4 = var2;
        var2 >>= 8;
        int var5 = var2;
        var2 >>= 8;
        int var6 = var2;
        var2 >>= 8;
        int var7;
        if ((var2 & 128) == 0) {
            var7 = var2 | 128;
        } else {
            var7 = ~var2;
            var6 = ~var6;
            var5 = ~var5;
            var4 = ~var4;
        }

        var3[3] = (byte)var4;
        var3[2] = (byte)var5;
        var3[1] = (byte)var6;
        var3[0] = (byte)var7;
        return var3;
    }

    static float canonicalFormatBytesToFloat(byte[] var0) {
        byte var1 = var0[0];
        byte var2 = var0[1];
        byte var3 = var0[2];
        byte var4 = var0[3];
        int var6;
        int var7;
        int var8;
        int var9;
        if ((var1 & 128) != 0) {
            var6 = var1 & 127;
            var7 = var2 & 255;
            var8 = var3 & 255;
            var9 = var4 & 255;
        } else {
            var6 = ~var1 & 255;
            var7 = ~var2 & 255;
            var8 = ~var3 & 255;
            var9 = ~var4 & 255;
        }

        int var5 = var6 << 24 | var7 << 16 | var8 << 8 | var9;
        return Float.intBitsToFloat(var5);
    }
}
