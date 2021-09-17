package oracle.jdbc.proxy;

import java.io.InputStream;
import java.io.Reader;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.net.URL;
import java.sql.Array;
import java.sql.Blob;
import java.sql.CallableStatement;
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

public abstract class oracle$1jdbc$1replay$1driver$1NonTxnReplayableStatement$2java$1sql$1CallableStatement$$$Proxy extends NonTxnReplayableStatement implements CallableStatement, _Proxy_ {
   private CallableStatement delegate;
   private final Object creator;
   private final ProxyFactory proxyFactory;
   private final Map proxyCache;
   private static Object[] zeroLengthObjectArray = new Object[0];
   private static Method methodObject26038;
   private static Method methodObject26100;
   private static Method methodObject26195;
   private static Method methodObject26125;
   private static Method methodObject26044;
   private static Method methodObject26190;
   private static Method methodObject26084;
   private static Method methodObject26204;
   private static Method methodObject26140;
   private static Method methodObject26141;
   private static Method methodObject26126;
   private static Method methodObject26064;
   private static Method methodObject26188;
   private static Method methodObject26040;
   private static Method methodObject26202;
   private static Method methodObject26225;
   private static Method methodObject26146;
   private static Method methodObject26187;
   private static Method methodObject26068;
   private static Method methodObject26162;
   private static Method methodObject26047;
   private static Method methodObject26171;
   private static Method methodObject26223;
   private static Method methodObject26166;
   private static Method methodObject26224;
   private static Method methodObject26228;
   private static Method methodObject26063;
   private static Method methodObject26156;
   private static Method methodObject26201;
   private static Method methodObject26106;
   private static Method methodObject26222;
   private static Method methodObject26080;
   private static Method methodObject26062;
   private static Method methodObject26227;
   private static Method methodObject26211;
   private static Method methodObject26181;
   private static Method methodObject26114;
   private static Method methodObject26098;
   private static Method methodObject26079;
   private static Method methodObject26210;
   private static Method methodObject26042;
   private static Method methodObject26026;
   private static Method methodObject26058;
   private static Method methodObject26168;
   private static Method methodObject26230;
   private static Method methodObject26206;
   private static Method methodObject26093;
   private static Method methodObject26075;
   private static Method methodObject26123;
   private static Method methodObject26131;
   private static Method methodObject26037;
   private static Method methodObject26085;
   private static Method methodObject26159;
   private static Method methodObject26215;
   private static Method methodObject26065;
   private static Method methodObject26182;
   private static Method methodObject26031;
   private static Method methodObject26198;
   private static Method methodObject26214;
   private static Method methodObject26133;
   private static Method methodObject26232;
   private static Method methodObject26108;
   private static Method methodObject26091;
   private static Method methodObject26051;
   private static Method methodObject26178;
   private static Method methodObject26179;
   private static Method methodObject26132;
   private static Method methodObject26158;
   private static Method methodObject26139;
   private static Method methodObject26130;
   private static Method methodObject26033;
   private static Method methodObject26060;
   private static Method methodObject26072;
   private static Method methodObject26099;
   private static Method methodObject26180;
   private static Method methodObject26135;
   private static Method methodObject26101;
   private static Method methodObject26046;
   private static Method methodObject26069;
   private static Method methodObject26082;
   private static Method methodObject26073;
   private static Method methodObject26121;
   private static Method methodObject26153;
   private static Method methodObject26236;
   private static Method methodObject26212;
   private static Method methodObject26221;
   private static Method methodObject26111;
   private static Method methodObject26134;
   private static Method methodObject26164;
   private static Method methodObject26165;
   private static Method methodObject26039;
   private static Method methodObject26193;
   private static Method methodObject26052;
   private static Method methodObject26199;
   private static Method methodObject26231;
   private static Method methodObject26078;
   private static Method methodObject26200;
   private static Method methodObject26083;
   private static Method methodObject26116;
   private static Method methodObject26160;
   private static Method methodObject26184;
   private static Method methodObject26197;
   private static Method methodObject26127;
   private static Method methodObject26097;
   private static Method methodObject26113;
   private static Method methodObject26028;
   private static Method methodObject26172;
   private static Method methodObject26218;
   private static Method methodObject26057;
   private static Method methodObject26203;
   private static Method methodObject26076;
   private static Method methodObject26032;
   private static Method methodObject26128;
   private static Method methodObject26129;
   private static Method methodObject26207;
   private static Method methodObject26142;
   private static Method methodObject26107;
   private static Method methodObject26191;
   private static Method methodObject26217;
   private static Method methodObject26174;
   private static Method methodObject26175;
   private static Method methodObject26036;
   private static Method methodObject26059;
   private static Method methodObject26061;
   private static Method methodObject26205;
   private static Method methodObject26118;
   private static Method methodObject26124;
   private static Method methodObject26066;
   private static Method methodObject26220;
   private static Method methodObject26196;
   private static Method methodObject26148;
   private static Method methodObject26186;
   private static Method methodObject26086;
   private static Method methodObject26105;
   private static Method methodObject26177;
   private static Method methodObject26189;
   private static Method methodObject26027;
   private static Method methodObject26183;
   private static Method methodObject26067;
   private static Method methodObject26122;
   private static Method methodObject26167;
   private static Method methodObject26071;
   private static Method methodObject26050;
   private static Method methodObject26049;
   private static Method methodObject26102;
   private static Method methodObject26120;
   private static Method methodObject26209;
   private static Method methodObject26104;
   private static Method methodObject26034;
   private static Method methodObject26208;
   private static Method methodObject26229;
   private static Method methodObject26041;
   private static Method methodObject26138;
   private static Method methodObject26087;
   private static Method methodObject26194;
   private static Method methodObject26045;
   private static Method methodObject26030;
   private static Method methodObject26136;
   private static Method methodObject26070;
   private static Method methodObject26147;
   private static Method methodObject26155;
   private static Method methodObject26089;
   private static Method methodObject26081;
   private static Method methodObject26056;
   private static Method methodObject26035;
   private static Method methodObject26096;
   private static Method methodObject26048;
   private static Method methodObject26145;
   private static Method methodObject26219;
   private static Method methodObject26213;
   private static Method methodObject26137;
   private static Method methodObject26192;
   private static Method methodObject26185;
   private static Method methodObject26117;
   private static Method methodObject26150;
   private static Method methodObject26151;
   private static Method methodObject26088;
   private static Method methodObject26161;
   private static Method methodObject26170;
   private static Method methodObject26144;
   private static Method methodObject26173;
   private static Method methodObject26090;
   private static Method methodObject26043;
   private static Method methodObject26053;
   private static Method methodObject26235;
   private static Method methodObject26234;
   private static Method methodObject26233;
   private static Method methodObject26110;
   private static Method methodObject26157;
   private static Method methodObject26226;
   private static Method methodObject26054;
   private static Method methodObject26163;
   private static Method methodObject26095;
   private static Method methodObject26154;
   private static Method methodObject26077;
   private static Method methodObject26176;
   private static Method methodObject26237;
   private static Method methodObject26029;
   private static Method methodObject26115;
   private static Method methodObject26149;
   private static Method methodObject26094;
   private static Method methodObject26169;
   private static Method methodObject26103;
   private static Method methodObject26092;
   private static Method methodObject26119;
   private static Method methodObject26109;
   private static Method methodObject26074;
   private static Method methodObject26152;
   private static Method methodObject26216;
   private static Method methodObject26112;
   private static Method methodObject26055;
   private static Method methodObject26143;

