//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package oracle.jdbc.pool;

import java.sql.SQLException;
import java.util.Hashtable;
import java.util.Properties;
import java.util.StringTokenizer;
import javax.naming.Context;
import javax.naming.Name;
import javax.naming.Reference;
import javax.naming.StringRefAddr;
import javax.naming.spi.ObjectFactory;
import oracle.jdbc.driver.DatabaseError;
import oracle.jdbc.internal.OracleConnection;
import oracle.jdbc.xa.client.OracleXADataSource;

public class OracleDataSourceFactory implements ObjectFactory {
    private static final String CONNECTION_CACHING_ENABLED = "connectionCachingEnabled";
    private static final String CONNECTION_CACHE_NAME = "connectionCacheName";
    private static final String CONNECTION_CACHE_PROPERTIES = "connectionCacheProperties";
    private static final String CONNECTION_PROPERTIES = "connectionProperties";
    private static final String FAST_CONNECTION_FAILOVER_ENABLED = "fastConnectionFailoverEnabled";
    private static final String ONS_CONFIG_STR = "onsConfigStr";
    private static final String ORACLE_CONN_DATA_POOL_SOURCE = "oracle.jdbc.pool.OracleConnectionPoolDataSource";
    private static final String ORACLE_OCI_CONN_POOL = "oracle.jdbc.pool.OracleOCIConnectionPool";
    private static final String ORACLE_DATA_SOURCE = "oracle.jdbc.pool.OracleDataSource";
    private static final String ORACLE_XA_DATA_SOURCE = "oracle.jdbc.xa.client.OracleXADataSource";
    private static final String _Copyright_2007_Oracle_All_Rights_Reserved_ = null;
    public static final String BUILD_DATE = "Thu_Apr_04_15:09:24_PDT_2013";
    public static final boolean TRACE = false;

    public OracleDataSourceFactory() {
    }

