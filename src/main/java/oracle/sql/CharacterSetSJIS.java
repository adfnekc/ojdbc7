//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package oracle.sql;

import java.sql.SQLException;
import oracle.jdbc.driver.DatabaseError;
import oracle.sql.converter.JdbcCharacterConverters;

class CharacterSetSJIS extends CharacterSetWithConverter {
    static final String CHAR_CONV_SUPERCLASS_NAME = "oracle.sql.converter.CharacterConverterSJIS";
    static final short MAX_7BIT = 127;
    static final short MIN_8BIT_SB = 161;
    static final short MAX_8BIT_SB = 223;
    static Class m_charConvSuperclass;
    private static final String _Copyright_2007_Oracle_All_Rights_Reserved_ = null;
    public static final String BUILD_DATE = "Thu_Apr_04_15:09:24_PDT_2013";
    public static final boolean TRACE = false;

    CharacterSetSJIS(int var1, JdbcCharacterConverters var2) {
        super(var1, var2);
    }

    static CharacterSetSJIS getInstance(int var0, JdbcCharacterConverters var1) {
        return var1.getGroupId() == 4 ? new CharacterSetSJIS(var0, var1) : null;
    }

    int decode(CharacterWalker var1) throws SQLException {
        int var2 = var1.bytes[var1.next] & 255;
        ++var1.next;
        if (var2 > 223 || var2 > 127 && var2 < 161) {
            if (var1.bytes.length <= var1.next) {
                SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 182, "destination too small");
                var3.fillInStackTrace();
                throw var3;
            }

            var2 = var2 << 8 | var1.bytes[var1.next];
            ++var1.next;
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
