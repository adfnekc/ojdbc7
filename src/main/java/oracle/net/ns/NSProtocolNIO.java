package oracle.net.ns;

import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import oracle.net.jdbc.nl.NLException;
import oracle.net.jdbc.nl.NVFactory;
import oracle.net.jdbc.nl.NVNavigator;
import oracle.net.jdbc.nl.NVPair;
import oracle.net.nt.ConnOption;

public class NSProtocolNIO extends NSProtocol {
   private static final byte[] ANO_NEGOTIATION_SEND = new byte[]{-34, -83, -66, -17, 0, -110, 10, 32, 0, 0, 0, 4, 0, 0, 4, 0, 3, 0, 0, 0, 0, 0, 4, 0, 5, 10, 32, 0, 0, 0, 8, 0, 1, 9, 9, 9, 9, 9, 9, 9, 9, 0, 18, 0, 1, -34, -83, -66, -17, 0, 3, 0, 0, 0, 4, 0, 4, 0, 1, 0, 2, 0, 3, 0, 1, 0, 3, 0, 0, 0, 0, 0, 4, 0, 5, 10, 32, 0, 0, 0, 2, 0, 3, -32, -31, 0, 2, 0, 6, -4, -1, 0, 2, 0, 2, 0, 0, 0, 0, 0, 4, 0, 5, 10, 32, 0, 0, 0, 12, 0, 1, 0, 1, 8, 10, 6, 3, 2, 11, 12, 15, 16, 17, 0, 3, 0, 2, 0, 0, 0, 0, 0, 4, 0, 5, 10, 32, 0, 0, 0, 3, 0, 1, 0, 1, 3};
   private NIONSDataChannel probePacket;
   private static final String _Copyright_2007_Oracle_All_Rights_Reserved_ = null;
   public static final String BUILD_DATE = "Thu_Apr_04_15:09:24_PDT_2013";
   public static final boolean TRACE = false;

   public NSProtocolNIO(boolean var1) {
      this.sAtts = new SessionAtts(this, 2097152, 2097152, true, var1);
      this.ACTIVATE_ANO_NIO = false;
   }

   void negotiateConnection(NVFactory var1, NVNavigator var2, boolean var3, boolean var4) throws IOException, NetException {
      NIOConnectPacket var5 = new NIOConnectPacket(this.sAtts);
      NVPair var9 = null;
      String var10 = null;

      while(true) {
         IOException var11 = null;
         NIOPacket var12 = null;
         boolean var13 = false;

         int var21;
         try {
            var5.writeToSocketChannel(this.sAtts.cOption.conn_data.toString(), !var3, var4, this.sAtts.nt.isCharacteristicUrgentSupported(), this.sAtts.getSDU(), this.sAtts.getTDU(), this.sAtts.getANOFlags());
            var12 = NIOPacket.readNIOPacket(this.sAtts);
            var21 = var12.header.type;
         } catch (InterruptedIOException var19) {
            throw var19;
         } catch (IOException var20) {
            var21 = 4;
            var11 = var20;
         }

         switch(var21) {
         case 2:
            NIOAcceptPacket var6 = (NIOAcceptPacket)var12;
            this.sAtts.setNegotiatedSDUAndTDU(var6.sduSize, var6.tduSize);
            this.sAtts.setNegotiatedOptions(var6.options);
            this.sAtts.payloadDataBuffer.put(ANO_NEGOTIATION_SEND);
            this.sAtts.dataChannel.writeDataToSocketChannel();
            this.sAtts.dataChannel.readDataFromSocketChannel();
            return;
         case 3:
         case 6:
         case 7:
         case 8:
         case 9:
         case 10:
         default:
            this.sAtts.cOption.nt.disconnect();
            throw new NetException(205);
         case 4:
            this.sAtts.cOption.nt.disconnect();
            this.sAtts.cOption = null;
            this.establishConnection((String)null);
            if (this.sAtts.cOption == null) {
               if (var11 != null) {
                  throw var11;
               }

               if (var12 != null) {
                  NIORefusePacket var7 = (NIORefusePacket)var12;

                  try {
                     var9 = var2.findNVPairRecurse(var1.createNVPair(var7.refuseData), "ERROR");
                     if (var9 != null) {
                        NVPair var17 = var2.findNVPairRecurse(var9, "CODE");
                        if (var17 != null) {
                           var10 = var17.valueToString();
                        }
                     }
                  } catch (NLException var18) {
                     System.err.println(var18.getMessage());
                  }

                  throw new NetException(var10 == null ? 206 : Integer.parseInt(var10), "");
               }
            }
            break;
         case 5:
            NIORedirectPacket var8 = (NIORedirectPacket)var12;
            ConnOption var14 = this.sAtts.cOption;
            this.addrRes.connection_redirected = true;
            this.sAtts.cOption.nt.disconnect();
            String var15 = var8.redirectData;
            String var16 = null;
            if ((var8.header.flags & 2) == 2 && var8.redirectData.indexOf(0) != -1) {
               var15 = var8.redirectData.substring(0, var8.redirectData.indexOf(0));
               this.sAtts.redirecting = true;
               var16 = var8.redirectData.substring(var8.redirectData.indexOf(0) + 1, var8.redirectData.length());
            }

            this.establishConnection(var15);
            this.sAtts.cOption.restoreFromOrigCoption(var14);
            if (this.sAtts.redirecting) {
               this.sAtts.cOption.conn_data.setLength(0);
               this.sAtts.cOption.conn_data.append(var16);
            }
         case 11:
         }
      }
   }

