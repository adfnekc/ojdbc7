package oracle.jdbc.driver;

import java.io.IOException;
import java.sql.SQLException;
import oracle.jdbc.internal.XSSecureId;

final class T4CTTIoxsdes extends T4CTTIfun {
   private byte[] kpxsdesopsid;
   private XSSecureId kpxsdesopsidp;
   private byte[] kpxsdesopcookie;

   T4CTTIoxsdes(T4CConnection var1) {
      super(var1, (byte)3);
      this.setFunCode((short)182);
   }

   void doOXSDES(byte[] var1, XSSecureId var2, byte[] var3) throws IOException, SQLException {
      this.kpxsdesopsid = var1;
      this.kpxsdesopsidp = var2;
      this.kpxsdesopcookie = var3;
      this.doRPC();
   }

   void marshal() throws IOException {
      boolean var1 = false;
      if (this.kpxsdesopsid != null && this.kpxsdesopsid.length > 0) {
         var1 = true;
         this.meg.marshalPTR();
         this.meg.marshalUB4((long)this.kpxsdesopsid.length);
      } else {
         this.meg.marshalNULLPTR();
         this.meg.marshalUB4(0L);
      }

      boolean var2 = false;
      if (this.kpxsdesopsidp != null) {
         var2 = true;
         this.meg.marshalPTR();
      } else {
         this.meg.marshalNULLPTR();
      }

      boolean var3 = false;
      if (this.kpxsdesopcookie != null && this.kpxsdesopcookie.length > 0) {
         var3 = true;
         this.meg.marshalPTR();
         this.meg.marshalUB4((long)this.kpxsdesopcookie.length);
      } else {
         this.meg.marshalNULLPTR();
         this.meg.marshalUB4(0L);
      }

      if (var1) {
         this.meg.marshalB1Array(this.kpxsdesopsid);
      }

      if (var2) {
         ((XSSecureIdI)this.kpxsdesopsidp).marshal(this.meg);
      }

      if (var3) {
         this.meg.marshalB1Array(this.kpxsdesopcookie);
      }

   }

   protected oracle.jdbc.internal.OracleConnection getConnectionDuringExceptionHandling() {
      return this.connection;
   }
}
