package oracle.jdbc.replay;

import java.sql.SQLException;
import java.util.Properties;
import javax.sql.DataSource;

public interface OracleDataSource extends DataSource {
   String USER = "user";
   String URL = "url";
   String PASSWORD = "password";
   String SERVER_NAME = "serverName";
   String PORT_NUMBER = "portNumber";
   String DATABASE_NAME = "databaseName";
   String DATA_SOURCE_NAME = "dataSourceName";
   String DESCRIPTION = "description";
   String NETWORK_PROTOCOL = "networkProtocol";
   String ROLE_NAME = "roleName";
   String CONNECTION_PROPERTIES = "connectionProperties";
   String MAX_STATEMENTS = "maxStatements";
   String IMPLICIT_CACHING_ENABLED = "implicitCachingEnabled";
   String EXPLICIT_CACHING_ENABLED = "explicitCachingEnabled";

   void setURL(String var1) throws SQLException;

   String getURL();

   void setUser(String var1) throws SQLException;

   String getUser();

   void setPassword(String var1) throws SQLException;

   String getPassword();

   void setServerName(String var1) throws SQLException;

   String getServerName();

   void setPortNumber(int var1) throws SQLException;

   int getPortNumber();

   void setDatabaseName(String var1) throws SQLException;

   String getDatabaseName();

   void setDataSourceName(String var1) throws SQLException;

   String getDataSourceName();

   void setDescription(String var1) throws SQLException;

   String getDescription();

   void setNetworkProtocol(String var1) throws SQLException;

   String getNetworkProtocol();

   void setRoleName(String var1) throws SQLException;

   String getRoleName();

   void registerConnectionInitializationCallback(oracle.jdbc.replay.internal.ConnectionInitializationCallback var1) throws SQLException;

   void unregisterConnectionInitializationCallback(oracle.jdbc.replay.internal.ConnectionInitializationCallback var1) throws SQLException;

   oracle.jdbc.replay.internal.ConnectionInitializationCallback getConnectionInitializationCallback();

   Properties getConnectionProperties();

   String getConnectionProperty(String var1);

   void setConnectionProperty(String var1, String var2) throws SQLException;

   void setConnectionProperties(Properties var1) throws SQLException;

   void setMaxStatements(int var1) throws SQLException;

   int getMaxStatements() throws SQLException;

   void setImplicitCachingEnabled(boolean var1) throws SQLException;

   boolean getImplicitCachingEnabled() throws SQLException;

   void setExplicitCachingEnabled(boolean var1) throws SQLException;

   boolean getExplicitCachingEnabled() throws SQLException;
}
