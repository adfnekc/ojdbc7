//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package oracle.jdbc.internal;

import java.sql.SQLException;
import java.util.concurrent.Executor;
import oracle.jdbc.NotificationRegistration;

public interface JMSNotificationRegistration extends NotificationRegistration {
    void addListener(JMSNotificationListener var1) throws SQLException;

    void addListener(JMSNotificationListener var1, Executor var2) throws SQLException;

    void removeListener(JMSNotificationListener var1) throws SQLException;

    String getQueueName();

    public static enum Directive {
        COMMIT((short)1),
        ROLLBACK((short)2);

        private final short mode;

        private Directive(short var3) {
            this.mode = var3;
        }

        public final short getCode() {
            return this.mode;
        }
    }
}
