//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package oracle.sql;

import java.util.StringTokenizer;

public class INTERVALDS extends Datum {
    private static int MAXLEADPREC = 9;
    private static int MAXHOUR = 23;
    private static int MAXMINUTE = 59;
    private static int MAXSECOND = 59;
    private static int INTERVALDSMAXLENGTH = 11;
    private static int INTERVALDSOFFSET = 60;
    private static int INTERVALDAYOFFSET = -2147483648;
    static final long serialVersionUID = 7164731704878764759L;
    private static final String _Copyright_2007_Oracle_All_Rights_Reserved_ = null;
    public static final String BUILD_DATE = "Thu_Apr_04_15:09:24_PDT_2013";
    public static final boolean TRACE = false;

    public INTERVALDS() {
        super(_initIntervalDS());
    }

    public INTERVALDS(byte[] var1) {
        super(var1);
    }

    public INTERVALDS(String var1) {
        super(toBytes(var1));
    }

    public byte[] toBytes() {
        return this.getBytes();
    }

    public static byte[] toBytes(String var0) {
        if (var0 == null) {
            return null;
        } else {
            boolean var2 = false;
            boolean var3 = false;
            boolean var4 = false;
            boolean var5 = false;
            boolean var6 = false;
            byte[] var7 = new byte[INTERVALDSMAXLENGTH];
            String var12 = null;
            String var13 = var0.trim();
            char var14 = var13.charAt(0);
            byte var1;
            if (var14 != '-' && var14 != '+') {
                var1 = 0;
            } else {
                var1 = 1;
            }

            var13 = var13.substring(var1);
            int var15 = var13.indexOf(32);
            String var8 = var13.substring(0, var15);
            if (var8.length() > MAXLEADPREC) {
                throw new NumberFormatException();
            } else {
                String var16 = var13.substring(var15 + 1);
                StringTokenizer var17 = new StringTokenizer(var16, ":.");
                if (var17.hasMoreTokens()) {
                    String var9;
                    String var10;
                    String var11;
                    try {
                        var9 = var17.nextToken();
                        var10 = var17.nextToken();
                        var11 = var17.nextToken();
                        var12 = var17.nextToken();
                    } catch (Exception var21) {
                        throw new NumberFormatException();
                    }

                    int var22 = Integer.valueOf(var8);
                    int var23 = Integer.valueOf(var9);
                    int var24 = Integer.valueOf(var10);
                    int var25 = Integer.valueOf(var11);
                    if (var23 > MAXHOUR) {
                        throw new NumberFormatException();
                    } else if (var24 > MAXMINUTE) {
                        throw new NumberFormatException();
                    } else if (var25 > MAXSECOND) {
                        throw new NumberFormatException();
                    } else if (var12.length() > MAXLEADPREC) {
                        throw new NumberFormatException();
                    } else {
                        int var26;
                        if (var12.length() < MAXLEADPREC) {
                            char[] var19 = new char[MAXLEADPREC];

                            int var18;
                            for(var18 = 0; var18 < var12.length(); ++var18) {
                                var19[var18] = var12.charAt(var18);
                            }

                            for(int var20 = var18; var20 < MAXLEADPREC; ++var20) {
                                var19[var20] = '0';
                            }

                            String var27 = new String(var19);
                            var26 = Integer.valueOf(var27);
                        } else {
                            var26 = Integer.valueOf(var12);
                        }

                        if (var14 == '-') {
                            var22 = -var22;
                            var23 = -var23;
                            var24 = -var24;
                            var25 = -var25;
                            var26 = -var26;
                        }

                        var22 += INTERVALDAYOFFSET;
                        var7[0] = utilpack.RIGHTSHIFTFIRSTNIBBLE(var22);
                        var7[1] = utilpack.RIGHTSHIFTSECONDNIBBLE(var22);
                        var7[2] = utilpack.RIGHTSHIFTTHIRDNIBBLE(var22);
                        var7[3] = utilpack.RIGHTSHIFTFOURTHNIBBLE(var22);
                        var7[4] = (byte)(var23 + INTERVALDSOFFSET);
                        var7[5] = (byte)(var24 + INTERVALDSOFFSET);
                        var7[6] = (byte)(var25 + INTERVALDSOFFSET);
                        var26 += INTERVALDAYOFFSET;
                        var7[7] = utilpack.RIGHTSHIFTFIRSTNIBBLE(var26);
                        var7[8] = utilpack.RIGHTSHIFTSECONDNIBBLE(var26);
                        var7[9] = utilpack.RIGHTSHIFTTHIRDNIBBLE(var26);
                        var7[10] = utilpack.RIGHTSHIFTFOURTHNIBBLE(var26);
                        return var7;
                    }
                } else {
                    throw new NumberFormatException();
                }
            }
        }
    }

