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
import oracle.jdbc.internal.OracleNClob;
import oracle.jdbc.replay.driver.NonTxnReplayableNClob;
import oracle.sql.ClobDBAccess;

public abstract class oracle$1jdbc$1replay$1driver$1NonTxnReplayableNClob$2oracle$1jdbc$1internal$1OracleNClob$$$Proxy extends NonTxnReplayableNClob implements OracleNClob, _Proxy_ {
   private OracleNClob delegate;
   private final Object creator;
   private final ProxyFactory proxyFactory;
   private final Map proxyCache;
   private static Object[] zeroLengthObjectArray = new Object[0];
   private static Method methodObject25247;
   private static Method methodObject25295;
   private static Method methodObject25285;
   private static Method methodObject25278;
   private static Method methodObject25273;
   private static Method methodObject25291;
   private static Method methodObject25230;
   private static Method methodObject25276;
   private static Method methodObject25282;
   private static Method methodObject25314;
   private static Method methodObject25255;
   private static Method methodObject25232;
   private static Method methodObject25258;
   private static Method methodObject25301;
   private static Method methodObject25292;
   private static Method methodObject25250;
   private static Method methodObject25277;
   private static Method methodObject25263;
   private static Method methodObject25300;
   private static Method methodObject25288;
   private static Method methodObject25272;
   private static Method methodObject25307;
   private static Method methodObject25245;
   private static Method methodObject25235;
   private static Method methodObject25283;
   private static Method methodObject25265;
   private static Method methodObject25274;
   private static Method methodObject25284;
   private static Method methodObject25305;
   private static Method methodObject25233;
   private static Method methodObject25293;
   private static Method methodObject25271;
   private static Method methodObject25256;
   private static Method methodObject25302;
   private static Method methodObject25280;
   private static Method methodObject25260;
   private static Method methodObject25304;
   private static Method methodObject25238;
   private static Method methodObject25313;
   private static Method methodObject25312;
   private static Method methodObject25268;
   private static Method methodObject25261;
   private static Method methodObject25281;
   private static Method methodObject25236;
   private static Method methodObject25254;
   private static Method methodObject25308;
   private static Method methodObject25309;
   private static Method methodObject25303;
   private static Method methodObject25289;
   private static Method methodObject25264;
   private static Method methodObject25315;
   private static Method methodObject25311;
   private static Method methodObject25257;
   private static Method methodObject25286;
   private static Method methodObject25267;
   private static Method methodObject25294;
   private static Method methodObject25262;
   private static Method methodObject25266;
   private static Method methodObject25275;
   private static Method methodObject25252;
   private static Method methodObject25298;
   private static Method methodObject25246;
   private static Method methodObject25251;
   private static Method methodObject25269;
   private static Method methodObject25290;
   private static Method methodObject25306;
   private static Method methodObject25297;
   private static Method methodObject25231;
   private static Method methodObject25310;
   private static Method methodObject25296;
   private static Method methodObject25234;
   private static Method methodObject25287;
   private static Method methodObject25299;
   private static Method methodObject25270;
   private static Method methodObject25248;
   private static Method methodObject25279;
   private static Method methodObject25253;
   private static Method methodObject25229;
   private static Method methodObject25259;

   public void setShareBytes(byte[] arg0) {
      super.preForAll(methodObject25247, this, arg0);
      this.delegate.setShareBytes(arg0);
   }

   public InputStream getAsciiStream(long arg0) throws SQLException {
      try {
         super.preForAll(methodObject25295, this, arg0);
         return (InputStream)this.postForAll(methodObject25295, (Object)super.getAsciiStream(arg0));
      } catch (SQLException var4) {
         return (InputStream)this.postForAll(methodObject25295, this.onErrorForAll(methodObject25295, var4));
      }
   }

   public void setLocator(byte[] arg0) {
      super.preForAll(methodObject25285, this, arg0);
      this.delegate.setLocator(arg0);
   }

