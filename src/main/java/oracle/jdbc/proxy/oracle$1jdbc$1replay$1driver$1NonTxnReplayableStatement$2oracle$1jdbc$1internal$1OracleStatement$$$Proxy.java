package oracle.jdbc.proxy;

import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLWarning;
import java.sql.Statement;
import java.sql.Wrapper;
import java.util.Map;
import oracle.jdbc.dcn.DatabaseChangeRegistration;
import oracle.jdbc.internal.ACProxyable;
import oracle.jdbc.internal.OracleStatement;
import oracle.jdbc.replay.driver.NonTxnReplayableStatement;

public abstract class oracle$1jdbc$1replay$1driver$1NonTxnReplayableStatement$2oracle$1jdbc$1internal$1OracleStatement$$$Proxy extends NonTxnReplayableStatement implements OracleStatement, _Proxy_ {
   private OracleStatement delegate;
   private final Object creator;
   private final ProxyFactory proxyFactory;
   private final Map proxyCache;
   private static Object[] zeroLengthObjectArray = new Object[0];
   private static Method methodObject27845;
   private static Method methodObject27846;
   private static Method methodObject27839;
   private static Method methodObject27872;
   private static Method methodObject27847;
   private static Method methodObject27842;
   private static Method methodObject27886;
   private static Method methodObject27838;
   private static Method methodObject27855;
   private static Method methodObject27852;
   private static Method methodObject27834;
   private static Method methodObject27871;
   private static Method methodObject27851;
   private static Method methodObject27889;
   private static Method methodObject27837;
   private static Method methodObject27830;
   private static Method methodObject27828;
   private static Method methodObject27850;
   private static Method methodObject27895;
   private static Method methodObject27861;
   private static Method methodObject27825;
   private static Method methodObject27826;
   private static Method methodObject27854;
   private static Method methodObject27843;
   private static Method methodObject27824;
   private static Method methodObject27876;
   private static Method methodObject27859;
   private static Method methodObject27870;
   private static Method methodObject27882;
   private static Method methodObject27848;
   private static Method methodObject27875;
   private static Method methodObject27836;
   private static Method methodObject27860;
   private static Method methodObject27841;
   private static Method methodObject27880;
   private static Method methodObject27881;
   private static Method methodObject27885;
   private static Method methodObject27840;
   private static Method methodObject27864;
   private static Method methodObject27835;
   private static Method methodObject27831;
   private static Method methodObject27892;
   private static Method methodObject27891;
   private static Method methodObject27890;
   private static Method methodObject27874;
   private static Method methodObject27883;
   private static Method methodObject27862;
   private static Method methodObject27858;
   private static Method methodObject27879;
   private static Method methodObject27833;
   private static Method methodObject27884;
   private static Method methodObject27877;
   private static Method methodObject27868;
   private static Method methodObject27832;
   private static Method methodObject27849;
   private static Method methodObject27853;
   private static Method methodObject27894;
   private static Method methodObject27893;
   private static Method methodObject27869;
   private static Method methodObject27878;
   private static Method methodObject27896;
   private static Method methodObject27867;
   private static Method methodObject27844;
   private static Method methodObject27887;
   private static Method methodObject27863;
   private static Method methodObject27873;
   private static Method methodObject27827;
   private static Method methodObject27856;
   private static Method methodObject27866;
   private static Method methodObject27829;
   private static Method methodObject27888;
   private static Method methodObject27857;
   private static Method methodObject27865;

