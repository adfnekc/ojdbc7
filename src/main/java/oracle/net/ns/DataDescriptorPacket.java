//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package oracle.net.ns;

import java.io.IOException;

public class DataDescriptorPacket extends Packet implements SQLnetDef {
    int totalDataLength;
    int descriptorFLaG;
    int[] sdd = new int[26];
    Packet packet;
    boolean useLongDescriptor = false;
    private static final byte[] STANDARD_SDD_MAX_DD = new byte[]{0, 72, 0, 0, 15, 0, 0, 0, 0, 0, 0, 2, 0, 25, -1, -26, 0, 0, 0, 26, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};
    private static final String _Copyright_2007_Oracle_All_Rights_Reserved_ = null;
    public static final String BUILD_DATE = "Thu_Apr_04_15:09:24_PDT_2013";
    public static final boolean TRACE = false;

    public DataDescriptorPacket(SessionAtts var1) {
        super(var1, 72, 15, 0);
    }

    public DataDescriptorPacket(Packet var1, SessionAtts var2) {
        super(var2);
        this.type = 15;
        this.packet = var1;
        this.buffer = this.packet.buffer;
    }

    protected void receive() throws IOException, NetException {
        this.packet.receive();
        this.descriptorFLaG = (this.buffer[8] & 255) << 24 | (this.buffer[9] & 255) << 16 | (this.buffer[10] & 255) << 8 | this.buffer[11] & 255;
        if ((this.descriptorFLaG & 2) != 0) {
            this.useLongDescriptor = false;
        } else {
            this.useLongDescriptor = true;
        }

        this.totalDataLength = (this.buffer[12] & 255) << 24 | (this.buffer[13] & 255) << 16 | (this.buffer[14] & 255) << 8 | this.buffer[15] & 255;
    }

    protected void send(int var1, boolean var2) throws IOException {
        if (var1 == 1703910 && !var2) {
            synchronized(this.sAtts.ntOutputStream) {
                this.sAtts.ntOutputStream.write(STANDARD_SDD_MAX_DD, 0, STANDARD_SDD_MAX_DD.length);
            }
        } else {
            this.useLongDescriptor = false;
            this.descriptorFLaG = 2;
            if (var2) {
                this.descriptorFLaG |= 1;
            }

            int var3 = 0;

            for(int var4 = var1; var4 > 0; ++var3) {
                if (var4 > 65535) {
                    this.sdd[var3] = 65535;
                } else {
                    this.sdd[var3] = var4;
                }

                var4 -= this.sdd[var3];
            }

            this.writeB4ToBuffer(this.buffer, 8, this.descriptorFLaG);
            this.writeB4ToBuffer(this.buffer, 12, var1);
            this.writeB4ToBuffer(this.buffer, 16, var3);

            int var5;
            for(var5 = 0; var5 < var3; ++var5) {
                this.writeB2ToBuffer(this.buffer, 20 + var5 * 2, this.sdd[var5]);
            }

            for(var5 = var3; var5 < 26; ++var5) {
                this.writeB2ToBuffer(this.buffer, 20 + var5 * 2, 0);
            }

            synchronized(this.sAtts.ntOutputStream) {
                this.sAtts.ntOutputStream.write(this.buffer, 0, 72);
            }
        }

    }

    void writeB4ToBuffer(byte[] var1, int var2, int var3) {
        byte var4 = (byte)((var3 & -16777216) >>> 24 & 255);
        byte var5 = (byte)((var3 & 16711680) >>> 16 & 255);
        byte var6 = (byte)((var3 & '\uff00') >>> 8 & 255);
        byte var7 = (byte)(var3 & 255);
        var1[var2] = var4;
        var1[var2 + 1] = var5;
        var1[var2 + 2] = var6;
        var1[var2 + 3] = var7;
    }

    void writeB2ToBuffer(byte[] var1, int var2, int var3) {
        byte var4 = (byte)((var3 & '\uff00') >>> 8 & 255);
        byte var5 = (byte)(var3 & 255);
        var1[var2] = var4;
        var1[var2 + 1] = var5;
    }
}
