//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package oracle.sql;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.SQLException;
import oracle.core.lmx.CoreException;
import oracle.jdbc.driver.DatabaseError;
import oracle.jdbc.internal.OracleConnection;

public class NUMBER extends Datum {
    static byte[] MAX_LONG = toBytes(9223372036854775807L);
    static byte[] MIN_LONG = toBytes(-9223372036854775808L);
    private static final int CHARACTER_ZERO = 48;
    private static final BigDecimal BIGDEC_NEGZERO = new BigDecimal("-0");
    private static final BigDecimal BIGDEC_ZERO = BigDecimal.valueOf(0L);
    private static final BigDecimal BIGDEC_ONE = BigDecimal.valueOf(1L);
    private static final BigInteger BIGINT_ZERO = BigInteger.valueOf(0L);
    private static final BigInteger BIGINT_HUND = BigInteger.valueOf(100L);
    private static final byte DIGEND = 21;
    private static final byte ODIGEND = 9;
    private static final int HUNDIGMAX = 66;
    private static final int BIGINTARRAYMAX = 54;
    private static final double BIGRATIO = 0.1505149978319906D;
    private static final int BIGLENMAX = 22;
    static final byte LNXM_NUM = 22;
    static final int LNXSGNBT = 128;
    static final byte LNXDIGS = 20;
    static final byte LNXEXPBS = 64;
    static final double ORANUM_FBASE = 100.0D;
    static final int LNXBASE = 100;
    static final byte IEEE_DBL_DIG = 15;
    private static final byte IEEE_FLT_DIG = 6;
    static final int LNXEXPMX = 127;
    static final int LNXEXPMN = 0;
    static final int LNXMXOUT = 40;
    static final int LNXMXFMT = 64;
    private static final byte BYTE_MAX_VALUE = 127;
    private static final byte BYTE_MIN_VALUE = -128;
    private static final short SHORT_MAX_VALUE = 32767;
    private static final short SHORT_MIN_VALUE = -32768;
    private static final byte[] PI = new byte[]{-63, 4, 15, 16, 93, 66, 36, 90, 80, 33, 39, 47, 27, 44, 39, 33, 80, 51, 29, 85, 21};
    private static final byte[] E = new byte[]{-63, 3, 72, 83, 82, 83, 85, 60, 5, 53, 36, 37, 3, 88, 48, 14, 53, 67, 25, 98, 77};
    private static final byte[] LN10 = new byte[]{-63, 3, 31, 26, 86, 10, 30, 95, 5, 57, 85, 2, 80, 92, 46, 47, 85, 37, 43, 8, 61};
    private static LnxLib _slnxlib;
    private static LnxLib _thinlib = null;
    private static int DBL_MAX = 40;
    private static int INT_MAX = 15;
    private static float FLOAT_MAX_INT = 2.14748365E9F;
    private static float FLOAT_MIN_INT = -2.14748365E9F;
    private static double DOUBLE_MAX_INT = 2.147483647E9D;
    private static double DOUBLE_MIN_INT = -2.147483648E9D;
    private static double DOUBLE_MAX_INT_2 = 2.147483649E9D;
    private static double DOUBLE_MIN_INT_2 = -2.147483649E9D;
    private static Object drvType = null;
    private static String LANGID;
    static final long serialVersionUID = -1656085588913430059L;
    private static final String _Copyright_2007_Oracle_All_Rights_Reserved_;
    public static final String BUILD_DATE = "Thu_Apr_04_15:09:24_PDT_2013";
    public static final boolean TRACE = false;

    public NUMBER() {
        super(_makeZero());
    }

    public NUMBER(byte[] var1) {
        super(var1);
    }

    public NUMBER(byte var1) {
        super(toBytes(var1));
    }

    public NUMBER(int var1) {
        super(toBytes(var1));
    }

    public NUMBER(long var1) {
        super(toBytes(var1));
    }

    public NUMBER(short var1) {
        super(toBytes(var1));
    }

    public NUMBER(float var1) {
        super(toBytes(var1));
    }

    public NUMBER(double var1) throws SQLException {
        super(toBytes(var1));
    }

    public NUMBER(BigDecimal var1) throws SQLException {
        super(toBytes(var1));
    }

    public NUMBER(BigInteger var1) throws SQLException {
        super(toBytes(var1));
    }

    public NUMBER(String var1, int var2) throws SQLException {
        super(toBytes(var1, var2));
    }

    public NUMBER(boolean var1) {
        super(toBytes(var1));
    }

    public NUMBER(Object var1) throws SQLException {
        if (var1 instanceof Integer) {
            this.setShareBytes(toBytes((Integer)var1));
        } else if (var1 instanceof Long) {
            this.setShareBytes(toBytes((Long)var1));
        } else if (var1 instanceof Float) {
            this.setShareBytes(toBytes((Float)var1));
        } else if (var1 instanceof Double) {
            this.setShareBytes(toBytes((Double)var1));
        } else if (var1 instanceof BigInteger) {
            this.setShareBytes(toBytes((BigInteger)var1));
        } else if (var1 instanceof BigDecimal) {
            this.setShareBytes(toBytes((BigDecimal)var1));
        } else if (var1 instanceof Boolean) {
            this.setShareBytes(toBytes((Boolean)var1));
        } else if (var1 instanceof String) {
            this.setShareBytes(this.stringToBytes((String)var1));
        } else if (var1 instanceof Short) {
            this.setShareBytes(toBytes((Short)var1));
        } else {
            if (!(var1 instanceof Byte)) {
                throw new SQLException("Initialization failed");
            }

            this.setShareBytes(toBytes((Byte)var1));
        }

    }

    public static double toDouble(byte[] var0) {
        if (_isZero(var0)) {
            return 0.0D;
        } else if (_isPosInf(var0)) {
            return 1.0D / 0.0;
        } else if (_isNegInf(var0)) {
            return -1.0D / 0.0;
        } else {
            String var1 = null;

            try {
                if (drvType == null) {
                    var1 = _slnxlib.lnxnuc(var0, DBL_MAX, (String)null);
                } else {
                    var1 = _slnxlib.lnxnuc(var0, DBL_MAX, LANGID);
                }
            } catch (Exception var4) {
            }

            double var2 = Double.valueOf(var1);
            return var2;
        }
    }

    public static float toFloat(byte[] var0) {
        return (float)toDouble(var0);
    }

    public static long toLong(byte[] var0) throws SQLException {
        if (_isZero(var0)) {
            return 0L;
        } else if (!_isInf(var0) && compareBytes(var0, MAX_LONG) <= 0 && compareBytes(var0, MIN_LONG) >= 0) {
            return _getLnxLib().lnxsni(var0);
        } else {
            throw new SQLException(CoreException.getMessage((byte)3));
        }
    }

