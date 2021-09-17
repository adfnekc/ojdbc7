//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package oracle.sql;

import java.sql.SQLException;

interface LdxLib {
    byte[] ldxadm(byte[] var1, int var2) throws SQLException;

    byte[] ldxads(byte[] var1, int var2, int var3) throws SQLException;

    int ldxchk(byte[] var1) throws SQLException;

    byte[] ldxdfd(int var1, int var2) throws SQLException;

    void ldxdtd(byte[] var1, int[] var2, int[] var3) throws SQLException;

    String ldxdts(byte[] var1, String var2, String var3) throws SQLException;

    String ldxdts(byte[] var1, byte[] var2, String var3) throws SQLException;

    byte[] ldxsto(String var1, String var2) throws SQLException;

    byte[] ldxdyf(byte[] var1) throws SQLException;

    void ldxftd(byte[] var1, int[] var2, int[] var3) throws SQLException;

    byte[] ldxgdt() throws SQLException;

    byte[] ldxldd(byte[] var1) throws SQLException;

    byte[] ldxnxd(byte[] var1, int var2) throws SQLException;

    byte[] ldxrnd(byte[] var1, String var2) throws SQLException;

    byte[] ldxsbm(byte[] var1, byte[] var2) throws SQLException;

    void ldxsub(byte[] var1, byte[] var2, int[] var3, int[] var4) throws SQLException;

    byte[] ldxstd(String var1, String var2, String var3) throws SQLException;

    byte[] ldxtrn(byte[] var1, String var2) throws SQLException;
}
