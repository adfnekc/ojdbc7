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
import oracle.jdbc.replay.driver.TxnReplayableStatement;

public class oracle$1jdbc$1replay$1driver$1TxnReplayableStatement$2oracle$1jdbc$1internal$1OracleStatement$$$Proxy extends TxnReplayableStatement implements OracleStatement, _Proxy_ {
   private OracleStatement delegate;
   private final Object creator;
   private final ProxyFactory proxyFactory;
   private final Map proxyCache;
   private static Object[] zeroLengthObjectArray = new Object[0];
   private static Method methodObject5810;
   private static Method methodObject5767;
   private static Method methodObject5782;
   private static Method methodObject5777;
   private static Method methodObject5775;
   private static Method methodObject5808;
   private static Method methodObject5804;
   private static Method methodObject5773;
   private static Method methodObject5795;
   private static Method methodObject5786;
   private static Method methodObject5778;
   private static Method methodObject5793;
   private static Method methodObject5762;
   private static Method methodObject5780;
   private static Method methodObject5760;
   private static Method methodObject5785;
   private static Method methodObject5814;
   private static Method methodObject5823;
   private static Method methodObject5766;
   private static Method methodObject5796;
   private static Method methodObject5790;
   private static Method methodObject5827;
   private static Method methodObject5822;
   private static Method methodObject5765;
   private static Method methodObject5759;
   private static Method methodObject5803;
   private static Method methodObject5821;
   private static Method methodObject5813;
   private static Method methodObject5776;
   private static Method methodObject5772;
   private static Method methodObject5819;
   private static Method methodObject5820;
   private static Method methodObject5770;
   private static Method methodObject5828;
   private static Method methodObject5763;
   private static Method methodObject5769;
   private static Method methodObject5794;
   private static Method methodObject5812;
   private static Method methodObject5805;
   private static Method methodObject5818;
   private static Method methodObject5789;
   private static Method methodObject5829;
   private static Method methodObject5817;
   private static Method methodObject5815;
   private static Method methodObject5768;
   private static Method methodObject5764;
   private static Method methodObject5784;
   private static Method methodObject5806;
   private static Method methodObject5783;
   private static Method methodObject5816;
   private static Method methodObject5830;
   private static Method methodObject5831;
   private static Method methodObject5807;
   private static Method methodObject5797;
   private static Method methodObject5779;
   private static Method methodObject5788;
   private static Method methodObject5826;
   private static Method methodObject5781;
   private static Method methodObject5774;
   private static Method methodObject5799;
   private static Method methodObject5825;
   private static Method methodObject5811;
   private static Method methodObject5802;
   private static Method methodObject5771;
   private static Method methodObject5787;
   private static Method methodObject5791;
   private static Method methodObject5798;
   private static Method methodObject5761;
   private static Method methodObject5824;
   private static Method methodObject5800;
   private static Method methodObject5809;
   private static Method methodObject5792;
   private static Method methodObject5801;

   public ResultSet getGeneratedKeys() throws SQLException {
      try {
         super.preForAll(methodObject5810, this, zeroLengthObjectArray);
         return (ResultSet)this.postForAll(methodObject5810, this.proxyFactory.proxyForCache((Object)this.delegate.getGeneratedKeys(), this, this.proxyCache, methodObject5810));
      } catch (SQLException var2) {
         return (ResultSet)this.postForAll(methodObject5810, this.onErrorForAll(methodObject5810, var2));
      }
   }

   public void registerBindChecksumListener(OracleStatement.BindChecksumListener arg0) throws SQLException {
      try {
         super.preForAll(methodObject5767, this, arg0);
         Method var10001 = methodObject5767;
         this.delegate.registerBindChecksumListener(arg0);
         this.postForAll(var10001);
      } catch (SQLException var3) {
         this.onErrorVoidForAll(methodObject5767, var3);
      }
   }

   public int creationState() {
      super.preForAll(methodObject5782, this, zeroLengthObjectArray);
      return (Integer)this.postForAll(methodObject5782, this.delegate.creationState());
   }

   public int getRowPrefetch() {
      super.preForAll(methodObject5777, this, zeroLengthObjectArray);
      return (Integer)this.postForAll(methodObject5777, this.delegate.getRowPrefetch());
   }

   public void defineColumnTypeBytes(int arg0, int arg1, int arg2) throws SQLException {
      try {
         super.preForAll(methodObject5775, this, arg0, arg1, arg2);
         Method var10001 = methodObject5775;
         this.delegate.defineColumnTypeBytes(arg0, arg1, arg2);
         this.postForAll(var10001);
      } catch (SQLException var5) {
         this.onErrorVoidForAll(methodObject5775, var5);
      }
   }

