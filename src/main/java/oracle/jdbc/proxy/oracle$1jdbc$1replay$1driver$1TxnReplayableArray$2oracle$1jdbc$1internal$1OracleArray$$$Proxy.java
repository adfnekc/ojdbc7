package oracle.jdbc.proxy;

import java.io.InputStream;
import java.io.Reader;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.sql.Array;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Map;
import oracle.jdbc.OracleTypeMetaData;
import oracle.jdbc.internal.ACProxyable;
import oracle.jdbc.internal.OracleArray;
import oracle.jdbc.internal.OracleConnection;
import oracle.jdbc.internal.OracleDatumWithConnection;
import oracle.jdbc.replay.driver.TxnReplayableArray;
import oracle.sql.ArrayDescriptor;
import oracle.sql.Datum;

public abstract class oracle$1jdbc$1replay$1driver$1TxnReplayableArray$2oracle$1jdbc$1internal$1OracleArray$$$Proxy extends TxnReplayableArray implements OracleArray, _Proxy_ {
   private OracleArray delegate;
   private final Object creator;
   private final ProxyFactory proxyFactory;
   private final Map proxyCache;
   private static Object[] zeroLengthObjectArray = new Object[0];
   private static Method methodObject2892;
   private static Method methodObject2856;
   private static Method methodObject2857;
   private static Method methodObject2842;
   private static Method methodObject2870;
   private static Method methodObject2843;
   private static Method methodObject2897;
   private static Method methodObject2912;
   private static Method methodObject2869;
   private static Method methodObject2872;
   private static Method methodObject2905;
   private static Method methodObject2841;
   private static Method methodObject2902;
   private static Method methodObject2852;
   private static Method methodObject2907;
   private static Method methodObject2904;
   private static Method methodObject2844;
   private static Method methodObject2883;
   private static Method methodObject2924;
   private static Method methodObject2874;
   private static Method methodObject2906;
   private static Method methodObject2891;
   private static Method methodObject2862;
   private static Method methodObject2882;
   private static Method methodObject2923;
   private static Method methodObject2884;
   private static Method methodObject2864;
   private static Method methodObject2886;
   private static Method methodObject2910;
   private static Method methodObject2879;
   private static Method methodObject2877;
   private static Method methodObject2853;
   private static Method methodObject2917;
   private static Method methodObject2854;
   private static Method methodObject2859;
   private static Method methodObject2866;
   private static Method methodObject2908;
   private static Method methodObject2849;
   private static Method methodObject2875;
   private static Method methodObject2851;
   private static Method methodObject2922;
   private static Method methodObject2920;
   private static Method methodObject2915;
   private static Method methodObject2916;
   private static Method methodObject2900;
   private static Method methodObject2895;
   private static Method methodObject2840;
   private static Method methodObject2889;
   private static Method methodObject2846;
   private static Method methodObject2914;
   private static Method methodObject2868;
   private static Method methodObject2847;
   private static Method methodObject2845;
   private static Method methodObject2878;
   private static Method methodObject2921;
   private static Method methodObject2865;
   private static Method methodObject2858;
   private static Method methodObject2887;
   private static Method methodObject2863;
   private static Method methodObject2925;
   private static Method methodObject2926;
   private static Method methodObject2898;
   private static Method methodObject2913;
   private static Method methodObject2901;
   private static Method methodObject2918;
   private static Method methodObject2855;
   private static Method methodObject2867;
   private static Method methodObject2850;
   private static Method methodObject2894;
   private static Method methodObject2893;
   private static Method methodObject2880;
   private static Method methodObject2860;
   private static Method methodObject2903;
   private static Method methodObject2911;
   private static Method methodObject2873;
   private static Method methodObject2909;
   private static Method methodObject2861;
   private static Method methodObject2876;
   private static Method methodObject2885;
   private static Method methodObject2890;
   private static Method methodObject2848;
   private static Method methodObject2871;
   private static Method methodObject2881;
   private static Method methodObject2919;
   private static Method methodObject2899;
   private static Method methodObject2896;

   public String stringValue(Connection arg0) throws SQLException {
      try {
         super.preForAll(methodObject2892, this, arg0);
         return (String)this.postForAll(methodObject2892, (Object)this.delegate.stringValue(arg0 instanceof _Proxy_ ? (Connection)((_Proxy_)arg0)._getDelegate_() : arg0));
      } catch (SQLException var3) {
         return (String)this.postForAll(methodObject2892, this.onErrorForAll(methodObject2892, var3));
      }
   }

   public boolean isInline() {
      super.preForAll(methodObject2856, this, zeroLengthObjectArray);
      return (Boolean)this.postForAll(methodObject2856, this.delegate.isInline());
   }

   public void setAutoBuffering(boolean arg0) throws SQLException {
      try {
         super.preForAll(methodObject2857, this, arg0);
         Method var10001 = methodObject2857;
         this.delegate.setAutoBuffering(arg0);
         this.postForAll(var10001);
      } catch (SQLException var3) {
         this.onErrorVoidForAll(methodObject2857, var3);
      }
   }

   public void setLength(int arg0) {
      super.preForAll(methodObject2842, this, arg0);
      Method var10001 = methodObject2842;
      this.delegate.setLength(arg0);
      this.postForAll(var10001);
   }

   public long getImageLength() {
      super.preForAll(methodObject2870, this, zeroLengthObjectArray);
      return (Long)this.postForAll(methodObject2870, this.delegate.getImageLength());
   }

