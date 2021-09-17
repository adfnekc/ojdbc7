package oracle.jdbc.proxy;

import java.io.InputStream;
import java.io.Reader;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.Date;
import java.sql.Ref;
import java.sql.SQLException;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Map;
import oracle.jdbc.OracleTypeMetaData;
import oracle.jdbc.internal.ACProxyable;
import oracle.jdbc.internal.OracleConnection;
import oracle.jdbc.internal.OracleDatumWithConnection;
import oracle.jdbc.internal.OracleRef;
import oracle.jdbc.replay.driver.TxnReplayableRef;
import oracle.sql.STRUCT;
import oracle.sql.StructDescriptor;

public class oracle$1jdbc$1replay$1driver$1TxnReplayableRef$2oracle$1jdbc$1internal$1OracleRef$$$Proxy extends TxnReplayableRef implements OracleRef, _Proxy_ {
   private OracleRef delegate;
   private final Object creator;
   private final ProxyFactory proxyFactory;
   private final Map proxyCache;
   private static Object[] zeroLengthObjectArray = new Object[0];
   private static Method methodObject3744;
   private static Method methodObject3747;
   private static Method methodObject3717;
   private static Method methodObject3741;
   private static Method methodObject3754;
   private static Method methodObject3753;
   private static Method methodObject3719;
   private static Method methodObject3756;
   private static Method methodObject3721;
   private static Method methodObject3749;
   private static Method methodObject3731;
   private static Method methodObject3725;
   private static Method methodObject3718;
   private static Method methodObject3740;
   private static Method methodObject3722;
   private static Method methodObject3736;
   private static Method methodObject3757;
   private static Method methodObject3727;
   private static Method methodObject3758;
   private static Method methodObject3750;
   private static Method methodObject3743;
   private static Method methodObject3715;
   private static Method methodObject3720;
   private static Method methodObject3735;
   private static Method methodObject3755;
   private static Method methodObject3737;
   private static Method methodObject3739;
   private static Method methodObject3716;
   private static Method methodObject3746;
   private static Method methodObject3732;
   private static Method methodObject3723;
   private static Method methodObject3730;
   private static Method methodObject3745;
   private static Method methodObject3733;
   private static Method methodObject3752;
   private static Method methodObject3728;
   private static Method methodObject3726;
   private static Method methodObject3729;
   private static Method methodObject3738;
   private static Method methodObject3742;
   private static Method methodObject3724;
   private static Method methodObject3734;
   private static Method methodObject3751;
   private static Method methodObject3748;

   public String stringValue(Connection arg0) throws SQLException {
      try {
         super.preForAll(methodObject3744, this, arg0);
         return (String)this.postForAll(methodObject3744, (Object)this.delegate.stringValue(arg0 instanceof _Proxy_ ? (Connection)((_Proxy_)arg0)._getDelegate_() : arg0));
      } catch (SQLException var3) {
         return (String)this.postForAll(methodObject3744, this.onErrorForAll(methodObject3744, var3));
      }
   }

   public OracleConnection getInternalConnection() throws SQLException {
      try {
         super.preForAll(methodObject3747, this, zeroLengthObjectArray);
         return (OracleConnection)this.postForAll(methodObject3747, this.proxyFactory.proxyForCache((Object)this.delegate.getInternalConnection(), this, this.proxyCache, methodObject3747));
      } catch (SQLException var2) {
         return (OracleConnection)this.postForAll(methodObject3747, this.onErrorForAll(methodObject3747, var2));
      }
   }

   public StructDescriptor getDescriptor() throws SQLException {
      try {
         super.preForAll(methodObject3717, this, zeroLengthObjectArray);
         return (StructDescriptor)this.postForAll(methodObject3717, (Object)this.delegate.getDescriptor());
      } catch (SQLException var2) {
         return (StructDescriptor)this.postForAll(methodObject3717, this.onErrorForAll(methodObject3717, var2));
      }
   }

   public void setShareBytes(byte[] arg0) {
      super.preForAll(methodObject3741, this, arg0);
      Method var10001 = methodObject3741;
      this.delegate.setShareBytes(arg0);
      this.postForAll(var10001);
   }

