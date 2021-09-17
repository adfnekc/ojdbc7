//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package oracle.jdbc.driver;

import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.logging.Level;

public class OracleLog {
    private static final int maxPrintBytes = 512;
    public static final boolean TRACE = false;
    public static final Level INTERNAL_ERROR;
    public static final Level TRACE_1;
    public static final Level TRACE_10;
    public static final Level TRACE_16;
    public static final Level TRACE_20;
    public static final Level TRACE_30;
    public static final Level TRACE_32;
    static boolean securityExceptionWhileGettingSystemProperties;

    public OracleLog() {
    }

    public static boolean isDebugZip() {
        boolean var0 = true;
        var0 = false;
        return var0;
    }

    public static boolean isPrivateLogAvailable() {
        boolean var0 = false;
        return var0;
    }

    public static boolean isEnabled() {
        return false;
    }

    public static boolean registerClassNameAndGetCurrentTraceSetting(Class var0) {
        return false;
    }

    public static void setTrace(boolean var0) {
    }

    private static void initialize() {
        setupFromSystemProperties();
    }

    public static void setupFromSystemProperties() {
        boolean var0 = false;
        securityExceptionWhileGettingSystemProperties = false;

        try {
            String var1 = null;
            var1 = getSystemProperty("oracle.jdbc.Trace", (String)null);
            if (var1 != null && var1.compareTo("true") == 0) {
                var0 = true;
            }
        } catch (SecurityException var2) {
            securityExceptionWhileGettingSystemProperties = true;
        }

        setTrace(var0);
    }

    private static String getSystemProperty(String var0) {
        return getSystemProperty(var0, (String)null);
    }

    private static String getSystemProperty(final String var0, final String var1) {
        if (var0 != null) {
            final String[] var4 = new String[]{var1};
            AccessController.doPrivileged(new PrivilegedAction() {
                public Object run() {
                    var4[0] = System.getProperty(var0, var1);
                    return null;
                }
            });
            return var4[0];
        } else {
            return var1;
        }
    }

    public static String argument() {
        return "";
    }

    public static String argument(boolean var0) {
        return Boolean.toString(var0);
    }

    public static String argument(byte var0) {
        return Byte.toString(var0);
    }

    public static String argument(short var0) {
        return Short.toString(var0);
    }

    public static String argument(int var0) {
        return Integer.toString(var0);
    }

    public static String argument(long var0) {
        return Long.toString(var0);
    }

    public static String argument(float var0) {
        return Float.toString(var0);
    }

    public static String argument(double var0) {
        return Double.toString(var0);
    }

    public static String argument(Object var0) {
        if (var0 == null) {
            return "null";
        } else {
            return var0 instanceof String ? "\"" + (String)var0 + "\"" : var0.toString();
        }
    }

    /** @deprecated */
    public static String byteToHexString(byte var0) {
        StringBuffer var1 = new StringBuffer("");
        int var2 = 255 & var0;
        if (var2 <= 15) {
            var1.append("0x0");
        } else {
            var1.append("0x");
        }

        var1.append(Integer.toHexString(var2));
        return var1.toString();
    }

    /** @deprecated */
    public static String bytesToPrintableForm(String var0, byte[] var1) {
        int var2 = var1 == null ? 0 : var1.length;
        return bytesToPrintableForm(var0, var1, var2);
    }

    /** @deprecated */
    public static String bytesToPrintableForm(String var0, byte[] var1, int var2) {
        String var3 = null;
        if (var1 == null) {
            var3 = var0 + ": null";
        } else {
            var3 = var0 + " (" + var1.length + " bytes):\n" + bytesToFormattedStr(var1, var2, "  ");
        }

        return var3;
    }

    /** @deprecated */
    public static String bytesToFormattedStr(byte[] var0, int var1, String var2) {
        StringBuffer var5 = new StringBuffer("");
        if (var2 == null) {
            var2 = new String("");
        }

        var5.append(var2);
        if (var0 == null) {
            var5.append("byte [] is null");
            return var5.toString();
        } else {
            for(int var3 = 0; var3 < var1; ++var3) {
                if (var3 >= 512) {
                    var5.append("\n" + var2 + "... last " + (var1 - 512) + " bytes were not printed to limit the output size");
                    break;
                }

                if (var3 > 0 && var3 % 20 == 0) {
                    var5.append("\n" + var2);
                }

                if (var3 % 20 == 10) {
                    var5.append(" ");
                }

                int var4 = 255 & var0[var3];
                if (var4 <= 15) {
                    var5.append("0");
                }

                var5.append(Integer.toHexString(var4) + " ");
            }

            return var5.toString();
        }
    }

    /** @deprecated */
    public static byte[] strToUcs2Bytes(String var0) {
        return var0 == null ? null : charsToUcs2Bytes(var0.toCharArray());
    }

    /** @deprecated */
    public static byte[] charsToUcs2Bytes(char[] var0) {
        return var0 == null ? null : charsToUcs2Bytes(var0, var0.length);
    }

