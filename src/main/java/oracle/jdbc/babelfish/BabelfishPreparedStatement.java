//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package oracle.jdbc.babelfish;

import java.io.InputStream;
import java.io.Reader;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.net.URL;
import java.sql.Array;
import java.sql.Blob;
import java.sql.Clob;
import java.sql.Date;
import java.sql.NClob;
import java.sql.PreparedStatement;
import java.sql.Ref;
import java.sql.RowId;
import java.sql.SQLException;
import java.sql.SQLXML;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Calendar;
import oracle.jdbc.OraclePreparedStatement;
import oracle.jdbc.proxy.annotation.GetCreator;
import oracle.jdbc.proxy.annotation.GetDelegate;
import oracle.jdbc.proxy.annotation.OnError;
import oracle.jdbc.proxy.annotation.Post;
import oracle.jdbc.proxy.annotation.ProxyFor;

@ProxyFor({OraclePreparedStatement.class, PreparedStatement.class})
public abstract class BabelfishPreparedStatement extends BabelfishStatement {
    static String NAMED_PARAMETER_PREFIX = "b";
    private static final String _Copyright_2007_Oracle_All_Rights_Reserved_ = null;
    public static final String BUILD_DATE = "Thu_Apr_04_15:09:24_PDT_2013";
    public static final boolean TRACE = false;

