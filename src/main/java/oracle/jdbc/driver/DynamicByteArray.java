//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package oracle.jdbc.driver;

import java.io.IOException;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.sql.SQLException;
import oracle.sql.CharacterSet;
import oracle.sql.converter.CharacterConverter1Byte;
import oracle.sql.converter.CharacterConverterJDBC;
import oracle.sql.converter.JdbcCharacterConverters;

final class DynamicByteArray extends ByteArray {
    static final int INITIAL_BLOCKS = 16;
    static final int GROWTH_FACTOR = 8;
    private final BlockSource source;
    private final long blockSize;
    private byte[][] blocks = new byte[16][];
    protected long length = 0L;
    private final int[] out_bytesRead = new int[1];
    private static final char[] ISO_LATIN_1_TO_JAVA;
    private static final char[] WE8DEC_TO_JAVA;
    private static final char[] WE8MSWIN1252_TO_JAVA;
    private int globalBlockIndex = -1;
    private int globalByteIndex = -1;
    private int globalRemaining = -1;
    private int globalBlockSize = -1;
    private byte[] globalBytes = null;
    private static final char UTF16_REPLACEMENT_CHAR = '�';
    private static final String _Copyright_2007_Oracle_All_Rights_Reserved_;
    public static final String BUILD_DATE = "Thu_Apr_04_15:09:24_PDT_2013";
    public static final boolean TRACE = false;

    long length() {
        return this.length;
    }

    static DynamicByteArray createDynamicByteArray(BlockSource var0) {
        return new DynamicByteArray(var0);
    }

    private DynamicByteArray(BlockSource var1) {
        assert var1 != null : "source is null";

        this.source = var1;
        this.blockSize = (long)var1.getBlockSize();
    }

    private void grow() {
        byte[][] var1 = new byte[this.blocks.length * 8][];
        System.arraycopy(this.blocks, 0, var1, 0, this.blocks.length);
        this.blocks = var1;
    }

    final int unmarshalCLR(T4CMAREngine var1) throws SQLException, IOException {
        return this.unmarshalCLR(var1, 2147483647);
    }

    final int unmarshalCLR(T4CMAREngine var1, int var2) throws SQLException, IOException {
        var1.unmarshalCLR(this, this.position, this.out_bytesRead, var2, 0);
        this.position += (long)this.out_bytesRead[0];
        this.length = Math.max(this.length, this.position + 1L);
        return this.out_bytesRead[0];
    }

    final long unmarshalBuffer(T4CMAREngine var1, long var2, int var4) throws SQLException, IOException {
        assert var2 >= 0L : "offset: " + var2;

        int var5 = (int)(var2 / this.blockSize);
        int var6 = (int)(var2 % this.blockSize);

        int var7;
        for(var2 += (long)var4; var4 > 0; var4 -= var7) {
            while(var5 >= this.blocks.length) {
                this.grow();
            }

            if (this.blocks[var5] == null) {
                this.blocks[var5] = this.source.get();
            }

            var7 = Math.min(var4, (int)this.blockSize - var6);
            var1.unmarshalNBytes(this.blocks[var5], var6, var7);
            var6 = 0;
            ++var5;
        }

        return var2;
    }

    final int unmarshalCLRforREFS(T4CMAREngine var1) throws SQLException, IOException {
        byte[] var2 = var1.unmarshalCLRforREFS();
        if (var2 == null) {
            return 0;
        } else {
            this.put(var2);
            return var2.length;
        }
    }

    void copyLeft(long var1, int var3) {
        assert var1 >= this.position && var3 >= 0 && this.length >= this.position + (long)var3 : "this.position: " + this.position + " this.length: " + this.length + " srcOffset: " + var1 + " length: " + var3;

        if (var1 != this.position && var3 != 0) {
            assert var1 > this.position && var3 > 0;

            int var4 = (int)(this.position / this.blockSize);
            int var5 = (int)(this.position % this.blockSize);
            int var6 = (int)(var1 / this.blockSize);
            int var7 = (int)(var1 % this.blockSize);
            int var8 = (int)this.blockSize;

            int var10;
            for(int var9 = var3; var9 > 0; var9 -= var10) {
                var10 = Math.min(var9, Math.min(var8 - var7, var8 - var5));
                System.arraycopy(this.blocks[var6], var7, this.blocks[var4], var5, var10);
                var7 += var10;
                if (var7 == var8) {
                    ++var6;
                    var7 = 0;
                }

                var5 += var10;
                if (var5 == var8) {
                    ++var4;
                    var5 = 0;
                }
            }

            this.position += (long)var3;
        } else {
            this.position += (long)var3;
        }
    }

