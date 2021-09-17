//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package oracle.sql;

import java.io.ByteArrayInputStream;
import java.io.CharArrayReader;
import java.io.InputStream;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import oracle.jdbc.driver.DBConversion;
import oracle.jdbc.driver.DatabaseError;
import oracle.jdbc.internal.OracleConnection;
import oracle.jdbc.util.RepConversion;

public class RAW extends Datum {
    static final long serialVersionUID = -3298750557928937840L;
    private static final String _Copyright_2007_Oracle_All_Rights_Reserved_ = null;
    public static final String BUILD_DATE = "Thu_Apr_04_15:09:24_PDT_2013";
    public static final boolean TRACE = false;

    static int hexDigit2Nibble(char var0) throws SQLException {
        int var1 = Character.digit(var0, 16);
        if (var1 == -1) {
            SQLException var2 = DatabaseError.createSqlException((OracleConnection)null, 59, "Invalid hex digit: " + var0);
            var2.fillInStackTrace();
            throw var2;
        } else {
            return var1;
        }
    }

    public static byte[] hexString2Bytes(String var0) throws SQLException {
        int var1 = var0.length();
        char[] var2 = new char[var1];
        var0.getChars(0, var1, var2, 0);
        int var4 = 0;
        int var5 = 0;
        if (var1 == 0) {
            return new byte[0];
        } else {
            byte[] var3;
            if (var1 % 2 > 0) {
                var3 = new byte[(var1 + 1) / 2];
                var3[var4++] = (byte)hexDigit2Nibble(var2[var5++]);
            } else {
                var3 = new byte[var1 / 2];
            }

            while(var4 < var3.length) {
                var3[var4] = (byte)(hexDigit2Nibble(var2[var5++]) << 4 | hexDigit2Nibble(var2[var5++]));
                ++var4;
            }

            return var3;
        }
    }

    public static RAW newRAW(Object var0) throws SQLException {
        RAW var1 = new RAW(var0);
        return var1;
    }

    public static RAW oldRAW(Object var0) throws SQLException {
        RAW var1;
        if (var0 instanceof String) {
            String var2 = (String)var0;
            Object var3 = null;

            byte[] var7;
            try {
                var7 = var2.getBytes("ISO8859_1");
            } catch (UnsupportedEncodingException var6) {
                SQLException var5 = DatabaseError.createSqlException((OracleConnection)null, 109, "ISO8859_1 character encoding not found");
                var5.fillInStackTrace();
                throw var5;
            }

            var1 = new RAW(var7);
        } else {
            var1 = new RAW(var0);
        }

        return var1;
    }

    public RAW() {
    }

    public RAW(byte[] var1) {
        super(var1);
    }

    /** @deprecated */
    public RAW(Object var1) throws SQLException {
        this();
        if (var1 instanceof byte[]) {
            this.setShareBytes((byte[])((byte[])var1));
        } else {
            if (!(var1 instanceof String)) {
                SQLException var2 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 59, var1);
                var2.fillInStackTrace();
                throw var2;
            }

            this.setShareBytes(hexString2Bytes((String)var1));
        }

    }

    public Object toJdbc() throws SQLException {
        return this.getBytes();
    }

    public boolean isConvertibleTo(Class var1) {
        String var2 = var1.getName();
        return var2.compareTo("java.lang.String") == 0 || var2.compareTo("java.io.InputStream") == 0 || var2.compareTo("java.io.Reader") == 0;
    }

    public String stringValue() {
        String var1 = RepConversion.bArray2String(this.getBytes());
        return var1;
    }

    public Reader characterStreamValue() throws SQLException {
        int var1 = (int)this.getLength();
        char[] var2 = new char[var1 * 2];
        byte[] var3 = this.shareBytes();
        DBConversion.RAWBytesToHexChars(var3, var1, var2);
        CharArrayReader var4 = new CharArrayReader(var2);
        return var4;
    }

    public InputStream asciiStreamValue() throws SQLException {
        int var1 = (int)this.getLength();
        char[] var2 = new char[var1 * 2];
        byte[] var3 = this.shareBytes();
        DBConversion.RAWBytesToHexChars(var3, var1, var2);
        byte[] var4 = new byte[var1 * 2];
        DBConversion.javaCharsToAsciiBytes(var2, var1 * 2, var4);
        ByteArrayInputStream var5 = new ByteArrayInputStream(var4);
        return var5;
    }

    public InputStream binaryStreamValue() throws SQLException {
        return this.getStream();
    }

    public Object makeJdbcArray(int var1) {
        return new byte[var1][];
    }

    protected OracleConnection getConnectionDuringExceptionHandling() {
        return null;
    }
}
