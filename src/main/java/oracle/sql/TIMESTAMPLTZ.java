//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package oracle.sql;

import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.TimeZone;
import oracle.jdbc.OracleConnection;

public class TIMESTAMPLTZ extends Datum {
    private static int SIZE_TIMESTAMPLTZ = 11;
    private static int SIZE_TIMESTAMPLTZ_NOFRAC = 7;
    private static int SIZE_DATE = 7;
    private static int HOUR_MILLISECOND = 3600000;
    private static int MINUTE_MILLISECOND = 60000;
    private static int JAVA_YEAR = 1970;
    private static int JAVA_MONTH = 0;
    private static int JAVA_DATE = 1;
    private static int MINYEAR = -4712;
    private static int MAXYEAR = 9999;
    private static boolean cached = false;
    private static Calendar dbtz;
    static final long serialVersionUID = 2045880772054757133L;
    private static final String _Copyright_2007_Oracle_All_Rights_Reserved_ = null;
    public static final String BUILD_DATE = "Thu_Apr_04_15:09:24_PDT_2013";
    public static final boolean TRACE = false;

    public TIMESTAMPLTZ() {
        super(initTimestampltz());
    }

    public TIMESTAMPLTZ(byte[] var1) {
        super(var1);
    }

    /** @deprecated */
    public TIMESTAMPLTZ(Connection var1, Time var2, Calendar var3) throws SQLException {
        super(toBytes(var1, var2, var3));
    }

    /** @deprecated */
    public TIMESTAMPLTZ(Connection var1, Date var2, Calendar var3) throws SQLException {
        super(toBytes(var1, var2, var3));
    }

    /** @deprecated */
    public TIMESTAMPLTZ(Connection var1, Timestamp var2, Calendar var3) throws SQLException {
        super(toBytes(var1, var2, var3));
    }

    /** @deprecated */
    public TIMESTAMPLTZ(Connection var1, DATE var2, Calendar var3) throws SQLException {
        super(toBytes(var1, var2, var3));
    }

    /** @deprecated */
    public TIMESTAMPLTZ(Connection var1, String var2, Calendar var3) throws SQLException {
        super(toBytes(var1, var2, var3));
    }

    public TIMESTAMPLTZ(Connection var1, Calendar var2, Time var3) throws SQLException {
        super(toBytes(var1, var2, var3));
    }

    public TIMESTAMPLTZ(Connection var1, Calendar var2, Date var3) throws SQLException {
        super(toBytes(var1, var2, var3));
    }

    public TIMESTAMPLTZ(Connection var1, Calendar var2, Timestamp var3) throws SQLException {
        super(toBytes(var1, var2, var3));
    }

    public TIMESTAMPLTZ(Connection var1, Calendar var2, DATE var3) throws SQLException {
        super(toBytes(var1, var2, var3));
    }

    /** @deprecated */
    public TIMESTAMPLTZ(Connection var1, Calendar var2, String var3) throws SQLException {
        super(toBytes(var1, var2, var3));
    }

    public TIMESTAMPLTZ(Connection var1, Time var2) throws SQLException {
        super(toBytes(var1, getSessCalendar(var1), var2));
    }

    public TIMESTAMPLTZ(Connection var1, Date var2) throws SQLException {
        super(toBytes(var1, getSessCalendar(var1), var2));
    }

    public TIMESTAMPLTZ(Connection var1, Timestamp var2) throws SQLException {
        super(toBytes(var1, getSessCalendar(var1), var2));
    }

    public TIMESTAMPLTZ(Connection var1, DATE var2) throws SQLException {
        super(toBytes(var1, getSessCalendar(var1), var2));
    }

    /** @deprecated */
    public TIMESTAMPLTZ(Connection var1, String var2) throws SQLException {
        super(toBytes(var1, getSessCalendar(var1), Timestamp.valueOf(var2)));
    }

    public static Date toDate(Connection var0, byte[] var1, Calendar var2) throws SQLException {
        Calendar var3 = toCalendar(var0, Calendar.getInstance(), var1, var2);
        long var4 = var3.getTime().getTime();
        return new Date(var4);
    }

    public static Time toTime(Connection var0, byte[] var1, Calendar var2) throws SQLException {
        Calendar var3 = toCalendar(var0, Calendar.getInstance(), var1, var2);
        return new Time(var3.get(11), var3.get(12), var3.get(13));
    }

