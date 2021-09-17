package oracle.jdbc.proxy;

import java.lang.reflect.Method;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Wrapper;
import java.util.Map;
import oracle.jdbc.internal.ACProxyable;
import oracle.jdbc.internal.OracleResultSetMetaData;
import oracle.jdbc.replay.driver.NonTxnReplayableBase;

public abstract class oracle$1jdbc$1replay$1driver$1NonTxnReplayableBase$2oracle$1jdbc$1internal$1OracleResultSetMetaData$$$Proxy extends NonTxnReplayableBase implements OracleResultSetMetaData, _Proxy_ {
   private OracleResultSetMetaData delegate;
   private final Object creator;
   private final ProxyFactory proxyFactory;
   private final Map proxyCache;
   private static Object[] zeroLengthObjectArray = new Object[0];
   private static Method methodObject30080;
   private static Method methodObject30088;
   private static Method methodObject30091;
   private static Method methodObject30075;
   private static Method methodObject30079;
   private static Method methodObject30074;
   private static Method methodObject30082;
   private static Method methodObject30083;
   private static Method methodObject30087;
   private static Method methodObject30090;
   private static Method methodObject30100;
   private static Method methodObject30099;
   private static Method methodObject30098;
   private static Method methodObject30076;
   private static Method methodObject30097;
   private static Method methodObject30101;
   private static Method methodObject30096;
   private static Method methodObject30085;
   private static Method methodObject30094;
   private static Method methodObject30077;
   private static Method methodObject30093;
   private static Method methodObject30081;
   private static Method methodObject30086;
   private static Method methodObject30095;
   private static Method methodObject30092;
   private static Method methodObject30089;
   private static Method methodObject30078;
   private static Method methodObject30073;
   private static Method methodObject30084;

