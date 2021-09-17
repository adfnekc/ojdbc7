//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package oracle.jdbc;

import java.security.BasicPermission;

public final class OracleSQLPermission extends BasicPermission {
    private static final String[] allowedTargets = new String[]{"callAbort", "clientInfo\\..*"};

    private final void checkTarget(String var1) {
        for(int var2 = 0; var2 < allowedTargets.length; ++var2) {
            if (var1.matches(allowedTargets[var2])) {
                return;
            }
        }

        throw new IllegalArgumentException(var1);
    }

    public OracleSQLPermission(String var1) {
        super(var1);
        this.checkTarget(var1);
    }

    public OracleSQLPermission(String var1, String var2) {
        super(var1, var2);
        this.checkTarget(var1);
    }
}
