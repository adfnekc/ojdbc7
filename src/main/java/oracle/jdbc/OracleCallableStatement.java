//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package oracle.jdbc;

import java.io.InputStream;
import java.io.Reader;
import java.math.BigDecimal;
import java.net.URL;
import java.sql.Array;
import java.sql.Blob;
import java.sql.CallableStatement;
import java.sql.Clob;
import java.sql.Date;
import java.sql.Ref;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Calendar;
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

public interface OracleCallableStatement extends CallableStatement, OraclePreparedStatement {
    ARRAY getARRAY(int var1) throws SQLException;

    InputStream getAsciiStream(int var1) throws SQLException;

    BFILE getBFILE(int var1) throws SQLException;

    BFILE getBfile(int var1) throws SQLException;

    InputStream getBinaryStream(int var1) throws SQLException;

    InputStream getBinaryStream(String var1) throws SQLException;

    BLOB getBLOB(int var1) throws SQLException;

    CHAR getCHAR(int var1) throws SQLException;

    Reader getCharacterStream(int var1) throws SQLException;

    CLOB getCLOB(int var1) throws SQLException;

    ResultSet getCursor(int var1) throws SQLException;

    /** @deprecated */
    Object getCustomDatum(int var1, CustomDatumFactory var2) throws SQLException;

    Object getORAData(int var1, ORADataFactory var2) throws SQLException;

    Object getObject(int var1, OracleDataFactory var2) throws SQLException;

    /** @deprecated */
    Object getAnyDataEmbeddedObject(int var1) throws SQLException;

    DATE getDATE(int var1) throws SQLException;

    NUMBER getNUMBER(int var1) throws SQLException;

    OPAQUE getOPAQUE(int var1) throws SQLException;

    Datum getOracleObject(int var1) throws SQLException;

    RAW getRAW(int var1) throws SQLException;

    REF getREF(int var1) throws SQLException;

    ROWID getROWID(int var1) throws SQLException;

    STRUCT getSTRUCT(int var1) throws SQLException;

    INTERVALYM getINTERVALYM(int var1) throws SQLException;

    INTERVALDS getINTERVALDS(int var1) throws SQLException;

    TIMESTAMP getTIMESTAMP(int var1) throws SQLException;

    TIMESTAMPTZ getTIMESTAMPTZ(int var1) throws SQLException;

    TIMESTAMPLTZ getTIMESTAMPLTZ(int var1) throws SQLException;

    InputStream getUnicodeStream(int var1) throws SQLException;

    InputStream getUnicodeStream(String var1) throws SQLException;

    void registerOutParameter(int var1, int var2, int var3, int var4) throws SQLException;

    /** @deprecated */
    void registerOutParameterBytes(int var1, int var2, int var3, int var4) throws SQLException;

    /** @deprecated */
    void registerOutParameterChars(int var1, int var2, int var3, int var4) throws SQLException;

    int sendBatch() throws SQLException;

    /** @deprecated */
    void setExecuteBatch(int var1) throws SQLException;

    Object getPlsqlIndexTable(int var1) throws SQLException;

    Object getPlsqlIndexTable(int var1, Class var2) throws SQLException;

    Datum[] getOraclePlsqlIndexTable(int var1) throws SQLException;

    void registerIndexTableOutParameter(int var1, int var2, int var3, int var4) throws SQLException;

    void setBinaryFloat(String var1, BINARY_FLOAT var2) throws SQLException;

    void setBinaryDouble(String var1, BINARY_DOUBLE var2) throws SQLException;

    void setStringForClob(String var1, String var2) throws SQLException;

    void setBytesForBlob(String var1, byte[] var2) throws SQLException;

    void registerOutParameter(String var1, int var2, int var3, int var4) throws SQLException;

    void setNull(String var1, int var2, String var3) throws SQLException;

    void setNull(String var1, int var2) throws SQLException;

    void setBoolean(String var1, boolean var2) throws SQLException;

    void setByte(String var1, byte var2) throws SQLException;

