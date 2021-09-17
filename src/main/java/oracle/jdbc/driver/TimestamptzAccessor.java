//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package oracle.jdbc.driver;

import java.sql.Date;
import java.sql.SQLException;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Map;
import java.util.TimeZone;
import oracle.sql.DATE;
import oracle.sql.Datum;
import oracle.sql.TIMESTAMP;
import oracle.sql.TIMESTAMPTZ;
import oracle.sql.TIMEZONETAB;
import oracle.sql.ZONEIDMAP;

class TimestamptzAccessor extends DateTimeCommonAccessor {
    static final int MAXLENGTH = 13;
    TimestamptzAccessor.TimestampTzConverter tstzConverter = null;
    static int OFFSET_HOUR = 20;
    static int OFFSET_MINUTE = 60;
    static byte REGIONIDBIT = -128;
    private static final String _Copyright_2007_Oracle_All_Rights_Reserved_ = null;
    public static final String BUILD_DATE = "Thu_Apr_04_15:09:24_PDT_2013";
    public static final boolean TRACE = false;

    TimestamptzAccessor(OracleStatement var1, int var2, short var3, int var4, boolean var5) throws SQLException {
        super(Representation.TIMESTAMPTZ, var1, 13, var5);
        this.init(var1, 181, 181, var3, var5);
        this.initForDataAccess(var4, var2, (String)null);
        if (this.statement.connection.timestamptzInGmt) {
            this.tstzConverter = new TimestamptzAccessor.GmtTimestampTzConverter();
        } else {
            this.tstzConverter = new TimestamptzAccessor.OldTimestampTzConverter();
        }

    }

    TimestamptzAccessor(OracleStatement var1, int var2, boolean var3, int var4, int var5, int var6, int var7, int var8, short var9) throws SQLException {
        super(Representation.TIMESTAMPTZ, var1, 13, false);
        this.init(var1, 181, 181, var9, false);
        this.initForDescribe(181, var2, var3, var4, var5, var6, var7, var8, var9, (String)null);
        this.initForDataAccess(0, var2, (String)null);
        if (this.statement.connection.timestamptzInGmt) {
            this.tstzConverter = new TimestamptzAccessor.GmtTimestampTzConverter();
        } else {
            this.tstzConverter = new TimestamptzAccessor.OldTimestampTzConverter();
        }

    }

    String getString(int var1) throws SQLException {
        if (this.isNull(var1)) {
            return null;
        } else {
            int var3 = 0;
            this.getBytesInternal(var1, this.tmpBytes);
            String var2;
            int var5;
            if ((this.oracleTZ1(this.tmpBytes) & REGIONIDBIT) != 0) {
                var3 = getHighOrderbits(this.oracleTZ1(this.tmpBytes));
                var3 += getLowOrderbits(this.oracleTZ2(this.tmpBytes));
                TIMEZONETAB var4 = this.statement.connection.getTIMEZONETAB();
                if (var4.checkID(var3)) {
                    var4.updateTable(this.statement.connection, var3);
                }

                var2 = ZONEIDMAP.getRegion(var3);
            } else {
                int var13 = this.oracleTZ1(this.tmpBytes) - OFFSET_HOUR;
                var5 = this.oracleTZ2(this.tmpBytes) - OFFSET_MINUTE;
                var2 = "GMT" + (var13 < 0 ? "-" : "+") + Math.abs(var13) + ":" + (var5 < 10 ? "0" : "") + var5;
            }

            Calendar var14 = (Calendar)((Calendar)this.statement.getGMTCalendar().clone());
            var5 = this.oracleYear(this.tmpBytes);
            var14.set(1, var5);
            var14.set(2, this.oracleMonth(this.tmpBytes));
            var14.set(5, this.oracleDay(this.tmpBytes));
            var14.set(11, this.oracleHour(this.tmpBytes));
            var14.set(12, this.oracleMin(this.tmpBytes));
            var14.set(13, this.oracleSec(this.tmpBytes));
            var14.set(14, 0);
            int var7;
            if ((this.oracleTZ1(this.tmpBytes) & REGIONIDBIT) != 0) {
                TIMEZONETAB var6 = this.statement.connection.getTIMEZONETAB();
                var7 = var6.getOffset(var14, var3);
                var14.add(14, var7);
            } else {
                var14.add(10, this.oracleTZ1(this.tmpBytes) - OFFSET_HOUR);
                var14.add(12, this.oracleTZ2(this.tmpBytes) - OFFSET_MINUTE);
            }

            var5 = var14.get(1);
            int var15 = var14.get(2) + 1;
            var7 = var14.get(5);
            int var8 = var14.get(11);
            int var9 = var14.get(12);
            int var10 = var14.get(13);
            boolean var11 = var8 < 12;
            if (var2.length() > 3 && var2.startsWith("GMT")) {
                var2 = var2.substring(3);
            }

            int var12 = this.oracleNanos(this.tmpBytes);
            return this.toText(var5, var15, var7, var8, var9, var10, var12, var11, var2);
        }
    }

