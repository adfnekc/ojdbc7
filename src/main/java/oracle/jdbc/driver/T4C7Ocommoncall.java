package oracle.jdbc.driver;

import java.io.IOException;
import java.sql.SQLException;

final class T4C7Ocommoncall extends T4CTTIfun {
   private static final String _Copyright_2007_Oracle_All_Rights_Reserved_ = null;
   public static final String BUILD_DATE = "Thu_Apr_04_15:09:24_PDT_2013";
   public static final boolean TRACE = false;

   T4C7Ocommoncall(T4CConnection var1) {
      super(var1, (byte)3);
   }

   void doOLOGOFF() throws SQLException, IOException {
      this.setFunCode((short)9);
      this.doRPC();
   }

   void doOROLLBACK() throws SQLException, IOException {
      this.setFunCode((short)15);
      this.doRPC();
   }

   void doOCOMMIT() throws SQLException, IOException {
      this.setFunCode((short)14);
      this.doRPC();
   }

   void marshal() throws IOException {
   }

   void processError() throws SQLException {
      if (this.oer.retCode != 2089) {
         this.oer.processError();
      }

   }

   protected oracle.jdbc.internal.OracleConnection getConnectionDuringExceptionHandling() {
      return null;
   }
}
