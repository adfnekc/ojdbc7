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
import java.sql.Date;
import java.sql.NClob;
import java.sql.Ref;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.RowId;
import java.sql.SQLException;
import java.sql.SQLWarning;
import java.sql.SQLXML;
import java.sql.Statement;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Map;
import oracle.jdbc.OracleDataFactory;
import oracle.jdbc.internal.OracleConnection;
import oracle.jdbc.internal.OracleResultSet;
import oracle.sql.ARRAY;
import oracle.sql.BFILE;
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

abstract class GeneratedResultSet implements OracleResultSet {
    protected PhysicalConnection connection;
    protected Object acProxy;
    private static final String _Copyright_2007_Oracle_All_Rights_Reserved_ = null;
    public static final String BUILD_DATE = "Thu_Apr_04_15:09:24_PDT_2013";
    public static final boolean TRACE = false;

    public abstract boolean absolute(int var1) throws SQLException;

    public abstract void afterLast() throws SQLException;

    public abstract void beforeFirst() throws SQLException;

    public abstract void cancelRowUpdates() throws SQLException;

    public abstract void clearWarnings() throws SQLException;

    public abstract void deleteRow() throws SQLException;

    public abstract boolean first() throws SQLException;

    public abstract int getConcurrency() throws SQLException;

    public abstract String getCursorName() throws SQLException;

    public abstract int getFetchDirection() throws SQLException;

    public abstract int getFetchSize() throws SQLException;

    public abstract int getHoldability() throws SQLException;

    public abstract ResultSetMetaData getMetaData() throws SQLException;

    public abstract int getRow() throws SQLException;

    public abstract Statement getStatement() throws SQLException;

    public abstract int getType() throws SQLException;

    public abstract SQLWarning getWarnings() throws SQLException;

    public abstract void insertRow() throws SQLException;

    public abstract boolean isAfterLast() throws SQLException;

    public abstract boolean isBeforeFirst() throws SQLException;

    public abstract boolean isClosed() throws SQLException;

    public abstract boolean isFirst() throws SQLException;

    public abstract boolean isLast() throws SQLException;

    public abstract boolean last() throws SQLException;

    public abstract void moveToCurrentRow() throws SQLException;

    public abstract void moveToInsertRow() throws SQLException;

    public abstract boolean next() throws SQLException;

    public abstract boolean previous() throws SQLException;

    public abstract void refreshRow() throws SQLException;

    public abstract boolean relative(int var1) throws SQLException;

    public abstract boolean rowDeleted() throws SQLException;

    public abstract boolean rowInserted() throws SQLException;

    public abstract boolean rowUpdated() throws SQLException;

    public abstract void setFetchDirection(int var1) throws SQLException;

    public abstract void setFetchSize(int var1) throws SQLException;

    public abstract void updateRow() throws SQLException;

    public abstract boolean wasNull() throws SQLException;

    protected GeneratedResultSet(PhysicalConnection var1) {
        this.connection = var1;
    }

    public void close() throws SQLException {
        this.connection = null;
    }

    public abstract int findColumn(String var1) throws SQLException;

    public abstract Array getArray(int var1) throws SQLException;

    public abstract BigDecimal getBigDecimal(int var1) throws SQLException;

    public abstract BigDecimal getBigDecimal(int var1, int var2) throws SQLException;

    public abstract Blob getBlob(int var1) throws SQLException;

    public abstract boolean getBoolean(int var1) throws SQLException;

    public abstract byte getByte(int var1) throws SQLException;

    public abstract byte[] getBytes(int var1) throws SQLException;

    public abstract Clob getClob(int var1) throws SQLException;

    public abstract Date getDate(int var1) throws SQLException;

    public abstract Date getDate(int var1, Calendar var2) throws SQLException;

    public abstract double getDouble(int var1) throws SQLException;

    public abstract float getFloat(int var1) throws SQLException;

    public abstract int getInt(int var1) throws SQLException;

    public abstract long getLong(int var1) throws SQLException;

    public abstract NClob getNClob(int var1) throws SQLException;

    public abstract String getNString(int var1) throws SQLException;

    public abstract Object getObject(int var1) throws SQLException;

    public abstract Object getObject(int var1, Map var2) throws SQLException;

    public abstract Ref getRef(int var1) throws SQLException;

    public abstract RowId getRowId(int var1) throws SQLException;

    public abstract short getShort(int var1) throws SQLException;

