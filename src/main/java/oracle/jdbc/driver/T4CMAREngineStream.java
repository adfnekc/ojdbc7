package oracle.jdbc.driver;

import java.io.IOException;
import java.net.SocketTimeoutException;
import java.sql.SQLException;
import oracle.net.ns.BreakNetException;
import oracle.net.ns.Communication;
import oracle.net.ns.NetException;
import oracle.net.ns.NetInputStream;
import oracle.net.ns.NetOutputStream;

class T4CMAREngineStream extends T4CMAREngine {
   NetInputStream inStream;
   NetOutputStream outStream;
   private static final String _Copyright_2007_Oracle_All_Rights_Reserved_ = null;
   public static final String BUILD_DATE = "Thu_Apr_04_15:09:24_PDT_2013";
   public static final boolean TRACE = false;

   T4CMAREngineStream(Communication var1) throws SQLException, IOException {
      if (var1 == null) {
         SQLException var2 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 433);
         var2.fillInStackTrace();
         throw var2;
      } else {
         this.net = var1;

         try {
            this.outStream = new T4CSocketOutputStreamWrapper((NetOutputStream)var1.getOutputStream());
            this.inStream = new T4CSocketInputStreamWrapper((NetInputStream)var1.getInputStream(), (T4CSocketOutputStreamWrapper)this.outStream);
         } catch (NetException var3) {
            throw new IOException(var3.getMessage());
         }

         this.types = new T4CTypeRep(this, false);
         this.types.setRep((byte)1, (byte)2);
      }
   }

   void initBuffers() {
   }

   final void marshalSB1(byte var1) throws IOException {
      this.marshalSB2((short)var1);
   }

   final void marshalUB1(short var1) throws IOException {
      this.outStream.write((byte)(var1 & 255));
   }

   final void marshalSB2(short var1) throws IOException {
      byte var2 = this.value2Buffer(var1, this.tmpBuffer2, (byte)1);
      if (var2 != 0) {
         this.outStream.write(this.tmpBuffer2, 0, var2);
      }

   }

   final void marshalUB2(int var1) throws IOException {
      this.marshalSB2((short)(var1 & '\uffff'));
   }

   final void marshalSB4(int var1) throws IOException {
      byte var2 = this.value2Buffer(var1, this.tmpBuffer4, (byte)2);
      if (var2 != 0) {
         this.outStream.write(this.tmpBuffer4, 0, var2);
      }

   }

   final void marshalUB4(long var1) throws IOException {
      this.marshalSB4((int)(var1 & -1L));
   }

   final void marshalSB8(long var1) throws IOException {
      byte var3 = this.value2Buffer(var1, this.tmpBuffer8, (byte)3);
      if (var3 != 0) {
         this.outStream.write(this.tmpBuffer8, 0, var3);
      }

   }

   final void marshalB1Array(byte[] var1) throws IOException {
      if (var1.length > 0) {
         this.outStream.write(var1);
      }

   }

   final void marshalB1Array(byte[] var1, int var2, int var3) throws IOException {
      if (var1.length > 0) {
         this.outStream.write(var1, var2, var3);
      }

   }

   final byte value2Buffer(int var1, byte[] var2, byte var3) throws IOException {
      boolean var4 = (this.types.rep[var3] & 1) > 0;
      boolean var5 = true;
      byte var6 = 0;

      for(int var7 = var2.length - 1; var7 >= 0; --var7) {
         var2[var6] = (byte)(var1 >>> 8 * var7 & 255);
         if (var4) {
            if (!var5 || var2[var6] != 0) {
               var5 = false;
               ++var6;
            }
         } else {
            ++var6;
         }
      }

      if (var4) {
         this.outStream.write(var6);
      }

      if ((this.types.rep[var3] & 2) > 0) {
         this.reverseArray(var2, var6);
      }

      return var6;
   }

   final byte value2Buffer(long var1, byte[] var3, byte var4) throws IOException {
      boolean var5 = (this.types.rep[var4] & 1) > 0;
      boolean var6 = true;
      byte var7 = 0;

      for(int var8 = var3.length - 1; var8 >= 0; --var8) {
         var3[var7] = (byte)((int)(var1 >>> 8 * var8 & 255L));
         if (var5) {
            if (!var6 || var3[var7] != 0) {
               var6 = false;
               ++var7;
            }
         } else {
            ++var7;
         }
      }

      if (var5) {
         this.outStream.write(var7);
      }

      if ((this.types.rep[var4] & 2) > 0) {
         this.reverseArray(var3, var7);
      }

      return var7;
   }

   final void reverseArray(byte[] var1, byte var2) {
      int var4 = var2 / 2;

      for(int var5 = 0; var5 < var4; ++var5) {
         byte var3 = var1[var5];
         var1[var5] = var1[var2 - 1 - var5];
         var1[var2 - 1 - var5] = var3;
      }

   }

   final byte unmarshalSB1() throws SQLException, IOException {
      byte var1 = (byte)this.unmarshalSB2();
      return var1;
   }

   final short unmarshalUB1() throws SQLException, IOException {
      boolean var1 = false;

      short var5;
      try {
         var5 = (short)this.inStream.read();
      } catch (SocketTimeoutException var3) {
         ((T4CConnection)this.getConnectionDuringExceptionHandling()).doAsynchronousClose();
         throw var3;
      } catch (BreakNetException var4) {
         this.net.sendReset();
         throw var4;
      }

      if (var5 < 0) {
         SQLException var2 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 410);
         var2.fillInStackTrace();
         throw var2;
      } else {
         return var5;
      }
   }

   final short unmarshalSB2() throws SQLException, IOException {
      short var1 = (short)this.unmarshalUB2();
      return var1;
   }

   final int unmarshalUB2() throws SQLException, IOException {
      int var1 = (int)this.buffer2Value((byte)1);
      return var1 & '\uffff';
   }

   final int unmarshalSB4() throws SQLException, IOException {
      int var1 = (int)this.unmarshalUB4();
      return var1;
   }

   final long unmarshalUB4() throws SQLException, IOException {
      long var1 = this.buffer2Value((byte)2);
      return var1;
   }

   byte[] unmarshalNBytes(int var1) throws SQLException, IOException {
      byte[] var2 = new byte[var1];
      if (var1 > 0) {
         try {
            if (this.inStream.read(var2) < 0) {
               SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 410);
               var3.fillInStackTrace();
               throw var3;
            }
         } catch (SocketTimeoutException var4) {
            ((T4CConnection)this.getConnectionDuringExceptionHandling()).doAsynchronousClose();
            throw var4;
         } catch (BreakNetException var5) {
            this.net.sendReset();
            throw var5;
         }
      }

      return var2;
   }

   int unmarshalNBytes(byte[] var1, int var2, int var3) throws SQLException, IOException {
      if (var2 + var3 > var1.length) {
         var3 = var1.length - var2;
      }

      int var4;
      for(var4 = 0; var4 < var3; var4 += this.getNBytes(var1, var2 + var4, var3 - var4)) {
      }

      return var4;
   }

   int getNBytes(byte[] var1, int var2, int var3) throws SQLException, IOException {
      if (var2 + var3 > var1.length) {
         var3 = var1.length - var2;
      }

      boolean var4 = false;

      try {
         int var8;
         if ((var8 = this.inStream.read(var1, var2, var3)) < 0) {
            SQLException var5 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 410);
            var5.fillInStackTrace();
            throw var5;
         } else {
            return var8;
         }
      } catch (SocketTimeoutException var6) {
         ((T4CConnection)this.getConnectionDuringExceptionHandling()).doAsynchronousClose();
         throw var6;
      } catch (BreakNetException var7) {
         this.net.sendReset();
         throw var7;
      }
   }

   byte[] getNBytes(int var1) throws SQLException, IOException {
      byte[] var2 = new byte[var1];

      try {
         if (this.inStream.read(var2) < 0) {
            SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 410);
            var3.fillInStackTrace();
            throw var3;
         } else {
            return var2;
         }
      } catch (SocketTimeoutException var4) {
         ((T4CConnection)this.getConnectionDuringExceptionHandling()).doAsynchronousClose();
         throw var4;
      } catch (BreakNetException var5) {
         this.net.sendReset();
         throw var5;
      }
   }

   byte[] unmarshalTEXT(int var1) throws SQLException, IOException {
      int var2 = 0;
      byte[] var3 = new byte[var1];

      while(var2 < var1) {
         try {
            if (this.inStream.read(var3, var2, 1) < 0) {
               SQLException var5 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 410);
               var5.fillInStackTrace();
               throw var5;
            }
         } catch (SocketTimeoutException var6) {
            ((T4CConnection)this.getConnectionDuringExceptionHandling()).doAsynchronousClose();
            throw var6;
         } catch (BreakNetException var7) {
            this.net.sendReset();
            throw var7;
         }

         if (var3[var2++] == 0) {
            break;
         }
      }

      int var10000 = var3.length;
      --var2;
      byte[] var4;
      if (var10000 == var2) {
         var4 = var3;
      } else {
         var4 = new byte[var2];
         System.arraycopy(var3, 0, var4, 0, var2);
      }

      return var4;
   }

   final long buffer2Value(byte var1) throws SQLException, IOException {
      try {
         long var2 = 0L;
         int var4 = 1;
         if ((this.types.rep[var1] & 1) > 0) {
            var4 = this.inStream.readB1();
         } else {
            switch(var1) {
            case 1:
               var4 = 2;
               break;
            case 2:
               var4 = 4;
               break;
            case 3:
               var4 = 8;
            }
         }

         if ((this.types.rep[var1] & 2) > 0) {
            var2 = this.inStream.readLongLSB(var4);
         } else {
            var2 = this.inStream.readLongMSB(var4);
         }

         return var2;
      } catch (BreakNetException var5) {
         this.net.sendReset();
         throw var5;
      } catch (SocketTimeoutException var6) {
         ((T4CConnection)this.getConnectionDuringExceptionHandling()).doAsynchronousClose();
         throw var6;
      }
   }

   void setByteOrder(byte var1) throws IOException {
   }

   protected void flush() throws IOException {
      ((T4CSocketOutputStreamWrapper)this.outStream).flush(true);
   }

   void writeZeroCopyIO(byte[] var1, int var2, int var3) throws IOException, NetException {
      this.outStream.flush();
      this.outStream.writeZeroCopyIO(var1, var2, var3);
   }
}
