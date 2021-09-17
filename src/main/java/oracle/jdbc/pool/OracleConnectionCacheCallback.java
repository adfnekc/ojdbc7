//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package oracle.jdbc.pool;

import oracle.jdbc.OracleConnection;

/** @deprecated */
public interface OracleConnectionCacheCallback {
    /** @deprecated */
    boolean handleAbandonedConnection(OracleConnection var1, Object var2);

    /** @deprecated */
    void releaseConnection(OracleConnection var1, Object var2);
}
