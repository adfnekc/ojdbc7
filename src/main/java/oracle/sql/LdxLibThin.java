//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package oracle.sql;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.DateFormatSymbols;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.Locale.Category;
import oracle.core.lmx.CoreException;

class LdxLibThin implements LdxLib {
    private static final int LDXFDLSZ = 50;
    private static final byte LDX_CC = 1;
    private static final byte LDX_SCC = 2;
    private static final byte LDX_I = 3;
    private static final byte LDX_Y = 4;
    private static final byte LDX_IY = 5;
    private static final byte LDX_YY = 6;
    private static final byte LDX_IYY = 7;
    private static final byte LDX_YYY = 8;
    private static final byte LDX_IYYY = 9;
    private static final byte LDX_YYYY = 10;
    private static final byte LDX_YCYYY = 11;
    private static final byte LDX_SYYYY = 12;
    private static final byte LDX_SYCYYY = 13;
    private static final byte LDX_YEAR = 14;
    private static final byte LDX_SYEAR = 15;
    private static final byte LDX_Q = 16;
    private static final byte LDX_MM = 17;
    private static final byte LDX_IW = 18;
    private static final byte LDX_WW = 19;
    private static final byte LDX_W = 20;
    private static final byte LDX_D = 21;
    private static final byte LDX_DD = 22;
    private static final byte LDX_DDD = 23;
    private static final byte LDX_HH24 = 24;
    private static final byte LDX_HH = 25;
    private static final byte LDX_MI = 26;
    private static final byte LDX_SS = 27;
    private static final byte LDX_SSSSS = 28;
    private static final byte LDX_J = 29;
    private static final byte LDX_MONTH = 30;
    private static final byte LDX_MON = 31;
    private static final byte LDX_DAY = 32;
    private static final byte LDX_DY = 33;
    private static final byte LDX_AMPM = 34;
    private static final byte LDX_A_M_P_M = 35;
    private static final byte LDX_BCAD = 36;
    private static final byte LDX_B_C_A_D = 37;
    private static final byte LDX_RM = 38;
    private static final byte LDX_FM = 39;
    private static final byte LDX_RR = 40;
    private static final byte LDX_RRRR = 41;
    private static final byte LDX_FX = 42;
    private static final byte LDX_E = 43;
    private static final byte LDX_EE = 44;
    private static final byte LDX_LIT = 45;
    private static final byte LDX_JUS = 16;
    private static final byte LDX_NTH = 1;
    private static final byte LDX_SPL = 2;
    private static final byte LDX_CAP = 4;
    private static final byte LDX_UPR = 8;
    private static final byte LDX_QUO = 1;
    private static final byte LDX_SPA = 2;
    private static final byte LDX_PUN = 4;
    private static final byte LDX_ALPHA = -128;
    private static final byte LDXFNJUS = 64;
    private static final byte LDX_NEG = 32;
    private static final byte LDX_COMMA = 16;
    private static final byte LDX_LEN = 15;
    private static final byte LDXFL_NOT = 0;
    private static final byte LDXFL_FLEX = 1;
    private static final byte LDXFL_STD = 2;
    private static final byte LDXFL_MDONE = 4;
    private static final byte LDXFL_YDONE = 8;
    private static final byte LDXFL_PUNC = 16;
    private static final byte LDXFL_MSEC = 32;
    private static final int LDXSBUFFERSIZE = 64;
    private static final int LDXWBUFSIZE = 64;
    private static final int LDXTCE = 0;
    private static final int LDXTYE = 1;
    private static final int LDXTMO = 2;
    private static final int LDXTDA = 3;
    private static final int LDXTHO = 4;
    private static final int LDXTMI = 5;
    private static final int LDXTSO = 6;
    private static final int LDXTSIZ = 7;
    private static final int LDX_SUNDAY = 2445029;
    private static final int LDXPMXYR = 9999;
    private static final int LDXPMNYR = -4712;
    private static final char[][] ldxfda = new char[][]{{'A', '.', 'D', '.'}, {'A', '.', 'M', '.'}, {'A', 'D'}, {'A', 'M'}, {'B', '.', 'C', '.'}, {'B', 'C'}, {'C', 'C'}, {'D'}, {'D', 'A', 'Y'}, {'D', 'D'}, {'D', 'D', 'D'}, {'D', 'Y'}, {'E'}, {'E', 'E'}, {'F', 'M'}, {'F', 'X'}, {'H', 'H'}, {'H', 'H', '1', '2'}, {'H', 'H', '2', '4'}, {'I'}, {'I', 'W'}, {'I', 'Y'}, {'I', 'Y', 'Y'}, {'I', 'Y', 'Y', 'Y'}, {'J'}, {'M', 'I'}, {'M', 'M'}, {'M', 'O', 'N'}, {'M', 'O', 'N', 'T', 'H'}, {'P', '.', 'M', '.'}, {'P', 'M'}, {'Q'}, {'R', 'M'}, {'R', 'R'}, {'R', 'R', 'R', 'R'}, {'S', 'C', 'C'}, {'S', 'S'}, {'S', 'S', 'S', 'S', 'S'}, {'S', 'Y', ',', 'Y', 'Y', 'Y'}, {'S', 'Y', 'E', 'A', 'R'}, {'S', 'Y', 'Y', 'Y', 'Y'}, {'W'}, {'W', 'W'}, {'Y'}, {'Y', ',', 'Y', 'Y', 'Y'}, {'Y', 'E', 'A', 'R'}, {'Y', 'Y'}, {'Y', 'Y', 'Y'}, {'Y', 'Y', 'Y', 'Y'}, {'\u0000'}};
    private static final byte[] ldxfdc = new byte[]{37, 35, 36, 34, 37, 36, 1, 21, 32, 22, 23, 33, 43, 44, 39, 42, 25, 25, 24, 3, 18, 5, 7, 9, 29, 26, 17, 31, 30, 35, 34, 16, 38, 40, 41, 2, 27, 28, 13, 15, 12, 20, 19, 4, 11, 14, 6, 8, 10, 0};
    private static final byte[] ldxfcdlen = new byte[]{0, 2, 35, 1, 1, 2, 2, 3, 3, 4, 4, 21, 37, 54, -60, -27, 1, 2, 2, 2, 1, 1, 2, 3, 2, 2, 2, 2, 5, 7, -128, -128, -128, -128, -62, -60, -62, -60, -124, 0, 2, 4, 0, -113, -98, -128, -128};
    private static int[] ldxfdi = new int[]{0, 4, 6, 7, 12, 14, -2147483648, 16, 19, 24, -2147483648, -2147483648, 25, -2147483648, -2147483648, 29, 31, 32, 35, -2147483648, -2147483648, -2147483648, 41, -2147483648, 43, -2147483648};
    private static final char[][] ldxfdx = new char[][]{{'S', 'P'}, {'S', 'P', 'T', 'H'}, {'T', 'H'}, {'T', 'H', 'S', 'P'}, {'\u0000'}};
    private static final byte[] ldxfdxc = new byte[]{2, 3, 1, 3, 0};
    private static final byte[] NULLFMT = new byte[]{0, 16};
    private static final byte[] DEFAULT_FORMAT = new byte[]{22, 24, 46, 4, 47, 31, 24, 46, 4, 47, 10, 24};
    private static final String[] ldxpaa = new String[]{"A.D.", "A.M.", "B.C.", "P.M."};
    private static final int[] ldxdom = new int[]{0, 0, 31, 59, 90, 120, 151, 181, 212, 243, 273, 304, 334, 365};
    private final byte[][] ldxpmxa = new byte[][]{{23, 29}, {4, 6, 8, 10, 12, 11, 13}, {25, 24}, {34, 35}, {36, 37}, {30, 31, 17, 38}, {32, 33, 21}, {34, 35, 24}, {12, 13, 36, 37}};

