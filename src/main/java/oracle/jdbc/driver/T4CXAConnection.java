//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package oracle.jdbc.driver;

import java.sql.Connection;
import javax.transaction.xa.XAException;
import javax.transaction.xa.XAResource;
import oracle.jdbc.babelfish.BabelfishConnection;
import oracle.jdbc.proxy._Proxy_;
import oracle.jdbc.xa.OracleXAResource;
import oracle.jdbc.xa.client.OracleXAConnection;

public class T4CXAConnection extends OracleXAConnection {
    T4CTTIOtxen otxen;
    T4CTTIOtxse otxse;
    T4CConnection physicalConnection;
    private static final String _Copyright_2007_Oracle_All_Rights_Reserved_ = null;
    public static final String BUILD_DATE = "Thu_Apr_04_15:09:24_PDT_2013";
    public static final boolean TRACE = false;

    public T4CXAConnection(Connection var1) throws XAException {
        super(var1);
        if (var1 instanceof BabelfishConnection) {
            this.physicalConnection = (T4CConnection)((_Proxy_)var1)._getDelegate_();
        } else {
            this.physicalConnection = (T4CConnection)var1;
        }

        this.xaResource = null;
    }

    public synchronized XAResource getXAResource() {
        try {
            if (this.xaResource == null) {
                this.xaResource = new T4CXAResource(this.physicalConnection, this, this.isXAResourceTransLoose);
                if (this.logicalHandle != null) {
                    ((OracleXAResource)this.xaResource).setLogicalConnection(this.logicalHandle);
                }
            }
        } catch (Exception var2) {
            this.xaResource = null;
        }

        return this.xaResource;
    }
}
