package oracle.net.ns;

import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.io.OutputStream;
import oracle.net.jdbc.nl.NLException;
import oracle.net.jdbc.nl.NVFactory;
import oracle.net.jdbc.nl.NVNavigator;
import oracle.net.jdbc.nl.NVPair;
import oracle.net.nt.ConnOption;

public class NSProtocolStream extends NSProtocol {
   private MarkerPacket mkPkt;
   private DataPacket probePacket;
   private Packet packet;
   private static final String _Copyright_2007_Oracle_All_Rights_Reserved_ = null;
   public static final String BUILD_DATE = "Thu_Apr_04_15:09:24_PDT_2013";
   public static final boolean TRACE = false;

   public NSProtocolStream() {
      this.sAtts = new SessionAtts(this, 2097152, 2097152, false, false);
      this.sAtts.connected = false;
   }

   void negotiateConnection(NVFactory var1, NVNavigator var2, boolean var3, boolean var4) throws IOException, NetException {
      NVPair var9 = null;
      String var10 = null;

      while(true) {
         IOException var11 = null;
         ConnectPacket var5 = new ConnectPacket(this.sAtts, !var3, var4);
         this.packet = new Packet(this.sAtts, this.sAtts.getSDU());

         try {
            var5.send();
            this.packet.receive();
         } catch (InterruptedIOException var18) {
            throw var18;
         } catch (IOException var19) {
            this.packet.type = 4;
            var11 = var19;
         }

         RefusePacket var7;
         RedirectPacket var8;
         switch(this.packet.type) {
         case 2:
            new AcceptPacket(this.packet);
            this.setNetStreams();
            this.packet = null;
            var5 = null;
            Object var6 = null;
            var8 = null;
            var7 = null;
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
            var7 = new RefusePacket(this.packet);
            this.sAtts.cOption.nt.disconnect();
            this.sAtts.cOption = null;
            this.establishConnection((String)null);
            if (this.sAtts.cOption == null) {
               if (var11 != null) {
                  throw var11;
               }

               try {
                  var9 = var2.findNVPairRecurse(var1.createNVPair(var7.getData()), "ERROR");
                  if (var9 != null) {
                     NVPair var16 = var2.findNVPairRecurse(var9, "CODE");
                     if (var16 != null) {
                        var10 = var16.valueToString();
                     }
                  }
               } catch (NLException var17) {
                  System.err.println(var17.getMessage());
               }

               throw new NetException(var10 == null ? 206 : Integer.parseInt(var10), "");
            }
            break;
         case 5:
            var8 = new RedirectPacket(this.packet);
            ConnOption var12 = this.sAtts.cOption;
            this.addrRes.connection_redirected = true;
            this.sAtts.cOption.nt.disconnect();
            String var13 = var8.getData();
            String var14 = var13;
            String var15 = null;
            if ((var8.flags & 2) == 2 && var13.indexOf(0) != -1) {
               var14 = var13.substring(0, var13.indexOf(0));
               this.sAtts.redirecting = true;
               var15 = var13.substring(var13.indexOf(0) + 1, var13.length());
            }

            this.sAtts = this.establishConnection(var14);
            this.sAtts.cOption.restoreFromOrigCoption(var12);
            if (this.sAtts.redirecting) {
               this.sAtts.cOption.conn_data.setLength(0);
               this.sAtts.cOption.conn_data.append(var15);
            }
            break;
         case 11:
            if ((this.packet.flags & 8) == 8) {
               this.sAtts.renegotiateSSLSession();
            }
         }
      }
   }

   public void writeZeroCopyIO(byte[] var1, int var2, int var3) throws IOException, NetException {
      NetOutputStream var4 = this.getNetOutputStream();
      var4.writeZeroCopyIO(var1, var2, var3);
   }

   public boolean readZeroCopyIO(byte[] var1, int var2, int[] var3) throws IOException, NetException {
      NetInputStream var4 = this.getNetInputStream();
      boolean var5 = var4.readZeroCopyIO(var1, var2, var3);
      return var5;
   }

   public void disconnect() throws IOException, NetException {
      if (!this.sAtts.connected) {
         throw new NetException(200);
      } else {
         IOException var1 = null;

         try {
            this.sAtts.nsOutputStream.close();
         } catch (IOException var3) {
            var1 = var3;
         }

         this.sAtts.connected = false;
         this.sAtts.cOption.nt.disconnect();
         if (var1 != null) {
            throw var1;
         }
      }
   }

   public void sendReset() throws IOException, NetException {
      if (!this.sAtts.connected) {
         throw new NetException(200);
      } else {
         this.sendMarker(2);

         while(this.sAtts.onBreakReset) {
            Packet var1 = ((NetInputStream)this.sAtts.getInputStream()).getCurrentPacket();
            var1.receive();
            if (var1.type == 12) {
               this.mkPkt = new MarkerPacket(var1);
               if (this.mkPkt.data == 2) {
                  this.sAtts.onBreakReset = false;
               }
            }
         }

         this.mkPkt = null;
      }
   }

   public NetInputStream getNetInputStream() throws NetException {
      if (!this.sAtts.connected) {
         throw new NetException(200);
      } else {
         return this.sAtts.nsInputStream;
      }
   }

   public InputStream getInputStream() throws NetException {
      return this.getNetInputStream();
   }

   public NetOutputStream getNetOutputStream() throws NetException {
      if (!this.sAtts.connected) {
         throw new NetException(200);
      } else {
         return this.sAtts.nsOutputStream;
      }
   }

   public OutputStream getOutputStream() throws NetException {
      return this.getNetOutputStream();
   }

   void initializeSessionAttributes() throws NetException, IOException {
      this.sAtts.ntInputStream = this.sAtts.cOption.nt.getInputStream();
      this.sAtts.ntOutputStream = this.sAtts.cOption.nt.getOutputStream();
      this.sAtts.dataEOF = false;
      if (this.sAtts.attemptingReconnect) {
         this.sAtts.nsOutputStream.reinitialize(this.sAtts);
         this.sAtts.nsInputStream.reinitialize(this.sAtts);
         if (this.mkPkt != null) {
            this.mkPkt.reinitialize(this.sAtts);
         }
      } else {
         this.sAtts.nsOutputStream = new NetOutputStream(this.sAtts, 255);
         this.sAtts.nsInputStream = new NetInputStream(this.sAtts);
      }

   }

   private void setNetStreams() throws NetException, IOException {
      this.sAtts.nsOutputStream = new NetOutputStream(this.sAtts);
      this.sAtts.nsInputStream = new NetInputStream(this.sAtts);
   }

   protected void sendMarker(int var1) throws IOException, NetException {
      if (!this.sAtts.connected) {
         throw new NetException(200);
      } else {
         this.mkPkt = new MarkerPacket(this.sAtts, var1);
         this.mkPkt.send();
         this.mkPkt = null;
      }
   }

   void sendProbePacket() throws IOException {
      if (this.probePacket == null) {
         this.probePacket = new DataPacket(this.sAtts, 26);
      } else {
         this.probePacket.reinitialize(this.sAtts);
      }

      this.probePacket.send();
   }
}
