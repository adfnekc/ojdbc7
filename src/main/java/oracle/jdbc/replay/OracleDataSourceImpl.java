package oracle.jdbc.replay;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.io.Serializable;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.Hashtable;
import java.util.Properties;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.Name;
import javax.naming.NamingException;
import javax.naming.Reference;
import javax.naming.Referenceable;
import javax.naming.StringRefAddr;
import javax.naming.spi.ObjectFactory;
import oracle.jdbc.internal.OracleConnection;
import oracle.jdbc.proxy.ProxyFactory;
import oracle.jdbc.replay.driver.NonTxnReplayableArray;
import oracle.jdbc.replay.driver.NonTxnReplayableBase;
import oracle.jdbc.replay.driver.NonTxnReplayableBfile;
import oracle.jdbc.replay.driver.NonTxnReplayableBlob;
import oracle.jdbc.replay.driver.NonTxnReplayableClob;
import oracle.jdbc.replay.driver.NonTxnReplayableConnection;
import oracle.jdbc.replay.driver.NonTxnReplayableNClob;
import oracle.jdbc.replay.driver.NonTxnReplayableOpaque;
import oracle.jdbc.replay.driver.NonTxnReplayableOthers;
import oracle.jdbc.replay.driver.NonTxnReplayableRef;
import oracle.jdbc.replay.driver.NonTxnReplayableResultSet;
import oracle.jdbc.replay.driver.NonTxnReplayableStatement;
import oracle.jdbc.replay.driver.NonTxnReplayableStruct;
import oracle.jdbc.replay.driver.TxnReplayableArray;
import oracle.jdbc.replay.driver.TxnReplayableBase;
import oracle.jdbc.replay.driver.TxnReplayableBfile;
import oracle.jdbc.replay.driver.TxnReplayableBlob;
import oracle.jdbc.replay.driver.TxnReplayableClob;
import oracle.jdbc.replay.driver.TxnReplayableConnection;
import oracle.jdbc.replay.driver.TxnReplayableNClob;
import oracle.jdbc.replay.driver.TxnReplayableOpaque;
import oracle.jdbc.replay.driver.TxnReplayableOthers;
import oracle.jdbc.replay.driver.TxnReplayableRef;
import oracle.jdbc.replay.driver.TxnReplayableResultSet;
import oracle.jdbc.replay.driver.TxnReplayableSqlxml;
import oracle.jdbc.replay.driver.TxnReplayableStatement;
import oracle.jdbc.replay.driver.TxnReplayableStruct;

public class OracleDataSourceImpl implements oracle.jdbc.replay.internal.OracleDataSource, Serializable, Referenceable, ObjectFactory {
   private static final long serialVersionUID = 5634196469087099680L;
   private static ProxyFactory PROXY_FACTORY = null;
   private static ProxyFactory NON_TXN_PROXY_FACTORY = null;
   private static final Object proxyFactoryLock = new Object();
   private oracle.jdbc.pool.OracleDataSource ods = null;
   private oracle.jdbc.pool.OracleDataSource odsReconnectOnly = null;
   private String user = null;
   private String password = null;
   private String url = null;
   private String serverName = null;
   private int portNumber = 0;
   private String databaseName = null;
   private String dataSourceName = null;
   private String description = null;
   private String networkProtocol = null;
   private String roleName = null;
   private Properties connectionProperties = null;
   private Properties reconnectionProperties = null;
   private int maxStatements = 0;
   private boolean implicitCachingEnabled = false;
   private boolean explicitCachingEnabled = false;
   private oracle.jdbc.replay.internal.ConnectionInitializationCallback connectionInitializationCallback = null;
   private AtomicBoolean isFirstConnection = new AtomicBoolean(true);
   private static final String RECONNECT_DELAY_PROPERTY = "AUTH_FAILOVER_DELAY";
   private static final String RECONNECT_RETRIES_PROPERTY = "AUTH_FAILOVER_RETRIES";
   private int reconnectDelay = 10;
   private int reconnectRetries = 30;
   private static final String FAILOVER_TYPE_PROPERTY = "AUTH_FAILOVER_TYPE";
   private static final int FAILOVER_TYPE_TRANSACTION = 8;
   private static final int SESSION_STATE_CONSISTENCY_STATIC = 16;
   private boolean isTransactionReplayEnabled = false;
   private static final String SESSION_STATE_PROPERTY = "AUTH_SESSION_STATE_CONSISTENCY";
   private boolean isReplayInDynamicMode = true;
   private static final String INITIATION_TIMEOUT_PROPERTY = "AUTH_FAILOVER_REPLAYTIMEOUT";
   private int replayInitiationTimeout = 300;
   private static final String CHECKSUM_PROPERTY = "oracle.jdbc.calculateChecksum";
   private final String clientChecksum12x;
   private final String clientChecksum11203x;
   private static final String IGNORE_AC_CONTEXT_PROPERTY = "oracle.jdbc.ignoreReplayContextFromAuthentication";
   private static final String AC_11203_COMPATIBLE_SYSTEM_PROPERTY = "oracle.jdbc.AC11203Compatible";
   private static final String _Copyright_2007_Oracle_All_Rights_Reserved_;
   public static final String BUILD_DATE = "Thu_Apr_04_15:09:24_PDT_2013";

