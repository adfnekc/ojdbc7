//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package oracle.jdbc.driver;

import java.io.InputStream;
import java.io.Reader;
import java.sql.SQLException;
import oracle.jdbc.internal.OracleConnection;
import oracle.jdbc.util.RepConversion;
import oracle.sql.CharacterSet;
import oracle.sql.converter.CharacterSetMetaData;

public class DBConversion {
    public static final boolean DO_CONVERSION_WITH_REPLACEMENT = true;
    public static final short ORACLE8_PROD_VERSION = 8030;
    protected short serverNCharSetId;
    protected short serverCharSetId;
    protected short clientCharSetId;
    protected CharacterSet serverCharSet;
    protected CharacterSet serverNCharSet;
    protected CharacterSet clientCharSet;
    protected CharacterSet asciiCharSet;
    protected boolean isServerCharSetFixedWidth;
    protected boolean isServerNCharSetFixedWidth;
    protected int c2sNlsRatio;
    protected int s2cNlsRatio;
    protected int sMaxCharSize;
    protected int cMaxCharSize;
    protected int maxNCharSize;
    protected boolean isServerCSMultiByte;
    private boolean isStrictASCIIConversion;
    public static final short DBCS_CHARSET = -1;
    public static final short UCS2_CHARSET = -5;
    public static final short ASCII_CHARSET = 1;
    public static final short ISO_LATIN_1_CHARSET = 31;
    public static final short AL24UTFFSS_CHARSET = 870;
    public static final short UTF8_CHARSET = 871;
    public static final short AL32UTF8_CHARSET = 873;
    public static final short AL16UTF16_CHARSET = 2000;
    private static final String _Copyright_2007_Oracle_All_Rights_Reserved_ = null;
    public static final String BUILD_DATE = "Thu_Apr_04_15:09:24_PDT_2013";
    public static final boolean TRACE = false;

    public DBConversion(short var1, short var2, short var3, boolean var4) throws SQLException {
        this.isStrictASCIIConversion = var4;
        if (var2 != -1) {
            this.init(var1, var2, var3);
        }

    }

    public DBConversion(short var1, short var2, short var3) throws SQLException {
        this(var1, var2, var3, false);
    }

    void init(short var1, short var2, short var3) throws SQLException {
        switch(var2) {
            default:
                unexpectedCharset(var2);
            case -5:
            case 1:
            case 2:
            case 31:
            case 178:
            case 870:
            case 871:
            case 873:
                this.serverCharSetId = var1;
                this.clientCharSetId = var2;
                this.serverCharSet = CharacterSet.make(this.serverCharSetId);
                this.serverNCharSetId = var3;
                this.serverNCharSet = CharacterSet.make(this.serverNCharSetId);
                this.clientCharSet = CharacterSet.make(this.clientCharSetId);
                this.c2sNlsRatio = CharacterSetMetaData.getRatio(var1, var2);
                this.s2cNlsRatio = CharacterSetMetaData.getRatio(var2, var1);
                this.sMaxCharSize = CharacterSetMetaData.getRatio(var1, 1);
                this.cMaxCharSize = CharacterSetMetaData.getRatio(var2, 1);
                this.maxNCharSize = CharacterSetMetaData.getRatio(var3, 1);
                this.findFixedWidthInfo();
        }
    }

    void findFixedWidthInfo() throws SQLException {
        this.isServerCharSetFixedWidth = CharacterSetMetaData.isFixedWidth(this.serverCharSetId);
        this.isServerNCharSetFixedWidth = CharacterSetMetaData.isFixedWidth(this.serverNCharSetId);
        this.isServerCSMultiByte = this.sMaxCharSize > 1;
    }

    public short getServerCharSetId() {
        return this.serverCharSetId;
    }

    public short getNCharSetId() {
        return this.serverNCharSetId;
    }

    public boolean IsNCharFixedWith() {
        return this.serverNCharSetId == 2000;
    }

    public short getClientCharSet() {
        return this.clientCharSetId == -1 ? this.serverCharSetId : this.clientCharSetId;
    }

    public CharacterSet getDbCharSetObj() {
        return this.serverCharSet;
    }

    public CharacterSet getDriverCharSetObj() {
        return this.clientCharSet;
    }

    public CharacterSet getDriverNCharSetObj() {
        return this.serverNCharSet;
    }

