//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package oracle.jdbc.oracore;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.Map;
import oracle.jdbc.driver.DatabaseError;
import oracle.jdbc.internal.OracleConnection;
import oracle.sql.Datum;
import oracle.sql.NUMBER;

public class OracleTypeSINT32 extends OracleType implements Serializable {
    static final long serialVersionUID = -5465988397261455848L;
    boolean isBigEndian = false;
    private static final String _Copyright_2007_Oracle_All_Rights_Reserved_ = null;
    public static final String BUILD_DATE = "Thu_Apr_04_15:09:24_PDT_2013";
    public static final boolean TRACE = false;

    protected OracleTypeSINT32(boolean var1) {
        this.isBigEndian = var1;
    }

    public Datum toDatum(Object var1, OracleConnection var2) throws SQLException {
        return OracleTypeNUMBER.toNUMBER(var1, var2);
    }

    public Datum[] toDatumArray(Object var1, OracleConnection var2, long var3, int var5) throws SQLException {
        return OracleTypeNUMBER.toNUMBERArray(var1, var2, var3, var5);
    }

    public Datum toDatumInternal(Object var1, OracleConnection var2) throws SQLException {
        boolean var3 = false;
        if (var1 == null) {
            return null;
        } else {
            int var5;
            if (var1 instanceof Number) {
                var5 = ((Number)var1).intValue();
            } else {
                NUMBER var4;
                if (var1 instanceof NUMBER) {
                    var4 = (NUMBER)var1;
                    var5 = var4.intValue();
                } else {
                    var4 = new NUMBER(var1);
                    var5 = var4.intValue();
                }
            }

            return SINT32.valueOf(var5, this.isBigEndian);
        }
    }

    public Datum[] toDatumArrayInternal(Object var1, OracleConnection var2, long var3, int var5) throws SQLException {
        if (var1 == null) {
            return null;
        } else {
            Object[] var6 = (Object[])((Object[])var1);
            SINT32[] var7 = SINT32.createArray(var5);
            long var8 = var3 + (long)var5;

            for(int var10 = 0; var3 < var8; ++var3) {
                var7[var10] = (SINT32) this.toDatumInternal(var6[(int)var3], var2);
                ++var10;
            }

            return var7;
        }
    }

    public int getTypeCode() {
        return 2;
    }

    protected Object toObject(byte[] var1, int var2, Map var3) throws SQLException {
        if (var1 != null && var1.length != 0) {
            int var4 = SINT32.bytesToInt(var1, this.isBigEndian);
            Object var5 = null;
            switch(var2) {
                case 1:
                    var5 = new NUMBER(var4);
                    break;
                case 2:
                    var5 = new BigDecimal(var4);
                    break;
                case 3:
                    byte[] var7 = NUMBER.toBytes(var4);
                default:
                    SQLException var6 = DatabaseError.createSqlException((OracleConnection)null, 23);
                    var6.fillInStackTrace();
                    throw var6;
            }

            return var5;
        } else {
            return null;
        }
    }

    private void writeObject(ObjectOutputStream var1) throws IOException {
    }

    private void readObject(ObjectInputStream var1) throws IOException, ClassNotFoundException {
    }
}
