//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package oracle.core.lvf;

public final class VersionMgr {
    public static final byte ALPHA = 1;
    public static final byte BETA = 2;
    public static final byte PROD = 3;
    public static final byte NONE = 4;
    private final byte MAX_LEN = 64;
    private final byte MAX_PRODLEN = 30;
    private final byte MAX_VERLEN = 15;
    private final byte MAX_DISTLEN = 5;
    private final String alpha = "Alpha";
    private final String beta = "Beta";
    private final String prod = "Production";
    private String version;

    public VersionMgr() {
    }

    public void setVersion(String var1, byte var2, byte var3, byte var4, byte var5, byte var6, char var7, String var8, byte var9, int var10) {
        char[] var13 = new char[64];
        String var18 = "";
        byte var15;
        if ((var15 = (byte)var1.length()) > 30) {
            var15 = 30;
        }

        byte var14;
        for(var14 = 0; 0 < var15--; ++var14) {
            var13[var14] = var1.charAt(var14);
        }

        var13[var14++] = '\t';
        if (var2 < 0) {
            var2 = 0;
        }

        if (var3 < 0) {
            var3 = 0;
        }

        if (var4 < 0) {
            var4 = 0;
        }

        if (var5 < 0) {
            var5 = 0;
        }

        if (var6 < 0) {
            var6 = 0;
        }

        if (var2 > 99) {
            var2 = 99;
        }

        if (var3 > 99) {
            var3 = 99;
        }

        if (var4 > 99) {
            var4 = 99;
        }

        if (var5 > 99) {
            var5 = 99;
        }

        if (var6 > 99) {
            var6 = 99;
        }

        String var12;
        if (var7 != 0) {
            var12 = var2 + "." + var3 + "." + var4 + "." + var5 + "." + var6 + var7;
        } else {
            var12 = var2 + "." + var3 + "." + var4 + "." + var5 + "." + var6;
        }

        byte var16 = (byte)var12.length();

        byte var11;
        for(var11 = 0; 0 < var16--; var13[var14++] = var12.charAt(var11++)) {
        }

        if (var9 != 4) {
            var13[var14++] = '\t';
            if (var8 != null) {
                boolean var19 = false;
                byte var20;
                if ((var20 = (byte)var8.length()) > 5) {
                    var20 = 5;
                }

                for(var11 = 0; 0 < var20--; var13[var14++] = var8.charAt(var11++)) {
                }

                var13[var14++] = '\t';
            }

            switch(var9) {
                case 1:
                    var18 = "Alpha";
                    break;
                case 2:
                    var18 = "Beta";
                    break;
                case 3:
                    var18 = "Production";
            }

            var11 = 0;

            for(byte var17 = (byte)var18.length(); 0 < var17--; var13[var14++] = var18.charAt(var11++)) {
            }
        }

        this.version = new String(var13, 0, var14);
    }

    public String getVersion() {
        return this.version;
    }
}
