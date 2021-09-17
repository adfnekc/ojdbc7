//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package oracle.jdbc.driver;

import java.sql.SQLException;
import oracle.sql.CharacterSet;

class SimpleByteArray extends ByteArray {
    protected byte[] bytes;
    private static final String _Copyright_2007_Oracle_All_Rights_Reserved_ = null;
    public static final String BUILD_DATE = "Thu_Apr_04_15:09:24_PDT_2013";
    public static final boolean TRACE = false;

    protected SimpleByteArray(byte[] var1) {
        this.setBytes(var1);
    }

    void setBytes(byte[] var1) {
        this.bytes = var1;
    }

    long length() {
        return (long)this.bytes.length;
    }

    void put(long var1, byte var3) {
        assert var1 >= 0L && var1 < (long)this.bytes.length : "index = " + var1 + " length = " + this.bytes.length;

        this.bytes[(int)var1] = var3;
    }

    byte get(long var1) {
        assert var1 >= 0L && var1 < (long)this.bytes.length : "index = " + var1 + " length = " + this.bytes.length;

        return this.bytes[(int)var1];
    }

    void put(long var1, byte[] var3, int var4, int var5) {
        assert var1 >= 0L && var1 + (long)var5 < (long)this.bytes.length : "offset = " + var1 + " length = " + var5 + " bytes.length = " + this.bytes.length;

        assert var4 >= 0 && var4 + var5 < var3.length : "srcOffset = " + var4 + " length = " + var5 + " src.length = " + var3.length;

        System.arraycopy(var3, var4, this.bytes, (int)var1, var5);
    }

    void get(long var1, byte[] var3, int var4, int var5) {
        assert var1 >= 0L && var1 + (long)var5 <= (long)this.bytes.length && var4 >= 0 && var4 + var5 <= var3.length : " offset: " + var1 + " bytes.length: " + this.bytes.length + " destOffset: " + var4 + " length: " + var5;

        System.arraycopy(this.bytes, (int)var1, var3, var4, var5);
    }

    char[] getChars(long var1, int var3, DBConversion var4, int var5, int[] var6) throws SQLException {
        assert var1 >= 0L && var3 >= 0 && (long)this.bytes.length >= var1 + (long)var3 : "bytes.length: " + this.bytes.length + " offset: " + var1 + " lengthInBytes: " + var3;

        assert var4 != null : "conversion is null";

        assert var6 != null && var6.length >= 1 : "out_lengthInChars: " + var6;

        boolean var7 = var5 == 2;
        char[] var8 = new char[var3 * var4.cMaxCharSize];
        int[] var9 = new int[]{var3};
        int var10 = var4.CHARBytesToJavaChars(this.bytes, (int)var1, var8, 0, var9, var8.length, var7);
        var6[0] = var10;
        return var8;
    }

    char[] getChars(long var1, int var3, CharacterSet var4, int[] var5) throws SQLException {
        assert var1 >= 0L && var3 >= 0 : "offset: " + var1 + " lengthInBytes: " + var3;

        assert (long)this.bytes.length >= var1 + (long)var3 : "bytes.length: " + this.bytes.length + " offset: " + var1 + " lengthInBytes: " + var3;

        assert var5 != null && var5.length > 0 : "out_lengthInChars: " + var5;

        String var6 = var4.toString(this.bytes, (int)var1, var3);
        char[] var7 = var6.toCharArray();
        var5[0] = var7.length;
        return var7;
    }

    long updateChecksum(long var1, int var3, CRC64 var4, long var5) {
        return CRC64.updateChecksum(var5, this.bytes, (int)var1, var3);
    }

    byte[] getBlockBasic(long var1, int[] var3) {
        var3[0] = (int)var1;
        return var1 < (long)this.bytes.length ? this.bytes : null;
    }

    void free() {
    }
}
