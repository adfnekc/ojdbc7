//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package oracle.jdbc.driver;

import java.sql.SQLException;
import java.util.EventListener;
import java.util.Properties;
import java.util.concurrent.Executor;
import oracle.jdbc.NotificationRegistration.RegistrationState;
import oracle.jdbc.aq.AQNotificationListener;
import oracle.jdbc.aq.AQNotificationEvent.EventType;
import oracle.jdbc.dcn.DatabaseChangeListener;
import oracle.jdbc.internal.JMSNotificationListener;
import oracle.jdbc.internal.OracleConnection;

abstract class NTFRegistration {
    private final boolean jdbcGetsNotification;
    private final String clientHost;
    private final int clientTCPPort;
    private final Properties options;
    private final boolean isPurgeOnNTF;
    private final String username;
    private final int namespace;
    private final int jdbcRegId;
    private final String dbName;
    private final short databaseVersion;
    private RegistrationState state;
    private NTFEventListener[] listeners = new NTFEventListener[0];
    private static final String _Copyright_2007_Oracle_All_Rights_Reserved_ = null;
    public static final String BUILD_DATE = "Thu_Apr_04_15:09:24_PDT_2013";
    public static final boolean TRACE = false;

    NTFRegistration(int var1, int var2, boolean var3, String var4, String var5, int var6, Properties var7, String var8, short var9) {
        this.namespace = var2;
        this.clientHost = var5;
        this.clientTCPPort = var6;
        this.options = var7;
        this.jdbcRegId = var1;
        this.username = var8;
        this.jdbcGetsNotification = var3;
        this.dbName = var4;
        this.state = RegistrationState.ACTIVE;
        if (this.options.getProperty("NTF_QOS_PURGE_ON_NTFN", "false").compareToIgnoreCase("true") == 0) {
            this.isPurgeOnNTF = true;
        } else {
            this.isPurgeOnNTF = false;
        }

        this.databaseVersion = var9;
    }

    short getDatabaseVersion() {
        return this.databaseVersion;
    }

    synchronized void addListener(NTFEventListener var1) throws SQLException {
        SQLException var5;
        if (this.state == RegistrationState.CLOSED) {
            var5 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 251);
            var5.fillInStackTrace();
            throw var5;
        } else if (!this.jdbcGetsNotification) {
            var5 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 247);
            var5.fillInStackTrace();
            throw var5;
        } else {
            int var2 = this.listeners.length;

            for(int var3 = 0; var3 < var2; ++var3) {
                if (this.listeners[var3].getListener() == var1.getListener()) {
                    SQLException var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 248);
                    var4.fillInStackTrace();
                    throw var4;
                }
            }

            NTFEventListener[] var6 = new NTFEventListener[var2 + 1];
            System.arraycopy(this.listeners, 0, var6, 0, var2);
            var6[var2] = var1;
            this.listeners = var6;
        }
    }

    synchronized void removeListener(EventListener var1) throws SQLException {
        boolean var2 = false;
        int var3 = this.listeners.length;

        int var6;
        for(var6 = 0; var6 < var3 && this.listeners[var6].getListener() != var1; ++var6) {
        }

        if (var6 == var3) {
            SQLException var7 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 249);
            var7.fillInStackTrace();
            throw var7;
        } else {
            NTFEventListener[] var4 = new NTFEventListener[var3 - 1];
            int var5 = 0;

            for(var6 = 0; var6 < var3; ++var6) {
                if (this.listeners[var6].getListener() != var1) {
                    var4[var5++] = this.listeners[var6];
                }
            }

            this.listeners = var4;
        }
    }

    void notify(final NTFDCNEvent var1) {
        long var2 = 0L;
        NTFEventListener[] var4 = this.listeners;
        int var5 = var4.length;

        for(int var6 = 0; var6 < var5; ++var6) {
            Executor var7 = var4[var6].getExecutor();
            if (var7 != null) {
                final DatabaseChangeListener var8 = var4[var6].getDCNListener();
                var7.execute(new Runnable() {
                    public void run() {
                        var8.onDatabaseChangeNotification(var1);
                    }
                });
            } else {
                var4[var6].getDCNListener().onDatabaseChangeNotification(var1);
            }
        }

        if (var1.isDeregistrationEvent() || this.isPurgeOnNTF) {
            PhysicalConnection.ntfManager.removeRegistration(this);
            PhysicalConnection.ntfManager.freeJdbcRegId(this.getJdbcRegId());
            PhysicalConnection.ntfManager.cleanListenersT4C(this.getClientTCPPort());
            this.state = RegistrationState.CLOSED;
        }

    }

    void notify(final NTFAQEvent var1) {
        long var2 = 0L;
        NTFEventListener[] var4 = this.listeners;
        int var5 = var4.length;

        for(int var6 = 0; var6 < var5; ++var6) {
            Executor var7 = var4[var6].getExecutor();
            if (var7 != null) {
                final AQNotificationListener var8 = var4[var6].getAQListener();
                var7.execute(new Runnable() {
                    public void run() {
                        var8.onAQNotification(var1);
                    }
                });
            } else {
                var4[var6].getAQListener().onAQNotification(var1);
            }
        }

        if (var1.getEventType() == EventType.DEREG || this.isPurgeOnNTF) {
            PhysicalConnection.ntfManager.removeRegistration(this);
            PhysicalConnection.ntfManager.freeJdbcRegId(this.getJdbcRegId());
            PhysicalConnection.ntfManager.cleanListenersT4C(this.getClientTCPPort());
            this.state = RegistrationState.CLOSED;
        }

    }

    void notify(final NTFJMSEvent var1) {
        long var2 = 0L;
        NTFEventListener[] var4 = this.listeners;
        int var5 = var4.length;

        for(int var6 = 0; var6 < var5; ++var6) {
            Executor var7 = var4[var6].getExecutor();
            if (var7 != null) {
                final JMSNotificationListener var8 = var4[var6].getJMSListener();
                var7.execute(new Runnable() {
                    public void run() {
                        var8.onJMSNotification(var1);
                    }
                });
            } else {
                var4[var6].getJMSListener().onJMSNotification(var1);
            }
        }

    }

    public Properties getRegistrationOptions() {
        return this.options;
    }

    int getJdbcRegId() {
        return this.jdbcRegId;
    }

    public String getUserName() {
        return this.username;
    }

    String getClientHost() {
        return this.clientHost;
    }

    int getClientTCPPort() {
        return this.clientTCPPort;
    }

    public String getDatabaseName() {
        return this.dbName;
    }

    public RegistrationState getState() {
        return this.state;
    }

    protected void setState(RegistrationState var1) {
        this.state = var1;
    }

    int getNamespace() {
        return this.namespace;
    }

    protected OracleConnection getConnectionDuringExceptionHandling() {
        return null;
    }
}
