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
import java.sql.RowId;
import java.sql.SQLException;
import java.sql.SQLXML;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Map;
import oracle.jdbc.OracleDataFactory;
import oracle.jdbc.internal.OracleCallableStatement;
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

class OracleCallableStatementWrapper extends OraclePreparedStatementWrapper implements OracleCallableStatement {
    protected OracleCallableStatement callableStatement = null;
    Object acProxy;
    private static final String _Copyright_2007_Oracle_All_Rights_Reserved_ = null;
    public static final String BUILD_DATE = "Thu_Apr_04_15:09:24_PDT_2013";
    public static final boolean TRACE = false;

    OracleCallableStatementWrapper(oracle.jdbc.OracleCallableStatement var1) throws SQLException {
        super(var1);
        this.callableStatement = (OracleCallableStatement)var1;
    }

    public void setArray(String var1, Array var2) throws SQLException {
        this.callableStatement.setArray(var1, var2);
    }

    public void setBigDecimal(String var1, BigDecimal var2) throws SQLException {
        this.callableStatement.setBigDecimal(var1, var2);
    }

    public void setBlob(String var1, Blob var2) throws SQLException {
        this.callableStatement.setBlob(var1, var2);
    }

    public void setBoolean(String var1, boolean var2) throws SQLException {
        this.callableStatement.setBoolean(var1, var2);
    }

    public void setByte(String var1, byte var2) throws SQLException {
        this.callableStatement.setByte(var1, var2);
    }

    public void setBytes(String var1, byte[] var2) throws SQLException {
        this.callableStatement.setBytes(var1, var2);
    }

    public void setClob(String var1, Clob var2) throws SQLException {
        this.callableStatement.setClob(var1, var2);
    }

    public void setDate(String var1, Date var2) throws SQLException {
        this.callableStatement.setDate(var1, var2);
    }

    public void setDate(String var1, Date var2, Calendar var3) throws SQLException {
        this.callableStatement.setDate(var1, var2, var3);
    }

    public void setDouble(String var1, double var2) throws SQLException {
        this.callableStatement.setDouble(var1, var2);
    }

    public void setFloat(String var1, float var2) throws SQLException {
        this.callableStatement.setFloat(var1, var2);
    }

    public void setInt(String var1, int var2) throws SQLException {
        this.callableStatement.setInt(var1, var2);
    }

    public void setLong(String var1, long var2) throws SQLException {
        this.callableStatement.setLong(var1, var2);
    }

    public void setNClob(String var1, NClob var2) throws SQLException {
        this.callableStatement.setNClob(var1, var2);
    }

    public void setNString(String var1, String var2) throws SQLException {
        this.callableStatement.setNString(var1, var2);
    }

    public void setObject(String var1, Object var2) throws SQLException {
        this.callableStatement.setObject(var1, var2);
    }

    public void setObject(String var1, Object var2, int var3) throws SQLException {
        this.callableStatement.setObject(var1, var2, var3);
    }

    public void setRef(String var1, Ref var2) throws SQLException {
        this.callableStatement.setRef(var1, var2);
    }

    public void setRowId(String var1, RowId var2) throws SQLException {
        this.callableStatement.setRowId(var1, var2);
    }

    public void setShort(String var1, short var2) throws SQLException {
        this.callableStatement.setShort(var1, var2);
    }

    public void setSQLXML(String var1, SQLXML var2) throws SQLException {
        this.callableStatement.setSQLXML(var1, var2);
    }

    public void setString(String var1, String var2) throws SQLException {
        this.callableStatement.setString(var1, var2);
    }

    public void setTime(String var1, Time var2) throws SQLException {
        this.callableStatement.setTime(var1, var2);
    }

    public void setTime(String var1, Time var2, Calendar var3) throws SQLException {
        this.callableStatement.setTime(var1, var2, var3);
    }

    public void setTimestamp(String var1, Timestamp var2) throws SQLException {
        this.callableStatement.setTimestamp(var1, var2);
    }

    public void setTimestamp(String var1, Timestamp var2, Calendar var3) throws SQLException {
        this.callableStatement.setTimestamp(var1, var2, var3);
    }

    public void setURL(String var1, URL var2) throws SQLException {
        this.callableStatement.setURL(var1, var2);
    }

    public void setARRAY(String var1, ARRAY var2) throws SQLException {
        this.callableStatement.setARRAY(var1, var2);
    }

    public void setBFILE(String var1, BFILE var2) throws SQLException {
        this.callableStatement.setBFILE(var1, var2);
    }

