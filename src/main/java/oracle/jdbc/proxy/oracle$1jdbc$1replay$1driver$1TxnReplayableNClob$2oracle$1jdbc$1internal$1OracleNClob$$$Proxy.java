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
import oracle.jdbc.replay.driver.TxnReplayableNClob;
import oracle.sql.ClobDBAccess;

public class oracle$1jdbc$1replay$1driver$1TxnReplayableNClob$2oracle$1jdbc$1internal$1OracleNClob$$$Proxy extends TxnReplayableNClob implements OracleNClob, _Proxy_ {
   private OracleNClob delegate;
   private final Object creator;
   private final ProxyFactory proxyFactory;
   private final Map proxyCache;
   private static Object[] zeroLengthObjectArray = new Object[0];
   private static Method methodObject665;
   private static Method methodObject638;
   private static Method methodObject670;
   private static Method methodObject662;
   private static Method methodObject648;
   private static Method methodObject647;
   private static Method methodObject659;
   private static Method methodObject696;
   private static Method methodObject682;
   private static Method methodObject653;
   private static Method methodObject616;
   private static Method methodObject663;
   private static Method methodObject667;
   private static Method methodObject668;
   private static Method methodObject628;
   private static Method methodObject618;
   private static Method methodObject679;
   private static Method methodObject627;
   private static Method methodObject664;
   private static Method methodObject629;
   private static Method methodObject649;
   private static Method methodObject673;
   private static Method methodObject624;
   private static Method methodObject621;
   private static Method methodObject690;
   private static Method methodObject656;
   private static Method methodObject681;
   private static Method methodObject697;
   private static Method methodObject619;
   private static Method methodObject699;
   private static Method methodObject680;
   private static Method methodObject694;
   private static Method methodObject646;
   private static Method methodObject641;
   private static Method methodObject635;
   private static Method methodObject657;
   private static Method methodObject660;
   private static Method methodObject678;
   private static Method methodObject651;
   private static Method methodObject676;
   private static Method methodObject622;
   private static Method methodObject687;
   private static Method methodObject695;
   private static Method methodObject674;
   private static Method methodObject693;
   private static Method methodObject691;
   private static Method methodObject658;
   private static Method methodObject700;
   private static Method methodObject701;
   private static Method methodObject644;
   private static Method methodObject675;
   private static Method methodObject650;
   private static Method methodObject655;
   private static Method methodObject689;
   private static Method methodObject686;
   private static Method methodObject661;
   private static Method methodObject640;
   private static Method methodObject669;
   private static Method methodObject639;
   private static Method methodObject625;
   private static Method methodObject688;
   private static Method methodObject684;
   private static Method methodObject692;
   private static Method methodObject652;
   private static Method methodObject671;
   private static Method methodObject698;
   private static Method methodObject683;
   private static Method methodObject677;
   private static Method methodObject617;
   private static Method methodObject685;
   private static Method methodObject666;
   private static Method methodObject672;
   private static Method methodObject620;
   private static Method methodObject636;
   private static Method methodObject615;
   private static Method methodObject626;
   private static Method methodObject654;
   private static Method methodObject642;
   private static Method methodObject645;

   public int getChars(long arg0, int arg1, char[] arg2) throws SQLException {
      try {
         super.preForAll(methodObject665, this, arg0, arg1, arg2);
         return (Integer)this.postForAll(methodObject665, this.delegate.getChars(arg0, arg1, arg2));
      } catch (SQLException var6) {
         return (Integer)this.postForAll(methodObject665, this.onErrorForAll(methodObject665, var6));
      }
   }

   public String stringValue(Connection arg0) throws SQLException {
      try {
         super.preForAll(methodObject638, this, arg0);
         return (String)this.postForAll(methodObject638, (Object)this.delegate.stringValue(arg0 instanceof _Proxy_ ? (Connection)((_Proxy_)arg0)._getDelegate_() : arg0));
      } catch (SQLException var3) {
         return (String)this.postForAll(methodObject638, this.onErrorForAll(methodObject638, var3));
      }
   }

   public int putChars(long arg0, char[] arg1) throws SQLException {
      try {
         super.preForAll(methodObject670, this, arg0, arg1);
         return (Integer)this.postForAll(methodObject670, this.delegate.putChars(arg0, arg1));
      } catch (SQLException var5) {
         return (Integer)this.postForAll(methodObject670, this.onErrorForAll(methodObject670, var5));
      }
   }

