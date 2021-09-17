//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package oracle.sql;

public class INTERVALYM extends Datum {
    private static int MASKVAL = 255;
    private static int INTYMYEAROFFSET = -2147483648;
    private static int INTYMMONTHOFFSET = 60;
    private static int INTERVALYMMAXLENGTH = 5;
    private static int MAXYEARPREC = 9;
    private static int MAXMONTH = 12;
    static final long serialVersionUID = 8393284561907159296L;
    private static final String _Copyright_2007_Oracle_All_Rights_Reserved_ = null;
    public static final String BUILD_DATE = "Thu_Apr_04_15:09:24_PDT_2013";
    public static final boolean TRACE = false;

    public INTERVALYM() {
        super(_initIntervalYM());
    }

    public INTERVALYM(byte[] var1) {
        super(var1);
    }

    public INTERVALYM(String var1) {
        super(toBytes(var1));
    }

    public byte[] toBytes() {
        return this.getBytes();
    }

    public static byte[] toBytes(String var0) {
        if (var0 == null) {
            return null;
        } else {
            byte[] var1 = new byte[INTERVALYMMAXLENGTH];
            String var3 = var0.trim();
            char var4 = var3.charAt(0);
            byte var2;
            if (var4 != '-' && var4 != '+') {
                var2 = 0;
            } else {
                var2 = 1;
            }

            var3 = var3.substring(var2);
            int var5 = var3.indexOf(45);
            String var6 = var3.substring(0, var5);
            if (var6.length() > MAXYEARPREC) {
                throw new NumberFormatException();
            } else {
                int var7 = Integer.valueOf(var6);
                String var8 = var3.substring(var5 + 1);
                int var9 = Integer.valueOf(var8);
                if (var9 >= MAXMONTH) {
                    throw new NumberFormatException();
                } else {
                    if (var4 == '-') {
                        var7 = -1 * var7;
                        var9 = -1 * var9;
                    }

                    var7 += INTYMYEAROFFSET;
                    var1[0] = utilpack.RIGHTSHIFTFIRSTNIBBLE(var7);
                    var1[1] = utilpack.RIGHTSHIFTSECONDNIBBLE(var7);
                    var1[2] = utilpack.RIGHTSHIFTTHIRDNIBBLE(var7);
                    var1[3] = utilpack.RIGHTSHIFTFOURTHNIBBLE(var7);
                    var1[4] = (byte)(var9 + INTYMMONTHOFFSET);
                    return var1;
                }
            }
        }
    }

    public static String toString(byte[] var0) {
        if (var0 != null && var0.length != 0) {
            boolean var2 = true;
            int var3 = utilpack.LEFTSHIFTFIRSTNIBBLE(var0[0]);
            var3 |= utilpack.LEFTSHIFTSECONDNIBBLE(var0[1]);
            var3 |= utilpack.LEFTSHIFTTHIRDNIBBLE(var0[2]);
            var3 |= var0[3] & 255;
            var3 -= INTYMYEAROFFSET;
            int var4 = var0[4] - INTYMMONTHOFFSET;
            if (var3 < 0) {
                var2 = false;
                var3 = -var3;
            }

            if (var4 < 0) {
                var2 = false;
                var4 = -var4;
            }

            String var1 = var3 + "-" + var4;
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

    public Object makeJdbcArray(int var1) {
        INTERVALYM[] var2 = new INTERVALYM[var1];
        return var2;
    }

    public boolean isConvertibleTo(Class var1) {
        return var1.getName().compareTo("java.lang.String") == 0;
    }

    private static byte[] _initIntervalYM() {
        byte[] var0 = new byte[INTERVALYMMAXLENGTH];
        byte var1 = 0;
        byte var2 = 0;
        int var3 = var1 + INTYMYEAROFFSET;
        var0[0] = utilpack.RIGHTSHIFTFIRSTNIBBLE(var3);
        var0[1] = utilpack.RIGHTSHIFTSECONDNIBBLE(var3);
        var0[2] = utilpack.RIGHTSHIFTTHIRDNIBBLE(var3);
        var0[3] = utilpack.RIGHTSHIFTFOURTHNIBBLE(var3);
        var0[4] = (byte)(var2 + INTYMMONTHOFFSET);
        return var0;
    }
}