    public static int toInt(byte[] var0) throws SQLException {
        if (_isInf(var0)) {
            throw new SQLException(CoreException.getMessage((byte)3));
        } else {
            String var1;
            if (drvType == null) {
                var1 = _slnxlib.lnxnuc(var0, INT_MAX, (String)null);
            } else {
                var1 = _slnxlib.lnxnuc(var0, INT_MAX, LANGID);
            }

            double var2 = Double.valueOf(var1);
            if ((float)var2 <= FLOAT_MAX_INT && (float)var2 >= FLOAT_MIN_INT) {
                if (var2 > DOUBLE_MAX_INT && var2 <= DOUBLE_MAX_INT_2) {
                    throw new SQLException(CoreException.getMessage((byte)3));
                } else if (var2 < DOUBLE_MIN_INT && var2 >= DOUBLE_MIN_INT_2) {
                    throw new SQLException(CoreException.getMessage((byte)3));
                } else {
                    int var4 = (int)var2;
                    return var4;
                }
            } else {
                throw new SQLException(CoreException.getMessage((byte)3));
            }
        }
    }

    public static short toShort(byte[] var0) throws SQLException {
        long var1 = 0L;

        try {
            var1 = toLong(var0);
            if (var1 > 32767L || var1 < -32768L) {
                throw new SQLException(CoreException.getMessage((byte)3));
            }
        } finally {
            ;
        }

        return (short)((int)var1);
    }

    public static byte toByte(byte[] var0) throws SQLException {
        long var1 = 0L;

        try {
            var1 = toLong(var0);
            if (var1 > 127L || var1 < -128L) {
                throw new SQLException(CoreException.getMessage((byte)3));
            }
        } finally {
            ;
        }

        return (byte)((int)var1);
    }

    public static BigInteger toBigInteger(byte[] var0) throws SQLException {
        long[] var1 = new long[10];
        byte var2 = 9;
        byte var3 = 1;
        byte var9 = 0;
        if (_isZero(var0)) {
            return BIGINT_ZERO;
        } else if (_isInf(var0)) {
            throw new SQLException(CoreException.getMessage((byte)3));
        } else {
            boolean var12 = _isPositive(var0);
            byte[] var13 = _fromLnxFmt(var0);
            if (var13[0] < 0) {
                return BIGINT_ZERO;
            } else {
                int var10 = Math.min(var13[0] + 1, var13.length - 1);
                int var4;
                byte var17;
                if ((var10 & 1) == 1) {
                    var1[var2] = (long)var13[var3];
                    var17 = (byte)(var3 + 1);
                    var4 = var10 - 1;
                } else {
                    var1[var2] = (long)(var13[var3] * 100 + var13[var3 + 1]);
                    var17 = (byte)(var3 + 2);
                    var4 = var10 - 2;
                }

                byte var5;
                for(var5 = var2; var4 != 0; var4 -= 2) {
                    long var6 = (long)(var13[var17] * 100 + var13[var17 + 1]);

                    for(byte var16 = 9; var16 >= var5; --var16) {
                        var6 += var1[var16] * 10000L;
                        var1[var16] = var6 & 65535L;
                        var6 >>= 16;
                    }

                    if (var6 != 0L) {
                    }

                    --var5;
                    var1[var5] = var6;
                    var17 = (byte)(var17 + 2);
                }

                int var8;
                if (var1[var5] >> 8 != 0L) {
                    var8 = 2 * (9 - var5) + 2;
                } else {
                    var8 = 2 * (9 - var5) + 1;
                }

                byte[] var14 = new byte[var8];
                int var18;
                if ((var8 & 1) == 1) {
                    var14[var9] = (byte)((int)var1[var5]);
                    var18 = var9 + 1;
                } else {
                    var14[var9] = (byte)((int)(var1[var5] >> 8));
                    var18 = var9 + 1;
                    var14[var18] = (byte)((int)(var1[var5] & 255L));
                    ++var18;
                }

                ++var5;

                while(var5 <= 9) {
                    var14[var18] = (byte)((int)(var1[var5] >> 8));
                    var14[var18 + 1] = (byte)((int)(var1[var5] & 255L));
                    var18 += 2;
                    ++var5;
                }

                BigInteger var15 = new BigInteger(var12 ? 1 : -1, var14);
                int var11 = var13[0] - (var10 - 1);
                return var15.multiply(BIGINT_HUND.pow(var11));
            }
        }
    }

    public static BigDecimal toBigDecimal(byte[] var0) throws SQLException {
        long[] var1 = new long[10];
        byte var2 = 9;
        byte var3 = 1;
        byte var9 = 0;
        if (_isZero(var0)) {
            return BIGDEC_ZERO;
        } else if (_isInf(var0)) {
            throw new SQLException(CoreException.getMessage((byte)3));
        } else {
            boolean var12 = _isPositive(var0);
            byte[] var13 = _fromLnxFmt(var0);
            int var10;
            int var4 = var10 = var13.length - 1;
            byte var19;
            if ((var10 & 1) == 1) {
                var1[var2] = (long)var13[var3];
                var19 = (byte)(var3 + 1);
                --var4;
            } else {
                var1[var2] = (long)(var13[var3] * 100 + var13[var3 + 1]);
                var19 = (byte)(var3 + 2);
                var4 -= 2;
            }

            byte var5;
            for(var5 = var2; var4 != 0; var4 -= 2) {
                long var6 = (long)(var13[var19] * 100 + var13[var19 + 1]);

                for(byte var18 = 9; var18 >= var5; --var18) {
                    var6 += var1[var18] * 10000L;
                    var1[var18] = var6 & 65535L;
                    var6 >>= 16;
                }

                if (var6 != 0L) {
                }

                --var5;
                var1[var5] = var6;
                var19 = (byte)(var19 + 2);
            }

            int var8;
            if (var1[var5] >> 8 != 0L) {
                var8 = 2 * (9 - var5) + 2;
            } else {
                var8 = 2 * (9 - var5) + 1;
            }

            byte[] var14 = new byte[var8];
            int var20;
            if ((var8 & 1) == 1) {
                var14[var9] = (byte)((int)var1[var5]);
                var20 = var9 + 1;
            } else {
                var14[var9] = (byte)((int)(var1[var5] >> 8));
                var20 = var9 + 1;
                var14[var20] = (byte)((int)(var1[var5] & 255L));
                ++var20;
            }

            ++var5;

            while(var5 <= 9) {
                var14[var20] = (byte)((int)(var1[var5] >> 8));
                var14[var20 + 1] = (byte)((int)(var1[var5] & 255L));
                var20 += 2;
                ++var5;
            }

            BigInteger var15 = new BigInteger(var12 ? 1 : -1, var14);
            BigDecimal var16 = new BigDecimal(var15);
            int var17 = var13[0] - var10 + 1;
            var16 = var16.movePointRight(var17 * 2);
            if (var17 < 0 && var13[var10] % 10 == 0) {
                var16 = var16.setScale(-(var17 * 2 + 1));
            }

            return var16;
        }
    }

