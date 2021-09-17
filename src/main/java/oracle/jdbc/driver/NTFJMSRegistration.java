//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package oracle.jdbc.driver;

import java.sql.SQLException;
import java.util.Properties;
import java.util.concurrent.Executor;
import oracle.jdbc.internal.JMSNotificationListener;
import oracle.jdbc.internal.JMSNotificationRegistration;

class NTFJMSRegistration extends NTFRegistration implements JMSNotificationRegistration {
    private final String name;
    private final String clientId;
    private long jmsRegistrationId;
    private int qosFlag;
    private static final String _Copyright_2007_Oracle_All_Rights_Reserved_ = null;
    public static final String BUILD_DATE = "Thu_Apr_04_15:09:24_PDT_2013";
    public static final boolean TRACE = false;

    NTFJMSRegistration(long var1, boolean var3, String var4, String var5, Properties var6, String var7, short var8, String var9) {
        super((int)var1, 1, var3, var4, (String)null, 0, var6, var5, var8);
        this.name = var7;
        this.clientId = var9;
    }

    public void addListener(JMSNotificationListener var1, Executor var2) throws SQLException {
        NTFEventListener var3 = new NTFEventListener(var1);
        var3.setExecutor(var2);
        this.addListener(var3);
    }

    public void addListener(JMSNotificationListener var1) throws SQLException {
        NTFEventListener var2 = new NTFEventListener(var1);
        this.addListener(var2);
    }

    public void removeListener(JMSNotificationListener var1) throws SQLException {
        super.removeListener(var1);
    }

    public String getQueueName() {
        return this.name;
    }

    public String getClientId() {
        return this.clientId;
    }

    long getJMSRegistrationId() {
        return this.jmsRegistrationId;
    }

    void setJMSRegistrationId(long var1) {
        this.jmsRegistrationId = var1;
    }

    public int getQOSFlag() {
        return this.qosFlag;
    }

    public void setQOSFlag(int var1) {
        this.qosFlag = var1;
    }
}
