package oracle.jdbc.proxy;

import java.lang.reflect.Method;
import java.sql.Array;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;
import oracle.jdbc.OracleArray;
import oracle.jdbc.OracleTypeMetaData;
import oracle.jdbc.replay.driver.NonTxnReplayableArray;

public abstract class oracle$1jdbc$1replay$1driver$1NonTxnReplayableArray$2oracle$1jdbc$1OracleArray$$$Proxy extends NonTxnReplayableArray implements OracleArray, _Proxy_ {
   private OracleArray delegate;
   private final Object creator;
   private final ProxyFactory proxyFactory;
   private final Map proxyCache;
   private static Object[] zeroLengthObjectArray = new Object[0];
   private static Method methodObject13100;
   private static Method methodObject13114;
   private static Method methodObject13111;
   private static Method methodObject13105;
   private static Method methodObject13112;
   private static Method methodObject13107;
   private static Method methodObject13102;
   private static Method methodObject13121;
   private static Method methodObject13104;
   private static Method methodObject13116;
   private static Method methodObject13119;
   private static Method methodObject13106;
   private static Method methodObject13122;
   private static Method methodObject13101;
   private static Method methodObject13117;
   private static Method methodObject13124;
   private static Method methodObject13118;
   private static Method methodObject13110;
   private static Method methodObject13109;
   private static Method methodObject13108;
   private static Method methodObject13103;
   private static Method methodObject13123;
   private static Method methodObject13113;
   private static Method methodObject13115;
   private static Method methodObject13120;

   public int length() throws SQLException {
      try {
         super.preForAll(methodObject13100, this, zeroLengthObjectArray);
         return (Integer)this.postForAll(methodObject13100, this.delegate.length());
      } catch (SQLException var2) {
         return (Integer)this.postForAll(methodObject13100, this.onErrorForAll(methodObject13100, var2));
      }
   }

   public Object getArray() throws SQLException {
      try {
         super.preForAll(methodObject13114, this, zeroLengthObjectArray);
         return this.postForAll(methodObject13114, this.proxyFactory.proxyForCache(this.delegate.getArray(), this, this.proxyCache, methodObject13114));
      } catch (SQLException var2) {
         return this.postForAll(methodObject13114, this.onErrorForAll(methodObject13114, var2));
      }
   }

   public long[] getLongArray(long arg0, int arg1) throws SQLException {
      try {
         super.preForAll(methodObject13111, this, arg0, arg1);
         return (long[])this.postForAll(methodObject13111, (Object)this.delegate.getLongArray(arg0, arg1));
      } catch (SQLException var5) {
         return (long[])this.postForAll(methodObject13111, this.onErrorForAll(methodObject13111, var5));
      }
   }

   public int[] getIntArray(long arg0, int arg1) throws SQLException {
      try {
         super.preForAll(methodObject13105, this, arg0, arg1);
         return (int[])this.postForAll(methodObject13105, (Object)this.delegate.getIntArray(arg0, arg1));
      } catch (SQLException var5) {
         return (int[])this.postForAll(methodObject13105, this.onErrorForAll(methodObject13105, var5));
      }
   }

   public float[] getFloatArray() throws SQLException {
      try {
         super.preForAll(methodObject13112, this, zeroLengthObjectArray);
         return (float[])this.postForAll(methodObject13112, (Object)this.delegate.getFloatArray());
      } catch (SQLException var2) {
         return (float[])this.postForAll(methodObject13112, this.onErrorForAll(methodObject13112, var2));
      }
   }

   public double[] getDoubleArray(long arg0, int arg1) throws SQLException {
      try {
         super.preForAll(methodObject13107, this, arg0, arg1);
         return (double[])this.postForAll(methodObject13107, (Object)this.delegate.getDoubleArray(arg0, arg1));
      } catch (SQLException var5) {
         return (double[])this.postForAll(methodObject13107, this.onErrorForAll(methodObject13107, var5));
      }
   }

   public String getSQLTypeName() throws SQLException {
      try {
         super.preForAll(methodObject13102, this, zeroLengthObjectArray);
         return (String)this.postForAll(methodObject13102, (Object)this.delegate.getSQLTypeName());
      } catch (SQLException var2) {
         return (String)this.postForAll(methodObject13102, this.onErrorForAll(methodObject13102, var2));
      }
   }

   public ResultSet getResultSet(Map arg0) throws SQLException {
      try {
         super.preForAll(methodObject13121, this, arg0);
         return (ResultSet)this.postForAll(methodObject13121, this.proxyFactory.proxyForCreate((Object)this.delegate.getResultSet(arg0), this, this.proxyCache, methodObject13121));
      } catch (SQLException var3) {
         return (ResultSet)this.postForAll(methodObject13121, this.onErrorForAll(methodObject13121, var3));
      }
   }

   public int[] getIntArray() throws SQLException {
      try {
         super.preForAll(methodObject13104, this, zeroLengthObjectArray);
         return (int[])this.postForAll(methodObject13104, (Object)this.delegate.getIntArray());
      } catch (SQLException var2) {
         return (int[])this.postForAll(methodObject13104, this.onErrorForAll(methodObject13104, var2));
      }
   }

