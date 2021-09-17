//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package oracle.jdbc.xa.client;

import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import javax.transaction.xa.XAException;
import javax.transaction.xa.Xid;
import oracle.jdbc.internal.OracleConnection;
import oracle.jdbc.oracore.Util;
import oracle.jdbc.xa.OracleXAConnection;
import oracle.jdbc.xa.OracleXAException;

public class OracleXAResource extends oracle.jdbc.xa.OracleXAResource {
    private short m_version = 0;
    private boolean needStackingForCommitRollbackPrepare = false;
    private static String xa_start_816 = "begin ? := JAVA_XA.xa_start(?,?,?,?); end;";
    private static String xa_start_post_816 = "begin ? := JAVA_XA.xa_start_new(?,?,?,?,?); end;";
    private static String xa_end_816 = "begin ? := JAVA_XA.xa_end(?,?); end;";
    private static String xa_end_post_816 = "begin ? := JAVA_XA.xa_end_new(?,?,?,?); end;";
    private static String xa_commit_816 = "begin ? := JAVA_XA.xa_commit (?,?,?); end;";
    private static String xa_commit_post_816 = "begin ? := JAVA_XA.xa_commit_new (?,?,?,?); end;";
    private static String xa_prepare_816 = "begin ? := JAVA_XA.xa_prepare (?,?); end;";
    private static String xa_prepare_post_816 = "begin ? := JAVA_XA.xa_prepare_new (?,?,?); end;";
    private static String xa_rollback_816 = "begin ? := JAVA_XA.xa_rollback (?,?); end;";
    private static String xa_rollback_post_816 = "begin ? := JAVA_XA.xa_rollback_new (?,?,?); end;";
    private static String xa_forget_816 = "begin ? := JAVA_XA.xa_forget (?,?); end;";
    private static String xa_forget_post_816 = "begin ? := JAVA_XA.xa_forget_new (?,?,?); end;";
    boolean isTransLoose = false;
    private static final String _Copyright_2007_Oracle_All_Rights_Reserved_ = null;
    public static final String BUILD_DATE = "Thu_Apr_04_15:09:24_PDT_2013";
    public static final boolean TRACE = false;

    public OracleXAResource() {
    }

    public OracleXAResource(Connection var1, OracleXAConnection var2) throws XAException {
        super(var1, var2);

        try {
            this.m_version = ((OracleConnection)var1).getVersionNumber();
            this.needStackingForCommitRollbackPrepare = this.m_version < 9000;
        } catch (SQLException var4) {
        }

        if (this.m_version < 8170) {
            throw new XAException(-6);
        }
    }

    public void start(Xid var1, int var2) throws XAException {
        synchronized(this.connection) {
            int var4 = -1;

            try {
                if (var1 == null) {
                    throw new XAException(-5);
                }

                int var5 = var2 & '\uff00';
                var2 &= -65281;
                int var6 = var2 & 65536 | (this.isTransLoose ? 65536 : 0);
                var2 &= -65537;
                if ((var2 & 136314882) != var2 || var6 != 0 && (var6 & 65536) != 65536) {
                    throw new XAException(-5);
                }

                if ((var5 & '\uff00') != 0 && var5 != 256 && var5 != 512 && var5 != 1024) {
                    throw new XAException(-5);
                }

                if ((var2 & 136314880) != 0 && ((var5 & '\uff00') != 0 || (var6 & 65536) != 0)) {
                    throw new XAException(-5);
                }

                var2 |= var5 | var6;
                this.saveAndAlterAutoCommitModeForGlobalTransaction();

                try {
                    var4 = this.doStart(var1, var2);
                } catch (SQLException var9) {
                    this.checkError(var9, -3);
                }

                this.checkError(var4);
                boolean[] var7 = new boolean[]{false};
                super.createOrUpdateXid(var1, false, var7);
            } catch (XAException var10) {
                this.restoreAutoCommitModeForGlobalTransaction();
                throw var10;
            }

        }
    }

    protected int doStart(Xid var1, int var2) throws XAException, SQLException {
        boolean var3 = true;
        CallableStatement var4 = null;

        int var15;
        try {
            var4 = this.connection.prepareCall(xa_start_post_816);
            var4.registerOutParameter(1, 2);
            var4.setInt(2, var1.getFormatId());
            var4.setBytes(3, var1.getGlobalTransactionId());
            var4.setBytes(4, var1.getBranchQualifier());
            var4.setInt(5, this.timeout);
            var4.setInt(6, var2);
            var4.execute();
            var15 = var4.getInt(1);
        } catch (SQLException var13) {
            var15 = var13.getErrorCode();
            if (var15 == 0) {
                throw new XAException(-6);
            }

            throw var13;
        } finally {
            try {
                if (var4 != null) {
                    var4.close();
                }
            } catch (SQLException var12) {
            }

            var4 = null;
        }

        return var15;
    }