    void put(long var1, byte var3) {
        assert var1 >= 0L : "index: " + var1;

        int var4 = (int)(var1 / this.blockSize);
        int var5 = (int)(var1 % this.blockSize);

        while(var4 >= this.blocks.length) {
            this.grow();
        }

        if (this.blocks[var4] == null) {
            this.blocks[var4] = this.source.get();
        }

        this.blocks[var4][var5] = var3;
        this.length = Math.max(this.length, var1 + 1L);
    }

    byte get(long var1) {
        assert var1 >= 0L && var1 < this.length;

        int var3 = (int)(var1 / this.blockSize);
        int var4 = (int)(var1 % this.blockSize);

        assert this.blocks.length >= var3 && this.blocks[var3] != null : "invalid read--blocks.length: " + this.blocks.length + " blockIndex: " + var3 + (var3 < this.blocks.length ? " blocks[" + var3 + "]: " + this.blocks[var3] : "");

        return this.blocks[var3][var4];
    }

    void put(long var1, byte[] var3, int var4, int var5) {
        assert var3 != null : "src is null";

        assert var1 >= 0L && var4 + var5 <= var3.length : "offset: " + var1 + " src.length: " + var3.length + " srcOffset: " + var4 + " length: " + var5;

        int var6 = (int)(var1 / this.blockSize);
        int var7 = (int)(var1 % this.blockSize);
        int var8 = (int)this.blockSize;
        int var9 = var5;

        while(true) {
            while(var6 < this.blocks.length) {
                if (this.blocks[var6] == null) {
                    this.blocks[var6] = this.source.get();
                }

                System.arraycopy(var3, var4 + var5 - var9, this.blocks[var6], var7, Math.min(var8 - var7, var9));
                ++var6;
                var9 -= var8 - var7;
                var7 = 0;
                if (var9 <= 0) {
                    this.length = Math.max(this.length, var1 + (long)var5 + 1L);
                    return;
                }
            }

            this.grow();
        }
    }

    void get(long var1, byte[] var3, int var4, int var5) {
        assert var1 >= 0L && var1 + (long)var5 <= this.length && var4 >= 0 && var4 + var5 <= var3.length : " offset: " + var1 + " this.length: " + this.length + " destOffset: " + var4 + " length: " + var5;

        int var6 = (int)(var1 / this.blockSize);
        int var7 = (int)(var1 % this.blockSize);
        int var8 = (int)this.blockSize;
        int var9 = var5;

        do {
            System.arraycopy(this.blocks[var6], var7, var3, var4 + var5 - var9, Math.min(var8 - var7, var9));
            ++var6;
            var9 -= var8 - var7;
            var7 = 0;
        } while(var9 > 0);

    }

    void free() {
        for(int var1 = 0; var1 < this.blocks.length; ++var1) {
            if (this.blocks[var1] != null) {
                this.source.put(this.blocks[var1]);
                this.blocks[var1] = null;
            }
        }

        this.position = 0L;
        this.length = 0L;
    }

    long updateChecksum(long var1, int var3, CRC64 var4, long var5) {
        int var7 = (int)(var1 / this.blockSize);
        int var8 = (int)(var1 % this.blockSize);
        int var9 = var3;

        long var10;
        for(var10 = var5; var9 > 0; var8 = 0) {
            int var12 = Math.min(var9, (int)this.blockSize - var8);
            var10 = CRC64.updateChecksum(var10, this.blocks[var7], var8, var12);
            var9 -= var12;
            ++var7;
        }

        return var10;
    }

    final char[] getChars(long var1, int var3, CharacterSet var4, int[] var5) throws SQLException {
        String var6 = this.getString(var1, var3, var4);
        char[] var7 = var6.toCharArray();
        var5[0] = var7.length;
        return var7;
    }

