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
import oracle.jdbc.replay.driver.TxnReplayableStruct;
import oracle.sql.Datum;
import oracle.sql.ORADataFactory;
import oracle.sql.StructDescriptor;

public class oracle$1jdbc$1replay$1driver$1TxnReplayableStruct$2oracle$1jdbc$1internal$1OracleStruct$$$Proxy extends TxnReplayableStruct implements OracleStruct, _Proxy_ {
   private OracleStruct delegate;
   private final Object creator;
   private final ProxyFactory proxyFactory;
   private final Map proxyCache;
   private static Object[] zeroLengthObjectArray = new Object[0];
   private static Method methodObject1407;
   private static Method methodObject1415;
   private static Method methodObject1377;
   private static Method methodObject1382;
   private static Method methodObject1383;
   private static Method methodObject1388;
   private static Method methodObject1381;
   private static Method methodObject1368;
   private static Method methodObject1417;
   private static Method methodObject1369;
   private static Method methodObject1399;
   private static Method methodObject1390;
   private static Method methodObject1406;
   private static Method methodObject1398;
   private static Method methodObject1373;
   private static Method methodObject1400;
   private static Method methodObject1402;
   private static Method methodObject1395;
   private static Method methodObject1393;
   private static Method methodObject1385;
   private static Method methodObject1375;
   private static Method methodObject1391;
   private static Method methodObject1365;
   private static Method methodObject1410;
   private static Method methodObject1404;
   private static Method methodObject1380;
   private static Method methodObject1367;
   private static Method methodObject1372;
   private static Method methodObject1394;
   private static Method methodObject1378;
   private static Method methodObject1403;
   private static Method methodObject1384;
   private static Method methodObject1418;
   private static Method methodObject1419;
   private static Method methodObject1412;
   private static Method methodObject1370;
   private static Method methodObject1416;
   private static Method methodObject1379;
   private static Method methodObject1386;
   private static Method methodObject1409;
   private static Method methodObject1366;
   private static Method methodObject1408;
   private static Method methodObject1396;
   private static Method methodObject1414;
   private static Method methodObject1376;
   private static Method methodObject1389;
   private static Method methodObject1392;
   private static Method methodObject1401;
   private static Method methodObject1371;
   private static Method methodObject1374;
   private static Method methodObject1405;
   private static Method methodObject1387;
   private static Method methodObject1397;
   private static Method methodObject1411;
   private static Method methodObject1413;

   public String stringValue(Connection arg0) throws SQLException {
      try {
         super.preForAll(methodObject1407, this, arg0);
         return (String)this.postForAll(methodObject1407, (Object)this.delegate.stringValue(arg0 instanceof _Proxy_ ? (Connection)((_Proxy_)arg0)._getDelegate_() : arg0));
      } catch (SQLException var3) {
         return (String)this.postForAll(methodObject1407, this.onErrorForAll(methodObject1407, var3));
      }
   }

   public Object[] getAttributes() throws SQLException {
      try {
         super.preForAll(methodObject1415, this, zeroLengthObjectArray);
         return (Object[])this.postForAll(methodObject1415, (Object)this.delegate.getAttributes());
      } catch (SQLException var2) {
         return (Object[])this.postForAll(methodObject1415, this.onErrorForAll(methodObject1415, var2));
      }
   }

   public void setAutoBuffering(boolean arg0) throws SQLException {
      try {
         super.preForAll(methodObject1377, this, arg0);
         Method var10001 = methodObject1377;
         this.delegate.setAutoBuffering(arg0);
         this.postForAll(var10001);
      } catch (SQLException var3) {
         this.onErrorVoidForAll(methodObject1377, var3);
      }
   }

   public long getImageLength() {
      super.preForAll(methodObject1382, this, zeroLengthObjectArray);
      return (Long)this.postForAll(methodObject1382, this.delegate.getImageLength());
   }

