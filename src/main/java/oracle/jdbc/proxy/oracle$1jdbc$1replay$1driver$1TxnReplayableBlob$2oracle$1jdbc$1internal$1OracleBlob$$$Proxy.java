package oracle.jdbc.proxy;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Map;
import oracle.jdbc.LargeObjectAccessMode;
import oracle.jdbc.internal.ACProxyable;
import oracle.jdbc.internal.OracleBlob;
import oracle.jdbc.internal.OracleConnection;
import oracle.jdbc.internal.OracleDatumWithConnection;
import oracle.jdbc.replay.driver.TxnReplayableBlob;
import oracle.sql.BlobDBAccess;

public class oracle$1jdbc$1replay$1driver$1TxnReplayableBlob$2oracle$1jdbc$1internal$1OracleBlob$$$Proxy extends TxnReplayableBlob implements OracleBlob, _Proxy_ {
   private OracleBlob delegate;
   private final Object creator;
   private final ProxyFactory proxyFactory;
   private final Map proxyCache;
   private static Object[] zeroLengthObjectArray = new Object[0];
   private static Method methodObject2024;
   private static Method methodObject2035;
   private static Method methodObject2042;
   private static Method methodObject2032;
   private static Method methodObject2001;
   private static Method methodObject1993;
   private static Method methodObject2031;
   private static Method methodObject2008;
   private static Method methodObject2037;
   private static Method methodObject1981;
   private static Method methodObject1982;
   private static Method methodObject2019;
   private static Method methodObject2010;
   private static Method methodObject2023;
   private static Method methodObject2018;
   private static Method methodObject2038;
   private static Method methodObject2043;
   private static Method methodObject2020;
   private static Method methodObject1998;
   private static Method methodObject1987;
   private static Method methodObject2015;
   private static Method methodObject2039;
   private static Method methodObject2013;
   private static Method methodObject1995;
   private static Method methodObject1992;
   private static Method methodObject2002;
   private static Method methodObject2011;
   private static Method methodObject2004;
   private static Method methodObject1983;
   private static Method methodObject1991;
   private static Method methodObject1999;
   private static Method methodObject2047;
   private static Method methodObject2045;
   private static Method methodObject2040;
   private static Method methodObject2006;
   private static Method methodObject2027;
   private static Method methodObject2021;
   private static Method methodObject2046;
   private static Method methodObject2033;
   private static Method methodObject2049;
   private static Method methodObject1990;
   private static Method methodObject2044;
   private static Method methodObject2014;
   private static Method methodObject1984;
   private static Method methodObject2000;
   private static Method methodObject1988;
   private static Method methodObject2048;
   private static Method methodObject1996;
   private static Method methodObject2005;
   private static Method methodObject2050;
   private static Method methodObject2051;
   private static Method methodObject2029;
   private static Method methodObject1989;
   private static Method methodObject1994;
   private static Method methodObject2034;
   private static Method methodObject2026;
   private static Method methodObject1985;
   private static Method methodObject2025;
   private static Method methodObject2016;
   private static Method methodObject2036;
   private static Method methodObject1997;
   private static Method methodObject2003;
   private static Method methodObject2009;
   private static Method methodObject1980;
   private static Method methodObject1986;
   private static Method methodObject2012;
   private static Method methodObject2022;
   private static Method methodObject2007;
   private static Method methodObject2017;
   private static Method methodObject2041;
   private static Method methodObject2030;
   private static Method methodObject2028;

   public String stringValue(Connection arg0) throws SQLException {
      try {
         super.preForAll(methodObject2024, this, arg0);
         return (String)this.postForAll(methodObject2024, (Object)this.delegate.stringValue(arg0 instanceof _Proxy_ ? (Connection)((_Proxy_)arg0)._getDelegate_() : arg0));
      } catch (SQLException var3) {
         return (String)this.postForAll(methodObject2024, this.onErrorForAll(methodObject2024, var3));
      }
   }

