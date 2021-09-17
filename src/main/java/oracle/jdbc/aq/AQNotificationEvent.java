//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package oracle.jdbc.aq;

import java.sql.SQLException;
import java.util.EventObject;

public abstract class AQNotificationEvent extends EventObject {
    private static final String _Copyright_2007_Oracle_All_Rights_Reserved_ = null;
    public static final String BUILD_DATE = "Thu_Apr_04_15:09:24_PDT_2013";
    public static final boolean TRACE = false;

    protected AQNotificationEvent(Object var1) {
        super(var1);
    }

    public abstract AQMessageProperties getMessageProperties() throws SQLException;

    public abstract String getRegistration() throws SQLException;

    public abstract byte[] getPayload() throws SQLException;

    public abstract String getQueueName() throws SQLException;

    public abstract byte[] getMessageId() throws SQLException;

    public abstract String getConsumerName() throws SQLException;

    public abstract String getConnectionInformation();

    public abstract AQNotificationEvent.EventType getEventType();

    public abstract AQNotificationEvent.AdditionalEventType getAdditionalEventType();

    public abstract String toString();

    public static enum AdditionalEventType {
        NONE(0),
        TIMEOUT(1),
        GROUPING(2);

        private final int code;

        private AdditionalEventType(int var3) {
            this.code = var3;
        }

        public final int getCode() {
            return this.code;
        }

        public static final AQNotificationEvent.AdditionalEventType getEventType(int var0) {
            if (var0 == TIMEOUT.getCode()) {
                return TIMEOUT;
            } else {
                return var0 == GROUPING.getCode() ? GROUPING : NONE;
            }
        }
    }

    public static enum EventType {
        REGULAR(0),
        DEREG(1);

        private final int code;

        private EventType(int var3) {
            this.code = var3;
        }

        public final int getCode() {
            return this.code;
        }
    }
}
