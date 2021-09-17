//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package oracle.jdbc.oracore;

import oracle.sql.Datum;

class SINT32 extends Datum {
    boolean isBigEndian;

    private SINT32() {
    }

    private SINT32(byte[] var1, boolean var2) {
        this.setBytes(var1);
        this.isBigEndian = var2;
    }

    public boolean isConvertibleTo(Class var1) {
        return false;
    }

    public Object toJdbc() {
        return bytesToInt(this.shareBytes(), this.isBigEndian);
    }

    public Object makeJdbcArray(int var1) {
        return new SINT32[var1];
    }

    static SINT32[] createArray(int var0) {
        return new SINT32[var0];
    }

    static int bytesToInt(byte[] var0, boolean var1) {
        int var2 = 0;
        int var3 = var1 ? 0 : var0.length - 1;
        byte[] var4 = var0;
        int var5 = var0.length;

        for(int var6 = 0; var6 < var5; ++var6) {
            byte var7 = var4[var6];
            var2 |= (var7 & 255) << var3 * 8;
            var3 += var1 ? 1 : -1;
        }

        return var2;
    }

    static SINT32 valueOf(int var0, boolean var1) {
        byte[] var2 = new byte[4];
        int var3 = var1 ? 0 : var2.length - 1;

        for(int var4 = 0; var4 < 4; ++var4) {
            var2[var4] = (byte)(var0 >> var3 * 8 & 255);
            var3 += var1 ? 1 : -1;
        }

        return new SINT32(var2, var1);
    }
}
