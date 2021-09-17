//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package oracle.jdbc.driver;

import java.math.BigDecimal;
import java.sql.SQLException;
import oracle.core.lmx.CoreException;

class BigDecimalBinder extends VarnumBinder {
    private static final String _Copyright_2007_Oracle_All_Rights_Reserved_ = null;
    public static final String BUILD_DATE = "Thu_Apr_04_15:09:24_PDT_2013";
    public static final boolean TRACE = false;

    BigDecimalBinder() {
    }

    long bind(OraclePreparedStatement var1, int var2, int var3, int var4, byte[] var5, char[] var6, short[] var7, int var8, int var9, int var10, int var11, int var12, int var13, boolean var14, long var15) throws SQLException {
        byte[] var17 = var5;
        int var18 = var10 + 1;
        BigDecimal var19 = var1.parameterBigDecimal[var4][var2];
        boolean var20 = false;
        String var22 = var19.toString();
        int var23;
        int var32;
        int var33;
        int var34;
        int var35;
        int var36;
        int var39;
        if ((var23 = var22.indexOf("E")) != -1) {
            StringBuffer var24 = new StringBuffer(var22.length() + 5);
            boolean var25 = false;
            BigDecimal var26 = null;
            boolean var27 = var22.charAt(0) == '-';
            String var28 = var22.substring(var23 + 1);
            String var29 = var22.substring(var27 ? 1 : 0, var23);
            var26 = new BigDecimal(var29);
            boolean var30 = var28.charAt(0) == '-';
            var28 = var28.substring(1);
            var39 = Integer.parseInt(var28);
            String var31 = var26.toString();
            var32 = var31.indexOf(".");
            var33 = var31.length();
            var34 = var33;
            if (var32 != -1) {
                var31 = var31.substring(0, var32) + var31.substring(var32 + 1);
                --var33;
                if (var30) {
                    var39 -= var32;
                } else {
                    ++var39;
                    var34 = var39;
                }
            } else if (var30) {
                var39 -= var33;
            } else {
                ++var39;
                var34 = var39;
            }

            if (var27) {
                var24.append("-");
            }

            if (!var30) {
                var35 = var39 > var33 ? var39 : var33;

                for(var36 = 0; var36 < var35; ++var36) {
                    if (var34 == var36) {
                        var24.append(".");
                    }

                    var24.append(var33 > var36 ? var31.charAt(var36) : '0');
                }
            } else {
                var24.append("0.");

                for(var35 = 0; var35 < var39; ++var35) {
                    var24.append("0");
                }

                var24.append(var31);
            }

            var22 = var24.toString();
        }

        int var38 = var22.length();
        var39 = var22.indexOf(46);
        int var40 = var22.charAt(0) == '-' ? 1 : 0;
        int var41 = var40;
        int var45 = 2;
        if (var39 == -1) {
            var39 = var38;
        } else if ((var38 - var39 & 1) != 0) {
            var32 = var38 + 1;
        }

        char var42;
        while(var41 < var38 && ((var42 = var22.charAt(var41)) < '1' || var42 > '9')) {
            ++var41;
        }

        int var37;
        if (var41 >= var38) {
            var5[var18] = -128;
            var37 = 1;
        } else {
            int var43;
            if (var41 < var39) {
                var43 = 2 - (var39 - var41 & 1);
            } else {
                var43 = 1 + (var41 - var39 & 1);
            }

            int var44 = (var39 - var41 - 1) / 2;
            SQLException var46;
            if (var44 > 62) {
                var46 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 1, CoreException.getMessage((byte)3) + " trying to bind " + var19);
                var46.fillInStackTrace();
                throw var46;
            }

            if (var44 < -65) {
                var46 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 1, CoreException.getMessage((byte)2) + " trying to bind " + var19);
                var46.fillInStackTrace();
                throw var46;
            }

            var33 = var41 + var43 + 38;
            if (var33 > var38) {
                var33 = var38;
            }

            for(var34 = var41 + var43; var34 < var33; var34 += 2) {
                if (var34 == var39) {
                    --var34;
                    if (var33 < var38) {
                        ++var33;
                    }
                } else if (var22.charAt(var34) != '0' || var34 + 1 < var38 && var22.charAt(var34 + 1) != '0') {
                    var45 = (var34 - var41 - var43) / 2 + 3;
                }
            }

            var35 = var18 + 2;
            var34 = var41 + var43;
            if (var40 == 0) {
                var5[var18] = (byte)(192 + var44 + 1);
                var36 = var22.charAt(var41) - 48;
                if (var43 == 2) {
                    var36 = var36 * 10 + (var41 + 1 < var38 ? var22.charAt(var41 + 1) - 48 : 0);
                }

                for(var5[var18 + 1] = (byte)(var36 + 1); var35 < var18 + var45; var34 += 2) {
                    if (var34 == var39) {
                        ++var34;
                    }

                    var36 = (var22.charAt(var34) - 48) * 10;
                    if (var34 + 1 < var38) {
                        var36 += var22.charAt(var34 + 1) - 48;
                    }

                    var17[var35++] = (byte)(var36 + 1);
                }
            } else {
                var5[var18] = (byte)(62 - var44);
                var36 = var22.charAt(var41) - 48;
                if (var43 == 2) {
                    var36 = var36 * 10 + (var41 + 1 < var38 ? var22.charAt(var41 + 1) - 48 : 0);
                }

                for(var5[var18 + 1] = (byte)(101 - var36); var35 < var18 + var45; var34 += 2) {
                    if (var34 == var39) {
                        ++var34;
                    }

                    var36 = (var22.charAt(var34) - 48) * 10;
                    if (var34 + 1 < var38) {
                        var36 += var22.charAt(var34 + 1) - 48;
                    }

                    var17[var35++] = (byte)(101 - var36);
                }

                if (var45 < 21) {
                    var17[var18 + var45++] = 102;
                }
            }

            var37 = var45;
        }

        var17[var10] = (byte)var37;
        var7[var13] = 0;
        var7[var12] = (short)(var37 + 1);
        if (var1.connection.checksumMode.needToCalculateBindChecksum()) {
            CRC64 var10000 = PhysicalConnection.CHECKSUM;
            var15 = CRC64.updateChecksum(var15, var19.toString());
        }

        return var15;
    }
}
