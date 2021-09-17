package oracle.jdbc.driver;

import oracle.jdbc.internal.PDBChangeEvent;

public class NTFPDBChangeEvent implements PDBChangeEvent {
   oracle.jdbc.OracleConnection conn;
   private static final String _Copyright_2007_Oracle_All_Rights_Reserved_ = null;
   public static final String BUILD_DATE = "Thu_Apr_04_15:09:24_PDT_2013";
   public static final boolean TRACE = false;

   NTFPDBChangeEvent(oracle.jdbc.OracleConnection var1) {
      this.conn = var1;
   }

   public oracle.jdbc.OracleConnection getConnection() {
      return this.conn;
   }
}
