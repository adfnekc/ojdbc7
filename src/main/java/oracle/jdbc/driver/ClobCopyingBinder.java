package oracle.jdbc.driver;

class ClobCopyingBinder extends ByteCopyingBinder {
   private static final String _Copyright_2007_Oracle_All_Rights_Reserved_ = null;
   public static final String BUILD_DATE = "Thu_Apr_04_15:09:24_PDT_2013";
   public static final boolean TRACE = false;

   ClobCopyingBinder() {
      ClobBinder.init(this);
   }

   void lastBoundValueCleanup(OraclePreparedStatement var1, int var2) {
      if (var1.lastBoundClobs != null) {
         var1.moveTempLobsToFree(var1.lastBoundClobs[var2]);
      }

   }
}
