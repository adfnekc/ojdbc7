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
import oracle.jdbc.replay.driver.TxnReplayableBfile;
import oracle.sql.BFILE;
import oracle.sql.BfileDBAccess;

public class oracle$1jdbc$1replay$1driver$1TxnReplayableBfile$2oracle$1jdbc$1internal$1OracleBfile$$$Proxy extends TxnReplayableBfile implements OracleBfile, _Proxy_ {
   private OracleBfile delegate;
   private final Object creator;
   private final ProxyFactory proxyFactory;
   private final Map proxyCache;
   private static Object[] zeroLengthObjectArray = new Object[0];
   private static Method methodObject731;
   private static Method methodObject747;
   private static Method methodObject749;
   private static Method methodObject744;
   private static Method methodObject712;
   private static Method methodObject740;
   private static Method methodObject715;
   private static Method methodObject703;
   private static Method methodObject704;
   private static Method methodObject726;
   private static Method methodObject717;
   private static Method methodObject730;
   private static Method methodObject751;
   private static Method methodObject702;
   private static Method methodObject725;
   private static Method methodObject727;
   private static Method methodObject706;
   private static Method methodObject722;
   private static Method methodObject720;
   private static Method methodObject739;
   private static Method methodObject713;
   private static Method methodObject748;
   private static Method methodObject711;
   private static Method methodObject718;
   private static Method methodObject743;
   private static Method methodObject710;
   private static Method methodObject741;
   private static Method methodObject734;
   private static Method methodObject728;
   private static Method methodObject752;
   private static Method methodObject745;
   private static Method methodObject709;
   private static Method methodObject721;
   private static Method methodObject707;
   private static Method methodObject754;
   private static Method methodObject755;
   private static Method methodObject736;
   private static Method methodObject708;
   private static Method methodObject746;
   private static Method methodObject733;
   private static Method methodObject732;
   private static Method methodObject723;
   private static Method methodObject753;
   private static Method methodObject750;
   private static Method methodObject716;
   private static Method methodObject719;
   private static Method methodObject705;
   private static Method methodObject729;
   private static Method methodObject724;
   private static Method methodObject714;
   private static Method methodObject738;
   private static Method methodObject742;
   private static Method methodObject735;
   private static Method methodObject737;

   public String stringValue(Connection arg0) throws SQLException {
      try {
         super.preForAll(methodObject731, this, arg0);
         return (String)this.postForAll(methodObject731, (Object)this.delegate.stringValue(arg0 instanceof _Proxy_ ? (Connection)((_Proxy_)arg0)._getDelegate_() : arg0));
      } catch (SQLException var3) {
         return (String)this.postForAll(methodObject731, this.onErrorForAll(methodObject731, var3));
      }
   }

   public void openFile() throws SQLException {
      try {
         super.preForAll(methodObject747, this, zeroLengthObjectArray);
         Method var10001 = methodObject747;
         this.delegate.openFile();
         this.postForAll(var10001);
      } catch (SQLException var2) {
         this.onErrorVoidForAll(methodObject747, var2);
      }
   }

