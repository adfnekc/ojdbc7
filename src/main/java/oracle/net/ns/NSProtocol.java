//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package oracle.net.ns;

import java.io.IOException;
import java.lang.reflect.Method;
import java.net.SocketException;
import java.util.Properties;
import oracle.net.ano.Ano;
import oracle.net.jdbc.nl.NVFactory;
import oracle.net.jdbc.nl.NVNavigator;
import oracle.net.nt.ConnOption;
import oracle.net.nt.NTAdapter;
import oracle.net.resolver.AddrResolution;

public abstract class NSProtocol implements Communication, SQLnetDef {
    protected AddrResolution addrRes;
    protected SessionAtts sAtts;
    private static final boolean ACTIVATE_ANO = true;
    boolean ACTIVATE_ANO_NIO = true;
    private static final String _Copyright_2007_Oracle_All_Rights_Reserved_ = null;
    public static final String BUILD_DATE = "Thu_Apr_04_15:09:24_PDT_2013";
    public static final boolean TRACE = false;

    public NSProtocol() {
    }

    public SessionAtts getSessionAttributes() {
        return this.sAtts;
    }

    public void connect(String var1, Properties var2) throws IOException, NetException {
        if (this.sAtts.connected) {
            throw new NetException(201);
        } else if (var1 == null) {
            throw new NetException(208);
        } else {
            NVFactory var3 = new NVFactory();
            NVNavigator var4 = new NVNavigator();
            Object var5 = null;
            Object var6 = null;
            this.addrRes = new AddrResolution(var1, var2);
            String var7 = (String)var2.get("DISABLE_OOB");
            boolean var8 = var7 != null && "true".equals(var7);
            String var9 = (String)var2.get("USE_ZERO_COPY_IO");
            boolean var10 = true;
            if (var9 != null && "false".equals(var9)) {
                var10 = false;
            }

            this.sAtts.traceId = (String)var2.get("T4CConnection.hashCode");
            if (this.addrRes.connection_revised) {
                var1 = this.addrRes.getTNSAddress();
                var2 = this.addrRes.getUp();
            }

            this.sAtts.profile = new ClientProfile(var2);
            this.establishConnection(var1);
            Object var11 = null;
            if (this.ACTIVATE_ANO_NIO) {
                try {
                    var11 = Class.forName("oracle.net.ano.Ano").newInstance();
                    this.sAtts.anoEnabled = true;
                } catch (Exception var16) {
                    this.sAtts.anoEnabled = false;
                }

                if (var11 != null) {
                    ((Ano)var11).init(this.sAtts);
                    this.sAtts.ano = (Ano)var11;
                    this.sAtts.anoEnabled = true;
                }
            }

            this.negotiateConnection(var3, var4, var8, var10);
            this.sAtts.connected = true;
            this.sAtts.nt.setReadTimeoutIfRequired(var2);
            String var12 = (String)this.sAtts.nt.getOption(6);
            if (var12 != null && var12.equalsIgnoreCase("false")) {
                throw new NetException(405);
            } else {
                if (this.ACTIVATE_ANO_NIO && !this.sAtts.noAnoServices && this.sAtts.ano != null) {
                    this.sAtts.ano.negotiation(this.addrRes.connection_redirected);
                    String var13 = (String)this.sAtts.nt.getOption(2);
                    if (var13 != null && var13.equals("TRUE")) {
                        try {
                            Method var14 = this.sAtts.ano.getClass().getMethod("getEncryptionAlg", (Class[])null);
                            if (var14.invoke(this.sAtts.ano, (Object[])null) != null) {
                                throw new NetException(406);
                            }
                        } catch (Exception var15) {
                        }
                    }
                }

                this.addrRes.connection_redirected = false;
            }
        }
    }

    abstract void negotiateConnection(NVFactory var1, NVNavigator var2, boolean var3, boolean var4) throws IOException, NetException;

    public void sendBreak() throws IOException, NetException {
        if ((this.sAtts.negotiatedOptions & 1024) == 1024) {
            this.sAtts.nt.sendUrgentByte(33);
            if ((this.sAtts.negotiatedOptions & 2048) != 2048) {
                this.sendMarker(1);
            }
        } else {
            this.sendMarker(1);
        }

    }

