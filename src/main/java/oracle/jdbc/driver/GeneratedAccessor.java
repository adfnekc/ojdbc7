//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package oracle.jdbc.driver;

import java.io.InputStream;
import java.io.Reader;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.URL;
import java.sql.Array;
import java.sql.Blob;
import java.sql.Clob;
import java.sql.Date;
import java.sql.NClob;
import java.sql.Ref;
import java.sql.ResultSet;
import java.sql.RowId;
import java.sql.SQLException;
import java.sql.SQLXML;
import java.sql.Struct;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Map;
import oracle.jdbc.OracleArray;
import oracle.jdbc.OracleBfile;
import oracle.jdbc.OracleBlob;
import oracle.jdbc.OracleClob;
import oracle.jdbc.OracleData;
import oracle.jdbc.OracleDataFactory;
import oracle.jdbc.OracleOpaque;
import oracle.jdbc.OracleRef;
import oracle.jdbc.internal.OracleConnection;
import oracle.sql.ARRAY;
import oracle.sql.BFILE;
import oracle.sql.BINARY_DOUBLE;
import oracle.sql.BINARY_FLOAT;
import oracle.sql.BLOB;
import oracle.sql.CHAR;
import oracle.sql.CLOB;
import oracle.sql.CustomDatum;
import oracle.sql.CustomDatumFactory;
import oracle.sql.DATE;
import oracle.sql.Datum;
import oracle.sql.INTERVALDS;
import oracle.sql.INTERVALYM;
import oracle.sql.NUMBER;
import oracle.sql.OPAQUE;
import oracle.sql.ORAData;
import oracle.sql.ORADataFactory;
import oracle.sql.RAW;
import oracle.sql.REF;
import oracle.sql.ROWID;
import oracle.sql.STRUCT;
import oracle.sql.TIMESTAMP;
import oracle.sql.TIMESTAMPLTZ;
import oracle.sql.TIMESTAMPTZ;

abstract class GeneratedAccessor {
    OracleStatement statement;
    private static final String _Copyright_2007_Oracle_All_Rights_Reserved_ = null;
    public static final String BUILD_DATE = "Thu_Apr_04_15:09:24_PDT_2013";
    public static final boolean TRACE = false;

    GeneratedAccessor() {
    }

    abstract boolean isNull(int var1) throws SQLException;

