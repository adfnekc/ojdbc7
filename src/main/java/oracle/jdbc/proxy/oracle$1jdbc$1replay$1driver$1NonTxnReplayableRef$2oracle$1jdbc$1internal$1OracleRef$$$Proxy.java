package oracle.jdbc.proxy;

import java.io.InputStream;
import java.io.Reader;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.Date;
import java.sql.Ref;
import java.sql.SQLException;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Map;
import oracle.jdbc.OracleTypeMetaData;
import oracle.jdbc.internal.ACProxyable;
import oracle.jdbc.internal.OracleConnection;
import oracle.jdbc.internal.OracleDatumWithConnection;
import oracle.jdbc.internal.OracleRef;
import oracle.jdbc.replay.driver.NonTxnReplayableRef;
import oracle.sql.STRUCT;
import oracle.sql.StructDescriptor;

public abstract class oracle$1jdbc$1replay$1driver$1NonTxnReplayableRef$2oracle$1jdbc$1internal$1OracleRef$$$Proxy extends NonTxnReplayableRef implements OracleRef, _Proxy_ {
   private OracleRef delegate;
   private final Object creator;
   private final ProxyFactory proxyFactory;
   private final Map proxyCache;
   private static Object[] zeroLengthObjectArray = new Object[0];
   private static Method methodObject23306;
   private static Method methodObject23286;
   private static Method methodObject23284;
   private static Method methodObject23299;
   private static Method methodObject23321;
   private static Method methodObject23285;
   private static Method methodObject23298;
   private static Method methodObject23303;
   private static Method methodObject23320;
   private static Method methodObject23313;
   private static Method methodObject23292;
   private static Method methodObject23282;
   private static Method methodObject23289;
   private static Method methodObject23302;
   private static Method methodObject23324;
   private static Method methodObject23314;
   private static Method methodObject23317;
   private static Method methodObject23294;
   private static Method methodObject23325;
   private static Method methodObject23316;
   private static Method methodObject23308;
   private static Method methodObject23287;
   private static Method methodObject23323;
   private static Method methodObject23322;
   private static Method methodObject23309;
   private static Method methodObject23301;
   private static Method methodObject23283;
   private static Method methodObject23311;
   private static Method methodObject23304;
   private static Method methodObject23305;
   private static Method methodObject23290;
   private static Method methodObject23297;
   private static Method methodObject23310;
   private static Method methodObject23319;
   private static Method methodObject23288;
   private static Method methodObject23295;
   private static Method methodObject23315;
   private static Method methodObject23293;
   private static Method methodObject23296;
   private static Method methodObject23300;
   private static Method methodObject23307;
   private static Method methodObject23312;
   private static Method methodObject23291;
   private static Method methodObject23318;

   public void setShareBytes(byte[] arg0) {
      super.preForAll(methodObject23306, this, arg0);
      this.delegate.setShareBytes(arg0);
   }

   public void setValue(Object arg0) throws SQLException {
      try {
         super.preForAll(methodObject23286, this, arg0);
         this.delegate.setValue(arg0 instanceof _Proxy_ ? (Object)((_Proxy_)arg0)._getDelegate_() : arg0);
      } catch (SQLException var3) {
         this.onErrorVoidForAll(methodObject23286, var3);
      }
   }

   public StructDescriptor getDescriptor() throws SQLException {
      try {
         super.preForAll(methodObject23284, this, zeroLengthObjectArray);
         return (StructDescriptor)this.postForAll(methodObject23284, (Object)this.delegate.getDescriptor());
      } catch (SQLException var2) {
         return (StructDescriptor)this.postForAll(methodObject23284, this.onErrorForAll(methodObject23284, var2));
      }
   }

   public OracleConnection getInternalConnection() throws SQLException {
      try {
         super.preForAll(methodObject23299, this, zeroLengthObjectArray);
         return (OracleConnection)this.postForAll(methodObject23299, this.proxyFactory.proxyForCache((Object)this.delegate.getInternalConnection(), this, this.proxyCache, methodObject23299));
      } catch (SQLException var2) {
         return (OracleConnection)this.postForAll(methodObject23299, this.onErrorForAll(methodObject23299, var2));
      }
   }

