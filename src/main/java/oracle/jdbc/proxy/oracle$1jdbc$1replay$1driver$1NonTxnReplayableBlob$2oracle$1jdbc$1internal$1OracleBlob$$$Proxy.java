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
import oracle.jdbc.replay.driver.NonTxnReplayableBlob;
import oracle.sql.BlobDBAccess;

public abstract class oracle$1jdbc$1replay$1driver$1NonTxnReplayableBlob$2oracle$1jdbc$1internal$1OracleBlob$$$Proxy extends NonTxnReplayableBlob implements OracleBlob, _Proxy_ {
   private OracleBlob delegate;
   private final Object creator;
   private final ProxyFactory proxyFactory;
   private final Map proxyCache;
   private static Object[] zeroLengthObjectArray = new Object[0];
   private static Method methodObject30199;
   private static Method methodObject30170;
   private static Method methodObject30137;
   private static Method methodObject30190;
   private static Method methodObject30184;
   private static Method methodObject30143;
   private static Method methodObject30160;
   private static Method methodObject30188;
   private static Method methodObject30134;
   private static Method methodObject30152;
   private static Method methodObject30202;
   private static Method methodObject30178;
   private static Method methodObject30181;
   private static Method methodObject30162;
   private static Method methodObject30172;
   private static Method methodObject30191;
   private static Method methodObject30153;
   private static Method methodObject30173;
   private static Method methodObject30193;
   private static Method methodObject30189;
   private static Method methodObject30195;
   private static Method methodObject30140;
   private static Method methodObject30194;
   private static Method methodObject30168;
   private static Method methodObject30165;
   private static Method methodObject30185;
   private static Method methodObject30135;
   private static Method methodObject30136;
   private static Method methodObject30157;
   private static Method methodObject30187;
   private static Method methodObject30163;
   private static Method methodObject30146;
   private static Method methodObject30198;
   private static Method methodObject30196;
   private static Method methodObject30183;
   private static Method methodObject30179;
   private static Method methodObject30154;
   private static Method methodObject30132;
   private static Method methodObject30192;
   private static Method methodObject30200;
   private static Method methodObject30156;
   private static Method methodObject30167;
   private static Method methodObject30197;
   private static Method methodObject30145;
   private static Method methodObject30149;
   private static Method methodObject30133;
   private static Method methodObject30166;
   private static Method methodObject30177;
   private static Method methodObject30155;
   private static Method methodObject30141;
   private static Method methodObject30144;
   private static Method methodObject30203;
   private static Method methodObject30180;
   private static Method methodObject30148;
   private static Method methodObject30138;
   private static Method methodObject30147;
   private static Method methodObject30201;
   private static Method methodObject30186;
   private static Method methodObject30175;
   private static Method methodObject30150;
   private static Method methodObject30169;
   private static Method methodObject30174;
   private static Method methodObject30142;
   private static Method methodObject30158;
   private static Method methodObject30161;
   private static Method methodObject30139;
   private static Method methodObject30164;
   private static Method methodObject30151;
   private static Method methodObject30171;
   private static Method methodObject30159;
   private static Method methodObject30176;
   private static Method methodObject30182;

   public int setBytes(long arg0, byte[] arg1) throws SQLException {
      try {
         super.preForBlobWrites(methodObject30199, this, arg0, arg1);
         return (Integer)this.postForAll(methodObject30199, this.delegate.setBytes(arg0, arg1));
      } catch (SQLException var5) {
         return (Integer)this.postForAll(methodObject30199, this.onErrorForAll(methodObject30199, var5));
      }
   }

   public void setShareBytes(byte[] arg0) {
      super.preForAll(methodObject30170, this, arg0);
      this.delegate.setShareBytes(arg0);
   }

   public void setLocator(byte[] arg0) {
      super.preForAll(methodObject30137, this, arg0);
      this.delegate.setLocator(arg0);
   }

