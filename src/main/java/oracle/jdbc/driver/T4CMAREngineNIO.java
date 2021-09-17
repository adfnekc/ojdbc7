package oracle.jdbc.driver;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.sql.SQLException;
import oracle.net.ns.BreakNetException;
import oracle.net.ns.Communication;
import oracle.net.ns.NIONSDataChannel;
import oracle.net.ns.NetException;

class T4CMAREngineNIO extends T4CMAREngine {
   NIONSDataChannel nsDataChannel;
   ByteBuffer dataBuffer;
   private boolean bytesReadyToGo = false;
   private boolean bufferReadyToWriteInto = false;
   int bytesWrittenSoFar = 0;
   int bytesToWriteInNextCall = 0;
   private static final String _Copyright_2007_Oracle_All_Rights_Reserved_ = null;
   public static final String BUILD_DATE = "Thu_Apr_04_15:09:24_PDT_2013";
   public static final boolean TRACE = false;

   T4CMAREngineNIO(Communication var1) throws SQLException, IOException {
      if (var1 == null) {
         SQLException var2 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 433);
         var2.fillInStackTrace();
         throw var2;
      } else {
         this.net = var1;
         this.nsDataChannel = var1.getSessionAttributes().dataChannel;
         this.dataBuffer = var1.getSessionAttributes().payloadDataBuffer;
         this.types = new T4CTypeRep(this, true);
         this.types.setRep((byte)1, (byte)2);
         this.dataBuffer.order(ByteOrder.LITTLE_ENDIAN);
      }
   }

   final void prepareForReading() throws IOException {
      try {
         if (this.bytesReadyToGo) {
            this.nsDataChannel.writeDataToSocketChannel();
            this.bytesReadyToGo = false;
            this.nsDataChannel.readDataFromSocketChannel();
         }

         while(!this.dataBuffer.hasRemaining()) {
            this.nsDataChannel.readDataFromSocketChannel();
         }

         this.bufferReadyToWriteInto = false;
      } catch (BreakNetException var2) {
         this.net.sendReset();
         throw var2;
      }
   }

   final void prepareForWriting() throws IOException {
      if (!this.bufferReadyToWriteInto) {
         this.dataBuffer.clear();
         this.dataBuffer.limit(this.dataBuffer.capacity());
         this.bufferReadyToWriteInto = true;
      }

   }

   private static void valueToUNV(long var0, byte[] var2) {
      var2[0] = 0;
      if (var0 != 0L) {
         int var3 = 0;
         boolean var4 = true;
         boolean var5 = var0 < 0L;
         long var6 = var5 ? -var0 : var0;

         for(int var8 = 0; var8 < 8; ++var8) {
            byte var9 = (byte)((int)(var6 >>> 8 * (7 - var8) & 255L));
            if (!var4 || var9 != 0) {
               var4 = false;
               ++var3;
               var2[var3] = var9;
            }
         }

         var2[0] = (byte)var3;
         if (var5) {
            var2[0] |= -128;
         }

      }
   }

   final void marshalSB1(byte var1) throws IOException {
      this.prepareForWriting();
      if (this.dataBuffer.remaining() < 1) {
         this.nsDataChannel.writeDataToSocketChannel();
      }

      this.dataBuffer.put(var1);
      this.bytesReadyToGo = true;
   }

   final void marshalUB1(short var1) throws IOException {
      this.marshalSB1((byte)var1);
   }

   final void marshalSB2(short var1) throws IOException {
      this.prepareForWriting();
      if (this.dataBuffer.remaining() < 3) {
         this.nsDataChannel.writeDataToSocketChannel();
      }

      if (this.types.rep[1] != 1) {
         this.dataBuffer.putShort(var1);
      } else if (var1 == 0) {
         this.dataBuffer.put((byte)0);
      } else {
         boolean var2 = var1 < 0;
         short var3 = (short)(var2 ? -var1 : var1);
         if (var3 <= 255) {
            if (var2) {
               this.dataBuffer.put((byte)-127);
            } else {
               this.dataBuffer.put((byte)1);
            }

            this.dataBuffer.put((byte)var3);
         } else {
            if (var2) {
               this.dataBuffer.put((byte)-126);
            } else {
               this.dataBuffer.put((byte)2);
            }

            this.dataBuffer.putShort(var3);
         }
      }

   }

   final void marshalUB2(int var1) throws IOException {
      this.prepareForWriting();
      if (this.dataBuffer.remaining() < 3) {
         this.nsDataChannel.writeDataToSocketChannel();
      }

      if (this.types.rep[1] != 1) {
         this.dataBuffer.putShort((short)var1);
      } else if (var1 == 0) {
         this.dataBuffer.put((byte)0);
      } else if (var1 <= 255) {
         this.dataBuffer.put((byte)1);
         this.dataBuffer.put((byte)var1);
      } else {
         this.dataBuffer.put((byte)2);
         this.dataBuffer.putShort((short)var1);
      }

      this.bytesReadyToGo = true;
   }

   final void marshalSB4(int var1) throws IOException {
      this.prepareForWriting();
      if (this.dataBuffer.remaining() < 5) {
         this.nsDataChannel.writeDataToSocketChannel();
      }

      if (this.types.rep[2] != 1) {
         this.dataBuffer.putInt(var1);
      } else if (var1 == 0) {
         this.dataBuffer.put((byte)0);
      } else {
         boolean var2 = var1 < 0;
         int var3 = var2 ? -var1 : var1;
         if (var3 <= 255) {
            if (!var2) {
               this.dataBuffer.put((byte)1);
            } else {
               this.dataBuffer.put((byte)-127);
            }

            this.dataBuffer.put((byte)var3);
         } else if (var3 <= 65535) {
            if (!var2) {
               this.dataBuffer.put((byte)2);
            } else {
               this.dataBuffer.put((byte)-126);
            }

            this.dataBuffer.putShort((short)var3);
         } else if (var3 < 26) {
            valueToUNV((long)var1, this.tmpBuffer10);
            this.dataBuffer.put(this.tmpBuffer10, 0, this.tmpBuffer10[0] + 1);
         } else {
            if (!var2) {
               this.dataBuffer.put((byte)4);
            } else {
               this.dataBuffer.put((byte)-124);
            }

            this.dataBuffer.putInt(var3);
         }
      }

      this.bytesReadyToGo = true;
   }

   final void marshalUB4(long var1) throws IOException {
      this.prepareForWriting();
      if (this.dataBuffer.remaining() < 5) {
         this.nsDataChannel.writeDataToSocketChannel();
      }

      if (this.types.rep[2] != 1) {
         this.dataBuffer.putInt((int)var1);
      } else if (var1 == 0L) {
         this.dataBuffer.put((byte)0);
      } else if (var1 <= 255L) {
         this.dataBuffer.put((byte)1);
         this.dataBuffer.put((byte)((int)var1));
      } else if (var1 <= 65535L) {
         this.dataBuffer.put((byte)2);
         this.dataBuffer.putShort((short)((int)var1));
      } else if (var1 <= 16777215L) {
         valueToUNV(var1, this.tmpBuffer10);
         this.dataBuffer.put(this.tmpBuffer10, 0, this.tmpBuffer10[0] + 1);
      } else {
         this.dataBuffer.put((byte)4);
         this.dataBuffer.putInt((int)var1);
      }

      this.bytesReadyToGo = true;
   }

   final void marshalSB8(long var1) throws IOException {
      this.prepareForWriting();
      if (this.dataBuffer.remaining() < 9) {
         this.nsDataChannel.writeDataToSocketChannel();
      }

      if (this.types.rep[3] != 1) {
         throw new IOException("TODO: SB8 in UNV representation only");
      } else {
         valueToUNV(var1, this.tmpBuffer10);
         this.dataBuffer.put(this.tmpBuffer10, 0, this.tmpBuffer10[0] + 1);
      }
   }

   final void marshalUB8(long var1) throws IOException {
      this.prepareForWriting();
      if (this.dataBuffer.remaining() < 9) {
         this.nsDataChannel.writeDataToSocketChannel();
      }

      if (var1 == 0L) {
         this.dataBuffer.put((byte)0);
      }

      if (this.types.rep[3] != 1) {
         throw new IOException("TODO: UB8 in UNV representation only");
      } else {
         this.tmpBuffer10[0] = 0;
         int var3 = 0;

         for(int var4 = 0; var4 < 8; ++var4) {
            byte var5 = (byte)((int)(var1 >>> 8 * (7 - var4) & 255L));
            if (var5 != 0) {
               ++var3;
               this.tmpBuffer10[var3] = var5;
            }
         }

         this.tmpBuffer10[0] = (byte)var3;
         this.dataBuffer.put(this.tmpBuffer10, 0, this.tmpBuffer10[0] + 1);
      }
   }

   final void marshalB1Array(byte[] var1) throws IOException {
      this.marshalB1Array(var1, 0, var1.length);
   }

   final void marshalB1Array(byte[] var1, int var2, int var3) throws IOException {
      this.prepareForWriting();
      this.bytesWrittenSoFar = 0;

      for(this.bytesToWriteInNextCall = 0; this.bytesWrittenSoFar < var3; this.bytesWrittenSoFar += this.bytesToWriteInNextCall) {
         if (this.dataBuffer.remaining() == 0) {
            this.nsDataChannel.writeDataToSocketChannel();
         }

         this.bytesToWriteInNextCall = Math.min(this.dataBuffer.remaining(), var3 - this.bytesWrittenSoFar);
         this.dataBuffer.put(var1, var2 + this.bytesWrittenSoFar, this.bytesToWriteInNextCall);
      }

      this.bytesReadyToGo = true;
   }

   final byte unmarshalSB1() throws SQLException, IOException {
      byte var1 = (byte)this.unmarshalSB2();
      return var1;
   }

   final short unmarshalUB1() throws SQLException, IOException {
      this.prepareForReading();
      short var1 = (short)(this.dataBuffer.get() & 255);
      return var1;
   }

   final short unmarshalSB2() throws SQLException, IOException {
      this.prepareForReading();
      if (this.types.rep[1] != 1 && this.dataBuffer.remaining() >= 2) {
         return this.dataBuffer.getShort();
      } else {
         short var1 = (short)this.unmarshalUB2();
         return var1;
      }
   }

   final int unmarshalUB2() throws SQLException, IOException {
      int var1 = (int)this.buffer2Value((byte)1);
      return var1 & '\uffff';
   }

   final int unmarshalSB4() throws SQLException, IOException {
      this.prepareForReading();
      return this.types.rep[1] != 1 && this.dataBuffer.remaining() >= 4 ? this.dataBuffer.getInt() : (int)this.buffer2Value((byte)2);
   }

   final long unmarshalUB4() throws SQLException, IOException {
      return (long)this.unmarshalSB4() & 4294967295L;
   }

   byte[] unmarshalNBytes(int var1) throws SQLException, IOException {
      byte[] var2 = new byte[var1];
      this.getNBytes(var2, 0, var1);
      return var2;
   }

   int unmarshalNBytes(byte[] var1, int var2, int var3) throws SQLException, IOException {
      return this.getNBytes(var1, var2, var3);
   }

   int getNBytes(byte[] var1, int var2, int var3) throws SQLException, IOException {
      if (var2 + var3 > var1.length) {
         var3 = var1.length - var2;
      }

      boolean var4 = false;
      this.prepareForReading();

      int var5;
      int var6;
      for(var5 = 0; var5 < var3; var5 += this.dataBuffer.position() - var6) {
         if (!this.dataBuffer.hasRemaining()) {
            this.prepareForReading();
         }

         var6 = this.dataBuffer.position();
         this.dataBuffer.get(var1, var2 + var5, Math.min(var3 - var5, this.dataBuffer.remaining()));
      }

      return var5;
   }

   byte[] getNBytes(int var1) throws SQLException, IOException {
      return this.unmarshalNBytes(var1);
   }

   byte[] unmarshalTEXT(int var1) throws SQLException, IOException {
      int var2 = 0;
      byte[] var3 = new byte[var1];

      while(var2 < var1) {
         this.prepareForReading();
         var3[var2] = this.dataBuffer.get();
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
      long var2 = 0L;
      byte var4 = this.types.rep[var1];
      int var5 = 0;
      boolean var6 = false;
      if (var4 == 1) {
         this.prepareForReading();
         var5 = this.dataBuffer.get();
         if (var5 == 0) {
            return 0L;
         }

         if ((var5 & 128) > 0) {
            var5 &= 127;
            var6 = true;
         }
      } else {
         switch(var1) {
         case 1:
            var5 = 2;
            break;
         case 2:
            var5 = 4;
            break;
         case 3:
            var5 = 8;
         }
      }

      if (this.dataBuffer.remaining() < var5 || var5 != 1 && var5 != 2 && var5 != 4 && var5 != 8) {
         this.unmarshalNBytes(this.tmpBuffer8, 0, var5);

         for(int var7 = 0; var7 < var5; ++var7) {
            if (var4 != 1 && var4 == 2) {
               var2 |= ((long)this.tmpBuffer8[var7] & 255L) << 8 * var7;
            } else {
               var2 |= ((long)this.tmpBuffer8[var7] & 255L) << 8 * (var5 - var7 - 1);
            }
         }
      } else {
         this.prepareForReading();
         if (var5 == 1) {
            var2 = (long)this.dataBuffer.get() & 255L;
         } else if (var5 == 2) {
            var2 = (long)this.dataBuffer.getShort() & 65535L;
         } else if (var5 == 4) {
            var2 = (long)this.dataBuffer.getInt() & -1L;
         } else {
            var2 = this.dataBuffer.getLong();
         }
      }

      if (var6) {
         var2 *= -1L;
      }

      return var2;
   }

   void setByteOrder(byte var1) {
      if (var1 == 2) {
         this.dataBuffer.order(ByteOrder.LITTLE_ENDIAN);
      } else {
         this.dataBuffer.order(ByteOrder.BIG_ENDIAN);
      }

   }

   protected void flush() throws IOException {
      this.nsDataChannel.writeDataToSocketChannel();
      this.bytesReadyToGo = false;
   }

   void writeZeroCopyIO(byte[] var1, int var2, int var3) throws IOException, NetException {
      this.net.writeZeroCopyIO(var1, var2, var3);
   }
}
