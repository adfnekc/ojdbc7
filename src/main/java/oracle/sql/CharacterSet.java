//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package oracle.sql;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.sql.SQLException;
import java.util.HashMap;
import oracle.jdbc.driver.DatabaseError;
import oracle.jdbc.internal.OracleConnection;
import oracle.sql.converter.CharacterConverterFactoryOGS;

public abstract class CharacterSet {
    public static final short DEFAULT_CHARSET = -1;
    public static final short ASCII_CHARSET = 1;
    public static final short ISO_LATIN_1_CHARSET = 31;
    public static final short UNICODE_1_CHARSET = 870;
    public static final short US7ASCII_CHARSET = 1;
    public static final short WE8DEC_CHARSET = 2;
    public static final short WE8HP_CHARSET = 3;
    public static final short US8PC437_CHARSET = 4;
    public static final short WE8EBCDIC37_CHARSET = 5;
    public static final short WE8EBCDIC500_CHARSET = 6;
    public static final short WE8EBCDIC285_CHARSET = 8;
    public static final short WE8PC850_CHARSET = 10;
    public static final short D7DEC_CHARSET = 11;
    public static final short F7DEC_CHARSET = 12;
    public static final short S7DEC_CHARSET = 13;
    public static final short E7DEC_CHARSET = 14;
    public static final short SF7ASCII_CHARSET = 15;
    public static final short NDK7DEC_CHARSET = 16;
    public static final short I7DEC_CHARSET = 17;
    public static final short NL7DEC_CHARSET = 18;
    public static final short CH7DEC_CHARSET = 19;
    public static final short YUG7ASCII_CHARSET = 20;
    public static final short SF7DEC_CHARSET = 21;
    public static final short TR7DEC_CHARSET = 22;
    public static final short IW7IS960_CHARSET = 23;
    public static final short IN8ISCII_CHARSET = 25;
    public static final short WE8ISO8859P1_CHARSET = 31;
    public static final short EE8ISO8859P2_CHARSET = 32;
    public static final short SE8ISO8859P3_CHARSET = 33;
    public static final short NEE8ISO8859P4_CHARSET = 34;
    public static final short CL8ISO8859P5_CHARSET = 35;
    public static final short AR8ISO8859P6_CHARSET = 36;
    public static final short EL8ISO8859P7_CHARSET = 37;
    public static final short IW8ISO8859P8_CHARSET = 38;
    public static final short WE8ISO8859P9_CHARSET = 39;
    public static final short NE8ISO8859P10_CHARSET = 40;
    public static final short TH8TISASCII_CHARSET = 41;
    public static final short TH8TISEBCDIC_CHARSET = 42;
    public static final short BN8BSCII_CHARSET = 43;
    public static final short VN8VN3_CHARSET = 44;
    public static final short VN8MSWIN1258_CHARSET = 45;
    public static final short WE8NEXTSTEP_CHARSET = 50;
    public static final short AR8ASMO708PLUS_CHARSET = 61;
    public static final short AR8EBCDICX_CHARSET = 70;
    public static final short AR8XBASIC_CHARSET = 72;
    public static final short EL8DEC_CHARSET = 81;
    public static final short TR8DEC_CHARSET = 82;
    public static final short WE8EBCDIC37C_CHARSET = 90;
    public static final short WE8EBCDIC500C_CHARSET = 91;
    public static final short IW8EBCDIC424_CHARSET = 92;
    public static final short TR8EBCDIC1026_CHARSET = 93;
    public static final short WE8EBCDIC871_CHARSET = 94;
    public static final short WE8EBCDIC284_CHARSET = 95;
    public static final short WE8EBCDIC1047_CHARSET = 96;
    public static final short EEC8EUROASCI_CHARSET = 110;
    public static final short EEC8EUROPA3_CHARSET = 113;
    public static final short LA8PASSPORT_CHARSET = 114;
    public static final short BG8PC437S_CHARSET = 140;
    public static final short EE8PC852_CHARSET = 150;
    public static final short RU8PC866_CHARSET = 152;
    public static final short RU8BESTA_CHARSET = 153;
    public static final short IW8PC1507_CHARSET = 154;
    public static final short RU8PC855_CHARSET = 155;
    public static final short TR8PC857_CHARSET = 156;
    public static final short CL8MACCYRILLIC_CHARSET = 158;
    public static final short CL8MACCYRILLICS_CHARSET = 159;
    public static final short WE8PC860_CHARSET = 160;
    public static final short IS8PC861_CHARSET = 161;
    public static final short EE8MACCES_CHARSET = 162;
    public static final short EE8MACCROATIANS_CHARSET = 163;
    public static final short TR8MACTURKISHS_CHARSET = 164;
    public static final short IS8MACICELANDICS_CHARSET = 165;
    public static final short EL8MACGREEKS_CHARSET = 166;
    public static final short IW8MACHEBREWS_CHARSET = 167;
    public static final short EE8MSWIN1250_CHARSET = 170;
    public static final short CL8MSWIN1251_CHARSET = 171;
    public static final short ET8MSWIN923_CHARSET = 172;
    public static final short BG8MSWIN_CHARSET = 173;
    public static final short EL8MSWIN1253_CHARSET = 174;
    public static final short IW8MSWIN1255_CHARSET = 175;
    public static final short LT8MSWIN921_CHARSET = 176;
    public static final short TR8MSWIN1254_CHARSET = 177;
    public static final short WE8MSWIN1252_CHARSET = 178;
    public static final short BLT8MSWIN1257_CHARSET = 179;
    public static final short D8EBCDIC273_CHARSET = 180;
    public static final short I8EBCDIC280_CHARSET = 181;
    public static final short DK8EBCDIC277_CHARSET = 182;
    public static final short S8EBCDIC278_CHARSET = 183;
    public static final short EE8EBCDIC870_CHARSET = 184;
    public static final short CL8EBCDIC1025_CHARSET = 185;
    public static final short F8EBCDIC297_CHARSET = 186;
    public static final short IW8EBCDIC1086_CHARSET = 187;
    public static final short CL8EBCDIC1025X_CHARSET = 188;
    public static final short N8PC865_CHARSET = 190;
    public static final short BLT8CP921_CHARSET = 191;
    public static final short LV8PC1117_CHARSET = 192;
    public static final short LV8PC8LR_CHARSET = 193;
    public static final short BLT8EBCDIC1112_CHARSET = 194;
    public static final short LV8RST104090_CHARSET = 195;
    public static final short CL8KOI8R_CHARSET = 196;
    public static final short BLT8PC775_CHARSET = 197;
    public static final short F7SIEMENS9780X_CHARSET = 201;
    public static final short E7SIEMENS9780X_CHARSET = 202;
    public static final short S7SIEMENS9780X_CHARSET = 203;
    public static final short DK7SIEMENS9780X_CHARSET = 204;
    public static final short N7SIEMENS9780X_CHARSET = 205;
    public static final short I7SIEMENS9780X_CHARSET = 206;
    public static final short D7SIEMENS9780X_CHARSET = 207;
    public static final short WE8GCOS7_CHARSET = 210;
    public static final short EL8GCOS7_CHARSET = 211;
    public static final short US8BS2000_CHARSET = 221;
    public static final short D8BS2000_CHARSET = 222;
    public static final short F8BS2000_CHARSET = 223;
    public static final short E8BS2000_CHARSET = 224;
    public static final short DK8BS2000_CHARSET = 225;
    public static final short S8BS2000_CHARSET = 226;
    public static final short WE8BS2000_CHARSET = 231;
    public static final short CL8BS2000_CHARSET = 235;
    public static final short WE8BS2000L5_CHARSET = 239;
    public static final short WE8DG_CHARSET = 241;
    public static final short WE8NCR4970_CHARSET = 251;
    public static final short WE8ROMAN8_CHARSET = 261;
    public static final short EE8MACCE_CHARSET = 262;
    public static final short EE8MACCROATIAN_CHARSET = 263;
    public static final short TR8MACTURKISH_CHARSET = 264;
    public static final short IS8MACICELANDIC_CHARSET = 265;
    public static final short EL8MACGREEK_CHARSET = 266;
    public static final short IW8MACHEBREW_CHARSET = 267;
    public static final short US8ICL_CHARSET = 277;
    public static final short WE8ICL_CHARSET = 278;
    public static final short WE8ISOICLUK_CHARSET = 279;
    public static final short WE8MACROMAN8_CHARSET = 351;
    public static final short WE8MACROMAN8S_CHARSET = 352;
    public static final short TH8MACTHAI_CHARSET = 353;
    public static final short TH8MACTHAIS_CHARSET = 354;
    public static final short HU8CWI2_CHARSET = 368;
    public static final short EL8PC437S_CHARSET = 380;
    public static final short EL8EBCDIC875_CHARSET = 381;
    public static final short EL8PC737_CHARSET = 382;
    public static final short LT8PC772_CHARSET = 383;
    public static final short LT8PC774_CHARSET = 384;
    public static final short EL8PC869_CHARSET = 385;
    public static final short EL8PC851_CHARSET = 386;
    public static final short CDN8PC863_CHARSET = 390;
    public static final short HU8ABMOD_CHARSET = 401;
    public static final short AR8ASMO8X_CHARSET = 500;
    public static final short AR8NAFITHA711T_CHARSET = 504;
    public static final short AR8SAKHR707T_CHARSET = 505;
    public static final short AR8MUSSAD768T_CHARSET = 506;
    public static final short AR8ADOS710T_CHARSET = 507;
    public static final short AR8ADOS720T_CHARSET = 508;
    public static final short AR8APTEC715T_CHARSET = 509;
    public static final short AR8NAFITHA721T_CHARSET = 511;
    public static final short AR8HPARABIC8T_CHARSET = 514;
    public static final short AR8NAFITHA711_CHARSET = 554;
    public static final short AR8SAKHR707_CHARSET = 555;
    public static final short AR8MUSSAD768_CHARSET = 556;
    public static final short AR8ADOS710_CHARSET = 557;
    public static final short AR8ADOS720_CHARSET = 558;
    public static final short AR8APTEC715_CHARSET = 559;
    public static final short AR8MSAWIN_CHARSET = 560;
    public static final short AR8NAFITHA721_CHARSET = 561;
    public static final short AR8SAKHR706_CHARSET = 563;
    public static final short AR8ARABICMAC_CHARSET = 565;
    public static final short AR8ARABICMACS_CHARSET = 566;
    public static final short AR8ARABICMACT_CHARSET = 567;
    public static final short LA8ISO6937_CHARSET = 590;
    public static final short US8NOOP_CHARSET = 797;
    public static final short WE8DECTST_CHARSET = 798;
    public static final short JA16VMS_CHARSET = 829;
    public static final short JA16EUC_CHARSET = 830;
    public static final short JA16EUCYEN_CHARSET = 831;
    public static final short JA16SJIS_CHARSET = 832;
    public static final short JA16DBCS_CHARSET = 833;
    public static final short JA16SJISYEN_CHARSET = 834;
    public static final short JA16EBCDIC930_CHARSET = 835;
    public static final short JA16MACSJIS_CHARSET = 836;
    public static final short JA16EUCTILDE_CHARSET = 837;
    public static final short JA16SJISTILDE_CHARSET = 838;
    public static final short KO16KSC5601_CHARSET = 840;
    public static final short KO16DBCS_CHARSET = 842;
    public static final short KO16KSCCS_CHARSET = 845;
    public static final short KO16MSWIN949_CHARSET = 846;
    public static final short ZHS16CGB231280_CHARSET = 850;
    public static final short ZHS16MACCGB231280_CHARSET = 851;
    public static final short ZHS16GBK_CHARSET = 852;
    public static final short ZHS16DBCS_CHARSET = 853;
    public static final short ZHS32GB18030_CHARSET = 854;
    public static final short ZHT32EUC_CHARSET = 860;
    public static final short ZHT32SOPS_CHARSET = 861;
    public static final short ZHT16DBT_CHARSET = 862;
    public static final short ZHT32TRIS_CHARSET = 863;
    public static final short ZHT16DBCS_CHARSET = 864;
    public static final short ZHT16BIG5_CHARSET = 865;
    public static final short ZHT16CCDC_CHARSET = 866;
    public static final short ZHT16MSWIN950_CHARSET = 867;
    public static final short AL24UTFFSS_CHARSET = 870;
    public static final short UTF8_CHARSET = 871;
    public static final short UTFE_CHARSET = 872;
    public static final short AL32UTF8_CHARSET = 873;
    public static final short KO16TSTSET_CHARSET = 996;
    public static final short JA16TSTSET2_CHARSET = 997;
    public static final short JA16TSTSET_CHARSET = 998;
    public static final short US16TSTFIXED_CHARSET = 1001;
    public static final short AL16UTF16_CHARSET = 2000;
    public static final short AL16UTF16LE_CHARSET = 2002;
    public static final short TH8TISEBCDICS_CHARSET = 319;
    public static final short BLT8EBCDIC1112S_CHARSET = 314;
    public static final short CE8BS2000_CHARSET = 233;
    public static final short CL8EBCDIC1025R_CHARSET = 323;
    public static final short CL8EBCDIC1158R_CHARSET = 326;
    public static final short D8EBCDIC1141_CHARSET = 189;
    public static final short DK8EBCDIC1142_CHARSET = 198;
    public static final short EE8BS2000_CHARSET = 232;
    public static final short EE8EBCDIC870S_CHARSET = 316;
    public static final short EL8EBCDIC423R_CHARSET = 327;
    public static final short EL8EBCDIC875S_CHARSET = 311;
    public static final short EL8EBCDIC875R_CHARSET = 324;
    public static final short F8EBCDIC1147_CHARSET = 208;
    public static final short I8EBCDIC1144_CHARSET = 200;
    public static final short WE8BS2000E_CHARSET = 230;
    public static final short WE8EBCDIC1047E_CHARSET = 100;
    public static final short WE8EBCDIC1140_CHARSET = 7;
    public static final short WE8EBCDIC1145_CHARSET = 98;
    public static final short WE8EBCDIC1146_CHARSET = 9;
    public static final short WE8EBCDIC1148_CHARSET = 27;
    public static final short AR8EBCDIC420S_CHARSET = 320;
    public static final short IW8EBCDIC424S_CHARSET = 315;
    public static final short TR8EBCDIC1026S_CHARSET = 312;
    public static final short ZHT16HKSCS_CHARSET = 868;
    public static final short BLT8ISO8859P13_CHARSET = 47;
    public static final short WE8ISO8859P15_CHARSET = 46;
    public static final short AR8MSWIN1256_CHARSET = 560;
    public static final short S8EBCDIC1143_CHARSET = 199;
    public static final short ZHT16HKSCS31_CHARSET = 992;
    public static final short AZ8ISO8859P9E_CHARSET = 52;
    public static final short CEL8ISO8859P14_CHARSET = 48;
    public static final short CL8ISOIR111_CHARSET = 49;
    public static final short CL8KOI8U_CHARSET = 51;
    public static final short WE8PC858_CHARSET = 28;
    public static final short CL8EBCDIC1025C_CHARSET = 322;
    public static final short CL8EBCDIC1025S_CHARSET = 317;
    public static final short CL8EBCDIC1158_CHARSET = 325;
    public static final short EE8EBCDIC870C_CHARSET = 301;
    public static final short WE8EBCDIC924_CHARSET = 101;
    public static final short WE8EBCDIC1140C_CHARSET = 97;
    public static final short WE8EBCDIC1148C_CHARSET = 99;
    public static final short UNICODE_2_CHARSET = 871;
    private static CharacterSet asciiCharSet = null;
    static CharacterSetFactory factory;
    private int oracleId;
    int rep;
    private static final String _Copyright_2007_Oracle_All_Rights_Reserved_;
    public static final String BUILD_DATE = "Thu_Apr_04_15:09:24_PDT_2013";
    public static final boolean TRACE = false;

