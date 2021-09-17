package oracle.net.ns;

import java.io.IOException;

public class AcceptPacket extends Packet implements SQLnetDef {
   protected int version;
   protected int options;
   protected int sduSize;
   protected int tduSize;
   protected int myHWByteOrder;
   protected int flag0;
   protected int flag1;

   public AcceptPacket(Packet var1) throws IOException, NetException {
      super(var1);
      this.version = this.buffer[8] & 255;
      this.version <<= 8;
      this.version |= this.buffer[9] & 255;
      this.options = this.buffer[10] & 255;
      this.options <<= 8;
      this.options |= this.buffer[11] & 255;
      this.sduSize = this.buffer[12] & 255;
      this.sduSize <<= 8;
      this.sduSize |= this.buffer[13] & 255;
      this.tduSize = this.buffer[14] & 255;
      this.tduSize <<= 8;
      this.tduSize |= this.buffer[15] & 255;
      this.myHWByteOrder = this.buffer[16] & 255;
      this.myHWByteOrder <<= 8;
      this.myHWByteOrder |= this.buffer[17] & 255;
      this.dataLen = this.buffer[18] & 255;
      this.dataLen <<= 8;
      this.dataLen |= this.buffer[19] & 255;
      this.dataOff = this.buffer[20] & 255;
      this.dataOff <<= 8;
      this.dataOff |= this.buffer[21] & 255;
      this.flag0 = this.buffer[22];
      this.flag1 = this.buffer[23];
      this.sAtts.noAnoServices = (this.flag1 & 8) == 8;
      if (!this.sAtts.noAnoServices) {
         this.sAtts.noAnoServices = (this.flag0 & 4) == 4;
      }

      this.sAtts.timeout = toUb2(this.buffer, 24);
      this.sAtts.tick = toUb2(this.buffer, 26);
      SessionAtts var10000 = this.sAtts;
      var10000.timeout -= this.sAtts.tick;
      var10000 = this.sAtts;
      var10000.timeout *= 10;
      int var2 = toUb2(this.buffer, 28);
      int var3 = toUb2(this.buffer, 30);
      if (var2 > 0) {
         this.sAtts.reconnectAddress = new byte[var2];
         System.arraycopy(this.buffer, var3, this.sAtts.reconnectAddress, 0, var2);
      }

      if (this.version >= 315) {
         this.sduSize = toUb4(this.buffer, 32);
         this.tduSize = toUb4(this.buffer, 36);
         this.sAtts.isLargeSDU = true;
      }

      if (this.sAtts.timeout > 0) {
         int var4 = this.dataLen + this.dataOff;
         this.sAtts.poolEnabled = true;
         this.sAtts.sessionId = new byte[16];
         System.arraycopy(this.buffer, var4, this.sAtts.sessionId, 0, 16);
         this.sAtts.nsInputStream.poolEnabled(true);
         this.sAtts.nsOutputStream.poolEnabled(true);
         this.sAtts.timestampLastIO = System.currentTimeMillis();
      }

      this.extractData();
      this.sAtts.setSDU(this.sduSize);
      this.sAtts.setTDU(this.tduSize);
      this.sAtts.negotiatedSDU = this.sdu;
      if (this.tduSize < this.sduSize) {
         this.sAtts.setSDU(this.tduSize);
      }

      this.sAtts.setNegotiatedOptions(this.options);
   }

   public String toString() {
      return "version=" + this.version + ", options=" + this.options + ", sduSize=" + this.sduSize + ", tduSize=" + this.tduSize + "\nmyHWByteOrder=" + this.myHWByteOrder + ", dataLen=" + this.dataLen + ", flag0=" + this.flag0 + ", flag1=" + this.flag1 + "\n" + (this.sAtts.poolEnabled ? "timeout=" + this.sAtts.timeout + ",re-connect: " + this.sAtts.reconnectAddress + "\n(byte)Dumping session-id:\n" + this.dumpBytes(this.sAtts.sessionId, 0, 16) : "") + "\n\n";
   }
}
