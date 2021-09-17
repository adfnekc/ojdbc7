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
import oracle.jdbc.OracleParameterMetaData;
import oracle.jdbc.OraclePreparedStatement;
import oracle.jdbc.OracleStatement;
import oracle.jdbc.dcn.DatabaseChangeRegistration;
import oracle.jdbc.replay.driver.NonTxnReplayableStatement;
import oracle.sql.ARRAY;
import oracle.sql.BFILE;
import oracle.sql.BINARY_DOUBLE;
import oracle.sql.BINARY_FLOAT;
import oracle.sql.BLOB;
import oracle.sql.CHAR;
import oracle.sql.CLOB;
import oracle.sql.CustomDatum;
import oracle.sql.DATE;
import oracle.sql.Datum;
import oracle.sql.INTERVALDS;
import oracle.sql.INTERVALYM;
import oracle.sql.NUMBER;
import oracle.sql.OPAQUE;
import oracle.sql.ORAData;
import oracle.sql.RAW;
import oracle.sql.REF;
import oracle.sql.ROWID;
import oracle.sql.STRUCT;
import oracle.sql.StructDescriptor;
import oracle.sql.TIMESTAMP;
import oracle.sql.TIMESTAMPLTZ;
import oracle.sql.TIMESTAMPTZ;

public abstract class oracle$1jdbc$1replay$1driver$1NonTxnReplayableStatement$2oracle$1jdbc$1OraclePreparedStatement$$$Proxy extends NonTxnReplayableStatement implements OraclePreparedStatement, _Proxy_ {
   private OraclePreparedStatement delegate;
   private final Object creator;
   private final ProxyFactory proxyFactory;
   private final Map proxyCache;
   private static Object[] zeroLengthObjectArray = new Object[0];
   private static Method methodObject26851;
   private static Method methodObject26988;
   private static Method methodObject26825;
   private static Method methodObject26853;
   private static Method methodObject26918;
   private static Method methodObject26894;
   private static Method methodObject26847;
   private static Method methodObject26983;
   private static Method methodObject26920;
   private static Method methodObject26997;
   private static Method methodObject26893;
   private static Method methodObject26927;
   private static Method methodObject26933;
   private static Method methodObject26934;
   private static Method methodObject26816;
   private static Method methodObject26981;
   private static Method methodObject27040;
   private static Method methodObject26995;
   private static Method methodObject27018;
   private static Method methodObject26844;
   private static Method methodObject26939;
   private static Method methodObject26980;
   private static Method methodObject27033;
   private static Method methodObject26819;
   private static Method methodObject26955;
   private static Method methodObject26964;
   private static Method methodObject27016;
   private static Method methodObject26834;
   private static Method methodObject26959;
   private static Method methodObject27017;
   private static Method methodObject27021;
   private static Method methodObject26896;
   private static Method methodObject26922;
   private static Method methodObject26874;
   private static Method methodObject26809;
   private static Method methodObject26949;
   private static Method methodObject26810;
   private static Method methodObject26994;
   private static Method methodObject27015;
   private static Method methodObject26858;
   private static Method methodObject27020;
   private static Method methodObject27004;
   private static Method methodObject26830;
   private static Method methodObject26974;
   private static Method methodObject26822;
   private static Method methodObject26903;
   private static Method methodObject26852;
   private static Method methodObject27003;
   private static Method methodObject26910;
   private static Method methodObject26888;
   private static Method methodObject26916;
   private static Method methodObject26824;
   private static Method methodObject26926;
   private static Method methodObject26961;
   private static Method methodObject26898;
   private static Method methodObject27023;
   private static Method methodObject26999;
   private static Method methodObject26870;
   private static Method methodObject26854;
   private static Method methodObject26931;
   private static Method methodObject27036;
   private static Method methodObject27008;
   private static Method methodObject26952;
   private static Method methodObject27039;
   private static Method methodObject26975;
   private static Method methodObject26991;
   private static Method methodObject26808;
   private static Method methodObject27007;
   private static Method methodObject26835;
   private static Method methodObject27025;
   private static Method methodObject26911;
   private static Method methodObject26971;
   private static Method methodObject26972;
   private static Method methodObject26838;
   private static Method methodObject26951;
   private static Method methodObject26832;
   private static Method methodObject26932;
   private static Method methodObject26885;
   private static Method methodObject26860;
   private static Method methodObject26840;
   private static Method methodObject26902;
   private static Method methodObject26925;
   private static Method methodObject26837;
   private static Method methodObject26821;
   private static Method methodObject26930;
   private static Method methodObject26820;
   private static Method methodObject26928;
   private static Method methodObject26812;
   private static Method methodObject26909;
   private static Method methodObject26880;
   private static Method methodObject26973;
   private static Method methodObject27032;
   private static Method methodObject26892;
   private static Method methodObject26872;
   private static Method methodObject26864;
   private static Method methodObject26905;
   private static Method methodObject26831;
   private static Method methodObject26900;
   private static Method methodObject26850;
   private static Method methodObject26929;
   private static Method methodObject26946;
   private static Method methodObject26848;
   private static Method methodObject26907;
   private static Method methodObject26827;
   private static Method methodObject27029;
   private static Method methodObject27005;
   private static Method methodObject27014;
   private static Method methodObject26890;
   private static Method methodObject26871;
   private static Method methodObject26855;
   private static Method methodObject26957;
   private static Method methodObject26889;
   private static Method methodObject26868;
   private static Method methodObject26923;
   private static Method methodObject26958;
   private static Method methodObject26826;
   private static Method methodObject26986;
   private static Method methodObject26862;
   private static Method methodObject26992;
   private static Method methodObject26899;
   private static Method methodObject26836;
   private static Method methodObject27024;
   private static Method methodObject26993;
   private static Method methodObject27042;
   private static Method methodObject27043;
   private static Method methodObject27035;
   private static Method methodObject26863;
   private static Method methodObject26875;
   private static Method methodObject26953;
   private static Method methodObject26921;
   private static Method methodObject27034;
   private static Method methodObject27047;
   private static Method methodObject26977;
   private static Method methodObject26866;
   private static Method methodObject26906;
   private static Method methodObject26990;
   private static Method methodObject26873;
   private static Method methodObject26965;
   private static Method methodObject27011;
   private static Method methodObject26996;
   private static Method methodObject26829;
   private static Method methodObject26867;
   private static Method methodObject26865;
   private static Method methodObject26843;
   private static Method methodObject27000;
   private static Method methodObject26897;
   private static Method methodObject26935;
   private static Method methodObject26915;
   private static Method methodObject26984;
   private static Method methodObject26879;
   private static Method methodObject26818;
   private static Method methodObject27010;
   private static Method methodObject26924;
   private static Method methodObject26967;
   private static Method methodObject26968;
   private static Method methodObject26998;
   private static Method methodObject26887;
   private static Method methodObject26913;
   private static Method methodObject27013;
   private static Method methodObject26895;
   private static Method methodObject26989;
   private static Method methodObject26941;
   private static Method methodObject26979;
   private static Method methodObject26841;
   private static Method methodObject26970;
   private static Method methodObject26982;
   private static Method methodObject26976;
   private static Method methodObject26960;
   private static Method methodObject26828;
   private static Method methodObject26891;
   private static Method methodObject26842;
   private static Method methodObject27002;
   private static Method methodObject26908;
   private static Method methodObject26884;
   private static Method methodObject26919;
   private static Method methodObject27001;
   private static Method methodObject26861;
   private static Method methodObject27044;
   private static Method methodObject27022;
   private static Method methodObject26886;
   private static Method methodObject27031;
   private static Method methodObject26857;
   private static Method methodObject26987;
   private static Method methodObject26869;
   private static Method methodObject26912;
   private static Method methodObject26833;
   private static Method methodObject26882;
   private static Method methodObject26839;
   private static Method methodObject26940;
   private static Method methodObject26948;
   private static Method methodObject26813;
   private static Method methodObject26856;
   private static Method methodObject26881;
   private static Method methodObject26938;
   private static Method methodObject27012;
   private static Method methodObject27006;
   private static Method methodObject27045;
   private static Method methodObject26985;
   private static Method methodObject26978;
   private static Method methodObject26943;
   private static Method methodObject26944;
   private static Method methodObject27038;
   private static Method methodObject26954;
   private static Method methodObject26963;
   private static Method methodObject27037;
   private static Method methodObject26937;
   private static Method methodObject26966;
   private static Method methodObject26876;
   private static Method methodObject26859;
   private static Method methodObject26914;
   private static Method methodObject27028;
   private static Method methodObject27027;
   private static Method methodObject27026;
   private static Method methodObject26849;
   private static Method methodObject26901;
   private static Method methodObject26950;
   private static Method methodObject27019;
   private static Method methodObject26956;
   private static Method methodObject26947;
   private static Method methodObject27046;
   private static Method methodObject26969;
   private static Method methodObject26811;
   private static Method methodObject27030;
   private static Method methodObject26846;
   private static Method methodObject26878;
   private static Method methodObject26942;
   private static Method methodObject27041;
   private static Method methodObject26823;
   private static Method methodObject26845;
   private static Method methodObject26962;
   private static Method methodObject26815;
   private static Method methodObject26877;
   private static Method methodObject26904;
   private static Method methodObject26883;
   private static Method methodObject26917;
   private static Method methodObject26945;
   private static Method methodObject26817;
   private static Method methodObject27009;
   private static Method methodObject26814;
   private static Method methodObject26936;

   public void setCHARAtName(String arg0, CHAR arg1) throws SQLException {
      try {
         super.preForAll(methodObject26851, this, arg0, arg1);
         this.delegate.setCHARAtName(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject26851, var4);
      }
   }

   public boolean execute(String arg0) throws SQLException {
      try {
         super.preForExecute(methodObject26988, this, arg0);
         return this.postForExecute(methodObject26988, this.delegate.execute(arg0));
      } catch (SQLException var3) {
         return this.postForExecute(methodObject26988, this.onErrorForExecute(methodObject26988, var3));
      }
   }

   public int getExecuteBatch() {
      super.preForAll(methodObject26825, this, zeroLengthObjectArray);
      return (Integer)this.postForAll(methodObject26825, this.delegate.getExecuteBatch());
   }

   public void setNUMBERAtName(String arg0, NUMBER arg1) throws SQLException {
      try {
         super.preForAll(methodObject26853, this, arg0, arg1);
         this.delegate.setNUMBERAtName(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject26853, var4);
      }
   }

   public void setINTERVALDS(int arg0, INTERVALDS arg1) throws SQLException {
      try {
         super.preForAll(methodObject26918, this, arg0, arg1);
         this.delegate.setINTERVALDS(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject26918, var4);
      }
   }

   public void setNClobAtName(String arg0, Reader arg1, long arg2) throws SQLException {
      try {
         super.preForAll(methodObject26894, this, arg0, arg1, arg2);
         this.delegate.setNClobAtName(arg0, arg1, arg2);
      } catch (SQLException var6) {
         this.onErrorVoidForAll(methodObject26894, var6);
      }
   }

   public void setOPAQUEAtName(String arg0, OPAQUE arg1) throws SQLException {
      try {
         super.preForAll(methodObject26847, this, arg0, arg1);
         this.delegate.setOPAQUEAtName(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject26847, var4);
      }
   }

   public void setRowId(int arg0, RowId arg1) throws SQLException {
      try {
         super.preForAll(methodObject26983, this, arg0, arg1);
         this.delegate.setRowId(arg0, arg1 instanceof _Proxy_ ? (RowId)((_Proxy_)arg1)._getDelegate_() : arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject26983, var4);
      }
   }

   public void setTIMESTAMPTZ(int arg0, TIMESTAMPTZ arg1) throws SQLException {
      try {
         super.preForAll(methodObject26920, this, arg0, arg1);
         this.delegate.setTIMESTAMPTZ(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject26920, var4);
      }
   }

   public int executeUpdate(String arg0, int[] arg1) throws SQLException {
      try {
         super.preForExecuteUpdate(methodObject26997, this, arg0, arg1);
         return this.postForExecuteUpdate(methodObject26997, this.delegate.executeUpdate(arg0, arg1));
      } catch (SQLException var4) {
         return this.postForExecuteUpdate(methodObject26997, (Integer)this.onErrorForAll(methodObject26997, var4));
      }
   }

   public void setNClobAtName(String arg0, NClob arg1) throws SQLException {
      try {
         super.preForAll(methodObject26893, this, arg0, arg1);
         this.delegate.setNClobAtName(arg0, arg1 instanceof _Proxy_ ? (NClob)((_Proxy_)arg1)._getDelegate_() : arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject26893, var4);
      }
   }

   public void setORAData(int arg0, ORAData arg1) throws SQLException {
      try {
         super.preForAll(methodObject26927, this, arg0, arg1);
         this.delegate.setORAData(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject26927, var4);
      }
   }

   public void setByte(int arg0, byte arg1) throws SQLException {
      try {
         super.preForAll(methodObject26933, this, arg0, arg1);
         this.delegate.setByte(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject26933, var4);
      }
   }

   public void setDouble(int arg0, double arg1) throws SQLException {
      try {
         super.preForAll(methodObject26934, this, arg0, arg1);
         this.delegate.setDouble(arg0, arg1);
      } catch (SQLException var5) {
         this.onErrorVoidForAll(methodObject26934, var5);
      }
   }

   public void setNCharacterStreamAtName(String arg0, Reader arg1, long arg2) throws SQLException {
      try {
         super.preForSetStreams(methodObject26816, this, arg0, arg1, arg2);
         this.delegate.setNCharacterStreamAtName(arg0, arg1, arg2);
      } catch (SQLException var6) {
         this.onErrorVoidForAll(methodObject26816, var6);
      }
   }

   public void setNull(int arg0, int arg1) throws SQLException {
      try {
         super.preForAll(methodObject26981, this, arg0, arg1);
         this.delegate.setNull(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject26981, var4);
      }
   }

