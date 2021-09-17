//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package oracle.net.resolver;

import java.util.HashMap;
import oracle.net.ns.NetException;

public class NameResolverFactory {
    private static HashMap resolverMap = new HashMap();
    private static final String TNS_ADMIN_PROPERTY = "oracle.net.tns_admin";
    private static final boolean DEBUG = false;

    public NameResolverFactory() {
    }

    public static NameResolver getNameResolver(String var0, String var1, String var2) throws NetException {
        if (var0 != null) {
            var0 = var0.trim();
        }

        if (var0 != null && var0.length() == 0) {
            throw new NetException(119);
        } else {
            Class var4 = NameResolverFactory.class;
            synchronized(NameResolverFactory.class) {
                NameResolver var5 = (NameResolver)resolverMap.get(var0);
                if (var5 == null) {
                    var5 = new NameResolver(var0, var1, var2);
                    resolverMap.put(var0, var5);
                }

                return var5;
            }
        }
    }
}
