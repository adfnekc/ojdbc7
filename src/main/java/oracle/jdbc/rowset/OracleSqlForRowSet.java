package oracle.jdbc.rowset;

import java.sql.SQLException;
import oracle.jdbc.driver.DBConversion;
import oracle.jdbc.driver.OracleSql;

class OracleSqlForRowSet extends OracleSql {
   private static final String _Copyright_2007_Oracle_All_Rights_Reserved_ = null;
   public static final String BUILD_DATE = "Thu_Apr_04_15:09:24_PDT_2013";
   public static final boolean TRACE = false;

   OracleSqlForRowSet(String var1) throws SQLException {
      super((DBConversion)null);
      this.initialize(var1);
   }

   protected void initialize(String var1) throws SQLException {
      super.initialize(var1);
   }

   protected int getParameterCount() throws SQLException {
      return super.getParameterCount();
   }

   protected String[] getParameterList() throws SQLException {
      return super.getParameterList();
   }
}
