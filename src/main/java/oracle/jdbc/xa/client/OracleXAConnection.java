//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package oracle.jdbc.xa.client;

import java.sql.Connection;
import javax.transaction.xa.XAException;
import javax.transaction.xa.XAResource;

public class OracleXAConnection extends oracle.jdbc.xa.OracleXAConnection {
    protected boolean isXAResourceTransLoose = false;
    private static final String _Copyright_2007_Oracle_All_Rights_Reserved_ = null;
    public static final String BUILD_DATE = "Thu_Apr_04_15:09:24_PDT_2013";
    public static final boolean TRACE = false;

    public OracleXAConnection() throws XAException {
    }

    public OracleXAConnection(Connection var1) throws XAException {
        super(var1);
    }

    public synchronized XAResource getXAResource() {
        try {
            if (this.xaResource == null) {
                this.xaResource = new OracleXAResource(this.physicalConn, this);
                ((OracleXAResource)this.xaResource).isTransLoose = this.isXAResourceTransLoose;
                if (this.logicalHandle != null) {
                    ((oracle.jdbc.xa.OracleXAResource)this.xaResource).setLogicalConnection(this.logicalHandle);
                }
            }
        } catch (XAException var2) {
            this.xaResource = null;
        }

        return this.xaResource;
    }
}
