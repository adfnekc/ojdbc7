package oracle.jdbc.driver;

class DateNullBinder extends DateBinder {
   private static final String _Copyright_2007_Oracle_All_Rights_Reserved_ = null;
   public static final String BUILD_DATE = "Thu_Apr_04_15:09:24_PDT_2013";
   public static final boolean TRACE = false;

   long bind(OraclePreparedStatement var1, int var2, int var3, int var4, byte[] var5, char[] var6, short[] var7, int var8, int var9, int var10, int var11, int var12, int var13, boolean var14, long var15) {
      var7[var13] = -1;
      if (var1.connection.checksumMode.needToCalculateBindChecksum()) {
         CRC64 var10000 = PhysicalConnection.CHECKSUM;
         var15 = CRC64.updateChecksum(var15, (byte[])Accessor.NULL_DATA_BYTES, 0, Accessor.NULL_DATA_BYTES.length);
      }

      return var15;
   }

   Binder copyingBinder() {
      return this;
   }
}
