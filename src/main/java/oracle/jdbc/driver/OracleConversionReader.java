//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package oracle.jdbc.driver;

import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.sql.SQLException;
import oracle.jdbc.internal.OracleConnection;

class OracleConversionReader extends Reader {
    static final int CHUNK_SIZE = 32768;
    DBConversion dbConversion;
    int conversion;
    InputStream istream;
    char[] buf;
    byte[] byteBuf;
    int pos;
    int count;
    int numUnconvertedBytes;
    boolean isClosed;
    boolean endOfStream;
    private short csform;
    int[] nbytes;
    private static final String _Copyright_2007_Oracle_All_Rights_Reserved_ = null;
    public static final String BUILD_DATE = "Thu_Apr_04_15:09:24_PDT_2013";
    public static final boolean TRACE = false;

    public OracleConversionReader(DBConversion var1, InputStream var2, int var3) throws SQLException {
        if (var1 == null || var2 == null || var3 != 8 && var3 != 9) {
            SQLException var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 68);
            var4.fillInStackTrace();
            throw var4;
        } else {
            this.dbConversion = var1;
            this.conversion = var3;
            this.istream = var2;
            this.pos = this.count = 0;
            this.numUnconvertedBytes = 0;
            this.isClosed = false;
            this.nbytes = new int[1];
            if (var3 == 8) {
                this.byteBuf = new byte[16384];
                this.buf = new char['耀'];
            } else if (var3 == 9) {
                this.byteBuf = new byte['耀'];
                this.buf = new char['耀'];
            }

        }
    }

    public void setFormOfUse(short var1) {
        this.csform = var1;
    }

    public int read(char[] var1, int var2, int var3) throws IOException {
        this.ensureOpen();
        if (!this.needChars()) {
            return -1;
        } else {
            int var5 = var2 + Math.min(var3, var1.length - var2);

            int var4;
            for(var4 = var2 + this.writeChars(var1, var2, var5 - var2); var4 < var5 && this.needChars(); var4 += this.writeChars(var1, var4, var5 - var4)) {
            }

            return var4 - var2;
        }
    }

    protected boolean needChars() throws IOException {
        this.ensureOpen();
        if (this.pos < this.count) {
            return true;
        } else {
            if (!this.endOfStream) {
                try {
                    int var1 = this.istream.read(this.byteBuf, this.numUnconvertedBytes, this.byteBuf.length - this.numUnconvertedBytes);
                    SQLException var5;
                    if (var1 == -1) {
                        this.endOfStream = true;
                        this.istream.close();
                        if (this.numUnconvertedBytes != 0) {
                            var5 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 55);
                            var5.fillInStackTrace();
                            throw var5;
                        }
                    }

                    var1 += this.numUnconvertedBytes;
                    if (var1 > 0) {
                        label46:
                        switch(this.conversion) {
                            case 8:
                                DBConversion var10001 = this.dbConversion;
                                this.count = DBConversion.RAWBytesToHexChars(this.byteBuf, var1, this.buf);
                                break;
                            case 9:
                                this.nbytes[0] = var1;
                                if (this.csform == 2) {
                                    this.count = this.dbConversion.NCHARBytesToJavaChars(this.byteBuf, 0, this.buf, 0, this.nbytes, this.buf.length);
                                } else {
                                    this.count = this.dbConversion.CHARBytesToJavaChars(this.byteBuf, 0, this.buf, 0, this.nbytes, this.buf.length);
                                }

                                this.numUnconvertedBytes = this.nbytes[0];
                                int var4 = 0;

                                while(true) {
                                    if (var4 >= this.numUnconvertedBytes) {
                                        break label46;
                                    }

                                    this.byteBuf[var4] = this.byteBuf[var1 - this.numUnconvertedBytes + var4];
                                    ++var4;
                                }
                            default:
                                var5 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 23);
                                var5.fillInStackTrace();
                                throw var5;
                        }

                        if (this.count > 0) {
                            this.pos = 0;
                            return true;
                        }
                    }
                } catch (SQLException var3) {
                    IOException var2 = DatabaseError.createIOException(var3);
                    var2.fillInStackTrace();
                    throw var2;
                }
            }

            return false;
        }
    }

    protected int writeChars(char[] var1, int var2, int var3) {
        int var4 = Math.min(var3, this.count - this.pos);
        System.arraycopy(this.buf, this.pos, var1, var2, var4);
        this.pos += var4;
        return var4;
    }

    public boolean ready() throws IOException {
        this.ensureOpen();
        return this.pos < this.count;
    }

    public void close() throws IOException {
        if (!this.isClosed) {
            this.isClosed = true;
            this.istream.close();
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
        return null;
    }
}
