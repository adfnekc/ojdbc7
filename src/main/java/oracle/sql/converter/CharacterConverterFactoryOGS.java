//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package oracle.sql.converter;

import oracle.i18n.text.converter.CharacterConverter;
import oracle.i18n.text.converter.CharacterConverterOGS;

public class CharacterConverterFactoryOGS extends CharacterConverterFactory {
    public CharacterConverterFactoryOGS() {
    }

    public JdbcCharacterConverters make(int var1) {
        CharacterConverter var2 = CharacterConverterOGS.getInstance(var1);
        return var2 == null ? null : new I18CharacterConvertersWrapper(var2);
    }
}
