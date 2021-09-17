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
import java.sql.Clob;
import java.sql.Date;
import java.sql.NClob;
import java.sql.PreparedStatement;
import java.sql.Ref;
import java.sql.ResultSet;
import java.sql.RowId;
import java.sql.SQLException;
import java.sql.SQLXML;
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

public interface OraclePreparedStatement extends PreparedStatement, OracleStatement {
    short FORM_NCHAR = 2;
    short FORM_CHAR = 1;

    void defineParameterTypeBytes(int var1, int var2, int var3) throws SQLException;

    void defineParameterTypeChars(int var1, int var2, int var3) throws SQLException;

    void defineParameterType(int var1, int var2, int var3) throws SQLException;

    /** @deprecated */
    int getExecuteBatch();

    /** @deprecated */
    int sendBatch() throws SQLException;

    void setARRAY(int var1, ARRAY var2) throws SQLException;

    void setBfile(int var1, BFILE var2) throws SQLException;

    void setBFILE(int var1, BFILE var2) throws SQLException;

    void setBLOB(int var1, BLOB var2) throws SQLException;

    void setCHAR(int var1, CHAR var2) throws SQLException;

    void setCLOB(int var1, CLOB var2) throws SQLException;

    /** @deprecated */
    void setCursor(int var1, ResultSet var2) throws SQLException;

    /** @deprecated */
    void setCustomDatum(int var1, CustomDatum var2) throws SQLException;

    void setORAData(int var1, ORAData var2) throws SQLException;

    void setDATE(int var1, DATE var2) throws SQLException;

    /** @deprecated */
    void setExecuteBatch(int var1) throws SQLException;

    void setFixedCHAR(int var1, String var2) throws SQLException;

    void setNUMBER(int var1, NUMBER var2) throws SQLException;

    void setBinaryFloat(int var1, float var2) throws SQLException;

    void setBinaryFloat(int var1, BINARY_FLOAT var2) throws SQLException;

    void setBinaryDouble(int var1, double var2) throws SQLException;

    void setBinaryDouble(int var1, BINARY_DOUBLE var2) throws SQLException;

    void setOPAQUE(int var1, OPAQUE var2) throws SQLException;

    void setOracleObject(int var1, Datum var2) throws SQLException;

    void setStructDescriptor(int var1, StructDescriptor var2) throws SQLException;

    void setRAW(int var1, RAW var2) throws SQLException;

    void setREF(int var1, REF var2) throws SQLException;

    void setRefType(int var1, REF var2) throws SQLException;

    void setROWID(int var1, ROWID var2) throws SQLException;

    void setSTRUCT(int var1, STRUCT var2) throws SQLException;

    void setTIMESTAMP(int var1, TIMESTAMP var2) throws SQLException;

    void setTIMESTAMPTZ(int var1, TIMESTAMPTZ var2) throws SQLException;

    void setTIMESTAMPLTZ(int var1, TIMESTAMPLTZ var2) throws SQLException;

    void setINTERVALYM(int var1, INTERVALYM var2) throws SQLException;

    void setINTERVALDS(int var1, INTERVALDS var2) throws SQLException;

    void setNullAtName(String var1, int var2, String var3) throws SQLException;

    void setNullAtName(String var1, int var2) throws SQLException;

    void setBooleanAtName(String var1, boolean var2) throws SQLException;

    void setByteAtName(String var1, byte var2) throws SQLException;

    void setShortAtName(String var1, short var2) throws SQLException;

    void setIntAtName(String var1, int var2) throws SQLException;

    void setLongAtName(String var1, long var2) throws SQLException;

    void setFloatAtName(String var1, float var2) throws SQLException;

    void setDoubleAtName(String var1, double var2) throws SQLException;

    void setBinaryFloatAtName(String var1, float var2) throws SQLException;

    void setBinaryFloatAtName(String var1, BINARY_FLOAT var2) throws SQLException;

    void setBinaryDoubleAtName(String var1, double var2) throws SQLException;

    void setBinaryDoubleAtName(String var1, BINARY_DOUBLE var2) throws SQLException;

    void setBigDecimalAtName(String var1, BigDecimal var2) throws SQLException;

    void setStringAtName(String var1, String var2) throws SQLException;

    void setStringForClob(int var1, String var2) throws SQLException;

    void setStringForClobAtName(String var1, String var2) throws SQLException;

    void setFixedCHARAtName(String var1, String var2) throws SQLException;

    void setCursorAtName(String var1, ResultSet var2) throws SQLException;

    void setROWIDAtName(String var1, ROWID var2) throws SQLException;

    void setArrayAtName(String var1, Array var2) throws SQLException;

    void setARRAYAtName(String var1, ARRAY var2) throws SQLException;

    void setOPAQUEAtName(String var1, OPAQUE var2) throws SQLException;

    void setStructDescriptorAtName(String var1, StructDescriptor var2) throws SQLException;

    void setSTRUCTAtName(String var1, STRUCT var2) throws SQLException;

