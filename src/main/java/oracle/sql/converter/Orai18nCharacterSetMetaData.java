//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package oracle.sql.converter;

// import orai18n.text.OraBoot;

class Orai18nCharacterSetMetaData implements InternalCharacterSetMetaData {
    // OraBoot oraBoot = OraBoot.getInstance();
    Object oraBoot = new Object();

    Orai18nCharacterSetMetaData() {
    }

    public boolean isFixedWidth(int var1) {
        // String var2 = this.oraBoot.getCharSetName("" + var1);
        // return this.oraBoot.getCharSetIsFixed().contains(var2);
        System.out.println("ERR 00000000000000000000000000000000000");
        return true;
    }

    public int getMaxCharLength(int var1) {
        // String var2 = this.oraBoot.getCharsetMaxCharLen("" + var1);
        // return var2 != null ? Integer.parseInt(var2) & 255 : 0;
        System.out.println("ERR 00000000000000000000000000000000000");
        return 255;
    }
}