   public int getInt(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject26038, this, arg0);
         return (Integer)this.postForAll(methodObject26038, this.delegate.getInt(arg0));
      } catch (SQLException var3) {
         return (Integer)this.postForAll(methodObject26038, this.onErrorForAll(methodObject26038, var3));
      }
   }

   public Time getTime(String arg0, Calendar arg1) throws SQLException {
      try {
         super.preForAll(methodObject26100, this, arg0, arg1);
         return (Time)this.postForAll(methodObject26100, (Object)this.delegate.getTime(arg0, arg1));
      } catch (SQLException var4) {
         return (Time)this.postForAll(methodObject26100, this.onErrorForAll(methodObject26100, var4));
      }
   }

   public boolean execute(String arg0) throws SQLException {
      try {
         super.preForExecute(methodObject26195, this, arg0);
         return this.postForExecute(methodObject26195, this.delegate.execute(arg0));
      } catch (SQLException var3) {
         return this.postForExecute(methodObject26195, this.onErrorForExecute(methodObject26195, var3));
      }
   }

   public void setNull(String arg0, int arg1, String arg2) throws SQLException {
      try {
         super.preForAll(methodObject26125, this, arg0, arg1, arg2);
         this.delegate.setNull(arg0, arg1, arg2);
      } catch (SQLException var5) {
         this.onErrorVoidForAll(methodObject26125, var5);
      }
   }

   public double getDouble(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject26044, this, arg0);
         return (Double)this.postForAll(methodObject26044, this.delegate.getDouble(arg0));
      } catch (SQLException var3) {
         return (Double)this.postForAll(methodObject26044, this.onErrorForAll(methodObject26044, var3));
      }
   }

   public void setRowId(int arg0, RowId arg1) throws SQLException {
      try {
         super.preForAll(methodObject26190, this, arg0, arg1);
         this.delegate.setRowId(arg0, arg1 instanceof _Proxy_ ? (RowId)((_Proxy_)arg1)._getDelegate_() : arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject26190, var4);
      }
   }

   public void setObject(String arg0, Object arg1) throws SQLException {
      try {
         super.preForSetObjects(methodObject26084, this, arg0, arg1);
         this.delegate.setObject(arg0, arg1 instanceof _Proxy_ ? (Object)((_Proxy_)arg1)._getDelegate_() : arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject26084, var4);
      }
   }

   public int executeUpdate(String arg0, int[] arg1) throws SQLException {
      try {
         super.preForExecuteUpdate(methodObject26204, this, arg0, arg1);
         return this.postForExecuteUpdate(methodObject26204, this.delegate.executeUpdate(arg0, arg1));
      } catch (SQLException var4) {
         return this.postForExecuteUpdate(methodObject26204, (Integer)this.onErrorForAll(methodObject26204, var4));
      }
   }

   public void setByte(int arg0, byte arg1) throws SQLException {
      try {
         super.preForAll(methodObject26140, this, arg0, arg1);
         this.delegate.setByte(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject26140, var4);
      }
   }

   public void setDouble(int arg0, double arg1) throws SQLException {
      try {
         super.preForAll(methodObject26141, this, arg0, arg1);
         this.delegate.setDouble(arg0, arg1);
      } catch (SQLException var5) {
         this.onErrorVoidForAll(methodObject26141, var5);
      }
   }

   public void setRowId(String arg0, RowId arg1) throws SQLException {
      try {
         super.preForAll(methodObject26126, this, arg0, arg1);
         this.delegate.setRowId(arg0, arg1 instanceof _Proxy_ ? (RowId)((_Proxy_)arg1)._getDelegate_() : arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject26126, var4);
      }
   }

   public String getString(String arg0) throws SQLException {
      try {
         super.preForAll(methodObject26064, this, arg0);
         return (String)this.postForAll(methodObject26064, (Object)this.delegate.getString(arg0));
      } catch (SQLException var3) {
         return (String)this.postForAll(methodObject26064, this.onErrorForAll(methodObject26064, var3));
      }
   }

   public void setNull(int arg0, int arg1) throws SQLException {
      try {
         super.preForAll(methodObject26188, this, arg0, arg1);
         this.delegate.setNull(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject26188, var4);
      }
   }

   public long getLong(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject26040, this, arg0);
         return (Long)this.postForAll(methodObject26040, this.delegate.getLong(arg0));
      } catch (SQLException var3) {
         return (Long)this.postForAll(methodObject26040, this.onErrorForAll(methodObject26040, var3));
      }
   }

   public int executeUpdate(String arg0) throws SQLException {
      try {
         super.preForExecuteUpdate(methodObject26202, this, arg0);
         return this.postForExecuteUpdate(methodObject26202, this.delegate.executeUpdate(arg0));
      } catch (SQLException var3) {
         return this.postForExecuteUpdate(methodObject26202, (Integer)this.onErrorForAll(methodObject26202, var3));
      }
   }

   public boolean isPoolable() throws SQLException {
      try {
         super.preForAll(methodObject26225, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject26225, this.delegate.isPoolable());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject26225, this.onErrorForAll(methodObject26225, var2));
      }
   }

   public void setTimestamp(int arg0, Timestamp arg1) throws SQLException {
      try {
         super.preForAll(methodObject26146, this, arg0, arg1);
         this.delegate.setTimestamp(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject26146, var4);
      }
   }

   public void setNString(int arg0, String arg1) throws SQLException {
      try {
         super.preForAll(methodObject26187, this, arg0, arg1);
         this.delegate.setNString(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject26187, var4);
      }
   }

   public Date getDate(String arg0) throws SQLException {
      try {
         super.preForAll(methodObject26068, this, arg0);
         return (Date)this.postForAll(methodObject26068, (Object)this.delegate.getDate(arg0));
      } catch (SQLException var3) {
         return (Date)this.postForAll(methodObject26068, this.onErrorForAll(methodObject26068, var3));
      }
   }

   public void setUnicodeStream(int arg0, InputStream arg1, int arg2) throws SQLException {
      try {
         super.preForAll(methodObject26162, this, arg0, arg1, arg2);
         this.delegate.setUnicodeStream(arg0, arg1, arg2);
      } catch (SQLException var5) {
         this.onErrorVoidForAll(methodObject26162, var5);
      }
   }

   public byte[] getBytes(String arg0) throws SQLException {
      try {
         super.preForAll(methodObject26047, this, arg0);
         return (byte[])this.postForAll(methodObject26047, (Object)this.delegate.getBytes(arg0));
      } catch (SQLException var3) {
         return (byte[])this.postForAll(methodObject26047, this.onErrorForAll(methodObject26047, var3));
      }
   }

   public void setTime(int arg0, Time arg1, Calendar arg2) throws SQLException {
      try {
         super.preForAll(methodObject26171, this, arg0, arg1, arg2);
         this.delegate.setTime(arg0, arg1, arg2);
      } catch (SQLException var5) {
         this.onErrorVoidForAll(methodObject26171, var5);
      }
   }

   public int getUpdateCount() throws SQLException {
      try {
         super.preForAll(methodObject26223, this, zeroLengthObjectArray);
         return (Integer)this.postForAll(methodObject26223, this.delegate.getUpdateCount());
      } catch (SQLException var2) {
         return (Integer)this.postForAll(methodObject26223, this.onErrorForAll(methodObject26223, var2));
      }
   }

   public void setObject(int arg0, Object arg1, int arg2, int arg3) throws SQLException {
      try {
         super.preForSetObjects(methodObject26166, this, arg0, arg1, arg2, arg3);
         this.delegate.setObject(arg0, arg1 instanceof _Proxy_ ? (Object)((_Proxy_)arg1)._getDelegate_() : arg1, arg2, arg3);
      } catch (SQLException var6) {
         this.onErrorVoidForAll(methodObject26166, var6);
      }
   }

   public boolean isCloseOnCompletion() throws SQLException {
      try {
         super.preForAll(methodObject26224, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject26224, this.delegate.isCloseOnCompletion());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject26224, this.onErrorForAll(methodObject26224, var2));
      }
   }

   public void setMaxFieldSize(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject26228, this, arg0);
         this.delegate.setMaxFieldSize(arg0);
      } catch (SQLException var3) {
         this.onErrorVoidForAll(methodObject26228, var3);
      }
   }

   public String getString(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject26063, this, arg0);
         return (String)this.postForAll(methodObject26063, (Object)this.delegate.getString(arg0));
      } catch (SQLException var3) {
         return (String)this.postForAll(methodObject26063, this.onErrorForAll(methodObject26063, var3));
      }
   }

   public void setBinaryStream(int arg0, InputStream arg1) throws SQLException {
      try {
         super.preForSetStreams(methodObject26156, this, arg0, arg1);
         this.delegate.setBinaryStream(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject26156, var4);
      }
   }

   public int[] executeBatch() throws SQLException {
      try {
         super.preForExecuteBatch(methodObject26201, this, zeroLengthObjectArray);
         return (int[])this.postForAll(methodObject26201, (Object)this.delegate.executeBatch());
      } catch (SQLException var2) {
         return (int[])this.postForAll(methodObject26201, this.onErrorForAll(methodObject26201, var2));
      }
   }

   public boolean wasNull() throws SQLException {
      try {
         super.preForAll(methodObject26106, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject26106, this.delegate.wasNull());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject26106, this.onErrorForAll(methodObject26106, var2));
      }
   }

   public int getResultSetType() throws SQLException {
      try {
         super.preForAll(methodObject26222, this, zeroLengthObjectArray);
         return (Integer)this.postForAll(methodObject26222, this.delegate.getResultSetType());
      } catch (SQLException var2) {
         return (Integer)this.postForAll(methodObject26222, this.onErrorForAll(methodObject26222, var2));
      }
   }

   public void setNCharacterStream(String arg0, Reader arg1) throws SQLException {
      try {
         super.preForSetStreams(methodObject26080, this, arg0, arg1);
         this.delegate.setNCharacterStream(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject26080, var4);
      }
   }

   public Ref getRef(String arg0) throws SQLException {
      try {
         super.preForAll(methodObject26062, this, arg0);
         return (Ref)this.postForAll(methodObject26062, this.proxyFactory.proxyForCreate((Object)this.delegate.getRef(arg0), this, this.proxyCache, methodObject26062));
      } catch (SQLException var3) {
         return (Ref)this.postForAll(methodObject26062, this.onErrorForAll(methodObject26062, var3));
      }
   }

   public void setEscapeProcessing(boolean arg0) throws SQLException {
      try {
         super.preForAll(methodObject26227, this, arg0);
         this.delegate.setEscapeProcessing(arg0);
      } catch (SQLException var3) {
         this.onErrorVoidForAll(methodObject26227, var3);
      }
   }

   public int getResultSetHoldability() throws SQLException {
      try {
         super.preForAll(methodObject26211, this, zeroLengthObjectArray);
         return (Integer)this.postForAll(methodObject26211, this.delegate.getResultSetHoldability());
      } catch (SQLException var2) {
         return (Integer)this.postForAll(methodObject26211, this.onErrorForAll(methodObject26211, var2));
      }
   }

   public void setClob(int arg0, Clob arg1) throws SQLException {
      try {
         super.preForAll(methodObject26181, this, arg0, arg1);
         this.delegate.setClob(arg0, arg1 instanceof _Proxy_ ? (Clob)((_Proxy_)arg1)._getDelegate_() : arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject26181, var4);
      }
   }

   public void setBlob(String arg0, InputStream arg1, long arg2) throws SQLException {
      try {
         super.preForAll(methodObject26114, this, arg0, arg1, arg2);
         this.delegate.setBlob(arg0, arg1, arg2);
      } catch (SQLException var6) {
         this.onErrorVoidForAll(methodObject26114, var6);
      }
   }

   public Time getTime(int arg0, Calendar arg1) throws SQLException {
      try {
         super.preForAll(methodObject26098, this, arg0, arg1);
         return (Time)this.postForAll(methodObject26098, (Object)this.delegate.getTime(arg0, arg1));
      } catch (SQLException var4) {
         return (Time)this.postForAll(methodObject26098, this.onErrorForAll(methodObject26098, var4));
      }
   }

   public void setNCharacterStream(String arg0, Reader arg1, long arg2) throws SQLException {
      try {
         super.preForSetStreams(methodObject26079, this, arg0, arg1, arg2);
         this.delegate.setNCharacterStream(arg0, arg1, arg2);
      } catch (SQLException var6) {
         this.onErrorVoidForAll(methodObject26079, var6);
      }
   }

   public void clearWarnings() throws SQLException {
      try {
         super.preForAll(methodObject26210, this, zeroLengthObjectArray);
         this.delegate.clearWarnings();
      } catch (SQLException var2) {
         this.onErrorVoidForAll(methodObject26210, var2);
      }
   }

   public float getFloat(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject26042, this, arg0);
         return (Float)this.postForAll(methodObject26042, this.delegate.getFloat(arg0));
      } catch (SQLException var3) {
         return (Float)this.postForAll(methodObject26042, this.onErrorForAll(methodObject26042, var3));
      }
   }

   public Object getObject(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject26026, this, arg0);
         return this.postForAll(methodObject26026, this.proxyFactory.proxyForCache(this.delegate.getObject(arg0), this, this.proxyCache, methodObject26026));
      } catch (SQLException var3) {
         return this.postForAll(methodObject26026, this.onErrorForAll(methodObject26026, var3));
      }
   }

   public void setShort(String arg0, short arg1) throws SQLException {
      try {
         super.preForAll(methodObject26058, this, arg0, arg1);
         this.delegate.setShort(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject26058, var4);
      }
   }

   public ResultSetMetaData getMetaData() throws SQLException {
      try {
         super.preForAll(methodObject26168, this, zeroLengthObjectArray);
         return (ResultSetMetaData)this.postForAll(methodObject26168, this.proxyFactory.proxyForCreate((Object)this.delegate.getMetaData(), this, this.proxyCache, methodObject26168));
      } catch (SQLException var2) {
         return (ResultSetMetaData)this.postForAll(methodObject26168, this.onErrorForAll(methodObject26168, var2));
      }
   }

   public void setPoolable(boolean arg0) throws SQLException {
      try {
         super.preForAll(methodObject26230, this, arg0);
         this.delegate.setPoolable(arg0);
      } catch (SQLException var3) {
         this.onErrorVoidForAll(methodObject26230, var3);
      }
   }

   public boolean isClosed() throws SQLException {
      try {
         super.preForAll(methodObject26206, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject26206, this.delegate.isClosed());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject26206, this.onErrorForAll(methodObject26206, var2));
      }
   }

   public SQLXML getSQLXML(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject26093, this, arg0);
         return (SQLXML)this.postForAll(methodObject26093, this.proxyFactory.proxyForCreate((Object)this.delegate.getSQLXML(arg0), this, this.proxyCache, methodObject26093));
      } catch (SQLException var3) {
         return (SQLXML)this.postForAll(methodObject26093, this.onErrorForAll(methodObject26093, var3));
      }
   }

   public void setBinaryStream(String arg0, InputStream arg1) throws SQLException {
      try {
         super.preForSetStreams(methodObject26075, this, arg0, arg1);
         this.delegate.setBinaryStream(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject26075, var4);
      }
   }

   public void setNString(String arg0, String arg1) throws SQLException {
      try {
         super.preForAll(methodObject26123, this, arg0, arg1);
         this.delegate.setNString(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject26123, var4);
      }
   }

   public Reader getNCharacterStream(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject26131, this, arg0);
         return (Reader)this.postForAll(methodObject26131, (Object)this.delegate.getNCharacterStream(arg0));
      } catch (SQLException var3) {
         return (Reader)this.postForAll(methodObject26131, this.onErrorForAll(methodObject26131, var3));
      }
   }

   public short getShort(String arg0) throws SQLException {
      try {
         super.preForAll(methodObject26037, this, arg0);
         return (Short)this.postForAll(methodObject26037, this.delegate.getShort(arg0));
      } catch (SQLException var3) {
         return (Short)this.postForAll(methodObject26037, this.onErrorForAll(methodObject26037, var3));
      }
   }

   public Blob getBlob(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject26085, this, arg0);
         return (Blob)this.postForAll(methodObject26085, this.proxyFactory.proxyForCreate((Object)this.delegate.getBlob(arg0), this, this.proxyCache, methodObject26085));
      } catch (SQLException var3) {
         return (Blob)this.postForAll(methodObject26085, this.onErrorForAll(methodObject26085, var3));
      }
   }

   public void setCharacterStream(int arg0, Reader arg1) throws SQLException {
      try {
         super.preForSetStreams(methodObject26159, this, arg0, arg1);
         this.delegate.setCharacterStream(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject26159, var4);
      }
   }

   public ResultSet getGeneratedKeys() throws SQLException {
      try {
         super.preForAll(methodObject26215, this, zeroLengthObjectArray);
         return (ResultSet)this.postForAll(methodObject26215, this.proxyFactory.proxyForCache((Object)this.delegate.getGeneratedKeys(), this, this.proxyCache, methodObject26215));
      } catch (SQLException var2) {
         return (ResultSet)this.postForAll(methodObject26215, this.onErrorForAll(methodObject26215, var2));
      }
   }

   public void setURL(String arg0, URL arg1) throws SQLException {
      try {
         super.preForAll(methodObject26065, this, arg0, arg1);
         this.delegate.setURL(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject26065, var4);
      }
   }

   public void setClob(int arg0, Reader arg1, long arg2) throws SQLException {
      try {
         super.preForAll(methodObject26182, this, arg0, arg1, arg2);
         this.delegate.setClob(arg0, arg1, arg2);
      } catch (SQLException var6) {
         this.onErrorVoidForAll(methodObject26182, var6);
      }
   }

   public Object getObject(String arg0, Class arg1) throws SQLException {
      try {
         super.preForAll(methodObject26031, this, arg0, arg1);
         return this.postForAll(methodObject26031, this.proxyFactory.proxyForCache(this.delegate.getObject(arg0, arg1), this, this.proxyCache, methodObject26031));
      } catch (SQLException var4) {
         return this.postForAll(methodObject26031, this.onErrorForAll(methodObject26031, var4));
      }
   }

   public boolean execute(String arg0, String[] arg1) throws SQLException {
      try {
         super.preForExecute(methodObject26198, this, arg0, arg1);
         return this.postForExecute(methodObject26198, this.delegate.execute(arg0, arg1));
      } catch (SQLException var4) {
         return this.postForExecute(methodObject26198, this.onErrorForExecute(methodObject26198, var4));
      }
   }

   public void closeOnCompletion() throws SQLException {
      try {
         super.preForAll(methodObject26214, this, zeroLengthObjectArray);
         this.delegate.closeOnCompletion();
      } catch (SQLException var2) {
         this.onErrorVoidForAll(methodObject26214, var2);
      }
   }

   public String getNString(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject26133, this, arg0);
         return (String)this.postForAll(methodObject26133, (Object)this.delegate.getNString(arg0));
      } catch (SQLException var3) {
         return (String)this.postForAll(methodObject26133, this.onErrorForAll(methodObject26133, var3));
      }
   }

   public int getFetchDirection() throws SQLException {
      try {
         super.preForAll(methodObject26232, this, zeroLengthObjectArray);
         return (Integer)this.postForAll(methodObject26232, this.delegate.getFetchDirection());
      } catch (SQLException var2) {
         return (Integer)this.postForAll(methodObject26232, this.onErrorForAll(methodObject26232, var2));
      }
   }

   public void registerOutParameter(int arg0, int arg1, int arg2) throws SQLException {
      try {
         super.preForAll(methodObject26108, this, arg0, arg1, arg2);
         this.delegate.registerOutParameter(arg0, arg1, arg2);
      } catch (SQLException var5) {
         this.onErrorVoidForAll(methodObject26108, var5);
      }
   }

   public RowId getRowId(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject26091, this, arg0);
         return (RowId)this.postForAll(methodObject26091, this.proxyFactory.proxyForCreate((Object)this.delegate.getRowId(arg0), this, this.proxyCache, methodObject26091));
      } catch (SQLException var3) {
         return (RowId)this.postForAll(methodObject26091, this.onErrorForAll(methodObject26091, var3));
      }
   }

   public URL getURL(String arg0) throws SQLException {
      try {
         super.preForAll(methodObject26051, this, arg0);
         return (URL)this.postForAll(methodObject26051, (Object)this.delegate.getURL(arg0));
      } catch (SQLException var3) {
         return (URL)this.postForAll(methodObject26051, this.onErrorForAll(methodObject26051, var3));
      }
   }

   public void setBlob(int arg0, Blob arg1) throws SQLException {
      try {
         super.preForAll(methodObject26178, this, arg0, arg1);
         this.delegate.setBlob(arg0, arg1 instanceof _Proxy_ ? (Blob)((_Proxy_)arg1)._getDelegate_() : arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject26178, var4);
      }
   }

   public void setBlob(int arg0, InputStream arg1, long arg2) throws SQLException {
      try {
         super.preForAll(methodObject26179, this, arg0, arg1, arg2);
         this.delegate.setBlob(arg0, arg1, arg2);
      } catch (SQLException var6) {
         this.onErrorVoidForAll(methodObject26179, var6);
      }
   }

   public Reader getNCharacterStream(String arg0) throws SQLException {
      try {
         super.preForAll(methodObject26132, this, arg0);
         return (Reader)this.postForAll(methodObject26132, (Object)this.delegate.getNCharacterStream(arg0));
      } catch (SQLException var3) {
         return (Reader)this.postForAll(methodObject26132, this.onErrorForAll(methodObject26132, var3));
      }
   }

   public void setCharacterStream(int arg0, Reader arg1, long arg2) throws SQLException {
      try {
         super.preForSetStreams(methodObject26158, this, arg0, arg1, arg2);
         this.delegate.setCharacterStream(arg0, arg1, arg2);
      } catch (SQLException var6) {
         this.onErrorVoidForAll(methodObject26158, var6);
      }
   }

   public void setBoolean(int arg0, boolean arg1) throws SQLException {
      try {
         super.preForAll(methodObject26139, this, arg0, arg1);
         this.delegate.setBoolean(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject26139, var4);
      }
   }

   public BigDecimal getBigDecimal(String arg0) throws SQLException {
      try {
         super.preForAll(methodObject26130, this, arg0);
         return (BigDecimal)this.postForAll(methodObject26130, (Object)this.delegate.getBigDecimal(arg0));
      } catch (SQLException var3) {
         return (BigDecimal)this.postForAll(methodObject26130, this.onErrorForAll(methodObject26130, var3));
      }
   }

   public boolean getBoolean(String arg0) throws SQLException {
      try {
         super.preForAll(methodObject26033, this, arg0);
         return (Boolean)this.postForAll(methodObject26033, this.delegate.getBoolean(arg0));
      } catch (SQLException var3) {
         return (Boolean)this.postForAll(methodObject26033, this.onErrorForAll(methodObject26033, var3));
      }
   }

   public void setTimestamp(String arg0, Timestamp arg1, Calendar arg2) throws SQLException {
      try {
         super.preForAll(methodObject26060, this, arg0, arg1, arg2);
         this.delegate.setTimestamp(arg0, arg1, arg2);
      } catch (SQLException var5) {
         this.onErrorVoidForAll(methodObject26060, var5);
      }
   }

   public void setAsciiStream(String arg0, InputStream arg1) throws SQLException {
      try {
         super.preForSetStreams(methodObject26072, this, arg0, arg1);
         this.delegate.setAsciiStream(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject26072, var4);
      }
   }

   public Time getTime(String arg0) throws SQLException {
      try {
         super.preForAll(methodObject26099, this, arg0);
         return (Time)this.postForAll(methodObject26099, (Object)this.delegate.getTime(arg0));
      } catch (SQLException var3) {
         return (Time)this.postForAll(methodObject26099, this.onErrorForAll(methodObject26099, var3));
      }
   }

   public void setBlob(int arg0, InputStream arg1) throws SQLException {
      try {
         super.preForAll(methodObject26180, this, arg0, arg1);
         this.delegate.setBlob(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject26180, var4);
      }
   }

   public Timestamp getTimestamp(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject26135, this, arg0);
         return (Timestamp)this.postForAll(methodObject26135, (Object)this.delegate.getTimestamp(arg0));
      } catch (SQLException var3) {
         return (Timestamp)this.postForAll(methodObject26135, this.onErrorForAll(methodObject26135, var3));
      }
   }

   public void setDate(String arg0, Date arg1) throws SQLException {
      try {
         super.preForAll(methodObject26101, this, arg0, arg1);
         this.delegate.setDate(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject26101, var4);
      }
   }

   public byte[] getBytes(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject26046, this, arg0);
         return (byte[])this.postForAll(methodObject26046, (Object)this.delegate.getBytes(arg0));
      } catch (SQLException var3) {
         return (byte[])this.postForAll(methodObject26046, this.onErrorForAll(methodObject26046, var3));
      }
   }

   public Date getDate(String arg0, Calendar arg1) throws SQLException {
      try {
         super.preForAll(methodObject26069, this, arg0, arg1);
         return (Date)this.postForAll(methodObject26069, (Object)this.delegate.getDate(arg0, arg1));
      } catch (SQLException var4) {
         return (Date)this.postForAll(methodObject26069, this.onErrorForAll(methodObject26069, var4));
      }
   }

   public void setObject(String arg0, Object arg1, int arg2, int arg3) throws SQLException {
      try {
         super.preForSetObjects(methodObject26082, this, arg0, arg1, arg2, arg3);
         this.delegate.setObject(arg0, arg1 instanceof _Proxy_ ? (Object)((_Proxy_)arg1)._getDelegate_() : arg1, arg2, arg3);
      } catch (SQLException var6) {
         this.onErrorVoidForAll(methodObject26082, var6);
      }
   }

   public void setBinaryStream(String arg0, InputStream arg1, int arg2) throws SQLException {
      try {
         super.preForSetStreams(methodObject26073, this, arg0, arg1, arg2);
         this.delegate.setBinaryStream(arg0, arg1, arg2);
      } catch (SQLException var5) {
         this.onErrorVoidForAll(methodObject26073, var5);
      }
   }

   public void setNClob(String arg0, Reader arg1, long arg2) throws SQLException {
      try {
         super.preForAll(methodObject26121, this, arg0, arg1, arg2);
         this.delegate.setNClob(arg0, arg1, arg2);
      } catch (SQLException var6) {
         this.onErrorVoidForAll(methodObject26121, var6);
      }
   }

   public void setAsciiStream(int arg0, InputStream arg1) throws SQLException {
      try {
         super.preForSetStreams(methodObject26153, this, arg0, arg1);
         this.delegate.setAsciiStream(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject26153, var4);
      }
   }

   public Object unwrap(Class arg0) throws SQLException {
      try {
         super.preForAll(methodObject26236, this, arg0);
         return this.postForAll(methodObject26236, super.unwrap(arg0));
      } catch (SQLException var3) {
         return this.postForAll(methodObject26236, this.onErrorForAll(methodObject26236, var3));
      }
   }

   public void addBatch(String arg0) throws SQLException {
      try {
         super.preForAll(methodObject26212, this, arg0);
         this.delegate.addBatch(arg0);
      } catch (SQLException var3) {
         this.onErrorVoidForAll(methodObject26212, var3);
      }
   }

   public int getResultSetConcurrency() throws SQLException {
      try {
         super.preForAll(methodObject26221, this, zeroLengthObjectArray);
         return (Integer)this.postForAll(methodObject26221, this.delegate.getResultSetConcurrency());
      } catch (SQLException var2) {
         return (Integer)this.postForAll(methodObject26221, this.onErrorForAll(methodObject26221, var2));
      }
   }

   public void registerOutParameter(String arg0, int arg1, int arg2) throws SQLException {
      try {
         super.preForAll(methodObject26111, this, arg0, arg1, arg2);
         this.delegate.registerOutParameter(arg0, arg1, arg2);
      } catch (SQLException var5) {
         this.onErrorVoidForAll(methodObject26111, var5);
      }
   }

   public String getNString(String arg0) throws SQLException {
      try {
         super.preForAll(methodObject26134, this, arg0);
         return (String)this.postForAll(methodObject26134, (Object)this.delegate.getNString(arg0));
      } catch (SQLException var3) {
         return (String)this.postForAll(methodObject26134, this.onErrorForAll(methodObject26134, var3));
      }
   }

   public void setObject(int arg0, Object arg1, int arg2) throws SQLException {
      try {
         super.preForSetObjects(methodObject26164, this, arg0, arg1, arg2);
         this.delegate.setObject(arg0, arg1 instanceof _Proxy_ ? (Object)((_Proxy_)arg1)._getDelegate_() : arg1, arg2);
      } catch (SQLException var5) {
         this.onErrorVoidForAll(methodObject26164, var5);
      }
   }

   public void setObject(int arg0, Object arg1) throws SQLException {
      try {
         super.preForSetObjects(methodObject26165, this, arg0, arg1);
         this.delegate.setObject(arg0, arg1 instanceof _Proxy_ ? (Object)((_Proxy_)arg1)._getDelegate_() : arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject26165, var4);
      }
   }

   public int getInt(String arg0) throws SQLException {
      try {
         super.preForAll(methodObject26039, this, arg0);
         return (Integer)this.postForAll(methodObject26039, this.delegate.getInt(arg0));
      } catch (SQLException var3) {
         return (Integer)this.postForAll(methodObject26039, this.onErrorForAll(methodObject26039, var3));
      }
   }

   public void setRef(int arg0, Ref arg1) throws SQLException {
      try {
         super.preForAll(methodObject26193, this, arg0, arg1);
         this.delegate.setRef(arg0, arg1 instanceof _Proxy_ ? (Ref)((_Proxy_)arg1)._getDelegate_() : arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject26193, var4);
      }
   }

   public void setBoolean(String arg0, boolean arg1) throws SQLException {
      try {
         super.preForAll(methodObject26052, this, arg0, arg1);
         this.delegate.setBoolean(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject26052, var4);
      }
   }

   public void cancel() throws SQLException {
      try {
         super.preForAll(methodObject26199, this, zeroLengthObjectArray);
         this.delegate.cancel();
      } catch (SQLException var2) {
         this.onErrorVoidForAll(methodObject26199, var2);
      }
   }

   public void setQueryTimeout(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject26231, this, arg0);
         this.delegate.setQueryTimeout(arg0);
      } catch (SQLException var3) {
         this.onErrorVoidForAll(methodObject26231, var3);
      }
   }

   public void setCharacterStream(String arg0, Reader arg1) throws SQLException {
      try {
         super.preForSetStreams(methodObject26078, this, arg0, arg1);
         this.delegate.setCharacterStream(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject26078, var4);
      }
   }

   public ResultSet getResultSet() throws SQLException {
      try {
         super.preForAll(methodObject26200, this, zeroLengthObjectArray);
         return (ResultSet)this.postForAll(methodObject26200, this.proxyFactory.proxyForCache((Object)this.delegate.getResultSet(), this, this.proxyCache, methodObject26200));
      } catch (SQLException var2) {
         return (ResultSet)this.postForAll(methodObject26200, this.onErrorForAll(methodObject26200, var2));
      }
   }

   public void setObject(String arg0, Object arg1, int arg2) throws SQLException {
      try {
         super.preForSetObjects(methodObject26083, this, arg0, arg1, arg2);
         this.delegate.setObject(arg0, arg1 instanceof _Proxy_ ? (Object)((_Proxy_)arg1)._getDelegate_() : arg1, arg2);
      } catch (SQLException var5) {
         this.onErrorVoidForAll(methodObject26083, var5);
      }
   }

   public void setBlob(String arg0, InputStream arg1) throws SQLException {
      try {
         super.preForAll(methodObject26116, this, arg0, arg1);
         this.delegate.setBlob(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject26116, var4);
      }
   }

   public void setNCharacterStream(int arg0, Reader arg1, long arg2) throws SQLException {
      try {
         super.preForSetStreams(methodObject26160, this, arg0, arg1, arg2);
         this.delegate.setNCharacterStream(arg0, arg1, arg2);
      } catch (SQLException var6) {
         this.onErrorVoidForAll(methodObject26160, var6);
      }
   }

   public void setNClob(int arg0, NClob arg1) throws SQLException {
      try {
         super.preForAll(methodObject26184, this, arg0, arg1);
         this.delegate.setNClob(arg0, arg1 instanceof _Proxy_ ? (NClob)((_Proxy_)arg1)._getDelegate_() : arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject26184, var4);
      }
   }

   public boolean execute(String arg0, int[] arg1) throws SQLException {
      try {
         super.preForExecute(methodObject26197, this, arg0, arg1);
         return this.postForExecute(methodObject26197, this.delegate.execute(arg0, arg1));
      } catch (SQLException var4) {
         return this.postForExecute(methodObject26197, this.onErrorForExecute(methodObject26197, var4));
      }
   }

   public void setSQLXML(String arg0, SQLXML arg1) throws SQLException {
      try {
         super.preForAll(methodObject26127, this, arg0, arg1);
         this.delegate.setSQLXML(arg0, arg1 instanceof _Proxy_ ? (SQLXML)((_Proxy_)arg1)._getDelegate_() : arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject26127, var4);
      }
   }

   public Time getTime(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject26097, this, arg0);
         return (Time)this.postForAll(methodObject26097, (Object)this.delegate.getTime(arg0));
      } catch (SQLException var3) {
         return (Time)this.postForAll(methodObject26097, this.onErrorForAll(methodObject26097, var3));
      }
   }

   public void setBigDecimal(String arg0, BigDecimal arg1) throws SQLException {
      try {
         super.preForAll(methodObject26113, this, arg0, arg1);
         this.delegate.setBigDecimal(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject26113, var4);
      }
   }

   public Object getObject(String arg0) throws SQLException {
      try {
         super.preForAll(methodObject26028, this, arg0);
         return this.postForAll(methodObject26028, this.proxyFactory.proxyForCache(this.delegate.getObject(arg0), this, this.proxyCache, methodObject26028));
      } catch (SQLException var3) {
         return this.postForAll(methodObject26028, this.onErrorForAll(methodObject26028, var3));
      }
   }

   public void setDate(int arg0, Date arg1) throws SQLException {
      try {
         super.preForAll(methodObject26172, this, arg0, arg1);
         this.delegate.setDate(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject26172, var4);
      }
   }

   public boolean getMoreResults() throws SQLException {
      try {
         super.preForAll(methodObject26218, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject26218, this.delegate.getMoreResults());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject26218, this.onErrorForAll(methodObject26218, var2));
      }
   }

   public void setLong(String arg0, long arg1) throws SQLException {
      try {
         super.preForAll(methodObject26057, this, arg0, arg1);
         this.delegate.setLong(arg0, arg1);
      } catch (SQLException var5) {
         this.onErrorVoidForAll(methodObject26057, var5);
      }
   }

   public int executeUpdate(String arg0, int arg1) throws SQLException {
      try {
         super.preForExecuteUpdate(methodObject26203, this, arg0, arg1);
         return this.postForExecuteUpdate(methodObject26203, this.delegate.executeUpdate(arg0, arg1));
      } catch (SQLException var4) {
         return this.postForExecuteUpdate(methodObject26203, (Integer)this.onErrorForAll(methodObject26203, var4));
      }
   }

   public void setCharacterStream(String arg0, Reader arg1, int arg2) throws SQLException {
      try {
         super.preForSetStreams(methodObject26076, this, arg0, arg1, arg2);
         this.delegate.setCharacterStream(arg0, arg1, arg2);
      } catch (SQLException var5) {
         this.onErrorVoidForAll(methodObject26076, var5);
      }
   }

   public boolean getBoolean(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject26032, this, arg0);
         return (Boolean)this.postForAll(methodObject26032, this.delegate.getBoolean(arg0));
      } catch (SQLException var3) {
         return (Boolean)this.postForAll(methodObject26032, this.onErrorForAll(methodObject26032, var3));
      }
   }

   public BigDecimal getBigDecimal(int arg0, int arg1) throws SQLException {
      try {
         super.preForAll(methodObject26128, this, arg0, arg1);
         return (BigDecimal)this.postForAll(methodObject26128, (Object)this.delegate.getBigDecimal(arg0, arg1));
      } catch (SQLException var4) {
         return (BigDecimal)this.postForAll(methodObject26128, this.onErrorForAll(methodObject26128, var4));
      }
   }

   public BigDecimal getBigDecimal(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject26129, this, arg0);
         return (BigDecimal)this.postForAll(methodObject26129, (Object)this.delegate.getBigDecimal(arg0));
      } catch (SQLException var3) {
         return (BigDecimal)this.postForAll(methodObject26129, this.onErrorForAll(methodObject26129, var3));
      }
   }

   public ResultSet executeQuery(String arg0) throws SQLException {
      try {
         super.preForAll(methodObject26207, this, arg0);
         return this.postForExecuteQuery(methodObject26207, (ResultSet)this.proxyFactory.proxyForCreateCache((Object)this.delegate.executeQuery(arg0), this, this.proxyCache, methodObject26207));
      } catch (SQLException var3) {
         return this.postForExecuteQuery(methodObject26207, (ResultSet)this.onErrorForAll(methodObject26207, var3));
      }
   }

   public void setFloat(int arg0, float arg1) throws SQLException {
      try {
         super.preForAll(methodObject26142, this, arg0, arg1);
         this.delegate.setFloat(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject26142, var4);
      }
   }

   public void registerOutParameter(int arg0, int arg1) throws SQLException {
      try {
         super.preForAll(methodObject26107, this, arg0, arg1);
         this.delegate.registerOutParameter(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject26107, var4);
      }
   }

   public void setSQLXML(int arg0, SQLXML arg1) throws SQLException {
      try {
         super.preForAll(methodObject26191, this, arg0, arg1);
         this.delegate.setSQLXML(arg0, arg1 instanceof _Proxy_ ? (SQLXML)((_Proxy_)arg1)._getDelegate_() : arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject26191, var4);
      }
   }

   public int getMaxRows() throws SQLException {
      try {
         super.preForAll(methodObject26217, this, zeroLengthObjectArray);
         return (Integer)this.postForAll(methodObject26217, this.delegate.getMaxRows());
      } catch (SQLException var2) {
         return (Integer)this.postForAll(methodObject26217, this.onErrorForAll(methodObject26217, var2));
      }
   }

   public void setString(int arg0, String arg1) throws SQLException {
      try {
         super.preForAll(methodObject26174, this, arg0, arg1);
         this.delegate.setString(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject26174, var4);
      }
   }

   public void addBatch() throws SQLException {
      try {
         super.preForAll(methodObject26175, this, zeroLengthObjectArray);
         this.delegate.addBatch();
      } catch (SQLException var2) {
         this.onErrorVoidForAll(methodObject26175, var2);
      }
   }

   public short getShort(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject26036, this, arg0);
         return (Short)this.postForAll(methodObject26036, this.delegate.getShort(arg0));
      } catch (SQLException var3) {
         return (Short)this.postForAll(methodObject26036, this.onErrorForAll(methodObject26036, var3));
      }
   }

   public void setTimestamp(String arg0, Timestamp arg1) throws SQLException {
      try {
         super.preForAll(methodObject26059, this, arg0, arg1);
         this.delegate.setTimestamp(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject26059, var4);
      }
   }

   public Ref getRef(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject26061, this, arg0);
         return (Ref)this.postForAll(methodObject26061, this.proxyFactory.proxyForCreate((Object)this.delegate.getRef(arg0), this, this.proxyCache, methodObject26061));
      } catch (SQLException var3) {
         return (Ref)this.postForAll(methodObject26061, this.onErrorForAll(methodObject26061, var3));
      }
   }

   public int executeUpdate(String arg0, String[] arg1) throws SQLException {
      try {
         super.preForExecuteUpdate(methodObject26205, this, arg0, arg1);
         return this.postForExecuteUpdate(methodObject26205, this.delegate.executeUpdate(arg0, arg1));
      } catch (SQLException var4) {
         return this.postForExecuteUpdate(methodObject26205, (Integer)this.onErrorForAll(methodObject26205, var4));
      }
   }

   public void setClob(String arg0, Clob arg1) throws SQLException {
      try {
         super.preForAll(methodObject26118, this, arg0, arg1);
         this.delegate.setClob(arg0, arg1 instanceof _Proxy_ ? (Clob)((_Proxy_)arg1)._getDelegate_() : arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject26118, var4);
      }
   }

   public void setNull(String arg0, int arg1) throws SQLException {
      try {
         super.preForAll(methodObject26124, this, arg0, arg1);
         this.delegate.setNull(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject26124, var4);
      }
   }

   public Date getDate(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject26066, this, arg0);
         return (Date)this.postForAll(methodObject26066, (Object)this.delegate.getDate(arg0));
      } catch (SQLException var3) {
         return (Date)this.postForAll(methodObject26066, this.onErrorForAll(methodObject26066, var3));
      }
   }

   public int getQueryTimeout() throws SQLException {
      try {
         super.preForAll(methodObject26220, this, zeroLengthObjectArray);
         return (Integer)this.postForAll(methodObject26220, this.delegate.getQueryTimeout());
      } catch (SQLException var2) {
         return (Integer)this.postForAll(methodObject26220, this.onErrorForAll(methodObject26220, var2));
      }
   }

   public boolean execute(String arg0, int arg1) throws SQLException {
      try {
         super.preForExecute(methodObject26196, this, arg0, arg1);
         return this.postForExecute(methodObject26196, this.delegate.execute(arg0, arg1));
      } catch (SQLException var4) {
         return this.postForExecute(methodObject26196, this.onErrorForExecute(methodObject26196, var4));
      }
   }

   public void setURL(int arg0, URL arg1) throws SQLException {
      try {
         super.preForAll(methodObject26148, this, arg0, arg1);
         this.delegate.setURL(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject26148, var4);
      }
   }

   public void setNClob(int arg0, Reader arg1) throws SQLException {
      try {
         super.preForAll(methodObject26186, this, arg0, arg1);
         this.delegate.setNClob(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject26186, var4);
      }
   }

   public Blob getBlob(String arg0) throws SQLException {
      try {
         super.preForAll(methodObject26086, this, arg0);
         return (Blob)this.postForAll(methodObject26086, this.proxyFactory.proxyForCreate((Object)this.delegate.getBlob(arg0), this, this.proxyCache, methodObject26086));
      } catch (SQLException var3) {
         return (Blob)this.postForAll(methodObject26086, this.onErrorForAll(methodObject26086, var3));
      }
   }

   public void setString(String arg0, String arg1) throws SQLException {
      try {
         super.preForAll(methodObject26105, this, arg0, arg1);
         this.delegate.setString(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject26105, var4);
      }
   }

   public void setBigDecimal(int arg0, BigDecimal arg1) throws SQLException {
      try {
         super.preForAll(methodObject26177, this, arg0, arg1);
         this.delegate.setBigDecimal(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject26177, var4);
      }
   }

   public void setNull(int arg0, int arg1, String arg2) throws SQLException {
      try {
         super.preForAll(methodObject26189, this, arg0, arg1, arg2);
         this.delegate.setNull(arg0, arg1, arg2);
      } catch (SQLException var5) {
         this.onErrorVoidForAll(methodObject26189, var5);
      }
   }

   public Object getObject(int arg0, Map arg1) throws SQLException {
      try {
         super.preForAll(methodObject26027, this, arg0, arg1);
         return this.postForAll(methodObject26027, this.proxyFactory.proxyForCache(this.delegate.getObject(arg0, arg1), this, this.proxyCache, methodObject26027));
      } catch (SQLException var4) {
         return this.postForAll(methodObject26027, this.onErrorForAll(methodObject26027, var4));
      }
   }

   public void setClob(int arg0, Reader arg1) throws SQLException {
      try {
         super.preForAll(methodObject26183, this, arg0, arg1);
         this.delegate.setClob(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject26183, var4);
      }
   }

   public Date getDate(int arg0, Calendar arg1) throws SQLException {
      try {
         super.preForAll(methodObject26067, this, arg0, arg1);
         return (Date)this.postForAll(methodObject26067, (Object)this.delegate.getDate(arg0, arg1));
      } catch (SQLException var4) {
         return (Date)this.postForAll(methodObject26067, this.onErrorForAll(methodObject26067, var4));
      }
   }

   public void setNClob(String arg0, Reader arg1) throws SQLException {
      try {
         super.preForAll(methodObject26122, this, arg0, arg1);
         this.delegate.setNClob(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject26122, var4);
      }
   }

   public ResultSet executeQuery() throws SQLException {
      try {
         super.preForAll(methodObject26167, this, zeroLengthObjectArray);
         return this.postForExecuteQuery(methodObject26167, (ResultSet)this.proxyFactory.proxyForCreateCache((Object)this.delegate.executeQuery(), this, this.proxyCache, methodObject26167));
      } catch (SQLException var2) {
         return this.postForExecuteQuery(methodObject26167, (ResultSet)this.onErrorForAll(methodObject26167, var2));
      }
   }

   public void setAsciiStream(String arg0, InputStream arg1, long arg2) throws SQLException {
      try {
         super.preForSetStreams(methodObject26071, this, arg0, arg1, arg2);
         this.delegate.setAsciiStream(arg0, arg1, arg2);
      } catch (SQLException var6) {
         this.onErrorVoidForAll(methodObject26071, var6);
      }
   }

   public URL getURL(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject26050, this, arg0);
         return (URL)this.postForAll(methodObject26050, (Object)this.delegate.getURL(arg0));
      } catch (SQLException var3) {
         return (URL)this.postForAll(methodObject26050, this.onErrorForAll(methodObject26050, var3));
      }
   }

   public Array getArray(String arg0) throws SQLException {
      try {
         super.preForAll(methodObject26049, this, arg0);
         return (Array)this.postForAll(methodObject26049, this.proxyFactory.proxyForCreate((Object)this.delegate.getArray(arg0), this, this.proxyCache, methodObject26049));
      } catch (SQLException var3) {
         return (Array)this.postForAll(methodObject26049, this.onErrorForAll(methodObject26049, var3));
      }
   }

   public void setDate(String arg0, Date arg1, Calendar arg2) throws SQLException {
      try {
         super.preForAll(methodObject26102, this, arg0, arg1, arg2);
         this.delegate.setDate(arg0, arg1, arg2);
      } catch (SQLException var5) {
         this.onErrorVoidForAll(methodObject26102, var5);
      }
   }

   public void setNClob(String arg0, NClob arg1) throws SQLException {
      try {
         super.preForAll(methodObject26120, this, arg0, arg1);
         this.delegate.setNClob(arg0, arg1 instanceof _Proxy_ ? (NClob)((_Proxy_)arg1)._getDelegate_() : arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject26120, var4);
      }
   }

   public SQLWarning getWarnings() throws SQLException {
      try {
         super.preForAll(methodObject26209, this, zeroLengthObjectArray);
         return (SQLWarning)this.postForAll(methodObject26209, (Object)this.delegate.getWarnings());
      } catch (SQLException var2) {
         return (SQLWarning)this.postForAll(methodObject26209, this.onErrorForAll(methodObject26209, var2));
      }
   }

   public Reader getCharacterStream(String arg0) throws SQLException {
      try {
         super.preForAll(methodObject26104, this, arg0);
         return (Reader)this.postForAll(methodObject26104, (Object)this.delegate.getCharacterStream(arg0));
      } catch (SQLException var3) {
         return (Reader)this.postForAll(methodObject26104, this.onErrorForAll(methodObject26104, var3));
      }
   }

   public byte getByte(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject26034, this, arg0);
         return (Byte)this.postForAll(methodObject26034, this.delegate.getByte(arg0));
      } catch (SQLException var3) {
         return (Byte)this.postForAll(methodObject26034, this.onErrorForAll(methodObject26034, var3));
      }
   }

   public Connection getConnection() throws SQLException {
      try {
         super.preForAll(methodObject26208, this, zeroLengthObjectArray);
         return (Connection)this.postForAll(methodObject26208, (Object)super.getConnection());
      } catch (SQLException var2) {
         return (Connection)this.postForAll(methodObject26208, this.onErrorForAll(methodObject26208, var2));
      }
   }

   public void setMaxRows(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject26229, this, arg0);
         this.delegate.setMaxRows(arg0);
      } catch (SQLException var3) {
         this.onErrorVoidForAll(methodObject26229, var3);
      }
   }

   public long getLong(String arg0) throws SQLException {
      try {
         super.preForAll(methodObject26041, this, arg0);
         return (Long)this.postForAll(methodObject26041, this.delegate.getLong(arg0));
      } catch (SQLException var3) {
         return (Long)this.postForAll(methodObject26041, this.onErrorForAll(methodObject26041, var3));
      }
   }

   public Timestamp getTimestamp(String arg0, Calendar arg1) throws SQLException {
      try {
         super.preForAll(methodObject26138, this, arg0, arg1);
         return (Timestamp)this.postForAll(methodObject26138, (Object)this.delegate.getTimestamp(arg0, arg1));
      } catch (SQLException var4) {
         return (Timestamp)this.postForAll(methodObject26138, this.onErrorForAll(methodObject26138, var4));
      }
   }

   public Clob getClob(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject26087, this, arg0);
         return (Clob)this.postForAll(methodObject26087, this.proxyFactory.proxyForCreate((Object)this.delegate.getClob(arg0), this, this.proxyCache, methodObject26087));
      } catch (SQLException var3) {
         return (Clob)this.postForAll(methodObject26087, this.onErrorForAll(methodObject26087, var3));
      }
   }

   public void close() throws SQLException {
      try {
         super.preForAll(methodObject26194, this, zeroLengthObjectArray);
         Method var10001 = methodObject26194;
         this.delegate.close();
         this.postForClose(var10001);
      } catch (SQLException var2) {
         this.onErrorVoidForClose(methodObject26194, var2);
      }
   }

   public double getDouble(String arg0) throws SQLException {
      try {
         super.preForAll(methodObject26045, this, arg0);
         return (Double)this.postForAll(methodObject26045, this.delegate.getDouble(arg0));
      } catch (SQLException var3) {
         return (Double)this.postForAll(methodObject26045, this.onErrorForAll(methodObject26045, var3));
      }
   }

   public Object getObject(int arg0, Class arg1) throws SQLException {
      try {
         super.preForAll(methodObject26030, this, arg0, arg1);
         return this.postForAll(methodObject26030, this.proxyFactory.proxyForCache(this.delegate.getObject(arg0, arg1), this, this.proxyCache, methodObject26030));
      } catch (SQLException var4) {
         return this.postForAll(methodObject26030, this.onErrorForAll(methodObject26030, var4));
      }
   }

   public Timestamp getTimestamp(int arg0, Calendar arg1) throws SQLException {
      try {
         super.preForAll(methodObject26136, this, arg0, arg1);
         return (Timestamp)this.postForAll(methodObject26136, (Object)this.delegate.getTimestamp(arg0, arg1));
      } catch (SQLException var4) {
         return (Timestamp)this.postForAll(methodObject26136, this.onErrorForAll(methodObject26136, var4));
      }
   }

   public void setAsciiStream(String arg0, InputStream arg1, int arg2) throws SQLException {
      try {
         super.preForSetStreams(methodObject26070, this, arg0, arg1, arg2);
         this.delegate.setAsciiStream(arg0, arg1, arg2);
      } catch (SQLException var5) {
         this.onErrorVoidForAll(methodObject26070, var5);
      }
   }

   public void setTimestamp(int arg0, Timestamp arg1, Calendar arg2) throws SQLException {
      try {
         super.preForAll(methodObject26147, this, arg0, arg1, arg2);
         this.delegate.setTimestamp(arg0, arg1, arg2);
      } catch (SQLException var5) {
         this.onErrorVoidForAll(methodObject26147, var5);
      }
   }

   public void setBinaryStream(int arg0, InputStream arg1, long arg2) throws SQLException {
      try {
         super.preForSetStreams(methodObject26155, this, arg0, arg1, arg2);
         this.delegate.setBinaryStream(arg0, arg1, arg2);
      } catch (SQLException var6) {
         this.onErrorVoidForAll(methodObject26155, var6);
      }
   }

   public NClob getNClob(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject26089, this, arg0);
         return (NClob)this.postForAll(methodObject26089, this.proxyFactory.proxyForCreate((Object)this.delegate.getNClob(arg0), this, this.proxyCache, methodObject26089));
      } catch (SQLException var3) {
         return (NClob)this.postForAll(methodObject26089, this.onErrorForAll(methodObject26089, var3));
      }
   }

   public void setBytes(String arg0, byte[] arg1) throws SQLException {
      try {
         super.preForAll(methodObject26081, this, arg0, arg1);
         this.delegate.setBytes(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject26081, var4);
      }
   }

   public void setInt(String arg0, int arg1) throws SQLException {
      try {
         super.preForAll(methodObject26056, this, arg0, arg1);
         this.delegate.setInt(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject26056, var4);
      }
   }

   public byte getByte(String arg0) throws SQLException {
      try {
         super.preForAll(methodObject26035, this, arg0);
         return (Byte)this.postForAll(methodObject26035, this.delegate.getByte(arg0));
      } catch (SQLException var3) {
         return (Byte)this.postForAll(methodObject26035, this.onErrorForAll(methodObject26035, var3));
      }
   }

   public void setTime(String arg0, Time arg1, Calendar arg2) throws SQLException {
      try {
         super.preForAll(methodObject26096, this, arg0, arg1, arg2);
         this.delegate.setTime(arg0, arg1, arg2);
      } catch (SQLException var5) {
         this.onErrorVoidForAll(methodObject26096, var5);
      }
   }

   public Array getArray(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject26048, this, arg0);
         return (Array)this.postForAll(methodObject26048, this.proxyFactory.proxyForCreate((Object)this.delegate.getArray(arg0), this, this.proxyCache, methodObject26048));
      } catch (SQLException var3) {
         return (Array)this.postForAll(methodObject26048, this.onErrorForAll(methodObject26048, var3));
      }
   }

   public void setShort(int arg0, short arg1) throws SQLException {
      try {
         super.preForAll(methodObject26145, this, arg0, arg1);
         this.delegate.setShort(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject26145, var4);
      }
   }

   public boolean getMoreResults(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject26219, this, arg0);
         return (Boolean)this.postForAll(methodObject26219, this.delegate.getMoreResults(arg0));
      } catch (SQLException var3) {
         return (Boolean)this.postForAll(methodObject26219, this.onErrorForAll(methodObject26219, var3));
      }
   }

   public void clearBatch() throws SQLException {
      try {
         super.preForAll(methodObject26213, this, zeroLengthObjectArray);
         this.delegate.clearBatch();
      } catch (SQLException var2) {
         this.onErrorVoidForAll(methodObject26213, var2);
      }
   }

   public Timestamp getTimestamp(String arg0) throws SQLException {
      try {
         super.preForAll(methodObject26137, this, arg0);
         return (Timestamp)this.postForAll(methodObject26137, (Object)this.delegate.getTimestamp(arg0));
      } catch (SQLException var3) {
         return (Timestamp)this.postForAll(methodObject26137, this.onErrorForAll(methodObject26137, var3));
      }
   }

   public void setArray(int arg0, Array arg1) throws SQLException {
      try {
         super.preForAll(methodObject26192, this, arg0, arg1);
         this.delegate.setArray(arg0, arg1 instanceof _Proxy_ ? (Array)((_Proxy_)arg1)._getDelegate_() : arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject26192, var4);
      }
   }

   public void setNClob(int arg0, Reader arg1, long arg2) throws SQLException {
      try {
         super.preForAll(methodObject26185, this, arg0, arg1, arg2);
         this.delegate.setNClob(arg0, arg1, arg2);
      } catch (SQLException var6) {
         this.onErrorVoidForAll(methodObject26185, var6);
      }
   }

   public void setClob(String arg0, Reader arg1, long arg2) throws SQLException {
      try {
         super.preForAll(methodObject26117, this, arg0, arg1, arg2);
         this.delegate.setClob(arg0, arg1, arg2);
      } catch (SQLException var6) {
         this.onErrorVoidForAll(methodObject26117, var6);
      }
   }

   public int executeUpdate() throws SQLException {
      try {
         super.preForExecuteUpdate(methodObject26150, this, zeroLengthObjectArray);
         return this.postForExecuteUpdate(methodObject26150, this.delegate.executeUpdate());
      } catch (SQLException var2) {
         return this.postForExecuteUpdate(methodObject26150, (Integer)this.onErrorForAll(methodObject26150, var2));
      }
   }

   public void setAsciiStream(int arg0, InputStream arg1, int arg2) throws SQLException {
      try {
         super.preForSetStreams(methodObject26151, this, arg0, arg1, arg2);
         this.delegate.setAsciiStream(arg0, arg1, arg2);
      } catch (SQLException var5) {
         this.onErrorVoidForAll(methodObject26151, var5);
      }
   }

   public Clob getClob(String arg0) throws SQLException {
      try {
         super.preForAll(methodObject26088, this, arg0);
         return (Clob)this.postForAll(methodObject26088, this.proxyFactory.proxyForCreate((Object)this.delegate.getClob(arg0), this, this.proxyCache, methodObject26088));
      } catch (SQLException var3) {
         return (Clob)this.postForAll(methodObject26088, this.onErrorForAll(methodObject26088, var3));
      }
   }

   public void setNCharacterStream(int arg0, Reader arg1) throws SQLException {
      try {
         super.preForSetStreams(methodObject26161, this, arg0, arg1);
         this.delegate.setNCharacterStream(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject26161, var4);
      }
   }

   public void setTime(int arg0, Time arg1) throws SQLException {
      try {
         super.preForAll(methodObject26170, this, arg0, arg1);
         this.delegate.setTime(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject26170, var4);
      }
   }

   public void setLong(int arg0, long arg1) throws SQLException {
      try {
         super.preForAll(methodObject26144, this, arg0, arg1);
         this.delegate.setLong(arg0, arg1);
      } catch (SQLException var5) {
         this.onErrorVoidForAll(methodObject26144, var5);
      }
   }

   public void setDate(int arg0, Date arg1, Calendar arg2) throws SQLException {
      try {
         super.preForAll(methodObject26173, this, arg0, arg1, arg2);
         this.delegate.setDate(arg0, arg1, arg2);
      } catch (SQLException var5) {
         this.onErrorVoidForAll(methodObject26173, var5);
      }
   }

   public NClob getNClob(String arg0) throws SQLException {
      try {
         super.preForAll(methodObject26090, this, arg0);
         return (NClob)this.postForAll(methodObject26090, this.proxyFactory.proxyForCreate((Object)this.delegate.getNClob(arg0), this, this.proxyCache, methodObject26090));
      } catch (SQLException var3) {
         return (NClob)this.postForAll(methodObject26090, this.onErrorForAll(methodObject26090, var3));
      }
   }

   public float getFloat(String arg0) throws SQLException {
      try {
         super.preForAll(methodObject26043, this, arg0);
         return (Float)this.postForAll(methodObject26043, this.delegate.getFloat(arg0));
      } catch (SQLException var3) {
         return (Float)this.postForAll(methodObject26043, this.onErrorForAll(methodObject26043, var3));
      }
   }

   public void setByte(String arg0, byte arg1) throws SQLException {
      try {
         super.preForAll(methodObject26053, this, arg0, arg1);
         this.delegate.setByte(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject26053, var4);
      }
   }

   public void setFetchSize(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject26235, this, arg0);
         this.delegate.setFetchSize(arg0);
      } catch (SQLException var3) {
         this.onErrorVoidForAll(methodObject26235, var3);
      }
   }

   public void setFetchDirection(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject26234, this, arg0);
         this.delegate.setFetchDirection(arg0);
      } catch (SQLException var3) {
         this.onErrorVoidForAll(methodObject26234, var3);
      }
   }

   public int getFetchSize() throws SQLException {
      try {
         super.preForAll(methodObject26233, this, zeroLengthObjectArray);
         return (Integer)this.postForAll(methodObject26233, this.delegate.getFetchSize());
      } catch (SQLException var2) {
         return (Integer)this.postForAll(methodObject26233, this.onErrorForAll(methodObject26233, var2));
      }
   }

   public void registerOutParameter(String arg0, int arg1) throws SQLException {
      try {
         super.preForAll(methodObject26110, this, arg0, arg1);
         this.delegate.registerOutParameter(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject26110, var4);
      }
   }

   public void setCharacterStream(int arg0, Reader arg1, int arg2) throws SQLException {
      try {
         super.preForSetStreams(methodObject26157, this, arg0, arg1, arg2);
         this.delegate.setCharacterStream(arg0, arg1, arg2);
      } catch (SQLException var5) {
         this.onErrorVoidForAll(methodObject26157, var5);
      }
   }

   public void setCursorName(String arg0) throws SQLException {
      try {
         super.preForAll(methodObject26226, this, arg0);
         this.delegate.setCursorName(arg0);
      } catch (SQLException var3) {
         this.onErrorVoidForAll(methodObject26226, var3);
      }
   }

   public void setDouble(String arg0, double arg1) throws SQLException {
      try {
         super.preForAll(methodObject26054, this, arg0, arg1);
         this.delegate.setDouble(arg0, arg1);
      } catch (SQLException var5) {
         this.onErrorVoidForAll(methodObject26054, var5);
      }
   }

   public void setBytes(int arg0, byte[] arg1) throws SQLException {
      try {
         super.preForAll(methodObject26163, this, arg0, arg1);
         this.delegate.setBytes(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject26163, var4);
      }
   }

   public void setTime(String arg0, Time arg1) throws SQLException {
      try {
         super.preForAll(methodObject26095, this, arg0, arg1);
         this.delegate.setTime(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject26095, var4);
      }
   }

   public void setBinaryStream(int arg0, InputStream arg1, int arg2) throws SQLException {
      try {
         super.preForSetStreams(methodObject26154, this, arg0, arg1, arg2);
         this.delegate.setBinaryStream(arg0, arg1, arg2);
      } catch (SQLException var5) {
         this.onErrorVoidForAll(methodObject26154, var5);
      }
   }

   public void setCharacterStream(String arg0, Reader arg1, long arg2) throws SQLException {
      try {
         super.preForSetStreams(methodObject26077, this, arg0, arg1, arg2);
         this.delegate.setCharacterStream(arg0, arg1, arg2);
      } catch (SQLException var6) {
         this.onErrorVoidForAll(methodObject26077, var6);
      }
   }

   public void clearParameters() throws SQLException {
      try {
         super.preForAll(methodObject26176, this, zeroLengthObjectArray);
         this.delegate.clearParameters();
      } catch (SQLException var2) {
         this.onErrorVoidForAll(methodObject26176, var2);
      }
   }

   public boolean isWrapperFor(Class arg0) throws SQLException {
      try {
         super.preForAll(methodObject26237, this, arg0);
         return (Boolean)this.postForAll(methodObject26237, this.delegate.isWrapperFor(arg0));
      } catch (SQLException var3) {
         return (Boolean)this.postForAll(methodObject26237, this.onErrorForAll(methodObject26237, var3));
      }
   }

   public Object getObject(String arg0, Map arg1) throws SQLException {
      try {
         super.preForAll(methodObject26029, this, arg0, arg1);
         return this.postForAll(methodObject26029, this.proxyFactory.proxyForCache(this.delegate.getObject(arg0, arg1), this, this.proxyCache, methodObject26029));
      } catch (SQLException var4) {
         return this.postForAll(methodObject26029, this.onErrorForAll(methodObject26029, var4));
      }
   }

   public void setBlob(String arg0, Blob arg1) throws SQLException {
      try {
         super.preForAll(methodObject26115, this, arg0, arg1);
         this.delegate.setBlob(arg0, arg1 instanceof _Proxy_ ? (Blob)((_Proxy_)arg1)._getDelegate_() : arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject26115, var4);
      }
   }

   public boolean execute() throws SQLException {
      try {
         super.preForExecute(methodObject26149, this, zeroLengthObjectArray);
         return this.postForExecute(methodObject26149, this.delegate.execute());
      } catch (SQLException var2) {
         return this.postForExecute(methodObject26149, this.onErrorForExecute(methodObject26149, var2));
      }
   }

   public SQLXML getSQLXML(String arg0) throws SQLException {
      try {
         super.preForAll(methodObject26094, this, arg0);
         return (SQLXML)this.postForAll(methodObject26094, this.proxyFactory.proxyForCreate((Object)this.delegate.getSQLXML(arg0), this, this.proxyCache, methodObject26094));
      } catch (SQLException var3) {
         return (SQLXML)this.postForAll(methodObject26094, this.onErrorForAll(methodObject26094, var3));
      }
   }

   public ParameterMetaData getParameterMetaData() throws SQLException {
      try {
         super.preForAll(methodObject26169, this, zeroLengthObjectArray);
         return (ParameterMetaData)this.postForAll(methodObject26169, this.proxyFactory.proxyForCreate((Object)this.delegate.getParameterMetaData(), this, this.proxyCache, methodObject26169));
      } catch (SQLException var2) {
         return (ParameterMetaData)this.postForAll(methodObject26169, this.onErrorForAll(methodObject26169, var2));
      }
   }

   public Reader getCharacterStream(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject26103, this, arg0);
         return (Reader)this.postForAll(methodObject26103, (Object)this.delegate.getCharacterStream(arg0));
      } catch (SQLException var3) {
         return (Reader)this.postForAll(methodObject26103, this.onErrorForAll(methodObject26103, var3));
      }
   }

   public RowId getRowId(String arg0) throws SQLException {
      try {
         super.preForAll(methodObject26092, this, arg0);
         return (RowId)this.postForAll(methodObject26092, this.proxyFactory.proxyForCreate((Object)this.delegate.getRowId(arg0), this, this.proxyCache, methodObject26092));
      } catch (SQLException var3) {
         return (RowId)this.postForAll(methodObject26092, this.onErrorForAll(methodObject26092, var3));
      }
   }

   public void setClob(String arg0, Reader arg1) throws SQLException {
      try {
         super.preForAll(methodObject26119, this, arg0, arg1);
         this.delegate.setClob(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject26119, var4);
      }
   }

   public void registerOutParameter(int arg0, int arg1, String arg2) throws SQLException {
      try {
         super.preForAll(methodObject26109, this, arg0, arg1, arg2);
         this.delegate.registerOutParameter(arg0, arg1, arg2);
      } catch (SQLException var5) {
         this.onErrorVoidForAll(methodObject26109, var5);
      }
   }

   public void setBinaryStream(String arg0, InputStream arg1, long arg2) throws SQLException {
      try {
         super.preForSetStreams(methodObject26074, this, arg0, arg1, arg2);
         this.delegate.setBinaryStream(arg0, arg1, arg2);
      } catch (SQLException var6) {
         this.onErrorVoidForAll(methodObject26074, var6);
      }
   }

   public void setAsciiStream(int arg0, InputStream arg1, long arg2) throws SQLException {
      try {
         super.preForSetStreams(methodObject26152, this, arg0, arg1, arg2);
         this.delegate.setAsciiStream(arg0, arg1, arg2);
      } catch (SQLException var6) {
         this.onErrorVoidForAll(methodObject26152, var6);
      }
   }

   public int getMaxFieldSize() throws SQLException {
      try {
         super.preForAll(methodObject26216, this, zeroLengthObjectArray);
         return (Integer)this.postForAll(methodObject26216, this.delegate.getMaxFieldSize());
      } catch (SQLException var2) {
         return (Integer)this.postForAll(methodObject26216, this.onErrorForAll(methodObject26216, var2));
      }
   }

   public void registerOutParameter(String arg0, int arg1, String arg2) throws SQLException {
      try {
         super.preForAll(methodObject26112, this, arg0, arg1, arg2);
         this.delegate.registerOutParameter(arg0, arg1, arg2);
      } catch (SQLException var5) {
         this.onErrorVoidForAll(methodObject26112, var5);
      }
   }

   public void setFloat(String arg0, float arg1) throws SQLException {
      try {
         super.preForAll(methodObject26055, this, arg0, arg1);
         this.delegate.setFloat(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject26055, var4);
      }
   }

   public void setInt(int arg0, int arg1) throws SQLException {
      try {
         super.preForAll(methodObject26143, this, arg0, arg1);
         this.delegate.setInt(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject26143, var4);
      }
   }

   public CallableStatement _getDelegate_() {
      return this.delegate;
   }

   public Object getDelegate() {
      return this.delegate;
   }

   public void setDelegate(Object delegate) {
      this.proxyFactory.updateDelegate(this, this.delegate, delegate);
      this.delegate = (CallableStatement)delegate;
   }

   public Object getCreator() {
      return this.creator;
   }

   static {
      try {
         methodObject26038 = CallableStatement.class.getDeclaredMethod("getInt", Integer.TYPE);
         methodObject26100 = CallableStatement.class.getDeclaredMethod("getTime", String.class, Calendar.class);
         methodObject26195 = Statement.class.getDeclaredMethod("execute", String.class);
         methodObject26125 = CallableStatement.class.getDeclaredMethod("setNull", String.class, Integer.TYPE, String.class);
         methodObject26044 = CallableStatement.class.getDeclaredMethod("getDouble", Integer.TYPE);
         methodObject26190 = PreparedStatement.class.getDeclaredMethod("setRowId", Integer.TYPE, RowId.class);
         methodObject26084 = CallableStatement.class.getDeclaredMethod("setObject", String.class, Object.class);
         methodObject26204 = Statement.class.getDeclaredMethod("executeUpdate", String.class, int[].class);
         methodObject26140 = PreparedStatement.class.getDeclaredMethod("setByte", Integer.TYPE, Byte.TYPE);
         methodObject26141 = PreparedStatement.class.getDeclaredMethod("setDouble", Integer.TYPE, Double.TYPE);
         methodObject26126 = CallableStatement.class.getDeclaredMethod("setRowId", String.class, RowId.class);
         methodObject26064 = CallableStatement.class.getDeclaredMethod("getString", String.class);
         methodObject26188 = PreparedStatement.class.getDeclaredMethod("setNull", Integer.TYPE, Integer.TYPE);
         methodObject26040 = CallableStatement.class.getDeclaredMethod("getLong", Integer.TYPE);
         methodObject26202 = Statement.class.getDeclaredMethod("executeUpdate", String.class);
         methodObject26225 = Statement.class.getDeclaredMethod("isPoolable");
         methodObject26146 = PreparedStatement.class.getDeclaredMethod("setTimestamp", Integer.TYPE, Timestamp.class);
         methodObject26187 = PreparedStatement.class.getDeclaredMethod("setNString", Integer.TYPE, String.class);
         methodObject26068 = CallableStatement.class.getDeclaredMethod("getDate", String.class);
         methodObject26162 = PreparedStatement.class.getDeclaredMethod("setUnicodeStream", Integer.TYPE, InputStream.class, Integer.TYPE);
         methodObject26047 = CallableStatement.class.getDeclaredMethod("getBytes", String.class);
         methodObject26171 = PreparedStatement.class.getDeclaredMethod("setTime", Integer.TYPE, Time.class, Calendar.class);
         methodObject26223 = Statement.class.getDeclaredMethod("getUpdateCount");
         methodObject26166 = PreparedStatement.class.getDeclaredMethod("setObject", Integer.TYPE, Object.class, Integer.TYPE, Integer.TYPE);
         methodObject26224 = Statement.class.getDeclaredMethod("isCloseOnCompletion");
         methodObject26228 = Statement.class.getDeclaredMethod("setMaxFieldSize", Integer.TYPE);
         methodObject26063 = CallableStatement.class.getDeclaredMethod("getString", Integer.TYPE);
         methodObject26156 = PreparedStatement.class.getDeclaredMethod("setBinaryStream", Integer.TYPE, InputStream.class);
         methodObject26201 = Statement.class.getDeclaredMethod("executeBatch");
         methodObject26106 = CallableStatement.class.getDeclaredMethod("wasNull");
         methodObject26222 = Statement.class.getDeclaredMethod("getResultSetType");
         methodObject26080 = CallableStatement.class.getDeclaredMethod("setNCharacterStream", String.class, Reader.class);
         methodObject26062 = CallableStatement.class.getDeclaredMethod("getRef", String.class);
         methodObject26227 = Statement.class.getDeclaredMethod("setEscapeProcessing", Boolean.TYPE);
         methodObject26211 = Statement.class.getDeclaredMethod("getResultSetHoldability");
         methodObject26181 = PreparedStatement.class.getDeclaredMethod("setClob", Integer.TYPE, Clob.class);
         methodObject26114 = CallableStatement.class.getDeclaredMethod("setBlob", String.class, InputStream.class, Long.TYPE);
         methodObject26098 = CallableStatement.class.getDeclaredMethod("getTime", Integer.TYPE, Calendar.class);
         methodObject26079 = CallableStatement.class.getDeclaredMethod("setNCharacterStream", String.class, Reader.class, Long.TYPE);
         methodObject26210 = Statement.class.getDeclaredMethod("clearWarnings");
         methodObject26042 = CallableStatement.class.getDeclaredMethod("getFloat", Integer.TYPE);
         methodObject26026 = CallableStatement.class.getDeclaredMethod("getObject", Integer.TYPE);
         methodObject26058 = CallableStatement.class.getDeclaredMethod("setShort", String.class, Short.TYPE);
         methodObject26168 = PreparedStatement.class.getDeclaredMethod("getMetaData");
         methodObject26230 = Statement.class.getDeclaredMethod("setPoolable", Boolean.TYPE);
         methodObject26206 = Statement.class.getDeclaredMethod("isClosed");
         methodObject26093 = CallableStatement.class.getDeclaredMethod("getSQLXML", Integer.TYPE);
         methodObject26075 = CallableStatement.class.getDeclaredMethod("setBinaryStream", String.class, InputStream.class);
         methodObject26123 = CallableStatement.class.getDeclaredMethod("setNString", String.class, String.class);
         methodObject26131 = CallableStatement.class.getDeclaredMethod("getNCharacterStream", Integer.TYPE);
         methodObject26037 = CallableStatement.class.getDeclaredMethod("getShort", String.class);
         methodObject26085 = CallableStatement.class.getDeclaredMethod("getBlob", Integer.TYPE);
         methodObject26159 = PreparedStatement.class.getDeclaredMethod("setCharacterStream", Integer.TYPE, Reader.class);
         methodObject26215 = Statement.class.getDeclaredMethod("getGeneratedKeys");
         methodObject26065 = CallableStatement.class.getDeclaredMethod("setURL", String.class, URL.class);
         methodObject26182 = PreparedStatement.class.getDeclaredMethod("setClob", Integer.TYPE, Reader.class, Long.TYPE);
         methodObject26031 = CallableStatement.class.getDeclaredMethod("getObject", String.class, Class.class);
         methodObject26198 = Statement.class.getDeclaredMethod("execute", String.class, String[].class);
         methodObject26214 = Statement.class.getDeclaredMethod("closeOnCompletion");
         methodObject26133 = CallableStatement.class.getDeclaredMethod("getNString", Integer.TYPE);
         methodObject26232 = Statement.class.getDeclaredMethod("getFetchDirection");
         methodObject26108 = CallableStatement.class.getDeclaredMethod("registerOutParameter", Integer.TYPE, Integer.TYPE, Integer.TYPE);
         methodObject26091 = CallableStatement.class.getDeclaredMethod("getRowId", Integer.TYPE);
         methodObject26051 = CallableStatement.class.getDeclaredMethod("getURL", String.class);
         methodObject26178 = PreparedStatement.class.getDeclaredMethod("setBlob", Integer.TYPE, Blob.class);
         methodObject26179 = PreparedStatement.class.getDeclaredMethod("setBlob", Integer.TYPE, InputStream.class, Long.TYPE);
         methodObject26132 = CallableStatement.class.getDeclaredMethod("getNCharacterStream", String.class);
         methodObject26158 = PreparedStatement.class.getDeclaredMethod("setCharacterStream", Integer.TYPE, Reader.class, Long.TYPE);
         methodObject26139 = PreparedStatement.class.getDeclaredMethod("setBoolean", Integer.TYPE, Boolean.TYPE);
         methodObject26130 = CallableStatement.class.getDeclaredMethod("getBigDecimal", String.class);
         methodObject26033 = CallableStatement.class.getDeclaredMethod("getBoolean", String.class);
         methodObject26060 = CallableStatement.class.getDeclaredMethod("setTimestamp", String.class, Timestamp.class, Calendar.class);
         methodObject26072 = CallableStatement.class.getDeclaredMethod("setAsciiStream", String.class, InputStream.class);
         methodObject26099 = CallableStatement.class.getDeclaredMethod("getTime", String.class);
         methodObject26180 = PreparedStatement.class.getDeclaredMethod("setBlob", Integer.TYPE, InputStream.class);
         methodObject26135 = CallableStatement.class.getDeclaredMethod("getTimestamp", Integer.TYPE);
         methodObject26101 = CallableStatement.class.getDeclaredMethod("setDate", String.class, Date.class);
         methodObject26046 = CallableStatement.class.getDeclaredMethod("getBytes", Integer.TYPE);
         methodObject26069 = CallableStatement.class.getDeclaredMethod("getDate", String.class, Calendar.class);
         methodObject26082 = CallableStatement.class.getDeclaredMethod("setObject", String.class, Object.class, Integer.TYPE, Integer.TYPE);
         methodObject26073 = CallableStatement.class.getDeclaredMethod("setBinaryStream", String.class, InputStream.class, Integer.TYPE);
         methodObject26121 = CallableStatement.class.getDeclaredMethod("setNClob", String.class, Reader.class, Long.TYPE);
         methodObject26153 = PreparedStatement.class.getDeclaredMethod("setAsciiStream", Integer.TYPE, InputStream.class);
         methodObject26236 = Wrapper.class.getDeclaredMethod("unwrap", Class.class);
         methodObject26212 = Statement.class.getDeclaredMethod("addBatch", String.class);
         methodObject26221 = Statement.class.getDeclaredMethod("getResultSetConcurrency");
         methodObject26111 = CallableStatement.class.getDeclaredMethod("registerOutParameter", String.class, Integer.TYPE, Integer.TYPE);
         methodObject26134 = CallableStatement.class.getDeclaredMethod("getNString", String.class);
         methodObject26164 = PreparedStatement.class.getDeclaredMethod("setObject", Integer.TYPE, Object.class, Integer.TYPE);
         methodObject26165 = PreparedStatement.class.getDeclaredMethod("setObject", Integer.TYPE, Object.class);
         methodObject26039 = CallableStatement.class.getDeclaredMethod("getInt", String.class);
         methodObject26193 = PreparedStatement.class.getDeclaredMethod("setRef", Integer.TYPE, Ref.class);
         methodObject26052 = CallableStatement.class.getDeclaredMethod("setBoolean", String.class, Boolean.TYPE);
         methodObject26199 = Statement.class.getDeclaredMethod("cancel");
         methodObject26231 = Statement.class.getDeclaredMethod("setQueryTimeout", Integer.TYPE);
         methodObject26078 = CallableStatement.class.getDeclaredMethod("setCharacterStream", String.class, Reader.class);
         methodObject26200 = Statement.class.getDeclaredMethod("getResultSet");
         methodObject26083 = CallableStatement.class.getDeclaredMethod("setObject", String.class, Object.class, Integer.TYPE);
         methodObject26116 = CallableStatement.class.getDeclaredMethod("setBlob", String.class, InputStream.class);
         methodObject26160 = PreparedStatement.class.getDeclaredMethod("setNCharacterStream", Integer.TYPE, Reader.class, Long.TYPE);
         methodObject26184 = PreparedStatement.class.getDeclaredMethod("setNClob", Integer.TYPE, NClob.class);
         methodObject26197 = Statement.class.getDeclaredMethod("execute", String.class, int[].class);
         methodObject26127 = CallableStatement.class.getDeclaredMethod("setSQLXML", String.class, SQLXML.class);
         methodObject26097 = CallableStatement.class.getDeclaredMethod("getTime", Integer.TYPE);
         methodObject26113 = CallableStatement.class.getDeclaredMethod("setBigDecimal", String.class, BigDecimal.class);
         methodObject26028 = CallableStatement.class.getDeclaredMethod("getObject", String.class);
         methodObject26172 = PreparedStatement.class.getDeclaredMethod("setDate", Integer.TYPE, Date.class);
         methodObject26218 = Statement.class.getDeclaredMethod("getMoreResults");
         methodObject26057 = CallableStatement.class.getDeclaredMethod("setLong", String.class, Long.TYPE);
         methodObject26203 = Statement.class.getDeclaredMethod("executeUpdate", String.class, Integer.TYPE);
         methodObject26076 = CallableStatement.class.getDeclaredMethod("setCharacterStream", String.class, Reader.class, Integer.TYPE);
         methodObject26032 = CallableStatement.class.getDeclaredMethod("getBoolean", Integer.TYPE);
         methodObject26128 = CallableStatement.class.getDeclaredMethod("getBigDecimal", Integer.TYPE, Integer.TYPE);
         methodObject26129 = CallableStatement.class.getDeclaredMethod("getBigDecimal", Integer.TYPE);
         methodObject26207 = Statement.class.getDeclaredMethod("executeQuery", String.class);
         methodObject26142 = PreparedStatement.class.getDeclaredMethod("setFloat", Integer.TYPE, Float.TYPE);
         methodObject26107 = CallableStatement.class.getDeclaredMethod("registerOutParameter", Integer.TYPE, Integer.TYPE);
         methodObject26191 = PreparedStatement.class.getDeclaredMethod("setSQLXML", Integer.TYPE, SQLXML.class);
         methodObject26217 = Statement.class.getDeclaredMethod("getMaxRows");
         methodObject26174 = PreparedStatement.class.getDeclaredMethod("setString", Integer.TYPE, String.class);
         methodObject26175 = PreparedStatement.class.getDeclaredMethod("addBatch");
         methodObject26036 = CallableStatement.class.getDeclaredMethod("getShort", Integer.TYPE);
         methodObject26059 = CallableStatement.class.getDeclaredMethod("setTimestamp", String.class, Timestamp.class);
         methodObject26061 = CallableStatement.class.getDeclaredMethod("getRef", Integer.TYPE);
         methodObject26205 = Statement.class.getDeclaredMethod("executeUpdate", String.class, String[].class);
         methodObject26118 = CallableStatement.class.getDeclaredMethod("setClob", String.class, Clob.class);
         methodObject26124 = CallableStatement.class.getDeclaredMethod("setNull", String.class, Integer.TYPE);
         methodObject26066 = CallableStatement.class.getDeclaredMethod("getDate", Integer.TYPE);
         methodObject26220 = Statement.class.getDeclaredMethod("getQueryTimeout");
         methodObject26196 = Statement.class.getDeclaredMethod("execute", String.class, Integer.TYPE);
         methodObject26148 = PreparedStatement.class.getDeclaredMethod("setURL", Integer.TYPE, URL.class);
         methodObject26186 = PreparedStatement.class.getDeclaredMethod("setNClob", Integer.TYPE, Reader.class);
         methodObject26086 = CallableStatement.class.getDeclaredMethod("getBlob", String.class);
         methodObject26105 = CallableStatement.class.getDeclaredMethod("setString", String.class, String.class);
         methodObject26177 = PreparedStatement.class.getDeclaredMethod("setBigDecimal", Integer.TYPE, BigDecimal.class);
         methodObject26189 = PreparedStatement.class.getDeclaredMethod("setNull", Integer.TYPE, Integer.TYPE, String.class);
         methodObject26027 = CallableStatement.class.getDeclaredMethod("getObject", Integer.TYPE, Map.class);
         methodObject26183 = PreparedStatement.class.getDeclaredMethod("setClob", Integer.TYPE, Reader.class);
         methodObject26067 = CallableStatement.class.getDeclaredMethod("getDate", Integer.TYPE, Calendar.class);
         methodObject26122 = CallableStatement.class.getDeclaredMethod("setNClob", String.class, Reader.class);
         methodObject26167 = PreparedStatement.class.getDeclaredMethod("executeQuery");
         methodObject26071 = CallableStatement.class.getDeclaredMethod("setAsciiStream", String.class, InputStream.class, Long.TYPE);
         methodObject26050 = CallableStatement.class.getDeclaredMethod("getURL", Integer.TYPE);
         methodObject26049 = CallableStatement.class.getDeclaredMethod("getArray", String.class);
         methodObject26102 = CallableStatement.class.getDeclaredMethod("setDate", String.class, Date.class, Calendar.class);
         methodObject26120 = CallableStatement.class.getDeclaredMethod("setNClob", String.class, NClob.class);
         methodObject26209 = Statement.class.getDeclaredMethod("getWarnings");
         methodObject26104 = CallableStatement.class.getDeclaredMethod("getCharacterStream", String.class);
         methodObject26034 = CallableStatement.class.getDeclaredMethod("getByte", Integer.TYPE);
         methodObject26208 = Statement.class.getDeclaredMethod("getConnection");
         methodObject26229 = Statement.class.getDeclaredMethod("setMaxRows", Integer.TYPE);
         methodObject26041 = CallableStatement.class.getDeclaredMethod("getLong", String.class);
         methodObject26138 = CallableStatement.class.getDeclaredMethod("getTimestamp", String.class, Calendar.class);
         methodObject26087 = CallableStatement.class.getDeclaredMethod("getClob", Integer.TYPE);
         methodObject26194 = Statement.class.getDeclaredMethod("close");
         methodObject26045 = CallableStatement.class.getDeclaredMethod("getDouble", String.class);
         methodObject26030 = CallableStatement.class.getDeclaredMethod("getObject", Integer.TYPE, Class.class);
         methodObject26136 = CallableStatement.class.getDeclaredMethod("getTimestamp", Integer.TYPE, Calendar.class);
         methodObject26070 = CallableStatement.class.getDeclaredMethod("setAsciiStream", String.class, InputStream.class, Integer.TYPE);
         methodObject26147 = PreparedStatement.class.getDeclaredMethod("setTimestamp", Integer.TYPE, Timestamp.class, Calendar.class);
         methodObject26155 = PreparedStatement.class.getDeclaredMethod("setBinaryStream", Integer.TYPE, InputStream.class, Long.TYPE);
         methodObject26089 = CallableStatement.class.getDeclaredMethod("getNClob", Integer.TYPE);
         methodObject26081 = CallableStatement.class.getDeclaredMethod("setBytes", String.class, byte[].class);
         methodObject26056 = CallableStatement.class.getDeclaredMethod("setInt", String.class, Integer.TYPE);
         methodObject26035 = CallableStatement.class.getDeclaredMethod("getByte", String.class);
         methodObject26096 = CallableStatement.class.getDeclaredMethod("setTime", String.class, Time.class, Calendar.class);
         methodObject26048 = CallableStatement.class.getDeclaredMethod("getArray", Integer.TYPE);
         methodObject26145 = PreparedStatement.class.getDeclaredMethod("setShort", Integer.TYPE, Short.TYPE);
         methodObject26219 = Statement.class.getDeclaredMethod("getMoreResults", Integer.TYPE);
         methodObject26213 = Statement.class.getDeclaredMethod("clearBatch");
         methodObject26137 = CallableStatement.class.getDeclaredMethod("getTimestamp", String.class);
         methodObject26192 = PreparedStatement.class.getDeclaredMethod("setArray", Integer.TYPE, Array.class);
         methodObject26185 = PreparedStatement.class.getDeclaredMethod("setNClob", Integer.TYPE, Reader.class, Long.TYPE);
         methodObject26117 = CallableStatement.class.getDeclaredMethod("setClob", String.class, Reader.class, Long.TYPE);
         methodObject26150 = PreparedStatement.class.getDeclaredMethod("executeUpdate");
         methodObject26151 = PreparedStatement.class.getDeclaredMethod("setAsciiStream", Integer.TYPE, InputStream.class, Integer.TYPE);
         methodObject26088 = CallableStatement.class.getDeclaredMethod("getClob", String.class);
         methodObject26161 = PreparedStatement.class.getDeclaredMethod("setNCharacterStream", Integer.TYPE, Reader.class);
         methodObject26170 = PreparedStatement.class.getDeclaredMethod("setTime", Integer.TYPE, Time.class);
         methodObject26144 = PreparedStatement.class.getDeclaredMethod("setLong", Integer.TYPE, Long.TYPE);
         methodObject26173 = PreparedStatement.class.getDeclaredMethod("setDate", Integer.TYPE, Date.class, Calendar.class);
         methodObject26090 = CallableStatement.class.getDeclaredMethod("getNClob", String.class);
         methodObject26043 = CallableStatement.class.getDeclaredMethod("getFloat", String.class);
         methodObject26053 = CallableStatement.class.getDeclaredMethod("setByte", String.class, Byte.TYPE);
         methodObject26235 = Statement.class.getDeclaredMethod("setFetchSize", Integer.TYPE);
         methodObject26234 = Statement.class.getDeclaredMethod("setFetchDirection", Integer.TYPE);
         methodObject26233 = Statement.class.getDeclaredMethod("getFetchSize");
         methodObject26110 = CallableStatement.class.getDeclaredMethod("registerOutParameter", String.class, Integer.TYPE);
         methodObject26157 = PreparedStatement.class.getDeclaredMethod("setCharacterStream", Integer.TYPE, Reader.class, Integer.TYPE);
         methodObject26226 = Statement.class.getDeclaredMethod("setCursorName", String.class);
         methodObject26054 = CallableStatement.class.getDeclaredMethod("setDouble", String.class, Double.TYPE);
         methodObject26163 = PreparedStatement.class.getDeclaredMethod("setBytes", Integer.TYPE, byte[].class);
         methodObject26095 = CallableStatement.class.getDeclaredMethod("setTime", String.class, Time.class);
         methodObject26154 = PreparedStatement.class.getDeclaredMethod("setBinaryStream", Integer.TYPE, InputStream.class, Integer.TYPE);
         methodObject26077 = CallableStatement.class.getDeclaredMethod("setCharacterStream", String.class, Reader.class, Long.TYPE);
         methodObject26176 = PreparedStatement.class.getDeclaredMethod("clearParameters");
         methodObject26237 = Wrapper.class.getDeclaredMethod("isWrapperFor", Class.class);
         methodObject26029 = CallableStatement.class.getDeclaredMethod("getObject", String.class, Map.class);
         methodObject26115 = CallableStatement.class.getDeclaredMethod("setBlob", String.class, Blob.class);
         methodObject26149 = PreparedStatement.class.getDeclaredMethod("execute");
         methodObject26094 = CallableStatement.class.getDeclaredMethod("getSQLXML", String.class);
         methodObject26169 = PreparedStatement.class.getDeclaredMethod("getParameterMetaData");
         methodObject26103 = CallableStatement.class.getDeclaredMethod("getCharacterStream", Integer.TYPE);
         methodObject26092 = CallableStatement.class.getDeclaredMethod("getRowId", String.class);
         methodObject26119 = CallableStatement.class.getDeclaredMethod("setClob", String.class, Reader.class);
         methodObject26109 = CallableStatement.class.getDeclaredMethod("registerOutParameter", Integer.TYPE, Integer.TYPE, String.class);
         methodObject26074 = CallableStatement.class.getDeclaredMethod("setBinaryStream", String.class, InputStream.class, Long.TYPE);
         methodObject26152 = PreparedStatement.class.getDeclaredMethod("setAsciiStream", Integer.TYPE, InputStream.class, Long.TYPE);
         methodObject26216 = Statement.class.getDeclaredMethod("getMaxFieldSize");
         methodObject26112 = CallableStatement.class.getDeclaredMethod("registerOutParameter", String.class, Integer.TYPE, String.class);
         methodObject26055 = CallableStatement.class.getDeclaredMethod("setFloat", String.class, Float.TYPE);
         methodObject26143 = PreparedStatement.class.getDeclaredMethod("setInt", Integer.TYPE, Integer.TYPE);
      } catch (Throwable var1) {
         throw new RuntimeException(var1);
      }
   }

   public oracle$1jdbc$1replay$1driver$1NonTxnReplayableStatement$2java$1sql$1CallableStatement$$$Proxy(CallableStatement var1, Object var2, ProxyFactory var3, Map var4) {
      this.delegate = var1;
      this.creator = var2;
      this.proxyFactory = var3;
      this.proxyCache = var4;
   }
}
