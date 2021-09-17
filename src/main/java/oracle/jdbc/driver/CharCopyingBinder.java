//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package oracle.jdbc.driver;

abstract class CharCopyingBinder extends Binder {
    private static final String _Copyright_2007_Oracle_All_Rights_Reserved_ = null;
    public static final String BUILD_DATE = "Thu_Apr_04_15:09:24_PDT_2013";
    public static final boolean TRACE = false;

    CharCopyingBinder() {
    }

    Binder copyingBinder() {
        return this;
    }

    long bind(OraclePreparedStatement var1, int var2, int var3, int var4, byte[] var5, char[] var6, short[] var7, int var8, int var9, int var10, int var11, int var12, int var13, boolean var14, long var15) {
        CRC64 var10000;
        char[] var17;
        int var18;
        int var19;
        if (var3 == 0) {
            var17 = var1.lastBoundChars;
            var18 = var1.lastBoundCharOffsets[var2];
            var7[var13] = var1.lastBoundInds[var2];
            var7[var12] = var1.lastBoundLens[var2];
            if (var17 == var6 && var18 == var11) {
                if (var1.connection.checksumMode.needToCalculateBindChecksum()) {
                    if (var7[var13] == -1) {
                        var10000 = PhysicalConnection.CHECKSUM;
                        var15 = CRC64.updateChecksum(var15, Accessor.NULL_DATA_BYTES, 0, Accessor.NULL_DATA_BYTES.length);
                    } else {
                        var19 = var1.lastBoundCharLens[var2];
                        var10000 = PhysicalConnection.CHECKSUM;
                        var15 = CRC64.updateChecksum(var15, var17, var18, var19);
                    }
                }

                return var15;
            }

            var19 = var1.lastBoundCharLens[var2];
            if (var19 > var9) {
                var19 = var9;
            }
        } else {
            var17 = var6;
            var18 = var11 - var9;
            var7[var13] = var7[var13 - 1];
            var7[var12] = var7[var12 - 1];
            var19 = var9;
        }

        System.arraycopy(var17, var18, var6, var11, var19);
        if (var1.connection.checksumMode.needToCalculateBindChecksum()) {
            if (var7[var13] == -1) {
                var10000 = PhysicalConnection.CHECKSUM;
                var15 = CRC64.updateChecksum(var15, Accessor.NULL_DATA_BYTES, 0, Accessor.NULL_DATA_BYTES.length);
            } else {
                var10000 = PhysicalConnection.CHECKSUM;
                var15 = CRC64.updateChecksum(var15, var17, var18, var19);
            }
        }

        return var15;
    }
}
