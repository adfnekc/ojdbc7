package oracle.jdbc.proxy;

import java.lang.reflect.Method;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.util.Map;
import oracle.jdbc.internal.ACProxyable;
import oracle.jdbc.internal.OracleSavepoint;
import oracle.jdbc.replay.driver.TxnReplayableBase;

public class oracle$1jdbc$1replay$1driver$1TxnReplayableBase$2oracle$1jdbc$1internal$1OracleSavepoint$$$Proxy extends TxnReplayableBase implements OracleSavepoint, _Proxy_ {
   private OracleSavepoint delegate;
   private final Object creator;
   private final ProxyFactory proxyFactory;
   private final Map proxyCache;
   private static Object[] zeroLengthObjectArray = new Object[0];
   private static Method methodObject4902;
   private static Method methodObject4904;
   private static Method methodObject4905;
   private static Method methodObject4903;

   public int getSavepointId() throws SQLException {
      try {
         super.preForAll(methodObject4902, this, zeroLengthObjectArray);
         return (Integer)this.postForAll(methodObject4902, this.delegate.getSavepointId());
      } catch (SQLException var2) {
         return (Integer)this.postForAll(methodObject4902, this.onErrorForAll(methodObject4902, var2));
      }
   }

   public void setACProxy(Object arg0) {
      super.preForAll(methodObject4904, this, arg0);
      Method var10001 = methodObject4904;
      this.delegate.setACProxy(arg0 instanceof _Proxy_ ? (Object)((_Proxy_)arg0)._getDelegate_() : arg0);
      this.postForAll(var10001);
   }

   public Object getACProxy() {
      super.preForAll(methodObject4905, this, zeroLengthObjectArray);
      return this.postForAll(methodObject4905, this.proxyFactory.proxyForCache(this.delegate.getACProxy(), this, this.proxyCache, methodObject4905));
   }

   public String getSavepointName() throws SQLException {
      try {
         super.preForAll(methodObject4903, this, zeroLengthObjectArray);
         return (String)this.postForAll(methodObject4903, (Object)this.delegate.getSavepointName());
      } catch (SQLException var2) {
         return (String)this.postForAll(methodObject4903, this.onErrorForAll(methodObject4903, var2));
      }
   }

   public OracleSavepoint _getDelegate_() {
      return this.delegate;
   }

   public Object getDelegate() {
      return this.delegate;
   }

   public void setDelegate(Object delegate) {
      this.proxyFactory.updateDelegate(this, this.delegate, delegate);
      this.delegate = (OracleSavepoint)delegate;
   }

   public Object getCreator() {
      return this.creator;
   }

   static {
      try {
         methodObject4902 = Savepoint.class.getDeclaredMethod("getSavepointId");
         methodObject4904 = ACProxyable.class.getDeclaredMethod("setACProxy", Object.class);
         methodObject4905 = ACProxyable.class.getDeclaredMethod("getACProxy");
         methodObject4903 = Savepoint.class.getDeclaredMethod("getSavepointName");
      } catch (Throwable var1) {
         throw new RuntimeException(var1);
      }
   }

   public oracle$1jdbc$1replay$1driver$1TxnReplayableBase$2oracle$1jdbc$1internal$1OracleSavepoint$$$Proxy(OracleSavepoint var1, Object var2, ProxyFactory var3, Map var4) {
      this.delegate = var1;
      this.creator = var2;
      this.proxyFactory = var3;
      this.proxyCache = var4;
   }
}
