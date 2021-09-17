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
import java.util.Locale;
import java.util.SimpleTimeZone;
import java.util.TimeZone;
import oracle.jdbc.OracleConnection;
import oracle.jdbc.driver.DatabaseError;

public class TIMESTAMPTZ extends Datum {
    static final long serialVersionUID = 6708361144588335769L;
    static final Calendar CAL_GMT_US;
    static final TimeZone TIMEZONE_UTC;
    private static int HOUR_MILLISECOND;
    private static int MINUTE_MILLISECOND;
    private static int OFFSET_HOUR;
    private static int OFFSET_MINUTE;
    private static byte REGIONIDBIT;
    private static final String _Copyright_2007_Oracle_All_Rights_Reserved_;
    public static final String BUILD_DATE = "Thu_Apr_04_15:09:24_PDT_2013";
    public static final boolean TRACE = false;

    public TIMESTAMPTZ() {
        super(initTimestamptz());
    }

    public TIMESTAMPTZ(byte[] var1) {
        super(var1);
    }

    public TIMESTAMPTZ(Connection var1, Date var2) throws SQLException {
        super(toBytes(var1, var2));
    }

    public TIMESTAMPTZ(Connection var1, Date var2, Calendar var3) throws SQLException {
        super(toBytes(var1, var2, var3));
    }

    public TIMESTAMPTZ(Connection var1, Time var2) throws SQLException {
        super(toBytes(var1, var2));
    }

    public TIMESTAMPTZ(Connection var1, Time var2, Calendar var3) throws SQLException {
        super(toBytes(var1, var2, var3));
    }

    public TIMESTAMPTZ(Connection var1, Timestamp var2) throws SQLException {
        super(toBytes(var1, var2));
    }

    public TIMESTAMPTZ(Connection var1, Timestamp var2, Calendar var3) throws SQLException {
        super(toBytes(var1, var2, var3));
    }

    public TIMESTAMPTZ(Connection var1, DATE var2) throws SQLException {
        super(toBytes(var1, var2));
    }

    public TIMESTAMPTZ(Connection var1, String var2) throws SQLException {
        super(toBytes(var1, var2));
    }

    public TIMESTAMPTZ(Connection var1, String var2, Calendar var3) throws SQLException {
        super(toBytes(var1, var2, var3));
    }

    public static Date toDate(Connection var0, byte[] var1) throws SQLException {
        int[] var2 = new int[13];

        int var4;
        for(var4 = 0; var4 < 13; ++var4) {
            var2[var4] = var1[var4] & 255;
        }

        var4 = TIMESTAMP.getJavaYear(var2[0], var2[1]);
        Calendar var5 = Calendar.getInstance();
        var5.set(1, var4);
        var5.set(2, var2[2] - 1);
        var5.set(5, var2[3]);
        var5.set(11, var2[4] - 1);
        var5.set(12, var2[5] - 1);
        var5.set(13, var2[6] - 1);
        var5.set(14, 0);
        if ((var2[11] & REGIONIDBIT) != 0) {
            int var6 = getHighOrderbits(var2[11]);
            var6 += getLowOrderbits(var2[12]);
            TIMEZONETAB var7 = getTIMEZONETAB(var0);
            if (var7.checkID(var6)) {
                var7.updateTable(var0, var6);
            }

            int var3 = var7.getOffset(var5, var6);
            var5.add(10, var3 / HOUR_MILLISECOND);
            var5.add(12, var3 % HOUR_MILLISECOND / MINUTE_MILLISECOND);
        } else {
            var5.add(10, var2[11] - OFFSET_HOUR);
            var5.add(12, var2[12] - OFFSET_MINUTE);
        }

        long var8 = var5.getTime().getTime();
        return new Date(var8);
    }

    public static Date toDate2(Connection var0, byte[] var1) throws SQLException {
        int[] var2 = new int[13];

        int var4;
        for(var4 = 0; var4 < 13; ++var4) {
            var2[var4] = var1[var4] & 255;
        }

        var4 = TIMESTAMP.getJavaYear(var2[0], var2[1]);
        Calendar var5 = (Calendar)CAL_GMT_US.clone();
        var5.set(1, var4);
        var5.set(2, var2[2] - 1);
        var5.set(5, var2[3]);
        var5.set(11, var2[4] - 1);
        var5.set(12, var2[5] - 1);
        var5.set(13, var2[6] - 1);
        var5.set(14, 0);
        long var6 = var5.getTime().getTime();
        return new Date(var6);
    }