    public void setBfile(String var1, BFILE var2) throws SQLException {
        this.callableStatement.setBfile(var1, var2);
    }

    public void setBinaryFloat(String var1, float var2) throws SQLException {
        this.callableStatement.setBinaryFloat(var1, var2);
    }

    public void setBinaryFloat(String var1, BINARY_FLOAT var2) throws SQLException {
        this.callableStatement.setBinaryFloat(var1, var2);
    }

    public void setBinaryDouble(String var1, double var2) throws SQLException {
        this.callableStatement.setBinaryDouble(var1, var2);
    }

    public void setBinaryDouble(String var1, BINARY_DOUBLE var2) throws SQLException {
        this.callableStatement.setBinaryDouble(var1, var2);
    }

    public void setBLOB(String var1, BLOB var2) throws SQLException {
        this.callableStatement.setBLOB(var1, var2);
    }

    public void setCHAR(String var1, CHAR var2) throws SQLException {
        this.callableStatement.setCHAR(var1, var2);
    }

    public void setCLOB(String var1, CLOB var2) throws SQLException {
        this.callableStatement.setCLOB(var1, var2);
    }

    public void setCursor(String var1, ResultSet var2) throws SQLException {
        this.callableStatement.setCursor(var1, var2);
    }

    public void setDATE(String var1, DATE var2) throws SQLException {
        this.callableStatement.setDATE(var1, var2);
    }

    public void setFixedCHAR(String var1, String var2) throws SQLException {
        this.callableStatement.setFixedCHAR(var1, var2);
    }

    public void setINTERVALDS(String var1, INTERVALDS var2) throws SQLException {
        this.callableStatement.setINTERVALDS(var1, var2);
    }

    public void setINTERVALYM(String var1, INTERVALYM var2) throws SQLException {
        this.callableStatement.setINTERVALYM(var1, var2);
    }

    public void setNUMBER(String var1, NUMBER var2) throws SQLException {
        this.callableStatement.setNUMBER(var1, var2);
    }

    public void setOPAQUE(String var1, OPAQUE var2) throws SQLException {
        this.callableStatement.setOPAQUE(var1, var2);
    }

    public void setOracleObject(String var1, Datum var2) throws SQLException {
        this.callableStatement.setOracleObject(var1, var2);
    }

    public void setORAData(String var1, ORAData var2) throws SQLException {
        this.callableStatement.setORAData(var1, var2);
    }

    public void setRAW(String var1, RAW var2) throws SQLException {
        this.callableStatement.setRAW(var1, var2);
    }

    public void setREF(String var1, REF var2) throws SQLException {
        this.callableStatement.setREF(var1, var2);
    }

    public void setRefType(String var1, REF var2) throws SQLException {
        this.callableStatement.setRefType(var1, var2);
    }

    public void setROWID(String var1, ROWID var2) throws SQLException {
        this.callableStatement.setROWID(var1, var2);
    }

    public void setSTRUCT(String var1, STRUCT var2) throws SQLException {
        this.callableStatement.setSTRUCT(var1, var2);
    }

    public void setTIMESTAMPLTZ(String var1, TIMESTAMPLTZ var2) throws SQLException {
        this.callableStatement.setTIMESTAMPLTZ(var1, var2);
    }

    public void setTIMESTAMPTZ(String var1, TIMESTAMPTZ var2) throws SQLException {
        this.callableStatement.setTIMESTAMPTZ(var1, var2);
    }

    public void setTIMESTAMP(String var1, TIMESTAMP var2) throws SQLException {
        this.callableStatement.setTIMESTAMP(var1, var2);
    }

    public void setCustomDatum(String var1, CustomDatum var2) throws SQLException {
        this.callableStatement.setCustomDatum(var1, var2);
    }

    public void setBlob(String var1, InputStream var2) throws SQLException {
        this.callableStatement.setBlob(var1, var2);
    }

    public void setBlob(String var1, InputStream var2, long var3) throws SQLException {
        this.callableStatement.setBlob(var1, var2, var3);
    }

    public void setClob(String var1, Reader var2) throws SQLException {
        this.callableStatement.setClob(var1, var2);
    }

    public void setClob(String var1, Reader var2, long var3) throws SQLException {
        this.callableStatement.setClob(var1, var2, var3);
    }

    public void setNClob(String var1, Reader var2) throws SQLException {
        this.callableStatement.setNClob(var1, var2);
    }

