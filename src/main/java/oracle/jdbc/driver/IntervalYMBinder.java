package oracle.jdbc.driver;

class IntervalYMBinder extends DatumBinder {
   Binder theIntervalYMCopyingBinder;
   private static final String _Copyright_2007_Oracle_All_Rights_Reserved_ = null;
   public static final String BUILD_DATE = "Thu_Apr_04_15:09:24_PDT_2013";
   public static final boolean TRACE = false;

   static void init(Binder var0) {
      var0.type = 182;
      var0.bytelen = 5;
   }

   IntervalYMBinder() {
      this.theIntervalYMCopyingBinder = OraclePreparedStatementReadOnly.theStaticIntervalYMCopyingBinder;
      init(this);
   }

   Binder copyingBinder() {
      return this.theIntervalYMCopyingBinder;
   }
}
