package oracle.jdbc.proxy;

import java.io.InputStream;
import java.io.Reader;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Struct;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Hashtable;
import java.util.Map;
import oracle.jdbc.OracleTypeMetaData;
import oracle.jdbc.internal.ACProxyable;
import oracle.jdbc.internal.OracleConnection;
import oracle.jdbc.internal.OracleDatumWithConnection;
import oracle.jdbc.internal.OracleStruct;
import oracle.jdbc.replay.driver.NonTxnReplayableStruct;
import oracle.sql.Datum;
import oracle.sql.ORADataFactory;
import oracle.sql.StructDescriptor;

public abstract class oracle$1jdbc$1replay$1driver$1NonTxnReplayableStruct$2oracle$1jdbc$1internal$1OracleStruct$$$Proxy extends NonTxnReplayableStruct implements OracleStruct, _Proxy_ {
   private OracleStruct delegate;
   private final Object creator;
   private final ProxyFactory proxyFactory;
   private final Map proxyCache;
   private static Object[] zeroLengthObjectArray = new Object[0];
   private static Method methodObject25342;
   private static Method methodObject25359;
   private static Method methodObject25374;
   private static Method methodObject25373;
   private static Method methodObject25338;
   private static Method methodObject25341;
   private static Method methodObject25331;
   private static Method methodObject25335;
   private static Method methodObject25346;
   private static Method methodObject25340;
   private static Method methodObject25375;
   private static Method methodObject25376;
   private static Method methodObject25343;
   private static Method methodObject25327;
   private static Method methodObject25367;
   private static Method methodObject25348;
   private static Method methodObject25370;
   private static Method methodObject25361;
   private static Method methodObject25362;
   private static Method methodObject25355;
   private static Method methodObject25357;
   private static Method methodObject25351;
   private static Method methodObject25339;
   private static Method methodObject25349;
   private static Method methodObject25325;
   private static Method methodObject25368;
   private static Method methodObject25334;
   private static Method methodObject25336;
   private static Method methodObject25332;
   private static Method methodObject25323;
   private static Method methodObject25353;
   private static Method methodObject25326;
   private static Method methodObject25352;
   private static Method methodObject25366;
   private static Method methodObject25337;
   private static Method methodObject25356;
   private static Method methodObject25344;
   private static Method methodObject25324;
   private static Method methodObject25377;
   private static Method methodObject25369;
   private static Method methodObject25328;
   private static Method methodObject25364;
   private static Method methodObject25358;
   private static Method methodObject25363;
   private static Method methodObject25372;
   private static Method methodObject25330;
   private static Method methodObject25329;
   private static Method methodObject25347;
   private static Method methodObject25350;
   private static Method methodObject25354;
   private static Method methodObject25333;
   private static Method methodObject25360;
   private static Method methodObject25345;
   private static Method methodObject25365;
   private static Method methodObject25371;

   public boolean isInHierarchyOf(String arg0) throws SQLException {
      try {
         super.preForAll(methodObject25342, this, arg0);
         return (Boolean)this.postForAll(methodObject25342, this.delegate.isInHierarchyOf(arg0));
      } catch (SQLException var3) {
         return (Boolean)this.postForAll(methodObject25342, this.onErrorForAll(methodObject25342, var3));
      }
   }

   public void setShareBytes(byte[] arg0) {
      super.preForAll(methodObject25359, this, arg0);
      this.delegate.setShareBytes(arg0);
   }

   public Object[] getAttributes(Map arg0) throws SQLException {
      try {
         super.preForAll(methodObject25374, this, arg0);
         return (Object[])this.postForAll(methodObject25374, (Object)this.delegate.getAttributes(arg0));
      } catch (SQLException var3) {
         return (Object[])this.postForAll(methodObject25374, this.onErrorForAll(methodObject25374, var3));
      }
   }

   public Object[] getAttributes() throws SQLException {
      try {
         super.preForAll(methodObject25373, this, zeroLengthObjectArray);
         return (Object[])this.postForAll(methodObject25373, (Object)this.delegate.getAttributes());
      } catch (SQLException var2) {
         return (Object[])this.postForAll(methodObject25373, this.onErrorForAll(methodObject25373, var2));
      }
   }