   public boolean fileExists() throws SQLException {
      try {
         super.preForAll(methodObject749, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject749, this.delegate.fileExists());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject749, this.onErrorForAll(methodObject749, var2));
      }
   }

   public void close() throws SQLException {
      try {
         super.preForAll(methodObject744, this, zeroLengthObjectArray);
         Method var10001 = methodObject744;
         this.delegate.close();
         this.postForAll(var10001);
      } catch (SQLException var2) {
         this.onErrorVoidForAll(methodObject744, var2);
      }
   }

   public Connection getJavaSqlConnection() throws SQLException {
      try {
         super.preForAll(methodObject712, this, zeroLengthObjectArray);
         return (Connection)this.postForAll(methodObject712, this.proxyFactory.proxyForCache((Object)this.delegate.getJavaSqlConnection(), this, this.proxyCache, methodObject712));
      } catch (SQLException var2) {
         return (Connection)this.postForAll(methodObject712, this.onErrorForAll(methodObject712, var2));
      }
   }

   public int getBytes(long arg0, int arg1, byte[] arg2) throws SQLException {
      try {
         super.preForAll(methodObject740, this, arg0, arg1, arg2);
         return (Integer)this.postForAll(methodObject740, this.delegate.getBytes(arg0, arg1, arg2));
      } catch (SQLException var6) {
         return (Integer)this.postForAll(methodObject740, this.onErrorForAll(methodObject740, var6));
      }
   }

   public boolean booleanValue() throws SQLException {
      try {
         super.preForAll(methodObject715, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject715, this.delegate.booleanValue());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject715, this.onErrorForAll(methodObject715, var2));
      }
   }

   public boolean isConvertibleTo(Class arg0) {
      super.preForAll(methodObject703, this, arg0);
      return (Boolean)this.postForAll(methodObject703, this.delegate.isConvertibleTo(arg0));
   }

   public void setLength(long arg0) {
      super.preForAll(methodObject704, this, arg0);
      Method var10001 = methodObject704;
      this.delegate.setLength(arg0);
      this.postForAll(var10001);
   }

   public Timestamp timestampValue() throws SQLException {
      try {
         super.preForAll(methodObject726, this, zeroLengthObjectArray);
         return (Timestamp)this.postForAll(methodObject726, (Object)this.delegate.timestampValue());
      } catch (SQLException var2) {
         return (Timestamp)this.postForAll(methodObject726, this.onErrorForAll(methodObject726, var2));
      }
   }

   public int intValue() throws SQLException {
      try {
         super.preForAll(methodObject717, this, zeroLengthObjectArray);
         return (Integer)this.postForAll(methodObject717, this.delegate.intValue());
      } catch (SQLException var2) {
         return (Integer)this.postForAll(methodObject717, this.onErrorForAll(methodObject717, var2));
      }
   }

   public String stringValue() throws SQLException {
      try {
         super.preForAll(methodObject730, this, zeroLengthObjectArray);
         return (String)this.postForAll(methodObject730, (Object)this.delegate.stringValue());
      } catch (SQLException var2) {
         return (String)this.postForAll(methodObject730, this.onErrorForAll(methodObject730, var2));
      }
   }

   public String getDirAlias() throws SQLException {
      try {
         super.preForAll(methodObject751, this, zeroLengthObjectArray);
         return (String)this.postForAll(methodObject751, (Object)this.delegate.getDirAlias());
      } catch (SQLException var2) {
         return (String)this.postForAll(methodObject751, this.onErrorForAll(methodObject751, var2));
      }
   }

   public long position(BFILE arg0, long arg1) throws SQLException {
      try {
         super.preForAll(methodObject702, this, arg0, arg1);
         return (Long)this.postForAll(methodObject702, this.delegate.position(arg0, arg1));
      } catch (SQLException var5) {
         return (Long)this.postForAll(methodObject702, this.onErrorForAll(methodObject702, var5));
      }
   }

   public Time timeValue(Calendar arg0) throws SQLException {
      try {
         super.preForAll(methodObject725, this, arg0);
         return (Time)this.postForAll(methodObject725, (Object)this.delegate.timeValue(arg0));
      } catch (SQLException var3) {
         return (Time)this.postForAll(methodObject725, this.onErrorForAll(methodObject725, var3));
      }
   }

   public Timestamp timestampValue(Calendar arg0) throws SQLException {
      try {
         super.preForAll(methodObject727, this, arg0);
         return (Timestamp)this.postForAll(methodObject727, (Object)this.delegate.timestampValue(arg0));
      } catch (SQLException var3) {
         return (Timestamp)this.postForAll(methodObject727, this.onErrorForAll(methodObject727, var3));
      }
   }

   public InputStream asciiStreamValue() throws SQLException {
      try {
         super.preForAll(methodObject706, this, zeroLengthObjectArray);
         return (InputStream)this.postForAll(methodObject706, (Object)this.delegate.asciiStreamValue());
      } catch (SQLException var2) {
         return (InputStream)this.postForAll(methodObject706, this.onErrorForAll(methodObject706, var2));
      }
   }

   public byte[] shareBytes() {
      super.preForAll(methodObject722, this, zeroLengthObjectArray);
      return (byte[])this.postForAll(methodObject722, (Object)this.delegate.shareBytes());
   }

   public double doubleValue() throws SQLException {
      try {
         super.preForAll(methodObject720, this, zeroLengthObjectArray);
         return (Double)this.postForAll(methodObject720, this.delegate.doubleValue());
      } catch (SQLException var2) {
         return (Double)this.postForAll(methodObject720, this.onErrorForAll(methodObject720, var2));
      }
   }

   public byte[] getBytes(long arg0, int arg1) throws SQLException {
      try {
         super.preForAll(methodObject739, this, arg0, arg1);
         return (byte[])this.postForAll(methodObject739, (Object)this.delegate.getBytes(arg0, arg1));
      } catch (SQLException var5) {
         return (byte[])this.postForAll(methodObject739, this.onErrorForAll(methodObject739, var5));
      }
   }

   public BfileDBAccess getDBAccess() throws SQLException {
      try {
         super.preForAll(methodObject713, this, zeroLengthObjectArray);
         return (BfileDBAccess)this.postForAll(methodObject713, (Object)this.delegate.getDBAccess());
      } catch (SQLException var2) {
         return (BfileDBAccess)this.postForAll(methodObject713, this.onErrorForAll(methodObject713, var2));
      }
   }

   public boolean isFileOpen() throws SQLException {
      try {
         super.preForAll(methodObject748, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject748, this.delegate.isFileOpen());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject748, this.onErrorForAll(methodObject748, var2));
      }
   }

   public byte[] getLocator() {
      super.preForAll(methodObject711, this, zeroLengthObjectArray);
      return (byte[])this.postForAll(methodObject711, (Object)this.delegate.getLocator());
   }

   public long longValue() throws SQLException {
      try {
         super.preForAll(methodObject718, this, zeroLengthObjectArray);
         return (Long)this.postForAll(methodObject718, this.delegate.longValue());
      } catch (SQLException var2) {
         return (Long)this.postForAll(methodObject718, this.onErrorForAll(methodObject718, var2));
      }
   }

   public long position(oracle.jdbc.OracleBfile arg0, long arg1) throws SQLException {
      try {
         super.preForAll(methodObject743, this, arg0, arg1);
         return (Long)this.postForAll(methodObject743, this.delegate.position(arg0 instanceof _Proxy_ ? (oracle.jdbc.OracleBfile)((_Proxy_)arg0)._getDelegate_() : arg0, arg1));
      } catch (SQLException var5) {
         return (Long)this.postForAll(methodObject743, this.onErrorForAll(methodObject743, var5));
      }
   }

   public void setLocator(byte[] arg0) {
      super.preForAll(methodObject710, this, arg0);
      Method var10001 = methodObject710;
      this.delegate.setLocator(arg0);
      this.postForAll(var10001);
   }

   public long length() throws SQLException {
      try {
         super.preForAll(methodObject741, this, zeroLengthObjectArray);
         return (Long)this.postForAll(methodObject741, this.delegate.length());
      } catch (SQLException var2) {
         return (Long)this.postForAll(methodObject741, this.onErrorForAll(methodObject741, var2));
      }
   }

   public OracleConnection getInternalConnection() throws SQLException {
      try {
         super.preForAll(methodObject734, this, zeroLengthObjectArray);
         return (OracleConnection)this.postForAll(methodObject734, (Object)super.getInternalConnection());
      } catch (SQLException var2) {
         return (OracleConnection)this.postForAll(methodObject734, this.onErrorForAll(methodObject734, var2));
      }
   }

   public void setShareBytes(byte[] arg0) {
      super.preForAll(methodObject728, this, arg0);
      Method var10001 = methodObject728;
      this.delegate.setShareBytes(arg0);
      this.postForAll(var10001);
   }

   public InputStream getBinaryStream() throws SQLException {
      try {
         super.preForAll(methodObject752, this, zeroLengthObjectArray);
         return (InputStream)this.postForAll(methodObject752, (Object)super.getBinaryStream());
      } catch (SQLException var2) {
         return (InputStream)this.postForAll(methodObject752, this.onErrorForAll(methodObject752, var2));
      }
   }

   public void open(LargeObjectAccessMode arg0) throws SQLException {
      try {
         super.preForAll(methodObject745, this, arg0);
         Method var10001 = methodObject745;
         this.delegate.open(arg0);
         this.postForAll(var10001);
      } catch (SQLException var3) {
         this.onErrorVoidForAll(methodObject745, var3);
      }
   }

   public Object makeJdbcArray(int arg0) {
      super.preForAll(methodObject709, this, arg0);
      return this.postForAll(methodObject709, this.proxyFactory.proxyForCache(this.delegate.makeJdbcArray(arg0), this, this.proxyCache, methodObject709));
   }

   public byte[] getBytes() {
      super.preForAll(methodObject721, this, zeroLengthObjectArray);
      return (byte[])this.postForAll(methodObject721, (Object)this.delegate.getBytes());
   }

   public InputStream binaryStreamValue() throws SQLException {
      try {
         super.preForAll(methodObject707, this, zeroLengthObjectArray);
         return (InputStream)this.postForAll(methodObject707, (Object)this.delegate.binaryStreamValue());
      } catch (SQLException var2) {
         return (InputStream)this.postForAll(methodObject707, this.onErrorForAll(methodObject707, var2));
      }
   }

   public void setACProxy(Object arg0) {
      super.preForAll(methodObject754, this, arg0);
      Method var10001 = methodObject754;
      this.delegate.setACProxy(arg0 instanceof _Proxy_ ? (Object)((_Proxy_)arg0)._getDelegate_() : arg0);
      this.postForAll(var10001);
   }

   public Object getACProxy() {
      super.preForAll(methodObject755, this, zeroLengthObjectArray);
      return this.postForAll(methodObject755, this.proxyFactory.proxyForCache(this.delegate.getACProxy(), this, this.proxyCache, methodObject755));
   }

   public oracle.jdbc.OracleConnection getOracleConnection() throws SQLException {
      try {
         super.preForAll(methodObject736, this, zeroLengthObjectArray);
         return (oracle.jdbc.OracleConnection)this.postForAll(methodObject736, this.proxyFactory.proxyForCache((Object)this.delegate.getOracleConnection(), this, this.proxyCache, methodObject736));
      } catch (SQLException var2) {
         return (oracle.jdbc.OracleConnection)this.postForAll(methodObject736, this.onErrorForAll(methodObject736, var2));
      }
   }

   public Object toJdbc() throws SQLException {
      try {
         super.preForAll(methodObject708, this, zeroLengthObjectArray);
         return this.postForAll(methodObject708, this.proxyFactory.proxyForCache(this.delegate.toJdbc(), this, this.proxyCache, methodObject708));
      } catch (SQLException var2) {
         return this.postForAll(methodObject708, this.onErrorForAll(methodObject708, var2));
      }
   }

   public boolean isOpen() throws SQLException {
      try {
         super.preForAll(methodObject746, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject746, this.delegate.isOpen());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject746, this.onErrorForAll(methodObject746, var2));
      }
   }

   public Date dateValue() throws SQLException {
      try {
         super.preForAll(methodObject733, this, zeroLengthObjectArray);
         return (Date)this.postForAll(methodObject733, (Object)this.delegate.dateValue());
      } catch (SQLException var2) {
         return (Date)this.postForAll(methodObject733, this.onErrorForAll(methodObject733, var2));
      }
   }

   public BigDecimal bigDecimalValue() throws SQLException {
      try {
         super.preForAll(methodObject732, this, zeroLengthObjectArray);
         return (BigDecimal)this.postForAll(methodObject732, (Object)this.delegate.bigDecimalValue());
      } catch (SQLException var2) {
         return (BigDecimal)this.postForAll(methodObject732, this.onErrorForAll(methodObject732, var2));
      }
   }

   public void setBytes(byte[] arg0) {
      super.preForAll(methodObject723, this, arg0);
      Method var10001 = methodObject723;
      this.delegate.setBytes(arg0);
      this.postForAll(var10001);
   }

   public InputStream getBinaryStream(long arg0) throws SQLException {
      try {
         super.preForAll(methodObject753, this, arg0);
         return (InputStream)this.postForAll(methodObject753, (Object)super.getBinaryStream(arg0));
      } catch (SQLException var4) {
         return (InputStream)this.postForAll(methodObject753, this.onErrorForAll(methodObject753, var4));
      }
   }

   public void closeFile() throws SQLException {
      try {
         super.preForAll(methodObject750, this, zeroLengthObjectArray);
         Method var10001 = methodObject750;
         this.delegate.closeFile();
         this.postForAll(var10001);
      } catch (SQLException var2) {
         this.onErrorVoidForAll(methodObject750, var2);
      }
   }

   public byte byteValue() throws SQLException {
      try {
         super.preForAll(methodObject716, this, zeroLengthObjectArray);
         return (Byte)this.postForAll(methodObject716, this.delegate.byteValue());
      } catch (SQLException var2) {
         return (Byte)this.postForAll(methodObject716, this.onErrorForAll(methodObject716, var2));
      }
   }

   public float floatValue() throws SQLException {
      try {
         super.preForAll(methodObject719, this, zeroLengthObjectArray);
         return (Float)this.postForAll(methodObject719, this.delegate.floatValue());
      } catch (SQLException var2) {
         return (Float)this.postForAll(methodObject719, this.onErrorForAll(methodObject719, var2));
      }
   }

   public Reader characterStreamValue() throws SQLException {
      try {
         super.preForAll(methodObject705, this, zeroLengthObjectArray);
         return (Reader)this.postForAll(methodObject705, (Object)this.delegate.characterStreamValue());
      } catch (SQLException var2) {
         return (Reader)this.postForAll(methodObject705, this.onErrorForAll(methodObject705, var2));
      }
   }

   public InputStream getStream() throws SQLException {
      try {
         super.preForAll(methodObject729, this, zeroLengthObjectArray);
         return (InputStream)this.postForAll(methodObject729, (Object)this.delegate.getStream());
      } catch (SQLException var2) {
         return (InputStream)this.postForAll(methodObject729, this.onErrorForAll(methodObject729, var2));
      }
   }

   public Time timeValue() throws SQLException {
      try {
         super.preForAll(methodObject724, this, zeroLengthObjectArray);
         return (Time)this.postForAll(methodObject724, (Object)this.delegate.timeValue());
      } catch (SQLException var2) {
         return (Time)this.postForAll(methodObject724, this.onErrorForAll(methodObject724, var2));
      }
   }

   public long getLength() {
      super.preForAll(methodObject714, this, zeroLengthObjectArray);
      return (Long)this.postForAll(methodObject714, this.delegate.getLength());
   }

   public String getName() throws SQLException {
      try {
         super.preForAll(methodObject738, this, zeroLengthObjectArray);
         return (String)this.postForAll(methodObject738, (Object)this.delegate.getName());
      } catch (SQLException var2) {
         return (String)this.postForAll(methodObject738, this.onErrorForAll(methodObject738, var2));
      }
   }

   public long position(byte[] arg0, long arg1) throws SQLException {
      try {
         super.preForAll(methodObject742, this, arg0, arg1);
         return (Long)this.postForAll(methodObject742, this.delegate.position(arg0, arg1));
      } catch (SQLException var5) {
         return (Long)this.postForAll(methodObject742, this.onErrorForAll(methodObject742, var5));
      }
   }

   public void setPhysicalConnectionOf(Connection arg0) {
      super.preForAll(methodObject735, this, arg0);
      Method var10001 = methodObject735;
      this.delegate.setPhysicalConnectionOf(arg0 instanceof _Proxy_ ? (Connection)((_Proxy_)arg0)._getDelegate_() : arg0);
      this.postForAll(var10001);
   }

   public oracle.jdbc.driver.OracleConnection getConnection() throws SQLException {
      try {
         super.preForAll(methodObject737, this, zeroLengthObjectArray);
         return (oracle.jdbc.driver.OracleConnection)this.postForAll(methodObject737, (Object)this.delegate.getConnection());
      } catch (SQLException var2) {
         return (oracle.jdbc.driver.OracleConnection)this.postForAll(methodObject737, this.onErrorForAll(methodObject737, var2));
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
         methodObject731 = OracleDatumWithConnection.class.getDeclaredMethod("stringValue", Connection.class);
         methodObject747 = oracle.jdbc.OracleBfile.class.getDeclaredMethod("openFile");
         methodObject749 = oracle.jdbc.OracleBfile.class.getDeclaredMethod("fileExists");
         methodObject744 = oracle.jdbc.OracleBfile.class.getDeclaredMethod("close");
         methodObject712 = OracleBfile.class.getDeclaredMethod("getJavaSqlConnection");
         methodObject740 = oracle.jdbc.OracleBfile.class.getDeclaredMethod("getBytes", Long.TYPE, Integer.TYPE, byte[].class);
         methodObject715 = OracleDatumWithConnection.class.getDeclaredMethod("booleanValue");
         methodObject703 = OracleBfile.class.getDeclaredMethod("isConvertibleTo", Class.class);
         methodObject704 = OracleBfile.class.getDeclaredMethod("setLength", Long.TYPE);
         methodObject726 = OracleDatumWithConnection.class.getDeclaredMethod("timestampValue");
         methodObject717 = OracleDatumWithConnection.class.getDeclaredMethod("intValue");
         methodObject730 = OracleDatumWithConnection.class.getDeclaredMethod("stringValue");
         methodObject751 = oracle.jdbc.OracleBfile.class.getDeclaredMethod("getDirAlias");
         methodObject702 = OracleBfile.class.getDeclaredMethod("position", BFILE.class, Long.TYPE);
         methodObject725 = OracleDatumWithConnection.class.getDeclaredMethod("timeValue", Calendar.class);
         methodObject727 = OracleDatumWithConnection.class.getDeclaredMethod("timestampValue", Calendar.class);
         methodObject706 = OracleBfile.class.getDeclaredMethod("asciiStreamValue");
         methodObject722 = OracleDatumWithConnection.class.getDeclaredMethod("shareBytes");
         methodObject720 = OracleDatumWithConnection.class.getDeclaredMethod("doubleValue");
         methodObject739 = oracle.jdbc.OracleBfile.class.getDeclaredMethod("getBytes", Long.TYPE, Integer.TYPE);
         methodObject713 = OracleBfile.class.getDeclaredMethod("getDBAccess");
         methodObject748 = oracle.jdbc.OracleBfile.class.getDeclaredMethod("isFileOpen");
         methodObject711 = OracleBfile.class.getDeclaredMethod("getLocator");
         methodObject718 = OracleDatumWithConnection.class.getDeclaredMethod("longValue");
         methodObject743 = oracle.jdbc.OracleBfile.class.getDeclaredMethod("position", oracle.jdbc.OracleBfile.class, Long.TYPE);
         methodObject710 = OracleBfile.class.getDeclaredMethod("setLocator", byte[].class);
         methodObject741 = oracle.jdbc.OracleBfile.class.getDeclaredMethod("length");
         methodObject734 = OracleDatumWithConnection.class.getDeclaredMethod("getInternalConnection");
         methodObject728 = OracleDatumWithConnection.class.getDeclaredMethod("setShareBytes", byte[].class);
         methodObject752 = oracle.jdbc.OracleBfile.class.getDeclaredMethod("getBinaryStream");
         methodObject745 = oracle.jdbc.OracleBfile.class.getDeclaredMethod("open", LargeObjectAccessMode.class);
         methodObject709 = OracleBfile.class.getDeclaredMethod("makeJdbcArray", Integer.TYPE);
         methodObject721 = OracleDatumWithConnection.class.getDeclaredMethod("getBytes");
         methodObject707 = OracleBfile.class.getDeclaredMethod("binaryStreamValue");
         methodObject754 = ACProxyable.class.getDeclaredMethod("setACProxy", Object.class);
         methodObject755 = ACProxyable.class.getDeclaredMethod("getACProxy");
         methodObject736 = OracleDatumWithConnection.class.getDeclaredMethod("getOracleConnection");
         methodObject708 = OracleBfile.class.getDeclaredMethod("toJdbc");
         methodObject746 = oracle.jdbc.OracleBfile.class.getDeclaredMethod("isOpen");
         methodObject733 = OracleDatumWithConnection.class.getDeclaredMethod("dateValue");
         methodObject732 = OracleDatumWithConnection.class.getDeclaredMethod("bigDecimalValue");
         methodObject723 = OracleDatumWithConnection.class.getDeclaredMethod("setBytes", byte[].class);
         methodObject753 = oracle.jdbc.OracleBfile.class.getDeclaredMethod("getBinaryStream", Long.TYPE);
         methodObject750 = oracle.jdbc.OracleBfile.class.getDeclaredMethod("closeFile");
         methodObject716 = OracleDatumWithConnection.class.getDeclaredMethod("byteValue");
         methodObject719 = OracleDatumWithConnection.class.getDeclaredMethod("floatValue");
         methodObject705 = OracleBfile.class.getDeclaredMethod("characterStreamValue");
         methodObject729 = OracleDatumWithConnection.class.getDeclaredMethod("getStream");
         methodObject724 = OracleDatumWithConnection.class.getDeclaredMethod("timeValue");
         methodObject714 = OracleDatumWithConnection.class.getDeclaredMethod("getLength");
         methodObject738 = oracle.jdbc.OracleBfile.class.getDeclaredMethod("getName");
         methodObject742 = oracle.jdbc.OracleBfile.class.getDeclaredMethod("position", byte[].class, Long.TYPE);
         methodObject735 = OracleDatumWithConnection.class.getDeclaredMethod("setPhysicalConnectionOf", Connection.class);
         methodObject737 = OracleDatumWithConnection.class.getDeclaredMethod("getConnection");
      } catch (Throwable var1) {
         throw new RuntimeException(var1);
      }
   }

   public oracle$1jdbc$1replay$1driver$1TxnReplayableBfile$2oracle$1jdbc$1internal$1OracleBfile$$$Proxy(OracleBfile var1, Object var2, ProxyFactory var3, Map var4) {
      this.delegate = var1;
      this.creator = var2;
      this.proxyFactory = var3;
      this.proxyCache = var4;
   }
}