    public void setNClob(String var1, Reader var2, long var3) throws SQLException {
        this.callableStatement.setNClob(var1, var2, var3);
    }

    public void setAsciiStream(String var1, InputStream var2) throws SQLException {
        this.callableStatement.setAsciiStream(var1, var2);
    }

    public void setAsciiStream(String var1, InputStream var2, int var3) throws SQLException {
        this.callableStatement.setAsciiStream(var1, var2, var3);
    }

    public void setAsciiStream(String var1, InputStream var2, long var3) throws SQLException {
        this.callableStatement.setAsciiStream(var1, var2, var3);
    }

    public void setBinaryStream(String var1, InputStream var2) throws SQLException {
        this.callableStatement.setBinaryStream(var1, var2);
    }

    public void setBinaryStream(String var1, InputStream var2, int var3) throws SQLException {
        this.callableStatement.setBinaryStream(var1, var2, var3);
    }

    public void setBinaryStream(String var1, InputStream var2, long var3) throws SQLException {
        this.callableStatement.setBinaryStream(var1, var2, var3);
    }

    public void setCharacterStream(String var1, Reader var2) throws SQLException {
        this.callableStatement.setCharacterStream(var1, var2);
    }

    public void setCharacterStream(String var1, Reader var2, int var3) throws SQLException {
        this.callableStatement.setCharacterStream(var1, var2, var3);
    }

    public void setCharacterStream(String var1, Reader var2, long var3) throws SQLException {
        this.callableStatement.setCharacterStream(var1, var2, var3);
    }

    public void setNCharacterStream(String var1, Reader var2) throws SQLException {
        this.callableStatement.setNCharacterStream(var1, var2);
    }

    public void setNCharacterStream(String var1, Reader var2, long var3) throws SQLException {
        this.callableStatement.setNCharacterStream(var1, var2, var3);
    }

    public void setUnicodeStream(String var1, InputStream var2, int var3) throws SQLException {
        this.callableStatement.setUnicodeStream(var1, var2, var3);
    }

    public void setNull(String var1, int var2, String var3) throws SQLException {
        this.callableStatement.setNull(var1, var2, var3);
    }

    public void setNull(String var1, int var2) throws SQLException {
        this.callableStatement.setNull(var1, var2);
    }

    public Array getArray(int var1) throws SQLException {
        return this.callableStatement.getArray(var1);
    }

    public BigDecimal getBigDecimal(int var1) throws SQLException {
        return this.callableStatement.getBigDecimal(var1);
    }

    public BigDecimal getBigDecimal(int var1, int var2) throws SQLException {
        return this.callableStatement.getBigDecimal(var1, var2);
    }

    public Blob getBlob(int var1) throws SQLException {
        return this.callableStatement.getBlob(var1);
    }

    public boolean getBoolean(int var1) throws SQLException {
        return this.callableStatement.getBoolean(var1);
    }

    public byte getByte(int var1) throws SQLException {
        return this.callableStatement.getByte(var1);
    }

    public byte[] getBytes(int var1) throws SQLException {
        return this.callableStatement.getBytes(var1);
    }

    public Clob getClob(int var1) throws SQLException {
        return this.callableStatement.getClob(var1);
    }

    public Date getDate(int var1) throws SQLException {
        return this.callableStatement.getDate(var1);
    }

    public Date getDate(int var1, Calendar var2) throws SQLException {
        return this.callableStatement.getDate(var1, var2);
    }

    public double getDouble(int var1) throws SQLException {
        return this.callableStatement.getDouble(var1);
    }

    public float getFloat(int var1) throws SQLException {
        return this.callableStatement.getFloat(var1);
    }

    public int getInt(int var1) throws SQLException {
        return this.callableStatement.getInt(var1);
    }

    public long getLong(int var1) throws SQLException {
        return this.callableStatement.getLong(var1);
    }

    public NClob getNClob(int var1) throws SQLException {
        return this.callableStatement.getNClob(var1);
    }

    public String getNString(int var1) throws SQLException {
        return this.callableStatement.getNString(var1);
    }

    public Object getObject(int var1) throws SQLException {
        return this.callableStatement.getObject(var1);
    }

    public Object getObject(int var1, Map var2) throws SQLException {
        return this.callableStatement.getObject(var1, var2);
    }

    public Ref getRef(int var1) throws SQLException {
        return this.callableStatement.getRef(var1);
    }

    public RowId getRowId(int var1) throws SQLException {
        return this.callableStatement.getRowId(var1);
    }

