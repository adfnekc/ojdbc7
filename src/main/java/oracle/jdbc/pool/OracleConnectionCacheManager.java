//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package oracle.jdbc.pool;

import java.io.UnsupportedEncodingException;
import java.security.AccessController;
import java.security.PrivilegedActionException;
import java.security.PrivilegedExceptionAction;
import java.sql.SQLException;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;
import java.util.StringTokenizer;
import java.util.concurrent.atomic.AtomicInteger;
import javax.sql.ConnectionPoolDataSource;
import oracle.jdbc.driver.DatabaseError;
import oracle.jdbc.internal.OracleConnection;
import oracle.ons.ONS;
import oracle.ons.ONSException;

/** @deprecated */
public class OracleConnectionCacheManager {
    private static OracleConnectionCacheManager cacheManagerInstance = null;
    protected Hashtable m_connCache = null;
    public static final int REFRESH_INVALID_CONNECTIONS = 4096;
    public static final int REFRESH_ALL_CONNECTIONS = 8192;
    public static final String PHYSICAL_CONNECTION_CREATED_COUNT = "PhysicalConnectionCreatedCount";
    public static final String PHYSICAL_CONNECTION_CLOSED_COUNT = "PhysicalConnectionClosedCount";
    protected static final int FAILOVER_EVENT_TYPE_SERVICE = 256;
    protected static final int FAILOVER_EVENT_TYPE_HOST = 512;
    protected static final String EVENT_DELIMITER = "{} =";
    protected OracleFailoverEventHandlerThread failoverEventHandlerThread = null;
    private static boolean isONSInitializedForRemoteSubscription = false;
    static final int ORAERROR_END_OF_FILE_ON_COM_CHANNEL = 3113;
    static final int ORAERROR_NOT_CONNECTED_TO_ORACLE = 3114;
    static final int ORAERROR_INIT_SHUTDOWN_IN_PROGRESS = 1033;
    static final int ORAERROR_ORACLE_NOT_AVAILABLE = 1034;
    static final int ORAERROR_IMMEDIATE_SHUTDOWN_IN_PROGRESS = 1089;
    static final int ORAERROR_SHUTDOWN_IN_PROGRESS_NO_CONN = 1090;
    static final int ORAERROR_NET_IO_EXCEPTION = 17002;
    protected int[] fatalErrorCodes = null;
    protected int failoverEnabledCacheCount = 0;
    protected static AtomicInteger UNNAMED_CACHE_COUNT;
    private static final String _Copyright_2007_Oracle_All_Rights_Reserved_ = null;
    public static final String BUILD_DATE = "Thu_Apr_04_15:09:24_PDT_2013";
    public static final boolean TRACE = false;

    private OracleConnectionCacheManager() {
        this.m_connCache = new Hashtable();
        UNNAMED_CACHE_COUNT = new AtomicInteger();
    }

    /** @deprecated */
    public static synchronized OracleConnectionCacheManager getConnectionCacheManagerInstance() throws SQLException {
        try {
            if (cacheManagerInstance == null) {
                cacheManagerInstance = new OracleConnectionCacheManager();
            }
        } catch (RuntimeException var1) {
        }

        return cacheManagerInstance;
    }

