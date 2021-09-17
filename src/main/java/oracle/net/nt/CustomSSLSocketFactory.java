//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package oracle.net.nt;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.KeyStore;
import java.security.SecureRandom;
import java.security.Security;
import java.util.Properties;
import javax.net.ssl.KeyManager;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import oracle.net.jdbc.nl.NVFactory;
import oracle.net.jdbc.nl.NVNavigator;
import oracle.net.jdbc.nl.NVPair;
import oracle.net.ns.NetException;

public class CustomSSLSocketFactory {
    static final boolean DEBUG = false;
    public static final String DEFAULT_SSO_WALLET_FILE_NAME = "cwallet.sso";
    public static final String DEFAULT_PKCS12_WALLET_FILE_NAME = "ewallet.p12";
    public static final String SSO_WALLET_TYPE = "SSO";
    public static final String PKCS12_WALLET_TYPE = "PKCS12";
    public static final String SUPPORTED_METHOD_TYPE = "FILE";
    public static SSLSocketFactory defSSLFactory;
    public static String defPropString = getDefaultPropertiesString();
    public static boolean initDefFactory;

    private CustomSSLSocketFactory() {
    }

    public static SSLSocketFactory getSSLSocketFactory(Properties var0) throws IOException {
        String var3 = null;
        String var2 = null;
        String var1 = null;
        String var5 = null;
        String var6 = null;
        String var4 = null;
        String var7 = null;
        String var8 = null;
        String var9 = null;
        String var10 = null;
        String var11 = null;
        String var12 = null;
        SSLSocketFactory var13 = null;
        var11 = (String)var0.get(5);
        var12 = (String)var0.get(16);
        if (var11 == null) {
            var1 = (String)var0.get(8);
            if (var1 != null) {
                var3 = (String)var0.get(9);
                if (var3 == null) {
                    var3 = KeyStore.getDefaultType();
                }

                var2 = (String)var0.get(10);
                if (var2 == null) {
                    var2 = "";
                }

                var7 = (String)var0.get(14);
                if (var7 == null) {
                    var7 = Security.getProperty("ssl.keyManagerFactory.algorithm");
                }

                if (var7 == null) {
                    var7 = KeyManagerFactory.getDefaultAlgorithm();
                }
            }

            var4 = (String)var0.get(11);
            if (var4 != null) {
                var5 = (String)var0.get(12);
                if (var5 == null) {
                    var5 = KeyStore.getDefaultType();
                }

                var6 = (String)var0.get(13);
                if (var6 == null) {
                    var6 = "";
                }

                var8 = (String)var0.get(15);
                if (var8 == null) {
                    var8 = Security.getProperty("ssl.trustManagerFactory.algorithm");
                }

                if (var8 == null) {
                    var8 = TrustManagerFactory.getDefaultAlgorithm();
                }
            }

            var9 = var1 + "#" + var3 + "#" + var2 + "#" + var4 + "#" + var5 + "#" + var6 + "#" + var7 + "#" + var8;
        } else {
            boolean var14 = false;
            if (var11.startsWith("(")) {
                var10 = processWalletLocation(var11);
            } else {
                if (!var11.startsWith("file:")) {
                    throw new NetException(412, "Location: " + var11);
                }

                var10 = var11.substring("file:".length());
                File var15 = new File(var10);
                if (!var15.exists()) {
                    throw new NetException(407, "Couldn't find file at " + var10);
                }

                if (!var15.isDirectory()) {
                    var14 = true;
                }
            }

            if (var12 == null) {
                if (!var14) {
                    var1 = var10 + System.getProperty("file.separator") + "cwallet.sso";
                } else {
                    var1 = var10;
                }

                var3 = "SSO";
                var2 = "";
                var7 = KeyManagerFactory.getDefaultAlgorithm();
                var4 = var1;
                var5 = "SSO";
                var6 = "";
                var8 = TrustManagerFactory.getDefaultAlgorithm();
            } else {
                if (!var14) {
                    var1 = var10 + System.getProperty("file.separator") + "ewallet.p12";
                } else {
                    var1 = var10;
                }

                var3 = "PKCS12";
                var2 = var12;
                var7 = KeyManagerFactory.getDefaultAlgorithm();
                var4 = var1;
                var5 = "PKCS12";
                var6 = var12;
                var8 = TrustManagerFactory.getDefaultAlgorithm();
            }

            var9 = var11 + "#" + var7 + "#" + var8;
        }

        if (var9.equals(defPropString)) {
            if (initDefFactory) {
                return defSSLFactory;
            } else {
                Class var24 = CustomSSLSocketFactory.class;
                synchronized(CustomSSLSocketFactory.class) {
                    if (!initDefFactory) {
                        try {
                            KeyManager[] var25 = null;
                            TrustManager[] var26 = null;
                            if (var1 != null) {
                                var25 = getKeyManagerArray(var1, var2, var3, var7);
                            }

                            if (var4 != null) {
                                var26 = getTrustManagerArray(var4, var6, var5, var8);
                            }

                            SSLContext var17 = SSLContext.getInstance("SSL");
                            var17.init(var25, var26, (SecureRandom)null);
                            defSSLFactory = var17.getSocketFactory();
                            if (defSSLFactory != null) {
                                initDefFactory = true;
                            }
                        } catch (Exception var19) {
                            throw (NetException)(new NetException(410)).initCause(var19);
                        }
                    }

                    return defSSLFactory;
                }
            }
        } else {
            try {
                KeyManager[] var22 = null;
                TrustManager[] var23 = null;
                if (var1 != null) {
                    var22 = getKeyManagerArray(var1, var2, var3, var7);
                }

                if (var4 != null) {
                    var23 = getTrustManagerArray(var4, var6, var5, var8);
                }

                SSLContext var16 = SSLContext.getInstance("SSL");
                var16.init(var22, var23, (SecureRandom)null);
                var13 = var16.getSocketFactory();
                return var13;
            } catch (Exception var21) {
                throw (NetException)(new NetException(410)).initCause(var21);
            }
        }
    }

