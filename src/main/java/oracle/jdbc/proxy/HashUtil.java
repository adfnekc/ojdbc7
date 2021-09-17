//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package oracle.jdbc.proxy;

import java.lang.reflect.Array;

class HashUtil {
    static final int SEED = 23;
    private static final int ODD_PRIME_NUMBER = 37;

    HashUtil() {
    }

    static int hash(int var0, boolean var1) {
        return firstTerm(var0) + (var1 ? 1 : 0);
    }

    static int hash(int var0, char var1) {
        return firstTerm(var0) + var1;
    }

    static int hash(int var0, int var1) {
        return firstTerm(var0) + var1;
    }

    static int hash(int var0, long var1) {
        return firstTerm(var0) + (int)(var1 ^ var1 >>> 32);
    }

    static int hash(int var0, float var1) {
        return hash(var0, Float.floatToIntBits(var1));
    }

    static int hash(int var0, double var1) {
        return hash(var0, Double.doubleToLongBits(var1));
    }

    static int hash(int var0, Object var1) {
        int var2 = var0;
        if (var1 == null) {
            var2 = hash(var0, (int)0);
        } else if (!var1.getClass().isArray()) {
            var2 = hash(var0, var1.hashCode());
        } else {
            int var3 = Array.getLength(var1);

            for(int var4 = 0; var4 < var3; ++var4) {
                Object var5 = Array.get(var1, var4);
                var2 = hash(var2, var5);
            }
        }

        return var2;
    }

    private static int firstTerm(int var0) {
        return 37 * var0;
    }
}
