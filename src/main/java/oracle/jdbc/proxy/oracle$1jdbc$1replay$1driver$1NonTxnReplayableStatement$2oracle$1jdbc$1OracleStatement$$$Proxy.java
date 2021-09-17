package oracle.jdbc.proxy;

import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLWarning;
import java.sql.Statement;
import java.sql.Wrapper;
import java.util.Map;
import oracle.jdbc.OracleStatement;
import oracle.jdbc.dcn.DatabaseChangeRegistration;
import oracle.jdbc.replay.driver.NonTxnReplayableStatement;

public abstract class oracle$1jdbc$1replay$1driver$1NonTxnReplayableStatement$2oracle$1jdbc$1OracleStatement$$$Proxy extends NonTxnReplayableStatement implements OracleStatement, _Proxy_ {
   private OracleStatement delegate;
   private final Object creator;
   private final ProxyFactory proxyFactory;
   private final Map proxyCache;
   private static Object[] zeroLengthObjectArray = new Object[0];
   private static Method methodObject27059;
   private static Method methodObject27053;
   private static Method methodObject27060;
   private static Method methodObject27086;
   private static Method methodObject27061;
   private static Method methodObject27056;
   private static Method methodObject27100;
   private static Method methodObject27069;
   private static Method methodObject27052;
   private static Method methodObject27066;
   private static Method methodObject27048;
   private static Method methodObject27085;
   private static Method methodObject27065;
   private static Method methodObject27103;
   private static Method methodObject27051;
   private static Method methodObject27064;
   private static Method methodObject27075;
   private static Method methodObject27068;
   private static Method methodObject27057;
   private static Method methodObject27073;
   private static Method methodObject27084;
   private static Method methodObject27090;
   private static Method methodObject27062;
   private static Method methodObject27096;
   private static Method methodObject27050;
   private static Method methodObject27089;
   private static Method methodObject27074;
   private static Method methodObject27055;
   private static Method methodObject27094;
   private static Method methodObject27095;
   private static Method methodObject27099;
   private static Method methodObject27054;
   private static Method methodObject27078;
   private static Method methodObject27049;
   private static Method methodObject27106;
   private static Method methodObject27105;
   private static Method methodObject27104;
   private static Method methodObject27088;
   private static Method methodObject27097;
   private static Method methodObject27076;
   private static Method methodObject27072;
   private static Method methodObject27093;
   private static Method methodObject27098;
   private static Method methodObject27082;
   private static Method methodObject27091;
   private static Method methodObject27063;
   private static Method methodObject27067;
   private static Method methodObject27108;
   private static Method methodObject27107;
   private static Method methodObject27083;
   private static Method methodObject27092;
   private static Method methodObject27081;
   private static Method methodObject27058;
   private static Method methodObject27101;
   private static Method methodObject27077;
   private static Method methodObject27087;
   private static Method methodObject27070;
   private static Method methodObject27080;
   private static Method methodObject27102;
   private static Method methodObject27071;
   private static Method methodObject27079;