    LdxLibThin() {
    }

    public byte[] ldxadm(byte[] var1, int var2) throws SQLException {
        int var4 = ((var1[0] & 255) - 100) * 100 + ((var1[1] & 255) - 100);
        int var5 = var1[2] & 255;
        int var6 = var1[3] & 255;
        var2 += (var1[2] & 255) + var4 * 12;
        int var3;
        if (var2 > 0) {
            if ((var3 = var2 / 12) > 9999) {
                throw new SQLException(CoreException.getMessage((byte)8));
            }

            if ((var2 %= 12) == 0) {
                --var3;
                var2 = 12;
            }
        } else {
            if ((var3 = var2 / 12 - 1) < -4712) {
                throw new SQLException(CoreException.getMessage((byte)8));
            }

            var2 = var2 % 12 + 12;
        }

        int var8 = var2 == 2 && this.ldxisl(var4) ? 29 : ldxdom[var5 + 1] - ldxdom[var5];
        var1[0] = (byte)(var3 / 100 + 100);
        var1[1] = (byte)(var3 % 100 + 100);
        var1[2] = (byte)var2;
        int var7 = var2 == 2 && this.ldxisl(var3) ? 29 : ldxdom[var2 + 1] - ldxdom[var2];
        var1[3] = (byte)(var6 != var8 && var6 <= var7 ? var6 : var7);
        return var1;
    }

