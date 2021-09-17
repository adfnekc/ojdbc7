//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package oracle.jdbc.driver;

import java.io.IOException;
import java.sql.SQLException;
import javax.sql.XAConnection;
import javax.transaction.xa.XAException;
import javax.transaction.xa.XAResource;
import javax.transaction.xa.Xid;
import oracle.jdbc.internal.OracleConnection;
import oracle.jdbc.xa.OracleXAConnection;
import oracle.jdbc.xa.OracleXAException;
import oracle.jdbc.xa.OracleXid;
import oracle.jdbc.xa.client.OracleXADataSource;
import oracle.jdbc.xa.client.OracleXAResource;

class T4CXAResource extends OracleXAResource {
    T4CConnection physicalConn;
    int[] applicationValueArr = new int[1];
    boolean isTransLoose = false;
    byte[] context;
    int errorNumber;
    private String password;
    private static final String _Copyright_2007_Oracle_All_Rights_Reserved_ = null;
    public static final String BUILD_DATE = "Thu_Apr_04_15:09:24_PDT_2013";
    public static final boolean TRACE = false;

    T4CXAResource(T4CConnection var1, OracleXAConnection var2, boolean var3) throws XAException {
        super(var1, var2);
        this.physicalConn = var1;
        this.isTransLoose = var3;
    }

