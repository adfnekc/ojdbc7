//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package oracle.jdbc.babelfish;

import java.lang.reflect.Method;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.EnumMap;
import java.util.Map;
import oracle.jdbc.OracleConnection;
import oracle.jdbc.OracleTranslatingConnection;
import oracle.jdbc.OracleTranslatingConnection.SqlTranslationVersion;
import oracle.jdbc.proxy.annotation.GetCreator;
import oracle.jdbc.proxy.annotation.GetDelegate;
import oracle.jdbc.proxy.annotation.OnError;
import oracle.jdbc.proxy.annotation.Post;
import oracle.jdbc.proxy.annotation.ProxyFor;
import oracle.jdbc.proxy.annotation.ProxyLocale;

@ProxyFor({Connection.class, OracleConnection.class, oracle.jdbc.internal.OracleConnection.class})
@ProxyLocale
public abstract class BabelfishConnection extends BabelfishGenericProxy implements OracleTranslatingConnection {
    private static final String _Copyright_2007_Oracle_All_Rights_Reserved_ = null;
    public static final String BUILD_DATE = "Thu_Apr_04_15:09:24_PDT_2013";
    public static final boolean TRACE = false;

    public BabelfishConnection() {
    }

    @GetCreator
    protected abstract Object getCreator();

    @GetDelegate
    protected abstract Object getDelegate();

    @OnError(SQLException.class)
    protected Object translateError(Method var1, SQLException var2) throws SQLException {
        throw this.translator.translateError(var2);
    }

    @Post
    protected Object post_Methods(Method var1, Object var2) {
        if (var2 instanceof BabelfishGenericProxy) {
            ((BabelfishGenericProxy)var2).setTranslator(this.translator);
        }

        return var2;
    }

    public PreparedStatement prepareStatement(String var1) throws SQLException {
        String var2 = this.translator.translateQuery(var1);
        return ((Connection)this.getDelegate()).prepareStatement(var2);
    }

    public PreparedStatement prepareStatement(String var1, int var2) throws SQLException {
        String var3 = this.translator.translateQuery(var1);
        return ((Connection)this.getDelegate()).prepareStatement(var3, var2);
    }

    public PreparedStatement prepareStatement(String var1, int[] var2) throws SQLException {
        String var3 = this.translator.translateQuery(var1);
        return ((Connection)this.getDelegate()).prepareStatement(var3, var2);
    }

    public PreparedStatement prepareStatement(String var1, String[] var2) throws SQLException {
        String var3 = this.translator.translateQuery(var1);
        return ((Connection)this.getDelegate()).prepareStatement(var3, var2);
    }

    public PreparedStatement prepareStatement(String var1, int var2, int var3) throws SQLException {
        String var4 = this.translator.translateQuery(var1);
        return ((Connection)this.getDelegate()).prepareStatement(var4, var2, var3);
    }

    public PreparedStatement prepareStatement(String var1, int var2, int var3, int var4) throws SQLException {
        String var5 = this.translator.translateQuery(var1);
        return ((Connection)this.getDelegate()).prepareStatement(var5, var2, var3, var4);
    }

    public CallableStatement prepareCall(String var1) throws SQLException {
        String var2 = this.translator.translateQuery(var1);
        return ((Connection)this.getDelegate()).prepareCall(var2);
    }

    public CallableStatement prepareCall(String var1, int var2, int var3) throws SQLException {
        String var4 = this.translator.translateQuery(var1);
        return ((Connection)this.getDelegate()).prepareCall(var4, var2, var3);
    }

    public CallableStatement prepareCall(String var1, int var2, int var3, int var4) throws SQLException {
        String var5 = this.translator.translateQuery(var1);
        return ((Connection)this.getDelegate()).prepareCall(var5, var2, var3, var4);
    }

    public String nativeSQL(String var1) throws SQLException {
        String var2 = this.translator.translateQuery(var1);
        return ((Connection)this.getDelegate()).nativeSQL(var2);
    }

    public void close() throws SQLException {
        this.translator.deactivateServerTranslation();
        ((Connection)this.getDelegate()).close();
    }

    public abstract Statement createStatement() throws SQLException;

    public Statement createStatement(boolean var1) throws SQLException {
        Statement var2;
        if (!var1) {
            var2 = ((Connection)this.getDelegate()).createStatement();
        } else {
            var2 = this.createStatement();
        }

        return var2;
    }

    public abstract Statement createStatement(int var1, int var2) throws SQLException;

