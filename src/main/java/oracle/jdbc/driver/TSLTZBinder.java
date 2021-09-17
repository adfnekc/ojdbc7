package oracle.jdbc.driver;

class TSLTZBinder extends DatumBinder {
   Binder theTSLTZCopyingBinder;
   private static final String _Copyright_2007_Oracle_All_Rights_Reserved_ = null;
   public static final String BUILD_DATE = "Thu_Apr_04_15:09:24_PDT_2013";
   public static final boolean TRACE = false;

   static void init(Binder var0) {
      var0.type = 231;
      var0.bytelen = 11;
   }

   TSLTZBinder() {
      this.theTSLTZCopyingBinder = OraclePreparedStatementReadOnly.theStaticTSLTZCopyingBinder;
      init(this);
   }

   Binder copyingBinder() {
      return this.theTSLTZCopyingBinder;
   }
}
