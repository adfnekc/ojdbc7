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

class OracleConversionInputStream extends OracleBufferedStream {
    static final int CHUNK_SIZE = 32768;
    DBConversion converter;
    int conversion;
    InputStream istream;
    Reader reader;
    byte[] convbuf;
    char[] javaChars;
    int maxSize;
    int totalSize;
    int numUnconvertedBytes;
    boolean endOfStream;
    private short csform;
    int[] nbytes;
    private static final String _Copyright_2007_Oracle_All_Rights_Reserved_ = null;
    public static final String BUILD_DATE = "Thu_Apr_04_15:09:24_PDT_2013";
    public static final boolean TRACE = false;

    public OracleConversionInputStream(DBConversion var1, InputStream var2, int var3) {
        this(var1, var2, var3, (short)1);
    }

    public OracleConversionInputStream(DBConversion var1, InputStream var2, int var3, short var4) {
        super(32768);
        this.istream = var2;
        this.conversion = var3;
        this.converter = var1;
        this.maxSize = 0;
        this.totalSize = 0;
        this.numUnconvertedBytes = 0;
        this.endOfStream = false;
        this.nbytes = new int[1];
        this.csform = var4;
        this.currentBufferSize = this.initialBufferSize;
        this.resizableBuffer = new byte[this.currentBufferSize];
        int var5;
        switch(var3) {
            case 0:
                this.javaChars = new char['耀'];
                this.convbuf = new byte['耀'];
                break;
            case 1:
                this.convbuf = new byte[16384];
                this.javaChars = new char[16384];
                break;
            case 2:
                this.convbuf = new byte[16384];
                this.javaChars = new char['耀'];
                break;
            case 3:
                this.convbuf = new byte[8192];
                this.javaChars = new char[16384];
                break;
            case 4:
                var5 = '耀' / this.converter.getMaxCharbyteSize();
                this.convbuf = new byte[var5 * 2];
                this.javaChars = new char[var5];
                break;
            case 5:
                if (this.converter.isUcs2CharSet()) {
                    this.convbuf = new byte[16384];
                    this.javaChars = new char[16384];
                } else {
                    this.convbuf = new byte['耀'];
                    this.javaChars = new char['耀'];
                }
                break;
            case 6:
            default:
                this.convbuf = new byte['耀'];
                this.javaChars = new char['耀'];
                break;
            case 7:
                var5 = '耀' / (var4 == 2 ? this.converter.getMaxNCharbyteSize() : this.converter.getMaxCharbyteSize());
                this.javaChars = new char[var5];
        }

    }

    public OracleConversionInputStream(DBConversion var1, InputStream var2, int var3, int var4) {
        this(var1, var2, var3, (short)1);
        this.maxSize = var4;
        this.totalSize = 0;
    }

    public OracleConversionInputStream(DBConversion var1, Reader var2, int var3, int var4, short var5) {
        this(var1, (InputStream)null, var3, var5);
        this.reader = var2;
        this.maxSize = var4;
        this.totalSize = 0;
    }

    public void setFormOfUse(short var1) {
        this.csform = var1;
    }

    public boolean needBytes(int var1) throws IOException {
        return this.needBytes();
    }

    public boolean needBytes() throws IOException {
        if (this.closed) {
            return false;
        } else if (this.pos < this.count) {
            return true;
        } else if (this.istream != null) {
            return this.needBytesFromStream();
        } else {
            return this.reader != null ? this.needBytesFromReader() : false;
        }
    }

    public boolean needBytesFromReader() throws IOException {
        try {
            boolean var1 = false;
            int var4;
            if (this.maxSize == 0) {
                var4 = this.javaChars.length;
            } else {
                var4 = Math.min(this.maxSize - this.totalSize, this.javaChars.length);
            }

            if (var4 <= 0) {
                return false;
            }

            int var5 = this.reader.read(this.javaChars, 0, var4);
            if (var5 == -1) {
                return false;
            }

            this.totalSize += var5;
            switch(this.conversion) {
                case 7:
                    if (this.csform == 2) {
                        this.count = this.converter.javaCharsToNCHARBytes(this.javaChars, var5, this.resizableBuffer);
                    } else {
                        this.count = this.converter.javaCharsToCHARBytes(this.javaChars, var5, this.resizableBuffer);
                    }
                    break;
                default:
                    System.arraycopy(this.convbuf, 0, this.resizableBuffer, 0, var5);
                    this.count = var5;
            }
        } catch (SQLException var3) {
            IOException var2 = DatabaseError.createIOException(var3);
            var2.fillInStackTrace();
            throw var2;
        }

        this.pos = 0;
        return true;
    }

