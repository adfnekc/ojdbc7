package oracle.jdbc.driver;

import java.io.IOException;
import java.sql.SQLException;

final class T4CTTIoping extends T4CTTIfun {
   private static final String _Copyright_2007_Oracle_All_Rights_Reserved_ = null;
   public static final String BUILD_DATE = "Thu_Apr_04_15:09:24_PDT_2013";
   public static final boolean TRACE = false;

   T4CTTIoping(T4CConnection var1) {
      super(var1, (byte)3);
      this.setFunCode((short)147);
   }

   void doOPING() throws IOException, SQLException {
      this.doRPC();
   }

   void marshal() throws IOException {
   }

   protected oracle.jdbc.internal.OracleConnection getConnectionDuringExceptionHandling() {
      return this.connection;
   }
}
