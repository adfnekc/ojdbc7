//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package oracle.sql;

import java.sql.SQLException;
import oracle.jdbc.driver.DatabaseError;
import oracle.jdbc.internal.OracleConnection;

class CharacterSetUnknown extends CharacterSet implements CharacterRepConstants {
    private static final String _Copyright_2007_Oracle_All_Rights_Reserved_ = null;
    public static final String BUILD_DATE = "Thu_Apr_04_15:09:24_PDT_2013";
    public static final boolean TRACE = false;

    CharacterSetUnknown(int var1) {
        super(var1);
        this.rep = 1024 + var1;
    }

    public boolean isLossyFrom(CharacterSet var1) {
        return var1.getOracleId() != this.getOracleId();
    }

    public boolean isConvertibleFrom(CharacterSet var1) {
        return var1.getOracleId() == this.getOracleId();
    }

    public String toStringWithReplacement(byte[] var1, int var2, int var3) {
        return "???";
    }

    public String toString(byte[] var1, int var2, int var3) throws SQLException {
        failCharsetUnknown(this);
        return null;
    }

    public byte[] convert(String var1) throws SQLException {
        failCharsetUnknown(this);
        return null;
    }

    public byte[] convertWithReplacement(String var1) {
        return new byte[0];
    }

    public byte[] convert(CharacterSet var1, byte[] var2, int var3, int var4) throws SQLException {
        if (var1.getOracleId() == this.getOracleId()) {
            return useOrCopy(var2, var3, var4);
        } else {
            failCharsetUnknown(this);
            return null;
        }
    }

    int decode(CharacterWalker var1) throws SQLException {
        failCharsetUnknown(this);
        return 0;
    }

    void encode(CharacterBuffer var1, int var2) throws SQLException {
        failCharsetUnknown(this);
    }

    static void failCharsetUnknown(CharacterSet var0) throws SQLException {
        SQLException var1 = DatabaseError.createSqlException((OracleConnection)null, 56, var0);
        var1.fillInStackTrace();
        throw var1;
    }

    public boolean isUnknown() {
        return true;
    }
}
