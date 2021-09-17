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
import oracle.jdbc.replay.driver.NonTxnReplayableArray;
import oracle.sql.ArrayDescriptor;
import oracle.sql.Datum;

public abstract class oracle$1jdbc$1replay$1driver$1NonTxnReplayableArray$2oracle$1jdbc$1internal$1OracleArray$$$Proxy extends NonTxnReplayableArray implements OracleArray, _Proxy_ {
   private OracleArray delegate;
   private final Object creator;
   private final ProxyFactory proxyFactory;
   private final Map proxyCache;
   private static Object[] zeroLengthObjectArray = new Object[0];
   private static Method methodObject13172;
   private static Method methodObject13131;
   private static Method methodObject13134;
   private static Method methodObject13141;
   private static Method methodObject13139;
   private static Method methodObject13152;
   private static Method methodObject13155;
   private static Method methodObject13196;
   private static Method methodObject13190;
   private static Method methodObject13169;
   private static Method methodObject13197;
   private static Method methodObject13154;
   private static Method methodObject13157;
   private static Method methodObject13192;
   private static Method methodObject13137;
   private static Method methodObject13187;
   private static Method methodObject13206;
   private static Method methodObject13189;
   private static Method methodObject13210;
   private static Method methodObject13201;
   private static Method methodObject13129;
   private static Method methodObject13180;
   private static Method methodObject13204;
   private static Method methodObject13183;
   private static Method methodObject13159;
   private static Method methodObject13191;
   private static Method methodObject13174;
   private static Method methodObject13148;
   private static Method methodObject13147;
   private static Method methodObject13202;
   private static Method methodObject13175;
   private static Method methodObject13203;
   private static Method methodObject13127;
   private static Method methodObject13138;
   private static Method methodObject13167;
   private static Method methodObject13195;
   private static Method methodObject13170;
   private static Method methodObject13162;
   private static Method methodObject13130;
   private static Method methodObject13151;
   private static Method methodObject13193;
   private static Method methodObject13153;
   private static Method methodObject13208;
   private static Method methodObject13160;
   private static Method methodObject13181;
   private static Method methodObject13136;
   private static Method methodObject13149;
   private static Method methodObject13142;
   private static Method methodObject13185;
   private static Method methodObject13125;
   private static Method methodObject13164;
   private static Method methodObject13133;
   private static Method methodObject13199;
   private static Method methodObject13144;
   private static Method methodObject13126;
   private static Method methodObject13163;
   private static Method methodObject13179;
   private static Method methodObject13150;
   private static Method methodObject13145;
   private static Method methodObject13143;
   private static Method methodObject13168;
   private static Method methodObject13211;
   private static Method methodObject13182;
   private static Method methodObject13207;
   private static Method methodObject13186;
   private static Method methodObject13209;
   private static Method methodObject13140;
   private static Method methodObject13128;
   private static Method methodObject13177;
   private static Method methodObject13171;
   private static Method methodObject13176;
   private static Method methodObject13194;
   private static Method methodObject13188;
   private static Method methodObject13132;
   private static Method methodObject13198;
   private static Method methodObject13158;
   private static Method methodObject13146;
   private static Method methodObject13161;
   private static Method methodObject13166;
   private static Method methodObject13135;
   private static Method methodObject13173;
   private static Method methodObject13178;
   private static Method methodObject13156;
   private static Method methodObject13200;
   private static Method methodObject13205;
   private static Method methodObject13184;

   public void setShareBytes(byte[] arg0) {
      super.preForAll(methodObject13172, this, arg0);
      this.delegate.setShareBytes(arg0);
   }

   public void setLocator(byte[] arg0) {
      super.preForAll(methodObject13131, this, arg0);
      this.delegate.setLocator(arg0);
   }

   public Datum[] getOracleArray(long arg0, int arg1) throws SQLException {
      try {
         super.preForAll(methodObject13134, this, arg0, arg1);
         return (Datum[])this.postForAll(methodObject13134, (Object)this.delegate.getOracleArray(arg0, arg1));
      } catch (SQLException var5) {
         return (Datum[])this.postForAll(methodObject13134, this.onErrorForAll(methodObject13134, var5));
      }
   }

   public boolean isInline() {
      super.preForAll(methodObject13141, this, zeroLengthObjectArray);
      return (Boolean)this.postForAll(methodObject13141, this.delegate.isInline());
   }

   public void setPrefixFlag(byte arg0) {
      super.preForAll(methodObject13139, this, arg0);
      this.delegate.setPrefixFlag(arg0);
   }

   public void setImage(byte[] arg0, long arg1, long arg2) throws SQLException {
      try {
         super.preForAll(methodObject13152, this, arg0, arg1, arg2);
         this.delegate.setImage(arg0, arg1, arg2);
      } catch (SQLException var7) {
         this.onErrorVoidForAll(methodObject13152, var7);
      }
   }

   public long getImageLength() {
      super.preForAll(methodObject13155, this, zeroLengthObjectArray);
      return (Long)this.postForAll(methodObject13155, this.delegate.getImageLength());
   }

   public long[] getLongArray(long arg0, int arg1) throws SQLException {
      try {
         super.preForAll(methodObject13196, this, arg0, arg1);
         return (long[])this.postForAll(methodObject13196, (Object)this.delegate.getLongArray(arg0, arg1));
      } catch (SQLException var5) {
         return (long[])this.postForAll(methodObject13196, this.onErrorForAll(methodObject13196, var5));
      }
   }

