//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package oracle.jdbc.pool;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.sql.SQLWarning;
import java.util.Enumeration;
import java.util.Properties;
import java.util.logging.Logger;
import javax.naming.NamingException;
import javax.naming.Reference;
import javax.naming.Referenceable;
import javax.naming.StringRefAddr;
import javax.sql.DataSource;
import oracle.jdbc.OracleConnection;
import oracle.jdbc.driver.DatabaseError;
import oracle.jdbc.driver.OracleDriver;

public class OracleDataSource implements DataSource, Serializable, Referenceable {
    static final long serialVersionUID = 3349652938965166731L;
    protected PrintWriter logWriter = null;
    protected int loginTimeout = 0;
    protected String databaseName = null;
    protected String serviceName = null;
    protected String dataSourceName = "OracleDataSource";
    protected String description = null;
    protected String networkProtocol = "tcp";
    protected int portNumber = 0;
    protected String user = null;
    protected String password = null;
    protected String serverName = null;
    protected String url = null;
    protected String driverType = null;
    protected String tnsEntry = null;
    protected int maxStatements = 0;
    protected boolean implicitCachingEnabled = false;
    protected boolean explicitCachingEnabled = false;
    protected transient OracleImplicitConnectionCache odsCache = null;
    protected transient OracleConnectionCacheManager cacheManager = null;
    protected String connCacheName = null;
    protected Properties connCacheProperties = null;
    protected Properties connectionProperties = null;
    protected boolean connCachingEnabled = false;
    protected boolean fastConnFailover = false;
    protected String onsConfigStr = null;
    public boolean isOracleDataSource = true;
    private static final boolean fastConnectionFailoverSysProperty = "true".equalsIgnoreCase(OracleDriver.getSystemPropertyFastConnectionFailover("false"));
    private boolean urlExplicit = false;
    private boolean useDefaultConnection = false;
    protected transient OracleDriver driver = new OracleDriver();
    private static final String spawnNewThreadToCancelProperty = "oracle.jdbc.spawnNewThreadToCancel";
    private static final String _Copyright_2007_Oracle_All_Rights_Reserved_ = null;
    public static final String BUILD_DATE = "Thu_Apr_04_15:09:24_PDT_2013";
    public static final boolean TRACE = false;

    public OracleDataSource() throws SQLException {
        this.processFastConnectionFailoverSysProperty();
    }

    void processFastConnectionFailoverSysProperty() {
        if (this.isOracleDataSource && fastConnectionFailoverSysProperty) {
            this.connCachingEnabled = true;
            if (this.cacheManager == null) {
                try {
                    this.cacheManager = OracleConnectionCacheManager.getConnectionCacheManagerInstance();
                } catch (SQLException var2) {
                }
            }

            this.fastConnFailover = true;
            this.setSpawnNewThreadToCancel(true);
        }

    }

    public Connection getConnection() throws SQLException {
        String var1 = null;
        String var2 = null;
        synchronized(this) {
            var1 = this.user;
            var2 = this.password;
        }

        return this.getConnection(var1, var2);
    }

    public Connection getConnection(String var1, String var2) throws SQLException {
        Connection var3 = null;
        Properties var4 = null;
        if (this.connCachingEnabled) {
            var3 = this.getConnection(var1, var2, (Properties)null);
        } else {
            synchronized(this) {
                this.makeURL();
                var4 = this.connectionProperties == null ? new Properties() : (Properties)this.connectionProperties.clone();
                if (this.url != null) {
                    var4.setProperty("connection_url", this.url);
                }

                if (var1 != null) {
                    var4.setProperty("user", var1);
                }

                if (var2 != null) {
                    var4.setProperty("password", var2);
                }

                if (this.loginTimeout != 0) {
                    var4.setProperty("LoginTimeout", "" + this.loginTimeout);
                }

                if (this.maxStatements != 0) {
                    var4.setProperty("stmt_cache_size", "" + this.maxStatements);
                }
            }

            var3 = this.getPhysicalConnection(var4);
            if (var3 == null) {
                SQLException var5 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 67);
                var5.fillInStackTrace();
                throw var5;
            }
        }

