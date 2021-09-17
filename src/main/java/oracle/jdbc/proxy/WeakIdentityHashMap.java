//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package oracle.jdbc.proxy;

import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.AbstractCollection;
import java.util.AbstractSet;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.AbstractMap.SimpleEntry;

public class WeakIdentityHashMap<K, V> implements Map<K, V> {
    private static final int DEFAULT_INITIAL_CAPACITY = 16;
    private static final int MAXIMUM_CAPACITY = 1073741824;
    private static final float DEFAULT_LOAD_FACTOR = 0.75F;
    WeakIdentityHashMap.Entry<K, V>[] table;
    private int size;
    private int threshold;
    private final float loadFactor;
    private final ReferenceQueue<Object> queue;
    private static final int CALLS_BEFORE_NEXT_EXPUNGE = 10;
    private int callsBeforeNextExpunge;
    volatile int modCount;
    private static final Object NULL_KEY = new Object();
    private transient Set<java.util.Map.Entry<K, V>> entrySet;
    transient volatile Set<K> keySet;
    transient volatile Collection<V> values;

    private WeakIdentityHashMap.Entry<K, V>[] newTable(int var1) {
        return (WeakIdentityHashMap.Entry[])(new WeakIdentityHashMap.Entry[var1]);
    }

    public WeakIdentityHashMap(int var1, float var2) {
        this.queue = new ReferenceQueue();
        this.callsBeforeNextExpunge = 10;
        this.entrySet = null;
        this.keySet = null;
        this.values = null;
        if (var1 < 0) {
            throw new IllegalArgumentException("Illegal Initial Capacity: " + var1);
        } else {
            if (var1 > 1073741824) {
                var1 = 1073741824;
            }

            if (var2 > 0.0F && !Float.isNaN(var2)) {
                int var3;
                for(var3 = 1; var3 < var1; var3 <<= 1) {
                }

                this.table = this.newTable(var3);
                this.loadFactor = var2;
                this.threshold = (int)((float)var3 * var2);
            } else {
                throw new IllegalArgumentException("Illegal Load factor: " + var2);
            }
        }
    }

    public WeakIdentityHashMap(int var1) {
        this(var1, 0.75F);
    }

    public WeakIdentityHashMap() {
        this.queue = new ReferenceQueue();
        this.callsBeforeNextExpunge = 10;
        this.entrySet = null;
        this.keySet = null;
        this.values = null;
        this.loadFactor = 0.75F;
        this.threshold = 16;
        this.table = this.newTable(16);
    }

    public WeakIdentityHashMap(Map<? extends K, ? extends V> var1) {
        this(Math.max((int)((float)var1.size() / 0.75F) + 1, 16), 0.75F);
        this.putAll(var1);
    }

    private static Object maskNull(Object var0) {
        return var0 == null ? NULL_KEY : var0;
    }

    static Object unmaskNull(Object var0) {
        return var0 == NULL_KEY ? null : var0;
    }

    private static boolean eq(Object var0, Object var1) {
        return var0 == var1;
    }

    private static int indexFor(int var0, int var1) {
        return var0 & var1 - 1;
    }

    private void expungeStaleEntries() {
        Reference var1;
        while((var1 = this.queue.poll()) != null) {
            synchronized(this.queue) {
                WeakIdentityHashMap.Entry var3 = (WeakIdentityHashMap.Entry)var1;
                int var4 = indexFor(var3.hash, this.table.length);
                WeakIdentityHashMap.Entry var5 = this.table[var4];

                WeakIdentityHashMap.Entry var7;
                for(WeakIdentityHashMap.Entry var6 = var5; var6 != null; var6 = var7) {
                    var7 = var6.next;
                    if (var6 == var3) {
                        if (var5 == var3) {
                            this.table[var4] = var7;
                        } else {
                            var5.next = var7;
                        }

                        var3.value = null;
                        --this.size;
                        break;
                    }

                    var5 = var6;
                }
            }
        }

    }

    private WeakIdentityHashMap.Entry<K, V>[] getTable() {
        this.expungeStaleEntries();
        return this.table;
    }

    public int size() {
        if (this.size == 0) {
            return 0;
        } else {
            this.expungeStaleEntries();
            return this.size;
        }
    }