    /** @deprecated */
    public String createCache(OracleDataSource var1, Properties var2) throws SQLException {
        String var3 = null;
        if (var1 != null && var1.getConnectionCachingEnabled()) {
            if (var1.connCacheName != null) {
                var3 = var1.connCacheName;
            } else {
                var3 = var1.dataSourceName + "#0x" + Integer.toHexString(UNNAMED_CACHE_COUNT.getAndIncrement());
            }

            this.createCache(var3, var1, var2);
            return var3;
        } else {
            SQLException var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 137);
            var4.fillInStackTrace();
            throw var4;
        }
    }

    /** @deprecated */
    public void createCache(String var1, OracleDataSource var2, Properties var3) throws SQLException {
        SQLException var4;
        if (var2 != null && var2.getConnectionCachingEnabled()) {
            if (var1 == null) {
                var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 138);
                var4.fillInStackTrace();
                throw var4;
            } else if (this.m_connCache.containsKey(var1)) {
                var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 140);
                var4.fillInStackTrace();
                throw var4;
            } else {
                boolean var12 = var2.getFastConnectionFailoverEnabled();
                if (var12 && this.failoverEventHandlerThread == null) {
                    final String var5 = var2.getONSConfiguration();
                    if (var5 != null && !var5.equals("")) {
                        synchronized(this) {
                            if (!isONSInitializedForRemoteSubscription) {
                                try {
                                    AccessController.doPrivileged(new PrivilegedExceptionAction() {
                                        public Object run() throws ONSException {
                                            new ONS(var5);
                                            return null;
                                        }
                                    });
                                } catch (PrivilegedActionException var10) {
                                    SQLException var8 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 175, var10);
                                    var8.fillInStackTrace();
                                    throw var8;
                                }

                                isONSInitializedForRemoteSubscription = true;
                            }
                        }
                    }

                    this.failoverEventHandlerThread = new OracleFailoverEventHandlerThread();
                }

                OracleImplicitConnectionCache var13 = new OracleImplicitConnectionCache(var2, var3);
                var13.cacheName = var1;
                var2.odsCache = var13;
                this.m_connCache.put(var1, var13);
                if (var12) {
                    this.checkAndStartThread(this.failoverEventHandlerThread);
                }

            }
        } else {
            var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 137);
            var4.fillInStackTrace();
            throw var4;
        }
    }

    /** @deprecated */
    public void removeCache(String var1, long var2) throws SQLException {
        OracleImplicitConnectionCache var4 = var1 != null ? (OracleImplicitConnectionCache)((OracleImplicitConnectionCache)this.m_connCache.remove(var1)) : null;
        if (var4 != null) {
            var4.disableConnectionCache();
            if (var2 > 0L) {
                try {
                    Thread.currentThread();
                    Thread.sleep(var2 * 1000L);
                } catch (InterruptedException var6) {
                }
            }

            if (var4.cacheEnabledDS.getFastConnectionFailoverEnabled()) {
                this.cleanupFCFThreads(var4);
            }

            var4.closeConnectionCache(var2 < 0L ? 32 : 1);
            var4 = null;
        } else {
            SQLException var5 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 141);
            var5.fillInStackTrace();
            throw var5;
        }
    }

    /** @deprecated */
    public void reinitializeCache(String var1, Properties var2) throws SQLException {
        OracleImplicitConnectionCache var3 = var1 != null ? (OracleImplicitConnectionCache)((OracleImplicitConnectionCache)this.m_connCache.get(var1)) : null;
        if (var3 != null) {
            this.disableCache(var1);
            var3.reinitializeCacheConnections(var2);
            this.enableCache(var1);
        } else {
            SQLException var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 141);
            var4.fillInStackTrace();
            throw var4;
        }
    }

    /** @deprecated */
    public boolean existsCache(String var1) throws SQLException {
        return this.m_connCache.containsKey(var1);
    }

    /** @deprecated */
    public void enableCache(String var1) throws SQLException {
        OracleImplicitConnectionCache var2 = var1 != null ? (OracleImplicitConnectionCache)((OracleImplicitConnectionCache)this.m_connCache.get(var1)) : null;
        if (var2 != null) {
            var2.enableConnectionCache();
        } else {
            SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 141);
            var3.fillInStackTrace();
            throw var3;
        }
    }

    /** @deprecated */
    public void disableCache(String var1) throws SQLException {
        OracleImplicitConnectionCache var2 = var1 != null ? (OracleImplicitConnectionCache)((OracleImplicitConnectionCache)this.m_connCache.get(var1)) : null;
        if (var2 != null) {
            var2.disableConnectionCache();
        } else {
            SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 141);
            var3.fillInStackTrace();
            throw var3;
        }
    }

    /** @deprecated */
    public void refreshCache(String var1, int var2) throws SQLException {
        OracleImplicitConnectionCache var3 = var1 != null ? (OracleImplicitConnectionCache)((OracleImplicitConnectionCache)this.m_connCache.get(var1)) : null;
        SQLException var4;
        if (var3 != null) {
            switch(var2) {
                case 4096:
                case 8192:
                    var3.refreshCacheConnections(var2);
                    return;
                default:
                    var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 68);
                    var4.fillInStackTrace();
                    throw var4;
            }
        } else {
            var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 141);
            var4.fillInStackTrace();
            throw var4;
        }
    }

    /** @deprecated */
    public void purgeCache(String var1, boolean var2) throws SQLException {
        OracleImplicitConnectionCache var3 = var1 != null ? (OracleImplicitConnectionCache)((OracleImplicitConnectionCache)this.m_connCache.get(var1)) : null;
        if (var3 != null) {
            var3.purgeCacheConnections(var2, 1);
        } else {
            SQLException var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 141);
            var4.fillInStackTrace();
            throw var4;
        }
    }

    /** @deprecated */
    public Properties getCacheProperties(String var1) throws SQLException {
        OracleImplicitConnectionCache var2 = var1 != null ? (OracleImplicitConnectionCache)((OracleImplicitConnectionCache)this.m_connCache.get(var1)) : null;
        if (var2 != null) {
            return var2.getConnectionCacheProperties();
        } else {
            SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 141);
            var3.fillInStackTrace();
            throw var3;
        }
    }

    /** @deprecated */
    public String[] getCacheNameList() throws SQLException {
        String[] var1 = (String[])((String[])this.m_connCache.keySet().toArray(new String[this.m_connCache.size()]));
        return var1;
    }

    /** @deprecated */
    public int getNumberOfAvailableConnections(String var1) throws SQLException {
        OracleImplicitConnectionCache var2 = var1 != null ? (OracleImplicitConnectionCache)((OracleImplicitConnectionCache)this.m_connCache.get(var1)) : null;
        if (var2 != null) {
            return var2.cacheSize;
        } else {
            SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 141);
            var3.fillInStackTrace();
            throw var3;
        }
    }

    /** @deprecated */
    public int getNumberOfActiveConnections(String var1) throws SQLException {
        OracleImplicitConnectionCache var2 = var1 != null ? (OracleImplicitConnectionCache)((OracleImplicitConnectionCache)this.m_connCache.get(var1)) : null;
        if (var2 != null) {
            return var2.getNumberOfCheckedOutConnections();
        } else {
            SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 141);
            var3.fillInStackTrace();
            throw var3;
        }
    }

    /** @deprecated */
    public synchronized void setConnectionPoolDataSource(String var1, ConnectionPoolDataSource var2) throws SQLException {
        OracleImplicitConnectionCache var3 = var1 != null ? (OracleImplicitConnectionCache)((OracleImplicitConnectionCache)this.m_connCache.get(var1)) : null;
        SQLException var4;
        if (var3 != null) {
            if (var3.cacheSize > 0) {
                var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 78);
                var4.fillInStackTrace();
                throw var4;
            } else {
                ((OracleConnectionPoolDataSource)var2).makeURL();
                ((OracleConnectionPoolDataSource)var2).setURL(((OracleConnectionPoolDataSource)var2).url);
                var3.connectionPoolDS = (OracleConnectionPoolDataSource)var2;
            }
        } else {
            var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 141);
            var4.fillInStackTrace();
            throw var4;
        }
    }

    protected void verifyAndHandleEvent(int var1, byte[] var2) throws SQLException {
        String var3 = null;
        String var4 = null;
        String var5 = null;
        String var6 = null;
        String var7 = null;
        int var8 = 0;
        StringTokenizer var9 = null;
        boolean var10 = true;

        try {
            var9 = new StringTokenizer(new String(var2, "UTF-8"), "{} =", true);
        } catch (UnsupportedEncodingException var16) {
        }

        String var11 = null;
        String var12 = null;
        String var13 = null;

        while(var9.hasMoreTokens()) {
            var12 = null;
            var11 = var9.nextToken();
            if (var11.equals("=") && var9.hasMoreTokens()) {
                var12 = var9.nextToken();
            } else {
                var13 = var11;
            }

            if (var13.equalsIgnoreCase("version") && var12 != null && !var12.startsWith("1.")) {
                var10 = false;
            }

            if (var13.equalsIgnoreCase("service") && var12 != null) {
                var3 = var12;
            }

            if (var13.equalsIgnoreCase("instance") && var12 != null && !var12.equals(" ")) {
                var4 = var12.toLowerCase().intern();
            }

            if (var13.equalsIgnoreCase("database") && var12 != null) {
                var5 = var12.toLowerCase().intern();
            }

            if (var13.equalsIgnoreCase("host") && var12 != null) {
                var6 = var12.toLowerCase().intern();
            }

            if (var13.equalsIgnoreCase("status") && var12 != null) {
                var7 = var12;
            }

            if (var13.equalsIgnoreCase("card") && var12 != null) {
                try {
                    var8 = Integer.parseInt(var12);
                } catch (NumberFormatException var15) {
                    var10 = false;
                }
            }
        }

        if (var10) {
            this.invokeFailoverProcessingThreads(var1, var3, var4, var5, var6, var7, var8);
        } else {
            var9 = null;
        }

    }

    private void invokeFailoverProcessingThreads(int var1, String var2, String var3, String var4, String var5, String var6, int var7) throws SQLException {
        OracleImplicitConnectionCache var8 = null;
        boolean var9 = false;
        boolean var10 = false;
        if (var1 == 256) {
            var9 = true;
        }

        if (var1 == 512) {
            var10 = true;
        }

        Iterator var11 = this.m_connCache.values().iterator();

        while(true) {
            do {
                if (!var11.hasNext()) {
                    return;
                }

                var8 = (OracleImplicitConnectionCache)var11.next();
            } while((!var9 || !var2.equalsIgnoreCase(var8.dataSourceServiceName)) && !var10);

            OracleFailoverWorkerThread var12 = new OracleFailoverWorkerThread(var8, var1, var3, var4, var5, var6, var7);
            this.checkAndStartThread(var12);
            var8.failoverWorkerThread = var12;
        }
    }

    protected void checkAndStartThread(Thread var1) throws SQLException {
        try {
            if (!var1.isAlive()) {
                var1.setDaemon(true);
                var1.start();
            }
        } catch (IllegalThreadStateException var3) {
        }

    }

    protected boolean failoverEnabledCacheExists() {
        return this.failoverEnabledCacheCount > 0;
    }

    protected void parseRuntimeLoadBalancingEvent(String var1, byte[] var2) throws SQLException {
        OracleImplicitConnectionCache var3 = null;
        Enumeration var4 = this.m_connCache.elements();

        while(var4.hasMoreElements()) {
            try {
                var3 = (OracleImplicitConnectionCache)var4.nextElement();
                if (var1.equalsIgnoreCase(var3.dataSourceServiceName)) {
                    if (var2 == null) {
                        var3.zapRLBInfo();
                    } else {
                        this.retrieveServiceMetrics(var3, var2);
                    }
                }
            } catch (Exception var6) {
            }
        }

    }

    private void retrieveServiceMetrics(OracleImplicitConnectionCache var1, byte[] var2) throws SQLException {
        StringTokenizer var3 = null;
        String var4 = null;
        String var5 = null;
        int var6 = 0;
        byte var7 = 0;
        boolean var8 = false;

        try {
            var3 = new StringTokenizer(new String(var2, "UTF-8"), "{} =", true);
        } catch (UnsupportedEncodingException var14) {
        }

        String var9 = null;
        String var10 = null;
        String var11 = null;

        while(true) {
            while(var3.hasMoreTokens()) {
                var10 = null;
                var9 = var3.nextToken();
                if (var9.equals("=") && var3.hasMoreTokens()) {
                    var10 = var3.nextToken();
                } else {
                    if (var9.equals("}")) {
                        if (var8) {
                            var1.updateDatabaseInstance(var5, var4, var6, var7);
                            var8 = false;
                        }
                        continue;
                    }

                    if (var9.equals("{") || var9.equals(" ")) {
                        continue;
                    }

                    var11 = var9;
                    var8 = true;
                }

                if (var11.equalsIgnoreCase("version") && var10 != null && !var10.equals("1.0")) {
                    SQLException var12 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 146);
                    var12.fillInStackTrace();
                    throw var12;
                }

                if (var11.equalsIgnoreCase("database") && var10 != null) {
                    var5 = var10.toLowerCase().intern();
                }

                if (var11.equalsIgnoreCase("instance") && var10 != null) {
                    var4 = var10.toLowerCase().intern();
                }

                if (var11.equalsIgnoreCase("percent") && var10 != null) {
                    try {
                        var6 = Integer.parseInt(var10);
                        if (var6 == 0) {
                            var6 = 1;
                        }
                    } catch (NumberFormatException var13) {
                    }
                }

                if (var11.equalsIgnoreCase("flag") && var10 != null) {
                    if (var10.equalsIgnoreCase("good")) {
                        var7 = 1;
                    } else if (var10.equalsIgnoreCase("violating")) {
                        var7 = 3;
                    } else if (var10.equalsIgnoreCase("NO_DATA")) {
                        var7 = 4;
                    } else if (var10.equalsIgnoreCase("UNKNOWN")) {
                        var7 = 2;
                    } else if (var10.equalsIgnoreCase("BLOCKED")) {
                        var7 = 5;
                    }
                }
            }

            var1.processDatabaseInstances();
            return;
        }
    }

    protected void cleanupFCFThreads(OracleImplicitConnectionCache var1) throws SQLException {
        this.cleanupFCFWorkerThread(var1);
        var1.cleanupRLBThreads();
        if (this.failoverEnabledCacheCount <= 0) {
            this.cleanupFCFEventHandlerThread();
        }

        --this.failoverEnabledCacheCount;
    }

    protected void cleanupFCFWorkerThread(OracleImplicitConnectionCache var1) throws SQLException {
        if (var1.failoverWorkerThread != null) {
            try {
                if (var1.failoverWorkerThread.isAlive()) {
                    var1.failoverWorkerThread.join();
                }
            } catch (InterruptedException var3) {
            }

            var1.failoverWorkerThread = null;
        }

    }

    protected void cleanupFCFEventHandlerThread() throws SQLException {
        if (this.failoverEventHandlerThread != null) {
            try {
                this.failoverEventHandlerThread.interrupt();
            } catch (Exception var2) {
            }

            this.failoverEventHandlerThread = null;
        }

    }

    public boolean isFatalConnectionError(SQLException var1) {
        boolean var2 = false;
        int var3 = var1.getErrorCode();
        if (var3 == 3113 || var3 == 3114 || var3 == 1033 || var3 == 1034 || var3 == 1089 || var3 == 1090 || var3 == 17002) {
            var2 = true;
        }

        if (!var2 && this.fatalErrorCodes != null) {
            for(int var4 = 0; var4 < this.fatalErrorCodes.length; ++var4) {
                if (var3 == this.fatalErrorCodes[var4]) {
                    var2 = true;
                    break;
                }
            }
        }

        return var2;
    }

    public synchronized void setConnectionErrorCodes(int[] var1) throws SQLException {
        if (var1 != null) {
            this.fatalErrorCodes = var1;
        }

    }

    public int[] getConnectionErrorCodes() throws SQLException {
        return this.fatalErrorCodes;
    }

    /** @deprecated */
    public Map getStatistics(String var1) throws SQLException {
        Map var2 = null;
        OracleImplicitConnectionCache var3 = null;
        if (this.m_connCache != null && (var3 = (OracleImplicitConnectionCache)this.m_connCache.get(var1)) != null) {
            var2 = var3.getStatistics();
        }

        return var2;
    }

    protected OracleConnection getConnectionDuringExceptionHandling() {
        return null;
    }
}
