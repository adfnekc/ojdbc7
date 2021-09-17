package oracle.jdbc.driver;

import java.io.IOException;
import java.sql.SQLException;

public class T4CTTIkpdnrgnc {
   byte[] kpdnrgnclsc;
   T4CMAREngine mar;
   private static final String _Copyright_2007_Oracle_All_Rights_Reserved_ = null;
   public static final String BUILD_DATE = "Thu_Apr_04_15:09:24_PDT_2013";
   public static final boolean TRACE = false;

   T4CTTIkpdnrgnc(T4CConnection var1) {
      this.mar = var1.mare;
   }

   void receive() throws SQLException, IOException {
      int var1 = this.mar.unmarshalSWORD();
      if (var1 > 0) {
         this.kpdnrgnclsc = new byte[var1];
         int[] var2 = new int[1];
         this.mar.unmarshalCLR(this.kpdnrgnclsc, 0, var2, var1);
      } else {
         this.kpdnrgnclsc = null;
      }

   }

   public byte[] getKpdnrgnclsc() {
      return this.kpdnrgnclsc;
   }
}
