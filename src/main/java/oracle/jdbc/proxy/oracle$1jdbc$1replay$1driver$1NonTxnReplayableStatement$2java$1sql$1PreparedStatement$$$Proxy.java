package oracle.jdbc.proxy;

import java.io.InputStream;
import java.io.Reader;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.net.URL;
import java.sql.Array;
import java.sql.Blob;
import java.sql.Clob;
import java.sql.Connection;
import java.sql.Date;
import java.sql.NClob;
import java.sql.ParameterMetaData;
import java.sql.PreparedStatement;
import java.sql.Ref;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.RowId;
import java.sql.SQLException;
import java.sql.SQLWarning;
import java.sql.SQLXML;
import java.sql.Statement;
import java.sql.Time;
import java.sql.Timestamp;
import java.sql.Wrapper;
import java.util.Calendar;
import java.util.Map;
import oracle.jdbc.replay.driver.NonTxnReplayableStatement;

public abstract class oracle$1jdbc$1replay$1driver$1NonTxnReplayableStatement$2java$1sql$1PreparedStatement$$$Proxy extends NonTxnReplayableStatement implements PreparedStatement, _Proxy_ {
   private PreparedStatement delegate;
   private final Object creator;
   private final ProxyFactory proxyFactory;
   private final Map proxyCache;
   private static Object[] zeroLengthObjectArray = new Object[0];
   private static Method methodObject26294;
   private static Method methodObject26259;
   private static Method methodObject26289;
   private static Method methodObject26283;
   private static Method methodObject26303;
   private static Method methodObject26239;
   private static Method methodObject26240;
   private static Method methodObject26296;
   private static Method methodObject26287;
   private static Method methodObject26301;
   private static Method methodObject26271;
   private static Method methodObject26245;
   private static Method methodObject26324;
   private static Method methodObject26286;
   private static Method methodObject26317;
   private static Method methodObject26302;
   private static Method methodObject26261;
   private static Method methodObject26270;
   private static Method methodObject26322;
   private static Method methodObject26265;
   private static Method methodObject26323;
   private static Method methodObject26327;
   private static Method methodObject26306;
   private static Method methodObject26241;
   private static Method methodObject26290;
   private static Method methodObject26255;
   private static Method methodObject26316;
   private static Method methodObject26274;
   private static Method methodObject26273;
   private static Method methodObject26304;
   private static Method methodObject26300;
   private static Method methodObject26321;
   private static Method methodObject26326;
   private static Method methodObject26310;
   private static Method methodObject26319;
   private static Method methodObject26280;
   private static Method methodObject26295;
   private static Method methodObject26285;
   private static Method methodObject26247;
   private static Method methodObject26276;
   private static Method methodObject26309;
   private static Method methodObject26288;
   private static Method methodObject26282;
   private static Method methodObject26266;
   private static Method methodObject26267;
   private static Method methodObject26305;
   private static Method methodObject26329;
   private static Method methodObject26308;
   private static Method methodObject26307;
   private static Method methodObject26258;
   private static Method methodObject26314;
   private static Method methodObject26328;
   private static Method methodObject26281;
   private static Method methodObject26297;
   private static Method methodObject26313;
   private static Method methodObject26293;
   private static Method methodObject26331;
   private static Method methodObject26277;
   private static Method methodObject26278;
   private static Method methodObject26257;
   private static Method methodObject26246;
   private static Method methodObject26238;
   private static Method methodObject26254;
   private static Method methodObject26244;
   private static Method methodObject26312;
   private static Method methodObject26318;
   private static Method methodObject26291;
   private static Method methodObject26284;
   private static Method methodObject26250;
   private static Method methodObject26249;
   private static Method methodObject26260;
   private static Method methodObject26269;
   private static Method methodObject26243;
   private static Method methodObject26279;
   private static Method methodObject26272;
   private static Method methodObject26333;
   private static Method methodObject26334;
   private static Method methodObject26332;
   private static Method methodObject26256;
   private static Method methodObject26325;
   private static Method methodObject26262;
   private static Method methodObject26252;
   private static Method methodObject26253;
   private static Method methodObject26275;
   private static Method methodObject26336;
   private static Method methodObject26335;
   private static Method methodObject26311;
   private static Method methodObject26320;
   private static Method methodObject26248;
   private static Method methodObject26268;
   private static Method methodObject26263;
   private static Method methodObject26264;
   private static Method methodObject26251;
   private static Method methodObject26315;
   private static Method methodObject26292;
   private static Method methodObject26298;
   private static Method methodObject26242;
   private static Method methodObject26299;
   private static Method methodObject26330;

   public boolean execute(String arg0) throws SQLException {
      try {
         super.preForExecute(methodObject26294, this, arg0);
         return this.postForExecute(methodObject26294, this.delegate.execute(arg0));
      } catch (SQLException var3) {
         return this.postForExecute(methodObject26294, this.onErrorForExecute(methodObject26294, var3));
      }
   }

   public void setNCharacterStream(int arg0, Reader arg1, long arg2) throws SQLException {
      try {
         super.preForSetStreams(methodObject26259, this, arg0, arg1, arg2);
         this.delegate.setNCharacterStream(arg0, arg1, arg2);
      } catch (SQLException var6) {
         this.onErrorVoidForAll(methodObject26259, var6);
      }
   }

   public void setRowId(int arg0, RowId arg1) throws SQLException {
      try {
         super.preForAll(methodObject26289, this, arg0, arg1);
         this.delegate.setRowId(arg0, arg1 instanceof _Proxy_ ? (RowId)((_Proxy_)arg1)._getDelegate_() : arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject26289, var4);
      }
   }

   public void setNClob(int arg0, NClob arg1) throws SQLException {
      try {
         super.preForAll(methodObject26283, this, arg0, arg1);
         this.delegate.setNClob(arg0, arg1 instanceof _Proxy_ ? (NClob)((_Proxy_)arg1)._getDelegate_() : arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject26283, var4);
      }
   }

