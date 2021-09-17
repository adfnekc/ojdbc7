//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package oracle.jdbc.driver;

import java.io.IOException;
import java.io.OutputStream;
import java.sql.SQLException;
import oracle.jdbc.internal.OracleBlob;
import oracle.jdbc.internal.OracleConnection;
import oracle.sql.BLOB;

class OracleBlobOutputStream extends OutputStream {
    long lobOffset;
    OracleBlob blob;
    byte[] buf;
    int count;
    int bufSize;
    boolean isClosed;
    private static final String _Copyright_2007_Oracle_All_Rights_Reserved_ = null;
    public static final String BUILD_DATE = "Thu_Apr_04_15:09:24_PDT_2013";
    public static final boolean TRACE = false;

    public OracleBlobOutputStream(BLOB var1, int var2) throws SQLException {
        this((OracleBlob)var1, var2);
    }

    public OracleBlobOutputStream(OracleBlob var1, int var2) throws SQLException {
        this(var1, var2, 1L);
    }

    public OracleBlobOutputStream(BLOB var1, int var2, long var3) throws SQLException {
        this((OracleBlob)var1, var2, var3);
    }

    public OracleBlobOutputStream(OracleBlob var1, int var2, long var3) throws SQLException {
        if (var1 != null && var2 > 0 && var3 >= 1L) {
            this.blob = var1;
            this.lobOffset = var3;
            PhysicalConnection var5 = (PhysicalConnection)var1.getInternalConnection();
            synchronized(var5) {
                this.buf = var5.getByteBuffer(var2);
            }

            this.count = 0;
            this.bufSize = var2;
            this.isClosed = false;
        } else {
            throw new IllegalArgumentException("Illegal Arguments");
        }
    }

    public void write(int var1) throws IOException {
        this.ensureOpen();
        if (this.count >= this.bufSize) {
            this.flushBuffer();
        }

        this.buf[this.count++] = (byte)var1;
    }

    public void write(byte[] var1, int var2, int var3) throws IOException {
        this.ensureOpen();
        int var4 = var2;
        int var5 = Math.min(var3, var1.length - var2);
        if (var5 >= 2 * this.bufSize) {
            if (this.count > 0) {
                this.flushBuffer();
            }

            try {
                this.lobOffset += (long)this.blob.setBytes(this.lobOffset, var1, var2, var5);
            } catch (SQLException var8) {
                IOException var7 = DatabaseError.createIOException(var8);
                var7.fillInStackTrace();
                throw var7;
            }
        } else {
            int var6 = var2 + var5;

            while(var4 < var6) {
                int var9 = Math.min(this.bufSize - this.count, var6 - var4);
                System.arraycopy(var1, var4, this.buf, this.count, var9);
                var4 += var9;
                this.count += var9;
                if (this.count >= this.bufSize) {
                    this.flushBuffer();
                }
            }
        }

    }

    public void flush() throws IOException {
        this.ensureOpen();
        this.flushBuffer();
    }

    public void close() throws IOException {
        if (!this.isClosed) {
            boolean var13 = false;

            try {
                var13 = true;
                this.isClosed = true;
                this.flushBuffer();
                var13 = false;
            } finally {
                if (var13) {
                    try {
                        PhysicalConnection var5 = (PhysicalConnection)this.blob.getInternalConnection();
                        synchronized(var5) {
                            if (this.buf != null) {
                                var5.cacheBuffer(this.buf);
                                this.buf = null;
                            }

                        }
                    } catch (SQLException var15) {
                        IOException var6 = DatabaseError.createIOException(var15);
                        var6.fillInStackTrace();
                        throw var6;
                    }
                }
            }

            try {
                PhysicalConnection var1 = (PhysicalConnection)this.blob.getInternalConnection();
                synchronized(var1) {
                    if (this.buf != null) {
                        var1.cacheBuffer(this.buf);
                        this.buf = null;
                    }

                }
            } catch (SQLException var17) {
                IOException var2 = DatabaseError.createIOException(var17);
                var2.fillInStackTrace();
                throw var2;
            }
        }
    }

    private void flushBuffer() throws IOException {
        try {
            if (this.count > 0) {
                this.lobOffset += (long)this.blob.setBytes(this.lobOffset, this.buf, 0, this.count);
                this.count = 0;
            }

        } catch (SQLException var3) {
            IOException var2 = DatabaseError.createIOException(var3);
            var2.fillInStackTrace();
            throw var2;
        }
    }

    void ensureOpen() throws IOException {
        try {
            if (this.isClosed) {
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

    protected OracleConnection getConnectionDuringExceptionHandling() {
        try {
            return this.blob.getInternalConnection();
        } catch (Exception var2) {
            return null;
        }
    }
}
