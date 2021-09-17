package oracle.jdbc.proxy;

import java.lang.reflect.Method;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Map;
import oracle.jdbc.internal.ACProxyable;
import oracle.jdbc.internal.OracleTypeMetaData;
import oracle.jdbc.replay.driver.TxnReplayableBase;
import oracle.sql.SQLName;

public class oracle$1jdbc$1replay$1driver$1TxnReplayableBase$2oracle$1jdbc$1internal$1OracleTypeMetaData$Struct$$$Proxy extends TxnReplayableBase implements OracleTypeMetaData.Struct, _Proxy_ {
   private OracleTypeMetaData.Struct delegate;
   private final Object creator;
   private final ProxyFactory proxyFactory;
   private final Map proxyCache;
   private static Object[] zeroLengthObjectArray = new Object[0];
   private static Method methodObject4955;
   private static Method methodObject4942;
   private static Method methodObject4943;
   private static Method methodObject4948;
   private static Method methodObject4944;
   private static Method methodObject4950;
   private static Method methodObject4940;
   private static Method methodObject4951;
   private static Method methodObject4953;
   private static Method methodObject4941;
   private static Method methodObject4952;
   private static Method methodObject4949;
   private static Method methodObject4939;
   private static Method methodObject4945;
   private static Method methodObject4947;
   private static Method methodObject4954;
   private static Method methodObject4946;

   public String[] getSubtypeNames() throws SQLException {
      try {
         super.preForAll(methodObject4955, this, zeroLengthObjectArray);
         return (String[])this.postForAll(methodObject4955, (Object)this.delegate.getSubtypeNames());
      } catch (SQLException var2) {
         return (String[])this.postForAll(methodObject4955, this.onErrorForAll(methodObject4955, var2));
      }
   }

   public SQLName getSQLName() throws SQLException {
      try {
         super.preForAll(methodObject4942, this, zeroLengthObjectArray);
         return (SQLName)this.postForAll(methodObject4942, (Object)this.delegate.getSQLName());
      } catch (SQLException var2) {
         return (SQLName)this.postForAll(methodObject4942, this.onErrorForAll(methodObject4942, var2));
      }
   }

   public String getTypeCodeName() throws SQLException {
      try {
         super.preForAll(methodObject4943, this, zeroLengthObjectArray);
         return (String)this.postForAll(methodObject4943, (Object)this.delegate.getTypeCodeName());
      } catch (SQLException var2) {
         return (String)this.postForAll(methodObject4943, this.onErrorForAll(methodObject4943, var2));
      }
   }

   public ResultSetMetaData getMetaData() throws SQLException {
      try {
         super.preForAll(methodObject4948, this, zeroLengthObjectArray);
         return (ResultSetMetaData)this.postForAll(methodObject4948, this.proxyFactory.proxyForCache((Object)this.delegate.getMetaData(), this, this.proxyCache, methodObject4948));
      } catch (SQLException var2) {
         return (ResultSetMetaData)this.postForAll(methodObject4948, this.onErrorForAll(methodObject4948, var2));
      }
   }

   public oracle.jdbc.OracleTypeMetaData.Kind getKind() {
      super.preForAll(methodObject4944, this, zeroLengthObjectArray);
      return (oracle.jdbc.OracleTypeMetaData.Kind)this.postForAll(methodObject4944, (Object)this.delegate.getKind());
   }

