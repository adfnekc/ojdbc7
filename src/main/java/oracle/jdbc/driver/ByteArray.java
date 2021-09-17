//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package oracle.jdbc.driver;

import java.sql.SQLException;
import oracle.jdbc.internal.OracleConnection;
import oracle.sql.CharacterSet;

abstract class ByteArray {
    protected long position = 0L;
    private static final String _Copyright_2007_Oracle_All_Rights_Reserved_ = null;
    public static final String BUILD_DATE = "Thu_Apr_04_15:09:24_PDT_2013";
    public static final boolean TRACE = false;

    ByteArray() {
    }

    abstract long length();

    final long getPosition() {
        return this.position;
    }

    final void setPosition(long var1) {
        assert var1 >= 0L : "index: " + var1;

        this.position = var1;
    }

    final void reset() {
        this.setPosition(0L);
    }

    final byte get() {
        assert this.position < this.length() : "position: " + this.position + " length: " + this.length();

        return this.get((long)(this.position++));
    }

    final byte[] getBytes(int var1) {
        assert var1 >= 0 && this.length() >= this.getPosition() + (long)var1 : "this.length: " + this.length() + " position: " + this.position + " length: " + var1;

        byte[] var2 = this.get(this.position, var1);
        this.position += (long)var1;
        return var2;
    }

    final void getBytes(byte[] var1, int var2, int var3) {
        assert var1 != null : "dest is null";

        assert var2 >= 0 && var3 >= 0 && var1.length >= var2 + var3 : "destOffset: " + var2 + " length: " + var3 + " dest.length: " + var1.length;

        assert this.length() >= this.position + (long)var3 : " this.length: " + this.length() + " this.position: " + this.position + " length: " + var3;

        this.get(this.position, var1, var2, var3);
        this.position += (long)var3;
    }

    final int getShort() {
        assert this.position + 1L < this.length() : "position: " + this.position + " length: " + this.length();

        return (this.get() & 255) << 8 | this.get() & 255;
    }

    final int getInt() {
        assert this.position + 3L < this.length() : "position: " + this.position + " length: " + this.length();

        return (this.get() & 255) << 24 | (this.get() & 255) << 16 | (this.get() & 255) << 8 | this.get() & 255;
    }

    final String getString(int var1, CharacterSet var2) throws SQLException {
        String var3 = this.getString(this.position, var1, var2);
        this.position += (long)var1;
        return var3;
    }

    final void put(byte var1) {
        this.put((long)(this.position++), var1);
    }

    final void putShort(short var1) {
        this.putShort(this.position, var1);
        this.position += 2L;
    }

    final void putInt(int var1) {
        this.putInt(this.position, var1);
        this.position += 4L;
    }

    final void put(byte[] var1) {
        this.put(this.position, var1);
        this.position += (long)var1.length;
    }

    final void put(byte[] var1, int var2, int var3) {
        assert var1 != null : "src is null";

        assert var2 >= 0 && var3 >= 0 : "srcOffset: " + var2 + " length: " + var3;

        assert var1.length >= var2 + var3 : "src.length: " + var1.length + " srcOffset: " + var2 + " length: " + var3;

        this.put(this.position, var1, var2, var3);
        this.position += (long)var3;
    }

    abstract void put(long var1, byte var3);

    abstract byte get(long var1);

    final void putShort(long var1, short var3) {
        this.put(var1, (byte)(var3 >> 8 & 255));
        this.put(var1 + 1L, (byte)(var3 & 255));
    }

    final void putInt(long var1, int var3) {
        for(int var4 = 3; var4 >= 0; --var4) {
            this.put(var1 + (long)var4, (byte)(var3 & 255));
            var3 >>= 8;
        }

    }

    final void put(long var1, byte[] var3) {
        assert var1 >= 0L && var3 != null : "offset: " + var1 + " src: " + var3;

        this.put(var1, var3, 0, var3.length);
    }

    abstract void put(long var1, byte[] var3, int var4, int var5);

    void put(long var1, ByteArray var3, long var4, int var6) {
        assert var1 >= 0L && var3 != null && var4 >= 0L : "offset: " + var1 + " src: " + var3 + " srcOffset: " + var4;

        byte[] var7 = var3.get(var4, var6);
        this.put(var1, var7, 0, var6);
    }

    final byte[] get(long var1, int var3) {
        assert var1 >= 0L && var3 >= 0 && this.length() >= var1 + (long)var3 : "this.length: " + this.length() + " offset: " + var1 + " length: " + var3;

        byte[] var4 = new byte[var3];
        this.get(var1, var4, 0, var3);
        return var4;
    }

    abstract void get(long var1, byte[] var3, int var4, int var5);

    String getString(long var1, int var3, CharacterSet var4) throws SQLException {
        int[] var5 = new int[1];
        char[] var6 = this.getChars(var1, var3, var4, var5);
        return var5[0] == var6.length ? new String(var6) : String.valueOf(var6, 0, var5[0]);
    }

    char[] getChars(long var1, int var3, CharacterSet var4) throws SQLException {
        int[] var5 = new int[1];
        char[] var6 = this.getChars(var1, var3, var4, var5);
        if (var5[0] == var6.length) {
            return var6;
        } else {
            char[] var7 = new char[var5[0]];
            System.arraycopy(var6, 0, var7, 0, var7.length);
            return var7;
        }
    }

    abstract char[] getChars(long var1, int var3, CharacterSet var4, int[] var5) throws SQLException;

    boolean equalBytes(long var1, int var3, ByteArray var4, long var5) throws SQLException {
        if (var1 + (long)var3 < this.length() && var5 + (long)var3 < var4.length()) {
            for(int var7 = 0; var7 < var3; ++var7) {
                if (this.get(var1 + (long)var7) != var4.get(var5 + (long)var7)) {
                    return false;
                }
            }

            return true;
        } else {
            return false;
        }
    }

    abstract long updateChecksum(long var1, int var3, CRC64 var4, long var5);

    byte[] getBytesFromHex(long var1, int var3, CharacterSet var4) throws SQLException {
        int[] var5 = new int[1];
        char[] var6 = this.getChars(var1, var3, var4, var5);
        int var7 = var5[0];
        byte[] var8 = new byte[(var7 + 1) / 2];
        boolean var9 = true;
        int var10 = 0;
        char[] var11 = var6;
        int var12 = var6.length;

        for(int var13 = 0; var13 < var12; ++var13) {
            char var14 = var11[var13];
            if (var9) {
                var8[var10] = (byte)(this.hexDigit2Nibble(var14) << 4);
            } else {
                int var10001 = var10++;
                var8[var10001] = (byte)(var8[var10001] + (this.hexDigit2Nibble(var14) & 15));
            }

            var9 = !var9;
        }

        return var8;
    }

    final int hexDigit2Nibble(char var1) throws SQLException {
        int var2 = Character.digit(var1, 16);
        if (var2 == -1) {
            SQLException var3 = DatabaseError.createSqlException((OracleConnection)null, 59, "Invalid hex digit: " + var1);
            var3.fillInStackTrace();
            throw var3;
        } else {
            return var2;
        }
    }

    final void freeSpace(long var1, int var3) {
    }

    byte[] getBlockBasic(long var1, int[] var3) {
        throw new Error("not implemented");
    }

    abstract void free();
}
