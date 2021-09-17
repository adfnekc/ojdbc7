package oracle.jdbc.connector;

import javax.resource.NotSupportedException;
import javax.resource.ResourceException;
import javax.resource.spi.ActivationSpec;
import javax.resource.spi.BootstrapContext;
import javax.resource.spi.ResourceAdapter;
import javax.resource.spi.ResourceAdapterInternalException;
import javax.resource.spi.endpoint.MessageEndpointFactory;
import javax.transaction.xa.XAResource;

public class OracleResourceAdapter implements ResourceAdapter {
   private static final String _Copyright_2007_Oracle_All_Rights_Reserved_ = null;
   public static final String BUILD_DATE = "Thu_Apr_04_15:09:24_PDT_2013";
   public static final boolean TRACE = false;

   public void start(BootstrapContext var1) throws ResourceAdapterInternalException {
   }

   public void stop() {
   }

   public void endpointActivation(MessageEndpointFactory var1, ActivationSpec var2) throws NotSupportedException {
   }

   public void endpointDeactivation(MessageEndpointFactory var1, ActivationSpec var2) {
   }

   public XAResource[] getXAResources(ActivationSpec[] var1) throws ResourceException {
      return new XAResource[0];
   }
}