    public short getShort(int var1) throws SQLException {
        return this.callableStatement.getShort(var1);
    }

    public SQLXML getSQLXML(int var1) throws SQLException {
        return this.callableStatement.getSQLXML(var1);
    }

    public String getString(int var1) throws SQLException {
        return this.callableStatement.getString(var1);
    }

    public Time getTime(int var1) throws SQLException {
        return this.callableStatement.getTime(var1);
    }

    public Time getTime(int var1, Calendar var2) throws SQLException {
        return this.callableStatement.getTime(var1, var2);
    }

    public Timestamp getTimestamp(int var1) throws SQLException {
        return this.callableStatement.getTimestamp(var1);
    }

    public Timestamp getTimestamp(int var1, Calendar var2) throws SQLException {
        return this.callableStatement.getTimestamp(var1, var2);
    }

    public URL getURL(int var1) throws SQLException {
        return this.callableStatement.getURL(var1);
    }

    public ARRAY getARRAY(int var1) throws SQLException {
        return this.callableStatement.getARRAY(var1);
    }

    public BFILE getBFILE(int var1) throws SQLException {
        return this.callableStatement.getBFILE(var1);
    }

    public BFILE getBfile(int var1) throws SQLException {
        return this.callableStatement.getBfile(var1);
    }

    public BLOB getBLOB(int var1) throws SQLException {
        return this.callableStatement.getBLOB(var1);
    }

    public CHAR getCHAR(int var1) throws SQLException {
        return this.callableStatement.getCHAR(var1);
    }

    public CLOB getCLOB(int var1) throws SQLException {
        return this.callableStatement.getCLOB(var1);
    }

    public ResultSet getCursor(int var1) throws SQLException {
        return this.callableStatement.getCursor(var1);
    }

    public DATE getDATE(int var1) throws SQLException {
        return this.callableStatement.getDATE(var1);
    }

    public INTERVALDS getINTERVALDS(int var1) throws SQLException {
        return this.callableStatement.getINTERVALDS(var1);
    }

    public INTERVALYM getINTERVALYM(int var1) throws SQLException {
        return this.callableStatement.getINTERVALYM(var1);
    }

    public NUMBER getNUMBER(int var1) throws SQLException {
        return this.callableStatement.getNUMBER(var1);
    }

    public OPAQUE getOPAQUE(int var1) throws SQLException {
        return this.callableStatement.getOPAQUE(var1);
    }

    public Datum getOracleObject(int var1) throws SQLException {
        return this.callableStatement.getOracleObject(var1);
    }

    public Object getORAData(int var1, ORADataFactory var2) throws SQLException {
        return this.callableStatement.getORAData(var1, var2);
    }

    public Object getObject(int var1, OracleDataFactory var2) throws SQLException {
        return this.callableStatement.getObject(var1, var2);
    }

    public RAW getRAW(int var1) throws SQLException {
        return this.callableStatement.getRAW(var1);
    }

    public REF getREF(int var1) throws SQLException {
        return this.callableStatement.getREF(var1);
    }

    public ROWID getROWID(int var1) throws SQLException {
        return this.callableStatement.getROWID(var1);
    }

    public STRUCT getSTRUCT(int var1) throws SQLException {
        return this.callableStatement.getSTRUCT(var1);
    }

    public TIMESTAMPLTZ getTIMESTAMPLTZ(int var1) throws SQLException {
        return this.callableStatement.getTIMESTAMPLTZ(var1);
    }

    public TIMESTAMPTZ getTIMESTAMPTZ(int var1) throws SQLException {
        return this.callableStatement.getTIMESTAMPTZ(var1);
    }

    public TIMESTAMP getTIMESTAMP(int var1) throws SQLException {
        return this.callableStatement.getTIMESTAMP(var1);
    }

    public Object getCustomDatum(int var1, CustomDatumFactory var2) throws SQLException {
        return this.callableStatement.getCustomDatum(var1, var2);
    }

    public InputStream getAsciiStream(int var1) throws SQLException {
        return this.callableStatement.getAsciiStream(var1);
    }

    public InputStream getBinaryStream(int var1) throws SQLException {
        return this.callableStatement.getBinaryStream(var1);
    }

    public Reader getCharacterStream(int var1) throws SQLException {
        return this.callableStatement.getCharacterStream(var1);
    }

    public Reader getNCharacterStream(int var1) throws SQLException {
        return this.callableStatement.getNCharacterStream(var1);
    }

