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
import oracle.jdbc.OracleTypeMetaData;
import oracle.jdbc.internal.ACProxyable;
import oracle.jdbc.internal.OracleConnection;
import oracle.jdbc.internal.OracleDatumWithConnection;
import oracle.jdbc.internal.OracleOpaque;
import oracle.jdbc.replay.driver.NonTxnReplayableOpaque;
import oracle.sql.OpaqueDescriptor;

public abstract class oracle$1jdbc$1replay$1driver$1NonTxnReplayableOpaque$2oracle$1jdbc$1internal$1OracleOpaque$$$Proxy extends NonTxnReplayableOpaque implements OracleOpaque, _Proxy_ {
   private OracleOpaque delegate;
   private final Object creator;
   private final ProxyFactory proxyFactory;
   private final Map proxyCache;
   private static Object[] zeroLengthObjectArray = new Object[0];
   private static Method methodObject17871;
   private static Method methodObject17852;
   private static Method methodObject17855;
   private static Method methodObject17849;
   private static Method methodObject17858;
   private static Method methodObject17854;
   private static Method methodObject17885;
   private static Method methodObject17887;
   private static Method methodObject17845;
   private static Method methodObject17879;
   private static Method methodObject17860;
   private static Method methodObject17882;
   private static Method methodObject17873;
   private static Method methodObject17874;
   private static Method methodObject17867;
   private static Method methodObject17884;
   private static Method methodObject17869;
   private static Method methodObject17863;
   private static Method methodObject17856;
   private static Method methodObject17853;
   private static Method methodObject17861;
   private static Method methodObject17842;
   private static Method methodObject17880;
   private static Method methodObject17840;
   private static Method methodObject17865;
   private static Method methodObject17843;
   private static Method methodObject17864;
   private static Method methodObject17878;
   private static Method methodObject17868;
   private static Method methodObject17841;
   private static Method methodObject17881;
   private static Method methodObject17888;
   private static Method methodObject17846;
   private static Method methodObject17876;
   private static Method methodObject17870;
   private static Method methodObject17875;
   private static Method methodObject17850;
   private static Method methodObject17844;
   private static Method methodObject17886;
   private static Method methodObject17848;
   private static Method methodObject17847;
   private static Method methodObject17859;
   private static Method methodObject17862;
   private static Method methodObject17866;
   private static Method methodObject17851;
   private static Method methodObject17872;
   private static Method methodObject17857;
   private static Method methodObject17877;
   private static Method methodObject17883;

   public void setShareBytes(byte[] arg0) {
      super.preForAll(methodObject17871, this, arg0);
      this.delegate.setShareBytes(arg0);
   }

   public void setImage(byte[] arg0, long arg1, long arg2) throws SQLException {
      try {
         super.preForAll(methodObject17852, this, arg0, arg1, arg2);
         this.delegate.setImage(arg0, arg1, arg2);
      } catch (SQLException var7) {
         this.onErrorVoidForAll(methodObject17852, var7);
      }
   }

   public long getImageLength() {
      super.preForAll(methodObject17855, this, zeroLengthObjectArray);
      return (Long)this.postForAll(methodObject17855, this.delegate.getImageLength());
   }

   public Connection getJavaSqlConnection() throws SQLException {
      try {
         super.preForAll(methodObject17849, this, zeroLengthObjectArray);
         return (Connection)this.postForAll(methodObject17849, (Object)super.getJavaSqlConnection());
      } catch (SQLException var2) {
         return (Connection)this.postForAll(methodObject17849, this.onErrorForAll(methodObject17849, var2));
      }
   }

