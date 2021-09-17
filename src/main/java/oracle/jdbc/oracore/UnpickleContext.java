//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package oracle.jdbc.oracore;

import java.sql.SQLException;
import java.util.Vector;

public final class UnpickleContext {
    byte[] image;
    int absoluteOffset;
    int beginOffset;
    int markedOffset;
    Vector patches;
    long[] ldsOffsets;
    boolean[] nullIndicators;
    boolean bigEndian;
    private static final String _Copyright_2007_Oracle_All_Rights_Reserved_ = null;
    public static final String BUILD_DATE = "Thu_Apr_04_15:09:24_PDT_2013";
    public static final boolean TRACE = false;

    public UnpickleContext() {
    }

    public UnpickleContext(byte[] var1, int var2, boolean[] var3, long[] var4, boolean var5) {
        this.image = var1;
        this.beginOffset = var2;
        this.absoluteOffset = var2;
        this.bigEndian = var5;
        this.nullIndicators = var3;
        this.patches = null;
        this.ldsOffsets = var4;
    }

    public byte readByte() throws SQLException {
        byte var1;
        try {
            var1 = this.image[this.absoluteOffset];
        } finally {
            ++this.absoluteOffset;
        }

        return var1;
    }

    public byte[] readVarNumBytes() throws SQLException {
        byte[] var1 = new byte[this.image[this.absoluteOffset] & 255];

        try {
            System.arraycopy(this.image, this.absoluteOffset + 1, var1, 0, var1.length);
        } finally {
            this.absoluteOffset += 22;
        }

        return var1;
    }

    public byte[] readPtrBytes() throws SQLException {
        byte[] var1 = new byte[(this.image[this.absoluteOffset] & 255) * 256 + (this.image[this.absoluteOffset + 1] & 255) + 2];
        System.arraycopy(this.image, this.absoluteOffset, var1, 0, var1.length);
        this.absoluteOffset += var1.length;
        return var1;
    }

    public void skipPtrBytes() throws SQLException {
        this.absoluteOffset += (this.image[this.absoluteOffset] & 255) * 256 + (this.image[this.absoluteOffset + 1] & 255) + 2;
    }

    public byte[] readBytes(int var1) throws SQLException {
        byte[] var3;
        try {
            byte[] var2 = new byte[var1];
            System.arraycopy(this.image, this.absoluteOffset, var2, 0, var1);
            var3 = var2;
        } finally {
            this.absoluteOffset += var1;
        }

        return var3;
    }

    public long readLong() throws SQLException {
        long var1;
        try {
            var1 = (long)((((this.image[this.absoluteOffset] & 255) * 256 + (this.image[this.absoluteOffset + 1] & 255)) * 256 + (this.image[this.absoluteOffset + 2] & 255)) * 256 + (this.image[this.absoluteOffset + 3] & 255));
        } finally {
            this.absoluteOffset += 4;
        }

        return var1;
    }

    public short readShort() throws SQLException {
        short var1;
        try {
            var1 = (short)((this.image[this.absoluteOffset] & 255) * 256 + (this.image[this.absoluteOffset + 1] & 255));
        } finally {
            this.absoluteOffset += 2;
        }

        return var1;
    }

    public byte[] readLengthBytes() throws SQLException {
        long var1 = this.readLong();
        return this.readBytes((int)var1);
    }

    public void skipLengthBytes() throws SQLException {
        long var1 = this.readLong();
        this.absoluteOffset = (int)((long)this.absoluteOffset + var1);
    }

    public void skipTo(long var1) throws SQLException {
        if (var1 > (long)(this.absoluteOffset - this.beginOffset)) {
            this.absoluteOffset = this.beginOffset + (int)var1;
        }

    }

    public void skipTo(int var1) throws SQLException {
        if (var1 > this.absoluteOffset - this.beginOffset) {
            this.absoluteOffset = this.beginOffset + var1;
        }

    }

    public void mark() throws SQLException {
        this.markedOffset = this.absoluteOffset;
    }

    public void reset() throws SQLException {
        this.absoluteOffset = this.markedOffset;
    }

    public void markAndSkip() throws SQLException {
        this.markedOffset = this.absoluteOffset + 4;
        this.absoluteOffset = this.beginOffset + (int)this.readLong();
    }

    public void markAndSkip(long var1) throws SQLException {
        this.markedOffset = this.absoluteOffset;
        this.absoluteOffset = this.beginOffset + (int)var1;
    }

    public void skipBytes(int var1) throws SQLException {
        if (var1 >= 0) {
            this.absoluteOffset += var1;
        }

    }

    public boolean isNull(int var1) {
        return this.nullIndicators[var1];
    }

    public int absoluteOffset() throws SQLException {
        return this.absoluteOffset;
    }

    public int offset() throws SQLException {
        return this.absoluteOffset - this.beginOffset;
    }

    public byte[] image() throws SQLException {
        return this.image;
    }
}