   public OracleDataSourceImpl() {
      this.clientChecksum12x = OracleConnection.ChecksumMode.CALCULATE_CHECKSUM_BINDS.toString();
      this.clientChecksum11203x = OracleConnection.ChecksumMode.CALCULATE_CHECKSUM_ALL.toString();

      try {
         this.ods = new oracle.jdbc.pool.OracleDataSource();
         this.odsReconnectOnly = new oracle.jdbc.pool.OracleDataSource();
      } catch (SQLException var2) {
      }

   }

   public Connection getConnection() throws SQLException {
      return this.getConnection(this.user, this.password);
   }

   public Connection getConnection(String var1, String var2) throws SQLException {
      return this.getConnectionInternal(var1, var2, true);
   }

   public Connection getConnectionNoProxy(String var1, String var2) throws SQLException {
      int var3 = 1;
      Connection var4 = null;
      Exception var5 = null;

      do {
         try {
            var5 = null;
            var4 = this.getConnectionInternal(var1, var2, false);
         } catch (Exception var12) {
            var4 = null;
            var5 = var12;
         } finally {
            if (var4 != null && var5 == null) {
               return var4;
            }

            ++var3;
         }

         try {
            if (this.reconnectDelay > 0) {
               Thread.sleep((long)(this.reconnectDelay * 1000));
            }
         } catch (InterruptedException var11) {
         }
      } while(var3 <= this.reconnectRetries);

      return null;
   }

   private Connection getConnectionInternal(String var1, String var2, boolean var3) throws SQLException {
      Connection var4 = null;
      if (this.isFirstConnection.get()) {
         this.setConnectionProperty("oracle.jdbc.calculateChecksum", this.clientChecksum12x);
         this.reconnectionProperties.setProperty("oracle.jdbc.ignoreReplayContextFromAuthentication", "true");
         this.odsReconnectOnly.setConnectionProperties(this.reconnectionProperties);
      }

      if (var3) {
         var4 = this.ods.getConnection(var1, var2);
      } else {
         var4 = this.odsReconnectOnly.getConnection(var1, var2);
      }

      boolean var5 = false;
      OracleConnection var6 = (OracleConnection)var4;
      Properties var7 = var6.getServerSessionInfo();
      String var8 = var7.getProperty("AUTH_FAILOVER_DELAY");
      if (var8 != null && !"".equals(var8)) {
         int var9 = Integer.parseInt(var8);
         if (var9 > 0) {
            this.reconnectDelay = var9;
         }
      }

      String var18 = var7.getProperty("AUTH_FAILOVER_RETRIES");
      if (var18 != null && !"".equals(var18)) {
         int var10 = Integer.parseInt(var18);
         if (var10 > 0) {
            this.reconnectRetries = var10;
         }
      }

      String var19 = var7.getProperty("AUTH_FAILOVER_TYPE");
      if (var19 != null && !"".equals(var19)) {
         int var11;
         try {
            var11 = Integer.parseInt(var19);
         } catch (NumberFormatException var16) {
            var11 = 0;
         }

         this.isTransactionReplayEnabled = (var11 & 8) == 8;
         this.isReplayInDynamicMode = (var11 & 16) == 0;
      }

      String var20 = var7.getProperty("AUTH_FAILOVER_REPLAYTIMEOUT");
      if (var20 != null && !"".equals(var20)) {
         this.replayInitiationTimeout = Integer.parseInt(var20);
      }

      short var17 = var6.getVersionNumber();
      if (var17 < 11203) {
         var3 = false;
      } else if (var17 >= 12100 && !this.isTransactionReplayEnabled) {
         var3 = false;
      } else if (var17 >= 11203 && var17 < 12100) {
         boolean var12 = "true".equalsIgnoreCase(this.getSystemProperty("oracle.jdbc.AC11203Compatible", "false"));
         if (var12) {
            var4.close();
            this.setConnectionProperty("oracle.jdbc.calculateChecksum", this.clientChecksum11203x);
            var4 = this.ods.getConnection(var1, var2);
            synchronized(proxyFactoryLock) {
               PROXY_FACTORY = NON_TXN_PROXY_FACTORY;
            }
         } else {
            var3 = false;
         }
      }

      this.isFirstConnection.set(false);
      if (var3) {
         Connection var21 = (Connection)PROXY_FACTORY.proxyFor(var4);
         oracle.jdbc.replay.internal.ReplayableConnection var13 = (oracle.jdbc.replay.internal.ReplayableConnection)var21;
         var13.initialize(this, var1, var2);
         if (var17 >= 12100) {
            var13.setReplayInitiationTimeout(this.replayInitiationTimeout);
            var13.setSessionStateConsistency(!this.isReplayInDynamicMode);
         }

         ((OracleConnection)var4).getReplayContext();
         return var21;
      } else {
         return var4;
      }
   }

