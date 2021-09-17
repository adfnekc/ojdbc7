//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package oracle.jdbc.driver;

import java.io.InputStream;
import java.io.Reader;
import java.math.BigDecimal;
import java.net.URL;
import java.sql.Array;
import java.sql.Blob;
import java.sql.Clob;
import java.sql.Connection;
import java.sql.Date;
import java.sql.NClob;
import java.sql.ParameterMetaData;
import java.sql.Ref;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.RowId;
import java.sql.SQLException;
import java.sql.SQLWarning;
import java.sql.SQLXML;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Map;
import oracle.jdbc.OracleDataFactory;
import oracle.jdbc.OracleParameterMetaData;
import oracle.jdbc.dcn.DatabaseChangeRegistration;
import oracle.jdbc.internal.OracleCallableStatement;
import oracle.jdbc.internal.OracleConnection;
import oracle.jdbc.internal.OracleStatement.BindChecksumListener;
import oracle.jdbc.internal.OracleStatement.SqlKind;
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
import oracle.sql.StructDescriptor;
import oracle.sql.TIMESTAMP;
import oracle.sql.TIMESTAMPLTZ;
import oracle.sql.TIMESTAMPTZ;

class OracleClosedStatement implements OracleCallableStatement, Wrappable<OracleStatementWrapper> {
    Object acProxy;
    private static final String _Copyright_2007_Oracle_All_Rights_Reserved_ = null;
    public static final String BUILD_DATE = "Thu_Apr_04_15:09:24_PDT_2013";
    public static final boolean TRACE = false;

    OracleClosedStatement() {
    }

    public void setWrapper(OracleStatementWrapper var1) {
    }

    public void setArray(int var1, Array var2) throws SQLException {
        SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
        var3.fillInStackTrace();
        throw var3;
    }

    public void setArrayAtName(String var1, Array var2) throws SQLException {
        SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
        var3.fillInStackTrace();
        throw var3;
    }

    public void setArray(String var1, Array var2) throws SQLException {
        SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
        var3.fillInStackTrace();
        throw var3;
    }

    public void setBigDecimal(int var1, BigDecimal var2) throws SQLException {
        SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
        var3.fillInStackTrace();
        throw var3;
    }

    public void setBigDecimalAtName(String var1, BigDecimal var2) throws SQLException {
        SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
        var3.fillInStackTrace();
        throw var3;
    }

    public void setBigDecimal(String var1, BigDecimal var2) throws SQLException {
        SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
        var3.fillInStackTrace();
        throw var3;
    }

    public void setBlob(int var1, Blob var2) throws SQLException {
        SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
        var3.fillInStackTrace();
        throw var3;
    }

    public void setBlobAtName(String var1, Blob var2) throws SQLException {
        SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
        var3.fillInStackTrace();
        throw var3;
    }

    public void setBlob(String var1, Blob var2) throws SQLException {
        SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
        var3.fillInStackTrace();
        throw var3;
    }

    public void setBoolean(int var1, boolean var2) throws SQLException {
        SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
        var3.fillInStackTrace();
        throw var3;
    }

    public void setBooleanAtName(String var1, boolean var2) throws SQLException {
        SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
        var3.fillInStackTrace();
        throw var3;
    }

    public void setBoolean(String var1, boolean var2) throws SQLException {
        SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
        var3.fillInStackTrace();
        throw var3;
    }

    public void setByte(int var1, byte var2) throws SQLException {
        SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
        var3.fillInStackTrace();
        throw var3;
    }

    public void setByteAtName(String var1, byte var2) throws SQLException {
        SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
        var3.fillInStackTrace();
        throw var3;
    }

    public void setByte(String var1, byte var2) throws SQLException {
        SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
        var3.fillInStackTrace();
        throw var3;
    }

    public void setBytes(int var1, byte[] var2) throws SQLException {
        SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
        var3.fillInStackTrace();
        throw var3;
    }

    public void setBytesAtName(String var1, byte[] var2) throws SQLException {
        SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
        var3.fillInStackTrace();
        throw var3;
    }

    public void setBytes(String var1, byte[] var2) throws SQLException {
        SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
        var3.fillInStackTrace();
        throw var3;
    }

    public void setClob(int var1, Clob var2) throws SQLException {
        SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
        var3.fillInStackTrace();
        throw var3;
    }

    public void setClobAtName(String var1, Clob var2) throws SQLException {
        SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
        var3.fillInStackTrace();
        throw var3;
    }

    public void setClob(String var1, Clob var2) throws SQLException {
        SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
        var3.fillInStackTrace();
        throw var3;
    }

    public void setDate(int var1, Date var2) throws SQLException {
        SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
        var3.fillInStackTrace();
        throw var3;
    }

    public void setDateAtName(String var1, Date var2) throws SQLException {
        SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
        var3.fillInStackTrace();
        throw var3;
    }

    public void setDate(String var1, Date var2) throws SQLException {
        SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
        var3.fillInStackTrace();
        throw var3;
    }

    public void setDate(int var1, Date var2, Calendar var3) throws SQLException {
        SQLException var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
        var4.fillInStackTrace();
        throw var4;
    }

    public void setDateAtName(String var1, Date var2, Calendar var3) throws SQLException {
        SQLException var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
        var4.fillInStackTrace();
        throw var4;
    }

    public void setDate(String var1, Date var2, Calendar var3) throws SQLException {
        SQLException var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
        var4.fillInStackTrace();
        throw var4;
    }

    public void setDouble(int var1, double var2) throws SQLException {
        SQLException var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
        var4.fillInStackTrace();
        throw var4;
    }

    public void setDoubleAtName(String var1, double var2) throws SQLException {
        SQLException var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
        var4.fillInStackTrace();
        throw var4;
    }

    public void setDouble(String var1, double var2) throws SQLException {
        SQLException var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
        var4.fillInStackTrace();
        throw var4;
    }

    public void setFloat(int var1, float var2) throws SQLException {
        SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
        var3.fillInStackTrace();
        throw var3;
    }

    public void setFloatAtName(String var1, float var2) throws SQLException {
        SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
        var3.fillInStackTrace();
        throw var3;
    }

    public void setFloat(String var1, float var2) throws SQLException {
        SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
        var3.fillInStackTrace();
        throw var3;
    }

    public void setInt(int var1, int var2) throws SQLException {
        SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
        var3.fillInStackTrace();
        throw var3;
    }

    public void setIntAtName(String var1, int var2) throws SQLException {
        SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
        var3.fillInStackTrace();
        throw var3;
    }

    public void setInt(String var1, int var2) throws SQLException {
        SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
        var3.fillInStackTrace();
        throw var3;
    }

    public void setLong(int var1, long var2) throws SQLException {
        SQLException var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
        var4.fillInStackTrace();
        throw var4;
    }

    public void setLongAtName(String var1, long var2) throws SQLException {
        SQLException var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
        var4.fillInStackTrace();
        throw var4;
    }

    public void setLong(String var1, long var2) throws SQLException {
        SQLException var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
        var4.fillInStackTrace();
        throw var4;
    }

    public void setNClob(int var1, NClob var2) throws SQLException {
        SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
        var3.fillInStackTrace();
        throw var3;
    }

    public void setNClobAtName(String var1, NClob var2) throws SQLException {
        SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
        var3.fillInStackTrace();
        throw var3;
    }

    public void setNClob(String var1, NClob var2) throws SQLException {
        SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
        var3.fillInStackTrace();
        throw var3;
    }

    public void setNString(int var1, String var2) throws SQLException {
        SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
        var3.fillInStackTrace();
        throw var3;
    }

    public void setNStringAtName(String var1, String var2) throws SQLException {
        SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
        var3.fillInStackTrace();
        throw var3;
    }

    public void setNString(String var1, String var2) throws SQLException {
        SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
        var3.fillInStackTrace();
        throw var3;
    }

    public void setObject(int var1, Object var2) throws SQLException {
        SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
        var3.fillInStackTrace();
        throw var3;
    }

    public void setObjectAtName(String var1, Object var2) throws SQLException {
        SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
        var3.fillInStackTrace();
        throw var3;
    }

    public void setObject(String var1, Object var2) throws SQLException {
        SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
        var3.fillInStackTrace();
        throw var3;
    }

    public void setObject(int var1, Object var2, int var3) throws SQLException {
        SQLException var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
        var4.fillInStackTrace();
        throw var4;
    }

    public void setObjectAtName(String var1, Object var2, int var3) throws SQLException {
        SQLException var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
        var4.fillInStackTrace();
        throw var4;
    }

    public void setObject(String var1, Object var2, int var3) throws SQLException {
        SQLException var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
        var4.fillInStackTrace();
        throw var4;
    }

