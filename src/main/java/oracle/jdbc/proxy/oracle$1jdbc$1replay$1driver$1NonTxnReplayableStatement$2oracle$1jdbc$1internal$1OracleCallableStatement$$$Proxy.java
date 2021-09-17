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
import oracle.jdbc.OracleDataFactory;
import oracle.jdbc.OracleParameterMetaData;
import oracle.jdbc.dcn.DatabaseChangeRegistration;
import oracle.jdbc.internal.ACProxyable;
import oracle.jdbc.internal.OracleCallableStatement;
import oracle.jdbc.internal.OraclePreparedStatement;
import oracle.jdbc.internal.OracleStatement;
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

public abstract class oracle$1jdbc$1replay$1driver$1NonTxnReplayableStatement$2oracle$1jdbc$1internal$1OracleCallableStatement$$$Proxy extends NonTxnReplayableStatement implements OracleCallableStatement, _Proxy_ {
   private OracleCallableStatement delegate;
   private final Object creator;
   private final ProxyFactory proxyFactory;
   private final Map proxyCache;
   private static Object[] zeroLengthObjectArray = new Object[0];
   private static Method methodObject27357;
   private static Method methodObject27164;
   private static Method methodObject27111;
   private static Method methodObject27146;
   private static Method methodObject27235;
   private static Method methodObject27172;
   private static Method methodObject27541;
   private static Method methodObject27366;
   private static Method methodObject27303;
   private static Method methodObject27288;
   private static Method methodObject27350;
   private static Method methodObject27231;
   private static Method methodObject27364;
   private static Method methodObject27436;
   private static Method methodObject27349;
   private static Method methodObject27249;
   private static Method methodObject27411;
   private static Method methodObject27333;
   private static Method methodObject27426;
   private static Method methodObject27386;
   private static Method methodObject27488;
   private static Method methodObject27513;
   private static Method methodObject27466;
   private static Method methodObject27273;
   private static Method methodObject27384;
   private static Method methodObject27450;
   private static Method methodObject27560;
   private static Method methodObject27244;
   private static Method methodObject27373;
   private static Method methodObject27414;
   private static Method methodObject27141;
   private static Method methodObject27280;
   private static Method methodObject27444;
   private static Method methodObject27372;
   private static Method methodObject27186;
   private static Method methodObject27501;
   private static Method methodObject27159;
   private static Method methodObject27507;
   private static Method methodObject27416;
   private static Method methodObject27217;
   private static Method methodObject27517;
   private static Method methodObject27330;
   private static Method methodObject27392;
   private static Method methodObject27193;
   private static Method methodObject27446;
   private static Method methodObject27267;
   private static Method methodObject27254;
   private static Method methodObject27287;
   private static Method methodObject27228;
   private static Method methodObject27527;
   private static Method methodObject27259;
   private static Method methodObject27377;
   private static Method methodObject27123;
   private static Method methodObject27222;
   private static Method methodObject27360;
   private static Method methodObject27400;
   private static Method methodObject27295;
   private static Method methodObject27275;
   private static Method methodObject27394;
   private static Method methodObject27502;
   private static Method methodObject27340;
   private static Method methodObject27341;
   private static Method methodObject27555;
   private static Method methodObject27320;
   private static Method methodObject27552;
   private static Method methodObject27188;
   private static Method methodObject27477;
   private static Method methodObject27212;
   private static Method methodObject27127;
   private static Method methodObject27493;
   private static Method methodObject27516;
   private static Method methodObject27224;
   private static Method methodObject27122;
   private static Method methodObject27521;
   private static Method methodObject27181;
   private static Method methodObject27342;
   private static Method methodObject27523;
   private static Method methodObject27496;
   private static Method methodObject27442;
   private static Method methodObject27203;
   private static Method methodObject27520;
   private static Method methodObject27498;
   private static Method methodObject27440;
   private static Method methodObject27154;
   private static Method methodObject27296;
   private static Method methodObject27150;
   private static Method methodObject27326;
   private static Method methodObject27514;
   private static Method methodObject27460;
   private static Method methodObject27114;
   private static Method methodObject27142;
   private static Method methodObject27163;
   private static Method methodObject27454;
   private static Method methodObject27361;
   private static Method methodObject27191;
   private static Method methodObject27256;
   private static Method methodObject27393;
   private static Method methodObject27533;
   private static Method methodObject27534;
   private static Method methodObject27128;
   private static Method methodObject27539;
   private static Method methodObject27152;
   private static Method methodObject27132;
   private static Method methodObject27149;
   private static Method methodObject27281;
   private static Method methodObject27322;
   private static Method methodObject27512;
   private static Method methodObject27346;
   private static Method methodObject27208;
   private static Method methodObject27289;
   private static Method methodObject27269;
   private static Method methodObject27334;
   private static Method methodObject27119;
   private static Method methodObject27365;
   private static Method methodObject27126;
   private static Method methodObject27174;
   private static Method methodObject27183;
   private static Method methodObject27421;
   private static Method methodObject27459;
   private static Method methodObject27290;
   private static Method methodObject27457;
   private static Method methodObject27369;
   private static Method methodObject27304;
   private static Method methodObject27489;
   private static Method methodObject27274;
   private static Method methodObject27506;
   private static Method methodObject27353;
   private static Method methodObject27471;
   private static Method methodObject27515;
   private static Method methodObject27379;
   private static Method methodObject27337;
   private static Method methodObject27243;
   private static Method methodObject27177;
   private static Method methodObject27247;
   private static Method methodObject27479;
   private static Method methodObject27382;
   private static Method methodObject27559;
   private static Method methodObject27310;
   private static Method methodObject27348;
   private static Method methodObject27433;
   private static Method methodObject27339;
   private static Method methodObject27351;
   private static Method methodObject27248;
   private static Method methodObject27286;
   private static Method methodObject27166;
   private static Method methodObject27546;
   private static Method methodObject27420;
   private static Method methodObject27197;
   private static Method methodObject27240;
   private static Method methodObject27483;
   private static Method methodObject27137;
   private static Method methodObject27548;
   private static Method methodObject27225;
   private static Method methodObject27216;
   private static Method methodObject27196;
   private static Method methodObject27155;
   private static Method methodObject27535;
   private static Method methodObject27261;
   private static Method methodObject27209;
   private static Method methodObject27449;
   private static Method methodObject27236;
   private static Method methodObject27221;
   private static Method methodObject27503;
   private static Method methodObject27298;
   private static Method methodObject27214;
   private static Method methodObject27138;
   private static Method methodObject27124;
   private static Method methodObject27474;
   private static Method methodObject27431;
   private static Method methodObject27190;
   private static Method methodObject27545;
   private static Method methodObject27226;
   private static Method methodObject27405;
   private static Method methodObject27473;
   private static Method methodObject27551;
   private static Method methodObject27375;
   private static Method methodObject27381;
   private static Method methodObject27299;
   private static Method methodObject27354;
   private static Method methodObject27168;
   private static Method methodObject27313;
   private static Method methodObject27529;
   private static Method methodObject27262;
   private static Method methodObject27173;
   private static Method methodObject27332;
   private static Method methodObject27210;
   private static Method methodObject27180;
   private static Method methodObject27234;
   private static Method methodObject27558;
   private static Method methodObject27451;
   private static Method methodObject27207;
   private static Method methodObject27397;
   private static Method methodObject27395;
   private static Method methodObject27388;
   private static Method methodObject27325;
   private static Method methodObject27547;
   private static Method methodObject27134;
   private static Method methodObject27316;
   private static Method methodObject27537;
   private static Method methodObject27255;
   private static Method methodObject27338;
   private static Method methodObject27220;
   private static Method methodObject27399;
   private static Method methodObject27199;
   private static Method methodObject27438;
   private static Method methodObject27144;
   private static Method methodObject27311;
   private static Method methodObject27407;
   private static Method methodObject27139;
   private static Method methodObject27112;
   private static Method methodObject27266;
   private static Method methodObject27469;
   private static Method methodObject27283;
   private static Method methodObject27276;
   private static Method methodObject27475;
   private static Method methodObject27253;
   private static Method methodObject27179;
   private static Method methodObject27279;
   private static Method methodObject27406;
   private static Method methodObject27229;
   private static Method methodObject27443;
   private static Method methodObject27272;
   private static Method methodObject27151;
   private static Method methodObject27417;
   private static Method methodObject27445;
   private static Method methodObject27509;
   private static Method methodObject27486;
   private static Method methodObject27439;
   private static Method methodObject27352;
   private static Method methodObject27557;
   private static Method methodObject27511;
   private static Method methodObject27178;
   private static Method methodObject27133;
   private static Method methodObject27518;
   private static Method methodObject27485;
   private static Method methodObject27302;
   private static Method methodObject27113;
   private static Method methodObject27408;
   private static Method methodObject27246;
   private static Method methodObject27531;
   private static Method methodObject27308;
   private static Method methodObject27387;
   private static Method methodObject27524;
   private static Method methodObject27201;
   private static Method methodObject27324;
   private static Method methodObject27238;
   private static Method methodObject27385;
   private static Method methodObject27328;
   private static Method methodObject27245;
   private static Method methodObject27390;
   private static Method methodObject27401;
   private static Method methodObject27318;
   private static Method methodObject27402;
   private static Method methodObject27363;
   private static Method methodObject27258;
   private static Method methodObject27389;
   private static Method methodObject27422;
   private static Method methodObject27343;
   private static Method methodObject27494;
   private static Method methodObject27270;
   private static Method methodObject27148;
   private static Method methodObject27257;
   private static Method methodObject27480;
   private static Method methodObject27233;
   private static Method methodObject27200;
   private static Method methodObject27120;
   private static Method methodObject27171;
   private static Method methodObject27490;
   private static Method methodObject27170;
   private static Method methodObject27368;
   private static Method methodObject27462;
   private static Method methodObject27556;
   private static Method methodObject27293;
   private static Method methodObject27211;
   private static Method methodObject27321;
   private static Method methodObject27530;
   private static Method methodObject27109;
   private static Method methodObject27344;
   private static Method methodObject27195;
   private static Method methodObject27376;
   private static Method methodObject27427;
   private static Method methodObject27265;
   private static Method methodObject27242;
   private static Method methodObject27294;
   private static Method methodObject27430;
   private static Method methodObject27561;
   private static Method methodObject27424;
   private static Method methodObject27301;
   private static Method methodObject27452;
   private static Method methodObject27432;
   private static Method methodObject27292;
   private static Method methodObject27429;
   private static Method methodObject27252;
   private static Method methodObject27413;
   private static Method methodObject27412;
   private static Method methodObject27271;
   private static Method methodObject27519;
   private static Method methodObject27175;
   private static Method methodObject27204;
   private static Method methodObject27404;
   private static Method methodObject27500;
   private static Method methodObject27189;
   private static Method methodObject27472;
   private static Method methodObject27297;
   private static Method methodObject27136;
   private static Method methodObject27484;
   private static Method methodObject27250;
   private static Method methodObject27237;
   private static Method methodObject27456;
   private static Method methodObject27464;
   private static Method methodObject27423;
   private static Method methodObject27131;
   private static Method methodObject27125;
   private static Method methodObject27491;
   private static Method methodObject27206;
   private static Method methodObject27285;
   private static Method methodObject27315;
   private static Method methodObject27169;
   private static Method methodObject27419;
   private static Method methodObject27374;
   private static Method methodObject27398;
   private static Method methodObject27278;
   private static Method methodObject27383;
   private static Method methodObject27160;
   private static Method methodObject27482;
   private static Method methodObject27463;
   private static Method methodObject27447;
   private static Method methodObject27544;
   private static Method methodObject27542;
   private static Method methodObject27327;
   private static Method methodObject27481;
   private static Method methodObject27418;
   private static Method methodObject27230;
   private static Method methodObject27554;
   private static Method methodObject27355;
   private static Method methodObject27549;
   private static Method methodObject27428;
   private static Method methodObject27362;
   private static Method methodObject27187;
   private static Method methodObject27526;
   private static Method methodObject27455;
   private static Method methodObject27467;
   private static Method methodObject27156;
   private static Method methodObject27525;
   private static Method methodObject27157;
   private static Method methodObject27538;
   private static Method methodObject27458;
   private static Method methodObject27202;
   private static Method methodObject27497;
   private static Method methodObject27553;
   private static Method methodObject27359;
   private static Method methodObject27465;
   private static Method methodObject27143;
   private static Method methodObject27219;
   private static Method methodObject27380;
   private static Method methodObject27223;
   private static Method methodObject27291;
   private static Method methodObject27435;
   private static Method methodObject27410;
   private static Method methodObject27198;
   private static Method methodObject27336;
   private static Method methodObject27227;
   private static Method methodObject27121;
   private static Method methodObject27367;
   private static Method methodObject27145;
   private static Method methodObject27147;
   private static Method methodObject27504;
   private static Method methodObject27543;
   private static Method methodObject27358;
   private static Method methodObject27487;
   private static Method methodObject27260;
   private static Method methodObject27140;
   private static Method methodObject27218;
   private static Method methodObject27345;
   private static Method methodObject27329;
   private static Method methodObject27251;
   private static Method methodObject27161;
   private static Method methodObject27241;
   private static Method methodObject27434;
   private static Method methodObject27499;
   private static Method methodObject27284;
   private static Method methodObject27371;
   private static Method methodObject27510;
   private static Method methodObject27110;
   private static Method methodObject27162;
   private static Method methodObject27158;
   private static Method methodObject27205;
   private static Method methodObject27370;
   private static Method methodObject27453;
   private static Method methodObject27192;
   private static Method methodObject27300;
   private static Method methodObject27232;
   private static Method methodObject27391;
   private static Method methodObject27478;
   private static Method methodObject27167;
   private static Method methodObject27213;
   private static Method methodObject27522;
   private static Method methodObject27356;
   private static Method methodObject27153;
   private static Method methodObject27461;
   private static Method methodObject27425;
   private static Method methodObject27165;
   private static Method methodObject27194;
   private static Method methodObject27309;
   private static Method methodObject27317;
   private static Method methodObject27263;
   private static Method methodObject27130;
   private static Method methodObject27118;
   private static Method methodObject27135;
   private static Method methodObject27448;
   private static Method methodObject27239;
   private static Method methodObject27307;
   private static Method methodObject27182;
   private static Method methodObject27536;
   private static Method methodObject27347;
   private static Method methodObject27282;
   private static Method methodObject27312;
   private static Method methodObject27323;
   private static Method methodObject27528;
   private static Method methodObject27306;
   private static Method methodObject27335;
   private static Method methodObject27264;
   private static Method methodObject27468;
   private static Method methodObject27540;
   private static Method methodObject27505;
   private static Method methodObject27115;
   private static Method methodObject27396;
   private static Method methodObject27185;
   private static Method methodObject27441;
   private static Method methodObject27277;
   private static Method methodObject27319;
   private static Method methodObject27492;
   private static Method methodObject27116;
   private static Method methodObject27184;
   private static Method methodObject27129;
   private static Method methodObject27403;
   private static Method methodObject27562;
   private static Method methodObject27470;
   private static Method methodObject27532;
   private static Method methodObject27415;
   private static Method methodObject27268;
   private static Method methodObject27331;
   private static Method methodObject27437;
   private static Method methodObject27495;
   private static Method methodObject27508;
   private static Method methodObject27314;
   private static Method methodObject27409;
   private static Method methodObject27378;
   private static Method methodObject27117;
   private static Method methodObject27305;

   public boolean execute(String arg0) throws SQLException {
      try {
         super.preForExecute(methodObject27357, this, arg0);
         return this.postForExecute(methodObject27357, this.delegate.execute(arg0));
      } catch (SQLException var3) {
         return this.postForExecute(methodObject27357, this.onErrorForExecute(methodObject27357, var3));
      }
   }