   public void setLobPrefetchSize(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject27845, this, arg0);
         this.delegate.setLobPrefetchSize(arg0);
      } catch (SQLException var3) {
         this.onErrorVoidForAll(methodObject27845, var3);
      }
   }

   public void closeWithKey(String arg0) throws SQLException {
      try {
         super.preForAll(methodObject27846, this, arg0);
         this.delegate.closeWithKey(arg0);
      } catch (SQLException var3) {
         this.onErrorVoidForAll(methodObject27846, var3);
      }
   }

   public void defineColumnType(int arg0, int arg1, String arg2) throws SQLException {
      try {
         super.preForAll(methodObject27839, this, arg0, arg1, arg2);
         this.delegate.defineColumnType(arg0, arg1, arg2);
      } catch (SQLException var5) {
         this.onErrorVoidForAll(methodObject27839, var5);
      }
   }

   public ResultSet getGeneratedKeys() throws SQLException {
      try {
         super.preForAll(methodObject27872, this, zeroLengthObjectArray);
         return (ResultSet)this.postForAll(methodObject27872, this.proxyFactory.proxyForCache((Object)this.delegate.getGeneratedKeys(), this, this.proxyCache, methodObject27872));
      } catch (SQLException var2) {
         return (ResultSet)this.postForAll(methodObject27872, this.onErrorForAll(methodObject27872, var2));
      }
   }

   public int creationState() {
      super.preForAll(methodObject27847, this, zeroLengthObjectArray);
      return (Integer)this.postForAll(methodObject27847, this.delegate.creationState());
   }

   public int getRowPrefetch() {
      super.preForAll(methodObject27842, this, zeroLengthObjectArray);
      return (Integer)this.postForAll(methodObject27842, this.delegate.getRowPrefetch());
   }

   public void setMaxRows(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject27886, this, arg0);
         this.delegate.setMaxRows(arg0);
      } catch (SQLException var3) {
         this.onErrorVoidForAll(methodObject27886, var3);
      }
   }

   public void defineColumnType(int arg0, int arg1, int arg2, short arg3) throws SQLException {
      try {
         super.preForAll(methodObject27838, this, arg0, arg1, arg2, arg3);
         this.delegate.defineColumnType(arg0, arg1, arg2, arg3);
      } catch (SQLException var6) {
         this.onErrorVoidForAll(methodObject27838, var6);
      }
   }

   public boolean execute(String arg0, String[] arg1) throws SQLException {
      try {
         super.preForExecute(methodObject27855, this, arg0, arg1);
         return this.postForExecute(methodObject27855, this.delegate.execute(arg0, arg1));
      } catch (SQLException var4) {
         return this.postForExecute(methodObject27855, this.onErrorForExecute(methodObject27855, var4));
      }
   }

   public boolean execute(String arg0) throws SQLException {
      try {
         super.preForExecute(methodObject27852, this, arg0);
         return this.postForExecute(methodObject27852, this.delegate.execute(arg0));
      } catch (SQLException var3) {
         return this.postForExecute(methodObject27852, this.onErrorForExecute(methodObject27852, var3));
      }
   }

   public boolean isNCHAR(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject27834, this, arg0);
         return (Boolean)this.postForAll(methodObject27834, this.delegate.isNCHAR(arg0));
      } catch (SQLException var3) {
         return (Boolean)this.postForAll(methodObject27834, this.onErrorForAll(methodObject27834, var3));
      }
   }

   public void closeOnCompletion() throws SQLException {
      try {
         super.preForAll(methodObject27871, this, zeroLengthObjectArray);
         this.delegate.closeOnCompletion();
      } catch (SQLException var2) {
         this.onErrorVoidForAll(methodObject27871, var2);
      }
   }

   public void close() throws SQLException {
      try {
         super.preForAll(methodObject27851, this, zeroLengthObjectArray);
         Method var10001 = methodObject27851;
         this.delegate.close();
         this.postForClose(var10001);
      } catch (SQLException var2) {
         this.onErrorVoidForClose(methodObject27851, var2);
      }
   }

   public int getFetchDirection() throws SQLException {
      try {
         super.preForAll(methodObject27889, this, zeroLengthObjectArray);
         return (Integer)this.postForAll(methodObject27889, this.delegate.getFetchDirection());
      } catch (SQLException var2) {
         return (Integer)this.postForAll(methodObject27889, this.onErrorForAll(methodObject27889, var2));
      }
   }

   public void defineColumnType(int arg0, int arg1, int arg2) throws SQLException {
      try {
         super.preForAll(methodObject27837, this, arg0, arg1, arg2);
         this.delegate.defineColumnType(arg0, arg1, arg2);
      } catch (SQLException var5) {
         this.onErrorVoidForAll(methodObject27837, var5);
      }
   }

   public boolean getserverCursor() {
      super.preForAll(methodObject27830, this, zeroLengthObjectArray);
      return (Boolean)this.postForAll(methodObject27830, this.delegate.getserverCursor());
   }

   public boolean getFixedString() {
      super.preForAll(methodObject27828, this, zeroLengthObjectArray);
      return (Boolean)this.postForAll(methodObject27828, this.delegate.getFixedString());
   }

   public long getRegisteredQueryId() throws SQLException {
      try {
         super.preForAll(methodObject27850, this, zeroLengthObjectArray);
         return (Long)this.postForAll(methodObject27850, this.delegate.getRegisteredQueryId());
      } catch (SQLException var2) {
         return (Long)this.postForAll(methodObject27850, this.onErrorForAll(methodObject27850, var2));
      }
   }

   public void setACProxy(Object arg0) {
      super.preForAll(methodObject27895, this, arg0);
      this.delegate.setACProxy(arg0 instanceof _Proxy_ ? (Object)((_Proxy_)arg0)._getDelegate_() : arg0);
   }

   public int executeUpdate(String arg0, int[] arg1) throws SQLException {
      try {
         super.preForExecuteUpdate(methodObject27861, this, arg0, arg1);
         return this.postForExecuteUpdate(methodObject27861, this.delegate.executeUpdate(arg0, arg1));
      } catch (SQLException var4) {
         return this.postForExecuteUpdate(methodObject27861, (Integer)this.onErrorForAll(methodObject27861, var4));
      }
   }

   public long getChecksum() throws SQLException {
      try {
         super.preForAll(methodObject27825, this, zeroLengthObjectArray);
         return (Long)this.postForAll(methodObject27825, this.delegate.getChecksum());
      } catch (SQLException var2) {
         return (Long)this.postForAll(methodObject27825, this.onErrorForAll(methodObject27825, var2));
      }
   }

   public void setSnapshotSCN(long arg0) throws SQLException {
      try {
         super.preForAll(methodObject27826, this, arg0);
         this.delegate.setSnapshotSCN(arg0);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject27826, var4);
      }
   }

   public boolean execute(String arg0, int[] arg1) throws SQLException {
      try {
         super.preForExecute(methodObject27854, this, arg0, arg1);
         return this.postForExecute(methodObject27854, this.delegate.execute(arg0, arg1));
      } catch (SQLException var4) {
         return this.postForExecute(methodObject27854, this.onErrorForExecute(methodObject27854, var4));
      }
   }

   public void setRowPrefetch(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject27843, this, arg0);
         this.delegate.setRowPrefetch(arg0);
      } catch (SQLException var3) {
         this.onErrorVoidForAll(methodObject27843, var3);
      }
   }

   public OracleStatement.SqlKind getSqlKind() throws SQLException {
      try {
         super.preForAll(methodObject27824, this, zeroLengthObjectArray);
         return (OracleStatement.SqlKind)this.postForAll(methodObject27824, (Object)this.delegate.getSqlKind());
      } catch (SQLException var2) {
         return (OracleStatement.SqlKind)this.postForAll(methodObject27824, this.onErrorForAll(methodObject27824, var2));
      }
   }

   public boolean getMoreResults(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject27876, this, arg0);
         return (Boolean)this.postForAll(methodObject27876, this.delegate.getMoreResults(arg0));
      } catch (SQLException var3) {
         return (Boolean)this.postForAll(methodObject27876, this.onErrorForAll(methodObject27876, var3));
      }
   }

   public int executeUpdate(String arg0) throws SQLException {
      try {
         super.preForExecuteUpdate(methodObject27859, this, arg0);
         return this.postForExecuteUpdate(methodObject27859, this.delegate.executeUpdate(arg0));
      } catch (SQLException var3) {
         return this.postForExecuteUpdate(methodObject27859, (Integer)this.onErrorForAll(methodObject27859, var3));
      }
   }

   public void clearBatch() throws SQLException {
      try {
         super.preForAll(methodObject27870, this, zeroLengthObjectArray);
         this.delegate.clearBatch();
      } catch (SQLException var2) {
         this.onErrorVoidForAll(methodObject27870, var2);
      }
   }

   public boolean isPoolable() throws SQLException {
      try {
         super.preForAll(methodObject27882, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject27882, this.delegate.isPoolable());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject27882, this.onErrorForAll(methodObject27882, var2));
      }
   }

   public void setDatabaseChangeRegistration(DatabaseChangeRegistration arg0) throws SQLException {
      try {
         super.preForAll(methodObject27848, this, arg0);
         this.delegate.setDatabaseChangeRegistration(arg0);
      } catch (SQLException var3) {
         this.onErrorVoidForAll(methodObject27848, var3);
      }
   }

   public boolean getMoreResults() throws SQLException {
      try {
         super.preForAll(methodObject27875, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject27875, this.delegate.getMoreResults());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject27875, this.onErrorForAll(methodObject27875, var2));
      }
   }

   public void defineColumnType(int arg0, int arg1) throws SQLException {
      try {
         super.preForAll(methodObject27836, this, arg0, arg1);
         this.delegate.defineColumnType(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject27836, var4);
      }
   }

   public int executeUpdate(String arg0, int arg1) throws SQLException {
      try {
         super.preForExecuteUpdate(methodObject27860, this, arg0, arg1);
         return this.postForExecuteUpdate(methodObject27860, this.delegate.executeUpdate(arg0, arg1));
      } catch (SQLException var4) {
         return this.postForExecuteUpdate(methodObject27860, (Integer)this.onErrorForAll(methodObject27860, var4));
      }
   }

   public void defineColumnTypeChars(int arg0, int arg1, int arg2) throws SQLException {
      try {
         super.preForAll(methodObject27841, this, arg0, arg1, arg2);
         this.delegate.defineColumnTypeChars(arg0, arg1, arg2);
      } catch (SQLException var5) {
         this.onErrorVoidForAll(methodObject27841, var5);
      }
   }

   public int getUpdateCount() throws SQLException {
      try {
         super.preForAll(methodObject27880, this, zeroLengthObjectArray);
         return (Integer)this.postForAll(methodObject27880, this.delegate.getUpdateCount());
      } catch (SQLException var2) {
         return (Integer)this.postForAll(methodObject27880, this.onErrorForAll(methodObject27880, var2));
      }
   }

   public boolean isCloseOnCompletion() throws SQLException {
      try {
         super.preForAll(methodObject27881, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject27881, this.delegate.isCloseOnCompletion());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject27881, this.onErrorForAll(methodObject27881, var2));
      }
   }

   public void setMaxFieldSize(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject27885, this, arg0);
         this.delegate.setMaxFieldSize(arg0);
      } catch (SQLException var3) {
         this.onErrorVoidForAll(methodObject27885, var3);
      }
   }

   public void defineColumnTypeBytes(int arg0, int arg1, int arg2) throws SQLException {
      try {
         super.preForAll(methodObject27840, this, arg0, arg1, arg2);
         this.delegate.defineColumnTypeBytes(arg0, arg1, arg2);
      } catch (SQLException var5) {
         this.onErrorVoidForAll(methodObject27840, var5);
      }
   }

   public ResultSet executeQuery(String arg0) throws SQLException {
      try {
         super.preForAll(methodObject27864, this, arg0);
         return this.postForExecuteQuery(methodObject27864, (ResultSet)this.proxyFactory.proxyForCreateCache((Object)this.delegate.executeQuery(arg0), this, this.proxyCache, methodObject27864));
      } catch (SQLException var3) {
         return this.postForExecuteQuery(methodObject27864, (ResultSet)this.onErrorForAll(methodObject27864, var3));
      }
   }

   public void clearDefines() throws SQLException {
      try {
         super.preForAll(methodObject27835, this, zeroLengthObjectArray);
         this.delegate.clearDefines();
      } catch (SQLException var2) {
         this.onErrorVoidForAll(methodObject27835, var2);
      }
   }

   public int getcacheState() {
      super.preForAll(methodObject27831, this, zeroLengthObjectArray);
      return (Integer)this.postForAll(methodObject27831, this.delegate.getcacheState());
   }

   public void setFetchSize(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject27892, this, arg0);
         this.delegate.setFetchSize(arg0);
      } catch (SQLException var3) {
         this.onErrorVoidForAll(methodObject27892, var3);
      }
   }

   public void setFetchDirection(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject27891, this, arg0);
         this.delegate.setFetchDirection(arg0);
      } catch (SQLException var3) {
         this.onErrorVoidForAll(methodObject27891, var3);
      }
   }

   public int getFetchSize() throws SQLException {
      try {
         super.preForAll(methodObject27890, this, zeroLengthObjectArray);
         return (Integer)this.postForAll(methodObject27890, this.delegate.getFetchSize());
      } catch (SQLException var2) {
         return (Integer)this.postForAll(methodObject27890, this.onErrorForAll(methodObject27890, var2));
      }
   }

   public int getMaxRows() throws SQLException {
      try {
         super.preForAll(methodObject27874, this, zeroLengthObjectArray);
         return (Integer)this.postForAll(methodObject27874, this.delegate.getMaxRows());
      } catch (SQLException var2) {
         return (Integer)this.postForAll(methodObject27874, this.onErrorForAll(methodObject27874, var2));
      }
   }

   public void setCursorName(String arg0) throws SQLException {
      try {
         super.preForAll(methodObject27883, this, arg0);
         this.delegate.setCursorName(arg0);
      } catch (SQLException var3) {
         this.onErrorVoidForAll(methodObject27883, var3);
      }
   }

   public int executeUpdate(String arg0, String[] arg1) throws SQLException {
      try {
         super.preForExecuteUpdate(methodObject27862, this, arg0, arg1);
         return this.postForExecuteUpdate(methodObject27862, this.delegate.executeUpdate(arg0, arg1));
      } catch (SQLException var4) {
         return this.postForExecuteUpdate(methodObject27862, (Integer)this.onErrorForAll(methodObject27862, var4));
      }
   }

   public int[] executeBatch() throws SQLException {
      try {
         super.preForExecuteBatch(methodObject27858, this, zeroLengthObjectArray);
         return (int[])this.postForAll(methodObject27858, (Object)this.delegate.executeBatch());
      } catch (SQLException var2) {
         return (int[])this.postForAll(methodObject27858, this.onErrorForAll(methodObject27858, var2));
      }
   }

   public int getResultSetType() throws SQLException {
      try {
         super.preForAll(methodObject27879, this, zeroLengthObjectArray);
         return (Integer)this.postForAll(methodObject27879, this.delegate.getResultSetType());
      } catch (SQLException var2) {
         return (Integer)this.postForAll(methodObject27879, this.onErrorForAll(methodObject27879, var2));
      }
   }

   public void registerBindChecksumListener(OracleStatement.BindChecksumListener arg0) throws SQLException {
      try {
         super.preForAll(methodObject27833, this, arg0);
         this.delegate.registerBindChecksumListener(arg0);
      } catch (SQLException var3) {
         this.onErrorVoidForAll(methodObject27833, var3);
      }
   }

   public void setEscapeProcessing(boolean arg0) throws SQLException {
      try {
         super.preForAll(methodObject27884, this, arg0);
         this.delegate.setEscapeProcessing(arg0);
      } catch (SQLException var3) {
         this.onErrorVoidForAll(methodObject27884, var3);
      }
   }

   public int getQueryTimeout() throws SQLException {
      try {
         super.preForAll(methodObject27877, this, zeroLengthObjectArray);
         return (Integer)this.postForAll(methodObject27877, this.delegate.getQueryTimeout());
      } catch (SQLException var2) {
         return (Integer)this.postForAll(methodObject27877, this.onErrorForAll(methodObject27877, var2));
      }
   }

   public int getResultSetHoldability() throws SQLException {
      try {
         super.preForAll(methodObject27868, this, zeroLengthObjectArray);
         return (Integer)this.postForAll(methodObject27868, this.delegate.getResultSetHoldability());
      } catch (SQLException var2) {
         return (Integer)this.postForAll(methodObject27868, this.onErrorForAll(methodObject27868, var2));
      }
   }

   public int getstatementType() {
      super.preForAll(methodObject27832, this, zeroLengthObjectArray);
      return (Integer)this.postForAll(methodObject27832, this.delegate.getstatementType());
   }

   public String[] getRegisteredTableNames() throws SQLException {
      try {
         super.preForAll(methodObject27849, this, zeroLengthObjectArray);
         return (String[])this.postForAll(methodObject27849, (Object)this.delegate.getRegisteredTableNames());
      } catch (SQLException var2) {
         return (String[])this.postForAll(methodObject27849, this.onErrorForAll(methodObject27849, var2));
      }
   }

   public boolean execute(String arg0, int arg1) throws SQLException {
      try {
         super.preForExecute(methodObject27853, this, arg0, arg1);
         return this.postForExecute(methodObject27853, this.delegate.execute(arg0, arg1));
      } catch (SQLException var4) {
         return this.postForExecute(methodObject27853, this.onErrorForExecute(methodObject27853, var4));
      }
   }

   public boolean isWrapperFor(Class arg0) throws SQLException {
      try {
         super.preForAll(methodObject27894, this, arg0);
         return (Boolean)this.postForAll(methodObject27894, this.delegate.isWrapperFor(arg0));
      } catch (SQLException var3) {
         return (Boolean)this.postForAll(methodObject27894, this.onErrorForAll(methodObject27894, var3));
      }
   }

   public Object unwrap(Class arg0) throws SQLException {
      try {
         super.preForAll(methodObject27893, this, arg0);
         return this.postForAll(methodObject27893, super.unwrap(arg0));
      } catch (SQLException var3) {
         return this.postForAll(methodObject27893, this.onErrorForAll(methodObject27893, var3));
      }
   }

   public void addBatch(String arg0) throws SQLException {
      try {
         super.preForAll(methodObject27869, this, arg0);
         this.delegate.addBatch(arg0);
      } catch (SQLException var3) {
         this.onErrorVoidForAll(methodObject27869, var3);
      }
   }

   public int getResultSetConcurrency() throws SQLException {
      try {
         super.preForAll(methodObject27878, this, zeroLengthObjectArray);
         return (Integer)this.postForAll(methodObject27878, this.delegate.getResultSetConcurrency());
      } catch (SQLException var2) {
         return (Integer)this.postForAll(methodObject27878, this.onErrorForAll(methodObject27878, var2));
      }
   }

   public Object getACProxy() {
      super.preForAll(methodObject27896, this, zeroLengthObjectArray);
      return this.postForAll(methodObject27896, this.proxyFactory.proxyForCache(this.delegate.getACProxy(), this, this.proxyCache, methodObject27896));
   }

   public void clearWarnings() throws SQLException {
      try {
         super.preForAll(methodObject27867, this, zeroLengthObjectArray);
         this.delegate.clearWarnings();
      } catch (SQLException var2) {
         this.onErrorVoidForAll(methodObject27867, var2);
      }
   }

   public int getLobPrefetchSize() throws SQLException {
      try {
         super.preForAll(methodObject27844, this, zeroLengthObjectArray);
         return (Integer)this.postForAll(methodObject27844, this.delegate.getLobPrefetchSize());
      } catch (SQLException var2) {
         return (Integer)this.postForAll(methodObject27844, this.onErrorForAll(methodObject27844, var2));
      }
   }

   public void setPoolable(boolean arg0) throws SQLException {
      try {
         super.preForAll(methodObject27887, this, arg0);
         this.delegate.setPoolable(arg0);
      } catch (SQLException var3) {
         this.onErrorVoidForAll(methodObject27887, var3);
      }
   }

   public boolean isClosed() throws SQLException {
      try {
         super.preForAll(methodObject27863, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject27863, this.delegate.isClosed());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject27863, this.onErrorForAll(methodObject27863, var2));
      }
   }

   public int getMaxFieldSize() throws SQLException {
      try {
         super.preForAll(methodObject27873, this, zeroLengthObjectArray);
         return (Integer)this.postForAll(methodObject27873, this.delegate.getMaxFieldSize());
      } catch (SQLException var2) {
         return (Integer)this.postForAll(methodObject27873, this.onErrorForAll(methodObject27873, var2));
      }
   }

   public void setFixedString(boolean arg0) {
      super.preForAll(methodObject27827, this, arg0);
      this.delegate.setFixedString(arg0);
   }

   public void cancel() throws SQLException {
      try {
         super.preForAll(methodObject27856, this, zeroLengthObjectArray);
         this.delegate.cancel();
      } catch (SQLException var2) {
         this.onErrorVoidForAll(methodObject27856, var2);
      }
   }

   public SQLWarning getWarnings() throws SQLException {
      try {
         super.preForAll(methodObject27866, this, zeroLengthObjectArray);
         return (SQLWarning)this.postForAll(methodObject27866, (Object)this.delegate.getWarnings());
      } catch (SQLException var2) {
         return (SQLWarning)this.postForAll(methodObject27866, this.onErrorForAll(methodObject27866, var2));
      }
   }

   public int sendBatch() throws SQLException {
      try {
         super.preForAll(methodObject27829, this, zeroLengthObjectArray);
         return (Integer)this.postForAll(methodObject27829, this.delegate.sendBatch());
      } catch (SQLException var2) {
         return (Integer)this.postForAll(methodObject27829, this.onErrorForAll(methodObject27829, var2));
      }
   }

   public void setQueryTimeout(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject27888, this, arg0);
         this.delegate.setQueryTimeout(arg0);
      } catch (SQLException var3) {
         this.onErrorVoidForAll(methodObject27888, var3);
      }
   }

   public ResultSet getResultSet() throws SQLException {
      try {
         super.preForAll(methodObject27857, this, zeroLengthObjectArray);
         return (ResultSet)this.postForAll(methodObject27857, this.proxyFactory.proxyForCache((Object)this.delegate.getResultSet(), this, this.proxyCache, methodObject27857));
      } catch (SQLException var2) {
         return (ResultSet)this.postForAll(methodObject27857, this.onErrorForAll(methodObject27857, var2));
      }
   }

   public Connection getConnection() throws SQLException {
      try {
         super.preForAll(methodObject27865, this, zeroLengthObjectArray);
         return (Connection)this.postForAll(methodObject27865, (Object)super.getConnection());
      } catch (SQLException var2) {
         return (Connection)this.postForAll(methodObject27865, this.onErrorForAll(methodObject27865, var2));
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
         methodObject27845 = oracle.jdbc.OracleStatement.class.getDeclaredMethod("setLobPrefetchSize", Integer.TYPE);
         methodObject27846 = oracle.jdbc.OracleStatement.class.getDeclaredMethod("closeWithKey", String.class);
         methodObject27839 = oracle.jdbc.OracleStatement.class.getDeclaredMethod("defineColumnType", Integer.TYPE, Integer.TYPE, String.class);
         methodObject27872 = Statement.class.getDeclaredMethod("getGeneratedKeys");
         methodObject27847 = oracle.jdbc.OracleStatement.class.getDeclaredMethod("creationState");
         methodObject27842 = oracle.jdbc.OracleStatement.class.getDeclaredMethod("getRowPrefetch");
         methodObject27886 = Statement.class.getDeclaredMethod("setMaxRows", Integer.TYPE);
         methodObject27838 = oracle.jdbc.OracleStatement.class.getDeclaredMethod("defineColumnType", Integer.TYPE, Integer.TYPE, Integer.TYPE, Short.TYPE);
         methodObject27855 = Statement.class.getDeclaredMethod("execute", String.class, String[].class);
         methodObject27852 = Statement.class.getDeclaredMethod("execute", String.class);
         methodObject27834 = oracle.jdbc.OracleStatement.class.getDeclaredMethod("isNCHAR", Integer.TYPE);
         methodObject27871 = Statement.class.getDeclaredMethod("closeOnCompletion");
         methodObject27851 = Statement.class.getDeclaredMethod("close");
         methodObject27889 = Statement.class.getDeclaredMethod("getFetchDirection");
         methodObject27837 = oracle.jdbc.OracleStatement.class.getDeclaredMethod("defineColumnType", Integer.TYPE, Integer.TYPE, Integer.TYPE);
         methodObject27830 = OracleStatement.class.getDeclaredMethod("getserverCursor");
         methodObject27828 = OracleStatement.class.getDeclaredMethod("getFixedString");
         methodObject27850 = oracle.jdbc.OracleStatement.class.getDeclaredMethod("getRegisteredQueryId");
         methodObject27895 = ACProxyable.class.getDeclaredMethod("setACProxy", Object.class);
         methodObject27861 = Statement.class.getDeclaredMethod("executeUpdate", String.class, int[].class);
         methodObject27825 = OracleStatement.class.getDeclaredMethod("getChecksum");
         methodObject27826 = OracleStatement.class.getDeclaredMethod("setSnapshotSCN", Long.TYPE);
         methodObject27854 = Statement.class.getDeclaredMethod("execute", String.class, int[].class);
         methodObject27843 = oracle.jdbc.OracleStatement.class.getDeclaredMethod("setRowPrefetch", Integer.TYPE);
         methodObject27824 = OracleStatement.class.getDeclaredMethod("getSqlKind");
         methodObject27876 = Statement.class.getDeclaredMethod("getMoreResults", Integer.TYPE);
         methodObject27859 = Statement.class.getDeclaredMethod("executeUpdate", String.class);
         methodObject27870 = Statement.class.getDeclaredMethod("clearBatch");
         methodObject27882 = Statement.class.getDeclaredMethod("isPoolable");
         methodObject27848 = oracle.jdbc.OracleStatement.class.getDeclaredMethod("setDatabaseChangeRegistration", DatabaseChangeRegistration.class);
         methodObject27875 = Statement.class.getDeclaredMethod("getMoreResults");
         methodObject27836 = oracle.jdbc.OracleStatement.class.getDeclaredMethod("defineColumnType", Integer.TYPE, Integer.TYPE);
         methodObject27860 = Statement.class.getDeclaredMethod("executeUpdate", String.class, Integer.TYPE);
         methodObject27841 = oracle.jdbc.OracleStatement.class.getDeclaredMethod("defineColumnTypeChars", Integer.TYPE, Integer.TYPE, Integer.TYPE);
         methodObject27880 = Statement.class.getDeclaredMethod("getUpdateCount");
         methodObject27881 = Statement.class.getDeclaredMethod("isCloseOnCompletion");
         methodObject27885 = Statement.class.getDeclaredMethod("setMaxFieldSize", Integer.TYPE);
         methodObject27840 = oracle.jdbc.OracleStatement.class.getDeclaredMethod("defineColumnTypeBytes", Integer.TYPE, Integer.TYPE, Integer.TYPE);
         methodObject27864 = Statement.class.getDeclaredMethod("executeQuery", String.class);
         methodObject27835 = oracle.jdbc.OracleStatement.class.getDeclaredMethod("clearDefines");
         methodObject27831 = OracleStatement.class.getDeclaredMethod("getcacheState");
         methodObject27892 = Statement.class.getDeclaredMethod("setFetchSize", Integer.TYPE);
         methodObject27891 = Statement.class.getDeclaredMethod("setFetchDirection", Integer.TYPE);
         methodObject27890 = Statement.class.getDeclaredMethod("getFetchSize");
         methodObject27874 = Statement.class.getDeclaredMethod("getMaxRows");
         methodObject27883 = Statement.class.getDeclaredMethod("setCursorName", String.class);
         methodObject27862 = Statement.class.getDeclaredMethod("executeUpdate", String.class, String[].class);
         methodObject27858 = Statement.class.getDeclaredMethod("executeBatch");
         methodObject27879 = Statement.class.getDeclaredMethod("getResultSetType");
         methodObject27833 = OracleStatement.class.getDeclaredMethod("registerBindChecksumListener", OracleStatement.BindChecksumListener.class);
         methodObject27884 = Statement.class.getDeclaredMethod("setEscapeProcessing", Boolean.TYPE);
         methodObject27877 = Statement.class.getDeclaredMethod("getQueryTimeout");
         methodObject27868 = Statement.class.getDeclaredMethod("getResultSetHoldability");
         methodObject27832 = OracleStatement.class.getDeclaredMethod("getstatementType");
         methodObject27849 = oracle.jdbc.OracleStatement.class.getDeclaredMethod("getRegisteredTableNames");
         methodObject27853 = Statement.class.getDeclaredMethod("execute", String.class, Integer.TYPE);
         methodObject27894 = Wrapper.class.getDeclaredMethod("isWrapperFor", Class.class);
         methodObject27893 = Wrapper.class.getDeclaredMethod("unwrap", Class.class);
         methodObject27869 = Statement.class.getDeclaredMethod("addBatch", String.class);
         methodObject27878 = Statement.class.getDeclaredMethod("getResultSetConcurrency");
         methodObject27896 = ACProxyable.class.getDeclaredMethod("getACProxy");
         methodObject27867 = Statement.class.getDeclaredMethod("clearWarnings");
         methodObject27844 = oracle.jdbc.OracleStatement.class.getDeclaredMethod("getLobPrefetchSize");
         methodObject27887 = Statement.class.getDeclaredMethod("setPoolable", Boolean.TYPE);
         methodObject27863 = Statement.class.getDeclaredMethod("isClosed");
         methodObject27873 = Statement.class.getDeclaredMethod("getMaxFieldSize");
         methodObject27827 = OracleStatement.class.getDeclaredMethod("setFixedString", Boolean.TYPE);
         methodObject27856 = Statement.class.getDeclaredMethod("cancel");
         methodObject27866 = Statement.class.getDeclaredMethod("getWarnings");
         methodObject27829 = OracleStatement.class.getDeclaredMethod("sendBatch");
         methodObject27888 = Statement.class.getDeclaredMethod("setQueryTimeout", Integer.TYPE);
         methodObject27857 = Statement.class.getDeclaredMethod("getResultSet");
         methodObject27865 = Statement.class.getDeclaredMethod("getConnection");
      } catch (Throwable var1) {
         throw new RuntimeException(var1);
      }
   }

   public oracle$1jdbc$1replay$1driver$1NonTxnReplayableStatement$2oracle$1jdbc$1internal$1OracleStatement$$$Proxy(OracleStatement var1, Object var2, ProxyFactory var3, Map var4) {
      this.delegate = var1;
      this.creator = var2;
      this.proxyFactory = var3;
      this.proxyCache = var4;
   }
}
