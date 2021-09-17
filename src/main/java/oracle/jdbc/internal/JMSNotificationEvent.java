//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package oracle.jdbc.internal;

import java.sql.SQLException;
import java.util.EventObject;
import oracle.jdbc.aq.AQMessageProperties;

public abstract class JMSNotificationEvent extends EventObject {
    private static final String _Copyright_2007_Oracle_All_Rights_Reserved_ = null;
    public static final String BUILD_DATE = "Thu_Apr_04_15:09:24_PDT_2013";
    public static final boolean TRACE = false;

    protected JMSNotificationEvent(Object var1) {
        super(var1);
    }

    public abstract JMSMessageProperties getJMSMessageProperties() throws SQLException;

    public abstract AQMessageProperties getMessageProperties() throws SQLException;

    public abstract String getRegistrationName() throws SQLException;

    public abstract byte[] getPayload() throws SQLException;

    public abstract String getQueueName() throws SQLException;

    public abstract byte[] getMessageId() throws SQLException;

    public abstract String getConsumerName() throws SQLException;
}
