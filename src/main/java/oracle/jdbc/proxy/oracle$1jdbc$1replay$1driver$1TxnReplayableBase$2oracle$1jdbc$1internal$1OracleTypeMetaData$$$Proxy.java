package oracle.jdbc.proxy;

import java.lang.reflect.Method;
import java.sql.SQLException;
import java.util.Map;
import oracle.jdbc.internal.ACProxyable;
import oracle.jdbc.internal.OracleTypeMetaData;
import oracle.jdbc.replay.driver.TxnReplayableBase;
import oracle.sql.SQLName;

public class oracle$1jdbc$1replay$1driver$1TxnReplayableBase$2oracle$1jdbc$1internal$1OracleTypeMetaData$$$Proxy extends TxnReplayableBase implements OracleTypeMetaData, _Proxy_ {
   private OracleTypeMetaData delegate;
   private final Object creator;
   private final ProxyFactory proxyFactory;
   private final Map proxyCache;
   private static Object[] zeroLengthObjectArray = new Object[0];
   private static Method methodObject4911;
   private static Method methodObject4907;
   private static Method methodObject4909;
   private static Method methodObject4908;
   private static Method methodObject4910;
   private static Method methodObject4912;
   private static Method methodObject4906;
   private static Method methodObject4913;

   public oracle.jdbc.OracleTypeMetaData.Kind getKind() {
      super.preForAll(methodObject4911, this, zeroLengthObjectArray);
      return (oracle.jdbc.OracleTypeMetaData.Kind)this.postForAll(methodObject4911, (Object)this.delegate.getKind());
   }

   public int getTypeCode() throws SQLException {
      try {
         super.preForAll(methodObject4907, this, zeroLengthObjectArray);
         return (Integer)this.postForAll(methodObject4907, this.delegate.getTypeCode());
      } catch (SQLException var2) {
         return (Integer)this.postForAll(methodObject4907, this.onErrorForAll(methodObject4907, var2));
      }
   }

   public SQLName getSQLName() throws SQLException {
      try {
         super.preForAll(methodObject4909, this, zeroLengthObjectArray);
         return (SQLName)this.postForAll(methodObject4909, (Object)this.delegate.getSQLName());
      } catch (SQLException var2) {
         return (SQLName)this.postForAll(methodObject4909, this.onErrorForAll(methodObject4909, var2));
      }
   }

   public String getSchemaName() throws SQLException {
      try {
         super.preForAll(methodObject4908, this, zeroLengthObjectArray);
         return (String)this.postForAll(methodObject4908, (Object)this.delegate.getSchemaName());
      } catch (SQLException var2) {
         return (String)this.postForAll(methodObject4908, this.onErrorForAll(methodObject4908, var2));
      }
   }

   public String getTypeCodeName() throws SQLException {
      try {
         super.preForAll(methodObject4910, this, zeroLengthObjectArray);
         return (String)this.postForAll(methodObject4910, (Object)this.delegate.getTypeCodeName());
      } catch (SQLException var2) {
         return (String)this.postForAll(methodObject4910, this.onErrorForAll(methodObject4910, var2));
      }
   }

   public void setACProxy(Object arg0) {
      super.preForAll(methodObject4912, this, arg0);
      Method var10001 = methodObject4912;
      this.delegate.setACProxy(arg0 instanceof _Proxy_ ? (Object)((_Proxy_)arg0)._getDelegate_() : arg0);
      this.postForAll(var10001);
   }

   public String getName() throws SQLException {
      try {
         super.preForAll(methodObject4906, this, zeroLengthObjectArray);
         return (String)this.postForAll(methodObject4906, (Object)this.delegate.getName());
      } catch (SQLException var2) {
         return (String)this.postForAll(methodObject4906, this.onErrorForAll(methodObject4906, var2));
      }
   }

   public Object getACProxy() {
      super.preForAll(methodObject4913, this, zeroLengthObjectArray);
      return this.postForAll(methodObject4913, this.proxyFactory.proxyForCache(this.delegate.getACProxy(), this, this.proxyCache, methodObject4913));
   }

   public OracleTypeMetaData _getDelegate_() {
      return this.delegate;
   }

   public Object getDelegate() {
      return this.delegate;
   }

   public void setDelegate(Object delegate) {
      this.proxyFactory.updateDelegate(this, this.delegate, delegate);
      this.delegate = (OracleTypeMetaData)delegate;
   }

   public Object getCreator() {
      return this.creator;
   }

   static {
      try {
         methodObject4911 = oracle.jdbc.OracleTypeMetaData.class.getDeclaredMethod("getKind");
         methodObject4907 = oracle.jdbc.OracleTypeMetaData.class.getDeclaredMethod("getTypeCode");
         methodObject4909 = oracle.jdbc.OracleTypeMetaData.class.getDeclaredMethod("getSQLName");
         methodObject4908 = oracle.jdbc.OracleTypeMetaData.class.getDeclaredMethod("getSchemaName");
         methodObject4910 = oracle.jdbc.OracleTypeMetaData.class.getDeclaredMethod("getTypeCodeName");
         methodObject4912 = ACProxyable.class.getDeclaredMethod("setACProxy", Object.class);
         methodObject4906 = oracle.jdbc.OracleTypeMetaData.class.getDeclaredMethod("getName");
         methodObject4913 = ACProxyable.class.getDeclaredMethod("getACProxy");
      } catch (Throwable var1) {
         throw new RuntimeException(var1);
      }
   }

   public oracle$1jdbc$1replay$1driver$1TxnReplayableBase$2oracle$1jdbc$1internal$1OracleTypeMetaData$$$Proxy(OracleTypeMetaData var1, Object var2, ProxyFactory var3, Map var4) {
      this.delegate = var1;
      this.creator = var2;
      this.proxyFactory = var3;
      this.proxyCache = var4;
   }
}