    public static KeyManager[] getKeyManagerArray(String var0, String var1, String var2, String var3) throws IOException {
        FileInputStream var4 = null;

        KeyManager[] var7;
        try {
            KeyStore var5 = KeyStore.getInstance(var2);
            var4 = new FileInputStream(var0);
            var5.load(var4, var1.toCharArray());
            KeyManagerFactory var6 = KeyManagerFactory.getInstance(var3);
            var6.init(var5, var1.toCharArray());
            var7 = var6.getKeyManagers();
        } catch (Exception var11) {
            throw (NetException)(new NetException(408)).initCause(var11);
        } finally {
            if (var4 != null) {
                var4.close();
            }

        }

        return var7;
    }

    public static TrustManager[] getTrustManagerArray(String var0, String var1, String var2, String var3) throws IOException {
        FileInputStream var4 = null;

        TrustManager[] var7;
        try {
            KeyStore var5 = KeyStore.getInstance(var2);
            var4 = new FileInputStream(var0);
            var5.load(var4, var1.toCharArray());
            TrustManagerFactory var6 = TrustManagerFactory.getInstance(var3);
            var6.init(var5);
            var7 = var6.getTrustManagers();
        } catch (Exception var11) {
            throw (NetException)(new NetException(409)).initCause(var11);
        } finally {
            if (var4 != null) {
                var4.close();
            }

        }

        return var7;
    }

    public static String processWalletLocation(String var0) throws NetException {
        String var1 = null;

        try {
            NVNavigator var2 = new NVNavigator();
            NVPair var3 = (new NVFactory()).createNVPair(var0);
            NVPair var4 = var2.findNVPair(var3, "METHOD");
            NVPair var5 = var2.findNVPair(var3, "METHOD_DATA");
            NVPair var6 = var2.findNVPair(var5, "DIRECTORY");
            var1 = var4.getAtom();
            if (var1.equalsIgnoreCase("FILE")) {
                String var7 = var6.getAtom();
                return var7;
            } else {
                throw new NetException(412, var1);
            }
        } catch (Exception var8) {
            throw (NetException)(new NetException(407)).initCause(var8);
        }
    }

    public static String getDefaultPropertiesString() {
        String var0 = null;
        String var1 = null;
        Object var2 = null;
        String var3 = null;
        String var4 = null;
        var1 = System.getProperty("oracle.net.wallet_location");
        if (var1 != null) {
            var0 = var1;
        } else {
            var0 = System.getProperty("javax.net.ssl.keyStore", "") + "#" + System.getProperty("javax.net.ssl.keyStoreType", KeyStore.getDefaultType()) + "#" + System.getProperty("javax.net.ssl.keyStorePassword", "") + "#" + System.getProperty("javax.net.ssl.trustStore", "") + "#" + System.getProperty("javax.net.ssl.trustStoreType", KeyStore.getDefaultType()) + "#" + System.getProperty("javax.net.ssl.trustStorePassword", "");
        }

        if (var3 == null) {
            var3 = KeyManagerFactory.getDefaultAlgorithm();
        }

        if (var4 == null) {
            var4 = TrustManagerFactory.getDefaultAlgorithm();
        }

        return var0 + "#" + var3 + "#" + var4;
    }
}
