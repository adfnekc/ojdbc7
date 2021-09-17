package oracle.jdbc.driver;

class NamedTypeBinder extends TypeBinder {
   Binder theNamedTypeCopyingBinder;
   private static final String _Copyright_2007_Oracle_All_Rights_Reserved_ = null;
   public static final String BUILD_DATE = "Thu_Apr_04_15:09:24_PDT_2013";
   public static final boolean TRACE = false;

   NamedTypeBinder() {
      this.theNamedTypeCopyingBinder = OraclePreparedStatementReadOnly.theStaticNamedTypeCopyingBinder;
      init(this);
   }

   static void init(Binder var0) {
      var0.type = 109;
      var0.bytelen = 24;
   }

   Binder copyingBinder() {
      return this.theNamedTypeCopyingBinder;
   }
}