    public static Time toTime(Connection var0, byte[] var1) throws SQLException {
        int[] var2 = new int[13];

        for(int var4 = 0; var4 < 13; ++var4) {
            var2[var4] = var1[var4] & 255;
        }

        Calendar var6 = (Calendar)CAL_GMT_US.clone();
        int var5 = TIMESTAMP.getJavaYear(var2[0], var2[1]);
        var6.set(1, var5);
        var6.set(2, var2[2] - 1);
        var6.set(5, var2[3]);
        var6.set(11, var2[4] - 1);
        var6.set(12, var2[5] - 1);
        var6.set(13, var2[6] - 1);
        var6.set(14, 0);
        return new Time(var6.getTimeInMillis());
    }

    public static DATE toDATE(Connection var0, byte[] var1) throws SQLException {
        return new DATE(toTimestampInSessionTimezone(var0, var1));
    }

    public static TIMESTAMP toTIMESTAMP(Connection var0, byte[] var1) throws SQLException {
        return new TIMESTAMP(toTimestampInSessionTimezone(var0, var1));
    }

    public static Timestamp toTimestamp(Connection var0, byte[] var1) throws SQLException {
        int[] var2 = new int[13];

        for(int var4 = 0; var4 < 13; ++var4) {
            var2[var4] = var1[var4] & 255;
        }

        Calendar var18 = Calendar.getInstance();
        Calendar var5 = (Calendar)CAL_GMT_US.clone();
        Calendar var6 = Calendar.getInstance();
        int var7 = TIMESTAMP.getJavaYear(var2[0], var2[1]);
        var18.set(1, var7);
        var18.set(2, var2[2] - 1);
        var18.set(5, var2[3]);
        var18.set(11, var2[4] - 1);
        var18.set(12, var2[5] - 1);
        var18.set(13, var2[6] - 1);
        var18.set(14, 0);
        var5.set(1, var7);
        var5.set(2, var2[2] - 1);
        var5.set(5, var2[3]);
        var5.set(11, var2[4] - 1);
        var5.set(12, var2[5] - 1);
        var5.set(13, var2[6] - 1);
        var5.set(14, 0);
        long var8 = var18.getTime().getTime();
        if ((var2[11] & REGIONIDBIT) != 0) {
            int var10 = getHighOrderbits(var2[11]);
            var10 += getLowOrderbits(var2[12]);
            TIMEZONETAB var11 = getTIMEZONETAB(var0);
            if (var11.checkID(var10)) {
                var11.updateTable(var0, var10);
            }

            int var3 = var11.getOffset(var5, var10);
            var8 += (long)var3;
            TimeZone var12 = var18.getTimeZone();
            TimeZone var13 = var6.getTimeZone();
            if (!var12.inDaylightTime(var18.getTime()) && var13.inDaylightTime(new Timestamp(var8))) {
                if (var13 instanceof SimpleTimeZone) {
                    var8 -= (long)((SimpleTimeZone)((SimpleTimeZone)var13)).getDSTSavings();
                } else {
                    var8 -= (long)HOUR_MILLISECOND;
                }
            }

            if (var12.inDaylightTime(var18.getTime()) && !var13.inDaylightTime(new Timestamp(var8))) {
                if (var13 instanceof SimpleTimeZone) {
                    var8 += (long)((SimpleTimeZone)((SimpleTimeZone)var12)).getDSTSavings();
                } else {
                    var8 += (long)HOUR_MILLISECOND;
                }
            }
        } else {
            var18.add(10, var2[11] - OFFSET_HOUR);
            var18.add(12, var2[12] - OFFSET_MINUTE);
            var8 = var18.getTime().getTime();
        }

        Timestamp var19 = new Timestamp(var8);
        long var20 = var5.getTime().getTime();
        Calendar var21 = Calendar.getInstance();
        var21.setTimeInMillis(var20);
        Calendar var14 = Calendar.getInstance();
        var14.setTime(var19);
        boolean var15 = var21.getTimeZone().inDaylightTime(var21.getTime());
        boolean var16 = var14.getTimeZone().inDaylightTime(var14.getTime());
        if (var15 && !var16) {
            var19 = new Timestamp(var8 - (long)var21.getTimeZone().getDSTSavings());
        } else if (!var15 && var16) {
            var19 = new Timestamp(var8 + (long)var14.getTimeZone().getDSTSavings());
        }

        int var17 = TIMESTAMP.getNanos(var1, 7);
        var19.setNanos(var17);
        return var19;
    }

