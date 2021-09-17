//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package oracle.net.ns;

import java.io.IOException;

final class NIOHeader {
    int length;
    int packetChecksum;
    int flags;
    int headerChecksum;
    int type;
    final SessionAtts session;

    NIOHeader(SessionAtts var1) {
        this.session = var1;
    }

    final void readHeaderBuffer() throws IOException {
        this.session.headerBuffer.clear();

        while(this.session.headerBuffer.hasRemaining()) {
            this.session.socketChannel.read(this.session.headerBuffer);
        }

        this.session.headerBuffer.rewind();
        if (!this.session.isLargeSDU || this.type != 6 && this.type != 12) {
            this.length = this.session.headerBuffer.getShort() & '\uffff';
            this.packetChecksum = this.session.headerBuffer.getShort() & '\uffff';
        } else {
            this.length = this.session.headerBuffer.getInt() & -1;
        }

        this.type = this.session.headerBuffer.get() & 255;
        this.flags = this.session.headerBuffer.get() & 255;
        this.headerChecksum = this.session.headerBuffer.getShort() & '\uffff';
    }

    final void fillHeaderBuffer() throws IOException {
        this.session.headerBuffer.clear();
        if ((!this.session.isLargeSDU || this.type != 6 && this.type != 12) && this.type != 15) {
            this.session.headerBuffer.putShort((short)this.length);
            this.session.headerBuffer.putShort((short)0);
        } else {
            this.session.headerBuffer.putInt(this.length);
        }

        this.session.headerBuffer.put((byte)this.type);
        this.session.headerBuffer.put((byte)this.flags);
        this.session.headerBuffer.putShort((short)0);
    }
}
