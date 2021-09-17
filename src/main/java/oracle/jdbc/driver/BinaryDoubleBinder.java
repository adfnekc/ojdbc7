//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package oracle.jdbc.driver;

class BinaryDoubleBinder extends Binder {
    Binder theBinaryDoubleCopyingBinder;
    private static final String _Copyright_2007_Oracle_All_Rights_Reserved_ = null;
    public static final String BUILD_DATE = "Thu_Apr_04_15:09:24_PDT_2013";
    public static final boolean TRACE = false;

    static void init(Binder var0) {
        var0.type = 101;
        var0.bytelen = 8;
    }

    BinaryDoubleBinder() {
        this.theBinaryDoubleCopyingBinder = OraclePreparedStatementReadOnly.theStaticBinaryDoubleCopyingBinder;
        init(this);
    }

    Binder copyingBinder() {
        return this.theBinaryDoubleCopyingBinder;
    }

    long bind(OraclePreparedStatement var1, int var2, int var3, int var4, byte[] var5, char[] var6, short[] var7, int var8, int var9, int var10, int var11, int var12, int var13, boolean var14, long var15) {
        double var19 = var1.parameterDouble[var4][var2];
        if (var19 == 0.0D) {
            var19 = 0.0D;
        } else if (var19 != var19) {
            var19 = 0.0D / 0.0;
        }

        long var21 = Double.doubleToLongBits(var19);
        int var23 = (int)var21;
        int var24 = (int)(var21 >> 32);
        int var25 = var23;
        var23 >>= 8;
        int var26 = var23;
        var23 >>= 8;
        int var27 = var23;
        var23 >>= 8;
        int var28 = var23;
        int var29 = var24;
        var24 >>= 8;
        int var30 = var24;
        var24 >>= 8;
        int var31 = var24;
        var24 >>= 8;
        int var32;
        if ((var24 & 128) == 0) {
            var32 = var24 | 128;
        } else {
            var32 = ~var24;
            var31 = ~var31;
            var30 = ~var30;
            var29 = ~var29;
            var28 = ~var23;
            var27 = ~var27;
            var26 = ~var26;
            var25 = ~var25;
        }

        var5[var10 + 7] = (byte)var25;
        var5[var10 + 6] = (byte)var26;
        var5[var10 + 5] = (byte)var27;
        var5[var10 + 4] = (byte)var28;
        var5[var10 + 3] = (byte)var29;
        var5[var10 + 2] = (byte)var30;
        var5[var10 + 1] = (byte)var31;
        var5[var10] = (byte)var32;
        var7[var13] = 0;
        var7[var12] = 8;
        return var15;
    }
}
