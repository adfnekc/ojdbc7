//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package oracle.jdbc.driver;

import java.io.IOException;
import java.sql.SQLException;
import oracle.jdbc.internal.OracleConnection;

final class T4CTTIk2rpc extends T4CTTIfun {
    static final int K2RPClogon = 1;
    static final int K2RPCbegin = 2;
    static final int K2RPCend = 3;
    static final int K2RPCrecover = 4;
    static final int K2RPCsession = 5;
    private int k2rpctyp;
    private int command;
    private static final String _Copyright_2007_Oracle_All_Rights_Reserved_ = null;
    public static final String BUILD_DATE = "Thu_Apr_04_15:09:24_PDT_2013";
    public static final boolean TRACE = false;

    T4CTTIk2rpc(T4CConnection var1) {
        super(var1, (byte)3);
        this.setFunCode((short)67);
    }

    void doOK2RPC(int var1, int var2) throws IOException, SQLException {
        this.k2rpctyp = var1;
        this.command = var2;
        this.doRPC();
    }

    void marshal() throws IOException {
        this.meg.marshalUB4(0L);
        this.meg.marshalUB4((long)this.k2rpctyp);
        this.meg.marshalPTR();
        this.meg.marshalUB4(3L);
        this.meg.marshalNULLPTR();
        this.meg.marshalUB4(0L);
        this.meg.marshalNULLPTR();
        this.meg.marshalUB4(0L);
        this.meg.marshalPTR();
        this.meg.marshalUB4(3L);
        this.meg.marshalPTR();
        this.meg.marshalNULLPTR();
        this.meg.marshalUB4(0L);
        this.meg.marshalNULLPTR();
        this.meg.marshalNULLPTR();
        this.meg.marshalUB4(0L);
        this.meg.marshalNULLPTR();
        this.meg.marshalUB4((long)this.command);
        this.meg.marshalUB4(0L);
        this.meg.marshalUB4(0L);
    }

    void readRPA() throws IOException, SQLException {
        int var1 = this.meg.unmarshalUB2();

        for(int var2 = 0; var2 < var1; ++var2) {
            this.meg.unmarshalUB4();
        }

    }

    protected OracleConnection getConnectionDuringExceptionHandling() {
        return null;
    }
}
