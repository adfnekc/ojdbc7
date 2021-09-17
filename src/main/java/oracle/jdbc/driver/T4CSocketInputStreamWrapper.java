package oracle.jdbc.driver;

import java.io.IOException;
import oracle.net.ns.BreakNetException;
import oracle.net.ns.NetException;
import oracle.net.ns.NetInputStream;

class T4CSocketInputStreamWrapper extends NetInputStream {
   static final int MAX_BUFFER_SIZE = 2048;
   NetInputStream is = null;
   T4CSocketOutputStreamWrapper os = null;
   boolean eof = false;
   byte[] buffer = new byte[2048];
   int bIndex = 0;
   int bytesAvailable;

   T4CSocketInputStreamWrapper(NetInputStream var1, T4CSocketOutputStreamWrapper var2) throws IOException {
      this.is = var1;
      this.os = var2;
   }

   public final int read() throws IOException {
      if (this.eof) {
         return -1;
      } else {
         if (this.bytesAvailable < 1) {
            this.readNextPacket();
            if (this.eof) {
               return -1;
            }
         }

         --this.bytesAvailable;
         return this.buffer[this.bIndex++] & 255;
      }
   }

   public final int read(byte[] var1, int var2, int var3) throws IOException {
      if (this.eof) {
         return 0;
      } else {
         if (this.bytesAvailable < var3) {
            int var4 = this.bytesAvailable;
            System.arraycopy(this.buffer, this.bIndex, var1, var2, var4);
            var2 += var4;
            this.bIndex += var4;
            this.bytesAvailable -= var4;
            this.is.read(var1, var2, var3 - var4);
         } else {
            System.arraycopy(this.buffer, this.bIndex, var1, var2, var3);
            this.bIndex += var3;
            this.bytesAvailable -= var3;
         }

         return var3;
      }
   }

   void readNextPacket() throws IOException {
      this.os.flush();
      int var1 = this.is.read();
      if (var1 == -1) {
         this.eof = true;
      } else {
         this.buffer[0] = (byte)var1;
         this.bytesAvailable = this.is.available() + 1;
         this.bytesAvailable = this.bytesAvailable > 2048 ? 2048 : this.bytesAvailable;
         if (this.bytesAvailable > 1) {
            this.is.read(this.buffer, 1, this.bytesAvailable - 1);
         }

         this.bIndex = 0;
      }
   }

   public int readB1() throws IOException {
      return this.read();
   }

   public long readLongLSB(int var1) throws IOException {
      long var2 = 0L;
      boolean var4 = false;
      if ((var1 & 128) > 0) {
         var1 &= 127;
         var4 = true;
      }

      int var5 = var1;

      for(int var6 = 0; var5 > 0; ++var6) {
         if (this.bytesAvailable < 1) {
            this.readNextPacket();
         }

         var2 |= ((long)this.buffer[this.bIndex++] & 255L) << 8 * var6;
         --this.bytesAvailable;
         --var5;
      }

      return (long)(var4 ? -1 : 1) * var2;
   }

   public long readLongMSB(int var1) throws IOException {
      long var2 = 0L;
      boolean var4 = false;
      if ((var1 & 128) > 0) {
         var1 &= 127;
         var4 = true;
      }

      for(int var5 = var1; var5 > 0; --var5) {
         if (this.bytesAvailable < 1) {
            this.readNextPacket();
         }

         var2 |= ((long)this.buffer[this.bIndex++] & 255L) << 8 * (var5 - 1);
         --this.bytesAvailable;
      }

      return (long)(var4 ? -1 : 1) * var2;
   }

   public boolean readZeroCopyIO(byte[] var1, int var2, int[] var3) throws IOException, NetException, BreakNetException {
      this.os.flush();
      return this.is.readZeroCopyIO(var1, var2, var3);
   }
}
