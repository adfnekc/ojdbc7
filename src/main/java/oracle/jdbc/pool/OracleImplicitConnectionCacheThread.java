//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package oracle.jdbc.pool;

import java.sql.Connection;
import java.sql.SQLException;
import oracle.jdbc.internal.OracleConnection;

/** @deprecated */
class OracleImplicitConnectionCacheThread extends Thread {
    private OracleImplicitConnectionCache implicitCache = null;
    protected boolean timeToLive = true;
    protected boolean isSleeping = false;
    private static final String _Copyright_2007_Oracle_All_Rights_Reserved_ = null;
    public static final String BUILD_DATE = "Thu_Apr_04_15:09:24_PDT_2013";
    public static final boolean TRACE = false;

    OracleImplicitConnectionCacheThread(OracleImplicitConnectionCache var1) throws SQLException {
        this.implicitCache = var1;
    }

    public void run() {
        long var1 = 0L;
        long var3 = 0L;
        long var5 = 0L;

        while(this.timeToLive) {
            try {
                if (this.timeToLive && (var1 = (long)this.implicitCache.getCacheTimeToLiveTimeout()) > 0L) {
                    this.runTimeToLiveTimeout(var1);
                }

                if (this.timeToLive && (var3 = (long)this.implicitCache.getCacheInactivityTimeout()) > 0L) {
                    this.runInactivityTimeout();
                }

                if (this.timeToLive && (var5 = (long)this.implicitCache.getCacheAbandonedTimeout()) > 0L) {
                    this.runAbandonedTimeout(var5);
                }

                if (this.timeToLive) {
                    this.isSleeping = true;

                    try {
                        sleep((long)(this.implicitCache.getCachePropertyCheckInterval() * 1000));
                    } catch (InterruptedException var8) {
                    }

                    this.isSleeping = false;
                }

                if (this.implicitCache == null || var1 <= 0L && var3 <= 0L && var5 <= 0L) {
                    this.timeToLive = false;
                }
            } catch (SQLException var9) {
            }
        }

    }

    private void runTimeToLiveTimeout(long var1) throws SQLException {
        long var3 = 0L;
        long var5 = 0L;
        if (this.implicitCache.getNumberOfCheckedOutConnections() > 0) {
            OraclePooledConnection var7 = null;
            synchronized(this.implicitCache) {
                Object[] var9 = this.implicitCache.checkedOutConnectionList.toArray();
                int var10 = this.implicitCache.checkedOutConnectionList.size();

                for(int var11 = 0; var11 < var10; ++var11) {
                    var7 = (OraclePooledConnection)var9[var11];
                    Connection var12 = var7.getLogicalHandle();
                    if (var12 != null) {
                        var5 = ((OracleConnection)var12).getStartTime();
                        var3 = System.currentTimeMillis();
                        if (var3 - var5 > var1 * 1000L) {
                            try {
                                this.implicitCache.closeCheckedOutConnection(var7, true);
                            } catch (SQLException var15) {
                            }
                        }
                    }
                }
            }
        }

    }

    private void runInactivityTimeout() {
        try {
            OracleImplicitConnectionCache var10001 = this.implicitCache;
            this.implicitCache.doForEveryCachedConnection(4);
        } catch (SQLException var2) {
        }

    }

    private void runAbandonedTimeout(long var1) throws SQLException {
        if (this.implicitCache.getNumberOfCheckedOutConnections() > 0) {
            OraclePooledConnection var3 = null;
            synchronized(this.implicitCache) {
                Object[] var5 = this.implicitCache.checkedOutConnectionList.toArray();

                for(int var6 = 0; var6 < var5.length; ++var6) {
                    var3 = (OraclePooledConnection)var5[var6];
                    OracleConnection var7 = (OracleConnection)((OracleConnection)var3.getLogicalHandle());
                    if (var7 != null) {
                        OracleConnectionCacheCallback var8 = var7.getConnectionCacheCallbackObj();
                        if ((long)(var7.getHeartbeatNoChangeCount() * this.implicitCache.getCachePropertyCheckInterval()) > var1) {
                            try {
                                boolean var9 = true;
                                if (var8 != null && (var7.getConnectionCacheCallbackFlag() == 4 || var7.getConnectionCacheCallbackFlag() == 1)) {
                                    var9 = var8.handleAbandonedConnection(var7, var7.getConnectionCacheCallbackPrivObj());
                                }

                                if (var9) {
                                    this.implicitCache.closeCheckedOutConnection(var3, true);
                                    this.implicitCache.checkedOutConnectionList.remove(var3);
                                    this.implicitCache.storeCacheConnection(var3.cachedConnectionAttributes, var3);
                                }
                            } catch (SQLException var11) {
                            }
                        }
                    }
                }
            }
        }

    }
}
