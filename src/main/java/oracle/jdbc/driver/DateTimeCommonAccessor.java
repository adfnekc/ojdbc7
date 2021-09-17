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
import java.util.TimeZone;
import oracle.sql.DATE;
import oracle.sql.TIMESTAMP;
import oracle.sql.TIMESTAMPTZ;

abstract class DateTimeCommonAccessor extends Accessor {
    static final int GREGORIAN_CUTOVER_YEAR = 1582;
    static final long GREGORIAN_CUTOVER = -12219292800000L;
    static final int JAN_1_1_JULIAN_DAY = 1721426;
    static final int EPOCH_JULIAN_DAY = 2440588;
    static final int ONE_SECOND = 1000;
    static final int ONE_MINUTE = 60000;
    static final int ONE_HOUR = 3600000;
    static final long ONE_DAY = 86400000L;
    static final int[] NUM_DAYS = new int[]{0, 31, 59, 90, 120, 151, 181, 212, 243, 273, 304, 334};
    static final int[] LEAP_NUM_DAYS = new int[]{0, 31, 60, 91, 121, 152, 182, 213, 244, 274, 305, 335};
    static final int ORACLE_CENTURY = 0;
    static final int ORACLE_YEAR = 1;
    static final int ORACLE_MONTH = 2;
    static final int ORACLE_DAY = 3;
    static final int ORACLE_HOUR = 4;
    static final int ORACLE_MIN = 5;
    static final int ORACLE_SEC = 6;
    static final int ORACLE_NANO1 = 7;
    static final int ORACLE_NANO2 = 8;
    static final int ORACLE_NANO3 = 9;
    static final int ORACLE_NANO4 = 10;
    static final int ORACLE_TZ1 = 11;
    static final int ORACLE_TZ2 = 12;
    static final int SIZE_DATE = 7;
    static final int MAX_TIMESTAMP_LENGTH = 11;
    protected final byte[] tmpBytes;
    static TimeZone epochTimeZone;
    static long epochTimeZoneOffset;
    private static final String _Copyright_2007_Oracle_All_Rights_Reserved_ = null;
    public static final String BUILD_DATE = "Thu_Apr_04_15:09:24_PDT_2013";
    public static final boolean TRACE = false;

    DateTimeCommonAccessor(Representation var1, OracleStatement var2, int var3, boolean var4) {
        super(var1, var2, var3, var4);
        this.tmpBytes = new byte[this.representationMaxLength];
    }

    Date getDate(int var1) throws SQLException {
        return this.getDate(var1, (Calendar)null);
    }

    Date getDate(int var1, Calendar var2) throws SQLException {
        if (this.isNull(var1)) {
            return null;
        } else {
            Date var3 = null;
            Calendar var4;
            if (var2 == null) {
                var4 = this.statement.getDefaultCalendar();
            } else {
                var4 = (Calendar)((Calendar)var2.clone());
            }

            this.getBytesInternal(var1, this.tmpBytes);
            int var5 = this.oracleYear(this.tmpBytes);
            var4.set(1, var5);
            var4.set(2, this.oracleMonth(this.tmpBytes));
            var4.set(5, this.oracleDay(this.tmpBytes));
            var4.set(11, this.oracleHour(this.tmpBytes));
            var4.set(12, this.oracleMin(this.tmpBytes));
            var4.set(13, this.oracleSec(this.tmpBytes));
            var4.set(14, 0);
            if (var5 > 0 && var4.isSet(0)) {
                var4.set(0, 1);
            }

            var3 = new Date(var4.getTimeInMillis());
            return var3;
        }
    }

    Time getTime(int var1) throws SQLException {
        Time var2 = null;
        if (this.isNull(var1)) {
            return null;
        } else {
            TimeZone var3 = this.statement.getDefaultTimeZone();
            if (var3 != epochTimeZone) {
                epochTimeZoneOffset = calculateEpochOffset(var3);
                epochTimeZone = var3;
            }

            this.getBytesInternal(var1, this.tmpBytes);
            var2 = new Time((long)this.oracleTime(this.tmpBytes) - epochTimeZoneOffset);
            return var2;
        }
    }