    public Object getObjectInstance(Object var1, Name var2, Context var3, Hashtable var4) throws Exception {
        Reference var5 = (Reference)var1;
        Object var6 = null;
        String var7 = var5.getClassName();
        Properties var8 = new Properties();
        StringRefAddr var9;
        String var10;
        if (!var7.equals("oracle.jdbc.pool.OracleDataSource") && !var7.equals("oracle.jdbc.xa.client.OracleXADataSource")) {
            if (var7.equals("oracle.jdbc.pool.OracleConnectionPoolDataSource")) {
                var6 = new OracleConnectionPoolDataSource();
            } else {
                if (!var7.equals("oracle.jdbc.pool.OracleOCIConnectionPool")) {
                    return null;
                }

                var6 = new OracleOCIConnectionPool();
                String var19 = null;
                var10 = null;
                String var20 = null;
                String var12 = null;
                String var13 = null;
                String var14 = null;
                String var15 = null;
                StringRefAddr var16 = null;
                Object var17 = null;
                String var18 = null;
                if ((var16 = (StringRefAddr)var5.get("connpool_min_limit")) != null) {
                    var19 = (String)var16.getContent();
                }

                if ((var16 = (StringRefAddr)var5.get("connpool_max_limit")) != null) {
                    var10 = (String)var16.getContent();
                }

                if ((var16 = (StringRefAddr)var5.get("connpool_increment")) != null) {
                    var20 = (String)var16.getContent();
                }

                if ((var16 = (StringRefAddr)var5.get("connpool_active_size")) != null) {
                    var12 = (String)var16.getContent();
                }

                if ((var16 = (StringRefAddr)var5.get("connpool_pool_size")) != null) {
                    var13 = (String)var16.getContent();
                }

                if ((var16 = (StringRefAddr)var5.get("connpool_timeout")) != null) {
                    var14 = (String)var16.getContent();
                }

                if ((var16 = (StringRefAddr)var5.get("connpool_nowait")) != null) {
                    var15 = (String)var16.getContent();
                }

                if ((var16 = (StringRefAddr)var5.get("transactions_distributed")) != null) {
                    var18 = (String)var16.getContent();
                }

                var8.put("connpool_min_limit", var19);
                var8.put("connpool_max_limit", var10);
                var8.put("connpool_increment", var20);
                var8.put("connpool_active_size", var12);
                var8.put("connpool_pool_size", var13);
                var8.put("connpool_timeout", var14);
                if (var15 == "true") {
                    var8.put("connpool_nowait", var15);
                }

                if (var18 == "true") {
                    var8.put("transactions_distributed", var18);
                }
            }
        } else {
            if (var7.equals("oracle.jdbc.pool.OracleDataSource")) {
                var6 = new OracleDataSource();
            } else {
                var6 = new OracleXADataSource();
            }

            var9 = null;
            if ((var9 = (StringRefAddr)var5.get("connectionCachingEnabled")) != null) {
                var10 = (String)var9.getContent();
                if (var10.equals(String.valueOf("true"))) {
                    ((OracleDataSource)var6).setConnectionCachingEnabled(true);
                }
            }

            if ((var9 = (StringRefAddr)var5.get("connectionCacheName")) != null) {
                ((OracleDataSource)var6).setConnectionCacheName((String)var9.getContent());
            }

            Properties var11;
            if ((var9 = (StringRefAddr)var5.get("connectionCacheProperties")) != null) {
                var10 = (String)var9.getContent();
                var11 = this.extractConnectionCacheProperties(var10);
                ((OracleDataSource)var6).setConnectionCacheProperties(var11);
            }

            if ((var9 = (StringRefAddr)var5.get("connectionProperties")) != null) {
                var10 = (String)var9.getContent();
                var11 = this.extractConnectionProperties(var10);
                ((OracleDataSource)var6).setConnectionProperties(var11);
            }

            if ((var9 = (StringRefAddr)var5.get("fastConnectionFailoverEnabled")) != null) {
                var10 = (String)var9.getContent();
                if (var10.equals(String.valueOf("true"))) {
                    ((OracleDataSource)var6).setFastConnectionFailoverEnabled(true);
                }
            }

            if ((var9 = (StringRefAddr)var5.get("onsConfigStr")) != null) {
                ((OracleDataSource)var6).setONSConfiguration((String)var9.getContent());
            }
        }

        if (var6 != null) {
            var9 = null;
            if ((var9 = (StringRefAddr)var5.get("url")) != null) {
                ((OracleDataSource)var6).setURL((String)var9.getContent());
            }

            if ((var9 = (StringRefAddr)var5.get("userName")) != null || (var9 = (StringRefAddr)var5.get("u")) != null || (var9 = (StringRefAddr)var5.get("user")) != null) {
                ((OracleDataSource)var6).setUser((String)var9.getContent());
            }

            if ((var9 = (StringRefAddr)var5.get("passWord")) != null || (var9 = (StringRefAddr)var5.get("password")) != null) {
                ((OracleDataSource)var6).setPassword((String)var9.getContent());
            }

            if ((var9 = (StringRefAddr)var5.get("description")) != null || (var9 = (StringRefAddr)var5.get("describe")) != null) {
                ((OracleDataSource)var6).setDescription((String)var9.getContent());
            }

            if ((var9 = (StringRefAddr)var5.get("driverType")) != null || (var9 = (StringRefAddr)var5.get("driver")) != null) {
                ((OracleDataSource)var6).setDriverType((String)var9.getContent());
            }

            if ((var9 = (StringRefAddr)var5.get("serverName")) != null || (var9 = (StringRefAddr)var5.get("host")) != null) {
                ((OracleDataSource)var6).setServerName((String)var9.getContent());
            }

            if ((var9 = (StringRefAddr)var5.get("databaseName")) != null || (var9 = (StringRefAddr)var5.get("sid")) != null) {
                ((OracleDataSource)var6).setDatabaseName((String)var9.getContent());
            }

            if ((var9 = (StringRefAddr)var5.get("serviceName")) != null) {
                ((OracleDataSource)var6).setServiceName((String)var9.getContent());
            }

            if ((var9 = (StringRefAddr)var5.get("networkProtocol")) != null || (var9 = (StringRefAddr)var5.get("protocol")) != null) {
                ((OracleDataSource)var6).setNetworkProtocol((String)var9.getContent());
            }

            if ((var9 = (StringRefAddr)var5.get("portNumber")) != null || (var9 = (StringRefAddr)var5.get("port")) != null) {
                var10 = (String)var9.getContent();
                ((OracleDataSource)var6).setPortNumber(Integer.parseInt(var10));
            }

            if ((var9 = (StringRefAddr)var5.get("tnsentryname")) == null && (var9 = (StringRefAddr)var5.get("tns")) == null) {
                if (var7.equals("oracle.jdbc.pool.OracleOCIConnectionPool")) {
                    var10 = null;
                    if ((var9 = (StringRefAddr)var5.get("connpool_is_poolcreated")) != null) {
                        var10 = (String)var9.getContent();
                    }

                    if (var10.equals(String.valueOf("true"))) {
                        ((OracleOCIConnectionPool)var6).setPoolConfig(var8);
                    }
                }
            } else {
                ((OracleDataSource)var6).setTNSEntryName((String)var9.getContent());
            }
        }

        return var6;
    }