    Date getDate(int var1) throws SQLException {
        return this.tstzConverter.getDate(var1);
    }

    Date getDate(int var1, Calendar var2) throws SQLException {
        return this.getDate(var1);
    }

    Time getTime(int var1) throws SQLException {
        return this.tstzConverter.getTime(var1);
    }

    Time getTime(int var1, Calendar var2) throws SQLException {
        return this.getTime(var1);
    }

    Timestamp getTimestamp(int var1) throws SQLException {
        return this.tstzConverter.getTimestamp(var1);
    }

    Timestamp getTimestamp(int var1, Calendar var2) throws SQLException {
        return this.getTimestamp(var1);
    }

    Object getObject(int var1) throws SQLException {
        return this.tstzConverter.getObject(var1);
    }

    Datum getOracleObject(int var1) throws SQLException {
        return this.tstzConverter.getOracleObject(var1);
    }

    DATE getDATE(int var1) throws SQLException {
        TIMESTAMPTZ var2 = this.tstzConverter.getTIMESTAMPTZ(var1);
        return var2 == null ? null : oracle.sql.TIMESTAMPTZ.toDATE(this.statement.connection, var2.getBytes());
    }

    TIMESTAMP getTIMESTAMP(int var1) throws SQLException {
        TIMESTAMPTZ var2 = this.tstzConverter.getTIMESTAMPTZ(var1);
        return var2 == null ? null : oracle.sql.TIMESTAMPTZ.toTIMESTAMP(this.statement.connection, var2.getBytes());
    }

    TIMESTAMPTZ getTIMESTAMPTZ(int var1) throws SQLException {
        return this.tstzConverter.getTIMESTAMPTZ(var1);
    }

    static int setHighOrderbits(int var0) {
        return (var0 & 8128) >> 6;
    }

    static int setLowOrderbits(int var0) {
        return (var0 & 63) << 2;
    }

    static int getHighOrderbits(int var0) {
        return (var0 & 127) << 6;
    }

    static int getLowOrderbits(int var0) {
        return (var0 & 252) >> 2;
    }

    abstract class TimestampTzConverter {
        TimestampTzConverter() {
        }

        abstract Date getDate(int var1) throws SQLException;

        abstract Time getTime(int var1) throws SQLException;

        abstract Timestamp getTimestamp(int var1) throws SQLException;

        Object getObject(int var1) throws SQLException {
            return this.getTIMESTAMPTZ(var1);
        }

        Datum getOracleObject(int var1) throws SQLException {
            return this.getTIMESTAMPTZ(var1);
        }

        Object getObject(int var1, Map var2) throws SQLException {
            return this.getTIMESTAMPTZ(var1);
        }

        abstract TIMESTAMPTZ getTIMESTAMPTZ(int var1) throws SQLException;
    }

    class GmtTimestampTzConverter extends TimestamptzAccessor.TimestampTzConverter {
        GmtTimestampTzConverter() {
            super();
        }

        Date getDate(int var1) throws SQLException {
            if (TimestamptzAccessor.this.isNull(var1)) {
                return null;
            } else {
                Calendar var2 = (Calendar)((Calendar)TimestamptzAccessor.this.statement.getGMTCalendar().clone());
                TimestamptzAccessor.this.getBytesInternal(var1, TimestamptzAccessor.this.tmpBytes);
                int var3 = TimestamptzAccessor.this.oracleYear(TimestamptzAccessor.this.tmpBytes);
                var2.set(1, var3);
                var2.set(2, TimestamptzAccessor.this.oracleMonth(TimestamptzAccessor.this.tmpBytes));
                var2.set(5, TimestamptzAccessor.this.oracleDay(TimestamptzAccessor.this.tmpBytes));
                var2.set(11, TimestamptzAccessor.this.oracleHour(TimestamptzAccessor.this.tmpBytes));
                var2.set(12, TimestamptzAccessor.this.oracleMin(TimestamptzAccessor.this.tmpBytes));
                var2.set(13, TimestamptzAccessor.this.oracleSec(TimestamptzAccessor.this.tmpBytes));
                var2.set(14, 0);
                long var4 = var2.getTimeInMillis();
                return new Date(var4);
            }
        }

