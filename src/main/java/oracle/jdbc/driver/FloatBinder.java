//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package oracle.jdbc.driver;

import java.sql.SQLException;
import oracle.core.lmx.CoreException;

class FloatBinder extends VarnumBinder {
    private static final String _Copyright_2007_Oracle_All_Rights_Reserved_ = null;
    public static final String BUILD_DATE = "Thu_Apr_04_15:09:24_PDT_2013";
    public static final boolean TRACE = false;

    FloatBinder() {
    }

    long bind(OraclePreparedStatement var1, int var2, int var3, int var4, byte[] var5, char[] var6, short[] var7, int var8, int var9, int var10, int var11, int var12, int var13, boolean var14, long var15) throws SQLException {
        int var18 = var10 + 1;
        double var19 = var1.parameterDouble[var4][var2];
        boolean var21 = false;
        int var33;
        if (var19 == 0.0D) {
            var5[var18] = -128;
            var33 = 1;
        } else if (var19 == 1.0D / 0.0) {
            var5[var18] = -1;
            var5[var18 + 1] = 101;
            var33 = 2;
        } else if (var19 == -1.0D / 0.0) {
            var5[var18] = 0;
            var33 = 1;
        } else {
            boolean var23 = var19 < 0.0D;
            if (var23) {
                var19 = -var19;
            }

            long var24 = Double.doubleToLongBits(var19);
            int var26 = (int)(var24 >> 52 & 2047L);
            int var27 = (var26 > 1023 ? 126 : 127) - (int)((double)(var26 - 1023) / 6.643856189774725D);
            SQLException var28;
            if (var27 < 0) {
                var28 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 1, CoreException.getMessage((byte)3) + " trying to bind " + var19);
                var28.fillInStackTrace();
                throw var28;
            }

            if (var27 > 192) {
                var28 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 1, CoreException.getMessage((byte)2) + " trying to bind " + var19);
                var28.fillInStackTrace();
                throw var28;
            }

            if (var19 > factorTable[var27]) {
                while(var27 > 0) {
                    --var27;
                    if (var19 <= factorTable[var27]) {
                        break;
                    }
                }
            } else {
                while(var27 < 193 && var19 <= factorTable[var27 + 1]) {
                    ++var27;
                }
            }

            if (var19 == factorTable[var27]) {
                if (var27 < 65) {
                    var28 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 1, CoreException.getMessage((byte)3) + " trying to bind " + var19);
                    var28.fillInStackTrace();
                    throw var28;
                }

                if (var27 > 192) {
                    var28 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 1, CoreException.getMessage((byte)2) + " trying to bind " + var19);
                    var28.fillInStackTrace();
                    throw var28;
                }

                if (var23) {
                    var5[var18] = (byte)(62 - (127 - var27));
                    var5[var18 + 1] = 100;
                    var5[var18 + 2] = 102;
                    var33 = 3;
                } else {
                    var5[var18] = (byte)(192 + (128 - var27));
                    var5[var18 + 1] = 2;
                    var33 = 2;
                }
            } else {
                if (var27 < 64) {
                    var28 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 1, CoreException.getMessage((byte)3) + " trying to bind " + var19);
                    var28.fillInStackTrace();
                    throw var28;
                }

                if (var27 > 191) {
                    var28 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 1, CoreException.getMessage((byte)2) + " trying to bind " + var19);
                    var28.fillInStackTrace();
                    throw var28;
                }

                int var34 = Float.floatToIntBits((float)var19);
                int var29 = var34 & 8388607;
                int var30 = var34 >> 23 & 255;
                char[] var32 = var1.digits;
                int var31;
                if (var30 != 0) {
                    var29 |= 8388608;
                    var31 = 24;
                } else {
                    while((long)(var29 & 8388608) == 0L) {
                        var29 <<= 1;
                        --var30;
                    }

                    var31 = 24 + var30;
                    ++var30;
                }

                var30 -= 127;
                var33 = this.dtoa(var5, var18, var19, var23, true, var32, var30, (long)var29 << 29, var31);
            }
        }

        var5[var10] = (byte)var33;
        var7[var13] = 0;
        var7[var12] = (short)(var33 + 1);
        return var15;
    }
}