    public static Timestamp toTimestamp(Connection var0, byte[] var1, Calendar var2) throws SQLException {
        return toTimestamp(var0, Calendar.getInstance(), var1, var2);
    }

    public static DATE toDATE(Connection var0, byte[] var1, Calendar var2) throws SQLException {
        return new DATE(toTimestamp(var0, getSessCalendar(var0), var1, (Calendar)null));
    }

    public Timestamp timestampValue(Connection var1, Calendar var2) throws SQLException {
        return toTimestamp(var1, this.getBytes(), var2);
    }

    public Timestamp timestampValue(Connection var1) throws SQLException {
        return toTimestamp(var1, this.getBytes());
    }

    /** @deprecated */
    public static String toString(Connection var0, byte[] var1, Calendar var2) throws SQLException {
        Calendar var3 = toCalendar(var0, (Calendar)null, var1, var2);
        int var4 = var3.get(1);
        if (var3.get(0) == 0) {
            var4 = -(var4 - 1);
        }

        int var5 = var3.get(2) + 1;
        int var6 = var3.get(5);
        int var7 = var3.get(11);
        int var8 = var3.get(12);
        int var9 = var3.get(13);
        int var10 = -1;
        if (var1.length == SIZE_TIMESTAMPLTZ) {
            var10 = TIMESTAMP.getNanos(var1, 7);
        }

        return TIMESTAMPTZ.toString(var4, var5, var6, var7, var8, var9, var10, var3.getTimeZone().getID());
    }

    public byte[] toBytes() {
        return this.getBytes();
    }

    /** @deprecated */
    public static byte[] toBytes(Connection var0, Time var1, Calendar var2) throws SQLException {
        if (var1 == null) {
            return null;
        } else {
            Calendar var3 = Calendar.getInstance();
            var3.setTime(var1);
            short var4;
            if (((OracleConnection)var0).physicalConnectionWithin().getUse1900AsYearForTime()) {
                var4 = 1900;
            } else {
                var4 = 1970;
            }

            var3.set(1, var4);
            var3.set(2, 0);
            var3.set(5, 1);
            byte[] var5 = toBytes(var0, var3, var2, 0);
            return var5;
        }
    }

    /** @deprecated */
    public static byte[] toBytes(Connection var0, Date var1, Calendar var2) throws SQLException {
        if (var1 == null) {
            return null;
        } else {
            Calendar var3 = Calendar.getInstance();
            var3.setTime(var1);
            byte[] var4 = toBytes(var0, var3, var2, 0);
            return var4;
        }
    }

    /** @deprecated */
    public static byte[] toBytes(Connection var0, Timestamp var1, Calendar var2) throws SQLException {
        if (var1 == null) {
            return null;
        } else {
            Calendar var3 = Calendar.getInstance();
            var3.setTime(var1);
            int var4 = var1.getNanos();
            byte[] var5 = toBytes(var0, var3, var2, var4);
            return var5;
        }
    }

    /** @deprecated */
    public static byte[] toBytes(Connection var0, DATE var1, Calendar var2) throws SQLException {
        if (var1 == null) {
            return null;
        } else {
            Calendar var3 = Calendar.getInstance();
            var3.setTime(DATE.toDate(var1.toBytes()));
            byte[] var4 = toBytes(var0, var3, var2, 0);
            return var4;
        }
    }

    public static byte[] toBytes(Connection var0, String var1, Calendar var2) throws SQLException {
        return toBytes(var0, Timestamp.valueOf(var1), var2);
    }

    public static Date toDate(Connection var0, byte[] var1) throws SQLException {
        Calendar var2 = toCalendar(var0, (Calendar)null, var1, (Calendar)null);
        long var3 = var2.getTime().getTime();
        return new Date(var3);
    }

    public static Time toTime(Connection var0, byte[] var1) throws SQLException {
        Calendar var2 = toCalendar(var0, (Calendar)null, var1, (Calendar)null);
        return new Time(var2.get(11), var2.get(12), var2.get(13));
    }

    public static Timestamp toTimestamp(Connection var0, byte[] var1) throws SQLException {
        return toTimestamp(var0, (Calendar)null, var1, (Calendar)null);
    }

    public static DATE toDATE(Connection var0, byte[] var1) throws SQLException {
        Calendar var2 = toCalendar(var0, (Calendar)null, var1, (Calendar)null);
        long var3 = var2.getTime().getTime();
        return new DATE(new Timestamp(var3));
    }