    public InputStream getUnicodeStream(int var1) throws SQLException {
        return this.callableStatement.getUnicodeStream(var1);
    }

    public Array getArray(String var1) throws SQLException {
        return this.callableStatement.getArray(var1);
    }

    public BigDecimal getBigDecimal(String var1) throws SQLException {
        return this.callableStatement.getBigDecimal(var1);
    }

    public BigDecimal getBigDecimal(String var1, int var2) throws SQLException {
        return this.callableStatement.getBigDecimal(var1, var2);
    }

    public Blob getBlob(String var1) throws SQLException {
        return this.callableStatement.getBlob(var1);
    }

    public boolean getBoolean(String var1) throws SQLException {
        return this.callableStatement.getBoolean(var1);
    }

    public byte getByte(String var1) throws SQLException {
        return this.callableStatement.getByte(var1);
    }

    public byte[] getBytes(String var1) throws SQLException {
        return this.callableStatement.getBytes(var1);
    }

    public Clob getClob(String var1) throws SQLException {
        return this.callableStatement.getClob(var1);
    }

    public Date getDate(String var1) throws SQLException {
        return this.callableStatement.getDate(var1);
    }

    public Date getDate(String var1, Calendar var2) throws SQLException {
        return this.callableStatement.getDate(var1, var2);
    }

    public double getDouble(String var1) throws SQLException {
        return this.callableStatement.getDouble(var1);
    }

    public float getFloat(String var1) throws SQLException {
        return this.callableStatement.getFloat(var1);
    }

    public int getInt(String var1) throws SQLException {
        return this.callableStatement.getInt(var1);
    }

    public long getLong(String var1) throws SQLException {
        return this.callableStatement.getLong(var1);
    }

    public NClob getNClob(String var1) throws SQLException {
        return this.callableStatement.getNClob(var1);
    }

    public String getNString(String var1) throws SQLException {
        return this.callableStatement.getNString(var1);
    }

    public Object getObject(String var1) throws SQLException {
        return this.callableStatement.getObject(var1);
    }

    public Object getObject(String var1, Map var2) throws SQLException {
        return this.callableStatement.getObject(var1, var2);
    }

    public Ref getRef(String var1) throws SQLException {
        return this.callableStatement.getRef(var1);
    }

    public RowId getRowId(String var1) throws SQLException {
        return this.callableStatement.getRowId(var1);
    }

    public short getShort(String var1) throws SQLException {
        return this.callableStatement.getShort(var1);
    }

    public SQLXML getSQLXML(String var1) throws SQLException {
        return this.callableStatement.getSQLXML(var1);
    }

    public String getString(String var1) throws SQLException {
        return this.callableStatement.getString(var1);
    }

    public Time getTime(String var1) throws SQLException {
        return this.callableStatement.getTime(var1);
    }

    public Time getTime(String var1, Calendar var2) throws SQLException {
        return this.callableStatement.getTime(var1, var2);
    }

    public Timestamp getTimestamp(String var1) throws SQLException {
        return this.callableStatement.getTimestamp(var1);
    }

    public Timestamp getTimestamp(String var1, Calendar var2) throws SQLException {
        return this.callableStatement.getTimestamp(var1, var2);
    }

    public URL getURL(String var1) throws SQLException {
        return this.callableStatement.getURL(var1);
    }

    public InputStream getAsciiStream(String var1) throws SQLException {
        return this.callableStatement.getAsciiStream(var1);
    }

    public InputStream getBinaryStream(String var1) throws SQLException {
        return this.callableStatement.getBinaryStream(var1);
    }

    public Reader getCharacterStream(String var1) throws SQLException {
        return this.callableStatement.getCharacterStream(var1);
    }

    public Reader getNCharacterStream(String var1) throws SQLException {
        return this.callableStatement.getNCharacterStream(var1);
    }

    public InputStream getUnicodeStream(String var1) throws SQLException {
        return this.callableStatement.getUnicodeStream(var1);
    }

    public void setObject(String var1, Object var2, int var3, int var4) throws SQLException {
        this.callableStatement.setObject(var1, var2, var3, var4);
    }

    public <T> T getObject(String var1, Class<T> var2) throws SQLException {
        return this.callableStatement.getObject(var1, var2);
    }

    public <T> T getObject(int var1, Class<T> var2) throws SQLException {
        return this.callableStatement.getObject(var1, var2);
    }

    public Object getAnyDataEmbeddedObject(int var1) throws SQLException {
        return this.callableStatement.getAnyDataEmbeddedObject(var1);
    }

