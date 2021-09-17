//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package oracle.jdbc.pool;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Properties;
import java.util.Random;
import java.util.Vector;
import java.util.Map.Entry;
import javax.sql.PooledConnection;
import oracle.jdbc.driver.DatabaseError;
import oracle.jdbc.internal.OracleConnection;
import oracle.jdbc.internal.OracleConnection.TransactionState;
import oracle.jdbc.xa.client.OracleXADataSource;

/** @deprecated */
class OracleImplicitConnectionCache {
    protected OracleDataSource cacheEnabledDS = null;
    protected String cacheName = null;
    protected OracleConnectionPoolDataSource connectionPoolDS = null;
    protected boolean fastConnectionFailoverEnabled = false;
    protected String defaultUser = null;
    protected String defaultPassword = null;
    protected static final int DEFAULT_MIN_LIMIT = 0;
    protected static final int DEFAULT_MAX_LIMIT = 2147483647;
    protected static final int DEFAULT_INITIAL_LIMIT = 0;
    protected static final int DEFAULT_MAX_STATEMENTS_LIMIT = 0;
    protected static final int DEFAULT_INACTIVITY_TIMEOUT = 0;
    protected static final int DEFAULT_TIMETOLIVE_TIMEOUT = 0;
    protected static final int DEFAULT_ABANDONED_CONN_TIMEOUT = 0;
    protected static final int DEFAULT_CONNECTION_WAIT_TIMEOUT = 0;
    protected static final String DEFAULT_ATTRIBUTE_WEIGHT = "0";
    protected static final int DEFAULT_LOWER_THRESHOLD_LIMIT = 20;
    protected static final int DEFAULT_PROPERTY_CHECK_INTERVAL = 900;
    protected static final int CLOSE_AND_REMOVE_ALL_CONNECTIONS = 1;
    protected static final int CLOSE_AND_REMOVE_FAILOVER_CONNECTIONS = 2;
    protected static final int PROCESS_INACTIVITY_TIMEOUT = 4;
    protected static final int CLOSE_AND_REMOVE_N_CONNECTIONS = 8;
    protected static final int DISABLE_STATEMENT_CACHING = 16;
    protected static final int RESET_STATEMENT_CACHE_SIZE = 18;
    protected static final int CLOSE_AND_REMOVE_RLB_CONNECTIONS = 24;
    protected static final int ABORT_AND_CLOSE_ALL_CONNECTIONS = 32;
    public static final int REFRESH_INVALID_CONNECTIONS = 4096;
    public static final int REFRESH_ALL_CONNECTIONS = 8192;
    private static final String ATTRKEY_DELIM = "0xffff";
    protected int cacheMinLimit = 0;
    protected int cacheMaxLimit = 2147483647;
    protected int cacheInitialLimit = 0;
    protected int cacheMaxStatementsLimit = 0;
    protected Properties cacheAttributeWeights = null;
    protected int cacheInactivityTimeout = 0;
    protected int cacheTimeToLiveTimeout = 0;
    protected int cacheAbandonedConnectionTimeout = 0;
    protected int cacheLowerThresholdLimit = 20;
    protected int cachePropertyCheckInterval = 900;
    protected boolean cacheClosestConnectionMatch = false;
    protected boolean cacheValidateConnection = false;
    protected boolean cacheUseLIFO = false;
    protected int cacheConnectionWaitTimeout = 0;
    static final String MIN_LIMIT_KEY = "MinLimit";
    static final String MAX_LIMIT_KEY = "MaxLimit";
    static final String INITIAL_LIMIT_KEY = "InitialLimit";
    static final String MAX_STATEMENTS_LIMIT_KEY = "MaxStatementsLimit";
    static final String ATTRIBUTE_WEIGHTS_KEY = "AttributeWeights";
    static final String INACTIVITY_TIMEOUT_KEY = "InactivityTimeout";
    static final String TIME_TO_LIVE_TIMEOUT_KEY = "TimeToLiveTimeout";
    static final String ABANDONED_CONNECTION_TIMEOUT_KEY = "AbandonedConnectionTimeout";
    static final String LOWER_THRESHOLD_LIMIT_KEY = "LowerThresholdLimit";
    static final String PROPERTY_CHECK_INTERVAL_KEY = "PropertyCheckInterval";
    static final String VALIDATE_CONNECTION_KEY = "ValidateConnection";
    static final String CLOSEST_CONNECTION_MATCH_KEY = "ClosestConnectionMatch";
    static final String CONNECTION_WAIT_TIMEOUT_KEY = "ConnectionWaitTimeout";
    static final String LOCAL_TXN_COMMIT_ON_CLOSE = "LocalTransactionCommitOnClose";
    static final String USE_LIFO_KEY = "UseLIFO";
    static final int INSTANCE_GOOD = 1;
    static final int INSTANCE_UNKNOWN = 2;
    static final int INSTANCE_VIOLATING = 3;
    static final int INSTANCE_NO_DATA = 4;
    static final int INSTANCE_BLOCKED = 5;
    static final int RLB_NUMBER_OF_HITS_PER_INSTANCE = 1000;
    int dbInstancePercentTotal = 0;
    boolean useGoodGroup = false;
    Vector instancesToRetireQueue = null;
    OracleDatabaseInstance instanceToRetire = null;
    int retireConnectionsCount = 0;
    int countTotal = 0;
    protected OracleConnectionCacheManager cacheManager = null;
    protected boolean disableConnectionRequest = false;
    protected OracleImplicitConnectionCacheThread timeoutThread = null;
    protected OracleRuntimeLoadBalancingEventHandlerThread runtimeLoadBalancingThread = null;
    protected OracleGravitateConnectionCacheThread gravitateCacheThread = null;
    protected int connectionsToRemove = 0;
    private HashMap userMap = null;
    Vector checkedOutConnectionList = null;
    LinkedList databaseInstancesList = null;
    int cacheSize = 0;
    protected static final String EVENT_DELIMITER = " ";
    protected boolean isEntireServiceDownProcessed = false;
    protected int defaultUserPreFailureSize = 0;
    protected String dataSourceServiceName = null;
    protected OracleFailoverWorkerThread failoverWorkerThread = null;
    protected Random rand = null;
    protected int downEventCount = 0;
    protected int upEventCount = 0;
    protected int pendingCreationRequests = 0;
    protected int connectionClosedCount = 0;
    protected int connectionCreatedCount = 0;
    boolean cacheLocalTxnCommitOnClose = false;
    private static final String _Copyright_2007_Oracle_All_Rights_Reserved_ = null;
    public static final String BUILD_DATE = "Thu_Apr_04_15:09:24_PDT_2013";
    public static final boolean TRACE = false;

    OracleImplicitConnectionCache(OracleDataSource var1, Properties var2) throws SQLException {
        this.cacheEnabledDS = var1;
        this.initializeConnectionCache();
        this.setConnectionCacheProperties(var2);
        this.defaultUserPrePopulateCache(this.cacheInitialLimit);
    }

    private void defaultUserPrePopulateCache(int var1) throws SQLException {
        if (var1 > 0) {
            String var2 = this.defaultUser;
            String var3 = this.defaultPassword;
            this.validateUser(var2, var3);
            OraclePooledConnection var4 = null;

            for(int var5 = 0; var5 < var1; ++var5) {
                var4 = this.makeOneConnection(var2, var3);
                synchronized(this) {
                    if (var4 != null) {
                        --this.cacheSize;
                        this.storeCacheConnection((Properties)null, var4);
                    }
                }
            }
        }

    }

