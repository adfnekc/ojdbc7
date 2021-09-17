package oracle.jdbc.driver;

import java.io.IOException;
import java.sql.SQLException;

final class T4C8Odscrarr extends T4CTTIfun {
   private static final byte OPERATIONFLAGS = 7;
   private static final long SQLPARSEVERSION = 2L;
   byte[] sqltext;
   T4CTTIdcb dcb;
   int cursor_id = 0;
   int numuds = 0;
   private static final boolean UDSARRAYO2U = true;
   private static final boolean NUMUDSO2U = true;
   OracleStatement statement = null;
   private Accessor[] accessors;
   private static final String _Copyright_2007_Oracle_All_Rights_Reserved_ = null;
   public static final String BUILD_DATE = "Thu_Apr_04_15:09:24_PDT_2013";
   public static final boolean TRACE = false;

   T4C8Odscrarr(T4CConnection var1) {
      super(var1, (byte)3);
      this.setFunCode((short)98);
      this.dcb = new T4CTTIdcb(var1);
   }

   void doODNY(OracleStatement var1, int var2, Accessor[] var3, byte[] var4) throws IOException, SQLException {
      this.numuds = 0;
      this.cursor_id = var1.cursorId;
      this.statement = var1;
      if (var4 != null && var4.length > 0) {
         this.sqltext = var4;
      } else {
         this.sqltext = PhysicalConnection.EMPTY_BYTE_ARRAY;
      }

      this.dcb.init(var1, var2);
      this.accessors = var3;
      this.numuds = 0;
      this.doRPC();
   }

   void marshal() throws IOException {
      this.meg.marshalUB1((short)7);
      this.meg.marshalSWORD(this.cursor_id);
      if (this.sqltext.length == 0) {
         this.meg.marshalNULLPTR();
      } else {
         this.meg.marshalPTR();
      }

      this.meg.marshalSB4(this.sqltext.length);
      this.meg.marshalUB4(2L);
      this.meg.marshalO2U(true);
      this.meg.marshalO2U(true);
      this.meg.marshalCHR(this.sqltext);
      this.sqltext = PhysicalConnection.EMPTY_BYTE_ARRAY;
   }

   Accessor[] getAccessors() {
      return this.accessors;
   }

   void readRPA() throws IOException, SQLException {
      this.accessors = this.dcb.receiveCommon(this.accessors, true);
      this.numuds = this.dcb.numuds;
   }
}
