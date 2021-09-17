//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package oracle.jdbc.driver;

import java.io.PrintWriter;
import java.sql.SQLException;
import oracle.jdbc.driver.OracleSqlReadOnly.ODBCAction;
import oracle.jdbc.internal.OracleConnection;
import oracle.jdbc.internal.OracleStatement.SqlKind;

public class OracleSql {
    static final int UNINITIALIZED = -1;
    static final String[] EMPTY_LIST = new String[0];
    static final int MAX_IDENTIFIER_LENGTH = 258;
    DBConversion conversion;
    String originalSql;
    String parameterSql;
    String utickSql;
    String processedSql;
    String rowidSql;
    String actualSql;
    byte[] sqlBytes;
    SqlKind sqlKind;
    byte sqlKindByte;
    int parameterCount;
    int returningIntoParameterCount;
    boolean currentConvertNcharLiterals;
    boolean currentProcessEscapes;
    boolean includeRowid;
    String[] parameterList;
    char[] currentParameter;
    int bindParameterCount;
    String[] bindParameterList;
    int cachedBindParameterCount;
    String[] cachedBindParameterList;
    String cachedParameterSql;
    String cachedUtickSql;
    String cachedProcessedSql;
    String cachedRowidSql;
    String cachedActualSql;
    byte[] cachedSqlBytes;
    int selectEndIndex;
    int orderByStartIndex;
    int orderByEndIndex;
    int whereStartIndex;
    int whereEndIndex;
    int forUpdateStartIndex;
    int forUpdateEndIndex;
    int[] ncharLiteralLocation;
    int lastNcharLiteralLocation;
    static final String paramPrefix = "rowid";
    int paramSuffix;
    StringBuffer stringBufferForScrollableStatement;
    private static final int cMax = 127;
    private static final int[][] TRANSITION;
    private static final int[][] ACTION;
    private static final int NO_ACTION = 0;
    private static final int DELETE_ACTION = 1;
    private static final int INSERT_ACTION = 2;
    private static final int MERGE_ACTION = 3;
    private static final int UPDATE_ACTION = 4;
    private static final int PLSQL_ACTION = 5;
    private static final int CALL_ACTION = 6;
    private static final int SELECT_ACTION = 7;
    private static final int ORDER_ACTION = 10;
    private static final int ORDER_BY_ACTION = 11;
    private static final int WHERE_ACTION = 9;
    private static final int FOR_ACTION = 12;
    private static final int FOR_UPDATE_ACTION = 13;
    private static final int OTHER_ACTION = 8;
    private static final int QUESTION_ACTION = 14;
    private static final int PARAMETER_ACTION = 15;
    private static final int END_PARAMETER_ACTION = 16;
    private static final int START_NCHAR_LITERAL_ACTION = 17;
    private static final int END_NCHAR_LITERAL_ACTION = 18;
    private static final int SAVE_DELIMITER_ACTION = 19;
    private static final int LOOK_FOR_DELIMITER_ACTION = 20;
    private static final int ALTER_SESSION_ACTION = 21;
    private static final int RETURNING_ACTION = 22;
    private static final int INTO_ACTION = 23;
    private static final int INITIAL_STATE = 0;
    private static final int RESTART_STATE = 66;
    private static final ODBCAction[][] ODBC_ACTION;
    private static final boolean DEBUG_CBI = false;
    int current_argument;
    int i;
    int length;
    char currentChar;
    boolean first;
    String odbc_sql;
    StringBuffer oracle_sql;
    StringBuffer token_buffer;
    private static final String _Copyright_2007_Oracle_All_Rights_Reserved_;
    public static final String BUILD_DATE = "Thu_Apr_04_15:09:24_PDT_2013";
    public static final boolean TRACE = false;

    protected OracleSql(DBConversion var1) {
        this.sqlKind = SqlKind.UNINITIALIZED;
        this.sqlKindByte = -1;
        this.parameterCount = -1;
        this.returningIntoParameterCount = -1;
        this.currentConvertNcharLiterals = true;
        this.currentProcessEscapes = true;
        this.includeRowid = false;
        this.parameterList = EMPTY_LIST;
        this.currentParameter = null;
        this.bindParameterCount = -1;
        this.bindParameterList = null;
        this.cachedBindParameterCount = -1;
        this.cachedBindParameterList = null;
        this.selectEndIndex = -1;
        this.orderByStartIndex = -1;
        this.orderByEndIndex = -1;
        this.whereStartIndex = -1;
        this.whereEndIndex = -1;
        this.forUpdateStartIndex = -1;
        this.forUpdateEndIndex = -1;
        this.ncharLiteralLocation = new int[513];
        this.lastNcharLiteralLocation = -1;
        this.paramSuffix = 0;
        this.stringBufferForScrollableStatement = null;
        this.conversion = var1;
    }