    public static TIMESTAMP toTIMESTAMP(Connection var0, byte[] var1) throws SQLException {
        return new TIMESTAMP(toTimestamp(var0, getSessCalendar(var0), var1, (Calendar)null));
    }

    public static TIMESTAMPTZ toTIMESTAMPTZ(Connection var0, byte[] var1) throws SQLException {
        return new TIMESTAMPTZ(var0, toTimestamp(var0, getSessCalendar(var0), var1, (Calendar)null), getSessCalendar(var0));
    }

    public static String toString(Connection var0, byte[] var1) throws SQLException {
        return toString(var0, var1, (Calendar)null);
    }

    public static byte[] toBytes(Connection var0, Calendar var1, Time var2) throws SQLException {
        if (var2 == null) {
            return null;
        } else {
            Calendar var3;
            if (var1 == null) {
                var3 = getSessCalendar(var0);
            } else {
                var3 = (Calendar)((Calendar)var1.clone());
            }

            var3.setTime(var2);
            short var4;
            if (((OracleConnection)var0).physicalConnectionWithin().getUse1900AsYearForTime()) {
                var4 = 1900;
            } else {
                var4 = 1970;
            }

            var3.set(1, var4);
            var3.set(2, 0);
            var3.set(5, 1);
            initDbTimeZone(var0);
            Calendar var5 = (Calendar)dbtz.clone();
            byte[] var6 = toBytes(var0, var3, var5, 0);
            return var6;
        }
    }

    public static byte[] toBytes(Connection var0, Calendar var1, Date var2) throws SQLException {
        if (var2 == null) {
            return null;
        } else {
            Calendar var3;
            if (var1 == null) {
                var3 = getSessCalendar(var0);
            } else {
                var3 = (Calendar)((Calendar)var1.clone());
            }

            var3.setTime(var2);
            initDbTimeZone(var0);
            Calendar var4 = (Calendar)dbtz.clone();
            byte[] var5 = toBytes(var0, var3, var4, 0);
            return var5;
        }
    }

    public static byte[] toBytes(Connection var0, Calendar var1, Timestamp var2) throws SQLException {
        if (var2 == null) {
            return null;
        } else {
            Calendar var3;
            if (var1 == null) {
                var3 = getSessCalendar(var0);
            } else {
                var3 = (Calendar)((Calendar)var1.clone());
            }

            var3.setTime(var2);
            int var4 = var2.getNanos();
            initDbTimeZone(var0);
            Calendar var5 = (Calendar)dbtz.clone();
            byte[] var6 = toBytes(var0, var3, var5, var4);
            return var6;
        }
    }

    public static byte[] toBytes(Connection var0, Calendar var1, DATE var2) throws SQLException {
        if (var2 == null) {
            return null;
        } else {
            Calendar var3;
            if (var1 == null) {
                var3 = getSessCalendar(var0);
            } else {
                var3 = (Calendar)((Calendar)var1.clone());
            }

            var3.setTime(DATE.toDate(var2.toBytes()));
            initDbTimeZone(var0);
            Calendar var4 = (Calendar)dbtz.clone();
            byte[] var5 = toBytes(var0, var3, var4, 0);
            return var5;
        }
    }

    public static byte[] toBytes(Connection var0, Calendar var1, String var2) throws SQLException {
        return toBytes(var0, var1, Timestamp.valueOf(var2));
    }

    public String stringValue(Connection var1) throws SQLException {
        return toString(var1, this.getBytes());
    }

    public String stringValue(Connection var1, Calendar var2) throws SQLException {
        return toString(var1, this.getBytes(), var2);
    }

    public Date dateValue(Connection var1, Calendar var2) throws SQLException {
        return toDate(var1, this.getBytes(), var2);
    }

    public Date dateValue(Connection var1) throws SQLException {
        return toDate(var1, this.getBytes());
    }

    public Time timeValue(Connection var1) throws SQLException {
        return toTime(var1, this.getBytes());
    }

    public Time timeValue(Connection var1, Calendar var2) throws SQLException {
        return toTime(var1, this.getBytes(), var2);
    }

    public Object toJdbc() throws SQLException {
        return null;
    }

    public Object makeJdbcArray(int var1) {
        Timestamp[] var2 = new Timestamp[var1];
        return var2;
    }