   public int getScale(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject30080, this, arg0);
         return (Integer)this.postForAll(methodObject30080, this.delegate.getScale(arg0));
      } catch (SQLException var3) {
         return (Integer)this.postForAll(methodObject30080, this.onErrorForAll(methodObject30080, var3));
      }
   }

   public String getColumnName(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject30088, this, arg0);
         return (String)this.postForAll(methodObject30088, (Object)this.delegate.getColumnName(arg0));
      } catch (SQLException var3) {
         return (String)this.postForAll(methodObject30088, this.onErrorForAll(methodObject30088, var3));
      }
   }

   public String getSchemaName(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject30091, this, arg0);
         return (String)this.postForAll(methodObject30091, (Object)this.delegate.getSchemaName(arg0));
      } catch (SQLException var3) {
         return (String)this.postForAll(methodObject30091, this.onErrorForAll(methodObject30091, var3));
      }
   }

   public boolean isColumnInvisible(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject30075, this, arg0);
         return (Boolean)this.postForAll(methodObject30075, this.delegate.isColumnInvisible(arg0));
      } catch (SQLException var3) {
         return (Boolean)this.postForAll(methodObject30075, this.onErrorForAll(methodObject30075, var3));
      }
   }

   public String getCatalogName(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject30079, this, arg0);
         return (String)this.postForAll(methodObject30079, (Object)this.delegate.getCatalogName(arg0));
      } catch (SQLException var3) {
         return (String)this.postForAll(methodObject30079, this.onErrorForAll(methodObject30079, var3));
      }
   }

   public boolean isNCHAR(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject30074, this, arg0);
         return (Boolean)this.postForAll(methodObject30074, this.delegate.isNCHAR(arg0));
      } catch (SQLException var3) {
         return (Boolean)this.postForAll(methodObject30074, this.onErrorForAll(methodObject30074, var3));
      }
   }

   public boolean isSigned(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject30082, this, arg0);
         return (Boolean)this.postForAll(methodObject30082, this.delegate.isSigned(arg0));
      } catch (SQLException var3) {
         return (Boolean)this.postForAll(methodObject30082, this.onErrorForAll(methodObject30082, var3));
      }
   }

   public String getTableName(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject30083, this, arg0);
         return (String)this.postForAll(methodObject30083, (Object)this.delegate.getTableName(arg0));
      } catch (SQLException var3) {
         return (String)this.postForAll(methodObject30083, this.onErrorForAll(methodObject30083, var3));
      }
   }

   public String getColumnLabel(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject30087, this, arg0);
         return (String)this.postForAll(methodObject30087, (Object)this.delegate.getColumnLabel(arg0));
      } catch (SQLException var3) {
         return (String)this.postForAll(methodObject30087, this.onErrorForAll(methodObject30087, var3));
      }
   }

   public String getColumnTypeName(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject30090, this, arg0);
         return (String)this.postForAll(methodObject30090, (Object)this.delegate.getColumnTypeName(arg0));
      } catch (SQLException var3) {
         return (String)this.postForAll(methodObject30090, this.onErrorForAll(methodObject30090, var3));
      }
   }

   public void setACProxy(Object arg0) {
      super.preForAll(methodObject30100, this, arg0);
      Method var10001 = methodObject30100;
      this.delegate.setACProxy(arg0 instanceof _Proxy_ ? (Object)((_Proxy_)arg0)._getDelegate_() : arg0);
      this.postForAll(var10001);
   }

   public boolean isWrapperFor(Class arg0) throws SQLException {
      try {
         super.preForAll(methodObject30099, this, arg0);
         return (Boolean)this.postForAll(methodObject30099, this.delegate.isWrapperFor(arg0));
      } catch (SQLException var3) {
         return (Boolean)this.postForAll(methodObject30099, this.onErrorForAll(methodObject30099, var3));
      }
   }

   public Object unwrap(Class arg0) throws SQLException {
      try {
         super.preForAll(methodObject30098, this, arg0);
         return this.postForAll(methodObject30098, this.proxyFactory.proxyForCache(this.delegate.unwrap(arg0), this, this.proxyCache, methodObject30098));
      } catch (SQLException var3) {
         return this.postForAll(methodObject30098, this.onErrorForAll(methodObject30098, var3));
      }
   }

   public boolean isVariableScale(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject30076, this, arg0);
         return (Boolean)this.postForAll(methodObject30076, this.delegate.isVariableScale(arg0));
      } catch (SQLException var3) {
         return (Boolean)this.postForAll(methodObject30076, this.onErrorForAll(methodObject30076, var3));
      }
   }

   public boolean isWritable(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject30097, this, arg0);
         return (Boolean)this.postForAll(methodObject30097, this.delegate.isWritable(arg0));
      } catch (SQLException var3) {
         return (Boolean)this.postForAll(methodObject30097, this.onErrorForAll(methodObject30097, var3));
      }
   }

   public Object getACProxy() {
      super.preForAll(methodObject30101, this, zeroLengthObjectArray);
      return this.postForAll(methodObject30101, this.proxyFactory.proxyForCache(this.delegate.getACProxy(), this, this.proxyCache, methodObject30101));
   }

   public boolean isSearchable(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject30096, this, arg0);
         return (Boolean)this.postForAll(methodObject30096, this.delegate.isSearchable(arg0));
      } catch (SQLException var3) {
         return (Boolean)this.postForAll(methodObject30096, this.onErrorForAll(methodObject30096, var3));
      }
   }

   public int getColumnCount() throws SQLException {
      try {
         super.preForAll(methodObject30085, this, zeroLengthObjectArray);
         return (Integer)this.postForAll(methodObject30085, this.delegate.getColumnCount());
      } catch (SQLException var2) {
         return (Integer)this.postForAll(methodObject30085, this.onErrorForAll(methodObject30085, var2));
      }
   }

   public boolean isCurrency(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject30094, this, arg0);
         return (Boolean)this.postForAll(methodObject30094, this.delegate.isCurrency(arg0));
      } catch (SQLException var3) {
         return (Boolean)this.postForAll(methodObject30094, this.onErrorForAll(methodObject30094, var3));
      }
   }

   public boolean isReadOnly(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject30077, this, arg0);
         return (Boolean)this.postForAll(methodObject30077, this.delegate.isReadOnly(arg0));
      } catch (SQLException var3) {
         return (Boolean)this.postForAll(methodObject30077, this.onErrorForAll(methodObject30077, var3));
      }
   }

   public boolean isCaseSensitive(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject30093, this, arg0);
         return (Boolean)this.postForAll(methodObject30093, this.delegate.isCaseSensitive(arg0));
      } catch (SQLException var3) {
         return (Boolean)this.postForAll(methodObject30093, this.onErrorForAll(methodObject30093, var3));
      }
   }

   public int isNullable(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject30081, this, arg0);
         return (Integer)this.postForAll(methodObject30081, this.delegate.isNullable(arg0));
      } catch (SQLException var3) {
         return (Integer)this.postForAll(methodObject30081, this.onErrorForAll(methodObject30081, var3));
      }
   }

   public int getColumnDisplaySize(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject30086, this, arg0);
         return (Integer)this.postForAll(methodObject30086, this.delegate.getColumnDisplaySize(arg0));
      } catch (SQLException var3) {
         return (Integer)this.postForAll(methodObject30086, this.onErrorForAll(methodObject30086, var3));
      }
   }

   public boolean isDefinitelyWritable(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject30095, this, arg0);
         return (Boolean)this.postForAll(methodObject30095, this.delegate.isDefinitelyWritable(arg0));
      } catch (SQLException var3) {
         return (Boolean)this.postForAll(methodObject30095, this.onErrorForAll(methodObject30095, var3));
      }
   }

   public boolean isAutoIncrement(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject30092, this, arg0);
         return (Boolean)this.postForAll(methodObject30092, this.delegate.isAutoIncrement(arg0));
      } catch (SQLException var3) {
         return (Boolean)this.postForAll(methodObject30092, this.onErrorForAll(methodObject30092, var3));
      }
   }

   public int getColumnType(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject30089, this, arg0);
         return (Integer)this.postForAll(methodObject30089, this.delegate.getColumnType(arg0));
      } catch (SQLException var3) {
         return (Integer)this.postForAll(methodObject30089, this.onErrorForAll(methodObject30089, var3));
      }
   }

   public int getPrecision(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject30078, this, arg0);
         return (Integer)this.postForAll(methodObject30078, this.delegate.getPrecision(arg0));
      } catch (SQLException var3) {
         return (Integer)this.postForAll(methodObject30078, this.onErrorForAll(methodObject30078, var3));
      }
   }

   public oracle.jdbc.OracleResultSetMetaData.SecurityAttribute getSecurityAttribute(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject30073, this, arg0);
         return (oracle.jdbc.OracleResultSetMetaData.SecurityAttribute)this.postForAll(methodObject30073, (Object)this.delegate.getSecurityAttribute(arg0));
      } catch (SQLException var3) {
         return (oracle.jdbc.OracleResultSetMetaData.SecurityAttribute)this.postForAll(methodObject30073, this.onErrorForAll(methodObject30073, var3));
      }
   }

   public String getColumnClassName(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject30084, this, arg0);
         return (String)this.postForAll(methodObject30084, (Object)this.delegate.getColumnClassName(arg0));
      } catch (SQLException var3) {
         return (String)this.postForAll(methodObject30084, this.onErrorForAll(methodObject30084, var3));
      }
   }

   public OracleResultSetMetaData _getDelegate_() {
      return this.delegate;
   }

   public Object getDelegate() {
      return this.delegate;
   }

   public void setDelegate(Object delegate) {
      this.proxyFactory.updateDelegate(this, this.delegate, delegate);
      this.delegate = (OracleResultSetMetaData)delegate;
   }

   public Object getCreator() {
      return this.creator;
   }

   static {
      try {
         methodObject30080 = ResultSetMetaData.class.getDeclaredMethod("getScale", Integer.TYPE);
         methodObject30088 = ResultSetMetaData.class.getDeclaredMethod("getColumnName", Integer.TYPE);
         methodObject30091 = ResultSetMetaData.class.getDeclaredMethod("getSchemaName", Integer.TYPE);
         methodObject30075 = oracle.jdbc.OracleResultSetMetaData.class.getDeclaredMethod("isColumnInvisible", Integer.TYPE);
         methodObject30079 = ResultSetMetaData.class.getDeclaredMethod("getCatalogName", Integer.TYPE);
         methodObject30074 = oracle.jdbc.OracleResultSetMetaData.class.getDeclaredMethod("isNCHAR", Integer.TYPE);
         methodObject30082 = ResultSetMetaData.class.getDeclaredMethod("isSigned", Integer.TYPE);
         methodObject30083 = ResultSetMetaData.class.getDeclaredMethod("getTableName", Integer.TYPE);
         methodObject30087 = ResultSetMetaData.class.getDeclaredMethod("getColumnLabel", Integer.TYPE);
         methodObject30090 = ResultSetMetaData.class.getDeclaredMethod("getColumnTypeName", Integer.TYPE);
         methodObject30100 = ACProxyable.class.getDeclaredMethod("setACProxy", Object.class);
         methodObject30099 = Wrapper.class.getDeclaredMethod("isWrapperFor", Class.class);
         methodObject30098 = Wrapper.class.getDeclaredMethod("unwrap", Class.class);
         methodObject30076 = oracle.jdbc.OracleResultSetMetaData.class.getDeclaredMethod("isVariableScale", Integer.TYPE);
         methodObject30097 = ResultSetMetaData.class.getDeclaredMethod("isWritable", Integer.TYPE);
         methodObject30101 = ACProxyable.class.getDeclaredMethod("getACProxy");
         methodObject30096 = ResultSetMetaData.class.getDeclaredMethod("isSearchable", Integer.TYPE);
         methodObject30085 = ResultSetMetaData.class.getDeclaredMethod("getColumnCount");
         methodObject30094 = ResultSetMetaData.class.getDeclaredMethod("isCurrency", Integer.TYPE);
         methodObject30077 = ResultSetMetaData.class.getDeclaredMethod("isReadOnly", Integer.TYPE);
         methodObject30093 = ResultSetMetaData.class.getDeclaredMethod("isCaseSensitive", Integer.TYPE);
         methodObject30081 = ResultSetMetaData.class.getDeclaredMethod("isNullable", Integer.TYPE);
         methodObject30086 = ResultSetMetaData.class.getDeclaredMethod("getColumnDisplaySize", Integer.TYPE);
         methodObject30095 = ResultSetMetaData.class.getDeclaredMethod("isDefinitelyWritable", Integer.TYPE);
         methodObject30092 = ResultSetMetaData.class.getDeclaredMethod("isAutoIncrement", Integer.TYPE);
         methodObject30089 = ResultSetMetaData.class.getDeclaredMethod("getColumnType", Integer.TYPE);
         methodObject30078 = ResultSetMetaData.class.getDeclaredMethod("getPrecision", Integer.TYPE);
         methodObject30073 = oracle.jdbc.OracleResultSetMetaData.class.getDeclaredMethod("getSecurityAttribute", Integer.TYPE);
         methodObject30084 = ResultSetMetaData.class.getDeclaredMethod("getColumnClassName", Integer.TYPE);
      } catch (Throwable var1) {
         throw new RuntimeException(var1);
      }
   }

   public oracle$1jdbc$1replay$1driver$1NonTxnReplayableBase$2oracle$1jdbc$1internal$1OracleResultSetMetaData$$$Proxy(OracleResultSetMetaData var1, Object var2, ProxyFactory var3, Map var4) {
      this.delegate = var1;
      this.creator = var2;
      this.proxyFactory = var3;
      this.proxyCache = var4;
   }
}