    public static Timestamp toTimestamp2(Connection var0, byte[] var1) throws SQLException {
        int[] var2 = new int[13];

        int var3;
        for(var3 = 0; var3 < 13; ++var3) {
            var2[var3] = var1[var3] & 255;
        }

        var3 = TIMESTAMP.getJavaYear(var2[0], var2[1]);
        Calendar var4 = (Calendar)CAL_GMT_US.clone();
        var4.clear();
        var4.set(1, var3);
        var4.set(2, var2[2] - 1);
        var4.set(5, var2[3]);
        var4.set(11, var2[4] - 1);
        var4.set(12, var2[5] - 1);
        var4.set(13, var2[6] - 1);
        var4.set(14, 0);
        long var5 = var4.getTime().getTime();
        Timestamp var7 = new Timestamp(var5);
        int var8 = TIMESTAMP.getNanos(var1, 7);
        var7.setNanos(var8);
        return var7;
    }

    static Timestamp toTimestampInSessionTimezone(Connection var0, byte[] var1) throws SQLException {
        int[] var2 = new int[13];

        int var3;
        for(var3 = 0; var3 < 13; ++var3) {
            var2[var3] = var1[var3] & 255;
        }

        var3 = TIMESTAMP.getJavaYear(var2[0], var2[1]);
        Calendar var4 = (Calendar)CAL_GMT_US.clone();
        var4.clear();
        var4.set(1, var3);
        var4.set(2, var2[2] - 1);
        var4.set(5, var2[3]);
        var4.set(11, var2[4] - 1);
        var4.set(12, var2[5] - 1);
        var4.set(13, var2[6] - 1);
        var4.set(14, 0);
        Calendar var5 = TIMESTAMPLTZ.getSessCalendar(var0);
        TIMESTAMPLTZ.TimeZoneAdjust(var0, var4, var5);
        long var6 = var5.getTime().getTime();
        Timestamp var8 = new Timestamp(var6);
        int var9 = TIMESTAMP.getNanos(var1, 7);
        var8.setNanos(var9);
        return var8;
    }

    public static String toString(Connection var0, byte[] var1) throws SQLException {
        String var2;
        String var3;
        int var4;
        if ((var1[11] & REGIONIDBIT) != 0) {
            var4 = getHighOrderbits(var1[11]);
            var4 += getLowOrderbits(var1[12]);
            var2 = ZONEIDMAP.getRegion(var4);
            var3 = var2;
        } else {
            var4 = var1[11] - OFFSET_HOUR;
            int var5 = var1[12] - OFFSET_MINUTE;
            var2 = var4 + ":";
            if (var5 == 0) {
                var2 = var2 + "00";
            } else {
                var2 = var2 + "" + var5;
            }

            var3 = "GMT" + (var4 >= 0 ? "+" : "") + var2;
        }

        Calendar var13 = Calendar.getInstance(TimeZone.getTimeZone(var3));
        Timestamp var14 = toTimestamp2(var0, var1);
        var13.setTimeInMillis(var14.getTime());
        int var6 = var13.get(1);
        if (var13.get(0) == 0) {
            var6 = -(var6 - 1);
        }

        int var7 = var13.get(2) + 1;
        int var8 = var13.get(5);
        int var9 = var13.get(11);
        int var10 = var13.get(12);
        int var11 = var13.get(13);
        boolean var12 = false;
        int var15 = (var1[7] & 255) << 24;
        var15 |= (var1[8] & 255) << 16;
        var15 |= (var1[9] & 255) << 8;
        var15 |= var1[10] & 255 & 255;
        return toString(var6, var7, var8, var9, var10, var11, var15, var2);
    }

