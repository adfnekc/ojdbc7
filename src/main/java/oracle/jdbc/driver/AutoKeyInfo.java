//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package oracle.jdbc.driver;

import java.sql.SQLException;
import oracle.jdbc.internal.OracleStatement.SqlKind;

class AutoKeyInfo extends OracleResultSetMetaData {
    String originalSql;
    String newSql;
    String tableName;
    SqlKind sqlKind;
    int sqlParserParamCount;
    String[] sqlParserParamList;
    boolean useNamedParameter;
    int current_argument;
    String[] columnNames;
    int[] columnIndexes;
    int numColumns;
    String[] tableColumnNames;
    int[] tableColumnTypes;
    int[] tableMaxLengths;
    boolean[] tableNullables;
    short[] tableFormOfUses;
    int[] tablePrecisions;
    int[] tableScales;
    String[] tableTypeNames;
    int autoKeyType;
    static final int KEYFLAG = 0;
    static final int COLUMNAME = 1;
    static final int COLUMNINDEX = 2;
    static final char QMARK = '?';
    int[] returnTypes;
    Accessor[] returnAccessors;
    private static final ThreadLocal<OracleSql> SQL_PARSER = new ThreadLocal() {
        protected OracleSql initialValue() {
            return new OracleSql((DBConversion)null);
        }
    };
    private static final String _Copyright_2007_Oracle_All_Rights_Reserved_ = null;
    public static final String BUILD_DATE = "Thu_Apr_04_15:09:24_PDT_2013";
    public static final boolean TRACE = false;

    AutoKeyInfo(String var1) {
        this.sqlKind = SqlKind.UNINITIALIZED;
        this.originalSql = var1;
        this.autoKeyType = 0;
    }

    AutoKeyInfo(String var1, String[] var2) {
        this.sqlKind = SqlKind.UNINITIALIZED;
        this.originalSql = var1;
        this.columnNames = var2;
        this.autoKeyType = 1;
    }

    AutoKeyInfo(String var1, int[] var2) {
        this.sqlKind = SqlKind.UNINITIALIZED;
        this.originalSql = var1;
        this.columnIndexes = var2;
        this.autoKeyType = 2;
    }

