//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package oracle.jdbc.driver;

import java.io.IOException;
import java.sql.SQLException;
import oracle.jdbc.internal.OracleConnection;

final class T4CTTIOtxen extends T4CTTIfun {
    static final int OTXCOMIT = 1;
    static final int OTXABORT = 2;
    static final int OTXPREPA = 3;
    static final int OTXFORGT = 4;
    static final int OTXRECOV = 5;
    static final int OTXMLPRE = 6;
    static final int K2CMDprepare = 0;
    static final int K2CMDrqcommit = 1;
    static final int K2CMDcommit = 2;
    static final int K2CMDabort = 3;
    static final int K2CMDrdonly = 4;
    static final int K2CMDforget = 5;
    static final int K2CMDrecovered = 7;
    static final int K2CMDtimeout = 8;
    static final int K2STAidle = 0;
    static final int K2STAcollecting = 1;
    static final int K2STAprepared = 2;
    static final int K2STAcommitted = 3;
    static final int K2STAhabort = 4;
    static final int K2STAhcommit = 5;
    static final int K2STAhdamage = 6;
    static final int K2STAtimeout = 7;
    static final int K2STAinactive = 9;
    static final int K2STAactive = 10;
    static final int K2STAptprepared = 11;
    static final int K2STAptcommitted = 12;
    static final int K2STAmax = 13;
    static final int OTXNDEF_F_CWRBATCH = 1;
    static final int OTXNDEF_F_CWRBATOPT = 2;
    static final int OTXNDEF_F_CWRNOWAIT = 4;
    static final int OTXNDEF_F_CWRWATOPT = 8;
    static final int OTXNDEF_F_CWRBATMSK = 3;
    static final int OTXNDEF_F_CWRWATMSK = 12;
    private int operation;
    private int formatId;
    private int gtridLength;
    private int bqualLength;
    private int timeout;
    private int inState;
    private int txnflg;
    private byte[] transactionContext;
    private byte[] xid = null;
    private int outState = -1;
    private static final String _Copyright_2007_Oracle_All_Rights_Reserved_ = null;
    public static final String BUILD_DATE = "Thu_Apr_04_15:09:24_PDT_2013";
    public static final boolean TRACE = false;

    T4CTTIOtxen(T4CConnection var1) {
        super(var1, (byte)3);
        this.setFunCode((short)104);
    }

    void doOTXEN(int var1, byte[] var2, byte[] var3, int var4, int var5, int var6, int var7, int var8, int var9) throws IOException, SQLException {
        if (var1 != 1 && var1 != 2 && var1 != 3 && var1 != 4 && var1 != 5 && var1 != 6) {
            throw new SQLException("Invalid operation.");
        } else {
            this.operation = var1;
            this.formatId = var4;
            this.gtridLength = var5;
            this.bqualLength = var6;
            this.timeout = var7;
            this.inState = var8;
            this.txnflg = var9;
            this.transactionContext = var2;
            this.xid = var3;
            this.outState = -1;
            this.doRPC();
        }
    }

    void marshal() throws IOException {
        int var1 = this.operation;
        this.meg.marshalSWORD(var1);
        if (this.transactionContext == null) {
            this.meg.marshalNULLPTR();
        } else {
            this.meg.marshalPTR();
        }

        if (this.transactionContext == null) {
            this.meg.marshalUB4(0L);
        } else {
            this.meg.marshalUB4((long)this.transactionContext.length);
        }

        this.meg.marshalUB4((long)this.formatId);
        this.meg.marshalUB4((long)this.gtridLength);
        this.meg.marshalUB4((long)this.bqualLength);
        if (this.xid != null) {
            this.meg.marshalPTR();
        } else {
            this.meg.marshalNULLPTR();
        }

        if (this.xid != null) {
            this.meg.marshalUB4((long)this.xid.length);
        } else {
            this.meg.marshalUB4(0L);
        }

        this.meg.marshalUWORD((long)this.timeout);
        this.meg.marshalUB4((long)this.inState);
        this.meg.marshalPTR();
        if (this.connection.getTTCVersion() >= 4) {
            this.meg.marshalUB4((long)this.txnflg);
        }

        if (this.transactionContext != null) {
            this.meg.marshalB1Array(this.transactionContext);
        }

        if (this.xid != null) {
            this.meg.marshalB1Array(this.xid);
        }

    }

    void readRPA() throws IOException, SQLException {
        this.outState = (int)this.meg.unmarshalUB4();
    }

    int getOutStateFromServer() {
        return this.outState;
    }

    protected OracleConnection getConnectionDuringExceptionHandling() {
        return null;
    }
}
