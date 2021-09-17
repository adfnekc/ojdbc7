//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package oracle.jdbc.xa.client;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;
import javax.sql.PooledConnection;
import javax.sql.XAConnection;
import javax.transaction.xa.XAException;
import oracle.jdbc.OracleConnection;
import oracle.jdbc.driver.DatabaseError;
import oracle.jdbc.driver.T2CConnection;
import oracle.jdbc.driver.T4CXAConnection;

public class OracleXADataSource extends oracle.jdbc.xa.OracleXADataSource {
    private static final boolean DEBUG = false;
    private int rmid = -1;
    private String xaOpenString = null;
    private static boolean libraryLoaded = false;
    private static final String dbSuffix = "HeteroXA";
    private static final String dllName = "heteroxa12";
    private static final char atSignChar = '@';
    private static int rmidSeed = 0;
    private static final int MAX_RMID_SEED = 65536;
    private String driverCharSetIdString = null;
    private String oldTnsEntry = null;
    private static final String _Copyright_2007_Oracle_All_Rights_Reserved_ = null;
    public static final String BUILD_DATE = "Thu_Apr_04_15:09:24_PDT_2013";
    public static final boolean TRACE = false;

    public OracleXADataSource() throws SQLException {
        this.isOracleDataSource = true;
    }

    public XAConnection getXAConnection() throws SQLException {
        Properties var1 = new Properties(this.connectionProperties);
        if (this.user != null && this.password != null) {
            var1.setProperty("user", this.user);
            var1.setProperty("password", this.password);
        }

        return this.getXAConnection(var1);
    }

