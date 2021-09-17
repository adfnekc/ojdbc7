//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package oracle.jdbc.xa;

import java.sql.Connection;
import java.sql.SQLException;
import javax.sql.XAConnection;
import javax.transaction.xa.XAException;
import javax.transaction.xa.XAResource;
import oracle.jdbc.pool.OraclePooledConnection;

public abstract class OracleXAConnection extends OraclePooledConnection implements XAConnection {
    protected XAResource xaResource;
    private static final String _Copyright_2007_Oracle_All_Rights_Reserved_ = null;
    public static final String BUILD_DATE = "Thu_Apr_04_15:09:24_PDT_2013";
    public static final boolean TRACE = false;

    public OracleXAConnection() throws XAException {
        this((Connection)null);
    }

    public OracleXAConnection(Connection var1) throws XAException {
        super(var1);
        this.xaResource = null;
    }

    public abstract XAResource getXAResource();

    public synchronized Connection getConnection() throws SQLException {
        Connection var1 = super.getConnection();
        if (this.xaResource != null) {
            ((OracleXAResource)this.xaResource).setLogicalConnection(var1);
        }

        return var1;
    }

    boolean getAutoCommit() throws SQLException {
        return this.autoCommit;
    }

    void setAutoCommit(boolean var1) throws SQLException {
        this.autoCommit = var1;
    }
}