   public boolean isTemporary() throws SQLException {
      try {
         super.preForAll(methodObject2035, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject2035, this.delegate.isTemporary());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject2035, this.onErrorForAll(methodObject2035, var2));
      }
   }

   public long position(Blob arg0, long arg1) throws SQLException {
      try {
         super.preForAll(methodObject2042, this, arg0, arg1);
         return (Long)this.postForAll(methodObject2042, this.delegate.position(arg0 instanceof _Proxy_ ? (Blob)((_Proxy_)arg0)._getDelegate_() : arg0, arg1));
      } catch (SQLException var5) {
         return (Long)this.postForAll(methodObject2042, this.onErrorForAll(methodObject2042, var5));
      }
   }

   public void close() throws SQLException {
      try {
         super.preForAll(methodObject2032, this, zeroLengthObjectArray);
         Method var10001 = methodObject2032;
         this.delegate.close();
         this.postForAll(var10001);
      } catch (SQLException var2) {
         this.onErrorVoidForAll(methodObject2032, var2);
      }
   }

   public void setActivePrefetch(boolean arg0) {
      super.preForAll(methodObject2001, this, arg0);
      Method var10001 = methodObject2001;
      this.delegate.setActivePrefetch(arg0);
      this.postForAll(var10001);
   }

   public Connection getJavaSqlConnection() throws SQLException {
      try {
         super.preForAll(methodObject1993, this, zeroLengthObjectArray);
         return (Connection)this.postForAll(methodObject1993, this.proxyFactory.proxyForCache((Object)this.delegate.getJavaSqlConnection(), this, this.proxyCache, methodObject1993));
      } catch (SQLException var2) {
         return (Connection)this.postForAll(methodObject1993, this.onErrorForAll(methodObject1993, var2));
      }
   }

   public int getBytes(long arg0, int arg1, byte[] arg2) throws SQLException {
      try {
         super.preForAll(methodObject2031, this, arg0, arg1, arg2);
         return (Integer)this.postForAll(methodObject2031, this.delegate.getBytes(arg0, arg1, arg2));
      } catch (SQLException var6) {
         return (Integer)this.postForAll(methodObject2031, this.onErrorForAll(methodObject2031, var6));
      }
   }

   public boolean booleanValue() throws SQLException {
      try {
         super.preForAll(methodObject2008, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject2008, this.delegate.booleanValue());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject2008, this.onErrorForAll(methodObject2008, var2));
      }
   }

   public boolean isEmptyLob() throws SQLException {
      try {
         super.preForAll(methodObject2037, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject2037, this.delegate.isEmptyLob());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject2037, this.onErrorForAll(methodObject2037, var2));
      }
   }

   public boolean isConvertibleTo(Class arg0) {
      super.preForAll(methodObject1981, this, arg0);
      return (Boolean)this.postForAll(methodObject1981, this.delegate.isConvertibleTo(arg0));
   }

   public void setLength(long arg0) {
      super.preForAll(methodObject1982, this, arg0);
      Method var10001 = methodObject1982;
      this.delegate.setLength(arg0);
      this.postForAll(var10001);
   }

   public Timestamp timestampValue() throws SQLException {
      try {
         super.preForAll(methodObject2019, this, zeroLengthObjectArray);
         return (Timestamp)this.postForAll(methodObject2019, (Object)this.delegate.timestampValue());
      } catch (SQLException var2) {
         return (Timestamp)this.postForAll(methodObject2019, this.onErrorForAll(methodObject2019, var2));
      }
   }

   public int intValue() throws SQLException {
      try {
         super.preForAll(methodObject2010, this, zeroLengthObjectArray);
         return (Integer)this.postForAll(methodObject2010, this.delegate.intValue());
      } catch (SQLException var2) {
         return (Integer)this.postForAll(methodObject2010, this.onErrorForAll(methodObject2010, var2));
      }
   }

   public String stringValue() throws SQLException {
      try {
         super.preForAll(methodObject2023, this, zeroLengthObjectArray);
         return (String)this.postForAll(methodObject2023, (Object)this.delegate.stringValue());
      } catch (SQLException var2) {
         return (String)this.postForAll(methodObject2023, this.onErrorForAll(methodObject2023, var2));
      }
   }

   public Time timeValue(Calendar arg0) throws SQLException {
      try {
         super.preForAll(methodObject2018, this, arg0);
         return (Time)this.postForAll(methodObject2018, (Object)this.delegate.timeValue(arg0));
      } catch (SQLException var3) {
         return (Time)this.postForAll(methodObject2018, this.onErrorForAll(methodObject2018, var3));
      }
   }

   public boolean isSecureFile() throws SQLException {
      try {
         super.preForAll(methodObject2038, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject2038, this.delegate.isSecureFile());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject2038, this.onErrorForAll(methodObject2038, var2));
      }
   }

   public void free() throws SQLException {
      try {
         super.preForFree(methodObject2043, this, zeroLengthObjectArray);
         Method var10001 = methodObject2043;
         this.delegate.free();
         this.postForAll(var10001);
      } catch (SQLException var2) {
         this.onErrorVoidForAll(methodObject2043, var2);
      }
   }

   public Timestamp timestampValue(Calendar arg0) throws SQLException {
      try {
         super.preForAll(methodObject2020, this, arg0);
         return (Timestamp)this.postForAll(methodObject2020, (Object)this.delegate.timestampValue(arg0));
      } catch (SQLException var3) {
         return (Timestamp)this.postForAll(methodObject2020, this.onErrorForAll(methodObject2020, var3));
      }
   }

   public void setPrefetchedData(byte[] arg0, int arg1) {
      super.preForAll(methodObject1998, this, arg0, arg1);
      Method var10001 = methodObject1998;
      this.delegate.setPrefetchedData(arg0, arg1);
      this.postForAll(var10001);
   }

   public InputStream asciiStreamValue() throws SQLException {
      try {
         super.preForAll(methodObject1987, this, zeroLengthObjectArray);
         return (InputStream)this.postForAll(methodObject1987, (Object)this.delegate.asciiStreamValue());
      } catch (SQLException var2) {
         return (InputStream)this.postForAll(methodObject1987, this.onErrorForAll(methodObject1987, var2));
      }
   }

   public byte[] shareBytes() {
      super.preForAll(methodObject2015, this, zeroLengthObjectArray);
      return (byte[])this.postForAll(methodObject2015, (Object)this.delegate.shareBytes());
   }

   public byte[] getBytes(long arg0, int arg1) throws SQLException {
      try {
         super.preForAll(methodObject2039, this, arg0, arg1);
         return (byte[])this.postForAll(methodObject2039, (Object)this.delegate.getBytes(arg0, arg1));
      } catch (SQLException var5) {
         return (byte[])this.postForAll(methodObject2039, this.onErrorForAll(methodObject2039, var5));
      }
   }

   public double doubleValue() throws SQLException {
      try {
         super.preForAll(methodObject2013, this, zeroLengthObjectArray);
         return (Double)this.postForAll(methodObject2013, this.delegate.doubleValue());
      } catch (SQLException var2) {
         return (Double)this.postForAll(methodObject2013, this.onErrorForAll(methodObject2013, var2));
      }
   }

   public BlobDBAccess getDBAccess() throws SQLException {
      try {
         super.preForAll(methodObject1995, this, zeroLengthObjectArray);
         return (BlobDBAccess)this.postForAll(methodObject1995, (Object)this.delegate.getDBAccess());
      } catch (SQLException var2) {
         return (BlobDBAccess)this.postForAll(methodObject1995, this.onErrorForAll(methodObject1995, var2));
      }
   }

   public byte[] getLocator() {
      super.preForAll(methodObject1992, this, zeroLengthObjectArray);
      return (byte[])this.postForAll(methodObject1992, (Object)this.delegate.getLocator());
   }

   public void clearCachedData() {
      super.preForAll(methodObject2002, this, zeroLengthObjectArray);
      Method var10001 = methodObject2002;
      this.delegate.clearCachedData();
      this.postForAll(var10001);
   }

   public long longValue() throws SQLException {
      try {
         super.preForAll(methodObject2011, this, zeroLengthObjectArray);
         return (Long)this.postForAll(methodObject2011, this.delegate.longValue());
      } catch (SQLException var2) {
         return (Long)this.postForAll(methodObject2011, this.onErrorForAll(methodObject2011, var2));
      }
   }

   public boolean canReadBasicLobDataInLocator() throws SQLException {
      try {
         super.preForAll(methodObject2004, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject2004, this.delegate.canReadBasicLobDataInLocator());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject2004, this.onErrorForAll(methodObject2004, var2));
      }
   }

   public int putBytes(long arg0, byte[] arg1) throws SQLException {
      try {
         super.preForAll(methodObject1983, this, arg0, arg1);
         return (Integer)this.postForAll(methodObject1983, this.delegate.putBytes(arg0, arg1));
      } catch (SQLException var5) {
         return (Integer)this.postForAll(methodObject1983, this.onErrorForAll(methodObject1983, var5));
      }
   }

   public void setLocator(byte[] arg0) {
      super.preForAll(methodObject1991, this, arg0);
      Method var10001 = methodObject1991;
      this.delegate.setLocator(arg0);
      this.postForAll(var10001);
   }

   public byte[] getPrefetchedData() {
      super.preForAll(methodObject1999, this, zeroLengthObjectArray);
      return (byte[])this.postForAll(methodObject1999, (Object)this.delegate.getPrefetchedData());
   }

   public InputStream getBinaryStream(long arg0, long arg1) throws SQLException {
      try {
         super.preForAll(methodObject2047, this, arg0, arg1);
         return (InputStream)this.postForAll(methodObject2047, (Object)super.getBinaryStream(arg0, arg1));
      } catch (SQLException var6) {
         return (InputStream)this.postForAll(methodObject2047, this.onErrorForAll(methodObject2047, var6));
      }
   }

   public int setBytes(long arg0, byte[] arg1, int arg2, int arg3) throws SQLException {
      try {
         super.preForBlobWrites(methodObject2045, this, arg0, arg1, arg2, arg3);
         return (Integer)this.postForAll(methodObject2045, this.delegate.setBytes(arg0, arg1, arg2, arg3));
      } catch (SQLException var7) {
         return (Integer)this.postForAll(methodObject2045, this.onErrorForAll(methodObject2045, var7));
      }
   }

   public long length() throws SQLException {
      try {
         super.preForAll(methodObject2040, this, zeroLengthObjectArray);
         return (Long)this.postForAll(methodObject2040, this.delegate.length());
      } catch (SQLException var2) {
         return (Long)this.postForAll(methodObject2040, this.onErrorForAll(methodObject2040, var2));
      }
   }

   public OutputStream getBinaryOutputStream(long arg0) throws SQLException {
      try {
         super.preForAll(methodObject2006, this, arg0);
         return (OutputStream)this.postForAll(methodObject2006, (Object)super.getBinaryOutputStream(arg0));
      } catch (SQLException var4) {
         return (OutputStream)this.postForAll(methodObject2006, this.onErrorForAll(methodObject2006, var4));
      }
   }

   public OracleConnection getInternalConnection() throws SQLException {
      try {
         super.preForAll(methodObject2027, this, zeroLengthObjectArray);
         return (OracleConnection)this.postForAll(methodObject2027, (Object)super.getInternalConnection());
      } catch (SQLException var2) {
         return (OracleConnection)this.postForAll(methodObject2027, this.onErrorForAll(methodObject2027, var2));
      }
   }

   public void setShareBytes(byte[] arg0) {
      super.preForAll(methodObject2021, this, arg0);
      Method var10001 = methodObject2021;
      this.delegate.setShareBytes(arg0);
      this.postForAll(var10001);
   }

   public InputStream getBinaryStream() throws SQLException {
      try {
         super.preForAll(methodObject2046, this, zeroLengthObjectArray);
         return (InputStream)this.postForAll(methodObject2046, (Object)super.getBinaryStream());
      } catch (SQLException var2) {
         return (InputStream)this.postForAll(methodObject2046, this.onErrorForAll(methodObject2046, var2));
      }
   }

   public void open(LargeObjectAccessMode arg0) throws SQLException {
      try {
         super.preForAll(methodObject2033, this, arg0);
         Method var10001 = methodObject2033;
         this.delegate.open(arg0);
         this.postForAll(var10001);
      } catch (SQLException var3) {
         this.onErrorVoidForAll(methodObject2033, var3);
      }
   }

   public OutputStream setBinaryStream(long arg0) throws SQLException {
      try {
         super.preForAll(methodObject2049, this, arg0);
         return (OutputStream)this.postForAll(methodObject2049, (Object)super.setBinaryStream(arg0));
      } catch (SQLException var4) {
         return (OutputStream)this.postForAll(methodObject2049, this.onErrorForAll(methodObject2049, var4));
      }
   }

   public Object makeJdbcArray(int arg0) {
      super.preForAll(methodObject1990, this, arg0);
      return this.postForAll(methodObject1990, this.proxyFactory.proxyForCache(this.delegate.makeJdbcArray(arg0), this, this.proxyCache, methodObject1990));
   }

   public int setBytes(long arg0, byte[] arg1) throws SQLException {
      try {
         super.preForBlobWrites(methodObject2044, this, arg0, arg1);
         return (Integer)this.postForAll(methodObject2044, this.delegate.setBytes(arg0, arg1));
      } catch (SQLException var5) {
         return (Integer)this.postForAll(methodObject2044, this.onErrorForAll(methodObject2044, var5));
      }
   }

   public byte[] getBytes() {
      super.preForAll(methodObject2014, this, zeroLengthObjectArray);
      return (byte[])this.postForAll(methodObject2014, (Object)this.delegate.getBytes());
   }

   public int putBytes(long arg0, byte[] arg1, int arg2) throws SQLException {
      try {
         super.preForAll(methodObject1984, this, arg0, arg1, arg2);
         return (Integer)this.postForAll(methodObject1984, this.delegate.putBytes(arg0, arg1, arg2));
      } catch (SQLException var6) {
         return (Integer)this.postForAll(methodObject1984, this.onErrorForAll(methodObject1984, var6));
      }
   }

   public int getPrefetchedDataSize() {
      super.preForAll(methodObject2000, this, zeroLengthObjectArray);
      return (Integer)this.postForAll(methodObject2000, this.delegate.getPrefetchedDataSize());
   }

   public InputStream binaryStreamValue() throws SQLException {
      try {
         super.preForAll(methodObject1988, this, zeroLengthObjectArray);
         return (InputStream)this.postForAll(methodObject1988, (Object)this.delegate.binaryStreamValue());
      } catch (SQLException var2) {
         return (InputStream)this.postForAll(methodObject1988, this.onErrorForAll(methodObject1988, var2));
      }
   }

   public void truncate(long arg0) throws SQLException {
      try {
         super.preForBlobWrites(methodObject2048, this, arg0);
         Method var10001 = methodObject2048;
         this.delegate.truncate(arg0);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject2048, var4);
      }
   }

   public void setChunkSize(int arg0) {
      super.preForAll(methodObject1996, this, arg0);
      Method var10001 = methodObject1996;
      this.delegate.setChunkSize(arg0);
      this.postForAll(var10001);
   }

   public OutputStream getBinaryOutputStream() throws SQLException {
      try {
         super.preForAll(methodObject2005, this, zeroLengthObjectArray);
         return (OutputStream)this.postForAll(methodObject2005, (Object)super.getBinaryOutputStream());
      } catch (SQLException var2) {
         return (OutputStream)this.postForAll(methodObject2005, this.onErrorForAll(methodObject2005, var2));
      }
   }

   public void setACProxy(Object arg0) {
      super.preForAll(methodObject2050, this, arg0);
      Method var10001 = methodObject2050;
      this.delegate.setACProxy(arg0 instanceof _Proxy_ ? (Object)((_Proxy_)arg0)._getDelegate_() : arg0);
      this.postForAll(var10001);
   }

   public Object getACProxy() {
      super.preForAll(methodObject2051, this, zeroLengthObjectArray);
      return this.postForAll(methodObject2051, this.proxyFactory.proxyForCache(this.delegate.getACProxy(), this, this.proxyCache, methodObject2051));
   }

   public oracle.jdbc.OracleConnection getOracleConnection() throws SQLException {
      try {
         super.preForAll(methodObject2029, this, zeroLengthObjectArray);
         return (oracle.jdbc.OracleConnection)this.postForAll(methodObject2029, this.proxyFactory.proxyForCache((Object)this.delegate.getOracleConnection(), this, this.proxyCache, methodObject2029));
      } catch (SQLException var2) {
         return (oracle.jdbc.OracleConnection)this.postForAll(methodObject2029, this.onErrorForAll(methodObject2029, var2));
      }
   }

   public Object toJdbc() throws SQLException {
      try {
         super.preForAll(methodObject1989, this, zeroLengthObjectArray);
         return this.postForAll(methodObject1989, this.proxyFactory.proxyForCache(this.delegate.toJdbc(), this, this.proxyCache, methodObject1989));
      } catch (SQLException var2) {
         return this.postForAll(methodObject1989, this.onErrorForAll(methodObject1989, var2));
      }
   }

   public int getBufferSize() throws SQLException {
      try {
         super.preForAll(methodObject1994, this, zeroLengthObjectArray);
         return (Integer)this.postForAll(methodObject1994, this.delegate.getBufferSize());
      } catch (SQLException var2) {
         return (Integer)this.postForAll(methodObject1994, this.onErrorForAll(methodObject1994, var2));
      }
   }

   public boolean isOpen() throws SQLException {
      try {
         super.preForAll(methodObject2034, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject2034, this.delegate.isOpen());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject2034, this.onErrorForAll(methodObject2034, var2));
      }
   }

   public Date dateValue() throws SQLException {
      try {
         super.preForAll(methodObject2026, this, zeroLengthObjectArray);
         return (Date)this.postForAll(methodObject2026, (Object)this.delegate.dateValue());
      } catch (SQLException var2) {
         return (Date)this.postForAll(methodObject2026, this.onErrorForAll(methodObject2026, var2));
      }
   }

   public int getChunkSize() throws SQLException {
      try {
         super.preForAll(methodObject1985, this, zeroLengthObjectArray);
         return (Integer)this.postForAll(methodObject1985, this.delegate.getChunkSize());
      } catch (SQLException var2) {
         return (Integer)this.postForAll(methodObject1985, this.onErrorForAll(methodObject1985, var2));
      }
   }

   public BigDecimal bigDecimalValue() throws SQLException {
      try {
         super.preForAll(methodObject2025, this, zeroLengthObjectArray);
         return (BigDecimal)this.postForAll(methodObject2025, (Object)this.delegate.bigDecimalValue());
      } catch (SQLException var2) {
         return (BigDecimal)this.postForAll(methodObject2025, this.onErrorForAll(methodObject2025, var2));
      }
   }

   public void setBytes(byte[] arg0) {
      super.preForAll(methodObject2016, this, arg0);
      Method var10001 = methodObject2016;
      this.delegate.setBytes(arg0);
      this.postForAll(var10001);
   }

   public InputStream getBinaryStream(long arg0) throws SQLException {
      try {
         super.preForAll(methodObject2036, this, arg0);
         return (InputStream)this.postForAll(methodObject2036, (Object)super.getBinaryStream(arg0));
      } catch (SQLException var4) {
         return (InputStream)this.postForAll(methodObject2036, this.onErrorForAll(methodObject2036, var4));
      }
   }

   public void setPrefetchedData(byte[] arg0) {
      super.preForAll(methodObject1997, this, arg0);
      Method var10001 = methodObject1997;
      this.delegate.setPrefetchedData(arg0);
      this.postForAll(var10001);
   }

   public boolean isActivePrefetch() {
      super.preForAll(methodObject2003, this, zeroLengthObjectArray);
      return (Boolean)this.postForAll(methodObject2003, this.delegate.isActivePrefetch());
   }

   public byte byteValue() throws SQLException {
      try {
         super.preForAll(methodObject2009, this, zeroLengthObjectArray);
         return (Byte)this.postForAll(methodObject2009, this.delegate.byteValue());
      } catch (SQLException var2) {
         return (Byte)this.postForAll(methodObject2009, this.onErrorForAll(methodObject2009, var2));
      }
   }

   public void trim(long arg0) throws SQLException {
      try {
         super.preForAll(methodObject1980, this, arg0);
         Method var10001 = methodObject1980;
         this.delegate.trim(arg0);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject1980, var4);
      }
   }

   public Reader characterStreamValue() throws SQLException {
      try {
         super.preForAll(methodObject1986, this, zeroLengthObjectArray);
         return (Reader)this.postForAll(methodObject1986, (Object)this.delegate.characterStreamValue());
      } catch (SQLException var2) {
         return (Reader)this.postForAll(methodObject1986, this.onErrorForAll(methodObject1986, var2));
      }
   }

   public float floatValue() throws SQLException {
      try {
         super.preForAll(methodObject2012, this, zeroLengthObjectArray);
         return (Float)this.postForAll(methodObject2012, this.delegate.floatValue());
      } catch (SQLException var2) {
         return (Float)this.postForAll(methodObject2012, this.onErrorForAll(methodObject2012, var2));
      }
   }

   public InputStream getStream() throws SQLException {
      try {
         super.preForAll(methodObject2022, this, zeroLengthObjectArray);
         return (InputStream)this.postForAll(methodObject2022, (Object)this.delegate.getStream());
      } catch (SQLException var2) {
         return (InputStream)this.postForAll(methodObject2022, this.onErrorForAll(methodObject2022, var2));
      }
   }

   public long getLength() {
      super.preForAll(methodObject2007, this, zeroLengthObjectArray);
      return (Long)this.postForAll(methodObject2007, this.delegate.getLength());
   }

   public Time timeValue() throws SQLException {
      try {
         super.preForAll(methodObject2017, this, zeroLengthObjectArray);
         return (Time)this.postForAll(methodObject2017, (Object)this.delegate.timeValue());
      } catch (SQLException var2) {
         return (Time)this.postForAll(methodObject2017, this.onErrorForAll(methodObject2017, var2));
      }
   }

   public long position(byte[] arg0, long arg1) throws SQLException {
      try {
         super.preForAll(methodObject2041, this, arg0, arg1);
         return (Long)this.postForAll(methodObject2041, this.delegate.position(arg0, arg1));
      } catch (SQLException var5) {
         return (Long)this.postForAll(methodObject2041, this.onErrorForAll(methodObject2041, var5));
      }
   }

   public oracle.jdbc.driver.OracleConnection getConnection() throws SQLException {
      try {
         super.preForAll(methodObject2030, this, zeroLengthObjectArray);
         return (oracle.jdbc.driver.OracleConnection)this.postForAll(methodObject2030, (Object)this.delegate.getConnection());
      } catch (SQLException var2) {
         return (oracle.jdbc.driver.OracleConnection)this.postForAll(methodObject2030, this.onErrorForAll(methodObject2030, var2));
      }
   }

   public void setPhysicalConnectionOf(Connection arg0) {
      super.preForAll(methodObject2028, this, arg0);
      Method var10001 = methodObject2028;
      this.delegate.setPhysicalConnectionOf(arg0 instanceof _Proxy_ ? (Connection)((_Proxy_)arg0)._getDelegate_() : arg0);
      this.postForAll(var10001);
   }

   public OracleBlob _getDelegate_() {
      return this.delegate;
   }

   public Object getDelegate() {
      return this.delegate;
   }

   public void setDelegate(Object delegate) {
      this.proxyFactory.updateDelegate(this, this.delegate, delegate);
      this.delegate = (OracleBlob)delegate;
   }

   public Object getCreator() {
      return this.creator;
   }

   static {
      try {
         methodObject2024 = OracleDatumWithConnection.class.getDeclaredMethod("stringValue", Connection.class);
         methodObject2035 = oracle.jdbc.OracleBlob.class.getDeclaredMethod("isTemporary");
         methodObject2042 = Blob.class.getDeclaredMethod("position", Blob.class, Long.TYPE);
         methodObject2032 = oracle.jdbc.OracleBlob.class.getDeclaredMethod("close");
         methodObject2001 = OracleBlob.class.getDeclaredMethod("setActivePrefetch", Boolean.TYPE);
         methodObject1993 = OracleBlob.class.getDeclaredMethod("getJavaSqlConnection");
         methodObject2031 = oracle.jdbc.OracleBlob.class.getDeclaredMethod("getBytes", Long.TYPE, Integer.TYPE, byte[].class);
         methodObject2008 = OracleDatumWithConnection.class.getDeclaredMethod("booleanValue");
         methodObject2037 = oracle.jdbc.OracleBlob.class.getDeclaredMethod("isEmptyLob");
         methodObject1981 = OracleBlob.class.getDeclaredMethod("isConvertibleTo", Class.class);
         methodObject1982 = OracleBlob.class.getDeclaredMethod("setLength", Long.TYPE);
         methodObject2019 = OracleDatumWithConnection.class.getDeclaredMethod("timestampValue");
         methodObject2010 = OracleDatumWithConnection.class.getDeclaredMethod("intValue");
         methodObject2023 = OracleDatumWithConnection.class.getDeclaredMethod("stringValue");
         methodObject2018 = OracleDatumWithConnection.class.getDeclaredMethod("timeValue", Calendar.class);
         methodObject2038 = oracle.jdbc.OracleBlob.class.getDeclaredMethod("isSecureFile");
         methodObject2043 = Blob.class.getDeclaredMethod("free");
         methodObject2020 = OracleDatumWithConnection.class.getDeclaredMethod("timestampValue", Calendar.class);
         methodObject1998 = OracleBlob.class.getDeclaredMethod("setPrefetchedData", byte[].class, Integer.TYPE);
         methodObject1987 = OracleBlob.class.getDeclaredMethod("asciiStreamValue");
         methodObject2015 = OracleDatumWithConnection.class.getDeclaredMethod("shareBytes");
         methodObject2039 = Blob.class.getDeclaredMethod("getBytes", Long.TYPE, Integer.TYPE);
         methodObject2013 = OracleDatumWithConnection.class.getDeclaredMethod("doubleValue");
         methodObject1995 = OracleBlob.class.getDeclaredMethod("getDBAccess");
         methodObject1992 = OracleBlob.class.getDeclaredMethod("getLocator");
         methodObject2002 = OracleBlob.class.getDeclaredMethod("clearCachedData");
         methodObject2011 = OracleDatumWithConnection.class.getDeclaredMethod("longValue");
         methodObject2004 = OracleBlob.class.getDeclaredMethod("canReadBasicLobDataInLocator");
         methodObject1983 = OracleBlob.class.getDeclaredMethod("putBytes", Long.TYPE, byte[].class);
         methodObject1991 = OracleBlob.class.getDeclaredMethod("setLocator", byte[].class);
         methodObject1999 = OracleBlob.class.getDeclaredMethod("getPrefetchedData");
         methodObject2047 = Blob.class.getDeclaredMethod("getBinaryStream", Long.TYPE, Long.TYPE);
         methodObject2045 = Blob.class.getDeclaredMethod("setBytes", Long.TYPE, byte[].class, Integer.TYPE, Integer.TYPE);
         methodObject2040 = Blob.class.getDeclaredMethod("length");
         methodObject2006 = OracleBlob.class.getDeclaredMethod("getBinaryOutputStream", Long.TYPE);
         methodObject2027 = OracleDatumWithConnection.class.getDeclaredMethod("getInternalConnection");
         methodObject2021 = OracleDatumWithConnection.class.getDeclaredMethod("setShareBytes", byte[].class);
         methodObject2046 = Blob.class.getDeclaredMethod("getBinaryStream");
         methodObject2033 = oracle.jdbc.OracleBlob.class.getDeclaredMethod("open", LargeObjectAccessMode.class);
         methodObject2049 = Blob.class.getDeclaredMethod("setBinaryStream", Long.TYPE);
         methodObject1990 = OracleBlob.class.getDeclaredMethod("makeJdbcArray", Integer.TYPE);
         methodObject2044 = Blob.class.getDeclaredMethod("setBytes", Long.TYPE, byte[].class);
         methodObject2014 = OracleDatumWithConnection.class.getDeclaredMethod("getBytes");
         methodObject1984 = OracleBlob.class.getDeclaredMethod("putBytes", Long.TYPE, byte[].class, Integer.TYPE);
         methodObject2000 = OracleBlob.class.getDeclaredMethod("getPrefetchedDataSize");
         methodObject1988 = OracleBlob.class.getDeclaredMethod("binaryStreamValue");
         methodObject2048 = Blob.class.getDeclaredMethod("truncate", Long.TYPE);
         methodObject1996 = OracleBlob.class.getDeclaredMethod("setChunkSize", Integer.TYPE);
         methodObject2005 = OracleBlob.class.getDeclaredMethod("getBinaryOutputStream");
         methodObject2050 = ACProxyable.class.getDeclaredMethod("setACProxy", Object.class);
         methodObject2051 = ACProxyable.class.getDeclaredMethod("getACProxy");
         methodObject2029 = OracleDatumWithConnection.class.getDeclaredMethod("getOracleConnection");
         methodObject1989 = OracleBlob.class.getDeclaredMethod("toJdbc");
         methodObject1994 = OracleBlob.class.getDeclaredMethod("getBufferSize");
         methodObject2034 = oracle.jdbc.OracleBlob.class.getDeclaredMethod("isOpen");
         methodObject2026 = OracleDatumWithConnection.class.getDeclaredMethod("dateValue");
         methodObject1985 = OracleBlob.class.getDeclaredMethod("getChunkSize");
         methodObject2025 = OracleDatumWithConnection.class.getDeclaredMethod("bigDecimalValue");
         methodObject2016 = OracleDatumWithConnection.class.getDeclaredMethod("setBytes", byte[].class);
         methodObject2036 = oracle.jdbc.OracleBlob.class.getDeclaredMethod("getBinaryStream", Long.TYPE);
         methodObject1997 = OracleBlob.class.getDeclaredMethod("setPrefetchedData", byte[].class);
         methodObject2003 = OracleBlob.class.getDeclaredMethod("isActivePrefetch");
         methodObject2009 = OracleDatumWithConnection.class.getDeclaredMethod("byteValue");
         methodObject1980 = OracleBlob.class.getDeclaredMethod("trim", Long.TYPE);
         methodObject1986 = OracleBlob.class.getDeclaredMethod("characterStreamValue");
         methodObject2012 = OracleDatumWithConnection.class.getDeclaredMethod("floatValue");
         methodObject2022 = OracleDatumWithConnection.class.getDeclaredMethod("getStream");
         methodObject2007 = OracleDatumWithConnection.class.getDeclaredMethod("getLength");
         methodObject2017 = OracleDatumWithConnection.class.getDeclaredMethod("timeValue");
         methodObject2041 = Blob.class.getDeclaredMethod("position", byte[].class, Long.TYPE);
         methodObject2030 = OracleDatumWithConnection.class.getDeclaredMethod("getConnection");
         methodObject2028 = OracleDatumWithConnection.class.getDeclaredMethod("setPhysicalConnectionOf", Connection.class);
      } catch (Throwable var1) {
         throw new RuntimeException(var1);
      }
   }

   public oracle$1jdbc$1replay$1driver$1TxnReplayableBlob$2oracle$1jdbc$1internal$1OracleBlob$$$Proxy(OracleBlob var1, Object var2, ProxyFactory var3, Map var4) {
      this.delegate = var1;
      this.creator = var2;
      this.proxyFactory = var3;
      this.proxyCache = var4;
   }
}