    CharacterSet getCharacterSet(short var1) {
        return var1 == 2 ? this.getDriverNCharSetObj() : this.getDriverCharSetObj();
    }

    public static final short findDriverCharSet(short var0, short var1) {
        boolean var2 = false;
        int var3;
        switch(var0) {
            case 1:
            case 2:
            case 31:
            case 178:
            case 873:
                var3 = var0;
                break;
            default:
                var3 = var1 >= 8030 ? 871 : 870;
        }

        return (short)var3;
    }

    public static final byte[] stringToDriverCharBytes(String var0, short var1) throws SQLException {
        if (var0 == null) {
            return null;
        } else {
            byte[] var2 = null;
            switch(var1) {
                case -5:
                case 2000:
                    var2 = CharacterSet.stringToAL16UTF16Bytes(var0);
                    break;
                case -1:
                default:
                    unexpectedCharset(var1);
                    break;
                case 1:
                case 2:
                    var2 = CharacterSet.stringToASCII(var0);
                    break;
                case 870:
                case 871:
                    var2 = CharacterSet.stringToUTF(var0);
                    break;
                case 873:
                    var2 = CharacterSet.stringToAL32UTF8(var0);
            }

            return var2;
        }
    }

    public byte[] StringToCharBytes(String var1) throws SQLException {
        if (var1.length() == 0) {
            return null;
        } else {
            switch(this.clientCharSetId) {
                case -1:
                    return this.serverCharSet.convertWithReplacement(var1);
                case 2:
                case 31:
                case 178:
                    return this.clientCharSet.convertWithReplacement(var1);
                default:
                    return stringToDriverCharBytes(var1, this.clientCharSetId);
            }
        }
    }

    public String CharBytesToString(byte[] var1, int var2) throws SQLException {
        return this.CharBytesToString(var1, var2, true);
    }

    public String CharBytesToString(byte[] var1, int var2, boolean var3) throws SQLException {
        String var4 = null;
        if (var1.length == 0) {
            return var4;
        } else {
            switch(this.clientCharSetId) {
                case -5:
                    var4 = CharacterSet.AL16UTF16BytesToString(var1, var2);
                    break;
                case -1:
                    var4 = this.serverCharSet.toStringWithReplacement(var1, 0, var2);
                    break;
                case 1:
                    var4 = new String(var1, 0, 0, var2);
                    break;
                case 2:
                case 31:
                case 178:
                    if (var3) {
                        var4 = this.clientCharSet.toStringWithReplacement(var1, 0, var2);
                    } else {
                        var4 = this.clientCharSet.toString(var1, 0, var2);
                    }
                    break;
                case 870:
                case 871:
                    var4 = CharacterSet.UTFToString(var1, 0, var2, var3);
                    break;
                case 873:
                    var4 = CharacterSet.AL32UTF8ToString(var1, 0, var2, var3);
                    break;
                default:
                    unexpectedCharset(this.clientCharSetId);
            }

            return var4;
        }
    }

    public String NCharBytesToString(byte[] var1, int var2) throws SQLException {
        String var3 = null;
        if (this.clientCharSetId == -1) {
            var3 = this.serverNCharSet.toStringWithReplacement(var1, 0, var2);
        } else {
            switch(this.serverNCharSetId) {
                case -5:
                case 2000:
                    var3 = CharacterSet.AL16UTF16BytesToString(var1, var2);
                    break;
                case -1:
                    var3 = this.serverCharSet.toStringWithReplacement(var1, 0, var2);
                    break;
                case 1:
                case 2:
                    var3 = new String(var1, 0, 0, var2);
                    break;
                case 31:
                case 178:
                    var3 = this.serverNCharSet.toStringWithReplacement(var1, 0, var2);
                    break;
                case 870:
                case 871:
                    var3 = CharacterSet.UTFToString(var1, 0, var2);
                    break;
                case 873:
                    var3 = CharacterSet.AL32UTF8ToString(var1, 0, var2);
                    break;
                default:
                    unexpectedCharset(this.clientCharSetId);
            }
        }

        return var3;
    }

    public int javaCharsToCHARBytes(char[] var1, int var2, byte[] var3) throws SQLException {
        return this.javaCharsToCHARBytes(var1, var2, var3, this.clientCharSetId);
    }

