//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package oracle.jdbc.driver;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import oracle.jdbc.OracleCallableStatement;
import oracle.jdbc.internal.OracleConnection;
import oracle.jdbc.internal.OracleResultSet;

class OracleDatabaseMetaData extends oracle.jdbc.OracleDatabaseMetaData {
    private static final String _Copyright_2007_Oracle_All_Rights_Reserved_ = null;
    public static final String BUILD_DATE = "Thu_Apr_04_15:09:24_PDT_2013";
    public static final boolean TRACE = false;

    public OracleDatabaseMetaData(OracleConnection var1) {
        super(var1);
    }

    public OracleDatabaseMetaData(oracle.jdbc.driver.OracleConnection var1) {
        this((OracleConnection)var1);
    }

    public synchronized ResultSet getColumns(String var1, String var2, String var3, String var4) throws SQLException {
        boolean var5 = this.connection.getIncludeSynonyms();
        return var5 && var2 != null && !this.hasSqlWildcard(var2) && var3 != null && !this.hasSqlWildcard(var3) ? this.getColumnsNoWildcards(this.stripSqlEscapes(var2), this.stripSqlEscapes(var3), var4) : this.getColumnsWithWildcards(var2, var3, var4, var5);
    }

    ResultSet getColumnsNoWildcards(String var1, String var2, String var3) throws SQLException {
        String var4 = this.getColumnsNoWildcardsPlsql();
        CallableStatement var5 = this.connection.prepareCall(var4);
        var5.setString(1, var1);
        var5.setString(2, var2);
        var5.setString(3, var3 == null ? "%" : var3);
        var5.registerOutParameter(4, -10);
        var5.execute();
        ResultSet var6 = ((OracleCallableStatement)var5).getCursor(4);
        ((OracleResultSet)var6).closeStatementOnClose();
        return var6;
    }

