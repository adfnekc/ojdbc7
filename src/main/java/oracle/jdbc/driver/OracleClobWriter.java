//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package oracle.jdbc.driver;

import java.io.IOException;
import java.io.Writer;
import java.sql.SQLException;
import oracle.jdbc.internal.OracleClob;
import oracle.jdbc.internal.OracleConnection;
import oracle.sql.CLOB;

class OracleClobWriter extends Writer {
    DBConversion dbConversion;
    OracleClob clob;
    long lobOffset;
    char[] charBuf;
    byte[] nativeBuf;
    int pos;
    int count;
    int chunkSize;
    boolean isClosed;
    private static final String _Copyright_2007_Oracle_All_Rights_Reserved_ = null;
    public static final String BUILD_DATE = "Thu_Apr_04_15:09:24_PDT_2013";
    public static final boolean TRACE = false;

    public OracleClobWriter(CLOB var1, int var2) throws SQLException {
        this((OracleClob)var1, var2);
    }

    public OracleClobWriter(OracleClob var1, int var2) throws SQLException {
        this(var1, var2, 1L);
    }

    public OracleClobWriter(CLOB var1, int var2, long var3) throws SQLException {
        this((OracleClob)var1, var2, var3);
    }

    public OracleClobWriter(OracleClob var1, int var2, long var3) throws SQLException {
        if (var1 != null && var2 > 0 && var1.getJavaSqlConnection() != null && var3 >= 1L) {
            this.dbConversion = ((PhysicalConnection)var1.getInternalConnection()).conversion;
            this.clob = var1;
            this.lobOffset = var3;
            this.charBuf = new char[var2];
            this.nativeBuf = new byte[var2 * 3];
            this.pos = this.count = 0;
            this.chunkSize = var2;
            this.isClosed = false;
        } else {
            throw new IllegalArgumentException();
        }
    }

    public void write(char[] var1, int var2, int var3) throws IOException {
        synchronized(this.lock) {
            this.ensureOpen();
            int var5 = var2;
            int var6 = Math.min(var3, var1.length - var2);
            if (var6 >= 2 * this.chunkSize) {
                if (this.count > 0) {
                    this.flushBuffer();
                }

                try {
                    this.lobOffset += (long)this.clob.putChars(this.lobOffset, var1, var2, var6);
                } catch (SQLException var10) {
                    IOException var12 = DatabaseError.createIOException(var10);
                    var12.fillInStackTrace();
                    throw var12;
                }

            } else {
                int var7 = var2 + var6;

                while(var5 < var7) {
                    int var8 = Math.min(this.chunkSize - this.count, var7 - var5);
                    System.arraycopy(var1, var5, this.charBuf, this.count, var8);
                    var5 += var8;
                    this.count += var8;
                    if (this.count >= this.chunkSize) {
                        this.flushBuffer();
                    }
                }

            }
        }
    }

    public void flush() throws IOException {
        synchronized(this.lock) {
            this.ensureOpen();
            this.flushBuffer();
        }
    }

    public void close() throws IOException {
        synchronized(this.lock) {
            this.flushBuffer();
            this.isClosed = true;
        }
    }

    private void flushBuffer() throws IOException {
        synchronized(this.lock) {
            try {
                if (this.count > 0) {
                    this.lobOffset += (long)this.clob.putChars(this.lobOffset, this.charBuf, 0, this.count);
                    this.count = 0;
                }
            } catch (SQLException var5) {
                IOException var3 = DatabaseError.createIOException(var5);
                var3.fillInStackTrace();
                throw var3;
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

    protected OracleConnection getConnectionDuringExceptionHandling() {
        try {
            return this.clob.getInternalConnection();
        } catch (Exception var2) {
            return null;
        }
    }
}
