package oracle.net.ns;

import java.io.IOException;

public class ConnectPacket extends Packet implements SQLnetDef {
   private boolean connDataOflow;
   private byte[] connBytes;

   public ConnectPacket(SessionAtts var1, boolean var2, boolean var3) throws IOException {
      super(var1);
      this.data = var1.cOption.conn_data.toString();
      if (this.data != null) {
         this.connBytes = this.data.getBytes();
         this.dataLen = this.connBytes.length;
      } else {
         this.connBytes = null;
         this.dataLen = 0;
      }

      this.connDataOflow = this.dataLen > 230;
      int var4 = !this.connDataOflow ? 70 + this.dataLen : 70;
      this.createBuffer(var4, 1, var1.redirecting ? 2 : 0);
      var1.redirecting = false;
      this.buffer[8] = 1;
      this.buffer[9] = 59;
      this.buffer[10] = 1;
      this.buffer[11] = 44;
      int var5 = 1;
      if (var2 && var1.nt.isCharacteristicUrgentSupported()) {
         var5 |= 3072;
      }

      if (var3) {
         var5 |= 64;
      }

      this.buffer[12] = (byte)(var5 >> 8 & 255);
      this.buffer[13] = (byte)(var5 & 255);
      if (this.sdu < 65535) {
         this.buffer[14] = (byte)(this.sdu / 256);
         this.buffer[15] = (byte)(this.sdu % 256);
      } else {
         this.buffer[14] = -1;
         this.buffer[15] = -1;
      }

      if (this.tdu < 65535) {
         this.buffer[16] = (byte)(this.tdu / 256);
         this.buffer[17] = (byte)(this.tdu % 256);
      } else {
         this.buffer[16] = -1;
         this.buffer[17] = -1;
      }

      this.buffer[18] = 79;
      this.buffer[19] = -104;
      this.buffer[22] = 0;
      this.buffer[23] = 1;
      this.buffer[24] = (byte)(this.dataLen / 256);
      this.buffer[25] = (byte)(this.dataLen % 256);
      this.buffer[27] = 70;
      if (!var1.anoEnabled) {
         this.buffer[32] = this.buffer[33] = 4;
      } else {
         this.buffer[32] = this.buffer[33] = (byte)var1.getANOFlags();
      }

      byte[] var10000 = this.buffer;
      var10000[32] = (byte)(var10000[32] | 128);
      var10000 = this.buffer;
      var10000[33] = (byte)(var10000[33] | 128);
      setUb2ToBytes(this.buffer, 50, 0);
      setUb2ToBytes(this.buffer, 52, 0);
      setUb2ToBytes(this.buffer, 54, 0);
      setUb2ToBytes(this.buffer, 56, 0);
      this.buffer[61] = (byte)(this.sdu & 255);
      this.buffer[60] = (byte)(this.sdu >> 8 & 255);
      this.buffer[59] = (byte)(this.sdu >> 16 & 255);
      this.buffer[58] = (byte)(this.sdu >> 24 & 255);
      this.buffer[65] = (byte)(this.tdu & 255);
      this.buffer[64] = (byte)(this.tdu >> 8 & 255);
      this.buffer[63] = (byte)(this.tdu >> 16 & 255);
      this.buffer[62] = (byte)(this.tdu >> 24 & 255);
      if (!this.connDataOflow && this.connBytes != null && this.connBytes.length > 0) {
         System.arraycopy(this.connBytes, 0, this.buffer, 70, this.connBytes.length);
      }

   }

   protected void send() throws IOException {
      super.send();
      if (this.connDataOflow) {
         byte[] var1 = new byte[this.connBytes.length];
         System.arraycopy(this.connBytes, 0, var1, 0, this.connBytes.length);
         this.sAtts.nsOutputStream.write(var1);
         this.sAtts.nsOutputStream.flush();
      }

   }
}
