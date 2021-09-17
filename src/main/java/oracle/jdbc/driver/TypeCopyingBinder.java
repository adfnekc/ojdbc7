package oracle.jdbc.driver;

abstract class TypeCopyingBinder extends Binder {
   private static final String _Copyright_2007_Oracle_All_Rights_Reserved_ = null;
   public static final String BUILD_DATE = "Thu_Apr_04_15:09:24_PDT_2013";
   public static final boolean TRACE = false;

   Binder copyingBinder() {
      return this;
   }

   long bind(OraclePreparedStatement var1, int var2, int var3, int var4, byte[] var5, char[] var6, short[] var7, int var8, int var9, int var10, int var11, int var12, int var13, boolean var14, long var15) {
      if (var3 == 0) {
         var1.parameterDatum[0][var2] = var1.lastBoundTypeBytes[var2];
         var1.parameterOtype[0][var2] = var1.lastBoundTypeOtypes[var2];
      } else {
         var1.parameterDatum[var3][var2] = var1.parameterDatum[var3 - 1][var2];
         var1.parameterOtype[var3][var2] = var1.parameterOtype[var3 - 1][var2];
      }

      if (var1.connection.checksumMode.needToCalculateBindChecksum()) {
         CRC64 var10000;
         if (var1.parameterDatum[var3][var2] == null) {
            var10000 = PhysicalConnection.CHECKSUM;
            var15 = CRC64.updateChecksum(var15, (byte[])Accessor.NULL_DATA_BYTES, 0, Accessor.NULL_DATA_BYTES.length);
         } else {
            byte[] var17 = var1.parameterDatum[var3][var2];
            var10000 = PhysicalConnection.CHECKSUM;
            var15 = CRC64.updateChecksum(var15, (byte[])var17, 0, var17.length);
         }
      }

      return var15;
   }
}