   public int executeUpdate(String arg0, int[] arg1) throws SQLException {
      try {
         super.preForExecuteUpdate(methodObject5808, this, arg0, arg1);
         return (Integer)this.postForAll(methodObject5808, this.delegate.executeUpdate(arg0, arg1));
      } catch (SQLException var4) {
         return (Integer)this.postForAll(methodObject5808, this.onErrorForAll(methodObject5808, var4));
      }
   }

   public void closeOnCompletion() throws SQLException {
      try {
         super.preForAll(methodObject5804, this, zeroLengthObjectArray);
         Method var10001 = methodObject5804;
         this.delegate.closeOnCompletion();
         this.postForAll(var10001);
      } catch (SQLException var2) {
         this.onErrorVoidForAll(methodObject5804, var2);
      }
   }

   public void defineColumnType(int arg0, int arg1, int arg2, short arg3) throws SQLException {
      try {
         super.preForAll(methodObject5773, this, arg0, arg1, arg2, arg3);
         Method var10001 = methodObject5773;
         this.delegate.defineColumnType(arg0, arg1, arg2, arg3);
         this.postForAll(var10001);
      } catch (SQLException var6) {
         this.onErrorVoidForAll(methodObject5773, var6);
      }
   }

   public void setFetchDirection(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject5795, this, arg0);
         Method var10001 = methodObject5795;
         this.delegate.setFetchDirection(arg0);
         this.postForAll(var10001);
      } catch (SQLException var3) {
         this.onErrorVoidForAll(methodObject5795, var3);
      }
   }

   public void close() throws SQLException {
      try {
         super.preForAll(methodObject5786, this, zeroLengthObjectArray);
         Method var10001 = methodObject5786;
         this.delegate.close();
         this.postForAll(var10001);
      } catch (SQLException var2) {
         this.onErrorVoidForClose(methodObject5786, var2);
      }
   }

   public void setRowPrefetch(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject5778, this, arg0);
         Method var10001 = methodObject5778;
         this.delegate.setRowPrefetch(arg0);
         this.postForAll(var10001);
      } catch (SQLException var3) {
         this.onErrorVoidForAll(methodObject5778, var3);
      }
   }

   public int getFetchDirection() throws SQLException {
      try {
         super.preForAll(methodObject5793, this, zeroLengthObjectArray);
         return (Integer)this.postForAll(methodObject5793, this.delegate.getFetchDirection());
      } catch (SQLException var2) {
         return (Integer)this.postForAll(methodObject5793, this.onErrorForAll(methodObject5793, var2));
      }
   }

   public boolean getserverCursor() {
      super.preForAll(methodObject5762, this, zeroLengthObjectArray);
      return (Boolean)this.postForAll(methodObject5762, this.delegate.getserverCursor());
   }

   public void setLobPrefetchSize(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject5780, this, arg0);
         Method var10001 = methodObject5780;
         this.delegate.setLobPrefetchSize(arg0);
         this.postForAll(var10001);
      } catch (SQLException var3) {
         this.onErrorVoidForAll(methodObject5780, var3);
      }
   }

   public boolean getFixedString() {
      super.preForAll(methodObject5760, this, zeroLengthObjectArray);
      return (Boolean)this.postForAll(methodObject5760, this.delegate.getFixedString());
   }

   public long getRegisteredQueryId() throws SQLException {
      try {
         super.preForAll(methodObject5785, this, zeroLengthObjectArray);
         return (Long)this.postForAll(methodObject5785, this.delegate.getRegisteredQueryId());
      } catch (SQLException var2) {
         return (Long)this.postForAll(methodObject5785, this.onErrorForAll(methodObject5785, var2));
      }
   }

   public boolean getMoreResults(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject5814, this, arg0);
         return (Boolean)this.postForAll(methodObject5814, this.delegate.getMoreResults(arg0));
      } catch (SQLException var3) {
         return (Boolean)this.postForAll(methodObject5814, this.onErrorForAll(methodObject5814, var3));
      }
   }

   public void setEscapeProcessing(boolean arg0) throws SQLException {
      try {
         super.preForAll(methodObject5823, this, arg0);
         Method var10001 = methodObject5823;
         this.delegate.setEscapeProcessing(arg0);
         this.postForAll(var10001);
      } catch (SQLException var3) {
         this.onErrorVoidForAll(methodObject5823, var3);
      }
   }

   public long getChecksum() throws SQLException {
      try {
         super.preForAll(methodObject5766, this, zeroLengthObjectArray);
         return (Long)this.postForAll(methodObject5766, this.delegate.getChecksum());
      } catch (SQLException var2) {
         return (Long)this.postForAll(methodObject5766, this.onErrorForAll(methodObject5766, var2));
      }
   }

   public void setFetchSize(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject5796, this, arg0);
         Method var10001 = methodObject5796;
         this.delegate.setFetchSize(arg0);
         this.postForAll(var10001);
      } catch (SQLException var3) {
         this.onErrorVoidForAll(methodObject5796, var3);
      }
   }

   public boolean execute(String arg0, String[] arg1) throws SQLException {
      try {
         super.preForExecute(methodObject5790, this, arg0, arg1);
         return (Boolean)this.postForAll(methodObject5790, this.delegate.execute(arg0, arg1));
      } catch (SQLException var4) {
         return (Boolean)this.postForAll(methodObject5790, this.onErrorForAll(methodObject5790, var4));
      }
   }

   public void setQueryTimeout(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject5827, this, arg0);
         Method var10001 = methodObject5827;
         this.delegate.setQueryTimeout(arg0);
         this.postForAll(var10001);
      } catch (SQLException var3) {
         this.onErrorVoidForAll(methodObject5827, var3);
      }
   }

   public void setCursorName(String arg0) throws SQLException {
      try {
         super.preForAll(methodObject5822, this, arg0);
         Method var10001 = methodObject5822;
         this.delegate.setCursorName(arg0);
         this.postForAll(var10001);
      } catch (SQLException var3) {
         this.onErrorVoidForAll(methodObject5822, var3);
      }
   }

   public OracleStatement.SqlKind getSqlKind() throws SQLException {
      try {
         super.preForAll(methodObject5765, this, zeroLengthObjectArray);
         return (OracleStatement.SqlKind)this.postForAll(methodObject5765, (Object)this.delegate.getSqlKind());
      } catch (SQLException var2) {
         return (OracleStatement.SqlKind)this.postForAll(methodObject5765, this.onErrorForAll(methodObject5765, var2));
      }
   }

   public void setFixedString(boolean arg0) {
      super.preForAll(methodObject5759, this, arg0);
      Method var10001 = methodObject5759;
      this.delegate.setFixedString(arg0);
      this.postForAll(var10001);
   }

   public void clearBatch() throws SQLException {
      try {
         super.preForAll(methodObject5803, this, zeroLengthObjectArray);
         Method var10001 = methodObject5803;
         this.delegate.clearBatch();
         this.postForAll(var10001);
      } catch (SQLException var2) {
         this.onErrorVoidForAll(methodObject5803, var2);
      }
   }

   public boolean isPoolable() throws SQLException {
      try {
         super.preForAll(methodObject5821, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject5821, this.delegate.isPoolable());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject5821, this.onErrorForAll(methodObject5821, var2));
      }
   }

   public boolean getMoreResults() throws SQLException {
      try {
         super.preForAll(methodObject5813, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject5813, this.delegate.getMoreResults());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject5813, this.onErrorForAll(methodObject5813, var2));
      }
   }

   public void defineColumnTypeChars(int arg0, int arg1, int arg2) throws SQLException {
      try {
         super.preForAll(methodObject5776, this, arg0, arg1, arg2);
         Method var10001 = methodObject5776;
         this.delegate.defineColumnTypeChars(arg0, arg1, arg2);
         this.postForAll(var10001);
      } catch (SQLException var5) {
         this.onErrorVoidForAll(methodObject5776, var5);
      }
   }

   public void defineColumnType(int arg0, int arg1, int arg2) throws SQLException {
      try {
         super.preForAll(methodObject5772, this, arg0, arg1, arg2);
         Method var10001 = methodObject5772;
         this.delegate.defineColumnType(arg0, arg1, arg2);
         this.postForAll(var10001);
      } catch (SQLException var5) {
         this.onErrorVoidForAll(methodObject5772, var5);
      }
   }

   public int getUpdateCount() throws SQLException {
      try {
         super.preForAll(methodObject5819, this, zeroLengthObjectArray);
         return (Integer)this.postForAll(methodObject5819, this.delegate.getUpdateCount());
      } catch (SQLException var2) {
         return (Integer)this.postForAll(methodObject5819, this.onErrorForAll(methodObject5819, var2));
      }
   }

   public boolean isCloseOnCompletion() throws SQLException {
      try {
         super.preForAll(methodObject5820, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject5820, this.delegate.isCloseOnCompletion());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject5820, this.onErrorForAll(methodObject5820, var2));
      }
   }

   public void clearDefines() throws SQLException {
      try {
         super.preForAll(methodObject5770, this, zeroLengthObjectArray);
         Method var10001 = methodObject5770;
         this.delegate.clearDefines();
         this.postForAll(var10001);
      } catch (SQLException var2) {
         this.onErrorVoidForAll(methodObject5770, var2);
      }
   }

   public Object unwrap(Class arg0) throws SQLException {
      try {
         super.preForAll(methodObject5828, this, arg0);
         return this.postForAll(methodObject5828, this.proxyFactory.proxyForCache(this.delegate.unwrap(arg0), this, this.proxyCache, methodObject5828));
      } catch (SQLException var3) {
         return this.postForAll(methodObject5828, this.onErrorForAll(methodObject5828, var3));
      }
   }

   public int getcacheState() {
      super.preForAll(methodObject5763, this, zeroLengthObjectArray);
      return (Integer)this.postForAll(methodObject5763, this.delegate.getcacheState());
   }

   public boolean isNCHAR(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject5769, this, arg0);
         return (Boolean)this.postForAll(methodObject5769, this.delegate.isNCHAR(arg0));
      } catch (SQLException var3) {
         return (Boolean)this.postForAll(methodObject5769, this.onErrorForAll(methodObject5769, var3));
      }
   }

   public int getFetchSize() throws SQLException {
      try {
         super.preForAll(methodObject5794, this, zeroLengthObjectArray);
         return (Integer)this.postForAll(methodObject5794, this.delegate.getFetchSize());
      } catch (SQLException var2) {
         return (Integer)this.postForAll(methodObject5794, this.onErrorForAll(methodObject5794, var2));
      }
   }

   public int getMaxRows() throws SQLException {
      try {
         super.preForAll(methodObject5812, this, zeroLengthObjectArray);
         return (Integer)this.postForAll(methodObject5812, this.delegate.getMaxRows());
      } catch (SQLException var2) {
         return (Integer)this.postForAll(methodObject5812, this.onErrorForAll(methodObject5812, var2));
      }
   }

   public int[] executeBatch() throws SQLException {
      try {
         super.preForBatches(methodObject5805, this, zeroLengthObjectArray);
         return (int[])this.postForAll(methodObject5805, (Object)this.delegate.executeBatch());
      } catch (SQLException var2) {
         return (int[])this.postForAll(methodObject5805, this.onErrorForAll(methodObject5805, var2));
      }
   }

   public int getResultSetType() throws SQLException {
      try {
         super.preForAll(methodObject5818, this, zeroLengthObjectArray);
         return (Integer)this.postForAll(methodObject5818, this.delegate.getResultSetType());
      } catch (SQLException var2) {
         return (Integer)this.postForAll(methodObject5818, this.onErrorForAll(methodObject5818, var2));
      }
   }

   public boolean execute(String arg0, int[] arg1) throws SQLException {
      try {
         super.preForExecute(methodObject5789, this, arg0, arg1);
         return (Boolean)this.postForAll(methodObject5789, this.delegate.execute(arg0, arg1));
      } catch (SQLException var4) {
         return (Boolean)this.postForAll(methodObject5789, this.onErrorForAll(methodObject5789, var4));
      }
   }

   public boolean isWrapperFor(Class arg0) throws SQLException {
      try {
         super.preForAll(methodObject5829, this, arg0);
         return (Boolean)this.postForAll(methodObject5829, this.delegate.isWrapperFor(arg0));
      } catch (SQLException var3) {
         return (Boolean)this.postForAll(methodObject5829, this.onErrorForAll(methodObject5829, var3));
      }
   }

   public int getResultSetHoldability() throws SQLException {
      try {
         super.preForAll(methodObject5817, this, zeroLengthObjectArray);
         return (Integer)this.postForAll(methodObject5817, this.delegate.getResultSetHoldability());
      } catch (SQLException var2) {
         return (Integer)this.postForAll(methodObject5817, this.onErrorForAll(methodObject5817, var2));
      }
   }

   public int getQueryTimeout() throws SQLException {
      try {
         super.preForAll(methodObject5815, this, zeroLengthObjectArray);
         return (Integer)this.postForAll(methodObject5815, this.delegate.getQueryTimeout());
      } catch (SQLException var2) {
         return (Integer)this.postForAll(methodObject5815, this.onErrorForAll(methodObject5815, var2));
      }
   }

   public void setSnapshotSCN(long arg0) throws SQLException {
      try {
         super.preForAll(methodObject5768, this, arg0);
         Method var10001 = methodObject5768;
         this.delegate.setSnapshotSCN(arg0);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject5768, var4);
      }
   }

   public int getstatementType() {
      super.preForAll(methodObject5764, this, zeroLengthObjectArray);
      return (Integer)this.postForAll(methodObject5764, this.delegate.getstatementType());
   }

   public String[] getRegisteredTableNames() throws SQLException {
      try {
         super.preForAll(methodObject5784, this, zeroLengthObjectArray);
         return (String[])this.postForAll(methodObject5784, (Object)this.delegate.getRegisteredTableNames());
      } catch (SQLException var2) {
         return (String[])this.postForAll(methodObject5784, this.onErrorForAll(methodObject5784, var2));
      }
   }

   public int executeUpdate(String arg0) throws SQLException {
      try {
         super.preForExecuteUpdate(methodObject5806, this, arg0);
         return (Integer)this.postForAll(methodObject5806, this.delegate.executeUpdate(arg0));
      } catch (SQLException var3) {
         return (Integer)this.postForAll(methodObject5806, this.onErrorForAll(methodObject5806, var3));
      }
   }

   public void setDatabaseChangeRegistration(DatabaseChangeRegistration arg0) throws SQLException {
      try {
         super.preForAll(methodObject5783, this, arg0);
         Method var10001 = methodObject5783;
         this.delegate.setDatabaseChangeRegistration(arg0);
         this.postForAll(var10001);
      } catch (SQLException var3) {
         this.onErrorVoidForAll(methodObject5783, var3);
      }
   }

   public int getResultSetConcurrency() throws SQLException {
      try {
         super.preForAll(methodObject5816, this, zeroLengthObjectArray);
         return (Integer)this.postForAll(methodObject5816, this.delegate.getResultSetConcurrency());
      } catch (SQLException var2) {
         return (Integer)this.postForAll(methodObject5816, this.onErrorForAll(methodObject5816, var2));
      }
   }

   public void setACProxy(Object arg0) {
      super.preForAll(methodObject5830, this, arg0);
      Method var10001 = methodObject5830;
      this.delegate.setACProxy(arg0 instanceof _Proxy_ ? (Object)((_Proxy_)arg0)._getDelegate_() : arg0);
      this.postForAll(var10001);
   }

   public Object getACProxy() {
      super.preForAll(methodObject5831, this, zeroLengthObjectArray);
      return this.postForAll(methodObject5831, this.proxyFactory.proxyForCache(this.delegate.getACProxy(), this, this.proxyCache, methodObject5831));
   }

   public int executeUpdate(String arg0, int arg1) throws SQLException {
      try {
         super.preForExecuteUpdate(methodObject5807, this, arg0, arg1);
         return (Integer)this.postForAll(methodObject5807, this.delegate.executeUpdate(arg0, arg1));
      } catch (SQLException var4) {
         return (Integer)this.postForAll(methodObject5807, this.onErrorForAll(methodObject5807, var4));
      }
   }

   public void clearWarnings() throws SQLException {
      try {
         super.preForAll(methodObject5797, this, zeroLengthObjectArray);
         Method var10001 = methodObject5797;
         this.delegate.clearWarnings();
         this.postForAll(var10001);
      } catch (SQLException var2) {
         this.onErrorVoidForAll(methodObject5797, var2);
      }
   }

   public int getLobPrefetchSize() throws SQLException {
      try {
         super.preForAll(methodObject5779, this, zeroLengthObjectArray);
         return (Integer)this.postForAll(methodObject5779, this.delegate.getLobPrefetchSize());
      } catch (SQLException var2) {
         return (Integer)this.postForAll(methodObject5779, this.onErrorForAll(methodObject5779, var2));
      }
   }

   public boolean execute(String arg0, int arg1) throws SQLException {
      try {
         super.preForExecute(methodObject5788, this, arg0, arg1);
         return (Boolean)this.postForAll(methodObject5788, this.delegate.execute(arg0, arg1));
      } catch (SQLException var4) {
         return (Boolean)this.postForAll(methodObject5788, this.onErrorForAll(methodObject5788, var4));
      }
   }

   public void setPoolable(boolean arg0) throws SQLException {
      try {
         super.preForAll(methodObject5826, this, arg0);
         Method var10001 = methodObject5826;
         this.delegate.setPoolable(arg0);
         this.postForAll(var10001);
      } catch (SQLException var3) {
         this.onErrorVoidForAll(methodObject5826, var3);
      }
   }

   public void closeWithKey(String arg0) throws SQLException {
      try {
         super.preForAll(methodObject5781, this, arg0);
         Method var10001 = methodObject5781;
         this.delegate.closeWithKey(arg0);
         this.postForAll(var10001);
      } catch (SQLException var3) {
         this.onErrorVoidForAll(methodObject5781, var3);
      }
   }

   public void defineColumnType(int arg0, int arg1, String arg2) throws SQLException {
      try {
         super.preForAll(methodObject5774, this, arg0, arg1, arg2);
         Method var10001 = methodObject5774;
         this.delegate.defineColumnType(arg0, arg1, arg2);
         this.postForAll(var10001);
      } catch (SQLException var5) {
         this.onErrorVoidForAll(methodObject5774, var5);
      }
   }

   public boolean isClosed() throws SQLException {
      try {
         super.preForAll(methodObject5799, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject5799, this.delegate.isClosed());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject5799, this.onErrorForAll(methodObject5799, var2));
      }
   }

   public void setMaxRows(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject5825, this, arg0);
         Method var10001 = methodObject5825;
         this.delegate.setMaxRows(arg0);
         this.postForAll(var10001);
      } catch (SQLException var3) {
         this.onErrorVoidForAll(methodObject5825, var3);
      }
   }

   public int getMaxFieldSize() throws SQLException {
      try {
         super.preForAll(methodObject5811, this, zeroLengthObjectArray);
         return (Integer)this.postForAll(methodObject5811, this.delegate.getMaxFieldSize());
      } catch (SQLException var2) {
         return (Integer)this.postForAll(methodObject5811, this.onErrorForAll(methodObject5811, var2));
      }
   }

   public void addBatch(String arg0) throws SQLException {
      try {
         super.preForAll(methodObject5802, this, arg0);
         Method var10001 = methodObject5802;
         this.delegate.addBatch(arg0);
         this.postForAll(var10001);
      } catch (SQLException var3) {
         this.onErrorVoidForAll(methodObject5802, var3);
      }
   }

   public void defineColumnType(int arg0, int arg1) throws SQLException {
      try {
         super.preForAll(methodObject5771, this, arg0, arg1);
         Method var10001 = methodObject5771;
         this.delegate.defineColumnType(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject5771, var4);
      }
   }

   public boolean execute(String arg0) throws SQLException {
      try {
         super.preForExecute(methodObject5787, this, arg0);
         return (Boolean)this.postForAll(methodObject5787, this.delegate.execute(arg0));
      } catch (SQLException var3) {
         return (Boolean)this.postForAll(methodObject5787, this.onErrorForAll(methodObject5787, var3));
      }
   }

   public void cancel() throws SQLException {
      try {
         super.preForAll(methodObject5791, this, zeroLengthObjectArray);
         Method var10001 = methodObject5791;
         this.delegate.cancel();
         this.postForAll(var10001);
      } catch (SQLException var2) {
         this.onErrorVoidForAll(methodObject5791, var2);
      }
   }

   public SQLWarning getWarnings() throws SQLException {
      try {
         super.preForAll(methodObject5798, this, zeroLengthObjectArray);
         return (SQLWarning)this.postForAll(methodObject5798, (Object)this.delegate.getWarnings());
      } catch (SQLException var2) {
         return (SQLWarning)this.postForAll(methodObject5798, this.onErrorForAll(methodObject5798, var2));
      }
   }

   public int sendBatch() throws SQLException {
      try {
         super.preForBatches(methodObject5761, this, zeroLengthObjectArray);
         return (Integer)this.postForAll(methodObject5761, this.delegate.sendBatch());
      } catch (SQLException var2) {
         return (Integer)this.postForAll(methodObject5761, this.onErrorForAll(methodObject5761, var2));
      }
   }

   public void setMaxFieldSize(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject5824, this, arg0);
         Method var10001 = methodObject5824;
         this.delegate.setMaxFieldSize(arg0);
         this.postForAll(var10001);
      } catch (SQLException var3) {
         this.onErrorVoidForAll(methodObject5824, var3);
      }
   }

   public ResultSet executeQuery(String arg0) throws SQLException {
      try {
         super.preForExecuteQuery(methodObject5800, this, arg0);
         return this.postForExecuteQuery(methodObject5800, (ResultSet)this.proxyFactory.proxyForCache((Object)this.delegate.executeQuery(arg0), this, this.proxyCache, methodObject5800));
      } catch (SQLException var3) {
         return this.postForExecuteQuery(methodObject5800, (ResultSet)this.onErrorForAll(methodObject5800, var3));
      }
   }

   public int executeUpdate(String arg0, String[] arg1) throws SQLException {
      try {
         super.preForExecuteUpdate(methodObject5809, this, arg0, arg1);
         return (Integer)this.postForAll(methodObject5809, this.delegate.executeUpdate(arg0, arg1));
      } catch (SQLException var4) {
         return (Integer)this.postForAll(methodObject5809, this.onErrorForAll(methodObject5809, var4));
      }
   }

   public ResultSet getResultSet() throws SQLException {
      try {
         super.preForAll(methodObject5792, this, zeroLengthObjectArray);
         return this.postForGetResultSet(methodObject5792, (ResultSet)this.proxyFactory.proxyForCache((Object)this.delegate.getResultSet(), this, this.proxyCache, methodObject5792));
      } catch (SQLException var2) {
         return this.postForGetResultSet(methodObject5792, (ResultSet)this.onErrorForAll(methodObject5792, var2));
      }
   }

   public Connection getConnection() throws SQLException {
      try {
         super.preForAll(methodObject5801, this, zeroLengthObjectArray);
         return (Connection)this.postForAll(methodObject5801, this.proxyFactory.proxyForCache((Object)this.delegate.getConnection(), this, this.proxyCache, methodObject5801));
      } catch (SQLException var2) {
         return (Connection)this.postForAll(methodObject5801, this.onErrorForAll(methodObject5801, var2));
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
         methodObject5810 = Statement.class.getDeclaredMethod("getGeneratedKeys");
         methodObject5767 = OracleStatement.class.getDeclaredMethod("registerBindChecksumListener", OracleStatement.BindChecksumListener.class);
         methodObject5782 = oracle.jdbc.OracleStatement.class.getDeclaredMethod("creationState");
         methodObject5777 = oracle.jdbc.OracleStatement.class.getDeclaredMethod("getRowPrefetch");
         methodObject5775 = oracle.jdbc.OracleStatement.class.getDeclaredMethod("defineColumnTypeBytes", Integer.TYPE, Integer.TYPE, Integer.TYPE);
         methodObject5808 = Statement.class.getDeclaredMethod("executeUpdate", String.class, int[].class);
         methodObject5804 = Statement.class.getDeclaredMethod("closeOnCompletion");
         methodObject5773 = oracle.jdbc.OracleStatement.class.getDeclaredMethod("defineColumnType", Integer.TYPE, Integer.TYPE, Integer.TYPE, Short.TYPE);
         methodObject5795 = Statement.class.getDeclaredMethod("setFetchDirection", Integer.TYPE);
         methodObject5786 = Statement.class.getDeclaredMethod("close");
         methodObject5778 = oracle.jdbc.OracleStatement.class.getDeclaredMethod("setRowPrefetch", Integer.TYPE);
         methodObject5793 = Statement.class.getDeclaredMethod("getFetchDirection");
         methodObject5762 = OracleStatement.class.getDeclaredMethod("getserverCursor");
         methodObject5780 = oracle.jdbc.OracleStatement.class.getDeclaredMethod("setLobPrefetchSize", Integer.TYPE);
         methodObject5760 = OracleStatement.class.getDeclaredMethod("getFixedString");
         methodObject5785 = oracle.jdbc.OracleStatement.class.getDeclaredMethod("getRegisteredQueryId");
         methodObject5814 = Statement.class.getDeclaredMethod("getMoreResults", Integer.TYPE);
         methodObject5823 = Statement.class.getDeclaredMethod("setEscapeProcessing", Boolean.TYPE);
         methodObject5766 = OracleStatement.class.getDeclaredMethod("getChecksum");
         methodObject5796 = Statement.class.getDeclaredMethod("setFetchSize", Integer.TYPE);
         methodObject5790 = Statement.class.getDeclaredMethod("execute", String.class, String[].class);
         methodObject5827 = Statement.class.getDeclaredMethod("setQueryTimeout", Integer.TYPE);
         methodObject5822 = Statement.class.getDeclaredMethod("setCursorName", String.class);
         methodObject5765 = OracleStatement.class.getDeclaredMethod("getSqlKind");
         methodObject5759 = OracleStatement.class.getDeclaredMethod("setFixedString", Boolean.TYPE);
         methodObject5803 = Statement.class.getDeclaredMethod("clearBatch");
         methodObject5821 = Statement.class.getDeclaredMethod("isPoolable");
         methodObject5813 = Statement.class.getDeclaredMethod("getMoreResults");
         methodObject5776 = oracle.jdbc.OracleStatement.class.getDeclaredMethod("defineColumnTypeChars", Integer.TYPE, Integer.TYPE, Integer.TYPE);
         methodObject5772 = oracle.jdbc.OracleStatement.class.getDeclaredMethod("defineColumnType", Integer.TYPE, Integer.TYPE, Integer.TYPE);
         methodObject5819 = Statement.class.getDeclaredMethod("getUpdateCount");
         methodObject5820 = Statement.class.getDeclaredMethod("isCloseOnCompletion");
         methodObject5770 = oracle.jdbc.OracleStatement.class.getDeclaredMethod("clearDefines");
         methodObject5828 = Wrapper.class.getDeclaredMethod("unwrap", Class.class);
         methodObject5763 = OracleStatement.class.getDeclaredMethod("getcacheState");
         methodObject5769 = oracle.jdbc.OracleStatement.class.getDeclaredMethod("isNCHAR", Integer.TYPE);
         methodObject5794 = Statement.class.getDeclaredMethod("getFetchSize");
         methodObject5812 = Statement.class.getDeclaredMethod("getMaxRows");
         methodObject5805 = Statement.class.getDeclaredMethod("executeBatch");
         methodObject5818 = Statement.class.getDeclaredMethod("getResultSetType");
         methodObject5789 = Statement.class.getDeclaredMethod("execute", String.class, int[].class);
         methodObject5829 = Wrapper.class.getDeclaredMethod("isWrapperFor", Class.class);
         methodObject5817 = Statement.class.getDeclaredMethod("getResultSetHoldability");
         methodObject5815 = Statement.class.getDeclaredMethod("getQueryTimeout");
         methodObject5768 = OracleStatement.class.getDeclaredMethod("setSnapshotSCN", Long.TYPE);
         methodObject5764 = OracleStatement.class.getDeclaredMethod("getstatementType");
         methodObject5784 = oracle.jdbc.OracleStatement.class.getDeclaredMethod("getRegisteredTableNames");
         methodObject5806 = Statement.class.getDeclaredMethod("executeUpdate", String.class);
         methodObject5783 = oracle.jdbc.OracleStatement.class.getDeclaredMethod("setDatabaseChangeRegistration", DatabaseChangeRegistration.class);
         methodObject5816 = Statement.class.getDeclaredMethod("getResultSetConcurrency");
         methodObject5830 = ACProxyable.class.getDeclaredMethod("setACProxy", Object.class);
         methodObject5831 = ACProxyable.class.getDeclaredMethod("getACProxy");
         methodObject5807 = Statement.class.getDeclaredMethod("executeUpdate", String.class, Integer.TYPE);
         methodObject5797 = Statement.class.getDeclaredMethod("clearWarnings");
         methodObject5779 = oracle.jdbc.OracleStatement.class.getDeclaredMethod("getLobPrefetchSize");
         methodObject5788 = Statement.class.getDeclaredMethod("execute", String.class, Integer.TYPE);
         methodObject5826 = Statement.class.getDeclaredMethod("setPoolable", Boolean.TYPE);
         methodObject5781 = oracle.jdbc.OracleStatement.class.getDeclaredMethod("closeWithKey", String.class);
         methodObject5774 = oracle.jdbc.OracleStatement.class.getDeclaredMethod("defineColumnType", Integer.TYPE, Integer.TYPE, String.class);
         methodObject5799 = Statement.class.getDeclaredMethod("isClosed");
         methodObject5825 = Statement.class.getDeclaredMethod("setMaxRows", Integer.TYPE);
         methodObject5811 = Statement.class.getDeclaredMethod("getMaxFieldSize");
         methodObject5802 = Statement.class.getDeclaredMethod("addBatch", String.class);
         methodObject5771 = oracle.jdbc.OracleStatement.class.getDeclaredMethod("defineColumnType", Integer.TYPE, Integer.TYPE);
         methodObject5787 = Statement.class.getDeclaredMethod("execute", String.class);
         methodObject5791 = Statement.class.getDeclaredMethod("cancel");
         methodObject5798 = Statement.class.getDeclaredMethod("getWarnings");
         methodObject5761 = OracleStatement.class.getDeclaredMethod("sendBatch");
         methodObject5824 = Statement.class.getDeclaredMethod("setMaxFieldSize", Integer.TYPE);
         methodObject5800 = Statement.class.getDeclaredMethod("executeQuery", String.class);
         methodObject5809 = Statement.class.getDeclaredMethod("executeUpdate", String.class, String[].class);
         methodObject5792 = Statement.class.getDeclaredMethod("getResultSet");
         methodObject5801 = Statement.class.getDeclaredMethod("getConnection");
      } catch (Throwable var1) {
         throw new RuntimeException(var1);
      }
   }

   public oracle$1jdbc$1replay$1driver$1TxnReplayableStatement$2oracle$1jdbc$1internal$1OracleStatement$$$Proxy(OracleStatement var1, Object var2, ProxyFactory var3, Map var4) {
      this.delegate = var1;
      this.creator = var2;
      this.proxyFactory = var3;
      this.proxyCache = var4;
   }
}
