//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package oracle.sql.converter;

import java.sql.SQLException;
import java.util.Vector;

public interface JdbcCharacterConverters {
    int CHARCONV1BYTEID = 0;
    int CHARCONV12BYTEID = 1;
    int CHARCONVJAEUCID = 2;
    int CHARCONVLCFIXEDID = 3;
    int CHARCONVSJISID = 4;
    int CHARCONVZHTEUCID = 5;
    int CHARCONV2BYTEFIXEDID = 6;
    int CHARCONVSHIFTID = 7;
    int CHARCONVLCID = 8;
    int CHARCONVGB18030ID = 9;
    int CHARCONVAL16UTF16ID = 10;
    int CHARCONVMSOLISO2022JPFWID = 11;
    int CHARCONVMSOLISO2022JPHWID = 12;
    int CHARCONVGBKID = 13;

    int getGroupId();

    int getOracleId();

    String toUnicodeString(byte[] var1, int var2, int var3) throws SQLException;

    String toUnicodeStringWithReplacement(byte[] var1, int var2, int var3);

    int toUnicodeChars(byte[] var1, int var2, char[] var3, int var4, int var5) throws SQLException;

    byte[] toOracleString(String var1) throws SQLException;

    byte[] toOracleStringWithReplacement(String var1);

    void buildUnicodeToOracleMapping();

    void extractCodepoints(Vector var1);

    void extractExtraMappings(Vector var1);

    boolean hasExtraMappings();

    char getOraChar1ByteRep();

    char getOraChar2ByteRep();

    int getUCS2CharRep();

    char[] getLeadingCodes();
}
