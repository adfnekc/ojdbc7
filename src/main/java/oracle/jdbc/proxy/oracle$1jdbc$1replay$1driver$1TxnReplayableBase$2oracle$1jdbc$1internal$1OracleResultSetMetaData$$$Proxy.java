package oracle.jdbc.proxy;

import java.lang.reflect.Method;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Wrapper;
import java.util.Map;
import oracle.jdbc.internal.ACProxyable;
import oracle.jdbc.internal.OracleResultSetMetaData;
import oracle.jdbc.replay.driver.TxnReplayableBase;

public class oracle$1jdbc$1replay$1driver$1TxnReplayableBase$2oracle$1jdbc$1internal$1OracleResultSetMetaData$$$Proxy extends TxnReplayableBase implements OracleResultSetMetaData, _Proxy_ {
   private OracleResultSetMetaData delegate;
   private final Object creator;
   private final ProxyFactory proxyFactory;
   private final Map proxyCache;
   private static Object[] zeroLengthObjectArray = new Object[0];
   private static Method methodObject4960;
   private static Method methodObject4956;
   private static Method methodObject4959;
   private static Method methodObject4979;
   private static Method methodObject4975;
   private static Method methodObject4957;
   private static Method methodObject4971;
   private static Method methodObject4982;
   private static Method methodObject4969;
   private static Method methodObject4977;
   private static Method methodObject4974;
   private static Method methodObject4965;
   private static Method methodObject4973;
   private static Method methodObject4968;
   private static Method methodObject4983;
   private static Method methodObject4984;
   private static Method methodObject4962;
   private static Method methodObject4961;
   private static Method methodObject4972;
   private static Method methodObject4958;
   private static Method methodObject4964;
   private static Method methodObject4963;
   private static Method methodObject4970;
   private static Method methodObject4976;
   private static Method methodObject4980;
   private static Method methodObject4966;
   private static Method methodObject4978;
   private static Method methodObject4967;
   private static Method methodObject4981;