   public PrintWriter getLogWriter() throws SQLException {
      return null;
   }

   public void setLogWriter(PrintWriter var1) throws SQLException {
   }

   public void setLoginTimeout(int var1) throws SQLException {
   }

   public int getLoginTimeout() throws SQLException {
      return 0;
   }

   public String getUser() {
      return this.user;
   }

   public void setUser(String var1) throws SQLException {
      this.user = var1;
      this.ods.setUser(var1);
      this.odsReconnectOnly.setUser(var1);
   }

   public String getPassword() {
      return this.password;
   }

   public void setPassword(String var1) throws SQLException {
      this.password = var1;
      this.ods.setPassword(var1);
      this.odsReconnectOnly.setPassword(var1);
   }

   public String getURL() {
      return this.url;
   }

   public void setURL(String var1) throws SQLException {
      this.url = var1;
      this.ods.setURL(var1);
      this.odsReconnectOnly.setURL(var1);
   }

   public void setServerName(String var1) throws SQLException {
      this.serverName = var1;
      this.ods.setServerName(var1);
      this.odsReconnectOnly.setServerName(var1);
   }

   public String getServerName() {
      return this.serverName;
   }

   public void setPortNumber(int var1) throws SQLException {
      this.portNumber = var1;
      this.ods.setPortNumber(var1);
      this.odsReconnectOnly.setPortNumber(var1);
   }

   public int getPortNumber() {
      return this.portNumber;
   }

   public void setDatabaseName(String var1) throws SQLException {
      this.databaseName = var1;
      this.ods.setDatabaseName(var1);
      this.odsReconnectOnly.setDatabaseName(var1);
   }

   public String getDatabaseName() {
      return this.databaseName;
   }

   public void setDataSourceName(String var1) throws SQLException {
      this.dataSourceName = var1;
      this.ods.setDataSourceName(var1);
      this.odsReconnectOnly.setDataSourceName(var1);
   }

   public String getDataSourceName() {
      return this.dataSourceName;
   }

   public void setDescription(String var1) throws SQLException {
      this.description = var1;
      this.ods.setDescription(var1);
      this.odsReconnectOnly.setDescription(var1);
   }

   public String getDescription() {
      return this.description;
   }

   public void setNetworkProtocol(String var1) throws SQLException {
      this.networkProtocol = var1;
      this.ods.setNetworkProtocol(var1);
      this.odsReconnectOnly.setNetworkProtocol(var1);
   }

   public String getNetworkProtocol() {
      return this.networkProtocol;
   }

   public void setRoleName(String var1) throws SQLException {
      this.roleName = var1;
   }

   public String getRoleName() {
      return this.roleName;
   }

   public void registerConnectionInitializationCallback(oracle.jdbc.replay.internal.ConnectionInitializationCallback var1) throws SQLException {
      if (var1 == null) {
         throw new NullPointerException("callback has to be non-null");
      } else {
         this.connectionInitializationCallback = var1;
      }
   }

   public void unregisterConnectionInitializationCallback(oracle.jdbc.replay.internal.ConnectionInitializationCallback var1) throws SQLException {
      this.connectionInitializationCallback = null;
   }

   public oracle.jdbc.replay.internal.ConnectionInitializationCallback getConnectionInitializationCallback() {
      return this.connectionInitializationCallback;
   }

   public Properties getConnectionProperties() {
      return this.connectionProperties;
   }

   public String getConnectionProperty(String var1) {
      return this.connectionProperties.getProperty(var1);
   }

