//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package oracle.jdbc.proxy;

import java.util.AbstractList;
import java.util.Collection;

abstract class ReadOnlyList<E> extends AbstractList<E> {
    private final RuntimeException e = new RuntimeException("read only");

    protected ReadOnlyList() {
    }

    public final boolean add(E var1) {
        throw this.e;
    }

    public final void add(int var1, E var2) {
        throw this.e;
    }

    public final boolean addAll(int var1, Collection<? extends E> var2) {
        throw this.e;
    }

    public final void clear() {
        throw this.e;
    }

    public final E remove(int var1) {
        throw this.e;
    }

    public final void removeRange(int var1, int var2) {
        throw this.e;
    }

    public final E set(int var1, E var2) {
        throw this.e;
    }
}