    public void end(Xid var1, int var2) throws XAException {
        synchronized(this.connection) {
            int var4 = -1;
            boolean var5 = false;
            boolean var6 = false;

            try {
                if (var1 == null) {
                    throw new XAException(-5);
                }

                int var7 = 638582786;
                if ((var2 & var7) != var2) {
                    throw new XAException(-5);
                }

                Xid var8 = null;
                var5 = (var2 & 67108864) != 0;
                var6 = (var2 & 536870912) != 0;
                if (var5 || var6) {
                    var8 = super.suspendStacked(var1);
                }

                try {
                    boolean var9 = false;
                    if (!var5 && !var6) {
                        if (var2 == 33554432) {
                            boolean[] var10 = new boolean[]{false};
                            super.createOrUpdateXid(var1, true, var10);
                            var9 = var10[0];
                        }
                    } else {
                        var9 = this.isXidSuspended(var1);
                        if (var9) {
                            super.resumeStacked(var1);
                        }

                        this.removeXidFromList(var1);
                    }

                    var4 = this.doEnd(var1, var2, var9);
                } catch (SQLException var16) {
                    this.checkError(var16, -3);
                }

                if (var8 != null) {
                    super.resumeStacked(var8);
                } else if (this.isXidListEmpty()) {
                    this.exitGlobalTxnMode();
                    this.activeXid = null;
                }

                this.checkError(var4);
                if (var5 && var2 != 67108864 || var6 && var2 != 536870912) {
                    throw new XAException(-5);
                }
            } finally {
                this.restoreAutoCommitModeForGlobalTransaction();
            }

        }
    }

    protected int doEnd(Xid var1, int var2, boolean var3) throws XAException, SQLException {
        CallableStatement var4 = null;
        boolean var5 = true;

        int var16;
        try {
            var4 = this.connection.prepareCall(xa_end_post_816);
            var4.registerOutParameter(1, 2);
            var4.setInt(2, var1.getFormatId());
            var4.setBytes(3, var1.getGlobalTransactionId());
            var4.setBytes(4, var1.getBranchQualifier());
            var4.setInt(5, var2);
            var4.execute();
            var16 = var4.getInt(1);
        } catch (SQLException var14) {
            var16 = var14.getErrorCode();
            if (var16 == 0) {
                throw new XAException(-6);
            }

            throw var14;
        } finally {
            try {
                if (var4 != null) {
                    var4.close();
                }
            } catch (SQLException var13) {
            }

            var4 = null;
        }

        return var16;
    }

    public void commit(Xid var1, boolean var2) throws XAException {
        synchronized(this.connection) {
            if (var1 == null) {
                throw new XAException(-5);
            } else {
                Xid var4 = null;
                if (this.needStackingForCommitRollbackPrepare) {
                    var4 = super.suspendStacked(var1);
                } else {
                    this.removeXidFromList(var1);
                    if (this.activeXid == null) {
                        this.exitGlobalTxnMode();
                    }
                }

                try {
                    try {
                        this.doCommit(var1, var2);
                    } catch (SQLException var9) {
                        this.checkError(var9, -3);
                    }
                } catch (XAException var10) {
                    if (var10.errorCode == -7) {
                        try {
                            this.connection.close();
                        } catch (SQLException var8) {
                        }
                    } else if (this.needStackingForCommitRollbackPrepare) {
                        super.resumeStacked(var4);
                    }

                    throw var10;
                }

                if (this.needStackingForCommitRollbackPrepare) {
                    super.resumeStacked(var4);
                }

            }
        }
    }

    protected void doCommit(Xid var1, boolean var2) throws XAException, SQLException {
        CallableStatement var3 = null;

        try {
            var3 = this.connection.prepareCall(xa_commit_post_816);
            var3.registerOutParameter(1, 2);
            var3.setInt(2, var1.getFormatId());
            var3.setBytes(3, var1.getGlobalTransactionId());
            var3.setBytes(4, var1.getBranchQualifier());
            var3.setInt(5, var2 ? 1 : 0);
            var3.execute();
            int var4 = var3.getInt(1);
            this.checkError(var4, -7);
        } catch (SQLException var13) {
            int var5 = var13.getErrorCode();
            if (var5 == 0) {
                throw new XAException(-6);
            }

            throw var13;
        } finally {
            try {
                if (var3 != null) {
                    var3.close();
                }
            } catch (SQLException var12) {
            }

            var3 = null;
        }

    }

