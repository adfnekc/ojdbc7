//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package oracle.sql;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.Reader;
import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Calendar;
import oracle.jdbc.driver.DatabaseError;
import oracle.jdbc.internal.OracleConnection;

public abstract class Datum implements Serializable {
    private byte[] data;
    static final long serialVersionUID = 4645732484621936751L;
    private static final String _Copyright_2007_Oracle_All_Rights_Reserved_ = null;
    public static final String BUILD_DATE = "Thu_Apr_04_15:09:24_PDT_2013";
    public static final boolean TRACE = false;

    public Datum() {
    }

    public Datum(byte[] var1) {
        this.data = var1;
    }

    public boolean equals(Object var1) {
        if (this == var1) {
            return true;
        } else if (var1 != null && var1 instanceof Datum) {
            if (this.getClass() == var1.getClass()) {
                Datum var2 = (Datum)var1;
                if (this.data == null && var2.data == null) {
                    return true;
                } else if (this.data == null && var2.data != null || this.data != null && var2.data == null) {
                    return false;
                } else if (this.data.length != var2.data.length) {
                    return false;
                } else {
                    for(int var3 = 0; var3 < this.data.length; ++var3) {
                        if (this.data[var3] != var2.data[var3]) {
                            return false;
                        }
                    }

                    return true;
                }
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    public byte[] shareBytes() {
        return this.data;
    }

    public long getLength() {
        return null == this.data ? 0L : (long)this.data.length;
    }

    public void setBytes(byte[] var1) {
        int var2 = var1.length;
        this.data = new byte[var2];
        System.arraycopy(var1, 0, this.data, 0, var2);
    }

    public void setShareBytes(byte[] var1) {
        this.data = var1;
    }

    public byte[] getBytes() {
        if (this.data == null) {
            return new byte[0];
        } else {
            byte[] var1 = new byte[this.data.length];
            System.arraycopy(this.data, 0, var1, 0, this.data.length);
            return var1;
        }
    }

    public boolean isNull() {
        return this.data == null || this.data.length == 0;
    }

    public InputStream getStream() {
        return new ByteArrayInputStream(this.data);
    }

    public String stringValue() throws SQLException {
        throw new SQLException("Conversion to String failed");
    }

    public String stringValue(Connection var1) throws SQLException {
        return this.stringValue();
    }

    public boolean booleanValue() throws SQLException {
        throw new SQLException("Conversion to boolean failed");
    }

    public int intValue() throws SQLException {
        throw new SQLException("Conversion to integer failed");
    }

    public long longValue() throws SQLException {
        throw new SQLException("Conversion to long failed");
    }

    public float floatValue() throws SQLException {
        throw new SQLException("Conversion to float failed");
    }

    public double doubleValue() throws SQLException {
        throw new SQLException("Conversion to double failed");
    }

    public byte byteValue() throws SQLException {
        throw new SQLException("Conversion to byte failed");
    }

    public BigDecimal bigDecimalValue() throws SQLException {
        throw new SQLException("Conversion to BigDecimal failed");
    }

    public Date dateValue() throws SQLException {
        throw new SQLException("Conversion to Date failed");
    }

    public Time timeValue() throws SQLException {
        throw new SQLException("Conversion to Time failed");
    }

    public Time timeValue(Calendar var1) throws SQLException {
        throw new SQLException("Conversion to Time failed");
    }

    public Timestamp timestampValue() throws SQLException {
        throw new SQLException("Conversion to Timestamp failed");
    }

    public Timestamp timestampValue(Calendar var1) throws SQLException {
        throw new SQLException("Conversion to Timestamp failed");
    }

    public Reader characterStreamValue() throws SQLException {
        throw new SQLException("Conversion to character stream failed");
    }

    public InputStream asciiStreamValue() throws SQLException {
        throw new SQLException("Conversion to ascii stream failed");
    }

    public InputStream binaryStreamValue() throws SQLException {
        throw new SQLException("Conversion to binary stream failed");
    }

    public abstract boolean isConvertibleTo(Class var1);

    public <T> T toClass(Class<T> var1) throws SQLException {
        Object var2 = null;
        if (var1 == this.getClass()) {
            var2 = this;
        } else if (var1 == String.class) {
            var2 = this.stringValue();
        } else if (var1 == Boolean.class) {
            var2 = this.booleanValue();
        } else if (var1 == Byte.class) {
            var2 = this.byteValue();
        } else if (var1 == Integer.class) {
            var2 = this.intValue();
        } else if (var1 == Long.class) {
            var2 = this.longValue();
        } else if (var1 == Float.class) {
            var2 = this.floatValue();
        } else if (var1 == Double.class) {
            var2 = this.doubleValue();
        } else if (var1 == BigDecimal.class) {
            var2 = this.bigDecimalValue();
        } else if (var1 == Date.class) {
            var2 = this.dateValue();
        } else if (var1 == Time.class) {
            var2 = this.timeValue();
        } else if (var1 == Timestamp.class) {
            var2 = this.timestampValue();
        } else if (var1 == Reader.class) {
            var2 = this.characterStreamValue();
        } else {
            if (var1 != InputStream.class) {
                SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 59, var1.getName());
                var3.fillInStackTrace();
                throw var3;
            }

            var2 = this.binaryStreamValue();
        }

        return (T) var2;
    }

    public abstract Object toJdbc() throws SQLException;

    public abstract Object makeJdbcArray(int var1);

    protected static int compareBytes(byte[] var0, byte[] var1) {
        int var2 = var0.length;
        int var3 = var1.length;
        int var4 = 0;
        int var5 = Math.min(var2, var3);
        boolean var6 = false;

        for(boolean var7 = false; var4 < var5; ++var4) {
            int var8 = var0[var4] & 255;
            int var9 = var1[var4] & 255;
            if (var8 != var9) {
                if (var8 < var9) {
                    return -1;
                }

                return 1;
            }
        }

        if (var2 == var3) {
            return 0;
        } else if (var2 > var3) {
            return 1;
        } else {
            return -1;
        }
    }

    protected boolean bytesEqual(Datum var1) {
        boolean var2 = this == var1;
        if (!var2) {
            byte[] var3 = var1.shareBytes();
            boolean var4 = this.data == null;
            if (var4 == (var3 == null) && (var4 || this.data.length == var3.length)) {
                var2 = true;
                if (!var4) {
                    for(int var5 = 0; var5 < this.data.length; ++var5) {
                        if (this.data[var5] != var3[var5]) {
                            var2 = false;
                            break;
                        }
                    }
                }
            }
        }

        return var2;
    }

    protected OracleConnection getConnectionDuringExceptionHandling() {
        return null;
    }
}
