//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package oracle.jdbc.xa;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Hashtable;
import javax.transaction.xa.XAException;
import javax.transaction.xa.XAResource;
import javax.transaction.xa.Xid;
import oracle.jdbc.internal.OracleConnection;

public abstract class OracleXAResource implements XAResource {
    public static final int XA_OK = 0;
    public static final short DEFAULT_XA_TIMEOUT = 60;
    protected boolean savedConnectionAutoCommit = false;
    protected boolean savedXAConnectionAutoCommit = false;
    public static final int TMNOFLAGS = 0;
    public static final int TMNOMIGRATE = 2;
    public static final int TMENDRSCAN = 8388608;
    public static final int TMFAIL = 536870912;
    public static final int TMMIGRATE = 1048576;
    public static final int TMJOIN = 2097152;
    public static final int TMONEPHASE = 1073741824;
    public static final int TMRESUME = 134217728;
    public static final int TMSTARTRSCAN = 16777216;
    public static final int TMSUCCESS = 67108864;
    public static final int TMSUSPEND = 33554432;
    public static final int ORATMREADONLY = 256;
    public static final int ORATMREADWRITE = 512;
    public static final int ORATMSERIALIZABLE = 1024;
    public static final int ORAISOLATIONMASK = 65280;
    public static final int ORATRANSLOOSE = 65536;
    protected Connection connection = null;
    protected OracleXAConnection xaconnection = null;
    protected int timeout = 60;
    protected String dblink = null;
    private Connection logicalConnection = null;
    private String synchronizeBeforeRecoverNewCall = "BEGIN sys.dbms_xa.dist_txn_sync \n; END;";
    private String synchronizeBeforeRecoverOldCall = "BEGIN sys.dbms_system.dist_txn_sync(0) \n; END;";
    private String recoverySqlRows = "SELECT formatid, globalid, branchid FROM SYS.DBA_PENDING_TRANSACTIONS";
    protected boolean canBeMigratablySuspended = false;
    private boolean isTMRScanStarted = false;
    private static final Xid[] NO_XID = new Xid[0];
    Xid lastActiveXid = null;
    protected Xid activeXid = null;
    protected Hashtable<Xid, OracleXAResource.XidListEntry> xidHash = new Hashtable(50);
    private static final String _Copyright_2007_Oracle_All_Rights_Reserved_ = null;
    public static final String BUILD_DATE = "Thu_Apr_04_15:09:24_PDT_2013";
    public static final boolean TRACE = false;

    public OracleXAResource() {
    }

    public OracleXAResource(Connection var1, OracleXAConnection var2) throws XAException {
        this.connection = var1;
        this.xaconnection = var2;
        if (this.connection == null) {
            throw new XAException(-7);
        }
    }

    public synchronized void setConnection(Connection var1) throws XAException {
        this.connection = var1;
        if (this.connection == null) {
            throw new XAException(-7);
        }
    }

    final synchronized OracleXAResource.XidListEntry getMatchingXidListEntry(Xid var1) {
        OracleXAResource.XidListEntry var2 = (OracleXAResource.XidListEntry)this.xidHash.get(var1);
        return var2;
    }

    protected final synchronized boolean removeXidFromList(Xid var1) {
        if (this.isSameXid(this.activeXid, var1)) {
            this.activeXid = null;
        }

        return this.xidHash.remove(var1) != null;
    }

    final boolean isSameXid(Xid var1, Xid var2) {
        return var1 == var2;
    }

    protected final boolean isOnStack(Xid var1) throws XAException {
        return this.xidHash.containsKey(var1);
    }

    protected final synchronized boolean isXidListEmpty() {
        return this.xidHash.isEmpty();
    }

    protected synchronized void createOrUpdateXid(Xid var1, boolean var2, boolean[] var3) {
        OracleXAResource.XidListEntry var4 = this.getMatchingXidListEntry(var1);
        if (var4 != null) {
            var3[0] = true;
            var4.isSuspended = var2;
        } else {
            var4 = new OracleXAResource.XidListEntry(var1, var2);
            this.xidHash.put(var1, var4);
        }

        if (var2) {
            this.lastActiveXid = this.activeXid;
            this.activeXid = null;
        } else {
            this.enterGlobalTxnMode();
            if (this.lastActiveXid != null && this.isSameXid(var1, this.lastActiveXid)) {
                this.lastActiveXid = null;
            }

            this.activeXid = var4.xid;
        }

    }