   public boolean isTemporary() throws SQLException {
      try {
         super.preForAll(methodObject30190, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject30190, this.delegate.isTemporary());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject30190, this.onErrorForAll(methodObject30190, var2));
      }
   }

   public void close() throws SQLException {
      try {
         super.preForAll(methodObject30184, this, zeroLengthObjectArray);
         this.delegate.close();
      } catch (SQLException var2) {
         this.onErrorVoidForAll(methodObject30184, var2);
      }
   }

   public Connection getJavaSqlConnection() throws SQLException {
      try {
         super.preForAll(methodObject30143, this, zeroLengthObjectArray);
         return (Connection)this.postForAll(methodObject30143, this.proxyFactory.proxyForCache((Object)this.delegate.getJavaSqlConnection(), this, this.proxyCache, methodObject30143));
      } catch (SQLException var2) {
         return (Connection)this.postForAll(methodObject30143, this.onErrorForAll(methodObject30143, var2));
      }
   }

   public boolean booleanValue() throws SQLException {
      try {
         super.preForAll(methodObject30160, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject30160, this.delegate.booleanValue());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject30160, this.onErrorForAll(methodObject30160, var2));
      }
   }

   public boolean isEmptyLob() throws SQLException {
      try {
         super.preForAll(methodObject30188, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject30188, this.delegate.isEmptyLob());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject30188, this.onErrorForAll(methodObject30188, var2));
      }
   }

   public void setLength(long arg0) {
      super.preForAll(methodObject30134, this, arg0);
      this.delegate.setLength(arg0);
   }

   public void setPrefetchedData(byte[] arg0) {
      super.preForAll(methodObject30152, this, arg0);
      this.delegate.setPrefetchedData(arg0);
   }

   public void setACProxy(Object arg0) {
      super.preForAll(methodObject30202, this, arg0);
      this.delegate.setACProxy(arg0 instanceof _Proxy_ ? (Object)((_Proxy_)arg0)._getDelegate_() : arg0);
   }

   public Timestamp timestampValue() throws SQLException {
      try {
         super.preForAll(methodObject30178, this, zeroLengthObjectArray);
         return (Timestamp)this.postForAll(methodObject30178, (Object)this.delegate.timestampValue());
      } catch (SQLException var2) {
         return (Timestamp)this.postForAll(methodObject30178, this.onErrorForAll(methodObject30178, var2));
      }
   }

   public void setPhysicalConnectionOf(Connection arg0) {
      super.preForAll(methodObject30181, this, arg0);
      this.delegate.setPhysicalConnectionOf(arg0 instanceof _Proxy_ ? (Connection)((_Proxy_)arg0)._getDelegate_() : arg0);
   }

   public int intValue() throws SQLException {
      try {
         super.preForAll(methodObject30162, this, zeroLengthObjectArray);
         return (Integer)this.postForAll(methodObject30162, this.delegate.intValue());
      } catch (SQLException var2) {
         return (Integer)this.postForAll(methodObject30162, this.onErrorForAll(methodObject30162, var2));
      }
   }

   public String stringValue() throws SQLException {
      try {
         super.preForAll(methodObject30172, this, zeroLengthObjectArray);
         return (String)this.postForAll(methodObject30172, (Object)this.delegate.stringValue());
      } catch (SQLException var2) {
         return (String)this.postForAll(methodObject30172, this.onErrorForAll(methodObject30172, var2));
      }
   }

   public byte[] getBytes(long arg0, int arg1) throws SQLException {
      try {
         super.preForAll(methodObject30191, this, arg0, arg1);
         return (byte[])this.postForAll(methodObject30191, (Object)this.delegate.getBytes(arg0, arg1));
      } catch (SQLException var5) {
         return (byte[])this.postForAll(methodObject30191, this.onErrorForAll(methodObject30191, var5));
      }
   }

   public void setPrefetchedData(byte[] arg0, int arg1) {
      super.preForAll(methodObject30153, this, arg0, arg1);
      this.delegate.setPrefetchedData(arg0, arg1);
   }

   public String stringValue(Connection arg0) throws SQLException {
      try {
         super.preForAll(methodObject30173, this, arg0);
         return (String)this.postForAll(methodObject30173, (Object)this.delegate.stringValue(arg0 instanceof _Proxy_ ? (Connection)((_Proxy_)arg0)._getDelegate_() : arg0));
      } catch (SQLException var3) {
         return (String)this.postForAll(methodObject30173, this.onErrorForAll(methodObject30173, var3));
      }
   }

   public long position(byte[] arg0, long arg1) throws SQLException {
      try {
         super.preForAll(methodObject30193, this, arg0, arg1);
         return (Long)this.postForAll(methodObject30193, this.delegate.position(arg0, arg1));
      } catch (SQLException var5) {
         return (Long)this.postForAll(methodObject30193, this.onErrorForAll(methodObject30193, var5));
      }
   }

   public boolean isSecureFile() throws SQLException {
      try {
         super.preForAll(methodObject30189, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject30189, this.delegate.isSecureFile());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject30189, this.onErrorForAll(methodObject30189, var2));
      }
   }

   public void free() throws SQLException {
      try {
         super.preForFree(methodObject30195, this, zeroLengthObjectArray);
         this.delegate.free();
      } catch (SQLException var2) {
         this.onErrorVoidForAll(methodObject30195, var2);
      }
   }

   public InputStream asciiStreamValue() throws SQLException {
      try {
         super.preForAll(methodObject30140, this, zeroLengthObjectArray);
         return (InputStream)this.postForAll(methodObject30140, (Object)this.delegate.asciiStreamValue());
      } catch (SQLException var2) {
         return (InputStream)this.postForAll(methodObject30140, this.onErrorForAll(methodObject30140, var2));
      }
   }

   public long position(Blob arg0, long arg1) throws SQLException {
      try {
         super.preForAll(methodObject30194, this, arg0, arg1);
         return (Long)this.postForAll(methodObject30194, this.delegate.position(arg0 instanceof _Proxy_ ? (Blob)((_Proxy_)arg0)._getDelegate_() : arg0, arg1));
      } catch (SQLException var5) {
         return (Long)this.postForAll(methodObject30194, this.onErrorForAll(methodObject30194, var5));
      }
   }

   public byte[] shareBytes() {
      super.preForAll(methodObject30168, this, zeroLengthObjectArray);
      return (byte[])this.postForAll(methodObject30168, (Object)this.delegate.shareBytes());
   }

   public double doubleValue() throws SQLException {
      try {
         super.preForAll(methodObject30165, this, zeroLengthObjectArray);
         return (Double)this.postForAll(methodObject30165, this.delegate.doubleValue());
      } catch (SQLException var2) {
         return (Double)this.postForAll(methodObject30165, this.onErrorForAll(methodObject30165, var2));
      }
   }

   public void open(LargeObjectAccessMode arg0) throws SQLException {
      try {
         super.preForAll(methodObject30185, this, arg0);
         this.delegate.open(arg0);
      } catch (SQLException var3) {
         this.onErrorVoidForAll(methodObject30185, var3);
      }
   }

   public BlobDBAccess getDBAccess() throws SQLException {
      try {
         super.preForAll(methodObject30135, this, zeroLengthObjectArray);
         return (BlobDBAccess)this.postForAll(methodObject30135, (Object)this.delegate.getDBAccess());
      } catch (SQLException var2) {
         return (BlobDBAccess)this.postForAll(methodObject30135, this.onErrorForAll(methodObject30135, var2));
      }
   }

   public byte[] getLocator() {
      super.preForAll(methodObject30136, this, zeroLengthObjectArray);
      return (byte[])this.postForAll(methodObject30136, (Object)this.delegate.getLocator());
   }

   public void clearCachedData() {
      super.preForAll(methodObject30157, this, zeroLengthObjectArray);
      this.delegate.clearCachedData();
   }

   public InputStream getBinaryStream(long arg0) throws SQLException {
      try {
         super.preForAll(methodObject30187, this, arg0);
         return (InputStream)this.postForAll(methodObject30187, (Object)super.getBinaryStream(arg0));
      } catch (SQLException var4) {
         return (InputStream)this.postForAll(methodObject30187, this.onErrorForAll(methodObject30187, var4));
      }
   }

   public long longValue() throws SQLException {
      try {
         super.preForAll(methodObject30163, this, zeroLengthObjectArray);
         return (Long)this.postForAll(methodObject30163, this.delegate.longValue());
      } catch (SQLException var2) {
         return (Long)this.postForAll(methodObject30163, this.onErrorForAll(methodObject30163, var2));
      }
   }

   public boolean canReadBasicLobDataInLocator() throws SQLException {
      try {
         super.preForAll(methodObject30146, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject30146, this.delegate.canReadBasicLobDataInLocator());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject30146, this.onErrorForAll(methodObject30146, var2));
      }
   }

   public InputStream getBinaryStream(long arg0, long arg1) throws SQLException {
      try {
         super.preForAll(methodObject30198, this, arg0, arg1);
         return (InputStream)this.postForAll(methodObject30198, (Object)super.getBinaryStream(arg0, arg1));
      } catch (SQLException var6) {
         return (InputStream)this.postForAll(methodObject30198, this.onErrorForAll(methodObject30198, var6));
      }
   }

   public OutputStream setBinaryStream(long arg0) throws SQLException {
      try {
         super.preForAll(methodObject30196, this, arg0);
         return (OutputStream)this.postForAll(methodObject30196, (Object)super.setBinaryStream(arg0));
      } catch (SQLException var4) {
         return (OutputStream)this.postForAll(methodObject30196, this.onErrorForAll(methodObject30196, var4));
      }
   }

   public int getBytes(long arg0, int arg1, byte[] arg2) throws SQLException {
      try {
         super.preForAll(methodObject30183, this, arg0, arg1, arg2);
         return (Integer)this.postForAll(methodObject30183, this.delegate.getBytes(arg0, arg1, arg2));
      } catch (SQLException var6) {
         return (Integer)this.postForAll(methodObject30183, this.onErrorForAll(methodObject30183, var6));
      }
   }

   public Timestamp timestampValue(Calendar arg0) throws SQLException {
      try {
         super.preForAll(methodObject30179, this, arg0);
         return (Timestamp)this.postForAll(methodObject30179, (Object)this.delegate.timestampValue(arg0));
      } catch (SQLException var3) {
         return (Timestamp)this.postForAll(methodObject30179, this.onErrorForAll(methodObject30179, var3));
      }
   }

   public byte[] getPrefetchedData() {
      super.preForAll(methodObject30154, this, zeroLengthObjectArray);
      return (byte[])this.postForAll(methodObject30154, (Object)this.delegate.getPrefetchedData());
   }

   public void trim(long arg0) throws SQLException {
      try {
         super.preForAll(methodObject30132, this, arg0);
         this.delegate.trim(arg0);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject30132, var4);
      }
   }

   public long length() throws SQLException {
      try {
         super.preForAll(methodObject30192, this, zeroLengthObjectArray);
         return (Long)this.postForAll(methodObject30192, this.delegate.length());
      } catch (SQLException var2) {
         return (Long)this.postForAll(methodObject30192, this.onErrorForAll(methodObject30192, var2));
      }
   }

   public int setBytes(long arg0, byte[] arg1, int arg2, int arg3) throws SQLException {
      try {
         super.preForBlobWrites(methodObject30200, this, arg0, arg1, arg2, arg3);
         return (Integer)this.postForAll(methodObject30200, this.delegate.setBytes(arg0, arg1, arg2, arg3));
      } catch (SQLException var7) {
         return (Integer)this.postForAll(methodObject30200, this.onErrorForAll(methodObject30200, var7));
      }
   }

   public void setActivePrefetch(boolean arg0) {
      super.preForAll(methodObject30156, this, arg0);
      this.delegate.setActivePrefetch(arg0);
   }

   public OracleConnection getInternalConnection() throws SQLException {
      try {
         super.preForAll(methodObject30167, this, zeroLengthObjectArray);
         return (OracleConnection)this.postForAll(methodObject30167, (Object)super.getInternalConnection());
      } catch (SQLException var2) {
         return (OracleConnection)this.postForAll(methodObject30167, this.onErrorForAll(methodObject30167, var2));
      }
   }

   public InputStream getBinaryStream() throws SQLException {
      try {
         super.preForAll(methodObject30197, this, zeroLengthObjectArray);
         return (InputStream)this.postForAll(methodObject30197, (Object)super.getBinaryStream());
      } catch (SQLException var2) {
         return (InputStream)this.postForAll(methodObject30197, this.onErrorForAll(methodObject30197, var2));
      }
   }

   public OutputStream getBinaryOutputStream(long arg0) throws SQLException {
      try {
         super.preForAll(methodObject30145, this, arg0);
         return (OutputStream)this.postForAll(methodObject30145, (Object)super.getBinaryOutputStream(arg0));
      } catch (SQLException var4) {
         return (OutputStream)this.postForAll(methodObject30145, this.onErrorForAll(methodObject30145, var4));
      }
   }

   public int putBytes(long arg0, byte[] arg1, int arg2) throws SQLException {
      try {
         super.preForAll(methodObject30149, this, arg0, arg1, arg2);
         return (Integer)this.postForAll(methodObject30149, this.delegate.putBytes(arg0, arg1, arg2));
      } catch (SQLException var6) {
         return (Integer)this.postForAll(methodObject30149, this.onErrorForAll(methodObject30149, var6));
      }
   }

   public boolean isConvertibleTo(Class arg0) {
      super.preForAll(methodObject30133, this, arg0);
      return (Boolean)this.postForAll(methodObject30133, this.delegate.isConvertibleTo(arg0));
   }

   public byte[] getBytes() {
      super.preForAll(methodObject30166, this, zeroLengthObjectArray);
      return (byte[])this.postForAll(methodObject30166, (Object)this.delegate.getBytes());
   }

   public Time timeValue(Calendar arg0) throws SQLException {
      try {
         super.preForAll(methodObject30177, this, arg0);
         return (Time)this.postForAll(methodObject30177, (Object)this.delegate.timeValue(arg0));
      } catch (SQLException var3) {
         return (Time)this.postForAll(methodObject30177, this.onErrorForAll(methodObject30177, var3));
      }
   }

   public int getPrefetchedDataSize() {
      super.preForAll(methodObject30155, this, zeroLengthObjectArray);
      return (Integer)this.postForAll(methodObject30155, this.delegate.getPrefetchedDataSize());
   }

   public InputStream binaryStreamValue() throws SQLException {
      try {
         super.preForAll(methodObject30141, this, zeroLengthObjectArray);
         return (InputStream)this.postForAll(methodObject30141, (Object)this.delegate.binaryStreamValue());
      } catch (SQLException var2) {
         return (InputStream)this.postForAll(methodObject30141, this.onErrorForAll(methodObject30141, var2));
      }
   }

   public OutputStream getBinaryOutputStream() throws SQLException {
      try {
         super.preForAll(methodObject30144, this, zeroLengthObjectArray);
         return (OutputStream)this.postForAll(methodObject30144, (Object)super.getBinaryOutputStream());
      } catch (SQLException var2) {
         return (OutputStream)this.postForAll(methodObject30144, this.onErrorForAll(methodObject30144, var2));
      }
   }

   public Object getACProxy() {
      super.preForAll(methodObject30203, this, zeroLengthObjectArray);
      return this.postForAll(methodObject30203, this.proxyFactory.proxyForCache(this.delegate.getACProxy(), this, this.proxyCache, methodObject30203));
   }

   public oracle.jdbc.OracleConnection getOracleConnection() throws SQLException {
      try {
         super.preForAll(methodObject30180, this, zeroLengthObjectArray);
         return (oracle.jdbc.OracleConnection)this.postForAll(methodObject30180, this.proxyFactory.proxyForCache((Object)this.delegate.getOracleConnection(), this, this.proxyCache, methodObject30180));
      } catch (SQLException var2) {
         return (oracle.jdbc.OracleConnection)this.postForAll(methodObject30180, this.onErrorForAll(methodObject30180, var2));
      }
   }

   public int putBytes(long arg0, byte[] arg1) throws SQLException {
      try {
         super.preForAll(methodObject30148, this, arg0, arg1);
         return (Integer)this.postForAll(methodObject30148, this.delegate.putBytes(arg0, arg1));
      } catch (SQLException var5) {
         return (Integer)this.postForAll(methodObject30148, this.onErrorForAll(methodObject30148, var5));
      }
   }

   public Object toJdbc() throws SQLException {
      try {
         super.preForAll(methodObject30138, this, zeroLengthObjectArray);
         return this.postForAll(methodObject30138, this.proxyFactory.proxyForCache(this.delegate.toJdbc(), this, this.proxyCache, methodObject30138));
      } catch (SQLException var2) {
         return this.postForAll(methodObject30138, this.onErrorForAll(methodObject30138, var2));
      }
   }

   public int getBufferSize() throws SQLException {
      try {
         super.preForAll(methodObject30147, this, zeroLengthObjectArray);
         return (Integer)this.postForAll(methodObject30147, this.delegate.getBufferSize());
      } catch (SQLException var2) {
         return (Integer)this.postForAll(methodObject30147, this.onErrorForAll(methodObject30147, var2));
      }
   }

   public void truncate(long arg0) throws SQLException {
      try {
         super.preForBlobWrites(methodObject30201, this, arg0);
         this.delegate.truncate(arg0);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject30201, var4);
      }
   }

   public boolean isOpen() throws SQLException {
      try {
         super.preForAll(methodObject30186, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject30186, this.delegate.isOpen());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject30186, this.onErrorForAll(methodObject30186, var2));
      }
   }

   public Date dateValue() throws SQLException {
      try {
         super.preForAll(methodObject30175, this, zeroLengthObjectArray);
         return (Date)this.postForAll(methodObject30175, (Object)this.delegate.dateValue());
      } catch (SQLException var2) {
         return (Date)this.postForAll(methodObject30175, this.onErrorForAll(methodObject30175, var2));
      }
   }

   public int getChunkSize() throws SQLException {
      try {
         super.preForAll(methodObject30150, this, zeroLengthObjectArray);
         return (Integer)this.postForAll(methodObject30150, this.delegate.getChunkSize());
      } catch (SQLException var2) {
         return (Integer)this.postForAll(methodObject30150, this.onErrorForAll(methodObject30150, var2));
      }
   }

   public void setBytes(byte[] arg0) {
      super.preForAll(methodObject30169, this, arg0);
      this.delegate.setBytes(arg0);
   }

   public BigDecimal bigDecimalValue() throws SQLException {
      try {
         super.preForAll(methodObject30174, this, zeroLengthObjectArray);
         return (BigDecimal)this.postForAll(methodObject30174, (Object)this.delegate.bigDecimalValue());
      } catch (SQLException var2) {
         return (BigDecimal)this.postForAll(methodObject30174, this.onErrorForAll(methodObject30174, var2));
      }
   }

   public Object makeJdbcArray(int arg0) {
      super.preForAll(methodObject30142, this, arg0);
      return this.postForAll(methodObject30142, this.proxyFactory.proxyForCache(this.delegate.makeJdbcArray(arg0), this, this.proxyCache, methodObject30142));
   }

   public boolean isActivePrefetch() {
      super.preForAll(methodObject30158, this, zeroLengthObjectArray);
      return (Boolean)this.postForAll(methodObject30158, this.delegate.isActivePrefetch());
   }

   public byte byteValue() throws SQLException {
      try {
         super.preForAll(methodObject30161, this, zeroLengthObjectArray);
         return (Byte)this.postForAll(methodObject30161, this.delegate.byteValue());
      } catch (SQLException var2) {
         return (Byte)this.postForAll(methodObject30161, this.onErrorForAll(methodObject30161, var2));
      }
   }

   public Reader characterStreamValue() throws SQLException {
      try {
         super.preForAll(methodObject30139, this, zeroLengthObjectArray);
         return (Reader)this.postForAll(methodObject30139, (Object)this.delegate.characterStreamValue());
      } catch (SQLException var2) {
         return (Reader)this.postForAll(methodObject30139, this.onErrorForAll(methodObject30139, var2));
      }
   }

   public float floatValue() throws SQLException {
      try {
         super.preForAll(methodObject30164, this, zeroLengthObjectArray);
         return (Float)this.postForAll(methodObject30164, this.delegate.floatValue());
      } catch (SQLException var2) {
         return (Float)this.postForAll(methodObject30164, this.onErrorForAll(methodObject30164, var2));
      }
   }

   public void setChunkSize(int arg0) {
      super.preForAll(methodObject30151, this, arg0);
      this.delegate.setChunkSize(arg0);
   }

   public InputStream getStream() throws SQLException {
      try {
         super.preForAll(methodObject30171, this, zeroLengthObjectArray);
         return (InputStream)this.postForAll(methodObject30171, (Object)this.delegate.getStream());
      } catch (SQLException var2) {
         return (InputStream)this.postForAll(methodObject30171, this.onErrorForAll(methodObject30171, var2));
      }
   }

   public long getLength() {
      super.preForAll(methodObject30159, this, zeroLengthObjectArray);
      return (Long)this.postForAll(methodObject30159, this.delegate.getLength());
   }

   public Time timeValue() throws SQLException {
      try {
         super.preForAll(methodObject30176, this, zeroLengthObjectArray);
         return (Time)this.postForAll(methodObject30176, (Object)this.delegate.timeValue());
      } catch (SQLException var2) {
         return (Time)this.postForAll(methodObject30176, this.onErrorForAll(methodObject30176, var2));
      }
   }

   public oracle.jdbc.driver.OracleConnection getConnection() throws SQLException {
      try {
         super.preForAll(methodObject30182, this, zeroLengthObjectArray);
         return (oracle.jdbc.driver.OracleConnection)this.postForAll(methodObject30182, (Object)this.delegate.getConnection());
      } catch (SQLException var2) {
         return (oracle.jdbc.driver.OracleConnection)this.postForAll(methodObject30182, this.onErrorForAll(methodObject30182, var2));
      }
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
         methodObject30199 = Blob.class.getDeclaredMethod("setBytes", Long.TYPE, byte[].class);
         methodObject30170 = OracleDatumWithConnection.class.getDeclaredMethod("setShareBytes", byte[].class);
         methodObject30137 = OracleBlob.class.getDeclaredMethod("setLocator", byte[].class);
         methodObject30190 = oracle.jdbc.OracleBlob.class.getDeclaredMethod("isTemporary");
         methodObject30184 = oracle.jdbc.OracleBlob.class.getDeclaredMethod("close");
         methodObject30143 = OracleBlob.class.getDeclaredMethod("getJavaSqlConnection");
         methodObject30160 = OracleDatumWithConnection.class.getDeclaredMethod("booleanValue");
         methodObject30188 = oracle.jdbc.OracleBlob.class.getDeclaredMethod("isEmptyLob");
         methodObject30134 = OracleBlob.class.getDeclaredMethod("setLength", Long.TYPE);
         methodObject30152 = OracleBlob.class.getDeclaredMethod("setPrefetchedData", byte[].class);
         methodObject30202 = ACProxyable.class.getDeclaredMethod("setACProxy", Object.class);
         methodObject30178 = OracleDatumWithConnection.class.getDeclaredMethod("timestampValue");
         methodObject30181 = OracleDatumWithConnection.class.getDeclaredMethod("setPhysicalConnectionOf", Connection.class);
         methodObject30162 = OracleDatumWithConnection.class.getDeclaredMethod("intValue");
         methodObject30172 = OracleDatumWithConnection.class.getDeclaredMethod("stringValue");
         methodObject30191 = Blob.class.getDeclaredMethod("getBytes", Long.TYPE, Integer.TYPE);
         methodObject30153 = OracleBlob.class.getDeclaredMethod("setPrefetchedData", byte[].class, Integer.TYPE);
         methodObject30173 = OracleDatumWithConnection.class.getDeclaredMethod("stringValue", Connection.class);
         methodObject30193 = Blob.class.getDeclaredMethod("position", byte[].class, Long.TYPE);
         methodObject30189 = oracle.jdbc.OracleBlob.class.getDeclaredMethod("isSecureFile");
         methodObject30195 = Blob.class.getDeclaredMethod("free");
         methodObject30140 = OracleBlob.class.getDeclaredMethod("asciiStreamValue");
         methodObject30194 = Blob.class.getDeclaredMethod("position", Blob.class, Long.TYPE);
         methodObject30168 = OracleDatumWithConnection.class.getDeclaredMethod("shareBytes");
         methodObject30165 = OracleDatumWithConnection.class.getDeclaredMethod("doubleValue");
         methodObject30185 = oracle.jdbc.OracleBlob.class.getDeclaredMethod("open", LargeObjectAccessMode.class);
         methodObject30135 = OracleBlob.class.getDeclaredMethod("getDBAccess");
         methodObject30136 = OracleBlob.class.getDeclaredMethod("getLocator");
         methodObject30157 = OracleBlob.class.getDeclaredMethod("clearCachedData");
         methodObject30187 = oracle.jdbc.OracleBlob.class.getDeclaredMethod("getBinaryStream", Long.TYPE);
         methodObject30163 = OracleDatumWithConnection.class.getDeclaredMethod("longValue");
         methodObject30146 = OracleBlob.class.getDeclaredMethod("canReadBasicLobDataInLocator");
         methodObject30198 = Blob.class.getDeclaredMethod("getBinaryStream", Long.TYPE, Long.TYPE);
         methodObject30196 = Blob.class.getDeclaredMethod("setBinaryStream", Long.TYPE);
         methodObject30183 = oracle.jdbc.OracleBlob.class.getDeclaredMethod("getBytes", Long.TYPE, Integer.TYPE, byte[].class);
         methodObject30179 = OracleDatumWithConnection.class.getDeclaredMethod("timestampValue", Calendar.class);
         methodObject30154 = OracleBlob.class.getDeclaredMethod("getPrefetchedData");
         methodObject30132 = OracleBlob.class.getDeclaredMethod("trim", Long.TYPE);
         methodObject30192 = Blob.class.getDeclaredMethod("length");
         methodObject30200 = Blob.class.getDeclaredMethod("setBytes", Long.TYPE, byte[].class, Integer.TYPE, Integer.TYPE);
         methodObject30156 = OracleBlob.class.getDeclaredMethod("setActivePrefetch", Boolean.TYPE);
         methodObject30167 = OracleDatumWithConnection.class.getDeclaredMethod("getInternalConnection");
         methodObject30197 = Blob.class.getDeclaredMethod("getBinaryStream");
         methodObject30145 = OracleBlob.class.getDeclaredMethod("getBinaryOutputStream", Long.TYPE);
         methodObject30149 = OracleBlob.class.getDeclaredMethod("putBytes", Long.TYPE, byte[].class, Integer.TYPE);
         methodObject30133 = OracleBlob.class.getDeclaredMethod("isConvertibleTo", Class.class);
         methodObject30166 = OracleDatumWithConnection.class.getDeclaredMethod("getBytes");
         methodObject30177 = OracleDatumWithConnection.class.getDeclaredMethod("timeValue", Calendar.class);
         methodObject30155 = OracleBlob.class.getDeclaredMethod("getPrefetchedDataSize");
         methodObject30141 = OracleBlob.class.getDeclaredMethod("binaryStreamValue");
         methodObject30144 = OracleBlob.class.getDeclaredMethod("getBinaryOutputStream");
         methodObject30203 = ACProxyable.class.getDeclaredMethod("getACProxy");
         methodObject30180 = OracleDatumWithConnection.class.getDeclaredMethod("getOracleConnection");
         methodObject30148 = OracleBlob.class.getDeclaredMethod("putBytes", Long.TYPE, byte[].class);
         methodObject30138 = OracleBlob.class.getDeclaredMethod("toJdbc");
         methodObject30147 = OracleBlob.class.getDeclaredMethod("getBufferSize");
         methodObject30201 = Blob.class.getDeclaredMethod("truncate", Long.TYPE);
         methodObject30186 = oracle.jdbc.OracleBlob.class.getDeclaredMethod("isOpen");
         methodObject30175 = OracleDatumWithConnection.class.getDeclaredMethod("dateValue");
         methodObject30150 = OracleBlob.class.getDeclaredMethod("getChunkSize");
         methodObject30169 = OracleDatumWithConnection.class.getDeclaredMethod("setBytes", byte[].class);
         methodObject30174 = OracleDatumWithConnection.class.getDeclaredMethod("bigDecimalValue");
         methodObject30142 = OracleBlob.class.getDeclaredMethod("makeJdbcArray", Integer.TYPE);
         methodObject30158 = OracleBlob.class.getDeclaredMethod("isActivePrefetch");
         methodObject30161 = OracleDatumWithConnection.class.getDeclaredMethod("byteValue");
         methodObject30139 = OracleBlob.class.getDeclaredMethod("characterStreamValue");
         methodObject30164 = OracleDatumWithConnection.class.getDeclaredMethod("floatValue");
         methodObject30151 = OracleBlob.class.getDeclaredMethod("setChunkSize", Integer.TYPE);
         methodObject30171 = OracleDatumWithConnection.class.getDeclaredMethod("getStream");
         methodObject30159 = OracleDatumWithConnection.class.getDeclaredMethod("getLength");
         methodObject30176 = OracleDatumWithConnection.class.getDeclaredMethod("timeValue");
         methodObject30182 = OracleDatumWithConnection.class.getDeclaredMethod("getConnection");
      } catch (Throwable var1) {
         throw new RuntimeException(var1);
      }
   }

   public oracle$1jdbc$1replay$1driver$1NonTxnReplayableBlob$2oracle$1jdbc$1internal$1OracleBlob$$$Proxy(OracleBlob var1, Object var2, ProxyFactory var3, Map var4) {
      this.delegate = var1;
      this.creator = var2;
      this.proxyFactory = var3;
      this.proxyCache = var4;
   }
}
