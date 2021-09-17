package oracle.jdbc.connector;

import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.resource.ResourceException;
import javax.resource.spi.ConnectionManager;
import javax.resource.spi.ConnectionRequestInfo;
import javax.resource.spi.EISSystemException;
import javax.resource.spi.ManagedConnection;
import javax.resource.spi.ManagedConnectionFactory;
import javax.resource.spi.ResourceAdapterInternalException;
import javax.resource.spi.security.PasswordCredential;
import javax.security.auth.Subject;
import javax.sql.DataSource;
import javax.sql.XAConnection;
import javax.sql.XADataSource;

public class OracleManagedConnectionFactory implements ManagedConnectionFactory {
   private XADataSource xaDataSource = null;
   private String xaDataSourceName = null;
   private static final String RAERR_MCF_SET_XADS = "invalid xads";
   private static final String RAERR_MCF_GET_PCRED = "no password credential";
   private static final String _Copyright_2007_Oracle_All_Rights_Reserved_ = null;
   public static final String BUILD_DATE = "Thu_Apr_04_15:09:24_PDT_2013";
   public static final boolean TRACE = false;

   public OracleManagedConnectionFactory() throws ResourceException {
   }

   public OracleManagedConnectionFactory(XADataSource var1) throws ResourceException {
      this.xaDataSource = var1;
      this.xaDataSourceName = "XADataSource";
   }

   public void setXADataSourceName(String var1) {
      this.xaDataSourceName = var1;
   }

   public String getXADataSourceName() {
      return this.xaDataSourceName;
   }

   public Object createConnectionFactory(ConnectionManager var1) throws ResourceException {
      if (this.xaDataSource == null) {
         this.setupXADataSource();
      }

      return (DataSource)this.xaDataSource;
   }

   public Object createConnectionFactory() throws ResourceException {
      return this.createConnectionFactory((ConnectionManager)null);
   }

   public ManagedConnection createManagedConnection(Subject var1, ConnectionRequestInfo var2) throws ResourceException {
      try {
         if (this.xaDataSource == null) {
            this.setupXADataSource();
         }

         XAConnection var3 = null;
         PasswordCredential var7 = this.getPasswordCredential(var1, var2);
         if (var7 == null) {
            var3 = this.xaDataSource.getXAConnection();
         } else {
            var3 = this.xaDataSource.getXAConnection(var7.getUserName(), new String(var7.getPassword()));
         }

         OracleManagedConnection var5 = new OracleManagedConnection(var3);
         var5.setPasswordCredential(var7);
         var5.setLogWriter(this.getLogWriter());
         return var5;
      } catch (SQLException var6) {
         EISSystemException var4 = new EISSystemException("SQLException: " + var6.getMessage());
         var4.setLinkedException(var6);
         throw var4;
      }
   }

   public ManagedConnection matchManagedConnections(Set var1, Subject var2, ConnectionRequestInfo var3) throws ResourceException {
      PasswordCredential var4 = this.getPasswordCredential(var2, var3);
      Iterator var5 = var1.iterator();

      while(var5.hasNext()) {
         Object var6 = var5.next();
         if (var6 instanceof OracleManagedConnection) {
            OracleManagedConnection var7 = (OracleManagedConnection)var6;
            if (var7.getPasswordCredential().equals(var4)) {
               return var7;
            }
         }
      }

      return null;
   }

   public void setLogWriter(PrintWriter var1) throws ResourceException {
      try {
         if (this.xaDataSource == null) {
            this.setupXADataSource();
         }

         this.xaDataSource.setLogWriter(var1);
      } catch (SQLException var4) {
         EISSystemException var3 = new EISSystemException("SQLException: " + var4.getMessage());
         var3.setLinkedException(var4);
         throw var3;
      }
   }

   public PrintWriter getLogWriter() throws ResourceException {
      try {
         if (this.xaDataSource == null) {
            this.setupXADataSource();
         }

         return this.xaDataSource.getLogWriter();
      } catch (SQLException var3) {
         EISSystemException var2 = new EISSystemException("SQLException: " + var3.getMessage());
         var2.setLinkedException(var3);
         throw var2;
      }
   }

   private void setupXADataSource() throws ResourceException {
      try {
         InitialContext var1 = null;

         try {
            Properties var5 = System.getProperties();
            var1 = new InitialContext(var5);
         } catch (SecurityException var3) {
         }

         if (var1 == null) {
            var1 = new InitialContext();
         }

         XADataSource var6 = (XADataSource)var1.lookup(this.xaDataSourceName);
         if (var6 == null) {
            throw new ResourceAdapterInternalException("Invalid XADataSource object");
         } else {
            this.xaDataSource = var6;
         }
      } catch (NamingException var4) {
         ResourceException var2 = new ResourceException("NamingException: " + var4.getMessage());
         var2.setLinkedException(var4);
         throw var2;
      }
   }

   private PasswordCredential getPasswordCredential(Subject var1, ConnectionRequestInfo var2) throws ResourceException {
      if (var1 != null) {
         Set var6 = var1.getPrivateCredentials(PasswordCredential.class);
         Iterator var7 = var6.iterator();

         PasswordCredential var5;
         do {
            if (!var7.hasNext()) {
               throw new javax.resource.spi.SecurityException("Can not find user/password information", "no password credential");
            }

            var5 = (PasswordCredential)var7.next();
         } while(!var5.getManagedConnectionFactory().equals(this));

         return var5;
      } else if (var2 == null) {
         return null;
      } else {
         OracleConnectionRequestInfo var3 = (OracleConnectionRequestInfo)var2;
         PasswordCredential var4 = new PasswordCredential(var3.getUser(), var3.getPassword().toCharArray());
         var4.setManagedConnectionFactory(this);
         return var4;
      }
   }
}