    public BabelfishPreparedStatement() {
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

    public void setArray(int var1, Array var2) throws SQLException {
        ((OraclePreparedStatement)this.getDelegate()).setArrayAtName(NAMED_PARAMETER_PREFIX + var1, var2);
    }

    public void setAsciiStream(int var1, InputStream var2) throws SQLException {
        ((OraclePreparedStatement)this.getDelegate()).setAsciiStreamAtName(NAMED_PARAMETER_PREFIX + var1, var2);
    }

    public void setAsciiStream(int var1, InputStream var2, int var3) throws SQLException {
        ((OraclePreparedStatement)this.getDelegate()).setAsciiStreamAtName(NAMED_PARAMETER_PREFIX + var1, var2, var3);
    }

    public void setAsciiStream(int var1, InputStream var2, long var3) throws SQLException {
        ((OraclePreparedStatement)this.getDelegate()).setAsciiStreamAtName(NAMED_PARAMETER_PREFIX + var1, var2, var3);
    }

    public void setBigDecimal(int var1, BigDecimal var2) throws SQLException {
        ((OraclePreparedStatement)this.getDelegate()).setBigDecimalAtName(NAMED_PARAMETER_PREFIX + var1, var2);
    }

    public void setBinaryStream(int var1, InputStream var2) throws SQLException {
        ((OraclePreparedStatement)this.getDelegate()).setBinaryStreamAtName(NAMED_PARAMETER_PREFIX + var1, var2);
    }

    public void setBinaryStream(int var1, InputStream var2, int var3) throws SQLException {
        ((OraclePreparedStatement)this.getDelegate()).setBinaryStreamAtName(NAMED_PARAMETER_PREFIX + var1, var2, var3);
    }

    public void setBinaryStream(int var1, InputStream var2, long var3) throws SQLException {
        ((OraclePreparedStatement)this.getDelegate()).setBinaryStreamAtName(NAMED_PARAMETER_PREFIX + var1, var2, var3);
    }

    public void setBlob(int var1, Blob var2) throws SQLException {
        ((OraclePreparedStatement)this.getDelegate()).setBlobAtName(NAMED_PARAMETER_PREFIX + var1, var2);
    }

    public void setBlob(int var1, InputStream var2) throws SQLException {
        ((OraclePreparedStatement)this.getDelegate()).setBlobAtName(NAMED_PARAMETER_PREFIX + var1, var2);
    }

    public void setBlob(int var1, InputStream var2, long var3) throws SQLException {
        ((OraclePreparedStatement)this.getDelegate()).setBlobAtName(NAMED_PARAMETER_PREFIX + var1, var2, var3);
    }

    public void setBoolean(int var1, boolean var2) throws SQLException {
        ((OraclePreparedStatement)this.getDelegate()).setBooleanAtName(NAMED_PARAMETER_PREFIX + var1, var2);
    }

    public void setByte(int var1, byte var2) throws SQLException {
        ((OraclePreparedStatement)this.getDelegate()).setByteAtName(NAMED_PARAMETER_PREFIX + var1, var2);
    }

    public void setBytes(int var1, byte[] var2) throws SQLException {
        ((OraclePreparedStatement)this.getDelegate()).setBytesAtName(NAMED_PARAMETER_PREFIX + var1, var2);
    }

    public void setCharacterStream(int var1, Reader var2) throws SQLException {
        ((OraclePreparedStatement)this.getDelegate()).setCharacterStreamAtName(NAMED_PARAMETER_PREFIX + var1, var2);
    }

    public void setCharacterStream(int var1, Reader var2, int var3) throws SQLException {
        ((OraclePreparedStatement)this.getDelegate()).setCharacterStreamAtName(NAMED_PARAMETER_PREFIX + var1, var2, (long)var3);
    }

    public void setCharacterStream(int var1, Reader var2, long var3) throws SQLException {
        ((OraclePreparedStatement)this.getDelegate()).setCharacterStreamAtName(NAMED_PARAMETER_PREFIX + var1, var2, var3);
    }

    public void setClob(int var1, Clob var2) throws SQLException {
        ((OraclePreparedStatement)this.getDelegate()).setClobAtName(NAMED_PARAMETER_PREFIX + var1, var2);
    }

    public void setClob(int var1, Reader var2) throws SQLException {
        ((OraclePreparedStatement)this.getDelegate()).setClobAtName(NAMED_PARAMETER_PREFIX + var1, var2);
    }

    public void setClob(int var1, Reader var2, long var3) throws SQLException {
        ((OraclePreparedStatement)this.getDelegate()).setClobAtName(NAMED_PARAMETER_PREFIX + var1, var2, var3);
    }

    public void setDate(int var1, Date var2) throws SQLException {
        ((OraclePreparedStatement)this.getDelegate()).setDateAtName(NAMED_PARAMETER_PREFIX + var1, var2);
    }

    public void setDate(int var1, Date var2, Calendar var3) throws SQLException {
        ((OraclePreparedStatement)this.getDelegate()).setDateAtName(NAMED_PARAMETER_PREFIX + var1, var2, var3);
    }

    public void setDouble(int var1, double var2) throws SQLException {
        ((OraclePreparedStatement)this.getDelegate()).setDoubleAtName(NAMED_PARAMETER_PREFIX + var1, var2);
    }

    public void setFloat(int var1, float var2) throws SQLException {
        ((OraclePreparedStatement)this.getDelegate()).setFloatAtName(NAMED_PARAMETER_PREFIX + var1, var2);
    }

    public void setInt(int var1, int var2) throws SQLException {
        ((OraclePreparedStatement)this.getDelegate()).setIntAtName(NAMED_PARAMETER_PREFIX + var1, var2);
    }

    public void setLong(int var1, long var2) throws SQLException {
        ((OraclePreparedStatement)this.getDelegate()).setLongAtName(NAMED_PARAMETER_PREFIX + var1, var2);
    }

    public void setNCharacterStream(int var1, Reader var2) throws SQLException {
        ((OraclePreparedStatement)this.getDelegate()).setNCharacterStreamAtName(NAMED_PARAMETER_PREFIX + var1, var2);
    }

    public void setNCharacterStream(int var1, Reader var2, long var3) throws SQLException {
        ((OraclePreparedStatement)this.getDelegate()).setNCharacterStreamAtName(NAMED_PARAMETER_PREFIX + var1, var2, var3);
    }

    public void setNClob(int var1, NClob var2) throws SQLException {
        ((OraclePreparedStatement)this.getDelegate()).setNClobAtName(NAMED_PARAMETER_PREFIX + var1, var2);
    }

    public void setNClob(int var1, Reader var2) throws SQLException {
        ((OraclePreparedStatement)this.getDelegate()).setNClobAtName(NAMED_PARAMETER_PREFIX + var1, var2);
    }

    public void setNClob(int var1, Reader var2, long var3) throws SQLException {
        ((OraclePreparedStatement)this.getDelegate()).setNClobAtName(NAMED_PARAMETER_PREFIX + var1, var2, var3);
    }

    public void setNString(int var1, String var2) throws SQLException {
        ((OraclePreparedStatement)this.getDelegate()).setNStringAtName(NAMED_PARAMETER_PREFIX + var1, var2);
    }

    public void setNull(int var1, int var2) throws SQLException {
        ((OraclePreparedStatement)this.getDelegate()).setNullAtName(NAMED_PARAMETER_PREFIX + var1, var2);
    }

    public void setNull(int var1, int var2, String var3) throws SQLException {
        ((OraclePreparedStatement)this.getDelegate()).setNullAtName(NAMED_PARAMETER_PREFIX + var1, var2, var3);
    }

    public void setObject(int var1, Object var2) throws SQLException {
        ((OraclePreparedStatement)this.getDelegate()).setObjectAtName(NAMED_PARAMETER_PREFIX + var1, var2);
    }

    public void setObject(int var1, Object var2, int var3) throws SQLException {
        ((OraclePreparedStatement)this.getDelegate()).setObjectAtName(NAMED_PARAMETER_PREFIX + var1, var2, var3);
    }

    public void setObject(int var1, Object var2, int var3, int var4) throws SQLException {
        ((OraclePreparedStatement)this.getDelegate()).setObjectAtName(NAMED_PARAMETER_PREFIX + var1, var2, var3, var4);
    }

    public void setRef(int var1, Ref var2) throws SQLException {
        ((OraclePreparedStatement)this.getDelegate()).setRefAtName(NAMED_PARAMETER_PREFIX + var1, var2);
    }

    public void setRowId(int var1, RowId var2) throws SQLException {
        ((OraclePreparedStatement)this.getDelegate()).setRowIdAtName(NAMED_PARAMETER_PREFIX + var1, var2);
    }

    public void setShort(int var1, short var2) throws SQLException {
        ((OraclePreparedStatement)this.getDelegate()).setShortAtName(NAMED_PARAMETER_PREFIX + var1, var2);
    }

    public void setSQLXML(int var1, SQLXML var2) throws SQLException {
        ((OraclePreparedStatement)this.getDelegate()).setSQLXMLAtName(NAMED_PARAMETER_PREFIX + var1, var2);
    }

    public void setString(int var1, String var2) throws SQLException {
        ((OraclePreparedStatement)this.getDelegate()).setStringAtName(NAMED_PARAMETER_PREFIX + var1, var2);
    }

    public void setTime(int var1, Time var2) throws SQLException {
        ((OraclePreparedStatement)this.getDelegate()).setTimeAtName(NAMED_PARAMETER_PREFIX + var1, var2);
    }

    public void setTime(int var1, Time var2, Calendar var3) throws SQLException {
        ((OraclePreparedStatement)this.getDelegate()).setTimeAtName(NAMED_PARAMETER_PREFIX + var1, var2, var3);
    }

    public void setTimestamp(int var1, Timestamp var2) throws SQLException {
        ((OraclePreparedStatement)this.getDelegate()).setTimestampAtName(NAMED_PARAMETER_PREFIX + var1, var2);
    }

    public void setTimestamp(int var1, Timestamp var2, Calendar var3) throws SQLException {
        ((OraclePreparedStatement)this.getDelegate()).setTimestampAtName(NAMED_PARAMETER_PREFIX + var1, var2, var3);
    }

    public void setUnicodeStream(int var1, InputStream var2, int var3) throws SQLException {
        ((OraclePreparedStatement)this.getDelegate()).setUnicodeStreamAtName(NAMED_PARAMETER_PREFIX + var1, var2, var3);
    }

    public void setURL(int var1, URL var2) throws SQLException {
        ((OraclePreparedStatement)this.getDelegate()).setURLAtName(NAMED_PARAMETER_PREFIX + var1, var2);
    }
}
