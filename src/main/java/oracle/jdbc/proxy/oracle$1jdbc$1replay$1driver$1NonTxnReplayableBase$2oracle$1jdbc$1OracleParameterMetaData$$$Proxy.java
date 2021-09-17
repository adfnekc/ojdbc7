package oracle.jdbc.proxy;

import java.lang.reflect.Method;
import java.sql.ParameterMetaData;
import java.sql.SQLException;
import java.sql.Wrapper;
import java.util.Map;
import oracle.jdbc.OracleParameterMetaData;
import oracle.jdbc.replay.driver.NonTxnReplayableBase;

public abstract class oracle$1jdbc$1replay$1driver$1NonTxnReplayableBase$2oracle$1jdbc$1OracleParameterMetaData$$$Proxy extends NonTxnReplayableBase implements OracleParameterMetaData, _Proxy_ {
   private OracleParameterMetaData delegate;
   private final Object creator;
   private final ProxyFactory proxyFactory;
   private final Map proxyCache;
   private static Object[] zeroLengthObjectArray = new Object[0];
   private static Method methodObject29997;
   private static Method methodObject30000;
   private static Method methodObject29993;
   private static Method methodObject29995;
   private static Method methodObject29999;
   private static Method methodObject29996;
   private static Method methodObject29994;
   private static Method methodObject30003;
   private static Method methodObject30002;
   private static Method methodObject29998;
   private static Method methodObject30001;

   public int getParameterType(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject29997, this, arg0);
         return (Integer)this.postForAll(methodObject29997, this.delegate.getParameterType(arg0));
      } catch (SQLException var3) {
         return (Integer)this.postForAll(methodObject29997, this.onErrorForAll(methodObject29997, var3));
      }
   }

   public int isNullable(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject30000, this, arg0);
         return (Integer)this.postForAll(methodObject30000, this.delegate.isNullable(arg0));
      } catch (SQLException var3) {
         return (Integer)this.postForAll(methodObject30000, this.onErrorForAll(methodObject30000, var3));
      }
   }

   public String getParameterClassName(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject29993, this, arg0);
         return (String)this.postForAll(methodObject29993, (Object)this.delegate.getParameterClassName(arg0));
      } catch (SQLException var3) {
         return (String)this.postForAll(methodObject29993, this.onErrorForAll(methodObject29993, var3));
      }
   }

   public int getParameterCount() throws SQLException {
      try {
         super.preForAll(methodObject29995, this, zeroLengthObjectArray);
         return (Integer)this.postForAll(methodObject29995, this.delegate.getParameterCount());
      } catch (SQLException var2) {
         return (Integer)this.postForAll(methodObject29995, this.onErrorForAll(methodObject29995, var2));
      }
   }

   public int getScale(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject29999, this, arg0);
         return (Integer)this.postForAll(methodObject29999, this.delegate.getScale(arg0));
      } catch (SQLException var3) {
         return (Integer)this.postForAll(methodObject29999, this.onErrorForAll(methodObject29999, var3));
      }
   }

   public int getParameterMode(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject29996, this, arg0);
         return (Integer)this.postForAll(methodObject29996, this.delegate.getParameterMode(arg0));
      } catch (SQLException var3) {
         return (Integer)this.postForAll(methodObject29996, this.onErrorForAll(methodObject29996, var3));
      }
   }

   public int getPrecision(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject29994, this, arg0);
         return (Integer)this.postForAll(methodObject29994, this.delegate.getPrecision(arg0));
      } catch (SQLException var3) {
         return (Integer)this.postForAll(methodObject29994, this.onErrorForAll(methodObject29994, var3));
      }
   }

   public boolean isWrapperFor(Class arg0) throws SQLException {
      try {
         super.preForAll(methodObject30003, this, arg0);
         return (Boolean)this.postForAll(methodObject30003, this.delegate.isWrapperFor(arg0));
      } catch (SQLException var3) {
         return (Boolean)this.postForAll(methodObject30003, this.onErrorForAll(methodObject30003, var3));
      }
   }

   public Object unwrap(Class arg0) throws SQLException {
      try {
         super.preForAll(methodObject30002, this, arg0);
         return this.postForAll(methodObject30002, this.proxyFactory.proxyForCache(this.delegate.unwrap(arg0), this, this.proxyCache, methodObject30002));
      } catch (SQLException var3) {
         return this.postForAll(methodObject30002, this.onErrorForAll(methodObject30002, var3));
      }
   }

   public String getParameterTypeName(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject29998, this, arg0);
         return (String)this.postForAll(methodObject29998, (Object)this.delegate.getParameterTypeName(arg0));
      } catch (SQLException var3) {
         return (String)this.postForAll(methodObject29998, this.onErrorForAll(methodObject29998, var3));
      }
   }

   public boolean isSigned(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject30001, this, arg0);
         return (Boolean)this.postForAll(methodObject30001, this.delegate.isSigned(arg0));
      } catch (SQLException var3) {
         return (Boolean)this.postForAll(methodObject30001, this.onErrorForAll(methodObject30001, var3));
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
         methodObject29997 = ParameterMetaData.class.getDeclaredMethod("getParameterType", Integer.TYPE);
         methodObject30000 = ParameterMetaData.class.getDeclaredMethod("isNullable", Integer.TYPE);
         methodObject29993 = ParameterMetaData.class.getDeclaredMethod("getParameterClassName", Integer.TYPE);
         methodObject29995 = ParameterMetaData.class.getDeclaredMethod("getParameterCount");
         methodObject29999 = ParameterMetaData.class.getDeclaredMethod("getScale", Integer.TYPE);
         methodObject29996 = ParameterMetaData.class.getDeclaredMethod("getParameterMode", Integer.TYPE);
         methodObject29994 = ParameterMetaData.class.getDeclaredMethod("getPrecision", Integer.TYPE);
         methodObject30003 = Wrapper.class.getDeclaredMethod("isWrapperFor", Class.class);
         methodObject30002 = Wrapper.class.getDeclaredMethod("unwrap", Class.class);
         methodObject29998 = ParameterMetaData.class.getDeclaredMethod("getParameterTypeName", Integer.TYPE);
         methodObject30001 = ParameterMetaData.class.getDeclaredMethod("isSigned", Integer.TYPE);
      } catch (Throwable var1) {
         throw new RuntimeException(var1);
      }
   }

   public oracle$1jdbc$1replay$1driver$1NonTxnReplayableBase$2oracle$1jdbc$1OracleParameterMetaData$$$Proxy(OracleParameterMetaData var1, Object var2, ProxyFactory var3, Map var4) {
      this.delegate = var1;
      this.creator = var2;
      this.proxyFactory = var3;
      this.proxyCache = var4;
   }
}