    void setRAWAtName(String var1, RAW var2) throws SQLException;

    void setCHARAtName(String var1, CHAR var2) throws SQLException;

    void setDATEAtName(String var1, DATE var2) throws SQLException;

    void setNUMBERAtName(String var1, NUMBER var2) throws SQLException;

    void setBLOBAtName(String var1, BLOB var2) throws SQLException;

    void setBlobAtName(String var1, Blob var2) throws SQLException;

    void setBlobAtName(String var1, InputStream var2, long var3) throws SQLException;

    void setBlobAtName(String var1, InputStream var2) throws SQLException;

    void setCLOBAtName(String var1, CLOB var2) throws SQLException;

    void setClobAtName(String var1, Clob var2) throws SQLException;

    void setClobAtName(String var1, Reader var2, long var3) throws SQLException;

    void setClobAtName(String var1, Reader var2) throws SQLException;

    void setBFILEAtName(String var1, BFILE var2) throws SQLException;

    void setBfileAtName(String var1, BFILE var2) throws SQLException;

    void setBytesAtName(String var1, byte[] var2) throws SQLException;

    void setBytesForBlob(int var1, byte[] var2) throws SQLException;

    void setBytesForBlobAtName(String var1, byte[] var2) throws SQLException;

    void setDateAtName(String var1, Date var2) throws SQLException;

    void setDateAtName(String var1, Date var2, Calendar var3) throws SQLException;

    void setTimeAtName(String var1, Time var2) throws SQLException;

    void setTimeAtName(String var1, Time var2, Calendar var3) throws SQLException;

    void setTimestampAtName(String var1, Timestamp var2) throws SQLException;

    void setTimestampAtName(String var1, Timestamp var2, Calendar var3) throws SQLException;

    void setINTERVALYMAtName(String var1, INTERVALYM var2) throws SQLException;

    void setINTERVALDSAtName(String var1, INTERVALDS var2) throws SQLException;

    void setTIMESTAMPAtName(String var1, TIMESTAMP var2) throws SQLException;

    void setTIMESTAMPTZAtName(String var1, TIMESTAMPTZ var2) throws SQLException;

    void setTIMESTAMPLTZAtName(String var1, TIMESTAMPLTZ var2) throws SQLException;

    void setAsciiStreamAtName(String var1, InputStream var2, int var3) throws SQLException;

    void setAsciiStreamAtName(String var1, InputStream var2, long var3) throws SQLException;

    void setAsciiStreamAtName(String var1, InputStream var2) throws SQLException;

    void setBinaryStreamAtName(String var1, InputStream var2, int var3) throws SQLException;

    void setBinaryStreamAtName(String var1, InputStream var2, long var3) throws SQLException;

    void setBinaryStreamAtName(String var1, InputStream var2) throws SQLException;

    void setCharacterStreamAtName(String var1, Reader var2, long var3) throws SQLException;

    void setCharacterStreamAtName(String var1, Reader var2) throws SQLException;

    void setUnicodeStreamAtName(String var1, InputStream var2, int var3) throws SQLException;

    void setCustomDatumAtName(String var1, CustomDatum var2) throws SQLException;

    void setORADataAtName(String var1, ORAData var2) throws SQLException;

    void setObjectAtName(String var1, Object var2, int var3, int var4) throws SQLException;

    void setObjectAtName(String var1, Object var2, int var3) throws SQLException;

    void setRefTypeAtName(String var1, REF var2) throws SQLException;

    void setRefAtName(String var1, Ref var2) throws SQLException;

    void setREFAtName(String var1, REF var2) throws SQLException;

    void setObjectAtName(String var1, Object var2) throws SQLException;

    void setOracleObjectAtName(String var1, Datum var2) throws SQLException;

    void setURLAtName(String var1, URL var2) throws SQLException;

    void setCheckBindTypes(boolean var1);

    void setPlsqlIndexTable(int var1, Object var2, int var3, int var4, int var5, int var6) throws SQLException;

    void setFormOfUse(int var1, short var2);

    void setDisableStmtCaching(boolean var1);

    OracleParameterMetaData OracleGetParameterMetaData() throws SQLException;

    void registerReturnParameter(int var1, int var2) throws SQLException;

    void registerReturnParameter(int var1, int var2, int var3) throws SQLException;

    void registerReturnParameter(int var1, int var2, String var3) throws SQLException;

    ResultSet getReturnResultSet() throws SQLException;

    void setNCharacterStreamAtName(String var1, Reader var2, long var3) throws SQLException;

    void setNCharacterStreamAtName(String var1, Reader var2) throws SQLException;

    void setNClobAtName(String var1, NClob var2) throws SQLException;

    void setNClobAtName(String var1, Reader var2, long var3) throws SQLException;

    void setNClobAtName(String var1, Reader var2) throws SQLException;

    void setNStringAtName(String var1, String var2) throws SQLException;

    void setRowIdAtName(String var1, RowId var2) throws SQLException;

    void setSQLXMLAtName(String var1, SQLXML var2) throws SQLException;
}
