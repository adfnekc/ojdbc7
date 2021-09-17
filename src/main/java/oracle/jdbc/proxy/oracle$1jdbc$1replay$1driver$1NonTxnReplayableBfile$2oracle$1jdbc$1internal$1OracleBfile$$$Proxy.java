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
import oracle.jdbc.LargeObjectAccessMode;
import oracle.jdbc.internal.ACProxyable;
import oracle.jdbc.internal.OracleBfile;
import oracle.jdbc.internal.OracleConnection;
import oracle.jdbc.internal.OracleDatumWithConnection;
import oracle.jdbc.replay.driver.NonTxnReplayableBfile;
import oracle.sql.BFILE;
import oracle.sql.BfileDBAccess;

public abstract class oracle$1jdbc$1replay$1driver$1NonTxnReplayableBfile$2oracle$1jdbc$1internal$1OracleBfile$$$Proxy extends NonTxnReplayableBfile implements OracleBfile, _Proxy_ {
   private OracleBfile delegate;
   private final Object creator;
   private final ProxyFactory proxyFactory;
   private final Map proxyCache;
   private static Object[] zeroLengthObjectArray = new Object[0];
   private static Method methodObject30354;
   private static Method methodObject30336;
   private static Method methodObject30378;
   private static Method methodObject30380;
   private static Method methodObject30373;
   private static Method methodObject30342;
   private static Method methodObject30344;
   private static Method methodObject30333;
   private static Method methodObject30372;
   private static Method methodObject30383;
   private static Method methodObject30362;
   private static Method methodObject30346;
   private static Method methodObject30365;
   private static Method methodObject30356;
   private static Method methodObject30382;
   private static Method methodObject30357;
   private static Method methodObject30368;
   private static Method methodObject30371;
   private static Method methodObject30339;
   private static Method methodObject30352;
   private static Method methodObject30349;
   private static Method methodObject30334;
   private static Method methodObject30374;
   private static Method methodObject30379;
   private static Method methodObject30335;
   private static Method methodObject30377;
   private static Method methodObject30347;
   private static Method methodObject30363;
   private static Method methodObject30369;
   private static Method methodObject30370;
   private static Method methodObject30351;
   private static Method methodObject30376;
   private static Method methodObject30332;
   private static Method methodObject30350;
   private static Method methodObject30361;
   private static Method methodObject30340;
   private static Method methodObject30331;
   private static Method methodObject30384;
   private static Method methodObject30364;
   private static Method methodObject30337;
   private static Method methodObject30375;
   private static Method methodObject30359;
   private static Method methodObject30353;
   private static Method methodObject30358;
   private static Method methodObject30381;
   private static Method methodObject30341;
   private static Method methodObject30345;
   private static Method methodObject30348;
   private static Method methodObject30338;
   private static Method methodObject30355;
   private static Method methodObject30343;
   private static Method methodObject30360;
   private static Method methodObject30367;
   private static Method methodObject30366;

   public void setShareBytes(byte[] arg0) {
      super.preForAll(methodObject30354, this, arg0);
      this.delegate.setShareBytes(arg0);
   }

   public void setLocator(byte[] arg0) {
      super.preForAll(methodObject30336, this, arg0);
      this.delegate.setLocator(arg0);
   }

   public void openFile() throws SQLException {
      try {
         super.preForAll(methodObject30378, this, zeroLengthObjectArray);
         this.delegate.openFile();
      } catch (SQLException var2) {
         this.onErrorVoidForAll(methodObject30378, var2);
      }
   }