   public Object getObject() throws SQLException {
      try {
         super.preForAll(methodObject3754, this, zeroLengthObjectArray);
         return this.postForAll(methodObject3754, this.proxyFactory.proxyForCache(this.delegate.getObject(), this, this.proxyCache, methodObject3754));
      } catch (SQLException var2) {
         return this.postForAll(methodObject3754, this.onErrorForAll(methodObject3754, var2));
      }
   }

   public Object getObject(Map arg0) throws SQLException {
      try {
         super.preForAll(methodObject3753, this, arg0);
         return this.postForAll(methodObject3753, this.proxyFactory.proxyForCache(this.delegate.getObject(arg0), this, this.proxyCache, methodObject3753));
      } catch (SQLException var3) {
         return this.postForAll(methodObject3753, this.onErrorForAll(methodObject3753, var3));
      }
   }

   public void setValue(Object arg0) throws SQLException {
      try {
         super.preForAll(methodObject3719, this, arg0);
         Method var10001 = methodObject3719;
         this.delegate.setValue(arg0 instanceof _Proxy_ ? (Object)((_Proxy_)arg0)._getDelegate_() : arg0);
         this.postForAll(var10001);
      } catch (SQLException var3) {
         this.onErrorVoidForAll(methodObject3719, var3);
      }
   }

   public void setObject(Object arg0) throws SQLException {
      try {
         super.preForAll(methodObject3756, this, arg0);
         Method var10001 = methodObject3756;
         this.delegate.setObject(arg0 instanceof _Proxy_ ? (Object)((_Proxy_)arg0)._getDelegate_() : arg0);
         this.postForAll(var10001);
      } catch (SQLException var3) {
         this.onErrorVoidForAll(methodObject3756, var3);
      }
   }

   public Object makeJdbcArray(int arg0) {
      super.preForAll(methodObject3721, this, arg0);
      return this.postForAll(methodObject3721, this.proxyFactory.proxyForCache(this.delegate.makeJdbcArray(arg0), this, this.proxyCache, methodObject3721));
   }

   @Override
   public Object clone() throws CloneNotSupportedException {
      return null;
   }

   public Connection getJavaSqlConnection() throws SQLException {
      try {
         super.preForAll(methodObject3749, this, zeroLengthObjectArray);
         return (Connection)this.postForAll(methodObject3749, this.proxyFactory.proxyForCache((Object)this.delegate.getJavaSqlConnection(), this, this.proxyCache, methodObject3749));
      } catch (SQLException var2) {
         return (Connection)this.postForAll(methodObject3749, this.onErrorForAll(methodObject3749, var2));
      }
   }

   public byte[] getBytes() {
      super.preForAll(methodObject3731, this, zeroLengthObjectArray);
      return (byte[])this.postForAll(methodObject3731, (Object)this.delegate.getBytes());
   }

