//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package oracle.jdbc.aq;

import java.sql.SQLException;
import java.util.concurrent.Executor;
import oracle.jdbc.NotificationRegistration;

public interface AQNotificationRegistration extends NotificationRegistration {
    void addListener(AQNotificationListener var1) throws SQLException;

    void addListener(AQNotificationListener var1, Executor var2) throws SQLException;

    void removeListener(AQNotificationListener var1) throws SQLException;

    String getQueueName();
}
