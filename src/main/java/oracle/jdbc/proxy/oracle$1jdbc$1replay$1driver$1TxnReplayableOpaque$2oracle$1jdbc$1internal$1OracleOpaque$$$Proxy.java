package oracle.jdbc.proxy;

import java.io.InputStream;
import java.io.Reader;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Map;
import oracle.jdbc.OracleTypeMetaData;
import oracle.jdbc.internal.ACProxyable;
import oracle.jdbc.internal.OracleConnection;
import oracle.jdbc.internal.OracleDatumWithConnection;
import oracle.jdbc.internal.OracleOpaque;
import oracle.jdbc.replay.driver.TxnReplayableOpaque;
import oracle.sql.OpaqueDescriptor;

public class oracle$1jdbc$1replay$1driver$1TxnReplayableOpaque$2oracle$1jdbc$1internal$1OracleOpaque$$$Proxy extends TxnReplayableOpaque implements OracleOpaque, _Proxy_ {
   private OracleOpaque delegate;
   private final Object creator;
   private final ProxyFactory proxyFactory;
   private final Map proxyCache;
   private static Object[] zeroLengthObjectArray = new Object[0];
   private static Method methodObject1073;
   private static Method methodObject1050;
   private static Method methodObject1051;
   private static Method methodObject1054;
   private static Method methodObject1049;
   private static Method methodObject1039;
   private static Method methodObject1081;
   private static Method methodObject1041;
   private static Method methodObject1065;
   private static Method methodObject1056;
   private static Method methodObject1072;
   private static Method methodObject1064;
   private static Method methodObject1045;
   private static Method methodObject1066;
   private static Method methodObject1068;
   private static Method methodObject1080;
   private static Method methodObject1061;
   private static Method methodObject1059;
   private static Method methodObject1057;
   private static Method methodObject1036;
   private static Method methodObject1076;
   private static Method methodObject1070;
   private static Method methodObject1048;
   private static Method methodObject1038;
   private static Method methodObject1040;
   private static Method methodObject1044;
   private static Method methodObject1060;
   private static Method methodObject1069;
   private static Method methodObject1083;
   private static Method methodObject1078;
   private static Method methodObject1084;
   private static Method methodObject1042;
   private static Method methodObject1047;
   private static Method methodObject1075;
   private static Method methodObject1037;
   private static Method methodObject1074;
   private static Method methodObject1052;
   private static Method methodObject1062;
   private static Method methodObject1082;
   private static Method methodObject1055;
   private static Method methodObject1058;
   private static Method methodObject1067;
   private static Method methodObject1043;
   private static Method methodObject1046;
   private static Method methodObject1071;
   private static Method methodObject1053;
   private static Method methodObject1063;
   private static Method methodObject1077;
   private static Method methodObject1079;

   public String stringValue(Connection arg0) throws SQLException {
      try {
         super.preForAll(methodObject1073, this, arg0);
         return (String)this.postForAll(methodObject1073, (Object)this.delegate.stringValue(arg0 instanceof _Proxy_ ? (Connection)((_Proxy_)arg0)._getDelegate_() : arg0));
      } catch (SQLException var3) {
         return (String)this.postForAll(methodObject1073, this.onErrorForAll(methodObject1073, var3));
      }
   }

   public long getImageLength() {
      super.preForAll(methodObject1050, this, zeroLengthObjectArray);
      return (Long)this.postForAll(methodObject1050, this.delegate.getImageLength());
   }

   public Connection getJavaSqlConnection() throws SQLException {
      try {
         super.preForAll(methodObject1051, this, zeroLengthObjectArray);
         return (Connection)this.postForAll(methodObject1051, this.proxyFactory.proxyForCache((Object)this.delegate.getJavaSqlConnection(), this, this.proxyCache, methodObject1051));
      } catch (SQLException var2) {
         return (Connection)this.postForAll(methodObject1051, this.onErrorForAll(methodObject1051, var2));
      }
   }

