//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package oracle.sql;

import java.sql.SQLException;

class LnxLibServer implements LnxLib {
    LnxLibServer() {
    }

    public native byte[] lnxabs(byte[] var1) throws SQLException;

    public native byte[] lnxacos(byte[] var1) throws SQLException;

    public native byte[] lnxadd(byte[] var1, byte[] var2) throws SQLException;

    public native byte[] lnxasin(byte[] var1) throws SQLException;

    public native byte[] lnxatan(byte[] var1) throws SQLException;

    public native byte[] lnxatan2(byte[] var1, byte[] var2) throws SQLException;

    public native byte[] lnxbex(byte[] var1, byte[] var2) throws SQLException;

    public native byte[] lnxcos(byte[] var1) throws SQLException;

    public native byte[] lnxcsh(byte[] var1) throws SQLException;

    public native byte[] lnxdec(byte[] var1) throws SQLException;

    public native byte[] lnxdiv(byte[] var1, byte[] var2) throws SQLException;

    public native byte[] lnxexp(byte[] var1) throws SQLException;

    public native byte[] lnxflo(byte[] var1) throws SQLException;

    public native byte[] lnxceil(byte[] var1) throws SQLException;

    public native byte[] lnxfpr(byte[] var1, int var2) throws SQLException;

    public native byte[] lnxinc(byte[] var1) throws SQLException;

    public native byte[] lnxln(byte[] var1) throws SQLException;

    public native byte[] lnxlog(byte[] var1, byte[] var2) throws SQLException;

    public native byte[] lnxmod(byte[] var1, byte[] var2) throws SQLException;

    public native byte[] lnxmul(byte[] var1, byte[] var2) throws SQLException;

    public native byte[] lnxneg(byte[] var1) throws SQLException;

    public native byte[] lnxpow(byte[] var1, int var2) throws SQLException;

    public native byte[] lnxrou(byte[] var1, int var2) throws SQLException;

    public native byte[] lnxsca(byte[] var1, int var2, int var3, boolean[] var4) throws SQLException;

    public native byte[] lnxshift(byte[] var1, int var2) throws SQLException;

    public native byte[] lnxsin(byte[] var1) throws SQLException;

    public native byte[] lnxsnh(byte[] var1) throws SQLException;

    public native byte[] lnxsqr(byte[] var1) throws SQLException;

    public native byte[] lnxsub(byte[] var1, byte[] var2) throws SQLException;

    public native byte[] lnxtan(byte[] var1) throws SQLException;

    public native byte[] lnxtnh(byte[] var1) throws SQLException;

    public native byte[] lnxtru(byte[] var1, int var2) throws SQLException;

    public native byte[] lnxcpn(String var1, boolean var2, int var3, boolean var4, int var5, String var6) throws SQLException;

    public native byte[] lnxfcn(String var1, String var2, String var3) throws SQLException;

    public native String lnxnfn(byte[] var1, String var2, String var3) throws SQLException;

    public native String lnxnuc(byte[] var1, int var2, String var3) throws SQLException;

    public native byte[] lnxren(double var1) throws SQLException;

    public native double lnxnur(byte[] var1);

    public native byte[] lnxmin(long var1);

    public native long lnxsni(byte[] var1) throws SQLException;

    static {
        LoadCorejava.init();
    }
}