    public int javaCharsToCHARBytes(char[] var1, int var2, byte[] var3, int var4, int var5) throws SQLException {
        return this.javaCharsToCHARBytes(var1, var2, var3, var4, this.clientCharSetId, var5);
    }

    public int javaCharsToNCHARBytes(char[] var1, int var2, byte[] var3) throws SQLException {
        return this.javaCharsToCHARBytes(var1, var2, var3, this.serverNCharSetId);
    }

    public int javaCharsToNCHARBytes(char[] var1, int var2, byte[] var3, int var4, int var5) throws SQLException {
        return this.javaCharsToCHARBytes(var1, var2, var3, var4, this.serverNCharSetId, var5);
    }

    protected int javaCharsToCHARBytes(char[] var1, int var2, byte[] var3, short var4) throws SQLException {
        return this.javaCharsToCHARBytes(var1, 0, var3, 0, var4, var2);
    }

    protected int javaCharsToCHARBytes(char[] var1, int var2, byte[] var3, int var4, short var5, int var6) throws SQLException {
        int var7 = 0;
        switch(var5) {
            case -5:
            case 2000:
                var7 = CharacterSet.convertJavaCharsToAL16UTF16Bytes(var1, var2, var3, var4, var6);
                break;
            case -1:
                var7 = this.javaCharsToDbCsBytes(var1, var2, var3, var4, var6);
                break;
            case 1:
                var7 = CharacterSet.convertJavaCharsToASCIIBytes(var1, var2, var3, var4, var6, this.isStrictASCIIConversion);
                break;
            case 2:
            case 178:
                byte[] var8 = this.clientCharSet.convertWithReplacement(new String(var1, var2, var6));
                System.arraycopy(var8, 0, var3, 0, var8.length);
                var7 = var8.length;
                break;
            case 31:
                var7 = CharacterSet.convertJavaCharsToISOLATIN1Bytes(var1, var2, var3, var4, var6);
                break;
            case 870:
            case 871:
                var7 = CharacterSet.convertJavaCharsToUTFBytes(var1, var2, var3, var4, var6);
                break;
            case 873:
                var7 = CharacterSet.convertJavaCharsToAL32UTF8Bytes(var1, var2, var3, var4, var6);
                break;
            default:
                unexpectedCharset(this.clientCharSetId);
        }

        return var7;
    }

    public int CHARBytesToJavaChars(byte[] var1, int var2, char[] var3, int var4, int[] var5, int var6, boolean var7) throws SQLException {
        return var7 ? this.NCHARBytesToJavaChars(var1, var2, var3, var4, var5, var6) : this.CHARBytesToJavaChars(var1, var2, var3, var4, var5, var6);
    }

    public int CHARBytesToJavaChars(byte[] var1, int var2, char[] var3, int var4, int[] var5, int var6) throws SQLException {
        return _CHARBytesToJavaChars(var1, var2, var3, var4, this.clientCharSetId, var5, var6, this.serverCharSet, this.serverNCharSet, this.clientCharSet, false);
    }

    public int NCHARBytesToJavaChars(byte[] var1, int var2, char[] var3, int var4, int[] var5, int var6) throws SQLException {
        return _CHARBytesToJavaChars(var1, var2, var3, var4, this.serverNCharSetId, var5, var6, this.serverCharSet, this.serverNCharSet, this.clientCharSet, true);
    }