   public void setLobPrefetchSize(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject27059, this, arg0);
         this.delegate.setLobPrefetchSize(arg0);
      } catch (SQLException var3) {
         this.onErrorVoidForAll(methodObject27059, var3);
      }
   }

   public void defineColumnType(int arg0, int arg1, String arg2) throws SQLException {
      try {
         super.preForAll(methodObject27053, this, arg0, arg1, arg2);
         this.delegate.defineColumnType(arg0, arg1, arg2);
      } catch (SQLException var5) {
         this.onErrorVoidForAll(methodObject27053, var5);
      }
   }

   public void closeWithKey(String arg0) throws SQLException {
      try {
         super.preForAll(methodObject27060, this, arg0);
         this.delegate.closeWithKey(arg0);
      } catch (SQLException var3) {
         this.onErrorVoidForAll(methodObject27060, var3);
      }
   }

   public ResultSet getGeneratedKeys() throws SQLException {
      try {
         super.preForAll(methodObject27086, this, zeroLengthObjectArray);
         return (ResultSet)this.postForAll(methodObject27086, this.proxyFactory.proxyForCache((Object)this.delegate.getGeneratedKeys(), this, this.proxyCache, methodObject27086));
      } catch (SQLException var2) {
         return (ResultSet)this.postForAll(methodObject27086, this.onErrorForAll(methodObject27086, var2));
      }
   }

   public int creationState() {
      super.preForAll(methodObject27061, this, zeroLengthObjectArray);
      return (Integer)this.postForAll(methodObject27061, this.delegate.creationState());
   }

   public int getRowPrefetch() {
      super.preForAll(methodObject27056, this, zeroLengthObjectArray);
      return (Integer)this.postForAll(methodObject27056, this.delegate.getRowPrefetch());
   }

   public void setMaxRows(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject27100, this, arg0);
         this.delegate.setMaxRows(arg0);
      } catch (SQLException var3) {
         this.onErrorVoidForAll(methodObject27100, var3);
      }
   }

   public boolean execute(String arg0, String[] arg1) throws SQLException {
      try {
         super.preForExecute(methodObject27069, this, arg0, arg1);
         return this.postForExecute(methodObject27069, this.delegate.execute(arg0, arg1));
      } catch (SQLException var4) {
         return this.postForExecute(methodObject27069, this.onErrorForExecute(methodObject27069, var4));
      }
   }

   public void defineColumnType(int arg0, int arg1, int arg2, short arg3) throws SQLException {
      try {
         super.preForAll(methodObject27052, this, arg0, arg1, arg2, arg3);
         this.delegate.defineColumnType(arg0, arg1, arg2, arg3);
      } catch (SQLException var6) {
         this.onErrorVoidForAll(methodObject27052, var6);
      }
   }

   public boolean execute(String arg0) throws SQLException {
      try {
         super.preForExecute(methodObject27066, this, arg0);
         return this.postForExecute(methodObject27066, this.delegate.execute(arg0));
      } catch (SQLException var3) {
         return this.postForExecute(methodObject27066, this.onErrorForExecute(methodObject27066, var3));
      }
   }

   public boolean isNCHAR(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject27048, this, arg0);
         return (Boolean)this.postForAll(methodObject27048, this.delegate.isNCHAR(arg0));
      } catch (SQLException var3) {
         return (Boolean)this.postForAll(methodObject27048, this.onErrorForAll(methodObject27048, var3));
      }
   }

   public void closeOnCompletion() throws SQLException {
      try {
         super.preForAll(methodObject27085, this, zeroLengthObjectArray);
         this.delegate.closeOnCompletion();
      } catch (SQLException var2) {
         this.onErrorVoidForAll(methodObject27085, var2);
      }
   }

   public void close() throws SQLException {
      try {
         super.preForAll(methodObject27065, this, zeroLengthObjectArray);
         Method var10001 = methodObject27065;
         this.delegate.close();
         this.postForClose(var10001);
      } catch (SQLException var2) {
         this.onErrorVoidForClose(methodObject27065, var2);
      }
   }

   public int getFetchDirection() throws SQLException {
      try {
         super.preForAll(methodObject27103, this, zeroLengthObjectArray);
         return (Integer)this.postForAll(methodObject27103, this.delegate.getFetchDirection());
      } catch (SQLException var2) {
         return (Integer)this.postForAll(methodObject27103, this.onErrorForAll(methodObject27103, var2));
      }
   }

   public void defineColumnType(int arg0, int arg1, int arg2) throws SQLException {
      try {
         super.preForAll(methodObject27051, this, arg0, arg1, arg2);
         this.delegate.defineColumnType(arg0, arg1, arg2);
      } catch (SQLException var5) {
         this.onErrorVoidForAll(methodObject27051, var5);
      }
   }

   public long getRegisteredQueryId() throws SQLException {
      try {
         super.preForAll(methodObject27064, this, zeroLengthObjectArray);
         return (Long)this.postForAll(methodObject27064, this.delegate.getRegisteredQueryId());
      } catch (SQLException var2) {
         return (Long)this.postForAll(methodObject27064, this.onErrorForAll(methodObject27064, var2));
      }
   }

   public int executeUpdate(String arg0, int[] arg1) throws SQLException {
      try {
         super.preForExecuteUpdate(methodObject27075, this, arg0, arg1);
         return this.postForExecuteUpdate(methodObject27075, this.delegate.executeUpdate(arg0, arg1));
      } catch (SQLException var4) {
         return this.postForExecuteUpdate(methodObject27075, (Integer)this.onErrorForAll(methodObject27075, var4));
      }
   }

   public boolean execute(String arg0, int[] arg1) throws SQLException {
      try {
         super.preForExecute(methodObject27068, this, arg0, arg1);
         return this.postForExecute(methodObject27068, this.delegate.execute(arg0, arg1));
      } catch (SQLException var4) {
         return this.postForExecute(methodObject27068, this.onErrorForExecute(methodObject27068, var4));
      }
   }

   public void setRowPrefetch(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject27057, this, arg0);
         this.delegate.setRowPrefetch(arg0);
      } catch (SQLException var3) {
         this.onErrorVoidForAll(methodObject27057, var3);
      }
   }

   public int executeUpdate(String arg0) throws SQLException {
      try {
         super.preForExecuteUpdate(methodObject27073, this, arg0);
         return this.postForExecuteUpdate(methodObject27073, this.delegate.executeUpdate(arg0));
      } catch (SQLException var3) {
         return this.postForExecuteUpdate(methodObject27073, (Integer)this.onErrorForAll(methodObject27073, var3));
      }
   }

   public void clearBatch() throws SQLException {
      try {
         super.preForAll(methodObject27084, this, zeroLengthObjectArray);
         this.delegate.clearBatch();
      } catch (SQLException var2) {
         this.onErrorVoidForAll(methodObject27084, var2);
      }
   }

   public boolean getMoreResults(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject27090, this, arg0);
         return (Boolean)this.postForAll(methodObject27090, this.delegate.getMoreResults(arg0));
      } catch (SQLException var3) {
         return (Boolean)this.postForAll(methodObject27090, this.onErrorForAll(methodObject27090, var3));
      }
   }

   public void setDatabaseChangeRegistration(DatabaseChangeRegistration arg0) throws SQLException {
      try {
         super.preForAll(methodObject27062, this, arg0);
         this.delegate.setDatabaseChangeRegistration(arg0);
      } catch (SQLException var3) {
         this.onErrorVoidForAll(methodObject27062, var3);
      }
   }

   public boolean isPoolable() throws SQLException {
      try {
         super.preForAll(methodObject27096, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject27096, this.delegate.isPoolable());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject27096, this.onErrorForAll(methodObject27096, var2));
      }
   }

   public void defineColumnType(int arg0, int arg1) throws SQLException {
      try {
         super.preForAll(methodObject27050, this, arg0, arg1);
         this.delegate.defineColumnType(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject27050, var4);
      }
   }

   public boolean getMoreResults() throws SQLException {
      try {
         super.preForAll(methodObject27089, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject27089, this.delegate.getMoreResults());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject27089, this.onErrorForAll(methodObject27089, var2));
      }
   }

   public int executeUpdate(String arg0, int arg1) throws SQLException {
      try {
         super.preForExecuteUpdate(methodObject27074, this, arg0, arg1);
         return this.postForExecuteUpdate(methodObject27074, this.delegate.executeUpdate(arg0, arg1));
      } catch (SQLException var4) {
         return this.postForExecuteUpdate(methodObject27074, (Integer)this.onErrorForAll(methodObject27074, var4));
      }
   }

   public void defineColumnTypeChars(int arg0, int arg1, int arg2) throws SQLException {
      try {
         super.preForAll(methodObject27055, this, arg0, arg1, arg2);
         this.delegate.defineColumnTypeChars(arg0, arg1, arg2);
      } catch (SQLException var5) {
         this.onErrorVoidForAll(methodObject27055, var5);
      }
   }

   public int getUpdateCount() throws SQLException {
      try {
         super.preForAll(methodObject27094, this, zeroLengthObjectArray);
         return (Integer)this.postForAll(methodObject27094, this.delegate.getUpdateCount());
      } catch (SQLException var2) {
         return (Integer)this.postForAll(methodObject27094, this.onErrorForAll(methodObject27094, var2));
      }
   }

   public boolean isCloseOnCompletion() throws SQLException {
      try {
         super.preForAll(methodObject27095, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject27095, this.delegate.isCloseOnCompletion());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject27095, this.onErrorForAll(methodObject27095, var2));
      }
   }

   public void setMaxFieldSize(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject27099, this, arg0);
         this.delegate.setMaxFieldSize(arg0);
      } catch (SQLException var3) {
         this.onErrorVoidForAll(methodObject27099, var3);
      }
   }

   public void defineColumnTypeBytes(int arg0, int arg1, int arg2) throws SQLException {
      try {
         super.preForAll(methodObject27054, this, arg0, arg1, arg2);
         this.delegate.defineColumnTypeBytes(arg0, arg1, arg2);
      } catch (SQLException var5) {
         this.onErrorVoidForAll(methodObject27054, var5);
      }
   }

   public ResultSet executeQuery(String arg0) throws SQLException {
      try {
         super.preForAll(methodObject27078, this, arg0);
         return this.postForExecuteQuery(methodObject27078, (ResultSet)this.proxyFactory.proxyForCreateCache((Object)this.delegate.executeQuery(arg0), this, this.proxyCache, methodObject27078));
      } catch (SQLException var3) {
         return this.postForExecuteQuery(methodObject27078, (ResultSet)this.onErrorForAll(methodObject27078, var3));
      }
   }

   public void clearDefines() throws SQLException {
      try {
         super.preForAll(methodObject27049, this, zeroLengthObjectArray);
         this.delegate.clearDefines();
      } catch (SQLException var2) {
         this.onErrorVoidForAll(methodObject27049, var2);
      }
   }

   public void setFetchSize(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject27106, this, arg0);
         this.delegate.setFetchSize(arg0);
      } catch (SQLException var3) {
         this.onErrorVoidForAll(methodObject27106, var3);
      }
   }

   public void setFetchDirection(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject27105, this, arg0);
         this.delegate.setFetchDirection(arg0);
      } catch (SQLException var3) {
         this.onErrorVoidForAll(methodObject27105, var3);
      }
   }

   public int getFetchSize() throws SQLException {
      try {
         super.preForAll(methodObject27104, this, zeroLengthObjectArray);
         return (Integer)this.postForAll(methodObject27104, this.delegate.getFetchSize());
      } catch (SQLException var2) {
         return (Integer)this.postForAll(methodObject27104, this.onErrorForAll(methodObject27104, var2));
      }
   }

   public int getMaxRows() throws SQLException {
      try {
         super.preForAll(methodObject27088, this, zeroLengthObjectArray);
         return (Integer)this.postForAll(methodObject27088, this.delegate.getMaxRows());
      } catch (SQLException var2) {
         return (Integer)this.postForAll(methodObject27088, this.onErrorForAll(methodObject27088, var2));
      }
   }

   public void setCursorName(String arg0) throws SQLException {
      try {
         super.preForAll(methodObject27097, this, arg0);
         this.delegate.setCursorName(arg0);
      } catch (SQLException var3) {
         this.onErrorVoidForAll(methodObject27097, var3);
      }
   }

   public int executeUpdate(String arg0, String[] arg1) throws SQLException {
      try {
         super.preForExecuteUpdate(methodObject27076, this, arg0, arg1);
         return this.postForExecuteUpdate(methodObject27076, this.delegate.executeUpdate(arg0, arg1));
      } catch (SQLException var4) {
         return this.postForExecuteUpdate(methodObject27076, (Integer)this.onErrorForAll(methodObject27076, var4));
      }
   }

   public int[] executeBatch() throws SQLException {
      try {
         super.preForExecuteBatch(methodObject27072, this, zeroLengthObjectArray);
         return (int[])this.postForAll(methodObject27072, (Object)this.delegate.executeBatch());
      } catch (SQLException var2) {
         return (int[])this.postForAll(methodObject27072, this.onErrorForAll(methodObject27072, var2));
      }
   }

   public int getResultSetType() throws SQLException {
      try {
         super.preForAll(methodObject27093, this, zeroLengthObjectArray);
         return (Integer)this.postForAll(methodObject27093, this.delegate.getResultSetType());
      } catch (SQLException var2) {
         return (Integer)this.postForAll(methodObject27093, this.onErrorForAll(methodObject27093, var2));
      }
   }

   public void setEscapeProcessing(boolean arg0) throws SQLException {
      try {
         super.preForAll(methodObject27098, this, arg0);
         this.delegate.setEscapeProcessing(arg0);
      } catch (SQLException var3) {
         this.onErrorVoidForAll(methodObject27098, var3);
      }
   }

   public int getResultSetHoldability() throws SQLException {
      try {
         super.preForAll(methodObject27082, this, zeroLengthObjectArray);
         return (Integer)this.postForAll(methodObject27082, this.delegate.getResultSetHoldability());
      } catch (SQLException var2) {
         return (Integer)this.postForAll(methodObject27082, this.onErrorForAll(methodObject27082, var2));
      }
   }

   public int getQueryTimeout() throws SQLException {
      try {
         super.preForAll(methodObject27091, this, zeroLengthObjectArray);
         return (Integer)this.postForAll(methodObject27091, this.delegate.getQueryTimeout());
      } catch (SQLException var2) {
         return (Integer)this.postForAll(methodObject27091, this.onErrorForAll(methodObject27091, var2));
      }
   }

   public String[] getRegisteredTableNames() throws SQLException {
      try {
         super.preForAll(methodObject27063, this, zeroLengthObjectArray);
         return (String[])this.postForAll(methodObject27063, (Object)this.delegate.getRegisteredTableNames());
      } catch (SQLException var2) {
         return (String[])this.postForAll(methodObject27063, this.onErrorForAll(methodObject27063, var2));
      }
   }

   public boolean execute(String arg0, int arg1) throws SQLException {
      try {
         super.preForExecute(methodObject27067, this, arg0, arg1);
         return this.postForExecute(methodObject27067, this.delegate.execute(arg0, arg1));
      } catch (SQLException var4) {
         return this.postForExecute(methodObject27067, this.onErrorForExecute(methodObject27067, var4));
      }
   }

   public boolean isWrapperFor(Class arg0) throws SQLException {
      try {
         super.preForAll(methodObject27108, this, arg0);
         return (Boolean)this.postForAll(methodObject27108, this.delegate.isWrapperFor(arg0));
      } catch (SQLException var3) {
         return (Boolean)this.postForAll(methodObject27108, this.onErrorForAll(methodObject27108, var3));
      }
   }

   public Object unwrap(Class arg0) throws SQLException {
      try {
         super.preForAll(methodObject27107, this, arg0);
         return this.postForAll(methodObject27107, super.unwrap(arg0));
      } catch (SQLException var3) {
         return this.postForAll(methodObject27107, this.onErrorForAll(methodObject27107, var3));
      }
   }

   public void addBatch(String arg0) throws SQLException {
      try {
         super.preForAll(methodObject27083, this, arg0);
         this.delegate.addBatch(arg0);
      } catch (SQLException var3) {
         this.onErrorVoidForAll(methodObject27083, var3);
      }
   }

   public int getResultSetConcurrency() throws SQLException {
      try {
         super.preForAll(methodObject27092, this, zeroLengthObjectArray);
         return (Integer)this.postForAll(methodObject27092, this.delegate.getResultSetConcurrency());
      } catch (SQLException var2) {
         return (Integer)this.postForAll(methodObject27092, this.onErrorForAll(methodObject27092, var2));
      }
   }

   public void clearWarnings() throws SQLException {
      try {
         super.preForAll(methodObject27081, this, zeroLengthObjectArray);
         this.delegate.clearWarnings();
      } catch (SQLException var2) {
         this.onErrorVoidForAll(methodObject27081, var2);
      }
   }

   public int getLobPrefetchSize() throws SQLException {
      try {
         super.preForAll(methodObject27058, this, zeroLengthObjectArray);
         return (Integer)this.postForAll(methodObject27058, this.delegate.getLobPrefetchSize());
      } catch (SQLException var2) {
         return (Integer)this.postForAll(methodObject27058, this.onErrorForAll(methodObject27058, var2));
      }
   }

   public void setPoolable(boolean arg0) throws SQLException {
      try {
         super.preForAll(methodObject27101, this, arg0);
         this.delegate.setPoolable(arg0);
      } catch (SQLException var3) {
         this.onErrorVoidForAll(methodObject27101, var3);
      }
   }

   public boolean isClosed() throws SQLException {
      try {
         super.preForAll(methodObject27077, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject27077, this.delegate.isClosed());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject27077, this.onErrorForAll(methodObject27077, var2));
      }
   }

   public int getMaxFieldSize() throws SQLException {
      try {
         super.preForAll(methodObject27087, this, zeroLengthObjectArray);
         return (Integer)this.postForAll(methodObject27087, this.delegate.getMaxFieldSize());
      } catch (SQLException var2) {
         return (Integer)this.postForAll(methodObject27087, this.onErrorForAll(methodObject27087, var2));
      }
   }

   public void cancel() throws SQLException {
      try {
         super.preForAll(methodObject27070, this, zeroLengthObjectArray);
         this.delegate.cancel();
      } catch (SQLException var2) {
         this.onErrorVoidForAll(methodObject27070, var2);
      }
   }

   public SQLWarning getWarnings() throws SQLException {
      try {
         super.preForAll(methodObject27080, this, zeroLengthObjectArray);
         return (SQLWarning)this.postForAll(methodObject27080, (Object)this.delegate.getWarnings());
      } catch (SQLException var2) {
         return (SQLWarning)this.postForAll(methodObject27080, this.onErrorForAll(methodObject27080, var2));
      }
   }

   public void setQueryTimeout(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject27102, this, arg0);
         this.delegate.setQueryTimeout(arg0);
      } catch (SQLException var3) {
         this.onErrorVoidForAll(methodObject27102, var3);
      }
   }

   public ResultSet getResultSet() throws SQLException {
      try {
         super.preForAll(methodObject27071, this, zeroLengthObjectArray);
         return (ResultSet)this.postForAll(methodObject27071, this.proxyFactory.proxyForCache((Object)this.delegate.getResultSet(), this, this.proxyCache, methodObject27071));
      } catch (SQLException var2) {
         return (ResultSet)this.postForAll(methodObject27071, this.onErrorForAll(methodObject27071, var2));
      }
   }

   public Connection getConnection() throws SQLException {
      try {
         super.preForAll(methodObject27079, this, zeroLengthObjectArray);
         return (Connection)this.postForAll(methodObject27079, (Object)super.getConnection());
      } catch (SQLException var2) {
         return (Connection)this.postForAll(methodObject27079, this.onErrorForAll(methodObject27079, var2));
      }
   }

   public OracleStatement _getDelegate_() {
      return this.delegate;
   }

   public Object getDelegate() {
      return this.delegate;
   }

   public void setDelegate(Object delegate) {
      this.proxyFactory.updateDelegate(this, this.delegate, delegate);
      this.delegate = (OracleStatement)delegate;
   }

   public Object getCreator() {
      return this.creator;
   }

   static {
      try {
         methodObject27059 = OracleStatement.class.getDeclaredMethod("setLobPrefetchSize", Integer.TYPE);
         methodObject27053 = OracleStatement.class.getDeclaredMethod("defineColumnType", Integer.TYPE, Integer.TYPE, String.class);
         methodObject27060 = OracleStatement.class.getDeclaredMethod("closeWithKey", String.class);
         methodObject27086 = Statement.class.getDeclaredMethod("getGeneratedKeys");
         methodObject27061 = OracleStatement.class.getDeclaredMethod("creationState");
         methodObject27056 = OracleStatement.class.getDeclaredMethod("getRowPrefetch");
         methodObject27100 = Statement.class.getDeclaredMethod("setMaxRows", Integer.TYPE);
         methodObject27069 = Statement.class.getDeclaredMethod("execute", String.class, String[].class);
         methodObject27052 = OracleStatement.class.getDeclaredMethod("defineColumnType", Integer.TYPE, Integer.TYPE, Integer.TYPE, Short.TYPE);
         methodObject27066 = Statement.class.getDeclaredMethod("execute", String.class);
         methodObject27048 = OracleStatement.class.getDeclaredMethod("isNCHAR", Integer.TYPE);
         methodObject27085 = Statement.class.getDeclaredMethod("closeOnCompletion");
         methodObject27065 = Statement.class.getDeclaredMethod("close");
         methodObject27103 = Statement.class.getDeclaredMethod("getFetchDirection");
         methodObject27051 = OracleStatement.class.getDeclaredMethod("defineColumnType", Integer.TYPE, Integer.TYPE, Integer.TYPE);
         methodObject27064 = OracleStatement.class.getDeclaredMethod("getRegisteredQueryId");
         methodObject27075 = Statement.class.getDeclaredMethod("executeUpdate", String.class, int[].class);
         methodObject27068 = Statement.class.getDeclaredMethod("execute", String.class, int[].class);
         methodObject27057 = OracleStatement.class.getDeclaredMethod("setRowPrefetch", Integer.TYPE);
         methodObject27073 = Statement.class.getDeclaredMethod("executeUpdate", String.class);
         methodObject27084 = Statement.class.getDeclaredMethod("clearBatch");
         methodObject27090 = Statement.class.getDeclaredMethod("getMoreResults", Integer.TYPE);
         methodObject27062 = OracleStatement.class.getDeclaredMethod("setDatabaseChangeRegistration", DatabaseChangeRegistration.class);
         methodObject27096 = Statement.class.getDeclaredMethod("isPoolable");
         methodObject27050 = OracleStatement.class.getDeclaredMethod("defineColumnType", Integer.TYPE, Integer.TYPE);
         methodObject27089 = Statement.class.getDeclaredMethod("getMoreResults");
         methodObject27074 = Statement.class.getDeclaredMethod("executeUpdate", String.class, Integer.TYPE);
         methodObject27055 = OracleStatement.class.getDeclaredMethod("defineColumnTypeChars", Integer.TYPE, Integer.TYPE, Integer.TYPE);
         methodObject27094 = Statement.class.getDeclaredMethod("getUpdateCount");
         methodObject27095 = Statement.class.getDeclaredMethod("isCloseOnCompletion");
         methodObject27099 = Statement.class.getDeclaredMethod("setMaxFieldSize", Integer.TYPE);
         methodObject27054 = OracleStatement.class.getDeclaredMethod("defineColumnTypeBytes", Integer.TYPE, Integer.TYPE, Integer.TYPE);
         methodObject27078 = Statement.class.getDeclaredMethod("executeQuery", String.class);
         methodObject27049 = OracleStatement.class.getDeclaredMethod("clearDefines");
         methodObject27106 = Statement.class.getDeclaredMethod("setFetchSize", Integer.TYPE);
         methodObject27105 = Statement.class.getDeclaredMethod("setFetchDirection", Integer.TYPE);
         methodObject27104 = Statement.class.getDeclaredMethod("getFetchSize");
         methodObject27088 = Statement.class.getDeclaredMethod("getMaxRows");
         methodObject27097 = Statement.class.getDeclaredMethod("setCursorName", String.class);
         methodObject27076 = Statement.class.getDeclaredMethod("executeUpdate", String.class, String[].class);
         methodObject27072 = Statement.class.getDeclaredMethod("executeBatch");
         methodObject27093 = Statement.class.getDeclaredMethod("getResultSetType");
         methodObject27098 = Statement.class.getDeclaredMethod("setEscapeProcessing", Boolean.TYPE);
         methodObject27082 = Statement.class.getDeclaredMethod("getResultSetHoldability");
         methodObject27091 = Statement.class.getDeclaredMethod("getQueryTimeout");
         methodObject27063 = OracleStatement.class.getDeclaredMethod("getRegisteredTableNames");
         methodObject27067 = Statement.class.getDeclaredMethod("execute", String.class, Integer.TYPE);
         methodObject27108 = Wrapper.class.getDeclaredMethod("isWrapperFor", Class.class);
         methodObject27107 = Wrapper.class.getDeclaredMethod("unwrap", Class.class);
         methodObject27083 = Statement.class.getDeclaredMethod("addBatch", String.class);
         methodObject27092 = Statement.class.getDeclaredMethod("getResultSetConcurrency");
         methodObject27081 = Statement.class.getDeclaredMethod("clearWarnings");
         methodObject27058 = OracleStatement.class.getDeclaredMethod("getLobPrefetchSize");
         methodObject27101 = Statement.class.getDeclaredMethod("setPoolable", Boolean.TYPE);
         methodObject27077 = Statement.class.getDeclaredMethod("isClosed");
         methodObject27087 = Statement.class.getDeclaredMethod("getMaxFieldSize");
         methodObject27070 = Statement.class.getDeclaredMethod("cancel");
         methodObject27080 = Statement.class.getDeclaredMethod("getWarnings");
         methodObject27102 = Statement.class.getDeclaredMethod("setQueryTimeout", Integer.TYPE);
         methodObject27071 = Statement.class.getDeclaredMethod("getResultSet");
         methodObject27079 = Statement.class.getDeclaredMethod("getConnection");
      } catch (Throwable var1) {
         throw new RuntimeException(var1);
      }
   }

   public oracle$1jdbc$1replay$1driver$1NonTxnReplayableStatement$2oracle$1jdbc$1OracleStatement$$$Proxy(OracleStatement var1, Object var2, ProxyFactory var3, Map var4) {
      this.delegate = var1;
      this.creator = var2;
      this.proxyFactory = var3;
      this.proxyCache = var4;
   }
}
