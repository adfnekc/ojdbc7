package oracle.net.ns;

import java.io.IOException;

public class RedirectPacket extends Packet implements SQLnetDef {
   public RedirectPacket(Packet var1) throws IOException, NetException {
      super(var1);
      this.dataOff = 10;
      this.dataLen = this.buffer[8] & 255;
      this.dataLen <<= 8;
      this.dataLen |= this.buffer[9] & 255;
      this.extractData();
   }
}
