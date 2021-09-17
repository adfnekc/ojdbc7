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
import java.sql.ParameterMetaData;
import java.sql.Ref;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.RowId;
import java.sql.SQLException;
import java.sql.SQLXML;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Calendar;
import oracle.jdbc.OracleParameterMetaData;
import oracle.jdbc.internal.OraclePreparedStatement;
import oracle.sql.ARRAY;
import oracle.sql.BFILE;
import oracle.sql.BINARY_DOUBLE;
import oracle.sql.BINARY_FLOAT;
import oracle.sql.BLOB;
import oracle.sql.CHAR;
import oracle.sql.CLOB;
import oracle.sql.CustomDatum;
import oracle.sql.DATE;
import oracle.sql.Datum;
import oracle.sql.INTERVALDS;
import oracle.sql.INTERVALYM;
import oracle.sql.NUMBER;
import oracle.sql.OPAQUE;
import oracle.sql.ORAData;
import oracle.sql.RAW;
import oracle.sql.REF;
import oracle.sql.ROWID;
import oracle.sql.STRUCT;
import oracle.sql.StructDescriptor;
import oracle.sql.TIMESTAMP;
import oracle.sql.TIMESTAMPLTZ;
import oracle.sql.TIMESTAMPTZ;

class OraclePreparedStatementWrapper extends OracleStatementWrapper implements OraclePreparedStatement {
    protected OraclePreparedStatement preparedStatement = null;
    Object acProxy;
    private static final String _Copyright_2007_Oracle_All_Rights_Reserved_ = null;
    public static final String BUILD_DATE = "Thu_Apr_04_15:09:24_PDT_2013";
    public static final boolean TRACE = false;

    OraclePreparedStatementWrapper(oracle.jdbc.OraclePreparedStatement var1) throws SQLException {
        super(var1);
        this.preparedStatement = (OraclePreparedStatement)var1;
    }

    public void close() throws SQLException {
        super.close();
        this.preparedStatement = OracleStatementWrapper.closedStatement;
    }

    void beClosed() throws SQLException {
        this.preparedStatement = closedStatement;
        super.beClosed();
    }

    public void closeWithKey(String var1) throws SQLException {
        this.preparedStatement.closeWithKey(var1);
        this.statement = this.preparedStatement = closedStatement;
    }

    public void setArray(int var1, Array var2) throws SQLException {
        this.preparedStatement.setArray(var1, var2);
    }

    public void setBigDecimal(int var1, BigDecimal var2) throws SQLException {
        this.preparedStatement.setBigDecimal(var1, var2);
    }

    public void setBlob(int var1, Blob var2) throws SQLException {
        this.preparedStatement.setBlob(var1, var2);
    }

    public void setBoolean(int var1, boolean var2) throws SQLException {
        this.preparedStatement.setBoolean(var1, var2);
    }

    public void setByte(int var1, byte var2) throws SQLException {
        this.preparedStatement.setByte(var1, var2);
    }

    public void setBytes(int var1, byte[] var2) throws SQLException {
        this.preparedStatement.setBytes(var1, var2);
    }

    public void setClob(int var1, Clob var2) throws SQLException {
        this.preparedStatement.setClob(var1, var2);
    }

    public void setDate(int var1, Date var2) throws SQLException {
        this.preparedStatement.setDate(var1, var2);
    }

    public void setDate(int var1, Date var2, Calendar var3) throws SQLException {
        this.preparedStatement.setDate(var1, var2, var3);
    }

    public void setDouble(int var1, double var2) throws SQLException {
        this.preparedStatement.setDouble(var1, var2);
    }

    public void setFloat(int var1, float var2) throws SQLException {
        this.preparedStatement.setFloat(var1, var2);
    }

    public void setInt(int var1, int var2) throws SQLException {
        this.preparedStatement.setInt(var1, var2);
    }

    public void setLong(int var1, long var2) throws SQLException {
        this.preparedStatement.setLong(var1, var2);
    }

    public void setNClob(int var1, NClob var2) throws SQLException {
        this.preparedStatement.setNClob(var1, var2);
    }

    public void setNString(int var1, String var2) throws SQLException {
        this.preparedStatement.setNString(var1, var2);
    }

    public void setObject(int var1, Object var2) throws SQLException {
        this.preparedStatement.setObject(var1, var2);
    }

