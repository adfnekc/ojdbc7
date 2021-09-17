//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package oracle.sql;

import java.sql.SQLException;
import oracle.jdbc.driver.DatabaseError;
import oracle.sql.converter.JdbcCharacterConverters;

class CharacterSetLCFixed extends CharacterSetWithConverter {
    static final String CHAR_CONV_SUPERCLASS_NAME = "oracle.sql.converter.CharacterConverterLCFixed";
    static final int CHARLENGTH = 4;
    static Class m_charConvSuperclass;
    char[] m_leadingCodes;
    private static final String _Copyright_2007_Oracle_All_Rights_Reserved_ = null;
    public static final String BUILD_DATE = "Thu_Apr_04_15:09:24_PDT_2013";
    public static final boolean TRACE = false;

    CharacterSetLCFixed(int var1, JdbcCharacterConverters var2) {
        super(var1, var2);
        this.m_leadingCodes = var2.getLeadingCodes();
    }

    static CharacterSetLCFixed getInstance(int var0, JdbcCharacterConverters var1) {
        return var1.getGroupId() == 3 ? new CharacterSetLCFixed(var0, var1) : null;
    }

    int decode(CharacterWalker var1) throws SQLException {
        if (var1.bytes.length - var1.next < 4) {
            SQLException var6 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 182, "destination too small");
            var6.fillInStackTrace();
            throw var6;
        } else {
            int var2 = var1.bytes[var1.next] << 8 | var1.bytes[var1.next + 1];

            for(int var3 = 0; var3 < this.m_leadingCodes.length; ++var3) {
                if (var2 == this.m_leadingCodes[var3]) {
                    int var4 = 0;

                    for(int var5 = 0; var5 < 4; ++var5) {
                        var4 = var4 << 8 | var1.bytes[var1.next++];
                    }

                    return var4;
                }
            }

            SQLException var7 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 181, "Leading code invalid");
            var7.fillInStackTrace();
            throw var7;
        }
    }

    void encode(CharacterBuffer var1, int var2) throws SQLException {
        int var3 = var2 >> 16;

        for(int var4 = 0; var4 < this.m_leadingCodes.length; ++var4) {
            if (var3 == this.m_leadingCodes[var4]) {
                need(var1, 4);

                for(int var5 = 3; var5 >= 0; --var5) {
                    var1.bytes[var1.next++] = (byte)(var2 >> 8 * var5 & 255);
                }

                return;
            }
        }

        SQLException var6 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 181, "Leading code invalid");
        var6.fillInStackTrace();
        throw var6;
    }
}
