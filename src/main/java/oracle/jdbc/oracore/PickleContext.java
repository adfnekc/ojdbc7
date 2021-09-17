//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package oracle.jdbc.oracore;

import java.io.IOException;
import java.sql.SQLException;
import oracle.jdbc.driver.DatabaseError;
import oracle.jdbc.internal.OracleConnection;

public final class PickleContext {
    private PickleOutputStream outStream;
    byte[] image;
    int imageOffset;
    private byte[] lengthBuffer = new byte[5];
    static short KOPI20_LN_ELNL = 255;
    static short KOPI20_LN_5BLN = 254;
    static short KOPI20_LN_ATMN = 253;
    static short KOPI20_LN_IEMN = 252;
    static short KOPI20_LN_MAXV = 245;
    static short KOPI20_IF_IS81 = 128;
    static short KOPI20_IF_CMSB = 64;
    static short KOPI20_IF_CLSB = 32;
    static short KOPI20_IF_DEGN = 16;
    static short KOPI20_IF_COLL = 8;
    static short KOPI20_IF_NOPS = 4;
    static short KOPI20_IF_ANY = 2;
    static short KOPI20_IF_NONL = 1;
    static short KOPI20_CF_CMSB = 64;
    static short KOPI20_CF_CLSB = 32;
    static short KOPI20_CF_INDX = 16;
    static short KOPI20_CF_NOLN = 8;
    static short KOPI20_VERSION = 1;
    static final byte KOPUP_INLINE_COLL = 1;
    static final byte KOPUP_TYPEINFO_NONE = 0;
    static final byte KOPUP_TYPEINFO_TOID = 4;
    static final byte KOPUP_TYPEINFO_TOBJN = 8;
    static final byte KOPUP_TYPEINFO_TDS = 12;
    static final byte KOPUP_VSN_PRESENT = 16;
    private static final String _Copyright_2007_Oracle_All_Rights_Reserved_ = null;
    public static final String BUILD_DATE = "Thu_Apr_04_15:09:24_PDT_2013";
    public static final boolean TRACE = false;

    public PickleContext() {
    }

    public PickleContext(byte[] var1) {
        this.image = var1;
        this.imageOffset = 0;
    }

    public PickleContext(byte[] var1, long var2) {
        this.image = var1;
        this.imageOffset = (int)var2;
    }

    public void initStream(int var1) {
        this.outStream = new PickleOutputStream(var1);
    }

    public void initStream() {
        this.outStream = new PickleOutputStream();
    }

    public int lengthInBytes(int var1) {
        return var1 <= KOPI20_LN_MAXV ? 1 : 5;
    }

    public int writeElementNull() throws SQLException {
        this.outStream.write(KOPI20_LN_ELNL);
        return 1;
    }

    public int writeAtomicNull() throws SQLException {
        this.outStream.write(KOPI20_LN_ATMN);
        return 1;
    }

    public int writeImmediatelyEmbeddedElementNull(byte var1) throws SQLException {
        this.lengthBuffer[0] = (byte)KOPI20_LN_IEMN;
        this.lengthBuffer[1] = var1;
        this.outStream.write(this.lengthBuffer, 0, 2);
        return 2;
    }

    public int writeSB2(int var1) throws SQLException {
        this.lengthBuffer[0] = (byte)(var1 >> 8 & 255);
        this.lengthBuffer[1] = (byte)(var1 & 255);
        this.outStream.write(this.lengthBuffer, 0, 2);
        return 2;
    }