    public void setObject(int var1, Object var2, int var3) throws SQLException {
        this.preparedStatement.setObject(var1, var2, var3);
    }

    public void setRef(int var1, Ref var2) throws SQLException {
        this.preparedStatement.setRef(var1, var2);
    }

    public void setRowId(int var1, RowId var2) throws SQLException {
        this.preparedStatement.setRowId(var1, var2);
    }

    public void setShort(int var1, short var2) throws SQLException {
        this.preparedStatement.setShort(var1, var2);
    }

    public void setSQLXML(int var1, SQLXML var2) throws SQLException {
        this.preparedStatement.setSQLXML(var1, var2);
    }

    public void setString(int var1, String var2) throws SQLException {
        this.preparedStatement.setString(var1, var2);
    }

    public void setTime(int var1, Time var2) throws SQLException {
        this.preparedStatement.setTime(var1, var2);
    }

    public void setTime(int var1, Time var2, Calendar var3) throws SQLException {
        this.preparedStatement.setTime(var1, var2, var3);
    }

    public void setTimestamp(int var1, Timestamp var2) throws SQLException {
        this.preparedStatement.setTimestamp(var1, var2);
    }

    public void setTimestamp(int var1, Timestamp var2, Calendar var3) throws SQLException {
        this.preparedStatement.setTimestamp(var1, var2, var3);
    }

    public void setURL(int var1, URL var2) throws SQLException {
        this.preparedStatement.setURL(var1, var2);
    }

    public void setARRAY(int var1, ARRAY var2) throws SQLException {
        this.preparedStatement.setARRAY(var1, var2);
    }

    public void setBFILE(int var1, BFILE var2) throws SQLException {
        this.preparedStatement.setBFILE(var1, var2);
    }

    public void setBfile(int var1, BFILE var2) throws SQLException {
        this.preparedStatement.setBfile(var1, var2);
    }

    public void setBinaryFloat(int var1, float var2) throws SQLException {
        this.preparedStatement.setBinaryFloat(var1, var2);
    }

    public void setBinaryFloat(int var1, BINARY_FLOAT var2) throws SQLException {
        this.preparedStatement.setBinaryFloat(var1, var2);
    }

    public void setBinaryDouble(int var1, double var2) throws SQLException {
        this.preparedStatement.setBinaryDouble(var1, var2);
    }

    public void setBinaryDouble(int var1, BINARY_DOUBLE var2) throws SQLException {
        this.preparedStatement.setBinaryDouble(var1, var2);
    }

    public void setBLOB(int var1, BLOB var2) throws SQLException {
        this.preparedStatement.setBLOB(var1, var2);
    }

    public void setCHAR(int var1, CHAR var2) throws SQLException {
        this.preparedStatement.setCHAR(var1, var2);
    }

    public void setCLOB(int var1, CLOB var2) throws SQLException {
        this.preparedStatement.setCLOB(var1, var2);
    }

    public void setCursor(int var1, ResultSet var2) throws SQLException {
        this.preparedStatement.setCursor(var1, var2);
    }

    public void setDATE(int var1, DATE var2) throws SQLException {
        this.preparedStatement.setDATE(var1, var2);
    }

    public void setFixedCHAR(int var1, String var2) throws SQLException {
        this.preparedStatement.setFixedCHAR(var1, var2);
    }

    public void setINTERVALDS(int var1, INTERVALDS var2) throws SQLException {
        this.preparedStatement.setINTERVALDS(var1, var2);
    }

    public void setINTERVALYM(int var1, INTERVALYM var2) throws SQLException {
        this.preparedStatement.setINTERVALYM(var1, var2);
    }

    public void setNUMBER(int var1, NUMBER var2) throws SQLException {
        this.preparedStatement.setNUMBER(var1, var2);
    }

    public void setOPAQUE(int var1, OPAQUE var2) throws SQLException {
        this.preparedStatement.setOPAQUE(var1, var2);
    }

    public void setOracleObject(int var1, Datum var2) throws SQLException {
        this.preparedStatement.setOracleObject(var1, var2);
    }

    public void setORAData(int var1, ORAData var2) throws SQLException {
        this.preparedStatement.setORAData(var1, var2);
    }

    public void setRAW(int var1, RAW var2) throws SQLException {
        this.preparedStatement.setRAW(var1, var2);
    }