    public static String toString(byte[] var0) {
        int var1 = 0;
        if (_isZero(var0)) {
            return "0";
        } else if (_isPosInf(var0)) {
            return (new Double(1.0D / 0.0)).toString();
        } else if (_isNegInf(var0)) {
            return (new Double(-1.0D / 0.0)).toString();
        } else {
            byte[] var3 = _fromLnxFmt(var0);
            int var4 = var3[0];
            int var5 = var3.length - 1;
            int var6 = var4 - (var5 - 1);
            int var8;
            if (var6 >= 0) {
                var8 = 2 * (var4 + 1) + 1;
            } else if (var4 >= 0) {
                var8 = 2 * (var5 + 1);
            } else {
                var8 = 2 * (var5 - var4) + 3;
            }

            char[] var9 = new char[var8];
            if (!_isPositive(var0)) {
                var9[var1++] = '-';
            }

            int var2;
            if (var6 >= 0) {
                var1 += _byteToChars(var3[1], var9, var1);

                for(var2 = 2; var2 <= var5; --var4) {
                    _byteTo2Chars(var3[var2], var9, var1);
                    var1 += 2;
                    ++var2;
                }

                if (var4 > 0) {
                    while(var4 > 0) {
                        var9[var1++] = '0';
                        var9[var1++] = '0';
                        --var4;
                    }
                }
            } else {
                int var7 = var5 + var6;
                if (var7 > 0) {
                    var1 += _byteToChars(var3[1], var9, var1);
                    if (var7 == 1) {
                        var9[var1++] = '.';
                    }

                    for(var2 = 2; var2 < var5; ++var2) {
                        _byteTo2Chars(var3[var2], var9, var1);
                        var1 += 2;
                        if (var7 == var2) {
                            var9[var1++] = '.';
                        }
                    }

                    if (var3[var2] % 10 == 0) {
                        var1 += _byteToChars((byte)(var3[var2] / 10), var9, var1);
                    } else {
                        _byteTo2Chars(var3[var2], var9, var1);
                        var1 += 2;
                    }
                } else {
                    var9[var1++] = '0';

                    for(var9[var1++] = '.'; var7 < 0; ++var7) {
                        var9[var1++] = '0';
                        var9[var1++] = '0';
                    }

                    for(var2 = 1; var2 < var5; ++var2) {
                        _byteTo2Chars(var3[var2], var9, var1);
                        var1 += 2;
                    }

                    if (var3[var2] % 10 == 0) {
                        var1 += _byteToChars((byte)(var3[var2] / 10), var9, var1);
                    } else {
                        _byteTo2Chars(var3[var2], var9, var1);
                        var1 += 2;
                    }
                }
            }

            return new String(var9, 0, var1);
        }
    }

    public static boolean toBoolean(byte[] var0) {
        return !_isZero(var0);
    }

    public static byte[] toBytes(double var0) throws SQLException {
        if (Double.isNaN(var0)) {
            throw new IllegalArgumentException(CoreException.getMessage((byte)11));
        } else if (var0 != 0.0D && var0 != -0.0D) {
            if (var0 == 1.0D / 0.0) {
                return _makePosInf();
            } else {
                return var0 == -1.0D / 0.0 ? _makeNegInf() : _getThinLib().lnxren(var0);
            }
        } else {
            return _makeZero();
        }
    }

    public static byte[] toBytes(float var0) {
        if (Float.isNaN(var0)) {
            throw new IllegalArgumentException(CoreException.getMessage((byte)11));
        } else if (var0 != 0.0F && var0 != -0.0F) {
            if (var0 == 1.0F / 0.0) {
                return _makePosInf();
            } else if (var0 == -1.0F / 0.0) {
                return _makeNegInf();
            } else {
                String var1 = Float.toString(var0);

                try {
                    return _getLnxLib().lnxcpn(var1, false, 0, false, 0, "AMERICAN_AMERICA");
                } catch (Exception var3) {
                    return null;
                }
            }
        } else {
            return _makeZero();
        }
    }

    public static byte[] toBytes(long var0) {
        return _getLnxLib().lnxmin(var0);
    }

    public static byte[] toBytes(int var0) {
        return toBytes((long)var0);
    }

    public static byte[] toBytes(short var0) {
        return toBytes((long)var0);
    }

    public static byte[] toBytes(byte var0) {
        return toBytes((long)var0);
    }

