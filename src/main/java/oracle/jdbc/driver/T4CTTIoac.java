package oracle.jdbc.driver;

import java.io.IOException;
import java.sql.SQLException;
import oracle.jdbc.oracore.OracleTypeADT;

class T4CTTIoac {
   static final short UACFIND = 1;
   static final short UACFALN = 2;
   static final short UACFRCP = 4;
   static final short UACFBBV = 8;
   static final short UACFNCP = 16;
   static final short UACFBLP = 32;
   static final short UACFARR = 64;
   static final short UACFIGN = 128;
   static final int UACFNSCL = 1;
   static final int UACFBUC = 2;
   static final int UACFSKP = 4;
   static final int UACFCHRCNT = 8;
   static final int UACFNOADJ = 16;
   static final int UACFCUS = 4096;
   static final int UACFLSZ = 33554432;
   static final int UACFVFSP = 134217728;
   static final byte[] NO_BYTES = new byte[0];
   int oaccsi;
   short oaccsfrm;
   static int maxBindArrayLength;
   T4CMAREngine meg;
   T4CConnection connection;
   short oacdty;
   short oacflg;
   short oacpre;
   short oacscl;
   int oacmxl;
   int oacmxlc;
   int oacmal;
   int oacfl2;
   byte[] oactoid;
   int oactoidl;
   int oacvsn;
   private static final String _Copyright_2007_Oracle_All_Rights_Reserved_ = null;
   public static final String BUILD_DATE = "Thu_Apr_04_15:09:24_PDT_2013";
   public static final boolean TRACE = false;

   T4CTTIoac(T4CConnection var1) {
      this.connection = var1;
      this.meg = this.connection.mare;
      this.oactoid = NO_BYTES;
   }

   void init(short var1, int var2) {
      if (var1 != 9 && var1 != 1 && var1 != 996) {
         if (var1 == 104) {
            this.oacdty = 11;
         } else if (var1 != 6 && var1 != 2) {
            if (var1 == 15) {
               this.oacdty = 23;
            } else if (var1 == 116) {
               this.oacdty = 102;
            } else {
               this.oacdty = var1;
            }
         } else {
            this.oacdty = 2;
         }
      } else {
         this.oacdty = 1;
      }

      if (this.oacdty == 1 || this.oacdty == 96) {
         this.oacfl2 = 16;
      }

      if (this.oacdty == 102) {
         this.oacmxl = 1;
      } else {
         this.oacmxl = var2;
      }

      this.oacflg = 3;
   }

   boolean isOldSufficient(T4CTTIoac var1) {
      boolean var2 = false;
      if (this.oactoidl == 0 && var1.oactoidl == 0) {
         if (this.oaccsi == var1.oaccsi && this.oaccsfrm == var1.oaccsfrm && this.oacdty == var1.oacdty && this.oacflg == var1.oacflg && this.oacpre == var1.oacpre && this.oacscl <= var1.oacscl && (this.oacmxl == var1.oacmxl || var1.oacmxl > this.oacmxl && var1.oacmxl < 4000) && this.oacmxlc == var1.oacmxlc && this.oacmal == var1.oacmal && this.oacfl2 == var1.oacfl2 && this.oacvsn == var1.oacvsn) {
            var2 = true;
         }

         return var2;
      } else {
         return false;
      }
   }

   boolean isNType() {
      boolean var1 = this.oaccsfrm == 2;
      return var1;
   }

   void unmarshal() throws IOException, SQLException {
      this.oacdty = this.meg.unmarshalUB1();
      this.oacflg = this.meg.unmarshalUB1();
      this.oacpre = this.meg.unmarshalUB1();
      this.oacscl = (short)this.meg.unmarshalSB1();
      this.oacmxl = this.meg.unmarshalSB4();
      this.oacmal = this.meg.unmarshalSB4();
      this.oacfl2 = this.meg.unmarshalSB4();
      this.oactoid = this.meg.unmarshalDALC();
      this.oactoidl = this.oactoid == null ? 0 : this.oactoid.length;
      this.oacvsn = this.meg.unmarshalUB2();
      this.oaccsi = this.meg.unmarshalUB2();
      this.oaccsfrm = this.meg.unmarshalUB1();
      if (this.connection.getTTCVersion() >= 2) {
         this.oacmxlc = (int)this.meg.unmarshalUB4();
      }

      if (this.oacmxl > 0) {
         switch(this.oacdty) {
         case 2:
            this.oacmxl = 22;
            break;
         case 12:
            this.oacmxl = 7;
            break;
         case 181:
            this.oacmxl = 13;
         }
      }

   }

   void setMal(int var1) {
      this.oacmal = var1;
   }

   void addFlg(short var1) {
      this.oacflg |= var1;
   }

   void addFlg2(int var1) {
      this.oacfl2 |= var1;
   }

   void setFormOfUse(short var1) {
      this.oaccsfrm = var1;
   }

   void setCharset(int var1) {
      this.oaccsi = var1;
   }

   void setMxlc(int var1) {
      this.oacmxlc = var1;
   }

   void setPrecision(short var1) {
      this.oacpre = var1;
   }

   void setTimestampFractionalSecondsPrecision(short var1) {
      this.oacscl = var1;
   }

   void setADT(OracleTypeADT var1) {
      this.oactoid = var1.getTOID();
      this.oacvsn = var1.getTypeVersion();
      this.oaccsi = 2;
      this.oaccsfrm = (short)var1.getCharSetForm();
   }

   void marshal() throws IOException {
      this.meg.marshalUB1(this.oacdty);
      this.meg.marshalUB1(this.oacflg);
      this.meg.marshalUB1(this.oacpre);
      if (this.oacdty != 2 && this.oacdty != 180 && this.oacdty != 181 && this.oacdty != 231 && this.oacdty != 183) {
         this.meg.marshalUB1(this.oacscl);
      } else {
         this.meg.marshalUB2(this.oacscl);
      }

      this.meg.marshalUB4((long)this.oacmxl);
      this.meg.marshalSB4(this.oacmal);
      this.meg.marshalSB4(this.oacfl2);
      this.meg.marshalDALC(this.oactoid);
      this.meg.marshalUB2(this.oacvsn);
      this.meg.marshalUB2(this.oaccsi);
      this.meg.marshalUB1(this.oaccsfrm);
      if (this.connection.getTTCVersion() >= 2) {
         this.meg.marshalUB4((long)this.oacmxlc);
      }

   }
}