        Time getTime(int var1) throws SQLException {
            if (TimestamptzAccessor.this.isNull(var1)) {
                return null;
            } else {
                Calendar var2 = (Calendar)((Calendar)TimestamptzAccessor.this.statement.getGMTCalendar().clone());
                TimestamptzAccessor.this.getBytesInternal(var1, TimestamptzAccessor.this.tmpBytes);
                int var3 = TimestamptzAccessor.this.oracleYear(TimestamptzAccessor.this.tmpBytes);
                var2.set(1, var3);
                var2.set(2, TimestamptzAccessor.this.oracleMonth(TimestamptzAccessor.this.tmpBytes));
                var2.set(5, TimestamptzAccessor.this.oracleDay(TimestamptzAccessor.this.tmpBytes));
                var2.set(11, TimestamptzAccessor.this.oracleHour(TimestamptzAccessor.this.tmpBytes));
                var2.set(12, TimestamptzAccessor.this.oracleMin(TimestamptzAccessor.this.tmpBytes));
                var2.set(13, TimestamptzAccessor.this.oracleSec(TimestamptzAccessor.this.tmpBytes));
                var2.set(14, 0);
                return new Time(var2.getTimeInMillis());
            }
        }

        Timestamp getTimestamp(int var1) throws SQLException {
            if (TimestamptzAccessor.this.isNull(var1)) {
                return null;
            } else {
                Calendar var2 = (Calendar)((Calendar)TimestamptzAccessor.this.statement.getGMTCalendar().clone());
                TimestamptzAccessor.this.getBytesInternal(var1, TimestamptzAccessor.this.tmpBytes);
                int var3 = TimestamptzAccessor.this.oracleYear(TimestamptzAccessor.this.tmpBytes);
                var2.set(1, var3);
                var2.set(2, TimestamptzAccessor.this.oracleMonth(TimestamptzAccessor.this.tmpBytes));
                var2.set(5, TimestamptzAccessor.this.oracleDay(TimestamptzAccessor.this.tmpBytes));
                var2.set(11, TimestamptzAccessor.this.oracleHour(TimestamptzAccessor.this.tmpBytes));
                var2.set(12, TimestamptzAccessor.this.oracleMin(TimestamptzAccessor.this.tmpBytes));
                var2.set(13, TimestamptzAccessor.this.oracleSec(TimestamptzAccessor.this.tmpBytes));
                var2.set(14, 0);
                long var4 = var2.getTimeInMillis();
                Timestamp var6 = new Timestamp(var4);
                int var7 = TimestamptzAccessor.this.oracleNanos(TimestamptzAccessor.this.tmpBytes);
                var6.setNanos(var7);
                return var6;
            }
        }

        TIMESTAMPTZ getTIMESTAMPTZ(int var1) throws SQLException {
            return TimestamptzAccessor.this.isNull(var1) ? null : new TIMESTAMPTZ(TimestamptzAccessor.this.getBytesInternal(var1));
        }
    }

    class OldTimestampTzConverter extends TimestamptzAccessor.TimestampTzConverter {
        OldTimestampTzConverter() {
            super();
        }

