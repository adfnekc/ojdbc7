//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package oracle.net.jdbc.nl;

public class NVNavigator {
    public NVNavigator() {
    }

    public NVPair findNVPairRecurse(NVPair var1, String var2) {
        if (var1 != null && !var2.equalsIgnoreCase(var1.getName())) {
            if (var1.getRHSType() == NVPair.RHS_ATOM) {
                return null;
            } else {
                for(int var3 = 0; var3 < var1.getListSize(); ++var3) {
                    NVPair var4 = this.findNVPairRecurse(var1.getListElement(var3), var2);
                    if (var4 != null) {
                        return var4;
                    }
                }

                return null;
            }
        } else {
            return var1;
        }
    }

    public NVPair findNVPair(NVPair var1, String var2) {
        if (var1 != null && var1.getRHSType() == NVPair.RHS_LIST) {
            for(int var3 = 0; var3 < var1.getListSize(); ++var3) {
                NVPair var4 = var1.getListElement(var3);
                if (var2.equalsIgnoreCase(var4.getName())) {
                    return var4;
                }
            }

            return null;
        } else {
            return null;
        }
    }

    public NVPair findNVPair(NVPair var1, String[] var2) {
        NVPair var3 = var1;

        for(int var4 = 0; var4 < var2.length; ++var4) {
            var3 = this.findNVPair(var3, var2[var4]);
            if (var3 == null) {
                return null;
            }
        }

        return var3;
    }
}