    public static byte[] toBytes(BigInteger var0) throws SQLException {
        if (var0 == null) {
            SQLException var18 = DatabaseError.createSqlException((OracleConnection)null, 68, "input should not be null");
            var18.fillInStackTrace();
            throw var18;
        } else {
            byte[] var1 = new byte[66];
            long[] var2 = new long[54];
            long[] var3 = new long[22];
            byte var4 = 21;
            byte var5 = 0;
            byte var7 = 21;
            boolean var10 = false;
            byte var12 = 0;
            boolean var14 = true;
            if (var0.signum() == 0) {
                return _makeZero();
            } else {
                byte[] var13;
                int var15;
                if (var0.signum() == -1) {
                    BigInteger var17 = var0.abs();
                    var14 = false;
                    var13 = var17.toByteArray();
                    var15 = (int)Math.floor((double)var17.bitLength() * 0.1505149978319906D);
                } else {
                    var13 = var0.toByteArray();
                    var15 = (int)Math.floor((double)var0.bitLength() * 0.1505149978319906D);
                }

                if (var0.abs().compareTo(BIGINT_HUND.pow(var15)) < 0) {
                    --var15;
                }

                if (var13.length > 54) {
                    throw new SQLException(CoreException.getMessage((byte)3));
                } else {
                    int var16;
                    for(var16 = 0; var16 < var13.length; ++var16) {
                        if (var13[var16] < 0) {
                            var2[var16] = (long)(var13[var16] + 256);
                        } else {
                            var2[var16] = (long)var13[var16];
                        }
                    }

                    int var6 = var13.length;
                    long var8;
                    byte var20;
                    switch(var6 % 3) {
                        case 1:
                            var3[var4] = var2[var5];
                            var20 = (byte)(var5 + 1);
                            --var6;
                            break;
                        case 2:
                            var3[var4] = (var2[var5] << 8) + var2[var5 + 1];
                            var20 = (byte)(var5 + 2);
                            var6 -= 2;
                            break;
                        default:
                            var8 = (var2[var5] << 16) + (var2[var5 + 1] << 8) + var2[var5 + 2];
                            var3[var4] = var8 % 1000000L;
                            var3[var4 - 1] = var8 / 1000000L;
                            var7 = (byte)(var7 - (var3[var4 - 1] != 0L ? 1 : 0));
                            var20 = (byte)(var5 + 3);
                            var6 -= 3;
                    }

                    byte var19;
                    while(var6 != 0) {
                        var8 = (var2[var20] << 4) + (var2[var20 + 1] >> 4);

                        for(var19 = 21; var19 >= var7; --var19) {
                            var8 += var3[var19] << 12;
                            var3[var19] = var8 % 1000000L;
                            var8 /= 1000000L;
                        }

                        if (var8 != 0L) {
                            --var7;
                            var3[var7] = var8;
                        }

                        var8 = ((var2[var20 + 1] & 15L) << 8) + var2[var20 + 2];

                        for(var19 = 21; var19 >= var7; --var19) {
                            var8 += var3[var19] << 12;
                            var3[var19] = var8 % 1000000L;
                            var8 /= 1000000L;
                        }

                        if (var8 != 0L) {
                            --var7;
                            var3[var7] = var8;
                        }

                        var20 = (byte)(var20 + 3);
                        var6 -= 3;
                    }

                    int var11;
                    int var21;
                    if ((var1[var12] = (byte)((int)(var3[var7] / 10000L))) != 0) {
                        var11 = 3 * (21 - var7) + 3;
                        var1[var12 + 1] = (byte)((int)(var3[var7] % 10000L / 100L));
                        var1[var12 + 2] = (byte)((int)(var3[var7] % 100L));
                        var21 = var12 + 3;
                    } else if ((var1[var12] = (byte)((int)(var3[var7] % 10000L / 100L))) != 0) {
                        var11 = 3 * (21 - var7) + 2;
                        var1[var12 + 1] = (byte)((int)(var3[var7] % 100L));
                        var21 = var12 + 2;
                    } else {
                        var1[var12] = (byte)((int)var3[var7]);
                        var11 = 3 * (21 - var7) + 1;
                        var21 = var12 + 1;
                    }

                    for(var19 = (byte)(var7 + 1); var19 <= 21; ++var19) {
                        var1[var21] = (byte)((int)(var3[var19] / 10000L));
                        var1[var21 + 1] = (byte)((int)(var3[var19] % 10000L / 100L));
                        var1[var21 + 2] = (byte)((int)(var3[var19] % 100L));
                        var21 += 3;
                    }

                    for(var16 = var21 - 1; var16 >= 0 && var1[var16] == 0; --var16) {
                        --var11;
                    }

                    if (var11 > 19) {
                        byte var22 = 20;
                        var11 = 19;
                        if (var1[var22] >= 50) {
                            var16 = var22 - 1;
                            ++var1[var16];

                            while(var1[var16] == 100) {
                                if (var16 == 0) {
                                    ++var15;
                                    var1[var16] = 1;
                                    break;
                                }

                                var1[var16] = 0;
                                --var16;
                                ++var1[var16];
                            }

                            for(var16 = var11 - 1; var16 >= 0 && var1[var16] == 0; --var16) {
                                --var11;
                            }
                        }
                    }

                    if (var15 > 62) {
                        throw new SQLException(CoreException.getMessage((byte)3));
                    } else {
                        byte[] var23 = new byte[var11 + 1];
                        var23[0] = (byte)var15;
                        System.arraycopy(var1, 0, var23, 1, var11);
                        return _toLnxFmt(var23, var14);
                    }
                }
            }
        }
    }