   public void setRowPrefetch(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject27040, this, arg0);
         this.delegate.setRowPrefetch(arg0);
      } catch (SQLException var3) {
         this.onErrorVoidForAll(methodObject27040, var3);
      }
   }

   public int executeUpdate(String arg0) throws SQLException {
      try {
         super.preForExecuteUpdate(methodObject26995, this, arg0);
         return this.postForExecuteUpdate(methodObject26995, this.delegate.executeUpdate(arg0));
      } catch (SQLException var3) {
         return this.postForExecuteUpdate(methodObject26995, (Integer)this.onErrorForAll(methodObject26995, var3));
      }
   }

   public boolean isPoolable() throws SQLException {
      try {
         super.preForAll(methodObject27018, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject27018, this.delegate.isPoolable());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject27018, this.onErrorForAll(methodObject27018, var2));
      }
   }

   public void setROWIDAtName(String arg0, ROWID arg1) throws SQLException {
      try {
         super.preForAll(methodObject26844, this, arg0, arg1);
         this.delegate.setROWIDAtName(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject26844, var4);
      }
   }

   public void setTimestamp(int arg0, Timestamp arg1) throws SQLException {
      try {
         super.preForAll(methodObject26939, this, arg0, arg1);
         this.delegate.setTimestamp(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject26939, var4);
      }
   }

   public void setNString(int arg0, String arg1) throws SQLException {
      try {
         super.preForAll(methodObject26980, this, arg0, arg1);
         this.delegate.setNString(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject26980, var4);
      }
   }

   public void defineColumnType(int arg0, int arg1) throws SQLException {
      try {
         super.preForAll(methodObject27033, this, arg0, arg1);
         this.delegate.defineColumnType(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject27033, var4);
      }
   }

   public void setObjectAtName(String arg0, Object arg1, int arg2, int arg3) throws SQLException {
      try {
         super.preForSetObjects(methodObject26819, this, arg0, arg1, arg2, arg3);
         this.delegate.setObjectAtName(arg0, arg1 instanceof _Proxy_ ? (Object)((_Proxy_)arg1)._getDelegate_() : arg1, arg2, arg3);
      } catch (SQLException var6) {
         this.onErrorVoidForAll(methodObject26819, var6);
      }
   }

   public void setUnicodeStream(int arg0, InputStream arg1, int arg2) throws SQLException {
      try {
         super.preForAll(methodObject26955, this, arg0, arg1, arg2);
         this.delegate.setUnicodeStream(arg0, arg1, arg2);
      } catch (SQLException var5) {
         this.onErrorVoidForAll(methodObject26955, var5);
      }
   }

   public void setTime(int arg0, Time arg1, Calendar arg2) throws SQLException {
      try {
         super.preForAll(methodObject26964, this, arg0, arg1, arg2);
         this.delegate.setTime(arg0, arg1, arg2);
      } catch (SQLException var5) {
         this.onErrorVoidForAll(methodObject26964, var5);
      }
   }

   public int getUpdateCount() throws SQLException {
      try {
         super.preForAll(methodObject27016, this, zeroLengthObjectArray);
         return (Integer)this.postForAll(methodObject27016, this.delegate.getUpdateCount());
      } catch (SQLException var2) {
         return (Integer)this.postForAll(methodObject27016, this.onErrorForAll(methodObject27016, var2));
      }
   }

   public void setDoubleAtName(String arg0, double arg1) throws SQLException {
      try {
         super.preForAll(methodObject26834, this, arg0, arg1);
         this.delegate.setDoubleAtName(arg0, arg1);
      } catch (SQLException var5) {
         this.onErrorVoidForAll(methodObject26834, var5);
      }
   }

   public void setObject(int arg0, Object arg1, int arg2, int arg3) throws SQLException {
      try {
         super.preForSetObjects(methodObject26959, this, arg0, arg1, arg2, arg3);
         this.delegate.setObject(arg0, arg1 instanceof _Proxy_ ? (Object)((_Proxy_)arg1)._getDelegate_() : arg1, arg2, arg3);
      } catch (SQLException var6) {
         this.onErrorVoidForAll(methodObject26959, var6);
      }
   }

   public boolean isCloseOnCompletion() throws SQLException {
      try {
         super.preForAll(methodObject27017, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject27017, this.delegate.isCloseOnCompletion());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject27017, this.onErrorForAll(methodObject27017, var2));
      }
   }

   public void setMaxFieldSize(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject27021, this, arg0);
         this.delegate.setMaxFieldSize(arg0);
      } catch (SQLException var3) {
         this.onErrorVoidForAll(methodObject27021, var3);
      }
   }

   public void setNStringAtName(String arg0, String arg1) throws SQLException {
      try {
         super.preForAll(methodObject26896, this, arg0, arg1);
         this.delegate.setNStringAtName(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject26896, var4);
      }
   }

   public void setARRAY(int arg0, ARRAY arg1) throws SQLException {
      try {
         super.preForAll(methodObject26922, this, arg0, arg1);
         this.delegate.setARRAY(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject26922, var4);
      }
   }

   public void setTIMESTAMPAtName(String arg0, TIMESTAMP arg1) throws SQLException {
      try {
         super.preForAll(methodObject26874, this, arg0, arg1);
         this.delegate.setTIMESTAMPAtName(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject26874, var4);
      }
   }

   public void setAsciiStreamAtName(String arg0, InputStream arg1, long arg2) throws SQLException {
      try {
         super.preForSetStreams(methodObject26809, this, arg0, arg1, arg2);
         this.delegate.setAsciiStreamAtName(arg0, arg1, arg2);
      } catch (SQLException var6) {
         this.onErrorVoidForAll(methodObject26809, var6);
      }
   }

   public void setBinaryStream(int arg0, InputStream arg1) throws SQLException {
      try {
         super.preForSetStreams(methodObject26949, this, arg0, arg1);
         this.delegate.setBinaryStream(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject26949, var4);
      }
   }

   public void setAsciiStreamAtName(String arg0, InputStream arg1) throws SQLException {
      try {
         super.preForSetStreams(methodObject26810, this, arg0, arg1);
         this.delegate.setAsciiStreamAtName(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject26810, var4);
      }
   }

   public int[] executeBatch() throws SQLException {
      try {
         super.preForExecuteBatch(methodObject26994, this, zeroLengthObjectArray);
         return (int[])this.postForAll(methodObject26994, (Object)this.delegate.executeBatch());
      } catch (SQLException var2) {
         return (int[])this.postForAll(methodObject26994, this.onErrorForAll(methodObject26994, var2));
      }
   }

   public int getResultSetType() throws SQLException {
      try {
         super.preForAll(methodObject27015, this, zeroLengthObjectArray);
         return (Integer)this.postForAll(methodObject27015, this.delegate.getResultSetType());
      } catch (SQLException var2) {
         return (Integer)this.postForAll(methodObject27015, this.onErrorForAll(methodObject27015, var2));
      }
   }

   public void setCLOBAtName(String arg0, CLOB arg1) throws SQLException {
      try {
         super.preForAll(methodObject26858, this, arg0, arg1);
         this.delegate.setCLOBAtName(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject26858, var4);
      }
   }

   public void setEscapeProcessing(boolean arg0) throws SQLException {
      try {
         super.preForAll(methodObject27020, this, arg0);
         this.delegate.setEscapeProcessing(arg0);
      } catch (SQLException var3) {
         this.onErrorVoidForAll(methodObject27020, var3);
      }
   }

   public int getResultSetHoldability() throws SQLException {
      try {
         super.preForAll(methodObject27004, this, zeroLengthObjectArray);
         return (Integer)this.postForAll(methodObject27004, this.delegate.getResultSetHoldability());
      } catch (SQLException var2) {
         return (Integer)this.postForAll(methodObject27004, this.onErrorForAll(methodObject27004, var2));
      }
   }

   public void setShortAtName(String arg0, short arg1) throws SQLException {
      try {
         super.preForAll(methodObject26830, this, arg0, arg1);
         this.delegate.setShortAtName(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject26830, var4);
      }
   }

   public void setClob(int arg0, Clob arg1) throws SQLException {
      try {
         super.preForAll(methodObject26974, this, arg0, arg1);
         this.delegate.setClob(arg0, arg1 instanceof _Proxy_ ? (Clob)((_Proxy_)arg1)._getDelegate_() : arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject26974, var4);
      }
   }

   public void defineParameterTypeBytes(int arg0, int arg1, int arg2) throws SQLException {
      try {
         super.preForAll(methodObject26822, this, arg0, arg1, arg2);
         this.delegate.defineParameterTypeBytes(arg0, arg1, arg2);
      } catch (SQLException var5) {
         this.onErrorVoidForAll(methodObject26822, var5);
      }
   }

   public void setBinaryDouble(int arg0, BINARY_DOUBLE arg1) throws SQLException {
      try {
         super.preForAll(methodObject26903, this, arg0, arg1);
         this.delegate.setBinaryDouble(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject26903, var4);
      }
   }

   public void setDATEAtName(String arg0, DATE arg1) throws SQLException {
      try {
         super.preForAll(methodObject26852, this, arg0, arg1);
         this.delegate.setDATEAtName(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject26852, var4);
      }
   }

   public void clearWarnings() throws SQLException {
      try {
         super.preForAll(methodObject27003, this, zeroLengthObjectArray);
         this.delegate.clearWarnings();
      } catch (SQLException var2) {
         this.onErrorVoidForAll(methodObject27003, var2);
      }
   }

   public void setCHAR(int arg0, CHAR arg1) throws SQLException {
      try {
         super.preForAll(methodObject26910, this, arg0, arg1);
         this.delegate.setCHAR(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject26910, var4);
      }
   }

   public OracleParameterMetaData OracleGetParameterMetaData() throws SQLException {
      try {
         super.preForAll(methodObject26888, this, zeroLengthObjectArray);
         return (OracleParameterMetaData)this.postForAll(methodObject26888, this.proxyFactory.proxyForCache((Object)this.delegate.OracleGetParameterMetaData(), this, this.proxyCache, methodObject26888));
      } catch (SQLException var2) {
         return (OracleParameterMetaData)this.postForAll(methodObject26888, this.onErrorForAll(methodObject26888, var2));
      }
   }

   public void setBfile(int arg0, BFILE arg1) throws SQLException {
      try {
         super.preForAll(methodObject26916, this, arg0, arg1);
         this.delegate.setBfile(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject26916, var4);
      }
   }

   public void defineParameterType(int arg0, int arg1, int arg2) throws SQLException {
      try {
         super.preForAll(methodObject26824, this, arg0, arg1, arg2);
         this.delegate.defineParameterType(arg0, arg1, arg2);
      } catch (SQLException var5) {
         this.onErrorVoidForAll(methodObject26824, var5);
      }
   }

   public void setCustomDatum(int arg0, CustomDatum arg1) throws SQLException {
      try {
         super.preForAll(methodObject26926, this, arg0, arg1);
         this.delegate.setCustomDatum(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject26926, var4);
      }
   }

   public ResultSetMetaData getMetaData() throws SQLException {
      try {
         super.preForAll(methodObject26961, this, zeroLengthObjectArray);
         return (ResultSetMetaData)this.postForAll(methodObject26961, this.proxyFactory.proxyForCreate((Object)this.delegate.getMetaData(), this, this.proxyCache, methodObject26961));
      } catch (SQLException var2) {
         return (ResultSetMetaData)this.postForAll(methodObject26961, this.onErrorForAll(methodObject26961, var2));
      }
   }

   public void setSQLXMLAtName(String arg0, SQLXML arg1) throws SQLException {
      try {
         super.preForAll(methodObject26898, this, arg0, arg1);
         this.delegate.setSQLXMLAtName(arg0, arg1 instanceof _Proxy_ ? (SQLXML)((_Proxy_)arg1)._getDelegate_() : arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject26898, var4);
      }
   }

   public void setPoolable(boolean arg0) throws SQLException {
      try {
         super.preForAll(methodObject27023, this, arg0);
         this.delegate.setPoolable(arg0);
      } catch (SQLException var3) {
         this.onErrorVoidForAll(methodObject27023, var3);
      }
   }

   public boolean isClosed() throws SQLException {
      try {
         super.preForAll(methodObject26999, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject26999, this.delegate.isClosed());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject26999, this.onErrorForAll(methodObject26999, var2));
      }
   }

   public void setTimestampAtName(String arg0, Timestamp arg1) throws SQLException {
      try {
         super.preForAll(methodObject26870, this, arg0, arg1);
         this.delegate.setTimestampAtName(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject26870, var4);
      }
   }

   public void setBLOBAtName(String arg0, BLOB arg1) throws SQLException {
      try {
         super.preForAll(methodObject26854, this, arg0, arg1);
         this.delegate.setBLOBAtName(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject26854, var4);
      }
   }

   public int sendBatch() throws SQLException {
      try {
         super.preForAll(methodObject26931, this, zeroLengthObjectArray);
         return (Integer)this.postForAll(methodObject26931, this.delegate.sendBatch());
      } catch (SQLException var2) {
         return (Integer)this.postForAll(methodObject26931, this.onErrorForAll(methodObject26931, var2));
      }
   }

   public void defineColumnType(int arg0, int arg1, String arg2) throws SQLException {
      try {
         super.preForAll(methodObject27036, this, arg0, arg1, arg2);
         this.delegate.defineColumnType(arg0, arg1, arg2);
      } catch (SQLException var5) {
         this.onErrorVoidForAll(methodObject27036, var5);
      }
   }

   public ResultSet getGeneratedKeys() throws SQLException {
      try {
         super.preForAll(methodObject27008, this, zeroLengthObjectArray);
         return (ResultSet)this.postForAll(methodObject27008, this.proxyFactory.proxyForCache((Object)this.delegate.getGeneratedKeys(), this, this.proxyCache, methodObject27008));
      } catch (SQLException var2) {
         return (ResultSet)this.postForAll(methodObject27008, this.onErrorForAll(methodObject27008, var2));
      }
   }

   public void setCharacterStream(int arg0, Reader arg1) throws SQLException {
      try {
         super.preForSetStreams(methodObject26952, this, arg0, arg1);
         this.delegate.setCharacterStream(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject26952, var4);
      }
   }

   public int getRowPrefetch() {
      super.preForAll(methodObject27039, this, zeroLengthObjectArray);
      return (Integer)this.postForAll(methodObject27039, this.delegate.getRowPrefetch());
   }

   public void setClob(int arg0, Reader arg1, long arg2) throws SQLException {
      try {
         super.preForAll(methodObject26975, this, arg0, arg1, arg2);
         this.delegate.setClob(arg0, arg1, arg2);
      } catch (SQLException var6) {
         this.onErrorVoidForAll(methodObject26975, var6);
      }
   }

   public boolean execute(String arg0, String[] arg1) throws SQLException {
      try {
         super.preForExecute(methodObject26991, this, arg0, arg1);
         return this.postForExecute(methodObject26991, this.delegate.execute(arg0, arg1));
      } catch (SQLException var4) {
         return this.postForExecute(methodObject26991, this.onErrorForExecute(methodObject26991, var4));
      }
   }

   public void setAsciiStreamAtName(String arg0, InputStream arg1, int arg2) throws SQLException {
      try {
         super.preForSetStreams(methodObject26808, this, arg0, arg1, arg2);
         this.delegate.setAsciiStreamAtName(arg0, arg1, arg2);
      } catch (SQLException var5) {
         this.onErrorVoidForAll(methodObject26808, var5);
      }
   }

   public void closeOnCompletion() throws SQLException {
      try {
         super.preForAll(methodObject27007, this, zeroLengthObjectArray);
         this.delegate.closeOnCompletion();
      } catch (SQLException var2) {
         this.onErrorVoidForAll(methodObject27007, var2);
      }
   }

   public void setBinaryFloatAtName(String arg0, float arg1) throws SQLException {
      try {
         super.preForAll(methodObject26835, this, arg0, arg1);
         this.delegate.setBinaryFloatAtName(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject26835, var4);
      }
   }

   public int getFetchDirection() throws SQLException {
      try {
         super.preForAll(methodObject27025, this, zeroLengthObjectArray);
         return (Integer)this.postForAll(methodObject27025, this.delegate.getFetchDirection());
      } catch (SQLException var2) {
         return (Integer)this.postForAll(methodObject27025, this.onErrorForAll(methodObject27025, var2));
      }
   }

   public void setDATE(int arg0, DATE arg1) throws SQLException {
      try {
         super.preForAll(methodObject26911, this, arg0, arg1);
         this.delegate.setDATE(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject26911, var4);
      }
   }

   public void setBlob(int arg0, Blob arg1) throws SQLException {
      try {
         super.preForAll(methodObject26971, this, arg0, arg1);
         this.delegate.setBlob(arg0, arg1 instanceof _Proxy_ ? (Blob)((_Proxy_)arg1)._getDelegate_() : arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject26971, var4);
      }
   }

   public void setBlob(int arg0, InputStream arg1, long arg2) throws SQLException {
      try {
         super.preForAll(methodObject26972, this, arg0, arg1, arg2);
         this.delegate.setBlob(arg0, arg1, arg2);
      } catch (SQLException var6) {
         this.onErrorVoidForAll(methodObject26972, var6);
      }
   }

   public void setBinaryDoubleAtName(String arg0, BINARY_DOUBLE arg1) throws SQLException {
      try {
         super.preForAll(methodObject26838, this, arg0, arg1);
         this.delegate.setBinaryDoubleAtName(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject26838, var4);
      }
   }

   public void setCharacterStream(int arg0, Reader arg1, long arg2) throws SQLException {
      try {
         super.preForSetStreams(methodObject26951, this, arg0, arg1, arg2);
         this.delegate.setCharacterStream(arg0, arg1, arg2);
      } catch (SQLException var6) {
         this.onErrorVoidForAll(methodObject26951, var6);
      }
   }

   public void setLongAtName(String arg0, long arg1) throws SQLException {
      try {
         super.preForAll(methodObject26832, this, arg0, arg1);
         this.delegate.setLongAtName(arg0, arg1);
      } catch (SQLException var5) {
         this.onErrorVoidForAll(methodObject26832, var5);
      }
   }

   public void setBoolean(int arg0, boolean arg1) throws SQLException {
      try {
         super.preForAll(methodObject26932, this, arg0, arg1);
         this.delegate.setBoolean(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject26932, var4);
      }
   }

   public void setPlsqlIndexTable(int arg0, Object arg1, int arg2, int arg3, int arg4, int arg5) throws SQLException {
      try {
         super.preForAll(methodObject26885, this, arg0, arg1, arg2, arg3, arg4, arg5);
         this.delegate.setPlsqlIndexTable(arg0, arg1 instanceof _Proxy_ ? (Object)((_Proxy_)arg1)._getDelegate_() : arg1, arg2, arg3, arg4, arg5);
      } catch (SQLException var8) {
         this.onErrorVoidForAll(methodObject26885, var8);
      }
   }

   public void setClobAtName(String arg0, Reader arg1, long arg2) throws SQLException {
      try {
         super.preForAll(methodObject26860, this, arg0, arg1, arg2);
         this.delegate.setClobAtName(arg0, arg1, arg2);
      } catch (SQLException var6) {
         this.onErrorVoidForAll(methodObject26860, var6);
      }
   }

   public void setStringAtName(String arg0, String arg1) throws SQLException {
      try {
         super.preForAll(methodObject26840, this, arg0, arg1);
         this.delegate.setStringAtName(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject26840, var4);
      }
   }

   public void setBinaryDouble(int arg0, double arg1) throws SQLException {
      try {
         super.preForAll(methodObject26902, this, arg0, arg1);
         this.delegate.setBinaryDouble(arg0, arg1);
      } catch (SQLException var5) {
         this.onErrorVoidForAll(methodObject26902, var5);
      }
   }

   public void setSTRUCT(int arg0, STRUCT arg1) throws SQLException {
      try {
         super.preForAll(methodObject26925, this, arg0, arg1);
         this.delegate.setSTRUCT(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject26925, var4);
      }
   }

   public void setBinaryDoubleAtName(String arg0, double arg1) throws SQLException {
      try {
         super.preForAll(methodObject26837, this, arg0, arg1);
         this.delegate.setBinaryDoubleAtName(arg0, arg1);
      } catch (SQLException var5) {
         this.onErrorVoidForAll(methodObject26837, var5);
      }
   }

   public void setObjectAtName(String arg0, Object arg1) throws SQLException {
      try {
         super.preForSetObjects(methodObject26821, this, arg0, arg1);
         this.delegate.setObjectAtName(arg0, arg1 instanceof _Proxy_ ? (Object)((_Proxy_)arg1)._getDelegate_() : arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject26821, var4);
      }
   }

   public void setOracleObject(int arg0, Datum arg1) throws SQLException {
      try {
         super.preForAll(methodObject26930, this, arg0, arg1);
         this.delegate.setOracleObject(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject26930, var4);
      }
   }

   public void setObjectAtName(String arg0, Object arg1, int arg2) throws SQLException {
      try {
         super.preForSetObjects(methodObject26820, this, arg0, arg1, arg2);
         this.delegate.setObjectAtName(arg0, arg1 instanceof _Proxy_ ? (Object)((_Proxy_)arg1)._getDelegate_() : arg1, arg2);
      } catch (SQLException var5) {
         this.onErrorVoidForAll(methodObject26820, var5);
      }
   }

   public void setRefType(int arg0, REF arg1) throws SQLException {
      try {
         super.preForAll(methodObject26928, this, arg0, arg1);
         this.delegate.setRefType(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject26928, var4);
      }
   }

   public void setBinaryStreamAtName(String arg0, InputStream arg1, long arg2) throws SQLException {
      try {
         super.preForSetStreams(methodObject26812, this, arg0, arg1, arg2);
         this.delegate.setBinaryStreamAtName(arg0, arg1, arg2);
      } catch (SQLException var6) {
         this.onErrorVoidForAll(methodObject26812, var6);
      }
   }

   public void setRAW(int arg0, RAW arg1) throws SQLException {
      try {
         super.preForAll(methodObject26909, this, arg0, arg1);
         this.delegate.setRAW(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject26909, var4);
      }
   }

   public void setRefAtName(String arg0, Ref arg1) throws SQLException {
      try {
         super.preForAll(methodObject26880, this, arg0, arg1);
         this.delegate.setRefAtName(arg0, arg1 instanceof _Proxy_ ? (Ref)((_Proxy_)arg1)._getDelegate_() : arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject26880, var4);
      }
   }

   public void setBlob(int arg0, InputStream arg1) throws SQLException {
      try {
         super.preForAll(methodObject26973, this, arg0, arg1);
         this.delegate.setBlob(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject26973, var4);
      }
   }

   public void clearDefines() throws SQLException {
      try {
         super.preForAll(methodObject27032, this, zeroLengthObjectArray);
         this.delegate.clearDefines();
      } catch (SQLException var2) {
         this.onErrorVoidForAll(methodObject27032, var2);
      }
   }

   public ResultSet getReturnResultSet() throws SQLException {
      try {
         super.preForAll(methodObject26892, this, zeroLengthObjectArray);
         return (ResultSet)this.postForAll(methodObject26892, this.proxyFactory.proxyForCache((Object)this.delegate.getReturnResultSet(), this, this.proxyCache, methodObject26892));
      } catch (SQLException var2) {
         return (ResultSet)this.postForAll(methodObject26892, this.onErrorForAll(methodObject26892, var2));
      }
   }

   public void setINTERVALYMAtName(String arg0, INTERVALYM arg1) throws SQLException {
      try {
         super.preForAll(methodObject26872, this, arg0, arg1);
         this.delegate.setINTERVALYMAtName(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject26872, var4);
      }
   }

   public void setBytesAtName(String arg0, byte[] arg1) throws SQLException {
      try {
         super.preForAll(methodObject26864, this, arg0, arg1);
         this.delegate.setBytesAtName(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject26864, var4);
      }
   }

   public void setBytesForBlob(int arg0, byte[] arg1) throws SQLException {
      try {
         super.preForAll(methodObject26905, this, arg0, arg1);
         this.delegate.setBytesForBlob(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject26905, var4);
      }
   }

   public void setIntAtName(String arg0, int arg1) throws SQLException {
      try {
         super.preForAll(methodObject26831, this, arg0, arg1);
         this.delegate.setIntAtName(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject26831, var4);
      }
   }

   public void setBinaryFloat(int arg0, float arg1) throws SQLException {
      try {
         super.preForAll(methodObject26900, this, arg0, arg1);
         this.delegate.setBinaryFloat(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject26900, var4);
      }
   }

   public void setRAWAtName(String arg0, RAW arg1) throws SQLException {
      try {
         super.preForAll(methodObject26850, this, arg0, arg1);
         this.delegate.setRAWAtName(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject26850, var4);
      }
   }

   public void setREF(int arg0, REF arg1) throws SQLException {
      try {
         super.preForAll(methodObject26929, this, arg0, arg1);
         this.delegate.setREF(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject26929, var4);
      }
   }

   public void setAsciiStream(int arg0, InputStream arg1) throws SQLException {
      try {
         super.preForSetStreams(methodObject26946, this, arg0, arg1);
         this.delegate.setAsciiStream(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject26946, var4);
      }
   }

   public void setStructDescriptorAtName(String arg0, StructDescriptor arg1) throws SQLException {
      try {
         super.preForAll(methodObject26848, this, arg0, arg1);
         this.delegate.setStructDescriptorAtName(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject26848, var4);
      }
   }

   public void setCursor(int arg0, ResultSet arg1) throws SQLException {
      try {
         super.preForAll(methodObject26907, this, arg0, arg1);
         this.delegate.setCursor(arg0, arg1 instanceof _Proxy_ ? (ResultSet)((_Proxy_)arg1)._getDelegate_() : arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject26907, var4);
      }
   }

   public void setNullAtName(String arg0, int arg1) throws SQLException {
      try {
         super.preForAll(methodObject26827, this, arg0, arg1);
         this.delegate.setNullAtName(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject26827, var4);
      }
   }

   public Object unwrap(Class arg0) throws SQLException {
      try {
         super.preForAll(methodObject27029, this, arg0);
         return this.postForAll(methodObject27029, super.unwrap(arg0));
      } catch (SQLException var3) {
         return this.postForAll(methodObject27029, this.onErrorForAll(methodObject27029, var3));
      }
   }

   public void addBatch(String arg0) throws SQLException {
      try {
         super.preForAll(methodObject27005, this, arg0);
         this.delegate.addBatch(arg0);
      } catch (SQLException var3) {
         this.onErrorVoidForAll(methodObject27005, var3);
      }
   }

   public int getResultSetConcurrency() throws SQLException {
      try {
         super.preForAll(methodObject27014, this, zeroLengthObjectArray);
         return (Integer)this.postForAll(methodObject27014, this.delegate.getResultSetConcurrency());
      } catch (SQLException var2) {
         return (Integer)this.postForAll(methodObject27014, this.onErrorForAll(methodObject27014, var2));
      }
   }

   public void registerReturnParameter(int arg0, int arg1, int arg2) throws SQLException {
      try {
         super.preForAll(methodObject26890, this, arg0, arg1, arg2);
         this.delegate.registerReturnParameter(arg0, arg1, arg2);
      } catch (SQLException var5) {
         this.onErrorVoidForAll(methodObject26890, var5);
      }
   }

   public void setTimestampAtName(String arg0, Timestamp arg1, Calendar arg2) throws SQLException {
      try {
         super.preForAll(methodObject26871, this, arg0, arg1, arg2);
         this.delegate.setTimestampAtName(arg0, arg1, arg2);
      } catch (SQLException var5) {
         this.onErrorVoidForAll(methodObject26871, var5);
      }
   }

   public void setBlobAtName(String arg0, Blob arg1) throws SQLException {
      try {
         super.preForAll(methodObject26855, this, arg0, arg1);
         this.delegate.setBlobAtName(arg0, arg1 instanceof _Proxy_ ? (Blob)((_Proxy_)arg1)._getDelegate_() : arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject26855, var4);
      }
   }

   public void setObject(int arg0, Object arg1, int arg2) throws SQLException {
      try {
         super.preForSetObjects(methodObject26957, this, arg0, arg1, arg2);
         this.delegate.setObject(arg0, arg1 instanceof _Proxy_ ? (Object)((_Proxy_)arg1)._getDelegate_() : arg1, arg2);
      } catch (SQLException var5) {
         this.onErrorVoidForAll(methodObject26957, var5);
      }
   }

   public void registerReturnParameter(int arg0, int arg1) throws SQLException {
      try {
         super.preForAll(methodObject26889, this, arg0, arg1);
         this.delegate.registerReturnParameter(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject26889, var4);
      }
   }

   public void setTimeAtName(String arg0, Time arg1) throws SQLException {
      try {
         super.preForAll(methodObject26868, this, arg0, arg1);
         this.delegate.setTimeAtName(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject26868, var4);
      }
   }

   public void setOPAQUE(int arg0, OPAQUE arg1) throws SQLException {
      try {
         super.preForAll(methodObject26923, this, arg0, arg1);
         this.delegate.setOPAQUE(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject26923, var4);
      }
   }

   public void setObject(int arg0, Object arg1) throws SQLException {
      try {
         super.preForSetObjects(methodObject26958, this, arg0, arg1);
         this.delegate.setObject(arg0, arg1 instanceof _Proxy_ ? (Object)((_Proxy_)arg1)._getDelegate_() : arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject26958, var4);
      }
   }

   public void setNullAtName(String arg0, int arg1, String arg2) throws SQLException {
      try {
         super.preForAll(methodObject26826, this, arg0, arg1, arg2);
         this.delegate.setNullAtName(arg0, arg1, arg2);
      } catch (SQLException var5) {
         this.onErrorVoidForAll(methodObject26826, var5);
      }
   }

   public void setRef(int arg0, Ref arg1) throws SQLException {
      try {
         super.preForAll(methodObject26986, this, arg0, arg1);
         this.delegate.setRef(arg0, arg1 instanceof _Proxy_ ? (Ref)((_Proxy_)arg1)._getDelegate_() : arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject26986, var4);
      }
   }

   public void setBFILEAtName(String arg0, BFILE arg1) throws SQLException {
      try {
         super.preForAll(methodObject26862, this, arg0, arg1);
         this.delegate.setBFILEAtName(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject26862, var4);
      }
   }

   public void cancel() throws SQLException {
      try {
         super.preForAll(methodObject26992, this, zeroLengthObjectArray);
         this.delegate.cancel();
      } catch (SQLException var2) {
         this.onErrorVoidForAll(methodObject26992, var2);
      }
   }

   public void setExecuteBatch(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject26899, this, arg0);
         this.delegate.setExecuteBatch(arg0);
      } catch (SQLException var3) {
         this.onErrorVoidForAll(methodObject26899, var3);
      }
   }

   public void setBinaryFloatAtName(String arg0, BINARY_FLOAT arg1) throws SQLException {
      try {
         super.preForAll(methodObject26836, this, arg0, arg1);
         this.delegate.setBinaryFloatAtName(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject26836, var4);
      }
   }

   public void setQueryTimeout(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject27024, this, arg0);
         this.delegate.setQueryTimeout(arg0);
      } catch (SQLException var3) {
         this.onErrorVoidForAll(methodObject27024, var3);
      }
   }

   public ResultSet getResultSet() throws SQLException {
      try {
         super.preForAll(methodObject26993, this, zeroLengthObjectArray);
         return (ResultSet)this.postForAll(methodObject26993, this.proxyFactory.proxyForCache((Object)this.delegate.getResultSet(), this, this.proxyCache, methodObject26993));
      } catch (SQLException var2) {
         return (ResultSet)this.postForAll(methodObject26993, this.onErrorForAll(methodObject26993, var2));
      }
   }

   public void setLobPrefetchSize(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject27042, this, arg0);
         this.delegate.setLobPrefetchSize(arg0);
      } catch (SQLException var3) {
         this.onErrorVoidForAll(methodObject27042, var3);
      }
   }

   public void closeWithKey(String arg0) throws SQLException {
      try {
         super.preForAll(methodObject27043, this, arg0);
         this.delegate.closeWithKey(arg0);
      } catch (SQLException var3) {
         this.onErrorVoidForAll(methodObject27043, var3);
      }
   }

   public void defineColumnType(int arg0, int arg1, int arg2, short arg3) throws SQLException {
      try {
         super.preForAll(methodObject27035, this, arg0, arg1, arg2, arg3);
         this.delegate.defineColumnType(arg0, arg1, arg2, arg3);
      } catch (SQLException var6) {
         this.onErrorVoidForAll(methodObject27035, var6);
      }
   }

   public void setBfileAtName(String arg0, BFILE arg1) throws SQLException {
      try {
         super.preForAll(methodObject26863, this, arg0, arg1);
         this.delegate.setBfileAtName(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject26863, var4);
      }
   }

   public void setTIMESTAMPTZAtName(String arg0, TIMESTAMPTZ arg1) throws SQLException {
      try {
         super.preForAll(methodObject26875, this, arg0, arg1);
         this.delegate.setTIMESTAMPTZAtName(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject26875, var4);
      }
   }

   public void setNCharacterStream(int arg0, Reader arg1, long arg2) throws SQLException {
      try {
         super.preForSetStreams(methodObject26953, this, arg0, arg1, arg2);
         this.delegate.setNCharacterStream(arg0, arg1, arg2);
      } catch (SQLException var6) {
         this.onErrorVoidForAll(methodObject26953, var6);
      }
   }

   public void setTIMESTAMPLTZ(int arg0, TIMESTAMPLTZ arg1) throws SQLException {
      try {
         super.preForAll(methodObject26921, this, arg0, arg1);
         this.delegate.setTIMESTAMPLTZ(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject26921, var4);
      }
   }

   public void defineColumnType(int arg0, int arg1, int arg2) throws SQLException {
      try {
         super.preForAll(methodObject27034, this, arg0, arg1, arg2);
         this.delegate.defineColumnType(arg0, arg1, arg2);
      } catch (SQLException var5) {
         this.onErrorVoidForAll(methodObject27034, var5);
      }
   }

   public long getRegisteredQueryId() throws SQLException {
      try {
         super.preForAll(methodObject27047, this, zeroLengthObjectArray);
         return (Long)this.postForAll(methodObject27047, this.delegate.getRegisteredQueryId());
      } catch (SQLException var2) {
         return (Long)this.postForAll(methodObject27047, this.onErrorForAll(methodObject27047, var2));
      }
   }

   public void setNClob(int arg0, NClob arg1) throws SQLException {
      try {
         super.preForAll(methodObject26977, this, arg0, arg1);
         this.delegate.setNClob(arg0, arg1 instanceof _Proxy_ ? (NClob)((_Proxy_)arg1)._getDelegate_() : arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject26977, var4);
      }
   }

   public void setDateAtName(String arg0, Date arg1) throws SQLException {
      try {
         super.preForAll(methodObject26866, this, arg0, arg1);
         this.delegate.setDateAtName(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject26866, var4);
      }
   }

   public void setFixedCHAR(int arg0, String arg1) throws SQLException {
      try {
         super.preForAll(methodObject26906, this, arg0, arg1);
         this.delegate.setFixedCHAR(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject26906, var4);
      }
   }

   public boolean execute(String arg0, int[] arg1) throws SQLException {
      try {
         super.preForExecute(methodObject26990, this, arg0, arg1);
         return this.postForExecute(methodObject26990, this.delegate.execute(arg0, arg1));
      } catch (SQLException var4) {
         return this.postForExecute(methodObject26990, this.onErrorForExecute(methodObject26990, var4));
      }
   }

   public void setINTERVALDSAtName(String arg0, INTERVALDS arg1) throws SQLException {
      try {
         super.preForAll(methodObject26873, this, arg0, arg1);
         this.delegate.setINTERVALDSAtName(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject26873, var4);
      }
   }

   public void setDate(int arg0, Date arg1) throws SQLException {
      try {
         super.preForAll(methodObject26965, this, arg0, arg1);
         this.delegate.setDate(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject26965, var4);
      }
   }

   public boolean getMoreResults() throws SQLException {
      try {
         super.preForAll(methodObject27011, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject27011, this.delegate.getMoreResults());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject27011, this.onErrorForAll(methodObject27011, var2));
      }
   }

   public int executeUpdate(String arg0, int arg1) throws SQLException {
      try {
         super.preForExecuteUpdate(methodObject26996, this, arg0, arg1);
         return this.postForExecuteUpdate(methodObject26996, this.delegate.executeUpdate(arg0, arg1));
      } catch (SQLException var4) {
         return this.postForExecuteUpdate(methodObject26996, (Integer)this.onErrorForAll(methodObject26996, var4));
      }
   }

   public void setByteAtName(String arg0, byte arg1) throws SQLException {
      try {
         super.preForAll(methodObject26829, this, arg0, arg1);
         this.delegate.setByteAtName(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject26829, var4);
      }
   }

   public void setDateAtName(String arg0, Date arg1, Calendar arg2) throws SQLException {
      try {
         super.preForAll(methodObject26867, this, arg0, arg1, arg2);
         this.delegate.setDateAtName(arg0, arg1, arg2);
      } catch (SQLException var5) {
         this.onErrorVoidForAll(methodObject26867, var5);
      }
   }

   public void setBytesForBlobAtName(String arg0, byte[] arg1) throws SQLException {
      try {
         super.preForAll(methodObject26865, this, arg0, arg1);
         this.delegate.setBytesForBlobAtName(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject26865, var4);
      }
   }

   public void setCursorAtName(String arg0, ResultSet arg1) throws SQLException {
      try {
         super.preForAll(methodObject26843, this, arg0, arg1);
         this.delegate.setCursorAtName(arg0, arg1 instanceof _Proxy_ ? (ResultSet)((_Proxy_)arg1)._getDelegate_() : arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject26843, var4);
      }
   }

   public ResultSet executeQuery(String arg0) throws SQLException {
      try {
         super.preForAll(methodObject27000, this, arg0);
         return this.postForExecuteQuery(methodObject27000, (ResultSet)this.proxyFactory.proxyForCreateCache((Object)this.delegate.executeQuery(arg0), this, this.proxyCache, methodObject27000));
      } catch (SQLException var3) {
         return this.postForExecuteQuery(methodObject27000, (ResultSet)this.onErrorForAll(methodObject27000, var3));
      }
   }

   public void setRowIdAtName(String arg0, RowId arg1) throws SQLException {
      try {
         super.preForAll(methodObject26897, this, arg0, arg1);
         this.delegate.setRowIdAtName(arg0, arg1 instanceof _Proxy_ ? (RowId)((_Proxy_)arg1)._getDelegate_() : arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject26897, var4);
      }
   }

   public void setFloat(int arg0, float arg1) throws SQLException {
      try {
         super.preForAll(methodObject26935, this, arg0, arg1);
         this.delegate.setFloat(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject26935, var4);
      }
   }

   public void setBFILE(int arg0, BFILE arg1) throws SQLException {
      try {
         super.preForAll(methodObject26915, this, arg0, arg1);
         this.delegate.setBFILE(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject26915, var4);
      }
   }

   public void setSQLXML(int arg0, SQLXML arg1) throws SQLException {
      try {
         super.preForAll(methodObject26984, this, arg0, arg1);
         this.delegate.setSQLXML(arg0, arg1 instanceof _Proxy_ ? (SQLXML)((_Proxy_)arg1)._getDelegate_() : arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject26984, var4);
      }
   }

   public void setRefTypeAtName(String arg0, REF arg1) throws SQLException {
      try {
         super.preForAll(methodObject26879, this, arg0, arg1);
         this.delegate.setRefTypeAtName(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject26879, var4);
      }
   }

   public void setUnicodeStreamAtName(String arg0, InputStream arg1, int arg2) throws SQLException {
      try {
         super.preForAll(methodObject26818, this, arg0, arg1, arg2);
         this.delegate.setUnicodeStreamAtName(arg0, arg1, arg2);
      } catch (SQLException var5) {
         this.onErrorVoidForAll(methodObject26818, var5);
      }
   }

   public int getMaxRows() throws SQLException {
      try {
         super.preForAll(methodObject27010, this, zeroLengthObjectArray);
         return (Integer)this.postForAll(methodObject27010, this.delegate.getMaxRows());
      } catch (SQLException var2) {
         return (Integer)this.postForAll(methodObject27010, this.onErrorForAll(methodObject27010, var2));
      }
   }

   public void setStructDescriptor(int arg0, StructDescriptor arg1) throws SQLException {
      try {
         super.preForAll(methodObject26924, this, arg0, arg1);
         this.delegate.setStructDescriptor(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject26924, var4);
      }
   }

   public void setString(int arg0, String arg1) throws SQLException {
      try {
         super.preForAll(methodObject26967, this, arg0, arg1);
         this.delegate.setString(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject26967, var4);
      }
   }

   public void addBatch() throws SQLException {
      try {
         super.preForAll(methodObject26968, this, zeroLengthObjectArray);
         this.delegate.addBatch();
      } catch (SQLException var2) {
         this.onErrorVoidForAll(methodObject26968, var2);
      }
   }

   public int executeUpdate(String arg0, String[] arg1) throws SQLException {
      try {
         super.preForExecuteUpdate(methodObject26998, this, arg0, arg1);
         return this.postForExecuteUpdate(methodObject26998, this.delegate.executeUpdate(arg0, arg1));
      } catch (SQLException var4) {
         return this.postForExecuteUpdate(methodObject26998, (Integer)this.onErrorForAll(methodObject26998, var4));
      }
   }

   public void setDisableStmtCaching(boolean arg0) {
      super.preForAll(methodObject26887, this, arg0);
      this.delegate.setDisableStmtCaching(arg0);
   }

   public void setBLOB(int arg0, BLOB arg1) throws SQLException {
      try {
         super.preForAll(methodObject26913, this, arg0, arg1);
         this.delegate.setBLOB(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject26913, var4);
      }
   }

   public int getQueryTimeout() throws SQLException {
      try {
         super.preForAll(methodObject27013, this, zeroLengthObjectArray);
         return (Integer)this.postForAll(methodObject27013, this.delegate.getQueryTimeout());
      } catch (SQLException var2) {
         return (Integer)this.postForAll(methodObject27013, this.onErrorForAll(methodObject27013, var2));
      }
   }

   public void setNClobAtName(String arg0, Reader arg1) throws SQLException {
      try {
         super.preForAll(methodObject26895, this, arg0, arg1);
         this.delegate.setNClobAtName(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject26895, var4);
      }
   }

   public boolean execute(String arg0, int arg1) throws SQLException {
      try {
         super.preForExecute(methodObject26989, this, arg0, arg1);
         return this.postForExecute(methodObject26989, this.delegate.execute(arg0, arg1));
      } catch (SQLException var4) {
         return this.postForExecute(methodObject26989, this.onErrorForExecute(methodObject26989, var4));
      }
   }

   public void setURL(int arg0, URL arg1) throws SQLException {
      try {
         super.preForAll(methodObject26941, this, arg0, arg1);
         this.delegate.setURL(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject26941, var4);
      }
   }

   public void setNClob(int arg0, Reader arg1) throws SQLException {
      try {
         super.preForAll(methodObject26979, this, arg0, arg1);
         this.delegate.setNClob(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject26979, var4);
      }
   }

   public void setStringForClobAtName(String arg0, String arg1) throws SQLException {
      try {
         super.preForAll(methodObject26841, this, arg0, arg1);
         this.delegate.setStringForClobAtName(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject26841, var4);
      }
   }

   public void setBigDecimal(int arg0, BigDecimal arg1) throws SQLException {
      try {
         super.preForAll(methodObject26970, this, arg0, arg1);
         this.delegate.setBigDecimal(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject26970, var4);
      }
   }

   public void setNull(int arg0, int arg1, String arg2) throws SQLException {
      try {
         super.preForAll(methodObject26982, this, arg0, arg1, arg2);
         this.delegate.setNull(arg0, arg1, arg2);
      } catch (SQLException var5) {
         this.onErrorVoidForAll(methodObject26982, var5);
      }
   }

   public void setClob(int arg0, Reader arg1) throws SQLException {
      try {
         super.preForAll(methodObject26976, this, arg0, arg1);
         this.delegate.setClob(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject26976, var4);
      }
   }

   public ResultSet executeQuery() throws SQLException {
      try {
         super.preForAll(methodObject26960, this, zeroLengthObjectArray);
         return this.postForExecuteQuery(methodObject26960, (ResultSet)this.proxyFactory.proxyForCreateCache((Object)this.delegate.executeQuery(), this, this.proxyCache, methodObject26960));
      } catch (SQLException var2) {
         return this.postForExecuteQuery(methodObject26960, (ResultSet)this.onErrorForAll(methodObject26960, var2));
      }
   }

   public void setBooleanAtName(String arg0, boolean arg1) throws SQLException {
      try {
         super.preForAll(methodObject26828, this, arg0, arg1);
         this.delegate.setBooleanAtName(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject26828, var4);
      }
   }

   public void registerReturnParameter(int arg0, int arg1, String arg2) throws SQLException {
      try {
         super.preForAll(methodObject26891, this, arg0, arg1, arg2);
         this.delegate.registerReturnParameter(arg0, arg1, arg2);
      } catch (SQLException var5) {
         this.onErrorVoidForAll(methodObject26891, var5);
      }
   }

   public void setFixedCHARAtName(String arg0, String arg1) throws SQLException {
      try {
         super.preForAll(methodObject26842, this, arg0, arg1);
         this.delegate.setFixedCHARAtName(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject26842, var4);
      }
   }

   public SQLWarning getWarnings() throws SQLException {
      try {
         super.preForAll(methodObject27002, this, zeroLengthObjectArray);
         return (SQLWarning)this.postForAll(methodObject27002, (Object)this.delegate.getWarnings());
      } catch (SQLException var2) {
         return (SQLWarning)this.postForAll(methodObject27002, this.onErrorForAll(methodObject27002, var2));
      }
   }

   public void setROWID(int arg0, ROWID arg1) throws SQLException {
      try {
         super.preForAll(methodObject26908, this, arg0, arg1);
         this.delegate.setROWID(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject26908, var4);
      }
   }

   public void setCheckBindTypes(boolean arg0) {
      super.preForAll(methodObject26884, this, arg0);
      this.delegate.setCheckBindTypes(arg0);
   }

   public void setTIMESTAMP(int arg0, TIMESTAMP arg1) throws SQLException {
      try {
         super.preForAll(methodObject26919, this, arg0, arg1);
         this.delegate.setTIMESTAMP(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject26919, var4);
      }
   }

   public Connection getConnection() throws SQLException {
      try {
         super.preForAll(methodObject27001, this, zeroLengthObjectArray);
         return (Connection)this.postForAll(methodObject27001, (Object)super.getConnection());
      } catch (SQLException var2) {
         return (Connection)this.postForAll(methodObject27001, this.onErrorForAll(methodObject27001, var2));
      }
   }

   public void setClobAtName(String arg0, Reader arg1) throws SQLException {
      try {
         super.preForAll(methodObject26861, this, arg0, arg1);
         this.delegate.setClobAtName(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject26861, var4);
      }
   }

   public int creationState() {
      super.preForAll(methodObject27044, this, zeroLengthObjectArray);
      return (Integer)this.postForAll(methodObject27044, this.delegate.creationState());
   }

   public void setMaxRows(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject27022, this, arg0);
         this.delegate.setMaxRows(arg0);
      } catch (SQLException var3) {
         this.onErrorVoidForAll(methodObject27022, var3);
      }
   }

   public void setFormOfUse(int arg0, short arg1) {
      super.preForAll(methodObject26886, this, arg0, arg1);
      this.delegate.setFormOfUse(arg0, arg1);
   }

   public boolean isNCHAR(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject27031, this, arg0);
         return (Boolean)this.postForAll(methodObject27031, this.delegate.isNCHAR(arg0));
      } catch (SQLException var3) {
         return (Boolean)this.postForAll(methodObject27031, this.onErrorForAll(methodObject27031, var3));
      }
   }

   public void setBlobAtName(String arg0, InputStream arg1) throws SQLException {
      try {
         super.preForAll(methodObject26857, this, arg0, arg1);
         this.delegate.setBlobAtName(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject26857, var4);
      }
   }

   public void close() throws SQLException {
      try {
         super.preForAll(methodObject26987, this, zeroLengthObjectArray);
         Method var10001 = methodObject26987;
         this.delegate.close();
         this.postForClose(var10001);
      } catch (SQLException var2) {
         this.onErrorVoidForClose(methodObject26987, var2);
      }
   }

   public void setTimeAtName(String arg0, Time arg1, Calendar arg2) throws SQLException {
      try {
         super.preForAll(methodObject26869, this, arg0, arg1, arg2);
         this.delegate.setTimeAtName(arg0, arg1, arg2);
      } catch (SQLException var5) {
         this.onErrorVoidForAll(methodObject26869, var5);
      }
   }

   public void setNUMBER(int arg0, NUMBER arg1) throws SQLException {
      try {
         super.preForAll(methodObject26912, this, arg0, arg1);
         this.delegate.setNUMBER(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject26912, var4);
      }
   }

   public void setFloatAtName(String arg0, float arg1) throws SQLException {
      try {
         super.preForAll(methodObject26833, this, arg0, arg1);
         this.delegate.setFloatAtName(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject26833, var4);
      }
   }

   public void setOracleObjectAtName(String arg0, Datum arg1) throws SQLException {
      try {
         super.preForAll(methodObject26882, this, arg0, arg1);
         this.delegate.setOracleObjectAtName(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject26882, var4);
      }
   }

   public void setBigDecimalAtName(String arg0, BigDecimal arg1) throws SQLException {
      try {
         super.preForAll(methodObject26839, this, arg0, arg1);
         this.delegate.setBigDecimalAtName(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject26839, var4);
      }
   }

   public void setTimestamp(int arg0, Timestamp arg1, Calendar arg2) throws SQLException {
      try {
         super.preForAll(methodObject26940, this, arg0, arg1, arg2);
         this.delegate.setTimestamp(arg0, arg1, arg2);
      } catch (SQLException var5) {
         this.onErrorVoidForAll(methodObject26940, var5);
      }
   }

   public void setBinaryStream(int arg0, InputStream arg1, long arg2) throws SQLException {
      try {
         super.preForSetStreams(methodObject26948, this, arg0, arg1, arg2);
         this.delegate.setBinaryStream(arg0, arg1, arg2);
      } catch (SQLException var6) {
         this.onErrorVoidForAll(methodObject26948, var6);
      }
   }

   public void setBinaryStreamAtName(String arg0, InputStream arg1) throws SQLException {
      try {
         super.preForSetStreams(methodObject26813, this, arg0, arg1);
         this.delegate.setBinaryStreamAtName(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject26813, var4);
      }
   }

   public void setBlobAtName(String arg0, InputStream arg1, long arg2) throws SQLException {
      try {
         super.preForAll(methodObject26856, this, arg0, arg1, arg2);
         this.delegate.setBlobAtName(arg0, arg1, arg2);
      } catch (SQLException var6) {
         this.onErrorVoidForAll(methodObject26856, var6);
      }
   }

   public void setREFAtName(String arg0, REF arg1) throws SQLException {
      try {
         super.preForAll(methodObject26881, this, arg0, arg1);
         this.delegate.setREFAtName(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject26881, var4);
      }
   }

   public void setShort(int arg0, short arg1) throws SQLException {
      try {
         super.preForAll(methodObject26938, this, arg0, arg1);
         this.delegate.setShort(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject26938, var4);
      }
   }

   public boolean getMoreResults(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject27012, this, arg0);
         return (Boolean)this.postForAll(methodObject27012, this.delegate.getMoreResults(arg0));
      } catch (SQLException var3) {
         return (Boolean)this.postForAll(methodObject27012, this.onErrorForAll(methodObject27012, var3));
      }
   }

   public void clearBatch() throws SQLException {
      try {
         super.preForAll(methodObject27006, this, zeroLengthObjectArray);
         this.delegate.clearBatch();
      } catch (SQLException var2) {
         this.onErrorVoidForAll(methodObject27006, var2);
      }
   }

   public void setDatabaseChangeRegistration(DatabaseChangeRegistration arg0) throws SQLException {
      try {
         super.preForAll(methodObject27045, this, arg0);
         this.delegate.setDatabaseChangeRegistration(arg0);
      } catch (SQLException var3) {
         this.onErrorVoidForAll(methodObject27045, var3);
      }
   }

   public void setArray(int arg0, Array arg1) throws SQLException {
      try {
         super.preForAll(methodObject26985, this, arg0, arg1);
         this.delegate.setArray(arg0, arg1 instanceof _Proxy_ ? (Array)((_Proxy_)arg1)._getDelegate_() : arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject26985, var4);
      }
   }

   public void setNClob(int arg0, Reader arg1, long arg2) throws SQLException {
      try {
         super.preForAll(methodObject26978, this, arg0, arg1, arg2);
         this.delegate.setNClob(arg0, arg1, arg2);
      } catch (SQLException var6) {
         this.onErrorVoidForAll(methodObject26978, var6);
      }
   }

   public int executeUpdate() throws SQLException {
      try {
         super.preForExecuteUpdate(methodObject26943, this, zeroLengthObjectArray);
         return this.postForExecuteUpdate(methodObject26943, this.delegate.executeUpdate());
      } catch (SQLException var2) {
         return this.postForExecuteUpdate(methodObject26943, (Integer)this.onErrorForAll(methodObject26943, var2));
      }
   }

   public void setAsciiStream(int arg0, InputStream arg1, int arg2) throws SQLException {
      try {
         super.preForSetStreams(methodObject26944, this, arg0, arg1, arg2);
         this.delegate.setAsciiStream(arg0, arg1, arg2);
      } catch (SQLException var5) {
         this.onErrorVoidForAll(methodObject26944, var5);
      }
   }

   public void defineColumnTypeChars(int arg0, int arg1, int arg2) throws SQLException {
      try {
         super.preForAll(methodObject27038, this, arg0, arg1, arg2);
         this.delegate.defineColumnTypeChars(arg0, arg1, arg2);
      } catch (SQLException var5) {
         this.onErrorVoidForAll(methodObject27038, var5);
      }
   }

   public void setNCharacterStream(int arg0, Reader arg1) throws SQLException {
      try {
         super.preForSetStreams(methodObject26954, this, arg0, arg1);
         this.delegate.setNCharacterStream(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject26954, var4);
      }
   }

   public void setTime(int arg0, Time arg1) throws SQLException {
      try {
         super.preForAll(methodObject26963, this, arg0, arg1);
         this.delegate.setTime(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject26963, var4);
      }
   }

   public void defineColumnTypeBytes(int arg0, int arg1, int arg2) throws SQLException {
      try {
         super.preForAll(methodObject27037, this, arg0, arg1, arg2);
         this.delegate.defineColumnTypeBytes(arg0, arg1, arg2);
      } catch (SQLException var5) {
         this.onErrorVoidForAll(methodObject27037, var5);
      }
   }

   public void setLong(int arg0, long arg1) throws SQLException {
      try {
         super.preForAll(methodObject26937, this, arg0, arg1);
         this.delegate.setLong(arg0, arg1);
      } catch (SQLException var5) {
         this.onErrorVoidForAll(methodObject26937, var5);
      }
   }

   public void setDate(int arg0, Date arg1, Calendar arg2) throws SQLException {
      try {
         super.preForAll(methodObject26966, this, arg0, arg1, arg2);
         this.delegate.setDate(arg0, arg1, arg2);
      } catch (SQLException var5) {
         this.onErrorVoidForAll(methodObject26966, var5);
      }
   }

   public void setTIMESTAMPLTZAtName(String arg0, TIMESTAMPLTZ arg1) throws SQLException {
      try {
         super.preForAll(methodObject26876, this, arg0, arg1);
         this.delegate.setTIMESTAMPLTZAtName(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject26876, var4);
      }
   }

   public void setClobAtName(String arg0, Clob arg1) throws SQLException {
      try {
         super.preForAll(methodObject26859, this, arg0, arg1);
         this.delegate.setClobAtName(arg0, arg1 instanceof _Proxy_ ? (Clob)((_Proxy_)arg1)._getDelegate_() : arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject26859, var4);
      }
   }

   public void setCLOB(int arg0, CLOB arg1) throws SQLException {
      try {
         super.preForAll(methodObject26914, this, arg0, arg1);
         this.delegate.setCLOB(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject26914, var4);
      }
   }

   public void setFetchSize(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject27028, this, arg0);
         this.delegate.setFetchSize(arg0);
      } catch (SQLException var3) {
         this.onErrorVoidForAll(methodObject27028, var3);
      }
   }

   public void setFetchDirection(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject27027, this, arg0);
         this.delegate.setFetchDirection(arg0);
      } catch (SQLException var3) {
         this.onErrorVoidForAll(methodObject27027, var3);
      }
   }

   public int getFetchSize() throws SQLException {
      try {
         super.preForAll(methodObject27026, this, zeroLengthObjectArray);
         return (Integer)this.postForAll(methodObject27026, this.delegate.getFetchSize());
      } catch (SQLException var2) {
         return (Integer)this.postForAll(methodObject27026, this.onErrorForAll(methodObject27026, var2));
      }
   }

   public void setSTRUCTAtName(String arg0, STRUCT arg1) throws SQLException {
      try {
         super.preForAll(methodObject26849, this, arg0, arg1);
         this.delegate.setSTRUCTAtName(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject26849, var4);
      }
   }

   public void setBinaryFloat(int arg0, BINARY_FLOAT arg1) throws SQLException {
      try {
         super.preForAll(methodObject26901, this, arg0, arg1);
         this.delegate.setBinaryFloat(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject26901, var4);
      }
   }

   public void setCharacterStream(int arg0, Reader arg1, int arg2) throws SQLException {
      try {
         super.preForSetStreams(methodObject26950, this, arg0, arg1, arg2);
         this.delegate.setCharacterStream(arg0, arg1, arg2);
      } catch (SQLException var5) {
         this.onErrorVoidForAll(methodObject26950, var5);
      }
   }

   public void setCursorName(String arg0) throws SQLException {
      try {
         super.preForAll(methodObject27019, this, arg0);
         this.delegate.setCursorName(arg0);
      } catch (SQLException var3) {
         this.onErrorVoidForAll(methodObject27019, var3);
      }
   }

   public void setBytes(int arg0, byte[] arg1) throws SQLException {
      try {
         super.preForAll(methodObject26956, this, arg0, arg1);
         this.delegate.setBytes(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject26956, var4);
      }
   }

   public void setBinaryStream(int arg0, InputStream arg1, int arg2) throws SQLException {
      try {
         super.preForSetStreams(methodObject26947, this, arg0, arg1, arg2);
         this.delegate.setBinaryStream(arg0, arg1, arg2);
      } catch (SQLException var5) {
         this.onErrorVoidForAll(methodObject26947, var5);
      }
   }

   public String[] getRegisteredTableNames() throws SQLException {
      try {
         super.preForAll(methodObject27046, this, zeroLengthObjectArray);
         return (String[])this.postForAll(methodObject27046, (Object)this.delegate.getRegisteredTableNames());
      } catch (SQLException var2) {
         return (String[])this.postForAll(methodObject27046, this.onErrorForAll(methodObject27046, var2));
      }
   }

   public void clearParameters() throws SQLException {
      try {
         super.preForAll(methodObject26969, this, zeroLengthObjectArray);
         this.delegate.clearParameters();
      } catch (SQLException var2) {
         this.onErrorVoidForAll(methodObject26969, var2);
      }
   }

   public void setBinaryStreamAtName(String arg0, InputStream arg1, int arg2) throws SQLException {
      try {
         super.preForSetStreams(methodObject26811, this, arg0, arg1, arg2);
         this.delegate.setBinaryStreamAtName(arg0, arg1, arg2);
      } catch (SQLException var5) {
         this.onErrorVoidForAll(methodObject26811, var5);
      }
   }

   public boolean isWrapperFor(Class arg0) throws SQLException {
      try {
         super.preForAll(methodObject27030, this, arg0);
         return (Boolean)this.postForAll(methodObject27030, this.delegate.isWrapperFor(arg0));
      } catch (SQLException var3) {
         return (Boolean)this.postForAll(methodObject27030, this.onErrorForAll(methodObject27030, var3));
      }
   }

   public void setARRAYAtName(String arg0, ARRAY arg1) throws SQLException {
      try {
         super.preForAll(methodObject26846, this, arg0, arg1);
         this.delegate.setARRAYAtName(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject26846, var4);
      }
   }

   public void setORADataAtName(String arg0, ORAData arg1) throws SQLException {
      try {
         super.preForAll(methodObject26878, this, arg0, arg1);
         this.delegate.setORADataAtName(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject26878, var4);
      }
   }

   public boolean execute() throws SQLException {
      try {
         super.preForExecute(methodObject26942, this, zeroLengthObjectArray);
         return this.postForExecute(methodObject26942, this.delegate.execute());
      } catch (SQLException var2) {
         return this.postForExecute(methodObject26942, this.onErrorForExecute(methodObject26942, var2));
      }
   }

   public int getLobPrefetchSize() throws SQLException {
      try {
         super.preForAll(methodObject27041, this, zeroLengthObjectArray);
         return (Integer)this.postForAll(methodObject27041, this.delegate.getLobPrefetchSize());
      } catch (SQLException var2) {
         return (Integer)this.postForAll(methodObject27041, this.onErrorForAll(methodObject27041, var2));
      }
   }

   public void defineParameterTypeChars(int arg0, int arg1, int arg2) throws SQLException {
      try {
         super.preForAll(methodObject26823, this, arg0, arg1, arg2);
         this.delegate.defineParameterTypeChars(arg0, arg1, arg2);
      } catch (SQLException var5) {
         this.onErrorVoidForAll(methodObject26823, var5);
      }
   }

   public void setArrayAtName(String arg0, Array arg1) throws SQLException {
      try {
         super.preForAll(methodObject26845, this, arg0, arg1);
         this.delegate.setArrayAtName(arg0, arg1 instanceof _Proxy_ ? (Array)((_Proxy_)arg1)._getDelegate_() : arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject26845, var4);
      }
   }

   public ParameterMetaData getParameterMetaData() throws SQLException {
      try {
         super.preForAll(methodObject26962, this, zeroLengthObjectArray);
         return (ParameterMetaData)this.postForAll(methodObject26962, this.proxyFactory.proxyForCreate((Object)this.delegate.getParameterMetaData(), this, this.proxyCache, methodObject26962));
      } catch (SQLException var2) {
         return (ParameterMetaData)this.postForAll(methodObject26962, this.onErrorForAll(methodObject26962, var2));
      }
   }

   public void setCharacterStreamAtName(String arg0, Reader arg1) throws SQLException {
      try {
         super.preForSetStreams(methodObject26815, this, arg0, arg1);
         this.delegate.setCharacterStreamAtName(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject26815, var4);
      }
   }

   public void setCustomDatumAtName(String arg0, CustomDatum arg1) throws SQLException {
      try {
         super.preForAll(methodObject26877, this, arg0, arg1);
         this.delegate.setCustomDatumAtName(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject26877, var4);
      }
   }

   public void setStringForClob(int arg0, String arg1) throws SQLException {
      try {
         super.preForAll(methodObject26904, this, arg0, arg1);
         this.delegate.setStringForClob(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject26904, var4);
      }
   }

   public void setURLAtName(String arg0, URL arg1) throws SQLException {
      try {
         super.preForAll(methodObject26883, this, arg0, arg1);
         this.delegate.setURLAtName(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject26883, var4);
      }
   }

   public void setINTERVALYM(int arg0, INTERVALYM arg1) throws SQLException {
      try {
         super.preForAll(methodObject26917, this, arg0, arg1);
         this.delegate.setINTERVALYM(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject26917, var4);
      }
   }

   public void setAsciiStream(int arg0, InputStream arg1, long arg2) throws SQLException {
      try {
         super.preForSetStreams(methodObject26945, this, arg0, arg1, arg2);
         this.delegate.setAsciiStream(arg0, arg1, arg2);
      } catch (SQLException var6) {
         this.onErrorVoidForAll(methodObject26945, var6);
      }
   }

   public void setNCharacterStreamAtName(String arg0, Reader arg1) throws SQLException {
      try {
         super.preForSetStreams(methodObject26817, this, arg0, arg1);
         this.delegate.setNCharacterStreamAtName(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject26817, var4);
      }
   }

   public int getMaxFieldSize() throws SQLException {
      try {
         super.preForAll(methodObject27009, this, zeroLengthObjectArray);
         return (Integer)this.postForAll(methodObject27009, this.delegate.getMaxFieldSize());
      } catch (SQLException var2) {
         return (Integer)this.postForAll(methodObject27009, this.onErrorForAll(methodObject27009, var2));
      }
   }

   public void setCharacterStreamAtName(String arg0, Reader arg1, long arg2) throws SQLException {
      try {
         super.preForSetStreams(methodObject26814, this, arg0, arg1, arg2);
         this.delegate.setCharacterStreamAtName(arg0, arg1, arg2);
      } catch (SQLException var6) {
         this.onErrorVoidForAll(methodObject26814, var6);
      }
   }

   public void setInt(int arg0, int arg1) throws SQLException {
      try {
         super.preForAll(methodObject26936, this, arg0, arg1);
         this.delegate.setInt(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject26936, var4);
      }
   }

   public OraclePreparedStatement _getDelegate_() {
      return this.delegate;
   }

   public Object getDelegate() {
      return this.delegate;
   }

   public void setDelegate(Object delegate) {
      this.proxyFactory.updateDelegate(this, this.delegate, delegate);
      this.delegate = (OraclePreparedStatement)delegate;
   }

   public Object getCreator() {
      return this.creator;
   }

   static {
      try {
         methodObject26851 = OraclePreparedStatement.class.getDeclaredMethod("setCHARAtName", String.class, CHAR.class);
         methodObject26988 = Statement.class.getDeclaredMethod("execute", String.class);
         methodObject26825 = OraclePreparedStatement.class.getDeclaredMethod("getExecuteBatch");
         methodObject26853 = OraclePreparedStatement.class.getDeclaredMethod("setNUMBERAtName", String.class, NUMBER.class);
         methodObject26918 = OraclePreparedStatement.class.getDeclaredMethod("setINTERVALDS", Integer.TYPE, INTERVALDS.class);
         methodObject26894 = OraclePreparedStatement.class.getDeclaredMethod("setNClobAtName", String.class, Reader.class, Long.TYPE);
         methodObject26847 = OraclePreparedStatement.class.getDeclaredMethod("setOPAQUEAtName", String.class, OPAQUE.class);
         methodObject26983 = PreparedStatement.class.getDeclaredMethod("setRowId", Integer.TYPE, RowId.class);
         methodObject26920 = OraclePreparedStatement.class.getDeclaredMethod("setTIMESTAMPTZ", Integer.TYPE, TIMESTAMPTZ.class);
         methodObject26997 = Statement.class.getDeclaredMethod("executeUpdate", String.class, int[].class);
         methodObject26893 = OraclePreparedStatement.class.getDeclaredMethod("setNClobAtName", String.class, NClob.class);
         methodObject26927 = OraclePreparedStatement.class.getDeclaredMethod("setORAData", Integer.TYPE, ORAData.class);
         methodObject26933 = PreparedStatement.class.getDeclaredMethod("setByte", Integer.TYPE, Byte.TYPE);
         methodObject26934 = PreparedStatement.class.getDeclaredMethod("setDouble", Integer.TYPE, Double.TYPE);
         methodObject26816 = OraclePreparedStatement.class.getDeclaredMethod("setNCharacterStreamAtName", String.class, Reader.class, Long.TYPE);
         methodObject26981 = PreparedStatement.class.getDeclaredMethod("setNull", Integer.TYPE, Integer.TYPE);
         methodObject27040 = OracleStatement.class.getDeclaredMethod("setRowPrefetch", Integer.TYPE);
         methodObject26995 = Statement.class.getDeclaredMethod("executeUpdate", String.class);
         methodObject27018 = Statement.class.getDeclaredMethod("isPoolable");
         methodObject26844 = OraclePreparedStatement.class.getDeclaredMethod("setROWIDAtName", String.class, ROWID.class);
         methodObject26939 = PreparedStatement.class.getDeclaredMethod("setTimestamp", Integer.TYPE, Timestamp.class);
         methodObject26980 = PreparedStatement.class.getDeclaredMethod("setNString", Integer.TYPE, String.class);
         methodObject27033 = OracleStatement.class.getDeclaredMethod("defineColumnType", Integer.TYPE, Integer.TYPE);
         methodObject26819 = OraclePreparedStatement.class.getDeclaredMethod("setObjectAtName", String.class, Object.class, Integer.TYPE, Integer.TYPE);
         methodObject26955 = PreparedStatement.class.getDeclaredMethod("setUnicodeStream", Integer.TYPE, InputStream.class, Integer.TYPE);
         methodObject26964 = PreparedStatement.class.getDeclaredMethod("setTime", Integer.TYPE, Time.class, Calendar.class);
         methodObject27016 = Statement.class.getDeclaredMethod("getUpdateCount");
         methodObject26834 = OraclePreparedStatement.class.getDeclaredMethod("setDoubleAtName", String.class, Double.TYPE);
         methodObject26959 = PreparedStatement.class.getDeclaredMethod("setObject", Integer.TYPE, Object.class, Integer.TYPE, Integer.TYPE);
         methodObject27017 = Statement.class.getDeclaredMethod("isCloseOnCompletion");
         methodObject27021 = Statement.class.getDeclaredMethod("setMaxFieldSize", Integer.TYPE);
         methodObject26896 = OraclePreparedStatement.class.getDeclaredMethod("setNStringAtName", String.class, String.class);
         methodObject26922 = OraclePreparedStatement.class.getDeclaredMethod("setARRAY", Integer.TYPE, ARRAY.class);
         methodObject26874 = OraclePreparedStatement.class.getDeclaredMethod("setTIMESTAMPAtName", String.class, TIMESTAMP.class);
         methodObject26809 = OraclePreparedStatement.class.getDeclaredMethod("setAsciiStreamAtName", String.class, InputStream.class, Long.TYPE);
         methodObject26949 = PreparedStatement.class.getDeclaredMethod("setBinaryStream", Integer.TYPE, InputStream.class);
         methodObject26810 = OraclePreparedStatement.class.getDeclaredMethod("setAsciiStreamAtName", String.class, InputStream.class);
         methodObject26994 = Statement.class.getDeclaredMethod("executeBatch");
         methodObject27015 = Statement.class.getDeclaredMethod("getResultSetType");
         methodObject26858 = OraclePreparedStatement.class.getDeclaredMethod("setCLOBAtName", String.class, CLOB.class);
         methodObject27020 = Statement.class.getDeclaredMethod("setEscapeProcessing", Boolean.TYPE);
         methodObject27004 = Statement.class.getDeclaredMethod("getResultSetHoldability");
         methodObject26830 = OraclePreparedStatement.class.getDeclaredMethod("setShortAtName", String.class, Short.TYPE);
         methodObject26974 = PreparedStatement.class.getDeclaredMethod("setClob", Integer.TYPE, Clob.class);
         methodObject26822 = OraclePreparedStatement.class.getDeclaredMethod("defineParameterTypeBytes", Integer.TYPE, Integer.TYPE, Integer.TYPE);
         methodObject26903 = OraclePreparedStatement.class.getDeclaredMethod("setBinaryDouble", Integer.TYPE, BINARY_DOUBLE.class);
         methodObject26852 = OraclePreparedStatement.class.getDeclaredMethod("setDATEAtName", String.class, DATE.class);
         methodObject27003 = Statement.class.getDeclaredMethod("clearWarnings");
         methodObject26910 = OraclePreparedStatement.class.getDeclaredMethod("setCHAR", Integer.TYPE, CHAR.class);
         methodObject26888 = OraclePreparedStatement.class.getDeclaredMethod("OracleGetParameterMetaData");
         methodObject26916 = OraclePreparedStatement.class.getDeclaredMethod("setBfile", Integer.TYPE, BFILE.class);
         methodObject26824 = OraclePreparedStatement.class.getDeclaredMethod("defineParameterType", Integer.TYPE, Integer.TYPE, Integer.TYPE);
         methodObject26926 = OraclePreparedStatement.class.getDeclaredMethod("setCustomDatum", Integer.TYPE, CustomDatum.class);
         methodObject26961 = PreparedStatement.class.getDeclaredMethod("getMetaData");
         methodObject26898 = OraclePreparedStatement.class.getDeclaredMethod("setSQLXMLAtName", String.class, SQLXML.class);
         methodObject27023 = Statement.class.getDeclaredMethod("setPoolable", Boolean.TYPE);
         methodObject26999 = Statement.class.getDeclaredMethod("isClosed");
         methodObject26870 = OraclePreparedStatement.class.getDeclaredMethod("setTimestampAtName", String.class, Timestamp.class);
         methodObject26854 = OraclePreparedStatement.class.getDeclaredMethod("setBLOBAtName", String.class, BLOB.class);
         methodObject26931 = OraclePreparedStatement.class.getDeclaredMethod("sendBatch");
         methodObject27036 = OracleStatement.class.getDeclaredMethod("defineColumnType", Integer.TYPE, Integer.TYPE, String.class);
         methodObject27008 = Statement.class.getDeclaredMethod("getGeneratedKeys");
         methodObject26952 = PreparedStatement.class.getDeclaredMethod("setCharacterStream", Integer.TYPE, Reader.class);
         methodObject27039 = OracleStatement.class.getDeclaredMethod("getRowPrefetch");
         methodObject26975 = PreparedStatement.class.getDeclaredMethod("setClob", Integer.TYPE, Reader.class, Long.TYPE);
         methodObject26991 = Statement.class.getDeclaredMethod("execute", String.class, String[].class);
         methodObject26808 = OraclePreparedStatement.class.getDeclaredMethod("setAsciiStreamAtName", String.class, InputStream.class, Integer.TYPE);
         methodObject27007 = Statement.class.getDeclaredMethod("closeOnCompletion");
         methodObject26835 = OraclePreparedStatement.class.getDeclaredMethod("setBinaryFloatAtName", String.class, Float.TYPE);
         methodObject27025 = Statement.class.getDeclaredMethod("getFetchDirection");
         methodObject26911 = OraclePreparedStatement.class.getDeclaredMethod("setDATE", Integer.TYPE, DATE.class);
         methodObject26971 = PreparedStatement.class.getDeclaredMethod("setBlob", Integer.TYPE, Blob.class);
         methodObject26972 = PreparedStatement.class.getDeclaredMethod("setBlob", Integer.TYPE, InputStream.class, Long.TYPE);
         methodObject26838 = OraclePreparedStatement.class.getDeclaredMethod("setBinaryDoubleAtName", String.class, BINARY_DOUBLE.class);
         methodObject26951 = PreparedStatement.class.getDeclaredMethod("setCharacterStream", Integer.TYPE, Reader.class, Long.TYPE);
         methodObject26832 = OraclePreparedStatement.class.getDeclaredMethod("setLongAtName", String.class, Long.TYPE);
         methodObject26932 = PreparedStatement.class.getDeclaredMethod("setBoolean", Integer.TYPE, Boolean.TYPE);
         methodObject26885 = OraclePreparedStatement.class.getDeclaredMethod("setPlsqlIndexTable", Integer.TYPE, Object.class, Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE);
         methodObject26860 = OraclePreparedStatement.class.getDeclaredMethod("setClobAtName", String.class, Reader.class, Long.TYPE);
         methodObject26840 = OraclePreparedStatement.class.getDeclaredMethod("setStringAtName", String.class, String.class);
         methodObject26902 = OraclePreparedStatement.class.getDeclaredMethod("setBinaryDouble", Integer.TYPE, Double.TYPE);
         methodObject26925 = OraclePreparedStatement.class.getDeclaredMethod("setSTRUCT", Integer.TYPE, STRUCT.class);
         methodObject26837 = OraclePreparedStatement.class.getDeclaredMethod("setBinaryDoubleAtName", String.class, Double.TYPE);
         methodObject26821 = OraclePreparedStatement.class.getDeclaredMethod("setObjectAtName", String.class, Object.class);
         methodObject26930 = OraclePreparedStatement.class.getDeclaredMethod("setOracleObject", Integer.TYPE, Datum.class);
         methodObject26820 = OraclePreparedStatement.class.getDeclaredMethod("setObjectAtName", String.class, Object.class, Integer.TYPE);
         methodObject26928 = OraclePreparedStatement.class.getDeclaredMethod("setRefType", Integer.TYPE, REF.class);
         methodObject26812 = OraclePreparedStatement.class.getDeclaredMethod("setBinaryStreamAtName", String.class, InputStream.class, Long.TYPE);
         methodObject26909 = OraclePreparedStatement.class.getDeclaredMethod("setRAW", Integer.TYPE, RAW.class);
         methodObject26880 = OraclePreparedStatement.class.getDeclaredMethod("setRefAtName", String.class, Ref.class);
         methodObject26973 = PreparedStatement.class.getDeclaredMethod("setBlob", Integer.TYPE, InputStream.class);
         methodObject27032 = OracleStatement.class.getDeclaredMethod("clearDefines");
         methodObject26892 = OraclePreparedStatement.class.getDeclaredMethod("getReturnResultSet");
         methodObject26872 = OraclePreparedStatement.class.getDeclaredMethod("setINTERVALYMAtName", String.class, INTERVALYM.class);
         methodObject26864 = OraclePreparedStatement.class.getDeclaredMethod("setBytesAtName", String.class, byte[].class);
         methodObject26905 = OraclePreparedStatement.class.getDeclaredMethod("setBytesForBlob", Integer.TYPE, byte[].class);
         methodObject26831 = OraclePreparedStatement.class.getDeclaredMethod("setIntAtName", String.class, Integer.TYPE);
         methodObject26900 = OraclePreparedStatement.class.getDeclaredMethod("setBinaryFloat", Integer.TYPE, Float.TYPE);
         methodObject26850 = OraclePreparedStatement.class.getDeclaredMethod("setRAWAtName", String.class, RAW.class);
         methodObject26929 = OraclePreparedStatement.class.getDeclaredMethod("setREF", Integer.TYPE, REF.class);
         methodObject26946 = PreparedStatement.class.getDeclaredMethod("setAsciiStream", Integer.TYPE, InputStream.class);
         methodObject26848 = OraclePreparedStatement.class.getDeclaredMethod("setStructDescriptorAtName", String.class, StructDescriptor.class);
         methodObject26907 = OraclePreparedStatement.class.getDeclaredMethod("setCursor", Integer.TYPE, ResultSet.class);
         methodObject26827 = OraclePreparedStatement.class.getDeclaredMethod("setNullAtName", String.class, Integer.TYPE);
         methodObject27029 = Wrapper.class.getDeclaredMethod("unwrap", Class.class);
         methodObject27005 = Statement.class.getDeclaredMethod("addBatch", String.class);
         methodObject27014 = Statement.class.getDeclaredMethod("getResultSetConcurrency");
         methodObject26890 = OraclePreparedStatement.class.getDeclaredMethod("registerReturnParameter", Integer.TYPE, Integer.TYPE, Integer.TYPE);
         methodObject26871 = OraclePreparedStatement.class.getDeclaredMethod("setTimestampAtName", String.class, Timestamp.class, Calendar.class);
         methodObject26855 = OraclePreparedStatement.class.getDeclaredMethod("setBlobAtName", String.class, Blob.class);
         methodObject26957 = PreparedStatement.class.getDeclaredMethod("setObject", Integer.TYPE, Object.class, Integer.TYPE);
         methodObject26889 = OraclePreparedStatement.class.getDeclaredMethod("registerReturnParameter", Integer.TYPE, Integer.TYPE);
         methodObject26868 = OraclePreparedStatement.class.getDeclaredMethod("setTimeAtName", String.class, Time.class);
         methodObject26923 = OraclePreparedStatement.class.getDeclaredMethod("setOPAQUE", Integer.TYPE, OPAQUE.class);
         methodObject26958 = PreparedStatement.class.getDeclaredMethod("setObject", Integer.TYPE, Object.class);
         methodObject26826 = OraclePreparedStatement.class.getDeclaredMethod("setNullAtName", String.class, Integer.TYPE, String.class);
         methodObject26986 = PreparedStatement.class.getDeclaredMethod("setRef", Integer.TYPE, Ref.class);
         methodObject26862 = OraclePreparedStatement.class.getDeclaredMethod("setBFILEAtName", String.class, BFILE.class);
         methodObject26992 = Statement.class.getDeclaredMethod("cancel");
         methodObject26899 = OraclePreparedStatement.class.getDeclaredMethod("setExecuteBatch", Integer.TYPE);
         methodObject26836 = OraclePreparedStatement.class.getDeclaredMethod("setBinaryFloatAtName", String.class, BINARY_FLOAT.class);
         methodObject27024 = Statement.class.getDeclaredMethod("setQueryTimeout", Integer.TYPE);
         methodObject26993 = Statement.class.getDeclaredMethod("getResultSet");
         methodObject27042 = OracleStatement.class.getDeclaredMethod("setLobPrefetchSize", Integer.TYPE);
         methodObject27043 = OracleStatement.class.getDeclaredMethod("closeWithKey", String.class);
         methodObject27035 = OracleStatement.class.getDeclaredMethod("defineColumnType", Integer.TYPE, Integer.TYPE, Integer.TYPE, Short.TYPE);
         methodObject26863 = OraclePreparedStatement.class.getDeclaredMethod("setBfileAtName", String.class, BFILE.class);
         methodObject26875 = OraclePreparedStatement.class.getDeclaredMethod("setTIMESTAMPTZAtName", String.class, TIMESTAMPTZ.class);
         methodObject26953 = PreparedStatement.class.getDeclaredMethod("setNCharacterStream", Integer.TYPE, Reader.class, Long.TYPE);
         methodObject26921 = OraclePreparedStatement.class.getDeclaredMethod("setTIMESTAMPLTZ", Integer.TYPE, TIMESTAMPLTZ.class);
         methodObject27034 = OracleStatement.class.getDeclaredMethod("defineColumnType", Integer.TYPE, Integer.TYPE, Integer.TYPE);
         methodObject27047 = OracleStatement.class.getDeclaredMethod("getRegisteredQueryId");
         methodObject26977 = PreparedStatement.class.getDeclaredMethod("setNClob", Integer.TYPE, NClob.class);
         methodObject26866 = OraclePreparedStatement.class.getDeclaredMethod("setDateAtName", String.class, Date.class);
         methodObject26906 = OraclePreparedStatement.class.getDeclaredMethod("setFixedCHAR", Integer.TYPE, String.class);
         methodObject26990 = Statement.class.getDeclaredMethod("execute", String.class, int[].class);
         methodObject26873 = OraclePreparedStatement.class.getDeclaredMethod("setINTERVALDSAtName", String.class, INTERVALDS.class);
         methodObject26965 = PreparedStatement.class.getDeclaredMethod("setDate", Integer.TYPE, Date.class);
         methodObject27011 = Statement.class.getDeclaredMethod("getMoreResults");
         methodObject26996 = Statement.class.getDeclaredMethod("executeUpdate", String.class, Integer.TYPE);
         methodObject26829 = OraclePreparedStatement.class.getDeclaredMethod("setByteAtName", String.class, Byte.TYPE);
         methodObject26867 = OraclePreparedStatement.class.getDeclaredMethod("setDateAtName", String.class, Date.class, Calendar.class);
         methodObject26865 = OraclePreparedStatement.class.getDeclaredMethod("setBytesForBlobAtName", String.class, byte[].class);
         methodObject26843 = OraclePreparedStatement.class.getDeclaredMethod("setCursorAtName", String.class, ResultSet.class);
         methodObject27000 = Statement.class.getDeclaredMethod("executeQuery", String.class);
         methodObject26897 = OraclePreparedStatement.class.getDeclaredMethod("setRowIdAtName", String.class, RowId.class);
         methodObject26935 = PreparedStatement.class.getDeclaredMethod("setFloat", Integer.TYPE, Float.TYPE);
         methodObject26915 = OraclePreparedStatement.class.getDeclaredMethod("setBFILE", Integer.TYPE, BFILE.class);
         methodObject26984 = PreparedStatement.class.getDeclaredMethod("setSQLXML", Integer.TYPE, SQLXML.class);
         methodObject26879 = OraclePreparedStatement.class.getDeclaredMethod("setRefTypeAtName", String.class, REF.class);
         methodObject26818 = OraclePreparedStatement.class.getDeclaredMethod("setUnicodeStreamAtName", String.class, InputStream.class, Integer.TYPE);
         methodObject27010 = Statement.class.getDeclaredMethod("getMaxRows");
         methodObject26924 = OraclePreparedStatement.class.getDeclaredMethod("setStructDescriptor", Integer.TYPE, StructDescriptor.class);
         methodObject26967 = PreparedStatement.class.getDeclaredMethod("setString", Integer.TYPE, String.class);
         methodObject26968 = PreparedStatement.class.getDeclaredMethod("addBatch");
         methodObject26998 = Statement.class.getDeclaredMethod("executeUpdate", String.class, String[].class);
         methodObject26887 = OraclePreparedStatement.class.getDeclaredMethod("setDisableStmtCaching", Boolean.TYPE);
         methodObject26913 = OraclePreparedStatement.class.getDeclaredMethod("setBLOB", Integer.TYPE, BLOB.class);
         methodObject27013 = Statement.class.getDeclaredMethod("getQueryTimeout");
         methodObject26895 = OraclePreparedStatement.class.getDeclaredMethod("setNClobAtName", String.class, Reader.class);
         methodObject26989 = Statement.class.getDeclaredMethod("execute", String.class, Integer.TYPE);
         methodObject26941 = PreparedStatement.class.getDeclaredMethod("setURL", Integer.TYPE, URL.class);
         methodObject26979 = PreparedStatement.class.getDeclaredMethod("setNClob", Integer.TYPE, Reader.class);
         methodObject26841 = OraclePreparedStatement.class.getDeclaredMethod("setStringForClobAtName", String.class, String.class);
         methodObject26970 = PreparedStatement.class.getDeclaredMethod("setBigDecimal", Integer.TYPE, BigDecimal.class);
         methodObject26982 = PreparedStatement.class.getDeclaredMethod("setNull", Integer.TYPE, Integer.TYPE, String.class);
         methodObject26976 = PreparedStatement.class.getDeclaredMethod("setClob", Integer.TYPE, Reader.class);
         methodObject26960 = PreparedStatement.class.getDeclaredMethod("executeQuery");
         methodObject26828 = OraclePreparedStatement.class.getDeclaredMethod("setBooleanAtName", String.class, Boolean.TYPE);
         methodObject26891 = OraclePreparedStatement.class.getDeclaredMethod("registerReturnParameter", Integer.TYPE, Integer.TYPE, String.class);
         methodObject26842 = OraclePreparedStatement.class.getDeclaredMethod("setFixedCHARAtName", String.class, String.class);
         methodObject27002 = Statement.class.getDeclaredMethod("getWarnings");
         methodObject26908 = OraclePreparedStatement.class.getDeclaredMethod("setROWID", Integer.TYPE, ROWID.class);
         methodObject26884 = OraclePreparedStatement.class.getDeclaredMethod("setCheckBindTypes", Boolean.TYPE);
         methodObject26919 = OraclePreparedStatement.class.getDeclaredMethod("setTIMESTAMP", Integer.TYPE, TIMESTAMP.class);
         methodObject27001 = Statement.class.getDeclaredMethod("getConnection");
         methodObject26861 = OraclePreparedStatement.class.getDeclaredMethod("setClobAtName", String.class, Reader.class);
         methodObject27044 = OracleStatement.class.getDeclaredMethod("creationState");
         methodObject27022 = Statement.class.getDeclaredMethod("setMaxRows", Integer.TYPE);
         methodObject26886 = OraclePreparedStatement.class.getDeclaredMethod("setFormOfUse", Integer.TYPE, Short.TYPE);
         methodObject27031 = OracleStatement.class.getDeclaredMethod("isNCHAR", Integer.TYPE);
         methodObject26857 = OraclePreparedStatement.class.getDeclaredMethod("setBlobAtName", String.class, InputStream.class);
         methodObject26987 = Statement.class.getDeclaredMethod("close");
         methodObject26869 = OraclePreparedStatement.class.getDeclaredMethod("setTimeAtName", String.class, Time.class, Calendar.class);
         methodObject26912 = OraclePreparedStatement.class.getDeclaredMethod("setNUMBER", Integer.TYPE, NUMBER.class);
         methodObject26833 = OraclePreparedStatement.class.getDeclaredMethod("setFloatAtName", String.class, Float.TYPE);
         methodObject26882 = OraclePreparedStatement.class.getDeclaredMethod("setOracleObjectAtName", String.class, Datum.class);
         methodObject26839 = OraclePreparedStatement.class.getDeclaredMethod("setBigDecimalAtName", String.class, BigDecimal.class);
         methodObject26940 = PreparedStatement.class.getDeclaredMethod("setTimestamp", Integer.TYPE, Timestamp.class, Calendar.class);
         methodObject26948 = PreparedStatement.class.getDeclaredMethod("setBinaryStream", Integer.TYPE, InputStream.class, Long.TYPE);
         methodObject26813 = OraclePreparedStatement.class.getDeclaredMethod("setBinaryStreamAtName", String.class, InputStream.class);
         methodObject26856 = OraclePreparedStatement.class.getDeclaredMethod("setBlobAtName", String.class, InputStream.class, Long.TYPE);
         methodObject26881 = OraclePreparedStatement.class.getDeclaredMethod("setREFAtName", String.class, REF.class);
         methodObject26938 = PreparedStatement.class.getDeclaredMethod("setShort", Integer.TYPE, Short.TYPE);
         methodObject27012 = Statement.class.getDeclaredMethod("getMoreResults", Integer.TYPE);
         methodObject27006 = Statement.class.getDeclaredMethod("clearBatch");
         methodObject27045 = OracleStatement.class.getDeclaredMethod("setDatabaseChangeRegistration", DatabaseChangeRegistration.class);
         methodObject26985 = PreparedStatement.class.getDeclaredMethod("setArray", Integer.TYPE, Array.class);
         methodObject26978 = PreparedStatement.class.getDeclaredMethod("setNClob", Integer.TYPE, Reader.class, Long.TYPE);
         methodObject26943 = PreparedStatement.class.getDeclaredMethod("executeUpdate");
         methodObject26944 = PreparedStatement.class.getDeclaredMethod("setAsciiStream", Integer.TYPE, InputStream.class, Integer.TYPE);
         methodObject27038 = OracleStatement.class.getDeclaredMethod("defineColumnTypeChars", Integer.TYPE, Integer.TYPE, Integer.TYPE);
         methodObject26954 = PreparedStatement.class.getDeclaredMethod("setNCharacterStream", Integer.TYPE, Reader.class);
         methodObject26963 = PreparedStatement.class.getDeclaredMethod("setTime", Integer.TYPE, Time.class);
         methodObject27037 = OracleStatement.class.getDeclaredMethod("defineColumnTypeBytes", Integer.TYPE, Integer.TYPE, Integer.TYPE);
         methodObject26937 = PreparedStatement.class.getDeclaredMethod("setLong", Integer.TYPE, Long.TYPE);
         methodObject26966 = PreparedStatement.class.getDeclaredMethod("setDate", Integer.TYPE, Date.class, Calendar.class);
         methodObject26876 = OraclePreparedStatement.class.getDeclaredMethod("setTIMESTAMPLTZAtName", String.class, TIMESTAMPLTZ.class);
         methodObject26859 = OraclePreparedStatement.class.getDeclaredMethod("setClobAtName", String.class, Clob.class);
         methodObject26914 = OraclePreparedStatement.class.getDeclaredMethod("setCLOB", Integer.TYPE, CLOB.class);
         methodObject27028 = Statement.class.getDeclaredMethod("setFetchSize", Integer.TYPE);
         methodObject27027 = Statement.class.getDeclaredMethod("setFetchDirection", Integer.TYPE);
         methodObject27026 = Statement.class.getDeclaredMethod("getFetchSize");
         methodObject26849 = OraclePreparedStatement.class.getDeclaredMethod("setSTRUCTAtName", String.class, STRUCT.class);
         methodObject26901 = OraclePreparedStatement.class.getDeclaredMethod("setBinaryFloat", Integer.TYPE, BINARY_FLOAT.class);
         methodObject26950 = PreparedStatement.class.getDeclaredMethod("setCharacterStream", Integer.TYPE, Reader.class, Integer.TYPE);
         methodObject27019 = Statement.class.getDeclaredMethod("setCursorName", String.class);
         methodObject26956 = PreparedStatement.class.getDeclaredMethod("setBytes", Integer.TYPE, byte[].class);
         methodObject26947 = PreparedStatement.class.getDeclaredMethod("setBinaryStream", Integer.TYPE, InputStream.class, Integer.TYPE);
         methodObject27046 = OracleStatement.class.getDeclaredMethod("getRegisteredTableNames");
         methodObject26969 = PreparedStatement.class.getDeclaredMethod("clearParameters");
         methodObject26811 = OraclePreparedStatement.class.getDeclaredMethod("setBinaryStreamAtName", String.class, InputStream.class, Integer.TYPE);
         methodObject27030 = Wrapper.class.getDeclaredMethod("isWrapperFor", Class.class);
         methodObject26846 = OraclePreparedStatement.class.getDeclaredMethod("setARRAYAtName", String.class, ARRAY.class);
         methodObject26878 = OraclePreparedStatement.class.getDeclaredMethod("setORADataAtName", String.class, ORAData.class);
         methodObject26942 = PreparedStatement.class.getDeclaredMethod("execute");
         methodObject27041 = OracleStatement.class.getDeclaredMethod("getLobPrefetchSize");
         methodObject26823 = OraclePreparedStatement.class.getDeclaredMethod("defineParameterTypeChars", Integer.TYPE, Integer.TYPE, Integer.TYPE);
         methodObject26845 = OraclePreparedStatement.class.getDeclaredMethod("setArrayAtName", String.class, Array.class);
         methodObject26962 = PreparedStatement.class.getDeclaredMethod("getParameterMetaData");
         methodObject26815 = OraclePreparedStatement.class.getDeclaredMethod("setCharacterStreamAtName", String.class, Reader.class);
         methodObject26877 = OraclePreparedStatement.class.getDeclaredMethod("setCustomDatumAtName", String.class, CustomDatum.class);
         methodObject26904 = OraclePreparedStatement.class.getDeclaredMethod("setStringForClob", Integer.TYPE, String.class);
         methodObject26883 = OraclePreparedStatement.class.getDeclaredMethod("setURLAtName", String.class, URL.class);
         methodObject26917 = OraclePreparedStatement.class.getDeclaredMethod("setINTERVALYM", Integer.TYPE, INTERVALYM.class);
         methodObject26945 = PreparedStatement.class.getDeclaredMethod("setAsciiStream", Integer.TYPE, InputStream.class, Long.TYPE);
         methodObject26817 = OraclePreparedStatement.class.getDeclaredMethod("setNCharacterStreamAtName", String.class, Reader.class);
         methodObject27009 = Statement.class.getDeclaredMethod("getMaxFieldSize");
         methodObject26814 = OraclePreparedStatement.class.getDeclaredMethod("setCharacterStreamAtName", String.class, Reader.class, Long.TYPE);
         methodObject26936 = PreparedStatement.class.getDeclaredMethod("setInt", Integer.TYPE, Integer.TYPE);
      } catch (Throwable var1) {
         throw new RuntimeException(var1);
      }
   }

   public oracle$1jdbc$1replay$1driver$1NonTxnReplayableStatement$2oracle$1jdbc$1OraclePreparedStatement$$$Proxy(OraclePreparedStatement var1, Object var2, ProxyFactory var3, Map var4) {
      this.delegate = var1;
      this.creator = var2;
      this.proxyFactory = var3;
      this.proxyCache = var4;
   }
}
