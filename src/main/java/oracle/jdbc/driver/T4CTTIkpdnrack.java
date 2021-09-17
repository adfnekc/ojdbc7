//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package oracle.jdbc.driver;

import java.io.IOException;

class T4CTTIkpdnrack {
    byte[] acknowledgmentQueue;
    long acknowledgementRegistrationId;
    byte[] lastReceivedMessageId;
    T4CMAREngine mar;
    private static final String _Copyright_2007_Oracle_All_Rights_Reserved_ = null;
    public static final String BUILD_DATE = "Thu_Apr_04_15:09:24_PDT_2013";
    public static final boolean TRACE = false;

    T4CTTIkpdnrack(T4CConnection var1) {
        this.mar = var1.mare;
    }

    void send(byte[] var1, long var2, byte[] var4) throws IOException {
        this.acknowledgmentQueue = var1;
        this.acknowledgementRegistrationId = var2;
        this.lastReceivedMessageId = var4;
        this.marshal();
    }

    void marshal() throws IOException {
        if (this.acknowledgmentQueue != null && this.acknowledgmentQueue.length != 0) {
            this.mar.marshalSWORD(this.acknowledgmentQueue.length);
            this.mar.marshalCLR(this.acknowledgmentQueue, 0, this.acknowledgmentQueue.length);
        } else {
            this.mar.marshalSWORD(0);
        }

        this.mar.marshalUB4(this.acknowledgementRegistrationId);
        if (this.lastReceivedMessageId != null && this.lastReceivedMessageId.length != 0) {
            this.mar.marshalSWORD(this.lastReceivedMessageId.length);
            this.mar.marshalCLR(this.lastReceivedMessageId, 0, this.lastReceivedMessageId.length);
        } else {
            this.mar.marshalSWORD(0);
        }

    }
}
