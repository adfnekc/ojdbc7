//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package oracle.jdbc.driver;

class SetCHARBinder extends Binder {
    Binder theSetCHARCopyingBinder;
    private static final String _Copyright_2007_Oracle_All_Rights_Reserved_ = null;
    public static final String BUILD_DATE = "Thu_Apr_04_15:09:24_PDT_2013";
    public static final boolean TRACE = false;

    static void init(Binder var0) {
        var0.type = 996;
        var0.bytelen = 0;
    }

    SetCHARBinder() {
        this.theSetCHARCopyingBinder = OraclePreparedStatementReadOnly.theStaticSetCHARCopyingBinder;
        init(this);
    }

    Binder copyingBinder() {
        return this.theSetCHARCopyingBinder;
    }

    long bind(OraclePreparedStatement var1, int var2, int var3, int var4, byte[] var5, char[] var6, short[] var7, int var8, int var9, int var10, int var11, int var12, int var13, boolean var14, long var15) {
        byte[][] var17 = var1.parameterDatum[var4];
        byte[] var18 = var17[var2];
        if (var14) {
            var17[var2] = null;
        }

        if (var18 == null) {
            var7[var13] = -1;
        } else {
            var7[var13] = 0;
            int var19 = var18.length;
            var6[var11] = (char)var19;
            if (var19 > 65532) {
                var7[var12] = -2;
            } else {
                var7[var12] = (short)(var19 + 2);
            }

            int var20 = var11 + (var19 >> 1);
            if (var19 % 2 == 1) {
                int var10001 = var20 + 1;
                --var19;
                var6[var10001] = (char)(var18[var19] << 8);
            }

            while(var19 > 0) {
                var19 -= 2;
                var6[var20--] = (char)(var18[var19] << 8 | var18[var19 + 1] & 255);
            }
        }

        if (var1.connection.checksumMode.needToCalculateBindChecksum()) {
            CRC64 var10000;
            if (var7[var13] == -1) {
                var10000 = PhysicalConnection.CHECKSUM;
                var15 = CRC64.updateChecksum(var15, Accessor.NULL_DATA_BYTES, 0, Accessor.NULL_DATA_BYTES.length);
            } else {
                var10000 = PhysicalConnection.CHECKSUM;
                var15 = CRC64.updateChecksum(var15, var18, 0, var18.length);
            }
        }

        return var15;
    }

    short updateInoutIndicatorValue(short var1) {
        return (short)(var1 | 4);
    }
}