    private void parseSql() throws SQLException {
        if (this.originalSql == null) {
            SQLException var2 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 68);
            var2.fillInStackTrace();
            throw var2;
        } else {
            OracleSql var1 = (OracleSql)SQL_PARSER.get();
            var1.initialize(this.originalSql);
            this.sqlKind = var1.getSqlKind();
            if (this.sqlKind == SqlKind.INSERT) {
                this.sqlParserParamCount = var1.getParameterCount();
                this.sqlParserParamList = var1.getParameterList();
                if (this.sqlParserParamList == OracleSql.EMPTY_LIST) {
                    this.useNamedParameter = false;
                } else {
                    this.useNamedParameter = true;
                    this.current_argument = this.sqlParserParamCount;
                }
            }

        }
    }

    private String generateUniqueNamedParameter() {
        boolean var1;
        String var2;
        do {
            var1 = false;
            var2 = Integer.toString(++this.current_argument).intern();

            for(int var3 = 0; var3 < this.sqlParserParamCount; ++var3) {
                if (this.sqlParserParamList[var3] == var2) {
                    var1 = true;
                    break;
                }
            }
        } while(var1);

        return ":" + var2;
    }

    String getNewSql() throws SQLException {
        try {
            if (this.newSql != null) {
                return this.newSql;
            } else {
                if (this.sqlKind == SqlKind.UNINITIALIZED) {
                    this.parseSql();
                }

                switch(this.autoKeyType) {
                    case 0:
                        this.newSql = this.originalSql + " RETURNING ROWID INTO " + (this.useNamedParameter ? this.generateUniqueNamedParameter() : '?');
                        this.returnTypes = new int[1];
                        this.returnTypes[0] = 104;
                        break;
                    case 1:
                        this.getNewSqlByColumnName();
                        break;
                    case 2:
                        this.getNewSqlByColumnIndexes();
                }

                this.sqlKind = SqlKind.UNINITIALIZED;
                this.sqlParserParamList = null;
                return this.newSql;
            }
        } catch (Exception var3) {
            SQLException var2 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), var3);
            var2.fillInStackTrace();
            throw var2;
        }
    }

    private String getNewSqlByColumnName() throws SQLException {
        this.returnTypes = new int[this.columnNames.length];
        this.columnIndexes = new int[this.columnNames.length];
        StringBuffer var1 = new StringBuffer(this.originalSql);
        var1.append(" RETURNING ");

        int var3;
        for(var3 = 0; var3 < this.columnNames.length; ++var3) {
            int var2 = this.getReturnParamTypeCode(var3, this.columnNames[var3], this.columnIndexes);
            this.returnTypes[var3] = var2;
            var1.append(this.columnNames[var3]);
            if (var3 < this.columnNames.length - 1) {
                var1.append(", ");
            }
        }

        var1.append(" INTO ");

        for(var3 = 0; var3 < this.columnNames.length - 1; ++var3) {
            var1.append((this.useNamedParameter ? this.generateUniqueNamedParameter() : '?') + ", ");
        }

        var1.append(this.useNamedParameter ? this.generateUniqueNamedParameter() : '?');
        this.newSql = new String(var1);
        return this.newSql;
    }

    private String getNewSqlByColumnIndexes() throws SQLException {
        this.returnTypes = new int[this.columnIndexes.length];
        StringBuffer var1 = new StringBuffer(this.originalSql);
        var1.append(" RETURNING ");

        int var3;
        for(var3 = 0; var3 < this.columnIndexes.length; ++var3) {
            int var4 = this.columnIndexes[var3] - 1;
            if (var4 < 0 || var4 > this.tableColumnNames.length) {
                SQLException var6 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 68);
                var6.fillInStackTrace();
                throw var6;
            }

            int var2 = this.tableColumnTypes[var4];
            String var5 = this.tableColumnNames[var4];
            this.returnTypes[var3] = var2;
            var1.append(var5);
            if (var3 < this.columnIndexes.length - 1) {
                var1.append(", ");
            }
        }

        var1.append(" INTO ");

        for(var3 = 0; var3 < this.columnIndexes.length - 1; ++var3) {
            var1.append((this.useNamedParameter ? this.generateUniqueNamedParameter() : '?') + ", ");
        }

        var1.append(this.useNamedParameter ? this.generateUniqueNamedParameter() : '?');
        this.newSql = new String(var1);
        return this.newSql;
    }

    private final int getReturnParamTypeCode(int var1, String var2, int[] var3) throws SQLException {
        for(int var4 = 0; var4 < this.tableColumnNames.length; ++var4) {
            if (var2.equalsIgnoreCase(this.tableColumnNames[var4])) {
                var3[var1] = var4 + 1;
                return this.tableColumnTypes[var4];
            }
        }

        SQLException var5 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 68);
        var5.fillInStackTrace();
        throw var5;
    }

    final boolean isInsertSqlStmt() throws SQLException {
        if (this.sqlKind == SqlKind.UNINITIALIZED) {
            this.parseSql();
        }

        return this.sqlKind == SqlKind.INSERT;
    }

    String getTableName() throws SQLException {
        if (this.tableName != null) {
            return this.tableName;
        } else {
            String var1 = this.originalSql.trim().toUpperCase();
            int var2 = var1.indexOf("INSERT");
            var2 = var1.indexOf("INTO", var2);
            if (var2 < 0) {
                SQLException var7 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 68);
                var7.fillInStackTrace();
                throw var7;
            } else {
                int var3 = var1.length();

                int var4;
                for(var4 = var2 + 5; var4 < var3 && var1.charAt(var4) == ' '; ++var4) {
                }

                if (var4 >= var3) {
                    SQLException var8 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 68);
                    var8.fillInStackTrace();
                    throw var8;
                } else {
                    int var5;
                    for(var5 = var4 + 1; var5 < var3 && var1.charAt(var5) != ' ' && var1.charAt(var5) != '('; ++var5) {
                    }

                    if (var4 == var5 - 1) {
                        SQLException var6 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 68);
                        var6.fillInStackTrace();
                        throw var6;
                    } else {
                        this.tableName = var1.substring(var4, var5);
                        return this.tableName;
                    }
                }
            }
        }
    }

    void allocateSpaceForDescribedData(int var1) throws SQLException {
        this.numColumns = var1;
        this.tableColumnNames = new String[var1];
        this.tableColumnTypes = new int[var1];
        this.tableMaxLengths = new int[var1];
        this.tableNullables = new boolean[var1];
        this.tableFormOfUses = new short[var1];
        this.tablePrecisions = new int[var1];
        this.tableScales = new int[var1];
        this.tableTypeNames = new String[var1];
    }

    void fillDescribedData(int var1, String var2, int var3, int var4, boolean var5, short var6, int var7, int var8, String var9) throws SQLException {
        this.tableColumnNames[var1] = var2;
        this.tableColumnTypes[var1] = var3;
        this.tableMaxLengths[var1] = var4;
        this.tableNullables[var1] = var5;
        this.tableFormOfUses[var1] = var6;
        this.tablePrecisions[var1] = var7;
        this.tableScales[var1] = var8;
        this.tableTypeNames[var1] = var9;
    }

    void initMetaData(OracleResultSet var1) throws SQLException {
        if (this.returnAccessors == null) {
            this.returnAccessors = var1.getOracleStatement().accessors;
            switch(this.autoKeyType) {
                case 0:
                    this.initMetaDataKeyFlag();
                    break;
                case 1:
                case 2:
                    this.initMetaDataColumnIndexes();
            }

        }
    }

    void initMetaDataKeyFlag() throws SQLException {
        this.returnAccessors[0].columnName = "ROWID";
        this.returnAccessors[0].describeType = 104;
        this.returnAccessors[0].describeMaxLength = 4;
        this.returnAccessors[0].nullable = true;
        this.returnAccessors[0].precision = 0;
        this.returnAccessors[0].scale = 0;
        this.returnAccessors[0].formOfUse = 0;
    }

    void initMetaDataColumnIndexes() throws SQLException {
        for(int var3 = 0; var3 < this.returnAccessors.length; ++var3) {
            Accessor var1 = this.returnAccessors[var3];
            int var2 = this.columnIndexes[var3] - 1;
            var1.columnName = this.tableColumnNames[var2];
            var1.describeType = this.tableColumnTypes[var2];
            var1.describeMaxLength = this.tableMaxLengths[var2];
            var1.nullable = this.tableNullables[var2];
            var1.precision = this.tablePrecisions[var2];
            var1.scale = this.tablePrecisions[var2];
            var1.formOfUse = this.tableFormOfUses[var2];
        }

    }

    int getValidColumnIndex(int var1) throws SQLException {
        if (var1 > 0 && var1 <= this.returnAccessors.length) {
            return var1 - 1;
        } else {
            SQLException var2 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 3);
            var2.fillInStackTrace();
            throw var2;
        }
    }

    public int getColumnCount() throws SQLException {
        return this.returnAccessors.length;
    }

    public String getColumnName(int var1) throws SQLException {
        if (var1 > 0 && var1 <= this.returnAccessors.length) {
            return this.returnAccessors[var1 - 1].columnName;
        } else {
            SQLException var2 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 3);
            var2.fillInStackTrace();
            throw var2;
        }
    }

    public String getTableName(int var1) throws SQLException {
        if (var1 > 0 && var1 <= this.returnAccessors.length) {
            return this.getTableName();
        } else {
            SQLException var2 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 3);
            var2.fillInStackTrace();
            throw var2;
        }
    }

    Accessor[] getDescription() throws SQLException {
        return this.returnAccessors;
    }
}