    static final int _CHARBytesToJavaChars(byte[] var0, int var1, char[] var2, int var3, short var4, int[] var5, int var6, CharacterSet var7, CharacterSet var8, CharacterSet var9, boolean var10) throws SQLException {
        int var11 = 0;
        boolean var12 = false;
        int var17;
        switch(var4) {
            case -5:
            case 2000:
                var17 = var5[0] - var5[0] % 2;
                if (var6 > var2.length - var3) {
                    var6 = var2.length - var3;
                }

                if (var6 * 2 < var17) {
                    var17 = var6 * 2;
                }

                var11 = CharacterSet.convertAL16UTF16BytesToJavaChars(var0, var1, var2, var3, var17, true);
                var5[0] -= var17;
                break;
            case -1:
                unexpectedCharset((short)-1);
                break;
            case 1:
                var17 = var5[0];
                if (var6 > var2.length - var3) {
                    var6 = var2.length - var3;
                }

                if (var6 < var17) {
                    var17 = var6;
                }

                var11 = CharacterSet.convertASCIIBytesToJavaChars(var0, var1, var2, var3, var17);
                var5[0] -= var17;
                break;
            case 31:
            case 178:
                var17 = var5[0];
                var11 = var7.toCharWithReplacement(var0, var1, var2, var3, var17);
                var5[0] -= var11;
                break;
            case 870:
            case 871:
                if (var6 > var2.length - var3) {
                    var6 = var2.length - var3;
                }

                var11 = CharacterSet.convertUTFBytesToJavaChars(var0, var1, var2, var3, var5, true, var6);
                break;
            case 873:
                if (var6 > var2.length - var3) {
                    var6 = var2.length - var3;
                }

                var11 = CharacterSet.convertAL32UTF8BytesToJavaChars(var0, var1, var2, var3, var5, true, var6);
                break;
            default:
                CharacterSet var13 = var9;
                if (var10) {
                    var13 = var8;
                }

                String var14 = var13.toStringWithReplacement(var0, var1, var5[0]);
                char[] var15 = var14.toCharArray();
                int var16 = var15.length;
                if (var16 > var6) {
                    var16 = var6;
                }

                var11 = var16;
                var5[0] -= var16;
                System.arraycopy(var15, 0, var2, var3, var16);
        }

        return var11;
    }

    public byte[] asciiBytesToCHARBytes(byte[] var1) {
        byte[] var4 = null;
        switch(this.clientCharSetId) {
            case -5:
                var4 = new byte[var1.length * 2];
                int var2 = 0;

                for(int var3 = 0; var2 < var1.length; ++var2) {
                    var4[var3++] = 0;
                    var4[var3++] = var1[var2];
                }

                return var4;
            case -1:
                if (this.asciiCharSet == null) {
                    this.asciiCharSet = CharacterSet.make(1);
                }

                try {
                    var4 = this.serverCharSet.convert(this.asciiCharSet, var1, 0, var1.length);
                } catch (SQLException var6) {
                }
                break;
            default:
                var4 = var1;
        }

        return var4;
    }

    public int javaCharsToDbCsBytes(char[] var1, int var2, byte[] var3) throws SQLException {
        int var4 = this.javaCharsToDbCsBytes(var1, 0, var3, 0, var2);
        return var4;
    }

    public int javaCharsToDbCsBytes(char[] var1, int var2, byte[] var3, int var4, int var5) throws SQLException {
        int var6 = 0;
        catchCharsLen(var1, var2, var5);
        String var8 = new String(var1, var2, var5);
        byte[] var9 = this.serverCharSet.convertWithReplacement(var8);
        var8 = null;
        if (var9 != null) {
            var6 = var9.length;
            catchBytesLen(var3, var4, var6);
            System.arraycopy(var9, 0, var3, var4, var6);
            Object var10 = null;
        }

        return var6;
    }

    public static final int javaCharsToUcs2Bytes(char[] var0, int var1, byte[] var2) throws SQLException {
        int var3 = javaCharsToUcs2Bytes(var0, 0, var2, 0, var1);
        return var3;
    }

    public static final int javaCharsToUcs2Bytes(char[] var0, int var1, byte[] var2, int var3, int var4) throws SQLException {
        catchCharsLen(var0, var1, var4);
        catchBytesLen(var2, var3, var4 * 2);
        int var7 = var4 + var1;
        int var5 = var1;

        int var6;
        for(var6 = var3; var5 < var7; ++var5) {
            var2[var6++] = (byte)(var0[var5] >> 8 & 255);
            var2[var6++] = (byte)(var0[var5] & 255);
        }

        return var6 - var3;
    }

    public static final int ucs2BytesToJavaChars(byte[] var0, int var1, char[] var2) throws SQLException {
        return CharacterSet.AL16UTF16BytesToJavaChars(var0, var1, var2);
    }

    public static final byte[] stringToAsciiBytes(String var0) {
        return CharacterSet.stringToASCII(var0);
    }

    public static final int asciiBytesToJavaChars(byte[] var0, int var1, char[] var2) throws SQLException {
        return CharacterSet.convertASCIIBytesToJavaChars(var0, 0, var2, 0, var1);
    }

    public static final int javaCharsToAsciiBytes(char[] var0, int var1, byte[] var2) throws SQLException {
        return CharacterSet.convertJavaCharsToASCIIBytes(var0, 0, var2, 0, var1);
    }