    public boolean isEmpty() {
        return this.size() == 0;
    }

    public V get(Object var1) {
        if (this.callsBeforeNextExpunge-- < 0) {
            this.expungeStaleEntries();
            this.callsBeforeNextExpunge = 10;
        }

        Object var2 = maskNull(var1);
        int var3 = System.identityHashCode(var2);
        WeakIdentityHashMap.Entry[] var4 = this.getTable();
        int var5 = indexFor(var3, var4.length);

        for(WeakIdentityHashMap.Entry var6 = var4[var5]; var6 != null; var6 = var6.next) {
            if (var6.hash == var3 && eq(var2, var6.get())) {
                return (V) var6.value;
            }
        }

        return null;
    }

    public boolean containsKey(Object var1) {
        return this.getEntry(var1) != null;
    }

    WeakIdentityHashMap.Entry<K, V> getEntry(Object var1) {
        Object var2 = maskNull(var1);
        int var3 = System.identityHashCode(var2);
        WeakIdentityHashMap.Entry[] var4 = this.getTable();
        int var5 = indexFor(var3, var4.length);

        WeakIdentityHashMap.Entry var6;
        for(var6 = var4[var5]; var6 != null && (var6.hash != var3 || !eq(var2, var6.get())); var6 = var6.next) {
        }

        return var6;
    }

    public V put(K var1, V var2) {
        if (this.callsBeforeNextExpunge-- < 0) {
            this.expungeStaleEntries();
            this.callsBeforeNextExpunge = 10;
        }

        Object var3 = maskNull(var1);
        int var4 = System.identityHashCode(var3);
        WeakIdentityHashMap.Entry[] var5 = this.getTable();
        int var6 = indexFor(var4, var5.length);

        WeakIdentityHashMap.Entry var7;
        for(var7 = var5[var6]; var7 != null; var7 = var7.next) {
            if (var4 == var7.hash && eq(var3, var7.get())) {
                Object var8 = var7.value;
                if (var2 != var8) {
                    var7.value = var2;
                }

                return (V) var8;
            }
        }

        ++this.modCount;
        var7 = var5[var6];
        var5[var6] = new WeakIdentityHashMap.Entry(var3, var2, this.queue, var4, var7);
        if (++this.size >= this.threshold) {
            this.resize(var5.length * 2);
        }

        return null;
    }

    void resize(int var1) {
        WeakIdentityHashMap.Entry[] var2 = this.getTable();
        int var3 = var2.length;
        if (var3 == 1073741824) {
            this.threshold = 2147483647;
        } else {
            WeakIdentityHashMap.Entry[] var4 = this.newTable(var1);
            this.transfer(var2, var4);
            this.table = var4;
            if (this.size >= this.threshold / 2) {
                this.threshold = (int)((float)var1 * this.loadFactor);
            } else {
                this.expungeStaleEntries();
                this.transfer(var4, var2);
                this.table = var2;
            }

        }
    }

    private void transfer(WeakIdentityHashMap.Entry<K, V>[] var1, WeakIdentityHashMap.Entry<K, V>[] var2) {
        for(int var3 = 0; var3 < var1.length; ++var3) {
            WeakIdentityHashMap.Entry var4 = var1[var3];

            WeakIdentityHashMap.Entry var5;
            for(var1[var3] = null; var4 != null; var4 = var5) {
                var5 = var4.next;
                Object var6 = var4.get();
                if (var6 == null) {
                    var4.next = null;
                    var4.value = null;
                    --this.size;
                } else {
                    int var7 = indexFor(var4.hash, var2.length);
                    var4.next = var2[var7];
                    var2[var7] = var4;
                }
            }
        }

    }

    public void putAll(Map<? extends K, ? extends V> var1) {
        int var2 = var1.size();
        if (var2 != 0) {
            if (var2 > this.threshold) {
                int var3 = (int)((float)var2 / this.loadFactor + 1.0F);
                if (var3 > 1073741824) {
                    var3 = 1073741824;
                }

                int var4;
                for(var4 = this.table.length; var4 < var3; var4 <<= 1) {
                }

                if (var4 > this.table.length) {
                    this.resize(var4);
                }
            }

            Iterator var5 = var1.entrySet().iterator();

            while(var5.hasNext()) {
                java.util.Map.Entry var6 = (java.util.Map.Entry)var5.next();
                this.put((K)var6.getKey(), (V)var6.getValue());
            }

        }
    }