    final String getString(long var1, int var3, CharacterSet var4) throws SQLException {
        switch(var4.getOracleId()) {
            case 1:
                return this.getStringFromUS7ASCII(var1, var3);
            case 2:
                return this.getStringFrom1Byte(var1, var3, WE8DEC_TO_JAVA);
            case 31:
                return this.getStringFrom1Byte(var1, var3, ISO_LATIN_1_TO_JAVA);
            case 178:
                return this.getStringFrom1Byte(var1, var3, WE8MSWIN1252_TO_JAVA);
            case 871:
                return this.getStringFromUTF8(var1, var3);
            case 873:
                return this.getStringFromAL32UTF8(var1, var3);
            case 2000:
                return this.getStringFromAL16UTF16(var1, var3);
            case 2002:
                return this.getStringFromAL16UTF16LE(var1, var3);
            default:
                assert false : "charSet: " + var4.toString();

                int var5 = (int)(var1 / this.blockSize);
                int var6 = (int)(var1 % this.blockSize);
                if (var3 <= (int)this.blockSize - var6) {
                    return var4.toString(this.blocks[var5], var6, var3);
                } else {
                    byte[] var7 = this.get(var1, var3);
                    return var4.toString(var7, 0, var7.length);
                }
        }
    }

    private final String getStringFromUS7ASCII(long var1, int var3) throws SQLException {
        assert var1 >= 0L && var3 >= 0 && this.length >= var1 + (long)var3 : "this.length: " + this.length + " offset: " + var1 + " lengthInBytes: " + var3;

        int var4 = (int)(var1 / this.blockSize);
        int var5 = (int)(var1 % this.blockSize);
        Object var6 = null;
        int var7 = var3;
        char[] var8 = new char[var3];

        int var9;
        for(var9 = 0; var7 > 0; var5 = 0) {
            byte[] var11 = this.blocks[var4++];
            int var10 = Math.min(var5 + var7, var11.length);

            for(var7 = var7 - var10 + var5; var5 < var10; var8[var9++] = (char)var11[var5++]) {
            }
        }

        assert var9 == var8.length : "charIndex: " + var9 + "\tchars.length: " + var8.length;

        return new String(var8);
    }

    private static final char[] intToChar(int[] var0) {
        char[] var1 = new char[var0.length];

        for(int var2 = 0; var2 < var0.length; ++var2) {
            var1[var2] = (char)var0[var2];
        }

        return var1;
    }

    private final String getStringFrom1Byte(long var1, int var3, char[] var4) throws SQLException {
        assert var1 >= 0L && var3 >= 0 && this.length >= var1 + (long)var3 : "this.length: " + this.length + " offset: " + var1 + " lengthInBytes: " + var3;

        int var5 = (int)(var1 / this.blockSize);
        int var6 = (int)(var1 % this.blockSize);
        Object var7 = null;
        int var8 = var3;
        char[] var9 = new char[var3];

        int var10;
        for(var10 = 0; var8 > 0; var6 = 0) {
            byte[] var12 = this.blocks[var5++];
            int var11 = Math.min(var6 + var8, var12.length);

            for(var8 = var8 - var11 + var6; var6 < var11; var9[var10++] = var4[var12[var6++] & 255]) {
            }
        }

        assert var10 == var9.length : "charIndex: " + var10 + "\tchars.length: " + var9.length;

        return new String(var9);
    }

    private final void setGlobals(long var1, int var3) {
        this.globalBlockIndex = (int)(var1 / this.blockSize);
        this.globalByteIndex = (int)(var1 % this.blockSize);
        this.globalRemaining = var3;
        this.globalBlockSize = (int)this.blockSize;
        this.globalBytes = this.globalBlockIndex < this.blocks.length ? this.blocks[this.globalBlockIndex++] : null;
    }

    private final byte next() {
        assert this.globalRemaining > 0 : "next overrun in DBA";

        byte var1 = this.globalBytes[this.globalByteIndex++];
        --this.globalRemaining;
        if (this.globalByteIndex >= this.globalBlockSize) {
            this.globalBytes = this.globalBlockIndex < this.blocks.length ? this.blocks[this.globalBlockIndex++] : null;
            this.globalByteIndex = 0;
        }

        return var1;
    }

    private final byte peek() {
        assert this.globalRemaining > 0 : "peek overrun in DBA";

        return this.globalBytes[this.globalByteIndex];
    }

