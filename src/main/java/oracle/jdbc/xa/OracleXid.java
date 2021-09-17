//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package oracle.jdbc.xa;

import java.io.Serializable;
import javax.transaction.xa.XAException;
import javax.transaction.xa.Xid;
import oracle.jdbc.internal.OracleConnection;

public class OracleXid implements Xid, Serializable {
    private int formatId;
    private byte[] gtrid;
    private byte[] bqual;
    private byte[] txctx;
    public static final int MAXGTRIDSIZE = 64;
    public static final int MAXBQUALSIZE = 64;
    private int state;
    private static final String _Copyright_2007_Oracle_All_Rights_Reserved_ = null;
    public static final String BUILD_DATE = "Thu_Apr_04_15:09:24_PDT_2013";
    public static final boolean TRACE = false;

    public OracleXid(int var1, byte[] var2, byte[] var3) throws XAException {
        this(var1, var2, var3, (byte[])null);
    }

    public OracleXid(int var1, byte[] var2, byte[] var3, byte[] var4) throws XAException {
        this.gtrid = null;
        this.bqual = null;
        this.txctx = null;
        this.formatId = var1;
        if (var2 != null && var2.length > 64) {
            throw new XAException(-4);
        } else {
            this.gtrid = var2;
            if (var3 != null && var3.length > 64) {
                throw new XAException(-4);
            } else {
                this.bqual = var3;
                this.txctx = var4;
                this.state = 0;
            }
        }
    }

    public void setState(int var1) {
        this.state = var1;
    }

    public int getState() {
        return this.state;
    }

    public int getFormatId() {
        return this.formatId;
    }

    public byte[] getGlobalTransactionId() {
        return this.gtrid;
    }

    public byte[] getBranchQualifier() {
        return this.bqual;
    }

    public byte[] getTxContext() {
        return this.txctx;
    }

    public void setTxContext(byte[] var1) {
        this.txctx = var1;
    }

    public static final boolean isLocalTransaction(Xid var0) {
        byte[] var1 = var0.getGlobalTransactionId();
        if (var1 == null) {
            return true;
        } else {
            for(int var2 = 0; var2 < var1.length; ++var2) {
                if (var1[var2] != 0) {
                    return false;
                }
            }

            return true;
        }
    }

    protected OracleConnection getConnectionDuringExceptionHandling() {
        return null;
    }
}