    CharacterSet(int var1) {
        this.oracleId = var1;
    }

    public static CharacterSet make(int var0) {
        return factory.make(var0);
    }

    public String toString() {
        if (ReadWriteCharacterSetNamesMap.cache == null) {
            this.buildCharacterSetNames();
        }

        return (String)ReadWriteCharacterSetNamesMap.cache.get(new Short((short)this.oracleId));
    }

    synchronized void buildCharacterSetNames() {
        if (ReadWriteCharacterSetNamesMap.cache == null) {
            Class var1 = CharacterSet.class;
            Field[] var2 = var1.getFields();
            HashMap var3 = new HashMap();

            for(int var4 = 0; var4 < var2.length; ++var4) {
                try {
                    String var5 = var2[var4].getName();
                    int var6 = var5.lastIndexOf("_CHARSET");
                    if (var6 != -1) {
                        var5 = var5.substring(0, var6);
                        if (!var5.equals("ASCII") && !var5.equals("ISO_LATIN_1") && !var5.equals("AR8MSAWIN") && !var5.equals("UNICODE_1") && !var5.equals("UNICODE_2")) {
                            short var7 = var2[var4].getShort(CharacterSet.class);
                            int var8 = var2[var4].getModifiers();
                            if (Modifier.isStatic(var8) && Modifier.isFinal(var8)) {
                                String var9 = (String)var3.get(new Short(var7));
                                if (var9 != null) {
                                    throw new RuntimeException("duplicate field name: " + var5 + " for id: " + var7);
                                }

                                var3.put(new Short(var7), var5);
                            }
                        }
                    }
                } catch (Exception var10) {
                    throw new RuntimeException("Failed for field: " + var2[var4], var10);
                }
            }

            ReadWriteCharacterSetNamesMap.cache = var3;
        }

    }

