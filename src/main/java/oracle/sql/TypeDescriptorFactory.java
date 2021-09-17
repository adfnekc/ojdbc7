package oracle.sql;

import java.sql.SQLException;
import oracle.jdbc.OracleData;
import oracle.jdbc.OracleDataFactory;
import oracle.jdbc.driver.DatabaseError;
import oracle.jdbc.internal.OracleConnection;
import oracle.jdbc.oracore.PickleContext;

class TypeDescriptorFactory implements ORADataFactory, OracleDataFactory {
   private static final String _Copyright_2007_Oracle_All_Rights_Reserved_ = null;
   public static final String BUILD_DATE = "Thu_Apr_04_15:09:24_PDT_2013";
   public static final boolean TRACE = false;

   public ORAData create(Datum var1, int var2) throws SQLException {
      if (var1 == null) {
         return null;
      } else if (var2 == 2007) {
         OPAQUE var7 = (OPAQUE)var1;
         byte[] var4 = var7.getBytesValue();
         short[] var5 = new short[1];
         TypeDescriptor var6 = TypeDescriptor.unpickleOpaqueTypeImage(new PickleContext(var4, 0L), var7.getPhysicalConnection(), var5);
         return var6;
      } else {
         SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 1);
         var3.fillInStackTrace();
         throw var3;
      }
   }

   public OracleData create(Object var1, int var2) throws SQLException {
      if (var1 == null) {
         return null;
      } else if (var2 == 2007) {
         OPAQUE var7 = (OPAQUE)var1;
         byte[] var4 = var7.getBytesValue();
         short[] var5 = new short[1];
         TypeDescriptor var6 = TypeDescriptor.unpickleOpaqueTypeImage(new PickleContext(var4, 0L), var7.getPhysicalConnection(), var5);
         return var6;
      } else {
         SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 1);
         var3.fillInStackTrace();
         throw var3;
      }
   }

   protected OracleConnection getConnectionDuringExceptionHandling() {
      return null;
   }
}
