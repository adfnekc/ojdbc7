package oracle.jdbc.proxy;

import java.lang.reflect.Method;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Wrapper;
import java.util.Map;
import oracle.jdbc.replay.driver.NonTxnReplayableBase;

public abstract class oracle$1jdbc$1replay$1driver$1NonTxnReplayableBase$2java$1sql$1ResultSetMetaData$$$Proxy extends NonTxnReplayableBase implements ResultSetMetaData, _Proxy_ {
   private ResultSetMetaData delegate;
   private final Object creator;
   private final ProxyFactory proxyFactory;
   private final Map proxyCache;
   private static Object[] zeroLengthObjectArray = new Object[0];
   private static Method methodObject29769;
   private static Method methodObject29755;
   private static Method methodObject29766;
   private static Method methodObject29763;
   private static Method methodObject29752;
   private static Method methodObject29754;
   private static Method methodObject29768;
   private static Method methodObject29757;
   private static Method methodObject29756;
   private static Method methodObject29758;
   private static Method methodObject29770;
   private static Method methodObject29761;
   private static Method methodObject29762;
   private static Method methodObject29767;
   private static Method methodObject29764;
   private static Method methodObject29765;
   private static Method methodObject29753;
   private static Method methodObject29774;
   private static Method methodObject29773;
   private static Method methodObject29772;
   private static Method methodObject29771;
   private static Method methodObject29759;
   private static Method methodObject29760;

