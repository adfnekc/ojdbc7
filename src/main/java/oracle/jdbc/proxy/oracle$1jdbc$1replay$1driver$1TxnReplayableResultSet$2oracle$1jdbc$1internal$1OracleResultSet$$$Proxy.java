package oracle.jdbc.proxy;

import java.io.InputStream;
import java.io.Reader;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.net.URL;
import java.sql.Array;
import java.sql.Blob;
import java.sql.Clob;
import java.sql.Date;
import java.sql.NClob;
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
import oracle.jdbc.OracleDataFactory;
import oracle.jdbc.internal.ACProxyable;
import oracle.jdbc.internal.OracleResultSet;
import oracle.jdbc.replay.driver.TxnReplayableResultSet;
import oracle.sql.ARRAY;
import oracle.sql.BFILE;
import oracle.sql.BLOB;
import oracle.sql.CHAR;
import oracle.sql.CLOB;
import oracle.sql.CustomDatum;
import oracle.sql.CustomDatumFactory;
import oracle.sql.DATE;
import oracle.sql.Datum;
import oracle.sql.INTERVALDS;
import oracle.sql.INTERVALYM;
import oracle.sql.NUMBER;
import oracle.sql.OPAQUE;
import oracle.sql.ORAData;
import oracle.sql.ORADataFactory;
import oracle.sql.RAW;
import oracle.sql.REF;
import oracle.sql.ROWID;
import oracle.sql.STRUCT;
import oracle.sql.TIMESTAMP;
import oracle.sql.TIMESTAMPLTZ;
import oracle.sql.TIMESTAMPTZ;

public class oracle$1jdbc$1replay$1driver$1TxnReplayableResultSet$2oracle$1jdbc$1internal$1OracleResultSet$$$Proxy extends TxnReplayableResultSet implements OracleResultSet, _Proxy_ {
   private OracleResultSet delegate;
   private final Object creator;
   private final ProxyFactory proxyFactory;
   private final Map proxyCache;
   private static Object[] zeroLengthObjectArray = new Object[0];
   private static Method methodObject6053;
   private static Method methodObject5931;
   private static Method methodObject6085;
   private static Method methodObject6011;
   private static Method methodObject6080;
   private static Method methodObject6032;
   private static Method methodObject6006;
   private static Method methodObject6031;
   private static Method methodObject5915;
   private static Method methodObject6015;
   private static Method methodObject5905;
   private static Method methodObject5841;
   private static Method methodObject6049;
   private static Method methodObject6050;
   private static Method methodObject6091;
   private static Method methodObject6071;
   private static Method methodObject5992;
   private static Method methodObject6063;
   private static Method methodObject6051;
   private static Method methodObject5938;
   private static Method methodObject6043;
   private static Method methodObject5872;
   private static Method methodObject5973;
   private static Method methodObject6100;
   private static Method methodObject5896;
   private static Method methodObject6104;
   private static Method methodObject6074;
   private static Method methodObject5966;
   private static Method methodObject5999;
   private static Method methodObject5898;
   private static Method methodObject6068;
   private static Method methodObject6010;
   private static Method methodObject5861;
   private static Method methodObject6101;
   private static Method methodObject5850;
   private static Method methodObject6069;
   private static Method methodObject5981;
   private static Method methodObject5902;
   private static Method methodObject6110;
   private static Method methodObject5888;
   private static Method methodObject6047;
   private static Method methodObject5844;
   private static Method methodObject5941;
   private static Method methodObject6022;
   private static Method methodObject6060;
   private static Method methodObject5836;
   private static Method methodObject5899;
   private static Method methodObject5916;
   private static Method methodObject6079;
   private static Method methodObject6083;
   private static Method methodObject5955;
   private static Method methodObject6109;
   private static Method methodObject5936;
   private static Method methodObject6070;
   private static Method methodObject6111;
   private static Method methodObject6087;
   private static Method methodObject5980;
   private static Method methodObject6003;
   private static Method methodObject6077;
   private static Method methodObject6072;
   private static Method methodObject6112;
   private static Method methodObject6102;
   private static Method methodObject5967;
   private static Method methodObject6092;
   private static Method methodObject6024;
   private static Method methodObject5927;
   private static Method methodObject5939;
   private static Method methodObject6042;
   private static Method methodObject5880;
   private static Method methodObject6094;
   private static Method methodObject5903;
   private static Method methodObject5868;
   private static Method methodObject6096;
   private static Method methodObject5894;
   private static Method methodObject6020;
   private static Method methodObject5951;
   private static Method methodObject5887;
   private static Method methodObject6007;
   private static Method methodObject6014;
   private static Method methodObject5895;
   private static Method methodObject5858;
   private static Method methodObject5993;
   private static Method methodObject5923;
   private static Method methodObject5974;
   private static Method methodObject5994;
   private static Method methodObject5946;
   private static Method methodObject5978;
   private static Method methodObject6005;
   private static Method methodObject6062;
   private static Method methodObject5910;
   private static Method methodObject5950;
   private static Method methodObject5890;
   private static Method methodObject5930;
   private static Method methodObject5919;
   private static Method methodObject5853;
   private static Method methodObject5909;
   private static Method methodObject5914;
   private static Method methodObject5984;
   private static Method methodObject5935;
   private static Method methodObject5865;
   private static Method methodObject5945;
   private static Method methodObject5949;
   private static Method methodObject5983;
   private static Method methodObject5956;
   private static Method methodObject5926;
   private static Method methodObject5859;
   private static Method methodObject5834;
   private static Method methodObject5876;
   private static Method methodObject5975;
   private static Method methodObject5934;
   private static Method methodObject6018;
   private static Method methodObject5874;
   private static Method methodObject5871;
   private static Method methodObject6076;
   private static Method methodObject6026;
   private static Method methodObject5882;
   private static Method methodObject6105;
   private static Method methodObject6067;
   private static Method methodObject5842;
   private static Method methodObject5917;
   private static Method methodObject5995;
   private static Method methodObject6029;
   private static Method methodObject5885;
   private static Method methodObject5961;
   private static Method methodObject6066;
   private static Method methodObject6086;
   private static Method methodObject6061;
   private static Method methodObject5968;
   private static Method methodObject5972;
   private static Method methodObject6040;
   private static Method methodObject5900;
   private static Method methodObject5833;
   private static Method methodObject5954;
   private static Method methodObject5959;
   private static Method methodObject5963;
   private static Method methodObject5847;
   private static Method methodObject6089;
   private static Method methodObject5906;
   private static Method methodObject5990;
   private static Method methodObject6099;
   private static Method methodObject5958;
   private static Method methodObject5965;
   private static Method methodObject5873;
   private static Method methodObject5855;
   private static Method methodObject5845;
   private static Method methodObject6055;
   private static Method methodObject5929;
   private static Method methodObject6059;
   private static Method methodObject5943;
   private static Method methodObject6082;
   private static Method methodObject6016;
   private static Method methodObject5932;
   private static Method methodObject5897;
   private static Method methodObject5889;
   private static Method methodObject5857;
   private static Method methodObject5987;
   private static Method methodObject5856;
   private static Method methodObject6009;
   private static Method methodObject5904;
   private static Method methodObject5840;
   private static Method methodObject5892;
   private static Method methodObject5879;
   private static Method methodObject5962;
   private static Method methodObject6093;
   private static Method methodObject5835;
   private static Method methodObject6054;
   private static Method methodObject5911;
   private static Method methodObject5985;
   private static Method methodObject6084;
   private static Method methodObject6017;
   private static Method methodObject5864;
   private static Method methodObject6090;
   private static Method methodObject6097;
   private static Method methodObject6081;
   private static Method methodObject6023;
   private static Method methodObject6056;
   private static Method methodObject5922;
   private static Method methodObject5832;
   private static Method methodObject6107;
   private static Method methodObject5854;
   private static Method methodObject5988;
   private static Method methodObject5912;
   private static Method methodObject6048;
   private static Method methodObject5924;
   private static Method methodObject6001;
   private static Method methodObject5918;
   private static Method methodObject5944;
   private static Method methodObject5860;
   private static Method methodObject5952;
   private static Method methodObject5925;
   private static Method methodObject5921;
   private static Method methodObject5866;
   private static Method methodObject6064;
   private static Method methodObject6098;
   private static Method methodObject5848;
   private static Method methodObject6021;
   private static Method methodObject5877;
   private static Method methodObject5998;
   private static Method methodObject6012;
   private static Method methodObject6088;
   private static Method methodObject5960;
   private static Method methodObject5969;
   private static Method methodObject6034;
   private static Method methodObject5886;
   private static Method methodObject6046;
   private static Method methodObject6039;
   private static Method methodObject5971;
   private static Method methodObject6035;
   private static Method methodObject5991;
   private static Method methodObject6095;
   private static Method methodObject5867;
   private static Method methodObject5893;
   private static Method methodObject6025;
   private static Method methodObject6057;
   private static Method methodObject5846;
   private static Method methodObject5957;
   private static Method methodObject6108;
   private static Method methodObject5852;
   private static Method methodObject5977;
   private static Method methodObject5839;
   private static Method methodObject6037;
   private static Method methodObject5948;
   private static Method methodObject6045;
   private static Method methodObject5933;
   private static Method methodObject6030;
   private static Method methodObject5863;
   private static Method methodObject5878;
   private static Method methodObject5838;
   private static Method methodObject5869;
   private static Method methodObject6052;
   private static Method methodObject5907;
   private static Method methodObject5837;
   private static Method methodObject5901;
   private static Method methodObject6000;
   private static Method methodObject6065;
   private static Method methodObject5875;
   private static Method methodObject6033;
   private static Method methodObject5982;
   private static Method methodObject6019;
   private static Method methodObject5986;
   private static Method methodObject6044;
   private static Method methodObject6027;
   private static Method methodObject5928;
   private static Method methodObject6002;
   private static Method methodObject5979;
   private static Method methodObject5970;
   private static Method methodObject6073;
   private static Method methodObject5884;
   private static Method methodObject6058;
   private static Method methodObject5891;
   private static Method methodObject5953;
   private static Method methodObject6106;
   private static Method methodObject6008;
   private static Method methodObject6036;
   private static Method methodObject5996;
   private static Method methodObject6038;
   private static Method methodObject5964;
   private static Method methodObject5908;
   private static Method methodObject5881;
   private static Method methodObject6113;
   private static Method methodObject6028;
   private static Method methodObject5989;
   private static Method methodObject5870;
   private static Method methodObject5843;
   private static Method methodObject5849;
   private static Method methodObject6004;
   private static Method methodObject5976;
   private static Method methodObject6078;
   private static Method methodObject5862;
   private static Method methodObject5920;
   private static Method methodObject5942;
   private static Method methodObject6075;
   private static Method methodObject6103;
   private static Method methodObject5997;
   private static Method methodObject5851;
   private static Method methodObject5940;
   private static Method methodObject5947;
   private static Method methodObject6041;
   private static Method methodObject6013;
   private static Method methodObject5913;
   private static Method methodObject5937;
   private static Method methodObject5883;

   public void updateClob(int arg0, Reader arg1, long arg2) throws SQLException {
      try {
         super.preForAll(methodObject6053, this, arg0, arg1, arg2);
         Method var10001 = methodObject6053;
         this.delegate.updateClob(arg0, arg1, arg2);
         this.postForAll(var10001);
      } catch (SQLException var6) {
         this.onErrorVoidForAll(methodObject6053, var6);
      }
   }