    public boolean needBytesFromStream() throws IOException {
        if (!this.endOfStream) {
            try {
                boolean var1 = false;
                int var6;
                if (this.maxSize == 0) {
                    var6 = this.convbuf.length;
                } else {
                    var6 = Math.min(this.maxSize - this.totalSize, this.convbuf.length);
                }

                int var7 = 0;
                SQLException var3;
                if (var6 <= 0) {
                    this.endOfStream = true;
                    this.istream.close();
                    if (this.numUnconvertedBytes != 0) {
                        var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 55);
                        var3.fillInStackTrace();
                        throw var3;
                    }
                } else {
                    var7 = this.istream.read(this.convbuf, this.numUnconvertedBytes, var6 - this.numUnconvertedBytes);
                }

                if (var7 == -1) {
                    this.endOfStream = true;
                    this.istream.close();
                    if (this.numUnconvertedBytes != 0) {
                        var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 55);
                        var3.fillInStackTrace();
                        throw var3;
                    }
                } else {
                    var7 += this.numUnconvertedBytes;
                    this.totalSize += var7;
                }

                if (var7 <= 0) {
                    return false;
                }

                DBConversion var10000;
                DBConversion var10001;
                int var4;
                int var8;
                switch(this.conversion) {
                    case 0:
                        this.nbytes[0] = var7;
                        var8 = this.converter.CHARBytesToJavaChars(this.convbuf, 0, this.javaChars, 0, this.nbytes, this.javaChars.length);
                        this.numUnconvertedBytes = this.nbytes[0];

                        for(var4 = 0; var4 < this.numUnconvertedBytes; ++var4) {
                            this.convbuf[var4] = this.convbuf[var7 - this.numUnconvertedBytes];
                        }

                        var10001 = this.converter;
                        this.count = DBConversion.javaCharsToAsciiBytes(this.javaChars, var8, this.resizableBuffer);
                        break;
                    case 1:
                        this.nbytes[0] = var7;
                        var8 = this.converter.CHARBytesToJavaChars(this.convbuf, 0, this.javaChars, 0, this.nbytes, this.javaChars.length);
                        this.numUnconvertedBytes = this.nbytes[0];

                        for(var4 = 0; var4 < this.numUnconvertedBytes; ++var4) {
                            this.convbuf[var4] = this.convbuf[var7 - this.numUnconvertedBytes];
                        }

                        var10001 = this.converter;
                        this.count = DBConversion.javaCharsToUcs2Bytes(this.javaChars, var8, this.resizableBuffer);
                        break;
                    case 2:
                        var10000 = this.converter;
                        var8 = DBConversion.RAWBytesToHexChars(this.convbuf, var7, this.javaChars);
                        var10001 = this.converter;
                        this.count = DBConversion.javaCharsToAsciiBytes(this.javaChars, var8, this.resizableBuffer);
                        break;
                    case 3:
                        var10000 = this.converter;
                        var8 = DBConversion.RAWBytesToHexChars(this.convbuf, var7, this.javaChars);
                        var10001 = this.converter;
                        this.count = DBConversion.javaCharsToUcs2Bytes(this.javaChars, var8, this.resizableBuffer);
                        break;
                    case 4:
                        var10000 = this.converter;
                        var8 = DBConversion.ucs2BytesToJavaChars(this.convbuf, var7, this.javaChars);
                        this.count = this.converter.javaCharsToCHARBytes(this.javaChars, var8, this.resizableBuffer);
                        break;
                    case 5:
                        var10000 = this.converter;
                        DBConversion.asciiBytesToJavaChars(this.convbuf, var7, this.javaChars);
                        this.count = this.converter.javaCharsToCHARBytes(this.javaChars, var7, this.resizableBuffer);
                        break;
                    case 6:
                    case 7:
                    case 8:
                    case 9:
                    case 10:
                    case 11:
                    default:
                        System.arraycopy(this.convbuf, 0, this.resizableBuffer, 0, var7);
                        this.count = var7;
                        break;
                    case 12:
                        var10000 = this.converter;
                        var8 = DBConversion.ucs2BytesToJavaChars(this.convbuf, var7, this.javaChars);
                        var10001 = this.converter;
                        this.count = DBConversion.javaCharsToAsciiBytes(this.javaChars, var8, this.resizableBuffer);
                }
            } catch (SQLException var5) {
                IOException var2 = DatabaseError.createIOException(var5);
                var2.fillInStackTrace();
                throw var2;
            }

            this.pos = 0;
            return true;
        } else {
            return false;
        }
    }

    protected OracleConnection getConnectionDuringExceptionHandling() {
        return null;
    }
}
