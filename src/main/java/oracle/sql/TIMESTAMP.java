//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package oracle.sql;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.TimeZone;

public class TIMESTAMP extends Datum implements Serializable {
    static final int CENTURY_DEFAULT = 119;
    static final int DECADE_DEFAULT = 100;
    static final int MONTH_DEFAULT = 1;
    static final int DAY_DEFAULT = 1;
    static final int DECADE_INIT = 170;
    static final int JAVA_YEAR = 1970;
    static final int JAVA_MONTH = 0;
    static final int JAVA_DATE = 1;
    public static final int SIZE_DATE = 7;
    public static final int SIZE_TIMESTAMP = 11;
    public static final int SIZE_TIMESTAMP_NOFRAC = 7;
    static final int SIZE_TIMESTAMPTZ = 13;
    static final int MINYEAR = -4712;
    static final int MAXYEAR = 9999;
    static final int JANMONTH = 1;
    static final int DECMONTH = 12;
    static final int MINDAYS = 1;
    static final int MAXDAYS = 31;
    static final int MINHOURS = 1;
    static final int MAXHOURS = 24;
    static final int MINMINUTES = 1;
    static final int MAXMINUTES = 60;
    static final int MINSECONDS = 1;
    static final int MAXSECONDS = 60;
    static final int[] daysInMonth = new int[]{31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    static final long serialVersionUID = -7964732752952728545L;
    private static final String _Copyright_2007_Oracle_All_Rights_Reserved_ = null;
    public static final String BUILD_DATE = "Thu_Apr_04_15:09:24_PDT_2013";
    public static final boolean TRACE = false;

    public TIMESTAMP() {
        super(initTimestamp());
    }

    public TIMESTAMP(byte[] var1) {
        super(var1);
    }

    public TIMESTAMP(Time var1) {
        super(toBytes(var1));
    }

    public TIMESTAMP(Date var1) {
        super(toBytes(var1));
    }

    public TIMESTAMP(Timestamp var1) {
        super(toBytes(var1));
    }

    public TIMESTAMP(Timestamp var1, Calendar var2) {
        super(toBytes(var1, var2));
    }

    public TIMESTAMP(DATE var1) {
        super(toBytes(var1));
    }

    public static final int getNanos(byte[] var0, int var1) {
        int var2 = (var0[var1] & 255) << 24;
        var2 |= (var0[var1 + 1] & 255) << 16;
        var2 |= (var0[var1 + 2] & 255) << 8;
        var2 |= var0[var1 + 3] & 255 & 255;
        return var2;
    }

    public TIMESTAMP(String var1) {
        super(toBytes(var1));
    }

    public static Date toDate(byte[] var0) throws SQLException {
        int var2 = var0.length;
        int[] var1;
        if (var2 == 11) {
            var1 = new int[11];
        } else {
            var1 = new int[7];
        }

        int var3;
        for(var3 = 0; var3 < var0.length; ++var3) {
            var1[var3] = var0[var3] & 255;
        }

        var3 = getJavaYear(var1[0], var1[1]);
        Calendar var4 = Calendar.getInstance();
        var4.set(1, var3);
        var4.set(2, var1[2] - 1);
        var4.set(5, var1[3]);
        var4.set(11, var1[4] - 1);
        var4.set(12, var1[5] - 1);
        var4.set(13, var1[6] - 1);
        int var5 = 0;
        if (var2 == 11) {
            var5 = getNanos(var0, 7) / 1000;
        }

        var4.set(14, var5);
        long var6 = var4.getTime().getTime();
        return new Date(var6);
    }

    public static Time toTime(byte[] var0) throws SQLException {
        int var1 = var0[4] & 255;
        int var2 = var0[5] & 255;
        int var3 = var0[6] & 255;
        return new Time(var1 - 1, var2 - 1, var3 - 1);
    }

    public static Timestamp toTimestamp(byte[] var0) throws SQLException {
        return toTimestamp(var0, (Calendar)null);
    }

    public static Timestamp toTimestamp(byte[] var0, Calendar var1) throws SQLException {
        int var3 = var0.length;
        int[] var2;
        if (var3 == 11) {
            var2 = new int[11];
        } else {
            var2 = new int[7];
        }

        int var4;
        for(var4 = 0; var4 < var0.length; ++var4) {
            var2[var4] = var0[var4] & 255;
        }

        var4 = getJavaYear(var2[0], var2[1]);
        Calendar var5;
        if (var1 == null) {
            var5 = Calendar.getInstance();
        } else {
            var5 = Calendar.getInstance(var1.getTimeZone());
        }

        var5.clear();
        var5.set(1, var4);
        var5.set(2, var2[2] - 1);
        var5.set(5, var2[3]);
        var5.set(11, var2[4] - 1);
        var5.set(12, var2[5] - 1);
        var5.set(13, var2[6] - 1);
        var5.set(14, 0);
        long var6 = var5.getTime().getTime();
        Timestamp var8 = new Timestamp(var6);
        int var9 = 0;
        if (var3 == 11) {
            var9 = getNanos(var0, 7);
        }

        var8.setNanos(var9);
        return var8;
    }

    public static DATE toDATE(byte[] var0) throws SQLException {
        byte[] var1 = new byte[7];
        System.arraycopy(var0, 0, var1, 0, 7);
        return new DATE(var1);
    }

    public Timestamp timestampValue() throws SQLException {
        return toTimestamp(this.getBytes());
    }

    public Timestamp timestampValue(Calendar var1) throws SQLException {
        return toTimestamp(this.getBytes(), var1);
    }

    public static String toString(byte[] var0) {
        int[] var1 = new int[var0.length];

        int var2;
        for(var2 = 0; var2 < var0.length; ++var2) {
            if (var0[var2] < 0) {
                var1[var2] = var0[var2] + 256;
            } else {
                var1[var2] = var0[var2];
            }
        }

        var2 = getJavaYear(var1[0], var1[1]);
        int var3 = var1[2];
        int var4 = var1[3];
        int var5 = var1[4] - 1;
        int var6 = var1[5] - 1;
        int var7 = var1[6] - 1;
        int var8 = 0;
        if (var0.length > 7) {
            var8 = getNanos(var0, 7);
        }

        return TIMESTAMPTZ.toString(var2, var3, var4, var5, var6, var7, var8, (String)null);
    }

    public byte[] toBytes() {
        return this.getBytes();
    }

    public static byte[] toBytes(Time var0) {
        if (var0 == null) {
            return null;
        } else {
            byte[] var1 = new byte[7];
            Calendar var2 = Calendar.getInstance();
            var2.setTime(var0);
            var1[0] = 119;
            var1[1] = -86;
            var1[2] = 1;
            var1[3] = 1;
            var1[4] = (byte)(var2.get(11) + 1);
            var1[5] = (byte)(var2.get(12) + 1);
            var1[6] = (byte)(var2.get(13) + 1);
            return var1;
        }
    }

    public static byte[] toBytes(Date var0) {
        if (var0 == null) {
            return null;
        } else {
            byte[] var1 = new byte[7];
            Calendar var2 = Calendar.getInstance();
            var2.setTime(var0);
            int var3 = getOracleYear(var2);
            var1[0] = (byte)(var3 / 100 + 100);
            var1[1] = (byte)(var3 % 100 + 100);
            var1[2] = (byte)(var2.get(2) + 1);
            var1[3] = (byte)var2.get(5);
            var1[4] = (byte)(var2.get(11) + 1);
            var1[5] = (byte)(var2.get(12) + 1);
            var1[6] = (byte)(var2.get(13) + 1);
            return var1;
        }
    }

    public static byte[] toBytes(Timestamp var0) {
        return toBytes(var0, (Calendar)null);
    }

    public static byte[] toBytes(Timestamp var0, Calendar var1) {
        if (var0 == null) {
            return null;
        } else {
            int var2 = var0.getNanos();
            byte[] var3;
            if (var2 == 0) {
                var3 = new byte[7];
            } else {
                var3 = new byte[11];
            }

            Calendar var4;
            if (var1 == null) {
                var4 = Calendar.getInstance();
            } else {
                var4 = Calendar.getInstance(var1.getTimeZone());
            }

            var4.setTime(var0);
            int var5 = getOracleYear(var4);
            var3[0] = (byte)(var5 / 100 + 100);
            var3[1] = (byte)(var5 % 100 + 100);
            var3[2] = (byte)(var4.get(2) + 1);
            var3[3] = (byte)var4.get(5);
            var3[4] = (byte)(var4.get(11) + 1);
            var3[5] = (byte)(var4.get(12) + 1);
            var3[6] = (byte)(var4.get(13) + 1);
            if (var2 != 0) {
                var3[7] = (byte)(var2 >> 24);
                var3[8] = (byte)(var2 >> 16 & 255);
                var3[9] = (byte)(var2 >> 8 & 255);
                var3[10] = (byte)(var2 & 255);
            }

            return var3;
        }
    }

    public static byte[] toBytes(DATE var0) {
        if (var0 == null) {
            return null;
        } else {
            byte[] var1 = new byte[7];
            System.arraycopy(var0.getBytes(), 0, var1, 0, 7);
            return var1;
        }
    }

    public static byte[] toBytes(String var0) {
        return toBytes(Timestamp.valueOf(var0));
    }

    public Object toJdbc() throws SQLException {
        return this.timestampValue();
    }

    public Object makeJdbcArray(int var1) {
        Timestamp[] var2 = new Timestamp[var1];
        return var2;
    }

    public boolean isConvertibleTo(Class var1) {
        return var1.getName().compareTo("java.sql.Date") == 0 || var1.getName().compareTo("java.sql.Time") == 0 || var1.getName().compareTo("java.sql.Timestamp") == 0 || var1.getName().compareTo("java.lang.String") == 0;
    }

    public static TIMESTAMP TimeZoneConvert(Connection var0, TIMESTAMP var1, TimeZone var2, TimeZone var3) throws SQLException {
        byte[] var5 = var1.getBytes();
        int var6 = var5.length;
        int[] var4;
        if (var6 == 11) {
            var4 = new int[11];
        } else {
            var4 = new int[7];
        }

        int var7;
        for(var7 = 0; var7 < var6; ++var7) {
            var4[var7] = var5[var7] & 255;
        }

        var7 = getJavaYear(var4[0], var4[1]);
        int var8 = var4[2] - 1;
        int var9 = var4[3];
        int var10 = var4[4] - 1;
        int var11 = var4[5] - 1;
        int var12 = var4[6] - 1;
        Calendar var13 = Calendar.getInstance(var2);
        var13.set(1, var7);
        var13.set(2, var8);
        var13.set(5, var9);
        var13.set(11, var10);
        var13.set(12, var11);
        var13.set(13, var12);
        var13.set(14, 0);
        long var14 = var13.getTimeInMillis();
        Timestamp var16 = new Timestamp(var14);
        int var17 = 0;
        if (var6 == 11) {
            var17 = getNanos(var5, 7);
        }

        var16.setNanos(var17);
        Calendar var18 = Calendar.getInstance(var3);
        return new TIMESTAMP(var16, var18);
    }

    public String stringValue() {
        return toString(this.getBytes());
    }

    public String toString() {
        return this.stringValue();
    }

    public static int getOracleYear(Calendar var0) {
        int var1 = var0.get(1);
        if (var0.get(0) == 0) {
            var1 = -var1;
        }

        if (var1 >= -4712 && var1 <= 9999) {
            return var1;
        } else {
            throw new IllegalArgumentException("Invalid year value");
        }
    }

    public Date dateValue() throws SQLException {
        return toDate(this.getBytes());
    }

    public Time timeValue() throws SQLException {
        return toTime(this.getBytes());
    }

    public static int getJavaYear(int var0, int var1) {
        int var2 = (var0 - 100) * 100 + (var1 - 100);
        if (var2 <= 0) {
            ++var2;
        }

        return var2;
    }

    private static byte[] initTimestamp() {
        byte[] var0 = new byte[11];
        var0[0] = 119;
        var0[1] = -86;
        var0[2] = 1;
        var0[3] = 1;
        var0[4] = 1;
        var0[5] = 1;
        var0[6] = 1;
        return var0;
    }

    private boolean isLeapYear(int var1) {
        boolean var10000;
        label28: {
            if (var1 % 4 == 0) {
                if (var1 <= 1582) {
                    if (var1 != -4712) {
                        break label28;
                    }
                } else if (var1 % 100 != 0 || var1 % 400 == 0) {
                    break label28;
                }
            }

            var10000 = false;
            return var10000;
        }

        var10000 = true;
        return var10000;
    }

    private boolean isValid() {
        byte[] var1 = this.getBytes();
        if (var1.length != 11 && var1.length != 7) {
            return false;
        } else {
            int var2 = ((var1[0] & 255) - 100) * 100 + ((var1[1] & 255) - 100);
            if (var2 >= -4712 && var2 <= 9999) {
                if (var2 == 0) {
                    return false;
                } else {
                    int var3 = var1[2] & 255;
                    if (var3 >= 1 && var3 <= 12) {
                        int var4 = var1[3] & 255;
                        if (var4 >= 1 && var4 <= 31) {
                            if (var4 <= daysInMonth[var3 - 1] || this.isLeapYear(var2) && var3 == 2 && var4 == 29) {
                                if (var2 == 1582 && var3 == 10 && var4 >= 5 && var4 < 15) {
                                    return false;
                                } else {
                                    int var5 = var1[4] & 255;
                                    if (var5 >= 1 && var5 <= 24) {
                                        int var6 = var1[5] & 255;
                                        if (var6 >= 1 && var6 <= 60) {
                                            int var7 = var1[6] & 255;
                                            return var7 >= 1 && var7 <= 60;
                                        } else {
                                            return false;
                                        }
                                    } else {
                                        return false;
                                    }
                                }
                            } else {
                                return false;
                            }
                        } else {
                            return false;
                        }
                    } else {
                        return false;
                    }
                }
            } else {
                return false;
            }
        }
    }

    private void readObject(ObjectInputStream var1) throws IOException, ClassNotFoundException {
        var1.defaultReadObject();
        if (!this.isValid()) {
            throw new IOException("Invalid TIMESTAMP");
        }
    }
}