    protected void initialize(String var1) throws SQLException {
        if (var1 != null && var1.length() != 0) {
            this.originalSql = var1;
            this.utickSql = null;
            this.processedSql = null;
            this.rowidSql = null;
            this.actualSql = null;
            this.sqlBytes = null;
            this.sqlKind = SqlKind.UNINITIALIZED;
            this.parameterCount = -1;
            this.parameterList = EMPTY_LIST;
            this.includeRowid = false;
            this.parameterSql = this.originalSql;
            this.bindParameterCount = -1;
            this.bindParameterList = null;
            this.cachedBindParameterCount = -1;
            this.cachedBindParameterList = null;
            this.cachedParameterSql = null;
            this.cachedActualSql = null;
            this.cachedProcessedSql = null;
            this.cachedRowidSql = null;
            this.cachedSqlBytes = null;
            this.selectEndIndex = -1;
            this.orderByStartIndex = -1;
            this.orderByEndIndex = -1;
            this.whereStartIndex = -1;
            this.whereEndIndex = -1;
            this.forUpdateStartIndex = -1;
            this.forUpdateEndIndex = -1;
        } else {
            SQLException var2 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 104);
            var2.fillInStackTrace();
            throw var2;
        }
    }

    String getOriginalSql() {
        return this.originalSql;
    }

    boolean setNamedParameters(int var1, String[] var2) throws SQLException {
        boolean var3 = false;
        if (var1 == 0) {
            this.bindParameterCount = -1;
            var3 = this.bindParameterCount != this.cachedBindParameterCount;
        } else {
            this.bindParameterCount = var1;
            this.bindParameterList = var2;
            var3 = this.bindParameterCount != this.cachedBindParameterCount;
            if (!var3) {
                for(int var4 = 0; var4 < var1; ++var4) {
                    if (this.bindParameterList[var4] != this.cachedBindParameterList[var4]) {
                        var3 = true;
                        break;
                    }
                }
            }

            if (var3) {
                if (this.bindParameterCount != this.getParameterCount()) {
                    SQLException var9 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 197);
                    var9.fillInStackTrace();
                    throw var9;
                }

                char[] var8 = this.originalSql.toCharArray();
                StringBuffer var5 = new StringBuffer();
                int var6 = 0;

                for(int var7 = 0; var7 < var8.length; ++var7) {
                    if (var8[var7] != '?') {
                        var5.append(var8[var7]);
                    } else {
                        var5.append(this.bindParameterList[var6++]);
                        var5.append("=>" + this.nextArgument());
                    }
                }

                this.parameterSql = var5.toString();
                this.actualSql = null;
                this.utickSql = null;
                this.processedSql = null;
                this.rowidSql = null;
                this.sqlBytes = null;
            } else {
                this.parameterSql = this.cachedParameterSql;
                this.actualSql = this.cachedActualSql;
                this.utickSql = this.cachedUtickSql;
                this.processedSql = this.cachedProcessedSql;
                this.rowidSql = this.cachedRowidSql;
                this.sqlBytes = this.cachedSqlBytes;
            }
        }

        this.cachedBindParameterList = null;
        this.cachedParameterSql = null;
        this.cachedActualSql = null;
        this.cachedUtickSql = null;
        this.cachedProcessedSql = null;
        this.cachedRowidSql = null;
        this.cachedSqlBytes = null;
        return var3;
    }

    void resetNamedParameters() {
        this.cachedBindParameterCount = this.bindParameterCount;
        if (this.bindParameterCount != -1) {
            if (this.cachedBindParameterList == null || this.cachedBindParameterList == this.bindParameterList || this.cachedBindParameterList.length < this.bindParameterCount) {
                this.cachedBindParameterList = new String[this.bindParameterCount];
            }

            System.arraycopy(this.bindParameterList, 0, this.cachedBindParameterList, 0, this.bindParameterCount);
            this.cachedParameterSql = this.parameterSql;
            this.cachedActualSql = this.actualSql;
            this.cachedUtickSql = this.utickSql;
            this.cachedProcessedSql = this.processedSql;
            this.cachedRowidSql = this.rowidSql;
            this.cachedSqlBytes = this.sqlBytes;
            this.bindParameterCount = -1;
            this.bindParameterList = null;
            this.parameterSql = this.originalSql;
            this.actualSql = null;
            this.utickSql = null;
            this.processedSql = null;
            this.rowidSql = null;
            this.sqlBytes = null;
        }

    }

    String getSql(boolean var1, boolean var2) throws SQLException {
        if (this.sqlKind == SqlKind.UNINITIALIZED) {
            this.computeBasicInfo(this.parameterSql);
        }

        if (var1 != this.currentProcessEscapes || var2 != this.currentConvertNcharLiterals) {
            if (var2 != this.currentConvertNcharLiterals) {
                this.utickSql = null;
            }

            this.processedSql = null;
            this.rowidSql = null;
            this.actualSql = null;
            this.sqlBytes = null;
        }

        this.currentConvertNcharLiterals = var2;
        this.currentProcessEscapes = var1;
        if (this.actualSql == null) {
            if (this.utickSql == null) {
                this.utickSql = this.currentConvertNcharLiterals ? this.convertNcharLiterals(this.parameterSql) : this.parameterSql;
            }

            if (this.processedSql == null) {
                this.processedSql = this.currentProcessEscapes ? this.parse(this.utickSql) : this.utickSql;
            }

            if (this.rowidSql == null) {
                this.rowidSql = this.includeRowid ? this.addRowid(this.processedSql) : this.processedSql;
            }

            this.actualSql = this.rowidSql;
        }

        return this.actualSql;
    }

    String getRevisedSql() throws SQLException {
        String var1 = null;
        if (this.sqlKind == SqlKind.UNINITIALIZED) {
            this.computeBasicInfo(this.parameterSql);
        }

        var1 = this.removeOrderByForUpdate(this.parameterSql);
        return this.addRowid(var1);
    }

    String removeForUpdate(String var1) throws SQLException {
        return this.forUpdateStartIndex != -1 ? var1.substring(0, this.forUpdateStartIndex) : var1;
    }

    String removeOrderByForUpdate(String var1) throws SQLException {
        if (this.orderByStartIndex == -1 || this.forUpdateStartIndex != -1 && this.forUpdateStartIndex <= this.orderByStartIndex) {
            if (this.forUpdateStartIndex != -1) {
                var1 = var1.substring(0, this.forUpdateStartIndex);
            }
        } else {
            var1 = var1.substring(0, this.orderByStartIndex);
        }

        return var1;
    }

    void appendForUpdate(StringBuffer var1) throws SQLException {
        if (this.orderByStartIndex == -1 || this.forUpdateStartIndex != -1 && this.forUpdateStartIndex <= this.orderByStartIndex) {
            if (this.forUpdateStartIndex != -1) {
                var1.append(this.originalSql.substring(this.forUpdateStartIndex));
            }
        } else {
            var1.append(this.originalSql.substring(this.orderByStartIndex));
        }

    }

    String getInsertSqlForUpdatableResultSet(UpdatableResultSet var1) throws SQLException {
        String var2 = this.getOriginalSql();
        boolean var3 = this.generatedSqlNeedEscapeProcessing();
        if (this.stringBufferForScrollableStatement == null) {
            this.stringBufferForScrollableStatement = new StringBuffer(var2.length() + 100);
        } else {
            this.stringBufferForScrollableStatement.delete(0, this.stringBufferForScrollableStatement.length());
        }

        this.stringBufferForScrollableStatement.append("insert into (");
        this.stringBufferForScrollableStatement.append(this.removeOrderByForUpdate(var2));
        this.stringBufferForScrollableStatement.append(") values ( ");

        for(int var4 = 0; var4 < var1.getColumnCount(); ++var4) {
            if (var4 != 0) {
                this.stringBufferForScrollableStatement.append(", ");
            }

            if (var3) {
                this.stringBufferForScrollableStatement.append("?");
            } else {
                this.stringBufferForScrollableStatement.append(":" + this.generateParameterName());
            }
        }

        this.stringBufferForScrollableStatement.append(")");
        this.paramSuffix = 0;
        return this.stringBufferForScrollableStatement.substring(0, this.stringBufferForScrollableStatement.length());
    }

    String getRefetchSqlForScrollableResultSet(OracleResultSet var1, int var2) throws SQLException {
        throw new SQLException("no longer used");
    }

    String getRefetchSql() throws SQLException {
        String var1 = this.removeForUpdate(this.parameterSql);
        StringBuilder var2 = new StringBuilder(var1.length() + 240);
        var2.append("WITH \"__JDBC_ROWIDS__\" AS (SELECT COLUMN_VALUE ID, ROWNUM NUM FROM TABLE(");
        var2.append(this.generatedSqlNeedEscapeProcessing() ? "?" : ":" + this.generateParameterName());
        var2.append("))\n");
        var2.append("SELECT \"__JDBC_ORIGINAL__\".ROWID, \"__JDBC_ORIGINAL__\".*\n");
        var2.append("FROM (");
        var2.append(var1);
        var2.append(") \"__JDBC_ORIGINAL__\", \"__JDBC_ROWIDS__\"\n");
        var2.append("WHERE \"__JDBC_ORIGINAL__\".ROWID(+) = \"__JDBC_ROWIDS__\".ID\n");
        var2.append("ORDER BY \"__JDBC_ROWIDS__\".NUM");
        this.paramSuffix = 0;
        return var2.toString();
    }

    String getUpdateSqlForUpdatableResultSet(UpdatableResultSet var1, int var2, Object[] var3, int[] var4) throws SQLException {
        String var5 = this.getRevisedSql();
        boolean var6 = this.generatedSqlNeedEscapeProcessing();
        if (this.stringBufferForScrollableStatement == null) {
            this.stringBufferForScrollableStatement = new StringBuffer(var5.length() + 100);
        } else {
            this.stringBufferForScrollableStatement.delete(0, this.stringBufferForScrollableStatement.length());
        }

        this.stringBufferForScrollableStatement.append("update (");
        this.stringBufferForScrollableStatement.append(var5);
        this.stringBufferForScrollableStatement.append(") set ");
        if (var3 != null) {
            for(int var7 = 0; var7 < var2; ++var7) {
                if (var7 > 0) {
                    this.stringBufferForScrollableStatement.append(", ");
                }

                this.stringBufferForScrollableStatement.append(var1.getInternalMetadata().getColumnName(var4[var7] + 1));
                if (var6) {
                    this.stringBufferForScrollableStatement.append(" = ?");
                } else {
                    this.stringBufferForScrollableStatement.append(" = :" + this.generateParameterName());
                }
            }
        }

        this.stringBufferForScrollableStatement.append(" WHERE ");
        if (var6) {
            this.stringBufferForScrollableStatement.append(" ROWID = ?");
        } else {
            this.stringBufferForScrollableStatement.append(" ROWID = :" + this.generateParameterName());
        }

        this.paramSuffix = 0;
        return this.stringBufferForScrollableStatement.substring(0, this.stringBufferForScrollableStatement.length());
    }

    String getDeleteSqlForUpdatableResultSet(UpdatableResultSet var1) throws SQLException {
        String var2 = this.getRevisedSql();
        boolean var3 = this.generatedSqlNeedEscapeProcessing();
        if (this.stringBufferForScrollableStatement == null) {
            this.stringBufferForScrollableStatement = new StringBuffer(var2.length() + 100);
        } else {
            this.stringBufferForScrollableStatement.delete(0, this.stringBufferForScrollableStatement.length());
        }

        this.stringBufferForScrollableStatement.append("delete from (");
        this.stringBufferForScrollableStatement.append(var2);
        this.stringBufferForScrollableStatement.append(") where ");
        if (var3) {
            this.stringBufferForScrollableStatement.append(" ROWID = ?");
        } else {
            this.stringBufferForScrollableStatement.append(" ROWID = :" + this.generateParameterName());
        }

        this.paramSuffix = 0;
        return this.stringBufferForScrollableStatement.substring(0, this.stringBufferForScrollableStatement.length());
    }

    final boolean generatedSqlNeedEscapeProcessing() {
        return this.parameterCount > 0 && this.parameterList == EMPTY_LIST;
    }

    byte[] getSqlBytes(boolean var1, boolean var2) throws SQLException {
        if (this.sqlBytes == null || var1 != this.currentProcessEscapes) {
            this.sqlBytes = this.conversion.StringToCharBytes(this.getSql(var1, var2));
        }

        return this.sqlBytes;
    }

    SqlKind getSqlKind() throws SQLException {
        if (this.parameterSql == null) {
            return SqlKind.UNINITIALIZED;
        } else {
            if (this.sqlKind == SqlKind.UNINITIALIZED) {
                this.computeBasicInfo(this.parameterSql);
            }

            return this.sqlKind;
        }
    }

    protected int getParameterCount() throws SQLException {
        if (this.parameterCount == -1) {
            this.computeBasicInfo(this.parameterSql);
        }

        return this.parameterCount;
    }

    protected String[] getParameterList() throws SQLException {
        if (this.parameterCount == -1) {
            this.computeBasicInfo(this.parameterSql);
        }

        return this.parameterList;
    }

    void setIncludeRowid(boolean var1) {
        if (var1 != this.includeRowid) {
            this.includeRowid = var1;
            this.rowidSql = null;
            this.actualSql = null;
            this.sqlBytes = null;
        }

    }

    public String toString() {
        return this.parameterSql == null ? "null" : this.parameterSql;
    }

    private String hexUnicode(int var1) throws SQLException {
        String var2 = Integer.toHexString(var1);
        switch(var2.length()) {
            case 0:
                return "\\0000";
            case 1:
                return "\\000" + var2;
            case 2:
                return "\\00" + var2;
            case 3:
                return "\\0" + var2;
            case 4:
                return "\\" + var2;
            default:
                SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 89, "Unexpected case in OracleSql.hexUnicode: " + var1);
                var3.fillInStackTrace();
                throw var3;
        }
    }

    String convertNcharLiterals(String var1) throws SQLException {
        if (this.lastNcharLiteralLocation <= 2) {
            return var1;
        } else {
            String var2 = "";
            int var3 = 0;

            while(true) {
                int var4 = this.ncharLiteralLocation[var3++];
                int var5 = this.ncharLiteralLocation[var3++];
                var2 = var2 + var1.substring(var4, var5);
                if (var3 >= this.lastNcharLiteralLocation) {
                    return var2;
                }

                var4 = this.ncharLiteralLocation[var3];
                var2 = var2 + "u'";

                for(int var6 = var5 + 2; var6 < var4; ++var6) {
                    char var7 = var1.charAt(var6);
                    if (var7 == '\\') {
                        var2 = var2 + "\\\\";
                    } else if (var7 < 128) {
                        var2 = var2 + var7;
                    } else {
                        var2 = var2 + this.hexUnicode(var7);
                    }
                }
            }
        }
    }

    void computeBasicInfo(String var1) throws SQLException {
        this.parameterCount = 0;
        boolean var2 = false;
        boolean var3 = false;
        this.returningIntoParameterCount = 0;
        this.lastNcharLiteralLocation = 0;
        this.ncharLiteralLocation[this.lastNcharLiteralLocation++] = 0;
        char var4 = 0;
        int var5 = 0;
        int var6 = 0;
        int var7 = var1.length();
        int var8 = -1;
        int var9 = -1;
        int var10 = var7 + 1;

        for(int var11 = 0; var11 < var10; ++var11) {
            char var12 = var11 < var7 ? var1.charAt(var11) : 32;
            this.currentChar = var12;
            if (var12 > 127) {
                if (Character.isLetterOrDigit(var12)) {
                    this.currentChar = 'X';
                } else {
                    this.currentChar = ' ';
                }
            }

            switch(ACTION[var6][this.currentChar]) {
                case 0:
                default:
                    break;
                case 1:
                    this.sqlKind = SqlKind.DELETE;
                    break;
                case 2:
                    this.sqlKind = SqlKind.INSERT;
                    break;
                case 3:
                    this.sqlKind = SqlKind.MERGE;
                    break;
                case 4:
                    this.sqlKind = SqlKind.UPDATE;
                    break;
                case 5:
                    this.sqlKind = SqlKind.PLSQL_BLOCK;
                    break;
                case 6:
                    this.sqlKind = SqlKind.CALL_BLOCK;
                    break;
                case 7:
                    this.sqlKind = SqlKind.SELECT;
                    this.selectEndIndex = var11;
                    break;
                case 8:
                    this.sqlKind = SqlKind.OTHER;
                    break;
                case 9:
                    this.whereStartIndex = var11 - 5;
                    this.whereEndIndex = var11;
                    break;
                case 10:
                    var8 = var11 - 5;
                    break;
                case 11:
                    this.orderByStartIndex = var8;
                    this.orderByEndIndex = var11;
                    break;
                case 12:
                    var9 = var11 - 3;
                    break;
                case 13:
                    this.forUpdateStartIndex = var9;
                    this.forUpdateEndIndex = var11;
                    if (this.sqlKind == SqlKind.SELECT) {
                        this.sqlKind = SqlKind.SELECT_FOR_UPDATE;
                    }
                    break;
                case 14:
                    ++this.parameterCount;
                    if (var3) {
                        ++this.returningIntoParameterCount;
                    }
                    break;
                case 15:
                    if (this.currentParameter == null) {
                        this.currentParameter = new char[258];
                    }

                    if (var5 >= this.currentParameter.length) {
                        SQLException var14 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 134, new String(this.currentParameter));
                        var14.fillInStackTrace();
                        throw var14;
                    }

                    this.currentParameter[var5++] = var12;
                    break;
                case 16:
                    if (var5 > 0) {
                        if (this.parameterList == EMPTY_LIST) {
                            this.parameterList = new String[Math.max(8, this.parameterCount * 4)];
                        } else if (this.parameterList.length <= this.parameterCount) {
                            String[] var13 = new String[this.parameterList.length * 4];
                            System.arraycopy(this.parameterList, 0, var13, 0, this.parameterList.length);
                            this.parameterList = var13;
                        }

                        this.parameterList[this.parameterCount] = (new String(this.currentParameter, 0, var5)).intern();
                        var5 = 0;
                        ++this.parameterCount;
                        if (var3) {
                            ++this.returningIntoParameterCount;
                        }
                    }
                    break;
                case 17:
                    this.ncharLiteralLocation[this.lastNcharLiteralLocation++] = var11 - 1;
                    if (this.lastNcharLiteralLocation >= this.ncharLiteralLocation.length) {
                        this.growNcharLiteralLocation(this.ncharLiteralLocation.length << 2);
                    }
                    break;
                case 18:
                    this.ncharLiteralLocation[this.lastNcharLiteralLocation++] = var11;
                    if (this.lastNcharLiteralLocation >= this.ncharLiteralLocation.length) {
                        this.growNcharLiteralLocation(this.ncharLiteralLocation.length << 2);
                    }
                    break;
                case 19:
                    if (var12 == '[') {
                        var4 = ']';
                    } else if (var12 == '{') {
                        var4 = '}';
                    } else if (var12 == '<') {
                        var4 = '>';
                    } else if (var12 == '(') {
                        var4 = ')';
                    } else {
                        var4 = var12;
                    }
                    break;
                case 20:
                    if (var12 == var4) {
                        ++var6;
                    }
                    break;
                case 21:
                    this.sqlKind = SqlKind.ALTER_SESSION;
                    break;
                case 22:
                    var2 = true;
                    break;
                case 23:
                    if (var2) {
                        var3 = true;
                    }
            }

            var6 = TRANSITION[var6][this.currentChar];
        }

        if (this.lastNcharLiteralLocation + 2 >= this.ncharLiteralLocation.length) {
            this.growNcharLiteralLocation(this.lastNcharLiteralLocation + 2);
        }

        this.ncharLiteralLocation[this.lastNcharLiteralLocation++] = var7;
        this.ncharLiteralLocation[this.lastNcharLiteralLocation] = var7;
    }

    void growNcharLiteralLocation(int var1) {
        int[] var2 = new int[var1];
        System.arraycopy(this.ncharLiteralLocation, 0, var2, 0, this.ncharLiteralLocation.length);
        this.ncharLiteralLocation = null;
        this.ncharLiteralLocation = var2;
    }

    private String addRowid(String var1) throws SQLException {
        if (this.selectEndIndex == -1) {
            SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 88);
            var3.fillInStackTrace();
            throw var3;
        } else {
            String var2 = "select rowid as \"__Oracle_JDBC_interal_ROWID__\"," + var1.substring(this.selectEndIndex);
            return var2;
        }
    }

    String parse(String var1) throws SQLException {
        this.first = true;
        this.current_argument = 1;
        this.i = 0;
        this.odbc_sql = var1;
        this.length = this.odbc_sql.length();
        if (this.oracle_sql == null) {
            this.oracle_sql = new StringBuffer(this.length);
            this.token_buffer = new StringBuffer(32);
        } else {
            this.oracle_sql.ensureCapacity(this.length);
        }

        this.oracle_sql.delete(0, this.oracle_sql.length());
        this.skipSpace();
        this.handleODBC(OracleSql.ParseMode.NORMAL);
        if (this.i < this.length) {
            Integer var2 = this.i;
            SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 33, var2);
            var3.fillInStackTrace();
            throw var3;
        } else {
            return this.oracle_sql.substring(0, this.oracle_sql.length());
        }
    }

    void handleODBC(OracleSql.ParseMode var1) throws SQLException {
        int var2 = var1 == OracleSql.ParseMode.NORMAL ? 0 : 66;
        char var3 = 0;

        for(int var4 = 0; this.i < this.length; ++this.i) {
            char var5 = this.i < this.length ? this.odbc_sql.charAt(this.i) : 32;
            this.currentChar = var5;
            if (var5 > 127) {
                if (Character.isLetterOrDigit(var5)) {
                    this.currentChar = 'X';
                } else {
                    this.currentChar = ' ';
                }
            }

            switch(ODBC_ACTION[var2][this.currentChar]) {
                case NONE:
                default:
                    break;
                case COPY:
                    this.oracle_sql.append(var5);
                    break;
                case QUESTION:
                    this.oracle_sql.append(this.nextArgument());
                    this.oracle_sql.append(' ');
                    break;
                case SAVE_DELIMITER:
                    if (var5 == '[') {
                        var3 = ']';
                    } else if (var5 == '{') {
                        var3 = '}';
                    } else if (var5 == '<') {
                        var3 = '>';
                    } else if (var5 == '(') {
                        var3 = ')';
                    } else {
                        var3 = var5;
                    }

                    this.oracle_sql.append(var5);
                    break;
                case LOOK_FOR_DELIMITER:
                    if (var5 == var3) {
                        ++var2;
                    }

                    this.oracle_sql.append(var5);
                    break;
                case FUNCTION:
                    this.handleFunction();
                    break;
                case CALL:
                    this.handleCall();
                    break;
                case TIME:
                    this.handleTime();
                    break;
                case TIMESTAMP:
                    this.handleTimestamp();
                    break;
                case DATE:
                    this.handleDate();
                    break;
                case ESCAPE:
                    this.handleEscape();
                    break;
                case SCALAR_FUNCTION:
                    this.handleScalarFunction();
                    break;
                case OUTER_JOIN:
                    this.handleOuterJoin();
                    break;
                case UNKNOWN_ESCAPE:
                    SQLException var6 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 34, this.i);
                    var6.fillInStackTrace();
                    throw var6;
                case END_ODBC_ESCAPE:
                    if (var1 == OracleSql.ParseMode.SCALAR) {
                        var2 = TRANSITION[var2][this.currentChar];
                        return;
                    }
                case COMMA:
                    if (var1 == OracleSql.ParseMode.LOCATE_1 && var4 > 1) {
                        this.oracle_sql.append(var5);
                    } else {
                        if (var1 == OracleSql.ParseMode.LOCATE_1) {
                            var2 = TRANSITION[var2][this.currentChar];
                            return;
                        }

                        if (var1 != OracleSql.ParseMode.LOCATE_2) {
                            this.oracle_sql.append(var5);
                        }
                    }
                    break;
                case OPEN_PAREN:
                    if (var1 == OracleSql.ParseMode.LOCATE_1) {
                        if (var4 > 0) {
                            this.oracle_sql.append(var5);
                        }

                        ++var4;
                    } else if (var1 == OracleSql.ParseMode.LOCATE_2) {
                        ++var4;
                        this.oracle_sql.append(var5);
                    } else {
                        this.oracle_sql.append(var5);
                    }
                    break;
                case CLOSE_PAREN:
                    if (var1 == OracleSql.ParseMode.LOCATE_1) {
                        --var4;
                        this.oracle_sql.append(var5);
                    } else if (var1 == OracleSql.ParseMode.LOCATE_2 && var4 > 1) {
                        --var4;
                        this.oracle_sql.append(var5);
                    } else {
                        if (var1 == OracleSql.ParseMode.LOCATE_2) {
                            ++this.i;
                            var2 = TRANSITION[var2][this.currentChar];
                            return;
                        }

                        this.oracle_sql.append(var5);
                    }
                    break;
                case BEGIN:
                    this.first = false;
                    this.oracle_sql.append(var5);
                    break;
                case LIMIT:
                    this.handleLimit();
            }

            var2 = TRANSITION[var2][this.currentChar];
        }

    }

    void handleFunction() throws SQLException {
        boolean var1 = this.first;
        this.first = false;
        if (var1) {
            this.oracle_sql.append("BEGIN ");
        }

        this.appendChar(this.oracle_sql, '?');
        this.skipSpace();
        String var2;
        SQLException var3;
        if (this.currentChar != '=') {
            var2 = this.i + ". Expecting \"=\" got \"" + this.currentChar + "\"";
            var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 33, var2);
            var3.fillInStackTrace();
            throw var3;
        } else {
            ++this.i;
            this.skipSpace();
            if (!this.odbc_sql.startsWith("call", this.i)) {
                var2 = this.i + ". Expecting \"call\"";
                var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 33, var2);
                var3.fillInStackTrace();
                throw var3;
            } else {
                this.i += 4;
                this.oracle_sql.append(" := ");
                this.skipSpace();
                this.handleODBC(OracleSql.ParseMode.SCALAR);
                if (var1) {
                    this.oracle_sql.append("; END;");
                }

            }
        }
    }

    void handleCall() throws SQLException {
        boolean var1 = this.first;
        this.first = false;
        if (var1) {
            this.oracle_sql.append("BEGIN ");
        }

        this.skipSpace();
        this.handleODBC(OracleSql.ParseMode.SCALAR);
        this.skipSpace();
        if (var1) {
            this.oracle_sql.append("; END;");
        }

    }

    void handleTimestamp() throws SQLException {
        this.oracle_sql.append("TO_TIMESTAMP (");
        this.skipSpace();
        this.handleODBC(OracleSql.ParseMode.SCALAR);
        this.oracle_sql.append(", 'YYYY-MM-DD HH24:MI:SS.FF')");
    }

    void handleTime() throws SQLException {
        this.skipSpace();
        this.oracle_sql.append("TO_DATE('1-JAN-1970 '||TO_CHAR(TO_DATE(");
        this.handleODBC(OracleSql.ParseMode.SCALAR);
        this.oracle_sql.append(",'HH24:MI:SS'),'HH24:MI:SS'),'DD-MON-YYYY HH24:MI:SS')");
    }

    void handleDate() throws SQLException {
        this.oracle_sql.append("TO_DATE (");
        this.skipSpace();
        this.handleODBC(OracleSql.ParseMode.SCALAR);
        this.oracle_sql.append(", 'YYYY-MM-DD')");
    }

    void handleEscape() throws SQLException {
        this.oracle_sql.append("ESCAPE ");
        this.skipSpace();
        this.handleODBC(OracleSql.ParseMode.SCALAR);
    }

    void handleLimit() throws SQLException {
        this.oracle_sql.append("ROWNUM <= ");
        this.skipSpace();
        this.handleODBC(OracleSql.ParseMode.SCALAR);
    }

    void handleScalarFunction() throws SQLException {
        this.token_buffer.delete(0, this.token_buffer.length());
        ++this.i;
        this.skipSpace();

        while(this.i < this.length && (Character.isJavaLetterOrDigit(this.currentChar = this.odbc_sql.charAt(this.i)) || this.currentChar == '?')) {
            this.token_buffer.append(this.currentChar);
            ++this.i;
        }

        String var1 = this.token_buffer.substring(0, this.token_buffer.length()).toUpperCase().intern();
        if (var1 == "ABS") {
            this.usingFunctionName(var1);
        } else if (var1 == "ACOS") {
            this.usingFunctionName(var1);
        } else if (var1 == "ASIN") {
            this.usingFunctionName(var1);
        } else if (var1 == "ATAN") {
            this.usingFunctionName(var1);
        } else if (var1 == "ATAN2") {
            this.usingFunctionName(var1);
        } else if (var1 == "CEILING") {
            this.usingFunctionName("CEIL");
        } else if (var1 == "COS") {
            this.usingFunctionName(var1);
        } else {
            SQLException var4;
            if (var1 == "COT") {
                var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 34, var1);
                var4.fillInStackTrace();
                throw var4;
            }

            if (var1 == "DEGREES") {
                var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 34, var1);
                var4.fillInStackTrace();
                throw var4;
            }

            if (var1 == "EXP") {
                this.usingFunctionName(var1);
            } else if (var1 == "FLOOR") {
                this.usingFunctionName(var1);
            } else if (var1 == "LOG") {
                this.usingFunctionName("LN");
            } else if (var1 == "LOG10") {
                this.replacingFunctionPrefix("LOG ( 10, ");
            } else if (var1 == "MOD") {
                this.usingFunctionName(var1);
            } else if (var1 == "PI") {
                this.replacingFunctionPrefix("( 3.141592653589793238462643383279502884197169399375 ");
            } else if (var1 == "POWER") {
                this.usingFunctionName(var1);
            } else {
                if (var1 == "RADIANS") {
                    var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 34, var1);
                    var4.fillInStackTrace();
                    throw var4;
                }

                if (var1 == "RAND") {
                    var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 34, var1);
                    var4.fillInStackTrace();
                    throw var4;
                }

                if (var1 == "ROUND") {
                    this.usingFunctionName(var1);
                } else if (var1 == "SIGN") {
                    this.usingFunctionName(var1);
                } else if (var1 == "SIN") {
                    this.usingFunctionName(var1);
                } else if (var1 == "SQRT") {
                    this.usingFunctionName(var1);
                } else if (var1 == "TAN") {
                    this.usingFunctionName(var1);
                } else if (var1 == "TRUNCATE") {
                    this.usingFunctionName("TRUNC");
                } else if (var1 == "ASCII") {
                    this.usingFunctionName(var1);
                } else if (var1 == "CHAR") {
                    this.usingFunctionName("CHR");
                } else if (var1 == "CHAR_LENGTH") {
                    this.usingFunctionName("LENGTH");
                } else if (var1 == "CHARACTER_LENGTH") {
                    this.usingFunctionName("LENGTH");
                } else if (var1 == "CONCAT") {
                    this.usingFunctionName(var1);
                } else {
                    if (var1 == "DIFFERENCE") {
                        var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 34, var1);
                        var4.fillInStackTrace();
                        throw var4;
                    }

                    if (var1 == "INSERT") {
                        var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 34, var1);
                        var4.fillInStackTrace();
                        throw var4;
                    }

                    if (var1 == "LCASE") {
                        this.usingFunctionName("LOWER");
                    } else {
                        if (var1 == "LEFT") {
                            var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 34, var1);
                            var4.fillInStackTrace();
                            throw var4;
                        }

                        if (var1 == "LENGTH") {
                            this.usingFunctionName(var1);
                        } else if (var1 == "LOCATE") {
                            StringBuffer var2 = this.oracle_sql;
                            this.oracle_sql = new StringBuffer();
                            this.handleODBC(OracleSql.ParseMode.LOCATE_1);
                            StringBuffer var3 = this.oracle_sql;
                            this.oracle_sql = var2;
                            this.oracle_sql.append("INSTR(");
                            this.handleODBC(OracleSql.ParseMode.LOCATE_2);
                            this.oracle_sql.append(',');
                            this.oracle_sql.append(var3);
                            this.oracle_sql.append(')');
                            this.handleODBC(OracleSql.ParseMode.SCALAR);
                        } else if (var1 == "LTRIM") {
                            this.usingFunctionName(var1);
                        } else if (var1 == "OCTET_LENGTH") {
                            this.usingFunctionName("LENGTHB");
                        } else {
                            if (var1 == "POSITION") {
                                var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 34, var1);
                                var4.fillInStackTrace();
                                throw var4;
                            }

                            if (var1 == "REPEAT") {
                                var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 34, var1);
                                var4.fillInStackTrace();
                                throw var4;
                            }

                            if (var1 == "REPLACE") {
                                this.usingFunctionName(var1);
                            } else {
                                if (var1 == "RIGHT") {
                                    var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 34, var1);
                                    var4.fillInStackTrace();
                                    throw var4;
                                }

                                if (var1 == "RTRIM") {
                                    this.usingFunctionName(var1);
                                } else if (var1 == "SOUNDEX") {
                                    this.usingFunctionName(var1);
                                } else {
                                    if (var1 == "SPACE") {
                                        var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 34, var1);
                                        var4.fillInStackTrace();
                                        throw var4;
                                    }

                                    if (var1 == "SUBSTRING") {
                                        this.usingFunctionName("SUBSTR");
                                    } else if (var1 == "UCASE") {
                                        this.usingFunctionName("UPPER");
                                    } else if (var1 == "CURRENT_DATE") {
                                        this.replacingFunctionPrefix("(CURRENT_DATE");
                                    } else {
                                        if (var1 == "CURRENT_TIME") {
                                            var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 34, var1);
                                            var4.fillInStackTrace();
                                            throw var4;
                                        }

                                        if (var1 == "CURRENT_TIMESTAMP") {
                                            this.replacingFunctionPrefix("(CURRENT_TIMESTAMP");
                                        } else if (var1 == "CURDATE") {
                                            this.replacingFunctionPrefix("(CURRENT_DATE");
                                        } else if (var1 == "CURTIME") {
                                            this.replacingFunctionPrefix("(CURRENT_TIMESTAMP");
                                        } else {
                                            if (var1 == "DAYNAME") {
                                                var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 34, var1);
                                                var4.fillInStackTrace();
                                                throw var4;
                                            }

                                            if (var1 == "DAYOFMONTH") {
                                                this.replacingFunctionPrefix("EXTRACT ( DAY FROM ");
                                            } else {
                                                if (var1 == "DAYOFWEEK") {
                                                    var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 34, var1);
                                                    var4.fillInStackTrace();
                                                    throw var4;
                                                }

                                                if (var1 == "DAYOFYEAR") {
                                                    var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 34, var1);
                                                    var4.fillInStackTrace();
                                                    throw var4;
                                                }

                                                if (var1 == "EXTRACT") {
                                                    this.usingFunctionName("EXTRACT");
                                                } else if (var1 == "HOUR") {
                                                    this.replacingFunctionPrefix("EXTRACT ( HOUR FROM ");
                                                } else if (var1 == "MINUTE") {
                                                    this.replacingFunctionPrefix("EXTRACT ( MINUTE FROM ");
                                                } else if (var1 == "MONTH") {
                                                    this.replacingFunctionPrefix("EXTRACT ( MONTH FROM ");
                                                } else {
                                                    if (var1 == "MONTHNAME") {
                                                        var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 34, var1);
                                                        var4.fillInStackTrace();
                                                        throw var4;
                                                    }

                                                    if (var1 == "NOW") {
                                                        this.replacingFunctionPrefix("(CURRENT_TIMESTAMP");
                                                    } else {
                                                        if (var1 == "QUARTER") {
                                                            var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 34, var1);
                                                            var4.fillInStackTrace();
                                                            throw var4;
                                                        }

                                                        if (var1 == "SECOND") {
                                                            this.replacingFunctionPrefix("EXTRACT ( SECOND FROM ");
                                                        } else {
                                                            if (var1 == "TIMESTAMPADD") {
                                                                var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 34, var1);
                                                                var4.fillInStackTrace();
                                                                throw var4;
                                                            }

                                                            if (var1 == "TIMESTAMPDIFF") {
                                                                var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 34, var1);
                                                                var4.fillInStackTrace();
                                                                throw var4;
                                                            }

                                                            if (var1 == "WEEK") {
                                                                var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 34, var1);
                                                                var4.fillInStackTrace();
                                                                throw var4;
                                                            }

                                                            if (var1 == "YEAR") {
                                                                this.replacingFunctionPrefix("EXTRACT ( YEAR FROM ");
                                                            } else {
                                                                if (var1 == "DATABASE") {
                                                                    var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 34, var1);
                                                                    var4.fillInStackTrace();
                                                                    throw var4;
                                                                }

                                                                if (var1 == "IFNULL") {
                                                                    this.usingFunctionName("NVL");
                                                                } else {
                                                                    if (var1 != "USER") {
                                                                        if (var1 == "CONVERT") {
                                                                            var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 34, var1);
                                                                            var4.fillInStackTrace();
                                                                            throw var4;
                                                                        }

                                                                        var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 34, var1);
                                                                        var4.fillInStackTrace();
                                                                        throw var4;
                                                                    }

                                                                    this.replacingFunctionPrefix("(USER");
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

    }

    void usingFunctionName(String var1) throws SQLException {
        this.oracle_sql.append(var1);
        this.skipSpace();
        this.handleODBC(OracleSql.ParseMode.SCALAR);
    }

    void replacingFunctionPrefix(String var1) throws SQLException {
        this.skipSpace();
        if (this.i < this.length && (this.currentChar = this.odbc_sql.charAt(this.i)) == '(') {
            ++this.i;
            this.oracle_sql.append(var1);
            this.skipSpace();
            this.handleODBC(OracleSql.ParseMode.SCALAR);
        } else {
            SQLException var2 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 33);
            var2.fillInStackTrace();
            throw var2;
        }
    }

    void handleOuterJoin() throws SQLException {
        this.oracle_sql.append(" ( ");
        this.skipSpace();
        this.handleODBC(OracleSql.ParseMode.SCALAR);
        this.oracle_sql.append(" ) ");
    }

    String nextArgument() {
        String var1 = ":" + this.current_argument;
        ++this.current_argument;
        return var1;
    }

    void appendChar(StringBuffer var1, char var2) {
        if (var2 == '?') {
            var1.append(this.nextArgument());
        } else {
            var1.append(var2);
        }

    }

    void skipSpace() {
        while(this.i < this.length && (this.currentChar = this.odbc_sql.charAt(this.i)) == ' ') {
            ++this.i;
        }

    }

    String generateParameterName() {
        if (this.parameterCount != 0 && this.parameterList != null) {
            label20:
            while(true) {
                String var1 = "rowid" + this.paramSuffix++;

                for(int var2 = 0; var2 < this.parameterList.length; ++var2) {
                    if (var1.equals(this.parameterList[var2])) {
                        continue label20;
                    }
                }

                return var1;
            }
        } else {
            return "rowid" + this.paramSuffix++;
        }
    }

    static boolean isValidPlsqlWarning(String var0) throws SQLException {
        return var0.matches("('\\s*([a-zA-Z0-9:,\\(\\)\\s])*')\\s*(,\\s*'([a-zA-Z0-9:,\\(\\)\\s])*')*");
    }

    public static boolean isValidObjectName(String var0) throws SQLException {
        if (var0.matches("([a-zA-Z]{1}\\w*(\\$|\\#)*\\w*)|(\".*)")) {
            return true;
        } else {
            char[] var1 = var0.toCharArray();
            int var2 = var1.length;
            if (!Character.isLetter(var1[0])) {
                return false;
            } else {
                for(int var3 = 1; var3 < var2; ++var3) {
                    if (!Character.isLetterOrDigit(var1[var3]) && var1[var3] != '$' && var1[var3] != '#' && var1[var3] != '_') {
                        return false;
                    }
                }

                return true;
            }
        }
    }

    public static void main(String[] var0) {
        if (var0.length < 2) {
            System.err.println("ERROR: incorrect usage. OracleSql (-transition <file> | <process_escapes> <convert_nchars> { <sql> } )");
        } else if (var0[0].equals("-dump")) {
            dumpTransitionMatrix(var0[1]);
        } else {
            boolean var1 = var0[0].equals("true");
            boolean var2 = var0[1].equals("true");
            String[] var3;
            if (var0.length > 2) {
                var3 = new String[var0.length - 2];
                System.arraycopy(var0, 2, var3, 0, var3.length);
            } else {
                var3 = new String[]{"select ? from dual", "insert into dual values (?)", "delete from dual", "update dual set dummy = ?", "merge tab into dual", " select ? from dual where ? = ?", "select ?from dual where?=?for update", "select '?', n'?', q'???', q'{?}', q'{cat's}' from dual", "select'?',n'?',q'???',q'{?}',q'{cat's}'from dual", "select--line\n? from dual", "select --line\n? from dual", "--line\nselect ? from dual", " --line\nselect ? from dual", "--line\n select ? from dual", "begin proc4in4out (:x1, :x2, :x3, :x4); end;", "{CALL tkpjpn01(:pin, :pinout, :pout)}", "select :NumberBindVar as the_number from dual", "select {fn locate(bob(carol(),ted(alice,sue)), 'xfy')} from dual", "CREATE USER vijay6 IDENTIFIED BY \"vjay?\"", "ALTER SESSION SET TIME", "SELECT ename FROM emp WHERE hiredate BETWEEN {ts'1980-12-17'} AND {ts '1981-09-28'} "};
            }

            String[] var4 = var3;
            int var5 = var3.length;

            for(int var6 = 0; var6 < var5; ++var6) {
                String var7 = var4[var6];

                try {
                    System.out.println("\n\n-----------------------");
                    System.out.println(var7);
                    System.out.println();
                    OracleSql var8 = new OracleSql((DBConversion)null);
                    var8.initialize(var7);
                    String var9 = var8.getSql(var1, var2);
                    System.out.println(var8.sqlKind + ", " + var8.parameterCount);
                    String[] var10 = var8.getParameterList();
                    int var11;
                    if (var10 == EMPTY_LIST) {
                        System.out.println("parameterList is empty");
                    } else {
                        for(var11 = 0; var11 < var10.length; ++var11) {
                            System.out.println("parameterList[" + var11 + "] = " + var10[var11]);
                        }
                    }

                    if (var8.getSqlKind().isDML()) {
                        var11 = var8.getReturnParameterCount();
                        if (var11 == -1) {
                            System.out.println("no return parameters");
                        } else {
                            System.out.println(var11 + " return parameters");
                        }
                    }

                    if (var8.lastNcharLiteralLocation == 2) {
                        System.out.println("No NCHAR literals");
                    } else {
                        System.out.println("NCHAR Literals");
                        var11 = 1;

                        while(var11 < var8.lastNcharLiteralLocation - 1) {
                            System.out.println(var9.substring(var8.ncharLiteralLocation[var11++], var8.ncharLiteralLocation[var11++]));
                        }
                    }

                    System.out.println("Keywords");
                    if (var8.selectEndIndex == -1) {
                        System.out.println("no select");
                    } else {
                        System.out.println("'" + var9.substring(var8.selectEndIndex - 6, var8.selectEndIndex) + "'");
                    }

                    if (var8.orderByStartIndex == -1) {
                        System.out.println("no order by");
                    } else {
                        System.out.println("'" + var9.substring(var8.orderByStartIndex, var8.orderByEndIndex) + "'");
                    }

                    if (var8.whereStartIndex == -1) {
                        System.out.println("no where");
                    } else {
                        System.out.println("'" + var9.substring(var8.whereStartIndex, var8.whereEndIndex) + "'");
                    }

                    if (var8.forUpdateStartIndex == -1) {
                        System.out.println("no for update");
                    } else {
                        System.out.println("'" + var9.substring(var8.forUpdateStartIndex, var8.forUpdateEndIndex) + "'");
                    }

                    System.out.println("isPlsqlOrCall(): " + var8.getSqlKind().isPlsqlOrCall());
                    System.out.println("isDML(): " + var8.getSqlKind().isDML());
                    System.out.println("isSELECT(): " + var8.getSqlKind().isSELECT());
                    System.out.println("isOTHER(): " + var8.getSqlKind().isOTHER());
                    System.out.println("\"" + var9 + "\"");
                    System.out.println("\"" + var8.getRevisedSql() + "\"");
                    System.out.println("\"" + var8.getRefetchSql() + "\"");
                } catch (Exception var12) {
                    System.out.println(var12);
                }
            }

        }
    }

    private static final void dumpTransitionMatrix(String var0) {
        try {
            PrintWriter var1 = new PrintWriter(var0);
            var1.print(",");

            for(int var2 = 0; var2 < 128; ++var2) {
                var1.print("'" + (var2 < 32 ? "0x" + Integer.toHexString(var2) : Character.toString((char)var2)) + (var2 < 127 ? "'," : "'"));
            }

            var1.println();
            int[][] var7 = OracleSqlReadOnly.TRANSITION;
            String[] var3 = OracleSqlReadOnly.PARSER_STATE_NAME;

            for(int var4 = 0; var4 < TRANSITION.length; ++var4) {
                var1.print(var3[var4] + ",");

                for(int var5 = 0; var5 < var7[var4].length; ++var5) {
                    var1.print(var3[var7[var4][var5]] + (var5 < 127 ? "," : ""));
                }

                var1.println();
            }

            var1.close();
        } catch (Throwable var6) {
            System.err.println(var6);
        }

    }

    protected OracleConnection getConnectionDuringExceptionHandling() {
        return null;
    }

    int getReturnParameterCount() throws SQLException {
        if (this.sqlKind == SqlKind.UNINITIALIZED) {
            this.computeBasicInfo(this.parameterSql);
        }

        return !this.sqlKind.isDML() ? -1 : this.returningIntoParameterCount;
    }

    private int getSubstrPos(String var1, String var2) throws SQLException {
        int var3 = -1;
        int var4 = var1.indexOf(var2);
        if (var4 >= 1 && Character.isWhitespace(var1.charAt(var4 - 1))) {
            int var5 = var4 + var2.length();
            if (var5 < var1.length() && Character.isWhitespace(var1.charAt(var5))) {
                var3 = var4;
            }
        }

        return var3;
    }

    static {
        TRANSITION = OracleSqlReadOnly.TRANSITION;
        ACTION = OracleSqlReadOnly.ACTION;
        ODBC_ACTION = OracleSqlReadOnly.ODBC_ACTION;
        _Copyright_2007_Oracle_All_Rights_Reserved_ = null;
    }

    static enum ParseMode {
        NORMAL,
        SCALAR,
        LOCATE_1,
        LOCATE_2;

        private ParseMode() {
        }
    }
}
