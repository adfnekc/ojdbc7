//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package oracle.jdbc.driver;

import java.io.IOException;
import java.sql.SQLException;

class T4CTTIkpdnrnf {
    int messageType;
    int errorCode;
    long registrationId;
    byte[] notificationQueue = null;
    byte[] consumerName = null;
    String consumerNameString = null;
    T4CConnection connection = null;
    T4CMAREngine mar;
    private static final String _Copyright_2007_Oracle_All_Rights_Reserved_ = null;
    public static final String BUILD_DATE = "Thu_Apr_04_15:09:24_PDT_2013";
    public static final boolean TRACE = false;

    T4CTTIkpdnrnf(T4CConnection var1) {
        this.mar = var1.mare;
    }

    public void receive() throws SQLException, IOException {
        this.messageType = (int)this.mar.unmarshalUB4();
        this.errorCode = (int)this.mar.unmarshalUB4();
        this.registrationId = this.mar.unmarshalUB4();
        int var1 = (int)this.mar.unmarshalUB4();
        if (var1 > 0) {
            this.notificationQueue = new byte[var1];
            int[] var2 = new int[1];
            this.mar.unmarshalCLR(this.notificationQueue, 0, var2, this.notificationQueue.length);
            var1 = var2[0];
        }

        int var4 = (int)this.mar.unmarshalUB4();
        if (var4 > 0) {
            this.consumerName = new byte[var4];
            int[] var3 = new int[1];
            this.mar.unmarshalCLR(this.consumerName, 0, var3, this.consumerName.length);
            var4 = var3[0];
        }

    }

    public String getNotificationQueue() throws SQLException {
        return this.mar.conv.CharBytesToString(this.notificationQueue, this.notificationQueue.length);
    }

    public long getRegistrationId() {
        return this.registrationId;
    }

    public String getConsumerName() throws SQLException {
        return this.consumerName == null ? null : this.mar.conv.CharBytesToString(this.consumerName, this.consumerName.length);
    }
}
