package oracle.sql;

import java.sql.SQLException;
import java.util.Map;
import oracle.jdbc.OracleData;
import oracle.jdbc.OracleDataFactory;
import oracle.jdbc.internal.OracleConnection;

public class SQLUtil {
   private static final String _Copyright_2007_Oracle_All_Rights_Reserved_ = null;
   public static final String BUILD_DATE = "Thu_Apr_04_15:09:24_PDT_2013";
   public static final boolean TRACE = false;

   public static Object SQLToJava(OracleConnection var0, byte[] var1, int var2, String var3, Class var4, Map var5) throws SQLException {
      return oracle.jdbc.driver.SQLUtil.SQLToJava(var0, var1, var2, var3, var4, var5);
   }

   public static CustomDatum SQLToJava(OracleConnection var0, byte[] var1, int var2, String var3, CustomDatumFactory var4) throws SQLException {
      return oracle.jdbc.driver.SQLUtil.SQLToJava(var0, var1, var2, var3, var4);
   }

   public static ORAData SQLToJava(OracleConnection var0, byte[] var1, int var2, String var3, ORADataFactory var4) throws SQLException {
      return oracle.jdbc.driver.SQLUtil.SQLToJava(var0, var1, var2, var3, var4);
   }

   public static OracleData SQLToJava(OracleConnection var0, byte[] var1, int var2, String var3, OracleDataFactory var4) throws SQLException {
      return oracle.jdbc.driver.SQLUtil.SQLToJava(var0, var1, var2, var3, var4);
   }

   public static Object SQLToJava(OracleConnection var0, Datum var1, Class var2, Map var3) throws SQLException {
      return oracle.jdbc.driver.SQLUtil.SQLToJava(var0, var1, var2, var3);
   }

   public static byte[] JavaToSQL(OracleConnection var0, Object var1, int var2, String var3) throws SQLException {
      return oracle.jdbc.driver.SQLUtil.JavaToSQL(var0, var1, var2, var3);
   }

   public static Datum makeDatum(OracleConnection var0, byte[] var1, int var2, String var3, int var4) throws SQLException {
      return oracle.jdbc.driver.SQLUtil.makeDatum(var0, var1, var2, var3, var4);
   }

   public static Datum makeDatum(OracleConnection var0, Object var1, int var2, String var3) throws SQLException {
      return oracle.jdbc.driver.SQLUtil.makeDatum(var0, var1, var2, var3);
   }

   public static Object getTypeDescriptor(String var0, OracleConnection var1) throws SQLException {
      return oracle.jdbc.driver.SQLUtil.getTypeDescriptor(var0, var1);
   }

   public static boolean checkDatumType(Datum var0, int var1, String var2) throws SQLException {
      return oracle.jdbc.driver.SQLUtil.checkDatumType(var0, var1, var2);
   }

   public static boolean implementsInterface(Class var0, Class var1) {
      return oracle.jdbc.driver.SQLUtil.implementsInterface(var0, var1);
   }

   public static Datum makeOracleDatum(OracleConnection var0, Object var1, int var2, String var3) throws SQLException {
      return oracle.jdbc.driver.SQLUtil.makeOracleDatum(var0, var1, var2, var3);
   }

   public static int getInternalType(int var0) throws SQLException {
      return oracle.jdbc.driver.SQLUtil.getInternalType(var0);
   }

   /** @deprecated */
   public static int get_internal_type(int var0) throws SQLException {
      return getInternalType(var0);
   }
}
