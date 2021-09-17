package oracle.net.ns;

import java.io.IOException;
import java.nio.ByteOrder;

final class NIOConnectPacket extends NIOPacket {
   static final int ntCharacteristics = 20376;

   NIOConnectPacket(SessionAtts var1) {
      super(var1);
   }

   final void writeToSocketChannel(String var1, boolean var2, boolean var3, boolean var4, int var5, int var6, int var7) throws IOException {
      if (var5 < 512) {
         var5 = 512;
      }

      if (var6 < 255) {
         var6 = 255;
      }

      if (var5 > 2097152) {
         var5 = 2097152;
      }

      if (var6 > 2097152) {
         var6 = 2097152;
      }

      if (var6 < var5) {
         var6 = var5;
      }

      int var8 = var1 == null ? 0 : var1.length();
      boolean var9 = var8 > 230;
      this.session.payloadBuffer.clear();
      this.session.payloadBuffer.order(ByteOrder.BIG_ENDIAN);
      this.session.payloadBuffer.putShort((short)315);
      this.session.payloadBuffer.putShort((short)300);
      int var10 = 0;
      if (var2 && var4) {
         var10 = 3585;
      }

      if (var3) {
         var10 |= 64;
      }

      this.session.payloadBuffer.putShort((short)var10);
      if (var5 < 65535) {
         this.session.payloadBuffer.putShort((short)var5);
      } else {
         this.session.payloadBuffer.putShort((short)-1);
      }

      if (var6 < 65535) {
         this.session.payloadBuffer.putShort((short)var6);
      } else {
         this.session.payloadBuffer.putShort((short)-1);
      }

      this.session.payloadBuffer.putShort((short)20376);
      this.session.payloadBuffer.putShort((short)0);
      this.session.payloadBuffer.putShort((short)1);
      this.session.payloadBuffer.putShort((short)var8);
      this.session.payloadBuffer.putShort((short)70);
      this.session.payloadBuffer.putInt(0);
      this.session.payloadBuffer.putShort((short)var7);
      this.session.payloadBuffer.position(42);
      this.session.payloadBuffer.putShort((short)0);
      this.session.payloadBuffer.putShort((short)0);
      this.session.payloadBuffer.putShort((short)0);
      this.session.payloadBuffer.putShort((short)0);
      this.session.payloadBuffer.putInt(var5);
      this.session.payloadBuffer.putInt(var6);
      this.session.payloadBuffer.position(62);
      if (!var9 && var8 > 0) {
         this.session.payloadBuffer.put(var1.getBytes());
      }

      this.header.type = 1;
      this.header.flags = this.session.redirecting ? 2 : 0;
      this.session.redirecting = false;
      this.writeToSocketChannel();
      if (var9) {
         byte[] var11 = var1.getBytes();
         this.session.dataChannel.writeDataToSocketChannel(var11);
      }

   }

   void readPayloadBuffer() throws IOException {
      throw new UnsupportedOperationException("Attempting to read from a one way packet sent by client");
   }
}
