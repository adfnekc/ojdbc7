//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package oracle.net.ns;

import java.io.IOException;
import java.nio.charset.Charset;

final class NIORefusePacket extends NIOPacket {
    int userReason;
    int systemReason;
    String refuseData;

    NIORefusePacket(NIOHeader var1, SessionAtts var2) throws IOException {
        super(var1, var2);
    }

    void readPayloadBuffer() throws IOException, NetException {
        this.userReason = this.session.payloadBuffer.get();
        this.systemReason = this.session.payloadBuffer.get();
        short var1 = this.session.payloadBuffer.getShort();
        if (var1 > 0) {
            Object var2 = null;
            byte[] var3;
            if (this.session.payloadBuffer.limit() > this.session.payloadBuffer.position()) {
                var3 = new byte[var1];
                this.session.payloadBuffer.get(var3);
            } else {
                var3 = this.session.dataChannel.readPayloadDataFromSocketChannel(var1);
            }

            this.refuseData = new String(var3, Charset.forName("US-ASCII"));
        } else {
            this.refuseData = "";
        }

    }
}
