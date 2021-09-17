//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package oracle.sql;

import java.sql.SQLException;

abstract class CharacterSetFactory {
    public static final short DEFAULT_CHARSET = -1;
    public static final short ASCII_CHARSET = 1;
    public static final short ISO_LATIN_1_CHARSET = 31;
    public static final short UNICODE_1_CHARSET = 870;
    public static final short UNICODE_2_CHARSET = 871;
    private static final String _Copyright_2007_Oracle_All_Rights_Reserved_ = null;
    public static final String BUILD_DATE = "Thu_Apr_04_15:09:24_PDT_2013";
    public static final boolean TRACE = false;

    CharacterSetFactory() {
    }

    public abstract CharacterSet make(int var1);

    public static void main(String[] var0) {
        CharacterSet var1 = CharacterSet.make(871);
        int[] var2 = new int[]{1, 31, 870, 871};

        for(int var3 = 0; var3 < var2.length; ++var3) {
            CharacterSet var4 = CharacterSet.make(var2[var3]);
            String var5 = "longlonglonglong";
            var5 = var5 + var5 + var5 + var5;
            var5 = var5 + var5 + var5 + var5;
            var5 = var5 + var5 + var5 + var5;
            var5 = var5 + var5 + var5 + var5;
            String[] var6 = new String[]{"abc", "ab?c", "XYZ", var5};

            for(int var7 = 0; var7 < var6.length; ++var7) {
                String var8 = var6[var7];
                String var9 = var8;
                if (var8.length() > 16) {
                    var9 = var8.substring(0, 16) + "...";
                }

                System.out.println("testing " + var4 + " against <" + var9 + ">");
                boolean var10 = true;

                try {
                    byte[] var11 = var4.convertWithReplacement(var8);
                    String var12 = var4.toStringWithReplacement(var11, 0, var11.length);
                    var11 = var4.convert(var12);
                    String var13 = var4.toString(var11, 0, var11.length);
                    if (!var12.equals(var13)) {
                        System.out.println("    FAILED roundTrip " + var13);
                        var10 = false;
                    }

                    byte[] var14;
                    if (var4.isLossyFrom(var1)) {
                        try {
                            var14 = var4.convert(var8);
                            String var15 = var4.toString(var14, 0, var14.length);
                            if (!var15.equals(var13)) {
                                System.out.println("    FAILED roundtrip, no throw");
                            }
                        } catch (SQLException var17) {
                        }
                    } else {
                        if (!var13.equals(var8)) {
                            System.out.println("    FAILED roundTrip " + var13);
                            var10 = false;
                        }

                        var14 = var1.convert(var8);
                        byte[] var19 = var4.convert(var1, var14, 0, var14.length);
                        String var16 = var4.toString(var19, 0, var19.length);
                        if (!var16.equals(var8)) {
                            System.out.println("    FAILED withoutReplacement " + var16);
                            var10 = false;
                        }
                    }
                } catch (Exception var18) {
                    System.out.println("    FAILED with Exception " + var18);
                }

                if (var10) {
                    System.out.println("    PASSED " + (var4.isLossyFrom(var1) ? "LOSSY" : ""));
                }
            }
        }

    }
}