    public abstract SQLXML getSQLXML(int var1) throws SQLException;

    public abstract String getString(int var1) throws SQLException;

    public abstract Time getTime(int var1) throws SQLException;

    public abstract Time getTime(int var1, Calendar var2) throws SQLException;

    public abstract Timestamp getTimestamp(int var1) throws SQLException;

    public abstract Timestamp getTimestamp(int var1, Calendar var2) throws SQLException;

    public abstract URL getURL(int var1) throws SQLException;

    public abstract ARRAY getARRAY(int var1) throws SQLException;

    public abstract BFILE getBFILE(int var1) throws SQLException;

    public abstract BFILE getBfile(int var1) throws SQLException;

    public abstract BLOB getBLOB(int var1) throws SQLException;

    public abstract CHAR getCHAR(int var1) throws SQLException;

    public abstract CLOB getCLOB(int var1) throws SQLException;

    public abstract ResultSet getCursor(int var1) throws SQLException;

    public abstract DATE getDATE(int var1) throws SQLException;

    public abstract INTERVALDS getINTERVALDS(int var1) throws SQLException;

    public abstract INTERVALYM getINTERVALYM(int var1) throws SQLException;

    public abstract NUMBER getNUMBER(int var1) throws SQLException;

    public abstract OPAQUE getOPAQUE(int var1) throws SQLException;

    public abstract Datum getOracleObject(int var1) throws SQLException;

    public abstract ORAData getORAData(int var1, ORADataFactory var2) throws SQLException;

    public abstract Object getObject(int var1, OracleDataFactory var2) throws SQLException;

    public abstract RAW getRAW(int var1) throws SQLException;

    public abstract REF getREF(int var1) throws SQLException;

    public abstract ROWID getROWID(int var1) throws SQLException;

    public abstract STRUCT getSTRUCT(int var1) throws SQLException;

    public abstract TIMESTAMPLTZ getTIMESTAMPLTZ(int var1) throws SQLException;

    public abstract TIMESTAMPTZ getTIMESTAMPTZ(int var1) throws SQLException;

    public abstract TIMESTAMP getTIMESTAMP(int var1) throws SQLException;

    public abstract CustomDatum getCustomDatum(int var1, CustomDatumFactory var2) throws SQLException;

    public abstract InputStream getAsciiStream(int var1) throws SQLException;

    public abstract InputStream getBinaryStream(int var1) throws SQLException;

    public abstract Reader getCharacterStream(int var1) throws SQLException;

    public abstract Reader getNCharacterStream(int var1) throws SQLException;

    public abstract InputStream getUnicodeStream(int var1) throws SQLException;

