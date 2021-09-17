package oracle.jdbc.driver;

import java.io.IOException;
import java.sql.SQLException;

final class T4CTTIosesstate extends T4CTTIfun {
   private long flags_kpdssSessionStateOps;

   T4CTTIosesstate(T4CConnection var1) {
      super(var1, (byte)17);
      this.setFunCode((short)176);
   }

   void doOSESSSTATE(long var1) throws IOException, SQLException {
      this.flags_kpdssSessionStateOps = var1;
      this.doPigRPC();
   }

   void marshal() throws IOException {
      this.meg.marshalSB8(this.flags_kpdssSessionStateOps);
   }
}