    public Statement createStatement(int var1, int var2, boolean var3) throws SQLException {
        Statement var4;
        if (!var3) {
            var4 = ((Connection)this.getDelegate()).createStatement(var1, var2);
        } else {
            var4 = this.createStatement(var1, var2);
        }

        return var4;
    }

    public abstract Statement createStatement(int var1, int var2, int var3) throws SQLException;

    public Statement createStatement(int var1, int var2, int var3, boolean var4) throws SQLException {
        Statement var5;
        if (!var4) {
            var5 = ((Connection)this.getDelegate()).createStatement(var1, var2, var3);
        } else {
            var5 = this.createStatement(var1, var2, var3);
        }

        return var5;
    }

    public PreparedStatement prepareStatement(String var1, boolean var2) throws SQLException {
        PreparedStatement var3;
        if (!var2) {
            var3 = ((Connection)this.getDelegate()).prepareStatement(var1);
        } else {
            var3 = this.prepareStatement(var1);
        }

        return var3;
    }

    public PreparedStatement prepareStatement(String var1, int var2, boolean var3) throws SQLException {
        PreparedStatement var4;
        if (!var3) {
            var4 = ((Connection)this.getDelegate()).prepareStatement(var1, var2);
        } else {
            var4 = this.prepareStatement(var1, var2);
        }

        return var4;
    }

    public PreparedStatement prepareStatement(String var1, int[] var2, boolean var3) throws SQLException {
        PreparedStatement var4;
        if (!var3) {
            var4 = ((Connection)this.getDelegate()).prepareStatement(var1, var2);
        } else {
            var4 = this.prepareStatement(var1, var2);
        }

        return var4;
    }

    public PreparedStatement prepareStatement(String var1, String[] var2, boolean var3) throws SQLException {
        PreparedStatement var4;
        if (!var3) {
            var4 = ((Connection)this.getDelegate()).prepareStatement(var1, var2);
        } else {
            var4 = this.prepareStatement(var1, var2);
        }

        return var4;
    }

    public PreparedStatement prepareStatement(String var1, int var2, int var3, boolean var4) throws SQLException {
        PreparedStatement var5;
        if (!var4) {
            var5 = ((Connection)this.getDelegate()).prepareStatement(var1, var2, var3);
        } else {
            var5 = this.prepareStatement(var1, var2, var3);
        }

        return var5;
    }

    public PreparedStatement prepareStatement(String var1, int var2, int var3, int var4, boolean var5) throws SQLException {
        PreparedStatement var6;
        if (!var5) {
            var6 = ((Connection)this.getDelegate()).prepareStatement(var1, var2, var3, var4);
        } else {
            var6 = this.prepareStatement(var1, var2, var3, var4);
        }

        return var6;
    }

    public CallableStatement prepareCall(String var1, boolean var2) throws SQLException {
        CallableStatement var3;
        if (!var2) {
            var3 = ((Connection)this.getDelegate()).prepareCall(var1);
        } else {
            var3 = this.prepareCall(var1);
        }

        return var3;
    }

    public CallableStatement prepareCall(String var1, int var2, int var3, boolean var4) throws SQLException {
        CallableStatement var5;
        if (!var4) {
            var5 = ((Connection)this.getDelegate()).prepareCall(var1, var2, var3);
        } else {
            var5 = this.prepareCall(var1, var2, var3);
        }

        return var5;
    }

    public CallableStatement prepareCall(String var1, int var2, int var3, int var4, boolean var5) throws SQLException {
        CallableStatement var6;
        if (!var5) {
            var6 = ((Connection)this.getDelegate()).prepareCall(var1, var2, var3, var4);
        } else {
            var6 = this.prepareCall(var1, var2, var3, var4);
        }

        return var6;
    }

    public Map<SqlTranslationVersion, String> getSqlTranslationVersions(String var1, boolean var2) throws SQLException {
        EnumMap var4 = new EnumMap(SqlTranslationVersion.class);
        var4.put(SqlTranslationVersion.ORIGINAL_SQL, var1);
        String var3 = this.translator.convertParameterMarkersToOracleStyle(var1);
        var4.put(SqlTranslationVersion.JDBC_MARKER_CONVERTED, var3);

        try {
            var3 = this.translator.translateQuery(var1);
            var4.put(SqlTranslationVersion.TRANSLATED, var3);
        } catch (SQLException var6) {
            if (!var2) {
                throw var6;
            }

            var4.put(SqlTranslationVersion.TRANSLATED, (Object)null);
        }

        return var4;
    }
}
