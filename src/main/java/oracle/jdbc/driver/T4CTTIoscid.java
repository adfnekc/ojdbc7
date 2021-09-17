package oracle.jdbc.driver;

import java.io.IOException;
import java.sql.SQLException;

final class T4CTTIoscid extends T4CTTIfun {
   static final int KPDUSR_CID_RESET = 1;
   static final int KPDUSR_PROXY_RESET = 2;
   static final int KPDUSR_PROXY_TKTSENT = 4;
   static final int KPDUSR_MODULE_RESET = 8;
   static final int KPDUSR_ACTION_RESET = 16;
   static final int KPDUSR_EXECID_RESET = 32;
   static final int KPDUSR_EXECSQ_RESET = 64;
   static final int KPDUSR_COLLCT_RESET = 128;
   static final int KPDUSR_CLINFO_RESET = 256;
   static final int KPDUSR_DBOP_RESET = 512;
   private byte[] cidcid = null;
   private byte[] cidmod = null;
   private byte[] cidact = null;
   private byte[] cideci = null;
   private byte[] ciddbop = null;
   private boolean[] endToEndHasChanged = null;
   private String[] endToEndValues = null;
   private int endToEndECIDSequenceNumber;
   private static final String _Copyright_2007_Oracle_All_Rights_Reserved_ = null;
   public static final String BUILD_DATE = "Thu_Apr_04_15:09:24_PDT_2013";
   public static final boolean TRACE = false;

   T4CTTIoscid(T4CConnection var1) {
      super(var1, (byte)17);
      this.setFunCode((short)135);
   }

   void doOSCID(boolean[] var1, String[] var2, int var3) throws IOException, SQLException {
      this.endToEndHasChanged = var1;
      this.endToEndValues = var2;
      this.endToEndECIDSequenceNumber = var3;
      if (this.endToEndValues[1] != null) {
         this.cidcid = this.meg.conv.StringToCharBytes(this.endToEndValues[1]);
      } else {
         this.cidcid = null;
      }

      if (this.endToEndValues[3] != null) {
         this.cidmod = this.meg.conv.StringToCharBytes(this.endToEndValues[3]);
      } else {
         this.cidmod = null;
      }

      if (this.endToEndValues[0] != null) {
         this.cidact = this.meg.conv.StringToCharBytes(this.endToEndValues[0]);
      } else {
         this.cidact = null;
      }

      if (this.endToEndValues[2] != null) {
         this.cideci = this.meg.conv.StringToCharBytes(this.endToEndValues[2]);
      } else {
         this.cideci = null;
      }

      if (this.endToEndValues[4] != null) {
         this.ciddbop = this.meg.conv.StringToCharBytes(this.endToEndValues[4]);
      } else {
         this.ciddbop = null;
      }

      this.doPigRPC();
   }

   void marshal() throws IOException {
      int var1 = 64;
      if (this.endToEndHasChanged[0]) {
         var1 |= 16;
      }

      if (this.endToEndHasChanged[1]) {
         var1 |= 1;
      }

      if (this.endToEndHasChanged[2]) {
         var1 |= 32;
      }

      if (this.endToEndHasChanged[3]) {
         var1 |= 8;
      }

      if (this.endToEndHasChanged[4]) {
         var1 |= 512;
      }

      this.meg.marshalNULLPTR();
      this.meg.marshalNULLPTR();
      this.meg.marshalUB4((long)var1);
      boolean var2 = false;
      boolean var3 = false;
      boolean var4 = false;
      boolean var5 = false;
      boolean var6 = false;
      if (this.endToEndHasChanged[1]) {
         this.meg.marshalPTR();
         if (this.cidcid != null) {
            this.meg.marshalUB4((long)this.cidcid.length);
         } else {
            this.meg.marshalUB4(0L);
         }

         var2 = true;
      } else {
         this.meg.marshalNULLPTR();
         this.meg.marshalUB4(0L);
      }

      if (this.endToEndHasChanged[3]) {
         this.meg.marshalPTR();
         if (this.cidmod != null) {
            this.meg.marshalUB4((long)this.cidmod.length);
         } else {
            this.meg.marshalUB4(0L);
         }

         var3 = true;
      } else {
         this.meg.marshalNULLPTR();
         this.meg.marshalUB4(0L);
      }

      if (this.endToEndHasChanged[0]) {
         this.meg.marshalPTR();
         if (this.cidact != null) {
            this.meg.marshalUB4((long)this.cidact.length);
         } else {
            this.meg.marshalUB4(0L);
         }

         var4 = true;
      } else {
         this.meg.marshalNULLPTR();
         this.meg.marshalUB4(0L);
      }

      if (this.endToEndHasChanged[2]) {
         this.meg.marshalPTR();
         if (this.cideci != null) {
            this.meg.marshalUB4((long)this.cideci.length);
         } else {
            this.meg.marshalUB4(0L);
         }

         var5 = true;
      } else {
         this.meg.marshalNULLPTR();
         this.meg.marshalUB4(0L);
      }

      this.meg.marshalUB2(0);
      this.meg.marshalUB2(this.endToEndECIDSequenceNumber);
      this.meg.marshalNULLPTR();
      this.meg.marshalUB4(0L);
      this.meg.marshalNULLPTR();
      this.meg.marshalUB4(0L);
      this.meg.marshalNULLPTR();
      this.meg.marshalUB4(0L);
      if (this.connection.getTTCVersion() >= 7) {
         if (this.endToEndHasChanged[4]) {
            this.meg.marshalPTR();
            if (this.ciddbop != null) {
               this.meg.marshalUB4((long)this.ciddbop.length);
            } else {
               this.meg.marshalUB4(0L);
            }

            var6 = true;
         } else {
            this.meg.marshalNULLPTR();
            this.meg.marshalUB4(0L);
         }
      }

      if (var2 && this.cidcid != null) {
         this.meg.marshalCHR(this.cidcid);
      }

      if (var3 && this.cidmod != null) {
         this.meg.marshalCHR(this.cidmod);
      }

      if (var4 && this.cidact != null) {
         this.meg.marshalCHR(this.cidact);
      }

      if (var5 && this.cideci != null) {
         this.meg.marshalCHR(this.cideci);
      }

      if (var6 && this.ciddbop != null) {
         this.meg.marshalCHR(this.ciddbop);
      }

   }
}