   public void setConnectionProperty(String var1, String var2) throws SQLException {
      if (var2 != null && !var2.equals("")) {
         if (this.connectionProperties == null) {
            this.connectionProperties = new Properties();
         }

         if (this.reconnectionProperties == null) {
            this.reconnectionProperties = new Properties();
         }

         this.connectionProperties.setProperty(var1, var2);
         this.reconnectionProperties.setProperty(var1, var2);
         this.ods.setConnectionProperties(this.connectionProperties);
         this.odsReconnectOnly.setConnectionProperties(this.reconnectionProperties);
      } else {
         throw new IllegalArgumentException();
      }
   }

   public void setConnectionProperties(Properties var1) throws SQLException {
      if (var1 == null) {
         this.connectionProperties = null;
         this.reconnectionProperties = null;
      } else {
         this.connectionProperties = (Properties)var1.clone();
         this.reconnectionProperties = (Properties)var1.clone();
      }

      this.setConnectionProperty("oracle.jdbc.calculateChecksum", this.clientChecksum12x);
      this.reconnectionProperties.setProperty("oracle.jdbc.ignoreReplayContextFromAuthentication", "true");
      this.odsReconnectOnly.setConnectionProperties(this.reconnectionProperties);
   }

   public void setMaxStatements(int var1) throws SQLException {
      this.maxStatements = var1;
      this.ods.setMaxStatements(var1);
      this.odsReconnectOnly.setMaxStatements(var1);
   }

   public int getMaxStatements() throws SQLException {
      return this.maxStatements;
   }

   public void setImplicitCachingEnabled(boolean var1) throws SQLException {
      this.implicitCachingEnabled = var1;
      this.ods.setImplicitCachingEnabled(var1);
      this.odsReconnectOnly.setImplicitCachingEnabled(var1);
   }

   public boolean getImplicitCachingEnabled() throws SQLException {
      return this.implicitCachingEnabled;
   }

   public void setExplicitCachingEnabled(boolean var1) throws SQLException {
      this.explicitCachingEnabled = var1;
      this.ods.setExplicitCachingEnabled(var1);
      this.odsReconnectOnly.setExplicitCachingEnabled(var1);
   }

   public boolean getExplicitCachingEnabled() throws SQLException {
      return this.explicitCachingEnabled;
   }