    public boolean isConvertibleTo(Class var1) {
        return var1.getName().compareTo("java.sql.Date") == 0 || var1.getName().compareTo("java.sql.Time") == 0 || var1.getName().compareTo("java.sql.Timestamp") == 0 || var1.getName().compareTo("java.lang.String") == 0;
    }

    private static byte[] initTimestampltz() {
        byte[] var0 = new byte[SIZE_TIMESTAMPLTZ];
        var0[0] = 119;
        var0[1] = -86;
        var0[2] = 1;
        var0[3] = 1;
        var0[4] = 1;
        var0[5] = 1;
        var0[6] = 1;
        return var0;
    }

    private static byte[] toBytes(Connection var0, Calendar var1, Calendar var2, int var3) throws SQLException {
        byte[] var4;
        if (var3 == 0) {
            var4 = new byte[SIZE_TIMESTAMPLTZ_NOFRAC];
        } else {
            var4 = new byte[SIZE_TIMESTAMPLTZ];
        }

        TimeZoneAdjust(var0, var1, var2);
        int var5 = TIMESTAMP.getOracleYear(var2);
        var4[0] = (byte)(var5 / 100 + 100);
        var4[1] = (byte)(var5 % 100 + 100);
        var4[2] = (byte)(var2.get(2) + 1);
        var4[3] = (byte)var2.get(5);
        var4[4] = (byte)(var2.get(11) + 1);
        var4[5] = (byte)(var2.get(12) + 1);
        var4[6] = (byte)(var2.get(13) + 1);
        if (var3 != 0) {
            var4[7] = (byte)(var3 >> 24);
            var4[8] = (byte)(var3 >> 16 & 255);
            var4[9] = (byte)(var3 >> 8 & 255);
            var4[10] = (byte)(var3 & 255);
        }

        return var4;
    }

    private static Timestamp toTimestamp(Connection var0, Calendar var1, byte[] var2, Calendar var3) throws SQLException {
        Calendar var4 = toCalendar(var0, var1, var2, var3);
        long var5 = var4.getTime().getTime();
        Timestamp var7 = new Timestamp(var5);
        int var8 = 0;
        if (var2.length == SIZE_TIMESTAMPLTZ) {
            var8 = TIMESTAMP.getNanos(var2, 7);
        }

        var7.setNanos(var8);
        return var7;
    }

    private static final Calendar toCalendar(Connection var0, Calendar var1, byte[] var2, Calendar var3) throws SQLException {
        int var5 = var2.length;
        int[] var4;
        if (var5 == SIZE_TIMESTAMPLTZ) {
            var4 = new int[SIZE_TIMESTAMPLTZ];
        } else {
            var4 = new int[SIZE_TIMESTAMPLTZ_NOFRAC];
        }

        int var6;
        for(var6 = 0; var6 < var2.length; ++var6) {
            var4[var6] = var2[var6] & 255;
        }

        var6 = TIMESTAMP.getJavaYear(var4[0], var4[1]);
        if (var3 == null) {
            initDbTimeZone(var0);
            var3 = (Calendar)dbtz.clone();
        }

        var3.set(1, var6);
        var3.set(2, var4[2] - 1);
        var3.set(5, var4[3]);
        var3.set(11, var4[4] - 1);
        var3.set(12, var4[5] - 1);
        var3.set(13, var4[6] - 1);
        var3.set(14, 0);
        Calendar var7;
        if (var1 == null) {
            var7 = getSessCalendar(var0);
        } else {
            var7 = (Calendar)((Calendar)var1.clone());
        }

        TimeZoneAdjust(var0, var3, var7);
        return var7;
    }

