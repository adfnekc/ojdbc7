package oracle.jdbc.driver;

import java.io.IOException;
import java.sql.SQLException;

class T4C8TTIuds extends T4CTTIMsg {
   T4CTTIoac udsoac;
   boolean udsnull;
   short udscnl;
   byte optimizeOAC;
   byte[] udscolnm;
   short udscolnl;
   byte[] udssnm;
   long udssnl;
   int[] snnumchar;
   byte[] udstnm;
   long udstnl;
   int[] tnnumchar;
   int[] numBytes;
   short udskpos = -1;
   int udsflg;
   static final int UDSFCOLSEC_ENABLED = 1;
   static final int UDSFCOLSEC_UNKNOWN = 2;
   static final int UDSFCOLSEC_UNAUTH_DATA_NULL = 4;
   static final int UDSFCOL_IS_INVISIBLE = 8;
   private static final String _Copyright_2007_Oracle_All_Rights_Reserved_ = null;
   public static final String BUILD_DATE = "Thu_Apr_04_15:09:24_PDT_2013";
   public static final boolean TRACE = false;

   T4C8TTIuds(T4CConnection var1) {
      super(var1, (byte)0);
      this.udsoac = new T4CTTIoac(var1);
   }

   void unmarshal() throws IOException, SQLException {
      this.udsoac.unmarshal();
      short var1 = this.meg.unmarshalUB1();
      this.udsnull = var1 > 0;
      this.udscnl = this.meg.unmarshalUB1();
      this.numBytes = new int[1];
      this.udscolnm = this.meg.unmarshalDALC(this.numBytes);
      this.snnumchar = new int[1];
      this.udssnm = this.meg.unmarshalDALC(this.snnumchar);
      this.udssnl = (long)this.udssnm.length;
      this.tnnumchar = new int[1];
      this.udstnm = this.meg.unmarshalDALC(this.tnnumchar);
      this.udstnl = (long)this.udstnm.length;
      if (this.connection.getTTCVersion() >= 3) {
         this.udskpos = (short)this.meg.unmarshalUB2();
         if (this.connection.getTTCVersion() >= 6) {
            this.udsflg = (int)this.meg.unmarshalUB4();
         }
      } else {
         this.udskpos = -1;
      }

   }

   short getKernelPosition() {
      return this.udskpos;
   }

   byte[] getColumName() {
      return this.udscolnm;
   }

   byte[] getTypeName() {
      return this.udstnm;
   }

   byte[] getSchemaName() {
      return this.udssnm;
   }

   short getTypeCharLength() {
      return (short)this.tnnumchar[0];
   }

   short getColumNameByteLength() {
      return (short)this.numBytes[0];
   }

   short getSchemaCharLength() {
      return (short)this.snnumchar[0];
   }

   void print() {
   }
}
