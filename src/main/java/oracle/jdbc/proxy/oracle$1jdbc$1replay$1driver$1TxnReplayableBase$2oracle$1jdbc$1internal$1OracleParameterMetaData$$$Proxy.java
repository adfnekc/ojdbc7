package oracle.jdbc.proxy;

import java.lang.reflect.Method;
import java.sql.ParameterMetaData;
import java.sql.SQLException;
import java.sql.Wrapper;
import java.util.Map;
import oracle.jdbc.internal.ACProxyable;
import oracle.jdbc.internal.OracleParameterMetaData;
import oracle.jdbc.replay.driver.TxnReplayableBase;

public class oracle$1jdbc$1replay$1driver$1TxnReplayableBase$2oracle$1jdbc$1internal$1OracleParameterMetaData$$$Proxy extends TxnReplayableBase implements OracleParameterMetaData, _Proxy_ {
   private OracleParameterMetaData delegate;
   private final Object creator;
   private final ProxyFactory proxyFactory;
   private final Map proxyCache;
   private static Object[] zeroLengthObjectArray = new Object[0];
   private static Method methodObject4889;
   private static Method methodObject4887;
   private static Method methodObject4893;
   private static Method methodObject4895;
   private static Method methodObject4890;
   private static Method methodObject4891;
   private static Method methodObject4885;
   private static Method methodObject4886;
   private static Method methodObject4888;
   private static Method methodObject4896;
   private static Method methodObject4894;
   private static Method methodObject4897;
   private static Method methodObject4892;

