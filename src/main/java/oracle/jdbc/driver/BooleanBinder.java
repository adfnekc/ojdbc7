//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package oracle.jdbc.driver;

class BooleanBinder extends VarnumBinder {
    private static final String _Copyright_2007_Oracle_All_Rights_Reserved_ = null;
    public static final String BUILD_DATE = "Thu_Apr_04_15:09:24_PDT_2013";
    public static final boolean TRACE = false;

    BooleanBinder() {
    }

    long bind(OraclePreparedStatement var1, int var2, int var3, int var4, byte[] var5, char[] var6, short[] var7, int var8, int var9, int var10, int var11, int var12, int var13, boolean var14, long var15) {
        int var18 = var10 + 1;
        int var19 = var1.parameterInt[var4][var2];
        boolean var20 = false;
        byte var21;
        if (var19 != 0) {
            var5[var18] = -63;
            var5[var18 + 1] = 2;
            var21 = 2;
        } else {
            var5[var18] = -128;
            var21 = 1;
        }

        var5[var10] = (byte)var21;
        var7[var13] = 0;
        var7[var12] = (short)(var21 + 1);
        return var15;
    }
}
