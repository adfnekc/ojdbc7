//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package oracle.jdbc.driver;

import java.io.IOException;
import java.sql.SQLException;

class T4CTTIkpdnrpay {
    private int payloadType;
    private int payloadFlag;
    private int chunkNumber;
    private byte[] rawPayload = null;
    T4CConnection connection = null;
    T4CMAREngine mar;
    private static final String _Copyright_2007_Oracle_All_Rights_Reserved_ = null;
    public static final String BUILD_DATE = "Thu_Apr_04_15:09:24_PDT_2013";
    public static final boolean TRACE = false;

    T4CTTIkpdnrpay(T4CConnection var1) {
        this.mar = var1.mare;
    }

    public void receive() throws SQLException, IOException {
        this.payloadType = (int)this.mar.unmarshalUB4();
        this.payloadFlag = (int)this.mar.unmarshalUB4();
        this.chunkNumber = (int)this.mar.unmarshalUB4();
        int var1 = this.mar.unmarshalSWORD();
        if (var1 > 0) {
            this.rawPayload = new byte[var1];
            int[] var2 = new int[1];
            this.mar.unmarshalCLR(this.rawPayload, 0, var2, this.rawPayload.length);
            var1 = var2[0];
        }

        int var3 = this.mar.unmarshalSWORD();
    }

    public byte[] getRawPayload() {
        return this.rawPayload;
    }
}
