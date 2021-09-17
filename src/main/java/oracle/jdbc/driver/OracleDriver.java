//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package oracle.jdbc.driver;

import java.io.IOException;
import java.io.InputStream;
import java.lang.management.ManagementFactory;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.DriverPropertyInfo;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.sql.Timestamp;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Map;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.management.InstanceAlreadyExistsException;
import javax.management.InstanceNotFoundException;
import javax.management.JMException;
import javax.management.MBeanServer;
import javax.management.ObjectName;
import oracle.jdbc.OracleDatabaseMetaData;
import oracle.jdbc.babelfish.BabelfishCallableStatement;
import oracle.jdbc.babelfish.BabelfishConnection;
import oracle.jdbc.babelfish.BabelfishGenericProxy;
import oracle.jdbc.babelfish.BabelfishPreparedStatement;
import oracle.jdbc.babelfish.BabelfishStatement;
import oracle.jdbc.babelfish.TranslationManager;
import oracle.jdbc.babelfish.Translator;
import oracle.jdbc.internal.OracleConnection;
import oracle.jdbc.proxy.ProxyFactory;
import oracle.security.pki.OraclePKIProvider;

public class OracleDriver implements Driver {
    public static final String oracle_string = "oracle";
    public static final String jdbc_string = "jdbc";
    public static final String protocol_string = "protocol";
    public static final String user_string = "user";
    public static final String password_string = "password";
    public static final String database_string = "database";
    public static final String server_string = "server";
    /** @deprecated */
    public static final String access_string = "access";
    /** @deprecated */
    public static final String protocolFullName_string = "protocolFullName";
    public static final String logon_as_internal_str = "internal_logon";
    public static final String proxy_client_name = "oracle.jdbc.proxyClientName";
    public static final String prefetch_string = "prefetch";
    public static final String row_prefetch_string = "rowPrefetch";
    public static final String default_row_prefetch_string = "defaultRowPrefetch";
    public static final String batch_string = "batch";
    public static final String execute_batch_string = "executeBatch";
    public static final String default_execute_batch_string = "defaultExecuteBatch";
    public static final String process_escapes_string = "processEscapes";
    public static final String accumulate_batch_result = "AccumulateBatchResult";
    public static final String j2ee_compliance = "oracle.jdbc.J2EE13Compliant";
    public static final String v8compatible_string = "V8Compatible";
    public static final String permit_timestamp_date_mismatch_string = "oracle.jdbc.internal.permitBindDateDefineTimestampMismatch";
    public static final String prelim_auth_string = "prelim_auth";
    public static final String SetFloatAndDoubleUseBinary_string = "SetFloatAndDoubleUseBinary";
    /** @deprecated */
    public static final String xa_trans_loose = "oracle.jdbc.XATransLoose";
    public static final String tcp_no_delay = "oracle.jdbc.TcpNoDelay";
    public static final String read_timeout = "oracle.jdbc.ReadTimeout";
    public static final String defaultnchar_string = "oracle.jdbc.defaultNChar";
    public static final String defaultncharprop_string = "defaultNChar";
    public static final String useFetchSizeWithLongColumn_prop_string = "useFetchSizeWithLongColumn";
    public static final String useFetchSizeWithLongColumn_string = "oracle.jdbc.useFetchSizeWithLongColumn";
    public static final String remarks_string = "remarks";
    public static final String report_remarks_string = "remarksReporting";
    public static final String synonyms_string = "synonyms";
    public static final String include_synonyms_string = "includeSynonyms";
    public static final String restrict_getTables_string = "restrictGetTables";
    public static final String fixed_string_string = "fixedString";
    public static final String dll_string = "oracle.jdbc.ocinativelibrary";
    public static final String nls_lang_backdoor = "oracle.jdbc.ociNlsLangBackwardCompatible";
    public static final String disable_defineColumnType_string = "disableDefineColumnType";
    public static final String convert_nchar_literals_string = "oracle.jdbc.convertNcharLiterals";
    public static final String dataSizeUnitsPropertyName = "";
    public static final String dataSizeBytes = "";
    public static final String dataSizeChars = "";
    public static final String set_new_password_string = "OCINewPassword";
    public static final String retain_v9_bind_behavior_string = "oracle.jdbc.RetainV9LongBindBehavior";
    public static final String no_caching_buffers = "oracle.jdbc.FreeMemoryOnEnterImplicitCache";
    static final int EXTENSION_TYPE_ORACLE_ERROR = -3;
    static final int EXTENSION_TYPE_GEN_ERROR = -2;
    static final int EXTENSION_TYPE_TYPE4_CLIENT = 0;
    static final int EXTENSION_TYPE_TYPE4_SERVER = 1;
    static final int EXTENSION_TYPE_TYPE2_CLIENT = 2;
    static final int EXTENSION_TYPE_TYPE2_SERVER = 3;
    private static final int NUMBER_OF_EXTENSION_TYPES = 4;
    private OracleDriverExtension[] driverExtensions = new OracleDriverExtension[4];
    private static final String DRIVER_PACKAGE_STRING = "driver";
    private static final String[] driverExtensionClassNames = new String[]{"oracle.jdbc.driver.T4CDriverExtension", "oracle.jdbc.driver.T4CDriverExtension", "oracle.jdbc.driver.T2CDriverExtension", "oracle.jdbc.driver.T2SDriverExtension"};
    private static Properties driverAccess;
    protected static Connection defaultConn = null;
    private static OracleDriver defaultDriver = null;
    public static final Map<String, Class> systemTypeMap;
    private static final String DEFAULT_CONNECTION_PROPERTIES_RESOURCE_NAME = "/oracle/jdbc/defaultConnectionProperties.properties";
    protected static final Properties DEFAULT_CONNECTION_PROPERTIES;
    private static ObjectName diagnosticMBeanObjectName;
    private static final String _Copyright_2007_Oracle_All_Rights_Reserved_;
    public static final String BUILD_DATE = "Thu_Apr_04_15:09:24_PDT_2013";
    public static final boolean TRACE = false;

