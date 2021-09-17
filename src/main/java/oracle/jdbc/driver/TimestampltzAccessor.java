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
import oracle.sql.OffsetDST;
import oracle.sql.TIMESTAMP;
import oracle.sql.TIMESTAMPLTZ;
import oracle.sql.TIMESTAMPTZ;
import oracle.sql.TIMEZONETAB;
import oracle.sql.ZONEIDMAP;

class TimestampltzAccessor extends DateTimeCommonAccessor {
    static final int MAXLENGTH = 11;
    private static final String _Copyright_2007_Oracle_All_Rights_Reserved_ = null;
    public static final String BUILD_DATE = "Thu_Apr_04_15:09:24_PDT_2013";
    public static final boolean TRACE = false;

    TimestampltzAccessor(OracleStatement var1, int var2, short var3, int var4, boolean var5) throws SQLException {
        super(Representation.TIMESTAMPLTZ, var1, 11, var5);
        this.init(var1, 231, 231, var3, var5);
        this.initForDataAccess(var4, var2, (String)null);
    }

    TimestampltzAccessor(OracleStatement var1, int var2, boolean var3, int var4, int var5, int var6, int var7, int var8, short var9) throws SQLException {
        super(Representation.TIMESTAMPLTZ, var1, 11, false);
        this.init(var1, 231, 231, var9, false);
        this.initForDescribe(231, var2, var3, var4, var5, var6, var7, var8, var9, (String)null);
        this.initForDataAccess(0, var2, (String)null);
    }

