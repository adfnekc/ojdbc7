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
import oracle.jdbc.OracleCallableStatement;
import oracle.jdbc.OracleDataFactory;
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
import oracle.sql.StructDescriptor;
import oracle.sql.TIMESTAMP;
import oracle.sql.TIMESTAMPLTZ;
import oracle.sql.TIMESTAMPTZ;

public abstract class oracle$1jdbc$1replay$1driver$1NonTxnReplayableStatement$2oracle$1jdbc$1OracleCallableStatement$$$Proxy extends NonTxnReplayableStatement implements OracleCallableStatement, _Proxy_ {
   private OracleCallableStatement delegate;
   private final Object creator;
   private final ProxyFactory proxyFactory;
   private final Map proxyCache;
   private static Object[] zeroLengthObjectArray = new Object[0];
   private static Method methodObject26626;
   private static Method methodObject26432;
   private static Method methodObject26414;
   private static Method methodObject26503;
   private static Method methodObject26440;
   private static Method methodObject26635;
   private static Method methodObject26572;
   private static Method methodObject26557;
   private static Method methodObject26619;
   private static Method methodObject26499;
   private static Method methodObject26633;
   private static Method methodObject26705;
   private static Method methodObject26618;
   private static Method methodObject26517;
   private static Method methodObject26680;
   private static Method methodObject26602;
   private static Method methodObject26695;
   private static Method methodObject26655;
   private static Method methodObject26757;
   private static Method methodObject26782;
   private static Method methodObject26735;
   private static Method methodObject26542;
   private static Method methodObject26653;
   private static Method methodObject26719;
   private static Method methodObject26512;
   private static Method methodObject26642;
   private static Method methodObject26683;
   private static Method methodObject26409;
   private static Method methodObject26549;
   private static Method methodObject26713;
   private static Method methodObject26641;
   private static Method methodObject26454;
   private static Method methodObject26770;
   private static Method methodObject26427;
   private static Method methodObject26776;
   private static Method methodObject26685;
   private static Method methodObject26485;
   private static Method methodObject26786;
   private static Method methodObject26599;
   private static Method methodObject26661;
   private static Method methodObject26461;
   private static Method methodObject26715;
   private static Method methodObject26535;
   private static Method methodObject26522;
   private static Method methodObject26556;
   private static Method methodObject26496;
   private static Method methodObject26796;
   private static Method methodObject26527;
   private static Method methodObject26646;
   private static Method methodObject26391;
   private static Method methodObject26490;
   private static Method methodObject26629;
   private static Method methodObject26669;
   private static Method methodObject26564;
   private static Method methodObject26544;
   private static Method methodObject26663;
   private static Method methodObject26771;
   private static Method methodObject26609;
   private static Method methodObject26610;
   private static Method methodObject26589;
   private static Method methodObject26456;
   private static Method methodObject26746;
   private static Method methodObject26480;
   private static Method methodObject26395;
   private static Method methodObject26762;
   private static Method methodObject26785;
   private static Method methodObject26492;
   private static Method methodObject26390;
   private static Method methodObject26790;
   private static Method methodObject26449;
   private static Method methodObject26611;
   private static Method methodObject26792;
   private static Method methodObject26765;
   private static Method methodObject26711;
   private static Method methodObject26471;
   private static Method methodObject26789;
   private static Method methodObject26767;
   private static Method methodObject26709;
   private static Method methodObject26422;
   private static Method methodObject26565;
   private static Method methodObject26418;
   private static Method methodObject26595;
   private static Method methodObject26783;
   private static Method methodObject26729;
   private static Method methodObject26382;
   private static Method methodObject26410;
   private static Method methodObject26431;
   private static Method methodObject26723;
   private static Method methodObject26630;
   private static Method methodObject26459;
   private static Method methodObject26524;
   private static Method methodObject26662;
   private static Method methodObject26802;
   private static Method methodObject26803;
   private static Method methodObject26396;
   private static Method methodObject26420;
   private static Method methodObject26400;
   private static Method methodObject26417;
   private static Method methodObject26550;
   private static Method methodObject26591;
   private static Method methodObject26781;
   private static Method methodObject26615;
   private static Method methodObject26476;
   private static Method methodObject26558;
   private static Method methodObject26537;
   private static Method methodObject26603;
   private static Method methodObject26387;
   private static Method methodObject26634;
   private static Method methodObject26394;
   private static Method methodObject26442;
   private static Method methodObject26451;
   private static Method methodObject26690;
   private static Method methodObject26728;
   private static Method methodObject26559;
   private static Method methodObject26726;
   private static Method methodObject26638;
   private static Method methodObject26573;
   private static Method methodObject26758;
   private static Method methodObject26543;
   private static Method methodObject26775;
   private static Method methodObject26622;
   private static Method methodObject26740;
   private static Method methodObject26784;
   private static Method methodObject26648;
   private static Method methodObject26606;
   private static Method methodObject26511;
   private static Method methodObject26445;
   private static Method methodObject26515;
   private static Method methodObject26748;
   private static Method methodObject26651;
   private static Method methodObject26579;
   private static Method methodObject26617;
   private static Method methodObject26702;
   private static Method methodObject26608;
   private static Method methodObject26620;
   private static Method methodObject26516;
   private static Method methodObject26555;
   private static Method methodObject26434;
   private static Method methodObject26689;
   private static Method methodObject26465;
   private static Method methodObject26508;
   private static Method methodObject26752;
   private static Method methodObject26405;
   private static Method methodObject26745;
   private static Method methodObject26493;
   private static Method methodObject26484;
   private static Method methodObject26464;
   private static Method methodObject26423;
   private static Method methodObject26804;
   private static Method methodObject26529;
   private static Method methodObject26477;
   private static Method methodObject26718;
   private static Method methodObject26504;
   private static Method methodObject26489;
   private static Method methodObject26772;
   private static Method methodObject26567;
   private static Method methodObject26482;
   private static Method methodObject26406;
   private static Method methodObject26392;
   private static Method methodObject26743;
   private static Method methodObject26700;
   private static Method methodObject26458;
   private static Method methodObject26494;
   private static Method methodObject26674;
   private static Method methodObject26742;
   private static Method methodObject26644;
   private static Method methodObject26650;
   private static Method methodObject26568;
   private static Method methodObject26623;
   private static Method methodObject26436;
   private static Method methodObject26582;
   private static Method methodObject26798;
   private static Method methodObject26530;
   private static Method methodObject26441;
   private static Method methodObject26601;
   private static Method methodObject26478;
   private static Method methodObject26448;
   private static Method methodObject26502;
   private static Method methodObject26720;
   private static Method methodObject26475;
   private static Method methodObject26666;
   private static Method methodObject26664;
   private static Method methodObject26657;
   private static Method methodObject26594;
   private static Method methodObject26402;
   private static Method methodObject26585;
   private static Method methodObject26806;
   private static Method methodObject26523;
   private static Method methodObject26607;
   private static Method methodObject26488;
   private static Method methodObject26668;
   private static Method methodObject26467;
   private static Method methodObject26707;
   private static Method methodObject26412;
   private static Method methodObject26580;
   private static Method methodObject26676;
   private static Method methodObject26407;
   private static Method methodObject26534;
   private static Method methodObject26738;
   private static Method methodObject26552;
   private static Method methodObject26545;
   private static Method methodObject26744;
   private static Method methodObject26521;
   private static Method methodObject26447;
   private static Method methodObject26548;
   private static Method methodObject26675;
   private static Method methodObject26497;
   private static Method methodObject26712;
   private static Method methodObject26540;
   private static Method methodObject26419;
   private static Method methodObject26686;
   private static Method methodObject26714;
   private static Method methodObject26778;
   private static Method methodObject26755;
   private static Method methodObject26708;
   private static Method methodObject26621;
   private static Method methodObject26780;
   private static Method methodObject26446;
   private static Method methodObject26401;
   private static Method methodObject26787;
   private static Method methodObject26754;
   private static Method methodObject26571;
   private static Method methodObject26381;
   private static Method methodObject26677;
   private static Method methodObject26514;
   private static Method methodObject26800;
   private static Method methodObject26577;
   private static Method methodObject26656;
   private static Method methodObject26793;
   private static Method methodObject26469;
   private static Method methodObject26593;
   private static Method methodObject26506;
   private static Method methodObject26654;
   private static Method methodObject26597;
   private static Method methodObject26513;
   private static Method methodObject26659;
   private static Method methodObject26670;
   private static Method methodObject26587;
   private static Method methodObject26671;
   private static Method methodObject26632;
   private static Method methodObject26526;
   private static Method methodObject26658;
   private static Method methodObject26691;
   private static Method methodObject26612;
   private static Method methodObject26538;
   private static Method methodObject26416;
   private static Method methodObject26763;
   private static Method methodObject26525;
   private static Method methodObject26749;
   private static Method methodObject26501;
   private static Method methodObject26468;
   private static Method methodObject26388;
   private static Method methodObject26439;
   private static Method methodObject26759;
   private static Method methodObject26438;
   private static Method methodObject26637;
   private static Method methodObject26731;
   private static Method methodObject26483;
   private static Method methodObject26562;
   private static Method methodObject26479;
   private static Method methodObject26590;
   private static Method methodObject26799;
   private static Method methodObject26613;
   private static Method methodObject26463;
   private static Method methodObject26645;
   private static Method methodObject26696;
   private static Method methodObject26533;
   private static Method methodObject26510;
   private static Method methodObject26563;
   private static Method methodObject26699;
   private static Method methodObject26693;
   private static Method methodObject26570;
   private static Method methodObject26721;
   private static Method methodObject26701;
   private static Method methodObject26561;
   private static Method methodObject26698;
   private static Method methodObject26520;
   private static Method methodObject26682;
   private static Method methodObject26681;
   private static Method methodObject26539;
   private static Method methodObject26788;
   private static Method methodObject26443;
   private static Method methodObject26472;
   private static Method methodObject26673;
   private static Method methodObject26769;
   private static Method methodObject26457;
   private static Method methodObject26741;
   private static Method methodObject26566;
   private static Method methodObject26404;
   private static Method methodObject26753;
   private static Method methodObject26518;
   private static Method methodObject26505;
   private static Method methodObject26725;
   private static Method methodObject26733;
   private static Method methodObject26692;
   private static Method methodObject26399;
   private static Method methodObject26393;
   private static Method methodObject26760;
   private static Method methodObject26474;
   private static Method methodObject26554;
   private static Method methodObject26584;
   private static Method methodObject26437;
   private static Method methodObject26688;
   private static Method methodObject26643;
   private static Method methodObject26667;
   private static Method methodObject26547;
   private static Method methodObject26652;
   private static Method methodObject26428;
   private static Method methodObject26751;
   private static Method methodObject26732;
   private static Method methodObject26716;
   private static Method methodObject26596;
   private static Method methodObject26750;
   private static Method methodObject26687;
   private static Method methodObject26498;
   private static Method methodObject26624;
   private static Method methodObject26444;
   private static Method methodObject26697;
   private static Method methodObject26631;
   private static Method methodObject26455;
   private static Method methodObject26795;
   private static Method methodObject26724;
   private static Method methodObject26736;
   private static Method methodObject26424;
   private static Method methodObject26794;
   private static Method methodObject26425;
   private static Method methodObject26807;
   private static Method methodObject26727;
   private static Method methodObject26470;
   private static Method methodObject26766;
   private static Method methodObject26628;
   private static Method methodObject26734;
   private static Method methodObject26411;
   private static Method methodObject26487;
   private static Method methodObject26649;
   private static Method methodObject26491;
   private static Method methodObject26560;
   private static Method methodObject26704;
   private static Method methodObject26679;
   private static Method methodObject26466;
   private static Method methodObject26605;
   private static Method methodObject26495;
   private static Method methodObject26389;
   private static Method methodObject26636;
   private static Method methodObject26413;
   private static Method methodObject26415;
   private static Method methodObject26773;
   private static Method methodObject26627;
   private static Method methodObject26756;
   private static Method methodObject26528;
   private static Method methodObject26408;
   private static Method methodObject26486;
   private static Method methodObject26614;
   private static Method methodObject26598;
   private static Method methodObject26519;
   private static Method methodObject26429;
   private static Method methodObject26509;
   private static Method methodObject26703;
   private static Method methodObject26768;
   private static Method methodObject26553;
   private static Method methodObject26640;
   private static Method methodObject26779;
   private static Method methodObject26541;
   private static Method methodObject26430;
   private static Method methodObject26426;
   private static Method methodObject26473;
   private static Method methodObject26639;
   private static Method methodObject26722;
   private static Method methodObject26460;
   private static Method methodObject26569;
   private static Method methodObject26500;
   private static Method methodObject26660;
   private static Method methodObject26747;
   private static Method methodObject26435;
   private static Method methodObject26481;
   private static Method methodObject26791;
   private static Method methodObject26625;
   private static Method methodObject26421;
   private static Method methodObject26730;
   private static Method methodObject26694;
   private static Method methodObject26433;
   private static Method methodObject26462;
   private static Method methodObject26578;
   private static Method methodObject26586;
   private static Method methodObject26531;
   private static Method methodObject26398;
   private static Method methodObject26386;
   private static Method methodObject26403;
   private static Method methodObject26717;
   private static Method methodObject26507;
   private static Method methodObject26576;
   private static Method methodObject26450;
   private static Method methodObject26805;
   private static Method methodObject26616;
   private static Method methodObject26551;
   private static Method methodObject26581;
   private static Method methodObject26592;
   private static Method methodObject26797;
   private static Method methodObject26575;
   private static Method methodObject26604;
   private static Method methodObject26532;
   private static Method methodObject26737;
   private static Method methodObject26774;
   private static Method methodObject26383;
   private static Method methodObject26665;
   private static Method methodObject26453;
   private static Method methodObject26710;
   private static Method methodObject26546;
   private static Method methodObject26588;
   private static Method methodObject26761;
   private static Method methodObject26384;
   private static Method methodObject26452;
   private static Method methodObject26397;
   private static Method methodObject26672;
   private static Method methodObject26739;
   private static Method methodObject26801;
   private static Method methodObject26684;
   private static Method methodObject26536;
   private static Method methodObject26600;
   private static Method methodObject26706;
   private static Method methodObject26764;
   private static Method methodObject26777;
   private static Method methodObject26583;
   private static Method methodObject26678;
   private static Method methodObject26647;
   private static Method methodObject26385;
   private static Method methodObject26574;

   public boolean execute(String arg0) throws SQLException {
      try {
         super.preForExecute(methodObject26626, this, arg0);
         return this.postForExecute(methodObject26626, this.delegate.execute(arg0));
      } catch (SQLException var3) {
         return this.postForExecute(methodObject26626, this.onErrorForExecute(methodObject26626, var3));
      }
   }

