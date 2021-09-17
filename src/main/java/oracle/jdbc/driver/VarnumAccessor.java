package oracle.jdbc.driver;

import java.sql.SQLException;

class VarnumAccessor extends NumberCommonAccessor {
   static final int MAXLENGTH = 21;
   private static final String _Copyright_2007_Oracle_All_Rights_Reserved_ = null;
   public static final String BUILD_DATE = "Thu_Apr_04_15:09:24_PDT_2013";
   public static final boolean TRACE = false;

   VarnumAccessor(OracleStatement var1, int var2, short var3, int var4, boolean var5) throws SQLException {
      super(var1, 21, var5);
      this.init(var1, var2, var3, var4, var5);
   }

   VarnumAccessor(OracleStatement var1, int var2, boolean var3, int var4, int var5, int var6, int var7, int var8, short var9) throws SQLException {
      super(var1, 21, false);
      this.init(var1, 6, var2, var3, var4, var5, var6, var7, var8, var9);
   }
}
