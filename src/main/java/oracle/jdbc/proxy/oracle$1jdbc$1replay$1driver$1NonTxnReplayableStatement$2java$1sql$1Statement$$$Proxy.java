package oracle.jdbc.proxy;

import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLWarning;
import java.sql.Statement;
import java.sql.Wrapper;
import java.util.Map;
import oracle.jdbc.replay.driver.NonTxnReplayableStatement;

public abstract class oracle$1jdbc$1replay$1driver$1NonTxnReplayableStatement$2java$1sql$1Statement$$$Proxy extends NonTxnReplayableStatement implements Statement, _Proxy_ {
   private Statement delegate;
   private final Object creator;
   private final ProxyFactory proxyFactory;
   private final Map proxyCache;
   private static Object[] zeroLengthObjectArray = new Object[0];
   private static Method methodObject26378;
   private static Method methodObject26377;
   private static Method methodObject26376;
   private static Method methodObject26358;
   private static Method methodObject26372;
   private static Method methodObject26360;
   private static Method methodObject26369;
   private static Method methodObject26348;
   private static Method methodObject26341;
   private static Method methodObject26344;
   private static Method methodObject26338;
   private static Method methodObject26357;
   private static Method methodObject26365;
   private static Method methodObject26337;
   private static Method methodObject26375;
   private static Method methodObject26370;
   private static Method methodObject26363;
   private static Method methodObject26354;
   private static Method methodObject26339;
   private static Method methodObject26347;
   private static Method methodObject26380;
   private static Method methodObject26379;
   private static Method methodObject26355;
   private static Method methodObject26364;
   private static Method methodObject26353;
   private static Method methodObject26340;
   private static Method methodObject26362;
   private static Method methodObject26345;
   private static Method methodObject26356;
   private static Method methodObject26368;
   private static Method methodObject26361;
   private static Method methodObject26346;
   private static Method methodObject26373;
   private static Method methodObject26349;
   private static Method methodObject26366;
   private static Method methodObject26359;
   private static Method methodObject26367;
   private static Method methodObject26371;
   private static Method methodObject26342;
   private static Method methodObject26352;
   private static Method methodObject26350;
   private static Method methodObject26374;
   private static Method methodObject26343;
   private static Method methodObject26351;