    public void sendInterrupt() throws IOException, NetException {
        if ((this.sAtts.negotiatedOptions & 1024) == 1024) {
            this.sAtts.nt.sendUrgentByte(33);
            if ((this.sAtts.negotiatedOptions & 2048) != 2048) {
                this.sendMarker(3);
            }
        } else {
            this.sendMarker(3);
        }

    }

    protected abstract void sendMarker(int var1) throws IOException, NetException;

    public void setOption(int var1, Object var2) throws NetException, IOException {
        if (var1 > 0 && var1 < 10) {
            NTAdapter var3 = this.sAtts.getNTAdapter();
            var3.setOption(var1, var2);
        }

    }

    public Object getOption(int var1) throws NetException, IOException {
        if (var1 > 0 && var1 < 10) {
            NTAdapter var2 = this.sAtts.getNTAdapter();
            return var2.getOption(var1);
        } else {
            return null;
        }
    }

    public void abort() throws NetException, IOException {
        NTAdapter var1 = this.sAtts.getNTAdapter();
        if (var1 != null) {
            var1.abort();
        }

    }

    public String getEncryptionName() {
        String var1 = null;
        NTAdapter var2 = this.sAtts.getNTAdapter();

        try {
            var1 = (String)var2.getOption(5);
        } catch (Exception var4) {
        }

        if (var1 == null && this.sAtts.ano != null) {
            var1 = this.sAtts.ano.getEncryptionName();
        }

        if (var1 == null) {
            var1 = "";
        }

        return var1;
    }

    public String getDataIntegrityName() {
        String var1 = "";
        if (this.sAtts.ano != null) {
            var1 = this.sAtts.ano.getDataIntegrityName();
        }

        return var1;
    }

    public String getAuthenticationAdaptorName() {
        String var1 = "";
        if (this.sAtts.ano != null) {
            var1 = this.sAtts.ano.getAuthenticationAdaptorName();
        }

        return var1;
    }

    public void reconnectIfRequired(boolean var1) throws IOException {
        long var2 = System.currentTimeMillis();
        long var4 = var2 - this.sAtts.timestampLastIO;
        if (var4 > (long)this.sAtts.timeout) {
            this.reconnect(var1);
        }

    }

    public void setO3logSessionKey(byte[] var1) throws NetException {
        if (var1 != null && this.ACTIVATE_ANO_NIO) {
            this.sAtts.ano.setO3logSessionKey(var1);
        }

    }

    public void reconnect(boolean var1) throws IOException {
        try {
            String var2 = new String(this.sAtts.reconnectAddress);
            this.sAtts.attemptingReconnect = true;
            ConnOption var3 = this.sAtts.cOption;
            this.addrRes.connection_redirected = true;
            this.sAtts.cOption.nt.disconnect();
            this.establishConnection(var2);
            this.sAtts.cOption.restoreFromOrigCoption(var3);
            if (var1) {
                this.sendProbePacket();
            }
        } finally {
            this.sAtts.attemptingReconnect = false;
        }

    }

    SessionAtts establishConnection(String var1) throws NetException, IOException {
        this.sAtts.cOption = this.addrRes.resolveAndExecute(var1);
        if (this.sAtts.cOption == null) {
            return null;
        } else {
            this.sAtts.nt = this.sAtts.cOption.nt;
            this.sAtts.setTDU(this.sAtts.cOption.tdu);
            this.sAtts.setSDU(this.sAtts.cOption.sdu);
            this.initializeSessionAttributes();
            return this.sAtts;
        }
    }

    abstract void initializeSessionAttributes() throws NetException, IOException;

    abstract void sendProbePacket() throws IOException;

    public boolean isConnectionSocketKeepAlive() throws SocketException {
        return this.addrRes.isConnectionSocketKeepAlive();
    }

    public int getSocketReadTimeout() throws NetException, IOException {
        String var1 = (String)this.getOption(3);
        int var2 = var1 != null && !"".equals(var1) ? Integer.parseInt(var1) : 0;
        return var2;
    }

    public void setSocketReadTimeout(int var1) throws NetException, IOException {
        String var2 = Integer.toString(var1);
        this.setOption(3, var2);
    }

    public String getConnectionString() {
        return this.addrRes.getTNSAddress();
    }

    public int getNegotiatedSDU() throws NetException {
        if (!this.sAtts.connected) {
            throw new NetException(200);
        } else {
            return this.sAtts.negotiatedSDU;
        }
    }
}