    public abstract boolean isLossyFrom(CharacterSet var1);

    public abstract boolean isConvertibleFrom(CharacterSet var1);

    public boolean isUnicode() {
        return false;
    }

    boolean isWellFormed(byte[] var1, int var2, int var3) {
        return true;
    }

    public int getOracleId() {
        return this.oracleId;
    }

    int getRep() {
        return this.rep;
    }

    public int getRatioTo(CharacterSet var1) {
        throw new Error("oracle.sql.CharacterSet.getRationTo Not Implemented");
    }

    public boolean equals(Object var1) {
        return var1 == this || var1 instanceof CharacterSet && this.oracleId == ((CharacterSet)var1).oracleId;
    }

    public int hashCode() {
        return this.oracleId;
    }

    public abstract String toStringWithReplacement(byte[] var1, int var2, int var3);

    public String toString(byte[] var1, int var2, int var3) throws SQLException {
        String var4 = this.toStringWithReplacement(var1, var2, var3);
        byte[] var5 = this.convert(var4);
        if (var3 != var5.length) {
            failCharacterConversion(this);
        }

        for(int var6 = 0; var6 < var3; ++var6) {
            if (var5[var6] != var1[var2 + var6]) {
                failCharacterConversion(this);
            }
        }

        return null;
    }