    ResultSet getColumnsWithWildcards(String var1, String var2, String var3, boolean var4) throws SQLException {
        short var5 = this.connection.getVersionNumber();
        String var6 = "SELECT ";
        String var7 = " NULL AS table_cat,\n";
        String var8 = "";
        if (var5 >= 10200 & var5 < 11100 & var4) {
            var8 = "/*+ CHOOSE */";
        }

        String var9 = "       t.owner AS table_schem,\n       t.table_name AS table_name,\n";
        String var10 = "       DECODE(s.owner, NULL, t.owner, s.owner)\n              AS table_schem,\n       DECODE(s.synonym_name, NULL, t.table_name, s.synonym_name)\n              AS table_name,\n";
        String var11 = "         DECODE (t.data_type, 'CHAR', t.char_length,                   'VARCHAR', t.char_length,                   'VARCHAR2', t.char_length,                   'NVARCHAR2', t.char_length,                   'NCHAR', t.char_length,                   'NUMBER', 0,           t.data_length)";
        String var12 = "       t.column_name AS column_name,\n       DECODE (t.data_type, 'CHAR', 1, 'VARCHAR2', 12, 'NUMBER', 3,\n               'LONG', -1, 'DATE', " + (((PhysicalConnection)this.connection).mapDateToTimestamp ? "93" : "91") + ", 'RAW', -3, 'LONG RAW', -4,  \n" + "               'BLOB', 2004, 'CLOB', 2005, 'BFILE', -13, 'FLOAT', 6, \n" + "               'TIMESTAMP(6)', 93, 'TIMESTAMP(6) WITH TIME ZONE', -101, \n" + "               'TIMESTAMP(6) WITH LOCAL TIME ZONE', -102, \n" + "               'INTERVAL YEAR(2) TO MONTH', -103, \n" + "               'INTERVAL DAY(2) TO SECOND(6)', -104, \n" + "               'BINARY_FLOAT', 100, 'BINARY_DOUBLE', 101, \n" + "               'XMLTYPE', 2009, \n" + "               1111)\n" + "              AS data_type,\n" + "       t.data_type AS type_name,\n" + "       DECODE (t.data_precision, " + "               null, DECODE(t.data_type, " + "                       'NUMBER', DECODE(t.data_scale, " + "                                   null, " + (((PhysicalConnection)this.connection).j2ee13Compliant ? "38" : "0") + "                                   , 38), " + var11 + "                           )," + "         t.data_precision)\n" + "              AS column_size,\n" + "       0 AS buffer_length,\n" + "       DECODE (t.data_type, " + "               'NUMBER', DECODE(t.data_precision, " + "                                null, DECODE(t.data_scale, " + "                                             null, " + (((PhysicalConnection)this.connection).j2ee13Compliant ? "0" : "-127") + "                                             , t.data_scale), " + "                                 t.data_scale), " + "               t.data_scale) AS decimal_digits,\n" + "       10 AS num_prec_radix,\n" + "       DECODE (t.nullable, 'N', 0, 1) AS nullable,\n";
        String var13 = "       c.comments AS remarks,\n";
        String var14 = "       NULL AS remarks,\n";
        String var15 = "       t.data_default AS column_def,\n       0 AS sql_data_type,\n       0 AS sql_datetime_sub,\n       t.data_length AS char_octet_length,\n       t.column_id AS ordinal_position,\n       DECODE (t.nullable, 'N', 'NO', 'YES') AS is_nullable,\n";
        String var16 = "         null as SCOPE_CATALOG,\n       null as SCOPE_SCHEMA,\n       null as SCOPE_TABLE,\n       null as SOURCE_DATA_TYPE,\n       'NO' as IS_AUTOINCREMENT\n";
        String var17 = "FROM all_tab_columns t";
        String var18 = ", all_synonyms s";
        String var19 = ", all_col_comments c";
        String var20 = "WHERE t.owner LIKE :1 ESCAPE '/'\n  AND t.table_name LIKE :2 ESCAPE '/'\n  AND t.column_name LIKE :3 ESCAPE '/'\n";
        String var21 = "WHERE (t.owner LIKE :4 ESCAPE '/' OR\n       (s.owner LIKE :5 ESCAPE '/' AND t.owner = s.table_owner))\n  AND (t.table_name LIKE :6 ESCAPE '/' OR\n       s.synonym_name LIKE :7 ESCAPE '/')\n  AND t.column_name LIKE :8 ESCAPE '/'\n";
        String var22 = "  AND t.owner = c.owner (+)\n  AND t.table_name = c.table_name (+)\n  AND t.column_name = c.column_name (+)\n";
        String var23 = "  AND s.table_name (+) = t.table_name\n  AND ((DECODE(s.owner, t.owner, 'OK',\n                       'PUBLIC', 'OK',\n                       NULL, 'OK',\n                       'NOT OK') = 'OK') OR\n       (t.owner LIKE :9 AND t.owner = s.table_owner) OR\n       (s.owner LIKE :10 AND t.owner = s.table_owner))";
        String var24 = "ORDER BY table_schem, table_name, ordinal_position\n";
        String var25 = var6 + var8 + var7;
        if (var4) {
            var25 = var25 + var10;
        } else {
            var25 = var25 + var9;
        }

        var25 = var25 + var12;
        if (this.connection.getRemarksReporting()) {
            var25 = var25 + var13;
        } else {
            var25 = var25 + var14;
        }

        var25 = var25 + var15 + var16 + var17;
        if (this.connection.getRemarksReporting()) {
            var25 = var25 + var19;
        }

        if (var4) {
            var25 = var25 + var18;
        }

        if (var4) {
            var25 = var25 + "\n" + var21;
        } else {
            var25 = var25 + "\n" + var20;
        }

        if (this.connection.getRemarksReporting()) {
            var25 = var25 + var22;
        }

        if (this.connection.getIncludeSynonyms()) {
            var25 = var25 + var23;
        }

        var25 = var25 + "\n" + var24;
        PreparedStatement var26 = this.connection.prepareStatement(var25);
        if (var4) {
            var26.setString(1, var1 == null ? "%" : var1);
            var26.setString(2, var1 == null ? "%" : var1);
            var26.setString(3, var2 == null ? "%" : var2);
            var26.setString(4, var2 == null ? "%" : var2);
            var26.setString(5, var3 == null ? "%" : var3);
            var26.setString(6, var1 == null ? "%" : var1);
            var26.setString(7, var1 == null ? "%" : var1);
        } else {
            var26.setString(1, var1 == null ? "%" : var1);
            var26.setString(2, var2 == null ? "%" : var2);
            var26.setString(3, var3 == null ? "%" : var3);
        }

        OracleResultSet var27 = (OracleResultSet)var26.executeQuery();
        var27.closeStatementOnClose();
        return var27;
    }