   public boolean booleanValue() throws SQLException {
      try {
         super.preForAll(methodObject3725, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject3725, this.delegate.booleanValue());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject3725, this.onErrorForAll(methodObject3725, var2));
      }
   }

   public boolean isConvertibleTo(Class arg0) {
      super.preForAll(methodObject3718, this, arg0);
      return (Boolean)this.postForAll(methodObject3718, this.delegate.isConvertibleTo(arg0));
   }

   public InputStream binaryStreamValue() throws SQLException {
      try {
         super.preForAll(methodObject3740, this, zeroLengthObjectArray);
         return (InputStream)this.postForAll(methodObject3740, (Object)this.delegate.binaryStreamValue());
      } catch (SQLException var2) {
         return (InputStream)this.postForAll(methodObject3740, this.onErrorForAll(methodObject3740, var2));
      }
   }

   public String getSQLTypeName() throws SQLException {
      try {
         super.preForAll(methodObject3722, this, zeroLengthObjectArray);
         return (String)this.postForAll(methodObject3722, (Object)this.delegate.getSQLTypeName());
      } catch (SQLException var2) {
         return (String)this.postForAll(methodObject3722, this.onErrorForAll(methodObject3722, var2));
      }
   }

   public Timestamp timestampValue() throws SQLException {
      try {
         super.preForAll(methodObject3736, this, zeroLengthObjectArray);
         return (Timestamp)this.postForAll(methodObject3736, (Object)this.delegate.timestampValue());
      } catch (SQLException var2) {
         return (Timestamp)this.postForAll(methodObject3736, this.onErrorForAll(methodObject3736, var2));
      }
   }

   public void setACProxy(Object arg0) {
      super.preForAll(methodObject3757, this, arg0);
      Method var10001 = methodObject3757;
      this.delegate.setACProxy(arg0 instanceof _Proxy_ ? (Object)((_Proxy_)arg0)._getDelegate_() : arg0);
      this.postForAll(var10001);
   }

   public int intValue() throws SQLException {
      try {
         super.preForAll(methodObject3727, this, zeroLengthObjectArray);
         return (Integer)this.postForAll(methodObject3727, this.delegate.intValue());
      } catch (SQLException var2) {
         return (Integer)this.postForAll(methodObject3727, this.onErrorForAll(methodObject3727, var2));
      }
   }

   public Object getACProxy() {
      super.preForAll(methodObject3758, this, zeroLengthObjectArray);
      return this.postForAll(methodObject3758, this.proxyFactory.proxyForCache(this.delegate.getACProxy(), this, this.proxyCache, methodObject3758));
   }

   public oracle.jdbc.OracleConnection getOracleConnection() throws SQLException {
      try {
         super.preForAll(methodObject3750, this, zeroLengthObjectArray);
         return (oracle.jdbc.OracleConnection)this.postForAll(methodObject3750, this.proxyFactory.proxyForCache((Object)this.delegate.getOracleConnection(), this, this.proxyCache, methodObject3750));
      } catch (SQLException var2) {
         return (oracle.jdbc.OracleConnection)this.postForAll(methodObject3750, this.onErrorForAll(methodObject3750, var2));
      }
   }

   public String stringValue() throws SQLException {
      try {
         super.preForAll(methodObject3743, this, zeroLengthObjectArray);
         return (String)this.postForAll(methodObject3743, (Object)this.delegate.stringValue());
      } catch (SQLException var2) {
         return (String)this.postForAll(methodObject3743, this.onErrorForAll(methodObject3743, var2));
      }
   }

   public Object getValue(Map arg0) throws SQLException {
      try {
         super.preForAll(methodObject3715, this, arg0);
         return this.postForAll(methodObject3715, this.proxyFactory.proxyForCache(this.delegate.getValue(arg0), this, this.proxyCache, methodObject3715));
      } catch (SQLException var3) {
         return this.postForAll(methodObject3715, this.onErrorForAll(methodObject3715, var3));
      }
   }

   public Object toJdbc() throws SQLException {
      try {
         super.preForAll(methodObject3720, this, zeroLengthObjectArray);
         return this.postForAll(methodObject3720, this.proxyFactory.proxyForCache(this.delegate.toJdbc(), this, this.proxyCache, methodObject3720));
      } catch (SQLException var2) {
         return this.postForAll(methodObject3720, this.onErrorForAll(methodObject3720, var2));
      }
   }

   public Time timeValue(Calendar arg0) throws SQLException {
      try {
         super.preForAll(methodObject3735, this, arg0);
         return (Time)this.postForAll(methodObject3735, (Object)this.delegate.timeValue(arg0));
      } catch (SQLException var3) {
         return (Time)this.postForAll(methodObject3735, this.onErrorForAll(methodObject3735, var3));
      }
   }

   public String getBaseTypeName() throws SQLException {
      try {
         super.preForAll(methodObject3755, this, zeroLengthObjectArray);
         return (String)this.postForAll(methodObject3755, (Object)this.delegate.getBaseTypeName());
      } catch (SQLException var2) {
         return (String)this.postForAll(methodObject3755, this.onErrorForAll(methodObject3755, var2));
      }
   }

   public Timestamp timestampValue(Calendar arg0) throws SQLException {
      try {
         super.preForAll(methodObject3737, this, arg0);
         return (Timestamp)this.postForAll(methodObject3737, (Object)this.delegate.timestampValue(arg0));
      } catch (SQLException var3) {
         return (Timestamp)this.postForAll(methodObject3737, this.onErrorForAll(methodObject3737, var3));
      }
   }

   public InputStream asciiStreamValue() throws SQLException {
      try {
         super.preForAll(methodObject3739, this, zeroLengthObjectArray);
         return (InputStream)this.postForAll(methodObject3739, (Object)this.delegate.asciiStreamValue());
      } catch (SQLException var2) {
         return (InputStream)this.postForAll(methodObject3739, this.onErrorForAll(methodObject3739, var2));
      }
   }

   public Object getValue() throws SQLException {
      try {
         super.preForAll(methodObject3716, this, zeroLengthObjectArray);
         return this.postForAll(methodObject3716, this.proxyFactory.proxyForCache(this.delegate.getValue(), this, this.proxyCache, methodObject3716));
      } catch (SQLException var2) {
         return this.postForAll(methodObject3716, this.onErrorForAll(methodObject3716, var2));
      }
   }

   public Date dateValue() throws SQLException {
      try {
         super.preForAll(methodObject3746, this, zeroLengthObjectArray);
         return (Date)this.postForAll(methodObject3746, (Object)this.delegate.dateValue());
      } catch (SQLException var2) {
         return (Date)this.postForAll(methodObject3746, this.onErrorForAll(methodObject3746, var2));
      }
   }

   public byte[] shareBytes() {
      super.preForAll(methodObject3732, this, zeroLengthObjectArray);
      return (byte[])this.postForAll(methodObject3732, (Object)this.delegate.shareBytes());
   }

   public STRUCT getSTRUCT() throws SQLException {
      try {
         super.preForAll(methodObject3723, this, zeroLengthObjectArray);
         return (STRUCT)this.postForAll(methodObject3723, (Object)this.delegate.getSTRUCT());
      } catch (SQLException var2) {
         return (STRUCT)this.postForAll(methodObject3723, this.onErrorForAll(methodObject3723, var2));
      }
   }

   public double doubleValue() throws SQLException {
      try {
         super.preForAll(methodObject3730, this, zeroLengthObjectArray);
         return (Double)this.postForAll(methodObject3730, this.delegate.doubleValue());
      } catch (SQLException var2) {
         return (Double)this.postForAll(methodObject3730, this.onErrorForAll(methodObject3730, var2));
      }
   }

   public BigDecimal bigDecimalValue() throws SQLException {
      try {
         super.preForAll(methodObject3745, this, zeroLengthObjectArray);
         return (BigDecimal)this.postForAll(methodObject3745, (Object)this.delegate.bigDecimalValue());
      } catch (SQLException var2) {
         return (BigDecimal)this.postForAll(methodObject3745, this.onErrorForAll(methodObject3745, var2));
      }
   }

   public void setBytes(byte[] arg0) {
      super.preForAll(methodObject3733, this, arg0);
      Method var10001 = methodObject3733;
      this.delegate.setBytes(arg0);
      this.postForAll(var10001);
   }

   public OracleTypeMetaData getOracleMetaData() throws SQLException {
      try {
         super.preForAll(methodObject3752, this, zeroLengthObjectArray);
         return (OracleTypeMetaData)this.postForAll(methodObject3752, this.proxyFactory.proxyForCache((Object)this.delegate.getOracleMetaData(), this, this.proxyCache, methodObject3752));
      } catch (SQLException var2) {
         return (OracleTypeMetaData)this.postForAll(methodObject3752, this.onErrorForAll(methodObject3752, var2));
      }
   }

   public long longValue() throws SQLException {
      try {
         super.preForAll(methodObject3728, this, zeroLengthObjectArray);
         return (Long)this.postForAll(methodObject3728, this.delegate.longValue());
      } catch (SQLException var2) {
         return (Long)this.postForAll(methodObject3728, this.onErrorForAll(methodObject3728, var2));
      }
   }

   public byte byteValue() throws SQLException {
      try {
         super.preForAll(methodObject3726, this, zeroLengthObjectArray);
         return (Byte)this.postForAll(methodObject3726, this.delegate.byteValue());
      } catch (SQLException var2) {
         return (Byte)this.postForAll(methodObject3726, this.onErrorForAll(methodObject3726, var2));
      }
   }

   public float floatValue() throws SQLException {
      try {
         super.preForAll(methodObject3729, this, zeroLengthObjectArray);
         return (Float)this.postForAll(methodObject3729, this.delegate.floatValue());
      } catch (SQLException var2) {
         return (Float)this.postForAll(methodObject3729, this.onErrorForAll(methodObject3729, var2));
      }
   }

   public Reader characterStreamValue() throws SQLException {
      try {
         super.preForAll(methodObject3738, this, zeroLengthObjectArray);
         return (Reader)this.postForAll(methodObject3738, (Object)this.delegate.characterStreamValue());
      } catch (SQLException var2) {
         return (Reader)this.postForAll(methodObject3738, this.onErrorForAll(methodObject3738, var2));
      }
   }

   public InputStream getStream() throws SQLException {
      try {
         super.preForAll(methodObject3742, this, zeroLengthObjectArray);
         return (InputStream)this.postForAll(methodObject3742, (Object)this.delegate.getStream());
      } catch (SQLException var2) {
         return (InputStream)this.postForAll(methodObject3742, this.onErrorForAll(methodObject3742, var2));
      }
   }

   public long getLength() {
      super.preForAll(methodObject3724, this, zeroLengthObjectArray);
      return (Long)this.postForAll(methodObject3724, this.delegate.getLength());
   }

   public Time timeValue() throws SQLException {
      try {
         super.preForAll(methodObject3734, this, zeroLengthObjectArray);
         return (Time)this.postForAll(methodObject3734, (Object)this.delegate.timeValue());
      } catch (SQLException var2) {
         return (Time)this.postForAll(methodObject3734, this.onErrorForAll(methodObject3734, var2));
      }
   }

   public oracle.jdbc.driver.OracleConnection getConnection() throws SQLException {
      try {
         super.preForAll(methodObject3751, this, zeroLengthObjectArray);
         return (oracle.jdbc.driver.OracleConnection)this.postForAll(methodObject3751, (Object)this.delegate.getConnection());
      } catch (SQLException var2) {
         return (oracle.jdbc.driver.OracleConnection)this.postForAll(methodObject3751, this.onErrorForAll(methodObject3751, var2));
      }
   }

   public void setPhysicalConnectionOf(Connection arg0) {
      super.preForAll(methodObject3748, this, arg0);
      Method var10001 = methodObject3748;
      this.delegate.setPhysicalConnectionOf(arg0 instanceof _Proxy_ ? (Connection)((_Proxy_)arg0)._getDelegate_() : arg0);
      this.postForAll(var10001);
   }

   public OracleRef _getDelegate_() {
      return this.delegate;
   }

   public Object getDelegate() {
      return this.delegate;
   }

   public void setDelegate(Object delegate) {
      this.proxyFactory.updateDelegate(this, this.delegate, delegate);
      this.delegate = (OracleRef)delegate;
   }

   public Object getCreator() {
      return this.creator;
   }

   static {
      try {
         methodObject3744 = OracleDatumWithConnection.class.getDeclaredMethod("stringValue", Connection.class);
         methodObject3747 = OracleDatumWithConnection.class.getDeclaredMethod("getInternalConnection");
         methodObject3717 = OracleRef.class.getDeclaredMethod("getDescriptor");
         methodObject3741 = OracleDatumWithConnection.class.getDeclaredMethod("setShareBytes", byte[].class);
         methodObject3754 = Ref.class.getDeclaredMethod("getObject");
         methodObject3753 = Ref.class.getDeclaredMethod("getObject", Map.class);
         methodObject3719 = OracleRef.class.getDeclaredMethod("setValue", Object.class);
         methodObject3756 = Ref.class.getDeclaredMethod("setObject", Object.class);
         methodObject3721 = OracleRef.class.getDeclaredMethod("makeJdbcArray", Integer.TYPE);
         methodObject3749 = OracleDatumWithConnection.class.getDeclaredMethod("getJavaSqlConnection");
         methodObject3731 = OracleDatumWithConnection.class.getDeclaredMethod("getBytes");
         methodObject3725 = OracleDatumWithConnection.class.getDeclaredMethod("booleanValue");
         methodObject3718 = OracleRef.class.getDeclaredMethod("isConvertibleTo", Class.class);
         methodObject3740 = OracleDatumWithConnection.class.getDeclaredMethod("binaryStreamValue");
         methodObject3722 = OracleRef.class.getDeclaredMethod("getSQLTypeName");
         methodObject3736 = OracleDatumWithConnection.class.getDeclaredMethod("timestampValue");
         methodObject3757 = ACProxyable.class.getDeclaredMethod("setACProxy", Object.class);
         methodObject3727 = OracleDatumWithConnection.class.getDeclaredMethod("intValue");
         methodObject3758 = ACProxyable.class.getDeclaredMethod("getACProxy");
         methodObject3750 = OracleDatumWithConnection.class.getDeclaredMethod("getOracleConnection");
         methodObject3743 = OracleDatumWithConnection.class.getDeclaredMethod("stringValue");
         methodObject3715 = OracleRef.class.getDeclaredMethod("getValue", Map.class);
         methodObject3720 = OracleRef.class.getDeclaredMethod("toJdbc");
         methodObject3735 = OracleDatumWithConnection.class.getDeclaredMethod("timeValue", Calendar.class);
         methodObject3755 = Ref.class.getDeclaredMethod("getBaseTypeName");
         methodObject3737 = OracleDatumWithConnection.class.getDeclaredMethod("timestampValue", Calendar.class);
         methodObject3739 = OracleDatumWithConnection.class.getDeclaredMethod("asciiStreamValue");
         methodObject3716 = OracleRef.class.getDeclaredMethod("getValue");
         methodObject3746 = OracleDatumWithConnection.class.getDeclaredMethod("dateValue");
         methodObject3732 = OracleDatumWithConnection.class.getDeclaredMethod("shareBytes");
         methodObject3723 = OracleRef.class.getDeclaredMethod("getSTRUCT");
         methodObject3730 = OracleDatumWithConnection.class.getDeclaredMethod("doubleValue");
         methodObject3745 = OracleDatumWithConnection.class.getDeclaredMethod("bigDecimalValue");
         methodObject3733 = OracleDatumWithConnection.class.getDeclaredMethod("setBytes", byte[].class);
         methodObject3752 = oracle.jdbc.OracleRef.class.getDeclaredMethod("getOracleMetaData");
         methodObject3728 = OracleDatumWithConnection.class.getDeclaredMethod("longValue");
         methodObject3726 = OracleDatumWithConnection.class.getDeclaredMethod("byteValue");
         methodObject3729 = OracleDatumWithConnection.class.getDeclaredMethod("floatValue");
         methodObject3738 = OracleDatumWithConnection.class.getDeclaredMethod("characterStreamValue");
         methodObject3742 = OracleDatumWithConnection.class.getDeclaredMethod("getStream");
         methodObject3724 = OracleDatumWithConnection.class.getDeclaredMethod("getLength");
         methodObject3734 = OracleDatumWithConnection.class.getDeclaredMethod("timeValue");
         methodObject3751 = OracleDatumWithConnection.class.getDeclaredMethod("getConnection");
         methodObject3748 = OracleDatumWithConnection.class.getDeclaredMethod("setPhysicalConnectionOf", Connection.class);
      } catch (Throwable var1) {
         throw new RuntimeException(var1);
      }
   }

   public oracle$1jdbc$1replay$1driver$1TxnReplayableRef$2oracle$1jdbc$1internal$1OracleRef$$$Proxy(OracleRef var1, Object var2, ProxyFactory var3, Map var4) {
      this.delegate = var1;
      this.creator = var2;
      this.proxyFactory = var3;
      this.proxyCache = var4;
   }
}
