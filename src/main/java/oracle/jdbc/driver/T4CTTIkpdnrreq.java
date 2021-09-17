//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package oracle.jdbc.driver;

import java.io.IOException;

class T4CTTIkpdnrreq {
    byte[] clientIdBytes;
    short registrationOpCode;
    boolean acknowledgement = false;
    T4CTTIkpdnrack notificationAcknowledgment;
    T4CMAREngine mar;
    private static final String _Copyright_2007_Oracle_All_Rights_Reserved_ = null;
    public static final String BUILD_DATE = "Thu_Apr_04_15:09:24_PDT_2013";
    public static final boolean TRACE = false;

    T4CTTIkpdnrreq(T4CConnection var1) {
        this.mar = var1.mare;
    }

    void send(byte[] var1, T4CTTIkpdnrreq.OpCode var2) throws IOException {
        this.clientIdBytes = var1;
        this.registrationOpCode = var2.getCode();
        this.marshal();
    }

    void marshal() throws IOException {
        if (this.clientIdBytes != null && this.clientIdBytes.length != 0) {
            this.mar.marshalUB2(this.clientIdBytes.length);
            this.mar.marshalCLR(this.clientIdBytes, 0, this.clientIdBytes.length);
        } else {
            this.mar.marshalSWORD(0);
        }

        this.mar.marshalUB1(this.registrationOpCode);
        if (this.acknowledgement) {
            this.notificationAcknowledgment.send((byte[])null, 0L, (byte[])null);
        } else {
            this.mar.marshalSWORD(0);
        }

    }

    static enum OpCode {
        INIT_KPDNRREQ((short)1),
        COMMIT_KPDNRREQ((short)2),
        ROLLBACK_KPDNRREQ((short)3),
        REINIT_KPDNRREQ((short)4);

        private final short mode;

        private OpCode(short var3) {
            this.mode = var3;
        }

        public final short getCode() {
            return this.mode;
        }
    }
}