   public Connection getJavaSqlConnection() throws SQLException {
      try {
         super.preForAll(methodObject1383, this, zeroLengthObjectArray);
         return (Connection)this.postForAll(methodObject1383, this.proxyFactory.proxyForCache((Object)this.delegate.getJavaSqlConnection(), this, this.proxyCache, methodObject1383));
      } catch (SQLException var2) {
         return (Connection)this.postForAll(methodObject1383, this.onErrorForAll(methodObject1383, var2));
      }
   }

   public boolean booleanValue() throws SQLException {
      try {
         super.preForAll(methodObject1388, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject1388, this.delegate.booleanValue());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject1388, this.onErrorForAll(methodObject1388, var2));
      }
   }

   public long getImageOffset() {
      super.preForAll(methodObject1381, this, zeroLengthObjectArray);
      return (Long)this.postForAll(methodObject1381, this.delegate.getImageOffset());
   }

   public boolean isConvertibleTo(Class arg0) {
      super.preForAll(methodObject1368, this, arg0);
      return (Boolean)this.postForAll(methodObject1368, this.delegate.isConvertibleTo(arg0));
   }

   public String getSQLTypeName() throws SQLException {
      try {
         super.preForAll(methodObject1417, this, zeroLengthObjectArray);
         return (String)this.postForAll(methodObject1417, (Object)this.delegate.getSQLTypeName());
      } catch (SQLException var2) {
         return (String)this.postForAll(methodObject1417, this.onErrorForAll(methodObject1417, var2));
      }
   }

   public Map getMap() {
      super.preForAll(methodObject1369, this, zeroLengthObjectArray);
      return (Map)this.postForAll(methodObject1369, (Object)this.delegate.getMap());
   }

   public Timestamp timestampValue() throws SQLException {
      try {
         super.preForAll(methodObject1399, this, zeroLengthObjectArray);
         return (Timestamp)this.postForAll(methodObject1399, (Object)this.delegate.timestampValue());
      } catch (SQLException var2) {
         return (Timestamp)this.postForAll(methodObject1399, this.onErrorForAll(methodObject1399, var2));
      }
   }

   public int intValue() throws SQLException {
      try {
         super.preForAll(methodObject1390, this, zeroLengthObjectArray);
         return (Integer)this.postForAll(methodObject1390, this.delegate.intValue());
      } catch (SQLException var2) {
         return (Integer)this.postForAll(methodObject1390, this.onErrorForAll(methodObject1390, var2));
      }
   }

   public String stringValue() throws SQLException {
      try {
         super.preForAll(methodObject1406, this, zeroLengthObjectArray);
         return (String)this.postForAll(methodObject1406, (Object)this.delegate.stringValue());
      } catch (SQLException var2) {
         return (String)this.postForAll(methodObject1406, this.onErrorForAll(methodObject1406, var2));
      }
   }

   public Time timeValue(Calendar arg0) throws SQLException {
      try {
         super.preForAll(methodObject1398, this, arg0);
         return (Time)this.postForAll(methodObject1398, (Object)this.delegate.timeValue(arg0));
      } catch (SQLException var3) {
         return (Time)this.postForAll(methodObject1398, this.onErrorForAll(methodObject1398, var3));
      }
   }

   public void setDescriptor(StructDescriptor arg0) {
      super.preForAll(methodObject1373, this, arg0);
      Method var10001 = methodObject1373;
      this.delegate.setDescriptor(arg0);
      this.postForAll(var10001);
   }

   public Timestamp timestampValue(Calendar arg0) throws SQLException {
      try {
         super.preForAll(methodObject1400, this, arg0);
         return (Timestamp)this.postForAll(methodObject1400, (Object)this.delegate.timestampValue(arg0));
      } catch (SQLException var3) {
         return (Timestamp)this.postForAll(methodObject1400, this.onErrorForAll(methodObject1400, var3));
      }
   }

   public InputStream asciiStreamValue() throws SQLException {
      try {
         super.preForAll(methodObject1402, this, zeroLengthObjectArray);
         return (InputStream)this.postForAll(methodObject1402, (Object)this.delegate.asciiStreamValue());
      } catch (SQLException var2) {
         return (InputStream)this.postForAll(methodObject1402, this.onErrorForAll(methodObject1402, var2));
      }
   }

   public byte[] shareBytes() {
      super.preForAll(methodObject1395, this, zeroLengthObjectArray);
      return (byte[])this.postForAll(methodObject1395, (Object)this.delegate.shareBytes());
   }

   public double doubleValue() throws SQLException {
      try {
         super.preForAll(methodObject1393, this, zeroLengthObjectArray);
         return (Double)this.postForAll(methodObject1393, this.delegate.doubleValue());
      } catch (SQLException var2) {
         return (Double)this.postForAll(methodObject1393, this.onErrorForAll(methodObject1393, var2));
      }
   }

   public boolean isInHierarchyOf(String arg0) throws SQLException {
      try {
         super.preForAll(methodObject1385, this, arg0);
         return (Boolean)this.postForAll(methodObject1385, this.delegate.isInHierarchyOf(arg0));
      } catch (SQLException var3) {
         return (Boolean)this.postForAll(methodObject1385, this.onErrorForAll(methodObject1385, var3));
      }
   }

   public void setDatumArray(Datum[] arg0) {
      super.preForAll(methodObject1375, this, arg0);
      Method var10001 = methodObject1375;
      this.delegate.setDatumArray(arg0);
      this.postForAll(var10001);
   }

   public long longValue() throws SQLException {
      try {
         super.preForAll(methodObject1391, this, zeroLengthObjectArray);
         return (Long)this.postForAll(methodObject1391, this.delegate.longValue());
      } catch (SQLException var2) {
         return (Long)this.postForAll(methodObject1391, this.onErrorForAll(methodObject1391, var2));
      }
   }

   public StructDescriptor getDescriptor() throws SQLException {
      try {
         super.preForAll(methodObject1365, this, zeroLengthObjectArray);
         return (StructDescriptor)this.postForAll(methodObject1365, (Object)this.delegate.getDescriptor());
      } catch (SQLException var2) {
         return (StructDescriptor)this.postForAll(methodObject1365, this.onErrorForAll(methodObject1365, var2));
      }
   }

   public OracleConnection getInternalConnection() throws SQLException {
      try {
         super.preForAll(methodObject1410, this, zeroLengthObjectArray);
         return (OracleConnection)this.postForAll(methodObject1410, this.proxyFactory.proxyForCache((Object)this.delegate.getInternalConnection(), this, this.proxyCache, methodObject1410));
      } catch (SQLException var2) {
         return (OracleConnection)this.postForAll(methodObject1410, this.onErrorForAll(methodObject1410, var2));
      }
   }

   public void setShareBytes(byte[] arg0) {
      super.preForAll(methodObject1404, this, arg0);
      Method var10001 = methodObject1404;
      this.delegate.setShareBytes(arg0);
      this.postForAll(var10001);
   }

   public void setImageLength(long arg0) throws SQLException {
      try {
         super.preForAll(methodObject1380, this, arg0);
         Method var10001 = methodObject1380;
         this.delegate.setImageLength(arg0);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject1380, var4);
      }
   }

   public Object toClass(Class arg0, Map arg1) throws SQLException {
      try {
         super.preForAll(methodObject1367, this, arg0, arg1);
         return this.postForAll(methodObject1367, this.proxyFactory.proxyForCache(this.delegate.toClass(arg0, arg1), this, this.proxyCache, methodObject1367));
      } catch (SQLException var4) {
         return this.postForAll(methodObject1367, this.onErrorForAll(methodObject1367, var4));
      }
   }

   public Object makeJdbcArray(int arg0) {
      super.preForAll(methodObject1372, this, arg0);
      return this.postForAll(methodObject1372, this.proxyFactory.proxyForCache(this.delegate.makeJdbcArray(arg0), this, this.proxyCache, methodObject1372));
   }

   public byte[] getBytes() {
      super.preForAll(methodObject1394, this, zeroLengthObjectArray);
      return (byte[])this.postForAll(methodObject1394, (Object)this.delegate.getBytes());
   }

   public boolean getAutoBuffering() throws SQLException {
      try {
         super.preForAll(methodObject1378, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject1378, this.delegate.getAutoBuffering());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject1378, this.onErrorForAll(methodObject1378, var2));
      }
   }

   public InputStream binaryStreamValue() throws SQLException {
      try {
         super.preForAll(methodObject1403, this, zeroLengthObjectArray);
         return (InputStream)this.postForAll(methodObject1403, (Object)this.delegate.binaryStreamValue());
      } catch (SQLException var2) {
         return (InputStream)this.postForAll(methodObject1403, this.onErrorForAll(methodObject1403, var2));
      }
   }

   public Datum[] getOracleAttributes() throws SQLException {
      try {
         super.preForAll(methodObject1384, this, zeroLengthObjectArray);
         return (Datum[])this.postForAll(methodObject1384, (Object)this.delegate.getOracleAttributes());
      } catch (SQLException var2) {
         return (Datum[])this.postForAll(methodObject1384, this.onErrorForAll(methodObject1384, var2));
      }
   }

   public void setACProxy(Object arg0) {
      super.preForAll(methodObject1418, this, arg0);
      Method var10001 = methodObject1418;
      this.delegate.setACProxy(arg0 instanceof _Proxy_ ? (Object)((_Proxy_)arg0)._getDelegate_() : arg0);
      this.postForAll(var10001);
   }

   public Object getACProxy() {
      super.preForAll(methodObject1419, this, zeroLengthObjectArray);
      return this.postForAll(methodObject1419, this.proxyFactory.proxyForCache(this.delegate.getACProxy(), this, this.proxyCache, methodObject1419));
   }

   public oracle.jdbc.OracleConnection getOracleConnection() throws SQLException {
      try {
         super.preForAll(methodObject1412, this, zeroLengthObjectArray);
         return (oracle.jdbc.OracleConnection)this.postForAll(methodObject1412, this.proxyFactory.proxyForCache((Object)this.delegate.getOracleConnection(), this, this.proxyCache, methodObject1412));
      } catch (SQLException var2) {
         return (oracle.jdbc.OracleConnection)this.postForAll(methodObject1412, this.onErrorForAll(methodObject1412, var2));
      }
   }

   public Object toJdbc() throws SQLException {
      try {
         super.preForAll(methodObject1370, this, zeroLengthObjectArray);
         return this.postForAll(methodObject1370, this.proxyFactory.proxyForCache(this.delegate.toJdbc(), this, this.proxyCache, methodObject1370));
      } catch (SQLException var2) {
         return this.postForAll(methodObject1370, this.onErrorForAll(methodObject1370, var2));
      }
   }

   public Object[] getAttributes(Map arg0) throws SQLException {
      try {
         super.preForAll(methodObject1416, this, arg0);
         return (Object[])this.postForAll(methodObject1416, (Object)this.delegate.getAttributes(arg0));
      } catch (SQLException var3) {
         return (Object[])this.postForAll(methodObject1416, this.onErrorForAll(methodObject1416, var3));
      }
   }

   public void setImage(byte[] arg0, long arg1, long arg2) throws SQLException {
      try {
         super.preForAll(methodObject1379, this, arg0, arg1, arg2);
         Method var10001 = methodObject1379;
         this.delegate.setImage(arg0, arg1, arg2);
         this.postForAll(var10001);
      } catch (SQLException var7) {
         this.onErrorVoidForAll(methodObject1379, var7);
      }
   }

   public ORADataFactory getORADataFactory(Hashtable arg0, String arg1) throws SQLException {
      try {
         super.preForAll(methodObject1386, this, arg0, arg1);
         return (ORADataFactory)this.postForAll(methodObject1386, (Object)this.delegate.getORADataFactory(arg0, arg1));
      } catch (SQLException var4) {
         return (ORADataFactory)this.postForAll(methodObject1386, this.onErrorForAll(methodObject1386, var4));
      }
   }

   public Date dateValue() throws SQLException {
      try {
         super.preForAll(methodObject1409, this, zeroLengthObjectArray);
         return (Date)this.postForAll(methodObject1409, (Object)this.delegate.dateValue());
      } catch (SQLException var2) {
         return (Date)this.postForAll(methodObject1409, this.onErrorForAll(methodObject1409, var2));
      }
   }

   public Object toClass(Class arg0) throws SQLException {
      try {
         super.preForAll(methodObject1366, this, arg0);
         return this.postForAll(methodObject1366, this.proxyFactory.proxyForCache(this.delegate.toClass(arg0), this, this.proxyCache, methodObject1366));
      } catch (SQLException var3) {
         return this.postForAll(methodObject1366, this.onErrorForAll(methodObject1366, var3));
      }
   }

   public BigDecimal bigDecimalValue() throws SQLException {
      try {
         super.preForAll(methodObject1408, this, zeroLengthObjectArray);
         return (BigDecimal)this.postForAll(methodObject1408, (Object)this.delegate.bigDecimalValue());
      } catch (SQLException var2) {
         return (BigDecimal)this.postForAll(methodObject1408, this.onErrorForAll(methodObject1408, var2));
      }
   }

   public void setBytes(byte[] arg0) {
      super.preForAll(methodObject1396, this, arg0);
      Method var10001 = methodObject1396;
      this.delegate.setBytes(arg0);
      this.postForAll(var10001);
   }

   public OracleTypeMetaData getOracleMetaData() throws SQLException {
      try {
         super.preForAll(methodObject1414, this, zeroLengthObjectArray);
         return (OracleTypeMetaData)this.postForAll(methodObject1414, this.proxyFactory.proxyForCache((Object)this.delegate.getOracleMetaData(), this, this.proxyCache, methodObject1414));
      } catch (SQLException var2) {
         return (OracleTypeMetaData)this.postForAll(methodObject1414, this.onErrorForAll(methodObject1414, var2));
      }
   }

   public void setObjArray(Object[] arg0) throws SQLException {
      try {
         super.preForAll(methodObject1376, this, (Object)arg0);
         Method var10001 = methodObject1376;
         this.delegate.setObjArray(arg0);
         this.postForAll(var10001);
      } catch (SQLException var3) {
         this.onErrorVoidForAll(methodObject1376, var3);
      }
   }

   public byte byteValue() throws SQLException {
      try {
         super.preForAll(methodObject1389, this, zeroLengthObjectArray);
         return (Byte)this.postForAll(methodObject1389, this.delegate.byteValue());
      } catch (SQLException var2) {
         return (Byte)this.postForAll(methodObject1389, this.onErrorForAll(methodObject1389, var2));
      }
   }

   public float floatValue() throws SQLException {
      try {
         super.preForAll(methodObject1392, this, zeroLengthObjectArray);
         return (Float)this.postForAll(methodObject1392, this.delegate.floatValue());
      } catch (SQLException var2) {
         return (Float)this.postForAll(methodObject1392, this.onErrorForAll(methodObject1392, var2));
      }
   }

   public Reader characterStreamValue() throws SQLException {
      try {
         super.preForAll(methodObject1401, this, zeroLengthObjectArray);
         return (Reader)this.postForAll(methodObject1401, (Object)this.delegate.characterStreamValue());
      } catch (SQLException var2) {
         return (Reader)this.postForAll(methodObject1401, this.onErrorForAll(methodObject1401, var2));
      }
   }

   public Object toJdbc(Map arg0) throws SQLException {
      try {
         super.preForAll(methodObject1371, this, arg0);
         return this.postForAll(methodObject1371, this.proxyFactory.proxyForCache(this.delegate.toJdbc(arg0), this, this.proxyCache, methodObject1371));
      } catch (SQLException var3) {
         return this.postForAll(methodObject1371, this.onErrorForAll(methodObject1371, var3));
      }
   }

   public byte[] toBytes() throws SQLException {
      try {
         super.preForAll(methodObject1374, this, zeroLengthObjectArray);
         return (byte[])this.postForAll(methodObject1374, (Object)this.delegate.toBytes());
      } catch (SQLException var2) {
         return (byte[])this.postForAll(methodObject1374, this.onErrorForAll(methodObject1374, var2));
      }
   }

   public InputStream getStream() throws SQLException {
      try {
         super.preForAll(methodObject1405, this, zeroLengthObjectArray);
         return (InputStream)this.postForAll(methodObject1405, (Object)this.delegate.getStream());
      } catch (SQLException var2) {
         return (InputStream)this.postForAll(methodObject1405, this.onErrorForAll(methodObject1405, var2));
      }
   }

   public long getLength() {
      super.preForAll(methodObject1387, this, zeroLengthObjectArray);
      return (Long)this.postForAll(methodObject1387, this.delegate.getLength());
   }

   public Time timeValue() throws SQLException {
      try {
         super.preForAll(methodObject1397, this, zeroLengthObjectArray);
         return (Time)this.postForAll(methodObject1397, (Object)this.delegate.timeValue());
      } catch (SQLException var2) {
         return (Time)this.postForAll(methodObject1397, this.onErrorForAll(methodObject1397, var2));
      }
   }

   public void setPhysicalConnectionOf(Connection arg0) {
      super.preForAll(methodObject1411, this, arg0);
      Method var10001 = methodObject1411;
      this.delegate.setPhysicalConnectionOf(arg0 instanceof _Proxy_ ? (Connection)((_Proxy_)arg0)._getDelegate_() : arg0);
      this.postForAll(var10001);
   }

   public oracle.jdbc.driver.OracleConnection getConnection() throws SQLException {
      try {
         super.preForAll(methodObject1413, this, zeroLengthObjectArray);
         return (oracle.jdbc.driver.OracleConnection)this.postForAll(methodObject1413, (Object)this.delegate.getConnection());
      } catch (SQLException var2) {
         return (oracle.jdbc.driver.OracleConnection)this.postForAll(methodObject1413, this.onErrorForAll(methodObject1413, var2));
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
         methodObject1407 = OracleDatumWithConnection.class.getDeclaredMethod("stringValue", Connection.class);
         methodObject1415 = Struct.class.getDeclaredMethod("getAttributes");
         methodObject1377 = OracleStruct.class.getDeclaredMethod("setAutoBuffering", Boolean.TYPE);
         methodObject1382 = OracleStruct.class.getDeclaredMethod("getImageLength");
         methodObject1383 = OracleStruct.class.getDeclaredMethod("getJavaSqlConnection");
         methodObject1388 = OracleDatumWithConnection.class.getDeclaredMethod("booleanValue");
         methodObject1381 = OracleStruct.class.getDeclaredMethod("getImageOffset");
         methodObject1368 = OracleStruct.class.getDeclaredMethod("isConvertibleTo", Class.class);
         methodObject1417 = Struct.class.getDeclaredMethod("getSQLTypeName");
         methodObject1369 = OracleStruct.class.getDeclaredMethod("getMap");
         methodObject1399 = OracleDatumWithConnection.class.getDeclaredMethod("timestampValue");
         methodObject1390 = OracleDatumWithConnection.class.getDeclaredMethod("intValue");
         methodObject1406 = OracleDatumWithConnection.class.getDeclaredMethod("stringValue");
         methodObject1398 = OracleDatumWithConnection.class.getDeclaredMethod("timeValue", Calendar.class);
         methodObject1373 = OracleStruct.class.getDeclaredMethod("setDescriptor", StructDescriptor.class);
         methodObject1400 = OracleDatumWithConnection.class.getDeclaredMethod("timestampValue", Calendar.class);
         methodObject1402 = OracleDatumWithConnection.class.getDeclaredMethod("asciiStreamValue");
         methodObject1395 = OracleDatumWithConnection.class.getDeclaredMethod("shareBytes");
         methodObject1393 = OracleDatumWithConnection.class.getDeclaredMethod("doubleValue");
         methodObject1385 = OracleStruct.class.getDeclaredMethod("isInHierarchyOf", String.class);
         methodObject1375 = OracleStruct.class.getDeclaredMethod("setDatumArray", Datum[].class);
         methodObject1391 = OracleDatumWithConnection.class.getDeclaredMethod("longValue");
         methodObject1365 = OracleStruct.class.getDeclaredMethod("getDescriptor");
         methodObject1410 = OracleDatumWithConnection.class.getDeclaredMethod("getInternalConnection");
         methodObject1404 = OracleDatumWithConnection.class.getDeclaredMethod("setShareBytes", byte[].class);
         methodObject1380 = OracleStruct.class.getDeclaredMethod("setImageLength", Long.TYPE);
         methodObject1367 = OracleStruct.class.getDeclaredMethod("toClass", Class.class, Map.class);
         methodObject1372 = OracleStruct.class.getDeclaredMethod("makeJdbcArray", Integer.TYPE);
         methodObject1394 = OracleDatumWithConnection.class.getDeclaredMethod("getBytes");
         methodObject1378 = OracleStruct.class.getDeclaredMethod("getAutoBuffering");
         methodObject1403 = OracleDatumWithConnection.class.getDeclaredMethod("binaryStreamValue");
         methodObject1384 = OracleStruct.class.getDeclaredMethod("getOracleAttributes");
         methodObject1418 = ACProxyable.class.getDeclaredMethod("setACProxy", Object.class);
         methodObject1419 = ACProxyable.class.getDeclaredMethod("getACProxy");
         methodObject1412 = OracleDatumWithConnection.class.getDeclaredMethod("getOracleConnection");
         methodObject1370 = OracleStruct.class.getDeclaredMethod("toJdbc");
         methodObject1416 = Struct.class.getDeclaredMethod("getAttributes", Map.class);
         methodObject1379 = OracleStruct.class.getDeclaredMethod("setImage", byte[].class, Long.TYPE, Long.TYPE);
         methodObject1386 = OracleStruct.class.getDeclaredMethod("getORADataFactory", Hashtable.class, String.class);
         methodObject1409 = OracleDatumWithConnection.class.getDeclaredMethod("dateValue");
         methodObject1366 = OracleStruct.class.getDeclaredMethod("toClass", Class.class);
         methodObject1408 = OracleDatumWithConnection.class.getDeclaredMethod("bigDecimalValue");
         methodObject1396 = OracleDatumWithConnection.class.getDeclaredMethod("setBytes", byte[].class);
         methodObject1414 = oracle.jdbc.OracleStruct.class.getDeclaredMethod("getOracleMetaData");
         methodObject1376 = OracleStruct.class.getDeclaredMethod("setObjArray", Object[].class);
         methodObject1389 = OracleDatumWithConnection.class.getDeclaredMethod("byteValue");
         methodObject1392 = OracleDatumWithConnection.class.getDeclaredMethod("floatValue");
         methodObject1401 = OracleDatumWithConnection.class.getDeclaredMethod("characterStreamValue");
         methodObject1371 = OracleStruct.class.getDeclaredMethod("toJdbc", Map.class);
         methodObject1374 = OracleStruct.class.getDeclaredMethod("toBytes");
         methodObject1405 = OracleDatumWithConnection.class.getDeclaredMethod("getStream");
         methodObject1387 = OracleDatumWithConnection.class.getDeclaredMethod("getLength");
         methodObject1397 = OracleDatumWithConnection.class.getDeclaredMethod("timeValue");
         methodObject1411 = OracleDatumWithConnection.class.getDeclaredMethod("setPhysicalConnectionOf", Connection.class);
         methodObject1413 = OracleDatumWithConnection.class.getDeclaredMethod("getConnection");
      } catch (Throwable var1) {
         throw new RuntimeException(var1);
      }
   }

   public oracle$1jdbc$1replay$1driver$1TxnReplayableStruct$2oracle$1jdbc$1internal$1OracleStruct$$$Proxy(OracleStruct var1, Object var2, ProxyFactory var3, Map var4) {
      this.delegate = var1;
      this.creator = var2;
      this.proxyFactory = var3;
      this.proxyCache = var4;
   }
}
