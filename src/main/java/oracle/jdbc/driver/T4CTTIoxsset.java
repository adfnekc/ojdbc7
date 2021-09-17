package oracle.jdbc.driver;

import java.io.IOException;
import java.sql.SQLException;
import oracle.jdbc.internal.XSSecureId;

final class T4CTTIoxsset extends T4CTTIfun {
   oracle.jdbc.internal.OracleConnection.XSSessionSetOperationCode opCode;
   byte[] sessionId;
   XSSecureId sidp;
   XSSessionParametersI sessParam;
   private static final String _Copyright_2007_Oracle_All_Rights_Reserved_ = null;
   public static final String BUILD_DATE = "Thu_Apr_04_15:09:24_PDT_2013";
   public static final boolean TRACE = false;

   T4CTTIoxsset(T4CConnection var1) {
      super(var1, (byte)3);
      this.setFunCode((short)183);
   }

   void doOXSSET(oracle.jdbc.internal.OracleConnection.XSSessionSetOperationCode var1, byte[] var2, XSSecureId var3, XSSessionParametersI var4) throws IOException, SQLException {
      this.opCode = var1;
      this.sessionId = var2;
      this.sidp = var3;
      this.sessParam = var4;
      if (var4 != null) {
         var4.doCharConversion(this.meg.conv);
      }

      this.doRPC();
   }

   void marshal() throws IOException {
      this.meg.marshalUB4((long)this.opCode.getCode());
      boolean var1 = false;
      if (this.sessionId != null && this.sessionId.length > 0) {
         var1 = true;
         this.meg.marshalPTR();
         this.meg.marshalUB4((long)this.sessionId.length);
      } else {
         this.meg.marshalNULLPTR();
         this.meg.marshalUB4(0L);
      }

      if (this.sidp != null) {
         this.meg.marshalPTR();
      } else {
         this.meg.marshalNULLPTR();
      }

      if (this.sessParam != null && this.sessParam.binaryParam != null && this.sessParam.binaryParam.length > 0) {
         this.meg.marshalPTR();
         this.meg.marshalUB4((long)this.sessParam.binaryParam.length);
      } else {
         this.meg.marshalNULLPTR();
         this.meg.marshalUB4(0L);
      }

      if (this.sessParam != null) {
         this.meg.marshalUB4((long)this.sessParam.intParam);
      } else {
         this.meg.marshalUB4(0L);
      }

      if (this.sessParam != null && this.sessParam.textParamBytes != null && this.sessParam.textParamBytes.length > 0) {
         this.meg.marshalPTR();
         this.meg.marshalUB4((long)this.sessParam.textParamBytes.length);
      } else {
         this.meg.marshalNULLPTR();
         this.meg.marshalUB4(0L);
      }

      if (var1) {
         this.meg.marshalB1Array(this.sessionId);
      }

      if (this.sidp != null) {
         ((XSSecureIdI)this.sidp).marshal(this.meg);
      }

      if (this.sessParam != null && this.sessParam.binaryParam != null && this.sessParam.binaryParam.length > 0) {
         this.meg.marshalB1Array(this.sessParam.binaryParam);
      }

      if (this.sessParam != null && this.sessParam.textParamBytes != null && this.sessParam.textParamBytes.length > 0) {
         for(int var2 = 0; var2 < this.sessParam.textParamBytes.length; ++var2) {
            if (this.sessParam.textParamBytes[var2] == null) {
               this.meg.marshalUB4(0L);
            } else {
               this.meg.marshalUB4((long)this.sessParam.textParamBytes[var2].length);
               this.meg.marshalCLR(this.sessParam.textParamBytes[var2], this.sessParam.textParamBytes[var2].length);
            }
         }
      }

   }
}