   public String getParameterClassName(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject4889, this, arg0);
         return (String)this.postForAll(methodObject4889, (Object)this.delegate.getParameterClassName(arg0));
      } catch (SQLException var3) {
         return (String)this.postForAll(methodObject4889, this.onErrorForAll(methodObject4889, var3));
      }
   }

   public int getPrecision(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject4887, this, arg0);
         return (Integer)this.postForAll(methodObject4887, this.delegate.getPrecision(arg0));
      } catch (SQLException var3) {
         return (Integer)this.postForAll(methodObject4887, this.onErrorForAll(methodObject4887, var3));
      }
   }

   public String getParameterTypeName(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject4893, this, arg0);
         return (String)this.postForAll(methodObject4893, (Object)this.delegate.getParameterTypeName(arg0));
      } catch (SQLException var3) {
         return (String)this.postForAll(methodObject4893, this.onErrorForAll(methodObject4893, var3));
      }
   }

   public boolean isWrapperFor(Class arg0) throws SQLException {
      try {
         super.preForAll(methodObject4895, this, arg0);
         return (Boolean)this.postForAll(methodObject4895, this.delegate.isWrapperFor(arg0));
      } catch (SQLException var3) {
         return (Boolean)this.postForAll(methodObject4895, this.onErrorForAll(methodObject4895, var3));
      }
   }

   public int getParameterCount() throws SQLException {
      try {
         super.preForAll(methodObject4890, this, zeroLengthObjectArray);
         return (Integer)this.postForAll(methodObject4890, this.delegate.getParameterCount());
      } catch (SQLException var2) {
         return (Integer)this.postForAll(methodObject4890, this.onErrorForAll(methodObject4890, var2));
      }
   }

   public int getParameterMode(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject4891, this, arg0);
         return (Integer)this.postForAll(methodObject4891, this.delegate.getParameterMode(arg0));
      } catch (SQLException var3) {
         return (Integer)this.postForAll(methodObject4891, this.onErrorForAll(methodObject4891, var3));
      }
   }

   public int isNullable(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject4885, this, arg0);
         return (Integer)this.postForAll(methodObject4885, this.delegate.isNullable(arg0));
      } catch (SQLException var3) {
         return (Integer)this.postForAll(methodObject4885, this.onErrorForAll(methodObject4885, var3));
      }
   }

   public boolean isSigned(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject4886, this, arg0);
         return (Boolean)this.postForAll(methodObject4886, this.delegate.isSigned(arg0));
      } catch (SQLException var3) {
         return (Boolean)this.postForAll(methodObject4886, this.onErrorForAll(methodObject4886, var3));
      }
   }

   public int getScale(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject4888, this, arg0);
         return (Integer)this.postForAll(methodObject4888, this.delegate.getScale(arg0));
      } catch (SQLException var3) {
         return (Integer)this.postForAll(methodObject4888, this.onErrorForAll(methodObject4888, var3));
      }
   }

   public void setACProxy(Object arg0) {
      super.preForAll(methodObject4896, this, arg0);
      Method var10001 = methodObject4896;
      this.delegate.setACProxy(arg0 instanceof _Proxy_ ? (Object)((_Proxy_)arg0)._getDelegate_() : arg0);
      this.postForAll(var10001);
   }

   public Object unwrap(Class arg0) throws SQLException {
      try {
         super.preForAll(methodObject4894, this, arg0);
         return this.postForAll(methodObject4894, this.proxyFactory.proxyForCache(this.delegate.unwrap(arg0), this, this.proxyCache, methodObject4894));
      } catch (SQLException var3) {
         return this.postForAll(methodObject4894, this.onErrorForAll(methodObject4894, var3));
      }
   }

   public Object getACProxy() {
      super.preForAll(methodObject4897, this, zeroLengthObjectArray);
      return this.postForAll(methodObject4897, this.proxyFactory.proxyForCache(this.delegate.getACProxy(), this, this.proxyCache, methodObject4897));
   }

   public int getParameterType(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject4892, this, arg0);
         return (Integer)this.postForAll(methodObject4892, this.delegate.getParameterType(arg0));
      } catch (SQLException var3) {
         return (Integer)this.postForAll(methodObject4892, this.onErrorForAll(methodObject4892, var3));
      }
   }

   public OracleParameterMetaData _getDelegate_() {
      return this.delegate;
   }

   public Object getDelegate() {
      return this.delegate;
   }

   public void setDelegate(Object delegate) {
      this.proxyFactory.updateDelegate(this, this.delegate, delegate);
      this.delegate = (OracleParameterMetaData)delegate;
   }

   public Object getCreator() {
      return this.creator;
   }

   static {
      try {
         methodObject4889 = ParameterMetaData.class.getDeclaredMethod("getParameterClassName", Integer.TYPE);
         methodObject4887 = ParameterMetaData.class.getDeclaredMethod("getPrecision", Integer.TYPE);
         methodObject4893 = ParameterMetaData.class.getDeclaredMethod("getParameterTypeName", Integer.TYPE);
         methodObject4895 = Wrapper.class.getDeclaredMethod("isWrapperFor", Class.class);
         methodObject4890 = ParameterMetaData.class.getDeclaredMethod("getParameterCount");
         methodObject4891 = ParameterMetaData.class.getDeclaredMethod("getParameterMode", Integer.TYPE);
         methodObject4885 = ParameterMetaData.class.getDeclaredMethod("isNullable", Integer.TYPE);
         methodObject4886 = ParameterMetaData.class.getDeclaredMethod("isSigned", Integer.TYPE);
         methodObject4888 = ParameterMetaData.class.getDeclaredMethod("getScale", Integer.TYPE);
         methodObject4896 = ACProxyable.class.getDeclaredMethod("setACProxy", Object.class);
         methodObject4894 = Wrapper.class.getDeclaredMethod("unwrap", Class.class);
         methodObject4897 = ACProxyable.class.getDeclaredMethod("getACProxy");
         methodObject4892 = ParameterMetaData.class.getDeclaredMethod("getParameterType", Integer.TYPE);
      } catch (Throwable var1) {
         throw new RuntimeException(var1);
      }
   }

   public oracle$1jdbc$1replay$1driver$1TxnReplayableBase$2oracle$1jdbc$1internal$1OracleParameterMetaData$$$Proxy(OracleParameterMetaData var1, Object var2, ProxyFactory var3, Map var4) {
      this.delegate = var1;
      this.creator = var2;
      this.proxyFactory = var3;
      this.proxyCache = var4;
   }
}
