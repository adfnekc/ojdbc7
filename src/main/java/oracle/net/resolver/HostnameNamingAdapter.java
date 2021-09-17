//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package oracle.net.resolver;

import java.net.InetAddress;
import java.net.UnknownHostException;
import oracle.net.ns.NetException;

public class HostnameNamingAdapter implements NamingAdapterInterface {
    public static final int DEFAULT_DATABASE_PORT = 1521;
    public static final String DEFAULT_PROTOCOL = "TCP";
    String osuser;
    String programName;

    private HostnameNamingAdapter() {
    }

    public HostnameNamingAdapter(String var1, String var2) {
        this.osuser = var1;
        this.programName = var2;
    }

    public String resolve(String var1) throws NetException {
        int var7 = 0;
        boolean var8 = false;
        boolean var9 = false;
        int var10 = 0;
        boolean var11 = false;
        if (var1.startsWith("//")) {
            var1 = var1.substring(2);
        }

        int var18;
        byte var19;
        if (var1.charAt(0) == '[') {
            var11 = true;
            var10 = var1.indexOf(93);
            if (var10 != -1) {
                var7 = var1.indexOf(58, var10);
            }

            if (var10 == -1 || var7 != -1 && var7 != var10 + 1) {
                throw new NetException(117);
            }

            var19 = 1;
            var18 = var1.indexOf(47, var10);
        } else {
            var19 = 0;
            var7 = var1.indexOf(58);
            var18 = var1.indexOf(47, var19);
        }

        if ((var18 == -1 || var7 <= var18) && !var1.endsWith("/") && !var1.endsWith(":")) {
            try {
                String var2;
                if (var11) {
                    var2 = var1.substring(var19, var10);
                } else if (var7 != -1) {
                    var2 = var1.substring(var19, var7);
                } else if (var18 != -1) {
                    var2 = var1.substring(var19, var18);
                } else {
                    var2 = var1.substring(var19);
                }

                int var6;
                if (var7 != -1) {
                    if (var18 != -1) {
                        var6 = Integer.parseInt(var1.substring(var7 + 1, var18));
                    } else {
                        var6 = Integer.parseInt(var1.substring(var7 + 1));
                    }
                } else {
                    var6 = 1521;
                }

                boolean var12 = false;
                String var3;
                if (var18 != -1) {
                    int var13 = var1.indexOf(58, var18 + 1);
                    if (var13 != -1) {
                        var12 = "POOLED".equalsIgnoreCase(var1.substring(var13 + 1));
                    }

                    if (var12) {
                        var3 = var1.substring(var18 + 1, var13);
                    } else {
                        var3 = var1.substring(var18 + 1);
                    }
                } else {
                    var3 = "";
                }

                InetAddress[] var20 = InetAddress.getAllByName(var2);
                StringBuilder var14 = new StringBuilder();

                for(int var15 = 0; var15 < var20.length; ++var15) {
                    var2 = var20[var15].getHostAddress();
                    var14.append(String.format("(ADDRESS=(PROTOCOL=%s)(HOST=%s)(PORT=%s))", "TCP", var2, var6));
                }

                String var4 = String.format("(DESCRIPTION=%s%s)", String.format("(CONNECT_DATA=%s%s%s)", String.format("(SERVICE_NAME=%s)", var3), var12 ? "(SERVER=POOLED)" : "", ""), var14.toString());
                return var4;
            } catch (NumberFormatException var16) {
                throw new NetException(116);
            } catch (UnknownHostException var17) {
                throw new NetException(118);
            }
        } else {
            throw new NetException(117);
        }
    }
}
