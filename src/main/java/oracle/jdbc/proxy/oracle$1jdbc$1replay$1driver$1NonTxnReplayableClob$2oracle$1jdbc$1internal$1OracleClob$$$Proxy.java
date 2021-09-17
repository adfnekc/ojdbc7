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
import oracle.jdbc.replay.driver.NonTxnReplayableClob;
import oracle.sql.ClobDBAccess;

public abstract class oracle$1jdbc$1replay$1driver$1NonTxnReplayableClob$2oracle$1jdbc$1internal$1OracleClob$$$Proxy extends NonTxnReplayableClob implements OracleClob, _Proxy_ {
   private OracleClob delegate;
   private final Object creator;
   private final ProxyFactory proxyFactory;
   private final Map proxyCache;
   private static Object[] zeroLengthObjectArray = new Object[0];
   private static Method methodObject30282;
   private static Method methodObject30252;
   private static Method methodObject30242;
   private static Method methodObject30299;
   private static Method methodObject30294;
   private static Method methodObject30248;
   private static Method methodObject30272;
   private static Method methodObject30297;
   private static Method methodObject30239;
   private static Method methodObject30313;
   private static Method methodObject30289;
   private static Method methodObject30292;
   private static Method methodObject30274;
   private static Method methodObject30258;
   private static Method methodObject30249;
   private static Method methodObject30284;
   private static Method methodObject30298;
   private static Method methodObject30303;
   private static Method methodObject30257;
   private static Method methodObject30312;
   private static Method methodObject30245;
   private static Method methodObject30264;
   private static Method methodObject30280;
   private static Method methodObject30277;
   private static Method methodObject30305;
   private static Method methodObject30295;
   private static Method methodObject30240;
   private static Method methodObject30241;
   private static Method methodObject30262;
   private static Method methodObject30275;
   private static Method methodObject30311;
   private static Method methodObject30250;
   private static Method methodObject30290;
   private static Method methodObject30259;
   private static Method methodObject30237;
   private static Method methodObject30300;
   private static Method methodObject30261;
   private static Method methodObject30279;
   private static Method methodObject30270;
   private static Method methodObject30308;
   private static Method methodObject30269;
   private static Method methodObject30301;
   private static Method methodObject30238;
   private static Method methodObject30278;
   private static Method methodObject30288;
   private static Method methodObject30265;
   private static Method methodObject30266;
   private static Method methodObject30260;
   private static Method methodObject30246;
   private static Method methodObject30304;
   private static Method methodObject30314;
   private static Method methodObject30291;
   private static Method methodObject30268;
   private static Method methodObject30307;
   private static Method methodObject30243;
   private static Method methodObject30251;
   private static Method methodObject30306;
   private static Method methodObject30302;
   private static Method methodObject30296;
   private static Method methodObject30286;
   private static Method methodObject30255;
   private static Method methodObject30281;
   private static Method methodObject30285;
   private static Method methodObject30309;
   private static Method methodObject30247;
   private static Method methodObject30263;
   private static Method methodObject30254;
   private static Method methodObject30273;
   private static Method methodObject30267;
   private static Method methodObject30253;
   private static Method methodObject30244;
   private static Method methodObject30276;
   private static Method methodObject30310;
   private static Method methodObject30256;
   private static Method methodObject30283;
   private static Method methodObject30287;
   private static Method methodObject30236;
   private static Method methodObject30271;
   private static Method methodObject30293;

   public void setShareBytes(byte[] arg0) {
      super.preForAll(methodObject30282, this, arg0);
      this.delegate.setShareBytes(arg0);
   }

   public InputStream getAsciiStream(long arg0) throws SQLException {
      try {
         super.preForAll(methodObject30252, this, arg0);
         return (InputStream)this.postForAll(methodObject30252, (Object)super.getAsciiStream(arg0));
      } catch (SQLException var4) {
         return (InputStream)this.postForAll(methodObject30252, this.onErrorForAll(methodObject30252, var4));
      }
   }

   public void setLocator(byte[] arg0) {
      super.preForAll(methodObject30242, this, arg0);
      this.delegate.setLocator(arg0);
   }

