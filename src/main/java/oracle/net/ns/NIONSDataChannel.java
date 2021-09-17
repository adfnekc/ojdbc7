//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package oracle.net.ns;

import java.io.IOException;
import java.nio.ByteBuffer;

public class NIONSDataChannel extends NIOPacket {
    int sessionIdSize;

    public NIONSDataChannel(SessionAtts var1) {
        super(var1);
        this.header.type = 6;
        this.sessionIdSize = var1.poolEnabled ? 16 : 0;
    }

    public void readDataFromSocketChannel() throws IOException {
        this.session.payloadDataBuffer.position(this.session.payloadDataBuffer.limit());
        this.readFromSocketChannel(true);
        this.session.payloadDataBuffer.clear();
        this.session.payloadDataBuffer.limit(this.session.payloadBuffer.limit() - 2);
    }

    public void writeDataToSocketChannel() throws IOException {
        this.writeDataToSocketChannel(0);
    }

    public void writeDataToSocketChannel(int var1) throws IOException {
        if (this.session.payloadDataBuffer.position() > 0) {
            this.session.payloadBuffer.clear();
            this.session.payloadBuffer.position(this.session.payloadDataBuffer.position() + 2);
            this.session.payloadBuffer.put(0, (byte)(var1 / 256));
            this.session.payloadBuffer.put(1, (byte)(var1 % 256));
            this.writeToSocketChannel();
        }

        this.session.payloadDataBuffer.clear();
    }

    public ByteBuffer getDataBuffer() {
        return this.session.payloadDataBuffer;
    }

    byte[] readPayloadDataFromSocketChannel(int var1) throws IOException {
        byte[] var2 = new byte[var1];
        int var3 = 0;

        int var5;
        for(boolean var4 = false; var3 < var1; var3 += var5) {
            this.readDataFromSocketChannel();
            var5 = this.session.payloadDataBuffer.limit();
            this.session.payloadDataBuffer.get(var2, var3, var5);
        }

        return var2;
    }

    void writeDataToSocketChannel(byte[] var1) throws IOException {
        int var2 = 0;
        boolean var3 = false;

        int var5;
        for(boolean var4 = false; var2 < var1.length; var2 += var5) {
            var5 = this.session.payloadDataBuffer.limit() - this.session.payloadDataBuffer.position();
            if (var5 > var1.length - var2) {
                var5 = var1.length - var2;
            }

            int var6 = var1.length > var5 ? 32 : 0;
            this.session.payloadDataBuffer.put(var1, var2, var5);
            this.writeDataToSocketChannel(var6);
        }

    }

    void readPayloadBuffer() throws IOException {
        throw new UnsupportedOperationException("Data Byte buffers are not duplicated and accessed directly by the upper layer");
    }
}