    public byte[] ldxads(byte[] var1, int var2, int var3) throws SQLException {
        if (var3 != 0) {
            var3 += ((var1[4] - 1) * 60 + (var1[5] - 1)) * 60 + (var1[6] - 1);
            var2 += var3 / 86400;
            if ((var3 %= 86400) < 0) {
                var3 += 86400;
                --var2;
            }

            var1[4] = (byte)(var3 / 3600 + 1);
            var1[5] = (byte)(var3 % 3600 / 60 + 1);
            var1[6] = (byte)(var3 % 3600 % 60 + 1);
        }

        int var5 = ((var1[0] & 255) - 100) * 100 + ((var1[1] & 255) - 100);
        if (var2 != 0) {
            var2 += this.ldxctj(var5, var1[2], var1[3]);
            if (var2 < 1) {
                throw new SQLException(CoreException.getMessage((byte)8));
            }

            var1 = this.ldxjtc(var2, var1);
        }

        var5 = ((var1[0] & 255) - 100) * 100 + ((var1[1] & 255) - 100);
        if (var5 > 9999) {
            throw new SQLException(CoreException.getMessage((byte)8));
        } else {
            return var1;
        }
    }

    public int ldxchk(byte[] var1) throws SQLException {
        throw new SQLException(CoreException.getMessage((byte)1));
    }

    public byte[] ldxdfd(int var1, int var2) throws SQLException {
        throw new SQLException(CoreException.getMessage((byte)1));
    }

    public void ldxdtd(byte[] var1, int[] var2, int[] var3) throws SQLException {
        throw new SQLException(CoreException.getMessage((byte)1));
    }

    public String ldxdts(byte[] var1, String var2, String var3) throws SQLException {
        return this.ldxdts(var1, this.ldxsto(var2, var3), var3);
    }

