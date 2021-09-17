//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package oracle.net.ns;

public class MarkerPacket extends Packet implements SQLnetDef {
    protected int data;
    private boolean isReset;
    private boolean isBreak;
    private int markerType;

    public MarkerPacket(SessionAtts var1, int var2) {
        super(var1);
        this.createBuffer(11, 12, var1.isLargeSDU ? 32 : 0);
        this.buffer[4] = 12;
        this.buffer[8] = 1;
        this.buffer[10] = (byte)var2;
    }

    public MarkerPacket(Packet var1) throws NetException {
        super(var1);
        this.type = 12;
        this.markerType = this.buffer[8];
        switch(this.markerType) {
            case 0:
                this.data = 0;
                this.isBreak = true;
                break;
            case 1:
                this.data = this.buffer[10];
                if (this.data == 2) {
                    this.isReset = true;
                } else {
                    this.isBreak = true;
                }
                break;
            default:
                throw new NetException(205);
        }

    }

    public boolean isBreakPkt() {
        return this.isBreak;
    }
}