   public long getOffset(long arg0) throws SQLException {
      try {
         super.preForAll(methodObject2843, this, arg0);
         return (Long)this.postForAll(methodObject2843, this.delegate.getOffset(arg0));
      } catch (SQLException var4) {
         return (Long)this.postForAll(methodObject2843, this.onErrorForAll(methodObject2843, var4));
      }
   }

   public Connection getJavaSqlConnection() throws SQLException {
      try {
         super.preForAll(methodObject2897, this, zeroLengthObjectArray);
         return (Connection)this.postForAll(methodObject2897, this.proxyFactory.proxyForCache((Object)this.delegate.getJavaSqlConnection(), this, this.proxyCache, methodObject2897));
      } catch (SQLException var2) {
         return (Connection)this.postForAll(methodObject2897, this.onErrorForAll(methodObject2897, var2));
      }
   }

   public float[] getFloatArray() throws SQLException {
      try {
         super.preForAll(methodObject2912, this, zeroLengthObjectArray);
         return (float[])this.postForAll(methodObject2912, (Object)this.delegate.getFloatArray());
      } catch (SQLException var2) {
         return (float[])this.postForAll(methodObject2912, this.onErrorForAll(methodObject2912, var2));
      }
   }

   public long getImageOffset() {
      super.preForAll(methodObject2869, this, zeroLengthObjectArray);
      return (Long)this.postForAll(methodObject2869, this.delegate.getImageOffset());
   }