    public String ldxdts(byte[] var1, byte[] var2, String var3) throws SQLException {
        boolean var4 = false;
        boolean var6 = false;
        int var7 = 0;
        boolean var9 = false;
        boolean var11 = false;
        int var12 = 0;
        String var13 = null;
        StringBuffer var16 = new StringBuffer(64);
        StringBuffer var17 = null;
        if (var2.length == 0 || var2 == null || var2[0] == 0 && var2[1] == 16) {
            var2 = DEFAULT_FORMAT;
        }

        int var8 = var2.length;
        Locale var15;
        if (var3 != null && var3.compareTo("") != 0) {
            var12 = var3.indexOf("_");
            if (var12 == -1) {
                var15 = LxMetaData.getJavaLocale(var3, "");
            } else {
                String var20 = var3.substring(0, var12);
                String var21 = var3.substring(var12 + 1);
                var15 = LxMetaData.getJavaLocale(var20, var21);
            }

            if (var15 == null) {
                var15 = Locale.getDefault(Category.FORMAT);
            }
        } else {
            var15 = Locale.getDefault(Category.FORMAT);
        }

        int var30 = ((var1[0] & 255) - 100) * 100 + ((var1[1] & 255) - 100);

        while(true) {
            if (var7 < var8) {
                int var28 = var2[var7++];
                byte var29 = var2[var7++];
                if (var28 != 0) {
                    if (var28 >= 45) {
                        int var10 = var28 - 45;
                        var16.append(new String(var2, var7, var10));
                        var7 += var10;
                        continue;
                    }

                    byte var5 = ldxfcdlen[var28];
                    StringBuffer var18;
                    if (((var5 & -128) == 0 || (var29 & 12) == 0) && ((var29 & 16) == 0 || (var5 & 64) != 0) && ((var29 & 12) == 0 || (var29 & 3) == 0)) {
                        var18 = var16;
                    } else {
                        var17 = new StringBuffer(64);
                        var18 = var17;
                    }

                    int var14;
                    int var19;
                    switch(var28) {
                        case 1:
                        case 2:
                            if (var30 > 0) {
                                var12 = (var30 - 1) / 100 + 1;
                            } else {
                                var12 = -((-1 - var30) / 100) - 1;
                            }
                            break;
                        case 3:
                            throw new SQLException(CoreException.getMessage((byte)1));
                        case 4:
                            var12 = var30 % 10;
                            break;
                        case 5:
                            throw new SQLException(CoreException.getMessage((byte)1));
                        case 6:
                        case 40:
                            var12 = var30 % 100;
                            break;
                        case 7:
                            throw new SQLException(CoreException.getMessage((byte)1));
                        case 8:
                            var12 = var30 % 1000;
                            break;
                        case 9:
                            throw new SQLException(CoreException.getMessage((byte)1));
                        case 10:
                        case 11:
                        case 12:
                        case 13:
                        case 41:
                            var12 = var30;
                            break;
                        case 14:
                        case 15:
                            throw new SQLException(CoreException.getMessage((byte)1));
                        case 16:
                            var12 = (var1[2] + 2) / 3;
                            break;
                        case 17:
                            var12 = var1[2];
                            break;
                        case 18:
                            throw new SQLException(CoreException.getMessage((byte)1));
                        case 19:
                            var12 = (this.ldxcty(var30, var1[2], var1[3]) + 6) / 7;
                            break;
                        case 20:
                            var12 = (var1[3] + 6) / 7;
                            break;
                        case 21:
                            var12 = this.ldxdow(var30, var1[2], var1[3], var15);
                            break;
                        case 22:
                            var12 = var1[3];
                            break;
                        case 23:
                            var12 = this.ldxcty(var30, var1[2], var1[3]);
                            break;
                        case 24:
                        case 25:
                            var12 = var1[4] - 1;
                            if (var28 == 25) {
                                var12 = var12 > 12 ? var12 - 12 : (var12 == 0 ? 12 : var12);
                            }
                            break;
                        case 26:
                            var12 = var1[5] - 1;
                            break;
                        case 27:
                            var12 = var1[6] - 1;
                            break;
                        case 28:
                            var12 = ((var1[4] - 1) * 60 + (var1[5] - 1)) * 60 + (var1[6] - 1);
                            break;
                        case 29:
                            var12 = this.ldxctj(var30, var1[2], var1[3]);
                            break;
                        case 30:
                        case 31:
                            byte var31 = var1[2];
                            String[] var24;
                            if (var28 == 30) {
                                var24 = (new DateFormatSymbols(var15)).getMonths();
                            } else {
                                var24 = (new DateFormatSymbols(var15)).getShortMonths();
                            }

                            var12 = var31 - 1;
                            var18.append(var24[var12]);
                            var14 = var18.length();
                            break;
                        case 32:
                        case 33:
                            var19 = this.ldxdow(var30, var1[2], var1[3], var15);
                            Calendar var22 = GregorianCalendar.getInstance(var15);
                            if (var22.getFirstDayOfWeek() > 1) {
                                ++var19;
                            }

                            if (var19 > 7) {
                                var19 -= 7;
                            }

                            if (var19 == 0) {
                                ++var19;
                            }

                            String[] var23;
                            if (var28 == 32) {
                                var23 = (new DateFormatSymbols(var15)).getWeekdays();
                            } else {
                                var23 = (new DateFormatSymbols(var15)).getShortWeekdays();
                            }

                            var18.append(var23[var19]);
                            var14 = var18.length();
                            break;
                        case 35:
                            if (var15.getCountry().compareTo("US") == 0 && var15.getLanguage().compareTo("en") == 0) {
                                var13 = var1[4] - 1 >= 12 ? ldxpaa[3] : ldxpaa[1];
                                break;
                            } else {
                                --var28;
                            }
                        case 34:
                            var18.append((new DateFormatSymbols(var15)).getAmPmStrings()[var1[4] - 1 >= 12 ? 1 : 0]);
                            var14 = var18.length();
                            break;
                        case 37:
                            if (var15.getCountry().compareTo("US") == 0 && var15.getLanguage().compareTo("en") == 0) {
                                var13 = var1[0] < 100 ? ldxpaa[2] : ldxpaa[0];
                                break;
                            } else {
                                --var28;
                            }
                        case 36:
                            var18.append((new DateFormatSymbols(var15)).getEras()[var1[0] < 100 ? 0 : 1]);
                            var14 = var18.length();
                            break;
                        case 38:
                            throw new SQLException(CoreException.getMessage((byte)1));
                        case 39:
                        default:
                            throw new SQLException(CoreException.getMessage((byte)7));
                        case 42:
                            continue;
                        case 43:
                        case 44:
                            throw new SQLException(CoreException.getMessage((byte)1));
                    }

                    if ((var5 & -128) == 0) {
                        if ((var5 & 32) == 0) {
                            if (var12 < 0) {
                                var12 = -var12;
                            }
                        } else if (var12 >= 0) {
                            var18.insert(0, " ");
                            --var5;
                        }

                        if ((var29 & 2) != 0) {
                            throw new SQLException(CoreException.getMessage((byte)1));
                        }

                        if ((var29 & 16) != 0) {
                            var14 = var5 & 15;
                        } else {
                            var14 = 0;
                        }

                        String var25 = this.lxi42b(64, (long)var12, var14, (var5 & 16) != 0, var15);
                        var18.append(var25);
                        if ((var29 & 1) != 0) {
                            throw new SQLException(CoreException.getMessage((byte)1));
                        }
                    } else if ((var29 & 16) != 0 && (var5 & 64) == 0) {
                        String[] var26;
                        switch(var28) {
                            case 30:
                                var26 = (new DateFormatSymbols(var15)).getMonths();
                                break;
                            case 31:
                                var26 = (new DateFormatSymbols(var15)).getShortMonths();
                                break;
                            case 32:
                                var26 = (new DateFormatSymbols(var15)).getWeekdays();
                                break;
                            case 33:
                                var26 = (new DateFormatSymbols(var15)).getShortWeekdays();
                                break;
                            default:
                                throw new SQLException(CoreException.getMessage((byte)7));
                        }

                        var19 = 0;

                        int var27;
                        for(var27 = 0; var27 < var26.length; ++var27) {
                            var12 = var26[var27].length();
                            if (var12 > var19) {
                                var19 = var12;
                            }
                        }

                        var19 -= var18.length();

                        for(var27 = 0; var27 < var19; ++var27) {
                            var18.append(" ");
                        }
                    }

                    if (var13 != null) {
                        boolean var32 = true;
                        if ((var29 & 12) == 0) {
                            var18 = var16;
                        }

                        var18.append(var13.toLowerCase(var15));
                        var13 = null;
                    }

                    if ((var29 & 4) != 0) {
                        if (Character.isLowerCase(var18.charAt(0))) {
                            var18.setCharAt(0, Character.toUpperCase(var18.charAt(0)));
                        }

                        var16.append(var18.toString());
                    } else if ((var29 & 8) != 0) {
                        var16.append(var18.toString().toUpperCase());
                    } else if (var18 != var16) {
                        var16.append(var18.toString());
                    }
                    continue;
                }
            }

            return var16.toString();
        }
    }

