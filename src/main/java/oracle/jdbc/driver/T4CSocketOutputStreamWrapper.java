package oracle.jdbc.driver;

import java.io.IOException;
import oracle.net.ns.BreakNetException;
import oracle.net.ns.NetException;
import oracle.net.ns.NetOutputStream;

class T4CSocketOutputStreamWrapper extends NetOutputStream {
   static final int MAX_BUFFER_SIZE = 2048;
   NetOutputStream os = null;
   byte[] buffer = new byte[2048];
   int bIndex = 0;

   T4CSocketOutputStreamWrapper(NetOutputStream var1) throws IOException {
      this.os = var1;
   }

   public void write(int var1) throws IOException {
      if (this.bIndex + 1 >= 2048) {
         this.flush();
      }

      this.buffer[this.bIndex++] = (byte)(var1 & 255);
   }

   public void write(byte[] var1, int var2, int var3) throws IOException {
      if (var3 > 2048) {
         this.flush();
         this.os.write(var1, var2, var3);
      } else if (this.bIndex + var3 < 2048) {
         System.arraycopy(var1, var2, this.buffer, this.bIndex, var3);
         this.bIndex += var3;
      } else {
         this.flush();
         System.arraycopy(var1, var2, this.buffer, this.bIndex, var3);
         this.bIndex += var3;
      }

   }

   public void flush() throws IOException {
      this.flush(false);
   }

   public void flush(boolean var1) throws IOException {
      if (this.bIndex > 0) {
         this.os.write(this.buffer, 0, this.bIndex);
         this.bIndex = 0;
      }

      if (var1) {
         this.os.flush();
      }

   }

   public void close() throws IOException {
      this.os.close();
      super.close();
   }

   public void writeZeroCopyIO(byte[] var1, int var2, int var3) throws IOException, NetException, BreakNetException {
      this.flush(true);
      this.os.writeZeroCopyIO(var1, var2, var3);
   }
}
