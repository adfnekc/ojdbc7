//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package oracle.jdbc.driver;

class StringBinder extends VarcharBinder {
    private static final String _Copyright_2007_Oracle_All_Rights_Reserved_ = null;
    public static final String BUILD_DATE = "Thu_Apr_04_15:09:24_PDT_2013";
    public static final boolean TRACE = false;

    StringBinder() {
    }

    long bind(OraclePreparedStatement var1, int var2, int var3, int var4, byte[] var5, char[] var6, short[] var7, int var8, int var9, int var10, int var11, int var12, int var13, boolean var14, long var15) {
        String[] var17 = var1.parameterString[var4];
        String var18 = var17[var2];
        if (var14) {
            var17[var2] = null;
        }

        if (var18 == null) {
            var7[var13] = -1;
        } else {
            var7[var13] = 0;
            int var19 = var18.length();
            var18.getChars(0, var19, var6, var11 + 1);
            var19 <<= 1;
            var6[var11] = (char)var19;
            if (var19 > 65532) {
                var7[var12] = -2;
            } else {
                var7[var12] = (short)(var19 + 2);
            }
        }

        return var15;
    }
}
