//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package oracle.jdbc.driver;

import java.lang.ref.SoftReference;
import java.lang.reflect.Array;
import oracle.jdbc.internal.OracleConnection.BufferCacheStatistics;

class BufferCache<T> {
    private static final double ln2 = Math.log(2.0D);
    private static final int BUFFERS_PER_BUCKET = 8;
    private static final int MIN_INDEX = 12;
    private final BufferCache.InternalStatistics stats;
    private final int[] bufferSize;
    private final SoftReference<T>[][] buckets;
    private final int[] top;
    private static final String _Copyright_2007_Oracle_All_Rights_Reserved_ = null;
    public static final String BUILD_DATE = "Thu_Apr_04_15:09:24_PDT_2013";
    public static final boolean TRACE = false;

    BufferCache(int var1) {
        int var2;
        if (var1 < 31) {
            var2 = var1;
        } else {
            var2 = (int)Math.ceil(Math.log((double)var1) / ln2);
        }

        int var3 = Math.max(0, var2 - 12 + 1);
        this.buckets = (SoftReference[][])(new SoftReference[var3][8]);
        this.top = new int[var3];
        this.bufferSize = new int[var3];
        int var4 = 4096;

        for(int var5 = 0; var5 < this.bufferSize.length; ++var5) {
            this.bufferSize[var5] = var4;
            var4 <<= 1;
        }

        this.stats = new BufferCache.InternalStatistics(this.bufferSize);
    }

    T get(Class<?> var1, int var2) {
        int var3 = this.bufferIndex(var2);
        if (var3 >= this.buckets.length) {
            this.stats.requestTooBig();
            return (T) Array.newInstance(var1, var2);
        } else {
            Object var5;
            do {
                if (this.top[var3] <= 0) {
                    this.stats.cacheMiss(var3);
                    return (T) Array.newInstance(var1, this.bufferSize[var3]);
                }

                SoftReference var4 = this.buckets[var3][--this.top[var3]];
                this.buckets[var3][this.top[var3]] = null;
                var5 = var4.get();
            } while(var5 == null);

            this.stats.cacheHit(var3);
            return (T) var5;
        }
    }

    void put(T var1) {
        int var2 = Array.getLength(var1);
        int var3 = this.bufferIndex(var2);
        if (var3 < this.buckets.length && var2 == this.bufferSize[var3]) {
            if (this.top[var3] < 8) {
                this.stats.bufferCached(var3);
                this.buckets[var3][this.top[var3]++] = new SoftReference(var1);
            } else {
                int var4 = this.top[var3];

                while(var4 > 0) {
                    SoftReference[] var10000 = this.buckets[var3];
                    --var4;
                    if (var10000[var4].get() == null) {
                        this.stats.refCleared(var3);
                        this.buckets[var3][var4] = new SoftReference(var1);
                        return;
                    }
                }

                this.stats.bucketFull(var3);
            }

        } else {
            this.stats.cacheTooBig();
        }
    }

    BufferCacheStatistics getStatistics() {
        return this.stats;
    }

    private int bufferIndex(int var1) {
        for(int var2 = 0; var2 < this.bufferSize.length; ++var2) {
            if (var1 <= this.bufferSize[var2]) {
                return var2;
            }
        }

        return 2147483647;
    }

    private static final class InternalStatistics implements BufferCacheStatistics {
        private static int CACHE_COUNT = 0;
        private final int cacheId;
        private final int[] sizes;
        private final int[] nCacheHit;
        private final int[] nCacheMiss;
        private int nRequestTooBig;
        private final int[] nBufferCached;
        private final int[] nBucketFull;
        private final int[] nRefCleared;
        private int nCacheTooBig;

        InternalStatistics(int[] var1) {
            this.cacheId = ++CACHE_COUNT;
            this.sizes = var1;
            int var2 = var1.length;
            this.nCacheHit = new int[var2];
            this.nCacheMiss = new int[var2];
            this.nRequestTooBig = 0;
            this.nBufferCached = new int[var2];
            this.nBucketFull = new int[var2];
            this.nRefCleared = new int[var2];
            this.nCacheTooBig = 0;
        }

        void cacheHit(int var1) {
            int var10002 = this.nCacheHit[var1]++;
        }

        void cacheMiss(int var1) {
            int var10002 = this.nCacheMiss[var1]++;
        }

        void requestTooBig() {
            ++this.nRequestTooBig;
        }

        void bufferCached(int var1) {
            int var10002 = this.nBufferCached[var1]++;
        }

        void bucketFull(int var1) {
            int var10002 = this.nBucketFull[var1]++;
        }

        void refCleared(int var1) {
            int var10002 = this.nRefCleared[var1]++;
        }

        void cacheTooBig() {
            ++this.nCacheTooBig;
        }

        public int getId() {
            return this.cacheId;
        }

        public int[] getBufferSizes() {
            int[] var1 = new int[this.sizes.length];
            System.arraycopy(this.sizes, 0, var1, 0, this.sizes.length);
            return var1;
        }

        public int getCacheHits(int var1) {
            return this.nCacheHit[var1];
        }

        public int getCacheMisses(int var1) {
            return this.nCacheMiss[var1];
        }

        public int getRequestsTooBig() {
            return this.nRequestTooBig;
        }

        public int getBuffersCached(int var1) {
            return this.nBufferCached[var1];
        }

        public int getBucketsFull(int var1) {
            return this.nBucketFull[var1];
        }

        public int getReferencesCleared(int var1) {
            return this.nRefCleared[var1];
        }

        public int getTooBigToCache() {
            return this.nCacheTooBig;
        }

        public String toString() {
            int var1 = 0;
            int var2 = 0;
            int var3 = 0;
            int var4 = 0;
            int var5 = 0;

            for(int var6 = 0; var6 < this.sizes.length; ++var6) {
                var1 += this.nCacheHit[var6];
                var2 += this.nCacheMiss[var6];
                var3 += this.nBufferCached[var6];
                var4 += this.nBucketFull[var6];
                var5 += this.nRefCleared[var6];
            }

            String var7 = "oracle.jdbc.driver.BufferCache<" + this.cacheId + ">\n" + "\tTotal Hits   :\t" + var1 + "\n" + "\tTotal Misses :\t" + (var2 + this.nRequestTooBig) + "\n" + "\tTotal Cached :\t" + var3 + "\n" + "\tTotal Dropped:\t" + (var4 + this.nCacheTooBig) + "\n" + "\tTotal Cleared:\t" + var5 + "\n";
            return var7;
        }
    }
}
