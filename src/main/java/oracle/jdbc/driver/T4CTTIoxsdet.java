package oracle.jdbc.driver;

import java.io.IOException;
import java.sql.SQLException;
import oracle.jdbc.internal.XSSecureId;

final class T4CTTIoxsdet extends T4CTTIfun {
   private int opcode;
   private byte[] sessionId;
   private XSSecureId secureId;
   private static final String _Copyright_2007_Oracle_All_Rights_Reserved_ = null;
   public static final String BUILD_DATE = "Thu_Apr_04_15:09:24_PDT_2013";
   public static final boolean TRACE = false;

   T4CTTIoxsdet(T4CConnection var1) {
      super(var1, (byte)3);
      this.setFunCode((short)181);
   }

   void doOXSDET(int var1, byte[] var2, XSSecureId var3, boolean var4) throws IOException, SQLException {
      if (var4) {
         this.setTTCCode((byte)3);
      } else {
         this.setTTCCode((byte)17);
      }

      this.opcode = var1;
      this.sessionId = var2;
      this.secureId = var3;
      if (var4) {
         this.doRPC();
      } else {
         this.doPigRPC();
      }

   }

   void marshal() throws IOException {
      this.meg.marshalUB4((long)this.opcode);
      boolean var1 = false;
      if (this.sessionId != null && this.sessionId.length > 0) {
         var1 = true;
         this.meg.marshalPTR();
         this.meg.marshalUB4((long)this.sessionId.length);
      } else {
         this.meg.marshalNULLPTR();
         this.meg.marshalUB4(0L);
      }

      if (this.secureId == null) {
         this.meg.marshalNULLPTR();
      } else {
         this.meg.marshalPTR();
      }

      if (var1) {
         this.meg.marshalB1Array(this.sessionId);
      }

      if (this.secureId != null) {
         ((XSSecureIdI)this.secureId).marshal(this.meg);
      }

   }
}
