//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package oracle.jdbc.xa.client;

import java.io.IOException;
import java.sql.Connection;
import javax.transaction.xa.XAException;
import javax.transaction.xa.Xid;
import oracle.jdbc.oracore.Util;

public class OracleXAHeteroResource extends OracleXAResource {
    private int rmid = -1;
    private static final String _Copyright_2007_Oracle_All_Rights_Reserved_ = null;
    public static final String BUILD_DATE = "Thu_Apr_04_15:09:24_PDT_2013";
    public static final boolean TRACE = false;

    public OracleXAHeteroResource(Connection var1, OracleXAConnection var2) throws XAException {
        this.connection = var1;
        this.xaconnection = var2;
        if (this.connection == null) {
            throw new XAException(-7);
        }
    }

    public void start(Xid var1, int var2) throws XAException {
        if (var1 == null) {
            throw new XAException(-5);
        } else {
            int var3 = var2 & '\uff00';
            var2 &= -65281;
            if ((var2 & 136314882) != var2) {
                throw new XAException(-5);
            } else if ((var3 & '\uff00') != 0 && var3 != 256 && var3 != 512 && var3 != 1024) {
                throw new XAException(-5);
            } else if ((var3 & '\uff00') != 0 && (var2 & 136314880) != 0) {
                throw new XAException(-5);
            } else {
                try {
                    this.saveAndAlterAutoCommitModeForGlobalTransaction();
                    var2 |= var3;
                    int var4 = var1.getFormatId();
                    byte[] var5 = var1.getGlobalTransactionId();
                    byte[] var6 = var1.getBranchQualifier();
                    int var7 = this.t2cDoXaStart(var4, var5, var6, this.rmid, var2, 0);
                    this.checkStatus(var7);
                    this.enterGlobalTxnMode();
                } catch (XAException var8) {
                    this.restoreAutoCommitModeForGlobalTransaction();
                    throw var8;
                }
            }
        }
    }

    public void end(Xid var1, int var2) throws XAException {
        try {
            if (var1 == null) {
                throw new XAException(-5);
            }

            int var3 = 638582786;
            if ((var2 & var3) != var2) {
                throw new XAException(-5);
            }

            int var4 = var1.getFormatId();
            byte[] var5 = var1.getGlobalTransactionId();
            byte[] var6 = var1.getBranchQualifier();
            this.exitGlobalTxnMode();
            int var7 = this.t2cDoXaEnd(var4, var5, var6, this.rmid, var2, 0);
            this.checkStatus(var7);
        } finally {
            this.restoreAutoCommitModeForGlobalTransaction();
        }

    }

    public void commit(Xid var1, boolean var2) throws XAException {
        if (var1 == null) {
            throw new XAException(-5);
        } else {
            int var3 = var2 ? 1073741824 : 0;
            int var4 = var1.getFormatId();
            byte[] var5 = var1.getGlobalTransactionId();
            byte[] var6 = var1.getBranchQualifier();
            int var7 = this.t2cDoXaCommit(var4, var5, var6, this.rmid, var3, 0);
            this.checkStatus(var7);
        }
    }

    public int prepare(Xid var1) throws XAException {
        if (var1 == null) {
            throw new XAException(-5);
        } else {
            int var2 = var1.getFormatId();
            byte[] var3 = var1.getGlobalTransactionId();
            byte[] var4 = var1.getBranchQualifier();
            int var5 = this.t2cDoXaPrepare(var2, var3, var4, this.rmid, 0, 0);
            if (var5 != 0 && var5 != 3) {
                this.checkStatus(var5);
            }

            return var5;
        }
    }

    public void forget(Xid var1) throws XAException {
        if (var1 == null) {
            throw new XAException(-5);
        } else {
            int var2 = var1.getFormatId();
            byte[] var3 = var1.getGlobalTransactionId();
            byte[] var4 = var1.getBranchQualifier();
            int var5 = this.t2cDoXaForget(var2, var3, var4, this.rmid, 0, 0);
            this.checkStatus(var5);
        }
    }

    public void rollback(Xid var1) throws XAException {
        if (var1 == null) {
            throw new XAException(-5);
        } else {
            int var2 = var1.getFormatId();
            byte[] var3 = var1.getGlobalTransactionId();
            byte[] var4 = var1.getBranchQualifier();
            int var5 = this.t2cDoXaRollback(var2, var3, var4, this.rmid, 0, 0);
            this.checkStatus(var5);
        }
    }

    private native int t2cDoXaStart(int var1, byte[] var2, byte[] var3, int var4, int var5, int var6);

    private native int t2cDoXaEnd(int var1, byte[] var2, byte[] var3, int var4, int var5, int var6);

    private native int t2cDoXaCommit(int var1, byte[] var2, byte[] var3, int var4, int var5, int var6);

    private native int t2cDoXaPrepare(int var1, byte[] var2, byte[] var3, int var4, int var5, int var6);

    private native int t2cDoXaForget(int var1, byte[] var2, byte[] var3, int var4, int var5, int var6);

    private native int t2cDoXaRollback(int var1, byte[] var2, byte[] var3, int var4, int var5, int var6);

    synchronized void setRmid(int var1) {
        this.rmid = var1;
    }

    synchronized int getRmid() {
        return this.rmid;
    }

    private static byte[] getSerializedBytes(Xid var0) {
        try {
            return Util.serializeObject(var0);
        } catch (IOException var2) {
            var2.printStackTrace();
            return null;
        }
    }

    private void checkStatus(int var1) throws XAException {
        if (var1 != 0) {
            throw new XAException(var1);
        }
    }
}
