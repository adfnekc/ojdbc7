//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package oracle.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
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

public interface OracleResultSet extends ResultSet {
    ARRAY getARRAY(int var1) throws SQLException;

    ARRAY getARRAY(String var1) throws SQLException;

    BFILE getBfile(int var1) throws SQLException;

    BFILE getBFILE(int var1) throws SQLException;

    BFILE getBfile(String var1) throws SQLException;

    BFILE getBFILE(String var1) throws SQLException;

    BLOB getBLOB(int var1) throws SQLException;

    BLOB getBLOB(String var1) throws SQLException;

    CHAR getCHAR(int var1) throws SQLException;

    CHAR getCHAR(String var1) throws SQLException;

    CLOB getCLOB(int var1) throws SQLException;

    CLOB getCLOB(String var1) throws SQLException;

    OPAQUE getOPAQUE(int var1) throws SQLException;

    OPAQUE getOPAQUE(String var1) throws SQLException;

    INTERVALYM getINTERVALYM(int var1) throws SQLException;

    INTERVALYM getINTERVALYM(String var1) throws SQLException;

    INTERVALDS getINTERVALDS(int var1) throws SQLException;

    INTERVALDS getINTERVALDS(String var1) throws SQLException;

    TIMESTAMP getTIMESTAMP(int var1) throws SQLException;

    TIMESTAMP getTIMESTAMP(String var1) throws SQLException;

    TIMESTAMPTZ getTIMESTAMPTZ(int var1) throws SQLException;

    TIMESTAMPTZ getTIMESTAMPTZ(String var1) throws SQLException;

    TIMESTAMPLTZ getTIMESTAMPLTZ(int var1) throws SQLException;

    TIMESTAMPLTZ getTIMESTAMPLTZ(String var1) throws SQLException;

    ResultSet getCursor(int var1) throws SQLException;

    ResultSet getCursor(String var1) throws SQLException;

    /** @deprecated */
    CustomDatum getCustomDatum(int var1, CustomDatumFactory var2) throws SQLException;

    ORAData getORAData(int var1, ORADataFactory var2) throws SQLException;

    Object getObject(int var1, OracleDataFactory var2) throws SQLException;

    Object getObject(String var1, OracleDataFactory var2) throws SQLException;

    /** @deprecated */
    CustomDatum getCustomDatum(String var1, CustomDatumFactory var2) throws SQLException;

    ORAData getORAData(String var1, ORADataFactory var2) throws SQLException;

    DATE getDATE(int var1) throws SQLException;

    DATE getDATE(String var1) throws SQLException;

    NUMBER getNUMBER(int var1) throws SQLException;

    NUMBER getNUMBER(String var1) throws SQLException;

    Datum getOracleObject(int var1) throws SQLException;

    Datum getOracleObject(String var1) throws SQLException;

    RAW getRAW(int var1) throws SQLException;

    RAW getRAW(String var1) throws SQLException;

    REF getREF(int var1) throws SQLException;

    REF getREF(String var1) throws SQLException;

    ROWID getROWID(int var1) throws SQLException;

    ROWID getROWID(String var1) throws SQLException;

    STRUCT getSTRUCT(int var1) throws SQLException;

    STRUCT getSTRUCT(String var1) throws SQLException;

    void updateARRAY(int var1, ARRAY var2) throws SQLException;

    void updateARRAY(String var1, ARRAY var2) throws SQLException;

    void updateBfile(int var1, BFILE var2) throws SQLException;

    void updateBFILE(int var1, BFILE var2) throws SQLException;

    void updateBfile(String var1, BFILE var2) throws SQLException;

    void updateBFILE(String var1, BFILE var2) throws SQLException;

    void updateBLOB(int var1, BLOB var2) throws SQLException;

    void updateBLOB(String var1, BLOB var2) throws SQLException;

    void updateCHAR(int var1, CHAR var2) throws SQLException;

    void updateCHAR(String var1, CHAR var2) throws SQLException;

    void updateCLOB(int var1, CLOB var2) throws SQLException;

    void updateCLOB(String var1, CLOB var2) throws SQLException;

    /** @deprecated */
    void updateCustomDatum(int var1, CustomDatum var2) throws SQLException;

    void updateORAData(int var1, ORAData var2) throws SQLException;

    /** @deprecated */
    void updateCustomDatum(String var1, CustomDatum var2) throws SQLException;

    void updateORAData(String var1, ORAData var2) throws SQLException;

    void updateDATE(int var1, DATE var2) throws SQLException;

    void updateDATE(String var1, DATE var2) throws SQLException;

    void updateINTERVALYM(int var1, INTERVALYM var2) throws SQLException;

    void updateINTERVALYM(String var1, INTERVALYM var2) throws SQLException;

    void updateINTERVALDS(int var1, INTERVALDS var2) throws SQLException;

    void updateINTERVALDS(String var1, INTERVALDS var2) throws SQLException;

    void updateTIMESTAMP(int var1, TIMESTAMP var2) throws SQLException;

    void updateTIMESTAMP(String var1, TIMESTAMP var2) throws SQLException;

    void updateTIMESTAMPTZ(int var1, TIMESTAMPTZ var2) throws SQLException;

    void updateTIMESTAMPTZ(String var1, TIMESTAMPTZ var2) throws SQLException;

    void updateTIMESTAMPLTZ(int var1, TIMESTAMPLTZ var2) throws SQLException;

    void updateTIMESTAMPLTZ(String var1, TIMESTAMPLTZ var2) throws SQLException;

    void updateNUMBER(int var1, NUMBER var2) throws SQLException;

    void updateNUMBER(String var1, NUMBER var2) throws SQLException;

    void updateOracleObject(int var1, Datum var2) throws SQLException;

    void updateOracleObject(String var1, Datum var2) throws SQLException;

    void updateRAW(int var1, RAW var2) throws SQLException;

    void updateRAW(String var1, RAW var2) throws SQLException;

    void updateREF(int var1, REF var2) throws SQLException;

    void updateREF(String var1, REF var2) throws SQLException;

    void updateROWID(int var1, ROWID var2) throws SQLException;

    void updateROWID(String var1, ROWID var2) throws SQLException;

    void updateSTRUCT(int var1, STRUCT var2) throws SQLException;

    void updateSTRUCT(String var1, STRUCT var2) throws SQLException;

    OracleResultSet.AuthorizationIndicator getAuthorizationIndicator(int var1) throws SQLException;

    OracleResultSet.AuthorizationIndicator getAuthorizationIndicator(String var1) throws SQLException;

    public static enum AuthorizationIndicator {
        NONE,
        UNAUTHORIZED,
        UNKNOWN;

        private AuthorizationIndicator() {
        }
    }
}
