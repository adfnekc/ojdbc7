package oracle.jdbc.driver;

import java.io.IOException;
import java.sql.SQLException;

class T4CTTIosessget extends T4CTTIfun {
   static final int SESSGET_TAG_MISMATCH = 1;
   static final int SESSGET_PURITY_NEW = 2;
   static final int SESSGET_SESSION_CHANGED = 4;
   static final int SESSGET_STMTCACHE_DESTROY = 8;
   int sessgetokvn;
   KeywordValueI[] sessgetokv;
   long sessgetflags;
   private static final String _Copyright_2007_Oracle_All_Rights_Reserved_ = null;
   public static final String BUILD_DATE = "Thu_Apr_04_15:09:24_PDT_2013";
   public static final boolean TRACE = false;

   T4CTTIosessget(T4CConnection var1) {
      super(var1, (byte)3);
      this.setFunCode((short)162);
   }

   void marshal() throws IOException {
      this.sessgetflags = 0L;
      this.meg.marshalDALC(T4CMAREngine.NO_BYTES);
      this.meg.marshalPTR();
      this.meg.marshalPTR();
   }

   void readRPA() throws IOException, SQLException {
      int var1 = this.meg.unmarshalUB2();
      short var2 = this.meg.unmarshalUB1();
      this.meg.unmarshalNBytes(var2);
   }
}
