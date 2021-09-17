package oracle.jdbc.proxy;

import java.lang.reflect.Method;
import java.sql.SQLException;
import java.util.Map;
import oracle.jdbc.internal.ACProxyable;
import oracle.jdbc.internal.OracleTypeMetaData;
import oracle.jdbc.replay.driver.TxnReplayableBase;
import oracle.sql.SQLName;

public class oracle$1jdbc$1replay$1driver$1TxnReplayableBase$2oracle$1jdbc$1internal$1OracleTypeMetaData$Opaque$$$Proxy extends TxnReplayableBase implements OracleTypeMetaData.Opaque, _Proxy_ {
   private OracleTypeMetaData.Opaque delegate;
   private final Object creator;
   private final ProxyFactory proxyFactory;
   private final Map proxyCache;
   private static Object[] zeroLengthObjectArray = new Object[0];
   private static Method methodObject4935;
   private static Method methodObject4938;
   private static Method methodObject4929;
   private static Method methodObject4930;
   private static Method methodObject4931;
   private static Method methodObject4936;
   private static Method methodObject4927;
   private static Method methodObject4937;
   private static Method methodObject4934;
   private static Method methodObject4928;
   private static Method methodObject4926;
   private static Method methodObject4932;
   private static Method methodObject4933;

   public boolean isModeledInC() throws SQLException {
      try {
         super.preForAll(methodObject4935, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject4935, this.delegate.isModeledInC());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject4935, this.onErrorForAll(methodObject4935, var2));
      }
   }

   public boolean hasFixedSize() throws SQLException {
      try {
         super.preForAll(methodObject4938, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject4938, this.delegate.hasFixedSize());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject4938, this.onErrorForAll(methodObject4938, var2));
      }
   }

   public SQLName getSQLName() throws SQLException {
      try {
         super.preForAll(methodObject4929, this, zeroLengthObjectArray);
         return (SQLName)this.postForAll(methodObject4929, (Object)this.delegate.getSQLName());
      } catch (SQLException var2) {
         return (SQLName)this.postForAll(methodObject4929, this.onErrorForAll(methodObject4929, var2));
      }
   }

   public String getTypeCodeName() throws SQLException {
      try {
         super.preForAll(methodObject4930, this, zeroLengthObjectArray);
         return (String)this.postForAll(methodObject4930, (Object)this.delegate.getTypeCodeName());
      } catch (SQLException var2) {
         return (String)this.postForAll(methodObject4930, this.onErrorForAll(methodObject4930, var2));
      }
   }

   public oracle.jdbc.OracleTypeMetaData.Kind getKind() {
      super.preForAll(methodObject4931, this, zeroLengthObjectArray);
      return (oracle.jdbc.OracleTypeMetaData.Kind)this.postForAll(methodObject4931, (Object)this.delegate.getKind());
   }

   public boolean isTrustedLibrary() throws SQLException {
      try {
         super.preForAll(methodObject4936, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject4936, this.delegate.isTrustedLibrary());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject4936, this.onErrorForAll(methodObject4936, var2));
      }
   }

   public int getTypeCode() throws SQLException {
      try {
         super.preForAll(methodObject4927, this, zeroLengthObjectArray);
         return (Integer)this.postForAll(methodObject4927, this.delegate.getTypeCode());
      } catch (SQLException var2) {
         return (Integer)this.postForAll(methodObject4927, this.onErrorForAll(methodObject4927, var2));
      }
   }

   public boolean hasUnboundedSize() throws SQLException {
      try {
         super.preForAll(methodObject4937, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject4937, this.delegate.hasUnboundedSize());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject4937, this.onErrorForAll(methodObject4937, var2));
      }
   }

   public long getMaxLength() throws SQLException {
      try {
         super.preForAll(methodObject4934, this, zeroLengthObjectArray);
         return (Long)this.postForAll(methodObject4934, this.delegate.getMaxLength());
      } catch (SQLException var2) {
         return (Long)this.postForAll(methodObject4934, this.onErrorForAll(methodObject4934, var2));
      }
   }

   public String getSchemaName() throws SQLException {
      try {
         super.preForAll(methodObject4928, this, zeroLengthObjectArray);
         return (String)this.postForAll(methodObject4928, (Object)this.delegate.getSchemaName());
      } catch (SQLException var2) {
         return (String)this.postForAll(methodObject4928, this.onErrorForAll(methodObject4928, var2));
      }
   }

   public String getName() throws SQLException {
      try {
         super.preForAll(methodObject4926, this, zeroLengthObjectArray);
         return (String)this.postForAll(methodObject4926, (Object)this.delegate.getName());
      } catch (SQLException var2) {
         return (String)this.postForAll(methodObject4926, this.onErrorForAll(methodObject4926, var2));
      }
   }

   public void setACProxy(Object arg0) {
      super.preForAll(methodObject4932, this, arg0);
      Method var10001 = methodObject4932;
      this.delegate.setACProxy(arg0 instanceof _Proxy_ ? (Object)((_Proxy_)arg0)._getDelegate_() : arg0);
      this.postForAll(var10001);
   }

   public Object getACProxy() {
      super.preForAll(methodObject4933, this, zeroLengthObjectArray);
      return this.postForAll(methodObject4933, this.proxyFactory.proxyForCache(this.delegate.getACProxy(), this, this.proxyCache, methodObject4933));
   }

   public OracleTypeMetaData.Opaque _getDelegate_() {
      return this.delegate;
   }

   public Object getDelegate() {
      return this.delegate;
   }

   public void setDelegate(Object delegate) {
      this.proxyFactory.updateDelegate(this, this.delegate, delegate);
      this.delegate = (OracleTypeMetaData.Opaque)delegate;
   }

   public Object getCreator() {
      return this.creator;
   }

   static {
      try {
         methodObject4935 = oracle.jdbc.OracleTypeMetaData.Opaque.class.getDeclaredMethod("isModeledInC");
         methodObject4938 = oracle.jdbc.OracleTypeMetaData.Opaque.class.getDeclaredMethod("hasFixedSize");
         methodObject4929 = oracle.jdbc.OracleTypeMetaData.class.getDeclaredMethod("getSQLName");
         methodObject4930 = oracle.jdbc.OracleTypeMetaData.class.getDeclaredMethod("getTypeCodeName");
         methodObject4931 = oracle.jdbc.OracleTypeMetaData.class.getDeclaredMethod("getKind");
         methodObject4936 = oracle.jdbc.OracleTypeMetaData.Opaque.class.getDeclaredMethod("isTrustedLibrary");
         methodObject4927 = oracle.jdbc.OracleTypeMetaData.class.getDeclaredMethod("getTypeCode");
         methodObject4937 = oracle.jdbc.OracleTypeMetaData.Opaque.class.getDeclaredMethod("hasUnboundedSize");
         methodObject4934 = oracle.jdbc.OracleTypeMetaData.Opaque.class.getDeclaredMethod("getMaxLength");
         methodObject4928 = oracle.jdbc.OracleTypeMetaData.class.getDeclaredMethod("getSchemaName");
         methodObject4926 = oracle.jdbc.OracleTypeMetaData.class.getDeclaredMethod("getName");
         methodObject4932 = ACProxyable.class.getDeclaredMethod("setACProxy", Object.class);
         methodObject4933 = ACProxyable.class.getDeclaredMethod("getACProxy");
      } catch (Throwable var1) {
         throw new RuntimeException(var1);
      }
   }

   public oracle$1jdbc$1replay$1driver$1TxnReplayableBase$2oracle$1jdbc$1internal$1OracleTypeMetaData$Opaque$$$Proxy(OracleTypeMetaData.Opaque var1, Object var2, ProxyFactory var3, Map var4) {
      this.delegate = var1;
      this.creator = var2;
      this.proxyFactory = var3;
      this.proxyCache = var4;
   }
}
