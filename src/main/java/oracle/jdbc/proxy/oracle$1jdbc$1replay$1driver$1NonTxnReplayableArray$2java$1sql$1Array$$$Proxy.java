package oracle.jdbc.proxy;

import java.lang.reflect.Method;
import java.sql.Array;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;
import oracle.jdbc.replay.driver.NonTxnReplayableArray;

public abstract class oracle$1jdbc$1replay$1driver$1NonTxnReplayableArray$2java$1sql$1Array$$$Proxy extends NonTxnReplayableArray implements Array, _Proxy_ {
   private Array delegate;
   private final Object creator;
   private final ProxyFactory proxyFactory;
   private final Map proxyCache;
   private static Object[] zeroLengthObjectArray = new Object[0];
   private static Method methodObject13099;
   private static Method methodObject13092;
   private static Method methodObject13098;
   private static Method methodObject13093;
   private static Method methodObject13096;
   private static Method methodObject13089;
   private static Method methodObject13091;
   private static Method methodObject13094;
   private static Method methodObject13090;
   private static Method methodObject13097;
   private static Method methodObject13095;

   public String getBaseTypeName() throws SQLException {
      try {
         super.preForAll(methodObject13099, this, zeroLengthObjectArray);
         return (String)this.postForAll(methodObject13099, (Object)this.delegate.getBaseTypeName());
      } catch (SQLException var2) {
         return (String)this.postForAll(methodObject13099, this.onErrorForAll(methodObject13099, var2));
      }
   }

   public Object getArray(long arg0, int arg1, Map arg2) throws SQLException {
      try {
         super.preForAll(methodObject13092, this, arg0, arg1, arg2);
         return this.postForAll(methodObject13092, this.proxyFactory.proxyForCache(this.delegate.getArray(arg0, arg1, arg2), this, this.proxyCache, methodObject13092));
      } catch (SQLException var6) {
         return this.postForAll(methodObject13092, this.onErrorForAll(methodObject13092, var6));
      }
   }

   public ResultSet getResultSet(long arg0, int arg1, Map arg2) throws SQLException {
      try {
         super.preForAll(methodObject13098, this, arg0, arg1, arg2);
         return (ResultSet)this.postForAll(methodObject13098, this.proxyFactory.proxyForCreate((Object)this.delegate.getResultSet(arg0, arg1, arg2), this, this.proxyCache, methodObject13098));
      } catch (SQLException var6) {
         return (ResultSet)this.postForAll(methodObject13098, this.onErrorForAll(methodObject13098, var6));
      }
   }

   public void free() throws SQLException {
      try {
         super.preForAll(methodObject13093, this, zeroLengthObjectArray);
         this.delegate.free();
      } catch (SQLException var2) {
         this.onErrorVoidForAll(methodObject13093, var2);
      }
   }

   public ResultSet getResultSet(Map arg0) throws SQLException {
      try {
         super.preForAll(methodObject13096, this, arg0);
         return (ResultSet)this.postForAll(methodObject13096, this.proxyFactory.proxyForCreate((Object)this.delegate.getResultSet(arg0), this, this.proxyCache, methodObject13096));
      } catch (SQLException var3) {
         return (ResultSet)this.postForAll(methodObject13096, this.onErrorForAll(methodObject13096, var3));
      }
   }

   public Object getArray() throws SQLException {
      try {
         super.preForAll(methodObject13089, this, zeroLengthObjectArray);
         return this.postForAll(methodObject13089, this.proxyFactory.proxyForCache(this.delegate.getArray(), this, this.proxyCache, methodObject13089));
      } catch (SQLException var2) {
         return this.postForAll(methodObject13089, this.onErrorForAll(methodObject13089, var2));
      }
   }