    public V remove(Object var1) {
        Object var2 = maskNull(var1);
        int var3 = System.identityHashCode(var2);
        WeakIdentityHashMap.Entry[] var4 = this.getTable();
        int var5 = indexFor(var3, var4.length);
        WeakIdentityHashMap.Entry var6 = var4[var5];

        WeakIdentityHashMap.Entry var8;
        for(WeakIdentityHashMap.Entry var7 = var6; var7 != null; var7 = var8) {
            var8 = var7.next;
            if (var3 == var7.hash && eq(var2, var7.get())) {
                ++this.modCount;
                --this.size;
                if (var6 == var7) {
                    var4[var5] = var8;
                } else {
                    var6.next = var8;
                }

                return (V) var7.value;
            }

            var6 = var7;
        }

        return null;
    }

    boolean removeMapping(Object var1) {
        if (!(var1 instanceof java.util.Map.Entry)) {
            return false;
        } else {
            WeakIdentityHashMap.Entry[] var2 = this.getTable();
            java.util.Map.Entry var3 = (java.util.Map.Entry)var1;
            Object var4 = maskNull(var3.getKey());
            int var5 = System.identityHashCode(var4);
            int var6 = indexFor(var5, var2.length);
            WeakIdentityHashMap.Entry var7 = var2[var6];

            WeakIdentityHashMap.Entry var9;
            for(WeakIdentityHashMap.Entry var8 = var7; var8 != null; var8 = var9) {
                var9 = var8.next;
                if (var5 == var8.hash && var8.equals(var3)) {
                    ++this.modCount;
                    --this.size;
                    if (var7 == var8) {
                        var2[var6] = var9;
                    } else {
                        var7.next = var9;
                    }

                    return true;
                }

                var7 = var8;
            }

            return false;
        }
    }

    public void clear() {
        while(this.queue.poll() != null) {
        }

        ++this.modCount;
        Arrays.fill(this.table, (Object)null);
        this.size = 0;

        while(this.queue.poll() != null) {
        }

    }

    public boolean containsValue(Object var1) {
        if (var1 == null) {
            return this.containsNullValue();
        } else {
            WeakIdentityHashMap.Entry[] var2 = this.getTable();
            int var3 = var2.length;

            while(var3-- > 0) {
                for(WeakIdentityHashMap.Entry var4 = var2[var3]; var4 != null; var4 = var4.next) {
                    if (var1.equals(var4.value)) {
                        return true;
                    }
                }
            }

            return false;
        }
    }

    private boolean containsNullValue() {
        WeakIdentityHashMap.Entry[] var1 = this.getTable();
        int var2 = var1.length;

        while(var2-- > 0) {
            for(WeakIdentityHashMap.Entry var3 = var1[var2]; var3 != null; var3 = var3.next) {
                if (var3.value == null) {
                    return true;
                }
            }
        }

        return false;
    }

    public Set<K> keySet() {
        Set var1 = this.keySet;
        return var1 != null ? var1 : (this.keySet = new WeakIdentityHashMap.KeySet());
    }

    public Collection<V> values() {
        Collection var1 = this.values;
        return var1 != null ? var1 : (this.values = new WeakIdentityHashMap.Values());
    }

    public Set<java.util.Map.Entry<K, V>> entrySet() {
        Set var1 = this.entrySet;
        return var1 != null ? var1 : (this.entrySet = new WeakIdentityHashMap.EntrySet());
    }

    public boolean equals(Object var1) {
        if (var1 == this) {
            return true;
        } else if (!(var1 instanceof Map)) {
            return false;
        } else {
            Map var2 = (Map)var1;
            if (var2.size() != this.size()) {
                return false;
            } else {
                try {
                    Iterator var3 = this.entrySet().iterator();

                    Object var5;
                    label43:
                    do {
                        Object var6;
                        do {
                            if (!var3.hasNext()) {
                                return true;
                            }

                            java.util.Map.Entry var4 = (java.util.Map.Entry)var3.next();
                            var5 = var4.getKey();
                            var6 = var4.getValue();
                            if (var6 == null) {
                                continue label43;
                            }
                        } while(var6.equals(var2.get(var5)));

                        return false;
                    } while(var2.get(var5) == null && var2.containsKey(var5));

                    return false;
                } catch (ClassCastException var7) {
                    return false;
                } catch (NullPointerException var8) {
                    return false;
                }
            }
        }
    }