    public void setStructDescriptor(int var1, StructDescriptor var2) throws SQLException {
        this.callableStatement.setStructDescriptor(var1, var2);
    }

    public void setStructDescriptor(String var1, StructDescriptor var2) throws SQLException {
        this.callableStatement.setStructDescriptor(var1, var2);
    }

    public void close() throws SQLException {
        super.close();
        this.callableStatement = OracleStatementWrapper.closedStatement;
    }

    void beClosed() throws SQLException {
        this.callableStatement = closedStatement;
        super.beClosed();
    }

    public void closeWithKey(String var1) throws SQLException {
        this.callableStatement.closeWithKey(var1);
        this.statement = this.preparedStatement = this.callableStatement = closedStatement;
    }

    public void registerOutParameter(int var1, int var2, int var3, int var4) throws SQLException {
        this.callableStatement.registerOutParameter(var1, var2, var3, var4);
    }

    public void registerOutParameterBytes(int var1, int var2, int var3, int var4) throws SQLException {
        this.callableStatement.registerOutParameterBytes(var1, var2, var3, var4);
    }

    public void registerOutParameterChars(int var1, int var2, int var3, int var4) throws SQLException {
        this.callableStatement.registerOutParameterChars(var1, var2, var3, var4);
    }

    public void registerIndexTableOutParameter(int var1, int var2, int var3, int var4) throws SQLException {
        this.callableStatement.registerIndexTableOutParameter(var1, var2, var3, var4);
    }

    public void registerOutParameter(String var1, int var2, int var3, int var4) throws SQLException {
        this.callableStatement.registerOutParameter(var1, var2, var3, var4);
    }

    public void registerOutParameter(String var1, int var2, String var3) throws SQLException {
        this.callableStatement.registerOutParameter(var1, var2, var3);
    }

    public int sendBatch() throws SQLException {
        return this.callableStatement.sendBatch();
    }

    public void setExecuteBatch(int var1) throws SQLException {
        this.callableStatement.setExecuteBatch(var1);
    }

    public Object getPlsqlIndexTable(int var1) throws SQLException {
        return this.callableStatement.getPlsqlIndexTable(var1);
    }

    public Object getPlsqlIndexTable(int var1, Class var2) throws SQLException {
        return this.callableStatement.getPlsqlIndexTable(var1, var2);
    }

    public Datum[] getOraclePlsqlIndexTable(int var1) throws SQLException {
        return this.callableStatement.getOraclePlsqlIndexTable(var1);
    }

    public void setStringForClob(String var1, String var2) throws SQLException {
        this.callableStatement.setStringForClob(var1, var2);
    }

    public void setBytesForBlob(String var1, byte[] var2) throws SQLException {
        this.callableStatement.setBytesForBlob(var1, var2);
    }

    public boolean wasNull() throws SQLException {
        return this.callableStatement.wasNull();
    }

    public void registerOutParameter(int var1, int var2) throws SQLException {
        this.callableStatement.registerOutParameter(var1, var2);
    }

    public void registerOutParameter(int var1, int var2, int var3) throws SQLException {
        this.callableStatement.registerOutParameter(var1, var2, var3);
    }

    public void registerOutParameter(int var1, int var2, String var3) throws SQLException {
        this.callableStatement.registerOutParameter(var1, var2, var3);
    }

    public void registerOutParameter(String var1, int var2) throws SQLException {
        this.callableStatement.registerOutParameter(var1, var2);
    }

    public void registerOutParameter(String var1, int var2, int var3) throws SQLException {
        this.callableStatement.registerOutParameter(var1, var2, var3);
    }

    public void registerOutParameterAtName(String var1, int var2) throws SQLException {
        this.callableStatement.registerOutParameterAtName(var1, var2);
    }

    public void registerOutParameterAtName(String var1, int var2, int var3) throws SQLException {
        this.callableStatement.registerOutParameterAtName(var1, var2, var3);
    }

    public void registerOutParameterAtName(String var1, int var2, String var3) throws SQLException {
        this.callableStatement.registerOutParameterAtName(var1, var2, var3);
    }

    public byte[] privateGetBytes(int var1) throws SQLException {
        return ((oracle.jdbc.driver.OracleCallableStatement)this.callableStatement).privateGetBytes(var1);
    }

    public void setACProxy(Object var1) {
        this.acProxy = var1;
    }

    public Object getACProxy() {
        return this.acProxy;
    }
}
