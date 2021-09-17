package oracle.jdbc.driver;

class ClobBinder extends DatumBinder {
   Binder theClobCopyingBinder;
   private static final String _Copyright_2007_Oracle_All_Rights_Reserved_ = null;
   public static final String BUILD_DATE = "Thu_Apr_04_15:09:24_PDT_2013";
   public static final boolean TRACE = false;

   static void init(Binder var0) {
      var0.type = 112;
      var0.bytelen = 4000;
   }

   ClobBinder() {
      this.theClobCopyingBinder = OraclePreparedStatementReadOnly.theStaticClobCopyingBinder;
      init(this);
      this.skipBindChecksumForLobs = true;
   }

   Binder copyingBinder() {
      return this.theClobCopyingBinder;
   }

   void lastBoundValueCleanup(OraclePreparedStatement var1, int var2) {
      if (var1.lastBoundClobs != null) {
         var1.moveTempLobsToFree(var1.lastBoundClobs[var2]);
      }

   }
}