   public Object getArray(long arg0, int arg1) throws SQLException {
      try {
         super.preForAll(methodObject13091, this, arg0, arg1);
         return this.postForAll(methodObject13091, this.proxyFactory.proxyForCache(this.delegate.getArray(arg0, arg1), this, this.proxyCache, methodObject13091));
      } catch (SQLException var5) {
         return this.postForAll(methodObject13091, this.onErrorForAll(methodObject13091, var5));
      }
   }

   public int getBaseType() throws SQLException {
      try {
         super.preForAll(methodObject13094, this, zeroLengthObjectArray);
         return (Integer)this.postForAll(methodObject13094, this.delegate.getBaseType());
      } catch (SQLException var2) {
         return (Integer)this.postForAll(methodObject13094, this.onErrorForAll(methodObject13094, var2));
      }
   }

   public Object getArray(Map arg0) throws SQLException {
      try {
         super.preForAll(methodObject13090, this, arg0);
         return this.postForAll(methodObject13090, this.proxyFactory.proxyForCache(this.delegate.getArray(arg0), this, this.proxyCache, methodObject13090));
      } catch (SQLException var3) {
         return this.postForAll(methodObject13090, this.onErrorForAll(methodObject13090, var3));
      }
   }

   public ResultSet getResultSet(long arg0, int arg1) throws SQLException {
      try {
         super.preForAll(methodObject13097, this, arg0, arg1);
         return (ResultSet)this.postForAll(methodObject13097, this.proxyFactory.proxyForCreate((Object)this.delegate.getResultSet(arg0, arg1), this, this.proxyCache, methodObject13097));
      } catch (SQLException var5) {
         return (ResultSet)this.postForAll(methodObject13097, this.onErrorForAll(methodObject13097, var5));
      }
   }

   public ResultSet getResultSet() throws SQLException {
      try {
         super.preForAll(methodObject13095, this, zeroLengthObjectArray);
         return (ResultSet)this.postForAll(methodObject13095, this.proxyFactory.proxyForCreate((Object)this.delegate.getResultSet(), this, this.proxyCache, methodObject13095));
      } catch (SQLException var2) {
         return (ResultSet)this.postForAll(methodObject13095, this.onErrorForAll(methodObject13095, var2));
      }
   }

   public Array _getDelegate_() {
      return this.delegate;
   }

   public Object getDelegate() {
      return this.delegate;
   }

   public void setDelegate(Object delegate) {
      this.proxyFactory.updateDelegate(this, this.delegate, delegate);
      this.delegate = (Array)delegate;
   }

   public Object getCreator() {
      return this.creator;
   }

   static {
      try {
         methodObject13099 = Array.class.getDeclaredMethod("getBaseTypeName");
         methodObject13092 = Array.class.getDeclaredMethod("getArray", Long.TYPE, Integer.TYPE, Map.class);
         methodObject13098 = Array.class.getDeclaredMethod("getResultSet", Long.TYPE, Integer.TYPE, Map.class);
         methodObject13093 = Array.class.getDeclaredMethod("free");
         methodObject13096 = Array.class.getDeclaredMethod("getResultSet", Map.class);
         methodObject13089 = Array.class.getDeclaredMethod("getArray");
         methodObject13091 = Array.class.getDeclaredMethod("getArray", Long.TYPE, Integer.TYPE);
         methodObject13094 = Array.class.getDeclaredMethod("getBaseType");
         methodObject13090 = Array.class.getDeclaredMethod("getArray", Map.class);
         methodObject13097 = Array.class.getDeclaredMethod("getResultSet", Long.TYPE, Integer.TYPE);
         methodObject13095 = Array.class.getDeclaredMethod("getResultSet");
      } catch (Throwable var1) {
         throw new RuntimeException(var1);
      }
   }

   public oracle$1jdbc$1replay$1driver$1NonTxnReplayableArray$2java$1sql$1Array$$$Proxy(Array var1, Object var2, ProxyFactory var3, Map var4) {
      this.delegate = var1;
      this.creator = var2;
      this.proxyFactory = var3;
      this.proxyCache = var4;
   }
}
