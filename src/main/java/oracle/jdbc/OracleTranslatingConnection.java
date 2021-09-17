//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package oracle.jdbc;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Map;

public interface OracleTranslatingConnection {
    Statement createStatement(boolean var1) throws SQLException;

    Statement createStatement(int var1, int var2, boolean var3) throws SQLException;

    Statement createStatement(int var1, int var2, int var3, boolean var4) throws SQLException;

    PreparedStatement prepareStatement(String var1, boolean var2) throws SQLException;

    PreparedStatement prepareStatement(String var1, int var2, boolean var3) throws SQLException;

    PreparedStatement prepareStatement(String var1, int[] var2, boolean var3) throws SQLException;

    PreparedStatement prepareStatement(String var1, String[] var2, boolean var3) throws SQLException;

    PreparedStatement prepareStatement(String var1, int var2, int var3, boolean var4) throws SQLException;

    PreparedStatement prepareStatement(String var1, int var2, int var3, int var4, boolean var5) throws SQLException;

    CallableStatement prepareCall(String var1, boolean var2) throws SQLException;

    CallableStatement prepareCall(String var1, int var2, int var3, boolean var4) throws SQLException;

    CallableStatement prepareCall(String var1, int var2, int var3, int var4, boolean var5) throws SQLException;

    Map<OracleTranslatingConnection.SqlTranslationVersion, String> getSqlTranslationVersions(String var1, boolean var2) throws SQLException;

    public static enum SqlTranslationVersion {
        ORIGINAL_SQL,
        JDBC_MARKER_CONVERTED,
        TRANSLATED;

        private SqlTranslationVersion() {
        }
    }
}
