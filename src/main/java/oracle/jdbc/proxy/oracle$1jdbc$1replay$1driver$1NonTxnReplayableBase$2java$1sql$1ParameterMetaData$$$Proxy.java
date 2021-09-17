package oracle.jdbc.proxy;

import java.lang.reflect.Method;
import java.sql.ParameterMetaData;
import java.sql.SQLException;
import java.sql.Wrapper;
import java.util.Map;
import oracle.jdbc.replay.driver.NonTxnReplayableBase;

public abstract class oracle$1jdbc$1replay$1driver$1NonTxnReplayableBase$2java$1sql$1ParameterMetaData$$$Proxy extends NonTxnReplayableBase implements ParameterMetaData, _Proxy_ {
   private ParameterMetaData delegate;
   private final Object creator;
   private final ProxyFactory proxyFactory;
   private final Map proxyCache;
   private static Object[] zeroLengthObjectArray = new Object[0];
   private static Method methodObject29745;
   private static Method methodObject29748;
   private static Method methodObject29741;
   private static Method methodObject29743;
   private static Method methodObject29747;
   private static Method methodObject29744;
   private static Method methodObject29742;
   private static Method methodObject29751;
   private static Method methodObject29750;
   private static Method methodObject29746;
   private static Method methodObject29749;

   public int getParameterType(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject29745, this, arg0);
         return (Integer)this.postForAll(methodObject29745, this.delegate.getParameterType(arg0));
      } catch (SQLException var3) {
         return (Integer)this.postForAll(methodObject29745, this.onErrorForAll(methodObject29745, var3));
      }
   }

   public int isNullable(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject29748, this, arg0);
         return (Integer)this.postForAll(methodObject29748, this.delegate.isNullable(arg0));
      } catch (SQLException var3) {
         return (Integer)this.postForAll(methodObject29748, this.onErrorForAll(methodObject29748, var3));
      }
   }

   public String getParameterClassName(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject29741, this, arg0);
         return (String)this.postForAll(methodObject29741, (Object)this.delegate.getParameterClassName(arg0));
      } catch (SQLException var3) {
         return (String)this.postForAll(methodObject29741, this.onErrorForAll(methodObject29741, var3));
      }
   }

   public int getParameterCount() throws SQLException {
      try {
         super.preForAll(methodObject29743, this, zeroLengthObjectArray);
         return (Integer)this.postForAll(methodObject29743, this.delegate.getParameterCount());
      } catch (SQLException var2) {
         return (Integer)this.postForAll(methodObject29743, this.onErrorForAll(methodObject29743, var2));
      }
   }

   public int getScale(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject29747, this, arg0);
         return (Integer)this.postForAll(methodObject29747, this.delegate.getScale(arg0));
      } catch (SQLException var3) {
         return (Integer)this.postForAll(methodObject29747, this.onErrorForAll(methodObject29747, var3));
      }
   }

   public int getParameterMode(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject29744, this, arg0);
         return (Integer)this.postForAll(methodObject29744, this.delegate.getParameterMode(arg0));
      } catch (SQLException var3) {
         return (Integer)this.postForAll(methodObject29744, this.onErrorForAll(methodObject29744, var3));
      }
   }

   public int getPrecision(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject29742, this, arg0);
         return (Integer)this.postForAll(methodObject29742, this.delegate.getPrecision(arg0));
      } catch (SQLException var3) {
         return (Integer)this.postForAll(methodObject29742, this.onErrorForAll(methodObject29742, var3));
      }
   }

   public boolean isWrapperFor(Class arg0) throws SQLException {
      try {
         super.preForAll(methodObject29751, this, arg0);
         return (Boolean)this.postForAll(methodObject29751, this.delegate.isWrapperFor(arg0));
      } catch (SQLException var3) {
         return (Boolean)this.postForAll(methodObject29751, this.onErrorForAll(methodObject29751, var3));
      }
   }

   public Object unwrap(Class arg0) throws SQLException {
      try {
         super.preForAll(methodObject29750, this, arg0);
         return this.postForAll(methodObject29750, this.proxyFactory.proxyForCache(this.delegate.unwrap(arg0), this, this.proxyCache, methodObject29750));
      } catch (SQLException var3) {
         return this.postForAll(methodObject29750, this.onErrorForAll(methodObject29750, var3));
      }
   }

   public String getParameterTypeName(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject29746, this, arg0);
         return (String)this.postForAll(methodObject29746, (Object)this.delegate.getParameterTypeName(arg0));
      } catch (SQLException var3) {
         return (String)this.postForAll(methodObject29746, this.onErrorForAll(methodObject29746, var3));
      }
   }

   public boolean isSigned(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject29749, this, arg0);
         return (Boolean)this.postForAll(methodObject29749, this.delegate.isSigned(arg0));
      } catch (SQLException var3) {
         return (Boolean)this.postForAll(methodObject29749, this.onErrorForAll(methodObject29749, var3));
      }
   }

   public ParameterMetaData _getDelegate_() {
      return this.delegate;
   }

   public Object getDelegate() {
      return this.delegate;
   }

   public void setDelegate(Object delegate) {
      this.proxyFactory.updateDelegate(this, this.delegate, delegate);
      this.delegate = (ParameterMetaData)delegate;
   }

   public Object getCreator() {
      return this.creator;
   }

   static {
      try {
         methodObject29745 = ParameterMetaData.class.getDeclaredMethod("getParameterType", Integer.TYPE);
         methodObject29748 = ParameterMetaData.class.getDeclaredMethod("isNullable", Integer.TYPE);
         methodObject29741 = ParameterMetaData.class.getDeclaredMethod("getParameterClassName", Integer.TYPE);
         methodObject29743 = ParameterMetaData.class.getDeclaredMethod("getParameterCount");
         methodObject29747 = ParameterMetaData.class.getDeclaredMethod("getScale", Integer.TYPE);
         methodObject29744 = ParameterMetaData.class.getDeclaredMethod("getParameterMode", Integer.TYPE);
         methodObject29742 = ParameterMetaData.class.getDeclaredMethod("getPrecision", Integer.TYPE);
         methodObject29751 = Wrapper.class.getDeclaredMethod("isWrapperFor", Class.class);
         methodObject29750 = Wrapper.class.getDeclaredMethod("unwrap", Class.class);
         methodObject29746 = ParameterMetaData.class.getDeclaredMethod("getParameterTypeName", Integer.TYPE);
         methodObject29749 = ParameterMetaData.class.getDeclaredMethod("isSigned", Integer.TYPE);
      } catch (Throwable var1) {
         throw new RuntimeException(var1);
      }
   }

   public oracle$1jdbc$1replay$1driver$1NonTxnReplayableBase$2java$1sql$1ParameterMetaData$$$Proxy(ParameterMetaData var1, Object var2, ProxyFactory var3, Map var4) {
      this.delegate = var1;
      this.creator = var2;
      this.proxyFactory = var3;
      this.proxyCache = var4;
   }
}
