package oracle.jdbc.proxy;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.SQLXML;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Map;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import oracle.jdbc.OracleTypeMetaData;
import oracle.jdbc.internal.ACProxyable;
import oracle.jdbc.internal.OracleConnection;
import oracle.jdbc.internal.OracleDatumWithConnection;
import oracle.jdbc.internal.OracleOpaque;
import oracle.jdbc.internal.XMLTypeIntf;
import oracle.jdbc.replay.driver.TxnReplayableSqlxml;
import oracle.sql.Datum;
import oracle.sql.ORAData;
import oracle.sql.OpaqueDescriptor;

public class oracle$1jdbc$1replay$1driver$1TxnReplayableSqlxml$2oracle$1jdbc$1internal$1XMLTypeIntf$$$Proxy extends TxnReplayableSqlxml implements XMLTypeIntf, _Proxy_ {
   private XMLTypeIntf delegate;
   private final Object creator;
   private final ProxyFactory proxyFactory;
   private final Map proxyCache;
   private static Object[] zeroLengthObjectArray = new Object[0];
   private static Method methodObject5031;
   private static Method methodObject5008;
   private static Method methodObject5009;
   private static Method methodObject5007;
   private static Method methodObject5012;
   private static Method methodObject4997;
   private static Method methodObject5039;
   private static Method methodObject4992;
   private static Method methodObject4999;
   private static Method methodObject5023;
   private static Method methodObject5014;
   private static Method methodObject5030;
   private static Method methodObject5022;
   private static Method methodObject5003;
   private static Method methodObject4986;
   private static Method methodObject5024;
   private static Method methodObject5026;
   private static Method methodObject5038;
   private static Method methodObject5019;
   private static Method methodObject5017;
   private static Method methodObject5015;
   private static Method methodObject4985;
   private static Method methodObject5034;
   private static Method methodObject4994;
   private static Method methodObject5028;
   private static Method methodObject4987;
   private static Method methodObject5006;
   private static Method methodObject4996;
   private static Method methodObject4988;
   private static Method methodObject4998;
   private static Method methodObject4990;
   private static Method methodObject5002;
   private static Method methodObject5018;
   private static Method methodObject4989;
   private static Method methodObject5027;
   private static Method methodObject5043;
   private static Method methodObject5041;
   private static Method methodObject5042;
   private static Method methodObject5036;
   private static Method methodObject5000;
   private static Method methodObject4991;
   private static Method methodObject5005;
   private static Method methodObject5033;
   private static Method methodObject4993;
   private static Method methodObject4995;
   private static Method methodObject5032;
   private static Method methodObject5010;
   private static Method methodObject5020;
   private static Method methodObject5040;
   private static Method methodObject5013;
   private static Method methodObject5016;
   private static Method methodObject5025;
   private static Method methodObject5001;
   private static Method methodObject5004;
   private static Method methodObject5029;
   private static Method methodObject5011;
   private static Method methodObject5021;
   private static Method methodObject5037;
   private static Method methodObject5035;

   public String stringValue(Connection arg0) throws SQLException {
      try {
         super.preForAll(methodObject5031, this, arg0);
         return (String)this.postForAll(methodObject5031, (Object)this.delegate.stringValue(arg0 instanceof _Proxy_ ? (Connection)((_Proxy_)arg0)._getDelegate_() : arg0));
      } catch (SQLException var3) {
         return (String)this.postForAll(methodObject5031, this.onErrorForAll(methodObject5031, var3));
      }
   }

   public long getImageLength() {
      super.preForAll(methodObject5008, this, zeroLengthObjectArray);
      return (Long)this.postForAll(methodObject5008, this.delegate.getImageLength());
   }

   public Connection getJavaSqlConnection() throws SQLException {
      try {
         super.preForAll(methodObject5009, this, zeroLengthObjectArray);
         return (Connection)this.postForAll(methodObject5009, this.proxyFactory.proxyForCache((Object)this.delegate.getJavaSqlConnection(), this, this.proxyCache, methodObject5009));
      } catch (SQLException var2) {
         return (Connection)this.postForAll(methodObject5009, this.onErrorForAll(methodObject5009, var2));
      }
   }

