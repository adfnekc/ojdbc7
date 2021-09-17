//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package oracle.jdbc.driver;

import java.io.IOException;
import java.io.OutputStream;
import java.sql.SQLException;
import oracle.jdbc.internal.OracleClob;
import oracle.jdbc.internal.OracleConnection;
import oracle.sql.CLOB;

class OracleClobOutputStream extends OutputStream {
    long lobOffset;
    OracleClob clob;
    byte[] buf;
    int count;
    int bufSize;
    boolean isClosed;
    private static final String _Copyright_2007_Oracle_All_Rights_Reserved_ = null;
    public static final String BUILD_DATE = "Thu_Apr_04_15:09:24_PDT_2013";
    public static final boolean TRACE = false;

    public OracleClobOutputStream(CLOB var1, int var2) throws SQLException {
        this((OracleClob)var1, var2);
    }

    public OracleClobOutputStream(OracleClob var1, int var2) throws SQLException {
        this(var1, var2, 1L);
    }

    public OracleClobOutputStream(CLOB var1, int var2, long var3) throws SQLException {
        this((OracleClob)var1, var2, var3);
    }

    public OracleClobOutputStream(OracleClob var1, int var2, long var3) throws SQLException {
        if (var1 != null && var2 > 0 && var3 >= 1L) {
            this.clob = var1;
            this.lobOffset = var3;
            PhysicalConnection var5 = (PhysicalConnection)var1.getInternalConnection();
            synchronized(var5) {
                this.buf = var5.getByteBuffer(var2);
            }

            this.count = 0;
            this.bufSize = var2;
            this.isClosed = false;
        } else {
            throw new IllegalArgumentException();
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
        int var10;
        if (var5 < 2 * this.bufSize) {
            int var9 = var2 + var5;

            while(var4 < var9) {
                var10 = Math.min(this.bufSize - this.count, var9 - var4);
                System.arraycopy(var1, var4, this.buf, this.count, var10);
                var4 += var10;
                this.count += var10;
                if (this.count >= this.bufSize) {
                    this.flushBuffer();
                }
            }

        } else {
            if (this.count > 0) {
                this.flushBuffer();
            }

            try {
                char[] var6 = new char[var5];

                for(var10 = 0; var10 < var5; ++var10) {
                    var6[var10] = (char)var1[var10 + var2];
                }

                this.lobOffset += (long)this.clob.putChars(this.lobOffset, var6);
            } catch (SQLException var8) {
                IOException var7 = DatabaseError.createIOException(var8);
                var7.fillInStackTrace();
                throw var7;
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
                        PhysicalConnection var5 = (PhysicalConnection)this.clob.getInternalConnection();
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
                PhysicalConnection var1 = (PhysicalConnection)this.clob.getInternalConnection();
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
                char[] var1 = new char[this.count];

                for(int var4 = 0; var4 < this.count; ++var4) {
                    var1[var4] = (char)this.buf[var4];
                }

                this.lobOffset += (long)this.clob.putChars(this.lobOffset, var1);
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
            return this.clob.getInternalConnection();
        } catch (Exception var2) {
            return null;
        }
    }
}
