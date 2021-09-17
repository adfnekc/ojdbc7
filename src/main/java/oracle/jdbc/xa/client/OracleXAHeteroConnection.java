//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package oracle.jdbc.xa.client;

import java.sql.Connection;
import javax.transaction.xa.XAException;
import javax.transaction.xa.XAResource;
import oracle.jdbc.xa.OracleXAResource;

public class OracleXAHeteroConnection extends OracleXAConnection {
    private int rmid = -1;
    private String xaCloseString = null;
    private static final String _Copyright_2007_Oracle_All_Rights_Reserved_ = null;
    public static final String BUILD_DATE = "Thu_Apr_04_15:09:24_PDT_2013";
    public static final boolean TRACE = false;

    public OracleXAHeteroConnection() throws XAException {
    }

    public OracleXAHeteroConnection(Connection var1) throws XAException {
        super(var1);
    }

    public synchronized XAResource getXAResource() {
        try {
            if (this.xaResource == null) {
                this.xaResource = new OracleXAHeteroResource(this.physicalConn, this);
                ((OracleXAHeteroResource)this.xaResource).setRmid(this.rmid);
                if (this.logicalHandle != null) {
                    ((OracleXAResource)this.xaResource).setLogicalConnection(this.logicalHandle);
                }
            }
        } catch (XAException var2) {
            this.xaResource = null;
        }

        return this.xaResource;
    }

    synchronized void setRmid(int var1) {
        this.rmid = var1;
    }

    synchronized int getRmid() {
        return this.rmid;
    }

    synchronized void setXaCloseString(String var1) {
        this.xaCloseString = var1;
    }

    synchronized String getXaCloseString() {
        return this.xaCloseString;
    }
}
