package oracle.net.jndi;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import javax.net.SocketFactory;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

public class CustomSSLSocketFactory extends SSLSocketFactory {
   private static final boolean DEBUG = false;
   private static SSLSocketFactory ossl = null;

   protected static boolean isFactorySet() {
      return null != ossl;
   }

   protected static void setFactory(SSLSocketFactory var0) {
      if (null == ossl) {
         ossl = var0;
      }

   }

   protected void setDefaultFactory() {
      setFactory((SSLSocketFactory)SSLSocketFactory.getDefault());
   }

   protected CustomSSLSocketFactory() {
   }

   public static SocketFactory getDefault() {
      Object var0 = null;

      try {
         var0 = new TrustManagerSSLSocketFactory();
      } catch (Exception var2) {
         var0 = new CustomSSLSocketFactory();
      }

      ((CustomSSLSocketFactory)var0).setDefaultFactory();
      return (SocketFactory)var0;
   }

   public Socket createSocket(String var1, int var2) throws IOException {
      SSLSocket var3 = (SSLSocket)ossl.createSocket(var1, var2);
      return this.init(var3);
   }

   public Socket createSocket(InetAddress var1, int var2) throws IOException {
      SSLSocket var3 = (SSLSocket)ossl.createSocket(var1, var2);
      return this.init(var3);
   }

   public Socket createSocket(String var1, int var2, InetAddress var3, int var4) throws IOException {
      SSLSocket var5 = (SSLSocket)ossl.createSocket(var1, var2, var3, var4);
      return this.init(var5);
   }

   public Socket createSocket(InetAddress var1, int var2, InetAddress var3, int var4) throws IOException {
      SSLSocket var5 = (SSLSocket)ossl.createSocket(var1, var2, var3, var4);
      return this.init(var5);
   }

   public Socket createSocket(Socket var1, String var2, int var3, boolean var4) throws IOException {
      SSLSocket var5 = (SSLSocket)ossl.createSocket(var1, var2, var3, var4);
      return this.init(var5);
   }

   public String[] getDefaultCipherSuites() {
      return ossl.getDefaultCipherSuites();
   }

   public String[] getSupportedCipherSuites() {
      return ossl.getSupportedCipherSuites();
   }

   private SSLSocket init(SSLSocket var1) throws IOException {
      var1.setUseClientMode(true);
      String[] var2 = new String[]{"SSL_DH_anon_WITH_3DES_EDE_CBC_SHA"};
      String[] var3 = new String[]{"TLSv1", "SSLv2Hello", "SSLv3"};
      var1.setEnabledCipherSuites(var2);
      var1.setEnabledProtocols(var3);
      var1.startHandshake();
      return var1;
   }
}