    public static byte[] toBytes(BigDecimal var0) throws SQLException {
        if (var0 == null) {
            SQLException var25 = DatabaseError.createSqlException((OracleConnection)null, 68, "input should not be null");
            var25.fillInStackTrace();
            throw var25;
        } else {
            byte[] var1 = new byte[66];
            long[] var2 = new long[54];
            long[] var3 = new long[22];
            byte var4 = 21;
            byte var5 = 0;
            byte var7 = 21;
            byte var11 = 0;
            boolean var14 = false;
            BigDecimal var18 = var0.abs();
            boolean var20 = false;
            if (var0.signum() == 0) {
                return _makeZero();
            } else {
                boolean var13 = var0.signum() != -1;
                int var16 = var0.scale();
                if (var16 < 0) {
                    var0 = var0.setScale(0);
                    var16 = 0;
                }

                int var19 = var18.compareTo(BIGDEC_ONE);
                int var21 = 0;
                BigDecimal var22;
                int var31;
                if (var19 == -1) {
                    do {
                        ++var21;
                        var22 = var18.movePointRight(var21);
                    } while(var22.compareTo(BIGDEC_ONE) < 0);

                    var31 = -var21;
                } else {
                    do {
                        ++var21;
                        var22 = var18.movePointLeft(var21);
                    } while(var22.compareTo(BIGDEC_ONE) >= 0);

                    var31 = var21;
                }

                byte[] var12 = var18.movePointRight(var16).toBigInteger().toByteArray();
                if (var12.length > 54) {
                    throw new SQLException(CoreException.getMessage((byte)3));
                } else {
                    int var15;
                    for(var15 = 0; var15 < var12.length; ++var15) {
                        if (var12[var15] < 0) {
                            var2[var15] = (long)(var12[var15] + 256);
                        } else {
                            var2[var15] = (long)var12[var15];
                        }
                    }

                    int var6 = var12.length;
                    long var8;
                    byte var27;
                    switch(var6 % 3) {
                        case 1:
                            var3[var4] = var2[var5];
                            var27 = (byte)(var5 + 1);
                            --var6;
                            break;
                        case 2:
                            var3[var4] = (var2[var5] << 8) + var2[var5 + 1];
                            var27 = (byte)(var5 + 2);
                            var6 -= 2;
                            break;
                        default:
                            var8 = (var2[var5] << 16) + (var2[var5 + 1] << 8) + var2[var5 + 2];
                            var3[var4] = var8 % 1000000L;
                            var3[var4 - 1] = var8 / 1000000L;
                            var7 = (byte)(var7 - (var3[var4 - 1] != 0L ? 1 : 0));
                            var27 = (byte)(var5 + 3);
                            var6 -= 3;
                    }

                    byte var26;
                    while(var6 != 0) {
                        var8 = (var2[var27] << 4) + (var2[var27 + 1] >> 4);

                        for(var26 = 21; var26 >= var7; --var26) {
                            var8 += var3[var26] << 12;
                            var3[var26] = var8 % 1000000L;
                            var8 /= 1000000L;
                        }

                        if (var8 != 0L) {
                            --var7;
                            var3[var7] = var8;
                        }

                        var8 = ((var2[var27 + 1] & 15L) << 8) + var2[var27 + 2];

                        for(var26 = 21; var26 >= var7; --var26) {
                            var8 += var3[var26] << 12;
                            var3[var26] = var8 % 1000000L;
                            var8 /= 1000000L;
                        }

                        if (var8 != 0L) {
                            --var7;
                            var3[var7] = var8;
                        }

                        var27 = (byte)(var27 + 3);
                        var6 -= 3;
                    }

                    int var10;
                    int var28;
                    if ((var1[var11] = (byte)((int)(var3[var7] / 10000L))) != 0) {
                        var10 = 3 * (21 - var7) + 3;
                        var1[var11 + 1] = (byte)((int)(var3[var7] % 10000L / 100L));
                        var1[var11 + 2] = (byte)((int)(var3[var7] % 100L));
                        var28 = var11 + 3;
                    } else if ((var1[var11] = (byte)((int)(var3[var7] % 10000L / 100L))) != 0) {
                        var10 = 3 * (21 - var7) + 2;
                        var1[var11 + 1] = (byte)((int)(var3[var7] % 100L));
                        var28 = var11 + 2;
                    } else {
                        var1[var11] = (byte)((int)var3[var7]);
                        var10 = 3 * (21 - var7) + 1;
                        var28 = var11 + 1;
                    }

                    for(var26 = (byte)(var7 + 1); var26 <= 21; ++var26) {
                        var1[var28] = (byte)((int)(var3[var26] / 10000L));
                        var1[var28 + 1] = (byte)((int)(var3[var26] % 10000L / 100L));
                        var1[var28 + 2] = (byte)((int)(var3[var26] % 100L));
                        var28 += 3;
                    }

                    for(var15 = var28 - 1; var15 >= 0 && var1[var15] == 0; --var15) {
                        --var10;
                    }

                    if (var16 > 0 && (var16 & 1) != 0) {
                        int var23 = var10;
                        byte[] var24 = new byte[var10 + 1];
                        if (var1[0] <= 9) {
                            for(var15 = 0; var15 < var23 - 1; ++var15) {
                                var24[var15] = (byte)(var1[var15] % 10 * 10 + var1[var15 + 1] / 10);
                            }

                            var24[var15] = (byte)(var1[var15] % 10 * 10);
                            if (var24[var23 - 1] == 0) {
                                --var10;
                            }
                        } else {
                            var24[var10] = (byte)(var1[var10 - 1] % 10 * 10);

                            for(var15 = var10 - 1; var15 > 0; --var15) {
                                var24[var15] = (byte)(var1[var15] / 10 + var1[var15 - 1] % 10 * 10);
                            }

                            var24[var15] = (byte)(var1[var15] / 10);
                            if (var24[var10] > 0) {
                                ++var10;
                            }
                        }

                        System.arraycopy(var24, 0, var1, 0, var10);
                    }

                    if (var10 > 20) {
                        byte var30 = 20;
                        var10 = 20;
                        if (var1[var30] >= 50) {
                            var15 = var30 - 1;
                            ++var1[var15];

                            while(var1[var15] == 100) {
                                if (var15 == 0) {
                                    ++var31;
                                    var1[var15] = 1;
                                    break;
                                }

                                var1[var15] = 0;
                                --var15;
                                ++var1[var15];
                            }
                        }

                        for(var15 = var10 - 1; var15 >= 0 && var1[var15] == 0; --var15) {
                            --var10;
                        }
                    }

                    int var29;
                    if (var31 <= 0) {
                        if (var1[0] < 10) {
                            var29 = -(2 - var31) / 2 + 1;
                        } else {
                            var29 = -(2 - var31) / 2;
                        }
                    } else {
                        var29 = (var31 - 1) / 2;
                    }

                    if (var29 > 62) {
                        throw new SQLException(CoreException.getMessage((byte)3));
                    } else if (var29 <= -65) {
                        throw new SQLException(CoreException.getMessage((byte)2));
                    } else {
                        byte[] var32 = new byte[var10 + 1];
                        var32[0] = (byte)var29;
                        System.arraycopy(var1, 0, var32, 1, var10);
                        return _toLnxFmt(var32, var13);
                    }
                }
            }
        }
    }