   public boolean fileExists() throws SQLException {
      try {
         super.preForAll(methodObject30380, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject30380, this.delegate.fileExists());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject30380, this.onErrorForAll(methodObject30380, var2));
      }
   }

   public void close() throws SQLException {
      try {
         super.preForAll(methodObject30373, this, zeroLengthObjectArray);
         this.delegate.close();
      } catch (SQLException var2) {
         this.onErrorVoidForAll(methodObject30373, var2);
      }
   }

   public Connection getJavaSqlConnection() throws SQLException {
      try {
         super.preForAll(methodObject30342, this, zeroLengthObjectArray);
         return (Connection)this.postForAll(methodObject30342, this.proxyFactory.proxyForCache((Object)this.delegate.getJavaSqlConnection(), this, this.proxyCache, methodObject30342));
      } catch (SQLException var2) {
         return (Connection)this.postForAll(methodObject30342, this.onErrorForAll(methodObject30342, var2));
      }
   }

   public boolean booleanValue() throws SQLException {
      try {
         super.preForAll(methodObject30344, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject30344, this.delegate.booleanValue());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject30344, this.onErrorForAll(methodObject30344, var2));
      }
   }

   public void setLength(long arg0) {
      super.preForAll(methodObject30333, this, arg0);
      this.delegate.setLength(arg0);
   }

   public long position(oracle.jdbc.OracleBfile arg0, long arg1) throws SQLException {
      try {
         super.preForAll(methodObject30372, this, arg0, arg1);
         return (Long)this.postForAll(methodObject30372, this.delegate.position(arg0 instanceof _Proxy_ ? (oracle.jdbc.OracleBfile)((_Proxy_)arg0)._getDelegate_() : arg0, arg1));
      } catch (SQLException var5) {
         return (Long)this.postForAll(methodObject30372, this.onErrorForAll(methodObject30372, var5));
      }
   }

   public void setACProxy(Object arg0) {
      super.preForAll(methodObject30383, this, arg0);
      this.delegate.setACProxy(arg0 instanceof _Proxy_ ? (Object)((_Proxy_)arg0)._getDelegate_() : arg0);
   }

   public Timestamp timestampValue() throws SQLException {
      try {
         super.preForAll(methodObject30362, this, zeroLengthObjectArray);
         return (Timestamp)this.postForAll(methodObject30362, (Object)this.delegate.timestampValue());
      } catch (SQLException var2) {
         return (Timestamp)this.postForAll(methodObject30362, this.onErrorForAll(methodObject30362, var2));
      }
   }

   public int intValue() throws SQLException {
      try {
         super.preForAll(methodObject30346, this, zeroLengthObjectArray);
         return (Integer)this.postForAll(methodObject30346, this.delegate.intValue());
      } catch (SQLException var2) {
         return (Integer)this.postForAll(methodObject30346, this.onErrorForAll(methodObject30346, var2));
      }
   }

   public void setPhysicalConnectionOf(Connection arg0) {
      super.preForAll(methodObject30365, this, arg0);
      this.delegate.setPhysicalConnectionOf(arg0 instanceof _Proxy_ ? (Connection)((_Proxy_)arg0)._getDelegate_() : arg0);
   }

   public String stringValue() throws SQLException {
      try {
         super.preForAll(methodObject30356, this, zeroLengthObjectArray);
         return (String)this.postForAll(methodObject30356, (Object)this.delegate.stringValue());
      } catch (SQLException var2) {
         return (String)this.postForAll(methodObject30356, this.onErrorForAll(methodObject30356, var2));
      }
   }

   public String getDirAlias() throws SQLException {
      try {
         super.preForAll(methodObject30382, this, zeroLengthObjectArray);
         return (String)this.postForAll(methodObject30382, (Object)this.delegate.getDirAlias());
      } catch (SQLException var2) {
         return (String)this.postForAll(methodObject30382, this.onErrorForAll(methodObject30382, var2));
      }
   }

   public String stringValue(Connection arg0) throws SQLException {
      try {
         super.preForAll(methodObject30357, this, arg0);
         return (String)this.postForAll(methodObject30357, (Object)this.delegate.stringValue(arg0 instanceof _Proxy_ ? (Connection)((_Proxy_)arg0)._getDelegate_() : arg0));
      } catch (SQLException var3) {
         return (String)this.postForAll(methodObject30357, this.onErrorForAll(methodObject30357, var3));
      }
   }

   public byte[] getBytes(long arg0, int arg1) throws SQLException {
      try {
         super.preForAll(methodObject30368, this, arg0, arg1);
         return (byte[])this.postForAll(methodObject30368, (Object)this.delegate.getBytes(arg0, arg1));
      } catch (SQLException var5) {
         return (byte[])this.postForAll(methodObject30368, this.onErrorForAll(methodObject30368, var5));
      }
   }

   public long position(byte[] arg0, long arg1) throws SQLException {
      try {
         super.preForAll(methodObject30371, this, arg0, arg1);
         return (Long)this.postForAll(methodObject30371, this.delegate.position(arg0, arg1));
      } catch (SQLException var5) {
         return (Long)this.postForAll(methodObject30371, this.onErrorForAll(methodObject30371, var5));
      }
   }

   public InputStream asciiStreamValue() throws SQLException {
      try {
         super.preForAll(methodObject30339, this, zeroLengthObjectArray);
         return (InputStream)this.postForAll(methodObject30339, (Object)this.delegate.asciiStreamValue());
      } catch (SQLException var2) {
         return (InputStream)this.postForAll(methodObject30339, this.onErrorForAll(methodObject30339, var2));
      }
   }

   public byte[] shareBytes() {
      super.preForAll(methodObject30352, this, zeroLengthObjectArray);
      return (byte[])this.postForAll(methodObject30352, (Object)this.delegate.shareBytes());
   }

   public double doubleValue() throws SQLException {
      try {
         super.preForAll(methodObject30349, this, zeroLengthObjectArray);
         return (Double)this.postForAll(methodObject30349, this.delegate.doubleValue());
      } catch (SQLException var2) {
         return (Double)this.postForAll(methodObject30349, this.onErrorForAll(methodObject30349, var2));
      }
   }

   public BfileDBAccess getDBAccess() throws SQLException {
      try {
         super.preForAll(methodObject30334, this, zeroLengthObjectArray);
         return (BfileDBAccess)this.postForAll(methodObject30334, (Object)this.delegate.getDBAccess());
      } catch (SQLException var2) {
         return (BfileDBAccess)this.postForAll(methodObject30334, this.onErrorForAll(methodObject30334, var2));
      }
   }

   public void open(LargeObjectAccessMode arg0) throws SQLException {
      try {
         super.preForAll(methodObject30374, this, arg0);
         this.delegate.open(arg0);
      } catch (SQLException var3) {
         this.onErrorVoidForAll(methodObject30374, var3);
      }
   }

   public boolean isFileOpen() throws SQLException {
      try {
         super.preForAll(methodObject30379, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject30379, this.delegate.isFileOpen());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject30379, this.onErrorForAll(methodObject30379, var2));
      }
   }

   public byte[] getLocator() {
      super.preForAll(methodObject30335, this, zeroLengthObjectArray);
      return (byte[])this.postForAll(methodObject30335, (Object)this.delegate.getLocator());
   }

   public InputStream getBinaryStream(long arg0) throws SQLException {
      try {
         super.preForAll(methodObject30377, this, arg0);
         return (InputStream)this.postForAll(methodObject30377, (Object)super.getBinaryStream(arg0));
      } catch (SQLException var4) {
         return (InputStream)this.postForAll(methodObject30377, this.onErrorForAll(methodObject30377, var4));
      }
   }

   public long longValue() throws SQLException {
      try {
         super.preForAll(methodObject30347, this, zeroLengthObjectArray);
         return (Long)this.postForAll(methodObject30347, this.delegate.longValue());
      } catch (SQLException var2) {
         return (Long)this.postForAll(methodObject30347, this.onErrorForAll(methodObject30347, var2));
      }
   }

   public Timestamp timestampValue(Calendar arg0) throws SQLException {
      try {
         super.preForAll(methodObject30363, this, arg0);
         return (Timestamp)this.postForAll(methodObject30363, (Object)this.delegate.timestampValue(arg0));
      } catch (SQLException var3) {
         return (Timestamp)this.postForAll(methodObject30363, this.onErrorForAll(methodObject30363, var3));
      }
   }

   public int getBytes(long arg0, int arg1, byte[] arg2) throws SQLException {
      try {
         super.preForAll(methodObject30369, this, arg0, arg1, arg2);
         return (Integer)this.postForAll(methodObject30369, this.delegate.getBytes(arg0, arg1, arg2));
      } catch (SQLException var6) {
         return (Integer)this.postForAll(methodObject30369, this.onErrorForAll(methodObject30369, var6));
      }
   }

   public long length() throws SQLException {
      try {
         super.preForAll(methodObject30370, this, zeroLengthObjectArray);
         return (Long)this.postForAll(methodObject30370, this.delegate.length());
      } catch (SQLException var2) {
         return (Long)this.postForAll(methodObject30370, this.onErrorForAll(methodObject30370, var2));
      }
   }

   public OracleConnection getInternalConnection() throws SQLException {
      try {
         super.preForAll(methodObject30351, this, zeroLengthObjectArray);
         return (OracleConnection)this.postForAll(methodObject30351, (Object)super.getInternalConnection());
      } catch (SQLException var2) {
         return (OracleConnection)this.postForAll(methodObject30351, this.onErrorForAll(methodObject30351, var2));
      }
   }

   public InputStream getBinaryStream() throws SQLException {
      try {
         super.preForAll(methodObject30376, this, zeroLengthObjectArray);
         return (InputStream)this.postForAll(methodObject30376, (Object)super.getBinaryStream());
      } catch (SQLException var2) {
         return (InputStream)this.postForAll(methodObject30376, this.onErrorForAll(methodObject30376, var2));
      }
   }

   public boolean isConvertibleTo(Class arg0) {
      super.preForAll(methodObject30332, this, arg0);
      return (Boolean)this.postForAll(methodObject30332, this.delegate.isConvertibleTo(arg0));
   }

   public byte[] getBytes() {
      super.preForAll(methodObject30350, this, zeroLengthObjectArray);
      return (byte[])this.postForAll(methodObject30350, (Object)this.delegate.getBytes());
   }

   public Time timeValue(Calendar arg0) throws SQLException {
      try {
         super.preForAll(methodObject30361, this, arg0);
         return (Time)this.postForAll(methodObject30361, (Object)this.delegate.timeValue(arg0));
      } catch (SQLException var3) {
         return (Time)this.postForAll(methodObject30361, this.onErrorForAll(methodObject30361, var3));
      }
   }

   public InputStream binaryStreamValue() throws SQLException {
      try {
         super.preForAll(methodObject30340, this, zeroLengthObjectArray);
         return (InputStream)this.postForAll(methodObject30340, (Object)this.delegate.binaryStreamValue());
      } catch (SQLException var2) {
         return (InputStream)this.postForAll(methodObject30340, this.onErrorForAll(methodObject30340, var2));
      }
   }

   public long position(BFILE arg0, long arg1) throws SQLException {
      try {
         super.preForAll(methodObject30331, this, arg0, arg1);
         return (Long)this.postForAll(methodObject30331, this.delegate.position(arg0, arg1));
      } catch (SQLException var5) {
         return (Long)this.postForAll(methodObject30331, this.onErrorForAll(methodObject30331, var5));
      }
   }

   public Object getACProxy() {
      super.preForAll(methodObject30384, this, zeroLengthObjectArray);
      return this.postForAll(methodObject30384, this.proxyFactory.proxyForCache(this.delegate.getACProxy(), this, this.proxyCache, methodObject30384));
   }

   public oracle.jdbc.OracleConnection getOracleConnection() throws SQLException {
      try {
         super.preForAll(methodObject30364, this, zeroLengthObjectArray);
         return (oracle.jdbc.OracleConnection)this.postForAll(methodObject30364, this.proxyFactory.proxyForCache((Object)this.delegate.getOracleConnection(), this, this.proxyCache, methodObject30364));
      } catch (SQLException var2) {
         return (oracle.jdbc.OracleConnection)this.postForAll(methodObject30364, this.onErrorForAll(methodObject30364, var2));
      }
   }

   public Object toJdbc() throws SQLException {
      try {
         super.preForAll(methodObject30337, this, zeroLengthObjectArray);
         return this.postForAll(methodObject30337, this.proxyFactory.proxyForCache(this.delegate.toJdbc(), this, this.proxyCache, methodObject30337));
      } catch (SQLException var2) {
         return this.postForAll(methodObject30337, this.onErrorForAll(methodObject30337, var2));
      }
   }

   public boolean isOpen() throws SQLException {
      try {
         super.preForAll(methodObject30375, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject30375, this.delegate.isOpen());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject30375, this.onErrorForAll(methodObject30375, var2));
      }
   }

   public Date dateValue() throws SQLException {
      try {
         super.preForAll(methodObject30359, this, zeroLengthObjectArray);
         return (Date)this.postForAll(methodObject30359, (Object)this.delegate.dateValue());
      } catch (SQLException var2) {
         return (Date)this.postForAll(methodObject30359, this.onErrorForAll(methodObject30359, var2));
      }
   }

   public void setBytes(byte[] arg0) {
      super.preForAll(methodObject30353, this, arg0);
      this.delegate.setBytes(arg0);
   }

   public BigDecimal bigDecimalValue() throws SQLException {
      try {
         super.preForAll(methodObject30358, this, zeroLengthObjectArray);
         return (BigDecimal)this.postForAll(methodObject30358, (Object)this.delegate.bigDecimalValue());
      } catch (SQLException var2) {
         return (BigDecimal)this.postForAll(methodObject30358, this.onErrorForAll(methodObject30358, var2));
      }
   }

   public void closeFile() throws SQLException {
      try {
         super.preForAll(methodObject30381, this, zeroLengthObjectArray);
         this.delegate.closeFile();
      } catch (SQLException var2) {
         this.onErrorVoidForAll(methodObject30381, var2);
      }
   }

   public Object makeJdbcArray(int arg0) {
      super.preForAll(methodObject30341, this, arg0);
      return this.postForAll(methodObject30341, this.proxyFactory.proxyForCache(this.delegate.makeJdbcArray(arg0), this, this.proxyCache, methodObject30341));
   }

   public byte byteValue() throws SQLException {
      try {
         super.preForAll(methodObject30345, this, zeroLengthObjectArray);
         return (Byte)this.postForAll(methodObject30345, this.delegate.byteValue());
      } catch (SQLException var2) {
         return (Byte)this.postForAll(methodObject30345, this.onErrorForAll(methodObject30345, var2));
      }
   }

   public float floatValue() throws SQLException {
      try {
         super.preForAll(methodObject30348, this, zeroLengthObjectArray);
         return (Float)this.postForAll(methodObject30348, this.delegate.floatValue());
      } catch (SQLException var2) {
         return (Float)this.postForAll(methodObject30348, this.onErrorForAll(methodObject30348, var2));
      }
   }

   public Reader characterStreamValue() throws SQLException {
      try {
         super.preForAll(methodObject30338, this, zeroLengthObjectArray);
         return (Reader)this.postForAll(methodObject30338, (Object)this.delegate.characterStreamValue());
      } catch (SQLException var2) {
         return (Reader)this.postForAll(methodObject30338, this.onErrorForAll(methodObject30338, var2));
      }
   }

   public InputStream getStream() throws SQLException {
      try {
         super.preForAll(methodObject30355, this, zeroLengthObjectArray);
         return (InputStream)this.postForAll(methodObject30355, (Object)this.delegate.getStream());
      } catch (SQLException var2) {
         return (InputStream)this.postForAll(methodObject30355, this.onErrorForAll(methodObject30355, var2));
      }
   }

   public long getLength() {
      super.preForAll(methodObject30343, this, zeroLengthObjectArray);
      return (Long)this.postForAll(methodObject30343, this.delegate.getLength());
   }

   public Time timeValue() throws SQLException {
      try {
         super.preForAll(methodObject30360, this, zeroLengthObjectArray);
         return (Time)this.postForAll(methodObject30360, (Object)this.delegate.timeValue());
      } catch (SQLException var2) {
         return (Time)this.postForAll(methodObject30360, this.onErrorForAll(methodObject30360, var2));
      }
   }

   public String getName() throws SQLException {
      try {
         super.preForAll(methodObject30367, this, zeroLengthObjectArray);
         return (String)this.postForAll(methodObject30367, (Object)this.delegate.getName());
      } catch (SQLException var2) {
         return (String)this.postForAll(methodObject30367, this.onErrorForAll(methodObject30367, var2));
      }
   }

   public oracle.jdbc.driver.OracleConnection getConnection() throws SQLException {
      try {
         super.preForAll(methodObject30366, this, zeroLengthObjectArray);
         return (oracle.jdbc.driver.OracleConnection)this.postForAll(methodObject30366, (Object)this.delegate.getConnection());
      } catch (SQLException var2) {
         return (oracle.jdbc.driver.OracleConnection)this.postForAll(methodObject30366, this.onErrorForAll(methodObject30366, var2));
      }
   }

   public OracleBfile _getDelegate_() {
      return this.delegate;
   }

   public Object getDelegate() {
      return this.delegate;
   }

   public void setDelegate(Object delegate) {
      this.proxyFactory.updateDelegate(this, this.delegate, delegate);
      this.delegate = (OracleBfile)delegate;
   }

   public Object getCreator() {
      return this.creator;
   }

   static {
      try {
         methodObject30354 = OracleDatumWithConnection.class.getDeclaredMethod("setShareBytes", byte[].class);
         methodObject30336 = OracleBfile.class.getDeclaredMethod("setLocator", byte[].class);
         methodObject30378 = oracle.jdbc.OracleBfile.class.getDeclaredMethod("openFile");
         methodObject30380 = oracle.jdbc.OracleBfile.class.getDeclaredMethod("fileExists");
         methodObject30373 = oracle.jdbc.OracleBfile.class.getDeclaredMethod("close");
         methodObject30342 = OracleBfile.class.getDeclaredMethod("getJavaSqlConnection");
         methodObject30344 = OracleDatumWithConnection.class.getDeclaredMethod("booleanValue");
         methodObject30333 = OracleBfile.class.getDeclaredMethod("setLength", Long.TYPE);
         methodObject30372 = oracle.jdbc.OracleBfile.class.getDeclaredMethod("position", oracle.jdbc.OracleBfile.class, Long.TYPE);
         methodObject30383 = ACProxyable.class.getDeclaredMethod("setACProxy", Object.class);
         methodObject30362 = OracleDatumWithConnection.class.getDeclaredMethod("timestampValue");
         methodObject30346 = OracleDatumWithConnection.class.getDeclaredMethod("intValue");
         methodObject30365 = OracleDatumWithConnection.class.getDeclaredMethod("setPhysicalConnectionOf", Connection.class);
         methodObject30356 = OracleDatumWithConnection.class.getDeclaredMethod("stringValue");
         methodObject30382 = oracle.jdbc.OracleBfile.class.getDeclaredMethod("getDirAlias");
         methodObject30357 = OracleDatumWithConnection.class.getDeclaredMethod("stringValue", Connection.class);
         methodObject30368 = oracle.jdbc.OracleBfile.class.getDeclaredMethod("getBytes", Long.TYPE, Integer.TYPE);
         methodObject30371 = oracle.jdbc.OracleBfile.class.getDeclaredMethod("position", byte[].class, Long.TYPE);
         methodObject30339 = OracleBfile.class.getDeclaredMethod("asciiStreamValue");
         methodObject30352 = OracleDatumWithConnection.class.getDeclaredMethod("shareBytes");
         methodObject30349 = OracleDatumWithConnection.class.getDeclaredMethod("doubleValue");
         methodObject30334 = OracleBfile.class.getDeclaredMethod("getDBAccess");
         methodObject30374 = oracle.jdbc.OracleBfile.class.getDeclaredMethod("open", LargeObjectAccessMode.class);
         methodObject30379 = oracle.jdbc.OracleBfile.class.getDeclaredMethod("isFileOpen");
         methodObject30335 = OracleBfile.class.getDeclaredMethod("getLocator");
         methodObject30377 = oracle.jdbc.OracleBfile.class.getDeclaredMethod("getBinaryStream", Long.TYPE);
         methodObject30347 = OracleDatumWithConnection.class.getDeclaredMethod("longValue");
         methodObject30363 = OracleDatumWithConnection.class.getDeclaredMethod("timestampValue", Calendar.class);
         methodObject30369 = oracle.jdbc.OracleBfile.class.getDeclaredMethod("getBytes", Long.TYPE, Integer.TYPE, byte[].class);
         methodObject30370 = oracle.jdbc.OracleBfile.class.getDeclaredMethod("length");
         methodObject30351 = OracleDatumWithConnection.class.getDeclaredMethod("getInternalConnection");
         methodObject30376 = oracle.jdbc.OracleBfile.class.getDeclaredMethod("getBinaryStream");
         methodObject30332 = OracleBfile.class.getDeclaredMethod("isConvertibleTo", Class.class);
         methodObject30350 = OracleDatumWithConnection.class.getDeclaredMethod("getBytes");
         methodObject30361 = OracleDatumWithConnection.class.getDeclaredMethod("timeValue", Calendar.class);
         methodObject30340 = OracleBfile.class.getDeclaredMethod("binaryStreamValue");
         methodObject30331 = OracleBfile.class.getDeclaredMethod("position", BFILE.class, Long.TYPE);
         methodObject30384 = ACProxyable.class.getDeclaredMethod("getACProxy");
         methodObject30364 = OracleDatumWithConnection.class.getDeclaredMethod("getOracleConnection");
         methodObject30337 = OracleBfile.class.getDeclaredMethod("toJdbc");
         methodObject30375 = oracle.jdbc.OracleBfile.class.getDeclaredMethod("isOpen");
         methodObject30359 = OracleDatumWithConnection.class.getDeclaredMethod("dateValue");
         methodObject30353 = OracleDatumWithConnection.class.getDeclaredMethod("setBytes", byte[].class);
         methodObject30358 = OracleDatumWithConnection.class.getDeclaredMethod("bigDecimalValue");
         methodObject30381 = oracle.jdbc.OracleBfile.class.getDeclaredMethod("closeFile");
         methodObject30341 = OracleBfile.class.getDeclaredMethod("makeJdbcArray", Integer.TYPE);
         methodObject30345 = OracleDatumWithConnection.class.getDeclaredMethod("byteValue");
         methodObject30348 = OracleDatumWithConnection.class.getDeclaredMethod("floatValue");
         methodObject30338 = OracleBfile.class.getDeclaredMethod("characterStreamValue");
         methodObject30355 = OracleDatumWithConnection.class.getDeclaredMethod("getStream");
         methodObject30343 = OracleDatumWithConnection.class.getDeclaredMethod("getLength");
         methodObject30360 = OracleDatumWithConnection.class.getDeclaredMethod("timeValue");
         methodObject30367 = oracle.jdbc.OracleBfile.class.getDeclaredMethod("getName");
         methodObject30366 = OracleDatumWithConnection.class.getDeclaredMethod("getConnection");
      } catch (Throwable var1) {
         throw new RuntimeException(var1);
      }
   }

   public oracle$1jdbc$1replay$1driver$1NonTxnReplayableBfile$2oracle$1jdbc$1internal$1OracleBfile$$$Proxy(OracleBfile var1, Object var2, ProxyFactory var3, Map var4) {
      this.delegate = var1;
      this.creator = var2;
      this.proxyFactory = var3;
      this.proxyCache = var4;
   }
}
