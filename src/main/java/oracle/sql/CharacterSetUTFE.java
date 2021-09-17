//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package oracle.sql;

import java.sql.SQLException;
import oracle.sql.CharacterSet.CharacterConverterBehavior;

class CharacterSetUTFE extends CharacterSet implements CharacterRepConstants {
    static final int MAXBYTEPERCHAR = 4;
    static byte[][] utf8m2utfe = new byte[][]{{0, 1, 2, 3, 55, 45, 46, 47, 22, 5, 21, 11, 12, 13, 14, 15}, {16, 17, 18, 19, 60, 61, 50, 38, 24, 25, 63, 39, 28, 29, 30, 31}, {64, 90, 127, 123, 91, 108, 80, 125, 77, 93, 92, 78, 107, 96, 75, 97}, {-16, -15, -14, -13, -12, -11, -10, -9, -8, -7, 122, 94, 76, 126, 110, 111}, {124, -63, -62, -61, -60, -59, -58, -57, -56, -55, -47, -46, -45, -44, -43, -42}, {-41, -40, -39, -30, -29, -28, -27, -26, -25, -24, -23, -83, -32, -67, 95, 109}, {121, -127, -126, -125, -124, -123, -122, -121, -120, -119, -111, -110, -109, -108, -107, -106}, {-105, -104, -103, -94, -93, -92, -91, -90, -89, -88, -87, -64, 79, -48, -95, 7}, {32, 33, 34, 35, 36, 37, 6, 23, 40, 41, 42, 43, 44, 9, 10, 27}, {48, 49, 26, 51, 52, 53, 54, 8, 56, 57, 58, 59, 4, 20, 62, -1}, {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 81, 82, 83, 84, 85, 86}, {87, 88, 89, 98, 99, 100, 101, 102, 103, 104, 105, 106, 112, 113, 114, 115}, {116, 117, 118, 119, 120, -128, -118, -117, -116, -115, -114, -113, -112, -102, -101, -100}, {-99, -98, -97, -96, -86, -85, -84, -82, -81, -80, -79, -78, -77, -76, -75, -74}, {-73, -72, -71, -70, -69, -68, -66, -65, -54, -53, -52, -51, -50, -49, -38, -37}, {-36, -35, -34, -33, -31, -22, -21, -20, -19, -18, -17, -6, -5, -4, -3, -2}};
    static byte[][] utfe2utf8m = new byte[][]{{0, 1, 2, 3, -100, 9, -122, 127, -105, -115, -114, 11, 12, 13, 14, 15}, {16, 17, 18, 19, -99, 10, 8, -121, 24, 25, -110, -113, 28, 29, 30, 31}, {-128, -127, -126, -125, -124, -123, 23, 27, -120, -119, -118, -117, -116, 5, 6, 7}, {-112, -111, 22, -109, -108, -107, -106, 4, -104, -103, -102, -101, 20, 21, -98, 26}, {32, -96, -95, -94, -93, -92, -91, -90, -89, -88, -87, 46, 60, 40, 43, 124}, {38, -86, -85, -84, -83, -82, -81, -80, -79, -78, 33, 36, 42, 41, 59, 94}, {45, 47, -77, -76, -75, -74, -73, -72, -71, -70, -69, 44, 37, 95, 62, 63}, {-68, -67, -66, -65, -64, -63, -62, -61, -60, 96, 58, 35, 64, 39, 61, 34}, {-59, 97, 98, 99, 100, 101, 102, 103, 104, 105, -58, -57, -56, -55, -54, -53}, {-52, 106, 107, 108, 109, 110, 111, 112, 113, 114, -51, -50, -49, -48, -47, -46}, {-45, 126, 115, 116, 117, 118, 119, 120, 121, 122, -44, -43, -42, 88, -41, -40}, {-39, -38, -37, -36, -35, -34, -33, -32, -31, -30, -29, -28, -27, 93, -26, -25}, {123, 65, 66, 67, 68, 69, 70, 71, 72, 73, -24, -23, -22, -21, -20, -19}, {13, 74, 75, 76, 77, 78, 79, 80, 81, 82, -18, -17, -16, -15, -14, -13}, {92, -12, 83, 84, 85, 86, 87, 88, 89, 90, -11, -10, -9, -8, -7, -6}, {48, 49, 50, 51, 52, 53, 54, 55, 56, 57, -5, -4, -3, -2, -1, -97}};
    private static int[] m_byteLen = new int[]{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 2, 2, 3, 4};
    private static final String _Copyright_2007_Oracle_All_Rights_Reserved_ = null;
    public static final String BUILD_DATE = "Thu_Apr_04_15:09:24_PDT_2013";
    public static final boolean TRACE = false;

    CharacterSetUTFE(int var1) {
        super(var1);
        this.rep = 3;
    }

    public boolean isLossyFrom(CharacterSet var1) {
        return !var1.isUnicode();
    }