   public void setImage(byte[] arg0, long arg1, long arg2) throws SQLException {
      try {
         super.preForAll(methodObject25338, this, arg0, arg1, arg2);
         this.delegate.setImage(arg0, arg1, arg2);
      } catch (SQLException var7) {
         this.onErrorVoidForAll(methodObject25338, var7);
      }
   }

   public long getImageLength() {
      super.preForAll(methodObject25341, this, zeroLengthObjectArray);
      return (Long)this.postForAll(methodObject25341, this.delegate.getImageLength());
   }

   public Connection getJavaSqlConnection() throws SQLException {
      try {
         super.preForAll(methodObject25331, this, zeroLengthObjectArray);
         return (Connection)this.postForAll(methodObject25331, (Object)super.getJavaSqlConnection());
      } catch (SQLException var2) {
         return (Connection)this.postForAll(methodObject25331, this.onErrorForAll(methodObject25331, var2));
      }
   }

   public void setObjArray(Object[] arg0) throws SQLException {
      try {
         super.preForAll(methodObject25335, this, (Object)arg0);
         this.delegate.setObjArray(arg0);
      } catch (SQLException var3) {
         this.onErrorVoidForAll(methodObject25335, var3);
      }
   }

   public boolean booleanValue() throws SQLException {
      try {
         super.preForAll(methodObject25346, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject25346, this.delegate.booleanValue());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject25346, this.onErrorForAll(methodObject25346, var2));
      }
   }

   public long getImageOffset() {
      super.preForAll(methodObject25340, this, zeroLengthObjectArray);
      return (Long)this.postForAll(methodObject25340, this.delegate.getImageOffset());
   }

   public String getSQLTypeName() throws SQLException {
      try {
         super.preForAll(methodObject25375, this, zeroLengthObjectArray);
         return (String)this.postForAll(methodObject25375, (Object)this.delegate.getSQLTypeName());
      } catch (SQLException var2) {
         return (String)this.postForAll(methodObject25375, this.onErrorForAll(methodObject25375, var2));
      }
   }

   public void setACProxy(Object arg0) {
      super.preForAll(methodObject25376, this, arg0);
      this.delegate.setACProxy(arg0 instanceof _Proxy_ ? (Object)((_Proxy_)arg0)._getDelegate_() : arg0);
   }

   public void setDescriptor(StructDescriptor arg0) {
      super.preForAll(methodObject25343, this, arg0);
      this.delegate.setDescriptor(arg0);
   }

   public Map getMap() {
      super.preForAll(methodObject25327, this, zeroLengthObjectArray);
      return (Map)this.postForAll(methodObject25327, (Object)this.delegate.getMap());
   }

   public Timestamp timestampValue() throws SQLException {
      try {
         super.preForAll(methodObject25367, this, zeroLengthObjectArray);
         return (Timestamp)this.postForAll(methodObject25367, (Object)this.delegate.timestampValue());
      } catch (SQLException var2) {
         return (Timestamp)this.postForAll(methodObject25367, this.onErrorForAll(methodObject25367, var2));
      }
   }

   public int intValue() throws SQLException {
      try {
         super.preForAll(methodObject25348, this, zeroLengthObjectArray);
         return (Integer)this.postForAll(methodObject25348, this.delegate.intValue());
      } catch (SQLException var2) {
         return (Integer)this.postForAll(methodObject25348, this.onErrorForAll(methodObject25348, var2));
      }
   }

   public void setPhysicalConnectionOf(Connection arg0) {
      super.preForAll(methodObject25370, this, arg0);
      this.delegate.setPhysicalConnectionOf(arg0 instanceof _Proxy_ ? (Connection)((_Proxy_)arg0)._getDelegate_() : arg0);
   }

   public String stringValue() throws SQLException {
      try {
         super.preForAll(methodObject25361, this, zeroLengthObjectArray);
         return (String)this.postForAll(methodObject25361, (Object)this.delegate.stringValue());
      } catch (SQLException var2) {
         return (String)this.postForAll(methodObject25361, this.onErrorForAll(methodObject25361, var2));
      }
   }

   public String stringValue(Connection arg0) throws SQLException {
      try {
         super.preForAll(methodObject25362, this, arg0);
         return (String)this.postForAll(methodObject25362, (Object)this.delegate.stringValue(arg0 instanceof _Proxy_ ? (Connection)((_Proxy_)arg0)._getDelegate_() : arg0));
      } catch (SQLException var3) {
         return (String)this.postForAll(methodObject25362, this.onErrorForAll(methodObject25362, var3));
      }
   }

   public InputStream asciiStreamValue() throws SQLException {
      try {
         super.preForAll(methodObject25355, this, zeroLengthObjectArray);
         return (InputStream)this.postForAll(methodObject25355, (Object)this.delegate.asciiStreamValue());
      } catch (SQLException var2) {
         return (InputStream)this.postForAll(methodObject25355, this.onErrorForAll(methodObject25355, var2));
      }
   }

   public byte[] shareBytes() {
      super.preForAll(methodObject25357, this, zeroLengthObjectArray);
      return (byte[])this.postForAll(methodObject25357, (Object)this.delegate.shareBytes());
   }

   public double doubleValue() throws SQLException {
      try {
         super.preForAll(methodObject25351, this, zeroLengthObjectArray);
         return (Double)this.postForAll(methodObject25351, this.delegate.doubleValue());
      } catch (SQLException var2) {
         return (Double)this.postForAll(methodObject25351, this.onErrorForAll(methodObject25351, var2));
      }
   }

   public void setImageLength(long arg0) throws SQLException {
      try {
         super.preForAll(methodObject25339, this, arg0);
         this.delegate.setImageLength(arg0);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject25339, var4);
      }
   }

   public long longValue() throws SQLException {
      try {
         super.preForAll(methodObject25349, this, zeroLengthObjectArray);
         return (Long)this.postForAll(methodObject25349, this.delegate.longValue());
      } catch (SQLException var2) {
         return (Long)this.postForAll(methodObject25349, this.onErrorForAll(methodObject25349, var2));
      }
   }

   public Object toClass(Class arg0, Map arg1) throws SQLException {
      try {
         super.preForAll(methodObject25325, this, arg0, arg1);
         return this.postForAll(methodObject25325, this.proxyFactory.proxyForCache(this.delegate.toClass(arg0, arg1), this, this.proxyCache, methodObject25325));
      } catch (SQLException var4) {
         return this.postForAll(methodObject25325, this.onErrorForAll(methodObject25325, var4));
      }
   }

   public Timestamp timestampValue(Calendar arg0) throws SQLException {
      try {
         super.preForAll(methodObject25368, this, arg0);
         return (Timestamp)this.postForAll(methodObject25368, (Object)this.delegate.timestampValue(arg0));
      } catch (SQLException var3) {
         return (Timestamp)this.postForAll(methodObject25368, this.onErrorForAll(methodObject25368, var3));
      }
   }

   public void setDatumArray(Datum[] arg0) {
      super.preForAll(methodObject25334, this, arg0);
      this.delegate.setDatumArray(arg0);
   }

   public void setAutoBuffering(boolean arg0) throws SQLException {
      try {
         super.preForAll(methodObject25336, this, arg0);
         this.delegate.setAutoBuffering(arg0);
      } catch (SQLException var3) {
         this.onErrorVoidForAll(methodObject25336, var3);
      }
   }

   public ORADataFactory getORADataFactory(Hashtable arg0, String arg1) throws SQLException {
      try {
         super.preForAll(methodObject25332, this, arg0, arg1);
         return (ORADataFactory)this.postForAll(methodObject25332, (Object)this.delegate.getORADataFactory(arg0, arg1));
      } catch (SQLException var4) {
         return (ORADataFactory)this.postForAll(methodObject25332, this.onErrorForAll(methodObject25332, var4));
      }
   }

   public StructDescriptor getDescriptor() throws SQLException {
      try {
         super.preForAll(methodObject25323, this, zeroLengthObjectArray);
         return (StructDescriptor)this.postForAll(methodObject25323, (Object)this.delegate.getDescriptor());
      } catch (SQLException var2) {
         return (StructDescriptor)this.postForAll(methodObject25323, this.onErrorForAll(methodObject25323, var2));
      }
   }

   public OracleConnection getInternalConnection() throws SQLException {
      try {
         super.preForAll(methodObject25353, this, zeroLengthObjectArray);
         return (OracleConnection)this.postForAll(methodObject25353, this.proxyFactory.proxyForCache((Object)this.delegate.getInternalConnection(), this, this.proxyCache, methodObject25353));
      } catch (SQLException var2) {
         return (OracleConnection)this.postForAll(methodObject25353, this.onErrorForAll(methodObject25353, var2));
      }
   }

   public boolean isConvertibleTo(Class arg0) {
      super.preForAll(methodObject25326, this, arg0);
      return (Boolean)this.postForAll(methodObject25326, this.delegate.isConvertibleTo(arg0));
   }

   public byte[] getBytes() {
      super.preForAll(methodObject25352, this, zeroLengthObjectArray);
      return (byte[])this.postForAll(methodObject25352, (Object)this.delegate.getBytes());
   }

   public Time timeValue(Calendar arg0) throws SQLException {
      try {
         super.preForAll(methodObject25366, this, arg0);
         return (Time)this.postForAll(methodObject25366, (Object)this.delegate.timeValue(arg0));
      } catch (SQLException var3) {
         return (Time)this.postForAll(methodObject25366, this.onErrorForAll(methodObject25366, var3));
      }
   }

   public boolean getAutoBuffering() throws SQLException {
      try {
         super.preForAll(methodObject25337, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject25337, this.delegate.getAutoBuffering());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject25337, this.onErrorForAll(methodObject25337, var2));
      }
   }

   public InputStream binaryStreamValue() throws SQLException {
      try {
         super.preForAll(methodObject25356, this, zeroLengthObjectArray);
         return (InputStream)this.postForAll(methodObject25356, (Object)this.delegate.binaryStreamValue());
      } catch (SQLException var2) {
         return (InputStream)this.postForAll(methodObject25356, this.onErrorForAll(methodObject25356, var2));
      }
   }

   public Datum[] getOracleAttributes() throws SQLException {
      try {
         super.preForAll(methodObject25344, this, zeroLengthObjectArray);
         return (Datum[])this.postForAll(methodObject25344, (Object)this.delegate.getOracleAttributes());
      } catch (SQLException var2) {
         return (Datum[])this.postForAll(methodObject25344, this.onErrorForAll(methodObject25344, var2));
      }
   }

   public Object toClass(Class arg0) throws SQLException {
      try {
         super.preForAll(methodObject25324, this, arg0);
         return this.postForAll(methodObject25324, this.proxyFactory.proxyForCache(this.delegate.toClass(arg0), this, this.proxyCache, methodObject25324));
      } catch (SQLException var3) {
         return this.postForAll(methodObject25324, this.onErrorForAll(methodObject25324, var3));
      }
   }

   public Object getACProxy() {
      super.preForAll(methodObject25377, this, zeroLengthObjectArray);
      return this.postForAll(methodObject25377, this.proxyFactory.proxyForCache(this.delegate.getACProxy(), this, this.proxyCache, methodObject25377));
   }

   public oracle.jdbc.OracleConnection getOracleConnection() throws SQLException {
      try {
         super.preForAll(methodObject25369, this, zeroLengthObjectArray);
         return (oracle.jdbc.OracleConnection)this.postForAll(methodObject25369, this.proxyFactory.proxyForCache((Object)this.delegate.getOracleConnection(), this, this.proxyCache, methodObject25369));
      } catch (SQLException var2) {
         return (oracle.jdbc.OracleConnection)this.postForAll(methodObject25369, this.onErrorForAll(methodObject25369, var2));
      }
   }

   public Object toJdbc() throws SQLException {
      try {
         super.preForAll(methodObject25328, this, zeroLengthObjectArray);
         return this.postForAll(methodObject25328, this.proxyFactory.proxyForCache(this.delegate.toJdbc(), this, this.proxyCache, methodObject25328));
      } catch (SQLException var2) {
         return this.postForAll(methodObject25328, this.onErrorForAll(methodObject25328, var2));
      }
   }

   public Date dateValue() throws SQLException {
      try {
         super.preForAll(methodObject25364, this, zeroLengthObjectArray);
         return (Date)this.postForAll(methodObject25364, (Object)this.delegate.dateValue());
      } catch (SQLException var2) {
         return (Date)this.postForAll(methodObject25364, this.onErrorForAll(methodObject25364, var2));
      }
   }

   public void setBytes(byte[] arg0) {
      super.preForAll(methodObject25358, this, arg0);
      this.delegate.setBytes(arg0);
   }

   public BigDecimal bigDecimalValue() throws SQLException {
      try {
         super.preForAll(methodObject25363, this, zeroLengthObjectArray);
         return (BigDecimal)this.postForAll(methodObject25363, (Object)this.delegate.bigDecimalValue());
      } catch (SQLException var2) {
         return (BigDecimal)this.postForAll(methodObject25363, this.onErrorForAll(methodObject25363, var2));
      }
   }

   public OracleTypeMetaData getOracleMetaData() throws SQLException {
      try {
         super.preForAll(methodObject25372, this, zeroLengthObjectArray);
         return (OracleTypeMetaData)this.postForAll(methodObject25372, this.proxyFactory.proxyForCache((Object)this.delegate.getOracleMetaData(), this, this.proxyCache, methodObject25372));
      } catch (SQLException var2) {
         return (OracleTypeMetaData)this.postForAll(methodObject25372, this.onErrorForAll(methodObject25372, var2));
      }
   }

   public Object makeJdbcArray(int arg0) {
      super.preForAll(methodObject25330, this, arg0);
      return this.postForAll(methodObject25330, this.proxyFactory.proxyForCache(this.delegate.makeJdbcArray(arg0), this, this.proxyCache, methodObject25330));
   }

   public Object toJdbc(Map arg0) throws SQLException {
      try {
         super.preForAll(methodObject25329, this, arg0);
         return this.postForAll(methodObject25329, this.proxyFactory.proxyForCache(this.delegate.toJdbc(arg0), this, this.proxyCache, methodObject25329));
      } catch (SQLException var3) {
         return this.postForAll(methodObject25329, this.onErrorForAll(methodObject25329, var3));
      }
   }

   public byte byteValue() throws SQLException {
      try {
         super.preForAll(methodObject25347, this, zeroLengthObjectArray);
         return (Byte)this.postForAll(methodObject25347, this.delegate.byteValue());
      } catch (SQLException var2) {
         return (Byte)this.postForAll(methodObject25347, this.onErrorForAll(methodObject25347, var2));
      }
   }

   public float floatValue() throws SQLException {
      try {
         super.preForAll(methodObject25350, this, zeroLengthObjectArray);
         return (Float)this.postForAll(methodObject25350, this.delegate.floatValue());
      } catch (SQLException var2) {
         return (Float)this.postForAll(methodObject25350, this.onErrorForAll(methodObject25350, var2));
      }
   }

   public Reader characterStreamValue() throws SQLException {
      try {
         super.preForAll(methodObject25354, this, zeroLengthObjectArray);
         return (Reader)this.postForAll(methodObject25354, (Object)this.delegate.characterStreamValue());
      } catch (SQLException var2) {
         return (Reader)this.postForAll(methodObject25354, this.onErrorForAll(methodObject25354, var2));
      }
   }

   public byte[] toBytes() throws SQLException {
      try {
         super.preForAll(methodObject25333, this, zeroLengthObjectArray);
         return (byte[])this.postForAll(methodObject25333, (Object)this.delegate.toBytes());
      } catch (SQLException var2) {
         return (byte[])this.postForAll(methodObject25333, this.onErrorForAll(methodObject25333, var2));
      }
   }

   public InputStream getStream() throws SQLException {
      try {
         super.preForAll(methodObject25360, this, zeroLengthObjectArray);
         return (InputStream)this.postForAll(methodObject25360, (Object)this.delegate.getStream());
      } catch (SQLException var2) {
         return (InputStream)this.postForAll(methodObject25360, this.onErrorForAll(methodObject25360, var2));
      }
   }

   public long getLength() {
      super.preForAll(methodObject25345, this, zeroLengthObjectArray);
      return (Long)this.postForAll(methodObject25345, this.delegate.getLength());
   }

   public Time timeValue() throws SQLException {
      try {
         super.preForAll(methodObject25365, this, zeroLengthObjectArray);
         return (Time)this.postForAll(methodObject25365, (Object)this.delegate.timeValue());
      } catch (SQLException var2) {
         return (Time)this.postForAll(methodObject25365, this.onErrorForAll(methodObject25365, var2));
      }
   }

   public oracle.jdbc.driver.OracleConnection getConnection() throws SQLException {
      try {
         super.preForAll(methodObject25371, this, zeroLengthObjectArray);
         return (oracle.jdbc.driver.OracleConnection)this.postForAll(methodObject25371, (Object)this.delegate.getConnection());
      } catch (SQLException var2) {
         return (oracle.jdbc.driver.OracleConnection)this.postForAll(methodObject25371, this.onErrorForAll(methodObject25371, var2));
      }
   }

   public OracleStruct _getDelegate_() {
      return this.delegate;
   }

   public Object getDelegate() {
      return this.delegate;
   }

   public void setDelegate(Object delegate) {
      this.proxyFactory.updateDelegate(this, this.delegate, delegate);
      this.delegate = (OracleStruct)delegate;
   }

   public Object getCreator() {
      return this.creator;
   }

   static {
      try {
         methodObject25342 = OracleStruct.class.getDeclaredMethod("isInHierarchyOf", String.class);
         methodObject25359 = OracleDatumWithConnection.class.getDeclaredMethod("setShareBytes", byte[].class);
         methodObject25374 = Struct.class.getDeclaredMethod("getAttributes", Map.class);
         methodObject25373 = Struct.class.getDeclaredMethod("getAttributes");
         methodObject25338 = OracleStruct.class.getDeclaredMethod("setImage", byte[].class, Long.TYPE, Long.TYPE);
         methodObject25341 = OracleStruct.class.getDeclaredMethod("getImageLength");
         methodObject25331 = OracleStruct.class.getDeclaredMethod("getJavaSqlConnection");
         methodObject25335 = OracleStruct.class.getDeclaredMethod("setObjArray", Object[].class);
         methodObject25346 = OracleDatumWithConnection.class.getDeclaredMethod("booleanValue");
         methodObject25340 = OracleStruct.class.getDeclaredMethod("getImageOffset");
         methodObject25375 = Struct.class.getDeclaredMethod("getSQLTypeName");
         methodObject25376 = ACProxyable.class.getDeclaredMethod("setACProxy", Object.class);
         methodObject25343 = OracleStruct.class.getDeclaredMethod("setDescriptor", StructDescriptor.class);
         methodObject25327 = OracleStruct.class.getDeclaredMethod("getMap");
         methodObject25367 = OracleDatumWithConnection.class.getDeclaredMethod("timestampValue");
         methodObject25348 = OracleDatumWithConnection.class.getDeclaredMethod("intValue");
         methodObject25370 = OracleDatumWithConnection.class.getDeclaredMethod("setPhysicalConnectionOf", Connection.class);
         methodObject25361 = OracleDatumWithConnection.class.getDeclaredMethod("stringValue");
         methodObject25362 = OracleDatumWithConnection.class.getDeclaredMethod("stringValue", Connection.class);
         methodObject25355 = OracleDatumWithConnection.class.getDeclaredMethod("asciiStreamValue");
         methodObject25357 = OracleDatumWithConnection.class.getDeclaredMethod("shareBytes");
         methodObject25351 = OracleDatumWithConnection.class.getDeclaredMethod("doubleValue");
         methodObject25339 = OracleStruct.class.getDeclaredMethod("setImageLength", Long.TYPE);
         methodObject25349 = OracleDatumWithConnection.class.getDeclaredMethod("longValue");
         methodObject25325 = OracleStruct.class.getDeclaredMethod("toClass", Class.class, Map.class);
         methodObject25368 = OracleDatumWithConnection.class.getDeclaredMethod("timestampValue", Calendar.class);
         methodObject25334 = OracleStruct.class.getDeclaredMethod("setDatumArray", Datum[].class);
         methodObject25336 = OracleStruct.class.getDeclaredMethod("setAutoBuffering", Boolean.TYPE);
         methodObject25332 = OracleStruct.class.getDeclaredMethod("getORADataFactory", Hashtable.class, String.class);
         methodObject25323 = OracleStruct.class.getDeclaredMethod("getDescriptor");
         methodObject25353 = OracleDatumWithConnection.class.getDeclaredMethod("getInternalConnection");
         methodObject25326 = OracleStruct.class.getDeclaredMethod("isConvertibleTo", Class.class);
         methodObject25352 = OracleDatumWithConnection.class.getDeclaredMethod("getBytes");
         methodObject25366 = OracleDatumWithConnection.class.getDeclaredMethod("timeValue", Calendar.class);
         methodObject25337 = OracleStruct.class.getDeclaredMethod("getAutoBuffering");
         methodObject25356 = OracleDatumWithConnection.class.getDeclaredMethod("binaryStreamValue");
         methodObject25344 = OracleStruct.class.getDeclaredMethod("getOracleAttributes");
         methodObject25324 = OracleStruct.class.getDeclaredMethod("toClass", Class.class);
         methodObject25377 = ACProxyable.class.getDeclaredMethod("getACProxy");
         methodObject25369 = OracleDatumWithConnection.class.getDeclaredMethod("getOracleConnection");
         methodObject25328 = OracleStruct.class.getDeclaredMethod("toJdbc");
         methodObject25364 = OracleDatumWithConnection.class.getDeclaredMethod("dateValue");
         methodObject25358 = OracleDatumWithConnection.class.getDeclaredMethod("setBytes", byte[].class);
         methodObject25363 = OracleDatumWithConnection.class.getDeclaredMethod("bigDecimalValue");
         methodObject25372 = oracle.jdbc.OracleStruct.class.getDeclaredMethod("getOracleMetaData");
         methodObject25330 = OracleStruct.class.getDeclaredMethod("makeJdbcArray", Integer.TYPE);
         methodObject25329 = OracleStruct.class.getDeclaredMethod("toJdbc", Map.class);
         methodObject25347 = OracleDatumWithConnection.class.getDeclaredMethod("byteValue");
         methodObject25350 = OracleDatumWithConnection.class.getDeclaredMethod("floatValue");
         methodObject25354 = OracleDatumWithConnection.class.getDeclaredMethod("characterStreamValue");
         methodObject25333 = OracleStruct.class.getDeclaredMethod("toBytes");
         methodObject25360 = OracleDatumWithConnection.class.getDeclaredMethod("getStream");
         methodObject25345 = OracleDatumWithConnection.class.getDeclaredMethod("getLength");
         methodObject25365 = OracleDatumWithConnection.class.getDeclaredMethod("timeValue");
         methodObject25371 = OracleDatumWithConnection.class.getDeclaredMethod("getConnection");
      } catch (Throwable var1) {
         throw new RuntimeException(var1);
      }
   }

   public oracle$1jdbc$1replay$1driver$1NonTxnReplayableStruct$2oracle$1jdbc$1internal$1OracleStruct$$$Proxy(OracleStruct var1, Object var2, ProxyFactory var3, Map var4) {
      this.delegate = var1;
      this.creator = var2;
      this.proxyFactory = var3;
      this.proxyCache = var4;
   }
}
