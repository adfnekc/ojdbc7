//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package oracle.jdbc;

import java.util.Properties;

public interface NotificationRegistration {
    Properties getRegistrationOptions();

    String getDatabaseName();

    String getUserName();

    NotificationRegistration.RegistrationState getState();

    public static enum RegistrationState {
        ACTIVE,
        CLOSED;

        private RegistrationState() {
        }
    }
}
