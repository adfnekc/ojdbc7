//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package oracle.net.ns;

import java.io.IOException;

abstract class NIOPacket {
    final NIOHeader header;
    public SessionAtts session;

    NIOPacket(SessionAtts var1) {
        this.session = var1;
        this.header = new NIOHeader(var1);
    }

    NIOPacket(NIOHeader var1, SessionAtts var2) throws IOException {
        this.header = var1;
        this.session = var2;
    }

    abstract void readPayloadBuffer() throws IOException;

    final void readFromSocketChannel(boolean var1) throws IOException {
        this.readFromSocketChannel(var1, true);
    }

    final void readFromSocketChannel(boolean var1, boolean var2) throws IOException {
        if (var1) {
            this.header.readHeaderBuffer();
        }

        this.session.payloadBuffer.clear();
        this.session.payloadBuffer.limit(this.header.length - 8);

        while(this.session.payloadBuffer.hasRemaining()) {
            this.session.socketChannel.read(this.session.payloadBuffer);
        }

        this.session.payloadBuffer.rewind();
        if (var2 && this.header.type == 12) {
            this.session.markerPacket.readPayloadBuffer();
            this.processMarker();
            this.session.onBreakReset = this.session.markerPacket.isBreakPkt();
            throw new BreakNetException(500);
        }
    }

    protected void processMarker() throws IOException, NetException, BreakNetException {
    }

    final void writeToSocketChannel() throws IOException {
        this.header.length = this.session.payloadBuffer.position() + 8;
        this.header.fillHeaderBuffer();
        this.session.buffer.clear();
        this.session.buffer.limit(this.session.payloadBuffer.position() + 8);

        while(this.session.buffer.hasRemaining()) {
            this.session.socketChannel.write(this.session.buffer);
        }

        this.session.payloadBuffer.clear();
    }

    static NIOPacket readNIOPacket(SessionAtts var0) throws IOException {
        Object var1 = null;
        NIOHeader var2 = new NIOHeader(var0);
        var2.readHeaderBuffer();
        switch(var2.type) {
            case 2:
                var1 = new NIOAcceptPacket(var2, var0);
            case 3:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            default:
                break;
            case 4:
                var1 = new NIORefusePacket(var2, var0);
                break;
            case 5:
                var1 = new NIORedirectPacket(var2, var0);
                break;
            case 11:
                var1 = new NIOResendPacket(var2, var0);
                break;
            case 12:
                var1 = new NIOMarkerPacket(var2, var0);
        }

        ((NIOPacket)var1).readFromSocketChannel(false);
        ((NIOPacket)var1).readPayloadBuffer();
        return (NIOPacket)var1;
    }

    void reinitialize(SessionAtts var1) throws NetException {
        this.session = var1;
    }

    void addFlags(int var1) throws NetException {
        NIOHeader var10000 = this.header;
        var10000.flags |= var1;
    }

    void setPoolEnabled(boolean var1) throws IOException, NetException, BreakNetException {
        if (var1) {
            this.addFlags(1);
        }

    }

    void setLargeSDU(boolean var1) throws IOException, NetException, BreakNetException {
        if (var1) {
            this.addFlags(32);
        }

    }
}