   public Reference getReference() throws NamingException {
      Reference var1 = new Reference(this.getClass().getName(), "oracle.jdbc.replay.OracleDataSourceImpl", (String)null);
      if (this.user != null) {
         var1.add(new StringRefAddr("user", this.user));
      }

      if (this.password != null) {
         var1.add(new StringRefAddr("password", this.password));
      }

      if (this.url != null) {
         var1.add(new StringRefAddr("url", this.url));
      }

      if (this.serverName != null) {
         var1.add(new StringRefAddr("serverName", this.serverName));
      }

      var1.add(new StringRefAddr("portNumber", Integer.toString(this.portNumber)));
      if (this.databaseName != null) {
         var1.add(new StringRefAddr("databaseName", this.databaseName));
      }

      if (this.dataSourceName != null) {
         var1.add(new StringRefAddr("dataSourceName", this.dataSourceName.toString()));
      }

      if (this.description != null) {
         var1.add(new StringRefAddr("description", this.description.toString()));
      }

      if (this.networkProtocol != null) {
         var1.add(new StringRefAddr("networkProtocol", this.networkProtocol.toString()));
      }

      if (this.roleName != null) {
         var1.add(new StringRefAddr("roleName", this.roleName));
      }

      if (this.connectionProperties.size() > 0) {
         var1.add(new StringRefAddr("connectionProperties", this.connectionProperties.toString()));
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

      return var1;
   }

   private void writeObject(ObjectOutputStream var1) throws IOException {
      var1.defaultWriteObject();
   }

   private void readObject(ObjectInputStream var1) throws IOException, ClassNotFoundException, SQLException {
      var1.defaultReadObject();
   }

   public Object getObjectInstance(Object var1, Name var2, Context var3, Hashtable var4) throws Exception {
      Reference var5 = (Reference)var1;
      String var6 = var5.getClassName();
      OracleDataSourceImpl var7 = null;
      if (var6.equals("oracle.jdbc.replay.OracleDataSource") || var6.equals("oracle.jdbc.replay.OracleDataSourceImpl")) {
         var7 = new OracleDataSourceImpl();
      }

      if (var7 == null) {
         return null;
      } else {
         StringRefAddr var8 = (StringRefAddr)var5.get("user");
         if (var8 != null) {
            var7.setUser((String)var8.getContent());
         }

         var8 = (StringRefAddr)var5.get("password");
         if (var8 != null) {
            var7.setPassword((String)var8.getContent());
         }

         var8 = (StringRefAddr)var5.get("url");
         if (var8 != null) {
            var7.setURL((String)var8.getContent());
         }

         var8 = (StringRefAddr)var5.get("serverName");
         if (var8 != null) {
            var7.setServerName((String)var8.getContent());
         }

         var8 = (StringRefAddr)var5.get("portNumber");
         if (var8 != null) {
            var7.setPortNumber(Integer.parseInt((String)var8.getContent()));
         }

         var8 = (StringRefAddr)var5.get("databaseName");
         if (var8 != null) {
            var7.setDatabaseName((String)var8.getContent());
         }

         var8 = (StringRefAddr)var5.get("dataSourceName");
         if (var8 != null) {
            var7.setDataSourceName((String)var8.getContent());
         }

         var8 = (StringRefAddr)var5.get("description");
         if (var8 != null) {
            var7.setDescription((String)var8.getContent());
         }

         var8 = (StringRefAddr)var5.get("networkProtocol");
         if (var8 != null) {
            var7.setNetworkProtocol((String)var8.getContent());
         }

         var8 = (StringRefAddr)var5.get("roleName");
         if (var8 != null) {
            var7.setRoleName((String)var8.getContent());
         }

         var8 = (StringRefAddr)var5.get("connectionProperties");
         String var9;
         if (var8 != null) {
            var9 = (String)var8.getContent();
            Properties var10 = new Properties();
            String[] var11 = var9.substring(1, var9.length() - 1).split(", ");
            String[] var12 = var11;
            int var13 = var11.length;

            for(int var14 = 0; var14 < var13; ++var14) {
               String var15 = var12[var14];
               String[] var16 = var15.split("=");
               var10.setProperty(var16[0], var16[1]);
            }

            var7.setConnectionProperties(var10);
         }

         var8 = (StringRefAddr)var5.get("maxStatements");
         if (var8 != null) {
            var7.setMaxStatements(Integer.parseInt((String)var8.getContent()));
         }

         var8 = (StringRefAddr)var5.get("implicitCachingEnabled");
         if (var8 != null) {
            var9 = (String)var8.getContent();
            if (var9.equalsIgnoreCase("true")) {
               var7.setImplicitCachingEnabled(true);
            } else {
               var7.setImplicitCachingEnabled(false);
            }
         }

         var8 = (StringRefAddr)var5.get("explicitCachingEnabled");
         if (var8 != null) {
            var9 = (String)var8.getContent();
            if (var9.equalsIgnoreCase("true")) {
               var7.setExplicitCachingEnabled(true);
            } else {
               var7.setExplicitCachingEnabled(false);
            }
         }

         return var7;
      }
   }

   public boolean isWrapperFor(Class var1) throws SQLException {
      return false;
   }

   public Object unwrap(Class var1) throws SQLException {
      return var1.isInterface() && var1.isInstance(this) ? this : null;
   }

   public Logger getParentLogger() throws SQLFeatureNotSupportedException {
      return Logger.getLogger("oracle");
   }

   private String getSystemProperty(final String var1, final String var2) {
      if (var1 != null) {
         final String[] var5 = new String[]{var2};
         AccessController.doPrivileged(new PrivilegedAction() {
            public Object run() {
               var5[0] = System.getProperty(var1, var2);
               return null;
            }
         });
         return var5[0];
      } else {
         return var2;
      }
   }

   static {
      synchronized(proxyFactoryLock) {
         if (PROXY_FACTORY == null) {
            NON_TXN_PROXY_FACTORY = ProxyFactory.createProxyFactory(NonTxnReplayableBase.class, NonTxnReplayableConnection.class, NonTxnReplayableStatement.class, NonTxnReplayableResultSet.class, NonTxnReplayableArray.class, NonTxnReplayableBfile.class, NonTxnReplayableBlob.class, NonTxnReplayableClob.class, NonTxnReplayableNClob.class, NonTxnReplayableOpaque.class, NonTxnReplayableRef.class, NonTxnReplayableStruct.class, NonTxnReplayableOthers.class);
            PROXY_FACTORY = ProxyFactory.createProxyFactory(TxnReplayableBase.class, TxnReplayableConnection.class, TxnReplayableStatement.class, TxnReplayableResultSet.class, TxnReplayableArray.class, TxnReplayableBfile.class, TxnReplayableBlob.class, TxnReplayableClob.class, TxnReplayableNClob.class, TxnReplayableOpaque.class, TxnReplayableRef.class, TxnReplayableSqlxml.class, TxnReplayableStruct.class, TxnReplayableOthers.class);
         }
      }

      _Copyright_2007_Oracle_All_Rights_Reserved_ = null;
   }
}