    public void setRef(int var1, Ref var2) throws SQLException {
        SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
        var3.fillInStackTrace();
        throw var3;
    }

    public void setRefAtName(String var1, Ref var2) throws SQLException {
        SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
        var3.fillInStackTrace();
        throw var3;
    }

    public void setRef(String var1, Ref var2) throws SQLException {
        SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
        var3.fillInStackTrace();
        throw var3;
    }

    public void setRowId(int var1, RowId var2) throws SQLException {
        SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
        var3.fillInStackTrace();
        throw var3;
    }

    public void setRowIdAtName(String var1, RowId var2) throws SQLException {
        SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
        var3.fillInStackTrace();
        throw var3;
    }

    public void setRowId(String var1, RowId var2) throws SQLException {
        SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
        var3.fillInStackTrace();
        throw var3;
    }

    public void setShort(int var1, short var2) throws SQLException {
        SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
        var3.fillInStackTrace();
        throw var3;
    }

    public void setShortAtName(String var1, short var2) throws SQLException {
        SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
        var3.fillInStackTrace();
        throw var3;
    }

    public void setShort(String var1, short var2) throws SQLException {
        SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
        var3.fillInStackTrace();
        throw var3;
    }

    public void setSQLXML(int var1, SQLXML var2) throws SQLException {
        SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
        var3.fillInStackTrace();
        throw var3;
    }

    public void setSQLXMLAtName(String var1, SQLXML var2) throws SQLException {
        SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
        var3.fillInStackTrace();
        throw var3;
    }

    public void setSQLXML(String var1, SQLXML var2) throws SQLException {
        SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
        var3.fillInStackTrace();
        throw var3;
    }

    public void setString(int var1, String var2) throws SQLException {
        SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
        var3.fillInStackTrace();
        throw var3;
    }

    public void setStringAtName(String var1, String var2) throws SQLException {
        SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
        var3.fillInStackTrace();
        throw var3;
    }

    public void setString(String var1, String var2) throws SQLException {
        SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
        var3.fillInStackTrace();
        throw var3;
    }

    public void setTime(int var1, Time var2) throws SQLException {
        SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
        var3.fillInStackTrace();
        throw var3;
    }

    public void setTimeAtName(String var1, Time var2) throws SQLException {
        SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
        var3.fillInStackTrace();
        throw var3;
    }

    public void setTime(String var1, Time var2) throws SQLException {
        SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
        var3.fillInStackTrace();
        throw var3;
    }

    public void setTime(int var1, Time var2, Calendar var3) throws SQLException {
        SQLException var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
        var4.fillInStackTrace();
        throw var4;
    }

    public void setTimeAtName(String var1, Time var2, Calendar var3) throws SQLException {
        SQLException var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
        var4.fillInStackTrace();
        throw var4;
    }

    public void setTime(String var1, Time var2, Calendar var3) throws SQLException {
        SQLException var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
        var4.fillInStackTrace();
        throw var4;
    }

    public void setTimestamp(int var1, Timestamp var2) throws SQLException {
        SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
        var3.fillInStackTrace();
        throw var3;
    }

    public void setTimestampAtName(String var1, Timestamp var2) throws SQLException {
        SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
        var3.fillInStackTrace();
        throw var3;
    }

    public void setTimestamp(String var1, Timestamp var2) throws SQLException {
        SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
        var3.fillInStackTrace();
        throw var3;
    }

    public void setTimestamp(int var1, Timestamp var2, Calendar var3) throws SQLException {
        SQLException var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
        var4.fillInStackTrace();
        throw var4;
    }

    public void setTimestampAtName(String var1, Timestamp var2, Calendar var3) throws SQLException {
        SQLException var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
        var4.fillInStackTrace();
        throw var4;
    }

    public void setTimestamp(String var1, Timestamp var2, Calendar var3) throws SQLException {
        SQLException var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
        var4.fillInStackTrace();
        throw var4;
    }

    public void setURL(int var1, URL var2) throws SQLException {
        SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
        var3.fillInStackTrace();
        throw var3;
    }

    public void setURLAtName(String var1, URL var2) throws SQLException {
        SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
        var3.fillInStackTrace();
        throw var3;
    }

    public void setURL(String var1, URL var2) throws SQLException {
        SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
        var3.fillInStackTrace();
        throw var3;
    }

    public void setARRAY(int var1, ARRAY var2) throws SQLException {
        SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
        var3.fillInStackTrace();
        throw var3;
    }

    public void setARRAYAtName(String var1, ARRAY var2) throws SQLException {
        SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
        var3.fillInStackTrace();
        throw var3;
    }

    public void setARRAY(String var1, ARRAY var2) throws SQLException {
        SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
        var3.fillInStackTrace();
        throw var3;
    }

    public void setBFILE(int var1, BFILE var2) throws SQLException {
        SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
        var3.fillInStackTrace();
        throw var3;
    }

    public void setBFILEAtName(String var1, BFILE var2) throws SQLException {
        SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
        var3.fillInStackTrace();
        throw var3;
    }

    public void setBFILE(String var1, BFILE var2) throws SQLException {
        SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
        var3.fillInStackTrace();
        throw var3;
    }

    public void setBfile(int var1, BFILE var2) throws SQLException {
        SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
        var3.fillInStackTrace();
        throw var3;
    }

    public void setBfileAtName(String var1, BFILE var2) throws SQLException {
        SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
        var3.fillInStackTrace();
        throw var3;
    }

    public void setBfile(String var1, BFILE var2) throws SQLException {
        SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
        var3.fillInStackTrace();
        throw var3;
    }

    public void setBinaryFloat(int var1, float var2) throws SQLException {
        SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
        var3.fillInStackTrace();
        throw var3;
    }

    public void setBinaryFloatAtName(String var1, float var2) throws SQLException {
        SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
        var3.fillInStackTrace();
        throw var3;
    }

    public void setBinaryFloat(String var1, float var2) throws SQLException {
        SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
        var3.fillInStackTrace();
        throw var3;
    }

    public void setBinaryFloat(int var1, BINARY_FLOAT var2) throws SQLException {
        SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
        var3.fillInStackTrace();
        throw var3;
    }

    public void setBinaryFloatAtName(String var1, BINARY_FLOAT var2) throws SQLException {
        SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
        var3.fillInStackTrace();
        throw var3;
    }

    public void setBinaryFloat(String var1, BINARY_FLOAT var2) throws SQLException {
        SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
        var3.fillInStackTrace();
        throw var3;
    }

    public void setBinaryDouble(int var1, double var2) throws SQLException {
        SQLException var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
        var4.fillInStackTrace();
        throw var4;
    }

    public void setBinaryDoubleAtName(String var1, double var2) throws SQLException {
        SQLException var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
        var4.fillInStackTrace();
        throw var4;
    }

    public void setBinaryDouble(String var1, double var2) throws SQLException {
        SQLException var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
        var4.fillInStackTrace();
        throw var4;
    }

    public void setBinaryDouble(int var1, BINARY_DOUBLE var2) throws SQLException {
        SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
        var3.fillInStackTrace();
        throw var3;
    }

    public void setBinaryDoubleAtName(String var1, BINARY_DOUBLE var2) throws SQLException {
        SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
        var3.fillInStackTrace();
        throw var3;
    }

    public void setBinaryDouble(String var1, BINARY_DOUBLE var2) throws SQLException {
        SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
        var3.fillInStackTrace();
        throw var3;
    }

    public void setBLOB(int var1, BLOB var2) throws SQLException {
        SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
        var3.fillInStackTrace();
        throw var3;
    }

    public void setBLOBAtName(String var1, BLOB var2) throws SQLException {
        SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
        var3.fillInStackTrace();
        throw var3;
    }

    public void setBLOB(String var1, BLOB var2) throws SQLException {
        SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
        var3.fillInStackTrace();
        throw var3;
    }

    public void setCHAR(int var1, CHAR var2) throws SQLException {
        SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
        var3.fillInStackTrace();
        throw var3;
    }

    public void setCHARAtName(String var1, CHAR var2) throws SQLException {
        SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
        var3.fillInStackTrace();
        throw var3;
    }

    public void setCHAR(String var1, CHAR var2) throws SQLException {
        SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
        var3.fillInStackTrace();
        throw var3;
    }

    public void setCLOB(int var1, CLOB var2) throws SQLException {
        SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
        var3.fillInStackTrace();
        throw var3;
    }

    public void setCLOBAtName(String var1, CLOB var2) throws SQLException {
        SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
        var3.fillInStackTrace();
        throw var3;
    }

    public void setCLOB(String var1, CLOB var2) throws SQLException {
        SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
        var3.fillInStackTrace();
        throw var3;
    }