    private int ldxdow(int var1, int var2, int var3, Locale var4) {
        Calendar var7 = GregorianCalendar.getInstance(var4);
        int var5 = this.ldxctj(var1, var2, var3);
        int var6 = (var5 - (2445029 + (var7.getFirstDayOfWeek() - 1))) % 7;
        if (var6 < 0) {
            var6 += 7;
        }

        return var6 + 1;
    }

    private int ldxctj(int var1, int var2, int var3) {
        int var4;
        if (var1 == -4712) {
            var4 = 0;
        } else {
            var4 = var1 + 4712;
            var4 = 365 * var4 + (var4 - 1) / 4;
        }

        if (var1 >= 1583) {
            var4 = var4 - 10 - (var1 - 1501) / 100 + (var1 - 1201) / 400;
        }

        var4 += this.ldxcty(var1, var2, var3);
        if (var1 == 1582 && (var2 == 10 && var3 >= 15 || var2 >= 11)) {
            var4 -= 10;
        }

        return var4;
    }

    private byte[] ldxjtc(int var1, byte[] var2) throws SQLException {
        if (var1 < 1) {
            throw new SQLException(CoreException.getMessage((byte)10));
        } else {
            if (var1 < 366) {
                var2[0] = 53;
                var2[1] = 28;
                var2 = this.ldxdyc(-4712, var1, var2);
            } else {
                int var3;
                int var4;
                int var5;
                if (var1 < 2299161) {
                    var1 -= 366;
                    var5 = -4711 + var1 / 1461 * 4;
                    var1 %= 1461;
                    var3 = var1 / 365;
                    var4 = var1 % 365;
                    if (var4 == 0 && var3 == 4) {
                        var4 = 366;
                        var3 = 3;
                    } else {
                        ++var4;
                    }

                    var5 += var3;
                    var2 = this.ldxdyc(var5, var4, var2);
                    var2[0] = (byte)(var5 / 100 + 100);
                    var2[1] = (byte)(var5 % 100 + 100);
                } else {
                    var1 = 4 * (var1 - 1721119) - 1;
                    var5 = var1 / 146097;
                    var1 %= 146097;
                    var4 = var1 / 4;
                    var1 = 4 * var4 + 3;
                    var4 = var1 % 1461;
                    var1 /= 1461;
                    var4 /= 4;
                    ++var4;
                    var3 = 5 * var4 - 3;
                    var4 = var3 % 153;
                    var3 /= 153;
                    var4 /= 5;
                    ++var4;
                    var5 *= 100;
                    var5 += var1;
                    if (var3 < 10) {
                        var3 += 3;
                    } else {
                        var3 -= 9;
                        ++var5;
                    }

                    var2[3] = (byte)var4;
                    var2[2] = (byte)var3;
                    var2[0] = (byte)(var5 / 100 + 100);
                    var2[1] = (byte)(var5 % 100 + 100);
                }
            }

            return var2;
        }
    }

    private byte[] ldxdyc(int var1, int var2, byte[] var3) throws SQLException {
        boolean var6 = this.ldxisl(var1);
        if (var2 == 366 && !var6) {
            throw new SQLException(CoreException.getMessage((byte)9));
        } else {
            int var4 = var2;
            if (var2 > 59 + (var6 ? 1 : 0)) {
                var4 = var2 + (2 - (var6 ? 1 : 0));
            }

            var4 += 91;
            int var5 = var4 * 100;
            var3[3] = (byte)(var4 - (var5 - var5 % 3055) / 100);
            var3[2] = (byte)(var5 / 3055 - 2);
            return var3;
        }
    }

    private int ldxcty(int var1, int var2, int var3) {
        return ldxdom[var2] + var3 + (var2 >= 3 && this.ldxisl(var1) ? 1 : 0);
    }