   public void setFetchSize(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject26378, this, arg0);
         this.delegate.setFetchSize(arg0);
      } catch (SQLException var3) {
         this.onErrorVoidForAll(methodObject26378, var3);
      }
   }

   public void setFetchDirection(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject26377, this, arg0);
         this.delegate.setFetchDirection(arg0);
      } catch (SQLException var3) {
         this.onErrorVoidForAll(methodObject26377, var3);
      }
   }

   public int getFetchSize() throws SQLException {
      try {
         super.preForAll(methodObject26376, this, zeroLengthObjectArray);
         return (Integer)this.postForAll(methodObject26376, this.delegate.getFetchSize());
      } catch (SQLException var2) {
         return (Integer)this.postForAll(methodObject26376, this.onErrorForAll(methodObject26376, var2));
      }
   }

   public ResultSet getGeneratedKeys() throws SQLException {
      try {
         super.preForAll(methodObject26358, this, zeroLengthObjectArray);
         return (ResultSet)this.postForAll(methodObject26358, this.proxyFactory.proxyForCache((Object)this.delegate.getGeneratedKeys(), this, this.proxyCache, methodObject26358));
      } catch (SQLException var2) {
         return (ResultSet)this.postForAll(methodObject26358, this.onErrorForAll(methodObject26358, var2));
      }
   }

   public void setMaxRows(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject26372, this, arg0);
         this.delegate.setMaxRows(arg0);
      } catch (SQLException var3) {
         this.onErrorVoidForAll(methodObject26372, var3);
      }
   }

   public int getMaxRows() throws SQLException {
      try {
         super.preForAll(methodObject26360, this, zeroLengthObjectArray);
         return (Integer)this.postForAll(methodObject26360, this.delegate.getMaxRows());
      } catch (SQLException var2) {
         return (Integer)this.postForAll(methodObject26360, this.onErrorForAll(methodObject26360, var2));
      }
   }

   public void setCursorName(String arg0) throws SQLException {
      try {
         super.preForAll(methodObject26369, this, arg0);
         this.delegate.setCursorName(arg0);
      } catch (SQLException var3) {
         this.onErrorVoidForAll(methodObject26369, var3);
      }
   }

   public int executeUpdate(String arg0, String[] arg1) throws SQLException {
      try {
         super.preForExecuteUpdate(methodObject26348, this, arg0, arg1);
         return this.postForExecuteUpdate(methodObject26348, this.delegate.executeUpdate(arg0, arg1));
      } catch (SQLException var4) {
         return this.postForExecuteUpdate(methodObject26348, (Integer)this.onErrorForAll(methodObject26348, var4));
      }
   }

   public boolean execute(String arg0, String[] arg1) throws SQLException {
      try {
         super.preForExecute(methodObject26341, this, arg0, arg1);
         return this.postForExecute(methodObject26341, this.delegate.execute(arg0, arg1));
      } catch (SQLException var4) {
         return this.postForExecute(methodObject26341, this.onErrorForExecute(methodObject26341, var4));
      }
   }

   public int[] executeBatch() throws SQLException {
      try {
         super.preForExecuteBatch(methodObject26344, this, zeroLengthObjectArray);
         return (int[])this.postForAll(methodObject26344, (Object)this.delegate.executeBatch());
      } catch (SQLException var2) {
         return (int[])this.postForAll(methodObject26344, this.onErrorForAll(methodObject26344, var2));
      }
   }

   public boolean execute(String arg0) throws SQLException {
      try {
         super.preForExecute(methodObject26338, this, arg0);
         return this.postForExecute(methodObject26338, this.delegate.execute(arg0));
      } catch (SQLException var3) {
         return this.postForExecute(methodObject26338, this.onErrorForExecute(methodObject26338, var3));
      }
   }

   public void closeOnCompletion() throws SQLException {
      try {
         super.preForAll(methodObject26357, this, zeroLengthObjectArray);
         this.delegate.closeOnCompletion();
      } catch (SQLException var2) {
         this.onErrorVoidForAll(methodObject26357, var2);
      }
   }

   public int getResultSetType() throws SQLException {
      try {
         super.preForAll(methodObject26365, this, zeroLengthObjectArray);
         return (Integer)this.postForAll(methodObject26365, this.delegate.getResultSetType());
      } catch (SQLException var2) {
         return (Integer)this.postForAll(methodObject26365, this.onErrorForAll(methodObject26365, var2));
      }
   }

   public void close() throws SQLException {
      try {
         super.preForAll(methodObject26337, this, zeroLengthObjectArray);
         Method var10001 = methodObject26337;
         this.delegate.close();
         this.postForClose(var10001);
      } catch (SQLException var2) {
         this.onErrorVoidForClose(methodObject26337, var2);
      }
   }

   public int getFetchDirection() throws SQLException {
      try {
         super.preForAll(methodObject26375, this, zeroLengthObjectArray);
         return (Integer)this.postForAll(methodObject26375, this.delegate.getFetchDirection());
      } catch (SQLException var2) {
         return (Integer)this.postForAll(methodObject26375, this.onErrorForAll(methodObject26375, var2));
      }
   }

   public void setEscapeProcessing(boolean arg0) throws SQLException {
      try {
         super.preForAll(methodObject26370, this, arg0);
         this.delegate.setEscapeProcessing(arg0);
      } catch (SQLException var3) {
         this.onErrorVoidForAll(methodObject26370, var3);
      }
   }

   public int getQueryTimeout() throws SQLException {
      try {
         super.preForAll(methodObject26363, this, zeroLengthObjectArray);
         return (Integer)this.postForAll(methodObject26363, this.delegate.getQueryTimeout());
      } catch (SQLException var2) {
         return (Integer)this.postForAll(methodObject26363, this.onErrorForAll(methodObject26363, var2));
      }
   }

   public int getResultSetHoldability() throws SQLException {
      try {
         super.preForAll(methodObject26354, this, zeroLengthObjectArray);
         return (Integer)this.postForAll(methodObject26354, this.delegate.getResultSetHoldability());
      } catch (SQLException var2) {
         return (Integer)this.postForAll(methodObject26354, this.onErrorForAll(methodObject26354, var2));
      }
   }

   public boolean execute(String arg0, int arg1) throws SQLException {
      try {
         super.preForExecute(methodObject26339, this, arg0, arg1);
         return this.postForExecute(methodObject26339, this.delegate.execute(arg0, arg1));
      } catch (SQLException var4) {
         return this.postForExecute(methodObject26339, this.onErrorForExecute(methodObject26339, var4));
      }
   }

   public int executeUpdate(String arg0, int[] arg1) throws SQLException {
      try {
         super.preForExecuteUpdate(methodObject26347, this, arg0, arg1);
         return this.postForExecuteUpdate(methodObject26347, this.delegate.executeUpdate(arg0, arg1));
      } catch (SQLException var4) {
         return this.postForExecuteUpdate(methodObject26347, (Integer)this.onErrorForAll(methodObject26347, var4));
      }
   }

   public boolean isWrapperFor(Class arg0) throws SQLException {
      try {
         super.preForAll(methodObject26380, this, arg0);
         return (Boolean)this.postForAll(methodObject26380, this.delegate.isWrapperFor(arg0));
      } catch (SQLException var3) {
         return (Boolean)this.postForAll(methodObject26380, this.onErrorForAll(methodObject26380, var3));
      }
   }

   public Object unwrap(Class arg0) throws SQLException {
      try {
         super.preForAll(methodObject26379, this, arg0);
         return this.postForAll(methodObject26379, super.unwrap(arg0));
      } catch (SQLException var3) {
         return this.postForAll(methodObject26379, this.onErrorForAll(methodObject26379, var3));
      }
   }

   public void addBatch(String arg0) throws SQLException {
      try {
         super.preForAll(methodObject26355, this, arg0);
         this.delegate.addBatch(arg0);
      } catch (SQLException var3) {
         this.onErrorVoidForAll(methodObject26355, var3);
      }
   }

   public int getResultSetConcurrency() throws SQLException {
      try {
         super.preForAll(methodObject26364, this, zeroLengthObjectArray);
         return (Integer)this.postForAll(methodObject26364, this.delegate.getResultSetConcurrency());
      } catch (SQLException var2) {
         return (Integer)this.postForAll(methodObject26364, this.onErrorForAll(methodObject26364, var2));
      }
   }

   public void clearWarnings() throws SQLException {
      try {
         super.preForAll(methodObject26353, this, zeroLengthObjectArray);
         this.delegate.clearWarnings();
      } catch (SQLException var2) {
         this.onErrorVoidForAll(methodObject26353, var2);
      }
   }

   public boolean execute(String arg0, int[] arg1) throws SQLException {
      try {
         super.preForExecute(methodObject26340, this, arg0, arg1);
         return this.postForExecute(methodObject26340, this.delegate.execute(arg0, arg1));
      } catch (SQLException var4) {
         return this.postForExecute(methodObject26340, this.onErrorForExecute(methodObject26340, var4));
      }
   }

   public boolean getMoreResults(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject26362, this, arg0);
         return (Boolean)this.postForAll(methodObject26362, this.delegate.getMoreResults(arg0));
      } catch (SQLException var3) {
         return (Boolean)this.postForAll(methodObject26362, this.onErrorForAll(methodObject26362, var3));
      }
   }

   public int executeUpdate(String arg0) throws SQLException {
      try {
         super.preForExecuteUpdate(methodObject26345, this, arg0);
         return this.postForExecuteUpdate(methodObject26345, this.delegate.executeUpdate(arg0));
      } catch (SQLException var3) {
         return this.postForExecuteUpdate(methodObject26345, (Integer)this.onErrorForAll(methodObject26345, var3));
      }
   }

   public void clearBatch() throws SQLException {
      try {
         super.preForAll(methodObject26356, this, zeroLengthObjectArray);
         this.delegate.clearBatch();
      } catch (SQLException var2) {
         this.onErrorVoidForAll(methodObject26356, var2);
      }
   }

   public boolean isPoolable() throws SQLException {
      try {
         super.preForAll(methodObject26368, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject26368, this.delegate.isPoolable());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject26368, this.onErrorForAll(methodObject26368, var2));
      }
   }

   public boolean getMoreResults() throws SQLException {
      try {
         super.preForAll(methodObject26361, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject26361, this.delegate.getMoreResults());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject26361, this.onErrorForAll(methodObject26361, var2));
      }
   }

   public int executeUpdate(String arg0, int arg1) throws SQLException {
      try {
         super.preForExecuteUpdate(methodObject26346, this, arg0, arg1);
         return this.postForExecuteUpdate(methodObject26346, this.delegate.executeUpdate(arg0, arg1));
      } catch (SQLException var4) {
         return this.postForExecuteUpdate(methodObject26346, (Integer)this.onErrorForAll(methodObject26346, var4));
      }
   }

   public void setPoolable(boolean arg0) throws SQLException {
      try {
         super.preForAll(methodObject26373, this, arg0);
         this.delegate.setPoolable(arg0);
      } catch (SQLException var3) {
         this.onErrorVoidForAll(methodObject26373, var3);
      }
   }

   public boolean isClosed() throws SQLException {
      try {
         super.preForAll(methodObject26349, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject26349, this.delegate.isClosed());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject26349, this.onErrorForAll(methodObject26349, var2));
      }
   }

   public int getUpdateCount() throws SQLException {
      try {
         super.preForAll(methodObject26366, this, zeroLengthObjectArray);
         return (Integer)this.postForAll(methodObject26366, this.delegate.getUpdateCount());
      } catch (SQLException var2) {
         return (Integer)this.postForAll(methodObject26366, this.onErrorForAll(methodObject26366, var2));
      }
   }

   public int getMaxFieldSize() throws SQLException {
      try {
         super.preForAll(methodObject26359, this, zeroLengthObjectArray);
         return (Integer)this.postForAll(methodObject26359, this.delegate.getMaxFieldSize());
      } catch (SQLException var2) {
         return (Integer)this.postForAll(methodObject26359, this.onErrorForAll(methodObject26359, var2));
      }
   }

   public boolean isCloseOnCompletion() throws SQLException {
      try {
         super.preForAll(methodObject26367, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject26367, this.delegate.isCloseOnCompletion());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject26367, this.onErrorForAll(methodObject26367, var2));
      }
   }

   public void setMaxFieldSize(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject26371, this, arg0);
         this.delegate.setMaxFieldSize(arg0);
      } catch (SQLException var3) {
         this.onErrorVoidForAll(methodObject26371, var3);
      }
   }

   public void cancel() throws SQLException {
      try {
         super.preForAll(methodObject26342, this, zeroLengthObjectArray);
         this.delegate.cancel();
      } catch (SQLException var2) {
         this.onErrorVoidForAll(methodObject26342, var2);
      }
   }

   public SQLWarning getWarnings() throws SQLException {
      try {
         super.preForAll(methodObject26352, this, zeroLengthObjectArray);
         return (SQLWarning)this.postForAll(methodObject26352, (Object)this.delegate.getWarnings());
      } catch (SQLException var2) {
         return (SQLWarning)this.postForAll(methodObject26352, this.onErrorForAll(methodObject26352, var2));
      }
   }

   public ResultSet executeQuery(String arg0) throws SQLException {
      try {
         super.preForAll(methodObject26350, this, arg0);
         return this.postForExecuteQuery(methodObject26350, (ResultSet)this.proxyFactory.proxyForCreateCache((Object)this.delegate.executeQuery(arg0), this, this.proxyCache, methodObject26350));
      } catch (SQLException var3) {
         return this.postForExecuteQuery(methodObject26350, (ResultSet)this.onErrorForAll(methodObject26350, var3));
      }
   }

   public void setQueryTimeout(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject26374, this, arg0);
         this.delegate.setQueryTimeout(arg0);
      } catch (SQLException var3) {
         this.onErrorVoidForAll(methodObject26374, var3);
      }
   }

   public ResultSet getResultSet() throws SQLException {
      try {
         super.preForAll(methodObject26343, this, zeroLengthObjectArray);
         return (ResultSet)this.postForAll(methodObject26343, this.proxyFactory.proxyForCache((Object)this.delegate.getResultSet(), this, this.proxyCache, methodObject26343));
      } catch (SQLException var2) {
         return (ResultSet)this.postForAll(methodObject26343, this.onErrorForAll(methodObject26343, var2));
      }
   }

   public Connection getConnection() throws SQLException {
      try {
         super.preForAll(methodObject26351, this, zeroLengthObjectArray);
         return (Connection)this.postForAll(methodObject26351, (Object)super.getConnection());
      } catch (SQLException var2) {
         return (Connection)this.postForAll(methodObject26351, this.onErrorForAll(methodObject26351, var2));
      }
   }

   public Statement _getDelegate_() {
      return this.delegate;
   }

   public Object getDelegate() {
      return this.delegate;
   }

   public void setDelegate(Object delegate) {
      this.proxyFactory.updateDelegate(this, this.delegate, delegate);
      this.delegate = (Statement)delegate;
   }

   public Object getCreator() {
      return this.creator;
   }

   static {
      try {
         methodObject26378 = Statement.class.getDeclaredMethod("setFetchSize", Integer.TYPE);
         methodObject26377 = Statement.class.getDeclaredMethod("setFetchDirection", Integer.TYPE);
         methodObject26376 = Statement.class.getDeclaredMethod("getFetchSize");
         methodObject26358 = Statement.class.getDeclaredMethod("getGeneratedKeys");
         methodObject26372 = Statement.class.getDeclaredMethod("setMaxRows", Integer.TYPE);
         methodObject26360 = Statement.class.getDeclaredMethod("getMaxRows");
         methodObject26369 = Statement.class.getDeclaredMethod("setCursorName", String.class);
         methodObject26348 = Statement.class.getDeclaredMethod("executeUpdate", String.class, String[].class);
         methodObject26341 = Statement.class.getDeclaredMethod("execute", String.class, String[].class);
         methodObject26344 = Statement.class.getDeclaredMethod("executeBatch");
         methodObject26338 = Statement.class.getDeclaredMethod("execute", String.class);
         methodObject26357 = Statement.class.getDeclaredMethod("closeOnCompletion");
         methodObject26365 = Statement.class.getDeclaredMethod("getResultSetType");
         methodObject26337 = Statement.class.getDeclaredMethod("close");
         methodObject26375 = Statement.class.getDeclaredMethod("getFetchDirection");
         methodObject26370 = Statement.class.getDeclaredMethod("setEscapeProcessing", Boolean.TYPE);
         methodObject26363 = Statement.class.getDeclaredMethod("getQueryTimeout");
         methodObject26354 = Statement.class.getDeclaredMethod("getResultSetHoldability");
         methodObject26339 = Statement.class.getDeclaredMethod("execute", String.class, Integer.TYPE);
         methodObject26347 = Statement.class.getDeclaredMethod("executeUpdate", String.class, int[].class);
         methodObject26380 = Wrapper.class.getDeclaredMethod("isWrapperFor", Class.class);
         methodObject26379 = Wrapper.class.getDeclaredMethod("unwrap", Class.class);
         methodObject26355 = Statement.class.getDeclaredMethod("addBatch", String.class);
         methodObject26364 = Statement.class.getDeclaredMethod("getResultSetConcurrency");
         methodObject26353 = Statement.class.getDeclaredMethod("clearWarnings");
         methodObject26340 = Statement.class.getDeclaredMethod("execute", String.class, int[].class);
         methodObject26362 = Statement.class.getDeclaredMethod("getMoreResults", Integer.TYPE);
         methodObject26345 = Statement.class.getDeclaredMethod("executeUpdate", String.class);
         methodObject26356 = Statement.class.getDeclaredMethod("clearBatch");
         methodObject26368 = Statement.class.getDeclaredMethod("isPoolable");
         methodObject26361 = Statement.class.getDeclaredMethod("getMoreResults");
         methodObject26346 = Statement.class.getDeclaredMethod("executeUpdate", String.class, Integer.TYPE);
         methodObject26373 = Statement.class.getDeclaredMethod("setPoolable", Boolean.TYPE);
         methodObject26349 = Statement.class.getDeclaredMethod("isClosed");
         methodObject26366 = Statement.class.getDeclaredMethod("getUpdateCount");
         methodObject26359 = Statement.class.getDeclaredMethod("getMaxFieldSize");
         methodObject26367 = Statement.class.getDeclaredMethod("isCloseOnCompletion");
         methodObject26371 = Statement.class.getDeclaredMethod("setMaxFieldSize", Integer.TYPE);
         methodObject26342 = Statement.class.getDeclaredMethod("cancel");
         methodObject26352 = Statement.class.getDeclaredMethod("getWarnings");
         methodObject26350 = Statement.class.getDeclaredMethod("executeQuery", String.class);
         methodObject26374 = Statement.class.getDeclaredMethod("setQueryTimeout", Integer.TYPE);
         methodObject26343 = Statement.class.getDeclaredMethod("getResultSet");
         methodObject26351 = Statement.class.getDeclaredMethod("getConnection");
      } catch (Throwable var1) {
         throw new RuntimeException(var1);
      }
   }

   public oracle$1jdbc$1replay$1driver$1NonTxnReplayableStatement$2java$1sql$1Statement$$$Proxy(Statement var1, Object var2, ProxyFactory var3, Map var4) {
      this.delegate = var1;
      this.creator = var2;
      this.proxyFactory = var3;
      this.proxyCache = var4;
   }
}
