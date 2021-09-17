package oracle.jdbc.driver;

class LongStreamBinder extends Binder {
   private static final String _Copyright_2007_Oracle_All_Rights_Reserved_ = null;
   public static final String BUILD_DATE = "Thu_Apr_04_15:09:24_PDT_2013";
   public static final boolean TRACE = false;

   LongStreamBinder() {
      this.type = 8;
   }

   long bind(OraclePreparedStatement var1, int var2, int var3, int var4, byte[] var5, char[] var6, short[] var7, int var8, int var9, int var10, int var11, int var12, int var13, boolean var14, long var15) {
      var7[var13] = 0;
      return var15;
   }

   Binder copyingBinder() {
      return OraclePreparedStatementReadOnly.theStaticVarcharNullBinder;
   }
}
