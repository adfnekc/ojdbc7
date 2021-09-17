//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package oracle.jdbc.driver;

import oracle.jdbc.internal.JMSMessageProperties;
import oracle.jdbc.internal.JMSMessageProperties.JMSMessageType;

class JMSMessagePropertiesI implements JMSMessageProperties {
    private String headerProperties = "0";
    private String userProperties = "0";
    private JMSMessageType jmsMessageType;
    private static final String _Copyright_2007_Oracle_All_Rights_Reserved_ = null;
    public static final String BUILD_DATE = "Thu_Apr_04_15:09:24_PDT_2013";
    public static final boolean TRACE = false;

    JMSMessagePropertiesI() {
        this.jmsMessageType = JMSMessageType.TEXT_MESSAGE;
    }

    public String getHeaderProperties() {
        return this.headerProperties;
    }

    public void setHeaderProperties(String var1) {
        this.headerProperties = var1;
    }

    public String getUserProperties() {
        return this.userProperties;
    }

    public void setUserProperties(String var1) {
        this.userProperties = var1;
    }

    public JMSMessageType getJMSMessageType() {
        return this.jmsMessageType;
    }

    public void setJMSMessageType(JMSMessageType var1) {
        this.jmsMessageType = var1;
    }
}
