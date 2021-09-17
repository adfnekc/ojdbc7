//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package oracle.jdbc.dcn;

import java.sql.SQLException;
import java.util.concurrent.Executor;
import oracle.jdbc.NotificationRegistration;

public interface DatabaseChangeRegistration extends NotificationRegistration {
    /** @deprecated */
    int getRegistrationId();

    long getRegId();

    String[] getTables();

    void addListener(DatabaseChangeListener var1) throws SQLException;

    void addListener(DatabaseChangeListener var1, Executor var2) throws SQLException;

    void removeListener(DatabaseChangeListener var1) throws SQLException;
}
