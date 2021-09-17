package oracle.jdbc.driver;

import java.io.IOException;
import java.sql.SQLException;

final class T4CTTIoappcontreplay extends T4CTTIfun {
   private byte[] replayCtxts_kpdxcAppContReplay;
   private int flags_kpdxcAppContReplay;

   T4CTTIoappcontreplay(T4CConnection var1) {
      super(var1, (byte)17);
      this.setFunCode((short)177);
   }

   void doOAPPCONTREPLAY(oracle.jdbc.internal.ReplayContext var1) throws IOException, SQLException {
      this.replayCtxts_kpdxcAppContReplay = var1.getContext();
      this.flags_kpdxcAppContReplay = 0;
      this.doPigRPC();
   }

   void marshal() throws IOException {
      this.meg.marshalPTR();
      this.meg.marshalUB4(1L);
      this.meg.marshalUB4((long)this.flags_kpdxcAppContReplay);
      this.meg.marshalUB4((long)this.replayCtxts_kpdxcAppContReplay.length);
      this.meg.marshalCLR(this.replayCtxts_kpdxcAppContReplay, 0, this.replayCtxts_kpdxcAppContReplay.length);
   }
}