    protected synchronized boolean updateXidList(Xid var1, boolean[] var2) {
        boolean var3 = false;
        OracleXAResource.XidListEntry var4 = this.getMatchingXidListEntry(var1);
        if (var4 != null) {
            var3 = true;
            var2[0] = true;
            var2[1] = var4.isSuspended;
            if (var4.isSuspended) {
                this.enterGlobalTxnMode();
            } else {
                this.exitGlobalTxnMode();
            }
        }

        return var3;
    }

    protected boolean isXidSuspended(Xid var1) throws XAException {
        boolean var2 = false;
        OracleXAResource.XidListEntry var3 = this.getMatchingXidListEntry(var1);
        if (var3 != null) {
            var2 = var3.isSuspended;
        }

        return var2;
    }

    protected Xid suspendStacked(Xid var1) throws XAException {
        Xid var2 = null;
        if (this.activeXid != null && !this.isSameXid(this.activeXid, var1)) {
            var2 = this.activeXid;
            if (!this.isXidSuspended(this.activeXid)) {
                this.end(this.activeXid, 33554432);
                this.lastActiveXid = this.activeXid;
                this.activeXid = null;
            }
        }

        return var2;
    }

    protected void resumeStacked(Xid var1) throws XAException {
        if (var1 != null) {
            this.start(var1, 134217728);
            this.activeXid = var1;
        }

    }

    public abstract void start(Xid var1, int var2) throws XAException;

    public abstract void end(Xid var1, int var2) throws XAException;

    public abstract void commit(Xid var1, boolean var2) throws XAException;

    public abstract int prepare(Xid var1) throws XAException;

    public abstract void forget(Xid var1) throws XAException;

    public abstract void rollback(Xid var1) throws XAException;

    public Xid[] recover(int var1) throws XAException {
        synchronized(this.connection) {
            if ((var1 & 25165824) != var1) {
                throw new XAException(-5);
            } else {
                if (var1 == 16777216) {
                    this.isTMRScanStarted = true;
                } else {
                    if (this.isTMRScanStarted && var1 == 8388608) {
                        this.isTMRScanStarted = false;
                        return NO_XID;
                    }

                    if (this.isTMRScanStarted && var1 == 0) {
                        return NO_XID;
                    }
                }

                Statement var3 = null;
                ResultSet var4 = null;
                ArrayList var5 = new ArrayList(50);

                try {
                    var3 = this.connection.createStatement();

                    try {
                        var3.execute(this.synchronizeBeforeRecoverNewCall);
                    } catch (Exception var17) {
                        var3.execute(this.synchronizeBeforeRecoverOldCall);
                    }

                    var4 = var3.executeQuery(this.recoverySqlRows);

                    while(var4.next()) {
                        var5.add(new OracleXid(var4.getInt(1), var4.getBytes(2), var4.getBytes(3)));
                    }
                } catch (SQLException var18) {
                    throw new XAException(-3);
                } finally {
                    try {
                        if (var3 != null) {
                            var3.close();
                        }

                        if (var4 != null) {
                            var4.close();
                        }
                    } catch (Exception var16) {
                    }

                }

                int var6 = var5.size();
                Xid[] var7 = new Xid[var6];
                System.arraycopy(var5.toArray(), 0, var7, 0, var6);
                return var7;
            }
        }
    }

    protected void restoreAutoCommitModeForGlobalTransaction() throws XAException {
        if (this.savedConnectionAutoCommit && ((OracleConnection)this.connection).getTxnMode() != 1) {
            try {
                this.connection.setAutoCommit(this.savedConnectionAutoCommit);
                this.xaconnection.setAutoCommit(this.savedXAConnectionAutoCommit);
            } catch (SQLException var2) {
            }
        }

    }

