package oracle.jdbc.proxy;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.sql.Clob;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Map;
import oracle.jdbc.LargeObjectAccessMode;
import oracle.jdbc.internal.ACProxyable;
import oracle.jdbc.internal.OracleClob;
import oracle.jdbc.internal.OracleConnection;
import oracle.jdbc.internal.OracleDatumWithConnection;
import oracle.jdbc.replay.driver.TxnReplayableClob;
import oracle.sql.ClobDBAccess;

public class oracle$1jdbc$1replay$1driver$1TxnReplayableClob$2oracle$1jdbc$1internal$1OracleClob$$$Proxy extends TxnReplayableClob implements OracleClob, _Proxy_ {
   private OracleClob delegate;
   private final Object creator;
   private final ProxyFactory proxyFactory;
   private final Map proxyCache;
   private static Object[] zeroLengthObjectArray = new Object[0];
   private static Method methodObject4117;
   private static Method methodObject4066;
   private static Method methodObject4071;
   private static Method methodObject4127;
   private static Method methodObject4132;
   private static Method methodObject4131;
   private static Method methodObject4124;
   private static Method methodObject4137;
   private static Method methodObject4083;
   private static Method methodObject4097;
   private static Method methodObject4102;
   private static Method methodObject4128;
   private static Method methodObject4068;
   private static Method methodObject4069;
   private static Method methodObject4113;
   private static Method methodObject4104;
   private static Method methodObject4080;
   private static Method methodObject4112;
   private static Method methodObject4129;
   private static Method methodObject4133;
   private static Method methodObject4114;
   private static Method methodObject4074;
   private static Method methodObject4109;
   private static Method methodObject4107;
   private static Method methodObject4140;
   private static Method methodObject4091;
   private static Method methodObject4082;
   private static Method methodObject4098;
   private static Method methodObject4105;
   private static Method methodObject4100;
   private static Method methodObject4081;
   private static Method methodObject4095;
   private static Method methodObject4130;
   private static Method methodObject4120;
   private static Method methodObject4115;
   private static Method methodObject4141;
   private static Method methodObject4125;
   private static Method methodObject4079;
   private static Method methodObject4135;
   private static Method methodObject4077;
   private static Method methodObject4108;
   private static Method methodObject4088;
   private static Method methodObject4075;
   private static Method methodObject4096;
   private static Method methodObject4094;
   private static Method methodObject4142;
   private static Method methodObject4092;
   private static Method methodObject4143;
   private static Method methodObject4144;
   private static Method methodObject4122;
   private static Method methodObject4139;
   private static Method methodObject4134;
   private static Method methodObject4076;
   private static Method methodObject4090;
   private static Method methodObject4087;
   private static Method methodObject4126;
   private static Method methodObject4119;
   private static Method methodObject4070;
   private static Method methodObject4118;
   private static Method methodObject4110;
   private static Method methodObject4089;
   private static Method methodObject4085;
   private static Method methodObject4136;
   private static Method methodObject4093;
   private static Method methodObject4072;
   private static Method methodObject4099;
   private static Method methodObject4084;
   private static Method methodObject4078;
   private static Method methodObject4103;
   private static Method methodObject4086;
   private static Method methodObject4067;
   private static Method methodObject4073;
   private static Method methodObject4106;
   private static Method methodObject4116;
   private static Method methodObject4101;
   private static Method methodObject4111;
   private static Method methodObject4138;
   private static Method methodObject4123;
   private static Method methodObject4121;

   public String stringValue(Connection arg0) throws SQLException {
      try {
         super.preForAll(methodObject4117, this, arg0);
         return (String)this.postForAll(methodObject4117, (Object)this.delegate.stringValue(arg0 instanceof _Proxy_ ? (Connection)((_Proxy_)arg0)._getDelegate_() : arg0));
      } catch (SQLException var3) {
         return (String)this.postForAll(methodObject4117, this.onErrorForAll(methodObject4117, var3));
      }
   }

   public int getChars(long arg0, int arg1, char[] arg2) throws SQLException {
      try {
         super.preForAll(methodObject4066, this, arg0, arg1, arg2);
         return (Integer)this.postForAll(methodObject4066, this.delegate.getChars(arg0, arg1, arg2));
      } catch (SQLException var6) {
         return (Integer)this.postForAll(methodObject4066, this.onErrorForAll(methodObject4066, var6));
      }
   }

   public int putChars(long arg0, char[] arg1) throws SQLException {
      try {
         super.preForAll(methodObject4071, this, arg0, arg1);
         return (Integer)this.postForAll(methodObject4071, this.delegate.putChars(arg0, arg1));
      } catch (SQLException var5) {
         return (Integer)this.postForAll(methodObject4071, this.onErrorForAll(methodObject4071, var5));
      }
   }

