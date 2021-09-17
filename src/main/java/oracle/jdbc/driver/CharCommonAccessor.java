//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package oracle.jdbc.driver;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.Reader;
import java.io.StringReader;
import java.math.BigDecimal;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Time;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Map;
import oracle.jdbc.internal.OracleConnection;
import oracle.sql.CHAR;
import oracle.sql.CharacterSet;
import oracle.sql.Datum;
import oracle.sql.ROWID;

abstract class CharCommonAccessor extends Accessor {
    protected static final String[] DATE_FORMATS = new String[]{"yyyy-MM-dd HH:mm:ss z", "EEE MMM dd HH:mm:ss z yyyy", "yyyy-MM-dd HH:mm:ss", "yyyy-MM-dd", "HH:mm:ss z", "HH:mm:ss"};
    private static final String _Copyright_2007_Oracle_All_Rights_Reserved_ = null;
    public static final String BUILD_DATE = "Thu_Apr_04_15:09:24_PDT_2013";
    public static final boolean TRACE = false;

    CharCommonAccessor(OracleStatement var1, int var2, short var3, boolean var4) {
        super(var3 == 2 ? Representation.NVARCHAR : Representation.VARCHAR, var1, var2, var4);
    }

    void init(OracleStatement var1, int var2, int var3, int var4, short var5, int var6, boolean var7, int var8) throws SQLException {
        if (var7) {
            if (var2 != 23) {
                var2 = 1;
            }

            if (var1.maxFieldSize > 0 && (var4 == -1 || var4 < var1.maxFieldSize)) {
                var4 = var1.maxFieldSize;
            }
        }

        this.init(var1, var2, var3, var5, var7);
        if (var7 && var1.connection.defaultnchar) {
            this.formOfUse = 2;
        }

        this.initForDataAccess(var6, var4, (String)null);
    }

    void init(OracleStatement var1, int var2, int var3, int var4, boolean var5, int var6, int var7, int var8, int var9, int var10, short var11, int var12) throws SQLException {
        this.init(var1, var2, var3, var11, false);
        this.initForDescribe(var2, var4, var5, var6, var7, var8, var9, var10, var11, (String)null);
        int var13 = var1.maxFieldSize;
        if (var13 != 0 && var13 <= var4) {
            var4 = var13;
        }

        this.initForDataAccess(0, var4, (String)null);
    }

    void initForDataAccess(int var1, int var2, String var3) throws SQLException {
        if (var1 != 0) {
            this.externalType = var1;
        }

        this.charLength = this.isNullByDescribe ? 0 : (var2 < 0 || var2 >= this.representationMaxLength && !this.statement.isFetchStreams ? this.representationMaxLength + 1 : var2 + 1);
    }

