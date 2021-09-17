//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package oracle.sql.converter;

public class CharacterConverterFactoryJDBC extends CharacterConverterFactory {
    public CharacterConverterFactoryJDBC() {
    }

    public JdbcCharacterConverters make(int var1) {
        return CharacterConverterJDBC.getInstance(var1);
    }
}
