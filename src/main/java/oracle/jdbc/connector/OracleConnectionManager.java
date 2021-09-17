package oracle.jdbc.connector;

import javax.resource.ResourceException;
import javax.resource.spi.ConnectionManager;
import javax.resource.spi.ConnectionRequestInfo;
import javax.resource.spi.ManagedConnection;
import javax.resource.spi.ManagedConnectionFactory;
import javax.security.auth.Subject;

public class OracleConnectionManager implements ConnectionManager {
   private static final String _Copyright_2007_Oracle_All_Rights_Reserved_ = null;
   public static final String BUILD_DATE = "Thu_Apr_04_15:09:24_PDT_2013";
   public static final boolean TRACE = false;

   public Object allocateConnection(ManagedConnectionFactory var1, ConnectionRequestInfo var2) throws ResourceException {
      ManagedConnection var3 = var1.createManagedConnection((Subject)null, var2);
      return var3.getConnection((Subject)null, var2);
   }
}
