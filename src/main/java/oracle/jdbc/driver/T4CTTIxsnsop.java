package oracle.jdbc.driver;

import java.io.IOException;
import java.sql.SQLException;
import oracle.jdbc.internal.XSNamespace;

class T4CTTIxsnsop extends T4CTTIfun {
   private oracle.jdbc.internal.OracleConnection.XSOperationCode operationCode;
   private byte[] sessionId;
   private XSNamespace[] namespaces;
   private XSNamespace[] outNamespaces;
   private static final String _Copyright_2007_Oracle_All_Rights_Reserved_ = null;
   public static final String BUILD_DATE = "Thu_Apr_04_15:09:24_PDT_2013";
   public static final boolean TRACE = false;

   T4CTTIxsnsop(T4CConnection var1) {
      super(var1, (byte)3);
      this.setFunCode((short)172);
   }

   void doOXSNS(oracle.jdbc.internal.OracleConnection.XSOperationCode var1, byte[] var2, XSNamespace[] var3, boolean var4) throws IOException, SQLException {
      if (var4) {
         this.setTTCCode((byte)3);
      } else {
         this.setTTCCode((byte)17);
      }

      this.operationCode = var1;
      this.sessionId = var2;
      this.namespaces = var3;
      if (this.namespaces != null) {
         for(int var5 = 0; var5 < this.namespaces.length; ++var5) {
            ((XSNamespaceI)this.namespaces[var5]).doCharConversion(this.meg.conv);
         }
      }

      if (var4) {
         this.doRPC();
      } else {
         this.doPigRPC();
      }

   }

   void marshal() throws IOException {
      this.meg.marshalUB4((long)this.operationCode.getCode());
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
      this.meg.marshalPTR();
      if (this.namespaces != null && this.namespaces.length > 0) {
         var2 = true;
         this.meg.marshalUB4((long)this.namespaces.length);
      } else {
         this.meg.marshalUB4(0L);
      }

      this.meg.marshalPTR();
      if (var1) {
         this.meg.marshalB1Array(this.sessionId);
      }

      if (var2) {
         for(int var3 = 0; var3 < this.namespaces.length; ++var3) {
            ((XSNamespaceI)this.namespaces[var3]).marshal(this.meg);
         }
      }

   }

   void readRPA() throws SQLException, IOException {
      this.outNamespaces = null;
      int var1 = (int)this.meg.unmarshalUB4();
      if (var1 > 0) {
         this.outNamespaces = new XSNamespace[var1];

         for(int var2 = 0; var2 < var1; ++var2) {
            this.outNamespaces[var2] = XSNamespaceI.unmarshal(this.meg);
         }
      }

   }

   XSNamespace[] getNamespaces() throws SQLException {
      return this.outNamespaces;
   }

   protected oracle.jdbc.internal.OracleConnection getConnectionDuringExceptionHandling() {
      return this.connection;
   }
}