    public static final boolean isCharSetMultibyte(short var0) {
        switch(var0) {
            case -5:
            case -1:
            case 870:
            case 871:
            case 873:
                return true;
            case 1:
            case 31:
                return false;
            default:
                return false;
        }
    }

    public int getMaxCharbyteSize() {
        return this._getMaxCharbyteSize(this.clientCharSetId);
    }

    public int getMaxNCharbyteSize() {
        return this._getMaxCharbyteSize(this.serverNCharSetId);
    }

    public int _getMaxCharbyteSize(short var1) {
        switch(var1) {
            case -5:
            case 2000:
                return 2;
            case -1:
                return 4;
            case 1:
                return 1;
            case 31:
                return 1;
            case 870:
            case 871:
                return 3;
            case 873:
                return 4;
            default:
                return 1;
        }
    }

    public boolean isUcs2CharSet() {
        return this.clientCharSetId == -5;
    }

    public static final int RAWBytesToHexChars(byte[] var0, int var1, char[] var2) {
        int var3 = 0;

        int var4;
        for(var4 = 0; var3 < var1; ++var3) {
            var2[var4++] = (char)RepConversion.nibbleToHex((byte)(var0[var3] >> 4 & 15));
            var2[var4++] = (char)RepConversion.nibbleToHex((byte)(var0[var3] & 15));
        }

        return var4;
    }

