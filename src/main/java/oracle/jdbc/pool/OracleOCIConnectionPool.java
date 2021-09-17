//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package oracle.jdbc.pool;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Properties;
import javax.naming.NamingException;
import javax.naming.Reference;
import javax.naming.StringRefAddr;
import oracle.jdbc.driver.DatabaseError;
import oracle.jdbc.driver.OracleDriver;
import oracle.jdbc.internal.OracleConnection;
import oracle.jdbc.oci.OracleOCIConnection;

public class OracleOCIConnectionPool extends OracleDataSource {
    public OracleOCIConnection m_connection_pool;
    public static final String IS_CONNECTION_POOLING = "is_connection_pooling";
    private int m_conn_min_limit;
    private int m_conn_max_limit;
    private int m_conn_increment;
    private int m_conn_active_size;
    private int m_conn_pool_size;
    private int m_conn_timeout;
    private String m_conn_nowait;
    private int m_is_transactions_distributed;
    public static final String CONNPOOL_OBJECT = "connpool_object";
    public static final String CONNPOOL_LOGON_MODE = "connection_pool";
    public static final String CONNECTION_POOL = "connection_pool";
    public static final String CONNPOOL_CONNECTION = "connpool_connection";
    public static final String CONNPOOL_PROXY_CONNECTION = "connpool_proxy_connection";
    public static final String CONNPOOL_ALIASED_CONNECTION = "connpool_alias_connection";
    public static final String PROXY_USER_NAME = "proxy_user_name";
    public static final String PROXY_DISTINGUISHED_NAME = "proxy_distinguished_name";
    public static final String PROXY_CERTIFICATE = "proxy_certificate";
    public static final String PROXY_ROLES = "proxy_roles";
    public static final String PROXY_NUM_ROLES = "proxy_num_roles";
    public static final String PROXY_PASSWORD = "proxy_password";
    public static final String PROXYTYPE = "proxytype";
    public static final String PROXYTYPE_USER_NAME = "proxytype_user_name";
    public static final String PROXYTYPE_DISTINGUISHED_NAME = "proxytype_distinguished_name";
    public static final String PROXYTYPE_CERTIFICATE = "proxytype_certificate";
    public static final String CONNECTION_ID = "connection_id";
    public static final String CONNPOOL_MIN_LIMIT = "connpool_min_limit";
    public static final String CONNPOOL_MAX_LIMIT = "connpool_max_limit";
    public static final String CONNPOOL_INCREMENT = "connpool_increment";
    public static final String CONNPOOL_ACTIVE_SIZE = "connpool_active_size";
    public static final String CONNPOOL_POOL_SIZE = "connpool_pool_size";
    public static final String CONNPOOL_TIMEOUT = "connpool_timeout";
    public static final String CONNPOOL_NOWAIT = "connpool_nowait";
    public static final String CONNPOOL_IS_POOLCREATED = "connpool_is_poolcreated";
    public static final String TRANSACTIONS_DISTRIBUTED = "transactions_distributed";
    private Hashtable m_lconnections;
    private OracleOCIConnectionPool.Lifecycle lifecycle;
    private OracleDriver m_oracleDriver;
    protected int m_stmtCacheSize;
    protected boolean m_stmtClearMetaData;
    private static final String _Copyright_2007_Oracle_All_Rights_Reserved_ = null;
    public static final String BUILD_DATE = "Thu_Apr_04_15:09:24_PDT_2013";
    public static final boolean TRACE = false;