   public Object getArray(long arg0, int arg1) throws SQLException {
      try {
         super.preForAll(methodObject13116, this, arg0, arg1);
         return this.postForAll(methodObject13116, this.proxyFactory.proxyForCache(this.delegate.getArray(arg0, arg1), this, this.proxyCache, methodObject13116));
      } catch (SQLException var5) {
         return this.postForAll(methodObject13116, this.onErrorForAll(methodObject13116, var5));
      }
   }

   public int getBaseType() throws SQLException {
      try {
         super.preForAll(methodObject13119, this, zeroLengthObjectArray);
         return (Integer)this.postForAll(methodObject13119, this.delegate.getBaseType());
      } catch (SQLException var2) {
         return (Integer)this.postForAll(methodObject13119, this.onErrorForAll(methodObject13119, var2));
      }
   }

   public double[] getDoubleArray() throws SQLException {
      try {
         super.preForAll(methodObject13106, this, zeroLengthObjectArray);
         return (double[])this.postForAll(methodObject13106, (Object)this.delegate.getDoubleArray());
      } catch (SQLException var2) {
         return (double[])this.postForAll(methodObject13106, this.onErrorForAll(methodObject13106, var2));
      }
   }

   public ResultSet getResultSet(long arg0, int arg1) throws SQLException {
      try {
         super.preForAll(methodObject13122, this, arg0, arg1);
         return (ResultSet)this.postForAll(methodObject13122, this.proxyFactory.proxyForCreate((Object)this.delegate.getResultSet(arg0, arg1), this, this.proxyCache, methodObject13122));
      } catch (SQLException var5) {
         return (ResultSet)this.postForAll(methodObject13122, this.onErrorForAll(methodObject13122, var5));
      }
   }

   public Object toJdbc() throws SQLException {
      try {
         super.preForAll(methodObject13101, this, zeroLengthObjectArray);
         return this.postForAll(methodObject13101, this.proxyFactory.proxyForCache(this.delegate.toJdbc(), this, this.proxyCache, methodObject13101));
      } catch (SQLException var2) {
         return this.postForAll(methodObject13101, this.onErrorForAll(methodObject13101, var2));
      }
   }

   public Object getArray(long arg0, int arg1, Map arg2) throws SQLException {
      try {
         super.preForAll(methodObject13117, this, arg0, arg1, arg2);
         return this.postForAll(methodObject13117, this.proxyFactory.proxyForCache(this.delegate.getArray(arg0, arg1, arg2), this, this.proxyCache, methodObject13117));
      } catch (SQLException var6) {
         return this.postForAll(methodObject13117, this.onErrorForAll(methodObject13117, var6));
      }
   }

   public String getBaseTypeName() throws SQLException {
      try {
         super.preForAll(methodObject13124, this, zeroLengthObjectArray);
         return (String)this.postForAll(methodObject13124, (Object)this.delegate.getBaseTypeName());
      } catch (SQLException var2) {
         return (String)this.postForAll(methodObject13124, this.onErrorForAll(methodObject13124, var2));
      }
   }

   public void free() throws SQLException {
      try {
         super.preForAll(methodObject13118, this, zeroLengthObjectArray);
         this.delegate.free();
      } catch (SQLException var2) {
         this.onErrorVoidForAll(methodObject13118, var2);
      }
   }

   public long[] getLongArray() throws SQLException {
      try {
         super.preForAll(methodObject13110, this, zeroLengthObjectArray);
         return (long[])this.postForAll(methodObject13110, (Object)this.delegate.getLongArray());
      } catch (SQLException var2) {
         return (long[])this.postForAll(methodObject13110, this.onErrorForAll(methodObject13110, var2));
      }
   }

   public short[] getShortArray(long arg0, int arg1) throws SQLException {
      try {
         super.preForAll(methodObject13109, this, arg0, arg1);
         return (short[])this.postForAll(methodObject13109, (Object)this.delegate.getShortArray(arg0, arg1));
      } catch (SQLException var5) {
         return (short[])this.postForAll(methodObject13109, this.onErrorForAll(methodObject13109, var5));
      }
   }

   public short[] getShortArray() throws SQLException {
      try {
         super.preForAll(methodObject13108, this, zeroLengthObjectArray);
         return (short[])this.postForAll(methodObject13108, (Object)this.delegate.getShortArray());
      } catch (SQLException var2) {
         return (short[])this.postForAll(methodObject13108, this.onErrorForAll(methodObject13108, var2));
      }
   }

   public OracleTypeMetaData getOracleMetaData() throws SQLException {
      try {
         super.preForAll(methodObject13103, this, zeroLengthObjectArray);
         return (OracleTypeMetaData)this.postForAll(methodObject13103, this.proxyFactory.proxyForCache((Object)this.delegate.getOracleMetaData(), this, this.proxyCache, methodObject13103));
      } catch (SQLException var2) {
         return (OracleTypeMetaData)this.postForAll(methodObject13103, this.onErrorForAll(methodObject13103, var2));
      }
   }