    public static byte[] toBytes(String var0, int var1) throws SQLException {
        if (var0 != null && var0.length() != 0) {
            boolean var36 = false;
            int var3 = 0;
            byte[] var5 = new byte[22];
            byte var7 = 0;
            boolean var9 = true;
            boolean var10 = false;
            boolean var11 = false;
            int var12 = 0;
            int var14 = 0;
            int var15 = 0;
            byte var16 = 40;
            int var17 = 0;
            boolean var18 = false;
            byte var19 = 0;
            int var21 = 0;
            int var22;
            int var41;
            if ((var22 = var0.indexOf("E")) != -1 || (var22 = var0.indexOf("e")) != -1) {
                StringBuffer var23 = new StringBuffer(var0.length() + 5);
                boolean var24 = false;
                BigDecimal var25 = null;
                boolean var26 = var0.charAt(0) == '-';
                String var27 = var0.substring(var22 + 1);
                String var28 = var0.substring(var26 ? 1 : 0, var22);
                var25 = new BigDecimal(var28);
                boolean var29 = var27.charAt(0) == '-';
                if (var29 || var27.charAt(0) == '+') {
                    var27 = var27.substring(1);
                }

                var41 = Integer.parseInt(var27);
                String var30 = var25.toString();
                int var31 = var30.indexOf(".");
                int var32 = var30.length();
                int var33 = var32;
                if (var31 != -1) {
                    var30 = var30.substring(0, var31) + var30.substring(var31 + 1);
                    --var32;
                    if (var29) {
                        var41 -= var31;
                    } else {
                        ++var41;
                        var33 = var41;
                    }
                } else if (var29) {
                    var41 -= var32;
                } else {
                    ++var41;
                    var33 = var41;
                }

                if (var26) {
                    var23.append("-");
                }

                int var34;
                if (!var29) {
                    var34 = var41 > var32 ? var41 : var32;

                    for(int var35 = 0; var35 < var34; ++var35) {
                        if (var33 == var35) {
                            var23.append(".");
                        }

                        var23.append(var32 > var35 ? var30.charAt(var35) : '0');
                    }
                } else {
                    var23.append("0.");

                    for(var34 = 0; var34 < var41; ++var34) {
                        var23.append("0");
                    }

                    var23.append(var30);
                }

                var0 = var23.toString();
            }

            var0 = var0.trim();
            int var20 = var0.length();
            if (var0.charAt(0) == '-') {
                --var20;
                var9 = false;
                var19 = 1;
            }

            int var37 = var20;
            char[] var40 = new char[var20];
            var0.getChars(var19, var20 + var19, var40, 0);

            int var4;
            for(var4 = 0; var4 < var20; ++var4) {
                if (var40[var4] == '.') {
                    var11 = true;
                    break;
                }
            }

            if (!var11) {
                var1 = 0;
            }

            while(var3 < var37 && var40[var3] == '0') {
                ++var3;
                if (var11) {
                    ++var21;
                }
            }

            if (var3 == var37) {
                return _makeZero();
            } else {
                int var6;
                int var38;
                int var39;
                if (var20 >= 2 && var40[var3] == '.') {
                    ++var3;

                    while(var37 > 0 && var40[var37 - 1] == '0') {
                        --var37;
                    }

                    if (var3 == var37) {
                        return _makeZero();
                    }

                    --var12;

                    while(var3 < var37 - 1 && var40[var3] == '0' && var40[var3 + 1] == '0') {
                        --var12;
                        var15 += 2;
                        var3 += 2;
                    }

                    if (var12 < -65) {
                        throw new SQLException(CoreException.getMessage((byte)2));
                    }

                    if (var37 - var3 > var16) {
                        var6 = var3 + var16;
                        if (var15 > 0) {
                            var6 += var15;
                        }

                        if (var6 <= var37) {
                            var37 = var6;
                        }

                        var17 = var37;
                        var10 = true;
                    }

                    var38 = var37 - var3 >> 1;
                    if ((var37 - var3) % 2 != 0) {
                        var5[var38] = (byte)(Integer.parseInt(new String(var40, var37 - 1, 1)) * 10);
                        ++var14;
                        --var37;
                    }

                    while(var37 > var3) {
                        --var38;
                        var5[var38] = (byte)Integer.parseInt(new String(var40, var37 - 2, 2));
                        var37 -= 2;
                        ++var14;
                    }
                } else {
                    while(var1 > 0 && var37 > 0 && var40[var37 - 1] == '0') {
                        --var37;
                        --var1;
                    }

                    if (var1 == 0 && var37 > 1) {
                        if (var40[var37 - 1] == '.') {
                            --var37;
                        }

                        if (var3 == var37) {
                            return _makeZero();
                        }

                        while(var37 > 1 && var40[var37 - 2] == '0' && var40[var37 - 1] == '0') {
                            var37 -= 2;
                            ++var12;
                        }
                    }

                    if (var12 > 62) {
                        throw new SQLException(CoreException.getMessage((byte)3));
                    }

                    if (var37 - var3 - (var11 ? 1 : 0) > var16) {
                        var6 = var16 + (var11 ? 1 : 0);
                        var41 = var37 - var6;
                        var37 = var6;
                        var1 -= var41;
                        if (var1 < 0) {
                            var1 = 0;
                        }

                        var10 = true;
                        var17 = var6;
                    }

                    int var13 = var1 == 0 ? var37 - var3 : var37 - var1 - 1;
                    if (var21 > 0) {
                        var13 -= var21;
                    }

                    if (var13 % 2 != 0) {
                        var39 = Integer.parseInt(new String(var40, var3, 1));
                        ++var3;
                        --var13;
                        if (var37 - 1 == var16) {
                            --var1;
                            --var37;
                            var10 = true;
                            var17 = var37;
                        }
                    } else {
                        var39 = Integer.parseInt(new String(var40, var3, 2));
                        var3 += 2;
                        var13 -= 2;
                    }

                    var5[var7] = (byte)var39;
                    var38 = var7 + 1;
                    ++var14;

                    while(var13 > 0) {
                        var5[var38] = (byte)Integer.parseInt(new String(var40, var3, 2));
                        ++var38;
                        var3 += 2;
                        ++var12;
                        var13 -= 2;
                        ++var14;
                    }

                    if (var3 < var37) {
                        if (var1 % 2 != 0) {
                            var38 += var1 / 2;
                            var5[var38] = (byte)(Integer.parseInt(new String(var40, var37 - 1, 1)) * 10);
                            --var37;
                            --var1;
                        } else {
                            var38 += var1 / 2 - 1;
                            var5[var38] = (byte)Integer.parseInt(new String(var40, var37 - 2, 2));
                            var37 -= 2;
                            var1 -= 2;
                        }

                        ++var14;
                        --var38;
                    }

                    while(var1 > 0) {
                        var5[var38] = (byte)Integer.parseInt(new String(var40, var37 - 2, 2));
                        --var38;
                        var37 -= 2;
                        var1 -= 2;
                        ++var14;
                    }
                }

                if (var10) {
                    var39 = Integer.parseInt(new String(var40, var17, 1));
                    if (var39 >= 5) {
                        var41 = var14 - 1;
                        ++var5[var41];

                        while(var5[var41] == 100) {
                            if (var41 == 0) {
                                ++var12;
                                var5[var41] = 1;
                                break;
                            }

                            var5[var41] = 0;
                            --var41;
                            ++var5[var41];
                        }

                        for(var4 = var14 - 1; var4 >= 0 && var5[var4] == 0; --var4) {
                            --var14;
                        }
                    }
                }

                byte[] var42 = new byte[var14 + 1];
                var42[0] = (byte)var12;
                System.arraycopy(var5, 0, var42, 1, var14);
                return _toLnxFmt(var42, var9);
            }
        } else {
            SQLException var2 = DatabaseError.createSqlException((OracleConnection)null, 68);
            var2.fillInStackTrace();
            throw var2;
        }
    }

    public static byte[] toBytes(boolean var0) {
        return var0 ? toBytes(1L) : toBytes(0L);
    }

    public byte[] toBytes() {
        return this.getBytes();
    }

    public double doubleValue() {
        return toDouble(this.shareBytes());
    }

    public float floatValue() {
        return toFloat(this.shareBytes());
    }

    public long longValue() throws SQLException {
        return toLong(this.shareBytes());
    }

    public int intValue() throws SQLException {
        return toInt(this.shareBytes());
    }

    public short shortValue() throws SQLException {
        return toShort(this.shareBytes());
    }

    public byte byteValue() throws SQLException {
        return toByte(this.shareBytes());
    }

    public BigInteger bigIntegerValue() throws SQLException {
        return toBigInteger(this.shareBytes());
    }

    public BigDecimal bigDecimalValue() throws SQLException {
        return toBigDecimal(this.shareBytes());
    }

    public String stringValue() {
        return toString(this.shareBytes());
    }

    public boolean booleanValue() {
        return toBoolean(this.shareBytes());
    }

    public Object toJdbc() throws SQLException {
        try {
            return this.bigDecimalValue();
        } catch (SQLException var2) {
            return new SQLException(var2.getMessage());
        }
    }

    public Object makeJdbcArray(int var1) {
        BigDecimal[] var2 = new BigDecimal[var1];
        return var2;
    }

    public boolean isConvertibleTo(Class var1) {
        String var2 = var1.getName();
        return var2.compareTo("java.lang.Integer") == 0 || var2.compareTo("java.lang.Long") == 0 || var2.compareTo("java.lang.Float") == 0 || var2.compareTo("java.lang.Double") == 0 || var2.compareTo("java.math.BigInteger") == 0 || var2.compareTo("java.math.BigDecimal") == 0 || var2.compareTo("java.lang.String") == 0 || var2.compareTo("java.lang.Boolean") == 0 || var2.compareTo("java.lang.Byte") == 0 || var2.compareTo("java.lang.Short") == 0;
    }

