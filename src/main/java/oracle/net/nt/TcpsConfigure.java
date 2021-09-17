//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package oracle.net.nt;

import java.io.IOException;
import javax.net.ssl.SSLSocket;
import oracle.net.jdbc.nl.NLException;
import oracle.net.jdbc.nl.NVFactory;
import oracle.net.jdbc.nl.NVPair;
import oracle.net.ns.NetException;

public class TcpsConfigure {
    static final boolean DEBUG = false;
    public static final String[] VALID_SSL_VERSION_STRINGS = new String[]{"0", "undetermined", "2", "2.0", "version 2", "3", "3.0", "version 3 only", "1", "1.0", "version 1 only", "1 or 3", "1.0 or 3.0", "version 1 or version 3"};
    public static final String[][] TABLE_ENABLED_SSL_PROTOCOLS = new String[][]{{"TLSv1", "SSLv3", "SSLv2Hello"}, {"SSLv2Hello"}, {"SSLv3"}, {"TLSv1"}, {"TLSv1", "SSLv3"}};
    public static final int[] VALID_SSL_STRING_TO_PROTOCOLS_MAP = new int[]{0, 0, 1, 1, 1, 2, 2, 2, 3, 3, 3, 4, 4, 4};

    private TcpsConfigure() {
    }

    public static void configureVersion(SSLSocket var0, String var1) throws NetException, IOException {
        if (var1 == null) {
            var1 = System.getProperty("oracle.net.ssl_version");
        }

        int var2 = 0;
        if (var1 != null) {
            if (var1.startsWith("(") && var1.endsWith(")")) {
                var1 = "(ssl_version=" + var1.substring(1);
            } else {
                var1 = "(ssl_version=" + var1 + ")";
            }

            try {
                NVPair var3 = (new NVFactory()).createNVPair(var1);
                String var4 = var3.getAtom();

                for(int var5 = 0; var5 < VALID_SSL_VERSION_STRINGS.length; ++var5) {
                    if (var4.equalsIgnoreCase(VALID_SSL_VERSION_STRINGS[var5])) {
                        var2 = var5;
                        break;
                    }
                }
            } catch (NLException var7) {
                throw (NetException)(new NetException(400, var1)).initCause(var7);
            }
        }

        if (var2 >= VALID_SSL_VERSION_STRINGS.length) {
            throw new NetException(400);
        } else {
            String[] var8 = TABLE_ENABLED_SSL_PROTOCOLS[VALID_SSL_STRING_TO_PROTOCOLS_MAP[var2]];

            try {
                var0.setEnabledProtocols(var8);
            } catch (IllegalArgumentException var6) {
                throw (NetException)(new NetException(401)).initCause(var6);
            }
        }
    }

    public static void configureCipherSuites(SSLSocket var0, String var1) throws NetException, IOException {
        if (var1 == null) {
            var1 = System.getProperty("oracle.net.ssl_cipher_suites");
        }

        if (var1 != null) {
            if (var1.startsWith("(") && var1.endsWith(")")) {
                var1 = "(cipher_suites=" + var1 + ")";
            } else {
                var1 = "(cipher_suites=(" + var1 + "))";
            }

            try {
                NVPair var2 = (new NVFactory()).createNVPair(var1);
                String[] var3 = new String[var2.getListSize()];
                if (var2.getRHSType() != NVPair.LIST_COMMASEP && var2.getRHSType() != NVPair.RHS_LIST) {
                    throw new NetException(403, var1);
                } else {
                    for(int var4 = 0; var4 < var2.getListSize(); ++var4) {
                        var3[var4] = var2.getListElement(var4).getName();
                    }

                    var0.setEnabledCipherSuites(var3);
                }
            } catch (NLException var5) {
                throw new NetException(403, var1);
            } catch (IllegalArgumentException var6) {
                throw (NetException)(new NetException(404)).initCause(var6);
            }
        }
    }

    public static boolean matchServerDN(String var0, String var1, boolean var2) {
        var0 = normalizeDN(var0);
        if (var0 == null) {
            return false;
        } else if (var2) {
            var1 = normalizeDN(var1);
            if (var1 == null) {
                return false;
            } else if (var1.equals(var0)) {
                return true;
            } else {
                var0 = reverseDN(var0);
                return var1.equals(var0);
            }
        } else {
            int var3 = var0.indexOf("CN=");
            if (var3 != -1) {
                if (var0.indexOf(44, var3) != -1) {
                    var0 = var0.substring(var3, var0.indexOf(44, var3));
                } else {
                    var0 = var0.substring(var3);
                }

                if (var1.equals(var0)) {
                    return true;
                }
            }

            return false;
        }
    }

    public static String normalizeDN(String var0) {
        StringBuffer var1 = new StringBuffer();
        String var2 = null;
        String var3 = null;
        int var4 = 0;
        int var5 = 0;

        for(var0 = var0.trim(); (var4 = var0.indexOf(61, var4)) != -1; var5 = var4 + 1) {
            var2 = var0.substring(var5, var4);
            var2 = var2.trim();
            var1.append(var2.toUpperCase());
            var1.append('=');
            var5 = var4;
            if (var4 >= var0.length() - 1) {
                return null;
            }

            var4 = var0.indexOf(44, var4);
            if (var4 == -1) {
                var3 = var0.substring(var5 + 1);
                var1.append(var3.trim());
                break;
            }

            var3 = var0.substring(var5 + 1, var4);
            var1.append(var3.trim());
            var1.append(',');
            if (var4 >= var0.length() - 1) {
                return null;
            }
        }

        return var1.toString();
    }

    public static String reverseDN(String var0) {
        StringBuffer var1 = new StringBuffer();
        String var2 = null;
        int var3 = var0.length();
        int var4 = var3;

        do {
            var3 = var0.lastIndexOf(44, var3);
            if (var3 == -1) {
                var1.append(var0.substring(0, var4));
                break;
            }

            var2 = var0.substring(var3 + 1, var4);
            var1.append(var2);
            var1.append(',');
            var4 = var3--;
        } while(var3 != -1);

        return var1.toString();
    }
}
