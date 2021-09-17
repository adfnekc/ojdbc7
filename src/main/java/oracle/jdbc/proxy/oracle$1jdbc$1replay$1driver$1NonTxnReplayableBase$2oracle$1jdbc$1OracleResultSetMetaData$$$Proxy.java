package oracle.jdbc.proxy;

import java.lang.reflect.Method;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Wrapper;
import java.util.Map;
import oracle.jdbc.OracleResultSetMetaData;
import oracle.jdbc.replay.driver.NonTxnReplayableBase;

public abstract class oracle$1jdbc$1replay$1driver$1NonTxnReplayableBase$2oracle$1jdbc$1OracleResultSetMetaData$$$Proxy extends NonTxnReplayableBase implements OracleResultSetMetaData, _Proxy_ {
   private OracleResultSetMetaData delegate;
   private final Object creator;
   private final ProxyFactory proxyFactory;
   private final Map proxyCache;
   private static Object[] zeroLengthObjectArray = new Object[0];
   private static Method methodObject30011;
   private static Method methodObject30019;
   private static Method methodObject30022;
   private static Method methodObject30006;
   private static Method methodObject30010;
   private static Method methodObject30005;
   private static Method methodObject30013;
   private static Method methodObject30014;
   private static Method methodObject30018;
   private static Method methodObject30021;
   private static Method methodObject30030;
   private static Method methodObject30029;
   private static Method methodObject30007;
   private static Method methodObject30028;
   private static Method methodObject30027;
   private static Method methodObject30016;
   private static Method methodObject30025;
   private static Method methodObject30008;
   private static Method methodObject30024;
   private static Method methodObject30012;
   private static Method methodObject30017;
   private static Method methodObject30026;
   private static Method methodObject30023;
   private static Method methodObject30020;
   private static Method methodObject30009;
   private static Method methodObject30004;
   private static Method methodObject30015;

