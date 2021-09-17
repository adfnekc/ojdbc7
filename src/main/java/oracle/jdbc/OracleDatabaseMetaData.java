//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package oracle.jdbc;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.RowIdLifetime;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import oracle.jdbc.driver.DatabaseError;
import oracle.jdbc.driver.OracleSql;
import oracle.jdbc.internal.OracleConnection;
import oracle.jdbc.internal.OracleResultSet;
import oracle.sql.SQLName;
import oracle.sql.TypeDescriptor;

public class OracleDatabaseMetaData implements AdditionalDatabaseMetaData {
    private static String DRIVER_NAME = "Oracle JDBC driver";
    private static String DRIVER_VERSION = "12.1.0.1.0";
    private static int DRIVER_MAJOR_VERSION = 12;
    private static int DRIVER_MINOR_VERSION = 1;
    private static String LOB_MAXSIZE = "4294967295";
    private static long LOB_MAXLENGTH_32BIT = 4294967295L;
    protected OracleConnection connection;
    private static int DRIVER_API_MAJOR_VERSION = 4;
    private static int DRIVER_API_MINOR_VERSION = 1;
    int procedureResultUnknown = 0;
    int procedureNoResult = 1;
    int procedureReturnsResult = 2;
    int procedureColumnUnknown = 0;
    int procedureColumnIn = 1;
    int procedureColumnInOut = 2;
    int procedureColumnOut = 4;
    int procedureColumnReturn = 5;
    int procedureColumnResult = 3;
    int procedureNoNulls = 0;
    int procedureNullable = 1;
    int procedureNullableUnknown = 2;
    int columnNoNulls = 0;
    int columnNullable = 1;
    int columnNullableUnknown = 2;
    static final int bestRowTemporary = 0;
    static final int bestRowTransaction = 1;
    static final int bestRowSession = 2;
    static final int bestRowUnknown = 0;
    static final int bestRowNotPseudo = 1;
    static final int bestRowPseudo = 2;
    int versionColumnUnknown = 0;
    int versionColumnNotPseudo = 1;
    int versionColumnPseudo = 2;
    int importedKeyCascade = 0;
    int importedKeyRestrict = 1;
    int importedKeySetNull = 2;
    int typeNoNulls = 0;
    int typeNullable = 1;
    int typeNullableUnknown = 2;
    int typePredNone = 0;
    int typePredChar = 1;
    int typePredBasic = 2;
    int typeSearchable = 3;
    short tableIndexStatistic = 0;
    short tableIndexClustered = 1;
    short tableIndexHashed = 2;
    short tableIndexOther = 3;
    short attributeNoNulls = 0;
    short attributeNullable = 1;
    short attributeNullableUnknown = 2;
    int sqlStateXOpen = 1;
    int sqlStateSQL99 = 2;
    protected static final String sqlWildcardRegex = "^%|^_|[^/]%|[^/]_";
    protected static Pattern sqlWildcardPattern = null;
    protected static final String sqlEscapeRegex = "/";
    protected static Pattern sqlEscapePattern = null;
    private static final String _Copyright_2007_Oracle_All_Rights_Reserved_ = null;
    public static final String BUILD_DATE = "Thu_Apr_04_15:09:24_PDT_2013";
    public static final boolean TRACE = false;

    /** @deprecated */
    public OracleDatabaseMetaData(oracle.jdbc.OracleConnection var1) {
        this.connection = var1.physicalConnectionWithin();
    }

    public boolean allProceduresAreCallable() throws SQLException {
        return false;
    }

    public boolean allTablesAreSelectable() throws SQLException {
        return false;
    }

    public String getURL() throws SQLException {
        return this.connection.getURL();
    }

    public String getUserName() throws SQLException {
        return this.connection.getUserName();
    }

    public boolean isReadOnly() throws SQLException {
        return false;
    }

    public boolean nullsAreSortedHigh() throws SQLException {
        return false;
    }

    public boolean nullsAreSortedLow() throws SQLException {
        return true;
    }

    public boolean nullsAreSortedAtStart() throws SQLException {
        return false;
    }

    public boolean nullsAreSortedAtEnd() throws SQLException {
        return false;
    }

    public String getDatabaseProductName() throws SQLException {
        return "Oracle";
    }

    public String getDatabaseProductVersion() throws SQLException {
        return this.connection.getDatabaseProductVersion();
    }

    public String getDriverName() throws SQLException {
        return DRIVER_NAME;
    }

    public String getDriverVersion() throws SQLException {
        return DRIVER_VERSION;
    }

    public int getDriverMajorVersion() {
        return DRIVER_MAJOR_VERSION;
    }

    public int getDriverMinorVersion() {
        return DRIVER_MINOR_VERSION;
    }

    public boolean usesLocalFiles() throws SQLException {
        return false;
    }

    public boolean usesLocalFilePerTable() throws SQLException {
        return false;
    }

    public boolean supportsMixedCaseIdentifiers() throws SQLException {
        return false;
    }

    public boolean storesUpperCaseIdentifiers() throws SQLException {
        return true;
    }

    public boolean storesLowerCaseIdentifiers() throws SQLException {
        return false;
    }

    public boolean storesMixedCaseIdentifiers() throws SQLException {
        return false;
    }

    public boolean supportsMixedCaseQuotedIdentifiers() throws SQLException {
        return true;
    }

    public boolean storesUpperCaseQuotedIdentifiers() throws SQLException {
        return false;
    }

    public boolean storesLowerCaseQuotedIdentifiers() throws SQLException {
        return false;
    }

    public boolean storesMixedCaseQuotedIdentifiers() throws SQLException {
        return true;
    }

    public String getIdentifierQuoteString() throws SQLException {
        return "\"";
    }

    public String getSQLKeywords() throws SQLException {
        return "ACCESS, ADD, ALTER, AUDIT, CLUSTER, COLUMN, COMMENT, COMPRESS, CONNECT, DATE, DROP, EXCLUSIVE, FILE, IDENTIFIED, IMMEDIATE, INCREMENT, INDEX, INITIAL, INTERSECT, LEVEL, LOCK, LONG, MAXEXTENTS, MINUS, MODE, NOAUDIT, NOCOMPRESS, NOWAIT, NUMBER, OFFLINE, ONLINE, PCTFREE, PRIOR, all_PL_SQL_reserved_ words";
    }

    public String getNumericFunctions() throws SQLException {
        return "ABS,ACOS,ASIN,ATAN,ATAN2,CEILING,COS,EXP,FLOOR,LOG,LOG10,MOD,PI,POWER,ROUND,SIGN,SIN,SQRT,TAN,TRUNCATE";
    }

    public String getStringFunctions() throws SQLException {
        return "ASCII,CHAR,CHAR_LENGTH,CHARACTER_LENGTH,CONCAT,LCASE,LENGTH,LTRIM,OCTET_LENGTH,REPLACE,RTRIM,SOUNDEX,SUBSTRING,UCASE";
    }

    public String getSystemFunctions() throws SQLException {
        return "USER";
    }

    public String getTimeDateFunctions() throws SQLException {
        return "CURRENT_DATE,CURRENT_TIMESTAMP,CURDATE,EXTRACT,HOUR,MINUTE,MONTH,SECOND,YEAR";
    }

    public String getSearchStringEscape() throws SQLException {
        return "/";
    }

    public String getExtraNameCharacters() throws SQLException {
        return "$#";
    }

    public boolean supportsAlterTableWithAddColumn() throws SQLException {
        return true;
    }

    public boolean supportsAlterTableWithDropColumn() throws SQLException {
        return false;
    }

    public boolean supportsColumnAliasing() throws SQLException {
        return true;
    }

    public boolean nullPlusNonNullIsNull() throws SQLException {
        return true;
    }

    public boolean supportsConvert() throws SQLException {
        return false;
    }

    public boolean supportsConvert(int var1, int var2) throws SQLException {
        return false;
    }

    public boolean supportsTableCorrelationNames() throws SQLException {
        return true;
    }

    public boolean supportsDifferentTableCorrelationNames() throws SQLException {
        return true;
    }

    public boolean supportsExpressionsInOrderBy() throws SQLException {
        return true;
    }

    public boolean supportsOrderByUnrelated() throws SQLException {
        return true;
    }

    public boolean supportsGroupBy() throws SQLException {
        return true;
    }

    public boolean supportsGroupByUnrelated() throws SQLException {
        return true;
    }

    public boolean supportsGroupByBeyondSelect() throws SQLException {
        return true;
    }

    public boolean supportsLikeEscapeClause() throws SQLException {
        return true;
    }

    public boolean supportsMultipleResultSets() throws SQLException {
        return false;
    }

    public boolean supportsMultipleTransactions() throws SQLException {
        return true;
    }

    public boolean supportsNonNullableColumns() throws SQLException {
        return true;
    }

    public boolean supportsMinimumSQLGrammar() throws SQLException {
        return true;
    }

    public boolean supportsCoreSQLGrammar() throws SQLException {
        return true;
    }

    public boolean supportsExtendedSQLGrammar() throws SQLException {
        return true;
    }

    public boolean supportsANSI92EntryLevelSQL() throws SQLException {
        return true;
    }

