//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package oracle.jdbc.driver;

import java.lang.management.ManagementFactory;
import java.lang.management.MemoryMXBean;
import java.lang.management.MemoryPoolMXBean;
import java.lang.management.MemoryType;
import java.lang.management.MemoryUsage;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.regex.Pattern;
import javax.management.Notification;
import javax.management.NotificationEmitter;
import javax.management.NotificationFilter;
import javax.management.NotificationListener;

abstract class BlockSource {
    private static final int BLOCK_SIZE = 32768;
    private static final String _Copyright_2007_Oracle_All_Rights_Reserved_ = null;
    public static final String BUILD_DATE = "Thu_Apr_04_15:09:24_PDT_2013";
    public static final boolean TRACE = false;

    BlockSource() {
    }

    static final BlockSource createBlockSource(boolean var0, BlockSource.Implementation var1) {
        return var0 ? BlockSource.ThreadLocalBlockSource.createBlockSource(var1) : createBlockSource(var1);
    }

    static BlockSource createBlockSource(BlockSource.Implementation var0) {
        switch(var0) {
            case DUMB:
                return BlockSource.DumbBlockSource.createBlockSource();
            case SIMPLE:
                return BlockSource.SimpleCachingBlockSource.createBlockSource();
            case SOFT:
                return BlockSource.SoftCachingBlockSource.createBlockSource();
            case THREADED:
                return BlockSource.ThreadedCachingBlockSource.createBlockSource();
            default:
                return null;
        }
    }

    abstract int getBlockSize();

    abstract byte[] get();

    abstract void put(byte[] var1);

    private static final class ThreadLocalBlockSource extends BlockSource {
        private static BlockSource.Implementation IMPL = null;
        private static final ThreadLocal<BlockSource> REF = new ThreadLocal<BlockSource>() {
            protected BlockSource initialValue() {
                return BlockSource.createBlockSource(BlockSource.ThreadLocalBlockSource.IMPL);
            }
        };

        static BlockSource createBlockSource(BlockSource.Implementation var0) {
            assert IMPL == null || IMPL == var0 : "IMPL: " + IMPL + " impl: " + var0;

            IMPL = var0;
            return new BlockSource.ThreadLocalBlockSource();
        }

        private ThreadLocalBlockSource() {
        }

        int getBlockSize() {
            return ((BlockSource)REF.get()).getBlockSize();
        }

        byte[] get() {
            BlockSource var1 = (BlockSource)REF.get();
            return var1.get();
        }

        void put(byte[] var1) {
            BlockSource var2 = (BlockSource)REF.get();
            var2.put(var1);
        }
    }

    private static final class SoftCachingBlockSource extends BlockSource {
        private static final int CACHE_SIZE = 1024;
        private final SoftReference<byte[]>[] blocks = new SoftReference[1024];
        private int top = 0;
        private static final String _Copyright_2007_Oracle_All_Rights_Reserved_ = null;
        public static final String BUILD_DATE = "Thu_Apr_04_15:09:24_PDT_2013";
        public static final boolean TRACE = false;

        private static BlockSource createBlockSource() {
            return new BlockSource.SoftCachingBlockSource();
        }

        private SoftCachingBlockSource() {
        }

        int getBlockSize() {
            return 32768;
        }

        byte[] get() {
            while(true) {
                if (this.top > 0) {
                    SoftReference var1 = this.blocks[--this.top];
                    this.blocks[this.top] = null;
                    byte[] var2 = (byte[])var1.get();
                    if (var2 == null) {
                        continue;
                    }

                    return var2;
                }

                return new byte['耀'];
            }
        }

        void put(byte[] var1) {
            assert var1 != null : "block is null";

            assert var1.length == 32768 : "block.length: " + var1.length;

            if (this.top < this.blocks.length) {
                this.blocks[this.top++] = new SoftReference(var1);
            } else {
                int var2 = this.top;

                while(var2 > 0) {
                    --var2;
                    if (this.blocks[var2].get() == null) {
                        this.blocks[var2] = new SoftReference(var1);
                        return;
                    }
                }
            }

        }
    }

