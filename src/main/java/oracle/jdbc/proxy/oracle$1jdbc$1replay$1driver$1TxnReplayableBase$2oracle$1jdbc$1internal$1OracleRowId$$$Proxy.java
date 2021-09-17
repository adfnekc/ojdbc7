package oracle.jdbc.proxy;

import java.lang.reflect.Method;
import java.sql.RowId;
import java.util.Map;
import oracle.jdbc.internal.ACProxyable;
import oracle.jdbc.internal.OracleRowId;
import oracle.jdbc.replay.driver.TxnReplayableBase;

public class oracle$1jdbc$1replay$1driver$1TxnReplayableBase$2oracle$1jdbc$1internal$1OracleRowId$$$Proxy extends TxnReplayableBase implements OracleRowId, _Proxy_ {
   private OracleRowId delegate;
   private final Object creator;
   private final ProxyFactory proxyFactory;
   private final Map proxyCache;
   private static Object[] zeroLengthObjectArray = new Object[0];
   private static Method methodObject4898;
   private static Method methodObject4900;
   private static Method methodObject4901;
   private static Method methodObject4899;

   public String toString() {
      super.preForToString(methodObject4898, this, zeroLengthObjectArray);
      return this.postForToString(methodObject4898, super.toString());
   }

   public void setACProxy(Object arg0) {
      super.preForAll(methodObject4900, this, arg0);
      Method var10001 = methodObject4900;
      this.delegate.setACProxy(arg0 instanceof _Proxy_ ? (Object)((_Proxy_)arg0)._getDelegate_() : arg0);
      this.postForAll(var10001);
   }

   public Object getACProxy() {
      super.preForAll(methodObject4901, this, zeroLengthObjectArray);
      return this.postForAll(methodObject4901, this.proxyFactory.proxyForCache(this.delegate.getACProxy(), this, this.proxyCache, methodObject4901));
   }

   public byte[] getBytes() {
      super.preForAll(methodObject4899, this, zeroLengthObjectArray);
      return (byte[])this.postForAll(methodObject4899, (Object)this.delegate.getBytes());
   }

   public OracleRowId _getDelegate_() {
      return this.delegate;
   }

   public Object getDelegate() {
      return this.delegate;
   }

   public void setDelegate(Object delegate) {
      this.proxyFactory.updateDelegate(this, this.delegate, delegate);
      this.delegate = (OracleRowId)delegate;
   }

   public Object getCreator() {
      return this.creator;
   }

   static {
      try {
         methodObject4898 = RowId.class.getDeclaredMethod("toString");
         methodObject4900 = ACProxyable.class.getDeclaredMethod("setACProxy", Object.class);
         methodObject4901 = ACProxyable.class.getDeclaredMethod("getACProxy");
         methodObject4899 = RowId.class.getDeclaredMethod("getBytes");
      } catch (Throwable var1) {
         throw new RuntimeException(var1);
      }
   }

   public oracle$1jdbc$1replay$1driver$1TxnReplayableBase$2oracle$1jdbc$1internal$1OracleRowId$$$Proxy(OracleRowId var1, Object var2, ProxyFactory var3, Map var4) {
      this.delegate = var1;
      this.creator = var2;
      this.proxyFactory = var3;
      this.proxyCache = var4;
   }
}
