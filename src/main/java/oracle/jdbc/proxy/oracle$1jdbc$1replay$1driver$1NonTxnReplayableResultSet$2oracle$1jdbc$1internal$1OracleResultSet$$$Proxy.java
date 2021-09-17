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
import oracle.jdbc.replay.driver.NonTxnReplayableResultSet;
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

public abstract class oracle$1jdbc$1replay$1driver$1NonTxnReplayableResultSet$2oracle$1jdbc$1internal$1OracleResultSet$$$Proxy extends NonTxnReplayableResultSet implements OracleResultSet, _Proxy_ {
   private OracleResultSet delegate;
   private final Object creator;
   private final ProxyFactory proxyFactory;
   private final Map proxyCache;
   private static Object[] zeroLengthObjectArray = new Object[0];
   private static Method methodObject17790;
   private static Method methodObject17656;
   private static Method methodObject17726;
   private static Method methodObject17759;
   private static Method methodObject17579;
   private static Method methodObject17763;
   private static Method methodObject17783;
   private static Method methodObject17622;
   private static Method methodObject17576;
   private static Method methodObject17592;
   private static Method methodObject17742;
   private static Method methodObject17776;
   private static Method methodObject17662;
   private static Method methodObject17638;
   private static Method methodObject17574;
   private static Method methodObject17565;
   private static Method methodObject17794;
   private static Method methodObject17556;
   private static Method methodObject17701;
   private static Method methodObject17807;
   private static Method methodObject17677;
   private static Method methodObject17801;
   private static Method methodObject17658;
   private static Method methodObject17589;
   private static Method methodObject17679;
   private static Method methodObject17695;
   private static Method methodObject17766;
   private static Method methodObject17665;
   private static Method methodObject17687;
   private static Method methodObject17596;
   private static Method methodObject17601;
   private static Method methodObject17676;
   private static Method methodObject17587;
   private static Method methodObject17591;
   private static Method methodObject17643;
   private static Method methodObject17562;
   private static Method methodObject17621;
   private static Method methodObject17789;
   private static Method methodObject17611;
   private static Method methodObject17736;
   private static Method methodObject17730;
   private static Method methodObject17675;
   private static Method methodObject17586;
   private static Method methodObject17684;
   private static Method methodObject17830;
   private static Method methodObject17760;
   private static Method methodObject17820;
   private static Method methodObject17725;
   private static Method methodObject17824;
   private static Method methodObject17787;
   private static Method methodObject17588;
   private static Method methodObject17728;
   private static Method methodObject17693;
   private static Method methodObject17697;
   private static Method methodObject17627;
   private static Method methodObject17635;
   private static Method methodObject17799;
   private static Method methodObject17614;
   private static Method methodObject17660;
   private static Method methodObject17731;
   private static Method methodObject17644;
   private static Method methodObject17704;
   private static Method methodObject17636;
   private static Method methodObject17712;
   private static Method methodObject17634;
   private static Method methodObject17711;
   private static Method methodObject17721;
   private static Method methodObject17811;
   private static Method methodObject17686;
   private static Method methodObject17793;
   private static Method methodObject17749;
   private static Method methodObject17655;
   private static Method methodObject17821;
   private static Method methodObject17796;
   private static Method methodObject17582;
   private static Method methodObject17707;
   private static Method methodObject17713;
   private static Method methodObject17810;
   private static Method methodObject17770;
   private static Method methodObject17733;
   private static Method methodObject17649;
   private static Method methodObject17599;
   private static Method methodObject17706;
   private static Method methodObject17751;
   private static Method methodObject17747;
   private static Method methodObject17719;
   private static Method methodObject17670;
   private static Method methodObject17816;
   private static Method methodObject17762;
   private static Method methodObject17750;
   private static Method methodObject17835;
   private static Method methodObject17673;
   private static Method methodObject17570;
   private static Method methodObject17573;
   private static Method methodObject17739;
   private static Method methodObject17585;
   private static Method methodObject17744;
   private static Method methodObject17651;
   private static Method methodObject17668;
   private static Method methodObject17803;
   private static Method methodObject17672;
   private static Method methodObject17724;
   private static Method methodObject17786;
   private static Method methodObject17623;
   private static Method methodObject17578;
   private static Method methodObject17754;
   private static Method methodObject17664;
   private static Method methodObject17681;
   private static Method methodObject17557;
   private static Method methodObject17806;
   private static Method methodObject17603;
   private static Method methodObject17560;
   private static Method methodObject17779;
   private static Method methodObject17825;
   private static Method methodObject17613;
   private static Method methodObject17632;
   private static Method methodObject17604;
   private static Method methodObject17767;
   private static Method methodObject17833;
   private static Method methodObject17791;
   private static Method methodObject17616;
   private static Method methodObject17823;
   private static Method methodObject17758;
   private static Method methodObject17752;
   private static Method methodObject17564;
   private static Method methodObject17802;
   private static Method methodObject17800;
   private static Method methodObject17737;
   private static Method methodObject17832;
   private static Method methodObject17633;
   private static Method methodObject17657;
   private static Method methodObject17620;
   private static Method methodObject17702;
   private static Method methodObject17682;
   private static Method methodObject17814;
   private static Method methodObject17584;
   private static Method methodObject17561;
   private static Method methodObject17709;
   private static Method methodObject17812;
   private static Method methodObject17600;
   private static Method methodObject17705;
   private static Method methodObject17641;
   private static Method methodObject17740;
   private static Method methodObject17609;
   private static Method methodObject17608;
   private static Method methodObject17788;
   private static Method methodObject17619;
   private static Method methodObject17699;
   private static Method methodObject17625;
   private static Method methodObject17610;
   private static Method methodObject17563;
   private static Method methodObject17567;
   private static Method methodObject17784;
   private static Method methodObject17813;
   private static Method methodObject17817;
   private static Method methodObject17577;
   private static Method methodObject17692;
   private static Method methodObject17723;
   private static Method methodObject17765;
   private static Method methodObject17809;
   private static Method methodObject17798;
   private static Method methodObject17580;
   private static Method methodObject17703;
   private static Method methodObject17738;
   private static Method methodObject17645;
   private static Method methodObject17729;
   private static Method methodObject17629;
   private static Method methodObject17805;
   private static Method methodObject17617;
   private static Method methodObject17696;
   private static Method methodObject17650;
   private static Method methodObject17741;
   private static Method methodObject17743;
   private static Method methodObject17688;
   private static Method methodObject17575;
   private static Method methodObject17637;
   private static Method methodObject17827;
   private static Method methodObject17555;
   private static Method methodObject17654;
   private static Method methodObject17674;
   private static Method methodObject17605;
   private static Method methodObject17590;
   private static Method methodObject17678;
   private static Method methodObject17714;
   private static Method methodObject17828;
   private static Method methodObject17808;
   private static Method methodObject17646;
   private static Method methodObject17780;
   private static Method methodObject17680;
   private static Method methodObject17626;
   private static Method methodObject17768;
   private static Method methodObject17639;
   private static Method methodObject17829;
   private static Method methodObject17774;
   private static Method methodObject17558;
   private static Method methodObject17795;
   private static Method methodObject17775;
   private static Method methodObject17593;
   private static Method methodObject17669;
   private static Method methodObject17667;
   private static Method methodObject17708;
   private static Method methodObject17727;
   private static Method methodObject17566;
   private static Method methodObject17735;
   private static Method methodObject17594;
   private static Method methodObject17652;
   private static Method methodObject17618;
   private static Method methodObject17612;
   private static Method methodObject17642;
   private static Method methodObject17606;
   private static Method methodObject17757;
   private static Method methodObject17659;
   private static Method methodObject17715;
   private static Method methodObject17777;
   private static Method methodObject17628;
   private static Method methodObject17782;
   private static Method methodObject17746;
   private static Method methodObject17671;
   private static Method methodObject17694;
   private static Method methodObject17602;
   private static Method methodObject17663;
   private static Method methodObject17648;
   private static Method methodObject17822;
   private static Method methodObject17773;
   private static Method methodObject17756;
   private static Method methodObject17732;
   private static Method methodObject17624;
   private static Method methodObject17785;
   private static Method methodObject17717;
   private static Method methodObject17691;
   private static Method methodObject17653;
   private static Method methodObject17690;
   private static Method methodObject17826;
   private static Method methodObject17571;
   private static Method methodObject17666;
   private static Method methodObject17698;
   private static Method methodObject17755;
   private static Method methodObject17689;
   private static Method methodObject17630;
   private static Method methodObject17716;
   private static Method methodObject17792;
   private static Method methodObject17640;
   private static Method methodObject17685;
   private static Method methodObject17818;
   private static Method methodObject17753;
   private static Method methodObject17615;
   private static Method methodObject17597;
   private static Method methodObject17661;
   private static Method methodObject17718;
   private static Method methodObject17607;
   private static Method methodObject17683;
   private static Method methodObject17772;
   private static Method methodObject17771;
   private static Method methodObject17819;
   private static Method methodObject17748;
   private static Method methodObject17595;
   private static Method methodObject17764;
   private static Method methodObject17710;
   private static Method methodObject17804;
   private static Method methodObject17559;
   private static Method methodObject17572;
   private static Method methodObject17815;
   private static Method methodObject17834;
   private static Method methodObject17647;
   private static Method methodObject17631;
   private static Method methodObject17836;
   private static Method methodObject17598;
   private static Method methodObject17722;
   private static Method methodObject17700;
   private static Method methodObject17734;
   private static Method methodObject17569;
   private static Method methodObject17583;
   private static Method methodObject17797;
   private static Method methodObject17761;
   private static Method methodObject17720;
   private static Method methodObject17745;
   private static Method methodObject17781;
   private static Method methodObject17831;
   private static Method methodObject17581;
   private static Method methodObject17568;
   private static Method methodObject17778;
   private static Method methodObject17769;

   public void updateBytes(String arg0, byte[] arg1) throws SQLException {
      try {
         super.preForAll(methodObject17790, this, arg0, arg1);
         Method var10001 = methodObject17790;
         this.delegate.updateBytes(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject17790, var4);
      }
   }

