//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package oracle.jdbc.internal;

import oracle.jdbc.aq.AQMessageProperties;

public interface JMSMessage {
    byte[] getMessageId();

    void setMessageId(byte[] var1);

    byte[] getPayload();

    void setPayload(byte[] var1);

    void setJMSMessageProperties(JMSMessageProperties var1);

    JMSMessageProperties getJMSMessageProperties();

    AQMessageProperties getAQMessageProperties();

    void setAQMessageProperties(AQMessageProperties var1);

    byte[] getToid();
}
