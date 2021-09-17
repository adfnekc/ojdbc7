//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package oracle.jdbc.aq;

import java.sql.SQLException;
import oracle.jdbc.driver.InternalFactory;

public abstract class AQFactory {
    private static final String _Copyright_2007_Oracle_All_Rights_Reserved_ = null;
    public static final String BUILD_DATE = "Thu_Apr_04_15:09:24_PDT_2013";
    public static final boolean TRACE = false;

    public AQFactory() {
    }

    public static AQMessage createAQMessage(AQMessageProperties var0) throws SQLException {
        return InternalFactory.createAQMessage(var0);
    }

    public static AQMessageProperties createAQMessageProperties() throws SQLException {
        return InternalFactory.createAQMessageProperties();
    }

    public static AQAgent createAQAgent() throws SQLException {
        return InternalFactory.createAQAgent();
    }
}