    public void setREF(int var1, REF var2) throws SQLException {
        this.preparedStatement.setREF(var1, var2);
    }

    public void setRefType(int var1, REF var2) throws SQLException {
        this.preparedStatement.setRefType(var1, var2);
    }

    public void setROWID(int var1, ROWID var2) throws SQLException {
        this.preparedStatement.setROWID(var1, var2);
    }

    public void setSTRUCT(int var1, STRUCT var2) throws SQLException {
        this.preparedStatement.setSTRUCT(var1, var2);
    }

    public void setTIMESTAMPLTZ(int var1, TIMESTAMPLTZ var2) throws SQLException {
        this.preparedStatement.setTIMESTAMPLTZ(var1, var2);
    }

    public void setTIMESTAMPTZ(int var1, TIMESTAMPTZ var2) throws SQLException {
        this.preparedStatement.setTIMESTAMPTZ(var1, var2);
    }

    public void setTIMESTAMP(int var1, TIMESTAMP var2) throws SQLException {
        this.preparedStatement.setTIMESTAMP(var1, var2);
    }

    public void setCustomDatum(int var1, CustomDatum var2) throws SQLException {
        this.preparedStatement.setCustomDatum(var1, var2);
    }

    public void setBlob(int var1, InputStream var2) throws SQLException {
        this.preparedStatement.setBlob(var1, var2);
    }

    public void setBlob(int var1, InputStream var2, long var3) throws SQLException {
        this.preparedStatement.setBlob(var1, var2, var3);
    }

    public void setClob(int var1, Reader var2) throws SQLException {
        this.preparedStatement.setClob(var1, var2);
    }

    public void setClob(int var1, Reader var2, long var3) throws SQLException {
        this.preparedStatement.setClob(var1, var2, var3);
    }

    public void setNClob(int var1, Reader var2) throws SQLException {
        this.preparedStatement.setNClob(var1, var2);
    }

    public void setNClob(int var1, Reader var2, long var3) throws SQLException {
        this.preparedStatement.setNClob(var1, var2, var3);
    }

    public void setAsciiStream(int var1, InputStream var2) throws SQLException {
        this.preparedStatement.setAsciiStream(var1, var2);
    }

    public void setAsciiStream(int var1, InputStream var2, int var3) throws SQLException {
        this.preparedStatement.setAsciiStream(var1, var2, var3);
    }

    public void setAsciiStream(int var1, InputStream var2, long var3) throws SQLException {
        this.preparedStatement.setAsciiStream(var1, var2, var3);
    }

    public void setBinaryStream(int var1, InputStream var2) throws SQLException {
        this.preparedStatement.setBinaryStream(var1, var2);
    }

    public void setBinaryStream(int var1, InputStream var2, int var3) throws SQLException {
        this.preparedStatement.setBinaryStream(var1, var2, var3);
    }

    public void setBinaryStream(int var1, InputStream var2, long var3) throws SQLException {
        this.preparedStatement.setBinaryStream(var1, var2, var3);
    }

    public void setCharacterStream(int var1, Reader var2) throws SQLException {
        this.preparedStatement.setCharacterStream(var1, var2);
    }

    public void setCharacterStream(int var1, Reader var2, int var3) throws SQLException {
        this.preparedStatement.setCharacterStream(var1, var2, var3);
    }

    public void setCharacterStream(int var1, Reader var2, long var3) throws SQLException {
        this.preparedStatement.setCharacterStream(var1, var2, var3);
    }

    public void setNCharacterStream(int var1, Reader var2) throws SQLException {
        this.preparedStatement.setNCharacterStream(var1, var2);
    }

    public void setNCharacterStream(int var1, Reader var2, long var3) throws SQLException {
        this.preparedStatement.setNCharacterStream(var1, var2, var3);
    }

    public void setUnicodeStream(int var1, InputStream var2, int var3) throws SQLException {
        this.preparedStatement.setUnicodeStream(var1, var2, var3);
    }

    public void setArrayAtName(String var1, Array var2) throws SQLException {
        this.preparedStatement.setArrayAtName(var1, var2);
    }

    public void setBigDecimalAtName(String var1, BigDecimal var2) throws SQLException {
        this.preparedStatement.setBigDecimalAtName(var1, var2);
    }