    public int hashCode() {
        int var1 = 0;

        for(Iterator var2 = this.entrySet().iterator(); var2.hasNext(); var1 += ((java.util.Map.Entry)var2.next()).hashCode()) {
        }

        return var1;
    }

    public String toString() {
        Iterator var1 = this.entrySet().iterator();
        if (!var1.hasNext()) {
            return "{}";
        } else {
            StringBuilder var2 = new StringBuilder();
            var2.append('{');

            while(true) {
                java.util.Map.Entry var3 = (java.util.Map.Entry)var1.next();
                Object var4 = var3.getKey();
                Object var5 = var3.getValue();
                var2.append(var4 == this ? "(this Map)" : var4);
                var2.append('=');
                var2.append(var5 == this ? "(this Map)" : var5);
                if (!var1.hasNext()) {
                    return var2.append('}').toString();
                }

                var2.append(", ");
            }
        }
    }

    protected Object clone() throws CloneNotSupportedException {
        WeakIdentityHashMap var1 = (WeakIdentityHashMap)super.clone();
        var1.keySet = null;
        var1.values = null;
        return var1;
    }

    private class EntrySet extends AbstractSet<java.util.Map.Entry<K, V>> {
        private EntrySet() {
        }

        public Iterator<java.util.Map.Entry<K, V>> iterator() {
            return WeakIdentityHashMap.this.new EntryIterator();
        }

        public boolean contains(Object var1) {
            if (!(var1 instanceof java.util.Map.Entry)) {
                return false;
            } else {
                java.util.Map.Entry var2 = (java.util.Map.Entry)var1;
                WeakIdentityHashMap.Entry var3 = WeakIdentityHashMap.this.getEntry(var2.getKey());
                return var3 != null && var3.equals(var2);
            }
        }

        public boolean remove(Object var1) {
            return WeakIdentityHashMap.this.removeMapping(var1);
        }

        public int size() {
            return WeakIdentityHashMap.this.size();
        }

        public void clear() {
            WeakIdentityHashMap.this.clear();
        }

        private List<java.util.Map.Entry<K, V>> deepCopy() {
            ArrayList var1 = new ArrayList(this.size());
            Iterator var2 = this.iterator();

            while(var2.hasNext()) {
                java.util.Map.Entry var3 = (java.util.Map.Entry)var2.next();
                var1.add(new SimpleEntry(var3));
            }

            return var1;
        }

        public Object[] toArray() {
            return this.deepCopy().toArray();
        }

        public <T> T[] toArray(T[] var1) {
            return this.deepCopy().toArray(var1);
        }
    }

    private class Values extends AbstractCollection<V> {
        private Values() {
        }

        public Iterator<V> iterator() {
            return WeakIdentityHashMap.this.new ValueIterator();
        }

        public int size() {
            return WeakIdentityHashMap.this.size();
        }

        public boolean contains(Object var1) {
            return WeakIdentityHashMap.this.containsValue(var1);
        }

        public void clear() {
            WeakIdentityHashMap.this.clear();
        }
    }

    private class KeySet extends AbstractSet<K> {
        private KeySet() {
        }

        public Iterator<K> iterator() {
            return WeakIdentityHashMap.this.new KeyIterator();
        }

        public int size() {
            return WeakIdentityHashMap.this.size();
        }

        public boolean contains(Object var1) {
            return WeakIdentityHashMap.this.containsKey(var1);
        }

        public boolean remove(Object var1) {
            if (WeakIdentityHashMap.this.containsKey(var1)) {
                WeakIdentityHashMap.this.remove(var1);
                return true;
            } else {
                return false;
            }
        }

        public void clear() {
            WeakIdentityHashMap.this.clear();
        }
    }

    private class EntryIterator extends WeakIdentityHashMap<K, V>.HashIterator<java.util.Map.Entry<K, V>> {
        private EntryIterator() {
            super();
        }

