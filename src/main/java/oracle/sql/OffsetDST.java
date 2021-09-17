//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package oracle.sql;

import java.sql.Timestamp;

public class OffsetDST {
    private Timestamp timestamp;
    private int offset;
    private byte DSTflag;

    public OffsetDST(Timestamp var1, int var2, byte var3) {
        this.timestamp = var1;
        this.offset = var2;
        this.DSTflag = var3;
    }

    public OffsetDST() {
        this.timestamp = new Timestamp(0L);
        this.offset = 0;
        this.DSTflag = 0;
    }

    public int getOFFSET() {
        return this.offset;
    }

    public byte getDSTFLAG() {
        return this.DSTflag;
    }

    public Timestamp getTimestamp() {
        return this.timestamp;
    }

    public void setOFFSET(int var1) {
        this.offset = var1;
    }

    public void setDSTFLAG(byte var1) {
        this.DSTflag = var1;
    }

    public long getTime() {
        return this.timestamp.getTime();
    }
}