    public boolean isConvertibleFrom(CharacterSet var1) {
        boolean var2 = var1.rep <= 1024;
        return var2;
    }

    public boolean isUnicode() {
        return true;
    }

    public String toString(byte[] var1, int var2, int var3) throws SQLException {
        char[] var4 = new char[var1.length];
        int var5 = this.UTFEToJavaChar(var1, var2, var3, var4, CharacterConverterBehavior.REPORT_ERROR);
        return new String(var4, 0, var5);
    }

    public String toStringWithReplacement(byte[] var1, int var2, int var3) {
        try {
            char[] var4 = new char[var1.length];
            int var5 = this.UTFEToJavaChar(var1, var2, var3, var4, CharacterConverterBehavior.REPLACEMENT);
            return new String(var4, 0, var5);
        } catch (SQLException var6) {
            throw new IllegalStateException(var6.getMessage());
        }
    }

    int UTFEToJavaChar(byte[] var1, int var2, int var3, char[] var4, CharacterConverterBehavior var5) throws SQLException {
        int var6 = var2;
        int var7 = var2 + var3;
        int var8 = 0;

        while(true) {
            while(true) {
                while(var6 < var7) {
                    byte var9 = utfe2utf8m[high(var1[var6])][low(var1[var6++])];
                    byte var10;
                    byte var11;
                    switch(var9 >>> 4 & 15) {
                        case 0:
                        case 1:
                        case 2:
                        case 3:
                        case 4:
                        case 5:
                        case 6:
                        case 7:
                            var4[var8++] = (char)(var9 & 127);
                            break;
                        case 8:
                        case 9:
                            var4[var8++] = (char)(var9 & 31);
                            break;
                        case 10:
                        case 11:
                        default:
                            var5.onFailConversion();
                            var4[var8++] = '�';
                            break;
                        case 12:
                        case 13:
                            if (var6 >= var7) {
                                var5.onFailConversion();
                                var6 = var7;
                            } else {
                                var9 = (byte)(var9 & 31);
                                var10 = utfe2utf8m[high(var1[var6])][low(var1[var6++])];
                                if (!is101xxxxx(var10)) {
                                    var5.onFailConversion();
                                    var4[var8++] = '�';
                                } else {
                                    var4[var8++] = (char)(var9 << 5 | var10 & 31);
                                }
                            }
                            break;
                        case 14:
                            if (var6 + 1 >= var7) {
                                var5.onFailConversion();
                                var6 = var7;
                            } else {
                                var9 = (byte)(var9 & 15);
                                var10 = utfe2utf8m[high(var1[var6])][low(var1[var6++])];
                                var11 = utfe2utf8m[high(var1[var6])][low(var1[var6++])];
                                if (is101xxxxx(var10) && is101xxxxx(var11)) {
                                    var4[var8++] = (char)(var9 << 10 | (var10 & 31) << 5 | var11 & 31);
                                    continue;
                                }

                                var5.onFailConversion();
                                var4[var8++] = '�';
                            }
                            break;
                        case 15:
                            if (var6 + 2 >= var7) {
                                var5.onFailConversion();
                                var6 = var7;
                            } else {
                                var9 = (byte)(var9 & 1);
                                var10 = utfe2utf8m[high(var1[var6])][low(var1[var6++])];
                                var11 = utfe2utf8m[high(var1[var6])][low(var1[var6++])];
                                byte var12 = utfe2utf8m[high(var1[var6])][low(var1[var6++])];
                                if (is101xxxxx(var10) && is101xxxxx(var11) && is101xxxxx(var12)) {
                                    var4[var8++] = (char)(var9 << 15 | (var10 & 31) << 10 | (var11 & 31) << 5 | var12 & 31);
                                } else {
                                    var5.onFailConversion();
                                    var4[var8++] = '�';
                                }
                            }
                    }
                }

                return var8;
            }
        }
    }

    public byte[] convertWithReplacement(String var1) {
        char[] var2 = var1.toCharArray();
        byte[] var3 = new byte[var2.length * 4];
        int var4 = this.javaCharsToUTFE(var2, 0, var2.length, var3, 0);
        byte[] var5 = new byte[var4];
        System.arraycopy(var3, 0, var5, 0, var4);
        return var5;
    }

    public byte[] convert(String var1) throws SQLException {
        return this.convertWithReplacement(var1);
    }

    public byte[] convert(CharacterSet var1, byte[] var2, int var3, int var4) throws SQLException {
        byte[] var5;
        if (var1.rep == 3) {
            var5 = useOrCopy(var2, var3, var4);
        } else {
            String var6 = var1.toString(var2, var3, var4);
            var5 = this.convert(var6);
        }

        return var5;
    }