   public int[] getIntArray(long arg0, int arg1) throws SQLException {
      try {
         super.preForAll(methodObject13190, this, arg0, arg1);
         return (int[])this.postForAll(methodObject13190, (Object)this.delegate.getIntArray(arg0, arg1));
      } catch (SQLException var5) {
         return (int[])this.postForAll(methodObject13190, this.onErrorForAll(methodObject13190, var5));
      }
   }

   public Connection getJavaSqlConnection() throws SQLException {
      try {
         super.preForAll(methodObject13169, this, zeroLengthObjectArray);
         return (Connection)this.postForAll(methodObject13169, this.proxyFactory.proxyForCache((Object)this.delegate.getJavaSqlConnection(), this, this.proxyCache, methodObject13169));
      } catch (SQLException var2) {
         return (Connection)this.postForAll(methodObject13169, this.onErrorForAll(methodObject13169, var2));
      }
   }

   public float[] getFloatArray() throws SQLException {
      try {
         super.preForAll(methodObject13197, this, zeroLengthObjectArray);
         return (float[])this.postForAll(methodObject13197, (Object)this.delegate.getFloatArray());
      } catch (SQLException var2) {
         return (float[])this.postForAll(methodObject13197, this.onErrorForAll(methodObject13197, var2));
      }
   }

   public long getImageOffset() {
      super.preForAll(methodObject13154, this, zeroLengthObjectArray);
      return (Long)this.postForAll(methodObject13154, this.delegate.getImageOffset());
   }

