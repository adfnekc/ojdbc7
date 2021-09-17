//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package oracle.jdbc.driver;

import java.sql.SQLException;
import oracle.sql.CharacterSet;

class AggregateByteArray extends SimpleByteArray {
    protected ByteArray extension;
    private static final String _Copyright_2007_Oracle_All_Rights_Reserved_ = null;
    public static final String BUILD_DATE = "Thu_Apr_04_15:09:24_PDT_2013";
    public static final boolean TRACE = false;

    AggregateByteArray(byte[] var1, ByteArray var2) {
        super(var1);
        this.extension = var2;
    }

    long length() {
        return (long)this.bytes.length + this.extension.length();
    }

    void put(long var1, byte var3) {
        if (var1 < (long)this.bytes.length) {
            super.put(var1, var3);
        } else {
            this.extension.put(var1 - (long)this.bytes.length, var3);
        }

    }

    byte get(long var1) {
        return var1 < (long)this.bytes.length ? super.get(var1) : this.extension.get(var1 - (long)this.bytes.length);
    }

    void put(long var1, byte[] var3, int var4, int var5) {
        assert var1 < (long)this.bytes.length == var1 + (long)var5 <= (long)this.bytes.length : "offset:" + var1 + " length:" + var5 + " bytes.length:" + this.bytes.length;

        if (var1 < (long)this.bytes.length) {
            super.put(var1, var3, var4, var5);
        } else {
            this.extension.put(var1 - (long)this.bytes.length, var3, var4, var5);
        }

    }

    void get(long var1, byte[] var3, int var4, int var5) {
        assert var1 < (long)this.bytes.length == var1 + (long)var5 <= (long)this.bytes.length : "offset:" + var1 + " length:" + var5 + " bytes.length:" + this.bytes.length;

        if (var1 < (long)this.bytes.length) {
            super.get(var1, var3, var4, var5);
        } else {
            this.extension.get(var1 - (long)this.bytes.length, var3, var4, var5);
        }

    }

    char[] getChars(long var1, int var3, CharacterSet var4, int[] var5) throws SQLException {
        assert var1 < (long)this.bytes.length == var1 + (long)var3 <= (long)this.bytes.length : "offset:" + var1 + " lengthInBytes:" + var3 + " bytes.length:" + this.bytes.length;

        return var1 < (long)this.bytes.length ? super.getChars(var1, var3, var4, var5) : this.extension.getChars(var1 - (long)this.bytes.length, var3, var4, var5);
    }

    long updateChecksum(long var1, int var3, CRC64 var4, long var5) {
        assert var1 < (long)this.bytes.length == var1 + (long)var3 <= (long)this.bytes.length : "offset:" + var1 + " length:" + var3 + " bytes.length:" + this.bytes.length;

        return var1 < (long)this.bytes.length ? super.updateChecksum(var1, var3, var4, var5) : this.extension.updateChecksum(var1 - (long)this.bytes.length, var3, var4, var5);
    }

    byte[] getBlockBasic(long var1, int[] var3) {
        return var1 < (long)this.bytes.length ? super.getBlockBasic(var1, var3) : this.extension.getBlockBasic(var1, var3);
    }

    void free() {
        super.free();
        this.extension.free();
    }
}