   public boolean isTemporary() throws SQLException {
      try {
         super.preForAll(methodObject25278, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject25278, this.delegate.isTemporary());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject25278, this.onErrorForAll(methodObject25278, var2));
      }
   }

   public void close() throws SQLException {
      try {
         super.preForAll(methodObject25273, this, zeroLengthObjectArray);
         this.delegate.close();
      } catch (SQLException var2) {
         this.onErrorVoidForAll(methodObject25273, var2);
      }
   }

   public Connection getJavaSqlConnection() throws SQLException {
      try {
         super.preForAll(methodObject25291, this, zeroLengthObjectArray);
         return (Connection)this.postForAll(methodObject25291, this.proxyFactory.proxyForCache((Object)this.delegate.getJavaSqlConnection(), this, this.proxyCache, methodObject25291));
      } catch (SQLException var2) {
         return (Connection)this.postForAll(methodObject25291, this.onErrorForAll(methodObject25291, var2));
      }
   }

   public boolean booleanValue() throws SQLException {
      try {
         super.preForAll(methodObject25230, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject25230, this.delegate.booleanValue());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject25230, this.onErrorForAll(methodObject25230, var2));
      }
   }

   public boolean isEmptyLob() throws SQLException {
      try {
         super.preForAll(methodObject25276, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject25276, this.delegate.isEmptyLob());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject25276, this.onErrorForAll(methodObject25276, var2));
      }
   }

   public void setLength(long arg0) {
      super.preForAll(methodObject25282, this, arg0);
      this.delegate.setLength(arg0);
   }

   public void setACProxy(Object arg0) {
      super.preForAll(methodObject25314, this, arg0);
      this.delegate.setACProxy(arg0 instanceof _Proxy_ ? (Object)((_Proxy_)arg0)._getDelegate_() : arg0);
   }

   public Timestamp timestampValue() throws SQLException {
      try {
         super.preForAll(methodObject25255, this, zeroLengthObjectArray);
         return (Timestamp)this.postForAll(methodObject25255, (Object)this.delegate.timestampValue());
      } catch (SQLException var2) {
         return (Timestamp)this.postForAll(methodObject25255, this.onErrorForAll(methodObject25255, var2));
      }
   }

   public int intValue() throws SQLException {
      try {
         super.preForAll(methodObject25232, this, zeroLengthObjectArray);
         return (Integer)this.postForAll(methodObject25232, this.delegate.intValue());
      } catch (SQLException var2) {
         return (Integer)this.postForAll(methodObject25232, this.onErrorForAll(methodObject25232, var2));
      }
   }

   public void setPhysicalConnectionOf(Connection arg0) {
      super.preForAll(methodObject25258, this, arg0);
      this.delegate.setPhysicalConnectionOf(arg0 instanceof _Proxy_ ? (Connection)((_Proxy_)arg0)._getDelegate_() : arg0);
   }

   public void setPrefetchedData(char[] arg0, int arg1) {
      super.preForAll(methodObject25301, this, arg0, arg1);
      this.delegate.setPrefetchedData(arg0, arg1);
   }

   public String stringValue() throws SQLException {
      try {
         super.preForAll(methodObject25292, this, zeroLengthObjectArray);
         return (String)this.postForAll(methodObject25292, (Object)this.delegate.stringValue());
      } catch (SQLException var2) {
         return (String)this.postForAll(methodObject25292, this.onErrorForAll(methodObject25292, var2));
      }
   }

   public String stringValue(Connection arg0) throws SQLException {
      try {
         super.preForAll(methodObject25250, this, arg0);
         return (String)this.postForAll(methodObject25250, (Object)this.delegate.stringValue(arg0 instanceof _Proxy_ ? (Connection)((_Proxy_)arg0)._getDelegate_() : arg0));
      } catch (SQLException var3) {
         return (String)this.postForAll(methodObject25250, this.onErrorForAll(methodObject25250, var3));
      }
   }

   public boolean isSecureFile() throws SQLException {
      try {
         super.preForAll(methodObject25277, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject25277, this.delegate.isSecureFile());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject25277, this.onErrorForAll(methodObject25277, var2));
      }
   }

   public void free() throws SQLException {
      try {
         super.preForAll(methodObject25263, this, zeroLengthObjectArray);
         this.delegate.free();
      } catch (SQLException var2) {
         this.onErrorVoidForAll(methodObject25263, var2);
      }
   }

   public void setPrefetchedData(char[] arg0) {
      super.preForAll(methodObject25300, this, arg0);
      this.delegate.setPrefetchedData(arg0);
   }

   public InputStream asciiStreamValue() throws SQLException {
      try {
         super.preForAll(methodObject25288, this, zeroLengthObjectArray);
         return (InputStream)this.postForAll(methodObject25288, (Object)this.delegate.asciiStreamValue());
      } catch (SQLException var2) {
         return (InputStream)this.postForAll(methodObject25288, this.onErrorForAll(methodObject25288, var2));
      }
   }

   public String getSubString(long arg0, int arg1) throws SQLException {
      try {
         super.preForAll(methodObject25272, this, arg0, arg1);
         return (String)this.postForAll(methodObject25272, (Object)this.delegate.getSubString(arg0, arg1));
      } catch (SQLException var5) {
         return (String)this.postForAll(methodObject25272, this.onErrorForAll(methodObject25272, var5));
      }
   }

   public OutputStream getAsciiOutputStream(long arg0) throws SQLException {
      try {
         super.preForAll(methodObject25307, this, arg0);
         return (OutputStream)this.postForAll(methodObject25307, (Object)super.getAsciiOutputStream(arg0));
      } catch (SQLException var4) {
         return (OutputStream)this.postForAll(methodObject25307, this.onErrorForAll(methodObject25307, var4));
      }
   }

   public byte[] shareBytes() {
      super.preForAll(methodObject25245, this, zeroLengthObjectArray);
      return (byte[])this.postForAll(methodObject25245, (Object)this.delegate.shareBytes());
   }

   public double doubleValue() throws SQLException {
      try {
         super.preForAll(methodObject25235, this, zeroLengthObjectArray);
         return (Double)this.postForAll(methodObject25235, this.delegate.doubleValue());
      } catch (SQLException var2) {
         return (Double)this.postForAll(methodObject25235, this.onErrorForAll(methodObject25235, var2));
      }
   }

   public ClobDBAccess getDBAccess() throws SQLException {
      try {
         super.preForAll(methodObject25283, this, zeroLengthObjectArray);
         return (ClobDBAccess)this.postForAll(methodObject25283, (Object)this.delegate.getDBAccess());
      } catch (SQLException var2) {
         return (ClobDBAccess)this.postForAll(methodObject25283, this.onErrorForAll(methodObject25283, var2));
      }
   }

   public Writer setCharacterStream(long arg0) throws SQLException {
      try {
         super.preForAll(methodObject25265, this, arg0);
         return (Writer)this.postForAll(methodObject25265, (Object)super.setCharacterStream(arg0));
      } catch (SQLException var4) {
         return (Writer)this.postForAll(methodObject25265, this.onErrorForAll(methodObject25265, var4));
      }
   }

   public void open(LargeObjectAccessMode arg0) throws SQLException {
      try {
         super.preForAll(methodObject25274, this, arg0);
         this.delegate.open(arg0);
      } catch (SQLException var3) {
         this.onErrorVoidForAll(methodObject25274, var3);
      }
   }

   public byte[] getLocator() {
      super.preForAll(methodObject25284, this, zeroLengthObjectArray);
      return (byte[])this.postForAll(methodObject25284, (Object)this.delegate.getLocator());
   }

   public void clearCachedData() {
      super.preForAll(methodObject25305, this, zeroLengthObjectArray);
      this.delegate.clearCachedData();
   }

   public long longValue() throws SQLException {
      try {
         super.preForAll(methodObject25233, this, zeroLengthObjectArray);
         return (Long)this.postForAll(methodObject25233, this.delegate.longValue());
      } catch (SQLException var2) {
         return (Long)this.postForAll(methodObject25233, this.onErrorForAll(methodObject25233, var2));
      }
   }

   public boolean canReadBasicLobDataInLocator() throws SQLException {
      try {
         super.preForAll(methodObject25293, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject25293, this.delegate.canReadBasicLobDataInLocator());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject25293, this.onErrorForAll(methodObject25293, var2));
      }
   }

   public int setString(long arg0, String arg1, int arg2, int arg3) throws SQLException {
      try {
         super.preForClobWrites(methodObject25271, this, arg0, arg1, arg2, arg3);
         return (Integer)this.postForAll(methodObject25271, this.delegate.setString(arg0, arg1, arg2, arg3));
      } catch (SQLException var7) {
         return (Integer)this.postForAll(methodObject25271, this.onErrorForAll(methodObject25271, var7));
      }
   }

   public Timestamp timestampValue(Calendar arg0) throws SQLException {
      try {
         super.preForAll(methodObject25256, this, arg0);
         return (Timestamp)this.postForAll(methodObject25256, (Object)this.delegate.timestampValue(arg0));
      } catch (SQLException var3) {
         return (Timestamp)this.postForAll(methodObject25256, this.onErrorForAll(methodObject25256, var3));
      }
   }

   public char[] getPrefetchedData() {
      super.preForAll(methodObject25302, this, zeroLengthObjectArray);
      return (char[])this.postForAll(methodObject25302, (Object)this.delegate.getPrefetchedData());
   }

   public void trim(long arg0) throws SQLException {
      try {
         super.preForAll(methodObject25280, this, arg0);
         this.delegate.trim(arg0);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject25280, var4);
      }
   }

   public long length() throws SQLException {
      try {
         super.preForAll(methodObject25260, this, zeroLengthObjectArray);
         return (Long)this.postForAll(methodObject25260, this.delegate.length());
      } catch (SQLException var2) {
         return (Long)this.postForAll(methodObject25260, this.onErrorForAll(methodObject25260, var2));
      }
   }

   public void setActivePrefetch(boolean arg0) {
      super.preForAll(methodObject25304, this, arg0);
      this.delegate.setActivePrefetch(arg0);
   }

   public OracleConnection getInternalConnection() throws SQLException {
      try {
         super.preForAll(methodObject25238, this, zeroLengthObjectArray);
         return (OracleConnection)this.postForAll(methodObject25238, (Object)super.getInternalConnection());
      } catch (SQLException var2) {
         return (OracleConnection)this.postForAll(methodObject25238, this.onErrorForAll(methodObject25238, var2));
      }
   }

   public int putString(long arg0, String arg1) throws SQLException {
      try {
         super.preForAll(methodObject25313, this, arg0, arg1);
         return (Integer)this.postForAll(methodObject25313, this.delegate.putString(arg0, arg1));
      } catch (SQLException var5) {
         return (Integer)this.postForAll(methodObject25313, this.onErrorForAll(methodObject25313, var5));
      }
   }

   public int putChars(long arg0, char[] arg1, int arg2, int arg3) throws SQLException {
      try {
         super.preForAll(methodObject25312, this, arg0, arg1, arg2, arg3);
         return (Integer)this.postForAll(methodObject25312, this.delegate.putChars(arg0, arg1, arg2, arg3));
      } catch (SQLException var7) {
         return (Integer)this.postForAll(methodObject25312, this.onErrorForAll(methodObject25312, var7));
      }
   }

   public Reader getCharacterStream() throws SQLException {
      try {
         super.preForAll(methodObject25268, this, zeroLengthObjectArray);
         return (Reader)this.postForAll(methodObject25268, (Object)super.getCharacterStream());
      } catch (SQLException var2) {
         return (Reader)this.postForAll(methodObject25268, this.onErrorForAll(methodObject25268, var2));
      }
   }

   public long position(String arg0, long arg1) throws SQLException {
      try {
         super.preForAll(methodObject25261, this, arg0, arg1);
         return (Long)this.postForAll(methodObject25261, this.delegate.position(arg0, arg1));
      } catch (SQLException var5) {
         return (Long)this.postForAll(methodObject25261, this.onErrorForAll(methodObject25261, var5));
      }
   }

   public boolean isConvertibleTo(Class arg0) {
      super.preForAll(methodObject25281, this, arg0);
      return (Boolean)this.postForAll(methodObject25281, this.delegate.isConvertibleTo(arg0));
   }

   public byte[] getBytes() {
      super.preForAll(methodObject25236, this, zeroLengthObjectArray);
      return (byte[])this.postForAll(methodObject25236, (Object)this.delegate.getBytes());
   }

   public Time timeValue(Calendar arg0) throws SQLException {
      try {
         super.preForAll(methodObject25254, this, arg0);
         return (Time)this.postForAll(methodObject25254, (Object)this.delegate.timeValue(arg0));
      } catch (SQLException var3) {
         return (Time)this.postForAll(methodObject25254, this.onErrorForAll(methodObject25254, var3));
      }
   }

   public OutputStream getAsciiOutputStream() throws SQLException {
      try {
         super.preForAll(methodObject25308, this, zeroLengthObjectArray);
         return (OutputStream)this.postForAll(methodObject25308, (Object)super.getAsciiOutputStream());
      } catch (SQLException var2) {
         return (OutputStream)this.postForAll(methodObject25308, this.onErrorForAll(methodObject25308, var2));
      }
   }

   public Writer getCharacterOutputStream(long arg0) throws SQLException {
      try {
         super.preForAll(methodObject25309, this, arg0);
         return (Writer)this.postForAll(methodObject25309, (Object)super.getCharacterOutputStream(arg0));
      } catch (SQLException var4) {
         return (Writer)this.postForAll(methodObject25309, this.onErrorForAll(methodObject25309, var4));
      }
   }

   public int getPrefetchedDataSize() {
      super.preForAll(methodObject25303, this, zeroLengthObjectArray);
      return (Integer)this.postForAll(methodObject25303, this.delegate.getPrefetchedDataSize());
   }

   public InputStream binaryStreamValue() throws SQLException {
      try {
         super.preForAll(methodObject25289, this, zeroLengthObjectArray);
         return (InputStream)this.postForAll(methodObject25289, (Object)this.delegate.binaryStreamValue());
      } catch (SQLException var2) {
         return (InputStream)this.postForAll(methodObject25289, this.onErrorForAll(methodObject25289, var2));
      }
   }

   public OutputStream setAsciiStream(long arg0) throws SQLException {
      try {
         super.preForAll(methodObject25264, this, arg0);
         return (OutputStream)this.postForAll(methodObject25264, (Object)super.setAsciiStream(arg0));
      } catch (SQLException var4) {
         return (OutputStream)this.postForAll(methodObject25264, this.onErrorForAll(methodObject25264, var4));
      }
   }

   public Object getACProxy() {
      super.preForAll(methodObject25315, this, zeroLengthObjectArray);
      return this.postForAll(methodObject25315, this.proxyFactory.proxyForCache(this.delegate.getACProxy(), this, this.proxyCache, methodObject25315));
   }

   public int putChars(long arg0, char[] arg1) throws SQLException {
      try {
         super.preForAll(methodObject25311, this, arg0, arg1);
         return (Integer)this.postForAll(methodObject25311, this.delegate.putChars(arg0, arg1));
      } catch (SQLException var5) {
         return (Integer)this.postForAll(methodObject25311, this.onErrorForAll(methodObject25311, var5));
      }
   }

   public oracle.jdbc.OracleConnection getOracleConnection() throws SQLException {
      try {
         super.preForAll(methodObject25257, this, zeroLengthObjectArray);
         return (oracle.jdbc.OracleConnection)this.postForAll(methodObject25257, this.proxyFactory.proxyForCache((Object)this.delegate.getOracleConnection(), this, this.proxyCache, methodObject25257));
      } catch (SQLException var2) {
         return (oracle.jdbc.OracleConnection)this.postForAll(methodObject25257, this.onErrorForAll(methodObject25257, var2));
      }
   }

   public Object toJdbc() throws SQLException {
      try {
         super.preForAll(methodObject25286, this, zeroLengthObjectArray);
         return this.postForAll(methodObject25286, this.proxyFactory.proxyForCache(this.delegate.toJdbc(), this, this.proxyCache, methodObject25286));
      } catch (SQLException var2) {
         return this.postForAll(methodObject25286, this.onErrorForAll(methodObject25286, var2));
      }
   }

   public InputStream getAsciiStream() throws SQLException {
      try {
         super.preForAll(methodObject25267, this, zeroLengthObjectArray);
         return (InputStream)this.postForAll(methodObject25267, (Object)super.getAsciiStream());
      } catch (SQLException var2) {
         return (InputStream)this.postForAll(methodObject25267, this.onErrorForAll(methodObject25267, var2));
      }
   }

   public int getBufferSize() throws SQLException {
      try {
         super.preForAll(methodObject25294, this, zeroLengthObjectArray);
         return (Integer)this.postForAll(methodObject25294, this.delegate.getBufferSize());
      } catch (SQLException var2) {
         return (Integer)this.postForAll(methodObject25294, this.onErrorForAll(methodObject25294, var2));
      }
   }

   public long position(Clob arg0, long arg1) throws SQLException {
      try {
         super.preForAll(methodObject25262, this, arg0, arg1);
         return (Long)this.postForAll(methodObject25262, this.delegate.position(arg0 instanceof _Proxy_ ? (Clob)((_Proxy_)arg0)._getDelegate_() : arg0, arg1));
      } catch (SQLException var5) {
         return (Long)this.postForAll(methodObject25262, this.onErrorForAll(methodObject25262, var5));
      }
   }

   public void truncate(long arg0) throws SQLException {
      try {
         super.preForClobWrites(methodObject25266, this, arg0);
         this.delegate.truncate(arg0);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject25266, var4);
      }
   }

   public boolean isOpen() throws SQLException {
      try {
         super.preForAll(methodObject25275, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject25275, this.delegate.isOpen());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject25275, this.onErrorForAll(methodObject25275, var2));
      }
   }

   public Date dateValue() throws SQLException {
      try {
         super.preForAll(methodObject25252, this, zeroLengthObjectArray);
         return (Date)this.postForAll(methodObject25252, (Object)this.delegate.dateValue());
      } catch (SQLException var2) {
         return (Date)this.postForAll(methodObject25252, this.onErrorForAll(methodObject25252, var2));
      }
   }

   public int getChunkSize() throws SQLException {
      try {
         super.preForAll(methodObject25298, this, zeroLengthObjectArray);
         return (Integer)this.postForAll(methodObject25298, this.delegate.getChunkSize());
      } catch (SQLException var2) {
         return (Integer)this.postForAll(methodObject25298, this.onErrorForAll(methodObject25298, var2));
      }
   }

   public void setBytes(byte[] arg0) {
      super.preForAll(methodObject25246, this, arg0);
      this.delegate.setBytes(arg0);
   }

   public BigDecimal bigDecimalValue() throws SQLException {
      try {
         super.preForAll(methodObject25251, this, zeroLengthObjectArray);
         return (BigDecimal)this.postForAll(methodObject25251, (Object)this.delegate.bigDecimalValue());
      } catch (SQLException var2) {
         return (BigDecimal)this.postForAll(methodObject25251, this.onErrorForAll(methodObject25251, var2));
      }
   }

   public Reader getCharacterStream(long arg0, long arg1) throws SQLException {
      try {
         super.preForAll(methodObject25269, this, arg0, arg1);
         return (Reader)this.postForAll(methodObject25269, (Object)super.getCharacterStream(arg0, arg1));
      } catch (SQLException var6) {
         return (Reader)this.postForAll(methodObject25269, this.onErrorForAll(methodObject25269, var6));
      }
   }

   public Object makeJdbcArray(int arg0) {
      super.preForAll(methodObject25290, this, arg0);
      return this.postForAll(methodObject25290, this.proxyFactory.proxyForCache(this.delegate.makeJdbcArray(arg0), this, this.proxyCache, methodObject25290));
   }

   public boolean isActivePrefetch() {
      super.preForAll(methodObject25306, this, zeroLengthObjectArray);
      return (Boolean)this.postForAll(methodObject25306, this.delegate.isActivePrefetch());
   }

   public boolean isNCLOB() {
      super.preForAll(methodObject25297, this, zeroLengthObjectArray);
      return (Boolean)this.postForAll(methodObject25297, this.delegate.isNCLOB());
   }

   public byte byteValue() throws SQLException {
      try {
         super.preForAll(methodObject25231, this, zeroLengthObjectArray);
         return (Byte)this.postForAll(methodObject25231, this.delegate.byteValue());
      } catch (SQLException var2) {
         return (Byte)this.postForAll(methodObject25231, this.onErrorForAll(methodObject25231, var2));
      }
   }

   public Writer getCharacterOutputStream() throws SQLException {
      try {
         super.preForAll(methodObject25310, this, zeroLengthObjectArray);
         return (Writer)this.postForAll(methodObject25310, (Object)super.getCharacterOutputStream());
      } catch (SQLException var2) {
         return (Writer)this.postForAll(methodObject25310, this.onErrorForAll(methodObject25310, var2));
      }
   }

   public Reader getCharacterStream(long arg0) throws SQLException {
      try {
         super.preForAll(methodObject25296, this, arg0);
         return (Reader)this.postForAll(methodObject25296, (Object)super.getCharacterStream(arg0));
      } catch (SQLException var4) {
         return (Reader)this.postForAll(methodObject25296, this.onErrorForAll(methodObject25296, var4));
      }
   }

   public float floatValue() throws SQLException {
      try {
         super.preForAll(methodObject25234, this, zeroLengthObjectArray);
         return (Float)this.postForAll(methodObject25234, this.delegate.floatValue());
      } catch (SQLException var2) {
         return (Float)this.postForAll(methodObject25234, this.onErrorForAll(methodObject25234, var2));
      }
   }

   public Reader characterStreamValue() throws SQLException {
      try {
         super.preForAll(methodObject25287, this, zeroLengthObjectArray);
         return (Reader)this.postForAll(methodObject25287, (Object)this.delegate.characterStreamValue());
      } catch (SQLException var2) {
         return (Reader)this.postForAll(methodObject25287, this.onErrorForAll(methodObject25287, var2));
      }
   }

   public void setChunkSize(int arg0) {
      super.preForAll(methodObject25299, this, arg0);
      this.delegate.setChunkSize(arg0);
   }

   public int setString(long arg0, String arg1) throws SQLException {
      try {
         super.preForClobWrites(methodObject25270, this, arg0, arg1);
         return (Integer)this.postForAll(methodObject25270, this.delegate.setString(arg0, arg1));
      } catch (SQLException var5) {
         return (Integer)this.postForAll(methodObject25270, this.onErrorForAll(methodObject25270, var5));
      }
   }

   public InputStream getStream() throws SQLException {
      try {
         super.preForAll(methodObject25248, this, zeroLengthObjectArray);
         return (InputStream)this.postForAll(methodObject25248, (Object)this.delegate.getStream());
      } catch (SQLException var2) {
         return (InputStream)this.postForAll(methodObject25248, this.onErrorForAll(methodObject25248, var2));
      }
   }

   public int getChars(long arg0, int arg1, char[] arg2) throws SQLException {
      try {
         super.preForAll(methodObject25279, this, arg0, arg1, arg2);
         return (Integer)this.postForAll(methodObject25279, this.delegate.getChars(arg0, arg1, arg2));
      } catch (SQLException var6) {
         return (Integer)this.postForAll(methodObject25279, this.onErrorForAll(methodObject25279, var6));
      }
   }

   public Time timeValue() throws SQLException {
      try {
         super.preForAll(methodObject25253, this, zeroLengthObjectArray);
         return (Time)this.postForAll(methodObject25253, (Object)this.delegate.timeValue());
      } catch (SQLException var2) {
         return (Time)this.postForAll(methodObject25253, this.onErrorForAll(methodObject25253, var2));
      }
   }

   public long getLength() {
      super.preForAll(methodObject25229, this, zeroLengthObjectArray);
      return (Long)this.postForAll(methodObject25229, this.delegate.getLength());
   }

   public oracle.jdbc.driver.OracleConnection getConnection() throws SQLException {
      try {
         super.preForAll(methodObject25259, this, zeroLengthObjectArray);
         return (oracle.jdbc.driver.OracleConnection)this.postForAll(methodObject25259, (Object)this.delegate.getConnection());
      } catch (SQLException var2) {
         return (oracle.jdbc.driver.OracleConnection)this.postForAll(methodObject25259, this.onErrorForAll(methodObject25259, var2));
      }
   }

   public OracleNClob _getDelegate_() {
      return this.delegate;
   }

   public Object getDelegate() {
      return this.delegate;
   }

   public void setDelegate(Object delegate) {
      this.proxyFactory.updateDelegate(this, this.delegate, delegate);
      this.delegate = (OracleNClob)delegate;
   }

   public Object getCreator() {
      return this.creator;
   }

   static {
      try {
         methodObject25247 = OracleDatumWithConnection.class.getDeclaredMethod("setShareBytes", byte[].class);
         methodObject25295 = OracleClob.class.getDeclaredMethod("getAsciiStream", Long.TYPE);
         methodObject25285 = OracleClob.class.getDeclaredMethod("setLocator", byte[].class);
         methodObject25278 = oracle.jdbc.OracleClob.class.getDeclaredMethod("isTemporary");
         methodObject25273 = oracle.jdbc.OracleClob.class.getDeclaredMethod("close");
         methodObject25291 = OracleClob.class.getDeclaredMethod("getJavaSqlConnection");
         methodObject25230 = OracleDatumWithConnection.class.getDeclaredMethod("booleanValue");
         methodObject25276 = oracle.jdbc.OracleClob.class.getDeclaredMethod("isEmptyLob");
         methodObject25282 = OracleClob.class.getDeclaredMethod("setLength", Long.TYPE);
         methodObject25314 = ACProxyable.class.getDeclaredMethod("setACProxy", Object.class);
         methodObject25255 = OracleDatumWithConnection.class.getDeclaredMethod("timestampValue");
         methodObject25232 = OracleDatumWithConnection.class.getDeclaredMethod("intValue");
         methodObject25258 = OracleDatumWithConnection.class.getDeclaredMethod("setPhysicalConnectionOf", Connection.class);
         methodObject25301 = OracleClob.class.getDeclaredMethod("setPrefetchedData", char[].class, Integer.TYPE);
         methodObject25292 = OracleClob.class.getDeclaredMethod("stringValue");
         methodObject25250 = OracleDatumWithConnection.class.getDeclaredMethod("stringValue", Connection.class);
         methodObject25277 = oracle.jdbc.OracleClob.class.getDeclaredMethod("isSecureFile");
         methodObject25263 = Clob.class.getDeclaredMethod("free");
         methodObject25300 = OracleClob.class.getDeclaredMethod("setPrefetchedData", char[].class);
         methodObject25288 = OracleClob.class.getDeclaredMethod("asciiStreamValue");
         methodObject25272 = Clob.class.getDeclaredMethod("getSubString", Long.TYPE, Integer.TYPE);
         methodObject25307 = OracleClob.class.getDeclaredMethod("getAsciiOutputStream", Long.TYPE);
         methodObject25245 = OracleDatumWithConnection.class.getDeclaredMethod("shareBytes");
         methodObject25235 = OracleDatumWithConnection.class.getDeclaredMethod("doubleValue");
         methodObject25283 = OracleClob.class.getDeclaredMethod("getDBAccess");
         methodObject25265 = Clob.class.getDeclaredMethod("setCharacterStream", Long.TYPE);
         methodObject25274 = oracle.jdbc.OracleClob.class.getDeclaredMethod("open", LargeObjectAccessMode.class);
         methodObject25284 = OracleClob.class.getDeclaredMethod("getLocator");
         methodObject25305 = OracleClob.class.getDeclaredMethod("clearCachedData");
         methodObject25233 = OracleDatumWithConnection.class.getDeclaredMethod("longValue");
         methodObject25293 = OracleClob.class.getDeclaredMethod("canReadBasicLobDataInLocator");
         methodObject25271 = Clob.class.getDeclaredMethod("setString", Long.TYPE, String.class, Integer.TYPE, Integer.TYPE);
         methodObject25256 = OracleDatumWithConnection.class.getDeclaredMethod("timestampValue", Calendar.class);
         methodObject25302 = OracleClob.class.getDeclaredMethod("getPrefetchedData");
         methodObject25280 = OracleClob.class.getDeclaredMethod("trim", Long.TYPE);
         methodObject25260 = Clob.class.getDeclaredMethod("length");
         methodObject25304 = OracleClob.class.getDeclaredMethod("setActivePrefetch", Boolean.TYPE);
         methodObject25238 = OracleDatumWithConnection.class.getDeclaredMethod("getInternalConnection");
         methodObject25313 = OracleClob.class.getDeclaredMethod("putString", Long.TYPE, String.class);
         methodObject25312 = OracleClob.class.getDeclaredMethod("putChars", Long.TYPE, char[].class, Integer.TYPE, Integer.TYPE);
         methodObject25268 = Clob.class.getDeclaredMethod("getCharacterStream");
         methodObject25261 = Clob.class.getDeclaredMethod("position", String.class, Long.TYPE);
         methodObject25281 = OracleClob.class.getDeclaredMethod("isConvertibleTo", Class.class);
         methodObject25236 = OracleDatumWithConnection.class.getDeclaredMethod("getBytes");
         methodObject25254 = OracleDatumWithConnection.class.getDeclaredMethod("timeValue", Calendar.class);
         methodObject25308 = OracleClob.class.getDeclaredMethod("getAsciiOutputStream");
         methodObject25309 = OracleClob.class.getDeclaredMethod("getCharacterOutputStream", Long.TYPE);
         methodObject25303 = OracleClob.class.getDeclaredMethod("getPrefetchedDataSize");
         methodObject25289 = OracleClob.class.getDeclaredMethod("binaryStreamValue");
         methodObject25264 = Clob.class.getDeclaredMethod("setAsciiStream", Long.TYPE);
         methodObject25315 = ACProxyable.class.getDeclaredMethod("getACProxy");
         methodObject25311 = OracleClob.class.getDeclaredMethod("putChars", Long.TYPE, char[].class);
         methodObject25257 = OracleDatumWithConnection.class.getDeclaredMethod("getOracleConnection");
         methodObject25286 = OracleClob.class.getDeclaredMethod("toJdbc");
         methodObject25267 = Clob.class.getDeclaredMethod("getAsciiStream");
         methodObject25294 = OracleClob.class.getDeclaredMethod("getBufferSize");
         methodObject25262 = Clob.class.getDeclaredMethod("position", Clob.class, Long.TYPE);
         methodObject25266 = Clob.class.getDeclaredMethod("truncate", Long.TYPE);
         methodObject25275 = oracle.jdbc.OracleClob.class.getDeclaredMethod("isOpen");
         methodObject25252 = OracleDatumWithConnection.class.getDeclaredMethod("dateValue");
         methodObject25298 = OracleClob.class.getDeclaredMethod("getChunkSize");
         methodObject25246 = OracleDatumWithConnection.class.getDeclaredMethod("setBytes", byte[].class);
         methodObject25251 = OracleDatumWithConnection.class.getDeclaredMethod("bigDecimalValue");
         methodObject25269 = Clob.class.getDeclaredMethod("getCharacterStream", Long.TYPE, Long.TYPE);
         methodObject25290 = OracleClob.class.getDeclaredMethod("makeJdbcArray", Integer.TYPE);
         methodObject25306 = OracleClob.class.getDeclaredMethod("isActivePrefetch");
         methodObject25297 = OracleClob.class.getDeclaredMethod("isNCLOB");
         methodObject25231 = OracleDatumWithConnection.class.getDeclaredMethod("byteValue");
         methodObject25310 = OracleClob.class.getDeclaredMethod("getCharacterOutputStream");
         methodObject25296 = OracleClob.class.getDeclaredMethod("getCharacterStream", Long.TYPE);
         methodObject25234 = OracleDatumWithConnection.class.getDeclaredMethod("floatValue");
         methodObject25287 = OracleClob.class.getDeclaredMethod("characterStreamValue");
         methodObject25299 = OracleClob.class.getDeclaredMethod("setChunkSize", Integer.TYPE);
         methodObject25270 = Clob.class.getDeclaredMethod("setString", Long.TYPE, String.class);
         methodObject25248 = OracleDatumWithConnection.class.getDeclaredMethod("getStream");
         methodObject25279 = OracleClob.class.getDeclaredMethod("getChars", Long.TYPE, Integer.TYPE, char[].class);
         methodObject25253 = OracleDatumWithConnection.class.getDeclaredMethod("timeValue");
         methodObject25229 = OracleDatumWithConnection.class.getDeclaredMethod("getLength");
         methodObject25259 = OracleDatumWithConnection.class.getDeclaredMethod("getConnection");
      } catch (Throwable var1) {
         throw new RuntimeException(var1);
      }
   }

   public oracle$1jdbc$1replay$1driver$1NonTxnReplayableNClob$2oracle$1jdbc$1internal$1OracleNClob$$$Proxy(OracleNClob var1, Object var2, ProxyFactory var3, Map var4) {
      this.delegate = var1;
      this.creator = var2;
      this.proxyFactory = var3;
      this.proxyCache = var4;
   }
}
