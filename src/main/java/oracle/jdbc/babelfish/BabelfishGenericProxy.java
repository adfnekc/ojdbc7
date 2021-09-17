//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package oracle.jdbc.babelfish;

import java.lang.reflect.Method;
import java.sql.Array;
import java.sql.Blob;
import java.sql.Clob;
import java.sql.DatabaseMetaData;
import java.sql.NClob;
import java.sql.ParameterMetaData;
import java.sql.Ref;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.RowId;
import java.sql.SQLData;
import java.sql.SQLException;
import java.sql.SQLInput;
import java.sql.SQLOutput;
import java.sql.SQLXML;
import java.sql.Savepoint;
import java.sql.Struct;
import java.sql.Wrapper;
import oracle.jdbc.proxy.annotation.GetCreator;
import oracle.jdbc.proxy.annotation.GetDelegate;
import oracle.jdbc.proxy.annotation.OnError;
import oracle.jdbc.proxy.annotation.Post;
import oracle.jdbc.proxy.annotation.ProxyFor;

@ProxyFor({Array.class, Blob.class, Clob.class, DatabaseMetaData.class, NClob.class, ParameterMetaData.class, Ref.class, ResultSet.class, ResultSetMetaData.class, RowId.class, Savepoint.class, SQLData.class, SQLInput.class, SQLOutput.class, SQLXML.class, Struct.class, Wrapper.class})
public abstract class BabelfishGenericProxy {
    Translator translator;
    private static final String _Copyright_2007_Oracle_All_Rights_Reserved_ = null;
    public static final String BUILD_DATE = "Thu_Apr_04_15:09:24_PDT_2013";
    public static final boolean TRACE = false;

    public BabelfishGenericProxy() {
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

    public void setTranslator(Translator var1) {
        this.translator = var1;
    }
}