    public int prepare(Xid var1) throws XAException {
        synchronized(this.connection) {
            int var3 = 0;
            if (var1 == null) {
                throw new XAException(-5);
            } else {
                Xid var4 = null;
                if (this.needStackingForCommitRollbackPrepare) {
                    var4 = super.suspendStacked(var1);
                }

                try {
                    try {
                        var3 = this.doPrepare(var1);
                        if (var3 != 0 && var3 != 3) {
                            int var5 = OracleXAException.errorConvert(var3);
                            if (var5 != 0 && var5 != 3) {
                                XAException var6 = OracleXAException.newXAException(this.getConnectionDuringExceptionHandling(), var3);
                                var6.fillInStackTrace();
                                throw var6;
                            }

                            var3 = var5;
                        }
                    } catch (SQLException var9) {
                        this.checkError(var9, -3);
                    }
                } catch (XAException var10) {
                    if (var10.errorCode == -7) {
                        try {
                            this.connection.close();
                        } catch (SQLException var8) {
                        }
                    } else if (this.needStackingForCommitRollbackPrepare) {
                        super.resumeStacked(var4);
                    }

                    throw var10;
                }

                if (this.needStackingForCommitRollbackPrepare) {
                    super.resumeStacked(var4);
                }

                return var3;
            }
        }
    }

    protected int doPrepare(Xid var1) throws XAException, SQLException {
        boolean var2 = false;
        CallableStatement var3 = null;

        int var15;
        try {
            var3 = this.connection.prepareCall(xa_prepare_post_816);
            var3.registerOutParameter(1, 2);
            var3.setInt(2, var1.getFormatId());
            var3.setBytes(3, var1.getGlobalTransactionId());
            var3.setBytes(4, var1.getBranchQualifier());
            var3.execute();
            var15 = var3.getInt(1);
        } catch (SQLException var13) {
            int var5 = var13.getErrorCode();
            if (var5 == 0) {
                throw new XAException(-6);
            }

            throw var13;
        } finally {
            try {
                if (var3 != null) {
                    var3.close();
                }
            } catch (SQLException var12) {
            }

            var3 = null;
        }

        return var15;
    }

    public void forget(Xid var1) throws XAException {
        synchronized(this.connection) {
            int var3 = 0;
            if (var1 == null) {
                throw new XAException(-5);
            } else {
                this.removeXidFromList(var1);

                try {
                    var3 = this.doForget(var1);
                } catch (SQLException var6) {
                    this.checkError(var6, -3);
                }

                this.checkError(var3);
            }
        }
    }

    protected int doForget(Xid var1) throws XAException, SQLException {
        boolean var2 = false;
        CallableStatement var3 = null;

        int var14;
        try {
            var3 = this.connection.prepareCall(xa_forget_post_816);
            var3.registerOutParameter(1, 2);
            var3.setInt(2, var1.getFormatId());
            var3.setBytes(3, var1.getGlobalTransactionId());
            var3.setBytes(4, var1.getBranchQualifier());
            var3.execute();
            var14 = var3.getInt(1);
        } catch (SQLException var12) {
            var14 = var12.getErrorCode();
            if (var14 == 0) {
                throw new XAException(-6);
            }

            throw var12;
        } finally {
            try {
                if (var3 != null) {
                    var3.close();
                }
            } catch (SQLException var11) {
            }

            var3 = null;
        }

        return var14;
    }

    public void rollback(Xid var1) throws XAException {
        synchronized(this.connection) {
            byte var3 = 0;
            if (var1 == null) {
                throw new XAException(-5);
            } else {
                Xid var4 = null;
                if (this.needStackingForCommitRollbackPrepare) {
                    var4 = super.suspendStacked(var1);
                } else {
                    this.removeXidFromList(var1);
                    if (this.activeXid == null) {
                        this.exitGlobalTxnMode();
                    }
                }

                try {
                    this.doRollback(var1);
                } catch (SQLException var7) {
                    this.checkError(var7, -3);
                }

                if (this.needStackingForCommitRollbackPrepare) {
                    super.resumeStacked(var4);
                }

                this.checkError(var3);
            }
        }
    }

    protected void doRollback(Xid var1) throws XAException, SQLException {
        CallableStatement var2 = null;

        try {
            var2 = this.connection.prepareCall(xa_rollback_post_816);
            var2.registerOutParameter(1, 2);
            var2.setInt(2, var1.getFormatId());
            var2.setBytes(3, var1.getGlobalTransactionId());
            var2.setBytes(4, var1.getBranchQualifier());
            var2.execute();
            int var3 = var2.getInt(1);
            this.checkError(var3, -7);
        } catch (SQLException var12) {
            int var4 = var12.getErrorCode();
            if (var4 == 0) {
                throw new XAException(-6);
            }

            throw var12;
        } finally {
            try {
                if (var2 != null) {
                    var2.close();
                }
            } catch (SQLException var11) {
            }

            var2 = null;
        }

    }

    public void doTwoPhaseAction(int var1, int var2, String[] var3, Xid[] var4) throws XAException {
        synchronized(this.connection) {
            this.doDoTwoPhaseAction(var1, var2, var3, var4);
        }
    }

    protected int doDoTwoPhaseAction(int var1, int var2, String[] var3, Xid[] var4) throws XAException {
        throw new XAException(-6);
    }

    private static byte[] getSerializedBytes(Xid var0) {
        try {
            return Util.serializeObject(var0);
        } catch (IOException var2) {
            return null;
        }
    }
}