   public OPAQUE getOPAQUE(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject26432, this, arg0);
         return (OPAQUE)this.postForAll(methodObject26432, (Object)this.delegate.getOPAQUE(arg0));
      } catch (SQLException var3) {
         return (OPAQUE)this.postForAll(methodObject26432, this.onErrorForAll(methodObject26432, var3));
      }
   }

   public void setNull(String arg0, int arg1, String arg2) throws SQLException {
      try {
         super.preForAll(methodObject26414, this, arg0, arg1, arg2);
         this.delegate.setNull(arg0, arg1, arg2);
      } catch (SQLException var5) {
         this.onErrorVoidForAll(methodObject26414, var5);
      }
   }

   public double getDouble(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject26503, this, arg0);
         return (Double)this.postForAll(methodObject26503, this.delegate.getDouble(arg0));
      } catch (SQLException var3) {
         return (Double)this.postForAll(methodObject26503, this.onErrorForAll(methodObject26503, var3));
      }
   }

   public TIMESTAMPTZ getTIMESTAMPTZ(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject26440, this, arg0);
         return (TIMESTAMPTZ)this.postForAll(methodObject26440, (Object)this.delegate.getTIMESTAMPTZ(arg0));
      } catch (SQLException var3) {
         return (TIMESTAMPTZ)this.postForAll(methodObject26440, this.onErrorForAll(methodObject26440, var3));
      }
   }

   public int executeUpdate(String arg0, int[] arg1) throws SQLException {
      try {
         super.preForExecuteUpdate(methodObject26635, this, arg0, arg1);
         return this.postForExecuteUpdate(methodObject26635, this.delegate.executeUpdate(arg0, arg1));
      } catch (SQLException var4) {
         return this.postForExecuteUpdate(methodObject26635, (Integer)this.onErrorForAll(methodObject26635, var4));
      }
   }

   public void setDouble(int arg0, double arg1) throws SQLException {
      try {
         super.preForAll(methodObject26572, this, arg0, arg1);
         this.delegate.setDouble(arg0, arg1);
      } catch (SQLException var5) {
         this.onErrorVoidForAll(methodObject26572, var5);
      }
   }

   public void setRowId(String arg0, RowId arg1) throws SQLException {
      try {
         super.preForAll(methodObject26557, this, arg0, arg1);
         this.delegate.setRowId(arg0, arg1 instanceof _Proxy_ ? (RowId)((_Proxy_)arg1)._getDelegate_() : arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject26557, var4);
      }
   }

   public void setNull(int arg0, int arg1) throws SQLException {
      try {
         super.preForAll(methodObject26619, this, arg0, arg1);
         this.delegate.setNull(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject26619, var4);
      }
   }

   public long getLong(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject26499, this, arg0);
         return (Long)this.postForAll(methodObject26499, this.delegate.getLong(arg0));
      } catch (SQLException var3) {
         return (Long)this.postForAll(methodObject26499, this.onErrorForAll(methodObject26499, var3));
      }
   }

   public int executeUpdate(String arg0) throws SQLException {
      try {
         super.preForExecuteUpdate(methodObject26633, this, arg0);
         return this.postForExecuteUpdate(methodObject26633, this.delegate.executeUpdate(arg0));
      } catch (SQLException var3) {
         return this.postForExecuteUpdate(methodObject26633, (Integer)this.onErrorForAll(methodObject26633, var3));
      }
   }

   public void setROWIDAtName(String arg0, ROWID arg1) throws SQLException {
      try {
         super.preForAll(methodObject26705, this, arg0, arg1);
         this.delegate.setROWIDAtName(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject26705, var4);
      }
   }

   public void setNString(int arg0, String arg1) throws SQLException {
      try {
         super.preForAll(methodObject26618, this, arg0, arg1);
         this.delegate.setNString(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject26618, var4);
      }
   }

   public Date getDate(String arg0) throws SQLException {
      try {
         super.preForAll(methodObject26517, this, arg0);
         return (Date)this.postForAll(methodObject26517, (Object)this.delegate.getDate(arg0));
      } catch (SQLException var3) {
         return (Date)this.postForAll(methodObject26517, this.onErrorForAll(methodObject26517, var3));
      }
   }

   public void setObjectAtName(String arg0, Object arg1, int arg2, int arg3) throws SQLException {
      try {
         super.preForSetObjects(methodObject26680, this, arg0, arg1, arg2, arg3);
         this.delegate.setObjectAtName(arg0, arg1 instanceof _Proxy_ ? (Object)((_Proxy_)arg1)._getDelegate_() : arg1, arg2, arg3);
      } catch (SQLException var6) {
         this.onErrorVoidForAll(methodObject26680, var6);
      }
   }

   public void setTime(int arg0, Time arg1, Calendar arg2) throws SQLException {
      try {
         super.preForAll(methodObject26602, this, arg0, arg1, arg2);
         this.delegate.setTime(arg0, arg1, arg2);
      } catch (SQLException var5) {
         this.onErrorVoidForAll(methodObject26602, var5);
      }
   }

   public void setDoubleAtName(String arg0, double arg1) throws SQLException {
      try {
         super.preForAll(methodObject26695, this, arg0, arg1);
         this.delegate.setDoubleAtName(arg0, arg1);
      } catch (SQLException var5) {
         this.onErrorVoidForAll(methodObject26695, var5);
      }
   }

   public boolean isCloseOnCompletion() throws SQLException {
      try {
         super.preForAll(methodObject26655, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject26655, this.delegate.isCloseOnCompletion());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject26655, this.onErrorForAll(methodObject26655, var2));
      }
   }

   public void setNStringAtName(String arg0, String arg1) throws SQLException {
      try {
         super.preForAll(methodObject26757, this, arg0, arg1);
         this.delegate.setNStringAtName(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject26757, var4);
      }
   }

   public void setARRAY(int arg0, ARRAY arg1) throws SQLException {
      try {
         super.preForAll(methodObject26782, this, arg0, arg1);
         this.delegate.setARRAY(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject26782, var4);
      }
   }

   public void setTIMESTAMPAtName(String arg0, TIMESTAMP arg1) throws SQLException {
      try {
         super.preForAll(methodObject26735, this, arg0, arg1);
         this.delegate.setTIMESTAMPAtName(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject26735, var4);
      }
   }

   public boolean wasNull() throws SQLException {
      try {
         super.preForAll(methodObject26542, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject26542, this.delegate.wasNull());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject26542, this.onErrorForAll(methodObject26542, var2));
      }
   }

   public int getResultSetType() throws SQLException {
      try {
         super.preForAll(methodObject26653, this, zeroLengthObjectArray);
         return (Integer)this.postForAll(methodObject26653, this.delegate.getResultSetType());
      } catch (SQLException var2) {
         return (Integer)this.postForAll(methodObject26653, this.onErrorForAll(methodObject26653, var2));
      }
   }

   public void setCLOBAtName(String arg0, CLOB arg1) throws SQLException {
      try {
         super.preForAll(methodObject26719, this, arg0, arg1);
         this.delegate.setCLOBAtName(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject26719, var4);
      }
   }

   public Ref getRef(String arg0) throws SQLException {
      try {
         super.preForAll(methodObject26512, this, arg0);
         return (Ref)this.postForAll(methodObject26512, this.proxyFactory.proxyForCreate((Object)this.delegate.getRef(arg0), this, this.proxyCache, methodObject26512));
      } catch (SQLException var3) {
         return (Ref)this.postForAll(methodObject26512, this.onErrorForAll(methodObject26512, var3));
      }
   }

   public int getResultSetHoldability() throws SQLException {
      try {
         super.preForAll(methodObject26642, this, zeroLengthObjectArray);
         return (Integer)this.postForAll(methodObject26642, this.delegate.getResultSetHoldability());
      } catch (SQLException var2) {
         return (Integer)this.postForAll(methodObject26642, this.onErrorForAll(methodObject26642, var2));
      }
   }

   public void defineParameterTypeBytes(int arg0, int arg1, int arg2) throws SQLException {
      try {
         super.preForAll(methodObject26683, this, arg0, arg1, arg2);
         this.delegate.defineParameterTypeBytes(arg0, arg1, arg2);
      } catch (SQLException var5) {
         this.onErrorVoidForAll(methodObject26683, var5);
      }
   }

   public void registerOutParameter(int arg0, int arg1, int arg2, int arg3) throws SQLException {
      try {
         super.preForAll(methodObject26409, this, arg0, arg1, arg2, arg3);
         this.delegate.registerOutParameter(arg0, arg1, arg2, arg3);
      } catch (SQLException var6) {
         this.onErrorVoidForAll(methodObject26409, var6);
      }
   }

   public void setBlob(String arg0, InputStream arg1, long arg2) throws SQLException {
      try {
         super.preForAll(methodObject26549, this, arg0, arg1, arg2);
         this.delegate.setBlob(arg0, arg1, arg2);
      } catch (SQLException var6) {
         this.onErrorVoidForAll(methodObject26549, var6);
      }
   }

   public void setDATEAtName(String arg0, DATE arg1) throws SQLException {
      try {
         super.preForAll(methodObject26713, this, arg0, arg1);
         this.delegate.setDATEAtName(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject26713, var4);
      }
   }

   public void clearWarnings() throws SQLException {
      try {
         super.preForAll(methodObject26641, this, zeroLengthObjectArray);
         this.delegate.clearWarnings();
      } catch (SQLException var2) {
         this.onErrorVoidForAll(methodObject26641, var2);
      }
   }

   public void setBytesForBlob(String arg0, byte[] arg1) throws SQLException {
      try {
         super.preForAll(methodObject26454, this, arg0, arg1);
         this.delegate.setBytesForBlob(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject26454, var4);
      }
   }

   public void setCHAR(int arg0, CHAR arg1) throws SQLException {
      try {
         super.preForAll(methodObject26770, this, arg0, arg1);
         this.delegate.setCHAR(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject26770, var4);
      }
   }

   public Object getCustomDatum(int arg0, CustomDatumFactory arg1) throws SQLException {
      try {
         super.preForAll(methodObject26427, this, arg0, arg1);
         return this.postForAll(methodObject26427, this.proxyFactory.proxyForCache(this.delegate.getCustomDatum(arg0, arg1), this, this.proxyCache, methodObject26427));
      } catch (SQLException var4) {
         return this.postForAll(methodObject26427, this.onErrorForAll(methodObject26427, var4));
      }
   }

   public void setBfile(int arg0, BFILE arg1) throws SQLException {
      try {
         super.preForAll(methodObject26776, this, arg0, arg1);
         this.delegate.setBfile(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject26776, var4);
      }
   }

   public void defineParameterType(int arg0, int arg1, int arg2) throws SQLException {
      try {
         super.preForAll(methodObject26685, this, arg0, arg1, arg2);
         this.delegate.defineParameterType(arg0, arg1, arg2);
      } catch (SQLException var5) {
         this.onErrorVoidForAll(methodObject26685, var5);
      }
   }

   public Object getObject(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject26485, this, arg0);
         return this.postForAll(methodObject26485, this.proxyFactory.proxyForCache(this.delegate.getObject(arg0), this, this.proxyCache, methodObject26485));
      } catch (SQLException var3) {
         return this.postForAll(methodObject26485, this.onErrorForAll(methodObject26485, var3));
      }
   }

   public void setCustomDatum(int arg0, CustomDatum arg1) throws SQLException {
      try {
         super.preForAll(methodObject26786, this, arg0, arg1);
         this.delegate.setCustomDatum(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject26786, var4);
      }
   }

   public ResultSetMetaData getMetaData() throws SQLException {
      try {
         super.preForAll(methodObject26599, this, zeroLengthObjectArray);
         return (ResultSetMetaData)this.postForAll(methodObject26599, this.proxyFactory.proxyForCreate((Object)this.delegate.getMetaData(), this, this.proxyCache, methodObject26599));
      } catch (SQLException var2) {
         return (ResultSetMetaData)this.postForAll(methodObject26599, this.onErrorForAll(methodObject26599, var2));
      }
   }

   public void setPoolable(boolean arg0) throws SQLException {
      try {
         super.preForAll(methodObject26661, this, arg0);
         this.delegate.setPoolable(arg0);
      } catch (SQLException var3) {
         this.onErrorVoidForAll(methodObject26661, var3);
      }
   }

   public void setNUMBER(String arg0, NUMBER arg1) throws SQLException {
      try {
         super.preForAll(methodObject26461, this, arg0, arg1);
         this.delegate.setNUMBER(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject26461, var4);
      }
   }

   public void setBLOBAtName(String arg0, BLOB arg1) throws SQLException {
      try {
         super.preForAll(methodObject26715, this, arg0, arg1);
         this.delegate.setBLOBAtName(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject26715, var4);
      }
   }

   public SQLXML getSQLXML(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject26535, this, arg0);
         return (SQLXML)this.postForAll(methodObject26535, this.proxyFactory.proxyForCreate((Object)this.delegate.getSQLXML(arg0), this, this.proxyCache, methodObject26535));
      } catch (SQLException var3) {
         return (SQLXML)this.postForAll(methodObject26535, this.onErrorForAll(methodObject26535, var3));
      }
   }

   public void setBinaryStream(String arg0, InputStream arg1) throws SQLException {
      try {
         super.preForSetStreams(methodObject26522, this, arg0, arg1);
         this.delegate.setBinaryStream(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject26522, var4);
      }
   }

   public void setNString(String arg0, String arg1) throws SQLException {
      try {
         super.preForAll(methodObject26556, this, arg0, arg1);
         this.delegate.setNString(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject26556, var4);
      }
   }

   public short getShort(String arg0) throws SQLException {
      try {
         super.preForAll(methodObject26496, this, arg0);
         return (Short)this.postForAll(methodObject26496, this.delegate.getShort(arg0));
      } catch (SQLException var3) {
         return (Short)this.postForAll(methodObject26496, this.onErrorForAll(methodObject26496, var3));
      }
   }

   public void defineColumnType(int arg0, int arg1, String arg2) throws SQLException {
      try {
         super.preForAll(methodObject26796, this, arg0, arg1, arg2);
         this.delegate.defineColumnType(arg0, arg1, arg2);
      } catch (SQLException var5) {
         this.onErrorVoidForAll(methodObject26796, var5);
      }
   }

   public Blob getBlob(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject26527, this, arg0);
         return (Blob)this.postForAll(methodObject26527, this.proxyFactory.proxyForCreate((Object)this.delegate.getBlob(arg0), this, this.proxyCache, methodObject26527));
      } catch (SQLException var3) {
         return (Blob)this.postForAll(methodObject26527, this.onErrorForAll(methodObject26527, var3));
      }
   }

   public ResultSet getGeneratedKeys() throws SQLException {
      try {
         super.preForAll(methodObject26646, this, zeroLengthObjectArray);
         return (ResultSet)this.postForAll(methodObject26646, this.proxyFactory.proxyForCache((Object)this.delegate.getGeneratedKeys(), this, this.proxyCache, methodObject26646));
      } catch (SQLException var2) {
         return (ResultSet)this.postForAll(methodObject26646, this.onErrorForAll(methodObject26646, var2));
      }
   }

   public void setURL(String arg0, URL arg1) throws SQLException {
      try {
         super.preForAll(methodObject26391, this, arg0, arg1);
         this.delegate.setURL(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject26391, var4);
      }
   }

   public Object getObject(String arg0, Class arg1) throws SQLException {
      try {
         super.preForAll(methodObject26490, this, arg0, arg1);
         return this.postForAll(methodObject26490, this.proxyFactory.proxyForCache(this.delegate.getObject(arg0, arg1), this, this.proxyCache, methodObject26490));
      } catch (SQLException var4) {
         return this.postForAll(methodObject26490, this.onErrorForAll(methodObject26490, var4));
      }
   }

   public boolean execute(String arg0, String[] arg1) throws SQLException {
      try {
         super.preForExecute(methodObject26629, this, arg0, arg1);
         return this.postForExecute(methodObject26629, this.delegate.execute(arg0, arg1));
      } catch (SQLException var4) {
         return this.postForExecute(methodObject26629, this.onErrorForExecute(methodObject26629, var4));
      }
   }

   public void setAsciiStreamAtName(String arg0, InputStream arg1, int arg2) throws SQLException {
      try {
         super.preForSetStreams(methodObject26669, this, arg0, arg1, arg2);
         this.delegate.setAsciiStreamAtName(arg0, arg1, arg2);
      } catch (SQLException var5) {
         this.onErrorVoidForAll(methodObject26669, var5);
      }
   }

   public String getNString(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject26564, this, arg0);
         return (String)this.postForAll(methodObject26564, (Object)this.delegate.getNString(arg0));
      } catch (SQLException var3) {
         return (String)this.postForAll(methodObject26564, this.onErrorForAll(methodObject26564, var3));
      }
   }

   public void registerOutParameter(int arg0, int arg1, int arg2) throws SQLException {
      try {
         super.preForAll(methodObject26544, this, arg0, arg1, arg2);
         this.delegate.registerOutParameter(arg0, arg1, arg2);
      } catch (SQLException var5) {
         this.onErrorVoidForAll(methodObject26544, var5);
      }
   }

   public int getFetchDirection() throws SQLException {
      try {
         super.preForAll(methodObject26663, this, zeroLengthObjectArray);
         return (Integer)this.postForAll(methodObject26663, this.delegate.getFetchDirection());
      } catch (SQLException var2) {
         return (Integer)this.postForAll(methodObject26663, this.onErrorForAll(methodObject26663, var2));
      }
   }

   public void setDATE(int arg0, DATE arg1) throws SQLException {
      try {
         super.preForAll(methodObject26771, this, arg0, arg1);
         this.delegate.setDATE(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject26771, var4);
      }
   }

   public void setBlob(int arg0, Blob arg1) throws SQLException {
      try {
         super.preForAll(methodObject26609, this, arg0, arg1);
         this.delegate.setBlob(arg0, arg1 instanceof _Proxy_ ? (Blob)((_Proxy_)arg1)._getDelegate_() : arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject26609, var4);
      }
   }

   public void setBlob(int arg0, InputStream arg1, long arg2) throws SQLException {
      try {
         super.preForAll(methodObject26610, this, arg0, arg1, arg2);
         this.delegate.setBlob(arg0, arg1, arg2);
      } catch (SQLException var6) {
         this.onErrorVoidForAll(methodObject26610, var6);
      }
   }

   public void setCharacterStream(int arg0, Reader arg1, long arg2) throws SQLException {
      try {
         super.preForSetStreams(methodObject26589, this, arg0, arg1, arg2);
         this.delegate.setCharacterStream(arg0, arg1, arg2);
      } catch (SQLException var6) {
         this.onErrorVoidForAll(methodObject26589, var6);
      }
   }

   public void setCursor(String arg0, ResultSet arg1) throws SQLException {
      try {
         super.preForAll(methodObject26456, this, arg0, arg1);
         this.delegate.setCursor(arg0, arg1 instanceof _Proxy_ ? (ResultSet)((_Proxy_)arg1)._getDelegate_() : arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject26456, var4);
      }
   }

   public void setPlsqlIndexTable(int arg0, Object arg1, int arg2, int arg3, int arg4, int arg5) throws SQLException {
      try {
         super.preForAll(methodObject26746, this, arg0, arg1, arg2, arg3, arg4, arg5);
         this.delegate.setPlsqlIndexTable(arg0, arg1 instanceof _Proxy_ ? (Object)((_Proxy_)arg1)._getDelegate_() : arg1, arg2, arg3, arg4, arg5);
      } catch (SQLException var8) {
         this.onErrorVoidForAll(methodObject26746, var8);
      }
   }

   public void registerOutParameterAtName(String arg0, int arg1) throws SQLException {
      try {
         super.preForAll(methodObject26480, this, arg0, arg1);
         this.delegate.registerOutParameterAtName(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject26480, var4);
      }
   }

   public void setUnicodeStream(String arg0, InputStream arg1, int arg2) throws SQLException {
      try {
         super.preForAll(methodObject26395, this, arg0, arg1, arg2);
         this.delegate.setUnicodeStream(arg0, arg1, arg2);
      } catch (SQLException var5) {
         this.onErrorVoidForAll(methodObject26395, var5);
      }
   }

   public void setBinaryDouble(int arg0, double arg1) throws SQLException {
      try {
         super.preForAll(methodObject26762, this, arg0, arg1);
         this.delegate.setBinaryDouble(arg0, arg1);
      } catch (SQLException var5) {
         this.onErrorVoidForAll(methodObject26762, var5);
      }
   }

   public void setSTRUCT(int arg0, STRUCT arg1) throws SQLException {
      try {
         super.preForAll(methodObject26785, this, arg0, arg1);
         this.delegate.setSTRUCT(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject26785, var4);
      }
   }

   public boolean getBoolean(String arg0) throws SQLException {
      try {
         super.preForAll(methodObject26492, this, arg0);
         return (Boolean)this.postForAll(methodObject26492, this.delegate.getBoolean(arg0));
      } catch (SQLException var3) {
         return (Boolean)this.postForAll(methodObject26492, this.onErrorForAll(methodObject26492, var3));
      }
   }

   public void setTimestamp(String arg0, Timestamp arg1, Calendar arg2) throws SQLException {
      try {
         super.preForAll(methodObject26390, this, arg0, arg1, arg2);
         this.delegate.setTimestamp(arg0, arg1, arg2);
      } catch (SQLException var5) {
         this.onErrorVoidForAll(methodObject26390, var5);
      }
   }

   public void setOracleObject(int arg0, Datum arg1) throws SQLException {
      try {
         super.preForAll(methodObject26790, this, arg0, arg1);
         this.delegate.setOracleObject(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject26790, var4);
      }
   }

   public void setBinaryFloat(String arg0, BINARY_FLOAT arg1) throws SQLException {
      try {
         super.preForAll(methodObject26449, this, arg0, arg1);
         this.delegate.setBinaryFloat(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject26449, var4);
      }
   }

   public void setBlob(int arg0, InputStream arg1) throws SQLException {
      try {
         super.preForAll(methodObject26611, this, arg0, arg1);
         this.delegate.setBlob(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject26611, var4);
      }
   }

   public void clearDefines() throws SQLException {
      try {
         super.preForAll(methodObject26792, this, zeroLengthObjectArray);
         this.delegate.clearDefines();
      } catch (SQLException var2) {
         this.onErrorVoidForAll(methodObject26792, var2);
      }
   }

   public void setBytesForBlob(int arg0, byte[] arg1) throws SQLException {
      try {
         super.preForAll(methodObject26765, this, arg0, arg1);
         this.delegate.setBytesForBlob(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject26765, var4);
      }
   }

   public void setRAWAtName(String arg0, RAW arg1) throws SQLException {
      try {
         super.preForAll(methodObject26711, this, arg0, arg1);
         this.delegate.setRAWAtName(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject26711, var4);
      }
   }

   public void setARRAY(String arg0, ARRAY arg1) throws SQLException {
      try {
         super.preForAll(methodObject26471, this, arg0, arg1);
         this.delegate.setARRAY(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject26471, var4);
      }
   }

   public void setREF(int arg0, REF arg1) throws SQLException {
      try {
         super.preForAll(methodObject26789, this, arg0, arg1);
         this.delegate.setREF(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject26789, var4);
      }
   }

   public void setCursor(int arg0, ResultSet arg1) throws SQLException {
      try {
         super.preForAll(methodObject26767, this, arg0, arg1);
         this.delegate.setCursor(arg0, arg1 instanceof _Proxy_ ? (ResultSet)((_Proxy_)arg1)._getDelegate_() : arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject26767, var4);
      }
   }

   public void setStructDescriptorAtName(String arg0, StructDescriptor arg1) throws SQLException {
      try {
         super.preForAll(methodObject26709, this, arg0, arg1);
         this.delegate.setStructDescriptorAtName(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject26709, var4);
      }
   }

   public BFILE getBFILE(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject26422, this, arg0);
         return (BFILE)this.postForAll(methodObject26422, (Object)this.delegate.getBFILE(arg0));
      } catch (SQLException var3) {
         return (BFILE)this.postForAll(methodObject26422, this.onErrorForAll(methodObject26422, var3));
      }
   }

   public String getNString(String arg0) throws SQLException {
      try {
         super.preForAll(methodObject26565, this, arg0);
         return (String)this.postForAll(methodObject26565, (Object)this.delegate.getNString(arg0));
      } catch (SQLException var3) {
         return (String)this.postForAll(methodObject26565, this.onErrorForAll(methodObject26565, var3));
      }
   }

   public InputStream getUnicodeStream(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject26418, this, arg0);
         return (InputStream)this.postForAll(methodObject26418, (Object)this.delegate.getUnicodeStream(arg0));
      } catch (SQLException var3) {
         return (InputStream)this.postForAll(methodObject26418, this.onErrorForAll(methodObject26418, var3));
      }
   }

   public void setObject(int arg0, Object arg1, int arg2) throws SQLException {
      try {
         super.preForSetObjects(methodObject26595, this, arg0, arg1, arg2);
         this.delegate.setObject(arg0, arg1 instanceof _Proxy_ ? (Object)((_Proxy_)arg1)._getDelegate_() : arg1, arg2);
      } catch (SQLException var5) {
         this.onErrorVoidForAll(methodObject26595, var5);
      }
   }

   public void setOPAQUE(int arg0, OPAQUE arg1) throws SQLException {
      try {
         super.preForAll(methodObject26783, this, arg0, arg1);
         this.delegate.setOPAQUE(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject26783, var4);
      }
   }

   public void setTimeAtName(String arg0, Time arg1) throws SQLException {
      try {
         super.preForAll(methodObject26729, this, arg0, arg1);
         this.delegate.setTimeAtName(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject26729, var4);
      }
   }

   public void setBoolean(String arg0, boolean arg1) throws SQLException {
      try {
         super.preForAll(methodObject26382, this, arg0, arg1);
         this.delegate.setBoolean(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject26382, var4);
      }
   }

   public void registerOutParameter(String arg0, int arg1, int arg2, int arg3) throws SQLException {
      try {
         super.preForAll(methodObject26410, this, arg0, arg1, arg2, arg3);
         this.delegate.registerOutParameter(arg0, arg1, arg2, arg3);
      } catch (SQLException var6) {
         this.onErrorVoidForAll(methodObject26410, var6);
      }
   }

   public NUMBER getNUMBER(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject26431, this, arg0);
         return (NUMBER)this.postForAll(methodObject26431, (Object)this.delegate.getNUMBER(arg0));
      } catch (SQLException var3) {
         return (NUMBER)this.postForAll(methodObject26431, this.onErrorForAll(methodObject26431, var3));
      }
   }

   public void setBFILEAtName(String arg0, BFILE arg1) throws SQLException {
      try {
         super.preForAll(methodObject26723, this, arg0, arg1);
         this.delegate.setBFILEAtName(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject26723, var4);
      }
   }

   public void cancel() throws SQLException {
      try {
         super.preForAll(methodObject26630, this, zeroLengthObjectArray);
         this.delegate.cancel();
      } catch (SQLException var2) {
         this.onErrorVoidForAll(methodObject26630, var2);
      }
   }

   public void setCHAR(String arg0, CHAR arg1) throws SQLException {
      try {
         super.preForAll(methodObject26459, this, arg0, arg1);
         this.delegate.setCHAR(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject26459, var4);
      }
   }

   public void setCharacterStream(String arg0, Reader arg1) throws SQLException {
      try {
         super.preForSetStreams(methodObject26524, this, arg0, arg1);
         this.delegate.setCharacterStream(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject26524, var4);
      }
   }

   public void setQueryTimeout(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject26662, this, arg0);
         this.delegate.setQueryTimeout(arg0);
      } catch (SQLException var3) {
         this.onErrorVoidForAll(methodObject26662, var3);
      }
   }

   public void setLobPrefetchSize(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject26802, this, arg0);
         this.delegate.setLobPrefetchSize(arg0);
      } catch (SQLException var3) {
         this.onErrorVoidForAll(methodObject26802, var3);
      }
   }

   public void closeWithKey(String arg0) throws SQLException {
      try {
         super.preForAll(methodObject26803, this, arg0);
         this.delegate.closeWithKey(arg0);
      } catch (SQLException var3) {
         this.onErrorVoidForAll(methodObject26803, var3);
      }
   }

   public InputStream getBinaryStream(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject26396, this, arg0);
         return (InputStream)this.postForAll(methodObject26396, (Object)this.delegate.getBinaryStream(arg0));
      } catch (SQLException var3) {
         return (InputStream)this.postForAll(methodObject26396, this.onErrorForAll(methodObject26396, var3));
      }
   }

   public Datum getOracleObject(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject26420, this, arg0);
         return (Datum)this.postForAll(methodObject26420, (Object)this.delegate.getOracleObject(arg0));
      } catch (SQLException var3) {
         return (Datum)this.postForAll(methodObject26420, this.onErrorForAll(methodObject26420, var3));
      }
   }

   public void setObject(String arg0, Object arg1, int arg2) throws SQLException {
      try {
         super.preForSetObjects(methodObject26400, this, arg0, arg1, arg2);
         this.delegate.setObject(arg0, arg1 instanceof _Proxy_ ? (Object)((_Proxy_)arg1)._getDelegate_() : arg1, arg2);
      } catch (SQLException var5) {
         this.onErrorVoidForAll(methodObject26400, var5);
      }
   }

   public void setRef(String arg0, Ref arg1) throws SQLException {
      try {
         super.preForAll(methodObject26417, this, arg0, arg1);
         this.delegate.setRef(arg0, arg1 instanceof _Proxy_ ? (Ref)((_Proxy_)arg1)._getDelegate_() : arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject26417, var4);
      }
   }

   public void setBlob(String arg0, InputStream arg1) throws SQLException {
      try {
         super.preForAll(methodObject26550, this, arg0, arg1);
         this.delegate.setBlob(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject26550, var4);
      }
   }

   public void setNCharacterStream(int arg0, Reader arg1, long arg2) throws SQLException {
      try {
         super.preForSetStreams(methodObject26591, this, arg0, arg1, arg2);
         this.delegate.setNCharacterStream(arg0, arg1, arg2);
      } catch (SQLException var6) {
         this.onErrorVoidForAll(methodObject26591, var6);
      }
   }

   public void setTIMESTAMPLTZ(int arg0, TIMESTAMPLTZ arg1) throws SQLException {
      try {
         super.preForAll(methodObject26781, this, arg0, arg1);
         this.delegate.setTIMESTAMPLTZ(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject26781, var4);
      }
   }

   public void setNClob(int arg0, NClob arg1) throws SQLException {
      try {
         super.preForAll(methodObject26615, this, arg0, arg1);
         this.delegate.setNClob(arg0, arg1 instanceof _Proxy_ ? (NClob)((_Proxy_)arg1)._getDelegate_() : arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject26615, var4);
      }
   }

   public void setORAData(String arg0, ORAData arg1) throws SQLException {
      try {
         super.preForAll(methodObject26476, this, arg0, arg1);
         this.delegate.setORAData(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject26476, var4);
      }
   }

   public void setSQLXML(String arg0, SQLXML arg1) throws SQLException {
      try {
         super.preForAll(methodObject26558, this, arg0, arg1);
         this.delegate.setSQLXML(arg0, arg1 instanceof _Proxy_ ? (SQLXML)((_Proxy_)arg1)._getDelegate_() : arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject26558, var4);
      }
   }

   public Time getTime(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject26537, this, arg0);
         return (Time)this.postForAll(methodObject26537, (Object)this.delegate.getTime(arg0));
      } catch (SQLException var3) {
         return (Time)this.postForAll(methodObject26537, this.onErrorForAll(methodObject26537, var3));
      }
   }

   public void setDate(int arg0, Date arg1) throws SQLException {
      try {
         super.preForAll(methodObject26603, this, arg0, arg1);
         this.delegate.setDate(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject26603, var4);
      }
   }

   public void setLong(String arg0, long arg1) throws SQLException {
      try {
         super.preForAll(methodObject26387, this, arg0, arg1);
         this.delegate.setLong(arg0, arg1);
      } catch (SQLException var5) {
         this.onErrorVoidForAll(methodObject26387, var5);
      }
   }

   public int executeUpdate(String arg0, int arg1) throws SQLException {
      try {
         super.preForExecuteUpdate(methodObject26634, this, arg0, arg1);
         return this.postForExecuteUpdate(methodObject26634, this.delegate.executeUpdate(arg0, arg1));
      } catch (SQLException var4) {
         return this.postForExecuteUpdate(methodObject26634, (Integer)this.onErrorForAll(methodObject26634, var4));
      }
   }

   public void setCharacterStream(String arg0, Reader arg1, int arg2) throws SQLException {
      try {
         super.preForSetStreams(methodObject26394, this, arg0, arg1, arg2);
         this.delegate.setCharacterStream(arg0, arg1, arg2);
      } catch (SQLException var5) {
         this.onErrorVoidForAll(methodObject26394, var5);
      }
   }

   public void registerOutParameterBytes(int arg0, int arg1, int arg2, int arg3) throws SQLException {
      try {
         super.preForAll(methodObject26442, this, arg0, arg1, arg2, arg3);
         this.delegate.registerOutParameterBytes(arg0, arg1, arg2, arg3);
      } catch (SQLException var6) {
         this.onErrorVoidForAll(methodObject26442, var6);
      }
   }

   public void setBinaryDouble(String arg0, BINARY_DOUBLE arg1) throws SQLException {
      try {
         super.preForAll(methodObject26451, this, arg0, arg1);
         this.delegate.setBinaryDouble(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject26451, var4);
      }
   }

   public void setByteAtName(String arg0, byte arg1) throws SQLException {
      try {
         super.preForAll(methodObject26690, this, arg0, arg1);
         this.delegate.setByteAtName(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject26690, var4);
      }
   }

   public void setDateAtName(String arg0, Date arg1, Calendar arg2) throws SQLException {
      try {
         super.preForAll(methodObject26728, this, arg0, arg1, arg2);
         this.delegate.setDateAtName(arg0, arg1, arg2);
      } catch (SQLException var5) {
         this.onErrorVoidForAll(methodObject26728, var5);
      }
   }

   public BigDecimal getBigDecimal(int arg0, int arg1) throws SQLException {
      try {
         super.preForAll(methodObject26559, this, arg0, arg1);
         return (BigDecimal)this.postForAll(methodObject26559, (Object)this.delegate.getBigDecimal(arg0, arg1));
      } catch (SQLException var4) {
         return (BigDecimal)this.postForAll(methodObject26559, this.onErrorForAll(methodObject26559, var4));
      }
   }

   public void setBytesForBlobAtName(String arg0, byte[] arg1) throws SQLException {
      try {
         super.preForAll(methodObject26726, this, arg0, arg1);
         this.delegate.setBytesForBlobAtName(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject26726, var4);
      }
   }

   public ResultSet executeQuery(String arg0) throws SQLException {
      try {
         super.preForAll(methodObject26638, this, arg0);
         return this.postForExecuteQuery(methodObject26638, (ResultSet)this.proxyFactory.proxyForCreateCache((Object)this.delegate.executeQuery(arg0), this, this.proxyCache, methodObject26638));
      } catch (SQLException var3) {
         return this.postForExecuteQuery(methodObject26638, (ResultSet)this.onErrorForAll(methodObject26638, var3));
      }
   }

   public void setFloat(int arg0, float arg1) throws SQLException {
      try {
         super.preForAll(methodObject26573, this, arg0, arg1);
         this.delegate.setFloat(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject26573, var4);
      }
   }

   public void setRowIdAtName(String arg0, RowId arg1) throws SQLException {
      try {
         super.preForAll(methodObject26758, this, arg0, arg1);
         this.delegate.setRowIdAtName(arg0, arg1 instanceof _Proxy_ ? (RowId)((_Proxy_)arg1)._getDelegate_() : arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject26758, var4);
      }
   }

   public void registerOutParameter(int arg0, int arg1) throws SQLException {
      try {
         super.preForAll(methodObject26543, this, arg0, arg1);
         this.delegate.registerOutParameter(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject26543, var4);
      }
   }

   public void setBFILE(int arg0, BFILE arg1) throws SQLException {
      try {
         super.preForAll(methodObject26775, this, arg0, arg1);
         this.delegate.setBFILE(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject26775, var4);
      }
   }

   public void setSQLXML(int arg0, SQLXML arg1) throws SQLException {
      try {
         super.preForAll(methodObject26622, this, arg0, arg1);
         this.delegate.setSQLXML(arg0, arg1 instanceof _Proxy_ ? (SQLXML)((_Proxy_)arg1)._getDelegate_() : arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject26622, var4);
      }
   }

   public void setRefTypeAtName(String arg0, REF arg1) throws SQLException {
      try {
         super.preForAll(methodObject26740, this, arg0, arg1);
         this.delegate.setRefTypeAtName(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject26740, var4);
      }
   }

   public void setStructDescriptor(int arg0, StructDescriptor arg1) throws SQLException {
      try {
         super.preForAll(methodObject26784, this, arg0, arg1);
         this.delegate.setStructDescriptor(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject26784, var4);
      }
   }

   public int getMaxRows() throws SQLException {
      try {
         super.preForAll(methodObject26648, this, zeroLengthObjectArray);
         return (Integer)this.postForAll(methodObject26648, this.delegate.getMaxRows());
      } catch (SQLException var2) {
         return (Integer)this.postForAll(methodObject26648, this.onErrorForAll(methodObject26648, var2));
      }
   }

   public void addBatch() throws SQLException {
      try {
         super.preForAll(methodObject26606, this, zeroLengthObjectArray);
         this.delegate.addBatch();
      } catch (SQLException var2) {
         this.onErrorVoidForAll(methodObject26606, var2);
      }
   }

   public Ref getRef(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject26511, this, arg0);
         return (Ref)this.postForAll(methodObject26511, this.proxyFactory.proxyForCreate((Object)this.delegate.getRef(arg0), this, this.proxyCache, methodObject26511));
      } catch (SQLException var3) {
         return (Ref)this.postForAll(methodObject26511, this.onErrorForAll(methodObject26511, var3));
      }
   }

   public Object getPlsqlIndexTable(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject26445, this, arg0);
         return this.postForAll(methodObject26445, this.proxyFactory.proxyForCache(this.delegate.getPlsqlIndexTable(arg0), this, this.proxyCache, methodObject26445));
      } catch (SQLException var3) {
         return this.postForAll(methodObject26445, this.onErrorForAll(methodObject26445, var3));
      }
   }

   public Date getDate(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject26515, this, arg0);
         return (Date)this.postForAll(methodObject26515, (Object)this.delegate.getDate(arg0));
      } catch (SQLException var3) {
         return (Date)this.postForAll(methodObject26515, this.onErrorForAll(methodObject26515, var3));
      }
   }

   public void setDisableStmtCaching(boolean arg0) {
      super.preForAll(methodObject26748, this, arg0);
      this.delegate.setDisableStmtCaching(arg0);
   }

   public int getQueryTimeout() throws SQLException {
      try {
         super.preForAll(methodObject26651, this, zeroLengthObjectArray);
         return (Integer)this.postForAll(methodObject26651, this.delegate.getQueryTimeout());
      } catch (SQLException var2) {
         return (Integer)this.postForAll(methodObject26651, this.onErrorForAll(methodObject26651, var2));
      }
   }

   public void setURL(int arg0, URL arg1) throws SQLException {
      try {
         super.preForAll(methodObject26579, this, arg0, arg1);
         this.delegate.setURL(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject26579, var4);
      }
   }

   public void setNClob(int arg0, Reader arg1) throws SQLException {
      try {
         super.preForAll(methodObject26617, this, arg0, arg1);
         this.delegate.setNClob(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject26617, var4);
      }
   }

   public void setStringForClobAtName(String arg0, String arg1) throws SQLException {
      try {
         super.preForAll(methodObject26702, this, arg0, arg1);
         this.delegate.setStringForClobAtName(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject26702, var4);
      }
   }

   public void setBigDecimal(int arg0, BigDecimal arg1) throws SQLException {
      try {
         super.preForAll(methodObject26608, this, arg0, arg1);
         this.delegate.setBigDecimal(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject26608, var4);
      }
   }

   public void setNull(int arg0, int arg1, String arg2) throws SQLException {
      try {
         super.preForAll(methodObject26620, this, arg0, arg1, arg2);
         this.delegate.setNull(arg0, arg1, arg2);
      } catch (SQLException var5) {
         this.onErrorVoidForAll(methodObject26620, var5);
      }
   }

   public Date getDate(int arg0, Calendar arg1) throws SQLException {
      try {
         super.preForAll(methodObject26516, this, arg0, arg1);
         return (Date)this.postForAll(methodObject26516, (Object)this.delegate.getDate(arg0, arg1));
      } catch (SQLException var4) {
         return (Date)this.postForAll(methodObject26516, this.onErrorForAll(methodObject26516, var4));
      }
   }

   public void setNClob(String arg0, Reader arg1) throws SQLException {
      try {
         super.preForAll(methodObject26555, this, arg0, arg1);
         this.delegate.setNClob(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject26555, var4);
      }
   }

   public REF getREF(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject26434, this, arg0);
         return (REF)this.postForAll(methodObject26434, (Object)this.delegate.getREF(arg0));
      } catch (SQLException var3) {
         return (REF)this.postForAll(methodObject26434, this.onErrorForAll(methodObject26434, var3));
      }
   }

   public void setBooleanAtName(String arg0, boolean arg1) throws SQLException {
      try {
         super.preForAll(methodObject26689, this, arg0, arg1);
         this.delegate.setBooleanAtName(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject26689, var4);
      }
   }

   public void setBfile(String arg0, BFILE arg1) throws SQLException {
      try {
         super.preForAll(methodObject26465, this, arg0, arg1);
         this.delegate.setBfile(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject26465, var4);
      }
   }

   public Array getArray(String arg0) throws SQLException {
      try {
         super.preForAll(methodObject26508, this, arg0);
         return (Array)this.postForAll(methodObject26508, this.proxyFactory.proxyForCreate((Object)this.delegate.getArray(arg0), this, this.proxyCache, methodObject26508));
      } catch (SQLException var3) {
         return (Array)this.postForAll(methodObject26508, this.onErrorForAll(methodObject26508, var3));
      }
   }

   public void registerReturnParameter(int arg0, int arg1, String arg2) throws SQLException {
      try {
         super.preForAll(methodObject26752, this, arg0, arg1, arg2);
         this.delegate.registerReturnParameter(arg0, arg1, arg2);
      } catch (SQLException var5) {
         this.onErrorVoidForAll(methodObject26752, var5);
      }
   }

   public void setDate(String arg0, Date arg1, Calendar arg2) throws SQLException {
      try {
         super.preForAll(methodObject26405, this, arg0, arg1, arg2);
         this.delegate.setDate(arg0, arg1, arg2);
      } catch (SQLException var5) {
         this.onErrorVoidForAll(methodObject26405, var5);
      }
   }

   public void setCheckBindTypes(boolean arg0) {
      super.preForAll(methodObject26745, this, arg0);
      this.delegate.setCheckBindTypes(arg0);
   }

   public byte getByte(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject26493, this, arg0);
         return (Byte)this.postForAll(methodObject26493, this.delegate.getByte(arg0));
      } catch (SQLException var3) {
         return (Byte)this.postForAll(methodObject26493, this.onErrorForAll(methodObject26493, var3));
      }
   }

   public ARRAY getARRAY(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject26484, this, arg0);
         return (ARRAY)this.postForAll(methodObject26484, (Object)this.delegate.getARRAY(arg0));
      } catch (SQLException var3) {
         return (ARRAY)this.postForAll(methodObject26484, this.onErrorForAll(methodObject26484, var3));
      }
   }

   public void setBFILE(String arg0, BFILE arg1) throws SQLException {
      try {
         super.preForAll(methodObject26464, this, arg0, arg1);
         this.delegate.setBFILE(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject26464, var4);
      }
   }

   public BFILE getBfile(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject26423, this, arg0);
         return (BFILE)this.postForAll(methodObject26423, (Object)this.delegate.getBfile(arg0));
      } catch (SQLException var3) {
         return (BFILE)this.postForAll(methodObject26423, this.onErrorForAll(methodObject26423, var3));
      }
   }

   public int creationState() {
      super.preForAll(methodObject26804, this, zeroLengthObjectArray);
      return (Integer)this.postForAll(methodObject26804, this.delegate.creationState());
   }

   public Clob getClob(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject26529, this, arg0);
         return (Clob)this.postForAll(methodObject26529, this.proxyFactory.proxyForCreate((Object)this.delegate.getClob(arg0), this, this.proxyCache, methodObject26529));
      } catch (SQLException var3) {
         return (Clob)this.postForAll(methodObject26529, this.onErrorForAll(methodObject26529, var3));
      }
   }

   public void setRefType(String arg0, REF arg1) throws SQLException {
      try {
         super.preForAll(methodObject26477, this, arg0, arg1);
         this.delegate.setRefType(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject26477, var4);
      }
   }

   public void setBlobAtName(String arg0, InputStream arg1) throws SQLException {
      try {
         super.preForAll(methodObject26718, this, arg0, arg1);
         this.delegate.setBlobAtName(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject26718, var4);
      }
   }

   public double getDouble(String arg0) throws SQLException {
      try {
         super.preForAll(methodObject26504, this, arg0);
         return (Double)this.postForAll(methodObject26504, this.delegate.getDouble(arg0));
      } catch (SQLException var3) {
         return (Double)this.postForAll(methodObject26504, this.onErrorForAll(methodObject26504, var3));
      }
   }

   public Object getObject(int arg0, Class arg1) throws SQLException {
      try {
         super.preForAll(methodObject26489, this, arg0, arg1);
         return this.postForAll(methodObject26489, this.proxyFactory.proxyForCache(this.delegate.getObject(arg0, arg1), this, this.proxyCache, methodObject26489));
      } catch (SQLException var4) {
         return this.postForAll(methodObject26489, this.onErrorForAll(methodObject26489, var4));
      }
   }

   public void setNUMBER(int arg0, NUMBER arg1) throws SQLException {
      try {
         super.preForAll(methodObject26772, this, arg0, arg1);
         this.delegate.setNUMBER(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject26772, var4);
      }
   }

   public Timestamp getTimestamp(int arg0, Calendar arg1) throws SQLException {
      try {
         super.preForAll(methodObject26567, this, arg0, arg1);
         return (Timestamp)this.postForAll(methodObject26567, (Object)this.delegate.getTimestamp(arg0, arg1));
      } catch (SQLException var4) {
         return (Timestamp)this.postForAll(methodObject26567, this.onErrorForAll(methodObject26567, var4));
      }
   }

   public void registerOutParameterAtName(String arg0, int arg1, String arg2) throws SQLException {
      try {
         super.preForAll(methodObject26482, this, arg0, arg1, arg2);
         this.delegate.registerOutParameterAtName(arg0, arg1, arg2);
      } catch (SQLException var5) {
         this.onErrorVoidForAll(methodObject26482, var5);
      }
   }

   public InputStream getAsciiStream(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject26406, this, arg0);
         return (InputStream)this.postForAll(methodObject26406, (Object)this.delegate.getAsciiStream(arg0));
      } catch (SQLException var3) {
         return (InputStream)this.postForAll(methodObject26406, this.onErrorForAll(methodObject26406, var3));
      }
   }

   public void setAsciiStream(String arg0, InputStream arg1, int arg2) throws SQLException {
      try {
         super.preForSetStreams(methodObject26392, this, arg0, arg1, arg2);
         this.delegate.setAsciiStream(arg0, arg1, arg2);
      } catch (SQLException var5) {
         this.onErrorVoidForAll(methodObject26392, var5);
      }
   }

   public void setOracleObjectAtName(String arg0, Datum arg1) throws SQLException {
      try {
         super.preForAll(methodObject26743, this, arg0, arg1);
         this.delegate.setOracleObjectAtName(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject26743, var4);
      }
   }

   public void setBigDecimalAtName(String arg0, BigDecimal arg1) throws SQLException {
      try {
         super.preForAll(methodObject26700, this, arg0, arg1);
         this.delegate.setBigDecimalAtName(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject26700, var4);
      }
   }

   public void setRAW(String arg0, RAW arg1) throws SQLException {
      try {
         super.preForAll(methodObject26458, this, arg0, arg1);
         this.delegate.setRAW(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject26458, var4);
      }
   }

   public byte getByte(String arg0) throws SQLException {
      try {
         super.preForAll(methodObject26494, this, arg0);
         return (Byte)this.postForAll(methodObject26494, this.delegate.getByte(arg0));
      } catch (SQLException var3) {
         return (Byte)this.postForAll(methodObject26494, this.onErrorForAll(methodObject26494, var3));
      }
   }

   public void setBinaryStreamAtName(String arg0, InputStream arg1) throws SQLException {
      try {
         super.preForSetStreams(methodObject26674, this, arg0, arg1);
         this.delegate.setBinaryStreamAtName(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject26674, var4);
      }
   }

   public void setREFAtName(String arg0, REF arg1) throws SQLException {
      try {
         super.preForAll(methodObject26742, this, arg0, arg1);
         this.delegate.setREFAtName(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject26742, var4);
      }
   }

   public void clearBatch() throws SQLException {
      try {
         super.preForAll(methodObject26644, this, zeroLengthObjectArray);
         this.delegate.clearBatch();
      } catch (SQLException var2) {
         this.onErrorVoidForAll(methodObject26644, var2);
      }
   }

   public boolean getMoreResults(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject26650, this, arg0);
         return (Boolean)this.postForAll(methodObject26650, this.delegate.getMoreResults(arg0));
      } catch (SQLException var3) {
         return (Boolean)this.postForAll(methodObject26650, this.onErrorForAll(methodObject26650, var3));
      }
   }

   public Timestamp getTimestamp(String arg0) throws SQLException {
      try {
         super.preForAll(methodObject26568, this, arg0);
         return (Timestamp)this.postForAll(methodObject26568, (Object)this.delegate.getTimestamp(arg0));
      } catch (SQLException var3) {
         return (Timestamp)this.postForAll(methodObject26568, this.onErrorForAll(methodObject26568, var3));
      }
   }

   public void setArray(int arg0, Array arg1) throws SQLException {
      try {
         super.preForAll(methodObject26623, this, arg0, arg1);
         this.delegate.setArray(arg0, arg1 instanceof _Proxy_ ? (Array)((_Proxy_)arg1)._getDelegate_() : arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject26623, var4);
      }
   }

   public STRUCT getSTRUCT(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject26436, this, arg0);
         return (STRUCT)this.postForAll(methodObject26436, (Object)this.delegate.getSTRUCT(arg0));
      } catch (SQLException var3) {
         return (STRUCT)this.postForAll(methodObject26436, this.onErrorForAll(methodObject26436, var3));
      }
   }

   public void setAsciiStream(int arg0, InputStream arg1, int arg2) throws SQLException {
      try {
         super.preForSetStreams(methodObject26582, this, arg0, arg1, arg2);
         this.delegate.setAsciiStream(arg0, arg1, arg2);
      } catch (SQLException var5) {
         this.onErrorVoidForAll(methodObject26582, var5);
      }
   }

   public void defineColumnTypeChars(int arg0, int arg1, int arg2) throws SQLException {
      try {
         super.preForAll(methodObject26798, this, arg0, arg1, arg2);
         this.delegate.defineColumnTypeChars(arg0, arg1, arg2);
      } catch (SQLException var5) {
         this.onErrorVoidForAll(methodObject26798, var5);
      }
   }

   public Clob getClob(String arg0) throws SQLException {
      try {
         super.preForAll(methodObject26530, this, arg0);
         return (Clob)this.postForAll(methodObject26530, this.proxyFactory.proxyForCreate((Object)this.delegate.getClob(arg0), this, this.proxyCache, methodObject26530));
      } catch (SQLException var3) {
         return (Clob)this.postForAll(methodObject26530, this.onErrorForAll(methodObject26530, var3));
      }
   }

   public TIMESTAMPLTZ getTIMESTAMPLTZ(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject26441, this, arg0);
         return (TIMESTAMPLTZ)this.postForAll(methodObject26441, (Object)this.delegate.getTIMESTAMPLTZ(arg0));
      } catch (SQLException var3) {
         return (TIMESTAMPLTZ)this.postForAll(methodObject26441, this.onErrorForAll(methodObject26441, var3));
      }
   }

   public void setTime(int arg0, Time arg1) throws SQLException {
      try {
         super.preForAll(methodObject26601, this, arg0, arg1);
         this.delegate.setTime(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject26601, var4);
      }
   }

   public void setREF(String arg0, REF arg1) throws SQLException {
      try {
         super.preForAll(methodObject26478, this, arg0, arg1);
         this.delegate.setREF(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject26478, var4);
      }
   }

   public void registerIndexTableOutParameter(int arg0, int arg1, int arg2, int arg3) throws SQLException {
      try {
         super.preForAll(methodObject26448, this, arg0, arg1, arg2, arg3);
         this.delegate.registerIndexTableOutParameter(arg0, arg1, arg2, arg3);
      } catch (SQLException var6) {
         this.onErrorVoidForAll(methodObject26448, var6);
      }
   }

   public float getFloat(String arg0) throws SQLException {
      try {
         super.preForAll(methodObject26502, this, arg0);
         return (Float)this.postForAll(methodObject26502, this.delegate.getFloat(arg0));
      } catch (SQLException var3) {
         return (Float)this.postForAll(methodObject26502, this.onErrorForAll(methodObject26502, var3));
      }
   }

   public void setClobAtName(String arg0, Clob arg1) throws SQLException {
      try {
         super.preForAll(methodObject26720, this, arg0, arg1);
         this.delegate.setClobAtName(arg0, arg1 instanceof _Proxy_ ? (Clob)((_Proxy_)arg1)._getDelegate_() : arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject26720, var4);
      }
   }

   public void setCustomDatum(String arg0, CustomDatum arg1) throws SQLException {
      try {
         super.preForAll(methodObject26475, this, arg0, arg1);
         this.delegate.setCustomDatum(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject26475, var4);
      }
   }

   public void setFetchSize(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject26666, this, arg0);
         this.delegate.setFetchSize(arg0);
      } catch (SQLException var3) {
         this.onErrorVoidForAll(methodObject26666, var3);
      }
   }

   public int getFetchSize() throws SQLException {
      try {
         super.preForAll(methodObject26664, this, zeroLengthObjectArray);
         return (Integer)this.postForAll(methodObject26664, this.delegate.getFetchSize());
      } catch (SQLException var2) {
         return (Integer)this.postForAll(methodObject26664, this.onErrorForAll(methodObject26664, var2));
      }
   }

   public void setCursorName(String arg0) throws SQLException {
      try {
         super.preForAll(methodObject26657, this, arg0);
         this.delegate.setCursorName(arg0);
      } catch (SQLException var3) {
         this.onErrorVoidForAll(methodObject26657, var3);
      }
   }

   public void setBytes(int arg0, byte[] arg1) throws SQLException {
      try {
         super.preForAll(methodObject26594, this, arg0, arg1);
         this.delegate.setBytes(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject26594, var4);
      }
   }

   public void setTime(String arg0, Time arg1) throws SQLException {
      try {
         super.preForAll(methodObject26402, this, arg0, arg1);
         this.delegate.setTime(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject26402, var4);
      }
   }

   public void setBinaryStream(int arg0, InputStream arg1, int arg2) throws SQLException {
      try {
         super.preForSetStreams(methodObject26585, this, arg0, arg1, arg2);
         this.delegate.setBinaryStream(arg0, arg1, arg2);
      } catch (SQLException var5) {
         this.onErrorVoidForAll(methodObject26585, var5);
      }
   }

   public String[] getRegisteredTableNames() throws SQLException {
      try {
         super.preForAll(methodObject26806, this, zeroLengthObjectArray);
         return (String[])this.postForAll(methodObject26806, (Object)this.delegate.getRegisteredTableNames());
      } catch (SQLException var2) {
         return (String[])this.postForAll(methodObject26806, this.onErrorForAll(methodObject26806, var2));
      }
   }

   public void setCharacterStream(String arg0, Reader arg1, long arg2) throws SQLException {
      try {
         super.preForSetStreams(methodObject26523, this, arg0, arg1, arg2);
         this.delegate.setCharacterStream(arg0, arg1, arg2);
      } catch (SQLException var6) {
         this.onErrorVoidForAll(methodObject26523, var6);
      }
   }

   public void clearParameters() throws SQLException {
      try {
         super.preForAll(methodObject26607, this, zeroLengthObjectArray);
         this.delegate.clearParameters();
      } catch (SQLException var2) {
         this.onErrorVoidForAll(methodObject26607, var2);
      }
   }

   public Object getObject(String arg0, Map arg1) throws SQLException {
      try {
         super.preForAll(methodObject26488, this, arg0, arg1);
         return this.postForAll(methodObject26488, this.proxyFactory.proxyForCache(this.delegate.getObject(arg0, arg1), this, this.proxyCache, methodObject26488));
      } catch (SQLException var4) {
         return this.postForAll(methodObject26488, this.onErrorForAll(methodObject26488, var4));
      }
   }

   public boolean isWrapperFor(Class arg0) throws SQLException {
      try {
         super.preForAll(methodObject26668, this, arg0);
         return (Boolean)this.postForAll(methodObject26668, this.delegate.isWrapperFor(arg0));
      } catch (SQLException var3) {
         return (Boolean)this.postForAll(methodObject26668, this.onErrorForAll(methodObject26668, var3));
      }
   }

   public void setINTERVALDS(String arg0, INTERVALDS arg1) throws SQLException {
      try {
         super.preForAll(methodObject26467, this, arg0, arg1);
         this.delegate.setINTERVALDS(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject26467, var4);
      }
   }

   public void setARRAYAtName(String arg0, ARRAY arg1) throws SQLException {
      try {
         super.preForAll(methodObject26707, this, arg0, arg1);
         this.delegate.setARRAYAtName(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject26707, var4);
      }
   }

   public void setBlob(String arg0, Blob arg1) throws SQLException {
      try {
         super.preForAll(methodObject26412, this, arg0, arg1);
         this.delegate.setBlob(arg0, arg1 instanceof _Proxy_ ? (Blob)((_Proxy_)arg1)._getDelegate_() : arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject26412, var4);
      }
   }

   public boolean execute() throws SQLException {
      try {
         super.preForExecute(methodObject26580, this, zeroLengthObjectArray);
         return this.postForExecute(methodObject26580, this.delegate.execute());
      } catch (SQLException var2) {
         return this.postForExecute(methodObject26580, this.onErrorForExecute(methodObject26580, var2));
      }
   }

   public void setCharacterStreamAtName(String arg0, Reader arg1) throws SQLException {
      try {
         super.preForSetStreams(methodObject26676, this, arg0, arg1);
         this.delegate.setCharacterStreamAtName(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject26676, var4);
      }
   }

   public Reader getCharacterStream(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject26407, this, arg0);
         return (Reader)this.postForAll(methodObject26407, (Object)this.delegate.getCharacterStream(arg0));
      } catch (SQLException var3) {
         return (Reader)this.postForAll(methodObject26407, this.onErrorForAll(methodObject26407, var3));
      }
   }

   public RowId getRowId(String arg0) throws SQLException {
      try {
         super.preForAll(methodObject26534, this, arg0);
         return (RowId)this.postForAll(methodObject26534, this.proxyFactory.proxyForCreate((Object)this.delegate.getRowId(arg0), this, this.proxyCache, methodObject26534));
      } catch (SQLException var3) {
         return (RowId)this.postForAll(methodObject26534, this.onErrorForAll(methodObject26534, var3));
      }
   }

   public void setCustomDatumAtName(String arg0, CustomDatum arg1) throws SQLException {
      try {
         super.preForAll(methodObject26738, this, arg0, arg1);
         this.delegate.setCustomDatumAtName(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject26738, var4);
      }
   }

   public void setClob(String arg0, Reader arg1) throws SQLException {
      try {
         super.preForAll(methodObject26552, this, arg0, arg1);
         this.delegate.setClob(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject26552, var4);
      }
   }

   public void registerOutParameter(int arg0, int arg1, String arg2) throws SQLException {
      try {
         super.preForAll(methodObject26545, this, arg0, arg1, arg2);
         this.delegate.registerOutParameter(arg0, arg1, arg2);
      } catch (SQLException var5) {
         this.onErrorVoidForAll(methodObject26545, var5);
      }
   }

   public void setURLAtName(String arg0, URL arg1) throws SQLException {
      try {
         super.preForAll(methodObject26744, this, arg0, arg1);
         this.delegate.setURLAtName(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject26744, var4);
      }
   }

   public void setBinaryStream(String arg0, InputStream arg1, long arg2) throws SQLException {
      try {
         super.preForSetStreams(methodObject26521, this, arg0, arg1, arg2);
         this.delegate.setBinaryStream(arg0, arg1, arg2);
      } catch (SQLException var6) {
         this.onErrorVoidForAll(methodObject26521, var6);
      }
   }

   public Datum[] getOraclePlsqlIndexTable(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject26447, this, arg0);
         return (Datum[])this.postForAll(methodObject26447, (Object)this.delegate.getOraclePlsqlIndexTable(arg0));
      } catch (SQLException var3) {
         return (Datum[])this.postForAll(methodObject26447, this.onErrorForAll(methodObject26447, var3));
      }
   }

   public void registerOutParameter(String arg0, int arg1, String arg2) throws SQLException {
      try {
         super.preForAll(methodObject26548, this, arg0, arg1, arg2);
         this.delegate.registerOutParameter(arg0, arg1, arg2);
      } catch (SQLException var5) {
         this.onErrorVoidForAll(methodObject26548, var5);
      }
   }

   public void setCharacterStreamAtName(String arg0, Reader arg1, long arg2) throws SQLException {
      try {
         super.preForSetStreams(methodObject26675, this, arg0, arg1, arg2);
         this.delegate.setCharacterStreamAtName(arg0, arg1, arg2);
      } catch (SQLException var6) {
         this.onErrorVoidForAll(methodObject26675, var6);
      }
   }

   public int getInt(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject26497, this, arg0);
         return (Integer)this.postForAll(methodObject26497, this.delegate.getInt(arg0));
      } catch (SQLException var3) {
         return (Integer)this.postForAll(methodObject26497, this.onErrorForAll(methodObject26497, var3));
      }
   }

   public void setCHARAtName(String arg0, CHAR arg1) throws SQLException {
      try {
         super.preForAll(methodObject26712, this, arg0, arg1);
         this.delegate.setCHARAtName(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject26712, var4);
      }
   }

   public Time getTime(String arg0, Calendar arg1) throws SQLException {
      try {
         super.preForAll(methodObject26540, this, arg0, arg1);
         return (Time)this.postForAll(methodObject26540, (Object)this.delegate.getTime(arg0, arg1));
      } catch (SQLException var4) {
         return (Time)this.postForAll(methodObject26540, this.onErrorForAll(methodObject26540, var4));
      }
   }

   public InputStream getUnicodeStream(String arg0) throws SQLException {
      try {
         super.preForAll(methodObject26419, this, arg0);
         return (InputStream)this.postForAll(methodObject26419, (Object)this.delegate.getUnicodeStream(arg0));
      } catch (SQLException var3) {
         return (InputStream)this.postForAll(methodObject26419, this.onErrorForAll(methodObject26419, var3));
      }
   }

   public int getExecuteBatch() {
      super.preForAll(methodObject26686, this, zeroLengthObjectArray);
      return (Integer)this.postForAll(methodObject26686, this.delegate.getExecuteBatch());
   }

   public void setNUMBERAtName(String arg0, NUMBER arg1) throws SQLException {
      try {
         super.preForAll(methodObject26714, this, arg0, arg1);
         this.delegate.setNUMBERAtName(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject26714, var4);
      }
   }

   public void setINTERVALDS(int arg0, INTERVALDS arg1) throws SQLException {
      try {
         super.preForAll(methodObject26778, this, arg0, arg1);
         this.delegate.setINTERVALDS(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject26778, var4);
      }
   }

   public void setNClobAtName(String arg0, Reader arg1, long arg2) throws SQLException {
      try {
         super.preForAll(methodObject26755, this, arg0, arg1, arg2);
         this.delegate.setNClobAtName(arg0, arg1, arg2);
      } catch (SQLException var6) {
         this.onErrorVoidForAll(methodObject26755, var6);
      }
   }

   public void setOPAQUEAtName(String arg0, OPAQUE arg1) throws SQLException {
      try {
         super.preForAll(methodObject26708, this, arg0, arg1);
         this.delegate.setOPAQUEAtName(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject26708, var4);
      }
   }

   public void setRowId(int arg0, RowId arg1) throws SQLException {
      try {
         super.preForAll(methodObject26621, this, arg0, arg1);
         this.delegate.setRowId(arg0, arg1 instanceof _Proxy_ ? (RowId)((_Proxy_)arg1)._getDelegate_() : arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject26621, var4);
      }
   }

   public void setTIMESTAMPTZ(int arg0, TIMESTAMPTZ arg1) throws SQLException {
      try {
         super.preForAll(methodObject26780, this, arg0, arg1);
         this.delegate.setTIMESTAMPTZ(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject26780, var4);
      }
   }

   public Object getPlsqlIndexTable(int arg0, Class arg1) throws SQLException {
      try {
         super.preForAll(methodObject26446, this, arg0, arg1);
         return this.postForAll(methodObject26446, this.proxyFactory.proxyForCache(this.delegate.getPlsqlIndexTable(arg0, arg1), this, this.proxyCache, methodObject26446));
      } catch (SQLException var4) {
         return this.postForAll(methodObject26446, this.onErrorForAll(methodObject26446, var4));
      }
   }

   public void setObject(String arg0, Object arg1) throws SQLException {
      try {
         super.preForSetObjects(methodObject26401, this, arg0, arg1);
         this.delegate.setObject(arg0, arg1 instanceof _Proxy_ ? (Object)((_Proxy_)arg1)._getDelegate_() : arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject26401, var4);
      }
   }

   public void setORAData(int arg0, ORAData arg1) throws SQLException {
      try {
         super.preForAll(methodObject26787, this, arg0, arg1);
         this.delegate.setORAData(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject26787, var4);
      }
   }

   public void setNClobAtName(String arg0, NClob arg1) throws SQLException {
      try {
         super.preForAll(methodObject26754, this, arg0, arg1);
         this.delegate.setNClobAtName(arg0, arg1 instanceof _Proxy_ ? (NClob)((_Proxy_)arg1)._getDelegate_() : arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject26754, var4);
      }
   }

   public void setByte(int arg0, byte arg1) throws SQLException {
      try {
         super.preForAll(methodObject26571, this, arg0, arg1);
         this.delegate.setByte(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject26571, var4);
      }
   }

   public Object getObject(int arg0, OracleDataFactory arg1) throws SQLException {
      try {
         super.preForAll(methodObject26381, this, arg0, arg1);
         return this.postForAll(methodObject26381, this.proxyFactory.proxyForCache(this.delegate.getObject(arg0, arg1), this, this.proxyCache, methodObject26381));
      } catch (SQLException var4) {
         return this.postForAll(methodObject26381, this.onErrorForAll(methodObject26381, var4));
      }
   }

   public void setNCharacterStreamAtName(String arg0, Reader arg1, long arg2) throws SQLException {
      try {
         super.preForSetStreams(methodObject26677, this, arg0, arg1, arg2);
         this.delegate.setNCharacterStreamAtName(arg0, arg1, arg2);
      } catch (SQLException var6) {
         this.onErrorVoidForAll(methodObject26677, var6);
      }
   }

   public String getString(String arg0) throws SQLException {
      try {
         super.preForAll(methodObject26514, this, arg0);
         return (String)this.postForAll(methodObject26514, (Object)this.delegate.getString(arg0));
      } catch (SQLException var3) {
         return (String)this.postForAll(methodObject26514, this.onErrorForAll(methodObject26514, var3));
      }
   }

   public void setRowPrefetch(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject26800, this, arg0);
         this.delegate.setRowPrefetch(arg0);
      } catch (SQLException var3) {
         this.onErrorVoidForAll(methodObject26800, var3);
      }
   }

   public void setTimestamp(int arg0, Timestamp arg1) throws SQLException {
      try {
         super.preForAll(methodObject26577, this, arg0, arg1);
         this.delegate.setTimestamp(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject26577, var4);
      }
   }

   public boolean isPoolable() throws SQLException {
      try {
         super.preForAll(methodObject26656, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject26656, this.delegate.isPoolable());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject26656, this.onErrorForAll(methodObject26656, var2));
      }
   }

   public void defineColumnType(int arg0, int arg1) throws SQLException {
      try {
         super.preForAll(methodObject26793, this, arg0, arg1);
         this.delegate.defineColumnType(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject26793, var4);
      }
   }

   public void setTIMESTAMPTZ(String arg0, TIMESTAMPTZ arg1) throws SQLException {
      try {
         super.preForAll(methodObject26469, this, arg0, arg1);
         this.delegate.setTIMESTAMPTZ(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject26469, var4);
      }
   }

   public void setUnicodeStream(int arg0, InputStream arg1, int arg2) throws SQLException {
      try {
         super.preForAll(methodObject26593, this, arg0, arg1, arg2);
         this.delegate.setUnicodeStream(arg0, arg1, arg2);
      } catch (SQLException var5) {
         this.onErrorVoidForAll(methodObject26593, var5);
      }
   }

   public byte[] getBytes(String arg0) throws SQLException {
      try {
         super.preForAll(methodObject26506, this, arg0);
         return (byte[])this.postForAll(methodObject26506, (Object)this.delegate.getBytes(arg0));
      } catch (SQLException var3) {
         return (byte[])this.postForAll(methodObject26506, this.onErrorForAll(methodObject26506, var3));
      }
   }

   public int getUpdateCount() throws SQLException {
      try {
         super.preForAll(methodObject26654, this, zeroLengthObjectArray);
         return (Integer)this.postForAll(methodObject26654, this.delegate.getUpdateCount());
      } catch (SQLException var2) {
         return (Integer)this.postForAll(methodObject26654, this.onErrorForAll(methodObject26654, var2));
      }
   }

   public void setObject(int arg0, Object arg1, int arg2, int arg3) throws SQLException {
      try {
         super.preForSetObjects(methodObject26597, this, arg0, arg1, arg2, arg3);
         this.delegate.setObject(arg0, arg1 instanceof _Proxy_ ? (Object)((_Proxy_)arg1)._getDelegate_() : arg1, arg2, arg3);
      } catch (SQLException var6) {
         this.onErrorVoidForAll(methodObject26597, var6);
      }
   }

   public String getString(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject26513, this, arg0);
         return (String)this.postForAll(methodObject26513, (Object)this.delegate.getString(arg0));
      } catch (SQLException var3) {
         return (String)this.postForAll(methodObject26513, this.onErrorForAll(methodObject26513, var3));
      }
   }

   public void setMaxFieldSize(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject26659, this, arg0);
         this.delegate.setMaxFieldSize(arg0);
      } catch (SQLException var3) {
         this.onErrorVoidForAll(methodObject26659, var3);
      }
   }

   public void setAsciiStreamAtName(String arg0, InputStream arg1, long arg2) throws SQLException {
      try {
         super.preForSetStreams(methodObject26670, this, arg0, arg1, arg2);
         this.delegate.setAsciiStreamAtName(arg0, arg1, arg2);
      } catch (SQLException var6) {
         this.onErrorVoidForAll(methodObject26670, var6);
      }
   }

   public void setBinaryStream(int arg0, InputStream arg1) throws SQLException {
      try {
         super.preForSetStreams(methodObject26587, this, arg0, arg1);
         this.delegate.setBinaryStream(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject26587, var4);
      }
   }

   public void setAsciiStreamAtName(String arg0, InputStream arg1) throws SQLException {
      try {
         super.preForSetStreams(methodObject26671, this, arg0, arg1);
         this.delegate.setAsciiStreamAtName(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject26671, var4);
      }
   }

   public int[] executeBatch() throws SQLException {
      try {
         super.preForExecuteBatch(methodObject26632, this, zeroLengthObjectArray);
         return (int[])this.postForAll(methodObject26632, (Object)this.delegate.executeBatch());
      } catch (SQLException var2) {
         return (int[])this.postForAll(methodObject26632, this.onErrorForAll(methodObject26632, var2));
      }
   }

   public void setNCharacterStream(String arg0, Reader arg1) throws SQLException {
      try {
         super.preForSetStreams(methodObject26526, this, arg0, arg1);
         this.delegate.setNCharacterStream(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject26526, var4);
      }
   }

   public void setEscapeProcessing(boolean arg0) throws SQLException {
      try {
         super.preForAll(methodObject26658, this, arg0);
         this.delegate.setEscapeProcessing(arg0);
      } catch (SQLException var3) {
         this.onErrorVoidForAll(methodObject26658, var3);
      }
   }

   public void setShortAtName(String arg0, short arg1) throws SQLException {
      try {
         super.preForAll(methodObject26691, this, arg0, arg1);
         this.delegate.setShortAtName(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject26691, var4);
      }
   }

   public void setClob(int arg0, Clob arg1) throws SQLException {
      try {
         super.preForAll(methodObject26612, this, arg0, arg1);
         this.delegate.setClob(arg0, arg1 instanceof _Proxy_ ? (Clob)((_Proxy_)arg1)._getDelegate_() : arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject26612, var4);
      }
   }

   public Time getTime(int arg0, Calendar arg1) throws SQLException {
      try {
         super.preForAll(methodObject26538, this, arg0, arg1);
         return (Time)this.postForAll(methodObject26538, (Object)this.delegate.getTime(arg0, arg1));
      } catch (SQLException var4) {
         return (Time)this.postForAll(methodObject26538, this.onErrorForAll(methodObject26538, var4));
      }
   }

   public void setArray(String arg0, Array arg1) throws SQLException {
      try {
         super.preForAll(methodObject26416, this, arg0, arg1);
         this.delegate.setArray(arg0, arg1 instanceof _Proxy_ ? (Array)((_Proxy_)arg1)._getDelegate_() : arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject26416, var4);
      }
   }

   public void setBinaryDouble(int arg0, BINARY_DOUBLE arg1) throws SQLException {
      try {
         super.preForAll(methodObject26763, this, arg0, arg1);
         this.delegate.setBinaryDouble(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject26763, var4);
      }
   }

   public void setNCharacterStream(String arg0, Reader arg1, long arg2) throws SQLException {
      try {
         super.preForSetStreams(methodObject26525, this, arg0, arg1, arg2);
         this.delegate.setNCharacterStream(arg0, arg1, arg2);
      } catch (SQLException var6) {
         this.onErrorVoidForAll(methodObject26525, var6);
      }
   }

   public OracleParameterMetaData OracleGetParameterMetaData() throws SQLException {
      try {
         super.preForAll(methodObject26749, this, zeroLengthObjectArray);
         return (OracleParameterMetaData)this.postForAll(methodObject26749, this.proxyFactory.proxyForCache((Object)this.delegate.OracleGetParameterMetaData(), this, this.proxyCache, methodObject26749));
      } catch (SQLException var2) {
         return (OracleParameterMetaData)this.postForAll(methodObject26749, this.onErrorForAll(methodObject26749, var2));
      }
   }

   public float getFloat(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject26501, this, arg0);
         return (Float)this.postForAll(methodObject26501, this.delegate.getFloat(arg0));
      } catch (SQLException var3) {
         return (Float)this.postForAll(methodObject26501, this.onErrorForAll(methodObject26501, var3));
      }
   }

   public void setTIMESTAMP(String arg0, TIMESTAMP arg1) throws SQLException {
      try {
         super.preForAll(methodObject26468, this, arg0, arg1);
         this.delegate.setTIMESTAMP(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject26468, var4);
      }
   }

   public void setShort(String arg0, short arg1) throws SQLException {
      try {
         super.preForAll(methodObject26388, this, arg0, arg1);
         this.delegate.setShort(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject26388, var4);
      }
   }

   public TIMESTAMP getTIMESTAMP(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject26439, this, arg0);
         return (TIMESTAMP)this.postForAll(methodObject26439, (Object)this.delegate.getTIMESTAMP(arg0));
      } catch (SQLException var3) {
         return (TIMESTAMP)this.postForAll(methodObject26439, this.onErrorForAll(methodObject26439, var3));
      }
   }

   public void setSQLXMLAtName(String arg0, SQLXML arg1) throws SQLException {
      try {
         super.preForAll(methodObject26759, this, arg0, arg1);
         this.delegate.setSQLXMLAtName(arg0, arg1 instanceof _Proxy_ ? (SQLXML)((_Proxy_)arg1)._getDelegate_() : arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject26759, var4);
      }
   }

   public INTERVALDS getINTERVALDS(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject26438, this, arg0);
         return (INTERVALDS)this.postForAll(methodObject26438, (Object)this.delegate.getINTERVALDS(arg0));
      } catch (SQLException var3) {
         return (INTERVALDS)this.postForAll(methodObject26438, this.onErrorForAll(methodObject26438, var3));
      }
   }

   public boolean isClosed() throws SQLException {
      try {
         super.preForAll(methodObject26637, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject26637, this.delegate.isClosed());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject26637, this.onErrorForAll(methodObject26637, var2));
      }
   }

   public void setTimestampAtName(String arg0, Timestamp arg1) throws SQLException {
      try {
         super.preForAll(methodObject26731, this, arg0, arg1);
         this.delegate.setTimestampAtName(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject26731, var4);
      }
   }

   public int sendBatch() throws SQLException {
      try {
         super.preForAll(methodObject26483, this, zeroLengthObjectArray);
         return (Integer)this.postForAll(methodObject26483, this.delegate.sendBatch());
      } catch (SQLException var2) {
         return (Integer)this.postForAll(methodObject26483, this.onErrorForAll(methodObject26483, var2));
      }
   }

   public Reader getNCharacterStream(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject26562, this, arg0);
         return (Reader)this.postForAll(methodObject26562, (Object)this.delegate.getNCharacterStream(arg0));
      } catch (SQLException var3) {
         return (Reader)this.postForAll(methodObject26562, this.onErrorForAll(methodObject26562, var3));
      }
   }

   public void setOracleObject(String arg0, Datum arg1) throws SQLException {
      try {
         super.preForAll(methodObject26479, this, arg0, arg1);
         this.delegate.setOracleObject(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject26479, var4);
      }
   }

   public void setCharacterStream(int arg0, Reader arg1) throws SQLException {
      try {
         super.preForSetStreams(methodObject26590, this, arg0, arg1);
         this.delegate.setCharacterStream(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject26590, var4);
      }
   }

   public int getRowPrefetch() {
      super.preForAll(methodObject26799, this, zeroLengthObjectArray);
      return (Integer)this.postForAll(methodObject26799, this.delegate.getRowPrefetch());
   }

   public void setClob(int arg0, Reader arg1, long arg2) throws SQLException {
      try {
         super.preForAll(methodObject26613, this, arg0, arg1, arg2);
         this.delegate.setClob(arg0, arg1, arg2);
      } catch (SQLException var6) {
         this.onErrorVoidForAll(methodObject26613, var6);
      }
   }

   public void setCLOB(String arg0, CLOB arg1) throws SQLException {
      try {
         super.preForAll(methodObject26463, this, arg0, arg1);
         this.delegate.setCLOB(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject26463, var4);
      }
   }

   public void closeOnCompletion() throws SQLException {
      try {
         super.preForAll(methodObject26645, this, zeroLengthObjectArray);
         this.delegate.closeOnCompletion();
      } catch (SQLException var2) {
         this.onErrorVoidForAll(methodObject26645, var2);
      }
   }

   public void setBinaryFloatAtName(String arg0, float arg1) throws SQLException {
      try {
         super.preForAll(methodObject26696, this, arg0, arg1);
         this.delegate.setBinaryFloatAtName(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject26696, var4);
      }
   }

   public RowId getRowId(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject26533, this, arg0);
         return (RowId)this.postForAll(methodObject26533, this.proxyFactory.proxyForCreate((Object)this.delegate.getRowId(arg0), this, this.proxyCache, methodObject26533));
      } catch (SQLException var3) {
         return (RowId)this.postForAll(methodObject26533, this.onErrorForAll(methodObject26533, var3));
      }
   }

   public URL getURL(String arg0) throws SQLException {
      try {
         super.preForAll(methodObject26510, this, arg0);
         return (URL)this.postForAll(methodObject26510, (Object)this.delegate.getURL(arg0));
      } catch (SQLException var3) {
         return (URL)this.postForAll(methodObject26510, this.onErrorForAll(methodObject26510, var3));
      }
   }

   public Reader getNCharacterStream(String arg0) throws SQLException {
      try {
         super.preForAll(methodObject26563, this, arg0);
         return (Reader)this.postForAll(methodObject26563, (Object)this.delegate.getNCharacterStream(arg0));
      } catch (SQLException var3) {
         return (Reader)this.postForAll(methodObject26563, this.onErrorForAll(methodObject26563, var3));
      }
   }

   public void setBinaryDoubleAtName(String arg0, BINARY_DOUBLE arg1) throws SQLException {
      try {
         super.preForAll(methodObject26699, this, arg0, arg1);
         this.delegate.setBinaryDoubleAtName(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject26699, var4);
      }
   }

   public void setLongAtName(String arg0, long arg1) throws SQLException {
      try {
         super.preForAll(methodObject26693, this, arg0, arg1);
         this.delegate.setLongAtName(arg0, arg1);
      } catch (SQLException var5) {
         this.onErrorVoidForAll(methodObject26693, var5);
      }
   }

   public void setBoolean(int arg0, boolean arg1) throws SQLException {
      try {
         super.preForAll(methodObject26570, this, arg0, arg1);
         this.delegate.setBoolean(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject26570, var4);
      }
   }

   public void setClobAtName(String arg0, Reader arg1, long arg2) throws SQLException {
      try {
         super.preForAll(methodObject26721, this, arg0, arg1, arg2);
         this.delegate.setClobAtName(arg0, arg1, arg2);
      } catch (SQLException var6) {
         this.onErrorVoidForAll(methodObject26721, var6);
      }
   }

   public void setStringAtName(String arg0, String arg1) throws SQLException {
      try {
         super.preForAll(methodObject26701, this, arg0, arg1);
         this.delegate.setStringAtName(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject26701, var4);
      }
   }

   public BigDecimal getBigDecimal(String arg0) throws SQLException {
      try {
         super.preForAll(methodObject26561, this, arg0);
         return (BigDecimal)this.postForAll(methodObject26561, (Object)this.delegate.getBigDecimal(arg0));
      } catch (SQLException var3) {
         return (BigDecimal)this.postForAll(methodObject26561, this.onErrorForAll(methodObject26561, var3));
      }
   }

   public void setBinaryDoubleAtName(String arg0, double arg1) throws SQLException {
      try {
         super.preForAll(methodObject26698, this, arg0, arg1);
         this.delegate.setBinaryDoubleAtName(arg0, arg1);
      } catch (SQLException var5) {
         this.onErrorVoidForAll(methodObject26698, var5);
      }
   }

   public void setAsciiStream(String arg0, InputStream arg1) throws SQLException {
      try {
         super.preForSetStreams(methodObject26520, this, arg0, arg1);
         this.delegate.setAsciiStream(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject26520, var4);
      }
   }

   public void setObjectAtName(String arg0, Object arg1) throws SQLException {
      try {
         super.preForSetObjects(methodObject26682, this, arg0, arg1);
         this.delegate.setObjectAtName(arg0, arg1 instanceof _Proxy_ ? (Object)((_Proxy_)arg1)._getDelegate_() : arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject26682, var4);
      }
   }

   public void setObjectAtName(String arg0, Object arg1, int arg2) throws SQLException {
      try {
         super.preForSetObjects(methodObject26681, this, arg0, arg1, arg2);
         this.delegate.setObjectAtName(arg0, arg1 instanceof _Proxy_ ? (Object)((_Proxy_)arg1)._getDelegate_() : arg1, arg2);
      } catch (SQLException var5) {
         this.onErrorVoidForAll(methodObject26681, var5);
      }
   }

   public Time getTime(String arg0) throws SQLException {
      try {
         super.preForAll(methodObject26539, this, arg0);
         return (Time)this.postForAll(methodObject26539, (Object)this.delegate.getTime(arg0));
      } catch (SQLException var3) {
         return (Time)this.postForAll(methodObject26539, this.onErrorForAll(methodObject26539, var3));
      }
   }

   public void setRefType(int arg0, REF arg1) throws SQLException {
      try {
         super.preForAll(methodObject26788, this, arg0, arg1);
         this.delegate.setRefType(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject26788, var4);
      }
   }

   public void registerOutParameterChars(int arg0, int arg1, int arg2, int arg3) throws SQLException {
      try {
         super.preForAll(methodObject26443, this, arg0, arg1, arg2, arg3);
         this.delegate.registerOutParameterChars(arg0, arg1, arg2, arg3);
      } catch (SQLException var6) {
         this.onErrorVoidForAll(methodObject26443, var6);
      }
   }

   public void setOPAQUE(String arg0, OPAQUE arg1) throws SQLException {
      try {
         super.preForAll(methodObject26472, this, arg0, arg1);
         this.delegate.setOPAQUE(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject26472, var4);
      }
   }

   public void setBinaryStreamAtName(String arg0, InputStream arg1, long arg2) throws SQLException {
      try {
         super.preForSetStreams(methodObject26673, this, arg0, arg1, arg2);
         this.delegate.setBinaryStreamAtName(arg0, arg1, arg2);
      } catch (SQLException var6) {
         this.onErrorVoidForAll(methodObject26673, var6);
      }
   }

   public void setRAW(int arg0, RAW arg1) throws SQLException {
      try {
         super.preForAll(methodObject26769, this, arg0, arg1);
         this.delegate.setRAW(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject26769, var4);
      }
   }

   public void setROWID(String arg0, ROWID arg1) throws SQLException {
      try {
         super.preForAll(methodObject26457, this, arg0, arg1);
         this.delegate.setROWID(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject26457, var4);
      }
   }

   public void setRefAtName(String arg0, Ref arg1) throws SQLException {
      try {
         super.preForAll(methodObject26741, this, arg0, arg1);
         this.delegate.setRefAtName(arg0, arg1 instanceof _Proxy_ ? (Ref)((_Proxy_)arg1)._getDelegate_() : arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject26741, var4);
      }
   }

   public Timestamp getTimestamp(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject26566, this, arg0);
         return (Timestamp)this.postForAll(methodObject26566, (Object)this.delegate.getTimestamp(arg0));
      } catch (SQLException var3) {
         return (Timestamp)this.postForAll(methodObject26566, this.onErrorForAll(methodObject26566, var3));
      }
   }

   public void setDate(String arg0, Date arg1) throws SQLException {
      try {
         super.preForAll(methodObject26404, this, arg0, arg1);
         this.delegate.setDate(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject26404, var4);
      }
   }

   public ResultSet getReturnResultSet() throws SQLException {
      try {
         super.preForAll(methodObject26753, this, zeroLengthObjectArray);
         return (ResultSet)this.postForAll(methodObject26753, this.proxyFactory.proxyForCache((Object)this.delegate.getReturnResultSet(), this, this.proxyCache, methodObject26753));
      } catch (SQLException var2) {
         return (ResultSet)this.postForAll(methodObject26753, this.onErrorForAll(methodObject26753, var2));
      }
   }

   public Date getDate(String arg0, Calendar arg1) throws SQLException {
      try {
         super.preForAll(methodObject26518, this, arg0, arg1);
         return (Date)this.postForAll(methodObject26518, (Object)this.delegate.getDate(arg0, arg1));
      } catch (SQLException var4) {
         return (Date)this.postForAll(methodObject26518, this.onErrorForAll(methodObject26518, var4));
      }
   }

   public byte[] getBytes(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject26505, this, arg0);
         return (byte[])this.postForAll(methodObject26505, (Object)this.delegate.getBytes(arg0));
      } catch (SQLException var3) {
         return (byte[])this.postForAll(methodObject26505, this.onErrorForAll(methodObject26505, var3));
      }
   }

   public void setBytesAtName(String arg0, byte[] arg1) throws SQLException {
      try {
         super.preForAll(methodObject26725, this, arg0, arg1);
         this.delegate.setBytesAtName(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject26725, var4);
      }
   }

   public void setINTERVALYMAtName(String arg0, INTERVALYM arg1) throws SQLException {
      try {
         super.preForAll(methodObject26733, this, arg0, arg1);
         this.delegate.setINTERVALYMAtName(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject26733, var4);
      }
   }

   public void setIntAtName(String arg0, int arg1) throws SQLException {
      try {
         super.preForAll(methodObject26692, this, arg0, arg1);
         this.delegate.setIntAtName(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject26692, var4);
      }
   }

   public void setObject(String arg0, Object arg1, int arg2, int arg3) throws SQLException {
      try {
         super.preForSetObjects(methodObject26399, this, arg0, arg1, arg2, arg3);
         this.delegate.setObject(arg0, arg1 instanceof _Proxy_ ? (Object)((_Proxy_)arg1)._getDelegate_() : arg1, arg2, arg3);
      } catch (SQLException var6) {
         this.onErrorVoidForAll(methodObject26399, var6);
      }
   }

   public void setBinaryStream(String arg0, InputStream arg1, int arg2) throws SQLException {
      try {
         super.preForSetStreams(methodObject26393, this, arg0, arg1, arg2);
         this.delegate.setBinaryStream(arg0, arg1, arg2);
      } catch (SQLException var5) {
         this.onErrorVoidForAll(methodObject26393, var5);
      }
   }

   public void setBinaryFloat(int arg0, float arg1) throws SQLException {
      try {
         super.preForAll(methodObject26760, this, arg0, arg1);
         this.delegate.setBinaryFloat(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject26760, var4);
      }
   }

   public void setSTRUCT(String arg0, STRUCT arg1) throws SQLException {
      try {
         super.preForAll(methodObject26474, this, arg0, arg1);
         this.delegate.setSTRUCT(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject26474, var4);
      }
   }

   public void setNClob(String arg0, Reader arg1, long arg2) throws SQLException {
      try {
         super.preForAll(methodObject26554, this, arg0, arg1, arg2);
         this.delegate.setNClob(arg0, arg1, arg2);
      } catch (SQLException var6) {
         this.onErrorVoidForAll(methodObject26554, var6);
      }
   }

   public void setAsciiStream(int arg0, InputStream arg1) throws SQLException {
      try {
         super.preForSetStreams(methodObject26584, this, arg0, arg1);
         this.delegate.setAsciiStream(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject26584, var4);
      }
   }

   public INTERVALYM getINTERVALYM(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject26437, this, arg0);
         return (INTERVALYM)this.postForAll(methodObject26437, (Object)this.delegate.getINTERVALYM(arg0));
      } catch (SQLException var3) {
         return (INTERVALYM)this.postForAll(methodObject26437, this.onErrorForAll(methodObject26437, var3));
      }
   }

   public void setNullAtName(String arg0, int arg1) throws SQLException {
      try {
         super.preForAll(methodObject26688, this, arg0, arg1);
         this.delegate.setNullAtName(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject26688, var4);
      }
   }

   public void addBatch(String arg0) throws SQLException {
      try {
         super.preForAll(methodObject26643, this, arg0);
         this.delegate.addBatch(arg0);
      } catch (SQLException var3) {
         this.onErrorVoidForAll(methodObject26643, var3);
      }
   }

   public Object unwrap(Class arg0) throws SQLException {
      try {
         super.preForAll(methodObject26667, this, arg0);
         return this.postForAll(methodObject26667, super.unwrap(arg0));
      } catch (SQLException var3) {
         return this.postForAll(methodObject26667, this.onErrorForAll(methodObject26667, var3));
      }
   }

   public void registerOutParameter(String arg0, int arg1, int arg2) throws SQLException {
      try {
         super.preForAll(methodObject26547, this, arg0, arg1, arg2);
         this.delegate.registerOutParameter(arg0, arg1, arg2);
      } catch (SQLException var5) {
         this.onErrorVoidForAll(methodObject26547, var5);
      }
   }

   public int getResultSetConcurrency() throws SQLException {
      try {
         super.preForAll(methodObject26652, this, zeroLengthObjectArray);
         return (Integer)this.postForAll(methodObject26652, this.delegate.getResultSetConcurrency());
      } catch (SQLException var2) {
         return (Integer)this.postForAll(methodObject26652, this.onErrorForAll(methodObject26652, var2));
      }
   }

   public Object getORAData(int arg0, ORADataFactory arg1) throws SQLException {
      try {
         super.preForAll(methodObject26428, this, arg0, arg1);
         return this.postForAll(methodObject26428, this.proxyFactory.proxyForCache(this.delegate.getORAData(arg0, arg1), this, this.proxyCache, methodObject26428));
      } catch (SQLException var4) {
         return this.postForAll(methodObject26428, this.onErrorForAll(methodObject26428, var4));
      }
   }

   public void registerReturnParameter(int arg0, int arg1, int arg2) throws SQLException {
      try {
         super.preForAll(methodObject26751, this, arg0, arg1, arg2);
         this.delegate.registerReturnParameter(arg0, arg1, arg2);
      } catch (SQLException var5) {
         this.onErrorVoidForAll(methodObject26751, var5);
      }
   }

   public void setTimestampAtName(String arg0, Timestamp arg1, Calendar arg2) throws SQLException {
      try {
         super.preForAll(methodObject26732, this, arg0, arg1, arg2);
         this.delegate.setTimestampAtName(arg0, arg1, arg2);
      } catch (SQLException var5) {
         this.onErrorVoidForAll(methodObject26732, var5);
      }
   }

   public void setBlobAtName(String arg0, Blob arg1) throws SQLException {
      try {
         super.preForAll(methodObject26716, this, arg0, arg1);
         this.delegate.setBlobAtName(arg0, arg1 instanceof _Proxy_ ? (Blob)((_Proxy_)arg1)._getDelegate_() : arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject26716, var4);
      }
   }

   public void setObject(int arg0, Object arg1) throws SQLException {
      try {
         super.preForSetObjects(methodObject26596, this, arg0, arg1);
         this.delegate.setObject(arg0, arg1 instanceof _Proxy_ ? (Object)((_Proxy_)arg1)._getDelegate_() : arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject26596, var4);
      }
   }

   public void registerReturnParameter(int arg0, int arg1) throws SQLException {
      try {
         super.preForAll(methodObject26750, this, arg0, arg1);
         this.delegate.registerReturnParameter(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject26750, var4);
      }
   }

   public void setNullAtName(String arg0, int arg1, String arg2) throws SQLException {
      try {
         super.preForAll(methodObject26687, this, arg0, arg1, arg2);
         this.delegate.setNullAtName(arg0, arg1, arg2);
      } catch (SQLException var5) {
         this.onErrorVoidForAll(methodObject26687, var5);
      }
   }

   public int getInt(String arg0) throws SQLException {
      try {
         super.preForAll(methodObject26498, this, arg0);
         return (Integer)this.postForAll(methodObject26498, this.delegate.getInt(arg0));
      } catch (SQLException var3) {
         return (Integer)this.postForAll(methodObject26498, this.onErrorForAll(methodObject26498, var3));
      }
   }

   public void setRef(int arg0, Ref arg1) throws SQLException {
      try {
         super.preForAll(methodObject26624, this, arg0, arg1);
         this.delegate.setRef(arg0, arg1 instanceof _Proxy_ ? (Ref)((_Proxy_)arg1)._getDelegate_() : arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject26624, var4);
      }
   }

   public void setExecuteBatch(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject26444, this, arg0);
         this.delegate.setExecuteBatch(arg0);
      } catch (SQLException var3) {
         this.onErrorVoidForAll(methodObject26444, var3);
      }
   }

   public void setBinaryFloatAtName(String arg0, BINARY_FLOAT arg1) throws SQLException {
      try {
         super.preForAll(methodObject26697, this, arg0, arg1);
         this.delegate.setBinaryFloatAtName(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject26697, var4);
      }
   }

   public ResultSet getResultSet() throws SQLException {
      try {
         super.preForAll(methodObject26631, this, zeroLengthObjectArray);
         return (ResultSet)this.postForAll(methodObject26631, this.proxyFactory.proxyForCache((Object)this.delegate.getResultSet(), this, this.proxyCache, methodObject26631));
      } catch (SQLException var2) {
         return (ResultSet)this.postForAll(methodObject26631, this.onErrorForAll(methodObject26631, var2));
      }
   }

   public void setFixedCHAR(String arg0, String arg1) throws SQLException {
      try {
         super.preForAll(methodObject26455, this, arg0, arg1);
         this.delegate.setFixedCHAR(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject26455, var4);
      }
   }

   public void defineColumnType(int arg0, int arg1, int arg2, short arg3) throws SQLException {
      try {
         super.preForAll(methodObject26795, this, arg0, arg1, arg2, arg3);
         this.delegate.defineColumnType(arg0, arg1, arg2, arg3);
      } catch (SQLException var6) {
         this.onErrorVoidForAll(methodObject26795, var6);
      }
   }

   public void setBfileAtName(String arg0, BFILE arg1) throws SQLException {
      try {
         super.preForAll(methodObject26724, this, arg0, arg1);
         this.delegate.setBfileAtName(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject26724, var4);
      }
   }

   public void setTIMESTAMPTZAtName(String arg0, TIMESTAMPTZ arg1) throws SQLException {
      try {
         super.preForAll(methodObject26736, this, arg0, arg1);
         this.delegate.setTIMESTAMPTZAtName(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject26736, var4);
      }
   }

   public BLOB getBLOB(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject26424, this, arg0);
         return (BLOB)this.postForAll(methodObject26424, (Object)this.delegate.getBLOB(arg0));
      } catch (SQLException var3) {
         return (BLOB)this.postForAll(methodObject26424, this.onErrorForAll(methodObject26424, var3));
      }
   }

   public void defineColumnType(int arg0, int arg1, int arg2) throws SQLException {
      try {
         super.preForAll(methodObject26794, this, arg0, arg1, arg2);
         this.delegate.defineColumnType(arg0, arg1, arg2);
      } catch (SQLException var5) {
         this.onErrorVoidForAll(methodObject26794, var5);
      }
   }

   public CHAR getCHAR(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject26425, this, arg0);
         return (CHAR)this.postForAll(methodObject26425, (Object)this.delegate.getCHAR(arg0));
      } catch (SQLException var3) {
         return (CHAR)this.postForAll(methodObject26425, this.onErrorForAll(methodObject26425, var3));
      }
   }

   public long getRegisteredQueryId() throws SQLException {
      try {
         super.preForAll(methodObject26807, this, zeroLengthObjectArray);
         return (Long)this.postForAll(methodObject26807, this.delegate.getRegisteredQueryId());
      } catch (SQLException var2) {
         return (Long)this.postForAll(methodObject26807, this.onErrorForAll(methodObject26807, var2));
      }
   }

   public void setDateAtName(String arg0, Date arg1) throws SQLException {
      try {
         super.preForAll(methodObject26727, this, arg0, arg1);
         this.delegate.setDateAtName(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject26727, var4);
      }
   }

   public void setTIMESTAMPLTZ(String arg0, TIMESTAMPLTZ arg1) throws SQLException {
      try {
         super.preForAll(methodObject26470, this, arg0, arg1);
         this.delegate.setTIMESTAMPLTZ(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject26470, var4);
      }
   }

   public void setFixedCHAR(int arg0, String arg1) throws SQLException {
      try {
         super.preForAll(methodObject26766, this, arg0, arg1);
         this.delegate.setFixedCHAR(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject26766, var4);
      }
   }

   public boolean execute(String arg0, int[] arg1) throws SQLException {
      try {
         super.preForExecute(methodObject26628, this, arg0, arg1);
         return this.postForExecute(methodObject26628, this.delegate.execute(arg0, arg1));
      } catch (SQLException var4) {
         return this.postForExecute(methodObject26628, this.onErrorForExecute(methodObject26628, var4));
      }
   }

   public void setINTERVALDSAtName(String arg0, INTERVALDS arg1) throws SQLException {
      try {
         super.preForAll(methodObject26734, this, arg0, arg1);
         this.delegate.setINTERVALDSAtName(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject26734, var4);
      }
   }

   public void setBigDecimal(String arg0, BigDecimal arg1) throws SQLException {
      try {
         super.preForAll(methodObject26411, this, arg0, arg1);
         this.delegate.setBigDecimal(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject26411, var4);
      }
   }

   public Object getObject(String arg0) throws SQLException {
      try {
         super.preForAll(methodObject26487, this, arg0);
         return this.postForAll(methodObject26487, this.proxyFactory.proxyForCache(this.delegate.getObject(arg0), this, this.proxyCache, methodObject26487));
      } catch (SQLException var3) {
         return this.postForAll(methodObject26487, this.onErrorForAll(methodObject26487, var3));
      }
   }

   public boolean getMoreResults() throws SQLException {
      try {
         super.preForAll(methodObject26649, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject26649, this.delegate.getMoreResults());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject26649, this.onErrorForAll(methodObject26649, var2));
      }
   }

   public boolean getBoolean(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject26491, this, arg0);
         return (Boolean)this.postForAll(methodObject26491, this.delegate.getBoolean(arg0));
      } catch (SQLException var3) {
         return (Boolean)this.postForAll(methodObject26491, this.onErrorForAll(methodObject26491, var3));
      }
   }

   public BigDecimal getBigDecimal(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject26560, this, arg0);
         return (BigDecimal)this.postForAll(methodObject26560, (Object)this.delegate.getBigDecimal(arg0));
      } catch (SQLException var3) {
         return (BigDecimal)this.postForAll(methodObject26560, this.onErrorForAll(methodObject26560, var3));
      }
   }

   public void setCursorAtName(String arg0, ResultSet arg1) throws SQLException {
      try {
         super.preForAll(methodObject26704, this, arg0, arg1);
         this.delegate.setCursorAtName(arg0, arg1 instanceof _Proxy_ ? (ResultSet)((_Proxy_)arg1)._getDelegate_() : arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject26704, var4);
      }
   }

   public void setUnicodeStreamAtName(String arg0, InputStream arg1, int arg2) throws SQLException {
      try {
         super.preForAll(methodObject26679, this, arg0, arg1, arg2);
         this.delegate.setUnicodeStreamAtName(arg0, arg1, arg2);
      } catch (SQLException var5) {
         this.onErrorVoidForAll(methodObject26679, var5);
      }
   }

   public void setINTERVALYM(String arg0, INTERVALYM arg1) throws SQLException {
      try {
         super.preForAll(methodObject26466, this, arg0, arg1);
         this.delegate.setINTERVALYM(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject26466, var4);
      }
   }

   public void setString(int arg0, String arg1) throws SQLException {
      try {
         super.preForAll(methodObject26605, this, arg0, arg1);
         this.delegate.setString(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject26605, var4);
      }
   }

   public short getShort(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject26495, this, arg0);
         return (Short)this.postForAll(methodObject26495, this.delegate.getShort(arg0));
      } catch (SQLException var3) {
         return (Short)this.postForAll(methodObject26495, this.onErrorForAll(methodObject26495, var3));
      }
   }

   public void setTimestamp(String arg0, Timestamp arg1) throws SQLException {
      try {
         super.preForAll(methodObject26389, this, arg0, arg1);
         this.delegate.setTimestamp(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject26389, var4);
      }
   }

   public int executeUpdate(String arg0, String[] arg1) throws SQLException {
      try {
         super.preForExecuteUpdate(methodObject26636, this, arg0, arg1);
         return this.postForExecuteUpdate(methodObject26636, this.delegate.executeUpdate(arg0, arg1));
      } catch (SQLException var4) {
         return this.postForExecuteUpdate(methodObject26636, (Integer)this.onErrorForAll(methodObject26636, var4));
      }
   }

   public void setClob(String arg0, Clob arg1) throws SQLException {
      try {
         super.preForAll(methodObject26413, this, arg0, arg1);
         this.delegate.setClob(arg0, arg1 instanceof _Proxy_ ? (Clob)((_Proxy_)arg1)._getDelegate_() : arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject26413, var4);
      }
   }

   public void setNull(String arg0, int arg1) throws SQLException {
      try {
         super.preForAll(methodObject26415, this, arg0, arg1);
         this.delegate.setNull(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject26415, var4);
      }
   }

   public void setBLOB(int arg0, BLOB arg1) throws SQLException {
      try {
         super.preForAll(methodObject26773, this, arg0, arg1);
         this.delegate.setBLOB(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject26773, var4);
      }
   }

   public boolean execute(String arg0, int arg1) throws SQLException {
      try {
         super.preForExecute(methodObject26627, this, arg0, arg1);
         return this.postForExecute(methodObject26627, this.delegate.execute(arg0, arg1));
      } catch (SQLException var4) {
         return this.postForExecute(methodObject26627, this.onErrorForExecute(methodObject26627, var4));
      }
   }

   public void setNClobAtName(String arg0, Reader arg1) throws SQLException {
      try {
         super.preForAll(methodObject26756, this, arg0, arg1);
         this.delegate.setNClobAtName(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject26756, var4);
      }
   }

   public Blob getBlob(String arg0) throws SQLException {
      try {
         super.preForAll(methodObject26528, this, arg0);
         return (Blob)this.postForAll(methodObject26528, this.proxyFactory.proxyForCreate((Object)this.delegate.getBlob(arg0), this, this.proxyCache, methodObject26528));
      } catch (SQLException var3) {
         return (Blob)this.postForAll(methodObject26528, this.onErrorForAll(methodObject26528, var3));
      }
   }

   public void setString(String arg0, String arg1) throws SQLException {
      try {
         super.preForAll(methodObject26408, this, arg0, arg1);
         this.delegate.setString(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject26408, var4);
      }
   }

   public Object getObject(int arg0, Map arg1) throws SQLException {
      try {
         super.preForAll(methodObject26486, this, arg0, arg1);
         return this.postForAll(methodObject26486, this.proxyFactory.proxyForCache(this.delegate.getObject(arg0, arg1), this, this.proxyCache, methodObject26486));
      } catch (SQLException var4) {
         return this.postForAll(methodObject26486, this.onErrorForAll(methodObject26486, var4));
      }
   }

   public void setClob(int arg0, Reader arg1) throws SQLException {
      try {
         super.preForAll(methodObject26614, this, arg0, arg1);
         this.delegate.setClob(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject26614, var4);
      }
   }

   public ResultSet executeQuery() throws SQLException {
      try {
         super.preForAll(methodObject26598, this, zeroLengthObjectArray);
         return this.postForExecuteQuery(methodObject26598, (ResultSet)this.proxyFactory.proxyForCreateCache((Object)this.delegate.executeQuery(), this, this.proxyCache, methodObject26598));
      } catch (SQLException var2) {
         return this.postForExecuteQuery(methodObject26598, (ResultSet)this.onErrorForAll(methodObject26598, var2));
      }
   }

   public void setAsciiStream(String arg0, InputStream arg1, long arg2) throws SQLException {
      try {
         super.preForSetStreams(methodObject26519, this, arg0, arg1, arg2);
         this.delegate.setAsciiStream(arg0, arg1, arg2);
      } catch (SQLException var6) {
         this.onErrorVoidForAll(methodObject26519, var6);
      }
   }

   public Object getAnyDataEmbeddedObject(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject26429, this, arg0);
         return this.postForAll(methodObject26429, this.proxyFactory.proxyForCache(this.delegate.getAnyDataEmbeddedObject(arg0), this, this.proxyCache, methodObject26429));
      } catch (SQLException var3) {
         return this.postForAll(methodObject26429, this.onErrorForAll(methodObject26429, var3));
      }
   }

   public URL getURL(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject26509, this, arg0);
         return (URL)this.postForAll(methodObject26509, (Object)this.delegate.getURL(arg0));
      } catch (SQLException var3) {
         return (URL)this.postForAll(methodObject26509, this.onErrorForAll(methodObject26509, var3));
      }
   }

   public void setFixedCHARAtName(String arg0, String arg1) throws SQLException {
      try {
         super.preForAll(methodObject26703, this, arg0, arg1);
         this.delegate.setFixedCHARAtName(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject26703, var4);
      }
   }

   public void setROWID(int arg0, ROWID arg1) throws SQLException {
      try {
         super.preForAll(methodObject26768, this, arg0, arg1);
         this.delegate.setROWID(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject26768, var4);
      }
   }

   public void setNClob(String arg0, NClob arg1) throws SQLException {
      try {
         super.preForAll(methodObject26553, this, arg0, arg1);
         this.delegate.setNClob(arg0, arg1 instanceof _Proxy_ ? (NClob)((_Proxy_)arg1)._getDelegate_() : arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject26553, var4);
      }
   }

   public SQLWarning getWarnings() throws SQLException {
      try {
         super.preForAll(methodObject26640, this, zeroLengthObjectArray);
         return (SQLWarning)this.postForAll(methodObject26640, (Object)this.delegate.getWarnings());
      } catch (SQLException var2) {
         return (SQLWarning)this.postForAll(methodObject26640, this.onErrorForAll(methodObject26640, var2));
      }
   }

   public void setTIMESTAMP(int arg0, TIMESTAMP arg1) throws SQLException {
      try {
         super.preForAll(methodObject26779, this, arg0, arg1);
         this.delegate.setTIMESTAMP(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject26779, var4);
      }
   }

   public Reader getCharacterStream(String arg0) throws SQLException {
      try {
         super.preForAll(methodObject26541, this, arg0);
         return (Reader)this.postForAll(methodObject26541, (Object)this.delegate.getCharacterStream(arg0));
      } catch (SQLException var3) {
         return (Reader)this.postForAll(methodObject26541, this.onErrorForAll(methodObject26541, var3));
      }
   }

   public DATE getDATE(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject26430, this, arg0);
         return (DATE)this.postForAll(methodObject26430, (Object)this.delegate.getDATE(arg0));
      } catch (SQLException var3) {
         return (DATE)this.postForAll(methodObject26430, this.onErrorForAll(methodObject26430, var3));
      }
   }

   public CLOB getCLOB(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject26426, this, arg0);
         return (CLOB)this.postForAll(methodObject26426, (Object)this.delegate.getCLOB(arg0));
      } catch (SQLException var3) {
         return (CLOB)this.postForAll(methodObject26426, this.onErrorForAll(methodObject26426, var3));
      }
   }

   public void setStructDescriptor(String arg0, StructDescriptor arg1) throws SQLException {
      try {
         super.preForAll(methodObject26473, this, arg0, arg1);
         this.delegate.setStructDescriptor(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject26473, var4);
      }
   }

   public Connection getConnection() throws SQLException {
      try {
         super.preForAll(methodObject26639, this, zeroLengthObjectArray);
         return (Connection)this.postForAll(methodObject26639, (Object)super.getConnection());
      } catch (SQLException var2) {
         return (Connection)this.postForAll(methodObject26639, this.onErrorForAll(methodObject26639, var2));
      }
   }

   public void setClobAtName(String arg0, Reader arg1) throws SQLException {
      try {
         super.preForAll(methodObject26722, this, arg0, arg1);
         this.delegate.setClobAtName(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject26722, var4);
      }
   }

   public void setDATE(String arg0, DATE arg1) throws SQLException {
      try {
         super.preForAll(methodObject26460, this, arg0, arg1);
         this.delegate.setDATE(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject26460, var4);
      }
   }

   public Timestamp getTimestamp(String arg0, Calendar arg1) throws SQLException {
      try {
         super.preForAll(methodObject26569, this, arg0, arg1);
         return (Timestamp)this.postForAll(methodObject26569, (Object)this.delegate.getTimestamp(arg0, arg1));
      } catch (SQLException var4) {
         return (Timestamp)this.postForAll(methodObject26569, this.onErrorForAll(methodObject26569, var4));
      }
   }

   public long getLong(String arg0) throws SQLException {
      try {
         super.preForAll(methodObject26500, this, arg0);
         return (Long)this.postForAll(methodObject26500, this.delegate.getLong(arg0));
      } catch (SQLException var3) {
         return (Long)this.postForAll(methodObject26500, this.onErrorForAll(methodObject26500, var3));
      }
   }

   public void setMaxRows(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject26660, this, arg0);
         this.delegate.setMaxRows(arg0);
      } catch (SQLException var3) {
         this.onErrorVoidForAll(methodObject26660, var3);
      }
   }

   public void setFormOfUse(int arg0, short arg1) {
      super.preForAll(methodObject26747, this, arg0, arg1);
      this.delegate.setFormOfUse(arg0, arg1);
   }

   public ROWID getROWID(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject26435, this, arg0);
         return (ROWID)this.postForAll(methodObject26435, (Object)this.delegate.getROWID(arg0));
      } catch (SQLException var3) {
         return (ROWID)this.postForAll(methodObject26435, this.onErrorForAll(methodObject26435, var3));
      }
   }

   public void registerOutParameterAtName(String arg0, int arg1, int arg2) throws SQLException {
      try {
         super.preForAll(methodObject26481, this, arg0, arg1, arg2);
         this.delegate.registerOutParameterAtName(arg0, arg1, arg2);
      } catch (SQLException var5) {
         this.onErrorVoidForAll(methodObject26481, var5);
      }
   }

   public boolean isNCHAR(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject26791, this, arg0);
         return (Boolean)this.postForAll(methodObject26791, this.delegate.isNCHAR(arg0));
      } catch (SQLException var3) {
         return (Boolean)this.postForAll(methodObject26791, this.onErrorForAll(methodObject26791, var3));
      }
   }

   public void close() throws SQLException {
      try {
         super.preForAll(methodObject26625, this, zeroLengthObjectArray);
         Method var10001 = methodObject26625;
         this.delegate.close();
         this.postForClose(var10001);
      } catch (SQLException var2) {
         this.onErrorVoidForClose(methodObject26625, var2);
      }
   }

   public ResultSet getCursor(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject26421, this, arg0);
         return (ResultSet)this.postForAll(methodObject26421, this.proxyFactory.proxyForCache((Object)this.delegate.getCursor(arg0), this, this.proxyCache, methodObject26421));
      } catch (SQLException var3) {
         return (ResultSet)this.postForAll(methodObject26421, this.onErrorForAll(methodObject26421, var3));
      }
   }

   public void setTimeAtName(String arg0, Time arg1, Calendar arg2) throws SQLException {
      try {
         super.preForAll(methodObject26730, this, arg0, arg1, arg2);
         this.delegate.setTimeAtName(arg0, arg1, arg2);
      } catch (SQLException var5) {
         this.onErrorVoidForAll(methodObject26730, var5);
      }
   }

   public void setFloatAtName(String arg0, float arg1) throws SQLException {
      try {
         super.preForAll(methodObject26694, this, arg0, arg1);
         this.delegate.setFloatAtName(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject26694, var4);
      }
   }

   public RAW getRAW(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject26433, this, arg0);
         return (RAW)this.postForAll(methodObject26433, (Object)this.delegate.getRAW(arg0));
      } catch (SQLException var3) {
         return (RAW)this.postForAll(methodObject26433, this.onErrorForAll(methodObject26433, var3));
      }
   }

   public void setBLOB(String arg0, BLOB arg1) throws SQLException {
      try {
         super.preForAll(methodObject26462, this, arg0, arg1);
         this.delegate.setBLOB(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject26462, var4);
      }
   }

   public void setTimestamp(int arg0, Timestamp arg1, Calendar arg2) throws SQLException {
      try {
         super.preForAll(methodObject26578, this, arg0, arg1, arg2);
         this.delegate.setTimestamp(arg0, arg1, arg2);
      } catch (SQLException var5) {
         this.onErrorVoidForAll(methodObject26578, var5);
      }
   }

   public void setBinaryStream(int arg0, InputStream arg1, long arg2) throws SQLException {
      try {
         super.preForSetStreams(methodObject26586, this, arg0, arg1, arg2);
         this.delegate.setBinaryStream(arg0, arg1, arg2);
      } catch (SQLException var6) {
         this.onErrorVoidForAll(methodObject26586, var6);
      }
   }

   public NClob getNClob(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject26531, this, arg0);
         return (NClob)this.postForAll(methodObject26531, this.proxyFactory.proxyForCreate((Object)this.delegate.getNClob(arg0), this, this.proxyCache, methodObject26531));
      } catch (SQLException var3) {
         return (NClob)this.postForAll(methodObject26531, this.onErrorForAll(methodObject26531, var3));
      }
   }

   public void setBytes(String arg0, byte[] arg1) throws SQLException {
      try {
         super.preForAll(methodObject26398, this, arg0, arg1);
         this.delegate.setBytes(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject26398, var4);
      }
   }

   public void setInt(String arg0, int arg1) throws SQLException {
      try {
         super.preForAll(methodObject26386, this, arg0, arg1);
         this.delegate.setInt(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject26386, var4);
      }
   }

   public void setTime(String arg0, Time arg1, Calendar arg2) throws SQLException {
      try {
         super.preForAll(methodObject26403, this, arg0, arg1, arg2);
         this.delegate.setTime(arg0, arg1, arg2);
      } catch (SQLException var5) {
         this.onErrorVoidForAll(methodObject26403, var5);
      }
   }

   public void setBlobAtName(String arg0, InputStream arg1, long arg2) throws SQLException {
      try {
         super.preForAll(methodObject26717, this, arg0, arg1, arg2);
         this.delegate.setBlobAtName(arg0, arg1, arg2);
      } catch (SQLException var6) {
         this.onErrorVoidForAll(methodObject26717, var6);
      }
   }

   public Array getArray(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject26507, this, arg0);
         return (Array)this.postForAll(methodObject26507, this.proxyFactory.proxyForCreate((Object)this.delegate.getArray(arg0), this, this.proxyCache, methodObject26507));
      } catch (SQLException var3) {
         return (Array)this.postForAll(methodObject26507, this.onErrorForAll(methodObject26507, var3));
      }
   }

   public void setShort(int arg0, short arg1) throws SQLException {
      try {
         super.preForAll(methodObject26576, this, arg0, arg1);
         this.delegate.setShort(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject26576, var4);
      }
   }

   public void setBinaryFloat(String arg0, float arg1) throws SQLException {
      try {
         super.preForAll(methodObject26450, this, arg0, arg1);
         this.delegate.setBinaryFloat(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject26450, var4);
      }
   }

   public void setDatabaseChangeRegistration(DatabaseChangeRegistration arg0) throws SQLException {
      try {
         super.preForAll(methodObject26805, this, arg0);
         this.delegate.setDatabaseChangeRegistration(arg0);
      } catch (SQLException var3) {
         this.onErrorVoidForAll(methodObject26805, var3);
      }
   }

   public void setNClob(int arg0, Reader arg1, long arg2) throws SQLException {
      try {
         super.preForAll(methodObject26616, this, arg0, arg1, arg2);
         this.delegate.setNClob(arg0, arg1, arg2);
      } catch (SQLException var6) {
         this.onErrorVoidForAll(methodObject26616, var6);
      }
   }

   public void setClob(String arg0, Reader arg1, long arg2) throws SQLException {
      try {
         super.preForAll(methodObject26551, this, arg0, arg1, arg2);
         this.delegate.setClob(arg0, arg1, arg2);
      } catch (SQLException var6) {
         this.onErrorVoidForAll(methodObject26551, var6);
      }
   }

   public int executeUpdate() throws SQLException {
      try {
         super.preForExecuteUpdate(methodObject26581, this, zeroLengthObjectArray);
         return this.postForExecuteUpdate(methodObject26581, this.delegate.executeUpdate());
      } catch (SQLException var2) {
         return this.postForExecuteUpdate(methodObject26581, (Integer)this.onErrorForAll(methodObject26581, var2));
      }
   }

   public void setNCharacterStream(int arg0, Reader arg1) throws SQLException {
      try {
         super.preForSetStreams(methodObject26592, this, arg0, arg1);
         this.delegate.setNCharacterStream(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject26592, var4);
      }
   }

   public void defineColumnTypeBytes(int arg0, int arg1, int arg2) throws SQLException {
      try {
         super.preForAll(methodObject26797, this, arg0, arg1, arg2);
         this.delegate.defineColumnTypeBytes(arg0, arg1, arg2);
      } catch (SQLException var5) {
         this.onErrorVoidForAll(methodObject26797, var5);
      }
   }

   public void setLong(int arg0, long arg1) throws SQLException {
      try {
         super.preForAll(methodObject26575, this, arg0, arg1);
         this.delegate.setLong(arg0, arg1);
      } catch (SQLException var5) {
         this.onErrorVoidForAll(methodObject26575, var5);
      }
   }

   public void setDate(int arg0, Date arg1, Calendar arg2) throws SQLException {
      try {
         super.preForAll(methodObject26604, this, arg0, arg1, arg2);
         this.delegate.setDate(arg0, arg1, arg2);
      } catch (SQLException var5) {
         this.onErrorVoidForAll(methodObject26604, var5);
      }
   }

   public NClob getNClob(String arg0) throws SQLException {
      try {
         super.preForAll(methodObject26532, this, arg0);
         return (NClob)this.postForAll(methodObject26532, this.proxyFactory.proxyForCreate((Object)this.delegate.getNClob(arg0), this, this.proxyCache, methodObject26532));
      } catch (SQLException var3) {
         return (NClob)this.postForAll(methodObject26532, this.onErrorForAll(methodObject26532, var3));
      }
   }

   public void setTIMESTAMPLTZAtName(String arg0, TIMESTAMPLTZ arg1) throws SQLException {
      try {
         super.preForAll(methodObject26737, this, arg0, arg1);
         this.delegate.setTIMESTAMPLTZAtName(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject26737, var4);
      }
   }

   public void setCLOB(int arg0, CLOB arg1) throws SQLException {
      try {
         super.preForAll(methodObject26774, this, arg0, arg1);
         this.delegate.setCLOB(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject26774, var4);
      }
   }

   public void setByte(String arg0, byte arg1) throws SQLException {
      try {
         super.preForAll(methodObject26383, this, arg0, arg1);
         this.delegate.setByte(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject26383, var4);
      }
   }

   public void setFetchDirection(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject26665, this, arg0);
         this.delegate.setFetchDirection(arg0);
      } catch (SQLException var3) {
         this.onErrorVoidForAll(methodObject26665, var3);
      }
   }

   public void setStringForClob(String arg0, String arg1) throws SQLException {
      try {
         super.preForAll(methodObject26453, this, arg0, arg1);
         this.delegate.setStringForClob(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject26453, var4);
      }
   }

   public void setSTRUCTAtName(String arg0, STRUCT arg1) throws SQLException {
      try {
         super.preForAll(methodObject26710, this, arg0, arg1);
         this.delegate.setSTRUCTAtName(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject26710, var4);
      }
   }

   public void registerOutParameter(String arg0, int arg1) throws SQLException {
      try {
         super.preForAll(methodObject26546, this, arg0, arg1);
         this.delegate.registerOutParameter(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject26546, var4);
      }
   }

   public void setCharacterStream(int arg0, Reader arg1, int arg2) throws SQLException {
      try {
         super.preForSetStreams(methodObject26588, this, arg0, arg1, arg2);
         this.delegate.setCharacterStream(arg0, arg1, arg2);
      } catch (SQLException var5) {
         this.onErrorVoidForAll(methodObject26588, var5);
      }
   }

   public void setBinaryFloat(int arg0, BINARY_FLOAT arg1) throws SQLException {
      try {
         super.preForAll(methodObject26761, this, arg0, arg1);
         this.delegate.setBinaryFloat(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject26761, var4);
      }
   }

   public void setDouble(String arg0, double arg1) throws SQLException {
      try {
         super.preForAll(methodObject26384, this, arg0, arg1);
         this.delegate.setDouble(arg0, arg1);
      } catch (SQLException var5) {
         this.onErrorVoidForAll(methodObject26384, var5);
      }
   }

   public void setBinaryDouble(String arg0, double arg1) throws SQLException {
      try {
         super.preForAll(methodObject26452, this, arg0, arg1);
         this.delegate.setBinaryDouble(arg0, arg1);
      } catch (SQLException var5) {
         this.onErrorVoidForAll(methodObject26452, var5);
      }
   }

   public InputStream getBinaryStream(String arg0) throws SQLException {
      try {
         super.preForAll(methodObject26397, this, arg0);
         return (InputStream)this.postForAll(methodObject26397, (Object)this.delegate.getBinaryStream(arg0));
      } catch (SQLException var3) {
         return (InputStream)this.postForAll(methodObject26397, this.onErrorForAll(methodObject26397, var3));
      }
   }

   public void setBinaryStreamAtName(String arg0, InputStream arg1, int arg2) throws SQLException {
      try {
         super.preForSetStreams(methodObject26672, this, arg0, arg1, arg2);
         this.delegate.setBinaryStreamAtName(arg0, arg1, arg2);
      } catch (SQLException var5) {
         this.onErrorVoidForAll(methodObject26672, var5);
      }
   }

   public void setORADataAtName(String arg0, ORAData arg1) throws SQLException {
      try {
         super.preForAll(methodObject26739, this, arg0, arg1);
         this.delegate.setORADataAtName(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject26739, var4);
      }
   }

   public int getLobPrefetchSize() throws SQLException {
      try {
         super.preForAll(methodObject26801, this, zeroLengthObjectArray);
         return (Integer)this.postForAll(methodObject26801, this.delegate.getLobPrefetchSize());
      } catch (SQLException var2) {
         return (Integer)this.postForAll(methodObject26801, this.onErrorForAll(methodObject26801, var2));
      }
   }

   public void defineParameterTypeChars(int arg0, int arg1, int arg2) throws SQLException {
      try {
         super.preForAll(methodObject26684, this, arg0, arg1, arg2);
         this.delegate.defineParameterTypeChars(arg0, arg1, arg2);
      } catch (SQLException var5) {
         this.onErrorVoidForAll(methodObject26684, var5);
      }
   }

   public SQLXML getSQLXML(String arg0) throws SQLException {
      try {
         super.preForAll(methodObject26536, this, arg0);
         return (SQLXML)this.postForAll(methodObject26536, this.proxyFactory.proxyForCreate((Object)this.delegate.getSQLXML(arg0), this, this.proxyCache, methodObject26536));
      } catch (SQLException var3) {
         return (SQLXML)this.postForAll(methodObject26536, this.onErrorForAll(methodObject26536, var3));
      }
   }

   public ParameterMetaData getParameterMetaData() throws SQLException {
      try {
         super.preForAll(methodObject26600, this, zeroLengthObjectArray);
         return (ParameterMetaData)this.postForAll(methodObject26600, this.proxyFactory.proxyForCreate((Object)this.delegate.getParameterMetaData(), this, this.proxyCache, methodObject26600));
      } catch (SQLException var2) {
         return (ParameterMetaData)this.postForAll(methodObject26600, this.onErrorForAll(methodObject26600, var2));
      }
   }

   public void setArrayAtName(String arg0, Array arg1) throws SQLException {
      try {
         super.preForAll(methodObject26706, this, arg0, arg1);
         this.delegate.setArrayAtName(arg0, arg1 instanceof _Proxy_ ? (Array)((_Proxy_)arg1)._getDelegate_() : arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject26706, var4);
      }
   }

   public void setStringForClob(int arg0, String arg1) throws SQLException {
      try {
         super.preForAll(methodObject26764, this, arg0, arg1);
         this.delegate.setStringForClob(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject26764, var4);
      }
   }

   public void setINTERVALYM(int arg0, INTERVALYM arg1) throws SQLException {
      try {
         super.preForAll(methodObject26777, this, arg0, arg1);
         this.delegate.setINTERVALYM(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject26777, var4);
      }
   }

   public void setAsciiStream(int arg0, InputStream arg1, long arg2) throws SQLException {
      try {
         super.preForSetStreams(methodObject26583, this, arg0, arg1, arg2);
         this.delegate.setAsciiStream(arg0, arg1, arg2);
      } catch (SQLException var6) {
         this.onErrorVoidForAll(methodObject26583, var6);
      }
   }

   public void setNCharacterStreamAtName(String arg0, Reader arg1) throws SQLException {
      try {
         super.preForSetStreams(methodObject26678, this, arg0, arg1);
         this.delegate.setNCharacterStreamAtName(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject26678, var4);
      }
   }

   public int getMaxFieldSize() throws SQLException {
      try {
         super.preForAll(methodObject26647, this, zeroLengthObjectArray);
         return (Integer)this.postForAll(methodObject26647, this.delegate.getMaxFieldSize());
      } catch (SQLException var2) {
         return (Integer)this.postForAll(methodObject26647, this.onErrorForAll(methodObject26647, var2));
      }
   }

   public void setFloat(String arg0, float arg1) throws SQLException {
      try {
         super.preForAll(methodObject26385, this, arg0, arg1);
         this.delegate.setFloat(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject26385, var4);
      }
   }

   public void setInt(int arg0, int arg1) throws SQLException {
      try {
         super.preForAll(methodObject26574, this, arg0, arg1);
         this.delegate.setInt(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject26574, var4);
      }
   }

   public OracleCallableStatement _getDelegate_() {
      return this.delegate;
   }

   public Object getDelegate() {
      return this.delegate;
   }

   public void setDelegate(Object delegate) {
      this.proxyFactory.updateDelegate(this, this.delegate, delegate);
      this.delegate = (OracleCallableStatement)delegate;
   }

   public Object getCreator() {
      return this.creator;
   }

   static {
      try {
         methodObject26626 = Statement.class.getDeclaredMethod("execute", String.class);
         methodObject26432 = OracleCallableStatement.class.getDeclaredMethod("getOPAQUE", Integer.TYPE);
         methodObject26414 = OracleCallableStatement.class.getDeclaredMethod("setNull", String.class, Integer.TYPE, String.class);
         methodObject26503 = CallableStatement.class.getDeclaredMethod("getDouble", Integer.TYPE);
         methodObject26440 = OracleCallableStatement.class.getDeclaredMethod("getTIMESTAMPTZ", Integer.TYPE);
         methodObject26635 = Statement.class.getDeclaredMethod("executeUpdate", String.class, int[].class);
         methodObject26572 = PreparedStatement.class.getDeclaredMethod("setDouble", Integer.TYPE, Double.TYPE);
         methodObject26557 = CallableStatement.class.getDeclaredMethod("setRowId", String.class, RowId.class);
         methodObject26619 = PreparedStatement.class.getDeclaredMethod("setNull", Integer.TYPE, Integer.TYPE);
         methodObject26499 = CallableStatement.class.getDeclaredMethod("getLong", Integer.TYPE);
         methodObject26633 = Statement.class.getDeclaredMethod("executeUpdate", String.class);
         methodObject26705 = OraclePreparedStatement.class.getDeclaredMethod("setROWIDAtName", String.class, ROWID.class);
         methodObject26618 = PreparedStatement.class.getDeclaredMethod("setNString", Integer.TYPE, String.class);
         methodObject26517 = CallableStatement.class.getDeclaredMethod("getDate", String.class);
         methodObject26680 = OraclePreparedStatement.class.getDeclaredMethod("setObjectAtName", String.class, Object.class, Integer.TYPE, Integer.TYPE);
         methodObject26602 = PreparedStatement.class.getDeclaredMethod("setTime", Integer.TYPE, Time.class, Calendar.class);
         methodObject26695 = OraclePreparedStatement.class.getDeclaredMethod("setDoubleAtName", String.class, Double.TYPE);
         methodObject26655 = Statement.class.getDeclaredMethod("isCloseOnCompletion");
         methodObject26757 = OraclePreparedStatement.class.getDeclaredMethod("setNStringAtName", String.class, String.class);
         methodObject26782 = OraclePreparedStatement.class.getDeclaredMethod("setARRAY", Integer.TYPE, ARRAY.class);
         methodObject26735 = OraclePreparedStatement.class.getDeclaredMethod("setTIMESTAMPAtName", String.class, TIMESTAMP.class);
         methodObject26542 = CallableStatement.class.getDeclaredMethod("wasNull");
         methodObject26653 = Statement.class.getDeclaredMethod("getResultSetType");
         methodObject26719 = OraclePreparedStatement.class.getDeclaredMethod("setCLOBAtName", String.class, CLOB.class);
         methodObject26512 = CallableStatement.class.getDeclaredMethod("getRef", String.class);
         methodObject26642 = Statement.class.getDeclaredMethod("getResultSetHoldability");
         methodObject26683 = OraclePreparedStatement.class.getDeclaredMethod("defineParameterTypeBytes", Integer.TYPE, Integer.TYPE, Integer.TYPE);
         methodObject26409 = OracleCallableStatement.class.getDeclaredMethod("registerOutParameter", Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE);
         methodObject26549 = CallableStatement.class.getDeclaredMethod("setBlob", String.class, InputStream.class, Long.TYPE);
         methodObject26713 = OraclePreparedStatement.class.getDeclaredMethod("setDATEAtName", String.class, DATE.class);
         methodObject26641 = Statement.class.getDeclaredMethod("clearWarnings");
         methodObject26454 = OracleCallableStatement.class.getDeclaredMethod("setBytesForBlob", String.class, byte[].class);
         methodObject26770 = OraclePreparedStatement.class.getDeclaredMethod("setCHAR", Integer.TYPE, CHAR.class);
         methodObject26427 = OracleCallableStatement.class.getDeclaredMethod("getCustomDatum", Integer.TYPE, CustomDatumFactory.class);
         methodObject26776 = OraclePreparedStatement.class.getDeclaredMethod("setBfile", Integer.TYPE, BFILE.class);
         methodObject26685 = OraclePreparedStatement.class.getDeclaredMethod("defineParameterType", Integer.TYPE, Integer.TYPE, Integer.TYPE);
         methodObject26485 = CallableStatement.class.getDeclaredMethod("getObject", Integer.TYPE);
         methodObject26786 = OraclePreparedStatement.class.getDeclaredMethod("setCustomDatum", Integer.TYPE, CustomDatum.class);
         methodObject26599 = PreparedStatement.class.getDeclaredMethod("getMetaData");
         methodObject26661 = Statement.class.getDeclaredMethod("setPoolable", Boolean.TYPE);
         methodObject26461 = OracleCallableStatement.class.getDeclaredMethod("setNUMBER", String.class, NUMBER.class);
         methodObject26715 = OraclePreparedStatement.class.getDeclaredMethod("setBLOBAtName", String.class, BLOB.class);
         methodObject26535 = CallableStatement.class.getDeclaredMethod("getSQLXML", Integer.TYPE);
         methodObject26522 = CallableStatement.class.getDeclaredMethod("setBinaryStream", String.class, InputStream.class);
         methodObject26556 = CallableStatement.class.getDeclaredMethod("setNString", String.class, String.class);
         methodObject26496 = CallableStatement.class.getDeclaredMethod("getShort", String.class);
         methodObject26796 = OracleStatement.class.getDeclaredMethod("defineColumnType", Integer.TYPE, Integer.TYPE, String.class);
         methodObject26527 = CallableStatement.class.getDeclaredMethod("getBlob", Integer.TYPE);
         methodObject26646 = Statement.class.getDeclaredMethod("getGeneratedKeys");
         methodObject26391 = OracleCallableStatement.class.getDeclaredMethod("setURL", String.class, URL.class);
         methodObject26490 = CallableStatement.class.getDeclaredMethod("getObject", String.class, Class.class);
         methodObject26629 = Statement.class.getDeclaredMethod("execute", String.class, String[].class);
         methodObject26669 = OraclePreparedStatement.class.getDeclaredMethod("setAsciiStreamAtName", String.class, InputStream.class, Integer.TYPE);
         methodObject26564 = CallableStatement.class.getDeclaredMethod("getNString", Integer.TYPE);
         methodObject26544 = CallableStatement.class.getDeclaredMethod("registerOutParameter", Integer.TYPE, Integer.TYPE, Integer.TYPE);
         methodObject26663 = Statement.class.getDeclaredMethod("getFetchDirection");
         methodObject26771 = OraclePreparedStatement.class.getDeclaredMethod("setDATE", Integer.TYPE, DATE.class);
         methodObject26609 = PreparedStatement.class.getDeclaredMethod("setBlob", Integer.TYPE, Blob.class);
         methodObject26610 = PreparedStatement.class.getDeclaredMethod("setBlob", Integer.TYPE, InputStream.class, Long.TYPE);
         methodObject26589 = PreparedStatement.class.getDeclaredMethod("setCharacterStream", Integer.TYPE, Reader.class, Long.TYPE);
         methodObject26456 = OracleCallableStatement.class.getDeclaredMethod("setCursor", String.class, ResultSet.class);
         methodObject26746 = OraclePreparedStatement.class.getDeclaredMethod("setPlsqlIndexTable", Integer.TYPE, Object.class, Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE);
         methodObject26480 = OracleCallableStatement.class.getDeclaredMethod("registerOutParameterAtName", String.class, Integer.TYPE);
         methodObject26395 = OracleCallableStatement.class.getDeclaredMethod("setUnicodeStream", String.class, InputStream.class, Integer.TYPE);
         methodObject26762 = OraclePreparedStatement.class.getDeclaredMethod("setBinaryDouble", Integer.TYPE, Double.TYPE);
         methodObject26785 = OraclePreparedStatement.class.getDeclaredMethod("setSTRUCT", Integer.TYPE, STRUCT.class);
         methodObject26492 = CallableStatement.class.getDeclaredMethod("getBoolean", String.class);
         methodObject26390 = OracleCallableStatement.class.getDeclaredMethod("setTimestamp", String.class, Timestamp.class, Calendar.class);
         methodObject26790 = OraclePreparedStatement.class.getDeclaredMethod("setOracleObject", Integer.TYPE, Datum.class);
         methodObject26449 = OracleCallableStatement.class.getDeclaredMethod("setBinaryFloat", String.class, BINARY_FLOAT.class);
         methodObject26611 = PreparedStatement.class.getDeclaredMethod("setBlob", Integer.TYPE, InputStream.class);
         methodObject26792 = OracleStatement.class.getDeclaredMethod("clearDefines");
         methodObject26765 = OraclePreparedStatement.class.getDeclaredMethod("setBytesForBlob", Integer.TYPE, byte[].class);
         methodObject26711 = OraclePreparedStatement.class.getDeclaredMethod("setRAWAtName", String.class, RAW.class);
         methodObject26471 = OracleCallableStatement.class.getDeclaredMethod("setARRAY", String.class, ARRAY.class);
         methodObject26789 = OraclePreparedStatement.class.getDeclaredMethod("setREF", Integer.TYPE, REF.class);
         methodObject26767 = OraclePreparedStatement.class.getDeclaredMethod("setCursor", Integer.TYPE, ResultSet.class);
         methodObject26709 = OraclePreparedStatement.class.getDeclaredMethod("setStructDescriptorAtName", String.class, StructDescriptor.class);
         methodObject26422 = OracleCallableStatement.class.getDeclaredMethod("getBFILE", Integer.TYPE);
         methodObject26565 = CallableStatement.class.getDeclaredMethod("getNString", String.class);
         methodObject26418 = OracleCallableStatement.class.getDeclaredMethod("getUnicodeStream", Integer.TYPE);
         methodObject26595 = PreparedStatement.class.getDeclaredMethod("setObject", Integer.TYPE, Object.class, Integer.TYPE);
         methodObject26783 = OraclePreparedStatement.class.getDeclaredMethod("setOPAQUE", Integer.TYPE, OPAQUE.class);
         methodObject26729 = OraclePreparedStatement.class.getDeclaredMethod("setTimeAtName", String.class, Time.class);
         methodObject26382 = OracleCallableStatement.class.getDeclaredMethod("setBoolean", String.class, Boolean.TYPE);
         methodObject26410 = OracleCallableStatement.class.getDeclaredMethod("registerOutParameter", String.class, Integer.TYPE, Integer.TYPE, Integer.TYPE);
         methodObject26431 = OracleCallableStatement.class.getDeclaredMethod("getNUMBER", Integer.TYPE);
         methodObject26723 = OraclePreparedStatement.class.getDeclaredMethod("setBFILEAtName", String.class, BFILE.class);
         methodObject26630 = Statement.class.getDeclaredMethod("cancel");
         methodObject26459 = OracleCallableStatement.class.getDeclaredMethod("setCHAR", String.class, CHAR.class);
         methodObject26524 = CallableStatement.class.getDeclaredMethod("setCharacterStream", String.class, Reader.class);
         methodObject26662 = Statement.class.getDeclaredMethod("setQueryTimeout", Integer.TYPE);
         methodObject26802 = OracleStatement.class.getDeclaredMethod("setLobPrefetchSize", Integer.TYPE);
         methodObject26803 = OracleStatement.class.getDeclaredMethod("closeWithKey", String.class);
         methodObject26396 = OracleCallableStatement.class.getDeclaredMethod("getBinaryStream", Integer.TYPE);
         methodObject26420 = OracleCallableStatement.class.getDeclaredMethod("getOracleObject", Integer.TYPE);
         methodObject26400 = OracleCallableStatement.class.getDeclaredMethod("setObject", String.class, Object.class, Integer.TYPE);
         methodObject26417 = OracleCallableStatement.class.getDeclaredMethod("setRef", String.class, Ref.class);
         methodObject26550 = CallableStatement.class.getDeclaredMethod("setBlob", String.class, InputStream.class);
         methodObject26591 = PreparedStatement.class.getDeclaredMethod("setNCharacterStream", Integer.TYPE, Reader.class, Long.TYPE);
         methodObject26781 = OraclePreparedStatement.class.getDeclaredMethod("setTIMESTAMPLTZ", Integer.TYPE, TIMESTAMPLTZ.class);
         methodObject26615 = PreparedStatement.class.getDeclaredMethod("setNClob", Integer.TYPE, NClob.class);
         methodObject26476 = OracleCallableStatement.class.getDeclaredMethod("setORAData", String.class, ORAData.class);
         methodObject26558 = CallableStatement.class.getDeclaredMethod("setSQLXML", String.class, SQLXML.class);
         methodObject26537 = CallableStatement.class.getDeclaredMethod("getTime", Integer.TYPE);
         methodObject26603 = PreparedStatement.class.getDeclaredMethod("setDate", Integer.TYPE, Date.class);
         methodObject26387 = OracleCallableStatement.class.getDeclaredMethod("setLong", String.class, Long.TYPE);
         methodObject26634 = Statement.class.getDeclaredMethod("executeUpdate", String.class, Integer.TYPE);
         methodObject26394 = OracleCallableStatement.class.getDeclaredMethod("setCharacterStream", String.class, Reader.class, Integer.TYPE);
         methodObject26442 = OracleCallableStatement.class.getDeclaredMethod("registerOutParameterBytes", Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE);
         methodObject26451 = OracleCallableStatement.class.getDeclaredMethod("setBinaryDouble", String.class, BINARY_DOUBLE.class);
         methodObject26690 = OraclePreparedStatement.class.getDeclaredMethod("setByteAtName", String.class, Byte.TYPE);
         methodObject26728 = OraclePreparedStatement.class.getDeclaredMethod("setDateAtName", String.class, Date.class, Calendar.class);
         methodObject26559 = CallableStatement.class.getDeclaredMethod("getBigDecimal", Integer.TYPE, Integer.TYPE);
         methodObject26726 = OraclePreparedStatement.class.getDeclaredMethod("setBytesForBlobAtName", String.class, byte[].class);
         methodObject26638 = Statement.class.getDeclaredMethod("executeQuery", String.class);
         methodObject26573 = PreparedStatement.class.getDeclaredMethod("setFloat", Integer.TYPE, Float.TYPE);
         methodObject26758 = OraclePreparedStatement.class.getDeclaredMethod("setRowIdAtName", String.class, RowId.class);
         methodObject26543 = CallableStatement.class.getDeclaredMethod("registerOutParameter", Integer.TYPE, Integer.TYPE);
         methodObject26775 = OraclePreparedStatement.class.getDeclaredMethod("setBFILE", Integer.TYPE, BFILE.class);
         methodObject26622 = PreparedStatement.class.getDeclaredMethod("setSQLXML", Integer.TYPE, SQLXML.class);
         methodObject26740 = OraclePreparedStatement.class.getDeclaredMethod("setRefTypeAtName", String.class, REF.class);
         methodObject26784 = OraclePreparedStatement.class.getDeclaredMethod("setStructDescriptor", Integer.TYPE, StructDescriptor.class);
         methodObject26648 = Statement.class.getDeclaredMethod("getMaxRows");
         methodObject26606 = PreparedStatement.class.getDeclaredMethod("addBatch");
         methodObject26511 = CallableStatement.class.getDeclaredMethod("getRef", Integer.TYPE);
         methodObject26445 = OracleCallableStatement.class.getDeclaredMethod("getPlsqlIndexTable", Integer.TYPE);
         methodObject26515 = CallableStatement.class.getDeclaredMethod("getDate", Integer.TYPE);
         methodObject26748 = OraclePreparedStatement.class.getDeclaredMethod("setDisableStmtCaching", Boolean.TYPE);
         methodObject26651 = Statement.class.getDeclaredMethod("getQueryTimeout");
         methodObject26579 = PreparedStatement.class.getDeclaredMethod("setURL", Integer.TYPE, URL.class);
         methodObject26617 = PreparedStatement.class.getDeclaredMethod("setNClob", Integer.TYPE, Reader.class);
         methodObject26702 = OraclePreparedStatement.class.getDeclaredMethod("setStringForClobAtName", String.class, String.class);
         methodObject26608 = PreparedStatement.class.getDeclaredMethod("setBigDecimal", Integer.TYPE, BigDecimal.class);
         methodObject26620 = PreparedStatement.class.getDeclaredMethod("setNull", Integer.TYPE, Integer.TYPE, String.class);
         methodObject26516 = CallableStatement.class.getDeclaredMethod("getDate", Integer.TYPE, Calendar.class);
         methodObject26555 = CallableStatement.class.getDeclaredMethod("setNClob", String.class, Reader.class);
         methodObject26434 = OracleCallableStatement.class.getDeclaredMethod("getREF", Integer.TYPE);
         methodObject26689 = OraclePreparedStatement.class.getDeclaredMethod("setBooleanAtName", String.class, Boolean.TYPE);
         methodObject26465 = OracleCallableStatement.class.getDeclaredMethod("setBfile", String.class, BFILE.class);
         methodObject26508 = CallableStatement.class.getDeclaredMethod("getArray", String.class);
         methodObject26752 = OraclePreparedStatement.class.getDeclaredMethod("registerReturnParameter", Integer.TYPE, Integer.TYPE, String.class);
         methodObject26405 = OracleCallableStatement.class.getDeclaredMethod("setDate", String.class, Date.class, Calendar.class);
         methodObject26745 = OraclePreparedStatement.class.getDeclaredMethod("setCheckBindTypes", Boolean.TYPE);
         methodObject26493 = CallableStatement.class.getDeclaredMethod("getByte", Integer.TYPE);
         methodObject26484 = OracleCallableStatement.class.getDeclaredMethod("getARRAY", Integer.TYPE);
         methodObject26464 = OracleCallableStatement.class.getDeclaredMethod("setBFILE", String.class, BFILE.class);
         methodObject26423 = OracleCallableStatement.class.getDeclaredMethod("getBfile", Integer.TYPE);
         methodObject26804 = OracleStatement.class.getDeclaredMethod("creationState");
         methodObject26529 = CallableStatement.class.getDeclaredMethod("getClob", Integer.TYPE);
         methodObject26477 = OracleCallableStatement.class.getDeclaredMethod("setRefType", String.class, REF.class);
         methodObject26718 = OraclePreparedStatement.class.getDeclaredMethod("setBlobAtName", String.class, InputStream.class);
         methodObject26504 = CallableStatement.class.getDeclaredMethod("getDouble", String.class);
         methodObject26489 = CallableStatement.class.getDeclaredMethod("getObject", Integer.TYPE, Class.class);
         methodObject26772 = OraclePreparedStatement.class.getDeclaredMethod("setNUMBER", Integer.TYPE, NUMBER.class);
         methodObject26567 = CallableStatement.class.getDeclaredMethod("getTimestamp", Integer.TYPE, Calendar.class);
         methodObject26482 = OracleCallableStatement.class.getDeclaredMethod("registerOutParameterAtName", String.class, Integer.TYPE, String.class);
         methodObject26406 = OracleCallableStatement.class.getDeclaredMethod("getAsciiStream", Integer.TYPE);
         methodObject26392 = OracleCallableStatement.class.getDeclaredMethod("setAsciiStream", String.class, InputStream.class, Integer.TYPE);
         methodObject26743 = OraclePreparedStatement.class.getDeclaredMethod("setOracleObjectAtName", String.class, Datum.class);
         methodObject26700 = OraclePreparedStatement.class.getDeclaredMethod("setBigDecimalAtName", String.class, BigDecimal.class);
         methodObject26458 = OracleCallableStatement.class.getDeclaredMethod("setRAW", String.class, RAW.class);
         methodObject26494 = CallableStatement.class.getDeclaredMethod("getByte", String.class);
         methodObject26674 = OraclePreparedStatement.class.getDeclaredMethod("setBinaryStreamAtName", String.class, InputStream.class);
         methodObject26742 = OraclePreparedStatement.class.getDeclaredMethod("setREFAtName", String.class, REF.class);
         methodObject26644 = Statement.class.getDeclaredMethod("clearBatch");
         methodObject26650 = Statement.class.getDeclaredMethod("getMoreResults", Integer.TYPE);
         methodObject26568 = CallableStatement.class.getDeclaredMethod("getTimestamp", String.class);
         methodObject26623 = PreparedStatement.class.getDeclaredMethod("setArray", Integer.TYPE, Array.class);
         methodObject26436 = OracleCallableStatement.class.getDeclaredMethod("getSTRUCT", Integer.TYPE);
         methodObject26582 = PreparedStatement.class.getDeclaredMethod("setAsciiStream", Integer.TYPE, InputStream.class, Integer.TYPE);
         methodObject26798 = OracleStatement.class.getDeclaredMethod("defineColumnTypeChars", Integer.TYPE, Integer.TYPE, Integer.TYPE);
         methodObject26530 = CallableStatement.class.getDeclaredMethod("getClob", String.class);
         methodObject26441 = OracleCallableStatement.class.getDeclaredMethod("getTIMESTAMPLTZ", Integer.TYPE);
         methodObject26601 = PreparedStatement.class.getDeclaredMethod("setTime", Integer.TYPE, Time.class);
         methodObject26478 = OracleCallableStatement.class.getDeclaredMethod("setREF", String.class, REF.class);
         methodObject26448 = OracleCallableStatement.class.getDeclaredMethod("registerIndexTableOutParameter", Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE);
         methodObject26502 = CallableStatement.class.getDeclaredMethod("getFloat", String.class);
         methodObject26720 = OraclePreparedStatement.class.getDeclaredMethod("setClobAtName", String.class, Clob.class);
         methodObject26475 = OracleCallableStatement.class.getDeclaredMethod("setCustomDatum", String.class, CustomDatum.class);
         methodObject26666 = Statement.class.getDeclaredMethod("setFetchSize", Integer.TYPE);
         methodObject26664 = Statement.class.getDeclaredMethod("getFetchSize");
         methodObject26657 = Statement.class.getDeclaredMethod("setCursorName", String.class);
         methodObject26594 = PreparedStatement.class.getDeclaredMethod("setBytes", Integer.TYPE, byte[].class);
         methodObject26402 = OracleCallableStatement.class.getDeclaredMethod("setTime", String.class, Time.class);
         methodObject26585 = PreparedStatement.class.getDeclaredMethod("setBinaryStream", Integer.TYPE, InputStream.class, Integer.TYPE);
         methodObject26806 = OracleStatement.class.getDeclaredMethod("getRegisteredTableNames");
         methodObject26523 = CallableStatement.class.getDeclaredMethod("setCharacterStream", String.class, Reader.class, Long.TYPE);
         methodObject26607 = PreparedStatement.class.getDeclaredMethod("clearParameters");
         methodObject26488 = CallableStatement.class.getDeclaredMethod("getObject", String.class, Map.class);
         methodObject26668 = Wrapper.class.getDeclaredMethod("isWrapperFor", Class.class);
         methodObject26467 = OracleCallableStatement.class.getDeclaredMethod("setINTERVALDS", String.class, INTERVALDS.class);
         methodObject26707 = OraclePreparedStatement.class.getDeclaredMethod("setARRAYAtName", String.class, ARRAY.class);
         methodObject26412 = OracleCallableStatement.class.getDeclaredMethod("setBlob", String.class, Blob.class);
         methodObject26580 = PreparedStatement.class.getDeclaredMethod("execute");
         methodObject26676 = OraclePreparedStatement.class.getDeclaredMethod("setCharacterStreamAtName", String.class, Reader.class);
         methodObject26407 = OracleCallableStatement.class.getDeclaredMethod("getCharacterStream", Integer.TYPE);
         methodObject26534 = CallableStatement.class.getDeclaredMethod("getRowId", String.class);
         methodObject26738 = OraclePreparedStatement.class.getDeclaredMethod("setCustomDatumAtName", String.class, CustomDatum.class);
         methodObject26552 = CallableStatement.class.getDeclaredMethod("setClob", String.class, Reader.class);
         methodObject26545 = CallableStatement.class.getDeclaredMethod("registerOutParameter", Integer.TYPE, Integer.TYPE, String.class);
         methodObject26744 = OraclePreparedStatement.class.getDeclaredMethod("setURLAtName", String.class, URL.class);
         methodObject26521 = CallableStatement.class.getDeclaredMethod("setBinaryStream", String.class, InputStream.class, Long.TYPE);
         methodObject26447 = OracleCallableStatement.class.getDeclaredMethod("getOraclePlsqlIndexTable", Integer.TYPE);
         methodObject26548 = CallableStatement.class.getDeclaredMethod("registerOutParameter", String.class, Integer.TYPE, String.class);
         methodObject26675 = OraclePreparedStatement.class.getDeclaredMethod("setCharacterStreamAtName", String.class, Reader.class, Long.TYPE);
         methodObject26497 = CallableStatement.class.getDeclaredMethod("getInt", Integer.TYPE);
         methodObject26712 = OraclePreparedStatement.class.getDeclaredMethod("setCHARAtName", String.class, CHAR.class);
         methodObject26540 = CallableStatement.class.getDeclaredMethod("getTime", String.class, Calendar.class);
         methodObject26419 = OracleCallableStatement.class.getDeclaredMethod("getUnicodeStream", String.class);
         methodObject26686 = OraclePreparedStatement.class.getDeclaredMethod("getExecuteBatch");
         methodObject26714 = OraclePreparedStatement.class.getDeclaredMethod("setNUMBERAtName", String.class, NUMBER.class);
         methodObject26778 = OraclePreparedStatement.class.getDeclaredMethod("setINTERVALDS", Integer.TYPE, INTERVALDS.class);
         methodObject26755 = OraclePreparedStatement.class.getDeclaredMethod("setNClobAtName", String.class, Reader.class, Long.TYPE);
         methodObject26708 = OraclePreparedStatement.class.getDeclaredMethod("setOPAQUEAtName", String.class, OPAQUE.class);
         methodObject26621 = PreparedStatement.class.getDeclaredMethod("setRowId", Integer.TYPE, RowId.class);
         methodObject26780 = OraclePreparedStatement.class.getDeclaredMethod("setTIMESTAMPTZ", Integer.TYPE, TIMESTAMPTZ.class);
         methodObject26446 = OracleCallableStatement.class.getDeclaredMethod("getPlsqlIndexTable", Integer.TYPE, Class.class);
         methodObject26401 = OracleCallableStatement.class.getDeclaredMethod("setObject", String.class, Object.class);
         methodObject26787 = OraclePreparedStatement.class.getDeclaredMethod("setORAData", Integer.TYPE, ORAData.class);
         methodObject26754 = OraclePreparedStatement.class.getDeclaredMethod("setNClobAtName", String.class, NClob.class);
         methodObject26571 = PreparedStatement.class.getDeclaredMethod("setByte", Integer.TYPE, Byte.TYPE);
         methodObject26381 = OracleCallableStatement.class.getDeclaredMethod("getObject", Integer.TYPE, OracleDataFactory.class);
         methodObject26677 = OraclePreparedStatement.class.getDeclaredMethod("setNCharacterStreamAtName", String.class, Reader.class, Long.TYPE);
         methodObject26514 = CallableStatement.class.getDeclaredMethod("getString", String.class);
         methodObject26800 = OracleStatement.class.getDeclaredMethod("setRowPrefetch", Integer.TYPE);
         methodObject26577 = PreparedStatement.class.getDeclaredMethod("setTimestamp", Integer.TYPE, Timestamp.class);
         methodObject26656 = Statement.class.getDeclaredMethod("isPoolable");
         methodObject26793 = OracleStatement.class.getDeclaredMethod("defineColumnType", Integer.TYPE, Integer.TYPE);
         methodObject26469 = OracleCallableStatement.class.getDeclaredMethod("setTIMESTAMPTZ", String.class, TIMESTAMPTZ.class);
         methodObject26593 = PreparedStatement.class.getDeclaredMethod("setUnicodeStream", Integer.TYPE, InputStream.class, Integer.TYPE);
         methodObject26506 = CallableStatement.class.getDeclaredMethod("getBytes", String.class);
         methodObject26654 = Statement.class.getDeclaredMethod("getUpdateCount");
         methodObject26597 = PreparedStatement.class.getDeclaredMethod("setObject", Integer.TYPE, Object.class, Integer.TYPE, Integer.TYPE);
         methodObject26513 = CallableStatement.class.getDeclaredMethod("getString", Integer.TYPE);
         methodObject26659 = Statement.class.getDeclaredMethod("setMaxFieldSize", Integer.TYPE);
         methodObject26670 = OraclePreparedStatement.class.getDeclaredMethod("setAsciiStreamAtName", String.class, InputStream.class, Long.TYPE);
         methodObject26587 = PreparedStatement.class.getDeclaredMethod("setBinaryStream", Integer.TYPE, InputStream.class);
         methodObject26671 = OraclePreparedStatement.class.getDeclaredMethod("setAsciiStreamAtName", String.class, InputStream.class);
         methodObject26632 = Statement.class.getDeclaredMethod("executeBatch");
         methodObject26526 = CallableStatement.class.getDeclaredMethod("setNCharacterStream", String.class, Reader.class);
         methodObject26658 = Statement.class.getDeclaredMethod("setEscapeProcessing", Boolean.TYPE);
         methodObject26691 = OraclePreparedStatement.class.getDeclaredMethod("setShortAtName", String.class, Short.TYPE);
         methodObject26612 = PreparedStatement.class.getDeclaredMethod("setClob", Integer.TYPE, Clob.class);
         methodObject26538 = CallableStatement.class.getDeclaredMethod("getTime", Integer.TYPE, Calendar.class);
         methodObject26416 = OracleCallableStatement.class.getDeclaredMethod("setArray", String.class, Array.class);
         methodObject26763 = OraclePreparedStatement.class.getDeclaredMethod("setBinaryDouble", Integer.TYPE, BINARY_DOUBLE.class);
         methodObject26525 = CallableStatement.class.getDeclaredMethod("setNCharacterStream", String.class, Reader.class, Long.TYPE);
         methodObject26749 = OraclePreparedStatement.class.getDeclaredMethod("OracleGetParameterMetaData");
         methodObject26501 = CallableStatement.class.getDeclaredMethod("getFloat", Integer.TYPE);
         methodObject26468 = OracleCallableStatement.class.getDeclaredMethod("setTIMESTAMP", String.class, TIMESTAMP.class);
         methodObject26388 = OracleCallableStatement.class.getDeclaredMethod("setShort", String.class, Short.TYPE);
         methodObject26439 = OracleCallableStatement.class.getDeclaredMethod("getTIMESTAMP", Integer.TYPE);
         methodObject26759 = OraclePreparedStatement.class.getDeclaredMethod("setSQLXMLAtName", String.class, SQLXML.class);
         methodObject26438 = OracleCallableStatement.class.getDeclaredMethod("getINTERVALDS", Integer.TYPE);
         methodObject26637 = Statement.class.getDeclaredMethod("isClosed");
         methodObject26731 = OraclePreparedStatement.class.getDeclaredMethod("setTimestampAtName", String.class, Timestamp.class);
         methodObject26483 = OracleCallableStatement.class.getDeclaredMethod("sendBatch");
         methodObject26562 = CallableStatement.class.getDeclaredMethod("getNCharacterStream", Integer.TYPE);
         methodObject26479 = OracleCallableStatement.class.getDeclaredMethod("setOracleObject", String.class, Datum.class);
         methodObject26590 = PreparedStatement.class.getDeclaredMethod("setCharacterStream", Integer.TYPE, Reader.class);
         methodObject26799 = OracleStatement.class.getDeclaredMethod("getRowPrefetch");
         methodObject26613 = PreparedStatement.class.getDeclaredMethod("setClob", Integer.TYPE, Reader.class, Long.TYPE);
         methodObject26463 = OracleCallableStatement.class.getDeclaredMethod("setCLOB", String.class, CLOB.class);
         methodObject26645 = Statement.class.getDeclaredMethod("closeOnCompletion");
         methodObject26696 = OraclePreparedStatement.class.getDeclaredMethod("setBinaryFloatAtName", String.class, Float.TYPE);
         methodObject26533 = CallableStatement.class.getDeclaredMethod("getRowId", Integer.TYPE);
         methodObject26510 = CallableStatement.class.getDeclaredMethod("getURL", String.class);
         methodObject26563 = CallableStatement.class.getDeclaredMethod("getNCharacterStream", String.class);
         methodObject26699 = OraclePreparedStatement.class.getDeclaredMethod("setBinaryDoubleAtName", String.class, BINARY_DOUBLE.class);
         methodObject26693 = OraclePreparedStatement.class.getDeclaredMethod("setLongAtName", String.class, Long.TYPE);
         methodObject26570 = PreparedStatement.class.getDeclaredMethod("setBoolean", Integer.TYPE, Boolean.TYPE);
         methodObject26721 = OraclePreparedStatement.class.getDeclaredMethod("setClobAtName", String.class, Reader.class, Long.TYPE);
         methodObject26701 = OraclePreparedStatement.class.getDeclaredMethod("setStringAtName", String.class, String.class);
         methodObject26561 = CallableStatement.class.getDeclaredMethod("getBigDecimal", String.class);
         methodObject26698 = OraclePreparedStatement.class.getDeclaredMethod("setBinaryDoubleAtName", String.class, Double.TYPE);
         methodObject26520 = CallableStatement.class.getDeclaredMethod("setAsciiStream", String.class, InputStream.class);
         methodObject26682 = OraclePreparedStatement.class.getDeclaredMethod("setObjectAtName", String.class, Object.class);
         methodObject26681 = OraclePreparedStatement.class.getDeclaredMethod("setObjectAtName", String.class, Object.class, Integer.TYPE);
         methodObject26539 = CallableStatement.class.getDeclaredMethod("getTime", String.class);
         methodObject26788 = OraclePreparedStatement.class.getDeclaredMethod("setRefType", Integer.TYPE, REF.class);
         methodObject26443 = OracleCallableStatement.class.getDeclaredMethod("registerOutParameterChars", Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE);
         methodObject26472 = OracleCallableStatement.class.getDeclaredMethod("setOPAQUE", String.class, OPAQUE.class);
         methodObject26673 = OraclePreparedStatement.class.getDeclaredMethod("setBinaryStreamAtName", String.class, InputStream.class, Long.TYPE);
         methodObject26769 = OraclePreparedStatement.class.getDeclaredMethod("setRAW", Integer.TYPE, RAW.class);
         methodObject26457 = OracleCallableStatement.class.getDeclaredMethod("setROWID", String.class, ROWID.class);
         methodObject26741 = OraclePreparedStatement.class.getDeclaredMethod("setRefAtName", String.class, Ref.class);
         methodObject26566 = CallableStatement.class.getDeclaredMethod("getTimestamp", Integer.TYPE);
         methodObject26404 = OracleCallableStatement.class.getDeclaredMethod("setDate", String.class, Date.class);
         methodObject26753 = OraclePreparedStatement.class.getDeclaredMethod("getReturnResultSet");
         methodObject26518 = CallableStatement.class.getDeclaredMethod("getDate", String.class, Calendar.class);
         methodObject26505 = CallableStatement.class.getDeclaredMethod("getBytes", Integer.TYPE);
         methodObject26725 = OraclePreparedStatement.class.getDeclaredMethod("setBytesAtName", String.class, byte[].class);
         methodObject26733 = OraclePreparedStatement.class.getDeclaredMethod("setINTERVALYMAtName", String.class, INTERVALYM.class);
         methodObject26692 = OraclePreparedStatement.class.getDeclaredMethod("setIntAtName", String.class, Integer.TYPE);
         methodObject26399 = OracleCallableStatement.class.getDeclaredMethod("setObject", String.class, Object.class, Integer.TYPE, Integer.TYPE);
         methodObject26393 = OracleCallableStatement.class.getDeclaredMethod("setBinaryStream", String.class, InputStream.class, Integer.TYPE);
         methodObject26760 = OraclePreparedStatement.class.getDeclaredMethod("setBinaryFloat", Integer.TYPE, Float.TYPE);
         methodObject26474 = OracleCallableStatement.class.getDeclaredMethod("setSTRUCT", String.class, STRUCT.class);
         methodObject26554 = CallableStatement.class.getDeclaredMethod("setNClob", String.class, Reader.class, Long.TYPE);
         methodObject26584 = PreparedStatement.class.getDeclaredMethod("setAsciiStream", Integer.TYPE, InputStream.class);
         methodObject26437 = OracleCallableStatement.class.getDeclaredMethod("getINTERVALYM", Integer.TYPE);
         methodObject26688 = OraclePreparedStatement.class.getDeclaredMethod("setNullAtName", String.class, Integer.TYPE);
         methodObject26643 = Statement.class.getDeclaredMethod("addBatch", String.class);
         methodObject26667 = Wrapper.class.getDeclaredMethod("unwrap", Class.class);
         methodObject26547 = CallableStatement.class.getDeclaredMethod("registerOutParameter", String.class, Integer.TYPE, Integer.TYPE);
         methodObject26652 = Statement.class.getDeclaredMethod("getResultSetConcurrency");
         methodObject26428 = OracleCallableStatement.class.getDeclaredMethod("getORAData", Integer.TYPE, ORADataFactory.class);
         methodObject26751 = OraclePreparedStatement.class.getDeclaredMethod("registerReturnParameter", Integer.TYPE, Integer.TYPE, Integer.TYPE);
         methodObject26732 = OraclePreparedStatement.class.getDeclaredMethod("setTimestampAtName", String.class, Timestamp.class, Calendar.class);
         methodObject26716 = OraclePreparedStatement.class.getDeclaredMethod("setBlobAtName", String.class, Blob.class);
         methodObject26596 = PreparedStatement.class.getDeclaredMethod("setObject", Integer.TYPE, Object.class);
         methodObject26750 = OraclePreparedStatement.class.getDeclaredMethod("registerReturnParameter", Integer.TYPE, Integer.TYPE);
         methodObject26687 = OraclePreparedStatement.class.getDeclaredMethod("setNullAtName", String.class, Integer.TYPE, String.class);
         methodObject26498 = CallableStatement.class.getDeclaredMethod("getInt", String.class);
         methodObject26624 = PreparedStatement.class.getDeclaredMethod("setRef", Integer.TYPE, Ref.class);
         methodObject26444 = OracleCallableStatement.class.getDeclaredMethod("setExecuteBatch", Integer.TYPE);
         methodObject26697 = OraclePreparedStatement.class.getDeclaredMethod("setBinaryFloatAtName", String.class, BINARY_FLOAT.class);
         methodObject26631 = Statement.class.getDeclaredMethod("getResultSet");
         methodObject26455 = OracleCallableStatement.class.getDeclaredMethod("setFixedCHAR", String.class, String.class);
         methodObject26795 = OracleStatement.class.getDeclaredMethod("defineColumnType", Integer.TYPE, Integer.TYPE, Integer.TYPE, Short.TYPE);
         methodObject26724 = OraclePreparedStatement.class.getDeclaredMethod("setBfileAtName", String.class, BFILE.class);
         methodObject26736 = OraclePreparedStatement.class.getDeclaredMethod("setTIMESTAMPTZAtName", String.class, TIMESTAMPTZ.class);
         methodObject26424 = OracleCallableStatement.class.getDeclaredMethod("getBLOB", Integer.TYPE);
         methodObject26794 = OracleStatement.class.getDeclaredMethod("defineColumnType", Integer.TYPE, Integer.TYPE, Integer.TYPE);
         methodObject26425 = OracleCallableStatement.class.getDeclaredMethod("getCHAR", Integer.TYPE);
         methodObject26807 = OracleStatement.class.getDeclaredMethod("getRegisteredQueryId");
         methodObject26727 = OraclePreparedStatement.class.getDeclaredMethod("setDateAtName", String.class, Date.class);
         methodObject26470 = OracleCallableStatement.class.getDeclaredMethod("setTIMESTAMPLTZ", String.class, TIMESTAMPLTZ.class);
         methodObject26766 = OraclePreparedStatement.class.getDeclaredMethod("setFixedCHAR", Integer.TYPE, String.class);
         methodObject26628 = Statement.class.getDeclaredMethod("execute", String.class, int[].class);
         methodObject26734 = OraclePreparedStatement.class.getDeclaredMethod("setINTERVALDSAtName", String.class, INTERVALDS.class);
         methodObject26411 = OracleCallableStatement.class.getDeclaredMethod("setBigDecimal", String.class, BigDecimal.class);
         methodObject26487 = CallableStatement.class.getDeclaredMethod("getObject", String.class);
         methodObject26649 = Statement.class.getDeclaredMethod("getMoreResults");
         methodObject26491 = CallableStatement.class.getDeclaredMethod("getBoolean", Integer.TYPE);
         methodObject26560 = CallableStatement.class.getDeclaredMethod("getBigDecimal", Integer.TYPE);
         methodObject26704 = OraclePreparedStatement.class.getDeclaredMethod("setCursorAtName", String.class, ResultSet.class);
         methodObject26679 = OraclePreparedStatement.class.getDeclaredMethod("setUnicodeStreamAtName", String.class, InputStream.class, Integer.TYPE);
         methodObject26466 = OracleCallableStatement.class.getDeclaredMethod("setINTERVALYM", String.class, INTERVALYM.class);
         methodObject26605 = PreparedStatement.class.getDeclaredMethod("setString", Integer.TYPE, String.class);
         methodObject26495 = CallableStatement.class.getDeclaredMethod("getShort", Integer.TYPE);
         methodObject26389 = OracleCallableStatement.class.getDeclaredMethod("setTimestamp", String.class, Timestamp.class);
         methodObject26636 = Statement.class.getDeclaredMethod("executeUpdate", String.class, String[].class);
         methodObject26413 = OracleCallableStatement.class.getDeclaredMethod("setClob", String.class, Clob.class);
         methodObject26415 = OracleCallableStatement.class.getDeclaredMethod("setNull", String.class, Integer.TYPE);
         methodObject26773 = OraclePreparedStatement.class.getDeclaredMethod("setBLOB", Integer.TYPE, BLOB.class);
         methodObject26627 = Statement.class.getDeclaredMethod("execute", String.class, Integer.TYPE);
         methodObject26756 = OraclePreparedStatement.class.getDeclaredMethod("setNClobAtName", String.class, Reader.class);
         methodObject26528 = CallableStatement.class.getDeclaredMethod("getBlob", String.class);
         methodObject26408 = OracleCallableStatement.class.getDeclaredMethod("setString", String.class, String.class);
         methodObject26486 = CallableStatement.class.getDeclaredMethod("getObject", Integer.TYPE, Map.class);
         methodObject26614 = PreparedStatement.class.getDeclaredMethod("setClob", Integer.TYPE, Reader.class);
         methodObject26598 = PreparedStatement.class.getDeclaredMethod("executeQuery");
         methodObject26519 = CallableStatement.class.getDeclaredMethod("setAsciiStream", String.class, InputStream.class, Long.TYPE);
         methodObject26429 = OracleCallableStatement.class.getDeclaredMethod("getAnyDataEmbeddedObject", Integer.TYPE);
         methodObject26509 = CallableStatement.class.getDeclaredMethod("getURL", Integer.TYPE);
         methodObject26703 = OraclePreparedStatement.class.getDeclaredMethod("setFixedCHARAtName", String.class, String.class);
         methodObject26768 = OraclePreparedStatement.class.getDeclaredMethod("setROWID", Integer.TYPE, ROWID.class);
         methodObject26553 = CallableStatement.class.getDeclaredMethod("setNClob", String.class, NClob.class);
         methodObject26640 = Statement.class.getDeclaredMethod("getWarnings");
         methodObject26779 = OraclePreparedStatement.class.getDeclaredMethod("setTIMESTAMP", Integer.TYPE, TIMESTAMP.class);
         methodObject26541 = CallableStatement.class.getDeclaredMethod("getCharacterStream", String.class);
         methodObject26430 = OracleCallableStatement.class.getDeclaredMethod("getDATE", Integer.TYPE);
         methodObject26426 = OracleCallableStatement.class.getDeclaredMethod("getCLOB", Integer.TYPE);
         methodObject26473 = OracleCallableStatement.class.getDeclaredMethod("setStructDescriptor", String.class, StructDescriptor.class);
         methodObject26639 = Statement.class.getDeclaredMethod("getConnection");
         methodObject26722 = OraclePreparedStatement.class.getDeclaredMethod("setClobAtName", String.class, Reader.class);
         methodObject26460 = OracleCallableStatement.class.getDeclaredMethod("setDATE", String.class, DATE.class);
         methodObject26569 = CallableStatement.class.getDeclaredMethod("getTimestamp", String.class, Calendar.class);
         methodObject26500 = CallableStatement.class.getDeclaredMethod("getLong", String.class);
         methodObject26660 = Statement.class.getDeclaredMethod("setMaxRows", Integer.TYPE);
         methodObject26747 = OraclePreparedStatement.class.getDeclaredMethod("setFormOfUse", Integer.TYPE, Short.TYPE);
         methodObject26435 = OracleCallableStatement.class.getDeclaredMethod("getROWID", Integer.TYPE);
         methodObject26481 = OracleCallableStatement.class.getDeclaredMethod("registerOutParameterAtName", String.class, Integer.TYPE, Integer.TYPE);
         methodObject26791 = OracleStatement.class.getDeclaredMethod("isNCHAR", Integer.TYPE);
         methodObject26625 = Statement.class.getDeclaredMethod("close");
         methodObject26421 = OracleCallableStatement.class.getDeclaredMethod("getCursor", Integer.TYPE);
         methodObject26730 = OraclePreparedStatement.class.getDeclaredMethod("setTimeAtName", String.class, Time.class, Calendar.class);
         methodObject26694 = OraclePreparedStatement.class.getDeclaredMethod("setFloatAtName", String.class, Float.TYPE);
         methodObject26433 = OracleCallableStatement.class.getDeclaredMethod("getRAW", Integer.TYPE);
         methodObject26462 = OracleCallableStatement.class.getDeclaredMethod("setBLOB", String.class, BLOB.class);
         methodObject26578 = PreparedStatement.class.getDeclaredMethod("setTimestamp", Integer.TYPE, Timestamp.class, Calendar.class);
         methodObject26586 = PreparedStatement.class.getDeclaredMethod("setBinaryStream", Integer.TYPE, InputStream.class, Long.TYPE);
         methodObject26531 = CallableStatement.class.getDeclaredMethod("getNClob", Integer.TYPE);
         methodObject26398 = OracleCallableStatement.class.getDeclaredMethod("setBytes", String.class, byte[].class);
         methodObject26386 = OracleCallableStatement.class.getDeclaredMethod("setInt", String.class, Integer.TYPE);
         methodObject26403 = OracleCallableStatement.class.getDeclaredMethod("setTime", String.class, Time.class, Calendar.class);
         methodObject26717 = OraclePreparedStatement.class.getDeclaredMethod("setBlobAtName", String.class, InputStream.class, Long.TYPE);
         methodObject26507 = CallableStatement.class.getDeclaredMethod("getArray", Integer.TYPE);
         methodObject26576 = PreparedStatement.class.getDeclaredMethod("setShort", Integer.TYPE, Short.TYPE);
         methodObject26450 = OracleCallableStatement.class.getDeclaredMethod("setBinaryFloat", String.class, Float.TYPE);
         methodObject26805 = OracleStatement.class.getDeclaredMethod("setDatabaseChangeRegistration", DatabaseChangeRegistration.class);
         methodObject26616 = PreparedStatement.class.getDeclaredMethod("setNClob", Integer.TYPE, Reader.class, Long.TYPE);
         methodObject26551 = CallableStatement.class.getDeclaredMethod("setClob", String.class, Reader.class, Long.TYPE);
         methodObject26581 = PreparedStatement.class.getDeclaredMethod("executeUpdate");
         methodObject26592 = PreparedStatement.class.getDeclaredMethod("setNCharacterStream", Integer.TYPE, Reader.class);
         methodObject26797 = OracleStatement.class.getDeclaredMethod("defineColumnTypeBytes", Integer.TYPE, Integer.TYPE, Integer.TYPE);
         methodObject26575 = PreparedStatement.class.getDeclaredMethod("setLong", Integer.TYPE, Long.TYPE);
         methodObject26604 = PreparedStatement.class.getDeclaredMethod("setDate", Integer.TYPE, Date.class, Calendar.class);
         methodObject26532 = CallableStatement.class.getDeclaredMethod("getNClob", String.class);
         methodObject26737 = OraclePreparedStatement.class.getDeclaredMethod("setTIMESTAMPLTZAtName", String.class, TIMESTAMPLTZ.class);
         methodObject26774 = OraclePreparedStatement.class.getDeclaredMethod("setCLOB", Integer.TYPE, CLOB.class);
         methodObject26383 = OracleCallableStatement.class.getDeclaredMethod("setByte", String.class, Byte.TYPE);
         methodObject26665 = Statement.class.getDeclaredMethod("setFetchDirection", Integer.TYPE);
         methodObject26453 = OracleCallableStatement.class.getDeclaredMethod("setStringForClob", String.class, String.class);
         methodObject26710 = OraclePreparedStatement.class.getDeclaredMethod("setSTRUCTAtName", String.class, STRUCT.class);
         methodObject26546 = CallableStatement.class.getDeclaredMethod("registerOutParameter", String.class, Integer.TYPE);
         methodObject26588 = PreparedStatement.class.getDeclaredMethod("setCharacterStream", Integer.TYPE, Reader.class, Integer.TYPE);
         methodObject26761 = OraclePreparedStatement.class.getDeclaredMethod("setBinaryFloat", Integer.TYPE, BINARY_FLOAT.class);
         methodObject26384 = OracleCallableStatement.class.getDeclaredMethod("setDouble", String.class, Double.TYPE);
         methodObject26452 = OracleCallableStatement.class.getDeclaredMethod("setBinaryDouble", String.class, Double.TYPE);
         methodObject26397 = OracleCallableStatement.class.getDeclaredMethod("getBinaryStream", String.class);
         methodObject26672 = OraclePreparedStatement.class.getDeclaredMethod("setBinaryStreamAtName", String.class, InputStream.class, Integer.TYPE);
         methodObject26739 = OraclePreparedStatement.class.getDeclaredMethod("setORADataAtName", String.class, ORAData.class);
         methodObject26801 = OracleStatement.class.getDeclaredMethod("getLobPrefetchSize");
         methodObject26684 = OraclePreparedStatement.class.getDeclaredMethod("defineParameterTypeChars", Integer.TYPE, Integer.TYPE, Integer.TYPE);
         methodObject26536 = CallableStatement.class.getDeclaredMethod("getSQLXML", String.class);
         methodObject26600 = PreparedStatement.class.getDeclaredMethod("getParameterMetaData");
         methodObject26706 = OraclePreparedStatement.class.getDeclaredMethod("setArrayAtName", String.class, Array.class);
         methodObject26764 = OraclePreparedStatement.class.getDeclaredMethod("setStringForClob", Integer.TYPE, String.class);
         methodObject26777 = OraclePreparedStatement.class.getDeclaredMethod("setINTERVALYM", Integer.TYPE, INTERVALYM.class);
         methodObject26583 = PreparedStatement.class.getDeclaredMethod("setAsciiStream", Integer.TYPE, InputStream.class, Long.TYPE);
         methodObject26678 = OraclePreparedStatement.class.getDeclaredMethod("setNCharacterStreamAtName", String.class, Reader.class);
         methodObject26647 = Statement.class.getDeclaredMethod("getMaxFieldSize");
         methodObject26385 = OracleCallableStatement.class.getDeclaredMethod("setFloat", String.class, Float.TYPE);
         methodObject26574 = PreparedStatement.class.getDeclaredMethod("setInt", Integer.TYPE, Integer.TYPE);
      } catch (Throwable var1) {
         throw new RuntimeException(var1);
      }
   }

   public oracle$1jdbc$1replay$1driver$1NonTxnReplayableStatement$2oracle$1jdbc$1OracleCallableStatement$$$Proxy(OracleCallableStatement var1, Object var2, ProxyFactory var3, Map var4) {
      this.delegate = var1;
      this.creator = var2;
      this.proxyFactory = var3;
      this.proxyCache = var4;
   }
}