    public void setBlobAtName(String var1, Blob var2) throws SQLException {
        this.preparedStatement.setBlobAtName(var1, var2);
    }

    public void setBooleanAtName(String var1, boolean var2) throws SQLException {
        this.preparedStatement.setBooleanAtName(var1, var2);
    }

    public void setByteAtName(String var1, byte var2) throws SQLException {
        this.preparedStatement.setByteAtName(var1, var2);
    }

    public void setBytesAtName(String var1, byte[] var2) throws SQLException {
        this.preparedStatement.setBytesAtName(var1, var2);
    }

    public void setClobAtName(String var1, Clob var2) throws SQLException {
        this.preparedStatement.setClobAtName(var1, var2);
    }

    public void setDateAtName(String var1, Date var2) throws SQLException {
        this.preparedStatement.setDateAtName(var1, var2);
    }

    public void setDateAtName(String var1, Date var2, Calendar var3) throws SQLException {
        this.preparedStatement.setDateAtName(var1, var2, var3);
    }

    public void setDoubleAtName(String var1, double var2) throws SQLException {
        this.preparedStatement.setDoubleAtName(var1, var2);
    }

    public void setFloatAtName(String var1, float var2) throws SQLException {
        this.preparedStatement.setFloatAtName(var1, var2);
    }

    public void setIntAtName(String var1, int var2) throws SQLException {
        this.preparedStatement.setIntAtName(var1, var2);
    }

    public void setLongAtName(String var1, long var2) throws SQLException {
        this.preparedStatement.setLongAtName(var1, var2);
    }

    public void setNClobAtName(String var1, NClob var2) throws SQLException {
        this.preparedStatement.setNClobAtName(var1, var2);
    }

    public void setNStringAtName(String var1, String var2) throws SQLException {
        this.preparedStatement.setNStringAtName(var1, var2);
    }

    public void setObjectAtName(String var1, Object var2) throws SQLException {
        this.preparedStatement.setObjectAtName(var1, var2);
    }

    public void setObjectAtName(String var1, Object var2, int var3) throws SQLException {
        this.preparedStatement.setObjectAtName(var1, var2, var3);
    }

    public void setRefAtName(String var1, Ref var2) throws SQLException {
        this.preparedStatement.setRefAtName(var1, var2);
    }

    public void setRowIdAtName(String var1, RowId var2) throws SQLException {
        this.preparedStatement.setRowIdAtName(var1, var2);
    }

    public void setShortAtName(String var1, short var2) throws SQLException {
        this.preparedStatement.setShortAtName(var1, var2);
    }

    public void setSQLXMLAtName(String var1, SQLXML var2) throws SQLException {
        this.preparedStatement.setSQLXMLAtName(var1, var2);
    }

    public void setStringAtName(String var1, String var2) throws SQLException {
        this.preparedStatement.setStringAtName(var1, var2);
    }

    public void setTimeAtName(String var1, Time var2) throws SQLException {
        this.preparedStatement.setTimeAtName(var1, var2);
    }

    public void setTimeAtName(String var1, Time var2, Calendar var3) throws SQLException {
        this.preparedStatement.setTimeAtName(var1, var2, var3);
    }

    public void setTimestampAtName(String var1, Timestamp var2) throws SQLException {
        this.preparedStatement.setTimestampAtName(var1, var2);
    }

    public void setTimestampAtName(String var1, Timestamp var2, Calendar var3) throws SQLException {
        this.preparedStatement.setTimestampAtName(var1, var2, var3);
    }

    public void setURLAtName(String var1, URL var2) throws SQLException {
        this.preparedStatement.setURLAtName(var1, var2);
    }

    public void setARRAYAtName(String var1, ARRAY var2) throws SQLException {
        this.preparedStatement.setARRAYAtName(var1, var2);
    }

    public void setBFILEAtName(String var1, BFILE var2) throws SQLException {
        this.preparedStatement.setBFILEAtName(var1, var2);
    }

    public void setBfileAtName(String var1, BFILE var2) throws SQLException {
        this.preparedStatement.setBfileAtName(var1, var2);
    }

    public void setBinaryFloatAtName(String var1, float var2) throws SQLException {
        this.preparedStatement.setBinaryFloatAtName(var1, var2);
    }