    static final class ThreadedCachingBlockSource extends BlockSource {
        private static final BlockSource.ThreadedCachingBlockSource.BlockReleaser RELEASER;
        private static final BlockSource.ThreadedCachingBlockSource.BlockReleaserListener LISTENER;
        private static final Collection<WeakReference<BlockSource.ThreadedCachingBlockSource>> ALL_INSTANCES;
        private static final int INITIAL_CACHE_SIZE = 32;
        private int top = 0;
        private byte[][] stack = new byte[32][];
        private int lowWaterMark = 0;
        private int recentLowWaterMark = 0;

        private static void releaseFromAllSources() {
            synchronized(ALL_INSTANCES) {
                Iterator var1 = ALL_INSTANCES.iterator();

                while(var1.hasNext()) {
                    BlockSource.ThreadedCachingBlockSource var2 = (BlockSource.ThreadedCachingBlockSource)((WeakReference)var1.next()).get();
                    if (var2 == null) {
                        var1.remove();
                    } else {
                        var2.releaseUnusedBlocks();
                    }
                }

            }
        }

        static BlockSource createBlockSource() {
            BlockSource.ThreadedCachingBlockSource var0 = new BlockSource.ThreadedCachingBlockSource();
            WeakReference var1 = new WeakReference(var0);
            synchronized(ALL_INSTANCES) {
                ALL_INSTANCES.add(var1);
                return var0;
            }
        }

        private ThreadedCachingBlockSource() {
        }

        final synchronized void releaseUnusedBlocks() {
            assert this.top >= this.recentLowWaterMark;

            this.lowWaterMark = Math.min((this.lowWaterMark + this.recentLowWaterMark) / 2, this.recentLowWaterMark);

            for(int var1 = this.top - this.lowWaterMark; this.top > var1; this.stack[--this.top] = null) {
            }

            this.recentLowWaterMark = this.top;
        }

        private final void checkLowWater() {
            this.recentLowWaterMark = Math.min(this.recentLowWaterMark, this.top);
        }

        final int getBlockSize() {
            return 32768;
        }

        final synchronized byte[] get() {
            if (this.top == 0) {
                return new byte['耀'];
            } else {
                byte[] var1 = this.stack[--this.top];
                this.checkLowWater();
                return var1;
            }
        }

        final synchronized void put(byte[] var1) {
            assert var1.length == 32768 : "block.length: " + var1.length;

            if (this.top == this.stack.length) {
                byte[][] var2 = new byte[this.stack.length * 4][];
                System.arraycopy(this.stack, 0, var2, 0, this.stack.length);
                this.stack = var2;
            }

            this.stack[this.top++] = var1;
        }

        static {
            RELEASER = BlockSource.ThreadedCachingBlockSource.BlockReleaser.SOLE_INSTANCE;
            LISTENER = BlockSource.ThreadedCachingBlockSource.BlockReleaserListener.SOLE_INSTANCE;
            ALL_INSTANCES = new LinkedList();
        }

        private static final class BlockReleaserListener implements NotificationListener {
            private static final BlockSource.ThreadedCachingBlockSource.BlockReleaserListener SOLE_INSTANCE = new BlockSource.ThreadedCachingBlockSource.BlockReleaserListener();

            private BlockReleaserListener() {
                MemoryMXBean var1 = ManagementFactory.getMemoryMXBean();
                NotificationEmitter var2 = (NotificationEmitter)var1;
                var2.addNotificationListener(this, (NotificationFilter)null, (Object)null);
                Pattern var3 = Pattern.compile(".*Old.*");
                Iterator var4 = ManagementFactory.getMemoryPoolMXBeans().iterator();

                while(var4.hasNext()) {
                    final MemoryPoolMXBean var5 = (MemoryPoolMXBean)var4.next();
                    if (var5.getType() == MemoryType.HEAP && var5.isCollectionUsageThresholdSupported() && var3.matcher(var5.getName()).matches() && var5.getCollectionUsageThreshold() == 0L) {
                        MemoryUsage var6 = var5.getUsage();
                        final long var7 = (long)(var6.getMax() == -1L ? (double)Runtime.getRuntime().maxMemory() * 0.9D : (double)var6.getMax() * 0.9D);
                        AccessController.doPrivileged(new PrivilegedAction() {
                            public Object run() {
                                var5.setCollectionUsageThreshold(var7);
                                return null;
                            }
                        });
                    }
                }

            }

