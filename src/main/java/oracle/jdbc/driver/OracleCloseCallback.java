//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package oracle.jdbc.driver;

import oracle.jdbc.internal.OracleConnection;

public interface OracleCloseCallback {
    void beforeClose(OracleConnection var1, Object var2);

    void afterClose(Object var1);
}