   public boolean isReadOnly(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject4960, this, arg0);
         return (Boolean)this.postForAll(methodObject4960, this.delegate.isReadOnly(arg0));
      } catch (SQLException var3) {
         return (Boolean)this.postForAll(methodObject4960, this.onErrorForAll(methodObject4960, var3));
      }
   }

   public boolean isNCHAR(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject4956, this, arg0);
         return (Boolean)this.postForAll(methodObject4956, this.delegate.isNCHAR(arg0));
      } catch (SQLException var3) {
         return (Boolean)this.postForAll(methodObject4956, this.onErrorForAll(methodObject4956, var3));
      }
   }

   public boolean isVariableScale(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject4959, this, arg0);
         return (Boolean)this.postForAll(methodObject4959, this.delegate.isVariableScale(arg0));
      } catch (SQLException var3) {
         return (Boolean)this.postForAll(methodObject4959, this.onErrorForAll(methodObject4959, var3));
      }
   }

   public int getPrecision(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject4979, this, arg0);
         return (Integer)this.postForAll(methodObject4979, this.delegate.getPrecision(arg0));
      } catch (SQLException var3) {
         return (Integer)this.postForAll(methodObject4979, this.onErrorForAll(methodObject4979, var3));
      }
   }

   public boolean isCaseSensitive(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject4975, this, arg0);
         return (Boolean)this.postForAll(methodObject4975, this.delegate.isCaseSensitive(arg0));
      } catch (SQLException var3) {
         return (Boolean)this.postForAll(methodObject4975, this.onErrorForAll(methodObject4975, var3));
      }
   }

   public oracle.jdbc.OracleResultSetMetaData.SecurityAttribute getSecurityAttribute(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject4957, this, arg0);
         return (oracle.jdbc.OracleResultSetMetaData.SecurityAttribute)this.postForAll(methodObject4957, (Object)this.delegate.getSecurityAttribute(arg0));
      } catch (SQLException var3) {
         return (oracle.jdbc.OracleResultSetMetaData.SecurityAttribute)this.postForAll(methodObject4957, this.onErrorForAll(methodObject4957, var3));
      }
   }

   public int getColumnDisplaySize(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject4971, this, arg0);
         return (Integer)this.postForAll(methodObject4971, this.delegate.getColumnDisplaySize(arg0));
      } catch (SQLException var3) {
         return (Integer)this.postForAll(methodObject4971, this.onErrorForAll(methodObject4971, var3));
      }
   }

   public boolean isWrapperFor(Class arg0) throws SQLException {
      try {
         super.preForAll(methodObject4982, this, arg0);
         return (Boolean)this.postForAll(methodObject4982, this.delegate.isWrapperFor(arg0));
      } catch (SQLException var3) {
         return (Boolean)this.postForAll(methodObject4982, this.onErrorForAll(methodObject4982, var3));
      }
   }

   public int isNullable(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject4969, this, arg0);
         return (Integer)this.postForAll(methodObject4969, this.delegate.isNullable(arg0));
      } catch (SQLException var3) {
         return (Integer)this.postForAll(methodObject4969, this.onErrorForAll(methodObject4969, var3));
      }
   }

   public boolean isSigned(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject4977, this, arg0);
         return (Boolean)this.postForAll(methodObject4977, this.delegate.isSigned(arg0));
      } catch (SQLException var3) {
         return (Boolean)this.postForAll(methodObject4977, this.onErrorForAll(methodObject4977, var3));
      }
   }

   public boolean isAutoIncrement(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject4974, this, arg0);
         return (Boolean)this.postForAll(methodObject4974, this.delegate.isAutoIncrement(arg0));
      } catch (SQLException var3) {
         return (Boolean)this.postForAll(methodObject4974, this.onErrorForAll(methodObject4974, var3));
      }
   }

   public String getTableName(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject4965, this, arg0);
         return (String)this.postForAll(methodObject4965, (Object)this.delegate.getTableName(arg0));
      } catch (SQLException var3) {
         return (String)this.postForAll(methodObject4965, this.onErrorForAll(methodObject4965, var3));
      }
   }

   public String getColumnName(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject4973, this, arg0);
         return (String)this.postForAll(methodObject4973, (Object)this.delegate.getColumnName(arg0));
      } catch (SQLException var3) {
         return (String)this.postForAll(methodObject4973, this.onErrorForAll(methodObject4973, var3));
      }
   }

   public String getColumnClassName(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject4968, this, arg0);
         return (String)this.postForAll(methodObject4968, (Object)this.delegate.getColumnClassName(arg0));
      } catch (SQLException var3) {
         return (String)this.postForAll(methodObject4968, this.onErrorForAll(methodObject4968, var3));
      }
   }

   public void setACProxy(Object arg0) {
      super.preForAll(methodObject4983, this, arg0);
      Method var10001 = methodObject4983;
      this.delegate.setACProxy(arg0 instanceof _Proxy_ ? (Object)((_Proxy_)arg0)._getDelegate_() : arg0);
      this.postForAll(var10001);
   }

   public Object getACProxy() {
      super.preForAll(methodObject4984, this, zeroLengthObjectArray);
      return this.postForAll(methodObject4984, this.proxyFactory.proxyForCache(this.delegate.getACProxy(), this, this.proxyCache, methodObject4984));
   }

   public int getColumnCount() throws SQLException {
      try {
         super.preForAll(methodObject4962, this, zeroLengthObjectArray);
         return (Integer)this.postForAll(methodObject4962, this.delegate.getColumnCount());
      } catch (SQLException var2) {
         return (Integer)this.postForAll(methodObject4962, this.onErrorForAll(methodObject4962, var2));
      }
   }

   public String getSchemaName(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject4961, this, arg0);
         return (String)this.postForAll(methodObject4961, (Object)this.delegate.getSchemaName(arg0));
      } catch (SQLException var3) {
         return (String)this.postForAll(methodObject4961, this.onErrorForAll(methodObject4961, var3));
      }
   }

   public String getColumnLabel(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject4972, this, arg0);
         return (String)this.postForAll(methodObject4972, (Object)this.delegate.getColumnLabel(arg0));
      } catch (SQLException var3) {
         return (String)this.postForAll(methodObject4972, this.onErrorForAll(methodObject4972, var3));
      }
   }

   public boolean isColumnInvisible(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject4958, this, arg0);
         return (Boolean)this.postForAll(methodObject4958, this.delegate.isColumnInvisible(arg0));
      } catch (SQLException var3) {
         return (Boolean)this.postForAll(methodObject4958, this.onErrorForAll(methodObject4958, var3));
      }
   }

   public String getColumnTypeName(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject4964, this, arg0);
         return (String)this.postForAll(methodObject4964, (Object)this.delegate.getColumnTypeName(arg0));
      } catch (SQLException var3) {
         return (String)this.postForAll(methodObject4964, this.onErrorForAll(methodObject4964, var3));
      }
   }

   public int getColumnType(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject4963, this, arg0);
         return (Integer)this.postForAll(methodObject4963, this.delegate.getColumnType(arg0));
      } catch (SQLException var3) {
         return (Integer)this.postForAll(methodObject4963, this.onErrorForAll(methodObject4963, var3));
      }
   }

   public boolean isSearchable(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject4970, this, arg0);
         return (Boolean)this.postForAll(methodObject4970, this.delegate.isSearchable(arg0));
      } catch (SQLException var3) {
         return (Boolean)this.postForAll(methodObject4970, this.onErrorForAll(methodObject4970, var3));
      }
   }

   public boolean isDefinitelyWritable(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject4976, this, arg0);
         return (Boolean)this.postForAll(methodObject4976, this.delegate.isDefinitelyWritable(arg0));
      } catch (SQLException var3) {
         return (Boolean)this.postForAll(methodObject4976, this.onErrorForAll(methodObject4976, var3));
      }
   }

   public int getScale(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject4980, this, arg0);
         return (Integer)this.postForAll(methodObject4980, this.delegate.getScale(arg0));
      } catch (SQLException var3) {
         return (Integer)this.postForAll(methodObject4980, this.onErrorForAll(methodObject4980, var3));
      }
   }

   public boolean isCurrency(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject4966, this, arg0);
         return (Boolean)this.postForAll(methodObject4966, this.delegate.isCurrency(arg0));
      } catch (SQLException var3) {
         return (Boolean)this.postForAll(methodObject4966, this.onErrorForAll(methodObject4966, var3));
      }
   }

   public boolean isWritable(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject4978, this, arg0);
         return (Boolean)this.postForAll(methodObject4978, this.delegate.isWritable(arg0));
      } catch (SQLException var3) {
         return (Boolean)this.postForAll(methodObject4978, this.onErrorForAll(methodObject4978, var3));
      }
   }

   public String getCatalogName(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject4967, this, arg0);
         return (String)this.postForAll(methodObject4967, (Object)this.delegate.getCatalogName(arg0));
      } catch (SQLException var3) {
         return (String)this.postForAll(methodObject4967, this.onErrorForAll(methodObject4967, var3));
      }
   }

   public Object unwrap(Class arg0) throws SQLException {
      try {
         super.preForAll(methodObject4981, this, arg0);
         return this.postForAll(methodObject4981, this.proxyFactory.proxyForCache(this.delegate.unwrap(arg0), this, this.proxyCache, methodObject4981));
      } catch (SQLException var3) {
         return this.postForAll(methodObject4981, this.onErrorForAll(methodObject4981, var3));
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
         methodObject4960 = ResultSetMetaData.class.getDeclaredMethod("isReadOnly", Integer.TYPE);
         methodObject4956 = oracle.jdbc.OracleResultSetMetaData.class.getDeclaredMethod("isNCHAR", Integer.TYPE);
         methodObject4959 = oracle.jdbc.OracleResultSetMetaData.class.getDeclaredMethod("isVariableScale", Integer.TYPE);
         methodObject4979 = ResultSetMetaData.class.getDeclaredMethod("getPrecision", Integer.TYPE);
         methodObject4975 = ResultSetMetaData.class.getDeclaredMethod("isCaseSensitive", Integer.TYPE);
         methodObject4957 = oracle.jdbc.OracleResultSetMetaData.class.getDeclaredMethod("getSecurityAttribute", Integer.TYPE);
         methodObject4971 = ResultSetMetaData.class.getDeclaredMethod("getColumnDisplaySize", Integer.TYPE);
         methodObject4982 = Wrapper.class.getDeclaredMethod("isWrapperFor", Class.class);
         methodObject4969 = ResultSetMetaData.class.getDeclaredMethod("isNullable", Integer.TYPE);
         methodObject4977 = ResultSetMetaData.class.getDeclaredMethod("isSigned", Integer.TYPE);
         methodObject4974 = ResultSetMetaData.class.getDeclaredMethod("isAutoIncrement", Integer.TYPE);
         methodObject4965 = ResultSetMetaData.class.getDeclaredMethod("getTableName", Integer.TYPE);
         methodObject4973 = ResultSetMetaData.class.getDeclaredMethod("getColumnName", Integer.TYPE);
         methodObject4968 = ResultSetMetaData.class.getDeclaredMethod("getColumnClassName", Integer.TYPE);
         methodObject4983 = ACProxyable.class.getDeclaredMethod("setACProxy", Object.class);
         methodObject4984 = ACProxyable.class.getDeclaredMethod("getACProxy");
         methodObject4962 = ResultSetMetaData.class.getDeclaredMethod("getColumnCount");
         methodObject4961 = ResultSetMetaData.class.getDeclaredMethod("getSchemaName", Integer.TYPE);
         methodObject4972 = ResultSetMetaData.class.getDeclaredMethod("getColumnLabel", Integer.TYPE);
         methodObject4958 = oracle.jdbc.OracleResultSetMetaData.class.getDeclaredMethod("isColumnInvisible", Integer.TYPE);
         methodObject4964 = ResultSetMetaData.class.getDeclaredMethod("getColumnTypeName", Integer.TYPE);
         methodObject4963 = ResultSetMetaData.class.getDeclaredMethod("getColumnType", Integer.TYPE);
         methodObject4970 = ResultSetMetaData.class.getDeclaredMethod("isSearchable", Integer.TYPE);
         methodObject4976 = ResultSetMetaData.class.getDeclaredMethod("isDefinitelyWritable", Integer.TYPE);
         methodObject4980 = ResultSetMetaData.class.getDeclaredMethod("getScale", Integer.TYPE);
         methodObject4966 = ResultSetMetaData.class.getDeclaredMethod("isCurrency", Integer.TYPE);
         methodObject4978 = ResultSetMetaData.class.getDeclaredMethod("isWritable", Integer.TYPE);
         methodObject4967 = ResultSetMetaData.class.getDeclaredMethod("getCatalogName", Integer.TYPE);
         methodObject4981 = Wrapper.class.getDeclaredMethod("unwrap", Class.class);
      } catch (Throwable var1) {
         throw new RuntimeException(var1);
      }
   }

   public oracle$1jdbc$1replay$1driver$1TxnReplayableBase$2oracle$1jdbc$1internal$1OracleResultSetMetaData$$$Proxy(OracleResultSetMetaData var1, Object var2, ProxyFactory var3, Map var4) {
      this.delegate = var1;
      this.creator = var2;
      this.proxyFactory = var3;
      this.proxyCache = var4;
   }
}