   public int executeUpdate(String arg0, int[] arg1) throws SQLException {
      try {
         super.preForExecuteUpdate(methodObject26303, this, arg0, arg1);
         return this.postForExecuteUpdate(methodObject26303, this.delegate.executeUpdate(arg0, arg1));
      } catch (SQLException var4) {
         return this.postForExecuteUpdate(methodObject26303, (Integer)this.onErrorForAll(methodObject26303, var4));
      }
   }

   public void setByte(int arg0, byte arg1) throws SQLException {
      try {
         super.preForAll(methodObject26239, this, arg0, arg1);
         this.delegate.setByte(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject26239, var4);
      }
   }

   public void setDouble(int arg0, double arg1) throws SQLException {
      try {
         super.preForAll(methodObject26240, this, arg0, arg1);
         this.delegate.setDouble(arg0, arg1);
      } catch (SQLException var5) {
         this.onErrorVoidForAll(methodObject26240, var5);
      }
   }

   public boolean execute(String arg0, int[] arg1) throws SQLException {
      try {
         super.preForExecute(methodObject26296, this, arg0, arg1);
         return this.postForExecute(methodObject26296, this.delegate.execute(arg0, arg1));
      } catch (SQLException var4) {
         return this.postForExecute(methodObject26296, this.onErrorForExecute(methodObject26296, var4));
      }
   }

   public void setNull(int arg0, int arg1) throws SQLException {
      try {
         super.preForAll(methodObject26287, this, arg0, arg1);
         this.delegate.setNull(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject26287, var4);
      }
   }

   public int executeUpdate(String arg0) throws SQLException {
      try {
         super.preForExecuteUpdate(methodObject26301, this, arg0);
         return this.postForExecuteUpdate(methodObject26301, this.delegate.executeUpdate(arg0));
      } catch (SQLException var3) {
         return this.postForExecuteUpdate(methodObject26301, (Integer)this.onErrorForAll(methodObject26301, var3));
      }
   }

   public void setDate(int arg0, Date arg1) throws SQLException {
      try {
         super.preForAll(methodObject26271, this, arg0, arg1);
         this.delegate.setDate(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject26271, var4);
      }
   }

   public void setTimestamp(int arg0, Timestamp arg1) throws SQLException {
      try {
         super.preForAll(methodObject26245, this, arg0, arg1);
         this.delegate.setTimestamp(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject26245, var4);
      }
   }

