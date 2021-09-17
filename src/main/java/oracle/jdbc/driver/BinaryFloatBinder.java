//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package oracle.jdbc.driver;

class BinaryFloatBinder extends Binder {
    Binder theBinaryFloatCopyingBinder;
    private static final String _Copyright_2007_Oracle_All_Rights_Reserved_ = null;
    public static final String BUILD_DATE = "Thu_Apr_04_15:09:24_PDT_2013";
    public static final boolean TRACE = false;

    static void init(Binder var0) {
        var0.type = 100;
        var0.bytelen = 4;
    }

    BinaryFloatBinder() {
        this.theBinaryFloatCopyingBinder = OraclePreparedStatementReadOnly.theStaticBinaryFloatCopyingBinder;
        init(this);
    }

    Binder copyingBinder() {
        return this.theBinaryFloatCopyingBinder;
    }

    long bind(OraclePreparedStatement var1, int var2, int var3, int var4, byte[] var5, char[] var6, short[] var7, int var8, int var9, int var10, int var11, int var12, int var13, boolean var14, long var15) {
        float var19 = var1.parameterFloat[var4][var2];
        if ((double)var19 == 0.0D) {
            var19 = 0.0F;
        } else if (var19 != var19) {
            var19 = (float) (0.0F / 0.0);
        }

        int var20 = Float.floatToIntBits(var19);
        int var21 = var20;
        var20 >>= 8;
        int var22 = var20;
        var20 >>= 8;
        int var23 = var20;
        var20 >>= 8;
        int var24;
        if ((var20 & 128) == 0) {
            var24 = var20 | 128;
        } else {
            var24 = ~var20;
            var23 = ~var23;
            var22 = ~var22;
            var21 = ~var21;
        }

        var5[var10 + 3] = (byte)var21;
        var5[var10 + 2] = (byte)var22;
        var5[var10 + 1] = (byte)var23;
        var5[var10] = (byte)var24;
        var7[var13] = 0;
        var7[var12] = 4;
        return var15;
    }
}