    public final int hexDigit2Nibble(char var1) throws SQLException {
        int var2 = Character.digit(var1, 16);
        if (var2 == -1) {
            SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 59, "Invalid hex digit: " + var1);
            var3.fillInStackTrace();
            throw var3;
        } else {
            return var2;
        }
    }

    public final byte[] hexString2Bytes(String var1) throws SQLException {
        int var2 = var1.length();
        char[] var3 = new char[var2];
        var1.getChars(0, var2, var3, 0);
        return this.hexChars2Bytes(var3, 0, var2);
    }

    public final byte[] hexChars2Bytes(char[] var1, int var2, int var3) throws SQLException {
        int var5 = 0;
        int var6 = var2;
        if (var3 == 0) {
            return new byte[0];
        } else {
            byte[] var4;
            if (var3 % 2 > 0) {
                var4 = new byte[(var3 + 1) / 2];
                int var10001 = var5++;
                var6 = var2 + 1;
                var4[var10001] = (byte)this.hexDigit2Nibble(var1[var2]);
            } else {
                var4 = new byte[var3 / 2];
            }

            while(var5 < var4.length) {
                var4[var5] = (byte)(this.hexDigit2Nibble(var1[var6++]) << 4 | this.hexDigit2Nibble(var1[var6++]));
                ++var5;
            }

            return var4;
        }
    }

    public InputStream ConvertStream(InputStream var1, int var2) {
        return new OracleConversionInputStream(this, var1, var2);
    }

    public InputStream ConvertStream(InputStream var1, int var2, int var3) {
        return new OracleConversionInputStream(this, var1, var2, var3);
    }

    public InputStream ConvertStreamInternal(InputStream var1, int var2, int var3) {
        return new OracleConversionInputStreamInternal(this, var1, var2, var3);
    }

    public InputStream ConvertStream(Reader var1, int var2, int var3, short var4) {
        OracleConversionInputStream var5 = new OracleConversionInputStream(this, var1, var2, var3, var4);
        return var5;
    }

    public InputStream ConvertStreamInternal(Reader var1, int var2, int var3, short var4) {
        OracleConversionInputStreamInternal var5 = new OracleConversionInputStreamInternal(this, var1, var2, var3, var4);
        return var5;
    }

    public Reader ConvertCharacterStream(InputStream var1, int var2) throws SQLException {
        return new OracleConversionReader(this, var1, var2);
    }

    public Reader ConvertCharacterStream(InputStream var1, int var2, short var3) throws SQLException {
        OracleConversionReader var4 = new OracleConversionReader(this, var1, var2);
        var4.setFormOfUse(var3);
        return var4;
    }

    public InputStream CharsToStream(char[] var1, int var2, int var3, int var4) throws SQLException {
        if (var4 == 10) {
            return new DBConversion.AsciiStream(var1, var2, var3);
        } else if (var4 == 11) {
            return new DBConversion.UnicodeStream(var1, var2, var3);
        } else {
            SQLException var5 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 39, "unknownConversion");
            var5.fillInStackTrace();
            throw var5;
        }
    }

    static final void unexpectedCharset(short var0) throws SQLException {
        SQLException var1 = DatabaseError.createSqlException((OracleConnection)null, 35, "DBConversion");
        var1.fillInStackTrace();
        throw var1;
    }

    protected static final void catchBytesLen(byte[] var0, int var1, int var2) throws SQLException {
        if (var1 + var2 > var0.length) {
            SQLException var3 = DatabaseError.createSqlException((OracleConnection)null, 39, "catchBytesLen");
            var3.fillInStackTrace();
            throw var3;
        }
    }

    protected static final void catchCharsLen(char[] var0, int var1, int var2) throws SQLException {
        if (var1 + var2 > var0.length) {
            SQLException var3 = DatabaseError.createSqlException((OracleConnection)null, 39, "catchCharsLen");
            var3.fillInStackTrace();
            throw var3;
        }
    }

    public static final int getUtfLen(char var0) {
        boolean var1 = false;
        byte var2;
        if ((var0 & 'ﾀ') == 0) {
            var2 = 1;
        } else if ((var0 & '\uf800') == 0) {
            var2 = 2;
        } else {
            var2 = 3;
        }

        return var2;
    }

    int encodedByteLength(String var1, boolean var2) {
        int var3 = 0;
        if (var1 != null) {
            var3 = var1.length();
            if (var3 != 0) {
                if (var2) {
                    var3 = this.isServerNCharSetFixedWidth ? var3 * this.maxNCharSize : this.serverNCharSet.encodedByteLength(var1);
                } else {
                    var3 = this.isServerCharSetFixedWidth ? var3 * this.sMaxCharSize : this.serverCharSet.encodedByteLength(var1);
                }
            }
        }

        return var3;
    }

    int encodedByteLength(char[] var1, boolean var2) {
        int var3 = 0;
        if (var1 != null) {
            var3 = var1.length;
            if (var3 != 0) {
                if (var2) {
                    var3 = this.isServerNCharSetFixedWidth ? var3 * this.maxNCharSize : this.serverNCharSet.encodedByteLength(var1);
                } else {
                    var3 = this.isServerCharSetFixedWidth ? var3 * this.sMaxCharSize : this.serverCharSet.encodedByteLength(var1);
                }
            }
        }

        return var3;
    }

    protected OracleConnection getConnectionDuringExceptionHandling() {
        return null;
    }

    class UnicodeStream extends OracleBufferedStream {
        UnicodeStream(char[] var2, int var3, int var4) {
            super(var4);
            this.currentBufferSize = this.initialBufferSize;
            this.resizableBuffer = new byte[this.currentBufferSize];
            int var5 = var3;

            char var7;
            for(int var6 = 0; var6 < var4; this.resizableBuffer[var6++] = (byte)(var7 & 255)) {
                var7 = var2[var5++];
                this.resizableBuffer[var6++] = (byte)(var7 >> 8 & 255);
            }

            this.count = var4;
        }

        public boolean needBytes() {
            return !this.closed && this.pos < this.count;
        }

        public boolean needBytes(int var1) {
            return !this.closed && this.pos < this.count;
        }
    }

    class AsciiStream extends OracleBufferedStream {
        AsciiStream(char[] var2, int var3, int var4) {
            super(var4);
            this.currentBufferSize = this.initialBufferSize;
            this.resizableBuffer = new byte[this.currentBufferSize];
            if (DBConversion.this.serverCharSetId != 1 && DBConversion.this.isStrictASCIIConversion) {
                if (DBConversion.this.asciiCharSet == null) {
                    DBConversion.this.asciiCharSet = CharacterSet.make(1);
                }

                this.resizableBuffer = DBConversion.this.asciiCharSet.convertWithReplacement(new String(var2, var3, var4));
            } else {
                int var5 = var3;

                for(int var6 = 0; var6 < var4; ++var6) {
                    this.resizableBuffer[var6] = (byte)var2[var5++];
                }
            }

            this.count = var4;
        }

        public boolean needBytes() {
            return !this.closed && this.pos < this.count;
        }

        public boolean needBytes(int var1) {
            return !this.closed && this.pos < this.count;
        }
    }
}
