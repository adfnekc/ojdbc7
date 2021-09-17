//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package oracle.net.nt;

import java.io.IOException;
import java.net.SocketException;
import java.util.Enumeration;
import java.util.Properties;
import java.util.Vector;
import oracle.net.ns.NetException;

public class ConnStrategy {
    static final boolean DEBUG = false;
    private boolean optFound = false;
    public boolean reuseOpt = false;
    private ConnOption copt;
    public int sdu;
    public int tdu;
    public int nextOptToTry = 0;
    public Properties socketOptions = new Properties();
    private String osuser;
    private String programName;
    public int connectTimeout = -1;
    public int retryCount = 0;
    private int lastRetryCounter = 0;
    public Vector cOpts = new Vector(10, 10);

    public ConnStrategy(Properties var1) {
        this.osuser = var1.getProperty("oracle.jdbc.v$session.osuser");
        this.programName = var1.getProperty("oracle.jdbc.v$session.program");
        this.createSocketOptions(var1);
    }

    public String getOSUsername() {
        return this.osuser;
    }

    public String getProgramName() {
        return this.programName;
    }

    public void createSocketOptions(Properties var1) {
        String var2 = null;
        String var3 = null;
        boolean var4 = false;
        Enumeration var5 = var1.keys();

        while(var5.hasMoreElements()) {
            var2 = (String)var5.nextElement();
            if (var2.equalsIgnoreCase("TCP.NODELAY")) {
                var4 = true;
                var3 = var1.getProperty("TCP.NODELAY").toUpperCase();
                if (var3.equals("NO")) {
                    this.socketOptions.put(0, "NO");
                } else {
                    this.socketOptions.put(0, "YES");
                }
            } else if (var2.equalsIgnoreCase("oracle.net.READ_TIMEOUT")) {
                var3 = var1.getProperty("oracle.net.READ_TIMEOUT");
                this.socketOptions.put(3, var3);
            } else if (var2.equalsIgnoreCase("oracle.net.CONNECT_TIMEOUT")) {
                var3 = var1.getProperty("oracle.net.CONNECT_TIMEOUT");
                this.socketOptions.put(2, var3);
            } else if (var2.equalsIgnoreCase("oracle.net.ssl_server_dn_match")) {
                var3 = var1.getProperty("oracle.net.ssl_server_dn_match");
                this.socketOptions.put(4, var3);
            } else if (var2.equalsIgnoreCase("oracle.net.wallet_location")) {
                var3 = var1.getProperty("oracle.net.wallet_location");
                this.socketOptions.put(5, var3);
            } else if (var2.equalsIgnoreCase("oracle.net.wallet_password")) {
                var3 = var1.getProperty("oracle.net.wallet_password");
                this.socketOptions.put(16, var3);
            } else if (var2.equalsIgnoreCase("oracle.net.ssl_version")) {
                var3 = var1.getProperty("oracle.net.ssl_version");
                this.socketOptions.put(6, var3);
            } else if (var2.equalsIgnoreCase("oracle.net.ssl_cipher_suites")) {
                var3 = var1.getProperty("oracle.net.ssl_cipher_suites");
                this.socketOptions.put(7, var3);
            } else if (var2.equalsIgnoreCase("javax.net.ssl.keyStore")) {
                var3 = var1.getProperty("javax.net.ssl.keyStore");
                this.socketOptions.put(8, var3);
            } else if (var2.equalsIgnoreCase("javax.net.ssl.keyStoreType")) {
                var3 = var1.getProperty("javax.net.ssl.keyStoreType");
                this.socketOptions.put(9, var3);
            } else if (var2.equalsIgnoreCase("javax.net.ssl.keyStorePassword")) {
                var3 = var1.getProperty("javax.net.ssl.keyStorePassword");
                this.socketOptions.put(10, var3);
            } else if (var2.equalsIgnoreCase("javax.net.ssl.trustStore")) {
                var3 = var1.getProperty("javax.net.ssl.trustStore");
                this.socketOptions.put(11, var3);
            } else if (var2.equalsIgnoreCase("javax.net.ssl.trustStoreType")) {
                var3 = var1.getProperty("javax.net.ssl.trustStoreType");
                this.socketOptions.put(12, var3);
            } else if (var2.equalsIgnoreCase("javax.net.ssl.trustStorePassword")) {
                var3 = var1.getProperty("javax.net.ssl.trustStorePassword");
                this.socketOptions.put(13, var3);
            } else if (var2.equalsIgnoreCase("ssl.keyManagerFactory.algorithm")) {
                var3 = var1.getProperty("ssl.keyManagerFactory.algorithm");
                this.socketOptions.put(14, var3);
            } else if (var2.equalsIgnoreCase("FORCE_DNS_LOAD_BALANCING")) {
                var3 = var1.getProperty("FORCE_DNS_LOAD_BALANCING");
                this.socketOptions.put(18, var3);
            } else if (var2.equalsIgnoreCase("oracle.net.keepAlive")) {
                var3 = var1.getProperty("oracle.net.keepAlive");
                if (Boolean.parseBoolean(var3)) {
                    this.socketOptions.put(1, "YES");
                } else {
                    this.socketOptions.put(1, "NO");
                }
            } else if (var2.equalsIgnoreCase("oracle.jdbc.useNio")) {
                var3 = var1.getProperty("oracle.jdbc.useNio");
                this.socketOptions.put(20, var3);
            }
        }

        if (!var4 && !this.reuseOpt) {
            this.socketOptions.put(0, "YES");
        }

    }

    public void addSocketOptions(boolean var1) {
        if (var1) {
            this.socketOptions.put(1, "YES");
        } else if (!this.reuseOpt && !this.socketOptions.containsKey(1)) {
            this.socketOptions.put(1, "NO");
        }

    }

    public void addOption(ConnOption var1) {
        this.cOpts.addElement(var1);
    }

    public boolean hasMoreOptions() {
        return this.nextOptToTry < this.cOpts.size();
    }

    public ConnOption execute() throws NetException {
        IOException var1 = null;
        if (this.connectTimeout == -1) {
            if (this.socketOptions.get(2) == null) {
                this.socketOptions.put(2, Integer.toString(60000));
            }
        } else {
            this.socketOptions.put(2, Integer.toString(this.connectTimeout));
        }

        if (this.retryCount < 0) {
            this.retryCount = 0;
        }

        this.socketOptions.put(17, Integer.toString(this.retryCount));

        for(int var2 = this.lastRetryCounter; var2 <= this.retryCount; ++var2) {
            while(this.nextOptToTry < this.cOpts.size()) {
                try {
                    this.copt = (ConnOption)this.cOpts.elementAt(this.nextOptToTry);
                    this.copt.connect(this.socketOptions);
                    this.copt.sdu = this.sdu;
                    this.copt.tdu = this.tdu;
                    this.optFound = true;
                    ++this.nextOptToTry;
                    this.lastRetryCounter = var2;
                    return this.copt;
                } catch (IOException var4) {
                    ++this.nextOptToTry;
                    var1 = var4;
                }
            }

            this.nextOptToTry = 0;
        }

        if (var1 == null) {
            throw new NetException(20);
        } else {
            throw (NetException)(new NetException(20)).initCause(var1);
        }
    }

    public boolean optAvailable() {
        return this.optFound;
    }

    public void clearElements() {
        this.cOpts.removeAllElements();
    }

    public ConnOption getOption() {
        return this.copt;
    }

    public boolean isConnectionSocketKeepAlive() throws SocketException {
        return this.copt.isConnectionSocketKeepAlive();
    }
}