    public OracleDriver() {
    }

    public static void registerMBeans() {
        try {
            MBeanServer var0 = null;

            try {
                Class var1 = Class.forName("oracle.as.jmx.framework.PortableMBeanFactory");
                Object var2 = var1.newInstance();
                Method var3 = var1.getMethod("getMBeanServer");
                var0 = (MBeanServer)var3.invoke(var2);
            } catch (NoClassDefFoundError var6) {
                var0 = ManagementFactory.getPlatformMBeanServer();
            } catch (ClassNotFoundException var7) {
                var0 = ManagementFactory.getPlatformMBeanServer();
            } catch (NoSuchMethodException var8) {
                Logger.getLogger("oracle.jdbc").log(Level.WARNING, "Found Oracle Apps MBeanServer but not the getMBeanServer method.", var8);
                var0 = ManagementFactory.getPlatformMBeanServer();
            } catch (InstantiationException var9) {
                Logger.getLogger("oracle.jdbc").log(Level.WARNING, "Found Oracle Apps MBeanServer but could not create an instance.", var9);
                var0 = ManagementFactory.getPlatformMBeanServer();
            } catch (IllegalAccessException var10) {
                Logger.getLogger("oracle.jdbc").log(Level.WARNING, "Found Oracle Apps MBeanServer but could not access the getMBeanServer method.", var10);
                var0 = ManagementFactory.getPlatformMBeanServer();
            } catch (InvocationTargetException var11) {
                Logger.getLogger("oracle.jdbc").log(Level.WARNING, "Found Oracle Apps MBeanServer but the getMBeanServer method threw an exception.", var11);
                var0 = ManagementFactory.getPlatformMBeanServer();
            }

            if (var0 != null) {
                ClassLoader var15 = OracleDriver.class.getClassLoader();
                String var16 = var15 == null ? "nullLoader" : var15.getClass().getName();
                int var17 = 0;

                while(true) {
                    String var4 = var16 + "@" + Integer.toHexString((var15 == null ? 0 : var15.hashCode()) + var17++);
                    diagnosticMBeanObjectName = new ObjectName("com.oracle.jdbc:type=diagnosability,name=" + var4);

                    try {
                        var0.registerMBean(new OracleDiagnosabilityMBean(), diagnosticMBeanObjectName);
                        break;
                    } catch (InstanceAlreadyExistsException var12) {
                    }
                }
            } else {
                Logger.getLogger("oracle.jdbc").log(Level.WARNING, "Unable to find an MBeanServer so no MBears are registered.");
            }
        } catch (JMException var13) {
            Logger.getLogger("oracle.jdbc").log(Level.WARNING, "Error while registering Oracle JDBC Diagnosability MBean.", var13);
        } catch (Throwable var14) {
            Logger.getLogger("oracle.jdbc").log(Level.WARNING, "Error while registering Oracle JDBC Diagnosability MBean.", var14);
        }

    }