            public void handleNotification(Notification var1, Object var2) {
                String var3 = var1.getType();
                if (var3.equals("java.management.memory.collection.threshold.exceeded")) {
                    BlockSource.ThreadedCachingBlockSource.BlockReleaser.releaseAllUnusedBlocks();
                }

            }
        }

        private static final class BlockReleaser extends Thread {
            private static final String BLOCK_RELEASER_THREAD_NAME = "oracle.jdbc.driver.BlockSource.ThreadedCachingBlockSource.BlockReleaser";
            private static final int DELAY_MILLIS = 300000;
            private static final BlockSource.ThreadedCachingBlockSource.BlockReleaser SOLE_INSTANCE = new BlockSource.ThreadedCachingBlockSource.BlockReleaser();

            static void releaseAllUnusedBlocks() {
                synchronized(SOLE_INSTANCE) {
                    SOLE_INSTANCE.notifyAll();
                }
            }

            private BlockReleaser() {
                super("oracle.jdbc.driver.BlockSource.ThreadedCachingBlockSource.BlockReleaser");
                this.setDaemon(true);
                this.setPriority(4);
                this.start();
            }

            public void run() {
                while(true) {
                    try {
                        synchronized(SOLE_INSTANCE) {
                            SOLE_INSTANCE.wait(300000L);
                        }

                        BlockSource.ThreadedCachingBlockSource.releaseFromAllSources();
                    } catch (Throwable var4) {
                    }
                }
            }
        }
    }

    static final class SimpleCachingBlockSource extends BlockSource {
        private static final int INITIAL_CACHE_SIZE = 32;
        private static final long RELEASE_NANOS = 300000000L;
        private int top = 0;
        private byte[][] stack = new byte[32][];
        private int lowWaterMark = 0;
        private int recentLowWaterMark = 0;
        private long nextReleaseNanos = System.nanoTime() + 300000000L;

        static BlockSource createBlockSource() {
            return new BlockSource.SimpleCachingBlockSource();
        }

        private SimpleCachingBlockSource() {
        }

        final void releaseUnusedBlocks() {
            long var1 = System.nanoTime();
            if (var1 >= this.nextReleaseNanos) {
                this.nextReleaseNanos = var1 + 300000000L;

                assert this.top >= this.recentLowWaterMark;

                this.lowWaterMark = Math.min((this.lowWaterMark + this.recentLowWaterMark) / 2, this.recentLowWaterMark);

                for(int var3 = this.top - this.lowWaterMark; this.top > var3; this.stack[--this.top] = null) {
                }

                this.recentLowWaterMark = this.top;
            }
        }

        private final void checkLowWater() {
            this.recentLowWaterMark = Math.min(this.recentLowWaterMark, this.top);
        }

        final int getBlockSize() {
            return 32768;
        }

        final byte[] get() {
            if (this.top == 0) {
                return new byte['耀'];
            } else {
                byte[] var1 = this.stack[--this.top];
                this.checkLowWater();
                return var1;
            }
        }

        final void put(byte[] var1) {
            assert var1.length == 32768 : "block.length: " + var1.length;

            if (this.top == this.stack.length) {
                byte[][] var2 = new byte[this.stack.length * 4][];
                System.arraycopy(this.stack, 0, var2, 0, this.stack.length);
                this.stack = var2;
            }

            this.stack[this.top++] = var1;
            this.releaseUnusedBlocks();
        }
    }

    static class DumbBlockSource extends BlockSource {
        static final BlockSource createBlockSource() {
            return new BlockSource.DumbBlockSource();
        }

        DumbBlockSource() {
        }

        final int getBlockSize() {
            return 32768;
        }

        final byte[] get() {
            return new byte['耀'];
        }

        final void put(byte[] var1) {
        }
    }

    static enum Implementation {
        DUMB,
        SIMPLE,
        SOFT,
        THREADED;

        private Implementation() {
        }
    }
}