    private final void back() {
        if (this.globalByteIndex == 0) {
            this.globalByteIndex = this.globalBlockSize;
            --this.globalBlockIndex;
            this.globalBytes = this.blocks[this.globalBlockIndex];
        }

        --this.globalByteIndex;
        ++this.globalRemaining;
    }

    private final String getStringFromAL16UTF16(long var1, int var3) throws SQLException {
        assert var1 >= 0L && var3 >= 0 && this.length >= var1 + (long)var3 : "this.length: " + this.length + " offset: " + var1 + " lengthInBytes: " + var3;

        assert var3 % 2 == 0 : "lengthInBytes: " + var3;

        this.setGlobals(var1, var3);
        char[] var4 = new char[var3 / 2];

        int var5;
        int var6;
        for(var5 = 0; this.globalRemaining > 0; var4[var5++] = (char)(var6 | this.next() & 255)) {
            var6 = this.next() << 8;
        }

        assert var5 == var4.length : "charIndex: " + var5 + "\tchars.length: " + var4.length;

        return new String(var4);
    }

    private final String getStringFromAL16UTF16LE(long var1, int var3) throws SQLException {
        assert var1 >= 0L && var3 >= 0 && this.length >= var1 + (long)var3 : "this.length: " + this.length + " offset: " + var1 + " lengthInBytes: " + var3;

        assert var3 % 2 == 0 : "lengthInBytes: " + var3;

        this.setGlobals(var1, var3);
        char[] var4 = new char[var3 / 2];
        int var5 = 0;

        while(this.globalRemaining > 0) {
            byte var6 = this.next();
            char var7 = (char)(this.next() << 8 | var6 & 255);
            if (!this.isHiSurrogate(var7)) {
                var4[var5++] = var7;
            } else {
                if (this.globalRemaining == 0) {
                    var4[var5++] = '�';
                    break;
                }

                var6 = this.next();
                char var8 = (char)(this.next() << 8 | var6 & 255);
                if (this.isLoSurrogate(var8)) {
                    var4[var5++] = var7;
                } else {
                    var4[var5++] = '�';
                }

                var4[var5++] = var8;
            }
        }

        assert var5 == var4.length : "charIndex: " + var5 + "\tchars.length: " + var4.length;

        return new String(var4);
    }

    private final String getStringFromUTF8(long var1, int var3) throws SQLException {
        assert var1 >= 0L && var3 >= 0 && this.length >= var1 + (long)var3 : "this.length: " + this.length + " offset: " + var1 + " lengthInBytes: " + var3;

        this.setGlobals(var1, var3);
        int var4 = (int)((var1 + (long)var3 - 1L) / this.blockSize) + 1;
        int var5 = (int)((var1 + (long)var3 - 1L) % this.blockSize) + 1;
        char[] var6 = new char[var3];
        int var7 = 0;

        while(true) {
            while(this.globalRemaining > 0) {
                byte var8 = this.next();
                if (var8 >= 0) {
                    var6[var7++] = (char)var8;
                    int var15 = this.globalBlockIndex == var4 ? var5 : (this.globalBlockIndex < var4 ? (int)this.blockSize : 0);

                    int var16;
                    for(var16 = this.globalByteIndex; var16 < var15; ++var16) {
                        var8 = this.globalBytes[var16];
                        if (var8 < 0) {
                            break;
                        }

                        var6[var7++] = (char)var8;
                    }

                    this.globalRemaining -= var16 - this.globalByteIndex;
                    this.globalByteIndex = var16;
                    if (this.globalByteIndex >= this.globalBlockSize) {
                        this.globalByteIndex = 0;
                        this.globalBytes = this.globalBlockIndex < this.blocks.length ? this.blocks[this.globalBlockIndex++] : null;
                    }
                } else {
                    int var9 = var8 & 240;
                    byte var10 = (byte)(var8 << 2);
                    char var11;
                    if (var10 >= 0) {
                        if (this.globalRemaining < 1) {
                            var6[var7++] = '�';
                        } else {
                            var11 = this.conv2ByteUTFtoUTF16(var8, this.next());
                            var6[var7++] = var11;
                        }
                    } else {
                        var10 = (byte)(var10 << 1);
                        if (var10 >= 0) {
                            if (this.globalRemaining < 2) {
                                var6[var7++] = '�';
                            } else {
                                byte var13 = this.next();
                                byte var14 = this.next();
                                char var12 = this.conv3ByteUTFtoUTF16(var8, var13, var14);
                                if (this.isHiSurrogate(var12) && this.globalRemaining > 0) {
                                    var8 = this.peek();
                                    if ((byte)(var8 & 240) != -32) {
                                        var6[var7++] = '�';
                                    } else {
                                        this.next();
                                        if (this.globalRemaining < 2) {
                                            var6[var7++] = '�';
                                        } else {
                                            var13 = this.next();
                                            var14 = this.next();
                                            var11 = this.conv3ByteUTFtoUTF16(var8, var13, var14);
                                            if (this.isLoSurrogate(var11)) {
                                                var6[var7++] = var12;
                                            } else {
                                                var6[var7++] = '�';
                                            }

                                            var6[var7++] = var11;
                                        }
                                    }
                                } else {
                                    var6[var7++] = var12;
                                }
                            }
                        } else {
                            var6[var7++] = '�';
                        }
                    }
                }
            }

            return new String(var6, 0, var7);
        }
    }

