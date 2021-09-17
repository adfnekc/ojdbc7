//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package oracle.net.nt;

import java.io.IOException;
import java.net.SocketException;
import java.util.Properties;
import oracle.net.jdbc.nl.NLException;
import oracle.net.jdbc.nl.NVFactory;
import oracle.net.jdbc.nl.NVNavigator;
import oracle.net.jdbc.nl.NVPair;
import oracle.net.ns.NetException;

public class ConnOption {
    public NTAdapter nt;
    public int port;
    public int tdu;
    public int sdu;
    public String protocol;
    public String host;
    public String sid;
    public String addr;
    public String service_name;
    public String instance_name;
    public StringBuilder conn_data = new StringBuilder(200);
    public String sslServerCertDN;
    public String origSSLServerCertDN;
    public String origServiceName;
    public String origSid;
    public boolean done;

    public ConnOption() {
    }

    private NTAdapter getNT(Properties var1) throws NetException {
        try {
            if (this.protocol.equalsIgnoreCase("tcp")) {
                this.nt = new TcpNTAdapter(this.addr, var1);
                this.origServiceName = this.service_name;
                this.origSid = this.sid;
            } else if (this.protocol.equalsIgnoreCase("tcps")) {
                this.nt = new TcpsNTAdapter(this.addr, var1);
                this.origSSLServerCertDN = this.sslServerCertDN;
                this.origServiceName = this.service_name;
                this.origSid = this.sid;
                String[] var2 = new String[]{this.origSSLServerCertDN, this.origServiceName, this.origSid};
                this.nt.setOption(8, var2);
            } else {
                if (!this.protocol.equalsIgnoreCase("sdp")) {
                    throw new NetException(21);
                }

                this.nt = new SdpNTAdapter(this.addr, var1);
                this.origServiceName = this.service_name;
                this.origSid = this.sid;
            }
        } catch (NLException var3) {
            throw new NetException(501);
        } catch (Exception var4) {
            throw new NetException(21);
        }

        return this.nt;
    }

    public void connect(Properties var1) throws IOException {
        try {
            this.populateProtocol();
            if (this.protocol == null) {
                throw new NetException(501);
            }
        } catch (NLException var3) {
            throw new NetException(501);
        }

        this.nt = this.getNT(var1);
        this.nt.connect();
    }

    private void populateProtocol() throws NLException {
        NVPair var1 = null;
        NVNavigator var2 = new NVNavigator();
        NVPair var3 = (new NVFactory()).createNVPair(this.addr);
        var1 = var2.findNVPair(var3, "PROTOCOL");
        if (var1 != null) {
            this.protocol = var1.getAtom();
        } else {
            throw new NLException("NoNVPair-04614", "PROTOCOL");
        }
    }

    public void restoreFromOrigCoption(ConnOption var1) throws IOException {
        this.origSSLServerCertDN = var1.origSSLServerCertDN;
        this.origServiceName = var1.origServiceName;
        this.origSid = var1.origSid;
        this.conn_data = var1.conn_data;
        if (this.protocol.equalsIgnoreCase("tcps")) {
            String[] var2 = new String[]{this.origSSLServerCertDN, this.origServiceName, this.origSid};
            this.nt.setOption(8, var2);
        }

    }

    public String toString() {
        return "host=" + this.host + ", port=" + this.port + ", sid=" + this.sid + ", protocol=" + this.protocol + ", service_name=" + this.service_name + "\naddr=" + this.addr + "\nconn_data=" + this.conn_data + "\nsslServerCertDN=" + this.sslServerCertDN + ", origSSLServerCertDN=" + this.origSSLServerCertDN + ", origServiceName=" + this.origServiceName + ", origSid=" + this.origSid + ", done=" + this.done;
    }

    boolean isConnectionSocketKeepAlive() throws SocketException {
        return this.nt.isConnectionSocketKeepAlive();
    }
}
