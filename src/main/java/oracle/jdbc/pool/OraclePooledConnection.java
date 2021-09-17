//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package oracle.jdbc.pool;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.Properties;
import javax.sql.ConnectionEvent;
import javax.sql.ConnectionEventListener;
import javax.sql.PooledConnection;
import javax.sql.StatementEventListener;
import javax.transaction.xa.XAResource;
import oracle.jdbc.driver.DatabaseError;
import oracle.jdbc.driver.OracleCloseCallback;
import oracle.jdbc.driver.OracleDriver;
import oracle.jdbc.internal.OracleConnection;

public class OraclePooledConnection implements PooledConnection, Serializable {
    static final long serialVersionUID = -203725628718322873L;
    public static final String url_string = "connection_url";
    public static final String pool_auto_commit_string = "pool_auto_commit";
    public static final String object_type_map = "obj_type_map";
    public static final String transaction_isolation = "trans_isolation";
    public static final String statement_cache_size = "stmt_cache_size";
    public static final String isClearMetaData = "stmt_cache_clear_metadata";
    public static final String ImplicitStatementCachingEnabled = "ImplicitStatementCachingEnabled";
    public static final String ExplicitStatementCachingEnabled = "ExplicitStatementCachingEnabled";
    public static final String LoginTimeout = "LoginTimeout";
    public static final String connect_auto_commit_string = "connect_auto_commit";
    public static final String implicit_caching_enabled = "implicit_cache_enabled";
    public static final String explicit_caching_enabled = "explict_cache_enabled";
    public static final String connection_properties_string = "connection_properties";
    public static final String event_listener_string = "event_listener";
    public static final String sql_exception_string = "sql_exception";
    public static final String close_callback_string = "close_callback";
    public static final String private_data = "private_data";
    static final int CONNECTION_CLOSED_EVENT = 101;
    static final int CONNECTION_ERROROCCURED_EVENT = 102;
    private Hashtable eventListeners;
    private SQLException sqlException;
    protected boolean autoCommit;
    private ConnectionEventListener iccEventListener;
    protected transient OracleConnection logicalHandle;
    protected transient OracleConnection physicalConn;
    private Hashtable connectionProperty;
    public Properties cachedConnectionAttributes;
    public Properties unMatchedCachedConnAttr;
    public int closeOption;
    private String pcKey;
    private OracleCloseCallback closeCallback;
    private Object privateData;
    private long lastAccessedTime;
    protected String dataSourceInstanceNameKey;
    protected String dataSourceHostNameKey;
    protected String dataSourceDbUniqNameKey;
    protected boolean connectionMarkedDown;
    protected boolean needToAbort;
    protected transient OracleDriver oracleDriver;
    boolean localTxnCommitOnClose;
    private static final String _Copyright_2007_Oracle_All_Rights_Reserved_ = null;
    public static final String BUILD_DATE = "Thu_Apr_04_15:09:24_PDT_2013";
    public static final boolean TRACE = false;

    public OraclePooledConnection() {
        this((Connection)null);
    }