    public XAConnection getXAConnection(String var1, String var2) throws SQLException {
        Properties var3 = new Properties(this.connectionProperties);
        if (var1 != null && var2 != null) {
            var3.setProperty("user", var1);
            var3.setProperty("password", var2);
            return this.getXAConnection(var3);
        } else {
            SQLException var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 68);
            var4.fillInStackTrace();
            throw var4;
        }
    }

    public XAConnection getXAConnection(Properties var1) throws SQLException {
        if (this.connCachingEnabled) {
            SQLException var2 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 163);
            var2.fillInStackTrace();
            throw var2;
        } else {
            return (XAConnection)this.getPooledConnection(var1);
        }
    }

    public PooledConnection getPooledConnection(String var1, String var2) throws SQLException {
        Properties var3 = new Properties();
        var3.setProperty("user", var1);
        var3.setProperty("password", var2);
        return this.getPooledConnection(var3);
    }

    public PooledConnection getPooledConnection(Properties var1) throws SQLException {
        try {
            String var2 = this.getURL();
            String var3 = var1.getProperty("user");
            String var4 = var1.getProperty("password");
            String var5 = null;
            String var6 = null;
            String var7 = null;
            boolean var8 = false;
            String var11;
            if (!this.useNativeXA || !var2.startsWith("jdbc:oracle:oci8") && !var2.startsWith("jdbc:oracle:oci")) {
                Properties var32;
                if (this.useNativeXA && var2.startsWith("jdbc:oracle:thin")) {
                    var32 = new Properties();
                    synchronized(this) {
                        Class var35 = OracleXADataSource.class;
                        synchronized(OracleXADataSource.class) {
                            rmidSeed = (rmidSeed + 1) % 65536;
                            this.rmid = rmidSeed;
                        }

                        if (this.connectionProperties == null) {
                            this.connectionProperties = new Properties();
                        }

                        this.connectionProperties.put("RessourceManagerId", Integer.toString(this.rmid));
                        if (var3 != null) {
                            var32.setProperty("user", var3);
                        }

                        if (var4 != null) {
                            var32.setProperty("password", var4);
                        }

                        var32.setProperty("stmt_cache_size", "" + this.maxStatements);
                        var32.setProperty("ImplicitStatementCachingEnabled", "" + this.implicitCachingEnabled);
                        var32.setProperty("ExplicitStatementCachingEnabled", "" + this.explicitCachingEnabled);
                        if (this.loginTimeout != 0) {
                            var32.setProperty("LoginTimeout", "" + this.loginTimeout);
                        }
                    }

                    T4CXAConnection var34 = new T4CXAConnection(super.getPhysicalConnection(var32));
                    if (var3 != null && var4 != null) {
                        var34.setUserName(var3, var4);
                    }

                    var11 = this.connectionProperties != null ? this.connectionProperties.getProperty("oracle.jdbc.XATransLoose") : null;
                    var34.isXAResourceTransLoose = var11 != null && (var11.equals("true") || var11.equalsIgnoreCase("true"));
                    return var34;
                } else {
                    var32 = new Properties();
                    synchronized(this) {
                        if (var3 != null) {
                            var32.setProperty("user", var3);
                        }

                        if (var4 != null) {
                            var32.setProperty("password", var4);
                        }

                        var32.setProperty("stmt_cache_size", "" + this.maxStatements);
                        var32.setProperty("ImplicitStatementCachingEnabled", "" + this.implicitCachingEnabled);
                        var32.setProperty("ExplicitStatementCachingEnabled", "" + this.explicitCachingEnabled);
                        if (this.loginTimeout != 0) {
                            var32.setProperty("LoginTimeout", "" + this.loginTimeout);
                        }
                    }

                    OracleXAConnection var33 = new OracleXAConnection(super.getPhysicalConnection(var32));
                    if (var3 != null && var4 != null) {
                        var33.setUserName(var3, var4);
                    }

                    var11 = this.connectionProperties != null ? this.connectionProperties.getProperty("oracle.jdbc.XATransLoose") : null;
                    var33.isXAResourceTransLoose = var11 != null && (var11.equals("true") || var11.equalsIgnoreCase("true"));
                    return var33;
                }
            } else {
                long[] var9 = new long[]{0L, 0L};
                String var10 = null;
                var11 = null;
                Class var13;
                SQLException var39;
                synchronized(this) {
                    if (this.tnsEntry != null) {
                        var10 = this.tnsEntry;
                    } else {
                        var10 = this.getTNSEntryFromUrl(var2);
                    }

                    if (var10 != null && var10.length() == 0 || var10.startsWith("(DESCRIPTION")) {
                        var39 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 207);
                        var39.fillInStackTrace();
                        throw var39;
                    }

                    if (!libraryLoaded) {
                        var13 = OracleXADataSource.class;
                        synchronized(OracleXADataSource.class) {
                            if (!libraryLoaded) {
                                try {
                                    System.loadLibrary("heteroxa12");
                                    libraryLoaded = true;
                                } catch (Error var23) {
                                    libraryLoaded = false;
                                    throw var23;
                                }
                            }
                        }
                    }

                    if (this.connectionProperties != null) {
                        var11 = this.connectionProperties.getProperty("oracle.jdbc.ociNlsLangBackwardCompatible");
                    }
                }

                short var12;
                if (var11 != null && var11.equalsIgnoreCase("true")) {
                    var12 = T2CConnection.getDriverCharSetIdFromNLS_LANG((String)null);
                    this.driverCharSetIdString = Integer.toString(var12);
                } else if (!var10.equals(this.oldTnsEntry)) {
                    var12 = T2CConnection.getClientCharSetId();
                    this.driverCharSetIdString = Integer.toString(var12);
                    this.oldTnsEntry = var10;
                }

                int var31;
                synchronized(this) {
                    var5 = this.databaseName + "HeteroXA" + rmidSeed;
                    this.rmid = var31 = rmidSeed;
                    var13 = OracleXADataSource.class;
                    synchronized(OracleXADataSource.class) {
                        rmidSeed = (rmidSeed + 1) % 65536;
                    }

                    byte var37 = 0;
                    String var14 = this.connectionProperties != null ? this.connectionProperties.getProperty("oracle.jdbc.XATransLoose") : null;
                    this.xaOpenString = var7 = this.generateXAOpenString(var5, var10, var3, var4, 60, 2000, true, true, ".", var37, false, var14 != null && var14.equalsIgnoreCase("true"), this.driverCharSetIdString, this.driverCharSetIdString);
                    var6 = this.generateXACloseString(var5, false);
                }

                int var36 = this.t2cDoXaOpen(var7, var31, 0, 0);
                if (var36 != 0) {
                    var39 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), -1 * var36);
                    var39.fillInStackTrace();
                    throw var39;
                } else {
                    var36 = this.t2cConvertOciHandles(var5, var9);
                    if (var36 != 0) {
                        var39 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), -1 * var36);
                        var39.fillInStackTrace();
                        throw var39;
                    } else {
                        var1.put("OCISvcCtxHandle", String.valueOf(var9[0]));
                        var1.put("OCIEnvHandle", String.valueOf(var9[1]));
                        var1.put("JDBCDriverCharSetId", this.driverCharSetIdString);
                        if (this.loginTimeout != 0) {
                            var1.put("oracle.net.CONNECT_TIMEOUT", "" + this.loginTimeout * 1000);
                        }

                        Connection var38 = this.driver.connect(this.getURL(), var1);
                        ((OracleConnection)var38).setStatementCacheSize(this.maxStatements);
                        ((OracleConnection)var38).setExplicitCachingEnabled(this.explicitCachingEnabled);
                        ((OracleConnection)var38).setImplicitCachingEnabled(this.implicitCachingEnabled);
                        if (this.maxStatements > 0 && !this.explicitCachingEnabled && !this.implicitCachingEnabled) {
                            ((OracleConnection)var38).setImplicitCachingEnabled(true);
                            ((OracleConnection)var38).setExplicitCachingEnabled(true);
                        }

                        OracleXAHeteroConnection var40 = new OracleXAHeteroConnection(var38);
                        if (var3 != null && var4 != null) {
                            var40.setUserName(var3, var4);
                        }

                        var40.setRmid(var31);
                        var40.setXaCloseString(var6);
                        var40.registerCloseCallback(new OracleXAHeteroCloseCallback(), var40);
                        return var40;
                    }
                }
            }
        } catch (XAException var30) {
            return null;
        }
    }

    private native int t2cDoXaOpen(String var1, int var2, int var3, int var4);

    private native int t2cConvertOciHandles(String var1, long[] var2);

    synchronized void setRmid(int var1) {
        this.rmid = var1;
    }

    synchronized int getRmid() {
        return this.rmid;
    }

    synchronized void setXaOpenString(String var1) {
        this.xaOpenString = var1;
    }

    synchronized String getXaOpenString() {
        return this.xaOpenString;
    }

    private String generateXAOpenString(String var1, String var2, String var3, String var4, int var5, int var6, boolean var7, boolean var8, String var9, int var10, boolean var11, boolean var12, String var13, String var14) {
        return "ORACLE_XA+DB=" + var1 + "+ACC=P/" + var3 + "/" + var4 + "+SESTM=" + var6 + "+SESWT=" + var5 + "+LOGDIR=" + var9 + "+SQLNET=" + var2 + (var7 ? "+THREADS=true" : "") + (var8 ? "+OBJECTS=true" : "") + "+DBGFL=0x" + var10 + (var11 ? "+CONNCACHE=t" : "+CONNCACHE=f") + (var12 ? "+Loose_Coupling=t" : "") + "+CharSet=" + var13 + "+NCharSet=" + var14;
    }

    private String generateXACloseString(String var1, boolean var2) {
        return "ORACLE_XA+DB=" + var1 + (var2 ? "+CONNCACHE=t" : "+CONNCACHE=f");
    }

    private String getTNSEntryFromUrl(String var1) {
        int var2 = var1.indexOf(64);
        return var1.substring(var2 + 1);
    }
}