   public int getScale(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject30011, this, arg0);
         return (Integer)this.postForAll(methodObject30011, this.delegate.getScale(arg0));
      } catch (SQLException var3) {
         return (Integer)this.postForAll(methodObject30011, this.onErrorForAll(methodObject30011, var3));
      }
   }

   public String getColumnName(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject30019, this, arg0);
         return (String)this.postForAll(methodObject30019, (Object)this.delegate.getColumnName(arg0));
      } catch (SQLException var3) {
         return (String)this.postForAll(methodObject30019, this.onErrorForAll(methodObject30019, var3));
      }
   }

   public String getSchemaName(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject30022, this, arg0);
         return (String)this.postForAll(methodObject30022, (Object)this.delegate.getSchemaName(arg0));
      } catch (SQLException var3) {
         return (String)this.postForAll(methodObject30022, this.onErrorForAll(methodObject30022, var3));
      }
   }

   public boolean isColumnInvisible(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject30006, this, arg0);
         return (Boolean)this.postForAll(methodObject30006, this.delegate.isColumnInvisible(arg0));
      } catch (SQLException var3) {
         return (Boolean)this.postForAll(methodObject30006, this.onErrorForAll(methodObject30006, var3));
      }
   }

   public String getCatalogName(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject30010, this, arg0);
         return (String)this.postForAll(methodObject30010, (Object)this.delegate.getCatalogName(arg0));
      } catch (SQLException var3) {
         return (String)this.postForAll(methodObject30010, this.onErrorForAll(methodObject30010, var3));
      }
   }

   public boolean isNCHAR(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject30005, this, arg0);
         return (Boolean)this.postForAll(methodObject30005, this.delegate.isNCHAR(arg0));
      } catch (SQLException var3) {
         return (Boolean)this.postForAll(methodObject30005, this.onErrorForAll(methodObject30005, var3));
      }
   }

   public boolean isSigned(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject30013, this, arg0);
         return (Boolean)this.postForAll(methodObject30013, this.delegate.isSigned(arg0));
      } catch (SQLException var3) {
         return (Boolean)this.postForAll(methodObject30013, this.onErrorForAll(methodObject30013, var3));
      }
   }

   public String getTableName(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject30014, this, arg0);
         return (String)this.postForAll(methodObject30014, (Object)this.delegate.getTableName(arg0));
      } catch (SQLException var3) {
         return (String)this.postForAll(methodObject30014, this.onErrorForAll(methodObject30014, var3));
      }
   }

   public String getColumnLabel(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject30018, this, arg0);
         return (String)this.postForAll(methodObject30018, (Object)this.delegate.getColumnLabel(arg0));
      } catch (SQLException var3) {
         return (String)this.postForAll(methodObject30018, this.onErrorForAll(methodObject30018, var3));
      }
   }

   public String getColumnTypeName(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject30021, this, arg0);
         return (String)this.postForAll(methodObject30021, (Object)this.delegate.getColumnTypeName(arg0));
      } catch (SQLException var3) {
         return (String)this.postForAll(methodObject30021, this.onErrorForAll(methodObject30021, var3));
      }
   }

   public boolean isWrapperFor(Class arg0) throws SQLException {
      try {
         super.preForAll(methodObject30030, this, arg0);
         return (Boolean)this.postForAll(methodObject30030, this.delegate.isWrapperFor(arg0));
      } catch (SQLException var3) {
         return (Boolean)this.postForAll(methodObject30030, this.onErrorForAll(methodObject30030, var3));
      }
   }

   public Object unwrap(Class arg0) throws SQLException {
      try {
         super.preForAll(methodObject30029, this, arg0);
         return this.postForAll(methodObject30029, this.proxyFactory.proxyForCache(this.delegate.unwrap(arg0), this, this.proxyCache, methodObject30029));
      } catch (SQLException var3) {
         return this.postForAll(methodObject30029, this.onErrorForAll(methodObject30029, var3));
      }
   }

   public boolean isVariableScale(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject30007, this, arg0);
         return (Boolean)this.postForAll(methodObject30007, this.delegate.isVariableScale(arg0));
      } catch (SQLException var3) {
         return (Boolean)this.postForAll(methodObject30007, this.onErrorForAll(methodObject30007, var3));
      }
   }

   public boolean isWritable(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject30028, this, arg0);
         return (Boolean)this.postForAll(methodObject30028, this.delegate.isWritable(arg0));
      } catch (SQLException var3) {
         return (Boolean)this.postForAll(methodObject30028, this.onErrorForAll(methodObject30028, var3));
      }
   }

   public boolean isSearchable(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject30027, this, arg0);
         return (Boolean)this.postForAll(methodObject30027, this.delegate.isSearchable(arg0));
      } catch (SQLException var3) {
         return (Boolean)this.postForAll(methodObject30027, this.onErrorForAll(methodObject30027, var3));
      }
   }

   public int getColumnCount() throws SQLException {
      try {
         super.preForAll(methodObject30016, this, zeroLengthObjectArray);
         return (Integer)this.postForAll(methodObject30016, this.delegate.getColumnCount());
      } catch (SQLException var2) {
         return (Integer)this.postForAll(methodObject30016, this.onErrorForAll(methodObject30016, var2));
      }
   }

   public boolean isCurrency(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject30025, this, arg0);
         return (Boolean)this.postForAll(methodObject30025, this.delegate.isCurrency(arg0));
      } catch (SQLException var3) {
         return (Boolean)this.postForAll(methodObject30025, this.onErrorForAll(methodObject30025, var3));
      }
   }

   public boolean isReadOnly(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject30008, this, arg0);
         return (Boolean)this.postForAll(methodObject30008, this.delegate.isReadOnly(arg0));
      } catch (SQLException var3) {
         return (Boolean)this.postForAll(methodObject30008, this.onErrorForAll(methodObject30008, var3));
      }
   }

   public boolean isCaseSensitive(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject30024, this, arg0);
         return (Boolean)this.postForAll(methodObject30024, this.delegate.isCaseSensitive(arg0));
      } catch (SQLException var3) {
         return (Boolean)this.postForAll(methodObject30024, this.onErrorForAll(methodObject30024, var3));
      }
   }

   public int isNullable(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject30012, this, arg0);
         return (Integer)this.postForAll(methodObject30012, this.delegate.isNullable(arg0));
      } catch (SQLException var3) {
         return (Integer)this.postForAll(methodObject30012, this.onErrorForAll(methodObject30012, var3));
      }
   }

   public int getColumnDisplaySize(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject30017, this, arg0);
         return (Integer)this.postForAll(methodObject30017, this.delegate.getColumnDisplaySize(arg0));
      } catch (SQLException var3) {
         return (Integer)this.postForAll(methodObject30017, this.onErrorForAll(methodObject30017, var3));
      }
   }

   public boolean isDefinitelyWritable(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject30026, this, arg0);
         return (Boolean)this.postForAll(methodObject30026, this.delegate.isDefinitelyWritable(arg0));
      } catch (SQLException var3) {
         return (Boolean)this.postForAll(methodObject30026, this.onErrorForAll(methodObject30026, var3));
      }
   }

   public boolean isAutoIncrement(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject30023, this, arg0);
         return (Boolean)this.postForAll(methodObject30023, this.delegate.isAutoIncrement(arg0));
      } catch (SQLException var3) {
         return (Boolean)this.postForAll(methodObject30023, this.onErrorForAll(methodObject30023, var3));
      }
   }

   public int getColumnType(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject30020, this, arg0);
         return (Integer)this.postForAll(methodObject30020, this.delegate.getColumnType(arg0));
      } catch (SQLException var3) {
         return (Integer)this.postForAll(methodObject30020, this.onErrorForAll(methodObject30020, var3));
      }
   }

   public int getPrecision(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject30009, this, arg0);
         return (Integer)this.postForAll(methodObject30009, this.delegate.getPrecision(arg0));
      } catch (SQLException var3) {
         return (Integer)this.postForAll(methodObject30009, this.onErrorForAll(methodObject30009, var3));
      }
   }

   public OracleResultSetMetaData.SecurityAttribute getSecurityAttribute(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject30004, this, arg0);
         return (OracleResultSetMetaData.SecurityAttribute)this.postForAll(methodObject30004, (Object)this.delegate.getSecurityAttribute(arg0));
      } catch (SQLException var3) {
         return (OracleResultSetMetaData.SecurityAttribute)this.postForAll(methodObject30004, this.onErrorForAll(methodObject30004, var3));
      }
   }

   public String getColumnClassName(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject30015, this, arg0);
         return (String)this.postForAll(methodObject30015, (Object)this.delegate.getColumnClassName(arg0));
      } catch (SQLException var3) {
         return (String)this.postForAll(methodObject30015, this.onErrorForAll(methodObject30015, var3));
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
         methodObject30011 = ResultSetMetaData.class.getDeclaredMethod("getScale", Integer.TYPE);
         methodObject30019 = ResultSetMetaData.class.getDeclaredMethod("getColumnName", Integer.TYPE);
         methodObject30022 = ResultSetMetaData.class.getDeclaredMethod("getSchemaName", Integer.TYPE);
         methodObject30006 = OracleResultSetMetaData.class.getDeclaredMethod("isColumnInvisible", Integer.TYPE);
         methodObject30010 = ResultSetMetaData.class.getDeclaredMethod("getCatalogName", Integer.TYPE);
         methodObject30005 = OracleResultSetMetaData.class.getDeclaredMethod("isNCHAR", Integer.TYPE);
         methodObject30013 = ResultSetMetaData.class.getDeclaredMethod("isSigned", Integer.TYPE);
         methodObject30014 = ResultSetMetaData.class.getDeclaredMethod("getTableName", Integer.TYPE);
         methodObject30018 = ResultSetMetaData.class.getDeclaredMethod("getColumnLabel", Integer.TYPE);
         methodObject30021 = ResultSetMetaData.class.getDeclaredMethod("getColumnTypeName", Integer.TYPE);
         methodObject30030 = Wrapper.class.getDeclaredMethod("isWrapperFor", Class.class);
         methodObject30029 = Wrapper.class.getDeclaredMethod("unwrap", Class.class);
         methodObject30007 = OracleResultSetMetaData.class.getDeclaredMethod("isVariableScale", Integer.TYPE);
         methodObject30028 = ResultSetMetaData.class.getDeclaredMethod("isWritable", Integer.TYPE);
         methodObject30027 = ResultSetMetaData.class.getDeclaredMethod("isSearchable", Integer.TYPE);
         methodObject30016 = ResultSetMetaData.class.getDeclaredMethod("getColumnCount");
         methodObject30025 = ResultSetMetaData.class.getDeclaredMethod("isCurrency", Integer.TYPE);
         methodObject30008 = ResultSetMetaData.class.getDeclaredMethod("isReadOnly", Integer.TYPE);
         methodObject30024 = ResultSetMetaData.class.getDeclaredMethod("isCaseSensitive", Integer.TYPE);
         methodObject30012 = ResultSetMetaData.class.getDeclaredMethod("isNullable", Integer.TYPE);
         methodObject30017 = ResultSetMetaData.class.getDeclaredMethod("getColumnDisplaySize", Integer.TYPE);
         methodObject30026 = ResultSetMetaData.class.getDeclaredMethod("isDefinitelyWritable", Integer.TYPE);
         methodObject30023 = ResultSetMetaData.class.getDeclaredMethod("isAutoIncrement", Integer.TYPE);
         methodObject30020 = ResultSetMetaData.class.getDeclaredMethod("getColumnType", Integer.TYPE);
         methodObject30009 = ResultSetMetaData.class.getDeclaredMethod("getPrecision", Integer.TYPE);
         methodObject30004 = OracleResultSetMetaData.class.getDeclaredMethod("getSecurityAttribute", Integer.TYPE);
         methodObject30015 = ResultSetMetaData.class.getDeclaredMethod("getColumnClassName", Integer.TYPE);
      } catch (Throwable var1) {
         throw new RuntimeException(var1);
      }
   }

   public oracle$1jdbc$1replay$1driver$1NonTxnReplayableBase$2oracle$1jdbc$1OracleResultSetMetaData$$$Proxy(OracleResultSetMetaData var1, Object var2, ProxyFactory var3, Map var4) {
      this.delegate = var1;
      this.creator = var2;
      this.proxyFactory = var3;
      this.proxyCache = var4;
   }
}