    public abstract byte[] convert(String var1) throws SQLException;

    public abstract byte[] convertWithReplacement(String var1);

    public abstract byte[] convert(CharacterSet var1, byte[] var2, int var3, int var4) throws SQLException;

    public byte[] convertUnshared(CharacterSet var1, byte[] var2, int var3, int var4) throws SQLException {
        byte[] var5 = this.convert(var1, var2, var3, var4);
        if (var5 == var2) {
            var5 = new byte[var2.length];
            System.arraycopy(var2, 0, var5, 0, var4);
        }

        return var5;
    }

    abstract int decode(CharacterWalker var1) throws SQLException;

    abstract void encode(CharacterBuffer var1, int var2) throws SQLException;

    static final void failCharacterConversion(CharacterSet var0) throws SQLException {
        SQLException var1 = DatabaseError.createSqlException((OracleConnection)null, 55, var0);
        var1.fillInStackTrace();
        throw var1;
    }

    static final byte[] useOrCopy(byte[] var0, int var1, int var2) {
        byte[] var3;
        if (var0.length == var2 && var1 == 0) {
            var3 = var0;
        } else {
            var3 = new byte[var2];
            System.arraycopy(var0, var1, var3, 0, var2);
        }

        return var3;
    }

    static final void need(CharacterBuffer var0, int var1) {
        int var2 = var0.bytes.length;
        int var3 = var1 + var0.next;
        if (var3 > var2) {
            while(var3 > var2) {
                var2 = 2 * var2;
            }

            byte[] var4 = var0.bytes;
            var0.bytes = new byte[var2];
            System.arraycopy(var4, 0, var0.bytes, 0, var0.next);
        }
    }

    public static final String UTFToString(byte[] var0, int var1, int var2, boolean var3) throws SQLException {
        return new String(UTFToJavaChar(var0, var1, var2, var3));
    }

    public static final String UTFToString(byte[] var0, int var1, int var2) throws SQLException {
        return UTFToString(var0, var1, var2, false);
    }

    public static final char[] UTFToJavaChar(byte[] var0, int var1, int var2) throws SQLException {
        return UTFToJavaChar(var0, var1, var2, false);
    }

    public static final char[] UTFToJavaChar(byte[] var0, int var1, int var2, boolean var3) throws SQLException {
        Object var4 = null;
        char[] var8 = new char[var2];
        int[] var5 = new int[]{var2};
        int var6 = convertUTFBytesToJavaChars(var0, var1, var8, 0, var5, var3);
        char[] var7 = new char[var6];
        System.arraycopy(var8, 0, var7, 0, var6);
        var4 = null;
        return var7;
    }

    public static final char[] UTFToJavaCharWithReplacement(byte[] var0, int var1, int var2) {
        Object var3 = null;

        try {
            char[] var8 = new char[var2];
            int[] var4 = new int[]{var2};
            int var5 = convertUTFBytesToJavaChars(var0, var1, var8, 0, var4, true);
            char[] var6 = new char[var5];
            System.arraycopy(var8, 0, var6, 0, var5);
            var3 = null;
            return var6;
        } catch (SQLException var7) {
            throw new IllegalStateException(var7.getMessage());
        }
    }

    public static final int convertUTFBytesToJavaChars(byte[] var0, int var1, char[] var2, int var3, int[] var4, boolean var5) throws SQLException {
        return convertUTFBytesToJavaChars(var0, var1, var2, var3, var4, var5, var2.length - var3);
    }