    int getInt(int var1) throws SQLException {
        if (this.isNull(var1)) {
            return 0;
        } else {
            String var2 = this.getString(var1);

            try {
                return Integer.parseInt(var2);
            } catch (NumberFormatException var7) {
                try {
                    return Double.valueOf(var2).intValue();
                } catch (NumberFormatException var6) {
                    SQLException var5 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 59);
                    var5.fillInStackTrace();
                    throw var5;
                }
            }
        }
    }

    boolean getBoolean(int var1) throws SQLException {
        String var2 = this.getString(var1);
        if (var2 != null && !var2.trim().equals("0") && var2.trim().compareToIgnoreCase("f") != 0 && var2.trim().compareToIgnoreCase("false") != 0 && var2.trim().compareToIgnoreCase("n") != 0 && var2.trim().compareToIgnoreCase("no") != 0) {
            if (!var2.trim().equals("1") && var2.trim().compareToIgnoreCase("t") != 0 && var2.trim().compareToIgnoreCase("true") != 0 && var2.trim().compareToIgnoreCase("y") != 0 && var2.trim().compareToIgnoreCase("yes") != 0) {
                SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 59);
                var3.fillInStackTrace();
                throw var3;
            } else {
                return true;
            }
        } else {
            return false;
        }
    }

    short getShort(int var1) throws SQLException {
        if (this.isNull(var1)) {
            return 0;
        } else {
            String var2 = this.getString(var1);

            try {
                return Short.valueOf(var2);
            } catch (NumberFormatException var7) {
                try {
                    return Double.valueOf(var2).shortValue();
                } catch (NumberFormatException var6) {
                    SQLException var5 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 59);
                    var5.fillInStackTrace();
                    throw var5;
                }
            }
        }
    }

    byte getByte(int var1) throws SQLException {
        if (this.isNull(var1)) {
            return 0;
        } else {
            String var2 = this.getString(var1);

            try {
                return Byte.valueOf(var2);
            } catch (NumberFormatException var7) {
                try {
                    return Double.valueOf(var2).byteValue();
                } catch (NumberFormatException var6) {
                    SQLException var5 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 59);
                    var5.fillInStackTrace();
                    throw var5;
                }
            }
        }
    }

    long getLong(int var1) throws SQLException {
        if (this.isNull(var1)) {
            return 0L;
        } else {
            String var2 = this.getString(var1);

            try {
                return Long.valueOf(var2);
            } catch (NumberFormatException var7) {
                try {
                    return Double.valueOf(var2).longValue();
                } catch (NumberFormatException var6) {
                    SQLException var5 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 59);
                    var5.fillInStackTrace();
                    throw var5;
                }
            }
        }
    }

    float getFloat(int var1) throws SQLException {
        if (this.isNull(var1)) {
            return 0.0F;
        } else {
            String var2 = this.getString(var1);

            try {
                return Float.valueOf(var2);
            } catch (NumberFormatException var7) {
                try {
                    return Double.valueOf(var2).floatValue();
                } catch (NumberFormatException var6) {
                    SQLException var5 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 59);
                    var5.fillInStackTrace();
                    throw var5;
                }
            }
        }
    }

    double getDouble(int var1) throws SQLException {
        if (this.isNull(var1)) {
            return 0.0D;
        } else {
            try {
                return Double.valueOf(this.getString(var1));
            } catch (NumberFormatException var4) {
                SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 59);
                var3.fillInStackTrace();
                throw var3;
            }
        }
    }

    BigDecimal getBigDecimal(int var1) throws SQLException {
        if (this.isNull(var1)) {
            return null;
        } else {
            try {
                return new BigDecimal(this.getString(var1).trim());
            } catch (NumberFormatException var4) {
                SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 59);
                var3.fillInStackTrace();
                throw var3;
            }
        }
    }

    BigDecimal getBigDecimal(int var1, int var2) throws SQLException {
        BigDecimal var3 = this.getBigDecimal(var1);
        if (var3 != null) {
            var3.setScale(var2, 6);
        }

        return var3;
    }

    String getString(int var1) throws SQLException {
        if (this.isNull(var1)) {
            return null;
        } else {
            String var2 = this.rowData.getString(this.getOffset(var1), this.getLength(var1), this.statement.connection.conversion.getCharacterSet(this.formOfUse));
            if (var2.length() > this.charLength - 1) {
                var2 = var2.substring(0, this.charLength - 1);
            }

            return var2;
        }
    }

    Date getDate(int var1) throws SQLException {
        if (this.isNull(var1)) {
            return null;
        } else {
            Date var2 = null;

            try {
                var2 = Date.valueOf(this.getString(var1).trim());
                return var2;
            } catch (IllegalArgumentException var5) {
                SQLException var4 = DatabaseError.createSqlException((OracleConnection)null, 132, (Object)null, var5);
                var4.fillInStackTrace();
                throw var4;
            }
        }
    }

    Time getTime(int var1) throws SQLException {
        if (this.isNull(var1)) {
            return null;
        } else {
            Time var2 = null;

            try {
                var2 = Time.valueOf(this.getString(var1).trim());
                return var2;
            } catch (IllegalArgumentException var5) {
                SQLException var4 = DatabaseError.createSqlException((OracleConnection)null, 132, (Object)null, var5);
                var4.fillInStackTrace();
                throw var4;
            }
        }
    }

    Timestamp getTimestamp(int var1) throws SQLException {
        if (this.isNull(var1)) {
            return null;
        } else {
            Timestamp var2 = null;

            try {
                var2 = Timestamp.valueOf(this.getString(var1).trim());
                return var2;
            } catch (IllegalArgumentException var5) {
                SQLException var4 = DatabaseError.createSqlException((OracleConnection)null, 132, (Object)null, var5);
                var4.fillInStackTrace();
                throw var4;
            }
        }
    }

    java.util.Date getJavaUtilDate(int var1) throws SQLException {
        if (this.isNull(var1)) {
            return null;
        } else {
            java.util.Date var2 = null;
            String[] var3 = DATE_FORMATS;
            int var4 = var3.length;
            int var5 = 0;

            while(var5 < var4) {
                String var6 = var3[var5];
                SimpleDateFormat var7 = new SimpleDateFormat(var6);

                try {
                    var2 = var7.parse(this.getString(var1).trim());
                    return var2;
                } catch (ParseException var9) {
                    ++var5;
                }
            }

            SQLException var10 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 132);
            var10.fillInStackTrace();
            throw var10;
        }
    }

    Calendar getCalendar(int var1) throws SQLException {
        if (this.isNull(var1)) {
            return null;
        } else {
            Calendar var2 = (Calendar)((Calendar)this.statement.getDefaultCalendar().clone());
            var2.setTime(this.getJavaUtilDate(var1));
            return var2;
        }
    }

    InputStream getAsciiStream(int var1) throws SQLException {
        if (this.isNull(var1)) {
            return null;
        } else {
            DBConversion var2 = this.statement.connection.conversion;
            int[] var3 = new int[1];
            char[] var4 = this.rowData.getChars(this.getOffset(var1), this.getLength(var1), var2.getCharacterSet(this.formOfUse), var3);
            return var2.CharsToStream(var4, 0, var3[0], 10);
        }
    }

    InputStream getUnicodeStream(int var1) throws SQLException {
        if (this.isNull(var1)) {
            return null;
        } else {
            DBConversion var2 = this.statement.connection.conversion;
            int[] var3 = new int[1];
            char[] var4 = this.rowData.getChars(this.getOffset(var1), this.getLength(var1), var2.getCharacterSet(this.formOfUse), var3);
            return var2.CharsToStream(var4, 0, var3[0] << 1, 11);
        }
    }

    Reader getCharacterStream(int var1) throws SQLException {
        return this.isNull(var1) ? null : new StringReader(this.getString(var1));
    }

    InputStream getBinaryStream(int var1) throws SQLException {
        return this.isNull(var1) ? null : new ByteArrayInputStream(this.getBytes(var1));
    }

    Object getObject(int var1) throws SQLException {
        return this.getString(var1);
    }

    Object getObject(int var1, Map var2) throws SQLException {
        return this.getString(var1);
    }

    Datum getOracleObject(int var1) throws SQLException {
        return this.getCHAR(var1);
    }

    CHAR getCHAR(int var1) throws SQLException {
        byte[] var2 = this.getBytes(var1);
        if (var2 != null && var2.length != 0) {
            CharacterSet var3 = this.statement.connection.conversion.getCharacterSet(this.formOfUse);
            return new CHAR(var2, var3);
        } else {
            return null;
        }
    }

    URL getURL(int var1) throws SQLException {
        if (this.isNull(var1)) {
            return null;
        } else {
            try {
                return new URL(this.getString(var1));
            } catch (MalformedURLException var4) {
                SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 136);
                var3.fillInStackTrace();
                throw var3;
            }
        }
    }

    ROWID getROWID(int var1) throws SQLException {
        if (this.isNull(var1)) {
            return null;
        } else {
            byte[] var2 = this.getBytesInternal(var1);
            ROWID var3 = null;
            if (var2 != null) {
                var3 = new ROWID(var2);
            }

            return var3;
        }
    }

    byte[] getBytesFromHexChars(int var1) throws SQLException {
        if (this.isNull(var1)) {
            return null;
        } else {
            byte[] var2 = this.rowData.getBytesFromHex(this.getOffset(var1), this.getLength(var1), this.statement.connection.conversion.getCharacterSet(this.formOfUse));
            if (var2.length > this.charLength - 1) {
                byte[] var3 = new byte[this.charLength - 1];
                System.arraycopy(var2, 0, var3, 0, var3.length);
                var2 = var3;
            }

            return var2;
        }
    }
}