    public void setCursor(int var1, ResultSet var2) throws SQLException {
        SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
        var3.fillInStackTrace();
        throw var3;
    }

    public void setCursorAtName(String var1, ResultSet var2) throws SQLException {
        SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
        var3.fillInStackTrace();
        throw var3;
    }

    public void setCursor(String var1, ResultSet var2) throws SQLException {
        SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
        var3.fillInStackTrace();
        throw var3;
    }

    public void setDATE(int var1, DATE var2) throws SQLException {
        SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
        var3.fillInStackTrace();
        throw var3;
    }

    public void setDATEAtName(String var1, DATE var2) throws SQLException {
        SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
        var3.fillInStackTrace();
        throw var3;
    }

    public void setDATE(String var1, DATE var2) throws SQLException {
        SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
        var3.fillInStackTrace();
        throw var3;
    }

    public void setFixedCHAR(int var1, String var2) throws SQLException {
        SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
        var3.fillInStackTrace();
        throw var3;
    }

    public void setFixedCHARAtName(String var1, String var2) throws SQLException {
        SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
        var3.fillInStackTrace();
        throw var3;
    }

    public void setFixedCHAR(String var1, String var2) throws SQLException {
        SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
        var3.fillInStackTrace();
        throw var3;
    }

    public void setINTERVALDS(int var1, INTERVALDS var2) throws SQLException {
        SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
        var3.fillInStackTrace();
        throw var3;
    }

    public void setINTERVALDSAtName(String var1, INTERVALDS var2) throws SQLException {
        SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
        var3.fillInStackTrace();
        throw var3;
    }

    public void setINTERVALDS(String var1, INTERVALDS var2) throws SQLException {
        SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
        var3.fillInStackTrace();
        throw var3;
    }

    public void setINTERVALYM(int var1, INTERVALYM var2) throws SQLException {
        SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
        var3.fillInStackTrace();
        throw var3;
    }

    public void setINTERVALYMAtName(String var1, INTERVALYM var2) throws SQLException {
        SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
        var3.fillInStackTrace();
        throw var3;
    }

    public void setINTERVALYM(String var1, INTERVALYM var2) throws SQLException {
        SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
        var3.fillInStackTrace();
        throw var3;
    }

    public void setNUMBER(int var1, NUMBER var2) throws SQLException {
        SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
        var3.fillInStackTrace();
        throw var3;
    }

    public void setNUMBERAtName(String var1, NUMBER var2) throws SQLException {
        SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
        var3.fillInStackTrace();
        throw var3;
    }

    public void setNUMBER(String var1, NUMBER var2) throws SQLException {
        SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
        var3.fillInStackTrace();
        throw var3;
    }

    public void setOPAQUE(int var1, OPAQUE var2) throws SQLException {
        SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
        var3.fillInStackTrace();
        throw var3;
    }

    public void setOPAQUEAtName(String var1, OPAQUE var2) throws SQLException {
        SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
        var3.fillInStackTrace();
        throw var3;
    }

    public void setOPAQUE(String var1, OPAQUE var2) throws SQLException {
        SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
        var3.fillInStackTrace();
        throw var3;
    }

    public void setOracleObject(int var1, Datum var2) throws SQLException {
        SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
        var3.fillInStackTrace();
        throw var3;
    }

    public void setOracleObjectAtName(String var1, Datum var2) throws SQLException {
        SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
        var3.fillInStackTrace();
        throw var3;
    }

    public void setOracleObject(String var1, Datum var2) throws SQLException {
        SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
        var3.fillInStackTrace();
        throw var3;
    }

    public void setORAData(int var1, ORAData var2) throws SQLException {
        SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
        var3.fillInStackTrace();
        throw var3;
    }

    public void setORADataAtName(String var1, ORAData var2) throws SQLException {
        SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
        var3.fillInStackTrace();
        throw var3;
    }

    public void setORAData(String var1, ORAData var2) throws SQLException {
        SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
        var3.fillInStackTrace();
        throw var3;
    }

    public void setRAW(int var1, RAW var2) throws SQLException {
        SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
        var3.fillInStackTrace();
        throw var3;
    }

    public void setRAWAtName(String var1, RAW var2) throws SQLException {
        SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
        var3.fillInStackTrace();
        throw var3;
    }

    public void setRAW(String var1, RAW var2) throws SQLException {
        SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
        var3.fillInStackTrace();
        throw var3;
    }

    public void setREF(int var1, REF var2) throws SQLException {
        SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
        var3.fillInStackTrace();
        throw var3;
    }

    public void setREFAtName(String var1, REF var2) throws SQLException {
        SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
        var3.fillInStackTrace();
        throw var3;
    }

    public void setREF(String var1, REF var2) throws SQLException {
        SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
        var3.fillInStackTrace();
        throw var3;
    }

    public void setRefType(int var1, REF var2) throws SQLException {
        SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
        var3.fillInStackTrace();
        throw var3;
    }

    public void setRefTypeAtName(String var1, REF var2) throws SQLException {
        SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
        var3.fillInStackTrace();
        throw var3;
    }

    public void setRefType(String var1, REF var2) throws SQLException {
        SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
        var3.fillInStackTrace();
        throw var3;
    }

    public void setROWID(int var1, ROWID var2) throws SQLException {
        SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
        var3.fillInStackTrace();
        throw var3;
    }

    public void setROWIDAtName(String var1, ROWID var2) throws SQLException {
        SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
        var3.fillInStackTrace();
        throw var3;
    }

    public void setROWID(String var1, ROWID var2) throws SQLException {
        SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
        var3.fillInStackTrace();
        throw var3;
    }

    public void setSTRUCT(int var1, STRUCT var2) throws SQLException {
        SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
        var3.fillInStackTrace();
        throw var3;
    }

    public void setSTRUCTAtName(String var1, STRUCT var2) throws SQLException {
        SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
        var3.fillInStackTrace();
        throw var3;
    }

    public void setSTRUCT(String var1, STRUCT var2) throws SQLException {
        SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
        var3.fillInStackTrace();
        throw var3;
    }

    public void setTIMESTAMPLTZ(int var1, TIMESTAMPLTZ var2) throws SQLException {
        SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
        var3.fillInStackTrace();
        throw var3;
    }

    public void setTIMESTAMPLTZAtName(String var1, TIMESTAMPLTZ var2) throws SQLException {
        SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
        var3.fillInStackTrace();
        throw var3;
    }

    public void setTIMESTAMPLTZ(String var1, TIMESTAMPLTZ var2) throws SQLException {
        SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
        var3.fillInStackTrace();
        throw var3;
    }

    public void setTIMESTAMPTZ(int var1, TIMESTAMPTZ var2) throws SQLException {
        SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
        var3.fillInStackTrace();
        throw var3;
    }

    public void setTIMESTAMPTZAtName(String var1, TIMESTAMPTZ var2) throws SQLException {
        SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
        var3.fillInStackTrace();
        throw var3;
    }

    public void setTIMESTAMPTZ(String var1, TIMESTAMPTZ var2) throws SQLException {
        SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
        var3.fillInStackTrace();
        throw var3;
    }

    public void setTIMESTAMP(int var1, TIMESTAMP var2) throws SQLException {
        SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
        var3.fillInStackTrace();
        throw var3;
    }

    public void setTIMESTAMPAtName(String var1, TIMESTAMP var2) throws SQLException {
        SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
        var3.fillInStackTrace();
        throw var3;
    }

    public void setTIMESTAMP(String var1, TIMESTAMP var2) throws SQLException {
        SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
        var3.fillInStackTrace();
        throw var3;
    }

    public void setCustomDatum(int var1, CustomDatum var2) throws SQLException {
        SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
        var3.fillInStackTrace();
        throw var3;
    }

    public void setCustomDatumAtName(String var1, CustomDatum var2) throws SQLException {
        SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
        var3.fillInStackTrace();
        throw var3;
    }

    public void setCustomDatum(String var1, CustomDatum var2) throws SQLException {
        SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
        var3.fillInStackTrace();
        throw var3;
    }

    public void setBlob(int var1, InputStream var2) throws SQLException {
        SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
        var3.fillInStackTrace();
        throw var3;
    }

    public void setBlobAtName(String var1, InputStream var2) throws SQLException {
        SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
        var3.fillInStackTrace();
        throw var3;
    }

    public void setBlob(String var1, InputStream var2) throws SQLException {
        SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
        var3.fillInStackTrace();
        throw var3;
    }

    public void setBlob(int var1, InputStream var2, long var3) throws SQLException {
        SQLException var5 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
        var5.fillInStackTrace();
        throw var5;
    }

    public void setBlobAtName(String var1, InputStream var2, long var3) throws SQLException {
        SQLException var5 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
        var5.fillInStackTrace();
        throw var5;
    }