    private boolean ldxisl(int var1) {
        boolean var10000;
        label28: {
            if (var1 % 4 == 0) {
                if (var1 <= 1582) {
                    if (var1 != -4712) {
                        break label28;
                    }
                } else if (var1 % 100 != 0 || var1 % 400 == 0) {
                    break label28;
                }
            }

            var10000 = false;
            return var10000;
        }

        var10000 = true;
        return var10000;
    }

    private String lxi42b(int var1, long var2, int var4, boolean var5, Locale var6) throws SQLException {
        int var7 = 0;
        boolean var8 = false;
        long var9 = var2;
        NumberFormat var11 = NumberFormat.getInstance(var6);
        DecimalFormat var12 = (DecimalFormat)var11;
        StringBuffer var13 = new StringBuffer();
        int var14 = var12.getGroupingSize();
        char var15 = 0;
        char var16 = var12.getDecimalFormatSymbols().getZeroDigit();

        int var17;
        for(var17 = 1; (var9 /= 10L) != 0L; ++var17) {
        }

        if (var2 < 0L) {
            ++var17;
        }

        if (var5) {
            var17 += (var17 - 1) / var14;
        }

        if (!var5) {
            var11.setGroupingUsed(false);
        }

        var13.append(var12.format(var2));
        if (var17 > var1 || var4 > var1 || var4 != 0 && var17 > var4) {
            throw new SQLException(CoreException.getMessage((byte)3));
        } else {
            if (var5) {
                var15 = var12.getDecimalFormatSymbols().getGroupingSeparator();
            }

            if (var4 != 0) {
                for(var4 -= var17; var4-- != 0; var13.insert(0, var16)) {
                    if (var5 && var7++ == var14 && var4 != 0) {
                        var13.insert(0, var15);
                        var7 = 1;
                        --var4;
                    }
                }
            }

            return var13.toString();
        }
    }

    public byte[] ldxsto(String var1, String var2) throws SQLException {
        int var3 = 0;
        int var4 = 0;
        byte var6 = 0;
        byte[] var7 = new byte[512];
        boolean var8 = true;
        byte var9 = 0;
        boolean var10 = false;
        char[] var11 = new char[256];
        boolean var12 = false;
        boolean var15 = false;
        if (var1 != null && var1.compareTo("") != 0) {
            int var5 = var1.length();

            byte[] var26;
            label213:
            while(var3 < var5) {
                int var22 = 16;
                int var23 = 0;

                while(var3 >= var5 || var1.charAt(var3) != '|') {
                    int var24 = 0;

                    while(true) {
                        while(var3 < var5 && !Character.isLetterOrDigit(var1.charAt(var3))) {
                            if (var1.charAt(var3) == '"') {
                                for(var9 = 1; var3 != var5; ++var24) {
                                    ++var3;
                                    if (var1.charAt(var3) == '"') {
                                        break;
                                    }

                                    var11[var23++] = var1.charAt(var3);
                                }

                                if (var1.charAt(var3) == '"') {
                                    ++var3;
                                }
                            } else {
                                var11[var23++] = var1.charAt(var3++);
                                ++var24;
                            }
                        }

                        label206: {
                            int var16;
                            int var19;
                            if (var24 > 0) {
                                if (var24 > 210) {
                                    throw new SQLException(CoreException.getMessage((byte)7));
                                }

                                if (!Character.isWhitespace(var11[0])) {
                                    var23 = 0;
                                } else {
                                    int var20 = 0;
                                    var16 = var24;

                                    for(var19 = 0; var16 > 0 && Character.isWhitespace(var11[var20]); --var16) {
                                        ++var20;
                                        ++var19;
                                    }

                                    var7[var4++] = (byte)(45 + var19);
                                    var7[var4++] = 2;
                                    byte[] var21 = (new String(var11, 0, var19)).getBytes();
                                    System.arraycopy(var21, 0, var7, var4, var21.length);
                                    var4 += var21.length;
                                    var24 -= var19;
                                    if (var24 == 0) {
                                        break label206;
                                    }

                                    var3 += var19 + 1;
                                    var23 = var20;
                                }

                                if (var9 != 1) {
                                    var9 = 4;
                                }

                                var7[var4++] = (byte)(45 + var24);
                                var7[var4++] = var9;
                                var26 = (new String(var11, 0, var24)).getBytes();
                                System.arraycopy(var26, 0, var7, var4, var26.length);
                                var4 += var26.length;
                            } else {
                                if (!Character.isLetterOrDigit(var1.charAt(var3))) {
                                    throw new SQLException(CoreException.getMessage((byte)7));
                                }

                                char var14 = Character.toUpperCase(var1.charAt(var3));
                                var16 = var14 - 65;
                                if (var16 > 25 || ldxfdi[var16] == -2147483648) {
                                    throw new SQLException(CoreException.getMessage((byte)7));
                                }

                                int var25 = ldxfdi[var16];

                                int var17;
                                int var18;
                                for(var16 = 50; var25 < ldxfda.length; ++var25) {
                                    var19 = ldxfda[var25].length;
                                    var17 = 0;

                                    for(var18 = var3; var17 < var19 && var18 < var5 && Character.toUpperCase(var1.charAt(var18)) == ldxfda[var25][var17]; ++var18) {
                                        ++var17;
                                    }

                                    if (var17 == var19) {
                                        var16 = var25;
                                    }

                                    if (ldxfda[var25 + 1][0] != var14) {
                                        break;
                                    }
                                }

                                if (var16 >= ldxfda.length) {
                                    throw new SQLException(CoreException.getMessage((byte)7));
                                }

                                if (var5 - var3 > 1 && Character.isUpperCase(var1.charAt(var3))) {
                                    var14 = Character.isLetterOrDigit(var1.charAt(var3 + 1)) ? var1.charAt(var3 + 1) : var1.charAt(var3 + 2);
                                    if (Character.isLowerCase(var14)) {
                                        var22 = (byte)(var22 | 4);
                                    } else {
                                        var22 = (byte)(var22 | 8);
                                    }
                                }

                                var3 += ldxfda[var16].length;
                                var6 = ldxfdc[var16];
                                if ((ldxfcdlen[var6] & -128) == 0) {
                                    var25 = 0;
                                    var17 = -1;

                                    while(true) {
                                        if (var25 >= ldxfdx.length) {
                                            if (var17 >= 0 && var17 < ldxfdx.length) {
                                                var22 |= ldxfdxc[var17];
                                                var3 += ldxfdx[var17].length;
                                            }
                                            break;
                                        }

                                        var19 = ldxfdx[var25].length;
                                        var16 = 0;

                                        for(var18 = var3; var16 < var19 && var18 < var5 && Character.toUpperCase(var1.charAt(var18)) == ldxfdx[var25][var16]; ++var18) {
                                            ++var16;
                                        }

                                        if (var16 == var19) {
                                            var17 = var25;
                                        }

                                        ++var25;
                                    }
                                }

                                if (512 - var4 < 2) {
                                    throw new SQLException(CoreException.getMessage((byte)7));
                                }

                                var7[var4++] = (byte)var6;
                                var7[var4++] = (byte)var22;
                            }

                            if (var6 == 39) {
                                var22 = (var22 & 16) == 1 ? 0 : 16;
                            }
                        }

                        if (var6 != 39) {
                            continue label213;
                        }
                        break;
                    }
                }

                ++var3;
            }

            var26 = new byte[var4];
            System.arraycopy(var7, 0, var26, 0, var26.length);
            return var26;
        } else {
            return NULLFMT;
        }
    }

