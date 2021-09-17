package oracle.jdbc.driver;

import java.io.IOException;
import java.sql.SQLException;
import oracle.jdbc.internal.KeywordValueLong;
import oracle.jdbc.internal.XSKeyval;
import oracle.jdbc.internal.XSNamespace;
import oracle.jdbc.internal.XSPrincipal;
import oracle.jdbc.internal.XSSecureId;

final class T4CTTIoxscre extends T4CTTIfun {
   private oracle.jdbc.internal.OracleConnection.XSSessionOperationCode opcode;
   private XSSecureId sidp;
   private byte[] cookie;
   private XSPrincipal username;
   private byte[] tenantBytes;
   private XSNamespace[] namespaces;
   private oracle.jdbc.internal.OracleConnection.XSSessionModeFlag mode;
   private XSKeyval kv;
   private byte[] sessionId = null;
   private static final String _Copyright_2007_Oracle_All_Rights_Reserved_ = null;
   public static final String BUILD_DATE = "Thu_Apr_04_15:09:24_PDT_2013";
   public static final boolean TRACE = false;

   T4CTTIoxscre(T4CConnection var1) {
      super(var1, (byte)3);
      this.setFunCode((short)179);
   }

   void doOXSCRE(oracle.jdbc.internal.OracleConnection.XSSessionOperationCode var1, XSSecureId var2, byte[] var3, XSPrincipal var4, String var5, XSNamespace[] var6, oracle.jdbc.internal.OracleConnection.XSSessionModeFlag var7, XSKeyval var8) throws IOException, SQLException {
      this.opcode = var1;
      this.sidp = var2;
      this.cookie = var3;
      this.username = var4;
      if (var4 != null) {
         ((XSPrincipalI)var4).doCharConversion(this.meg.conv);
      }

      if (var5 != null && var5.length() > 0) {
         this.tenantBytes = this.meg.conv.StringToCharBytes(var5);
      } else {
         this.tenantBytes = null;
      }

      this.namespaces = var6;
      if (var6 != null) {
         for(int var9 = 0; var9 < var6.length; ++var9) {
            ((XSNamespaceI)var6[var9]).doCharConversion(this.meg.conv);
         }
      }

      this.mode = var7;
      this.kv = var8;
      if (var8 != null) {
         KeywordValueLong[] var11 = var8.getKeyval();
         if (var11 != null) {
            for(int var10 = 0; var10 < var11.length; ++var10) {
               ((KeywordValueLongI)var11[var10]).doCharConversion(this.meg.conv);
            }
         }
      }

      this.doRPC();
   }

   void marshal() throws IOException {
      this.meg.marshalUB4((long)this.opcode.getCode());
      this.meg.marshalPTR();
      this.meg.marshalPTR();
      boolean var1 = false;
      if (this.sidp != null) {
         var1 = true;
         this.meg.marshalPTR();
      } else {
         this.meg.marshalNULLPTR();
      }

      boolean var2 = false;
      if (this.cookie != null && this.cookie.length > 0) {
         var2 = true;
         this.meg.marshalPTR();
         this.meg.marshalUB4((long)this.cookie.length);
      } else {
         this.meg.marshalNULLPTR();
         this.meg.marshalUB4(0L);
      }

      boolean var3 = false;
      if (this.username != null) {
         var3 = true;
         this.meg.marshalPTR();
      } else {
         this.meg.marshalNULLPTR();
      }

      boolean var4 = false;
      if (this.tenantBytes != null) {
         var4 = true;
         this.meg.marshalPTR();
         this.meg.marshalUB4((long)this.tenantBytes.length);
      } else {
         this.meg.marshalNULLPTR();
         this.meg.marshalUB4(0L);
      }

      boolean var5 = false;
      this.meg.marshalPTR();
      if (this.namespaces != null && this.namespaces.length > 0) {
         var5 = true;
         this.meg.marshalUB4((long)this.namespaces.length);
      } else {
         this.meg.marshalUB4(0L);
      }

      this.meg.marshalUB4((long)this.mode.getCode());
      boolean var6 = false;
      if (this.kv != null) {
         var6 = true;
         this.meg.marshalPTR();
      } else {
         this.meg.marshalNULLPTR();
      }

      if (var1) {
         ((XSSecureIdI)this.sidp).marshal(this.meg);
      }

      if (var2) {
         this.meg.marshalB1Array(this.cookie);
      }

      if (var3) {
         ((XSPrincipalI)this.username).marshal(this.meg);
      }

      if (var4) {
         this.meg.marshalCHR(this.tenantBytes);
      }

      if (var5) {
         for(int var7 = 0; var7 < this.namespaces.length; ++var7) {
            ((XSNamespaceI)this.namespaces[var7]).marshal(this.meg);
         }
      }

      if (var6) {
         ((XSKeyvalI)this.kv).marshal(this.meg);
      }

   }

   byte[] getSessionId() {
      return this.sessionId;
   }

   void readRPA() throws SQLException, IOException {
      int var1 = (int)this.meg.unmarshalUB4();
      this.sessionId = null;
      if (var1 > 0) {
         this.sessionId = this.meg.unmarshalNBytes(var1);
      }

   }
}
