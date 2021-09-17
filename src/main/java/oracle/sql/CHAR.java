//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package oracle.sql;

import java.io.InputStream;
import java.io.Reader;
import java.io.StringReader;
import java.math.BigDecimal;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Time;
import java.sql.Timestamp;
import oracle.jdbc.driver.DatabaseError;
import oracle.jdbc.internal.OracleConnection;

public class CHAR extends Datum {
    static final long serialVersionUID = 5559010489982176244L;
    public static final CharacterSet DEFAULT_CHARSET = CharacterSet.make(-1);
    private CharacterSet charSet;
    private int oracleId;
    private static final byte[] empty = new byte[0];
    private static final String _Copyright_2007_Oracle_All_Rights_Reserved_ = null;
    public static final String BUILD_DATE = "Thu_Apr_04_15:09:24_PDT_2013";
    public static final boolean TRACE = false;

    protected CHAR() {
    }

    public CHAR(byte[] var1, CharacterSet var2) {
        this.setValue(var1, var2);
    }

    public CHAR(byte[] var1, int var2, int var3, CharacterSet var4) throws SQLException {
        if (var1 == null) {
            SQLException var6 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 68);
            var6.fillInStackTrace();
            throw var6;
        } else {
            byte[] var5 = new byte[var3];
            System.arraycopy(var1, var2, var5, 0, var3);
            this.setValue(var5, var4);
        }
    }

    public CHAR(String var1, CharacterSet var2) throws SQLException {
        if (var1 == null) {
            SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 68);
            var3.fillInStackTrace();
            throw var3;
        } else {
            if (var2 == null) {
                var2 = DEFAULT_CHARSET;
            }

            this.setValue(var2.convertWithReplacement(var1), var2);
        }
    }

    public CHAR(Object var1, CharacterSet var2) throws SQLException {
        this(var1 == null ? (String)null : var1.toString(), var2);
    }

    public CharacterSet getCharacterSet() {
        if (this.charSet == null) {
            if (this.oracleId == 0) {
                this.oracleId = -1;
            }

            if (DEFAULT_CHARSET == null || this.oracleId != -1 && this.oracleId != DEFAULT_CHARSET.getOracleId()) {
                this.charSet = CharacterSet.make(this.oracleId);
            } else {
                this.charSet = DEFAULT_CHARSET;
            }
        }

        return this.charSet;
    }

    public int oracleId() {
        return this.oracleId;
    }

    public String getString() throws SQLException {
        return this.getCharacterSet().toString(this.shareBytes(), 0, (int)this.getLength());
    }

    public String getStringWithReplacement() {
        byte[] var1 = this.shareBytes();
        return this.getCharacterSet().toStringWithReplacement(var1, 0, var1.length);
    }

    public String toString() {
        return this.getStringWithReplacement();
    }

    public boolean equals(Object var1) {
        boolean var2 = this == var1;
        if (!var2 && var1 instanceof CHAR) {
            CHAR var3 = (CHAR)var1;
            var2 = this.bytesEqual(var3) && this.getCharacterSet().equals(var3.getCharacterSet());
        }

        return var2;
    }

    void setValue(byte[] var1, CharacterSet var2) {
        this.charSet = var2 == null ? DEFAULT_CHARSET : var2;
        this.oracleId = this.charSet.getOracleId();
        this.setShareBytes(var1 == null ? empty : var1);
    }

    public Object toJdbc() throws SQLException {
        return this.stringValue();
    }

    public boolean isConvertibleTo(Class var1) {
        String var2 = var1.getName();
        return var2.compareTo("java.lang.String") == 0 || var2.compareTo("java.lang.Long") == 0 || var2.compareTo("java.math.BigDecimal") == 0 || var2.compareTo("java.io.InputStream") == 0 || var2.compareTo("java.sql.Date") == 0 || var2.compareTo("java.sql.Time") == 0 || var2.compareTo("java.sql.Timestamp") == 0 || var2.compareTo("java.io.Reader") == 0;
    }

    public String stringValue() {
        return this.toString();
    }

    public boolean booleanValue() throws SQLException {
        String var1 = this.stringValue();
        if (var1 != null && !var1.trim().equals("0") && var1.trim().compareToIgnoreCase("f") != 0 && var1.trim().compareToIgnoreCase("false") != 0 && var1.trim().compareToIgnoreCase("n") != 0 && var1.trim().compareToIgnoreCase("no") != 0) {
            if (!var1.trim().equals("1") && var1.trim().compareToIgnoreCase("t") != 0 && var1.trim().compareToIgnoreCase("true") != 0 && var1.trim().compareToIgnoreCase("y") != 0 && var1.trim().compareToIgnoreCase("yes") != 0) {
                SQLException var2 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 59);
                var2.fillInStackTrace();
                throw var2;
            } else {
                return true;
            }
        } else {
            return false;
        }
    }

    public int intValue() throws SQLException {
        long var1 = this.longValue();
        if (var1 <= 2147483647L && var1 >= -2147483648L) {
            return (int)var1;
        } else {
            SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 26);
            var3.fillInStackTrace();
            throw var3;
        }
    }

    public long longValue() throws SQLException {
        long var1 = 0L;

        try {
            var1 = Long.valueOf(this.stringValue().trim());
            return var1;
        } catch (NumberFormatException var5) {
            SQLException var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 59);
            var4.fillInStackTrace();
            throw var4;
        }
    }

    public float floatValue() throws SQLException {
        float var1 = 0.0F;

        try {
            var1 = Float.valueOf(this.stringValue().trim());
            return var1;
        } catch (NumberFormatException var4) {
            SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 59);
            var3.fillInStackTrace();
            throw var3;
        }
    }

    public double doubleValue() throws SQLException {
        double var1 = 0.0D;

        try {
            var1 = Double.valueOf(this.stringValue().trim());
            return var1;
        } catch (NumberFormatException var5) {
            SQLException var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 59);
            var4.fillInStackTrace();
            throw var4;
        }
    }

    public byte byteValue() throws SQLException {
        long var1 = this.longValue();
        if (var1 <= 127L && var1 >= -128L) {
            return (byte)((int)var1);
        } else {
            SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 26);
            var3.fillInStackTrace();
            throw var3;
        }
    }

    public Date dateValue() throws SQLException {
        return Date.valueOf(this.stringValue().trim());
    }

    public Time timeValue() throws SQLException {
        return Time.valueOf(this.stringValue().trim());
    }

    public Timestamp timestampValue() throws SQLException {
        return Timestamp.valueOf(this.stringValue().trim());
    }

    public BigDecimal bigDecimalValue() throws SQLException {
        BigDecimal var1 = null;

        try {
            var1 = new BigDecimal(this.stringValue().trim());
            return var1;
        } catch (NumberFormatException var4) {
            SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 12, "bigDecimalValue");
            var3.fillInStackTrace();
            throw var3;
        }
    }

    public Reader characterStreamValue() throws SQLException {
        return new StringReader(this.getString());
    }

    public InputStream asciiStreamValue() throws SQLException {
        return this.getStream();
    }

    public InputStream binaryStreamValue() throws SQLException {
        return this.getStream();
    }

    public Object makeJdbcArray(int var1) {
        return new String[var1];
    }

    protected OracleConnection getConnectionDuringExceptionHandling() {
        return null;
    }
}
