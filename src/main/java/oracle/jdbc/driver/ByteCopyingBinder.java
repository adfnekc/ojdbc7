//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package oracle.jdbc.driver;

abstract class ByteCopyingBinder extends Binder {
    private static final String _Copyright_2007_Oracle_All_Rights_Reserved_ = null;
    public static final String BUILD_DATE = "Thu_Apr_04_15:09:24_PDT_2013";
    public static final boolean TRACE = false;

    ByteCopyingBinder() {
    }

    Binder copyingBinder() {
        return this;
    }

    long bind(OraclePreparedStatement var1, int var2, int var3, int var4, byte[] var5, char[] var6, short[] var7, int var8, int var9, int var10, int var11, int var12, int var13, boolean var14, long var15) {
        int var10000 = var1.lastBoundByteLens[var2];
        byte[] var17;
        int var18;
        int var19;
        CRC64 var20;
        if (var3 == 0) {
            var17 = var1.lastBoundBytes;
            var18 = var1.lastBoundByteOffsets[var2];
            var7[var13] = var1.lastBoundInds[var2];
            var7[var12] = var1.lastBoundLens[var2];
            if (var17 == var5 && var18 == var10) {
                if (var1.connection.checksumMode.needToCalculateBindChecksum()) {
                    if (var7[var13] == -1) {
                        var20 = PhysicalConnection.CHECKSUM;
                        var15 = CRC64.updateChecksum(var15, Accessor.NULL_DATA_BYTES, 0, Accessor.NULL_DATA_BYTES.length);
                    } else {
                        var19 = var1.lastBoundByteLens[var2];
                        var20 = PhysicalConnection.CHECKSUM;
                        var15 = CRC64.updateChecksum(var15, var17, var18, var19);
                    }
                }

                return var15;
            }

            var19 = var1.lastBoundByteLens[var2];
            if (var19 > var8) {
                var19 = var8;
            }
        } else {
            var17 = var5;
            var18 = var10 - var8;
            var7[var13] = var7[var13 - 1];
            var7[var12] = var7[var12 - 1];
            var19 = var8;
        }

        System.arraycopy(var17, var18, var5, var10, var19);
        if (var1.connection.checksumMode.needToCalculateBindChecksum()) {
            if (var7[var13] == -1) {
                var20 = PhysicalConnection.CHECKSUM;
                var15 = CRC64.updateChecksum(var15, Accessor.NULL_DATA_BYTES, 0, Accessor.NULL_DATA_BYTES.length);
            } else {
                var20 = PhysicalConnection.CHECKSUM;
                var15 = CRC64.updateChecksum(var15, var17, var18, var19);
            }
        }

        return var15;
    }
}