   public boolean booleanValue() throws SQLException {
      try {
         super.preForAll(methodObject13157, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject13157, this.delegate.booleanValue());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject13157, this.onErrorForAll(methodObject13157, var2));
      }
   }

   public double[] getDoubleArray(long arg0, int arg1) throws SQLException {
      try {
         super.preForAll(methodObject13192, this, arg0, arg1);
         return (double[])this.postForAll(methodObject13192, (Object)this.delegate.getDoubleArray(arg0, arg1));
      } catch (SQLException var5) {
         return (double[])this.postForAll(methodObject13192, this.onErrorForAll(methodObject13192, var5));
      }
   }

   public void setObjArray(Object arg0) throws SQLException {
      try {
         super.preForAll(methodObject13137, this, arg0);
         this.delegate.setObjArray(arg0 instanceof _Proxy_ ? (Object)((_Proxy_)arg0)._getDelegate_() : arg0);
      } catch (SQLException var3) {
         this.onErrorVoidForAll(methodObject13137, var3);
      }
   }

   public String getSQLTypeName() throws SQLException {
      try {
         super.preForAll(methodObject13187, this, zeroLengthObjectArray);
         return (String)this.postForAll(methodObject13187, (Object)this.delegate.getSQLTypeName());
      } catch (SQLException var2) {
         return (String)this.postForAll(methodObject13187, this.onErrorForAll(methodObject13187, var2));
      }
   }

   public ResultSet getResultSet(Map arg0) throws SQLException {
      try {
         super.preForAll(methodObject13206, this, arg0);
         return (ResultSet)this.postForAll(methodObject13206, this.proxyFactory.proxyForCreate((Object)this.delegate.getResultSet(arg0), this, this.proxyCache, methodObject13206));
      } catch (SQLException var3) {
         return (ResultSet)this.postForAll(methodObject13206, this.onErrorForAll(methodObject13206, var3));
      }
   }

   public int[] getIntArray() throws SQLException {
      try {
         super.preForAll(methodObject13189, this, zeroLengthObjectArray);
         return (int[])this.postForAll(methodObject13189, (Object)this.delegate.getIntArray());
      } catch (SQLException var2) {
         return (int[])this.postForAll(methodObject13189, this.onErrorForAll(methodObject13189, var2));
      }
   }

   public void setACProxy(Object arg0) {
      super.preForAll(methodObject13210, this, arg0);
      this.delegate.setACProxy(arg0 instanceof _Proxy_ ? (Object)((_Proxy_)arg0)._getDelegate_() : arg0);
   }

   public Object getArray(long arg0, int arg1) throws SQLException {
      try {
         super.preForAll(methodObject13201, this, arg0, arg1);
         return this.postForAll(methodObject13201, this.proxyFactory.proxyForCache(this.delegate.getArray(arg0, arg1), this, this.proxyCache, methodObject13201));
      } catch (SQLException var5) {
         return this.postForAll(methodObject13201, this.onErrorForAll(methodObject13201, var5));
      }
   }

   public Map getMap() throws SQLException {
      try {
         super.preForAll(methodObject13129, this, zeroLengthObjectArray);
         return (Map)this.postForAll(methodObject13129, (Object)this.delegate.getMap());
      } catch (SQLException var2) {
         return (Map)this.postForAll(methodObject13129, this.onErrorForAll(methodObject13129, var2));
      }
   }

   public Timestamp timestampValue() throws SQLException {
      try {
         super.preForAll(methodObject13180, this, zeroLengthObjectArray);
         return (Timestamp)this.postForAll(methodObject13180, (Object)this.delegate.timestampValue());
      } catch (SQLException var2) {
         return (Timestamp)this.postForAll(methodObject13180, this.onErrorForAll(methodObject13180, var2));
      }
   }

   public int getBaseType() throws SQLException {
      try {
         super.preForAll(methodObject13204, this, zeroLengthObjectArray);
         return (Integer)this.postForAll(methodObject13204, this.delegate.getBaseType());
      } catch (SQLException var2) {
         return (Integer)this.postForAll(methodObject13204, this.onErrorForAll(methodObject13204, var2));
      }
   }

   public void setPhysicalConnectionOf(Connection arg0) {
      super.preForAll(methodObject13183, this, arg0);
      this.delegate.setPhysicalConnectionOf(arg0 instanceof _Proxy_ ? (Connection)((_Proxy_)arg0)._getDelegate_() : arg0);
   }

   public int intValue() throws SQLException {
      try {
         super.preForAll(methodObject13159, this, zeroLengthObjectArray);
         return (Integer)this.postForAll(methodObject13159, this.delegate.intValue());
      } catch (SQLException var2) {
         return (Integer)this.postForAll(methodObject13159, this.onErrorForAll(methodObject13159, var2));
      }
   }

   public double[] getDoubleArray() throws SQLException {
      try {
         super.preForAll(methodObject13191, this, zeroLengthObjectArray);
         return (double[])this.postForAll(methodObject13191, (Object)this.delegate.getDoubleArray());
      } catch (SQLException var2) {
         return (double[])this.postForAll(methodObject13191, this.onErrorForAll(methodObject13191, var2));
      }
   }

   public String stringValue() throws SQLException {
      try {
         super.preForAll(methodObject13174, this, zeroLengthObjectArray);
         return (String)this.postForAll(methodObject13174, (Object)this.delegate.stringValue());
      } catch (SQLException var2) {
         return (String)this.postForAll(methodObject13174, this.onErrorForAll(methodObject13174, var2));
      }
   }

   public void setLastIndexOffset(long arg0, long arg1) throws SQLException {
      try {
         super.preForAll(methodObject13148, this, arg0, arg1);
         this.delegate.setLastIndexOffset(arg0, arg1);
      } catch (SQLException var6) {
         this.onErrorVoidForAll(methodObject13148, var6);
      }
   }

   public int getAccessDirection() throws SQLException {
      try {
         super.preForAll(methodObject13147, this, zeroLengthObjectArray);
         return (Integer)this.postForAll(methodObject13147, this.delegate.getAccessDirection());
      } catch (SQLException var2) {
         return (Integer)this.postForAll(methodObject13147, this.onErrorForAll(methodObject13147, var2));
      }
   }

   public Object getArray(long arg0, int arg1, Map arg2) throws SQLException {
      try {
         super.preForAll(methodObject13202, this, arg0, arg1, arg2);
         return this.postForAll(methodObject13202, this.proxyFactory.proxyForCache(this.delegate.getArray(arg0, arg1, arg2), this, this.proxyCache, methodObject13202));
      } catch (SQLException var6) {
         return this.postForAll(methodObject13202, this.onErrorForAll(methodObject13202, var6));
      }
   }

   public String stringValue(Connection arg0) throws SQLException {
      try {
         super.preForAll(methodObject13175, this, arg0);
         return (String)this.postForAll(methodObject13175, (Object)this.delegate.stringValue(arg0 instanceof _Proxy_ ? (Connection)((_Proxy_)arg0)._getDelegate_() : arg0));
      } catch (SQLException var3) {
         return (String)this.postForAll(methodObject13175, this.onErrorForAll(methodObject13175, var3));
      }
   }

   public void free() throws SQLException {
      try {
         super.preForAll(methodObject13203, this, zeroLengthObjectArray);
         this.delegate.free();
      } catch (SQLException var2) {
         this.onErrorVoidForAll(methodObject13203, var2);
      }
   }

   public void setLength(int arg0) {
      super.preForAll(methodObject13127, this, arg0);
      this.delegate.setLength(arg0);
   }

   public void setPrefixSegment(byte[] arg0) {
      super.preForAll(methodObject13138, this, arg0);
      this.delegate.setPrefixSegment(arg0);
   }

   public InputStream asciiStreamValue() throws SQLException {
      try {
         super.preForAll(methodObject13167, this, zeroLengthObjectArray);
         return (InputStream)this.postForAll(methodObject13167, (Object)this.delegate.asciiStreamValue());
      } catch (SQLException var2) {
         return (InputStream)this.postForAll(methodObject13167, this.onErrorForAll(methodObject13167, var2));
      }
   }

   public long[] getLongArray() throws SQLException {
      try {
         super.preForAll(methodObject13195, this, zeroLengthObjectArray);
         return (long[])this.postForAll(methodObject13195, (Object)this.delegate.getLongArray());
      } catch (SQLException var2) {
         return (long[])this.postForAll(methodObject13195, this.onErrorForAll(methodObject13195, var2));
      }
   }

   public byte[] shareBytes() {
      super.preForAll(methodObject13170, this, zeroLengthObjectArray);
      return (byte[])this.postForAll(methodObject13170, (Object)this.delegate.shareBytes());
   }

   public double doubleValue() throws SQLException {
      try {
         super.preForAll(methodObject13162, this, zeroLengthObjectArray);
         return (Double)this.postForAll(methodObject13162, this.delegate.doubleValue());
      } catch (SQLException var2) {
         return (Double)this.postForAll(methodObject13162, this.onErrorForAll(methodObject13162, var2));
      }
   }

   public byte[] getLocator() {
      super.preForAll(methodObject13130, this, zeroLengthObjectArray);
      return (byte[])this.postForAll(methodObject13130, (Object)this.delegate.getLocator());
   }

   public long getLastOffset() throws SQLException {
      try {
         super.preForAll(methodObject13151, this, zeroLengthObjectArray);
         return (Long)this.postForAll(methodObject13151, this.delegate.getLastOffset());
      } catch (SQLException var2) {
         return (Long)this.postForAll(methodObject13151, this.onErrorForAll(methodObject13151, var2));
      }
   }

   public short[] getShortArray() throws SQLException {
      try {
         super.preForAll(methodObject13193, this, zeroLengthObjectArray);
         return (short[])this.postForAll(methodObject13193, (Object)this.delegate.getShortArray());
      } catch (SQLException var2) {
         return (short[])this.postForAll(methodObject13193, this.onErrorForAll(methodObject13193, var2));
      }
   }

   public void setImageLength(long arg0) throws SQLException {
      try {
         super.preForAll(methodObject13153, this, arg0);
         this.delegate.setImageLength(arg0);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject13153, var4);
      }
   }

   public ResultSet getResultSet(long arg0, int arg1, Map arg2) throws SQLException {
      try {
         super.preForAll(methodObject13208, this, arg0, arg1, arg2);
         return (ResultSet)this.postForAll(methodObject13208, this.proxyFactory.proxyForCreate((Object)this.delegate.getResultSet(arg0, arg1, arg2), this, this.proxyCache, methodObject13208));
      } catch (SQLException var6) {
         return (ResultSet)this.postForAll(methodObject13208, this.onErrorForAll(methodObject13208, var6));
      }
   }

   public long longValue() throws SQLException {
      try {
         super.preForAll(methodObject13160, this, zeroLengthObjectArray);
         return (Long)this.postForAll(methodObject13160, this.delegate.longValue());
      } catch (SQLException var2) {
         return (Long)this.postForAll(methodObject13160, this.onErrorForAll(methodObject13160, var2));
      }
   }

   public Timestamp timestampValue(Calendar arg0) throws SQLException {
      try {
         super.preForAll(methodObject13181, this, arg0);
         return (Timestamp)this.postForAll(methodObject13181, (Object)this.delegate.timestampValue(arg0));
      } catch (SQLException var3) {
         return (Timestamp)this.postForAll(methodObject13181, this.onErrorForAll(methodObject13181, var3));
      }
   }

   public void setDatumArray(Datum[] arg0) {
      super.preForAll(methodObject13136, this, arg0);
      this.delegate.setDatumArray(arg0);
   }

   public void setIndexOffset(long arg0, long arg1) throws SQLException {
      try {
         super.preForAll(methodObject13149, this, arg0, arg1);
         this.delegate.setIndexOffset(arg0, arg1);
      } catch (SQLException var6) {
         this.onErrorVoidForAll(methodObject13149, var6);
      }
   }

   public void setAutoBuffering(boolean arg0) throws SQLException {
      try {
         super.preForAll(methodObject13142, this, arg0);
         this.delegate.setAutoBuffering(arg0);
      } catch (SQLException var3) {
         this.onErrorVoidForAll(methodObject13142, var3);
      }
   }

   public int length() throws SQLException {
      try {
         super.preForAll(methodObject13185, this, zeroLengthObjectArray);
         return (Integer)this.postForAll(methodObject13185, this.delegate.length());
      } catch (SQLException var2) {
         return (Integer)this.postForAll(methodObject13185, this.onErrorForAll(methodObject13185, var2));
      }
   }

   public ArrayDescriptor getDescriptor() throws SQLException {
      try {
         super.preForAll(methodObject13125, this, zeroLengthObjectArray);
         return (ArrayDescriptor)this.postForAll(methodObject13125, (Object)this.delegate.getDescriptor());
      } catch (SQLException var2) {
         return (ArrayDescriptor)this.postForAll(methodObject13125, this.onErrorForAll(methodObject13125, var2));
      }
   }

   public OracleConnection getInternalConnection() throws SQLException {
      try {
         super.preForAll(methodObject13164, this, zeroLengthObjectArray);
         return (OracleConnection)this.postForAll(methodObject13164, this.proxyFactory.proxyForCache((Object)this.delegate.getInternalConnection(), this, this.proxyCache, methodObject13164));
      } catch (SQLException var2) {
         return (OracleConnection)this.postForAll(methodObject13164, this.onErrorForAll(methodObject13164, var2));
      }
   }

   public Datum[] getOracleArray() throws SQLException {
      try {
         super.preForAll(methodObject13133, this, zeroLengthObjectArray);
         return (Datum[])this.postForAll(methodObject13133, (Object)this.delegate.getOracleArray());
      } catch (SQLException var2) {
         return (Datum[])this.postForAll(methodObject13133, this.onErrorForAll(methodObject13133, var2));
      }
   }

   public Object getArray() throws SQLException {
      try {
         super.preForAll(methodObject13199, this, zeroLengthObjectArray);
         return this.postForAll(methodObject13199, this.proxyFactory.proxyForCache(this.delegate.getArray(), this, this.proxyCache, methodObject13199));
      } catch (SQLException var2) {
         return this.postForAll(methodObject13199, this.onErrorForAll(methodObject13199, var2));
      }
   }

   public void setAutoIndexing(boolean arg0, int arg1) throws SQLException {
      try {
         super.preForAll(methodObject13144, this, arg0, arg1);
         this.delegate.setAutoIndexing(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject13144, var4);
      }
   }

   public boolean isConvertibleTo(Class arg0) {
      super.preForAll(methodObject13126, this, arg0);
      return (Boolean)this.postForAll(methodObject13126, this.delegate.isConvertibleTo(arg0));
   }

   public byte[] getBytes() {
      super.preForAll(methodObject13163, this, zeroLengthObjectArray);
      return (byte[])this.postForAll(methodObject13163, (Object)this.delegate.getBytes());
   }

   public Time timeValue(Calendar arg0) throws SQLException {
      try {
         super.preForAll(methodObject13179, this, arg0);
         return (Time)this.postForAll(methodObject13179, (Object)this.delegate.timeValue(arg0));
      } catch (SQLException var3) {
         return (Time)this.postForAll(methodObject13179, this.onErrorForAll(methodObject13179, var3));
      }
   }

   public long getLastIndex() throws SQLException {
      try {
         super.preForAll(methodObject13150, this, zeroLengthObjectArray);
         return (Long)this.postForAll(methodObject13150, this.delegate.getLastIndex());
      } catch (SQLException var2) {
         return (Long)this.postForAll(methodObject13150, this.onErrorForAll(methodObject13150, var2));
      }
   }

   public void setAutoIndexing(boolean arg0) throws SQLException {
      try {
         super.preForAll(methodObject13145, this, arg0);
         this.delegate.setAutoIndexing(arg0);
      } catch (SQLException var3) {
         this.onErrorVoidForAll(methodObject13145, var3);
      }
   }

   public boolean getAutoBuffering() throws SQLException {
      try {
         super.preForAll(methodObject13143, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject13143, this.delegate.getAutoBuffering());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject13143, this.onErrorForAll(methodObject13143, var2));
      }
   }

   public InputStream binaryStreamValue() throws SQLException {
      try {
         super.preForAll(methodObject13168, this, zeroLengthObjectArray);
         return (InputStream)this.postForAll(methodObject13168, (Object)this.delegate.binaryStreamValue());
      } catch (SQLException var2) {
         return (InputStream)this.postForAll(methodObject13168, this.onErrorForAll(methodObject13168, var2));
      }
   }

   public Object getACProxy() {
      super.preForAll(methodObject13211, this, zeroLengthObjectArray);
      return this.postForAll(methodObject13211, this.proxyFactory.proxyForCache(this.delegate.getACProxy(), this, this.proxyCache, methodObject13211));
   }

   public oracle.jdbc.OracleConnection getOracleConnection() throws SQLException {
      try {
         super.preForAll(methodObject13182, this, zeroLengthObjectArray);
         return (oracle.jdbc.OracleConnection)this.postForAll(methodObject13182, this.proxyFactory.proxyForCache((Object)this.delegate.getOracleConnection(), this, this.proxyCache, methodObject13182));
      } catch (SQLException var2) {
         return (oracle.jdbc.OracleConnection)this.postForAll(methodObject13182, this.onErrorForAll(methodObject13182, var2));
      }
   }

   public ResultSet getResultSet(long arg0, int arg1) throws SQLException {
      try {
         super.preForAll(methodObject13207, this, arg0, arg1);
         return (ResultSet)this.postForAll(methodObject13207, this.proxyFactory.proxyForCreate((Object)this.delegate.getResultSet(arg0, arg1), this, this.proxyCache, methodObject13207));
      } catch (SQLException var5) {
         return (ResultSet)this.postForAll(methodObject13207, this.onErrorForAll(methodObject13207, var5));
      }
   }

   public Object toJdbc() throws SQLException {
      try {
         super.preForAll(methodObject13186, this, zeroLengthObjectArray);
         return this.postForAll(methodObject13186, this.proxyFactory.proxyForCache(this.delegate.toJdbc(), this, this.proxyCache, methodObject13186));
      } catch (SQLException var2) {
         return this.postForAll(methodObject13186, this.onErrorForAll(methodObject13186, var2));
      }
   }

   public String getBaseTypeName() throws SQLException {
      try {
         super.preForAll(methodObject13209, this, zeroLengthObjectArray);
         return (String)this.postForAll(methodObject13209, (Object)this.delegate.getBaseTypeName());
      } catch (SQLException var2) {
         return (String)this.postForAll(methodObject13209, this.onErrorForAll(methodObject13209, var2));
      }
   }

   public boolean hasDataSeg() {
      super.preForAll(methodObject13140, this, zeroLengthObjectArray);
      return (Boolean)this.postForAll(methodObject13140, this.delegate.hasDataSeg());
   }

   public long getOffset(long arg0) throws SQLException {
      try {
         super.preForAll(methodObject13128, this, arg0);
         return (Long)this.postForAll(methodObject13128, this.delegate.getOffset(arg0));
      } catch (SQLException var4) {
         return (Long)this.postForAll(methodObject13128, this.onErrorForAll(methodObject13128, var4));
      }
   }

   public Date dateValue() throws SQLException {
      try {
         super.preForAll(methodObject13177, this, zeroLengthObjectArray);
         return (Date)this.postForAll(methodObject13177, (Object)this.delegate.dateValue());
      } catch (SQLException var2) {
         return (Date)this.postForAll(methodObject13177, this.onErrorForAll(methodObject13177, var2));
      }
   }

   public void setBytes(byte[] arg0) {
      super.preForAll(methodObject13171, this, arg0);
      this.delegate.setBytes(arg0);
   }

   public BigDecimal bigDecimalValue() throws SQLException {
      try {
         super.preForAll(methodObject13176, this, zeroLengthObjectArray);
         return (BigDecimal)this.postForAll(methodObject13176, (Object)this.delegate.bigDecimalValue());
      } catch (SQLException var2) {
         return (BigDecimal)this.postForAll(methodObject13176, this.onErrorForAll(methodObject13176, var2));
      }
   }

   public short[] getShortArray(long arg0, int arg1) throws SQLException {
      try {
         super.preForAll(methodObject13194, this, arg0, arg1);
         return (short[])this.postForAll(methodObject13194, (Object)this.delegate.getShortArray(arg0, arg1));
      } catch (SQLException var5) {
         return (short[])this.postForAll(methodObject13194, this.onErrorForAll(methodObject13194, var5));
      }
   }

   public OracleTypeMetaData getOracleMetaData() throws SQLException {
      try {
         super.preForAll(methodObject13188, this, zeroLengthObjectArray);
         return (OracleTypeMetaData)this.postForAll(methodObject13188, this.proxyFactory.proxyForCache((Object)this.delegate.getOracleMetaData(), this, this.proxyCache, methodObject13188));
      } catch (SQLException var2) {
         return (OracleTypeMetaData)this.postForAll(methodObject13188, this.onErrorForAll(methodObject13188, var2));
      }
   }

   public Object makeJdbcArray(int arg0) {
      super.preForAll(methodObject13132, this, arg0);
      return this.postForAll(methodObject13132, this.proxyFactory.proxyForCache(this.delegate.makeJdbcArray(arg0), this, this.proxyCache, methodObject13132));
   }

   public float[] getFloatArray(long arg0, int arg1) throws SQLException {
      try {
         super.preForAll(methodObject13198, this, arg0, arg1);
         return (float[])this.postForAll(methodObject13198, (Object)this.delegate.getFloatArray(arg0, arg1));
      } catch (SQLException var5) {
         return (float[])this.postForAll(methodObject13198, this.onErrorForAll(methodObject13198, var5));
      }
   }

   public byte byteValue() throws SQLException {
      try {
         super.preForAll(methodObject13158, this, zeroLengthObjectArray);
         return (Byte)this.postForAll(methodObject13158, this.delegate.byteValue());
      } catch (SQLException var2) {
         return (Byte)this.postForAll(methodObject13158, this.onErrorForAll(methodObject13158, var2));
      }
   }

   public boolean getAutoIndexing() throws SQLException {
      try {
         super.preForAll(methodObject13146, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject13146, this.delegate.getAutoIndexing());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject13146, this.onErrorForAll(methodObject13146, var2));
      }
   }

   public float floatValue() throws SQLException {
      try {
         super.preForAll(methodObject13161, this, zeroLengthObjectArray);
         return (Float)this.postForAll(methodObject13161, this.delegate.floatValue());
      } catch (SQLException var2) {
         return (Float)this.postForAll(methodObject13161, this.onErrorForAll(methodObject13161, var2));
      }
   }

   public Reader characterStreamValue() throws SQLException {
      try {
         super.preForAll(methodObject13166, this, zeroLengthObjectArray);
         return (Reader)this.postForAll(methodObject13166, (Object)this.delegate.characterStreamValue());
      } catch (SQLException var2) {
         return (Reader)this.postForAll(methodObject13166, this.onErrorForAll(methodObject13166, var2));
      }
   }

   public byte[] toBytes() throws SQLException {
      try {
         super.preForAll(methodObject13135, this, zeroLengthObjectArray);
         return (byte[])this.postForAll(methodObject13135, (Object)this.delegate.toBytes());
      } catch (SQLException var2) {
         return (byte[])this.postForAll(methodObject13135, this.onErrorForAll(methodObject13135, var2));
      }
   }

   public InputStream getStream() throws SQLException {
      try {
         super.preForAll(methodObject13173, this, zeroLengthObjectArray);
         return (InputStream)this.postForAll(methodObject13173, (Object)this.delegate.getStream());
      } catch (SQLException var2) {
         return (InputStream)this.postForAll(methodObject13173, this.onErrorForAll(methodObject13173, var2));
      }
   }

   public Time timeValue() throws SQLException {
      try {
         super.preForAll(methodObject13178, this, zeroLengthObjectArray);
         return (Time)this.postForAll(methodObject13178, (Object)this.delegate.timeValue());
      } catch (SQLException var2) {
         return (Time)this.postForAll(methodObject13178, this.onErrorForAll(methodObject13178, var2));
      }
   }

   public long getLength() {
      super.preForAll(methodObject13156, this, zeroLengthObjectArray);
      return (Long)this.postForAll(methodObject13156, this.delegate.getLength());
   }

   public Object getArray(Map arg0) throws SQLException {
      try {
         super.preForAll(methodObject13200, this, arg0);
         return this.postForAll(methodObject13200, this.proxyFactory.proxyForCache(this.delegate.getArray(arg0), this, this.proxyCache, methodObject13200));
      } catch (SQLException var3) {
         return this.postForAll(methodObject13200, this.onErrorForAll(methodObject13200, var3));
      }
   }

   public ResultSet getResultSet() throws SQLException {
      try {
         super.preForAll(methodObject13205, this, zeroLengthObjectArray);
         return (ResultSet)this.postForAll(methodObject13205, this.proxyFactory.proxyForCreate((Object)this.delegate.getResultSet(), this, this.proxyCache, methodObject13205));
      } catch (SQLException var2) {
         return (ResultSet)this.postForAll(methodObject13205, this.onErrorForAll(methodObject13205, var2));
      }
   }

   public oracle.jdbc.driver.OracleConnection getConnection() throws SQLException {
      try {
         super.preForAll(methodObject13184, this, zeroLengthObjectArray);
         return (oracle.jdbc.driver.OracleConnection)this.postForAll(methodObject13184, (Object)this.delegate.getConnection());
      } catch (SQLException var2) {
         return (oracle.jdbc.driver.OracleConnection)this.postForAll(methodObject13184, this.onErrorForAll(methodObject13184, var2));
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
         methodObject13172 = OracleDatumWithConnection.class.getDeclaredMethod("setShareBytes", byte[].class);
         methodObject13131 = OracleArray.class.getDeclaredMethod("setLocator", byte[].class);
         methodObject13134 = OracleArray.class.getDeclaredMethod("getOracleArray", Long.TYPE, Integer.TYPE);
         methodObject13141 = OracleArray.class.getDeclaredMethod("isInline");
         methodObject13139 = OracleArray.class.getDeclaredMethod("setPrefixFlag", Byte.TYPE);
         methodObject13152 = OracleArray.class.getDeclaredMethod("setImage", byte[].class, Long.TYPE, Long.TYPE);
         methodObject13155 = OracleArray.class.getDeclaredMethod("getImageLength");
         methodObject13196 = oracle.jdbc.OracleArray.class.getDeclaredMethod("getLongArray", Long.TYPE, Integer.TYPE);
         methodObject13190 = oracle.jdbc.OracleArray.class.getDeclaredMethod("getIntArray", Long.TYPE, Integer.TYPE);
         methodObject13169 = OracleDatumWithConnection.class.getDeclaredMethod("getJavaSqlConnection");
         methodObject13197 = oracle.jdbc.OracleArray.class.getDeclaredMethod("getFloatArray");
         methodObject13154 = OracleArray.class.getDeclaredMethod("getImageOffset");
         methodObject13157 = OracleDatumWithConnection.class.getDeclaredMethod("booleanValue");
         methodObject13192 = oracle.jdbc.OracleArray.class.getDeclaredMethod("getDoubleArray", Long.TYPE, Integer.TYPE);
         methodObject13137 = OracleArray.class.getDeclaredMethod("setObjArray", Object.class);
         methodObject13187 = oracle.jdbc.OracleArray.class.getDeclaredMethod("getSQLTypeName");
         methodObject13206 = Array.class.getDeclaredMethod("getResultSet", Map.class);
         methodObject13189 = oracle.jdbc.OracleArray.class.getDeclaredMethod("getIntArray");
         methodObject13210 = ACProxyable.class.getDeclaredMethod("setACProxy", Object.class);
         methodObject13201 = Array.class.getDeclaredMethod("getArray", Long.TYPE, Integer.TYPE);
         methodObject13129 = OracleArray.class.getDeclaredMethod("getMap");
         methodObject13180 = OracleDatumWithConnection.class.getDeclaredMethod("timestampValue");
         methodObject13204 = Array.class.getDeclaredMethod("getBaseType");
         methodObject13183 = OracleDatumWithConnection.class.getDeclaredMethod("setPhysicalConnectionOf", Connection.class);
         methodObject13159 = OracleDatumWithConnection.class.getDeclaredMethod("intValue");
         methodObject13191 = oracle.jdbc.OracleArray.class.getDeclaredMethod("getDoubleArray");
         methodObject13174 = OracleDatumWithConnection.class.getDeclaredMethod("stringValue");
         methodObject13148 = OracleArray.class.getDeclaredMethod("setLastIndexOffset", Long.TYPE, Long.TYPE);
         methodObject13147 = OracleArray.class.getDeclaredMethod("getAccessDirection");
         methodObject13202 = Array.class.getDeclaredMethod("getArray", Long.TYPE, Integer.TYPE, Map.class);
         methodObject13175 = OracleDatumWithConnection.class.getDeclaredMethod("stringValue", Connection.class);
         methodObject13203 = Array.class.getDeclaredMethod("free");
         methodObject13127 = OracleArray.class.getDeclaredMethod("setLength", Integer.TYPE);
         methodObject13138 = OracleArray.class.getDeclaredMethod("setPrefixSegment", byte[].class);
         methodObject13167 = OracleDatumWithConnection.class.getDeclaredMethod("asciiStreamValue");
         methodObject13195 = oracle.jdbc.OracleArray.class.getDeclaredMethod("getLongArray");
         methodObject13170 = OracleDatumWithConnection.class.getDeclaredMethod("shareBytes");
         methodObject13162 = OracleDatumWithConnection.class.getDeclaredMethod("doubleValue");
         methodObject13130 = OracleArray.class.getDeclaredMethod("getLocator");
         methodObject13151 = OracleArray.class.getDeclaredMethod("getLastOffset");
         methodObject13193 = oracle.jdbc.OracleArray.class.getDeclaredMethod("getShortArray");
         methodObject13153 = OracleArray.class.getDeclaredMethod("setImageLength", Long.TYPE);
         methodObject13208 = Array.class.getDeclaredMethod("getResultSet", Long.TYPE, Integer.TYPE, Map.class);
         methodObject13160 = OracleDatumWithConnection.class.getDeclaredMethod("longValue");
         methodObject13181 = OracleDatumWithConnection.class.getDeclaredMethod("timestampValue", Calendar.class);
         methodObject13136 = OracleArray.class.getDeclaredMethod("setDatumArray", Datum[].class);
         methodObject13149 = OracleArray.class.getDeclaredMethod("setIndexOffset", Long.TYPE, Long.TYPE);
         methodObject13142 = OracleArray.class.getDeclaredMethod("setAutoBuffering", Boolean.TYPE);
         methodObject13185 = oracle.jdbc.OracleArray.class.getDeclaredMethod("length");
         methodObject13125 = OracleArray.class.getDeclaredMethod("getDescriptor");
         methodObject13164 = OracleDatumWithConnection.class.getDeclaredMethod("getInternalConnection");
         methodObject13133 = OracleArray.class.getDeclaredMethod("getOracleArray");
         methodObject13199 = Array.class.getDeclaredMethod("getArray");
         methodObject13144 = OracleArray.class.getDeclaredMethod("setAutoIndexing", Boolean.TYPE, Integer.TYPE);
         methodObject13126 = OracleArray.class.getDeclaredMethod("isConvertibleTo", Class.class);
         methodObject13163 = OracleDatumWithConnection.class.getDeclaredMethod("getBytes");
         methodObject13179 = OracleDatumWithConnection.class.getDeclaredMethod("timeValue", Calendar.class);
         methodObject13150 = OracleArray.class.getDeclaredMethod("getLastIndex");
         methodObject13145 = OracleArray.class.getDeclaredMethod("setAutoIndexing", Boolean.TYPE);
         methodObject13143 = OracleArray.class.getDeclaredMethod("getAutoBuffering");
         methodObject13168 = OracleDatumWithConnection.class.getDeclaredMethod("binaryStreamValue");
         methodObject13211 = ACProxyable.class.getDeclaredMethod("getACProxy");
         methodObject13182 = OracleDatumWithConnection.class.getDeclaredMethod("getOracleConnection");
         methodObject13207 = Array.class.getDeclaredMethod("getResultSet", Long.TYPE, Integer.TYPE);
         methodObject13186 = oracle.jdbc.OracleArray.class.getDeclaredMethod("toJdbc");
         methodObject13209 = Array.class.getDeclaredMethod("getBaseTypeName");
         methodObject13140 = OracleArray.class.getDeclaredMethod("hasDataSeg");
         methodObject13128 = OracleArray.class.getDeclaredMethod("getOffset", Long.TYPE);
         methodObject13177 = OracleDatumWithConnection.class.getDeclaredMethod("dateValue");
         methodObject13171 = OracleDatumWithConnection.class.getDeclaredMethod("setBytes", byte[].class);
         methodObject13176 = OracleDatumWithConnection.class.getDeclaredMethod("bigDecimalValue");
         methodObject13194 = oracle.jdbc.OracleArray.class.getDeclaredMethod("getShortArray", Long.TYPE, Integer.TYPE);
         methodObject13188 = oracle.jdbc.OracleArray.class.getDeclaredMethod("getOracleMetaData");
         methodObject13132 = OracleArray.class.getDeclaredMethod("makeJdbcArray", Integer.TYPE);
         methodObject13198 = oracle.jdbc.OracleArray.class.getDeclaredMethod("getFloatArray", Long.TYPE, Integer.TYPE);
         methodObject13158 = OracleDatumWithConnection.class.getDeclaredMethod("byteValue");
         methodObject13146 = OracleArray.class.getDeclaredMethod("getAutoIndexing");
         methodObject13161 = OracleDatumWithConnection.class.getDeclaredMethod("floatValue");
         methodObject13166 = OracleDatumWithConnection.class.getDeclaredMethod("characterStreamValue");
         methodObject13135 = OracleArray.class.getDeclaredMethod("toBytes");
         methodObject13173 = OracleDatumWithConnection.class.getDeclaredMethod("getStream");
         methodObject13178 = OracleDatumWithConnection.class.getDeclaredMethod("timeValue");
         methodObject13156 = OracleDatumWithConnection.class.getDeclaredMethod("getLength");
         methodObject13200 = Array.class.getDeclaredMethod("getArray", Map.class);
         methodObject13205 = Array.class.getDeclaredMethod("getResultSet");
         methodObject13184 = OracleDatumWithConnection.class.getDeclaredMethod("getConnection");
      } catch (Throwable var1) {
         throw new RuntimeException(var1);
      }
   }

   public oracle$1jdbc$1replay$1driver$1NonTxnReplayableArray$2oracle$1jdbc$1internal$1OracleArray$$$Proxy(OracleArray var1, Object var2, ProxyFactory var3, Map var4) {
      this.delegate = var1;
      this.creator = var2;
      this.proxyFactory = var3;
      this.proxyCache = var4;
   }
}