    public static final String toString(int var0, int var1, int var2, int var3, int var4, int var5, int var6, String var7) {
        String var8 = "" + var0 + "-" + toStr(var1) + "-" + toStr(var2) + " " + toStr(var3) + ":" + toStr(var4) + ":" + toStr(var5);
        if (var6 >= 0) {
            String var9 = String.format("%09d", var6);
            char[] var10 = var9.toCharArray();

            int var11;
            for(var11 = var10.length; var11 > 1 && var10[var11 - 1] == '0'; --var11) {
            }

            var9 = var9.substring(0, var11);
            var8 = var8 + "." + var9;
        }

        if (var7 != null) {
            var8 = var8 + " " + var7;
        }

        return var8;
    }

    private static final String toStr(int var0) {
        return var0 < 10 ? "0" + var0 : Integer.toString(var0);
    }

    public Timestamp timestampValue(Connection var1) throws SQLException {
        return ((OracleConnection)var1).physicalConnectionWithin().getTimestamptzInGmt() ? toTimestamp2(var1, this.getBytes()) : toTimestamp(var1, this.getBytes());
    }

    public byte[] toBytes() {
        return this.getBytes();
    }

    public static byte[] toBytes(Connection var0, Date var1) throws SQLException {
        return toBytes(var0, (Date)var1, (Calendar)null);
    }

    public static byte[] toBytes(Connection var0, Date var1, Calendar var2) throws SQLException {
        if (var1 == null) {
            return null;
        } else {
            byte[] var3 = new byte[13];
            Calendar var4 = getWorkCal(var0, var2);
            var4.setTime(var1);
            Calendar var5 = doCalWork(var0, var4, var3);
            int var6 = TIMESTAMP.getOracleYear(var5);
            var3[0] = (byte)(var6 / 100 + 100);
            var3[1] = (byte)(var6 % 100 + 100);
            var3[2] = (byte)(var5.get(2) + 1);
            var3[3] = (byte)var5.get(5);
            var3[4] = (byte)(var5.get(11) + 1);
            var3[5] = (byte)(var5.get(12) + 1);
            var3[6] = (byte)(var5.get(13) + 1);
            var3[7] = 0;
            var3[8] = 0;
            var3[9] = 0;
            var3[10] = 0;
            return var3;
        }
    }

    public static byte[] toBytes(Connection var0, Time var1) throws SQLException {
        return toBytes(var0, (Time)var1, (Calendar)null);
    }

    public static byte[] toBytes(Connection var0, Time var1, Calendar var2) throws SQLException {
        if (var1 == null) {
            return null;
        } else {
            byte[] var3 = new byte[13];
            Calendar var4 = getWorkCal(var0, var2);
            var4.setTime(var1);
            short var5;
            if (((OracleConnection)var0).physicalConnectionWithin().getUse1900AsYearForTime()) {
                var5 = 1900;
            } else {
                var5 = 1970;
            }

            var4.set(1, var5);
            var4.set(2, 0);
            var4.set(5, 1);
            Calendar var6 = doCalWork(var0, var4, var3);
            int var7 = TIMESTAMP.getOracleYear(var6);
            var3[0] = (byte)(var7 / 100 + 100);
            var3[1] = (byte)(var7 % 100 + 100);
            var3[2] = (byte)(var6.get(2) + 1);
            var3[3] = (byte)var6.get(5);
            var3[4] = (byte)(var6.get(11) + 1);
            var3[5] = (byte)(var6.get(12) + 1);
            var3[6] = (byte)(var6.get(13) + 1);
            var3[7] = 0;
            var3[8] = 0;
            var3[9] = 0;
            var3[10] = 0;
            return var3;
        }
    }

    public static byte[] toBytes(Connection var0, Timestamp var1) throws SQLException {
        return toBytes(var0, (Timestamp)var1, (Calendar)null);
    }