    private void ensureOpen() throws SQLException {
        if (this.lifecycle == OracleOCIConnectionPool.Lifecycle.NEW) {
            this.createConnectionPool((Properties)null);
        }

        if (this.lifecycle != OracleOCIConnectionPool.Lifecycle.OPEN) {
            SQLException var1 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 8);
            var1.fillInStackTrace();
            throw var1;
        }
    }

    public OracleOCIConnectionPool(String var1, String var2, String var3, Properties var4) throws SQLException {
        this();
        this.setURL(var3);
        this.setUser(var1);
        this.setPassword(var2);
        this.createConnectionPool(var4);
    }

    /** @deprecated */
    public OracleOCIConnectionPool(String var1, String var2, String var3) throws SQLException {
        this();
        this.setURL(var3);
        this.setUser(var1);
        this.setPassword(var2);
        this.createConnectionPool((Properties)null);
    }

    public OracleOCIConnectionPool() throws SQLException {
        this.m_conn_min_limit = 0;
        this.m_conn_max_limit = 0;
        this.m_conn_increment = 0;
        this.m_conn_active_size = 0;
        this.m_conn_pool_size = 0;
        this.m_conn_timeout = 0;
        this.m_conn_nowait = "false";
        this.m_is_transactions_distributed = 0;
        this.m_lconnections = null;
        this.lifecycle = OracleOCIConnectionPool.Lifecycle.NEW;
        this.m_oracleDriver = new OracleDriver();
        this.m_stmtCacheSize = 0;
        this.m_stmtClearMetaData = false;
        this.isOracleDataSource = false;
        this.m_lconnections = new Hashtable(10);
        this.setDriverType("oci8");
    }

    public synchronized Connection getConnection() throws SQLException {
        this.ensureOpen();
        Connection var1 = this.getConnection(this.user, this.password);
        return var1;
    }

    public synchronized Connection getConnection(String var1, String var2) throws SQLException {
        this.ensureOpen();
        Properties var3;
        if (this.connectionProperties != null) {
            var3 = new Properties(this.connectionProperties);
        } else {
            var3 = new Properties();
        }

        var3.put("is_connection_pooling", "true");
        var3.put("user", var1);
        var3.put("password", var2);
        var3.put("connection_pool", "connpool_connection");
        var3.put("connpool_object", this.m_connection_pool);
        OracleOCIConnection var4 = (OracleOCIConnection)this.m_oracleDriver.connect(this.url, var3);
        if (var4 == null) {
            SQLException var5 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 67);
            var5.fillInStackTrace();
            throw var5;
        } else {
            var4.setStmtCacheSize(this.m_stmtCacheSize, this.m_stmtClearMetaData);
            this.m_lconnections.put(var4, var4);
            var4.setConnectionPool(this);
            return var4;
        }
    }

    public synchronized Reference getReference() throws NamingException {
        Reference var1 = new Reference(this.getClass().getName(), "oracle.jdbc.pool.OracleDataSourceFactory", (String)null);
        super.addRefProperties(var1);
        var1.add(new StringRefAddr("connpool_min_limit", String.valueOf(this.m_conn_min_limit)));
        var1.add(new StringRefAddr("connpool_max_limit", String.valueOf(this.m_conn_max_limit)));
        var1.add(new StringRefAddr("connpool_increment", String.valueOf(this.m_conn_increment)));
        var1.add(new StringRefAddr("connpool_active_size", String.valueOf(this.m_conn_active_size)));
        var1.add(new StringRefAddr("connpool_pool_size", String.valueOf(this.m_conn_pool_size)));
        var1.add(new StringRefAddr("connpool_timeout", String.valueOf(this.m_conn_timeout)));
        var1.add(new StringRefAddr("connpool_nowait", this.m_conn_nowait));
        var1.add(new StringRefAddr("connpool_is_poolcreated", String.valueOf(this.isPoolCreated())));
        var1.add(new StringRefAddr("transactions_distributed", String.valueOf(this.isDistributedTransEnabled())));
        return var1;
    }

    public synchronized OracleConnection getProxyConnection(String var1, Properties var2) throws SQLException {
        this.ensureOpen();
        if ("proxytype_user_name".equals(var1)) {
            var2.put("user", var2.getProperty("proxy_user_name"));
        } else if ("proxytype_distinguished_name".equals(var1)) {
            var2.put("user", var2.getProperty("proxy_distinguished_name"));
        } else {
            if (!"proxytype_certificate".equals(var1)) {
                SQLException var6 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 107, "null properties");
                var6.fillInStackTrace();
                throw var6;
            }

            var2.put("user", String.valueOf(var2.getProperty("proxy_user_name")));
        }

        var2.put("is_connection_pooling", "true");
        var2.put("proxytype", var1);
        String[] var3;
        if ((var3 = (String[])((String[])var2.get("proxy_roles"))) != null) {
            var2.put("proxy_num_roles", new Integer(var3.length));
        } else {
            var2.put("proxy_num_roles", new Integer(0));
        }

        var2.put("connection_pool", "connpool_proxy_connection");
        var2.put("connpool_object", this.m_connection_pool);
        OracleOCIConnection var4 = (OracleOCIConnection)this.m_oracleDriver.connect(this.url, var2);
        if (var4 == null) {
            SQLException var5 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 67);
            var5.fillInStackTrace();
            throw var5;
        } else {
            var4.setStmtCacheSize(this.m_stmtCacheSize, this.m_stmtClearMetaData);
            this.m_lconnections.put(var4, var4);
            var4.setConnectionPool(this);
            return var4;
        }
    }

    public synchronized OracleConnection getAliasedConnection(byte[] var1) throws SQLException {
        this.ensureOpen();
        Properties var2 = new Properties();
        var2.put("is_connection_pooling", "true");
        var2.put("connection_id", var1);
        var2.put("connection_pool", "connpool_alias_connection");
        var2.put("connpool_object", this.m_connection_pool);
        OracleOCIConnection var3 = (OracleOCIConnection)this.m_oracleDriver.connect(this.url, var2);
        if (var3 == null) {
            SQLException var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 67);
            var4.fillInStackTrace();
            throw var4;
        } else {
            var3.setStmtCacheSize(this.m_stmtCacheSize, this.m_stmtClearMetaData);
            this.m_lconnections.put(var3, var3);
            var3.setConnectionPool(this);
            return var3;
        }
    }

    public synchronized void close() throws SQLException {
        if (this.lifecycle == OracleOCIConnectionPool.Lifecycle.OPEN) {
            this.lifecycle = OracleOCIConnectionPool.Lifecycle.CLOSING;

            for(Iterator var1 = this.m_lconnections.values().iterator(); var1.hasNext(); var1.remove()) {
                OracleOCIConnection var2 = (OracleOCIConnection)var1.next();
                if (var2 != null && var2 != this.m_connection_pool) {
                    var2.close();
                }
            }

            this.m_connection_pool.close();
            this.lifecycle = OracleOCIConnectionPool.Lifecycle.CLOSED;
        }
    }

    public synchronized void setPoolConfig(Properties var1) throws SQLException {
        if (var1 == null) {
            SQLException var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 106, "null properties");
            var4.fillInStackTrace();
            throw var4;
        } else {
            if (!this.isPoolCreated()) {
                this.createConnectionPool(var1);
            } else {
                Properties var2 = new Properties();
                this.checkPoolConfig(var1, var2);
                int[] var3 = new int[6];
                readPoolConfig(var2, var3);
                this.m_connection_pool.setConnectionPoolInfo(var3[0], var3[1], var3[2], var3[3], var3[4], var3[5]);
            }

            this.storePoolProperties();
        }
    }

    public static void readPoolConfig(int var0, int var1, int var2, int var3, boolean var4, boolean var5, int[] var6) {
        for(int var8 = 0; var8 < 6; ++var8) {
            var6[var8] = 0;
        }

        var6[0] = var0;
        var6[1] = var1;
        var6[2] = var2;
        var6[3] = var3;
        if (var4) {
            var6[4] = 1;
        }

        if (var5) {
            var6[5] = 1;
        }

    }

    public static void readPoolConfig(Properties var0, int[] var1) {
        String var2 = var0.getProperty("connpool_min_limit");
        if (var2 != null) {
            var1[0] = Integer.parseInt(var2);
        }

        var2 = var0.getProperty("connpool_max_limit");
        if (var2 != null) {
            var1[1] = Integer.parseInt(var2);
        }

        var2 = var0.getProperty("connpool_increment");
        if (var2 != null) {
            var1[2] = Integer.parseInt(var2);
        }

        var2 = var0.getProperty("connpool_timeout");
        if (var2 != null) {
            var1[3] = Integer.parseInt(var2);
        }

        var2 = var0.getProperty("connpool_nowait");
        if (var2 != null && var2.equalsIgnoreCase("true")) {
            var1[4] = 1;
        }

        var2 = var0.getProperty("transactions_distributed");
        if (var2 != null && var2.equalsIgnoreCase("true")) {
            var1[5] = 1;
        }

    }

    private void checkPoolConfig(Properties var1, Properties var2) throws SQLException {
        String var3 = (String)var1.get("transactions_distributed");
        String var4 = (String)var1.get("connpool_nowait");
        if ((var3 == null || var3.equalsIgnoreCase("true")) && (var4 == null || var4.equalsIgnoreCase("true")) && var1.get("connpool_min_limit") != null && var1.get("connpool_max_limit") != null && var1.get("connpool_increment") != null && Integer.decode((String)var1.get("connpool_min_limit")) >= 0 && Integer.decode((String)var1.get("connpool_max_limit")) >= 0 && Integer.decode((String)var1.get("connpool_increment")) >= 0) {
            Enumeration var8 = var1.propertyNames();

            while(true) {
                while(var8.hasMoreElements()) {
                    String var6 = (String)var8.nextElement();
                    String var7 = var1.getProperty(var6);
                    if (!"transactions_distributed".equals(var6) && !"connpool_nowait".equals(var6)) {
                        var2.put(var6, var7);
                    } else {
                        var2.put(var6, "true");
                    }
                }

                return;
            }
        } else {
            SQLException var5 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 106, "");
            var5.fillInStackTrace();
            throw var5;
        }
    }

    private synchronized void storePoolProperties() throws SQLException {
        Properties var1 = this.getPoolConfig();
        this.m_conn_min_limit = Integer.decode(var1.getProperty("connpool_min_limit"));
        this.m_conn_max_limit = Integer.decode(var1.getProperty("connpool_max_limit"));
        this.m_conn_increment = Integer.decode(var1.getProperty("connpool_increment"));
        this.m_conn_active_size = Integer.decode(var1.getProperty("connpool_active_size"));
        this.m_conn_pool_size = Integer.decode(var1.getProperty("connpool_pool_size"));
        this.m_conn_timeout = Integer.decode(var1.getProperty("connpool_timeout"));
        this.m_conn_nowait = var1.getProperty("connpool_nowait");
    }

    public synchronized Properties getPoolConfig() throws SQLException {
        this.ensureOpen();
        Properties var1 = this.m_connection_pool.getConnectionPoolInfo();
        var1.put("connpool_is_poolcreated", String.valueOf(this.isPoolCreated()));
        return var1;
    }

    public synchronized int getActiveSize() throws SQLException {
        this.ensureOpen();
        Properties var1 = this.m_connection_pool.getConnectionPoolInfo();
        String var2 = var1.getProperty("connpool_active_size");
        int var3 = Integer.decode(var2);
        return var3;
    }

    public synchronized int getPoolSize() throws SQLException {
        this.ensureOpen();
        Properties var1 = this.m_connection_pool.getConnectionPoolInfo();
        String var2 = var1.getProperty("connpool_pool_size");
        int var3 = Integer.decode(var2);
        return var3;
    }

    public synchronized int getTimeout() throws SQLException {
        this.ensureOpen();
        Properties var1 = this.m_connection_pool.getConnectionPoolInfo();
        String var2 = var1.getProperty("connpool_timeout");
        int var3 = Integer.decode(var2);
        return var3;
    }

    public synchronized String getNoWait() throws SQLException {
        this.ensureOpen();
        Properties var1 = this.m_connection_pool.getConnectionPoolInfo();
        return var1.getProperty("connpool_nowait");
    }

    public synchronized int getMinLimit() throws SQLException {
        this.ensureOpen();
        Properties var1 = this.m_connection_pool.getConnectionPoolInfo();
        String var2 = var1.getProperty("connpool_min_limit");
        int var3 = Integer.decode(var2);
        return var3;
    }

    public synchronized int getMaxLimit() throws SQLException {
        this.ensureOpen();
        Properties var1 = this.m_connection_pool.getConnectionPoolInfo();
        String var2 = var1.getProperty("connpool_max_limit");
        int var3 = Integer.decode(var2);
        return var3;
    }

    public synchronized int getConnectionIncrement() throws SQLException {
        this.ensureOpen();
        Properties var1 = this.m_connection_pool.getConnectionPoolInfo();
        String var2 = var1.getProperty("connpool_increment");
        int var3 = Integer.decode(var2);
        return var3;
    }

    public synchronized boolean isDistributedTransEnabled() {
        return this.m_is_transactions_distributed == 1;
    }

    private void createConnectionPool(Properties var1) throws SQLException {
        if (this.lifecycle == OracleOCIConnectionPool.Lifecycle.NEW) {
            if (this.user != null && this.password != null) {
                Properties var4 = new Properties();
                if (var1 != null) {
                    this.checkPoolConfig(var1, var4);
                }

                var4.put("is_connection_pooling", "true");
                var4.put("user", this.user);
                var4.put("password", this.password);
                var4.put("connection_pool", "connection_pool");
                if (this.getURL() == null) {
                    this.makeURL();
                }

                this.m_connection_pool = (OracleOCIConnection)this.m_oracleDriver.connect(this.url, var4);
                if (this.m_connection_pool == null) {
                    SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 67);
                    var3.fillInStackTrace();
                    throw var3;
                } else {
                    this.m_connection_pool.setConnectionPool(this);
                    this.m_lconnections.put(this.m_connection_pool, this.m_connection_pool);
                    this.lifecycle = OracleOCIConnectionPool.Lifecycle.OPEN;
                    this.storePoolProperties();
                    if (var1 != null && "true".equalsIgnoreCase(var1.getProperty("transactions_distributed"))) {
                        this.m_is_transactions_distributed = 1;
                    }

                }
            } else {
                SQLException var2 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 106, " ");
                var2.fillInStackTrace();
                throw var2;
            }
        }
    }

    public synchronized boolean isPoolCreated() {
        return this.lifecycle == OracleOCIConnectionPool.Lifecycle.OPEN;
    }

    public synchronized void connectionClosed(OracleOCIConnection var1) throws SQLException {
        if (this.lifecycle != OracleOCIConnectionPool.Lifecycle.CLOSING && this.m_lconnections.remove(var1) == null) {
            SQLException var2 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 1, "internal OracleOCIConnectionPool error");
            var2.fillInStackTrace();
            throw var2;
        }
    }

    public synchronized void setStmtCacheSize(int var1) throws SQLException {
        this.setStmtCacheSize(var1, false);
    }

    public synchronized void setStmtCacheSize(int var1, boolean var2) throws SQLException {
        if (var1 < 0) {
            SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 68);
            var3.fillInStackTrace();
            throw var3;
        } else {
            this.m_stmtCacheSize = var1;
            this.m_stmtClearMetaData = var2;
        }
    }

    public synchronized int getStmtCacheSize() {
        return this.m_stmtCacheSize;
    }

    public synchronized boolean isStmtCacheEnabled() {
        return this.m_stmtCacheSize > 0;
    }

    protected OracleConnection getConnectionDuringExceptionHandling() {
        return null;
    }

    private static enum Lifecycle {
        NEW,
        OPEN,
        CLOSING,
        CLOSED;

        private Lifecycle() {
        }
    }
}
