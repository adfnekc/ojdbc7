//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package oracle.net.ns;

import java.io.IOException;

final class NIORedirectPacket extends NIOPacket {
    String redirectData;

    NIORedirectPacket(NIOHeader var1, SessionAtts var2) throws IOException {
        super(var1, var2);
    }

    void readPayloadBuffer() throws IOException, NetException {
        short var1 = this.session.payloadBuffer.getShort();
        if (var1 > 0) {
            Object var2 = null;
            byte[] var3;
            if (this.session.payloadBuffer.hasRemaining()) {
                var3 = new byte[var1];
                this.session.payloadBuffer.get(var3);
            } else {
                var3 = this.session.dataChannel.readPayloadDataFromSocketChannel(var1);
            }

            this.redirectData = new String(var3);
        }

    }
}
