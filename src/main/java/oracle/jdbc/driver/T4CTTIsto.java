package oracle.jdbc.driver;

import java.io.IOException;
import java.sql.SQLException;

final class T4CTTIsto extends T4CTTIfun {
   static final short OV6STRT = 48;
   static final short OV6STOP = 49;
   static final int STOMFDBA = 1;
   static final int STOMFACA = 2;
   static final int STOMFALO = 4;
   static final int STOMFSHU = 8;
   static final int STOMFFRC = 16;
   static final int STOMFPOL = 32;
   static final int STOMFABO = 64;
   static final int STOMFATX = 128;
   static final int STOMFLTX = 256;
   static final int STOSDONE = 1;
   static final int STOSINPR = 2;
   static final int STOSERR = 3;
   private int inmode = 0;
   private int outmode = 0;
   private static final String _Copyright_2007_Oracle_All_Rights_Reserved_ = null;
   public static final String BUILD_DATE = "Thu_Apr_04_15:09:24_PDT_2013";
   public static final boolean TRACE = false;

   T4CTTIsto(T4CConnection var1) {
      super(var1, (byte)3);
   }

   void doOV6STRT(int var1) throws IOException, SQLException {
      this.setFunCode((short)48);
      this.inmode = var1;
      this.outmode = 0;
      this.doRPC();
   }

   void doOV6STOP(int var1) throws IOException, SQLException {
      this.setFunCode((short)49);
      this.inmode = var1;
      this.outmode = 0;
      this.doRPC();
   }

   void marshal() throws IOException {
      this.meg.marshalSWORD(this.inmode);
      this.meg.marshalPTR();
   }

   void readRPA() throws IOException, SQLException {
      this.outmode = (int)this.meg.unmarshalUB4();
      if (this.outmode == 3) {
      }

   }

   protected oracle.jdbc.internal.OracleConnection getConnectionDuringExceptionHandling() {
      return this.connection;
   }
}
