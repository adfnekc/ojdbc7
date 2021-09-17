//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package oracle.sql.converter;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Hashtable;
import oracle.sql.ConverterArchive;

public abstract class CharacterConverterJDBC implements JdbcCharacterConverters, Serializable {
    static final long serialVersionUID = 5948085171100875165L;
    static final String CONVERTERNAMEPREFIX = "converter_xcharset/lx2";
    static final String CONVERTERIDPREFIX = "0000";
    static final int HIBYTEMASK = 65280;
    static final int LOWBYTEMASK = 255;
    static final int STORE_INCREMENT = 10;
    static final int INVALID_ORA_CHAR = -1;
    static final int FIRSTBSHIFT = 24;
    static final int SECONDBSHIFT = 16;
    static final int THIRDBSHIFT = 8;
    static final int UB2MASK = 65535;
    static final int UB4MASK = 65535;
    static final HashMap m_converterStore = new HashMap();
    public int m_groupId;
    public int m_oracleId;
    public int[][] extraUnicodeToOracleMapping = (int[][])null;

    public CharacterConverterJDBC() {
    }

    public int getGroupId() {
        return this.m_groupId;
    }

    public int getOracleId() {
        return this.m_oracleId;
    }

    public char[] getLeadingCodes() {
        return null;
    }

    public static JdbcCharacterConverters getInstance(int var0) {
        CharacterConverterJDBC var1 = null;
        boolean var2 = false;
        boolean var3 = false;
        String var4 = Integer.toHexString(var0);
        synchronized(m_converterStore) {
            var1 = (CharacterConverterJDBC)m_converterStore.get(var4);
            if (var1 != null) {
                return var1;
            } else {
                String var6 = "converter_xcharset/lx2" + "0000".substring(0, 4 - var4.length()) + var4;
                ConverterArchive var7 = new ConverterArchive();
                var1 = (CharacterConverterJDBC)var7.readObj(var6 + ".glb");
                if (var1 == null) {
                    return null;
                } else {
                    var1.buildUnicodeToOracleMapping();
                    m_converterStore.put(var4, var1);
                    return var1;
                }
            }
        }
    }

    protected void storeMappingRange(int var1, Hashtable var2, Hashtable var3) {
        int var4 = var1 >> 24 & 255;
        int var5 = var1 >> 16 & 255;
        int var6 = var1 >> 8 & 255;
        int var7 = var1 & 255;
        Integer var8 = var4;
        Integer var9 = var1 >> 16 & '\uffff';
        Integer var10 = var1 >> 8 & 16777215;
        char[] var11;
        if (var1 >>> 26 == 54) {
            var11 = (char[])((char[])var2.get(var8));
            if (var11 == null) {
                var11 = new char[]{'ÿ', '\u0000'};
            }

            if (var11[0] == 255 && var11[1] == 0) {
                var11[0] = (char)var5;
                var11[1] = (char)var5;
            } else {
                if (var5 < (var11[0] & '\uffff')) {
                    var11[0] = (char)var5;
                }

                if (var5 > (var11[0] & '\uffff')) {
                    var11[1] = (char)var5;
                }
            }

            var2.put(var8, var11);
            var11 = (char[])((char[])var2.get(var9));
            if (var11 == null) {
                var11 = new char[]{'ÿ', '\u0000'};
            }

            if (var11[0] == 255 && var11[1] == 0) {
                var11[0] = (char)var6;
                var11[1] = (char)var6;
            } else {
                if (var6 < (var11[0] & '\uffff')) {
                    var11[0] = (char)var6;
                }

                if (var6 > (var11[0] & '\uffff')) {
                    var11[1] = (char)var6;
                }
            }

            var2.put(var9, var11);
        }

        var11 = (char[])((char[])var3.get(var10));
        if (var11 == null) {
            var11 = new char[]{'ÿ', '\u0000'};
        }

        if (var11[0] == 255 && var11[1] == 0) {
            var11[0] = (char)var7;
            var11[1] = (char)var7;
        } else {
            if (var7 < (var11[0] & '\uffff')) {
                var11[0] = (char)var7;
            }

            if (var7 > (var11[0] & '\uffff')) {
                var11[1] = (char)var7;
            }
        }

        var3.put(var10, var11);
    }
}