    Time getTime(int var1, Calendar var2) throws SQLException {
        if (this.isNull(var1)) {
            return null;
        } else if (var2 == null) {
            return this.getTime(var1);
        } else {
            this.getBytesInternal(var1, this.tmpBytes);
            int var3 = this.oracleYear(this.tmpBytes);
            Calendar var4 = (Calendar)((Calendar)var2.clone());
            var4.set(1, 1970);
            var4.set(2, 0);
            var4.set(5, 1);
            var4.set(11, this.oracleHour(this.tmpBytes));
            var4.set(12, this.oracleMin(this.tmpBytes));
            var4.set(13, this.oracleSec(this.tmpBytes));
            var4.set(14, 0);
            if (var3 > 0 && var4.isSet(0)) {
                var4.set(0, 1);
            }

            return new Time(var4.getTimeInMillis());
        }
    }

    Timestamp getTimestamp(int var1) throws SQLException {
        return this.getTimestamp(var1, (Calendar)null);
    }

    Timestamp getTimestamp(int var1, Calendar var2) throws SQLException {
        if (this.isNull(var1)) {
            return null;
        } else {
            Calendar var3;
            if (var2 == null) {
                var3 = this.statement.getDefaultCalendar();
            } else {
                var3 = (Calendar)((Calendar)var2.clone());
            }

            this.getBytesInternal(var1, this.tmpBytes);
            int var4 = this.oracleYear(this.tmpBytes);
            var3.set(1, var4);
            var3.set(2, this.oracleMonth(this.tmpBytes));
            var3.set(5, this.oracleDay(this.tmpBytes));
            var3.set(11, this.oracleHour(this.tmpBytes));
            var3.set(12, this.oracleMin(this.tmpBytes));
            var3.set(13, this.oracleSec(this.tmpBytes));
            var3.set(14, 0);
            if (var4 > 0 && var3.isSet(0)) {
                var3.set(0, 1);
            }

            Timestamp var5 = new Timestamp(var3.getTimeInMillis());
            if (this.getLength(var1) >= 11) {
                var5.setNanos(this.oracleNanos(this.tmpBytes));
            }

            return var5;
        }
    }

    DATE getDATE(int var1) throws SQLException {
        if (this.isNull(var1)) {
            return null;
        } else {
            byte[] var2 = new byte[7];
            this.rowData.get(this.getOffset(var1), var2, 0, 7);
            return new DATE(var2);
        }
    }

    TIMESTAMP getTIMESTAMP(int var1) throws SQLException {
        return this.isNull(var1) ? null : new TIMESTAMP(this.getBytesInternal(var1));
    }

    java.util.Date getJavaUtilDate(int var1) throws SQLException {
        if (this.isNull(var1)) {
            return null;
        } else {
            java.util.Date var2 = null;
            this.getBytesInternal(var1, this.tmpBytes);
            int var3 = this.oracleYear(this.tmpBytes);
            Calendar var4 = this.statement.getDefaultCalendar();
            var4.set(1, var3);
            var4.set(2, this.oracleMonth(this.tmpBytes));
            var4.set(5, this.oracleDay(this.tmpBytes));
            var4.set(11, this.oracleHour(this.tmpBytes));
            var4.set(12, this.oracleMin(this.tmpBytes));
            var4.set(13, this.oracleSec(this.tmpBytes));
            var4.set(14, 0);
            if (var3 > 0 && var4.isSet(0)) {
                var4.set(0, 1);
            }

            var2 = var4.getTime();
            return var2;
        }
    }

    Calendar getCalendar(int var1) throws SQLException {
        if (this.isNull(var1)) {
            return null;
        } else {
            this.getBytesInternal(var1, this.tmpBytes);
            int var2 = this.oracleYear(this.tmpBytes);
            Calendar var3 = (Calendar)((Calendar)this.statement.getDefaultCalendar().clone());
            var3.set(1, var2);
            var3.set(2, this.oracleMonth(this.tmpBytes));
            var3.set(5, this.oracleDay(this.tmpBytes));
            var3.set(11, this.oracleHour(this.tmpBytes));
            var3.set(12, this.oracleMin(this.tmpBytes));
            var3.set(13, this.oracleSec(this.tmpBytes));
            if (this.getLength(var1) >= 11) {
                var3.set(14, this.oracleNanos(this.tmpBytes) / 1000);
            } else {
                var3.set(14, 0);
            }

            if (var2 > 0 && var3.isSet(0)) {
                var3.set(0, 1);
            }

            return var3;
        }
    }