    /** @deprecated */
    public static byte[] charsToUcs2Bytes(char[] var0, int var1) {
        if (var0 == null) {
            return null;
        } else {
            return var1 < 0 ? null : charsToUcs2Bytes(var0, var1, 0);
        }
    }

    /** @deprecated */
    public static byte[] charsToUcs2Bytes(char[] var0, int var1, int var2) {
        if (var0 == null) {
            return null;
        } else {
            if (var1 > var0.length - var2) {
                var1 = var0.length - var2;
            }

            if (var1 < 0) {
                return null;
            } else {
                byte[] var5 = new byte[2 * var1];
                int var4 = var2;

                for(int var3 = 0; var4 < var1; ++var4) {
                    var5[var3++] = (byte)(var0[var4] >> 8 & 255);
                    var5[var3++] = (byte)(var0[var4] & 255);
                }

                return var5;
            }
        }
    }

    /** @deprecated */
    public static String toPrintableStr(String var0, int var1) {
        if (var0 == null) {
            return "null";
        } else {
            return var0.length() > var1 ? var0.substring(0, var1 - 1) + "\n ... the actual length was " + var0.length() : var0;
        }
    }

    public static String toHex(long var0, int var2) {
        String var3;
        switch(var2) {
            case 1:
                var3 = "00" + Long.toString(var0 & 255L, 16);
                break;
            case 2:
                var3 = "0000" + Long.toString(var0 & 65535L, 16);
                break;
            case 3:
                var3 = "000000" + Long.toString(var0 & 16777215L, 16);
                break;
            case 4:
                var3 = "00000000" + Long.toString(var0 & 4294967295L, 16);
                break;
            case 5:
                var3 = "0000000000" + Long.toString(var0 & 1099511627775L, 16);
                break;
            case 6:
                var3 = "000000000000" + Long.toString(var0 & 281474976710655L, 16);
                break;
            case 7:
                var3 = "00000000000000" + Long.toString(var0 & 72057594037927935L, 16);
                break;
            case 8:
                return toHex(var0 >> 32, 4) + toHex(var0, 4).substring(2);
            default:
                return "more than 8 bytes";
        }

        return "0x" + var3.substring(var3.length() - 2 * var2);
    }

    public static String toHex(byte var0) {
        String var1 = "00" + Integer.toHexString(var0 & 255);
        return "0x" + var1.substring(var1.length() - 2);
    }

    public static String toHex(short var0) {
        return toHex((long)var0, 2);
    }

    public static String toHex(int var0) {
        return toHex((long)var0, 4);
    }

    public static String toHex(byte[] var0, int var1) {
        if (var0 == null) {
            return "null";
        } else if (var1 > var0.length) {
            return "byte array not long enough";
        } else {
            String var2 = "[";
            int var3 = Math.min(64, var1);

            for(int var4 = 0; var4 < var3; ++var4) {
                var2 = var2 + toHex(var0[var4]) + " ";
            }

            if (var3 < var1) {
                var2 = var2 + "...";
            }

            return var2 + "]";
        }
    }

    public static String toHex(byte[] var0) {
        return var0 == null ? "null" : toHex(var0, var0.length);
    }

    static {
        INTERNAL_ERROR = OracleLog.OracleLevel.INTERNAL_ERROR;
        TRACE_1 = OracleLog.OracleLevel.TRACE_1;
        TRACE_10 = OracleLog.OracleLevel.TRACE_10;
        TRACE_16 = OracleLog.OracleLevel.TRACE_16;
        TRACE_20 = OracleLog.OracleLevel.TRACE_20;
        TRACE_30 = OracleLog.OracleLevel.TRACE_30;
        TRACE_32 = OracleLog.OracleLevel.TRACE_32;
        initialize();
    }

    private static class OracleLevel extends Level {
        static final OracleLog.OracleLevel INTERNAL_ERROR = new OracleLog.OracleLevel("INTERNAL_ERROR", 1100);
        static final OracleLog.OracleLevel TRACE_1;
        static final OracleLog.OracleLevel TRACE_10;
        static final OracleLog.OracleLevel TRACE_16;
        static final OracleLog.OracleLevel TRACE_20;
        static final OracleLog.OracleLevel TRACE_30;
        static final OracleLog.OracleLevel TRACE_32;

        OracleLevel(String var1, int var2) {
            super(var1, var2);
        }

        static {
            TRACE_1 = new OracleLog.OracleLevel("TRACE_1", Level.FINE.intValue());
            TRACE_10 = new OracleLog.OracleLevel("TRACE_10", 446);
            TRACE_16 = new OracleLog.OracleLevel("TRACE_16", Level.FINER.intValue());
            TRACE_20 = new OracleLog.OracleLevel("TRACE_20", 376);
            TRACE_30 = new OracleLog.OracleLevel("TRACE_30", 316);
            TRACE_32 = new OracleLog.OracleLevel("TRACE_32", Level.FINEST.intValue());
        }
    }
}
