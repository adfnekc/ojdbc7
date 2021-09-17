package oracle.jdbc.proxy;

import java.lang.reflect.Method;
import java.sql.Ref;
import java.sql.SQLException;
import java.util.Map;
import oracle.jdbc.OracleRef;
import oracle.jdbc.OracleTypeMetaData;
import oracle.jdbc.replay.driver.NonTxnReplayableRef;

public abstract class oracle$1jdbc$1replay$1driver$1NonTxnReplayableRef$2oracle$1jdbc$1OracleRef$$$Proxy extends NonTxnReplayableRef implements OracleRef, _Proxy_ {
   private OracleRef delegate;
   private final Object creator;
   private final ProxyFactory proxyFactory;
   private final Map proxyCache;
   private static Object[] zeroLengthObjectArray = new Object[0];
   private static Method methodObject23278;
   private static Method methodObject23277;
   private static Method methodObject23281;
   private static Method methodObject23280;
   private static Method methodObject23279;

   public Object getObject(Map arg0) throws SQLException {
      try {
         super.preForAll(methodObject23278, this, arg0);
         return this.postForAll(methodObject23278, this.proxyFactory.proxyForCache(this.delegate.getObject(arg0), this, this.proxyCache, methodObject23278));
      } catch (SQLException var3) {
         return this.postForAll(methodObject23278, this.onErrorForAll(methodObject23278, var3));
      }
   }

   public OracleTypeMetaData getOracleMetaData() throws SQLException {
      try {
         super.preForAll(methodObject23277, this, zeroLengthObjectArray);
         return (OracleTypeMetaData)this.postForAll(methodObject23277, this.proxyFactory.proxyForCache((Object)this.delegate.getOracleMetaData(), this, this.proxyCache, methodObject23277));
      } catch (SQLException var2) {
         return (OracleTypeMetaData)this.postForAll(methodObject23277, this.onErrorForAll(methodObject23277, var2));
      }
   }

   public void setObject(Object arg0) throws SQLException {
      try {
         super.preForAll(methodObject23281, this, arg0);
         this.delegate.setObject(arg0 instanceof _Proxy_ ? (Object)((_Proxy_)arg0)._getDelegate_() : arg0);
      } catch (SQLException var3) {
         this.onErrorVoidForAll(methodObject23281, var3);
      }
   }

   public String getBaseTypeName() throws SQLException {
      try {
         super.preForAll(methodObject23280, this, zeroLengthObjectArray);
         return (String)this.postForAll(methodObject23280, (Object)this.delegate.getBaseTypeName());
      } catch (SQLException var2) {
         return (String)this.postForAll(methodObject23280, this.onErrorForAll(methodObject23280, var2));
      }
   }

   public Object getObject() throws SQLException {
      try {
         super.preForAll(methodObject23279, this, zeroLengthObjectArray);
         return this.postForAll(methodObject23279, this.proxyFactory.proxyForCache(this.delegate.getObject(), this, this.proxyCache, methodObject23279));
      } catch (SQLException var2) {
         return this.postForAll(methodObject23279, this.onErrorForAll(methodObject23279, var2));
      }
   }

   public OracleRef _getDelegate_() {
      return this.delegate;
   }

   public Object getDelegate() {
      return this.delegate;
   }

   public void setDelegate(Object delegate) {
      this.proxyFactory.updateDelegate(this, this.delegate, delegate);
      this.delegate = (OracleRef)delegate;
   }

   public Object getCreator() {
      return this.creator;
   }

   static {
      try {
         methodObject23278 = Ref.class.getDeclaredMethod("getObject", Map.class);
         methodObject23277 = OracleRef.class.getDeclaredMethod("getOracleMetaData");
         methodObject23281 = Ref.class.getDeclaredMethod("setObject", Object.class);
         methodObject23280 = Ref.class.getDeclaredMethod("getBaseTypeName");
         methodObject23279 = Ref.class.getDeclaredMethod("getObject");
      } catch (Throwable var1) {
         throw new RuntimeException(var1);
      }
   }

   public oracle$1jdbc$1replay$1driver$1NonTxnReplayableRef$2oracle$1jdbc$1OracleRef$$$Proxy(OracleRef var1, Object var2, ProxyFactory var3, Map var4) {
      this.delegate = var1;
      this.creator = var2;
      this.proxyFactory = var3;
      this.proxyCache = var4;
   }
}
