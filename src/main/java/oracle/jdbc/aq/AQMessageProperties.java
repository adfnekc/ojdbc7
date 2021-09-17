//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package oracle.jdbc.aq;

import java.sql.SQLException;
import java.sql.Timestamp;

public interface AQMessageProperties {
    int MESSAGE_NO_DELAY = 0;
    int MESSAGE_NO_EXPIRATION = -1;

    int getDequeueAttemptsCount();

    void setCorrelation(String var1) throws SQLException;

    String getCorrelation();

    void setDelay(int var1) throws SQLException;

    int getDelay();

    Timestamp getEnqueueTime();

    void setExceptionQueue(String var1) throws SQLException;

    String getExceptionQueue();

    void setExpiration(int var1) throws SQLException;

    int getExpiration();

    AQMessageProperties.MessageState getState();

    void setPriority(int var1) throws SQLException;

    int getPriority();

    void setRecipientList(AQAgent[] var1) throws SQLException;

    AQAgent[] getRecipientList();

    void setSender(AQAgent var1) throws SQLException;

    AQAgent getSender();

    String getTransactionGroup();

    byte[] getPreviousQueueMessageId();

    AQMessageProperties.DeliveryMode getDeliveryMode();

    String toString();

    public static enum DeliveryMode {
        PERSISTENT(1),
        BUFFERED(2);

        private final int code;

        private DeliveryMode(int var3) {
            this.code = var3;
        }

        public final int getCode() {
            return this.code;
        }

        public static final AQMessageProperties.DeliveryMode getDeliveryMode(int var0) {
            return var0 == BUFFERED.getCode() ? BUFFERED : PERSISTENT;
        }
    }

    public static enum MessageState {
        WAITING(1),
        READY(0),
        PROCESSED(2),
        EXPIRED(3);

        private final int code;

        private MessageState(int var3) {
            this.code = var3;
        }

        public final int getCode() {
            return this.code;
        }

        public static final AQMessageProperties.MessageState getMessageState(int var0) {
            if (var0 == WAITING.getCode()) {
                return WAITING;
            } else if (var0 == READY.getCode()) {
                return READY;
            } else {
                return var0 == PROCESSED.getCode() ? PROCESSED : EXPIRED;
            }
        }
    }
}