   public boolean isPoolable() throws SQLException {
      try {
         super.preForAll(methodObject26324, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject26324, this.delegate.isPoolable());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject26324, this.onErrorForAll(methodObject26324, var2));
      }
   }

   public void setNString(int arg0, String arg1) throws SQLException {
      try {
         super.preForAll(methodObject26286, this, arg0, arg1);
         this.delegate.setNString(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject26286, var4);
      }
   }

   public boolean getMoreResults() throws SQLException {
      try {
         super.preForAll(methodObject26317, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject26317, this.delegate.getMoreResults());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject26317, this.onErrorForAll(methodObject26317, var2));
      }
   }

   public int executeUpdate(String arg0, int arg1) throws SQLException {
      try {
         super.preForExecuteUpdate(methodObject26302, this, arg0, arg1);
         return this.postForExecuteUpdate(methodObject26302, this.delegate.executeUpdate(arg0, arg1));
      } catch (SQLException var4) {
         return this.postForExecuteUpdate(methodObject26302, (Integer)this.onErrorForAll(methodObject26302, var4));
      }
   }

   public void setUnicodeStream(int arg0, InputStream arg1, int arg2) throws SQLException {
      try {
         super.preForAll(methodObject26261, this, arg0, arg1, arg2);
         this.delegate.setUnicodeStream(arg0, arg1, arg2);
      } catch (SQLException var5) {
         this.onErrorVoidForAll(methodObject26261, var5);
      }
   }

   public void setTime(int arg0, Time arg1, Calendar arg2) throws SQLException {
      try {
         super.preForAll(methodObject26270, this, arg0, arg1, arg2);
         this.delegate.setTime(arg0, arg1, arg2);
      } catch (SQLException var5) {
         this.onErrorVoidForAll(methodObject26270, var5);
      }
   }

   public int getUpdateCount() throws SQLException {
      try {
         super.preForAll(methodObject26322, this, zeroLengthObjectArray);
         return (Integer)this.postForAll(methodObject26322, this.delegate.getUpdateCount());
      } catch (SQLException var2) {
         return (Integer)this.postForAll(methodObject26322, this.onErrorForAll(methodObject26322, var2));
      }
   }

   public void setObject(int arg0, Object arg1, int arg2, int arg3) throws SQLException {
      try {
         super.preForSetObjects(methodObject26265, this, arg0, arg1, arg2, arg3);
         this.delegate.setObject(arg0, arg1 instanceof _Proxy_ ? (Object)((_Proxy_)arg1)._getDelegate_() : arg1, arg2, arg3);
      } catch (SQLException var6) {
         this.onErrorVoidForAll(methodObject26265, var6);
      }
   }

   public boolean isCloseOnCompletion() throws SQLException {
      try {
         super.preForAll(methodObject26323, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject26323, this.delegate.isCloseOnCompletion());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject26323, this.onErrorForAll(methodObject26323, var2));
      }
   }

   public void setMaxFieldSize(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject26327, this, arg0);
         this.delegate.setMaxFieldSize(arg0);
      } catch (SQLException var3) {
         this.onErrorVoidForAll(methodObject26327, var3);
      }
   }

   public ResultSet executeQuery(String arg0) throws SQLException {
      try {
         super.preForAll(methodObject26306, this, arg0);
         return this.postForExecuteQuery(methodObject26306, (ResultSet)this.proxyFactory.proxyForCreateCache((Object)this.delegate.executeQuery(arg0), this, this.proxyCache, methodObject26306));
      } catch (SQLException var3) {
         return this.postForExecuteQuery(methodObject26306, (ResultSet)this.onErrorForAll(methodObject26306, var3));
      }
   }

   public void setFloat(int arg0, float arg1) throws SQLException {
      try {
         super.preForAll(methodObject26241, this, arg0, arg1);
         this.delegate.setFloat(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject26241, var4);
      }
   }

   public void setSQLXML(int arg0, SQLXML arg1) throws SQLException {
      try {
         super.preForAll(methodObject26290, this, arg0, arg1);
         this.delegate.setSQLXML(arg0, arg1 instanceof _Proxy_ ? (SQLXML)((_Proxy_)arg1)._getDelegate_() : arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject26290, var4);
      }
   }

   public void setBinaryStream(int arg0, InputStream arg1) throws SQLException {
      try {
         super.preForSetStreams(methodObject26255, this, arg0, arg1);
         this.delegate.setBinaryStream(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject26255, var4);
      }
   }

   public int getMaxRows() throws SQLException {
      try {
         super.preForAll(methodObject26316, this, zeroLengthObjectArray);
         return (Integer)this.postForAll(methodObject26316, this.delegate.getMaxRows());
      } catch (SQLException var2) {
         return (Integer)this.postForAll(methodObject26316, this.onErrorForAll(methodObject26316, var2));
      }
   }

   public void addBatch() throws SQLException {
      try {
         super.preForAll(methodObject26274, this, zeroLengthObjectArray);
         this.delegate.addBatch();
      } catch (SQLException var2) {
         this.onErrorVoidForAll(methodObject26274, var2);
      }
   }

   public void setString(int arg0, String arg1) throws SQLException {
      try {
         super.preForAll(methodObject26273, this, arg0, arg1);
         this.delegate.setString(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject26273, var4);
      }
   }

   public int executeUpdate(String arg0, String[] arg1) throws SQLException {
      try {
         super.preForExecuteUpdate(methodObject26304, this, arg0, arg1);
         return this.postForExecuteUpdate(methodObject26304, this.delegate.executeUpdate(arg0, arg1));
      } catch (SQLException var4) {
         return this.postForExecuteUpdate(methodObject26304, (Integer)this.onErrorForAll(methodObject26304, var4));
      }
   }

   public int[] executeBatch() throws SQLException {
      try {
         super.preForExecuteBatch(methodObject26300, this, zeroLengthObjectArray);
         return (int[])this.postForAll(methodObject26300, (Object)this.delegate.executeBatch());
      } catch (SQLException var2) {
         return (int[])this.postForAll(methodObject26300, this.onErrorForAll(methodObject26300, var2));
      }
   }

   public int getResultSetType() throws SQLException {
      try {
         super.preForAll(methodObject26321, this, zeroLengthObjectArray);
         return (Integer)this.postForAll(methodObject26321, this.delegate.getResultSetType());
      } catch (SQLException var2) {
         return (Integer)this.postForAll(methodObject26321, this.onErrorForAll(methodObject26321, var2));
      }
   }

   public void setEscapeProcessing(boolean arg0) throws SQLException {
      try {
         super.preForAll(methodObject26326, this, arg0);
         this.delegate.setEscapeProcessing(arg0);
      } catch (SQLException var3) {
         this.onErrorVoidForAll(methodObject26326, var3);
      }
   }

   public int getResultSetHoldability() throws SQLException {
      try {
         super.preForAll(methodObject26310, this, zeroLengthObjectArray);
         return (Integer)this.postForAll(methodObject26310, this.delegate.getResultSetHoldability());
      } catch (SQLException var2) {
         return (Integer)this.postForAll(methodObject26310, this.onErrorForAll(methodObject26310, var2));
      }
   }

   public int getQueryTimeout() throws SQLException {
      try {
         super.preForAll(methodObject26319, this, zeroLengthObjectArray);
         return (Integer)this.postForAll(methodObject26319, this.delegate.getQueryTimeout());
      } catch (SQLException var2) {
         return (Integer)this.postForAll(methodObject26319, this.onErrorForAll(methodObject26319, var2));
      }
   }

   public void setClob(int arg0, Clob arg1) throws SQLException {
      try {
         super.preForAll(methodObject26280, this, arg0, arg1);
         this.delegate.setClob(arg0, arg1 instanceof _Proxy_ ? (Clob)((_Proxy_)arg1)._getDelegate_() : arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject26280, var4);
      }
   }

   public boolean execute(String arg0, int arg1) throws SQLException {
      try {
         super.preForExecute(methodObject26295, this, arg0, arg1);
         return this.postForExecute(methodObject26295, this.delegate.execute(arg0, arg1));
      } catch (SQLException var4) {
         return this.postForExecute(methodObject26295, this.onErrorForExecute(methodObject26295, var4));
      }
   }

   public void setNClob(int arg0, Reader arg1) throws SQLException {
      try {
         super.preForAll(methodObject26285, this, arg0, arg1);
         this.delegate.setNClob(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject26285, var4);
      }
   }

   public void setURL(int arg0, URL arg1) throws SQLException {
      try {
         super.preForAll(methodObject26247, this, arg0, arg1);
         this.delegate.setURL(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject26247, var4);
      }
   }

   public void setBigDecimal(int arg0, BigDecimal arg1) throws SQLException {
      try {
         super.preForAll(methodObject26276, this, arg0, arg1);
         this.delegate.setBigDecimal(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject26276, var4);
      }
   }

   public void clearWarnings() throws SQLException {
      try {
         super.preForAll(methodObject26309, this, zeroLengthObjectArray);
         this.delegate.clearWarnings();
      } catch (SQLException var2) {
         this.onErrorVoidForAll(methodObject26309, var2);
      }
   }

   public void setNull(int arg0, int arg1, String arg2) throws SQLException {
      try {
         super.preForAll(methodObject26288, this, arg0, arg1, arg2);
         this.delegate.setNull(arg0, arg1, arg2);
      } catch (SQLException var5) {
         this.onErrorVoidForAll(methodObject26288, var5);
      }
   }

   public void setClob(int arg0, Reader arg1) throws SQLException {
      try {
         super.preForAll(methodObject26282, this, arg0, arg1);
         this.delegate.setClob(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject26282, var4);
      }
   }

   public ResultSet executeQuery() throws SQLException {
      try {
         super.preForAll(methodObject26266, this, zeroLengthObjectArray);
         return this.postForExecuteQuery(methodObject26266, (ResultSet)this.proxyFactory.proxyForCreateCache((Object)this.delegate.executeQuery(), this, this.proxyCache, methodObject26266));
      } catch (SQLException var2) {
         return this.postForExecuteQuery(methodObject26266, (ResultSet)this.onErrorForAll(methodObject26266, var2));
      }
   }

   public ResultSetMetaData getMetaData() throws SQLException {
      try {
         super.preForAll(methodObject26267, this, zeroLengthObjectArray);
         return (ResultSetMetaData)this.postForAll(methodObject26267, this.proxyFactory.proxyForCreate((Object)this.delegate.getMetaData(), this, this.proxyCache, methodObject26267));
      } catch (SQLException var2) {
         return (ResultSetMetaData)this.postForAll(methodObject26267, this.onErrorForAll(methodObject26267, var2));
      }
   }

   public boolean isClosed() throws SQLException {
      try {
         super.preForAll(methodObject26305, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject26305, this.delegate.isClosed());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject26305, this.onErrorForAll(methodObject26305, var2));
      }
   }

   public void setPoolable(boolean arg0) throws SQLException {
      try {
         super.preForAll(methodObject26329, this, arg0);
         this.delegate.setPoolable(arg0);
      } catch (SQLException var3) {
         this.onErrorVoidForAll(methodObject26329, var3);
      }
   }

   public SQLWarning getWarnings() throws SQLException {
      try {
         super.preForAll(methodObject26308, this, zeroLengthObjectArray);
         return (SQLWarning)this.postForAll(methodObject26308, (Object)this.delegate.getWarnings());
      } catch (SQLException var2) {
         return (SQLWarning)this.postForAll(methodObject26308, this.onErrorForAll(methodObject26308, var2));
      }
   }

   public Connection getConnection() throws SQLException {
      try {
         super.preForAll(methodObject26307, this, zeroLengthObjectArray);
         return (Connection)this.postForAll(methodObject26307, (Object)super.getConnection());
      } catch (SQLException var2) {
         return (Connection)this.postForAll(methodObject26307, this.onErrorForAll(methodObject26307, var2));
      }
   }

   public void setCharacterStream(int arg0, Reader arg1) throws SQLException {
      try {
         super.preForSetStreams(methodObject26258, this, arg0, arg1);
         this.delegate.setCharacterStream(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject26258, var4);
      }
   }

   public ResultSet getGeneratedKeys() throws SQLException {
      try {
         super.preForAll(methodObject26314, this, zeroLengthObjectArray);
         return (ResultSet)this.postForAll(methodObject26314, this.proxyFactory.proxyForCache((Object)this.delegate.getGeneratedKeys(), this, this.proxyCache, methodObject26314));
      } catch (SQLException var2) {
         return (ResultSet)this.postForAll(methodObject26314, this.onErrorForAll(methodObject26314, var2));
      }
   }

   public void setMaxRows(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject26328, this, arg0);
         this.delegate.setMaxRows(arg0);
      } catch (SQLException var3) {
         this.onErrorVoidForAll(methodObject26328, var3);
      }
   }

   public void setClob(int arg0, Reader arg1, long arg2) throws SQLException {
      try {
         super.preForAll(methodObject26281, this, arg0, arg1, arg2);
         this.delegate.setClob(arg0, arg1, arg2);
      } catch (SQLException var6) {
         this.onErrorVoidForAll(methodObject26281, var6);
      }
   }

   public boolean execute(String arg0, String[] arg1) throws SQLException {
      try {
         super.preForExecute(methodObject26297, this, arg0, arg1);
         return this.postForExecute(methodObject26297, this.delegate.execute(arg0, arg1));
      } catch (SQLException var4) {
         return this.postForExecute(methodObject26297, this.onErrorForExecute(methodObject26297, var4));
      }
   }

   public void closeOnCompletion() throws SQLException {
      try {
         super.preForAll(methodObject26313, this, zeroLengthObjectArray);
         this.delegate.closeOnCompletion();
      } catch (SQLException var2) {
         this.onErrorVoidForAll(methodObject26313, var2);
      }
   }

   public void close() throws SQLException {
      try {
         super.preForAll(methodObject26293, this, zeroLengthObjectArray);
         Method var10001 = methodObject26293;
         this.delegate.close();
         this.postForClose(var10001);
      } catch (SQLException var2) {
         this.onErrorVoidForClose(methodObject26293, var2);
      }
   }

   public int getFetchDirection() throws SQLException {
      try {
         super.preForAll(methodObject26331, this, zeroLengthObjectArray);
         return (Integer)this.postForAll(methodObject26331, this.delegate.getFetchDirection());
      } catch (SQLException var2) {
         return (Integer)this.postForAll(methodObject26331, this.onErrorForAll(methodObject26331, var2));
      }
   }

   public void setBlob(int arg0, Blob arg1) throws SQLException {
      try {
         super.preForAll(methodObject26277, this, arg0, arg1);
         this.delegate.setBlob(arg0, arg1 instanceof _Proxy_ ? (Blob)((_Proxy_)arg1)._getDelegate_() : arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject26277, var4);
      }
   }

   public void setBlob(int arg0, InputStream arg1, long arg2) throws SQLException {
      try {
         super.preForAll(methodObject26278, this, arg0, arg1, arg2);
         this.delegate.setBlob(arg0, arg1, arg2);
      } catch (SQLException var6) {
         this.onErrorVoidForAll(methodObject26278, var6);
      }
   }

   public void setCharacterStream(int arg0, Reader arg1, long arg2) throws SQLException {
      try {
         super.preForSetStreams(methodObject26257, this, arg0, arg1, arg2);
         this.delegate.setCharacterStream(arg0, arg1, arg2);
      } catch (SQLException var6) {
         this.onErrorVoidForAll(methodObject26257, var6);
      }
   }

   public void setTimestamp(int arg0, Timestamp arg1, Calendar arg2) throws SQLException {
      try {
         super.preForAll(methodObject26246, this, arg0, arg1, arg2);
         this.delegate.setTimestamp(arg0, arg1, arg2);
      } catch (SQLException var5) {
         this.onErrorVoidForAll(methodObject26246, var5);
      }
   }

   public void setBoolean(int arg0, boolean arg1) throws SQLException {
      try {
         super.preForAll(methodObject26238, this, arg0, arg1);
         this.delegate.setBoolean(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject26238, var4);
      }
   }

   public void setBinaryStream(int arg0, InputStream arg1, long arg2) throws SQLException {
      try {
         super.preForSetStreams(methodObject26254, this, arg0, arg1, arg2);
         this.delegate.setBinaryStream(arg0, arg1, arg2);
      } catch (SQLException var6) {
         this.onErrorVoidForAll(methodObject26254, var6);
      }
   }

   public void setShort(int arg0, short arg1) throws SQLException {
      try {
         super.preForAll(methodObject26244, this, arg0, arg1);
         this.delegate.setShort(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject26244, var4);
      }
   }

   public void clearBatch() throws SQLException {
      try {
         super.preForAll(methodObject26312, this, zeroLengthObjectArray);
         this.delegate.clearBatch();
      } catch (SQLException var2) {
         this.onErrorVoidForAll(methodObject26312, var2);
      }
   }

   public boolean getMoreResults(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject26318, this, arg0);
         return (Boolean)this.postForAll(methodObject26318, this.delegate.getMoreResults(arg0));
      } catch (SQLException var3) {
         return (Boolean)this.postForAll(methodObject26318, this.onErrorForAll(methodObject26318, var3));
      }
   }

   public void setArray(int arg0, Array arg1) throws SQLException {
      try {
         super.preForAll(methodObject26291, this, arg0, arg1);
         this.delegate.setArray(arg0, arg1 instanceof _Proxy_ ? (Array)((_Proxy_)arg1)._getDelegate_() : arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject26291, var4);
      }
   }

   public void setNClob(int arg0, Reader arg1, long arg2) throws SQLException {
      try {
         super.preForAll(methodObject26284, this, arg0, arg1, arg2);
         this.delegate.setNClob(arg0, arg1, arg2);
      } catch (SQLException var6) {
         this.onErrorVoidForAll(methodObject26284, var6);
      }
   }

   public void setAsciiStream(int arg0, InputStream arg1, int arg2) throws SQLException {
      try {
         super.preForSetStreams(methodObject26250, this, arg0, arg1, arg2);
         this.delegate.setAsciiStream(arg0, arg1, arg2);
      } catch (SQLException var5) {
         this.onErrorVoidForAll(methodObject26250, var5);
      }
   }

   public int executeUpdate() throws SQLException {
      try {
         super.preForExecuteUpdate(methodObject26249, this, zeroLengthObjectArray);
         return this.postForExecuteUpdate(methodObject26249, this.delegate.executeUpdate());
      } catch (SQLException var2) {
         return this.postForExecuteUpdate(methodObject26249, (Integer)this.onErrorForAll(methodObject26249, var2));
      }
   }

   public void setNCharacterStream(int arg0, Reader arg1) throws SQLException {
      try {
         super.preForSetStreams(methodObject26260, this, arg0, arg1);
         this.delegate.setNCharacterStream(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject26260, var4);
      }
   }

   public void setTime(int arg0, Time arg1) throws SQLException {
      try {
         super.preForAll(methodObject26269, this, arg0, arg1);
         this.delegate.setTime(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject26269, var4);
      }
   }

   public void setLong(int arg0, long arg1) throws SQLException {
      try {
         super.preForAll(methodObject26243, this, arg0, arg1);
         this.delegate.setLong(arg0, arg1);
      } catch (SQLException var5) {
         this.onErrorVoidForAll(methodObject26243, var5);
      }
   }

   public void setBlob(int arg0, InputStream arg1) throws SQLException {
      try {
         super.preForAll(methodObject26279, this, arg0, arg1);
         this.delegate.setBlob(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject26279, var4);
      }
   }

   public void setDate(int arg0, Date arg1, Calendar arg2) throws SQLException {
      try {
         super.preForAll(methodObject26272, this, arg0, arg1, arg2);
         this.delegate.setDate(arg0, arg1, arg2);
      } catch (SQLException var5) {
         this.onErrorVoidForAll(methodObject26272, var5);
      }
   }

   public void setFetchDirection(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject26333, this, arg0);
         this.delegate.setFetchDirection(arg0);
      } catch (SQLException var3) {
         this.onErrorVoidForAll(methodObject26333, var3);
      }
   }

   public void setFetchSize(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject26334, this, arg0);
         this.delegate.setFetchSize(arg0);
      } catch (SQLException var3) {
         this.onErrorVoidForAll(methodObject26334, var3);
      }
   }

   public int getFetchSize() throws SQLException {
      try {
         super.preForAll(methodObject26332, this, zeroLengthObjectArray);
         return (Integer)this.postForAll(methodObject26332, this.delegate.getFetchSize());
      } catch (SQLException var2) {
         return (Integer)this.postForAll(methodObject26332, this.onErrorForAll(methodObject26332, var2));
      }
   }

   public void setCharacterStream(int arg0, Reader arg1, int arg2) throws SQLException {
      try {
         super.preForSetStreams(methodObject26256, this, arg0, arg1, arg2);
         this.delegate.setCharacterStream(arg0, arg1, arg2);
      } catch (SQLException var5) {
         this.onErrorVoidForAll(methodObject26256, var5);
      }
   }

   public void setCursorName(String arg0) throws SQLException {
      try {
         super.preForAll(methodObject26325, this, arg0);
         this.delegate.setCursorName(arg0);
      } catch (SQLException var3) {
         this.onErrorVoidForAll(methodObject26325, var3);
      }
   }

   public void setBytes(int arg0, byte[] arg1) throws SQLException {
      try {
         super.preForAll(methodObject26262, this, arg0, arg1);
         this.delegate.setBytes(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject26262, var4);
      }
   }

   public void setAsciiStream(int arg0, InputStream arg1) throws SQLException {
      try {
         super.preForSetStreams(methodObject26252, this, arg0, arg1);
         this.delegate.setAsciiStream(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject26252, var4);
      }
   }

   public void setBinaryStream(int arg0, InputStream arg1, int arg2) throws SQLException {
      try {
         super.preForSetStreams(methodObject26253, this, arg0, arg1, arg2);
         this.delegate.setBinaryStream(arg0, arg1, arg2);
      } catch (SQLException var5) {
         this.onErrorVoidForAll(methodObject26253, var5);
      }
   }

   public void clearParameters() throws SQLException {
      try {
         super.preForAll(methodObject26275, this, zeroLengthObjectArray);
         this.delegate.clearParameters();
      } catch (SQLException var2) {
         this.onErrorVoidForAll(methodObject26275, var2);
      }
   }

   public boolean isWrapperFor(Class arg0) throws SQLException {
      try {
         super.preForAll(methodObject26336, this, arg0);
         return (Boolean)this.postForAll(methodObject26336, this.delegate.isWrapperFor(arg0));
      } catch (SQLException var3) {
         return (Boolean)this.postForAll(methodObject26336, this.onErrorForAll(methodObject26336, var3));
      }
   }

   public Object unwrap(Class arg0) throws SQLException {
      try {
         super.preForAll(methodObject26335, this, arg0);
         return this.postForAll(methodObject26335, super.unwrap(arg0));
      } catch (SQLException var3) {
         return this.postForAll(methodObject26335, this.onErrorForAll(methodObject26335, var3));
      }
   }

   public void addBatch(String arg0) throws SQLException {
      try {
         super.preForAll(methodObject26311, this, arg0);
         this.delegate.addBatch(arg0);
      } catch (SQLException var3) {
         this.onErrorVoidForAll(methodObject26311, var3);
      }
   }

   public int getResultSetConcurrency() throws SQLException {
      try {
         super.preForAll(methodObject26320, this, zeroLengthObjectArray);
         return (Integer)this.postForAll(methodObject26320, this.delegate.getResultSetConcurrency());
      } catch (SQLException var2) {
         return (Integer)this.postForAll(methodObject26320, this.onErrorForAll(methodObject26320, var2));
      }
   }

   public boolean execute() throws SQLException {
      try {
         super.preForExecute(methodObject26248, this, zeroLengthObjectArray);
         return this.postForExecute(methodObject26248, this.delegate.execute());
      } catch (SQLException var2) {
         return this.postForExecute(methodObject26248, this.onErrorForExecute(methodObject26248, var2));
      }
   }

   public ParameterMetaData getParameterMetaData() throws SQLException {
      try {
         super.preForAll(methodObject26268, this, zeroLengthObjectArray);
         return (ParameterMetaData)this.postForAll(methodObject26268, this.proxyFactory.proxyForCreate((Object)this.delegate.getParameterMetaData(), this, this.proxyCache, methodObject26268));
      } catch (SQLException var2) {
         return (ParameterMetaData)this.postForAll(methodObject26268, this.onErrorForAll(methodObject26268, var2));
      }
   }

   public void setObject(int arg0, Object arg1, int arg2) throws SQLException {
      try {
         super.preForSetObjects(methodObject26263, this, arg0, arg1, arg2);
         this.delegate.setObject(arg0, arg1 instanceof _Proxy_ ? (Object)((_Proxy_)arg1)._getDelegate_() : arg1, arg2);
      } catch (SQLException var5) {
         this.onErrorVoidForAll(methodObject26263, var5);
      }
   }

   public void setObject(int arg0, Object arg1) throws SQLException {
      try {
         super.preForSetObjects(methodObject26264, this, arg0, arg1);
         this.delegate.setObject(arg0, arg1 instanceof _Proxy_ ? (Object)((_Proxy_)arg1)._getDelegate_() : arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject26264, var4);
      }
   }

   public void setAsciiStream(int arg0, InputStream arg1, long arg2) throws SQLException {
      try {
         super.preForSetStreams(methodObject26251, this, arg0, arg1, arg2);
         this.delegate.setAsciiStream(arg0, arg1, arg2);
      } catch (SQLException var6) {
         this.onErrorVoidForAll(methodObject26251, var6);
      }
   }

   public int getMaxFieldSize() throws SQLException {
      try {
         super.preForAll(methodObject26315, this, zeroLengthObjectArray);
         return (Integer)this.postForAll(methodObject26315, this.delegate.getMaxFieldSize());
      } catch (SQLException var2) {
         return (Integer)this.postForAll(methodObject26315, this.onErrorForAll(methodObject26315, var2));
      }
   }

   public void setRef(int arg0, Ref arg1) throws SQLException {
      try {
         super.preForAll(methodObject26292, this, arg0, arg1);
         this.delegate.setRef(arg0, arg1 instanceof _Proxy_ ? (Ref)((_Proxy_)arg1)._getDelegate_() : arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject26292, var4);
      }
   }

   public void cancel() throws SQLException {
      try {
         super.preForAll(methodObject26298, this, zeroLengthObjectArray);
         this.delegate.cancel();
      } catch (SQLException var2) {
         this.onErrorVoidForAll(methodObject26298, var2);
      }
   }

   public void setInt(int arg0, int arg1) throws SQLException {
      try {
         super.preForAll(methodObject26242, this, arg0, arg1);
         this.delegate.setInt(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject26242, var4);
      }
   }

   public ResultSet getResultSet() throws SQLException {
      try {
         super.preForAll(methodObject26299, this, zeroLengthObjectArray);
         return (ResultSet)this.postForAll(methodObject26299, this.proxyFactory.proxyForCache((Object)this.delegate.getResultSet(), this, this.proxyCache, methodObject26299));
      } catch (SQLException var2) {
         return (ResultSet)this.postForAll(methodObject26299, this.onErrorForAll(methodObject26299, var2));
      }
   }

   public void setQueryTimeout(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject26330, this, arg0);
         this.delegate.setQueryTimeout(arg0);
      } catch (SQLException var3) {
         this.onErrorVoidForAll(methodObject26330, var3);
      }
   }

   public PreparedStatement _getDelegate_() {
      return this.delegate;
   }

   public Object getDelegate() {
      return this.delegate;
   }

   public void setDelegate(Object delegate) {
      this.proxyFactory.updateDelegate(this, this.delegate, delegate);
      this.delegate = (PreparedStatement)delegate;
   }

   public Object getCreator() {
      return this.creator;
   }

   static {
      try {
         methodObject26294 = Statement.class.getDeclaredMethod("execute", String.class);
         methodObject26259 = PreparedStatement.class.getDeclaredMethod("setNCharacterStream", Integer.TYPE, Reader.class, Long.TYPE);
         methodObject26289 = PreparedStatement.class.getDeclaredMethod("setRowId", Integer.TYPE, RowId.class);
         methodObject26283 = PreparedStatement.class.getDeclaredMethod("setNClob", Integer.TYPE, NClob.class);
         methodObject26303 = Statement.class.getDeclaredMethod("executeUpdate", String.class, int[].class);
         methodObject26239 = PreparedStatement.class.getDeclaredMethod("setByte", Integer.TYPE, Byte.TYPE);
         methodObject26240 = PreparedStatement.class.getDeclaredMethod("setDouble", Integer.TYPE, Double.TYPE);
         methodObject26296 = Statement.class.getDeclaredMethod("execute", String.class, int[].class);
         methodObject26287 = PreparedStatement.class.getDeclaredMethod("setNull", Integer.TYPE, Integer.TYPE);
         methodObject26301 = Statement.class.getDeclaredMethod("executeUpdate", String.class);
         methodObject26271 = PreparedStatement.class.getDeclaredMethod("setDate", Integer.TYPE, Date.class);
         methodObject26245 = PreparedStatement.class.getDeclaredMethod("setTimestamp", Integer.TYPE, Timestamp.class);
         methodObject26324 = Statement.class.getDeclaredMethod("isPoolable");
         methodObject26286 = PreparedStatement.class.getDeclaredMethod("setNString", Integer.TYPE, String.class);
         methodObject26317 = Statement.class.getDeclaredMethod("getMoreResults");
         methodObject26302 = Statement.class.getDeclaredMethod("executeUpdate", String.class, Integer.TYPE);
         methodObject26261 = PreparedStatement.class.getDeclaredMethod("setUnicodeStream", Integer.TYPE, InputStream.class, Integer.TYPE);
         methodObject26270 = PreparedStatement.class.getDeclaredMethod("setTime", Integer.TYPE, Time.class, Calendar.class);
         methodObject26322 = Statement.class.getDeclaredMethod("getUpdateCount");
         methodObject26265 = PreparedStatement.class.getDeclaredMethod("setObject", Integer.TYPE, Object.class, Integer.TYPE, Integer.TYPE);
         methodObject26323 = Statement.class.getDeclaredMethod("isCloseOnCompletion");
         methodObject26327 = Statement.class.getDeclaredMethod("setMaxFieldSize", Integer.TYPE);
         methodObject26306 = Statement.class.getDeclaredMethod("executeQuery", String.class);
         methodObject26241 = PreparedStatement.class.getDeclaredMethod("setFloat", Integer.TYPE, Float.TYPE);
         methodObject26290 = PreparedStatement.class.getDeclaredMethod("setSQLXML", Integer.TYPE, SQLXML.class);
         methodObject26255 = PreparedStatement.class.getDeclaredMethod("setBinaryStream", Integer.TYPE, InputStream.class);
         methodObject26316 = Statement.class.getDeclaredMethod("getMaxRows");
         methodObject26274 = PreparedStatement.class.getDeclaredMethod("addBatch");
         methodObject26273 = PreparedStatement.class.getDeclaredMethod("setString", Integer.TYPE, String.class);
         methodObject26304 = Statement.class.getDeclaredMethod("executeUpdate", String.class, String[].class);
         methodObject26300 = Statement.class.getDeclaredMethod("executeBatch");
         methodObject26321 = Statement.class.getDeclaredMethod("getResultSetType");
         methodObject26326 = Statement.class.getDeclaredMethod("setEscapeProcessing", Boolean.TYPE);
         methodObject26310 = Statement.class.getDeclaredMethod("getResultSetHoldability");
         methodObject26319 = Statement.class.getDeclaredMethod("getQueryTimeout");
         methodObject26280 = PreparedStatement.class.getDeclaredMethod("setClob", Integer.TYPE, Clob.class);
         methodObject26295 = Statement.class.getDeclaredMethod("execute", String.class, Integer.TYPE);
         methodObject26285 = PreparedStatement.class.getDeclaredMethod("setNClob", Integer.TYPE, Reader.class);
         methodObject26247 = PreparedStatement.class.getDeclaredMethod("setURL", Integer.TYPE, URL.class);
         methodObject26276 = PreparedStatement.class.getDeclaredMethod("setBigDecimal", Integer.TYPE, BigDecimal.class);
         methodObject26309 = Statement.class.getDeclaredMethod("clearWarnings");
         methodObject26288 = PreparedStatement.class.getDeclaredMethod("setNull", Integer.TYPE, Integer.TYPE, String.class);
         methodObject26282 = PreparedStatement.class.getDeclaredMethod("setClob", Integer.TYPE, Reader.class);
         methodObject26266 = PreparedStatement.class.getDeclaredMethod("executeQuery");
         methodObject26267 = PreparedStatement.class.getDeclaredMethod("getMetaData");
         methodObject26305 = Statement.class.getDeclaredMethod("isClosed");
         methodObject26329 = Statement.class.getDeclaredMethod("setPoolable", Boolean.TYPE);
         methodObject26308 = Statement.class.getDeclaredMethod("getWarnings");
         methodObject26307 = Statement.class.getDeclaredMethod("getConnection");
         methodObject26258 = PreparedStatement.class.getDeclaredMethod("setCharacterStream", Integer.TYPE, Reader.class);
         methodObject26314 = Statement.class.getDeclaredMethod("getGeneratedKeys");
         methodObject26328 = Statement.class.getDeclaredMethod("setMaxRows", Integer.TYPE);
         methodObject26281 = PreparedStatement.class.getDeclaredMethod("setClob", Integer.TYPE, Reader.class, Long.TYPE);
         methodObject26297 = Statement.class.getDeclaredMethod("execute", String.class, String[].class);
         methodObject26313 = Statement.class.getDeclaredMethod("closeOnCompletion");
         methodObject26293 = Statement.class.getDeclaredMethod("close");
         methodObject26331 = Statement.class.getDeclaredMethod("getFetchDirection");
         methodObject26277 = PreparedStatement.class.getDeclaredMethod("setBlob", Integer.TYPE, Blob.class);
         methodObject26278 = PreparedStatement.class.getDeclaredMethod("setBlob", Integer.TYPE, InputStream.class, Long.TYPE);
         methodObject26257 = PreparedStatement.class.getDeclaredMethod("setCharacterStream", Integer.TYPE, Reader.class, Long.TYPE);
         methodObject26246 = PreparedStatement.class.getDeclaredMethod("setTimestamp", Integer.TYPE, Timestamp.class, Calendar.class);
         methodObject26238 = PreparedStatement.class.getDeclaredMethod("setBoolean", Integer.TYPE, Boolean.TYPE);
         methodObject26254 = PreparedStatement.class.getDeclaredMethod("setBinaryStream", Integer.TYPE, InputStream.class, Long.TYPE);
         methodObject26244 = PreparedStatement.class.getDeclaredMethod("setShort", Integer.TYPE, Short.TYPE);
         methodObject26312 = Statement.class.getDeclaredMethod("clearBatch");
         methodObject26318 = Statement.class.getDeclaredMethod("getMoreResults", Integer.TYPE);
         methodObject26291 = PreparedStatement.class.getDeclaredMethod("setArray", Integer.TYPE, Array.class);
         methodObject26284 = PreparedStatement.class.getDeclaredMethod("setNClob", Integer.TYPE, Reader.class, Long.TYPE);
         methodObject26250 = PreparedStatement.class.getDeclaredMethod("setAsciiStream", Integer.TYPE, InputStream.class, Integer.TYPE);
         methodObject26249 = PreparedStatement.class.getDeclaredMethod("executeUpdate");
         methodObject26260 = PreparedStatement.class.getDeclaredMethod("setNCharacterStream", Integer.TYPE, Reader.class);
         methodObject26269 = PreparedStatement.class.getDeclaredMethod("setTime", Integer.TYPE, Time.class);
         methodObject26243 = PreparedStatement.class.getDeclaredMethod("setLong", Integer.TYPE, Long.TYPE);
         methodObject26279 = PreparedStatement.class.getDeclaredMethod("setBlob", Integer.TYPE, InputStream.class);
         methodObject26272 = PreparedStatement.class.getDeclaredMethod("setDate", Integer.TYPE, Date.class, Calendar.class);
         methodObject26333 = Statement.class.getDeclaredMethod("setFetchDirection", Integer.TYPE);
         methodObject26334 = Statement.class.getDeclaredMethod("setFetchSize", Integer.TYPE);
         methodObject26332 = Statement.class.getDeclaredMethod("getFetchSize");
         methodObject26256 = PreparedStatement.class.getDeclaredMethod("setCharacterStream", Integer.TYPE, Reader.class, Integer.TYPE);
         methodObject26325 = Statement.class.getDeclaredMethod("setCursorName", String.class);
         methodObject26262 = PreparedStatement.class.getDeclaredMethod("setBytes", Integer.TYPE, byte[].class);
         methodObject26252 = PreparedStatement.class.getDeclaredMethod("setAsciiStream", Integer.TYPE, InputStream.class);
         methodObject26253 = PreparedStatement.class.getDeclaredMethod("setBinaryStream", Integer.TYPE, InputStream.class, Integer.TYPE);
         methodObject26275 = PreparedStatement.class.getDeclaredMethod("clearParameters");
         methodObject26336 = Wrapper.class.getDeclaredMethod("isWrapperFor", Class.class);
         methodObject26335 = Wrapper.class.getDeclaredMethod("unwrap", Class.class);
         methodObject26311 = Statement.class.getDeclaredMethod("addBatch", String.class);
         methodObject26320 = Statement.class.getDeclaredMethod("getResultSetConcurrency");
         methodObject26248 = PreparedStatement.class.getDeclaredMethod("execute");
         methodObject26268 = PreparedStatement.class.getDeclaredMethod("getParameterMetaData");
         methodObject26263 = PreparedStatement.class.getDeclaredMethod("setObject", Integer.TYPE, Object.class, Integer.TYPE);
         methodObject26264 = PreparedStatement.class.getDeclaredMethod("setObject", Integer.TYPE, Object.class);
         methodObject26251 = PreparedStatement.class.getDeclaredMethod("setAsciiStream", Integer.TYPE, InputStream.class, Long.TYPE);
         methodObject26315 = Statement.class.getDeclaredMethod("getMaxFieldSize");
         methodObject26292 = PreparedStatement.class.getDeclaredMethod("setRef", Integer.TYPE, Ref.class);
         methodObject26298 = Statement.class.getDeclaredMethod("cancel");
         methodObject26242 = PreparedStatement.class.getDeclaredMethod("setInt", Integer.TYPE, Integer.TYPE);
         methodObject26299 = Statement.class.getDeclaredMethod("getResultSet");
         methodObject26330 = Statement.class.getDeclaredMethod("setQueryTimeout", Integer.TYPE);
      } catch (Throwable var1) {
         throw new RuntimeException(var1);
      }
   }

   public oracle$1jdbc$1replay$1driver$1NonTxnReplayableStatement$2java$1sql$1PreparedStatement$$$Proxy(PreparedStatement var1, Object var2, ProxyFactory var3, Map var4) {
      this.delegate = var1;
      this.creator = var2;
      this.proxyFactory = var3;
      this.proxyCache = var4;
   }
}