    Array getArray(int var1) throws SQLException {
        if (this.isNull(var1)) {
            return null;
        } else {
            SQLException var2 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 4, "getArray not implemented for class " + this.getClass().getName());
            var2.fillInStackTrace();
            throw var2;
        }
    }

    BigDecimal getBigDecimal(int var1) throws SQLException {
        if (this.isNull(var1)) {
            return null;
        } else {
            SQLException var2 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 4, "getBigDecimal not implemented for class " + this.getClass().getName());
            var2.fillInStackTrace();
            throw var2;
        }
    }

    BigDecimal getBigDecimal(int var1, int var2) throws SQLException {
        if (this.isNull(var1)) {
            return null;
        } else {
            SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 4, "getBigDecimal not implemented for class " + this.getClass().getName());
            var3.fillInStackTrace();
            throw var3;
        }
    }

    Blob getBlob(int var1) throws SQLException {
        if (this.isNull(var1)) {
            return null;
        } else {
            SQLException var2 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 4, "getBlob not implemented for class " + this.getClass().getName());
            var2.fillInStackTrace();
            throw var2;
        }
    }

    boolean getBoolean(int var1) throws SQLException {
        if (this.isNull(var1)) {
            return false;
        } else {
            SQLException var2 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 4, "getBoolean not implemented for class " + this.getClass().getName());
            var2.fillInStackTrace();
            throw var2;
        }
    }

    byte getByte(int var1) throws SQLException {
        if (this.isNull(var1)) {
            return 0;
        } else {
            SQLException var2 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 4, "getByte not implemented for class " + this.getClass().getName());
            var2.fillInStackTrace();
            throw var2;
        }
    }

    byte[] getBytes(int var1) throws SQLException {
        if (this.isNull(var1)) {
            return null;
        } else {
            SQLException var2 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 4, "getBytes not implemented for class " + this.getClass().getName());
            var2.fillInStackTrace();
            throw var2;
        }
    }

    Clob getClob(int var1) throws SQLException {
        if (this.isNull(var1)) {
            return null;
        } else {
            SQLException var2 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 4, "getClob not implemented for class " + this.getClass().getName());
            var2.fillInStackTrace();
            throw var2;
        }
    }

    Date getDate(int var1) throws SQLException {
        if (this.isNull(var1)) {
            return null;
        } else {
            SQLException var2 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 4, "getDate not implemented for class " + this.getClass().getName());
            var2.fillInStackTrace();
            throw var2;
        }
    }

    Date getDate(int var1, Calendar var2) throws SQLException {
        if (this.isNull(var1)) {
            return null;
        } else {
            SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 4, "getDate not implemented for class " + this.getClass().getName());
            var3.fillInStackTrace();
            throw var3;
        }
    }

    double getDouble(int var1) throws SQLException {
        if (this.isNull(var1)) {
            return 0.0D;
        } else {
            SQLException var2 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 4, "getDouble not implemented for class " + this.getClass().getName());
            var2.fillInStackTrace();
            throw var2;
        }
    }

    float getFloat(int var1) throws SQLException {
        if (this.isNull(var1)) {
            return 0.0F;
        } else {
            SQLException var2 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 4, "getFloat not implemented for class " + this.getClass().getName());
            var2.fillInStackTrace();
            throw var2;
        }
    }

    int getInt(int var1) throws SQLException {
        if (this.isNull(var1)) {
            return 0;
        } else {
            SQLException var2 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 4, "getInt not implemented for class " + this.getClass().getName());
            var2.fillInStackTrace();
            throw var2;
        }
    }

    long getLong(int var1) throws SQLException {
        if (this.isNull(var1)) {
            return 0L;
        } else {
            SQLException var2 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 4, "getLong not implemented for class " + this.getClass().getName());
            var2.fillInStackTrace();
            throw var2;
        }
    }

    NClob getNClob(int var1) throws SQLException {
        if (this.isNull(var1)) {
            return null;
        } else {
            SQLException var2 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 4, "getNClob not implemented for class " + this.getClass().getName());
            var2.fillInStackTrace();
            throw var2;
        }
    }

    String getNString(int var1) throws SQLException {
        if (this.isNull(var1)) {
            return null;
        } else {
            SQLException var2 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 4, "getNString not implemented for class " + this.getClass().getName());
            var2.fillInStackTrace();
            throw var2;
        }
    }

    Object getObject(int var1) throws SQLException {
        if (this.isNull(var1)) {
            return null;
        } else {
            SQLException var2 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 4, "getObject not implemented for class " + this.getClass().getName());
            var2.fillInStackTrace();
            throw var2;
        }
    }

    Object getObject(int var1, Map var2) throws SQLException {
        if (this.isNull(var1)) {
            return null;
        } else {
            SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 4, "getObject not implemented for class " + this.getClass().getName());
            var3.fillInStackTrace();
            throw var3;
        }
    }

    Ref getRef(int var1) throws SQLException {
        if (this.isNull(var1)) {
            return null;
        } else {
            SQLException var2 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 4, "getRef not implemented for class " + this.getClass().getName());
            var2.fillInStackTrace();
            throw var2;
        }
    }

    RowId getRowId(int var1) throws SQLException {
        if (this.isNull(var1)) {
            return null;
        } else {
            SQLException var2 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 4, "getRowId not implemented for class " + this.getClass().getName());
            var2.fillInStackTrace();
            throw var2;
        }
    }

    short getShort(int var1) throws SQLException {
        if (this.isNull(var1)) {
            return 0;
        } else {
            SQLException var2 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 4, "getShort not implemented for class " + this.getClass().getName());
            var2.fillInStackTrace();
            throw var2;
        }
    }

    SQLXML getSQLXML(int var1) throws SQLException {
        if (this.isNull(var1)) {
            return null;
        } else {
            SQLException var2 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 4, "getSQLXML not implemented for class " + this.getClass().getName());
            var2.fillInStackTrace();
            throw var2;
        }
    }

    String getString(int var1) throws SQLException {
        if (this.isNull(var1)) {
            return null;
        } else {
            SQLException var2 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 4, "getString not implemented for class " + this.getClass().getName());
            var2.fillInStackTrace();
            throw var2;
        }
    }

    Struct getStruct(int var1) throws SQLException {
        if (this.isNull(var1)) {
            return null;
        } else {
            SQLException var2 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 4, "getStruct not implemented for class " + this.getClass().getName());
            var2.fillInStackTrace();
            throw var2;
        }
    }

    Time getTime(int var1) throws SQLException {
        if (this.isNull(var1)) {
            return null;
        } else {
            SQLException var2 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 4, "getTime not implemented for class " + this.getClass().getName());
            var2.fillInStackTrace();
            throw var2;
        }
    }

    Time getTime(int var1, Calendar var2) throws SQLException {
        if (this.isNull(var1)) {
            return null;
        } else {
            SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 4, "getTime not implemented for class " + this.getClass().getName());
            var3.fillInStackTrace();
            throw var3;
        }
    }

    Timestamp getTimestamp(int var1) throws SQLException {
        if (this.isNull(var1)) {
            return null;
        } else {
            SQLException var2 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 4, "getTimestamp not implemented for class " + this.getClass().getName());
            var2.fillInStackTrace();
            throw var2;
        }
    }

    Timestamp getTimestamp(int var1, Calendar var2) throws SQLException {
        if (this.isNull(var1)) {
            return null;
        } else {
            SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 4, "getTimestamp not implemented for class " + this.getClass().getName());
            var3.fillInStackTrace();
            throw var3;
        }
    }

    URL getURL(int var1) throws SQLException {
        if (this.isNull(var1)) {
            return null;
        } else {
            SQLException var2 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 4, "getURL not implemented for class " + this.getClass().getName());
            var2.fillInStackTrace();
            throw var2;
        }
    }

    BigInteger getBigInteger(int var1) throws SQLException {
        if (this.isNull(var1)) {
            return null;
        } else {
            SQLException var2 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 4, "getBigInteger not implemented for class " + this.getClass().getName());
            var2.fillInStackTrace();
            throw var2;
        }
    }

    java.util.Date getJavaUtilDate(int var1) throws SQLException {
        if (this.isNull(var1)) {
            return null;
        } else {
            SQLException var2 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 4, "getJavaUtilDate not implemented for class " + this.getClass().getName());
            var2.fillInStackTrace();
            throw var2;
        }
    }

    Calendar getCalendar(int var1) throws SQLException {
        if (this.isNull(var1)) {
            return null;
        } else {
            SQLException var2 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 4, "getCalendar not implemented for class " + this.getClass().getName());
            var2.fillInStackTrace();
            throw var2;
        }
    }

    ARRAY getARRAY(int var1) throws SQLException {
        if (this.isNull(var1)) {
            return null;
        } else {
            SQLException var2 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 4, "getARRAY not implemented for class " + this.getClass().getName());
            var2.fillInStackTrace();
            throw var2;
        }
    }

    BFILE getBFILE(int var1) throws SQLException {
        if (this.isNull(var1)) {
            return null;
        } else {
            SQLException var2 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 4, "getBFILE not implemented for class " + this.getClass().getName());
            var2.fillInStackTrace();
            throw var2;
        }
    }

    BFILE getBfile(int var1) throws SQLException {
        if (this.isNull(var1)) {
            return null;
        } else {
            SQLException var2 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 4, "getBfile not implemented for class " + this.getClass().getName());
            var2.fillInStackTrace();
            throw var2;
        }
    }

    BINARY_FLOAT getBINARY_FLOAT(int var1) throws SQLException {
        if (this.isNull(var1)) {
            return null;
        } else {
            SQLException var2 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 4, "getBINARY_FLOAT not implemented for class " + this.getClass().getName());
            var2.fillInStackTrace();
            throw var2;
        }
    }

    BINARY_DOUBLE getBINARY_DOUBLE(int var1) throws SQLException {
        if (this.isNull(var1)) {
            return null;
        } else {
            SQLException var2 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 4, "getBINARY_DOUBLE not implemented for class " + this.getClass().getName());
            var2.fillInStackTrace();
            throw var2;
        }
    }

    BLOB getBLOB(int var1) throws SQLException {
        if (this.isNull(var1)) {
            return null;
        } else {
            SQLException var2 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 4, "getBLOB not implemented for class " + this.getClass().getName());
            var2.fillInStackTrace();
            throw var2;
        }
    }

    CHAR getCHAR(int var1) throws SQLException {
        if (this.isNull(var1)) {
            return null;
        } else {
            SQLException var2 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 4, "getCHAR not implemented for class " + this.getClass().getName());
            var2.fillInStackTrace();
            throw var2;
        }
    }

    CLOB getCLOB(int var1) throws SQLException {
        if (this.isNull(var1)) {
            return null;
        } else {
            SQLException var2 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 4, "getCLOB not implemented for class " + this.getClass().getName());
            var2.fillInStackTrace();
            throw var2;
        }
    }

    ResultSet getCursor(int var1) throws SQLException {
        if (this.isNull(var1)) {
            return null;
        } else {
            SQLException var2 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 4, "getCursor not implemented for class " + this.getClass().getName());
            var2.fillInStackTrace();
            throw var2;
        }
    }

    DATE getDATE(int var1) throws SQLException {
        if (this.isNull(var1)) {
            return null;
        } else {
            SQLException var2 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 4, "getDATE not implemented for class " + this.getClass().getName());
            var2.fillInStackTrace();
            throw var2;
        }
    }

    INTERVALDS getINTERVALDS(int var1) throws SQLException {
        if (this.isNull(var1)) {
            return null;
        } else {
            SQLException var2 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 4, "getINTERVALDS not implemented for class " + this.getClass().getName());
            var2.fillInStackTrace();
            throw var2;
        }
    }

    INTERVALYM getINTERVALYM(int var1) throws SQLException {
        if (this.isNull(var1)) {
            return null;
        } else {
            SQLException var2 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 4, "getINTERVALYM not implemented for class " + this.getClass().getName());
            var2.fillInStackTrace();
            throw var2;
        }
    }

    NUMBER getNUMBER(int var1) throws SQLException {
        if (this.isNull(var1)) {
            return null;
        } else {
            SQLException var2 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 4, "getNUMBER not implemented for class " + this.getClass().getName());
            var2.fillInStackTrace();
            throw var2;
        }
    }

    OPAQUE getOPAQUE(int var1) throws SQLException {
        if (this.isNull(var1)) {
            return null;
        } else {
            SQLException var2 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 4, "getOPAQUE not implemented for class " + this.getClass().getName());
            var2.fillInStackTrace();
            throw var2;
        }
    }

    Datum getOracleObject(int var1) throws SQLException {
        if (this.isNull(var1)) {
            return null;
        } else {
            SQLException var2 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 4, "getOracleObject not implemented for class " + this.getClass().getName());
            var2.fillInStackTrace();
            throw var2;
        }
    }

    ORAData getORAData(int var1, ORADataFactory var2) throws SQLException {
        if (this.isNull(var1)) {
            return null;
        } else {
            SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 4, "getORAData not implemented for class " + this.getClass().getName());
            var3.fillInStackTrace();
            throw var3;
        }
    }

    ORAData getORAData(int var1) throws SQLException {
        if (this.isNull(var1)) {
            return null;
        } else {
            SQLException var2 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 4, "getORAData not implemented for class " + this.getClass().getName());
            var2.fillInStackTrace();
            throw var2;
        }
    }

    OracleData getOracleData(int var1) throws SQLException {
        if (this.isNull(var1)) {
            return null;
        } else {
            SQLException var2 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 4, "getOracleData not implemented for class " + this.getClass().getName());
            var2.fillInStackTrace();
            throw var2;
        }
    }

    Object getObject(int var1, OracleDataFactory var2) throws SQLException {
        if (this.isNull(var1)) {
            return null;
        } else {
            SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 4, "getObject not implemented for class " + this.getClass().getName());
            var3.fillInStackTrace();
            throw var3;
        }
    }

    RAW getRAW(int var1) throws SQLException {
        if (this.isNull(var1)) {
            return null;
        } else {
            SQLException var2 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 4, "getRAW not implemented for class " + this.getClass().getName());
            var2.fillInStackTrace();
            throw var2;
        }
    }

    REF getREF(int var1) throws SQLException {
        if (this.isNull(var1)) {
            return null;
        } else {
            SQLException var2 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 4, "getREF not implemented for class " + this.getClass().getName());
            var2.fillInStackTrace();
            throw var2;
        }
    }

    ROWID getROWID(int var1) throws SQLException {
        if (this.isNull(var1)) {
            return null;
        } else {
            SQLException var2 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 4, "getROWID not implemented for class " + this.getClass().getName());
            var2.fillInStackTrace();
            throw var2;
        }
    }

    STRUCT getSTRUCT(int var1) throws SQLException {
        if (this.isNull(var1)) {
            return null;
        } else {
            SQLException var2 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 4, "getSTRUCT not implemented for class " + this.getClass().getName());
            var2.fillInStackTrace();
            throw var2;
        }
    }

    TIMESTAMPLTZ getTIMESTAMPLTZ(int var1) throws SQLException {
        if (this.isNull(var1)) {
            return null;
        } else {
            SQLException var2 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 4, "getTIMESTAMPLTZ not implemented for class " + this.getClass().getName());
            var2.fillInStackTrace();
            throw var2;
        }
    }

    TIMESTAMPTZ getTIMESTAMPTZ(int var1) throws SQLException {
        if (this.isNull(var1)) {
            return null;
        } else {
            SQLException var2 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 4, "getTIMESTAMPTZ not implemented for class " + this.getClass().getName());
            var2.fillInStackTrace();
            throw var2;
        }
    }

    TIMESTAMP getTIMESTAMP(int var1) throws SQLException {
        if (this.isNull(var1)) {
            return null;
        } else {
            SQLException var2 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 4, "getTIMESTAMP not implemented for class " + this.getClass().getName());
            var2.fillInStackTrace();
            throw var2;
        }
    }

    CustomDatum getCustomDatum(int var1, CustomDatumFactory var2) throws SQLException {
        if (this.isNull(var1)) {
            return null;
        } else {
            SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 4, "getCustomDatum not implemented for class " + this.getClass().getName());
            var3.fillInStackTrace();
            throw var3;
        }
    }

    OracleArray getOracleArray(int var1) throws SQLException {
        if (this.isNull(var1)) {
            return null;
        } else {
            SQLException var2 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 4, "getOracleArray not implemented for class " + this.getClass().getName());
            var2.fillInStackTrace();
            throw var2;
        }
    }

    OracleBlob getOracleBlob(int var1) throws SQLException {
        if (this.isNull(var1)) {
            return null;
        } else {
            SQLException var2 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 4, "getOracleBlob not implemented for class " + this.getClass().getName());
            var2.fillInStackTrace();
            throw var2;
        }
    }

    OracleClob getOracleClob(int var1) throws SQLException {
        if (this.isNull(var1)) {
            return null;
        } else {
            SQLException var2 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 4, "getOracleClob not implemented for class " + this.getClass().getName());
            var2.fillInStackTrace();
            throw var2;
        }
    }

    OracleBfile getOracleBfile(int var1) throws SQLException {
        if (this.isNull(var1)) {
            return null;
        } else {
            SQLException var2 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 4, "getOracleBfile not implemented for class " + this.getClass().getName());
            var2.fillInStackTrace();
            throw var2;
        }
    }

    OracleRef getOracleRef(int var1) throws SQLException {
        if (this.isNull(var1)) {
            return null;
        } else {
            SQLException var2 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 4, "getOracleRef not implemented for class " + this.getClass().getName());
            var2.fillInStackTrace();
            throw var2;
        }
    }

    OracleOpaque getOracleOpaque(int var1) throws SQLException {
        if (this.isNull(var1)) {
            return null;
        } else {
            SQLException var2 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 4, "getOracleOpaque not implemented for class " + this.getClass().getName());
            var2.fillInStackTrace();
            throw var2;
        }
    }

    InputStream getAsciiStream(int var1) throws SQLException {
        if (this.isNull(var1)) {
            return null;
        } else {
            SQLException var2 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 4, "getAsciiStream not implemented for class " + this.getClass().getName());
            var2.fillInStackTrace();
            throw var2;
        }
    }

    InputStream getBinaryStream(int var1) throws SQLException {
        if (this.isNull(var1)) {
            return null;
        } else {
            SQLException var2 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 4, "getBinaryStream not implemented for class " + this.getClass().getName());
            var2.fillInStackTrace();
            throw var2;
        }
    }

    Reader getCharacterStream(int var1) throws SQLException {
        if (this.isNull(var1)) {
            return null;
        } else {
            SQLException var2 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 4, "getCharacterStream not implemented for class " + this.getClass().getName());
            var2.fillInStackTrace();
            throw var2;
        }
    }

    Reader getNCharacterStream(int var1) throws SQLException {
        if (this.isNull(var1)) {
            return null;
        } else {
            SQLException var2 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 4, "getNCharacterStream not implemented for class " + this.getClass().getName());
            var2.fillInStackTrace();
            throw var2;
        }
    }

    InputStream getUnicodeStream(int var1) throws SQLException {
        if (this.isNull(var1)) {
            return null;
        } else {
            SQLException var2 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 4, "getUnicodeStream not implemented for class " + this.getClass().getName());
            var2.fillInStackTrace();
            throw var2;
        }
    }

    protected OracleConnection getConnectionDuringExceptionHandling() {
        return this.statement.getConnectionDuringExceptionHandling();
    }
}