   public int getInt(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject17656, this, arg0);
         return (Integer)this.postForAll(methodObject17656, this.delegate.getInt(arg0));
      } catch (SQLException var3) {
         return (Integer)this.postForAll(methodObject17656, this.onErrorForAll(methodObject17656, var3));
      }
   }

   public Time getTime(String arg0, Calendar arg1) throws SQLException {
      try {
         super.preForAll(methodObject17726, this, arg0, arg1);
         return (Time)this.postForAll(methodObject17726, (Object)this.delegate.getTime(arg0, arg1));
      } catch (SQLException var4) {
         return (Time)this.postForAll(methodObject17726, this.onErrorForAll(methodObject17726, var4));
      }
   }

   public InputStream getUnicodeStream(String arg0) throws SQLException {
      try {
         super.preForAll(methodObject17759, this, arg0);
         return (InputStream)this.postForAll(methodObject17759, (Object)this.delegate.getUnicodeStream(arg0));
      } catch (SQLException var3) {
         return (InputStream)this.postForAll(methodObject17759, this.onErrorForAll(methodObject17759, var3));
      }
   }

   public void updateINTERVALDS(String arg0, INTERVALDS arg1) throws SQLException {
      try {
         super.preForAll(methodObject17579, this, arg0, arg1);
         Method var10001 = methodObject17579;
         this.delegate.updateINTERVALDS(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject17579, var4);
      }
   }

   public boolean isLast() throws SQLException {
      try {
         super.preForAll(methodObject17763, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject17763, this.delegate.isLast());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject17763, this.onErrorForAll(methodObject17763, var2));
      }
   }

   public void updateBlob(int arg0, InputStream arg1) throws SQLException {
      try {
         super.preForAll(methodObject17783, this, arg0, arg1);
         Method var10001 = methodObject17783;
         this.delegate.updateBlob(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject17783, var4);
      }
   }

   public OPAQUE getOPAQUE(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject17622, this, arg0);
         return (OPAQUE)this.postForAll(methodObject17622, (Object)this.delegate.getOPAQUE(arg0));
      } catch (SQLException var3) {
         return (OPAQUE)this.postForAll(methodObject17622, this.onErrorForAll(methodObject17622, var3));
      }
   }

   public void updateINTERVALYM(int arg0, INTERVALYM arg1) throws SQLException {
      try {
         super.preForAll(methodObject17576, this, arg0, arg1);
         Method var10001 = methodObject17576;
         this.delegate.updateINTERVALYM(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject17576, var4);
      }
   }

   public void updateREF(int arg0, REF arg1) throws SQLException {
      try {
         super.preForAll(methodObject17592, this, arg0, arg1);
         Method var10001 = methodObject17592;
         this.delegate.updateREF(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject17592, var4);
      }
   }

   public BigDecimal getBigDecimal(String arg0, int arg1) throws SQLException {
      try {
         super.preForAll(methodObject17742, this, arg0, arg1);
         return (BigDecimal)this.postForAll(methodObject17742, (Object)this.delegate.getBigDecimal(arg0, arg1));
      } catch (SQLException var4) {
         return (BigDecimal)this.postForAll(methodObject17742, this.onErrorForAll(methodObject17742, var4));
      }
   }

   public void updateArray(String arg0, Array arg1) throws SQLException {
      try {
         super.preForAll(methodObject17776, this, arg0, arg1);
         Method var10001 = methodObject17776;
         this.delegate.updateArray(arg0, arg1 instanceof _Proxy_ ? (Array)((_Proxy_)arg1)._getDelegate_() : arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject17776, var4);
      }
   }

   public double getDouble(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject17662, this, arg0);
         return (Double)this.postForAll(methodObject17662, this.delegate.getDouble(arg0));
      } catch (SQLException var3) {
         return (Double)this.postForAll(methodObject17662, this.onErrorForAll(methodObject17662, var3));
      }
   }

   public TIMESTAMPTZ getTIMESTAMPTZ(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject17638, this, arg0);
         return (TIMESTAMPTZ)this.postForAll(methodObject17638, (Object)this.delegate.getTIMESTAMPTZ(arg0));
      } catch (SQLException var3) {
         return (TIMESTAMPTZ)this.postForAll(methodObject17638, this.onErrorForAll(methodObject17638, var3));
      }
   }

   public void updateDATE(int arg0, DATE arg1) throws SQLException {
      try {
         super.preForAll(methodObject17574, this, arg0, arg1);
         Method var10001 = methodObject17574;
         this.delegate.updateDATE(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject17574, var4);
      }
   }

   public void updateBFILE(String arg0, BFILE arg1) throws SQLException {
      try {
         super.preForAll(methodObject17565, this, arg0, arg1);
         Method var10001 = methodObject17565;
         this.delegate.updateBFILE(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject17565, var4);
      }
   }

   public void updateClob(String arg0, Reader arg1, long arg2) throws SQLException {
      try {
         super.preForAll(methodObject17794, this, arg0, arg1, arg2);
         Method var10001 = methodObject17794;
         this.delegate.updateClob(arg0, arg1, arg2);
         this.postForAll(var10001);
      } catch (SQLException var6) {
         this.onErrorVoidForAll(methodObject17794, var6);
      }
   }

   public Object getObject(int arg0, OracleDataFactory arg1) throws SQLException {
      try {
         super.preForAll(methodObject17556, this, arg0, arg1);
         return this.postForAll(methodObject17556, this.proxyFactory.proxyForCreate(this.delegate.getObject(arg0, arg1), this, this.proxyCache, methodObject17556));
      } catch (SQLException var4) {
         return this.postForAll(methodObject17556, this.onErrorForAll(methodObject17556, var4));
      }
   }

   public void updateCharacterStream(int arg0, Reader arg1) throws SQLException {
      try {
         super.preForUpdateStreams(methodObject17701, this, arg0, arg1);
         Method var10001 = methodObject17701;
         this.delegate.updateCharacterStream(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject17701, var4);
      }
   }

   public void updateNClob(int arg0, NClob arg1) throws SQLException {
      try {
         super.preForAll(methodObject17807, this, arg0, arg1);
         Method var10001 = methodObject17807;
         this.delegate.updateNClob(arg0, arg1 instanceof _Proxy_ ? (NClob)((_Proxy_)arg1)._getDelegate_() : arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject17807, var4);
      }
   }

   public String getString(String arg0) throws SQLException {
      try {
         super.preForAll(methodObject17677, this, arg0);
         return (String)this.postForAll(methodObject17677, (Object)this.delegate.getString(arg0));
      } catch (SQLException var3) {
         return (String)this.postForAll(methodObject17677, this.onErrorForAll(methodObject17677, var3));
      }
   }

   public void updateFloat(int arg0, float arg1) throws SQLException {
      try {
         super.preForAll(methodObject17801, this, arg0, arg1);
         Method var10001 = methodObject17801;
         this.delegate.updateFloat(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject17801, var4);
      }
   }

   public long getLong(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject17658, this, arg0);
         return (Long)this.postForAll(methodObject17658, this.delegate.getLong(arg0));
      } catch (SQLException var3) {
         return (Long)this.postForAll(methodObject17658, this.onErrorForAll(methodObject17658, var3));
      }
   }

   public void updateOracleObject(String arg0, Datum arg1) throws SQLException {
      try {
         super.preForAll(methodObject17589, this, arg0, arg1);
         Method var10001 = methodObject17589;
         this.delegate.updateOracleObject(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject17589, var4);
      }
   }

   public Date getDate(String arg0) throws SQLException {
      try {
         super.preForAll(methodObject17679, this, arg0);
         return (Date)this.postForAll(methodObject17679, (Object)this.delegate.getDate(arg0));
      } catch (SQLException var3) {
         return (Date)this.postForAll(methodObject17679, this.onErrorForAll(methodObject17679, var3));
      }
   }

   public void updateBinaryStream(int arg0, InputStream arg1) throws SQLException {
      try {
         super.preForUpdateStreams(methodObject17695, this, arg0, arg1);
         Method var10001 = methodObject17695;
         this.delegate.updateBinaryStream(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject17695, var4);
      }
   }

   public void refreshRow() throws SQLException {
      try {
         super.preForAll(methodObject17766, this, zeroLengthObjectArray);
         Method var10001 = methodObject17766;
         this.delegate.refreshRow();
         this.postForAll(var10001);
      } catch (SQLException var2) {
         this.onErrorVoidForAll(methodObject17766, var2);
      }
   }

   public byte[] getBytes(String arg0) throws SQLException {
      try {
         super.preForAll(methodObject17665, this, arg0);
         return (byte[])this.postForAll(methodObject17665, (Object)this.delegate.getBytes(arg0));
      } catch (SQLException var3) {
         return (byte[])this.postForAll(methodObject17665, this.onErrorForAll(methodObject17665, var3));
      }
   }

   public void updateAsciiStream(int arg0, InputStream arg1, long arg2) throws SQLException {
      try {
         super.preForUpdateStreams(methodObject17687, this, arg0, arg1, arg2);
         Method var10001 = methodObject17687;
         this.delegate.updateAsciiStream(arg0, arg1, arg2);
         this.postForAll(var10001);
      } catch (SQLException var6) {
         this.onErrorVoidForAll(methodObject17687, var6);
      }
   }

   public void updateSTRUCT(int arg0, STRUCT arg1) throws SQLException {
      try {
         super.preForAll(methodObject17596, this, arg0, arg1);
         Method var10001 = methodObject17596;
         this.delegate.updateSTRUCT(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject17596, var4);
      }
   }

   public Datum getOracleObject(String arg0) throws SQLException {
      try {
         super.preForAll(methodObject17601, this, arg0);
         return (Datum)this.postForAll(methodObject17601, (Object)this.delegate.getOracleObject(arg0));
      } catch (SQLException var3) {
         return (Datum)this.postForAll(methodObject17601, this.onErrorForAll(methodObject17601, var3));
      }
   }

   public String getString(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject17676, this, arg0);
         return (String)this.postForAll(methodObject17676, (Object)this.delegate.getString(arg0));
      } catch (SQLException var3) {
         return (String)this.postForAll(methodObject17676, this.onErrorForAll(methodObject17676, var3));
      }
   }

   public void updateNUMBER(String arg0, NUMBER arg1) throws SQLException {
      try {
         super.preForAll(methodObject17587, this, arg0, arg1);
         Method var10001 = methodObject17587;
         this.delegate.updateNUMBER(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject17587, var4);
      }
   }

   public void updateRAW(String arg0, RAW arg1) throws SQLException {
      try {
         super.preForAll(methodObject17591, this, arg0, arg1);
         Method var10001 = methodObject17591;
         this.delegate.updateRAW(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject17591, var4);
      }
   }

   public ARRAY getARRAY(String arg0) throws SQLException {
      try {
         super.preForAll(methodObject17643, this, arg0);
         return (ARRAY)this.postForAll(methodObject17643, (Object)this.delegate.getARRAY(arg0));
      } catch (SQLException var3) {
         return (ARRAY)this.postForAll(methodObject17643, this.onErrorForAll(methodObject17643, var3));
      }
   }

   public void updateBfile(int arg0, BFILE arg1) throws SQLException {
      try {
         super.preForAll(methodObject17562, this, arg0, arg1);
         Method var10001 = methodObject17562;
         this.delegate.updateBfile(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject17562, var4);
      }
   }

   public NUMBER getNUMBER(String arg0) throws SQLException {
      try {
         super.preForAll(methodObject17621, this, arg0);
         return (NUMBER)this.postForAll(methodObject17621, (Object)this.delegate.getNUMBER(arg0));
      } catch (SQLException var3) {
         return (NUMBER)this.postForAll(methodObject17621, this.onErrorForAll(methodObject17621, var3));
      }
   }

   public void updateBytes(int arg0, byte[] arg1) throws SQLException {
      try {
         super.preForAll(methodObject17789, this, arg0, arg1);
         Method var10001 = methodObject17789;
         this.delegate.updateBytes(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject17789, var4);
      }
   }

   public CHAR getCHAR(String arg0) throws SQLException {
      try {
         super.preForAll(methodObject17611, this, arg0);
         return (CHAR)this.postForAll(methodObject17611, (Object)this.delegate.getCHAR(arg0));
      } catch (SQLException var3) {
         return (CHAR)this.postForAll(methodObject17611, this.onErrorForAll(methodObject17611, var3));
      }
   }

   public boolean wasNull() throws SQLException {
      try {
         super.preForAll(methodObject17736, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject17736, this.delegate.wasNull());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject17736, this.onErrorForAll(methodObject17736, var2));
      }
   }

   public void updateTime(int arg0, Time arg1) throws SQLException {
      try {
         super.preForAll(methodObject17730, this, arg0, arg1);
         Method var10001 = methodObject17730;
         this.delegate.updateTime(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject17730, var4);
      }
   }

   public Ref getRef(String arg0) throws SQLException {
      try {
         super.preForAll(methodObject17675, this, arg0);
         return (Ref)this.postForAll(methodObject17675, this.proxyFactory.proxyForCreate((Object)this.delegate.getRef(arg0), this, this.proxyCache, methodObject17675));
      } catch (SQLException var3) {
         return (Ref)this.postForAll(methodObject17675, this.onErrorForAll(methodObject17675, var3));
      }
   }

   public void updateNUMBER(int arg0, NUMBER arg1) throws SQLException {
      try {
         super.preForAll(methodObject17586, this, arg0, arg1);
         Method var10001 = methodObject17586;
         this.delegate.updateNUMBER(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject17586, var4);
      }
   }

   public void updateRow() throws SQLException {
      try {
         super.preForRowUpdates(methodObject17684, this, zeroLengthObjectArray);
         Method var10001 = methodObject17684;
         this.delegate.updateRow();
         this.postForAll(var10001);
      } catch (SQLException var2) {
         this.onErrorVoidForAll(methodObject17684, var2);
      }
   }

   public void updateString(String arg0, String arg1) throws SQLException {
      try {
         super.preForAll(methodObject17830, this, arg0, arg1);
         Method var10001 = methodObject17830;
         this.delegate.updateString(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject17830, var4);
      }
   }

   public boolean isAfterLast() throws SQLException {
      try {
         super.preForAll(methodObject17760, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject17760, this.delegate.isAfterLast());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject17760, this.onErrorForAll(methodObject17760, var2));
      }
   }

   public void updateObject(String arg0, Object arg1) throws SQLException {
      try {
         super.preForAll(methodObject17820, this, arg0, arg1);
         Method var10001 = methodObject17820;
         this.delegate.updateObject(arg0, arg1 instanceof _Proxy_ ? (Object)((_Proxy_)arg1)._getDelegate_() : arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject17820, var4);
      }
   }

   public Time getTime(int arg0, Calendar arg1) throws SQLException {
      try {
         super.preForAll(methodObject17725, this, arg0, arg1);
         return (Time)this.postForAll(methodObject17725, (Object)this.delegate.getTime(arg0, arg1));
      } catch (SQLException var4) {
         return (Time)this.postForAll(methodObject17725, this.onErrorForAll(methodObject17725, var4));
      }
   }

   public void updateRowId(String arg0, RowId arg1) throws SQLException {
      try {
         super.preForAll(methodObject17824, this, arg0, arg1);
         Method var10001 = methodObject17824;
         this.delegate.updateRowId(arg0, arg1 instanceof _Proxy_ ? (RowId)((_Proxy_)arg1)._getDelegate_() : arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject17824, var4);
      }
   }

   public void updateByte(int arg0, byte arg1) throws SQLException {
      try {
         super.preForAll(methodObject17787, this, arg0, arg1);
         Method var10001 = methodObject17787;
         this.delegate.updateByte(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject17787, var4);
      }
   }

   public void updateOracleObject(int arg0, Datum arg1) throws SQLException {
      try {
         super.preForAll(methodObject17588, this, arg0, arg1);
         Method var10001 = methodObject17588;
         this.delegate.updateOracleObject(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject17588, var4);
      }
   }

   public void clearWarnings() throws SQLException {
      try {
         super.preForAll(methodObject17728, this, zeroLengthObjectArray);
         Method var10001 = methodObject17728;
         this.delegate.clearWarnings();
         this.postForAll(var10001);
      } catch (SQLException var2) {
         this.onErrorVoidForAll(methodObject17728, var2);
      }
   }

   public void updateBinaryStream(int arg0, InputStream arg1, long arg2) throws SQLException {
      try {
         super.preForUpdateStreams(methodObject17693, this, arg0, arg1, arg2);
         Method var10001 = methodObject17693;
         this.delegate.updateBinaryStream(arg0, arg1, arg2);
         this.postForAll(var10001);
      } catch (SQLException var6) {
         this.onErrorVoidForAll(methodObject17693, var6);
      }
   }

   public void updateCharacterStream(int arg0, Reader arg1, int arg2) throws SQLException {
      try {
         super.preForUpdateStreams(methodObject17697, this, arg0, arg1, arg2);
         Method var10001 = methodObject17697;
         this.delegate.updateCharacterStream(arg0, arg1, arg2);
         this.postForAll(var10001);
      } catch (SQLException var5) {
         this.onErrorVoidForAll(methodObject17697, var5);
      }
   }

   public REF getREF(String arg0) throws SQLException {
      try {
         super.preForAll(methodObject17627, this, arg0);
         return (REF)this.postForAll(methodObject17627, (Object)this.delegate.getREF(arg0));
      } catch (SQLException var3) {
         return (REF)this.postForAll(methodObject17627, this.onErrorForAll(methodObject17627, var3));
      }
   }

   public INTERVALDS getINTERVALDS(String arg0) throws SQLException {
      try {
         super.preForAll(methodObject17635, this, arg0);
         return (INTERVALDS)this.postForAll(methodObject17635, (Object)this.delegate.getINTERVALDS(arg0));
      } catch (SQLException var3) {
         return (INTERVALDS)this.postForAll(methodObject17635, this.onErrorForAll(methodObject17635, var3));
      }
   }

   public void updateDouble(int arg0, double arg1) throws SQLException {
      try {
         super.preForAll(methodObject17799, this, arg0, arg1);
         Method var10001 = methodObject17799;
         this.delegate.updateDouble(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var5) {
         this.onErrorVoidForAll(methodObject17799, var5);
      }
   }

   public CustomDatum getCustomDatum(int arg0, CustomDatumFactory arg1) throws SQLException {
      try {
         super.preForAll(methodObject17614, this, arg0, arg1);
         return (CustomDatum)this.postForAll(methodObject17614, (Object)this.delegate.getCustomDatum(arg0, arg1));
      } catch (SQLException var4) {
         return (CustomDatum)this.postForAll(methodObject17614, this.onErrorForAll(methodObject17614, var4));
      }
   }

   public float getFloat(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject17660, this, arg0);
         return (Float)this.postForAll(methodObject17660, this.delegate.getFloat(arg0));
      } catch (SQLException var3) {
         return (Float)this.postForAll(methodObject17660, this.onErrorForAll(methodObject17660, var3));
      }
   }

   public void updateTime(String arg0, Time arg1) throws SQLException {
      try {
         super.preForAll(methodObject17731, this, arg0, arg1);
         Method var10001 = methodObject17731;
         this.delegate.updateTime(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject17731, var4);
      }
   }

   public Object getObject(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject17644, this, arg0);
         return this.postForAll(methodObject17644, this.proxyFactory.proxyForCreate(this.delegate.getObject(arg0), this, this.proxyCache, methodObject17644));
      } catch (SQLException var3) {
         return this.postForAll(methodObject17644, this.onErrorForAll(methodObject17644, var3));
      }
   }

   public void updateNCharacterStream(String arg0, Reader arg1, long arg2) throws SQLException {
      try {
         super.preForUpdateStreams(methodObject17704, this, arg0, arg1, arg2);
         Method var10001 = methodObject17704;
         this.delegate.updateNCharacterStream(arg0, arg1, arg2);
         this.postForAll(var10001);
      } catch (SQLException var6) {
         this.onErrorVoidForAll(methodObject17704, var6);
      }
   }

   public TIMESTAMP getTIMESTAMP(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject17636, this, arg0);
         return (TIMESTAMP)this.postForAll(methodObject17636, (Object)this.delegate.getTIMESTAMP(arg0));
      } catch (SQLException var3) {
         return (TIMESTAMP)this.postForAll(methodObject17636, this.onErrorForAll(methodObject17636, var3));
      }
   }

   public ResultSetMetaData getMetaData() throws SQLException {
      try {
         super.preForAll(methodObject17712, this, zeroLengthObjectArray);
         return (ResultSetMetaData)this.postForAll(methodObject17712, this.proxyFactory.proxyForCreate((Object)this.delegate.getMetaData(), this, this.proxyCache, methodObject17712));
      } catch (SQLException var2) {
         return (ResultSetMetaData)this.postForAll(methodObject17712, this.onErrorForAll(methodObject17712, var2));
      }
   }

   public INTERVALDS getINTERVALDS(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject17634, this, arg0);
         return (INTERVALDS)this.postForAll(methodObject17634, (Object)this.delegate.getINTERVALDS(arg0));
      } catch (SQLException var3) {
         return (INTERVALDS)this.postForAll(methodObject17634, this.onErrorForAll(methodObject17634, var3));
      }
   }

   public boolean isClosed() throws SQLException {
      try {
         super.preForAll(methodObject17711, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject17711, this.delegate.isClosed());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject17711, this.onErrorForAll(methodObject17711, var2));
      }
   }

   public SQLXML getSQLXML(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject17721, this, arg0);
         return (SQLXML)this.postForAll(methodObject17721, this.proxyFactory.proxyForCreate((Object)this.delegate.getSQLXML(arg0), this, this.proxyCache, methodObject17721));
      } catch (SQLException var3) {
         return (SQLXML)this.postForAll(methodObject17721, this.onErrorForAll(methodObject17721, var3));
      }
   }

   public void updateNClob(int arg0, Reader arg1) throws SQLException {
      try {
         super.preForAll(methodObject17811, this, arg0, arg1);
         Method var10001 = methodObject17811;
         this.delegate.updateNClob(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject17811, var4);
      }
   }

   public void updateAsciiStream(String arg0, InputStream arg1, int arg2) throws SQLException {
      try {
         super.preForUpdateStreams(methodObject17686, this, arg0, arg1, arg2);
         Method var10001 = methodObject17686;
         this.delegate.updateAsciiStream(arg0, arg1, arg2);
         this.postForAll(var10001);
      } catch (SQLException var5) {
         this.onErrorVoidForAll(methodObject17686, var5);
      }
   }

   public void updateClob(int arg0, Reader arg1, long arg2) throws SQLException {
      try {
         super.preForAll(methodObject17793, this, arg0, arg1, arg2);
         Method var10001 = methodObject17793;
         this.delegate.updateClob(arg0, arg1, arg2);
         this.postForAll(var10001);
      } catch (SQLException var6) {
         this.onErrorVoidForAll(methodObject17793, var6);
      }
   }

   public Reader getNCharacterStream(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject17749, this, arg0);
         return (Reader)this.postForAll(methodObject17749, (Object)this.delegate.getNCharacterStream(arg0));
      } catch (SQLException var3) {
         return (Reader)this.postForAll(methodObject17749, this.onErrorForAll(methodObject17749, var3));
      }
   }

   public short getShort(String arg0) throws SQLException {
      try {
         super.preForAll(methodObject17655, this, arg0);
         return (Short)this.postForAll(methodObject17655, this.delegate.getShort(arg0));
      } catch (SQLException var3) {
         return (Short)this.postForAll(methodObject17655, this.onErrorForAll(methodObject17655, var3));
      }
   }

   public void updateRef(int arg0, Ref arg1) throws SQLException {
      try {
         super.preForAll(methodObject17821, this, arg0, arg1);
         Method var10001 = methodObject17821;
         this.delegate.updateRef(arg0, arg1 instanceof _Proxy_ ? (Ref)((_Proxy_)arg1)._getDelegate_() : arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject17821, var4);
      }
   }

   public void updateClob(String arg0, Reader arg1) throws SQLException {
      try {
         super.preForAll(methodObject17796, this, arg0, arg1);
         Method var10001 = methodObject17796;
         this.delegate.updateClob(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject17796, var4);
      }
   }

   public void updateTIMESTAMPTZ(int arg0, TIMESTAMPTZ arg1) throws SQLException {
      try {
         super.preForAll(methodObject17582, this, arg0, arg1);
         Method var10001 = methodObject17582;
         this.delegate.updateTIMESTAMPTZ(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject17582, var4);
      }
   }

   public boolean last() throws SQLException {
      try {
         super.preForAll(methodObject17707, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject17707, this.delegate.last());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject17707, this.onErrorForLast(methodObject17707, var2));
      }
   }

   public Blob getBlob(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject17713, this, arg0);
         return (Blob)this.postForAll(methodObject17713, this.proxyFactory.proxyForCreate((Object)this.delegate.getBlob(arg0), this, this.proxyCache, methodObject17713));
      } catch (SQLException var3) {
         return (Blob)this.postForAll(methodObject17713, this.onErrorForAll(methodObject17713, var3));
      }
   }

   public void updateNClob(String arg0, Reader arg1, long arg2) throws SQLException {
      try {
         super.preForAll(methodObject17810, this, arg0, arg1, arg2);
         Method var10001 = methodObject17810;
         this.delegate.updateNClob(arg0, arg1, arg2);
         this.postForAll(var10001);
      } catch (SQLException var6) {
         this.onErrorVoidForAll(methodObject17810, var6);
      }
   }

   public boolean rowUpdated() throws SQLException {
      try {
         super.preForAll(methodObject17770, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject17770, this.delegate.rowUpdated());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject17770, this.onErrorForAll(methodObject17770, var2));
      }
   }

   public InputStream getAsciiStream(String arg0) throws SQLException {
      try {
         super.preForAll(methodObject17733, this, arg0);
         return (InputStream)this.postForAll(methodObject17733, (Object)this.delegate.getAsciiStream(arg0));
      } catch (SQLException var3) {
         return (InputStream)this.postForAll(methodObject17733, this.onErrorForAll(methodObject17733, var3));
      }
   }

   public Object getObject(String arg0, Class arg1) throws SQLException {
      try {
         super.preForAll(methodObject17649, this, arg0, arg1);
         return this.postForAll(methodObject17649, this.proxyFactory.proxyForCreate(this.delegate.getObject(arg0, arg1), this, this.proxyCache, methodObject17649));
      } catch (SQLException var4) {
         return this.postForAll(methodObject17649, this.onErrorForAll(methodObject17649, var4));
      }
   }

   public oracle.jdbc.OracleResultSet.AuthorizationIndicator getAuthorizationIndicator(String arg0) throws SQLException {
      try {
         super.preForAll(methodObject17599, this, arg0);
         return (oracle.jdbc.OracleResultSet.AuthorizationIndicator)this.postForAll(methodObject17599, (Object)this.delegate.getAuthorizationIndicator(arg0));
      } catch (SQLException var3) {
         return (oracle.jdbc.OracleResultSet.AuthorizationIndicator)this.postForAll(methodObject17599, this.onErrorForAll(methodObject17599, var3));
      }
   }

   public void updateNCharacterStream(String arg0, Reader arg1) throws SQLException {
      try {
         super.preForUpdateStreams(methodObject17706, this, arg0, arg1);
         Method var10001 = methodObject17706;
         this.delegate.updateNCharacterStream(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject17706, var4);
      }
   }

   public String getNString(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject17751, this, arg0);
         return (String)this.postForAll(methodObject17751, (Object)this.delegate.getNString(arg0));
      } catch (SQLException var3) {
         return (String)this.postForAll(methodObject17751, this.onErrorForAll(methodObject17751, var3));
      }
   }

   public int getFetchDirection() throws SQLException {
      try {
         super.preForAll(methodObject17747, this, zeroLengthObjectArray);
         return (Integer)this.postForAll(methodObject17747, this.delegate.getFetchDirection());
      } catch (SQLException var2) {
         return (Integer)this.postForAll(methodObject17747, this.onErrorForAll(methodObject17747, var2));
      }
   }

   public RowId getRowId(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject17719, this, arg0);
         return (RowId)this.postForAll(methodObject17719, this.proxyFactory.proxyForCreate((Object)this.delegate.getRowId(arg0), this, this.proxyCache, methodObject17719));
      } catch (SQLException var3) {
         return (RowId)this.postForAll(methodObject17719, this.onErrorForAll(methodObject17719, var3));
      }
   }

   public URL getURL(String arg0) throws SQLException {
      try {
         super.preForAll(methodObject17670, this, arg0);
         return (URL)this.postForAll(methodObject17670, (Object)this.delegate.getURL(arg0));
      } catch (SQLException var3) {
         return (URL)this.postForAll(methodObject17670, this.onErrorForAll(methodObject17670, var3));
      }
   }

   public void updateNull(String arg0) throws SQLException {
      try {
         super.preForAll(methodObject17816, this, arg0);
         Method var10001 = methodObject17816;
         this.delegate.updateNull(arg0);
         this.postForAll(var10001);
      } catch (SQLException var3) {
         this.onErrorVoidForAll(methodObject17816, var3);
      }
   }

   public boolean isFirst() throws SQLException {
      try {
         super.preForAll(methodObject17762, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject17762, this.delegate.isFirst());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject17762, this.onErrorForAll(methodObject17762, var2));
      }
   }

   public Reader getNCharacterStream(String arg0) throws SQLException {
      try {
         super.preForAll(methodObject17750, this, arg0);
         return (Reader)this.postForAll(methodObject17750, (Object)this.delegate.getNCharacterStream(arg0));
      } catch (SQLException var3) {
         return (Reader)this.postForAll(methodObject17750, this.onErrorForAll(methodObject17750, var3));
      }
   }

   public void setACProxy(Object arg0) {
      super.preForAll(methodObject17835, this, arg0);
      Method var10001 = methodObject17835;
      this.delegate.setACProxy(arg0 instanceof _Proxy_ ? (Object)((_Proxy_)arg0)._getDelegate_() : arg0);
      this.postForAll(var10001);
   }

   public boolean previous() throws SQLException {
      try {
         super.preForAll(methodObject17673, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject17673, this.delegate.previous());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject17673, this.onErrorForAll(methodObject17673, var2));
      }
   }

   public void updateCLOB(int arg0, CLOB arg1) throws SQLException {
      try {
         super.preForAll(methodObject17570, this, arg0, arg1);
         Method var10001 = methodObject17570;
         this.delegate.updateCLOB(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject17570, var4);
      }
   }

   public void updateORAData(String arg0, ORAData arg1) throws SQLException {
      try {
         super.preForAll(methodObject17573, this, arg0, arg1);
         Method var10001 = methodObject17573;
         this.delegate.updateORAData(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject17573, var4);
      }
   }

   public int findColumn(String arg0) throws SQLException {
      try {
         super.preForAll(methodObject17739, this, arg0);
         return (Integer)this.postForAll(methodObject17739, this.delegate.findColumn(arg0));
      } catch (SQLException var3) {
         return (Integer)this.postForAll(methodObject17739, this.onErrorForAll(methodObject17739, var3));
      }
   }

   public void updateTIMESTAMPLTZ(String arg0, TIMESTAMPLTZ arg1) throws SQLException {
      try {
         super.preForAll(methodObject17585, this, arg0, arg1);
         Method var10001 = methodObject17585;
         this.delegate.updateTIMESTAMPLTZ(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject17585, var4);
      }
   }

   public BigDecimal getBigDecimal(String arg0) throws SQLException {
      try {
         super.preForAll(methodObject17744, this, arg0);
         return (BigDecimal)this.postForAll(methodObject17744, (Object)this.delegate.getBigDecimal(arg0));
      } catch (SQLException var3) {
         return (BigDecimal)this.postForAll(methodObject17744, this.onErrorForAll(methodObject17744, var3));
      }
   }

   public boolean getBoolean(String arg0) throws SQLException {
      try {
         super.preForAll(methodObject17651, this, arg0);
         return (Boolean)this.postForAll(methodObject17651, this.delegate.getBoolean(arg0));
      } catch (SQLException var3) {
         return (Boolean)this.postForAll(methodObject17651, this.onErrorForAll(methodObject17651, var3));
      }
   }

   public boolean next() throws SQLException {
      try {
         super.preForAll(methodObject17668, this, zeroLengthObjectArray);
         return this.postForNext(methodObject17668, this.delegate.next());
      } catch (SQLException var2) {
         return this.postForNext(methodObject17668, (Boolean)this.onErrorForAll(methodObject17668, var2));
      }
   }

   public void updateInt(int arg0, int arg1) throws SQLException {
      try {
         super.preForAll(methodObject17803, this, arg0, arg1);
         Method var10001 = methodObject17803;
         this.delegate.updateInt(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject17803, var4);
      }
   }

   public int getType() throws SQLException {
      try {
         super.preForAll(methodObject17672, this, zeroLengthObjectArray);
         return (Integer)this.postForAll(methodObject17672, this.delegate.getType());
      } catch (SQLException var2) {
         return (Integer)this.postForAll(methodObject17672, this.onErrorForAll(methodObject17672, var2));
      }
   }

   public Time getTime(String arg0) throws SQLException {
      try {
         super.preForAll(methodObject17724, this, arg0);
         return (Time)this.postForAll(methodObject17724, (Object)this.delegate.getTime(arg0));
      } catch (SQLException var3) {
         return (Time)this.postForAll(methodObject17724, this.onErrorForAll(methodObject17724, var3));
      }
   }

   public void updateBoolean(String arg0, boolean arg1) throws SQLException {
      try {
         super.preForAll(methodObject17786, this, arg0, arg1);
         Method var10001 = methodObject17786;
         this.delegate.updateBoolean(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject17786, var4);
      }
   }

   public OPAQUE getOPAQUE(String arg0) throws SQLException {
      try {
         super.preForAll(methodObject17623, this, arg0);
         return (OPAQUE)this.postForAll(methodObject17623, (Object)this.delegate.getOPAQUE(arg0));
      } catch (SQLException var3) {
         return (OPAQUE)this.postForAll(methodObject17623, this.onErrorForAll(methodObject17623, var3));
      }
   }

   public void updateINTERVALDS(int arg0, INTERVALDS arg1) throws SQLException {
      try {
         super.preForAll(methodObject17578, this, arg0, arg1);
         Method var10001 = methodObject17578;
         this.delegate.updateINTERVALDS(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject17578, var4);
      }
   }

   public Timestamp getTimestamp(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject17754, this, arg0);
         return (Timestamp)this.postForAll(methodObject17754, (Object)this.delegate.getTimestamp(arg0));
      } catch (SQLException var3) {
         return (Timestamp)this.postForAll(methodObject17754, this.onErrorForAll(methodObject17754, var3));
      }
   }

   public byte[] getBytes(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject17664, this, arg0);
         return (byte[])this.postForAll(methodObject17664, (Object)this.delegate.getBytes(arg0));
      } catch (SQLException var3) {
         return (byte[])this.postForAll(methodObject17664, this.onErrorForAll(methodObject17664, var3));
      }
   }

   public Date getDate(String arg0, Calendar arg1) throws SQLException {
      try {
         super.preForAll(methodObject17681, this, arg0, arg1);
         return (Date)this.postForAll(methodObject17681, (Object)this.delegate.getDate(arg0, arg1));
      } catch (SQLException var4) {
         return (Date)this.postForAll(methodObject17681, this.onErrorForAll(methodObject17681, var4));
      }
   }

   public Object getObject(String arg0, OracleDataFactory arg1) throws SQLException {
      try {
         super.preForAll(methodObject17557, this, arg0, arg1);
         return this.postForAll(methodObject17557, this.proxyFactory.proxyForCreate(this.delegate.getObject(arg0, arg1), this, this.proxyCache, methodObject17557));
      } catch (SQLException var4) {
         return this.postForAll(methodObject17557, this.onErrorForAll(methodObject17557, var4));
      }
   }

   public void updateLong(String arg0, long arg1) throws SQLException {
      try {
         super.preForAll(methodObject17806, this, arg0, arg1);
         Method var10001 = methodObject17806;
         this.delegate.updateLong(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var5) {
         this.onErrorVoidForAll(methodObject17806, var5);
      }
   }

   public ResultSet getCursor(String arg0) throws SQLException {
      try {
         super.preForAll(methodObject17603, this, arg0);
         return (ResultSet)this.postForAll(methodObject17603, this.proxyFactory.proxyForCreate((Object)this.delegate.getCursor(arg0), this, this.proxyCache, methodObject17603));
      } catch (SQLException var3) {
         return (ResultSet)this.postForAll(methodObject17603, this.onErrorForAll(methodObject17603, var3));
      }
   }

   public void updateARRAY(int arg0, ARRAY arg1) throws SQLException {
      try {
         super.preForAll(methodObject17560, this, arg0, arg1);
         Method var10001 = methodObject17560;
         this.delegate.updateARRAY(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject17560, var4);
      }
   }

   public void updateBlob(int arg0, Blob arg1) throws SQLException {
      try {
         super.preForAll(methodObject17779, this, arg0, arg1);
         Method var10001 = methodObject17779;
         this.delegate.updateBlob(arg0, arg1 instanceof _Proxy_ ? (Blob)((_Proxy_)arg1)._getDelegate_() : arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject17779, var4);
      }
   }

   public void updateSQLXML(int arg0, SQLXML arg1) throws SQLException {
      try {
         super.preForAll(methodObject17825, this, arg0, arg1);
         Method var10001 = methodObject17825;
         this.delegate.updateSQLXML(arg0, arg1 instanceof _Proxy_ ? (SQLXML)((_Proxy_)arg1)._getDelegate_() : arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject17825, var4);
      }
   }

   public CLOB getCLOB(String arg0) throws SQLException {
      try {
         super.preForAll(methodObject17613, this, arg0);
         return (CLOB)this.postForAll(methodObject17613, (Object)this.delegate.getCLOB(arg0));
      } catch (SQLException var3) {
         return (CLOB)this.postForAll(methodObject17613, this.onErrorForAll(methodObject17613, var3));
      }
   }

   public INTERVALYM getINTERVALYM(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject17632, this, arg0);
         return (INTERVALYM)this.postForAll(methodObject17632, (Object)this.delegate.getINTERVALYM(arg0));
      } catch (SQLException var3) {
         return (INTERVALYM)this.postForAll(methodObject17632, this.onErrorForAll(methodObject17632, var3));
      }
   }

   public BFILE getBFILE(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject17604, this, arg0);
         return (BFILE)this.postForAll(methodObject17604, (Object)this.delegate.getBFILE(arg0));
      } catch (SQLException var3) {
         return (BFILE)this.postForAll(methodObject17604, this.onErrorForAll(methodObject17604, var3));
      }
   }

   public boolean relative(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject17767, this, arg0);
         return (Boolean)this.postForAll(methodObject17767, this.delegate.relative(arg0));
      } catch (SQLException var3) {
         return (Boolean)this.postForAll(methodObject17767, this.onErrorForAll(methodObject17767, var3));
      }
   }

   public Object unwrap(Class arg0) throws SQLException {
      try {
         super.preForAll(methodObject17833, this, arg0);
         return this.postForAll(methodObject17833, super.unwrap(arg0));
      } catch (SQLException var3) {
         return this.postForAll(methodObject17833, this.onErrorForAll(methodObject17833, var3));
      }
   }

   public void updateClob(int arg0, Clob arg1) throws SQLException {
      try {
         super.preForAll(methodObject17791, this, arg0, arg1);
         Method var10001 = methodObject17791;
         this.delegate.updateClob(arg0, arg1 instanceof _Proxy_ ? (Clob)((_Proxy_)arg1)._getDelegate_() : arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject17791, var4);
      }
   }

   public ORAData getORAData(int arg0, ORADataFactory arg1) throws SQLException {
      try {
         super.preForAll(methodObject17616, this, arg0, arg1);
         return (ORAData)this.postForAll(methodObject17616, (Object)this.delegate.getORAData(arg0, arg1));
      } catch (SQLException var4) {
         return (ORAData)this.postForAll(methodObject17616, this.onErrorForAll(methodObject17616, var4));
      }
   }

   public void updateRowId(int arg0, RowId arg1) throws SQLException {
      try {
         super.preForAll(methodObject17823, this, arg0, arg1);
         Method var10001 = methodObject17823;
         this.delegate.updateRowId(arg0, arg1 instanceof _Proxy_ ? (RowId)((_Proxy_)arg1)._getDelegate_() : arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject17823, var4);
      }
   }

   public InputStream getUnicodeStream(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject17758, this, arg0);
         return (InputStream)this.postForAll(methodObject17758, (Object)this.delegate.getUnicodeStream(arg0));
      } catch (SQLException var3) {
         return (InputStream)this.postForAll(methodObject17758, this.onErrorForAll(methodObject17758, var3));
      }
   }

   public String getNString(String arg0) throws SQLException {
      try {
         super.preForAll(methodObject17752, this, arg0);
         return (String)this.postForAll(methodObject17752, (Object)this.delegate.getNString(arg0));
      } catch (SQLException var3) {
         return (String)this.postForAll(methodObject17752, this.onErrorForAll(methodObject17752, var3));
      }
   }

   public void updateBFILE(int arg0, BFILE arg1) throws SQLException {
      try {
         super.preForAll(methodObject17564, this, arg0, arg1);
         Method var10001 = methodObject17564;
         this.delegate.updateBFILE(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject17564, var4);
      }
   }

   public void updateFloat(String arg0, float arg1) throws SQLException {
      try {
         super.preForAll(methodObject17802, this, arg0, arg1);
         Method var10001 = methodObject17802;
         this.delegate.updateFloat(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject17802, var4);
      }
   }

   public void updateDouble(String arg0, double arg1) throws SQLException {
      try {
         super.preForAll(methodObject17800, this, arg0, arg1);
         Method var10001 = methodObject17800;
         this.delegate.updateDouble(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var5) {
         this.onErrorVoidForAll(methodObject17800, var5);
      }
   }

   public void beforeFirst() throws SQLException {
      try {
         super.preForAll(methodObject17737, this, zeroLengthObjectArray);
         Method var10001 = methodObject17737;
         this.delegate.beforeFirst();
         this.postForAll(var10001);
      } catch (SQLException var2) {
         this.onErrorVoidForAll(methodObject17737, var2);
      }
   }

   public void updateTimestamp(String arg0, Timestamp arg1) throws SQLException {
      try {
         super.preForAll(methodObject17832, this, arg0, arg1);
         Method var10001 = methodObject17832;
         this.delegate.updateTimestamp(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject17832, var4);
      }
   }

   public INTERVALYM getINTERVALYM(String arg0) throws SQLException {
      try {
         super.preForAll(methodObject17633, this, arg0);
         return (INTERVALYM)this.postForAll(methodObject17633, (Object)this.delegate.getINTERVALYM(arg0));
      } catch (SQLException var3) {
         return (INTERVALYM)this.postForAll(methodObject17633, this.onErrorForAll(methodObject17633, var3));
      }
   }

   public int getInt(String arg0) throws SQLException {
      try {
         super.preForAll(methodObject17657, this, arg0);
         return (Integer)this.postForAll(methodObject17657, this.delegate.getInt(arg0));
      } catch (SQLException var3) {
         return (Integer)this.postForAll(methodObject17657, this.onErrorForAll(methodObject17657, var3));
      }
   }

   public NUMBER getNUMBER(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject17620, this, arg0);
         return (NUMBER)this.postForAll(methodObject17620, (Object)this.delegate.getNUMBER(arg0));
      } catch (SQLException var3) {
         return (NUMBER)this.postForAll(methodObject17620, this.onErrorForAll(methodObject17620, var3));
      }
   }

   public void updateCharacterStream(String arg0, Reader arg1) throws SQLException {
      try {
         super.preForUpdateStreams(methodObject17702, this, arg0, arg1);
         Method var10001 = methodObject17702;
         this.delegate.updateCharacterStream(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject17702, var4);
      }
   }

   public void deleteRow() throws SQLException {
      try {
         super.preForRowUpdates(methodObject17682, this, zeroLengthObjectArray);
         Method var10001 = methodObject17682;
         this.delegate.deleteRow();
         this.postForAll(var10001);
      } catch (SQLException var2) {
         this.onErrorVoidForAll(methodObject17682, var2);
      }
   }

   public void updateNString(String arg0, String arg1) throws SQLException {
      try {
         super.preForAll(methodObject17814, this, arg0, arg1);
         Method var10001 = methodObject17814;
         this.delegate.updateNString(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject17814, var4);
      }
   }

   public void updateTIMESTAMPLTZ(int arg0, TIMESTAMPLTZ arg1) throws SQLException {
      try {
         super.preForAll(methodObject17584, this, arg0, arg1);
         Method var10001 = methodObject17584;
         this.delegate.updateTIMESTAMPLTZ(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject17584, var4);
      }
   }

   public void updateARRAY(String arg0, ARRAY arg1) throws SQLException {
      try {
         super.preForAll(methodObject17561, this, arg0, arg1);
         Method var10001 = methodObject17561;
         this.delegate.updateARRAY(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject17561, var4);
      }
   }

   public InputStream getBinaryStream(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject17709, this, arg0);
         return (InputStream)this.postForAll(methodObject17709, (Object)this.delegate.getBinaryStream(arg0));
      } catch (SQLException var3) {
         return (InputStream)this.postForAll(methodObject17709, this.onErrorForAll(methodObject17709, var3));
      }
   }

   public void updateNClob(String arg0, Reader arg1) throws SQLException {
      try {
         super.preForAll(methodObject17812, this, arg0, arg1);
         Method var10001 = methodObject17812;
         this.delegate.updateNClob(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject17812, var4);
      }
   }

   public Datum getOracleObject(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject17600, this, arg0);
         return (Datum)this.postForAll(methodObject17600, (Object)this.delegate.getOracleObject(arg0));
      } catch (SQLException var3) {
         return (Datum)this.postForAll(methodObject17600, this.onErrorForAll(methodObject17600, var3));
      }
   }

   public void updateNCharacterStream(int arg0, Reader arg1) throws SQLException {
      try {
         super.preForUpdateStreams(methodObject17705, this, arg0, arg1);
         Method var10001 = methodObject17705;
         this.delegate.updateNCharacterStream(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject17705, var4);
      }
   }

   public TIMESTAMPLTZ getTIMESTAMPLTZ(String arg0) throws SQLException {
      try {
         super.preForAll(methodObject17641, this, arg0);
         return (TIMESTAMPLTZ)this.postForAll(methodObject17641, (Object)this.delegate.getTIMESTAMPLTZ(arg0));
      } catch (SQLException var3) {
         return (TIMESTAMPLTZ)this.postForAll(methodObject17641, this.onErrorForAll(methodObject17641, var3));
      }
   }

   public boolean first() throws SQLException {
      try {
         super.preForAll(methodObject17740, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject17740, this.delegate.first());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject17740, this.onErrorForAll(methodObject17740, var2));
      }
   }

   public BLOB getBLOB(String arg0) throws SQLException {
      try {
         super.preForAll(methodObject17609, this, arg0);
         return (BLOB)this.postForAll(methodObject17609, (Object)this.delegate.getBLOB(arg0));
      } catch (SQLException var3) {
         return (BLOB)this.postForAll(methodObject17609, this.onErrorForAll(methodObject17609, var3));
      }
   }

   public BLOB getBLOB(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject17608, this, arg0);
         return (BLOB)this.postForAll(methodObject17608, (Object)this.delegate.getBLOB(arg0));
      } catch (SQLException var3) {
         return (BLOB)this.postForAll(methodObject17608, this.onErrorForAll(methodObject17608, var3));
      }
   }

   public void updateByte(String arg0, byte arg1) throws SQLException {
      try {
         super.preForAll(methodObject17788, this, arg0, arg1);
         Method var10001 = methodObject17788;
         this.delegate.updateByte(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject17788, var4);
      }
   }

   public DATE getDATE(String arg0) throws SQLException {
      try {
         super.preForAll(methodObject17619, this, arg0);
         return (DATE)this.postForAll(methodObject17619, (Object)this.delegate.getDATE(arg0));
      } catch (SQLException var3) {
         return (DATE)this.postForAll(methodObject17619, this.onErrorForAll(methodObject17619, var3));
      }
   }

   public void updateCharacterStream(int arg0, Reader arg1, long arg2) throws SQLException {
      try {
         super.preForUpdateStreams(methodObject17699, this, arg0, arg1, arg2);
         Method var10001 = methodObject17699;
         this.delegate.updateCharacterStream(arg0, arg1, arg2);
         this.postForAll(var10001);
      } catch (SQLException var6) {
         this.onErrorVoidForAll(methodObject17699, var6);
      }
   }

   public RAW getRAW(String arg0) throws SQLException {
      try {
         super.preForAll(methodObject17625, this, arg0);
         return (RAW)this.postForAll(methodObject17625, (Object)this.delegate.getRAW(arg0));
      } catch (SQLException var3) {
         return (RAW)this.postForAll(methodObject17625, this.onErrorForAll(methodObject17625, var3));
      }
   }

   public CHAR getCHAR(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject17610, this, arg0);
         return (CHAR)this.postForAll(methodObject17610, (Object)this.delegate.getCHAR(arg0));
      } catch (SQLException var3) {
         return (CHAR)this.postForAll(methodObject17610, this.onErrorForAll(methodObject17610, var3));
      }
   }

   public void updateBfile(String arg0, BFILE arg1) throws SQLException {
      try {
         super.preForAll(methodObject17563, this, arg0, arg1);
         Method var10001 = methodObject17563;
         this.delegate.updateBfile(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject17563, var4);
      }
   }

   public void updateBLOB(String arg0, BLOB arg1) throws SQLException {
      try {
         super.preForAll(methodObject17567, this, arg0, arg1);
         Method var10001 = methodObject17567;
         this.delegate.updateBLOB(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject17567, var4);
      }
   }

   public void updateBlob(String arg0, InputStream arg1) throws SQLException {
      try {
         super.preForAll(methodObject17784, this, arg0, arg1);
         Method var10001 = methodObject17784;
         this.delegate.updateBlob(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject17784, var4);
      }
   }

   public void updateNString(int arg0, String arg1) throws SQLException {
      try {
         super.preForAll(methodObject17813, this, arg0, arg1);
         Method var10001 = methodObject17813;
         this.delegate.updateNString(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject17813, var4);
      }
   }

   public void updateObject(int arg0, Object arg1, int arg2) throws SQLException {
      try {
         super.preForAll(methodObject17817, this, arg0, arg1, arg2);
         Method var10001 = methodObject17817;
         this.delegate.updateObject(arg0, arg1 instanceof _Proxy_ ? (Object)((_Proxy_)arg1)._getDelegate_() : arg1, arg2);
         this.postForAll(var10001);
      } catch (SQLException var5) {
         this.onErrorVoidForAll(methodObject17817, var5);
      }
   }

   public void updateINTERVALYM(String arg0, INTERVALYM arg1) throws SQLException {
      try {
         super.preForAll(methodObject17577, this, arg0, arg1);
         Method var10001 = methodObject17577;
         this.delegate.updateINTERVALYM(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject17577, var4);
      }
   }

   public void updateBinaryStream(String arg0, InputStream arg1, int arg2) throws SQLException {
      try {
         super.preForUpdateStreams(methodObject17692, this, arg0, arg1, arg2);
         Method var10001 = methodObject17692;
         this.delegate.updateBinaryStream(arg0, arg1, arg2);
         this.postForAll(var10001);
      } catch (SQLException var5) {
         this.onErrorVoidForAll(methodObject17692, var5);
      }
   }

   public Time getTime(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject17723, this, arg0);
         return (Time)this.postForAll(methodObject17723, (Object)this.delegate.getTime(arg0));
      } catch (SQLException var3) {
         return (Time)this.postForAll(methodObject17723, this.onErrorForAll(methodObject17723, var3));
      }
   }

   public void moveToInsertRow() throws SQLException {
      try {
         super.preForAll(methodObject17765, this, zeroLengthObjectArray);
         Method var10001 = methodObject17765;
         this.delegate.moveToInsertRow();
         this.postForAll(var10001);
      } catch (SQLException var2) {
         this.onErrorVoidForAll(methodObject17765, var2);
      }
   }

   public void updateNClob(int arg0, Reader arg1, long arg2) throws SQLException {
      try {
         super.preForAll(methodObject17809, this, arg0, arg1, arg2);
         Method var10001 = methodObject17809;
         this.delegate.updateNClob(arg0, arg1, arg2);
         this.postForAll(var10001);
      } catch (SQLException var6) {
         this.onErrorVoidForAll(methodObject17809, var6);
      }
   }

   public void updateDate(String arg0, Date arg1) throws SQLException {
      try {
         super.preForAll(methodObject17798, this, arg0, arg1);
         Method var10001 = methodObject17798;
         this.delegate.updateDate(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject17798, var4);
      }
   }

   public void updateTIMESTAMP(int arg0, TIMESTAMP arg1) throws SQLException {
      try {
         super.preForAll(methodObject17580, this, arg0, arg1);
         Method var10001 = methodObject17580;
         this.delegate.updateTIMESTAMP(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject17580, var4);
      }
   }

   public void updateNCharacterStream(int arg0, Reader arg1, long arg2) throws SQLException {
      try {
         super.preForUpdateStreams(methodObject17703, this, arg0, arg1, arg2);
         Method var10001 = methodObject17703;
         this.delegate.updateNCharacterStream(arg0, arg1, arg2);
         this.postForAll(var10001);
      } catch (SQLException var6) {
         this.onErrorVoidForAll(methodObject17703, var6);
      }
   }

   public void cancelRowUpdates() throws SQLException {
      try {
         super.preForAll(methodObject17738, this, zeroLengthObjectArray);
         Method var10001 = methodObject17738;
         this.delegate.cancelRowUpdates();
         this.postForAll(var10001);
      } catch (SQLException var2) {
         this.onErrorVoidForAll(methodObject17738, var2);
      }
   }

   public Object getObject(String arg0) throws SQLException {
      try {
         super.preForAll(methodObject17645, this, arg0);
         return this.postForAll(methodObject17645, this.proxyFactory.proxyForCreate(this.delegate.getObject(arg0), this, this.proxyCache, methodObject17645));
      } catch (SQLException var3) {
         return this.postForAll(methodObject17645, this.onErrorForAll(methodObject17645, var3));
      }
   }

   public int getHoldability() throws SQLException {
      try {
         super.preForAll(methodObject17729, this, zeroLengthObjectArray);
         return (Integer)this.postForAll(methodObject17729, this.delegate.getHoldability());
      } catch (SQLException var2) {
         return (Integer)this.postForAll(methodObject17729, this.onErrorForAll(methodObject17729, var2));
      }
   }

   public ROWID getROWID(String arg0) throws SQLException {
      try {
         super.preForAll(methodObject17629, this, arg0);
         return (ROWID)this.postForAll(methodObject17629, (Object)this.delegate.getROWID(arg0));
      } catch (SQLException var3) {
         return (ROWID)this.postForAll(methodObject17629, this.onErrorForAll(methodObject17629, var3));
      }
   }

   public void updateLong(int arg0, long arg1) throws SQLException {
      try {
         super.preForAll(methodObject17805, this, arg0, arg1);
         Method var10001 = methodObject17805;
         this.delegate.updateLong(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var5) {
         this.onErrorVoidForAll(methodObject17805, var5);
      }
   }

   public ORAData getORAData(String arg0, ORADataFactory arg1) throws SQLException {
      try {
         super.preForAll(methodObject17617, this, arg0, arg1);
         return (ORAData)this.postForAll(methodObject17617, (Object)this.delegate.getORAData(arg0, arg1));
      } catch (SQLException var4) {
         return (ORAData)this.postForAll(methodObject17617, this.onErrorForAll(methodObject17617, var4));
      }
   }

   public void updateBinaryStream(String arg0, InputStream arg1) throws SQLException {
      try {
         super.preForUpdateStreams(methodObject17696, this, arg0, arg1);
         Method var10001 = methodObject17696;
         this.delegate.updateBinaryStream(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject17696, var4);
      }
   }

   public boolean getBoolean(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject17650, this, arg0);
         return (Boolean)this.postForAll(methodObject17650, this.delegate.getBoolean(arg0));
      } catch (SQLException var3) {
         return (Boolean)this.postForAll(methodObject17650, this.onErrorForAll(methodObject17650, var3));
      }
   }

   public BigDecimal getBigDecimal(int arg0, int arg1) throws SQLException {
      try {
         super.preForAll(methodObject17741, this, arg0, arg1);
         return (BigDecimal)this.postForAll(methodObject17741, (Object)this.delegate.getBigDecimal(arg0, arg1));
      } catch (SQLException var4) {
         return (BigDecimal)this.postForAll(methodObject17741, this.onErrorForAll(methodObject17741, var4));
      }
   }

   public BigDecimal getBigDecimal(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject17743, this, arg0);
         return (BigDecimal)this.postForAll(methodObject17743, (Object)this.delegate.getBigDecimal(arg0));
      } catch (SQLException var3) {
         return (BigDecimal)this.postForAll(methodObject17743, this.onErrorForAll(methodObject17743, var3));
      }
   }

   public void updateAsciiStream(String arg0, InputStream arg1, long arg2) throws SQLException {
      try {
         super.preForUpdateStreams(methodObject17688, this, arg0, arg1, arg2);
         Method var10001 = methodObject17688;
         this.delegate.updateAsciiStream(arg0, arg1, arg2);
         this.postForAll(var10001);
      } catch (SQLException var6) {
         this.onErrorVoidForAll(methodObject17688, var6);
      }
   }

   public void updateDATE(String arg0, DATE arg1) throws SQLException {
      try {
         super.preForAll(methodObject17575, this, arg0, arg1);
         Method var10001 = methodObject17575;
         this.delegate.updateDATE(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject17575, var4);
      }
   }

   public TIMESTAMP getTIMESTAMP(String arg0) throws SQLException {
      try {
         super.preForAll(methodObject17637, this, arg0);
         return (TIMESTAMP)this.postForAll(methodObject17637, (Object)this.delegate.getTIMESTAMP(arg0));
      } catch (SQLException var3) {
         return (TIMESTAMP)this.postForAll(methodObject17637, this.onErrorForAll(methodObject17637, var3));
      }
   }

   public void updateShort(int arg0, short arg1) throws SQLException {
      try {
         super.preForAll(methodObject17827, this, arg0, arg1);
         Method var10001 = methodObject17827;
         this.delegate.updateShort(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject17827, var4);
      }
   }

   public void closeStatementOnClose() throws SQLException {
      try {
         super.preForAll(methodObject17555, this, zeroLengthObjectArray);
         Method var10001 = methodObject17555;
         this.delegate.closeStatementOnClose();
         this.postForAll(var10001);
      } catch (SQLException var2) {
         this.onErrorVoidForAll(methodObject17555, var2);
      }
   }

   public short getShort(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject17654, this, arg0);
         return (Short)this.postForAll(methodObject17654, this.delegate.getShort(arg0));
      } catch (SQLException var3) {
         return (Short)this.postForAll(methodObject17654, this.onErrorForAll(methodObject17654, var3));
      }
   }

   public Ref getRef(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject17674, this, arg0);
         return (Ref)this.postForAll(methodObject17674, this.proxyFactory.proxyForCreate((Object)this.delegate.getRef(arg0), this, this.proxyCache, methodObject17674));
      } catch (SQLException var3) {
         return (Ref)this.postForAll(methodObject17674, this.onErrorForAll(methodObject17674, var3));
      }
   }

   public BFILE getBFILE(String arg0) throws SQLException {
      try {
         super.preForAll(methodObject17605, this, arg0);
         return (BFILE)this.postForAll(methodObject17605, (Object)this.delegate.getBFILE(arg0));
      } catch (SQLException var3) {
         return (BFILE)this.postForAll(methodObject17605, this.onErrorForAll(methodObject17605, var3));
      }
   }

   public void updateRAW(int arg0, RAW arg1) throws SQLException {
      try {
         super.preForAll(methodObject17590, this, arg0, arg1);
         Method var10001 = methodObject17590;
         this.delegate.updateRAW(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject17590, var4);
      }
   }

   public Date getDate(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject17678, this, arg0);
         return (Date)this.postForAll(methodObject17678, (Object)this.delegate.getDate(arg0));
      } catch (SQLException var3) {
         return (Date)this.postForAll(methodObject17678, this.onErrorForAll(methodObject17678, var3));
      }
   }

   public Blob getBlob(String arg0) throws SQLException {
      try {
         super.preForAll(methodObject17714, this, arg0);
         return (Blob)this.postForAll(methodObject17714, this.proxyFactory.proxyForCreate((Object)this.delegate.getBlob(arg0), this, this.proxyCache, methodObject17714));
      } catch (SQLException var3) {
         return (Blob)this.postForAll(methodObject17714, this.onErrorForAll(methodObject17714, var3));
      }
   }

   public void updateShort(String arg0, short arg1) throws SQLException {
      try {
         super.preForAll(methodObject17828, this, arg0, arg1);
         Method var10001 = methodObject17828;
         this.delegate.updateShort(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject17828, var4);
      }
   }

   public void updateNClob(String arg0, NClob arg1) throws SQLException {
      try {
         super.preForAll(methodObject17808, this, arg0, arg1);
         Method var10001 = methodObject17808;
         this.delegate.updateNClob(arg0, arg1 instanceof _Proxy_ ? (NClob)((_Proxy_)arg1)._getDelegate_() : arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject17808, var4);
      }
   }

   public Object getObject(int arg0, Map arg1) throws SQLException {
      try {
         super.preForAll(methodObject17646, this, arg0, arg1);
         return this.postForAll(methodObject17646, this.proxyFactory.proxyForCreate(this.delegate.getObject(arg0, arg1), this, this.proxyCache, methodObject17646));
      } catch (SQLException var4) {
         return this.postForAll(methodObject17646, this.onErrorForAll(methodObject17646, var4));
      }
   }

   public void updateBlob(String arg0, Blob arg1) throws SQLException {
      try {
         super.preForAll(methodObject17780, this, arg0, arg1);
         Method var10001 = methodObject17780;
         this.delegate.updateBlob(arg0, arg1 instanceof _Proxy_ ? (Blob)((_Proxy_)arg1)._getDelegate_() : arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject17780, var4);
      }
   }

   public Date getDate(int arg0, Calendar arg1) throws SQLException {
      try {
         super.preForAll(methodObject17680, this, arg0, arg1);
         return (Date)this.postForAll(methodObject17680, (Object)this.delegate.getDate(arg0, arg1));
      } catch (SQLException var4) {
         return (Date)this.postForAll(methodObject17680, this.onErrorForAll(methodObject17680, var4));
      }
   }

   public REF getREF(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject17626, this, arg0);
         return (REF)this.postForAll(methodObject17626, (Object)this.delegate.getREF(arg0));
      } catch (SQLException var3) {
         return (REF)this.postForAll(methodObject17626, this.onErrorForAll(methodObject17626, var3));
      }
   }

   public boolean rowDeleted() throws SQLException {
      try {
         super.preForAll(methodObject17768, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject17768, this.delegate.rowDeleted());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject17768, this.onErrorForAll(methodObject17768, var2));
      }
   }

   public TIMESTAMPTZ getTIMESTAMPTZ(String arg0) throws SQLException {
      try {
         super.preForAll(methodObject17639, this, arg0);
         return (TIMESTAMPTZ)this.postForAll(methodObject17639, (Object)this.delegate.getTIMESTAMPTZ(arg0));
      } catch (SQLException var3) {
         return (TIMESTAMPTZ)this.postForAll(methodObject17639, this.onErrorForAll(methodObject17639, var3));
      }
   }

   public void updateString(int arg0, String arg1) throws SQLException {
      try {
         super.preForAll(methodObject17829, this, arg0, arg1);
         Method var10001 = methodObject17829;
         this.delegate.updateString(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject17829, var4);
      }
   }

   public void afterLast() throws SQLException {
      try {
         super.preForAll(methodObject17774, this, zeroLengthObjectArray);
         Method var10001 = methodObject17774;
         this.delegate.afterLast();
         this.postForAll(var10001);
      } catch (SQLException var2) {
         this.onErrorVoidForAll(methodObject17774, var2);
      }
   }

   public void updateCustomDatum(int arg0, CustomDatum arg1) throws SQLException {
      try {
         super.preForAll(methodObject17558, this, arg0, arg1);
         Method var10001 = methodObject17558;
         this.delegate.updateCustomDatum(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject17558, var4);
      }
   }

   public void updateClob(int arg0, Reader arg1) throws SQLException {
      try {
         super.preForAll(methodObject17795, this, arg0, arg1);
         Method var10001 = methodObject17795;
         this.delegate.updateClob(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject17795, var4);
      }
   }

   public void updateArray(int arg0, Array arg1) throws SQLException {
      try {
         super.preForAll(methodObject17775, this, arg0, arg1);
         Method var10001 = methodObject17775;
         this.delegate.updateArray(arg0, arg1 instanceof _Proxy_ ? (Array)((_Proxy_)arg1)._getDelegate_() : arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject17775, var4);
      }
   }

   public void updateREF(String arg0, REF arg1) throws SQLException {
      try {
         super.preForAll(methodObject17593, this, arg0, arg1);
         Method var10001 = methodObject17593;
         this.delegate.updateREF(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject17593, var4);
      }
   }

   public URL getURL(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject17669, this, arg0);
         return (URL)this.postForAll(methodObject17669, (Object)this.delegate.getURL(arg0));
      } catch (SQLException var3) {
         return (URL)this.postForAll(methodObject17669, this.onErrorForAll(methodObject17669, var3));
      }
   }

   public Array getArray(String arg0) throws SQLException {
      try {
         super.preForAll(methodObject17667, this, arg0);
         return (Array)this.postForAll(methodObject17667, this.proxyFactory.proxyForCreate((Object)this.delegate.getArray(arg0), this, this.proxyCache, methodObject17667));
      } catch (SQLException var3) {
         return (Array)this.postForAll(methodObject17667, this.onErrorForAll(methodObject17667, var3));
      }
   }

   public Statement getStatement() throws SQLException {
      try {
         super.preForAll(methodObject17708, this, zeroLengthObjectArray);
         return (Statement)this.postForAll(methodObject17708, (Object)super.getStatement());
      } catch (SQLException var2) {
         return (Statement)this.postForAll(methodObject17708, this.onErrorForAll(methodObject17708, var2));
      }
   }

   public SQLWarning getWarnings() throws SQLException {
      try {
         super.preForAll(methodObject17727, this, zeroLengthObjectArray);
         return (SQLWarning)this.postForAll(methodObject17727, (Object)this.delegate.getWarnings());
      } catch (SQLException var2) {
         return (SQLWarning)this.postForAll(methodObject17727, this.onErrorForAll(methodObject17727, var2));
      }
   }

   public void updateBLOB(int arg0, BLOB arg1) throws SQLException {
      try {
         super.preForAll(methodObject17566, this, arg0, arg1);
         Method var10001 = methodObject17566;
         this.delegate.updateBLOB(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject17566, var4);
      }
   }

   public Reader getCharacterStream(String arg0) throws SQLException {
      try {
         super.preForAll(methodObject17735, this, arg0);
         return (Reader)this.postForAll(methodObject17735, (Object)this.delegate.getCharacterStream(arg0));
      } catch (SQLException var3) {
         return (Reader)this.postForAll(methodObject17735, this.onErrorForAll(methodObject17735, var3));
      }
   }

   public void updateROWID(int arg0, ROWID arg1) throws SQLException {
      try {
         super.preForAll(methodObject17594, this, arg0, arg1);
         Method var10001 = methodObject17594;
         this.delegate.updateROWID(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject17594, var4);
      }
   }

   public byte getByte(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject17652, this, arg0);
         return (Byte)this.postForAll(methodObject17652, this.delegate.getByte(arg0));
      } catch (SQLException var3) {
         return (Byte)this.postForAll(methodObject17652, this.onErrorForAll(methodObject17652, var3));
      }
   }

   public DATE getDATE(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject17618, this, arg0);
         return (DATE)this.postForAll(methodObject17618, (Object)this.delegate.getDATE(arg0));
      } catch (SQLException var3) {
         return (DATE)this.postForAll(methodObject17618, this.onErrorForAll(methodObject17618, var3));
      }
   }

   public CLOB getCLOB(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject17612, this, arg0);
         return (CLOB)this.postForAll(methodObject17612, (Object)this.delegate.getCLOB(arg0));
      } catch (SQLException var3) {
         return (CLOB)this.postForAll(methodObject17612, this.onErrorForAll(methodObject17612, var3));
      }
   }

   public ARRAY getARRAY(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject17642, this, arg0);
         return (ARRAY)this.postForAll(methodObject17642, (Object)this.delegate.getARRAY(arg0));
      } catch (SQLException var3) {
         return (ARRAY)this.postForAll(methodObject17642, this.onErrorForAll(methodObject17642, var3));
      }
   }

   public BFILE getBfile(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject17606, this, arg0);
         return (BFILE)this.postForAll(methodObject17606, (Object)this.delegate.getBfile(arg0));
      } catch (SQLException var3) {
         return (BFILE)this.postForAll(methodObject17606, this.onErrorForAll(methodObject17606, var3));
      }
   }

   public Timestamp getTimestamp(String arg0, Calendar arg1) throws SQLException {
      try {
         super.preForAll(methodObject17757, this, arg0, arg1);
         return (Timestamp)this.postForAll(methodObject17757, (Object)this.delegate.getTimestamp(arg0, arg1));
      } catch (SQLException var4) {
         return (Timestamp)this.postForAll(methodObject17757, this.onErrorForAll(methodObject17757, var4));
      }
   }

   public long getLong(String arg0) throws SQLException {
      try {
         super.preForAll(methodObject17659, this, arg0);
         return (Long)this.postForAll(methodObject17659, this.delegate.getLong(arg0));
      } catch (SQLException var3) {
         return (Long)this.postForAll(methodObject17659, this.onErrorForAll(methodObject17659, var3));
      }
   }

   public Clob getClob(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject17715, this, arg0);
         return (Clob)this.postForAll(methodObject17715, this.proxyFactory.proxyForCreate((Object)this.delegate.getClob(arg0), this, this.proxyCache, methodObject17715));
      } catch (SQLException var3) {
         return (Clob)this.postForAll(methodObject17715, this.onErrorForAll(methodObject17715, var3));
      }
   }

   public void updateBigDecimal(int arg0, BigDecimal arg1) throws SQLException {
      try {
         super.preForAll(methodObject17777, this, arg0, arg1);
         Method var10001 = methodObject17777;
         this.delegate.updateBigDecimal(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject17777, var4);
      }
   }

   public ROWID getROWID(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject17628, this, arg0);
         return (ROWID)this.postForAll(methodObject17628, (Object)this.delegate.getROWID(arg0));
      } catch (SQLException var3) {
         return (ROWID)this.postForAll(methodObject17628, this.onErrorForAll(methodObject17628, var3));
      }
   }

   public void updateBlob(String arg0, InputStream arg1, long arg2) throws SQLException {
      try {
         super.preForAll(methodObject17782, this, arg0, arg1, arg2);
         Method var10001 = methodObject17782;
         this.delegate.updateBlob(arg0, arg1, arg2);
         this.postForAll(var10001);
      } catch (SQLException var6) {
         this.onErrorVoidForAll(methodObject17782, var6);
      }
   }

   public String getCursorName() throws SQLException {
      try {
         super.preForAll(methodObject17746, this, zeroLengthObjectArray);
         return (String)this.postForAll(methodObject17746, (Object)this.delegate.getCursorName());
      } catch (SQLException var2) {
         return (String)this.postForAll(methodObject17746, this.onErrorForAll(methodObject17746, var2));
      }
   }

   public void close() throws SQLException {
      try {
         super.preForAll(methodObject17671, this, zeroLengthObjectArray);
         Method var10001 = methodObject17671;
         this.delegate.close();
         this.postForClose(var10001);
      } catch (SQLException var2) {
         this.onErrorVoidForAll(methodObject17671, var2);
      }
   }

   public void updateBinaryStream(String arg0, InputStream arg1, long arg2) throws SQLException {
      try {
         super.preForUpdateStreams(methodObject17694, this, arg0, arg1, arg2);
         Method var10001 = methodObject17694;
         this.delegate.updateBinaryStream(arg0, arg1, arg2);
         this.postForAll(var10001);
      } catch (SQLException var6) {
         this.onErrorVoidForAll(methodObject17694, var6);
      }
   }

   public ResultSet getCursor(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject17602, this, arg0);
         return (ResultSet)this.postForAll(methodObject17602, this.proxyFactory.proxyForCreate((Object)this.delegate.getCursor(arg0), this, this.proxyCache, methodObject17602));
      } catch (SQLException var3) {
         return (ResultSet)this.postForAll(methodObject17602, this.onErrorForAll(methodObject17602, var3));
      }
   }

   public double getDouble(String arg0) throws SQLException {
      try {
         super.preForAll(methodObject17663, this, arg0);
         return (Double)this.postForAll(methodObject17663, this.delegate.getDouble(arg0));
      } catch (SQLException var3) {
         return (Double)this.postForAll(methodObject17663, this.onErrorForAll(methodObject17663, var3));
      }
   }

   public Object getObject(int arg0, Class arg1) throws SQLException {
      try {
         super.preForAll(methodObject17648, this, arg0, arg1);
         return this.postForAll(methodObject17648, this.proxyFactory.proxyForCreate(this.delegate.getObject(arg0, arg1), this, this.proxyCache, methodObject17648));
      } catch (SQLException var4) {
         return this.postForAll(methodObject17648, this.onErrorForAll(methodObject17648, var4));
      }
   }

   public void updateRef(String arg0, Ref arg1) throws SQLException {
      try {
         super.preForAll(methodObject17822, this, arg0, arg1);
         Method var10001 = methodObject17822;
         this.delegate.updateRef(arg0, arg1 instanceof _Proxy_ ? (Ref)((_Proxy_)arg1)._getDelegate_() : arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject17822, var4);
      }
   }

   public boolean absolute(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject17773, this, arg0);
         return (Boolean)this.postForAll(methodObject17773, this.delegate.absolute(arg0));
      } catch (SQLException var3) {
         return (Boolean)this.postForAll(methodObject17773, this.onErrorForAll(methodObject17773, var3));
      }
   }

   public Timestamp getTimestamp(int arg0, Calendar arg1) throws SQLException {
      try {
         super.preForAll(methodObject17756, this, arg0, arg1);
         return (Timestamp)this.postForAll(methodObject17756, (Object)this.delegate.getTimestamp(arg0, arg1));
      } catch (SQLException var4) {
         return (Timestamp)this.postForAll(methodObject17756, this.onErrorForAll(methodObject17756, var4));
      }
   }

   public InputStream getAsciiStream(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject17732, this, arg0);
         return (InputStream)this.postForAll(methodObject17732, (Object)this.delegate.getAsciiStream(arg0));
      } catch (SQLException var3) {
         return (InputStream)this.postForAll(methodObject17732, this.onErrorForAll(methodObject17732, var3));
      }
   }

   public RAW getRAW(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject17624, this, arg0);
         return (RAW)this.postForAll(methodObject17624, (Object)this.delegate.getRAW(arg0));
      } catch (SQLException var3) {
         return (RAW)this.postForAll(methodObject17624, this.onErrorForAll(methodObject17624, var3));
      }
   }

   public void updateBoolean(int arg0, boolean arg1) throws SQLException {
      try {
         super.preForAll(methodObject17785, this, arg0, arg1);
         Method var10001 = methodObject17785;
         this.delegate.updateBoolean(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject17785, var4);
      }
   }

   public NClob getNClob(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject17717, this, arg0);
         return (NClob)this.postForAll(methodObject17717, this.proxyFactory.proxyForCreate((Object)this.delegate.getNClob(arg0), this, this.proxyCache, methodObject17717));
      } catch (SQLException var3) {
         return (NClob)this.postForAll(methodObject17717, this.onErrorForAll(methodObject17717, var3));
      }
   }

   public void updateBinaryStream(int arg0, InputStream arg1, int arg2) throws SQLException {
      try {
         super.preForUpdateStreams(methodObject17691, this, arg0, arg1, arg2);
         Method var10001 = methodObject17691;
         this.delegate.updateBinaryStream(arg0, arg1, arg2);
         this.postForAll(var10001);
      } catch (SQLException var5) {
         this.onErrorVoidForAll(methodObject17691, var5);
      }
   }

   public byte getByte(String arg0) throws SQLException {
      try {
         super.preForAll(methodObject17653, this, arg0);
         return (Byte)this.postForAll(methodObject17653, this.delegate.getByte(arg0));
      } catch (SQLException var3) {
         return (Byte)this.postForAll(methodObject17653, this.onErrorForAll(methodObject17653, var3));
      }
   }

   public void updateAsciiStream(String arg0, InputStream arg1) throws SQLException {
      try {
         super.preForUpdateStreams(methodObject17690, this, arg0, arg1);
         Method var10001 = methodObject17690;
         this.delegate.updateAsciiStream(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject17690, var4);
      }
   }

   public void updateSQLXML(String arg0, SQLXML arg1) throws SQLException {
      try {
         super.preForAll(methodObject17826, this, arg0, arg1);
         Method var10001 = methodObject17826;
         this.delegate.updateSQLXML(arg0, arg1 instanceof _Proxy_ ? (SQLXML)((_Proxy_)arg1)._getDelegate_() : arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject17826, var4);
      }
   }

   public void updateCLOB(String arg0, CLOB arg1) throws SQLException {
      try {
         super.preForAll(methodObject17571, this, arg0, arg1);
         Method var10001 = methodObject17571;
         this.delegate.updateCLOB(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject17571, var4);
      }
   }

   public Array getArray(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject17666, this, arg0);
         return (Array)this.postForAll(methodObject17666, this.proxyFactory.proxyForCreate((Object)this.delegate.getArray(arg0), this, this.proxyCache, methodObject17666));
      } catch (SQLException var3) {
         return (Array)this.postForAll(methodObject17666, this.onErrorForAll(methodObject17666, var3));
      }
   }

   public void updateCharacterStream(String arg0, Reader arg1, int arg2) throws SQLException {
      try {
         super.preForUpdateStreams(methodObject17698, this, arg0, arg1, arg2);
         Method var10001 = methodObject17698;
         this.delegate.updateCharacterStream(arg0, arg1, arg2);
         this.postForAll(var10001);
      } catch (SQLException var5) {
         this.onErrorVoidForAll(methodObject17698, var5);
      }
   }

   public Timestamp getTimestamp(String arg0) throws SQLException {
      try {
         super.preForAll(methodObject17755, this, arg0);
         return (Timestamp)this.postForAll(methodObject17755, (Object)this.delegate.getTimestamp(arg0));
      } catch (SQLException var3) {
         return (Timestamp)this.postForAll(methodObject17755, this.onErrorForAll(methodObject17755, var3));
      }
   }

   public void updateAsciiStream(int arg0, InputStream arg1) throws SQLException {
      try {
         super.preForUpdateStreams(methodObject17689, this, arg0, arg1);
         Method var10001 = methodObject17689;
         this.delegate.updateAsciiStream(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject17689, var4);
      }
   }

   public STRUCT getSTRUCT(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject17630, this, arg0);
         return (STRUCT)this.postForAll(methodObject17630, (Object)this.delegate.getSTRUCT(arg0));
      } catch (SQLException var3) {
         return (STRUCT)this.postForAll(methodObject17630, this.onErrorForAll(methodObject17630, var3));
      }
   }

   public Clob getClob(String arg0) throws SQLException {
      try {
         super.preForAll(methodObject17716, this, arg0);
         return (Clob)this.postForAll(methodObject17716, this.proxyFactory.proxyForCreate((Object)this.delegate.getClob(arg0), this, this.proxyCache, methodObject17716));
      } catch (SQLException var3) {
         return (Clob)this.postForAll(methodObject17716, this.onErrorForAll(methodObject17716, var3));
      }
   }

   public void updateClob(String arg0, Clob arg1) throws SQLException {
      try {
         super.preForAll(methodObject17792, this, arg0, arg1);
         Method var10001 = methodObject17792;
         this.delegate.updateClob(arg0, arg1 instanceof _Proxy_ ? (Clob)((_Proxy_)arg1)._getDelegate_() : arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject17792, var4);
      }
   }

   public TIMESTAMPLTZ getTIMESTAMPLTZ(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject17640, this, arg0);
         return (TIMESTAMPLTZ)this.postForAll(methodObject17640, (Object)this.delegate.getTIMESTAMPLTZ(arg0));
      } catch (SQLException var3) {
         return (TIMESTAMPLTZ)this.postForAll(methodObject17640, this.onErrorForAll(methodObject17640, var3));
      }
   }

   public void updateAsciiStream(int arg0, InputStream arg1, int arg2) throws SQLException {
      try {
         super.preForUpdateStreams(methodObject17685, this, arg0, arg1, arg2);
         Method var10001 = methodObject17685;
         this.delegate.updateAsciiStream(arg0, arg1, arg2);
         this.postForAll(var10001);
      } catch (SQLException var5) {
         this.onErrorVoidForAll(methodObject17685, var5);
      }
   }

   public void updateObject(int arg0, Object arg1) throws SQLException {
      try {
         super.preForAll(methodObject17818, this, arg0, arg1);
         Method var10001 = methodObject17818;
         this.delegate.updateObject(arg0, arg1 instanceof _Proxy_ ? (Object)((_Proxy_)arg1)._getDelegate_() : arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject17818, var4);
      }
   }

   public int getRow() throws SQLException {
      try {
         super.preForAll(methodObject17753, this, zeroLengthObjectArray);
         return (Integer)this.postForAll(methodObject17753, this.delegate.getRow());
      } catch (SQLException var2) {
         return (Integer)this.postForAll(methodObject17753, this.onErrorForAll(methodObject17753, var2));
      }
   }

   public CustomDatum getCustomDatum(String arg0, CustomDatumFactory arg1) throws SQLException {
      try {
         super.preForAll(methodObject17615, this, arg0, arg1);
         return (CustomDatum)this.postForAll(methodObject17615, (Object)this.delegate.getCustomDatum(arg0, arg1));
      } catch (SQLException var4) {
         return (CustomDatum)this.postForAll(methodObject17615, this.onErrorForAll(methodObject17615, var4));
      }
   }

   public void updateSTRUCT(String arg0, STRUCT arg1) throws SQLException {
      try {
         super.preForAll(methodObject17597, this, arg0, arg1);
         Method var10001 = methodObject17597;
         this.delegate.updateSTRUCT(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject17597, var4);
      }
   }

   public float getFloat(String arg0) throws SQLException {
      try {
         super.preForAll(methodObject17661, this, arg0);
         return (Float)this.postForAll(methodObject17661, this.delegate.getFloat(arg0));
      } catch (SQLException var3) {
         return (Float)this.postForAll(methodObject17661, this.onErrorForAll(methodObject17661, var3));
      }
   }

   public NClob getNClob(String arg0) throws SQLException {
      try {
         super.preForAll(methodObject17718, this, arg0);
         return (NClob)this.postForAll(methodObject17718, this.proxyFactory.proxyForCreate((Object)this.delegate.getNClob(arg0), this, this.proxyCache, methodObject17718));
      } catch (SQLException var3) {
         return (NClob)this.postForAll(methodObject17718, this.onErrorForAll(methodObject17718, var3));
      }
   }

   public BFILE getBfile(String arg0) throws SQLException {
      try {
         super.preForAll(methodObject17607, this, arg0);
         return (BFILE)this.postForAll(methodObject17607, (Object)this.delegate.getBfile(arg0));
      } catch (SQLException var3) {
         return (BFILE)this.postForAll(methodObject17607, this.onErrorForAll(methodObject17607, var3));
      }
   }

   public void insertRow() throws SQLException {
      try {
         super.preForRowUpdates(methodObject17683, this, zeroLengthObjectArray);
         Method var10001 = methodObject17683;
         this.delegate.insertRow();
         this.postForAll(var10001);
      } catch (SQLException var2) {
         this.onErrorVoidForAll(methodObject17683, var2);
      }
   }

   public void setFetchSize(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject17772, this, arg0);
         Method var10001 = methodObject17772;
         this.delegate.setFetchSize(arg0);
         this.postForAll(var10001);
      } catch (SQLException var3) {
         this.onErrorVoidForAll(methodObject17772, var3);
      }
   }

   public void setFetchDirection(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject17771, this, arg0);
         Method var10001 = methodObject17771;
         this.delegate.setFetchDirection(arg0);
         this.postForAll(var10001);
      } catch (SQLException var3) {
         this.onErrorVoidForAll(methodObject17771, var3);
      }
   }

   public void updateObject(String arg0, Object arg1, int arg2) throws SQLException {
      try {
         super.preForAll(methodObject17819, this, arg0, arg1, arg2);
         Method var10001 = methodObject17819;
         this.delegate.updateObject(arg0, arg1 instanceof _Proxy_ ? (Object)((_Proxy_)arg1)._getDelegate_() : arg1, arg2);
         this.postForAll(var10001);
      } catch (SQLException var5) {
         this.onErrorVoidForAll(methodObject17819, var5);
      }
   }

   public int getFetchSize() throws SQLException {
      try {
         super.preForAll(methodObject17748, this, zeroLengthObjectArray);
         return (Integer)this.postForAll(methodObject17748, this.delegate.getFetchSize());
      } catch (SQLException var2) {
         return (Integer)this.postForAll(methodObject17748, this.onErrorForAll(methodObject17748, var2));
      }
   }

   public void updateROWID(String arg0, ROWID arg1) throws SQLException {
      try {
         super.preForAll(methodObject17595, this, arg0, arg1);
         Method var10001 = methodObject17595;
         this.delegate.updateROWID(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject17595, var4);
      }
   }

   public void moveToCurrentRow() throws SQLException {
      try {
         super.preForAll(methodObject17764, this, zeroLengthObjectArray);
         Method var10001 = methodObject17764;
         this.delegate.moveToCurrentRow();
         this.postForAll(var10001);
      } catch (SQLException var2) {
         this.onErrorVoidForAll(methodObject17764, var2);
      }
   }

   public InputStream getBinaryStream(String arg0) throws SQLException {
      try {
         super.preForAll(methodObject17710, this, arg0);
         return (InputStream)this.postForAll(methodObject17710, (Object)this.delegate.getBinaryStream(arg0));
      } catch (SQLException var3) {
         return (InputStream)this.postForAll(methodObject17710, this.onErrorForAll(methodObject17710, var3));
      }
   }

   public void updateInt(String arg0, int arg1) throws SQLException {
      try {
         super.preForAll(methodObject17804, this, arg0, arg1);
         Method var10001 = methodObject17804;
         this.delegate.updateInt(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject17804, var4);
      }
   }

   public void updateCustomDatum(String arg0, CustomDatum arg1) throws SQLException {
      try {
         super.preForAll(methodObject17559, this, arg0, arg1);
         Method var10001 = methodObject17559;
         this.delegate.updateCustomDatum(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject17559, var4);
      }
   }

   public void updateORAData(int arg0, ORAData arg1) throws SQLException {
      try {
         super.preForAll(methodObject17572, this, arg0, arg1);
         Method var10001 = methodObject17572;
         this.delegate.updateORAData(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject17572, var4);
      }
   }

   public void updateNull(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject17815, this, arg0);
         Method var10001 = methodObject17815;
         this.delegate.updateNull(arg0);
         this.postForAll(var10001);
      } catch (SQLException var3) {
         this.onErrorVoidForAll(methodObject17815, var3);
      }
   }

   public boolean isWrapperFor(Class arg0) throws SQLException {
      try {
         super.preForAll(methodObject17834, this, arg0);
         return (Boolean)this.postForAll(methodObject17834, this.delegate.isWrapperFor(arg0));
      } catch (SQLException var3) {
         return (Boolean)this.postForAll(methodObject17834, this.onErrorForAll(methodObject17834, var3));
      }
   }

   public Object getObject(String arg0, Map arg1) throws SQLException {
      try {
         super.preForAll(methodObject17647, this, arg0, arg1);
         return this.postForAll(methodObject17647, this.proxyFactory.proxyForCreate(this.delegate.getObject(arg0, arg1), this, this.proxyCache, methodObject17647));
      } catch (SQLException var4) {
         return this.postForAll(methodObject17647, this.onErrorForAll(methodObject17647, var4));
      }
   }

   public STRUCT getSTRUCT(String arg0) throws SQLException {
      try {
         super.preForAll(methodObject17631, this, arg0);
         return (STRUCT)this.postForAll(methodObject17631, (Object)this.delegate.getSTRUCT(arg0));
      } catch (SQLException var3) {
         return (STRUCT)this.postForAll(methodObject17631, this.onErrorForAll(methodObject17631, var3));
      }
   }

   public Object getACProxy() {
      super.preForAll(methodObject17836, this, zeroLengthObjectArray);
      return this.postForAll(methodObject17836, this.proxyFactory.proxyForCreate(this.delegate.getACProxy(), this, this.proxyCache, methodObject17836));
   }

   public oracle.jdbc.OracleResultSet.AuthorizationIndicator getAuthorizationIndicator(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject17598, this, arg0);
         return (oracle.jdbc.OracleResultSet.AuthorizationIndicator)this.postForAll(methodObject17598, (Object)this.delegate.getAuthorizationIndicator(arg0));
      } catch (SQLException var3) {
         return (oracle.jdbc.OracleResultSet.AuthorizationIndicator)this.postForAll(methodObject17598, this.onErrorForAll(methodObject17598, var3));
      }
   }

   public SQLXML getSQLXML(String arg0) throws SQLException {
      try {
         super.preForAll(methodObject17722, this, arg0);
         return (SQLXML)this.postForAll(methodObject17722, this.proxyFactory.proxyForCreate((Object)this.delegate.getSQLXML(arg0), this, this.proxyCache, methodObject17722));
      } catch (SQLException var3) {
         return (SQLXML)this.postForAll(methodObject17722, this.onErrorForAll(methodObject17722, var3));
      }
   }

   public void updateCharacterStream(String arg0, Reader arg1, long arg2) throws SQLException {
      try {
         super.preForUpdateStreams(methodObject17700, this, arg0, arg1, arg2);
         Method var10001 = methodObject17700;
         this.delegate.updateCharacterStream(arg0, arg1, arg2);
         this.postForAll(var10001);
      } catch (SQLException var6) {
         this.onErrorVoidForAll(methodObject17700, var6);
      }
   }

   public Reader getCharacterStream(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject17734, this, arg0);
         return (Reader)this.postForAll(methodObject17734, (Object)this.delegate.getCharacterStream(arg0));
      } catch (SQLException var3) {
         return (Reader)this.postForAll(methodObject17734, this.onErrorForAll(methodObject17734, var3));
      }
   }

   public void updateCHAR(String arg0, CHAR arg1) throws SQLException {
      try {
         super.preForAll(methodObject17569, this, arg0, arg1);
         Method var10001 = methodObject17569;
         this.delegate.updateCHAR(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject17569, var4);
      }
   }

   public void updateTIMESTAMPTZ(String arg0, TIMESTAMPTZ arg1) throws SQLException {
      try {
         super.preForAll(methodObject17583, this, arg0, arg1);
         Method var10001 = methodObject17583;
         this.delegate.updateTIMESTAMPTZ(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject17583, var4);
      }
   }

   public void updateDate(int arg0, Date arg1) throws SQLException {
      try {
         super.preForAll(methodObject17797, this, arg0, arg1);
         Method var10001 = methodObject17797;
         this.delegate.updateDate(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject17797, var4);
      }
   }

   public boolean isBeforeFirst() throws SQLException {
      try {
         super.preForAll(methodObject17761, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject17761, this.delegate.isBeforeFirst());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject17761, this.onErrorForAll(methodObject17761, var2));
      }
   }

   public RowId getRowId(String arg0) throws SQLException {
      try {
         super.preForAll(methodObject17720, this, arg0);
         return (RowId)this.postForAll(methodObject17720, this.proxyFactory.proxyForCreate((Object)this.delegate.getRowId(arg0), this, this.proxyCache, methodObject17720));
      } catch (SQLException var3) {
         return (RowId)this.postForAll(methodObject17720, this.onErrorForAll(methodObject17720, var3));
      }
   }

   public int getConcurrency() throws SQLException {
      try {
         super.preForAll(methodObject17745, this, zeroLengthObjectArray);
         return (Integer)this.postForAll(methodObject17745, this.delegate.getConcurrency());
      } catch (SQLException var2) {
         return (Integer)this.postForAll(methodObject17745, this.onErrorForAll(methodObject17745, var2));
      }
   }

   public void updateBlob(int arg0, InputStream arg1, long arg2) throws SQLException {
      try {
         super.preForAll(methodObject17781, this, arg0, arg1, arg2);
         Method var10001 = methodObject17781;
         this.delegate.updateBlob(arg0, arg1, arg2);
         this.postForAll(var10001);
      } catch (SQLException var6) {
         this.onErrorVoidForAll(methodObject17781, var6);
      }
   }

   public void updateTimestamp(int arg0, Timestamp arg1) throws SQLException {
      try {
         super.preForAll(methodObject17831, this, arg0, arg1);
         Method var10001 = methodObject17831;
         this.delegate.updateTimestamp(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject17831, var4);
      }
   }

   public void updateTIMESTAMP(String arg0, TIMESTAMP arg1) throws SQLException {
      try {
         super.preForAll(methodObject17581, this, arg0, arg1);
         Method var10001 = methodObject17581;
         this.delegate.updateTIMESTAMP(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject17581, var4);
      }
   }

   public void updateCHAR(int arg0, CHAR arg1) throws SQLException {
      try {
         super.preForAll(methodObject17568, this, arg0, arg1);
         Method var10001 = methodObject17568;
         this.delegate.updateCHAR(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject17568, var4);
      }
   }

   public void updateBigDecimal(String arg0, BigDecimal arg1) throws SQLException {
      try {
         super.preForAll(methodObject17778, this, arg0, arg1);
         Method var10001 = methodObject17778;
         this.delegate.updateBigDecimal(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject17778, var4);
      }
   }

   public boolean rowInserted() throws SQLException {
      try {
         super.preForAll(methodObject17769, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject17769, this.delegate.rowInserted());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject17769, this.onErrorForAll(methodObject17769, var2));
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
         methodObject17790 = ResultSet.class.getDeclaredMethod("updateBytes", String.class, byte[].class);
         methodObject17656 = ResultSet.class.getDeclaredMethod("getInt", Integer.TYPE);
         methodObject17726 = ResultSet.class.getDeclaredMethod("getTime", String.class, Calendar.class);
         methodObject17759 = ResultSet.class.getDeclaredMethod("getUnicodeStream", String.class);
         methodObject17579 = oracle.jdbc.OracleResultSet.class.getDeclaredMethod("updateINTERVALDS", String.class, INTERVALDS.class);
         methodObject17763 = ResultSet.class.getDeclaredMethod("isLast");
         methodObject17783 = ResultSet.class.getDeclaredMethod("updateBlob", Integer.TYPE, InputStream.class);
         methodObject17622 = oracle.jdbc.OracleResultSet.class.getDeclaredMethod("getOPAQUE", Integer.TYPE);
         methodObject17576 = oracle.jdbc.OracleResultSet.class.getDeclaredMethod("updateINTERVALYM", Integer.TYPE, INTERVALYM.class);
         methodObject17592 = oracle.jdbc.OracleResultSet.class.getDeclaredMethod("updateREF", Integer.TYPE, REF.class);
         methodObject17742 = ResultSet.class.getDeclaredMethod("getBigDecimal", String.class, Integer.TYPE);
         methodObject17776 = ResultSet.class.getDeclaredMethod("updateArray", String.class, Array.class);
         methodObject17662 = ResultSet.class.getDeclaredMethod("getDouble", Integer.TYPE);
         methodObject17638 = oracle.jdbc.OracleResultSet.class.getDeclaredMethod("getTIMESTAMPTZ", Integer.TYPE);
         methodObject17574 = oracle.jdbc.OracleResultSet.class.getDeclaredMethod("updateDATE", Integer.TYPE, DATE.class);
         methodObject17565 = oracle.jdbc.OracleResultSet.class.getDeclaredMethod("updateBFILE", String.class, BFILE.class);
         methodObject17794 = ResultSet.class.getDeclaredMethod("updateClob", String.class, Reader.class, Long.TYPE);
         methodObject17556 = oracle.jdbc.OracleResultSet.class.getDeclaredMethod("getObject", Integer.TYPE, OracleDataFactory.class);
         methodObject17701 = ResultSet.class.getDeclaredMethod("updateCharacterStream", Integer.TYPE, Reader.class);
         methodObject17807 = ResultSet.class.getDeclaredMethod("updateNClob", Integer.TYPE, NClob.class);
         methodObject17677 = ResultSet.class.getDeclaredMethod("getString", String.class);
         methodObject17801 = ResultSet.class.getDeclaredMethod("updateFloat", Integer.TYPE, Float.TYPE);
         methodObject17658 = ResultSet.class.getDeclaredMethod("getLong", Integer.TYPE);
         methodObject17589 = oracle.jdbc.OracleResultSet.class.getDeclaredMethod("updateOracleObject", String.class, Datum.class);
         methodObject17679 = ResultSet.class.getDeclaredMethod("getDate", String.class);
         methodObject17695 = ResultSet.class.getDeclaredMethod("updateBinaryStream", Integer.TYPE, InputStream.class);
         methodObject17766 = ResultSet.class.getDeclaredMethod("refreshRow");
         methodObject17665 = ResultSet.class.getDeclaredMethod("getBytes", String.class);
         methodObject17687 = ResultSet.class.getDeclaredMethod("updateAsciiStream", Integer.TYPE, InputStream.class, Long.TYPE);
         methodObject17596 = oracle.jdbc.OracleResultSet.class.getDeclaredMethod("updateSTRUCT", Integer.TYPE, STRUCT.class);
         methodObject17601 = oracle.jdbc.OracleResultSet.class.getDeclaredMethod("getOracleObject", String.class);
         methodObject17676 = ResultSet.class.getDeclaredMethod("getString", Integer.TYPE);
         methodObject17587 = oracle.jdbc.OracleResultSet.class.getDeclaredMethod("updateNUMBER", String.class, NUMBER.class);
         methodObject17591 = oracle.jdbc.OracleResultSet.class.getDeclaredMethod("updateRAW", String.class, RAW.class);
         methodObject17643 = oracle.jdbc.OracleResultSet.class.getDeclaredMethod("getARRAY", String.class);
         methodObject17562 = oracle.jdbc.OracleResultSet.class.getDeclaredMethod("updateBfile", Integer.TYPE, BFILE.class);
         methodObject17621 = oracle.jdbc.OracleResultSet.class.getDeclaredMethod("getNUMBER", String.class);
         methodObject17789 = ResultSet.class.getDeclaredMethod("updateBytes", Integer.TYPE, byte[].class);
         methodObject17611 = oracle.jdbc.OracleResultSet.class.getDeclaredMethod("getCHAR", String.class);
         methodObject17736 = ResultSet.class.getDeclaredMethod("wasNull");
         methodObject17730 = ResultSet.class.getDeclaredMethod("updateTime", Integer.TYPE, Time.class);
         methodObject17675 = ResultSet.class.getDeclaredMethod("getRef", String.class);
         methodObject17586 = oracle.jdbc.OracleResultSet.class.getDeclaredMethod("updateNUMBER", Integer.TYPE, NUMBER.class);
         methodObject17684 = ResultSet.class.getDeclaredMethod("updateRow");
         methodObject17830 = ResultSet.class.getDeclaredMethod("updateString", String.class, String.class);
         methodObject17760 = ResultSet.class.getDeclaredMethod("isAfterLast");
         methodObject17820 = ResultSet.class.getDeclaredMethod("updateObject", String.class, Object.class);
         methodObject17725 = ResultSet.class.getDeclaredMethod("getTime", Integer.TYPE, Calendar.class);
         methodObject17824 = ResultSet.class.getDeclaredMethod("updateRowId", String.class, RowId.class);
         methodObject17787 = ResultSet.class.getDeclaredMethod("updateByte", Integer.TYPE, Byte.TYPE);
         methodObject17588 = oracle.jdbc.OracleResultSet.class.getDeclaredMethod("updateOracleObject", Integer.TYPE, Datum.class);
         methodObject17728 = ResultSet.class.getDeclaredMethod("clearWarnings");
         methodObject17693 = ResultSet.class.getDeclaredMethod("updateBinaryStream", Integer.TYPE, InputStream.class, Long.TYPE);
         methodObject17697 = ResultSet.class.getDeclaredMethod("updateCharacterStream", Integer.TYPE, Reader.class, Integer.TYPE);
         methodObject17627 = oracle.jdbc.OracleResultSet.class.getDeclaredMethod("getREF", String.class);
         methodObject17635 = oracle.jdbc.OracleResultSet.class.getDeclaredMethod("getINTERVALDS", String.class);
         methodObject17799 = ResultSet.class.getDeclaredMethod("updateDouble", Integer.TYPE, Double.TYPE);
         methodObject17614 = oracle.jdbc.OracleResultSet.class.getDeclaredMethod("getCustomDatum", Integer.TYPE, CustomDatumFactory.class);
         methodObject17660 = ResultSet.class.getDeclaredMethod("getFloat", Integer.TYPE);
         methodObject17731 = ResultSet.class.getDeclaredMethod("updateTime", String.class, Time.class);
         methodObject17644 = ResultSet.class.getDeclaredMethod("getObject", Integer.TYPE);
         methodObject17704 = ResultSet.class.getDeclaredMethod("updateNCharacterStream", String.class, Reader.class, Long.TYPE);
         methodObject17636 = oracle.jdbc.OracleResultSet.class.getDeclaredMethod("getTIMESTAMP", Integer.TYPE);
         methodObject17712 = ResultSet.class.getDeclaredMethod("getMetaData");
         methodObject17634 = oracle.jdbc.OracleResultSet.class.getDeclaredMethod("getINTERVALDS", Integer.TYPE);
         methodObject17711 = ResultSet.class.getDeclaredMethod("isClosed");
         methodObject17721 = ResultSet.class.getDeclaredMethod("getSQLXML", Integer.TYPE);
         methodObject17811 = ResultSet.class.getDeclaredMethod("updateNClob", Integer.TYPE, Reader.class);
         methodObject17686 = ResultSet.class.getDeclaredMethod("updateAsciiStream", String.class, InputStream.class, Integer.TYPE);
         methodObject17793 = ResultSet.class.getDeclaredMethod("updateClob", Integer.TYPE, Reader.class, Long.TYPE);
         methodObject17749 = ResultSet.class.getDeclaredMethod("getNCharacterStream", Integer.TYPE);
         methodObject17655 = ResultSet.class.getDeclaredMethod("getShort", String.class);
         methodObject17821 = ResultSet.class.getDeclaredMethod("updateRef", Integer.TYPE, Ref.class);
         methodObject17796 = ResultSet.class.getDeclaredMethod("updateClob", String.class, Reader.class);
         methodObject17582 = oracle.jdbc.OracleResultSet.class.getDeclaredMethod("updateTIMESTAMPTZ", Integer.TYPE, TIMESTAMPTZ.class);
         methodObject17707 = ResultSet.class.getDeclaredMethod("last");
         methodObject17713 = ResultSet.class.getDeclaredMethod("getBlob", Integer.TYPE);
         methodObject17810 = ResultSet.class.getDeclaredMethod("updateNClob", String.class, Reader.class, Long.TYPE);
         methodObject17770 = ResultSet.class.getDeclaredMethod("rowUpdated");
         methodObject17733 = ResultSet.class.getDeclaredMethod("getAsciiStream", String.class);
         methodObject17649 = ResultSet.class.getDeclaredMethod("getObject", String.class, Class.class);
         methodObject17599 = oracle.jdbc.OracleResultSet.class.getDeclaredMethod("getAuthorizationIndicator", String.class);
         methodObject17706 = ResultSet.class.getDeclaredMethod("updateNCharacterStream", String.class, Reader.class);
         methodObject17751 = ResultSet.class.getDeclaredMethod("getNString", Integer.TYPE);
         methodObject17747 = ResultSet.class.getDeclaredMethod("getFetchDirection");
         methodObject17719 = ResultSet.class.getDeclaredMethod("getRowId", Integer.TYPE);
         methodObject17670 = ResultSet.class.getDeclaredMethod("getURL", String.class);
         methodObject17816 = ResultSet.class.getDeclaredMethod("updateNull", String.class);
         methodObject17762 = ResultSet.class.getDeclaredMethod("isFirst");
         methodObject17750 = ResultSet.class.getDeclaredMethod("getNCharacterStream", String.class);
         methodObject17835 = ACProxyable.class.getDeclaredMethod("setACProxy", Object.class);
         methodObject17673 = ResultSet.class.getDeclaredMethod("previous");
         methodObject17570 = oracle.jdbc.OracleResultSet.class.getDeclaredMethod("updateCLOB", Integer.TYPE, CLOB.class);
         methodObject17573 = oracle.jdbc.OracleResultSet.class.getDeclaredMethod("updateORAData", String.class, ORAData.class);
         methodObject17739 = ResultSet.class.getDeclaredMethod("findColumn", String.class);
         methodObject17585 = oracle.jdbc.OracleResultSet.class.getDeclaredMethod("updateTIMESTAMPLTZ", String.class, TIMESTAMPLTZ.class);
         methodObject17744 = ResultSet.class.getDeclaredMethod("getBigDecimal", String.class);
         methodObject17651 = ResultSet.class.getDeclaredMethod("getBoolean", String.class);
         methodObject17668 = ResultSet.class.getDeclaredMethod("next");
         methodObject17803 = ResultSet.class.getDeclaredMethod("updateInt", Integer.TYPE, Integer.TYPE);
         methodObject17672 = ResultSet.class.getDeclaredMethod("getType");
         methodObject17724 = ResultSet.class.getDeclaredMethod("getTime", String.class);
         methodObject17786 = ResultSet.class.getDeclaredMethod("updateBoolean", String.class, Boolean.TYPE);
         methodObject17623 = oracle.jdbc.OracleResultSet.class.getDeclaredMethod("getOPAQUE", String.class);
         methodObject17578 = oracle.jdbc.OracleResultSet.class.getDeclaredMethod("updateINTERVALDS", Integer.TYPE, INTERVALDS.class);
         methodObject17754 = ResultSet.class.getDeclaredMethod("getTimestamp", Integer.TYPE);
         methodObject17664 = ResultSet.class.getDeclaredMethod("getBytes", Integer.TYPE);
         methodObject17681 = ResultSet.class.getDeclaredMethod("getDate", String.class, Calendar.class);
         methodObject17557 = oracle.jdbc.OracleResultSet.class.getDeclaredMethod("getObject", String.class, OracleDataFactory.class);
         methodObject17806 = ResultSet.class.getDeclaredMethod("updateLong", String.class, Long.TYPE);
         methodObject17603 = oracle.jdbc.OracleResultSet.class.getDeclaredMethod("getCursor", String.class);
         methodObject17560 = oracle.jdbc.OracleResultSet.class.getDeclaredMethod("updateARRAY", Integer.TYPE, ARRAY.class);
         methodObject17779 = ResultSet.class.getDeclaredMethod("updateBlob", Integer.TYPE, Blob.class);
         methodObject17825 = ResultSet.class.getDeclaredMethod("updateSQLXML", Integer.TYPE, SQLXML.class);
         methodObject17613 = oracle.jdbc.OracleResultSet.class.getDeclaredMethod("getCLOB", String.class);
         methodObject17632 = oracle.jdbc.OracleResultSet.class.getDeclaredMethod("getINTERVALYM", Integer.TYPE);
         methodObject17604 = oracle.jdbc.OracleResultSet.class.getDeclaredMethod("getBFILE", Integer.TYPE);
         methodObject17767 = ResultSet.class.getDeclaredMethod("relative", Integer.TYPE);
         methodObject17833 = Wrapper.class.getDeclaredMethod("unwrap", Class.class);
         methodObject17791 = ResultSet.class.getDeclaredMethod("updateClob", Integer.TYPE, Clob.class);
         methodObject17616 = oracle.jdbc.OracleResultSet.class.getDeclaredMethod("getORAData", Integer.TYPE, ORADataFactory.class);
         methodObject17823 = ResultSet.class.getDeclaredMethod("updateRowId", Integer.TYPE, RowId.class);
         methodObject17758 = ResultSet.class.getDeclaredMethod("getUnicodeStream", Integer.TYPE);
         methodObject17752 = ResultSet.class.getDeclaredMethod("getNString", String.class);
         methodObject17564 = oracle.jdbc.OracleResultSet.class.getDeclaredMethod("updateBFILE", Integer.TYPE, BFILE.class);
         methodObject17802 = ResultSet.class.getDeclaredMethod("updateFloat", String.class, Float.TYPE);
         methodObject17800 = ResultSet.class.getDeclaredMethod("updateDouble", String.class, Double.TYPE);
         methodObject17737 = ResultSet.class.getDeclaredMethod("beforeFirst");
         methodObject17832 = ResultSet.class.getDeclaredMethod("updateTimestamp", String.class, Timestamp.class);
         methodObject17633 = oracle.jdbc.OracleResultSet.class.getDeclaredMethod("getINTERVALYM", String.class);
         methodObject17657 = ResultSet.class.getDeclaredMethod("getInt", String.class);
         methodObject17620 = oracle.jdbc.OracleResultSet.class.getDeclaredMethod("getNUMBER", Integer.TYPE);
         methodObject17702 = ResultSet.class.getDeclaredMethod("updateCharacterStream", String.class, Reader.class);
         methodObject17682 = ResultSet.class.getDeclaredMethod("deleteRow");
         methodObject17814 = ResultSet.class.getDeclaredMethod("updateNString", String.class, String.class);
         methodObject17584 = oracle.jdbc.OracleResultSet.class.getDeclaredMethod("updateTIMESTAMPLTZ", Integer.TYPE, TIMESTAMPLTZ.class);
         methodObject17561 = oracle.jdbc.OracleResultSet.class.getDeclaredMethod("updateARRAY", String.class, ARRAY.class);
         methodObject17709 = ResultSet.class.getDeclaredMethod("getBinaryStream", Integer.TYPE);
         methodObject17812 = ResultSet.class.getDeclaredMethod("updateNClob", String.class, Reader.class);
         methodObject17600 = oracle.jdbc.OracleResultSet.class.getDeclaredMethod("getOracleObject", Integer.TYPE);
         methodObject17705 = ResultSet.class.getDeclaredMethod("updateNCharacterStream", Integer.TYPE, Reader.class);
         methodObject17641 = oracle.jdbc.OracleResultSet.class.getDeclaredMethod("getTIMESTAMPLTZ", String.class);
         methodObject17740 = ResultSet.class.getDeclaredMethod("first");
         methodObject17609 = oracle.jdbc.OracleResultSet.class.getDeclaredMethod("getBLOB", String.class);
         methodObject17608 = oracle.jdbc.OracleResultSet.class.getDeclaredMethod("getBLOB", Integer.TYPE);
         methodObject17788 = ResultSet.class.getDeclaredMethod("updateByte", String.class, Byte.TYPE);
         methodObject17619 = oracle.jdbc.OracleResultSet.class.getDeclaredMethod("getDATE", String.class);
         methodObject17699 = ResultSet.class.getDeclaredMethod("updateCharacterStream", Integer.TYPE, Reader.class, Long.TYPE);
         methodObject17625 = oracle.jdbc.OracleResultSet.class.getDeclaredMethod("getRAW", String.class);
         methodObject17610 = oracle.jdbc.OracleResultSet.class.getDeclaredMethod("getCHAR", Integer.TYPE);
         methodObject17563 = oracle.jdbc.OracleResultSet.class.getDeclaredMethod("updateBfile", String.class, BFILE.class);
         methodObject17567 = oracle.jdbc.OracleResultSet.class.getDeclaredMethod("updateBLOB", String.class, BLOB.class);
         methodObject17784 = ResultSet.class.getDeclaredMethod("updateBlob", String.class, InputStream.class);
         methodObject17813 = ResultSet.class.getDeclaredMethod("updateNString", Integer.TYPE, String.class);
         methodObject17817 = ResultSet.class.getDeclaredMethod("updateObject", Integer.TYPE, Object.class, Integer.TYPE);
         methodObject17577 = oracle.jdbc.OracleResultSet.class.getDeclaredMethod("updateINTERVALYM", String.class, INTERVALYM.class);
         methodObject17692 = ResultSet.class.getDeclaredMethod("updateBinaryStream", String.class, InputStream.class, Integer.TYPE);
         methodObject17723 = ResultSet.class.getDeclaredMethod("getTime", Integer.TYPE);
         methodObject17765 = ResultSet.class.getDeclaredMethod("moveToInsertRow");
         methodObject17809 = ResultSet.class.getDeclaredMethod("updateNClob", Integer.TYPE, Reader.class, Long.TYPE);
         methodObject17798 = ResultSet.class.getDeclaredMethod("updateDate", String.class, Date.class);
         methodObject17580 = oracle.jdbc.OracleResultSet.class.getDeclaredMethod("updateTIMESTAMP", Integer.TYPE, TIMESTAMP.class);
         methodObject17703 = ResultSet.class.getDeclaredMethod("updateNCharacterStream", Integer.TYPE, Reader.class, Long.TYPE);
         methodObject17738 = ResultSet.class.getDeclaredMethod("cancelRowUpdates");
         methodObject17645 = ResultSet.class.getDeclaredMethod("getObject", String.class);
         methodObject17729 = ResultSet.class.getDeclaredMethod("getHoldability");
         methodObject17629 = oracle.jdbc.OracleResultSet.class.getDeclaredMethod("getROWID", String.class);
         methodObject17805 = ResultSet.class.getDeclaredMethod("updateLong", Integer.TYPE, Long.TYPE);
         methodObject17617 = oracle.jdbc.OracleResultSet.class.getDeclaredMethod("getORAData", String.class, ORADataFactory.class);
         methodObject17696 = ResultSet.class.getDeclaredMethod("updateBinaryStream", String.class, InputStream.class);
         methodObject17650 = ResultSet.class.getDeclaredMethod("getBoolean", Integer.TYPE);
         methodObject17741 = ResultSet.class.getDeclaredMethod("getBigDecimal", Integer.TYPE, Integer.TYPE);
         methodObject17743 = ResultSet.class.getDeclaredMethod("getBigDecimal", Integer.TYPE);
         methodObject17688 = ResultSet.class.getDeclaredMethod("updateAsciiStream", String.class, InputStream.class, Long.TYPE);
         methodObject17575 = oracle.jdbc.OracleResultSet.class.getDeclaredMethod("updateDATE", String.class, DATE.class);
         methodObject17637 = oracle.jdbc.OracleResultSet.class.getDeclaredMethod("getTIMESTAMP", String.class);
         methodObject17827 = ResultSet.class.getDeclaredMethod("updateShort", Integer.TYPE, Short.TYPE);
         methodObject17555 = OracleResultSet.class.getDeclaredMethod("closeStatementOnClose");
         methodObject17654 = ResultSet.class.getDeclaredMethod("getShort", Integer.TYPE);
         methodObject17674 = ResultSet.class.getDeclaredMethod("getRef", Integer.TYPE);
         methodObject17605 = oracle.jdbc.OracleResultSet.class.getDeclaredMethod("getBFILE", String.class);
         methodObject17590 = oracle.jdbc.OracleResultSet.class.getDeclaredMethod("updateRAW", Integer.TYPE, RAW.class);
         methodObject17678 = ResultSet.class.getDeclaredMethod("getDate", Integer.TYPE);
         methodObject17714 = ResultSet.class.getDeclaredMethod("getBlob", String.class);
         methodObject17828 = ResultSet.class.getDeclaredMethod("updateShort", String.class, Short.TYPE);
         methodObject17808 = ResultSet.class.getDeclaredMethod("updateNClob", String.class, NClob.class);
         methodObject17646 = ResultSet.class.getDeclaredMethod("getObject", Integer.TYPE, Map.class);
         methodObject17780 = ResultSet.class.getDeclaredMethod("updateBlob", String.class, Blob.class);
         methodObject17680 = ResultSet.class.getDeclaredMethod("getDate", Integer.TYPE, Calendar.class);
         methodObject17626 = oracle.jdbc.OracleResultSet.class.getDeclaredMethod("getREF", Integer.TYPE);
         methodObject17768 = ResultSet.class.getDeclaredMethod("rowDeleted");
         methodObject17639 = oracle.jdbc.OracleResultSet.class.getDeclaredMethod("getTIMESTAMPTZ", String.class);
         methodObject17829 = ResultSet.class.getDeclaredMethod("updateString", Integer.TYPE, String.class);
         methodObject17774 = ResultSet.class.getDeclaredMethod("afterLast");
         methodObject17558 = oracle.jdbc.OracleResultSet.class.getDeclaredMethod("updateCustomDatum", Integer.TYPE, CustomDatum.class);
         methodObject17795 = ResultSet.class.getDeclaredMethod("updateClob", Integer.TYPE, Reader.class);
         methodObject17775 = ResultSet.class.getDeclaredMethod("updateArray", Integer.TYPE, Array.class);
         methodObject17593 = oracle.jdbc.OracleResultSet.class.getDeclaredMethod("updateREF", String.class, REF.class);
         methodObject17669 = ResultSet.class.getDeclaredMethod("getURL", Integer.TYPE);
         methodObject17667 = ResultSet.class.getDeclaredMethod("getArray", String.class);
         methodObject17708 = ResultSet.class.getDeclaredMethod("getStatement");
         methodObject17727 = ResultSet.class.getDeclaredMethod("getWarnings");
         methodObject17566 = oracle.jdbc.OracleResultSet.class.getDeclaredMethod("updateBLOB", Integer.TYPE, BLOB.class);
         methodObject17735 = ResultSet.class.getDeclaredMethod("getCharacterStream", String.class);
         methodObject17594 = oracle.jdbc.OracleResultSet.class.getDeclaredMethod("updateROWID", Integer.TYPE, ROWID.class);
         methodObject17652 = ResultSet.class.getDeclaredMethod("getByte", Integer.TYPE);
         methodObject17618 = oracle.jdbc.OracleResultSet.class.getDeclaredMethod("getDATE", Integer.TYPE);
         methodObject17612 = oracle.jdbc.OracleResultSet.class.getDeclaredMethod("getCLOB", Integer.TYPE);
         methodObject17642 = oracle.jdbc.OracleResultSet.class.getDeclaredMethod("getARRAY", Integer.TYPE);
         methodObject17606 = oracle.jdbc.OracleResultSet.class.getDeclaredMethod("getBfile", Integer.TYPE);
         methodObject17757 = ResultSet.class.getDeclaredMethod("getTimestamp", String.class, Calendar.class);
         methodObject17659 = ResultSet.class.getDeclaredMethod("getLong", String.class);
         methodObject17715 = ResultSet.class.getDeclaredMethod("getClob", Integer.TYPE);
         methodObject17777 = ResultSet.class.getDeclaredMethod("updateBigDecimal", Integer.TYPE, BigDecimal.class);
         methodObject17628 = oracle.jdbc.OracleResultSet.class.getDeclaredMethod("getROWID", Integer.TYPE);
         methodObject17782 = ResultSet.class.getDeclaredMethod("updateBlob", String.class, InputStream.class, Long.TYPE);
         methodObject17746 = ResultSet.class.getDeclaredMethod("getCursorName");
         methodObject17671 = ResultSet.class.getDeclaredMethod("close");
         methodObject17694 = ResultSet.class.getDeclaredMethod("updateBinaryStream", String.class, InputStream.class, Long.TYPE);
         methodObject17602 = oracle.jdbc.OracleResultSet.class.getDeclaredMethod("getCursor", Integer.TYPE);
         methodObject17663 = ResultSet.class.getDeclaredMethod("getDouble", String.class);
         methodObject17648 = ResultSet.class.getDeclaredMethod("getObject", Integer.TYPE, Class.class);
         methodObject17822 = ResultSet.class.getDeclaredMethod("updateRef", String.class, Ref.class);
         methodObject17773 = ResultSet.class.getDeclaredMethod("absolute", Integer.TYPE);
         methodObject17756 = ResultSet.class.getDeclaredMethod("getTimestamp", Integer.TYPE, Calendar.class);
         methodObject17732 = ResultSet.class.getDeclaredMethod("getAsciiStream", Integer.TYPE);
         methodObject17624 = oracle.jdbc.OracleResultSet.class.getDeclaredMethod("getRAW", Integer.TYPE);
         methodObject17785 = ResultSet.class.getDeclaredMethod("updateBoolean", Integer.TYPE, Boolean.TYPE);
         methodObject17717 = ResultSet.class.getDeclaredMethod("getNClob", Integer.TYPE);
         methodObject17691 = ResultSet.class.getDeclaredMethod("updateBinaryStream", Integer.TYPE, InputStream.class, Integer.TYPE);
         methodObject17653 = ResultSet.class.getDeclaredMethod("getByte", String.class);
         methodObject17690 = ResultSet.class.getDeclaredMethod("updateAsciiStream", String.class, InputStream.class);
         methodObject17826 = ResultSet.class.getDeclaredMethod("updateSQLXML", String.class, SQLXML.class);
         methodObject17571 = oracle.jdbc.OracleResultSet.class.getDeclaredMethod("updateCLOB", String.class, CLOB.class);
         methodObject17666 = ResultSet.class.getDeclaredMethod("getArray", Integer.TYPE);
         methodObject17698 = ResultSet.class.getDeclaredMethod("updateCharacterStream", String.class, Reader.class, Integer.TYPE);
         methodObject17755 = ResultSet.class.getDeclaredMethod("getTimestamp", String.class);
         methodObject17689 = ResultSet.class.getDeclaredMethod("updateAsciiStream", Integer.TYPE, InputStream.class);
         methodObject17630 = oracle.jdbc.OracleResultSet.class.getDeclaredMethod("getSTRUCT", Integer.TYPE);
         methodObject17716 = ResultSet.class.getDeclaredMethod("getClob", String.class);
         methodObject17792 = ResultSet.class.getDeclaredMethod("updateClob", String.class, Clob.class);
         methodObject17640 = oracle.jdbc.OracleResultSet.class.getDeclaredMethod("getTIMESTAMPLTZ", Integer.TYPE);
         methodObject17685 = ResultSet.class.getDeclaredMethod("updateAsciiStream", Integer.TYPE, InputStream.class, Integer.TYPE);
         methodObject17818 = ResultSet.class.getDeclaredMethod("updateObject", Integer.TYPE, Object.class);
         methodObject17753 = ResultSet.class.getDeclaredMethod("getRow");
         methodObject17615 = oracle.jdbc.OracleResultSet.class.getDeclaredMethod("getCustomDatum", String.class, CustomDatumFactory.class);
         methodObject17597 = oracle.jdbc.OracleResultSet.class.getDeclaredMethod("updateSTRUCT", String.class, STRUCT.class);
         methodObject17661 = ResultSet.class.getDeclaredMethod("getFloat", String.class);
         methodObject17718 = ResultSet.class.getDeclaredMethod("getNClob", String.class);
         methodObject17607 = oracle.jdbc.OracleResultSet.class.getDeclaredMethod("getBfile", String.class);
         methodObject17683 = ResultSet.class.getDeclaredMethod("insertRow");
         methodObject17772 = ResultSet.class.getDeclaredMethod("setFetchSize", Integer.TYPE);
         methodObject17771 = ResultSet.class.getDeclaredMethod("setFetchDirection", Integer.TYPE);
         methodObject17819 = ResultSet.class.getDeclaredMethod("updateObject", String.class, Object.class, Integer.TYPE);
         methodObject17748 = ResultSet.class.getDeclaredMethod("getFetchSize");
         methodObject17595 = oracle.jdbc.OracleResultSet.class.getDeclaredMethod("updateROWID", String.class, ROWID.class);
         methodObject17764 = ResultSet.class.getDeclaredMethod("moveToCurrentRow");
         methodObject17710 = ResultSet.class.getDeclaredMethod("getBinaryStream", String.class);
         methodObject17804 = ResultSet.class.getDeclaredMethod("updateInt", String.class, Integer.TYPE);
         methodObject17559 = oracle.jdbc.OracleResultSet.class.getDeclaredMethod("updateCustomDatum", String.class, CustomDatum.class);
         methodObject17572 = oracle.jdbc.OracleResultSet.class.getDeclaredMethod("updateORAData", Integer.TYPE, ORAData.class);
         methodObject17815 = ResultSet.class.getDeclaredMethod("updateNull", Integer.TYPE);
         methodObject17834 = Wrapper.class.getDeclaredMethod("isWrapperFor", Class.class);
         methodObject17647 = ResultSet.class.getDeclaredMethod("getObject", String.class, Map.class);
         methodObject17631 = oracle.jdbc.OracleResultSet.class.getDeclaredMethod("getSTRUCT", String.class);
         methodObject17836 = ACProxyable.class.getDeclaredMethod("getACProxy");
         methodObject17598 = oracle.jdbc.OracleResultSet.class.getDeclaredMethod("getAuthorizationIndicator", Integer.TYPE);
         methodObject17722 = ResultSet.class.getDeclaredMethod("getSQLXML", String.class);
         methodObject17700 = ResultSet.class.getDeclaredMethod("updateCharacterStream", String.class, Reader.class, Long.TYPE);
         methodObject17734 = ResultSet.class.getDeclaredMethod("getCharacterStream", Integer.TYPE);
         methodObject17569 = oracle.jdbc.OracleResultSet.class.getDeclaredMethod("updateCHAR", String.class, CHAR.class);
         methodObject17583 = oracle.jdbc.OracleResultSet.class.getDeclaredMethod("updateTIMESTAMPTZ", String.class, TIMESTAMPTZ.class);
         methodObject17797 = ResultSet.class.getDeclaredMethod("updateDate", Integer.TYPE, Date.class);
         methodObject17761 = ResultSet.class.getDeclaredMethod("isBeforeFirst");
         methodObject17720 = ResultSet.class.getDeclaredMethod("getRowId", String.class);
         methodObject17745 = ResultSet.class.getDeclaredMethod("getConcurrency");
         methodObject17781 = ResultSet.class.getDeclaredMethod("updateBlob", Integer.TYPE, InputStream.class, Long.TYPE);
         methodObject17831 = ResultSet.class.getDeclaredMethod("updateTimestamp", Integer.TYPE, Timestamp.class);
         methodObject17581 = oracle.jdbc.OracleResultSet.class.getDeclaredMethod("updateTIMESTAMP", String.class, TIMESTAMP.class);
         methodObject17568 = oracle.jdbc.OracleResultSet.class.getDeclaredMethod("updateCHAR", Integer.TYPE, CHAR.class);
         methodObject17778 = ResultSet.class.getDeclaredMethod("updateBigDecimal", String.class, BigDecimal.class);
         methodObject17769 = ResultSet.class.getDeclaredMethod("rowInserted");
      } catch (Throwable var1) {
         throw new RuntimeException(var1);
      }
   }

   public oracle$1jdbc$1replay$1driver$1NonTxnReplayableResultSet$2oracle$1jdbc$1internal$1OracleResultSet$$$Proxy(OracleResultSet var1, Object var2, ProxyFactory var3, Map var4) {
      this.delegate = var1;
      this.creator = var2;
      this.proxyFactory = var3;
      this.proxyCache = var4;
   }
}
