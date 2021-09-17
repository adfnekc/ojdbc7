//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package oracle.jdbc.oracore;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.Map;
import oracle.jdbc.driver.DatabaseError;
import oracle.jdbc.internal.OracleConnection;
import oracle.sql.BINARY_FLOAT;
import oracle.sql.Datum;

public class OracleTypeBINARY_FLOAT extends OracleType implements Serializable {
    private static final String _Copyright_2007_Oracle_All_Rights_Reserved_ = null;
    public static final String BUILD_DATE = "Thu_Apr_04_15:09:24_PDT_2013";
    public static final boolean TRACE = false;

    protected OracleTypeBINARY_FLOAT() {
    }

    public Datum toDatum(Object var1, OracleConnection var2) throws SQLException {
        BINARY_FLOAT var3 = null;
        if (var1 != null) {
            if (var1 instanceof BINARY_FLOAT) {
                var3 = (BINARY_FLOAT)var1;
            } else if (var1 instanceof Float) {
                var3 = new BINARY_FLOAT((Float)var1);
            } else {
                if (!(var1 instanceof byte[])) {
                    SQLException var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 59, var1);
                    var4.fillInStackTrace();
                    throw var4;
                }

                var3 = new BINARY_FLOAT((byte[])((byte[])var1));
            }
        }

        return var3;
    }

    public Datum[] toDatumArray(Object var1, OracleConnection var2, long var3, int var5) throws SQLException {
        Datum[] var6 = null;
        if (var1 != null && var1 instanceof Object[]) {
            Object[] var7 = (Object[])((Object[])var1);
            int var8 = (int)(var5 == -1 ? (long)var7.length : Math.min((long)var7.length - var3 + 1L, (long)var5));
            var6 = new Datum[var8];

            for(int var9 = 0; var9 < var8; ++var9) {
                Object var10 = var7[(int)var3 + var9 - 1];
                if (var10 != null) {
                    if (var10 instanceof Float) {
                        var6[var9] = new BINARY_FLOAT((Float)var10);
                    } else {
                        if (!(var10 instanceof BINARY_FLOAT)) {
                            SQLException var11 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 68);
                            var11.fillInStackTrace();
                            throw var11;
                        }

                        var6[var9] = (BINARY_FLOAT)var10;
                    }
                } else {
                    var6[var9] = null;
                }
            }
        }

        return var6;
    }

    public int getTypeCode() {
        return 100;
    }

    protected Object toObject(byte[] var1, int var2, Map var3) throws SQLException {
        if (var1 != null && var1.length != 0) {
            if (var2 == 1) {
                return new BINARY_FLOAT(var1);
            } else if (var2 == 2) {
                return (new BINARY_FLOAT(var1)).toJdbc();
            } else if (var2 == 3) {
                return var1;
            } else {
                SQLException var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 59, var1);
                var4.fillInStackTrace();
                throw var4;
            }
        } else {
            return null;
        }
    }
}
