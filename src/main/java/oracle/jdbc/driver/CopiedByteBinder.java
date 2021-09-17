package oracle.jdbc.driver;

class CopiedByteBinder extends Binder {
   byte[] value;
   short len;
   private static final String _Copyright_2007_Oracle_All_Rights_Reserved_ = null;
   public static final String BUILD_DATE = "Thu_Apr_04_15:09:24_PDT_2013";
   public static final boolean TRACE = false;

   CopiedByteBinder(short var1, int var2, byte[] var3, short var4) {
      this.type = var1;
      this.bytelen = var2;
      this.value = var3;
      this.len = var4;
   }

   Binder copyingBinder() {
      return this;
   }

   long bind(OraclePreparedStatement var1, int var2, int var3, int var4, byte[] var5, char[] var6, short[] var7, int var8, int var9, int var10, int var11, int var12, int var13, boolean var14, long var15) {
      var7[var13] = 0;
      var7[var12] = this.len;
      System.arraycopy(this.value, 0, var5, var10, this.value.length);
      if (var1.connection.checksumMode.needToCalculateBindChecksum()) {
         CRC64 var10000 = PhysicalConnection.CHECKSUM;
         var15 = CRC64.updateChecksum(var15, (byte[])this.value, 0, this.value.length);
      }

      return var15;
   }
}