    String getString(int var1) throws SQLException {
        if (this.isNull(var1)) {
            return null;
        } else {
            Calendar var2 = this.statement.connection.getDbTzCalendar();
            String var3 = this.statement.connection.getSessionTimeZone();
            if (var3 == null) {
                SQLException var15 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 198);
                var15.fillInStackTrace();
                throw var15;
            } else {
                TimeZone var4 = TimeZone.getTimeZone(var3);
                Calendar var5 = Calendar.getInstance(var4);
                this.getBytesInternal(var1, this.tmpBytes);
                int var6 = this.oracleYear(this.tmpBytes);
                var2.set(1, var6);
                var2.set(2, this.oracleMonth(this.tmpBytes));
                var2.set(5, this.oracleDay(this.tmpBytes));
                var2.set(11, this.oracleHour(this.tmpBytes));
                var2.set(12, this.oracleMin(this.tmpBytes));
                var2.set(13, this.oracleSec(this.tmpBytes));
                var2.set(14, 0);
                this.TimeZoneAdjust(var2, var5);
                var6 = var5.get(1);
                int var7 = var5.get(2) + 1;
                int var8 = var5.get(5);
                int var9 = var5.get(11);
                int var10 = var5.get(12);
                int var11 = var5.get(13);
                int var12 = 0;
                boolean var13 = var9 < 12;
                String var14 = var5.getTimeZone().getID();
                if (var14.length() > 3 && var14.startsWith("GMT")) {
                    var14 = var14.substring(3);
                }

                if (this.getLength(var1) == 11) {
                    var12 = this.oracleNanos(this.tmpBytes);
                }

                return this.toText(var6, var7, var8, var9, var10, var11, var12, var13, var14);
            }
        }
    }

    Date getDate(int var1, Calendar var2) throws SQLException {
        return this.getDate(var1);
    }

    Date getDate(int var1) throws SQLException {
        if (this.isNull(var1)) {
            return null;
        } else {
            Calendar var2 = this.statement.connection.getDbTzCalendar();
            String var3 = this.statement.connection.getSessionTimeZone();
            if (var3 == null) {
                SQLException var9 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 198);
                var9.fillInStackTrace();
                throw var9;
            } else {
                TimeZone var4 = TimeZone.getTimeZone(var3);
                Calendar var5 = Calendar.getInstance(var4);
                this.getBytesInternal(var1, this.tmpBytes);
                int var6 = this.oracleYear(this.tmpBytes);
                var2.set(1, var6);
                var2.set(2, this.oracleMonth(this.tmpBytes));
                var2.set(5, this.oracleDay(this.tmpBytes));
                var2.set(11, this.oracleHour(this.tmpBytes));
                var2.set(12, this.oracleMin(this.tmpBytes));
                var2.set(13, this.oracleSec(this.tmpBytes));
                var2.set(14, 0);
                long var7 = this.TimeZoneAdjustUTC(var2);
                return new Date(var7);
            }
        }
    }

    Time getTime(int var1, Calendar var2) throws SQLException {
        return this.getTime(var1);
    }

    Time getTime(int var1) throws SQLException {
        if (this.isNull(var1)) {
            return null;
        } else {
            Calendar var2 = this.statement.connection.getDbTzCalendar();
            String var3 = this.statement.connection.getSessionTimeZone();
            if (var3 == null) {
                SQLException var9 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 198);
                var9.fillInStackTrace();
                throw var9;
            } else {
                TimeZone var4 = TimeZone.getTimeZone(var3);
                Calendar var5 = Calendar.getInstance(var4);
                this.getBytesInternal(var1, this.tmpBytes);
                int var6 = this.oracleYear(this.tmpBytes);
                var2.set(1, var6);
                var2.set(2, this.oracleMonth(this.tmpBytes));
                var2.set(5, this.oracleDay(this.tmpBytes));
                var2.set(11, this.oracleHour(this.tmpBytes));
                var2.set(12, this.oracleMin(this.tmpBytes));
                var2.set(13, this.oracleSec(this.tmpBytes));
                var2.set(14, 0);
                long var7 = this.TimeZoneAdjustUTC(var2);
                return new Time(var7);
            }
        }
    }

    Timestamp getTimestamp(int var1, Calendar var2) throws SQLException {
        return this.getTimestamp(var1);
    }

    Timestamp getTimestamp(int var1) throws SQLException {
        if (this.isNull(var1)) {
            return null;
        } else {
            Calendar var2 = this.statement.connection.getDbTzCalendar();
            String var3 = this.statement.connection.getSessionTimeZone();
            if (var3 == null) {
                SQLException var10 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 198);
                var10.fillInStackTrace();
                throw var10;
            } else {
                TimeZone var4 = TimeZone.getTimeZone(var3);
                Calendar var5 = Calendar.getInstance(var4);
                this.getBytesInternal(var1, this.tmpBytes);
                int var6 = this.oracleYear(this.tmpBytes);
                var2.set(1, var6);
                var2.set(2, this.oracleMonth(this.tmpBytes));
                var2.set(5, this.oracleDay(this.tmpBytes));
                var2.set(11, this.oracleHour(this.tmpBytes));
                var2.set(12, this.oracleMin(this.tmpBytes));
                var2.set(13, this.oracleSec(this.tmpBytes));
                var2.set(14, 0);
                long var7 = this.TimeZoneAdjustUTC(var2);
                Timestamp var9 = new Timestamp(var7);
                if (this.getLength(var1) == 11) {
                    var9.setNanos(this.oracleNanos(this.tmpBytes));
                }

                return var9;
            }
        }
    }

    Object getObject(int var1) throws SQLException {
        return this.getTIMESTAMPLTZ(var1);
    }

    Datum getOracleObject(int var1) throws SQLException {
        return this.getTIMESTAMPLTZ(var1);
    }

    Object getObject(int var1, Map var2) throws SQLException {
        return this.getTIMESTAMPLTZ(var1);
    }

    TIMESTAMPLTZ getTIMESTAMPLTZ(int var1) throws SQLException {
        return this.isNull(var1) ? null : new TIMESTAMPLTZ(this.getBytesInternal(var1));
    }

    TIMESTAMPTZ getTIMESTAMPTZ(int var1) throws SQLException {
        return this.isNull(var1) ? null : oracle.sql.TIMESTAMPLTZ.toTIMESTAMPTZ(this.statement.connection, this.getBytesInternal(var1));
    }

    TIMESTAMP getTIMESTAMP(int var1) throws SQLException {
        if (this.isNull(var1)) {
            return null;
        } else {
            TIMESTAMPTZ var2 = this.getTIMESTAMPTZ(var1);
            return oracle.sql.TIMESTAMPTZ.toTIMESTAMP(this.statement.connection, var2.getBytes());
        }
    }

    DATE getDATE(int var1) throws SQLException {
        if (this.isNull(var1)) {
            return null;
        } else {
            TIMESTAMPTZ var2 = this.getTIMESTAMPTZ(var1);
            return oracle.sql.TIMESTAMPTZ.toDATE(this.statement.connection, var2.getBytes());
        }
    }

    void TimeZoneAdjust(Calendar var1, Calendar var2) throws SQLException {
        String var4 = var1.getTimeZone().getID();
        String var5 = var2.getTimeZone().getID();
        int var8;
        int var9;
        if (!var5.equals(var4)) {
            OffsetDST var6 = new OffsetDST();
            this.getZoneOffset(var1, var6);
            var8 = var6.getOFFSET();
            var1.add(11, -(var8 / 3600000));
            var1.add(12, -(var8 % 3600000) / '\uea60');
            int var3;
            if (!var5.equals("Custom") && (!var5.startsWith("GMT") || var5.length() <= 3)) {
                var9 = ZONEIDMAP.getID(var5);
                if (!ZONEIDMAP.isValidID(var9)) {
                    SQLException var15 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 199);
                    var15.fillInStackTrace();
                    throw var15;
                }

                TIMEZONETAB var10 = this.statement.connection.getTIMEZONETAB();
                if (var10.checkID(var9)) {
                    var10.updateTable(this.statement.connection, var9);
                }

                Calendar var11 = (Calendar)((Calendar)this.statement.getGMTCalendar().clone());
                var11.set(0, var1.get(0));
                var11.set(1, var1.get(1));
                var11.set(2, var1.get(2));
                var11.set(5, var1.get(5));
                var11.set(11, var1.get(11));
                var11.set(12, var1.get(12));
                var11.set(13, var1.get(13));
                var11.set(14, var1.get(14));
                var3 = var10.getOffset(var11, var9);
            } else {
                var3 = var2.getTimeZone().getRawOffset();
            }

            var1.add(11, var3 / 3600000);
            var1.add(12, var3 % 3600000 / '\uea60');
        }

        int var7;
        int var13;
        if (var5.equals("Custom") && var4.equals("Custom") || var5.startsWith("GMT") && var5.length() > 3 && var4.startsWith("GMT") && var4.length() > 3) {
            var13 = var1.getTimeZone().getRawOffset();
            var7 = var2.getTimeZone().getRawOffset();
            var8 = 0;
            if (var13 != var7) {
                var8 = var13 - var7;
                var8 = var8 > 0 ? var8 : -var8;
            }

            if (var13 > var7) {
                var8 = -var8;
            }

            var1.add(11, var8 / 3600000);
            var1.add(12, var8 % 3600000 / '\uea60');
        }

        var13 = var1.get(1);
        var7 = var1.get(2);
        var8 = var1.get(5);
        var9 = var1.get(11);
        int var14 = var1.get(12);
        int var16 = var1.get(13);
        int var12 = var1.get(14);
        var2.set(0, var1.get(0));
        var2.set(1, var13);
        var2.set(2, var7);
        var2.set(5, var8);
        var2.set(11, var9);
        var2.set(12, var14);
        var2.set(13, var16);
        var2.set(14, var12);
    }

    long TimeZoneAdjustUTC(Calendar var1) throws SQLException {
        String var2 = var1.getTimeZone().getID();
        int var3;
        int var5;
        if (!var2.equals("Custom") && (!var2.startsWith("GMT") || var2.length() <= 3)) {
            if (!var2.equals("GMT") && !var2.equals("UTC")) {
                OffsetDST var13 = new OffsetDST();
                this.getZoneOffset(var1, var13);
                var5 = var13.getOFFSET();
                var1.add(11, -(var5 / 3600000));
                var1.add(12, -(var5 % 3600000) / '\uea60');
            }
        } else {
            var3 = var1.getTimeZone().getRawOffset();
            var1.add(11, -(var3 / 3600000));
            var1.add(12, -(var3 % 3600000) / '\uea60');
        }

        var3 = var1.get(1);
        int var4 = var1.get(2);
        var5 = var1.get(5);
        int var6 = var1.get(11);
        int var7 = var1.get(12);
        int var8 = var1.get(13);
        int var9 = var1.get(14);
        Calendar var10 = (Calendar)((Calendar)this.statement.getGMTCalendar().clone());
        var10.set(0, var1.get(0));
        var10.set(1, var3);
        var10.set(2, var4);
        var10.set(5, var5);
        var10.set(11, var6);
        var10.set(12, var7);
        var10.set(13, var8);
        var10.set(14, var9);
        long var11 = var10.getTimeInMillis();
        return var11;
    }

    byte getZoneOffset(Calendar var1, OffsetDST var2) throws SQLException {
        byte var3 = 0;
        String var4 = var1.getTimeZone().getID();
        if (var4 == "Custom" || var4.startsWith("GMT") && var4.length() > 3) {
            var2.setOFFSET(var1.getTimeZone().getRawOffset());
        } else {
            int var5 = ZONEIDMAP.getID(var4);
            if (!ZONEIDMAP.isValidID(var5)) {
                SQLException var7 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 199);
                var7.fillInStackTrace();
                throw var7;
            }

            TIMEZONETAB var6 = this.statement.connection.getTIMEZONETAB();
            if (var6.checkID(var5)) {
                var6.updateTable(this.statement.connection, var5);
            }

            var3 = var6.getLocalOffset(var1, var5, var2);
        }

        return var3;
    }
}