    public NUMBER abs() throws SQLException {
        return new NUMBER(_getLnxLib().lnxabs(this.shareBytes()));
    }

    public NUMBER acos() throws SQLException {
        return new NUMBER(_getLnxLib().lnxacos(this.shareBytes()));
    }

    public NUMBER add(NUMBER var1) throws SQLException {
        return new NUMBER(_getLnxLib().lnxadd(this.shareBytes(), var1.shareBytes()));
    }

    public NUMBER asin() throws SQLException {
        return new NUMBER(_getLnxLib().lnxasin(this.shareBytes()));
    }

    public NUMBER atan() throws SQLException {
        return new NUMBER(_getLnxLib().lnxatan(this.shareBytes()));
    }

    public NUMBER atan2(NUMBER var1) throws SQLException {
        return new NUMBER(_getLnxLib().lnxatan2(this.shareBytes(), var1.shareBytes()));
    }

    public NUMBER ceil() throws SQLException {
        return new NUMBER(_getLnxLib().lnxceil(this.shareBytes()));
    }

    public NUMBER cos() throws SQLException {
        return new NUMBER(_getLnxLib().lnxcos(this.shareBytes()));
    }

    public NUMBER cosh() throws SQLException {
        return new NUMBER(_getLnxLib().lnxcsh(this.shareBytes()));
    }

    public NUMBER decrement() throws SQLException {
        return new NUMBER(_getLnxLib().lnxdec(this.shareBytes()));
    }

    public NUMBER div(NUMBER var1) throws SQLException {
        return new NUMBER(_getLnxLib().lnxdiv(this.shareBytes(), var1.shareBytes()));
    }

    public NUMBER exp() throws SQLException {
        return new NUMBER(_getLnxLib().lnxexp(this.shareBytes()));
    }

    public NUMBER floatingPointRound(int var1) throws SQLException {
        return new NUMBER(_getLnxLib().lnxfpr(this.shareBytes(), var1));
    }

    public NUMBER floor() throws SQLException {
        return new NUMBER(_getLnxLib().lnxflo(this.shareBytes()));
    }

    public NUMBER increment() throws SQLException {
        return new NUMBER(_getLnxLib().lnxinc(this.shareBytes()));
    }

    public NUMBER ln() throws SQLException {
        return new NUMBER(_getLnxLib().lnxln(this.shareBytes()));
    }

    public NUMBER log(NUMBER var1) throws SQLException {
        return new NUMBER(_getLnxLib().lnxlog(this.shareBytes(), var1.shareBytes()));
    }

    public NUMBER mod(NUMBER var1) throws SQLException {
        return new NUMBER(_getLnxLib().lnxmod(this.shareBytes(), var1.shareBytes()));
    }

    public NUMBER mul(NUMBER var1) throws SQLException {
        return new NUMBER(_getLnxLib().lnxmul(this.shareBytes(), var1.shareBytes()));
    }

    public NUMBER negate() throws SQLException {
        return new NUMBER(_getLnxLib().lnxneg(this.shareBytes()));
    }

    public NUMBER pow(NUMBER var1) throws SQLException {
        return new NUMBER(_getLnxLib().lnxbex(this.shareBytes(), var1.shareBytes()));
    }

    public NUMBER pow(int var1) throws SQLException {
        return new NUMBER(_getLnxLib().lnxpow(this.shareBytes(), var1));
    }

    public NUMBER round(int var1) throws SQLException {
        return new NUMBER(_getLnxLib().lnxrou(this.shareBytes(), var1));
    }

    public NUMBER scale(int var1, int var2, boolean[] var3) throws SQLException {
        return new NUMBER(_getLnxLib().lnxsca(this.shareBytes(), var1, var2, var3));
    }

    public NUMBER shift(int var1) throws SQLException {
        return new NUMBER(_getLnxLib().lnxshift(this.shareBytes(), var1));
    }

    public NUMBER sin() throws SQLException {
        return new NUMBER(_getLnxLib().lnxsin(this.shareBytes()));
    }

    public NUMBER sinh() throws SQLException {
        return new NUMBER(_getLnxLib().lnxsnh(this.shareBytes()));
    }

    public NUMBER sqroot() throws SQLException {
        return new NUMBER(_getLnxLib().lnxsqr(this.shareBytes()));
    }

    public NUMBER sub(NUMBER var1) throws SQLException {
        return new NUMBER(_getLnxLib().lnxsub(this.shareBytes(), var1.shareBytes()));
    }

    public NUMBER tan() throws SQLException {
        return new NUMBER(_getLnxLib().lnxtan(this.shareBytes()));
    }

    public NUMBER tanh() throws SQLException {
        return new NUMBER(_getLnxLib().lnxtnh(this.shareBytes()));
    }

    public NUMBER truncate(int var1) throws SQLException {
        return new NUMBER(_getLnxLib().lnxtru(this.shareBytes(), var1));
    }

    public static NUMBER formattedTextToNumber(String var0, String var1, String var2) throws SQLException {
        return new NUMBER(_getLnxLib().lnxfcn(var0, var1, var2));
    }

    public static NUMBER textToPrecisionNumber(String var0, boolean var1, int var2, boolean var3, int var4, String var5) throws SQLException {
        return new NUMBER(_getLnxLib().lnxcpn(var0, var1, var2, var3, var4, var5));
    }

    public String toFormattedText(String var1, String var2) throws SQLException {
        return _getLnxLib().lnxnfn(this.shareBytes(), var1, var2);
    }

    public String toText(int var1, String var2) throws SQLException {
        return _getLnxLib().lnxnuc(this.shareBytes(), var1, var2);
    }

    public int compareTo(NUMBER var1) {
        return compareBytes(this.shareBytes(), var1.shareBytes());
    }

    public boolean isInf() {
        return _isInf(this.shareBytes());
    }

    public boolean isNegInf() {
        return _isNegInf(this.shareBytes());
    }

    public boolean isPosInf() {
        return _isPosInf(this.shareBytes());
    }

    public boolean isInt() {
        return _isInt(this.shareBytes());
    }

    public static boolean isValid(byte[] var0) {
        byte var1 = (byte)var0.length;
        byte var2;
        int var3;
        if (_isPositive(var0)) {
            if (var1 == 1) {
                return _isZero(var0);
            } else if (var0[0] == -1 && var0[1] == 101) {
                return var1 == 2;
            } else if (var1 > 21) {
                return false;
            } else if (var0[1] >= 2 && var0[var1 - 1] >= 2) {
                for(var3 = 1; var3 < var1; ++var3) {
                    var2 = var0[var3];
                    if (var2 < 1 || var2 > 100) {
                        return false;
                    }
                }

                return true;
            } else {
                return false;
            }
        } else if (var1 < 3) {
            return _isNegInf(var0);
        } else if (var1 > 21) {
            return false;
        } else {
            if (var0[var1 - 1] != 102) {
                if (var1 <= 20) {
                    return false;
                }
            } else {
                --var1;
            }

            if (var0[1] <= 100 && var0[var1 - 1] <= 100) {
                for(var3 = 1; var3 < var1; ++var3) {
                    var2 = var0[var3];
                    if (var2 < 2 || var2 > 101) {
                        return false;
                    }
                }

                return true;
            } else {
                return false;
            }
        }
    }

