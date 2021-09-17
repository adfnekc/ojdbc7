//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package oracle.net.ns;

import java.io.IOException;
import java.nio.charset.Charset;

final class NIOAcceptPacket extends NIOPacket {
    protected int version;
    protected int options;
    protected int sduSize;
    protected int tduSize;
    protected int myHWByteOrder;
    protected int flag0;
    protected int flag1;
    String connectData;

    NIOAcceptPacket(NIOHeader var1, SessionAtts var2) throws IOException {
        super(var1, var2);
    }

    void readPayloadBuffer() throws IOException, NetException {
        boolean var1 = false;
        boolean var2 = false;
        this.version = this.session.payloadBuffer.getShort();
        this.options = this.session.payloadBuffer.getShort();
        this.sduSize = this.session.payloadBuffer.getShort() & '\uffff';
        this.tduSize = this.session.payloadBuffer.getShort() & '\uffff';
        this.myHWByteOrder = this.session.payloadBuffer.getShort();
        short var3 = this.session.payloadBuffer.getShort();
        short var4 = this.session.payloadBuffer.getShort();
        this.flag0 = this.session.payloadBuffer.get();
        this.flag1 = this.session.payloadBuffer.get();
        this.session.timeout = this.session.payloadBuffer.getShort();
        this.session.tick = this.session.payloadBuffer.getShort();
        short var6 = this.session.payloadBuffer.getShort();
        short var7 = this.session.payloadBuffer.getShort();
        SessionAtts var10000 = this.session;
        var10000.timeout -= this.session.tick;
        var10000 = this.session;
        var10000.timeout *= 10;
        if (var6 > 0) {
            this.session.reconnectAddress = new byte[var6];
            this.session.payloadBuffer.position(var7 - 8);
            this.session.payloadBuffer.get(this.session.reconnectAddress, 0, var6);
        }

        if (this.version >= 315) {
            this.sduSize = this.session.payloadBuffer.getInt(24);
            this.tduSize = this.session.payloadBuffer.getInt(28);
            this.session.isLargeSDU = true;
            this.session.dataChannel.setLargeSDU(true);
            this.session.markerPacket.setLargeSDU(true);
        }

        if (this.session.timeout > 0) {
            int var5 = var3 + var4 - 8;
            this.session.poolEnabled = true;
            this.session.sessionId = new byte[16];
            this.session.payloadBuffer.position(var5);
            this.session.payloadBuffer.get(this.session.sessionId, 0, 16);
            this.session.dataChannel.setPoolEnabled(true);
            this.session.timestampLastIO = System.currentTimeMillis();
        }

        if (var3 > 0) {
            Object var8 = null;
            byte[] var9;
            if (this.session.payloadBuffer.hasRemaining()) {
                var9 = new byte[var3];
                this.session.payloadBuffer.position(var4);
                this.session.payloadBuffer.get(var9);
            } else {
                var9 = this.session.dataChannel.readPayloadDataFromSocketChannel(var3);
            }

            this.connectData = new String(var9, Charset.forName("US-ASCII"));
        }

        if (this.tduSize < this.sduSize) {
            this.session.setNegotiatedSDUAndTDU(this.tduSize, this.tduSize);
        } else {
            this.session.setNegotiatedSDUAndTDU(this.sduSize, this.tduSize);
        }

        this.session.setNegotiatedOptions(this.options);
    }
}
