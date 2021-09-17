package oracle.jdbc.driver;

import java.io.IOException;
import java.sql.SQLException;
import oracle.jdbc.internal.KeywordValueLong;

final class T4CTTIoxsscs extends T4CTTIfun {
   private String userName = null;
   private KeywordValueLong[] inKV = null;
   private int inFlags;
   private byte[] userNameArr = null;
   private byte[] sessionId = null;
   private KeywordValueLong[] outKV = null;
   private int outFlags = -1;
   private static final String _Copyright_2007_Oracle_All_Rights_Reserved_ = null;
   public static final String BUILD_DATE = "Thu_Apr_04_15:09:24_PDT_2013";
   public static final boolean TRACE = false;

   T4CTTIoxsscs(T4CConnection var1) {
      super(var1, (byte)3);
      this.setFunCode((short)155);
   }

   void doOXSSCS(String var1, KeywordValueLong[] var2, int var3) throws IOException, SQLException {
      this.userName = var1;
      this.inKV = var2;
      this.inFlags = var3;
      if (this.userName != null && this.userName.length() > 0) {
         this.userNameArr = this.meg.conv.StringToCharBytes(this.userName);
      } else {
         this.userNameArr = null;
      }

      this.sessionId = null;
      this.outKV = null;
      this.outFlags = -1;
      if (this.inKV != null) {
         for(int var4 = 0; var4 < this.inKV.length; ++var4) {
            ((KeywordValueLongI)this.inKV[var4]).doCharConversion(this.meg.conv);
         }
      }

      this.doRPC();
   }

   void marshal() throws IOException {
      this.meg.marshalPTR();
      this.meg.marshalPTR();
      if (this.userNameArr != null) {
         this.meg.marshalPTR();
         this.meg.marshalSB4(this.userNameArr.length);
      } else {
         this.meg.marshalNULLPTR();
         this.meg.marshalSB4(0);
      }

      boolean var1 = false;
      if (this.inKV != null && this.inKV.length > 0) {
         var1 = true;
         this.meg.marshalPTR();
         this.meg.marshalSB4(this.inKV.length);
      } else {
         this.meg.marshalNULLPTR();
         this.meg.marshalSB4(0);
      }

      this.meg.marshalUB4((long)this.inFlags);
      this.meg.marshalPTR();
      this.meg.marshalPTR();
      this.meg.marshalPTR();
      if (this.userNameArr != null) {
         this.meg.marshalCHR(this.userNameArr);
      }

      if (var1) {
         for(int var2 = 0; var2 < this.inKV.length; ++var2) {
            ((KeywordValueLongI)this.inKV[var2]).marshal(this.meg);
         }
      }

   }

   byte[] getSessionId() {
      return this.sessionId;
   }

   KeywordValueLong[] getOutKV() {
      return this.outKV;
   }

   int getOutFlags() {
      return this.outFlags;
   }

   void readRPA() throws SQLException, IOException {
      int var1 = (int)this.meg.unmarshalUB4();
      this.sessionId = this.meg.unmarshalNBytes(var1);
      int var2 = (int)this.meg.unmarshalUB4();
      this.outKV = new KeywordValueLong[var2];

      for(int var3 = 0; var3 < var2; ++var3) {
         this.outKV[var3] = KeywordValueLongI.unmarshal(this.meg);
      }

      this.outFlags = (int)this.meg.unmarshalUB4();
   }

   protected oracle.jdbc.internal.OracleConnection getConnectionDuringExceptionHandling() {
      return this.connection;
   }
}
