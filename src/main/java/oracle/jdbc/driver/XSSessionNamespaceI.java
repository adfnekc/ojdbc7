//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package oracle.jdbc.driver;

import java.io.IOException;
import java.sql.SQLException;
import oracle.jdbc.internal.XSPrincipal;
import oracle.jdbc.internal.XSSessionNamespace;
import oracle.sql.TIMESTAMPTZ;

class XSSessionNamespaceI extends XSSessionNamespace {
    XSPrincipalI kpxssessnsuser = null;
    String kpxssessnstenant = null;
    byte[] kpxssessnstenantBytes = null;
    byte[] kpxssessnssid = null;
    byte[] kpxssessnscookie = null;
    long kpxssessnsproxy = 0L;
    long kpxssessnsaclids = 0L;
    long kpxssessnscreator = 0L;
    long kpxssessnsupdater = 0L;
    byte[] kpxssessnscrets = null;
    byte[] kpxssessnsaccts = null;
    byte[] kpxssessnsautts = null;
    int kpxssessnstimeout = 0;
    private static final String _Copyright_2007_Oracle_All_Rights_Reserved_ = null;
    public static final String BUILD_DATE = "Thu_Apr_04_15:09:24_PDT_2013";
    public static final boolean TRACE = false;

    XSSessionNamespaceI() {
    }

    public XSPrincipal getPrincipal() {
        return this.kpxssessnsuser;
    }

    public String getTenant() {
        return this.kpxssessnstenant;
    }

    public byte[] getSessionId() {
        return this.kpxssessnssid;
    }

    public byte[] getCookie() {
        return this.kpxssessnscookie;
    }

    public long getProxyId() {
        return this.kpxssessnsproxy;
    }

    public long getACLId() {
        return this.kpxssessnsaclids;
    }

    public long getCreatedBy() {
        return this.kpxssessnscreator;
    }

    public long getUpdatedBy() {
        return this.kpxssessnsupdater;
    }

    public TIMESTAMPTZ getCreateTimestamp() {
        return new TIMESTAMPTZ(this.kpxssessnscrets);
    }

    public TIMESTAMPTZ getAccessTimestamp() {
        return new TIMESTAMPTZ(this.kpxssessnsaccts);
    }

    public TIMESTAMPTZ getAuthTimestamp() {
        return new TIMESTAMPTZ(this.kpxssessnsautts);
    }

    public int getTimeout() {
        return this.kpxssessnstimeout;
    }

    private void setPrincipal(XSPrincipal var1) throws SQLException {
        this.kpxssessnsuser = (XSPrincipalI)var1;
    }

    private void setTenant(String var1) throws SQLException {
        this.kpxssessnstenant = var1;
    }

    private void setSessionId(byte[] var1) throws SQLException {
        this.kpxssessnssid = var1;
    }

    private void setCookie(byte[] var1) throws SQLException {
        this.kpxssessnscookie = var1;
    }

    private void setProxyId(long var1) throws SQLException {
        this.kpxssessnsproxy = var1;
    }

    private void setACLId(long var1) throws SQLException {
        this.kpxssessnsaclids = var1;
    }

    private void setCreatedBy(long var1) throws SQLException {
        this.kpxssessnscreator = var1;
    }

    private void setUpdatedBy(long var1) throws SQLException {
        this.kpxssessnsupdater = var1;
    }

    private void setCreateTimestamp(byte[] var1) throws SQLException {
        this.kpxssessnscrets = var1;
    }

    private void setAccessTimestamp(byte[] var1) throws SQLException {
        this.kpxssessnsaccts = var1;
    }

    private void setAuthTimestamp(byte[] var1) throws SQLException {
        this.kpxssessnsautts = var1;
    }

    private void setTimeout(int var1) throws SQLException {
        this.kpxssessnstimeout = var1;
    }

    static XSSessionNamespaceI unmarshal(T4CMAREngine var0) throws SQLException, IOException {
        XSPrincipalI var1 = XSPrincipalI.unmarshal(var0);
        int[] var2 = new int[1];
        String var3 = null;
        int var4 = (int)var0.unmarshalUB4();
        byte[] var5;
        if (var4 > 0) {
            var5 = new byte[var4];
            var0.unmarshalCLR(var5, 0, var2);
            var3 = var0.conv.CharBytesToString(var5, var2[0]);
        }

        var5 = null;
        int var6 = (int)var0.unmarshalUB4();
        if (var6 > 0) {
            var0.unmarshalUB1();
            var5 = var0.unmarshalNBytes(var6);
        }

        byte[] var7 = null;
        int var8 = (int)var0.unmarshalUB4();
        if (var8 > 0) {
            var0.unmarshalUB1();
            var7 = var0.unmarshalNBytes(var8);
        }

        long var9 = var0.unmarshalSB8();
        long var11 = var0.unmarshalSB8();
        long var13 = var0.unmarshalSB8();
        long var15 = var0.unmarshalSB8();
        byte[] var17 = null;
        if (var0.unmarshalUB1() == 1) {
            int var18 = (int)var0.unmarshalUB4();
            var17 = var0.unmarshalNBytes(var18);
        }

        byte[] var22 = null;
        if (var0.unmarshalUB1() == 1) {
            int var19 = (int)var0.unmarshalUB4();
            var22 = var0.unmarshalNBytes(var19);
        }

        byte[] var23 = null;
        int var20;
        if (var0.unmarshalUB1() == 1) {
            var20 = (int)var0.unmarshalUB4();
            var23 = var0.unmarshalNBytes(var20);
        }

        var20 = (int)var0.unmarshalUB4();
        XSSessionNamespaceI var21 = new XSSessionNamespaceI();
        var21.setPrincipal(var1);
        var21.setTenant(var3);
        var21.setSessionId(var5);
        var21.setCookie(var7);
        var21.setProxyId(var9);
        var21.setACLId(var11);
        var21.setCreatedBy(var13);
        var21.setUpdatedBy(var15);
        var21.setCreateTimestamp(var17);
        var21.setAccessTimestamp(var22);
        var21.setAuthTimestamp(var23);
        var21.setTimeout(var20);
        return var21;
    }
}
