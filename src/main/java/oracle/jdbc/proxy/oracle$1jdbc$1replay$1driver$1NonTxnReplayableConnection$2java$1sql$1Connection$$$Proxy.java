package oracle.jdbc.proxy;

import java.lang.reflect.Method;
import java.sql.Array;
import java.sql.Blob;
import java.sql.CallableStatement;
import java.sql.Clob;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.NClob;
import java.sql.PreparedStatement;
import java.sql.SQLClientInfoException;
import java.sql.SQLException;
import java.sql.SQLWarning;
import java.sql.SQLXML;
import java.sql.Savepoint;
import java.sql.Statement;
import java.sql.Struct;
import java.sql.Wrapper;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.Executor;
import oracle.jdbc.replay.driver.NonTxnReplayableConnection;

public abstract class oracle$1jdbc$1replay$1driver$1NonTxnReplayableConnection$2java$1sql$1Connection$$$Proxy extends NonTxnReplayableConnection implements Connection, _Proxy_ {
   private Connection delegate;
   private final Object creator;
   private final ProxyFactory proxyFactory;
   private final Map proxyCache;
   private static Object[] zeroLengthObjectArray = new Object[0];
   private static Method methodObject30385;
   private static Method methodObject30408;
   private static Method methodObject30411;
   private static Method methodObject30403;
   private static Method methodObject30416;
   private static Method methodObject30413;
   private static Method methodObject30386;
   private static Method methodObject30422;
   private static Method methodObject30397;
   private static Method methodObject30399;
   private static Method methodObject30406;
   private static Method methodObject30423;
   private static Method methodObject30393;
   private static Method methodObject30400;
   private static Method methodObject30432;
   private static Method methodObject30436;
   private static Method methodObject30392;
   private static Method methodObject30435;
   private static Method methodObject30404;
   private static Method methodObject30409;
   private static Method methodObject30412;
   private static Method methodObject30391;
   private static Method methodObject30401;
   private static Method methodObject30414;
   private static Method methodObject30430;
   private static Method methodObject30410;
   private static Method methodObject30396;
   private static Method methodObject30389;
   private static Method methodObject30387;
   private static Method methodObject30394;
   private static Method methodObject30429;
   private static Method methodObject30434;
   private static Method methodObject30420;
   private static Method methodObject30407;
   private static Method methodObject30388;
   private static Method methodObject30405;
   private static Method methodObject30421;
   private static Method methodObject30398;
   private static Method methodObject30438;
   private static Method methodObject30437;
   private static Method methodObject30395;
   private static Method methodObject30431;
   private static Method methodObject30425;
   private static Method methodObject30433;
   private static Method methodObject30402;
   private static Method methodObject30417;
   private static Method methodObject30415;
   private static Method methodObject30418;
   private static Method methodObject30427;
   private static Method methodObject30390;
   private static Method methodObject30419;
   private static Method methodObject30428;
   private static Method methodObject30424;
   private static Method methodObject30426;

   public void setReadOnly(boolean arg0) throws SQLException {
      try {
         super.preForAll(methodObject30385, this, arg0);
         Method var10001 = methodObject30385;
         this.delegate.setReadOnly(arg0);
         this.postForAll(var10001);
      } catch (SQLException var3) {
         this.onErrorVoidForAll(methodObject30385, var3);
      }
   }

   public PreparedStatement prepareStatement(String arg0) throws SQLException {
      try {
         super.preForAll(methodObject30408, this, arg0);
         return (PreparedStatement)this.postForAll(methodObject30408, this.proxyFactory.proxyForCreateCache((Object)this.delegate.prepareStatement(arg0), this, this.proxyCache, methodObject30408));
      } catch (SQLException var3) {
         return (PreparedStatement)this.postForAll(methodObject30408, this.onErrorForAll(methodObject30408, var3));
      }
   }

