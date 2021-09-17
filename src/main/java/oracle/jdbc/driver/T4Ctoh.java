//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package oracle.jdbc.driver;

import java.io.IOException;
import java.sql.SQLException;

class T4Ctoh {
    static final int TOPLVL_KPCTOH = 1;
    static final int SERBEG_KPCTOH = 2;
    static final int SEREND_KPCTOH = 4;
    static final int SERONE_KPCTOH = 8;
    static final int NEW_KPCTOH = 16;
    static final int UPDATE_KPCTOH = 32;
    static final int DELETE_KPCTOH = 64;
    static final int LAST_KPCTOH = 128;
    static final int NOOBJ_KPCTOH = 256;
    static final int NNO_KPCTOH = 512;
    static final int RAWSTR_KPCTOH = 1024;
    static final byte[] EOID_KOTTD = new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1};
    static final byte KORFPFNNL = 2;
    static final byte EXTENT_OID = 8;
    static final int DONE_KPCTOC = 0;
    static final int MORE_KPCTOC = -1;
    static final int IGNORE_KPCTOC = -2;
    static final int KOLRUG_ENABLE = 1;
    static final byte[] ANYDATA_TOID = new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0, 17};
    static final int KOIDFLEN = 16;
    static final int KOIDSLEN = 8;
    byte[] toid = null;
    byte[] oid = null;
    byte[] snapshot = null;
    int versionNumber = 0;
    int imageLength = 0;
    int flags = 0;
    int[] intArr = new int[1];
    private static final String _Copyright_2007_Oracle_All_Rights_Reserved_ = null;
    public static final String BUILD_DATE = "Thu_Apr_04_15:09:24_PDT_2013";
    public static final boolean TRACE = false;

    T4Ctoh() {
    }

    void init(byte[] var1, int var2) {
        if (this.toid == null || this.toid.length != 36) {
            this.toid = new byte[36];
        }

        this.toid[0] = 0;
        this.toid[1] = 36;
        this.toid[2] = 2;
        this.toid[3] = 8;
        System.arraycopy(var1, 0, this.toid, 4, 16);
        System.arraycopy(EOID_KOTTD, 0, this.toid, 20, 16);
        this.imageLength = var2;
        this.oid = null;
        this.snapshot = null;
        this.versionNumber = 0;
        this.flags = 1;
    }

    void marshal(T4CMAREngine var1) throws IOException {
        if (this.toid == null) {
            var1.marshalUB4(0L);
        } else {
            var1.marshalUB4((long)this.toid.length);
            var1.marshalCLR(this.toid, 0, this.toid.length);
        }

        if (this.oid == null) {
            var1.marshalUB4(0L);
        } else {
            var1.marshalUB4((long)this.oid.length);
            var1.marshalCLR(this.oid, 0, this.oid.length);
        }

        if (this.snapshot == null) {
            var1.marshalUB4(0L);
        } else {
            var1.marshalUB4((long)this.snapshot.length);
            var1.marshalCLR(this.snapshot, 0, this.snapshot.length);
        }

        var1.marshalUB2(this.versionNumber);
        var1.marshalUB4((long)this.imageLength);
        var1.marshalUB2(this.flags);
    }

    void unmarshal(T4CMAREngine var1) throws SQLException, IOException {
        int var2 = (int)var1.unmarshalUB4();
        if (this.toid == null || this.toid.length != var2) {
            this.toid = new byte[var2];
        }

        if (var2 > 0) {
            var1.unmarshalCLR(this.toid, 0, this.intArr, var2);
        }

        int var3 = (int)var1.unmarshalUB4();
        this.oid = new byte[var3];
        if (var3 > 0) {
            var1.unmarshalCLR(this.oid, 0, this.intArr, var3);
        }

        int var4 = (int)var1.unmarshalUB4();
        this.snapshot = new byte[var4];
        if (var4 > 0) {
            var1.unmarshalCLR(this.snapshot, 0, this.intArr, var4);
        }

        this.versionNumber = var1.unmarshalUB2();
        this.imageLength = (int)var1.unmarshalUB4();
        this.flags = var1.unmarshalUB2();
    }
}
