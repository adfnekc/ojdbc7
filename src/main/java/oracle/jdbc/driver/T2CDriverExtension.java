package oracle.jdbc.driver;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

class T2CDriverExtension extends OracleDriverExtension {
   static final int T2C_DEFAULT_BATCHSIZE = 1;
   private static final String _Copyright_2007_Oracle_All_Rights_Reserved_ = null;
   public static final String BUILD_DATE = "Thu_Apr_04_15:09:24_PDT_2013";
   public static final boolean TRACE = false;

   Connection getConnection(String var1, Properties var2) throws SQLException {
      Object var3 = null;
      if (var2.getProperty("is_connection_pooling") == "true") {
         var3 = new oracle.jdbc.oci.OracleOCIConnection(var1, var2, this);
      } else {
         var3 = new T2CConnection(var1, var2, this);
      }

      return (Connection)var3;
   }

   OracleStatement allocateStatement(PhysicalConnection var1, int var2, int var3) throws SQLException {
      return new T2CStatement((T2CConnection)var1, 1, var1.defaultRowPrefetch, var2, var3);
   }

   OraclePreparedStatement allocatePreparedStatement(PhysicalConnection var1, String var2, int var3, int var4) throws SQLException {
      return new T2CPreparedStatement((T2CConnection)var1, var2, var1.defaultExecuteBatch, var1.defaultRowPrefetch, var3, var4);
   }

   OracleCallableStatement allocateCallableStatement(PhysicalConnection var1, String var2, int var3, int var4) throws SQLException {
      return new T2CCallableStatement((T2CConnection)var1, var2, var1.defaultExecuteBatch, var1.defaultRowPrefetch, var3, var4);
   }

   OracleInputStream createInputStream(OracleStatement var1, int var2, Accessor var3) throws SQLException {
      return new T2CInputStream(var1, var2, var3);
   }
}