    public void setBlob(String var1, InputStream var2, long var3) throws SQLException {
        SQLException var5 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
        var5.fillInStackTrace();
        throw var5;
    }

    public void setClob(int var1, Reader var2) throws SQLException {
        SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
        var3.fillInStackTrace();
        throw var3;
    }

    public void setClobAtName(String var1, Reader var2) throws SQLException {
        SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
        var3.fillInStackTrace();
        throw var3;
    }

    public void setClob(String var1, Reader var2) throws SQLException {
        SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
        var3.fillInStackTrace();
        throw var3;
    }

    public void setClob(int var1, Reader var2, long var3) throws SQLException {
        SQLException var5 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
        var5.fillInStackTrace();
        throw var5;
    }

    public void setClobAtName(String var1, Reader var2, long var3) throws SQLException {
        SQLException var5 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
        var5.fillInStackTrace();
        throw var5;
    }

    public void setClob(String var1, Reader var2, long var3) throws SQLException {
        SQLException var5 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
        var5.fillInStackTrace();
        throw var5;
    }

    public void setNClob(int var1, Reader var2) throws SQLException {
        SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
        var3.fillInStackTrace();
        throw var3;
    }

    public void setNClobAtName(String var1, Reader var2) throws SQLException {
        SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
        var3.fillInStackTrace();
        throw var3;
    }

    public void setNClob(String var1, Reader var2) throws SQLException {
        SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
        var3.fillInStackTrace();
        throw var3;
    }

    public void setNClob(int var1, Reader var2, long var3) throws SQLException {
        SQLException var5 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
        var5.fillInStackTrace();
        throw var5;
    }

    public void setNClobAtName(String var1, Reader var2, long var3) throws SQLException {
        SQLException var5 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
        var5.fillInStackTrace();
        throw var5;
    }

    public void setNClob(String var1, Reader var2, long var3) throws SQLException {
        SQLException var5 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
        var5.fillInStackTrace();
        throw var5;
    }

    public void setAsciiStream(int var1, InputStream var2) throws SQLException {
        SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
        var3.fillInStackTrace();
        throw var3;
    }

    public void setAsciiStreamAtName(String var1, InputStream var2) throws SQLException {
        SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
        var3.fillInStackTrace();
        throw var3;
    }

    public void setAsciiStream(String var1, InputStream var2) throws SQLException {
        SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
        var3.fillInStackTrace();
        throw var3;
    }

    public void setAsciiStream(int var1, InputStream var2, int var3) throws SQLException {
        SQLException var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
        var4.fillInStackTrace();
        throw var4;
    }

    public void setAsciiStreamAtName(String var1, InputStream var2, int var3) throws SQLException {
        SQLException var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
        var4.fillInStackTrace();
        throw var4;
    }

    public void setAsciiStream(String var1, InputStream var2, int var3) throws SQLException {
        SQLException var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
        var4.fillInStackTrace();
        throw var4;
    }

    public void setAsciiStream(int var1, InputStream var2, long var3) throws SQLException {
        SQLException var5 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
        var5.fillInStackTrace();
        throw var5;
    }

    public void setAsciiStreamAtName(String var1, InputStream var2, long var3) throws SQLException {
        SQLException var5 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
        var5.fillInStackTrace();
        throw var5;
    }

    public void setAsciiStream(String var1, InputStream var2, long var3) throws SQLException {
        SQLException var5 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
        var5.fillInStackTrace();
        throw var5;
    }

    public void setBinaryStream(int var1, InputStream var2) throws SQLException {
        SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
        var3.fillInStackTrace();
        throw var3;
    }

    public void setBinaryStreamAtName(String var1, InputStream var2) throws SQLException {
        SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
        var3.fillInStackTrace();
        throw var3;
    }

    public void setBinaryStream(String var1, InputStream var2) throws SQLException {
        SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
        var3.fillInStackTrace();
        throw var3;
    }

    public void setBinaryStream(int var1, InputStream var2, int var3) throws SQLException {
        SQLException var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
        var4.fillInStackTrace();
        throw var4;
    }

    public void setBinaryStreamAtName(String var1, InputStream var2, int var3) throws SQLException {
        SQLException var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
        var4.fillInStackTrace();
        throw var4;
    }

    public void setBinaryStream(String var1, InputStream var2, int var3) throws SQLException {
        SQLException var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
        var4.fillInStackTrace();
        throw var4;
    }

    public void setBinaryStream(int var1, InputStream var2, long var3) throws SQLException {
        SQLException var5 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
        var5.fillInStackTrace();
        throw var5;
    }

    public void setBinaryStreamAtName(String var1, InputStream var2, long var3) throws SQLException {
        SQLException var5 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
        var5.fillInStackTrace();
        throw var5;
    }

    public void setBinaryStream(String var1, InputStream var2, long var3) throws SQLException {
        SQLException var5 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
        var5.fillInStackTrace();
        throw var5;
    }

    public void setCharacterStream(int var1, Reader var2) throws SQLException {
        SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
        var3.fillInStackTrace();
        throw var3;
    }

    public void setCharacterStreamAtName(String var1, Reader var2) throws SQLException {
        SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
        var3.fillInStackTrace();
        throw var3;
    }

    public void setCharacterStream(String var1, Reader var2) throws SQLException {
        SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
        var3.fillInStackTrace();
        throw var3;
    }

    public void setCharacterStream(int var1, Reader var2, int var3) throws SQLException {
        SQLException var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
        var4.fillInStackTrace();
        throw var4;
    }

    public void setCharacterStreamAtName(String var1, Reader var2, int var3) throws SQLException {
        SQLException var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
        var4.fillInStackTrace();
        throw var4;
    }

    public void setCharacterStream(String var1, Reader var2, int var3) throws SQLException {
        SQLException var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
        var4.fillInStackTrace();
        throw var4;
    }

    public void setCharacterStream(int var1, Reader var2, long var3) throws SQLException {
        SQLException var5 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
        var5.fillInStackTrace();
        throw var5;
    }

    public void setCharacterStreamAtName(String var1, Reader var2, long var3) throws SQLException {
        SQLException var5 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
        var5.fillInStackTrace();
        throw var5;
    }

    public void setCharacterStream(String var1, Reader var2, long var3) throws SQLException {
        SQLException var5 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
        var5.fillInStackTrace();
        throw var5;
    }

    public void setNCharacterStream(int var1, Reader var2) throws SQLException {
        SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
        var3.fillInStackTrace();
        throw var3;
    }

    public void setNCharacterStreamAtName(String var1, Reader var2) throws SQLException {
        SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
        var3.fillInStackTrace();
        throw var3;
    }

    public void setNCharacterStream(String var1, Reader var2) throws SQLException {
        SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
        var3.fillInStackTrace();
        throw var3;
    }

    public void setNCharacterStream(int var1, Reader var2, long var3) throws SQLException {
        SQLException var5 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
        var5.fillInStackTrace();
        throw var5;
    }

    public void setNCharacterStreamAtName(String var1, Reader var2, long var3) throws SQLException {
        SQLException var5 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
        var5.fillInStackTrace();
        throw var5;
    }

    public void setNCharacterStream(String var1, Reader var2, long var3) throws SQLException {
        SQLException var5 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
        var5.fillInStackTrace();
        throw var5;
    }

    public void setUnicodeStream(int var1, InputStream var2, int var3) throws SQLException {
        SQLException var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
        var4.fillInStackTrace();
        throw var4;
    }

    public void setUnicodeStreamAtName(String var1, InputStream var2, int var3) throws SQLException {
        SQLException var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
        var4.fillInStackTrace();
        throw var4;
    }

    public void setUnicodeStream(String var1, InputStream var2, int var3) throws SQLException {
        SQLException var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
        var4.fillInStackTrace();
        throw var4;
    }

    public Array getArray(int var1) throws SQLException {
        SQLException var2 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
        var2.fillInStackTrace();
        throw var2;
    }

    public Array getArray(String var1) throws SQLException {
        SQLException var2 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
        var2.fillInStackTrace();
        throw var2;
    }

    public BigDecimal getBigDecimal(int var1) throws SQLException {
        SQLException var2 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
        var2.fillInStackTrace();
        throw var2;
    }

    public BigDecimal getBigDecimal(String var1) throws SQLException {
        SQLException var2 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
        var2.fillInStackTrace();
        throw var2;
    }

    public BigDecimal getBigDecimal(int var1, int var2) throws SQLException {
        SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
        var3.fillInStackTrace();
        throw var3;
    }

    public BigDecimal getBigDecimal(String var1, int var2) throws SQLException {
        SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
        var3.fillInStackTrace();
        throw var3;
    }

