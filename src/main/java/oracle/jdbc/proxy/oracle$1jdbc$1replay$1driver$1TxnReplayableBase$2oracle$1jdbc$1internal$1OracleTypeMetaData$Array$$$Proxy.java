package oracle.jdbc.proxy;

import java.lang.reflect.Method;
import java.sql.SQLException;
import java.util.Map;
import oracle.jdbc.internal.ACProxyable;
import oracle.jdbc.internal.OracleTypeMetaData;
import oracle.jdbc.replay.driver.TxnReplayableBase;
import oracle.sql.SQLName;

public class oracle$1jdbc$1replay$1driver$1TxnReplayableBase$2oracle$1jdbc$1internal$1OracleTypeMetaData$Array$$$Proxy extends TxnReplayableBase implements OracleTypeMetaData.Array, _Proxy_ {
   private OracleTypeMetaData.Array delegate;
   private final Object creator;
   private final ProxyFactory proxyFactory;
   private final Map proxyCache;
   private static Object[] zeroLengthObjectArray = new Object[0];
   private static Method methodObject4919;
   private static Method methodObject4925;
   private static Method methodObject4915;
   private static Method methodObject4924;
   private static Method methodObject4917;
   private static Method methodObject4916;
   private static Method methodObject4918;
   private static Method methodObject4923;
   private static Method methodObject4922;
   private static Method methodObject4920;
   private static Method methodObject4914;
   private static Method methodObject4921;

   public oracle.jdbc.OracleTypeMetaData.Kind getKind() {
      super.preForAll(methodObject4919, this, zeroLengthObjectArray);
      return (oracle.jdbc.OracleTypeMetaData.Kind)this.postForAll(methodObject4919, (Object)this.delegate.getKind());
   }

   public oracle.jdbc.OracleTypeMetaData.ArrayStorage getArrayStorage() throws SQLException {
      try {
         super.preForAll(methodObject4925, this, zeroLengthObjectArray);
         return (oracle.jdbc.OracleTypeMetaData.ArrayStorage)this.postForAll(methodObject4925, (Object)this.delegate.getArrayStorage());
      } catch (SQLException var2) {
         return (oracle.jdbc.OracleTypeMetaData.ArrayStorage)this.postForAll(methodObject4925, this.onErrorForAll(methodObject4925, var2));
      }
   }

   public int getTypeCode() throws SQLException {
      try {
         super.preForAll(methodObject4915, this, zeroLengthObjectArray);
         return (Integer)this.postForAll(methodObject4915, this.delegate.getTypeCode());
      } catch (SQLException var2) {
         return (Integer)this.postForAll(methodObject4915, this.onErrorForAll(methodObject4915, var2));
      }
   }

   public long getMaxLength() throws SQLException {
      try {
         super.preForAll(methodObject4924, this, zeroLengthObjectArray);
         return (Long)this.postForAll(methodObject4924, this.delegate.getMaxLength());
      } catch (SQLException var2) {
         return (Long)this.postForAll(methodObject4924, this.onErrorForAll(methodObject4924, var2));
      }
   }

   public SQLName getSQLName() throws SQLException {
      try {
         super.preForAll(methodObject4917, this, zeroLengthObjectArray);
         return (SQLName)this.postForAll(methodObject4917, (Object)this.delegate.getSQLName());
      } catch (SQLException var2) {
         return (SQLName)this.postForAll(methodObject4917, this.onErrorForAll(methodObject4917, var2));
      }
   }

   public String getSchemaName() throws SQLException {
      try {
         super.preForAll(methodObject4916, this, zeroLengthObjectArray);
         return (String)this.postForAll(methodObject4916, (Object)this.delegate.getSchemaName());
      } catch (SQLException var2) {
         return (String)this.postForAll(methodObject4916, this.onErrorForAll(methodObject4916, var2));
      }
   }

   public String getTypeCodeName() throws SQLException {
      try {
         super.preForAll(methodObject4918, this, zeroLengthObjectArray);
         return (String)this.postForAll(methodObject4918, (Object)this.delegate.getTypeCodeName());
      } catch (SQLException var2) {
         return (String)this.postForAll(methodObject4918, this.onErrorForAll(methodObject4918, var2));
      }
   }