    private Properties extractConnectionCacheProperties(String var1) throws SQLException {
        Properties var2 = new Properties();
        var1 = var1.substring(1, var1.length() - 1);
        int var3 = var1.indexOf("AttributeWeights", 0);
        String var6;
        String var9;
        String var10;
        if (var3 >= 0) {
            if (var1.charAt(var3 + 16) != '=' || var3 > 0 && var1.charAt(var3 - 1) != ' ') {
                SQLException var20 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 139);
                var20.fillInStackTrace();
                throw var20;
            }

            Properties var4 = new Properties();
            int var5 = var1.indexOf("}", var3);
            var6 = var1.substring(var3, var5);
            String var7 = var6.substring(18);
            StringTokenizer var8 = new StringTokenizer(var7, ", ");
            synchronized(var8) {
                while(var8.hasMoreTokens()) {
                    var10 = var8.nextToken();
                    int var11 = var10.length();
                    int var12 = var10.indexOf("=");
                    String var13 = var10.substring(0, var12);
                    String var14 = var10.substring(var12 + 1, var11);
                    var4.setProperty(var13, var14);
                }
            }

            var2.put("AttributeWeights", var4);
            if (var3 > 0 && var5 + 1 == var1.length()) {
                var1 = var1.substring(0, var3 - 2);
            } else if (var3 > 0 && var5 + 1 < var1.length()) {
                var9 = var1.substring(0, var3 - 2);
                var10 = var1.substring(var5 + 1, var1.length());
                var1 = var9.concat(var10);
            } else {
                var1 = var1.substring(var5 + 2, var1.length());
            }
        }

        StringTokenizer var19 = new StringTokenizer(var1, ", ");
        synchronized(var19) {
            while(var19.hasMoreTokens()) {
                var6 = var19.nextToken();
                int var21 = var6.length();
                int var22 = var6.indexOf("=");
                var9 = var6.substring(0, var22);
                var10 = var6.substring(var22 + 1, var21);
                var2.setProperty(var9, var10);
            }

            return var2;
        }
    }

    private Properties extractConnectionProperties(String var1) throws SQLException {
        Properties var2 = new Properties();
        var1 = var1.substring(1, var1.length() - 1);
        String[] var3 = var1.split(";");
        String[] var4 = var3;
        int var5 = var3.length;

        for(int var6 = 0; var6 < var5; ++var6) {
            String var7 = var4[var6];
            int var8 = var7.length();
            int var9 = var7.indexOf("=");
            if (var8 == 0 || var9 <= 0) {
                SQLException var12 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 190);
                var12.fillInStackTrace();
                throw var12;
            }

            String var10 = var7.substring(0, var9);
            String var11 = var7.substring(var9 + 1, var8);
            var2.setProperty(var10.trim(), var11.trim());
        }

        return var2;
    }

    protected OracleConnection getConnectionDuringExceptionHandling() {
        return null;
    }
}