   public PreparedStatement prepareStatement(String arg0, int arg1) throws SQLException {
      try {
         super.preForAll(methodObject30411, this, arg0, arg1);
         return (PreparedStatement)this.postForAll(methodObject30411, this.proxyFactory.proxyForCreateCache((Object)this.delegate.prepareStatement(arg0, arg1), this, this.proxyCache, methodObject30411));
      } catch (SQLException var4) {
         return (PreparedStatement)this.postForAll(methodObject30411, this.onErrorForAll(methodObject30411, var4));
      }
   }

   public Statement createStatement(int arg0, int arg1) throws SQLException {
      try {
         super.preForAll(methodObject30403, this, arg0, arg1);
         return (Statement)this.postForAll(methodObject30403, this.proxyFactory.proxyForCreateCache((Object)this.delegate.createStatement(arg0, arg1), this, this.proxyCache, methodObject30403));
      } catch (SQLException var4) {
         return (Statement)this.postForAll(methodObject30403, this.onErrorForAll(methodObject30403, var4));
      }
   }

   public String getSchema() throws SQLException {
      try {
         super.preForAll(methodObject30416, this, zeroLengthObjectArray);
         return (String)this.postForAll(methodObject30416, (Object)this.delegate.getSchema());
      } catch (SQLException var2) {
         return (String)this.postForAll(methodObject30416, this.onErrorForAll(methodObject30416, var2));
      }
   }

   public PreparedStatement prepareStatement(String arg0, String[] arg1) throws SQLException {
      try {
         super.preForAll(methodObject30413, this, arg0, arg1);
         return (PreparedStatement)this.postForAll(methodObject30413, this.proxyFactory.proxyForCreateCache((Object)this.delegate.prepareStatement(arg0, arg1), this, this.proxyCache, methodObject30413));
      } catch (SQLException var4) {
         return (PreparedStatement)this.postForAll(methodObject30413, this.onErrorForAll(methodObject30413, var4));
      }
   }

   public void close() throws SQLException {
      try {
         super.preForClosure(methodObject30386, this, zeroLengthObjectArray);
         Method var10001 = methodObject30386;
         this.delegate.close();
         this.postForClosure(var10001);
      } catch (SQLException var2) {
         this.onErrorVoidForAll(methodObject30386, var2);
      }
   }

   public void setCatalog(String arg0) throws SQLException {
      try {
         super.preForAll(methodObject30422, this, arg0);
         Method var10001 = methodObject30422;
         this.delegate.setCatalog(arg0);
         this.postForAll(var10001);
      } catch (SQLException var3) {
         this.onErrorVoidForAll(methodObject30422, var3);
      }
   }

   public Struct createStruct(String arg0, Object[] arg1) throws SQLException {
      try {
         super.preForAll(methodObject30397, this, arg0, arg1);
         return (Struct)this.postForAll(methodObject30397, this.proxyFactory.proxyForCreateCache((Object)super.createStruct(arg0, arg1), this, this.proxyCache, methodObject30397));
      } catch (SQLException var4) {
         return (Struct)this.postForAll(methodObject30397, this.onErrorForAll(methodObject30397, var4));
      }
   }

   public Clob createClob() throws SQLException {
      try {
         super.preForAll(methodObject30399, this, zeroLengthObjectArray);
         return (Clob)this.postForAll(methodObject30399, this.proxyFactory.proxyForCreateCache((Object)this.delegate.createClob(), this, this.proxyCache, methodObject30399));
      } catch (SQLException var2) {
         return (Clob)this.postForAll(methodObject30399, this.onErrorForAll(methodObject30399, var2));
      }
   }

   public CallableStatement prepareCall(String arg0, int arg1, int arg2) throws SQLException {
      try {
         super.preForAll(methodObject30406, this, arg0, arg1, arg2);
         return (CallableStatement)this.postForAll(methodObject30406, this.proxyFactory.proxyForCreateCache((Object)this.delegate.prepareCall(arg0, arg1, arg2), this, this.proxyCache, methodObject30406));
      } catch (SQLException var5) {
         return (CallableStatement)this.postForAll(methodObject30406, this.onErrorForAll(methodObject30406, var5));
      }
   }