   public boolean isTemporary() throws SQLException {
      try {
         super.preForAll(methodObject4127, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject4127, this.delegate.isTemporary());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject4127, this.onErrorForAll(methodObject4127, var2));
      }
   }

   public long position(Clob arg0, long arg1) throws SQLException {
      try {
         super.preForAll(methodObject4132, this, arg0, arg1);
         return (Long)this.postForAll(methodObject4132, this.delegate.position(arg0 instanceof _Proxy_ ? (Clob)((_Proxy_)arg0)._getDelegate_() : arg0, arg1));
      } catch (SQLException var5) {
         return (Long)this.postForAll(methodObject4132, this.onErrorForAll(methodObject4132, var5));
      }
   }

   public long position(String arg0, long arg1) throws SQLException {
      try {
         super.preForAll(methodObject4131, this, arg0, arg1);
         return (Long)this.postForAll(methodObject4131, this.delegate.position(arg0, arg1));
      } catch (SQLException var5) {
         return (Long)this.postForAll(methodObject4131, this.onErrorForAll(methodObject4131, var5));
      }
   }

   public void close() throws SQLException {
      try {
         super.preForAll(methodObject4124, this, zeroLengthObjectArray);
         Method var10001 = methodObject4124;
         this.delegate.close();
         this.postForAll(var10001);
      } catch (SQLException var2) {
         this.onErrorVoidForAll(methodObject4124, var2);
      }
   }

   public int setString(long arg0, String arg1) throws SQLException {
      try {
         super.preForClobWrites(methodObject4137, this, arg0, arg1);
         return (Integer)this.postForAll(methodObject4137, this.delegate.setString(arg0, arg1));
      } catch (SQLException var5) {
         return (Integer)this.postForAll(methodObject4137, this.onErrorForAll(methodObject4137, var5));
      }
   }

   public Connection getJavaSqlConnection() throws SQLException {
      try {
         super.preForAll(methodObject4083, this, zeroLengthObjectArray);
         return (Connection)this.postForAll(methodObject4083, this.proxyFactory.proxyForCache((Object)this.delegate.getJavaSqlConnection(), this, this.proxyCache, methodObject4083));
      } catch (SQLException var2) {
         return (Connection)this.postForAll(methodObject4083, this.onErrorForAll(methodObject4083, var2));
      }
   }

   public void setActivePrefetch(boolean arg0) {
      super.preForAll(methodObject4097, this, arg0);
      Method var10001 = methodObject4097;
      this.delegate.setActivePrefetch(arg0);
      this.postForAll(var10001);
   }

   public boolean booleanValue() throws SQLException {
      try {
         super.preForAll(methodObject4102, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject4102, this.delegate.booleanValue());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject4102, this.onErrorForAll(methodObject4102, var2));
      }
   }

   public boolean isEmptyLob() throws SQLException {
      try {
         super.preForAll(methodObject4128, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject4128, this.delegate.isEmptyLob());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject4128, this.onErrorForAll(methodObject4128, var2));
      }
   }

   public boolean isConvertibleTo(Class arg0) {
      super.preForAll(methodObject4068, this, arg0);
      return (Boolean)this.postForAll(methodObject4068, this.delegate.isConvertibleTo(arg0));
   }

   public void setLength(long arg0) {
      super.preForAll(methodObject4069, this, arg0);
      Method var10001 = methodObject4069;
      this.delegate.setLength(arg0);
      this.postForAll(var10001);
   }

   public Timestamp timestampValue() throws SQLException {
      try {
         super.preForAll(methodObject4113, this, zeroLengthObjectArray);
         return (Timestamp)this.postForAll(methodObject4113, (Object)this.delegate.timestampValue());
      } catch (SQLException var2) {
         return (Timestamp)this.postForAll(methodObject4113, this.onErrorForAll(methodObject4113, var2));
      }
   }

   public int intValue() throws SQLException {
      try {
         super.preForAll(methodObject4104, this, zeroLengthObjectArray);
         return (Integer)this.postForAll(methodObject4104, this.delegate.intValue());
      } catch (SQLException var2) {
         return (Integer)this.postForAll(methodObject4104, this.onErrorForAll(methodObject4104, var2));
      }
   }

   public String stringValue() throws SQLException {
      try {
         super.preForAll(methodObject4080, this, zeroLengthObjectArray);
         return (String)this.postForAll(methodObject4080, (Object)this.delegate.stringValue());
      } catch (SQLException var2) {
         return (String)this.postForAll(methodObject4080, this.onErrorForAll(methodObject4080, var2));
      }
   }

   public Time timeValue(Calendar arg0) throws SQLException {
      try {
         super.preForAll(methodObject4112, this, arg0);
         return (Time)this.postForAll(methodObject4112, (Object)this.delegate.timeValue(arg0));
      } catch (SQLException var3) {
         return (Time)this.postForAll(methodObject4112, this.onErrorForAll(methodObject4112, var3));
      }
   }

   public boolean isSecureFile() throws SQLException {
      try {
         super.preForAll(methodObject4129, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject4129, this.delegate.isSecureFile());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject4129, this.onErrorForAll(methodObject4129, var2));
      }
   }

   public void free() throws SQLException {
      try {
         super.preForFree(methodObject4133, this, zeroLengthObjectArray);
         Method var10001 = methodObject4133;
         this.delegate.free();
         this.postForAll(var10001);
      } catch (SQLException var2) {
         this.onErrorVoidForAll(methodObject4133, var2);
      }
   }

   public Timestamp timestampValue(Calendar arg0) throws SQLException {
      try {
         super.preForAll(methodObject4114, this, arg0);
         return (Timestamp)this.postForAll(methodObject4114, (Object)this.delegate.timestampValue(arg0));
      } catch (SQLException var3) {
         return (Timestamp)this.postForAll(methodObject4114, this.onErrorForAll(methodObject4114, var3));
      }
   }

   public InputStream asciiStreamValue() throws SQLException {
      try {
         super.preForAll(methodObject4074, this, zeroLengthObjectArray);
         return (InputStream)this.postForAll(methodObject4074, (Object)this.delegate.asciiStreamValue());
      } catch (SQLException var2) {
         return (InputStream)this.postForAll(methodObject4074, this.onErrorForAll(methodObject4074, var2));
      }
   }

   public byte[] shareBytes() {
      super.preForAll(methodObject4109, this, zeroLengthObjectArray);
      return (byte[])this.postForAll(methodObject4109, (Object)this.delegate.shareBytes());
   }

   public double doubleValue() throws SQLException {
      try {
         super.preForAll(methodObject4107, this, zeroLengthObjectArray);
         return (Double)this.postForAll(methodObject4107, this.delegate.doubleValue());
      } catch (SQLException var2) {
         return (Double)this.postForAll(methodObject4107, this.onErrorForAll(methodObject4107, var2));
      }
   }

   public OutputStream setAsciiStream(long arg0) throws SQLException {
      try {
         super.preForAll(methodObject4140, this, arg0);
         return (OutputStream)this.postForAll(methodObject4140, (Object)super.setAsciiStream(arg0));
      } catch (SQLException var4) {
         return (OutputStream)this.postForAll(methodObject4140, this.onErrorForAll(methodObject4140, var4));
      }
   }

   public ClobDBAccess getDBAccess() throws SQLException {
      try {
         super.preForAll(methodObject4091, this, zeroLengthObjectArray);
         return (ClobDBAccess)this.postForAll(methodObject4091, (Object)this.delegate.getDBAccess());
      } catch (SQLException var2) {
         return (ClobDBAccess)this.postForAll(methodObject4091, this.onErrorForAll(methodObject4091, var2));
      }
   }

   public byte[] getLocator() {
      super.preForAll(methodObject4082, this, zeroLengthObjectArray);
      return (byte[])this.postForAll(methodObject4082, (Object)this.delegate.getLocator());
   }

   public void clearCachedData() {
      super.preForAll(methodObject4098, this, zeroLengthObjectArray);
      Method var10001 = methodObject4098;
      this.delegate.clearCachedData();
      this.postForAll(var10001);
   }

   public long longValue() throws SQLException {
      try {
         super.preForAll(methodObject4105, this, zeroLengthObjectArray);
         return (Long)this.postForAll(methodObject4105, this.delegate.longValue());
      } catch (SQLException var2) {
         return (Long)this.postForAll(methodObject4105, this.onErrorForAll(methodObject4105, var2));
      }
   }

   public boolean canReadBasicLobDataInLocator() throws SQLException {
      try {
         super.preForAll(methodObject4100, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject4100, this.delegate.canReadBasicLobDataInLocator());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject4100, this.onErrorForAll(methodObject4100, var2));
      }
   }

   public void setLocator(byte[] arg0) {
      super.preForAll(methodObject4081, this, arg0);
      Method var10001 = methodObject4081;
      this.delegate.setLocator(arg0);
      this.postForAll(var10001);
   }

   public char[] getPrefetchedData() {
      super.preForAll(methodObject4095, this, zeroLengthObjectArray);
      return (char[])this.postForAll(methodObject4095, (Object)this.delegate.getPrefetchedData());
   }

   public long length() throws SQLException {
      try {
         super.preForAll(methodObject4130, this, zeroLengthObjectArray);
         return (Long)this.postForAll(methodObject4130, this.delegate.length());
      } catch (SQLException var2) {
         return (Long)this.postForAll(methodObject4130, this.onErrorForAll(methodObject4130, var2));
      }
   }

   public OracleConnection getInternalConnection() throws SQLException {
      try {
         super.preForAll(methodObject4120, this, zeroLengthObjectArray);
         return (OracleConnection)this.postForAll(methodObject4120, (Object)super.getInternalConnection());
      } catch (SQLException var2) {
         return (OracleConnection)this.postForAll(methodObject4120, this.onErrorForAll(methodObject4120, var2));
      }
   }

   public void setShareBytes(byte[] arg0) {
      super.preForAll(methodObject4115, this, arg0);
      Method var10001 = methodObject4115;
      this.delegate.setShareBytes(arg0);
      this.postForAll(var10001);
   }

   public Writer setCharacterStream(long arg0) throws SQLException {
      try {
         super.preForAll(methodObject4141, this, arg0);
         return (Writer)this.postForAll(methodObject4141, (Object)super.setCharacterStream(arg0));
      } catch (SQLException var4) {
         return (Writer)this.postForAll(methodObject4141, this.onErrorForAll(methodObject4141, var4));
      }
   }

   public void open(LargeObjectAccessMode arg0) throws SQLException {
      try {
         super.preForAll(methodObject4125, this, arg0);
         Method var10001 = methodObject4125;
         this.delegate.open(arg0);
         this.postForAll(var10001);
      } catch (SQLException var3) {
         this.onErrorVoidForAll(methodObject4125, var3);
      }
   }

   public Reader getCharacterStream(long arg0) throws SQLException {
      try {
         super.preForAll(methodObject4079, this, arg0);
         return (Reader)this.postForAll(methodObject4079, (Object)super.getCharacterStream(arg0));
      } catch (SQLException var4) {
         return (Reader)this.postForAll(methodObject4079, this.onErrorForAll(methodObject4079, var4));
      }
   }

   public Reader getCharacterStream() throws SQLException {
      try {
         super.preForAll(methodObject4135, this, zeroLengthObjectArray);
         return (Reader)this.postForAll(methodObject4135, (Object)super.getCharacterStream());
      } catch (SQLException var2) {
         return (Reader)this.postForAll(methodObject4135, this.onErrorForAll(methodObject4135, var2));
      }
   }

   public Object makeJdbcArray(int arg0) {
      super.preForAll(methodObject4077, this, arg0);
      return this.postForAll(methodObject4077, this.proxyFactory.proxyForCache(this.delegate.makeJdbcArray(arg0), this, this.proxyCache, methodObject4077));
   }

   public byte[] getBytes() {
      super.preForAll(methodObject4108, this, zeroLengthObjectArray);
      return (byte[])this.postForAll(methodObject4108, (Object)this.delegate.getBytes());
   }

   public OutputStream getAsciiOutputStream() throws SQLException {
      try {
         super.preForAll(methodObject4088, this, zeroLengthObjectArray);
         return (OutputStream)this.postForAll(methodObject4088, (Object)super.getAsciiOutputStream());
      } catch (SQLException var2) {
         return (OutputStream)this.postForAll(methodObject4088, this.onErrorForAll(methodObject4088, var2));
      }
   }

   public InputStream binaryStreamValue() throws SQLException {
      try {
         super.preForAll(methodObject4075, this, zeroLengthObjectArray);
         return (InputStream)this.postForAll(methodObject4075, (Object)this.delegate.binaryStreamValue());
      } catch (SQLException var2) {
         return (InputStream)this.postForAll(methodObject4075, this.onErrorForAll(methodObject4075, var2));
      }
   }

   public int getPrefetchedDataSize() {
      super.preForAll(methodObject4096, this, zeroLengthObjectArray);
      return (Integer)this.postForAll(methodObject4096, this.delegate.getPrefetchedDataSize());
   }

   public void setPrefetchedData(char[] arg0, int arg1) {
      super.preForAll(methodObject4094, this, arg0, arg1);
      Method var10001 = methodObject4094;
      this.delegate.setPrefetchedData(arg0, arg1);
      this.postForAll(var10001);
   }

   public void truncate(long arg0) throws SQLException {
      try {
         super.preForClobWrites(methodObject4142, this, arg0);
         Method var10001 = methodObject4142;
         this.delegate.truncate(arg0);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject4142, var4);
      }
   }

   public void setChunkSize(int arg0) {
      super.preForAll(methodObject4092, this, arg0);
      Method var10001 = methodObject4092;
      this.delegate.setChunkSize(arg0);
      this.postForAll(var10001);
   }

   public void setACProxy(Object arg0) {
      super.preForAll(methodObject4143, this, arg0);
      Method var10001 = methodObject4143;
      this.delegate.setACProxy(arg0 instanceof _Proxy_ ? (Object)((_Proxy_)arg0)._getDelegate_() : arg0);
      this.postForAll(var10001);
   }

   public Object getACProxy() {
      super.preForAll(methodObject4144, this, zeroLengthObjectArray);
      return this.postForAll(methodObject4144, this.proxyFactory.proxyForCache(this.delegate.getACProxy(), this, this.proxyCache, methodObject4144));
   }

   public oracle.jdbc.OracleConnection getOracleConnection() throws SQLException {
      try {
         super.preForAll(methodObject4122, this, zeroLengthObjectArray);
         return (oracle.jdbc.OracleConnection)this.postForAll(methodObject4122, this.proxyFactory.proxyForCache((Object)this.delegate.getOracleConnection(), this, this.proxyCache, methodObject4122));
      } catch (SQLException var2) {
         return (oracle.jdbc.OracleConnection)this.postForAll(methodObject4122, this.onErrorForAll(methodObject4122, var2));
      }
   }

   public String getSubString(long arg0, int arg1) throws SQLException {
      try {
         super.preForAll(methodObject4139, this, arg0, arg1);
         return (String)this.postForAll(methodObject4139, (Object)this.delegate.getSubString(arg0, arg1));
      } catch (SQLException var5) {
         return (String)this.postForAll(methodObject4139, this.onErrorForAll(methodObject4139, var5));
      }
   }

   public InputStream getAsciiStream() throws SQLException {
      try {
         super.preForAll(methodObject4134, this, zeroLengthObjectArray);
         return (InputStream)this.postForAll(methodObject4134, (Object)super.getAsciiStream());
      } catch (SQLException var2) {
         return (InputStream)this.postForAll(methodObject4134, this.onErrorForAll(methodObject4134, var2));
      }
   }

   public Object toJdbc() throws SQLException {
      try {
         super.preForAll(methodObject4076, this, zeroLengthObjectArray);
         return this.postForAll(methodObject4076, this.proxyFactory.proxyForCache(this.delegate.toJdbc(), this, this.proxyCache, methodObject4076));
      } catch (SQLException var2) {
         return this.postForAll(methodObject4076, this.onErrorForAll(methodObject4076, var2));
      }
   }

   public int getBufferSize() throws SQLException {
      try {
         super.preForAll(methodObject4090, this, zeroLengthObjectArray);
         return (Integer)this.postForAll(methodObject4090, this.delegate.getBufferSize());
      } catch (SQLException var2) {
         return (Integer)this.postForAll(methodObject4090, this.onErrorForAll(methodObject4090, var2));
      }
   }

   public OutputStream getAsciiOutputStream(long arg0) throws SQLException {
      try {
         super.preForAll(methodObject4087, this, arg0);
         return (OutputStream)this.postForAll(methodObject4087, (Object)super.getAsciiOutputStream(arg0));
      } catch (SQLException var4) {
         return (OutputStream)this.postForAll(methodObject4087, this.onErrorForAll(methodObject4087, var4));
      }
   }

   public boolean isOpen() throws SQLException {
      try {
         super.preForAll(methodObject4126, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject4126, this.delegate.isOpen());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject4126, this.onErrorForAll(methodObject4126, var2));
      }
   }

   public Date dateValue() throws SQLException {
      try {
         super.preForAll(methodObject4119, this, zeroLengthObjectArray);
         return (Date)this.postForAll(methodObject4119, (Object)this.delegate.dateValue());
      } catch (SQLException var2) {
         return (Date)this.postForAll(methodObject4119, this.onErrorForAll(methodObject4119, var2));
      }
   }

   public int getChunkSize() throws SQLException {
      try {
         super.preForAll(methodObject4070, this, zeroLengthObjectArray);
         return (Integer)this.postForAll(methodObject4070, this.delegate.getChunkSize());
      } catch (SQLException var2) {
         return (Integer)this.postForAll(methodObject4070, this.onErrorForAll(methodObject4070, var2));
      }
   }

   public BigDecimal bigDecimalValue() throws SQLException {
      try {
         super.preForAll(methodObject4118, this, zeroLengthObjectArray);
         return (BigDecimal)this.postForAll(methodObject4118, (Object)this.delegate.bigDecimalValue());
      } catch (SQLException var2) {
         return (BigDecimal)this.postForAll(methodObject4118, this.onErrorForAll(methodObject4118, var2));
      }
   }

   public void setBytes(byte[] arg0) {
      super.preForAll(methodObject4110, this, arg0);
      Method var10001 = methodObject4110;
      this.delegate.setBytes(arg0);
      this.postForAll(var10001);
   }

   public int putString(long arg0, String arg1) throws SQLException {
      try {
         super.preForAll(methodObject4089, this, arg0, arg1);
         return (Integer)this.postForAll(methodObject4089, this.delegate.putString(arg0, arg1));
      } catch (SQLException var5) {
         return (Integer)this.postForAll(methodObject4089, this.onErrorForAll(methodObject4089, var5));
      }
   }

   public Writer getCharacterOutputStream(long arg0) throws SQLException {
      try {
         super.preForAll(methodObject4085, this, arg0);
         return (Writer)this.postForAll(methodObject4085, (Object)super.getCharacterOutputStream(arg0));
      } catch (SQLException var4) {
         return (Writer)this.postForAll(methodObject4085, this.onErrorForAll(methodObject4085, var4));
      }
   }

   public Reader getCharacterStream(long arg0, long arg1) throws SQLException {
      try {
         super.preForAll(methodObject4136, this, arg0, arg1);
         return (Reader)this.postForAll(methodObject4136, (Object)super.getCharacterStream(arg0, arg1));
      } catch (SQLException var6) {
         return (Reader)this.postForAll(methodObject4136, this.onErrorForAll(methodObject4136, var6));
      }
   }

   public void setPrefetchedData(char[] arg0) {
      super.preForAll(methodObject4093, this, arg0);
      Method var10001 = methodObject4093;
      this.delegate.setPrefetchedData(arg0);
      this.postForAll(var10001);
   }

   public int putChars(long arg0, char[] arg1, int arg2, int arg3) throws SQLException {
      try {
         super.preForAll(methodObject4072, this, arg0, arg1, arg2, arg3);
         return (Integer)this.postForAll(methodObject4072, this.delegate.putChars(arg0, arg1, arg2, arg3));
      } catch (SQLException var7) {
         return (Integer)this.postForAll(methodObject4072, this.onErrorForAll(methodObject4072, var7));
      }
   }

   public boolean isActivePrefetch() {
      super.preForAll(methodObject4099, this, zeroLengthObjectArray);
      return (Boolean)this.postForAll(methodObject4099, this.delegate.isActivePrefetch());
   }

   public boolean isNCLOB() {
      super.preForAll(methodObject4084, this, zeroLengthObjectArray);
      return (Boolean)this.postForAll(methodObject4084, this.delegate.isNCLOB());
   }

   public InputStream getAsciiStream(long arg0) throws SQLException {
      try {
         super.preForAll(methodObject4078, this, arg0);
         return (InputStream)this.postForAll(methodObject4078, (Object)super.getAsciiStream(arg0));
      } catch (SQLException var4) {
         return (InputStream)this.postForAll(methodObject4078, this.onErrorForAll(methodObject4078, var4));
      }
   }

   public byte byteValue() throws SQLException {
      try {
         super.preForAll(methodObject4103, this, zeroLengthObjectArray);
         return (Byte)this.postForAll(methodObject4103, this.delegate.byteValue());
      } catch (SQLException var2) {
         return (Byte)this.postForAll(methodObject4103, this.onErrorForAll(methodObject4103, var2));
      }
   }

   public Writer getCharacterOutputStream() throws SQLException {
      try {
         super.preForAll(methodObject4086, this, zeroLengthObjectArray);
         return (Writer)this.postForAll(methodObject4086, (Object)super.getCharacterOutputStream());
      } catch (SQLException var2) {
         return (Writer)this.postForAll(methodObject4086, this.onErrorForAll(methodObject4086, var2));
      }
   }

   public void trim(long arg0) throws SQLException {
      try {
         super.preForAll(methodObject4067, this, arg0);
         Method var10001 = methodObject4067;
         this.delegate.trim(arg0);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject4067, var4);
      }
   }

   public Reader characterStreamValue() throws SQLException {
      try {
         super.preForAll(methodObject4073, this, zeroLengthObjectArray);
         return (Reader)this.postForAll(methodObject4073, (Object)this.delegate.characterStreamValue());
      } catch (SQLException var2) {
         return (Reader)this.postForAll(methodObject4073, this.onErrorForAll(methodObject4073, var2));
      }
   }

   public float floatValue() throws SQLException {
      try {
         super.preForAll(methodObject4106, this, zeroLengthObjectArray);
         return (Float)this.postForAll(methodObject4106, this.delegate.floatValue());
      } catch (SQLException var2) {
         return (Float)this.postForAll(methodObject4106, this.onErrorForAll(methodObject4106, var2));
      }
   }

   public InputStream getStream() throws SQLException {
      try {
         super.preForAll(methodObject4116, this, zeroLengthObjectArray);
         return (InputStream)this.postForAll(methodObject4116, (Object)this.delegate.getStream());
      } catch (SQLException var2) {
         return (InputStream)this.postForAll(methodObject4116, this.onErrorForAll(methodObject4116, var2));
      }
   }

   public long getLength() {
      super.preForAll(methodObject4101, this, zeroLengthObjectArray);
      return (Long)this.postForAll(methodObject4101, this.delegate.getLength());
   }

   public Time timeValue() throws SQLException {
      try {
         super.preForAll(methodObject4111, this, zeroLengthObjectArray);
         return (Time)this.postForAll(methodObject4111, (Object)this.delegate.timeValue());
      } catch (SQLException var2) {
         return (Time)this.postForAll(methodObject4111, this.onErrorForAll(methodObject4111, var2));
      }
   }

   public int setString(long arg0, String arg1, int arg2, int arg3) throws SQLException {
      try {
         super.preForClobWrites(methodObject4138, this, arg0, arg1, arg2, arg3);
         return (Integer)this.postForAll(methodObject4138, this.delegate.setString(arg0, arg1, arg2, arg3));
      } catch (SQLException var7) {
         return (Integer)this.postForAll(methodObject4138, this.onErrorForAll(methodObject4138, var7));
      }
   }

   public oracle.jdbc.driver.OracleConnection getConnection() throws SQLException {
      try {
         super.preForAll(methodObject4123, this, zeroLengthObjectArray);
         return (oracle.jdbc.driver.OracleConnection)this.postForAll(methodObject4123, (Object)this.delegate.getConnection());
      } catch (SQLException var2) {
         return (oracle.jdbc.driver.OracleConnection)this.postForAll(methodObject4123, this.onErrorForAll(methodObject4123, var2));
      }
   }

   public void setPhysicalConnectionOf(Connection arg0) {
      super.preForAll(methodObject4121, this, arg0);
      Method var10001 = methodObject4121;
      this.delegate.setPhysicalConnectionOf(arg0 instanceof _Proxy_ ? (Connection)((_Proxy_)arg0)._getDelegate_() : arg0);
      this.postForAll(var10001);
   }

   public OracleClob _getDelegate_() {
      return this.delegate;
   }

   public Object getDelegate() {
      return this.delegate;
   }

   public void setDelegate(Object delegate) {
      this.proxyFactory.updateDelegate(this, this.delegate, delegate);
      this.delegate = (OracleClob)delegate;
   }

   public Object getCreator() {
      return this.creator;
   }

   static {
      try {
         methodObject4117 = OracleDatumWithConnection.class.getDeclaredMethod("stringValue", Connection.class);
         methodObject4066 = OracleClob.class.getDeclaredMethod("getChars", Long.TYPE, Integer.TYPE, char[].class);
         methodObject4071 = OracleClob.class.getDeclaredMethod("putChars", Long.TYPE, char[].class);
         methodObject4127 = oracle.jdbc.OracleClob.class.getDeclaredMethod("isTemporary");
         methodObject4132 = Clob.class.getDeclaredMethod("position", Clob.class, Long.TYPE);
         methodObject4131 = Clob.class.getDeclaredMethod("position", String.class, Long.TYPE);
         methodObject4124 = oracle.jdbc.OracleClob.class.getDeclaredMethod("close");
         methodObject4137 = Clob.class.getDeclaredMethod("setString", Long.TYPE, String.class);
         methodObject4083 = OracleClob.class.getDeclaredMethod("getJavaSqlConnection");
         methodObject4097 = OracleClob.class.getDeclaredMethod("setActivePrefetch", Boolean.TYPE);
         methodObject4102 = OracleDatumWithConnection.class.getDeclaredMethod("booleanValue");
         methodObject4128 = oracle.jdbc.OracleClob.class.getDeclaredMethod("isEmptyLob");
         methodObject4068 = OracleClob.class.getDeclaredMethod("isConvertibleTo", Class.class);
         methodObject4069 = OracleClob.class.getDeclaredMethod("setLength", Long.TYPE);
         methodObject4113 = OracleDatumWithConnection.class.getDeclaredMethod("timestampValue");
         methodObject4104 = OracleDatumWithConnection.class.getDeclaredMethod("intValue");
         methodObject4080 = OracleClob.class.getDeclaredMethod("stringValue");
         methodObject4112 = OracleDatumWithConnection.class.getDeclaredMethod("timeValue", Calendar.class);
         methodObject4129 = oracle.jdbc.OracleClob.class.getDeclaredMethod("isSecureFile");
         methodObject4133 = Clob.class.getDeclaredMethod("free");
         methodObject4114 = OracleDatumWithConnection.class.getDeclaredMethod("timestampValue", Calendar.class);
         methodObject4074 = OracleClob.class.getDeclaredMethod("asciiStreamValue");
         methodObject4109 = OracleDatumWithConnection.class.getDeclaredMethod("shareBytes");
         methodObject4107 = OracleDatumWithConnection.class.getDeclaredMethod("doubleValue");
         methodObject4140 = Clob.class.getDeclaredMethod("setAsciiStream", Long.TYPE);
         methodObject4091 = OracleClob.class.getDeclaredMethod("getDBAccess");
         methodObject4082 = OracleClob.class.getDeclaredMethod("getLocator");
         methodObject4098 = OracleClob.class.getDeclaredMethod("clearCachedData");
         methodObject4105 = OracleDatumWithConnection.class.getDeclaredMethod("longValue");
         methodObject4100 = OracleClob.class.getDeclaredMethod("canReadBasicLobDataInLocator");
         methodObject4081 = OracleClob.class.getDeclaredMethod("setLocator", byte[].class);
         methodObject4095 = OracleClob.class.getDeclaredMethod("getPrefetchedData");
         methodObject4130 = Clob.class.getDeclaredMethod("length");
         methodObject4120 = OracleDatumWithConnection.class.getDeclaredMethod("getInternalConnection");
         methodObject4115 = OracleDatumWithConnection.class.getDeclaredMethod("setShareBytes", byte[].class);
         methodObject4141 = Clob.class.getDeclaredMethod("setCharacterStream", Long.TYPE);
         methodObject4125 = oracle.jdbc.OracleClob.class.getDeclaredMethod("open", LargeObjectAccessMode.class);
         methodObject4079 = OracleClob.class.getDeclaredMethod("getCharacterStream", Long.TYPE);
         methodObject4135 = Clob.class.getDeclaredMethod("getCharacterStream");
         methodObject4077 = OracleClob.class.getDeclaredMethod("makeJdbcArray", Integer.TYPE);
         methodObject4108 = OracleDatumWithConnection.class.getDeclaredMethod("getBytes");
         methodObject4088 = OracleClob.class.getDeclaredMethod("getAsciiOutputStream");
         methodObject4075 = OracleClob.class.getDeclaredMethod("binaryStreamValue");
         methodObject4096 = OracleClob.class.getDeclaredMethod("getPrefetchedDataSize");
         methodObject4094 = OracleClob.class.getDeclaredMethod("setPrefetchedData", char[].class, Integer.TYPE);
         methodObject4142 = Clob.class.getDeclaredMethod("truncate", Long.TYPE);
         methodObject4092 = OracleClob.class.getDeclaredMethod("setChunkSize", Integer.TYPE);
         methodObject4143 = ACProxyable.class.getDeclaredMethod("setACProxy", Object.class);
         methodObject4144 = ACProxyable.class.getDeclaredMethod("getACProxy");
         methodObject4122 = OracleDatumWithConnection.class.getDeclaredMethod("getOracleConnection");
         methodObject4139 = Clob.class.getDeclaredMethod("getSubString", Long.TYPE, Integer.TYPE);
         methodObject4134 = Clob.class.getDeclaredMethod("getAsciiStream");
         methodObject4076 = OracleClob.class.getDeclaredMethod("toJdbc");
         methodObject4090 = OracleClob.class.getDeclaredMethod("getBufferSize");
         methodObject4087 = OracleClob.class.getDeclaredMethod("getAsciiOutputStream", Long.TYPE);
         methodObject4126 = oracle.jdbc.OracleClob.class.getDeclaredMethod("isOpen");
         methodObject4119 = OracleDatumWithConnection.class.getDeclaredMethod("dateValue");
         methodObject4070 = OracleClob.class.getDeclaredMethod("getChunkSize");
         methodObject4118 = OracleDatumWithConnection.class.getDeclaredMethod("bigDecimalValue");
         methodObject4110 = OracleDatumWithConnection.class.getDeclaredMethod("setBytes", byte[].class);
         methodObject4089 = OracleClob.class.getDeclaredMethod("putString", Long.TYPE, String.class);
         methodObject4085 = OracleClob.class.getDeclaredMethod("getCharacterOutputStream", Long.TYPE);
         methodObject4136 = Clob.class.getDeclaredMethod("getCharacterStream", Long.TYPE, Long.TYPE);
         methodObject4093 = OracleClob.class.getDeclaredMethod("setPrefetchedData", char[].class);
         methodObject4072 = OracleClob.class.getDeclaredMethod("putChars", Long.TYPE, char[].class, Integer.TYPE, Integer.TYPE);
         methodObject4099 = OracleClob.class.getDeclaredMethod("isActivePrefetch");
         methodObject4084 = OracleClob.class.getDeclaredMethod("isNCLOB");
         methodObject4078 = OracleClob.class.getDeclaredMethod("getAsciiStream", Long.TYPE);
         methodObject4103 = OracleDatumWithConnection.class.getDeclaredMethod("byteValue");
         methodObject4086 = OracleClob.class.getDeclaredMethod("getCharacterOutputStream");
         methodObject4067 = OracleClob.class.getDeclaredMethod("trim", Long.TYPE);
         methodObject4073 = OracleClob.class.getDeclaredMethod("characterStreamValue");
         methodObject4106 = OracleDatumWithConnection.class.getDeclaredMethod("floatValue");
         methodObject4116 = OracleDatumWithConnection.class.getDeclaredMethod("getStream");
         methodObject4101 = OracleDatumWithConnection.class.getDeclaredMethod("getLength");
         methodObject4111 = OracleDatumWithConnection.class.getDeclaredMethod("timeValue");
         methodObject4138 = Clob.class.getDeclaredMethod("setString", Long.TYPE, String.class, Integer.TYPE, Integer.TYPE);
         methodObject4123 = OracleDatumWithConnection.class.getDeclaredMethod("getConnection");
         methodObject4121 = OracleDatumWithConnection.class.getDeclaredMethod("setPhysicalConnectionOf", Connection.class);
      } catch (Throwable var1) {
         throw new RuntimeException(var1);
      }
   }

   public oracle$1jdbc$1replay$1driver$1TxnReplayableClob$2oracle$1jdbc$1internal$1OracleClob$$$Proxy(OracleClob var1, Object var2, ProxyFactory var3, Map var4) {
      this.delegate = var1;
      this.creator = var2;
      this.proxyFactory = var3;
      this.proxyCache = var4;
   }
}