    public boolean supportsANSI92IntermediateSQL() throws SQLException {
        return false;
    }

    public boolean supportsANSI92FullSQL() throws SQLException {
        return false;
    }

    public boolean supportsIntegrityEnhancementFacility() throws SQLException {
        return true;
    }

    public boolean supportsOuterJoins() throws SQLException {
        return true;
    }

    public boolean supportsFullOuterJoins() throws SQLException {
        return true;
    }

    public boolean supportsLimitedOuterJoins() throws SQLException {
        return true;
    }

    public String getSchemaTerm() throws SQLException {
        return "schema";
    }

    public String getProcedureTerm() throws SQLException {
        return "procedure";
    }

    public String getCatalogTerm() throws SQLException {
        return "";
    }

    public boolean isCatalogAtStart() throws SQLException {
        return false;
    }

    public String getCatalogSeparator() throws SQLException {
        return "";
    }

    public boolean supportsSchemasInDataManipulation() throws SQLException {
        return true;
    }

    public boolean supportsSchemasInProcedureCalls() throws SQLException {
        return true;
    }

    public boolean supportsSchemasInTableDefinitions() throws SQLException {
        return true;
    }

    public boolean supportsSchemasInIndexDefinitions() throws SQLException {
        return true;
    }

    public boolean supportsSchemasInPrivilegeDefinitions() throws SQLException {
        return true;
    }

    public boolean supportsCatalogsInDataManipulation() throws SQLException {
        return false;
    }

    public boolean supportsCatalogsInProcedureCalls() throws SQLException {
        return false;
    }

    public boolean supportsCatalogsInTableDefinitions() throws SQLException {
        return false;
    }

    public boolean supportsCatalogsInIndexDefinitions() throws SQLException {
        return false;
    }

    public boolean supportsCatalogsInPrivilegeDefinitions() throws SQLException {
        return false;
    }

    public boolean supportsPositionedDelete() throws SQLException {
        return false;
    }

    public boolean supportsPositionedUpdate() throws SQLException {
        return false;
    }

    public boolean supportsSelectForUpdate() throws SQLException {
        return true;
    }

    public boolean supportsStoredProcedures() throws SQLException {
        return true;
    }

    public boolean supportsSubqueriesInComparisons() throws SQLException {
        return true;
    }

    public boolean supportsSubqueriesInExists() throws SQLException {
        return true;
    }

    public boolean supportsSubqueriesInIns() throws SQLException {
        return true;
    }

    public boolean supportsSubqueriesInQuantifieds() throws SQLException {
        return true;
    }

    public boolean supportsCorrelatedSubqueries() throws SQLException {
        return true;
    }

    public boolean supportsUnion() throws SQLException {
        return true;
    }

    public boolean supportsUnionAll() throws SQLException {
        return true;
    }

    public boolean supportsOpenCursorsAcrossCommit() throws SQLException {
        return false;
    }

    public boolean supportsOpenCursorsAcrossRollback() throws SQLException {
        return false;
    }

    public boolean supportsOpenStatementsAcrossCommit() throws SQLException {
        return false;
    }

    public boolean supportsOpenStatementsAcrossRollback() throws SQLException {
        return false;
    }

    public int getMaxBinaryLiteralLength() throws SQLException {
        return 1000;
    }

    public int getMaxCharLiteralLength() throws SQLException {
        return 2000;
    }

    public int getMaxColumnNameLength() throws SQLException {
        return 30;
    }

    public int getMaxColumnsInGroupBy() throws SQLException {
        return 0;
    }

    public int getMaxColumnsInIndex() throws SQLException {
        return 32;
    }

    public int getMaxColumnsInOrderBy() throws SQLException {
        return 0;
    }

    public int getMaxColumnsInSelect() throws SQLException {
        return 0;
    }

    public int getMaxColumnsInTable() throws SQLException {
        return 1000;
    }

    public int getMaxConnections() throws SQLException {
        return 0;
    }

    public int getMaxCursorNameLength() throws SQLException {
        return 0;
    }

    public int getMaxIndexLength() throws SQLException {
        return 0;
    }

    public int getMaxSchemaNameLength() throws SQLException {
        return 30;
    }

    public int getMaxProcedureNameLength() throws SQLException {
        return 30;
    }

    public int getMaxCatalogNameLength() throws SQLException {
        return 0;
    }

    public int getMaxRowSize() throws SQLException {
        return 0;
    }

    public boolean doesMaxRowSizeIncludeBlobs() throws SQLException {
        return true;
    }

    public int getMaxStatementLength() throws SQLException {
        return 65535;
    }

    public int getMaxStatements() throws SQLException {
        return 0;
    }

    public int getMaxTableNameLength() throws SQLException {
        return 30;
    }

    public int getMaxTablesInSelect() throws SQLException {
        return 0;
    }

    public int getMaxUserNameLength() throws SQLException {
        return 30;
    }

    public int getDefaultTransactionIsolation() throws SQLException {
        return 2;
    }

    public boolean supportsTransactions() throws SQLException {
        return true;
    }

    public boolean supportsTransactionIsolationLevel(int var1) throws SQLException {
        return var1 == 2 || var1 == 8;
    }

    public boolean supportsDataDefinitionAndDataManipulationTransactions() throws SQLException {
        return true;
    }

    public boolean supportsDataManipulationTransactionsOnly() throws SQLException {
        return true;
    }

    public boolean dataDefinitionCausesTransactionCommit() throws SQLException {
        return true;
    }

    public boolean dataDefinitionIgnoredInTransactions() throws SQLException {
        return false;
    }

    public synchronized ResultSet getProcedures(String var1, String var2, String var3) throws SQLException {
        String var4 = "SELECT\n  -- Standalone procedures and functions\n  NULL AS procedure_cat,\n  owner AS procedure_schem,\n  object_name AS procedure_name,\n  NULL,\n  NULL,\n  NULL,\n  'Standalone procedure or function' AS remarks,\n  DECODE(object_type, 'PROCEDURE', 1,\n                      'FUNCTION', 2,\n                      0) AS procedure_type\n,  NULL AS specific_name\nFROM all_objects\nWHERE (object_type = 'PROCEDURE' OR object_type = 'FUNCTION')\n  AND owner LIKE :1 ESCAPE '/'\n  AND object_name LIKE :2 ESCAPE '/'\n";
        String var5 = "SELECT\n  -- Packaged procedures with no arguments\n  package_name AS procedure_cat,\n  owner AS procedure_schem,\n  object_name AS procedure_name,\n  NULL,\n  NULL,\n  NULL,\n  'Packaged procedure' AS remarks,\n  1 AS procedure_type\n,  NULL AS specific_name\nFROM all_arguments\nWHERE argument_name IS NULL\n  AND data_type IS NULL\n  AND ";
        String var6 = "SELECT\n  -- Packaged procedures with arguments\n  package_name AS procedure_cat,\n  owner AS procedure_schem,\n  object_name AS procedure_name,\n  NULL,\n  NULL,\n  NULL,\n  'Packaged procedure' AS remarks,\n  1 AS procedure_type\n,  NULL AS specific_name\nFROM all_arguments\nWHERE argument_name IS NOT NULL\n  AND position = 1\n  AND position = sequence\n  AND ";
        String var7 = "SELECT\n  -- Packaged functions\n  package_name AS procedure_cat,\n  owner AS procedure_schem,\n  object_name AS procedure_name,\n  NULL,\n  NULL,\n  NULL,\n  'Packaged function' AS remarks,\n  2 AS procedure_type\n,  NULL AS specific_name\nFROM all_arguments\nWHERE argument_name IS NULL\n  AND in_out = 'OUT'\n  AND   data_level = 0\n  AND ";
        String var8 = "package_name LIKE :3 ESCAPE '/'\n  AND owner LIKE :4 ESCAPE '/'\n  AND object_name LIKE :5 ESCAPE '/'\n";
        String var9 = "package_name IS NOT NULL\n  AND owner LIKE :6 ESCAPE '/'\n  AND object_name LIKE :7 ESCAPE '/'\n";
        String var10 = "ORDER BY procedure_schem, procedure_name\n";
        PreparedStatement var11 = null;
        String var12 = null;
        String var13 = var2;
        if (var2 == null) {
            var13 = "%";
        } else if (var2.equals("")) {
            var13 = this.getUserName().toUpperCase();
        }

        String var14 = var3;
        if (var3 == null) {
            var14 = "%";
        } else if (var3.equals("")) {
            SQLException var16 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 74);
            var16.fillInStackTrace();
            throw var16;
        }

        if (var1 == null) {
            var12 = var4 + "UNION ALL " + var5 + var9 + "UNION ALL " + var6 + var9 + "UNION ALL " + var7 + var9 + var10;
            var11 = this.connection.prepareStatement(var12);
            var11.setString(1, var13);
            var11.setString(2, var14);
            var11.setString(3, var13);
            var11.setString(4, var14);
            var11.setString(5, var13);
            var11.setString(6, var14);
            var11.setString(7, var13);
            var11.setString(8, var14);
        } else if (var1.equals("")) {
            var11 = this.connection.prepareStatement(var4);
            var11.setString(1, var13);
            var11.setString(2, var14);
        } else {
            var12 = var5 + var8 + "UNION ALL " + var6 + var8 + "UNION ALL " + var7 + var8 + var10;
            var11 = this.connection.prepareStatement(var12);
            var11.setString(1, var1);
            var11.setString(2, var13);
            var11.setString(3, var14);
            var11.setString(4, var1);
            var11.setString(5, var13);
            var11.setString(6, var14);
            var11.setString(7, var1);
            var11.setString(8, var13);
            var11.setString(9, var14);
        }