    public ResultSet getTypeInfo() throws SQLException {
        Statement var1 = this.connection.createStatement();
        short var2 = this.connection.getVersionNumber();
        int var3 = this.connection.getVarTypeMaxLenCompat();
        short var4 = 2000;
        short var5 = 2000;
        short var6 = 4000;
        short var7 = 4000;
        short var8 = 2000;
        if (var3 == 2) {
            var4 = 2000;
            var5 = 2000;
            var6 = 32767;
            var7 = 32766;
            var8 = 32767;
        }

        String var17 = "union select\n 'CHAR' as type_name, 1 as data_type, " + var4 + " as precision,\n" + " '''' as literal_prefix, '''' as literal_suffix, NULL as create_params,\n" + " 1 as nullable, 1 as case_sensitive, 3 as searchable,\n" + " 0 as unsigned_attribute, 0 as fixed_prec_scale, 0 as auto_increment,\n" + " 'CHAR' as local_type_name, 0 as minimum_scale, 0 as maximum_scale,\n" + " NULL as sql_data_type, NULL as sql_datetime_sub, 10 as num_prec_radix\n" + "from dual\n";
        String var18 = "union select\n 'NCHAR' as type_name, -15 as data_type, " + var5 + " as precision,\n" + " '''' as literal_prefix, '''' as literal_suffix, NULL as create_params,\n" + " 1 as nullable, 1 as case_sensitive, 3 as searchable,\n" + " 0 as unsigned_attribute, 0 as fixed_prec_scale, 0 as auto_increment,\n" + " 'NCHAR' as local_type_name, 0 as minimum_scale, 0 as maximum_scale,\n" + " NULL as sql_data_type, NULL as sql_datetime_sub, 10 as num_prec_radix\n" + "from dual\n";
        String var19 = "union select\n 'VARCHAR2' as type_name, 12 as data_type, " + var6 + " as precision,\n" + " '''' as literal_prefix, '''' as literal_suffix, NULL as create_params,\n" + " 1 as nullable, 1 as case_sensitive, 3 as searchable,\n" + " 0 as unsigned_attribute, 0 as fixed_prec_scale, 0 as auto_increment,\n" + " 'VARCHAR2' as local_type_name, 0 as minimum_scale, 0 as maximum_scale,\n" + " NULL as sql_data_type, NULL as sql_datetime_sub, 10 as num_prec_radix\n" + "from dual\n";
        String var20 = "union select\n 'NVARCHAR2' as type_name, -9 as data_type, " + var7 + " as precision,\n" + " '''' as literal_prefix, '''' as literal_suffix, NULL as create_params,\n" + " 1 as nullable, 1 as case_sensitive, 3 as searchable,\n" + " 0 as unsigned_attribute, 0 as fixed_prec_scale, 0 as auto_increment,\n" + " 'nVARCHAR2' as local_type_name, 0 as minimum_scale, 0 as maximum_scale,\n" + " NULL as sql_data_type, NULL as sql_datetime_sub, 10 as num_prec_radix\n" + "from dual\n";
        String var22 = "union select\n 'DATE' as type_name, " + (((PhysicalConnection)this.connection).mapDateToTimestamp ? "93" : "91") + "as data_type, 7 as precision,\n" + " NULL as literal_prefix, NULL as literal_suffix, NULL as create_params,\n" + " 1 as nullable, 0 as case_sensitive, 3 as searchable,\n" + " 0 as unsigned_attribute, 0 as fixed_prec_scale, 0 as auto_increment,\n" + " 'DATE' as local_type_name, 0 as minimum_scale, 0 as maximum_scale,\n" + " NULL as sql_data_type, NULL as sql_datetime_sub, 10 as num_prec_radix\n" + "from dual\n";
        String var29 = "union select\n 'RAW' as type_name, -3 as data_type, " + var8 + " as precision,\n" + " '''' as literal_prefix, '''' as literal_suffix, NULL as create_params,\n" + " 1 as nullable, 0 as case_sensitive, 3 as searchable,\n" + " 0 as unsigned_attribute, 0 as fixed_prec_scale, 0 as auto_increment,\n" + " 'RAW' as local_type_name, 0 as minimum_scale, 0 as maximum_scale,\n" + " NULL as sql_data_type, NULL as sql_datetime_sub, 10 as num_prec_radix\n" + "from dual\n";
        String var31 = "-1";
        String var32 = "union select\n 'BLOB' as type_name, 2004 as data_type, " + var31 + " as precision,\n" + " null as literal_prefix, null as literal_suffix, NULL as create_params,\n" + " 1 as nullable, 0 as case_sensitive, 0 as searchable,\n" + " 0 as unsigned_attribute, 0 as fixed_prec_scale, 0 as auto_increment,\n" + " 'BLOB' as local_type_name, 0 as minimum_scale, 0 as maximum_scale,\n" + " NULL as sql_data_type, NULL as sql_datetime_sub, 10 as num_prec_radix\n" + "from dual\n";
        String var33 = "union select\n 'CLOB' as type_name, 2005 as data_type, " + var31 + " as precision,\n" + " '''' as literal_prefix, '''' as literal_suffix, NULL as create_params,\n" + " 1 as nullable, 1 as case_sensitive, 0 as searchable,\n" + " 0 as unsigned_attribute, 0 as fixed_prec_scale, 0 as auto_increment,\n" + " 'CLOB' as local_type_name, 0 as minimum_scale, 0 as maximum_scale,\n" + " NULL as sql_data_type, NULL as sql_datetime_sub, 10 as num_prec_radix\n" + "from dual\n";
        String var34 = "union select\n 'NCLOB' as type_name, 2011 as data_type, " + var31 + " as precision,\n" + " '''' as literal_prefix, '''' as literal_suffix, NULL as create_params,\n" + " 1 as nullable, 1 as case_sensitive, 0 as searchable,\n" + " 0 as unsigned_attribute, 0 as fixed_prec_scale, 0 as auto_increment,\n" + " 'NCLOB' as local_type_name, 0 as minimum_scale, 0 as maximum_scale,\n" + " NULL as sql_data_type, NULL as sql_datetime_sub, 10 as num_prec_radix\n" + "from dual\n";
        String var39 = "select\n 'NUMBER' as type_name, 2 as data_type, 38 as precision,\n NULL as literal_prefix, NULL as literal_suffix, NULL as create_params,\n 1 as nullable, 0 as case_sensitive, 3 as searchable,\n 0 as unsigned_attribute, 1 as fixed_prec_scale, 0 as auto_increment,\n 'NUMBER' as local_type_name, -84 as minimum_scale, 127 as maximum_scale,\n NULL as sql_data_type, NULL as sql_datetime_sub, 10 as num_prec_radix\nfrom dual\n" + var17 + var18 + var19 + var20 + var22 + "union select\n 'DATE' as type_name, 92 as data_type, 7 as precision,\n NULL as literal_prefix, NULL as literal_suffix, NULL as create_params,\n 1 as nullable, 0 as case_sensitive, 3 as searchable,\n 0 as unsigned_attribute, 0 as fixed_prec_scale, 0 as auto_increment,\n 'DATE' as local_type_name, 0 as minimum_scale, 0 as maximum_scale,\n NULL as sql_data_type, NULL as sql_datetime_sub, 10 as num_prec_radix\nfrom dual\n" + "union select\n 'TIMESTAMP' as type_name, 93 as data_type, 11 as precision,\n NULL as literal_prefix, NULL as literal_suffix, NULL as create_params,\n 1 as nullable, 0 as case_sensitive, 3 as searchable,\n 0 as unsigned_attribute, 0 as fixed_prec_scale, 0 as auto_increment,\n 'TIMESTAMP' as local_type_name, 0 as minimum_scale, 0 as maximum_scale,\n NULL as sql_data_type, NULL as sql_datetime_sub, 10 as num_prec_radix\nfrom dual\n" + "union select\n 'TIMESTAMP WITH TIME ZONE' as type_name, -101 as data_type, 13 as precision,\n NULL as literal_prefix, NULL as literal_suffix, NULL as create_params,\n 1 as nullable, 0 as case_sensitive, 3 as searchable,\n 0 as unsigned_attribute, 0 as fixed_prec_scale, 0 as auto_increment,\n 'TIMESTAMP WITH TIME ZONE' as local_type_name, 0 as minimum_scale, 0 as maximum_scale,\n NULL as sql_data_type, NULL as sql_datetime_sub, 10 as num_prec_radix\nfrom dual\n" + "union select\n 'TIMESTAMP WITH LOCAL TIME ZONE' as type_name, -102 as data_type, 11 as precision,\n NULL as literal_prefix, NULL as literal_suffix, NULL as create_params,\n 1 as nullable, 0 as case_sensitive, 3 as searchable,\n 0 as unsigned_attribute, 0 as fixed_prec_scale, 0 as auto_increment,\n 'TIMESTAMP WITH LOCAL TIME ZONE' as local_type_name, 0 as minimum_scale, 0 as maximum_scale,\n NULL as sql_data_type, NULL as sql_datetime_sub, 10 as num_prec_radix\nfrom dual\n" + "union select\n 'INTERVALYM' as type_name, -103 as data_type, 5 as precision,\n NULL as literal_prefix, NULL as literal_suffix, NULL as create_params,\n 1 as nullable, 0 as case_sensitive, 3 as searchable,\n 0 as unsigned_attribute, 0 as fixed_prec_scale, 0 as auto_increment,\n 'INTERVALYM' as local_type_name, 0 as minimum_scale, 0 as maximum_scale,\n NULL as sql_data_type, NULL as sql_datetime_sub, 10 as num_prec_radix\nfrom dual\n" + "union select\n 'INTERVALDS' as type_name, -104 as data_type, 4 as precision,\n NULL as literal_prefix, NULL as literal_suffix, NULL as create_params,\n 1 as nullable, 0 as case_sensitive, 3 as searchable,\n 0 as unsigned_attribute, 0 as fixed_prec_scale, 0 as auto_increment,\n 'INTERVALDS' as local_type_name, 0 as minimum_scale, 0 as maximum_scale,\n NULL as sql_data_type, NULL as sql_datetime_sub, 10 as num_prec_radix\nfrom dual\n" + var29 + "union select\n 'LONG' as type_name, -1 as data_type, 2147483647 as precision,\n '''' as literal_prefix, '''' as literal_suffix, NULL as create_params,\n 1 as nullable, 1 as case_sensitive, 0 as searchable,\n 0 as unsigned_attribute, 0 as fixed_prec_scale, 0 as auto_increment,\n 'LONG' as local_type_name, 0 as minimum_scale, 0 as maximum_scale,\n NULL as sql_data_type, NULL as sql_datetime_sub, 10 as num_prec_radix\nfrom dual\n" + "union select\n 'LONG RAW' as type_name, -4 as data_type, 2147483647 as precision,\n '''' as literal_prefix, '''' as literal_suffix, NULL as create_params,\n 1 as nullable, 0 as case_sensitive, 0 as searchable,\n 0 as unsigned_attribute, 0 as fixed_prec_scale, 0 as auto_increment,\n 'LONG RAW' as local_type_name, 0 as minimum_scale, 0 as maximum_scale,\n NULL as sql_data_type, NULL as sql_datetime_sub, 10 as num_prec_radix\nfrom dual\n" + "union select 'NUMBER' as type_name, -7 as data_type, 1 as precision,\nNULL as literal_prefix, NULL as literal_suffix, \n'(1)' as create_params, 1 as nullable, 0 as case_sensitive, 3 as searchable,\n0 as unsigned_attribute, 1 as fixed_prec_scale, 0 as auto_increment,\n'NUMBER' as local_type_name, -84 as minimum_scale, 127 as maximum_scale,\nNULL as sql_data_type, NULL as sql_datetime_sub, 10 as num_prec_radix\nfrom dual\n" + "union select 'NUMBER' as type_name, -6 as data_type, 3 as precision,\nNULL as literal_prefix, NULL as literal_suffix, \n'(3)' as create_params, 1 as nullable, 0 as case_sensitive, 3 as searchable,\n0 as unsigned_attribute, 1 as fixed_prec_scale, 0 as auto_increment,\n'NUMBER' as local_type_name, -84 as minimum_scale, 127 as maximum_scale,\nNULL as sql_data_type, NULL as sql_datetime_sub, 10 as num_prec_radix\nfrom dual\n" + "union select 'NUMBER' as type_name, 5 as data_type, 5 as precision,\nNULL as literal_prefix, NULL as literal_suffix, \n'(5)' as create_params, 1 as nullable, 0 as case_sensitive, 3 as searchable,\n0 as unsigned_attribute, 1 as fixed_prec_scale, 0 as auto_increment,\n'NUMBER' as local_type_name, -84 as minimum_scale, 127 as maximum_scale,\nNULL as sql_data_type, NULL as sql_datetime_sub, 10 as num_prec_radix\nfrom dual\n" + "union select 'NUMBER' as type_name, 4 as data_type, 10 as precision,\nNULL as literal_prefix, NULL as literal_suffix, \n'(10)' as create_params, 1 as nullable, 0 as case_sensitive, 3 as searchable,\n0 as unsigned_attribute, 1 as fixed_prec_scale, 0 as auto_increment,\n'NUMBER' as local_type_name, -84 as minimum_scale, 127 as maximum_scale,\nNULL as sql_data_type, NULL as sql_datetime_sub, 10 as num_prec_radix\nfrom dual\n" + "union select 'NUMBER' as type_name, -5 as data_type, 38 as precision,\nNULL as literal_prefix, NULL as literal_suffix, \nNULL as create_params, 1 as nullable, 0 as case_sensitive, 3 as searchable,\n0 as unsigned_attribute, 1 as fixed_prec_scale, 0 as auto_increment,\n'NUMBER' as local_type_name, -84 as minimum_scale, 127 as maximum_scale,\nNULL as sql_data_type, NULL as sql_datetime_sub, 10 as num_prec_radix\nfrom dual\n" + "union select 'FLOAT' as type_name, 6 as data_type, 63 as precision,\nNULL as literal_prefix, NULL as literal_suffix, \nNULL as create_params, 1 as nullable, 0 as case_sensitive, 3 as searchable,\n0 as unsigned_attribute, 1 as fixed_prec_scale, 0 as auto_increment,\n'FLOAT' as local_type_name, -84 as minimum_scale, 127 as maximum_scale,\nNULL as sql_data_type, NULL as sql_datetime_sub, 10 as num_prec_radix\nfrom dual\n" + "union select 'REAL' as type_name, 7 as data_type, 63 as precision,\nNULL as literal_prefix, NULL as literal_suffix, \nNULL as create_params, 1 as nullable, 0 as case_sensitive, 3 as searchable,\n0 as unsigned_attribute, 1 as fixed_prec_scale, 0 as auto_increment,\n'REAL' as local_type_name, -84 as minimum_scale, 127 as maximum_scale,\nNULL as sql_data_type, NULL as sql_datetime_sub, 10 as num_prec_radix\nfrom dual\n" + var32 + var33 + var34 + "union select\n 'REF' as type_name, 2006 as data_type, 0 as precision,\n '''' as literal_prefix, '''' as literal_suffix, NULL as create_params,\n 1 as nullable, 1 as case_sensitive, 0 as searchable,\n 0 as unsigned_attribute, 0 as fixed_prec_scale, 0 as auto_increment,\n 'REF' as local_type_name, 0 as minimum_scale, 0 as maximum_scale,\n NULL as sql_data_type, NULL as sql_datetime_sub, 10 as num_prec_radix\nfrom dual\n" + "union select\n 'ARRAY' as type_name, 2003 as data_type, 0 as precision,\n '''' as literal_prefix, '''' as literal_suffix, NULL as create_params,\n 1 as nullable, 1 as case_sensitive, 0 as searchable,\n 0 as unsigned_attribute, 0 as fixed_prec_scale, 0 as auto_increment,\n 'ARRAY' as local_type_name, 0 as minimum_scale, 0 as maximum_scale,\n NULL as sql_data_type, NULL as sql_datetime_sub, 10 as num_prec_radix\nfrom dual\n" + "union select\n 'STRUCT' as type_name, 2002 as data_type, 0 as precision,\n '''' as literal_prefix, '''' as literal_suffix, NULL as create_params,\n 1 as nullable, 1 as case_sensitive, 0 as searchable,\n 0 as unsigned_attribute, 0 as fixed_prec_scale, 0 as auto_increment,\n 'STRUCT' as local_type_name, 0 as minimum_scale, 0 as maximum_scale,\n NULL as sql_data_type, NULL as sql_datetime_sub, 10 as num_prec_radix\nfrom dual\n" + "order by data_type\n";
        OracleResultSet var40 = (OracleResultSet)var1.executeQuery(var39);
        var40.closeStatementOnClose();
        return var40;
    }