   public void setClientInfo(String arg0, String arg1) throws SQLClientInfoException {
      super.preForAll(methodObject30423, this, arg0, arg1);
      Method var10001 = methodObject30423;
      this.delegate.setClientInfo(arg0, arg1);
      this.postForAll(var10001);
   }

   public Savepoint setSavepoint() throws SQLException {
      try {
         super.preForTxnControl(methodObject30393, this, zeroLengthObjectArray);
         return (Savepoint)this.postForAll(methodObject30393, this.proxyFactory.proxyForCreate((Object)this.delegate.setSavepoint(), this, this.proxyCache, methodObject30393));
      } catch (SQLException var2) {
         return (Savepoint)this.postForAll(methodObject30393, this.onErrorForAll(methodObject30393, var2));
      }
   }

   public NClob createNClob() throws SQLException {
      try {
         super.preForAll(methodObject30400, this, zeroLengthObjectArray);
         return (NClob)this.postForAll(methodObject30400, this.proxyFactory.proxyForCreateCache((Object)this.delegate.createNClob(), this, this.proxyCache, methodObject30400));
      } catch (SQLException var2) {
         return (NClob)this.postForAll(methodObject30400, this.onErrorForAll(methodObject30400, var2));
      }
   }

   public boolean getAutoCommit() throws SQLException {
      try {
         super.preForAll(methodObject30432, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject30432, this.delegate.getAutoCommit());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject30432, this.onErrorForAll(methodObject30432, var2));
      }
   }

   public int getTransactionIsolation() throws SQLException {
      try {
         super.preForAll(methodObject30436, this, zeroLengthObjectArray);
         return (Integer)this.postForAll(methodObject30436, this.delegate.getTransactionIsolation());
      } catch (SQLException var2) {
         return (Integer)this.postForAll(methodObject30436, this.onErrorForAll(methodObject30436, var2));
      }
   }

   public void rollback(Savepoint arg0) throws SQLException {
      try {
         super.preForTxnControl(methodObject30392, this, arg0);
         Method var10001 = methodObject30392;
         this.delegate.rollback(arg0 instanceof _Proxy_ ? (Savepoint)((_Proxy_)arg0)._getDelegate_() : arg0);
         this.postForAll(var10001);
      } catch (SQLException var3) {
         this.onErrorVoidForAll(methodObject30392, var3);
      }
   }

   public int getHoldability() throws SQLException {
      try {
         super.preForAll(methodObject30435, this, zeroLengthObjectArray);
         return (Integer)this.postForAll(methodObject30435, this.delegate.getHoldability());
      } catch (SQLException var2) {
         return (Integer)this.postForAll(methodObject30435, this.onErrorForAll(methodObject30435, var2));
      }
   }

   public Statement createStatement(int arg0, int arg1, int arg2) throws SQLException {
      try {
         super.preForAll(methodObject30404, this, arg0, arg1, arg2);
         return (Statement)this.postForAll(methodObject30404, this.proxyFactory.proxyForCreateCache((Object)this.delegate.createStatement(arg0, arg1, arg2), this, this.proxyCache, methodObject30404));
      } catch (SQLException var5) {
         return (Statement)this.postForAll(methodObject30404, this.onErrorForAll(methodObject30404, var5));
      }
   }

   public PreparedStatement prepareStatement(String arg0, int arg1, int arg2) throws SQLException {
      try {
         super.preForAll(methodObject30409, this, arg0, arg1, arg2);
         return (PreparedStatement)this.postForAll(methodObject30409, this.proxyFactory.proxyForCreateCache((Object)this.delegate.prepareStatement(arg0, arg1, arg2), this, this.proxyCache, methodObject30409));
      } catch (SQLException var5) {
         return (PreparedStatement)this.postForAll(methodObject30409, this.onErrorForAll(methodObject30409, var5));
      }
   }

   public PreparedStatement prepareStatement(String arg0, int[] arg1) throws SQLException {
      try {
         super.preForAll(methodObject30412, this, arg0, arg1);
         return (PreparedStatement)this.postForAll(methodObject30412, this.proxyFactory.proxyForCreateCache((Object)this.delegate.prepareStatement(arg0, arg1), this, this.proxyCache, methodObject30412));
      } catch (SQLException var4) {
         return (PreparedStatement)this.postForAll(methodObject30412, this.onErrorForAll(methodObject30412, var4));
      }
   }

   public void rollback() throws SQLException {
      try {
         super.preForTxnControl(methodObject30391, this, zeroLengthObjectArray);
         Method var10001 = methodObject30391;
         this.delegate.rollback();
         this.postForAll(var10001);
      } catch (SQLException var2) {
         this.onErrorVoidForAll(methodObject30391, var2);
      }
   }

   public SQLXML createSQLXML() throws SQLException {
      try {
         super.preForAll(methodObject30401, this, zeroLengthObjectArray);
         return (SQLXML)this.postForAll(methodObject30401, this.proxyFactory.proxyForCreateCache((Object)this.delegate.createSQLXML(), this, this.proxyCache, methodObject30401));
      } catch (SQLException var2) {
         return (SQLXML)this.postForAll(methodObject30401, this.onErrorForAll(methodObject30401, var2));
      }
   }

   public String getCatalog() throws SQLException {
      try {
         super.preForAll(methodObject30414, this, zeroLengthObjectArray);
         return (String)this.postForAll(methodObject30414, (Object)this.delegate.getCatalog());
      } catch (SQLException var2) {
         return (String)this.postForAll(methodObject30414, this.onErrorForAll(methodObject30414, var2));
      }
   }

   public int getNetworkTimeout() throws SQLException {
      try {
         super.preForAll(methodObject30430, this, zeroLengthObjectArray);
         return (Integer)this.postForAll(methodObject30430, this.delegate.getNetworkTimeout());
      } catch (SQLException var2) {
         return (Integer)this.postForAll(methodObject30430, this.onErrorForAll(methodObject30430, var2));
      }
   }

   public PreparedStatement prepareStatement(String arg0, int arg1, int arg2, int arg3) throws SQLException {
      try {
         super.preForAll(methodObject30410, this, arg0, arg1, arg2, arg3);
         return (PreparedStatement)this.postForAll(methodObject30410, this.proxyFactory.proxyForCreateCache((Object)this.delegate.prepareStatement(arg0, arg1, arg2, arg3), this, this.proxyCache, methodObject30410));
      } catch (SQLException var6) {
         return (PreparedStatement)this.postForAll(methodObject30410, this.onErrorForAll(methodObject30410, var6));
      }
   }

   public Array createArrayOf(String arg0, Object[] arg1) throws SQLException {
      try {
         super.preForAll(methodObject30396, this, arg0, arg1);
         return (Array)this.postForAll(methodObject30396, this.proxyFactory.proxyForCreateCache((Object)super.createArrayOf(arg0, arg1), this, this.proxyCache, methodObject30396));
      } catch (SQLException var4) {
         return (Array)this.postForAll(methodObject30396, this.onErrorForAll(methodObject30396, var4));
      }
   }

   public void abort(Executor arg0) throws SQLException {
      try {
         super.preForAll(methodObject30389, this, arg0);
         Method var10001 = methodObject30389;
         this.delegate.abort(arg0);
         this.postForAll(var10001);
      } catch (SQLException var3) {
         this.onErrorVoidForAll(methodObject30389, var3);
      }
   }

   public boolean isValid(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject30387, this, arg0);
         return (Boolean)this.postForAll(methodObject30387, this.delegate.isValid(arg0));
      } catch (SQLException var3) {
         return (Boolean)this.postForAll(methodObject30387, this.onErrorForAll(methodObject30387, var3));
      }
   }

   public Savepoint setSavepoint(String arg0) throws SQLException {
      try {
         super.preForTxnControl(methodObject30394, this, arg0);
         return (Savepoint)this.postForAll(methodObject30394, this.proxyFactory.proxyForCreate((Object)this.delegate.setSavepoint(arg0), this, this.proxyCache, methodObject30394));
      } catch (SQLException var3) {
         return (Savepoint)this.postForAll(methodObject30394, this.onErrorForAll(methodObject30394, var3));
      }
   }

   public void setTypeMap(Map arg0) throws SQLException {
      try {
         super.preForAll(methodObject30429, this, arg0);
         Method var10001 = methodObject30429;
         this.delegate.setTypeMap(arg0);
         this.postForAll(var10001);
      } catch (SQLException var3) {
         this.onErrorVoidForAll(methodObject30429, var3);
      }
   }

   public Properties getClientInfo() throws SQLException {
      try {
         super.preForAll(methodObject30434, this, zeroLengthObjectArray);
         return (Properties)this.postForAll(methodObject30434, (Object)this.delegate.getClientInfo());
      } catch (SQLException var2) {
         return (Properties)this.postForAll(methodObject30434, this.onErrorForAll(methodObject30434, var2));
      }
   }

   public String nativeSQL(String arg0) throws SQLException {
      try {
         super.preForAll(methodObject30420, this, arg0);
         return (String)this.postForAll(methodObject30420, (Object)this.delegate.nativeSQL(arg0));
      } catch (SQLException var3) {
         return (String)this.postForAll(methodObject30420, this.onErrorForAll(methodObject30420, var3));
      }
   }

   public CallableStatement prepareCall(String arg0, int arg1, int arg2, int arg3) throws SQLException {
      try {
         super.preForAll(methodObject30407, this, arg0, arg1, arg2, arg3);
         return (CallableStatement)this.postForAll(methodObject30407, this.proxyFactory.proxyForCreateCache((Object)this.delegate.prepareCall(arg0, arg1, arg2, arg3), this, this.proxyCache, methodObject30407));
      } catch (SQLException var6) {
         return (CallableStatement)this.postForAll(methodObject30407, this.onErrorForAll(methodObject30407, var6));
      }
   }

   public boolean isReadOnly() throws SQLException {
      try {
         super.preForAll(methodObject30388, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject30388, this.delegate.isReadOnly());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject30388, this.onErrorForAll(methodObject30388, var2));
      }
   }

   public CallableStatement prepareCall(String arg0) throws SQLException {
      try {
         super.preForAll(methodObject30405, this, arg0);
         return (CallableStatement)this.postForAll(methodObject30405, this.proxyFactory.proxyForCreateCache((Object)this.delegate.prepareCall(arg0), this, this.proxyCache, methodObject30405));
      } catch (SQLException var3) {
         return (CallableStatement)this.postForAll(methodObject30405, this.onErrorForAll(methodObject30405, var3));
      }
   }

   public void setAutoCommit(boolean arg0) throws SQLException {
      try {
         super.preForAll(methodObject30421, this, arg0);
         Method var10001 = methodObject30421;
         this.delegate.setAutoCommit(arg0);
         this.postForAll(var10001);
      } catch (SQLException var3) {
         this.onErrorVoidForAll(methodObject30421, var3);
      }
   }

   public Blob createBlob() throws SQLException {
      try {
         super.preForAll(methodObject30398, this, zeroLengthObjectArray);
         return (Blob)this.postForAll(methodObject30398, this.proxyFactory.proxyForCreateCache((Object)this.delegate.createBlob(), this, this.proxyCache, methodObject30398));
      } catch (SQLException var2) {
         return (Blob)this.postForAll(methodObject30398, this.onErrorForAll(methodObject30398, var2));
      }
   }

   public boolean isWrapperFor(Class arg0) throws SQLException {
      try {
         super.preForAll(methodObject30438, this, arg0);
         return (Boolean)this.postForAll(methodObject30438, this.delegate.isWrapperFor(arg0));
      } catch (SQLException var3) {
         return (Boolean)this.postForAll(methodObject30438, this.onErrorForAll(methodObject30438, var3));
      }
   }

   public Object unwrap(Class arg0) throws SQLException {
      try {
         super.preForAll(methodObject30437, this, arg0);
         return this.postForAll(methodObject30437, super.unwrap(arg0));
      } catch (SQLException var3) {
         return this.postForAll(methodObject30437, this.onErrorForAll(methodObject30437, var3));
      }
   }

   public void releaseSavepoint(Savepoint arg0) throws SQLException {
      try {
         super.preForTxnControl(methodObject30395, this, arg0);
         Method var10001 = methodObject30395;
         this.delegate.releaseSavepoint(arg0 instanceof _Proxy_ ? (Savepoint)((_Proxy_)arg0)._getDelegate_() : arg0);
         this.postForAll(var10001);
      } catch (SQLException var3) {
         this.onErrorVoidForAll(methodObject30395, var3);
      }
   }

   public void clearWarnings() throws SQLException {
      try {
         super.preForAll(methodObject30431, this, zeroLengthObjectArray);
         Method var10001 = methodObject30431;
         this.delegate.clearWarnings();
         this.postForAll(var10001);
      } catch (SQLException var2) {
         this.onErrorVoidForAll(methodObject30431, var2);
      }
   }

   public void setHoldability(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject30425, this, arg0);
         Method var10001 = methodObject30425;
         this.delegate.setHoldability(arg0);
         this.postForAll(var10001);
      } catch (SQLException var3) {
         this.onErrorVoidForAll(methodObject30425, var3);
      }
   }

   public String getClientInfo(String arg0) throws SQLException {
      try {
         super.preForAll(methodObject30433, this, arg0);
         return (String)this.postForAll(methodObject30433, (Object)this.delegate.getClientInfo(arg0));
      } catch (SQLException var3) {
         return (String)this.postForAll(methodObject30433, this.onErrorForAll(methodObject30433, var3));
      }
   }

   public Statement createStatement() throws SQLException {
      try {
         super.preForAll(methodObject30402, this, zeroLengthObjectArray);
         return (Statement)this.postForAll(methodObject30402, this.proxyFactory.proxyForCreateCache((Object)this.delegate.createStatement(), this, this.proxyCache, methodObject30402));
      } catch (SQLException var2) {
         return (Statement)this.postForAll(methodObject30402, this.onErrorForAll(methodObject30402, var2));
      }
   }

   public DatabaseMetaData getMetaData() throws SQLException {
      try {
         super.preForAll(methodObject30417, this, zeroLengthObjectArray);
         return (DatabaseMetaData)this.postForAll(methodObject30417, this.proxyFactory.proxyForCache((Object)this.delegate.getMetaData(), this, this.proxyCache, methodObject30417));
      } catch (SQLException var2) {
         return (DatabaseMetaData)this.postForAll(methodObject30417, this.onErrorForAll(methodObject30417, var2));
      }
   }

   public boolean isClosed() throws SQLException {
      try {
         super.preForAll(methodObject30415, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject30415, this.delegate.isClosed());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject30415, this.onErrorForAll(methodObject30415, var2));
      }
   }

   public Map getTypeMap() throws SQLException {
      try {
         super.preForAll(methodObject30418, this, zeroLengthObjectArray);
         return (Map)this.postForAll(methodObject30418, (Object)this.delegate.getTypeMap());
      } catch (SQLException var2) {
         return (Map)this.postForAll(methodObject30418, this.onErrorForAll(methodObject30418, var2));
      }
   }

   public void setSchema(String arg0) throws SQLException {
      try {
         super.preForAll(methodObject30427, this, arg0);
         Method var10001 = methodObject30427;
         this.delegate.setSchema(arg0);
         this.postForAll(var10001);
      } catch (SQLException var3) {
         this.onErrorVoidForAll(methodObject30427, var3);
      }
   }

   public void commit() throws SQLException {
      try {
         super.preForTxnControl(methodObject30390, this, zeroLengthObjectArray);
         Method var10001 = methodObject30390;
         this.delegate.commit();
         this.postForAll(var10001);
      } catch (SQLException var2) {
         this.onErrorVoidForAll(methodObject30390, var2);
      }
   }

   public SQLWarning getWarnings() throws SQLException {
      try {
         super.preForAll(methodObject30419, this, zeroLengthObjectArray);
         return (SQLWarning)this.postForAll(methodObject30419, (Object)this.delegate.getWarnings());
      } catch (SQLException var2) {
         return (SQLWarning)this.postForAll(methodObject30419, this.onErrorForAll(methodObject30419, var2));
      }
   }

   public void setTransactionIsolation(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject30428, this, arg0);
         Method var10001 = methodObject30428;
         this.delegate.setTransactionIsolation(arg0);
         this.postForAll(var10001);
      } catch (SQLException var3) {
         this.onErrorVoidForAll(methodObject30428, var3);
      }
   }

   public void setClientInfo(Properties arg0) throws SQLClientInfoException {
      super.preForAll(methodObject30424, this, arg0);
      Method var10001 = methodObject30424;
      this.delegate.setClientInfo(arg0);
      this.postForAll(var10001);
   }

   public void setNetworkTimeout(Executor arg0, int arg1) throws SQLException {
      try {
         super.preForAll(methodObject30426, this, arg0, arg1);
         Method var10001 = methodObject30426;
         this.delegate.setNetworkTimeout(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject30426, var4);
      }
   }

   public Connection _getDelegate_() {
      return this.delegate;
   }

   public Object getDelegate() {
      return this.delegate;
   }

   public void setDelegate(Object delegate) {
      this.proxyFactory.updateDelegate(this, this.delegate, delegate);
      this.delegate = (Connection)delegate;
   }

   public Object getCreator() {
      return this.creator;
   }

   static {
      try {
         methodObject30385 = Connection.class.getDeclaredMethod("setReadOnly", Boolean.TYPE);
         methodObject30408 = Connection.class.getDeclaredMethod("prepareStatement", String.class);
         methodObject30411 = Connection.class.getDeclaredMethod("prepareStatement", String.class, Integer.TYPE);
         methodObject30403 = Connection.class.getDeclaredMethod("createStatement", Integer.TYPE, Integer.TYPE);
         methodObject30416 = Connection.class.getDeclaredMethod("getSchema");
         methodObject30413 = Connection.class.getDeclaredMethod("prepareStatement", String.class, String[].class);
         methodObject30386 = Connection.class.getDeclaredMethod("close");
         methodObject30422 = Connection.class.getDeclaredMethod("setCatalog", String.class);
         methodObject30397 = Connection.class.getDeclaredMethod("createStruct", String.class, Object[].class);
         methodObject30399 = Connection.class.getDeclaredMethod("createClob");
         methodObject30406 = Connection.class.getDeclaredMethod("prepareCall", String.class, Integer.TYPE, Integer.TYPE);
         methodObject30423 = Connection.class.getDeclaredMethod("setClientInfo", String.class, String.class);
         methodObject30393 = Connection.class.getDeclaredMethod("setSavepoint");
         methodObject30400 = Connection.class.getDeclaredMethod("createNClob");
         methodObject30432 = Connection.class.getDeclaredMethod("getAutoCommit");
         methodObject30436 = Connection.class.getDeclaredMethod("getTransactionIsolation");
         methodObject30392 = Connection.class.getDeclaredMethod("rollback", Savepoint.class);
         methodObject30435 = Connection.class.getDeclaredMethod("getHoldability");
         methodObject30404 = Connection.class.getDeclaredMethod("createStatement", Integer.TYPE, Integer.TYPE, Integer.TYPE);
         methodObject30409 = Connection.class.getDeclaredMethod("prepareStatement", String.class, Integer.TYPE, Integer.TYPE);
         methodObject30412 = Connection.class.getDeclaredMethod("prepareStatement", String.class, int[].class);
         methodObject30391 = Connection.class.getDeclaredMethod("rollback");
         methodObject30401 = Connection.class.getDeclaredMethod("createSQLXML");
         methodObject30414 = Connection.class.getDeclaredMethod("getCatalog");
         methodObject30430 = Connection.class.getDeclaredMethod("getNetworkTimeout");
         methodObject30410 = Connection.class.getDeclaredMethod("prepareStatement", String.class, Integer.TYPE, Integer.TYPE, Integer.TYPE);
         methodObject30396 = Connection.class.getDeclaredMethod("createArrayOf", String.class, Object[].class);
         methodObject30389 = Connection.class.getDeclaredMethod("abort", Executor.class);
         methodObject30387 = Connection.class.getDeclaredMethod("isValid", Integer.TYPE);
         methodObject30394 = Connection.class.getDeclaredMethod("setSavepoint", String.class);
         methodObject30429 = Connection.class.getDeclaredMethod("setTypeMap", Map.class);
         methodObject30434 = Connection.class.getDeclaredMethod("getClientInfo");
         methodObject30420 = Connection.class.getDeclaredMethod("nativeSQL", String.class);
         methodObject30407 = Connection.class.getDeclaredMethod("prepareCall", String.class, Integer.TYPE, Integer.TYPE, Integer.TYPE);
         methodObject30388 = Connection.class.getDeclaredMethod("isReadOnly");
         methodObject30405 = Connection.class.getDeclaredMethod("prepareCall", String.class);
         methodObject30421 = Connection.class.getDeclaredMethod("setAutoCommit", Boolean.TYPE);
         methodObject30398 = Connection.class.getDeclaredMethod("createBlob");
         methodObject30438 = Wrapper.class.getDeclaredMethod("isWrapperFor", Class.class);
         methodObject30437 = Wrapper.class.getDeclaredMethod("unwrap", Class.class);
         methodObject30395 = Connection.class.getDeclaredMethod("releaseSavepoint", Savepoint.class);
         methodObject30431 = Connection.class.getDeclaredMethod("clearWarnings");
         methodObject30425 = Connection.class.getDeclaredMethod("setHoldability", Integer.TYPE);
         methodObject30433 = Connection.class.getDeclaredMethod("getClientInfo", String.class);
         methodObject30402 = Connection.class.getDeclaredMethod("createStatement");
         methodObject30417 = Connection.class.getDeclaredMethod("getMetaData");
         methodObject30415 = Connection.class.getDeclaredMethod("isClosed");
         methodObject30418 = Connection.class.getDeclaredMethod("getTypeMap");
         methodObject30427 = Connection.class.getDeclaredMethod("setSchema", String.class);
         methodObject30390 = Connection.class.getDeclaredMethod("commit");
         methodObject30419 = Connection.class.getDeclaredMethod("getWarnings");
         methodObject30428 = Connection.class.getDeclaredMethod("setTransactionIsolation", Integer.TYPE);
         methodObject30424 = Connection.class.getDeclaredMethod("setClientInfo", Properties.class);
         methodObject30426 = Connection.class.getDeclaredMethod("setNetworkTimeout", Executor.class, Integer.TYPE);
      } catch (Throwable var1) {
         throw new RuntimeException(var1);
      }
   }

   public oracle$1jdbc$1replay$1driver$1NonTxnReplayableConnection$2java$1sql$1Connection$$$Proxy(Connection var1, Object var2, ProxyFactory var3, Map var4) {
      this.delegate = var1;
      this.creator = var2;
      this.proxyFactory = var3;
      this.proxyCache = var4;
   }
}