        public java.util.Map.Entry<K, V> next() {
            return this.nextEntry();
        }
    }

    private class KeyIterator extends WeakIdentityHashMap<K, V>.HashIterator<K> {
        private KeyIterator() {
            super();
        }

        public K next() {
            return this.nextEntry().getKey();
        }
    }

    private class ValueIterator extends WeakIdentityHashMap<K, V>.HashIterator<V> {
        private ValueIterator() {
            super();
        }

        public V next() {
            return this.nextEntry().value;
        }
    }

    private abstract class HashIterator<T> implements Iterator<T> {
        private int index;
        private WeakIdentityHashMap.Entry<K, V> entry = null;
        private WeakIdentityHashMap.Entry<K, V> lastReturned = null;
        private int expectedModCount;
        private Object nextKey;
        private Object currentKey;

        HashIterator() {
            this.expectedModCount = WeakIdentityHashMap.this.modCount;
            this.nextKey = null;
            this.currentKey = null;
            this.index = WeakIdentityHashMap.this.isEmpty() ? 0 : WeakIdentityHashMap.this.table.length;
        }

        public boolean hasNext() {
            WeakIdentityHashMap.Entry[] var1 = WeakIdentityHashMap.this.table;

            while(this.nextKey == null) {
                WeakIdentityHashMap.Entry var2 = this.entry;

                int var3;
                for(var3 = this.index; var2 == null && var3 > 0; var2 = var1[var3]) {
                    --var3;
                }

                this.entry = var2;
                this.index = var3;
                if (var2 == null) {
                    this.currentKey = null;
                    return false;
                }

                this.nextKey = var2.get();
                if (this.nextKey == null) {
                    this.entry = this.entry.next;
                }
            }

            return true;
        }

        protected WeakIdentityHashMap.Entry<K, V> nextEntry() {
            if (WeakIdentityHashMap.this.modCount != this.expectedModCount) {
                throw new ConcurrentModificationException();
            } else if (this.nextKey == null && !this.hasNext()) {
                throw new NoSuchElementException();
            } else {
                this.lastReturned = this.entry;
                this.entry = this.entry.next;
                this.currentKey = this.nextKey;
                this.nextKey = null;
                return this.lastReturned;
            }
        }

        public void remove() {
            if (this.lastReturned == null) {
                throw new IllegalStateException();
            } else if (WeakIdentityHashMap.this.modCount != this.expectedModCount) {
                throw new ConcurrentModificationException();
            } else {
                WeakIdentityHashMap.this.remove(this.currentKey);
                this.expectedModCount = WeakIdentityHashMap.this.modCount;
                this.lastReturned = null;
                this.currentKey = null;
            }
        }
    }

    private static class Entry<K, V> extends WeakReference<Object> implements java.util.Map.Entry<K, V> {
        V value;
        final int hash;
        WeakIdentityHashMap.Entry<K, V> next;

        Entry(Object var1, V var2, ReferenceQueue<Object> var3, int var4, WeakIdentityHashMap.Entry<K, V> var5) {
            super(var1, var3);
            this.value = var2;
            this.hash = var4;
            this.next = var5;
        }

        public K getKey() {
            return (K) WeakIdentityHashMap.unmaskNull(this.get());
        }

        public V getValue() {
            return this.value;
        }

        public V setValue(V var1) {
            Object var2 = this.value;
            this.value = var1;
            return (V) var2;
        }

        public boolean equals(Object var1) {
            if (!(var1 instanceof java.util.Map.Entry)) {
                return false;
            } else {
                java.util.Map.Entry var2 = (java.util.Map.Entry)var1;
                Object var3 = this.getKey();
                Object var4 = var2.getKey();
                if (var3 == var4) {
                    Object var5 = this.getValue();
                    Object var6 = var2.getValue();
                    if (var5 == var6 || var5 != null && var5.equals(var6)) {
                        return true;
                    }
                }

                return false;
            }
        }

        public int hashCode() {
            Object var1 = this.getKey();
            Object var2 = this.getValue();
            return (var1 == null ? 0 : System.identityHashCode(var1)) ^ (var2 == null ? 0 : var2.hashCode());
        }

        public String toString() {
            return this.getKey() + "=" + this.getValue();
        }
    }
}