   public boolean isTemporary() throws SQLException {
      try {
         super.preForAll(methodObject30299, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject30299, this.delegate.isTemporary());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject30299, this.onErrorForAll(methodObject30299, var2));
      }
   }

   public void close() throws SQLException {
      try {
         super.preForAll(methodObject30294, this, zeroLengthObjectArray);
         this.delegate.close();
      } catch (SQLException var2) {
         this.onErrorVoidForAll(methodObject30294, var2);
      }
   }

   public Connection getJavaSqlConnection() throws SQLException {
      try {
         super.preForAll(methodObject30248, this, zeroLengthObjectArray);
         return (Connection)this.postForAll(methodObject30248, this.proxyFactory.proxyForCache((Object)this.delegate.getJavaSqlConnection(), this, this.proxyCache, methodObject30248));
      } catch (SQLException var2) {
         return (Connection)this.postForAll(methodObject30248, this.onErrorForAll(methodObject30248, var2));
      }
   }

   public boolean booleanValue() throws SQLException {
      try {
         super.preForAll(methodObject30272, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject30272, this.delegate.booleanValue());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject30272, this.onErrorForAll(methodObject30272, var2));
      }
   }

   public boolean isEmptyLob() throws SQLException {
      try {
         super.preForAll(methodObject30297, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject30297, this.delegate.isEmptyLob());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject30297, this.onErrorForAll(methodObject30297, var2));
      }
   }

   public void setLength(long arg0) {
      super.preForAll(methodObject30239, this, arg0);
      this.delegate.setLength(arg0);
   }

   public void setACProxy(Object arg0) {
      super.preForAll(methodObject30313, this, arg0);
      this.delegate.setACProxy(arg0 instanceof _Proxy_ ? (Object)((_Proxy_)arg0)._getDelegate_() : arg0);
   }

   public Timestamp timestampValue() throws SQLException {
      try {
         super.preForAll(methodObject30289, this, zeroLengthObjectArray);
         return (Timestamp)this.postForAll(methodObject30289, (Object)this.delegate.timestampValue());
      } catch (SQLException var2) {
         return (Timestamp)this.postForAll(methodObject30289, this.onErrorForAll(methodObject30289, var2));
      }
   }

   public void setPhysicalConnectionOf(Connection arg0) {
      super.preForAll(methodObject30292, this, arg0);
      this.delegate.setPhysicalConnectionOf(arg0 instanceof _Proxy_ ? (Connection)((_Proxy_)arg0)._getDelegate_() : arg0);
   }

   public int intValue() throws SQLException {
      try {
         super.preForAll(methodObject30274, this, zeroLengthObjectArray);
         return (Integer)this.postForAll(methodObject30274, this.delegate.intValue());
      } catch (SQLException var2) {
         return (Integer)this.postForAll(methodObject30274, this.onErrorForAll(methodObject30274, var2));
      }
   }

   public void setPrefetchedData(char[] arg0, int arg1) {
      super.preForAll(methodObject30258, this, arg0, arg1);
      this.delegate.setPrefetchedData(arg0, arg1);
   }

   public String stringValue() throws SQLException {
      try {
         super.preForAll(methodObject30249, this, zeroLengthObjectArray);
         return (String)this.postForAll(methodObject30249, (Object)this.delegate.stringValue());
      } catch (SQLException var2) {
         return (String)this.postForAll(methodObject30249, this.onErrorForAll(methodObject30249, var2));
      }
   }

   public String stringValue(Connection arg0) throws SQLException {
      try {
         super.preForAll(methodObject30284, this, arg0);
         return (String)this.postForAll(methodObject30284, (Object)this.delegate.stringValue(arg0 instanceof _Proxy_ ? (Connection)((_Proxy_)arg0)._getDelegate_() : arg0));
      } catch (SQLException var3) {
         return (String)this.postForAll(methodObject30284, this.onErrorForAll(methodObject30284, var3));
      }
   }

   public boolean isSecureFile() throws SQLException {
      try {
         super.preForAll(methodObject30298, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject30298, this.delegate.isSecureFile());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject30298, this.onErrorForAll(methodObject30298, var2));
      }
   }

   public void free() throws SQLException {
      try {
         super.preForFree(methodObject30303, this, zeroLengthObjectArray);
         this.delegate.free();
      } catch (SQLException var2) {
         this.onErrorVoidForAll(methodObject30303, var2);
      }
   }

   public void setPrefetchedData(char[] arg0) {
      super.preForAll(methodObject30257, this, arg0);
      this.delegate.setPrefetchedData(arg0);
   }

   public String getSubString(long arg0, int arg1) throws SQLException {
      try {
         super.preForAll(methodObject30312, this, arg0, arg1);
         return (String)this.postForAll(methodObject30312, (Object)this.delegate.getSubString(arg0, arg1));
      } catch (SQLException var5) {
         return (String)this.postForAll(methodObject30312, this.onErrorForAll(methodObject30312, var5));
      }
   }

   public InputStream asciiStreamValue() throws SQLException {
      try {
         super.preForAll(methodObject30245, this, zeroLengthObjectArray);
         return (InputStream)this.postForAll(methodObject30245, (Object)this.delegate.asciiStreamValue());
      } catch (SQLException var2) {
         return (InputStream)this.postForAll(methodObject30245, this.onErrorForAll(methodObject30245, var2));
      }
   }

   public OutputStream getAsciiOutputStream(long arg0) throws SQLException {
      try {
         super.preForAll(methodObject30264, this, arg0);
         return (OutputStream)this.postForAll(methodObject30264, (Object)super.getAsciiOutputStream(arg0));
      } catch (SQLException var4) {
         return (OutputStream)this.postForAll(methodObject30264, this.onErrorForAll(methodObject30264, var4));
      }
   }

   public byte[] shareBytes() {
      super.preForAll(methodObject30280, this, zeroLengthObjectArray);
      return (byte[])this.postForAll(methodObject30280, (Object)this.delegate.shareBytes());
   }

   public double doubleValue() throws SQLException {
      try {
         super.preForAll(methodObject30277, this, zeroLengthObjectArray);
         return (Double)this.postForAll(methodObject30277, this.delegate.doubleValue());
      } catch (SQLException var2) {
         return (Double)this.postForAll(methodObject30277, this.onErrorForAll(methodObject30277, var2));
      }
   }

   public Writer setCharacterStream(long arg0) throws SQLException {
      try {
         super.preForAll(methodObject30305, this, arg0);
         return (Writer)this.postForAll(methodObject30305, (Object)super.setCharacterStream(arg0));
      } catch (SQLException var4) {
         return (Writer)this.postForAll(methodObject30305, this.onErrorForAll(methodObject30305, var4));
      }
   }

   public void open(LargeObjectAccessMode arg0) throws SQLException {
      try {
         super.preForAll(methodObject30295, this, arg0);
         this.delegate.open(arg0);
      } catch (SQLException var3) {
         this.onErrorVoidForAll(methodObject30295, var3);
      }
   }

   public ClobDBAccess getDBAccess() throws SQLException {
      try {
         super.preForAll(methodObject30240, this, zeroLengthObjectArray);
         return (ClobDBAccess)this.postForAll(methodObject30240, (Object)this.delegate.getDBAccess());
      } catch (SQLException var2) {
         return (ClobDBAccess)this.postForAll(methodObject30240, this.onErrorForAll(methodObject30240, var2));
      }
   }

   public byte[] getLocator() {
      super.preForAll(methodObject30241, this, zeroLengthObjectArray);
      return (byte[])this.postForAll(methodObject30241, (Object)this.delegate.getLocator());
   }

   public void clearCachedData() {
      super.preForAll(methodObject30262, this, zeroLengthObjectArray);
      this.delegate.clearCachedData();
   }

   public long longValue() throws SQLException {
      try {
         super.preForAll(methodObject30275, this, zeroLengthObjectArray);
         return (Long)this.postForAll(methodObject30275, this.delegate.longValue());
      } catch (SQLException var2) {
         return (Long)this.postForAll(methodObject30275, this.onErrorForAll(methodObject30275, var2));
      }
   }

   public int setString(long arg0, String arg1, int arg2, int arg3) throws SQLException {
      try {
         super.preForClobWrites(methodObject30311, this, arg0, arg1, arg2, arg3);
         return (Integer)this.postForAll(methodObject30311, this.delegate.setString(arg0, arg1, arg2, arg3));
      } catch (SQLException var7) {
         return (Integer)this.postForAll(methodObject30311, this.onErrorForAll(methodObject30311, var7));
      }
   }

   public boolean canReadBasicLobDataInLocator() throws SQLException {
      try {
         super.preForAll(methodObject30250, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject30250, this.delegate.canReadBasicLobDataInLocator());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject30250, this.onErrorForAll(methodObject30250, var2));
      }
   }

   public Timestamp timestampValue(Calendar arg0) throws SQLException {
      try {
         super.preForAll(methodObject30290, this, arg0);
         return (Timestamp)this.postForAll(methodObject30290, (Object)this.delegate.timestampValue(arg0));
      } catch (SQLException var3) {
         return (Timestamp)this.postForAll(methodObject30290, this.onErrorForAll(methodObject30290, var3));
      }
   }

   public char[] getPrefetchedData() {
      super.preForAll(methodObject30259, this, zeroLengthObjectArray);
      return (char[])this.postForAll(methodObject30259, (Object)this.delegate.getPrefetchedData());
   }

   public void trim(long arg0) throws SQLException {
      try {
         super.preForAll(methodObject30237, this, arg0);
         this.delegate.trim(arg0);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject30237, var4);
      }
   }

   public long length() throws SQLException {
      try {
         super.preForAll(methodObject30300, this, zeroLengthObjectArray);
         return (Long)this.postForAll(methodObject30300, this.delegate.length());
      } catch (SQLException var2) {
         return (Long)this.postForAll(methodObject30300, this.onErrorForAll(methodObject30300, var2));
      }
   }

   public void setActivePrefetch(boolean arg0) {
      super.preForAll(methodObject30261, this, arg0);
      this.delegate.setActivePrefetch(arg0);
   }

   public OracleConnection getInternalConnection() throws SQLException {
      try {
         super.preForAll(methodObject30279, this, zeroLengthObjectArray);
         return (OracleConnection)this.postForAll(methodObject30279, (Object)super.getInternalConnection());
      } catch (SQLException var2) {
         return (OracleConnection)this.postForAll(methodObject30279, this.onErrorForAll(methodObject30279, var2));
      }
   }

   public int putString(long arg0, String arg1) throws SQLException {
      try {
         super.preForAll(methodObject30270, this, arg0, arg1);
         return (Integer)this.postForAll(methodObject30270, this.delegate.putString(arg0, arg1));
      } catch (SQLException var5) {
         return (Integer)this.postForAll(methodObject30270, this.onErrorForAll(methodObject30270, var5));
      }
   }

   public Reader getCharacterStream() throws SQLException {
      try {
         super.preForAll(methodObject30308, this, zeroLengthObjectArray);
         return (Reader)this.postForAll(methodObject30308, (Object)super.getCharacterStream());
      } catch (SQLException var2) {
         return (Reader)this.postForAll(methodObject30308, this.onErrorForAll(methodObject30308, var2));
      }
   }

   public int putChars(long arg0, char[] arg1, int arg2, int arg3) throws SQLException {
      try {
         super.preForAll(methodObject30269, this, arg0, arg1, arg2, arg3);
         return (Integer)this.postForAll(methodObject30269, this.delegate.putChars(arg0, arg1, arg2, arg3));
      } catch (SQLException var7) {
         return (Integer)this.postForAll(methodObject30269, this.onErrorForAll(methodObject30269, var7));
      }
   }

   public long position(String arg0, long arg1) throws SQLException {
      try {
         super.preForAll(methodObject30301, this, arg0, arg1);
         return (Long)this.postForAll(methodObject30301, this.delegate.position(arg0, arg1));
      } catch (SQLException var5) {
         return (Long)this.postForAll(methodObject30301, this.onErrorForAll(methodObject30301, var5));
      }
   }

   public boolean isConvertibleTo(Class arg0) {
      super.preForAll(methodObject30238, this, arg0);
      return (Boolean)this.postForAll(methodObject30238, this.delegate.isConvertibleTo(arg0));
   }

   public byte[] getBytes() {
      super.preForAll(methodObject30278, this, zeroLengthObjectArray);
      return (byte[])this.postForAll(methodObject30278, (Object)this.delegate.getBytes());
   }

   public Time timeValue(Calendar arg0) throws SQLException {
      try {
         super.preForAll(methodObject30288, this, arg0);
         return (Time)this.postForAll(methodObject30288, (Object)this.delegate.timeValue(arg0));
      } catch (SQLException var3) {
         return (Time)this.postForAll(methodObject30288, this.onErrorForAll(methodObject30288, var3));
      }
   }

   public OutputStream getAsciiOutputStream() throws SQLException {
      try {
         super.preForAll(methodObject30265, this, zeroLengthObjectArray);
         return (OutputStream)this.postForAll(methodObject30265, (Object)super.getAsciiOutputStream());
      } catch (SQLException var2) {
         return (OutputStream)this.postForAll(methodObject30265, this.onErrorForAll(methodObject30265, var2));
      }
   }

   public Writer getCharacterOutputStream(long arg0) throws SQLException {
      try {
         super.preForAll(methodObject30266, this, arg0);
         return (Writer)this.postForAll(methodObject30266, (Object)super.getCharacterOutputStream(arg0));
      } catch (SQLException var4) {
         return (Writer)this.postForAll(methodObject30266, this.onErrorForAll(methodObject30266, var4));
      }
   }

   public int getPrefetchedDataSize() {
      super.preForAll(methodObject30260, this, zeroLengthObjectArray);
      return (Integer)this.postForAll(methodObject30260, this.delegate.getPrefetchedDataSize());
   }

   public InputStream binaryStreamValue() throws SQLException {
      try {
         super.preForAll(methodObject30246, this, zeroLengthObjectArray);
         return (InputStream)this.postForAll(methodObject30246, (Object)this.delegate.binaryStreamValue());
      } catch (SQLException var2) {
         return (InputStream)this.postForAll(methodObject30246, this.onErrorForAll(methodObject30246, var2));
      }
   }

   public OutputStream setAsciiStream(long arg0) throws SQLException {
      try {
         super.preForAll(methodObject30304, this, arg0);
         return (OutputStream)this.postForAll(methodObject30304, (Object)super.setAsciiStream(arg0));
      } catch (SQLException var4) {
         return (OutputStream)this.postForAll(methodObject30304, this.onErrorForAll(methodObject30304, var4));
      }
   }

   public Object getACProxy() {
      super.preForAll(methodObject30314, this, zeroLengthObjectArray);
      return this.postForAll(methodObject30314, this.proxyFactory.proxyForCache(this.delegate.getACProxy(), this, this.proxyCache, methodObject30314));
   }

   public oracle.jdbc.OracleConnection getOracleConnection() throws SQLException {
      try {
         super.preForAll(methodObject30291, this, zeroLengthObjectArray);
         return (oracle.jdbc.OracleConnection)this.postForAll(methodObject30291, this.proxyFactory.proxyForCache((Object)this.delegate.getOracleConnection(), this, this.proxyCache, methodObject30291));
      } catch (SQLException var2) {
         return (oracle.jdbc.OracleConnection)this.postForAll(methodObject30291, this.onErrorForAll(methodObject30291, var2));
      }
   }

   public int putChars(long arg0, char[] arg1) throws SQLException {
      try {
         super.preForAll(methodObject30268, this, arg0, arg1);
         return (Integer)this.postForAll(methodObject30268, this.delegate.putChars(arg0, arg1));
      } catch (SQLException var5) {
         return (Integer)this.postForAll(methodObject30268, this.onErrorForAll(methodObject30268, var5));
      }
   }

   public InputStream getAsciiStream() throws SQLException {
      try {
         super.preForAll(methodObject30307, this, zeroLengthObjectArray);
         return (InputStream)this.postForAll(methodObject30307, (Object)super.getAsciiStream());
      } catch (SQLException var2) {
         return (InputStream)this.postForAll(methodObject30307, this.onErrorForAll(methodObject30307, var2));
      }
   }

   public Object toJdbc() throws SQLException {
      try {
         super.preForAll(methodObject30243, this, zeroLengthObjectArray);
         return this.postForAll(methodObject30243, this.proxyFactory.proxyForCache(this.delegate.toJdbc(), this, this.proxyCache, methodObject30243));
      } catch (SQLException var2) {
         return this.postForAll(methodObject30243, this.onErrorForAll(methodObject30243, var2));
      }
   }

   public int getBufferSize() throws SQLException {
      try {
         super.preForAll(methodObject30251, this, zeroLengthObjectArray);
         return (Integer)this.postForAll(methodObject30251, this.delegate.getBufferSize());
      } catch (SQLException var2) {
         return (Integer)this.postForAll(methodObject30251, this.onErrorForAll(methodObject30251, var2));
      }
   }

   public void truncate(long arg0) throws SQLException {
      try {
         super.preForClobWrites(methodObject30306, this, arg0);
         this.delegate.truncate(arg0);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject30306, var4);
      }
   }

   public long position(Clob arg0, long arg1) throws SQLException {
      try {
         super.preForAll(methodObject30302, this, arg0, arg1);
         return (Long)this.postForAll(methodObject30302, this.delegate.position(arg0 instanceof _Proxy_ ? (Clob)((_Proxy_)arg0)._getDelegate_() : arg0, arg1));
      } catch (SQLException var5) {
         return (Long)this.postForAll(methodObject30302, this.onErrorForAll(methodObject30302, var5));
      }
   }

   public boolean isOpen() throws SQLException {
      try {
         super.preForAll(methodObject30296, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject30296, this.delegate.isOpen());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject30296, this.onErrorForAll(methodObject30296, var2));
      }
   }

   public Date dateValue() throws SQLException {
      try {
         super.preForAll(methodObject30286, this, zeroLengthObjectArray);
         return (Date)this.postForAll(methodObject30286, (Object)this.delegate.dateValue());
      } catch (SQLException var2) {
         return (Date)this.postForAll(methodObject30286, this.onErrorForAll(methodObject30286, var2));
      }
   }

   public int getChunkSize() throws SQLException {
      try {
         super.preForAll(methodObject30255, this, zeroLengthObjectArray);
         return (Integer)this.postForAll(methodObject30255, this.delegate.getChunkSize());
      } catch (SQLException var2) {
         return (Integer)this.postForAll(methodObject30255, this.onErrorForAll(methodObject30255, var2));
      }
   }

   public void setBytes(byte[] arg0) {
      super.preForAll(methodObject30281, this, arg0);
      this.delegate.setBytes(arg0);
   }

   public BigDecimal bigDecimalValue() throws SQLException {
      try {
         super.preForAll(methodObject30285, this, zeroLengthObjectArray);
         return (BigDecimal)this.postForAll(methodObject30285, (Object)this.delegate.bigDecimalValue());
      } catch (SQLException var2) {
         return (BigDecimal)this.postForAll(methodObject30285, this.onErrorForAll(methodObject30285, var2));
      }
   }

   public Reader getCharacterStream(long arg0, long arg1) throws SQLException {
      try {
         super.preForAll(methodObject30309, this, arg0, arg1);
         return (Reader)this.postForAll(methodObject30309, (Object)super.getCharacterStream(arg0, arg1));
      } catch (SQLException var6) {
         return (Reader)this.postForAll(methodObject30309, this.onErrorForAll(methodObject30309, var6));
      }
   }

   public Object makeJdbcArray(int arg0) {
      super.preForAll(methodObject30247, this, arg0);
      return this.postForAll(methodObject30247, this.proxyFactory.proxyForCache(this.delegate.makeJdbcArray(arg0), this, this.proxyCache, methodObject30247));
   }

   public boolean isActivePrefetch() {
      super.preForAll(methodObject30263, this, zeroLengthObjectArray);
      return (Boolean)this.postForAll(methodObject30263, this.delegate.isActivePrefetch());
   }

   public boolean isNCLOB() {
      super.preForAll(methodObject30254, this, zeroLengthObjectArray);
      return (Boolean)this.postForAll(methodObject30254, this.delegate.isNCLOB());
   }

   public byte byteValue() throws SQLException {
      try {
         super.preForAll(methodObject30273, this, zeroLengthObjectArray);
         return (Byte)this.postForAll(methodObject30273, this.delegate.byteValue());
      } catch (SQLException var2) {
         return (Byte)this.postForAll(methodObject30273, this.onErrorForAll(methodObject30273, var2));
      }
   }

   public Writer getCharacterOutputStream() throws SQLException {
      try {
         super.preForAll(methodObject30267, this, zeroLengthObjectArray);
         return (Writer)this.postForAll(methodObject30267, (Object)super.getCharacterOutputStream());
      } catch (SQLException var2) {
         return (Writer)this.postForAll(methodObject30267, this.onErrorForAll(methodObject30267, var2));
      }
   }

   public Reader getCharacterStream(long arg0) throws SQLException {
      try {
         super.preForAll(methodObject30253, this, arg0);
         return (Reader)this.postForAll(methodObject30253, (Object)super.getCharacterStream(arg0));
      } catch (SQLException var4) {
         return (Reader)this.postForAll(methodObject30253, this.onErrorForAll(methodObject30253, var4));
      }
   }

   public Reader characterStreamValue() throws SQLException {
      try {
         super.preForAll(methodObject30244, this, zeroLengthObjectArray);
         return (Reader)this.postForAll(methodObject30244, (Object)this.delegate.characterStreamValue());
      } catch (SQLException var2) {
         return (Reader)this.postForAll(methodObject30244, this.onErrorForAll(methodObject30244, var2));
      }
   }

   public float floatValue() throws SQLException {
      try {
         super.preForAll(methodObject30276, this, zeroLengthObjectArray);
         return (Float)this.postForAll(methodObject30276, this.delegate.floatValue());
      } catch (SQLException var2) {
         return (Float)this.postForAll(methodObject30276, this.onErrorForAll(methodObject30276, var2));
      }
   }

   public int setString(long arg0, String arg1) throws SQLException {
      try {
         super.preForClobWrites(methodObject30310, this, arg0, arg1);
         return (Integer)this.postForAll(methodObject30310, this.delegate.setString(arg0, arg1));
      } catch (SQLException var5) {
         return (Integer)this.postForAll(methodObject30310, this.onErrorForAll(methodObject30310, var5));
      }
   }

   public void setChunkSize(int arg0) {
      super.preForAll(methodObject30256, this, arg0);
      this.delegate.setChunkSize(arg0);
   }

   public InputStream getStream() throws SQLException {
      try {
         super.preForAll(methodObject30283, this, zeroLengthObjectArray);
         return (InputStream)this.postForAll(methodObject30283, (Object)this.delegate.getStream());
      } catch (SQLException var2) {
         return (InputStream)this.postForAll(methodObject30283, this.onErrorForAll(methodObject30283, var2));
      }
   }

   public Time timeValue() throws SQLException {
      try {
         super.preForAll(methodObject30287, this, zeroLengthObjectArray);
         return (Time)this.postForAll(methodObject30287, (Object)this.delegate.timeValue());
      } catch (SQLException var2) {
         return (Time)this.postForAll(methodObject30287, this.onErrorForAll(methodObject30287, var2));
      }
   }

   public int getChars(long arg0, int arg1, char[] arg2) throws SQLException {
      try {
         super.preForAll(methodObject30236, this, arg0, arg1, arg2);
         return (Integer)this.postForAll(methodObject30236, this.delegate.getChars(arg0, arg1, arg2));
      } catch (SQLException var6) {
         return (Integer)this.postForAll(methodObject30236, this.onErrorForAll(methodObject30236, var6));
      }
   }

   public long getLength() {
      super.preForAll(methodObject30271, this, zeroLengthObjectArray);
      return (Long)this.postForAll(methodObject30271, this.delegate.getLength());
   }

   public oracle.jdbc.driver.OracleConnection getConnection() throws SQLException {
      try {
         super.preForAll(methodObject30293, this, zeroLengthObjectArray);
         return (oracle.jdbc.driver.OracleConnection)this.postForAll(methodObject30293, (Object)this.delegate.getConnection());
      } catch (SQLException var2) {
         return (oracle.jdbc.driver.OracleConnection)this.postForAll(methodObject30293, this.onErrorForAll(methodObject30293, var2));
      }
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
         methodObject30282 = OracleDatumWithConnection.class.getDeclaredMethod("setShareBytes", byte[].class);
         methodObject30252 = OracleClob.class.getDeclaredMethod("getAsciiStream", Long.TYPE);
         methodObject30242 = OracleClob.class.getDeclaredMethod("setLocator", byte[].class);
         methodObject30299 = oracle.jdbc.OracleClob.class.getDeclaredMethod("isTemporary");
         methodObject30294 = oracle.jdbc.OracleClob.class.getDeclaredMethod("close");
         methodObject30248 = OracleClob.class.getDeclaredMethod("getJavaSqlConnection");
         methodObject30272 = OracleDatumWithConnection.class.getDeclaredMethod("booleanValue");
         methodObject30297 = oracle.jdbc.OracleClob.class.getDeclaredMethod("isEmptyLob");
         methodObject30239 = OracleClob.class.getDeclaredMethod("setLength", Long.TYPE);
         methodObject30313 = ACProxyable.class.getDeclaredMethod("setACProxy", Object.class);
         methodObject30289 = OracleDatumWithConnection.class.getDeclaredMethod("timestampValue");
         methodObject30292 = OracleDatumWithConnection.class.getDeclaredMethod("setPhysicalConnectionOf", Connection.class);
         methodObject30274 = OracleDatumWithConnection.class.getDeclaredMethod("intValue");
         methodObject30258 = OracleClob.class.getDeclaredMethod("setPrefetchedData", char[].class, Integer.TYPE);
         methodObject30249 = OracleClob.class.getDeclaredMethod("stringValue");
         methodObject30284 = OracleDatumWithConnection.class.getDeclaredMethod("stringValue", Connection.class);
         methodObject30298 = oracle.jdbc.OracleClob.class.getDeclaredMethod("isSecureFile");
         methodObject30303 = Clob.class.getDeclaredMethod("free");
         methodObject30257 = OracleClob.class.getDeclaredMethod("setPrefetchedData", char[].class);
         methodObject30312 = Clob.class.getDeclaredMethod("getSubString", Long.TYPE, Integer.TYPE);
         methodObject30245 = OracleClob.class.getDeclaredMethod("asciiStreamValue");
         methodObject30264 = OracleClob.class.getDeclaredMethod("getAsciiOutputStream", Long.TYPE);
         methodObject30280 = OracleDatumWithConnection.class.getDeclaredMethod("shareBytes");
         methodObject30277 = OracleDatumWithConnection.class.getDeclaredMethod("doubleValue");
         methodObject30305 = Clob.class.getDeclaredMethod("setCharacterStream", Long.TYPE);
         methodObject30295 = oracle.jdbc.OracleClob.class.getDeclaredMethod("open", LargeObjectAccessMode.class);
         methodObject30240 = OracleClob.class.getDeclaredMethod("getDBAccess");
         methodObject30241 = OracleClob.class.getDeclaredMethod("getLocator");
         methodObject30262 = OracleClob.class.getDeclaredMethod("clearCachedData");
         methodObject30275 = OracleDatumWithConnection.class.getDeclaredMethod("longValue");
         methodObject30311 = Clob.class.getDeclaredMethod("setString", Long.TYPE, String.class, Integer.TYPE, Integer.TYPE);
         methodObject30250 = OracleClob.class.getDeclaredMethod("canReadBasicLobDataInLocator");
         methodObject30290 = OracleDatumWithConnection.class.getDeclaredMethod("timestampValue", Calendar.class);
         methodObject30259 = OracleClob.class.getDeclaredMethod("getPrefetchedData");
         methodObject30237 = OracleClob.class.getDeclaredMethod("trim", Long.TYPE);
         methodObject30300 = Clob.class.getDeclaredMethod("length");
         methodObject30261 = OracleClob.class.getDeclaredMethod("setActivePrefetch", Boolean.TYPE);
         methodObject30279 = OracleDatumWithConnection.class.getDeclaredMethod("getInternalConnection");
         methodObject30270 = OracleClob.class.getDeclaredMethod("putString", Long.TYPE, String.class);
         methodObject30308 = Clob.class.getDeclaredMethod("getCharacterStream");
         methodObject30269 = OracleClob.class.getDeclaredMethod("putChars", Long.TYPE, char[].class, Integer.TYPE, Integer.TYPE);
         methodObject30301 = Clob.class.getDeclaredMethod("position", String.class, Long.TYPE);
         methodObject30238 = OracleClob.class.getDeclaredMethod("isConvertibleTo", Class.class);
         methodObject30278 = OracleDatumWithConnection.class.getDeclaredMethod("getBytes");
         methodObject30288 = OracleDatumWithConnection.class.getDeclaredMethod("timeValue", Calendar.class);
         methodObject30265 = OracleClob.class.getDeclaredMethod("getAsciiOutputStream");
         methodObject30266 = OracleClob.class.getDeclaredMethod("getCharacterOutputStream", Long.TYPE);
         methodObject30260 = OracleClob.class.getDeclaredMethod("getPrefetchedDataSize");
         methodObject30246 = OracleClob.class.getDeclaredMethod("binaryStreamValue");
         methodObject30304 = Clob.class.getDeclaredMethod("setAsciiStream", Long.TYPE);
         methodObject30314 = ACProxyable.class.getDeclaredMethod("getACProxy");
         methodObject30291 = OracleDatumWithConnection.class.getDeclaredMethod("getOracleConnection");
         methodObject30268 = OracleClob.class.getDeclaredMethod("putChars", Long.TYPE, char[].class);
         methodObject30307 = Clob.class.getDeclaredMethod("getAsciiStream");
         methodObject30243 = OracleClob.class.getDeclaredMethod("toJdbc");
         methodObject30251 = OracleClob.class.getDeclaredMethod("getBufferSize");
         methodObject30306 = Clob.class.getDeclaredMethod("truncate", Long.TYPE);
         methodObject30302 = Clob.class.getDeclaredMethod("position", Clob.class, Long.TYPE);
         methodObject30296 = oracle.jdbc.OracleClob.class.getDeclaredMethod("isOpen");
         methodObject30286 = OracleDatumWithConnection.class.getDeclaredMethod("dateValue");
         methodObject30255 = OracleClob.class.getDeclaredMethod("getChunkSize");
         methodObject30281 = OracleDatumWithConnection.class.getDeclaredMethod("setBytes", byte[].class);
         methodObject30285 = OracleDatumWithConnection.class.getDeclaredMethod("bigDecimalValue");
         methodObject30309 = Clob.class.getDeclaredMethod("getCharacterStream", Long.TYPE, Long.TYPE);
         methodObject30247 = OracleClob.class.getDeclaredMethod("makeJdbcArray", Integer.TYPE);
         methodObject30263 = OracleClob.class.getDeclaredMethod("isActivePrefetch");
         methodObject30254 = OracleClob.class.getDeclaredMethod("isNCLOB");
         methodObject30273 = OracleDatumWithConnection.class.getDeclaredMethod("byteValue");
         methodObject30267 = OracleClob.class.getDeclaredMethod("getCharacterOutputStream");
         methodObject30253 = OracleClob.class.getDeclaredMethod("getCharacterStream", Long.TYPE);
         methodObject30244 = OracleClob.class.getDeclaredMethod("characterStreamValue");
         methodObject30276 = OracleDatumWithConnection.class.getDeclaredMethod("floatValue");
         methodObject30310 = Clob.class.getDeclaredMethod("setString", Long.TYPE, String.class);
         methodObject30256 = OracleClob.class.getDeclaredMethod("setChunkSize", Integer.TYPE);
         methodObject30283 = OracleDatumWithConnection.class.getDeclaredMethod("getStream");
         methodObject30287 = OracleDatumWithConnection.class.getDeclaredMethod("timeValue");
         methodObject30236 = OracleClob.class.getDeclaredMethod("getChars", Long.TYPE, Integer.TYPE, char[].class);
         methodObject30271 = OracleDatumWithConnection.class.getDeclaredMethod("getLength");
         methodObject30293 = OracleDatumWithConnection.class.getDeclaredMethod("getConnection");
      } catch (Throwable var1) {
         throw new RuntimeException(var1);
      }
   }

   public oracle$1jdbc$1replay$1driver$1NonTxnReplayableClob$2oracle$1jdbc$1internal$1OracleClob$$$Proxy(OracleClob var1, Object var2, ProxyFactory var3, Map var4) {
      this.delegate = var1;
      this.creator = var2;
      this.proxyFactory = var3;
      this.proxyCache = var4;
   }
}