    public Connection connect(String var1, Properties var2) throws SQLException {
        if (var1.regionMatches(0, "jdbc:default:connection", 0, 23)) {
            String var3 = "jdbc:oracle:kprb";
            int var4 = var1.length();
            if (var4 > 23) {
                var1 = var3.concat(var1.substring(23, var1.length()));
            } else {
                var1 = var3.concat(":");
            }

            var3 = null;
        }

        int var10 = oracleDriverExtensionTypeFromURL(var1);
        if (var10 == -2) {
            return null;
        } else if (var10 == -3) {
            SQLException var13 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 67);
            var13.fillInStackTrace();
            throw var13;
        } else {
            OracleDriverExtension var11 = null;
            var11 = this.driverExtensions[var10];
            SQLException var6;
            if (var11 == null) {
                try {
                    synchronized(this) {
                        if (var11 == null) {
                            var11 = (OracleDriverExtension)Class.forName(driverExtensionClassNames[var10]).newInstance();
                            this.driverExtensions[var10] = var11;
                        } else {
                            var11 = this.driverExtensions[var10];
                        }
                    }
                } catch (Exception var9) {
                    var6 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), var9);
                    var6.fillInStackTrace();
                    throw var6;
                }
            }

            if (var2 == null) {
                var2 = new Properties();
            }

            Enumeration var5 = DriverManager.getDrivers();

            Driver var12;
            while(var5.hasMoreElements()) {
                var12 = (Driver)((Driver)var5.nextElement());
                if (var12 instanceof OracleDriver) {
                    break;
                }
            }

            while(var5.hasMoreElements()) {
                var12 = (Driver)((Driver)var5.nextElement());
                if (var12 instanceof OracleDriver) {
                    DriverManager.deregisterDriver(var12);
                }
            }

            var6 = null;
            Object var14;
            if (var10 == 2 && var2.containsKey("connection_pool") && var2.getProperty("connection_pool").equals("connection_pool")) {
                var14 = (PhysicalConnection)var11.getConnection(var1, var2);
                ((PhysicalConnection)var14).protocolId = var10;
            } else {
                String var7 = null;
                if (var2 != null) {
                    var7 = var2.getProperty("oracle.jdbc.sqlTranslationProfile");
                }

                if (var7 == null) {
                    var7 = PhysicalConnection.getSqlTranslationProfile();
                }

                if (var7 != null) {
                    var14 = this.babelfishConnect(var2, var7, var1, var11, var10);
                } else {
                    var14 = (PhysicalConnection)var11.getConnection(var1, var2);
                    ((PhysicalConnection)var14).protocolId = var10;
                }
            }

            return (Connection)var14;
        }
    }

    private Connection babelfishConnect(Properties var1, String var2, String var3, OracleDriverExtension var4, int var5) throws SQLException {
        var1.put("oracle.jdbc.sqlTranslationProfile", var2);
        var2 = null;
        if (var1 != null) {
            var2 = var1.getProperty("oracle.jdbc.sqlErrorTranslationFile");
        }

        if (var2 == null) {
            var2 = System.getProperty("oracle.jdbc.sqlErrorTranslationFile", (String)null);
        }

        if (var2 != null) {
            var1.put("oracle.jdbc.sqlErrorTranslationFile", var2);
        }

        var2 = null;
        if (var1 != null) {
            var2 = var1.getProperty("user");
            if (var2 == null) {
                var2 = var1.getProperty("oracle.jdbc.user");
            }
        }

        if (var2 == null) {
            var2 = System.getProperty("oracle.jdbc.user", (String)null);
        }

        if (var2 == null) {
            Hashtable var6 = PhysicalConnection.parseUrl(var3, (String)null, (String)null);
            var2 = (String)var6.get("user");
        }

        var1.put("user", var2);
        ProxyFactory var11 = ProxyFactory.createJDBCProxyFactory(new Class[]{BabelfishGenericProxy.class, BabelfishConnection.class, BabelfishStatement.class, BabelfishPreparedStatement.class, BabelfishCallableStatement.class});
        Translator var7 = TranslationManager.getTranslator(var3, var1.getProperty("user"), var1.getProperty("oracle.jdbc.sqlTranslationProfile"), var1.getProperty("oracle.jdbc.sqlErrorTranslationFile"));

        try {
            PhysicalConnection var8 = (PhysicalConnection)var4.getConnection(var3, var1);
            var8.protocolId = var5;
            Connection var9 = (Connection)var11.proxyFor(var8);
            ((BabelfishConnection)var9).setTranslator(var7);
            var7.activateServerTranslation(var8);
            return var9;
        } catch (SQLException var10) {
            throw var7.translateError(var10);
        }
    }

    public Connection defaultConnection() throws SQLException {
        if (defaultConn == null || defaultConn.isClosed()) {
            Class var1 = OracleDriver.class;
            synchronized(OracleDriver.class) {
                if (defaultConn == null || defaultConn.isClosed()) {
                    defaultConn = this.connect("jdbc:oracle:kprb:", new Properties());
                }
            }
        }

        return defaultConn;
    }

    static final int oracleDriverExtensionTypeFromURL(String var0) {
        int var1 = var0.indexOf(58);
        if (var1 == -1) {
            return -2;
        } else if (!var0.regionMatches(true, 0, "jdbc", 0, var1)) {
            return -2;
        } else {
            ++var1;
            int var2 = var0.indexOf(58, var1);
            if (var2 == -1) {
                return -2;
            } else if (!var0.regionMatches(true, var1, "oracle", 0, var2 - var1)) {
                return -2;
            } else {
                ++var2;
                int var3 = var0.indexOf(58, var2);
                String var4 = null;
                if (var3 == -1) {
                    return -3;
                } else {
                    var4 = var0.substring(var2, var3);
                    if (var4.equals("thin")) {
                        return 0;
                    } else {
                        return !var4.equals("oci8") && !var4.equals("oci") ? -3 : 2;
                    }
                }
            }
        }
    }

    public boolean acceptsURL(String var1) {
        if (var1.startsWith("jdbc:oracle:")) {
            return oracleDriverExtensionTypeFromURL(var1) > -2;
        } else {
            return false;
        }
    }

    public DriverPropertyInfo[] getPropertyInfo(String var1, Properties var2) throws SQLException {
        Class var3 = null;

        try {
            var3 = Class.forName("oracle.jdbc.OracleConnection");
        } catch (ClassNotFoundException var16) {
        }

        int var4 = 0;
        String[] var5 = new String[150];
        String[] var6 = new String[150];
        Field[] var7 = var3.getFields();

        for(int var8 = 0; var8 < var7.length; ++var8) {
            if (var7[var8].getName().startsWith("CONNECTION_PROPERTY_") && !var7[var8].getName().endsWith("_DEFAULT") && !var7[var8].getName().endsWith("_ACCESSMODE")) {
                try {
                    String var9 = (String)var7[var8].get((Object)null);
                    Field var10 = var3.getField(var7[var8].getName() + "_DEFAULT");
                    String var11 = (String)var10.get((Object)null);
                    if (var4 == var5.length) {
                        String[] var12 = new String[var5.length * 2];
                        String[] var13 = new String[var5.length * 2];
                        System.arraycopy(var5, 0, var12, 0, var5.length);
                        System.arraycopy(var6, 0, var13, 0, var5.length);
                        var5 = var12;
                        var6 = var13;
                    }

                    var5[var4] = var9;
                    var6[var4] = var11;
                    ++var4;
                } catch (IllegalAccessException var14) {
                } catch (NoSuchFieldException var15) {
                }
            }
        }

        DriverPropertyInfo[] var17 = new DriverPropertyInfo[var4];

        for(int var18 = 0; var18 < var4; ++var18) {
            var17[var18] = new DriverPropertyInfo(var5[var18], var6[var18]);
        }

        return var17;
    }

    public int getMajorVersion() {
        return OracleDatabaseMetaData.getDriverMajorVersionInfo();
    }

    public int getMinorVersion() {
        return OracleDatabaseMetaData.getDriverMinorVersionInfo();
    }

    public boolean jdbcCompliant() {
        return true;
    }

    public String processSqlEscapes(String var1) throws SQLException {
        OracleSql var2 = new OracleSql((DBConversion)null);
        var2.initialize(var1);
        return var2.parse(var1);
    }

    public static String getCompileTime() {
        return "Thu_Apr_04_15:09:24_PDT_2013";
    }

    public static String getSystemPropertyFastConnectionFailover(String var0) {
        return PhysicalConnection.getSystemPropertyFastConnectionFailover(var0);
    }

    protected OracleConnection getConnectionDuringExceptionHandling() {
        return null;
    }

    public Logger getParentLogger() throws SQLFeatureNotSupportedException {
        return Logger.getLogger("oracle");
    }

    protected void finalize() throws Throwable {
        if (diagnosticMBeanObjectName != null) {
            try {
                MBeanServer var1 = null;

                try {
                    Class var2 = Class.forName("oracle.as.jmx.framework.PortableMBeanFactory");
                    Object var3 = var2.newInstance();
                    Method var4 = var2.getMethod("getMBeanServer");
                    var1 = (MBeanServer)var4.invoke(var3);
                } catch (Throwable var6) {
                    var1 = ManagementFactory.getPlatformMBeanServer();
                }

                if (var1 != null) {
                    try {
                        var1.unregisterMBean(diagnosticMBeanObjectName);
                    } catch (InstanceNotFoundException var5) {
                    }
                } else {
                    Logger.getLogger("oracle.jdbc").log(Level.WARNING, "Unable to find an MBeanServer so no MBeans are unregistered.");
                }
            } catch (Throwable var7) {
                Logger.getLogger("oracle.jdbc").log(Level.WARNING, "Error while unregistering Oracle JDBC Diagnosability MBean.", var7);
            }
        }

    }

    static {
        try {
            if (defaultDriver == null) {
                defaultDriver = new oracle.jdbc.OracleDriver();
                DriverManager.registerDriver(defaultDriver);
            }

            AccessController.doPrivileged(new PrivilegedAction() {
                public Object run() {
                    OracleDriver.registerMBeans();
                    return null;
                }
            });
            Timestamp var0 = Timestamp.valueOf("2000-01-01 00:00:00.0");
        } catch (SQLException var4) {
            Logger.getLogger("oracle.jdbc.driver").log(Level.SEVERE, "SQLException in static block.", var4);
        } catch (RuntimeException var5) {
            Logger.getLogger("oracle.jdbc.driver").log(Level.SEVERE, "RuntimeException in static block.", var5);
        }

        try {
            new OraclePKIProvider();
        } catch (Throwable var3) {
        }

        systemTypeMap = new Hashtable(2);

        try {
            systemTypeMap.put("SYS.ANYDATA", Class.forName("oracle.sql.AnyDataFactory"));
            systemTypeMap.put("SYS.ANYTYPE", Class.forName("oracle.sql.TypeDescriptorFactory"));
        } catch (ClassNotFoundException var2) {
        }

        DEFAULT_CONNECTION_PROPERTIES = new Properties();

        try {
            InputStream var6 = PhysicalConnection.class.getResourceAsStream("/oracle/jdbc/defaultConnectionProperties.properties");
            if (var6 != null) {
                DEFAULT_CONNECTION_PROPERTIES.load(var6);
            }
        } catch (IOException var1) {
        }

        diagnosticMBeanObjectName = null;
        _Copyright_2007_Oracle_All_Rights_Reserved_ = null;
    }
}