    protected int doStart(Xid var1, int var2) throws XAException {
        synchronized(this.physicalConn) {
            boolean var4 = true;
            if (this.isTransLoose) {
                var2 |= 65536;
            }

            int var5 = var2 & 136314880;
            if (var5 == 134217728 && OracleXid.isLocalTransaction(var1)) {
                return 0;
            } else {
                this.applicationValueArr[0] = 0;

                int var18;
                try {
                    try {
                        T4CTTIOtxse var6 = this.physicalConn.otxse;
                        byte[] var19 = null;
                        byte[] var8 = var1.getGlobalTransactionId();
                        byte[] var9 = var1.getBranchQualifier();
                        int var10 = 0;
                        int var11 = 0;
                        if (var8 != null && var9 != null) {
                            var10 = Math.min(var8.length, 64);
                            var11 = Math.min(var9.length, 64);
                            var19 = new byte[128];
                            System.arraycopy(var8, 0, var19, 0, var10);
                            System.arraycopy(var9, 0, var19, var10, var11);
                        }

                        byte var12 = 0;
                        int var20;
                        if ((var2 & 2097152) == 0 && (var2 & 134217728) == 0) {
                            var20 = var12 | 1;
                        } else {
                            var20 = var12 | 4;
                        }

                        if ((var2 & 256) != 0) {
                            var20 |= 256;
                        }

                        if ((var2 & 512) != 0) {
                            var20 |= 512;
                        }

                        if ((var2 & 1024) != 0) {
                            var20 |= 1024;
                        }

                        if ((var2 & 65536) != 0) {
                            var20 |= 65536;
                        }

                        this.physicalConn.needLine();
                        var6.doOTXSE(1, (byte[])null, var19, var1.getFormatId(), var10, var11, this.timeout, var20, this.applicationValueArr);
                        this.applicationValueArr[0] = var6.getApplicationValue();
                        byte[] var13 = var6.getContext();
                        if (var13 != null) {
                            this.context = var13;
                        }

                        var18 = 0;
                        this.physicalConn.currentlyInTransaction = true;
                    } catch (IOException var15) {
                        SQLException var7 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), var15);
                        var7.fillInStackTrace();
                        throw var7;
                    }
                } catch (SQLException var16) {
                    var18 = var16.getErrorCode();
                    if (var18 == 0) {
                        throw new XAException(-6);
                    }
                }

                return var18;
            }
        }
    }

    protected int doEnd(Xid var1, int var2, boolean var3) throws XAException {
        synchronized(this.physicalConn) {
            boolean var5 = true;

            int var19;
            try {
                try {
                    T4CTTIOtxse var6 = this.physicalConn.otxse;
                    byte[] var20 = null;
                    byte[] var8 = var1.getGlobalTransactionId();
                    byte[] var9 = var1.getBranchQualifier();
                    int var10 = 0;
                    int var11 = 0;
                    if (var8 != null && var9 != null) {
                        var10 = Math.min(var8.length, 64);
                        var11 = Math.min(var9.length, 64);
                        var20 = new byte[128];
                        System.arraycopy(var8, 0, var20, 0, var10);
                        System.arraycopy(var9, 0, var20, var10, var11);
                    }

                    if (this.context == null) {
                        var19 = this.doStart(var1, 134217728);
                        if (var19 != 0) {
                            int var21 = var19;
                            return var21;
                        }
                    }

                    byte[] var12 = this.context;
                    int var13 = 0;
                    if ((var2 & 2) == 2) {
                        var13 = 1048576;
                    } else if ((var2 & 33554432) == 33554432 && (var2 & 1048576) != 1048576) {
                        var13 = 1048576;
                    }

                    int[] var10000 = this.applicationValueArr;
                    var10000[0] >>= 16;
                    this.physicalConn.needLine();
                    var6.doOTXSE(2, var12, var20, var1.getFormatId(), var10, var11, this.timeout, var13, this.applicationValueArr);
                    this.applicationValueArr[0] = var6.getApplicationValue();
                    byte[] var14 = var6.getContext();
                    if (var14 != null) {
                        this.context = var14;
                    }

                    var19 = 0;
                    this.physicalConn.currentlyInTransaction = false;
                    return var19;
                } catch (IOException var16) {
                    SQLException var7 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), var16);
                    var7.fillInStackTrace();
                    throw var7;
                }
            } catch (SQLException var17) {
                var19 = var17.getErrorCode();
                if (var19 == 0) {
                    throw new XAException(-6);
                } else {
                    return var19;
                }
            }
        }
    }

    protected void doCommit(Xid var1, boolean var2) throws SQLException, XAException {
        synchronized(this.physicalConn) {
            int var4 = var2 ? 4 : 2;

            try {
                int var5 = this.doTransaction(var1, 1, var4);
                if ((!var2 || var5 != 2 && var5 != 4) && (var2 || var5 != 5)) {
                    if (var5 == 8) {
                        throw new XAException(106);
                    }

                    throw new XAException(-6);
                }

                this.physicalConn.currentlyInTransaction = false;
            } catch (SQLException var23) {
                int var6 = var23.getErrorCode();
                if (var6 == 24756) {
                    this.kputxrec(var1, 1, this.timeout + 120, var23);
                } else {
                    if (var6 != 24780) {
                        throw var23;
                    }

                    OracleXADataSource var7 = null;
                    XAConnection var8 = null;

                    try {
                        var7 = new OracleXADataSource();
                        var7.setURL(this.physicalConn.url);
                        var7.setUser(this.physicalConn.userName);
                        this.physicalConn.getPasswordInternal(this);
                        var7.setPassword(this.password);
                        var8 = var7.getXAConnection();
                        XAResource var9 = var8.getXAResource();
                        var9.commit(var1, var2);
                        this.physicalConn.currentlyInTransaction = false;
                    } catch (SQLException var21) {
                        XAException var10 = new XAException(-6);
                        var10.initCause(var21);
                        throw var10;
                    } finally {
                        try {
                            if (var8 != null) {
                                var8.close();
                            }

                            if (var7 != null) {
                                var7.close();
                            }
                        } catch (Exception var20) {
                        }

                    }
                }
            }

        }
    }

    protected int doPrepare(Xid var1) throws XAException, SQLException {
        synchronized(this.physicalConn) {
            boolean var3 = true;

            byte var10;
            try {
                int var4 = this.doTransaction(var1, 3, 0);
                if (var4 == 8) {
                    throw new XAException(106);
                }

                if (var4 == 4) {
                    var10 = 3;
                } else {
                    if (var4 != 1) {
                        if (var4 == 3) {
                            throw new XAException(100);
                        }

                        throw new XAException(-6);
                    }

                    var10 = 0;
                }
            } catch (SQLException var8) {
                int var5 = var8.getErrorCode();
                if (var5 == 25351) {
                    XAException var6 = new XAException(-6);
                    var6.initCause(var8);
                    throw var6;
                }

                throw var8;
            }

            return var10;
        }
    }

    protected int doForget(Xid var1) throws XAException, SQLException {
        synchronized(this.physicalConn) {
            byte var3 = 0;
            if (OracleXid.isLocalTransaction(var1)) {
                return 24771;
            } else {
                int var4 = this.doStart(var1, 134217728);
                if (var4 != 24756) {
                    if (var4 == 0) {
                        try {
                            this.doEnd(var1, 0, false);
                        } catch (Exception var7) {
                        }
                    }

                    if (var4 != 0 && var4 != 2079 && var4 != 24754 && var4 != 24761 && var4 != 24774 && var4 != 24776 && var4 != 25351) {
                        return var4 == 24752 ? 24771 : var4;
                    } else {
                        return 24769;
                    }
                } else {
                    this.kputxrec(var1, 4, 1, (SQLException)null);
                    return var3;
                }
            }
        }
    }

    protected void doRollback(Xid var1) throws XAException, SQLException {
        synchronized(this.physicalConn) {
            try {
                int var3 = this.doTransaction(var1, 2, 3);
                if (var3 == 8) {
                    throw new XAException(106);
                }

                if (var3 != 3) {
                    throw new XAException(-6);
                }

                this.physicalConn.currentlyInTransaction = false;
            } catch (SQLException var21) {
                int var4 = var21.getErrorCode();
                if (var4 == 24756) {
                    this.kputxrec(var1, 2, this.timeout + 120, var21);
                } else if (var4 == 24780) {
                    OracleXADataSource var5 = null;
                    XAConnection var6 = null;

                    try {
                        var5 = new OracleXADataSource();
                        var5.setURL(this.physicalConn.url);
                        var5.setUser(this.physicalConn.userName);
                        this.physicalConn.getPasswordInternal(this);
                        var5.setPassword(this.password);
                        var6 = var5.getXAConnection();
                        XAResource var7 = var6.getXAResource();
                        var7.rollback(var1);
                        this.physicalConn.currentlyInTransaction = false;
                    } catch (SQLException var19) {
                        XAException var8 = new XAException(-6);
                        var8.initCause(var19);
                        throw var8;
                    } finally {
                        try {
                            if (var6 != null) {
                                var6.close();
                            }

                            if (var5 != null) {
                                var5.close();
                            }
                        } catch (Exception var18) {
                        }

                    }
                } else if (var4 != 25402) {
                    throw var21;
                }
            }

        }
    }

    int doTransaction(Xid var1, int var2, int var3) throws SQLException {
        boolean var4 = true;

        try {
            T4CTTIOtxen var5 = this.physicalConn.otxen;
            byte[] var14 = null;
            byte[] var7 = var1.getGlobalTransactionId();
            byte[] var8 = var1.getBranchQualifier();
            int var9 = 0;
            int var10 = 0;
            if (var7 != null && var8 != null) {
                var9 = Math.min(var7.length, 64);
                var10 = Math.min(var8.length, 64);
                var14 = new byte[128];
                System.arraycopy(var7, 0, var14, 0, var9);
                System.arraycopy(var8, 0, var14, var9, var10);
            }

            byte[] var11 = this.context;
            this.physicalConn.needLine();
            var5.doOTXEN(var2, var11, var14, var1.getFormatId(), var9, var10, this.timeout, var3, 0);
            int var13 = var5.getOutStateFromServer();
            return var13;
        } catch (IOException var12) {
            this.physicalConn.handleIOException(var12);
            SQLException var6 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), var12);
            var6.fillInStackTrace();
            throw var6;
        }
    }

    protected void kputxrec(Xid var1, int var2, int var3, SQLException var4) throws XAException, SQLException {
        byte var5;
        switch(var2) {
            case 1:
                var5 = 3;
                break;
            case 4:
                var5 = 2;
                break;
            default:
                var5 = 0;
        }

        int var6 = 0;

        while(var3-- > 0) {
            var6 = this.doTransaction(var1, 5, var5);
            if (var6 != 7) {
                break;
            }

            try {
                Thread.sleep(1000L);
            } catch (Exception var14) {
            }
        }

        if (var6 == 7) {
            throw new XAException(-6);
        } else {
            byte var8 = -1;
            byte var7;
            switch(var6) {
                case 0:
                    if (var2 == 4) {
                        var7 = 8;
                        var8 = -3;
                    } else {
                        var7 = 7;
                        if (var2 == 1) {
                            var8 = -4;
                        }
                    }
                    break;
                case 1:
                default:
                    var8 = -3;
                    var7 = 8;
                    break;
                case 2:
                    if (var2 == 4) {
                        var7 = 8;
                        var8 = -6;
                        break;
                    }
                case 5:
                    if (var2 == 4) {
                        var7 = 7;
                    } else {
                        var8 = 7;
                        var7 = 8;
                    }
                    break;
                case 3:
                    if (var2 == 1) {
                        var7 = 7;
                    } else {
                        var7 = 8;
                        var8 = -3;
                    }
                    break;
                case 4:
                    if (var2 == 4) {
                        var7 = 7;
                    } else {
                        var8 = 6;
                        var7 = 8;
                    }
                    break;
                case 6:
                    if (var2 == 4) {
                        var7 = 7;
                    } else {
                        var8 = 5;
                        var7 = 8;
                    }
            }

            T4CTTIk2rpc var9 = this.physicalConn.k2rpc;

            XAException var11;
            try {
                var9.doOK2RPC(3, var7);
            } catch (IOException var12) {
                var11 = new XAException(-7);
                var11.initCause(var12);
                throw var11;
            } catch (SQLException var13) {
                var11 = new XAException(-6);
                var11.initCause(var13);
                throw var11;
            }

            if (var8 != -1) {
                OracleXAException var10 = null;
                if (var4 != null) {
                    var10 = new OracleXAException(var4.getErrorCode(), var8);
                    var10.initCause(var4);
                } else {
                    var10 = new OracleXAException(0, var8);
                }

                throw var10;
            }
        }
    }

    final void setPasswordInternal(String var1) {
        this.password = var1;
    }

    protected OracleConnection getConnectionDuringExceptionHandling() {
        return this.physicalConn;
    }
}
