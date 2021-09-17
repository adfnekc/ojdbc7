//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package oracle.sql;

import java.sql.SQLException;

interface LnxLib {
    byte[] lnxabs(byte[] var1) throws SQLException;

    byte[] lnxacos(byte[] var1) throws SQLException;

    byte[] lnxadd(byte[] var1, byte[] var2) throws SQLException;

    byte[] lnxasin(byte[] var1) throws SQLException;

    byte[] lnxatan(byte[] var1) throws SQLException;

    byte[] lnxatan2(byte[] var1, byte[] var2) throws SQLException;

    byte[] lnxbex(byte[] var1, byte[] var2) throws SQLException;

    byte[] lnxcos(byte[] var1) throws SQLException;

    byte[] lnxcsh(byte[] var1) throws SQLException;

    byte[] lnxdec(byte[] var1) throws SQLException;

    byte[] lnxdiv(byte[] var1, byte[] var2) throws SQLException;

    byte[] lnxexp(byte[] var1) throws SQLException;

    byte[] lnxflo(byte[] var1) throws SQLException;

    byte[] lnxceil(byte[] var1) throws SQLException;

    byte[] lnxfpr(byte[] var1, int var2) throws SQLException;

    byte[] lnxinc(byte[] var1) throws SQLException;

    byte[] lnxln(byte[] var1) throws SQLException;

    byte[] lnxlog(byte[] var1, byte[] var2) throws SQLException;

    byte[] lnxmod(byte[] var1, byte[] var2) throws SQLException;

    byte[] lnxmul(byte[] var1, byte[] var2) throws SQLException;

    byte[] lnxneg(byte[] var1) throws SQLException;

    byte[] lnxpow(byte[] var1, int var2) throws SQLException;

    byte[] lnxrou(byte[] var1, int var2) throws SQLException;

    byte[] lnxsca(byte[] var1, int var2, int var3, boolean[] var4) throws SQLException;

    byte[] lnxshift(byte[] var1, int var2) throws SQLException;

    byte[] lnxsin(byte[] var1) throws SQLException;

    byte[] lnxsnh(byte[] var1) throws SQLException;

    byte[] lnxsqr(byte[] var1) throws SQLException;

    byte[] lnxsub(byte[] var1, byte[] var2) throws SQLException;

    byte[] lnxtan(byte[] var1) throws SQLException;

    byte[] lnxtnh(byte[] var1) throws SQLException;

    byte[] lnxtru(byte[] var1, int var2) throws SQLException;

    byte[] lnxcpn(String var1, boolean var2, int var3, boolean var4, int var5, String var6) throws SQLException;

    byte[] lnxfcn(String var1, String var2, String var3) throws SQLException;

    String lnxnfn(byte[] var1, String var2, String var3) throws SQLException;

    String lnxnuc(byte[] var1, int var2, String var3) throws SQLException;

    byte[] lnxren(double var1) throws SQLException;

    double lnxnur(byte[] var1);

    byte[] lnxmin(long var1);

    long lnxsni(byte[] var1) throws SQLException;
}