    public Blob getBlob(int var1) throws SQLException {
        SQLException var2 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
        var2.fillInStackTrace();
        throw var2;
    }

    public Blob getBlob(String var1) throws SQLException {
        SQLException var2 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
        var2.fillInStackTrace();
        throw var2;
    }

    public boolean getBoolean(int var1) throws SQLException {
        SQLException var2 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
        var2.fillInStackTrace();
        throw var2;
    }

    public boolean getBoolean(String var1) throws SQLException {
        SQLException var2 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
        var2.fillInStackTrace();
        throw var2;
    }

    public byte getByte(int var1) throws SQLException {
        SQLException var2 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
        var2.fillInStackTrace();
        throw var2;
    }

    public byte getByte(String var1) throws SQLException {
        SQLException var2 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
        var2.fillInStackTrace();
        throw var2;
    }

    public byte[] getBytes(int var1) throws SQLException {
        SQLException var2 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
        var2.fillInStackTrace();
        throw var2;
    }

    public byte[] getBytes(String var1) throws SQLException {
        SQLException var2 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
        var2.fillInStackTrace();
        throw var2;
    }

    public Clob getClob(int var1) throws SQLException {
        SQLException var2 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
        var2.fillInStackTrace();
        throw var2;
    }

    public Clob getClob(String var1) throws SQLException {
        SQLException var2 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
        var2.fillInStackTrace();
        throw var2;
    }

    public Date getDate(int var1) throws SQLException {
        SQLException var2 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
        var2.fillInStackTrace();
        throw var2;
    }

    public Date getDate(String var1) throws SQLException {
        SQLException var2 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
        var2.fillInStackTrace();
        throw var2;
    }

    public Date getDate(int var1, Calendar var2) throws SQLException {
        SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
        var3.fillInStackTrace();
        throw var3;
    }

    public Date getDate(String var1, Calendar var2) throws SQLException {
        SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
        var3.fillInStackTrace();
        throw var3;
    }

    public double getDouble(int var1) throws SQLException {
        SQLException var2 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
        var2.fillInStackTrace();
        throw var2;
    }

    public double getDouble(String var1) throws SQLException {
        SQLException var2 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
        var2.fillInStackTrace();
        throw var2;
    }

    public float getFloat(int var1) throws SQLException {
        SQLException var2 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
        var2.fillInStackTrace();
        throw var2;
    }

    public float getFloat(String var1) throws SQLException {
        SQLException var2 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
        var2.fillInStackTrace();
        throw var2;
    }

    public int getInt(int var1) throws SQLException {
        SQLException var2 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
        var2.fillInStackTrace();
        throw var2;
    }

    public int getInt(String var1) throws SQLException {
        SQLException var2 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
        var2.fillInStackTrace();
        throw var2;
    }

    public long getLong(int var1) throws SQLException {
        SQLException var2 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
        var2.fillInStackTrace();
        throw var2;
    }

    public long getLong(String var1) throws SQLException {
        SQLException var2 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
        var2.fillInStackTrace();
        throw var2;
    }

    public NClob getNClob(int var1) throws SQLException {
        SQLException var2 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
        var2.fillInStackTrace();
        throw var2;
    }

    public NClob getNClob(String var1) throws SQLException {
        SQLException var2 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
        var2.fillInStackTrace();
        throw var2;
    }

    public String getNString(int var1) throws SQLException {
        SQLException var2 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
        var2.fillInStackTrace();
        throw var2;
    }

    public String getNString(String var1) throws SQLException {
        SQLException var2 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
        var2.fillInStackTrace();
        throw var2;
    }

    public Object getObject(int var1) throws SQLException {
        SQLException var2 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
        var2.fillInStackTrace();
        throw var2;
    }

    public Object getObject(String var1) throws SQLException {
        SQLException var2 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
        var2.fillInStackTrace();
        throw var2;
    }

    public Object getObject(int var1, Map var2) throws SQLException {
        SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
        var3.fillInStackTrace();
        throw var3;
    }

    public Object getObject(String var1, Map var2) throws SQLException {
        SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
        var3.fillInStackTrace();
        throw var3;
    }

    public Ref getRef(int var1) throws SQLException {
        SQLException var2 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
        var2.fillInStackTrace();
        throw var2;
    }

    public Ref getRef(String var1) throws SQLException {
        SQLException var2 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
        var2.fillInStackTrace();
        throw var2;
    }

    public RowId getRowId(int var1) throws SQLException {
        SQLException var2 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
        var2.fillInStackTrace();
        throw var2;
    }

    public RowId getRowId(String var1) throws SQLException {
        SQLException var2 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
        var2.fillInStackTrace();
        throw var2;
    }

    public short getShort(int var1) throws SQLException {
        SQLException var2 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
        var2.fillInStackTrace();
        throw var2;
    }

    public short getShort(String var1) throws SQLException {
        SQLException var2 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
        var2.fillInStackTrace();
        throw var2;
    }

    public SQLXML getSQLXML(int var1) throws SQLException {
        SQLException var2 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
        var2.fillInStackTrace();
        throw var2;
    }

    public SQLXML getSQLXML(String var1) throws SQLException {
        SQLException var2 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
        var2.fillInStackTrace();
        throw var2;
    }

    public String getString(int var1) throws SQLException {
        SQLException var2 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
        var2.fillInStackTrace();
        throw var2;
    }

    public String getString(String var1) throws SQLException {
        SQLException var2 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
        var2.fillInStackTrace();
        throw var2;
    }

    public Time getTime(int var1) throws SQLException {
        SQLException var2 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
        var2.fillInStackTrace();
        throw var2;
    }

    public Time getTime(String var1) throws SQLException {
        SQLException var2 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
        var2.fillInStackTrace();
        throw var2;
    }

    public Time getTime(int var1, Calendar var2) throws SQLException {
        SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
        var3.fillInStackTrace();
        throw var3;
    }

    public Time getTime(String var1, Calendar var2) throws SQLException {
        SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
        var3.fillInStackTrace();
        throw var3;
    }

    public Timestamp getTimestamp(int var1) throws SQLException {
        SQLException var2 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
        var2.fillInStackTrace();
        throw var2;
    }

    public Timestamp getTimestamp(String var1) throws SQLException {
        SQLException var2 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
        var2.fillInStackTrace();
        throw var2;
    }

    public Timestamp getTimestamp(int var1, Calendar var2) throws SQLException {
        SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
        var3.fillInStackTrace();
        throw var3;
    }

    public Timestamp getTimestamp(String var1, Calendar var2) throws SQLException {
        SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
        var3.fillInStackTrace();
        throw var3;
    }

    public URL getURL(int var1) throws SQLException {
        SQLException var2 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
        var2.fillInStackTrace();
        throw var2;
    }

    public URL getURL(String var1) throws SQLException {
        SQLException var2 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
        var2.fillInStackTrace();
        throw var2;
    }

    public ARRAY getARRAY(int var1) throws SQLException {
        SQLException var2 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
        var2.fillInStackTrace();
        throw var2;
    }

    public ARRAY getARRAY(String var1) throws SQLException {
        SQLException var2 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
        var2.fillInStackTrace();
        throw var2;
    }

    public BFILE getBFILE(int var1) throws SQLException {
        SQLException var2 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
        var2.fillInStackTrace();
        throw var2;
    }

    public BFILE getBFILE(String var1) throws SQLException {
        SQLException var2 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
        var2.fillInStackTrace();
        throw var2;
    }

    public BFILE getBfile(int var1) throws SQLException {
        SQLException var2 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
        var2.fillInStackTrace();
        throw var2;
    }

    public BFILE getBfile(String var1) throws SQLException {
        SQLException var2 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
        var2.fillInStackTrace();
        throw var2;
    }

    public BLOB getBLOB(int var1) throws SQLException {
        SQLException var2 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
        var2.fillInStackTrace();
        throw var2;
    }

    public BLOB getBLOB(String var1) throws SQLException {
        SQLException var2 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
        var2.fillInStackTrace();
        throw var2;
    }

    public CHAR getCHAR(int var1) throws SQLException {
        SQLException var2 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
        var2.fillInStackTrace();
        throw var2;
    }

    public CHAR getCHAR(String var1) throws SQLException {
        SQLException var2 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
        var2.fillInStackTrace();
        throw var2;
    }

    public CLOB getCLOB(int var1) throws SQLException {
        SQLException var2 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
        var2.fillInStackTrace();
        throw var2;
    }

    public CLOB getCLOB(String var1) throws SQLException {
        SQLException var2 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
        var2.fillInStackTrace();
        throw var2;
    }

    public ResultSet getCursor(int var1) throws SQLException {
        SQLException var2 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
        var2.fillInStackTrace();
        throw var2;
    }

