package oracle.jdbc.proxy;

import java.lang.reflect.Method;
import java.sql.Ref;
import java.sql.SQLException;
import java.util.Map;
import oracle.jdbc.replay.driver.NonTxnReplayableRef;

public abstract class oracle$1jdbc$1replay$1driver$1NonTxnReplayableRef$2java$1sql$1Ref$$$Proxy extends NonTxnReplayableRef implements Ref, _Proxy_ {
   private Ref delegate;
   private final Object creator;
   private final ProxyFactory proxyFactory;
   private final Map proxyCache;
   private static Object[] zeroLengthObjectArray = new Object[0];
   private static Method methodObject23273;
   private static Method methodObject23276;
   private static Method methodObject23275;
   private static Method methodObject23274;

   public Object getObject(Map arg0) throws SQLException {
      try {
         super.preForAll(methodObject23273, this, arg0);
         return this.postForAll(methodObject23273, this.proxyFactory.proxyForCache(this.delegate.getObject(arg0), this, this.proxyCache, methodObject23273));
      } catch (SQLException var3) {
         return this.postForAll(methodObject23273, this.onErrorForAll(methodObject23273, var3));
      }
   }

   public void setObject(Object arg0) throws SQLException {
      try {
         super.preForAll(methodObject23276, this, arg0);
         this.delegate.setObject(arg0 instanceof _Proxy_ ? (Object)((_Proxy_)arg0)._getDelegate_() : arg0);
      } catch (SQLException var3) {
         this.onErrorVoidForAll(methodObject23276, var3);
      }
   }

   public String getBaseTypeName() throws SQLException {
      try {
         super.preForAll(methodObject23275, this, zeroLengthObjectArray);
         return (String)this.postForAll(methodObject23275, (Object)this.delegate.getBaseTypeName());
      } catch (SQLException var2) {
         return (String)this.postForAll(methodObject23275, this.onErrorForAll(methodObject23275, var2));
      }
   }

   public Object getObject() throws SQLException {
      try {
         super.preForAll(methodObject23274, this, zeroLengthObjectArray);
         return this.postForAll(methodObject23274, this.proxyFactory.proxyForCache(this.delegate.getObject(), this, this.proxyCache, methodObject23274));
      } catch (SQLException var2) {
         return this.postForAll(methodObject23274, this.onErrorForAll(methodObject23274, var2));
      }
   }

   public Ref _getDelegate_() {
      return this.delegate;
   }

   public Object getDelegate() {
      return this.delegate;
   }

   public void setDelegate(Object delegate) {
      this.proxyFactory.updateDelegate(this, this.delegate, delegate);
      this.delegate = (Ref)delegate;
   }

   public Object getCreator() {
      return this.creator;
   }

   static {
      try {
         methodObject23273 = Ref.class.getDeclaredMethod("getObject", Map.class);
         methodObject23276 = Ref.class.getDeclaredMethod("setObject", Object.class);
         methodObject23275 = Ref.class.getDeclaredMethod("getBaseTypeName");
         methodObject23274 = Ref.class.getDeclaredMethod("getObject");
      } catch (Throwable var1) {
         throw new RuntimeException(var1);
      }
   }

   public oracle$1jdbc$1replay$1driver$1NonTxnReplayableRef$2java$1sql$1Ref$$$Proxy(Ref var1, Object var2, ProxyFactory var3, Map var4) {
      this.delegate = var1;
      this.creator = var2;
      this.proxyFactory = var3;
      this.proxyCache = var4;
   }
}
