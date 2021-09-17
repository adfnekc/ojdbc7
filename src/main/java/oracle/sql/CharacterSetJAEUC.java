//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package oracle.sql;

import java.sql.SQLException;
import oracle.sql.converter.JdbcCharacterConverters;

class CharacterSetJAEUC extends CharacterSetWithConverter {
    static final String CHAR_CONV_SUPERCLASS_NAME = "oracle.sql.converter.CharacterConverterJAEUC";
    static final transient short MAX_7BIT = 127;
    static final transient short LEADINGCODE = 143;
    static Class m_charConvSuperclass;
    private static final String _Copyright_2007_Oracle_All_Rights_Reserved_ = null;
    public static final String BUILD_DATE = "Thu_Apr_04_15:09:24_PDT_2013";
    public static final boolean TRACE = false;

    CharacterSetJAEUC(int var1, JdbcCharacterConverters var2) {
        super(var1, var2);
    }

    static CharacterSetJAEUC getInstance(int var0, JdbcCharacterConverters var1) {
        return var1.getGroupId() == 2 ? new CharacterSetJAEUC(var0, var1) : null;
    }

    int decode(CharacterWalker var1) throws SQLException {
        int var2 = var1.bytes[var1.next] & 255;
        ++var1.next;
        if (var2 > 127) {
            if (var2 != 143) {
                if (var1.bytes.length > var1.next) {
                    var2 = var2 << 8 | var1.bytes[var1.next];
                    ++var1.next;
                }
            } else {
                for(int var3 = 0; var3 < 2; ++var3) {
                    if (var1.bytes.length > var1.next) {
                        var2 = var2 << 8 | var1.bytes[var1.next];
                        ++var1.next;
                    }
                }
            }
        }

        return var2;
    }

    void encode(CharacterBuffer var1, int var2) throws SQLException {
        short var3 = 0;

        short var4;
        for(var4 = 1; var2 >> var3 != 0; ++var4) {
            var3 = (short)(var3 + 8);
        }

        need(var1, var4);

        while(var3 >= 0) {
            var1.bytes[var1.next++] = (byte)(var2 >> var3 & 255);
            var3 = (short)(var3 - 8);
        }

    }
}
