//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package oracle.jdbc.oracore;

import java.sql.SQLException;
import java.util.Vector;
import oracle.jdbc.driver.DatabaseError;
import oracle.jdbc.internal.OracleConnection;

public class TDSReader {
    static final int KOPT_NONE_FINAL_TYPE = 1;
    static final int KOPT_JAVA_OBJECT = 2;
    long fixedDataSize = 0L;
    Vector patches = null;
    byte[] tds;
    int beginIndex;
    int index;
    private static final String _Copyright_2007_Oracle_All_Rights_Reserved_ = null;
    public static final String BUILD_DATE = "Thu_Apr_04_15:09:24_PDT_2013";
    public static final boolean TRACE = false;

    TDSReader(byte[] var1, long var2) {
        this.tds = var1;
        this.beginIndex = (int)var2;
        this.index = (int)var2;
    }

    void skipBytes(int var1) throws SQLException {
        this.index += var1;
    }

    void checkNextByte(byte var1) throws SQLException {
        try {
            if (var1 != this.tds[this.index]) {
                SQLException var2 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 47, "parseTDS");
                var2.fillInStackTrace();
                throw var2;
            }
        } finally {
            ++this.index;
        }

    }

    byte readByte() throws SQLException {
        byte var1;
        try {
            var1 = this.tds[this.index];
        } finally {
            ++this.index;
        }

        return var1;
    }

    int readUnsignedByte() throws SQLException {
        int var1;
        try {
            var1 = this.tds[this.index] & 255;
        } finally {
            ++this.index;
        }

        return var1;
    }

    int readUB2() throws SQLException {
        int var1;
        try {
            var1 = ((this.tds[this.index] & 255) << 8) + (this.tds[this.index + 1] & 255);
        } finally {
            this.index += 2;
        }

        return var1;
    }

    long readLong() throws SQLException {
        long var1;
        try {
            var1 = (long)((((this.tds[this.index] & 255) * 256 + (this.tds[this.index + 1] & 255)) * 256 + (this.tds[this.index + 2] & 255)) * 256 + (this.tds[this.index + 3] & 255));
        } finally {
            this.index += 4;
        }

        return var1;
    }

    void addNormalPatch(long var1, byte var3, OracleType var4) throws SQLException {
        this.addPatch(new TDSPatch(0, var4, var1, var3));
    }

    void addSimplePatch(long var1, OracleType var3) throws SQLException {
        this.addPatch(new TDSPatch(1, var3, var1, 0));
    }

    void addPatch(TDSPatch var1) throws SQLException {
        if (this.patches == null) {
            this.patches = new Vector(5);
        }

        this.patches.addElement(var1);
    }

    long moveToPatchPos(TDSPatch var1) throws SQLException {
        long var2 = var1.getPosition();
        if ((long)this.beginIndex + var2 > (long)this.tds.length) {
            SQLException var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 47, "parseTDS");
            var4.fillInStackTrace();
            throw var4;
        } else {
            this.skip_to(var2);
            return var2;
        }
    }

    TDSPatch getNextPatch() throws SQLException {
        TDSPatch var1 = null;
        if (this.patches != null && this.patches.size() > 0) {
            var1 = (TDSPatch)this.patches.firstElement();
            this.patches.removeElementAt(0);
        }

        return var1;
    }

    void skip_to(long var1) {
        this.index = this.beginIndex + (int)var1;
    }

    long offset() throws SQLException {
        return (long)(this.index - this.beginIndex);
    }

    long absoluteOffset() throws SQLException {
        return (long)this.index;
    }

    byte[] tds() throws SQLException {
        return this.tds;
    }

    boolean isJavaObject(int var1, byte var2) {
        return var1 >= 3 && (var2 & 2) != 0;
    }

    boolean isFinalType(int var1, byte var2) {
        return var1 >= 3 && (var2 & 1) == 0;
    }

    protected OracleConnection getConnectionDuringExceptionHandling() {
        return null;
    }
}
