//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package oracle.jdbc.oracore;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.Map;
import oracle.jdbc.driver.DatabaseError;
import oracle.jdbc.internal.OracleConnection;
import oracle.sql.Datum;
import oracle.sql.NUMBER;

public class OracleTypeNUMBER extends OracleType implements Serializable {
    static final long serialVersionUID = -7182242886677299812L;
    int precision;
    int scale;
    private static final String _Copyright_2007_Oracle_All_Rights_Reserved_ = null;
    public static final String BUILD_DATE = "Thu_Apr_04_15:09:24_PDT_2013";
    public static final boolean TRACE = false;

    protected OracleTypeNUMBER() {
    }

    protected OracleTypeNUMBER(int var1) {
        super(var1);
    }

    public Datum toDatum(Object var1, OracleConnection var2) throws SQLException {
        return toNUMBER(var1, var2);
    }

    public Datum[] toDatumArray(Object var1, OracleConnection var2, long var3, int var5) throws SQLException {
        return toNUMBERArray(var1, var2, var3, var5);
    }

    public void parseTDSrec(TDSReader var1) throws SQLException {
        this.precision = var1.readUnsignedByte();
        this.scale = var1.readByte();
    }

    protected static Object unpickle81NativeArray(PickleContext var0, long var1, int var3, int var4) throws SQLException {
        for(int var5 = 1; (long)var5 < var1 && var3 > 0; ++var5) {
            var0.skipDataValue();
        }

        Object var8 = null;
        int var7;
        byte[] var9;
        switch(var4) {
            case 4:
                int[] var13 = new int[var3];

                for(var7 = 0; var7 < var3; ++var7) {
                    if ((var9 = var0.readDataValue()) != null) {
                        var13[var7] = NUMBER.toInt(var9);
                    }
                }

                return var13;
            case 5:
                double[] var12 = new double[var3];

                for(var7 = 0; var7 < var3; ++var7) {
                    if ((var9 = var0.readDataValue()) != null) {
                        var12[var7] = NUMBER.toDouble(var9);
                    }
                }

                return var12;
            case 6:
                float[] var11 = new float[var3];

                for(var7 = 0; var7 < var3; ++var7) {
                    if ((var9 = var0.readDataValue()) != null) {
                        var11[var7] = NUMBER.toFloat(var9);
                    }
                }

                return var11;
            case 7:
                long[] var10 = new long[var3];

                for(var7 = 0; var7 < var3; ++var7) {
                    if ((var9 = var0.readDataValue()) != null) {
                        var10[var7] = NUMBER.toLong(var9);
                    }
                }

                return var10;
            case 8:
                short[] var6 = new short[var3];

                for(var7 = 0; var7 < var3; ++var7) {
                    if ((var9 = var0.readDataValue()) != null) {
                        var6[var7] = NUMBER.toShort(var9);
                    }
                }

                return var6;
            default:
                SQLException var14 = DatabaseError.createSqlException((OracleConnection)null, 23);
                var14.fillInStackTrace();
                throw var14;
        }
    }

    protected Object toObject(byte[] var1, int var2, Map var3) throws SQLException {
        return toNumericObject(var1, var2, var3);
    }

    static Object toNumericObject(byte[] var0, int var1, Map var2) throws SQLException {
        if (var0 != null && var0.length != 0) {
            switch(var1) {
                case 1:
                    return new NUMBER(var0);
                case 2:
                    return NUMBER.toBigDecimal(var0);
                case 3:
                    return var0;
                default:
                    SQLException var3 = DatabaseError.createSqlException((OracleConnection)null, 23);
                    var3.fillInStackTrace();
                    throw var3;
            }
        } else {
            return null;
        }
    }

    public static NUMBER toNUMBER(Object var0, OracleConnection var1) throws SQLException {
        NUMBER var2 = null;
        if (var0 != null) {
            try {
                if (var0 instanceof NUMBER) {
                    var2 = (NUMBER)var0;
                } else {
                    var2 = new NUMBER(var0);
                }
            } catch (SQLException var5) {
                SQLException var4 = DatabaseError.createSqlException((OracleConnection)null, 59, var0);
                var4.fillInStackTrace();
                throw var4;
            }
        }

        return var2;
    }