    final int oracleYear(byte[] var1) {
        int var2 = ((var1[0] & 255) - 100) * 100 + (var1[1] & 255) - 100;
        return var2 <= 0 ? var2 + 1 : var2;
    }

    final int oracleMonth(byte[] var1) {
        return var1[2] - 1;
    }

    final int oracleDay(byte[] var1) {
        return var1[3];
    }

    final int oracleHour(byte[] var1) {
        return var1[4] - 1;
    }

    final int oracleMin(byte[] var1) {
        return var1[5] - 1;
    }

    final int oracleSec(byte[] var1) {
        return var1[6] - 1;
    }

    final int oracleTZ1(byte[] var1) {
        return var1[11];
    }

    final int oracleTZ2(byte[] var1) {
        return var1[12];
    }

    final int oracleTime(byte[] var1) {
        int var2 = this.oracleHour(var1);
        var2 *= 60;
        var2 += this.oracleMin(var1);
        var2 *= 60;
        var2 += this.oracleSec(var1);
        var2 *= 1000;
        return var2;
    }

    final int oracleNanos(byte[] var1) {
        int var2 = (var1[7] & 255) << 24;
        var2 |= (var1[8] & 255) << 16;
        var2 |= (var1[9] & 255) << 8;
        var2 |= var1[10] & 255 & 255;
        return var2;
    }

    static final long computeJulianDay(boolean var0, int var1, int var2, int var3) {
        boolean var4 = var1 % 4 == 0;
        int var5 = var1 - 1;
        long var6 = 365L * (long)var5 + floorDivide((long)var5, 4L) + 1721423L;
        if (var0) {
            var4 = var4 && (var1 % 100 != 0 || var1 % 400 == 0);
            var6 += floorDivide((long)var5, 400L) - floorDivide((long)var5, 100L) + 2L;
        }

        return var6 + (long)var3 + (long)(var4 ? LEAP_NUM_DAYS[var2] : NUM_DAYS[var2]);
    }

    static final long floorDivide(long var0, long var2) {
        return var0 >= 0L ? var0 / var2 : (var0 + 1L) / var2 - 1L;
    }

    static final long julianDayToMillis(long var0) {
        return (var0 - 2440588L) * 86400000L;
    }

    static final long zoneOffset(TimeZone var0, int var1, int var2, int var3, int var4, int var5) {
        return (long)var0.getOffset(var1 < 0 ? 0 : 1, var1, var2, var3, var4, var5);
    }

    static long getMillis(int var0, int var1, int var2, int var3, TimeZone var4) {
        boolean var5 = var0 >= 1582;
        long var6 = computeJulianDay(var5, var0, var1, var2);
        long var8 = (var6 - 2440588L) * 86400000L;
        if (var5 != var8 >= -12219292800000L) {
            var6 = computeJulianDay(!var5, var0, var1, var2);
            var8 = (var6 - 2440588L) * 86400000L;
        }

        var8 += (long)var3;
        return var8 - zoneOffset(var4, var0, var1, var2, julianDayToDayOfWeek(var6), var3);
    }

    static final int julianDayToDayOfWeek(long var0) {
        int var2 = (int)((var0 + 1L) % 7L);
        return var2 + (var2 < 0 ? 8 : 1);
    }

    static long calculateEpochOffset(TimeZone var0) {
        return zoneOffset(var0, 1970, 0, 1, 5, 0);
    }

    String toText(int var1, int var2, int var3, int var4, int var5, int var6, int var7, boolean var8, String var9) throws SQLException {
        return oracle.sql.TIMESTAMPTZ.toString(var1, var2, var3, var4, var5, var6, var7, var9);
    }
}
