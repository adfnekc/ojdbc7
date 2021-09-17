//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package oracle.sql;

import java.sql.SQLException;
import oracle.jdbc.driver.DatabaseError;
import oracle.sql.converter.JdbcCharacterConverters;

class CharacterSetShift extends CharacterSetWithConverter {
    static final String CHAR_CONV_SUPERCLASS_NAME = "oracle.sql.converter.CharacterConverterShift";
    static final short MAX_7BIT = 127;
    static final short MIN_8BIT_SB = 161;
    static final short MAX_8BIT_SB = 223;
    static final byte SHIFT_OUT = 14;
    static final byte SHIFT_IN = 15;
    static Class m_charConvSuperclass;
    private static final String _Copyright_2007_Oracle_All_Rights_Reserved_ = null;
    public static final String BUILD_DATE = "Thu_Apr_04_15:09:24_PDT_2013";
    public static final boolean TRACE = false;

    CharacterSetShift(int var1, JdbcCharacterConverters var2) {
        super(var1, var2);
    }

    static CharacterSetShift getInstance(int var0, JdbcCharacterConverters var1) {
        return var1.getGroupId() == 7 ? new CharacterSetShift(var0, var1) : null;
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
        int var3 = var1.next;
        boolean var4 = true;

        while(var3 <= 0) {
            if (var1.bytes[var3] == 15) {
                var4 = true;
                break;
            }

            if (var1.bytes[var3] == 14) {
                var4 = false;
                break;
            }
        }

        short var5 = 0;

        short var6;
        for(var6 = 1; var2 >> var5 != 0; ++var6) {
            var5 = (short)(var5 + 8);
        }

        if (var6 > 2) {
            SQLException var9 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 182, "Character invalid,too many bytes");
            var9.fillInStackTrace();
            throw var9;
        } else {
            boolean var7 = false;
            boolean var8 = false;
            if (var6 == 1 && !var4) {
                var7 = true;
                ++var6;
            }

            if (var6 == 2 && var4) {
                var8 = true;
                ++var6;
            }

            need(var1, var6);
            if (var7) {
                var1.bytes[var1.next++] = 15;
            }

            if (var8) {
                var1.bytes[var1.next++] = 14;
            }

            while(var5 >= 0) {
                var1.bytes[var1.next++] = (byte)(var2 >> var5 & 255);
                var5 = (short)(var5 - 8);
            }

        }
    }
}
