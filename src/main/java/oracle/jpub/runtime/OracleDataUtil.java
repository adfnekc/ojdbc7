package oracle.jpub.runtime;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Timestamp;
import oracle.jdbc.OracleArray;
import oracle.jdbc.OracleBfile;
import oracle.jdbc.OracleBlob;
import oracle.jdbc.OracleClob;
import oracle.jdbc.OracleData;
import oracle.jdbc.OracleDataFactory;
import oracle.jdbc.OracleOpaque;
import oracle.jdbc.OracleRef;
import oracle.jdbc.OracleStruct;
import oracle.jdbc.driver.DatabaseError;
import oracle.jdbc.internal.OracleConnection;
import oracle.sql.CHAR;
import oracle.sql.CharacterSet;
import oracle.sql.DATE;
import oracle.sql.NUMBER;
import oracle.sql.RAW;
import oracle.sql.TIMESTAMP;

public class OracleDataUtil {
   static short lastCsId = 870;
   static CharacterSet lastCS = CharacterSet.make(870);
   private static final String _Copyright_2007_Oracle_All_Rights_Reserved_ = null;
   public static final String BUILD_DATE = "Thu_Apr_04_15:09:24_PDT_2013";
   public static final boolean TRACE = false;

   public static Object convertToObject(Object var0, int var1, OracleDataFactory var2) throws SQLException {
      Object var3 = _convertToObject(var0, var1, var2);
      return var3;
   }

   public static Object _convertToObject(Object var0, int var1, OracleDataFactory var2) throws SQLException {
      if (var0 == null) {
         return null;
      } else if (var0 instanceof OracleStruct) {
         return var2.create(var0, 2002);
      } else if (var0 instanceof OracleRef) {
         return var2.create(var0, 2006);
      } else if (var0 instanceof OracleArray) {
         return var2.create(var0, 2003);
      } else if (var0 instanceof OracleOpaque) {
         return var2.create(var0, 2007);
      } else if (var2 != null) {
         return var2.create(var0, var1);
      } else if (var0 instanceof NUMBER) {
         if (var1 != 2 && var1 != 3) {
            if (var1 != 8 && var1 != 6) {
               if (var1 != 4 && var1 != 5) {
                  if (var1 == 7) {
                     return ((NUMBER)var0).floatValue();
                  } else if (var1 == 16) {
                     return ((NUMBER)var0).booleanValue();
                  } else {
                     SQLException var3 = DatabaseError.createSqlException((OracleConnection)null, 48, " type: " + var1);
                     var3.fillInStackTrace();
                     throw var3;
                  }
               } else {
                  return ((NUMBER)var0).intValue();
               }
            } else {
               return ((NUMBER)var0).doubleValue();
            }
         } else {
            return ((NUMBER)var0).bigDecimalValue();
         }
      } else {
         return var0;
      }
   }

   public static Object convertToOracle(Object var0, Connection var1) throws SQLException {
      return convertToOracle(var0, var1, false);
   }

   public static Object convertToOracle(Object var0, Connection var1, boolean var2) throws SQLException {
      Object var3 = _convertToOracle(var0, var1, var2);
      return var3;
   }

   private static Object _convertToOracle(Object var0, Connection var1, boolean var2) throws SQLException {
      if (var0 == null) {
         return null;
      } else if (var0 instanceof OracleData) {
         return ((OracleData)var0).toJDBCObject((oracle.jdbc.driver.OracleConnection)var1);
      } else {
         short var3;
         if (var0 instanceof String) {
            var3 = var1 != null && var1 instanceof OracleConnection ? (var2 ? ((OracleConnection)var1).getNCharSet() : ((OracleConnection)var1).getDbCsId()) : 870;
            if (var3 != lastCsId) {
               lastCsId = var3;
               lastCS = CharacterSet.make(lastCsId);
            }

            return new CHAR((String)var0, lastCS);
         } else if (!(var0 instanceof Character)) {
            if (var0 instanceof BigDecimal) {
               return new NUMBER((BigDecimal)var0);
            } else if (var0 instanceof BigInteger) {
               return new NUMBER((BigInteger)var0);
            } else if (var0 instanceof Double) {
               return new NUMBER((Double)var0);
            } else if (var0 instanceof Float) {
               return new NUMBER((Float)var0);
            } else if (var0 instanceof Integer) {
               return new NUMBER((Integer)var0);
            } else if (var0 instanceof Boolean) {
               return new NUMBER((Boolean)var0);
            } else if (var0 instanceof Short) {
               return new NUMBER((Short)var0);
            } else if (var0 instanceof Byte) {
               return new NUMBER((Byte)var0);
            } else if (var0 instanceof Long) {
               return new NUMBER((Long)var0);
            } else if (var0 instanceof Timestamp) {
               return new TIMESTAMP((Timestamp)var0);
            } else if (var0 instanceof Date) {
               return new DATE((Date)var0);
            } else if (var0 instanceof java.util.Date) {
               return new DATE(new Date(((java.util.Date)var0).getTime()));
            } else if (var0 instanceof byte[]) {
               return new RAW((byte[])((byte[])var0));
            } else if (var0 instanceof OracleData) {
               return var0;
            } else {
               SQLException var4 = DatabaseError.createSqlException((OracleConnection)null, 48);
               var4.fillInStackTrace();
               throw var4;
            }
         } else {
            var3 = var1 != null && var1 instanceof OracleConnection ? ((OracleConnection)var1).getDbCsId() : 870;
            if (var3 != lastCsId) {
               lastCsId = var3;
               lastCS = CharacterSet.make(lastCsId);
            }

            return new CHAR(((Character)var0).toString(), lastCS);
         }
      }
   }

   static boolean isMutable(Object var0, OracleDataFactory var1) {
      if (var0 == null) {
         return false;
      } else {
         return var0 instanceof OracleBfile || var0 instanceof OracleBlob || var0 instanceof OracleClob || var1 != null && (var0 instanceof OracleStruct || var0 instanceof OracleOpaque || var0 instanceof OracleArray);
      }
   }

   protected OracleConnection getConnectionDuringExceptionHandling() {
      return null;
   }
}
