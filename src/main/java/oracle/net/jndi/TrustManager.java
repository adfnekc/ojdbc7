package oracle.net.jndi;

import java.security.KeyStore;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;

public class TrustManager implements X509TrustManager {
   X509TrustManager nativeTm;

   public TrustManager() {
      try {
         TrustManagerFactory var1 = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
         var1.init((KeyStore)null);
         this.nativeTm = (X509TrustManager)var1.getTrustManagers()[0];
      } catch (Exception var2) {
         var2.printStackTrace();
      }

   }

   public void checkServerTrusted(X509Certificate[] var1, String var2) throws CertificateException {
   }

   public void checkClientTrusted(X509Certificate[] var1, String var2) throws CertificateException {
   }

   public X509Certificate[] getAcceptedIssuers() {
      return this.nativeTm.getAcceptedIssuers();
   }
}
