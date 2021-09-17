package oracle.jdbc.driver;

import java.sql.SQLException;
import java.sql.Time;

class TimeBinder extends DateCommonBinder {
   Binder theTimeCopyingBinder;
   private static final String _Copyright_2007_Oracle_All_Rights_Reserved_ = null;
   public static final String BUILD_DATE = "Thu_Apr_04_15:09:24_PDT_2013";
   public static final boolean TRACE = false;

   static void init(Binder var0) {
      var0.type = 12;
      var0.bytelen = 7;
   }

   TimeBinder() {
      this.theTimeCopyingBinder = OraclePreparedStatementReadOnly.theStaticTimeCopyingBinder;
      init(this);
   }

   Binder copyingBinder() {
      return this.theTimeCopyingBinder;
   }

   long bind(OraclePreparedStatement var1, int var2, int var3, int var4, byte[] var5, char[] var6, short[] var7, int var8, int var9, int var10, int var11, int var12, int var13, boolean var14, long var15) throws SQLException {
      Time[] var17 = var1.parameterTime[var4];
      Time var18 = var17[var2];
      if (var14) {
         var17[var2] = null;
      }

      if (var18 == null) {
         var7[var13] = -1;
      } else {
         var7[var13] = 0;
         setOracleHMS(setOracleCYMD(var18.getTime(), var5, var10, var1), var5, var10);
         var5[0 + var10] = 119;
         var5[2 + var10] = 1;
         var5[3 + var10] = 1;
         if (var1.connection.use1900AsYearForTime) {
            var5[1 + var10] = 100;
         } else {
            var5[1 + var10] = -86;
         }

         var7[var12] = (short)var8;
      }

      if (var1.connection.checksumMode.needToCalculateBindChecksum()) {
         CRC64 var10000;
         if (var7[var13] == -1) {
            var10000 = PhysicalConnection.CHECKSUM;
            var15 = CRC64.updateChecksum(var15, (byte[])Accessor.NULL_DATA_BYTES, 0, Accessor.NULL_DATA_BYTES.length);
         } else {
            var10000 = PhysicalConnection.CHECKSUM;
            var15 = CRC64.updateChecksum(var15, var18.getTime());
         }
      }

      return var15;
   }
}