    int javaCharsToUTFE(char[] var1, int var2, int var3, byte[] var4, int var5) {
        int var6 = var2 + var3;
        int var8 = 0;

        for(int var9 = var2; var9 < var6; ++var9) {
            char var10 = var1[var9];
            int var7;
            if (var10 <= 31) {
                var7 = var10 | 128;
                var4[var8++] = utf8m2utfe[high(var7)][low(var7)];
            } else if (var10 <= 127) {
                var4[var8++] = utf8m2utfe[high(var10)][low(var10)];
            } else if (var10 <= 1023) {
                var7 = (var10 & 992) >> 5 | 192;
                var4[var8++] = utf8m2utfe[high(var7)][low(var7)];
                var7 = var10 & 31 | 160;
                var4[var8++] = utf8m2utfe[high(var7)][low(var7)];
            } else if (var10 <= 16383) {
                var7 = (var10 & 15360) >> 10 | 224;
                var4[var8++] = utf8m2utfe[high(var7)][low(var7)];
                var7 = (var10 & 992) >> 5 | 160;
                var4[var8++] = utf8m2utfe[high(var7)][low(var7)];
                var7 = var10 & 31 | 160;
                var4[var8++] = utf8m2utfe[high(var7)][low(var7)];
            } else {
                var7 = (var10 & '耀') >> 15 | 240;
                var4[var8++] = utf8m2utfe[high(var7)][low(var7)];
                var7 = (var10 & 31744) >> 10 | 160;
                var4[var8++] = utf8m2utfe[high(var7)][low(var7)];
                var7 = (var10 & 992) >> 5 | 160;
                var4[var8++] = utf8m2utfe[high(var7)][low(var7)];
                var7 = var10 & 31 | 160;
                var4[var8++] = utf8m2utfe[high(var7)][low(var7)];
            }
        }

        return var8;
    }

    int decode(CharacterWalker var1) throws SQLException {
        byte[] var2 = var1.bytes;
        int var3 = var1.next;
        int var4 = var1.end;
        byte var5 = 0;
        if (var3 >= var4) {
            failUTFConversion();
        }

        byte var6 = var2[var3];
        int var7 = getUTFByteLength((byte)var6);
        if (var7 == 0 || var3 + (var7 - 1) >= var4) {
            failUTFConversion();
        }

        try {
            char[] var8 = new char[2];
            int var9 = this.UTFEToJavaChar(var2, var3, var7, var8, CharacterConverterBehavior.REPORT_ERROR);
            var1.next += var7;
            return var9 == 1 ? var8[0] : var8[0] << 16 | var8[1];
        } catch (SQLException var10) {
            failUTFConversion();
            var1.next = var3;
            return var5;
        }
    }

    void encode(CharacterBuffer var1, int var2) throws SQLException {
        if ((var2 & -65536) != 0) {
            failUTFConversion();
        } else {
            int var3;
            if (var2 <= 31) {
                need(var1, 1);
                var3 = var2 | 128;
                var1.bytes[var1.next++] = utf8m2utfe[high(var3)][low(var3)];
            } else if (var2 <= 127) {
                need(var1, 1);
                var1.bytes[var1.next++] = utf8m2utfe[high(var2)][low(var2)];
            } else if (var2 <= 1023) {
                need(var1, 2);
                var3 = (var2 & 992) >> 5 | 192;
                var1.bytes[var1.next++] = utf8m2utfe[high(var3)][low(var3)];
                var3 = var2 & 31 | 160;
                var1.bytes[var1.next++] = utf8m2utfe[high(var3)][low(var3)];
            } else if (var2 <= 16383) {
                need(var1, 3);
                var3 = (var2 & 15360) >> 10 | 224;
                var1.bytes[var1.next++] = utf8m2utfe[high(var3)][low(var3)];
                var3 = (var2 & 992) >> 5 | 160;
                var1.bytes[var1.next++] = utf8m2utfe[high(var3)][low(var3)];
                var3 = var2 & 31 | 160;
                var1.bytes[var1.next++] = utf8m2utfe[high(var3)][low(var3)];
            } else {
                need(var1, 4);
                var3 = (var2 & '耀') >> 15 | 240;
                var1.bytes[var1.next++] = utf8m2utfe[high(var3)][low(var3)];
                var3 = (var2 & 31744) >> 10 | 160;
                var1.bytes[var1.next++] = utf8m2utfe[high(var3)][low(var3)];
                var3 = (var2 & 992) >> 5 | 160;
                var1.bytes[var1.next++] = utf8m2utfe[high(var3)][low(var3)];
                var3 = var2 & 31 | 160;
                var1.bytes[var1.next++] = utf8m2utfe[high(var3)][low(var3)];
            }
        }

    }

    private static int high(int var0) {
        return var0 >> 4 & 15;
    }

    private static int low(int var0) {
        return var0 & 15;
    }

    private static boolean is101xxxxx(byte var0) {
        return (var0 & -32) == -96;
    }

    private static int getUTFByteLength(byte var0) {
        return m_byteLen[utfe2utf8m[high(var0)][low(var0)] >>> 4 & 15];
    }
}
