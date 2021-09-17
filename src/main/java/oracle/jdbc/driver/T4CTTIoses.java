package oracle.jdbc.driver;

import java.io.IOException;
import java.sql.SQLException;

final class T4CTTIoses extends T4CTTIfun {
   static final int OSESSWS = 1;
   static final int OSESDET = 3;
   private int sididx;
   private int sidser;
   private int sidopc;
   private static final String _Copyright_2007_Oracle_All_Rights_Reserved_ = null;
   public static final String BUILD_DATE = "Thu_Apr_04_15:09:24_PDT_2013";
   public static final boolean TRACE = false;

   T4CTTIoses(T4CConnection var1) {
      super(var1, (byte)17);
      this.setFunCode((short)107);
   }

   void doO80SES(int var1, int var2, int var3) throws IOException, SQLException {
      this.sididx = var1;
      this.sidser = var2;
      this.sidopc = var3;
      if (this.sidopc != 1 && this.sidopc != 3) {
         throw new SQLException("Wrong operation : can only do switch or detach");
      } else {
         this.doPigRPC();
      }
   }

   void marshal() throws IOException {
      this.meg.marshalUB4((long)this.sididx);
      this.meg.marshalUB4((long)this.sidser);
      this.meg.marshalUB4((long)this.sidopc);
   }
}