    public int writeLength(int var1) throws SQLException {
        if (var1 <= KOPI20_LN_MAXV) {
            this.outStream.write((byte)var1);
            return 1;
        } else {
            this.lengthBuffer[0] = (byte)KOPI20_LN_5BLN;
            this.lengthBuffer[1] = (byte)(var1 >> 24);
            var1 &= 16777215;
            this.lengthBuffer[2] = (byte)(var1 >> 16);
            var1 &= 65535;
            this.lengthBuffer[3] = (byte)(var1 >> 8);
            var1 &= 255;
            this.lengthBuffer[4] = (byte)var1;

            try {
                this.outStream.write(this.lengthBuffer);
                return 5;
            } catch (IOException var4) {
                SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), var4);
                var3.fillInStackTrace();
                throw var3;
            }
        }
    }

    public int writeLength(int var1, boolean var2) throws SQLException {
        if (!var2) {
            return this.writeLength(var1);
        } else if (var1 <= KOPI20_LN_MAXV - 1) {
            this.outStream.write((byte)var1 + 1);
            return 1;
        } else {
            var1 += 5;
            this.lengthBuffer[0] = (byte)KOPI20_LN_5BLN;
            this.lengthBuffer[1] = (byte)(var1 >> 24);
            var1 &= 16777215;
            this.lengthBuffer[2] = (byte)(var1 >> 16);
            var1 &= 65535;
            this.lengthBuffer[3] = (byte)(var1 >> 8);
            var1 &= 255;
            this.lengthBuffer[4] = (byte)var1;

            try {
                this.outStream.write(this.lengthBuffer);
                return 5;
            } catch (IOException var5) {
                SQLException var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), var5);
                var4.fillInStackTrace();
                throw var4;
            }
        }
    }

    public byte[] to5bLengthBytes_pctx(int var1) throws SQLException {
        this.lengthBuffer[0] = (byte)KOPI20_LN_5BLN;
        this.lengthBuffer[1] = (byte)(var1 >> 24);
        var1 &= 16777215;
        this.lengthBuffer[2] = (byte)(var1 >> 16);
        var1 &= 65535;
        this.lengthBuffer[3] = (byte)(var1 >> 8);
        var1 &= 255;
        this.lengthBuffer[4] = (byte)var1;
        return this.lengthBuffer;
    }

    public int writeData(byte var1) throws SQLException {
        this.outStream.write(var1);
        return 1;
    }

    public int writeData(byte[] var1) throws SQLException {
        try {
            this.outStream.write(var1);
        } catch (IOException var4) {
            SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), var4);
            var3.fillInStackTrace();
            throw var3;
        }

        return var1.length;
    }

    public void patchImageLen(int var1, int var2) throws SQLException {
        byte[] var3 = this.to5bLengthBytes_pctx(var2);
        this.outStream.overwrite(var1, var3, 0, var3.length);
    }

    public int writeImageHeader(boolean var1) throws SQLException {
        return this.writeImageHeader(KOPI20_LN_MAXV + 1, var1);
    }

    public int writeOpaqueImageHeader(int var1) throws SQLException {
        byte var2 = 2;
        this.lengthBuffer[0] = (byte)(KOPI20_IF_IS81 | KOPI20_IF_NOPS | KOPI20_IF_NONL);
        this.lengthBuffer[1] = (byte)KOPI20_VERSION;
        this.outStream.write(this.lengthBuffer, 0, 2);
        int var3 = var2 + this.writeLength(var1 + 2, true);
        return var3;
    }

    public int writeImageHeader(int var1, boolean var2) throws SQLException {
        byte var3 = 2;
        if (var2) {
            this.lengthBuffer[0] = (byte)KOPI20_IF_IS81;
        } else {
            this.lengthBuffer[0] = (byte)(KOPI20_IF_IS81 | KOPI20_IF_NOPS);
        }

        this.lengthBuffer[1] = (byte)KOPI20_VERSION;
        this.outStream.write(this.lengthBuffer, 0, 2);
        int var4 = var3 + this.writeLength(var1);
        return var4;
    }

    public int writeCollImageHeader(int var1, int var2) throws SQLException {
        return this.writeCollImageHeader(KOPI20_LN_MAXV + 1, var1, var2);
    }

    public int writeCollImageHeader(int var1, int var2, int var3) throws SQLException {
        byte var4 = 5;
        this.lengthBuffer[0] = (byte)(KOPI20_IF_IS81 | KOPI20_IF_COLL);
        this.lengthBuffer[1] = (byte)KOPI20_VERSION;
        this.outStream.write(this.lengthBuffer, 0, 2);
        int var5 = var4 + this.writeLength(var1);
        this.lengthBuffer[0] = 1;
        this.lengthBuffer[1] = 17;
        byte[] var10000;
        if (var3 > KOPI20_LN_MAXV) {
            var10000 = this.lengthBuffer;
            var10000[0] = (byte)(var10000[0] + 5);
            var5 += 5;
            this.outStream.write(this.lengthBuffer, 0, 2);
            this.writeLength(var3);
        } else {
            var10000 = this.lengthBuffer;
            var10000[0] = (byte)(var10000[0] + 2);
            var5 += 2;
            this.outStream.write(this.lengthBuffer, 0, 2);
            this.writeSB2(var3);
        }

        this.lengthBuffer[0] = 0;
        this.outStream.write(this.lengthBuffer, 0, 1);
        var5 += this.writeLength(var2);
        return var5;
    }

    public int writeCollImageHeader(byte[] var1) throws SQLException {
        return this.writeCollImageHeader(KOPI20_LN_MAXV + 1, var1);
    }

    public int writeCollImageHeader(int var1, byte[] var2) throws SQLException {
        int var3 = var2.length;
        int var4 = 3 + var3;
        this.lengthBuffer[0] = (byte)(KOPI20_IF_IS81 | KOPI20_IF_DEGN);
        this.lengthBuffer[1] = (byte)KOPI20_VERSION;
        this.outStream.write(this.lengthBuffer, 0, 2);
        var4 += this.writeLength(var1);
        var4 += this.writeLength(var3 + 1);
        this.lengthBuffer[0] = 0;
        this.outStream.write(this.lengthBuffer, 0, 1);
        this.outStream.write(var2, 0, var3);
        return var4;
    }

    public byte[] stream2Bytes() throws SQLException {
        return this.outStream.toByteArray();
    }

    public byte readByte() throws SQLException {
        byte var1;
        try {
            var1 = this.image[this.imageOffset];
        } finally {
            ++this.imageOffset;
        }

        return var1;
    }

    public boolean readAndCheckVersion() throws SQLException {
        boolean var1;
        try {
            var1 = (this.image[this.imageOffset] & 255) <= KOPI20_VERSION;
        } finally {
            ++this.imageOffset;
        }

        return var1;
    }

    public int readLength() throws SQLException {
        int var1 = this.image[this.imageOffset] & 255;
        if (var1 > KOPI20_LN_MAXV) {
            if (var1 == KOPI20_LN_ELNL) {
                SQLException var2 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 1, "Invalid null flag read");
                var2.fillInStackTrace();
                throw var2;
            }

            var1 = (((this.image[this.imageOffset + 1] & 255) * 256 + (this.image[this.imageOffset + 2] & 255)) * 256 + (this.image[this.imageOffset + 3] & 255)) * 256 + (this.image[this.imageOffset + 4] & 255);
            this.imageOffset += 5;
        } else {
            ++this.imageOffset;
        }

        return var1;
    }

    public void skipLength() throws SQLException {
        int var1 = this.image[this.imageOffset] & 255;
        if (var1 > KOPI20_LN_MAXV) {
            this.imageOffset += 5;
        } else {
            ++this.imageOffset;
        }

    }

    public int readRestOfLength(byte var1) throws SQLException {
        if ((var1 & 255) != KOPI20_LN_5BLN) {
            return var1 & 255;
        } else {
            int var2;
            try {
                var2 = (((this.image[this.imageOffset] & 255) * 256 + (this.image[this.imageOffset + 1] & 255)) * 256 + (this.image[this.imageOffset + 2] & 255)) * 256 + (this.image[this.imageOffset + 3] & 255);
            } finally {
                this.imageOffset += 4;
            }

            return var2;
        }
    }

    public void skipRestOfLength(byte var1) throws SQLException {
        if ((var1 & 255) > KOPI20_LN_MAXV) {
            if ((var1 & 255) != KOPI20_LN_5BLN) {
                SQLException var2 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 1, "Invalid first length byte");
                var2.fillInStackTrace();
                throw var2;
            }

            this.imageOffset += 4;
        }

    }

    public int readLength(boolean var1) throws SQLException {
        int var2 = this.image[this.imageOffset] & 255;
        if (var2 > KOPI20_LN_MAXV) {
            var2 = (((this.image[this.imageOffset + 1] & 255) * 256 + (this.image[this.imageOffset + 2] & 255)) * 256 + (this.image[this.imageOffset + 3] & 255)) * 256 + (this.image[this.imageOffset + 4] & 255);
            if (var1) {
                var2 -= 5;
            }

            this.imageOffset += 5;
        } else {
            if (var1) {
                --var2;
            }

            ++this.imageOffset;
        }

        return var2;
    }

    public byte[] readPrefixSegment() throws SQLException {
        byte[] var1 = new byte[this.readLength()];
        System.arraycopy(this.image, this.imageOffset, var1, 0, var1.length);
        this.imageOffset += var1.length;
        return var1;
    }

    public byte[] readDataValue() throws SQLException {
        int var1 = this.image[this.imageOffset] & 255;
        if (var1 == KOPI20_LN_ELNL) {
            ++this.imageOffset;
            return null;
        } else {
            if (var1 > KOPI20_LN_MAXV) {
                var1 = (((this.image[this.imageOffset + 1] & 255) * 256 + (this.image[this.imageOffset + 2] & 255)) * 256 + (this.image[this.imageOffset + 3] & 255)) * 256 + (this.image[this.imageOffset + 4] & 255);
                this.imageOffset += 5;
            } else {
                ++this.imageOffset;
            }

            byte[] var2 = new byte[var1];
            System.arraycopy(this.image, this.imageOffset, var2, 0, var2.length);
            this.imageOffset += var2.length;
            return var2;
        }
    }

    public byte[] readBytes(int var1) throws SQLException {
        byte[] var2 = new byte[var1];
        System.arraycopy(this.image, this.imageOffset, var2, 0, var1);
        this.imageOffset += var1;
        return var2;
    }

    public byte[] read1ByteDataValue() throws SQLException {
        if ((this.image[this.imageOffset] & 255) == KOPI20_LN_ELNL) {
            return null;
        } else {
            byte[] var1 = new byte[this.image[this.imageOffset] & 255];
            System.arraycopy(this.image, this.imageOffset + 1, var1, 0, var1.length);
            this.imageOffset += var1.length + 1;
            return var1;
        }
    }

    public byte[] readDataValue(byte var1) throws SQLException {
        byte[] var2 = new byte[this.readRestOfLength(var1)];
        System.arraycopy(this.image, this.imageOffset, var2, 0, var2.length);
        this.imageOffset += var2.length;
        return var2;
    }

    public byte[] readDataValue(int var1) throws SQLException {
        byte[] var2 = new byte[var1];
        System.arraycopy(this.image, this.imageOffset, var2, 0, var1);
        this.imageOffset += var1;
        return var2;
    }

    public long readUB4() throws SQLException {
        long var1 = (long)this.image[this.imageOffset++] << 24 & -16777216L | (long)this.image[this.imageOffset++] << 16 & 16711680L | (long)this.image[this.imageOffset++] << 8 & 65280L | (long)this.image[this.imageOffset++] & 255L;
        return var1;
    }

    public int readUB2() throws SQLException {
        int var1 = this.image[this.imageOffset++] << 8 & '\uff00' | this.image[this.imageOffset++] & 255;
        return var1;
    }

    public void skipDataValue() throws SQLException {
        if ((this.image[this.imageOffset] & 255) == KOPI20_LN_ELNL) {
            ++this.imageOffset;
        } else {
            this.skipBytes(this.readLength());
        }

    }

    public void skipDataValue(byte var1) throws SQLException {
        this.skipBytes(this.readRestOfLength(var1));
    }

    public void skipBytes(int var1) throws SQLException {
        if (var1 > 0) {
            this.imageOffset += var1;
        }

    }

    public int offset() throws SQLException {
        return this.outStream != null ? this.outStream.offset() : this.imageOffset;
    }

    public int absoluteOffset() throws SQLException {
        return this.imageOffset;
    }

    public void skipTo(long var1) throws SQLException {
        if (var1 > (long)this.imageOffset) {
            this.imageOffset = (int)var1;
        }

    }

    public byte[] image() throws SQLException {
        return this.image;
    }

    public static boolean is81format(byte var0) throws SQLException {
        return (var0 & 255 & KOPI20_IF_IS81) != 0;
    }

    public static boolean isCollectionImage_pctx(byte var0) throws SQLException {
        return (var0 & 255 & KOPI20_IF_COLL) != 0;
    }

    public static boolean isDegenerateImage_pctx(byte var0) throws SQLException {
        return (var0 & 255 & KOPI20_IF_DEGN) != 0;
    }

    public static boolean hasPrefix(byte var0) throws SQLException {
        return (var0 & 255 & KOPI20_IF_NOPS) == 0;
    }

    public static boolean isAtomicNull(byte var0) throws SQLException {
        return (var0 & 255) == KOPI20_LN_ATMN;
    }

    public static boolean isImmediatelyEmbeddedNull(byte var0) throws SQLException {
        return (var0 & 255) == KOPI20_LN_IEMN;
    }

    public static boolean isElementNull(byte var0) throws SQLException {
        return (var0 & 255) == KOPI20_LN_ELNL;
    }

    protected OracleConnection getConnectionDuringExceptionHandling() {
        return null;
    }
}