    public byte[] ldxdyf(byte[] var1) throws SQLException {
        throw new SQLException(CoreException.getMessage((byte)1));
    }

    public void ldxftd(byte[] var1, int[] var2, int[] var3) throws SQLException {
        throw new SQLException(CoreException.getMessage((byte)1));
    }

    public byte[] ldxgdt() throws SQLException {
        throw new SQLException(CoreException.getMessage((byte)1));
    }

    public byte[] ldxldd(byte[] var1) throws SQLException {
        throw new SQLException(CoreException.getMessage((byte)1));
    }

    public byte[] ldxnxd(byte[] var1, int var2) throws SQLException {
        throw new SQLException(CoreException.getMessage((byte)1));
    }

    public byte[] ldxrnd(byte[] var1, String var2) throws SQLException {
        throw new SQLException(CoreException.getMessage((byte)1));
    }

    public byte[] ldxsbm(byte[] var1, byte[] var2) throws SQLException {
        throw new SQLException(CoreException.getMessage((byte)1));
    }

    public void ldxsub(byte[] var1, byte[] var2, int[] var3, int[] var4) throws SQLException {
        throw new SQLException(CoreException.getMessage((byte)1));
    }

    public byte[] ldxstd(String var1, String var2, String var3) throws SQLException {
        Object var4 = null;
        Object var5 = null;
        boolean var6 = false;
        boolean var7 = false;
        char[] var8 = new char[512];
        int var9 = 0;
        boolean var10 = false;
        int var11 = 0;
        boolean var12 = false;
        ParsePosition var13 = new ParsePosition(0);
        SimpleDateFormat var14 = new SimpleDateFormat();
        byte[] var17 = this.ldxsto(var2, var3);
        this.ldxsti(var17);
        int var20 = var17.length;

        String var22;
        label88:
        while(var9 < var20) {
            byte var18 = var17[var9++];
            byte var19 = var17[var9++];
            int var15;
            switch(var18) {
                case 4:
                    var8[var11++] = 'y';
                    break;
                case 5:
                case 7:
                case 9:
                case 14:
                case 15:
                case 16:
                case 18:
                case 19:
                case 20:
                default:
                    int var21 = var18 - 45;
                    var22 = new String(var17, var9, var21);
                    if (var19 == 1) {
                        var8[var11++] = '\'';
                        System.arraycopy(var22.toCharArray(), 0, var8, var11, var21);
                        var11 += var21;
                        var9 += var21;
                        var8[var11++] = '\'';
                    } else {
                        System.arraycopy(var22.toCharArray(), 0, var8, var11, var21);
                        var11 += var21;
                        var9 += var21;
                    }
                    break;
                case 6:
                    var15 = 0;

                    while(true) {
                        if (var15 >= 2) {
                            continue label88;
                        }

                        var8[var11++] = 'y';
                        ++var15;
                    }
                case 8:
                    var15 = 0;

                    while(true) {
                        if (var15 >= 3) {
                            continue label88;
                        }

                        var8[var11++] = 'y';
                        ++var15;
                    }
                case 10:
                    var15 = 0;

                    while(true) {
                        if (var15 >= 4) {
                            continue label88;
                        }

                        var8[var11++] = 'y';
                        ++var15;
                    }
                case 11:
                case 12:
                case 13:
                    throw new SQLException(CoreException.getMessage((byte)1));
                case 17:
                    var8[var11++] = 'M';
                    var8[var11++] = 'M';
                    break;
                case 21:
                case 33:
                    var8[var11++] = 'E';
                    break;
                case 22:
                    var8[var11++] = 'd';
                    break;
                case 23:
                    var8[var11++] = 'D';
                    break;
                case 24:
                    var8[var11++] = 'H';
                    break;
                case 25:
                    var8[var11++] = 'h';
                    break;
                case 26:
                    var8[var11++] = 'm';
                    break;
                case 27:
                    var8[var11++] = 's';
                    break;
                case 28:
                    throw new SQLException(CoreException.getMessage((byte)1));
                case 29:
                    throw new SQLException(CoreException.getMessage((byte)1));
                case 30:
                    var15 = 0;

                    while(true) {
                        if (var15 >= 4) {
                            continue label88;
                        }

                        var8[var11++] = 'M';
                        ++var15;
                    }
                case 31:
                    var15 = 0;

                    while(true) {
                        if (var15 >= 3) {
                            continue label88;
                        }

                        var8[var11++] = 'M';
                        ++var15;
                    }
                case 32:
                    var15 = 0;

                    while(true) {
                        if (var15 >= 4) {
                            continue label88;
                        }

                        var8[var11++] = 'E';
                        ++var15;
                    }
                case 34:
                case 35:
                    var8[var11++] = 'a';
                    break;
                case 36:
                case 37:
                    var8[var11++] = 'G';
                    break;
                case 38:
                    throw new SQLException(CoreException.getMessage((byte)1));
                case 39:
                case 42:
                    throw new SQLException(CoreException.getMessage((byte)1));
                case 40:
                    throw new SQLException(CoreException.getMessage((byte)1));
                case 41:
                    throw new SQLException(CoreException.getMessage((byte)1));
                case 43:
                case 44:
                    throw new SQLException(CoreException.getMessage((byte)1));
            }
        }

        var22 = new String(var8, 0, var11);
        var14.applyPattern(var22);
        var14.setLenient(false);
        Date var16 = var14.parse(var1, var13);
        if (var16 != null) {
            return DATE.toBytes(new Timestamp(var16.getTime()));
        } else {
            throw new SQLException(CoreException.getMessage((byte)6));
        }
    }

