//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package oracle.jdbc.driver;

import oracle.jdbc.aq.AQMessageProperties;
import oracle.jdbc.internal.JMSMessage;
import oracle.jdbc.internal.JMSMessageProperties;
import oracle.sql.TypeDescriptor;

class JMSMessageI implements JMSMessage {
    private byte[] payload;
    private byte[] messageId = null;
    private JMSMessageProperties jmsMessageProperties = null;
    private AQMessageProperties aqMessageProperties = null;
    private byte[] toid;
    private String typeName;

    JMSMessageI(JMSMessageProperties var1) {
        this.toid = TypeDescriptor.RAWTOID;
        this.jmsMessageProperties = var1;
    }

    public byte[] getMessageId() {
        return this.messageId;
    }

    public void setMessageId(byte[] var1) {
        this.messageId = var1;
    }

    public byte[] getPayload() {
        return this.payload;
    }

    public void setPayload(byte[] var1) {
        this.payload = var1;
    }

    public JMSMessageProperties getJMSMessageProperties() {
        return this.jmsMessageProperties;
    }

    public void setJMSMessageProperties(JMSMessageProperties var1) {
        this.jmsMessageProperties = var1;
    }

    public void setTypeName(String var1) {
        this.typeName = var1;
    }

    public String getTypeName() {
        return this.typeName;
    }

    public byte[] getToid() {
        return this.toid;
    }

    public AQMessageProperties getAQMessageProperties() {
        return this.aqMessageProperties;
    }

    public void setAQMessageProperties(AQMessageProperties var1) {
        this.aqMessageProperties = var1;
    }
}