   public String getBaseName() throws SQLException {
      try {
         super.preForAll(methodObject4923, this, zeroLengthObjectArray);
         return (String)this.postForAll(methodObject4923, (Object)this.delegate.getBaseName());
      } catch (SQLException var2) {
         return (String)this.postForAll(methodObject4923, this.onErrorForAll(methodObject4923, var2));
      }
   }

   public int getBaseType() throws SQLException {
      try {
         super.preForAll(methodObject4922, this, zeroLengthObjectArray);
         return (Integer)this.postForAll(methodObject4922, this.delegate.getBaseType());
      } catch (SQLException var2) {
         return (Integer)this.postForAll(methodObject4922, this.onErrorForAll(methodObject4922, var2));
      }
   }

   public void setACProxy(Object arg0) {
      super.preForAll(methodObject4920, this, arg0);
      Method var10001 = methodObject4920;
      this.delegate.setACProxy(arg0 instanceof _Proxy_ ? (Object)((_Proxy_)arg0)._getDelegate_() : arg0);
      this.postForAll(var10001);
   }

   public String getName() throws SQLException {
      try {
         super.preForAll(methodObject4914, this, zeroLengthObjectArray);
         return (String)this.postForAll(methodObject4914, (Object)this.delegate.getName());
      } catch (SQLException var2) {
         return (String)this.postForAll(methodObject4914, this.onErrorForAll(methodObject4914, var2));
      }
   }

   public Object getACProxy() {
      super.preForAll(methodObject4921, this, zeroLengthObjectArray);
      return this.postForAll(methodObject4921, this.proxyFactory.proxyForCache(this.delegate.getACProxy(), this, this.proxyCache, methodObject4921));
   }

   public OracleTypeMetaData.Array _getDelegate_() {
      return this.delegate;
   }

   public Object getDelegate() {
      return this.delegate;
   }

   public void setDelegate(Object delegate) {
      this.proxyFactory.updateDelegate(this, this.delegate, delegate);
      this.delegate = (OracleTypeMetaData.Array)delegate;
   }

   public Object getCreator() {
      return this.creator;
   }

   static {
      try {
         methodObject4919 = oracle.jdbc.OracleTypeMetaData.class.getDeclaredMethod("getKind");
         methodObject4925 = oracle.jdbc.OracleTypeMetaData.Array.class.getDeclaredMethod("getArrayStorage");
         methodObject4915 = oracle.jdbc.OracleTypeMetaData.class.getDeclaredMethod("getTypeCode");
         methodObject4924 = oracle.jdbc.OracleTypeMetaData.Array.class.getDeclaredMethod("getMaxLength");
         methodObject4917 = oracle.jdbc.OracleTypeMetaData.class.getDeclaredMethod("getSQLName");
         methodObject4916 = oracle.jdbc.OracleTypeMetaData.class.getDeclaredMethod("getSchemaName");
         methodObject4918 = oracle.jdbc.OracleTypeMetaData.class.getDeclaredMethod("getTypeCodeName");
         methodObject4923 = oracle.jdbc.OracleTypeMetaData.Array.class.getDeclaredMethod("getBaseName");
         methodObject4922 = oracle.jdbc.OracleTypeMetaData.Array.class.getDeclaredMethod("getBaseType");
         methodObject4920 = ACProxyable.class.getDeclaredMethod("setACProxy", Object.class);
         methodObject4914 = oracle.jdbc.OracleTypeMetaData.class.getDeclaredMethod("getName");
         methodObject4921 = ACProxyable.class.getDeclaredMethod("getACProxy");
      } catch (Throwable var1) {
         throw new RuntimeException(var1);
      }
   }

   public oracle$1jdbc$1replay$1driver$1TxnReplayableBase$2oracle$1jdbc$1internal$1OracleTypeMetaData$Array$$$Proxy(OracleTypeMetaData.Array var1, Object var2, ProxyFactory var3, Map var4) {
      this.delegate = var1;
      this.creator = var2;
      this.proxyFactory = var3;
      this.proxyCache = var4;
   }
}