    public void updateArray(int var1, Array var2) throws SQLException {
        SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 76, "updateArray");
        var3.fillInStackTrace();
        throw var3;
    }

    public void updateBigDecimal(int var1, BigDecimal var2) throws SQLException {
        SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 76, "updateBigDecimal");
        var3.fillInStackTrace();
        throw var3;
    }

    public void updateBlob(int var1, Blob var2) throws SQLException {
        SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 76, "updateBlob");
        var3.fillInStackTrace();
        throw var3;
    }

    public void updateBoolean(int var1, boolean var2) throws SQLException {
        SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 76, "updateBoolean");
        var3.fillInStackTrace();
        throw var3;
    }

    public void updateByte(int var1, byte var2) throws SQLException {
        SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 76, "updateByte");
        var3.fillInStackTrace();
        throw var3;
    }

    public void updateBytes(int var1, byte[] var2) throws SQLException {
        SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 76, "updateBytes");
        var3.fillInStackTrace();
        throw var3;
    }

    public void updateClob(int var1, Clob var2) throws SQLException {
        SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 76, "updateClob");
        var3.fillInStackTrace();
        throw var3;
    }

    public void updateDate(int var1, Date var2) throws SQLException {
        SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 76, "updateDate");
        var3.fillInStackTrace();
        throw var3;
    }

    public void updateDate(int var1, Date var2, Calendar var3) throws SQLException {
        SQLException var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 76, "updateDate");
        var4.fillInStackTrace();
        throw var4;
    }

    public void updateDouble(int var1, double var2) throws SQLException {
        SQLException var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 76, "updateDouble");
        var4.fillInStackTrace();
        throw var4;
    }

    public void updateFloat(int var1, float var2) throws SQLException {
        SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 76, "updateFloat");
        var3.fillInStackTrace();
        throw var3;
    }

    public void updateInt(int var1, int var2) throws SQLException {
        SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 76, "updateInt");
        var3.fillInStackTrace();
        throw var3;
    }

    public void updateLong(int var1, long var2) throws SQLException {
        SQLException var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 76, "updateLong");
        var4.fillInStackTrace();
        throw var4;
    }

    public void updateNClob(int var1, NClob var2) throws SQLException {
        SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 76, "updateNClob");
        var3.fillInStackTrace();
        throw var3;
    }

    public void updateNString(int var1, String var2) throws SQLException {
        SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 76, "updateNString");
        var3.fillInStackTrace();
        throw var3;
    }

    public void updateObject(int var1, Object var2) throws SQLException {
        SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 76, "updateObject");
        var3.fillInStackTrace();
        throw var3;
    }

    public void updateObject(int var1, Object var2, int var3) throws SQLException {
        SQLException var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 76, "updateObject");
        var4.fillInStackTrace();
        throw var4;
    }

    public void updateRef(int var1, Ref var2) throws SQLException {
        SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 76, "updateRef");
        var3.fillInStackTrace();
        throw var3;
    }

    public void updateRowId(int var1, RowId var2) throws SQLException {
        SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 76, "updateRowId");
        var3.fillInStackTrace();
        throw var3;
    }

    public void updateShort(int var1, short var2) throws SQLException {
        SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 76, "updateShort");
        var3.fillInStackTrace();
        throw var3;
    }

    public void updateSQLXML(int var1, SQLXML var2) throws SQLException {
        SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 76, "updateSQLXML");
        var3.fillInStackTrace();
        throw var3;
    }

    public void updateString(int var1, String var2) throws SQLException {
        SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 76, "updateString");
        var3.fillInStackTrace();
        throw var3;
    }

    public void updateTime(int var1, Time var2) throws SQLException {
        SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 76, "updateTime");
        var3.fillInStackTrace();
        throw var3;
    }

    public void updateTime(int var1, Time var2, Calendar var3) throws SQLException {
        SQLException var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 76, "updateTime");
        var4.fillInStackTrace();
        throw var4;
    }

    public void updateTimestamp(int var1, Timestamp var2) throws SQLException {
        SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 76, "updateTimestamp");
        var3.fillInStackTrace();
        throw var3;
    }

    public void updateTimestamp(int var1, Timestamp var2, Calendar var3) throws SQLException {
        SQLException var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 76, "updateTimestamp");
        var4.fillInStackTrace();
        throw var4;
    }

    public void updateURL(int var1, URL var2) throws SQLException {
        SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 76, "updateURL");
        var3.fillInStackTrace();
        throw var3;
    }

    public void updateARRAY(int var1, ARRAY var2) throws SQLException {
        SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 76, "updateARRAY");
        var3.fillInStackTrace();
        throw var3;
    }

    public void updateBFILE(int var1, BFILE var2) throws SQLException {
        SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 76, "updateBFILE");
        var3.fillInStackTrace();
        throw var3;
    }

    public void updateBfile(int var1, BFILE var2) throws SQLException {
        SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 76, "updateBfile");
        var3.fillInStackTrace();
        throw var3;
    }

    public void updateBLOB(int var1, BLOB var2) throws SQLException {
        SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 76, "updateBLOB");
        var3.fillInStackTrace();
        throw var3;
    }

    public void updateCHAR(int var1, CHAR var2) throws SQLException {
        SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 76, "updateCHAR");
        var3.fillInStackTrace();
        throw var3;
    }

    public void updateCLOB(int var1, CLOB var2) throws SQLException {
        SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 76, "updateCLOB");
        var3.fillInStackTrace();
        throw var3;
    }

    public void updateDATE(int var1, DATE var2) throws SQLException {
        SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 76, "updateDATE");
        var3.fillInStackTrace();
        throw var3;
    }

    public void updateINTERVALDS(int var1, INTERVALDS var2) throws SQLException {
        SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 76, "updateINTERVALDS");
        var3.fillInStackTrace();
        throw var3;
    }

    public void updateINTERVALYM(int var1, INTERVALYM var2) throws SQLException {
        SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 76, "updateINTERVALYM");
        var3.fillInStackTrace();
        throw var3;
    }

    public void updateNUMBER(int var1, NUMBER var2) throws SQLException {
        SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 76, "updateNUMBER");
        var3.fillInStackTrace();
        throw var3;
    }

    public void updateOracleObject(int var1, Datum var2) throws SQLException {
        SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 76, "updateOracleObject");
        var3.fillInStackTrace();
        throw var3;
    }

    public void updateORAData(int var1, ORAData var2) throws SQLException {
        SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 76, "updateORAData");
        var3.fillInStackTrace();
        throw var3;
    }

    public void updateRAW(int var1, RAW var2) throws SQLException {
        SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 76, "updateRAW");
        var3.fillInStackTrace();
        throw var3;
    }

    public void updateREF(int var1, REF var2) throws SQLException {
        SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 76, "updateREF");
        var3.fillInStackTrace();
        throw var3;
    }

    public void updateROWID(int var1, ROWID var2) throws SQLException {
        SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 76, "updateROWID");
        var3.fillInStackTrace();
        throw var3;
    }

    public void updateSTRUCT(int var1, STRUCT var2) throws SQLException {
        SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 76, "updateSTRUCT");
        var3.fillInStackTrace();
        throw var3;
    }

    public void updateTIMESTAMPLTZ(int var1, TIMESTAMPLTZ var2) throws SQLException {
        SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 76, "updateTIMESTAMPLTZ");
        var3.fillInStackTrace();
        throw var3;
    }

    public void updateTIMESTAMPTZ(int var1, TIMESTAMPTZ var2) throws SQLException {
        SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 76, "updateTIMESTAMPTZ");
        var3.fillInStackTrace();
        throw var3;
    }

    public void updateTIMESTAMP(int var1, TIMESTAMP var2) throws SQLException {
        SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 76, "updateTIMESTAMP");
        var3.fillInStackTrace();
        throw var3;
    }

    public void updateCustomDatum(int var1, CustomDatum var2) throws SQLException {
        SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 76, "updateCustomDatum");
        var3.fillInStackTrace();
        throw var3;
    }

    public void updateBlob(int var1, InputStream var2) throws SQLException {
        SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 76, "updateBlob");
        var3.fillInStackTrace();
        throw var3;
    }

    public void updateBlob(int var1, InputStream var2, long var3) throws SQLException {
        SQLException var5 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 76, "updateBlob");
        var5.fillInStackTrace();
        throw var5;
    }

    public void updateClob(int var1, Reader var2) throws SQLException {
        SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 76, "updateClob");
        var3.fillInStackTrace();
        throw var3;
    }

    public void updateClob(int var1, Reader var2, long var3) throws SQLException {
        SQLException var5 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 76, "updateClob");
        var5.fillInStackTrace();
        throw var5;
    }

    public void updateNClob(int var1, Reader var2) throws SQLException {
        SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 76, "updateNClob");
        var3.fillInStackTrace();
        throw var3;
    }

    public void updateNClob(int var1, Reader var2, long var3) throws SQLException {
        SQLException var5 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 76, "updateNClob");
        var5.fillInStackTrace();
        throw var5;
    }

    public void updateAsciiStream(int var1, InputStream var2) throws SQLException {
        SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 76, "updateAsciiStream");
        var3.fillInStackTrace();
        throw var3;
    }

    public void updateAsciiStream(int var1, InputStream var2, int var3) throws SQLException {
        SQLException var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 76, "updateAsciiStream");
        var4.fillInStackTrace();
        throw var4;
    }

    public void updateAsciiStream(int var1, InputStream var2, long var3) throws SQLException {
        SQLException var5 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 76, "updateAsciiStream");
        var5.fillInStackTrace();
        throw var5;
    }

    public void updateBinaryStream(int var1, InputStream var2) throws SQLException {
        SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 76, "updateBinaryStream");
        var3.fillInStackTrace();
        throw var3;
    }

    public void updateBinaryStream(int var1, InputStream var2, int var3) throws SQLException {
        SQLException var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 76, "updateBinaryStream");
        var4.fillInStackTrace();
        throw var4;
    }

    public void updateBinaryStream(int var1, InputStream var2, long var3) throws SQLException {
        SQLException var5 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 76, "updateBinaryStream");
        var5.fillInStackTrace();
        throw var5;
    }

    public void updateCharacterStream(int var1, Reader var2) throws SQLException {
        SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 76, "updateCharacterStream");
        var3.fillInStackTrace();
        throw var3;
    }

    public void updateCharacterStream(int var1, Reader var2, int var3) throws SQLException {
        SQLException var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 76, "updateCharacterStream");
        var4.fillInStackTrace();
        throw var4;
    }

    public void updateCharacterStream(int var1, Reader var2, long var3) throws SQLException {
        SQLException var5 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 76, "updateCharacterStream");
        var5.fillInStackTrace();
        throw var5;
    }

    public void updateNCharacterStream(int var1, Reader var2) throws SQLException {
        SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 76, "updateNCharacterStream");
        var3.fillInStackTrace();
        throw var3;
    }

    public void updateNCharacterStream(int var1, Reader var2, long var3) throws SQLException {
        SQLException var5 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 76, "updateNCharacterStream");
        var5.fillInStackTrace();
        throw var5;
    }

    public void updateUnicodeStream(int var1, InputStream var2, int var3) throws SQLException {
        SQLException var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 76, "updateUnicodeStream");
        var4.fillInStackTrace();
        throw var4;
    }

    public Array getArray(String var1) throws SQLException {
        return this.getArray(this.findColumn(var1));
    }

    public BigDecimal getBigDecimal(String var1) throws SQLException {
        return this.getBigDecimal(this.findColumn(var1));
    }

    public BigDecimal getBigDecimal(String var1, int var2) throws SQLException {
        return this.getBigDecimal(this.findColumn(var1), var2);
    }

    public Blob getBlob(String var1) throws SQLException {
        return this.getBlob(this.findColumn(var1));
    }

    public boolean getBoolean(String var1) throws SQLException {
        return this.getBoolean(this.findColumn(var1));
    }

    public byte getByte(String var1) throws SQLException {
        return this.getByte(this.findColumn(var1));
    }

    public byte[] getBytes(String var1) throws SQLException {
        return this.getBytes(this.findColumn(var1));
    }

    public Clob getClob(String var1) throws SQLException {
        return this.getClob(this.findColumn(var1));
    }

    public Date getDate(String var1) throws SQLException {
        return this.getDate(this.findColumn(var1));
    }

    public Date getDate(String var1, Calendar var2) throws SQLException {
        return this.getDate(this.findColumn(var1), var2);
    }

    public double getDouble(String var1) throws SQLException {
        return this.getDouble(this.findColumn(var1));
    }

    public float getFloat(String var1) throws SQLException {
        return this.getFloat(this.findColumn(var1));
    }

    public int getInt(String var1) throws SQLException {
        return this.getInt(this.findColumn(var1));
    }

    public long getLong(String var1) throws SQLException {
        return this.getLong(this.findColumn(var1));
    }

    public NClob getNClob(String var1) throws SQLException {
        return this.getNClob(this.findColumn(var1));
    }

    public String getNString(String var1) throws SQLException {
        return this.getNString(this.findColumn(var1));
    }

    public Object getObject(String var1) throws SQLException {
        return this.getObject(this.findColumn(var1));
    }

    public Object getObject(String var1, Map var2) throws SQLException {
        return this.getObject(this.findColumn(var1), var2);
    }

    public Ref getRef(String var1) throws SQLException {
        return this.getRef(this.findColumn(var1));
    }

    public RowId getRowId(String var1) throws SQLException {
        return this.getRowId(this.findColumn(var1));
    }

    public short getShort(String var1) throws SQLException {
        return this.getShort(this.findColumn(var1));
    }

    public SQLXML getSQLXML(String var1) throws SQLException {
        return this.getSQLXML(this.findColumn(var1));
    }

    public String getString(String var1) throws SQLException {
        return this.getString(this.findColumn(var1));
    }

    public Time getTime(String var1) throws SQLException {
        return this.getTime(this.findColumn(var1));
    }

    public Time getTime(String var1, Calendar var2) throws SQLException {
        return this.getTime(this.findColumn(var1), var2);
    }

    public Timestamp getTimestamp(String var1) throws SQLException {
        return this.getTimestamp(this.findColumn(var1));
    }

    public Timestamp getTimestamp(String var1, Calendar var2) throws SQLException {
        return this.getTimestamp(this.findColumn(var1), var2);
    }

    public URL getURL(String var1) throws SQLException {
        return this.getURL(this.findColumn(var1));
    }

    public ARRAY getARRAY(String var1) throws SQLException {
        return this.getARRAY(this.findColumn(var1));
    }

    public BFILE getBFILE(String var1) throws SQLException {
        return this.getBFILE(this.findColumn(var1));
    }

    public BFILE getBfile(String var1) throws SQLException {
        return this.getBfile(this.findColumn(var1));
    }

    public BLOB getBLOB(String var1) throws SQLException {
        return this.getBLOB(this.findColumn(var1));
    }

    public CHAR getCHAR(String var1) throws SQLException {
        return this.getCHAR(this.findColumn(var1));
    }

    public CLOB getCLOB(String var1) throws SQLException {
        return this.getCLOB(this.findColumn(var1));
    }

    public ResultSet getCursor(String var1) throws SQLException {
        return this.getCursor(this.findColumn(var1));
    }

    public DATE getDATE(String var1) throws SQLException {
        return this.getDATE(this.findColumn(var1));
    }

    public INTERVALDS getINTERVALDS(String var1) throws SQLException {
        return this.getINTERVALDS(this.findColumn(var1));
    }

    public INTERVALYM getINTERVALYM(String var1) throws SQLException {
        return this.getINTERVALYM(this.findColumn(var1));
    }

    public NUMBER getNUMBER(String var1) throws SQLException {
        return this.getNUMBER(this.findColumn(var1));
    }

    public OPAQUE getOPAQUE(String var1) throws SQLException {
        return this.getOPAQUE(this.findColumn(var1));
    }

    public Datum getOracleObject(String var1) throws SQLException {
        return this.getOracleObject(this.findColumn(var1));
    }

    public ORAData getORAData(String var1, ORADataFactory var2) throws SQLException {
        return this.getORAData(this.findColumn(var1), var2);
    }

    public Object getObject(String var1, OracleDataFactory var2) throws SQLException {
        return this.getObject(this.findColumn(var1), var2);
    }

    public RAW getRAW(String var1) throws SQLException {
        return this.getRAW(this.findColumn(var1));
    }

    public REF getREF(String var1) throws SQLException {
        return this.getREF(this.findColumn(var1));
    }

    public ROWID getROWID(String var1) throws SQLException {
        return this.getROWID(this.findColumn(var1));
    }

    public STRUCT getSTRUCT(String var1) throws SQLException {
        return this.getSTRUCT(this.findColumn(var1));
    }

    public TIMESTAMPLTZ getTIMESTAMPLTZ(String var1) throws SQLException {
        return this.getTIMESTAMPLTZ(this.findColumn(var1));
    }

    public TIMESTAMPTZ getTIMESTAMPTZ(String var1) throws SQLException {
        return this.getTIMESTAMPTZ(this.findColumn(var1));
    }

    public TIMESTAMP getTIMESTAMP(String var1) throws SQLException {
        return this.getTIMESTAMP(this.findColumn(var1));
    }

    public CustomDatum getCustomDatum(String var1, CustomDatumFactory var2) throws SQLException {
        return this.getCustomDatum(this.findColumn(var1), var2);
    }

    public InputStream getAsciiStream(String var1) throws SQLException {
        return this.getAsciiStream(this.findColumn(var1));
    }

    public InputStream getBinaryStream(String var1) throws SQLException {
        return this.getBinaryStream(this.findColumn(var1));
    }

    public Reader getCharacterStream(String var1) throws SQLException {
        return this.getCharacterStream(this.findColumn(var1));
    }

    public Reader getNCharacterStream(String var1) throws SQLException {
        return this.getNCharacterStream(this.findColumn(var1));
    }

    public InputStream getUnicodeStream(String var1) throws SQLException {
        return this.getUnicodeStream(this.findColumn(var1));
    }

    public void updateArray(String var1, Array var2) throws SQLException {
        this.updateArray(this.findColumn(var1), var2);
    }

    public void updateBigDecimal(String var1, BigDecimal var2) throws SQLException {
        this.updateBigDecimal(this.findColumn(var1), var2);
    }

    public void updateBlob(String var1, Blob var2) throws SQLException {
        this.updateBlob(this.findColumn(var1), var2);
    }

    public void updateBoolean(String var1, boolean var2) throws SQLException {
        this.updateBoolean(this.findColumn(var1), var2);
    }

    public void updateByte(String var1, byte var2) throws SQLException {
        this.updateByte(this.findColumn(var1), var2);
    }

    public void updateBytes(String var1, byte[] var2) throws SQLException {
        this.updateBytes(this.findColumn(var1), var2);
    }

    public void updateClob(String var1, Clob var2) throws SQLException {
        this.updateClob(this.findColumn(var1), var2);
    }

    public void updateDate(String var1, Date var2) throws SQLException {
        this.updateDate(this.findColumn(var1), var2);
    }

    public void updateDate(String var1, Date var2, Calendar var3) throws SQLException {
        this.updateDate(this.findColumn(var1), var2, var3);
    }

    public void updateDouble(String var1, double var2) throws SQLException {
        this.updateDouble(this.findColumn(var1), var2);
    }

    public void updateFloat(String var1, float var2) throws SQLException {
        this.updateFloat(this.findColumn(var1), var2);
    }

    public void updateInt(String var1, int var2) throws SQLException {
        this.updateInt(this.findColumn(var1), var2);
    }

    public void updateLong(String var1, long var2) throws SQLException {
        this.updateLong(this.findColumn(var1), var2);
    }

    public void updateNClob(String var1, NClob var2) throws SQLException {
        this.updateNClob(this.findColumn(var1), var2);
    }

    public void updateNString(String var1, String var2) throws SQLException {
        this.updateNString(this.findColumn(var1), var2);
    }

    public void updateObject(String var1, Object var2) throws SQLException {
        this.updateObject(this.findColumn(var1), var2);
    }

    public void updateObject(String var1, Object var2, int var3) throws SQLException {
        this.updateObject(this.findColumn(var1), var2, var3);
    }

    public void updateRef(String var1, Ref var2) throws SQLException {
        this.updateRef(this.findColumn(var1), var2);
    }

    public void updateRowId(String var1, RowId var2) throws SQLException {
        this.updateRowId(this.findColumn(var1), var2);
    }

    public void updateShort(String var1, short var2) throws SQLException {
        this.updateShort(this.findColumn(var1), var2);
    }

    public void updateSQLXML(String var1, SQLXML var2) throws SQLException {
        this.updateSQLXML(this.findColumn(var1), var2);
    }

    public void updateString(String var1, String var2) throws SQLException {
        this.updateString(this.findColumn(var1), var2);
    }

    public void updateTime(String var1, Time var2) throws SQLException {
        this.updateTime(this.findColumn(var1), var2);
    }

    public void updateTime(String var1, Time var2, Calendar var3) throws SQLException {
        this.updateTime(this.findColumn(var1), var2, var3);
    }

    public void updateTimestamp(String var1, Timestamp var2) throws SQLException {
        this.updateTimestamp(this.findColumn(var1), var2);
    }

    public void updateTimestamp(String var1, Timestamp var2, Calendar var3) throws SQLException {
        this.updateTimestamp(this.findColumn(var1), var2, var3);
    }

    public void updateURL(String var1, URL var2) throws SQLException {
        this.updateURL(this.findColumn(var1), var2);
    }

    public void updateARRAY(String var1, ARRAY var2) throws SQLException {
        this.updateARRAY(this.findColumn(var1), var2);
    }

    public void updateBFILE(String var1, BFILE var2) throws SQLException {
        this.updateBFILE(this.findColumn(var1), var2);
    }

    public void updateBfile(String var1, BFILE var2) throws SQLException {
        this.updateBfile(this.findColumn(var1), var2);
    }

    public void updateBLOB(String var1, BLOB var2) throws SQLException {
        this.updateBLOB(this.findColumn(var1), var2);
    }

    public void updateCHAR(String var1, CHAR var2) throws SQLException {
        this.updateCHAR(this.findColumn(var1), var2);
    }

    public void updateCLOB(String var1, CLOB var2) throws SQLException {
        this.updateCLOB(this.findColumn(var1), var2);
    }

    public void updateDATE(String var1, DATE var2) throws SQLException {
        this.updateDATE(this.findColumn(var1), var2);
    }

    public void updateINTERVALDS(String var1, INTERVALDS var2) throws SQLException {
        this.updateINTERVALDS(this.findColumn(var1), var2);
    }

    public void updateINTERVALYM(String var1, INTERVALYM var2) throws SQLException {
        this.updateINTERVALYM(this.findColumn(var1), var2);
    }

    public void updateNUMBER(String var1, NUMBER var2) throws SQLException {
        this.updateNUMBER(this.findColumn(var1), var2);
    }

    public void updateOracleObject(String var1, Datum var2) throws SQLException {
        this.updateOracleObject(this.findColumn(var1), var2);
    }

    public void updateORAData(String var1, ORAData var2) throws SQLException {
        this.updateORAData(this.findColumn(var1), var2);
    }

    public void updateRAW(String var1, RAW var2) throws SQLException {
        this.updateRAW(this.findColumn(var1), var2);
    }

    public void updateREF(String var1, REF var2) throws SQLException {
        this.updateREF(this.findColumn(var1), var2);
    }

    public void updateROWID(String var1, ROWID var2) throws SQLException {
        this.updateROWID(this.findColumn(var1), var2);
    }

    public void updateSTRUCT(String var1, STRUCT var2) throws SQLException {
        this.updateSTRUCT(this.findColumn(var1), var2);
    }

    public void updateTIMESTAMPLTZ(String var1, TIMESTAMPLTZ var2) throws SQLException {
        this.updateTIMESTAMPLTZ(this.findColumn(var1), var2);
    }

    public void updateTIMESTAMPTZ(String var1, TIMESTAMPTZ var2) throws SQLException {
        this.updateTIMESTAMPTZ(this.findColumn(var1), var2);
    }

    public void updateTIMESTAMP(String var1, TIMESTAMP var2) throws SQLException {
        this.updateTIMESTAMP(this.findColumn(var1), var2);
    }

    public void updateCustomDatum(String var1, CustomDatum var2) throws SQLException {
        this.updateCustomDatum(this.findColumn(var1), var2);
    }

    public void updateBlob(String var1, InputStream var2) throws SQLException {
        this.updateBlob(this.findColumn(var1), var2);
    }

    public void updateBlob(String var1, InputStream var2, long var3) throws SQLException {
        this.updateBlob(this.findColumn(var1), var2, var3);
    }

    public void updateClob(String var1, Reader var2) throws SQLException {
        this.updateClob(this.findColumn(var1), var2);
    }

    public void updateClob(String var1, Reader var2, long var3) throws SQLException {
        this.updateClob(this.findColumn(var1), var2, var3);
    }

    public void updateNClob(String var1, Reader var2) throws SQLException {
        this.updateNClob(this.findColumn(var1), var2);
    }

    public void updateNClob(String var1, Reader var2, long var3) throws SQLException {
        this.updateNClob(this.findColumn(var1), var2, var3);
    }

    public void updateAsciiStream(String var1, InputStream var2) throws SQLException {
        this.updateAsciiStream(this.findColumn(var1), var2);
    }

    public void updateAsciiStream(String var1, InputStream var2, int var3) throws SQLException {
        this.updateAsciiStream(this.findColumn(var1), var2, var3);
    }

    public void updateAsciiStream(String var1, InputStream var2, long var3) throws SQLException {
        this.updateAsciiStream(this.findColumn(var1), var2, var3);
    }

    public void updateBinaryStream(String var1, InputStream var2) throws SQLException {
        this.updateBinaryStream(this.findColumn(var1), var2);
    }

    public void updateBinaryStream(String var1, InputStream var2, int var3) throws SQLException {
        this.updateBinaryStream(this.findColumn(var1), var2, var3);
    }

    public void updateBinaryStream(String var1, InputStream var2, long var3) throws SQLException {
        this.updateBinaryStream(this.findColumn(var1), var2, var3);
    }

    public void updateCharacterStream(String var1, Reader var2) throws SQLException {
        this.updateCharacterStream(this.findColumn(var1), var2);
    }

    public void updateCharacterStream(String var1, Reader var2, int var3) throws SQLException {
        this.updateCharacterStream(this.findColumn(var1), var2, var3);
    }

    public void updateCharacterStream(String var1, Reader var2, long var3) throws SQLException {
        this.updateCharacterStream(this.findColumn(var1), var2, var3);
    }

    public void updateNCharacterStream(String var1, Reader var2) throws SQLException {
        this.updateNCharacterStream(this.findColumn(var1), var2);
    }

    public void updateNCharacterStream(String var1, Reader var2, long var3) throws SQLException {
        this.updateNCharacterStream(this.findColumn(var1), var2, var3);
    }

    public void updateUnicodeStream(String var1, InputStream var2, int var3) throws SQLException {
        this.updateUnicodeStream(this.findColumn(var1), var2, var3);
    }

    protected OracleConnection getConnectionDuringExceptionHandling() {
        return this.connection;
    }

    public void setACProxy(Object var1) {
        this.acProxy = var1;
    }

    public Object getACProxy() {
        return this.acProxy;
    }
}
