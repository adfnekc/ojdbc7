package oracle.jdbc.driver;

import java.io.IOException;
import java.sql.SQLException;
import java.sql.SQLWarning;

final class T4CTTIspfp extends T4CTTIfun {
   private static final String _Copyright_2007_Oracle_All_Rights_Reserved_ = null;
   public static final String BUILD_DATE = "Thu_Apr_04_15:09:24_PDT_2013";
   public static final boolean TRACE = false;

   T4CTTIspfp(T4CConnection var1) {
      super(var1, (byte)3);
      this.setFunCode((short)138);
   }

   void doOSPFPPUT() throws IOException, SQLException {
      this.doRPC();
   }

   void marshal() throws IOException {
      this.meg.marshalPTR();
      this.meg.marshalSWORD(100);
      this.meg.marshalPTR();
      this.meg.marshalPTR();
      this.meg.marshalSWORD(0);
      this.meg.marshalNULLPTR();
      this.meg.marshalSWORD(0);
      this.meg.marshalNULLPTR();
      this.meg.marshalNULLPTR();
   }

   void readRPA() throws IOException, SQLException {
      int var1 = this.meg.unmarshalUB2();
      byte[] var2 = this.meg.unmarshalNBytes(var1);
      if (var1 > 1) {
         String var3 = this.meg.conv.CharBytesToString(var2, var1, true);
         SQLWarning var4 = new SQLWarning(var3);
         SQLWarning var5 = this.connection.getWarnings();
         if (var5 == null) {
            this.connection.setWarnings(var4);
         } else {
            var5.setNextWarning(var4);
         }
      }

      this.meg.unmarshalUB2();
      this.meg.unmarshalUB2();
   }

   protected oracle.jdbc.internal.OracleConnection getConnectionDuringExceptionHandling() {
      return this.connection;
   }
}