    public void setBinaryFloatAtName(String var1, BINARY_FLOAT var2) throws SQLException {
        this.preparedStatement.setBinaryFloatAtName(var1, var2);
    }

    public void setBinaryDoubleAtName(String var1, double var2) throws SQLException {
        this.preparedStatement.setBinaryDoubleAtName(var1, var2);
    }

    public void setBinaryDoubleAtName(String var1, BINARY_DOUBLE var2) throws SQLException {
        this.preparedStatement.setBinaryDoubleAtName(var1, var2);
    }

    public void setBLOBAtName(String var1, BLOB var2) throws SQLException {
        this.preparedStatement.setBLOBAtName(var1, var2);
    }

    public void setCHARAtName(String var1, CHAR var2) throws SQLException {
        this.preparedStatement.setCHARAtName(var1, var2);
    }

    public void setCLOBAtName(String var1, CLOB var2) throws SQLException {
        this.preparedStatement.setCLOBAtName(var1, var2);
    }

    public void setCursorAtName(String var1, ResultSet var2) throws SQLException {
        this.preparedStatement.setCursorAtName(var1, var2);
    }

    public void setDATEAtName(String var1, DATE var2) throws SQLException {
        this.preparedStatement.setDATEAtName(var1, var2);
    }

    public void setFixedCHARAtName(String var1, String var2) throws SQLException {
        this.preparedStatement.setFixedCHARAtName(var1, var2);
    }

    public void setINTERVALDSAtName(String var1, INTERVALDS var2) throws SQLException {
        this.preparedStatement.setINTERVALDSAtName(var1, var2);
    }

    public void setINTERVALYMAtName(String var1, INTERVALYM var2) throws SQLException {
        this.preparedStatement.setINTERVALYMAtName(var1, var2);
    }

    public void setNUMBERAtName(String var1, NUMBER var2) throws SQLException {
        this.preparedStatement.setNUMBERAtName(var1, var2);
    }

    public void setOPAQUEAtName(String var1, OPAQUE var2) throws SQLException {
        this.preparedStatement.setOPAQUEAtName(var1, var2);
    }

    public void setOracleObjectAtName(String var1, Datum var2) throws SQLException {
        this.preparedStatement.setOracleObjectAtName(var1, var2);
    }

    public void setORADataAtName(String var1, ORAData var2) throws SQLException {
        this.preparedStatement.setORADataAtName(var1, var2);
    }

    public void setRAWAtName(String var1, RAW var2) throws SQLException {
        this.preparedStatement.setRAWAtName(var1, var2);
    }

    public void setREFAtName(String var1, REF var2) throws SQLException {
        this.preparedStatement.setREFAtName(var1, var2);
    }

    public void setRefTypeAtName(String var1, REF var2) throws SQLException {
        this.preparedStatement.setRefTypeAtName(var1, var2);
    }

    public void setROWIDAtName(String var1, ROWID var2) throws SQLException {
        this.preparedStatement.setROWIDAtName(var1, var2);
    }

    public void setSTRUCTAtName(String var1, STRUCT var2) throws SQLException {
        this.preparedStatement.setSTRUCTAtName(var1, var2);
    }

    public void setTIMESTAMPLTZAtName(String var1, TIMESTAMPLTZ var2) throws SQLException {
        this.preparedStatement.setTIMESTAMPLTZAtName(var1, var2);
    }

    public void setTIMESTAMPTZAtName(String var1, TIMESTAMPTZ var2) throws SQLException {
        this.preparedStatement.setTIMESTAMPTZAtName(var1, var2);
    }

    public void setTIMESTAMPAtName(String var1, TIMESTAMP var2) throws SQLException {
        this.preparedStatement.setTIMESTAMPAtName(var1, var2);
    }

    public void setCustomDatumAtName(String var1, CustomDatum var2) throws SQLException {
        this.preparedStatement.setCustomDatumAtName(var1, var2);
    }

    public void setBlobAtName(String var1, InputStream var2) throws SQLException {
        this.preparedStatement.setBlobAtName(var1, var2);
    }

    public void setBlobAtName(String var1, InputStream var2, long var3) throws SQLException {
        this.preparedStatement.setBlobAtName(var1, var2, var3);
    }

    public void setClobAtName(String var1, Reader var2) throws SQLException {
        this.preparedStatement.setClobAtName(var1, var2);
    }

