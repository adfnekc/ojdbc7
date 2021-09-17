package oracle.jdbc.driver;

import java.io.IOException;
import java.sql.SQLException;
import oracle.jdbc.internal.KeywordValueLong;

final class T4CTTIoxsspo extends T4CTTIfun {
   private int functionId;
   private byte[] sessionId;
   private KeywordValueLong[] inKV;
   private int inFlags;
   private static final String _Copyright_2007_Oracle_All_Rights_Reserved_ = null;
   public static final String BUILD_DATE = "Thu_Apr_04_15:09:24_PDT_2013";
   public static final boolean TRACE = false;

   T4CTTIoxsspo(T4CConnection var1) {
      super(var1, (byte)17);
      this.setFunCode((short)157);
   }

   void doOXSSPO(int var1, byte[] var2, KeywordValueLong[] var3, int var4) throws IOException, SQLException {
      this.functionId = var1;
      this.sessionId = var2;
      this.inKV = var3;
      this.inFlags = var4;
      if (this.inKV != null) {
         for(int var5 = 0; var5 < this.inKV.length; ++var5) {
            ((KeywordValueLongI)this.inKV[var5]).doCharConversion(this.meg.conv);
         }
      }

      this.doPigRPC();
   }

   void marshal() throws IOException {
      this.meg.marshalUB4((long)this.functionId);
      boolean var1 = false;
      if (this.sessionId != null && this.sessionId.length > 0) {
         var1 = true;
         this.meg.marshalPTR();
         this.meg.marshalUB4((long)this.sessionId.length);
      } else {
         this.meg.marshalNULLPTR();
         this.meg.marshalUB4(0L);
      }

      boolean var2 = false;
      if (this.inKV != null && this.inKV.length > 0) {
         var2 = true;
         this.meg.marshalPTR();
         this.meg.marshalUB4((long)this.inKV.length);
      } else {
         this.meg.marshalNULLPTR();
         this.meg.marshalUB4(0L);
      }

      this.meg.marshalUB4((long)this.inFlags);
      if (var1) {
         this.meg.marshalB1Array(this.sessionId);
      }

      if (var2) {
         for(int var3 = 0; var3 < this.inKV.length; ++var3) {
            ((KeywordValueLongI)this.inKV[var3]).marshal(this.meg);
         }
      }

   }
}
