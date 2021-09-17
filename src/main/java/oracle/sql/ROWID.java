//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package oracle.sql;

import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import oracle.jdbc.driver.DatabaseError;
import oracle.jdbc.internal.OracleConnection;
import oracle.jdbc.internal.OracleRowId;

public class ROWID extends Datum implements OracleRowId {
    static final long serialVersionUID = 5629736369998199486L;
    Object acProxy;
    private static final String _Copyright_2007_Oracle_All_Rights_Reserved_ = null;
    public static final String BUILD_DATE = "Thu_Apr_04_15:09:24_PDT_2013";
    public static final boolean TRACE = false;

    public ROWID() {
    }

    public ROWID(byte[] var1) {
        super(var1);
    }

    public ROWID(String var1) throws SQLException {
        this(toAsciiBytes(var1));
    }

    private static byte[] toAsciiBytes(String var0) throws SQLException {
        try {
            return var0.getBytes("US-ASCII");
        } catch (UnsupportedEncodingException var3) {
            SQLException var2 = DatabaseError.createSqlException((OracleConnection)null, 183);
            var2.fillInStackTrace();
            throw var2;
        }
    }

    public Object toJdbc() throws SQLException {
        return this;
    }

    public boolean isConvertibleTo(Class var1) {
        String var2 = var1.getName();
        return var2.compareTo("java.lang.String") == 0;
    }

    public String stringValue() {
        Object var1 = null;
        byte[] var2 = this.getBytes();
        return new String(var2, 0, 0, var2.length);
    }

    public String toString() {
        return this.stringValue();
    }

    public Object makeJdbcArray(int var1) {
        return new byte[var1][];
    }

    public void setACProxy(Object var1) {
        this.acProxy = var1;
    }

    public Object getACProxy() {
        return this.acProxy;
    }
}
