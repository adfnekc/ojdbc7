//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package oracle.net.ns;

import java.io.IOException;
import java.net.SocketException;

public class DataPacket extends Packet implements SQLnetDef {
    static final boolean DEBUG2 = false;
    protected int pktOffset;
    protected int dataFlags;
    protected boolean isBufferFull;
    protected boolean isBufferEmpty;
    protected int availableBytesToSend;
    protected int availableBytesToRead;
    protected int sessionIdSize;
    private static final String _Copyright_2007_Oracle_All_Rights_Reserved_ = null;
    public static final String BUILD_DATE = "Thu_Apr_04_15:09:24_PDT_2013";
    public static final boolean TRACE = false;

    public DataPacket(SessionAtts var1, int var2) {
        super(var1, var2, 6, (var1.poolEnabled ? 1 : 0) | (var1.isLargeSDU ? 32 : 0));
        this.isBufferFull = false;
        this.isBufferEmpty = false;
        this.availableBytesToSend = 0;
        this.availableBytesToRead = 0;
        this.sessionIdSize = 0;
        this.initialize(var2);
    }

    public DataPacket(SessionAtts var1) {
        this(var1, var1.getSDU());
    }

    protected void receive() throws IOException, NetException {
        super.receive();
        this.dataOff = this.pktOffset = 10;
        this.dataLen = this.length - this.dataOff - (this.sAtts.poolEnabled ? 16 : 0);
        this.dataFlags = this.buffer[8] & 255;
        this.dataFlags <<= 8;
        this.dataFlags |= this.buffer[9] & 255;
        if (this.type == 6 && (this.dataFlags & 64) != 0) {
            this.sAtts.dataEOF = true;
        }

        if (this.type == 6 && 0 == this.dataLen) {
            this.type = 7;
        }

        if (this.sAtts.poolEnabled) {
            this.sAtts.timestampLastIO = System.currentTimeMillis();
        }

    }

    protected void send() throws IOException {
        this.send(0);
    }

    protected void send(int var1) throws IOException {
        this.buffer[8] = (byte)(var1 / 256);
        this.buffer[9] = (byte)(var1 % 256);
        this.setBufferLength(this.pktOffset);
        synchronized(this.sAtts.ntOutputStream) {
            if (!this.sAtts.poolEnabled) {
                this.sAtts.ntOutputStream.write(this.buffer, 0, this.pktOffset);
            } else {
                int var4 = 20;

                boolean var3;
                do {
                    var3 = false;

                    try {
                        this.sAtts.ntOutputStream.write(this.buffer, 0, this.pktOffset);
                    } catch (SocketException var7) {
                        if (var7.getMessage().startsWith("Connection reset")) {
                            --var4;
                            if (var4 > 0) {
                                if (!this.sAtts.attemptingReconnect) {
                                    this.sAtts.ns.reconnectIfRequired(false);
                                }

                                var3 = true;
                                continue;
                            }
                        }

                        throw var7;
                    }
                } while(var3);
            }
        }

        this.pktOffset = 10;
        this.availableBytesToSend = 0;
        this.isBufferFull = false;
        if (this.sAtts.poolEnabled) {
            this.sAtts.timestampLastIO = System.currentTimeMillis();
        }

    }

    protected int putDataInBuffer(byte[] var1, int var2, int var3) throws IOException {
        int var4 = this.buffer.length - this.sessionIdSize - this.pktOffset <= var3 ? this.buffer.length - this.sessionIdSize - this.pktOffset : var3;
        if (var4 > 0) {
            System.arraycopy(var1, var2, this.buffer, this.pktOffset, var4);
            this.pktOffset += var4;
            this.isBufferFull = this.pktOffset == this.buffer.length - this.sessionIdSize;
            this.availableBytesToSend = this.dataOff < this.pktOffset ? this.pktOffset - this.dataOff : 0;
        }

        return var4;
    }

    public long readLongLSB(int var1) throws BreakNetException, NetException, IOException {
        long var2 = 0L;
        int var4 = var1;

        for(int var5 = 0; var4 > 0; --this.availableBytesToRead) {
            var2 |= ((long)this.buffer[this.pktOffset] & 255L) << 8 * var5;
            --var4;
            ++var5;
            ++this.pktOffset;
        }

        return var2;
    }

    public long readLongMSB(int var1) throws BreakNetException, NetException, IOException {
        long var2 = 0L;

        for(int var4 = var1; var4 > 0; --this.availableBytesToRead) {
            var2 |= ((long)this.buffer[this.pktOffset] & 255L) << 8 * (var4 - 1);
            --var4;
            ++this.pktOffset;
        }

        return var2;
    }

    protected int getDataFromBuffer(byte[] var1, int var2, int var3) throws NetException {
        int var4 = this.availableBytesToRead <= var3 ? this.availableBytesToRead : var3;
        if (var4 > 0) {
            System.arraycopy(this.buffer, this.pktOffset, var1, var2, var4);
            this.pktOffset += var4;
            this.isBufferEmpty = this.pktOffset == this.length;
            this.availableBytesToRead -= var4;
        }

        return var4;
    }

    protected void setBufferLength(int var1) throws NetException {
        if (this.sAtts.poolEnabled) {
            System.arraycopy(this.sAtts.sessionId, 0, this.buffer, this.pktOffset, 16);
            var1 += 16;
            this.pktOffset += 16;
        }

        if (this.sAtts.isLargeSDU) {
            this.buffer[3] = (byte)(var1 & 255);
            this.buffer[2] = (byte)(var1 >> 8 & 255);
            this.buffer[1] = (byte)(var1 >> 16 & 255);
            this.buffer[0] = (byte)(var1 >> 24 & 255);
        } else {
            this.buffer[0] = (byte)(var1 / 256);
            this.buffer[1] = (byte)(var1 % 256);
        }

    }

    protected void initialize(int var1) {
        this.dataOff = this.pktOffset = 10;
        this.dataLen = var1 - this.dataOff;
        this.dataFlags = 0;
        this.sessionIdSize = this.sAtts.poolEnabled ? 16 : 0;
    }
}