    public static byte[] toBytes(Connection var0, Timestamp var1, Calendar var2) throws SQLException {
        if (var1 == null) {
            return null;
        } else {
            byte[] var3 = new byte[13];
            Calendar var4 = getWorkCal(var0, var2);
            var4.setTime(var1);
            Calendar var5 = doCalWork(var0, var4, var3);
            int var6 = TIMESTAMP.getOracleYear(var5);
            var3[0] = (byte)(var6 / 100 + 100);
            var3[1] = (byte)(var6 % 100 + 100);
            var3[2] = (byte)(var5.get(2) + 1);
            var3[3] = (byte)var5.get(5);
            var3[4] = (byte)(var5.get(11) + 1);
            var3[5] = (byte)(var5.get(12) + 1);
            var3[6] = (byte)(var5.get(13) + 1);
            var3[7] = (byte)(var1.getNanos() >> 24);
            var3[8] = (byte)(var1.getNanos() >> 16 & 255);
            var3[9] = (byte)(var1.getNanos() >> 8 & 255);
            var3[10] = (byte)(var1.getNanos() & 255);
            return var3;
        }
    }

    public static byte[] toBytes(Connection var0, DATE var1) throws SQLException {
        if (var1 == null) {
            return null;
        } else {
            byte[] var2 = new byte[13];
            Calendar var3 = getWorkCal(var0, (Calendar)null);
            var3.setTime(DATE.toDate(var1.toBytes()));
            Calendar var4 = doCalWork(var0, var3, var2);
            int var5 = TIMESTAMP.getOracleYear(var4);
            var2[0] = (byte)(var5 / 100 + 100);
            var2[1] = (byte)(var5 % 100 + 100);
            var2[2] = (byte)(var4.get(2) + 1);
            var2[3] = (byte)var4.get(5);
            var2[4] = (byte)(var4.get(11) + 1);
            var2[5] = (byte)(var4.get(12) + 1);
            var2[6] = (byte)(var4.get(13) + 1);
            var2[7] = 0;
            var2[8] = 0;
            var2[9] = 0;
            var2[10] = 0;
            return var2;
        }
    }

    public static byte[] toBytes(Connection var0, String var1) throws SQLException {
        return toBytes(var0, Timestamp.valueOf(var1));
    }

    public static byte[] toBytes(Connection var0, String var1, Calendar var2) throws SQLException {
        Calendar var3 = (Calendar)CAL_GMT_US.clone();
        Timestamp var4 = parseTime(var1);
        var3.setTime(var4);
        Calendar var5;
        if (var2 == null) {
            var5 = Calendar.getInstance();
        } else {
            var5 = Calendar.getInstance(var2.getTimeZone());
        }

        var5.set(1, var3.get(1));
        var5.set(2, var3.get(2));
        var5.set(5, var3.get(5));
        var5.set(11, var3.get(11));
        var5.set(12, var3.get(12));
        var5.set(13, var3.get(13));
        var5.set(14, var3.get(14));
        int var6 = var4.getNanos();
        var4 = new Timestamp(var5.getTime().getTime());
        var4.setNanos(var6);
        return toBytes(var0, var4, var2);
    }

    public String stringValue(Connection var1) throws SQLException {
        return toString(var1, this.getBytes());
    }

    public Date dateValue(Connection var1) throws SQLException {
        return ((OracleConnection)var1).physicalConnectionWithin().getTimestamptzInGmt() ? toDate2(var1, this.getBytes()) : toDate(var1, this.getBytes());
    }

    public Time timeValue(Connection var1) throws SQLException {
        return toTime(var1, this.getBytes());
    }

    private static Calendar getWorkCal(Connection var0, Calendar var1) {
        Calendar var2;
        if (var1 == null) {
            String var3 = ((OracleConnection)var0).getSessionTimeZone();
            if (var3 == null) {
                var2 = Calendar.getInstance();
            } else {
                var2 = Calendar.getInstance(TimeZone.getTimeZone(var3));
            }
        } else {
            var2 = Calendar.getInstance(var1.getTimeZone());
        }

        return var2;
    }