    protected void initializeConnectionCache() throws SQLException {
        this.userMap = new HashMap();
        this.checkedOutConnectionList = new Vector();
        if (this.cacheManager == null) {
            this.cacheManager = OracleConnectionCacheManager.getConnectionCacheManagerInstance();
        }

        if (this.cacheEnabledDS.user != null && !this.cacheEnabledDS.user.startsWith("\"")) {
            this.defaultUser = this.cacheEnabledDS.user.toLowerCase();
        } else {
            this.defaultUser = this.cacheEnabledDS.user;
        }

        this.defaultPassword = this.cacheEnabledDS.password;
        if (this.connectionPoolDS == null) {
            if (this.cacheEnabledDS instanceof OracleXADataSource) {
                this.connectionPoolDS = new OracleXADataSource();
            } else {
                this.connectionPoolDS = new OracleConnectionPoolDataSource();
            }

            this.cacheEnabledDS.copy(this.connectionPoolDS);
        }

        if (this.fastConnectionFailoverEnabled = this.cacheEnabledDS.getFastConnectionFailoverEnabled()) {
            this.rand = new Random(0L);
            this.instancesToRetireQueue = new Vector();
            ++this.cacheManager.failoverEnabledCacheCount;
        }

    }

    private void validateUser(String var1, String var2) throws SQLException {
        if (var1 == null || var2 == null) {
            SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 79);
            var3.fillInStackTrace();
            throw var3;
        }
    }

    protected Connection getConnection(String var1, String var2, Properties var3) throws SQLException {
        OraclePooledConnection var4 = null;
        Connection var5 = null;

        try {
            SQLException var17;
            if (this.disableConnectionRequest) {
                var17 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 142);
                var17.fillInStackTrace();
                throw var17;
            } else {
                this.validateUser(var1, var2);
                if (!var1.startsWith("\"")) {
                    var1 = var1.toLowerCase();
                }

                if (this.getNumberOfCheckedOutConnections() < this.cacheMaxLimit) {
                    var4 = this.getCacheConnection(var1, var2, var3);
                }

                if (var4 == null) {
                    this.processConnectionCacheCallback();
                    if (this.cacheSize > 0) {
                        var4 = this.getCacheConnection(var1, var2, var3);
                    }

                    if (var4 == null && this.cacheConnectionWaitTimeout > 0) {
                        long var6 = (long)this.cacheConnectionWaitTimeout * 1000L;
                        long var8 = System.currentTimeMillis();
                        long var10 = 0L;

                        do {
                            this.processConnectionWaitTimeout(var6);
                            if (this.cacheSize > 0) {
                                var4 = this.getCacheConnection(var1, var2, var3);
                            }

                            var10 = System.currentTimeMillis();
                            var6 -= System.currentTimeMillis() - var8;
                            var8 = var10;
                        } while(var4 == null && var6 > 0L);
                    }
                }

                if (var4 != null && var4.physicalConn != null) {
                    var5 = var4.getConnection();
                    if (var5 != null) {
                        if (this.cacheValidateConnection && this.testDatabaseConnection((OracleConnection)var5) != 0) {
                            ((OracleConnection)var5).close(4096);
                            var17 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 143);
                            var17.fillInStackTrace();
                            throw var17;
                        }

                        if (this.cacheAbandonedConnectionTimeout > 0) {
                            ((OracleConnection)var5).setAbandonedTimeoutEnabled(true);
                        }

                        if (this.cacheTimeToLiveTimeout > 0) {
                            ((OracleConnection)var5).setStartTime(System.currentTimeMillis());
                        }

                        synchronized(this) {
                            --this.cacheSize;
                            this.checkedOutConnectionList.addElement(var4);
                        }
                    }
                }

                return var5;
            }
        } catch (SQLException var16) {
            synchronized(this) {
                if (var4 != null) {
                    --this.cacheSize;
                    this.abortConnection(var4);
                }
            }

            throw var16;
        }
    }

    private OraclePooledConnection getCacheConnection(String var1, String var2, Properties var3) throws SQLException {
        OraclePooledConnection var4 = this.retrieveCacheConnection(var1, var2, var3);
        if (var4 == null) {
            var4 = this.makeOneConnection(var1, var2);
            if (var4 != null && var3 != null && !var3.isEmpty()) {
                this.setUnMatchedAttributes(var3, var4);
            }
        }

        return var4;
    }

    OraclePooledConnection makeOneConnection(String var1, String var2) throws SQLException {
        OraclePooledConnection var3 = null;
        boolean var4 = false;
        synchronized(this) {
            if (this.getTotalCachedConnections() + this.pendingCreationRequests < this.cacheMaxLimit) {
                ++this.pendingCreationRequests;
                var4 = true;
            }
        }

        if (var4) {
            boolean var15 = false;

            try {
                var15 = true;
                var3 = this.makeCacheConnection(var1, var2);
                var15 = false;
            } finally {
                if (var15) {
                    synchronized(this) {
                        if (var3 != null) {
                            ++this.connectionCreatedCount;
                        }

                        --this.pendingCreationRequests;
                    }
                }
            }

            synchronized(this) {
                if (var3 != null) {
                    ++this.connectionCreatedCount;
                }

                --this.pendingCreationRequests;
            }
        }

        return var3;
    }

    protected int getTotalCachedConnections() {
        return this.cacheSize + this.getNumberOfCheckedOutConnections();
    }

    protected int getNumberOfCheckedOutConnections() {
        return this.checkedOutConnectionList.size();
    }

    private synchronized OraclePooledConnection retrieveCacheConnection(String var1, String var2, Properties var3) throws SQLException {
        OraclePooledConnection var4 = null;
        OracleConnectionCacheEntry var5 = (OracleConnectionCacheEntry)this.userMap.get(OraclePooledConnection.generateKey(var1, var2));
        if (var5 != null) {
            if (var3 == null || var3 != null && var3.isEmpty()) {
                if (var5.userConnList != null) {
                    var4 = this.retrieveFromConnectionList(var5.userConnList);
                }
            } else if (var5.attrConnMap != null) {
                String var6 = this.buildAttrKey(var3);
                Vector var7 = (Vector)((Vector)var5.attrConnMap.get(var6));
                if (var7 != null) {
                    var4 = this.retrieveFromConnectionList(var7);
                }

                if (var4 == null && this.cacheClosestConnectionMatch) {
                    var4 = this.retrieveClosestConnectionMatch(var5.attrConnMap, var3);
                }

                if (var4 == null && var5.userConnList != null) {
                    var4 = this.retrieveFromConnectionList(var5.userConnList);
                }
            }
        }

        if (var4 != null && var3 != null && !var3.isEmpty()) {
            this.setUnMatchedAttributes(var3, var4);
        }

        return var4;
    }

    private OraclePooledConnection retrieveClosestConnectionMatch(HashMap var1, Properties var2) throws SQLException {
        OraclePooledConnection var3 = null;
        OraclePooledConnection var4 = null;
        Vector var5 = null;
        int var6 = var2.size();
        int var7 = 0;
        int var8 = 0;
        boolean var9 = false;
        int var10 = 0;
        boolean var11 = false;
        if (this.cacheAttributeWeights != null) {
            var7 = this.getAttributesWeightCount(var2, (Properties)null);
        }

        if (var1 != null && !var1.isEmpty()) {
            Iterator var12 = var1.entrySet().iterator();

            while(var12.hasNext()) {
                Entry var13 = (Entry)var12.next();
                Vector var14 = (Vector)var13.getValue();
                Object[] var15 = var14.toArray();
                int var16 = var14.size();

                for(int var17 = 0; var17 < var16; ++var17) {
                    var3 = (OraclePooledConnection)var15[var17];
                    if (var3.cachedConnectionAttributes != null && !var3.cachedConnectionAttributes.isEmpty() && var3.cachedConnectionAttributes.size() <= var6) {
                        if (var7 > 0) {
                            int var18 = this.getAttributesWeightCount(var2, var3.cachedConnectionAttributes);
                            if (var18 > var8) {
                                var4 = var3;
                                var8 = var18;
                                var5 = var14;
                            }
                        } else {
                            int var19 = this.getAttributesMatchCount(var2, var3.cachedConnectionAttributes);
                            if (var19 > var10) {
                                var4 = var3;
                                var10 = var19;
                                var5 = var14;
                            }
                        }
                    }
                }
            }
        }

        if (var5 != null) {
            var5.remove(var4);
        }

        return var4;
    }

    private int getAttributesMatchCount(Properties var1, Properties var2) throws SQLException {
        int var3 = 0;
        Entry var4 = null;
        Object var5 = null;
        Object var6 = null;
        Iterator var7 = var1.entrySet().iterator();

        while(var7.hasNext()) {
            var4 = (Entry)var7.next();
            var5 = var4.getKey();
            var6 = var4.getValue();
            if (var2.containsKey(var5) && var6.equals(var2.get(var5))) {
                ++var3;
            }
        }

        return var3;
    }

    private int getAttributesWeightCount(Properties var1, Properties var2) throws SQLException {
        Entry var3 = null;
        Object var4 = null;
        Object var5 = null;
        int var6 = 0;
        Iterator var7 = var1.entrySet().iterator();

        while(var7.hasNext()) {
            var3 = (Entry)var7.next();
            var4 = var3.getKey();
            var5 = var3.getValue();
            if (var2 == null) {
                if (this.cacheAttributeWeights.containsKey(var4)) {
                    var6 += Integer.parseInt((String)((String)this.cacheAttributeWeights.get(var4)));
                }
            } else if (var2.containsKey(var4) && var5.equals(var2.get(var4))) {
                if (this.cacheAttributeWeights.containsKey(var4)) {
                    var6 += Integer.parseInt((String)((String)this.cacheAttributeWeights.get(var4)));
                } else {
                    ++var6;
                }
            }
        }

        return var6;
    }

    private void setUnMatchedAttributes(Properties var1, OraclePooledConnection var2) throws SQLException {
        if (var2.unMatchedCachedConnAttr == null) {
            var2.unMatchedCachedConnAttr = new Properties();
        } else {
            var2.unMatchedCachedConnAttr.clear();
        }

        if (!this.cacheClosestConnectionMatch) {
            var2.unMatchedCachedConnAttr.putAll(var1);
        } else {
            Properties var3 = var2.cachedConnectionAttributes;
            Entry var4 = null;
            Object var5 = null;
            Object var6 = null;
            Iterator var7 = var1.entrySet().iterator();

            while(var7.hasNext()) {
                var4 = (Entry)var7.next();
                var5 = var4.getKey();
                var6 = var4.getValue();
                if (!var3.containsKey(var5) && !var6.equals(var3.get(var5))) {
                    var2.unMatchedCachedConnAttr.put(var5, var6);
                }
            }
        }

    }

    private OraclePooledConnection retrieveFromConnectionList(Vector var1) throws SQLException {
        if (var1.isEmpty()) {
            return null;
        } else {
            OraclePooledConnection var2 = null;
            if (this.fastConnectionFailoverEnabled) {
                int var4;
                OraclePooledConnection var5;
                int var6;
                if (this.useGoodGroup && this.databaseInstancesList != null && this.databaseInstancesList.size() > 0) {
                    synchronized(this.databaseInstancesList) {
                        var4 = this.databaseInstancesList.size();
                        var5 = null;
                        boolean var15 = false;
                        boolean[] var16 = new boolean[var4];
                        int var8 = this.dbInstancePercentTotal;

                        for(int var9 = 0; var9 < var4; ++var9) {
                            int var10 = 0;
                            if (var8 <= 1) {
                                var6 = 0;
                            } else {
                                var6 = this.rand.nextInt(var8 - 1);
                            }

                            for(int var11 = 0; var11 < var4; ++var11) {
                                OracleDatabaseInstance var14 = (OracleDatabaseInstance)this.databaseInstancesList.get(var11);
                                if (!var16[var11] && var14.flag <= 3) {
                                    var10 += var14.percent;
                                    if (var6 <= var10) {
                                        if (var9 == 0) {
                                            ++var14.attemptedConnRequestCount;
                                        }

                                        if ((var2 = this.selectConnectionFromList(var1, var14)) != null) {
                                            return var2;
                                        }

                                        var8 -= var14.percent;
                                        var16[var11] = true;
                                        break;
                                    }
                                }
                            }
                        }
                    }
                } else if (!this.cacheUseLIFO) {
                    int var3 = var1.size();
                    var4 = this.rand.nextInt(var3);
                    var5 = null;

                    for(var6 = 0; var6 < var3; ++var6) {
                        int var7 = (var4++ + var3) % var3;
                        var5 = (OraclePooledConnection)var1.get(var7);
                        if (!var5.connectionMarkedDown) {
                            var2 = var5;
                            var1.remove(var5);
                            break;
                        }
                    }
                } else {
                    var2 = (OraclePooledConnection)var1.remove(0);
                }
            } else {
                var2 = (OraclePooledConnection)var1.remove(0);
            }

            return var2;
        }
    }

    private OraclePooledConnection selectConnectionFromList(Vector var1, OracleDatabaseInstance var2) {
        OraclePooledConnection var3 = null;
        OraclePooledConnection var4 = null;
        int var5 = var1.size();

        for(int var6 = 0; var6 < var5; ++var6) {
            var4 = (OraclePooledConnection)var1.get(var6);
            if (!var4.connectionMarkedDown && var4.dataSourceDbUniqNameKey == var2.databaseUniqName && var4.dataSourceInstanceNameKey == var2.instanceName) {
                var3 = var4;
                var1.remove(var4);
                break;
            }
        }

        return var3;
    }

    private void removeCacheConnection(OraclePooledConnection var1) throws SQLException {
        boolean var2 = false;
        OracleConnectionCacheEntry var3 = var1.removeFromImplictCache(this.userMap);
        if (var3 != null) {
            Properties var4 = var1.cachedConnectionAttributes;
            if (var4 == null || var4 != null && var4.isEmpty()) {
                if (var3.userConnList != null) {
                    var2 = var3.userConnList.removeElement(var1);
                }
            } else if (var3.attrConnMap != null) {
                String var5 = this.buildAttrKey(var4);
                Vector var6 = (Vector)((Vector)var3.attrConnMap.get(var5));
                if (var6 != null) {
                    if (var1.unMatchedCachedConnAttr != null) {
                        var1.unMatchedCachedConnAttr.clear();
                        var1.unMatchedCachedConnAttr = null;
                    }

                    if (var1.cachedConnectionAttributes != null) {
                        var1.cachedConnectionAttributes.clear();
                        var1.cachedConnectionAttributes = null;
                    }

                    var4 = null;
                    var2 = var6.removeElement(var1);
                }
            }
        }

        if (var2) {
            --this.cacheSize;
        }

    }

    protected void doForEveryCachedConnection(int var1) throws SQLException {
        int var3 = 0;
        synchronized(this) {
            if (this.userMap != null && !this.userMap.isEmpty()) {
                Iterator var5 = this.userMap.entrySet().iterator();

                label97:
                while(true) {
                    OracleConnectionCacheEntry var7;
                    do {
                        OraclePooledConnection var2;
                        do {
                            do {
                                if (!var5.hasNext()) {
                                    if (var1 == 1 || var1 == 32) {
                                        this.userMap.clear();
                                        this.cacheSize = 0;
                                    }
                                    break label97;
                                }

                                Entry var6 = (Entry)var5.next();
                                var7 = (OracleConnectionCacheEntry)var6.getValue();
                                if (var7.userConnList != null && !var7.userConnList.isEmpty()) {
                                    Vector var8 = var7.userConnList;
                                    Object[] var9 = var8.toArray();

                                    for(int var10 = 0; var10 < var9.length; ++var10) {
                                        var2 = (OraclePooledConnection)var9[var10];
                                        if (var2 != null && this.performPooledConnectionTask(var2, var1)) {
                                            ++var3;
                                        }
                                    }
                                }
                            } while(var7.attrConnMap == null);
                        } while(var7.attrConnMap.isEmpty());

                        Iterator var15 = var7.attrConnMap.entrySet().iterator();

                        while(var15.hasNext()) {
                            Entry var16 = (Entry)var15.next();
                            Vector var17 = (Vector)var16.getValue();
                            Object[] var11 = var17.toArray();

                            for(int var12 = 0; var12 < var11.length; ++var12) {
                                var2 = (OraclePooledConnection)var11[var12];
                                if (var2 != null && this.performPooledConnectionTask(var2, var1)) {
                                    ++var3;
                                }
                            }
                        }
                    } while(var1 != 1 && var1 != 32);

                    var7.attrConnMap.clear();
                }
            }
        }

        if (var3 > 0) {
            this.defaultUserPrePopulateCache(var3);
        }

    }

    private boolean performPooledConnectionTask(OraclePooledConnection var1, int var2) throws SQLException {
        boolean var3 = false;
        switch(var2) {
            case 1:
                this.closeAndRemovePooledConnection(var1);
                break;
            case 2:
                if (var1.connectionMarkedDown) {
                    var1.needToAbort = true;
                    this.closeAndRemovePooledConnection(var1);
                }
                break;
            case 4:
                this.processInactivityTimeout(var1);
                break;
            case 8:
                if (this.connectionsToRemove > 0) {
                    this.closeAndRemovePooledConnection(var1);
                    --this.connectionsToRemove;
                }
                break;
            case 16:
                this.setStatementCaching(var1, this.cacheMaxStatementsLimit, false);
                break;
            case 18:
                this.setStatementCaching(var1, this.cacheMaxStatementsLimit, true);
                break;
            case 24:
                if (this.retireConnectionsCount > 0 && this.instanceToRetire.databaseUniqName == var1.dataSourceDbUniqNameKey && this.instanceToRetire.instanceName == var1.dataSourceInstanceNameKey) {
                    this.closeAndRemovePooledConnection(var1);
                    --this.retireConnectionsCount;
                    if (this.getTotalCachedConnections() < this.cacheMinLimit) {
                        var3 = true;
                    }
                }
                break;
            case 32:
                this.abortConnection(var1);
                this.closeAndRemovePooledConnection(var1);
                break;
            case 4096:
                Connection var4 = var1.getLogicalHandle();
                if ((var4 != null || (var4 = var1.getPhysicalHandle()) != null) && this.testDatabaseConnection((OracleConnection)var4) != 0) {
                    this.closeAndRemovePooledConnection(var1);
                    var3 = true;
                }
                break;
            case 8192:
                this.closeAndRemovePooledConnection(var1);
                var3 = true;
        }

        return var3;
    }

    protected synchronized void doForEveryCheckedOutConnection(int var1) throws SQLException {
        int var2 = this.checkedOutConnectionList.size();
        int var3;
        OraclePooledConnection var4;
        switch(var1) {
            case 1:
                for(var3 = 0; var3 < var2; ++var3) {
                    this.closeCheckedOutConnection((OraclePooledConnection)this.checkedOutConnectionList.get(var3), false);
                }

                this.checkedOutConnectionList.removeAllElements();
                break;
            case 24:
                for(var3 = 0; var3 < var2 && this.retireConnectionsCount > 0; ++var3) {
                    var4 = (OraclePooledConnection)this.checkedOutConnectionList.get(var3);
                    if (this.instanceToRetire.databaseUniqName == var4.dataSourceDbUniqNameKey && this.instanceToRetire.instanceName == var4.dataSourceInstanceNameKey) {
                        var4.closeOption = 4096;
                        this.retireConnectionsCount -= 2;
                    }
                }

                return;
            case 32:
                for(var3 = 0; var3 < var2; ++var3) {
                    var4 = null;
                    this.abortConnection(var4 = (OraclePooledConnection)this.checkedOutConnectionList.get(var3));
                    this.closeCheckedOutConnection(var4, false);
                }

                this.checkedOutConnectionList.removeAllElements();
        }

    }

    protected void closeCheckedOutConnection(OraclePooledConnection var1, boolean var2) throws SQLException {
        if (var1 != null) {
            OracleConnection var3 = (OracleConnection)var1.getLogicalHandle();
            OracleConnection var4 = (OracleConnection)var1.getPhysicalHandle();
            boolean var5 = var3.getAutoCommit();
            if (var2) {
                boolean var6 = var1.localTxnCommitOnClose;

                try {
                    var1.localTxnCommitOnClose = false;
                    var3.cleanupAndClose(true);

                    try {
                        if (!var5 && !var1.needToAbort) {
                            var4.rollback();
                        }
                    } catch (SQLException var14) {
                    }
                } catch (SQLException var15) {
                } finally {
                    if (var1.localTxnCommitOnClose != var6) {
                        var1.localTxnCommitOnClose = var6;
                    }

                }
            } else {
                try {
                    if (!var5 && !var1.needToAbort) {
                        var4.cancel();
                        var4.rollback();
                    }
                } catch (SQLException var13) {
                }

                this.actualPooledConnectionClose(var1);
            }
        }

    }

    synchronized void storeCacheConnection(Properties var1, OraclePooledConnection var2) throws SQLException {
        boolean var3 = false;
        if (var2 != null && var2.physicalConn != null) {
            if (this.cacheInactivityTimeout > 0) {
                var2.setLastAccessedTime(System.currentTimeMillis());
            }

            if (var2.unMatchedCachedConnAttr != null) {
                var2.unMatchedCachedConnAttr.clear();
                var2.unMatchedCachedConnAttr = null;
            }

            OracleConnectionCacheEntry var4 = var2.removeFromImplictCache(this.userMap);
            String var5;
            if (var4 != null) {
                if (var1 != null && (var1 == null || !var1.isEmpty())) {
                    var2.cachedConnectionAttributes = var1;
                    if (var4.attrConnMap == null) {
                        var4.attrConnMap = new HashMap();
                    }

                    var5 = this.buildAttrKey(var1);
                    Vector var6 = (Vector)((Vector)var4.attrConnMap.get(var5));
                    if (var6 != null) {
                        if (this.cacheUseLIFO) {
                            var6.add(0, var2);
                            var3 = true;
                        } else {
                            var3 = var6.add(var2);
                        }
                    } else {
                        var6 = new Vector();
                        var3 = var6.add(var2);
                        var4.attrConnMap.put(var5, var6);
                    }
                } else {
                    if (var4.userConnList == null) {
                        var4.userConnList = new Vector();
                    }

                    if (this.cacheUseLIFO) {
                        var4.userConnList.add(0, var2);
                        var3 = true;
                    } else {
                        var3 = var4.userConnList.add(var2);
                    }
                }
            } else {
                var4 = new OracleConnectionCacheEntry();
                var2.addToImplicitCache(this.userMap, var4);
                if (var1 != null && (var1 == null || !var1.isEmpty())) {
                    var5 = this.buildAttrKey(var1);
                    var2.cachedConnectionAttributes = var1;
                    HashMap var9 = new HashMap();
                    Vector var7 = new Vector();
                    var3 = var7.add(var2);
                    var9.put(var5, var7);
                    var4.attrConnMap = var9;
                } else {
                    Vector var8 = new Vector();
                    var3 = var8.add(var2);
                    var4.userConnList = var8;
                }
            }

            if (var3) {
                ++this.cacheSize;
            }

            if (this.cacheConnectionWaitTimeout > 0) {
                this.notifyAll();
            }

        }
    }

    private String buildAttrKey(Properties var1) throws SQLException {
        int var2 = var1.keySet().size();
        Object[] var3 = var1.keySet().toArray();
        boolean var4 = true;
        StringBuffer var5 = new StringBuffer();

        int var6;
        while(var4) {
            var4 = false;

            for(var6 = 0; var6 < var2 - 1; ++var6) {
                if (((String)var3[var6]).compareTo((String)var3[var6 + 1]) > 0) {
                    var4 = true;
                    Object var7 = var3[var6];
                    var3[var6] = var3[var6 + 1];
                    var3[var6 + 1] = var7;
                }
            }
        }

        for(var6 = 0; var6 < var2; ++var6) {
            var5.append(var3[var6] + "0xffff" + var1.get(var3[var6]));
        }

        return var5.toString();
    }

    protected OraclePooledConnection makeCacheConnection(String var1, String var2) throws SQLException {
        OraclePooledConnection var3 = (OraclePooledConnection)this.connectionPoolDS.getPooledConnection(var1, var2);
        if (var3 != null) {
            if (this.cacheMaxStatementsLimit > 0) {
                this.setStatementCaching(var3, this.cacheMaxStatementsLimit, true);
            }

            var3.registerImplicitCacheConnectionEventListener(new OracleConnectionCacheEventListener(this));
            var3.cachedConnectionAttributes = new Properties();
            if (this.fastConnectionFailoverEnabled) {
                this.initFailoverParameters(var3);
            }

            synchronized(this) {
                ++this.cacheSize;
                if (this.fastConnectionFailoverEnabled && this.runtimeLoadBalancingThread == null) {
                    this.runtimeLoadBalancingThread = new OracleRuntimeLoadBalancingEventHandlerThread(this.dataSourceServiceName);
                    this.cacheManager.checkAndStartThread(this.runtimeLoadBalancingThread);
                }
            }

            var3.localTxnCommitOnClose = this.cacheLocalTxnCommitOnClose;
        }

        return var3;
    }

    private void setStatementCaching(OraclePooledConnection var1, int var2, boolean var3) throws SQLException {
        if (var2 > 0) {
            var1.setStatementCacheSize(var2);
        }

        var1.setImplicitCachingEnabled(var3);
        var1.setExplicitCachingEnabled(var3);
    }

    protected synchronized void reusePooledConnection(PooledConnection var1) throws SQLException {
        OraclePooledConnection var2 = (OraclePooledConnection)var1;
        if (var2 != null && var2.physicalConn != null) {
            if (var2.localTxnCommitOnClose) {
                var2.physicalConn.commit();
            } else if (var2.physicalConn.getProtocolType().equals("thin") && var2.physicalConn.getTransactionState().contains(TransactionState.TRANSACTION_STARTED)) {
                var2.physicalConn.rollback();
            }

            this.storeCacheConnection(var2.cachedConnectionAttributes, var2);
            this.checkedOutConnectionList.removeElement(var2);
            var2.logicalHandle = null;
        }

    }

    protected void closePooledConnection(PooledConnection var1) throws SQLException {
        if (var1 != null) {
            this.actualPooledConnectionClose((OraclePooledConnection)var1);
            if (((OraclePooledConnection)var1).closeOption == 4096) {
                this.checkedOutConnectionList.removeElement(var1);
            }

            var1 = null;
            if (this.getTotalCachedConnections() < this.cacheMinLimit) {
                this.defaultUserPrePopulateCache(1);
            }
        }

    }

    protected void refreshCacheConnections(int var1) throws SQLException {
        this.doForEveryCachedConnection(var1);
    }

    protected void reinitializeCacheConnections(Properties var1) throws SQLException {
        int var5 = 0;
        synchronized(this) {
            this.defaultUser = this.cacheEnabledDS.user;
            this.defaultPassword = this.cacheEnabledDS.password;
            this.fastConnectionFailoverEnabled = this.cacheEnabledDS.getFastConnectionFailoverEnabled();
            this.cleanupTimeoutThread();
            this.doForEveryCheckedOutConnection(1);
            int var2 = this.cacheInitialLimit;
            int var3 = this.cacheMaxLimit;
            int var4 = this.cacheMaxStatementsLimit;
            this.setConnectionCacheProperties(var1);
            if (this.cacheInitialLimit > var2) {
                var5 = this.cacheInitialLimit - var2;
            }

            if (var3 != 2147483647 && this.cacheMaxLimit < var3 && this.cacheSize > this.cacheMaxLimit) {
                this.connectionsToRemove = this.cacheSize - this.cacheMaxLimit;
                this.doForEveryCachedConnection(8);
                this.connectionsToRemove = 0;
            }

            if (this.cacheMaxStatementsLimit != var4) {
                if (this.cacheMaxStatementsLimit == 0) {
                    this.doForEveryCachedConnection(16);
                } else {
                    this.doForEveryCachedConnection(18);
                }
            }
        }

        if (var5 > 0) {
            this.defaultUserPrePopulateCache(var5);
        }

    }

    protected synchronized void setConnectionCacheProperties(Properties var1) throws SQLException {
        try {
            if (var1 != null) {
                String var2 = null;
                if ((var2 = var1.getProperty("MinLimit")) != null && (this.cacheMinLimit = Integer.parseInt(var2)) < 0) {
                    this.cacheMinLimit = 0;
                }

                if ((var2 = var1.getProperty("MaxLimit")) != null && (this.cacheMaxLimit = Integer.parseInt(var2)) < 0) {
                    this.cacheMaxLimit = 2147483647;
                }

                if (this.cacheMaxLimit < this.cacheMinLimit) {
                    this.cacheMinLimit = this.cacheMaxLimit;
                }

                if ((var2 = var1.getProperty("InitialLimit")) != null && (this.cacheInitialLimit = Integer.parseInt(var2)) < 0) {
                    this.cacheInitialLimit = 0;
                }

                if (this.cacheInitialLimit > this.cacheMaxLimit) {
                    this.cacheInitialLimit = this.cacheMaxLimit;
                }

                if ((var2 = var1.getProperty("MaxStatementsLimit")) != null && (this.cacheMaxStatementsLimit = Integer.parseInt(var2)) < 0) {
                    this.cacheMaxStatementsLimit = 0;
                }

                Properties var9 = (Properties)var1.get("AttributeWeights");
                if (var9 != null) {
                    Entry var4 = null;
                    boolean var5 = false;
                    Object var6 = null;
                    Iterator var7 = var9.entrySet().iterator();

                    while(var7.hasNext()) {
                        var4 = (Entry)var7.next();
                        var6 = var4.getKey();
                        if ((var2 = (String)((String)var9.get(var6))) != null && Integer.parseInt(var2) < 0) {
                            var9.put(var6, "0");
                        }
                    }

                    if (this.cacheAttributeWeights == null) {
                        this.cacheAttributeWeights = new Properties();
                    }

                    this.cacheAttributeWeights.putAll(var9);
                }

                if ((var2 = var1.getProperty("InactivityTimeout")) != null && (this.cacheInactivityTimeout = Integer.parseInt(var2)) < 0) {
                    this.cacheInactivityTimeout = 0;
                }

                if ((var2 = var1.getProperty("TimeToLiveTimeout")) != null && (this.cacheTimeToLiveTimeout = Integer.parseInt(var2)) < 0) {
                    this.cacheTimeToLiveTimeout = 0;
                }

                if ((var2 = var1.getProperty("AbandonedConnectionTimeout")) != null && (this.cacheAbandonedConnectionTimeout = Integer.parseInt(var2)) < 0) {
                    this.cacheAbandonedConnectionTimeout = 0;
                }

                if ((var2 = var1.getProperty("LowerThresholdLimit")) != null) {
                    this.cacheLowerThresholdLimit = Integer.parseInt(var2);
                    if (this.cacheLowerThresholdLimit < 0 || this.cacheLowerThresholdLimit > 100) {
                        this.cacheLowerThresholdLimit = 20;
                    }
                }

                if ((var2 = var1.getProperty("PropertyCheckInterval")) != null && (this.cachePropertyCheckInterval = Integer.parseInt(var2)) < 0) {
                    this.cachePropertyCheckInterval = 900;
                }

                if ((var2 = var1.getProperty("ValidateConnection")) != null) {
                    this.cacheValidateConnection = Boolean.valueOf(var2);
                }

                if ((var2 = var1.getProperty("ClosestConnectionMatch")) != null) {
                    this.cacheClosestConnectionMatch = Boolean.valueOf(var2);
                }

                if ((var2 = var1.getProperty("UseLIFO")) != null) {
                    this.cacheUseLIFO = Boolean.valueOf(var2);
                }

                if ((var2 = var1.getProperty("ConnectionWaitTimeout")) != null && (this.cacheConnectionWaitTimeout = Integer.parseInt(var2)) < 0) {
                    this.cacheConnectionWaitTimeout = 0;
                }

                if ((var2 = var1.getProperty("LocalTransactionCommitOnClose")) != null) {
                    this.cacheLocalTxnCommitOnClose = var2.equalsIgnoreCase("true");
                }
            } else {
                this.cacheMinLimit = 0;
                this.cacheMaxLimit = 2147483647;
                this.cacheInitialLimit = 0;
                this.cacheMaxStatementsLimit = 0;
                this.cacheAttributeWeights = null;
                this.cacheInactivityTimeout = 0;
                this.cacheTimeToLiveTimeout = 0;
                this.cacheAbandonedConnectionTimeout = 0;
                this.cacheLowerThresholdLimit = 20;
                this.cachePropertyCheckInterval = 900;
                this.cacheClosestConnectionMatch = false;
                this.cacheValidateConnection = false;
                this.cacheConnectionWaitTimeout = 0;
                this.cacheLocalTxnCommitOnClose = false;
                this.cacheUseLIFO = false;
            }

            if ((this.cacheInactivityTimeout > 0 || this.cacheTimeToLiveTimeout > 0 || this.cacheAbandonedConnectionTimeout > 0) && this.cachePropertyCheckInterval > 0) {
                if (this.timeoutThread == null) {
                    this.timeoutThread = new OracleImplicitConnectionCacheThread(this);
                }

                this.cacheManager.checkAndStartThread(this.timeoutThread);
            }

            if (this.cachePropertyCheckInterval == 0) {
                this.cleanupTimeoutThread();
            }

        } catch (NumberFormatException var8) {
            SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 139, "OracleImplicitConnectionCache:setConnectionCacheProperties() - NumberFormatException Occurred :" + var8.getMessage());
            var3.fillInStackTrace();
            throw var3;
        }
    }

    protected Properties getConnectionCacheProperties() throws SQLException {
        Properties var1 = new Properties();
        var1.setProperty("MinLimit", String.valueOf(this.cacheMinLimit));
        var1.setProperty("MaxLimit", String.valueOf(this.cacheMaxLimit));
        var1.setProperty("InitialLimit", String.valueOf(this.cacheInitialLimit));
        var1.setProperty("MaxStatementsLimit", String.valueOf(this.cacheMaxStatementsLimit));
        if (this.cacheAttributeWeights != null) {
            var1.put("AttributeWeights", this.cacheAttributeWeights);
        } else {
            var1.setProperty("AttributeWeights", "NULL");
        }

        var1.setProperty("InactivityTimeout", String.valueOf(this.cacheInactivityTimeout));
        var1.setProperty("TimeToLiveTimeout", String.valueOf(this.cacheTimeToLiveTimeout));
        var1.setProperty("AbandonedConnectionTimeout", String.valueOf(this.cacheAbandonedConnectionTimeout));
        var1.setProperty("LowerThresholdLimit", String.valueOf(this.cacheLowerThresholdLimit));
        var1.setProperty("PropertyCheckInterval", String.valueOf(this.cachePropertyCheckInterval));
        var1.setProperty("ConnectionWaitTimeout", String.valueOf(this.cacheConnectionWaitTimeout));
        var1.setProperty("ValidateConnection", String.valueOf(this.cacheValidateConnection));
        var1.setProperty("ClosestConnectionMatch", String.valueOf(this.cacheClosestConnectionMatch));
        var1.setProperty("LocalTransactionCommitOnClose", String.valueOf(this.cacheLocalTxnCommitOnClose));
        var1.setProperty("UseLIFO", String.valueOf(this.cacheUseLIFO));
        return var1;
    }

    protected int testDatabaseConnection(OracleConnection var1) throws SQLException {
        return var1.pingDatabase();
    }

    protected synchronized void closeConnectionCache(int var1) throws SQLException {
        this.cleanupTimeoutThread();
        this.purgeCacheConnections(true, var1);
        this.connectionPoolDS = null;
        this.cacheEnabledDS = null;
        this.checkedOutConnectionList = null;
        this.userMap = null;
        this.cacheManager = null;
    }

    protected synchronized void disableConnectionCache() throws SQLException {
        this.disableConnectionRequest = true;
    }

    protected synchronized void enableConnectionCache() throws SQLException {
        this.disableConnectionRequest = false;
    }

    protected void initFailoverParameters(OraclePooledConnection var1) throws SQLException {
        String var2 = null;
        String var3 = null;
        String var4 = null;
        Properties var5 = ((OracleConnection)((OracleConnection)var1.getPhysicalHandle())).getServerSessionInfo();
        var4 = var5.getProperty("INSTANCE_NAME");
        if (var4 != null) {
            var2 = var1.dataSourceInstanceNameKey = var4.trim().toLowerCase().intern();
        }

        var4 = var5.getProperty("SERVER_HOST");
        if (var4 != null) {
            var1.dataSourceHostNameKey = var4.trim().toLowerCase().intern();
        }

        var4 = var5.getProperty("SERVICE_NAME");
        if (var4 != null) {
            this.dataSourceServiceName = var4.trim();
        }

        var4 = var5.getProperty("DATABASE_NAME");
        if (var4 != null) {
            var3 = var1.dataSourceDbUniqNameKey = var4.trim().toLowerCase().intern();
        }

        if (this.databaseInstancesList == null) {
            this.databaseInstancesList = new LinkedList();
        }

        int var6 = this.databaseInstancesList.size();
        synchronized(this.databaseInstancesList) {
            OracleDatabaseInstance var8 = null;
            boolean var9 = false;

            for(int var10 = 0; var10 < var6; ++var10) {
                var8 = (OracleDatabaseInstance)this.databaseInstancesList.get(var10);
                if (var8.databaseUniqName == var3 && var8.instanceName == var2) {
                    ++var8.numberOfConnectionsCount;
                    var9 = true;
                    break;
                }
            }

            if (!var9) {
                OracleDatabaseInstance var13 = new OracleDatabaseInstance(var3, var2);
                ++var13.numberOfConnectionsCount;
                this.databaseInstancesList.add(var13);
            }

        }
    }

    protected void processFailoverEvent(int var1, String var2, String var3, String var4, String var5, int var6) {
        if (var1 == 256) {
            if (!var5.equalsIgnoreCase("down") && !var5.equalsIgnoreCase("not_restarting") && !var5.equalsIgnoreCase("restart_failed")) {
                if (var5.equalsIgnoreCase("up")) {
                    if (this.downEventCount > 0) {
                        ++this.upEventCount;
                    }

                    try {
                        this.processUpEvent(var6);
                    } catch (Exception var8) {
                    }

                    this.isEntireServiceDownProcessed = false;
                }
            } else {
                ++this.downEventCount;
                this.markDownLostConnections(true, false, var2, var3, var4, var5);
                this.cleanupFailoverConnections(true, false, var2, var3, var4, var5);
            }
        } else if (var1 == 512 && var5.equalsIgnoreCase("nodedown")) {
            this.markDownLostConnections(false, true, var2, var3, var4, var5);
            this.cleanupFailoverConnections(false, true, var2, var3, var4, var5);
        }

    }

    void processUpEvent(int var1) throws SQLException {
        boolean var2 = false;
        boolean var3 = false;
        int var4 = this.getTotalCachedConnections();
        boolean var5 = false;
        int var10;
        synchronized(this) {
            if (var1 <= 1) {
                var1 = 2;
            }

            int var9;
            if (this.downEventCount == 0 && this.upEventCount == 0 && this.getNumberOfDefaultUserConnections() > 0) {
                var9 = (int)((double)this.cacheSize * 0.25D);
            } else {
                var9 = this.defaultUserPreFailureSize;
            }

            if (var9 <= 0) {
                if (this.getNumberOfDefaultUserConnections() <= 0) {
                    return;
                }

                var10 = (int)((double)this.cacheSize * 0.25D);
                var5 = true;
            } else {
                var10 = var9 / var1;
                if (var10 + var4 > this.cacheMaxLimit) {
                    var5 = true;
                }
            }

            if (this.downEventCount == this.upEventCount) {
                this.defaultUserPreFailureSize = 0;
                this.downEventCount = 0;
                this.upEventCount = 0;
            }
        }

        if (var10 > 0) {
            this.loadBalanceConnections(var10, var5);
        }

    }

    private void loadBalanceConnections(int var1, boolean var2) throws SQLException {
        if (var2) {
            this.connectionsToRemove = var1;
            this.doForEveryCachedConnection(8);
            this.connectionsToRemove = 0;
        }

        if (var1 <= 10) {
            try {
                this.defaultUserPrePopulateCache(var1);
            } catch (Exception var7) {
            }
        } else {
            int var3 = (int)((double)var1 * 0.25D);

            for(int var4 = 0; var4 < 4; ++var4) {
                try {
                    this.defaultUserPrePopulateCache(var3);
                } catch (Exception var6) {
                }
            }
        }

    }

    private int getNumberOfDefaultUserConnections() {
        int var1 = 0;
        if (this.userMap != null && !this.userMap.isEmpty()) {
            OracleConnectionCacheEntry var2 = (OracleConnectionCacheEntry)this.userMap.get(OraclePooledConnection.generateKey(this.defaultUser, this.defaultPassword));
            if (var2 != null && var2.userConnList != null && !var2.userConnList.isEmpty()) {
                var1 = var2.userConnList.size();
            }
        }

        return var1;
    }

    synchronized void markDownLostConnections(boolean var1, boolean var2, String var3, String var4, String var5, String var6) {
        if (!this.isEntireServiceDownProcessed) {
            if (this.userMap != null && !this.userMap.isEmpty()) {
                Iterator var7 = this.userMap.entrySet().iterator();

                label102:
                while(true) {
                    OracleConnectionCacheEntry var11;
                    do {
                        do {
                            do {
                                if (!var7.hasNext()) {
                                    break label102;
                                }

                                boolean var8 = false;
                                Entry var9 = (Entry)var7.next();
                                String var10 = null;
                                if (this.defaultUser != null && this.defaultPassword != null) {
                                    var10 = this.defaultUser + this.defaultPassword;
                                }

                                if (var10 != null && var10.equalsIgnoreCase((String)var9.getKey())) {
                                    var8 = true;
                                }

                                var11 = (OracleConnectionCacheEntry)var9.getValue();
                                if (var11 != null && var11.userConnList != null && !var11.userConnList.isEmpty()) {
                                    boolean var12 = false;
                                    Iterator var13 = var11.userConnList.iterator();

                                    while(var13.hasNext()) {
                                        OraclePooledConnection var14 = (OraclePooledConnection)var13.next();
                                        if (var1) {
                                            var12 = this.markDownConnectionsForServiceEvent(var3, var4, var14);
                                        } else if (var2) {
                                            var12 = this.markDownConnectionsForHostEvent(var5, var14);
                                        }

                                        if (var12 && var8) {
                                            ++this.defaultUserPreFailureSize;
                                        }
                                    }
                                }
                            } while(var11 == null);
                        } while(var11.attrConnMap == null);
                    } while(var11.attrConnMap.isEmpty());

                    Iterator var16 = var11.attrConnMap.entrySet().iterator();

                    while(var16.hasNext()) {
                        Entry var17 = (Entry)var16.next();
                        Iterator var18 = ((Vector)var17.getValue()).iterator();

                        while(var18.hasNext()) {
                            OraclePooledConnection var15 = (OraclePooledConnection)var18.next();
                            if (var1) {
                                this.markDownConnectionsForServiceEvent(var3, var4, var15);
                            } else if (var2) {
                                this.markDownConnectionsForHostEvent(var5, var15);
                            }
                        }
                    }
                }
            }

            if (var3 == null) {
                this.isEntireServiceDownProcessed = true;
            }
        }

    }

    private boolean markDownConnectionsForServiceEvent(String var1, String var2, OraclePooledConnection var3) {
        boolean var4 = false;
        if (var1 == null || var2 == var3.dataSourceDbUniqNameKey && var1 == var3.dataSourceInstanceNameKey) {
            var3.connectionMarkedDown = true;
            var4 = true;
        }

        return var4;
    }

    private boolean markDownConnectionsForHostEvent(String var1, OraclePooledConnection var2) {
        boolean var3 = false;
        if (var1 == var2.dataSourceHostNameKey) {
            var2.connectionMarkedDown = true;
            var2.needToAbort = true;
            var3 = true;
        }

        return var3;
    }

    synchronized void cleanupFailoverConnections(boolean var1, boolean var2, String var3, String var4, String var5, String var6) {
        OraclePooledConnection var7 = null;
        Object[] var8 = this.checkedOutConnectionList.toArray();
        int var9 = this.checkedOutConnectionList.size();
        OraclePooledConnection[] var10 = new OraclePooledConnection[var9];
        int var11 = 0;

        int var12;
        for(var12 = 0; var12 < var9; ++var12) {
            try {
                var7 = (OraclePooledConnection)var8[var12];
                if (var1 && (var3 == null || var3 == var7.dataSourceInstanceNameKey) && var4 == var7.dataSourceDbUniqNameKey || var2 && var5 == var7.dataSourceHostNameKey) {
                    if (var7.isSameUser(this.defaultUser, this.defaultPassword) && var7.cachedConnectionAttributes != null && var7.cachedConnectionAttributes.isEmpty()) {
                        ++this.defaultUserPreFailureSize;
                    }

                    this.checkedOutConnectionList.removeElement(var7);
                    this.abortConnection(var7);
                    var7.needToAbort = true;
                    var10[var11++] = var7;
                }
            } catch (Exception var19) {
            }
        }

        for(var12 = 0; var12 < var11; ++var12) {
            try {
                this.closeCheckedOutConnection(var10[var12], false);
            } catch (SQLException var17) {
            }
        }

        if (this.checkedOutConnectionList.size() < var9 && this.cacheConnectionWaitTimeout > 0) {
            this.notifyAll();
        }

        try {
            this.doForEveryCachedConnection(2);
        } catch (SQLException var16) {
        }

        if (this.databaseInstancesList != null && (var9 = this.databaseInstancesList.size()) > 0) {
            synchronized(this.databaseInstancesList) {
                OracleDatabaseInstance var13 = null;
                var8 = this.databaseInstancesList.toArray();

                for(int var14 = 0; var14 < var9; ++var14) {
                    var13 = (OracleDatabaseInstance)var8[var14];
                    if (var13.databaseUniqName == var4 && var13.instanceName == var3) {
                        if (var13.flag <= 3) {
                            this.dbInstancePercentTotal -= var13.percent;
                        }

                        this.databaseInstancesList.remove(var13);
                    }
                }
            }
        }

    }

    void zapRLBInfo() {
        this.databaseInstancesList.clear();
    }

    protected synchronized void closeAndRemovePooledConnection(OraclePooledConnection var1) throws SQLException {
        if (var1 != null) {
            if (var1.needToAbort) {
                this.abortConnection(var1);
            }

            this.actualPooledConnectionClose(var1);
            this.removeCacheConnection(var1);
        }

    }

    private void abortConnection(OraclePooledConnection var1) {
        try {
            ((OracleConnection)((OracleConnection)var1.getPhysicalHandle())).abort();
        } catch (Exception var3) {
        }

    }

    private void actualPooledConnectionClose(OraclePooledConnection var1) throws SQLException {
        boolean var2 = false;
        int var9;
        if (this.databaseInstancesList != null && (var9 = this.databaseInstancesList.size()) > 0) {
            synchronized(this.databaseInstancesList) {
                OracleDatabaseInstance var4 = null;

                for(int var5 = 0; var5 < var9; ++var5) {
                    var4 = (OracleDatabaseInstance)this.databaseInstancesList.get(var5);
                    if (var4.databaseUniqName == var1.dataSourceDbUniqNameKey && var4.instanceName == var1.dataSourceInstanceNameKey) {
                        if (var4.numberOfConnectionsCount > 0) {
                            --var4.numberOfConnectionsCount;
                        }
                        break;
                    }
                }
            }
        }

        try {
            ++this.connectionClosedCount;
            var1.close();
        } catch (SQLException var7) {
        }

    }

    protected int getCacheTimeToLiveTimeout() {
        return this.cacheTimeToLiveTimeout;
    }

    protected int getCacheInactivityTimeout() {
        return this.cacheInactivityTimeout;
    }

    protected int getCachePropertyCheckInterval() {
        return this.cachePropertyCheckInterval;
    }

    protected int getCacheAbandonedTimeout() {
        return this.cacheAbandonedConnectionTimeout;
    }

    private synchronized void processConnectionCacheCallback() throws SQLException {
        float var1 = (float)this.cacheMaxLimit / 100.0F;
        int var2 = (int)((float)this.cacheLowerThresholdLimit * var1);
        this.releaseBasedOnPriority(1024, var2);
        if (this.cacheSize < var2) {
            this.releaseBasedOnPriority(512, var2);
        }

    }

    private void releaseBasedOnPriority(int var1, int var2) throws SQLException {
        Object[] var3 = this.checkedOutConnectionList.toArray();

        for(int var4 = 0; var4 < var3.length && this.cacheSize < var2; ++var4) {
            OraclePooledConnection var5 = (OraclePooledConnection)var3[var4];
            OracleConnection var6 = null;
            if (var5 != null) {
                var6 = (OracleConnection)((OracleConnection)var5.getLogicalHandle());
            }

            if (var6 != null) {
                OracleConnectionCacheCallback var7 = var6.getConnectionCacheCallbackObj();
                if (var7 != null && (var6.getConnectionCacheCallbackFlag() == 2 || var6.getConnectionCacheCallbackFlag() == 4) && var1 == var6.getConnectionReleasePriority()) {
                    Object var8 = var6.getConnectionCacheCallbackPrivObj();
                    var7.releaseConnection(var6, var8);
                }
            }
        }

    }

    private synchronized void processConnectionWaitTimeout(long var1) throws SQLException {
        try {
            this.wait(var1);
        } catch (InterruptedException var4) {
        }

    }

    private void processInactivityTimeout(OraclePooledConnection var1) throws SQLException {
        long var2 = var1.getLastAccessedTime();
        long var4 = System.currentTimeMillis();
        if (this.getTotalCachedConnections() > this.cacheMinLimit && var4 - var2 > (long)(this.cacheInactivityTimeout * 1000)) {
            this.closeAndRemovePooledConnection(var1);
        }

    }

    private void cleanupTimeoutThread() throws SQLException {
        if (this.timeoutThread != null) {
            this.timeoutThread.timeToLive = false;
            if (this.timeoutThread.isSleeping) {
                this.timeoutThread.interrupt();
            }

            this.timeoutThread = null;
        }

    }

    protected void purgeCacheConnections(boolean var1, int var2) {
        try {
            if (var1) {
                this.doForEveryCheckedOutConnection(var2);
            }

            this.doForEveryCachedConnection(var2);
        } catch (SQLException var4) {
        }

    }

    protected void updateDatabaseInstance(String var1, String var2, int var3, int var4) {
        if (this.databaseInstancesList == null) {
            this.databaseInstancesList = new LinkedList();
        }

        synchronized(this.databaseInstancesList) {
            int var6 = this.databaseInstancesList.size();
            boolean var7 = false;

            for(int var8 = 0; var8 < var6; ++var8) {
                OracleDatabaseInstance var9 = (OracleDatabaseInstance)this.databaseInstancesList.get(var8);
                if (var9.databaseUniqName == var1 && var9.instanceName == var2) {
                    var9.percent = var3;
                    var9.flag = var4;
                    var7 = true;
                    break;
                }
            }

            if (!var7) {
                OracleDatabaseInstance var12 = new OracleDatabaseInstance(var1, var2);
                var12.percent = var3;
                var12.flag = var4;
                this.databaseInstancesList.add(var12);
            }

        }
    }

    protected void processDatabaseInstances() throws SQLException {
        OracleDatabaseInstance var1 = null;
        if (this.databaseInstancesList != null) {
            synchronized(this.databaseInstancesList) {
                int var3 = 0;
                boolean var4 = false;
                this.useGoodGroup = false;
                int var5 = this.databaseInstancesList.size();

                int var6;
                for(var6 = 0; var6 < var5; ++var6) {
                    var1 = (OracleDatabaseInstance)this.databaseInstancesList.get(var6);
                    if (var1.flag <= 3) {
                        var3 += var1.percent;
                    }
                }

                if (var3 > 0) {
                    this.dbInstancePercentTotal = var3;
                    this.useGoodGroup = true;
                }

                if (var5 > 1) {
                    for(var6 = 0; var6 < var5; ++var6) {
                        var1 = (OracleDatabaseInstance)this.databaseInstancesList.get(var6);
                        this.countTotal += var1.attemptedConnRequestCount;
                    }

                    if (this.countTotal > var5 * 1000) {
                        for(var6 = 0; var6 < var5; ++var6) {
                            var1 = (OracleDatabaseInstance)this.databaseInstancesList.get(var6);
                            float var7 = (float)var1.attemptedConnRequestCount / (float)this.countTotal;
                            float var8 = (float)var1.numberOfConnectionsCount / (float)this.getTotalCachedConnections();
                            if (var8 > var7 * 2.0F) {
                                if ((int)((double)var1.numberOfConnectionsCount * 0.25D) >= 1) {
                                    this.instancesToRetireQueue.addElement(var1);
                                }

                                var4 = true;
                            }
                        }

                        if (var4) {
                            for(var6 = 0; var6 < var5; ++var6) {
                                var1 = (OracleDatabaseInstance)this.databaseInstancesList.get(var6);
                                var1.attemptedConnRequestCount = 0;
                            }

                            var4 = false;
                        }
                    }
                }
            }

            if (this.instancesToRetireQueue.size() > 0) {
                if (this.gravitateCacheThread != null) {
                    try {
                        this.gravitateCacheThread.interrupt();
                        this.gravitateCacheThread.join();
                    } catch (InterruptedException var10) {
                    }

                    this.gravitateCacheThread = null;
                }

                this.gravitateCacheThread = new OracleGravitateConnectionCacheThread(this);
                this.cacheManager.checkAndStartThread(this.gravitateCacheThread);
            }
        }

    }

    protected void gravitateCache() {
        while(this.instancesToRetireQueue.size() > 0) {
            this.instanceToRetire = (OracleDatabaseInstance)this.instancesToRetireQueue.remove(0);
            this.retireConnectionsCount = (int)((double)this.instanceToRetire.numberOfConnectionsCount * 0.25D);

            try {
                this.doForEveryCachedConnection(24);
            } catch (SQLException var3) {
            }

            if (this.retireConnectionsCount > 0) {
                try {
                    this.doForEveryCheckedOutConnection(24);
                } catch (SQLException var2) {
                }
            }
        }

        this.retireConnectionsCount = 0;
        this.instanceToRetire = null;
        this.countTotal = 0;
    }

    protected void cleanupRLBThreads() {
        if (this.gravitateCacheThread != null) {
            try {
                this.gravitateCacheThread.interrupt();
                this.gravitateCacheThread.join();
            } catch (InterruptedException var3) {
            }

            this.gravitateCacheThread = null;
        }

        if (this.runtimeLoadBalancingThread != null) {
            try {
                this.runtimeLoadBalancingThread.interrupt();
            } catch (Exception var2) {
            }

            this.runtimeLoadBalancingThread = null;
        }

    }

    Map getStatistics() throws SQLException {
        HashMap var1 = new HashMap(2);
        var1.put("PhysicalConnectionClosedCount", new Integer(this.connectionClosedCount));
        var1.put("PhysicalConnectionCreatedCount", new Integer(this.connectionCreatedCount));
        return var1;
    }

    protected OracleConnection getConnectionDuringExceptionHandling() {
        return null;
    }
}