    public byte[] ldxtrn(byte[] var1, String var2) throws SQLException {
        throw new SQLException(CoreException.getMessage((byte)1));
    }

    private void ldxsti(byte[] var1) throws SQLException {
        int[] var2 = new int[46];

        int var3;
        for(var3 = 0; var3 < var1.length; var3 += 2) {
            if (var1[var3] < 45) {
                byte var10000 = var1[var3];
                if (var1[var3] != 42 && var1[var3] != 39 && var2[var1[var3]] != 0) {
                    throw new SQLException(CoreException.getMessage((byte)7));
                }

                ++var2[var1[var3]];
                switch(var1[var3]) {
                    case 1:
                    case 2:
                    case 3:
                    case 5:
                    case 7:
                    case 9:
                    case 14:
                    case 15:
                    case 16:
                    case 18:
                    case 19:
                    case 20:
                        throw new SQLException(CoreException.getMessage((byte)7));
                    case 4:
                    case 6:
                    case 8:
                    case 10:
                    case 11:
                    case 12:
                    case 13:
                    case 17:
                }
            } else {
                var3 += var1[var3] - 45;
            }
        }

        for(var3 = 0; var3 < this.ldxpmxa.length; ++var3) {
            int var4 = 0;

            for(int var5 = 0; var5 < this.ldxpmxa[var3].length; ++var5) {
                var4 += var2[this.ldxpmxa[var3][var5]];
            }

            if (var4 > 1) {
                throw new SQLException(CoreException.getMessage((byte)7));
            }
        }

    }
}
