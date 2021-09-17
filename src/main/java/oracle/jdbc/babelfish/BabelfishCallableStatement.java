//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package oracle.jdbc.babelfish;

import java.lang.reflect.Method;
import java.sql.CallableStatement;
import java.sql.SQLException;
import oracle.jdbc.OracleCallableStatement;
import oracle.jdbc.proxy.annotation.GetCreator;
import oracle.jdbc.proxy.annotation.GetDelegate;
import oracle.jdbc.proxy.annotation.OnError;
import oracle.jdbc.proxy.annotation.Post;
import oracle.jdbc.proxy.annotation.ProxyFor;

@ProxyFor({OracleCallableStatement.class, CallableStatement.class})
public abstract class BabelfishCallableStatement extends BabelfishPreparedStatement {
    private static final String _Copyright_2007_Oracle_All_Rights_Reserved_ = null;
    public static final String BUILD_DATE = "Thu_Apr_04_15:09:24_PDT_2013";
    public static final boolean TRACE = false;

    public BabelfishCallableStatement() {
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

    public void registerOutParameter(int var1, int var2) throws SQLException {
        ((OracleCallableStatement)this.getDelegate()).registerOutParameterAtName(NAMED_PARAMETER_PREFIX + var1, var2);
    }

    public void registerOutParameter(int var1, int var2, int var3) throws SQLException {
        ((OracleCallableStatement)this.getDelegate()).registerOutParameterAtName(NAMED_PARAMETER_PREFIX + var1, var2, var3);
    }

    public void registerOutParameter(int var1, int var2, String var3) throws SQLException {
        ((OracleCallableStatement)this.getDelegate()).registerOutParameterAtName(NAMED_PARAMETER_PREFIX + var1, var2, var3);
    }
}
