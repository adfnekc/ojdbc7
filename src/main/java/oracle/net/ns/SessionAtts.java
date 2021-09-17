//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package oracle.net.ns;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import oracle.net.ano.Ano;
import oracle.net.nt.ConnOption;
import oracle.net.nt.NTAdapter;
import oracle.net.nt.TcpsNTAdapter;

public class SessionAtts implements SQLnetDef {
    protected NSProtocol ns;
    protected NTAdapter nt;
    protected InputStream ntInputStream;
    protected OutputStream ntOutputStream;
    protected NetInputStream nsInputStream;
    protected NetOutputStream nsOutputStream;
    private int sdu;
    private int tdu;
    protected ConnOption cOption;
    protected boolean dataEOF;
    protected boolean connected;
    public boolean onBreakReset;
    public ClientProfile profile;
    public Ano ano;
    public boolean anoEnabled;
    public boolean isEncryptionActive;
    public boolean isChecksumActive;
    public boolean areEncryptionAndChecksumActive;
    boolean noAnoServices;
    int negotiatedOptions;
    public boolean poolEnabled = false;
    protected byte[] sessionId;
    protected int timeout;
    protected int tick;
    protected byte[] reconnectAddress;
    protected long timestampLastIO;
    protected boolean attemptingReconnect = false;
    public boolean anoActive;
    protected boolean isLargeSDU = false;
    protected int negotiatedSDU = -1;
    protected boolean redirecting = false;
    SocketChannel socketChannel;
    public NIONSDataChannel dataChannel;
    NIOMarkerPacket markerPacket;
    NIODataDescriptorPacket ddPacket;
    public ByteBuffer buffer = null;
    ByteBuffer payloadBuffer = null;
    ByteBuffer headerBuffer = null;
    public ByteBuffer payloadDataBuffer = null;
    boolean useNativeBuffers = false;
    String traceId;

    public SessionAtts(NSProtocol var1, int var2, int var3, boolean var4, boolean var5) {
        this.sdu = var2;
        this.tdu = var3;
        this.ns = var1;
        this.anoActive = false;
        this.connected = false;
        if (var4) {
            this.dataChannel = new NIONSDataChannel(this);
            this.markerPacket = new NIOMarkerPacket(this);
            this.ddPacket = new NIODataDescriptorPacket(this);
            this.useNativeBuffers = var5;
        }

    }

    protected void initializeBuffer(int var1) {
        if (this.useNativeBuffers) {
            this.buffer = ByteBuffer.allocateDirect(var1);
        } else {
            this.buffer = ByteBuffer.allocate(var1);
        }

        this.buffer.limit(8);
        this.headerBuffer = this.buffer.slice();
        this.buffer.clear();
        this.buffer.position(8);
        this.payloadBuffer = this.buffer.slice();
        this.buffer.clear();
        this.buffer.position(10);
        this.payloadDataBuffer = this.buffer.slice();
    }

    public void setSDU(int var1) {
        if (var1 <= 0) {
            this.sdu = 8192;
        } else if (var1 > 2097152) {
            this.sdu = 2097152;
        } else if (var1 < 512) {
            this.sdu = 512;
        } else {
            this.sdu = var1;
        }

    }

    public int getSDU() {
        return this.sdu;
    }

    public void setTDU(int var1) {
        if (var1 <= 0) {
            this.tdu = 2097152;
        } else if (var1 > 2097152) {
            this.tdu = 2097152;
        } else if (var1 < 255) {
            this.tdu = 255;
        } else {
            this.tdu = var1;
        }

    }

    public int getTDU() {
        return this.tdu;
    }

    void setNegotiatedSDUAndTDU(int var1, int var2) {
        this.setTDU(var2);
        if (var2 < var1) {
            this.setSDU(var2);
        } else {
            this.setSDU(var1);
        }

        this.negotiatedSDU = this.sdu;
        this.initializeBuffer(this.getSDU());
    }

    public NTAdapter getNTAdapter() {
        return this.nt;
    }

    void renegotiateSSLSession() throws IOException {
        ((TcpsNTAdapter)this.nt).renegotiateSession();
        this.ntInputStream = this.nt.getInputStream();
        this.ntOutputStream = this.nt.getOutputStream();
    }

    public String toString() {
        return "Session Attributes: \nsdu=" + this.sdu + ", tdu=" + this.tdu + "\nnt: " + this.nt + "\n\nntInputStream : " + this.ntInputStream + "\nntOutputStream: " + this.ntOutputStream + "\nnsInputStream : " + this.nsInputStream + "\nnsOutputStream: " + this.nsOutputStream + "\n\nClient Profile: " + this.profile + "\n\nConnection Options: " + this.cOption + "\n\nonBreakReset=" + this.onBreakReset + ", dataEOF=" + this.dataEOF + ", negotiatedOptions=0x" + Integer.toHexString(this.negotiatedOptions) + ", connected=" + this.connected;
    }

    public void turnEncryptionOn(NetInputStream var1, NetOutputStream var2) throws NetException {
        if (var1 != null && var2 != null) {
            this.nsInputStream = var1;
            this.nsOutputStream = var2;
            this.anoActive = true;
        } else {
            throw new NetException(300);
        }
    }

    public void turnEncryptionOn(NIONSDataChannel var1) throws NetException {
        if (var1 != null) {
            this.dataChannel = var1;
            this.anoActive = true;
        } else {
            throw new NetException(300);
        }
    }

    public int getANOFlags() {
        int var1 = 1;
        if (this.ano != null) {
            var1 = this.ano.getNAFlags();
        }

        return var1;
    }

    public OutputStream getOutputStream() {
        return this.nsOutputStream;
    }

    public InputStream getInputStream() {
        return this.nsInputStream;
    }

    public void setNegotiatedOptions(int var1) {
        this.negotiatedOptions = var1;
    }

    public int getNegotiatedOptions() {
        return this.negotiatedOptions;
    }

    public ConnOption getcOption() {
        return this.cOption;
    }
}
