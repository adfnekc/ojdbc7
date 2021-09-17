//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package oracle.net.nt;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.security.cert.X509Certificate;
import java.util.Properties;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import oracle.net.jdbc.nl.NLException;
import oracle.net.ns.NetException;

public class TcpsNTAdapter extends TcpNTAdapter {
    String matchSSLServerCertDNWith;
    boolean fullDNMatch;
    SSLSocketFactory l_sslSockFac;
    Socket underlyingSocket = null;
    SSLSocket socketWithListener;

    public TcpsNTAdapter(String var1, Properties var2) throws NLException {
        super(var1, var2);
    }

    public void connect() throws IOException {
        this.l_sslSockFac = CustomSSLSocketFactory.getSSLSocketFactory(this.socketOptions);
        this.underlyingSocket = new Socket();
        String var2 = (String)this.socketOptions.get(2);
        int var3 = var2 == null ? 0 : Integer.parseInt(var2);
        boolean var4 = Boolean.parseBoolean((String)this.socketOptions.get(18));
        InetAddress[] var5 = InetAddress.getAllByName(this.host);
        if (var4 && var5.length > 1) {
            var5 = getAddressesInCircularOrder(this.host, var5);
        }

        int var6 = var5.length;
        int var7 = 0;

        while(true) {
            InetAddress var8 = var5[var7];
            InetSocketAddress var9 = new InetSocketAddress(var8, this.port);
            ++var7;
            --var6;
            this.underlyingSocket = new Socket();

            try {
                this.underlyingSocket.connect(var9, var3);
                this.socket = this.l_sslSockFac.createSocket(this.underlyingSocket, this.host, this.port, true);
                String var1;
                if ((var1 = (String)this.socketOptions.get(3)) != null) {
                    this.setOption(3, var1);
                }

                this.setSSLSocketOptions();
                break;
            } catch (IOException var13) {
                try {
                    if (this.underlyingSocket != null) {
                        this.underlyingSocket.close();
                    }

                    if (this.socket != null) {
                        this.socket.close();
                    }
                } catch (Exception var12) {
                }

                if (var6 <= 0) {
                    throw var13;
                }

                if (var7 >= var5.length) {
                    break;
                }
            } catch (NumberFormatException var14) {
                throw new NetException(505);
            }
        }

    }

    public void renegotiateSession() throws IOException {
        this.socketWithListener = (SSLSocket)this.socket;
        this.socket = this.l_sslSockFac.createSocket(this.underlyingSocket, this.host, this.port, true);
        String var1;
        if ((var1 = (String)this.socketOptions.get(3)) != null) {
            this.setOption(3, var1);
        }

        this.setSSLSocketOptions();
    }

    public void setSSLSocketOptions() throws IOException {
        super.setSocketOptions();
        SSLSocket var1 = (SSLSocket)this.socket;
        var1.setUseClientMode(true);
        TcpsConfigure.configureVersion(var1, (String)this.socketOptions.get(6));
        TcpsConfigure.configureCipherSuites(var1, (String)this.socketOptions.get(7));
    }

    public void setOption(int var1, Object var2) throws IOException, NetException {
        SSLSocket var3 = (SSLSocket)this.socket;
        switch(var1) {
            case 7:
                if (((String)var2).equalsIgnoreCase("TRUE")) {
                    this.fullDNMatch = true;
                } else {
                    this.fullDNMatch = false;
                }
                break;
            case 8:
                this.setServerDNMatchValue((String[])((String[])var2));
                break;
            default:
                super.setOption(var1, var2);
        }

    }

    public Object getOption(int var1) throws IOException, NetException {
        SSLSocket var2 = (SSLSocket)this.socket;
        switch(var1) {
            case 2:
                String var3 = var2.getSession().getCipherSuite();
                if (var3 != null && var3.indexOf("NULL") == -1) {
                    return "TRUE";
                }

                return "FALSE";
            case 3:
                X509Certificate var4 = (X509Certificate)var2.getSession().getPeerCertificates()[0];
                return var4.getSubjectDN().getName();
            case 4:
                return var2.getSession().getPeerCertificateChain();
            case 5:
                return var2.getSession().getCipherSuite();
            case 6:
                String var5 = (String)this.socketOptions.get(4);
                if (var5 == null) {
                    var5 = System.getProperty("oracle.net.ssl_server_dn_match", "false");
                }

                if (!var5.equalsIgnoreCase("YES") && !var5.equalsIgnoreCase("ON") && !var5.equalsIgnoreCase("TRUE")) {
                    return "TRUE";
                } else {
                    X509Certificate var6 = (X509Certificate)var2.getSession().getPeerCertificates()[0];
                    String var7 = var6.getSubjectDN().getName();
                    if (TcpsConfigure.matchServerDN(var7, this.matchSSLServerCertDNWith, this.fullDNMatch)) {
                        return "TRUE";
                    }

                    return "FALSE";
                }
            default:
                return super.getOption(var1);
        }
    }

    public void setServerDNMatchValue(String[] var1) {
        String var2 = var1[0];
        String var3 = var1[1];
        String var4 = var1[2];
        if (var2 != null) {
            this.matchSSLServerCertDNWith = var2;
            this.fullDNMatch = true;
        } else if (var3 != null) {
            if (var3.indexOf(46) != -1) {
                this.matchSSLServerCertDNWith = "CN=" + var3.substring(0, var3.indexOf(46));
            } else {
                this.matchSSLServerCertDNWith = "CN=" + var3.trim();
            }
        } else if (var4 != null) {
            if (var4.indexOf(46) != -1) {
                this.matchSSLServerCertDNWith = "CN=" + var4.substring(0, var4.indexOf(46));
            } else {
                this.matchSSLServerCertDNWith = "CN=" + var4.trim();
            }
        }

    }
}