   public ResultSet getResultSet(long arg0, int arg1, Map arg2) throws SQLException {
      try {
         super.preForAll(methodObject13123, this, arg0, arg1, arg2);
         return (ResultSet)this.postForAll(methodObject13123, this.proxyFactory.proxyForCreate((Object)this.delegate.getResultSet(arg0, arg1, arg2), this, this.proxyCache, methodObject13123));
      } catch (SQLException var6) {
         return (ResultSet)this.postForAll(methodObject13123, this.onErrorForAll(methodObject13123, var6));
      }
   }

   public float[] getFloatArray(long arg0, int arg1) throws SQLException {
      try {
         super.preForAll(methodObject13113, this, arg0, arg1);
         return (float[])this.postForAll(methodObject13113, (Object)this.delegate.getFloatArray(arg0, arg1));
      } catch (SQLException var5) {
         return (float[])this.postForAll(methodObject13113, this.onErrorForAll(methodObject13113, var5));
      }
   }

   public Object getArray(Map arg0) throws SQLException {
      try {
         super.preForAll(methodObject13115, this, arg0);
         return this.postForAll(methodObject13115, this.proxyFactory.proxyForCache(this.delegate.getArray(arg0), this, this.proxyCache, methodObject13115));
      } catch (SQLException var3) {
         return this.postForAll(methodObject13115, this.onErrorForAll(methodObject13115, var3));
      }
   }

   public ResultSet getResultSet() throws SQLException {
      try {
         super.preForAll(methodObject13120, this, zeroLengthObjectArray);
         return (ResultSet)this.postForAll(methodObject13120, this.proxyFactory.proxyForCreate((Object)this.delegate.getResultSet(), this, this.proxyCache, methodObject13120));
      } catch (SQLException var2) {
         return (ResultSet)this.postForAll(methodObject13120, this.onErrorForAll(methodObject13120, var2));
      }
   }

   public OracleArray _getDelegate_() {
      return this.delegate;
   }

   public Object getDelegate() {
      return this.delegate;
   }

   public void setDelegate(Object delegate) {
      this.proxyFactory.updateDelegate(this, this.delegate, delegate);
      this.delegate = (OracleArray)delegate;
   }

   public Object getCreator() {
      return this.creator;
   }

   static {
      try {
         methodObject13100 = OracleArray.class.getDeclaredMethod("length");
         methodObject13114 = Array.class.getDeclaredMethod("getArray");
         methodObject13111 = OracleArray.class.getDeclaredMethod("getLongArray", Long.TYPE, Integer.TYPE);
         methodObject13105 = OracleArray.class.getDeclaredMethod("getIntArray", Long.TYPE, Integer.TYPE);
         methodObject13112 = OracleArray.class.getDeclaredMethod("getFloatArray");
         methodObject13107 = OracleArray.class.getDeclaredMethod("getDoubleArray", Long.TYPE, Integer.TYPE);
         methodObject13102 = OracleArray.class.getDeclaredMethod("getSQLTypeName");
         methodObject13121 = Array.class.getDeclaredMethod("getResultSet", Map.class);
         methodObject13104 = OracleArray.class.getDeclaredMethod("getIntArray");
         methodObject13116 = Array.class.getDeclaredMethod("getArray", Long.TYPE, Integer.TYPE);
         methodObject13119 = Array.class.getDeclaredMethod("getBaseType");
         methodObject13106 = OracleArray.class.getDeclaredMethod("getDoubleArray");
         methodObject13122 = Array.class.getDeclaredMethod("getResultSet", Long.TYPE, Integer.TYPE);
         methodObject13101 = OracleArray.class.getDeclaredMethod("toJdbc");
         methodObject13117 = Array.class.getDeclaredMethod("getArray", Long.TYPE, Integer.TYPE, Map.class);
         methodObject13124 = Array.class.getDeclaredMethod("getBaseTypeName");
         methodObject13118 = Array.class.getDeclaredMethod("free");
         methodObject13110 = OracleArray.class.getDeclaredMethod("getLongArray");
         methodObject13109 = OracleArray.class.getDeclaredMethod("getShortArray", Long.TYPE, Integer.TYPE);
         methodObject13108 = OracleArray.class.getDeclaredMethod("getShortArray");
         methodObject13103 = OracleArray.class.getDeclaredMethod("getOracleMetaData");
         methodObject13123 = Array.class.getDeclaredMethod("getResultSet", Long.TYPE, Integer.TYPE, Map.class);
         methodObject13113 = OracleArray.class.getDeclaredMethod("getFloatArray", Long.TYPE, Integer.TYPE);
         methodObject13115 = Array.class.getDeclaredMethod("getArray", Map.class);
         methodObject13120 = Array.class.getDeclaredMethod("getResultSet");
      } catch (Throwable var1) {
         throw new RuntimeException(var1);
      }
   }

   public oracle$1jdbc$1replay$1driver$1NonTxnReplayableArray$2oracle$1jdbc$1OracleArray$$$Proxy(OracleArray var1, Object var2, ProxyFactory var3, Map var4) {
      this.delegate = var1;
      this.creator = var2;
      this.proxyFactory = var3;
      this.proxyCache = var4;
   }
}