   public OPAQUE getOPAQUE(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject27164, this, arg0);
         return (OPAQUE)this.postForAll(methodObject27164, (Object)this.delegate.getOPAQUE(arg0));
      } catch (SQLException var3) {
         return (OPAQUE)this.postForAll(methodObject27164, this.onErrorForAll(methodObject27164, var3));
      }
   }

   public BigDecimal getBigDecimal(String arg0, int arg1) throws SQLException {
      try {
         super.preForAll(methodObject27111, this, arg0, arg1);
         return (BigDecimal)this.postForAll(methodObject27111, (Object)this.delegate.getBigDecimal(arg0, arg1));
      } catch (SQLException var4) {
         return (BigDecimal)this.postForAll(methodObject27111, this.onErrorForAll(methodObject27111, var4));
      }
   }

   public void setNull(String arg0, int arg1, String arg2) throws SQLException {
      try {
         super.preForAll(methodObject27146, this, arg0, arg1, arg2);
         this.delegate.setNull(arg0, arg1, arg2);
      } catch (SQLException var5) {
         this.onErrorVoidForAll(methodObject27146, var5);
      }
   }

   public double getDouble(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject27235, this, arg0);
         return (Double)this.postForAll(methodObject27235, this.delegate.getDouble(arg0));
      } catch (SQLException var3) {
         return (Double)this.postForAll(methodObject27235, this.onErrorForAll(methodObject27235, var3));
      }
   }

   public TIMESTAMPTZ getTIMESTAMPTZ(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject27172, this, arg0);
         return (TIMESTAMPTZ)this.postForAll(methodObject27172, (Object)this.delegate.getTIMESTAMPTZ(arg0));
      } catch (SQLException var3) {
         return (TIMESTAMPTZ)this.postForAll(methodObject27172, this.onErrorForAll(methodObject27172, var3));
      }
   }

   public void enterImplicitCache() throws SQLException {
      try {
         super.preForAll(methodObject27541, this, zeroLengthObjectArray);
         this.delegate.enterImplicitCache();
      } catch (SQLException var2) {
         this.onErrorVoidForAll(methodObject27541, var2);
      }
   }

   public int executeUpdate(String arg0, int[] arg1) throws SQLException {
      try {
         super.preForExecuteUpdate(methodObject27366, this, arg0, arg1);
         return this.postForExecuteUpdate(methodObject27366, this.delegate.executeUpdate(arg0, arg1));
      } catch (SQLException var4) {
         return this.postForExecuteUpdate(methodObject27366, (Integer)this.onErrorForAll(methodObject27366, var4));
      }
   }

   public void setDouble(int arg0, double arg1) throws SQLException {
      try {
         super.preForAll(methodObject27303, this, arg0, arg1);
         this.delegate.setDouble(arg0, arg1);
      } catch (SQLException var5) {
         this.onErrorVoidForAll(methodObject27303, var5);
      }
   }

   public void setRowId(String arg0, RowId arg1) throws SQLException {
      try {
         super.preForAll(methodObject27288, this, arg0, arg1);
         this.delegate.setRowId(arg0, arg1 instanceof _Proxy_ ? (RowId)((_Proxy_)arg1)._getDelegate_() : arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject27288, var4);
      }
   }

   public void setNull(int arg0, int arg1) throws SQLException {
      try {
         super.preForAll(methodObject27350, this, arg0, arg1);
         this.delegate.setNull(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject27350, var4);
      }
   }

   public long getLong(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject27231, this, arg0);
         return (Long)this.postForAll(methodObject27231, this.delegate.getLong(arg0));
      } catch (SQLException var3) {
         return (Long)this.postForAll(methodObject27231, this.onErrorForAll(methodObject27231, var3));
      }
   }

   public int executeUpdate(String arg0) throws SQLException {
      try {
         super.preForExecuteUpdate(methodObject27364, this, arg0);
         return this.postForExecuteUpdate(methodObject27364, this.delegate.executeUpdate(arg0));
      } catch (SQLException var3) {
         return this.postForExecuteUpdate(methodObject27364, (Integer)this.onErrorForAll(methodObject27364, var3));
      }
   }

   public void setROWIDAtName(String arg0, ROWID arg1) throws SQLException {
      try {
         super.preForAll(methodObject27436, this, arg0, arg1);
         this.delegate.setROWIDAtName(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject27436, var4);
      }
   }

   public void setNString(int arg0, String arg1) throws SQLException {
      try {
         super.preForAll(methodObject27349, this, arg0, arg1);
         this.delegate.setNString(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject27349, var4);
      }
   }

   public Date getDate(String arg0) throws SQLException {
      try {
         super.preForAll(methodObject27249, this, arg0);
         return (Date)this.postForAll(methodObject27249, (Object)this.delegate.getDate(arg0));
      } catch (SQLException var3) {
         return (Date)this.postForAll(methodObject27249, this.onErrorForAll(methodObject27249, var3));
      }
   }

   public void setObjectAtName(String arg0, Object arg1, int arg2, int arg3) throws SQLException {
      try {
         super.preForSetObjects(methodObject27411, this, arg0, arg1, arg2, arg3);
         this.delegate.setObjectAtName(arg0, arg1 instanceof _Proxy_ ? (Object)((_Proxy_)arg1)._getDelegate_() : arg1, arg2, arg3);
      } catch (SQLException var6) {
         this.onErrorVoidForAll(methodObject27411, var6);
      }
   }

   public void setTime(int arg0, Time arg1, Calendar arg2) throws SQLException {
      try {
         super.preForAll(methodObject27333, this, arg0, arg1, arg2);
         this.delegate.setTime(arg0, arg1, arg2);
      } catch (SQLException var5) {
         this.onErrorVoidForAll(methodObject27333, var5);
      }
   }

   public void setDoubleAtName(String arg0, double arg1) throws SQLException {
      try {
         super.preForAll(methodObject27426, this, arg0, arg1);
         this.delegate.setDoubleAtName(arg0, arg1);
      } catch (SQLException var5) {
         this.onErrorVoidForAll(methodObject27426, var5);
      }
   }

   public boolean isCloseOnCompletion() throws SQLException {
      try {
         super.preForAll(methodObject27386, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject27386, this.delegate.isCloseOnCompletion());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject27386, this.onErrorForAll(methodObject27386, var2));
      }
   }

   public void setNStringAtName(String arg0, String arg1) throws SQLException {
      try {
         super.preForAll(methodObject27488, this, arg0, arg1);
         this.delegate.setNStringAtName(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject27488, var4);
      }
   }

   public void setARRAY(int arg0, ARRAY arg1) throws SQLException {
      try {
         super.preForAll(methodObject27513, this, arg0, arg1);
         this.delegate.setARRAY(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject27513, var4);
      }
   }

   public void setTIMESTAMPAtName(String arg0, TIMESTAMP arg1) throws SQLException {
      try {
         super.preForAll(methodObject27466, this, arg0, arg1);
         this.delegate.setTIMESTAMPAtName(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject27466, var4);
      }
   }

   public boolean wasNull() throws SQLException {
      try {
         super.preForAll(methodObject27273, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject27273, this.delegate.wasNull());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject27273, this.onErrorForAll(methodObject27273, var2));
      }
   }

   public int getResultSetType() throws SQLException {
      try {
         super.preForAll(methodObject27384, this, zeroLengthObjectArray);
         return (Integer)this.postForAll(methodObject27384, this.delegate.getResultSetType());
      } catch (SQLException var2) {
         return (Integer)this.postForAll(methodObject27384, this.onErrorForAll(methodObject27384, var2));
      }
   }

   public void setCLOBAtName(String arg0, CLOB arg1) throws SQLException {
      try {
         super.preForAll(methodObject27450, this, arg0, arg1);
         this.delegate.setCLOBAtName(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject27450, var4);
      }
   }

   public void registerBindChecksumListener(OracleStatement.BindChecksumListener arg0) throws SQLException {
      try {
         super.preForAll(methodObject27560, this, arg0);
         this.delegate.registerBindChecksumListener(arg0);
      } catch (SQLException var3) {
         this.onErrorVoidForAll(methodObject27560, var3);
      }
   }

   public Ref getRef(String arg0) throws SQLException {
      try {
         super.preForAll(methodObject27244, this, arg0);
         return (Ref)this.postForAll(methodObject27244, this.proxyFactory.proxyForCreate((Object)this.delegate.getRef(arg0), this, this.proxyCache, methodObject27244));
      } catch (SQLException var3) {
         return (Ref)this.postForAll(methodObject27244, this.onErrorForAll(methodObject27244, var3));
      }
   }

   public int getResultSetHoldability() throws SQLException {
      try {
         super.preForAll(methodObject27373, this, zeroLengthObjectArray);
         return (Integer)this.postForAll(methodObject27373, this.delegate.getResultSetHoldability());
      } catch (SQLException var2) {
         return (Integer)this.postForAll(methodObject27373, this.onErrorForAll(methodObject27373, var2));
      }
   }

   public void defineParameterTypeBytes(int arg0, int arg1, int arg2) throws SQLException {
      try {
         super.preForAll(methodObject27414, this, arg0, arg1, arg2);
         this.delegate.defineParameterTypeBytes(arg0, arg1, arg2);
      } catch (SQLException var5) {
         this.onErrorVoidForAll(methodObject27414, var5);
      }
   }

   public void registerOutParameter(int arg0, int arg1, int arg2, int arg3) throws SQLException {
      try {
         super.preForAll(methodObject27141, this, arg0, arg1, arg2, arg3);
         this.delegate.registerOutParameter(arg0, arg1, arg2, arg3);
      } catch (SQLException var6) {
         this.onErrorVoidForAll(methodObject27141, var6);
      }
   }

   public void setBlob(String arg0, InputStream arg1, long arg2) throws SQLException {
      try {
         super.preForAll(methodObject27280, this, arg0, arg1, arg2);
         this.delegate.setBlob(arg0, arg1, arg2);
      } catch (SQLException var6) {
         this.onErrorVoidForAll(methodObject27280, var6);
      }
   }

   public void setDATEAtName(String arg0, DATE arg1) throws SQLException {
      try {
         super.preForAll(methodObject27444, this, arg0, arg1);
         this.delegate.setDATEAtName(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject27444, var4);
      }
   }

   public void clearWarnings() throws SQLException {
      try {
         super.preForAll(methodObject27372, this, zeroLengthObjectArray);
         this.delegate.clearWarnings();
      } catch (SQLException var2) {
         this.onErrorVoidForAll(methodObject27372, var2);
      }
   }

   public void setBytesForBlob(String arg0, byte[] arg1) throws SQLException {
      try {
         super.preForAll(methodObject27186, this, arg0, arg1);
         this.delegate.setBytesForBlob(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject27186, var4);
      }
   }

   public void setCHAR(int arg0, CHAR arg1) throws SQLException {
      try {
         super.preForAll(methodObject27501, this, arg0, arg1);
         this.delegate.setCHAR(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject27501, var4);
      }
   }

   public Object getCustomDatum(int arg0, CustomDatumFactory arg1) throws SQLException {
      try {
         super.preForAll(methodObject27159, this, arg0, arg1);
         return this.postForAll(methodObject27159, this.proxyFactory.proxyForCache(this.delegate.getCustomDatum(arg0, arg1), this, this.proxyCache, methodObject27159));
      } catch (SQLException var4) {
         return this.postForAll(methodObject27159, this.onErrorForAll(methodObject27159, var4));
      }
   }

   public void setBfile(int arg0, BFILE arg1) throws SQLException {
      try {
         super.preForAll(methodObject27507, this, arg0, arg1);
         this.delegate.setBfile(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject27507, var4);
      }
   }

   public void defineParameterType(int arg0, int arg1, int arg2) throws SQLException {
      try {
         super.preForAll(methodObject27416, this, arg0, arg1, arg2);
         this.delegate.defineParameterType(arg0, arg1, arg2);
      } catch (SQLException var5) {
         this.onErrorVoidForAll(methodObject27416, var5);
      }
   }

   public Object getObject(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject27217, this, arg0);
         return this.postForAll(methodObject27217, this.proxyFactory.proxyForCache(this.delegate.getObject(arg0), this, this.proxyCache, methodObject27217));
      } catch (SQLException var3) {
         return this.postForAll(methodObject27217, this.onErrorForAll(methodObject27217, var3));
      }
   }

   public void setCustomDatum(int arg0, CustomDatum arg1) throws SQLException {
      try {
         super.preForAll(methodObject27517, this, arg0, arg1);
         this.delegate.setCustomDatum(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject27517, var4);
      }
   }

   public ResultSetMetaData getMetaData() throws SQLException {
      try {
         super.preForAll(methodObject27330, this, zeroLengthObjectArray);
         return (ResultSetMetaData)this.postForAll(methodObject27330, this.proxyFactory.proxyForCreate((Object)this.delegate.getMetaData(), this, this.proxyCache, methodObject27330));
      } catch (SQLException var2) {
         return (ResultSetMetaData)this.postForAll(methodObject27330, this.onErrorForAll(methodObject27330, var2));
      }
   }

   public void setPoolable(boolean arg0) throws SQLException {
      try {
         super.preForAll(methodObject27392, this, arg0);
         this.delegate.setPoolable(arg0);
      } catch (SQLException var3) {
         this.onErrorVoidForAll(methodObject27392, var3);
      }
   }

   public void setNUMBER(String arg0, NUMBER arg1) throws SQLException {
      try {
         super.preForAll(methodObject27193, this, arg0, arg1);
         this.delegate.setNUMBER(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject27193, var4);
      }
   }

   public void setBLOBAtName(String arg0, BLOB arg1) throws SQLException {
      try {
         super.preForAll(methodObject27446, this, arg0, arg1);
         this.delegate.setBLOBAtName(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject27446, var4);
      }
   }

   public SQLXML getSQLXML(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject27267, this, arg0);
         return (SQLXML)this.postForAll(methodObject27267, this.proxyFactory.proxyForCreate((Object)this.delegate.getSQLXML(arg0), this, this.proxyCache, methodObject27267));
      } catch (SQLException var3) {
         return (SQLXML)this.postForAll(methodObject27267, this.onErrorForAll(methodObject27267, var3));
      }
   }

   public void setBinaryStream(String arg0, InputStream arg1) throws SQLException {
      try {
         super.preForSetStreams(methodObject27254, this, arg0, arg1);
         this.delegate.setBinaryStream(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject27254, var4);
      }
   }

   public void setNString(String arg0, String arg1) throws SQLException {
      try {
         super.preForAll(methodObject27287, this, arg0, arg1);
         this.delegate.setNString(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject27287, var4);
      }
   }

   public short getShort(String arg0) throws SQLException {
      try {
         super.preForAll(methodObject27228, this, arg0);
         return (Short)this.postForAll(methodObject27228, this.delegate.getShort(arg0));
      } catch (SQLException var3) {
         return (Short)this.postForAll(methodObject27228, this.onErrorForAll(methodObject27228, var3));
      }
   }

   public void defineColumnType(int arg0, int arg1, String arg2) throws SQLException {
      try {
         super.preForAll(methodObject27527, this, arg0, arg1, arg2);
         this.delegate.defineColumnType(arg0, arg1, arg2);
      } catch (SQLException var5) {
         this.onErrorVoidForAll(methodObject27527, var5);
      }
   }

   public Blob getBlob(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject27259, this, arg0);
         return (Blob)this.postForAll(methodObject27259, this.proxyFactory.proxyForCreate((Object)this.delegate.getBlob(arg0), this, this.proxyCache, methodObject27259));
      } catch (SQLException var3) {
         return (Blob)this.postForAll(methodObject27259, this.onErrorForAll(methodObject27259, var3));
      }
   }

   public ResultSet getGeneratedKeys() throws SQLException {
      try {
         super.preForAll(methodObject27377, this, zeroLengthObjectArray);
         return (ResultSet)this.postForAll(methodObject27377, this.proxyFactory.proxyForCache((Object)this.delegate.getGeneratedKeys(), this, this.proxyCache, methodObject27377));
      } catch (SQLException var2) {
         return (ResultSet)this.postForAll(methodObject27377, this.onErrorForAll(methodObject27377, var2));
      }
   }

   public void setURL(String arg0, URL arg1) throws SQLException {
      try {
         super.preForAll(methodObject27123, this, arg0, arg1);
         this.delegate.setURL(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject27123, var4);
      }
   }

   public Object getObject(String arg0, Class arg1) throws SQLException {
      try {
         super.preForAll(methodObject27222, this, arg0, arg1);
         return this.postForAll(methodObject27222, this.proxyFactory.proxyForCache(this.delegate.getObject(arg0, arg1), this, this.proxyCache, methodObject27222));
      } catch (SQLException var4) {
         return this.postForAll(methodObject27222, this.onErrorForAll(methodObject27222, var4));
      }
   }

   public boolean execute(String arg0, String[] arg1) throws SQLException {
      try {
         super.preForExecute(methodObject27360, this, arg0, arg1);
         return this.postForExecute(methodObject27360, this.delegate.execute(arg0, arg1));
      } catch (SQLException var4) {
         return this.postForExecute(methodObject27360, this.onErrorForExecute(methodObject27360, var4));
      }
   }

   public void setAsciiStreamAtName(String arg0, InputStream arg1, int arg2) throws SQLException {
      try {
         super.preForSetStreams(methodObject27400, this, arg0, arg1, arg2);
         this.delegate.setAsciiStreamAtName(arg0, arg1, arg2);
      } catch (SQLException var5) {
         this.onErrorVoidForAll(methodObject27400, var5);
      }
   }

   public String getNString(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject27295, this, arg0);
         return (String)this.postForAll(methodObject27295, (Object)this.delegate.getNString(arg0));
      } catch (SQLException var3) {
         return (String)this.postForAll(methodObject27295, this.onErrorForAll(methodObject27295, var3));
      }
   }

   public void registerOutParameter(int arg0, int arg1, int arg2) throws SQLException {
      try {
         super.preForAll(methodObject27275, this, arg0, arg1, arg2);
         this.delegate.registerOutParameter(arg0, arg1, arg2);
      } catch (SQLException var5) {
         this.onErrorVoidForAll(methodObject27275, var5);
      }
   }

   public int getFetchDirection() throws SQLException {
      try {
         super.preForAll(methodObject27394, this, zeroLengthObjectArray);
         return (Integer)this.postForAll(methodObject27394, this.delegate.getFetchDirection());
      } catch (SQLException var2) {
         return (Integer)this.postForAll(methodObject27394, this.onErrorForAll(methodObject27394, var2));
      }
   }

   public void setDATE(int arg0, DATE arg1) throws SQLException {
      try {
         super.preForAll(methodObject27502, this, arg0, arg1);
         this.delegate.setDATE(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject27502, var4);
      }
   }

   public void setBlob(int arg0, Blob arg1) throws SQLException {
      try {
         super.preForAll(methodObject27340, this, arg0, arg1);
         this.delegate.setBlob(arg0, arg1 instanceof _Proxy_ ? (Blob)((_Proxy_)arg1)._getDelegate_() : arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject27340, var4);
      }
   }

   public void setBlob(int arg0, InputStream arg1, long arg2) throws SQLException {
      try {
         super.preForAll(methodObject27341, this, arg0, arg1, arg2);
         this.delegate.setBlob(arg0, arg1, arg2);
      } catch (SQLException var6) {
         this.onErrorVoidForAll(methodObject27341, var6);
      }
   }

   public boolean getFixedString() {
      super.preForAll(methodObject27555, this, zeroLengthObjectArray);
      return (Boolean)this.postForAll(methodObject27555, this.delegate.getFixedString());
   }

   public void setCharacterStream(int arg0, Reader arg1, long arg2) throws SQLException {
      try {
         super.preForSetStreams(methodObject27320, this, arg0, arg1, arg2);
         this.delegate.setCharacterStream(arg0, arg1, arg2);
      } catch (SQLException var6) {
         this.onErrorVoidForAll(methodObject27320, var6);
      }
   }

   public long getChecksum() throws SQLException {
      try {
         super.preForAll(methodObject27552, this, zeroLengthObjectArray);
         return (Long)this.postForAll(methodObject27552, this.delegate.getChecksum());
      } catch (SQLException var2) {
         return (Long)this.postForAll(methodObject27552, this.onErrorForAll(methodObject27552, var2));
      }
   }

   public void setCursor(String arg0, ResultSet arg1) throws SQLException {
      try {
         super.preForAll(methodObject27188, this, arg0, arg1);
         this.delegate.setCursor(arg0, arg1 instanceof _Proxy_ ? (ResultSet)((_Proxy_)arg1)._getDelegate_() : arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject27188, var4);
      }
   }

   public void setPlsqlIndexTable(int arg0, Object arg1, int arg2, int arg3, int arg4, int arg5) throws SQLException {
      try {
         super.preForAll(methodObject27477, this, arg0, arg1, arg2, arg3, arg4, arg5);
         this.delegate.setPlsqlIndexTable(arg0, arg1 instanceof _Proxy_ ? (Object)((_Proxy_)arg1)._getDelegate_() : arg1, arg2, arg3, arg4, arg5);
      } catch (SQLException var8) {
         this.onErrorVoidForAll(methodObject27477, var8);
      }
   }

   public void registerOutParameterAtName(String arg0, int arg1) throws SQLException {
      try {
         super.preForAll(methodObject27212, this, arg0, arg1);
         this.delegate.registerOutParameterAtName(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject27212, var4);
      }
   }

   public void setUnicodeStream(String arg0, InputStream arg1, int arg2) throws SQLException {
      try {
         super.preForAll(methodObject27127, this, arg0, arg1, arg2);
         this.delegate.setUnicodeStream(arg0, arg1, arg2);
      } catch (SQLException var5) {
         this.onErrorVoidForAll(methodObject27127, var5);
      }
   }

   public void setBinaryDouble(int arg0, double arg1) throws SQLException {
      try {
         super.preForAll(methodObject27493, this, arg0, arg1);
         this.delegate.setBinaryDouble(arg0, arg1);
      } catch (SQLException var5) {
         this.onErrorVoidForAll(methodObject27493, var5);
      }
   }

   public void setSTRUCT(int arg0, STRUCT arg1) throws SQLException {
      try {
         super.preForAll(methodObject27516, this, arg0, arg1);
         this.delegate.setSTRUCT(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject27516, var4);
      }
   }

   public boolean getBoolean(String arg0) throws SQLException {
      try {
         super.preForAll(methodObject27224, this, arg0);
         return (Boolean)this.postForAll(methodObject27224, this.delegate.getBoolean(arg0));
      } catch (SQLException var3) {
         return (Boolean)this.postForAll(methodObject27224, this.onErrorForAll(methodObject27224, var3));
      }
   }

   public void setTimestamp(String arg0, Timestamp arg1, Calendar arg2) throws SQLException {
      try {
         super.preForAll(methodObject27122, this, arg0, arg1, arg2);
         this.delegate.setTimestamp(arg0, arg1, arg2);
      } catch (SQLException var5) {
         this.onErrorVoidForAll(methodObject27122, var5);
      }
   }

   public void setOracleObject(int arg0, Datum arg1) throws SQLException {
      try {
         super.preForAll(methodObject27521, this, arg0, arg1);
         this.delegate.setOracleObject(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject27521, var4);
      }
   }

   public void setBinaryFloat(String arg0, BINARY_FLOAT arg1) throws SQLException {
      try {
         super.preForAll(methodObject27181, this, arg0, arg1);
         this.delegate.setBinaryFloat(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject27181, var4);
      }
   }

   public void setBlob(int arg0, InputStream arg1) throws SQLException {
      try {
         super.preForAll(methodObject27342, this, arg0, arg1);
         this.delegate.setBlob(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject27342, var4);
      }
   }

   public void clearDefines() throws SQLException {
      try {
         super.preForAll(methodObject27523, this, zeroLengthObjectArray);
         this.delegate.clearDefines();
      } catch (SQLException var2) {
         this.onErrorVoidForAll(methodObject27523, var2);
      }
   }

   public void setBytesForBlob(int arg0, byte[] arg1) throws SQLException {
      try {
         super.preForAll(methodObject27496, this, arg0, arg1);
         this.delegate.setBytesForBlob(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject27496, var4);
      }
   }

   public void setRAWAtName(String arg0, RAW arg1) throws SQLException {
      try {
         super.preForAll(methodObject27442, this, arg0, arg1);
         this.delegate.setRAWAtName(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject27442, var4);
      }
   }

   public void setARRAY(String arg0, ARRAY arg1) throws SQLException {
      try {
         super.preForAll(methodObject27203, this, arg0, arg1);
         this.delegate.setARRAY(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject27203, var4);
      }
   }

   public void setREF(int arg0, REF arg1) throws SQLException {
      try {
         super.preForAll(methodObject27520, this, arg0, arg1);
         this.delegate.setREF(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject27520, var4);
      }
   }

   public void setCursor(int arg0, ResultSet arg1) throws SQLException {
      try {
         super.preForAll(methodObject27498, this, arg0, arg1);
         this.delegate.setCursor(arg0, arg1 instanceof _Proxy_ ? (ResultSet)((_Proxy_)arg1)._getDelegate_() : arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject27498, var4);
      }
   }

   public void setStructDescriptorAtName(String arg0, StructDescriptor arg1) throws SQLException {
      try {
         super.preForAll(methodObject27440, this, arg0, arg1);
         this.delegate.setStructDescriptorAtName(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject27440, var4);
      }
   }

   public BFILE getBFILE(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject27154, this, arg0);
         return (BFILE)this.postForAll(methodObject27154, (Object)this.delegate.getBFILE(arg0));
      } catch (SQLException var3) {
         return (BFILE)this.postForAll(methodObject27154, this.onErrorForAll(methodObject27154, var3));
      }
   }

   public String getNString(String arg0) throws SQLException {
      try {
         super.preForAll(methodObject27296, this, arg0);
         return (String)this.postForAll(methodObject27296, (Object)this.delegate.getNString(arg0));
      } catch (SQLException var3) {
         return (String)this.postForAll(methodObject27296, this.onErrorForAll(methodObject27296, var3));
      }
   }

   public InputStream getUnicodeStream(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject27150, this, arg0);
         return (InputStream)this.postForAll(methodObject27150, (Object)this.delegate.getUnicodeStream(arg0));
      } catch (SQLException var3) {
         return (InputStream)this.postForAll(methodObject27150, this.onErrorForAll(methodObject27150, var3));
      }
   }

   public void setObject(int arg0, Object arg1, int arg2) throws SQLException {
      try {
         super.preForSetObjects(methodObject27326, this, arg0, arg1, arg2);
         this.delegate.setObject(arg0, arg1 instanceof _Proxy_ ? (Object)((_Proxy_)arg1)._getDelegate_() : arg1, arg2);
      } catch (SQLException var5) {
         this.onErrorVoidForAll(methodObject27326, var5);
      }
   }

   public void setOPAQUE(int arg0, OPAQUE arg1) throws SQLException {
      try {
         super.preForAll(methodObject27514, this, arg0, arg1);
         this.delegate.setOPAQUE(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject27514, var4);
      }
   }

   public void setTimeAtName(String arg0, Time arg1) throws SQLException {
      try {
         super.preForAll(methodObject27460, this, arg0, arg1);
         this.delegate.setTimeAtName(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject27460, var4);
      }
   }

   public void setBoolean(String arg0, boolean arg1) throws SQLException {
      try {
         super.preForAll(methodObject27114, this, arg0, arg1);
         this.delegate.setBoolean(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject27114, var4);
      }
   }

   public void registerOutParameter(String arg0, int arg1, int arg2, int arg3) throws SQLException {
      try {
         super.preForAll(methodObject27142, this, arg0, arg1, arg2, arg3);
         this.delegate.registerOutParameter(arg0, arg1, arg2, arg3);
      } catch (SQLException var6) {
         this.onErrorVoidForAll(methodObject27142, var6);
      }
   }

   public NUMBER getNUMBER(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject27163, this, arg0);
         return (NUMBER)this.postForAll(methodObject27163, (Object)this.delegate.getNUMBER(arg0));
      } catch (SQLException var3) {
         return (NUMBER)this.postForAll(methodObject27163, this.onErrorForAll(methodObject27163, var3));
      }
   }

   public void setBFILEAtName(String arg0, BFILE arg1) throws SQLException {
      try {
         super.preForAll(methodObject27454, this, arg0, arg1);
         this.delegate.setBFILEAtName(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject27454, var4);
      }
   }

   public void cancel() throws SQLException {
      try {
         super.preForAll(methodObject27361, this, zeroLengthObjectArray);
         this.delegate.cancel();
      } catch (SQLException var2) {
         this.onErrorVoidForAll(methodObject27361, var2);
      }
   }

   public void setCHAR(String arg0, CHAR arg1) throws SQLException {
      try {
         super.preForAll(methodObject27191, this, arg0, arg1);
         this.delegate.setCHAR(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject27191, var4);
      }
   }

   public void setCharacterStream(String arg0, Reader arg1) throws SQLException {
      try {
         super.preForSetStreams(methodObject27256, this, arg0, arg1);
         this.delegate.setCharacterStream(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject27256, var4);
      }
   }

   public void setQueryTimeout(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject27393, this, arg0);
         this.delegate.setQueryTimeout(arg0);
      } catch (SQLException var3) {
         this.onErrorVoidForAll(methodObject27393, var3);
      }
   }

   public void setLobPrefetchSize(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject27533, this, arg0);
         this.delegate.setLobPrefetchSize(arg0);
      } catch (SQLException var3) {
         this.onErrorVoidForAll(methodObject27533, var3);
      }
   }

   public void closeWithKey(String arg0) throws SQLException {
      try {
         super.preForAll(methodObject27534, this, arg0);
         this.delegate.closeWithKey(arg0);
      } catch (SQLException var3) {
         this.onErrorVoidForAll(methodObject27534, var3);
      }
   }

   public InputStream getBinaryStream(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject27128, this, arg0);
         return (InputStream)this.postForAll(methodObject27128, (Object)this.delegate.getBinaryStream(arg0));
      } catch (SQLException var3) {
         return (InputStream)this.postForAll(methodObject27128, this.onErrorForAll(methodObject27128, var3));
      }
   }

   public void setCharacterStreamAtName(String arg0, Reader arg1, int arg2) throws SQLException {
      try {
         super.preForSetStreams(methodObject27539, this, arg0, arg1, arg2);
         this.delegate.setCharacterStreamAtName(arg0, arg1, arg2);
      } catch (SQLException var5) {
         this.onErrorVoidForAll(methodObject27539, var5);
      }
   }

   public Datum getOracleObject(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject27152, this, arg0);
         return (Datum)this.postForAll(methodObject27152, (Object)this.delegate.getOracleObject(arg0));
      } catch (SQLException var3) {
         return (Datum)this.postForAll(methodObject27152, this.onErrorForAll(methodObject27152, var3));
      }
   }

   public void setObject(String arg0, Object arg1, int arg2) throws SQLException {
      try {
         super.preForSetObjects(methodObject27132, this, arg0, arg1, arg2);
         this.delegate.setObject(arg0, arg1 instanceof _Proxy_ ? (Object)((_Proxy_)arg1)._getDelegate_() : arg1, arg2);
      } catch (SQLException var5) {
         this.onErrorVoidForAll(methodObject27132, var5);
      }
   }

   public void setRef(String arg0, Ref arg1) throws SQLException {
      try {
         super.preForAll(methodObject27149, this, arg0, arg1);
         this.delegate.setRef(arg0, arg1 instanceof _Proxy_ ? (Ref)((_Proxy_)arg1)._getDelegate_() : arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject27149, var4);
      }
   }

   public void setBlob(String arg0, InputStream arg1) throws SQLException {
      try {
         super.preForAll(methodObject27281, this, arg0, arg1);
         this.delegate.setBlob(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject27281, var4);
      }
   }

   public void setNCharacterStream(int arg0, Reader arg1, long arg2) throws SQLException {
      try {
         super.preForSetStreams(methodObject27322, this, arg0, arg1, arg2);
         this.delegate.setNCharacterStream(arg0, arg1, arg2);
      } catch (SQLException var6) {
         this.onErrorVoidForAll(methodObject27322, var6);
      }
   }

   public void setTIMESTAMPLTZ(int arg0, TIMESTAMPLTZ arg1) throws SQLException {
      try {
         super.preForAll(methodObject27512, this, arg0, arg1);
         this.delegate.setTIMESTAMPLTZ(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject27512, var4);
      }
   }

   public void setNClob(int arg0, NClob arg1) throws SQLException {
      try {
         super.preForAll(methodObject27346, this, arg0, arg1);
         this.delegate.setNClob(arg0, arg1 instanceof _Proxy_ ? (NClob)((_Proxy_)arg1)._getDelegate_() : arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject27346, var4);
      }
   }

   public void setORAData(String arg0, ORAData arg1) throws SQLException {
      try {
         super.preForAll(methodObject27208, this, arg0, arg1);
         this.delegate.setORAData(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject27208, var4);
      }
   }

   public void setSQLXML(String arg0, SQLXML arg1) throws SQLException {
      try {
         super.preForAll(methodObject27289, this, arg0, arg1);
         this.delegate.setSQLXML(arg0, arg1 instanceof _Proxy_ ? (SQLXML)((_Proxy_)arg1)._getDelegate_() : arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject27289, var4);
      }
   }

   public Time getTime(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject27269, this, arg0);
         return (Time)this.postForAll(methodObject27269, (Object)this.delegate.getTime(arg0));
      } catch (SQLException var3) {
         return (Time)this.postForAll(methodObject27269, this.onErrorForAll(methodObject27269, var3));
      }
   }

   public void setDate(int arg0, Date arg1) throws SQLException {
      try {
         super.preForAll(methodObject27334, this, arg0, arg1);
         this.delegate.setDate(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject27334, var4);
      }
   }

   public void setLong(String arg0, long arg1) throws SQLException {
      try {
         super.preForAll(methodObject27119, this, arg0, arg1);
         this.delegate.setLong(arg0, arg1);
      } catch (SQLException var5) {
         this.onErrorVoidForAll(methodObject27119, var5);
      }
   }

   public int executeUpdate(String arg0, int arg1) throws SQLException {
      try {
         super.preForExecuteUpdate(methodObject27365, this, arg0, arg1);
         return this.postForExecuteUpdate(methodObject27365, this.delegate.executeUpdate(arg0, arg1));
      } catch (SQLException var4) {
         return this.postForExecuteUpdate(methodObject27365, (Integer)this.onErrorForAll(methodObject27365, var4));
      }
   }

   public void setCharacterStream(String arg0, Reader arg1, int arg2) throws SQLException {
      try {
         super.preForSetStreams(methodObject27126, this, arg0, arg1, arg2);
         this.delegate.setCharacterStream(arg0, arg1, arg2);
      } catch (SQLException var5) {
         this.onErrorVoidForAll(methodObject27126, var5);
      }
   }

   public void registerOutParameterBytes(int arg0, int arg1, int arg2, int arg3) throws SQLException {
      try {
         super.preForAll(methodObject27174, this, arg0, arg1, arg2, arg3);
         this.delegate.registerOutParameterBytes(arg0, arg1, arg2, arg3);
      } catch (SQLException var6) {
         this.onErrorVoidForAll(methodObject27174, var6);
      }
   }

   public void setBinaryDouble(String arg0, BINARY_DOUBLE arg1) throws SQLException {
      try {
         super.preForAll(methodObject27183, this, arg0, arg1);
         this.delegate.setBinaryDouble(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject27183, var4);
      }
   }

   public void setByteAtName(String arg0, byte arg1) throws SQLException {
      try {
         super.preForAll(methodObject27421, this, arg0, arg1);
         this.delegate.setByteAtName(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject27421, var4);
      }
   }

   public void setDateAtName(String arg0, Date arg1, Calendar arg2) throws SQLException {
      try {
         super.preForAll(methodObject27459, this, arg0, arg1, arg2);
         this.delegate.setDateAtName(arg0, arg1, arg2);
      } catch (SQLException var5) {
         this.onErrorVoidForAll(methodObject27459, var5);
      }
   }

   public BigDecimal getBigDecimal(int arg0, int arg1) throws SQLException {
      try {
         super.preForAll(methodObject27290, this, arg0, arg1);
         return (BigDecimal)this.postForAll(methodObject27290, (Object)this.delegate.getBigDecimal(arg0, arg1));
      } catch (SQLException var4) {
         return (BigDecimal)this.postForAll(methodObject27290, this.onErrorForAll(methodObject27290, var4));
      }
   }

   public void setBytesForBlobAtName(String arg0, byte[] arg1) throws SQLException {
      try {
         super.preForAll(methodObject27457, this, arg0, arg1);
         this.delegate.setBytesForBlobAtName(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject27457, var4);
      }
   }

   public ResultSet executeQuery(String arg0) throws SQLException {
      try {
         super.preForAll(methodObject27369, this, arg0);
         return this.postForExecuteQuery(methodObject27369, (ResultSet)this.proxyFactory.proxyForCreateCache((Object)this.delegate.executeQuery(arg0), this, this.proxyCache, methodObject27369));
      } catch (SQLException var3) {
         return this.postForExecuteQuery(methodObject27369, (ResultSet)this.onErrorForAll(methodObject27369, var3));
      }
   }

   public void setFloat(int arg0, float arg1) throws SQLException {
      try {
         super.preForAll(methodObject27304, this, arg0, arg1);
         this.delegate.setFloat(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject27304, var4);
      }
   }

   public void setRowIdAtName(String arg0, RowId arg1) throws SQLException {
      try {
         super.preForAll(methodObject27489, this, arg0, arg1);
         this.delegate.setRowIdAtName(arg0, arg1 instanceof _Proxy_ ? (RowId)((_Proxy_)arg1)._getDelegate_() : arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject27489, var4);
      }
   }

   public void registerOutParameter(int arg0, int arg1) throws SQLException {
      try {
         super.preForAll(methodObject27274, this, arg0, arg1);
         this.delegate.registerOutParameter(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject27274, var4);
      }
   }

   public void setBFILE(int arg0, BFILE arg1) throws SQLException {
      try {
         super.preForAll(methodObject27506, this, arg0, arg1);
         this.delegate.setBFILE(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject27506, var4);
      }
   }

   public void setSQLXML(int arg0, SQLXML arg1) throws SQLException {
      try {
         super.preForAll(methodObject27353, this, arg0, arg1);
         this.delegate.setSQLXML(arg0, arg1 instanceof _Proxy_ ? (SQLXML)((_Proxy_)arg1)._getDelegate_() : arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject27353, var4);
      }
   }

   public void setRefTypeAtName(String arg0, REF arg1) throws SQLException {
      try {
         super.preForAll(methodObject27471, this, arg0, arg1);
         this.delegate.setRefTypeAtName(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject27471, var4);
      }
   }

   public void setStructDescriptor(int arg0, StructDescriptor arg1) throws SQLException {
      try {
         super.preForAll(methodObject27515, this, arg0, arg1);
         this.delegate.setStructDescriptor(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject27515, var4);
      }
   }

   public int getMaxRows() throws SQLException {
      try {
         super.preForAll(methodObject27379, this, zeroLengthObjectArray);
         return (Integer)this.postForAll(methodObject27379, this.delegate.getMaxRows());
      } catch (SQLException var2) {
         return (Integer)this.postForAll(methodObject27379, this.onErrorForAll(methodObject27379, var2));
      }
   }

   public void addBatch() throws SQLException {
      try {
         super.preForAll(methodObject27337, this, zeroLengthObjectArray);
         this.delegate.addBatch();
      } catch (SQLException var2) {
         this.onErrorVoidForAll(methodObject27337, var2);
      }
   }

   public Ref getRef(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject27243, this, arg0);
         return (Ref)this.postForAll(methodObject27243, this.proxyFactory.proxyForCreate((Object)this.delegate.getRef(arg0), this, this.proxyCache, methodObject27243));
      } catch (SQLException var3) {
         return (Ref)this.postForAll(methodObject27243, this.onErrorForAll(methodObject27243, var3));
      }
   }

   public Object getPlsqlIndexTable(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject27177, this, arg0);
         return this.postForAll(methodObject27177, this.proxyFactory.proxyForCache(this.delegate.getPlsqlIndexTable(arg0), this, this.proxyCache, methodObject27177));
      } catch (SQLException var3) {
         return this.postForAll(methodObject27177, this.onErrorForAll(methodObject27177, var3));
      }
   }

   public Date getDate(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject27247, this, arg0);
         return (Date)this.postForAll(methodObject27247, (Object)this.delegate.getDate(arg0));
      } catch (SQLException var3) {
         return (Date)this.postForAll(methodObject27247, this.onErrorForAll(methodObject27247, var3));
      }
   }

   public void setDisableStmtCaching(boolean arg0) {
      super.preForAll(methodObject27479, this, arg0);
      this.delegate.setDisableStmtCaching(arg0);
   }

   public int getQueryTimeout() throws SQLException {
      try {
         super.preForAll(methodObject27382, this, zeroLengthObjectArray);
         return (Integer)this.postForAll(methodObject27382, this.delegate.getQueryTimeout());
      } catch (SQLException var2) {
         return (Integer)this.postForAll(methodObject27382, this.onErrorForAll(methodObject27382, var2));
      }
   }

   public int getstatementType() {
      super.preForAll(methodObject27559, this, zeroLengthObjectArray);
      return (Integer)this.postForAll(methodObject27559, this.delegate.getstatementType());
   }

   public void setURL(int arg0, URL arg1) throws SQLException {
      try {
         super.preForAll(methodObject27310, this, arg0, arg1);
         this.delegate.setURL(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject27310, var4);
      }
   }

   public void setNClob(int arg0, Reader arg1) throws SQLException {
      try {
         super.preForAll(methodObject27348, this, arg0, arg1);
         this.delegate.setNClob(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject27348, var4);
      }
   }

   public void setStringForClobAtName(String arg0, String arg1) throws SQLException {
      try {
         super.preForAll(methodObject27433, this, arg0, arg1);
         this.delegate.setStringForClobAtName(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject27433, var4);
      }
   }

   public void setBigDecimal(int arg0, BigDecimal arg1) throws SQLException {
      try {
         super.preForAll(methodObject27339, this, arg0, arg1);
         this.delegate.setBigDecimal(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject27339, var4);
      }
   }

   public void setNull(int arg0, int arg1, String arg2) throws SQLException {
      try {
         super.preForAll(methodObject27351, this, arg0, arg1, arg2);
         this.delegate.setNull(arg0, arg1, arg2);
      } catch (SQLException var5) {
         this.onErrorVoidForAll(methodObject27351, var5);
      }
   }

   public Date getDate(int arg0, Calendar arg1) throws SQLException {
      try {
         super.preForAll(methodObject27248, this, arg0, arg1);
         return (Date)this.postForAll(methodObject27248, (Object)this.delegate.getDate(arg0, arg1));
      } catch (SQLException var4) {
         return (Date)this.postForAll(methodObject27248, this.onErrorForAll(methodObject27248, var4));
      }
   }

   public void setNClob(String arg0, Reader arg1) throws SQLException {
      try {
         super.preForAll(methodObject27286, this, arg0, arg1);
         this.delegate.setNClob(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject27286, var4);
      }
   }

   public REF getREF(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject27166, this, arg0);
         return (REF)this.postForAll(methodObject27166, (Object)this.delegate.getREF(arg0));
      } catch (SQLException var3) {
         return (REF)this.postForAll(methodObject27166, this.onErrorForAll(methodObject27166, var3));
      }
   }

   public void exitExplicitCacheToClose() throws SQLException {
      try {
         super.preForAll(methodObject27546, this, zeroLengthObjectArray);
         this.delegate.exitExplicitCacheToClose();
      } catch (SQLException var2) {
         this.onErrorVoidForAll(methodObject27546, var2);
      }
   }

   public void setBooleanAtName(String arg0, boolean arg1) throws SQLException {
      try {
         super.preForAll(methodObject27420, this, arg0, arg1);
         this.delegate.setBooleanAtName(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject27420, var4);
      }
   }

   public void setBfile(String arg0, BFILE arg1) throws SQLException {
      try {
         super.preForAll(methodObject27197, this, arg0, arg1);
         this.delegate.setBfile(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject27197, var4);
      }
   }

   public Array getArray(String arg0) throws SQLException {
      try {
         super.preForAll(methodObject27240, this, arg0);
         return (Array)this.postForAll(methodObject27240, this.proxyFactory.proxyForCreate((Object)this.delegate.getArray(arg0), this, this.proxyCache, methodObject27240));
      } catch (SQLException var3) {
         return (Array)this.postForAll(methodObject27240, this.onErrorForAll(methodObject27240, var3));
      }
   }

   public void registerReturnParameter(int arg0, int arg1, String arg2) throws SQLException {
      try {
         super.preForAll(methodObject27483, this, arg0, arg1, arg2);
         this.delegate.registerReturnParameter(arg0, arg1, arg2);
      } catch (SQLException var5) {
         this.onErrorVoidForAll(methodObject27483, var5);
      }
   }

   public void setDate(String arg0, Date arg1, Calendar arg2) throws SQLException {
      try {
         super.preForAll(methodObject27137, this, arg0, arg1, arg2);
         this.delegate.setDate(arg0, arg1, arg2);
      } catch (SQLException var5) {
         this.onErrorVoidForAll(methodObject27137, var5);
      }
   }

   public void setCheckBindTypes(boolean arg0) {
      super.preForAll(methodObject27548, this, arg0);
      this.delegate.setCheckBindTypes(arg0);
   }

   public byte getByte(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject27225, this, arg0);
         return (Byte)this.postForAll(methodObject27225, this.delegate.getByte(arg0));
      } catch (SQLException var3) {
         return (Byte)this.postForAll(methodObject27225, this.onErrorForAll(methodObject27225, var3));
      }
   }

   public ARRAY getARRAY(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject27216, this, arg0);
         return (ARRAY)this.postForAll(methodObject27216, (Object)this.delegate.getARRAY(arg0));
      } catch (SQLException var3) {
         return (ARRAY)this.postForAll(methodObject27216, this.onErrorForAll(methodObject27216, var3));
      }
   }

   public void setBFILE(String arg0, BFILE arg1) throws SQLException {
      try {
         super.preForAll(methodObject27196, this, arg0, arg1);
         this.delegate.setBFILE(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject27196, var4);
      }
   }

   public BFILE getBfile(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject27155, this, arg0);
         return (BFILE)this.postForAll(methodObject27155, (Object)this.delegate.getBfile(arg0));
      } catch (SQLException var3) {
         return (BFILE)this.postForAll(methodObject27155, this.onErrorForAll(methodObject27155, var3));
      }
   }

   public int creationState() {
      super.preForAll(methodObject27535, this, zeroLengthObjectArray);
      return (Integer)this.postForAll(methodObject27535, this.delegate.creationState());
   }

   public Clob getClob(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject27261, this, arg0);
         return (Clob)this.postForAll(methodObject27261, this.proxyFactory.proxyForCreate((Object)this.delegate.getClob(arg0), this, this.proxyCache, methodObject27261));
      } catch (SQLException var3) {
         return (Clob)this.postForAll(methodObject27261, this.onErrorForAll(methodObject27261, var3));
      }
   }

   public void setRefType(String arg0, REF arg1) throws SQLException {
      try {
         super.preForAll(methodObject27209, this, arg0, arg1);
         this.delegate.setRefType(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject27209, var4);
      }
   }

   public void setBlobAtName(String arg0, InputStream arg1) throws SQLException {
      try {
         super.preForAll(methodObject27449, this, arg0, arg1);
         this.delegate.setBlobAtName(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject27449, var4);
      }
   }

   public double getDouble(String arg0) throws SQLException {
      try {
         super.preForAll(methodObject27236, this, arg0);
         return (Double)this.postForAll(methodObject27236, this.delegate.getDouble(arg0));
      } catch (SQLException var3) {
         return (Double)this.postForAll(methodObject27236, this.onErrorForAll(methodObject27236, var3));
      }
   }

   public Object getObject(int arg0, Class arg1) throws SQLException {
      try {
         super.preForAll(methodObject27221, this, arg0, arg1);
         return this.postForAll(methodObject27221, this.proxyFactory.proxyForCache(this.delegate.getObject(arg0, arg1), this, this.proxyCache, methodObject27221));
      } catch (SQLException var4) {
         return this.postForAll(methodObject27221, this.onErrorForAll(methodObject27221, var4));
      }
   }

   public void setNUMBER(int arg0, NUMBER arg1) throws SQLException {
      try {
         super.preForAll(methodObject27503, this, arg0, arg1);
         this.delegate.setNUMBER(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject27503, var4);
      }
   }

   public Timestamp getTimestamp(int arg0, Calendar arg1) throws SQLException {
      try {
         super.preForAll(methodObject27298, this, arg0, arg1);
         return (Timestamp)this.postForAll(methodObject27298, (Object)this.delegate.getTimestamp(arg0, arg1));
      } catch (SQLException var4) {
         return (Timestamp)this.postForAll(methodObject27298, this.onErrorForAll(methodObject27298, var4));
      }
   }

   public void registerOutParameterAtName(String arg0, int arg1, String arg2) throws SQLException {
      try {
         super.preForAll(methodObject27214, this, arg0, arg1, arg2);
         this.delegate.registerOutParameterAtName(arg0, arg1, arg2);
      } catch (SQLException var5) {
         this.onErrorVoidForAll(methodObject27214, var5);
      }
   }

   public InputStream getAsciiStream(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject27138, this, arg0);
         return (InputStream)this.postForAll(methodObject27138, (Object)this.delegate.getAsciiStream(arg0));
      } catch (SQLException var3) {
         return (InputStream)this.postForAll(methodObject27138, this.onErrorForAll(methodObject27138, var3));
      }
   }

   public void setAsciiStream(String arg0, InputStream arg1, int arg2) throws SQLException {
      try {
         super.preForSetStreams(methodObject27124, this, arg0, arg1, arg2);
         this.delegate.setAsciiStream(arg0, arg1, arg2);
      } catch (SQLException var5) {
         this.onErrorVoidForAll(methodObject27124, var5);
      }
   }

   public void setOracleObjectAtName(String arg0, Datum arg1) throws SQLException {
      try {
         super.preForAll(methodObject27474, this, arg0, arg1);
         this.delegate.setOracleObjectAtName(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject27474, var4);
      }
   }

   public void setBigDecimalAtName(String arg0, BigDecimal arg1) throws SQLException {
      try {
         super.preForAll(methodObject27431, this, arg0, arg1);
         this.delegate.setBigDecimalAtName(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject27431, var4);
      }
   }

   public void setRAW(String arg0, RAW arg1) throws SQLException {
      try {
         super.preForAll(methodObject27190, this, arg0, arg1);
         this.delegate.setRAW(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject27190, var4);
      }
   }

   public void exitImplicitCacheToClose() throws SQLException {
      try {
         super.preForAll(methodObject27545, this, zeroLengthObjectArray);
         this.delegate.exitImplicitCacheToClose();
      } catch (SQLException var2) {
         this.onErrorVoidForAll(methodObject27545, var2);
      }
   }

   public byte getByte(String arg0) throws SQLException {
      try {
         super.preForAll(methodObject27226, this, arg0);
         return (Byte)this.postForAll(methodObject27226, this.delegate.getByte(arg0));
      } catch (SQLException var3) {
         return (Byte)this.postForAll(methodObject27226, this.onErrorForAll(methodObject27226, var3));
      }
   }

   public void setBinaryStreamAtName(String arg0, InputStream arg1) throws SQLException {
      try {
         super.preForSetStreams(methodObject27405, this, arg0, arg1);
         this.delegate.setBinaryStreamAtName(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject27405, var4);
      }
   }

   public void setREFAtName(String arg0, REF arg1) throws SQLException {
      try {
         super.preForAll(methodObject27473, this, arg0, arg1);
         this.delegate.setREFAtName(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject27473, var4);
      }
   }

   public OracleStatement.SqlKind getSqlKind() throws SQLException {
      try {
         super.preForAll(methodObject27551, this, zeroLengthObjectArray);
         return (OracleStatement.SqlKind)this.postForAll(methodObject27551, (Object)this.delegate.getSqlKind());
      } catch (SQLException var2) {
         return (OracleStatement.SqlKind)this.postForAll(methodObject27551, this.onErrorForAll(methodObject27551, var2));
      }
   }

   public void clearBatch() throws SQLException {
      try {
         super.preForAll(methodObject27375, this, zeroLengthObjectArray);
         this.delegate.clearBatch();
      } catch (SQLException var2) {
         this.onErrorVoidForAll(methodObject27375, var2);
      }
   }

   public boolean getMoreResults(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject27381, this, arg0);
         return (Boolean)this.postForAll(methodObject27381, this.delegate.getMoreResults(arg0));
      } catch (SQLException var3) {
         return (Boolean)this.postForAll(methodObject27381, this.onErrorForAll(methodObject27381, var3));
      }
   }

   public Timestamp getTimestamp(String arg0) throws SQLException {
      try {
         super.preForAll(methodObject27299, this, arg0);
         return (Timestamp)this.postForAll(methodObject27299, (Object)this.delegate.getTimestamp(arg0));
      } catch (SQLException var3) {
         return (Timestamp)this.postForAll(methodObject27299, this.onErrorForAll(methodObject27299, var3));
      }
   }

   public void setArray(int arg0, Array arg1) throws SQLException {
      try {
         super.preForAll(methodObject27354, this, arg0, arg1);
         this.delegate.setArray(arg0, arg1 instanceof _Proxy_ ? (Array)((_Proxy_)arg1)._getDelegate_() : arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject27354, var4);
      }
   }

   public STRUCT getSTRUCT(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject27168, this, arg0);
         return (STRUCT)this.postForAll(methodObject27168, (Object)this.delegate.getSTRUCT(arg0));
      } catch (SQLException var3) {
         return (STRUCT)this.postForAll(methodObject27168, this.onErrorForAll(methodObject27168, var3));
      }
   }

   public void setAsciiStream(int arg0, InputStream arg1, int arg2) throws SQLException {
      try {
         super.preForSetStreams(methodObject27313, this, arg0, arg1, arg2);
         this.delegate.setAsciiStream(arg0, arg1, arg2);
      } catch (SQLException var5) {
         this.onErrorVoidForAll(methodObject27313, var5);
      }
   }

   public void defineColumnTypeChars(int arg0, int arg1, int arg2) throws SQLException {
      try {
         super.preForAll(methodObject27529, this, arg0, arg1, arg2);
         this.delegate.defineColumnTypeChars(arg0, arg1, arg2);
      } catch (SQLException var5) {
         this.onErrorVoidForAll(methodObject27529, var5);
      }
   }

   public Clob getClob(String arg0) throws SQLException {
      try {
         super.preForAll(methodObject27262, this, arg0);
         return (Clob)this.postForAll(methodObject27262, this.proxyFactory.proxyForCreate((Object)this.delegate.getClob(arg0), this, this.proxyCache, methodObject27262));
      } catch (SQLException var3) {
         return (Clob)this.postForAll(methodObject27262, this.onErrorForAll(methodObject27262, var3));
      }
   }

   public TIMESTAMPLTZ getTIMESTAMPLTZ(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject27173, this, arg0);
         return (TIMESTAMPLTZ)this.postForAll(methodObject27173, (Object)this.delegate.getTIMESTAMPLTZ(arg0));
      } catch (SQLException var3) {
         return (TIMESTAMPLTZ)this.postForAll(methodObject27173, this.onErrorForAll(methodObject27173, var3));
      }
   }

   public void setTime(int arg0, Time arg1) throws SQLException {
      try {
         super.preForAll(methodObject27332, this, arg0, arg1);
         this.delegate.setTime(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject27332, var4);
      }
   }

   public void setREF(String arg0, REF arg1) throws SQLException {
      try {
         super.preForAll(methodObject27210, this, arg0, arg1);
         this.delegate.setREF(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject27210, var4);
      }
   }

   public void registerIndexTableOutParameter(int arg0, int arg1, int arg2, int arg3) throws SQLException {
      try {
         super.preForAll(methodObject27180, this, arg0, arg1, arg2, arg3);
         this.delegate.registerIndexTableOutParameter(arg0, arg1, arg2, arg3);
      } catch (SQLException var6) {
         this.onErrorVoidForAll(methodObject27180, var6);
      }
   }

   public float getFloat(String arg0) throws SQLException {
      try {
         super.preForAll(methodObject27234, this, arg0);
         return (Float)this.postForAll(methodObject27234, this.delegate.getFloat(arg0));
      } catch (SQLException var3) {
         return (Float)this.postForAll(methodObject27234, this.onErrorForAll(methodObject27234, var3));
      }
   }

   public int getcacheState() {
      super.preForAll(methodObject27558, this, zeroLengthObjectArray);
      return (Integer)this.postForAll(methodObject27558, this.delegate.getcacheState());
   }

   public void setClobAtName(String arg0, Clob arg1) throws SQLException {
      try {
         super.preForAll(methodObject27451, this, arg0, arg1);
         this.delegate.setClobAtName(arg0, arg1 instanceof _Proxy_ ? (Clob)((_Proxy_)arg1)._getDelegate_() : arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject27451, var4);
      }
   }

   public void setCustomDatum(String arg0, CustomDatum arg1) throws SQLException {
      try {
         super.preForAll(methodObject27207, this, arg0, arg1);
         this.delegate.setCustomDatum(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject27207, var4);
      }
   }

   public void setFetchSize(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject27397, this, arg0);
         this.delegate.setFetchSize(arg0);
      } catch (SQLException var3) {
         this.onErrorVoidForAll(methodObject27397, var3);
      }
   }

   public int getFetchSize() throws SQLException {
      try {
         super.preForAll(methodObject27395, this, zeroLengthObjectArray);
         return (Integer)this.postForAll(methodObject27395, this.delegate.getFetchSize());
      } catch (SQLException var2) {
         return (Integer)this.postForAll(methodObject27395, this.onErrorForAll(methodObject27395, var2));
      }
   }

   public void setCursorName(String arg0) throws SQLException {
      try {
         super.preForAll(methodObject27388, this, arg0);
         this.delegate.setCursorName(arg0);
      } catch (SQLException var3) {
         this.onErrorVoidForAll(methodObject27388, var3);
      }
   }

   public void setBytes(int arg0, byte[] arg1) throws SQLException {
      try {
         super.preForAll(methodObject27325, this, arg0, arg1);
         this.delegate.setBytes(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject27325, var4);
      }
   }

   public String getOriginalSql() throws SQLException {
      try {
         super.preForAll(methodObject27547, this, zeroLengthObjectArray);
         return (String)this.postForAll(methodObject27547, (Object)this.delegate.getOriginalSql());
      } catch (SQLException var2) {
         return (String)this.postForAll(methodObject27547, this.onErrorForAll(methodObject27547, var2));
      }
   }

   public void setTime(String arg0, Time arg1) throws SQLException {
      try {
         super.preForAll(methodObject27134, this, arg0, arg1);
         this.delegate.setTime(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject27134, var4);
      }
   }

   public void setBinaryStream(int arg0, InputStream arg1, int arg2) throws SQLException {
      try {
         super.preForSetStreams(methodObject27316, this, arg0, arg1, arg2);
         this.delegate.setBinaryStream(arg0, arg1, arg2);
      } catch (SQLException var5) {
         this.onErrorVoidForAll(methodObject27316, var5);
      }
   }

   public String[] getRegisteredTableNames() throws SQLException {
      try {
         super.preForAll(methodObject27537, this, zeroLengthObjectArray);
         return (String[])this.postForAll(methodObject27537, (Object)this.delegate.getRegisteredTableNames());
      } catch (SQLException var2) {
         return (String[])this.postForAll(methodObject27537, this.onErrorForAll(methodObject27537, var2));
      }
   }

   public void setCharacterStream(String arg0, Reader arg1, long arg2) throws SQLException {
      try {
         super.preForSetStreams(methodObject27255, this, arg0, arg1, arg2);
         this.delegate.setCharacterStream(arg0, arg1, arg2);
      } catch (SQLException var6) {
         this.onErrorVoidForAll(methodObject27255, var6);
      }
   }

   public void clearParameters() throws SQLException {
      try {
         super.preForAll(methodObject27338, this, zeroLengthObjectArray);
         this.delegate.clearParameters();
      } catch (SQLException var2) {
         this.onErrorVoidForAll(methodObject27338, var2);
      }
   }

   public Object getObject(String arg0, Map arg1) throws SQLException {
      try {
         super.preForAll(methodObject27220, this, arg0, arg1);
         return this.postForAll(methodObject27220, this.proxyFactory.proxyForCache(this.delegate.getObject(arg0, arg1), this, this.proxyCache, methodObject27220));
      } catch (SQLException var4) {
         return this.postForAll(methodObject27220, this.onErrorForAll(methodObject27220, var4));
      }
   }

   public boolean isWrapperFor(Class arg0) throws SQLException {
      try {
         super.preForAll(methodObject27399, this, arg0);
         return (Boolean)this.postForAll(methodObject27399, this.delegate.isWrapperFor(arg0));
      } catch (SQLException var3) {
         return (Boolean)this.postForAll(methodObject27399, this.onErrorForAll(methodObject27399, var3));
      }
   }

   public void setINTERVALDS(String arg0, INTERVALDS arg1) throws SQLException {
      try {
         super.preForAll(methodObject27199, this, arg0, arg1);
         this.delegate.setINTERVALDS(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject27199, var4);
      }
   }

   public void setARRAYAtName(String arg0, ARRAY arg1) throws SQLException {
      try {
         super.preForAll(methodObject27438, this, arg0, arg1);
         this.delegate.setARRAYAtName(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject27438, var4);
      }
   }

   public void setBlob(String arg0, Blob arg1) throws SQLException {
      try {
         super.preForAll(methodObject27144, this, arg0, arg1);
         this.delegate.setBlob(arg0, arg1 instanceof _Proxy_ ? (Blob)((_Proxy_)arg1)._getDelegate_() : arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject27144, var4);
      }
   }

   public boolean execute() throws SQLException {
      try {
         super.preForExecute(methodObject27311, this, zeroLengthObjectArray);
         return this.postForExecute(methodObject27311, this.delegate.execute());
      } catch (SQLException var2) {
         return this.postForExecute(methodObject27311, this.onErrorForExecute(methodObject27311, var2));
      }
   }

   public void setCharacterStreamAtName(String arg0, Reader arg1) throws SQLException {
      try {
         super.preForSetStreams(methodObject27407, this, arg0, arg1);
         this.delegate.setCharacterStreamAtName(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject27407, var4);
      }
   }

   public Reader getCharacterStream(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject27139, this, arg0);
         return (Reader)this.postForAll(methodObject27139, (Object)this.delegate.getCharacterStream(arg0));
      } catch (SQLException var3) {
         return (Reader)this.postForAll(methodObject27139, this.onErrorForAll(methodObject27139, var3));
      }
   }

   public byte[] privateGetBytes(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject27112, this, arg0);
         return (byte[])this.postForAll(methodObject27112, (Object)this.delegate.privateGetBytes(arg0));
      } catch (SQLException var3) {
         return (byte[])this.postForAll(methodObject27112, this.onErrorForAll(methodObject27112, var3));
      }
   }

   public RowId getRowId(String arg0) throws SQLException {
      try {
         super.preForAll(methodObject27266, this, arg0);
         return (RowId)this.postForAll(methodObject27266, this.proxyFactory.proxyForCreate((Object)this.delegate.getRowId(arg0), this, this.proxyCache, methodObject27266));
      } catch (SQLException var3) {
         return (RowId)this.postForAll(methodObject27266, this.onErrorForAll(methodObject27266, var3));
      }
   }

   public void setCustomDatumAtName(String arg0, CustomDatum arg1) throws SQLException {
      try {
         super.preForAll(methodObject27469, this, arg0, arg1);
         this.delegate.setCustomDatumAtName(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject27469, var4);
      }
   }

   public void setClob(String arg0, Reader arg1) throws SQLException {
      try {
         super.preForAll(methodObject27283, this, arg0, arg1);
         this.delegate.setClob(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject27283, var4);
      }
   }

   public void registerOutParameter(int arg0, int arg1, String arg2) throws SQLException {
      try {
         super.preForAll(methodObject27276, this, arg0, arg1, arg2);
         this.delegate.registerOutParameter(arg0, arg1, arg2);
      } catch (SQLException var5) {
         this.onErrorVoidForAll(methodObject27276, var5);
      }
   }

   public void setURLAtName(String arg0, URL arg1) throws SQLException {
      try {
         super.preForAll(methodObject27475, this, arg0, arg1);
         this.delegate.setURLAtName(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject27475, var4);
      }
   }

   public void setBinaryStream(String arg0, InputStream arg1, long arg2) throws SQLException {
      try {
         super.preForSetStreams(methodObject27253, this, arg0, arg1, arg2);
         this.delegate.setBinaryStream(arg0, arg1, arg2);
      } catch (SQLException var6) {
         this.onErrorVoidForAll(methodObject27253, var6);
      }
   }

   public Datum[] getOraclePlsqlIndexTable(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject27179, this, arg0);
         return (Datum[])this.postForAll(methodObject27179, (Object)this.delegate.getOraclePlsqlIndexTable(arg0));
      } catch (SQLException var3) {
         return (Datum[])this.postForAll(methodObject27179, this.onErrorForAll(methodObject27179, var3));
      }
   }

   public void registerOutParameter(String arg0, int arg1, String arg2) throws SQLException {
      try {
         super.preForAll(methodObject27279, this, arg0, arg1, arg2);
         this.delegate.registerOutParameter(arg0, arg1, arg2);
      } catch (SQLException var5) {
         this.onErrorVoidForAll(methodObject27279, var5);
      }
   }

   public void setCharacterStreamAtName(String arg0, Reader arg1, long arg2) throws SQLException {
      try {
         super.preForSetStreams(methodObject27406, this, arg0, arg1, arg2);
         this.delegate.setCharacterStreamAtName(arg0, arg1, arg2);
      } catch (SQLException var6) {
         this.onErrorVoidForAll(methodObject27406, var6);
      }
   }

   public int getInt(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject27229, this, arg0);
         return (Integer)this.postForAll(methodObject27229, this.delegate.getInt(arg0));
      } catch (SQLException var3) {
         return (Integer)this.postForAll(methodObject27229, this.onErrorForAll(methodObject27229, var3));
      }
   }

   public void setCHARAtName(String arg0, CHAR arg1) throws SQLException {
      try {
         super.preForAll(methodObject27443, this, arg0, arg1);
         this.delegate.setCHARAtName(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject27443, var4);
      }
   }

   public Time getTime(String arg0, Calendar arg1) throws SQLException {
      try {
         super.preForAll(methodObject27272, this, arg0, arg1);
         return (Time)this.postForAll(methodObject27272, (Object)this.delegate.getTime(arg0, arg1));
      } catch (SQLException var4) {
         return (Time)this.postForAll(methodObject27272, this.onErrorForAll(methodObject27272, var4));
      }
   }

   public InputStream getUnicodeStream(String arg0) throws SQLException {
      try {
         super.preForAll(methodObject27151, this, arg0);
         return (InputStream)this.postForAll(methodObject27151, (Object)this.delegate.getUnicodeStream(arg0));
      } catch (SQLException var3) {
         return (InputStream)this.postForAll(methodObject27151, this.onErrorForAll(methodObject27151, var3));
      }
   }

   public int getExecuteBatch() {
      super.preForAll(methodObject27417, this, zeroLengthObjectArray);
      return (Integer)this.postForAll(methodObject27417, this.delegate.getExecuteBatch());
   }

   public void setNUMBERAtName(String arg0, NUMBER arg1) throws SQLException {
      try {
         super.preForAll(methodObject27445, this, arg0, arg1);
         this.delegate.setNUMBERAtName(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject27445, var4);
      }
   }

   public void setINTERVALDS(int arg0, INTERVALDS arg1) throws SQLException {
      try {
         super.preForAll(methodObject27509, this, arg0, arg1);
         this.delegate.setINTERVALDS(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject27509, var4);
      }
   }

   public void setNClobAtName(String arg0, Reader arg1, long arg2) throws SQLException {
      try {
         super.preForAll(methodObject27486, this, arg0, arg1, arg2);
         this.delegate.setNClobAtName(arg0, arg1, arg2);
      } catch (SQLException var6) {
         this.onErrorVoidForAll(methodObject27486, var6);
      }
   }

   public void setOPAQUEAtName(String arg0, OPAQUE arg1) throws SQLException {
      try {
         super.preForAll(methodObject27439, this, arg0, arg1);
         this.delegate.setOPAQUEAtName(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject27439, var4);
      }
   }

   public void setRowId(int arg0, RowId arg1) throws SQLException {
      try {
         super.preForAll(methodObject27352, this, arg0, arg1);
         this.delegate.setRowId(arg0, arg1 instanceof _Proxy_ ? (RowId)((_Proxy_)arg1)._getDelegate_() : arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject27352, var4);
      }
   }

   public boolean getserverCursor() {
      super.preForAll(methodObject27557, this, zeroLengthObjectArray);
      return (Boolean)this.postForAll(methodObject27557, this.delegate.getserverCursor());
   }

   public void setTIMESTAMPTZ(int arg0, TIMESTAMPTZ arg1) throws SQLException {
      try {
         super.preForAll(methodObject27511, this, arg0, arg1);
         this.delegate.setTIMESTAMPTZ(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject27511, var4);
      }
   }

   public Object getPlsqlIndexTable(int arg0, Class arg1) throws SQLException {
      try {
         super.preForAll(methodObject27178, this, arg0, arg1);
         return this.postForAll(methodObject27178, this.proxyFactory.proxyForCache(this.delegate.getPlsqlIndexTable(arg0, arg1), this, this.proxyCache, methodObject27178));
      } catch (SQLException var4) {
         return this.postForAll(methodObject27178, this.onErrorForAll(methodObject27178, var4));
      }
   }

   public void setObject(String arg0, Object arg1) throws SQLException {
      try {
         super.preForSetObjects(methodObject27133, this, arg0, arg1);
         this.delegate.setObject(arg0, arg1 instanceof _Proxy_ ? (Object)((_Proxy_)arg1)._getDelegate_() : arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject27133, var4);
      }
   }

   public void setORAData(int arg0, ORAData arg1) throws SQLException {
      try {
         super.preForAll(methodObject27518, this, arg0, arg1);
         this.delegate.setORAData(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject27518, var4);
      }
   }

   public void setNClobAtName(String arg0, NClob arg1) throws SQLException {
      try {
         super.preForAll(methodObject27485, this, arg0, arg1);
         this.delegate.setNClobAtName(arg0, arg1 instanceof _Proxy_ ? (NClob)((_Proxy_)arg1)._getDelegate_() : arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject27485, var4);
      }
   }

   public void setByte(int arg0, byte arg1) throws SQLException {
      try {
         super.preForAll(methodObject27302, this, arg0, arg1);
         this.delegate.setByte(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject27302, var4);
      }
   }

   public Object getObject(int arg0, OracleDataFactory arg1) throws SQLException {
      try {
         super.preForAll(methodObject27113, this, arg0, arg1);
         return this.postForAll(methodObject27113, this.proxyFactory.proxyForCache(this.delegate.getObject(arg0, arg1), this, this.proxyCache, methodObject27113));
      } catch (SQLException var4) {
         return this.postForAll(methodObject27113, this.onErrorForAll(methodObject27113, var4));
      }
   }

   public void setNCharacterStreamAtName(String arg0, Reader arg1, long arg2) throws SQLException {
      try {
         super.preForSetStreams(methodObject27408, this, arg0, arg1, arg2);
         this.delegate.setNCharacterStreamAtName(arg0, arg1, arg2);
      } catch (SQLException var6) {
         this.onErrorVoidForAll(methodObject27408, var6);
      }
   }

   public String getString(String arg0) throws SQLException {
      try {
         super.preForAll(methodObject27246, this, arg0);
         return (String)this.postForAll(methodObject27246, (Object)this.delegate.getString(arg0));
      } catch (SQLException var3) {
         return (String)this.postForAll(methodObject27246, this.onErrorForAll(methodObject27246, var3));
      }
   }

   public void setRowPrefetch(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject27531, this, arg0);
         this.delegate.setRowPrefetch(arg0);
      } catch (SQLException var3) {
         this.onErrorVoidForAll(methodObject27531, var3);
      }
   }

   public void setTimestamp(int arg0, Timestamp arg1) throws SQLException {
      try {
         super.preForAll(methodObject27308, this, arg0, arg1);
         this.delegate.setTimestamp(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject27308, var4);
      }
   }

   public boolean isPoolable() throws SQLException {
      try {
         super.preForAll(methodObject27387, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject27387, this.delegate.isPoolable());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject27387, this.onErrorForAll(methodObject27387, var2));
      }
   }

   public void defineColumnType(int arg0, int arg1) throws SQLException {
      try {
         super.preForAll(methodObject27524, this, arg0, arg1);
         this.delegate.defineColumnType(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject27524, var4);
      }
   }

   public void setTIMESTAMPTZ(String arg0, TIMESTAMPTZ arg1) throws SQLException {
      try {
         super.preForAll(methodObject27201, this, arg0, arg1);
         this.delegate.setTIMESTAMPTZ(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject27201, var4);
      }
   }

   public void setUnicodeStream(int arg0, InputStream arg1, int arg2) throws SQLException {
      try {
         super.preForAll(methodObject27324, this, arg0, arg1, arg2);
         this.delegate.setUnicodeStream(arg0, arg1, arg2);
      } catch (SQLException var5) {
         this.onErrorVoidForAll(methodObject27324, var5);
      }
   }

   public byte[] getBytes(String arg0) throws SQLException {
      try {
         super.preForAll(methodObject27238, this, arg0);
         return (byte[])this.postForAll(methodObject27238, (Object)this.delegate.getBytes(arg0));
      } catch (SQLException var3) {
         return (byte[])this.postForAll(methodObject27238, this.onErrorForAll(methodObject27238, var3));
      }
   }

   public int getUpdateCount() throws SQLException {
      try {
         super.preForAll(methodObject27385, this, zeroLengthObjectArray);
         return (Integer)this.postForAll(methodObject27385, this.delegate.getUpdateCount());
      } catch (SQLException var2) {
         return (Integer)this.postForAll(methodObject27385, this.onErrorForAll(methodObject27385, var2));
      }
   }

   public void setObject(int arg0, Object arg1, int arg2, int arg3) throws SQLException {
      try {
         super.preForSetObjects(methodObject27328, this, arg0, arg1, arg2, arg3);
         this.delegate.setObject(arg0, arg1 instanceof _Proxy_ ? (Object)((_Proxy_)arg1)._getDelegate_() : arg1, arg2, arg3);
      } catch (SQLException var6) {
         this.onErrorVoidForAll(methodObject27328, var6);
      }
   }

   public String getString(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject27245, this, arg0);
         return (String)this.postForAll(methodObject27245, (Object)this.delegate.getString(arg0));
      } catch (SQLException var3) {
         return (String)this.postForAll(methodObject27245, this.onErrorForAll(methodObject27245, var3));
      }
   }

   public void setMaxFieldSize(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject27390, this, arg0);
         this.delegate.setMaxFieldSize(arg0);
      } catch (SQLException var3) {
         this.onErrorVoidForAll(methodObject27390, var3);
      }
   }

   public void setAsciiStreamAtName(String arg0, InputStream arg1, long arg2) throws SQLException {
      try {
         super.preForSetStreams(methodObject27401, this, arg0, arg1, arg2);
         this.delegate.setAsciiStreamAtName(arg0, arg1, arg2);
      } catch (SQLException var6) {
         this.onErrorVoidForAll(methodObject27401, var6);
      }
   }

   public void setBinaryStream(int arg0, InputStream arg1) throws SQLException {
      try {
         super.preForSetStreams(methodObject27318, this, arg0, arg1);
         this.delegate.setBinaryStream(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject27318, var4);
      }
   }

   public void setAsciiStreamAtName(String arg0, InputStream arg1) throws SQLException {
      try {
         super.preForSetStreams(methodObject27402, this, arg0, arg1);
         this.delegate.setAsciiStreamAtName(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject27402, var4);
      }
   }

   public int[] executeBatch() throws SQLException {
      try {
         super.preForExecuteBatch(methodObject27363, this, zeroLengthObjectArray);
         return (int[])this.postForAll(methodObject27363, (Object)this.delegate.executeBatch());
      } catch (SQLException var2) {
         return (int[])this.postForAll(methodObject27363, this.onErrorForAll(methodObject27363, var2));
      }
   }

   public void setNCharacterStream(String arg0, Reader arg1) throws SQLException {
      try {
         super.preForSetStreams(methodObject27258, this, arg0, arg1);
         this.delegate.setNCharacterStream(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject27258, var4);
      }
   }

   public void setEscapeProcessing(boolean arg0) throws SQLException {
      try {
         super.preForAll(methodObject27389, this, arg0);
         this.delegate.setEscapeProcessing(arg0);
      } catch (SQLException var3) {
         this.onErrorVoidForAll(methodObject27389, var3);
      }
   }

   public void setShortAtName(String arg0, short arg1) throws SQLException {
      try {
         super.preForAll(methodObject27422, this, arg0, arg1);
         this.delegate.setShortAtName(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject27422, var4);
      }
   }

   public void setClob(int arg0, Clob arg1) throws SQLException {
      try {
         super.preForAll(methodObject27343, this, arg0, arg1);
         this.delegate.setClob(arg0, arg1 instanceof _Proxy_ ? (Clob)((_Proxy_)arg1)._getDelegate_() : arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject27343, var4);
      }
   }

   public void setBinaryDouble(int arg0, BINARY_DOUBLE arg1) throws SQLException {
      try {
         super.preForAll(methodObject27494, this, arg0, arg1);
         this.delegate.setBinaryDouble(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject27494, var4);
      }
   }

   public Time getTime(int arg0, Calendar arg1) throws SQLException {
      try {
         super.preForAll(methodObject27270, this, arg0, arg1);
         return (Time)this.postForAll(methodObject27270, (Object)this.delegate.getTime(arg0, arg1));
      } catch (SQLException var4) {
         return (Time)this.postForAll(methodObject27270, this.onErrorForAll(methodObject27270, var4));
      }
   }

   public void setArray(String arg0, Array arg1) throws SQLException {
      try {
         super.preForAll(methodObject27148, this, arg0, arg1);
         this.delegate.setArray(arg0, arg1 instanceof _Proxy_ ? (Array)((_Proxy_)arg1)._getDelegate_() : arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject27148, var4);
      }
   }

   public void setNCharacterStream(String arg0, Reader arg1, long arg2) throws SQLException {
      try {
         super.preForSetStreams(methodObject27257, this, arg0, arg1, arg2);
         this.delegate.setNCharacterStream(arg0, arg1, arg2);
      } catch (SQLException var6) {
         this.onErrorVoidForAll(methodObject27257, var6);
      }
   }

   public OracleParameterMetaData OracleGetParameterMetaData() throws SQLException {
      try {
         super.preForAll(methodObject27480, this, zeroLengthObjectArray);
         return (OracleParameterMetaData)this.postForAll(methodObject27480, this.proxyFactory.proxyForCache((Object)this.delegate.OracleGetParameterMetaData(), this, this.proxyCache, methodObject27480));
      } catch (SQLException var2) {
         return (OracleParameterMetaData)this.postForAll(methodObject27480, this.onErrorForAll(methodObject27480, var2));
      }
   }

   public float getFloat(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject27233, this, arg0);
         return (Float)this.postForAll(methodObject27233, this.delegate.getFloat(arg0));
      } catch (SQLException var3) {
         return (Float)this.postForAll(methodObject27233, this.onErrorForAll(methodObject27233, var3));
      }
   }

   public void setTIMESTAMP(String arg0, TIMESTAMP arg1) throws SQLException {
      try {
         super.preForAll(methodObject27200, this, arg0, arg1);
         this.delegate.setTIMESTAMP(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject27200, var4);
      }
   }

   public void setShort(String arg0, short arg1) throws SQLException {
      try {
         super.preForAll(methodObject27120, this, arg0, arg1);
         this.delegate.setShort(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject27120, var4);
      }
   }

   public TIMESTAMP getTIMESTAMP(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject27171, this, arg0);
         return (TIMESTAMP)this.postForAll(methodObject27171, (Object)this.delegate.getTIMESTAMP(arg0));
      } catch (SQLException var3) {
         return (TIMESTAMP)this.postForAll(methodObject27171, this.onErrorForAll(methodObject27171, var3));
      }
   }

   public void setSQLXMLAtName(String arg0, SQLXML arg1) throws SQLException {
      try {
         super.preForAll(methodObject27490, this, arg0, arg1);
         this.delegate.setSQLXMLAtName(arg0, arg1 instanceof _Proxy_ ? (SQLXML)((_Proxy_)arg1)._getDelegate_() : arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject27490, var4);
      }
   }

   public INTERVALDS getINTERVALDS(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject27170, this, arg0);
         return (INTERVALDS)this.postForAll(methodObject27170, (Object)this.delegate.getINTERVALDS(arg0));
      } catch (SQLException var3) {
         return (INTERVALDS)this.postForAll(methodObject27170, this.onErrorForAll(methodObject27170, var3));
      }
   }

   public boolean isClosed() throws SQLException {
      try {
         super.preForAll(methodObject27368, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject27368, this.delegate.isClosed());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject27368, this.onErrorForAll(methodObject27368, var2));
      }
   }

   public void setTimestampAtName(String arg0, Timestamp arg1) throws SQLException {
      try {
         super.preForAll(methodObject27462, this, arg0, arg1);
         this.delegate.setTimestampAtName(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject27462, var4);
      }
   }

   public int sendBatch() throws SQLException {
      try {
         super.preForAll(methodObject27556, this, zeroLengthObjectArray);
         return (Integer)this.postForAll(methodObject27556, this.delegate.sendBatch());
      } catch (SQLException var2) {
         return (Integer)this.postForAll(methodObject27556, this.onErrorForAll(methodObject27556, var2));
      }
   }

   public Reader getNCharacterStream(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject27293, this, arg0);
         return (Reader)this.postForAll(methodObject27293, (Object)this.delegate.getNCharacterStream(arg0));
      } catch (SQLException var3) {
         return (Reader)this.postForAll(methodObject27293, this.onErrorForAll(methodObject27293, var3));
      }
   }

   public void setOracleObject(String arg0, Datum arg1) throws SQLException {
      try {
         super.preForAll(methodObject27211, this, arg0, arg1);
         this.delegate.setOracleObject(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject27211, var4);
      }
   }

   public void setCharacterStream(int arg0, Reader arg1) throws SQLException {
      try {
         super.preForSetStreams(methodObject27321, this, arg0, arg1);
         this.delegate.setCharacterStream(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject27321, var4);
      }
   }

   public int getRowPrefetch() {
      super.preForAll(methodObject27530, this, zeroLengthObjectArray);
      return (Integer)this.postForAll(methodObject27530, this.delegate.getRowPrefetch());
   }

   public InputStream getAsciiStream(String arg0) throws SQLException {
      try {
         super.preForAll(methodObject27109, this, arg0);
         return (InputStream)this.postForAll(methodObject27109, (Object)this.delegate.getAsciiStream(arg0));
      } catch (SQLException var3) {
         return (InputStream)this.postForAll(methodObject27109, this.onErrorForAll(methodObject27109, var3));
      }
   }

   public void setClob(int arg0, Reader arg1, long arg2) throws SQLException {
      try {
         super.preForAll(methodObject27344, this, arg0, arg1, arg2);
         this.delegate.setClob(arg0, arg1, arg2);
      } catch (SQLException var6) {
         this.onErrorVoidForAll(methodObject27344, var6);
      }
   }

   public void setCLOB(String arg0, CLOB arg1) throws SQLException {
      try {
         super.preForAll(methodObject27195, this, arg0, arg1);
         this.delegate.setCLOB(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject27195, var4);
      }
   }

   public void closeOnCompletion() throws SQLException {
      try {
         super.preForAll(methodObject27376, this, zeroLengthObjectArray);
         this.delegate.closeOnCompletion();
      } catch (SQLException var2) {
         this.onErrorVoidForAll(methodObject27376, var2);
      }
   }

   public void setBinaryFloatAtName(String arg0, float arg1) throws SQLException {
      try {
         super.preForAll(methodObject27427, this, arg0, arg1);
         this.delegate.setBinaryFloatAtName(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject27427, var4);
      }
   }

   public RowId getRowId(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject27265, this, arg0);
         return (RowId)this.postForAll(methodObject27265, this.proxyFactory.proxyForCreate((Object)this.delegate.getRowId(arg0), this, this.proxyCache, methodObject27265));
      } catch (SQLException var3) {
         return (RowId)this.postForAll(methodObject27265, this.onErrorForAll(methodObject27265, var3));
      }
   }

   public URL getURL(String arg0) throws SQLException {
      try {
         super.preForAll(methodObject27242, this, arg0);
         return (URL)this.postForAll(methodObject27242, (Object)this.delegate.getURL(arg0));
      } catch (SQLException var3) {
         return (URL)this.postForAll(methodObject27242, this.onErrorForAll(methodObject27242, var3));
      }
   }

   public Reader getNCharacterStream(String arg0) throws SQLException {
      try {
         super.preForAll(methodObject27294, this, arg0);
         return (Reader)this.postForAll(methodObject27294, (Object)this.delegate.getNCharacterStream(arg0));
      } catch (SQLException var3) {
         return (Reader)this.postForAll(methodObject27294, this.onErrorForAll(methodObject27294, var3));
      }
   }

   public void setBinaryDoubleAtName(String arg0, BINARY_DOUBLE arg1) throws SQLException {
      try {
         super.preForAll(methodObject27430, this, arg0, arg1);
         this.delegate.setBinaryDoubleAtName(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject27430, var4);
      }
   }

   public void setACProxy(Object arg0) {
      super.preForAll(methodObject27561, this, arg0);
      this.delegate.setACProxy(arg0 instanceof _Proxy_ ? (Object)((_Proxy_)arg0)._getDelegate_() : arg0);
   }

   public void setLongAtName(String arg0, long arg1) throws SQLException {
      try {
         super.preForAll(methodObject27424, this, arg0, arg1);
         this.delegate.setLongAtName(arg0, arg1);
      } catch (SQLException var5) {
         this.onErrorVoidForAll(methodObject27424, var5);
      }
   }

   public void setBoolean(int arg0, boolean arg1) throws SQLException {
      try {
         super.preForAll(methodObject27301, this, arg0, arg1);
         this.delegate.setBoolean(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject27301, var4);
      }
   }

   public void setClobAtName(String arg0, Reader arg1, long arg2) throws SQLException {
      try {
         super.preForAll(methodObject27452, this, arg0, arg1, arg2);
         this.delegate.setClobAtName(arg0, arg1, arg2);
      } catch (SQLException var6) {
         this.onErrorVoidForAll(methodObject27452, var6);
      }
   }

   public void setStringAtName(String arg0, String arg1) throws SQLException {
      try {
         super.preForAll(methodObject27432, this, arg0, arg1);
         this.delegate.setStringAtName(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject27432, var4);
      }
   }

   public BigDecimal getBigDecimal(String arg0) throws SQLException {
      try {
         super.preForAll(methodObject27292, this, arg0);
         return (BigDecimal)this.postForAll(methodObject27292, (Object)this.delegate.getBigDecimal(arg0));
      } catch (SQLException var3) {
         return (BigDecimal)this.postForAll(methodObject27292, this.onErrorForAll(methodObject27292, var3));
      }
   }

   public void setBinaryDoubleAtName(String arg0, double arg1) throws SQLException {
      try {
         super.preForAll(methodObject27429, this, arg0, arg1);
         this.delegate.setBinaryDoubleAtName(arg0, arg1);
      } catch (SQLException var5) {
         this.onErrorVoidForAll(methodObject27429, var5);
      }
   }

   public void setAsciiStream(String arg0, InputStream arg1) throws SQLException {
      try {
         super.preForSetStreams(methodObject27252, this, arg0, arg1);
         this.delegate.setAsciiStream(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject27252, var4);
      }
   }

   public void setObjectAtName(String arg0, Object arg1) throws SQLException {
      try {
         super.preForSetObjects(methodObject27413, this, arg0, arg1);
         this.delegate.setObjectAtName(arg0, arg1 instanceof _Proxy_ ? (Object)((_Proxy_)arg1)._getDelegate_() : arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject27413, var4);
      }
   }

   public void setObjectAtName(String arg0, Object arg1, int arg2) throws SQLException {
      try {
         super.preForSetObjects(methodObject27412, this, arg0, arg1, arg2);
         this.delegate.setObjectAtName(arg0, arg1 instanceof _Proxy_ ? (Object)((_Proxy_)arg1)._getDelegate_() : arg1, arg2);
      } catch (SQLException var5) {
         this.onErrorVoidForAll(methodObject27412, var5);
      }
   }

   public Time getTime(String arg0) throws SQLException {
      try {
         super.preForAll(methodObject27271, this, arg0);
         return (Time)this.postForAll(methodObject27271, (Object)this.delegate.getTime(arg0));
      } catch (SQLException var3) {
         return (Time)this.postForAll(methodObject27271, this.onErrorForAll(methodObject27271, var3));
      }
   }

   public void setRefType(int arg0, REF arg1) throws SQLException {
      try {
         super.preForAll(methodObject27519, this, arg0, arg1);
         this.delegate.setRefType(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject27519, var4);
      }
   }

   public void registerOutParameterChars(int arg0, int arg1, int arg2, int arg3) throws SQLException {
      try {
         super.preForAll(methodObject27175, this, arg0, arg1, arg2, arg3);
         this.delegate.registerOutParameterChars(arg0, arg1, arg2, arg3);
      } catch (SQLException var6) {
         this.onErrorVoidForAll(methodObject27175, var6);
      }
   }

   public void setOPAQUE(String arg0, OPAQUE arg1) throws SQLException {
      try {
         super.preForAll(methodObject27204, this, arg0, arg1);
         this.delegate.setOPAQUE(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject27204, var4);
      }
   }

   public void setBinaryStreamAtName(String arg0, InputStream arg1, long arg2) throws SQLException {
      try {
         super.preForSetStreams(methodObject27404, this, arg0, arg1, arg2);
         this.delegate.setBinaryStreamAtName(arg0, arg1, arg2);
      } catch (SQLException var6) {
         this.onErrorVoidForAll(methodObject27404, var6);
      }
   }

   public void setRAW(int arg0, RAW arg1) throws SQLException {
      try {
         super.preForAll(methodObject27500, this, arg0, arg1);
         this.delegate.setRAW(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject27500, var4);
      }
   }

   public void setROWID(String arg0, ROWID arg1) throws SQLException {
      try {
         super.preForAll(methodObject27189, this, arg0, arg1);
         this.delegate.setROWID(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject27189, var4);
      }
   }

   public void setRefAtName(String arg0, Ref arg1) throws SQLException {
      try {
         super.preForAll(methodObject27472, this, arg0, arg1);
         this.delegate.setRefAtName(arg0, arg1 instanceof _Proxy_ ? (Ref)((_Proxy_)arg1)._getDelegate_() : arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject27472, var4);
      }
   }

   public Timestamp getTimestamp(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject27297, this, arg0);
         return (Timestamp)this.postForAll(methodObject27297, (Object)this.delegate.getTimestamp(arg0));
      } catch (SQLException var3) {
         return (Timestamp)this.postForAll(methodObject27297, this.onErrorForAll(methodObject27297, var3));
      }
   }

   public void setDate(String arg0, Date arg1) throws SQLException {
      try {
         super.preForAll(methodObject27136, this, arg0, arg1);
         this.delegate.setDate(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject27136, var4);
      }
   }

   public ResultSet getReturnResultSet() throws SQLException {
      try {
         super.preForAll(methodObject27484, this, zeroLengthObjectArray);
         return (ResultSet)this.postForAll(methodObject27484, this.proxyFactory.proxyForCache((Object)this.delegate.getReturnResultSet(), this, this.proxyCache, methodObject27484));
      } catch (SQLException var2) {
         return (ResultSet)this.postForAll(methodObject27484, this.onErrorForAll(methodObject27484, var2));
      }
   }

   public Date getDate(String arg0, Calendar arg1) throws SQLException {
      try {
         super.preForAll(methodObject27250, this, arg0, arg1);
         return (Date)this.postForAll(methodObject27250, (Object)this.delegate.getDate(arg0, arg1));
      } catch (SQLException var4) {
         return (Date)this.postForAll(methodObject27250, this.onErrorForAll(methodObject27250, var4));
      }
   }

   public byte[] getBytes(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject27237, this, arg0);
         return (byte[])this.postForAll(methodObject27237, (Object)this.delegate.getBytes(arg0));
      } catch (SQLException var3) {
         return (byte[])this.postForAll(methodObject27237, this.onErrorForAll(methodObject27237, var3));
      }
   }

   public void setBytesAtName(String arg0, byte[] arg1) throws SQLException {
      try {
         super.preForAll(methodObject27456, this, arg0, arg1);
         this.delegate.setBytesAtName(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject27456, var4);
      }
   }

   public void setINTERVALYMAtName(String arg0, INTERVALYM arg1) throws SQLException {
      try {
         super.preForAll(methodObject27464, this, arg0, arg1);
         this.delegate.setINTERVALYMAtName(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject27464, var4);
      }
   }

   public void setIntAtName(String arg0, int arg1) throws SQLException {
      try {
         super.preForAll(methodObject27423, this, arg0, arg1);
         this.delegate.setIntAtName(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject27423, var4);
      }
   }

   public void setObject(String arg0, Object arg1, int arg2, int arg3) throws SQLException {
      try {
         super.preForSetObjects(methodObject27131, this, arg0, arg1, arg2, arg3);
         this.delegate.setObject(arg0, arg1 instanceof _Proxy_ ? (Object)((_Proxy_)arg1)._getDelegate_() : arg1, arg2, arg3);
      } catch (SQLException var6) {
         this.onErrorVoidForAll(methodObject27131, var6);
      }
   }

   public void setBinaryStream(String arg0, InputStream arg1, int arg2) throws SQLException {
      try {
         super.preForSetStreams(methodObject27125, this, arg0, arg1, arg2);
         this.delegate.setBinaryStream(arg0, arg1, arg2);
      } catch (SQLException var5) {
         this.onErrorVoidForAll(methodObject27125, var5);
      }
   }

   public void setBinaryFloat(int arg0, float arg1) throws SQLException {
      try {
         super.preForAll(methodObject27491, this, arg0, arg1);
         this.delegate.setBinaryFloat(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject27491, var4);
      }
   }

   public void setSTRUCT(String arg0, STRUCT arg1) throws SQLException {
      try {
         super.preForAll(methodObject27206, this, arg0, arg1);
         this.delegate.setSTRUCT(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject27206, var4);
      }
   }

   public void setNClob(String arg0, Reader arg1, long arg2) throws SQLException {
      try {
         super.preForAll(methodObject27285, this, arg0, arg1, arg2);
         this.delegate.setNClob(arg0, arg1, arg2);
      } catch (SQLException var6) {
         this.onErrorVoidForAll(methodObject27285, var6);
      }
   }

   public void setAsciiStream(int arg0, InputStream arg1) throws SQLException {
      try {
         super.preForSetStreams(methodObject27315, this, arg0, arg1);
         this.delegate.setAsciiStream(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject27315, var4);
      }
   }

   public INTERVALYM getINTERVALYM(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject27169, this, arg0);
         return (INTERVALYM)this.postForAll(methodObject27169, (Object)this.delegate.getINTERVALYM(arg0));
      } catch (SQLException var3) {
         return (INTERVALYM)this.postForAll(methodObject27169, this.onErrorForAll(methodObject27169, var3));
      }
   }

   public void setNullAtName(String arg0, int arg1) throws SQLException {
      try {
         super.preForAll(methodObject27419, this, arg0, arg1);
         this.delegate.setNullAtName(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject27419, var4);
      }
   }

   public void addBatch(String arg0) throws SQLException {
      try {
         super.preForAll(methodObject27374, this, arg0);
         this.delegate.addBatch(arg0);
      } catch (SQLException var3) {
         this.onErrorVoidForAll(methodObject27374, var3);
      }
   }

   public Object unwrap(Class arg0) throws SQLException {
      try {
         super.preForAll(methodObject27398, this, arg0);
         return this.postForAll(methodObject27398, super.unwrap(arg0));
      } catch (SQLException var3) {
         return this.postForAll(methodObject27398, this.onErrorForAll(methodObject27398, var3));
      }
   }

   public void registerOutParameter(String arg0, int arg1, int arg2) throws SQLException {
      try {
         super.preForAll(methodObject27278, this, arg0, arg1, arg2);
         this.delegate.registerOutParameter(arg0, arg1, arg2);
      } catch (SQLException var5) {
         this.onErrorVoidForAll(methodObject27278, var5);
      }
   }

   public int getResultSetConcurrency() throws SQLException {
      try {
         super.preForAll(methodObject27383, this, zeroLengthObjectArray);
         return (Integer)this.postForAll(methodObject27383, this.delegate.getResultSetConcurrency());
      } catch (SQLException var2) {
         return (Integer)this.postForAll(methodObject27383, this.onErrorForAll(methodObject27383, var2));
      }
   }

   public Object getORAData(int arg0, ORADataFactory arg1) throws SQLException {
      try {
         super.preForAll(methodObject27160, this, arg0, arg1);
         return this.postForAll(methodObject27160, this.proxyFactory.proxyForCache(this.delegate.getORAData(arg0, arg1), this, this.proxyCache, methodObject27160));
      } catch (SQLException var4) {
         return this.postForAll(methodObject27160, this.onErrorForAll(methodObject27160, var4));
      }
   }

   public void registerReturnParameter(int arg0, int arg1, int arg2) throws SQLException {
      try {
         super.preForAll(methodObject27482, this, arg0, arg1, arg2);
         this.delegate.registerReturnParameter(arg0, arg1, arg2);
      } catch (SQLException var5) {
         this.onErrorVoidForAll(methodObject27482, var5);
      }
   }

   public void setTimestampAtName(String arg0, Timestamp arg1, Calendar arg2) throws SQLException {
      try {
         super.preForAll(methodObject27463, this, arg0, arg1, arg2);
         this.delegate.setTimestampAtName(arg0, arg1, arg2);
      } catch (SQLException var5) {
         this.onErrorVoidForAll(methodObject27463, var5);
      }
   }

   public void setBlobAtName(String arg0, Blob arg1) throws SQLException {
      try {
         super.preForAll(methodObject27447, this, arg0, arg1);
         this.delegate.setBlobAtName(arg0, arg1 instanceof _Proxy_ ? (Blob)((_Proxy_)arg1)._getDelegate_() : arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject27447, var4);
      }
   }

   public void exitExplicitCacheToActive() throws SQLException {
      try {
         super.preForAll(methodObject27544, this, zeroLengthObjectArray);
         this.delegate.exitExplicitCacheToActive();
      } catch (SQLException var2) {
         this.onErrorVoidForAll(methodObject27544, var2);
      }
   }

   public void enterExplicitCache() throws SQLException {
      try {
         super.preForAll(methodObject27542, this, zeroLengthObjectArray);
         this.delegate.enterExplicitCache();
      } catch (SQLException var2) {
         this.onErrorVoidForAll(methodObject27542, var2);
      }
   }

   public void setObject(int arg0, Object arg1) throws SQLException {
      try {
         super.preForSetObjects(methodObject27327, this, arg0, arg1);
         this.delegate.setObject(arg0, arg1 instanceof _Proxy_ ? (Object)((_Proxy_)arg1)._getDelegate_() : arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject27327, var4);
      }
   }

   public void registerReturnParameter(int arg0, int arg1) throws SQLException {
      try {
         super.preForAll(methodObject27481, this, arg0, arg1);
         this.delegate.registerReturnParameter(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject27481, var4);
      }
   }

   public void setNullAtName(String arg0, int arg1, String arg2) throws SQLException {
      try {
         super.preForAll(methodObject27418, this, arg0, arg1, arg2);
         this.delegate.setNullAtName(arg0, arg1, arg2);
      } catch (SQLException var5) {
         this.onErrorVoidForAll(methodObject27418, var5);
      }
   }

   public int getInt(String arg0) throws SQLException {
      try {
         super.preForAll(methodObject27230, this, arg0);
         return (Integer)this.postForAll(methodObject27230, this.delegate.getInt(arg0));
      } catch (SQLException var3) {
         return (Integer)this.postForAll(methodObject27230, this.onErrorForAll(methodObject27230, var3));
      }
   }

   public void setFixedString(boolean arg0) {
      super.preForAll(methodObject27554, this, arg0);
      this.delegate.setFixedString(arg0);
   }

   public void setRef(int arg0, Ref arg1) throws SQLException {
      try {
         super.preForAll(methodObject27355, this, arg0, arg1);
         this.delegate.setRef(arg0, arg1 instanceof _Proxy_ ? (Ref)((_Proxy_)arg1)._getDelegate_() : arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject27355, var4);
      }
   }

   public void setExecuteBatch(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject27549, this, arg0);
         this.delegate.setExecuteBatch(arg0);
      } catch (SQLException var3) {
         this.onErrorVoidForAll(methodObject27549, var3);
      }
   }

   public void setBinaryFloatAtName(String arg0, BINARY_FLOAT arg1) throws SQLException {
      try {
         super.preForAll(methodObject27428, this, arg0, arg1);
         this.delegate.setBinaryFloatAtName(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject27428, var4);
      }
   }

   public ResultSet getResultSet() throws SQLException {
      try {
         super.preForAll(methodObject27362, this, zeroLengthObjectArray);
         return (ResultSet)this.postForAll(methodObject27362, this.proxyFactory.proxyForCache((Object)this.delegate.getResultSet(), this, this.proxyCache, methodObject27362));
      } catch (SQLException var2) {
         return (ResultSet)this.postForAll(methodObject27362, this.onErrorForAll(methodObject27362, var2));
      }
   }

   public void setFixedCHAR(String arg0, String arg1) throws SQLException {
      try {
         super.preForAll(methodObject27187, this, arg0, arg1);
         this.delegate.setFixedCHAR(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject27187, var4);
      }
   }

   public void defineColumnType(int arg0, int arg1, int arg2, short arg3) throws SQLException {
      try {
         super.preForAll(methodObject27526, this, arg0, arg1, arg2, arg3);
         this.delegate.defineColumnType(arg0, arg1, arg2, arg3);
      } catch (SQLException var6) {
         this.onErrorVoidForAll(methodObject27526, var6);
      }
   }

   public void setBfileAtName(String arg0, BFILE arg1) throws SQLException {
      try {
         super.preForAll(methodObject27455, this, arg0, arg1);
         this.delegate.setBfileAtName(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject27455, var4);
      }
   }

   public void setTIMESTAMPTZAtName(String arg0, TIMESTAMPTZ arg1) throws SQLException {
      try {
         super.preForAll(methodObject27467, this, arg0, arg1);
         this.delegate.setTIMESTAMPTZAtName(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject27467, var4);
      }
   }

   public BLOB getBLOB(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject27156, this, arg0);
         return (BLOB)this.postForAll(methodObject27156, (Object)this.delegate.getBLOB(arg0));
      } catch (SQLException var3) {
         return (BLOB)this.postForAll(methodObject27156, this.onErrorForAll(methodObject27156, var3));
      }
   }

   public void defineColumnType(int arg0, int arg1, int arg2) throws SQLException {
      try {
         super.preForAll(methodObject27525, this, arg0, arg1, arg2);
         this.delegate.defineColumnType(arg0, arg1, arg2);
      } catch (SQLException var5) {
         this.onErrorVoidForAll(methodObject27525, var5);
      }
   }

   public CHAR getCHAR(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject27157, this, arg0);
         return (CHAR)this.postForAll(methodObject27157, (Object)this.delegate.getCHAR(arg0));
      } catch (SQLException var3) {
         return (CHAR)this.postForAll(methodObject27157, this.onErrorForAll(methodObject27157, var3));
      }
   }

   public long getRegisteredQueryId() throws SQLException {
      try {
         super.preForAll(methodObject27538, this, zeroLengthObjectArray);
         return (Long)this.postForAll(methodObject27538, this.delegate.getRegisteredQueryId());
      } catch (SQLException var2) {
         return (Long)this.postForAll(methodObject27538, this.onErrorForAll(methodObject27538, var2));
      }
   }

   public void setDateAtName(String arg0, Date arg1) throws SQLException {
      try {
         super.preForAll(methodObject27458, this, arg0, arg1);
         this.delegate.setDateAtName(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject27458, var4);
      }
   }

   public void setTIMESTAMPLTZ(String arg0, TIMESTAMPLTZ arg1) throws SQLException {
      try {
         super.preForAll(methodObject27202, this, arg0, arg1);
         this.delegate.setTIMESTAMPLTZ(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject27202, var4);
      }
   }

   public void setFixedCHAR(int arg0, String arg1) throws SQLException {
      try {
         super.preForAll(methodObject27497, this, arg0, arg1);
         this.delegate.setFixedCHAR(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject27497, var4);
      }
   }

   public void setSnapshotSCN(long arg0) throws SQLException {
      try {
         super.preForAll(methodObject27553, this, arg0);
         this.delegate.setSnapshotSCN(arg0);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject27553, var4);
      }
   }

   public boolean execute(String arg0, int[] arg1) throws SQLException {
      try {
         super.preForExecute(methodObject27359, this, arg0, arg1);
         return this.postForExecute(methodObject27359, this.delegate.execute(arg0, arg1));
      } catch (SQLException var4) {
         return this.postForExecute(methodObject27359, this.onErrorForExecute(methodObject27359, var4));
      }
   }

   public void setINTERVALDSAtName(String arg0, INTERVALDS arg1) throws SQLException {
      try {
         super.preForAll(methodObject27465, this, arg0, arg1);
         this.delegate.setINTERVALDSAtName(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject27465, var4);
      }
   }

   public void setBigDecimal(String arg0, BigDecimal arg1) throws SQLException {
      try {
         super.preForAll(methodObject27143, this, arg0, arg1);
         this.delegate.setBigDecimal(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject27143, var4);
      }
   }

   public Object getObject(String arg0) throws SQLException {
      try {
         super.preForAll(methodObject27219, this, arg0);
         return this.postForAll(methodObject27219, this.proxyFactory.proxyForCache(this.delegate.getObject(arg0), this, this.proxyCache, methodObject27219));
      } catch (SQLException var3) {
         return this.postForAll(methodObject27219, this.onErrorForAll(methodObject27219, var3));
      }
   }

   public boolean getMoreResults() throws SQLException {
      try {
         super.preForAll(methodObject27380, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject27380, this.delegate.getMoreResults());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject27380, this.onErrorForAll(methodObject27380, var2));
      }
   }

   public boolean getBoolean(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject27223, this, arg0);
         return (Boolean)this.postForAll(methodObject27223, this.delegate.getBoolean(arg0));
      } catch (SQLException var3) {
         return (Boolean)this.postForAll(methodObject27223, this.onErrorForAll(methodObject27223, var3));
      }
   }

   public BigDecimal getBigDecimal(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject27291, this, arg0);
         return (BigDecimal)this.postForAll(methodObject27291, (Object)this.delegate.getBigDecimal(arg0));
      } catch (SQLException var3) {
         return (BigDecimal)this.postForAll(methodObject27291, this.onErrorForAll(methodObject27291, var3));
      }
   }

   public void setCursorAtName(String arg0, ResultSet arg1) throws SQLException {
      try {
         super.preForAll(methodObject27435, this, arg0, arg1);
         this.delegate.setCursorAtName(arg0, arg1 instanceof _Proxy_ ? (ResultSet)((_Proxy_)arg1)._getDelegate_() : arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject27435, var4);
      }
   }

   public void setUnicodeStreamAtName(String arg0, InputStream arg1, int arg2) throws SQLException {
      try {
         super.preForAll(methodObject27410, this, arg0, arg1, arg2);
         this.delegate.setUnicodeStreamAtName(arg0, arg1, arg2);
      } catch (SQLException var5) {
         this.onErrorVoidForAll(methodObject27410, var5);
      }
   }

   public void setINTERVALYM(String arg0, INTERVALYM arg1) throws SQLException {
      try {
         super.preForAll(methodObject27198, this, arg0, arg1);
         this.delegate.setINTERVALYM(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject27198, var4);
      }
   }

   public void setString(int arg0, String arg1) throws SQLException {
      try {
         super.preForAll(methodObject27336, this, arg0, arg1);
         this.delegate.setString(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject27336, var4);
      }
   }

   public short getShort(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject27227, this, arg0);
         return (Short)this.postForAll(methodObject27227, this.delegate.getShort(arg0));
      } catch (SQLException var3) {
         return (Short)this.postForAll(methodObject27227, this.onErrorForAll(methodObject27227, var3));
      }
   }

   public void setTimestamp(String arg0, Timestamp arg1) throws SQLException {
      try {
         super.preForAll(methodObject27121, this, arg0, arg1);
         this.delegate.setTimestamp(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject27121, var4);
      }
   }

   public int executeUpdate(String arg0, String[] arg1) throws SQLException {
      try {
         super.preForExecuteUpdate(methodObject27367, this, arg0, arg1);
         return this.postForExecuteUpdate(methodObject27367, this.delegate.executeUpdate(arg0, arg1));
      } catch (SQLException var4) {
         return this.postForExecuteUpdate(methodObject27367, (Integer)this.onErrorForAll(methodObject27367, var4));
      }
   }

   public void setClob(String arg0, Clob arg1) throws SQLException {
      try {
         super.preForAll(methodObject27145, this, arg0, arg1);
         this.delegate.setClob(arg0, arg1 instanceof _Proxy_ ? (Clob)((_Proxy_)arg1)._getDelegate_() : arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject27145, var4);
      }
   }

   public void setNull(String arg0, int arg1) throws SQLException {
      try {
         super.preForAll(methodObject27147, this, arg0, arg1);
         this.delegate.setNull(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject27147, var4);
      }
   }

   public void setBLOB(int arg0, BLOB arg1) throws SQLException {
      try {
         super.preForAll(methodObject27504, this, arg0, arg1);
         this.delegate.setBLOB(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject27504, var4);
      }
   }

   public void exitImplicitCacheToActive() throws SQLException {
      try {
         super.preForAll(methodObject27543, this, zeroLengthObjectArray);
         this.delegate.exitImplicitCacheToActive();
      } catch (SQLException var2) {
         this.onErrorVoidForAll(methodObject27543, var2);
      }
   }

   public boolean execute(String arg0, int arg1) throws SQLException {
      try {
         super.preForExecute(methodObject27358, this, arg0, arg1);
         return this.postForExecute(methodObject27358, this.delegate.execute(arg0, arg1));
      } catch (SQLException var4) {
         return this.postForExecute(methodObject27358, this.onErrorForExecute(methodObject27358, var4));
      }
   }

   public void setNClobAtName(String arg0, Reader arg1) throws SQLException {
      try {
         super.preForAll(methodObject27487, this, arg0, arg1);
         this.delegate.setNClobAtName(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject27487, var4);
      }
   }

   public Blob getBlob(String arg0) throws SQLException {
      try {
         super.preForAll(methodObject27260, this, arg0);
         return (Blob)this.postForAll(methodObject27260, this.proxyFactory.proxyForCreate((Object)this.delegate.getBlob(arg0), this, this.proxyCache, methodObject27260));
      } catch (SQLException var3) {
         return (Blob)this.postForAll(methodObject27260, this.onErrorForAll(methodObject27260, var3));
      }
   }

   public void setString(String arg0, String arg1) throws SQLException {
      try {
         super.preForAll(methodObject27140, this, arg0, arg1);
         this.delegate.setString(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject27140, var4);
      }
   }

   public Object getObject(int arg0, Map arg1) throws SQLException {
      try {
         super.preForAll(methodObject27218, this, arg0, arg1);
         return this.postForAll(methodObject27218, this.proxyFactory.proxyForCache(this.delegate.getObject(arg0, arg1), this, this.proxyCache, methodObject27218));
      } catch (SQLException var4) {
         return this.postForAll(methodObject27218, this.onErrorForAll(methodObject27218, var4));
      }
   }

   public void setClob(int arg0, Reader arg1) throws SQLException {
      try {
         super.preForAll(methodObject27345, this, arg0, arg1);
         this.delegate.setClob(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject27345, var4);
      }
   }

   public ResultSet executeQuery() throws SQLException {
      try {
         super.preForAll(methodObject27329, this, zeroLengthObjectArray);
         return this.postForExecuteQuery(methodObject27329, (ResultSet)this.proxyFactory.proxyForCreateCache((Object)this.delegate.executeQuery(), this, this.proxyCache, methodObject27329));
      } catch (SQLException var2) {
         return this.postForExecuteQuery(methodObject27329, (ResultSet)this.onErrorForAll(methodObject27329, var2));
      }
   }

   public void setAsciiStream(String arg0, InputStream arg1, long arg2) throws SQLException {
      try {
         super.preForSetStreams(methodObject27251, this, arg0, arg1, arg2);
         this.delegate.setAsciiStream(arg0, arg1, arg2);
      } catch (SQLException var6) {
         this.onErrorVoidForAll(methodObject27251, var6);
      }
   }

   public Object getAnyDataEmbeddedObject(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject27161, this, arg0);
         return this.postForAll(methodObject27161, this.proxyFactory.proxyForCache(this.delegate.getAnyDataEmbeddedObject(arg0), this, this.proxyCache, methodObject27161));
      } catch (SQLException var3) {
         return this.postForAll(methodObject27161, this.onErrorForAll(methodObject27161, var3));
      }
   }

   public URL getURL(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject27241, this, arg0);
         return (URL)this.postForAll(methodObject27241, (Object)this.delegate.getURL(arg0));
      } catch (SQLException var3) {
         return (URL)this.postForAll(methodObject27241, this.onErrorForAll(methodObject27241, var3));
      }
   }

   public void setFixedCHARAtName(String arg0, String arg1) throws SQLException {
      try {
         super.preForAll(methodObject27434, this, arg0, arg1);
         this.delegate.setFixedCHARAtName(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject27434, var4);
      }
   }

   public void setROWID(int arg0, ROWID arg1) throws SQLException {
      try {
         super.preForAll(methodObject27499, this, arg0, arg1);
         this.delegate.setROWID(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject27499, var4);
      }
   }

   public void setNClob(String arg0, NClob arg1) throws SQLException {
      try {
         super.preForAll(methodObject27284, this, arg0, arg1);
         this.delegate.setNClob(arg0, arg1 instanceof _Proxy_ ? (NClob)((_Proxy_)arg1)._getDelegate_() : arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject27284, var4);
      }
   }

   public SQLWarning getWarnings() throws SQLException {
      try {
         super.preForAll(methodObject27371, this, zeroLengthObjectArray);
         return (SQLWarning)this.postForAll(methodObject27371, (Object)this.delegate.getWarnings());
      } catch (SQLException var2) {
         return (SQLWarning)this.postForAll(methodObject27371, this.onErrorForAll(methodObject27371, var2));
      }
   }

   public void setTIMESTAMP(int arg0, TIMESTAMP arg1) throws SQLException {
      try {
         super.preForAll(methodObject27510, this, arg0, arg1);
         this.delegate.setTIMESTAMP(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject27510, var4);
      }
   }

   public Reader getCharacterStream(String arg0) throws SQLException {
      try {
         super.preForAll(methodObject27110, this, arg0);
         return (Reader)this.postForAll(methodObject27110, (Object)this.delegate.getCharacterStream(arg0));
      } catch (SQLException var3) {
         return (Reader)this.postForAll(methodObject27110, this.onErrorForAll(methodObject27110, var3));
      }
   }

   public DATE getDATE(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject27162, this, arg0);
         return (DATE)this.postForAll(methodObject27162, (Object)this.delegate.getDATE(arg0));
      } catch (SQLException var3) {
         return (DATE)this.postForAll(methodObject27162, this.onErrorForAll(methodObject27162, var3));
      }
   }

   public CLOB getCLOB(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject27158, this, arg0);
         return (CLOB)this.postForAll(methodObject27158, (Object)this.delegate.getCLOB(arg0));
      } catch (SQLException var3) {
         return (CLOB)this.postForAll(methodObject27158, this.onErrorForAll(methodObject27158, var3));
      }
   }

   public void setStructDescriptor(String arg0, StructDescriptor arg1) throws SQLException {
      try {
         super.preForAll(methodObject27205, this, arg0, arg1);
         this.delegate.setStructDescriptor(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject27205, var4);
      }
   }

   public Connection getConnection() throws SQLException {
      try {
         super.preForAll(methodObject27370, this, zeroLengthObjectArray);
         return (Connection)this.postForAll(methodObject27370, (Object)super.getConnection());
      } catch (SQLException var2) {
         return (Connection)this.postForAll(methodObject27370, this.onErrorForAll(methodObject27370, var2));
      }
   }

   public void setClobAtName(String arg0, Reader arg1) throws SQLException {
      try {
         super.preForAll(methodObject27453, this, arg0, arg1);
         this.delegate.setClobAtName(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject27453, var4);
      }
   }

   public void setDATE(String arg0, DATE arg1) throws SQLException {
      try {
         super.preForAll(methodObject27192, this, arg0, arg1);
         this.delegate.setDATE(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject27192, var4);
      }
   }

   public Timestamp getTimestamp(String arg0, Calendar arg1) throws SQLException {
      try {
         super.preForAll(methodObject27300, this, arg0, arg1);
         return (Timestamp)this.postForAll(methodObject27300, (Object)this.delegate.getTimestamp(arg0, arg1));
      } catch (SQLException var4) {
         return (Timestamp)this.postForAll(methodObject27300, this.onErrorForAll(methodObject27300, var4));
      }
   }

   public long getLong(String arg0) throws SQLException {
      try {
         super.preForAll(methodObject27232, this, arg0);
         return (Long)this.postForAll(methodObject27232, this.delegate.getLong(arg0));
      } catch (SQLException var3) {
         return (Long)this.postForAll(methodObject27232, this.onErrorForAll(methodObject27232, var3));
      }
   }

   public void setMaxRows(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject27391, this, arg0);
         this.delegate.setMaxRows(arg0);
      } catch (SQLException var3) {
         this.onErrorVoidForAll(methodObject27391, var3);
      }
   }

   public void setFormOfUse(int arg0, short arg1) {
      super.preForAll(methodObject27478, this, arg0, arg1);
      this.delegate.setFormOfUse(arg0, arg1);
   }

   public ROWID getROWID(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject27167, this, arg0);
         return (ROWID)this.postForAll(methodObject27167, (Object)this.delegate.getROWID(arg0));
      } catch (SQLException var3) {
         return (ROWID)this.postForAll(methodObject27167, this.onErrorForAll(methodObject27167, var3));
      }
   }

   public void registerOutParameterAtName(String arg0, int arg1, int arg2) throws SQLException {
      try {
         super.preForAll(methodObject27213, this, arg0, arg1, arg2);
         this.delegate.registerOutParameterAtName(arg0, arg1, arg2);
      } catch (SQLException var5) {
         this.onErrorVoidForAll(methodObject27213, var5);
      }
   }

   public boolean isNCHAR(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject27522, this, arg0);
         return (Boolean)this.postForAll(methodObject27522, this.delegate.isNCHAR(arg0));
      } catch (SQLException var3) {
         return (Boolean)this.postForAll(methodObject27522, this.onErrorForAll(methodObject27522, var3));
      }
   }

   public void close() throws SQLException {
      try {
         super.preForAll(methodObject27356, this, zeroLengthObjectArray);
         Method var10001 = methodObject27356;
         this.delegate.close();
         this.postForClose(var10001);
      } catch (SQLException var2) {
         this.onErrorVoidForClose(methodObject27356, var2);
      }
   }

   public ResultSet getCursor(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject27153, this, arg0);
         return (ResultSet)this.postForAll(methodObject27153, this.proxyFactory.proxyForCache((Object)this.delegate.getCursor(arg0), this, this.proxyCache, methodObject27153));
      } catch (SQLException var3) {
         return (ResultSet)this.postForAll(methodObject27153, this.onErrorForAll(methodObject27153, var3));
      }
   }

   public void setTimeAtName(String arg0, Time arg1, Calendar arg2) throws SQLException {
      try {
         super.preForAll(methodObject27461, this, arg0, arg1, arg2);
         this.delegate.setTimeAtName(arg0, arg1, arg2);
      } catch (SQLException var5) {
         this.onErrorVoidForAll(methodObject27461, var5);
      }
   }

   public void setFloatAtName(String arg0, float arg1) throws SQLException {
      try {
         super.preForAll(methodObject27425, this, arg0, arg1);
         this.delegate.setFloatAtName(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject27425, var4);
      }
   }

   public RAW getRAW(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject27165, this, arg0);
         return (RAW)this.postForAll(methodObject27165, (Object)this.delegate.getRAW(arg0));
      } catch (SQLException var3) {
         return (RAW)this.postForAll(methodObject27165, this.onErrorForAll(methodObject27165, var3));
      }
   }

   public void setBLOB(String arg0, BLOB arg1) throws SQLException {
      try {
         super.preForAll(methodObject27194, this, arg0, arg1);
         this.delegate.setBLOB(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject27194, var4);
      }
   }

   public void setTimestamp(int arg0, Timestamp arg1, Calendar arg2) throws SQLException {
      try {
         super.preForAll(methodObject27309, this, arg0, arg1, arg2);
         this.delegate.setTimestamp(arg0, arg1, arg2);
      } catch (SQLException var5) {
         this.onErrorVoidForAll(methodObject27309, var5);
      }
   }

   public void setBinaryStream(int arg0, InputStream arg1, long arg2) throws SQLException {
      try {
         super.preForSetStreams(methodObject27317, this, arg0, arg1, arg2);
         this.delegate.setBinaryStream(arg0, arg1, arg2);
      } catch (SQLException var6) {
         this.onErrorVoidForAll(methodObject27317, var6);
      }
   }

   public NClob getNClob(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject27263, this, arg0);
         return (NClob)this.postForAll(methodObject27263, this.proxyFactory.proxyForCreate((Object)this.delegate.getNClob(arg0), this, this.proxyCache, methodObject27263));
      } catch (SQLException var3) {
         return (NClob)this.postForAll(methodObject27263, this.onErrorForAll(methodObject27263, var3));
      }
   }

   public void setBytes(String arg0, byte[] arg1) throws SQLException {
      try {
         super.preForAll(methodObject27130, this, arg0, arg1);
         this.delegate.setBytes(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject27130, var4);
      }
   }

   public void setInt(String arg0, int arg1) throws SQLException {
      try {
         super.preForAll(methodObject27118, this, arg0, arg1);
         this.delegate.setInt(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject27118, var4);
      }
   }

   public void setTime(String arg0, Time arg1, Calendar arg2) throws SQLException {
      try {
         super.preForAll(methodObject27135, this, arg0, arg1, arg2);
         this.delegate.setTime(arg0, arg1, arg2);
      } catch (SQLException var5) {
         this.onErrorVoidForAll(methodObject27135, var5);
      }
   }

   public void setBlobAtName(String arg0, InputStream arg1, long arg2) throws SQLException {
      try {
         super.preForAll(methodObject27448, this, arg0, arg1, arg2);
         this.delegate.setBlobAtName(arg0, arg1, arg2);
      } catch (SQLException var6) {
         this.onErrorVoidForAll(methodObject27448, var6);
      }
   }

   public Array getArray(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject27239, this, arg0);
         return (Array)this.postForAll(methodObject27239, this.proxyFactory.proxyForCreate((Object)this.delegate.getArray(arg0), this, this.proxyCache, methodObject27239));
      } catch (SQLException var3) {
         return (Array)this.postForAll(methodObject27239, this.onErrorForAll(methodObject27239, var3));
      }
   }

   public void setShort(int arg0, short arg1) throws SQLException {
      try {
         super.preForAll(methodObject27307, this, arg0, arg1);
         this.delegate.setShort(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject27307, var4);
      }
   }

   public void setBinaryFloat(String arg0, float arg1) throws SQLException {
      try {
         super.preForAll(methodObject27182, this, arg0, arg1);
         this.delegate.setBinaryFloat(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject27182, var4);
      }
   }

   public void setDatabaseChangeRegistration(DatabaseChangeRegistration arg0) throws SQLException {
      try {
         super.preForAll(methodObject27536, this, arg0);
         this.delegate.setDatabaseChangeRegistration(arg0);
      } catch (SQLException var3) {
         this.onErrorVoidForAll(methodObject27536, var3);
      }
   }

   public void setNClob(int arg0, Reader arg1, long arg2) throws SQLException {
      try {
         super.preForAll(methodObject27347, this, arg0, arg1, arg2);
         this.delegate.setNClob(arg0, arg1, arg2);
      } catch (SQLException var6) {
         this.onErrorVoidForAll(methodObject27347, var6);
      }
   }

   public void setClob(String arg0, Reader arg1, long arg2) throws SQLException {
      try {
         super.preForAll(methodObject27282, this, arg0, arg1, arg2);
         this.delegate.setClob(arg0, arg1, arg2);
      } catch (SQLException var6) {
         this.onErrorVoidForAll(methodObject27282, var6);
      }
   }

   public int executeUpdate() throws SQLException {
      try {
         super.preForExecuteUpdate(methodObject27312, this, zeroLengthObjectArray);
         return this.postForExecuteUpdate(methodObject27312, this.delegate.executeUpdate());
      } catch (SQLException var2) {
         return this.postForExecuteUpdate(methodObject27312, (Integer)this.onErrorForAll(methodObject27312, var2));
      }
   }

   public void setNCharacterStream(int arg0, Reader arg1) throws SQLException {
      try {
         super.preForSetStreams(methodObject27323, this, arg0, arg1);
         this.delegate.setNCharacterStream(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject27323, var4);
      }
   }

   public void defineColumnTypeBytes(int arg0, int arg1, int arg2) throws SQLException {
      try {
         super.preForAll(methodObject27528, this, arg0, arg1, arg2);
         this.delegate.defineColumnTypeBytes(arg0, arg1, arg2);
      } catch (SQLException var5) {
         this.onErrorVoidForAll(methodObject27528, var5);
      }
   }

   public void setLong(int arg0, long arg1) throws SQLException {
      try {
         super.preForAll(methodObject27306, this, arg0, arg1);
         this.delegate.setLong(arg0, arg1);
      } catch (SQLException var5) {
         this.onErrorVoidForAll(methodObject27306, var5);
      }
   }

   public void setDate(int arg0, Date arg1, Calendar arg2) throws SQLException {
      try {
         super.preForAll(methodObject27335, this, arg0, arg1, arg2);
         this.delegate.setDate(arg0, arg1, arg2);
      } catch (SQLException var5) {
         this.onErrorVoidForAll(methodObject27335, var5);
      }
   }

   public NClob getNClob(String arg0) throws SQLException {
      try {
         super.preForAll(methodObject27264, this, arg0);
         return (NClob)this.postForAll(methodObject27264, this.proxyFactory.proxyForCreate((Object)this.delegate.getNClob(arg0), this, this.proxyCache, methodObject27264));
      } catch (SQLException var3) {
         return (NClob)this.postForAll(methodObject27264, this.onErrorForAll(methodObject27264, var3));
      }
   }

   public void setTIMESTAMPLTZAtName(String arg0, TIMESTAMPLTZ arg1) throws SQLException {
      try {
         super.preForAll(methodObject27468, this, arg0, arg1);
         this.delegate.setTIMESTAMPLTZAtName(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject27468, var4);
      }
   }

   public void setInternalBytes(int arg0, byte[] arg1, int arg2) throws SQLException {
      try {
         super.preForAll(methodObject27540, this, arg0, arg1, arg2);
         this.delegate.setInternalBytes(arg0, arg1, arg2);
      } catch (SQLException var5) {
         this.onErrorVoidForAll(methodObject27540, var5);
      }
   }

   public void setCLOB(int arg0, CLOB arg1) throws SQLException {
      try {
         super.preForAll(methodObject27505, this, arg0, arg1);
         this.delegate.setCLOB(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject27505, var4);
      }
   }

   public void setByte(String arg0, byte arg1) throws SQLException {
      try {
         super.preForAll(methodObject27115, this, arg0, arg1);
         this.delegate.setByte(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject27115, var4);
      }
   }

   public void setFetchDirection(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject27396, this, arg0);
         this.delegate.setFetchDirection(arg0);
      } catch (SQLException var3) {
         this.onErrorVoidForAll(methodObject27396, var3);
      }
   }

   public void setStringForClob(String arg0, String arg1) throws SQLException {
      try {
         super.preForAll(methodObject27185, this, arg0, arg1);
         this.delegate.setStringForClob(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject27185, var4);
      }
   }

   public void setSTRUCTAtName(String arg0, STRUCT arg1) throws SQLException {
      try {
         super.preForAll(methodObject27441, this, arg0, arg1);
         this.delegate.setSTRUCTAtName(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject27441, var4);
      }
   }

   public void registerOutParameter(String arg0, int arg1) throws SQLException {
      try {
         super.preForAll(methodObject27277, this, arg0, arg1);
         this.delegate.registerOutParameter(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject27277, var4);
      }
   }

   public void setCharacterStream(int arg0, Reader arg1, int arg2) throws SQLException {
      try {
         super.preForSetStreams(methodObject27319, this, arg0, arg1, arg2);
         this.delegate.setCharacterStream(arg0, arg1, arg2);
      } catch (SQLException var5) {
         this.onErrorVoidForAll(methodObject27319, var5);
      }
   }

   public void setBinaryFloat(int arg0, BINARY_FLOAT arg1) throws SQLException {
      try {
         super.preForAll(methodObject27492, this, arg0, arg1);
         this.delegate.setBinaryFloat(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject27492, var4);
      }
   }

   public void setDouble(String arg0, double arg1) throws SQLException {
      try {
         super.preForAll(methodObject27116, this, arg0, arg1);
         this.delegate.setDouble(arg0, arg1);
      } catch (SQLException var5) {
         this.onErrorVoidForAll(methodObject27116, var5);
      }
   }

   public void setBinaryDouble(String arg0, double arg1) throws SQLException {
      try {
         super.preForAll(methodObject27184, this, arg0, arg1);
         this.delegate.setBinaryDouble(arg0, arg1);
      } catch (SQLException var5) {
         this.onErrorVoidForAll(methodObject27184, var5);
      }
   }

   public InputStream getBinaryStream(String arg0) throws SQLException {
      try {
         super.preForAll(methodObject27129, this, arg0);
         return (InputStream)this.postForAll(methodObject27129, (Object)this.delegate.getBinaryStream(arg0));
      } catch (SQLException var3) {
         return (InputStream)this.postForAll(methodObject27129, this.onErrorForAll(methodObject27129, var3));
      }
   }

   public void setBinaryStreamAtName(String arg0, InputStream arg1, int arg2) throws SQLException {
      try {
         super.preForSetStreams(methodObject27403, this, arg0, arg1, arg2);
         this.delegate.setBinaryStreamAtName(arg0, arg1, arg2);
      } catch (SQLException var5) {
         this.onErrorVoidForAll(methodObject27403, var5);
      }
   }

   public Object getACProxy() {
      super.preForAll(methodObject27562, this, zeroLengthObjectArray);
      return this.postForAll(methodObject27562, this.proxyFactory.proxyForCache(this.delegate.getACProxy(), this, this.proxyCache, methodObject27562));
   }

   public void setORADataAtName(String arg0, ORAData arg1) throws SQLException {
      try {
         super.preForAll(methodObject27470, this, arg0, arg1);
         this.delegate.setORADataAtName(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject27470, var4);
      }
   }

   public int getLobPrefetchSize() throws SQLException {
      try {
         super.preForAll(methodObject27532, this, zeroLengthObjectArray);
         return (Integer)this.postForAll(methodObject27532, this.delegate.getLobPrefetchSize());
      } catch (SQLException var2) {
         return (Integer)this.postForAll(methodObject27532, this.onErrorForAll(methodObject27532, var2));
      }
   }

   public void defineParameterTypeChars(int arg0, int arg1, int arg2) throws SQLException {
      try {
         super.preForAll(methodObject27415, this, arg0, arg1, arg2);
         this.delegate.defineParameterTypeChars(arg0, arg1, arg2);
      } catch (SQLException var5) {
         this.onErrorVoidForAll(methodObject27415, var5);
      }
   }

   public SQLXML getSQLXML(String arg0) throws SQLException {
      try {
         super.preForAll(methodObject27268, this, arg0);
         return (SQLXML)this.postForAll(methodObject27268, this.proxyFactory.proxyForCreate((Object)this.delegate.getSQLXML(arg0), this, this.proxyCache, methodObject27268));
      } catch (SQLException var3) {
         return (SQLXML)this.postForAll(methodObject27268, this.onErrorForAll(methodObject27268, var3));
      }
   }

   public ParameterMetaData getParameterMetaData() throws SQLException {
      try {
         super.preForAll(methodObject27331, this, zeroLengthObjectArray);
         return (ParameterMetaData)this.postForAll(methodObject27331, this.proxyFactory.proxyForCreate((Object)this.delegate.getParameterMetaData(), this, this.proxyCache, methodObject27331));
      } catch (SQLException var2) {
         return (ParameterMetaData)this.postForAll(methodObject27331, this.onErrorForAll(methodObject27331, var2));
      }
   }

   public void setArrayAtName(String arg0, Array arg1) throws SQLException {
      try {
         super.preForAll(methodObject27437, this, arg0, arg1);
         this.delegate.setArrayAtName(arg0, arg1 instanceof _Proxy_ ? (Array)((_Proxy_)arg1)._getDelegate_() : arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject27437, var4);
      }
   }

   public void setStringForClob(int arg0, String arg1) throws SQLException {
      try {
         super.preForAll(methodObject27495, this, arg0, arg1);
         this.delegate.setStringForClob(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject27495, var4);
      }
   }

   public void setINTERVALYM(int arg0, INTERVALYM arg1) throws SQLException {
      try {
         super.preForAll(methodObject27508, this, arg0, arg1);
         this.delegate.setINTERVALYM(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject27508, var4);
      }
   }

   public void setAsciiStream(int arg0, InputStream arg1, long arg2) throws SQLException {
      try {
         super.preForSetStreams(methodObject27314, this, arg0, arg1, arg2);
         this.delegate.setAsciiStream(arg0, arg1, arg2);
      } catch (SQLException var6) {
         this.onErrorVoidForAll(methodObject27314, var6);
      }
   }

   public void setNCharacterStreamAtName(String arg0, Reader arg1) throws SQLException {
      try {
         super.preForSetStreams(methodObject27409, this, arg0, arg1);
         this.delegate.setNCharacterStreamAtName(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject27409, var4);
      }
   }

   public int getMaxFieldSize() throws SQLException {
      try {
         super.preForAll(methodObject27378, this, zeroLengthObjectArray);
         return (Integer)this.postForAll(methodObject27378, this.delegate.getMaxFieldSize());
      } catch (SQLException var2) {
         return (Integer)this.postForAll(methodObject27378, this.onErrorForAll(methodObject27378, var2));
      }
   }

   public void setFloat(String arg0, float arg1) throws SQLException {
      try {
         super.preForAll(methodObject27117, this, arg0, arg1);
         this.delegate.setFloat(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject27117, var4);
      }
   }

   public void setInt(int arg0, int arg1) throws SQLException {
      try {
         super.preForAll(methodObject27305, this, arg0, arg1);
         this.delegate.setInt(arg0, arg1);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject27305, var4);
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
         methodObject27357 = Statement.class.getDeclaredMethod("execute", String.class);
         methodObject27164 = oracle.jdbc.OracleCallableStatement.class.getDeclaredMethod("getOPAQUE", Integer.TYPE);
         methodObject27111 = OracleCallableStatement.class.getDeclaredMethod("getBigDecimal", String.class, Integer.TYPE);
         methodObject27146 = oracle.jdbc.OracleCallableStatement.class.getDeclaredMethod("setNull", String.class, Integer.TYPE, String.class);
         methodObject27235 = CallableStatement.class.getDeclaredMethod("getDouble", Integer.TYPE);
         methodObject27172 = oracle.jdbc.OracleCallableStatement.class.getDeclaredMethod("getTIMESTAMPTZ", Integer.TYPE);
         methodObject27541 = OraclePreparedStatement.class.getDeclaredMethod("enterImplicitCache");
         methodObject27366 = Statement.class.getDeclaredMethod("executeUpdate", String.class, int[].class);
         methodObject27303 = PreparedStatement.class.getDeclaredMethod("setDouble", Integer.TYPE, Double.TYPE);
         methodObject27288 = CallableStatement.class.getDeclaredMethod("setRowId", String.class, RowId.class);
         methodObject27350 = PreparedStatement.class.getDeclaredMethod("setNull", Integer.TYPE, Integer.TYPE);
         methodObject27231 = CallableStatement.class.getDeclaredMethod("getLong", Integer.TYPE);
         methodObject27364 = Statement.class.getDeclaredMethod("executeUpdate", String.class);
         methodObject27436 = oracle.jdbc.OraclePreparedStatement.class.getDeclaredMethod("setROWIDAtName", String.class, ROWID.class);
         methodObject27349 = PreparedStatement.class.getDeclaredMethod("setNString", Integer.TYPE, String.class);
         methodObject27249 = CallableStatement.class.getDeclaredMethod("getDate", String.class);
         methodObject27411 = oracle.jdbc.OraclePreparedStatement.class.getDeclaredMethod("setObjectAtName", String.class, Object.class, Integer.TYPE, Integer.TYPE);
         methodObject27333 = PreparedStatement.class.getDeclaredMethod("setTime", Integer.TYPE, Time.class, Calendar.class);
         methodObject27426 = oracle.jdbc.OraclePreparedStatement.class.getDeclaredMethod("setDoubleAtName", String.class, Double.TYPE);
         methodObject27386 = Statement.class.getDeclaredMethod("isCloseOnCompletion");
         methodObject27488 = oracle.jdbc.OraclePreparedStatement.class.getDeclaredMethod("setNStringAtName", String.class, String.class);
         methodObject27513 = oracle.jdbc.OraclePreparedStatement.class.getDeclaredMethod("setARRAY", Integer.TYPE, ARRAY.class);
         methodObject27466 = oracle.jdbc.OraclePreparedStatement.class.getDeclaredMethod("setTIMESTAMPAtName", String.class, TIMESTAMP.class);
         methodObject27273 = CallableStatement.class.getDeclaredMethod("wasNull");
         methodObject27384 = Statement.class.getDeclaredMethod("getResultSetType");
         methodObject27450 = oracle.jdbc.OraclePreparedStatement.class.getDeclaredMethod("setCLOBAtName", String.class, CLOB.class);
         methodObject27560 = OracleStatement.class.getDeclaredMethod("registerBindChecksumListener", OracleStatement.BindChecksumListener.class);
         methodObject27244 = CallableStatement.class.getDeclaredMethod("getRef", String.class);
         methodObject27373 = Statement.class.getDeclaredMethod("getResultSetHoldability");
         methodObject27414 = oracle.jdbc.OraclePreparedStatement.class.getDeclaredMethod("defineParameterTypeBytes", Integer.TYPE, Integer.TYPE, Integer.TYPE);
         methodObject27141 = oracle.jdbc.OracleCallableStatement.class.getDeclaredMethod("registerOutParameter", Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE);
         methodObject27280 = CallableStatement.class.getDeclaredMethod("setBlob", String.class, InputStream.class, Long.TYPE);
         methodObject27444 = oracle.jdbc.OraclePreparedStatement.class.getDeclaredMethod("setDATEAtName", String.class, DATE.class);
         methodObject27372 = Statement.class.getDeclaredMethod("clearWarnings");
         methodObject27186 = oracle.jdbc.OracleCallableStatement.class.getDeclaredMethod("setBytesForBlob", String.class, byte[].class);
         methodObject27501 = oracle.jdbc.OraclePreparedStatement.class.getDeclaredMethod("setCHAR", Integer.TYPE, CHAR.class);
         methodObject27159 = oracle.jdbc.OracleCallableStatement.class.getDeclaredMethod("getCustomDatum", Integer.TYPE, CustomDatumFactory.class);
         methodObject27507 = oracle.jdbc.OraclePreparedStatement.class.getDeclaredMethod("setBfile", Integer.TYPE, BFILE.class);
         methodObject27416 = oracle.jdbc.OraclePreparedStatement.class.getDeclaredMethod("defineParameterType", Integer.TYPE, Integer.TYPE, Integer.TYPE);
         methodObject27217 = CallableStatement.class.getDeclaredMethod("getObject", Integer.TYPE);
         methodObject27517 = oracle.jdbc.OraclePreparedStatement.class.getDeclaredMethod("setCustomDatum", Integer.TYPE, CustomDatum.class);
         methodObject27330 = PreparedStatement.class.getDeclaredMethod("getMetaData");
         methodObject27392 = Statement.class.getDeclaredMethod("setPoolable", Boolean.TYPE);
         methodObject27193 = oracle.jdbc.OracleCallableStatement.class.getDeclaredMethod("setNUMBER", String.class, NUMBER.class);
         methodObject27446 = oracle.jdbc.OraclePreparedStatement.class.getDeclaredMethod("setBLOBAtName", String.class, BLOB.class);
         methodObject27267 = CallableStatement.class.getDeclaredMethod("getSQLXML", Integer.TYPE);
         methodObject27254 = CallableStatement.class.getDeclaredMethod("setBinaryStream", String.class, InputStream.class);
         methodObject27287 = CallableStatement.class.getDeclaredMethod("setNString", String.class, String.class);
         methodObject27228 = CallableStatement.class.getDeclaredMethod("getShort", String.class);
         methodObject27527 = oracle.jdbc.OracleStatement.class.getDeclaredMethod("defineColumnType", Integer.TYPE, Integer.TYPE, String.class);
         methodObject27259 = CallableStatement.class.getDeclaredMethod("getBlob", Integer.TYPE);
         methodObject27377 = Statement.class.getDeclaredMethod("getGeneratedKeys");
         methodObject27123 = oracle.jdbc.OracleCallableStatement.class.getDeclaredMethod("setURL", String.class, URL.class);
         methodObject27222 = CallableStatement.class.getDeclaredMethod("getObject", String.class, Class.class);
         methodObject27360 = Statement.class.getDeclaredMethod("execute", String.class, String[].class);
         methodObject27400 = oracle.jdbc.OraclePreparedStatement.class.getDeclaredMethod("setAsciiStreamAtName", String.class, InputStream.class, Integer.TYPE);
         methodObject27295 = CallableStatement.class.getDeclaredMethod("getNString", Integer.TYPE);
         methodObject27275 = CallableStatement.class.getDeclaredMethod("registerOutParameter", Integer.TYPE, Integer.TYPE, Integer.TYPE);
         methodObject27394 = Statement.class.getDeclaredMethod("getFetchDirection");
         methodObject27502 = oracle.jdbc.OraclePreparedStatement.class.getDeclaredMethod("setDATE", Integer.TYPE, DATE.class);
         methodObject27340 = PreparedStatement.class.getDeclaredMethod("setBlob", Integer.TYPE, Blob.class);
         methodObject27341 = PreparedStatement.class.getDeclaredMethod("setBlob", Integer.TYPE, InputStream.class, Long.TYPE);
         methodObject27555 = OracleStatement.class.getDeclaredMethod("getFixedString");
         methodObject27320 = PreparedStatement.class.getDeclaredMethod("setCharacterStream", Integer.TYPE, Reader.class, Long.TYPE);
         methodObject27552 = OracleStatement.class.getDeclaredMethod("getChecksum");
         methodObject27188 = oracle.jdbc.OracleCallableStatement.class.getDeclaredMethod("setCursor", String.class, ResultSet.class);
         methodObject27477 = oracle.jdbc.OraclePreparedStatement.class.getDeclaredMethod("setPlsqlIndexTable", Integer.TYPE, Object.class, Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE);
         methodObject27212 = oracle.jdbc.OracleCallableStatement.class.getDeclaredMethod("registerOutParameterAtName", String.class, Integer.TYPE);
         methodObject27127 = oracle.jdbc.OracleCallableStatement.class.getDeclaredMethod("setUnicodeStream", String.class, InputStream.class, Integer.TYPE);
         methodObject27493 = oracle.jdbc.OraclePreparedStatement.class.getDeclaredMethod("setBinaryDouble", Integer.TYPE, Double.TYPE);
         methodObject27516 = oracle.jdbc.OraclePreparedStatement.class.getDeclaredMethod("setSTRUCT", Integer.TYPE, STRUCT.class);
         methodObject27224 = CallableStatement.class.getDeclaredMethod("getBoolean", String.class);
         methodObject27122 = oracle.jdbc.OracleCallableStatement.class.getDeclaredMethod("setTimestamp", String.class, Timestamp.class, Calendar.class);
         methodObject27521 = oracle.jdbc.OraclePreparedStatement.class.getDeclaredMethod("setOracleObject", Integer.TYPE, Datum.class);
         methodObject27181 = oracle.jdbc.OracleCallableStatement.class.getDeclaredMethod("setBinaryFloat", String.class, BINARY_FLOAT.class);
         methodObject27342 = PreparedStatement.class.getDeclaredMethod("setBlob", Integer.TYPE, InputStream.class);
         methodObject27523 = oracle.jdbc.OracleStatement.class.getDeclaredMethod("clearDefines");
         methodObject27496 = oracle.jdbc.OraclePreparedStatement.class.getDeclaredMethod("setBytesForBlob", Integer.TYPE, byte[].class);
         methodObject27442 = oracle.jdbc.OraclePreparedStatement.class.getDeclaredMethod("setRAWAtName", String.class, RAW.class);
         methodObject27203 = oracle.jdbc.OracleCallableStatement.class.getDeclaredMethod("setARRAY", String.class, ARRAY.class);
         methodObject27520 = oracle.jdbc.OraclePreparedStatement.class.getDeclaredMethod("setREF", Integer.TYPE, REF.class);
         methodObject27498 = oracle.jdbc.OraclePreparedStatement.class.getDeclaredMethod("setCursor", Integer.TYPE, ResultSet.class);
         methodObject27440 = oracle.jdbc.OraclePreparedStatement.class.getDeclaredMethod("setStructDescriptorAtName", String.class, StructDescriptor.class);
         methodObject27154 = oracle.jdbc.OracleCallableStatement.class.getDeclaredMethod("getBFILE", Integer.TYPE);
         methodObject27296 = CallableStatement.class.getDeclaredMethod("getNString", String.class);
         methodObject27150 = oracle.jdbc.OracleCallableStatement.class.getDeclaredMethod("getUnicodeStream", Integer.TYPE);
         methodObject27326 = PreparedStatement.class.getDeclaredMethod("setObject", Integer.TYPE, Object.class, Integer.TYPE);
         methodObject27514 = oracle.jdbc.OraclePreparedStatement.class.getDeclaredMethod("setOPAQUE", Integer.TYPE, OPAQUE.class);
         methodObject27460 = oracle.jdbc.OraclePreparedStatement.class.getDeclaredMethod("setTimeAtName", String.class, Time.class);
         methodObject27114 = oracle.jdbc.OracleCallableStatement.class.getDeclaredMethod("setBoolean", String.class, Boolean.TYPE);
         methodObject27142 = oracle.jdbc.OracleCallableStatement.class.getDeclaredMethod("registerOutParameter", String.class, Integer.TYPE, Integer.TYPE, Integer.TYPE);
         methodObject27163 = oracle.jdbc.OracleCallableStatement.class.getDeclaredMethod("getNUMBER", Integer.TYPE);
         methodObject27454 = oracle.jdbc.OraclePreparedStatement.class.getDeclaredMethod("setBFILEAtName", String.class, BFILE.class);
         methodObject27361 = Statement.class.getDeclaredMethod("cancel");
         methodObject27191 = oracle.jdbc.OracleCallableStatement.class.getDeclaredMethod("setCHAR", String.class, CHAR.class);
         methodObject27256 = CallableStatement.class.getDeclaredMethod("setCharacterStream", String.class, Reader.class);
         methodObject27393 = Statement.class.getDeclaredMethod("setQueryTimeout", Integer.TYPE);
         methodObject27533 = oracle.jdbc.OracleStatement.class.getDeclaredMethod("setLobPrefetchSize", Integer.TYPE);
         methodObject27534 = oracle.jdbc.OracleStatement.class.getDeclaredMethod("closeWithKey", String.class);
         methodObject27128 = oracle.jdbc.OracleCallableStatement.class.getDeclaredMethod("getBinaryStream", Integer.TYPE);
         methodObject27539 = OraclePreparedStatement.class.getDeclaredMethod("setCharacterStreamAtName", String.class, Reader.class, Integer.TYPE);
         methodObject27152 = oracle.jdbc.OracleCallableStatement.class.getDeclaredMethod("getOracleObject", Integer.TYPE);
         methodObject27132 = oracle.jdbc.OracleCallableStatement.class.getDeclaredMethod("setObject", String.class, Object.class, Integer.TYPE);
         methodObject27149 = oracle.jdbc.OracleCallableStatement.class.getDeclaredMethod("setRef", String.class, Ref.class);
         methodObject27281 = CallableStatement.class.getDeclaredMethod("setBlob", String.class, InputStream.class);
         methodObject27322 = PreparedStatement.class.getDeclaredMethod("setNCharacterStream", Integer.TYPE, Reader.class, Long.TYPE);
         methodObject27512 = oracle.jdbc.OraclePreparedStatement.class.getDeclaredMethod("setTIMESTAMPLTZ", Integer.TYPE, TIMESTAMPLTZ.class);
         methodObject27346 = PreparedStatement.class.getDeclaredMethod("setNClob", Integer.TYPE, NClob.class);
         methodObject27208 = oracle.jdbc.OracleCallableStatement.class.getDeclaredMethod("setORAData", String.class, ORAData.class);
         methodObject27289 = CallableStatement.class.getDeclaredMethod("setSQLXML", String.class, SQLXML.class);
         methodObject27269 = CallableStatement.class.getDeclaredMethod("getTime", Integer.TYPE);
         methodObject27334 = PreparedStatement.class.getDeclaredMethod("setDate", Integer.TYPE, Date.class);
         methodObject27119 = oracle.jdbc.OracleCallableStatement.class.getDeclaredMethod("setLong", String.class, Long.TYPE);
         methodObject27365 = Statement.class.getDeclaredMethod("executeUpdate", String.class, Integer.TYPE);
         methodObject27126 = oracle.jdbc.OracleCallableStatement.class.getDeclaredMethod("setCharacterStream", String.class, Reader.class, Integer.TYPE);
         methodObject27174 = oracle.jdbc.OracleCallableStatement.class.getDeclaredMethod("registerOutParameterBytes", Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE);
         methodObject27183 = oracle.jdbc.OracleCallableStatement.class.getDeclaredMethod("setBinaryDouble", String.class, BINARY_DOUBLE.class);
         methodObject27421 = oracle.jdbc.OraclePreparedStatement.class.getDeclaredMethod("setByteAtName", String.class, Byte.TYPE);
         methodObject27459 = oracle.jdbc.OraclePreparedStatement.class.getDeclaredMethod("setDateAtName", String.class, Date.class, Calendar.class);
         methodObject27290 = CallableStatement.class.getDeclaredMethod("getBigDecimal", Integer.TYPE, Integer.TYPE);
         methodObject27457 = oracle.jdbc.OraclePreparedStatement.class.getDeclaredMethod("setBytesForBlobAtName", String.class, byte[].class);
         methodObject27369 = Statement.class.getDeclaredMethod("executeQuery", String.class);
         methodObject27304 = PreparedStatement.class.getDeclaredMethod("setFloat", Integer.TYPE, Float.TYPE);
         methodObject27489 = oracle.jdbc.OraclePreparedStatement.class.getDeclaredMethod("setRowIdAtName", String.class, RowId.class);
         methodObject27274 = CallableStatement.class.getDeclaredMethod("registerOutParameter", Integer.TYPE, Integer.TYPE);
         methodObject27506 = oracle.jdbc.OraclePreparedStatement.class.getDeclaredMethod("setBFILE", Integer.TYPE, BFILE.class);
         methodObject27353 = PreparedStatement.class.getDeclaredMethod("setSQLXML", Integer.TYPE, SQLXML.class);
         methodObject27471 = oracle.jdbc.OraclePreparedStatement.class.getDeclaredMethod("setRefTypeAtName", String.class, REF.class);
         methodObject27515 = oracle.jdbc.OraclePreparedStatement.class.getDeclaredMethod("setStructDescriptor", Integer.TYPE, StructDescriptor.class);
         methodObject27379 = Statement.class.getDeclaredMethod("getMaxRows");
         methodObject27337 = PreparedStatement.class.getDeclaredMethod("addBatch");
         methodObject27243 = CallableStatement.class.getDeclaredMethod("getRef", Integer.TYPE);
         methodObject27177 = oracle.jdbc.OracleCallableStatement.class.getDeclaredMethod("getPlsqlIndexTable", Integer.TYPE);
         methodObject27247 = CallableStatement.class.getDeclaredMethod("getDate", Integer.TYPE);
         methodObject27479 = oracle.jdbc.OraclePreparedStatement.class.getDeclaredMethod("setDisableStmtCaching", Boolean.TYPE);
         methodObject27382 = Statement.class.getDeclaredMethod("getQueryTimeout");
         methodObject27559 = OracleStatement.class.getDeclaredMethod("getstatementType");
         methodObject27310 = PreparedStatement.class.getDeclaredMethod("setURL", Integer.TYPE, URL.class);
         methodObject27348 = PreparedStatement.class.getDeclaredMethod("setNClob", Integer.TYPE, Reader.class);
         methodObject27433 = oracle.jdbc.OraclePreparedStatement.class.getDeclaredMethod("setStringForClobAtName", String.class, String.class);
         methodObject27339 = PreparedStatement.class.getDeclaredMethod("setBigDecimal", Integer.TYPE, BigDecimal.class);
         methodObject27351 = PreparedStatement.class.getDeclaredMethod("setNull", Integer.TYPE, Integer.TYPE, String.class);
         methodObject27248 = CallableStatement.class.getDeclaredMethod("getDate", Integer.TYPE, Calendar.class);
         methodObject27286 = CallableStatement.class.getDeclaredMethod("setNClob", String.class, Reader.class);
         methodObject27166 = oracle.jdbc.OracleCallableStatement.class.getDeclaredMethod("getREF", Integer.TYPE);
         methodObject27546 = OraclePreparedStatement.class.getDeclaredMethod("exitExplicitCacheToClose");
         methodObject27420 = oracle.jdbc.OraclePreparedStatement.class.getDeclaredMethod("setBooleanAtName", String.class, Boolean.TYPE);
         methodObject27197 = oracle.jdbc.OracleCallableStatement.class.getDeclaredMethod("setBfile", String.class, BFILE.class);
         methodObject27240 = CallableStatement.class.getDeclaredMethod("getArray", String.class);
         methodObject27483 = oracle.jdbc.OraclePreparedStatement.class.getDeclaredMethod("registerReturnParameter", Integer.TYPE, Integer.TYPE, String.class);
         methodObject27137 = oracle.jdbc.OracleCallableStatement.class.getDeclaredMethod("setDate", String.class, Date.class, Calendar.class);
         methodObject27548 = OraclePreparedStatement.class.getDeclaredMethod("setCheckBindTypes", Boolean.TYPE);
         methodObject27225 = CallableStatement.class.getDeclaredMethod("getByte", Integer.TYPE);
         methodObject27216 = oracle.jdbc.OracleCallableStatement.class.getDeclaredMethod("getARRAY", Integer.TYPE);
         methodObject27196 = oracle.jdbc.OracleCallableStatement.class.getDeclaredMethod("setBFILE", String.class, BFILE.class);
         methodObject27155 = oracle.jdbc.OracleCallableStatement.class.getDeclaredMethod("getBfile", Integer.TYPE);
         methodObject27535 = oracle.jdbc.OracleStatement.class.getDeclaredMethod("creationState");
         methodObject27261 = CallableStatement.class.getDeclaredMethod("getClob", Integer.TYPE);
         methodObject27209 = oracle.jdbc.OracleCallableStatement.class.getDeclaredMethod("setRefType", String.class, REF.class);
         methodObject27449 = oracle.jdbc.OraclePreparedStatement.class.getDeclaredMethod("setBlobAtName", String.class, InputStream.class);
         methodObject27236 = CallableStatement.class.getDeclaredMethod("getDouble", String.class);
         methodObject27221 = CallableStatement.class.getDeclaredMethod("getObject", Integer.TYPE, Class.class);
         methodObject27503 = oracle.jdbc.OraclePreparedStatement.class.getDeclaredMethod("setNUMBER", Integer.TYPE, NUMBER.class);
         methodObject27298 = CallableStatement.class.getDeclaredMethod("getTimestamp", Integer.TYPE, Calendar.class);
         methodObject27214 = oracle.jdbc.OracleCallableStatement.class.getDeclaredMethod("registerOutParameterAtName", String.class, Integer.TYPE, String.class);
         methodObject27138 = oracle.jdbc.OracleCallableStatement.class.getDeclaredMethod("getAsciiStream", Integer.TYPE);
         methodObject27124 = oracle.jdbc.OracleCallableStatement.class.getDeclaredMethod("setAsciiStream", String.class, InputStream.class, Integer.TYPE);
         methodObject27474 = oracle.jdbc.OraclePreparedStatement.class.getDeclaredMethod("setOracleObjectAtName", String.class, Datum.class);
         methodObject27431 = oracle.jdbc.OraclePreparedStatement.class.getDeclaredMethod("setBigDecimalAtName", String.class, BigDecimal.class);
         methodObject27190 = oracle.jdbc.OracleCallableStatement.class.getDeclaredMethod("setRAW", String.class, RAW.class);
         methodObject27545 = OraclePreparedStatement.class.getDeclaredMethod("exitImplicitCacheToClose");
         methodObject27226 = CallableStatement.class.getDeclaredMethod("getByte", String.class);
         methodObject27405 = oracle.jdbc.OraclePreparedStatement.class.getDeclaredMethod("setBinaryStreamAtName", String.class, InputStream.class);
         methodObject27473 = oracle.jdbc.OraclePreparedStatement.class.getDeclaredMethod("setREFAtName", String.class, REF.class);
         methodObject27551 = OracleStatement.class.getDeclaredMethod("getSqlKind");
         methodObject27375 = Statement.class.getDeclaredMethod("clearBatch");
         methodObject27381 = Statement.class.getDeclaredMethod("getMoreResults", Integer.TYPE);
         methodObject27299 = CallableStatement.class.getDeclaredMethod("getTimestamp", String.class);
         methodObject27354 = PreparedStatement.class.getDeclaredMethod("setArray", Integer.TYPE, Array.class);
         methodObject27168 = oracle.jdbc.OracleCallableStatement.class.getDeclaredMethod("getSTRUCT", Integer.TYPE);
         methodObject27313 = PreparedStatement.class.getDeclaredMethod("setAsciiStream", Integer.TYPE, InputStream.class, Integer.TYPE);
         methodObject27529 = oracle.jdbc.OracleStatement.class.getDeclaredMethod("defineColumnTypeChars", Integer.TYPE, Integer.TYPE, Integer.TYPE);
         methodObject27262 = CallableStatement.class.getDeclaredMethod("getClob", String.class);
         methodObject27173 = oracle.jdbc.OracleCallableStatement.class.getDeclaredMethod("getTIMESTAMPLTZ", Integer.TYPE);
         methodObject27332 = PreparedStatement.class.getDeclaredMethod("setTime", Integer.TYPE, Time.class);
         methodObject27210 = oracle.jdbc.OracleCallableStatement.class.getDeclaredMethod("setREF", String.class, REF.class);
         methodObject27180 = oracle.jdbc.OracleCallableStatement.class.getDeclaredMethod("registerIndexTableOutParameter", Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE);
         methodObject27234 = CallableStatement.class.getDeclaredMethod("getFloat", String.class);
         methodObject27558 = OracleStatement.class.getDeclaredMethod("getcacheState");
         methodObject27451 = oracle.jdbc.OraclePreparedStatement.class.getDeclaredMethod("setClobAtName", String.class, Clob.class);
         methodObject27207 = oracle.jdbc.OracleCallableStatement.class.getDeclaredMethod("setCustomDatum", String.class, CustomDatum.class);
         methodObject27397 = Statement.class.getDeclaredMethod("setFetchSize", Integer.TYPE);
         methodObject27395 = Statement.class.getDeclaredMethod("getFetchSize");
         methodObject27388 = Statement.class.getDeclaredMethod("setCursorName", String.class);
         methodObject27325 = PreparedStatement.class.getDeclaredMethod("setBytes", Integer.TYPE, byte[].class);
         methodObject27547 = OraclePreparedStatement.class.getDeclaredMethod("getOriginalSql");
         methodObject27134 = oracle.jdbc.OracleCallableStatement.class.getDeclaredMethod("setTime", String.class, Time.class);
         methodObject27316 = PreparedStatement.class.getDeclaredMethod("setBinaryStream", Integer.TYPE, InputStream.class, Integer.TYPE);
         methodObject27537 = oracle.jdbc.OracleStatement.class.getDeclaredMethod("getRegisteredTableNames");
         methodObject27255 = CallableStatement.class.getDeclaredMethod("setCharacterStream", String.class, Reader.class, Long.TYPE);
         methodObject27338 = PreparedStatement.class.getDeclaredMethod("clearParameters");
         methodObject27220 = CallableStatement.class.getDeclaredMethod("getObject", String.class, Map.class);
         methodObject27399 = Wrapper.class.getDeclaredMethod("isWrapperFor", Class.class);
         methodObject27199 = oracle.jdbc.OracleCallableStatement.class.getDeclaredMethod("setINTERVALDS", String.class, INTERVALDS.class);
         methodObject27438 = oracle.jdbc.OraclePreparedStatement.class.getDeclaredMethod("setARRAYAtName", String.class, ARRAY.class);
         methodObject27144 = oracle.jdbc.OracleCallableStatement.class.getDeclaredMethod("setBlob", String.class, Blob.class);
         methodObject27311 = PreparedStatement.class.getDeclaredMethod("execute");
         methodObject27407 = oracle.jdbc.OraclePreparedStatement.class.getDeclaredMethod("setCharacterStreamAtName", String.class, Reader.class);
         methodObject27139 = oracle.jdbc.OracleCallableStatement.class.getDeclaredMethod("getCharacterStream", Integer.TYPE);
         methodObject27112 = OracleCallableStatement.class.getDeclaredMethod("privateGetBytes", Integer.TYPE);
         methodObject27266 = CallableStatement.class.getDeclaredMethod("getRowId", String.class);
         methodObject27469 = oracle.jdbc.OraclePreparedStatement.class.getDeclaredMethod("setCustomDatumAtName", String.class, CustomDatum.class);
         methodObject27283 = CallableStatement.class.getDeclaredMethod("setClob", String.class, Reader.class);
         methodObject27276 = CallableStatement.class.getDeclaredMethod("registerOutParameter", Integer.TYPE, Integer.TYPE, String.class);
         methodObject27475 = oracle.jdbc.OraclePreparedStatement.class.getDeclaredMethod("setURLAtName", String.class, URL.class);
         methodObject27253 = CallableStatement.class.getDeclaredMethod("setBinaryStream", String.class, InputStream.class, Long.TYPE);
         methodObject27179 = oracle.jdbc.OracleCallableStatement.class.getDeclaredMethod("getOraclePlsqlIndexTable", Integer.TYPE);
         methodObject27279 = CallableStatement.class.getDeclaredMethod("registerOutParameter", String.class, Integer.TYPE, String.class);
         methodObject27406 = oracle.jdbc.OraclePreparedStatement.class.getDeclaredMethod("setCharacterStreamAtName", String.class, Reader.class, Long.TYPE);
         methodObject27229 = CallableStatement.class.getDeclaredMethod("getInt", Integer.TYPE);
         methodObject27443 = oracle.jdbc.OraclePreparedStatement.class.getDeclaredMethod("setCHARAtName", String.class, CHAR.class);
         methodObject27272 = CallableStatement.class.getDeclaredMethod("getTime", String.class, Calendar.class);
         methodObject27151 = oracle.jdbc.OracleCallableStatement.class.getDeclaredMethod("getUnicodeStream", String.class);
         methodObject27417 = oracle.jdbc.OraclePreparedStatement.class.getDeclaredMethod("getExecuteBatch");
         methodObject27445 = oracle.jdbc.OraclePreparedStatement.class.getDeclaredMethod("setNUMBERAtName", String.class, NUMBER.class);
         methodObject27509 = oracle.jdbc.OraclePreparedStatement.class.getDeclaredMethod("setINTERVALDS", Integer.TYPE, INTERVALDS.class);
         methodObject27486 = oracle.jdbc.OraclePreparedStatement.class.getDeclaredMethod("setNClobAtName", String.class, Reader.class, Long.TYPE);
         methodObject27439 = oracle.jdbc.OraclePreparedStatement.class.getDeclaredMethod("setOPAQUEAtName", String.class, OPAQUE.class);
         methodObject27352 = PreparedStatement.class.getDeclaredMethod("setRowId", Integer.TYPE, RowId.class);
         methodObject27557 = OracleStatement.class.getDeclaredMethod("getserverCursor");
         methodObject27511 = oracle.jdbc.OraclePreparedStatement.class.getDeclaredMethod("setTIMESTAMPTZ", Integer.TYPE, TIMESTAMPTZ.class);
         methodObject27178 = oracle.jdbc.OracleCallableStatement.class.getDeclaredMethod("getPlsqlIndexTable", Integer.TYPE, Class.class);
         methodObject27133 = oracle.jdbc.OracleCallableStatement.class.getDeclaredMethod("setObject", String.class, Object.class);
         methodObject27518 = oracle.jdbc.OraclePreparedStatement.class.getDeclaredMethod("setORAData", Integer.TYPE, ORAData.class);
         methodObject27485 = oracle.jdbc.OraclePreparedStatement.class.getDeclaredMethod("setNClobAtName", String.class, NClob.class);
         methodObject27302 = PreparedStatement.class.getDeclaredMethod("setByte", Integer.TYPE, Byte.TYPE);
         methodObject27113 = oracle.jdbc.OracleCallableStatement.class.getDeclaredMethod("getObject", Integer.TYPE, OracleDataFactory.class);
         methodObject27408 = oracle.jdbc.OraclePreparedStatement.class.getDeclaredMethod("setNCharacterStreamAtName", String.class, Reader.class, Long.TYPE);
         methodObject27246 = CallableStatement.class.getDeclaredMethod("getString", String.class);
         methodObject27531 = oracle.jdbc.OracleStatement.class.getDeclaredMethod("setRowPrefetch", Integer.TYPE);
         methodObject27308 = PreparedStatement.class.getDeclaredMethod("setTimestamp", Integer.TYPE, Timestamp.class);
         methodObject27387 = Statement.class.getDeclaredMethod("isPoolable");
         methodObject27524 = oracle.jdbc.OracleStatement.class.getDeclaredMethod("defineColumnType", Integer.TYPE, Integer.TYPE);
         methodObject27201 = oracle.jdbc.OracleCallableStatement.class.getDeclaredMethod("setTIMESTAMPTZ", String.class, TIMESTAMPTZ.class);
         methodObject27324 = PreparedStatement.class.getDeclaredMethod("setUnicodeStream", Integer.TYPE, InputStream.class, Integer.TYPE);
         methodObject27238 = CallableStatement.class.getDeclaredMethod("getBytes", String.class);
         methodObject27385 = Statement.class.getDeclaredMethod("getUpdateCount");
         methodObject27328 = PreparedStatement.class.getDeclaredMethod("setObject", Integer.TYPE, Object.class, Integer.TYPE, Integer.TYPE);
         methodObject27245 = CallableStatement.class.getDeclaredMethod("getString", Integer.TYPE);
         methodObject27390 = Statement.class.getDeclaredMethod("setMaxFieldSize", Integer.TYPE);
         methodObject27401 = oracle.jdbc.OraclePreparedStatement.class.getDeclaredMethod("setAsciiStreamAtName", String.class, InputStream.class, Long.TYPE);
         methodObject27318 = PreparedStatement.class.getDeclaredMethod("setBinaryStream", Integer.TYPE, InputStream.class);
         methodObject27402 = oracle.jdbc.OraclePreparedStatement.class.getDeclaredMethod("setAsciiStreamAtName", String.class, InputStream.class);
         methodObject27363 = Statement.class.getDeclaredMethod("executeBatch");
         methodObject27258 = CallableStatement.class.getDeclaredMethod("setNCharacterStream", String.class, Reader.class);
         methodObject27389 = Statement.class.getDeclaredMethod("setEscapeProcessing", Boolean.TYPE);
         methodObject27422 = oracle.jdbc.OraclePreparedStatement.class.getDeclaredMethod("setShortAtName", String.class, Short.TYPE);
         methodObject27343 = PreparedStatement.class.getDeclaredMethod("setClob", Integer.TYPE, Clob.class);
         methodObject27494 = oracle.jdbc.OraclePreparedStatement.class.getDeclaredMethod("setBinaryDouble", Integer.TYPE, BINARY_DOUBLE.class);
         methodObject27270 = CallableStatement.class.getDeclaredMethod("getTime", Integer.TYPE, Calendar.class);
         methodObject27148 = oracle.jdbc.OracleCallableStatement.class.getDeclaredMethod("setArray", String.class, Array.class);
         methodObject27257 = CallableStatement.class.getDeclaredMethod("setNCharacterStream", String.class, Reader.class, Long.TYPE);
         methodObject27480 = oracle.jdbc.OraclePreparedStatement.class.getDeclaredMethod("OracleGetParameterMetaData");
         methodObject27233 = CallableStatement.class.getDeclaredMethod("getFloat", Integer.TYPE);
         methodObject27200 = oracle.jdbc.OracleCallableStatement.class.getDeclaredMethod("setTIMESTAMP", String.class, TIMESTAMP.class);
         methodObject27120 = oracle.jdbc.OracleCallableStatement.class.getDeclaredMethod("setShort", String.class, Short.TYPE);
         methodObject27171 = oracle.jdbc.OracleCallableStatement.class.getDeclaredMethod("getTIMESTAMP", Integer.TYPE);
         methodObject27490 = oracle.jdbc.OraclePreparedStatement.class.getDeclaredMethod("setSQLXMLAtName", String.class, SQLXML.class);
         methodObject27170 = oracle.jdbc.OracleCallableStatement.class.getDeclaredMethod("getINTERVALDS", Integer.TYPE);
         methodObject27368 = Statement.class.getDeclaredMethod("isClosed");
         methodObject27462 = oracle.jdbc.OraclePreparedStatement.class.getDeclaredMethod("setTimestampAtName", String.class, Timestamp.class);
         methodObject27556 = OracleStatement.class.getDeclaredMethod("sendBatch");
         methodObject27293 = CallableStatement.class.getDeclaredMethod("getNCharacterStream", Integer.TYPE);
         methodObject27211 = oracle.jdbc.OracleCallableStatement.class.getDeclaredMethod("setOracleObject", String.class, Datum.class);
         methodObject27321 = PreparedStatement.class.getDeclaredMethod("setCharacterStream", Integer.TYPE, Reader.class);
         methodObject27530 = oracle.jdbc.OracleStatement.class.getDeclaredMethod("getRowPrefetch");
         methodObject27109 = OracleCallableStatement.class.getDeclaredMethod("getAsciiStream", String.class);
         methodObject27344 = PreparedStatement.class.getDeclaredMethod("setClob", Integer.TYPE, Reader.class, Long.TYPE);
         methodObject27195 = oracle.jdbc.OracleCallableStatement.class.getDeclaredMethod("setCLOB", String.class, CLOB.class);
         methodObject27376 = Statement.class.getDeclaredMethod("closeOnCompletion");
         methodObject27427 = oracle.jdbc.OraclePreparedStatement.class.getDeclaredMethod("setBinaryFloatAtName", String.class, Float.TYPE);
         methodObject27265 = CallableStatement.class.getDeclaredMethod("getRowId", Integer.TYPE);
         methodObject27242 = CallableStatement.class.getDeclaredMethod("getURL", String.class);
         methodObject27294 = CallableStatement.class.getDeclaredMethod("getNCharacterStream", String.class);
         methodObject27430 = oracle.jdbc.OraclePreparedStatement.class.getDeclaredMethod("setBinaryDoubleAtName", String.class, BINARY_DOUBLE.class);
         methodObject27561 = ACProxyable.class.getDeclaredMethod("setACProxy", Object.class);
         methodObject27424 = oracle.jdbc.OraclePreparedStatement.class.getDeclaredMethod("setLongAtName", String.class, Long.TYPE);
         methodObject27301 = PreparedStatement.class.getDeclaredMethod("setBoolean", Integer.TYPE, Boolean.TYPE);
         methodObject27452 = oracle.jdbc.OraclePreparedStatement.class.getDeclaredMethod("setClobAtName", String.class, Reader.class, Long.TYPE);
         methodObject27432 = oracle.jdbc.OraclePreparedStatement.class.getDeclaredMethod("setStringAtName", String.class, String.class);
         methodObject27292 = CallableStatement.class.getDeclaredMethod("getBigDecimal", String.class);
         methodObject27429 = oracle.jdbc.OraclePreparedStatement.class.getDeclaredMethod("setBinaryDoubleAtName", String.class, Double.TYPE);
         methodObject27252 = CallableStatement.class.getDeclaredMethod("setAsciiStream", String.class, InputStream.class);
         methodObject27413 = oracle.jdbc.OraclePreparedStatement.class.getDeclaredMethod("setObjectAtName", String.class, Object.class);
         methodObject27412 = oracle.jdbc.OraclePreparedStatement.class.getDeclaredMethod("setObjectAtName", String.class, Object.class, Integer.TYPE);
         methodObject27271 = CallableStatement.class.getDeclaredMethod("getTime", String.class);
         methodObject27519 = oracle.jdbc.OraclePreparedStatement.class.getDeclaredMethod("setRefType", Integer.TYPE, REF.class);
         methodObject27175 = oracle.jdbc.OracleCallableStatement.class.getDeclaredMethod("registerOutParameterChars", Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE);
         methodObject27204 = oracle.jdbc.OracleCallableStatement.class.getDeclaredMethod("setOPAQUE", String.class, OPAQUE.class);
         methodObject27404 = oracle.jdbc.OraclePreparedStatement.class.getDeclaredMethod("setBinaryStreamAtName", String.class, InputStream.class, Long.TYPE);
         methodObject27500 = oracle.jdbc.OraclePreparedStatement.class.getDeclaredMethod("setRAW", Integer.TYPE, RAW.class);
         methodObject27189 = oracle.jdbc.OracleCallableStatement.class.getDeclaredMethod("setROWID", String.class, ROWID.class);
         methodObject27472 = oracle.jdbc.OraclePreparedStatement.class.getDeclaredMethod("setRefAtName", String.class, Ref.class);
         methodObject27297 = CallableStatement.class.getDeclaredMethod("getTimestamp", Integer.TYPE);
         methodObject27136 = oracle.jdbc.OracleCallableStatement.class.getDeclaredMethod("setDate", String.class, Date.class);
         methodObject27484 = oracle.jdbc.OraclePreparedStatement.class.getDeclaredMethod("getReturnResultSet");
         methodObject27250 = CallableStatement.class.getDeclaredMethod("getDate", String.class, Calendar.class);
         methodObject27237 = CallableStatement.class.getDeclaredMethod("getBytes", Integer.TYPE);
         methodObject27456 = oracle.jdbc.OraclePreparedStatement.class.getDeclaredMethod("setBytesAtName", String.class, byte[].class);
         methodObject27464 = oracle.jdbc.OraclePreparedStatement.class.getDeclaredMethod("setINTERVALYMAtName", String.class, INTERVALYM.class);
         methodObject27423 = oracle.jdbc.OraclePreparedStatement.class.getDeclaredMethod("setIntAtName", String.class, Integer.TYPE);
         methodObject27131 = oracle.jdbc.OracleCallableStatement.class.getDeclaredMethod("setObject", String.class, Object.class, Integer.TYPE, Integer.TYPE);
         methodObject27125 = oracle.jdbc.OracleCallableStatement.class.getDeclaredMethod("setBinaryStream", String.class, InputStream.class, Integer.TYPE);
         methodObject27491 = oracle.jdbc.OraclePreparedStatement.class.getDeclaredMethod("setBinaryFloat", Integer.TYPE, Float.TYPE);
         methodObject27206 = oracle.jdbc.OracleCallableStatement.class.getDeclaredMethod("setSTRUCT", String.class, STRUCT.class);
         methodObject27285 = CallableStatement.class.getDeclaredMethod("setNClob", String.class, Reader.class, Long.TYPE);
         methodObject27315 = PreparedStatement.class.getDeclaredMethod("setAsciiStream", Integer.TYPE, InputStream.class);
         methodObject27169 = oracle.jdbc.OracleCallableStatement.class.getDeclaredMethod("getINTERVALYM", Integer.TYPE);
         methodObject27419 = oracle.jdbc.OraclePreparedStatement.class.getDeclaredMethod("setNullAtName", String.class, Integer.TYPE);
         methodObject27374 = Statement.class.getDeclaredMethod("addBatch", String.class);
         methodObject27398 = Wrapper.class.getDeclaredMethod("unwrap", Class.class);
         methodObject27278 = CallableStatement.class.getDeclaredMethod("registerOutParameter", String.class, Integer.TYPE, Integer.TYPE);
         methodObject27383 = Statement.class.getDeclaredMethod("getResultSetConcurrency");
         methodObject27160 = oracle.jdbc.OracleCallableStatement.class.getDeclaredMethod("getORAData", Integer.TYPE, ORADataFactory.class);
         methodObject27482 = oracle.jdbc.OraclePreparedStatement.class.getDeclaredMethod("registerReturnParameter", Integer.TYPE, Integer.TYPE, Integer.TYPE);
         methodObject27463 = oracle.jdbc.OraclePreparedStatement.class.getDeclaredMethod("setTimestampAtName", String.class, Timestamp.class, Calendar.class);
         methodObject27447 = oracle.jdbc.OraclePreparedStatement.class.getDeclaredMethod("setBlobAtName", String.class, Blob.class);
         methodObject27544 = OraclePreparedStatement.class.getDeclaredMethod("exitExplicitCacheToActive");
         methodObject27542 = OraclePreparedStatement.class.getDeclaredMethod("enterExplicitCache");
         methodObject27327 = PreparedStatement.class.getDeclaredMethod("setObject", Integer.TYPE, Object.class);
         methodObject27481 = oracle.jdbc.OraclePreparedStatement.class.getDeclaredMethod("registerReturnParameter", Integer.TYPE, Integer.TYPE);
         methodObject27418 = oracle.jdbc.OraclePreparedStatement.class.getDeclaredMethod("setNullAtName", String.class, Integer.TYPE, String.class);
         methodObject27230 = CallableStatement.class.getDeclaredMethod("getInt", String.class);
         methodObject27554 = OracleStatement.class.getDeclaredMethod("setFixedString", Boolean.TYPE);
         methodObject27355 = PreparedStatement.class.getDeclaredMethod("setRef", Integer.TYPE, Ref.class);
         methodObject27549 = oracle.jdbc.OraclePreparedStatement.class.getDeclaredMethod("setExecuteBatch", Integer.TYPE);
         methodObject27428 = oracle.jdbc.OraclePreparedStatement.class.getDeclaredMethod("setBinaryFloatAtName", String.class, BINARY_FLOAT.class);
         methodObject27362 = Statement.class.getDeclaredMethod("getResultSet");
         methodObject27187 = oracle.jdbc.OracleCallableStatement.class.getDeclaredMethod("setFixedCHAR", String.class, String.class);
         methodObject27526 = oracle.jdbc.OracleStatement.class.getDeclaredMethod("defineColumnType", Integer.TYPE, Integer.TYPE, Integer.TYPE, Short.TYPE);
         methodObject27455 = oracle.jdbc.OraclePreparedStatement.class.getDeclaredMethod("setBfileAtName", String.class, BFILE.class);
         methodObject27467 = oracle.jdbc.OraclePreparedStatement.class.getDeclaredMethod("setTIMESTAMPTZAtName", String.class, TIMESTAMPTZ.class);
         methodObject27156 = oracle.jdbc.OracleCallableStatement.class.getDeclaredMethod("getBLOB", Integer.TYPE);
         methodObject27525 = oracle.jdbc.OracleStatement.class.getDeclaredMethod("defineColumnType", Integer.TYPE, Integer.TYPE, Integer.TYPE);
         methodObject27157 = oracle.jdbc.OracleCallableStatement.class.getDeclaredMethod("getCHAR", Integer.TYPE);
         methodObject27538 = oracle.jdbc.OracleStatement.class.getDeclaredMethod("getRegisteredQueryId");
         methodObject27458 = oracle.jdbc.OraclePreparedStatement.class.getDeclaredMethod("setDateAtName", String.class, Date.class);
         methodObject27202 = oracle.jdbc.OracleCallableStatement.class.getDeclaredMethod("setTIMESTAMPLTZ", String.class, TIMESTAMPLTZ.class);
         methodObject27497 = oracle.jdbc.OraclePreparedStatement.class.getDeclaredMethod("setFixedCHAR", Integer.TYPE, String.class);
         methodObject27553 = OracleStatement.class.getDeclaredMethod("setSnapshotSCN", Long.TYPE);
         methodObject27359 = Statement.class.getDeclaredMethod("execute", String.class, int[].class);
         methodObject27465 = oracle.jdbc.OraclePreparedStatement.class.getDeclaredMethod("setINTERVALDSAtName", String.class, INTERVALDS.class);
         methodObject27143 = oracle.jdbc.OracleCallableStatement.class.getDeclaredMethod("setBigDecimal", String.class, BigDecimal.class);
         methodObject27219 = CallableStatement.class.getDeclaredMethod("getObject", String.class);
         methodObject27380 = Statement.class.getDeclaredMethod("getMoreResults");
         methodObject27223 = CallableStatement.class.getDeclaredMethod("getBoolean", Integer.TYPE);
         methodObject27291 = CallableStatement.class.getDeclaredMethod("getBigDecimal", Integer.TYPE);
         methodObject27435 = oracle.jdbc.OraclePreparedStatement.class.getDeclaredMethod("setCursorAtName", String.class, ResultSet.class);
         methodObject27410 = oracle.jdbc.OraclePreparedStatement.class.getDeclaredMethod("setUnicodeStreamAtName", String.class, InputStream.class, Integer.TYPE);
         methodObject27198 = oracle.jdbc.OracleCallableStatement.class.getDeclaredMethod("setINTERVALYM", String.class, INTERVALYM.class);
         methodObject27336 = PreparedStatement.class.getDeclaredMethod("setString", Integer.TYPE, String.class);
         methodObject27227 = CallableStatement.class.getDeclaredMethod("getShort", Integer.TYPE);
         methodObject27121 = oracle.jdbc.OracleCallableStatement.class.getDeclaredMethod("setTimestamp", String.class, Timestamp.class);
         methodObject27367 = Statement.class.getDeclaredMethod("executeUpdate", String.class, String[].class);
         methodObject27145 = oracle.jdbc.OracleCallableStatement.class.getDeclaredMethod("setClob", String.class, Clob.class);
         methodObject27147 = oracle.jdbc.OracleCallableStatement.class.getDeclaredMethod("setNull", String.class, Integer.TYPE);
         methodObject27504 = oracle.jdbc.OraclePreparedStatement.class.getDeclaredMethod("setBLOB", Integer.TYPE, BLOB.class);
         methodObject27543 = OraclePreparedStatement.class.getDeclaredMethod("exitImplicitCacheToActive");
         methodObject27358 = Statement.class.getDeclaredMethod("execute", String.class, Integer.TYPE);
         methodObject27487 = oracle.jdbc.OraclePreparedStatement.class.getDeclaredMethod("setNClobAtName", String.class, Reader.class);
         methodObject27260 = CallableStatement.class.getDeclaredMethod("getBlob", String.class);
         methodObject27140 = oracle.jdbc.OracleCallableStatement.class.getDeclaredMethod("setString", String.class, String.class);
         methodObject27218 = CallableStatement.class.getDeclaredMethod("getObject", Integer.TYPE, Map.class);
         methodObject27345 = PreparedStatement.class.getDeclaredMethod("setClob", Integer.TYPE, Reader.class);
         methodObject27329 = PreparedStatement.class.getDeclaredMethod("executeQuery");
         methodObject27251 = CallableStatement.class.getDeclaredMethod("setAsciiStream", String.class, InputStream.class, Long.TYPE);
         methodObject27161 = oracle.jdbc.OracleCallableStatement.class.getDeclaredMethod("getAnyDataEmbeddedObject", Integer.TYPE);
         methodObject27241 = CallableStatement.class.getDeclaredMethod("getURL", Integer.TYPE);
         methodObject27434 = oracle.jdbc.OraclePreparedStatement.class.getDeclaredMethod("setFixedCHARAtName", String.class, String.class);
         methodObject27499 = oracle.jdbc.OraclePreparedStatement.class.getDeclaredMethod("setROWID", Integer.TYPE, ROWID.class);
         methodObject27284 = CallableStatement.class.getDeclaredMethod("setNClob", String.class, NClob.class);
         methodObject27371 = Statement.class.getDeclaredMethod("getWarnings");
         methodObject27510 = oracle.jdbc.OraclePreparedStatement.class.getDeclaredMethod("setTIMESTAMP", Integer.TYPE, TIMESTAMP.class);
         methodObject27110 = OracleCallableStatement.class.getDeclaredMethod("getCharacterStream", String.class);
         methodObject27162 = oracle.jdbc.OracleCallableStatement.class.getDeclaredMethod("getDATE", Integer.TYPE);
         methodObject27158 = oracle.jdbc.OracleCallableStatement.class.getDeclaredMethod("getCLOB", Integer.TYPE);
         methodObject27205 = oracle.jdbc.OracleCallableStatement.class.getDeclaredMethod("setStructDescriptor", String.class, StructDescriptor.class);
         methodObject27370 = Statement.class.getDeclaredMethod("getConnection");
         methodObject27453 = oracle.jdbc.OraclePreparedStatement.class.getDeclaredMethod("setClobAtName", String.class, Reader.class);
         methodObject27192 = oracle.jdbc.OracleCallableStatement.class.getDeclaredMethod("setDATE", String.class, DATE.class);
         methodObject27300 = CallableStatement.class.getDeclaredMethod("getTimestamp", String.class, Calendar.class);
         methodObject27232 = CallableStatement.class.getDeclaredMethod("getLong", String.class);
         methodObject27391 = Statement.class.getDeclaredMethod("setMaxRows", Integer.TYPE);
         methodObject27478 = oracle.jdbc.OraclePreparedStatement.class.getDeclaredMethod("setFormOfUse", Integer.TYPE, Short.TYPE);
         methodObject27167 = oracle.jdbc.OracleCallableStatement.class.getDeclaredMethod("getROWID", Integer.TYPE);
         methodObject27213 = oracle.jdbc.OracleCallableStatement.class.getDeclaredMethod("registerOutParameterAtName", String.class, Integer.TYPE, Integer.TYPE);
         methodObject27522 = oracle.jdbc.OracleStatement.class.getDeclaredMethod("isNCHAR", Integer.TYPE);
         methodObject27356 = Statement.class.getDeclaredMethod("close");
         methodObject27153 = oracle.jdbc.OracleCallableStatement.class.getDeclaredMethod("getCursor", Integer.TYPE);
         methodObject27461 = oracle.jdbc.OraclePreparedStatement.class.getDeclaredMethod("setTimeAtName", String.class, Time.class, Calendar.class);
         methodObject27425 = oracle.jdbc.OraclePreparedStatement.class.getDeclaredMethod("setFloatAtName", String.class, Float.TYPE);
         methodObject27165 = oracle.jdbc.OracleCallableStatement.class.getDeclaredMethod("getRAW", Integer.TYPE);
         methodObject27194 = oracle.jdbc.OracleCallableStatement.class.getDeclaredMethod("setBLOB", String.class, BLOB.class);
         methodObject27309 = PreparedStatement.class.getDeclaredMethod("setTimestamp", Integer.TYPE, Timestamp.class, Calendar.class);
         methodObject27317 = PreparedStatement.class.getDeclaredMethod("setBinaryStream", Integer.TYPE, InputStream.class, Long.TYPE);
         methodObject27263 = CallableStatement.class.getDeclaredMethod("getNClob", Integer.TYPE);
         methodObject27130 = oracle.jdbc.OracleCallableStatement.class.getDeclaredMethod("setBytes", String.class, byte[].class);
         methodObject27118 = oracle.jdbc.OracleCallableStatement.class.getDeclaredMethod("setInt", String.class, Integer.TYPE);
         methodObject27135 = oracle.jdbc.OracleCallableStatement.class.getDeclaredMethod("setTime", String.class, Time.class, Calendar.class);
         methodObject27448 = oracle.jdbc.OraclePreparedStatement.class.getDeclaredMethod("setBlobAtName", String.class, InputStream.class, Long.TYPE);
         methodObject27239 = CallableStatement.class.getDeclaredMethod("getArray", Integer.TYPE);
         methodObject27307 = PreparedStatement.class.getDeclaredMethod("setShort", Integer.TYPE, Short.TYPE);
         methodObject27182 = oracle.jdbc.OracleCallableStatement.class.getDeclaredMethod("setBinaryFloat", String.class, Float.TYPE);
         methodObject27536 = oracle.jdbc.OracleStatement.class.getDeclaredMethod("setDatabaseChangeRegistration", DatabaseChangeRegistration.class);
         methodObject27347 = PreparedStatement.class.getDeclaredMethod("setNClob", Integer.TYPE, Reader.class, Long.TYPE);
         methodObject27282 = CallableStatement.class.getDeclaredMethod("setClob", String.class, Reader.class, Long.TYPE);
         methodObject27312 = PreparedStatement.class.getDeclaredMethod("executeUpdate");
         methodObject27323 = PreparedStatement.class.getDeclaredMethod("setNCharacterStream", Integer.TYPE, Reader.class);
         methodObject27528 = oracle.jdbc.OracleStatement.class.getDeclaredMethod("defineColumnTypeBytes", Integer.TYPE, Integer.TYPE, Integer.TYPE);
         methodObject27306 = PreparedStatement.class.getDeclaredMethod("setLong", Integer.TYPE, Long.TYPE);
         methodObject27335 = PreparedStatement.class.getDeclaredMethod("setDate", Integer.TYPE, Date.class, Calendar.class);
         methodObject27264 = CallableStatement.class.getDeclaredMethod("getNClob", String.class);
         methodObject27468 = oracle.jdbc.OraclePreparedStatement.class.getDeclaredMethod("setTIMESTAMPLTZAtName", String.class, TIMESTAMPLTZ.class);
         methodObject27540 = OraclePreparedStatement.class.getDeclaredMethod("setInternalBytes", Integer.TYPE, byte[].class, Integer.TYPE);
         methodObject27505 = oracle.jdbc.OraclePreparedStatement.class.getDeclaredMethod("setCLOB", Integer.TYPE, CLOB.class);
         methodObject27115 = oracle.jdbc.OracleCallableStatement.class.getDeclaredMethod("setByte", String.class, Byte.TYPE);
         methodObject27396 = Statement.class.getDeclaredMethod("setFetchDirection", Integer.TYPE);
         methodObject27185 = oracle.jdbc.OracleCallableStatement.class.getDeclaredMethod("setStringForClob", String.class, String.class);
         methodObject27441 = oracle.jdbc.OraclePreparedStatement.class.getDeclaredMethod("setSTRUCTAtName", String.class, STRUCT.class);
         methodObject27277 = CallableStatement.class.getDeclaredMethod("registerOutParameter", String.class, Integer.TYPE);
         methodObject27319 = PreparedStatement.class.getDeclaredMethod("setCharacterStream", Integer.TYPE, Reader.class, Integer.TYPE);
         methodObject27492 = oracle.jdbc.OraclePreparedStatement.class.getDeclaredMethod("setBinaryFloat", Integer.TYPE, BINARY_FLOAT.class);
         methodObject27116 = oracle.jdbc.OracleCallableStatement.class.getDeclaredMethod("setDouble", String.class, Double.TYPE);
         methodObject27184 = oracle.jdbc.OracleCallableStatement.class.getDeclaredMethod("setBinaryDouble", String.class, Double.TYPE);
         methodObject27129 = oracle.jdbc.OracleCallableStatement.class.getDeclaredMethod("getBinaryStream", String.class);
         methodObject27403 = oracle.jdbc.OraclePreparedStatement.class.getDeclaredMethod("setBinaryStreamAtName", String.class, InputStream.class, Integer.TYPE);
         methodObject27562 = ACProxyable.class.getDeclaredMethod("getACProxy");
         methodObject27470 = oracle.jdbc.OraclePreparedStatement.class.getDeclaredMethod("setORADataAtName", String.class, ORAData.class);
         methodObject27532 = oracle.jdbc.OracleStatement.class.getDeclaredMethod("getLobPrefetchSize");
         methodObject27415 = oracle.jdbc.OraclePreparedStatement.class.getDeclaredMethod("defineParameterTypeChars", Integer.TYPE, Integer.TYPE, Integer.TYPE);
         methodObject27268 = CallableStatement.class.getDeclaredMethod("getSQLXML", String.class);
         methodObject27331 = PreparedStatement.class.getDeclaredMethod("getParameterMetaData");
         methodObject27437 = oracle.jdbc.OraclePreparedStatement.class.getDeclaredMethod("setArrayAtName", String.class, Array.class);
         methodObject27495 = oracle.jdbc.OraclePreparedStatement.class.getDeclaredMethod("setStringForClob", Integer.TYPE, String.class);
         methodObject27508 = oracle.jdbc.OraclePreparedStatement.class.getDeclaredMethod("setINTERVALYM", Integer.TYPE, INTERVALYM.class);
         methodObject27314 = PreparedStatement.class.getDeclaredMethod("setAsciiStream", Integer.TYPE, InputStream.class, Long.TYPE);
         methodObject27409 = oracle.jdbc.OraclePreparedStatement.class.getDeclaredMethod("setNCharacterStreamAtName", String.class, Reader.class);
         methodObject27378 = Statement.class.getDeclaredMethod("getMaxFieldSize");
         methodObject27117 = oracle.jdbc.OracleCallableStatement.class.getDeclaredMethod("setFloat", String.class, Float.TYPE);
         methodObject27305 = PreparedStatement.class.getDeclaredMethod("setInt", Integer.TYPE, Integer.TYPE);
      } catch (Throwable var1) {
         throw new RuntimeException(var1);
      }
   }

   public oracle$1jdbc$1replay$1driver$1NonTxnReplayableStatement$2oracle$1jdbc$1internal$1OracleCallableStatement$$$Proxy(OracleCallableStatement var1, Object var2, ProxyFactory var3, Map var4) {
      this.delegate = var1;
      this.creator = var2;
      this.proxyFactory = var3;
      this.proxyCache = var4;
   }
}