    public void setClobAtName(String var1, Reader var2, long var3) throws SQLException {
        this.preparedStatement.setClobAtName(var1, var2, var3);
    }

    public void setNClobAtName(String var1, Reader var2) throws SQLException {
        this.preparedStatement.setNClobAtName(var1, var2);
    }

    public void setNClobAtName(String var1, Reader var2, long var3) throws SQLException {
        this.preparedStatement.setNClobAtName(var1, var2, var3);
    }

    public void setAsciiStreamAtName(String var1, InputStream var2) throws SQLException {
        this.preparedStatement.setAsciiStreamAtName(var1, var2);
    }

    public void setAsciiStreamAtName(String var1, InputStream var2, int var3) throws SQLException {
        this.preparedStatement.setAsciiStreamAtName(var1, var2, var3);
    }

    public void setAsciiStreamAtName(String var1, InputStream var2, long var3) throws SQLException {
        this.preparedStatement.setAsciiStreamAtName(var1, var2, var3);
    }

    public void setBinaryStreamAtName(String var1, InputStream var2) throws SQLException {
        this.preparedStatement.setBinaryStreamAtName(var1, var2);
    }

    public void setBinaryStreamAtName(String var1, InputStream var2, int var3) throws SQLException {
        this.preparedStatement.setBinaryStreamAtName(var1, var2, var3);
    }

    public void setBinaryStreamAtName(String var1, InputStream var2, long var3) throws SQLException {
        this.preparedStatement.setBinaryStreamAtName(var1, var2, var3);
    }

    public void setCharacterStreamAtName(String var1, Reader var2) throws SQLException {
        this.preparedStatement.setCharacterStreamAtName(var1, var2);
    }

    public void setCharacterStreamAtName(String var1, Reader var2, int var3) throws SQLException {
        this.preparedStatement.setCharacterStreamAtName(var1, var2, var3);
    }

    public void setCharacterStreamAtName(String var1, Reader var2, long var3) throws SQLException {
        this.preparedStatement.setCharacterStreamAtName(var1, var2, var3);
    }

    public void setNCharacterStreamAtName(String var1, Reader var2) throws SQLException {
        this.preparedStatement.setNCharacterStreamAtName(var1, var2);
    }

    public void setNCharacterStreamAtName(String var1, Reader var2, long var3) throws SQLException {
        this.preparedStatement.setNCharacterStreamAtName(var1, var2, var3);
    }

    public void setUnicodeStreamAtName(String var1, InputStream var2, int var3) throws SQLException {
        this.preparedStatement.setUnicodeStreamAtName(var1, var2, var3);
    }

    public void setNull(int var1, int var2) throws SQLException {
        this.preparedStatement.setNull(var1, var2);
    }

    public void setNull(int var1, int var2, String var3) throws SQLException {
        this.preparedStatement.setNull(var1, var2, var3);
    }

    public void setNullAtName(String var1, int var2) throws SQLException {
        this.preparedStatement.setNullAtName(var1, var2);
    }

    public void setNullAtName(String var1, int var2, String var3) throws SQLException {
        this.preparedStatement.setNullAtName(var1, var2, var3);
    }

    public void setObject(int var1, Object var2, int var3, int var4) throws SQLException {
        this.preparedStatement.setObject(var1, var2, var3, var4);
    }

    public void setObjectAtName(String var1, Object var2, int var3, int var4) throws SQLException {
        this.preparedStatement.setObjectAtName(var1, var2, var3, var4);
    }

    public void setStructDescriptor(int var1, StructDescriptor var2) throws SQLException {
        this.preparedStatement.setStructDescriptor(var1, var2);
    }

    public void setStructDescriptorAtName(String var1, StructDescriptor var2) throws SQLException {
        this.preparedStatement.setStructDescriptorAtName(var1, var2);
    }

    public int executeUpdate() throws SQLException {
        return this.preparedStatement.executeUpdate();
    }

    public void addBatch() throws SQLException {
        this.preparedStatement.addBatch();
    }

    public void clearParameters() throws SQLException {
        this.preparedStatement.clearParameters();
    }

    public boolean execute() throws SQLException {
        return this.preparedStatement.execute();
    }

    public void setCheckBindTypes(boolean var1) {
        this.preparedStatement.setCheckBindTypes(var1);
    }