   public short getShort(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject5931, this, arg0);
         return (Short)this.postForAll(methodObject5931, this.delegate.getShort(arg0));
      } catch (SQLException var3) {
         return (Short)this.postForAll(methodObject5931, this.onErrorForAll(methodObject5931, var3));
      }
   }

   public void updateRef(int arg0, Ref arg1) throws SQLException {
      try {
         super.preForAll(methodObject6085, this, arg0, arg1);
         Method var10001 = methodObject6085;
         this.delegate.updateRef(arg0, arg1 instanceof _Proxy_ ? (Ref)((_Proxy_)arg1)._getDelegate_() : arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject6085, var4);
      }
   }

   public boolean relative(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject6011, this, arg0);
         return (Boolean)this.postForAll(methodObject6011, this.delegate.relative(arg0));
      } catch (SQLException var3) {
         return (Boolean)this.postForAll(methodObject6011, this.onErrorForAll(methodObject6011, var3));
      }
   }

   public void updateNull(String arg0) throws SQLException {
      try {
         super.preForAll(methodObject6080, this, arg0);
         Method var10001 = methodObject6080;
         this.delegate.updateNull(arg0);
         this.postForAll(var10001);
      } catch (SQLException var3) {
         this.onErrorVoidForAll(methodObject6080, var3);
      }
   }

   public void updateBinaryStream(String arg0, InputStream arg1) throws SQLException {
      try {
         super.preForUpdateStreams(methodObject6032, this, arg0, arg1);
         Method var10001 = methodObject6032;
         this.delegate.updateBinaryStream(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject6032, var4);
      }
   }

   public boolean isLast() throws SQLException {
      try {
         super.preForAll(methodObject6006, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject6006, this.delegate.isLast());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject6006, this.onErrorForAll(methodObject6006, var2));
      }
   }

   public void updateBinaryStream(int arg0, InputStream arg1) throws SQLException {
      try {
         super.preForUpdateStreams(methodObject6031, this, arg0, arg1);
         Method var10001 = methodObject6031;
         this.delegate.updateBinaryStream(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject6031, var4);
      }
   }

   public void updateTIMESTAMPLTZ(int arg0, TIMESTAMPLTZ arg1) throws SQLException {
      try {
         super.preForAll(methodObject5915, this, arg0, arg1);
         Method var10001 = methodObject5915;
         this.delegate.updateTIMESTAMPLTZ(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject5915, var4);
      }
   }

   public void setFetchDirection(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject6015, this, arg0);
         Method var10001 = methodObject6015;
         this.delegate.setFetchDirection(arg0);
         this.postForAll(var10001);
      } catch (SQLException var3) {
         this.onErrorVoidForAll(methodObject6015, var3);
      }
   }

   public void updateDATE(int arg0, DATE arg1) throws SQLException {
      try {
         super.preForAll(methodObject5905, this, arg0, arg1);
         Method var10001 = methodObject5905;
         this.delegate.updateDATE(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject5905, var4);
      }
   }

   public BFILE getBFILE(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject5841, this, arg0);
         return (BFILE)this.postForAll(methodObject5841, (Object)this.delegate.getBFILE(arg0));
      } catch (SQLException var3) {
         return (BFILE)this.postForAll(methodObject5841, this.onErrorForAll(methodObject5841, var3));
      }
   }

   public void updateCharacterStream(int arg0, Reader arg1) throws SQLException {
      try {
         super.preForUpdateStreams(methodObject6049, this, arg0, arg1);
         Method var10001 = methodObject6049;
         this.delegate.updateCharacterStream(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject6049, var4);
      }
   }

   public void updateCharacterStream(String arg0, Reader arg1) throws SQLException {
      try {
         super.preForUpdateStreams(methodObject6050, this, arg0, arg1);
         Method var10001 = methodObject6050;
         this.delegate.updateCharacterStream(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject6050, var4);
      }
   }

   public void updateSQLXML(String arg0, SQLXML arg1) throws SQLException {
      try {
         super.preForAll(methodObject6091, this, arg0, arg1);
         Method var10001 = methodObject6091;
         this.delegate.updateSQLXML(arg0, arg1 instanceof _Proxy_ ? (SQLXML)((_Proxy_)arg1)._getDelegate_() : arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject6091, var4);
      }
   }

   public void updateNClob(int arg0, NClob arg1) throws SQLException {
      try {
         super.preForAll(methodObject6071, this, arg0, arg1);
         Method var10001 = methodObject6071;
         this.delegate.updateNClob(arg0, arg1 instanceof _Proxy_ ? (NClob)((_Proxy_)arg1)._getDelegate_() : arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject6071, var4);
      }
   }

   public Time getTime(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject5992, this, arg0);
         return (Time)this.postForAll(methodObject5992, (Object)this.delegate.getTime(arg0));
      } catch (SQLException var3) {
         return (Time)this.postForAll(methodObject5992, this.onErrorForAll(methodObject5992, var3));
      }
   }

   public void updateInt(int arg0, int arg1) throws SQLException {
      try {
         super.preForAll(methodObject6063, this, arg0, arg1);
         Method var10001 = methodObject6063;
         this.delegate.updateInt(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject6063, var4);
      }
   }

   public void updateClob(int arg0, Clob arg1) throws SQLException {
      try {
         super.preForAll(methodObject6051, this, arg0, arg1);
         Method var10001 = methodObject6051;
         this.delegate.updateClob(arg0, arg1 instanceof _Proxy_ ? (Clob)((_Proxy_)arg1)._getDelegate_() : arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject6051, var4);
      }
   }

   public float getFloat(String arg0) throws SQLException {
      try {
         super.preForAll(methodObject5938, this, arg0);
         return (Float)this.postForAll(methodObject5938, this.delegate.getFloat(arg0));
      } catch (SQLException var3) {
         return (Float)this.postForAll(methodObject5938, this.onErrorForAll(methodObject5938, var3));
      }
   }

   public void updateBytes(int arg0, byte[] arg1) throws SQLException {
      try {
         super.preForAll(methodObject6043, this, arg0, arg1);
         Method var10001 = methodObject6043;
         this.delegate.updateBytes(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject6043, var4);
      }
   }

   public INTERVALDS getINTERVALDS(String arg0) throws SQLException {
      try {
         super.preForAll(methodObject5872, this, arg0);
         return (INTERVALDS)this.postForAll(methodObject5872, (Object)this.delegate.getINTERVALDS(arg0));
      } catch (SQLException var3) {
         return (INTERVALDS)this.postForAll(methodObject5872, this.onErrorForAll(methodObject5872, var3));
      }
   }

   public InputStream getBinaryStream(String arg0) throws SQLException {
      try {
         super.preForAll(methodObject5973, this, arg0);
         return (InputStream)this.postForAll(methodObject5973, (Object)this.delegate.getBinaryStream(arg0));
      } catch (SQLException var3) {
         return (InputStream)this.postForAll(methodObject5973, this.onErrorForAll(methodObject5973, var3));
      }
   }

   public Reader getCharacterStream(String arg0) throws SQLException {
      try {
         super.preForAll(methodObject6100, this, arg0);
         return (Reader)this.postForAll(methodObject6100, (Object)this.delegate.getCharacterStream(arg0));
      } catch (SQLException var3) {
         return (Reader)this.postForAll(methodObject6100, this.onErrorForAll(methodObject6100, var3));
      }
   }

   public void updateBLOB(String arg0, BLOB arg1) throws SQLException {
      try {
         super.preForAll(methodObject5896, this, arg0, arg1);
         Method var10001 = methodObject5896;
         this.delegate.updateBLOB(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject5896, var4);
      }
   }

   public void updateString(String arg0, String arg1) throws SQLException {
      try {
         super.preForAll(methodObject6104, this, arg0, arg1);
         Method var10001 = methodObject6104;
         this.delegate.updateString(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject6104, var4);
      }
   }

   public void updateNClob(String arg0, Reader arg1, long arg2) throws SQLException {
      try {
         super.preForAll(methodObject6074, this, arg0, arg1, arg2);
         Method var10001 = methodObject6074;
         this.delegate.updateNClob(arg0, arg1, arg2);
         this.postForAll(var10001);
      } catch (SQLException var6) {
         this.onErrorVoidForAll(methodObject6074, var6);
      }
   }

   public InputStream getAsciiStream(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject5966, this, arg0);
         return (InputStream)this.postForAll(methodObject5966, (Object)this.delegate.getAsciiStream(arg0));
      } catch (SQLException var3) {
         return (InputStream)this.postForAll(methodObject5966, this.onErrorForAll(methodObject5966, var3));
      }
   }

   public Timestamp getTimestamp(String arg0, Calendar arg1) throws SQLException {
      try {
         super.preForAll(methodObject5999, this, arg0, arg1);
         return (Timestamp)this.postForAll(methodObject5999, (Object)this.delegate.getTimestamp(arg0, arg1));
      } catch (SQLException var4) {
         return (Timestamp)this.postForAll(methodObject5999, this.onErrorForAll(methodObject5999, var4));
      }
   }

   public void updateCHAR(String arg0, CHAR arg1) throws SQLException {
      try {
         super.preForAll(methodObject5898, this, arg0, arg1);
         Method var10001 = methodObject5898;
         this.delegate.updateCHAR(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject5898, var4);
      }
   }

   public void updateNCharacterStream(String arg0, Reader arg1, long arg2) throws SQLException {
      try {
         super.preForUpdateStreams(methodObject6068, this, arg0, arg1, arg2);
         Method var10001 = methodObject6068;
         this.delegate.updateNCharacterStream(arg0, arg1, arg2);
         this.postForAll(var10001);
      } catch (SQLException var6) {
         this.onErrorVoidForAll(methodObject6068, var6);
      }
   }

   public void refreshRow() throws SQLException {
      try {
         super.preForAll(methodObject6010, this, zeroLengthObjectArray);
         Method var10001 = methodObject6010;
         this.delegate.refreshRow();
         this.postForAll(var10001);
      } catch (SQLException var2) {
         this.onErrorVoidForAll(methodObject6010, var2);
      }
   }

   public RAW getRAW(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject5861, this, arg0);
         return (RAW)this.postForAll(methodObject5861, (Object)this.delegate.getRAW(arg0));
      } catch (SQLException var3) {
         return (RAW)this.postForAll(methodObject5861, this.onErrorForAll(methodObject5861, var3));
      }
   }

   public void updateShort(int arg0, short arg1) throws SQLException {
      try {
         super.preForAll(methodObject6101, this, arg0, arg1);
         Method var10001 = methodObject6101;
         this.delegate.updateShort(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject6101, var4);
      }
   }

   public CLOB getCLOB(String arg0) throws SQLException {
      try {
         super.preForAll(methodObject5850, this, arg0);
         return (CLOB)this.postForAll(methodObject5850, (Object)this.delegate.getCLOB(arg0));
      } catch (SQLException var3) {
         return (CLOB)this.postForAll(methodObject5850, this.onErrorForAll(methodObject5850, var3));
      }
   }

   public void updateNCharacterStream(int arg0, Reader arg1) throws SQLException {
      try {
         super.preForUpdateStreams(methodObject6069, this, arg0, arg1);
         Method var10001 = methodObject6069;
         this.delegate.updateNCharacterStream(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject6069, var4);
      }
   }

   public Reader getNCharacterStream(String arg0) throws SQLException {
      try {
         super.preForAll(methodObject5981, this, arg0);
         return (Reader)this.postForAll(methodObject5981, (Object)this.delegate.getNCharacterStream(arg0));
      } catch (SQLException var3) {
         return (Reader)this.postForAll(methodObject5981, this.onErrorForAll(methodObject5981, var3));
      }
   }

   public void updateCustomDatum(String arg0, CustomDatum arg1) throws SQLException {
      try {
         super.preForAll(methodObject5902, this, arg0, arg1);
         Method var10001 = methodObject5902;
         this.delegate.updateCustomDatum(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject5902, var4);
      }
   }

   public Object unwrap(Class arg0) throws SQLException {
      try {
         super.preForAll(methodObject6110, this, arg0);
         return this.postForAll(methodObject6110, this.proxyFactory.proxyForCache(this.delegate.unwrap(arg0), this, this.proxyCache, methodObject6110));
      } catch (SQLException var3) {
         return this.postForAll(methodObject6110, this.onErrorForAll(methodObject6110, var3));
      }
   }

   public oracle.jdbc.OracleResultSet.AuthorizationIndicator getAuthorizationIndicator(String arg0) throws SQLException {
      try {
         super.preForAll(methodObject5888, this, arg0);
         return (oracle.jdbc.OracleResultSet.AuthorizationIndicator)this.postForAll(methodObject5888, (Object)this.delegate.getAuthorizationIndicator(arg0));
      } catch (SQLException var3) {
         return (oracle.jdbc.OracleResultSet.AuthorizationIndicator)this.postForAll(methodObject5888, this.onErrorForAll(methodObject5888, var3));
      }
   }

   public void updateCharacterStream(int arg0, Reader arg1, long arg2) throws SQLException {
      try {
         super.preForUpdateStreams(methodObject6047, this, arg0, arg1, arg2);
         Method var10001 = methodObject6047;
         this.delegate.updateCharacterStream(arg0, arg1, arg2);
         this.postForAll(var10001);
      } catch (SQLException var6) {
         this.onErrorVoidForAll(methodObject6047, var6);
      }
   }

   public BFILE getBfile(String arg0) throws SQLException {
      try {
         super.preForAll(methodObject5844, this, arg0);
         return (BFILE)this.postForAll(methodObject5844, (Object)this.delegate.getBfile(arg0));
      } catch (SQLException var3) {
         return (BFILE)this.postForAll(methodObject5844, this.onErrorForAll(methodObject5844, var3));
      }
   }

   public byte[] getBytes(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject5941, this, arg0);
         return (byte[])this.postForAll(methodObject5941, (Object)this.delegate.getBytes(arg0));
      } catch (SQLException var3) {
         return (byte[])this.postForAll(methodObject5941, this.onErrorForAll(methodObject5941, var3));
      }
   }

   public void updateAsciiStream(String arg0, InputStream arg1, long arg2) throws SQLException {
      try {
         super.preForUpdateStreams(methodObject6022, this, arg0, arg1, arg2);
         Method var10001 = methodObject6022;
         this.delegate.updateAsciiStream(arg0, arg1, arg2);
         this.postForAll(var10001);
      } catch (SQLException var6) {
         this.onErrorVoidForAll(methodObject6022, var6);
      }
   }

   public void updateDouble(String arg0, double arg1) throws SQLException {
      try {
         super.preForAll(methodObject6060, this, arg0, arg1);
         Method var10001 = methodObject6060;
         this.delegate.updateDouble(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var5) {
         this.onErrorVoidForAll(methodObject6060, var5);
      }
   }

   public Datum getOracleObject(String arg0) throws SQLException {
      try {
         super.preForAll(methodObject5836, this, arg0);
         return (Datum)this.postForAll(methodObject5836, (Object)this.delegate.getOracleObject(arg0));
      } catch (SQLException var3) {
         return (Datum)this.postForAll(methodObject5836, this.onErrorForAll(methodObject5836, var3));
      }
   }

   public void updateCLOB(int arg0, CLOB arg1) throws SQLException {
      try {
         super.preForAll(methodObject5899, this, arg0, arg1);
         Method var10001 = methodObject5899;
         this.delegate.updateCLOB(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject5899, var4);
      }
   }

   public void updateTIMESTAMPLTZ(String arg0, TIMESTAMPLTZ arg1) throws SQLException {
      try {
         super.preForAll(methodObject5916, this, arg0, arg1);
         Method var10001 = methodObject5916;
         this.delegate.updateTIMESTAMPLTZ(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject5916, var4);
      }
   }

   public void updateNull(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject6079, this, arg0);
         Method var10001 = methodObject6079;
         this.delegate.updateNull(arg0);
         this.postForAll(var10001);
      } catch (SQLException var3) {
         this.onErrorVoidForAll(methodObject6079, var3);
      }
   }

   public void updateObject(String arg0, Object arg1, int arg2) throws SQLException {
      try {
         super.preForAll(methodObject6083, this, arg0, arg1, arg2);
         Method var10001 = methodObject6083;
         this.delegate.updateObject(arg0, arg1 instanceof _Proxy_ ? (Object)((_Proxy_)arg1)._getDelegate_() : arg1, arg2);
         this.postForAll(var10001);
      } catch (SQLException var5) {
         this.onErrorVoidForAll(methodObject6083, var5);
      }
   }

   public Date getDate(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject5955, this, arg0);
         return (Date)this.postForAll(methodObject5955, (Object)this.delegate.getDate(arg0));
      } catch (SQLException var3) {
         return (Date)this.postForAll(methodObject5955, this.onErrorForAll(methodObject5955, var3));
      }
   }

   public boolean wasNull() throws SQLException {
      try {
         super.preForAll(methodObject6109, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject6109, this.delegate.wasNull());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject6109, this.onErrorForAll(methodObject6109, var2));
      }
   }

   public long getLong(String arg0) throws SQLException {
      try {
         super.preForAll(methodObject5936, this, arg0);
         return (Long)this.postForAll(methodObject5936, this.delegate.getLong(arg0));
      } catch (SQLException var3) {
         return (Long)this.postForAll(methodObject5936, this.onErrorForAll(methodObject5936, var3));
      }
   }

   public void updateNCharacterStream(String arg0, Reader arg1) throws SQLException {
      try {
         super.preForUpdateStreams(methodObject6070, this, arg0, arg1);
         Method var10001 = methodObject6070;
         this.delegate.updateNCharacterStream(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject6070, var4);
      }
   }

   public boolean isWrapperFor(Class arg0) throws SQLException {
      try {
         super.preForAll(methodObject6111, this, arg0);
         return (Boolean)this.postForAll(methodObject6111, this.delegate.isWrapperFor(arg0));
      } catch (SQLException var3) {
         return (Boolean)this.postForAll(methodObject6111, this.onErrorForAll(methodObject6111, var3));
      }
   }

   public void updateRow() throws SQLException {
      try {
         super.preForAll(methodObject6087, this, zeroLengthObjectArray);
         Method var10001 = methodObject6087;
         this.delegate.updateRow();
         this.postForAll(var10001);
      } catch (SQLException var2) {
         this.onErrorVoidForAll(methodObject6087, var2);
      }
   }

   public Reader getNCharacterStream(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject5980, this, arg0);
         return (Reader)this.postForAll(methodObject5980, (Object)this.delegate.getNCharacterStream(arg0));
      } catch (SQLException var3) {
         return (Reader)this.postForAll(methodObject5980, this.onErrorForAll(methodObject5980, var3));
      }
   }

   public boolean isAfterLast() throws SQLException {
      try {
         super.preForAll(methodObject6003, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject6003, this.delegate.isAfterLast());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject6003, this.onErrorForAll(methodObject6003, var2));
      }
   }

   public void updateNString(int arg0, String arg1) throws SQLException {
      try {
         super.preForAll(methodObject6077, this, arg0, arg1);
         Method var10001 = methodObject6077;
         this.delegate.updateNString(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject6077, var4);
      }
   }

   public void updateNClob(String arg0, NClob arg1) throws SQLException {
      try {
         super.preForAll(methodObject6072, this, arg0, arg1);
         Method var10001 = methodObject6072;
         this.delegate.updateNClob(arg0, arg1 instanceof _Proxy_ ? (NClob)((_Proxy_)arg1)._getDelegate_() : arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject6072, var4);
      }
   }

   public void setACProxy(Object arg0) {
      super.preForAll(methodObject6112, this, arg0);
      Method var10001 = methodObject6112;
      this.delegate.setACProxy(arg0 instanceof _Proxy_ ? (Object)((_Proxy_)arg0)._getDelegate_() : arg0);
      this.postForAll(var10001);
   }

   public void updateShort(String arg0, short arg1) throws SQLException {
      try {
         super.preForAll(methodObject6102, this, arg0, arg1);
         Method var10001 = methodObject6102;
         this.delegate.updateShort(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject6102, var4);
      }
   }

   public InputStream getAsciiStream(String arg0) throws SQLException {
      try {
         super.preForAll(methodObject5967, this, arg0);
         return (InputStream)this.postForAll(methodObject5967, (Object)this.delegate.getAsciiStream(arg0));
      } catch (SQLException var3) {
         return (InputStream)this.postForAll(methodObject5967, this.onErrorForAll(methodObject5967, var3));
      }
   }

   public void clearWarnings() throws SQLException {
      try {
         super.preForAll(methodObject6092, this, zeroLengthObjectArray);
         Method var10001 = methodObject6092;
         this.delegate.clearWarnings();
         this.postForAll(var10001);
      } catch (SQLException var2) {
         this.onErrorVoidForAll(methodObject6092, var2);
      }
   }

   public void updateAsciiStream(String arg0, InputStream arg1) throws SQLException {
      try {
         super.preForUpdateStreams(methodObject6024, this, arg0, arg1);
         Method var10001 = methodObject6024;
         this.delegate.updateAsciiStream(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject6024, var4);
      }
   }

   public boolean getBoolean(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject5927, this, arg0);
         return (Boolean)this.postForAll(methodObject5927, this.delegate.getBoolean(arg0));
      } catch (SQLException var3) {
         return (Boolean)this.postForAll(methodObject5927, this.onErrorForAll(methodObject5927, var3));
      }
   }

   public double getDouble(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject5939, this, arg0);
         return (Double)this.postForAll(methodObject5939, this.delegate.getDouble(arg0));
      } catch (SQLException var3) {
         return (Double)this.postForAll(methodObject5939, this.onErrorForAll(methodObject5939, var3));
      }
   }

   public void updateByte(String arg0, byte arg1) throws SQLException {
      try {
         super.preForAll(methodObject6042, this, arg0, arg1);
         Method var10001 = methodObject6042;
         this.delegate.updateByte(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject6042, var4);
      }
   }

   public void updateOracleObject(String arg0, Datum arg1) throws SQLException {
      try {
         super.preForAll(methodObject5880, this, arg0, arg1);
         Method var10001 = methodObject5880;
         this.delegate.updateOracleObject(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject5880, var4);
      }
   }

   public ResultSetMetaData getMetaData() throws SQLException {
      try {
         super.preForAll(methodObject6094, this, zeroLengthObjectArray);
         return (ResultSetMetaData)this.postForAll(methodObject6094, this.proxyFactory.proxyForCache((Object)this.delegate.getMetaData(), this, this.proxyCache, methodObject6094));
      } catch (SQLException var2) {
         return (ResultSetMetaData)this.postForAll(methodObject6094, this.onErrorForAll(methodObject6094, var2));
      }
   }

   public void updateORAData(int arg0, ORAData arg1) throws SQLException {
      try {
         super.preForAll(methodObject5903, this, arg0, arg1);
         Method var10001 = methodObject5903;
         this.delegate.updateORAData(arg0, arg1 instanceof _Proxy_ ? (ORAData)((_Proxy_)arg1)._getDelegate_() : arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject5903, var4);
      }
   }

   public STRUCT getSTRUCT(String arg0) throws SQLException {
      try {
         super.preForAll(methodObject5868, this, arg0);
         return (STRUCT)this.postForAll(methodObject5868, (Object)this.delegate.getSTRUCT(arg0));
      } catch (SQLException var3) {
         return (STRUCT)this.postForAll(methodObject5868, this.onErrorForAll(methodObject5868, var3));
      }
   }

   public boolean isClosed() throws SQLException {
      try {
         super.preForAll(methodObject6096, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject6096, this.delegate.isClosed());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject6096, this.onErrorForAll(methodObject6096, var2));
      }
   }

   public void updateBFILE(String arg0, BFILE arg1) throws SQLException {
      try {
         super.preForAll(methodObject5894, this, arg0, arg1);
         Method var10001 = methodObject5894;
         this.delegate.updateBFILE(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject5894, var4);
      }
   }

   public void updateAsciiStream(String arg0, InputStream arg1, int arg2) throws SQLException {
      try {
         super.preForUpdateStreams(methodObject6020, this, arg0, arg1, arg2);
         Method var10001 = methodObject6020;
         this.delegate.updateAsciiStream(arg0, arg1, arg2);
         this.postForAll(var10001);
      } catch (SQLException var5) {
         this.onErrorVoidForAll(methodObject6020, var5);
      }
   }

   public Ref getRef(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject5951, this, arg0);
         return (Ref)this.postForAll(methodObject5951, this.proxyFactory.proxyForCache((Object)this.delegate.getRef(arg0), this, this.proxyCache, methodObject5951));
      } catch (SQLException var3) {
         return (Ref)this.postForAll(methodObject5951, this.onErrorForAll(methodObject5951, var3));
      }
   }

   public oracle.jdbc.OracleResultSet.AuthorizationIndicator getAuthorizationIndicator(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject5887, this, arg0);
         return (oracle.jdbc.OracleResultSet.AuthorizationIndicator)this.postForAll(methodObject5887, (Object)this.delegate.getAuthorizationIndicator(arg0));
      } catch (SQLException var3) {
         return (oracle.jdbc.OracleResultSet.AuthorizationIndicator)this.postForAll(methodObject5887, this.onErrorForAll(methodObject5887, var3));
      }
   }

   public boolean last() throws SQLException {
      try {
         super.preForAll(methodObject6007, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject6007, this.delegate.last());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject6007, this.onErrorForLast(methodObject6007, var2));
      }
   }

   public boolean rowUpdated() throws SQLException {
      try {
         super.preForAll(methodObject6014, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject6014, this.delegate.rowUpdated());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject6014, this.onErrorForAll(methodObject6014, var2));
      }
   }

   public void updateBLOB(int arg0, BLOB arg1) throws SQLException {
      try {
         super.preForAll(methodObject5895, this, arg0, arg1);
         Method var10001 = methodObject5895;
         this.delegate.updateBLOB(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject5895, var4);
      }
   }

   public NUMBER getNUMBER(String arg0) throws SQLException {
      try {
         super.preForAll(methodObject5858, this, arg0);
         return (NUMBER)this.postForAll(methodObject5858, (Object)this.delegate.getNUMBER(arg0));
      } catch (SQLException var3) {
         return (NUMBER)this.postForAll(methodObject5858, this.onErrorForAll(methodObject5858, var3));
      }
   }

   public Time getTime(String arg0) throws SQLException {
      try {
         super.preForAll(methodObject5993, this, arg0);
         return (Time)this.postForAll(methodObject5993, (Object)this.delegate.getTime(arg0));
      } catch (SQLException var3) {
         return (Time)this.postForAll(methodObject5993, this.onErrorForAll(methodObject5993, var3));
      }
   }

   public Object getObject(int arg0, Map arg1) throws SQLException {
      try {
         super.preForAll(methodObject5923, this, arg0, arg1);
         return this.postForAll(methodObject5923, this.proxyFactory.proxyForCache(this.delegate.getObject(arg0, arg1), this, this.proxyCache, methodObject5923));
      } catch (SQLException var4) {
         return this.postForAll(methodObject5923, this.onErrorForAll(methodObject5923, var4));
      }
   }

   public Clob getClob(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject5974, this, arg0);
         return (Clob)this.postForAll(methodObject5974, this.proxyFactory.proxyForCache((Object)this.delegate.getClob(arg0), this, this.proxyCache, methodObject5974));
      } catch (SQLException var3) {
         return (Clob)this.postForAll(methodObject5974, this.onErrorForAll(methodObject5974, var3));
      }
   }

   public Time getTime(int arg0, Calendar arg1) throws SQLException {
      try {
         super.preForAll(methodObject5994, this, arg0, arg1);
         return (Time)this.postForAll(methodObject5994, (Object)this.delegate.getTime(arg0, arg1));
      } catch (SQLException var4) {
         return (Time)this.postForAll(methodObject5994, this.onErrorForAll(methodObject5994, var4));
      }
   }

   public URL getURL(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject5946, this, arg0);
         return (URL)this.postForAll(methodObject5946, (Object)this.delegate.getURL(arg0));
      } catch (SQLException var3) {
         return (URL)this.postForAll(methodObject5946, this.onErrorForAll(methodObject5946, var3));
      }
   }

   public int getFetchDirection() throws SQLException {
      try {
         super.preForAll(methodObject5978, this, zeroLengthObjectArray);
         return (Integer)this.postForAll(methodObject5978, this.delegate.getFetchDirection());
      } catch (SQLException var2) {
         return (Integer)this.postForAll(methodObject5978, this.onErrorForAll(methodObject5978, var2));
      }
   }

   public boolean isFirst() throws SQLException {
      try {
         super.preForAll(methodObject6005, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject6005, this.delegate.isFirst());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject6005, this.onErrorForAll(methodObject6005, var2));
      }
   }

   public void updateFloat(String arg0, float arg1) throws SQLException {
      try {
         super.preForAll(methodObject6062, this, arg0, arg1);
         Method var10001 = methodObject6062;
         this.delegate.updateFloat(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject6062, var4);
      }
   }

   public void updateINTERVALDS(String arg0, INTERVALDS arg1) throws SQLException {
      try {
         super.preForAll(methodObject5910, this, arg0, arg1);
         Method var10001 = methodObject5910;
         this.delegate.updateINTERVALDS(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject5910, var4);
      }
   }

   public boolean previous() throws SQLException {
      try {
         super.preForAll(methodObject5950, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject5950, this.delegate.previous());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject5950, this.onErrorForAll(methodObject5950, var2));
      }
   }

   public void updateARRAY(String arg0, ARRAY arg1) throws SQLException {
      try {
         super.preForAll(methodObject5890, this, arg0, arg1);
         Method var10001 = methodObject5890;
         this.delegate.updateARRAY(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject5890, var4);
      }
   }

   public byte getByte(String arg0) throws SQLException {
      try {
         super.preForAll(methodObject5930, this, arg0);
         return (Byte)this.postForAll(methodObject5930, this.delegate.getByte(arg0));
      } catch (SQLException var3) {
         return (Byte)this.postForAll(methodObject5930, this.onErrorForAll(methodObject5930, var3));
      }
   }

   public void updateRAW(int arg0, RAW arg1) throws SQLException {
      try {
         super.preForAll(methodObject5919, this, arg0, arg1);
         Method var10001 = methodObject5919;
         this.delegate.updateRAW(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject5919, var4);
      }
   }

   public ORAData getORAData(int arg0, ORADataFactory arg1) throws SQLException {
      try {
         super.preForAll(methodObject5853, this, arg0, arg1);
         return (ORAData)this.postForAll(methodObject5853, this.proxyFactory.proxyForCache((Object)this.delegate.getORAData(arg0, arg1), this, this.proxyCache, methodObject5853));
      } catch (SQLException var4) {
         return (ORAData)this.postForAll(methodObject5853, this.onErrorForAll(methodObject5853, var4));
      }
   }

   public void updateINTERVALDS(int arg0, INTERVALDS arg1) throws SQLException {
      try {
         super.preForAll(methodObject5909, this, arg0, arg1);
         Method var10001 = methodObject5909;
         this.delegate.updateINTERVALDS(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject5909, var4);
      }
   }

   public void updateTIMESTAMPTZ(String arg0, TIMESTAMPTZ arg1) throws SQLException {
      try {
         super.preForAll(methodObject5914, this, arg0, arg1);
         Method var10001 = methodObject5914;
         this.delegate.updateTIMESTAMPTZ(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject5914, var4);
      }
   }

   public String getNString(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject5984, this, arg0);
         return (String)this.postForAll(methodObject5984, (Object)this.delegate.getNString(arg0));
      } catch (SQLException var3) {
         return (String)this.postForAll(methodObject5984, this.onErrorForAll(methodObject5984, var3));
      }
   }

   public long getLong(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject5935, this, arg0);
         return (Long)this.postForAll(methodObject5935, this.delegate.getLong(arg0));
      } catch (SQLException var3) {
         return (Long)this.postForAll(methodObject5935, this.onErrorForAll(methodObject5935, var3));
      }
   }

   public ROWID getROWID(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject5865, this, arg0);
         return (ROWID)this.postForAll(methodObject5865, (Object)this.delegate.getROWID(arg0));
      } catch (SQLException var3) {
         return (ROWID)this.postForAll(methodObject5865, this.onErrorForAll(methodObject5865, var3));
      }
   }

   public boolean next() throws SQLException {
      try {
         super.preForAll(methodObject5945, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject5945, this.delegate.next());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject5945, this.onErrorForAll(methodObject5945, var2));
      }
   }

   public int getType() throws SQLException {
      try {
         super.preForAll(methodObject5949, this, zeroLengthObjectArray);
         return (Integer)this.postForAll(methodObject5949, this.delegate.getType());
      } catch (SQLException var2) {
         return (Integer)this.postForAll(methodObject5949, this.onErrorForAll(methodObject5949, var2));
      }
   }

   public NClob getNClob(String arg0) throws SQLException {
      try {
         super.preForAll(methodObject5983, this, arg0);
         return (NClob)this.postForAll(methodObject5983, this.proxyFactory.proxyForCache((Object)this.delegate.getNClob(arg0), this, this.proxyCache, methodObject5983));
      } catch (SQLException var3) {
         return (NClob)this.postForAll(methodObject5983, this.onErrorForAll(methodObject5983, var3));
      }
   }

   public Date getDate(String arg0) throws SQLException {
      try {
         super.preForAll(methodObject5956, this, arg0);
         return (Date)this.postForAll(methodObject5956, (Object)this.delegate.getDate(arg0));
      } catch (SQLException var3) {
         return (Date)this.postForAll(methodObject5956, this.onErrorForAll(methodObject5956, var3));
      }
   }

   public Object getObject(String arg0, Class arg1) throws SQLException {
      try {
         super.preForAll(methodObject5926, this, arg0, arg1);
         return this.postForAll(methodObject5926, this.proxyFactory.proxyForCache(this.delegate.getObject(arg0, arg1), this, this.proxyCache, methodObject5926));
      } catch (SQLException var4) {
         return this.postForAll(methodObject5926, this.onErrorForAll(methodObject5926, var4));
      }
   }

   public OPAQUE getOPAQUE(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject5859, this, arg0);
         return (OPAQUE)this.postForAll(methodObject5859, (Object)this.delegate.getOPAQUE(arg0));
      } catch (SQLException var3) {
         return (OPAQUE)this.postForAll(methodObject5859, this.onErrorForAll(methodObject5859, var3));
      }
   }

   public Object getObject(String arg0, OracleDataFactory arg1) throws SQLException {
      try {
         super.preForAll(methodObject5834, this, arg0, arg1);
         return this.postForAll(methodObject5834, this.proxyFactory.proxyForCache(this.delegate.getObject(arg0, arg1), this, this.proxyCache, methodObject5834));
      } catch (SQLException var4) {
         return this.postForAll(methodObject5834, this.onErrorForAll(methodObject5834, var4));
      }
   }

   public TIMESTAMPTZ getTIMESTAMPTZ(String arg0) throws SQLException {
      try {
         super.preForAll(methodObject5876, this, arg0);
         return (TIMESTAMPTZ)this.postForAll(methodObject5876, (Object)this.delegate.getTIMESTAMPTZ(arg0));
      } catch (SQLException var3) {
         return (TIMESTAMPTZ)this.postForAll(methodObject5876, this.onErrorForAll(methodObject5876, var3));
      }
   }

   public Clob getClob(String arg0) throws SQLException {
      try {
         super.preForAll(methodObject5975, this, arg0);
         return (Clob)this.postForAll(methodObject5975, this.proxyFactory.proxyForCache((Object)this.delegate.getClob(arg0), this, this.proxyCache, methodObject5975));
      } catch (SQLException var3) {
         return (Clob)this.postForAll(methodObject5975, this.onErrorForAll(methodObject5975, var3));
      }
   }

   public int getInt(String arg0) throws SQLException {
      try {
         super.preForAll(methodObject5934, this, arg0);
         return (Integer)this.postForAll(methodObject5934, this.delegate.getInt(arg0));
      } catch (SQLException var3) {
         return (Integer)this.postForAll(methodObject5934, this.onErrorForAll(methodObject5934, var3));
      }
   }

   public void updateArray(String arg0, Array arg1) throws SQLException {
      try {
         super.preForAll(methodObject6018, this, arg0, arg1);
         Method var10001 = methodObject6018;
         this.delegate.updateArray(arg0, arg1 instanceof _Proxy_ ? (Array)((_Proxy_)arg1)._getDelegate_() : arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject6018, var4);
      }
   }

   public TIMESTAMP getTIMESTAMP(String arg0) throws SQLException {
      try {
         super.preForAll(methodObject5874, this, arg0);
         return (TIMESTAMP)this.postForAll(methodObject5874, (Object)this.delegate.getTIMESTAMP(arg0));
      } catch (SQLException var3) {
         return (TIMESTAMP)this.postForAll(methodObject5874, this.onErrorForAll(methodObject5874, var3));
      }
   }

   public INTERVALDS getINTERVALDS(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject5871, this, arg0);
         return (INTERVALDS)this.postForAll(methodObject5871, (Object)this.delegate.getINTERVALDS(arg0));
      } catch (SQLException var3) {
         return (INTERVALDS)this.postForAll(methodObject5871, this.onErrorForAll(methodObject5871, var3));
      }
   }

   public void updateNClob(String arg0, Reader arg1) throws SQLException {
      try {
         super.preForAll(methodObject6076, this, arg0, arg1);
         Method var10001 = methodObject6076;
         this.delegate.updateNClob(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject6076, var4);
      }
   }

   public void updateBigDecimal(String arg0, BigDecimal arg1) throws SQLException {
      try {
         super.preForAll(methodObject6026, this, arg0, arg1);
         Method var10001 = methodObject6026;
         this.delegate.updateBigDecimal(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject6026, var4);
      }
   }

   public void updateREF(String arg0, REF arg1) throws SQLException {
      try {
         super.preForAll(methodObject5882, this, arg0, arg1);
         Method var10001 = methodObject5882;
         this.delegate.updateREF(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject5882, var4);
      }
   }

   public void updateTime(int arg0, Time arg1) throws SQLException {
      try {
         super.preForAll(methodObject6105, this, arg0, arg1);
         Method var10001 = methodObject6105;
         this.delegate.updateTime(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject6105, var4);
      }
   }

   public void updateNCharacterStream(int arg0, Reader arg1, long arg2) throws SQLException {
      try {
         super.preForUpdateStreams(methodObject6067, this, arg0, arg1, arg2);
         Method var10001 = methodObject6067;
         this.delegate.updateNCharacterStream(arg0, arg1, arg2);
         this.postForAll(var10001);
      } catch (SQLException var6) {
         this.onErrorVoidForAll(methodObject6067, var6);
      }
   }

   public BFILE getBFILE(String arg0) throws SQLException {
      try {
         super.preForAll(methodObject5842, this, arg0);
         return (BFILE)this.postForAll(methodObject5842, (Object)this.delegate.getBFILE(arg0));
      } catch (SQLException var3) {
         return (BFILE)this.postForAll(methodObject5842, this.onErrorForAll(methodObject5842, var3));
      }
   }

   public void updateNUMBER(int arg0, NUMBER arg1) throws SQLException {
      try {
         super.preForAll(methodObject5917, this, arg0, arg1);
         Method var10001 = methodObject5917;
         this.delegate.updateNUMBER(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject5917, var4);
      }
   }

   public Time getTime(String arg0, Calendar arg1) throws SQLException {
      try {
         super.preForAll(methodObject5995, this, arg0, arg1);
         return (Time)this.postForAll(methodObject5995, (Object)this.delegate.getTime(arg0, arg1));
      } catch (SQLException var4) {
         return (Time)this.postForAll(methodObject5995, this.onErrorForAll(methodObject5995, var4));
      }
   }

   public void updateBinaryStream(int arg0, InputStream arg1, long arg2) throws SQLException {
      try {
         super.preForUpdateStreams(methodObject6029, this, arg0, arg1, arg2);
         Method var10001 = methodObject6029;
         this.delegate.updateBinaryStream(arg0, arg1, arg2);
         this.postForAll(var10001);
      } catch (SQLException var6) {
         this.onErrorVoidForAll(methodObject6029, var6);
      }
   }

   public void updateSTRUCT(int arg0, STRUCT arg1) throws SQLException {
      try {
         super.preForAll(methodObject5885, this, arg0, arg1);
         Method var10001 = methodObject5885;
         this.delegate.updateSTRUCT(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject5885, var4);
      }
   }

   public void beforeFirst() throws SQLException {
      try {
         super.preForAll(methodObject5961, this, zeroLengthObjectArray);
         Method var10001 = methodObject5961;
         this.delegate.beforeFirst();
         this.postForAll(var10001);
      } catch (SQLException var2) {
         this.onErrorVoidForAll(methodObject5961, var2);
      }
   }

   public void updateLong(String arg0, long arg1) throws SQLException {
      try {
         super.preForAll(methodObject6066, this, arg0, arg1);
         Method var10001 = methodObject6066;
         this.delegate.updateLong(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var5) {
         this.onErrorVoidForAll(methodObject6066, var5);
      }
   }

   public void updateRef(String arg0, Ref arg1) throws SQLException {
      try {
         super.preForAll(methodObject6086, this, arg0, arg1);
         Method var10001 = methodObject6086;
         this.delegate.updateRef(arg0, arg1 instanceof _Proxy_ ? (Ref)((_Proxy_)arg1)._getDelegate_() : arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject6086, var4);
      }
   }

   public void updateFloat(int arg0, float arg1) throws SQLException {
      try {
         super.preForAll(methodObject6061, this, arg0, arg1);
         Method var10001 = methodObject6061;
         this.delegate.updateFloat(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject6061, var4);
      }
   }

   public BigDecimal getBigDecimal(int arg0, int arg1) throws SQLException {
      try {
         super.preForAll(methodObject5968, this, arg0, arg1);
         return (BigDecimal)this.postForAll(methodObject5968, (Object)this.delegate.getBigDecimal(arg0, arg1));
      } catch (SQLException var4) {
         return (BigDecimal)this.postForAll(methodObject5968, this.onErrorForAll(methodObject5968, var4));
      }
   }

   public InputStream getBinaryStream(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject5972, this, arg0);
         return (InputStream)this.postForAll(methodObject5972, (Object)this.delegate.getBinaryStream(arg0));
      } catch (SQLException var3) {
         return (InputStream)this.postForAll(methodObject5972, this.onErrorForAll(methodObject5972, var3));
      }
   }

   public void updateBoolean(String arg0, boolean arg1) throws SQLException {
      try {
         super.preForAll(methodObject6040, this, arg0, arg1);
         Method var10001 = methodObject6040;
         this.delegate.updateBoolean(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject6040, var4);
      }
   }

   public void updateCLOB(String arg0, CLOB arg1) throws SQLException {
      try {
         super.preForAll(methodObject5900, this, arg0, arg1);
         Method var10001 = methodObject5900;
         this.delegate.updateCLOB(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject5900, var4);
      }
   }

   public Object getObject(int arg0, OracleDataFactory arg1) throws SQLException {
      try {
         super.preForAll(methodObject5833, this, arg0, arg1);
         return this.postForAll(methodObject5833, this.proxyFactory.proxyForCache(this.delegate.getObject(arg0, arg1), this, this.proxyCache, methodObject5833));
      } catch (SQLException var4) {
         return this.postForAll(methodObject5833, this.onErrorForAll(methodObject5833, var4));
      }
   }

   public String getString(String arg0) throws SQLException {
      try {
         super.preForAll(methodObject5954, this, arg0);
         return (String)this.postForAll(methodObject5954, (Object)this.delegate.getString(arg0));
      } catch (SQLException var3) {
         return (String)this.postForAll(methodObject5954, this.onErrorForAll(methodObject5954, var3));
      }
   }

   public boolean absolute(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject5959, this, arg0);
         return (Boolean)this.postForAll(methodObject5959, this.delegate.absolute(arg0));
      } catch (SQLException var3) {
         return (Boolean)this.postForAll(methodObject5959, this.onErrorForAll(methodObject5959, var3));
      }
   }

   public void deleteRow() throws SQLException {
      try {
         super.preForAll(methodObject5963, this, zeroLengthObjectArray);
         Method var10001 = methodObject5963;
         this.delegate.deleteRow();
         this.postForAll(var10001);
      } catch (SQLException var2) {
         this.onErrorVoidForAll(methodObject5963, var2);
      }
   }

   public CHAR getCHAR(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject5847, this, arg0);
         return (CHAR)this.postForAll(methodObject5847, (Object)this.delegate.getCHAR(arg0));
      } catch (SQLException var3) {
         return (CHAR)this.postForAll(methodObject5847, this.onErrorForAll(methodObject5847, var3));
      }
   }

   public void updateRowId(String arg0, RowId arg1) throws SQLException {
      try {
         super.preForAll(methodObject6089, this, arg0, arg1);
         Method var10001 = methodObject6089;
         this.delegate.updateRowId(arg0, arg1 instanceof _Proxy_ ? (RowId)((_Proxy_)arg1)._getDelegate_() : arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject6089, var4);
      }
   }

   public void updateDATE(String arg0, DATE arg1) throws SQLException {
      try {
         super.preForAll(methodObject5906, this, arg0, arg1);
         Method var10001 = methodObject5906;
         this.delegate.updateDATE(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject5906, var4);
      }
   }

   public SQLXML getSQLXML(String arg0) throws SQLException {
      try {
         super.preForAll(methodObject5990, this, arg0);
         return (SQLXML)this.postForAll(methodObject5990, this.proxyFactory.proxyForCache((Object)this.delegate.getSQLXML(arg0), this, this.proxyCache, methodObject5990));
      } catch (SQLException var3) {
         return (SQLXML)this.postForAll(methodObject5990, this.onErrorForAll(methodObject5990, var3));
      }
   }

   public Reader getCharacterStream(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject6099, this, arg0);
         return (Reader)this.postForAll(methodObject6099, (Object)this.delegate.getCharacterStream(arg0));
      } catch (SQLException var3) {
         return (Reader)this.postForAll(methodObject6099, this.onErrorForAll(methodObject6099, var3));
      }
   }

   public Date getDate(String arg0, Calendar arg1) throws SQLException {
      try {
         super.preForAll(methodObject5958, this, arg0, arg1);
         return (Date)this.postForAll(methodObject5958, (Object)this.delegate.getDate(arg0, arg1));
      } catch (SQLException var4) {
         return (Date)this.postForAll(methodObject5958, this.onErrorForAll(methodObject5958, var4));
      }
   }

   public boolean first() throws SQLException {
      try {
         super.preForAll(methodObject5965, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject5965, this.delegate.first());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject5965, this.onErrorForAll(methodObject5965, var2));
      }
   }

   public TIMESTAMP getTIMESTAMP(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject5873, this, arg0);
         return (TIMESTAMP)this.postForAll(methodObject5873, (Object)this.delegate.getTIMESTAMP(arg0));
      } catch (SQLException var3) {
         return (TIMESTAMP)this.postForAll(methodObject5873, this.onErrorForAll(methodObject5873, var3));
      }
   }

   public DATE getDATE(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject5855, this, arg0);
         return (DATE)this.postForAll(methodObject5855, (Object)this.delegate.getDATE(arg0));
      } catch (SQLException var3) {
         return (DATE)this.postForAll(methodObject5855, this.onErrorForAll(methodObject5855, var3));
      }
   }

   public BLOB getBLOB(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject5845, this, arg0);
         return (BLOB)this.postForAll(methodObject5845, (Object)this.delegate.getBLOB(arg0));
      } catch (SQLException var3) {
         return (BLOB)this.postForAll(methodObject5845, this.onErrorForAll(methodObject5845, var3));
      }
   }

   public void updateClob(int arg0, Reader arg1) throws SQLException {
      try {
         super.preForAll(methodObject6055, this, arg0, arg1);
         Method var10001 = methodObject6055;
         this.delegate.updateClob(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject6055, var4);
      }
   }

   public byte getByte(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject5929, this, arg0);
         return (Byte)this.postForAll(methodObject5929, this.delegate.getByte(arg0));
      } catch (SQLException var3) {
         return (Byte)this.postForAll(methodObject5929, this.onErrorForAll(methodObject5929, var3));
      }
   }

   public void updateDouble(int arg0, double arg1) throws SQLException {
      try {
         super.preForAll(methodObject6059, this, arg0, arg1);
         Method var10001 = methodObject6059;
         this.delegate.updateDouble(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var5) {
         this.onErrorVoidForAll(methodObject6059, var5);
      }
   }

   public Array getArray(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject5943, this, arg0);
         return (Array)this.postForAll(methodObject5943, this.proxyFactory.proxyForCache((Object)this.delegate.getArray(arg0), this, this.proxyCache, methodObject5943));
      } catch (SQLException var3) {
         return (Array)this.postForAll(methodObject5943, this.onErrorForAll(methodObject5943, var3));
      }
   }

   public void updateObject(int arg0, Object arg1) throws SQLException {
      try {
         super.preForAll(methodObject6082, this, arg0, arg1);
         Method var10001 = methodObject6082;
         this.delegate.updateObject(arg0, arg1 instanceof _Proxy_ ? (Object)((_Proxy_)arg1)._getDelegate_() : arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject6082, var4);
      }
   }

   public void setFetchSize(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject6016, this, arg0);
         Method var10001 = methodObject6016;
         this.delegate.setFetchSize(arg0);
         this.postForAll(var10001);
      } catch (SQLException var3) {
         this.onErrorVoidForAll(methodObject6016, var3);
      }
   }

   public short getShort(String arg0) throws SQLException {
      try {
         super.preForAll(methodObject5932, this, arg0);
         return (Short)this.postForAll(methodObject5932, this.delegate.getShort(arg0));
      } catch (SQLException var3) {
         return (Short)this.postForAll(methodObject5932, this.onErrorForAll(methodObject5932, var3));
      }
   }

   public void updateCHAR(int arg0, CHAR arg1) throws SQLException {
      try {
         super.preForAll(methodObject5897, this, arg0, arg1);
         Method var10001 = methodObject5897;
         this.delegate.updateCHAR(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject5897, var4);
      }
   }

   public void updateARRAY(int arg0, ARRAY arg1) throws SQLException {
      try {
         super.preForAll(methodObject5889, this, arg0, arg1);
         Method var10001 = methodObject5889;
         this.delegate.updateARRAY(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject5889, var4);
      }
   }

   public NUMBER getNUMBER(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject5857, this, arg0);
         return (NUMBER)this.postForAll(methodObject5857, (Object)this.delegate.getNUMBER(arg0));
      } catch (SQLException var3) {
         return (NUMBER)this.postForAll(methodObject5857, this.onErrorForAll(methodObject5857, var3));
      }
   }

   public RowId getRowId(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject5987, this, arg0);
         return (RowId)this.postForAll(methodObject5987, this.proxyFactory.proxyForCache((Object)this.delegate.getRowId(arg0), this, this.proxyCache, methodObject5987));
      } catch (SQLException var3) {
         return (RowId)this.postForAll(methodObject5987, this.onErrorForAll(methodObject5987, var3));
      }
   }

   public DATE getDATE(String arg0) throws SQLException {
      try {
         super.preForAll(methodObject5856, this, arg0);
         return (DATE)this.postForAll(methodObject5856, (Object)this.delegate.getDATE(arg0));
      } catch (SQLException var3) {
         return (DATE)this.postForAll(methodObject5856, this.onErrorForAll(methodObject5856, var3));
      }
   }

   public void moveToInsertRow() throws SQLException {
      try {
         super.preForAll(methodObject6009, this, zeroLengthObjectArray);
         Method var10001 = methodObject6009;
         this.delegate.moveToInsertRow();
         this.postForAll(var10001);
      } catch (SQLException var2) {
         this.onErrorVoidForAll(methodObject6009, var2);
      }
   }

   public void updateORAData(String arg0, ORAData arg1) throws SQLException {
      try {
         super.preForAll(methodObject5904, this, arg0, arg1);
         Method var10001 = methodObject5904;
         this.delegate.updateORAData(arg0, arg1 instanceof _Proxy_ ? (ORAData)((_Proxy_)arg1)._getDelegate_() : arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject5904, var4);
      }
   }

   public ARRAY getARRAY(String arg0) throws SQLException {
      try {
         super.preForAll(methodObject5840, this, arg0);
         return (ARRAY)this.postForAll(methodObject5840, (Object)this.delegate.getARRAY(arg0));
      } catch (SQLException var3) {
         return (ARRAY)this.postForAll(methodObject5840, this.onErrorForAll(methodObject5840, var3));
      }
   }

   public void updateBfile(String arg0, BFILE arg1) throws SQLException {
      try {
         super.preForAll(methodObject5892, this, arg0, arg1);
         Method var10001 = methodObject5892;
         this.delegate.updateBfile(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject5892, var4);
      }
   }

   public void updateOracleObject(int arg0, Datum arg1) throws SQLException {
      try {
         super.preForAll(methodObject5879, this, arg0, arg1);
         Method var10001 = methodObject5879;
         this.delegate.updateOracleObject(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject5879, var4);
      }
   }

   public void cancelRowUpdates() throws SQLException {
      try {
         super.preForAll(methodObject5962, this, zeroLengthObjectArray);
         Method var10001 = methodObject5962;
         this.delegate.cancelRowUpdates();
         this.postForAll(var10001);
      } catch (SQLException var2) {
         this.onErrorVoidForAll(methodObject5962, var2);
      }
   }

   public int getHoldability() throws SQLException {
      try {
         super.preForAll(methodObject6093, this, zeroLengthObjectArray);
         return (Integer)this.postForAll(methodObject6093, this.delegate.getHoldability());
      } catch (SQLException var2) {
         return (Integer)this.postForAll(methodObject6093, this.onErrorForAll(methodObject6093, var2));
      }
   }

   public Datum getOracleObject(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject5835, this, arg0);
         return (Datum)this.postForAll(methodObject5835, (Object)this.delegate.getOracleObject(arg0));
      } catch (SQLException var3) {
         return (Datum)this.postForAll(methodObject5835, this.onErrorForAll(methodObject5835, var3));
      }
   }

   public void updateClob(String arg0, Reader arg1, long arg2) throws SQLException {
      try {
         super.preForAll(methodObject6054, this, arg0, arg1, arg2);
         Method var10001 = methodObject6054;
         this.delegate.updateClob(arg0, arg1, arg2);
         this.postForAll(var10001);
      } catch (SQLException var6) {
         this.onErrorVoidForAll(methodObject6054, var6);
      }
   }

   public void updateTIMESTAMP(int arg0, TIMESTAMP arg1) throws SQLException {
      try {
         super.preForAll(methodObject5911, this, arg0, arg1);
         Method var10001 = methodObject5911;
         this.delegate.updateTIMESTAMP(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject5911, var4);
      }
   }

   public String getNString(String arg0) throws SQLException {
      try {
         super.preForAll(methodObject5985, this, arg0);
         return (String)this.postForAll(methodObject5985, (Object)this.delegate.getNString(arg0));
      } catch (SQLException var3) {
         return (String)this.postForAll(methodObject5985, this.onErrorForAll(methodObject5985, var3));
      }
   }

   public void updateObject(String arg0, Object arg1) throws SQLException {
      try {
         super.preForAll(methodObject6084, this, arg0, arg1);
         Method var10001 = methodObject6084;
         this.delegate.updateObject(arg0, arg1 instanceof _Proxy_ ? (Object)((_Proxy_)arg1)._getDelegate_() : arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject6084, var4);
      }
   }

   public void updateArray(int arg0, Array arg1) throws SQLException {
      try {
         super.preForAll(methodObject6017, this, arg0, arg1);
         Method var10001 = methodObject6017;
         this.delegate.updateArray(arg0, arg1 instanceof _Proxy_ ? (Array)((_Proxy_)arg1)._getDelegate_() : arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject6017, var4);
      }
   }

   public REF getREF(String arg0) throws SQLException {
      try {
         super.preForAll(methodObject5864, this, arg0);
         return (REF)this.postForAll(methodObject5864, (Object)this.delegate.getREF(arg0));
      } catch (SQLException var3) {
         return (REF)this.postForAll(methodObject5864, this.onErrorForAll(methodObject5864, var3));
      }
   }

   public void updateSQLXML(int arg0, SQLXML arg1) throws SQLException {
      try {
         super.preForAll(methodObject6090, this, arg0, arg1);
         Method var10001 = methodObject6090;
         this.delegate.updateSQLXML(arg0, arg1 instanceof _Proxy_ ? (SQLXML)((_Proxy_)arg1)._getDelegate_() : arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject6090, var4);
      }
   }

   public Blob getBlob(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject6097, this, arg0);
         return (Blob)this.postForAll(methodObject6097, this.proxyFactory.proxyForCache((Object)this.delegate.getBlob(arg0), this, this.proxyCache, methodObject6097));
      } catch (SQLException var3) {
         return (Blob)this.postForAll(methodObject6097, this.onErrorForAll(methodObject6097, var3));
      }
   }

   public void updateObject(int arg0, Object arg1, int arg2) throws SQLException {
      try {
         super.preForAll(methodObject6081, this, arg0, arg1, arg2);
         Method var10001 = methodObject6081;
         this.delegate.updateObject(arg0, arg1 instanceof _Proxy_ ? (Object)((_Proxy_)arg1)._getDelegate_() : arg1, arg2);
         this.postForAll(var10001);
      } catch (SQLException var5) {
         this.onErrorVoidForAll(methodObject6081, var5);
      }
   }

   public void updateAsciiStream(int arg0, InputStream arg1) throws SQLException {
      try {
         super.preForUpdateStreams(methodObject6023, this, arg0, arg1);
         Method var10001 = methodObject6023;
         this.delegate.updateAsciiStream(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject6023, var4);
      }
   }

   public void updateClob(String arg0, Reader arg1) throws SQLException {
      try {
         super.preForAll(methodObject6056, this, arg0, arg1);
         Method var10001 = methodObject6056;
         this.delegate.updateClob(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject6056, var4);
      }
   }

   public Object getObject(String arg0) throws SQLException {
      try {
         super.preForAll(methodObject5922, this, arg0);
         return this.postForAll(methodObject5922, this.proxyFactory.proxyForCache(this.delegate.getObject(arg0), this, this.proxyCache, methodObject5922));
      } catch (SQLException var3) {
         return this.postForAll(methodObject5922, this.onErrorForAll(methodObject5922, var3));
      }
   }

   public void closeStatementOnClose() throws SQLException {
      try {
         super.preForAll(methodObject5832, this, zeroLengthObjectArray);
         Method var10001 = methodObject5832;
         this.delegate.closeStatementOnClose();
         this.postForAll(var10001);
      } catch (SQLException var2) {
         this.onErrorVoidForAll(methodObject5832, var2);
      }
   }

   public void updateTimestamp(int arg0, Timestamp arg1) throws SQLException {
      try {
         super.preForAll(methodObject6107, this, arg0, arg1);
         Method var10001 = methodObject6107;
         this.delegate.updateTimestamp(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject6107, var4);
      }
   }

   public ORAData getORAData(String arg0, ORADataFactory arg1) throws SQLException {
      try {
         super.preForAll(methodObject5854, this, arg0, arg1);
         return (ORAData)this.postForAll(methodObject5854, this.proxyFactory.proxyForCache((Object)this.delegate.getORAData(arg0, arg1), this, this.proxyCache, methodObject5854));
      } catch (SQLException var4) {
         return (ORAData)this.postForAll(methodObject5854, this.onErrorForAll(methodObject5854, var4));
      }
   }

   public RowId getRowId(String arg0) throws SQLException {
      try {
         super.preForAll(methodObject5988, this, arg0);
         return (RowId)this.postForAll(methodObject5988, this.proxyFactory.proxyForCache((Object)this.delegate.getRowId(arg0), this, this.proxyCache, methodObject5988));
      } catch (SQLException var3) {
         return (RowId)this.postForAll(methodObject5988, this.onErrorForAll(methodObject5988, var3));
      }
   }

   public void updateTIMESTAMP(String arg0, TIMESTAMP arg1) throws SQLException {
      try {
         super.preForAll(methodObject5912, this, arg0, arg1);
         Method var10001 = methodObject5912;
         this.delegate.updateTIMESTAMP(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject5912, var4);
      }
   }

   public void updateCharacterStream(String arg0, Reader arg1, long arg2) throws SQLException {
      try {
         super.preForUpdateStreams(methodObject6048, this, arg0, arg1, arg2);
         Method var10001 = methodObject6048;
         this.delegate.updateCharacterStream(arg0, arg1, arg2);
         this.postForAll(var10001);
      } catch (SQLException var6) {
         this.onErrorVoidForAll(methodObject6048, var6);
      }
   }

   public Object getObject(String arg0, Map arg1) throws SQLException {
      try {
         super.preForAll(methodObject5924, this, arg0, arg1);
         return this.postForAll(methodObject5924, this.proxyFactory.proxyForCache(this.delegate.getObject(arg0, arg1), this, this.proxyCache, methodObject5924));
      } catch (SQLException var4) {
         return this.postForAll(methodObject5924, this.onErrorForAll(methodObject5924, var4));
      }
   }

   public InputStream getUnicodeStream(String arg0) throws SQLException {
      try {
         super.preForAll(methodObject6001, this, arg0);
         return (InputStream)this.postForAll(methodObject6001, (Object)this.delegate.getUnicodeStream(arg0));
      } catch (SQLException var3) {
         return (InputStream)this.postForAll(methodObject6001, this.onErrorForAll(methodObject6001, var3));
      }
   }

   public void updateNUMBER(String arg0, NUMBER arg1) throws SQLException {
      try {
         super.preForAll(methodObject5918, this, arg0, arg1);
         Method var10001 = methodObject5918;
         this.delegate.updateNUMBER(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject5918, var4);
      }
   }

   public Array getArray(String arg0) throws SQLException {
      try {
         super.preForAll(methodObject5944, this, arg0);
         return (Array)this.postForAll(methodObject5944, this.proxyFactory.proxyForCache((Object)this.delegate.getArray(arg0), this, this.proxyCache, methodObject5944));
      } catch (SQLException var3) {
         return (Array)this.postForAll(methodObject5944, this.onErrorForAll(methodObject5944, var3));
      }
   }

   public OPAQUE getOPAQUE(String arg0) throws SQLException {
      try {
         super.preForAll(methodObject5860, this, arg0);
         return (OPAQUE)this.postForAll(methodObject5860, (Object)this.delegate.getOPAQUE(arg0));
      } catch (SQLException var3) {
         return (OPAQUE)this.postForAll(methodObject5860, this.onErrorForAll(methodObject5860, var3));
      }
   }

   public Ref getRef(String arg0) throws SQLException {
      try {
         super.preForAll(methodObject5952, this, arg0);
         return (Ref)this.postForAll(methodObject5952, this.proxyFactory.proxyForCache((Object)this.delegate.getRef(arg0), this, this.proxyCache, methodObject5952));
      } catch (SQLException var3) {
         return (Ref)this.postForAll(methodObject5952, this.onErrorForAll(methodObject5952, var3));
      }
   }

   public Object getObject(int arg0, Class arg1) throws SQLException {
      try {
         super.preForAll(methodObject5925, this, arg0, arg1);
         return this.postForAll(methodObject5925, this.proxyFactory.proxyForCache(this.delegate.getObject(arg0, arg1), this, this.proxyCache, methodObject5925));
      } catch (SQLException var4) {
         return this.postForAll(methodObject5925, this.onErrorForAll(methodObject5925, var4));
      }
   }

   public Object getObject(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject5921, this, arg0);
         return this.postForAll(methodObject5921, this.proxyFactory.proxyForCache(this.delegate.getObject(arg0), this, this.proxyCache, methodObject5921));
      } catch (SQLException var3) {
         return this.postForAll(methodObject5921, this.onErrorForAll(methodObject5921, var3));
      }
   }

   public ROWID getROWID(String arg0) throws SQLException {
      try {
         super.preForAll(methodObject5866, this, arg0);
         return (ROWID)this.postForAll(methodObject5866, (Object)this.delegate.getROWID(arg0));
      } catch (SQLException var3) {
         return (ROWID)this.postForAll(methodObject5866, this.onErrorForAll(methodObject5866, var3));
      }
   }

   public void updateInt(String arg0, int arg1) throws SQLException {
      try {
         super.preForAll(methodObject6064, this, arg0, arg1);
         Method var10001 = methodObject6064;
         this.delegate.updateInt(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject6064, var4);
      }
   }

   public Blob getBlob(String arg0) throws SQLException {
      try {
         super.preForAll(methodObject6098, this, arg0);
         return (Blob)this.postForAll(methodObject6098, this.proxyFactory.proxyForCache((Object)this.delegate.getBlob(arg0), this, this.proxyCache, methodObject6098));
      } catch (SQLException var3) {
         return (Blob)this.postForAll(methodObject6098, this.onErrorForAll(methodObject6098, var3));
      }
   }

   public CHAR getCHAR(String arg0) throws SQLException {
      try {
         super.preForAll(methodObject5848, this, arg0);
         return (CHAR)this.postForAll(methodObject5848, (Object)this.delegate.getCHAR(arg0));
      } catch (SQLException var3) {
         return (CHAR)this.postForAll(methodObject5848, this.onErrorForAll(methodObject5848, var3));
      }
   }

   public void updateAsciiStream(int arg0, InputStream arg1, long arg2) throws SQLException {
      try {
         super.preForUpdateStreams(methodObject6021, this, arg0, arg1, arg2);
         Method var10001 = methodObject6021;
         this.delegate.updateAsciiStream(arg0, arg1, arg2);
         this.postForAll(var10001);
      } catch (SQLException var6) {
         this.onErrorVoidForAll(methodObject6021, var6);
      }
   }

   public TIMESTAMPLTZ getTIMESTAMPLTZ(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject5877, this, arg0);
         return (TIMESTAMPLTZ)this.postForAll(methodObject5877, (Object)this.delegate.getTIMESTAMPLTZ(arg0));
      } catch (SQLException var3) {
         return (TIMESTAMPLTZ)this.postForAll(methodObject5877, this.onErrorForAll(methodObject5877, var3));
      }
   }

   public Timestamp getTimestamp(int arg0, Calendar arg1) throws SQLException {
      try {
         super.preForAll(methodObject5998, this, arg0, arg1);
         return (Timestamp)this.postForAll(methodObject5998, (Object)this.delegate.getTimestamp(arg0, arg1));
      } catch (SQLException var4) {
         return (Timestamp)this.postForAll(methodObject5998, this.onErrorForAll(methodObject5998, var4));
      }
   }

   public boolean rowDeleted() throws SQLException {
      try {
         super.preForAll(methodObject6012, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject6012, this.delegate.rowDeleted());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject6012, this.onErrorForAll(methodObject6012, var2));
      }
   }

   public void updateRowId(int arg0, RowId arg1) throws SQLException {
      try {
         super.preForAll(methodObject6088, this, arg0, arg1);
         Method var10001 = methodObject6088;
         this.delegate.updateRowId(arg0, arg1 instanceof _Proxy_ ? (RowId)((_Proxy_)arg1)._getDelegate_() : arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject6088, var4);
      }
   }

   public void afterLast() throws SQLException {
      try {
         super.preForAll(methodObject5960, this, zeroLengthObjectArray);
         Method var10001 = methodObject5960;
         this.delegate.afterLast();
         this.postForAll(var10001);
      } catch (SQLException var2) {
         this.onErrorVoidForAll(methodObject5960, var2);
      }
   }

   public BigDecimal getBigDecimal(String arg0, int arg1) throws SQLException {
      try {
         super.preForAll(methodObject5969, this, arg0, arg1);
         return (BigDecimal)this.postForAll(methodObject5969, (Object)this.delegate.getBigDecimal(arg0, arg1));
      } catch (SQLException var4) {
         return (BigDecimal)this.postForAll(methodObject5969, this.onErrorForAll(methodObject5969, var4));
      }
   }

   public void updateBlob(String arg0, Blob arg1) throws SQLException {
      try {
         super.preForAll(methodObject6034, this, arg0, arg1);
         Method var10001 = methodObject6034;
         this.delegate.updateBlob(arg0, arg1 instanceof _Proxy_ ? (Blob)((_Proxy_)arg1)._getDelegate_() : arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject6034, var4);
      }
   }

   public void updateSTRUCT(String arg0, STRUCT arg1) throws SQLException {
      try {
         super.preForAll(methodObject5886, this, arg0, arg1);
         Method var10001 = methodObject5886;
         this.delegate.updateSTRUCT(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject5886, var4);
      }
   }

   public void updateCharacterStream(String arg0, Reader arg1, int arg2) throws SQLException {
      try {
         super.preForUpdateStreams(methodObject6046, this, arg0, arg1, arg2);
         Method var10001 = methodObject6046;
         this.delegate.updateCharacterStream(arg0, arg1, arg2);
         this.postForAll(var10001);
      } catch (SQLException var5) {
         this.onErrorVoidForAll(methodObject6046, var5);
      }
   }

   public void updateBoolean(int arg0, boolean arg1) throws SQLException {
      try {
         super.preForAll(methodObject6039, this, arg0, arg1);
         Method var10001 = methodObject6039;
         this.delegate.updateBoolean(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject6039, var4);
      }
   }

   public BigDecimal getBigDecimal(String arg0) throws SQLException {
      try {
         super.preForAll(methodObject5971, this, arg0);
         return (BigDecimal)this.postForAll(methodObject5971, (Object)this.delegate.getBigDecimal(arg0));
      } catch (SQLException var3) {
         return (BigDecimal)this.postForAll(methodObject5971, this.onErrorForAll(methodObject5971, var3));
      }
   }

   public void updateBlob(int arg0, InputStream arg1, long arg2) throws SQLException {
      try {
         super.preForAll(methodObject6035, this, arg0, arg1, arg2);
         Method var10001 = methodObject6035;
         this.delegate.updateBlob(arg0, arg1, arg2);
         this.postForAll(var10001);
      } catch (SQLException var6) {
         this.onErrorVoidForAll(methodObject6035, var6);
      }
   }

   public Statement getStatement() throws SQLException {
      try {
         super.preForAll(methodObject5991, this, zeroLengthObjectArray);
         return (Statement)this.postForAll(methodObject5991, this.proxyFactory.proxyForCache((Object)this.delegate.getStatement(), this, this.proxyCache, methodObject5991));
      } catch (SQLException var2) {
         return (Statement)this.postForAll(methodObject5991, this.onErrorForAll(methodObject5991, var2));
      }
   }

   public SQLWarning getWarnings() throws SQLException {
      try {
         super.preForAll(methodObject6095, this, zeroLengthObjectArray);
         return (SQLWarning)this.postForAll(methodObject6095, (Object)this.delegate.getWarnings());
      } catch (SQLException var2) {
         return (SQLWarning)this.postForAll(methodObject6095, this.onErrorForAll(methodObject6095, var2));
      }
   }

   public STRUCT getSTRUCT(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject5867, this, arg0);
         return (STRUCT)this.postForAll(methodObject5867, (Object)this.delegate.getSTRUCT(arg0));
      } catch (SQLException var3) {
         return (STRUCT)this.postForAll(methodObject5867, this.onErrorForAll(methodObject5867, var3));
      }
   }

   public void updateBFILE(int arg0, BFILE arg1) throws SQLException {
      try {
         super.preForAll(methodObject5893, this, arg0, arg1);
         Method var10001 = methodObject5893;
         this.delegate.updateBFILE(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject5893, var4);
      }
   }

   public void updateBigDecimal(int arg0, BigDecimal arg1) throws SQLException {
      try {
         super.preForAll(methodObject6025, this, arg0, arg1);
         Method var10001 = methodObject6025;
         this.delegate.updateBigDecimal(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject6025, var4);
      }
   }

   public void updateDate(int arg0, Date arg1) throws SQLException {
      try {
         super.preForAll(methodObject6057, this, arg0, arg1);
         Method var10001 = methodObject6057;
         this.delegate.updateDate(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject6057, var4);
      }
   }

   public BLOB getBLOB(String arg0) throws SQLException {
      try {
         super.preForAll(methodObject5846, this, arg0);
         return (BLOB)this.postForAll(methodObject5846, (Object)this.delegate.getBLOB(arg0));
      } catch (SQLException var3) {
         return (BLOB)this.postForAll(methodObject5846, this.onErrorForAll(methodObject5846, var3));
      }
   }

   public Date getDate(int arg0, Calendar arg1) throws SQLException {
      try {
         super.preForAll(methodObject5957, this, arg0, arg1);
         return (Date)this.postForAll(methodObject5957, (Object)this.delegate.getDate(arg0, arg1));
      } catch (SQLException var4) {
         return (Date)this.postForAll(methodObject5957, this.onErrorForAll(methodObject5957, var4));
      }
   }

   public void updateTimestamp(String arg0, Timestamp arg1) throws SQLException {
      try {
         super.preForAll(methodObject6108, this, arg0, arg1);
         Method var10001 = methodObject6108;
         this.delegate.updateTimestamp(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject6108, var4);
      }
   }

   public CustomDatum getCustomDatum(String arg0, CustomDatumFactory arg1) throws SQLException {
      try {
         super.preForAll(methodObject5852, this, arg0, arg1);
         return (CustomDatum)this.postForAll(methodObject5852, (Object)this.delegate.getCustomDatum(arg0, arg1));
      } catch (SQLException var4) {
         return (CustomDatum)this.postForAll(methodObject5852, this.onErrorForAll(methodObject5852, var4));
      }
   }

   public String getCursorName() throws SQLException {
      try {
         super.preForAll(methodObject5977, this, zeroLengthObjectArray);
         return (String)this.postForAll(methodObject5977, (Object)this.delegate.getCursorName());
      } catch (SQLException var2) {
         return (String)this.postForAll(methodObject5977, this.onErrorForAll(methodObject5977, var2));
      }
   }

   public ARRAY getARRAY(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject5839, this, arg0);
         return (ARRAY)this.postForAll(methodObject5839, (Object)this.delegate.getARRAY(arg0));
      } catch (SQLException var3) {
         return (ARRAY)this.postForAll(methodObject5839, this.onErrorForAll(methodObject5839, var3));
      }
   }

   public void updateBlob(int arg0, InputStream arg1) throws SQLException {
      try {
         super.preForAll(methodObject6037, this, arg0, arg1);
         Method var10001 = methodObject6037;
         this.delegate.updateBlob(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject6037, var4);
      }
   }

   public void close() throws SQLException {
      try {
         super.preForAll(methodObject5948, this, zeroLengthObjectArray);
         Method var10001 = methodObject5948;
         this.delegate.close();
         this.postForAll(var10001);
      } catch (SQLException var2) {
         this.onErrorVoidForAll(methodObject5948, var2);
      }
   }

   public void updateCharacterStream(int arg0, Reader arg1, int arg2) throws SQLException {
      try {
         super.preForUpdateStreams(methodObject6045, this, arg0, arg1, arg2);
         Method var10001 = methodObject6045;
         this.delegate.updateCharacterStream(arg0, arg1, arg2);
         this.postForAll(var10001);
      } catch (SQLException var5) {
         this.onErrorVoidForAll(methodObject6045, var5);
      }
   }

   public int getInt(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject5933, this, arg0);
         return (Integer)this.postForAll(methodObject5933, this.delegate.getInt(arg0));
      } catch (SQLException var3) {
         return (Integer)this.postForAll(methodObject5933, this.onErrorForAll(methodObject5933, var3));
      }
   }

   public void updateBinaryStream(String arg0, InputStream arg1, long arg2) throws SQLException {
      try {
         super.preForUpdateStreams(methodObject6030, this, arg0, arg1, arg2);
         Method var10001 = methodObject6030;
         this.delegate.updateBinaryStream(arg0, arg1, arg2);
         this.postForAll(var10001);
      } catch (SQLException var6) {
         this.onErrorVoidForAll(methodObject6030, var6);
      }
   }

   public REF getREF(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject5863, this, arg0);
         return (REF)this.postForAll(methodObject5863, (Object)this.delegate.getREF(arg0));
      } catch (SQLException var3) {
         return (REF)this.postForAll(methodObject5863, this.onErrorForAll(methodObject5863, var3));
      }
   }

   public TIMESTAMPLTZ getTIMESTAMPLTZ(String arg0) throws SQLException {
      try {
         super.preForAll(methodObject5878, this, arg0);
         return (TIMESTAMPLTZ)this.postForAll(methodObject5878, (Object)this.delegate.getTIMESTAMPLTZ(arg0));
      } catch (SQLException var3) {
         return (TIMESTAMPLTZ)this.postForAll(methodObject5878, this.onErrorForAll(methodObject5878, var3));
      }
   }

   public ResultSet getCursor(String arg0) throws SQLException {
      try {
         super.preForAll(methodObject5838, this, arg0);
         return (ResultSet)this.postForAll(methodObject5838, this.proxyFactory.proxyForCache((Object)this.delegate.getCursor(arg0), this, this.proxyCache, methodObject5838));
      } catch (SQLException var3) {
         return (ResultSet)this.postForAll(methodObject5838, this.onErrorForAll(methodObject5838, var3));
      }
   }

   public INTERVALYM getINTERVALYM(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject5869, this, arg0);
         return (INTERVALYM)this.postForAll(methodObject5869, (Object)this.delegate.getINTERVALYM(arg0));
      } catch (SQLException var3) {
         return (INTERVALYM)this.postForAll(methodObject5869, this.onErrorForAll(methodObject5869, var3));
      }
   }

   public void updateClob(String arg0, Clob arg1) throws SQLException {
      try {
         super.preForAll(methodObject6052, this, arg0, arg1);
         Method var10001 = methodObject6052;
         this.delegate.updateClob(arg0, arg1 instanceof _Proxy_ ? (Clob)((_Proxy_)arg1)._getDelegate_() : arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject6052, var4);
      }
   }

   public void updateINTERVALYM(int arg0, INTERVALYM arg1) throws SQLException {
      try {
         super.preForAll(methodObject5907, this, arg0, arg1);
         Method var10001 = methodObject5907;
         this.delegate.updateINTERVALYM(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject5907, var4);
      }
   }

   public ResultSet getCursor(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject5837, this, arg0);
         return (ResultSet)this.postForAll(methodObject5837, this.proxyFactory.proxyForCache((Object)this.delegate.getCursor(arg0), this, this.proxyCache, methodObject5837));
      } catch (SQLException var3) {
         return (ResultSet)this.postForAll(methodObject5837, this.onErrorForAll(methodObject5837, var3));
      }
   }

   public void updateCustomDatum(int arg0, CustomDatum arg1) throws SQLException {
      try {
         super.preForAll(methodObject5901, this, arg0, arg1);
         Method var10001 = methodObject5901;
         this.delegate.updateCustomDatum(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject5901, var4);
      }
   }

   public InputStream getUnicodeStream(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject6000, this, arg0);
         return (InputStream)this.postForAll(methodObject6000, (Object)this.delegate.getUnicodeStream(arg0));
      } catch (SQLException var3) {
         return (InputStream)this.postForAll(methodObject6000, this.onErrorForAll(methodObject6000, var3));
      }
   }

   public void updateLong(int arg0, long arg1) throws SQLException {
      try {
         super.preForAll(methodObject6065, this, arg0, arg1);
         Method var10001 = methodObject6065;
         this.delegate.updateLong(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var5) {
         this.onErrorVoidForAll(methodObject6065, var5);
      }
   }

   public TIMESTAMPTZ getTIMESTAMPTZ(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject5875, this, arg0);
         return (TIMESTAMPTZ)this.postForAll(methodObject5875, (Object)this.delegate.getTIMESTAMPTZ(arg0));
      } catch (SQLException var3) {
         return (TIMESTAMPTZ)this.postForAll(methodObject5875, this.onErrorForAll(methodObject5875, var3));
      }
   }

   public void updateBlob(int arg0, Blob arg1) throws SQLException {
      try {
         super.preForAll(methodObject6033, this, arg0, arg1);
         Method var10001 = methodObject6033;
         this.delegate.updateBlob(arg0, arg1 instanceof _Proxy_ ? (Blob)((_Proxy_)arg1)._getDelegate_() : arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject6033, var4);
      }
   }

   public NClob getNClob(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject5982, this, arg0);
         return (NClob)this.postForAll(methodObject5982, this.proxyFactory.proxyForCache((Object)this.delegate.getNClob(arg0), this, this.proxyCache, methodObject5982));
      } catch (SQLException var3) {
         return (NClob)this.postForAll(methodObject5982, this.onErrorForAll(methodObject5982, var3));
      }
   }

   public void updateAsciiStream(int arg0, InputStream arg1, int arg2) throws SQLException {
      try {
         super.preForUpdateStreams(methodObject6019, this, arg0, arg1, arg2);
         Method var10001 = methodObject6019;
         this.delegate.updateAsciiStream(arg0, arg1, arg2);
         this.postForAll(var10001);
      } catch (SQLException var5) {
         this.onErrorVoidForAll(methodObject6019, var5);
      }
   }

   public int getRow() throws SQLException {
      try {
         super.preForAll(methodObject5986, this, zeroLengthObjectArray);
         return (Integer)this.postForAll(methodObject5986, this.delegate.getRow());
      } catch (SQLException var2) {
         return (Integer)this.postForAll(methodObject5986, this.onErrorForAll(methodObject5986, var2));
      }
   }

   public void updateBytes(String arg0, byte[] arg1) throws SQLException {
      try {
         super.preForAll(methodObject6044, this, arg0, arg1);
         Method var10001 = methodObject6044;
         this.delegate.updateBytes(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject6044, var4);
      }
   }

   public void updateBinaryStream(int arg0, InputStream arg1, int arg2) throws SQLException {
      try {
         super.preForUpdateStreams(methodObject6027, this, arg0, arg1, arg2);
         Method var10001 = methodObject6027;
         this.delegate.updateBinaryStream(arg0, arg1, arg2);
         this.postForAll(var10001);
      } catch (SQLException var5) {
         this.onErrorVoidForAll(methodObject6027, var5);
      }
   }

   public boolean getBoolean(String arg0) throws SQLException {
      try {
         super.preForAll(methodObject5928, this, arg0);
         return (Boolean)this.postForAll(methodObject5928, this.delegate.getBoolean(arg0));
      } catch (SQLException var3) {
         return (Boolean)this.postForAll(methodObject5928, this.onErrorForAll(methodObject5928, var3));
      }
   }

   public void insertRow() throws SQLException {
      try {
         super.preForAll(methodObject6002, this, zeroLengthObjectArray);
         Method var10001 = methodObject6002;
         this.delegate.insertRow();
         this.postForAll(var10001);
      } catch (SQLException var2) {
         this.onErrorVoidForAll(methodObject6002, var2);
      }
   }

   public int getFetchSize() throws SQLException {
      try {
         super.preForAll(methodObject5979, this, zeroLengthObjectArray);
         return (Integer)this.postForAll(methodObject5979, this.delegate.getFetchSize());
      } catch (SQLException var2) {
         return (Integer)this.postForAll(methodObject5979, this.onErrorForAll(methodObject5979, var2));
      }
   }

   public BigDecimal getBigDecimal(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject5970, this, arg0);
         return (BigDecimal)this.postForAll(methodObject5970, (Object)this.delegate.getBigDecimal(arg0));
      } catch (SQLException var3) {
         return (BigDecimal)this.postForAll(methodObject5970, this.onErrorForAll(methodObject5970, var3));
      }
   }

   public void updateNClob(int arg0, Reader arg1, long arg2) throws SQLException {
      try {
         super.preForAll(methodObject6073, this, arg0, arg1, arg2);
         Method var10001 = methodObject6073;
         this.delegate.updateNClob(arg0, arg1, arg2);
         this.postForAll(var10001);
      } catch (SQLException var6) {
         this.onErrorVoidForAll(methodObject6073, var6);
      }
   }

   public void updateROWID(String arg0, ROWID arg1) throws SQLException {
      try {
         super.preForAll(methodObject5884, this, arg0, arg1);
         Method var10001 = methodObject5884;
         this.delegate.updateROWID(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject5884, var4);
      }
   }

   public void updateDate(String arg0, Date arg1) throws SQLException {
      try {
         super.preForAll(methodObject6058, this, arg0, arg1);
         Method var10001 = methodObject6058;
         this.delegate.updateDate(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject6058, var4);
      }
   }

   public void updateBfile(int arg0, BFILE arg1) throws SQLException {
      try {
         super.preForAll(methodObject5891, this, arg0, arg1);
         Method var10001 = methodObject5891;
         this.delegate.updateBfile(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject5891, var4);
      }
   }

   public String getString(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject5953, this, arg0);
         return (String)this.postForAll(methodObject5953, (Object)this.delegate.getString(arg0));
      } catch (SQLException var3) {
         return (String)this.postForAll(methodObject5953, this.onErrorForAll(methodObject5953, var3));
      }
   }

   public void updateTime(String arg0, Time arg1) throws SQLException {
      try {
         super.preForAll(methodObject6106, this, arg0, arg1);
         Method var10001 = methodObject6106;
         this.delegate.updateTime(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject6106, var4);
      }
   }

   public void moveToCurrentRow() throws SQLException {
      try {
         super.preForAll(methodObject6008, this, zeroLengthObjectArray);
         Method var10001 = methodObject6008;
         this.delegate.moveToCurrentRow();
         this.postForAll(var10001);
      } catch (SQLException var2) {
         this.onErrorVoidForAll(methodObject6008, var2);
      }
   }

   public void updateBlob(String arg0, InputStream arg1, long arg2) throws SQLException {
      try {
         super.preForAll(methodObject6036, this, arg0, arg1, arg2);
         Method var10001 = methodObject6036;
         this.delegate.updateBlob(arg0, arg1, arg2);
         this.postForAll(var10001);
      } catch (SQLException var6) {
         this.onErrorVoidForAll(methodObject6036, var6);
      }
   }

   public Timestamp getTimestamp(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject5996, this, arg0);
         return (Timestamp)this.postForAll(methodObject5996, (Object)this.delegate.getTimestamp(arg0));
      } catch (SQLException var3) {
         return (Timestamp)this.postForAll(methodObject5996, this.onErrorForAll(methodObject5996, var3));
      }
   }

   public void updateBlob(String arg0, InputStream arg1) throws SQLException {
      try {
         super.preForAll(methodObject6038, this, arg0, arg1);
         Method var10001 = methodObject6038;
         this.delegate.updateBlob(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject6038, var4);
      }
   }

   public int findColumn(String arg0) throws SQLException {
      try {
         super.preForAll(methodObject5964, this, arg0);
         return (Integer)this.postForAll(methodObject5964, this.delegate.findColumn(arg0));
      } catch (SQLException var3) {
         return (Integer)this.postForAll(methodObject5964, this.onErrorForAll(methodObject5964, var3));
      }
   }

   public void updateINTERVALYM(String arg0, INTERVALYM arg1) throws SQLException {
      try {
         super.preForAll(methodObject5908, this, arg0, arg1);
         Method var10001 = methodObject5908;
         this.delegate.updateINTERVALYM(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject5908, var4);
      }
   }

   public void updateREF(int arg0, REF arg1) throws SQLException {
      try {
         super.preForAll(methodObject5881, this, arg0, arg1);
         Method var10001 = methodObject5881;
         this.delegate.updateREF(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject5881, var4);
      }
   }

   public Object getACProxy() {
      super.preForAll(methodObject6113, this, zeroLengthObjectArray);
      return this.postForAll(methodObject6113, this.proxyFactory.proxyForCache(this.delegate.getACProxy(), this, this.proxyCache, methodObject6113));
   }

   public void updateBinaryStream(String arg0, InputStream arg1, int arg2) throws SQLException {
      try {
         super.preForUpdateStreams(methodObject6028, this, arg0, arg1, arg2);
         Method var10001 = methodObject6028;
         this.delegate.updateBinaryStream(arg0, arg1, arg2);
         this.postForAll(var10001);
      } catch (SQLException var5) {
         this.onErrorVoidForAll(methodObject6028, var5);
      }
   }

   public SQLXML getSQLXML(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject5989, this, arg0);
         return (SQLXML)this.postForAll(methodObject5989, this.proxyFactory.proxyForCache((Object)this.delegate.getSQLXML(arg0), this, this.proxyCache, methodObject5989));
      } catch (SQLException var3) {
         return (SQLXML)this.postForAll(methodObject5989, this.onErrorForAll(methodObject5989, var3));
      }
   }

   public INTERVALYM getINTERVALYM(String arg0) throws SQLException {
      try {
         super.preForAll(methodObject5870, this, arg0);
         return (INTERVALYM)this.postForAll(methodObject5870, (Object)this.delegate.getINTERVALYM(arg0));
      } catch (SQLException var3) {
         return (INTERVALYM)this.postForAll(methodObject5870, this.onErrorForAll(methodObject5870, var3));
      }
   }

   public BFILE getBfile(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject5843, this, arg0);
         return (BFILE)this.postForAll(methodObject5843, (Object)this.delegate.getBfile(arg0));
      } catch (SQLException var3) {
         return (BFILE)this.postForAll(methodObject5843, this.onErrorForAll(methodObject5843, var3));
      }
   }

   public CLOB getCLOB(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject5849, this, arg0);
         return (CLOB)this.postForAll(methodObject5849, (Object)this.delegate.getCLOB(arg0));
      } catch (SQLException var3) {
         return (CLOB)this.postForAll(methodObject5849, this.onErrorForAll(methodObject5849, var3));
      }
   }

   public boolean isBeforeFirst() throws SQLException {
      try {
         super.preForAll(methodObject6004, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject6004, this.delegate.isBeforeFirst());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject6004, this.onErrorForAll(methodObject6004, var2));
      }
   }

   public int getConcurrency() throws SQLException {
      try {
         super.preForAll(methodObject5976, this, zeroLengthObjectArray);
         return (Integer)this.postForAll(methodObject5976, this.delegate.getConcurrency());
      } catch (SQLException var2) {
         return (Integer)this.postForAll(methodObject5976, this.onErrorForAll(methodObject5976, var2));
      }
   }

   public void updateNString(String arg0, String arg1) throws SQLException {
      try {
         super.preForAll(methodObject6078, this, arg0, arg1);
         Method var10001 = methodObject6078;
         this.delegate.updateNString(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject6078, var4);
      }
   }

   public RAW getRAW(String arg0) throws SQLException {
      try {
         super.preForAll(methodObject5862, this, arg0);
         return (RAW)this.postForAll(methodObject5862, (Object)this.delegate.getRAW(arg0));
      } catch (SQLException var3) {
         return (RAW)this.postForAll(methodObject5862, this.onErrorForAll(methodObject5862, var3));
      }
   }

   public void updateRAW(String arg0, RAW arg1) throws SQLException {
      try {
         super.preForAll(methodObject5920, this, arg0, arg1);
         Method var10001 = methodObject5920;
         this.delegate.updateRAW(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject5920, var4);
      }
   }

   public byte[] getBytes(String arg0) throws SQLException {
      try {
         super.preForAll(methodObject5942, this, arg0);
         return (byte[])this.postForAll(methodObject5942, (Object)this.delegate.getBytes(arg0));
      } catch (SQLException var3) {
         return (byte[])this.postForAll(methodObject5942, this.onErrorForAll(methodObject5942, var3));
      }
   }

   public void updateNClob(int arg0, Reader arg1) throws SQLException {
      try {
         super.preForAll(methodObject6075, this, arg0, arg1);
         Method var10001 = methodObject6075;
         this.delegate.updateNClob(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject6075, var4);
      }
   }

   public void updateString(int arg0, String arg1) throws SQLException {
      try {
         super.preForAll(methodObject6103, this, arg0, arg1);
         Method var10001 = methodObject6103;
         this.delegate.updateString(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject6103, var4);
      }
   }

   public Timestamp getTimestamp(String arg0) throws SQLException {
      try {
         super.preForAll(methodObject5997, this, arg0);
         return (Timestamp)this.postForAll(methodObject5997, (Object)this.delegate.getTimestamp(arg0));
      } catch (SQLException var3) {
         return (Timestamp)this.postForAll(methodObject5997, this.onErrorForAll(methodObject5997, var3));
      }
   }

   public CustomDatum getCustomDatum(int arg0, CustomDatumFactory arg1) throws SQLException {
      try {
         super.preForAll(methodObject5851, this, arg0, arg1);
         return (CustomDatum)this.postForAll(methodObject5851, (Object)this.delegate.getCustomDatum(arg0, arg1));
      } catch (SQLException var4) {
         return (CustomDatum)this.postForAll(methodObject5851, this.onErrorForAll(methodObject5851, var4));
      }
   }

   public double getDouble(String arg0) throws SQLException {
      try {
         super.preForAll(methodObject5940, this, arg0);
         return (Double)this.postForAll(methodObject5940, this.delegate.getDouble(arg0));
      } catch (SQLException var3) {
         return (Double)this.postForAll(methodObject5940, this.onErrorForAll(methodObject5940, var3));
      }
   }

   public URL getURL(String arg0) throws SQLException {
      try {
         super.preForAll(methodObject5947, this, arg0);
         return (URL)this.postForAll(methodObject5947, (Object)this.delegate.getURL(arg0));
      } catch (SQLException var3) {
         return (URL)this.postForAll(methodObject5947, this.onErrorForAll(methodObject5947, var3));
      }
   }

   public void updateByte(int arg0, byte arg1) throws SQLException {
      try {
         super.preForAll(methodObject6041, this, arg0, arg1);
         Method var10001 = methodObject6041;
         this.delegate.updateByte(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject6041, var4);
      }
   }

   public boolean rowInserted() throws SQLException {
      try {
         super.preForAll(methodObject6013, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject6013, this.delegate.rowInserted());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject6013, this.onErrorForAll(methodObject6013, var2));
      }
   }

   public void updateTIMESTAMPTZ(int arg0, TIMESTAMPTZ arg1) throws SQLException {
      try {
         super.preForAll(methodObject5913, this, arg0, arg1);
         Method var10001 = methodObject5913;
         this.delegate.updateTIMESTAMPTZ(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject5913, var4);
      }
   }

   public float getFloat(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject5937, this, arg0);
         return (Float)this.postForAll(methodObject5937, this.delegate.getFloat(arg0));
      } catch (SQLException var3) {
         return (Float)this.postForAll(methodObject5937, this.onErrorForAll(methodObject5937, var3));
      }
   }

   public void updateROWID(int arg0, ROWID arg1) throws SQLException {
      try {
         super.preForAll(methodObject5883, this, arg0, arg1);
         Method var10001 = methodObject5883;
         this.delegate.updateROWID(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject5883, var4);
      }
   }

   public OracleResultSet _getDelegate_() {
      return this.delegate;
   }

   public Object getDelegate() {
      return this.delegate;
   }

   public void setDelegate(Object delegate) {
      this.proxyFactory.updateDelegate(this, this.delegate, delegate);
      this.delegate = (OracleResultSet)delegate;
   }

   public Object getCreator() {
      return this.creator;
   }

   static {
      try {
         methodObject6053 = ResultSet.class.getDeclaredMethod("updateClob", Integer.TYPE, Reader.class, Long.TYPE);
         methodObject5931 = ResultSet.class.getDeclaredMethod("getShort", Integer.TYPE);
         methodObject6085 = ResultSet.class.getDeclaredMethod("updateRef", Integer.TYPE, Ref.class);
         methodObject6011 = ResultSet.class.getDeclaredMethod("relative", Integer.TYPE);
         methodObject6080 = ResultSet.class.getDeclaredMethod("updateNull", String.class);
         methodObject6032 = ResultSet.class.getDeclaredMethod("updateBinaryStream", String.class, InputStream.class);
         methodObject6006 = ResultSet.class.getDeclaredMethod("isLast");
         methodObject6031 = ResultSet.class.getDeclaredMethod("updateBinaryStream", Integer.TYPE, InputStream.class);
         methodObject5915 = oracle.jdbc.OracleResultSet.class.getDeclaredMethod("updateTIMESTAMPLTZ", Integer.TYPE, TIMESTAMPLTZ.class);
         methodObject6015 = ResultSet.class.getDeclaredMethod("setFetchDirection", Integer.TYPE);
         methodObject5905 = oracle.jdbc.OracleResultSet.class.getDeclaredMethod("updateDATE", Integer.TYPE, DATE.class);
         methodObject5841 = oracle.jdbc.OracleResultSet.class.getDeclaredMethod("getBFILE", Integer.TYPE);
         methodObject6049 = ResultSet.class.getDeclaredMethod("updateCharacterStream", Integer.TYPE, Reader.class);
         methodObject6050 = ResultSet.class.getDeclaredMethod("updateCharacterStream", String.class, Reader.class);
         methodObject6091 = ResultSet.class.getDeclaredMethod("updateSQLXML", String.class, SQLXML.class);
         methodObject6071 = ResultSet.class.getDeclaredMethod("updateNClob", Integer.TYPE, NClob.class);
         methodObject5992 = ResultSet.class.getDeclaredMethod("getTime", Integer.TYPE);
         methodObject6063 = ResultSet.class.getDeclaredMethod("updateInt", Integer.TYPE, Integer.TYPE);
         methodObject6051 = ResultSet.class.getDeclaredMethod("updateClob", Integer.TYPE, Clob.class);
         methodObject5938 = ResultSet.class.getDeclaredMethod("getFloat", String.class);
         methodObject6043 = ResultSet.class.getDeclaredMethod("updateBytes", Integer.TYPE, byte[].class);
         methodObject5872 = oracle.jdbc.OracleResultSet.class.getDeclaredMethod("getINTERVALDS", String.class);
         methodObject5973 = ResultSet.class.getDeclaredMethod("getBinaryStream", String.class);
         methodObject6100 = ResultSet.class.getDeclaredMethod("getCharacterStream", String.class);
         methodObject5896 = oracle.jdbc.OracleResultSet.class.getDeclaredMethod("updateBLOB", String.class, BLOB.class);
         methodObject6104 = ResultSet.class.getDeclaredMethod("updateString", String.class, String.class);
         methodObject6074 = ResultSet.class.getDeclaredMethod("updateNClob", String.class, Reader.class, Long.TYPE);
         methodObject5966 = ResultSet.class.getDeclaredMethod("getAsciiStream", Integer.TYPE);
         methodObject5999 = ResultSet.class.getDeclaredMethod("getTimestamp", String.class, Calendar.class);
         methodObject5898 = oracle.jdbc.OracleResultSet.class.getDeclaredMethod("updateCHAR", String.class, CHAR.class);
         methodObject6068 = ResultSet.class.getDeclaredMethod("updateNCharacterStream", String.class, Reader.class, Long.TYPE);
         methodObject6010 = ResultSet.class.getDeclaredMethod("refreshRow");
         methodObject5861 = oracle.jdbc.OracleResultSet.class.getDeclaredMethod("getRAW", Integer.TYPE);
         methodObject6101 = ResultSet.class.getDeclaredMethod("updateShort", Integer.TYPE, Short.TYPE);
         methodObject5850 = oracle.jdbc.OracleResultSet.class.getDeclaredMethod("getCLOB", String.class);
         methodObject6069 = ResultSet.class.getDeclaredMethod("updateNCharacterStream", Integer.TYPE, Reader.class);
         methodObject5981 = ResultSet.class.getDeclaredMethod("getNCharacterStream", String.class);
         methodObject5902 = oracle.jdbc.OracleResultSet.class.getDeclaredMethod("updateCustomDatum", String.class, CustomDatum.class);
         methodObject6110 = Wrapper.class.getDeclaredMethod("unwrap", Class.class);
         methodObject5888 = oracle.jdbc.OracleResultSet.class.getDeclaredMethod("getAuthorizationIndicator", String.class);
         methodObject6047 = ResultSet.class.getDeclaredMethod("updateCharacterStream", Integer.TYPE, Reader.class, Long.TYPE);
         methodObject5844 = oracle.jdbc.OracleResultSet.class.getDeclaredMethod("getBfile", String.class);
         methodObject5941 = ResultSet.class.getDeclaredMethod("getBytes", Integer.TYPE);
         methodObject6022 = ResultSet.class.getDeclaredMethod("updateAsciiStream", String.class, InputStream.class, Long.TYPE);
         methodObject6060 = ResultSet.class.getDeclaredMethod("updateDouble", String.class, Double.TYPE);
         methodObject5836 = oracle.jdbc.OracleResultSet.class.getDeclaredMethod("getOracleObject", String.class);
         methodObject5899 = oracle.jdbc.OracleResultSet.class.getDeclaredMethod("updateCLOB", Integer.TYPE, CLOB.class);
         methodObject5916 = oracle.jdbc.OracleResultSet.class.getDeclaredMethod("updateTIMESTAMPLTZ", String.class, TIMESTAMPLTZ.class);
         methodObject6079 = ResultSet.class.getDeclaredMethod("updateNull", Integer.TYPE);
         methodObject6083 = ResultSet.class.getDeclaredMethod("updateObject", String.class, Object.class, Integer.TYPE);
         methodObject5955 = ResultSet.class.getDeclaredMethod("getDate", Integer.TYPE);
         methodObject6109 = ResultSet.class.getDeclaredMethod("wasNull");
         methodObject5936 = ResultSet.class.getDeclaredMethod("getLong", String.class);
         methodObject6070 = ResultSet.class.getDeclaredMethod("updateNCharacterStream", String.class, Reader.class);
         methodObject6111 = Wrapper.class.getDeclaredMethod("isWrapperFor", Class.class);
         methodObject6087 = ResultSet.class.getDeclaredMethod("updateRow");
         methodObject5980 = ResultSet.class.getDeclaredMethod("getNCharacterStream", Integer.TYPE);
         methodObject6003 = ResultSet.class.getDeclaredMethod("isAfterLast");
         methodObject6077 = ResultSet.class.getDeclaredMethod("updateNString", Integer.TYPE, String.class);
         methodObject6072 = ResultSet.class.getDeclaredMethod("updateNClob", String.class, NClob.class);
         methodObject6112 = ACProxyable.class.getDeclaredMethod("setACProxy", Object.class);
         methodObject6102 = ResultSet.class.getDeclaredMethod("updateShort", String.class, Short.TYPE);
         methodObject5967 = ResultSet.class.getDeclaredMethod("getAsciiStream", String.class);
         methodObject6092 = ResultSet.class.getDeclaredMethod("clearWarnings");
         methodObject6024 = ResultSet.class.getDeclaredMethod("updateAsciiStream", String.class, InputStream.class);
         methodObject5927 = ResultSet.class.getDeclaredMethod("getBoolean", Integer.TYPE);
         methodObject5939 = ResultSet.class.getDeclaredMethod("getDouble", Integer.TYPE);
         methodObject6042 = ResultSet.class.getDeclaredMethod("updateByte", String.class, Byte.TYPE);
         methodObject5880 = oracle.jdbc.OracleResultSet.class.getDeclaredMethod("updateOracleObject", String.class, Datum.class);
         methodObject6094 = ResultSet.class.getDeclaredMethod("getMetaData");
         methodObject5903 = oracle.jdbc.OracleResultSet.class.getDeclaredMethod("updateORAData", Integer.TYPE, ORAData.class);
         methodObject5868 = oracle.jdbc.OracleResultSet.class.getDeclaredMethod("getSTRUCT", String.class);
         methodObject6096 = ResultSet.class.getDeclaredMethod("isClosed");
         methodObject5894 = oracle.jdbc.OracleResultSet.class.getDeclaredMethod("updateBFILE", String.class, BFILE.class);
         methodObject6020 = ResultSet.class.getDeclaredMethod("updateAsciiStream", String.class, InputStream.class, Integer.TYPE);
         methodObject5951 = ResultSet.class.getDeclaredMethod("getRef", Integer.TYPE);
         methodObject5887 = oracle.jdbc.OracleResultSet.class.getDeclaredMethod("getAuthorizationIndicator", Integer.TYPE);
         methodObject6007 = ResultSet.class.getDeclaredMethod("last");
         methodObject6014 = ResultSet.class.getDeclaredMethod("rowUpdated");
         methodObject5895 = oracle.jdbc.OracleResultSet.class.getDeclaredMethod("updateBLOB", Integer.TYPE, BLOB.class);
         methodObject5858 = oracle.jdbc.OracleResultSet.class.getDeclaredMethod("getNUMBER", String.class);
         methodObject5993 = ResultSet.class.getDeclaredMethod("getTime", String.class);
         methodObject5923 = ResultSet.class.getDeclaredMethod("getObject", Integer.TYPE, Map.class);
         methodObject5974 = ResultSet.class.getDeclaredMethod("getClob", Integer.TYPE);
         methodObject5994 = ResultSet.class.getDeclaredMethod("getTime", Integer.TYPE, Calendar.class);
         methodObject5946 = ResultSet.class.getDeclaredMethod("getURL", Integer.TYPE);
         methodObject5978 = ResultSet.class.getDeclaredMethod("getFetchDirection");
         methodObject6005 = ResultSet.class.getDeclaredMethod("isFirst");
         methodObject6062 = ResultSet.class.getDeclaredMethod("updateFloat", String.class, Float.TYPE);
         methodObject5910 = oracle.jdbc.OracleResultSet.class.getDeclaredMethod("updateINTERVALDS", String.class, INTERVALDS.class);
         methodObject5950 = ResultSet.class.getDeclaredMethod("previous");
         methodObject5890 = oracle.jdbc.OracleResultSet.class.getDeclaredMethod("updateARRAY", String.class, ARRAY.class);
         methodObject5930 = ResultSet.class.getDeclaredMethod("getByte", String.class);
         methodObject5919 = oracle.jdbc.OracleResultSet.class.getDeclaredMethod("updateRAW", Integer.TYPE, RAW.class);
         methodObject5853 = oracle.jdbc.OracleResultSet.class.getDeclaredMethod("getORAData", Integer.TYPE, ORADataFactory.class);
         methodObject5909 = oracle.jdbc.OracleResultSet.class.getDeclaredMethod("updateINTERVALDS", Integer.TYPE, INTERVALDS.class);
         methodObject5914 = oracle.jdbc.OracleResultSet.class.getDeclaredMethod("updateTIMESTAMPTZ", String.class, TIMESTAMPTZ.class);
         methodObject5984 = ResultSet.class.getDeclaredMethod("getNString", Integer.TYPE);
         methodObject5935 = ResultSet.class.getDeclaredMethod("getLong", Integer.TYPE);
         methodObject5865 = oracle.jdbc.OracleResultSet.class.getDeclaredMethod("getROWID", Integer.TYPE);
         methodObject5945 = ResultSet.class.getDeclaredMethod("next");
         methodObject5949 = ResultSet.class.getDeclaredMethod("getType");
         methodObject5983 = ResultSet.class.getDeclaredMethod("getNClob", String.class);
         methodObject5956 = ResultSet.class.getDeclaredMethod("getDate", String.class);
         methodObject5926 = ResultSet.class.getDeclaredMethod("getObject", String.class, Class.class);
         methodObject5859 = oracle.jdbc.OracleResultSet.class.getDeclaredMethod("getOPAQUE", Integer.TYPE);
         methodObject5834 = oracle.jdbc.OracleResultSet.class.getDeclaredMethod("getObject", String.class, OracleDataFactory.class);
         methodObject5876 = oracle.jdbc.OracleResultSet.class.getDeclaredMethod("getTIMESTAMPTZ", String.class);
         methodObject5975 = ResultSet.class.getDeclaredMethod("getClob", String.class);
         methodObject5934 = ResultSet.class.getDeclaredMethod("getInt", String.class);
         methodObject6018 = ResultSet.class.getDeclaredMethod("updateArray", String.class, Array.class);
         methodObject5874 = oracle.jdbc.OracleResultSet.class.getDeclaredMethod("getTIMESTAMP", String.class);
         methodObject5871 = oracle.jdbc.OracleResultSet.class.getDeclaredMethod("getINTERVALDS", Integer.TYPE);
         methodObject6076 = ResultSet.class.getDeclaredMethod("updateNClob", String.class, Reader.class);
         methodObject6026 = ResultSet.class.getDeclaredMethod("updateBigDecimal", String.class, BigDecimal.class);
         methodObject5882 = oracle.jdbc.OracleResultSet.class.getDeclaredMethod("updateREF", String.class, REF.class);
         methodObject6105 = ResultSet.class.getDeclaredMethod("updateTime", Integer.TYPE, Time.class);
         methodObject6067 = ResultSet.class.getDeclaredMethod("updateNCharacterStream", Integer.TYPE, Reader.class, Long.TYPE);
         methodObject5842 = oracle.jdbc.OracleResultSet.class.getDeclaredMethod("getBFILE", String.class);
         methodObject5917 = oracle.jdbc.OracleResultSet.class.getDeclaredMethod("updateNUMBER", Integer.TYPE, NUMBER.class);
         methodObject5995 = ResultSet.class.getDeclaredMethod("getTime", String.class, Calendar.class);
         methodObject6029 = ResultSet.class.getDeclaredMethod("updateBinaryStream", Integer.TYPE, InputStream.class, Long.TYPE);
         methodObject5885 = oracle.jdbc.OracleResultSet.class.getDeclaredMethod("updateSTRUCT", Integer.TYPE, STRUCT.class);
         methodObject5961 = ResultSet.class.getDeclaredMethod("beforeFirst");
         methodObject6066 = ResultSet.class.getDeclaredMethod("updateLong", String.class, Long.TYPE);
         methodObject6086 = ResultSet.class.getDeclaredMethod("updateRef", String.class, Ref.class);
         methodObject6061 = ResultSet.class.getDeclaredMethod("updateFloat", Integer.TYPE, Float.TYPE);
         methodObject5968 = ResultSet.class.getDeclaredMethod("getBigDecimal", Integer.TYPE, Integer.TYPE);
         methodObject5972 = ResultSet.class.getDeclaredMethod("getBinaryStream", Integer.TYPE);
         methodObject6040 = ResultSet.class.getDeclaredMethod("updateBoolean", String.class, Boolean.TYPE);
         methodObject5900 = oracle.jdbc.OracleResultSet.class.getDeclaredMethod("updateCLOB", String.class, CLOB.class);
         methodObject5833 = oracle.jdbc.OracleResultSet.class.getDeclaredMethod("getObject", Integer.TYPE, OracleDataFactory.class);
         methodObject5954 = ResultSet.class.getDeclaredMethod("getString", String.class);
         methodObject5959 = ResultSet.class.getDeclaredMethod("absolute", Integer.TYPE);
         methodObject5963 = ResultSet.class.getDeclaredMethod("deleteRow");
         methodObject5847 = oracle.jdbc.OracleResultSet.class.getDeclaredMethod("getCHAR", Integer.TYPE);
         methodObject6089 = ResultSet.class.getDeclaredMethod("updateRowId", String.class, RowId.class);
         methodObject5906 = oracle.jdbc.OracleResultSet.class.getDeclaredMethod("updateDATE", String.class, DATE.class);
         methodObject5990 = ResultSet.class.getDeclaredMethod("getSQLXML", String.class);
         methodObject6099 = ResultSet.class.getDeclaredMethod("getCharacterStream", Integer.TYPE);
         methodObject5958 = ResultSet.class.getDeclaredMethod("getDate", String.class, Calendar.class);
         methodObject5965 = ResultSet.class.getDeclaredMethod("first");
         methodObject5873 = oracle.jdbc.OracleResultSet.class.getDeclaredMethod("getTIMESTAMP", Integer.TYPE);
         methodObject5855 = oracle.jdbc.OracleResultSet.class.getDeclaredMethod("getDATE", Integer.TYPE);
         methodObject5845 = oracle.jdbc.OracleResultSet.class.getDeclaredMethod("getBLOB", Integer.TYPE);
         methodObject6055 = ResultSet.class.getDeclaredMethod("updateClob", Integer.TYPE, Reader.class);
         methodObject5929 = ResultSet.class.getDeclaredMethod("getByte", Integer.TYPE);
         methodObject6059 = ResultSet.class.getDeclaredMethod("updateDouble", Integer.TYPE, Double.TYPE);
         methodObject5943 = ResultSet.class.getDeclaredMethod("getArray", Integer.TYPE);
         methodObject6082 = ResultSet.class.getDeclaredMethod("updateObject", Integer.TYPE, Object.class);
         methodObject6016 = ResultSet.class.getDeclaredMethod("setFetchSize", Integer.TYPE);
         methodObject5932 = ResultSet.class.getDeclaredMethod("getShort", String.class);
         methodObject5897 = oracle.jdbc.OracleResultSet.class.getDeclaredMethod("updateCHAR", Integer.TYPE, CHAR.class);
         methodObject5889 = oracle.jdbc.OracleResultSet.class.getDeclaredMethod("updateARRAY", Integer.TYPE, ARRAY.class);
         methodObject5857 = oracle.jdbc.OracleResultSet.class.getDeclaredMethod("getNUMBER", Integer.TYPE);
         methodObject5987 = ResultSet.class.getDeclaredMethod("getRowId", Integer.TYPE);
         methodObject5856 = oracle.jdbc.OracleResultSet.class.getDeclaredMethod("getDATE", String.class);
         methodObject6009 = ResultSet.class.getDeclaredMethod("moveToInsertRow");
         methodObject5904 = oracle.jdbc.OracleResultSet.class.getDeclaredMethod("updateORAData", String.class, ORAData.class);
         methodObject5840 = oracle.jdbc.OracleResultSet.class.getDeclaredMethod("getARRAY", String.class);
         methodObject5892 = oracle.jdbc.OracleResultSet.class.getDeclaredMethod("updateBfile", String.class, BFILE.class);
         methodObject5879 = oracle.jdbc.OracleResultSet.class.getDeclaredMethod("updateOracleObject", Integer.TYPE, Datum.class);
         methodObject5962 = ResultSet.class.getDeclaredMethod("cancelRowUpdates");
         methodObject6093 = ResultSet.class.getDeclaredMethod("getHoldability");
         methodObject5835 = oracle.jdbc.OracleResultSet.class.getDeclaredMethod("getOracleObject", Integer.TYPE);
         methodObject6054 = ResultSet.class.getDeclaredMethod("updateClob", String.class, Reader.class, Long.TYPE);
         methodObject5911 = oracle.jdbc.OracleResultSet.class.getDeclaredMethod("updateTIMESTAMP", Integer.TYPE, TIMESTAMP.class);
         methodObject5985 = ResultSet.class.getDeclaredMethod("getNString", String.class);
         methodObject6084 = ResultSet.class.getDeclaredMethod("updateObject", String.class, Object.class);
         methodObject6017 = ResultSet.class.getDeclaredMethod("updateArray", Integer.TYPE, Array.class);
         methodObject5864 = oracle.jdbc.OracleResultSet.class.getDeclaredMethod("getREF", String.class);
         methodObject6090 = ResultSet.class.getDeclaredMethod("updateSQLXML", Integer.TYPE, SQLXML.class);
         methodObject6097 = ResultSet.class.getDeclaredMethod("getBlob", Integer.TYPE);
         methodObject6081 = ResultSet.class.getDeclaredMethod("updateObject", Integer.TYPE, Object.class, Integer.TYPE);
         methodObject6023 = ResultSet.class.getDeclaredMethod("updateAsciiStream", Integer.TYPE, InputStream.class);
         methodObject6056 = ResultSet.class.getDeclaredMethod("updateClob", String.class, Reader.class);
         methodObject5922 = ResultSet.class.getDeclaredMethod("getObject", String.class);
         methodObject5832 = OracleResultSet.class.getDeclaredMethod("closeStatementOnClose");
         methodObject6107 = ResultSet.class.getDeclaredMethod("updateTimestamp", Integer.TYPE, Timestamp.class);
         methodObject5854 = oracle.jdbc.OracleResultSet.class.getDeclaredMethod("getORAData", String.class, ORADataFactory.class);
         methodObject5988 = ResultSet.class.getDeclaredMethod("getRowId", String.class);
         methodObject5912 = oracle.jdbc.OracleResultSet.class.getDeclaredMethod("updateTIMESTAMP", String.class, TIMESTAMP.class);
         methodObject6048 = ResultSet.class.getDeclaredMethod("updateCharacterStream", String.class, Reader.class, Long.TYPE);
         methodObject5924 = ResultSet.class.getDeclaredMethod("getObject", String.class, Map.class);
         methodObject6001 = ResultSet.class.getDeclaredMethod("getUnicodeStream", String.class);
         methodObject5918 = oracle.jdbc.OracleResultSet.class.getDeclaredMethod("updateNUMBER", String.class, NUMBER.class);
         methodObject5944 = ResultSet.class.getDeclaredMethod("getArray", String.class);
         methodObject5860 = oracle.jdbc.OracleResultSet.class.getDeclaredMethod("getOPAQUE", String.class);
         methodObject5952 = ResultSet.class.getDeclaredMethod("getRef", String.class);
         methodObject5925 = ResultSet.class.getDeclaredMethod("getObject", Integer.TYPE, Class.class);
         methodObject5921 = ResultSet.class.getDeclaredMethod("getObject", Integer.TYPE);
         methodObject5866 = oracle.jdbc.OracleResultSet.class.getDeclaredMethod("getROWID", String.class);
         methodObject6064 = ResultSet.class.getDeclaredMethod("updateInt", String.class, Integer.TYPE);
         methodObject6098 = ResultSet.class.getDeclaredMethod("getBlob", String.class);
         methodObject5848 = oracle.jdbc.OracleResultSet.class.getDeclaredMethod("getCHAR", String.class);
         methodObject6021 = ResultSet.class.getDeclaredMethod("updateAsciiStream", Integer.TYPE, InputStream.class, Long.TYPE);
         methodObject5877 = oracle.jdbc.OracleResultSet.class.getDeclaredMethod("getTIMESTAMPLTZ", Integer.TYPE);
         methodObject5998 = ResultSet.class.getDeclaredMethod("getTimestamp", Integer.TYPE, Calendar.class);
         methodObject6012 = ResultSet.class.getDeclaredMethod("rowDeleted");
         methodObject6088 = ResultSet.class.getDeclaredMethod("updateRowId", Integer.TYPE, RowId.class);
         methodObject5960 = ResultSet.class.getDeclaredMethod("afterLast");
         methodObject5969 = ResultSet.class.getDeclaredMethod("getBigDecimal", String.class, Integer.TYPE);
         methodObject6034 = ResultSet.class.getDeclaredMethod("updateBlob", String.class, Blob.class);
         methodObject5886 = oracle.jdbc.OracleResultSet.class.getDeclaredMethod("updateSTRUCT", String.class, STRUCT.class);
         methodObject6046 = ResultSet.class.getDeclaredMethod("updateCharacterStream", String.class, Reader.class, Integer.TYPE);
         methodObject6039 = ResultSet.class.getDeclaredMethod("updateBoolean", Integer.TYPE, Boolean.TYPE);
         methodObject5971 = ResultSet.class.getDeclaredMethod("getBigDecimal", String.class);
         methodObject6035 = ResultSet.class.getDeclaredMethod("updateBlob", Integer.TYPE, InputStream.class, Long.TYPE);
         methodObject5991 = ResultSet.class.getDeclaredMethod("getStatement");
         methodObject6095 = ResultSet.class.getDeclaredMethod("getWarnings");
         methodObject5867 = oracle.jdbc.OracleResultSet.class.getDeclaredMethod("getSTRUCT", Integer.TYPE);
         methodObject5893 = oracle.jdbc.OracleResultSet.class.getDeclaredMethod("updateBFILE", Integer.TYPE, BFILE.class);
         methodObject6025 = ResultSet.class.getDeclaredMethod("updateBigDecimal", Integer.TYPE, BigDecimal.class);
         methodObject6057 = ResultSet.class.getDeclaredMethod("updateDate", Integer.TYPE, Date.class);
         methodObject5846 = oracle.jdbc.OracleResultSet.class.getDeclaredMethod("getBLOB", String.class);
         methodObject5957 = ResultSet.class.getDeclaredMethod("getDate", Integer.TYPE, Calendar.class);
         methodObject6108 = ResultSet.class.getDeclaredMethod("updateTimestamp", String.class, Timestamp.class);
         methodObject5852 = oracle.jdbc.OracleResultSet.class.getDeclaredMethod("getCustomDatum", String.class, CustomDatumFactory.class);
         methodObject5977 = ResultSet.class.getDeclaredMethod("getCursorName");
         methodObject5839 = oracle.jdbc.OracleResultSet.class.getDeclaredMethod("getARRAY", Integer.TYPE);
         methodObject6037 = ResultSet.class.getDeclaredMethod("updateBlob", Integer.TYPE, InputStream.class);
         methodObject5948 = ResultSet.class.getDeclaredMethod("close");
         methodObject6045 = ResultSet.class.getDeclaredMethod("updateCharacterStream", Integer.TYPE, Reader.class, Integer.TYPE);
         methodObject5933 = ResultSet.class.getDeclaredMethod("getInt", Integer.TYPE);
         methodObject6030 = ResultSet.class.getDeclaredMethod("updateBinaryStream", String.class, InputStream.class, Long.TYPE);
         methodObject5863 = oracle.jdbc.OracleResultSet.class.getDeclaredMethod("getREF", Integer.TYPE);
         methodObject5878 = oracle.jdbc.OracleResultSet.class.getDeclaredMethod("getTIMESTAMPLTZ", String.class);
         methodObject5838 = oracle.jdbc.OracleResultSet.class.getDeclaredMethod("getCursor", String.class);
         methodObject5869 = oracle.jdbc.OracleResultSet.class.getDeclaredMethod("getINTERVALYM", Integer.TYPE);
         methodObject6052 = ResultSet.class.getDeclaredMethod("updateClob", String.class, Clob.class);
         methodObject5907 = oracle.jdbc.OracleResultSet.class.getDeclaredMethod("updateINTERVALYM", Integer.TYPE, INTERVALYM.class);
         methodObject5837 = oracle.jdbc.OracleResultSet.class.getDeclaredMethod("getCursor", Integer.TYPE);
         methodObject5901 = oracle.jdbc.OracleResultSet.class.getDeclaredMethod("updateCustomDatum", Integer.TYPE, CustomDatum.class);
         methodObject6000 = ResultSet.class.getDeclaredMethod("getUnicodeStream", Integer.TYPE);
         methodObject6065 = ResultSet.class.getDeclaredMethod("updateLong", Integer.TYPE, Long.TYPE);
         methodObject5875 = oracle.jdbc.OracleResultSet.class.getDeclaredMethod("getTIMESTAMPTZ", Integer.TYPE);
         methodObject6033 = ResultSet.class.getDeclaredMethod("updateBlob", Integer.TYPE, Blob.class);
         methodObject5982 = ResultSet.class.getDeclaredMethod("getNClob", Integer.TYPE);
         methodObject6019 = ResultSet.class.getDeclaredMethod("updateAsciiStream", Integer.TYPE, InputStream.class, Integer.TYPE);
         methodObject5986 = ResultSet.class.getDeclaredMethod("getRow");
         methodObject6044 = ResultSet.class.getDeclaredMethod("updateBytes", String.class, byte[].class);
         methodObject6027 = ResultSet.class.getDeclaredMethod("updateBinaryStream", Integer.TYPE, InputStream.class, Integer.TYPE);
         methodObject5928 = ResultSet.class.getDeclaredMethod("getBoolean", String.class);
         methodObject6002 = ResultSet.class.getDeclaredMethod("insertRow");
         methodObject5979 = ResultSet.class.getDeclaredMethod("getFetchSize");
         methodObject5970 = ResultSet.class.getDeclaredMethod("getBigDecimal", Integer.TYPE);
         methodObject6073 = ResultSet.class.getDeclaredMethod("updateNClob", Integer.TYPE, Reader.class, Long.TYPE);
         methodObject5884 = oracle.jdbc.OracleResultSet.class.getDeclaredMethod("updateROWID", String.class, ROWID.class);
         methodObject6058 = ResultSet.class.getDeclaredMethod("updateDate", String.class, Date.class);
         methodObject5891 = oracle.jdbc.OracleResultSet.class.getDeclaredMethod("updateBfile", Integer.TYPE, BFILE.class);
         methodObject5953 = ResultSet.class.getDeclaredMethod("getString", Integer.TYPE);
         methodObject6106 = ResultSet.class.getDeclaredMethod("updateTime", String.class, Time.class);
         methodObject6008 = ResultSet.class.getDeclaredMethod("moveToCurrentRow");
         methodObject6036 = ResultSet.class.getDeclaredMethod("updateBlob", String.class, InputStream.class, Long.TYPE);
         methodObject5996 = ResultSet.class.getDeclaredMethod("getTimestamp", Integer.TYPE);
         methodObject6038 = ResultSet.class.getDeclaredMethod("updateBlob", String.class, InputStream.class);
         methodObject5964 = ResultSet.class.getDeclaredMethod("findColumn", String.class);
         methodObject5908 = oracle.jdbc.OracleResultSet.class.getDeclaredMethod("updateINTERVALYM", String.class, INTERVALYM.class);
         methodObject5881 = oracle.jdbc.OracleResultSet.class.getDeclaredMethod("updateREF", Integer.TYPE, REF.class);
         methodObject6113 = ACProxyable.class.getDeclaredMethod("getACProxy");
         methodObject6028 = ResultSet.class.getDeclaredMethod("updateBinaryStream", String.class, InputStream.class, Integer.TYPE);
         methodObject5989 = ResultSet.class.getDeclaredMethod("getSQLXML", Integer.TYPE);
         methodObject5870 = oracle.jdbc.OracleResultSet.class.getDeclaredMethod("getINTERVALYM", String.class);
         methodObject5843 = oracle.jdbc.OracleResultSet.class.getDeclaredMethod("getBfile", Integer.TYPE);
         methodObject5849 = oracle.jdbc.OracleResultSet.class.getDeclaredMethod("getCLOB", Integer.TYPE);
         methodObject6004 = ResultSet.class.getDeclaredMethod("isBeforeFirst");
         methodObject5976 = ResultSet.class.getDeclaredMethod("getConcurrency");
         methodObject6078 = ResultSet.class.getDeclaredMethod("updateNString", String.class, String.class);
         methodObject5862 = oracle.jdbc.OracleResultSet.class.getDeclaredMethod("getRAW", String.class);
         methodObject5920 = oracle.jdbc.OracleResultSet.class.getDeclaredMethod("updateRAW", String.class, RAW.class);
         methodObject5942 = ResultSet.class.getDeclaredMethod("getBytes", String.class);
         methodObject6075 = ResultSet.class.getDeclaredMethod("updateNClob", Integer.TYPE, Reader.class);
         methodObject6103 = ResultSet.class.getDeclaredMethod("updateString", Integer.TYPE, String.class);
         methodObject5997 = ResultSet.class.getDeclaredMethod("getTimestamp", String.class);
         methodObject5851 = oracle.jdbc.OracleResultSet.class.getDeclaredMethod("getCustomDatum", Integer.TYPE, CustomDatumFactory.class);
         methodObject5940 = ResultSet.class.getDeclaredMethod("getDouble", String.class);
         methodObject5947 = ResultSet.class.getDeclaredMethod("getURL", String.class);
         methodObject6041 = ResultSet.class.getDeclaredMethod("updateByte", Integer.TYPE, Byte.TYPE);
         methodObject6013 = ResultSet.class.getDeclaredMethod("rowInserted");
         methodObject5913 = oracle.jdbc.OracleResultSet.class.getDeclaredMethod("updateTIMESTAMPTZ", Integer.TYPE, TIMESTAMPTZ.class);
         methodObject5937 = ResultSet.class.getDeclaredMethod("getFloat", Integer.TYPE);
         methodObject5883 = oracle.jdbc.OracleResultSet.class.getDeclaredMethod("updateROWID", Integer.TYPE, ROWID.class);
      } catch (Throwable var1) {
         throw new RuntimeException(var1);
      }
   }

   public oracle$1jdbc$1replay$1driver$1TxnReplayableResultSet$2oracle$1jdbc$1internal$1OracleResultSet$$$Proxy(OracleResultSet var1, Object var2, ProxyFactory var3, Map var4) {
      this.delegate = var1;
      this.creator = var2;
      this.proxyFactory = var3;
      this.proxyCache = var4;
   }
}