        return var3;
    }

    protected Connection getPhysicalConnection(Properties var1) throws SQLException {
        Connection var2 = null;
        Properties var3 = var1;
        String var4 = var1.getProperty("connection_url");
        String var5 = var1.getProperty("user");
        String var6 = var1.getProperty("password");
        String var7 = null;
        boolean var8 = false;
        synchronized(this) {
            if (this.connectionProperties != null) {
                var3 = (Properties)this.connectionProperties.clone();
                if (var5 != null) {
                    var3.put("user", var5);
                }

                if (var6 != null) {
                    var3.put("password", var6);
                }
            }

            if (var5 == null && this.user != null) {
                var3.put("user", this.user);
            }

            if (var6 == null && this.password != null) {
                var3.put("password", this.password);
            }

            if (var4 == null) {
                var4 = this.url;
            }

            String var10 = var1.getProperty("LoginTimeout");
            if (var10 != null) {
                var3.put("oracle.net.CONNECT_TIMEOUT", "" + Integer.parseInt(var10) * 1000);
            }

            var8 = this.useDefaultConnection;
            if (this.driver == null) {
                this.driver = new OracleDriver();
            }
        }

        if (var8) {
            var2 = this.driver.defaultConnection();
        } else {
            var2 = this.driver.connect(var4, var3);
        }

        if (var2 == null) {
            SQLException var13 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 67);
            var13.fillInStackTrace();
            throw var13;
        } else {
            var7 = var1.getProperty("stmt_cache_size");
            int var9 = 0;
            if (var7 != null) {
                ((OracleConnection)var2).setStatementCacheSize(var9 = Integer.parseInt(var7));
            }

            boolean var14 = false;
            var7 = var1.getProperty("ExplicitStatementCachingEnabled");
            if (var7 != null) {
                ((OracleConnection)var2).setExplicitCachingEnabled(var14 = var7.equals("true"));
            }

            boolean var11 = false;
            var7 = var1.getProperty("ImplicitStatementCachingEnabled");
            if (var7 != null) {
                ((OracleConnection)var2).setImplicitCachingEnabled(var11 = var7.equals("true"));
            }

            if (var9 > 0 && !var14 && !var11) {
                ((OracleConnection)var2).setImplicitCachingEnabled(true);
                ((OracleConnection)var2).setExplicitCachingEnabled(true);
            }

            return var2;
        }
    }

    /** @deprecated */
    public Connection getConnection(Properties var1) throws SQLException {
        String var2 = null;
        String var3 = null;
        synchronized(this) {
            if (!this.connCachingEnabled) {
                SQLException var5 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 137);
                var5.fillInStackTrace();
                throw var5;
            }

            var2 = this.user;
            var3 = this.password;
        }

        Connection var4 = this.getConnection(var2, var3, var1);
        return var4;
    }

    /** @deprecated */
    public Connection getConnection(String var1, String var2, Properties var3) throws SQLException {
        if (!this.connCachingEnabled) {
            SQLException var5 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 137);
            var5.fillInStackTrace();
            throw var5;
        } else {
            if (this.odsCache == null) {
                this.cacheInitialize();
            }

            Connection var4 = this.odsCache.getConnection(var1, var2, var3);
            return var4;
        }
    }

    private synchronized void cacheInitialize() throws SQLException {
        if (this.odsCache == null) {
            if (this.connCacheName != null) {
                this.cacheManager.createCache(this.connCacheName, this, this.connCacheProperties);
            } else {
                this.connCacheName = this.cacheManager.createCache(this, this.connCacheProperties);
            }
        }

    }

    /** @deprecated */
    public synchronized void close() throws SQLException {
        if (this.connCachingEnabled && this.odsCache != null) {
            this.cacheManager.removeCache(this.odsCache.cacheName, 0L);
            this.odsCache = null;
        }

    }

    /** @deprecated */
    public synchronized void setConnectionCachingEnabled(boolean var1) throws SQLException {
        if (this.isOracleDataSource) {
            if (var1) {
                this.connCachingEnabled = true;
                if (this.cacheManager == null) {
                    this.cacheManager = OracleConnectionCacheManager.getConnectionCacheManagerInstance();
                }
            } else if (this.odsCache == null) {
                this.connCachingEnabled = false;
                this.fastConnFailover = false;
                this.setSpawnNewThreadToCancel(false);
                this.connCacheName = null;
                this.connCacheProperties = null;
            }

        } else {
            SQLException var2 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 137);
            var2.fillInStackTrace();
            throw var2;
        }
    }

    public boolean getConnectionCachingEnabled() throws SQLException {
        return this.connCachingEnabled;
    }

    public synchronized void setConnectionCacheName(String var1) throws SQLException {
        if (var1 == null) {
            SQLException var2 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 138);
            var2.fillInStackTrace();
            throw var2;
        } else {
            this.connCacheName = var1;
        }
    }

    public String getConnectionCacheName() throws SQLException {
        return this.connCachingEnabled && this.odsCache != null ? this.odsCache.cacheName : this.connCacheName;
    }

    /** @deprecated */
    public synchronized void setConnectionCacheProperties(Properties var1) throws SQLException {
        this.connCacheProperties = var1;
    }

    public Properties getConnectionCacheProperties() throws SQLException {
        return this.connCachingEnabled && this.odsCache != null ? this.odsCache.getConnectionCacheProperties() : this.connCacheProperties;
    }

    public synchronized void setFastConnectionFailoverEnabled(boolean var1) throws SQLException {
        if (!this.fastConnFailover) {
            this.fastConnFailover = var1;
            this.setSpawnNewThreadToCancel(var1);
        } else if (!var1) {
            SQLException var2 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 255);
            var2.fillInStackTrace();
            throw var2;
        }

    }

    public boolean getFastConnectionFailoverEnabled() throws SQLException {
        return this.fastConnFailover;
    }

    /** @deprecated */
    public String getONSConfiguration() throws SQLException {
        return this.onsConfigStr;
    }

    /** @deprecated */
    public synchronized void setONSConfiguration(String var1) throws SQLException {
        this.onsConfigStr = var1;
    }

    public synchronized int getLoginTimeout() {
        return this.loginTimeout;
    }

    public synchronized void setLoginTimeout(int var1) {
        this.loginTimeout = var1;
    }

    public synchronized void setLogWriter(PrintWriter var1) {
        this.logWriter = var1;
    }

    public synchronized PrintWriter getLogWriter() {
        return this.logWriter;
    }

    public synchronized void setTNSEntryName(String var1) {
        this.tnsEntry = var1;
    }

    public synchronized String getTNSEntryName() {
        return this.tnsEntry;
    }

    public synchronized void setDataSourceName(String var1) {
        this.dataSourceName = var1;
    }

    public synchronized String getDataSourceName() {
        return this.dataSourceName;
    }

    public synchronized String getDatabaseName() {
        return this.databaseName;
    }

    public synchronized void setDatabaseName(String var1) {
        this.databaseName = var1;
    }

    public synchronized void setServiceName(String var1) {
        this.serviceName = var1;
    }

    public synchronized String getServiceName() {
        return this.serviceName;
    }

    public synchronized void setServerName(String var1) {
        this.serverName = var1;
    }

    public synchronized String getServerName() {
        return this.serverName;
    }

    public synchronized void setURL(String var1) {
        this.url = var1;
        if (this.url != null) {
            this.urlExplicit = true;
        }

        if (this.connCachingEnabled && this.odsCache != null && this.odsCache.connectionPoolDS != null) {
            this.odsCache.connectionPoolDS.url = var1;
        }

    }

    public synchronized String getURL() throws SQLException {
        if (!this.urlExplicit) {
            this.makeURL();
        }

        return this.url;
    }

    public synchronized void setUser(String var1) {
        this.user = var1;
    }

    public String getUser() {
        return this.user;
    }

    public synchronized void setPassword(String var1) {
        this.password = var1;
    }

    protected String getPassword() {
        return this.password;
    }

    public synchronized String getDescription() {
        return this.description;
    }

    public synchronized void setDescription(String var1) {
        this.description = var1;
    }

    public synchronized String getDriverType() {
        return this.driverType;
    }

    public synchronized void setDriverType(String var1) {
        this.driverType = var1;
    }

    public synchronized String getNetworkProtocol() {
        return this.networkProtocol;
    }

    public synchronized void setNetworkProtocol(String var1) {
        this.networkProtocol = var1;
    }

    public synchronized void setPortNumber(int var1) {
        this.portNumber = var1;
    }

    public synchronized int getPortNumber() {
        return this.portNumber;
    }

    public synchronized Reference getReference() throws NamingException {
        Reference var1 = new Reference(this.getClass().getName(), "oracle.jdbc.pool.OracleDataSourceFactory", (String)null);
        this.addRefProperties(var1);
        return var1;
    }

    protected void addRefProperties(Reference var1) {
        if (this.url != null) {
            var1.add(new StringRefAddr("url", this.url));
        }

        if (this.user != null) {
            var1.add(new StringRefAddr("userName", this.user));
        }

        if (this.password != null) {
            var1.add(new StringRefAddr("passWord", this.password));
        }

        if (this.description != null) {
            var1.add(new StringRefAddr("description", this.description));
        }

        if (this.driverType != null) {
            var1.add(new StringRefAddr("driverType", this.driverType));
        }

        if (this.serverName != null) {
            var1.add(new StringRefAddr("serverName", this.serverName));
        }

        if (this.databaseName != null) {
            var1.add(new StringRefAddr("databaseName", this.databaseName));
        }

        if (this.serviceName != null) {
            var1.add(new StringRefAddr("serviceName", this.serviceName));
        }

        if (this.networkProtocol != null) {
            var1.add(new StringRefAddr("networkProtocol", this.networkProtocol));
        }

        if (this.portNumber != 0) {
            var1.add(new StringRefAddr("portNumber", Integer.toString(this.portNumber)));
        }

        if (this.tnsEntry != null) {
            var1.add(new StringRefAddr("tnsentryname", this.tnsEntry));
        }

        if (this.maxStatements != 0) {
            var1.add(new StringRefAddr("maxStatements", Integer.toString(this.maxStatements)));
        }

        if (this.implicitCachingEnabled) {
            var1.add(new StringRefAddr("implicitCachingEnabled", "true"));
        }

        if (this.explicitCachingEnabled) {
            var1.add(new StringRefAddr("explicitCachingEnabled", "true"));
        }

        if (this.connCachingEnabled) {
            var1.add(new StringRefAddr("connectionCachingEnabled", "true"));
        }

        if (this.connCacheName != null) {
            var1.add(new StringRefAddr("connectionCacheName", this.connCacheName));
        }

        if (this.connCacheProperties != null) {
            var1.add(new StringRefAddr("connectionCacheProperties", this.connCacheProperties.toString()));
        }

        if (this.fastConnFailover) {
            var1.add(new StringRefAddr("fastConnectionFailoverEnabled", "true"));
        }

        if (this.onsConfigStr != null) {
            var1.add(new StringRefAddr("onsConfigStr", this.onsConfigStr));
        }

    }

    void makeURL() throws SQLException {
        if (!this.urlExplicit) {
            SQLException var1;
            if (this.driverType == null || !this.driverType.equals("oci8") && !this.driverType.equals("oci") && !this.driverType.equals("thin") && !this.driverType.equals("kprb")) {
                var1 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 67, "OracleDataSource.makeURL");
                var1.fillInStackTrace();
                throw var1;
            } else if (this.driverType.equals("kprb")) {
                this.useDefaultConnection = true;
                this.url = "jdbc:oracle:kprb:@";
            } else if ((this.driverType.equals("oci8") || this.driverType.equals("oci")) && this.networkProtocol != null && this.networkProtocol.equals("ipc")) {
                this.url = "jdbc:oracle:oci:@";
            } else if (this.tnsEntry != null) {
                this.url = "jdbc:oracle:" + this.driverType + ":@" + this.tnsEntry;
            } else {
                if (this.serviceName != null) {
                    this.url = "jdbc:oracle:" + this.driverType + ":@(DESCRIPTION=(ADDRESS=(PROTOCOL=" + this.networkProtocol + ")(PORT=" + this.portNumber + ")(HOST=" + this.serverName + "))(CONNECT_DATA=(SERVICE_NAME=" + this.serviceName + ")))";
                } else {
                    this.url = "jdbc:oracle:" + this.driverType + ":@(DESCRIPTION=(ADDRESS=(PROTOCOL=" + this.networkProtocol + ")(PORT=" + this.portNumber + ")(HOST=" + this.serverName + "))(CONNECT_DATA=(SID=" + this.databaseName + ")))";
                    DatabaseError.addSqlWarning((SQLWarning)null, new SQLWarning("URL with SID jdbc:subprotocol:@host:port:sid will be deprecated in 10i\nPlease use URL with SERVICE_NAME as jdbc:subprotocol:@//host:port/service_name"));
                    if (this.fastConnFailover) {
                        var1 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 67, "OracleDataSource.makeURL");
                        var1.fillInStackTrace();
                        throw var1;
                    }
                }

            }
        }
    }

    protected void trace(String var1) {
        if (this.logWriter != null) {
        }

    }

    protected void copy(OracleDataSource var1) throws SQLException {
        var1.setUser(this.user);
        var1.setPassword(this.password);
        var1.setTNSEntryName(this.tnsEntry);
        this.makeURL();
        var1.setURL(this.url);
        if (this.loginTimeout > 0) {
            var1.setLoginTimeout(this.loginTimeout);
        }

        var1.connectionProperties = this.connectionProperties;
    }

    /** @deprecated */
    public void setMaxStatements(int var1) throws SQLException {
        this.maxStatements = var1;
    }

    public int getMaxStatements() throws SQLException {
        return this.maxStatements;
    }

    public void setImplicitCachingEnabled(boolean var1) throws SQLException {
        this.implicitCachingEnabled = var1;
    }

    public boolean getImplicitCachingEnabled() throws SQLException {
        return this.implicitCachingEnabled;
    }

    public void setExplicitCachingEnabled(boolean var1) throws SQLException {
        this.explicitCachingEnabled = var1;
    }

    public boolean getExplicitCachingEnabled() throws SQLException {
        return this.explicitCachingEnabled;
    }

    public void setConnectionProperties(Properties var1) throws SQLException {
        if (var1 == null) {
            this.connectionProperties = var1;
        } else {
            this.connectionProperties = (Properties)var1.clone();
        }

        this.setSpawnNewThreadToCancel(this.fastConnFailover);
    }

    public Properties getConnectionProperties() throws SQLException {
        return filterConnectionProperties(this.connectionProperties);
    }

    public static final Properties filterConnectionProperties(Properties var0) {
        Properties var1 = null;
        if (var0 != null) {
            var1 = (Properties)var0.clone();
            Enumeration var2 = var1.propertyNames();
            Object var3 = null;

            while(var2.hasMoreElements()) {
                String var4 = (String)var2.nextElement();
                if (var4 != null && var4.matches(".*[P,p][A,a][S,s][S,s][W,w][O,o][R,r][D,d].*")) {
                    var1.remove(var4);
                }
            }

            var0.remove("oracle.jdbc.spawnNewThreadToCancel");
        }

        return var1;
    }

    private void setSpawnNewThreadToCancel(boolean var1) {
        if (var1) {
            if (this.connectionProperties == null) {
                this.connectionProperties = new Properties();
            }

            this.connectionProperties.setProperty("oracle.jdbc.spawnNewThreadToCancel", "true");
        } else if (this.connectionProperties != null) {
            this.connectionProperties.remove("oracle.jdbc.spawnNewThreadToCancel");
        }

    }

    private void writeObject(ObjectOutputStream var1) throws IOException {
        var1.defaultWriteObject();
    }

    private void readObject(ObjectInputStream var1) throws IOException, ClassNotFoundException, SQLException {
        var1.defaultReadObject();
        if (this.connCachingEnabled) {
            this.setConnectionCachingEnabled(this.connCachingEnabled);
        }

    }

    public boolean isWrapperFor(Class<?> var1) throws SQLException {
        if (var1.isInterface()) {
            return var1.isInstance(this);
        } else {
            SQLException var2 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 177);
            var2.fillInStackTrace();
            throw var2;
        }
    }

    public <T> T unwrap(Class<T> var1) throws SQLException {
        if (var1.isInterface() && var1.isInstance(this)) {
            return (T) this;
        } else {
            SQLException var2 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 177);
            var2.fillInStackTrace();
            throw var2;
        }
    }

    public Logger getParentLogger() throws SQLFeatureNotSupportedException {
        return Logger.getLogger("oracle");
    }

    protected oracle.jdbc.internal.OracleConnection getConnectionDuringExceptionHandling() {
        return null;
    }
}
