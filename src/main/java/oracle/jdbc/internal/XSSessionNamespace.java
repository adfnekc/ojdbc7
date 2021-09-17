//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package oracle.jdbc.internal;

import java.sql.SQLException;
import oracle.jdbc.driver.InternalFactory;
import oracle.sql.TIMESTAMPTZ;

public abstract class XSSessionNamespace {
    public XSSessionNamespace() {
    }

    public static final XSSessionNamespace constructXSSessionNamespace() throws SQLException {
        return InternalFactory.createXSSessionNamespace();
    }

    public abstract XSPrincipal getPrincipal();

    public abstract String getTenant();

    public abstract byte[] getSessionId();

    public abstract byte[] getCookie();

    public abstract long getProxyId();

    public abstract long getACLId();

    public abstract long getCreatedBy();

    public abstract long getUpdatedBy();

    public abstract TIMESTAMPTZ getCreateTimestamp();

    public abstract TIMESTAMPTZ getAccessTimestamp();

    public abstract TIMESTAMPTZ getAuthTimestamp();

    public abstract int getTimeout();
}
