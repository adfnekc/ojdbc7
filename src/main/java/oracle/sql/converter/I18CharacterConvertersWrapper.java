//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package oracle.sql.converter;

import java.sql.SQLException;
import java.util.Vector;
import oracle.i18n.text.converter.CharacterConverter;
import oracle.jdbc.internal.OracleConnection;

public class I18CharacterConvertersWrapper implements JdbcCharacterConverters {
    CharacterConverter wrapper;
    private static final String _Copyright_2007_Oracle_All_Rights_Reserved_ = null;
    public static final String BUILD_DATE = "Thu_Apr_04_15:09:24_PDT_2013";
    public static final boolean TRACE = false;

    public I18CharacterConvertersWrapper(CharacterConverter var1) {
        this.wrapper = var1;
    }

    public int getGroupId() {
        return this.wrapper.getGroupId();
    }

    public int getOracleId() {
        return this.wrapper.getOracleId();
    }

    public char[] getLeadingCodes() {
        return this.wrapper.getLeadingCodes();
    }

    public String toUnicodeString(byte[] var1, int var2, int var3) throws SQLException {
        return this.wrapper.toUnicodeString(var1, var2, var3);
    }

    public String toUnicodeStringWithReplacement(byte[] var1, int var2, int var3) {
        return this.wrapper.toUnicodeStringWithReplacement(var1, var2, var3);
    }

    public byte[] toOracleString(String var1) throws SQLException {
        return this.wrapper.toOracleString(var1);
    }

    public byte[] toOracleStringWithReplacement(String var1) {
        return this.wrapper.toOracleStringWithReplacement(var1);
    }

    public void buildUnicodeToOracleMapping() {
        this.wrapper.buildUnicodeToOracleMapping();
    }

    public void extractCodepoints(Vector var1) {
        this.wrapper.extractCodepoints(var1);
    }

    public void extractExtraMappings(Vector var1) {
        this.wrapper.extractExtraMappings(var1);
    }

    public boolean hasExtraMappings() {
        return this.wrapper.hasExtraMappings();
    }

    public char getOraChar1ByteRep() {
        return this.wrapper.getOraChar1ByteRep();
    }

    public char getOraChar2ByteRep() {
        return this.wrapper.getOraChar2ByteRep();
    }

    public int getUCS2CharRep() {
        return this.wrapper.getUCS2CharRep();
    }

    public int toUnicodeChars(byte[] var1, int var2, char[] var3, int var4, int var5) throws SQLException {
        return this.wrapper.toUnicodeCharsWithReplacement(var1, var2, var3, var4, var5);
    }

    protected OracleConnection getConnectionDuringExceptionHandling() {
        return null;
    }
}