   public boolean isCurrency(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject29769, this, arg0);
         return (Boolean)this.postForAll(methodObject29769, this.delegate.isCurrency(arg0));
      } catch (SQLException var3) {
         return (Boolean)this.postForAll(methodObject29769, this.onErrorForAll(methodObject29769, var3));
      }
   }

   public int getScale(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject29755, this, arg0);
         return (Integer)this.postForAll(methodObject29755, this.delegate.getScale(arg0));
      } catch (SQLException var3) {
         return (Integer)this.postForAll(methodObject29755, this.onErrorForAll(methodObject29755, var3));
      }
   }

   public String getSchemaName(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject29766, this, arg0);
         return (String)this.postForAll(methodObject29766, (Object)this.delegate.getSchemaName(arg0));
      } catch (SQLException var3) {
         return (String)this.postForAll(methodObject29766, this.onErrorForAll(methodObject29766, var3));
      }
   }

   public String getColumnName(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject29763, this, arg0);
         return (String)this.postForAll(methodObject29763, (Object)this.delegate.getColumnName(arg0));
      } catch (SQLException var3) {
         return (String)this.postForAll(methodObject29763, this.onErrorForAll(methodObject29763, var3));
      }
   }

   public boolean isReadOnly(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject29752, this, arg0);
         return (Boolean)this.postForAll(methodObject29752, this.delegate.isReadOnly(arg0));
      } catch (SQLException var3) {
         return (Boolean)this.postForAll(methodObject29752, this.onErrorForAll(methodObject29752, var3));
      }
   }

   public String getCatalogName(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject29754, this, arg0);
         return (String)this.postForAll(methodObject29754, (Object)this.delegate.getCatalogName(arg0));
      } catch (SQLException var3) {
         return (String)this.postForAll(methodObject29754, this.onErrorForAll(methodObject29754, var3));
      }
   }

   public boolean isCaseSensitive(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject29768, this, arg0);
         return (Boolean)this.postForAll(methodObject29768, this.delegate.isCaseSensitive(arg0));
      } catch (SQLException var3) {
         return (Boolean)this.postForAll(methodObject29768, this.onErrorForAll(methodObject29768, var3));
      }
   }

   public boolean isSigned(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject29757, this, arg0);
         return (Boolean)this.postForAll(methodObject29757, this.delegate.isSigned(arg0));
      } catch (SQLException var3) {
         return (Boolean)this.postForAll(methodObject29757, this.onErrorForAll(methodObject29757, var3));
      }
   }

   public int isNullable(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject29756, this, arg0);
         return (Integer)this.postForAll(methodObject29756, this.delegate.isNullable(arg0));
      } catch (SQLException var3) {
         return (Integer)this.postForAll(methodObject29756, this.onErrorForAll(methodObject29756, var3));
      }
   }

   public String getTableName(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject29758, this, arg0);
         return (String)this.postForAll(methodObject29758, (Object)this.delegate.getTableName(arg0));
      } catch (SQLException var3) {
         return (String)this.postForAll(methodObject29758, this.onErrorForAll(methodObject29758, var3));
      }
   }

   public boolean isDefinitelyWritable(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject29770, this, arg0);
         return (Boolean)this.postForAll(methodObject29770, this.delegate.isDefinitelyWritable(arg0));
      } catch (SQLException var3) {
         return (Boolean)this.postForAll(methodObject29770, this.onErrorForAll(methodObject29770, var3));
      }
   }

   public int getColumnDisplaySize(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject29761, this, arg0);
         return (Integer)this.postForAll(methodObject29761, this.delegate.getColumnDisplaySize(arg0));
      } catch (SQLException var3) {
         return (Integer)this.postForAll(methodObject29761, this.onErrorForAll(methodObject29761, var3));
      }
   }

   public String getColumnLabel(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject29762, this, arg0);
         return (String)this.postForAll(methodObject29762, (Object)this.delegate.getColumnLabel(arg0));
      } catch (SQLException var3) {
         return (String)this.postForAll(methodObject29762, this.onErrorForAll(methodObject29762, var3));
      }
   }

   public boolean isAutoIncrement(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject29767, this, arg0);
         return (Boolean)this.postForAll(methodObject29767, this.delegate.isAutoIncrement(arg0));
      } catch (SQLException var3) {
         return (Boolean)this.postForAll(methodObject29767, this.onErrorForAll(methodObject29767, var3));
      }
   }

   public int getColumnType(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject29764, this, arg0);
         return (Integer)this.postForAll(methodObject29764, this.delegate.getColumnType(arg0));
      } catch (SQLException var3) {
         return (Integer)this.postForAll(methodObject29764, this.onErrorForAll(methodObject29764, var3));
      }
   }

   public String getColumnTypeName(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject29765, this, arg0);
         return (String)this.postForAll(methodObject29765, (Object)this.delegate.getColumnTypeName(arg0));
      } catch (SQLException var3) {
         return (String)this.postForAll(methodObject29765, this.onErrorForAll(methodObject29765, var3));
      }
   }

   public int getPrecision(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject29753, this, arg0);
         return (Integer)this.postForAll(methodObject29753, this.delegate.getPrecision(arg0));
      } catch (SQLException var3) {
         return (Integer)this.postForAll(methodObject29753, this.onErrorForAll(methodObject29753, var3));
      }
   }

   public boolean isWrapperFor(Class arg0) throws SQLException {
      try {
         super.preForAll(methodObject29774, this, arg0);
         return (Boolean)this.postForAll(methodObject29774, this.delegate.isWrapperFor(arg0));
      } catch (SQLException var3) {
         return (Boolean)this.postForAll(methodObject29774, this.onErrorForAll(methodObject29774, var3));
      }
   }

   public Object unwrap(Class arg0) throws SQLException {
      try {
         super.preForAll(methodObject29773, this, arg0);
         return this.postForAll(methodObject29773, this.proxyFactory.proxyForCache(this.delegate.unwrap(arg0), this, this.proxyCache, methodObject29773));
      } catch (SQLException var3) {
         return this.postForAll(methodObject29773, this.onErrorForAll(methodObject29773, var3));
      }
   }

   public boolean isWritable(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject29772, this, arg0);
         return (Boolean)this.postForAll(methodObject29772, this.delegate.isWritable(arg0));
      } catch (SQLException var3) {
         return (Boolean)this.postForAll(methodObject29772, this.onErrorForAll(methodObject29772, var3));
      }
   }

   public boolean isSearchable(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject29771, this, arg0);
         return (Boolean)this.postForAll(methodObject29771, this.delegate.isSearchable(arg0));
      } catch (SQLException var3) {
         return (Boolean)this.postForAll(methodObject29771, this.onErrorForAll(methodObject29771, var3));
      }
   }

   public String getColumnClassName(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject29759, this, arg0);
         return (String)this.postForAll(methodObject29759, (Object)this.delegate.getColumnClassName(arg0));
      } catch (SQLException var3) {
         return (String)this.postForAll(methodObject29759, this.onErrorForAll(methodObject29759, var3));
      }
   }

   public int getColumnCount() throws SQLException {
      try {
         super.preForAll(methodObject29760, this, zeroLengthObjectArray);
         return (Integer)this.postForAll(methodObject29760, this.delegate.getColumnCount());
      } catch (SQLException var2) {
         return (Integer)this.postForAll(methodObject29760, this.onErrorForAll(methodObject29760, var2));
      }
   }

   public ResultSetMetaData _getDelegate_() {
      return this.delegate;
   }

   public Object getDelegate() {
      return this.delegate;
   }

   public void setDelegate(Object delegate) {
      this.proxyFactory.updateDelegate(this, this.delegate, delegate);
      this.delegate = (ResultSetMetaData)delegate;
   }

   public Object getCreator() {
      return this.creator;
   }

   static {
      try {
         methodObject29769 = ResultSetMetaData.class.getDeclaredMethod("isCurrency", Integer.TYPE);
         methodObject29755 = ResultSetMetaData.class.getDeclaredMethod("getScale", Integer.TYPE);
         methodObject29766 = ResultSetMetaData.class.getDeclaredMethod("getSchemaName", Integer.TYPE);
         methodObject29763 = ResultSetMetaData.class.getDeclaredMethod("getColumnName", Integer.TYPE);
         methodObject29752 = ResultSetMetaData.class.getDeclaredMethod("isReadOnly", Integer.TYPE);
         methodObject29754 = ResultSetMetaData.class.getDeclaredMethod("getCatalogName", Integer.TYPE);
         methodObject29768 = ResultSetMetaData.class.getDeclaredMethod("isCaseSensitive", Integer.TYPE);
         methodObject29757 = ResultSetMetaData.class.getDeclaredMethod("isSigned", Integer.TYPE);
         methodObject29756 = ResultSetMetaData.class.getDeclaredMethod("isNullable", Integer.TYPE);
         methodObject29758 = ResultSetMetaData.class.getDeclaredMethod("getTableName", Integer.TYPE);
         methodObject29770 = ResultSetMetaData.class.getDeclaredMethod("isDefinitelyWritable", Integer.TYPE);
         methodObject29761 = ResultSetMetaData.class.getDeclaredMethod("getColumnDisplaySize", Integer.TYPE);
         methodObject29762 = ResultSetMetaData.class.getDeclaredMethod("getColumnLabel", Integer.TYPE);
         methodObject29767 = ResultSetMetaData.class.getDeclaredMethod("isAutoIncrement", Integer.TYPE);
         methodObject29764 = ResultSetMetaData.class.getDeclaredMethod("getColumnType", Integer.TYPE);
         methodObject29765 = ResultSetMetaData.class.getDeclaredMethod("getColumnTypeName", Integer.TYPE);
         methodObject29753 = ResultSetMetaData.class.getDeclaredMethod("getPrecision", Integer.TYPE);
         methodObject29774 = Wrapper.class.getDeclaredMethod("isWrapperFor", Class.class);
         methodObject29773 = Wrapper.class.getDeclaredMethod("unwrap", Class.class);
         methodObject29772 = ResultSetMetaData.class.getDeclaredMethod("isWritable", Integer.TYPE);
         methodObject29771 = ResultSetMetaData.class.getDeclaredMethod("isSearchable", Integer.TYPE);
         methodObject29759 = ResultSetMetaData.class.getDeclaredMethod("getColumnClassName", Integer.TYPE);
         methodObject29760 = ResultSetMetaData.class.getDeclaredMethod("getColumnCount");
      } catch (Throwable var1) {
         throw new RuntimeException(var1);
      }
   }

   public oracle$1jdbc$1replay$1driver$1NonTxnReplayableBase$2java$1sql$1ResultSetMetaData$$$Proxy(ResultSetMetaData var1, Object var2, ProxyFactory var3, Map var4) {
      this.delegate = var1;
      this.creator = var2;
      this.proxyFactory = var3;
      this.proxyCache = var4;
   }
}
