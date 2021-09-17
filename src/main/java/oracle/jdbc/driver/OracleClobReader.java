//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package oracle.jdbc.driver;

import java.io.IOException;
import java.io.Reader;
import java.sql.SQLException;
import oracle.jdbc.internal.OracleClob;
import oracle.jdbc.internal.OracleConnection;
import oracle.sql.CLOB;

class OracleClobReader extends Reader {
    OracleClob clob;
    DBConversion dbConversion;
    long lobOffset;
    long markedChar;
    char[] resizableBuffer;
    int initialBufferSize;
    int currentBufferSize;
    int pos;
    int count;
    long maxPosition;
    boolean isClosed;
    boolean endOfStream;
    private static final String _Copyright_2007_Oracle_All_Rights_Reserved_ = null;
    public static final String BUILD_DATE = "Thu_Apr_04_15:09:24_PDT_2013";
    public static final boolean TRACE = false;

    public OracleClobReader(CLOB var1) throws SQLException {
        this((OracleClob)var1);
    }

    public OracleClobReader(OracleClob var1) throws SQLException {
        this(var1, ((PhysicalConnection)var1.getInternalConnection()).getDefaultStreamChunkSize() / 3);
    }

    public OracleClobReader(CLOB var1, int var2) throws SQLException {
        this((OracleClob)var1, var2);
    }

    public OracleClobReader(OracleClob var1, int var2) throws SQLException {
        this(var1, var2, 1L);
    }

    public OracleClobReader(CLOB var1, int var2, long var3) throws SQLException {
        this((OracleClob)var1, var2, var3);
    }

    public OracleClobReader(OracleClob var1, int var2, long var3) throws SQLException {
        this.maxPosition = 9223372036854775807L;
        if (var1 != null && var2 > 0 && var1.getInternalConnection() != null && var3 >= 1L) {
            this.dbConversion = ((PhysicalConnection)var1.getInternalConnection()).conversion;
            this.clob = var1;
            this.lobOffset = var3;
            this.markedChar = -1L;
            this.resizableBuffer = null;
            this.initialBufferSize = var2;
            this.currentBufferSize = 0;
            this.pos = this.count = 0;
            this.isClosed = false;
        } else {
            throw new IllegalArgumentException();
        }
    }

    public OracleClobReader(CLOB var1, int var2, long var3, long var5) throws SQLException {
        this((OracleClob)var1, var2, var3, var5);
    }

    public OracleClobReader(OracleClob var1, int var2, long var3, long var5) throws SQLException {
        this(var1, var2, var3);
        this.maxPosition = var3 + var5;
    }

    public int read(char[] var1, int var2, int var3) throws IOException {
        this.ensureOpen();
        int var5 = var2 + Math.min(var3, var1.length - var2);
        if (!this.needChars(var5 - var2)) {
            return -1;
        } else {
            int var4;
            for(var4 = var2 + this.writeChars(var1, var2, var5 - var2); var4 < var5 && this.needChars(var5 - var4); var4 += this.writeChars(var1, var4, var5 - var4)) {
            }

            return var4 - var2;
        }
    }

    protected boolean needChars(int var1) throws IOException {
        this.ensureOpen();
        if (this.pos >= this.count) {
            if (!this.endOfStream) {
                try {
                    if (var1 > this.currentBufferSize) {
                        this.currentBufferSize = Math.max(var1, this.initialBufferSize);
                        PhysicalConnection var2 = (PhysicalConnection)this.clob.getInternalConnection();
                        synchronized(var2) {
                            this.resizableBuffer = var2.getCharBuffer(this.currentBufferSize);
                        }
                    }

                    int var7 = this.currentBufferSize;
                    if (this.maxPosition - this.lobOffset < (long)this.currentBufferSize) {
                        var7 = (int)(this.maxPosition - this.lobOffset);
                    }

                    this.count = this.clob.getChars(this.lobOffset, var7, this.resizableBuffer);
                    if (this.count < this.currentBufferSize) {
                        this.endOfStream = true;
                    }

                    if (this.count > 0) {
                        this.pos = 0;
                        this.lobOffset += (long)this.count;
                        if (this.lobOffset >= this.maxPosition) {
                            this.endOfStream = true;
                        }

                        return true;
                    }
                } catch (SQLException var6) {
                    IOException var3 = DatabaseError.createIOException(var6);
                    var3.fillInStackTrace();
                    throw var3;
                }
            }

            return false;
        } else {
            return true;
        }
    }

    protected int writeChars(char[] var1, int var2, int var3) {
        int var4 = Math.min(var3, this.count - this.pos);
        System.arraycopy(this.resizableBuffer, this.pos, var1, var2, var4);
        this.pos += var4;
        return var4;
    }

    public boolean ready() throws IOException {
        this.ensureOpen();
        return this.pos < this.count;
    }

    public void close() throws IOException {
        if (!this.isClosed) {
            try {
                this.isClosed = true;
                PhysicalConnection var1 = (PhysicalConnection)this.clob.getInternalConnection();
                synchronized(var1) {
                    if (this.resizableBuffer != null) {
                        var1.cacheBuffer(this.resizableBuffer);
                        this.resizableBuffer = null;
                    }

                }
            } catch (SQLException var5) {
                IOException var2 = DatabaseError.createIOException(var5);
                var2.fillInStackTrace();
                throw var2;
            }
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

    public boolean markSupported() {
        return true;
    }

    public void mark(int var1) throws IOException {
        if (var1 < 0) {
            throw new IllegalArgumentException(DatabaseError.findMessage(195, (Object)null));
        } else {
            this.markedChar = this.lobOffset - (long)this.count + (long)this.pos;
        }
    }

    public void reset() throws IOException {
        this.ensureOpen();
        if (this.markedChar < 0L) {
            throw new IOException(DatabaseError.findMessage(195, (Object)null));
        } else {
            this.lobOffset = this.markedChar;
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
                long var5 = this.clob.length() - this.lobOffset + 1L;
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
        try {
            return this.clob.getInternalConnection();
        } catch (Exception var2) {
            return null;
        }
    }
}