    public static final int convertUTFBytesToJavaChars(byte[] var0, int var1, char[] var2, int var3, int[] var4, boolean var5, int var6) throws SQLException {
        CharacterSet.CharacterConverterBehavior var7 = var5 ? CharacterSet.CharacterConverterBehavior.REPLACEMENT : CharacterSet.CharacterConverterBehavior.REPORT_ERROR;
        int var8 = var4[0];
        var4[0] = 0;
        int var9 = var1;
        int var10 = var1 + var8;
        int var11 = var3;
        int var12 = var3 + var6;

        int var14;
        label117:
        while(var9 < var10) {
            byte var13 = var0[var9++];
            var14 = var13 & 240;
            byte var15;
            if (var13 >= 0) {
                if (var11 < var12) {
                    var2[var11++] = (char)(var13 & -1);
                    if (var10 > var0.length || var12 > var2.length || var9 >= var10 || var11 >= var12 || var9 < 0 || var11 < 0) {
                        continue;
                    }

                    while(true) {
                        if (var9 >= var10 || var11 >= var12) {
                            continue label117;
                        }

                        var15 = var0[var9];
                        if (var15 < 0) {
                            continue label117;
                        }

                        var2[var11] = (char)(var15 & -1);
                        ++var11;
                        ++var9;
                    }
                }

                var4[0] = var10 - var9 + 2;
                break;
            } else {
                var15 = (byte)(var13 << 2);
                char var16;
                if (var15 >= 0) {
                    if (var9 >= var10) {
                        var4[0] = 1;
                        var7.onFailConversion();
                        break;
                    }

                    var16 = conv2ByteUTFtoUTF16(var13, var0[var9++]);
                    if (var11 >= var12) {
                        var4[0] = var10 - var9 + 3;
                        break;
                    }

                    var2[var11++] = var16;
                    var7.onFailConversion(var16);
                } else {
                    var15 = (byte)(var15 << 1);
                    if (var15 >= 0) {
                        if (var9 + 1 >= var10) {
                            var4[0] = var10 - var9 + 1;
                            var7.onFailConversion();
                            break;
                        }

                        char var17 = conv3ByteUTFtoUTF16(var13, var0[var9++], var0[var9++]);
                        if (var14 != 244 && var0[var9 - 2] != -65 && var0[var9 - 1] != -67) {
                            var7.onFailConversion(var17);
                        }

                        if (isHiSurrogate(var17)) {
                            if (var11 > var12 - 2) {
                                var4[0] = var10 - var9 + 4;
                                break;
                            }

                            if (var9 < var10) {
                                var13 = var0[var9];
                                if ((byte)(var13 & 240) != -32) {
                                    var2[var11++] = '�';
                                    var7.onFailConversion();
                                } else {
                                    ++var9;
                                    if (var9 + 1 >= var10) {
                                        var4[0] = var10 - var9 + 1;
                                        var7.onFailConversion();
                                        break;
                                    }

                                    var16 = conv3ByteUTFtoUTF16(var13, var0[var9++], var0[var9++]);
                                    if (isLoSurrogate(var16)) {
                                        var2[var11++] = var17;
                                    } else {
                                        var2[var11++] = '�';
                                        var7.onFailConversion();
                                    }

                                    var2[var11++] = var16;
                                }
                            }
                        } else {
                            if (var11 >= var12) {
                                var4[0] = var10 - var9 + 4;
                                break;
                            }

                            var2[var11++] = var17;
                        }
                    } else {
                        if (var11 >= var12) {
                            var4[0] = var10 - var9 + 2;
                            break;
                        }

                        var2[var11++] = '�';
                        var7.onFailConversion();
                    }
                }
            }
        }

        var14 = var11 - var3;
        return var14;
    }

    public static final byte[] stringToUTF(String var0) {
        char[] var1 = var0.toCharArray();
        int var2 = var1.length * 3;
        Object var3 = null;
        Object var4 = null;
        byte[] var6 = new byte[var2];
        int var5 = convertJavaCharsToUTFBytes(var1, 0, var6, 0, var1.length);
        byte[] var7 = new byte[var5];
        System.arraycopy(var6, 0, var7, 0, var5);
        var3 = null;
        return var7;
    }

    public static final int convertJavaCharsToUTFBytes(char[] var0, int var1, byte[] var2, int var3, int var4) {
        int var6 = var1 + var4;
        int var7 = var3;

        for(int var9 = var1; var9 < var6; ++var9) {
            char var8 = var0[var9];
            if (var8 >= 0 && var8 <= 127) {
                var2[var7++] = (byte)var8;
            } else if (var8 > 2047) {
                var2[var7++] = (byte)(224 | var8 >>> 12 & 15);
                var2[var7++] = (byte)(128 | var8 >>> 6 & 63);
                var2[var7++] = (byte)(128 | var8 >>> 0 & 63);
            } else {
                var2[var7++] = (byte)(192 | var8 >>> 6 & 31);
                var2[var7++] = (byte)(128 | var8 >>> 0 & 63);
            }
        }

        int var10 = var7 - var3;
        return var10;
    }

    private static final int UTFStringLength(byte[] var0, int var1, int var2) {
        int var3 = 0;
        int var4 = var1;
        int var5 = var1 + var2;

        while(var4 < var5) {
            byte var6 = var0[var4];
            if (var6 >= 0) {
                ++var4;
                ++var3;
            } else {
                var6 = (byte)(var6 << 2);
                if (var6 >= 0) {
                    if (var4 + 1 >= var5) {
                        var4 = var5;
                    } else {
                        ++var3;
                        var4 += 2;
                    }
                } else {
                    var6 = (byte)(var6 << 1);
                    if (var6 >= 0) {
                        if (var4 + 2 >= var5) {
                            var4 = var5;
                        } else {
                            ++var3;
                            var4 += 3;
                        }
                    } else {
                        var6 = (byte)(var6 << 1);
                        if (var6 >= 0) {
                            if (var4 + 3 >= var5) {
                                var4 = var5;
                            } else {
                                var3 += 2;
                                var4 += 4;
                            }
                        } else {
                            ++var4;
                            ++var3;
                        }
                    }
                }
            }
        }

        return var3;
    }

    public static final int stringUTFLength(String var0) {
        char[] var1 = var0.toCharArray();
        return charArrayUTF8Length(var1);
    }

    static final int charArrayUTF8Length(char[] var0) {
        int var1 = 0;
        int var2 = var0.length;

        for(int var4 = 0; var4 < var2; ++var4) {
            char var3 = var0[var4];
            if (var3 >= 0 && var3 <= 127) {
                ++var1;
            } else if (var3 > 2047) {
                var1 += 3;
            } else {
                var1 += 2;
            }
        }

        return var1;
    }

    public static final String AL32UTF8ToString(byte[] var0, int var1, int var2) {
        return AL32UTF8ToString(var0, var1, var2, false);
    }

    public static final String AL32UTF8ToString(byte[] var0, int var1, int var2, boolean var3) {
        char[] var4 = null;

        try {
            var4 = AL32UTF8ToJavaChar(var0, var1, var2, var3);
        } catch (SQLException var6) {
        }

        return new String(var4);
    }

    public static final char[] AL32UTF8ToJavaChar(byte[] var0, int var1, int var2, boolean var3) throws SQLException {
        Object var4 = null;

        try {
            char[] var9 = new char[var2];
            int[] var5 = new int[]{var2};
            int var6 = convertAL32UTF8BytesToJavaChars(var0, var1, var9, 0, var5, var3);
            char[] var7 = new char[var6];
            System.arraycopy(var9, 0, var7, 0, var6);
            var4 = null;
            return var7;
        } catch (SQLException var8) {
            failUTFConversion();
            return new char[0];
        }
    }

    public static final int convertAL32UTF8BytesToJavaChars(byte[] var0, int var1, char[] var2, int var3, int[] var4, boolean var5) throws SQLException {
        return convertAL32UTF8BytesToJavaChars(var0, var1, var2, var3, var4, var5, var2.length - var3);
    }