   public void writeZeroCopyIO(byte[] var1, int var2, int var3) throws IOException {
      this.sAtts.dataChannel.writeDataToSocketChannel();
      int var4 = var3;

      int var5;
      for(boolean var6 = false; var4 > 0; var4 -= var5) {
         if (var4 >= 1703910) {
            var5 = 1703910;
         } else {
            var5 = var4;
            var6 = true;
         }

         this.sAtts.ddPacket.writeToSocketChannel(var5, var6);
         ByteBuffer var7 = ByteBuffer.wrap(var1, var2, var5);

         while(var7.hasRemaining()) {
            this.sAtts.socketChannel.write(var7);
         }

         var2 += var5;
      }

   }

   public boolean readZeroCopyIO(byte[] var1, int var2, int[] var3) throws IOException {
      boolean var4 = false;
      this.sAtts.ddPacket.readFromSocketChannel(true);
      this.sAtts.ddPacket.readPayloadBuffer();
      int var5 = this.sAtts.ddPacket.totalDataLength;
      if ((this.sAtts.ddPacket.descriptorFLaG & 1) != 0) {
         var4 = true;
      }

      if (var1.length < var2 + var5) {
         throw new IOException("Assertion Failed");
      } else {
         int var6 = 0;

         for(ByteBuffer var7 = this.sAtts.buffer; var6 < var5; var6 += var7.limit()) {
            var7.clear();
            var7.limit(Math.min(var7.capacity(), var5 - var6));

            while(var7.hasRemaining()) {
               this.sAtts.socketChannel.read(var7);
            }

            var7.get(var1, var2 + var6, var7.limit());
         }

         var3[0] = var6;
         return var4;
      }
   }

   public void disconnect() throws IOException, NetException {
      if (!this.sAtts.connected) {
         throw new NetException(200);
      } else {
         // todo
//         Object var1 = null;
         this.sAtts.connected = false;
         this.sAtts.cOption.nt.disconnect();
//         if (var1 != null) {
//            throw var1;
//         }
      }
   }

   public void sendReset() throws IOException, NetException {
      if (!this.sAtts.connected) {
         throw new NetException(200);
      } else {
         this.sendMarker(2);

         while(this.sAtts.onBreakReset) {
            this.sAtts.markerPacket.readFromSocketChannel(true, false);
            this.sAtts.markerPacket.readPayloadBuffer();
            if (this.sAtts.markerPacket.isResetPkt()) {
               this.sAtts.onBreakReset = false;
            }
         }

      }
   }

   public NetInputStream getNetInputStream() throws NetException, IOException {
      throw new UnsupportedOperationException("Unsupported operation in NIO");
   }

   public InputStream getInputStream() throws NetException, IOException {
      return this.getNetInputStream();
   }

   public NetOutputStream getNetOutputStream() throws NetException, IOException {
      throw new UnsupportedOperationException("Unsupported operation in NIO");
   }

   public OutputStream getOutputStream() throws NetException, IOException {
      return this.getNetOutputStream();
   }

   void initializeSessionAttributes() throws NetException, IOException {
      this.sAtts.socketChannel = this.sAtts.nt.getSocketChannel();
      this.sAtts.initializeBuffer(this.sAtts.getSDU());
   }

   protected void sendMarker(int var1) throws IOException, NetException {
      if (!this.sAtts.connected) {
         throw new NetException(200);
      } else {
         this.sAtts.markerPacket.writeToSocketChannel(var1);
      }
   }

   void sendProbePacket() throws IOException {
      if (this.probePacket == null) {
         this.probePacket = new NIONSDataChannel(this.sAtts);
      } else {
         this.probePacket.reinitialize(this.sAtts);
      }

      byte[] var1 = new byte[26];
      this.probePacket.writeDataToSocketChannel(var1);
   }
}