    public ResultSet getCursor(String var1) throws SQLException {
        SQLException var2 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
        var2.fillInStackTrace();
        throw var2;
    }

    public DATE getDATE(int var1) throws SQLException {
        SQLException var2 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
        var2.fillInStackTrace();
        throw var2;
    }

    public DATE getDATE(String var1) throws SQLException {
        SQLException var2 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
        var2.fillInStackTrace();
        throw var2;
    }

    public INTERVALDS getINTERVALDS(int var1) throws SQLException {
        SQLException var2 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
        var2.fillInStackTrace();
        throw var2;
    }

    public INTERVALDS getINTERVALDS(String var1) throws SQLException {
        SQLException var2 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
        var2.fillInStackTrace();
        throw var2;
    }

    public INTERVALYM getINTERVALYM(int var1) throws SQLException {
        SQLException var2 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
        var2.fillInStackTrace();
        throw var2;
    }

    public INTERVALYM getINTERVALYM(String var1) throws SQLException {
        SQLException var2 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
        var2.fillInStackTrace();
        throw var2;
    }

    public NUMBER getNUMBER(int var1) throws SQLException {
        SQLException var2 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
        var2.fillInStackTrace();
        throw var2;
    }

    public NUMBER getNUMBER(String var1) throws SQLException {
        SQLException var2 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
        var2.fillInStackTrace();
        throw var2;
    }

    public OPAQUE getOPAQUE(int var1) throws SQLException {
        SQLException var2 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
        var2.fillInStackTrace();
        throw var2;
    }

    public OPAQUE getOPAQUE(String var1) throws SQLException {
        SQLException var2 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
        var2.fillInStackTrace();
        throw var2;
    }

    public Datum getOracleObject(int var1) throws SQLException {
        SQLException var2 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
        var2.fillInStackTrace();
        throw var2;
    }

    public Datum getOracleObject(String var1) throws SQLException {
        SQLException var2 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
        var2.fillInStackTrace();
        throw var2;
    }

    public ORAData getORAData(int var1, ORADataFactory var2) throws SQLException {
        SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
        var3.fillInStackTrace();
        throw var3;
    }

    public ORAData getORAData(String var1, ORADataFactory var2) throws SQLException {
        SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
        var3.fillInStackTrace();
        throw var3;
    }

    public Object getObject(int var1, OracleDataFactory var2) throws SQLException {
        SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
        var3.fillInStackTrace();
        throw var3;
    }

    public Object getObject(String var1, OracleDataFactory var2) throws SQLException {
        SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
        var3.fillInStackTrace();
        throw var3;
    }

    public RAW getRAW(int var1) throws SQLException {
        SQLException var2 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
        var2.fillInStackTrace();
        throw var2;
    }

    public RAW getRAW(String var1) throws SQLException {
        SQLException var2 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
        var2.fillInStackTrace();
        throw var2;
    }

    public REF getREF(int var1) throws SQLException {
        SQLException var2 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
        var2.fillInStackTrace();
        throw var2;
    }

    public REF getREF(String var1) throws SQLException {
        SQLException var2 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
        var2.fillInStackTrace();
        throw var2;
    }

    public ROWID getROWID(int var1) throws SQLException {
        SQLException var2 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
        var2.fillInStackTrace();
        throw var2;
    }

    public ROWID getROWID(String var1) throws SQLException {
        SQLException var2 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
        var2.fillInStackTrace();
        throw var2;
    }

    public STRUCT getSTRUCT(int var1) throws SQLException {
        SQLException var2 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
        var2.fillInStackTrace();
        throw var2;
    }

    public STRUCT getSTRUCT(String var1) throws SQLException {
        SQLException var2 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
        var2.fillInStackTrace();
        throw var2;
    }

    public TIMESTAMPLTZ getTIMESTAMPLTZ(int var1) throws SQLException {
        SQLException var2 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
        var2.fillInStackTrace();
        throw var2;
    }

    public TIMESTAMPLTZ getTIMESTAMPLTZ(String var1) throws SQLException {
        SQLException var2 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
        var2.fillInStackTrace();
        throw var2;
    }

    public TIMESTAMPTZ getTIMESTAMPTZ(int var1) throws SQLException {
        SQLException var2 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
        var2.fillInStackTrace();
        throw var2;
    }

    public TIMESTAMPTZ getTIMESTAMPTZ(String var1) throws SQLException {
        SQLException var2 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
        var2.fillInStackTrace();
        throw var2;
    }

    public TIMESTAMP getTIMESTAMP(int var1) throws SQLException {
        SQLException var2 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
        var2.fillInStackTrace();
        throw var2;
    }

    public TIMESTAMP getTIMESTAMP(String var1) throws SQLException {
        SQLException var2 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
        var2.fillInStackTrace();
        throw var2;
    }

    public CustomDatum getCustomDatum(int var1, CustomDatumFactory var2) throws SQLException {
        SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
        var3.fillInStackTrace();
        throw var3;
    }

    public CustomDatum getCustomDatum(String var1, CustomDatumFactory var2) throws SQLException {
        SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
        var3.fillInStackTrace();
        throw var3;
    }

    public InputStream getAsciiStream(int var1) throws SQLException {
        SQLException var2 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
        var2.fillInStackTrace();
        throw var2;
    }

    public InputStream getAsciiStream(String var1) throws SQLException {
        SQLException var2 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
        var2.fillInStackTrace();
        throw var2;
    }

    public InputStream getBinaryStream(int var1) throws SQLException {
        SQLException var2 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
        var2.fillInStackTrace();
        throw var2;
    }

    public InputStream getBinaryStream(String var1) throws SQLException {
        SQLException var2 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
        var2.fillInStackTrace();
        throw var2;
    }

    public Reader getCharacterStream(int var1) throws SQLException {
        SQLException var2 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
        var2.fillInStackTrace();
        throw var2;
    }

    public Reader getCharacterStream(String var1) throws SQLException {
        SQLException var2 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
        var2.fillInStackTrace();
        throw var2;
    }

    public Reader getNCharacterStream(int var1) throws SQLException {
        SQLException var2 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
        var2.fillInStackTrace();
        throw var2;
    }

    public Reader getNCharacterStream(String var1) throws SQLException {
        SQLException var2 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
        var2.fillInStackTrace();
        throw var2;
    }

    public InputStream getUnicodeStream(int var1) throws SQLException {
        SQLException var2 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
        var2.fillInStackTrace();
        throw var2;
    }

    public InputStream getUnicodeStream(String var1) throws SQLException {
        SQLException var2 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
        var2.fillInStackTrace();
        throw var2;
    }

    public void setNull(int var1, int var2) throws SQLException {
        SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
        var3.fillInStackTrace();
        throw var3;
    }

    public void setNull(String var1, int var2) throws SQLException {
        SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
        var3.fillInStackTrace();
        throw var3;
    }

    public void setNull(int var1, int var2, String var3) throws SQLException {
        SQLException var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
        var4.fillInStackTrace();
        throw var4;
    }

    public void setNull(String var1, int var2, String var3) throws SQLException {
        SQLException var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
        var4.fillInStackTrace();
        throw var4;
    }

    public void setNullAtName(String var1, int var2) throws SQLException {
        SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
        var3.fillInStackTrace();
        throw var3;
    }

    public void setNullAtName(String var1, int var2, String var3) throws SQLException {
        SQLException var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
        var4.fillInStackTrace();
        throw var4;
    }

    public void setObject(int var1, Object var2, int var3, int var4) throws SQLException {
        SQLException var5 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
        var5.fillInStackTrace();
        throw var5;
    }

    public void setObject(String var1, Object var2, int var3, int var4) throws SQLException {
        SQLException var5 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
        var5.fillInStackTrace();
        throw var5;
    }

    public void setObjectAtName(String var1, Object var2, int var3, int var4) throws SQLException {
        SQLException var5 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
        var5.fillInStackTrace();
        throw var5;
    }

    public int getFetchDirection() throws SQLException {
        SQLException var1 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
        var1.fillInStackTrace();
        throw var1;
    }

    public int getFetchSize() throws SQLException {
        SQLException var1 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
        var1.fillInStackTrace();
        throw var1;
    }

    public int getMaxFieldSize() throws SQLException {
        SQLException var1 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
        var1.fillInStackTrace();
        throw var1;
    }

    public int getMaxRows() throws SQLException {
        SQLException var1 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
        var1.fillInStackTrace();
        throw var1;
    }

    public int getQueryTimeout() throws SQLException {
        SQLException var1 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
        var1.fillInStackTrace();
        throw var1;
    }

    public int getResultSetConcurrency() throws SQLException {
        SQLException var1 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
        var1.fillInStackTrace();
        throw var1;
    }