   public boolean booleanValue() throws SQLException {
      try {
         super.preForAll(methodObject1054, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject1054, this.delegate.booleanValue());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject1054, this.onErrorForAll(methodObject1054, var2));
      }
   }

   public long getImageOffset() {
      super.preForAll(methodObject1049, this, zeroLengthObjectArray);
      return (Long)this.postForAll(methodObject1049, this.delegate.getImageOffset());
   }

   public boolean isConvertibleTo(Class arg0) {
      super.preForAll(methodObject1039, this, arg0);
      return (Boolean)this.postForAll(methodObject1039, this.delegate.isConvertibleTo(arg0));
   }

   public String getSQLTypeName() throws SQLException {
      try {
         super.preForAll(methodObject1081, this, zeroLengthObjectArray);
         return (String)this.postForAll(methodObject1081, (Object)this.delegate.getSQLTypeName());
      } catch (SQLException var2) {
         return (String)this.postForAll(methodObject1081, this.onErrorForAll(methodObject1081, var2));
      }
   }

   public Map getMap() {
      super.preForAll(methodObject1041, this, zeroLengthObjectArray);
      return (Map)this.postForAll(methodObject1041, (Object)this.delegate.getMap());
   }

   public Timestamp timestampValue() throws SQLException {
      try {
         super.preForAll(methodObject1065, this, zeroLengthObjectArray);
         return (Timestamp)this.postForAll(methodObject1065, (Object)this.delegate.timestampValue());
      } catch (SQLException var2) {
         return (Timestamp)this.postForAll(methodObject1065, this.onErrorForAll(methodObject1065, var2));
      }
   }

   public int intValue() throws SQLException {
      try {
         super.preForAll(methodObject1056, this, zeroLengthObjectArray);
         return (Integer)this.postForAll(methodObject1056, this.delegate.intValue());
      } catch (SQLException var2) {
         return (Integer)this.postForAll(methodObject1056, this.onErrorForAll(methodObject1056, var2));
      }
   }

   public String stringValue() throws SQLException {
      try {
         super.preForAll(methodObject1072, this, zeroLengthObjectArray);
         return (String)this.postForAll(methodObject1072, (Object)this.delegate.stringValue());
      } catch (SQLException var2) {
         return (String)this.postForAll(methodObject1072, this.onErrorForAll(methodObject1072, var2));
      }
   }

   public Time timeValue(Calendar arg0) throws SQLException {
      try {
         super.preForAll(methodObject1064, this, arg0);
         return (Time)this.postForAll(methodObject1064, (Object)this.delegate.timeValue(arg0));
      } catch (SQLException var3) {
         return (Time)this.postForAll(methodObject1064, this.onErrorForAll(methodObject1064, var3));
      }
   }

   public void setDescriptor(OpaqueDescriptor arg0) {
      super.preForAll(methodObject1045, this, arg0);
      Method var10001 = methodObject1045;
      this.delegate.setDescriptor(arg0);
      this.postForAll(var10001);
   }

   public Timestamp timestampValue(Calendar arg0) throws SQLException {
      try {
         super.preForAll(methodObject1066, this, arg0);
         return (Timestamp)this.postForAll(methodObject1066, (Object)this.delegate.timestampValue(arg0));
      } catch (SQLException var3) {
         return (Timestamp)this.postForAll(methodObject1066, this.onErrorForAll(methodObject1066, var3));
      }
   }

   public InputStream asciiStreamValue() throws SQLException {
      try {
         super.preForAll(methodObject1068, this, zeroLengthObjectArray);
         return (InputStream)this.postForAll(methodObject1068, (Object)this.delegate.asciiStreamValue());
      } catch (SQLException var2) {
         return (InputStream)this.postForAll(methodObject1068, this.onErrorForAll(methodObject1068, var2));
      }
   }

   public Object getValue() throws SQLException {
      try {
         super.preForAll(methodObject1080, this, zeroLengthObjectArray);
         return this.postForAll(methodObject1080, this.proxyFactory.proxyForCache(this.delegate.getValue(), this, this.proxyCache, methodObject1080));
      } catch (SQLException var2) {
         return this.postForAll(methodObject1080, this.onErrorForAll(methodObject1080, var2));
      }
   }

   public byte[] shareBytes() {
      super.preForAll(methodObject1061, this, zeroLengthObjectArray);
      return (byte[])this.postForAll(methodObject1061, (Object)this.delegate.shareBytes());
   }

   public double doubleValue() throws SQLException {
      try {
         super.preForAll(methodObject1059, this, zeroLengthObjectArray);
         return (Double)this.postForAll(methodObject1059, this.delegate.doubleValue());
      } catch (SQLException var2) {
         return (Double)this.postForAll(methodObject1059, this.onErrorForAll(methodObject1059, var2));
      }
   }

   public long longValue() throws SQLException {
      try {
         super.preForAll(methodObject1057, this, zeroLengthObjectArray);
         return (Long)this.postForAll(methodObject1057, this.delegate.longValue());
      } catch (SQLException var2) {
         return (Long)this.postForAll(methodObject1057, this.onErrorForAll(methodObject1057, var2));
      }
   }

   public OpaqueDescriptor getDescriptor() throws SQLException {
      try {
         super.preForAll(methodObject1036, this, zeroLengthObjectArray);
         return (OpaqueDescriptor)this.postForAll(methodObject1036, (Object)this.delegate.getDescriptor());
      } catch (SQLException var2) {
         return (OpaqueDescriptor)this.postForAll(methodObject1036, this.onErrorForAll(methodObject1036, var2));
      }
   }

   public OracleConnection getInternalConnection() throws SQLException {
      try {
         super.preForAll(methodObject1076, this, zeroLengthObjectArray);
         return (OracleConnection)this.postForAll(methodObject1076, this.proxyFactory.proxyForCache((Object)this.delegate.getInternalConnection(), this, this.proxyCache, methodObject1076));
      } catch (SQLException var2) {
         return (OracleConnection)this.postForAll(methodObject1076, this.onErrorForAll(methodObject1076, var2));
      }
   }

   public void setShareBytes(byte[] arg0) {
      super.preForAll(methodObject1070, this, arg0);
      Method var10001 = methodObject1070;
      this.delegate.setShareBytes(arg0);
      this.postForAll(var10001);
   }

   public void setImageLength(long arg0) throws SQLException {
      try {
         super.preForAll(methodObject1048, this, arg0);
         Method var10001 = methodObject1048;
         this.delegate.setImageLength(arg0);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject1048, var4);
      }
   }

   public Object toClass(Class arg0, Map arg1) throws SQLException {
      try {
         super.preForAll(methodObject1038, this, arg0, arg1);
         return this.postForAll(methodObject1038, this.proxyFactory.proxyForCache(this.delegate.toClass(arg0, arg1), this, this.proxyCache, methodObject1038));
      } catch (SQLException var4) {
         return this.postForAll(methodObject1038, this.onErrorForAll(methodObject1038, var4));
      }
   }

   public void setValue(byte[] arg0) throws SQLException {
      try {
         super.preForAll(methodObject1040, this, arg0);
         Method var10001 = methodObject1040;
         this.delegate.setValue(arg0);
         this.postForAll(var10001);
      } catch (SQLException var3) {
         this.onErrorVoidForAll(methodObject1040, var3);
      }
   }

   public Object makeJdbcArray(int arg0) {
      super.preForAll(methodObject1044, this, arg0);
      return this.postForAll(methodObject1044, this.proxyFactory.proxyForCache(this.delegate.makeJdbcArray(arg0), this, this.proxyCache, methodObject1044));
   }

   public byte[] getBytes() {
      super.preForAll(methodObject1060, this, zeroLengthObjectArray);
      return (byte[])this.postForAll(methodObject1060, (Object)this.delegate.getBytes());
   }

   public InputStream binaryStreamValue() throws SQLException {
      try {
         super.preForAll(methodObject1069, this, zeroLengthObjectArray);
         return (InputStream)this.postForAll(methodObject1069, (Object)this.delegate.binaryStreamValue());
      } catch (SQLException var2) {
         return (InputStream)this.postForAll(methodObject1069, this.onErrorForAll(methodObject1069, var2));
      }
   }

   public void setACProxy(Object arg0) {
      super.preForAll(methodObject1083, this, arg0);
      Method var10001 = methodObject1083;
      this.delegate.setACProxy(arg0 instanceof _Proxy_ ? (Object)((_Proxy_)arg0)._getDelegate_() : arg0);
      this.postForAll(var10001);
   }

   public oracle.jdbc.OracleConnection getOracleConnection() throws SQLException {
      try {
         super.preForAll(methodObject1078, this, zeroLengthObjectArray);
         return (oracle.jdbc.OracleConnection)this.postForAll(methodObject1078, this.proxyFactory.proxyForCache((Object)this.delegate.getOracleConnection(), this, this.proxyCache, methodObject1078));
      } catch (SQLException var2) {
         return (oracle.jdbc.OracleConnection)this.postForAll(methodObject1078, this.onErrorForAll(methodObject1078, var2));
      }
   }

   public Object getACProxy() {
      super.preForAll(methodObject1084, this, zeroLengthObjectArray);
      return this.postForAll(methodObject1084, this.proxyFactory.proxyForCache(this.delegate.getACProxy(), this, this.proxyCache, methodObject1084));
   }

   public Object toJdbc() throws SQLException {
      try {
         super.preForAll(methodObject1042, this, zeroLengthObjectArray);
         return this.postForAll(methodObject1042, this.proxyFactory.proxyForCache(this.delegate.toJdbc(), this, this.proxyCache, methodObject1042));
      } catch (SQLException var2) {
         return this.postForAll(methodObject1042, this.onErrorForAll(methodObject1042, var2));
      }
   }

   public void setImage(byte[] arg0, long arg1, long arg2) throws SQLException {
      try {
         super.preForAll(methodObject1047, this, arg0, arg1, arg2);
         Method var10001 = methodObject1047;
         this.delegate.setImage(arg0, arg1, arg2);
         this.postForAll(var10001);
      } catch (SQLException var7) {
         this.onErrorVoidForAll(methodObject1047, var7);
      }
   }

   public Date dateValue() throws SQLException {
      try {
         super.preForAll(methodObject1075, this, zeroLengthObjectArray);
         return (Date)this.postForAll(methodObject1075, (Object)this.delegate.dateValue());
      } catch (SQLException var2) {
         return (Date)this.postForAll(methodObject1075, this.onErrorForAll(methodObject1075, var2));
      }
   }

   public Object toClass(Class arg0) throws SQLException {
      try {
         super.preForAll(methodObject1037, this, arg0);
         return this.postForAll(methodObject1037, this.proxyFactory.proxyForCache(this.delegate.toClass(arg0), this, this.proxyCache, methodObject1037));
      } catch (SQLException var3) {
         return this.postForAll(methodObject1037, this.onErrorForAll(methodObject1037, var3));
      }
   }

   public BigDecimal bigDecimalValue() throws SQLException {
      try {
         super.preForAll(methodObject1074, this, zeroLengthObjectArray);
         return (BigDecimal)this.postForAll(methodObject1074, (Object)this.delegate.bigDecimalValue());
      } catch (SQLException var2) {
         return (BigDecimal)this.postForAll(methodObject1074, this.onErrorForAll(methodObject1074, var2));
      }
   }

   public byte[] getBytesValue() throws SQLException {
      try {
         super.preForAll(methodObject1052, this, zeroLengthObjectArray);
         return (byte[])this.postForAll(methodObject1052, (Object)this.delegate.getBytesValue());
      } catch (SQLException var2) {
         return (byte[])this.postForAll(methodObject1052, this.onErrorForAll(methodObject1052, var2));
      }
   }

   public void setBytes(byte[] arg0) {
      super.preForAll(methodObject1062, this, arg0);
      Method var10001 = methodObject1062;
      this.delegate.setBytes(arg0);
      this.postForAll(var10001);
   }

   public OracleTypeMetaData getOracleMetaData() throws SQLException {
      try {
         super.preForAll(methodObject1082, this, zeroLengthObjectArray);
         return (OracleTypeMetaData)this.postForAll(methodObject1082, this.proxyFactory.proxyForCache((Object)this.delegate.getOracleMetaData(), this, this.proxyCache, methodObject1082));
      } catch (SQLException var2) {
         return (OracleTypeMetaData)this.postForAll(methodObject1082, this.onErrorForAll(methodObject1082, var2));
      }
   }

   public byte byteValue() throws SQLException {
      try {
         super.preForAll(methodObject1055, this, zeroLengthObjectArray);
         return (Byte)this.postForAll(methodObject1055, this.delegate.byteValue());
      } catch (SQLException var2) {
         return (Byte)this.postForAll(methodObject1055, this.onErrorForAll(methodObject1055, var2));
      }
   }

   public float floatValue() throws SQLException {
      try {
         super.preForAll(methodObject1058, this, zeroLengthObjectArray);
         return (Float)this.postForAll(methodObject1058, this.delegate.floatValue());
      } catch (SQLException var2) {
         return (Float)this.postForAll(methodObject1058, this.onErrorForAll(methodObject1058, var2));
      }
   }

   public Reader characterStreamValue() throws SQLException {
      try {
         super.preForAll(methodObject1067, this, zeroLengthObjectArray);
         return (Reader)this.postForAll(methodObject1067, (Object)this.delegate.characterStreamValue());
      } catch (SQLException var2) {
         return (Reader)this.postForAll(methodObject1067, this.onErrorForAll(methodObject1067, var2));
      }
   }

   public Object toJdbc(Map arg0) throws SQLException {
      try {
         super.preForAll(methodObject1043, this, arg0);
         return this.postForAll(methodObject1043, this.proxyFactory.proxyForCache(this.delegate.toJdbc(arg0), this, this.proxyCache, methodObject1043));
      } catch (SQLException var3) {
         return this.postForAll(methodObject1043, this.onErrorForAll(methodObject1043, var3));
      }
   }

   public byte[] toBytes() throws SQLException {
      try {
         super.preForAll(methodObject1046, this, zeroLengthObjectArray);
         return (byte[])this.postForAll(methodObject1046, (Object)this.delegate.toBytes());
      } catch (SQLException var2) {
         return (byte[])this.postForAll(methodObject1046, this.onErrorForAll(methodObject1046, var2));
      }
   }

   public InputStream getStream() throws SQLException {
      try {
         super.preForAll(methodObject1071, this, zeroLengthObjectArray);
         return (InputStream)this.postForAll(methodObject1071, (Object)this.delegate.getStream());
      } catch (SQLException var2) {
         return (InputStream)this.postForAll(methodObject1071, this.onErrorForAll(methodObject1071, var2));
      }
   }

   public long getLength() {
      super.preForAll(methodObject1053, this, zeroLengthObjectArray);
      return (Long)this.postForAll(methodObject1053, this.delegate.getLength());
   }

   public Time timeValue() throws SQLException {
      try {
         super.preForAll(methodObject1063, this, zeroLengthObjectArray);
         return (Time)this.postForAll(methodObject1063, (Object)this.delegate.timeValue());
      } catch (SQLException var2) {
         return (Time)this.postForAll(methodObject1063, this.onErrorForAll(methodObject1063, var2));
      }
   }

   public void setPhysicalConnectionOf(Connection arg0) {
      super.preForAll(methodObject1077, this, arg0);
      Method var10001 = methodObject1077;
      this.delegate.setPhysicalConnectionOf(arg0 instanceof _Proxy_ ? (Connection)((_Proxy_)arg0)._getDelegate_() : arg0);
      this.postForAll(var10001);
   }

   public oracle.jdbc.driver.OracleConnection getConnection() throws SQLException {
      try {
         super.preForAll(methodObject1079, this, zeroLengthObjectArray);
         return (oracle.jdbc.driver.OracleConnection)this.postForAll(methodObject1079, (Object)this.delegate.getConnection());
      } catch (SQLException var2) {
         return (oracle.jdbc.driver.OracleConnection)this.postForAll(methodObject1079, this.onErrorForAll(methodObject1079, var2));
      }
   }

   public OracleOpaque _getDelegate_() {
      return this.delegate;
   }

   public Object getDelegate() {
      return this.delegate;
   }

   public void setDelegate(Object delegate) {
      this.proxyFactory.updateDelegate(this, this.delegate, delegate);
      this.delegate = (OracleOpaque)delegate;
   }

   public Object getCreator() {
      return this.creator;
   }

   static {
      try {
         methodObject1073 = OracleDatumWithConnection.class.getDeclaredMethod("stringValue", Connection.class);
         methodObject1050 = OracleOpaque.class.getDeclaredMethod("getImageLength");
         methodObject1051 = OracleOpaque.class.getDeclaredMethod("getJavaSqlConnection");
         methodObject1054 = OracleDatumWithConnection.class.getDeclaredMethod("booleanValue");
         methodObject1049 = OracleOpaque.class.getDeclaredMethod("getImageOffset");
         methodObject1039 = OracleOpaque.class.getDeclaredMethod("isConvertibleTo", Class.class);
         methodObject1081 = oracle.jdbc.OracleOpaque.class.getDeclaredMethod("getSQLTypeName");
         methodObject1041 = OracleOpaque.class.getDeclaredMethod("getMap");
         methodObject1065 = OracleDatumWithConnection.class.getDeclaredMethod("timestampValue");
         methodObject1056 = OracleDatumWithConnection.class.getDeclaredMethod("intValue");
         methodObject1072 = OracleDatumWithConnection.class.getDeclaredMethod("stringValue");
         methodObject1064 = OracleDatumWithConnection.class.getDeclaredMethod("timeValue", Calendar.class);
         methodObject1045 = OracleOpaque.class.getDeclaredMethod("setDescriptor", OpaqueDescriptor.class);
         methodObject1066 = OracleDatumWithConnection.class.getDeclaredMethod("timestampValue", Calendar.class);
         methodObject1068 = OracleDatumWithConnection.class.getDeclaredMethod("asciiStreamValue");
         methodObject1080 = oracle.jdbc.OracleOpaque.class.getDeclaredMethod("getValue");
         methodObject1061 = OracleDatumWithConnection.class.getDeclaredMethod("shareBytes");
         methodObject1059 = OracleDatumWithConnection.class.getDeclaredMethod("doubleValue");
         methodObject1057 = OracleDatumWithConnection.class.getDeclaredMethod("longValue");
         methodObject1036 = OracleOpaque.class.getDeclaredMethod("getDescriptor");
         methodObject1076 = OracleDatumWithConnection.class.getDeclaredMethod("getInternalConnection");
         methodObject1070 = OracleDatumWithConnection.class.getDeclaredMethod("setShareBytes", byte[].class);
         methodObject1048 = OracleOpaque.class.getDeclaredMethod("setImageLength", Long.TYPE);
         methodObject1038 = OracleOpaque.class.getDeclaredMethod("toClass", Class.class, Map.class);
         methodObject1040 = OracleOpaque.class.getDeclaredMethod("setValue", byte[].class);
         methodObject1044 = OracleOpaque.class.getDeclaredMethod("makeJdbcArray", Integer.TYPE);
         methodObject1060 = OracleDatumWithConnection.class.getDeclaredMethod("getBytes");
         methodObject1069 = OracleDatumWithConnection.class.getDeclaredMethod("binaryStreamValue");
         methodObject1083 = ACProxyable.class.getDeclaredMethod("setACProxy", Object.class);
         methodObject1078 = OracleDatumWithConnection.class.getDeclaredMethod("getOracleConnection");
         methodObject1084 = ACProxyable.class.getDeclaredMethod("getACProxy");
         methodObject1042 = OracleOpaque.class.getDeclaredMethod("toJdbc");
         methodObject1047 = OracleOpaque.class.getDeclaredMethod("setImage", byte[].class, Long.TYPE, Long.TYPE);
         methodObject1075 = OracleDatumWithConnection.class.getDeclaredMethod("dateValue");
         methodObject1037 = OracleOpaque.class.getDeclaredMethod("toClass", Class.class);
         methodObject1074 = OracleDatumWithConnection.class.getDeclaredMethod("bigDecimalValue");
         methodObject1052 = OracleOpaque.class.getDeclaredMethod("getBytesValue");
         methodObject1062 = OracleDatumWithConnection.class.getDeclaredMethod("setBytes", byte[].class);
         methodObject1082 = oracle.jdbc.OracleOpaque.class.getDeclaredMethod("getOracleMetaData");
         methodObject1055 = OracleDatumWithConnection.class.getDeclaredMethod("byteValue");
         methodObject1058 = OracleDatumWithConnection.class.getDeclaredMethod("floatValue");
         methodObject1067 = OracleDatumWithConnection.class.getDeclaredMethod("characterStreamValue");
         methodObject1043 = OracleOpaque.class.getDeclaredMethod("toJdbc", Map.class);
         methodObject1046 = OracleOpaque.class.getDeclaredMethod("toBytes");
         methodObject1071 = OracleDatumWithConnection.class.getDeclaredMethod("getStream");
         methodObject1053 = OracleDatumWithConnection.class.getDeclaredMethod("getLength");
         methodObject1063 = OracleDatumWithConnection.class.getDeclaredMethod("timeValue");
         methodObject1077 = OracleDatumWithConnection.class.getDeclaredMethod("setPhysicalConnectionOf", Connection.class);
         methodObject1079 = OracleDatumWithConnection.class.getDeclaredMethod("getConnection");
      } catch (Throwable var1) {
         throw new RuntimeException(var1);
      }
   }

   public oracle$1jdbc$1replay$1driver$1TxnReplayableOpaque$2oracle$1jdbc$1internal$1OracleOpaque$$$Proxy(OracleOpaque var1, Object var2, ProxyFactory var3, Map var4) {
      this.delegate = var1;
      this.creator = var2;
      this.proxyFactory = var3;
      this.proxyCache = var4;
   }
}