    protected void saveAndAlterAutoCommitModeForGlobalTransaction() throws XAException {
        if (((OracleConnection)this.connection).getTxnMode() != 1) {
            try {
                this.savedConnectionAutoCommit = this.connection.getAutoCommit();
                this.connection.setAutoCommit(false);
                this.savedXAConnectionAutoCommit = this.xaconnection.getAutoCommit();
                this.xaconnection.setAutoCommit(false);
            } catch (SQLException var2) {
            }
        }

    }

    public void resume(Xid var1) throws XAException {
        this.start(var1, 134217728);
    }

    public void join(Xid var1) throws XAException {
        this.start(var1, 2097152);
    }

    public void suspend(Xid var1) throws XAException {
        this.end(var1, 33554432);
    }

    public void join(Xid var1, int var2) throws XAException {
        this.timeout = var2;
        this.start(var1, 2097152);
    }

    public void resume(Xid var1, int var2) throws XAException {
        this.timeout = var2;
        this.start(var1, 134217728);
    }

    public Connection getConnection() {
        return this.connection;
    }

    public int getTransactionTimeout() throws XAException {
        return this.timeout;
    }

    public boolean isSameRM(XAResource var1) throws XAException {
        Connection var2 = null;
        if (var1 instanceof OracleXAResource) {
            var2 = ((OracleXAResource)var1).getConnection();

            try {
                if (this.connection != null && !((OracleConnection)this.connection).isClosed()) {
                    String var3 = ((OracleConnection)this.connection).getURL();
                    String var4 = ((OracleConnection)this.connection).getProtocolType();
                    if (var2 == null) {
                        return false;
                    } else {
                        boolean var5 = var2.equals(this.connection) || ((OracleConnection)var2).getURL().equals(var3) || ((OracleConnection)var2).getProtocolType().equals(var4) && var4.equals("kprb");
                        return var5;
                    }
                } else {
                    return false;
                }
            } catch (SQLException var6) {
                throw new XAException(-3);
            }
        } else {
            return false;
        }
    }

    public boolean setTransactionTimeout(int var1) throws XAException {
        if (var1 < 0) {
            throw new XAException(-5);
        } else {
            this.timeout = var1;
            return true;
        }
    }

    public String getDBLink() {
        return this.dblink;
    }

    public void setDBLink(String var1) {
        this.dblink = var1;
    }

    public void setLogicalConnection(Connection var1) {
        this.logicalConnection = var1;
    }

    protected void allowGlobalTxnModeOnly(int var1) throws XAException {
        if (((OracleConnection)this.connection).getTxnMode() != 1) {
            throw new XAException(var1);
        }
    }

    protected void exitGlobalTxnMode() {
        ((OracleConnection)this.connection).setTxnMode(0);
    }

    protected void enterGlobalTxnMode() {
        ((OracleConnection)this.connection).setTxnMode(1);
    }

    protected void checkError(int var1) throws XAException {
        if ((var1 & '\uffff') != 0) {
            XAException var2 = OracleXAException.newXAException(this.getConnectionDuringExceptionHandling(), var1);
            var2.fillInStackTrace();
            throw var2;
        }
    }

    protected void checkError(int var1, int var2) throws XAException {
        if ((var1 & '\uffff') != 0) {
            XAException var3 = OracleXAException.newXAException(this.getConnectionDuringExceptionHandling(), var1, var2);
            var3.fillInStackTrace();
            throw var3;
        }
    }

    protected void checkError(SQLException var1, int var2) throws XAException {
        XAException var3 = OracleXAException.newXAException(this.getConnectionDuringExceptionHandling(), var1, var2);
        var3.fillInStackTrace();
        throw var3;
    }

    protected OracleConnection getConnectionDuringExceptionHandling() {
        return (OracleConnection)this.connection;
    }

    class XidListEntry {
        Xid xid;
        boolean isSuspended;

        XidListEntry(Xid var2, boolean var3) {
            this.xid = var2;
            this.isSuspended = var3;
        }
    }
}
