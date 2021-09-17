//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package oracle.jdbc.driver;

import java.io.IOException;
import java.sql.SQLException;
import oracle.jdbc.internal.XSSecureId;

class XSSecureIdI extends XSSecureId {
    byte[] kpxssidpmac = null;
    byte[] kpxssidpmtid = null;
    long kpxssidpnonce = 0L;

    XSSecureIdI() {
    }

    public void setMac(byte[] var1) throws SQLException {
        this.kpxssidpmac = var1;
    }

    public void setMidtierId(byte[] var1) throws SQLException {
        this.kpxssidpmtid = var1;
    }

    public void setNonce(long var1) throws SQLException {
        this.kpxssidpnonce = var1;
    }

    public byte[] getMac() {
        return this.kpxssidpmac;
    }

    public byte[] getMidtierId() {
        return this.kpxssidpmtid;
    }

    public long getNonce() {
        return this.kpxssidpnonce;
    }

    void marshal(T4CMAREngine var1) throws IOException {
        if (this.kpxssidpmac != null) {
            var1.marshalUB4((long)this.kpxssidpmac.length);
            var1.marshalCLR(this.kpxssidpmac, this.kpxssidpmac.length);
        } else {
            var1.marshalUB4(0L);
        }

        if (this.kpxssidpmtid != null) {
            var1.marshalUB4((long)this.kpxssidpmtid.length);
            var1.marshalCLR(this.kpxssidpmtid, this.kpxssidpmtid.length);
        } else {
            var1.marshalUB4(0L);
        }

        var1.marshalUB4(this.kpxssidpnonce);
    }

    static XSSecureIdI unmarshal(T4CMAREngine var0) throws SQLException, IOException {
        byte[] var1 = null;
        byte[] var2 = null;
        long var3 = 0L;
        int var5 = (int)var0.unmarshalUB4();
        if (var5 > 0) {
            var1 = var0.unmarshalNBytes(var5);
        }

        int var6 = (int)var0.unmarshalUB4();
        if (var6 > 0) {
            var2 = var0.unmarshalNBytes(var6);
        }

        var3 = var0.unmarshalUB4();
        XSSecureIdI var7 = new XSSecureIdI();
        var7.setMac(var1);
        var7.setMidtierId(var2);
        var7.setNonce(var3);
        return var7;
    }
}
