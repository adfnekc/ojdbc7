package oracle.jdbc.driver;

import java.sql.SQLException;
import java.util.Calendar;
import java.util.TimeZone;

abstract class DateCommonBinder extends Binder {
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
   static final int[] MONTH_LENGTH = new int[]{31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
   static final int[] LEAP_MONTH_LENGTH = new int[]{31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
   static final int ORACLE_DATE_CENTURY = 0;
   static final int ORACLE_DATE_YEAR = 1;
   static final int ORACLE_DATE_MONTH = 2;
   static final int ORACLE_DATE_DAY = 3;
   static final int ORACLE_DATE_HOUR = 4;
   static final int ORACLE_DATE_MIN = 5;
   static final int ORACLE_DATE_SEC = 6;
   static final int ORACLE_DATE_NANO1 = 7;
   static final int ORACLE_DATE_NANO2 = 8;
   static final int ORACLE_DATE_NANO3 = 9;
   static final int ORACLE_DATE_NANO4 = 10;
   private static int HOUR_MILLISECOND = 3600000;
   private static int MINUTE_MILLISECOND = 60000;
   private static int SECOND_MILLISECOND = 1000;
   private static final String _Copyright_2007_Oracle_All_Rights_Reserved_ = null;
   public static final String BUILD_DATE = "Thu_Apr_04_15:09:24_PDT_2013";
   public static final boolean TRACE = false;

   static final long floorDivide(long var0, long var2) {
      return var0 >= 0L ? var0 / var2 : (var0 + 1L) / var2 - 1L;
   }

   static final int floorDivide(int var0, int var1) {
      return var0 >= 0 ? var0 / var1 : (var0 + 1) / var1 - 1;
   }

   static final int floorDivide(int var0, int var1, int[] var2) {
      if (var0 >= 0) {
         var2[0] = var0 % var1;
         return var0 / var1;
      } else {
         int var3 = (var0 + 1) / var1 - 1;
         var2[0] = var0 - var3 * var1;
         return var3;
      }
   }

   static final int floorDivide(long var0, int var2, int[] var3) {
      if (var0 >= 0L) {
         var3[0] = (int)(var0 % (long)var2);
         return (int)(var0 / (long)var2);
      } else {
         int var4 = (int)((var0 + 1L) / (long)var2 - 1L);
         var3[0] = (int)(var0 - (long)(var4 * var2));
         return var4;
      }
   }

   static final long zoneOffset(TimeZone var0, int var1, int var2, int var3, int var4, int var5) {
      return (long)var0.getOffset(var1 < 0 ? 0 : 1, var1, var2, var3, var4, var5);
   }

   static void setOracleNanos(long var0, byte[] var2, int var3) {
      var2[10 + var3] = (byte)((int)(var0 & 255L));
      var2[9 + var3] = (byte)((int)(var0 >> 8 & 255L));
      var2[8 + var3] = (byte)((int)(var0 >> 16 & 255L));
      var2[7 + var3] = (byte)((int)(var0 >> 24 & 255L));
   }

   static void setOracleHMS(int var0, byte[] var1, int var2) {
      if (var0 < 0) {
         throw new RuntimeException("Assertion botch: negative time");
      } else {
         var0 /= 1000;
         var1[6 + var2] = (byte)(var0 % 60 + 1);
         var0 /= 60;
         var1[5 + var2] = (byte)(var0 % 60 + 1);
         var0 /= 60;
         var1[4 + var2] = (byte)(var0 + 1);
      }
   }

   static final int setOracleCYMD(long var0, byte[] var2, int var3, OraclePreparedStatement var4) throws SQLException {
      TimeZone var12 = var4.getDefaultTimeZone(true);
      Calendar var13 = var4.cachedUTCUSCalendar;
      var13.setTimeInMillis(var0);
      Calendar var14 = var4.getDefaultCalendar();
      var14.setTimeInMillis(var0);
      int var11 = var14.get(15);
      long var23 = var0 + (long)var11;
      int var5;
      int var8;
      int var9;
      boolean var10;
      long var15;
      int var19;
      long var25;
      if (var23 >= -12219292800000L) {
         var15 = 2440588L + floorDivide(var23, 86400000L) - 1721426L;
         int var17;
         int var18;
         int var20;
         if (var15 > 0L) {
            var17 = (int)(var15 / 146097L);
            var9 = (int)(var15 % 146097L);
            var18 = var9 / '躬';
            var9 %= 36524;
            var19 = var9 / 1461;
            var9 %= 1461;
            var20 = var9 / 365;
            var9 %= 365;
         } else {
            int[] var21 = new int[1];
            var17 = floorDivide(var15, 146097, var21);
            var18 = floorDivide(var21[0], 36524, var21);
            var19 = floorDivide(var21[0], 1461, var21);
            var20 = floorDivide(var21[0], 365, var21);
            var9 = var21[0];
         }

         var5 = 400 * var17 + 100 * var18 + 4 * var19 + var20;
         if (var18 != 4 && var20 != 4) {
            ++var5;
         } else {
            var9 = 365;
         }

         var10 = (var5 & 3) == 0 && (var5 % 100 != 0 || var5 % 400 == 0);
         var8 = (int)((var15 + 1L) % 7L);
      } else {
         var15 = 2440588L + floorDivide(var23, 86400000L) - 1721424L;
         var5 = (int)floorDivide(4L * var15 + 1464L, 1461L);
         var25 = (long)(365 * (var5 - 1) + floorDivide(var5 - 1, 4));
         var9 = (int)(var15 - var25);
         var10 = (var5 & 3) == 0;
         var8 = (int)((var15 - 1L) % 7L);
      }

      int var24 = 0;
      int var16 = var10 ? 60 : 59;
      if (var9 >= var16) {
         var24 = var10 ? 1 : 2;
      }

      int var6 = (12 * (var9 + var24) + 6) / 367;
      int var7 = var9 - (var10 ? LEAP_NUM_DAYS[var6] : NUM_DAYS[var6]) + 1;
      var8 += var8 < 0 ? 8 : 1;
      var25 = var23 / 86400000L;
      var19 = (int)(var23 - var25 * 86400000L);
      if (var19 < 0) {
         var19 = (int)((long)var19 + 86400000L);
      }

      long var26 = zoneOffset(var12, var5, var6, var7, var8, var19);
      var26 -= (long)var11;
      var19 = (int)((long)var19 + var26);
      if ((long)var19 >= 86400000L) {
         var19 = (int)((long)var19 - 86400000L);
         ++var7;
         if (var7 > (var10 ? LEAP_MONTH_LENGTH[var6] : MONTH_LENGTH[var6])) {
            var7 = 1;
            ++var6;
            if (var6 == 12) {
               var6 = 0;
               ++var5;
            }
         }
      }

      if (var5 <= 0) {
         --var5;
      }

      if (var5 <= 9999 && var5 >= -4712) {
         var2[0 + var3] = (byte)(var5 / 100 + 100);
         var2[1 + var3] = (byte)(var5 % 100 + 100);
         var2[2 + var3] = (byte)(var6 + 1);
         var2[3 + var3] = (byte)var7;
         return var19;
      } else {
         SQLException var22 = DatabaseError.createSqlException((oracle.jdbc.internal.OracleConnection)null, 268);
         var22.fillInStackTrace();
         throw var22;
      }
   }
}