        Date getDate(int var1) throws SQLException {
            if (TimestamptzAccessor.this.isNull(var1)) {
                return null;
            } else {
                TimeZone var2 = TimestamptzAccessor.this.statement.getDefaultTimeZone();
                Calendar var3 = Calendar.getInstance(var2);
                TimestamptzAccessor.this.getBytesInternal(var1, TimestamptzAccessor.this.tmpBytes);
                int var4 = TimestamptzAccessor.this.oracleYear(TimestamptzAccessor.this.tmpBytes);
                var3.set(1, var4);
                var3.set(2, TimestamptzAccessor.this.oracleMonth(TimestamptzAccessor.this.tmpBytes));
                var3.set(5, TimestamptzAccessor.this.oracleDay(TimestamptzAccessor.this.tmpBytes));
                var3.set(11, TimestamptzAccessor.this.oracleHour(TimestamptzAccessor.this.tmpBytes));
                var3.set(12, TimestamptzAccessor.this.oracleMin(TimestamptzAccessor.this.tmpBytes));
                var3.set(13, TimestamptzAccessor.this.oracleSec(TimestamptzAccessor.this.tmpBytes));
                var3.set(14, 0);
                if ((TimestamptzAccessor.this.oracleTZ1(TimestamptzAccessor.this.tmpBytes) & TimestamptzAccessor.REGIONIDBIT) != 0) {
                    int var5 = TimestamptzAccessor.getHighOrderbits(TimestamptzAccessor.this.oracleTZ1(TimestamptzAccessor.this.tmpBytes));
                    var5 += TimestamptzAccessor.getLowOrderbits(TimestamptzAccessor.this.oracleTZ2(TimestamptzAccessor.this.tmpBytes));
                    TIMEZONETAB var6 = TimestamptzAccessor.this.statement.connection.getTIMEZONETAB();
                    if (var6.checkID(var5)) {
                        var6.updateTable(TimestamptzAccessor.this.statement.connection, var5);
                    }

                    int var7 = var6.getOffset(var3, var5);
                    boolean var8 = var2.inDaylightTime(var3.getTime());
                    boolean var9 = var2.inDaylightTime(new java.util.Date(var3.getTimeInMillis() + (long)var7));
                    if (!var8 && var9) {
                        var3.add(14, -1 * var2.getDSTSavings());
                    } else if (var8 && !var9) {
                        var3.add(14, var2.getDSTSavings());
                    }

                    var3.add(10, var7 / 3600000);
                    var3.add(12, var7 % 3600000 / '\uea60');
                } else {
                    var3.add(10, TimestamptzAccessor.this.oracleTZ1(TimestamptzAccessor.this.tmpBytes) - TimestamptzAccessor.OFFSET_HOUR);
                    var3.add(12, TimestamptzAccessor.this.oracleTZ2(TimestamptzAccessor.this.tmpBytes) - TimestamptzAccessor.OFFSET_MINUTE);
                }

                long var10 = var3.getTimeInMillis();
                return new Date(var10);
            }
        }

        Time getTime(int var1) throws SQLException {
            if (TimestamptzAccessor.this.isNull(var1)) {
                return null;
            } else {
                TimeZone var2 = TimestamptzAccessor.this.statement.getDefaultTimeZone();
                Calendar var3 = Calendar.getInstance(var2);
                TimestamptzAccessor.this.getBytesInternal(var1, TimestamptzAccessor.this.tmpBytes);
                int var4 = TimestamptzAccessor.this.oracleYear(TimestamptzAccessor.this.tmpBytes);
                var3.set(1, var4);
                var3.set(2, TimestamptzAccessor.this.oracleMonth(TimestamptzAccessor.this.tmpBytes));
                var3.set(5, TimestamptzAccessor.this.oracleDay(TimestamptzAccessor.this.tmpBytes));
                var3.set(11, TimestamptzAccessor.this.oracleHour(TimestamptzAccessor.this.tmpBytes));
                var3.set(12, TimestamptzAccessor.this.oracleMin(TimestamptzAccessor.this.tmpBytes));
                var3.set(13, TimestamptzAccessor.this.oracleSec(TimestamptzAccessor.this.tmpBytes));
                var3.set(14, 0);
                if ((TimestamptzAccessor.this.oracleTZ1(TimestamptzAccessor.this.tmpBytes) & TimestamptzAccessor.REGIONIDBIT) != 0) {
                    int var5 = TimestamptzAccessor.getHighOrderbits(TimestamptzAccessor.this.oracleTZ1(TimestamptzAccessor.this.tmpBytes));
                    var5 += TimestamptzAccessor.getLowOrderbits(TimestamptzAccessor.this.oracleTZ2(TimestamptzAccessor.this.tmpBytes));
                    TIMEZONETAB var6 = TimestamptzAccessor.this.statement.connection.getTIMEZONETAB();
                    if (var6.checkID(var5)) {
                        var6.updateTable(TimestamptzAccessor.this.statement.connection, var5);
                    }

                    int var7 = var6.getOffset(var3, var5);
                    boolean var8 = var2.inDaylightTime(var3.getTime());
                    boolean var9 = var2.inDaylightTime(new java.util.Date(var3.getTimeInMillis() + (long)var7));
                    if (!var8 && var9) {
                        var3.add(14, -1 * var2.getDSTSavings());
                    } else if (var8 && !var9) {
                        var3.add(14, var2.getDSTSavings());
                    }

                    var3.add(10, var7 / 3600000);
                    var3.add(12, var7 % 3600000 / '\uea60');
                } else {
                    var3.add(10, TimestamptzAccessor.this.oracleTZ1(TimestamptzAccessor.this.tmpBytes) - TimestamptzAccessor.OFFSET_HOUR);
                    var3.add(12, TimestamptzAccessor.this.oracleTZ2(TimestamptzAccessor.this.tmpBytes) - TimestamptzAccessor.OFFSET_MINUTE);
                }

                long var10 = var3.getTimeInMillis();
                return new Time(var10);
            }
        }

