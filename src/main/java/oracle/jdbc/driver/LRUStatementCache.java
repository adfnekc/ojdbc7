//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package oracle.jdbc.driver;

import java.sql.SQLException;
import oracle.jdbc.internal.OracleConnection;

class LRUStatementCache {
    private int cacheSize;
    private int numElements;
    private OracleStatementCacheEntry applicationCacheStart;
    private OracleStatementCacheEntry applicationCacheEnd;
    private OracleStatementCacheEntry implicitCacheStart;
    private OracleStatementCacheEntry explicitCacheStart;
    boolean implicitCacheEnabled;
    boolean explicitCacheEnabled;
    private boolean debug = false;
    private static final String _Copyright_2007_Oracle_All_Rights_Reserved_ = null;
    public static final String BUILD_DATE = "Thu_Apr_04_15:09:24_PDT_2013";
    public static final boolean TRACE = false;

    protected LRUStatementCache(int var1) throws SQLException {
        if (var1 < 0) {
            SQLException var2 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 123);
            var2.fillInStackTrace();
            throw var2;
        } else {
            this.cacheSize = var1;
            this.numElements = 0;
            this.implicitCacheStart = null;
            this.explicitCacheStart = null;
            this.implicitCacheEnabled = false;
            this.explicitCacheEnabled = false;
        }
    }

    protected void resize(int var1) throws SQLException {
        if (var1 < 0) {
            SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 123);
            var3.fillInStackTrace();
            throw var3;
        } else {
            if (var1 < this.cacheSize && var1 < this.numElements) {
                for(OracleStatementCacheEntry var2 = this.applicationCacheEnd; this.numElements > var1; var2 = var2.applicationPrev) {
                    this.purgeCacheEntry(var2);
                }

                this.cacheSize = var1;
            } else {
                this.cacheSize = var1;
            }

        }
    }

    public void setImplicitCachingEnabled(boolean var1) throws SQLException {
        if (!var1) {
            this.purgeImplicitCache();
        }

        this.implicitCacheEnabled = var1;
    }

    public boolean getImplicitCachingEnabled() throws SQLException {
        boolean var1;
        if (this.cacheSize == 0) {
            var1 = false;
        } else {
            var1 = this.implicitCacheEnabled;
        }

        return var1;
    }

    public void setExplicitCachingEnabled(boolean var1) throws SQLException {
        if (!var1) {
            this.purgeExplicitCache();
        }

        this.explicitCacheEnabled = var1;
    }

    public boolean getExplicitCachingEnabled() throws SQLException {
        boolean var1;
        if (this.cacheSize == 0) {
            var1 = false;
        } else {
            var1 = this.explicitCacheEnabled;
        }

        return var1;
    }

    protected void addToImplicitCache(OraclePreparedStatement var1, String var2, int var3, int var4) throws SQLException {
        if (this.implicitCacheEnabled && this.cacheSize != 0 && var1.cacheState != 2) {
            if (this.numElements == this.cacheSize) {
                this.purgeCacheEntry(this.applicationCacheEnd);
            }

            var1.enterImplicitCache();
            OracleStatementCacheEntry var5 = new OracleStatementCacheEntry();
            var5.statement = var1;
            var5.onImplicit = true;
            var5.sql = var2;
            var5.statementType = var3;
            var5.scrollType = var4;
            var5.applicationNext = this.applicationCacheStart;
            var5.applicationPrev = null;
            if (this.applicationCacheStart != null) {
                this.applicationCacheStart.applicationPrev = var5;
            }

            this.applicationCacheStart = var5;
            var5.implicitNext = this.implicitCacheStart;
            var5.implicitPrev = null;
            if (this.implicitCacheStart != null) {
                this.implicitCacheStart.implicitPrev = var5;
            }

            this.implicitCacheStart = var5;
            if (this.applicationCacheEnd == null) {
                this.applicationCacheEnd = var5;
            }

            ++this.numElements;
        }
    }

    protected void addToExplicitCache(OraclePreparedStatement var1, String var2) throws SQLException {
        if (this.explicitCacheEnabled && this.cacheSize != 0 && var1.cacheState != 2) {
            if (this.numElements == this.cacheSize) {
                this.purgeCacheEntry(this.applicationCacheEnd);
            }

            var1.enterExplicitCache();
            OracleStatementCacheEntry var3 = new OracleStatementCacheEntry();
            var3.statement = var1;
            var3.sql = var2;
            var3.onImplicit = false;
            var3.applicationNext = this.applicationCacheStart;
            var3.applicationPrev = null;
            if (this.applicationCacheStart != null) {
                this.applicationCacheStart.applicationPrev = var3;
            }

            this.applicationCacheStart = var3;
            var3.explicitNext = this.explicitCacheStart;
            var3.explicitPrev = null;
            if (this.explicitCacheStart != null) {
                this.explicitCacheStart.explicitPrev = var3;
            }

            this.explicitCacheStart = var3;
            if (this.applicationCacheEnd == null) {
                this.applicationCacheEnd = var3;
            }

            ++this.numElements;
        }
    }

    protected OracleStatement searchImplicitCache(String var1, int var2, int var3, PhysicalConnection var4) throws SQLException {
        if (!this.implicitCacheEnabled) {
            return null;
        } else {
            OracleStatementCacheEntry var5 = null;

            for(var5 = this.implicitCacheStart; var5 != null && (var5.statementType != var2 || var5.scrollType != var3 || !var5.sql.equals(var1)); var5 = var5.implicitNext) {
            }

            if (var5 != null) {
                if (var5.applicationPrev != null) {
                    var5.applicationPrev.applicationNext = var5.applicationNext;
                }

                if (var5.applicationNext != null) {
                    var5.applicationNext.applicationPrev = var5.applicationPrev;
                }

                if (this.applicationCacheStart == var5) {
                    this.applicationCacheStart = var5.applicationNext;
                }

                if (this.applicationCacheEnd == var5) {
                    this.applicationCacheEnd = var5.applicationPrev;
                }

                if (var5.implicitPrev != null) {
                    var5.implicitPrev.implicitNext = var5.implicitNext;
                }

                if (var5.implicitNext != null) {
                    var5.implicitNext.implicitPrev = var5.implicitPrev;
                }

                if (this.implicitCacheStart == var5) {
                    this.implicitCacheStart = var5.implicitNext;
                }

                --this.numElements;
                var5.statement.exitImplicitCacheToActive();
                return var5.statement;
            } else {
                Object var6 = null;
                return (OracleStatement)var6;
            }
        }
    }

    protected OracleStatement searchExplicitCache(String var1) throws SQLException {
        if (!this.explicitCacheEnabled) {
            return null;
        } else {
            OracleStatementCacheEntry var2 = null;

            for(var2 = this.explicitCacheStart; var2 != null && !var2.sql.equals(var1); var2 = var2.explicitNext) {
            }

            if (var2 != null) {
                if (var2.applicationPrev != null) {
                    var2.applicationPrev.applicationNext = var2.applicationNext;
                }

                if (var2.applicationNext != null) {
                    var2.applicationNext.applicationPrev = var2.applicationPrev;
                }

                if (this.applicationCacheStart == var2) {
                    this.applicationCacheStart = var2.applicationNext;
                }

                if (this.applicationCacheEnd == var2) {
                    this.applicationCacheEnd = var2.applicationPrev;
                }

                if (var2.explicitPrev != null) {
                    var2.explicitPrev.explicitNext = var2.explicitNext;
                }

                if (var2.explicitNext != null) {
                    var2.explicitNext.explicitPrev = var2.explicitPrev;
                }

                if (this.explicitCacheStart == var2) {
                    this.explicitCacheStart = var2.explicitNext;
                }

                --this.numElements;
                var2.statement.exitExplicitCacheToActive();
                return var2.statement;
            } else {
                return null;
            }
        }
    }

    protected void purgeImplicitCache() throws SQLException {
        for(OracleStatementCacheEntry var1 = this.implicitCacheStart; var1 != null; var1 = var1.implicitNext) {
            this.purgeCacheEntry(var1);
        }

        this.implicitCacheStart = null;
    }

    protected void purgeExplicitCache() throws SQLException {
        for(OracleStatementCacheEntry var1 = this.explicitCacheStart; var1 != null; var1 = var1.explicitNext) {
            this.purgeCacheEntry(var1);
        }

        this.explicitCacheStart = null;
    }

    private void purgeCacheEntry(OracleStatementCacheEntry var1) throws SQLException {
        if (var1.applicationNext != null) {
            var1.applicationNext.applicationPrev = var1.applicationPrev;
        }

        if (var1.applicationPrev != null) {
            var1.applicationPrev.applicationNext = var1.applicationNext;
        }

        if (this.applicationCacheStart == var1) {
            this.applicationCacheStart = var1.applicationNext;
        }

        if (this.applicationCacheEnd == var1) {
            this.applicationCacheEnd = var1.applicationPrev;
        }

        OraclePreparedStatement var2 = var1.statement;
        if (var1.onImplicit) {
            if (var1.implicitNext != null) {
                var1.implicitNext.implicitPrev = var1.implicitPrev;
            }

            if (var1.implicitPrev != null) {
                var1.implicitPrev.implicitNext = var1.implicitNext;
            }

            if (this.implicitCacheStart == var1) {
                this.implicitCacheStart = var1.implicitNext;
            }
        } else {
            if (var1.explicitNext != null) {
                var1.explicitNext.explicitPrev = var1.explicitPrev;
            }

            if (var1.explicitPrev != null) {
                var1.explicitPrev.explicitNext = var1.explicitNext;
            }

            if (this.explicitCacheStart == var1) {
                this.explicitCacheStart = var1.explicitNext;
            }
        }

        --this.numElements;
        var1.statement.exitExplicitCacheToClose();
    }

    public int getCacheSize() {
        return this.cacheSize;
    }

    public void printCache(String var1) throws SQLException {
        System.out.println("*** Start of Statement Cache Dump (" + var1 + ") ***");
        System.out.println("cache size: " + this.cacheSize + " num elements: " + this.numElements + " implicit enabled: " + this.implicitCacheEnabled + " explicit enabled: " + this.explicitCacheEnabled);
        System.out.println("applicationStart: " + this.applicationCacheStart + "  applicationEnd: " + this.applicationCacheEnd);

        OracleStatementCacheEntry var2;
        for(var2 = this.applicationCacheStart; var2 != null; var2 = var2.applicationNext) {
            var2.print();
        }

        System.out.println("implicitStart: " + this.implicitCacheStart);

        for(var2 = this.implicitCacheStart; var2 != null; var2 = var2.implicitNext) {
            var2.print();
        }

        System.out.println("explicitStart: " + this.explicitCacheStart);

        for(var2 = this.explicitCacheStart; var2 != null; var2 = var2.explicitNext) {
            var2.print();
        }

        System.out.println("*** End of Statement Cache Dump (" + var1 + ") ***");
    }

    public void close() throws SQLException {
        for(OracleStatementCacheEntry var1 = this.applicationCacheStart; var1 != null; var1 = var1.applicationNext) {
            if (var1.onImplicit) {
                var1.statement.exitImplicitCacheToClose();
            } else {
                var1.statement.exitExplicitCacheToClose();
            }
        }

        this.applicationCacheStart = null;
        this.applicationCacheEnd = null;
        this.implicitCacheStart = null;
        this.explicitCacheStart = null;
        this.numElements = 0;
    }

    protected OracleConnection getConnectionDuringExceptionHandling() {
        return null;
    }

    int getNumberOfStatementsInCache() {
        return this.numElements;
    }

    String[] getCachedStrings() {
        int var1 = this.numElements;
        String[] var2 = new String[var1];
        int var3 = 0;

        for(OracleStatementCacheEntry var4 = this.applicationCacheEnd; var3 < var1; ++var3) {
            var2[var3] = var4.statement.sqlObject.getOriginalSql();
            var4 = var4.applicationPrev;
        }

        return var2;
    }
}