    public static String toString(byte[] var0) {
        if (var0 != null && var0.length != 0) {
            boolean var2 = true;
            boolean var7 = false;
            int var3 = utilpack.LEFTSHIFTFIRSTNIBBLE(var0[0]);
            var3 |= utilpack.LEFTSHIFTSECONDNIBBLE(var0[1]);
            var3 |= utilpack.LEFTSHIFTTHIRDNIBBLE(var0[2]);
            var3 |= var0[3] & 255;
            var3 -= INTERVALDAYOFFSET;
            int var4 = var0[4] - INTERVALDSOFFSET;
            int var5 = var0[5] - INTERVALDSOFFSET;
            int var6 = var0[6] - INTERVALDSOFFSET;
            int var11 = utilpack.LEFTSHIFTFIRSTNIBBLE(var0[7]);
            var11 |= utilpack.LEFTSHIFTSECONDNIBBLE(var0[8]);
            var11 |= utilpack.LEFTSHIFTTHIRDNIBBLE(var0[9]);
            var11 |= var0[10] & 255;
            var11 -= INTERVALDAYOFFSET;
            if (var3 < 0) {
                var2 = false;
                var3 = -var3;
                var4 = -var4;
                var5 = -var5;
                var6 = -var6;
                var11 = -var11;
            } else if (var4 < 0) {
                var2 = false;
                var4 = -var4;
                var5 = -var5;
                var6 = -var6;
                var11 = -var11;
            } else if (var5 < 0) {
                var2 = false;
                var5 = -var5;
                var6 = -var6;
                var11 = -var11;
            } else if (var6 < 0) {
                var2 = false;
                var6 = -var6;
                var11 = -var11;
            } else if (var11 < 0) {
                var2 = false;
                var11 = -var11;
            }

            String var8 = String.format("%09d", var11);
            char[] var9 = var8.toCharArray();

            int var10;
            for(var10 = var9.length; var10 > 1 && var9[var10 - 1] == '0'; --var10) {
            }

            var8 = var8.substring(0, var10);
            String var1 = var3 + " " + var4 + ":" + var5 + ":" + var6 + "." + var8;
            if (!var2) {
                var1 = "-" + var1;
            }

            return var1;
        } else {
            return new String();
        }
    }

    public Object toJdbc() {
        return this;
    }

    public String stringValue() {
        return toString(this.getBytes());
    }

    public String toString() {
        return toString(this.getBytes());
    }

    public boolean isConvertibleTo(Class var1) {
        return var1.getName().compareTo("java.lang.String") == 0;
    }

    public Object makeJdbcArray(int var1) {
        INTERVALDS[] var2 = new INTERVALDS[var1];
        return var2;
    }

    private static byte[] _initIntervalDS() {
        byte[] var0 = new byte[INTERVALDSMAXLENGTH];
        byte var1 = 0;
        byte var2 = 0;
        byte var3 = 0;
        byte var4 = 0;
        byte var5 = 0;
        int var6 = var1 + INTERVALDAYOFFSET;
        var0[0] = utilpack.RIGHTSHIFTFIRSTNIBBLE(var6);
        var0[1] = utilpack.RIGHTSHIFTSECONDNIBBLE(var6);
        var0[2] = utilpack.RIGHTSHIFTTHIRDNIBBLE(var6);
        var0[3] = utilpack.RIGHTSHIFTFOURTHNIBBLE(var6);
        var0[4] = (byte)(var2 + INTERVALDSOFFSET);
        var0[5] = (byte)(var3 + INTERVALDSOFFSET);
        var0[6] = (byte)(var4 + INTERVALDSOFFSET);
        int var7 = var5 + INTERVALDAYOFFSET;
        var0[7] = utilpack.RIGHTSHIFTFIRSTNIBBLE(var7);
        var0[8] = utilpack.RIGHTSHIFTSECONDNIBBLE(var7);
        var0[9] = utilpack.RIGHTSHIFTTHIRDNIBBLE(var7);
        var0[10] = utilpack.RIGHTSHIFTFOURTHNIBBLE(var7);
        return var0;
    }
}
