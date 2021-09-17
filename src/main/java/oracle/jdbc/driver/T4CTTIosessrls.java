package oracle.jdbc.driver;

import java.io.IOException;
import java.sql.SQLException;

class T4CTTIosessrls extends T4CTTIfun {
   String sessrlstag;
   long sessrlsmode;
   static final int SESSRLS_DROPSESS = 1;
   static final int SESSRLS_DEAUTHENTICATE = 2;
   static final int SESSRLS_RETAG = 4;
   private static final String _Copyright_2007_Oracle_All_Rights_Reserved_ = null;
   public static final String BUILD_DATE = "Thu_Apr_04_15:09:24_PDT_2013";
   public static final boolean TRACE = false;

   T4CTTIosessrls(T4CConnection var1) {
      super(var1, (byte)26);
      this.setFunCode((short)163);
   }

   void marshal() throws IOException {
      try {
         byte[] var1 = null;
         this.sessrlsmode = 0L;
         if (this.connection.drcpTagName != null) {
            var1 = this.meg.conv.StringToCharBytes(this.connection.drcpTagName);
            this.meg.marshalPTR();
            this.meg.marshalSWORD(var1.length);
            this.sessrlsmode |= 4L;
         } else {
            this.meg.marshalSWORD(0);
            this.meg.marshalNULLPTR();
         }

         this.meg.marshalUB4(this.sessrlsmode);
         if (var1 != null) {
            this.meg.marshalCHR(var1);
         }
      } catch (SQLException var2) {
      }

   }

   void receive() throws SQLException, IOException {
      int var1 = this.meg.unmarshalSWORD();
      if (var1 > 0) {
         byte[] var2 = this.meg.unmarshalCHR(var1);
         this.sessrlstag = new String(var2);
      }

      this.sessrlsmode = this.meg.unmarshalUB4();
   }
}
