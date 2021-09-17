//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package oracle.sql.converter;

import oracle.i18n.text.OraBoot;

class Orai18nCharacterSetMetaData implements InternalCharacterSetMetaData {
    OraBoot oraBoot = OraBoot.getInstance();

    Orai18nCharacterSetMetaData() {
    }

    public boolean isFixedWidth(int var1) {
        String var2 = this.oraBoot.getCharSetName("" + var1);
        return this.oraBoot.getCharSetIsFixed().contains(var2);
    }

    public int getMaxCharLength(int var1) {
        String var2 = this.oraBoot.getCharsetMaxCharLen("" + var1);
        return var2 != null ? Integer.parseInt(var2) & 255 : 0;
    }
}