    public static Datum[] toNUMBERArray(Object var0, OracleConnection var1, long var2, int var4) throws SQLException {
        Datum[] var5 = null;
        if (var0 != null) {
            if (var0 instanceof Object[] && !(var0 instanceof char[][])) {
                Object[] var6 = (Object[])((Object[])var0);
                int var7 = (int)(var4 == -1 ? (long)var6.length : Math.min((long)var6.length - var2 + 1L, (long)var4));
                var5 = new Datum[var7];

                for(int var8 = 0; var8 < var7; ++var8) {
                    var5[var8] = toNUMBER(var6[(int)var2 + var8 - 1], var1);
                }
            } else {
                var5 = cArrayToNUMBERArray(var0, var1, var2, var4);
            }
        }

        return var5;
    }

    static Datum[] cArrayToNUMBERArray(Object var0, OracleConnection var1, long var2, int var4) throws SQLException {
        Datum[] var5 = null;
        if (var0 != null) {
            int var7;
            int var8;
            if (var0 instanceof short[]) {
                short[] var6 = (short[])((short[])var0);
                var7 = (int)(var4 == -1 ? (long)var6.length : Math.min((long)var6.length - var2 + 1L, (long)var4));
                var5 = new Datum[var7];

                for(var8 = 0; var8 < var7; ++var8) {
                    var5[var8] = new NUMBER(var6[(int)var2 + var8 - 1]);
                }
            } else if (var0 instanceof int[]) {
                int[] var9 = (int[])((int[])var0);
                var7 = (int)(var4 == -1 ? (long)var9.length : Math.min((long)var9.length - var2 + 1L, (long)var4));
                var5 = new Datum[var7];

                for(var8 = 0; var8 < var7; ++var8) {
                    var5[var8] = new NUMBER(var9[(int)var2 + var8 - 1]);
                }
            } else if (var0 instanceof long[]) {
                long[] var10 = (long[])((long[])var0);
                var7 = (int)(var4 == -1 ? (long)var10.length : Math.min((long)var10.length - var2 + 1L, (long)var4));
                var5 = new Datum[var7];

                for(var8 = 0; var8 < var7; ++var8) {
                    var5[var8] = new NUMBER(var10[(int)var2 + var8 - 1]);
                }
            } else if (var0 instanceof float[]) {
                float[] var11 = (float[])((float[])var0);
                var7 = (int)(var4 == -1 ? (long)var11.length : Math.min((long)var11.length - var2 + 1L, (long)var4));
                var5 = new Datum[var7];

                for(var8 = 0; var8 < var7; ++var8) {
                    var5[var8] = new NUMBER(var11[(int)var2 + var8 - 1]);
                }
            } else if (var0 instanceof double[]) {
                double[] var12 = (double[])((double[])var0);
                var7 = (int)(var4 == -1 ? (long)var12.length : Math.min((long)var12.length - var2 + 1L, (long)var4));
                var5 = new Datum[var7];

                for(var8 = 0; var8 < var7; ++var8) {
                    var5[var8] = new NUMBER(var12[(int)var2 + var8 - 1]);
                }
            } else if (var0 instanceof boolean[]) {
                boolean[] var13 = (boolean[])((boolean[])var0);
                var7 = (int)(var4 == -1 ? (long)var13.length : Math.min((long)var13.length - var2 + 1L, (long)var4));
                var5 = new Datum[var7];

                for(var8 = 0; var8 < var7; ++var8) {
                    var5[var8] = new NUMBER(var13[(int)var2 + var8 - 1]);
                }
            } else {
                if (!(var0 instanceof char[][])) {
                    SQLException var15 = DatabaseError.createSqlException((OracleConnection)null, 59, var0);
                    var15.fillInStackTrace();
                    throw var15;
                }

                char[][] var14 = (char[][])((char[][])var0);
                var7 = (int)(var4 == -1 ? (long)var14.length : Math.min((long)var14.length - var2 + 1L, (long)var4));
                var5 = new Datum[var7];

                for(var8 = 0; var8 < var7; ++var8) {
                    var5[var8] = new NUMBER(new String(var14[(int)var2 + var8 - 1]));
                }
            }
        }

        return var5;
    }

    public int getPrecision() {
        return this.precision;
    }

    public int getScale() {
        return this.scale;
    }

    private void writeObject(ObjectOutputStream var1) throws IOException {
        var1.writeInt(this.scale);
        var1.writeInt(this.precision);
    }

    private void readObject(ObjectInputStream var1) throws IOException, ClassNotFoundException {
        this.scale = var1.readInt();
        this.precision = var1.readInt();
    }
}