    void setShort(String var1, short var2) throws SQLException;

    void setInt(String var1, int var2) throws SQLException;

    void setLong(String var1, long var2) throws SQLException;

    void setFloat(String var1, float var2) throws SQLException;

    void setBinaryFloat(String var1, float var2) throws SQLException;

    void setBinaryDouble(String var1, double var2) throws SQLException;

    void setDouble(String var1, double var2) throws SQLException;

    void setBigDecimal(String var1, BigDecimal var2) throws SQLException;

    void setString(String var1, String var2) throws SQLException;

    void setFixedCHAR(String var1, String var2) throws SQLException;

    void setCursor(String var1, ResultSet var2) throws SQLException;

    void setROWID(String var1, ROWID var2) throws SQLException;

    void setRAW(String var1, RAW var2) throws SQLException;

    void setCHAR(String var1, CHAR var2) throws SQLException;

    void setDATE(String var1, DATE var2) throws SQLException;

    void setNUMBER(String var1, NUMBER var2) throws SQLException;

    void setBLOB(String var1, BLOB var2) throws SQLException;

    void setBlob(String var1, Blob var2) throws SQLException;

    void setCLOB(String var1, CLOB var2) throws SQLException;

    void setClob(String var1, Clob var2) throws SQLException;

    void setBFILE(String var1, BFILE var2) throws SQLException;

    void setBfile(String var1, BFILE var2) throws SQLException;

    void setBytes(String var1, byte[] var2) throws SQLException;

    void setDate(String var1, Date var2) throws SQLException;

    void setTime(String var1, Time var2) throws SQLException;

    void setTimestamp(String var1, Timestamp var2) throws SQLException;

    void setINTERVALYM(String var1, INTERVALYM var2) throws SQLException;

    void setINTERVALDS(String var1, INTERVALDS var2) throws SQLException;

    void setTIMESTAMP(String var1, TIMESTAMP var2) throws SQLException;

    void setTIMESTAMPTZ(String var1, TIMESTAMPTZ var2) throws SQLException;

    void setTIMESTAMPLTZ(String var1, TIMESTAMPLTZ var2) throws SQLException;

    void setAsciiStream(String var1, InputStream var2, int var3) throws SQLException;

    void setBinaryStream(String var1, InputStream var2, int var3) throws SQLException;

    void setUnicodeStream(String var1, InputStream var2, int var3) throws SQLException;

    void setCharacterStream(String var1, Reader var2, int var3) throws SQLException;

    void setDate(String var1, Date var2, Calendar var3) throws SQLException;

    void setTime(String var1, Time var2, Calendar var3) throws SQLException;

    void setTimestamp(String var1, Timestamp var2, Calendar var3) throws SQLException;

    void setURL(String var1, URL var2) throws SQLException;

    void setArray(String var1, Array var2) throws SQLException;

    void setARRAY(String var1, ARRAY var2) throws SQLException;

    void setOPAQUE(String var1, OPAQUE var2) throws SQLException;

    void setStructDescriptor(String var1, StructDescriptor var2) throws SQLException;

    void setSTRUCT(String var1, STRUCT var2) throws SQLException;

    void setCustomDatum(String var1, CustomDatum var2) throws SQLException;

    void setORAData(String var1, ORAData var2) throws SQLException;

    void setObject(String var1, Object var2, int var3, int var4) throws SQLException;

    void setObject(String var1, Object var2, int var3) throws SQLException;

    void setRefType(String var1, REF var2) throws SQLException;

    void setRef(String var1, Ref var2) throws SQLException;

    void setREF(String var1, REF var2) throws SQLException;

    void setObject(String var1, Object var2) throws SQLException;

    void setOracleObject(String var1, Datum var2) throws SQLException;

    void registerOutParameterAtName(String var1, int var2) throws SQLException;

    void registerOutParameterAtName(String var1, int var2, int var3) throws SQLException;

    void registerOutParameterAtName(String var1, int var2, String var3) throws SQLException;
}