    public int getResultSetHoldability() throws SQLException {
        SQLException var1 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
        var1.fillInStackTrace();
        throw var1;
    }

    public int getResultSetType() throws SQLException {
        SQLException var1 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
        var1.fillInStackTrace();
        throw var1;
    }

    public int getUpdateCount() throws SQLException {
        SQLException var1 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
        var1.fillInStackTrace();
        throw var1;
    }

    public void cancel() throws SQLException {
        SQLException var1 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
        var1.fillInStackTrace();
        throw var1;
    }

    public void clearBatch() throws SQLException {
        SQLException var1 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
        var1.fillInStackTrace();
        throw var1;
    }

    public void clearWarnings() throws SQLException {
        SQLException var1 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
        var1.fillInStackTrace();
        throw var1;
    }

    public void close() throws SQLException {
    }

    public boolean getMoreResults() throws SQLException {
        SQLException var1 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
        var1.fillInStackTrace();
        throw var1;
    }

    public int[] executeBatch() throws SQLException {
        SQLException var1 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
        var1.fillInStackTrace();
        throw var1;
    }

    public void setFetchDirection(int var1) throws SQLException {
        SQLException var2 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
        var2.fillInStackTrace();
        throw var2;
    }

    public void setFetchSize(int var1) throws SQLException {
        SQLException var2 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
        var2.fillInStackTrace();
        throw var2;
    }

    public void setMaxFieldSize(int var1) throws SQLException {
        SQLException var2 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
        var2.fillInStackTrace();
        throw var2;
    }

    public void setMaxRows(int var1) throws SQLException {
        SQLException var2 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
        var2.fillInStackTrace();
        throw var2;
    }

    public void setQueryTimeout(int var1) throws SQLException {
        SQLException var2 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
        var2.fillInStackTrace();
        throw var2;
    }

    public boolean getMoreResults(int var1) throws SQLException {
        SQLException var2 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
        var2.fillInStackTrace();
        throw var2;
    }

    public void setEscapeProcessing(boolean var1) throws SQLException {
        SQLException var2 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
        var2.fillInStackTrace();
        throw var2;
    }

    public int executeUpdate(String var1) throws SQLException {
        SQLException var2 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
        var2.fillInStackTrace();
        throw var2;
    }

    public void addBatch(String var1) throws SQLException {
        SQLException var2 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
        var2.fillInStackTrace();
        throw var2;
    }

    public void setCursorName(String var1) throws SQLException {
        SQLException var2 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
        var2.fillInStackTrace();
        throw var2;
    }

    public boolean execute(String var1) throws SQLException {
        SQLException var2 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
        var2.fillInStackTrace();
        throw var2;
    }

    public int executeUpdate(String var1, int var2) throws SQLException {
        SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
        var3.fillInStackTrace();
        throw var3;
    }

    public boolean execute(String var1, int var2) throws SQLException {
        SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
        var3.fillInStackTrace();
        throw var3;
    }

    public int executeUpdate(String var1, int[] var2) throws SQLException {
        SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
        var3.fillInStackTrace();
        throw var3;
    }

    public boolean execute(String var1, int[] var2) throws SQLException {
        SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
        var3.fillInStackTrace();
        throw var3;
    }

    public Connection getConnection() throws SQLException {
        SQLException var1 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
        var1.fillInStackTrace();
        throw var1;
    }

    public ResultSet getGeneratedKeys() throws SQLException {
        SQLException var1 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
        var1.fillInStackTrace();
        throw var1;
    }

    public ResultSet getResultSet() throws SQLException {
        SQLException var1 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
        var1.fillInStackTrace();
        throw var1;
    }

    public SQLWarning getWarnings() throws SQLException {
        SQLException var1 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
        var1.fillInStackTrace();
        throw var1;
    }

    public int executeUpdate(String var1, String[] var2) throws SQLException {
        SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
        var3.fillInStackTrace();
        throw var3;
    }

    public boolean execute(String var1, String[] var2) throws SQLException {
        SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
        var3.fillInStackTrace();
        throw var3;
    }

    public ResultSet executeQuery(String var1) throws SQLException {
        SQLException var2 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
        var2.fillInStackTrace();
        throw var2;
    }

    public void clearDefines() throws SQLException {
        SQLException var1 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
        var1.fillInStackTrace();
        throw var1;
    }

    public void defineColumnType(int var1, int var2) throws SQLException {
        SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
        var3.fillInStackTrace();
        throw var3;
    }

    public void defineColumnType(int var1, int var2, int var3) throws SQLException {
        SQLException var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
        var4.fillInStackTrace();
        throw var4;
    }

    public void defineColumnType(int var1, int var2, int var3, short var4) throws SQLException {
        SQLException var5 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
        var5.fillInStackTrace();
        throw var5;
    }

    public void defineColumnTypeBytes(int var1, int var2, int var3) throws SQLException {
        SQLException var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
        var4.fillInStackTrace();
        throw var4;
    }

    public void defineColumnTypeChars(int var1, int var2, int var3) throws SQLException {
        SQLException var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
        var4.fillInStackTrace();
        throw var4;
    }

    public void defineColumnType(int var1, int var2, String var3) throws SQLException {
        SQLException var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
        var4.fillInStackTrace();
        throw var4;
    }

    public int getRowPrefetch() {
        return -1;
    }

    public void setRowPrefetch(int var1) throws SQLException {
        SQLException var2 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
        var2.fillInStackTrace();
        throw var2;
    }

    public int getLobPrefetchSize() throws SQLException {
        SQLException var1 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
        var1.fillInStackTrace();
        throw var1;
    }

    public void setLobPrefetchSize(int var1) throws SQLException {
        SQLException var2 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
        var2.fillInStackTrace();
        throw var2;
    }

    public void closeWithKey(String var1) throws SQLException {
        SQLException var2 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
        var2.fillInStackTrace();
        throw var2;
    }

    public int creationState() {
        return -1;
    }

    public boolean isNCHAR(int var1) throws SQLException {
        SQLException var2 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
        var2.fillInStackTrace();
        throw var2;
    }

    public int executeUpdate() throws SQLException {
        SQLException var1 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
        var1.fillInStackTrace();
        throw var1;
    }

    public void addBatch() throws SQLException {
        SQLException var1 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
        var1.fillInStackTrace();
        throw var1;
    }

    public void clearParameters() throws SQLException {
        SQLException var1 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
        var1.fillInStackTrace();
        throw var1;
    }

    public boolean execute() throws SQLException {
        SQLException var1 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
        var1.fillInStackTrace();
        throw var1;
    }

    public ParameterMetaData getParameterMetaData() throws SQLException {
        SQLException var1 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
        var1.fillInStackTrace();
        throw var1;
    }

    public ResultSet executeQuery() throws SQLException {
        SQLException var1 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
        var1.fillInStackTrace();
        throw var1;
    }

    public ResultSetMetaData getMetaData() throws SQLException {
        SQLException var1 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
        var1.fillInStackTrace();
        throw var1;
    }

    public ResultSet getReturnResultSet() throws SQLException {
        SQLException var1 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
        var1.fillInStackTrace();
        throw var1;
    }

    public void defineParameterTypeBytes(int var1, int var2, int var3) throws SQLException {
        SQLException var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
        var4.fillInStackTrace();
        throw var4;
    }

    public void defineParameterTypeChars(int var1, int var2, int var3) throws SQLException {
        SQLException var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
        var4.fillInStackTrace();
        throw var4;
    }

    public void defineParameterType(int var1, int var2, int var3) throws SQLException {
        SQLException var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
        var4.fillInStackTrace();
        throw var4;
    }

    public int getExecuteBatch() {
        return -1;
    }

    public int sendBatch() throws SQLException {
        SQLException var1 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
        var1.fillInStackTrace();
        throw var1;
    }

    public void setExecuteBatch(int var1) throws SQLException {
        SQLException var2 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
        var2.fillInStackTrace();
        throw var2;
    }

    public void setPlsqlIndexTable(int var1, Object var2, int var3, int var4, int var5, int var6) throws SQLException {
        SQLException var7 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
        var7.fillInStackTrace();
        throw var7;
    }

    public void setFormOfUse(int var1, short var2) {
    }

    public void setDisableStmtCaching(boolean var1) {
    }

    public OracleParameterMetaData OracleGetParameterMetaData() throws SQLException {
        SQLException var1 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
        var1.fillInStackTrace();
        throw var1;
    }

    public void registerReturnParameter(int var1, int var2) throws SQLException {
        SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
        var3.fillInStackTrace();
        throw var3;
    }

