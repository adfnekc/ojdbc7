//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package oracle.jdbc.driver;

import java.io.IOException;
import java.sql.SQLException;
import oracle.jdbc.internal.OracleBfile;
import oracle.jdbc.internal.OracleBlob;
import oracle.jdbc.internal.OracleConnection;

class OracleBlobInputStream extends OracleBufferedStream {
    long lobOffset;
    OracleBlob blob;
    OracleBfile bfile;
    boolean isStreamForBlob;
    long markedByte;
    boolean endOfStream;
    long maxPosition;
    private static final String _Copyright_2007_Oracle_All_Rights_Reserved_ = null;
    public static final String BUILD_DATE = "Thu_Apr_04_15:09:24_PDT_2013";
    public static final boolean TRACE = false;

    public OracleBlobInputStream(OracleBlob var1, int var2) throws SQLException {
        this(var1, var2, 1L);
    }

    public OracleBlobInputStream(OracleBlob var1, int var2, long var3) throws SQLException {
        super(var2);
        this.endOfStream = false;
        this.maxPosition = 9223372036854775807L;
        if (var1 != null && var2 > 0 && var3 >= 1L) {
            this.isStreamForBlob = true;
            this.blob = var1;
            this.bfile = null;
            this.markedByte = -1L;
            this.lobOffset = var3;
        } else {
            throw new IllegalArgumentException("Illegal Arguments");
        }
    }

    public OracleBlobInputStream(OracleBlob var1, int var2, long var3, long var5) throws SQLException {
        this(var1, var2, var3);
        this.maxPosition = var3 + var5;
    }

    public OracleBlobInputStream(OracleBfile var1, int var2) throws SQLException {
        this(var1, var2, 1L);
    }

    public OracleBlobInputStream(OracleBfile var1, int var2, long var3) throws SQLException {
        super(var2);
        this.endOfStream = false;
        this.maxPosition = 9223372036854775807L;
        if (var1 != null && var2 > 0 && var3 >= 1L) {
            this.isStreamForBlob = false;
            this.blob = null;
            this.bfile = var1;
            this.markedByte = -1L;
            this.lobOffset = var3;
        } else {
            throw new IllegalArgumentException("Illegal Arguments");
        }
    }

    public boolean needBytes(int var1) throws IOException {
        this.ensureOpen();
        if (this.pos < this.count) {
            return true;
        } else {
            if (!this.endOfStream) {
                if (var1 > this.currentBufferSize || var1 == 0) {
                    this.currentBufferSize = Math.max(var1, this.initialBufferSize);
                    this.resizableBuffer = new byte[this.currentBufferSize];
                }

                try {
                    int var2;
                    if ((long)this.currentBufferSize < this.maxPosition - this.lobOffset) {
                        var2 = this.currentBufferSize;
                    } else {
                        var2 = (int)(this.maxPosition - this.lobOffset);
                    }

                    if (this.isStreamForBlob) {
                        this.count = this.blob.getBytes(this.lobOffset, var2, this.resizableBuffer);
                    } else {
                        this.count = this.bfile.getBytes(this.lobOffset, var2, this.resizableBuffer);
                    }

                    if (this.count < this.currentBufferSize) {
                        this.endOfStream = true;
                    }

                    if (this.count > 0) {
                        this.pos = 0;
                        this.lobOffset += (long)this.count;
                        if (this.lobOffset > this.maxPosition) {
                            this.endOfStream = true;
                        }

                        return true;
                    }
                } catch (SQLException var4) {
                    IOException var3 = DatabaseError.createIOException(var4);
                    var3.fillInStackTrace();
                    throw var3;
                }
            }

            return false;
        }
    }

    void ensureOpen() throws IOException {
        try {
            if (this.closed) {
                SQLException var1 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 57, (Object)null);
                var1.fillInStackTrace();
                throw var1;
            }
        } catch (SQLException var3) {
            IOException var2 = DatabaseError.createIOException(var3);
            var2.fillInStackTrace();
            throw var2;
        }
    }

    public boolean markSupported() {
        return true;
    }

    public void mark(int var1) {
        if (var1 < 0) {
            throw new IllegalArgumentException("Read-ahead limit < 0");
        } else {
            this.markedByte = this.lobOffset - (long)this.count + (long)this.pos;
        }
    }

    public void markInternal(int var1) {
    }

    public void reset() throws IOException {
        this.ensureOpen();
        if (this.markedByte < 0L) {
            throw new IOException("Mark invalid or stream not marked.");
        } else {
            this.lobOffset = this.markedByte;
            this.pos = this.count;
            this.endOfStream = false;
        }
    }

    public long skip(long var1) throws IOException {
        this.ensureOpen();
        long var3 = 0L;
        if ((long)(this.count - this.pos) >= var1) {
            this.pos = (int)((long)this.pos + var1);
            var3 += var1;
        } else {
            var3 += (long)(this.count - this.pos);
            this.pos = this.count;

            try {
                long var5 = 0L;
                if (this.isStreamForBlob) {
                    var5 = this.blob.length() - this.lobOffset + 1L;
                } else {
                    var5 = this.bfile.length() - this.lobOffset + 1L;
                }

                if (var5 >= var1 - var3) {
                    this.lobOffset += var1 - var3;
                    var3 += var1 - var3;
                } else {
                    this.lobOffset += var5;
                    var3 += var5;
                }
            } catch (SQLException var7) {
                IOException var6 = DatabaseError.createIOException(var7);
                var6.fillInStackTrace();
                throw var6;
            }
        }

        return var3;
    }

    protected OracleConnection getConnectionDuringExceptionHandling() {
        OracleConnection var1 = null;

        try {
            if (this.isStreamForBlob && this.blob != null) {
                var1 = this.blob.getInternalConnection();
            } else if (!this.isStreamForBlob && this.bfile != null) {
                var1 = this.bfile.getInternalConnection();
            }
        } catch (Exception var3) {
            var1 = null;
        }

        return var1;
    }
}