   public boolean booleanValue() throws SQLException {
      try {
         super.preForAll(methodObject2872, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject2872, this.delegate.booleanValue());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject2872, this.onErrorForAll(methodObject2872, var2));
      }
   }

   public int[] getIntArray(long arg0, int arg1) throws SQLException {
      try {
         super.preForAll(methodObject2905, this, arg0, arg1);
         return (int[])this.postForAll(methodObject2905, (Object)this.delegate.getIntArray(arg0, arg1));
      } catch (SQLException var5) {
         return (int[])this.postForAll(methodObject2905, this.onErrorForAll(methodObject2905, var5));
      }
   }

   public boolean isConvertibleTo(Class arg0) {
      super.preForAll(methodObject2841, this, arg0);
      return (Boolean)this.postForAll(methodObject2841, this.delegate.isConvertibleTo(arg0));
   }

   public String getSQLTypeName() throws SQLException {
      try {
         super.preForAll(methodObject2902, this, zeroLengthObjectArray);
         return (String)this.postForAll(methodObject2902, (Object)this.delegate.getSQLTypeName());
      } catch (SQLException var2) {
         return (String)this.postForAll(methodObject2902, this.onErrorForAll(methodObject2902, var2));
      }
   }

   public void setPrefixSegment(byte[] arg0) {
      super.preForAll(methodObject2852, this, arg0);
      Method var10001 = methodObject2852;
      this.delegate.setPrefixSegment(arg0);
      this.postForAll(var10001);
   }

   public double[] getDoubleArray(long arg0, int arg1) throws SQLException {
      try {
         super.preForAll(methodObject2907, this, arg0, arg1);
         return (double[])this.postForAll(methodObject2907, (Object)this.delegate.getDoubleArray(arg0, arg1));
      } catch (SQLException var5) {
         return (double[])this.postForAll(methodObject2907, this.onErrorForAll(methodObject2907, var5));
      }
   }

   public int[] getIntArray() throws SQLException {
      try {
         super.preForAll(methodObject2904, this, zeroLengthObjectArray);
         return (int[])this.postForAll(methodObject2904, (Object)this.delegate.getIntArray());
      } catch (SQLException var2) {
         return (int[])this.postForAll(methodObject2904, this.onErrorForAll(methodObject2904, var2));
      }
   }

   public Map getMap() throws SQLException {
      try {
         super.preForAll(methodObject2844, this, zeroLengthObjectArray);
         return (Map)this.postForAll(methodObject2844, (Object)this.delegate.getMap());
      } catch (SQLException var2) {
         return (Map)this.postForAll(methodObject2844, this.onErrorForAll(methodObject2844, var2));
      }
   }

   public Timestamp timestampValue() throws SQLException {
      try {
         super.preForAll(methodObject2883, this, zeroLengthObjectArray);
         return (Timestamp)this.postForAll(methodObject2883, (Object)this.delegate.timestampValue());
      } catch (SQLException var2) {
         return (Timestamp)this.postForAll(methodObject2883, this.onErrorForAll(methodObject2883, var2));
      }
   }

   public int getBaseType() throws SQLException {
      try {
         super.preForAll(methodObject2924, this, zeroLengthObjectArray);
         return (Integer)this.postForAll(methodObject2924, this.delegate.getBaseType());
      } catch (SQLException var2) {
         return (Integer)this.postForAll(methodObject2924, this.onErrorForAll(methodObject2924, var2));
      }
   }

   public int intValue() throws SQLException {
      try {
         super.preForAll(methodObject2874, this, zeroLengthObjectArray);
         return (Integer)this.postForAll(methodObject2874, this.delegate.intValue());
      } catch (SQLException var2) {
         return (Integer)this.postForAll(methodObject2874, this.onErrorForAll(methodObject2874, var2));
      }
   }

   public double[] getDoubleArray() throws SQLException {
      try {
         super.preForAll(methodObject2906, this, zeroLengthObjectArray);
         return (double[])this.postForAll(methodObject2906, (Object)this.delegate.getDoubleArray());
      } catch (SQLException var2) {
         return (double[])this.postForAll(methodObject2906, this.onErrorForAll(methodObject2906, var2));
      }
   }

   public String stringValue() throws SQLException {
      try {
         super.preForAll(methodObject2891, this, zeroLengthObjectArray);
         return (String)this.postForAll(methodObject2891, (Object)this.delegate.stringValue());
      } catch (SQLException var2) {
         return (String)this.postForAll(methodObject2891, this.onErrorForAll(methodObject2891, var2));
      }
   }

   public int getAccessDirection() throws SQLException {
      try {
         super.preForAll(methodObject2862, this, zeroLengthObjectArray);
         return (Integer)this.postForAll(methodObject2862, this.delegate.getAccessDirection());
      } catch (SQLException var2) {
         return (Integer)this.postForAll(methodObject2862, this.onErrorForAll(methodObject2862, var2));
      }
   }

   public Time timeValue(Calendar arg0) throws SQLException {
      try {
         super.preForAll(methodObject2882, this, arg0);
         return (Time)this.postForAll(methodObject2882, (Object)this.delegate.timeValue(arg0));
      } catch (SQLException var3) {
         return (Time)this.postForAll(methodObject2882, this.onErrorForAll(methodObject2882, var3));
      }
   }

   public void free() throws SQLException {
      try {
         super.preForAll(methodObject2923, this, zeroLengthObjectArray);
         Method var10001 = methodObject2923;
         this.delegate.free();
         this.postForAll(var10001);
      } catch (SQLException var2) {
         this.onErrorVoidForAll(methodObject2923, var2);
      }
   }

   public Timestamp timestampValue(Calendar arg0) throws SQLException {
      try {
         super.preForAll(methodObject2884, this, arg0);
         return (Timestamp)this.postForAll(methodObject2884, (Object)this.delegate.timestampValue(arg0));
      } catch (SQLException var3) {
         return (Timestamp)this.postForAll(methodObject2884, this.onErrorForAll(methodObject2884, var3));
      }
   }

   public void setIndexOffset(long arg0, long arg1) throws SQLException {
      try {
         super.preForAll(methodObject2864, this, arg0, arg1);
         Method var10001 = methodObject2864;
         this.delegate.setIndexOffset(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var6) {
         this.onErrorVoidForAll(methodObject2864, var6);
      }
   }

   public InputStream asciiStreamValue() throws SQLException {
      try {
         super.preForAll(methodObject2886, this, zeroLengthObjectArray);
         return (InputStream)this.postForAll(methodObject2886, (Object)this.delegate.asciiStreamValue());
      } catch (SQLException var2) {
         return (InputStream)this.postForAll(methodObject2886, this.onErrorForAll(methodObject2886, var2));
      }
   }

   public long[] getLongArray() throws SQLException {
      try {
         super.preForAll(methodObject2910, this, zeroLengthObjectArray);
         return (long[])this.postForAll(methodObject2910, (Object)this.delegate.getLongArray());
      } catch (SQLException var2) {
         return (long[])this.postForAll(methodObject2910, this.onErrorForAll(methodObject2910, var2));
      }
   }

   public byte[] shareBytes() {
      super.preForAll(methodObject2879, this, zeroLengthObjectArray);
      return (byte[])this.postForAll(methodObject2879, (Object)this.delegate.shareBytes());
   }

   public double doubleValue() throws SQLException {
      try {
         super.preForAll(methodObject2877, this, zeroLengthObjectArray);
         return (Double)this.postForAll(methodObject2877, this.delegate.doubleValue());
      } catch (SQLException var2) {
         return (Double)this.postForAll(methodObject2877, this.onErrorForAll(methodObject2877, var2));
      }
   }

   public void setPrefixFlag(byte arg0) {
      super.preForAll(methodObject2853, this, arg0);
      Method var10001 = methodObject2853;
      this.delegate.setPrefixFlag(arg0);
      this.postForAll(var10001);
   }

   public Object getArray(long arg0, int arg1, Map arg2) throws SQLException {
      try {
         super.preForAll(methodObject2917, this, arg0, arg1, arg2);
         return this.postForAll(methodObject2917, this.proxyFactory.proxyForCache(this.delegate.getArray(arg0, arg1, arg2), this, this.proxyCache, methodObject2917));
      } catch (SQLException var6) {
         return this.postForAll(methodObject2917, this.onErrorForAll(methodObject2917, var6));
      }
   }

   public byte[] getLocator() {
      super.preForAll(methodObject2854, this, zeroLengthObjectArray);
      return (byte[])this.postForAll(methodObject2854, (Object)this.delegate.getLocator());
   }

   public void setAutoIndexing(boolean arg0, int arg1) throws SQLException {
      try {
         super.preForAll(methodObject2859, this, arg0, arg1);
         Method var10001 = methodObject2859;
         this.delegate.setAutoIndexing(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject2859, var4);
      }
   }

   public long getLastOffset() throws SQLException {
      try {
         super.preForAll(methodObject2866, this, zeroLengthObjectArray);
         return (Long)this.postForAll(methodObject2866, this.delegate.getLastOffset());
      } catch (SQLException var2) {
         return (Long)this.postForAll(methodObject2866, this.onErrorForAll(methodObject2866, var2));
      }
   }

   public short[] getShortArray() throws SQLException {
      try {
         super.preForAll(methodObject2908, this, zeroLengthObjectArray);
         return (short[])this.postForAll(methodObject2908, (Object)this.delegate.getShortArray());
      } catch (SQLException var2) {
         return (short[])this.postForAll(methodObject2908, this.onErrorForAll(methodObject2908, var2));
      }
   }

   public void setDatumArray(Datum[] arg0) {
      super.preForAll(methodObject2849, this, arg0);
      Method var10001 = methodObject2849;
      this.delegate.setDatumArray(arg0);
      this.postForAll(var10001);
   }

   public long longValue() throws SQLException {
      try {
         super.preForAll(methodObject2875, this, zeroLengthObjectArray);
         return (Long)this.postForAll(methodObject2875, this.delegate.longValue());
      } catch (SQLException var2) {
         return (Long)this.postForAll(methodObject2875, this.onErrorForAll(methodObject2875, var2));
      }
   }

   public void setLocator(byte[] arg0) {
      super.preForAll(methodObject2851, this, arg0);
      Method var10001 = methodObject2851;
      this.delegate.setLocator(arg0);
      this.postForAll(var10001);
   }

   public ResultSet getResultSet(long arg0, int arg1, Map arg2) throws SQLException {
      try {
         super.preForAll(methodObject2922, this, arg0, arg1, arg2);
         return (ResultSet)this.postForAll(methodObject2922, this.proxyFactory.proxyForCache((Object)this.delegate.getResultSet(arg0, arg1, arg2), this, this.proxyCache, methodObject2922));
      } catch (SQLException var6) {
         return (ResultSet)this.postForAll(methodObject2922, this.onErrorForAll(methodObject2922, var6));
      }
   }

   public ResultSet getResultSet(Map arg0) throws SQLException {
      try {
         super.preForAll(methodObject2920, this, arg0);
         return (ResultSet)this.postForAll(methodObject2920, this.proxyFactory.proxyForCache((Object)this.delegate.getResultSet(arg0), this, this.proxyCache, methodObject2920));
      } catch (SQLException var3) {
         return (ResultSet)this.postForAll(methodObject2920, this.onErrorForAll(methodObject2920, var3));
      }
   }

   public Object getArray(Map arg0) throws SQLException {
      try {
         super.preForAll(methodObject2915, this, arg0);
         return this.postForAll(methodObject2915, this.proxyFactory.proxyForCache(this.delegate.getArray(arg0), this, this.proxyCache, methodObject2915));
      } catch (SQLException var3) {
         return this.postForAll(methodObject2915, this.onErrorForAll(methodObject2915, var3));
      }
   }

   public Object getArray(long arg0, int arg1) throws SQLException {
      try {
         super.preForAll(methodObject2916, this, arg0, arg1);
         return this.postForAll(methodObject2916, this.proxyFactory.proxyForCache(this.delegate.getArray(arg0, arg1), this, this.proxyCache, methodObject2916));
      } catch (SQLException var5) {
         return this.postForAll(methodObject2916, this.onErrorForAll(methodObject2916, var5));
      }
   }

   public int length() throws SQLException {
      try {
         super.preForAll(methodObject2900, this, zeroLengthObjectArray);
         return (Integer)this.postForAll(methodObject2900, this.delegate.length());
      } catch (SQLException var2) {
         return (Integer)this.postForAll(methodObject2900, this.onErrorForAll(methodObject2900, var2));
      }
   }

   public OracleConnection getInternalConnection() throws SQLException {
      try {
         super.preForAll(methodObject2895, this, zeroLengthObjectArray);
         return (OracleConnection)this.postForAll(methodObject2895, this.proxyFactory.proxyForCache((Object)this.delegate.getInternalConnection(), this, this.proxyCache, methodObject2895));
      } catch (SQLException var2) {
         return (OracleConnection)this.postForAll(methodObject2895, this.onErrorForAll(methodObject2895, var2));
      }
   }

   public ArrayDescriptor getDescriptor() throws SQLException {
      try {
         super.preForAll(methodObject2840, this, zeroLengthObjectArray);
         return (ArrayDescriptor)this.postForAll(methodObject2840, (Object)this.delegate.getDescriptor());
      } catch (SQLException var2) {
         return (ArrayDescriptor)this.postForAll(methodObject2840, this.onErrorForAll(methodObject2840, var2));
      }
   }

   public void setShareBytes(byte[] arg0) {
      super.preForAll(methodObject2889, this, arg0);
      Method var10001 = methodObject2889;
      this.delegate.setShareBytes(arg0);
      this.postForAll(var10001);
   }

   public Datum[] getOracleArray() throws SQLException {
      try {
         super.preForAll(methodObject2846, this, zeroLengthObjectArray);
         return (Datum[])this.postForAll(methodObject2846, (Object)this.delegate.getOracleArray());
      } catch (SQLException var2) {
         return (Datum[])this.postForAll(methodObject2846, this.onErrorForAll(methodObject2846, var2));
      }
   }

   public Object getArray() throws SQLException {
      try {
         super.preForAll(methodObject2914, this, zeroLengthObjectArray);
         return this.postForAll(methodObject2914, this.proxyFactory.proxyForCache(this.delegate.getArray(), this, this.proxyCache, methodObject2914));
      } catch (SQLException var2) {
         return this.postForAll(methodObject2914, this.onErrorForAll(methodObject2914, var2));
      }
   }

   public void setImageLength(long arg0) throws SQLException {
      try {
         super.preForAll(methodObject2868, this, arg0);
         Method var10001 = methodObject2868;
         this.delegate.setImageLength(arg0);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject2868, var4);
      }
   }

   public Datum[] getOracleArray(long arg0, int arg1) throws SQLException {
      try {
         super.preForAll(methodObject2847, this, arg0, arg1);
         return (Datum[])this.postForAll(methodObject2847, (Object)this.delegate.getOracleArray(arg0, arg1));
      } catch (SQLException var5) {
         return (Datum[])this.postForAll(methodObject2847, this.onErrorForAll(methodObject2847, var5));
      }
   }

   public Object makeJdbcArray(int arg0) {
      super.preForAll(methodObject2845, this, arg0);
      return this.postForAll(methodObject2845, this.proxyFactory.proxyForCache(this.delegate.makeJdbcArray(arg0), this, this.proxyCache, methodObject2845));
   }

   public byte[] getBytes() {
      super.preForAll(methodObject2878, this, zeroLengthObjectArray);
      return (byte[])this.postForAll(methodObject2878, (Object)this.delegate.getBytes());
   }

   public ResultSet getResultSet(long arg0, int arg1) throws SQLException {
      try {
         super.preForAll(methodObject2921, this, arg0, arg1);
         return (ResultSet)this.postForAll(methodObject2921, this.proxyFactory.proxyForCache((Object)this.delegate.getResultSet(arg0, arg1), this, this.proxyCache, methodObject2921));
      } catch (SQLException var5) {
         return (ResultSet)this.postForAll(methodObject2921, this.onErrorForAll(methodObject2921, var5));
      }
   }

   public long getLastIndex() throws SQLException {
      try {
         super.preForAll(methodObject2865, this, zeroLengthObjectArray);
         return (Long)this.postForAll(methodObject2865, this.delegate.getLastIndex());
      } catch (SQLException var2) {
         return (Long)this.postForAll(methodObject2865, this.onErrorForAll(methodObject2865, var2));
      }
   }

   public boolean getAutoBuffering() throws SQLException {
      try {
         super.preForAll(methodObject2858, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject2858, this.delegate.getAutoBuffering());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject2858, this.onErrorForAll(methodObject2858, var2));
      }
   }

   public InputStream binaryStreamValue() throws SQLException {
      try {
         super.preForAll(methodObject2887, this, zeroLengthObjectArray);
         return (InputStream)this.postForAll(methodObject2887, (Object)this.delegate.binaryStreamValue());
      } catch (SQLException var2) {
         return (InputStream)this.postForAll(methodObject2887, this.onErrorForAll(methodObject2887, var2));
      }
   }

   public void setLastIndexOffset(long arg0, long arg1) throws SQLException {
      try {
         super.preForAll(methodObject2863, this, arg0, arg1);
         Method var10001 = methodObject2863;
         this.delegate.setLastIndexOffset(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var6) {
         this.onErrorVoidForAll(methodObject2863, var6);
      }
   }

   public void setACProxy(Object arg0) {
      super.preForAll(methodObject2925, this, arg0);
      Method var10001 = methodObject2925;
      this.delegate.setACProxy(arg0 instanceof _Proxy_ ? (Object)((_Proxy_)arg0)._getDelegate_() : arg0);
      this.postForAll(var10001);
   }

   public Object getACProxy() {
      super.preForAll(methodObject2926, this, zeroLengthObjectArray);
      return this.postForAll(methodObject2926, this.proxyFactory.proxyForCache(this.delegate.getACProxy(), this, this.proxyCache, methodObject2926));
   }

   public oracle.jdbc.OracleConnection getOracleConnection() throws SQLException {
      try {
         super.preForAll(methodObject2898, this, zeroLengthObjectArray);
         return (oracle.jdbc.OracleConnection)this.postForAll(methodObject2898, this.proxyFactory.proxyForCache((Object)this.delegate.getOracleConnection(), this, this.proxyCache, methodObject2898));
      } catch (SQLException var2) {
         return (oracle.jdbc.OracleConnection)this.postForAll(methodObject2898, this.onErrorForAll(methodObject2898, var2));
      }
   }

   public float[] getFloatArray(long arg0, int arg1) throws SQLException {
      try {
         super.preForAll(methodObject2913, this, arg0, arg1);
         return (float[])this.postForAll(methodObject2913, (Object)this.delegate.getFloatArray(arg0, arg1));
      } catch (SQLException var5) {
         return (float[])this.postForAll(methodObject2913, this.onErrorForAll(methodObject2913, var5));
      }
   }

   public Object toJdbc() throws SQLException {
      try {
         super.preForAll(methodObject2901, this, zeroLengthObjectArray);
         return this.postForAll(methodObject2901, this.proxyFactory.proxyForCache(this.delegate.toJdbc(), this, this.proxyCache, methodObject2901));
      } catch (SQLException var2) {
         return this.postForAll(methodObject2901, this.onErrorForAll(methodObject2901, var2));
      }
   }

   public String getBaseTypeName() throws SQLException {
      try {
         super.preForAll(methodObject2918, this, zeroLengthObjectArray);
         return (String)this.postForAll(methodObject2918, (Object)this.delegate.getBaseTypeName());
      } catch (SQLException var2) {
         return (String)this.postForAll(methodObject2918, this.onErrorForAll(methodObject2918, var2));
      }
   }

   public boolean hasDataSeg() {
      super.preForAll(methodObject2855, this, zeroLengthObjectArray);
      return (Boolean)this.postForAll(methodObject2855, this.delegate.hasDataSeg());
   }

   public void setImage(byte[] arg0, long arg1, long arg2) throws SQLException {
      try {
         super.preForAll(methodObject2867, this, arg0, arg1, arg2);
         Method var10001 = methodObject2867;
         this.delegate.setImage(arg0, arg1, arg2);
         this.postForAll(var10001);
      } catch (SQLException var7) {
         this.onErrorVoidForAll(methodObject2867, var7);
      }
   }

   public void setObjArray(Object arg0) throws SQLException {
      try {
         super.preForAll(methodObject2850, this, arg0);
         Method var10001 = methodObject2850;
         this.delegate.setObjArray(arg0 instanceof _Proxy_ ? (Object)((_Proxy_)arg0)._getDelegate_() : arg0);
         this.postForAll(var10001);
      } catch (SQLException var3) {
         this.onErrorVoidForAll(methodObject2850, var3);
      }
   }

   public Date dateValue() throws SQLException {
      try {
         super.preForAll(methodObject2894, this, zeroLengthObjectArray);
         return (Date)this.postForAll(methodObject2894, (Object)this.delegate.dateValue());
      } catch (SQLException var2) {
         return (Date)this.postForAll(methodObject2894, this.onErrorForAll(methodObject2894, var2));
      }
   }

   public BigDecimal bigDecimalValue() throws SQLException {
      try {
         super.preForAll(methodObject2893, this, zeroLengthObjectArray);
         return (BigDecimal)this.postForAll(methodObject2893, (Object)this.delegate.bigDecimalValue());
      } catch (SQLException var2) {
         return (BigDecimal)this.postForAll(methodObject2893, this.onErrorForAll(methodObject2893, var2));
      }
   }

   public void setBytes(byte[] arg0) {
      super.preForAll(methodObject2880, this, arg0);
      Method var10001 = methodObject2880;
      this.delegate.setBytes(arg0);
      this.postForAll(var10001);
   }

   public void setAutoIndexing(boolean arg0) throws SQLException {
      try {
         super.preForAll(methodObject2860, this, arg0);
         Method var10001 = methodObject2860;
         this.delegate.setAutoIndexing(arg0);
         this.postForAll(var10001);
      } catch (SQLException var3) {
         this.onErrorVoidForAll(methodObject2860, var3);
      }
   }

   public OracleTypeMetaData getOracleMetaData() throws SQLException {
      try {
         super.preForAll(methodObject2903, this, zeroLengthObjectArray);
         return (OracleTypeMetaData)this.postForAll(methodObject2903, this.proxyFactory.proxyForCache((Object)this.delegate.getOracleMetaData(), this, this.proxyCache, methodObject2903));
      } catch (SQLException var2) {
         return (OracleTypeMetaData)this.postForAll(methodObject2903, this.onErrorForAll(methodObject2903, var2));
      }
   }

   public long[] getLongArray(long arg0, int arg1) throws SQLException {
      try {
         super.preForAll(methodObject2911, this, arg0, arg1);
         return (long[])this.postForAll(methodObject2911, (Object)this.delegate.getLongArray(arg0, arg1));
      } catch (SQLException var5) {
         return (long[])this.postForAll(methodObject2911, this.onErrorForAll(methodObject2911, var5));
      }
   }

   public byte byteValue() throws SQLException {
      try {
         super.preForAll(methodObject2873, this, zeroLengthObjectArray);
         return (Byte)this.postForAll(methodObject2873, this.delegate.byteValue());
      } catch (SQLException var2) {
         return (Byte)this.postForAll(methodObject2873, this.onErrorForAll(methodObject2873, var2));
      }
   }

   public short[] getShortArray(long arg0, int arg1) throws SQLException {
      try {
         super.preForAll(methodObject2909, this, arg0, arg1);
         return (short[])this.postForAll(methodObject2909, (Object)this.delegate.getShortArray(arg0, arg1));
      } catch (SQLException var5) {
         return (short[])this.postForAll(methodObject2909, this.onErrorForAll(methodObject2909, var5));
      }
   }

   public boolean getAutoIndexing() throws SQLException {
      try {
         super.preForAll(methodObject2861, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject2861, this.delegate.getAutoIndexing());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject2861, this.onErrorForAll(methodObject2861, var2));
      }
   }

   public float floatValue() throws SQLException {
      try {
         super.preForAll(methodObject2876, this, zeroLengthObjectArray);
         return (Float)this.postForAll(methodObject2876, this.delegate.floatValue());
      } catch (SQLException var2) {
         return (Float)this.postForAll(methodObject2876, this.onErrorForAll(methodObject2876, var2));
      }
   }

   public Reader characterStreamValue() throws SQLException {
      try {
         super.preForAll(methodObject2885, this, zeroLengthObjectArray);
         return (Reader)this.postForAll(methodObject2885, (Object)this.delegate.characterStreamValue());
      } catch (SQLException var2) {
         return (Reader)this.postForAll(methodObject2885, this.onErrorForAll(methodObject2885, var2));
      }
   }

   public InputStream getStream() throws SQLException {
      try {
         super.preForAll(methodObject2890, this, zeroLengthObjectArray);
         return (InputStream)this.postForAll(methodObject2890, (Object)this.delegate.getStream());
      } catch (SQLException var2) {
         return (InputStream)this.postForAll(methodObject2890, this.onErrorForAll(methodObject2890, var2));
      }
   }

   public byte[] toBytes() throws SQLException {
      try {
         super.preForAll(methodObject2848, this, zeroLengthObjectArray);
         return (byte[])this.postForAll(methodObject2848, (Object)this.delegate.toBytes());
      } catch (SQLException var2) {
         return (byte[])this.postForAll(methodObject2848, this.onErrorForAll(methodObject2848, var2));
      }
   }

   public long getLength() {
      super.preForAll(methodObject2871, this, zeroLengthObjectArray);
      return (Long)this.postForAll(methodObject2871, this.delegate.getLength());
   }

   public Time timeValue() throws SQLException {
      try {
         super.preForAll(methodObject2881, this, zeroLengthObjectArray);
         return (Time)this.postForAll(methodObject2881, (Object)this.delegate.timeValue());
      } catch (SQLException var2) {
         return (Time)this.postForAll(methodObject2881, this.onErrorForAll(methodObject2881, var2));
      }
   }

   public ResultSet getResultSet() throws SQLException {
      try {
         super.preForAll(methodObject2919, this, zeroLengthObjectArray);
         return (ResultSet)this.postForAll(methodObject2919, this.proxyFactory.proxyForCache((Object)this.delegate.getResultSet(), this, this.proxyCache, methodObject2919));
      } catch (SQLException var2) {
         return (ResultSet)this.postForAll(methodObject2919, this.onErrorForAll(methodObject2919, var2));
      }
   }

   public oracle.jdbc.driver.OracleConnection getConnection() throws SQLException {
      try {
         super.preForAll(methodObject2899, this, zeroLengthObjectArray);
         return (oracle.jdbc.driver.OracleConnection)this.postForAll(methodObject2899, (Object)this.delegate.getConnection());
      } catch (SQLException var2) {
         return (oracle.jdbc.driver.OracleConnection)this.postForAll(methodObject2899, this.onErrorForAll(methodObject2899, var2));
      }
   }

   public void setPhysicalConnectionOf(Connection arg0) {
      super.preForAll(methodObject2896, this, arg0);
      Method var10001 = methodObject2896;
      this.delegate.setPhysicalConnectionOf(arg0 instanceof _Proxy_ ? (Connection)((_Proxy_)arg0)._getDelegate_() : arg0);
      this.postForAll(var10001);
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
         methodObject2892 = OracleDatumWithConnection.class.getDeclaredMethod("stringValue", Connection.class);
         methodObject2856 = OracleArray.class.getDeclaredMethod("isInline");
         methodObject2857 = OracleArray.class.getDeclaredMethod("setAutoBuffering", Boolean.TYPE);
         methodObject2842 = OracleArray.class.getDeclaredMethod("setLength", Integer.TYPE);
         methodObject2870 = OracleArray.class.getDeclaredMethod("getImageLength");
         methodObject2843 = OracleArray.class.getDeclaredMethod("getOffset", Long.TYPE);
         methodObject2897 = OracleDatumWithConnection.class.getDeclaredMethod("getJavaSqlConnection");
         methodObject2912 = oracle.jdbc.OracleArray.class.getDeclaredMethod("getFloatArray");
         methodObject2869 = OracleArray.class.getDeclaredMethod("getImageOffset");
         methodObject2872 = OracleDatumWithConnection.class.getDeclaredMethod("booleanValue");
         methodObject2905 = oracle.jdbc.OracleArray.class.getDeclaredMethod("getIntArray", Long.TYPE, Integer.TYPE);
         methodObject2841 = OracleArray.class.getDeclaredMethod("isConvertibleTo", Class.class);
         methodObject2902 = oracle.jdbc.OracleArray.class.getDeclaredMethod("getSQLTypeName");
         methodObject2852 = OracleArray.class.getDeclaredMethod("setPrefixSegment", byte[].class);
         methodObject2907 = oracle.jdbc.OracleArray.class.getDeclaredMethod("getDoubleArray", Long.TYPE, Integer.TYPE);
         methodObject2904 = oracle.jdbc.OracleArray.class.getDeclaredMethod("getIntArray");
         methodObject2844 = OracleArray.class.getDeclaredMethod("getMap");
         methodObject2883 = OracleDatumWithConnection.class.getDeclaredMethod("timestampValue");
         methodObject2924 = Array.class.getDeclaredMethod("getBaseType");
         methodObject2874 = OracleDatumWithConnection.class.getDeclaredMethod("intValue");
         methodObject2906 = oracle.jdbc.OracleArray.class.getDeclaredMethod("getDoubleArray");
         methodObject2891 = OracleDatumWithConnection.class.getDeclaredMethod("stringValue");
         methodObject2862 = OracleArray.class.getDeclaredMethod("getAccessDirection");
         methodObject2882 = OracleDatumWithConnection.class.getDeclaredMethod("timeValue", Calendar.class);
         methodObject2923 = Array.class.getDeclaredMethod("free");
         methodObject2884 = OracleDatumWithConnection.class.getDeclaredMethod("timestampValue", Calendar.class);
         methodObject2864 = OracleArray.class.getDeclaredMethod("setIndexOffset", Long.TYPE, Long.TYPE);
         methodObject2886 = OracleDatumWithConnection.class.getDeclaredMethod("asciiStreamValue");
         methodObject2910 = oracle.jdbc.OracleArray.class.getDeclaredMethod("getLongArray");
         methodObject2879 = OracleDatumWithConnection.class.getDeclaredMethod("shareBytes");
         methodObject2877 = OracleDatumWithConnection.class.getDeclaredMethod("doubleValue");
         methodObject2853 = OracleArray.class.getDeclaredMethod("setPrefixFlag", Byte.TYPE);
         methodObject2917 = Array.class.getDeclaredMethod("getArray", Long.TYPE, Integer.TYPE, Map.class);
         methodObject2854 = OracleArray.class.getDeclaredMethod("getLocator");
         methodObject2859 = OracleArray.class.getDeclaredMethod("setAutoIndexing", Boolean.TYPE, Integer.TYPE);
         methodObject2866 = OracleArray.class.getDeclaredMethod("getLastOffset");
         methodObject2908 = oracle.jdbc.OracleArray.class.getDeclaredMethod("getShortArray");
         methodObject2849 = OracleArray.class.getDeclaredMethod("setDatumArray", Datum[].class);
         methodObject2875 = OracleDatumWithConnection.class.getDeclaredMethod("longValue");
         methodObject2851 = OracleArray.class.getDeclaredMethod("setLocator", byte[].class);
         methodObject2922 = Array.class.getDeclaredMethod("getResultSet", Long.TYPE, Integer.TYPE, Map.class);
         methodObject2920 = Array.class.getDeclaredMethod("getResultSet", Map.class);
         methodObject2915 = Array.class.getDeclaredMethod("getArray", Map.class);
         methodObject2916 = Array.class.getDeclaredMethod("getArray", Long.TYPE, Integer.TYPE);
         methodObject2900 = oracle.jdbc.OracleArray.class.getDeclaredMethod("length");
         methodObject2895 = OracleDatumWithConnection.class.getDeclaredMethod("getInternalConnection");
         methodObject2840 = OracleArray.class.getDeclaredMethod("getDescriptor");
         methodObject2889 = OracleDatumWithConnection.class.getDeclaredMethod("setShareBytes", byte[].class);
         methodObject2846 = OracleArray.class.getDeclaredMethod("getOracleArray");
         methodObject2914 = Array.class.getDeclaredMethod("getArray");
         methodObject2868 = OracleArray.class.getDeclaredMethod("setImageLength", Long.TYPE);
         methodObject2847 = OracleArray.class.getDeclaredMethod("getOracleArray", Long.TYPE, Integer.TYPE);
         methodObject2845 = OracleArray.class.getDeclaredMethod("makeJdbcArray", Integer.TYPE);
         methodObject2878 = OracleDatumWithConnection.class.getDeclaredMethod("getBytes");
         methodObject2921 = Array.class.getDeclaredMethod("getResultSet", Long.TYPE, Integer.TYPE);
         methodObject2865 = OracleArray.class.getDeclaredMethod("getLastIndex");
         methodObject2858 = OracleArray.class.getDeclaredMethod("getAutoBuffering");
         methodObject2887 = OracleDatumWithConnection.class.getDeclaredMethod("binaryStreamValue");
         methodObject2863 = OracleArray.class.getDeclaredMethod("setLastIndexOffset", Long.TYPE, Long.TYPE);
         methodObject2925 = ACProxyable.class.getDeclaredMethod("setACProxy", Object.class);
         methodObject2926 = ACProxyable.class.getDeclaredMethod("getACProxy");
         methodObject2898 = OracleDatumWithConnection.class.getDeclaredMethod("getOracleConnection");
         methodObject2913 = oracle.jdbc.OracleArray.class.getDeclaredMethod("getFloatArray", Long.TYPE, Integer.TYPE);
         methodObject2901 = oracle.jdbc.OracleArray.class.getDeclaredMethod("toJdbc");
         methodObject2918 = Array.class.getDeclaredMethod("getBaseTypeName");
         methodObject2855 = OracleArray.class.getDeclaredMethod("hasDataSeg");
         methodObject2867 = OracleArray.class.getDeclaredMethod("setImage", byte[].class, Long.TYPE, Long.TYPE);
         methodObject2850 = OracleArray.class.getDeclaredMethod("setObjArray", Object.class);
         methodObject2894 = OracleDatumWithConnection.class.getDeclaredMethod("dateValue");
         methodObject2893 = OracleDatumWithConnection.class.getDeclaredMethod("bigDecimalValue");
         methodObject2880 = OracleDatumWithConnection.class.getDeclaredMethod("setBytes", byte[].class);
         methodObject2860 = OracleArray.class.getDeclaredMethod("setAutoIndexing", Boolean.TYPE);
         methodObject2903 = oracle.jdbc.OracleArray.class.getDeclaredMethod("getOracleMetaData");
         methodObject2911 = oracle.jdbc.OracleArray.class.getDeclaredMethod("getLongArray", Long.TYPE, Integer.TYPE);
         methodObject2873 = OracleDatumWithConnection.class.getDeclaredMethod("byteValue");
         methodObject2909 = oracle.jdbc.OracleArray.class.getDeclaredMethod("getShortArray", Long.TYPE, Integer.TYPE);
         methodObject2861 = OracleArray.class.getDeclaredMethod("getAutoIndexing");
         methodObject2876 = OracleDatumWithConnection.class.getDeclaredMethod("floatValue");
         methodObject2885 = OracleDatumWithConnection.class.getDeclaredMethod("characterStreamValue");
         methodObject2890 = OracleDatumWithConnection.class.getDeclaredMethod("getStream");
         methodObject2848 = OracleArray.class.getDeclaredMethod("toBytes");
         methodObject2871 = OracleDatumWithConnection.class.getDeclaredMethod("getLength");
         methodObject2881 = OracleDatumWithConnection.class.getDeclaredMethod("timeValue");
         methodObject2919 = Array.class.getDeclaredMethod("getResultSet");
         methodObject2899 = OracleDatumWithConnection.class.getDeclaredMethod("getConnection");
         methodObject2896 = OracleDatumWithConnection.class.getDeclaredMethod("setPhysicalConnectionOf", Connection.class);
      } catch (Throwable var1) {
         throw new RuntimeException(var1);
      }
   }

   public oracle$1jdbc$1replay$1driver$1TxnReplayableArray$2oracle$1jdbc$1internal$1OracleArray$$$Proxy(OracleArray var1, Object var2, ProxyFactory var3, Map var4) {
      this.delegate = var1;
      this.creator = var2;
      this.proxyFactory = var3;
      this.proxyCache = var4;
   }
}