        OracleResultSet var15 = (OracleResultSet)var11.executeQuery();
        var15.closeStatementOnClose();
        return var15;
    }

    public synchronized ResultSet getProcedureColumns(String var1, String var2, String var3, String var4) throws SQLException {
        boolean var5 = this.connection.getIncludeSynonyms();
        if ("".equals(var1) && (var2 == null || !this.hasSqlWildcard(var2)) && var3 != null && !this.hasSqlWildcard(var3)) {
            return this.getUnpackagedProcedureColumnsNoWildcards(var2 != null ? this.stripSqlEscapes(var2) : null, var3 != null ? this.stripSqlEscapes(var3) : null, var4);
        } else {
            return var1 == null || var1.length() == 0 || this.hasSqlWildcard(var1) || var2 != null && this.hasSqlWildcard(var2) ? this.getProcedureColumnsWithWildcards(var1, var2, var3, var4, var5) : this.getPackagedProcedureColumnsNoWildcards(var1 != null ? this.stripSqlEscapes(var1) : null, var2 != null ? this.stripSqlEscapes(var2) : null, var3, var4);
        }
    }

    ResultSet getUnpackagedProcedureColumnsNoWildcards(String var1, String var2, String var3) throws SQLException {
        if ("".equals(var3)) {
            SQLException var12 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 74);
            var12.fillInStackTrace();
            throw var12;
        } else {
            String var4 = this.getUnpackagedProcedureColumnsNoWildcardsPlsql();
            CallableStatement var5 = null;
            ResultSet var6 = null;

            try {
                var5 = this.connection.prepareCall(var4);
                var5.setString(1, var1);
                var5.setString(2, var2);
                var5.setString(3, var3 == null ? "%" : var3);
                var5.registerOutParameter(4, -10);
                var5.registerOutParameter(5, 2);
                var5.execute();
                int var7 = var5.getInt(5);
                if (var7 != 0) {
                    SQLException var8 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 258);
                    var8.fillInStackTrace();
                    throw var8;
                }

                var6 = ((OracleCallableStatement)var5).getCursor(4);
                ((OracleResultSet)var6).closeStatementOnClose();
            } finally {
                if (var6 == null && var5 != null) {
                    var5.close();
                }

            }

            return var6;
        }
    }

    ResultSet getPackagedProcedureColumnsNoWildcards(String var1, String var2, String var3, String var4) throws SQLException {
        if ("".equals(var4)) {
            SQLException var13 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 74);
            var13.fillInStackTrace();
            throw var13;
        } else {
            String var5 = this.getPackagedProcedureColumnsNoWildcardsPlsql();
            CallableStatement var6 = null;
            ResultSet var7 = null;

            try {
                var6 = this.connection.prepareCall(var5);
                var6.setString(1, var1);
                var6.setString(2, var2);
                var6.setString(3, var3);
                var6.setString(4, var4 == null ? "%" : var4);
                var6.registerOutParameter(5, -10);
                var6.registerOutParameter(6, 2);
                var6.execute();
                int var8 = var6.getInt(6);
                if (var8 != 0) {
                    SQLException var9 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 258);
                    var9.fillInStackTrace();
                    throw var9;
                }

                var7 = ((OracleCallableStatement)var6).getCursor(5);
                ((OracleResultSet)var7).closeStatementOnClose();
            } finally {
                if (var7 == null && var6 != null) {
                    var6.close();
                }

            }

            return var7;
        }
    }

    ResultSet getProcedureColumnsWithWildcards(String var1, String var2, String var3, String var4, boolean var5) throws SQLException {
        String var6 = "SELECT package_name AS procedure_cat,\n       owner AS procedure_schem,\n       object_name AS procedure_name,\n       argument_name AS column_name,\n       DECODE(position, 0, 5,\n                        DECODE(in_out, 'IN', 1,\n                                       'OUT', 4,\n                                       'IN/OUT', 2,\n                                       0)) AS column_type,\n       DECODE (data_type, 'CHAR', 1,\n                          'VARCHAR2', 12,\n                          'NUMBER', 3,\n                          'LONG', -1,\n                          'DATE', " + (this.connection.getMapDateToTimestamp() ? "93,\n" : "91,\n") + "                          'RAW', -3,\n" + "                          'LONG RAW', -4,\n" + "                          'TIMESTAMP', 93, \n" + "                          'TIMESTAMP WITH TIME ZONE', -101, \n" + "               'TIMESTAMP WITH LOCAL TIME ZONE', -102, \n" + "               'INTERVAL YEAR TO MONTH', -103, \n" + "               'INTERVAL DAY TO SECOND', -104, \n" + "               'BINARY_FLOAT', 100, 'BINAvRY_DOUBLE', 101," + "               1111) AS data_type,\n" + "       DECODE(data_type, 'OBJECT', type_owner || '.' || type_name, " + "              data_type) AS type_name,\n" + "       DECODE (data_precision, NULL, data_length,\n" + "                               data_precision) AS precision,\n" + "       data_length AS length,\n" + "       data_scale AS scale,\n" + "       10 AS radix,\n" + "       1 AS nullable,\n" + "       NULL AS remarks,\n" + "       default_value AS column_def,\n" + "       NULL as sql_data_type,\n" + "       NULL AS sql_datetime_sub,\n" + "       DECODE(data_type,\n" + "                         'CHAR', 32767,\n" + "                         'VARCHAR2', 32767,\n" + "                         'LONG', 32767,\n" + "                         'RAW', 32767,\n" + "                         'LONG RAW', 32767,\n" + "                         NULL) AS char_octet_length,\n" + "       (sequence - 1) AS ordinal_position,\n" + "       'YES' AS is_nullable,\n" + "       NULL AS specific_name,\n" + "       sequence,\n" + "       overload,\n" + "       default_value\n" + " FROM all_arguments\n" + "WHERE owner LIKE :1 ESCAPE '/'\n" + "  AND object_name LIKE :2 ESCAPE '/' AND data_level = 0\n";
        String var7 = "  AND package_name LIKE :3 ESCAPE '/'\n";
        String var8 = "  AND package_name IS NULL\n";
        String var9 = "  AND argument_name LIKE :4 ESCAPE '/'\n";
        String var10 = "  AND (argument_name LIKE :5 ESCAPE '/'\n       OR (argument_name IS NULL\n           AND data_type IS NOT NULL))\n";
        String var11 = "ORDER BY procedure_schem, procedure_name, overload, sequence\n";
        String var12 = null;
        PreparedStatement var13 = null;
        String var14 = null;
        String var15 = var2;
        if (var2 == null) {
            var15 = "%";
        } else if (var2.equals("")) {
            var15 = this.getUserName().toUpperCase();
        }

        String var16 = var3;
        if (var3 == null) {
            var16 = "%";
        } else if (var3.equals("")) {
            SQLException var20 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 74);
            var20.fillInStackTrace();
            throw var20;
        }

        String var17 = var4;
        if (var4 != null && !var4.equals("%")) {
            if (var4.equals("")) {
                SQLException var19 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 74);
                var19.fillInStackTrace();
                throw var19;
            }

            var14 = var9;
        } else {
            var17 = "%";
            var14 = var10;
        }

        if (var1 == null) {
            var12 = var6 + var14 + var11;
            var13 = this.connection.prepareStatement(var12);
            var13.setString(1, var15);
            var13.setString(2, var16);
            var13.setString(3, var17);
        } else if (var1.equals("")) {
            var12 = var6 + var8 + var14 + var11;
            var13 = this.connection.prepareStatement(var12);
            var13.setString(1, var15);
            var13.setString(2, var16);
            var13.setString(3, var17);
        } else {
            var12 = var6 + var7 + var14 + var11;
            var13 = this.connection.prepareStatement(var12);
            var13.setString(1, var15);
            var13.setString(2, var16);
            var13.setString(3, var1);
            var13.setString(4, var17);
        }

        OracleResultSet var18 = (OracleResultSet)var13.executeQuery();
        var18.closeStatementOnClose();
        return var18;
    }

    public ResultSet getFunctionColumns(String var1, String var2, String var3, String var4) throws SQLException {
        String var5 = "SELECT package_name AS function_cat,\n       arg.owner AS function_schem,\n       arg.object_name AS function_name,\n       arg.argument_name AS column_name,\n       DECODE(arg.position, 0, 5,\n                        DECODE(arg.in_out, 'IN', 1,\n                                       'OUT', 4,\n                                       'IN/OUT', 2,\n                                       0)) AS column_type,\n       DECODE (arg.data_type, 'CHAR', 1,\n                          'VARCHAR2', 12,\n                          'NUMBER', 3,\n                          'LONG', -1,\n                          'DATE', " + (this.connection.getMapDateToTimestamp() ? "93,\n" : "91,\n") + "                          'RAW', -3,\n" + "                          'LONG RAW', -4,\n" + "                          'TIMESTAMP', 93, \n" + "                          'TIMESTAMP WITH TIME ZONE', -101, \n" + "               'TIMESTAMP WITH LOCAL TIME ZONE', -102, \n" + "               'INTERVAL YEAR TO MONTH', -103, \n" + "               'INTERVAL DAY TO SECOND', -104, \n" + "               'BINARY_FLOAT', 100, 'BINAvRY_DOUBLE', 101," + "               1111) AS data_type,\n" + "       DECODE(arg.data_type, 'OBJECT', arg.type_owner || '.' || arg.type_name, " + "              arg.data_type) AS type_name,\n" + "       DECODE (arg.data_precision, NULL, arg.data_length,\n" + "                               arg.data_precision) AS precision,\n" + "       arg.data_length AS length,\n" + "       arg.data_scale AS scale,\n" + "       10 AS radix,\n" + "       1 AS nullable,\n" + "       NULL AS remarks,\n" + "       arg.default_value AS column_def,\n" + "       NULL as sql_data_type,\n" + "       NULL AS sql_datetime_sub,\n" + "       DECODE(arg.data_type,\n" + "                         'CHAR', 32767,\n" + "                         'VARCHAR2', 32767,\n" + "                         'LONG', 32767,\n" + "                         'RAW', 32767,\n" + "                         'LONG RAW', 32767,\n" + "                         NULL) AS char_octet_length,\n" + "       (arg.sequence - 1) AS ordinal_position,\n" + "       'YES' AS is_nullable,\n" + "       NULL AS specific_name,\n" + "       arg.sequence,\n" + "       arg.overload,\n" + "       arg.default_value\n" + " FROM all_arguments arg, all_procedures proc\n" + " WHERE arg.owner LIKE :1 ESCAPE '/'\n" + "  AND arg.object_name LIKE :2 ESCAPE '/'\n";
        short var6 = this.connection.getVersionNumber();
        String var7 = var6 >= 10200 ? "  AND proc.object_id = arg.object_id\n  AND proc.object_type = 'FUNCTION'\n" : "  AND proc.owner = arg.owner\n  AND proc.object_name = arg.object_name\n";
        String var8 = "  AND arg.package_name LIKE :3 ESCAPE '/'\n";
        String var9 = "  AND arg.package_name IS NULL\n";
        String var10 = "  AND arg.argument_name LIKE :4 ESCAPE '/'\n";
        String var11 = "  AND (arg.argument_name LIKE :5 ESCAPE '/'\n     OR (arg.argument_name IS NULL\n         AND arg.data_type IS NOT NULL))\n";
        String var12 = "ORDER BY function_schem, function_name, overload, sequence\n";
        String var13 = null;
        PreparedStatement var14 = null;
        String var15 = null;
        String var16 = var2;
        if (var2 == null) {
            var16 = "%";
        } else if (var2.equals("")) {
            var16 = this.getUserName().toUpperCase();
        }

        String var17 = var3;
        if (var3 == null) {
            var17 = "%";
        } else if (var3.equals("")) {
            SQLException var21 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 74);
            var21.fillInStackTrace();
            throw var21;
        }

        String var18 = var4;
        if (var4 != null && !var4.equals("%")) {
            if (var4.equals("")) {
                SQLException var20 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 74);
                var20.fillInStackTrace();
                throw var20;
            }

            var15 = var10;
        } else {
            var18 = "%";
            var15 = var11;
        }

        if (var1 == null) {
            var13 = var5 + var7 + var15 + var12;
            var14 = this.connection.prepareStatement(var13);
            var14.setString(1, var16);
            var14.setString(2, var17);
            var14.setString(3, var18);
        } else if (var1.equals("")) {
            var13 = var5 + var7 + var9 + var15 + var12;
            var14 = this.connection.prepareStatement(var13);
            var14.setString(1, var16);
            var14.setString(2, var17);
            var14.setString(3, var18);
        } else {
            var13 = var5 + var7 + var8 + var15 + var12;
            var14 = this.connection.prepareStatement(var13);
            var14.setString(1, var16);
            var14.setString(2, var17);
            var14.setString(3, var1);
            var14.setString(4, var18);
        }

        OracleResultSet var19 = (OracleResultSet)var14.executeQuery();
        var19.closeStatementOnClose();
        return var19;
    }

    public synchronized ResultSet getTables(String var1, String var2, String var3, String[] var4) throws SQLException {
        String var5 = "SELECT NULL AS table_cat,\n       o.owner AS table_schem,\n       o.object_name AS table_name,\n       o.object_type AS table_type,\n";
        String var6 = "       c.comments AS remarks\n";
        String var7 = "       NULL AS remarks\n";
        String var8 = "  FROM all_objects o, all_tab_comments c\n";
        String var9 = "  FROM all_objects o\n";
        String var10 = "  WHERE o.owner LIKE :1 ESCAPE '/'\n    AND o.object_name LIKE :2 ESCAPE '/'\n";
        String var11 = "    AND o.owner = c.owner (+)\n    AND o.object_name = c.table_name (+)\n";
        boolean var12 = false;
        String var13 = "";
        String var14 = "";
        if (var4 != null) {
            var13 = "    AND o.object_type IN ('xxx'";
            var14 = "    AND o.object_type IN ('xxx'";

            for(int var15 = 0; var15 < var4.length; ++var15) {
                if (var4[var15].equals("SYNONYM")) {
                    var13 = var13 + ", '" + var4[var15] + "'";
                    var12 = true;
                } else {
                    var13 = var13 + ", '" + var4[var15] + "'";
                    var14 = var14 + ", '" + var4[var15] + "'";
                }
            }

            var13 = var13 + ")\n";
            var14 = var14 + ")\n";
        } else {
            var12 = true;
            var13 = "    AND o.object_type IN ('TABLE', 'SYNONYM', 'VIEW')\n";
            var14 = "    AND o.object_type IN ('TABLE', 'VIEW')\n";
        }

        String var25 = "  ORDER BY table_type, table_schem, table_name\n";
        String var16 = "SELECT NULL AS table_cat,\n       s.owner AS table_schem,\n       s.synonym_name AS table_name,\n       'SYNONYM' AS table_table_type,\n";
        String var17 = "       c.comments AS remarks\n";
        String var18 = "       NULL AS remarks\n";
        String var19 = "  FROM all_synonyms s, all_objects o, all_tab_comments c\n";
        String var20 = "  FROM all_synonyms s, all_objects o\n";
        String var21 = "  WHERE s.owner LIKE :3 ESCAPE '/'\n    AND s.synonym_name LIKE :4 ESCAPE '/'\n    AND s.table_owner = o.owner\n    AND s.table_name = o.object_name\n    AND o.object_type IN ('TABLE', 'VIEW')\n";
        String var22 = "";
        var22 = var22 + var5;
        if (this.connection.getRemarksReporting()) {
            var22 = var22 + var6 + var8;
        } else {
            var22 = var22 + var7 + var9;
        }

        var22 = var22 + var10;
        if (this.connection.getRestrictGetTables()) {
            var22 = var22 + var14;
        } else {
            var22 = var22 + var13;
        }

        if (this.connection.getRemarksReporting()) {
            var22 = var22 + var11;
        }

        if (var12 && this.connection.getRestrictGetTables()) {
            var22 = var22 + "UNION\n" + var16;
            if (this.connection.getRemarksReporting()) {
                var22 = var22 + var17 + var19;
            } else {
                var22 = var22 + var18 + var20;
            }

            var22 = var22 + var21;
            if (this.connection.getRemarksReporting()) {
                var22 = var22 + var11;
            }
        }

        var22 = var22 + var25;
        PreparedStatement var23 = this.connection.prepareStatement(var22);
        var23.setString(1, var2 == null ? "%" : var2);
        var23.setString(2, var3 == null ? "%" : var3);
        if (var12 && this.connection.getRestrictGetTables()) {
            var23.setString(3, var2 == null ? "%" : var2);
            var23.setString(4, var3 == null ? "%" : var3);
        }

        OracleResultSet var24 = (OracleResultSet)var23.executeQuery();
        var24.closeStatementOnClose();
        return var24;
    }

    public ResultSet getSchemas() throws SQLException {
        Statement var1 = this.connection.createStatement();
        String var2 = "SELECT username AS table_schem,null as table_catalog  FROM all_users ORDER BY table_schem";
        OracleResultSet var3 = (OracleResultSet)var1.executeQuery(var2);
        var3.closeStatementOnClose();
        return var3;
    }

    public ResultSet getCatalogs() throws SQLException {
        Statement var1 = this.connection.createStatement();
        String var2 = "select 'nothing' as table_cat from dual where 1 = 2";
        OracleResultSet var3 = (OracleResultSet)var1.executeQuery(var2);
        var3.closeStatementOnClose();
        return var3;
    }

    public ResultSet getTableTypes() throws SQLException {
        Statement var1 = this.connection.createStatement();
        String var2 = "select 'TABLE' as table_type from dual\nunion select 'VIEW' as table_type from dual\nunion select 'SYNONYM' as table_type from dual\n";
        OracleResultSet var3 = (OracleResultSet)var1.executeQuery(var2);
        var3.closeStatementOnClose();
        return var3;
    }

    public ResultSet getColumns(String var1, String var2, String var3, String var4) throws SQLException {
        SQLException var5 = DatabaseError.createUnsupportedFeatureSqlException();
        var5.fillInStackTrace();
        throw var5;
    }

    public synchronized ResultSet getColumnPrivileges(String var1, String var2, String var3, String var4) throws SQLException {
        PreparedStatement var5 = this.connection.prepareStatement("SELECT NULL AS table_cat,\n       table_schema AS table_schem,\n       table_name,\n       column_name,\n       grantor,\n       grantee,\n       privilege,\n       grantable AS is_grantable\nFROM all_col_privs\nWHERE table_schema LIKE :1 ESCAPE '/'\n  AND table_name LIKE :2 ESCAPE '/'\n  AND column_name LIKE :3 ESCAPE '/'\nORDER BY column_name, privilege\n");
        var5.setString(1, var2 == null ? "%" : var2);
        var5.setString(2, var3 == null ? "%" : var3);
        var5.setString(3, var4 == null ? "%" : var4);
        OracleResultSet var6 = (OracleResultSet)var5.executeQuery();
        var6.closeStatementOnClose();
        return var6;
    }

    public synchronized ResultSet getTablePrivileges(String var1, String var2, String var3) throws SQLException {
        PreparedStatement var4 = this.connection.prepareStatement("SELECT NULL AS table_cat,\n       table_schema AS table_schem,\n       table_name,\n       grantor,\n       grantee,\n       privilege,\n       grantable AS is_grantable\nFROM all_tab_privs\nWHERE table_schema LIKE :1 ESCAPE '/'\n  AND table_name LIKE :2 ESCAPE '/'\nORDER BY table_schem, table_name, privilege\n");
        var4.setString(1, var2 == null ? "%" : var2);
        var4.setString(2, var3 == null ? "%" : var3);
        OracleResultSet var5 = (OracleResultSet)var4.executeQuery();
        var5.closeStatementOnClose();
        return var5;
    }

    public synchronized ResultSet getBestRowIdentifier(String var1, String var2, String var3, int var4, boolean var5) throws SQLException {
        PreparedStatement var6 = this.connection.prepareStatement("SELECT 1 AS scope, 'ROWID' AS column_name, -8 AS data_type,\n 'ROWID' AS type_name, 0 AS column_size, 0 AS buffer_length,\n       0 AS decimal_digits, 2 AS pseudo_column\nFROM DUAL\nWHERE :1 = 1\nUNION\nSELECT 2 AS scope,\n  t.column_name,\n DECODE (t.data_type, 'CHAR', 1, 'VARCHAR2', 12, 'NUMBER', 3,\n 'LONG', -1, 'DATE', " + (this.connection.getMapDateToTimestamp() ? "93,\n" : "91,\n") + " 'RAW', -3, 'LONG RAW', -4, \n" + " 'TIMESTAMP(6)', 93, " + " 'TIMESTAMP(6) WITH TIME ZONE', -101, \n" + " 'TIMESTAMP(6) WITH LOCAL TIME ZONE', -102, \n" + " 'INTERVAL YEAR(2) TO MONTH', -103, \n" + " 'INTERVAL DAY(2) TO SECOND(6)', -104, \n" + " 'BINARY_FLOAT', 100, " + " 'BINARY_DOUBLE', 101," + " 1111)\n" + " AS data_type,\n" + " t.data_type AS type_name,\n" + " DECODE (t.data_precision, null, t.data_length, t.data_precision)\n" + "  AS column_size,\n" + "  0 AS buffer_length,\n" + "  t.data_scale AS decimal_digits,\n" + "       1 AS pseudo_column\n" + "FROM all_tab_columns t, all_ind_columns i\n" + "WHERE :2 = 1\n" + "  AND t.table_name = :3\n" + "  AND t.owner like :4 escape '/'\n" + "  AND t.nullable != :5\n" + "  AND t.owner = i.table_owner\n" + "  AND t.table_name = i.table_name\n" + "  AND t.column_name = i.column_name\n");
        switch(var4) {
            case 0:
                var6.setInt(1, 0);
                var6.setInt(2, 0);
                break;
            case 1:
                var6.setInt(1, 1);
                var6.setInt(2, 1);
                break;
            case 2:
                var6.setInt(1, 0);
                var6.setInt(2, 1);
        }

        var6.setString(3, var3);
        var6.setString(4, var2 == null ? "%" : var2);
        var6.setString(5, var5 ? "X" : "Y");
        OracleResultSet var7 = (OracleResultSet)var6.executeQuery();
        var7.closeStatementOnClose();
        return var7;
    }

    public synchronized ResultSet getVersionColumns(String var1, String var2, String var3) throws SQLException {
        PreparedStatement var4 = this.connection.prepareStatement("SELECT 0 AS scope,\n t.column_name,\n DECODE (c.data_type, 'CHAR', 1, 'VARCHAR2', 12, 'NUMBER', 3,\n  'LONG', -1, 'DATE',  " + (this.connection.getMapDateToTimestamp() ? "93,\n" : "91,\n") + "  'RAW', -3, 'LONG RAW', -4, " + "  'TIMESTAMP(6)', 93, 'TIMESTAMP(6) WITH TIME ZONE', -101, \n" + "  'TIMESTAMP(6) WITH LOCAL TIME ZONE', -102, \n" + "  'INTERVAL YEAR(2) TO MONTH', -103, \n" + "  'INTERVAL DAY(2) TO SECOND(6)', -104, \n" + "  'BINARY_FLOAT', 100, 'BINARY_DOUBLE', 101," + "   1111)\n " + " AS data_type,\n" + "       c.data_type AS type_name,\n" + " DECODE (c.data_precision, null, c.data_length, c.data_precision)\n" + "   AS column_size,\n" + "       0 as buffer_length,\n" + "   c.data_scale as decimal_digits,\n" + "   0 as pseudo_column\n" + "FROM all_trigger_cols t, all_tab_columns c\n" + "WHERE t.table_name = :1\n" + "  AND c.owner like :2 escape '/'\n" + " AND t.table_owner = c.owner\n" + "  AND t.table_name = c.table_name\n" + " AND t.column_name = c.column_name\n");
        var4.setString(1, var3);
        var4.setString(2, var2 == null ? "%" : var2);
        OracleResultSet var5 = (OracleResultSet)var4.executeQuery();
        var5.closeStatementOnClose();
        return var5;
    }

    public ResultSet getPrimaryKeys(String var1, String var2, String var3) throws SQLException {
        PreparedStatement var4 = this.connection.prepareStatement("SELECT NULL AS table_cat,\n       c.owner AS table_schem,\n       c.table_name,\n       c.column_name,\n       c.position AS key_seq,\n       c.constraint_name AS pk_name\nFROM all_cons_columns c, all_constraints k\nWHERE k.constraint_type = 'P'\n  AND k.table_name = :1\n  AND k.owner like :2 escape '/'\n  AND k.constraint_name = c.constraint_name \n  AND k.table_name = c.table_name \n  AND k.owner = c.owner \nORDER BY column_name\n");
        var4.setString(1, var3);
        var4.setString(2, var2 == null ? "%" : var2);
        OracleResultSet var5 = (OracleResultSet)var4.executeQuery();
        var5.closeStatementOnClose();
        return var5;
    }

    ResultSet keys_query(String var1, String var2, String var3, String var4, String var5) throws SQLException {
        int var6 = 1;
        int var7 = var2 != null ? var6++ : 0;
        int var8 = var4 != null ? var6++ : 0;
        int var9 = var1 != null && var1.length() > 0 ? var6++ : 0;
        int var10 = var3 != null && var3.length() > 0 ? var6++ : 0;
        PreparedStatement var11 = this.connection.prepareStatement("SELECT NULL AS pktable_cat,\n       p.owner as pktable_schem,\n       p.table_name as pktable_name,\n       pc.column_name as pkcolumn_name,\n       NULL as fktable_cat,\n       f.owner as fktable_schem,\n       f.table_name as fktable_name,\n       fc.column_name as fkcolumn_name,\n       fc.position as key_seq,\n       NULL as update_rule,\n       decode (f.delete_rule, 'CASCADE', 0, 'SET NULL', 2, 1) as delete_rule,\n       f.constraint_name as fk_name,\n       p.constraint_name as pk_name,\n       decode(f.deferrable,       'DEFERRABLE',5      ,'NOT DEFERRABLE',7      , 'DEFERRED', 6      ) deferrability \n      FROM all_cons_columns pc, all_constraints p,\n      all_cons_columns fc, all_constraints f\nWHERE 1 = 1\n" + (var7 != 0 ? "  AND p.table_name = :1\n" : "") + (var8 != 0 ? "  AND f.table_name = :2\n" : "") + (var9 != 0 ? "  AND p.owner = :3\n" : "") + (var10 != 0 ? "  AND f.owner = :4\n" : "") + "  AND f.constraint_type = 'R'\n" + "  AND p.owner = f.r_owner\n" + "  AND p.constraint_name = f.r_constraint_name\n" + "  AND p.constraint_type = 'P'\n" + "  AND pc.owner = p.owner\n" + "  AND pc.constraint_name = p.constraint_name\n" + "  AND pc.table_name = p.table_name\n" + "  AND fc.owner = f.owner\n" + "  AND fc.constraint_name = f.constraint_name\n" + "  AND fc.table_name = f.table_name\n" + "  AND fc.position = pc.position\n" + var5);
        if (var7 != 0) {
            var11.setString(var7, var2);
        }

        if (var8 != 0) {
            var11.setString(var8, var4);
        }

        if (var9 != 0) {
            var11.setString(var9, var1);
        }

        if (var10 != 0) {
            var11.setString(var10, var3);
        }

        OracleResultSet var12 = (OracleResultSet)var11.executeQuery();
        var12.closeStatementOnClose();
        return var12;
    }

    public synchronized ResultSet getImportedKeys(String var1, String var2, String var3) throws SQLException {
        return this.keys_query((String)null, (String)null, var2, var3, "ORDER BY pktable_schem, pktable_name, key_seq");
    }

    public ResultSet getExportedKeys(String var1, String var2, String var3) throws SQLException {
        return this.keys_query(var2, var3, (String)null, (String)null, "ORDER BY fktable_schem, fktable_name, key_seq");
    }

    public ResultSet getCrossReference(String var1, String var2, String var3, String var4, String var5, String var6) throws SQLException {
        return this.keys_query(var2, var3, var5, var6, "ORDER BY fktable_schem, fktable_name, key_seq");
    }

    public ResultSet getTypeInfo() throws SQLException {
        SQLException var1 = DatabaseError.createUnsupportedFeatureSqlException();
        var1.fillInStackTrace();
        throw var1;
    }

    public synchronized ResultSet getIndexInfo(String var1, String var2, String var3, boolean var4, boolean var5) throws SQLException {
        Statement var6 = this.connection.createStatement();
        if (var2 != null && var2.length() != 0 && !OracleSql.isValidObjectName(var2) || var3 != null && var3.length() != 0 && !OracleSql.isValidObjectName(var3)) {
            SQLException var16 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 68);
            var16.fillInStackTrace();
            throw var16;
        } else {
            String var7;
            if (!var5) {
                var7 = "analyze table " + (var2 == null ? "" : var2 + ".") + var3 + " compute statistics";
                var6.executeUpdate(var7);
            }

            if (var3.startsWith("\"") && var3.endsWith("\"") && var3.length() > 2) {
                var3 = var3.substring(1, var3.length() - 1);
            }

            var7 = "select null as table_cat,\n       owner as table_schem,\n       table_name,\n       0 as NON_UNIQUE,\n       null as index_qualifier,\n       null as index_name, 0 as type,\n       0 as ordinal_position, null as column_name,\n       null as asc_or_desc,\n       num_rows as cardinality,\n       blocks as pages,\n       null as filter_condition\nfrom all_tables\nwhere table_name = '" + var3 + "'\n";
            String var8 = "";
            if (var2 != null && var2.length() > 0) {
                if (var2.startsWith("\"") && var2.endsWith("\"") && var2.length() > 2) {
                    var2 = var2.substring(1, var2.length() - 1);
                }

                var8 = "  and owner = '" + var2 + "'\n";
            }

            String var9 = "select null as table_cat,\n       i.owner as table_schem,\n       i.table_name,\n       decode (i.uniqueness, 'UNIQUE', 0, 1),\n       null as index_qualifier,\n       i.index_name,\n       1 as type,\n       c.column_position as ordinal_position,\n       c.column_name,\n       null as asc_or_desc,\n       i.distinct_keys as cardinality,\n       i.leaf_blocks as pages,\n       null as filter_condition\nfrom all_indexes i, all_ind_columns c\nwhere i.table_name = '" + var3 + "'\n";
            String var10 = "";
            if (var2 != null && var2.length() > 0) {
                var10 = "  and i.owner = '" + var2 + "'\n";
            }

            String var11 = "";
            if (var4) {
                var11 = "  and i.uniqueness = 'UNIQUE'\n";
            }

            String var12 = "  and i.index_name = c.index_name\n  and i.table_owner = c.table_owner\n  and i.table_name = c.table_name\n  and i.owner = c.index_owner\n";
            String var13 = "order by non_unique, type, index_name, ordinal_position\n";
            String var14 = var7 + var8 + "union\n" + var9 + var10 + var11 + var12 + var13;
            OracleResultSet var15 = (OracleResultSet)var6.executeQuery(var14);
            var15.closeStatementOnClose();
            return var15;
        }
    }

    SQLException fail() {
        SQLException var1 = new SQLException("Not implemented yet");
        return var1;
    }

    public boolean supportsResultSetType(int var1) throws SQLException {
        return true;
    }

    public boolean supportsResultSetConcurrency(int var1, int var2) throws SQLException {
        return true;
    }

    public boolean ownUpdatesAreVisible(int var1) throws SQLException {
        return var1 != 1003;
    }

    public boolean ownDeletesAreVisible(int var1) throws SQLException {
        return var1 != 1003;
    }

    public boolean ownInsertsAreVisible(int var1) throws SQLException {
        return false;
    }

    public boolean othersUpdatesAreVisible(int var1) throws SQLException {
        return var1 == 1005;
    }

    public boolean othersDeletesAreVisible(int var1) throws SQLException {
        return false;
    }

    public boolean othersInsertsAreVisible(int var1) throws SQLException {
        return false;
    }

    public boolean updatesAreDetected(int var1) throws SQLException {
        return false;
    }

    public boolean deletesAreDetected(int var1) throws SQLException {
        return false;
    }

    public boolean insertsAreDetected(int var1) throws SQLException {
        return false;
    }

    public boolean supportsBatchUpdates() throws SQLException {
        return true;
    }

    public ResultSet getUDTs(String var1, String var2, String var3, int[] var4) throws SQLException {
        boolean var5 = false;
        if (var3 != null && var3.length() != 0) {
            if (var4 == null) {
                var5 = true;
            } else {
                for(int var6 = 0; var6 < var4.length; ++var6) {
                    if (var4[var6] == 2002) {
                        var5 = true;
                        break;
                    }
                }
            }
        } else {
            var5 = false;
        }

        StringBuffer var10 = new StringBuffer();
        var10.append("SELECT NULL AS TYPE_CAT, owner AS TYPE_SCHEM, type_name, NULL AS CLASS_NAME, 'STRUCT' AS DATA_TYPE, NULL AS REMARKS FROM all_types ");
        if (var5) {
            var10.append("WHERE typecode = 'OBJECT' AND owner LIKE :1 ESCAPE '/' AND type_name LIKE :2 ESCAPE '/'");
        } else {
            var10.append("WHERE 1 = 2");
        }

        PreparedStatement var7 = this.connection.prepareStatement(var10.substring(0, var10.length()));
        if (var5) {
            String[] var8 = new String[1];
            String[] var9 = new String[1];
            if (SQLName.parse(var3, var8, var9)) {
                var7.setString(1, var8[0]);
                var7.setString(2, var9[0]);
            } else {
                if (var2 != null) {
                    var7.setString(1, var2);
                } else {
                    var7.setNull(1, 12);
                }

                var7.setString(2, var3);
            }
        }

        OracleResultSet var11 = (OracleResultSet)var7.executeQuery();
        var11.closeStatementOnClose();
        return var11;
    }

    public Connection getConnection() throws SQLException {
        return this.connection.getWrapper();
    }

    public boolean supportsSavepoints() throws SQLException {
        return true;
    }

    public boolean supportsNamedParameters() throws SQLException {
        return true;
    }

    public boolean supportsMultipleOpenResults() throws SQLException {
        return false;
    }

    public boolean supportsGetGeneratedKeys() throws SQLException {
        return true;
    }

    public ResultSet getSuperTypes(String var1, String var2, String var3) throws SQLException {
        SQLException var4 = DatabaseError.createUnsupportedFeatureSqlException();
        var4.fillInStackTrace();
        throw var4;
    }

    public ResultSet getSuperTables(String var1, String var2, String var3) throws SQLException {
        SQLException var4 = DatabaseError.createUnsupportedFeatureSqlException();
        var4.fillInStackTrace();
        throw var4;
    }

    public ResultSet getAttributes(String var1, String var2, String var3, String var4) throws SQLException {
        SQLException var5 = DatabaseError.createUnsupportedFeatureSqlException();
        var5.fillInStackTrace();
        throw var5;
    }

    public boolean supportsResultSetHoldability(int var1) throws SQLException {
        return var1 == 1;
    }

    public int getResultSetHoldability() throws SQLException {
        return 1;
    }

    public int getDatabaseMajorVersion() throws SQLException {
        return this.connection.getVersionNumber() / 1000;
    }

    public int getDatabaseMinorVersion() throws SQLException {
        return this.connection.getVersionNumber() % 1000 / 100;
    }

    public int getJDBCMajorVersion() throws SQLException {
        return DRIVER_API_MAJOR_VERSION;
    }

    public int getJDBCMinorVersion() throws SQLException {
        return DRIVER_API_MINOR_VERSION;
    }

    public int getSQLStateType() throws SQLException {
        return 0;
    }

    public boolean locatorsUpdateCopy() throws SQLException {
        return true;
    }

    public boolean supportsStatementPooling() throws SQLException {
        return true;
    }

    public static String getDriverNameInfo() throws SQLException {
        return DRIVER_NAME;
    }

    /** @deprecated */
    public static String getDriverVersionInfo() throws SQLException {
        return DRIVER_VERSION;
    }

    /** @deprecated */
    public static int getDriverMajorVersionInfo() {
        return DRIVER_MAJOR_VERSION;
    }

    /** @deprecated */
    public static int getDriverMinorVersionInfo() {
        return DRIVER_MINOR_VERSION;
    }

    /** @deprecated */
    public static String getLobPrecision() throws SQLException {
        return "-1";
    }

    public long getLobMaxLength() throws SQLException {
        return this.connection.getVersionNumber() >= 10000 ? 9223372036854775807L : LOB_MAXLENGTH_32BIT;
    }

    public RowIdLifetime getRowIdLifetime() throws SQLException {
        return RowIdLifetime.ROWID_VALID_FOREVER;
    }

    public ResultSet getSchemas(String var1, String var2) throws SQLException {
        if (var2 == null) {
            return this.getSchemas();
        } else {
            String var3 = "SELECT username AS table_schem, null as table_catalog FROM all_users WHERE username LIKE ? ORDER BY table_schem";
            PreparedStatement var4 = this.connection.prepareStatement(var3);
            var4.setString(1, var2);
            OracleResultSet var5 = (OracleResultSet)var4.executeQuery();
            var5.closeStatementOnClose();
            return var5;
        }
    }

    public boolean supportsStoredFunctionsUsingCallSyntax() throws SQLException {
        return true;
    }

    public boolean autoCommitFailureClosesAllResultSets() throws SQLException {
        return false;
    }

    public ResultSet getClientInfoProperties() throws SQLException {
        Statement var1 = this.connection.createStatement();
        return var1.executeQuery("select NULL NAME, -1 MAX_LEN, NULL DEFAULT_VALUE, NULL DESCRIPTION  from dual where 0 = 1");
    }

    public ResultSet getFunctions(String var1, String var2, String var3) throws SQLException {
        String var4 = "SELECT\n  -- Standalone functions\n  NULL AS function_cat,\n  owner AS function_schem,\n  object_name AS function_name,\n  'Standalone function' AS remarks,\n  0 AS function_type,\n  NULL AS specific_name\nFROM all_objects\nWHERE object_type = 'FUNCTION'\n  AND owner LIKE :1 ESCAPE '/'\n  AND object_name LIKE :2 ESCAPE '/'\n";
        String var5 = "SELECT\n  -- Packaged functions\n  package_name AS function_cat,\n  owner AS function_schem,\n  object_name AS function_name,\n  'Packaged function' AS remarks,\n  decode (data_type, 'TABLE', 2, 'PL/SQL TABLE', 2, 1) AS function_type,\n  NULL AS specific_name\nFROM all_arguments\nWHERE argument_name IS NULL\n  AND in_out = 'OUT'\n  AND data_level = 0\n";
        String var6 = "  AND package_name LIKE :3 ESCAPE '/'\n  AND owner LIKE :4 ESCAPE '/'\n  AND object_name LIKE :5 ESCAPE '/'\n";
        String var7 = "  AND package_name IS NOT NULL\n  AND owner LIKE :6 ESCAPE '/'\n  AND object_name LIKE :7 ESCAPE '/'\n";
        String var8 = "ORDER BY function_schem, function_name\n";
        PreparedStatement var9 = null;
        String var10 = null;
        String var11 = var2;
        if (var2 == null) {
            var11 = "%";
        } else if (var2.equals("")) {
            var11 = this.getUserName().toUpperCase();
        }

        String var12 = var3;
        if (var3 == null) {
            var12 = "%";
        } else if (var3.equals("")) {
            SQLException var14 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 74);
            var14.fillInStackTrace();
            throw var14;
        }

        if (var1 == null) {
            var10 = var4 + "UNION ALL " + var5 + var7 + var8;
            var9 = this.connection.prepareStatement(var10);
            var9.setString(1, var11);
            var9.setString(2, var12);
            var9.setString(3, var11);
            var9.setString(4, var12);
        } else if (var1.equals("")) {
            var9 = this.connection.prepareStatement(var4);
            var9.setString(1, var11);
            var9.setString(2, var12);
        } else {
            var10 = var5 + var6 + var8;
            var9 = this.connection.prepareStatement(var10);
            var9.setString(1, var11);
            var9.setString(2, var11);
            var9.setString(3, var12);
        }

        OracleResultSet var13 = (OracleResultSet)var9.executeQuery();
        var13.closeStatementOnClose();
        return var13;
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

    protected OracleConnection getConnectionDuringExceptionHandling() {
        return this.connection;
    }

    protected boolean hasSqlWildcard(String var1) {
        if (sqlWildcardPattern == null) {
            sqlWildcardPattern = Pattern.compile("^%|^_|[^/]%|[^/]_");
        }

        Matcher var2 = sqlWildcardPattern.matcher(var1);
        return var2.find();
    }

    protected String stripSqlEscapes(String var1) {
        if (sqlEscapePattern == null) {
            sqlEscapePattern = Pattern.compile("/");
        }

        Matcher var2 = sqlEscapePattern.matcher(var1);
        StringBuffer var3 = new StringBuffer();

        while(var2.find()) {
            var2.appendReplacement(var3, "");
        }

        var2.appendTail(var3);
        return var3.toString();
    }

    String getUnpackagedProcedureColumnsNoWildcardsPlsql() throws SQLException {
        String var1 = "declare\n  in_owner varchar2(32) := null;\n  in_name varchar2(32) := null;\n  my_user_name varchar2(32) := null;\n  cnt number := 0;\n  temp_owner varchar2(32) := null;\n  temp_name  varchar2(32):= null;\n  out_owner varchar2(32) := null;\n  out_name  varchar2(32):= null;\n  loc varchar2(32) := null;\n  status number := 0;\n  TYPE recursion_check_type is table of number index by varchar2(65);\n  recursion_check recursion_check_type;\n  dotted_name varchar2(65);\n  recursion_cnt number := 0;\n  xxx SYS_REFCURSOR;\nbegin\n  in_owner := ?;\n  in_name := ?;\n  select user into my_user_name from dual;\n  if( my_user_name = in_owner ) then\n    select count(*) into cnt from user_procedures where object_name = in_name;\n    if( cnt = 1 ) then\n      out_owner := in_owner;\n      out_name := in_name;\n      loc := 'USER_PROCEDURES';\n    end if;\n  else\n    select count(*) into cnt from all_arguments where owner = in_owner and object_name = in_name;\n    if( cnt = 1 ) then\n      out_owner := in_owner;\n      out_name := in_name;\n      loc := 'ALL_ARGUMENTS';\n    end if;\n  end if;\n  if loc is null then\n    temp_owner := in_owner;\n    temp_name := in_name;\n    loop\n      begin\n        dotted_name := temp_owner || '.' ||temp_name;\n        begin\n          recursion_cnt := recursion_check(dotted_name );\n          status := -1;\n          exit;\n        exception\n        when NO_DATA_FOUND then\n          recursion_check( dotted_name ) := 1;\n        end;\n        select table_owner, table_name into out_owner, out_name from all_synonyms \n          where  owner = temp_owner and synonym_name = temp_name;\n        cnt := cnt + 1;\n        temp_owner  := out_owner;\n        temp_name := out_name;\n        exception\n        when NO_DATA_FOUND then\n          exit;\n        end;\n      end loop;\n      if( not(out_owner is null) ) then\n        loc := 'ALL_SYNONYMS';\n    end if;\n  end if;\n";
        short var2 = this.connection.getVersionNumber();
        String var3 = "if( status = 0 ) then \n open xxx for \n";
        String var4 = "SELECT package_name AS procedure_cat,\n       owner AS procedure_schem,\n       object_name AS procedure_name,\n       argument_name AS column_name,\n       DECODE(position, 0, 5,\n                        DECODE(in_out, 'IN', 1,\n                                       'OUT', 4,\n                                       'IN/OUT', 2,\n                                       0)) AS column_type,\n       DECODE (data_type, 'CHAR', 1,\n                          'VARCHAR2', 12,\n                          'NUMBER', 3,\n                          'LONG', -1,\n                          'DATE', " + (this.connection.getMapDateToTimestamp() ? "93,\n" : "91,\n") + "                          'RAW', -3,\n" + "                          'LONG RAW', -4,\n" + "                          'TIMESTAMP', 93, \n" + "                          'TIMESTAMP WITH TIME ZONE', -101, \n" + "               'TIMESTAMP WITH LOCAL TIME ZONE', -102, \n" + "               'INTERVAL YEAR TO MONTH', -103, \n" + "               'INTERVAL DAY TO SECOND', -104, \n" + "               'BINARY_FLOAT', 100, 'BINAvRY_DOUBLE', 101," + "               1111) AS data_type,\n" + "       DECODE(data_type, 'OBJECT', type_owner || '.' || type_name, " + "              data_type) AS type_name,\n" + "       DECODE (data_precision, NULL, data_length,\n" + "                               data_precision) AS precision,\n" + "       data_length AS length,\n" + "       data_scale AS scale,\n" + "       10 AS radix,\n" + "       1 AS nullable,\n" + "       NULL AS remarks,\n" + "       default_value AS column_def,\n" + "       NULL as sql_data_type,\n" + "       NULL AS sql_datetime_sub,\n" + "       DECODE(data_type,\n" + "                         'CHAR', 32767,\n" + "                         'VARCHAR2', 32767,\n" + "                         'LONG', 32767,\n" + "                         'RAW', 32767,\n" + "                         'LONG RAW', 32767,\n" + "                         NULL) AS char_octet_length,\n" + "       (sequence - 1) AS ordinal_position,\n" + "       'YES' AS is_nullable,\n" + "       NULL AS specific_name,\n" + "       sequence,\n" + "       overload,\n" + "       default_value\n";
        String var5 = "FROM all_arguments a";
        String var6 = "WHERE a.owner = out_owner \n  AND a.object_name = out_name\n AND a.argument_name LIKE ? ESCAPE '/'\n AND data_level = 0\n AND package_name is null\n";
        String var7 = "ORDER BY procedure_schem, procedure_name, overload, sequence\n";
        String var8 = var3 + var4;
        var8 = var8 + var5;
        var8 = var8 + "\n" + var6;
        var8 = var8 + "\n" + var7;
        String var9 = "; \n end if;\n  ? := xxx; ? := status;\n end;";
        String var10 = var1 + var8 + var9;
        return var10;
    }

    String getPackagedProcedureColumnsNoWildcardsPlsql() throws SQLException {
        String var1 = "declare\n  in_package_name varchar2(32) := null;\n  in_owner varchar2(32) := null;\n  in_name varchar2(32) := null;\n  my_user_name varchar2(32) := null;\n  cnt number := 0;\n  temp_package_name varchar2(32) := null;\n  temp_owner varchar2(32) := null;\n  out_package_name varchar2(32) := null;\n  out_owner varchar2(32) := null;\n  loc varchar2(32) := null;\n  status number := 0;\n  TYPE recursion_check_type is table of number index by varchar2(65);\n  recursion_check recursion_check_type;\n  dotted_name varchar2(65);\n  recursion_cnt number := 0;\n  xxx SYS_REFCURSOR;\nbegin\n  in_package_name := ?;\n  in_owner := ?;\n  in_name := ?;\n  select user into my_user_name from dual;\n  if( my_user_name = in_owner ) then\n    select count(*) into cnt from user_arguments where package_name = in_package_name;\n    if( cnt >= 1 ) then\n      out_owner := in_owner;\n      out_package_name := in_package_name;\n      loc := 'USER_ARGUMENTS';\n    end if;\n  else\n    select count(*) into cnt from all_arguments where owner = in_owner and package_name = in_package_name;\n    if( cnt >= 1 ) then\n      out_owner := in_owner;\n      out_package_name := in_package_name;\n      loc := 'ALL_ARGUMENTS';\n    end if;\n  end if;\n  if loc is null then\n  temp_owner := in_owner;\n  temp_package_name := in_package_name;\n  loop\n    begin\n      dotted_name := temp_owner || '.' ||temp_package_name;\n      begin\n        recursion_cnt := recursion_check(dotted_name );\n        status := -1;\n        exit;\n      exception\n      when NO_DATA_FOUND then\n        recursion_check( dotted_name ) := 1;\n      end;\n      select table_owner, table_name into out_owner, out_package_name from all_synonyms \n        where  owner = temp_owner and synonym_name = temp_package_name;\n      cnt := cnt + 1;\n      temp_owner  := out_owner;\n      temp_package_name := out_package_name;\n      exception\n      when NO_DATA_FOUND then\n        exit;\n      end;\n    end loop;\n    if( not(out_owner is null) ) then\n      loc := 'ALL_SYNONYMS';\n    end if;\n  end if;\n";
        short var2 = this.connection.getVersionNumber();
        String var3 = "if( status = 0 ) then \n open xxx for \n";
        String var4 = "SELECT package_name AS procedure_cat,\n       owner AS procedure_schem,\n       object_name AS procedure_name,\n       argument_name AS column_name,\n       DECODE(position, 0, 5,\n                        DECODE(in_out, 'IN', 1,\n                                       'OUT', 4,\n                                       'IN/OUT', 2,\n                                       0)) AS column_type,\n       DECODE (data_type, 'CHAR', 1,\n                          'VARCHAR2', 12,\n                          'NUMBER', 3,\n                          'LONG', -1,\n                          'DATE', " + (this.connection.getMapDateToTimestamp() ? "93,\n" : "91,\n") + "                          'RAW', -3,\n" + "                          'LONG RAW', -4,\n" + "                          'TIMESTAMP', 93, \n" + "                          'TIMESTAMP WITH TIME ZONE', -101, \n" + "               'TIMESTAMP WITH LOCAL TIME ZONE', -102, \n" + "               'INTERVAL YEAR TO MONTH', -103, \n" + "               'INTERVAL DAY TO SECOND', -104, \n" + "               'BINARY_FLOAT', 100, 'BINAvRY_DOUBLE', 101," + "               1111) AS data_type,\n" + "       DECODE(data_type, 'OBJECT', type_owner || '.' || type_name, " + "              data_type) AS type_name,\n" + "       DECODE (data_precision, NULL, data_length,\n" + "                               data_precision) AS precision,\n" + "       data_length AS length,\n" + "       data_scale AS scale,\n" + "       10 AS radix,\n" + "       1 AS nullable,\n" + "       NULL AS remarks,\n" + "       default_value AS column_def,\n" + "       NULL as sql_data_type,\n" + "       NULL AS sql_datetime_sub,\n" + "       DECODE(data_type,\n" + "                         'CHAR', 32767,\n" + "                         'VARCHAR2', 32767,\n" + "                         'LONG', 32767,\n" + "                         'RAW', 32767,\n" + "                         'LONG RAW', 32767,\n" + "                         NULL) AS char_octet_length,\n" + "       (sequence - 1) AS ordinal_position,\n" + "       'YES' AS is_nullable,\n" + "       NULL AS specific_name,\n" + "       sequence,\n" + "       overload,\n" + "       default_value\n";
        String var5 = "FROM all_arguments a";
        String var6 = "WHERE a.owner = out_owner \n  AND a.object_name LIKE in_name ESCAPE '/' \n AND a.argument_name LIKE ? ESCAPE '/' \n AND data_level = 0\n AND package_name = out_package_name\n";
        String var7 = "ORDER BY procedure_schem, procedure_name, overload, sequence\n";
        String var8 = var3 + var4;
        var8 = var8 + var5;
        var8 = var8 + "\n" + var6;
        var8 = var8 + "\n" + var7;
        String var9 = "; \n end if;\n  ? := xxx; ? := status;\n end;";
        String var10 = var1 + var8 + var9;
        return var10;
    }

    public OracleTypeMetaData getOracleTypeMetaData(String var1) throws SQLException {
        return TypeDescriptor.getTypeDescriptor(var1, this.connection);
    }

    public ResultSet getPseudoColumns(String var1, String var2, String var3, String var4) throws SQLException {
        String var5 = this.pseudoColumnRow(var2, var3, "ORA_ROWSCN", 2, 10) + "union\n" + this.pseudoColumnRow(var2, var3, "ROWID", -8, 18) + "union\n" + this.pseudoColumnRow(var2, var3, "ROWNUM", 2, 10);
        String var6 = "select *\nfrom (" + var5 + ")\n" + "where column_name like '" + var4 + "'\n" + "order by column_name";
        PreparedStatement var7 = this.connection.prepareStatement(var6);
        var7.closeOnCompletion();
        return var7.executeQuery();
    }

    private String pseudoColumnRow(String var1, String var2, String var3, int var4, int var5) throws SQLException {
        return "select\n  null as TABLE_CAT,\n  owner as TABLE_SCHEM,\n  table_name as TABLE_NAME,\n  '" + var3 + "' as COLUMN_NAME,\n" + "  " + var4 + " as DATA_TYPE,\n" + "  " + var5 + " as COLUMN_SIZE,\n" + "  " + (var3.equals("ROWID") ? "null" : "38") + " as DECIMAL_DIGITS,\n" + "  10 as NUM_PREC_RADIX,\n" + "  'NO_USAGE_RESTRICTONS' as COLUMN_USAGE,\n" + "  null as REMARKS,\n" + "  null as CHAR_OCTET_LENGTH,\n" + "  'NO' as IS_NULLABLE\n" + "from all_tables\n" + "where\n" + "  owner like '" + var1 + "' and\n" + "  table_name like '" + var2 + "'\n";
    }

    public boolean generatedKeyAlwaysReturned() throws SQLException {
        return false;
    }
}
