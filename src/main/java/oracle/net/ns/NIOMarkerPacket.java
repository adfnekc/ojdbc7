//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package oracle.net.ns;

import java.io.IOException;

final class NIOMarkerPacket extends NIOPacket {
    private boolean isReset;
    private boolean isBreak;

    NIOMarkerPacket(SessionAtts var1) {
        super(var1);
        this.header.type = 12;
    }

    NIOMarkerPacket(NIOHeader var1, SessionAtts var2) throws IOException {
        super(var1, var2);
        var1.type = 12;
    }

    void writeToSocketChannel(int var1) throws IOException {
        this.session.payloadBuffer.clear();
        this.session.payloadBuffer.put((byte)1);
        this.session.payloadBuffer.put((byte)0);
        this.session.payloadBuffer.put((byte)var1);
        this.writeToSocketChannel();
    }

    void readPayloadBuffer() throws IOException {
        byte var1 = this.session.payloadBuffer.get();
        byte var2 = this.session.payloadBuffer.get();
        switch(var1) {
            case 0:
                this.isBreak = true;
                break;
            case 1:
                byte var3 = this.session.payloadBuffer.get();
                if (var3 == 2) {
                    this.isReset = true;
                } else {
                    this.isBreak = true;
                }
                break;
            default:
                throw new NetException(205);
        }

    }

    boolean isBreakPkt() {
        return this.isBreak;
    }

    boolean isResetPkt() {
        return this.isReset;
    }
}
