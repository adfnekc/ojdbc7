package oracle.jdbc.connector;

import java.sql.SQLException;
import javax.resource.ResourceException;
import javax.resource.spi.EISSystemException;
import javax.resource.spi.ManagedConnectionMetaData;
import oracle.jdbc.OracleConnection;
import oracle.jdbc.OracleDatabaseMetaData;

public class OracleManagedConnectionMetaData implements ManagedConnectionMetaData {
   private OracleManagedConnection managedConnection = null;
   private OracleDatabaseMetaData databaseMetaData = null;
   private static final String _Copyright_2007_Oracle_All_Rights_Reserved_ = null;
   public static final String BUILD_DATE = "Thu_Apr_04_15:09:24_PDT_2013";
   public static final boolean TRACE = false;

   OracleManagedConnectionMetaData(OracleManagedConnection var1) throws ResourceException {
      try {
         this.managedConnection = var1;
         OracleConnection var2 = (OracleConnection)var1.getPhysicalConnection();
         this.databaseMetaData = (OracleDatabaseMetaData)var2.getMetaData();
      } catch (Exception var4) {
         EISSystemException var3 = new EISSystemException("Exception: " + var4.getMessage());
         var3.setLinkedException(var4);
         throw var3;
      }
   }

   public String getEISProductName() throws ResourceException {
      try {
         return this.databaseMetaData.getDatabaseProductName();
      } catch (SQLException var3) {
         EISSystemException var2 = new EISSystemException("SQLException: " + var3.getMessage());
         var2.setLinkedException(var3);
         throw var2;
      }
   }

   public String getEISProductVersion() throws ResourceException {
      try {
         return this.databaseMetaData.getDatabaseProductVersion();
      } catch (Exception var3) {
         EISSystemException var2 = new EISSystemException("Exception: " + var3.getMessage());
         var2.setLinkedException(var3);
         throw var2;
      }
   }

   public int getMaxConnections() throws ResourceException {
      try {
         return this.databaseMetaData.getMaxConnections();
      } catch (SQLException var3) {
         EISSystemException var2 = new EISSystemException("SQLException: " + var3.getMessage());
         var2.setLinkedException(var3);
         throw var2;
      }
   }

   public String getUserName() throws ResourceException {
      try {
         return this.databaseMetaData.getUserName();
      } catch (SQLException var3) {
         EISSystemException var2 = new EISSystemException("SQLException: " + var3.getMessage());
         var2.setLinkedException(var3);
         throw var2;
      }
   }
}
