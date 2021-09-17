package oracle.net.ns;

import java.io.IOException;

public class RefusePacket extends Packet implements SQLnetDef {
   protected int userReason;
   protected int systemReason;
   private static final String _Copyright_2007_Oracle_All_Rights_Reserved_ = null;
   public static final String BUILD_DATE = "Thu_Apr_04_15:09:24_PDT_2013";
   public static final boolean TRACE = false;

   public RefusePacket(Packet var1) throws IOException, NetException {
      super(var1);
      this.userReason = this.buffer[8];
      this.systemReason = this.buffer[9];
      this.dataOff = 12;
      this.dataLen = this.buffer[10] & 255;
      this.dataLen <<= 8;
      this.dataLen |= this.buffer[11] & 255;
      this.extractData();
   }
}
