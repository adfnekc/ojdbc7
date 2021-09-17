//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package oracle.net.ns;

import java.io.IOException;
import java.nio.ByteOrder;

public final class NIODataDescriptorPacket extends NIOPacket implements SQLnetDef {
    int totalDataLength;
    int descriptorFLaG;
    int[] sdd = new int[26];
    boolean useLongDescriptor = false;
    private static final byte[] STANDARD_SDD_MAX_DD = new byte[]{0, 72, 0, 0, 15, 0, 0, 0, 0, 0, 0, 2, 0, 25, -1, -26, 0, 0, 0, 26, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};
    private static final String _Copyright_2007_Oracle_All_Rights_Reserved_ = null;
    public static final String BUILD_DATE = "Thu_Apr_04_15:09:24_PDT_2013";
    public static final boolean TRACE = false;

    NIODataDescriptorPacket(SessionAtts var1) {
        super(var1);
        this.header.type = 15;
    }

    void readPayloadBuffer() throws IOException {
        ByteOrder var1 = this.session.buffer.order();
        this.session.buffer.order(ByteOrder.BIG_ENDIAN);
        this.descriptorFLaG = this.session.payloadBuffer.getInt();
        if ((this.descriptorFLaG & 2) != 0) {
            this.useLongDescriptor = false;
        } else {
            this.useLongDescriptor = true;
        }

        this.totalDataLength = this.session.payloadBuffer.getInt();
        this.session.buffer.order(var1);
    }

    final void writeToSocketChannel(int var1, boolean var2) throws IOException {
        if (var1 == 1703910 && !var2) {
            this.session.buffer.clear();
            this.session.buffer.put(STANDARD_SDD_MAX_DD, 0, STANDARD_SDD_MAX_DD.length);
            this.session.buffer.rewind();

            while(this.session.buffer.hasRemaining()) {
                this.session.socketChannel.write(this.session.buffer);
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

            this.session.payloadBuffer.clear();
            this.session.payloadBuffer.putInt(this.descriptorFLaG);
            this.session.payloadBuffer.putInt(var1);
            this.session.payloadBuffer.putInt(var3);

            int var5;
            for(var5 = 0; var5 < var3; ++var5) {
                this.session.payloadBuffer.putShort((short)this.sdd[var5]);
            }

            for(var5 = var3; var5 < 26; ++var5) {
                this.session.payloadBuffer.putShort((short)0);
            }

            this.writeToSocketChannel();
        }

    }
}
