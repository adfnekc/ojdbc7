package oracle.net.ano;

import oracle.net.ns.NetOutputStream;
import oracle.net.ns.SessionAtts;

public class AnoNetOutputStream extends NetOutputStream {
   public AnoNetOutputStream(SessionAtts var1) {
      super(var1);
      this.daPkt = new CryptoDataPacket(var1);
   }
}