    public boolean isZero() {
        return _isZero(this.shareBytes());
    }

    public static NUMBER e() {
        return new NUMBER(E);
    }

    public static NUMBER ln10() {
        return new NUMBER(LN10);
    }

    public static NUMBER negInf() {
        return new NUMBER(_makeNegInf());
    }

    public static NUMBER pi() {
        return new NUMBER(PI);
    }

    public static NUMBER posInf() {
        return new NUMBER(_makePosInf());
    }

    public static NUMBER zero() {
        return new NUMBER(_makeZero());
    }

    public int sign() {
        if (_isZero(this.shareBytes())) {
            return 0;
        } else {
            return _isPositive(this.shareBytes()) ? 1 : -1;
        }
    }

    static boolean _isInf(byte[] var0) {
        return var0.length == 2 && var0[0] == -1 && var0[1] == 101 || var0[0] == 0 && var0.length == 1;
    }

    private static boolean _isInt(byte[] var0) {
        if (_isZero(var0)) {
            return true;
        } else if (_isInf(var0)) {
            return false;
        } else {
            byte[] var1 = _fromLnxFmt(var0);
            byte var2 = var1[0];
            byte var3 = (byte)(var1.length - 1);
            return var3 <= var2 + 1;
        }
    }

    static boolean _isNegInf(byte[] var0) {
        return var0[0] == 0 && var0.length == 1;
    }

    static boolean _isPosInf(byte[] var0) {
        return var0.length == 2 && var0[0] == -1 && var0[1] == 101;
    }

    static boolean _isPositive(byte[] var0) {
        return (var0[0] & -128) != 0;
    }

    static boolean _isZero(byte[] var0) {
        return var0[0] == -128 && var0.length == 1;
    }

    static byte[] _makePosInf() {
        byte[] var0 = new byte[]{-1, 101};
        return var0;
    }

    static byte[] _makeNegInf() {
        byte[] var0 = new byte[]{0};
        return var0;
    }

    static byte[] _makeZero() {
        byte[] var0 = new byte[]{-128};
        return var0;
    }

    static byte[] _fromLnxFmt(byte[] var0) {
        int var3 = var0.length;
        byte[] var1;
        int var2;
        if (_isPositive(var0)) {
            var1 = new byte[var3];
            var1[0] = (byte)((var0[0] & -129) - 65);

            for(var2 = 1; var2 < var3; ++var2) {
                var1[var2] = (byte)(var0[var2] - 1);
            }
        } else {
            if (var3 - 1 == 20 && var0[var3 - 1] != 102) {
                var1 = new byte[var3];
            } else {
                var1 = new byte[var3 - 1];
            }

            var1[0] = (byte)((~var0[0] & -129) - 65);

            for(var2 = 1; var2 < var1.length; ++var2) {
                var1[var2] = (byte)(101 - var0[var2]);
            }
        }

        return var1;
    }

    static byte[] _toLnxFmt(byte[] var0, boolean var1) {
        int var4 = var0.length;
        byte[] var2;
        int var3;
        if (var1) {
            var2 = new byte[var4];
            var2[0] = (byte)(var0[0] + 128 + 64 + 1);

            for(var3 = 1; var3 < var4; ++var3) {
                var2[var3] = (byte)(var0[var3] + 1);
            }
        } else {
            if (var4 - 1 < 20) {
                var2 = new byte[var4 + 1];
            } else {
                var2 = new byte[var4];
            }

            var2[0] = (byte)(~(var0[0] + 128 + 64 + 1));

            for(var3 = 1; var3 < var4; ++var3) {
                var2[var3] = (byte)(101 - var0[var3]);
            }

            if (var3 <= 20) {
                var2[var3] = 102;
            }
        }

        return var2;
    }

    private static LnxLib _getLnxLib() {
        if (_slnxlib == null) {
            try {
                if (System.getProperty("oracle.jserver.version") != null) {
                    _slnxlib = new LnxLibServer();
                } else {
                    _slnxlib = new LnxLibThin();
                }
            } catch (SecurityException var1) {
                _slnxlib = new LnxLibThin();
            }
        }

        return _slnxlib;
    }

    private static LnxLib _getThinLib() {
        if (_thinlib == null) {
            _thinlib = new LnxLibThin();
        }

        return _thinlib;
    }

    private static int _byteToChars(byte var0, char[] var1, int var2) {
        if (var0 < 0) {
            return 0;
        } else if (var0 < 10) {
            var1[var2] = (char)(48 + var0);
            return 1;
        } else if (var0 < 100) {
            var1[var2] = (char)(48 + var0 / 10);
            var1[var2 + 1] = (char)(48 + var0 % 10);
            return 2;
        } else {
            var1[var2] = '1';
            var1[var2 + 1] = (char)(48 + var0 / 10 - 10);
            var1[var2 + 2] = (char)(48 + var0 % 10);
            return 3;
        }
    }

    private static void _byteTo2Chars(byte var0, char[] var1, int var2) {
        if (var0 < 0) {
            var1[var2] = '0';
            var1[var2 + 1] = '0';
        } else if (var0 < 10) {
            var1[var2] = '0';
            var1[var2 + 1] = (char)(48 + var0);
        } else if (var0 < 100) {
            var1[var2] = (char)(48 + var0 / 10);
            var1[var2 + 1] = (char)(48 + var0 % 10);
        } else {
            var1[var2] = '0';
            var1[var2 + 1] = '0';
        }

    }

    private static void _printBytes(byte[] var0) {
        int var1 = var0.length;
        System.out.print(var1 + ": ");

        for(int var2 = 0; var2 < var1; ++var2) {
            System.out.print(var0[var2] + " ");
        }

        System.out.println();
    }

    private byte[] stringToBytes(String var1) throws SQLException {
        int var2 = 0;
        var1 = var1.trim();
        if (var1.indexOf(46) >= 0) {
            var2 = var1.length() - 1 - var1.indexOf(46);
        }

        return toBytes(var1, var2);
    }

    static {
        try {
            drvType = System.getProperty("oracle.jserver.version");
        } catch (SecurityException var1) {
            drvType = null;
        }

        LANGID = "AMERICAN";
        _Copyright_2007_Oracle_All_Rights_Reserved_ = null;
    }
}
