package oracle.net.ano;

import oracle.net.ns.NetInputStream;
import oracle.net.ns.SessionAtts;

public class AnoNetInputStream extends NetInputStream {
   public AnoNetInputStream(SessionAtts var1) {
      super(var1);
      this.daPkt = new CryptoDataPacket(var1);
   }

   protected void processMarker() {
      this.sAtts.ano.setRenewKey(true);
   }
}