   public boolean isTemporary() throws SQLException {
      try {
         super.preForAll(methodObject662, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject662, this.delegate.isTemporary());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject662, this.onErrorForAll(methodObject662, var2));
      }
   }

   public long position(Clob arg0, long arg1) throws SQLException {
      try {
         super.preForAll(methodObject648, this, arg0, arg1);
         return (Long)this.postForAll(methodObject648, this.delegate.position(arg0 instanceof _Proxy_ ? (Clob)((_Proxy_)arg0)._getDelegate_() : arg0, arg1));
      } catch (SQLException var5) {
         return (Long)this.postForAll(methodObject648, this.onErrorForAll(methodObject648, var5));
      }
   }

   public long position(String arg0, long arg1) throws SQLException {
      try {
         super.preForAll(methodObject647, this, arg0, arg1);
         return (Long)this.postForAll(methodObject647, this.delegate.position(arg0, arg1));
      } catch (SQLException var5) {
         return (Long)this.postForAll(methodObject647, this.onErrorForAll(methodObject647, var5));
      }
   }

   public void close() throws SQLException {
      try {
         super.preForAll(methodObject659, this, zeroLengthObjectArray);
         Method var10001 = methodObject659;
         this.delegate.close();
         this.postForAll(var10001);
      } catch (SQLException var2) {
         this.onErrorVoidForAll(methodObject659, var2);
      }
   }

   public void setActivePrefetch(boolean arg0) {
      super.preForAll(methodObject696, this, arg0);
      Method var10001 = methodObject696;
      this.delegate.setActivePrefetch(arg0);
      this.postForAll(var10001);
   }

   public Connection getJavaSqlConnection() throws SQLException {
      try {
         super.preForAll(methodObject682, this, zeroLengthObjectArray);
         return (Connection)this.postForAll(methodObject682, this.proxyFactory.proxyForCache((Object)this.delegate.getJavaSqlConnection(), this, this.proxyCache, methodObject682));
      } catch (SQLException var2) {
         return (Connection)this.postForAll(methodObject682, this.onErrorForAll(methodObject682, var2));
      }
   }

   public int setString(long arg0, String arg1) throws SQLException {
      try {
         super.preForClobWrites(methodObject653, this, arg0, arg1);
         return (Integer)this.postForAll(methodObject653, this.delegate.setString(arg0, arg1));
      } catch (SQLException var5) {
         return (Integer)this.postForAll(methodObject653, this.onErrorForAll(methodObject653, var5));
      }
   }

   public boolean booleanValue() throws SQLException {
      try {
         super.preForAll(methodObject616, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject616, this.delegate.booleanValue());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject616, this.onErrorForAll(methodObject616, var2));
      }
   }

   public boolean isEmptyLob() throws SQLException {
      try {
         super.preForAll(methodObject663, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject663, this.delegate.isEmptyLob());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject663, this.onErrorForAll(methodObject663, var2));
      }
   }

   public boolean isConvertibleTo(Class arg0) {
      super.preForAll(methodObject667, this, arg0);
      return (Boolean)this.postForAll(methodObject667, this.delegate.isConvertibleTo(arg0));
   }

   public void setLength(long arg0) {
      super.preForAll(methodObject668, this, arg0);
      Method var10001 = methodObject668;
      this.delegate.setLength(arg0);
      this.postForAll(var10001);
   }

   public Timestamp timestampValue() throws SQLException {
      try {
         super.preForAll(methodObject628, this, zeroLengthObjectArray);
         return (Timestamp)this.postForAll(methodObject628, (Object)this.delegate.timestampValue());
      } catch (SQLException var2) {
         return (Timestamp)this.postForAll(methodObject628, this.onErrorForAll(methodObject628, var2));
      }
   }

   public int intValue() throws SQLException {
      try {
         super.preForAll(methodObject618, this, zeroLengthObjectArray);
         return (Integer)this.postForAll(methodObject618, this.delegate.intValue());
      } catch (SQLException var2) {
         return (Integer)this.postForAll(methodObject618, this.onErrorForAll(methodObject618, var2));
      }
   }

   public String stringValue() throws SQLException {
      try {
         super.preForAll(methodObject679, this, zeroLengthObjectArray);
         return (String)this.postForAll(methodObject679, (Object)this.delegate.stringValue());
      } catch (SQLException var2) {
         return (String)this.postForAll(methodObject679, this.onErrorForAll(methodObject679, var2));
      }
   }

   public Time timeValue(Calendar arg0) throws SQLException {
      try {
         super.preForAll(methodObject627, this, arg0);
         return (Time)this.postForAll(methodObject627, (Object)this.delegate.timeValue(arg0));
      } catch (SQLException var3) {
         return (Time)this.postForAll(methodObject627, this.onErrorForAll(methodObject627, var3));
      }
   }

   public boolean isSecureFile() throws SQLException {
      try {
         super.preForAll(methodObject664, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject664, this.delegate.isSecureFile());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject664, this.onErrorForAll(methodObject664, var2));
      }
   }

   public Timestamp timestampValue(Calendar arg0) throws SQLException {
      try {
         super.preForAll(methodObject629, this, arg0);
         return (Timestamp)this.postForAll(methodObject629, (Object)this.delegate.timestampValue(arg0));
      } catch (SQLException var3) {
         return (Timestamp)this.postForAll(methodObject629, this.onErrorForAll(methodObject629, var3));
      }
   }

   public void free() throws SQLException {
      try {
         super.preForAll(methodObject649, this, zeroLengthObjectArray);
         Method var10001 = methodObject649;
         this.delegate.free();
         this.postForAll(var10001);
      } catch (SQLException var2) {
         this.onErrorVoidForAll(methodObject649, var2);
      }
   }

   public InputStream asciiStreamValue() throws SQLException {
      try {
         super.preForAll(methodObject673, this, zeroLengthObjectArray);
         return (InputStream)this.postForAll(methodObject673, (Object)this.delegate.asciiStreamValue());
      } catch (SQLException var2) {
         return (InputStream)this.postForAll(methodObject673, this.onErrorForAll(methodObject673, var2));
      }
   }

   public byte[] shareBytes() {
      super.preForAll(methodObject624, this, zeroLengthObjectArray);
      return (byte[])this.postForAll(methodObject624, (Object)this.delegate.shareBytes());
   }

   public double doubleValue() throws SQLException {
      try {
         super.preForAll(methodObject621, this, zeroLengthObjectArray);
         return (Double)this.postForAll(methodObject621, this.delegate.doubleValue());
      } catch (SQLException var2) {
         return (Double)this.postForAll(methodObject621, this.onErrorForAll(methodObject621, var2));
      }
   }

   public ClobDBAccess getDBAccess() throws SQLException {
      try {
         super.preForAll(methodObject690, this, zeroLengthObjectArray);
         return (ClobDBAccess)this.postForAll(methodObject690, (Object)this.delegate.getDBAccess());
      } catch (SQLException var2) {
         return (ClobDBAccess)this.postForAll(methodObject690, this.onErrorForAll(methodObject690, var2));
      }
   }

   public OutputStream setAsciiStream(long arg0) throws SQLException {
      try {
         super.preForAll(methodObject656, this, arg0);
         return (OutputStream)this.postForAll(methodObject656, (Object)super.setAsciiStream(arg0));
      } catch (SQLException var4) {
         return (OutputStream)this.postForAll(methodObject656, this.onErrorForAll(methodObject656, var4));
      }
   }

   public byte[] getLocator() {
      super.preForAll(methodObject681, this, zeroLengthObjectArray);
      return (byte[])this.postForAll(methodObject681, (Object)this.delegate.getLocator());
   }

   public void clearCachedData() {
      super.preForAll(methodObject697, this, zeroLengthObjectArray);
      Method var10001 = methodObject697;
      this.delegate.clearCachedData();
      this.postForAll(var10001);
   }

   public long longValue() throws SQLException {
      try {
         super.preForAll(methodObject619, this, zeroLengthObjectArray);
         return (Long)this.postForAll(methodObject619, this.delegate.longValue());
      } catch (SQLException var2) {
         return (Long)this.postForAll(methodObject619, this.onErrorForAll(methodObject619, var2));
      }
   }

   public boolean canReadBasicLobDataInLocator() throws SQLException {
      try {
         super.preForAll(methodObject699, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject699, this.delegate.canReadBasicLobDataInLocator());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject699, this.onErrorForAll(methodObject699, var2));
      }
   }

   public void setLocator(byte[] arg0) {
      super.preForAll(methodObject680, this, arg0);
      Method var10001 = methodObject680;
      this.delegate.setLocator(arg0);
      this.postForAll(var10001);
   }

   public char[] getPrefetchedData() {
      super.preForAll(methodObject694, this, zeroLengthObjectArray);
      return (char[])this.postForAll(methodObject694, (Object)this.delegate.getPrefetchedData());
   }

   public long length() throws SQLException {
      try {
         super.preForAll(methodObject646, this, zeroLengthObjectArray);
         return (Long)this.postForAll(methodObject646, this.delegate.length());
      } catch (SQLException var2) {
         return (Long)this.postForAll(methodObject646, this.onErrorForAll(methodObject646, var2));
      }
   }

   public OracleConnection getInternalConnection() throws SQLException {
      try {
         super.preForAll(methodObject641, this, zeroLengthObjectArray);
         return (OracleConnection)this.postForAll(methodObject641, (Object)super.getInternalConnection());
      } catch (SQLException var2) {
         return (OracleConnection)this.postForAll(methodObject641, this.onErrorForAll(methodObject641, var2));
      }
   }

   public void setShareBytes(byte[] arg0) {
      super.preForAll(methodObject635, this, arg0);
      Method var10001 = methodObject635;
      this.delegate.setShareBytes(arg0);
      this.postForAll(var10001);
   }

   public Writer setCharacterStream(long arg0) throws SQLException {
      try {
         super.preForAll(methodObject657, this, arg0);
         return (Writer)this.postForAll(methodObject657, (Object)super.setCharacterStream(arg0));
      } catch (SQLException var4) {
         return (Writer)this.postForAll(methodObject657, this.onErrorForAll(methodObject657, var4));
      }
   }

   public void open(LargeObjectAccessMode arg0) throws SQLException {
      try {
         super.preForAll(methodObject660, this, arg0);
         Method var10001 = methodObject660;
         this.delegate.open(arg0);
         this.postForAll(var10001);
      } catch (SQLException var3) {
         this.onErrorVoidForAll(methodObject660, var3);
      }
   }

   public Reader getCharacterStream(long arg0) throws SQLException {
      try {
         super.preForAll(methodObject678, this, arg0);
         return (Reader)this.postForAll(methodObject678, (Object)super.getCharacterStream(arg0));
      } catch (SQLException var4) {
         return (Reader)this.postForAll(methodObject678, this.onErrorForAll(methodObject678, var4));
      }
   }

   public Reader getCharacterStream() throws SQLException {
      try {
         super.preForAll(methodObject651, this, zeroLengthObjectArray);
         return (Reader)this.postForAll(methodObject651, (Object)super.getCharacterStream());
      } catch (SQLException var2) {
         return (Reader)this.postForAll(methodObject651, this.onErrorForAll(methodObject651, var2));
      }
   }

   public Object makeJdbcArray(int arg0) {
      super.preForAll(methodObject676, this, arg0);
      return this.postForAll(methodObject676, this.proxyFactory.proxyForCache(this.delegate.makeJdbcArray(arg0), this, this.proxyCache, methodObject676));
   }

   public byte[] getBytes() {
      super.preForAll(methodObject622, this, zeroLengthObjectArray);
      return (byte[])this.postForAll(methodObject622, (Object)this.delegate.getBytes());
   }

   public OutputStream getAsciiOutputStream() throws SQLException {
      try {
         super.preForAll(methodObject687, this, zeroLengthObjectArray);
         return (OutputStream)this.postForAll(methodObject687, (Object)super.getAsciiOutputStream());
      } catch (SQLException var2) {
         return (OutputStream)this.postForAll(methodObject687, this.onErrorForAll(methodObject687, var2));
      }
   }

   public int getPrefetchedDataSize() {
      super.preForAll(methodObject695, this, zeroLengthObjectArray);
      return (Integer)this.postForAll(methodObject695, this.delegate.getPrefetchedDataSize());
   }

   public InputStream binaryStreamValue() throws SQLException {
      try {
         super.preForAll(methodObject674, this, zeroLengthObjectArray);
         return (InputStream)this.postForAll(methodObject674, (Object)this.delegate.binaryStreamValue());
      } catch (SQLException var2) {
         return (InputStream)this.postForAll(methodObject674, this.onErrorForAll(methodObject674, var2));
      }
   }

   public void setPrefetchedData(char[] arg0, int arg1) {
      super.preForAll(methodObject693, this, arg0, arg1);
      Method var10001 = methodObject693;
      this.delegate.setPrefetchedData(arg0, arg1);
      this.postForAll(var10001);
   }

   public void setChunkSize(int arg0) {
      super.preForAll(methodObject691, this, arg0);
      Method var10001 = methodObject691;
      this.delegate.setChunkSize(arg0);
      this.postForAll(var10001);
   }

   public void truncate(long arg0) throws SQLException {
      try {
         super.preForClobWrites(methodObject658, this, arg0);
         Method var10001 = methodObject658;
         this.delegate.truncate(arg0);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject658, var4);
      }
   }

   public void setACProxy(Object arg0) {
      super.preForAll(methodObject700, this, arg0);
      Method var10001 = methodObject700;
      this.delegate.setACProxy(arg0 instanceof _Proxy_ ? (Object)((_Proxy_)arg0)._getDelegate_() : arg0);
      this.postForAll(var10001);
   }

   public Object getACProxy() {
      super.preForAll(methodObject701, this, zeroLengthObjectArray);
      return this.postForAll(methodObject701, this.proxyFactory.proxyForCache(this.delegate.getACProxy(), this, this.proxyCache, methodObject701));
   }

   public oracle.jdbc.OracleConnection getOracleConnection() throws SQLException {
      try {
         super.preForAll(methodObject644, this, zeroLengthObjectArray);
         return (oracle.jdbc.OracleConnection)this.postForAll(methodObject644, this.proxyFactory.proxyForCache((Object)this.delegate.getOracleConnection(), this, this.proxyCache, methodObject644));
      } catch (SQLException var2) {
         return (oracle.jdbc.OracleConnection)this.postForAll(methodObject644, this.onErrorForAll(methodObject644, var2));
      }
   }

   public Object toJdbc() throws SQLException {
      try {
         super.preForAll(methodObject675, this, zeroLengthObjectArray);
         return this.postForAll(methodObject675, this.proxyFactory.proxyForCache(this.delegate.toJdbc(), this, this.proxyCache, methodObject675));
      } catch (SQLException var2) {
         return this.postForAll(methodObject675, this.onErrorForAll(methodObject675, var2));
      }
   }

   public InputStream getAsciiStream() throws SQLException {
      try {
         super.preForAll(methodObject650, this, zeroLengthObjectArray);
         return (InputStream)this.postForAll(methodObject650, (Object)super.getAsciiStream());
      } catch (SQLException var2) {
         return (InputStream)this.postForAll(methodObject650, this.onErrorForAll(methodObject650, var2));
      }
   }

   public String getSubString(long arg0, int arg1) throws SQLException {
      try {
         super.preForAll(methodObject655, this, arg0, arg1);
         return (String)this.postForAll(methodObject655, (Object)this.delegate.getSubString(arg0, arg1));
      } catch (SQLException var5) {
         return (String)this.postForAll(methodObject655, this.onErrorForAll(methodObject655, var5));
      }
   }

   public int getBufferSize() throws SQLException {
      try {
         super.preForAll(methodObject689, this, zeroLengthObjectArray);
         return (Integer)this.postForAll(methodObject689, this.delegate.getBufferSize());
      } catch (SQLException var2) {
         return (Integer)this.postForAll(methodObject689, this.onErrorForAll(methodObject689, var2));
      }
   }

   public OutputStream getAsciiOutputStream(long arg0) throws SQLException {
      try {
         super.preForAll(methodObject686, this, arg0);
         return (OutputStream)this.postForAll(methodObject686, (Object)super.getAsciiOutputStream(arg0));
      } catch (SQLException var4) {
         return (OutputStream)this.postForAll(methodObject686, this.onErrorForAll(methodObject686, var4));
      }
   }

   public boolean isOpen() throws SQLException {
      try {
         super.preForAll(methodObject661, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject661, this.delegate.isOpen());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject661, this.onErrorForAll(methodObject661, var2));
      }
   }

   public Date dateValue() throws SQLException {
      try {
         super.preForAll(methodObject640, this, zeroLengthObjectArray);
         return (Date)this.postForAll(methodObject640, (Object)this.delegate.dateValue());
      } catch (SQLException var2) {
         return (Date)this.postForAll(methodObject640, this.onErrorForAll(methodObject640, var2));
      }
   }

   public int getChunkSize() throws SQLException {
      try {
         super.preForAll(methodObject669, this, zeroLengthObjectArray);
         return (Integer)this.postForAll(methodObject669, this.delegate.getChunkSize());
      } catch (SQLException var2) {
         return (Integer)this.postForAll(methodObject669, this.onErrorForAll(methodObject669, var2));
      }
   }

   public BigDecimal bigDecimalValue() throws SQLException {
      try {
         super.preForAll(methodObject639, this, zeroLengthObjectArray);
         return (BigDecimal)this.postForAll(methodObject639, (Object)this.delegate.bigDecimalValue());
      } catch (SQLException var2) {
         return (BigDecimal)this.postForAll(methodObject639, this.onErrorForAll(methodObject639, var2));
      }
   }

   public void setBytes(byte[] arg0) {
      super.preForAll(methodObject625, this, arg0);
      Method var10001 = methodObject625;
      this.delegate.setBytes(arg0);
      this.postForAll(var10001);
   }

   public int putString(long arg0, String arg1) throws SQLException {
      try {
         super.preForAll(methodObject688, this, arg0, arg1);
         return (Integer)this.postForAll(methodObject688, this.delegate.putString(arg0, arg1));
      } catch (SQLException var5) {
         return (Integer)this.postForAll(methodObject688, this.onErrorForAll(methodObject688, var5));
      }
   }

   public Writer getCharacterOutputStream(long arg0) throws SQLException {
      try {
         super.preForAll(methodObject684, this, arg0);
         return (Writer)this.postForAll(methodObject684, (Object)super.getCharacterOutputStream(arg0));
      } catch (SQLException var4) {
         return (Writer)this.postForAll(methodObject684, this.onErrorForAll(methodObject684, var4));
      }
   }

   public void setPrefetchedData(char[] arg0) {
      super.preForAll(methodObject692, this, arg0);
      Method var10001 = methodObject692;
      this.delegate.setPrefetchedData(arg0);
      this.postForAll(var10001);
   }

   public Reader getCharacterStream(long arg0, long arg1) throws SQLException {
      try {
         super.preForAll(methodObject652, this, arg0, arg1);
         return (Reader)this.postForAll(methodObject652, (Object)super.getCharacterStream(arg0, arg1));
      } catch (SQLException var6) {
         return (Reader)this.postForAll(methodObject652, this.onErrorForAll(methodObject652, var6));
      }
   }

   public int putChars(long arg0, char[] arg1, int arg2, int arg3) throws SQLException {
      try {
         super.preForAll(methodObject671, this, arg0, arg1, arg2, arg3);
         return (Integer)this.postForAll(methodObject671, this.delegate.putChars(arg0, arg1, arg2, arg3));
      } catch (SQLException var7) {
         return (Integer)this.postForAll(methodObject671, this.onErrorForAll(methodObject671, var7));
      }
   }

   public boolean isActivePrefetch() {
      super.preForAll(methodObject698, this, zeroLengthObjectArray);
      return (Boolean)this.postForAll(methodObject698, this.delegate.isActivePrefetch());
   }

   public boolean isNCLOB() {
      super.preForAll(methodObject683, this, zeroLengthObjectArray);
      return (Boolean)this.postForAll(methodObject683, this.delegate.isNCLOB());
   }

   public InputStream getAsciiStream(long arg0) throws SQLException {
      try {
         super.preForAll(methodObject677, this, arg0);
         return (InputStream)this.postForAll(methodObject677, (Object)super.getAsciiStream(arg0));
      } catch (SQLException var4) {
         return (InputStream)this.postForAll(methodObject677, this.onErrorForAll(methodObject677, var4));
      }
   }

   public byte byteValue() throws SQLException {
      try {
         super.preForAll(methodObject617, this, zeroLengthObjectArray);
         return (Byte)this.postForAll(methodObject617, this.delegate.byteValue());
      } catch (SQLException var2) {
         return (Byte)this.postForAll(methodObject617, this.onErrorForAll(methodObject617, var2));
      }
   }

   public Writer getCharacterOutputStream() throws SQLException {
      try {
         super.preForAll(methodObject685, this, zeroLengthObjectArray);
         return (Writer)this.postForAll(methodObject685, (Object)super.getCharacterOutputStream());
      } catch (SQLException var2) {
         return (Writer)this.postForAll(methodObject685, this.onErrorForAll(methodObject685, var2));
      }
   }

   public void trim(long arg0) throws SQLException {
      try {
         super.preForAll(methodObject666, this, arg0);
         Method var10001 = methodObject666;
         this.delegate.trim(arg0);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject666, var4);
      }
   }

   public Reader characterStreamValue() throws SQLException {
      try {
         super.preForAll(methodObject672, this, zeroLengthObjectArray);
         return (Reader)this.postForAll(methodObject672, (Object)this.delegate.characterStreamValue());
      } catch (SQLException var2) {
         return (Reader)this.postForAll(methodObject672, this.onErrorForAll(methodObject672, var2));
      }
   }

   public float floatValue() throws SQLException {
      try {
         super.preForAll(methodObject620, this, zeroLengthObjectArray);
         return (Float)this.postForAll(methodObject620, this.delegate.floatValue());
      } catch (SQLException var2) {
         return (Float)this.postForAll(methodObject620, this.onErrorForAll(methodObject620, var2));
      }
   }

   public InputStream getStream() throws SQLException {
      try {
         super.preForAll(methodObject636, this, zeroLengthObjectArray);
         return (InputStream)this.postForAll(methodObject636, (Object)this.delegate.getStream());
      } catch (SQLException var2) {
         return (InputStream)this.postForAll(methodObject636, this.onErrorForAll(methodObject636, var2));
      }
   }

   public long getLength() {
      super.preForAll(methodObject615, this, zeroLengthObjectArray);
      return (Long)this.postForAll(methodObject615, this.delegate.getLength());
   }

   public Time timeValue() throws SQLException {
      try {
         super.preForAll(methodObject626, this, zeroLengthObjectArray);
         return (Time)this.postForAll(methodObject626, (Object)this.delegate.timeValue());
      } catch (SQLException var2) {
         return (Time)this.postForAll(methodObject626, this.onErrorForAll(methodObject626, var2));
      }
   }

   public int setString(long arg0, String arg1, int arg2, int arg3) throws SQLException {
      try {
         super.preForClobWrites(methodObject654, this, arg0, arg1, arg2, arg3);
         return (Integer)this.postForAll(methodObject654, this.delegate.setString(arg0, arg1, arg2, arg3));
      } catch (SQLException var7) {
         return (Integer)this.postForAll(methodObject654, this.onErrorForAll(methodObject654, var7));
      }
   }

   public void setPhysicalConnectionOf(Connection arg0) {
      super.preForAll(methodObject642, this, arg0);
      Method var10001 = methodObject642;
      this.delegate.setPhysicalConnectionOf(arg0 instanceof _Proxy_ ? (Connection)((_Proxy_)arg0)._getDelegate_() : arg0);
      this.postForAll(var10001);
   }

   public oracle.jdbc.driver.OracleConnection getConnection() throws SQLException {
      try {
         super.preForAll(methodObject645, this, zeroLengthObjectArray);
         return (oracle.jdbc.driver.OracleConnection)this.postForAll(methodObject645, (Object)this.delegate.getConnection());
      } catch (SQLException var2) {
         return (oracle.jdbc.driver.OracleConnection)this.postForAll(methodObject645, this.onErrorForAll(methodObject645, var2));
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
         methodObject665 = OracleClob.class.getDeclaredMethod("getChars", Long.TYPE, Integer.TYPE, char[].class);
         methodObject638 = OracleDatumWithConnection.class.getDeclaredMethod("stringValue", Connection.class);
         methodObject670 = OracleClob.class.getDeclaredMethod("putChars", Long.TYPE, char[].class);
         methodObject662 = oracle.jdbc.OracleClob.class.getDeclaredMethod("isTemporary");
         methodObject648 = Clob.class.getDeclaredMethod("position", Clob.class, Long.TYPE);
         methodObject647 = Clob.class.getDeclaredMethod("position", String.class, Long.TYPE);
         methodObject659 = oracle.jdbc.OracleClob.class.getDeclaredMethod("close");
         methodObject696 = OracleClob.class.getDeclaredMethod("setActivePrefetch", Boolean.TYPE);
         methodObject682 = OracleClob.class.getDeclaredMethod("getJavaSqlConnection");
         methodObject653 = Clob.class.getDeclaredMethod("setString", Long.TYPE, String.class);
         methodObject616 = OracleDatumWithConnection.class.getDeclaredMethod("booleanValue");
         methodObject663 = oracle.jdbc.OracleClob.class.getDeclaredMethod("isEmptyLob");
         methodObject667 = OracleClob.class.getDeclaredMethod("isConvertibleTo", Class.class);
         methodObject668 = OracleClob.class.getDeclaredMethod("setLength", Long.TYPE);
         methodObject628 = OracleDatumWithConnection.class.getDeclaredMethod("timestampValue");
         methodObject618 = OracleDatumWithConnection.class.getDeclaredMethod("intValue");
         methodObject679 = OracleClob.class.getDeclaredMethod("stringValue");
         methodObject627 = OracleDatumWithConnection.class.getDeclaredMethod("timeValue", Calendar.class);
         methodObject664 = oracle.jdbc.OracleClob.class.getDeclaredMethod("isSecureFile");
         methodObject629 = OracleDatumWithConnection.class.getDeclaredMethod("timestampValue", Calendar.class);
         methodObject649 = Clob.class.getDeclaredMethod("free");
         methodObject673 = OracleClob.class.getDeclaredMethod("asciiStreamValue");
         methodObject624 = OracleDatumWithConnection.class.getDeclaredMethod("shareBytes");
         methodObject621 = OracleDatumWithConnection.class.getDeclaredMethod("doubleValue");
         methodObject690 = OracleClob.class.getDeclaredMethod("getDBAccess");
         methodObject656 = Clob.class.getDeclaredMethod("setAsciiStream", Long.TYPE);
         methodObject681 = OracleClob.class.getDeclaredMethod("getLocator");
         methodObject697 = OracleClob.class.getDeclaredMethod("clearCachedData");
         methodObject619 = OracleDatumWithConnection.class.getDeclaredMethod("longValue");
         methodObject699 = OracleClob.class.getDeclaredMethod("canReadBasicLobDataInLocator");
         methodObject680 = OracleClob.class.getDeclaredMethod("setLocator", byte[].class);
         methodObject694 = OracleClob.class.getDeclaredMethod("getPrefetchedData");
         methodObject646 = Clob.class.getDeclaredMethod("length");
         methodObject641 = OracleDatumWithConnection.class.getDeclaredMethod("getInternalConnection");
         methodObject635 = OracleDatumWithConnection.class.getDeclaredMethod("setShareBytes", byte[].class);
         methodObject657 = Clob.class.getDeclaredMethod("setCharacterStream", Long.TYPE);
         methodObject660 = oracle.jdbc.OracleClob.class.getDeclaredMethod("open", LargeObjectAccessMode.class);
         methodObject678 = OracleClob.class.getDeclaredMethod("getCharacterStream", Long.TYPE);
         methodObject651 = Clob.class.getDeclaredMethod("getCharacterStream");
         methodObject676 = OracleClob.class.getDeclaredMethod("makeJdbcArray", Integer.TYPE);
         methodObject622 = OracleDatumWithConnection.class.getDeclaredMethod("getBytes");
         methodObject687 = OracleClob.class.getDeclaredMethod("getAsciiOutputStream");
         methodObject695 = OracleClob.class.getDeclaredMethod("getPrefetchedDataSize");
         methodObject674 = OracleClob.class.getDeclaredMethod("binaryStreamValue");
         methodObject693 = OracleClob.class.getDeclaredMethod("setPrefetchedData", char[].class, Integer.TYPE);
         methodObject691 = OracleClob.class.getDeclaredMethod("setChunkSize", Integer.TYPE);
         methodObject658 = Clob.class.getDeclaredMethod("truncate", Long.TYPE);
         methodObject700 = ACProxyable.class.getDeclaredMethod("setACProxy", Object.class);
         methodObject701 = ACProxyable.class.getDeclaredMethod("getACProxy");
         methodObject644 = OracleDatumWithConnection.class.getDeclaredMethod("getOracleConnection");
         methodObject675 = OracleClob.class.getDeclaredMethod("toJdbc");
         methodObject650 = Clob.class.getDeclaredMethod("getAsciiStream");
         methodObject655 = Clob.class.getDeclaredMethod("getSubString", Long.TYPE, Integer.TYPE);
         methodObject689 = OracleClob.class.getDeclaredMethod("getBufferSize");
         methodObject686 = OracleClob.class.getDeclaredMethod("getAsciiOutputStream", Long.TYPE);
         methodObject661 = oracle.jdbc.OracleClob.class.getDeclaredMethod("isOpen");
         methodObject640 = OracleDatumWithConnection.class.getDeclaredMethod("dateValue");
         methodObject669 = OracleClob.class.getDeclaredMethod("getChunkSize");
         methodObject639 = OracleDatumWithConnection.class.getDeclaredMethod("bigDecimalValue");
         methodObject625 = OracleDatumWithConnection.class.getDeclaredMethod("setBytes", byte[].class);
         methodObject688 = OracleClob.class.getDeclaredMethod("putString", Long.TYPE, String.class);
         methodObject684 = OracleClob.class.getDeclaredMethod("getCharacterOutputStream", Long.TYPE);
         methodObject692 = OracleClob.class.getDeclaredMethod("setPrefetchedData", char[].class);
         methodObject652 = Clob.class.getDeclaredMethod("getCharacterStream", Long.TYPE, Long.TYPE);
         methodObject671 = OracleClob.class.getDeclaredMethod("putChars", Long.TYPE, char[].class, Integer.TYPE, Integer.TYPE);
         methodObject698 = OracleClob.class.getDeclaredMethod("isActivePrefetch");
         methodObject683 = OracleClob.class.getDeclaredMethod("isNCLOB");
         methodObject677 = OracleClob.class.getDeclaredMethod("getAsciiStream", Long.TYPE);
         methodObject617 = OracleDatumWithConnection.class.getDeclaredMethod("byteValue");
         methodObject685 = OracleClob.class.getDeclaredMethod("getCharacterOutputStream");
         methodObject666 = OracleClob.class.getDeclaredMethod("trim", Long.TYPE);
         methodObject672 = OracleClob.class.getDeclaredMethod("characterStreamValue");
         methodObject620 = OracleDatumWithConnection.class.getDeclaredMethod("floatValue");
         methodObject636 = OracleDatumWithConnection.class.getDeclaredMethod("getStream");
         methodObject615 = OracleDatumWithConnection.class.getDeclaredMethod("getLength");
         methodObject626 = OracleDatumWithConnection.class.getDeclaredMethod("timeValue");
         methodObject654 = Clob.class.getDeclaredMethod("setString", Long.TYPE, String.class, Integer.TYPE, Integer.TYPE);
         methodObject642 = OracleDatumWithConnection.class.getDeclaredMethod("setPhysicalConnectionOf", Connection.class);
         methodObject645 = OracleDatumWithConnection.class.getDeclaredMethod("getConnection");
      } catch (Throwable var1) {
         throw new RuntimeException(var1);
      }
   }

   public oracle$1jdbc$1replay$1driver$1TxnReplayableNClob$2oracle$1jdbc$1internal$1OracleNClob$$$Proxy(OracleNClob var1, Object var2, ProxyFactory var3, Map var4) {
      this.delegate = var1;
      this.creator = var2;
      this.proxyFactory = var3;
      this.proxyCache = var4;
   }
}