   public Object getObject() throws SQLException {
      try {
         super.preForAll(methodObject23321, this, zeroLengthObjectArray);
         return this.postForAll(methodObject23321, this.proxyFactory.proxyForCache(this.delegate.getObject(), this, this.proxyCache, methodObject23321));
      } catch (SQLException var2) {
         return this.postForAll(methodObject23321, this.onErrorForAll(methodObject23321, var2));
      }
   }

   public boolean isConvertibleTo(Class arg0) {
      super.preForAll(methodObject23285, this, arg0);
      return (Boolean)this.postForAll(methodObject23285, this.delegate.isConvertibleTo(arg0));
   }

   public byte[] getBytes() {
      super.preForAll(methodObject23298, this, zeroLengthObjectArray);
      return (byte[])this.postForAll(methodObject23298, (Object)this.delegate.getBytes());
   }

   public Connection getJavaSqlConnection() throws SQLException {
      try {
         super.preForAll(methodObject23303, this, zeroLengthObjectArray);
         return (Connection)this.postForAll(methodObject23303, this.proxyFactory.proxyForCache((Object)this.delegate.getJavaSqlConnection(), this, this.proxyCache, methodObject23303));
      } catch (SQLException var2) {
         return (Connection)this.postForAll(methodObject23303, this.onErrorForAll(methodObject23303, var2));
      }
   }

   public Object getObject(Map arg0) throws SQLException {
      try {
         super.preForAll(methodObject23320, this, arg0);
         return this.postForAll(methodObject23320, this.proxyFactory.proxyForCache(this.delegate.getObject(arg0), this, this.proxyCache, methodObject23320));
      } catch (SQLException var3) {
         return this.postForAll(methodObject23320, this.onErrorForAll(methodObject23320, var3));
      }
   }

   public Time timeValue(Calendar arg0) throws SQLException {
      try {
         super.preForAll(methodObject23313, this, arg0);
         return (Time)this.postForAll(methodObject23313, (Object)this.delegate.timeValue(arg0));
      } catch (SQLException var3) {
         return (Time)this.postForAll(methodObject23313, this.onErrorForAll(methodObject23313, var3));
      }
   }

