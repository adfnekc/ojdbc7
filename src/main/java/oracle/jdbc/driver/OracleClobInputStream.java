//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package oracle.jdbc.driver;

import java.io.IOException;
import java.sql.SQLException;
import oracle.jdbc.internal.OracleClob;
import oracle.jdbc.internal.OracleConnection;
import oracle.sql.CharacterSet;

class OracleClobInputStream extends OracleBufferedStream {
    protected long lobOffset;
    protected OracleClob clob;
    protected long markedByte;
    protected boolean endOfStream;
    protected char[] charBuf;
    protected boolean asciiStrictConversion;
    private static final String _Copyright_2007_Oracle_All_Rights_Reserved_ = null;
    public static final String BUILD_DATE = "Thu_Apr_04_15:09:24_PDT_2013";
    public static final boolean TRACE = false;

    public OracleClobInputStream(OracleClob var1, int var2) throws SQLException {
        this(var1, var2, 1L);
    }

    public OracleClobInputStream(OracleClob var1, int var2, long var3) throws SQLException {
        super(var2);
        if (var1 != null && var2 > 0 && var3 >= 1L) {
            this.lobOffset = var3;
            this.clob = var1;
            this.markedByte = -1L;
            this.endOfStream = false;
            this.asciiStrictConversion = ((PhysicalConnection)var1.getInternalConnection()).isStrictAsciiConversion;
        } else {
            throw new IllegalArgumentException();
        }
    }

    public boolean needBytes(int var1) throws IOException {
        this.ensureOpen();
        if (this.pos < this.count) {
            return true;
        } else {
            if (!this.endOfStream) {
                try {
                    if (var1 > this.currentBufferSize || var1 == 0) {
                        this.currentBufferSize = Math.max(var1, this.initialBufferSize);
                        PhysicalConnection var2 = (PhysicalConnection)this.clob.getInternalConnection();
                        synchronized(var2) {
                            this.resizableBuffer = var2.getByteBuffer(this.currentBufferSize);
                            this.charBuf = var2.getCharBuffer(this.currentBufferSize);
                        }
                    }

                    this.count = this.clob.getChars(this.lobOffset, this.currentBufferSize, this.charBuf);
                    CharacterSet.convertJavaCharsToASCIIBytes(this.charBuf, 0, this.resizableBuffer, 0, this.count, this.asciiStrictConversion);
                    if (this.count < this.currentBufferSize) {
                        this.endOfStream = true;
                    }

                    if (this.count > 0) {
                        this.pos = 0;
                        this.lobOffset += (long)this.count;
                        return true;
                    }
                } catch (SQLException var6) {
                    IOException var3 = DatabaseError.createIOException(var6);
                    var3.fillInStackTrace();
                    throw var3;
                }
            }

            return false;
        }
    }

    protected void ensureOpen() throws IOException {
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
            throw new IllegalArgumentException(DatabaseError.findMessage(196, (Object)null));
        } else {
            this.markedByte = this.lobOffset - (long)this.count + (long)this.pos;
        }
    }

    public void markInternal(int var1) {
    }

    public void reset() throws IOException {
        this.ensureOpen();
        if (this.markedByte < 0L) {
            throw new IOException(DatabaseError.findMessage(195, (Object)null));
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
                var5 = this.clob.length() - this.lobOffset + 1L;
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

    public void close() throws IOException {
        if (!this.closed) {
            boolean var13 = false;

            try {
                var13 = true;
                super.close();
                var13 = false;
            } finally {
                if (var13) {
                    try {
                        PhysicalConnection var5 = (PhysicalConnection)this.clob.getInternalConnection();
                        synchronized(var5) {
                            if (this.charBuf != null) {
                                var5.cacheBuffer(this.charBuf);
                                this.charBuf = null;
                            }

                            if (this.resizableBuffer != null) {
                                var5.cacheBuffer(this.resizableBuffer);
                                this.resizableBuffer = null;
                            }

                            this.currentBufferSize = 0;
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
                    if (this.charBuf != null) {
                        var1.cacheBuffer(this.charBuf);
                        this.charBuf = null;
                    }

                    if (this.resizableBuffer != null) {
                        var1.cacheBuffer(this.resizableBuffer);
                        this.resizableBuffer = null;
                    }

                    this.currentBufferSize = 0;
                }
            } catch (SQLException var17) {
                IOException var2 = DatabaseError.createIOException(var17);
                var2.fillInStackTrace();
                throw var2;
            }
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
