//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package oracle.jdbc.internal;

import java.sql.SQLException;
import oracle.jdbc.driver.InternalFactory;

public abstract class JMSFactory {
    public JMSFactory() {
    }

    public static JMSMessage createJMSMessage(JMSMessageProperties var0) throws SQLException {
        return InternalFactory.createJMSMessage(var0);
    }

    public static JMSMessageProperties createJMSMessageProperties() throws SQLException {
        return InternalFactory.createJMSMessageProperties();
    }
}
