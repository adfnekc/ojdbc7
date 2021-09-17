//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package oracle.jdbc.internal;

import java.util.EventObject;

public abstract class XSEvent extends EventObject {
    protected XSEvent(Object var1) {
        super(var1);
    }

    public abstract XSNamespace[] getNamespaces();

    public abstract XSNamespace[] getInvalidNamespaces();

    public abstract XSPrincipal[] getSessionRoles();

    public abstract XSSessionNamespace[] getSessionNamespaces();

    public abstract int getRoleVersion();

    public abstract long getSessionFlags();

    public abstract long getCacheFlags();

    public abstract XSKeyval getKeyval();
}
