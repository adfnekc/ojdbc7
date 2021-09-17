package oracle.net.ano;

import java.io.IOException;
import oracle.net.aso.h;
import oracle.net.aso.j;
import oracle.net.ns.DataPacket;
import oracle.net.ns.SQLnetDef;
import oracle.net.ns.SessionAtts;

public class CryptoDataPacket extends DataPacket implements SQLnetDef {
   private j a = null;
   private h b = null;
   private int c = 0;
   private int d = 0;
   private Ano e = null;

   public CryptoDataPacket(SessionAtts var1) {
      super(var1);
      this.e = var1.ano;
      if (var1.ano.b != null) {
         this.a = var1.ano.b;
         this.d += this.a.b();
      }

      if (var1.ano.c != null) {
         this.b = var1.ano.c;
         this.d += this.b.b();
      }

      ++this.d;
   }

   protected void createBuffer(int var1) {
      super.createBuffer(var1 + (this.sAtts.poolEnabled ? 16 : 0));
   }

   public void receive() throws IOException {
      super.receive();
      if (this.type == 6) {
         this.e = this.sAtts.ano;
         if (this.e.b != null) {
            this.a = this.e.b;
            this.d += this.a.b();
            if (this.e.getRenewKey()) {
               this.a.b((byte[])null, (byte[])null);
            }
         }

         if (this.e.c != null) {
            this.b = this.e.c;
            this.d += this.b.b();
            if (this.e.getRenewKey()) {
               this.b.a();
            }
         }

         ++this.d;
         this.e.setRenewKey(false);

         try {
            byte[] var2 = new byte[this.dataLen - 1];
            byte[] var10000 = this.buffer;
            int var6 = this.length;
            --this.dataLen;
            System.arraycopy(this.buffer, this.dataOff, var2, 0, this.dataLen);
            if (this.a != null) {
               var2 = this.a.a(var2);
            }

            if (var2 == null) {
               throw new IOException("Bad buffer - Fail to decrypt buffer");
            } else {
               this.dataLen = var2.length;
               if (this.b != null) {
                  byte[] var3 = new byte[this.b.b()];
                  this.dataLen -= this.b.b();
                  System.arraycopy(var2, this.dataLen, var3, 0, this.b.b());
                  byte[] var4 = new byte[this.dataLen];
                  System.arraycopy(var2, 0, var4, 0, this.dataLen);
                  if (this.b.a(var4, var3)) {
                     throw new IOException("Checksum fail");
                  }

                  System.arraycopy(var4, 0, this.buffer, this.dataOff, this.dataLen);
               } else {
                  System.arraycopy(var2, 0, this.buffer, this.dataOff, this.dataLen);
               }

               this.length = this.dataOff + this.dataLen;
               this.pktOffset = 10;
            }
         } catch (IOException var5) {
            throw var5;
         }
      }
   }

   protected int putDataInBuffer(byte[] var1, int var2, int var3) {
      if ((var3 = Math.min(this.buffer.length - this.sessionIdSize - this.d - this.pktOffset, var3)) > 0) {
         System.arraycopy(var1, var2, this.buffer, this.pktOffset, var3);
         this.pktOffset += var3;
         this.isBufferFull = this.pktOffset + this.d == this.buffer.length - this.sessionIdSize;
         this.availableBytesToSend = this.dataOff < this.pktOffset ? this.pktOffset - this.dataOff : 0;
      }

      return var3;
   }

   protected void send(int var1) throws IOException {
      byte[] var4;
      byte[] var5;
      byte[] var6;
      if (this.c < 2) {
         try {
            byte[] var3 = this.e.b();
            if ((var4 = this.e.getO3logSessionKey()) != null) {
               var5 = new byte[Math.max(var4.length, var3.length)];
               System.arraycopy(var6 = var4.length > var3.length ? var4 : var3, 0, var5, 0, var6.length);
               if (var4.length < 8 || var3.length < 8) {
                  throw new IOException("Key is too small");
               }

               for(int var9 = 0; var9 < 8; ++var9) {
                  var5[var9] = (byte)(var4[var9] ^ var3[var9]);
               }

               var6 = this.e.a();
               if (this.a != null) {
                  this.a.b(var5, var6);
               }

               if (this.b != null) {
                  this.b.b(var5, var6);
               }

               this.c = 3;
            }
         } catch (IOException var8) {
            throw var8;
         }
      }

      try {
         int var10000 = this.availableBytesToSend;
         var10000 = this.dataOff;
         var4 = new byte[this.availableBytesToSend];
         System.arraycopy(this.buffer, this.dataOff, var4, 0, var4.length);
         var5 = null;
         this.dataLen = this.availableBytesToSend;
         if (this.b != null && (var5 = this.b.a(var4, var4.length)) != null) {
            this.dataLen += var5.length;
         }

         var6 = new byte[this.dataLen];
         System.arraycopy(var4, 0, var6, 0, var4.length);
         if (var5 != null) {
            System.arraycopy(var5, 0, var6, var4.length, var5.length);
         }

         if (this.a != null) {
            if ((var6 = this.a.b(var6)) == null) {
               throw new IOException("Fail to encrypt buffer");
            }

            this.dataLen = var6.length;
            System.arraycopy(var6, 0, this.buffer, this.dataOff, this.dataLen);
         } else if (this.b != null) {
            System.arraycopy(var6, 0, this.buffer, this.dataOff, this.dataLen);
         }

         this.buffer[this.dataOff + this.dataLen] = (byte)(this.c >= 2 ? 1 : 0);
         ++this.dataLen;
         this.pktOffset = 10 + this.dataLen;
         this.length = 10 + this.dataLen;
      } catch (IOException var7) {
         throw var7;
      }

      super.send(var1);
   }
}
