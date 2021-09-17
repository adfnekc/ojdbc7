package oracle.jdbc.driver;

import java.io.IOException;
import java.sql.SQLException;

final class T4CTTIoxssync extends T4CTTIfun {
   T4CTTIoxssync(T4CConnection var1) {
      super(var1, (byte)17);
      this.setFunCode((short)176);
   }

   void doOXSSYNC() throws IOException, SQLException {
      this.doPigRPC();
   }

   void marshal() throws IOException {
   }

   protected oracle.jdbc.internal.OracleConnection getConnectionDuringExceptionHandling() {
      return this.connection;
   }
}