    static void TimeZoneAdjust(Connection var0, Calendar var1, Calendar var2) throws SQLException {
        TimeZone var8 = var1.getTimeZone();
        String var9 = new String(var1.getTimeZone().getID());
        String var10 = new String(var2.getTimeZone().getID());
        int var13;
        int var14;
        if (!var10.equals(var9) && (!var10.equals("Custom") || !var9.equals("Custom"))) {
            OffsetDST var11 = new OffsetDST();
            getZoneOffset(var0, var1, var11);
            var13 = var11.getOFFSET();
            long var4 = (long)var8.getOffset(var1.getTimeInMillis());
            var1.add(11, -(var13 / HOUR_MILLISECOND));
            var1.add(12, -(var13 % HOUR_MILLISECOND) / MINUTE_MILLISECOND);
            long var6 = (long)var8.getOffset(var1.getTimeInMillis());
            var1.add(14, (int)(var4 - var6));
            int var3;
            if (var10.equals("Custom")) {
                var3 = var2.getTimeZone().getRawOffset();
            } else {
                var14 = ZONEIDMAP.getID(var10);
                if (!ZONEIDMAP.isValidID(var14)) {
                    if (var2.getTimeZone().useDaylightTime()) {
                        throw new SQLException("Timezone not supported");
                    }

                    var3 = var2.getTimeZone().getRawOffset();
                } else {
                    TIMEZONETAB var15 = getTIMEZONETAB(var0);
                    if (var15.checkID(var14)) {
                        var15.updateTable(var0, var14);
                    }

                    var3 = var15.getOffset(var1, var14);
                }
            }

            var4 = (long)var8.getOffset(var1.getTimeInMillis());
            var1.add(11, var3 / HOUR_MILLISECOND);
            var1.add(12, var3 % HOUR_MILLISECOND / MINUTE_MILLISECOND);
            var6 = (long)var8.getOffset(var1.getTimeInMillis());
            var1.add(14, (int)(var4 - var6));
        }

        int var12;
        int var18;
        if (var10.equals("Custom") && var9.equals("Custom")) {
            var18 = var1.getTimeZone().getRawOffset();
            var12 = var2.getTimeZone().getRawOffset();
            var13 = 0;
            if (var18 != var12) {
                var13 = var18 - var12;
                var13 = var13 > 0 ? var13 : -var13;
            }

            if (var18 > var12) {
                var13 = -var13;
            }

            var1.add(11, var13 / HOUR_MILLISECOND);
            var1.add(12, var13 % HOUR_MILLISECOND / MINUTE_MILLISECOND);
        }

        var18 = var1.get(1);
        var12 = var1.get(2);
        var13 = var1.get(5);
        var14 = var1.get(11);
        int var19 = var1.get(12);
        int var16 = var1.get(13);
        int var17 = var1.get(14);
        var2.set(1, var18);
        var2.set(0, var1.get(0));
        var2.set(2, var12);
        var2.set(5, var13);
        var2.set(11, var14);
        var2.set(12, var19);
        var2.set(13, var16);
        var2.set(14, var17);
    }

    private static byte getZoneOffset(Connection var0, Calendar var1, OffsetDST var2) throws SQLException {
        byte var3 = 0;
        if (var1.getTimeZone().getID() == "Custom") {
            var2.setOFFSET(var1.getTimeZone().getRawOffset());
        } else {
            String var4 = new String(var1.getTimeZone().getID());
            int var5 = ZONEIDMAP.getID(var4);
            if (!ZONEIDMAP.isValidID(var5)) {
                if (var1.getTimeZone().useDaylightTime()) {
                    throw new SQLException("Timezone not supported");
                }

                var2.setOFFSET(var1.getTimeZone().getRawOffset());
            } else {
                TIMEZONETAB var6 = getTIMEZONETAB(var0);
                if (var6.checkID(var5)) {
                    var6.updateTable(var0, var5);
                }

                var3 = var6.getLocalOffset(var1, var5, var2);
            }
        }

        return var3;
    }

    private static Calendar getDbTzCalendar(String var0) {
        char var2 = var0.charAt(0);
        String var1;
        if (var2 != '+' && var2 != '-') {
            var1 = var0;
        } else {
            var1 = "GMT" + var0;
        }

        TimeZone var3 = TimeZone.getTimeZone(var1);
        return new GregorianCalendar(var3);
    }

    static Calendar getSessCalendar(Connection var0) {
        String var1 = ((OracleConnection)var0).getSessionTimeZone();
        Calendar var2;
        if (var1 == null) {
            var2 = Calendar.getInstance();
        } else {
            TimeZone var3 = TimeZone.getTimeZone(var1);
            var2 = Calendar.getInstance(var3);
        }

        return var2;
    }

    private static synchronized void initDbTimeZone(Connection var0) throws SQLException {
        if (!cached) {
            oracle.jdbc.internal.OracleConnection var1 = ((OracleConnection)var0).physicalConnectionWithin();
            String var2 = var1.getDatabaseTimeZone();
            dbtz = getDbTzCalendar(var2);
            cached = true;
        }

    }

    static TIMEZONETAB getTIMEZONETAB(Connection var0) throws SQLException {
        oracle.jdbc.internal.OracleConnection var1 = ((OracleConnection)var0).physicalConnectionWithin();
        return var1.getTIMEZONETAB();
    }
}
