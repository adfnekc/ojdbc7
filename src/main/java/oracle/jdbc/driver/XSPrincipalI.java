//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package oracle.jdbc.driver;

import java.io.IOException;
import java.sql.SQLException;
import oracle.jdbc.internal.XSPrincipal;
import oracle.jdbc.internal.XSPrincipal.Flag;

class XSPrincipalI extends XSPrincipal {
    long kpxsprindbid = 0L;
    String kpxsprinname = null;
    byte[] kpxsprinnameBytes = null;
    byte[] kpxsprinuuid = null;
    Flag kpxsprinflg;

    XSPrincipalI() {
        this.kpxsprinflg = Flag.KPXS_PRIN_EXT;
    }

    public void setDatabaseId(long var1) throws SQLException {
        this.kpxsprindbid = var1;
    }

    public void setName(String var1) throws SQLException {
        this.kpxsprinname = var1;
    }

    public void setUUID(byte[] var1) throws SQLException {
        this.kpxsprinuuid = var1;
    }

    public void setFlag(Flag var1) throws SQLException {
        this.kpxsprinflg = var1;
    }

    public long getDatabaseId() {
        return this.kpxsprindbid;
    }

    public String getName() {
        return this.kpxsprinname;
    }

    public byte[] getUUID() {
        return this.kpxsprinuuid;
    }

    public Flag getFlag() {
        return this.kpxsprinflg;
    }

    void doCharConversion(DBConversion var1) throws SQLException {
        if (this.kpxsprinname != null) {
            this.kpxsprinnameBytes = var1.StringToCharBytes(this.kpxsprinname);
        } else {
            this.kpxsprinnameBytes = null;
        }

    }

    void marshal(T4CMAREngine var1) throws IOException {
        var1.marshalSB8(this.kpxsprindbid);
        if (this.kpxsprinnameBytes != null) {
            var1.marshalUB4((long)this.kpxsprinnameBytes.length);
            var1.marshalCLR(this.kpxsprinnameBytes, this.kpxsprinnameBytes.length);
        } else {
            var1.marshalUB4(0L);
        }

        if (this.kpxsprinuuid != null) {
            var1.marshalUB4((long)this.kpxsprinuuid.length);
            var1.marshalCLR(this.kpxsprinuuid, this.kpxsprinuuid.length);
        } else {
            var1.marshalUB4(0L);
        }

        var1.marshalUB4(this.kpxsprinflg.getMode());
    }

    static XSPrincipalI unmarshal(T4CMAREngine var0) throws SQLException, IOException {
        int[] var1 = new int[1];
        long var2 = var0.unmarshalSB8();
        String var4 = null;
        int var5 = (int)var0.unmarshalUB4();
        byte[] var6;
        if (var5 > 0) {
            var6 = new byte[var5];
            var0.unmarshalCLR(var6, 0, var1);
            var4 = var0.conv.CharBytesToString(var6, var1[0]);
        }

        var6 = null;
        int var7 = (int)var0.unmarshalUB4();
        if (var7 > 0) {
            var0.unmarshalUB1();
            var6 = var0.unmarshalNBytes(var7);
        }

        long var8 = var0.unmarshalUB4();
        Flag var10;
        if (var8 == Flag.KPXS_PRIN_EXT.getMode()) {
            var10 = Flag.KPXS_PRIN_EXT;
        } else {
            var10 = Flag.KPXS_PRIN_USEDBID;
        }

        XSPrincipalI var11 = new XSPrincipalI();
        var11.setDatabaseId(var2);
        var11.setName(var4);
        var11.setUUID(var6);
        var11.setFlag(var10);
        return var11;
    }
}