    public void registerReturnParameter(int var1, int var2, int var3) throws SQLException {
        SQLException var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
        var4.fillInStackTrace();
        throw var4;
    }

    public void registerReturnParameter(int var1, int var2, String var3) throws SQLException {
        SQLException var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
        var4.fillInStackTrace();
        throw var4;
    }

    public void setBytesForBlob(int var1, byte[] var2) throws SQLException {
        SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
        var3.fillInStackTrace();
        throw var3;
    }

    public void setBytesForBlobAtName(String var1, byte[] var2) throws SQLException {
        SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
        var3.fillInStackTrace();
        throw var3;
    }

    public void setStringForClob(int var1, String var2) throws SQLException {
        SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
        var3.fillInStackTrace();
        throw var3;
    }

    public void setStringForClobAtName(String var1, String var2) throws SQLException {
        SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
        var3.fillInStackTrace();
        throw var3;
    }

    public void setStructDescriptor(int var1, StructDescriptor var2) throws SQLException {
        SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
        var3.fillInStackTrace();
        throw var3;
    }

    public void setStructDescriptor(String var1, StructDescriptor var2) throws SQLException {
        SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
        var3.fillInStackTrace();
        throw var3;
    }

    public void setStructDescriptorAtName(String var1, StructDescriptor var2) throws SQLException {
        SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
        var3.fillInStackTrace();
        throw var3;
    }

    public Object getAnyDataEmbeddedObject(int var1) throws SQLException {
        SQLException var2 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
        var2.fillInStackTrace();
        throw var2;
    }

    public void registerOutParameter(int var1, int var2, int var3, int var4) throws SQLException {
        SQLException var5 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
        var5.fillInStackTrace();
        throw var5;
    }

    public void registerOutParameter(int var1, int var2, String var3) throws SQLException {
        SQLException var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
        var4.fillInStackTrace();
        throw var4;
    }

    public void registerOutParameter(int var1, int var2, int var3) throws SQLException {
        SQLException var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
        var4.fillInStackTrace();
        throw var4;
    }

    public void registerOutParameter(int var1, int var2) throws SQLException {
        SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
        var3.fillInStackTrace();
        throw var3;
    }

    public void registerOutParameterBytes(int var1, int var2, int var3, int var4) throws SQLException {
        SQLException var5 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
        var5.fillInStackTrace();
        throw var5;
    }

    public void registerOutParameterChars(int var1, int var2, int var3, int var4) throws SQLException {
        SQLException var5 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
        var5.fillInStackTrace();
        throw var5;
    }

    public Object getPlsqlIndexTable(int var1) throws SQLException {
        SQLException var2 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
        var2.fillInStackTrace();
        throw var2;
    }

    public Object getPlsqlIndexTable(int var1, Class var2) throws SQLException {
        SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
        var3.fillInStackTrace();
        throw var3;
    }

    public Datum[] getOraclePlsqlIndexTable(int var1) throws SQLException {
        SQLException var2 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
        var2.fillInStackTrace();
        throw var2;
    }

    public void registerIndexTableOutParameter(int var1, int var2, int var3, int var4) throws SQLException {
        SQLException var5 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
        var5.fillInStackTrace();
        throw var5;
    }

    public void setStringForClob(String var1, String var2) throws SQLException {
        SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
        var3.fillInStackTrace();
        throw var3;
    }

    public void setBytesForBlob(String var1, byte[] var2) throws SQLException {
        SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
        var3.fillInStackTrace();
        throw var3;
    }

    public void registerOutParameter(String var1, int var2, int var3, int var4) throws SQLException {
        SQLException var5 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
        var5.fillInStackTrace();
        throw var5;
    }

    public boolean wasNull() throws SQLException {
        SQLException var1 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
        var1.fillInStackTrace();
        throw var1;
    }

    public void registerOutParameter(String var1, int var2) throws SQLException {
        SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
        var3.fillInStackTrace();
        throw var3;
    }

    public void registerOutParameter(String var1, int var2, int var3) throws SQLException {
        SQLException var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
        var4.fillInStackTrace();
        throw var4;
    }

    public void registerOutParameter(String var1, int var2, String var3) throws SQLException {
        SQLException var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
        var4.fillInStackTrace();
        throw var4;
    }

    public void registerOutParameterAtName(String var1, int var2) throws SQLException {
        SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
        var3.fillInStackTrace();
        throw var3;
    }

    public void registerOutParameterAtName(String var1, int var2, int var3) throws SQLException {
        SQLException var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
        var4.fillInStackTrace();
        throw var4;
    }

    public void registerOutParameterAtName(String var1, int var2, String var3) throws SQLException {
        SQLException var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
        var4.fillInStackTrace();
        throw var4;
    }

    public byte[] privateGetBytes(int var1) throws SQLException {
        SQLException var2 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
        var2.fillInStackTrace();
        throw var2;
    }

    public void setDatabaseChangeRegistration(DatabaseChangeRegistration var1) throws SQLException {
        SQLException var2 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
        var2.fillInStackTrace();
        throw var2;
    }

    public boolean isClosed() throws SQLException {
        return true;
    }

    public boolean isPoolable() throws SQLException {
        return false;
    }

    public void setPoolable(boolean var1) throws SQLException {
        SQLException var2 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
        var2.fillInStackTrace();
        throw var2;
    }

    public boolean isWrapperFor(Class<?> var1) throws SQLException {
        if (var1.isInterface()) {
            return var1.isInstance(this);
        } else {
            SQLException var2 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 177);
            var2.fillInStackTrace();
            throw var2;
        }
    }

    public <T> T unwrap(Class<T> var1) throws SQLException {
        if (var1.isInterface() && var1.isInstance(this)) {
            return (T) this;
        } else {
            SQLException var2 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 177);
            var2.fillInStackTrace();
            throw var2;
        }
    }

    public <T> T getObject(int var1, Class<T> var2) throws SQLException {
        SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
        var3.fillInStackTrace();
        throw var3;
    }

    public <T> T getObject(String var1, Class<T> var2) throws SQLException {
        SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
        var3.fillInStackTrace();
        throw var3;
    }

    public boolean isCloseOnCompletion() throws SQLException {
        SQLException var1 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
        var1.fillInStackTrace();
        throw var1;
    }

    public void closeOnCompletion() throws SQLException {
        SQLException var1 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
        var1.fillInStackTrace();
        throw var1;
    }

    public void setFixedString(boolean var1) {
    }

    public boolean getFixedString() {
        return false;
    }

    public boolean getserverCursor() {
        return false;
    }

    public int getcacheState() {
        return 0;
    }

    public int getstatementType() {
        return 3;
    }

    public void setCheckBindTypes(boolean var1) {
    }

    public void setInternalBytes(int var1, byte[] var2, int var3) throws SQLException {
        SQLException var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
        var4.fillInStackTrace();
        throw var4;
    }

    public void enterImplicitCache() throws SQLException {
        SQLException var1 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
        var1.fillInStackTrace();
        throw var1;
    }

    public void enterExplicitCache() throws SQLException {
        SQLException var1 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
        var1.fillInStackTrace();
        throw var1;
    }

    public void exitImplicitCacheToActive() throws SQLException {
        SQLException var1 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
        var1.fillInStackTrace();
        throw var1;
    }

    public void exitExplicitCacheToActive() throws SQLException {
        SQLException var1 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
        var1.fillInStackTrace();
        throw var1;
    }

    public void exitImplicitCacheToClose() throws SQLException {
        SQLException var1 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
        var1.fillInStackTrace();
        throw var1;
    }

    public void exitExplicitCacheToClose() throws SQLException {
        SQLException var1 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
        var1.fillInStackTrace();
        throw var1;
    }

    public String[] getRegisteredTableNames() throws SQLException {
        return null;
    }

    public long getRegisteredQueryId() throws SQLException {
        return -1L;
    }

    public String getOriginalSql() throws SQLException {
        SQLException var1 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
        var1.fillInStackTrace();
        throw var1;
    }

    public void setSnapshotSCN(long var1) throws SQLException {
        SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
        var3.fillInStackTrace();
        throw var3;
    }

    protected OracleConnection getConnectionDuringExceptionHandling() {
        return null;
    }

    public SqlKind getSqlKind() throws SQLException {
        SQLException var1 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
        var1.fillInStackTrace();
        throw var1;
    }

    public long getChecksum() throws SQLException {
        SQLException var1 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
        var1.fillInStackTrace();
        throw var1;
    }

    public void registerBindChecksumListener(BindChecksumListener var1) throws SQLException {
        SQLException var2 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
        var2.fillInStackTrace();
        throw var2;
    }

    public void setACProxy(Object var1) {
        this.acProxy = var1;
    }

    public Object getACProxy() {
        return this.acProxy;
    }
}