    private static Calendar doCalWork(Connection var0, Calendar var1, byte[] var2) throws SQLException {
        boolean var4 = var1.getTimeZone().inDaylightTime(var1.getTime());
        int var3;
        if (var1.getTimeZone().getID() == "Custom") {
            var3 = var1.getTimeZone().getRawOffset();
            var2[11] = (byte)(var3 / HOUR_MILLISECOND + OFFSET_HOUR);
            var2[12] = (byte)(var3 % HOUR_MILLISECOND / MINUTE_MILLISECOND + OFFSET_MINUTE);
        } else {
            String var5 = var1.getTimeZone().getID();
            int var6 = ZONEIDMAP.getID(var5);
            if (!ZONEIDMAP.isValidID(var6)) {
                if (var1.getTimeZone().useDaylightTime()) {
                    throw new SQLException("Timezone not supported");
                }

                var3 = var1.getTimeZone().getRawOffset();
                var2[11] = (byte)(var3 / HOUR_MILLISECOND + OFFSET_HOUR);
                var2[12] = (byte)(var3 % HOUR_MILLISECOND / MINUTE_MILLISECOND + OFFSET_MINUTE);
            } else {
                TIMEZONETAB var7 = getTIMEZONETAB(var0);
                if (var7.checkID(var6)) {
                    var7.updateTable(var0, var6);
                }

                OffsetDST var8 = new OffsetDST();
                byte var9 = var7.getLocalOffset(var1, var6, var8);
                var3 = var8.getOFFSET();
                if (var4 && var9 == 1) {
                    if (var8.getDSTFLAG() != 0) {
                        throw new SQLException();
                    }

                    var3 += HOUR_MILLISECOND;
                }

                int var10 = ZONEIDMAP.getID(var5);
                var2[11] = (byte)setHighOrderbits(var10);
                var2[11] |= REGIONIDBIT;
                var2[12] = (byte)setLowOrderbits(var10);
            }
        }

        Calendar var11 = (Calendar)CAL_GMT_US.clone();
        var11.set(0, var1.get(0));
        var11.set(1, var1.get(1));
        var11.set(2, var1.get(2));
        var11.set(5, var1.get(5));
        var11.set(11, var1.get(11));
        var11.set(12, var1.get(12));
        var11.set(13, var1.get(13));
        var11.add(14, -1 * var3);
        return var11;
    }

