package oracle.jdbc.driver;

class LongStreamForStringCopyingBinder extends LongStreamForStringBinder {
   private static final String _Copyright_2007_Oracle_All_Rights_Reserved_ = null;
   public static final String BUILD_DATE = "Thu_Apr_04_15:09:24_PDT_2013";
   public static final boolean TRACE = false;

   long bind(OraclePreparedStatement var1, int var2, int var3, int var4, byte[] var5, char[] var6, short[] var7, int var8, int var9, int var10, int var11, int var12, int var13, boolean var14, long var15) {
      var15 = super.bind(var1, var2, var3, var4, var5, var6, var7, var8, var9, var10, var11, var12, var13, var14, var15);
      if (var3 == 0) {
         var1.parameterStream[var4][var2] = var1.lastBoundStream[var2];
      } else {
         var1.parameterStream[var4][var2] = var1.parameterStream[var4 - 1][var2];
      }

      return var15;
   }
}
