//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package oracle.sql;

import java.sql.SQLException;

class LdxLibServer implements LdxLib {
    LdxLibServer() {
    }

    public native byte[] ldxadm(byte[] var1, int var2) throws SQLException;

    public native byte[] ldxads(byte[] var1, int var2, int var3) throws SQLException;

    public native int ldxchk(byte[] var1) throws SQLException;

    public native byte[] ldxdfd(int var1, int var2) throws SQLException;

    public native void ldxdtd(byte[] var1, int[] var2, int[] var3) throws SQLException;

    public native String ldxdts(byte[] var1, String var2, String var3) throws SQLException;

    public native String ldxdts(byte[] var1, byte[] var2, String var3) throws SQLException;

    public native byte[] ldxsto(String var1, String var2) throws SQLException;

    public native byte[] ldxdyf(byte[] var1) throws SQLException;

    public native void ldxftd(byte[] var1, int[] var2, int[] var3) throws SQLException;

    public native byte[] ldxgdt() throws SQLException;

    public native byte[] ldxldd(byte[] var1) throws SQLException;

    public native byte[] ldxnxd(byte[] var1, int var2) throws SQLException;

    public native byte[] ldxrnd(byte[] var1, String var2) throws SQLException;

    public native byte[] ldxsbm(byte[] var1, byte[] var2) throws SQLException;

    public native void ldxsub(byte[] var1, byte[] var2, int[] var3, int[] var4) throws SQLException;

    public native byte[] ldxstd(String var1, String var2, String var3) throws SQLException;

    public native byte[] ldxtrn(byte[] var1, String var2) throws SQLException;

    static {
        LoadCorejava.init();
    }
}
