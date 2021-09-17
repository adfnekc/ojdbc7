//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package oracle.jdbc.driver;

class ShortBinder extends VarnumBinder {
    private static final String _Copyright_2007_Oracle_All_Rights_Reserved_ = null;
    public static final String BUILD_DATE = "Thu_Apr_04_15:09:24_PDT_2013";
    public static final boolean TRACE = false;

    ShortBinder() {
    }

    long bind(OraclePreparedStatement var1, int var2, int var3, int var4, byte[] var5, char[] var6, short[] var7, int var8, int var9, int var10, int var11, int var12, int var13, boolean var14, long var15) {
        int var18 = var10 + 1;
        int var19 = var1.parameterInt[var4][var2];
        boolean var20 = false;
        byte var22;
        if (var19 == 0) {
            var5[var18] = -128;
            var22 = 1;
        } else {
            int var21;
            if (var19 < 0) {
                if (-var19 < 100) {
                    var5[var18] = 62;
                    var5[var18 + 1] = (byte)(101 + var19);
                    var5[var18 + 2] = 102;
                    var22 = 3;
                } else if (-var19 < 10000) {
                    var5[var18] = 61;
                    var5[var18 + 1] = (byte)(101 - -var19 / 100);
                    var21 = -var19 % 100;
                    if (var21 != 0) {
                        var5[var18 + 2] = (byte)(101 - var21);
                        var5[var18 + 3] = 102;
                        var22 = 4;
                    } else {
                        var5[var18 + 2] = 102;
                        var22 = 3;
                    }
                } else {
                    var5[var18] = 60;
                    var5[var18 + 1] = (byte)(101 - -var19 / 10000);
                    var21 = -var19 % 100;
                    if (var21 != 0) {
                        var5[var18 + 2] = (byte)(101 - -var19 % 10000 / 100);
                        var5[var18 + 3] = (byte)(101 - var21);
                        var5[var18 + 4] = 102;
                        var22 = 5;
                    } else {
                        var21 = -var19 % 10000 / 100;
                        if (var21 != 0) {
                            var5[var18 + 2] = (byte)(101 - var21);
                            var5[var18 + 3] = 102;
                            var22 = 4;
                        } else {
                            var5[var18 + 2] = 102;
                            var22 = 3;
                        }
                    }
                }
            } else if (var19 < 100) {
                var5[var18] = -63;
                var5[var18 + 1] = (byte)(var19 + 1);
                var22 = 2;
            } else if (var19 < 10000) {
                var5[var18] = -62;
                var5[var18 + 1] = (byte)(var19 / 100 + 1);
                var21 = var19 % 100;
                if (var21 != 0) {
                    var5[var18 + 2] = (byte)(var21 + 1);
                    var22 = 3;
                } else {
                    var22 = 2;
                }
            } else {
                var5[var18] = -61;
                var5[var18 + 1] = (byte)(var19 / 10000 + 1);
                var21 = var19 % 100;
                if (var21 != 0) {
                    var5[var18 + 2] = (byte)(var19 % 10000 / 100 + 1);
                    var5[var18 + 3] = (byte)(var21 + 1);
                    var22 = 4;
                } else {
                    var21 = var19 % 10000 / 100;
                    if (var21 != 0) {
                        var5[var18 + 2] = (byte)(var21 + 1);
                        var22 = 3;
                    } else {
                        var22 = 2;
                    }
                }
            }
        }

        var5[var10] = (byte)var22;
        var7[var13] = 0;
        var7[var12] = (short)(var22 + 1);
        return var15;
    }
}