   public boolean booleanValue() throws SQLException {
      try {
         super.preForAll(methodObject17858, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject17858, this.delegate.booleanValue());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject17858, this.onErrorForAll(methodObject17858, var2));
      }
   }

   public long getImageOffset() {
      super.preForAll(methodObject17854, this, zeroLengthObjectArray);
      return (Long)this.postForAll(methodObject17854, this.delegate.getImageOffset());
   }

   public String getSQLTypeName() throws SQLException {
      try {
         super.preForAll(methodObject17885, this, zeroLengthObjectArray);
         return (String)this.postForAll(methodObject17885, (Object)this.delegate.getSQLTypeName());
      } catch (SQLException var2) {
         return (String)this.postForAll(methodObject17885, this.onErrorForAll(methodObject17885, var2));
      }
   }

   public void setACProxy(Object arg0) {
      super.preForAll(methodObject17887, this, arg0);
      this.delegate.setACProxy(arg0 instanceof _Proxy_ ? (Object)((_Proxy_)arg0)._getDelegate_() : arg0);
   }

   public Map getMap() {
      super.preForAll(methodObject17845, this, zeroLengthObjectArray);
      return (Map)this.postForAll(methodObject17845, (Object)this.delegate.getMap());
   }

   public Timestamp timestampValue() throws SQLException {
      try {
         super.preForAll(methodObject17879, this, zeroLengthObjectArray);
         return (Timestamp)this.postForAll(methodObject17879, (Object)this.delegate.timestampValue());
      } catch (SQLException var2) {
         return (Timestamp)this.postForAll(methodObject17879, this.onErrorForAll(methodObject17879, var2));
      }
   }

   public int intValue() throws SQLException {
      try {
         super.preForAll(methodObject17860, this, zeroLengthObjectArray);
         return (Integer)this.postForAll(methodObject17860, this.delegate.intValue());
      } catch (SQLException var2) {
         return (Integer)this.postForAll(methodObject17860, this.onErrorForAll(methodObject17860, var2));
      }
   }

   public void setPhysicalConnectionOf(Connection arg0) {
      super.preForAll(methodObject17882, this, arg0);
      this.delegate.setPhysicalConnectionOf(arg0 instanceof _Proxy_ ? (Connection)((_Proxy_)arg0)._getDelegate_() : arg0);
   }

   public String stringValue() throws SQLException {
      try {
         super.preForAll(methodObject17873, this, zeroLengthObjectArray);
         return (String)this.postForAll(methodObject17873, (Object)this.delegate.stringValue());
      } catch (SQLException var2) {
         return (String)this.postForAll(methodObject17873, this.onErrorForAll(methodObject17873, var2));
      }
   }

   public String stringValue(Connection arg0) throws SQLException {
      try {
         super.preForAll(methodObject17874, this, arg0);
         return (String)this.postForAll(methodObject17874, (Object)this.delegate.stringValue(arg0 instanceof _Proxy_ ? (Connection)((_Proxy_)arg0)._getDelegate_() : arg0));
      } catch (SQLException var3) {
         return (String)this.postForAll(methodObject17874, this.onErrorForAll(methodObject17874, var3));
      }
   }

   public InputStream asciiStreamValue() throws SQLException {
      try {
         super.preForAll(methodObject17867, this, zeroLengthObjectArray);
         return (InputStream)this.postForAll(methodObject17867, (Object)this.delegate.asciiStreamValue());
      } catch (SQLException var2) {
         return (InputStream)this.postForAll(methodObject17867, this.onErrorForAll(methodObject17867, var2));
      }
   }

   public Object getValue() throws SQLException {
      try {
         super.preForAll(methodObject17884, this, zeroLengthObjectArray);
         return this.postForAll(methodObject17884, this.proxyFactory.proxyForCache(this.delegate.getValue(), this, this.proxyCache, methodObject17884));
      } catch (SQLException var2) {
         return this.postForAll(methodObject17884, this.onErrorForAll(methodObject17884, var2));
      }
   }

   public byte[] shareBytes() {
      super.preForAll(methodObject17869, this, zeroLengthObjectArray);
      return (byte[])this.postForAll(methodObject17869, (Object)this.delegate.shareBytes());
   }

   public double doubleValue() throws SQLException {
      try {
         super.preForAll(methodObject17863, this, zeroLengthObjectArray);
         return (Double)this.postForAll(methodObject17863, this.delegate.doubleValue());
      } catch (SQLException var2) {
         return (Double)this.postForAll(methodObject17863, this.onErrorForAll(methodObject17863, var2));
      }
   }

   public void setDescriptor(OpaqueDescriptor arg0) {
      super.preForAll(methodObject17856, this, arg0);
      this.delegate.setDescriptor(arg0);
   }

   public void setImageLength(long arg0) throws SQLException {
      try {
         super.preForAll(methodObject17853, this, arg0);
         this.delegate.setImageLength(arg0);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject17853, var4);
      }
   }

   public long longValue() throws SQLException {
      try {
         super.preForAll(methodObject17861, this, zeroLengthObjectArray);
         return (Long)this.postForAll(methodObject17861, this.delegate.longValue());
      } catch (SQLException var2) {
         return (Long)this.postForAll(methodObject17861, this.onErrorForAll(methodObject17861, var2));
      }
   }

   public Object toClass(Class arg0, Map arg1) throws SQLException {
      try {
         super.preForAll(methodObject17842, this, arg0, arg1);
         return this.postForAll(methodObject17842, this.proxyFactory.proxyForCache(this.delegate.toClass(arg0, arg1), this, this.proxyCache, methodObject17842));
      } catch (SQLException var4) {
         return this.postForAll(methodObject17842, this.onErrorForAll(methodObject17842, var4));
      }
   }

   public Timestamp timestampValue(Calendar arg0) throws SQLException {
      try {
         super.preForAll(methodObject17880, this, arg0);
         return (Timestamp)this.postForAll(methodObject17880, (Object)this.delegate.timestampValue(arg0));
      } catch (SQLException var3) {
         return (Timestamp)this.postForAll(methodObject17880, this.onErrorForAll(methodObject17880, var3));
      }
   }

   public OpaqueDescriptor getDescriptor() throws SQLException {
      try {
         super.preForAll(methodObject17840, this, zeroLengthObjectArray);
         return (OpaqueDescriptor)this.postForAll(methodObject17840, (Object)this.delegate.getDescriptor());
      } catch (SQLException var2) {
         return (OpaqueDescriptor)this.postForAll(methodObject17840, this.onErrorForAll(methodObject17840, var2));
      }
   }

   public OracleConnection getInternalConnection() throws SQLException {
      try {
         super.preForAll(methodObject17865, this, zeroLengthObjectArray);
         return (OracleConnection)this.postForAll(methodObject17865, this.proxyFactory.proxyForCache((Object)this.delegate.getInternalConnection(), this, this.proxyCache, methodObject17865));
      } catch (SQLException var2) {
         return (OracleConnection)this.postForAll(methodObject17865, this.onErrorForAll(methodObject17865, var2));
      }
   }

   public boolean isConvertibleTo(Class arg0) {
      super.preForAll(methodObject17843, this, arg0);
      return (Boolean)this.postForAll(methodObject17843, this.delegate.isConvertibleTo(arg0));
   }

   public byte[] getBytes() {
      super.preForAll(methodObject17864, this, zeroLengthObjectArray);
      return (byte[])this.postForAll(methodObject17864, (Object)this.delegate.getBytes());
   }

   public Time timeValue(Calendar arg0) throws SQLException {
      try {
         super.preForAll(methodObject17878, this, arg0);
         return (Time)this.postForAll(methodObject17878, (Object)this.delegate.timeValue(arg0));
      } catch (SQLException var3) {
         return (Time)this.postForAll(methodObject17878, this.onErrorForAll(methodObject17878, var3));
      }
   }

   public InputStream binaryStreamValue() throws SQLException {
      try {
         super.preForAll(methodObject17868, this, zeroLengthObjectArray);
         return (InputStream)this.postForAll(methodObject17868, (Object)this.delegate.binaryStreamValue());
      } catch (SQLException var2) {
         return (InputStream)this.postForAll(methodObject17868, this.onErrorForAll(methodObject17868, var2));
      }
   }

   public Object toClass(Class arg0) throws SQLException {
      try {
         super.preForAll(methodObject17841, this, arg0);
         return this.postForAll(methodObject17841, this.proxyFactory.proxyForCache(this.delegate.toClass(arg0), this, this.proxyCache, methodObject17841));
      } catch (SQLException var3) {
         return this.postForAll(methodObject17841, this.onErrorForAll(methodObject17841, var3));
      }
   }

   public oracle.jdbc.OracleConnection getOracleConnection() throws SQLException {
      try {
         super.preForAll(methodObject17881, this, zeroLengthObjectArray);
         return (oracle.jdbc.OracleConnection)this.postForAll(methodObject17881, this.proxyFactory.proxyForCache((Object)this.delegate.getOracleConnection(), this, this.proxyCache, methodObject17881));
      } catch (SQLException var2) {
         return (oracle.jdbc.OracleConnection)this.postForAll(methodObject17881, this.onErrorForAll(methodObject17881, var2));
      }
   }

   public Object getACProxy() {
      super.preForAll(methodObject17888, this, zeroLengthObjectArray);
      return this.postForAll(methodObject17888, this.proxyFactory.proxyForCache(this.delegate.getACProxy(), this, this.proxyCache, methodObject17888));
   }

   public Object toJdbc() throws SQLException {
      try {
         super.preForAll(methodObject17846, this, zeroLengthObjectArray);
         return this.postForAll(methodObject17846, this.proxyFactory.proxyForCache(this.delegate.toJdbc(), this, this.proxyCache, methodObject17846));
      } catch (SQLException var2) {
         return this.postForAll(methodObject17846, this.onErrorForAll(methodObject17846, var2));
      }
   }

   public Date dateValue() throws SQLException {
      try {
         super.preForAll(methodObject17876, this, zeroLengthObjectArray);
         return (Date)this.postForAll(methodObject17876, (Object)this.delegate.dateValue());
      } catch (SQLException var2) {
         return (Date)this.postForAll(methodObject17876, this.onErrorForAll(methodObject17876, var2));
      }
   }

   public void setBytes(byte[] arg0) {
      super.preForAll(methodObject17870, this, arg0);
      this.delegate.setBytes(arg0);
   }

   public BigDecimal bigDecimalValue() throws SQLException {
      try {
         super.preForAll(methodObject17875, this, zeroLengthObjectArray);
         return (BigDecimal)this.postForAll(methodObject17875, (Object)this.delegate.bigDecimalValue());
      } catch (SQLException var2) {
         return (BigDecimal)this.postForAll(methodObject17875, this.onErrorForAll(methodObject17875, var2));
      }
   }

   public byte[] getBytesValue() throws SQLException {
      try {
         super.preForAll(methodObject17850, this, zeroLengthObjectArray);
         return (byte[])this.postForAll(methodObject17850, (Object)this.delegate.getBytesValue());
      } catch (SQLException var2) {
         return (byte[])this.postForAll(methodObject17850, this.onErrorForAll(methodObject17850, var2));
      }
   }

   public void setValue(byte[] arg0) throws SQLException {
      try {
         super.preForAll(methodObject17844, this, arg0);
         this.delegate.setValue(arg0);
      } catch (SQLException var3) {
         this.onErrorVoidForAll(methodObject17844, var3);
      }
   }

   public OracleTypeMetaData getOracleMetaData() throws SQLException {
      try {
         super.preForAll(methodObject17886, this, zeroLengthObjectArray);
         return (OracleTypeMetaData)this.postForAll(methodObject17886, this.proxyFactory.proxyForCache((Object)this.delegate.getOracleMetaData(), this, this.proxyCache, methodObject17886));
      } catch (SQLException var2) {
         return (OracleTypeMetaData)this.postForAll(methodObject17886, this.onErrorForAll(methodObject17886, var2));
      }
   }

   public Object makeJdbcArray(int arg0) {
      super.preForAll(methodObject17848, this, arg0);
      return this.postForAll(methodObject17848, this.proxyFactory.proxyForCache(this.delegate.makeJdbcArray(arg0), this, this.proxyCache, methodObject17848));
   }

   public Object toJdbc(Map arg0) throws SQLException {
      try {
         super.preForAll(methodObject17847, this, arg0);
         return this.postForAll(methodObject17847, this.proxyFactory.proxyForCache(this.delegate.toJdbc(arg0), this, this.proxyCache, methodObject17847));
      } catch (SQLException var3) {
         return this.postForAll(methodObject17847, this.onErrorForAll(methodObject17847, var3));
      }
   }

   public byte byteValue() throws SQLException {
      try {
         super.preForAll(methodObject17859, this, zeroLengthObjectArray);
         return (Byte)this.postForAll(methodObject17859, this.delegate.byteValue());
      } catch (SQLException var2) {
         return (Byte)this.postForAll(methodObject17859, this.onErrorForAll(methodObject17859, var2));
      }
   }

   public float floatValue() throws SQLException {
      try {
         super.preForAll(methodObject17862, this, zeroLengthObjectArray);
         return (Float)this.postForAll(methodObject17862, this.delegate.floatValue());
      } catch (SQLException var2) {
         return (Float)this.postForAll(methodObject17862, this.onErrorForAll(methodObject17862, var2));
      }
   }

   public Reader characterStreamValue() throws SQLException {
      try {
         super.preForAll(methodObject17866, this, zeroLengthObjectArray);
         return (Reader)this.postForAll(methodObject17866, (Object)this.delegate.characterStreamValue());
      } catch (SQLException var2) {
         return (Reader)this.postForAll(methodObject17866, this.onErrorForAll(methodObject17866, var2));
      }
   }

   public byte[] toBytes() throws SQLException {
      try {
         super.preForAll(methodObject17851, this, zeroLengthObjectArray);
         return (byte[])this.postForAll(methodObject17851, (Object)this.delegate.toBytes());
      } catch (SQLException var2) {
         return (byte[])this.postForAll(methodObject17851, this.onErrorForAll(methodObject17851, var2));
      }
   }

   public InputStream getStream() throws SQLException {
      try {
         super.preForAll(methodObject17872, this, zeroLengthObjectArray);
         return (InputStream)this.postForAll(methodObject17872, (Object)this.delegate.getStream());
      } catch (SQLException var2) {
         return (InputStream)this.postForAll(methodObject17872, this.onErrorForAll(methodObject17872, var2));
      }
   }

   public long getLength() {
      super.preForAll(methodObject17857, this, zeroLengthObjectArray);
      return (Long)this.postForAll(methodObject17857, this.delegate.getLength());
   }

   public Time timeValue() throws SQLException {
      try {
         super.preForAll(methodObject17877, this, zeroLengthObjectArray);
         return (Time)this.postForAll(methodObject17877, (Object)this.delegate.timeValue());
      } catch (SQLException var2) {
         return (Time)this.postForAll(methodObject17877, this.onErrorForAll(methodObject17877, var2));
      }
   }

   public oracle.jdbc.driver.OracleConnection getConnection() throws SQLException {
      try {
         super.preForAll(methodObject17883, this, zeroLengthObjectArray);
         return (oracle.jdbc.driver.OracleConnection)this.postForAll(methodObject17883, (Object)this.delegate.getConnection());
      } catch (SQLException var2) {
         return (oracle.jdbc.driver.OracleConnection)this.postForAll(methodObject17883, this.onErrorForAll(methodObject17883, var2));
      }
   }

   public OracleOpaque _getDelegate_() {
      return this.delegate;
   }

   public Object getDelegate() {
      return this.delegate;
   }

   public void setDelegate(Object delegate) {
      this.proxyFactory.updateDelegate(this, this.delegate, delegate);
      this.delegate = (OracleOpaque)delegate;
   }

   public Object getCreator() {
      return this.creator;
   }

   static {
      try {
         methodObject17871 = OracleDatumWithConnection.class.getDeclaredMethod("setShareBytes", byte[].class);
         methodObject17852 = OracleOpaque.class.getDeclaredMethod("setImage", byte[].class, Long.TYPE, Long.TYPE);
         methodObject17855 = OracleOpaque.class.getDeclaredMethod("getImageLength");
         methodObject17849 = OracleOpaque.class.getDeclaredMethod("getJavaSqlConnection");
         methodObject17858 = OracleDatumWithConnection.class.getDeclaredMethod("booleanValue");
         methodObject17854 = OracleOpaque.class.getDeclaredMethod("getImageOffset");
         methodObject17885 = oracle.jdbc.OracleOpaque.class.getDeclaredMethod("getSQLTypeName");
         methodObject17887 = ACProxyable.class.getDeclaredMethod("setACProxy", Object.class);
         methodObject17845 = OracleOpaque.class.getDeclaredMethod("getMap");
         methodObject17879 = OracleDatumWithConnection.class.getDeclaredMethod("timestampValue");
         methodObject17860 = OracleDatumWithConnection.class.getDeclaredMethod("intValue");
         methodObject17882 = OracleDatumWithConnection.class.getDeclaredMethod("setPhysicalConnectionOf", Connection.class);
         methodObject17873 = OracleDatumWithConnection.class.getDeclaredMethod("stringValue");
         methodObject17874 = OracleDatumWithConnection.class.getDeclaredMethod("stringValue", Connection.class);
         methodObject17867 = OracleDatumWithConnection.class.getDeclaredMethod("asciiStreamValue");
         methodObject17884 = oracle.jdbc.OracleOpaque.class.getDeclaredMethod("getValue");
         methodObject17869 = OracleDatumWithConnection.class.getDeclaredMethod("shareBytes");
         methodObject17863 = OracleDatumWithConnection.class.getDeclaredMethod("doubleValue");
         methodObject17856 = OracleOpaque.class.getDeclaredMethod("setDescriptor", OpaqueDescriptor.class);
         methodObject17853 = OracleOpaque.class.getDeclaredMethod("setImageLength", Long.TYPE);
         methodObject17861 = OracleDatumWithConnection.class.getDeclaredMethod("longValue");
         methodObject17842 = OracleOpaque.class.getDeclaredMethod("toClass", Class.class, Map.class);
         methodObject17880 = OracleDatumWithConnection.class.getDeclaredMethod("timestampValue", Calendar.class);
         methodObject17840 = OracleOpaque.class.getDeclaredMethod("getDescriptor");
         methodObject17865 = OracleDatumWithConnection.class.getDeclaredMethod("getInternalConnection");
         methodObject17843 = OracleOpaque.class.getDeclaredMethod("isConvertibleTo", Class.class);
         methodObject17864 = OracleDatumWithConnection.class.getDeclaredMethod("getBytes");
         methodObject17878 = OracleDatumWithConnection.class.getDeclaredMethod("timeValue", Calendar.class);
         methodObject17868 = OracleDatumWithConnection.class.getDeclaredMethod("binaryStreamValue");
         methodObject17841 = OracleOpaque.class.getDeclaredMethod("toClass", Class.class);
         methodObject17881 = OracleDatumWithConnection.class.getDeclaredMethod("getOracleConnection");
         methodObject17888 = ACProxyable.class.getDeclaredMethod("getACProxy");
         methodObject17846 = OracleOpaque.class.getDeclaredMethod("toJdbc");
         methodObject17876 = OracleDatumWithConnection.class.getDeclaredMethod("dateValue");
         methodObject17870 = OracleDatumWithConnection.class.getDeclaredMethod("setBytes", byte[].class);
         methodObject17875 = OracleDatumWithConnection.class.getDeclaredMethod("bigDecimalValue");
         methodObject17850 = OracleOpaque.class.getDeclaredMethod("getBytesValue");
         methodObject17844 = OracleOpaque.class.getDeclaredMethod("setValue", byte[].class);
         methodObject17886 = oracle.jdbc.OracleOpaque.class.getDeclaredMethod("getOracleMetaData");
         methodObject17848 = OracleOpaque.class.getDeclaredMethod("makeJdbcArray", Integer.TYPE);
         methodObject17847 = OracleOpaque.class.getDeclaredMethod("toJdbc", Map.class);
         methodObject17859 = OracleDatumWithConnection.class.getDeclaredMethod("byteValue");
         methodObject17862 = OracleDatumWithConnection.class.getDeclaredMethod("floatValue");
         methodObject17866 = OracleDatumWithConnection.class.getDeclaredMethod("characterStreamValue");
         methodObject17851 = OracleOpaque.class.getDeclaredMethod("toBytes");
         methodObject17872 = OracleDatumWithConnection.class.getDeclaredMethod("getStream");
         methodObject17857 = OracleDatumWithConnection.class.getDeclaredMethod("getLength");
         methodObject17877 = OracleDatumWithConnection.class.getDeclaredMethod("timeValue");
         methodObject17883 = OracleDatumWithConnection.class.getDeclaredMethod("getConnection");
      } catch (Throwable var1) {
         throw new RuntimeException(var1);
      }
   }

   public oracle$1jdbc$1replay$1driver$1NonTxnReplayableOpaque$2oracle$1jdbc$1internal$1OracleOpaque$$$Proxy(OracleOpaque var1, Object var2, ProxyFactory var3, Map var4) {
      this.delegate = var1;
      this.creator = var2;
      this.proxyFactory = var3;
      this.proxyCache = var4;
   }
}
