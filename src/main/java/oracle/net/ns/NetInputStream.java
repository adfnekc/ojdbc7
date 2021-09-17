//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package oracle.net.ns;

import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;

public class NetInputStream extends InputStream implements SQLnetDef {
    protected DataPacket daPkt;
    protected DataDescriptorPacket ddPkt;
    protected MarkerPacket mkPkt;
    protected SessionAtts sAtts;
    private byte[] tmpBuf = new byte[1];

    public NetInputStream() {
    }

    public NetInputStream(SessionAtts var1) {
        this.sAtts = var1;
        this.daPkt = new DataPacket(var1);
        this.ddPkt = new DataDescriptorPacket(this.daPkt, var1);
    }

    public int read() throws IOException, NetException, BreakNetException {
        return this.read(this.tmpBuf) < 0 ? -1 : this.tmpBuf[0] & 255;
    }

    public int readB1() throws IOException, NetException, BreakNetException {
        return this.read();
    }

    public long readLongLSB(int var1) throws BreakNetException, NetException, IOException {
        long var2 = 0L;
        boolean var4 = false;
        if ((var1 & 128) > 0) {
            var1 &= 127;
            var4 = true;
        }

        if (!this.sAtts.anoActive && this.daPkt.availableBytesToRead >= var1) {
            var2 = this.daPkt.readLongLSB(var1);
        } else {
            int var5 = var1;

            for(int var6 = 0; var5 > 0; ++var6) {
                var2 |= ((long)this.read() & 255L) << 8 * var6;
                --var5;
            }
        }

        return (long)(var4 ? -1 : 1) * var2;
    }

    public long readLongMSB(int var1) throws BreakNetException, NetException, IOException {
        long var2 = 0L;
        boolean var4 = false;
        if ((var1 & 128) > 0) {
            var1 &= 127;
            var4 = true;
        }

        if (!this.sAtts.anoActive && this.daPkt.availableBytesToRead >= var1) {
            var2 = this.daPkt.readLongMSB(var1);
        } else {
            for(int var5 = var1; var5 > 0; --var5) {
                var2 |= ((long)this.read() & 255L) << 8 * (var5 - 1);
            }
        }

        return (long)(var4 ? -1 : 1) * var2;
    }

    public int read(byte[] var1) throws IOException, NetException, BreakNetException {
        return this.read(var1, 0, var1.length);
    }

    public boolean readZeroCopyIO(byte[] var1, int var2, int[] var3) throws IOException, NetException, BreakNetException {
        boolean var4 = false;
        if (this.sAtts.nsOutputStream.available() > 0) {
            this.sAtts.nsOutputStream.flush();
        }

        this.ddPkt.receive();
        int var5 = this.ddPkt.totalDataLength;
        if ((this.ddPkt.descriptorFLaG & 1) != 0) {
            var4 = true;
        }

        if (var1.length < var2 + var5) {
            throw new IOException("Assertion Failed");
        } else {
            int var6 = this.ddPkt.packet.readLocal(var1, var2, var5);

            while(var6 < var5) {
                try {
                    if ((var6 += this.sAtts.ntInputStream.read(var1, var6 + var2, var5 - var6)) <= 0) {
                        throw new NetException(0);
                    }
                } catch (InterruptedIOException var8) {
                    throw new NetException(504);
                }
            }

            var3[0] = var6;
            return var4;
        }
    }

    public int read(byte[] var1, int var2, int var3) throws IOException, NetException, BreakNetException {
        int var4 = 0;

        try {
            do {
                while(this.daPkt == null || this.daPkt.availableBytesToRead <= 0 || this.daPkt.type == 7) {
                    this.getNextPacket();
                }

                var4 += this.daPkt.getDataFromBuffer(var1, var2 + var4, var3 - var4);
            } while(var4 < var3);

            return var4;
        } catch (NetException var6) {
            if (var6.getErrorNumber() == 0) {
                return -1;
            } else {
                throw var6;
            }
        }
    }

    public int available() throws IOException {
        return this.daPkt.availableBytesToRead;
    }

    protected void getNextPacket() throws IOException, NetException, BreakNetException {
        if (this.sAtts.dataEOF) {
            throw new NetException(202);
        } else {
            if (this.sAtts.nsOutputStream.available() > 0) {
                this.sAtts.nsOutputStream.flush();
            }

            this.daPkt.receive();
            switch(this.daPkt.type) {
                case 6:
                    this.daPkt.availableBytesToRead = this.daPkt.dataLen;
                    break;
                case 7:
                    this.daPkt.availableBytesToRead = this.daPkt.dataLen;
                    break;
                case 12:
                    this.mkPkt = new MarkerPacket(this.daPkt);
                    this.daPkt.availableBytesToRead = 0;
                    this.sAtts.onBreakReset = this.mkPkt.isBreakPkt();
                    this.processMarker();
                    throw new BreakNetException(500);
                default:
                    throw new NetException(205);
            }

        }
    }

    protected void processMarker() throws IOException, NetException, BreakNetException {
    }

    void poolEnabled(boolean var1) throws IOException, NetException, BreakNetException {
        if (var1) {
            this.daPkt.setFlags(1);
        }

    }

    void reinitialize(SessionAtts var1) throws NetException {
        this.sAtts = var1;
    }

    Packet getCurrentPacket() throws IOException, NetException {
        return this.daPkt;
    }
}
