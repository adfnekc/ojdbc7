package oracle.jdbc.driver;

import java.io.IOException;
import java.sql.SQLException;

class T4CTTIimplres extends T4CTTIMsg {
   OracleStatement statement;
   private static final String _Copyright_2007_Oracle_All_Rights_Reserved_ = null;
   public static final String BUILD_DATE = "Thu_Apr_04_15:09:24_PDT_2013";
   public static final boolean TRACE = false;

   T4CTTIimplres(T4CConnection var1) {
      super(var1, (byte)27);
   }

   void init(OracleStatement var1) {
      this.statement = var1;
   }

   void readImplicitResultSet() throws IOException, SQLException {
      OracleStatement var1 = this.statement;
      OracleStatement var2 = this.connection.createImplicitResultSetStatement(var1);
      T4CTTIdcb var3 = new T4CTTIdcb((T4CConnection)var2.connection);
      var3.init(var2, 0);
      var2.accessors = var3.receive(var2.accessors);
      var2.numberOfDefinePositions = var3.numuds;
      var2.needToSendOalToFetch = true;
      int var4 = (int)this.meg.unmarshalUB4();
      var2.setCursorId(var4);
      this.statement = var1;
   }
}
