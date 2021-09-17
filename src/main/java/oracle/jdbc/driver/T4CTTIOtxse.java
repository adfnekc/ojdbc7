//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package oracle.jdbc.driver;

import java.io.IOException;
import java.sql.SQLException;
import oracle.jdbc.internal.OracleConnection;

final class T4CTTIOtxse extends T4CTTIfun {
    static final int OTXSTA = 1;
    static final int OTXDET = 2;
    static final int OCI_TRANS_NEW = 1;
    static final int OCI_TRANS_JOIN = 2;
    static final int OCI_TRANS_RESUME = 4;
    static final int OCI_TRANS_STARTMASK = 255;
    static final int OCI_TRANS_READONLY = 256;
    static final int OCI_TRANS_READWRITE = 512;
    static final int OCI_TRANS_SERIALIZABLE = 1024;
    static final int OCI_TRANS_ISOLMASK = 65280;
    static final int OCI_TRANS_LOOSE = 65536;
    static final int OCI_TRANS_TIGHT = 131072;
    static final int OCI_TRANS_TYPEMASK = 983040;
    static final int OCI_TRANS_NOMIGRATE = 1048576;
    static final int OCI_TRANS_SEPARABLE = 2097152;
    boolean sendTransactionContext = false;
    private int operation;
    private int formatId;
    private int gtridLength;
    private int bqualLength;
    private int timeout;
    private int flag;
    private int[] xidapp = null;
    private byte[] transactionContext;
    private byte[] xid = null;
    private int applicationValue = -1;
    private byte[] ctx = null;
    private static final String _Copyright_2007_Oracle_All_Rights_Reserved_ = null;
    public static final String BUILD_DATE = "Thu_Apr_04_15:09:24_PDT_2013";
    public static final boolean TRACE = false;

    T4CTTIOtxse(T4CConnection var1) {
        super(var1, (byte)3);
        this.setFunCode((short)103);
    }

    void doOTXSE(int var1, byte[] var2, byte[] var3, int var4, int var5, int var6, int var7, int var8, int[] var9) throws IOException, SQLException {
        if (var1 != 1 && var1 != 2) {
            throw new SQLException("Invalid operation.");
        } else {
            this.operation = var1;
            this.formatId = var4;
            this.gtridLength = var5;
            this.bqualLength = var6;
            this.timeout = var7;
            this.flag = var8;
            this.xidapp = var9;
            this.transactionContext = var2;
            this.xid = var3;
            this.applicationValue = -1;
            this.ctx = null;
            if (this.operation == 2 && this.transactionContext == null) {
                throw new SQLException("Transaction context cannot be null when detach is called.");
            } else {
                this.doRPC();
            }
        }
    }

    void marshal() throws IOException {
        int var1 = this.operation;
        this.meg.marshalSWORD(var1);
        if (this.operation == 2) {
            this.sendTransactionContext = true;
            this.meg.marshalPTR();
        } else {
            this.sendTransactionContext = false;
            this.meg.marshalNULLPTR();
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

        this.meg.marshalUB4((long)this.flag);
        this.meg.marshalUWORD((long)this.timeout);
        if (this.xidapp != null) {
            this.meg.marshalPTR();
        } else {
            this.meg.marshalNULLPTR();
        }

        this.meg.marshalPTR();
        this.meg.marshalPTR();
        boolean var2 = false;
        boolean var3 = false;
        if (this.connection.getTTCVersion() >= 5) {
            if (this.connection.internalName != null) {
                var2 = true;
                this.meg.marshalPTR();
                this.meg.marshalUB4((long)this.connection.internalName.length);
            } else {
                this.meg.marshalNULLPTR();
                this.meg.marshalUB4(0L);
            }

            if (this.connection.externalName != null) {
                var3 = true;
                this.meg.marshalPTR();
                this.meg.marshalUB4((long)this.connection.externalName.length);
            } else {
                this.meg.marshalNULLPTR();
                this.meg.marshalUB4(0L);
            }
        }

        if (this.sendTransactionContext) {
            this.meg.marshalB1Array(this.transactionContext);
        }

        if (this.xid != null) {
            this.meg.marshalB1Array(this.xid);
        }

        if (this.xidapp != null) {
            this.meg.marshalUB4((long)this.xidapp[0]);
        }

        if (this.connection.getTTCVersion() >= 5) {
            if (var2) {
                this.meg.marshalCHR(this.connection.internalName);
            }

            if (var3) {
                this.meg.marshalCHR(this.connection.externalName);
            }
        }

    }

    byte[] getContext() {
        return this.ctx;
    }

    int getApplicationValue() {
        return this.applicationValue;
    }

    void readRPA() throws IOException, SQLException {
        this.applicationValue = (int)this.meg.unmarshalUB4();
        int var1 = this.meg.unmarshalUB2();
        this.ctx = this.meg.unmarshalNBytes(var1);
    }

    protected OracleConnection getConnectionDuringExceptionHandling() {
        return this.connection;
    }
}
