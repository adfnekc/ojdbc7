//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package oracle.jdbc.babelfish;

import java.lang.reflect.Method;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import oracle.jdbc.OracleStatement;
import oracle.jdbc.proxy.annotation.GetCreator;
import oracle.jdbc.proxy.annotation.GetDelegate;
import oracle.jdbc.proxy.annotation.OnError;
import oracle.jdbc.proxy.annotation.Post;
import oracle.jdbc.proxy.annotation.ProxyFor;

@ProxyFor({OracleStatement.class, Statement.class})
public abstract class BabelfishStatement extends BabelfishGenericProxy {
    private static final String _Copyright_2007_Oracle_All_Rights_Reserved_ = null;
    public static final String BUILD_DATE = "Thu_Apr_04_15:09:24_PDT_2013";
    public static final boolean TRACE = false;

    public BabelfishStatement() {
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

    public void addBatch(String var1) throws SQLException {
        String var2 = this.translator.translateQuery(var1);
        ((Statement)this.getDelegate()).addBatch(var2);
    }

    public boolean execute(String var1) throws SQLException {
        String var2 = this.translator.translateQuery(var1);
        return ((Statement)this.getDelegate()).execute(var2);
    }

    public boolean execute(String var1, int var2) throws SQLException {
        String var3 = this.translator.translateQuery(var1);
        return ((Statement)this.getDelegate()).execute(var3, var2);
    }

    public boolean execute(String var1, int[] var2) throws SQLException {
        String var3 = this.translator.translateQuery(var1);
        return ((Statement)this.getDelegate()).execute(var3, var2);
    }

    public boolean execute(String var1, String[] var2) throws SQLException {
        String var3 = this.translator.translateQuery(var1);
        return ((Statement)this.getDelegate()).execute(var3, var2);
    }

    public ResultSet executeQuery(String var1) throws SQLException {
        String var2 = this.translator.translateQuery(var1);
        return ((Statement)this.getDelegate()).executeQuery(var2);
    }

    public int executeUpdate(String var1) throws SQLException {
        String var2 = this.translator.translateQuery(var1);
        return ((Statement)this.getDelegate()).executeUpdate(var2);
    }

    public int executeUpdate(String var1, int var2) throws SQLException {
        String var3 = this.translator.translateQuery(var1);
        return ((Statement)this.getDelegate()).executeUpdate(var3, var2);
    }

    public int executeUpdate(String var1, int[] var2) throws SQLException {
        String var3 = this.translator.translateQuery(var1);
        return ((Statement)this.getDelegate()).executeUpdate(var3, var2);
    }

    public int executeUpdate(String var1, String[] var2) throws SQLException {
        String var3 = this.translator.translateQuery(var1);
        return ((Statement)this.getDelegate()).executeUpdate(var3, var2);
    }
}