    public static final int convertAL32UTF8BytesToJavaChars(byte[] var0, int var1, char[] var2, int var3, int[] var4, boolean var5, int var6) throws SQLException {
        CharacterSet.CharacterConverterBehavior var7 = var5 ? CharacterSet.CharacterConverterBehavior.REPLACEMENT : CharacterSet.CharacterConverterBehavior.REPORT_ERROR;
        int var8 = var4[0];
        var4[0] = 0;
        int var9 = var1;
        int var10 = var1 + var8;
        int var11 = var3;
        int var12 = var3 + var6;

        int var15;
        label101:
        while(var9 < var10) {
            byte var14 = var0[var9++];
            byte var16;
            if (var14 >= 0) {
                if (var11 < var12) {
                    var2[var11++] = (char)(var14 & -1);
                    if (var10 > var0.length || var12 > var2.length || var9 >= var10 || var11 >= var12 || var9 < 0 || var11 < 0) {
                        continue;
                    }

                    while(true) {
                        if (var9 >= var10 || var11 >= var12) {
                            continue label101;
                        }

                        var16 = var0[var9];
                        if (var16 < 0) {
                            continue label101;
                        }

                        var2[var11] = (char)(var16 & -1);
                        ++var11;
                        ++var9;
                    }
                }

                var4[0] = var10 - var9 + 2;
                break;
            } else {
                var16 = (byte)(var14 << 2);
                char var13;
                if (var16 >= 0) {
                    if (var9 >= var10) {
                        var4[0] = 1;
                        var7.onFailConversion();
                        break;
                    }

                    var13 = conv2ByteUTFtoUTF16(var14, var0[var9++]);
                    if (var11 >= var12) {
                        var4[0] = var10 - var9 + 3;
                        break;
                    }

                    var2[var11++] = var13;
                    var7.onFailConversion(var13);
                } else {
                    var16 = (byte)(var16 << 1);
                    if (var16 >= 0) {
                        if (var9 + 1 >= var10) {
                            var4[0] = var10 - var9 + 1;
                            var7.onFailConversion();
                            break;
                        }

                        var13 = conv3ByteAL32UTF8toUTF16(var14, var0[var9++], var0[var9++]);
                        if (var11 >= var12) {
                            var4[0] = var10 - var9 + 4;
                            break;
                        }

                        var2[var11++] = var13;
                        var7.onFailConversion(var13);
                    } else {
                        var16 = (byte)(var16 << 1);
                        if (var16 >= 0) {
                            if (var9 + 2 >= var10) {
                                var4[0] = var10 - var9 + 1;
                                var7.onFailConversion();
                                break;
                            }

                            if (var11 > var12 - 2) {
                                var4[0] = var10 - var9 + 2;
                                break;
                            }

                            var15 = conv4ByteAL32UTF8toUTF16(var14, var0[var9++], var0[var9++], var0[var9++], var2, var11);
                            if (var15 == 1) {
                                var7.onFailConversion();
                                ++var11;
                            } else {
                                var11 += 2;
                            }
                        } else {
                            if (var11 >= var12) {
                                var4[0] = var10 - var9 + 2;
                                break;
                            }

                            var2[var11++] = '�';
                            var7.onFailConversion();
                        }
                    }
                }
            }
        }

        var15 = var11 - var3;
        return var15;
    }

    public static final byte[] stringToAL32UTF8(String var0) {
        char[] var1 = var0.toCharArray();
        int var2 = var1.length * 3;
        Object var3 = null;
        Object var4 = null;
        byte[] var6 = new byte[var2];
        int var5 = convertJavaCharsToAL32UTF8Bytes(var1, 0, var6, 0, var1.length);
        byte[] var7 = new byte[var5];
        System.arraycopy(var6, 0, var7, 0, var5);
        var3 = null;
        return var7;
    }

    public static final int convertJavaCharsToAL32UTF8Bytes(char[] var0, int var1, byte[] var2, int var3, int var4) {
        int var6 = var1 + var4;
        int var7 = var3;

        int var11;
        for(int var8 = var1; var8 < var6; ++var8) {
            char var9 = var0[var8];
            boolean var10 = false;
            if (var9 >= 0 && var9 <= 127) {
                var2[var7++] = (byte)var9;
            } else if (isHiSurrogate((char)var9)) {
                char var12;
                if (var8 + 1 < var6 && isLoSurrogate((char)(var12 = var0[var8 + 1]))) {
                    var11 = (var9 >>> 6 & 15) + 1;
                    var2[var7++] = (byte)(var11 >>> 2 | 240);
                    var2[var7++] = (byte)((var11 & 3) << 4 | var9 >>> 2 & 15 | 128);
                    var2[var7++] = (byte)((var9 & 3) << 4 | var12 >>> 6 & 15 | 128);
                    var2[var7++] = (byte)(var12 & 63 | 128);
                    ++var8;
                } else {
                    var2[var7++] = -17;
                    var2[var7++] = -65;
                    var2[var7++] = -67;
                }
            } else if (var9 > 2047) {
                var2[var7++] = (byte)(224 | var9 >>> 12 & 15);
                var2[var7++] = (byte)(128 | var9 >>> 6 & 63);
                var2[var7++] = (byte)(128 | var9 >>> 0 & 63);
            } else {
                var2[var7++] = (byte)(192 | var9 >>> 6 & 31);
                var2[var7++] = (byte)(128 | var9 >>> 0 & 63);
            }
        }

        var11 = var7 - var3;
        return var11;
    }

    public static final int string32UTF8Length(String var0) {
        return charArray32UTF8Length(var0.toCharArray());
    }

    static final int charArray32UTF8Length(char[] var0) {
        int var1 = 0;
        int var2 = var0.length;

        for(int var3 = 0; var3 < var2; ++var3) {
            char var4 = var0[var3];
            if (var4 >= 0 && var4 <= 127) {
                ++var1;
            } else if (var4 > 2047) {
                if (isHiSurrogate((char)var4)) {
                    if (var3 + 1 < var2) {
                        var1 += 4;
                        ++var3;
                    }
                } else {
                    var1 += 3;
                }
            } else {
                var1 += 2;
            }
        }

        return var1;
    }