    private static byte[] initTimestamptz() {
        byte[] var0 = new byte[13];
        Calendar var1 = Calendar.getInstance();
        var0[0] = 119;
        var0[1] = -86;
        var0[2] = 1;
        var0[3] = 1;
        var0[4] = 1;
        var0[5] = 1;
        var0[6] = 1;
        var0[7] = 0;
        var0[8] = 0;
        var0[9] = 0;
        var0[10] = 0;
        String var2 = var1.getTimeZone().getID();
        var0[11] = (byte)setHighOrderbits(ZONEIDMAP.getID(var2));
        var0[11] |= REGIONIDBIT;
        var0[12] = (byte)setLowOrderbits(ZONEIDMAP.getID(var2));
        return var0;
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

    private static Timestamp parseTime(String var0) throws SQLException {
        if (var0 == null) {
            SQLException var25 = DatabaseError.createSqlException((oracle.jdbc.internal.OracleConnection)null, 68);
            var25.fillInStackTrace();
            throw var25;
        } else {
            String var1 = var0.trim();
            int var2 = var1.indexOf(32);
            if (var2 == 0) {
                SQLException var26 = DatabaseError.createSqlException((oracle.jdbc.internal.OracleConnection)null, 68);
                var26.fillInStackTrace();
                throw var26;
            } else {
                String var3 = var1.substring(0, var2);
                String var4 = var1.substring(var2 + 1);
                if (var3 == null | var4 == null) {
                    SQLException var27 = DatabaseError.createSqlException((oracle.jdbc.internal.OracleConnection)null, 68);
                    var27.fillInStackTrace();
                    throw var27;
                } else {
                    int var5 = var3.indexOf(45);
                    int var6 = var3.indexOf(45, var5 + 1);
                    if (var5 >= 1 && var6 >= 1 && var6 != var3.length()) {
                        String var28 = var3.substring(0, var5);
                        String var8 = var3.substring(var5 + 1, var6);
                        String var9 = var3.substring(var6 + 1);
                        if (var28.length() == 4 && var8.length() == 2 && var9.length() == 2) {
                            int var29 = Integer.parseInt(var28);
                            int var11 = Integer.parseInt(var8) - 1;
                            int var12 = Integer.parseInt(var9);
                            int var13 = var4.indexOf(58);
                            int var14 = var4.indexOf(58, var13 + 1);
                            if (var13 >= 1 && var14 >= 1 && var14 != var4.length()) {
                                String var30 = var4.substring(0, var13);
                                String var16 = var4.substring(var13 + 1, var14);
                                if (var30.length() == 2 && var16.length() == 2) {
                                    int var31 = Integer.parseInt(var30);
                                    int var18 = Integer.parseInt(var16);
                                    int var20 = 0;
                                    int var21 = var4.indexOf(46, var14 + 1);
                                    int var19;
                                    if (var21 == -1) {
                                        var19 = Integer.parseInt(var4.substring(var14 + 1));
                                    } else {
                                        if (var21 <= 0 || var21 >= var4.length() - 1) {
                                            SQLException var33 = DatabaseError.createSqlException((oracle.jdbc.internal.OracleConnection)null, 68);
                                            var33.fillInStackTrace();
                                            throw var33;
                                        }

                                        var19 = Integer.parseInt(var4.substring(var14 + 1, var21));
                                        String var22 = var4.substring(var21 + 1);
                                        String var23 = "000000000";
                                        if (var22.length() > var23.length() || !Character.isDigit(var22.charAt(0))) {
                                            SQLException var24 = DatabaseError.createSqlException((oracle.jdbc.internal.OracleConnection)null, 68);
                                            var24.fillInStackTrace();
                                            throw var24;
                                        }

                                        var22 = var22 + var23.substring(0, var23.length() - var22.length());
                                        var20 = Integer.parseInt(var22);
                                    }

                                    Calendar var32 = (Calendar)CAL_GMT_US.clone();
                                    var32.set(1, var29);
                                    var32.set(2, var11);
                                    var32.set(5, var12);
                                    var32.set(11, var31);
                                    var32.set(12, var18);
                                    var32.set(13, var19);
                                    var32.set(14, 0);
                                    Timestamp var34 = new Timestamp(var32.getTime().getTime());
                                    var34.setNanos(var20);
                                    return var34;
                                } else {
                                    SQLException var17 = DatabaseError.createSqlException((oracle.jdbc.internal.OracleConnection)null, 68);
                                    var17.fillInStackTrace();
                                    throw var17;
                                }
                            } else {
                                SQLException var15 = DatabaseError.createSqlException((oracle.jdbc.internal.OracleConnection)null, 68);
                                var15.fillInStackTrace();
                                throw var15;
                            }
                        } else {
                            SQLException var10 = DatabaseError.createSqlException((oracle.jdbc.internal.OracleConnection)null, 68);
                            var10.fillInStackTrace();
                            throw var10;
                        }
                    } else {
                        SQLException var7 = DatabaseError.createSqlException((oracle.jdbc.internal.OracleConnection)null, 68);
                        var7.fillInStackTrace();
                        throw var7;
                    }
                }
            }
        }
    }

    private static int setHighOrderbits(int var0) {
        return (var0 & 8128) >> 6;
    }

    private static int setLowOrderbits(int var0) {
        return (var0 & 63) << 2;
    }

    private static int getHighOrderbits(int var0) {
        return (var0 & 127) << 6;
    }

    private static int getLowOrderbits(int var0) {
        return (var0 & 252) >> 2;
    }

    static TIMEZONETAB getTIMEZONETAB(Connection var0) throws SQLException {
        oracle.jdbc.internal.OracleConnection var1 = ((OracleConnection)var0).physicalConnectionWithin();
        return var1.getTIMEZONETAB();
    }

    static {
        CAL_GMT_US = Calendar.getInstance(TimeZone.getTimeZone("GMT"), Locale.US);
        TIMEZONE_UTC = TimeZone.getTimeZone("UTC");
        HOUR_MILLISECOND = 3600000;
        MINUTE_MILLISECOND = 60000;
        OFFSET_HOUR = 20;
        OFFSET_MINUTE = 60;
        REGIONIDBIT = -128;
        _Copyright_2007_Oracle_All_Rights_Reserved_ = null;
    }
}
