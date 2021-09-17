//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package oracle.sql;

import java.sql.Date;
import java.sql.SQLException;
import java.sql.Time;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class DATE extends Datum {
    static final long serialVersionUID = 5229717576495161269L;
    public static final int BDA = 1;
    public static final int BDAL = 2;
    public static final int BMO = 4;
    public static final int BMOL = 8;
    public static final int BYR = 16;
    public static final int BYRL = 32;
    public static final int BHR = 64;
    public static final int BHRL = 128;
    public static final int BMN = 256;
    public static final int BMNL = 512;
    public static final int BSC = 1024;
    public static final int BSCL = 2048;
    public static final int MSD = 4096;
    public static final int YR0 = 8192;
    public static final int BDT = 32768;
    public static final int HRZER0 = 65536;
    public static final int MIZERO = 131072;
    public static final int SEZERO = 262144;
    private static final byte LDXTCE = 0;
    private static final byte LDXTYE = 1;
    private static final byte LDXTMO = 2;
    private static final byte LDXTDA = 3;
    private static final byte LDXTHO = 4;
    private static final byte LDXTMI = 5;
    private static final byte LDXTSE = 6;
    private static LdxLib _sldxlib;
    private static final String _Copyright_2007_Oracle_All_Rights_Reserved_ = null;
    public static final String BUILD_DATE = "Thu_Apr_04_15:09:24_PDT_2013";
    public static final boolean TRACE = false;

    public DATE() {
        super(_initDate());
    }

    public DATE(byte[] var1) {
        super(var1);
    }

    public DATE(Date var1) {
        super(toBytes(var1));
    }

    public DATE(Time var1) {
        super(toBytes(var1));
    }

    public DATE(Timestamp var1) {
        super(toBytes(var1));
    }

    public DATE(Date var1, Calendar var2) {
        super(toBytes(var1, var2));
    }

    public DATE(Time var1, Calendar var2) {
        super(toBytes(var1, var2));
    }

    public DATE(Timestamp var1, Calendar var2) {
        super(toBytes(var1, var2));
    }

    public DATE(String var1) {
        super(toBytes(var1));
    }

    public DATE(String var1, boolean var2) throws ParseException {
        super(toBytes(var1));
        if (!var2) {
            SimpleDateFormat var3 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            var3.setLenient(false);
            var3.parse(var1);
        }

    }

    public DATE(String var1, Calendar var2) {
        super(toBytes(var1, var2));
    }

    public DATE(Object var1) throws SQLException {
        if (var1 instanceof Date) {
            this.setShareBytes(toBytes((Date)var1));
        } else if (var1 instanceof Time) {
            this.setShareBytes(toBytes((Time)var1));
        } else if (var1 instanceof Timestamp) {
            this.setShareBytes(toBytes((Timestamp)var1));
        } else {
            if (!(var1 instanceof String)) {
                throw new SQLException("Initialization failed");
            }

            this.setShareBytes(toBytes((String)var1));
        }

    }

    public DATE(Object var1, Calendar var2) throws SQLException {
        if (var1 instanceof Date) {
            this.setShareBytes(toBytes((Date)var1, var2));
        } else if (var1 instanceof Time) {
            this.setShareBytes(toBytes((Time)var1, var2));
        } else if (var1 instanceof Timestamp) {
            this.setShareBytes(toBytes((Timestamp)var1, var2));
        } else {
            if (!(var1 instanceof String)) {
                throw new SQLException("Initialization failed");
            }

            this.setShareBytes(toBytes((String)var1, var2));
        }

    }

    public static Date toDate(byte[] var0) {
        return toDate(var0, (Calendar)null);
    }

    public static Time toTime(byte[] var0) {
        return toTime(var0, (Calendar)null);
    }

    public static Timestamp toTimestamp(byte[] var0) {
        return toTimestamp(var0, (Calendar)null);
    }

    public static Date toDate(byte[] var0, Calendar var1) {
        int[] var2 = new int[7];

        int var3;
        for(var3 = 0; var3 < 7; ++var3) {
            var2[var3] = var0[var3] & 255;
        }

        var3 = TIMESTAMP.getJavaYear(var2[0], var2[1]);
        Calendar var4;
        if (var1 == null) {
            var4 = Calendar.getInstance();
        } else {
            var4 = Calendar.getInstance(var1.getTimeZone());
        }

        var4.clear();
        var4.set(1, var3);
        var4.set(2, var2[2] - 1);
        var4.set(5, var2[3]);
        var4.set(11, var2[4] - 1);
        var4.set(12, var2[5] - 1);
        var4.set(13, var2[6] - 1);
        var4.set(14, 0);
        Date var5 = new Date(var4.getTime().getTime());
        return var5;
    }

    public static Time toTime(byte[] var0, Calendar var1) {
        int[] var2 = new int[7];

        for(int var3 = 0; var3 < 7; ++var3) {
            var2[var3] = var0[var3] & 255;
        }

        Calendar var5;
        if (var1 == null) {
            var5 = Calendar.getInstance();
        } else {
            var5 = Calendar.getInstance(var1.getTimeZone());
        }

        var5.clear();
        var5.set(1, 1970);
        var5.set(2, 0);
        var5.set(5, 1);
        var5.set(11, var2[4] - 1);
        var5.set(12, var2[5] - 1);
        var5.set(13, var2[6] - 1);
        var5.set(14, 0);
        Time var4 = new Time(var5.getTime().getTime());
        return var4;
    }

    public static Timestamp toTimestamp(byte[] var0, Calendar var1) {
        int[] var2 = new int[7];

        int var3;
        for(var3 = 0; var3 < 7; ++var3) {
            var2[var3] = var0[var3] & 255;
        }

        var3 = TIMESTAMP.getJavaYear(var2[0], var2[1]);
        Calendar var4;
        if (var1 == null) {
            var4 = Calendar.getInstance();
        } else {
            var4 = Calendar.getInstance(var1.getTimeZone());
        }

        var4.clear();
        var4.set(1, var3);
        var4.set(2, var2[2] - 1);
        var4.set(5, var2[3]);
        var4.set(11, var2[4] - 1);
        var4.set(12, var2[5] - 1);
        var4.set(13, var2[6] - 1);
        var4.set(14, 0);
        Timestamp var5 = new Timestamp(var4.getTime().getTime());
        return var5;
    }

    public static String toString(byte[] var0) {
        if (var0 != null && var0.length != 0) {
            int[] var1 = new int[7];

            int var2;
            for(var2 = 0; var2 < 7; ++var2) {
                if (var0[var2] < 0) {
                    var1[var2] = var0[var2] + 256;
                } else {
                    var1[var2] = var0[var2];
                }
            }

            var2 = TIMESTAMP.getJavaYear(var1[0], var1[1]);
            int var3 = var1[2];
            int var4 = var1[3];
            int var5 = var1[4] - 1;
            int var6 = var1[5] - 1;
            int var7 = var1[6] - 1;
            boolean var8 = true;
            String var9 = TIMESTAMPTZ.toString(var2, var3, var4, var5, var6, var7, -1, (String)null);
            return var9;
        } else {
            return new String();
        }
    }

    public byte[] toBytes() {
        return this.getBytes();
    }

    public static byte[] toBytes(Date var0) {
        return toBytes((Date)var0, (Calendar)null);
    }

    public static byte[] toBytes(Time var0) {
        return toBytes((Time)var0, (Calendar)null);
    }

    public static byte[] toBytes(Timestamp var0) {
        return toBytes((Timestamp)var0, (Calendar)null);
    }

    public static byte[] toBytes(Date var0, Calendar var1) {
        if (var0 == null) {
            return null;
        } else {
            Calendar var2;
            if (var1 == null) {
                var2 = Calendar.getInstance();
            } else {
                var2 = Calendar.getInstance(var1.getTimeZone());
            }

            var2.clear();
            var2.setTime(var0);
            byte[] var3 = new byte[7];
            int var4 = TIMESTAMP.getOracleYear(var2);
            var3[0] = (byte)(var4 / 100 + 100);
            var3[1] = (byte)(var4 % 100 + 100);
            var3[2] = (byte)(var2.get(2) + 1);
            var3[3] = (byte)var2.get(5);
            var3[4] = (byte)(var2.get(11) + 1);
            var3[5] = (byte)(var2.get(12) + 1);
            var3[6] = (byte)(var2.get(13) + 1);
            return var3;
        }
    }

    public static byte[] toBytes(Time var0, Calendar var1) {
        if (var0 == null) {
            return null;
        } else {
            Calendar var2;
            if (var1 == null) {
                var2 = Calendar.getInstance();
            } else {
                var2 = Calendar.getInstance(var1.getTimeZone());
            }

            var2.clear();
            var2.setTime(var0);
            byte[] var3 = new byte[]{119, -86, 1, 1, (byte)(var2.get(11) + 1), (byte)(var2.get(12) + 1), (byte)(var2.get(13) + 1)};
            return var3;
        }
    }

    public static byte[] toBytes(Timestamp var0, Calendar var1) {
        if (var0 == null) {
            return null;
        } else {
            Calendar var2;
            if (var1 == null) {
                var2 = Calendar.getInstance();
            } else {
                var2 = Calendar.getInstance(var1.getTimeZone());
            }

            var2.clear();
            var2.setTime(var0);
            byte[] var3 = new byte[7];
            int var4 = TIMESTAMP.getOracleYear(var2);
            var3[0] = (byte)(var4 / 100 + 100);
            var3[1] = (byte)(var4 % 100 + 100);
            var3[2] = (byte)(var2.get(2) + 1);
            var3[3] = (byte)var2.get(5);
            var3[4] = (byte)(var2.get(11) + 1);
            var3[5] = (byte)(var2.get(12) + 1);
            var3[6] = (byte)(var2.get(13) + 1);
            return var3;
        }
    }

    public static byte[] toBytes(String var0) {
        if (var0 == null) {
            return null;
        } else {
            byte[] var1 = toBytes(Timestamp.valueOf(var0));
            return var1;
        }
    }

    public static byte[] toBytes(String var0, Calendar var1) {
        return toBytes(Timestamp.valueOf(var0), var1);
    }

    public Date dateValue() {
        return toDate(this.getBytes());
    }

    public Time timeValue() {
        return toTime(this.getBytes());
    }

    public Timestamp timestampValue() {
        return toTimestamp(this.getBytes());
    }

    public Date dateValue(Calendar var1) {
        return toDate(this.getBytes(), var1);
    }

    public Time timeValue(Calendar var1) {
        return toTime(this.getBytes(), var1);
    }

    public Timestamp timestampValue(Calendar var1) {
        return toTimestamp(this.getBytes(), var1);
    }

    public String stringValue() {
        return toString(this.getBytes());
    }

    public String toString() {
        return this.stringValue();
    }

    public Object toJdbc() {
        return this.timestampValue();
    }

    public Object makeJdbcArray(int var1) {
        Timestamp[] var2 = new Timestamp[var1];
        return var2;
    }

    public boolean isConvertibleTo(Class var1) {
        return var1.getName().compareTo("java.sql.Date") == 0 || var1.getName().compareTo("java.sql.Time") == 0 || var1.getName().compareTo("java.sql.Timestamp") == 0 || var1.getName().compareTo("java.lang.String") == 0;
    }

    public DATE addJulianDays(int var1, int var2) throws SQLException {
        return new DATE(_getLdxLib().ldxads(this.shareBytes(), var1, var2));
    }

    public DATE addMonths(int var1) throws SQLException {
        return new DATE(_getLdxLib().ldxadm(this.shareBytes(), var1));
    }

    public void diffInJulianDays(DATE var1, int[] var2, int[] var3) throws SQLException {
        _getLdxLib().ldxsub(this.shareBytes(), var1.shareBytes(), var2, var3);
    }

    public NUMBER diffInMonths(DATE var1) throws SQLException {
        return new NUMBER(_getLdxLib().ldxsbm(this.shareBytes(), var1.shareBytes()));
    }

    public static DATE getCurrentDate() throws SQLException {
        return new DATE(_getLdxLib().ldxgdt());
    }

    public static int checkValidity(byte[] var0) throws SQLException {
        return _getLdxLib().ldxchk(var0);
    }

    public static DATE fromJulianDays(int var0, int var1) throws SQLException {
        return new DATE(_getLdxLib().ldxdfd(var0, var1));
    }

    public static DATE fromText(String var0, String var1, String var2) throws SQLException {
        return new DATE(_getLdxLib().ldxstd(var0, var1, var2));
    }

    public DATE lastDayOfMonth() throws SQLException {
        return new DATE(_getLdxLib().ldxldd(this.shareBytes()));
    }

    public static void numberToJulianDays(NUMBER var0, int[] var1, int[] var2) throws SQLException {
        _getLdxLib().ldxftd(var0.toBytes(), var1, var2);
    }

    public DATE round(String var1) throws SQLException {
        return new DATE(_getLdxLib().ldxrnd(this.shareBytes(), var1));
    }

    public DATE setDayOfWeek(int var1) throws SQLException {
        return new DATE(_getLdxLib().ldxnxd(this.shareBytes(), var1));
    }

    public void toJulianDays(int[] var1, int[] var2) throws SQLException {
        _getLdxLib().ldxdtd(this.shareBytes(), var1, var2);
    }

    public NUMBER toNumber() throws SQLException {
        return new NUMBER(_getLdxLib().ldxdyf(this.shareBytes()));
    }

    public String toText(String var1, String var2) throws SQLException {
        return _getLdxLib().ldxdts(this.shareBytes(), var1, var2);
    }

    public String toText(byte[] var1, String var2) throws SQLException {
        return _getLdxLib().ldxdts(this.shareBytes(), var1, var2);
    }

    public static byte[] parseFormat(String var0, String var1) throws SQLException {
        return (byte[])_getLdxLib().ldxsto(var0, var1);
    }

    public DATE truncate(String var1) throws SQLException {
        return new DATE(_getLdxLib().ldxtrn(this.shareBytes(), var1));
    }

    public int compareTo(DATE var1) {
        return compareBytes(this.shareBytes(), var1.shareBytes());
    }

    private static byte[] _initDate() {
        byte[] var0 = new byte[]{119, -86, 1, 1, 1, 1, 1};
        return var0;
    }

    private static LdxLib _getLdxLib() {
        if (_sldxlib == null) {
            try {
                if (System.getProperty("oracle.jserver.version") != null) {
                    _sldxlib = new LdxLibServer();
                } else {
                    _sldxlib = new LdxLibThin();
                }
            } catch (SecurityException var1) {
                _sldxlib = new LdxLibThin();
            }
        }

        return _sldxlib;
    }

    private static void _printBytes(byte[] var0) {
        System.out.println(toString(var0));
    }
}