    public static final String AL16UTF16BytesToString(byte[] var0, int var1) {
        char[] var2 = new char[var1 >>> 1];
        AL16UTF16BytesToJavaChars(var0, var1, var2);
        return new String(var2);
    }

    public static final int AL16UTF16BytesToJavaChars(byte[] var0, int var1, char[] var2) {
        int var5 = var1 >>> 1;
        int var3 = 0;

        for(int var4 = 0; var3 < var5; ++var3) {
            int var6 = var0[var4] << 8;
            var2[var3] = (char)(var6 | var0[var4 + 1] & 255);
            var4 += 2;
        }

        return var3;
    }

    public static final int convertAL16UTF16BytesToJavaChars(byte[] var0, int var1, char[] var2, int var3, int var4, boolean var5) throws SQLException {
        CharacterSet.CharacterConverterBehavior var6 = var5 ? CharacterSet.CharacterConverterBehavior.REPLACEMENT : CharacterSet.CharacterConverterBehavior.REPORT_ERROR;
        int var7 = var3;
        int var8 = var1;

        for(int var9 = var1 + var4; var8 + 1 < var9; var8 += 2) {
            int var12 = var0[var8] << 8;
            char var10 = (char)(var12 | var0[var8 + 1] & 255);
            var2[var7++] = var10;
        }

        var8 = var7 - var3;
        return var8;
    }

    public static final int convertAL16UTF16LEBytesToJavaChars(byte[] var0, int var1, char[] var2, int var3, int var4, boolean var5) throws SQLException {
        CharacterSet.CharacterConverterBehavior var6 = var5 ? CharacterSet.CharacterConverterBehavior.REPLACEMENT : CharacterSet.CharacterConverterBehavior.REPORT_ERROR;
        int var7 = var3;
        int var8 = var1;

        for(int var9 = var1 + var4; var8 + 1 < var9; var8 += 2) {
            int var12 = var0[var8 + 1] << 8;
            char var10 = (char)(var12 | var0[var8] & 255);
            if (isHiSurrogate(var10)) {
                var8 += 2;
                if (var8 + 1 < var9) {
                    char var11 = (char)((var0[var8 + 1] << 8) + (var0[var8] & 255));
                    if (isLoSurrogate(var11)) {
                        var2[var7++] = var10;
                    } else {
                        var2[var7++] = '�';
                    }

                    var2[var7++] = var11;
                }
            } else {
                var2[var7++] = var10;
            }
        }

        var8 = var7 - var3;
        return var8;
    }

    public static final byte[] stringToAL16UTF16Bytes(String var0) {
        char[] var1 = var0.toCharArray();
        int var2 = var1.length;
        byte[] var3 = new byte[var2 * 2];
        javaCharsToAL16UTF16Bytes(var1, var2, var3);
        return var3;
    }

    public static final int javaCharsToAL16UTF16Bytes(char[] var0, int var1, byte[] var2) {
        int var3 = Math.min(var1, var2.length >>> 1);
        return convertJavaCharsToAL16UTF16Bytes(var0, 0, var2, 0, var3);
    }

    public static final int convertJavaCharsToAL16UTF16Bytes(char[] var0, int var1, byte[] var2, int var3, int var4) {
        int var5 = var1;
        int var6 = var3;

        for(int var7 = var1 + var4; var5 < var7; var6 += 2) {
            var2[var6] = (byte)(var0[var5] >>> 8 & 255);
            var2[var6 + 1] = (byte)(var0[var5] & 255);
            ++var5;
        }

        return var6 - var3;
    }

    public static final byte[] stringToAL16UTF16LEBytes(String var0) {
        char[] var1 = var0.toCharArray();
        byte[] var2 = new byte[var1.length * 2];
        javaCharsToAL16UTF16LEBytes(var1, var1.length, var2);
        return var2;
    }

    public static final int javaCharsToAL16UTF16LEBytes(char[] var0, int var1, byte[] var2) {
        return convertJavaCharsToAL16UTF16LEBytes(var0, 0, var2, 0, var1);
    }

    public static final int convertJavaCharsToAL16UTF16LEBytes(char[] var0, int var1, byte[] var2, int var3, int var4) {
        int var5 = var1;
        int var6 = var3;

        for(int var7 = var1 + var4; var5 < var7; var6 += 2) {
            var2[var6] = (byte)(var0[var5] & 255);
            var2[var6 + 1] = (byte)(var0[var5] >>> 8);
            ++var5;
        }

        return var6 - var3;
    }

    public static final int convertASCIIBytesToJavaChars(byte[] var0, int var1, char[] var2, int var3, int var4) throws SQLException {
        int var7 = var3 + var4;
        int var5 = var3;

        for(int var6 = var1; var5 < var7; ++var6) {
            var2[var5] = (char)(255 & var0[var6]);
            ++var5;
        }

        return var4;
    }

    public static final int convertJavaCharsToASCIIBytes(char[] var0, int var1, byte[] var2, int var3, int var4) throws SQLException {
        convertJavaCharsToASCIIBytes(var0, var1, var2, var3, var4, false);
        return var4;
    }

    public static final int convertJavaCharsToASCIIBytes(char[] var0, int var1, byte[] var2, int var3, int var4, boolean var5) throws SQLException {
        if (var5) {
            if (asciiCharSet == null) {
                asciiCharSet = make(1);
            }

            byte[] var7 = asciiCharSet.convertWithReplacement(new String(var0, var1, var4));
            System.arraycopy(var7, 0, var2, var3, var7.length);
            return var7.length;
        } else {
            for(int var6 = 0; var6 < var4; ++var6) {
                var2[var3 + var6] = (byte)var0[var1 + var6];
            }

            return var4;
        }
    }

    public static final int convertJavaCharsToISOLATIN1Bytes(char[] var0, int var1, byte[] var2, int var3, int var4) throws SQLException {
        for(int var5 = 0; var5 < var4; ++var5) {
            char var6 = var0[var1 + var5];
            if (var6 > 255) {
                var2[var3 + var5] = -65;
            } else {
                var2[var3 + var5] = (byte)var6;
            }
        }

        return var4;
    }

