package oracle.jdbc.connector;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Enumeration;
import java.util.Hashtable;
import javax.resource.ResourceException;
import javax.resource.spi.ConnectionEvent;
import javax.resource.spi.ConnectionEventListener;
import javax.resource.spi.ConnectionRequestInfo;
import javax.resource.spi.EISSystemException;
import javax.resource.spi.IllegalStateException;
import javax.resource.spi.LocalTransaction;
import javax.resource.spi.ManagedConnection;
import javax.resource.spi.ManagedConnectionMetaData;
import javax.resource.spi.security.PasswordCredential;
import javax.security.auth.Subject;
import javax.sql.XAConnection;
import javax.transaction.xa.XAResource;
import oracle.jdbc.internal.OracleConnection;
import oracle.jdbc.xa.OracleXAConnection;

public class OracleManagedConnection implements ManagedConnection {
   private OracleXAConnection xaConnection = null;
   private Hashtable connectionListeners = null;
   private Connection connection = null;
   private PrintWriter logWriter = null;
   private PasswordCredential passwordCredential = null;
   private OracleLocalTransaction localTxn = null;
   private static final String _Copyright_2007_Oracle_All_Rights_Reserved_ = null;
   public static final String BUILD_DATE = "Thu_Apr_04_15:09:24_PDT_2013";
   public static final boolean TRACE = false;

   OracleManagedConnection(XAConnection var1) {
      this.xaConnection = (OracleXAConnection)var1;
      this.connectionListeners = new Hashtable(10);
   }

   public Object getConnection(Subject var1, ConnectionRequestInfo var2) throws ResourceException {
      try {
         if (this.connection != null) {
            this.connection.close();
         }

         this.connection = this.xaConnection.getConnection();
         return this.connection;
      } catch (SQLException var5) {
         EISSystemException var4 = new EISSystemException("SQLException: " + var5.getMessage());
         var4.setLinkedException(var5);
         throw var4;
      }
   }

   public void destroy() throws ResourceException {
      try {
         if (this.xaConnection != null) {
            Connection var1 = this.xaConnection.getPhysicalHandle();
            if (this.localTxn != null && this.localTxn.isBeginCalled || ((OracleConnection)var1).getTxnMode() == 1) {
               throw new IllegalStateException("Could not close connection while transaction is active");
            }
         }

         if (this.connection != null) {
            this.connection.close();
         }

         if (this.xaConnection != null) {
            this.xaConnection.close();
         }

      } catch (SQLException var3) {
         EISSystemException var2 = new EISSystemException("SQLException: " + var3.getMessage());
         var2.setLinkedException(var3);
         throw var2;
      }
   }

   public void cleanup() throws ResourceException {
      try {
         if (this.connection != null) {
            if (this.localTxn != null && this.localTxn.isBeginCalled || ((OracleConnection)this.connection).getTxnMode() == 1) {
               throw new IllegalStateException("Could not close connection while transaction is active");
            }

            this.connection.close();
         }

      } catch (SQLException var3) {
         EISSystemException var2 = new EISSystemException("SQLException: " + var3.getMessage());
         var2.setLinkedException(var3);
         throw var2;
      }
   }

   public void associateConnection(Object var1) {
   }

   public void addConnectionEventListener(ConnectionEventListener var1) {
      this.connectionListeners.put(var1, var1);
   }

   public void removeConnectionEventListener(ConnectionEventListener var1) {
      this.connectionListeners.remove(var1);
   }

   public XAResource getXAResource() throws ResourceException {
      return this.xaConnection.getXAResource();
   }

   public LocalTransaction getLocalTransaction() throws ResourceException {
      if (this.localTxn == null) {
         this.localTxn = new OracleLocalTransaction(this);
      }

      return this.localTxn;
   }

   public ManagedConnectionMetaData getMetaData() throws ResourceException {
      return new OracleManagedConnectionMetaData(this);
   }

   public void setLogWriter(PrintWriter var1) throws ResourceException {
      this.logWriter = var1;
   }

   public PrintWriter getLogWriter() throws ResourceException {
      return this.logWriter;
   }

   Connection getPhysicalConnection() throws ResourceException {
      try {
         return this.xaConnection.getPhysicalHandle();
      } catch (Exception var3) {
         EISSystemException var2 = new EISSystemException("Exception: " + var3.getMessage());
         var2.setLinkedException(var3);
         throw var2;
      }
   }

   void setPasswordCredential(PasswordCredential var1) {
      this.passwordCredential = var1;
   }

   PasswordCredential getPasswordCredential() {
      return this.passwordCredential;
   }

   void eventOccurred(int var1) throws ResourceException {
      Enumeration var2 = this.connectionListeners.keys();

      while(var2.hasMoreElements()) {
         ConnectionEventListener var3 = (ConnectionEventListener)var2.nextElement();
         ConnectionEvent var4 = new ConnectionEvent(this, var1);
         switch(var1) {
         case 1:
            var3.connectionClosed(var4);
            break;
         case 2:
            var3.localTransactionStarted(var4);
            break;
         case 3:
            var3.localTransactionCommitted(var4);
            break;
         case 4:
            var3.localTransactionRolledback(var4);
            break;
         case 5:
            var3.connectionErrorOccurred(var4);
            break;
         default:
            throw new IllegalArgumentException("Illegal eventType in eventOccurred(): " + var1);
         }
      }

   }
}
