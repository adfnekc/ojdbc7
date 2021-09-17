//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package oracle.sql;

import java.sql.SQLException;

public final class CharacterBuffer {
    CharacterSet charSet;
    byte[] bytes;
    int next;
    private static final String _Copyright_2007_Oracle_All_Rights_Reserved_ = null;
    public static final String BUILD_DATE = "Thu_Apr_04_15:09:24_PDT_2013";
    public static final boolean TRACE = false;

    public CharacterBuffer(CharacterSet var1) {
        this.charSet = var1;
        this.next = 0;
        this.bytes = new byte[32];
    }

    public void append(int var1) throws SQLException {
        this.charSet.encode(this, var1);
    }

    public byte[] getBytes() {
        return CharacterSet.useOrCopy(this.bytes, 0, this.next);
    }
}