    public static final byte[] stringToASCII(String var0) {
        byte[] var1 = new byte[var0.length()];
        var1 = var0.getBytes();
        return var1;
    }

    public static final long convertUTF32toUTF16(long var0) {
        if (var0 > 65535L) {
            long var2 = 216L | var0 - 65536L >> 18 & 255L;
            var2 = var0 - 65536L >> 10 & 255L | var2 << 8;
            var2 = 220L | (var0 & 1023L) >> 8 & 255L | var2 << 8;
            var2 = var0 & 255L | var2 << 8;
            return var2;
        } else {
            return var0;
        }
    }

    static final boolean isHiSurrogate(char var0) {
        return (char)(var0 & 'ﰀ') == '\ud800';
    }

    static final boolean isLoSurrogate(char var0) {
        return (char)(var0 & 'ﰀ') == '\udc00';
    }

    static final boolean check80toBF(byte var0) {
        return (var0 & -64) == -128;
    }

    static final boolean check80to8F(byte var0) {
        return (var0 & -16) == -128;
    }

    static final boolean check80to9F(byte var0) {
        return (var0 & -32) == -128;
    }

    static final boolean checkA0toBF(byte var0) {
        return (var0 & -32) == -96;
    }

    static final boolean check90toBF(byte var0) {
        return (var0 & -64) == -128 && (var0 & 48) != 0;
    }

    static final char conv2ByteUTFtoUTF16(byte var0, byte var1) {
        return var0 >= -62 && var0 <= -33 && check80toBF(var1) ? (char)((var0 & 31) << 6 | var1 & 63) : '�';
    }

    static final char conv3ByteUTFtoUTF16(byte var0, byte var1, byte var2) {
        return var0 == -32 && checkA0toBF(var1) && check80toBF(var2) || var0 >= -31 && var0 <= -17 && check80toBF(var1) && check80toBF(var2) ? (char)((var0 & 15) << 12 | (var1 & 63) << 6 | var2 & 63) : '�';
    }

    static final char conv3ByteAL32UTF8toUTF16(byte var0, byte var1, byte var2) {
        return (var0 != -32 || !checkA0toBF(var1) || !check80toBF(var2)) && (var0 < -31 || var0 > -20 || !check80toBF(var1) || !check80toBF(var2)) && (var0 != -19 || !check80to9F(var1) || !check80toBF(var2)) && (var0 < -18 || var0 > -17 || !check80toBF(var1) || !check80toBF(var2)) ? '�' : (char)((var0 & 15) << 12 | (var1 & 63) << 6 | var2 & 63);
    }

    static final int conv4ByteAL32UTF8toUTF16(byte var0, byte var1, byte var2, byte var3, char[] var4, int var5) {
        boolean var6 = false;
        if (var0 == -16 && check90toBF(var1) && check80toBF(var2) && check80toBF(var3) || var0 >= -15 && var0 <= -13 && check80toBF(var1) && check80toBF(var2) && check80toBF(var3) || var0 == -12 && check80to8F(var1) && check80toBF(var2) && check80toBF(var3)) {
            var4[var5] = (char)((((var0 & 7) << 2 | var1 >>> 4 & 3) - 1 & 15) << 6 | (var1 & 15) << 2 | var2 >>> 4 & 3 | '\ud800');
            var4[var5 + 1] = (char)((var2 & 15) << 6 | var3 & 63 | '\udc00');
            return 2;
        } else {
            var4[var5] = '�';
            return 1;
        }
    }

    static void failUTFConversion() throws SQLException {
        SQLException var0 = DatabaseError.createSqlException((OracleConnection)null, 55);
        var0.fillInStackTrace();
        throw var0;
    }

    public int encodedByteLength(String var1) {
        return var1 != null && var1.length() != 0 ? this.convertWithReplacement(var1).length : 0;
    }

    public int encodedByteLength(char[] var1) {
        return var1 != null && var1.length != 0 ? this.convertWithReplacement(new String(var1)).length : 0;
    }

    public int toCharWithReplacement(byte[] var1, int var2, char[] var3, int var4, int var5) throws SQLException {
        SQLException var6 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 23);
        var6.fillInStackTrace();
        throw var6;
    }

    protected OracleConnection getConnectionDuringExceptionHandling() {
        return null;
    }

    public boolean isUnknown() {
        return false;
    }

    static {
        try {
            Class.forName("oracle.i18n.text.converter.CharacterConverterSJIS");
            CharacterSetWithConverter.ccFactory = new CharacterConverterFactoryOGS();
        } catch (ClassNotFoundException var1) {
        }

        factory = new CharacterSetFactoryDefault();
        _Copyright_2007_Oracle_All_Rights_Reserved_ = null;
    }

    abstract static class CharacterConverterBehavior {
        public static final char[] NULL_CHARS = new char[1];
        public static final char UTF16_REPLACEMENT_CHAR = '�';
        public static final CharacterSet.CharacterConverterBehavior REPORT_ERROR = new CharacterSet.CharacterConverterBehavior("Report Error") {
            public void onFailConversion() throws SQLException {
                SQLException var1 = DatabaseError.createSqlException((OracleConnection)null, 55);
                var1.fillInStackTrace();
                throw var1;
            }

            public void onFailConversion(char var1) throws SQLException {
                if (var1 == '�') {
                    SQLException var2 = DatabaseError.createSqlException((OracleConnection)null, 55);
                    var2.fillInStackTrace();
                    throw var2;
                }
            }
        };
        public static final CharacterSet.CharacterConverterBehavior REPLACEMENT = new CharacterSet.CharacterConverterBehavior("Replacement") {
            public void onFailConversion() throws SQLException {
            }

            public void onFailConversion(char var1) throws SQLException {
            }
        };
        private final String m_name;

        public CharacterConverterBehavior(String var1) {
            this.m_name = var1;
        }

        public abstract void onFailConversion(char var1) throws SQLException;

        public abstract void onFailConversion() throws SQLException;
    }
}
