//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package oracle.jdbc.driver;

import java.io.IOException;
import java.sql.SQLException;
import oracle.jdbc.aq.AQFactory;
import oracle.jdbc.aq.AQMessageProperties.DeliveryMode;
import oracle.jdbc.aq.AQMessageProperties.MessageState;
import oracle.jdbc.internal.JMSFactory;
import oracle.jdbc.internal.JMSMessageProperties.JMSMessageType;

class T4CTTIkpdnrmp {
    byte[] messageId;
    AQMessagePropertiesI aqMessageProperties;
    JMSMessagePropertiesI jmsMessageProperties;
    private T4CTTIaqm aqm = null;
    private T4CTTIaqjms aqjms = null;
    private T4Ctoh toh = null;
    T4CMAREngine mar;
    private static final String _Copyright_2007_Oracle_All_Rights_Reserved_ = null;
    public static final String BUILD_DATE = "Thu_Apr_04_15:09:24_PDT_2013";
    public static final boolean TRACE = false;

    T4CTTIkpdnrmp(T4CConnection var1) {
        this.toh = new T4Ctoh();
        this.aqm = new T4CTTIaqm(var1, this.toh);
        this.mar = var1.mare;
        this.aqjms = new T4CTTIaqjms(var1);
    }

    public void receive() throws SQLException, IOException {
        int var1 = this.mar.unmarshalSWORD();
        if (var1 > 0) {
            this.messageId = new byte[var1];
            int[] var2 = new int[1];
            this.mar.unmarshalCLR(this.messageId, 0, var2, this.messageId.length);
            var1 = var2[0];
        }

        int var5 = this.mar.unmarshalSWORD();
        if (var5 > 0) {
            this.mar.unmarshalUB1();
            this.aqm.receive();
            this.aqMessageProperties = (AQMessagePropertiesI)AQFactory.createAQMessageProperties();
            this.aqMessageProperties.setPriority(this.aqm.aqmpri);
            this.aqMessageProperties.setDelay(this.aqm.aqmdel);
            this.aqMessageProperties.setExpiration(this.aqm.aqmexp);
            String var3;
            if (this.aqm.aqmcorBytes != null) {
                var3 = this.mar.conv.CharBytesToString(this.aqm.aqmcorBytes, this.aqm.aqmcorBytesLength, true);
                this.aqMessageProperties.setCorrelation(var3);
            }

            this.aqMessageProperties.setAttempts(this.aqm.aqmatt);
            if (this.aqm.aqmeqnBytes != null) {
                var3 = this.mar.conv.CharBytesToString(this.aqm.aqmeqnBytes, this.aqm.aqmeqnBytesLength, true);
                this.aqMessageProperties.setExceptionQueue(var3);
            }

            this.aqMessageProperties.setMessageState(MessageState.getMessageState(this.aqm.aqmsta));
            if (this.aqm.aqmeqt != null) {
                this.aqMessageProperties.setEnqueueTime(this.aqm.aqmeqt.timestampValue());
            }

            AQAgentI var6 = new AQAgentI();
            if (this.aqm.senderAgentName != null) {
                var6.setName(this.mar.conv.CharBytesToString(this.aqm.senderAgentName, this.aqm.senderAgentNameLength, true));
            }

            if (this.aqm.senderAgentAddress != null) {
                var6.setAddress(this.mar.conv.CharBytesToString(this.aqm.senderAgentAddress, this.aqm.senderAgentAddressLength, true));
            }

            var6.setProtocol(this.aqm.senderAgentProtocol);
            this.aqMessageProperties.setSender(var6);
            this.aqMessageProperties.setPreviousQueueMessageId(this.aqm.originalMsgId);
            this.aqMessageProperties.setDeliveryMode(DeliveryMode.getDeliveryMode(this.aqm.aqmflg));
            if (this.aqm.aqmetiBytes != null) {
                String var4 = this.mar.conv.CharBytesToString(this.aqm.aqmetiBytes, this.aqm.aqmetiBytes.length, true);
                this.aqMessageProperties.setTransactionGroup(var4);
            }
        }

        int var7 = this.mar.unmarshalSWORD();
        if (var7 > 0) {
            this.mar.unmarshalUB1();
            this.aqjms.receive();
            this.jmsMessageProperties = (JMSMessagePropertiesI)JMSFactory.createJMSMessageProperties();
            this.jmsMessageProperties.setHeaderProperties(this.mar.conv.CharBytesToString(this.aqjms.aqjmshdrprop, this.aqjms.aqjmshdrprop.length));
            this.jmsMessageProperties.setUserProperties(this.mar.conv.CharBytesToString(this.aqjms.aqjmsuserprop, this.aqjms.aqjmsuserprop.length));
            this.jmsMessageProperties.setJMSMessageType(JMSMessageType.getJMSMessageType(this.aqjms.aqjmsflags));
        }

    }

    public AQMessagePropertiesI getAqMessageProperties() {
        return this.aqMessageProperties;
    }

    public JMSMessagePropertiesI getJmsMessageProperties() {
        return this.jmsMessageProperties;
    }

    public byte[] getMessageId() {
        return this.messageId;
    }
}