   public boolean isFinalType() throws SQLException {
      try {
         super.preForAll(methodObject4950, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject4950, this.delegate.isFinalType());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject4950, this.onErrorForAll(methodObject4950, var2));
      }
   }

   public int getTypeCode() throws SQLException {
      try {
         super.preForAll(methodObject4940, this, zeroLengthObjectArray);
         return (Integer)this.postForAll(methodObject4940, this.delegate.getTypeCode());
      } catch (SQLException var2) {
         return (Integer)this.postForAll(methodObject4940, this.onErrorForAll(methodObject4940, var2));
      }
   }

   public boolean isSubtype() throws SQLException {
      try {
         super.preForAll(methodObject4951, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject4951, this.delegate.isSubtype());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject4951, this.onErrorForAll(methodObject4951, var2));
      }
   }

   public String getSupertypeName() throws SQLException {
      try {
         super.preForAll(methodObject4953, this, zeroLengthObjectArray);
         return (String)this.postForAll(methodObject4953, (Object)this.delegate.getSupertypeName());
      } catch (SQLException var2) {
         return (String)this.postForAll(methodObject4953, this.onErrorForAll(methodObject4953, var2));
      }
   }

   public String getSchemaName() throws SQLException {
      try {
         super.preForAll(methodObject4941, this, zeroLengthObjectArray);
         return (String)this.postForAll(methodObject4941, (Object)this.delegate.getSchemaName());
      } catch (SQLException var2) {
         return (String)this.postForAll(methodObject4941, this.onErrorForAll(methodObject4941, var2));
      }
   }

   public boolean isInstantiable() throws SQLException {
      try {
         super.preForAll(methodObject4952, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject4952, this.delegate.isInstantiable());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject4952, this.onErrorForAll(methodObject4952, var2));
      }
   }

   public int getTypeVersion() throws SQLException {
      try {
         super.preForAll(methodObject4949, this, zeroLengthObjectArray);
         return (Integer)this.postForAll(methodObject4949, this.delegate.getTypeVersion());
      } catch (SQLException var2) {
         return (Integer)this.postForAll(methodObject4949, this.onErrorForAll(methodObject4949, var2));
      }
   }

   public String getName() throws SQLException {
      try {
         super.preForAll(methodObject4939, this, zeroLengthObjectArray);
         return (String)this.postForAll(methodObject4939, (Object)this.delegate.getName());
      } catch (SQLException var2) {
         return (String)this.postForAll(methodObject4939, this.onErrorForAll(methodObject4939, var2));
      }
   }

   public void setACProxy(Object arg0) {
      super.preForAll(methodObject4945, this, arg0);
      Method var10001 = methodObject4945;
      this.delegate.setACProxy(arg0 instanceof _Proxy_ ? (Object)((_Proxy_)arg0)._getDelegate_() : arg0);
      this.postForAll(var10001);
   }

   public int getLength() throws SQLException {
      try {
         super.preForAll(methodObject4947, this, zeroLengthObjectArray);
         return (Integer)this.postForAll(methodObject4947, this.delegate.getLength());
      } catch (SQLException var2) {
         return (Integer)this.postForAll(methodObject4947, this.onErrorForAll(methodObject4947, var2));
      }
   }

   public int getLocalAttributeCount() throws SQLException {
      try {
         super.preForAll(methodObject4954, this, zeroLengthObjectArray);
         return (Integer)this.postForAll(methodObject4954, this.delegate.getLocalAttributeCount());
      } catch (SQLException var2) {
         return (Integer)this.postForAll(methodObject4954, this.onErrorForAll(methodObject4954, var2));
      }
   }

   public Object getACProxy() {
      super.preForAll(methodObject4946, this, zeroLengthObjectArray);
      return this.postForAll(methodObject4946, this.proxyFactory.proxyForCache(this.delegate.getACProxy(), this, this.proxyCache, methodObject4946));
   }

   public OracleTypeMetaData.Struct _getDelegate_() {
      return this.delegate;
   }

   public Object getDelegate() {
      return this.delegate;
   }

   public void setDelegate(Object delegate) {
      this.proxyFactory.updateDelegate(this, this.delegate, delegate);
      this.delegate = (OracleTypeMetaData.Struct)delegate;
   }

   public Object getCreator() {
      return this.creator;
   }

   static {
      try {
         methodObject4955 = oracle.jdbc.OracleTypeMetaData.Struct.class.getDeclaredMethod("getSubtypeNames");
         methodObject4942 = oracle.jdbc.OracleTypeMetaData.class.getDeclaredMethod("getSQLName");
         methodObject4943 = oracle.jdbc.OracleTypeMetaData.class.getDeclaredMethod("getTypeCodeName");
         methodObject4948 = oracle.jdbc.OracleTypeMetaData.Struct.class.getDeclaredMethod("getMetaData");
         methodObject4944 = oracle.jdbc.OracleTypeMetaData.class.getDeclaredMethod("getKind");
         methodObject4950 = oracle.jdbc.OracleTypeMetaData.Struct.class.getDeclaredMethod("isFinalType");
         methodObject4940 = oracle.jdbc.OracleTypeMetaData.class.getDeclaredMethod("getTypeCode");
         methodObject4951 = oracle.jdbc.OracleTypeMetaData.Struct.class.getDeclaredMethod("isSubtype");
         methodObject4953 = oracle.jdbc.OracleTypeMetaData.Struct.class.getDeclaredMethod("getSupertypeName");
         methodObject4941 = oracle.jdbc.OracleTypeMetaData.class.getDeclaredMethod("getSchemaName");
         methodObject4952 = oracle.jdbc.OracleTypeMetaData.Struct.class.getDeclaredMethod("isInstantiable");
         methodObject4949 = oracle.jdbc.OracleTypeMetaData.Struct.class.getDeclaredMethod("getTypeVersion");
         methodObject4939 = oracle.jdbc.OracleTypeMetaData.class.getDeclaredMethod("getName");
         methodObject4945 = ACProxyable.class.getDeclaredMethod("setACProxy", Object.class);
         methodObject4947 = oracle.jdbc.OracleTypeMetaData.Struct.class.getDeclaredMethod("getLength");
         methodObject4954 = oracle.jdbc.OracleTypeMetaData.Struct.class.getDeclaredMethod("getLocalAttributeCount");
         methodObject4946 = ACProxyable.class.getDeclaredMethod("getACProxy");
      } catch (Throwable var1) {
         throw new RuntimeException(var1);
      }
   }

   public oracle$1jdbc$1replay$1driver$1TxnReplayableBase$2oracle$1jdbc$1internal$1OracleTypeMetaData$Struct$$$Proxy(OracleTypeMetaData.Struct var1, Object var2, ProxyFactory var3, Map var4) {
      this.delegate = var1;
      this.creator = var2;
      this.proxyFactory = var3;
      this.proxyCache = var4;
   }
}
