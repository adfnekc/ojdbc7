//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package oracle.jdbc.driver;

import java.io.IOException;
import java.sql.SQLException;
import oracle.jdbc.driver.T4CTTIkpdnrreq.OpCode;

final class T4CTTIoaqnfy extends T4CTTIfun {
    byte[] clientId = null;
    boolean isMarshalOver = false;
    boolean needToBeClosed = false;
    OracleConnection conn = null;
    T4CTTIkpdnrnf notificationHeader = null;
    T4CTTIkpdnrmp messageProperties = null;
    T4CTTIkpdnrpay payload = null;
    NTFManager ntfManager = null;
    T4CMAREngine mar;
    String databaseUniqueIdentifier;
    NTFJMSPerDatabaseManager jmsPerDatabaseManager = null;
    private static final String _Copyright_2007_Oracle_All_Rights_Reserved_ = null;
    public static final String BUILD_DATE = "Thu_Apr_04_15:09:24_PDT_2013";
    public static final boolean TRACE = false;

    T4CTTIoaqnfy(T4CConnection var1, String var2, NTFJMSPerDatabaseManager var3) throws SQLException {
        super(var1, (byte)3);

        assert var1 != null && var2 != null : "_connection is " + var1 + ", _clientId is " + var2;

        this.setFunCode((short)187);
        this.conn = var1;
        this.mar = var1.mare;
        this.clientId = this.mar.conv.StringToCharBytes(var2);
        this.jmsPerDatabaseManager = var3;
        this.databaseUniqueIdentifier = var1.databaseUniqueIdentifier;
    }

    void marshal() throws IOException {
        T4CTTIkpdnrreq var1 = new T4CTTIkpdnrreq((T4CConnection)this.conn);
        var1.send(this.clientId, OpCode.INIT_KPDNRREQ);
        this.isMarshalOver = true;
    }

    void readOAC() {
        try {
            while(true) {
                this.notificationHeader = new T4CTTIkpdnrnf((T4CConnection)this.conn);
                this.notificationHeader.receive();
                this.messageProperties = new T4CTTIkpdnrmp((T4CConnection)this.conn);
                this.messageProperties.receive();
                this.payload = new T4CTTIkpdnrpay((T4CConnection)this.conn);
                this.payload.receive();
                this.createAndGenerateEvent();
            }
        } catch (Exception var2) {
            if (this.needToBeClosed) {
            }

        }
    }

    public void createAndGenerateEvent() throws SQLException {
        NTFJMSEvent var1 = new NTFJMSEvent(this);
        var1.setAqMessageProperites(this.messageProperties.getAqMessageProperties());
        var1.setJmsMessageProperties(this.messageProperties.getJmsMessageProperties());
        var1.setMessageId(this.messageProperties.getMessageId());
        var1.setPayload(this.payload.getRawPayload());
        var1.setConsumerName(this.notificationHeader.getConsumerName());
        var1.setQueueName(this.notificationHeader.getNotificationQueue());
        var1.setRegistration(this.notificationHeader.getNotificationQueue());
        int var2 = this.jmsPerDatabaseManager.getJDBCRegId(this.notificationHeader.getRegistrationId());
        NTFJMSRegistration var3 = (NTFJMSRegistration)PhysicalConnection.ntfManager.getRegistration(var2);
        var3.notify(var1);
    }

    public void stopListening() {
        while(!this.isMarshalOver) {
        }

        this.needToBeClosed = true;
    }
}
