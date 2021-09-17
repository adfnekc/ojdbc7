//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package oracle.sql;

import java.sql.SQLException;
import oracle.jdbc.driver.DatabaseError;
import oracle.sql.converter.JdbcCharacterConverters;

class CharacterSetGB18030 extends CharacterSetWithConverter {
    static final int MAX_7BIT = 127;
    static Class m_charConvSuperclass;
    private static final String _Copyright_2007_Oracle_All_Rights_Reserved_ = null;
    public static final String BUILD_DATE = "Thu_Apr_04_15:09:24_PDT_2013";
    public static final boolean TRACE = false;

    CharacterSetGB18030(int var1, JdbcCharacterConverters var2) {
        super(var1, var2);
    }

    static CharacterSetGB18030 getInstance(int var0, JdbcCharacterConverters var1) {
        return var1.getGroupId() == 9 ? new CharacterSetGB18030(var0, var1) : null;
    }

    int decode(CharacterWalker var1) throws SQLException {
        int var2 = var1.bytes[var1.next] & 255;
        if (var2 > 127) {
            SQLException var3;
            if (var1.bytes.length <= var1.next + 1) {
                var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 182, "destination too small");
                var3.fillInStackTrace();
                throw var3;
            }

            if ((var1.bytes[var1.next] & 255) >= 129 && (var1.bytes[var1.next] & 255) <= 254 && (var1.bytes[var1.next + 1] & 255) >= 48 && (var1.bytes[var1.next + 1] & 255) <= 57) {
                if (var1.bytes.length <= var1.next + 3) {
                    var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 182, "destination too small");
                    var3.fillInStackTrace();
                    throw var3;
                }

                if ((var1.bytes[var1.next + 2] & 255) >= 129 && (var1.bytes[var1.next + 2] & 255) <= 254 && (var1.bytes[var1.next + 3] & 255) >= 48 && (var1.bytes[var1.next + 3] & 255) <= 57) {
                    var2 = (var1.bytes[var1.next] & 255) << 24 | (var1.bytes[var1.next + 1] & 255) << 16 | (var1.bytes[var1.next + 2] & 255) << 8 | var1.bytes[var1.next + 3] & 255;
                    var1.next += 4;
                } else {
                    var2 = var1.bytes[var1.next] & 255;
                    ++var1.next;
                }
            } else {
                var2 = (var1.bytes[var1.next] & 255) << 8 | var1.bytes[var1.next + 1] & 255;
                var1.next += 2;
            }
        }

        return var2;
    }

    void encode(CharacterBuffer var1, int var2) throws SQLException {
        short var3 = 0;

        for(short var4 = 0; var2 >> var3 != 0; ++var4) {
            var3 = (short)(var3 + 8);
        }

        byte var5;
        if (var2 >> 16 != 0) {
            var3 = 3;
            var5 = 4;
        } else if (var2 >> 8 != 0) {
            var3 = 1;
            var5 = 2;
        } else {
            var3 = 0;
            var5 = 1;
        }

        need(var1, var5);

        while(var3 >= 0) {
            var1.bytes[var1.next++] = (byte)(var2 >> var3 & 255);
            var3 = (short)(var3 - 8);
        }

    }
}