   public boolean booleanValue() throws SQLException {
      try {
         super.preForAll(methodObject23292, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject23292, this.delegate.booleanValue());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject23292, this.onErrorForAll(methodObject23292, var2));
      }
   }

   public Object getValue(Map arg0) throws SQLException {
      try {
         super.preForAll(methodObject23282, this, arg0);
         return this.postForAll(methodObject23282, this.proxyFactory.proxyForCache(this.delegate.getValue(arg0), this, this.proxyCache, methodObject23282));
      } catch (SQLException var3) {
         return this.postForAll(methodObject23282, this.onErrorForAll(methodObject23282, var3));
      }
   }

   public String getSQLTypeName() throws SQLException {
      try {
         super.preForAll(methodObject23289, this, zeroLengthObjectArray);
         return (String)this.postForAll(methodObject23289, (Object)this.delegate.getSQLTypeName());
      } catch (SQLException var2) {
         return (String)this.postForAll(methodObject23289, this.onErrorForAll(methodObject23289, var2));
      }
   }

   public InputStream binaryStreamValue() throws SQLException {
      try {
         super.preForAll(methodObject23302, this, zeroLengthObjectArray);
         return (InputStream)this.postForAll(methodObject23302, (Object)this.delegate.binaryStreamValue());
      } catch (SQLException var2) {
         return (InputStream)this.postForAll(methodObject23302, this.onErrorForAll(methodObject23302, var2));
      }
   }

   public void setACProxy(Object arg0) {
      super.preForAll(methodObject23324, this, arg0);
      this.delegate.setACProxy(arg0 instanceof _Proxy_ ? (Object)((_Proxy_)arg0)._getDelegate_() : arg0);
   }

   public Timestamp timestampValue() throws SQLException {
      try {
         super.preForAll(methodObject23314, this, zeroLengthObjectArray);
         return (Timestamp)this.postForAll(methodObject23314, (Object)this.delegate.timestampValue());
      } catch (SQLException var2) {
         return (Timestamp)this.postForAll(methodObject23314, this.onErrorForAll(methodObject23314, var2));
      }
   }

   public void setPhysicalConnectionOf(Connection arg0) {
      super.preForAll(methodObject23317, this, arg0);
      this.delegate.setPhysicalConnectionOf(arg0 instanceof _Proxy_ ? (Connection)((_Proxy_)arg0)._getDelegate_() : arg0);
   }

   public int intValue() throws SQLException {
      try {
         super.preForAll(methodObject23294, this, zeroLengthObjectArray);
         return (Integer)this.postForAll(methodObject23294, this.delegate.intValue());
      } catch (SQLException var2) {
         return (Integer)this.postForAll(methodObject23294, this.onErrorForAll(methodObject23294, var2));
      }
   }

   public Object getACProxy() {
      super.preForAll(methodObject23325, this, zeroLengthObjectArray);
      return this.postForAll(methodObject23325, this.proxyFactory.proxyForCache(this.delegate.getACProxy(), this, this.proxyCache, methodObject23325));
   }

   public oracle.jdbc.OracleConnection getOracleConnection() throws SQLException {
      try {
         super.preForAll(methodObject23316, this, zeroLengthObjectArray);
         return (oracle.jdbc.OracleConnection)this.postForAll(methodObject23316, this.proxyFactory.proxyForCache((Object)this.delegate.getOracleConnection(), this, this.proxyCache, methodObject23316));
      } catch (SQLException var2) {
         return (oracle.jdbc.OracleConnection)this.postForAll(methodObject23316, this.onErrorForAll(methodObject23316, var2));
      }
   }

   public String stringValue() throws SQLException {
      try {
         super.preForAll(methodObject23308, this, zeroLengthObjectArray);
         return (String)this.postForAll(methodObject23308, (Object)this.delegate.stringValue());
      } catch (SQLException var2) {
         return (String)this.postForAll(methodObject23308, this.onErrorForAll(methodObject23308, var2));
      }
   }

   public Object toJdbc() throws SQLException {
      try {
         super.preForAll(methodObject23287, this, zeroLengthObjectArray);
         return this.postForAll(methodObject23287, this.proxyFactory.proxyForCache(this.delegate.toJdbc(), this, this.proxyCache, methodObject23287));
      } catch (SQLException var2) {
         return this.postForAll(methodObject23287, this.onErrorForAll(methodObject23287, var2));
      }
   }

   public void setObject(Object arg0) throws SQLException {
      try {
         super.preForAll(methodObject23323, this, arg0);
         this.delegate.setObject(arg0 instanceof _Proxy_ ? (Object)((_Proxy_)arg0)._getDelegate_() : arg0);
      } catch (SQLException var3) {
         this.onErrorVoidForAll(methodObject23323, var3);
      }
   }

   public String getBaseTypeName() throws SQLException {
      try {
         super.preForAll(methodObject23322, this, zeroLengthObjectArray);
         return (String)this.postForAll(methodObject23322, (Object)this.delegate.getBaseTypeName());
      } catch (SQLException var2) {
         return (String)this.postForAll(methodObject23322, this.onErrorForAll(methodObject23322, var2));
      }
   }

   public String stringValue(Connection arg0) throws SQLException {
      try {
         super.preForAll(methodObject23309, this, arg0);
         return (String)this.postForAll(methodObject23309, (Object)this.delegate.stringValue(arg0 instanceof _Proxy_ ? (Connection)((_Proxy_)arg0)._getDelegate_() : arg0));
      } catch (SQLException var3) {
         return (String)this.postForAll(methodObject23309, this.onErrorForAll(methodObject23309, var3));
      }
   }

   public InputStream asciiStreamValue() throws SQLException {
      try {
         super.preForAll(methodObject23301, this, zeroLengthObjectArray);
         return (InputStream)this.postForAll(methodObject23301, (Object)this.delegate.asciiStreamValue());
      } catch (SQLException var2) {
         return (InputStream)this.postForAll(methodObject23301, this.onErrorForAll(methodObject23301, var2));
      }
   }

   public Object getValue() throws SQLException {
      try {
         super.preForAll(methodObject23283, this, zeroLengthObjectArray);
         return this.postForAll(methodObject23283, this.proxyFactory.proxyForCache(this.delegate.getValue(), this, this.proxyCache, methodObject23283));
      } catch (SQLException var2) {
         return this.postForAll(methodObject23283, this.onErrorForAll(methodObject23283, var2));
      }
   }

   public Date dateValue() throws SQLException {
      try {
         super.preForAll(methodObject23311, this, zeroLengthObjectArray);
         return (Date)this.postForAll(methodObject23311, (Object)this.delegate.dateValue());
      } catch (SQLException var2) {
         return (Date)this.postForAll(methodObject23311, this.onErrorForAll(methodObject23311, var2));
      }
   }

   public byte[] shareBytes() {
      super.preForAll(methodObject23304, this, zeroLengthObjectArray);
      return (byte[])this.postForAll(methodObject23304, (Object)this.delegate.shareBytes());
   }

   public void setBytes(byte[] arg0) {
      super.preForAll(methodObject23305, this, arg0);
      this.delegate.setBytes(arg0);
   }

   public STRUCT getSTRUCT() throws SQLException {
      try {
         super.preForAll(methodObject23290, this, zeroLengthObjectArray);
         return (STRUCT)this.postForAll(methodObject23290, (Object)this.delegate.getSTRUCT());
      } catch (SQLException var2) {
         return (STRUCT)this.postForAll(methodObject23290, this.onErrorForAll(methodObject23290, var2));
      }
   }

   public double doubleValue() throws SQLException {
      try {
         super.preForAll(methodObject23297, this, zeroLengthObjectArray);
         return (Double)this.postForAll(methodObject23297, this.delegate.doubleValue());
      } catch (SQLException var2) {
         return (Double)this.postForAll(methodObject23297, this.onErrorForAll(methodObject23297, var2));
      }
   }

   public BigDecimal bigDecimalValue() throws SQLException {
      try {
         super.preForAll(methodObject23310, this, zeroLengthObjectArray);
         return (BigDecimal)this.postForAll(methodObject23310, (Object)this.delegate.bigDecimalValue());
      } catch (SQLException var2) {
         return (BigDecimal)this.postForAll(methodObject23310, this.onErrorForAll(methodObject23310, var2));
      }
   }

   public OracleTypeMetaData getOracleMetaData() throws SQLException {
      try {
         super.preForAll(methodObject23319, this, zeroLengthObjectArray);
         return (OracleTypeMetaData)this.postForAll(methodObject23319, this.proxyFactory.proxyForCache((Object)this.delegate.getOracleMetaData(), this, this.proxyCache, methodObject23319));
      } catch (SQLException var2) {
         return (OracleTypeMetaData)this.postForAll(methodObject23319, this.onErrorForAll(methodObject23319, var2));
      }
   }

   public Object makeJdbcArray(int arg0) {
      super.preForAll(methodObject23288, this, arg0);
      return this.postForAll(methodObject23288, this.proxyFactory.proxyForCache(this.delegate.makeJdbcArray(arg0), this, this.proxyCache, methodObject23288));
   }

   @Override
   public Object clone() throws CloneNotSupportedException {
      return null;
   }

   public long longValue() throws SQLException {
      try {
         super.preForAll(methodObject23295, this, zeroLengthObjectArray);
         return (Long)this.postForAll(methodObject23295, this.delegate.longValue());
      } catch (SQLException var2) {
         return (Long)this.postForAll(methodObject23295, this.onErrorForAll(methodObject23295, var2));
      }
   }

   public Timestamp timestampValue(Calendar arg0) throws SQLException {
      try {
         super.preForAll(methodObject23315, this, arg0);
         return (Timestamp)this.postForAll(methodObject23315, (Object)this.delegate.timestampValue(arg0));
      } catch (SQLException var3) {
         return (Timestamp)this.postForAll(methodObject23315, this.onErrorForAll(methodObject23315, var3));
      }
   }

   public byte byteValue() throws SQLException {
      try {
         super.preForAll(methodObject23293, this, zeroLengthObjectArray);
         return (Byte)this.postForAll(methodObject23293, this.delegate.byteValue());
      } catch (SQLException var2) {
         return (Byte)this.postForAll(methodObject23293, this.onErrorForAll(methodObject23293, var2));
      }
   }

   public float floatValue() throws SQLException {
      try {
         super.preForAll(methodObject23296, this, zeroLengthObjectArray);
         return (Float)this.postForAll(methodObject23296, this.delegate.floatValue());
      } catch (SQLException var2) {
         return (Float)this.postForAll(methodObject23296, this.onErrorForAll(methodObject23296, var2));
      }
   }

   public Reader characterStreamValue() throws SQLException {
      try {
         super.preForAll(methodObject23300, this, zeroLengthObjectArray);
         return (Reader)this.postForAll(methodObject23300, (Object)this.delegate.characterStreamValue());
      } catch (SQLException var2) {
         return (Reader)this.postForAll(methodObject23300, this.onErrorForAll(methodObject23300, var2));
      }
   }

   public InputStream getStream() throws SQLException {
      try {
         super.preForAll(methodObject23307, this, zeroLengthObjectArray);
         return (InputStream)this.postForAll(methodObject23307, (Object)this.delegate.getStream());
      } catch (SQLException var2) {
         return (InputStream)this.postForAll(methodObject23307, this.onErrorForAll(methodObject23307, var2));
      }
   }

   public Time timeValue() throws SQLException {
      try {
         super.preForAll(methodObject23312, this, zeroLengthObjectArray);
         return (Time)this.postForAll(methodObject23312, (Object)this.delegate.timeValue());
      } catch (SQLException var2) {
         return (Time)this.postForAll(methodObject23312, this.onErrorForAll(methodObject23312, var2));
      }
   }

   public long getLength() {
      super.preForAll(methodObject23291, this, zeroLengthObjectArray);
      return (Long)this.postForAll(methodObject23291, this.delegate.getLength());
   }

   public oracle.jdbc.driver.OracleConnection getConnection() throws SQLException {
      try {
         super.preForAll(methodObject23318, this, zeroLengthObjectArray);
         return (oracle.jdbc.driver.OracleConnection)this.postForAll(methodObject23318, (Object)this.delegate.getConnection());
      } catch (SQLException var2) {
         return (oracle.jdbc.driver.OracleConnection)this.postForAll(methodObject23318, this.onErrorForAll(methodObject23318, var2));
      }
   }

   public OracleRef _getDelegate_() {
      return this.delegate;
   }

   public Object getDelegate() {
      return this.delegate;
   }

   public void setDelegate(Object delegate) {
      this.proxyFactory.updateDelegate(this, this.delegate, delegate);
      this.delegate = (OracleRef)delegate;
   }

   public Object getCreator() {
      return this.creator;
   }

   static {
      try {
         methodObject23306 = OracleDatumWithConnection.class.getDeclaredMethod("setShareBytes", byte[].class);
         methodObject23286 = OracleRef.class.getDeclaredMethod("setValue", Object.class);
         methodObject23284 = OracleRef.class.getDeclaredMethod("getDescriptor");
         methodObject23299 = OracleDatumWithConnection.class.getDeclaredMethod("getInternalConnection");
         methodObject23321 = Ref.class.getDeclaredMethod("getObject");
         methodObject23285 = OracleRef.class.getDeclaredMethod("isConvertibleTo", Class.class);
         methodObject23298 = OracleDatumWithConnection.class.getDeclaredMethod("getBytes");
         methodObject23303 = OracleDatumWithConnection.class.getDeclaredMethod("getJavaSqlConnection");
         methodObject23320 = Ref.class.getDeclaredMethod("getObject", Map.class);
         methodObject23313 = OracleDatumWithConnection.class.getDeclaredMethod("timeValue", Calendar.class);
         methodObject23292 = OracleDatumWithConnection.class.getDeclaredMethod("booleanValue");
         methodObject23282 = OracleRef.class.getDeclaredMethod("getValue", Map.class);
         methodObject23289 = OracleRef.class.getDeclaredMethod("getSQLTypeName");
         methodObject23302 = OracleDatumWithConnection.class.getDeclaredMethod("binaryStreamValue");
         methodObject23324 = ACProxyable.class.getDeclaredMethod("setACProxy", Object.class);
         methodObject23314 = OracleDatumWithConnection.class.getDeclaredMethod("timestampValue");
         methodObject23317 = OracleDatumWithConnection.class.getDeclaredMethod("setPhysicalConnectionOf", Connection.class);
         methodObject23294 = OracleDatumWithConnection.class.getDeclaredMethod("intValue");
         methodObject23325 = ACProxyable.class.getDeclaredMethod("getACProxy");
         methodObject23316 = OracleDatumWithConnection.class.getDeclaredMethod("getOracleConnection");
         methodObject23308 = OracleDatumWithConnection.class.getDeclaredMethod("stringValue");
         methodObject23287 = OracleRef.class.getDeclaredMethod("toJdbc");
         methodObject23323 = Ref.class.getDeclaredMethod("setObject", Object.class);
         methodObject23322 = Ref.class.getDeclaredMethod("getBaseTypeName");
         methodObject23309 = OracleDatumWithConnection.class.getDeclaredMethod("stringValue", Connection.class);
         methodObject23301 = OracleDatumWithConnection.class.getDeclaredMethod("asciiStreamValue");
         methodObject23283 = OracleRef.class.getDeclaredMethod("getValue");
         methodObject23311 = OracleDatumWithConnection.class.getDeclaredMethod("dateValue");
         methodObject23304 = OracleDatumWithConnection.class.getDeclaredMethod("shareBytes");
         methodObject23305 = OracleDatumWithConnection.class.getDeclaredMethod("setBytes", byte[].class);
         methodObject23290 = OracleRef.class.getDeclaredMethod("getSTRUCT");
         methodObject23297 = OracleDatumWithConnection.class.getDeclaredMethod("doubleValue");
         methodObject23310 = OracleDatumWithConnection.class.getDeclaredMethod("bigDecimalValue");
         methodObject23319 = oracle.jdbc.OracleRef.class.getDeclaredMethod("getOracleMetaData");
         methodObject23288 = OracleRef.class.getDeclaredMethod("makeJdbcArray", Integer.TYPE);
         methodObject23295 = OracleDatumWithConnection.class.getDeclaredMethod("longValue");
         methodObject23315 = OracleDatumWithConnection.class.getDeclaredMethod("timestampValue", Calendar.class);
         methodObject23293 = OracleDatumWithConnection.class.getDeclaredMethod("byteValue");
         methodObject23296 = OracleDatumWithConnection.class.getDeclaredMethod("floatValue");
         methodObject23300 = OracleDatumWithConnection.class.getDeclaredMethod("characterStreamValue");
         methodObject23307 = OracleDatumWithConnection.class.getDeclaredMethod("getStream");
         methodObject23312 = OracleDatumWithConnection.class.getDeclaredMethod("timeValue");
         methodObject23291 = OracleDatumWithConnection.class.getDeclaredMethod("getLength");
         methodObject23318 = OracleDatumWithConnection.class.getDeclaredMethod("getConnection");
      } catch (Throwable var1) {
         throw new RuntimeException(var1);
      }
   }

   public oracle$1jdbc$1replay$1driver$1NonTxnReplayableRef$2oracle$1jdbc$1internal$1OracleRef$$$Proxy(OracleRef var1, Object var2, ProxyFactory var3, Map var4) {
      this.delegate = var1;
      this.creator = var2;
      this.proxyFactory = var3;
      this.proxyCache = var4;
   }

   @Override
   public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
      return null;
   }
}
