//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package oracle.jdbc.babelfish;

import java.io.File;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Map;
import oracle.jdbc.driver.DatabaseError;
import oracle.jdbc.internal.OracleConnection;

public class Translator {
    private final File localErrorTranslationFile;
    private final String translationProfile;
    private Connection conn;
    private CallableStatement queryTranslationStatement;
    private CallableStatement errorTranslationStatement;
    private final Map<String, String> queryCache;
    private final Map<Integer, TranslatedErrorInfo> errorCache;
    private final Map<Integer, TranslatedErrorInfo> localErrorCache;
    private static final String _Copyright_2007_Oracle_All_Rights_Reserved_ = null;
    public static final String BUILD_DATE = "Thu_Apr_04_15:09:24_PDT_2013";
    public static final boolean TRACE = false;

    Translator(String var1, File var2, TranslationCache var3) throws SQLException {
        this.translationProfile = var1;
        this.localErrorTranslationFile = var2;
        this.queryCache = var3.getQueryCache();
        this.errorCache = var3.getErrorCache();
        this.localErrorCache = var3.getLocalErrorCache();
    }

    public SQLException translateError(SQLException var1) throws SQLException {
        if (this.conn == null) {
            return this.translateErrorLocal(var1);
        } else {
            TranslatedErrorInfo var2 = (TranslatedErrorInfo)this.errorCache.get(var1.getErrorCode());
            SQLException var6;
            if (var2 != null) {
                var6 = new SQLException("[Translated Error Codes] " + var1.getMessage(), var2.getSqlState(), var2.getErrorCode(), var1);
                var6.setStackTrace(var1.getStackTrace());
                return var6;
            } else {
                try {
                    this.errorTranslationStatement.clearParameters();
                    this.errorTranslationStatement.setInt(1, var1.getErrorCode());
                    this.errorTranslationStatement.registerOutParameter(2, 4);
                    this.errorTranslationStatement.registerOutParameter(3, 12);
                    this.errorTranslationStatement.execute();
                    int var3 = this.errorTranslationStatement.getInt(2);
                    if (this.errorTranslationStatement.wasNull()) {
                        var3 = var1.getErrorCode();
                    }

                    String var7 = this.errorTranslationStatement.getString(3);
                    if (var7 == null) {
                        var7 = var1.getSQLState();
                    }

                    var2 = new TranslatedErrorInfo(var3, var7);
                } catch (SQLException var5) {
                    SQLException var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 280, (Object)null, var5);
                    var4.fillInStackTrace();
                    throw var4;
                }

                this.errorCache.put(var1.getErrorCode(), var2);
                var6 = new SQLException("[Translated Error Codes] " + var1.getMessage(), var2.getSqlState(), var2.getErrorCode(), var1);
                var6.setStackTrace(var1.getStackTrace());
                return var6;
            }
        }
    }

    SQLException translateErrorLocal(SQLException var1) throws SQLException {
        if (this.localErrorCache == null) {
            return var1;
        } else {
            TranslatedErrorInfo var2 = (TranslatedErrorInfo)this.localErrorCache.get(var1.getErrorCode());
            if (var2 != null) {
                String var5 = "[Translated Error Codes] " + var1.getMessage();
                SQLException var4 = new SQLException(var5, var2.getSqlState(), var2.getErrorCode(), var1);
                var4.setStackTrace(var1.getStackTrace());
                return var4;
            } else {
                SQLException var3 = new SQLException("[Error Translation Not Available] " + var1.getMessage(), var1.getSQLState(), var1.getErrorCode(), var1);
                var3.setStackTrace(var1.getStackTrace());
                return var3;
            }
        }
    }

    String translateQuery(String var1) throws SQLException {
        if (this.conn != null) {
            String var7 = (String)this.queryCache.get(var1);
            if (var7 != null) {
                return var7;
            } else {
                String var3 = this.convertParameterMarkersToOracleStyle(var1);

                try {
                    this.queryTranslationStatement.clearParameters();
                    this.queryTranslationStatement.setString(1, var3);
                    this.queryTranslationStatement.registerOutParameter(2, 12);
                    this.queryTranslationStatement.execute();
                    var7 = this.queryTranslationStatement.getString(2);
                } catch (SQLException var6) {
                    SQLException var5 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 280, (Object)null, var6);
                    var5.fillInStackTrace();
                    throw var5;
                }

                if (var7 == null) {
                    var7 = var3;
                }

                this.queryCache.put(var1, var7);
                return var7;
            }
        } else {
            SQLException var2 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 279);
            var2.fillInStackTrace();
            throw var2;
        }
    }

    public void activateServerTranslation(Connection var1) throws SQLException {
        CallableStatement var2 = var1.prepareCall("begin execute immediate 'alter session set sql_translation_profile = ' || dbms_assert.qualified_sql_name(?); end;");
        var2.setString(1, this.translationProfile);
        var2.execute();
        this.queryTranslationStatement = var1.prepareCall("begin dbms_sql_translator.translate_sql(?, ? ); end;");
        this.errorTranslationStatement = var1.prepareCall("begin dbms_sql_translator.translate_error(?, ?, ? ); end;");
        this.conn = var1;
    }

    void deactivateServerTranslation() throws SQLException {
        this.queryTranslationStatement.close();
        this.errorTranslationStatement.close();
        this.conn = null;
    }

    String convertParameterMarkersToOracleStyle(String var1) {
        StringBuilder var2 = new StringBuilder();
        boolean var3 = false;
        int var4 = 1;

        for(int var5 = 0; var5 < var1.length(); ++var5) {
            char var6 = var1.charAt(var5);
            switch(var6) {
                case '\'':
                    var3 = !var3;
                default:
                    var2.append(var6);
                    break;
                case '?':
                    if (!var3) {
                        var2.append(" :").append(BabelfishPreparedStatement.NAMED_PARAMETER_PREFIX).append(var4++).append(" ");
                    }
                    break;
                case '\\':
                    var2.append(var6);
                    if (var5 < var1.length() - 1) {
                        ++var5;
                        var2.append(var1.charAt(var5));
                    }
            }
        }

        return var2.toString();
    }

    protected OracleConnection getConnectionDuringExceptionHandling() {
        return null;
    }
}
