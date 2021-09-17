package oracle.jdbc.driver;

import java.io.IOException;
import java.sql.SQLException;

public class T4CTTIkpdnrdeq extends T4CTTIfun {
   static final short COMMIT_KPNAQDEQ = 1;
   static final short ROLLBACK_KPNAQDEQ = 2;
   long registrationId;
   byte[] clientIdBytes = null;
   byte[] messageId = null;
   short opCode;
   T4CMAREngine mar;
   T4CConnection connection;
   String queue;
   byte[] queueNameBytes = null;
   int noOfAck = 1;

   T4CTTIkpdnrdeq(T4CConnection var1) {
      super(var1, (byte)3);
      this.mar = var1.mare;
      this.connection = var1;
      this.setFunCode((short)186);
   }

   void doOAQEMNDEQ(String var1, short var2, byte[] var3, long var4, String var6) throws SQLException, IOException {
      assert var1 != null && var6 != null : "cliendId is " + var1 + ", queue is " + var6;

      this.clientIdBytes = this.mar.conv.StringToCharBytes(var1);
      this.messageId = var3;
      this.opCode = var2;
      this.registrationId = var4;
      this.queueNameBytes = this.mar.conv.StringToCharBytes(var6);
      this.doRPC();
   }

   void marshal() throws IOException {
      if (this.clientIdBytes != null && this.clientIdBytes.length != 0) {
         this.mar.marshalPTR();
         this.mar.marshalSWORD(this.clientIdBytes.length);
      } else {
         this.mar.marshalNULLPTR();
         this.mar.marshalSWORD(0);
      }

      this.mar.marshalUB1(this.opCode);
      if (this.noOfAck > 0) {
         this.mar.marshalPTR();
         this.mar.marshalUB4((long)this.noOfAck);
      } else {
         this.mar.marshalNULLPTR();
         this.mar.marshalUB4(0L);
      }

      if (this.clientIdBytes != null && this.clientIdBytes.length != 0) {
         this.mar.marshalCHR(this.clientIdBytes);
      }

      for(int var1 = 0; var1 < this.noOfAck; ++var1) {
         T4CTTIkpdnrack var2 = new T4CTTIkpdnrack(this.connection);
         var2.send(this.queueNameBytes, this.registrationId, this.messageId);
      }

   }
}
