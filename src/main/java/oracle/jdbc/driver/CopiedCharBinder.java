package oracle.jdbc.driver;

class CopiedCharBinder extends Binder {
   char[] value;
   short len;
   short inoutIndicatorValue;
   private static final String _Copyright_2007_Oracle_All_Rights_Reserved_ = null;
   public static final String BUILD_DATE = "Thu_Apr_04_15:09:24_PDT_2013";
   public static final boolean TRACE = false;

   CopiedCharBinder(short var1, char[] var2, short var3, short var4) {
      this.type = var1;
      this.bytelen = 0;
      this.value = var2;
      this.len = var3;
      this.inoutIndicatorValue = var4;
   }

   Binder copyingBinder() {
      return this;
   }

   long bind(OraclePreparedStatement var1, int var2, int var3, int var4, byte[] var5, char[] var6, short[] var7, int var8, int var9, int var10, int var11, int var12, int var13, boolean var14, long var15) {
      var7[var13] = 0;
      var7[var12] = this.len;
      System.arraycopy(this.value, 0, var6, var11, this.value.length);
      if (var1.connection.checksumMode.needToCalculateBindChecksum()) {
         CRC64 var10000 = PhysicalConnection.CHECKSUM;
         var15 = CRC64.updateChecksum(var15, (char[])this.value, 0, this.value.length);
      }

      return var15;
   }

   short updateInoutIndicatorValue(short var1) {
      return this.inoutIndicatorValue;
   }
}
