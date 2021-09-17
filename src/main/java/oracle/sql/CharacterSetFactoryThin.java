//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package oracle.sql;

class CharacterSetFactoryThin extends CharacterSetFactory {
    private static final String _Copyright_2007_Oracle_All_Rights_Reserved_ = null;
    public static final String BUILD_DATE = "Thu_Apr_04_15:09:24_PDT_2013";
    public static final boolean TRACE = false;

    CharacterSetFactoryThin() {
    }

    public CharacterSet make(int var1) {
        if (var1 == -1) {
            var1 = 31;
        }

        if (var1 == 2000) {
            return new CharacterSetAL16UTF16(var1);
        } else if (var1 != 870 && var1 != 871) {
            if (var1 == 873) {
                return new CharacterSetAL32UTF8(var1);
            } else if (var1 == 872) {
                return new CharacterSetUTFE(var1);
            } else if (var1 == 2002) {
                return new CharacterSetAL16UTF16LE(var1);
            } else {
                CharacterSet var2 = CharacterSetWithConverter.getInstance(var1);
                return (CharacterSet)(var2 != null ? var2 : new CharacterSetUnknown(var1));
            }
        } else {
            return new CharacterSetUTF(var1);
        }
    }
}