    String getColumnsNoWildcardsPlsql() throws SQLException {
        String var1 = "declare\n  in_owner varchar2(32) := null;\n  in_name varchar2(32) := null;\n  my_user_name varchar2(32) := null;\n  cnt number := 0;\n  out_owner varchar2(32) := null;\n  out_name  varchar2(32):= null;\n  loc varchar2(32) := null;\n  xxx SYS_REFCURSOR;\nbegin\n  in_owner := ?;\n  in_name := ?;\n  select user into my_user_name from dual;\n  if( my_user_name = in_owner ) then\n    select count(*) into cnt from user_tables where table_name = in_name;\n    if( cnt = 1 ) then\n      out_owner := in_owner;\n      out_name := in_name;\n      loc := 'USER_TABLES';\n    else\n      begin\n        select table_owner, table_name into out_owner, out_name from user_synonyms where synonym_name = in_name;\n      exception\n        when NO_DATA_FOUND then\n        out_owner := null;\n        out_name := null;\n      end;\n      if( not(out_name is null) ) then\n        loc := 'USER_SYNONYMS';\n      end if;\n    end if;\n  else\n    select count(*) into cnt from all_tables where owner = in_owner and table_name = in_name;\n    if( cnt = 1 ) then\n      out_owner := in_owner;\n      out_name := in_name;\n      loc := 'ALL_TABLES';\n    else\n      begin\n        select table_owner, table_name into out_owner, out_name from all_synonyms \n          where  owner = in_owner and synonym_name = in_name;\n      exception\n        when NO_DATA_FOUND then\n          out_owner := null;\n          out_name := null;\n      end;\n      if( not(out_owner is null) ) then\n        loc := 'ALL_SYNONYMS';\n      end if;\n    end if;\n  end if;\n";
        short var2 = this.connection.getVersionNumber();
        String var3 = "open xxx for SELECT NULL AS table_cat,\n";
        String var4 = "       in_owner AS table_schem,\n       in_name AS table_name,\n";
        String var5 = "         DECODE (t.data_type, 'CHAR', t.char_length,                   'VARCHAR', t.char_length,                   'VARCHAR2', t.char_length,                   'NVARCHAR2', t.char_length,                   'NCHAR', t.char_length,                   'NUMBER', 0,           t.data_length)";
        String var6 = "       t.column_name AS column_name,\n       DECODE (t.data_type, 'CHAR', 1, 'VARCHAR2', 12, 'NUMBER', 3,\n               'LONG', -1, 'DATE', " + (this.connection.getMapDateToTimestamp() ? "93" : "91") + ", 'RAW', -3, 'LONG RAW', -4,  \n" + "               'BLOB', 2004, 'CLOB', 2005, 'BFILE', -13, 'FLOAT', 6, \n" + "               'TIMESTAMP(6)', 93, 'TIMESTAMP(6) WITH TIME ZONE', -101, \n" + "               'TIMESTAMP(6) WITH LOCAL TIME ZONE', -102, \n" + "               'INTERVAL YEAR(2) TO MONTH', -103, \n" + "               'INTERVAL DAY(2) TO SECOND(6)', -104, \n" + "               'BINARY_FLOAT', 100, 'BINARY_DOUBLE', 101, \n" + "               'XMLTYPE', 2009, \n" + "               1111)\n" + "              AS data_type,\n" + "       t.data_type AS type_name,\n" + "       DECODE (t.data_precision, " + "               null, DECODE(t.data_type, " + "                       'NUMBER', DECODE(t.data_scale, " + "                                   null, " + (((PhysicalConnection)this.connection).j2ee13Compliant ? "38" : "0") + "                                   , 38), " + var5 + "                           )," + "         t.data_precision)\n" + "              AS column_size,\n" + "       0 AS buffer_length,\n" + "       DECODE (t.data_type, " + "               'NUMBER', DECODE(t.data_precision, " + "                                null, DECODE(t.data_scale, " + "                                             null, " + (((PhysicalConnection)this.connection).j2ee13Compliant ? "0" : "-127") + "                                             , t.data_scale), " + "                                 t.data_scale), " + "               t.data_scale) AS decimal_digits,\n" + "       10 AS num_prec_radix,\n" + "       DECODE (t.nullable, 'N', 0, 1) AS nullable,\n";
        String var7 = "       c.comments AS remarks,\n";
        String var8 = "       NULL AS remarks,\n";
        String var9 = "       t.data_default AS column_def,\n       0 AS sql_data_type,\n       0 AS sql_datetime_sub,\n       t.data_length AS char_octet_length,\n       t.column_id AS ordinal_position,\n       DECODE (t.nullable, 'N', 'NO', 'YES') AS is_nullable,\n";
        String var10 = "         null as SCOPE_CATALOG,\n       null as SCOPE_SCHEMA,\n       null as SCOPE_TABLE,\n       null as SOURCE_DATA_TYPE,\n       'NO' as IS_AUTOINCREMENT\n";
        String var11 = "FROM all_tab_columns t";
        String var12 = ", all_col_comments c";
        String var13 = "WHERE t.owner = out_owner \n  AND t.table_name = out_name\n AND t.column_name LIKE ? ESCAPE '/'\n";
        String var14 = "  AND t.owner = c.owner (+)\n  AND t.table_name = c.table_name (+)\n  AND t.column_name = c.column_name (+)\n";
        String var15 = "ORDER BY table_schem, table_name, ordinal_position\n";
        String var16 = var3 + var4;
        var16 = var16 + var6;
        if (this.connection.getRemarksReporting()) {
            var16 = var16 + var7;
        } else {
            var16 = var16 + var8;
        }

        var16 = var16 + var9 + var10 + var11;
        if (this.connection.getRemarksReporting()) {
            var16 = var16 + var12;
        }

        var16 = var16 + "\n" + var13;
        if (this.connection.getRemarksReporting()) {
            var16 = var16 + var14;
        }

        var16 = var16 + "\n" + var15;
        String var17 = "; \n ? := xxx;\n end;";
        String var18 = var1 + var16 + var17;
        return var18;
    }
}