    public OraclePooledConnection(String var1) throws SQLException {
        this.eventListeners = null;
        this.sqlException = null;
        this.autoCommit = true;
        this.iccEventListener = null;
        this.logicalHandle = null;
        this.physicalConn = null;
        this.connectionProperty = null;
        this.cachedConnectionAttributes = null;
        this.unMatchedCachedConnAttr = null;
        this.closeOption = 0;
        this.pcKey = null;
        this.closeCallback = null;
        this.privateData = null;
        this.lastAccessedTime = 0L;
        this.dataSourceInstanceNameKey = null;
        this.dataSourceHostNameKey = null;
        this.dataSourceDbUniqNameKey = null;
        this.connectionMarkedDown = false;
        this.needToAbort = false;
        this.oracleDriver = new OracleDriver();
        this.localTxnCommitOnClose = false;
        Connection var2 = this.oracleDriver.connect(var1, new Properties());
        if (var2 == null) {
            SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 67);
            var3.fillInStackTrace();
            throw var3;
        } else {
            this.initialize(var2);
        }
    }

    public OraclePooledConnection(String var1, String var2, String var3) throws SQLException {
        this.eventListeners = null;
        this.sqlException = null;
        this.autoCommit = true;
        this.iccEventListener = null;
        this.logicalHandle = null;
        this.physicalConn = null;
        this.connectionProperty = null;
        this.cachedConnectionAttributes = null;
        this.unMatchedCachedConnAttr = null;
        this.closeOption = 0;
        this.pcKey = null;
        this.closeCallback = null;
        this.privateData = null;
        this.lastAccessedTime = 0L;
        this.dataSourceInstanceNameKey = null;
        this.dataSourceHostNameKey = null;
        this.dataSourceDbUniqNameKey = null;
        this.connectionMarkedDown = false;
        this.needToAbort = false;
        this.oracleDriver = new OracleDriver();
        this.localTxnCommitOnClose = false;
        Properties var4 = new Properties();
        var4.put("user", var2);
        var4.put("password", var3);
        Connection var5 = this.oracleDriver.connect(var1, var4);
        if (var5 == null) {
            SQLException var6 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 67);
            var6.fillInStackTrace();
            throw var6;
        } else {
            this.initialize(var5);
        }
    }

    public OraclePooledConnection(Connection var1) {
        this.eventListeners = null;
        this.sqlException = null;
        this.autoCommit = true;
        this.iccEventListener = null;
        this.logicalHandle = null;
        this.physicalConn = null;
        this.connectionProperty = null;
        this.cachedConnectionAttributes = null;
        this.unMatchedCachedConnAttr = null;
        this.closeOption = 0;
        this.pcKey = null;
        this.closeCallback = null;
        this.privateData = null;
        this.lastAccessedTime = 0L;
        this.dataSourceInstanceNameKey = null;
        this.dataSourceHostNameKey = null;
        this.dataSourceDbUniqNameKey = null;
        this.connectionMarkedDown = false;
        this.needToAbort = false;
        this.oracleDriver = new OracleDriver();
        this.localTxnCommitOnClose = false;
        this.initialize(var1);
    }

    public OraclePooledConnection(Connection var1, boolean var2) {
        this(var1);
        this.autoCommit = var2;
    }

    private void initialize(Connection var1) {
        this.physicalConn = (OracleConnection)var1;
        this.eventListeners = new Hashtable(10);
        this.closeCallback = null;
        this.privateData = null;
        this.lastAccessedTime = 0L;
    }

    public synchronized void addConnectionEventListener(ConnectionEventListener var1) {
        if (this.eventListeners == null) {
            this.sqlException = new SQLException("Listener Hashtable Null");
        } else {
            this.eventListeners.put(var1, var1);
        }

    }

    public synchronized void close() throws SQLException {
        if (this.closeCallback != null) {
            this.closeCallback.beforeClose(this.physicalConn, this.privateData);
        }

        if (this.physicalConn != null) {
            try {
                this.physicalConn.close();
            } catch (SQLException var2) {
            }

            this.physicalConn = null;
        }

        if (this.closeCallback != null) {
            this.closeCallback.afterClose(this.privateData);
        }

        this.lastAccessedTime = 0L;
        this.iccEventListener = null;
    }

    public synchronized Connection getConnection() throws SQLException {
        if (this.physicalConn == null) {
            this.sqlException = new SQLException("Physical Connection doesn't exist");
            this.callListener(102);
            SQLException var1 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 8);
            var1.fillInStackTrace();
            throw var1;
        } else {
            try {
                if (this.logicalHandle != null) {
                    this.logicalHandle.closeInternal(false);
                }

                this.logicalHandle = (OracleConnection)this.physicalConn.getLogicalConnection(this, this.autoCommit);
            } catch (SQLException var3) {
                this.sqlException = var3;
                this.callListener(102);
                this.callImplicitCacheListener(102);
                SQLException var2 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 8, "OraclePooledConnection.getConnection() - SQLException Ocurred:" + var3.getMessage());
                var2.fillInStackTrace();
                throw var2;
            }

            return this.logicalHandle;
        }
    }

    public Connection getLogicalHandle() throws SQLException {
        return this.logicalHandle;
    }

    public Connection getPhysicalHandle() throws SQLException {
        return this.physicalConn;
    }

    public synchronized void setLastAccessedTime(long var1) throws SQLException {
        this.lastAccessedTime = var1;
    }

    public long getLastAccessedTime() throws SQLException {
        return this.lastAccessedTime;
    }

    public synchronized void registerCloseCallback(OracleCloseCallback var1, Object var2) {
        this.closeCallback = var1;
        this.privateData = var2;
    }

    public synchronized void removeConnectionEventListener(ConnectionEventListener var1) {
        if (this.eventListeners == null) {
            this.sqlException = new SQLException("Listener Hashtable Null");
        } else {
            this.eventListeners.remove(var1);
        }

    }

    public synchronized void registerImplicitCacheConnectionEventListener(ConnectionEventListener var1) {
        if (this.iccEventListener != null) {
            this.sqlException = new SQLException("Implicit cache listeneralready registered");
        } else {
            this.iccEventListener = var1;
        }

    }

    public void logicalCloseForImplicitConnectionCache() {
        if (this.closeOption == 4096) {
            this.callImplicitCacheListener(102);
        } else {
            this.callImplicitCacheListener(101);
        }

    }

    public void logicalClose() {
        if (this.cachedConnectionAttributes != null) {
            this.logicalCloseForImplicitConnectionCache();
        } else {
            this.callListener(101);
        }

    }

    private void callListener(int var1) {
        if (this.eventListeners != null) {
            Enumeration var2 = this.eventListeners.keys();
            ConnectionEvent var3 = new ConnectionEvent(this, this.sqlException);

            while(var2.hasMoreElements()) {
                ConnectionEventListener var4 = (ConnectionEventListener)var2.nextElement();
                ConnectionEventListener var5 = (ConnectionEventListener)this.eventListeners.get(var4);
                if (var1 == 101) {
                    var5.connectionClosed(var3);
                } else if (var1 == 102) {
                    var5.connectionErrorOccurred(var3);
                }
            }

        }
    }

    private void callImplicitCacheListener(int var1) {
        if (this.iccEventListener != null) {
            ConnectionEvent var2 = new ConnectionEvent(this, this.sqlException);
            switch(var1) {
                case 101:
                    this.iccEventListener.connectionClosed(var2);
                    break;
                case 102:
                    this.iccEventListener.connectionErrorOccurred(var2);
            }

        }
    }

    /** @deprecated */
    public synchronized void setStmtCacheSize(int var1) throws SQLException {
        this.setStmtCacheSize(var1, false);
    }

    /** @deprecated */
    public synchronized void setStmtCacheSize(int var1, boolean var2) throws SQLException {
        if (var1 < 0) {
            SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 68);
            var3.fillInStackTrace();
            throw var3;
        } else {
            if (this.physicalConn != null) {
                this.physicalConn.setStmtCacheSize(var1, var2);
            }

        }
    }

    /** @deprecated */
    public synchronized int getStmtCacheSize() {
        return this.physicalConn != null ? this.physicalConn.getStmtCacheSize() : 0;
    }

    public void setStatementCacheSize(int var1) throws SQLException {
        if (this.physicalConn != null) {
            this.physicalConn.setStatementCacheSize(var1);
        }

    }

    public int getStatementCacheSize() throws SQLException {
        return this.physicalConn != null ? this.physicalConn.getStatementCacheSize() : 0;
    }

    public void setImplicitCachingEnabled(boolean var1) throws SQLException {
        if (this.physicalConn != null) {
            this.physicalConn.setImplicitCachingEnabled(var1);
        }

    }

    public boolean getImplicitCachingEnabled() throws SQLException {
        return this.physicalConn != null ? this.physicalConn.getImplicitCachingEnabled() : false;
    }

    public void setExplicitCachingEnabled(boolean var1) throws SQLException {
        if (this.physicalConn != null) {
            this.physicalConn.setExplicitCachingEnabled(var1);
        }

    }

    public boolean getExplicitCachingEnabled() throws SQLException {
        return this.physicalConn != null ? this.physicalConn.getExplicitCachingEnabled() : false;
    }

    public void purgeImplicitCache() throws SQLException {
        if (this.physicalConn != null) {
            this.physicalConn.purgeImplicitCache();
        }

    }

    public void purgeExplicitCache() throws SQLException {
        if (this.physicalConn != null) {
            this.physicalConn.purgeExplicitCache();
        }

    }

    public PreparedStatement getStatementWithKey(String var1) throws SQLException {
        return this.physicalConn != null ? this.physicalConn.getStatementWithKey(var1) : null;
    }

    public CallableStatement getCallWithKey(String var1) throws SQLException {
        return this.physicalConn != null ? this.physicalConn.getCallWithKey(var1) : null;
    }

    public boolean isStatementCacheInitialized() {
        return this.physicalConn != null ? this.physicalConn.isStatementCacheInitialized() : false;
    }

    public final void setProperties(Hashtable var1) {
        this.connectionProperty = var1;
    }

    public final void setUserName(String var1, String var2) {
        this.pcKey = generateKey(var1, var2);
    }

    static final String generateKey(String var0, String var1) {
        return var0.toUpperCase() + var1;
    }

    final OracleConnectionCacheEntry addToImplicitCache(HashMap var1, OracleConnectionCacheEntry var2) {
        return (OracleConnectionCacheEntry)var1.put(this.pcKey, var2);
    }

    final OracleConnectionCacheEntry removeFromImplictCache(HashMap var1) {
        return (OracleConnectionCacheEntry)var1.get(this.pcKey);
    }

    final boolean isSameUser(String var1, String var2) {
        return var1 != null && var2 != null && this.pcKey.equalsIgnoreCase(var1 + var2);
    }

    public XAResource getXAResource() throws SQLException {
        SQLException var1 = DatabaseError.createUnsupportedFeatureSqlException();
        var1.fillInStackTrace();
        throw var1;
    }

    private void writeObject(ObjectOutputStream var1) throws IOException {
        var1.defaultWriteObject();

        try {
            this.physicalConn.getPropertyForPooledConnection(this);
            if (this.eventListeners != null) {
                this.connectionProperty.put("event_listener", this.eventListeners);
            }

            if (this.sqlException != null) {
                this.connectionProperty.put("sql_exception", this.sqlException);
            }

            this.connectionProperty.put("pool_auto_commit", "" + this.autoCommit);
            if (this.closeCallback != null) {
                this.connectionProperty.put("close_callback", this.closeCallback);
            }

            if (this.privateData != null) {
                this.connectionProperty.put("private_data", this.privateData);
            }

            var1.writeObject(this.connectionProperty);
            this.physicalConn.close();
        } catch (SQLException var3) {
        }

    }

    private void readObject(ObjectInputStream var1) throws IOException, ClassNotFoundException, SQLException {
        var1.defaultReadObject();
        this.connectionProperty = (Hashtable)var1.readObject();

        try {
            Properties var2 = (Properties)this.connectionProperty.get("connection_properties");
            String var3 = var2.getProperty("connection_url");
            this.oracleDriver = new OracleDriver();
            Connection var4 = this.oracleDriver.connect(var3, var2);
            this.initialize(var4);
            this.eventListeners = (Hashtable)this.connectionProperty.get("event_listener");
            this.sqlException = (SQLException)this.connectionProperty.get("sql_exception");
            this.autoCommit = ((String)this.connectionProperty.get("pool_auto_commit")).equals("true");
            this.closeCallback = (OracleCloseCallback)this.connectionProperty.get("close_callback");
            this.privateData = this.connectionProperty.get("private_data");
            Map var5 = (Map)this.connectionProperty.get("obj_type_map");
            if (var5 != null) {
                ((OracleConnection)var4).setTypeMap(var5);
            }

            String var6 = var2.getProperty("trans_isolation");
            var4.setTransactionIsolation(Integer.parseInt(var6));
            var6 = var2.getProperty("stmt_cache_size");
            int var7 = Integer.parseInt(var6);
            if (var7 != -1) {
                this.setStatementCacheSize(var7);
                var6 = var2.getProperty("implicit_cache_enabled");
                if (var6 != null && var6.equalsIgnoreCase("true")) {
                    this.setImplicitCachingEnabled(true);
                } else {
                    this.setImplicitCachingEnabled(false);
                }

                var6 = var2.getProperty("explict_cache_enabled");
                if (var6 != null && var6.equalsIgnoreCase("true")) {
                    this.setExplicitCachingEnabled(true);
                } else {
                    this.setExplicitCachingEnabled(false);
                }
            }

            this.physicalConn.setAutoCommit(((String)var2.get("connect_auto_commit")).equals("true"));
        } catch (Exception var8) {
        }

    }

    public void addStatementEventListener(StatementEventListener var1) {
    }

    public void removeStatementEventListener(StatementEventListener var1) {
    }

    protected OracleConnection getConnectionDuringExceptionHandling() {
        return null;
    }
}
