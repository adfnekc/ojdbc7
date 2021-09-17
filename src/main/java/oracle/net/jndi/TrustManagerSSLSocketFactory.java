package oracle.net.jndi;

import java.security.SecureRandom;
import javax.net.ssl.KeyManager;
import javax.net.ssl.SSLContext;

public final class TrustManagerSSLSocketFactory extends CustomSSLSocketFactory {
   private static final boolean DEBUG = false;

   protected TrustManagerSSLSocketFactory() {
   }

   protected void setDefaultFactory() {
      try {
         SSLContext var1 = SSLContext.getInstance("SSL");
         var1.init((KeyManager[])null, new javax.net.ssl.TrustManager[]{new TrustManager()}, (SecureRandom)null);
         setFactory(var1.getSocketFactory());
      } catch (Exception var2) {
         super.setDefaultFactory();
      }

   }
}