        Timestamp getTimestamp(int var1) throws SQLException {
            if (TimestamptzAccessor.this.isNull(var1)) {
                return null;
            } else {
                TimeZone var2 = TimestamptzAccessor.this.statement.getDefaultTimeZone();
                Calendar var3 = Calendar.getInstance(var2);
                Calendar var4 = (Calendar)((Calendar)TimestamptzAccessor.this.statement.getGMTCalendar().clone());
                TimestamptzAccessor.this.getBytesInternal(var1, TimestamptzAccessor.this.tmpBytes);
                int var5 = TimestamptzAccessor.this.oracleYear(TimestamptzAccessor.this.tmpBytes);
                var3.set(1, var5);
                var3.set(2, TimestamptzAccessor.this.oracleMonth(TimestamptzAccessor.this.tmpBytes));
                var3.set(5, TimestamptzAccessor.this.oracleDay(TimestamptzAccessor.this.tmpBytes));
                var3.set(11, TimestamptzAccessor.this.oracleHour(TimestamptzAccessor.this.tmpBytes));
                var3.set(12, TimestamptzAccessor.this.oracleMin(TimestamptzAccessor.this.tmpBytes));
                var3.set(13, TimestamptzAccessor.this.oracleSec(TimestamptzAccessor.this.tmpBytes));
                var3.set(14, 0);
                var4.set(1, var5);
                var4.set(2, TimestamptzAccessor.this.oracleMonth(TimestamptzAccessor.this.tmpBytes));
                var4.set(5, TimestamptzAccessor.this.oracleDay(TimestamptzAccessor.this.tmpBytes));
                var4.set(11, TimestamptzAccessor.this.oracleHour(TimestamptzAccessor.this.tmpBytes));
                var4.set(12, TimestamptzAccessor.this.oracleMin(TimestamptzAccessor.this.tmpBytes));
                var4.set(13, TimestamptzAccessor.this.oracleSec(TimestamptzAccessor.this.tmpBytes));
                var4.set(14, 0);
                if ((TimestamptzAccessor.this.oracleTZ1(TimestamptzAccessor.this.tmpBytes) & TimestamptzAccessor.REGIONIDBIT) != 0) {
                    int var6 = TimestamptzAccessor.getHighOrderbits(TimestamptzAccessor.this.oracleTZ1(TimestamptzAccessor.this.tmpBytes));
                    var6 += TimestamptzAccessor.getLowOrderbits(TimestamptzAccessor.this.oracleTZ2(TimestamptzAccessor.this.tmpBytes));
                    TIMEZONETAB var7 = TimestamptzAccessor.this.statement.connection.getTIMEZONETAB();
                    if (var7.checkID(var6)) {
                        var7.updateTable(TimestamptzAccessor.this.statement.connection, var6);
                    }

                    int var8 = var7.getOffset(var4, var6);
                    boolean var9 = var2.inDaylightTime(var3.getTime());
                    boolean var10 = var2.inDaylightTime(new java.util.Date(var3.getTimeInMillis() + (long)var8));
                    if (!var9 && var10) {
                        var3.add(14, -1 * var2.getDSTSavings());
                    } else if (var9 && !var10) {
                        var3.add(14, var2.getDSTSavings());
                    }

                    var3.add(10, var8 / 3600000);
                    var3.add(12, var8 % 3600000 / '\uea60');
                } else {
                    var3.add(10, TimestamptzAccessor.this.oracleTZ1(TimestamptzAccessor.this.tmpBytes) - TimestamptzAccessor.OFFSET_HOUR);
                    var3.add(12, TimestamptzAccessor.this.oracleTZ2(TimestamptzAccessor.this.tmpBytes) - TimestamptzAccessor.OFFSET_MINUTE);
                }

                long var11 = var3.getTimeInMillis();
                Timestamp var12 = new Timestamp(var11);
                int var13 = TimestamptzAccessor.this.oracleNanos(TimestamptzAccessor.this.tmpBytes);
                var12.setNanos(var13);
                return var12;
            }
        }

        TIMESTAMPTZ getTIMESTAMPTZ(int var1) throws SQLException {
            return TimestamptzAccessor.this.isNull(var1) ? null : new TIMESTAMPTZ(TimestamptzAccessor.this.getBytesInternal(var1));
        }
    }
}