    private final String getStringFromAL32UTF8(long var1, int var3) throws SQLException {
        assert var1 >= 0L && var3 >= 0 && this.length >= var1 + (long)var3 : "this.length: " + this.length + " offset: " + var1 + " lengthInBytes: " + var3;

        this.setGlobals(var1, var3);
        int var4 = (int)((var1 + (long)var3 - 1L) / this.blockSize) + 1;
        int var5 = (int)((var1 + (long)var3 - 1L) % this.blockSize) + 1;
        char[] var6 = new char[var3];
        int var7 = 0;

        while(true) {
            while(this.globalRemaining > 0) {
                byte var8 = this.next();
                if (var8 >= 0) {
                    var6[var7++] = (char)var8;
                    int var10 = this.globalBlockIndex == var4 ? var5 : (this.globalBlockIndex < var4 ? (int)this.blockSize : 0);

                    int var11;
                    for(var11 = this.globalByteIndex; var11 < var10; ++var11) {
                        var8 = this.globalBytes[var11];
                        if (var8 < 0) {
                            break;
                        }

                        var6[var7++] = (char)var8;
                    }

                    this.globalRemaining -= var11 - this.globalByteIndex;
                    this.globalByteIndex = var11;
                    if (this.globalByteIndex >= this.globalBlockSize) {
                        this.globalByteIndex = 0;
                        this.globalBytes = this.globalBlockIndex < this.blocks.length ? this.blocks[this.globalBlockIndex++] : null;
                    }
                } else {
                    byte var9 = (byte)(var8 << 2);
                    if (var9 >= 0) {
                        if (this.globalRemaining < 1) {
                            var6[var7++] = '�';
                        } else {
                            var6[var7++] = this.conv2ByteUTFtoUTF16(var8, this.next());
                        }
                    } else {
                        var9 = (byte)(var9 << 1);
                        if (var9 >= 0) {
                            if (this.globalRemaining < 2) {
                                var6[var7++] = '�';
                            } else {
                                var6[var7++] = this.conv3ByteAL32UTF8toUTF16(var8, this.next(), this.next());
                            }
                        } else {
                            var9 = (byte)(var9 << 1);
                            if (var9 >= 0) {
                                if (this.globalRemaining < 3) {
                                    var6[var7++] = '�';
                                } else {
                                    var7 = this.conv4ByteAL32UTF8toUTF16(var8, this.next(), this.next(), this.next(), var6, var7);
                                }
                            } else {
                                var6[var7++] = '�';
                            }
                        }
                    }
                }
            }

            return new String(var6, 0, var7);
        }
    }

    private final boolean isHiSurrogate(char var1) {
        return (char)(var1 & 'ﰀ') == '\ud800';
    }

    private final boolean isLoSurrogate(char var1) {
        return (char)(var1 & 'ﰀ') == '\udc00';
    }

    private final boolean check80toBF(byte var1) {
        return (var1 & -64) == -128;
    }

    private final boolean check80to8F(byte var1) {
        return (var1 & -16) == -128;
    }

    private final boolean check80to9F(byte var1) {
        return (var1 & -32) == -128;
    }

    private final boolean checkA0toBF(byte var1) {
        return (var1 & -32) == -96;
    }

    private final boolean check90toBF(byte var1) {
        return (var1 & -64) == -128 && (var1 & 48) != 0;
    }