    public ResultSet getReturnResultSet() throws SQLException {
        return this.preparedStatement.getReturnResultSet();
    }

    public void defineParameterTypeBytes(int var1, int var2, int var3) throws SQLException {
        this.preparedStatement.defineParameterTypeBytes(var1, var2, var3);
    }

    public void defineParameterTypeChars(int var1, int var2, int var3) throws SQLException {
        this.preparedStatement.defineParameterTypeChars(var1, var2, var3);
    }

    public void defineParameterType(int var1, int var2, int var3) throws SQLException {
        this.preparedStatement.defineParameterType(var1, var2, var3);
    }

    public int getExecuteBatch() {
        return this.preparedStatement.getExecuteBatch();
    }

    public int sendBatch() throws SQLException {
        return this.preparedStatement.sendBatch();
    }

    public void setPlsqlIndexTable(int var1, Object var2, int var3, int var4, int var5, int var6) throws SQLException {
        this.preparedStatement.setPlsqlIndexTable(var1, var2, var3, var4, var5, var6);
    }

    public void setFormOfUse(int var1, short var2) {
        this.preparedStatement.setFormOfUse(var1, var2);
    }

    public void setDisableStmtCaching(boolean var1) {
        this.preparedStatement.setDisableStmtCaching(var1);
    }

    public OracleParameterMetaData OracleGetParameterMetaData() throws SQLException {
        return this.preparedStatement.OracleGetParameterMetaData();
    }

    public void registerReturnParameter(int var1, int var2) throws SQLException {
        this.preparedStatement.registerReturnParameter(var1, var2);
    }

    public void registerReturnParameter(int var1, int var2, int var3) throws SQLException {
        this.preparedStatement.registerReturnParameter(var1, var2, var3);
    }

    public void registerReturnParameter(int var1, int var2, String var3) throws SQLException {
        this.preparedStatement.registerReturnParameter(var1, var2, var3);
    }

    public ResultSet executeQuery() throws SQLException {
        return this.preparedStatement.executeQuery();
    }

    public ResultSetMetaData getMetaData() throws SQLException {
        return this.preparedStatement.getMetaData();
    }

    public void setBytesForBlob(int var1, byte[] var2) throws SQLException {
        this.preparedStatement.setBytesForBlob(var1, var2);
    }

    public void setBytesForBlobAtName(String var1, byte[] var2) throws SQLException {
        this.preparedStatement.setBytesForBlobAtName(var1, var2);
    }

    public void setStringForClob(int var1, String var2) throws SQLException {
        this.preparedStatement.setStringForClob(var1, var2);
    }

    public void setStringForClobAtName(String var1, String var2) throws SQLException {
        this.preparedStatement.setStringForClobAtName(var1, var2);
    }

    public ParameterMetaData getParameterMetaData() throws SQLException {
        return this.preparedStatement.getParameterMetaData();
    }

    public void setExecuteBatch(int var1) throws SQLException {
        this.preparedStatement.setExecuteBatch(var1);
    }

    public boolean isPoolable() throws SQLException {
        return this.preparedStatement.isPoolable();
    }

    public void setPoolable(boolean var1) throws SQLException {
        this.preparedStatement.setPoolable(var1);
    }

    public void setInternalBytes(int var1, byte[] var2, int var3) throws SQLException {
        this.preparedStatement.setInternalBytes(var1, var2, var3);
    }

    public void enterImplicitCache() throws SQLException {
        this.preparedStatement.enterImplicitCache();
    }

    public void enterExplicitCache() throws SQLException {
        this.preparedStatement.enterExplicitCache();
    }

    public void exitImplicitCacheToActive() throws SQLException {
        this.preparedStatement.exitImplicitCacheToActive();
    }

    public void exitExplicitCacheToActive() throws SQLException {
        this.preparedStatement.exitExplicitCacheToActive();
    }

    public void exitImplicitCacheToClose() throws SQLException {
        this.preparedStatement.exitImplicitCacheToClose();
    }

    public void exitExplicitCacheToClose() throws SQLException {
        this.preparedStatement.exitExplicitCacheToClose();
    }

    public String getOriginalSql() throws SQLException {
        return this.preparedStatement.getOriginalSql();
    }

    public void setACProxy(Object var1) {
        this.acProxy = var1;
    }

    public Object getACProxy() {
        return this.acProxy;
    }
}
