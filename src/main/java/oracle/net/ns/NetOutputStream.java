//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package oracle.net.ns;

import java.io.IOException;
import java.io.OutputStream;

public class NetOutputStream extends OutputStream implements SQLnetDef {
    protected DataPacket daPkt;
    protected DataDescriptorPacket ddPkt;
    protected SessionAtts sAtts;
    private byte[] tmpBuf = new byte[1];

    public NetOutputStream() {
    }

    public NetOutputStream(SessionAtts var1) {
        this.sAtts = var1;
        this.daPkt = new DataPacket(var1);
        this.ddPkt = new DataDescriptorPacket(var1);
    }

    public NetOutputStream(SessionAtts var1, int var2) {
        this.sAtts = var1;
        this.daPkt = new DataPacket(var1, var2);
        this.ddPkt = new DataDescriptorPacket(var1);
    }

    public void writeZeroCopyIO(byte[] var1, int var2, int var3) throws IOException, NetException, BreakNetException {
        int var4 = var3;

        int var5;
        for(boolean var6 = false; var4 > 0; var4 -= var5) {
            if (var4 > 1703910) {
                var5 = 1703910;
            } else {
                var5 = var4;
                var6 = true;
            }

            this.ddPkt.send(var5, var6);
            synchronized(this.sAtts.ntOutputStream) {
                this.sAtts.ntOutputStream.write(var1, var2, var5);
            }

            var2 += var5;
        }

    }

    public void write(int var1) throws IOException {
        this.tmpBuf[0] = (byte)var1;
        this.write(this.tmpBuf);
    }

    public void write(byte[] var1) throws IOException {
        this.write(var1, 0, var1.length);
    }

    public void write(byte[] var1, int var2, int var3) throws IOException {
        int var4 = 0;
        boolean var5 = false;

        while(var3 > var4) {
            var4 += this.daPkt.putDataInBuffer(var1, var2 + var4, var3 - var4);
            if (this.daPkt.isBufferFull) {
                int var6 = var3 > var4 ? 32 : 0;
                this.daPkt.send(var6);
            }
        }

    }

    public int available() throws IOException {
        return this.daPkt.availableBytesToSend;
    }

    public void flush() throws IOException {
        if (this.daPkt.availableBytesToSend > 0) {
            this.daPkt.send(0);
        }

    }

    public void close() throws IOException {
        this.daPkt.send(64);
    }

    void poolEnabled(boolean var1) throws IOException, NetException, BreakNetException {
        if (var1) {
            this.daPkt.setFlags(1);
        }

    }

    void reinitialize(SessionAtts var1) throws NetException {
        this.sAtts = var1;
    }
}
