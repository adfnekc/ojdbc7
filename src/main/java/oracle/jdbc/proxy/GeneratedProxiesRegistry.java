//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package oracle.jdbc.proxy;

import java.lang.reflect.Constructor;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

class GeneratedProxiesRegistry {
    private Map<GeneratedProxiesRegistry.Key, GeneratedProxiesRegistry.Value> registry = Collections.synchronizedMap(new HashMap());

    GeneratedProxiesRegistry() {
    }

    void put(Class var1, Class var2, GeneratedProxiesRegistry.Value var3) {
        this.registry.put(new GeneratedProxiesRegistry.Key(var1, var2), var3);
    }

    GeneratedProxiesRegistry.Value get(Class var1, Class var2) {
        return (GeneratedProxiesRegistry.Value)this.registry.get(new GeneratedProxiesRegistry.Key(var1, var2));
    }

    int size() {
        return this.registry.size();
    }

    Set<GeneratedProxiesRegistry.Key> keySet() {
        return this.registry.keySet();
    }

    Collection<GeneratedProxiesRegistry.Value> values() {
        return this.registry.values();
    }

    static class Value {
        private final String name;
        private final String source;
        private final Class clazz;
        private final Constructor constructor;

        Value(String var1, String var2, Class var3, Constructor var4) {
            this.name = var1;
            this.source = var2;
            this.clazz = var3;
            this.constructor = var4;
        }

        String getName() {
            return this.name;
        }

        String getSource() {
            return this.source;
        }

        Class getClazz() {
            return this.clazz;
        }

        Constructor getConstructor() {
            return this.constructor;
        }
    }

    static class Key {
        private final String PREFIX = "oracle.jdbc.proxy.";
        private final String SUFFIX = "$$$Proxy";
        private final Class iface;
        private final Class superclass;
        private Integer hashCode = null;

        Key(Class var1, Class var2) {
            this.iface = var1;
            this.superclass = var2;
        }

        Key(String var1) {
            this.iface = this.parseIface(var1);
            this.superclass = this.parseSuperclass(var1);
        }

        public boolean equals(Object var1) {
            if (null == var1) {
                return false;
            } else {
                try {
                    GeneratedProxiesRegistry.Key var2 = (GeneratedProxiesRegistry.Key)var1;
                    return this.iface.equals(var2.iface) && this.superclass.equals(var2.superclass);
                } catch (ClassCastException var3) {
                    return false;
                }
            }
        }

        public int hashCode() {
            if (null == this.hashCode) {
                this.hashCode = 23;
                this.hashCode = HashUtil.hash(this.hashCode, this.iface);
                this.hashCode = HashUtil.hash(this.hashCode, this.superclass);
            }

            return this.hashCode;
        }

        public String toString() {
            return "oracle.jdbc.proxy." + this.superclass.getName().replace(".", "$1") + "$2" + this.iface.getName().replace(".", "$1") + "$$$Proxy";
        }

        private Class parseSuperclass(String var1) {
            try {
                String var2 = var1.substring("oracle.jdbc.proxy.".length());
                String var3 = var2.replaceAll("\\$1", ".");
                String var4 = var3.substring(0, var3.indexOf("$2"));
                return Class.forName(var4);
            } catch (ClassNotFoundException var5) {
                throw new RuntimeException(var5);
            }
        }

        private Class parseIface(String var1) {
            try {
                String var2 = var1.substring("oracle.jdbc.proxy.".length());
                String var3 = var2.replaceAll("\\$1", ".");
                String var4 = var3.substring(var3.indexOf("$2") + 2, var3.indexOf("$$$Proxy"));
                return Class.forName(var4);
            } catch (ClassNotFoundException var5) {
                throw new RuntimeException(var5);
            }
        }

        public Class getIface() {
            return this.iface;
        }

        public Class getSuperclass() {
            return this.superclass;
        }

        public String makePathname() {
            return this.toString().replace(".", "/") + ".class";
        }
    }
}
