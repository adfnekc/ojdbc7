//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package oracle.jdbc.driver;

import java.sql.SQLException;
import java.util.Properties;
import java.util.concurrent.Executor;
import oracle.jdbc.aq.AQNotificationListener;
import oracle.jdbc.aq.AQNotificationRegistration;

class NTFAQRegistration extends NTFRegistration implements AQNotificationRegistration {
    private final String name;
    private static final String _Copyright_2007_Oracle_All_Rights_Reserved_ = null;
    public static final String BUILD_DATE = "Thu_Apr_04_15:09:24_PDT_2013";
    public static final boolean TRACE = false;

    NTFAQRegistration(int var1, boolean var2, String var3, String var4, String var5, int var6, Properties var7, String var8, short var9) {
        super(var1, 1, var2, var3, var5, var6, var7, var4, var9);
        this.name = var8;
    }

    public void addListener(AQNotificationListener var1, Executor var2) throws SQLException {
        NTFEventListener var3 = new NTFEventListener(var1);
        var3.setExecutor(var2);
        this.addListener(var3);
    }

    public void addListener(AQNotificationListener var1) throws SQLException {
        NTFEventListener var2 = new NTFEventListener(var1);
        this.addListener(var2);
    }

    public void removeListener(AQNotificationListener var1) throws SQLException {
        super.removeListener(var1);
    }

    public String getQueueName() {
        return this.name;
    }
}