   public long getImageOffset() {
      super.preForAll(methodObject5007, this, zeroLengthObjectArray);
      return (Long)this.postForAll(methodObject5007, this.delegate.getImageOffset());
   }

   public boolean booleanValue() throws SQLException {
      try {
         super.preForAll(methodObject5012, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject5012, this.delegate.booleanValue());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject5012, this.onErrorForAll(methodObject5012, var2));
      }
   }

   public boolean isConvertibleTo(Class arg0) {
      super.preForAll(methodObject4997, this, arg0);
      return (Boolean)this.postForAll(methodObject4997, this.delegate.isConvertibleTo(arg0));
   }

   public String getSQLTypeName() throws SQLException {
      try {
         super.preForAll(methodObject5039, this, zeroLengthObjectArray);
         return (String)this.postForAll(methodObject5039, (Object)this.delegate.getSQLTypeName());
      } catch (SQLException var2) {
         return (String)this.postForAll(methodObject5039, this.onErrorForAll(methodObject5039, var2));
      }
   }

   public Source getSource(Class arg0) throws SQLException {
      try {
         super.preForAll(methodObject4992, this, arg0);
         return (Source)this.postForAll(methodObject4992, (Object)this.delegate.getSource(arg0));
      } catch (SQLException var3) {
         return (Source)this.postForAll(methodObject4992, this.onErrorForAll(methodObject4992, var3));
      }
   }

   public Map getMap() {
      super.preForAll(methodObject4999, this, zeroLengthObjectArray);
      return (Map)this.postForAll(methodObject4999, (Object)this.delegate.getMap());
   }

   public Timestamp timestampValue() throws SQLException {
      try {
         super.preForAll(methodObject5023, this, zeroLengthObjectArray);
         return (Timestamp)this.postForAll(methodObject5023, (Object)this.delegate.timestampValue());
      } catch (SQLException var2) {
         return (Timestamp)this.postForAll(methodObject5023, this.onErrorForAll(methodObject5023, var2));
      }
   }

   public int intValue() throws SQLException {
      try {
         super.preForAll(methodObject5014, this, zeroLengthObjectArray);
         return (Integer)this.postForAll(methodObject5014, this.delegate.intValue());
      } catch (SQLException var2) {
         return (Integer)this.postForAll(methodObject5014, this.onErrorForAll(methodObject5014, var2));
      }
   }

   public String stringValue() throws SQLException {
      try {
         super.preForAll(methodObject5030, this, zeroLengthObjectArray);
         return (String)this.postForAll(methodObject5030, (Object)this.delegate.stringValue());
      } catch (SQLException var2) {
         return (String)this.postForAll(methodObject5030, this.onErrorForAll(methodObject5030, var2));
      }
   }

   public Time timeValue(Calendar arg0) throws SQLException {
      try {
         super.preForAll(methodObject5022, this, arg0);
         return (Time)this.postForAll(methodObject5022, (Object)this.delegate.timeValue(arg0));
      } catch (SQLException var3) {
         return (Time)this.postForAll(methodObject5022, this.onErrorForAll(methodObject5022, var3));
      }
   }

   public void setDescriptor(OpaqueDescriptor arg0) {
      super.preForAll(methodObject5003, this, arg0);
      Method var10001 = methodObject5003;
      this.delegate.setDescriptor(arg0);
      this.postForAll(var10001);
   }

   public void free() throws SQLException {
      try {
         super.preForAll(methodObject4986, this, zeroLengthObjectArray);
         Method var10001 = methodObject4986;
         this.delegate.free();
         this.postForAll(var10001);
      } catch (SQLException var2) {
         this.onErrorVoidForAll(methodObject4986, var2);
      }
   }

   public Timestamp timestampValue(Calendar arg0) throws SQLException {
      try {
         super.preForAll(methodObject5024, this, arg0);
         return (Timestamp)this.postForAll(methodObject5024, (Object)this.delegate.timestampValue(arg0));
      } catch (SQLException var3) {
         return (Timestamp)this.postForAll(methodObject5024, this.onErrorForAll(methodObject5024, var3));
      }
   }

   public InputStream asciiStreamValue() throws SQLException {
      try {
         super.preForAll(methodObject5026, this, zeroLengthObjectArray);
         return (InputStream)this.postForAll(methodObject5026, (Object)this.delegate.asciiStreamValue());
      } catch (SQLException var2) {
         return (InputStream)this.postForAll(methodObject5026, this.onErrorForAll(methodObject5026, var2));
      }
   }

   public Object getValue() throws SQLException {
      try {
         super.preForAll(methodObject5038, this, zeroLengthObjectArray);
         return this.postForAll(methodObject5038, this.proxyFactory.proxyForCache(this.delegate.getValue(), this, this.proxyCache, methodObject5038));
      } catch (SQLException var2) {
         return this.postForAll(methodObject5038, this.onErrorForAll(methodObject5038, var2));
      }
   }

   public byte[] shareBytes() {
      super.preForAll(methodObject5019, this, zeroLengthObjectArray);
      return (byte[])this.postForAll(methodObject5019, (Object)this.delegate.shareBytes());
   }

   public double doubleValue() throws SQLException {
      try {
         super.preForAll(methodObject5017, this, zeroLengthObjectArray);
         return (Double)this.postForAll(methodObject5017, this.delegate.doubleValue());
      } catch (SQLException var2) {
         return (Double)this.postForAll(methodObject5017, this.onErrorForAll(methodObject5017, var2));
      }
   }

   public long longValue() throws SQLException {
      try {
         super.preForAll(methodObject5015, this, zeroLengthObjectArray);
         return (Long)this.postForAll(methodObject5015, this.delegate.longValue());
      } catch (SQLException var2) {
         return (Long)this.postForAll(methodObject5015, this.onErrorForAll(methodObject5015, var2));
      }
   }

   public String getString() throws SQLException {
      try {
         super.preForAll(methodObject4985, this, zeroLengthObjectArray);
         return (String)this.postForAll(methodObject4985, (Object)this.delegate.getString());
      } catch (SQLException var2) {
         return (String)this.postForAll(methodObject4985, this.onErrorForAll(methodObject4985, var2));
      }
   }

   public OracleConnection getInternalConnection() throws SQLException {
      try {
         super.preForAll(methodObject5034, this, zeroLengthObjectArray);
         return (OracleConnection)this.postForAll(methodObject5034, this.proxyFactory.proxyForCache((Object)this.delegate.getInternalConnection(), this, this.proxyCache, methodObject5034));
      } catch (SQLException var2) {
         return (OracleConnection)this.postForAll(methodObject5034, this.onErrorForAll(methodObject5034, var2));
      }
   }

   public OpaqueDescriptor getDescriptor() throws SQLException {
      try {
         super.preForAll(methodObject4994, this, zeroLengthObjectArray);
         return (OpaqueDescriptor)this.postForAll(methodObject4994, (Object)this.delegate.getDescriptor());
      } catch (SQLException var2) {
         return (OpaqueDescriptor)this.postForAll(methodObject4994, this.onErrorForAll(methodObject4994, var2));
      }
   }

   public void setShareBytes(byte[] arg0) {
      super.preForAll(methodObject5028, this, arg0);
      Method var10001 = methodObject5028;
      this.delegate.setShareBytes(arg0);
      this.postForAll(var10001);
   }

   public InputStream getBinaryStream() throws SQLException {
      try {
         super.preForAll(methodObject4987, this, zeroLengthObjectArray);
         return (InputStream)this.postForAll(methodObject4987, (Object)this.delegate.getBinaryStream());
      } catch (SQLException var2) {
         return (InputStream)this.postForAll(methodObject4987, this.onErrorForAll(methodObject4987, var2));
      }
   }

   public void setImageLength(long arg0) throws SQLException {
      try {
         super.preForAll(methodObject5006, this, arg0);
         Method var10001 = methodObject5006;
         this.delegate.setImageLength(arg0);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject5006, var4);
      }
   }

   public Object toClass(Class arg0, Map arg1) throws SQLException {
      try {
         super.preForAll(methodObject4996, this, arg0, arg1);
         return this.postForAll(methodObject4996, this.proxyFactory.proxyForCache(this.delegate.toClass(arg0, arg1), this, this.proxyCache, methodObject4996));
      } catch (SQLException var4) {
         return this.postForAll(methodObject4996, this.onErrorForAll(methodObject4996, var4));
      }
   }

   public Reader getCharacterStream() throws SQLException {
      try {
         super.preForAll(methodObject4988, this, zeroLengthObjectArray);
         return (Reader)this.postForAll(methodObject4988, (Object)this.delegate.getCharacterStream());
      } catch (SQLException var2) {
         return (Reader)this.postForAll(methodObject4988, this.onErrorForAll(methodObject4988, var2));
      }
   }

   public void setValue(byte[] arg0) throws SQLException {
      try {
         super.preForAll(methodObject4998, this, arg0);
         Method var10001 = methodObject4998;
         this.delegate.setValue(arg0);
         this.postForAll(var10001);
      } catch (SQLException var3) {
         this.onErrorVoidForAll(methodObject4998, var3);
      }
   }

   public Writer setCharacterStream() throws SQLException {
      try {
         super.preForAll(methodObject4990, this, zeroLengthObjectArray);
         return (Writer)this.postForAll(methodObject4990, (Object)this.delegate.setCharacterStream());
      } catch (SQLException var2) {
         return (Writer)this.postForAll(methodObject4990, this.onErrorForAll(methodObject4990, var2));
      }
   }

   public Object makeJdbcArray(int arg0) {
      super.preForAll(methodObject5002, this, arg0);
      return this.postForAll(methodObject5002, this.proxyFactory.proxyForCache(this.delegate.makeJdbcArray(arg0), this, this.proxyCache, methodObject5002));
   }

   public byte[] getBytes() {
      super.preForAll(methodObject5018, this, zeroLengthObjectArray);
      return (byte[])this.postForAll(methodObject5018, (Object)this.delegate.getBytes());
   }

   public void setString(String arg0) throws SQLException {
      try {
         super.preForAll(methodObject4989, this, arg0);
         Method var10001 = methodObject4989;
         this.delegate.setString(arg0);
         this.postForAll(var10001);
      } catch (SQLException var3) {
         this.onErrorVoidForAll(methodObject4989, var3);
      }
   }

   public InputStream binaryStreamValue() throws SQLException {
      try {
         super.preForAll(methodObject5027, this, zeroLengthObjectArray);
         return (InputStream)this.postForAll(methodObject5027, (Object)this.delegate.binaryStreamValue());
      } catch (SQLException var2) {
         return (InputStream)this.postForAll(methodObject5027, this.onErrorForAll(methodObject5027, var2));
      }
   }

   public Datum toDatum(Connection arg0) throws SQLException {
      try {
         super.preForAll(methodObject5043, this, arg0);
         return (Datum)this.postForAll(methodObject5043, (Object)this.delegate.toDatum(arg0 instanceof _Proxy_ ? (Connection)((_Proxy_)arg0)._getDelegate_() : arg0));
      } catch (SQLException var3) {
         return (Datum)this.postForAll(methodObject5043, this.onErrorForAll(methodObject5043, var3));
      }
   }

   public void setACProxy(Object arg0) {
      super.preForAll(methodObject5041, this, arg0);
      Method var10001 = methodObject5041;
      this.delegate.setACProxy(arg0 instanceof _Proxy_ ? (Object)((_Proxy_)arg0)._getDelegate_() : arg0);
      this.postForAll(var10001);
   }

   public Object getACProxy() {
      super.preForAll(methodObject5042, this, zeroLengthObjectArray);
      return this.postForAll(methodObject5042, this.proxyFactory.proxyForCache(this.delegate.getACProxy(), this, this.proxyCache, methodObject5042));
   }

   public oracle.jdbc.OracleConnection getOracleConnection() throws SQLException {
      try {
         super.preForAll(methodObject5036, this, zeroLengthObjectArray);
         return (oracle.jdbc.OracleConnection)this.postForAll(methodObject5036, this.proxyFactory.proxyForCache((Object)this.delegate.getOracleConnection(), this, this.proxyCache, methodObject5036));
      } catch (SQLException var2) {
         return (oracle.jdbc.OracleConnection)this.postForAll(methodObject5036, this.onErrorForAll(methodObject5036, var2));
      }
   }

   public Object toJdbc() throws SQLException {
      try {
         super.preForAll(methodObject5000, this, zeroLengthObjectArray);
         return this.postForAll(methodObject5000, this.proxyFactory.proxyForCache(this.delegate.toJdbc(), this, this.proxyCache, methodObject5000));
      } catch (SQLException var2) {
         return this.postForAll(methodObject5000, this.onErrorForAll(methodObject5000, var2));
      }
   }

   public OutputStream setBinaryStream() throws SQLException {
      try {
         super.preForAll(methodObject4991, this, zeroLengthObjectArray);
         return (OutputStream)this.postForAll(methodObject4991, (Object)this.delegate.setBinaryStream());
      } catch (SQLException var2) {
         return (OutputStream)this.postForAll(methodObject4991, this.onErrorForAll(methodObject4991, var2));
      }
   }

   public void setImage(byte[] arg0, long arg1, long arg2) throws SQLException {
      try {
         super.preForAll(methodObject5005, this, arg0, arg1, arg2);
         Method var10001 = methodObject5005;
         this.delegate.setImage(arg0, arg1, arg2);
         this.postForAll(var10001);
      } catch (SQLException var7) {
         this.onErrorVoidForAll(methodObject5005, var7);
      }
   }

   public Date dateValue() throws SQLException {
      try {
         super.preForAll(methodObject5033, this, zeroLengthObjectArray);
         return (Date)this.postForAll(methodObject5033, (Object)this.delegate.dateValue());
      } catch (SQLException var2) {
         return (Date)this.postForAll(methodObject5033, this.onErrorForAll(methodObject5033, var2));
      }
   }

   public Result setResult(Class arg0) throws SQLException {
      try {
         super.preForAll(methodObject4993, this, arg0);
         return (Result)this.postForAll(methodObject4993, (Object)this.delegate.setResult(arg0));
      } catch (SQLException var3) {
         return (Result)this.postForAll(methodObject4993, this.onErrorForAll(methodObject4993, var3));
      }
   }

   public Object toClass(Class arg0) throws SQLException {
      try {
         super.preForAll(methodObject4995, this, arg0);
         return this.postForAll(methodObject4995, this.proxyFactory.proxyForCache(this.delegate.toClass(arg0), this, this.proxyCache, methodObject4995));
      } catch (SQLException var3) {
         return this.postForAll(methodObject4995, this.onErrorForAll(methodObject4995, var3));
      }
   }

   public BigDecimal bigDecimalValue() throws SQLException {
      try {
         super.preForAll(methodObject5032, this, zeroLengthObjectArray);
         return (BigDecimal)this.postForAll(methodObject5032, (Object)this.delegate.bigDecimalValue());
      } catch (SQLException var2) {
         return (BigDecimal)this.postForAll(methodObject5032, this.onErrorForAll(methodObject5032, var2));
      }
   }

   public byte[] getBytesValue() throws SQLException {
      try {
         super.preForAll(methodObject5010, this, zeroLengthObjectArray);
         return (byte[])this.postForAll(methodObject5010, (Object)this.delegate.getBytesValue());
      } catch (SQLException var2) {
         return (byte[])this.postForAll(methodObject5010, this.onErrorForAll(methodObject5010, var2));
      }
   }

   public void setBytes(byte[] arg0) {
      super.preForAll(methodObject5020, this, arg0);
      Method var10001 = methodObject5020;
      this.delegate.setBytes(arg0);
      this.postForAll(var10001);
   }

   public OracleTypeMetaData getOracleMetaData() throws SQLException {
      try {
         super.preForAll(methodObject5040, this, zeroLengthObjectArray);
         return (OracleTypeMetaData)this.postForAll(methodObject5040, this.proxyFactory.proxyForCache((Object)this.delegate.getOracleMetaData(), this, this.proxyCache, methodObject5040));
      } catch (SQLException var2) {
         return (OracleTypeMetaData)this.postForAll(methodObject5040, this.onErrorForAll(methodObject5040, var2));
      }
   }

   public byte byteValue() throws SQLException {
      try {
         super.preForAll(methodObject5013, this, zeroLengthObjectArray);
         return (Byte)this.postForAll(methodObject5013, this.delegate.byteValue());
      } catch (SQLException var2) {
         return (Byte)this.postForAll(methodObject5013, this.onErrorForAll(methodObject5013, var2));
      }
   }

   public float floatValue() throws SQLException {
      try {
         super.preForAll(methodObject5016, this, zeroLengthObjectArray);
         return (Float)this.postForAll(methodObject5016, this.delegate.floatValue());
      } catch (SQLException var2) {
         return (Float)this.postForAll(methodObject5016, this.onErrorForAll(methodObject5016, var2));
      }
   }

   public Reader characterStreamValue() throws SQLException {
      try {
         super.preForAll(methodObject5025, this, zeroLengthObjectArray);
         return (Reader)this.postForAll(methodObject5025, (Object)this.delegate.characterStreamValue());
      } catch (SQLException var2) {
         return (Reader)this.postForAll(methodObject5025, this.onErrorForAll(methodObject5025, var2));
      }
   }

   public Object toJdbc(Map arg0) throws SQLException {
      try {
         super.preForAll(methodObject5001, this, arg0);
         return this.postForAll(methodObject5001, this.proxyFactory.proxyForCache(this.delegate.toJdbc(arg0), this, this.proxyCache, methodObject5001));
      } catch (SQLException var3) {
         return this.postForAll(methodObject5001, this.onErrorForAll(methodObject5001, var3));
      }
   }

   public byte[] toBytes() throws SQLException {
      try {
         super.preForAll(methodObject5004, this, zeroLengthObjectArray);
         return (byte[])this.postForAll(methodObject5004, (Object)this.delegate.toBytes());
      } catch (SQLException var2) {
         return (byte[])this.postForAll(methodObject5004, this.onErrorForAll(methodObject5004, var2));
      }
   }

   public InputStream getStream() throws SQLException {
      try {
         super.preForAll(methodObject5029, this, zeroLengthObjectArray);
         return (InputStream)this.postForAll(methodObject5029, (Object)this.delegate.getStream());
      } catch (SQLException var2) {
         return (InputStream)this.postForAll(methodObject5029, this.onErrorForAll(methodObject5029, var2));
      }
   }

   public long getLength() {
      super.preForAll(methodObject5011, this, zeroLengthObjectArray);
      return (Long)this.postForAll(methodObject5011, this.delegate.getLength());
   }

   public Time timeValue() throws SQLException {
      try {
         super.preForAll(methodObject5021, this, zeroLengthObjectArray);
         return (Time)this.postForAll(methodObject5021, (Object)this.delegate.timeValue());
      } catch (SQLException var2) {
         return (Time)this.postForAll(methodObject5021, this.onErrorForAll(methodObject5021, var2));
      }
   }

   public oracle.jdbc.driver.OracleConnection getConnection() throws SQLException {
      try {
         super.preForAll(methodObject5037, this, zeroLengthObjectArray);
         return (oracle.jdbc.driver.OracleConnection)this.postForAll(methodObject5037, (Object)this.delegate.getConnection());
      } catch (SQLException var2) {
         return (oracle.jdbc.driver.OracleConnection)this.postForAll(methodObject5037, this.onErrorForAll(methodObject5037, var2));
      }
   }

   public void setPhysicalConnectionOf(Connection arg0) {
      super.preForAll(methodObject5035, this, arg0);
      Method var10001 = methodObject5035;
      this.delegate.setPhysicalConnectionOf(arg0 instanceof _Proxy_ ? (Connection)((_Proxy_)arg0)._getDelegate_() : arg0);
      this.postForAll(var10001);
   }

   public XMLTypeIntf _getDelegate_() {
      return this.delegate;
   }

   public Object getDelegate() {
      return this.delegate;
   }

   public void setDelegate(Object delegate) {
      this.proxyFactory.updateDelegate(this, this.delegate, delegate);
      this.delegate = (XMLTypeIntf)delegate;
   }

   public Object getCreator() {
      return this.creator;
   }

   static {
      try {
         methodObject5031 = OracleDatumWithConnection.class.getDeclaredMethod("stringValue", Connection.class);
         methodObject5008 = OracleOpaque.class.getDeclaredMethod("getImageLength");
         methodObject5009 = OracleOpaque.class.getDeclaredMethod("getJavaSqlConnection");
         methodObject5007 = OracleOpaque.class.getDeclaredMethod("getImageOffset");
         methodObject5012 = OracleDatumWithConnection.class.getDeclaredMethod("booleanValue");
         methodObject4997 = OracleOpaque.class.getDeclaredMethod("isConvertibleTo", Class.class);
         methodObject5039 = oracle.jdbc.OracleOpaque.class.getDeclaredMethod("getSQLTypeName");
         methodObject4992 = SQLXML.class.getDeclaredMethod("getSource", Class.class);
         methodObject4999 = OracleOpaque.class.getDeclaredMethod("getMap");
         methodObject5023 = OracleDatumWithConnection.class.getDeclaredMethod("timestampValue");
         methodObject5014 = OracleDatumWithConnection.class.getDeclaredMethod("intValue");
         methodObject5030 = OracleDatumWithConnection.class.getDeclaredMethod("stringValue");
         methodObject5022 = OracleDatumWithConnection.class.getDeclaredMethod("timeValue", Calendar.class);
         methodObject5003 = OracleOpaque.class.getDeclaredMethod("setDescriptor", OpaqueDescriptor.class);
         methodObject4986 = SQLXML.class.getDeclaredMethod("free");
         methodObject5024 = OracleDatumWithConnection.class.getDeclaredMethod("timestampValue", Calendar.class);
         methodObject5026 = OracleDatumWithConnection.class.getDeclaredMethod("asciiStreamValue");
         methodObject5038 = oracle.jdbc.OracleOpaque.class.getDeclaredMethod("getValue");
         methodObject5019 = OracleDatumWithConnection.class.getDeclaredMethod("shareBytes");
         methodObject5017 = OracleDatumWithConnection.class.getDeclaredMethod("doubleValue");
         methodObject5015 = OracleDatumWithConnection.class.getDeclaredMethod("longValue");
         methodObject4985 = SQLXML.class.getDeclaredMethod("getString");
         methodObject5034 = OracleDatumWithConnection.class.getDeclaredMethod("getInternalConnection");
         methodObject4994 = OracleOpaque.class.getDeclaredMethod("getDescriptor");
         methodObject5028 = OracleDatumWithConnection.class.getDeclaredMethod("setShareBytes", byte[].class);
         methodObject4987 = SQLXML.class.getDeclaredMethod("getBinaryStream");
         methodObject5006 = OracleOpaque.class.getDeclaredMethod("setImageLength", Long.TYPE);
         methodObject4996 = OracleOpaque.class.getDeclaredMethod("toClass", Class.class, Map.class);
         methodObject4988 = SQLXML.class.getDeclaredMethod("getCharacterStream");
         methodObject4998 = OracleOpaque.class.getDeclaredMethod("setValue", byte[].class);
         methodObject4990 = SQLXML.class.getDeclaredMethod("setCharacterStream");
         methodObject5002 = OracleOpaque.class.getDeclaredMethod("makeJdbcArray", Integer.TYPE);
         methodObject5018 = OracleDatumWithConnection.class.getDeclaredMethod("getBytes");
         methodObject4989 = SQLXML.class.getDeclaredMethod("setString", String.class);
         methodObject5027 = OracleDatumWithConnection.class.getDeclaredMethod("binaryStreamValue");
         methodObject5043 = ORAData.class.getDeclaredMethod("toDatum", Connection.class);
         methodObject5041 = ACProxyable.class.getDeclaredMethod("setACProxy", Object.class);
         methodObject5042 = ACProxyable.class.getDeclaredMethod("getACProxy");
         methodObject5036 = OracleDatumWithConnection.class.getDeclaredMethod("getOracleConnection");
         methodObject5000 = OracleOpaque.class.getDeclaredMethod("toJdbc");
         methodObject4991 = SQLXML.class.getDeclaredMethod("setBinaryStream");
         methodObject5005 = OracleOpaque.class.getDeclaredMethod("setImage", byte[].class, Long.TYPE, Long.TYPE);
         methodObject5033 = OracleDatumWithConnection.class.getDeclaredMethod("dateValue");
         methodObject4993 = SQLXML.class.getDeclaredMethod("setResult", Class.class);
         methodObject4995 = OracleOpaque.class.getDeclaredMethod("toClass", Class.class);
         methodObject5032 = OracleDatumWithConnection.class.getDeclaredMethod("bigDecimalValue");
         methodObject5010 = OracleOpaque.class.getDeclaredMethod("getBytesValue");
         methodObject5020 = OracleDatumWithConnection.class.getDeclaredMethod("setBytes", byte[].class);
         methodObject5040 = oracle.jdbc.OracleOpaque.class.getDeclaredMethod("getOracleMetaData");
         methodObject5013 = OracleDatumWithConnection.class.getDeclaredMethod("byteValue");
         methodObject5016 = OracleDatumWithConnection.class.getDeclaredMethod("floatValue");
         methodObject5025 = OracleDatumWithConnection.class.getDeclaredMethod("characterStreamValue");
         methodObject5001 = OracleOpaque.class.getDeclaredMethod("toJdbc", Map.class);
         methodObject5004 = OracleOpaque.class.getDeclaredMethod("toBytes");
         methodObject5029 = OracleDatumWithConnection.class.getDeclaredMethod("getStream");
         methodObject5011 = OracleDatumWithConnection.class.getDeclaredMethod("getLength");
         methodObject5021 = OracleDatumWithConnection.class.getDeclaredMethod("timeValue");
         methodObject5037 = OracleDatumWithConnection.class.getDeclaredMethod("getConnection");
         methodObject5035 = OracleDatumWithConnection.class.getDeclaredMethod("setPhysicalConnectionOf", Connection.class);
      } catch (Throwable var1) {
         throw new RuntimeException(var1);
      }
   }

   public oracle$1jdbc$1replay$1driver$1TxnReplayableSqlxml$2oracle$1jdbc$1internal$1XMLTypeIntf$$$Proxy(XMLTypeIntf var1, Object var2, ProxyFactory var3, Map var4) {
      this.delegate = var1;
      this.creator = var2;
      this.proxyFactory = var3;
      this.proxyCache = var4;
   }
}