    private final char conv2ByteUTFtoUTF16(byte var1, byte var2) {
        if (var1 >= -62 && var1 <= -33 && this.check80toBF(var2)) {
            return (char)((var1 & 31) << 6 | var2 & 63);
        } else {
            this.back();
            return '�';
        }
    }

    private final char conv3ByteUTFtoUTF16(byte var1, byte var2, byte var3) {
        if (var1 == -32 && this.checkA0toBF(var2) && this.check80toBF(var3) || var1 >= -31 && var1 <= -17 && this.check80toBF(var2) && this.check80toBF(var3)) {
            return (char)((var1 & 15) << 12 | (var2 & 63) << 6 | var3 & 63);
        } else {
            this.back();
            this.back();
            return '�';
        }
    }

    private final char conv3ByteAL32UTF8toUTF16(byte var1, byte var2, byte var3) {
        if ((var1 != -32 || !this.checkA0toBF(var2) || !this.check80toBF(var3)) && (var1 < -31 || var1 > -20 || !this.check80toBF(var2) || !this.check80toBF(var3)) && (var1 != -19 || !this.check80to9F(var2) || !this.check80toBF(var3)) && (var1 < -18 || var1 > -17 || !this.check80toBF(var2) || !this.check80toBF(var3))) {
            this.back();
            this.back();
            return '�';
        } else {
            return (char)((var1 & 15) << 12 | (var2 & 63) << 6 | var3 & 63);
        }
    }

    private final int conv4ByteAL32UTF8toUTF16(byte var1, byte var2, byte var3, byte var4, char[] var5, int var6) {
        boolean var7 = false;
        if (var1 == -16 && this.check90toBF(var2) && this.check80toBF(var3) && this.check80toBF(var4) || var1 >= -15 && var1 <= -13 && this.check80toBF(var2) && this.check80toBF(var3) && this.check80toBF(var4) || var1 == -12 && this.check80to8F(var2) && this.check80toBF(var3) && this.check80toBF(var4)) {
            var5[var6++] = (char)((((var1 & 7) << 2 | var2 >>> 4 & 3) - 1 & 15) << 6 | (var2 & 15) << 2 | var3 >>> 4 & 3 | '\ud800');
            var5[var6++] = (char)((var3 & 15) << 6 | var4 & 63 | '\udc00');
        } else {
            this.back();
            this.back();
            this.back();
            var5[var6++] = '�';
        }

        return var6;
    }

    byte[] getBlockBasic(long var1, int[] var3) {
        int var4 = (int)(var1 / this.blockSize);
        var3[0] = (int)(var1 % this.blockSize);
        return var4 >= this.blocks.length ? null : this.blocks[var4];
    }

    private static String escape(String var0) {
        StringBuilder var1 = new StringBuilder(var0.length() * 6);
        char[] var2 = var0.toCharArray();
        int var3 = var2.length;

        for(int var4 = 0; var4 < var3; ++var4) {
            char var5 = var2[var4];
            var1.append("\\u");
            byte var6 = (byte)(var5 >> 8);
            String var7 = "00" + Integer.toHexString(var6 & 255);
            var1.append(var7, var7.length() - 2, var7.length());
            var7 = "00" + Integer.toHexString((byte)var5 & 255);
            var1.append(var7, var7.length() - 2, var7.length());
        }

        return var1.toString();
    }

    static {
        final char[][] var0 = new char[3][];
        AccessController.doPrivileged(new PrivilegedAction() {
            public Object run() {
                JdbcCharacterConverters var1 = CharacterConverterJDBC.getInstance(31);
                var0[0] = DynamicByteArray.intToChar(((CharacterConverter1Byte)var1).m_ucsChar);
                var1 = CharacterConverterJDBC.getInstance(2);
                var0[1] = DynamicByteArray.intToChar(((CharacterConverter1Byte)var1).m_ucsChar);
                var1 = CharacterConverterJDBC.getInstance(178);
                var0[2] = DynamicByteArray.intToChar(((CharacterConverter1Byte)var1).m_ucsChar);
                return null;
            }
        });
        ISO_LATIN_1_TO_JAVA = var0[0];
        WE8DEC_TO_JAVA = var0[1];
        WE8MSWIN1252_TO_JAVA = var0[2];
        _Copyright_2007_Oracle_All_Rights_Reserved_ = null;
    }
}
