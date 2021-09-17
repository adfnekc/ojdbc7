//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package oracle.jdbc.driver;

import java.sql.SQLException;
import oracle.jdbc.aq.AQMessageProperties;
import oracle.jdbc.internal.JMSMessageProperties;
import oracle.jdbc.internal.JMSNotificationEvent;

public class NTFJMSEvent extends JMSNotificationEvent {
    private JMSMessageProperties jmsMessageProperties = null;
    private AQMessageProperties aqMessageProperties = null;
    private String registrationString = null;
    private byte[] payload;
    private String queueName = null;
    private byte[] messageId = null;
    private String consumerName = null;
    private static final String _Copyright_2007_Oracle_All_Rights_Reserved_ = null;
    public static final String BUILD_DATE = "Thu_Apr_04_15:09:24_PDT_2013";
    public static final boolean TRACE = false;

    NTFJMSEvent(T4CTTIoaqnfy var1) {
        super(var1);
    }

    public JMSMessageProperties getJMSMessageProperties() throws SQLException {
        return this.jmsMessageProperties;
    }

    public AQMessageProperties getMessageProperties() throws SQLException {
        return this.aqMessageProperties;
    }

    public byte[] getPayload() throws SQLException {
        return this.payload;
    }

    public String getQueueName() throws SQLException {
        return this.queueName;
    }

    public byte[] getMessageId() throws SQLException {
        return this.messageId;
    }

    public String getConsumerName() throws SQLException {
        return this.consumerName;
    }

    public String getRegistrationName() throws SQLException {
        return this.registrationString;
    }

    void setAqMessageProperites(AQMessageProperties var1) {
        this.aqMessageProperties = var1;
    }

    void setConsumerName(String var1) {
        this.consumerName = var1;
    }

    void setJmsMessageProperties(JMSMessageProperties var1) {
        this.jmsMessageProperties = var1;
    }

    void setMessageId(byte[] var1) {
        this.messageId = var1;
    }

    void setPayload(byte[] var1) {
        this.payload = var1;
    }

    void setQueueName(String var1) {
        this.queueName = var1;
    }

    void setRegistration(String var1) {
        this.registrationString = var1;
    }
}
