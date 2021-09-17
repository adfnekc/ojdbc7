//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package oracle.sql;

import java.sql.SQLException;
import oracle.sql.converter.JdbcCharacterConverters;

class CharacterSet1Byte extends CharacterSetWithConverter {
    static final String CHAR_CONV_SUPERCLASS_NAME = "oracle.sql.converter.CharacterConverter1Byte";
    static Class m_charConvSuperclass;
    private static final String _Copyright_2007_Oracle_All_Rights_Reserved_ = null;
    public static final String BUILD_DATE = "Thu_Apr_04_15:09:24_PDT_2013";
    public static final boolean TRACE = false;

    CharacterSet1Byte(int var1, JdbcCharacterConverters var2) {
        super(var1, var2);
    }

    static CharacterSet1Byte getInstance(int var0, JdbcCharacterConverters var1) {
        return var1.getGroupId() == 0 ? new CharacterSet1Byte(var0, var1) : null;
    }

    int decode(CharacterWalker var1) throws SQLException {
        int var2 = var1.bytes[var1.next] & 255;
        ++var1.next;
        return var2;
    }

    void encode(CharacterBuffer var1, int var2) throws SQLException {
        need(var1, 1);
        if (var2 < 256) {
            var1.bytes[var1.next] = (byte)var2;
            ++var1.next;
        }

    }

    public int toCharWithReplacement(byte[] var1, int var2, char[] var3, int var4, int var5) throws SQLException {
        return this.m_converter.toUnicodeChars(var1, var2, var3, var4, var5);
    }
}
