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
import oracle.jdbc.OraclePreparedStatement;
import oracle.jdbc.dcn.DatabaseChangeRegistration;
import oracle.jdbc.internal.ACProxyable;
import oracle.jdbc.internal.OracleCallableStatement;
import oracle.jdbc.internal.OracleStatement;
import oracle.jdbc.replay.driver.TxnReplayableStatement;
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

public class oracle$1jdbc$1replay$1driver$1TxnReplayableStatement$2oracle$1jdbc$1internal$1OracleCallableStatement$$$Proxy extends TxnReplayableStatement implements OracleCallableStatement, _Proxy_ {
   private OracleCallableStatement delegate;
   private final Object creator;
   private final ProxyFactory proxyFactory;
   private final Map proxyCache;
   private static Object[] zeroLengthObjectArray = new Object[0];
   private static Method methodObject5430;
   private static Method methodObject5289;
   private static Method methodObject5463;
   private static Method methodObject5233;
   private static Method methodObject5120;
   private static Method methodObject5273;
   private static Method methodObject5461;
   private static Method methodObject5391;
   private static Method methodObject5091;
   private static Method methodObject5377;
   private static Method methodObject5224;
   private static Method methodObject5476;
   private static Method methodObject5392;
   private static Method methodObject5080;
   private static Method methodObject5283;
   private static Method methodObject5078;
   private static Method methodObject5139;
   private static Method methodObject5410;
   private static Method methodObject5460;
   private static Method methodObject5381;
   private static Method methodObject5102;
   private static Method methodObject5085;
   private static Method methodObject5325;
   private static Method methodObject5076;
   private static Method methodObject5369;
   private static Method methodObject5456;
   private static Method methodObject5137;
   private static Method methodObject5333;
   private static Method methodObject5337;
   private static Method methodObject5388;
   private static Method methodObject5182;
   private static Method methodObject5217;
   private static Method methodObject5131;
   private static Method methodObject5323;
   private static Method methodObject5405;
   private static Method methodObject5445;
   private static Method methodObject5334;
   private static Method methodObject5322;
   private static Method methodObject5261;
   private static Method methodObject5228;
   private static Method methodObject5302;
   private static Method methodObject5378;
   private static Method methodObject5257;
   private static Method methodObject5058;
   private static Method methodObject5170;
   private static Method methodObject5114;
   private static Method methodObject5339;
   private static Method methodObject5146;
   private static Method methodObject5248;
   private static Method methodObject5420;
   private static Method methodObject5266;
   private static Method methodObject5307;
   private static Method methodObject5277;
   private static Method methodObject5329;
   private static Method methodObject5252;
   private static Method methodObject5053;
   private static Method methodObject5254;
   private static Method methodObject5275;
   private static Method methodObject5315;
   private static Method methodObject5313;
   private static Method methodObject5242;
   private static Method methodObject5382;
   private static Method methodObject5214;
   private static Method methodObject5202;
   private static Method methodObject5189;
   private static Method methodObject5176;
   private static Method methodObject5073;
   private static Method methodObject5054;
   private static Method methodObject5298;
   private static Method methodObject5487;
   private static Method methodObject5493;
   private static Method methodObject5267;
   private static Method methodObject5161;
   private static Method methodObject5251;
   private static Method methodObject5232;
   private static Method methodObject5221;
   private static Method methodObject5422;
   private static Method methodObject5464;
   private static Method methodObject5166;
   private static Method methodObject5414;
   private static Method methodObject5423;
   private static Method methodObject5194;
   private static Method methodObject5157;
   private static Method methodObject5453;
   private static Method methodObject5458;
   private static Method methodObject5190;
   private static Method methodObject5451;
   private static Method methodObject5165;
   private static Method methodObject5143;
   private static Method methodObject5294;
   private static Method methodObject5455;
   private static Method methodObject5047;
   private static Method methodObject5413;
   private static Method methodObject5485;
   private static Method methodObject5204;
   private static Method methodObject5050;
   private static Method methodObject5281;
   private static Method methodObject5115;
   private static Method methodObject5056;
   private static Method methodObject5226;
   private static Method methodObject5402;
   private static Method methodObject5061;
   private static Method methodObject5113;
   private static Method methodObject5462;
   private static Method methodObject5459;
   private static Method methodObject5241;
   private static Method methodObject5367;
   private static Method methodObject5374;
   private static Method methodObject5424;
   private static Method methodObject5296;
   private static Method methodObject5181;
   private static Method methodObject5215;
   private static Method methodObject5140;
   private static Method methodObject5466;
   private static Method methodObject5099;
   private static Method methodObject5219;
   private static Method methodObject5160;
   private static Method methodObject5230;
   private static Method methodObject5351;
   private static Method methodObject5059;
   private static Method methodObject5136;
   private static Method methodObject5468;
   private static Method methodObject5174;
   private static Method methodObject5409;
   private static Method methodObject5356;
   private static Method methodObject5328;
   private static Method methodObject5149;
   private static Method methodObject5301;
   private static Method methodObject5399;
   private static Method methodObject5163;
   private static Method methodObject5429;
   private static Method methodObject5216;
   private static Method methodObject5370;
   private static Method methodObject5225;
   private static Method methodObject5403;
   private static Method methodObject5327;
   private static Method methodObject5290;
   private static Method methodObject5196;
   private static Method methodObject5415;
   private static Method methodObject5237;
   private static Method methodObject5355;
   private static Method methodObject5222;
   private static Method methodObject5151;
   private static Method methodObject5439;
   private static Method methodObject5352;
   private static Method methodObject5375;
   private static Method methodObject5067;
   private static Method methodObject5135;
   private static Method methodObject5286;
   private static Method methodObject5209;
   private static Method methodObject5412;
   private static Method methodObject5154;
   private static Method methodObject5317;
   private static Method methodObject5258;
   private static Method methodObject5442;
   private static Method methodObject5344;
   private static Method methodObject5198;
   private static Method methodObject5052;
   private static Method methodObject5436;
   private static Method methodObject5441;
   private static Method methodObject5431;
   private static Method methodObject5213;
   private static Method methodObject5211;
   private static Method methodObject5320;
   private static Method methodObject5491;
   private static Method methodObject5287;
   private static Method methodObject5134;
   private static Method methodObject5393;
   private static Method methodObject5311;
   private static Method methodObject5404;
   private static Method methodObject5175;
   private static Method methodObject5083;
   private static Method methodObject5156;
   private static Method methodObject5152;
   private static Method methodObject5345;
   private static Method methodObject5406;
   private static Method methodObject5210;
   private static Method methodObject5358;
   private static Method methodObject5110;
   private static Method methodObject5350;
   private static Method methodObject5483;
   private static Method methodObject5481;
   private static Method methodObject5045;
   private static Method methodObject5438;
   private static Method methodObject5292;
   private static Method methodObject5072;
   private static Method methodObject5272;
   private static Method methodObject5130;
   private static Method methodObject5470;
   private static Method methodObject5127;
   private static Method methodObject5090;
   private static Method methodObject5284;
   private static Method methodObject5055;
   private static Method methodObject5373;
   private static Method methodObject5103;
   private static Method methodObject5238;
   private static Method methodObject5227;
   private static Method methodObject5068;
   private static Method methodObject5106;
   private static Method methodObject5268;
   private static Method methodObject5235;
   private static Method methodObject5394;
   private static Method methodObject5480;
   private static Method methodObject5150;
   private static Method methodObject5492;
   private static Method methodObject5475;
   private static Method methodObject5486;
   private static Method methodObject5308;
   private static Method methodObject5069;
   private static Method methodObject5385;
   private static Method methodObject5109;
   private static Method methodObject5364;
   private static Method methodObject5124;
   private static Method methodObject5256;
   private static Method methodObject5490;
   private static Method methodObject5299;
   private static Method methodObject5187;
   private static Method methodObject5132;
   private static Method methodObject5482;
   private static Method methodObject5240;
   private static Method methodObject5231;
   private static Method methodObject5205;
   private static Method methodObject5495;
   private static Method methodObject5285;
   private static Method methodObject5472;
   private static Method methodObject5434;
   private static Method methodObject5263;
   private static Method methodObject5425;
   private static Method methodObject5312;
   private static Method methodObject5246;
   private static Method methodObject5362;
   private static Method methodObject5353;
   private static Method methodObject5243;
   private static Method methodObject5095;
   private static Method methodObject5380;
   private static Method methodObject5450;
   private static Method methodObject5408;
   private static Method methodObject5177;
   private static Method methodObject5168;
   private static Method methodObject5305;
   private static Method methodObject5452;
   private static Method methodObject5162;
   private static Method methodObject5387;
   private static Method methodObject5390;
   private static Method methodObject5384;
   private static Method methodObject5386;
   private static Method methodObject5119;
   private static Method methodObject5300;
   private static Method methodObject5418;
   private static Method methodObject5280;
   private static Method methodObject5379;
   private static Method methodObject5489;
   private static Method methodObject5201;
   private static Method methodObject5077;
   private static Method methodObject5245;
   private static Method methodObject5169;
   private static Method methodObject5062;
   private static Method methodObject5433;
   private static Method methodObject5046;
   private static Method methodObject5112;
   private static Method methodObject5060;
   private static Method methodObject5326;
   private static Method methodObject5208;
   private static Method methodObject5427;
   private static Method methodObject5324;
   private static Method methodObject5255;
   private static Method methodObject5346;
   private static Method methodObject5192;
   private static Method methodObject5111;
   private static Method methodObject5249;
   private static Method methodObject5172;
   private static Method methodObject5129;
   private static Method methodObject5282;
   private static Method methodObject5395;
   private static Method methodObject5138;
   private static Method methodObject5133;
   private static Method methodObject5310;
   private static Method methodObject5428;
   private static Method methodObject5167;
   private static Method methodObject5383;
   private static Method methodObject5191;
   private static Method methodObject5265;
   private static Method methodObject5360;
   private static Method methodObject5496;
   private static Method methodObject5357;
   private static Method methodObject5044;
   private static Method methodObject5158;
   private static Method methodObject5447;
   private static Method methodObject5121;
   private static Method methodObject5437;
   private static Method methodObject5075;
   private static Method methodObject5304;
   private static Method methodObject5118;
   private static Method methodObject5212;
   private static Method methodObject5488;
   private static Method methodObject5446;
   private static Method methodObject5178;
   private static Method methodObject5494;
   private static Method methodObject5465;
   private static Method methodObject5474;
   private static Method methodObject5126;
   private static Method methodObject5309;
   private static Method methodObject5203;
   private static Method methodObject5342;
   private static Method methodObject5153;
   private static Method methodObject5145;
   private static Method methodObject5335;
   private static Method methodObject5319;
   private static Method methodObject5449;
   private static Method methodObject5419;
   private static Method methodObject5295;
   private static Method methodObject5097;
   private static Method methodObject5332;
   private static Method methodObject5389;
   private static Method methodObject5195;
   private static Method methodObject5432;
   private static Method methodObject5104;
   private static Method methodObject5401;
   private static Method methodObject5184;
   private static Method methodObject5101;
   private static Method methodObject5147;
   private static Method methodObject5440;
   private static Method methodObject5270;
   private static Method methodObject5349;
   private static Method methodObject5361;
   private static Method methodObject5229;
   private static Method methodObject5341;
   private static Method methodObject5084;
   private static Method methodObject5107;
   private static Method methodObject5471;
   private static Method methodObject5321;
   private static Method methodObject5435;
   private static Method methodObject5293;
   private static Method methodObject5365;
   private static Method methodObject5400;
   private static Method methodObject5142;
   private static Method methodObject5366;
   private static Method methodObject5479;
   private static Method methodObject5477;
   private static Method methodObject5363;
   private static Method methodObject5274;
   private static Method methodObject5186;
   private static Method methodObject5372;
   private static Method methodObject5048;
   private static Method methodObject5343;
   private static Method methodObject5398;
   private static Method methodObject5082;
   private static Method methodObject5094;
   private static Method methodObject5297;
   private static Method methodObject5314;
   private static Method methodObject5234;
   private static Method methodObject5200;
   private static Method methodObject5128;
   private static Method methodObject5065;
   private static Method methodObject5185;
   private static Method methodObject5108;
   private static Method methodObject5093;
   private static Method methodObject5239;
   private static Method methodObject5473;
   private static Method methodObject5454;
   private static Method methodObject5070;
   private static Method methodObject5336;
   private static Method methodObject5338;
   private static Method methodObject5100;
   private static Method methodObject5125;
   private static Method methodObject5197;
   private static Method methodObject5066;
   private static Method methodObject5089;
   private static Method methodObject5318;
   private static Method methodObject5396;
   private static Method methodObject5416;
   private static Method methodObject5088;
   private static Method methodObject5223;
   private static Method methodObject5269;
   private static Method methodObject5371;
   private static Method methodObject5260;
   private static Method methodObject5057;
   private static Method methodObject5236;
   private static Method methodObject5081;
   private static Method methodObject5340;
   private static Method methodObject5347;
   private static Method methodObject5220;
   private static Method methodObject5087;
   private static Method methodObject5155;
   private static Method methodObject5064;
   private static Method methodObject5098;
   private static Method methodObject5478;
   private static Method methodObject5079;
   private static Method methodObject5448;
   private static Method methodObject5179;
   private static Method methodObject5278;
   private static Method methodObject5250;
   private static Method methodObject5331;
   private static Method methodObject5206;
   private static Method methodObject5051;
   private static Method methodObject5144;
   private static Method methodObject5359;
   private static Method methodObject5049;
   private static Method methodObject5376;
   private static Method methodObject5188;
   private static Method methodObject5247;
   private static Method methodObject5348;
   private static Method methodObject5123;
   private static Method methodObject5105;
   private static Method methodObject5303;
   private static Method methodObject5306;
   private static Method methodObject5417;
   private static Method methodObject5141;
   private static Method methodObject5259;
   private static Method methodObject5183;
   private static Method methodObject5354;
   private static Method methodObject5407;
   private static Method methodObject5117;
   private static Method methodObject5271;
   private static Method methodObject5291;
   private static Method methodObject5164;
   private static Method methodObject5086;
   private static Method methodObject5148;
   private static Method methodObject5071;
   private static Method methodObject5063;
   private static Method methodObject5122;
   private static Method methodObject5262;
   private static Method methodObject5193;
   private static Method methodObject5276;
   private static Method methodObject5368;
   private static Method methodObject5159;
   private static Method methodObject5457;
   private static Method methodObject5244;
   private static Method methodObject5180;
   private static Method methodObject5411;
   private static Method methodObject5279;
   private static Method methodObject5497;
   private static Method methodObject5421;
   private static Method methodObject5467;
   private static Method methodObject5264;
   private static Method methodObject5397;
   private static Method methodObject5218;
   private static Method methodObject5199;
   private static Method methodObject5092;
   private static Method methodObject5253;
   private static Method methodObject5469;
   private static Method methodObject5288;
   private static Method methodObject5426;
   private static Method methodObject5444;
   private static Method methodObject5173;
   private static Method methodObject5316;
   private static Method methodObject5330;
   private static Method methodObject5207;
   private static Method methodObject5096;
   private static Method methodObject5171;

   public void setTimestampAtName(String arg0, Timestamp arg1, Calendar arg2) throws SQLException {
      try {
         super.preForAll(methodObject5430, this, arg0, arg1, arg2);
         Method var10001 = methodObject5430;
         this.delegate.setTimestampAtName(arg0, arg1, arg2);
         this.postForAll(var10001);
      } catch (SQLException var5) {
         this.onErrorVoidForAll(methodObject5430, var5);
      }
   }

   public void setTime(int arg0, Time arg1) throws SQLException {
      try {
         super.preForAll(methodObject5289, this, arg0, arg1);
         Method var10001 = methodObject5289;
         this.delegate.setTime(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject5289, var4);
      }
   }

   public void defineColumnTypeBytes(int arg0, int arg1, int arg2) throws SQLException {
      try {
         super.preForAll(methodObject5463, this, arg0, arg1, arg2);
         Method var10001 = methodObject5463;
         this.delegate.defineColumnTypeBytes(arg0, arg1, arg2);
         this.postForAll(var10001);
      } catch (SQLException var5) {
         this.onErrorVoidForAll(methodObject5463, var5);
      }
   }

   public void setNString(String arg0, String arg1) throws SQLException {
      try {
         super.preForAll(methodObject5233, this, arg0, arg1);
         Method var10001 = methodObject5233;
         this.delegate.setNString(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject5233, var4);
      }
   }

   public void setBinaryDouble(String arg0, BINARY_DOUBLE arg1) throws SQLException {
      try {
         super.preForAll(methodObject5120, this, arg0, arg1);
         Method var10001 = methodObject5120;
         this.delegate.setBinaryDouble(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject5120, var4);
      }
   }

   public void setDate(int arg0, Date arg1, Calendar arg2) throws SQLException {
      try {
         super.preForAll(methodObject5273, this, arg0, arg1, arg2);
         Method var10001 = methodObject5273;
         this.delegate.setDate(arg0, arg1, arg2);
         this.postForAll(var10001);
      } catch (SQLException var5) {
         this.onErrorVoidForAll(methodObject5273, var5);
      }
   }

   public void defineColumnType(int arg0, int arg1, int arg2, short arg3) throws SQLException {
      try {
         super.preForAll(methodObject5461, this, arg0, arg1, arg2, arg3);
         Method var10001 = methodObject5461;
         this.delegate.defineColumnType(arg0, arg1, arg2, arg3);
         this.postForAll(var10001);
      } catch (SQLException var6) {
         this.onErrorVoidForAll(methodObject5461, var6);
      }
   }

   public void setLongAtName(String arg0, long arg1) throws SQLException {
      try {
         super.preForAll(methodObject5391, this, arg0, arg1);
         Method var10001 = methodObject5391;
         this.delegate.setLongAtName(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var5) {
         this.onErrorVoidForAll(methodObject5391, var5);
      }
   }

   public BFILE getBFILE(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject5091, this, arg0);
         return (BFILE)this.postForAll(methodObject5091, (Object)this.delegate.getBFILE(arg0));
      } catch (SQLException var3) {
         return (BFILE)this.postForAll(methodObject5091, this.onErrorForAll(methodObject5091, var3));
      }
   }

   public void setORAData(int arg0, ORAData arg1) throws SQLException {
      try {
         super.preForAll(methodObject5377, this, arg0, arg1);
         Method var10001 = methodObject5377;
         this.delegate.setORAData(arg0, arg1 instanceof _Proxy_ ? (ORAData)((_Proxy_)arg1)._getDelegate_() : arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject5377, var4);
      }
   }

   public void setBlob(String arg0, InputStream arg1, long arg2) throws SQLException {
      try {
         super.preForAll(methodObject5224, this, arg0, arg1, arg2);
         Method var10001 = methodObject5224;
         this.delegate.setBlob(arg0, arg1, arg2);
         this.postForAll(var10001);
      } catch (SQLException var6) {
         this.onErrorVoidForAll(methodObject5224, var6);
      }
   }

   public void enterImplicitCache() throws SQLException {
      try {
         super.preForAll(methodObject5476, this, zeroLengthObjectArray);
         Method var10001 = methodObject5476;
         this.delegate.enterImplicitCache();
         this.postForAll(var10001);
      } catch (SQLException var2) {
         this.onErrorVoidForAll(methodObject5476, var2);
      }
   }

   public void setFloatAtName(String arg0, float arg1) throws SQLException {
      try {
         super.preForAll(methodObject5392, this, arg0, arg1);
         Method var10001 = methodObject5392;
         this.delegate.setFloatAtName(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject5392, var4);
      }
   }

   public void setDate(String arg0, Date arg1, Calendar arg2) throws SQLException {
      try {
         super.preForAll(methodObject5080, this, arg0, arg1, arg2);
         Method var10001 = methodObject5080;
         this.delegate.setDate(arg0, arg1, arg2);
         this.postForAll(var10001);
      } catch (SQLException var5) {
         this.onErrorVoidForAll(methodObject5080, var5);
      }
   }

   public void setObject(int arg0, Object arg1) throws SQLException {
      try {
         super.preForSetObjects(methodObject5283, this, arg0, arg1);
         Method var10001 = methodObject5283;
         this.delegate.setObject(arg0, arg1 instanceof _Proxy_ ? (Object)((_Proxy_)arg1)._getDelegate_() : arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject5283, var4);
      }
   }

   public void setClob(String arg0, Clob arg1) throws SQLException {
      try {
         super.preForAll(methodObject5078, this, arg0, arg1);
         Method var10001 = methodObject5078;
         this.delegate.setClob(arg0, arg1 instanceof _Proxy_ ? (Clob)((_Proxy_)arg1)._getDelegate_() : arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject5078, var4);
      }
   }

   public void setTIMESTAMPLTZ(String arg0, TIMESTAMPLTZ arg1) throws SQLException {
      try {
         super.preForAll(methodObject5139, this, arg0, arg1);
         Method var10001 = methodObject5139;
         this.delegate.setTIMESTAMPLTZ(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject5139, var4);
      }
   }

   public void setCHARAtName(String arg0, CHAR arg1) throws SQLException {
      try {
         super.preForAll(methodObject5410, this, arg0, arg1);
         Method var10001 = methodObject5410;
         this.delegate.setCHARAtName(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject5410, var4);
      }
   }

   public void defineColumnType(int arg0, int arg1, int arg2) throws SQLException {
      try {
         super.preForAll(methodObject5460, this, arg0, arg1, arg2);
         Method var10001 = methodObject5460;
         this.delegate.defineColumnType(arg0, arg1, arg2);
         this.postForAll(var10001);
      } catch (SQLException var5) {
         this.onErrorVoidForAll(methodObject5460, var5);
      }
   }

   public void defineParameterTypeBytes(int arg0, int arg1, int arg2) throws SQLException {
      try {
         super.preForAll(methodObject5381, this, arg0, arg1, arg2);
         Method var10001 = methodObject5381;
         this.delegate.defineParameterTypeBytes(arg0, arg1, arg2);
         this.postForAll(var10001);
      } catch (SQLException var5) {
         this.onErrorVoidForAll(methodObject5381, var5);
      }
   }

   public RAW getRAW(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject5102, this, arg0);
         return (RAW)this.postForAll(methodObject5102, (Object)this.delegate.getRAW(arg0));
      } catch (SQLException var3) {
         return (RAW)this.postForAll(methodObject5102, this.onErrorForAll(methodObject5102, var3));
      }
   }

   public void setObject(String arg0, Object arg1) throws SQLException {
      try {
         super.preForSetObjects(methodObject5085, this, arg0, arg1);
         Method var10001 = methodObject5085;
         this.delegate.setObject(arg0, arg1 instanceof _Proxy_ ? (Object)((_Proxy_)arg1)._getDelegate_() : arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject5085, var4);
      }
   }

   public boolean isCloseOnCompletion() throws SQLException {
      try {
         super.preForAll(methodObject5325, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject5325, this.delegate.isCloseOnCompletion());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject5325, this.onErrorForAll(methodObject5325, var2));
      }
   }

   public void setBigDecimal(String arg0, BigDecimal arg1) throws SQLException {
      try {
         super.preForAll(methodObject5076, this, arg0, arg1);
         Method var10001 = methodObject5076;
         this.delegate.setBigDecimal(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject5076, var4);
      }
   }

   public void setTIMESTAMP(int arg0, TIMESTAMP arg1) throws SQLException {
      try {
         super.preForAll(methodObject5369, this, arg0, arg1);
         Method var10001 = methodObject5369;
         this.delegate.setTIMESTAMP(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject5369, var4);
      }
   }

   public void setSQLXMLAtName(String arg0, SQLXML arg1) throws SQLException {
      try {
         super.preForAll(methodObject5456, this, arg0, arg1);
         Method var10001 = methodObject5456;
         this.delegate.setSQLXMLAtName(arg0, arg1 instanceof _Proxy_ ? (SQLXML)((_Proxy_)arg1)._getDelegate_() : arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject5456, var4);
      }
   }

   public void setTIMESTAMP(String arg0, TIMESTAMP arg1) throws SQLException {
      try {
         super.preForAll(methodObject5137, this, arg0, arg1);
         Method var10001 = methodObject5137;
         this.delegate.setTIMESTAMP(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject5137, var4);
      }
   }

   public Object unwrap(Class arg0) throws SQLException {
      try {
         super.preForAll(methodObject5333, this, arg0);
         return this.postForAll(methodObject5333, this.proxyFactory.proxyForCache(this.delegate.unwrap(arg0), this, this.proxyCache, methodObject5333));
      } catch (SQLException var3) {
         return this.postForAll(methodObject5333, this.onErrorForAll(methodObject5333, var3));
      }
   }

   public void setAsciiStreamAtName(String arg0, InputStream arg1) throws SQLException {
      try {
         super.preForSetStreams(methodObject5337, this, arg0, arg1);
         Method var10001 = methodObject5337;
         this.delegate.setAsciiStreamAtName(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject5337, var4);
      }
   }

   public void setByteAtName(String arg0, byte arg1) throws SQLException {
      try {
         super.preForAll(methodObject5388, this, arg0, arg1);
         Method var10001 = methodObject5388;
         this.delegate.setByteAtName(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject5388, var4);
      }
   }

   public Date getDate(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject5182, this, arg0);
         return (Date)this.postForAll(methodObject5182, (Object)this.delegate.getDate(arg0));
      } catch (SQLException var3) {
         return (Date)this.postForAll(methodObject5182, this.onErrorForAll(methodObject5182, var3));
      }
   }

   public boolean wasNull() throws SQLException {
      try {
         super.preForAll(methodObject5217, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject5217, this.delegate.wasNull());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject5217, this.onErrorForAll(methodObject5217, var2));
      }
   }

   public void setBLOB(String arg0, BLOB arg1) throws SQLException {
      try {
         super.preForAll(methodObject5131, this, arg0, arg1);
         Method var10001 = methodObject5131;
         this.delegate.setBLOB(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject5131, var4);
      }
   }

   public int getResultSetType() throws SQLException {
      try {
         super.preForAll(methodObject5323, this, zeroLengthObjectArray);
         return (Integer)this.postForAll(methodObject5323, this.delegate.getResultSetType());
      } catch (SQLException var2) {
         return (Integer)this.postForAll(methodObject5323, this.onErrorForAll(methodObject5323, var2));
      }
   }

   public void setARRAYAtName(String arg0, ARRAY arg1) throws SQLException {
      try {
         super.preForAll(methodObject5405, this, arg0, arg1);
         Method var10001 = methodObject5405;
         this.delegate.setARRAYAtName(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject5405, var4);
      }
   }

   public void setFormOfUse(int arg0, short arg1) {
      super.preForAll(methodObject5445, this, arg0, arg1);
      Method var10001 = methodObject5445;
      this.delegate.setFormOfUse(arg0, arg1);
      this.postForAll(var10001);
   }

   public boolean isWrapperFor(Class arg0) throws SQLException {
      try {
         super.preForAll(methodObject5334, this, arg0);
         return (Boolean)this.postForAll(methodObject5334, this.delegate.isWrapperFor(arg0));
      } catch (SQLException var3) {
         return (Boolean)this.postForAll(methodObject5334, this.onErrorForAll(methodObject5334, var3));
      }
   }

   public int getResultSetHoldability() throws SQLException {
      try {
         super.preForAll(methodObject5322, this, zeroLengthObjectArray);
         return (Integer)this.postForAll(methodObject5322, this.delegate.getResultSetHoldability());
      } catch (SQLException var2) {
         return (Integer)this.postForAll(methodObject5322, this.onErrorForAll(methodObject5322, var2));
      }
   }

   public void setBinaryStream(int arg0, InputStream arg1) throws SQLException {
      try {
         super.preForSetStreams(methodObject5261, this, arg0, arg1);
         Method var10001 = methodObject5261;
         this.delegate.setBinaryStream(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject5261, var4);
      }
   }

   public void setNCharacterStream(String arg0, Reader arg1, long arg2) throws SQLException {
      try {
         super.preForSetStreams(methodObject5228, this, arg0, arg1, arg2);
         Method var10001 = methodObject5228;
         this.delegate.setNCharacterStream(arg0, arg1, arg2);
         this.postForAll(var10001);
      } catch (SQLException var6) {
         this.onErrorVoidForAll(methodObject5228, var6);
      }
   }

   public void clearWarnings() throws SQLException {
      try {
         super.preForAll(methodObject5302, this, zeroLengthObjectArray);
         Method var10001 = methodObject5302;
         this.delegate.clearWarnings();
         this.postForAll(var10001);
      } catch (SQLException var2) {
         this.onErrorVoidForAll(methodObject5302, var2);
      }
   }

   public void setRefType(int arg0, REF arg1) throws SQLException {
      try {
         super.preForAll(methodObject5378, this, arg0, arg1);
         Method var10001 = methodObject5378;
         this.delegate.setRefType(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject5378, var4);
      }
   }

   public void setCharacterStream(int arg0, Reader arg1) throws SQLException {
      try {
         super.preForSetStreams(methodObject5257, this, arg0, arg1);
         Method var10001 = methodObject5257;
         this.delegate.setCharacterStream(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject5257, var4);
      }
   }

   public void setURL(String arg0, URL arg1) throws SQLException {
      try {
         super.preForAll(methodObject5058, this, arg0, arg1);
         Method var10001 = methodObject5058;
         this.delegate.setURL(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject5058, var4);
      }
   }

   public double getDouble(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject5170, this, arg0);
         return (Double)this.postForAll(methodObject5170, this.delegate.getDouble(arg0));
      } catch (SQLException var3) {
         return (Double)this.postForAll(methodObject5170, this.onErrorForAll(methodObject5170, var3));
      }
   }

   public void registerOutParameterBytes(int arg0, int arg1, int arg2, int arg3) throws SQLException {
      try {
         super.preForAll(methodObject5114, this, arg0, arg1, arg2, arg3);
         Method var10001 = methodObject5114;
         this.delegate.registerOutParameterBytes(arg0, arg1, arg2, arg3);
         this.postForAll(var10001);
      } catch (SQLException var6) {
         this.onErrorVoidForAll(methodObject5114, var6);
      }
   }

   public void setBinaryStreamAtName(String arg0, InputStream arg1, long arg2) throws SQLException {
      try {
         super.preForSetStreams(methodObject5339, this, arg0, arg1, arg2);
         Method var10001 = methodObject5339;
         this.delegate.setBinaryStreamAtName(arg0, arg1, arg2);
         this.postForAll(var10001);
      } catch (SQLException var6) {
         this.onErrorVoidForAll(methodObject5339, var6);
      }
   }

   public void setRefType(String arg0, REF arg1) throws SQLException {
      try {
         super.preForAll(methodObject5146, this, arg0, arg1);
         Method var10001 = methodObject5146;
         this.delegate.setRefType(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject5146, var4);
      }
   }

   public ResultSetMetaData getMetaData() throws SQLException {
      try {
         super.preForAll(methodObject5248, this, zeroLengthObjectArray);
         return (ResultSetMetaData)this.postForAll(methodObject5248, this.proxyFactory.proxyForCache((Object)this.delegate.getMetaData(), this, this.proxyCache, methodObject5248));
      } catch (SQLException var2) {
         return (ResultSetMetaData)this.postForAll(methodObject5248, this.onErrorForAll(methodObject5248, var2));
      }
   }

   public void setClobAtName(String arg0, Reader arg1) throws SQLException {
      try {
         super.preForAll(methodObject5420, this, arg0, arg1);
         Method var10001 = methodObject5420;
         this.delegate.setClobAtName(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject5420, var4);
      }
   }

   public void setBlob(int arg0, Blob arg1) throws SQLException {
      try {
         super.preForAll(methodObject5266, this, arg0, arg1);
         Method var10001 = methodObject5266;
         this.delegate.setBlob(arg0, arg1 instanceof _Proxy_ ? (Blob)((_Proxy_)arg1)._getDelegate_() : arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject5266, var4);
      }
   }

   public void addBatch(String arg0) throws SQLException {
      try {
         super.preForAll(methodObject5307, this, arg0);
         Method var10001 = methodObject5307;
         this.delegate.addBatch(arg0);
         this.postForAll(var10001);
      } catch (SQLException var3) {
         this.onErrorVoidForAll(methodObject5307, var3);
      }
   }

   public void setNClob(int arg0, Reader arg1, long arg2) throws SQLException {
      try {
         super.preForAll(methodObject5277, this, arg0, arg1, arg2);
         Method var10001 = methodObject5277;
         this.delegate.setNClob(arg0, arg1, arg2);
         this.postForAll(var10001);
      } catch (SQLException var6) {
         this.onErrorVoidForAll(methodObject5277, var6);
      }
   }

   public void setMaxFieldSize(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject5329, this, arg0);
         Method var10001 = methodObject5329;
         this.delegate.setMaxFieldSize(arg0);
         this.postForAll(var10001);
      } catch (SQLException var3) {
         this.onErrorVoidForAll(methodObject5329, var3);
      }
   }

   public void setAsciiStream(int arg0, InputStream arg1, int arg2) throws SQLException {
      try {
         super.preForSetStreams(methodObject5252, this, arg0, arg1, arg2);
         Method var10001 = methodObject5252;
         this.delegate.setAsciiStream(arg0, arg1, arg2);
         this.postForAll(var10001);
      } catch (SQLException var5) {
         this.onErrorVoidForAll(methodObject5252, var5);
      }
   }

   public void setInt(String arg0, int arg1) throws SQLException {
      try {
         super.preForAll(methodObject5053, this, arg0, arg1);
         Method var10001 = methodObject5053;
         this.delegate.setInt(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject5053, var4);
      }
   }

   public void setAsciiStream(int arg0, InputStream arg1) throws SQLException {
      try {
         super.preForSetStreams(methodObject5254, this, arg0, arg1);
         Method var10001 = methodObject5254;
         this.delegate.setAsciiStream(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject5254, var4);
      }
   }

   public void setNCharacterStream(int arg0, Reader arg1) throws SQLException {
      try {
         super.preForSetStreams(methodObject5275, this, arg0, arg1);
         Method var10001 = methodObject5275;
         this.delegate.setNCharacterStream(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject5275, var4);
      }
   }

   public ResultSet getGeneratedKeys() throws SQLException {
      try {
         super.preForAll(methodObject5315, this, zeroLengthObjectArray);
         return (ResultSet)this.postForAll(methodObject5315, this.proxyFactory.proxyForCache((Object)this.delegate.getGeneratedKeys(), this, this.proxyCache, methodObject5315));
      } catch (SQLException var2) {
         return (ResultSet)this.postForAll(methodObject5315, this.onErrorForAll(methodObject5315, var2));
      }
   }

   public int executeUpdate(String arg0, int[] arg1) throws SQLException {
      try {
         super.preForExecuteUpdate(methodObject5313, this, arg0, arg1);
         return (Integer)this.postForAll(methodObject5313, this.delegate.executeUpdate(arg0, arg1));
      } catch (SQLException var4) {
         return (Integer)this.postForAll(methodObject5313, this.onErrorForAll(methodObject5313, var4));
      }
   }

   public void setShort(int arg0, short arg1) throws SQLException {
      try {
         super.preForAll(methodObject5242, this, arg0, arg1);
         Method var10001 = methodObject5242;
         this.delegate.setShort(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject5242, var4);
      }
   }

   public void defineParameterTypeChars(int arg0, int arg1, int arg2) throws SQLException {
      try {
         super.preForAll(methodObject5382, this, arg0, arg1, arg2);
         Method var10001 = methodObject5382;
         this.delegate.defineParameterTypeChars(arg0, arg1, arg2);
         this.postForAll(var10001);
      } catch (SQLException var5) {
         this.onErrorVoidForAll(methodObject5382, var5);
      }
   }

   public void registerOutParameter(String arg0, int arg1) throws SQLException {
      try {
         super.preForAll(methodObject5214, this, arg0, arg1);
         Method var10001 = methodObject5214;
         this.delegate.registerOutParameter(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject5214, var4);
      }
   }

   public Time getTime(int arg0, Calendar arg1) throws SQLException {
      try {
         super.preForAll(methodObject5202, this, arg0, arg1);
         return (Time)this.postForAll(methodObject5202, (Object)this.delegate.getTime(arg0, arg1));
      } catch (SQLException var4) {
         return (Time)this.postForAll(methodObject5202, this.onErrorForAll(methodObject5202, var4));
      }
   }

   public Clob getClob(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject5189, this, arg0);
         return (Clob)this.postForAll(methodObject5189, this.proxyFactory.proxyForCache((Object)this.delegate.getClob(arg0), this, this.proxyCache, methodObject5189));
      } catch (SQLException var3) {
         return (Clob)this.postForAll(methodObject5189, this.onErrorForAll(methodObject5189, var3));
      }
   }

   public URL getURL(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject5176, this, arg0);
         return (URL)this.postForAll(methodObject5176, (Object)this.delegate.getURL(arg0));
      } catch (SQLException var3) {
         return (URL)this.postForAll(methodObject5176, this.onErrorForAll(methodObject5176, var3));
      }
   }

   public void setCharacterStream(String arg0, Reader arg1, int arg2) throws SQLException {
      try {
         super.preForSetStreams(methodObject5073, this, arg0, arg1, arg2);
         Method var10001 = methodObject5073;
         this.delegate.setCharacterStream(arg0, arg1, arg2);
         this.postForAll(var10001);
      } catch (SQLException var5) {
         this.onErrorVoidForAll(methodObject5073, var5);
      }
   }

   public void setLong(String arg0, long arg1) throws SQLException {
      try {
         super.preForAll(methodObject5054, this, arg0, arg1);
         Method var10001 = methodObject5054;
         this.delegate.setLong(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var5) {
         this.onErrorVoidForAll(methodObject5054, var5);
      }
   }

   public int getFetchDirection() throws SQLException {
      try {
         super.preForAll(methodObject5298, this, zeroLengthObjectArray);
         return (Integer)this.postForAll(methodObject5298, this.delegate.getFetchDirection());
      } catch (SQLException var2) {
         return (Integer)this.postForAll(methodObject5298, this.onErrorForAll(methodObject5298, var2));
      }
   }

   public boolean getFixedString() {
      super.preForAll(methodObject5487, this, zeroLengthObjectArray);
      return (Boolean)this.postForAll(methodObject5487, this.delegate.getFixedString());
   }

   public long getChecksum() throws SQLException {
      try {
         super.preForAll(methodObject5493, this, zeroLengthObjectArray);
         return (Long)this.postForAll(methodObject5493, this.delegate.getChecksum());
      } catch (SQLException var2) {
         return (Long)this.postForAll(methodObject5493, this.onErrorForAll(methodObject5493, var2));
      }
   }

   public void setBlob(int arg0, InputStream arg1, long arg2) throws SQLException {
      try {
         super.preForAll(methodObject5267, this, arg0, arg1, arg2);
         Method var10001 = methodObject5267;
         this.delegate.setBlob(arg0, arg1, arg2);
         this.postForAll(var10001);
      } catch (SQLException var6) {
         this.onErrorVoidForAll(methodObject5267, var6);
      }
   }

   public byte getByte(String arg0) throws SQLException {
      try {
         super.preForAll(methodObject5161, this, arg0);
         return (Byte)this.postForAll(methodObject5161, this.delegate.getByte(arg0));
      } catch (SQLException var3) {
         return (Byte)this.postForAll(methodObject5161, this.onErrorForAll(methodObject5161, var3));
      }
   }

   public void setString(int arg0, String arg1) throws SQLException {
      try {
         super.preForAll(methodObject5251, this, arg0, arg1);
         Method var10001 = methodObject5251;
         this.delegate.setString(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject5251, var4);
      }
   }

   public void setNClob(String arg0, Reader arg1) throws SQLException {
      try {
         super.preForAll(methodObject5232, this, arg0, arg1);
         Method var10001 = methodObject5232;
         this.delegate.setNClob(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject5232, var4);
      }
   }

   public void setCharacterStream(String arg0, Reader arg1) throws SQLException {
      try {
         super.preForSetStreams(methodObject5221, this, arg0, arg1);
         Method var10001 = methodObject5221;
         this.delegate.setCharacterStream(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject5221, var4);
      }
   }

   public void setBfileAtName(String arg0, BFILE arg1) throws SQLException {
      try {
         super.preForAll(methodObject5422, this, arg0, arg1);
         Method var10001 = methodObject5422;
         this.delegate.setBfileAtName(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject5422, var4);
      }
   }

   public void defineColumnTypeChars(int arg0, int arg1, int arg2) throws SQLException {
      try {
         super.preForAll(methodObject5464, this, arg0, arg1, arg2);
         Method var10001 = methodObject5464;
         this.delegate.defineColumnTypeChars(arg0, arg1, arg2);
         this.postForAll(var10001);
      } catch (SQLException var5) {
         this.onErrorVoidForAll(methodObject5464, var5);
      }
   }

   public long getLong(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject5166, this, arg0);
         return (Long)this.postForAll(methodObject5166, this.delegate.getLong(arg0));
      } catch (SQLException var3) {
         return (Long)this.postForAll(methodObject5166, this.onErrorForAll(methodObject5166, var3));
      }
   }

   public void setBlobAtName(String arg0, Blob arg1) throws SQLException {
      try {
         super.preForAll(methodObject5414, this, arg0, arg1);
         Method var10001 = methodObject5414;
         this.delegate.setBlobAtName(arg0, arg1 instanceof _Proxy_ ? (Blob)((_Proxy_)arg1)._getDelegate_() : arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject5414, var4);
      }
   }

   public void setBytesAtName(String arg0, byte[] arg1) throws SQLException {
      try {
         super.preForAll(methodObject5423, this, arg0, arg1);
         Method var10001 = methodObject5423;
         this.delegate.setBytesAtName(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject5423, var4);
      }
   }

   public NClob getNClob(String arg0) throws SQLException {
      try {
         super.preForAll(methodObject5194, this, arg0);
         return (NClob)this.postForAll(methodObject5194, this.proxyFactory.proxyForCache((Object)this.delegate.getNClob(arg0), this, this.proxyCache, methodObject5194));
      } catch (SQLException var3) {
         return (NClob)this.postForAll(methodObject5194, this.onErrorForAll(methodObject5194, var3));
      }
   }

   public Object getObject(String arg0, Class arg1) throws SQLException {
      try {
         super.preForAll(methodObject5157, this, arg0, arg1);
         return this.postForAll(methodObject5157, this.proxyFactory.proxyForCache(this.delegate.getObject(arg0, arg1), this, this.proxyCache, methodObject5157));
      } catch (SQLException var4) {
         return this.postForAll(methodObject5157, this.onErrorForAll(methodObject5157, var4));
      }
   }

   public void setNClobAtName(String arg0, Reader arg1) throws SQLException {
      try {
         super.preForAll(methodObject5453, this, arg0, arg1);
         Method var10001 = methodObject5453;
         this.delegate.setNClobAtName(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject5453, var4);
      }
   }

   public void clearDefines() throws SQLException {
      try {
         super.preForAll(methodObject5458, this, zeroLengthObjectArray);
         Method var10001 = methodObject5458;
         this.delegate.clearDefines();
         this.postForAll(var10001);
      } catch (SQLException var2) {
         this.onErrorVoidForAll(methodObject5458, var2);
      }
   }

   public Clob getClob(String arg0) throws SQLException {
      try {
         super.preForAll(methodObject5190, this, arg0);
         return (Clob)this.postForAll(methodObject5190, this.proxyFactory.proxyForCache((Object)this.delegate.getClob(arg0), this, this.proxyCache, methodObject5190));
      } catch (SQLException var3) {
         return (Clob)this.postForAll(methodObject5190, this.onErrorForAll(methodObject5190, var3));
      }
   }

   public void setNClobAtName(String arg0, NClob arg1) throws SQLException {
      try {
         super.preForAll(methodObject5451, this, arg0, arg1);
         Method var10001 = methodObject5451;
         this.delegate.setNClobAtName(arg0, arg1 instanceof _Proxy_ ? (NClob)((_Proxy_)arg1)._getDelegate_() : arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject5451, var4);
      }
   }

   public int getInt(String arg0) throws SQLException {
      try {
         super.preForAll(methodObject5165, this, arg0);
         return (Integer)this.postForAll(methodObject5165, this.delegate.getInt(arg0));
      } catch (SQLException var3) {
         return (Integer)this.postForAll(methodObject5165, this.onErrorForAll(methodObject5165, var3));
      }
   }

   public void setSTRUCT(String arg0, STRUCT arg1) throws SQLException {
      try {
         super.preForAll(methodObject5143, this, arg0, arg1);
         Method var10001 = methodObject5143;
         this.delegate.setSTRUCT(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject5143, var4);
      }
   }

   public boolean execute(String arg0, int[] arg1) throws SQLException {
      try {
         super.preForExecute(methodObject5294, this, arg0, arg1);
         return (Boolean)this.postForAll(methodObject5294, this.delegate.execute(arg0, arg1));
      } catch (SQLException var4) {
         return (Boolean)this.postForAll(methodObject5294, this.onErrorForAll(methodObject5294, var4));
      }
   }

   public void setRowIdAtName(String arg0, RowId arg1) throws SQLException {
      try {
         super.preForAll(methodObject5455, this, arg0, arg1);
         Method var10001 = methodObject5455;
         this.delegate.setRowIdAtName(arg0, arg1 instanceof _Proxy_ ? (RowId)((_Proxy_)arg1)._getDelegate_() : arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject5455, var4);
      }
   }

   public byte[] privateGetBytes(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject5047, this, arg0);
         return (byte[])this.postForAll(methodObject5047, (Object)this.delegate.privateGetBytes(arg0));
      } catch (SQLException var3) {
         return (byte[])this.postForAll(methodObject5047, this.onErrorForAll(methodObject5047, var3));
      }
   }

   public void setBLOBAtName(String arg0, BLOB arg1) throws SQLException {
      try {
         super.preForAll(methodObject5413, this, arg0, arg1);
         Method var10001 = methodObject5413;
         this.delegate.setBLOBAtName(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject5413, var4);
      }
   }

   public void setExecuteBatch(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject5485, this, arg0);
         Method var10001 = methodObject5485;
         this.delegate.setExecuteBatch(arg0);
         this.postForAll(var10001);
      } catch (SQLException var3) {
         this.onErrorVoidForAll(methodObject5485, var3);
      }
   }

   public Time getTime(String arg0, Calendar arg1) throws SQLException {
      try {
         super.preForAll(methodObject5204, this, arg0, arg1);
         return (Time)this.postForAll(methodObject5204, (Object)this.delegate.getTime(arg0, arg1));
      } catch (SQLException var4) {
         return (Time)this.postForAll(methodObject5204, this.onErrorForAll(methodObject5204, var4));
      }
   }

   public void setByte(String arg0, byte arg1) throws SQLException {
      try {
         super.preForAll(methodObject5050, this, arg0, arg1);
         Method var10001 = methodObject5050;
         this.delegate.setByte(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject5050, var4);
      }
   }

   public void setNull(int arg0, int arg1, String arg2) throws SQLException {
      try {
         super.preForAll(methodObject5281, this, arg0, arg1, arg2);
         Method var10001 = methodObject5281;
         this.delegate.setNull(arg0, arg1, arg2);
         this.postForAll(var10001);
      } catch (SQLException var5) {
         this.onErrorVoidForAll(methodObject5281, var5);
      }
   }

   public void registerOutParameterChars(int arg0, int arg1, int arg2, int arg3) throws SQLException {
      try {
         super.preForAll(methodObject5115, this, arg0, arg1, arg2, arg3);
         Method var10001 = methodObject5115;
         this.delegate.registerOutParameterChars(arg0, arg1, arg2, arg3);
         this.postForAll(var10001);
      } catch (SQLException var6) {
         this.onErrorVoidForAll(methodObject5115, var6);
      }
   }

   public void setTimestamp(String arg0, Timestamp arg1) throws SQLException {
      try {
         super.preForAll(methodObject5056, this, arg0, arg1);
         Method var10001 = methodObject5056;
         this.delegate.setTimestamp(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject5056, var4);
      }
   }

   public void setClob(String arg0, Reader arg1, long arg2) throws SQLException {
      try {
         super.preForAll(methodObject5226, this, arg0, arg1, arg2);
         Method var10001 = methodObject5226;
         this.delegate.setClob(arg0, arg1, arg2);
         this.postForAll(var10001);
      } catch (SQLException var6) {
         this.onErrorVoidForAll(methodObject5226, var6);
      }
   }

   public void setCursorAtName(String arg0, ResultSet arg1) throws SQLException {
      try {
         super.preForAll(methodObject5402, this, arg0, arg1);
         Method var10001 = methodObject5402;
         this.delegate.setCursorAtName(arg0, arg1 instanceof _Proxy_ ? (ResultSet)((_Proxy_)arg1)._getDelegate_() : arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject5402, var4);
      }
   }

   public InputStream getBinaryStream(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject5061, this, arg0);
         return (InputStream)this.postForAll(methodObject5061, (Object)this.delegate.getBinaryStream(arg0));
      } catch (SQLException var3) {
         return (InputStream)this.postForAll(methodObject5061, this.onErrorForAll(methodObject5061, var3));
      }
   }

   public Datum[] getOraclePlsqlIndexTable(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject5113, this, arg0);
         return (Datum[])this.postForAll(methodObject5113, (Object)this.delegate.getOraclePlsqlIndexTable(arg0));
      } catch (SQLException var3) {
         return (Datum[])this.postForAll(methodObject5113, this.onErrorForAll(methodObject5113, var3));
      }
   }

   public void defineColumnType(int arg0, int arg1, String arg2) throws SQLException {
      try {
         super.preForAll(methodObject5462, this, arg0, arg1, arg2);
         Method var10001 = methodObject5462;
         this.delegate.defineColumnType(arg0, arg1, arg2);
         this.postForAll(var10001);
      } catch (SQLException var5) {
         this.onErrorVoidForAll(methodObject5462, var5);
      }
   }

   public void defineColumnType(int arg0, int arg1) throws SQLException {
      try {
         super.preForAll(methodObject5459, this, arg0, arg1);
         Method var10001 = methodObject5459;
         this.delegate.defineColumnType(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject5459, var4);
      }
   }

   public void setLong(int arg0, long arg1) throws SQLException {
      try {
         super.preForAll(methodObject5241, this, arg0, arg1);
         Method var10001 = methodObject5241;
         this.delegate.setLong(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var5) {
         this.onErrorVoidForAll(methodObject5241, var5);
      }
   }

   public void setINTERVALYM(int arg0, INTERVALYM arg1) throws SQLException {
      try {
         super.preForAll(methodObject5367, this, arg0, arg1);
         Method var10001 = methodObject5367;
         this.delegate.setINTERVALYM(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject5367, var4);
      }
   }

   public void setStructDescriptor(int arg0, StructDescriptor arg1) throws SQLException {
      try {
         super.preForAll(methodObject5374, this, arg0, arg1);
         Method var10001 = methodObject5374;
         this.delegate.setStructDescriptor(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject5374, var4);
      }
   }

   public void setBytesForBlobAtName(String arg0, byte[] arg1) throws SQLException {
      try {
         super.preForAll(methodObject5424, this, arg0, arg1);
         Method var10001 = methodObject5424;
         this.delegate.setBytesForBlobAtName(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject5424, var4);
      }
   }

   public void cancel() throws SQLException {
      try {
         super.preForAll(methodObject5296, this, zeroLengthObjectArray);
         Method var10001 = methodObject5296;
         this.delegate.cancel();
         this.postForAll(var10001);
      } catch (SQLException var2) {
         this.onErrorVoidForAll(methodObject5296, var2);
      }
   }

   public String getString(String arg0) throws SQLException {
      try {
         super.preForAll(methodObject5181, this, arg0);
         return (String)this.postForAll(methodObject5181, (Object)this.delegate.getString(arg0));
      } catch (SQLException var3) {
         return (String)this.postForAll(methodObject5181, this.onErrorForAll(methodObject5181, var3));
      }
   }

   public void registerOutParameter(String arg0, int arg1, int arg2) throws SQLException {
      try {
         super.preForAll(methodObject5215, this, arg0, arg1, arg2);
         Method var10001 = methodObject5215;
         this.delegate.registerOutParameter(arg0, arg1, arg2);
         this.postForAll(var10001);
      } catch (SQLException var5) {
         this.onErrorVoidForAll(methodObject5215, var5);
      }
   }

   public void setARRAY(String arg0, ARRAY arg1) throws SQLException {
      try {
         super.preForAll(methodObject5140, this, arg0, arg1);
         Method var10001 = methodObject5140;
         this.delegate.setARRAY(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject5140, var4);
      }
   }

   public void setRowPrefetch(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject5466, this, arg0);
         Method var10001 = methodObject5466;
         this.delegate.setRowPrefetch(arg0);
         this.postForAll(var10001);
      } catch (SQLException var3) {
         this.onErrorVoidForAll(methodObject5466, var3);
      }
   }

   public DATE getDATE(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject5099, this, arg0);
         return (DATE)this.postForAll(methodObject5099, (Object)this.delegate.getDATE(arg0));
      } catch (SQLException var3) {
         return (DATE)this.postForAll(methodObject5099, this.onErrorForAll(methodObject5099, var3));
      }
   }

   public void setAsciiStream(String arg0, InputStream arg1) throws SQLException {
      try {
         super.preForSetStreams(methodObject5219, this, arg0, arg1);
         Method var10001 = methodObject5219;
         this.delegate.setAsciiStream(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject5219, var4);
      }
   }

   public byte getByte(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject5160, this, arg0);
         return (Byte)this.postForAll(methodObject5160, this.delegate.getByte(arg0));
      } catch (SQLException var3) {
         return (Byte)this.postForAll(methodObject5160, this.onErrorForAll(methodObject5160, var3));
      }
   }

   public void setNClob(String arg0, NClob arg1) throws SQLException {
      try {
         super.preForAll(methodObject5230, this, arg0, arg1);
         Method var10001 = methodObject5230;
         this.delegate.setNClob(arg0, arg1 instanceof _Proxy_ ? (NClob)((_Proxy_)arg1)._getDelegate_() : arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject5230, var4);
      }
   }

   public void setBinaryFloat(int arg0, BINARY_FLOAT arg1) throws SQLException {
      try {
         super.preForAll(methodObject5351, this, arg0, arg1);
         Method var10001 = methodObject5351;
         this.delegate.setBinaryFloat(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject5351, var4);
      }
   }

   public void setBytes(String arg0, byte[] arg1) throws SQLException {
      try {
         super.preForAll(methodObject5059, this, arg0, arg1);
         Method var10001 = methodObject5059;
         this.delegate.setBytes(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject5059, var4);
      }
   }

   public void setINTERVALDS(String arg0, INTERVALDS arg1) throws SQLException {
      try {
         super.preForAll(methodObject5136, this, arg0, arg1);
         Method var10001 = methodObject5136;
         this.delegate.setINTERVALDS(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject5136, var4);
      }
   }

   public void setLobPrefetchSize(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject5468, this, arg0);
         Method var10001 = methodObject5468;
         this.delegate.setLobPrefetchSize(arg0);
         this.postForAll(var10001);
      } catch (SQLException var3) {
         this.onErrorVoidForAll(methodObject5468, var3);
      }
   }

   public Array getArray(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject5174, this, arg0);
         return (Array)this.postForAll(methodObject5174, this.proxyFactory.proxyForCache((Object)this.delegate.getArray(arg0), this, this.proxyCache, methodObject5174));
      } catch (SQLException var3) {
         return (Array)this.postForAll(methodObject5174, this.onErrorForAll(methodObject5174, var3));
      }
   }

   public void setRAWAtName(String arg0, RAW arg1) throws SQLException {
      try {
         super.preForAll(methodObject5409, this, arg0, arg1);
         Method var10001 = methodObject5409;
         this.delegate.setRAWAtName(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject5409, var4);
      }
   }

   public void setFixedCHAR(int arg0, String arg1) throws SQLException {
      try {
         super.preForAll(methodObject5356, this, arg0, arg1);
         Method var10001 = methodObject5356;
         this.delegate.setFixedCHAR(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject5356, var4);
      }
   }

   public void setEscapeProcessing(boolean arg0) throws SQLException {
      try {
         super.preForAll(methodObject5328, this, arg0);
         Method var10001 = methodObject5328;
         this.delegate.setEscapeProcessing(arg0);
         this.postForAll(var10001);
      } catch (SQLException var3) {
         this.onErrorVoidForAll(methodObject5328, var3);
      }
   }

   public void registerOutParameterAtName(String arg0, int arg1) throws SQLException {
      try {
         super.preForAll(methodObject5149, this, arg0, arg1);
         Method var10001 = methodObject5149;
         this.delegate.registerOutParameterAtName(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject5149, var4);
      }
   }

   public void setFetchSize(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject5301, this, arg0);
         Method var10001 = methodObject5301;
         this.delegate.setFetchSize(arg0);
         this.postForAll(var10001);
      } catch (SQLException var3) {
         this.onErrorVoidForAll(methodObject5301, var3);
      }
   }

   public void setStringAtName(String arg0, String arg1) throws SQLException {
      try {
         super.preForAll(methodObject5399, this, arg0, arg1);
         Method var10001 = methodObject5399;
         this.delegate.setStringAtName(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject5399, var4);
      }
   }

   public short getShort(String arg0) throws SQLException {
      try {
         super.preForAll(methodObject5163, this, arg0);
         return (Short)this.postForAll(methodObject5163, this.delegate.getShort(arg0));
      } catch (SQLException var3) {
         return (Short)this.postForAll(methodObject5163, this.onErrorForAll(methodObject5163, var3));
      }
   }

   public void setTimestampAtName(String arg0, Timestamp arg1) throws SQLException {
      try {
         super.preForAll(methodObject5429, this, arg0, arg1);
         Method var10001 = methodObject5429;
         this.delegate.setTimestampAtName(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject5429, var4);
      }
   }

   public void registerOutParameter(String arg0, int arg1, String arg2) throws SQLException {
      try {
         super.preForAll(methodObject5216, this, arg0, arg1, arg2);
         Method var10001 = methodObject5216;
         this.delegate.registerOutParameter(arg0, arg1, arg2);
         this.postForAll(var10001);
      } catch (SQLException var5) {
         this.onErrorVoidForAll(methodObject5216, var5);
      }
   }

   public void setTIMESTAMPTZ(int arg0, TIMESTAMPTZ arg1) throws SQLException {
      try {
         super.preForAll(methodObject5370, this, arg0, arg1);
         Method var10001 = methodObject5370;
         this.delegate.setTIMESTAMPTZ(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject5370, var4);
      }
   }

   public void setBlob(String arg0, InputStream arg1) throws SQLException {
      try {
         super.preForAll(methodObject5225, this, arg0, arg1);
         Method var10001 = methodObject5225;
         this.delegate.setBlob(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject5225, var4);
      }
   }

   public void setROWIDAtName(String arg0, ROWID arg1) throws SQLException {
      try {
         super.preForAll(methodObject5403, this, arg0, arg1);
         Method var10001 = methodObject5403;
         this.delegate.setROWIDAtName(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject5403, var4);
      }
   }

   public void setCursorName(String arg0) throws SQLException {
      try {
         super.preForAll(methodObject5327, this, arg0);
         Method var10001 = methodObject5327;
         this.delegate.setCursorName(arg0);
         this.postForAll(var10001);
      } catch (SQLException var3) {
         this.onErrorVoidForAll(methodObject5327, var3);
      }
   }

   public void setTime(int arg0, Time arg1, Calendar arg2) throws SQLException {
      try {
         super.preForAll(methodObject5290, this, arg0, arg1, arg2);
         Method var10001 = methodObject5290;
         this.delegate.setTime(arg0, arg1, arg2);
         this.postForAll(var10001);
      } catch (SQLException var5) {
         this.onErrorVoidForAll(methodObject5290, var5);
      }
   }

   public String getNString(String arg0) throws SQLException {
      try {
         super.preForAll(methodObject5196, this, arg0);
         return (String)this.postForAll(methodObject5196, (Object)this.delegate.getNString(arg0));
      } catch (SQLException var3) {
         return (String)this.postForAll(methodObject5196, this.onErrorForAll(methodObject5196, var3));
      }
   }

   public void setBlobAtName(String arg0, InputStream arg1, long arg2) throws SQLException {
      try {
         super.preForAll(methodObject5415, this, arg0, arg1, arg2);
         Method var10001 = methodObject5415;
         this.delegate.setBlobAtName(arg0, arg1, arg2);
         this.postForAll(var10001);
      } catch (SQLException var6) {
         this.onErrorVoidForAll(methodObject5415, var6);
      }
   }

   public void setByte(int arg0, byte arg1) throws SQLException {
      try {
         super.preForAll(methodObject5237, this, arg0, arg1);
         Method var10001 = methodObject5237;
         this.delegate.setByte(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject5237, var4);
      }
   }

   public void setBytesForBlob(int arg0, byte[] arg1) throws SQLException {
      try {
         super.preForAll(methodObject5355, this, arg0, arg1);
         Method var10001 = methodObject5355;
         this.delegate.setBytesForBlob(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject5355, var4);
      }
   }

   public void setBinaryStream(String arg0, InputStream arg1, long arg2) throws SQLException {
      try {
         super.preForSetStreams(methodObject5222, this, arg0, arg1, arg2);
         Method var10001 = methodObject5222;
         this.delegate.setBinaryStream(arg0, arg1, arg2);
         this.postForAll(var10001);
      } catch (SQLException var6) {
         this.onErrorVoidForAll(methodObject5222, var6);
      }
   }

   public void registerOutParameterAtName(String arg0, int arg1, String arg2) throws SQLException {
      try {
         super.preForAll(methodObject5151, this, arg0, arg1, arg2);
         Method var10001 = methodObject5151;
         this.delegate.registerOutParameterAtName(arg0, arg1, arg2);
         this.postForAll(var10001);
      } catch (SQLException var5) {
         this.onErrorVoidForAll(methodObject5151, var5);
      }
   }

   public void setRefAtName(String arg0, Ref arg1) throws SQLException {
      try {
         super.preForAll(methodObject5439, this, arg0, arg1);
         Method var10001 = methodObject5439;
         this.delegate.setRefAtName(arg0, arg1 instanceof _Proxy_ ? (Ref)((_Proxy_)arg1)._getDelegate_() : arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject5439, var4);
      }
   }

   public void setBinaryDouble(int arg0, double arg1) throws SQLException {
      try {
         super.preForAll(methodObject5352, this, arg0, arg1);
         Method var10001 = methodObject5352;
         this.delegate.setBinaryDouble(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var5) {
         this.onErrorVoidForAll(methodObject5352, var5);
      }
   }

   public void setSTRUCT(int arg0, STRUCT arg1) throws SQLException {
      try {
         super.preForAll(methodObject5375, this, arg0, arg1);
         Method var10001 = methodObject5375;
         this.delegate.setSTRUCT(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject5375, var4);
      }
   }

   public void setArray(String arg0, Array arg1) throws SQLException {
      try {
         super.preForAll(methodObject5067, this, arg0, arg1);
         Method var10001 = methodObject5067;
         this.delegate.setArray(arg0, arg1 instanceof _Proxy_ ? (Array)((_Proxy_)arg1)._getDelegate_() : arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject5067, var4);
      }
   }

   public void setINTERVALYM(String arg0, INTERVALYM arg1) throws SQLException {
      try {
         super.preForAll(methodObject5135, this, arg0, arg1);
         Method var10001 = methodObject5135;
         this.delegate.setINTERVALYM(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject5135, var4);
      }
   }

   public void setRowId(int arg0, RowId arg1) throws SQLException {
      try {
         super.preForAll(methodObject5286, this, arg0, arg1);
         Method var10001 = methodObject5286;
         this.delegate.setRowId(arg0, arg1 instanceof _Proxy_ ? (RowId)((_Proxy_)arg1)._getDelegate_() : arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject5286, var4);
      }
   }

   public Blob getBlob(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject5209, this, arg0);
         return (Blob)this.postForAll(methodObject5209, this.proxyFactory.proxyForCache((Object)this.delegate.getBlob(arg0), this, this.proxyCache, methodObject5209));
      } catch (SQLException var3) {
         return (Blob)this.postForAll(methodObject5209, this.onErrorForAll(methodObject5209, var3));
      }
   }

   public void setNUMBERAtName(String arg0, NUMBER arg1) throws SQLException {
      try {
         super.preForAll(methodObject5412, this, arg0, arg1);
         Method var10001 = methodObject5412;
         this.delegate.setNUMBERAtName(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject5412, var4);
      }
   }

   public Object getObject(String arg0) throws SQLException {
      try {
         super.preForAll(methodObject5154, this, arg0);
         return this.postForAll(methodObject5154, this.proxyFactory.proxyForCache(this.delegate.getObject(arg0), this, this.proxyCache, methodObject5154));
      } catch (SQLException var3) {
         return this.postForAll(methodObject5154, this.onErrorForAll(methodObject5154, var3));
      }
   }

   public int getMaxRows() throws SQLException {
      try {
         super.preForAll(methodObject5317, this, zeroLengthObjectArray);
         return (Integer)this.postForAll(methodObject5317, this.delegate.getMaxRows());
      } catch (SQLException var2) {
         return (Integer)this.postForAll(methodObject5317, this.onErrorForAll(methodObject5317, var2));
      }
   }

   public void addBatch() throws SQLException {
      try {
         super.preForAll(methodObject5258, this, zeroLengthObjectArray);
         Method var10001 = methodObject5258;
         this.delegate.addBatch();
         this.postForAll(var10001);
      } catch (SQLException var2) {
         this.onErrorVoidForAll(methodObject5258, var2);
      }
   }

   public void setURLAtName(String arg0, URL arg1) throws SQLException {
      try {
         super.preForAll(methodObject5442, this, arg0, arg1);
         Method var10001 = methodObject5442;
         this.delegate.setURLAtName(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject5442, var4);
      }
   }

   public void setNCharacterStreamAtName(String arg0, Reader arg1) throws SQLException {
      try {
         super.preForSetStreams(methodObject5344, this, arg0, arg1);
         Method var10001 = methodObject5344;
         this.delegate.setNCharacterStreamAtName(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject5344, var4);
      }
   }

   public RowId getRowId(String arg0) throws SQLException {
      try {
         super.preForAll(methodObject5198, this, arg0);
         return (RowId)this.postForAll(methodObject5198, this.proxyFactory.proxyForCache((Object)this.delegate.getRowId(arg0), this, this.proxyCache, methodObject5198));
      } catch (SQLException var3) {
         return (RowId)this.postForAll(methodObject5198, this.onErrorForAll(methodObject5198, var3));
      }
   }

   public void setFloat(String arg0, float arg1) throws SQLException {
      try {
         super.preForAll(methodObject5052, this, arg0, arg1);
         Method var10001 = methodObject5052;
         this.delegate.setFloat(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject5052, var4);
      }
   }

   public void setCustomDatumAtName(String arg0, CustomDatum arg1) throws SQLException {
      try {
         super.preForAll(methodObject5436, this, arg0, arg1);
         Method var10001 = methodObject5436;
         this.delegate.setCustomDatumAtName(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject5436, var4);
      }
   }

   public void setOracleObjectAtName(String arg0, Datum arg1) throws SQLException {
      try {
         super.preForAll(methodObject5441, this, arg0, arg1);
         Method var10001 = methodObject5441;
         this.delegate.setOracleObjectAtName(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject5441, var4);
      }
   }

   public void setINTERVALYMAtName(String arg0, INTERVALYM arg1) throws SQLException {
      try {
         super.preForAll(methodObject5431, this, arg0, arg1);
         Method var10001 = methodObject5431;
         this.delegate.setINTERVALYMAtName(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject5431, var4);
      }
   }

   public void registerOutParameter(int arg0, int arg1, String arg2) throws SQLException {
      try {
         super.preForAll(methodObject5213, this, arg0, arg1, arg2);
         Method var10001 = methodObject5213;
         this.delegate.registerOutParameter(arg0, arg1, arg2);
         this.postForAll(var10001);
      } catch (SQLException var5) {
         this.onErrorVoidForAll(methodObject5213, var5);
      }
   }

   public void registerOutParameter(int arg0, int arg1) throws SQLException {
      try {
         super.preForAll(methodObject5211, this, arg0, arg1);
         Method var10001 = methodObject5211;
         this.delegate.registerOutParameter(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject5211, var4);
      }
   }

   public int getQueryTimeout() throws SQLException {
      try {
         super.preForAll(methodObject5320, this, zeroLengthObjectArray);
         return (Integer)this.postForAll(methodObject5320, this.delegate.getQueryTimeout());
      } catch (SQLException var2) {
         return (Integer)this.postForAll(methodObject5320, this.onErrorForAll(methodObject5320, var2));
      }
   }

   public int getstatementType() {
      super.preForAll(methodObject5491, this, zeroLengthObjectArray);
      return (Integer)this.postForAll(methodObject5491, this.delegate.getstatementType());
   }

   public void setSQLXML(int arg0, SQLXML arg1) throws SQLException {
      try {
         super.preForAll(methodObject5287, this, arg0, arg1);
         Method var10001 = methodObject5287;
         this.delegate.setSQLXML(arg0, arg1 instanceof _Proxy_ ? (SQLXML)((_Proxy_)arg1)._getDelegate_() : arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject5287, var4);
      }
   }

   public void setBfile(String arg0, BFILE arg1) throws SQLException {
      try {
         super.preForAll(methodObject5134, this, arg0, arg1);
         Method var10001 = methodObject5134;
         this.delegate.setBfile(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject5134, var4);
      }
   }

   public void setDoubleAtName(String arg0, double arg1) throws SQLException {
      try {
         super.preForAll(methodObject5393, this, arg0, arg1);
         Method var10001 = methodObject5393;
         this.delegate.setDoubleAtName(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var5) {
         this.onErrorVoidForAll(methodObject5393, var5);
      }
   }

   public int executeUpdate(String arg0) throws SQLException {
      try {
         super.preForExecuteUpdate(methodObject5311, this, arg0);
         return (Integer)this.postForAll(methodObject5311, this.delegate.executeUpdate(arg0));
      } catch (SQLException var3) {
         return (Integer)this.postForAll(methodObject5311, this.onErrorForAll(methodObject5311, var3));
      }
   }

   public void setArrayAtName(String arg0, Array arg1) throws SQLException {
      try {
         super.preForAll(methodObject5404, this, arg0, arg1);
         Method var10001 = methodObject5404;
         this.delegate.setArrayAtName(arg0, arg1 instanceof _Proxy_ ? (Array)((_Proxy_)arg1)._getDelegate_() : arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject5404, var4);
      }
   }

   public Array getArray(String arg0) throws SQLException {
      try {
         super.preForAll(methodObject5175, this, arg0);
         return (Array)this.postForAll(methodObject5175, this.proxyFactory.proxyForCache((Object)this.delegate.getArray(arg0), this, this.proxyCache, methodObject5175));
      } catch (SQLException var3) {
         return (Array)this.postForAll(methodObject5175, this.onErrorForAll(methodObject5175, var3));
      }
   }

   public void setObject(String arg0, Object arg1, int arg2, int arg3) throws SQLException {
      try {
         super.preForSetObjects(methodObject5083, this, arg0, arg1, arg2, arg3);
         Method var10001 = methodObject5083;
         this.delegate.setObject(arg0, arg1 instanceof _Proxy_ ? (Object)((_Proxy_)arg1)._getDelegate_() : arg1, arg2, arg3);
         this.postForAll(var10001);
      } catch (SQLException var6) {
         this.onErrorVoidForAll(methodObject5083, var6);
      }
   }

   public Object getObject(int arg0, Class arg1) throws SQLException {
      try {
         super.preForAll(methodObject5156, this, arg0, arg1);
         return this.postForAll(methodObject5156, this.proxyFactory.proxyForCache(this.delegate.getObject(arg0, arg1), this, this.proxyCache, methodObject5156));
      } catch (SQLException var4) {
         return this.postForAll(methodObject5156, this.onErrorForAll(methodObject5156, var4));
      }
   }

   public Object getObject(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject5152, this, arg0);
         return this.postForAll(methodObject5152, this.proxyFactory.proxyForCache(this.delegate.getObject(arg0), this, this.proxyCache, methodObject5152));
      } catch (SQLException var3) {
         return this.postForAll(methodObject5152, this.onErrorForAll(methodObject5152, var3));
      }
   }

   public void setUnicodeStreamAtName(String arg0, InputStream arg1, int arg2) throws SQLException {
      try {
         super.preForSetStreams(methodObject5345, this, arg0, arg1, arg2);
         Method var10001 = methodObject5345;
         this.delegate.setUnicodeStreamAtName(arg0, arg1, arg2);
         this.postForAll(var10001);
      } catch (SQLException var5) {
         this.onErrorVoidForAll(methodObject5345, var5);
      }
   }

   public void setOPAQUEAtName(String arg0, OPAQUE arg1) throws SQLException {
      try {
         super.preForAll(methodObject5406, this, arg0, arg1);
         Method var10001 = methodObject5406;
         this.delegate.setOPAQUEAtName(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject5406, var4);
      }
   }

   public Blob getBlob(String arg0) throws SQLException {
      try {
         super.preForAll(methodObject5210, this, arg0);
         return (Blob)this.postForAll(methodObject5210, this.proxyFactory.proxyForCache((Object)this.delegate.getBlob(arg0), this, this.proxyCache, methodObject5210));
      } catch (SQLException var3) {
         return (Blob)this.postForAll(methodObject5210, this.onErrorForAll(methodObject5210, var3));
      }
   }

   public void setROWID(int arg0, ROWID arg1) throws SQLException {
      try {
         super.preForAll(methodObject5358, this, arg0, arg1);
         Method var10001 = methodObject5358;
         this.delegate.setROWID(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject5358, var4);
      }
   }

   public TIMESTAMPLTZ getTIMESTAMPLTZ(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject5110, this, arg0);
         return (TIMESTAMPLTZ)this.postForAll(methodObject5110, (Object)this.delegate.getTIMESTAMPLTZ(arg0));
      } catch (SQLException var3) {
         return (TIMESTAMPLTZ)this.postForAll(methodObject5110, this.onErrorForAll(methodObject5110, var3));
      }
   }

   public void setBinaryFloat(int arg0, float arg1) throws SQLException {
      try {
         super.preForAll(methodObject5350, this, arg0, arg1);
         Method var10001 = methodObject5350;
         this.delegate.setBinaryFloat(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject5350, var4);
      }
   }

   public void setCheckBindTypes(boolean arg0) {
      super.preForAll(methodObject5483, this, arg0);
      Method var10001 = methodObject5483;
      this.delegate.setCheckBindTypes(arg0);
      this.postForAll(var10001);
   }

   public void exitExplicitCacheToClose() throws SQLException {
      try {
         super.preForAll(methodObject5481, this, zeroLengthObjectArray);
         Method var10001 = methodObject5481;
         this.delegate.exitExplicitCacheToClose();
         this.postForAll(var10001);
      } catch (SQLException var2) {
         this.onErrorVoidForAll(methodObject5481, var2);
      }
   }

   public BigDecimal getBigDecimal(String arg0, int arg1) throws SQLException {
      try {
         super.preForAll(methodObject5045, this, arg0, arg1);
         return (BigDecimal)this.postForAll(methodObject5045, (Object)this.delegate.getBigDecimal(arg0, arg1));
      } catch (SQLException var4) {
         return (BigDecimal)this.postForAll(methodObject5045, this.onErrorForAll(methodObject5045, var4));
      }
   }

   public void setRefTypeAtName(String arg0, REF arg1) throws SQLException {
      try {
         super.preForAll(methodObject5438, this, arg0, arg1);
         Method var10001 = methodObject5438;
         this.delegate.setRefTypeAtName(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject5438, var4);
      }
   }

   public boolean execute(String arg0) throws SQLException {
      try {
         super.preForExecute(methodObject5292, this, arg0);
         return (Boolean)this.postForAll(methodObject5292, this.delegate.execute(arg0));
      } catch (SQLException var3) {
         return (Boolean)this.postForAll(methodObject5292, this.onErrorForAll(methodObject5292, var3));
      }
   }

   public void setAsciiStream(String arg0, InputStream arg1, int arg2) throws SQLException {
      try {
         super.preForSetStreams(methodObject5072, this, arg0, arg1, arg2);
         Method var10001 = methodObject5072;
         this.delegate.setAsciiStream(arg0, arg1, arg2);
         this.postForAll(var10001);
      } catch (SQLException var5) {
         this.onErrorVoidForAll(methodObject5072, var5);
      }
   }

   public void setDate(int arg0, Date arg1) throws SQLException {
      try {
         super.preForAll(methodObject5272, this, arg0, arg1);
         Method var10001 = methodObject5272;
         this.delegate.setDate(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject5272, var4);
      }
   }

   public void setNUMBER(String arg0, NUMBER arg1) throws SQLException {
      try {
         super.preForAll(methodObject5130, this, arg0, arg1);
         Method var10001 = methodObject5130;
         this.delegate.setNUMBER(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject5130, var4);
      }
   }

   public int creationState() {
      super.preForAll(methodObject5470, this, zeroLengthObjectArray);
      return (Integer)this.postForAll(methodObject5470, this.delegate.creationState());
   }

   public void setRAW(String arg0, RAW arg1) throws SQLException {
      try {
         super.preForAll(methodObject5127, this, arg0, arg1);
         Method var10001 = methodObject5127;
         this.delegate.setRAW(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject5127, var4);
      }
   }

   public ARRAY getARRAY(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject5090, this, arg0);
         return (ARRAY)this.postForAll(methodObject5090, (Object)this.delegate.getARRAY(arg0));
      } catch (SQLException var3) {
         return (ARRAY)this.postForAll(methodObject5090, this.onErrorForAll(methodObject5090, var3));
      }
   }

   public void setObject(int arg0, Object arg1, int arg2, int arg3) throws SQLException {
      try {
         super.preForSetObjects(methodObject5284, this, arg0, arg1, arg2, arg3);
         Method var10001 = methodObject5284;
         this.delegate.setObject(arg0, arg1 instanceof _Proxy_ ? (Object)((_Proxy_)arg1)._getDelegate_() : arg1, arg2, arg3);
         this.postForAll(var10001);
      } catch (SQLException var6) {
         this.onErrorVoidForAll(methodObject5284, var6);
      }
   }

   public void setShort(String arg0, short arg1) throws SQLException {
      try {
         super.preForAll(methodObject5055, this, arg0, arg1);
         Method var10001 = methodObject5055;
         this.delegate.setShort(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject5055, var4);
      }
   }

   public void setOPAQUE(int arg0, OPAQUE arg1) throws SQLException {
      try {
         super.preForAll(methodObject5373, this, arg0, arg1);
         Method var10001 = methodObject5373;
         this.delegate.setOPAQUE(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject5373, var4);
      }
   }

   public REF getREF(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject5103, this, arg0);
         return (REF)this.postForAll(methodObject5103, (Object)this.delegate.getREF(arg0));
      } catch (SQLException var3) {
         return (REF)this.postForAll(methodObject5103, this.onErrorForAll(methodObject5103, var3));
      }
   }

   public void setDouble(int arg0, double arg1) throws SQLException {
      try {
         super.preForAll(methodObject5238, this, arg0, arg1);
         Method var10001 = methodObject5238;
         this.delegate.setDouble(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var5) {
         this.onErrorVoidForAll(methodObject5238, var5);
      }
   }

   public void setClob(String arg0, Reader arg1) throws SQLException {
      try {
         super.preForAll(methodObject5227, this, arg0, arg1);
         Method var10001 = methodObject5227;
         this.delegate.setClob(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject5227, var4);
      }
   }

   public void registerOutParameter(int arg0, int arg1, int arg2, int arg3) throws SQLException {
      try {
         super.preForAll(methodObject5068, this, arg0, arg1, arg2, arg3);
         Method var10001 = methodObject5068;
         this.delegate.registerOutParameter(arg0, arg1, arg2, arg3);
         this.postForAll(var10001);
      } catch (SQLException var6) {
         this.onErrorVoidForAll(methodObject5068, var6);
      }
   }

   public INTERVALYM getINTERVALYM(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject5106, this, arg0);
         return (INTERVALYM)this.postForAll(methodObject5106, (Object)this.delegate.getINTERVALYM(arg0));
      } catch (SQLException var3) {
         return (INTERVALYM)this.postForAll(methodObject5106, this.onErrorForAll(methodObject5106, var3));
      }
   }

   public void setBlob(int arg0, InputStream arg1) throws SQLException {
      try {
         super.preForAll(methodObject5268, this, arg0, arg1);
         Method var10001 = methodObject5268;
         this.delegate.setBlob(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject5268, var4);
      }
   }

   public void setSQLXML(String arg0, SQLXML arg1) throws SQLException {
      try {
         super.preForAll(methodObject5235, this, arg0, arg1);
         Method var10001 = methodObject5235;
         this.delegate.setSQLXML(arg0, arg1 instanceof _Proxy_ ? (SQLXML)((_Proxy_)arg1)._getDelegate_() : arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject5235, var4);
      }
   }

   public void setBinaryFloatAtName(String arg0, float arg1) throws SQLException {
      try {
         super.preForAll(methodObject5394, this, arg0, arg1);
         Method var10001 = methodObject5394;
         this.delegate.setBinaryFloatAtName(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject5394, var4);
      }
   }

   public void exitImplicitCacheToClose() throws SQLException {
      try {
         super.preForAll(methodObject5480, this, zeroLengthObjectArray);
         Method var10001 = methodObject5480;
         this.delegate.exitImplicitCacheToClose();
         this.postForAll(var10001);
      } catch (SQLException var2) {
         this.onErrorVoidForAll(methodObject5480, var2);
      }
   }

   public void registerOutParameterAtName(String arg0, int arg1, int arg2) throws SQLException {
      try {
         super.preForAll(methodObject5150, this, arg0, arg1, arg2);
         Method var10001 = methodObject5150;
         this.delegate.registerOutParameterAtName(arg0, arg1, arg2);
         this.postForAll(var10001);
      } catch (SQLException var5) {
         this.onErrorVoidForAll(methodObject5150, var5);
      }
   }

   public OracleStatement.SqlKind getSqlKind() throws SQLException {
      try {
         super.preForAll(methodObject5492, this, zeroLengthObjectArray);
         return (OracleStatement.SqlKind)this.postForAll(methodObject5492, (Object)this.delegate.getSqlKind());
      } catch (SQLException var2) {
         return (OracleStatement.SqlKind)this.postForAll(methodObject5492, this.onErrorForAll(methodObject5492, var2));
      }
   }

   public void setInternalBytes(int arg0, byte[] arg1, int arg2) throws SQLException {
      try {
         super.preForAll(methodObject5475, this, arg0, arg1, arg2);
         Method var10001 = methodObject5475;
         this.delegate.setInternalBytes(arg0, arg1, arg2);
         this.postForAll(var10001);
      } catch (SQLException var5) {
         this.onErrorVoidForAll(methodObject5475, var5);
      }
   }

   public void setFixedString(boolean arg0) {
      super.preForAll(methodObject5486, this, arg0);
      Method var10001 = methodObject5486;
      this.delegate.setFixedString(arg0);
      this.postForAll(var10001);
   }

   public void clearBatch() throws SQLException {
      try {
         super.preForAll(methodObject5308, this, zeroLengthObjectArray);
         Method var10001 = methodObject5308;
         this.delegate.clearBatch();
         this.postForAll(var10001);
      } catch (SQLException var2) {
         this.onErrorVoidForAll(methodObject5308, var2);
      }
   }

   public void registerOutParameter(String arg0, int arg1, int arg2, int arg3) throws SQLException {
      try {
         super.preForAll(methodObject5069, this, arg0, arg1, arg2, arg3);
         Method var10001 = methodObject5069;
         this.delegate.registerOutParameter(arg0, arg1, arg2, arg3);
         this.postForAll(var10001);
      } catch (SQLException var6) {
         this.onErrorVoidForAll(methodObject5069, var6);
      }
   }

   public void setNullAtName(String arg0, int arg1, String arg2) throws SQLException {
      try {
         super.preForAll(methodObject5385, this, arg0, arg1, arg2);
         Method var10001 = methodObject5385;
         this.delegate.setNullAtName(arg0, arg1, arg2);
         this.postForAll(var10001);
      } catch (SQLException var5) {
         this.onErrorVoidForAll(methodObject5385, var5);
      }
   }

   public TIMESTAMPTZ getTIMESTAMPTZ(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject5109, this, arg0);
         return (TIMESTAMPTZ)this.postForAll(methodObject5109, (Object)this.delegate.getTIMESTAMPTZ(arg0));
      } catch (SQLException var3) {
         return (TIMESTAMPTZ)this.postForAll(methodObject5109, this.onErrorForAll(methodObject5109, var3));
      }
   }

   public void setCLOB(int arg0, CLOB arg1) throws SQLException {
      try {
         super.preForAll(methodObject5364, this, arg0, arg1);
         Method var10001 = methodObject5364;
         this.delegate.setCLOB(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject5364, var4);
      }
   }

   public void setFixedCHAR(String arg0, String arg1) throws SQLException {
      try {
         super.preForAll(methodObject5124, this, arg0, arg1);
         Method var10001 = methodObject5124;
         this.delegate.setFixedCHAR(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject5124, var4);
      }
   }

   public void setCharacterStream(int arg0, Reader arg1, long arg2) throws SQLException {
      try {
         super.preForSetStreams(methodObject5256, this, arg0, arg1, arg2);
         Method var10001 = methodObject5256;
         this.delegate.setCharacterStream(arg0, arg1, arg2);
         this.postForAll(var10001);
      } catch (SQLException var6) {
         this.onErrorVoidForAll(methodObject5256, var6);
      }
   }

   public int getcacheState() {
      super.preForAll(methodObject5490, this, zeroLengthObjectArray);
      return (Integer)this.postForAll(methodObject5490, this.delegate.getcacheState());
   }

   public int getFetchSize() throws SQLException {
      try {
         super.preForAll(methodObject5299, this, zeroLengthObjectArray);
         return (Integer)this.postForAll(methodObject5299, this.delegate.getFetchSize());
      } catch (SQLException var2) {
         return (Integer)this.postForAll(methodObject5299, this.onErrorForAll(methodObject5299, var2));
      }
   }

   public BigDecimal getBigDecimal(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject5187, this, arg0);
         return (BigDecimal)this.postForAll(methodObject5187, (Object)this.delegate.getBigDecimal(arg0));
      } catch (SQLException var3) {
         return (BigDecimal)this.postForAll(methodObject5187, this.onErrorForAll(methodObject5187, var3));
      }
   }

   public void setCLOB(String arg0, CLOB arg1) throws SQLException {
      try {
         super.preForAll(methodObject5132, this, arg0, arg1);
         Method var10001 = methodObject5132;
         this.delegate.setCLOB(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject5132, var4);
      }
   }

   public String getOriginalSql() throws SQLException {
      try {
         super.preForAll(methodObject5482, this, zeroLengthObjectArray);
         return (String)this.postForAll(methodObject5482, (Object)this.delegate.getOriginalSql());
      } catch (SQLException var2) {
         return (String)this.postForAll(methodObject5482, this.onErrorForAll(methodObject5482, var2));
      }
   }

   public void setInt(int arg0, int arg1) throws SQLException {
      try {
         super.preForAll(methodObject5240, this, arg0, arg1);
         Method var10001 = methodObject5240;
         this.delegate.setInt(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject5240, var4);
      }
   }

   public void setNClob(String arg0, Reader arg1, long arg2) throws SQLException {
      try {
         super.preForAll(methodObject5231, this, arg0, arg1, arg2);
         Method var10001 = methodObject5231;
         this.delegate.setNClob(arg0, arg1, arg2);
         this.postForAll(var10001);
      } catch (SQLException var6) {
         this.onErrorVoidForAll(methodObject5231, var6);
      }
   }

   public Timestamp getTimestamp(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject5205, this, arg0);
         return (Timestamp)this.postForAll(methodObject5205, (Object)this.delegate.getTimestamp(arg0));
      } catch (SQLException var3) {
         return (Timestamp)this.postForAll(methodObject5205, this.onErrorForAll(methodObject5205, var3));
      }
   }

   public void setSnapshotSCN(long arg0) throws SQLException {
      try {
         super.preForAll(methodObject5495, this, arg0);
         Method var10001 = methodObject5495;
         this.delegate.setSnapshotSCN(arg0);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject5495, var4);
      }
   }

   public void setRef(int arg0, Ref arg1) throws SQLException {
      try {
         super.preForAll(methodObject5285, this, arg0, arg1);
         Method var10001 = methodObject5285;
         this.delegate.setRef(arg0, arg1 instanceof _Proxy_ ? (Ref)((_Proxy_)arg1)._getDelegate_() : arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject5285, var4);
      }
   }

   public String[] getRegisteredTableNames() throws SQLException {
      try {
         super.preForAll(methodObject5472, this, zeroLengthObjectArray);
         return (String[])this.postForAll(methodObject5472, (Object)this.delegate.getRegisteredTableNames());
      } catch (SQLException var2) {
         return (String[])this.postForAll(methodObject5472, this.onErrorForAll(methodObject5472, var2));
      }
   }

   public void setTIMESTAMPTZAtName(String arg0, TIMESTAMPTZ arg1) throws SQLException {
      try {
         super.preForAll(methodObject5434, this, arg0, arg1);
         Method var10001 = methodObject5434;
         this.delegate.setTIMESTAMPTZAtName(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject5434, var4);
      }
   }

   public void clearParameters() throws SQLException {
      try {
         super.preForAll(methodObject5263, this, zeroLengthObjectArray);
         Method var10001 = methodObject5263;
         this.delegate.clearParameters();
         this.postForAll(var10001);
      } catch (SQLException var2) {
         this.onErrorVoidForAll(methodObject5263, var2);
      }
   }

   public void setDateAtName(String arg0, Date arg1) throws SQLException {
      try {
         super.preForAll(methodObject5425, this, arg0, arg1);
         Method var10001 = methodObject5425;
         this.delegate.setDateAtName(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject5425, var4);
      }
   }

   public int executeUpdate(String arg0, int arg1) throws SQLException {
      try {
         super.preForExecuteUpdate(methodObject5312, this, arg0, arg1);
         return (Integer)this.postForAll(methodObject5312, this.delegate.executeUpdate(arg0, arg1));
      } catch (SQLException var4) {
         return (Integer)this.postForAll(methodObject5312, this.onErrorForAll(methodObject5312, var4));
      }
   }

   public boolean execute() throws SQLException {
      try {
         super.preForExecute(methodObject5246, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject5246, this.delegate.execute());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject5246, this.onErrorForAll(methodObject5246, var2));
      }
   }

   public void setNUMBER(int arg0, NUMBER arg1) throws SQLException {
      try {
         super.preForAll(methodObject5362, this, arg0, arg1);
         Method var10001 = methodObject5362;
         this.delegate.setNUMBER(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject5362, var4);
      }
   }

   public void setBinaryDouble(int arg0, BINARY_DOUBLE arg1) throws SQLException {
      try {
         super.preForAll(methodObject5353, this, arg0, arg1);
         Method var10001 = methodObject5353;
         this.delegate.setBinaryDouble(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject5353, var4);
      }
   }

   public void setTimestamp(int arg0, Timestamp arg1) throws SQLException {
      try {
         super.preForAll(methodObject5243, this, arg0, arg1);
         Method var10001 = methodObject5243;
         this.delegate.setTimestamp(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject5243, var4);
      }
   }

   public CLOB getCLOB(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject5095, this, arg0);
         return (CLOB)this.postForAll(methodObject5095, (Object)this.delegate.getCLOB(arg0));
      } catch (SQLException var3) {
         return (CLOB)this.postForAll(methodObject5095, this.onErrorForAll(methodObject5095, var3));
      }
   }

   public void setOracleObject(int arg0, Datum arg1) throws SQLException {
      try {
         super.preForAll(methodObject5380, this, arg0, arg1);
         Method var10001 = methodObject5380;
         this.delegate.setOracleObject(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject5380, var4);
      }
   }

   public void registerReturnParameter(int arg0, int arg1, String arg2) throws SQLException {
      try {
         super.preForAll(methodObject5450, this, arg0, arg1, arg2);
         Method var10001 = methodObject5450;
         this.delegate.registerReturnParameter(arg0, arg1, arg2);
         this.postForAll(var10001);
      } catch (SQLException var5) {
         this.onErrorVoidForAll(methodObject5450, var5);
      }
   }

   public void setSTRUCTAtName(String arg0, STRUCT arg1) throws SQLException {
      try {
         super.preForAll(methodObject5408, this, arg0, arg1);
         Method var10001 = methodObject5408;
         this.delegate.setSTRUCTAtName(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject5408, var4);
      }
   }

   public URL getURL(String arg0) throws SQLException {
      try {
         super.preForAll(methodObject5177, this, arg0);
         return (URL)this.postForAll(methodObject5177, (Object)this.delegate.getURL(arg0));
      } catch (SQLException var3) {
         return (URL)this.postForAll(methodObject5177, this.onErrorForAll(methodObject5177, var3));
      }
   }

   public float getFloat(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject5168, this, arg0);
         return (Float)this.postForAll(methodObject5168, this.delegate.getFloat(arg0));
      } catch (SQLException var3) {
         return (Float)this.postForAll(methodObject5168, this.onErrorForAll(methodObject5168, var3));
      }
   }

   public ResultSet executeQuery(String arg0) throws SQLException {
      try {
         super.preForExecuteQuery(methodObject5305, this, arg0);
         return this.postForExecuteQuery(methodObject5305, (ResultSet)this.proxyFactory.proxyForCache((Object)this.delegate.executeQuery(arg0), this, this.proxyCache, methodObject5305));
      } catch (SQLException var3) {
         return this.postForExecuteQuery(methodObject5305, (ResultSet)this.onErrorForAll(methodObject5305, var3));
      }
   }

   public void setNClobAtName(String arg0, Reader arg1, long arg2) throws SQLException {
      try {
         super.preForAll(methodObject5452, this, arg0, arg1, arg2);
         Method var10001 = methodObject5452;
         this.delegate.setNClobAtName(arg0, arg1, arg2);
         this.postForAll(var10001);
      } catch (SQLException var6) {
         this.onErrorVoidForAll(methodObject5452, var6);
      }
   }

   public short getShort(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject5162, this, arg0);
         return (Short)this.postForAll(methodObject5162, this.delegate.getShort(arg0));
      } catch (SQLException var3) {
         return (Short)this.postForAll(methodObject5162, this.onErrorForAll(methodObject5162, var3));
      }
   }

   public void setBooleanAtName(String arg0, boolean arg1) throws SQLException {
      try {
         super.preForAll(methodObject5387, this, arg0, arg1);
         Method var10001 = methodObject5387;
         this.delegate.setBooleanAtName(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject5387, var4);
      }
   }

   public void setIntAtName(String arg0, int arg1) throws SQLException {
      try {
         super.preForAll(methodObject5390, this, arg0, arg1);
         Method var10001 = methodObject5390;
         this.delegate.setIntAtName(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject5390, var4);
      }
   }

   public int getExecuteBatch() {
      super.preForAll(methodObject5384, this, zeroLengthObjectArray);
      return (Integer)this.postForAll(methodObject5384, this.delegate.getExecuteBatch());
   }

   public void setNullAtName(String arg0, int arg1) throws SQLException {
      try {
         super.preForAll(methodObject5386, this, arg0, arg1);
         Method var10001 = methodObject5386;
         this.delegate.setNullAtName(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject5386, var4);
      }
   }

   public void setBinaryFloat(String arg0, float arg1) throws SQLException {
      try {
         super.preForAll(methodObject5119, this, arg0, arg1);
         Method var10001 = methodObject5119;
         this.delegate.setBinaryFloat(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject5119, var4);
      }
   }

   public void setFetchDirection(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject5300, this, arg0);
         Method var10001 = methodObject5300;
         this.delegate.setFetchDirection(arg0);
         this.postForAll(var10001);
      } catch (SQLException var3) {
         this.onErrorVoidForAll(methodObject5300, var3);
      }
   }

   public void setClobAtName(String arg0, Clob arg1) throws SQLException {
      try {
         super.preForAll(methodObject5418, this, arg0, arg1);
         Method var10001 = methodObject5418;
         this.delegate.setClobAtName(arg0, arg1 instanceof _Proxy_ ? (Clob)((_Proxy_)arg1)._getDelegate_() : arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject5418, var4);
      }
   }

   public void setNull(int arg0, int arg1) throws SQLException {
      try {
         super.preForAll(methodObject5280, this, arg0, arg1);
         Method var10001 = methodObject5280;
         this.delegate.setNull(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject5280, var4);
      }
   }

   public void setREF(int arg0, REF arg1) throws SQLException {
      try {
         super.preForAll(methodObject5379, this, arg0, arg1);
         Method var10001 = methodObject5379;
         this.delegate.setREF(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject5379, var4);
      }
   }

   public boolean getserverCursor() {
      super.preForAll(methodObject5489, this, zeroLengthObjectArray);
      return (Boolean)this.postForAll(methodObject5489, this.delegate.getserverCursor());
   }

   public Time getTime(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject5201, this, arg0);
         return (Time)this.postForAll(methodObject5201, (Object)this.delegate.getTime(arg0));
      } catch (SQLException var3) {
         return (Time)this.postForAll(methodObject5201, this.onErrorForAll(methodObject5201, var3));
      }
   }

   public void setBlob(String arg0, Blob arg1) throws SQLException {
      try {
         super.preForAll(methodObject5077, this, arg0, arg1);
         Method var10001 = methodObject5077;
         this.delegate.setBlob(arg0, arg1 instanceof _Proxy_ ? (Blob)((_Proxy_)arg1)._getDelegate_() : arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject5077, var4);
      }
   }

   public void setURL(int arg0, URL arg1) throws SQLException {
      try {
         super.preForAll(methodObject5245, this, arg0, arg1);
         Method var10001 = methodObject5245;
         this.delegate.setURL(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject5245, var4);
      }
   }

   public float getFloat(String arg0) throws SQLException {
      try {
         super.preForAll(methodObject5169, this, arg0);
         return (Float)this.postForAll(methodObject5169, this.delegate.getFloat(arg0));
      } catch (SQLException var3) {
         return (Float)this.postForAll(methodObject5169, this.onErrorForAll(methodObject5169, var3));
      }
   }

   public InputStream getBinaryStream(String arg0) throws SQLException {
      try {
         super.preForAll(methodObject5062, this, arg0);
         return (InputStream)this.postForAll(methodObject5062, (Object)this.delegate.getBinaryStream(arg0));
      } catch (SQLException var3) {
         return (InputStream)this.postForAll(methodObject5062, this.onErrorForAll(methodObject5062, var3));
      }
   }

   public void setTIMESTAMPAtName(String arg0, TIMESTAMP arg1) throws SQLException {
      try {
         super.preForAll(methodObject5433, this, arg0, arg1);
         Method var10001 = methodObject5433;
         this.delegate.setTIMESTAMPAtName(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject5433, var4);
      }
   }

   public Reader getCharacterStream(String arg0) throws SQLException {
      try {
         super.preForAll(methodObject5046, this, arg0);
         return (Reader)this.postForAll(methodObject5046, (Object)this.delegate.getCharacterStream(arg0));
      } catch (SQLException var3) {
         return (Reader)this.postForAll(methodObject5046, this.onErrorForAll(methodObject5046, var3));
      }
   }

   public Object getPlsqlIndexTable(int arg0, Class arg1) throws SQLException {
      try {
         super.preForAll(methodObject5112, this, arg0, arg1);
         return this.postForAll(methodObject5112, this.proxyFactory.proxyForCache(this.delegate.getPlsqlIndexTable(arg0, arg1), this, this.proxyCache, methodObject5112));
      } catch (SQLException var4) {
         return this.postForAll(methodObject5112, this.onErrorForAll(methodObject5112, var4));
      }
   }

   public InputStream getAsciiStream(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject5060, this, arg0);
         return (InputStream)this.postForAll(methodObject5060, (Object)this.delegate.getAsciiStream(arg0));
      } catch (SQLException var3) {
         return (InputStream)this.postForAll(methodObject5060, this.onErrorForAll(methodObject5060, var3));
      }
   }

   public boolean isPoolable() throws SQLException {
      try {
         super.preForAll(methodObject5326, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject5326, this.delegate.isPoolable());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject5326, this.onErrorForAll(methodObject5326, var2));
      }
   }

   public Timestamp getTimestamp(String arg0, Calendar arg1) throws SQLException {
      try {
         super.preForAll(methodObject5208, this, arg0, arg1);
         return (Timestamp)this.postForAll(methodObject5208, (Object)this.delegate.getTimestamp(arg0, arg1));
      } catch (SQLException var4) {
         return (Timestamp)this.postForAll(methodObject5208, this.onErrorForAll(methodObject5208, var4));
      }
   }

   public void setTimeAtName(String arg0, Time arg1) throws SQLException {
      try {
         super.preForAll(methodObject5427, this, arg0, arg1);
         Method var10001 = methodObject5427;
         this.delegate.setTimeAtName(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject5427, var4);
      }
   }

   public int getUpdateCount() throws SQLException {
      try {
         super.preForAll(methodObject5324, this, zeroLengthObjectArray);
         return (Integer)this.postForAll(methodObject5324, this.delegate.getUpdateCount());
      } catch (SQLException var2) {
         return (Integer)this.postForAll(methodObject5324, this.onErrorForAll(methodObject5324, var2));
      }
   }

   public void setCharacterStream(int arg0, Reader arg1, int arg2) throws SQLException {
      try {
         super.preForSetStreams(methodObject5255, this, arg0, arg1, arg2);
         Method var10001 = methodObject5255;
         this.delegate.setCharacterStream(arg0, arg1, arg2);
         this.postForAll(var10001);
      } catch (SQLException var5) {
         this.onErrorVoidForAll(methodObject5255, var5);
      }
   }

   public void setObjectAtName(String arg0, Object arg1, int arg2, int arg3) throws SQLException {
      try {
         super.preForSetObjects(methodObject5346, this, arg0, arg1, arg2, arg3);
         Method var10001 = methodObject5346;
         this.delegate.setObjectAtName(arg0, arg1 instanceof _Proxy_ ? (Object)((_Proxy_)arg1)._getDelegate_() : arg1, arg2, arg3);
         this.postForAll(var10001);
      } catch (SQLException var6) {
         this.onErrorVoidForAll(methodObject5346, var6);
      }
   }

   public Reader getNCharacterStream(String arg0) throws SQLException {
      try {
         super.preForAll(methodObject5192, this, arg0);
         return (Reader)this.postForAll(methodObject5192, (Object)this.delegate.getNCharacterStream(arg0));
      } catch (SQLException var3) {
         return (Reader)this.postForAll(methodObject5192, this.onErrorForAll(methodObject5192, var3));
      }
   }

   public Object getPlsqlIndexTable(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject5111, this, arg0);
         return this.postForAll(methodObject5111, this.proxyFactory.proxyForCache(this.delegate.getPlsqlIndexTable(arg0), this, this.proxyCache, methodObject5111));
      } catch (SQLException var3) {
         return this.postForAll(methodObject5111, this.onErrorForAll(methodObject5111, var3));
      }
   }

   public void setArray(int arg0, Array arg1) throws SQLException {
      try {
         super.preForAll(methodObject5249, this, arg0, arg1);
         Method var10001 = methodObject5249;
         this.delegate.setArray(arg0, arg1 instanceof _Proxy_ ? (Array)((_Proxy_)arg1)._getDelegate_() : arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject5249, var4);
      }
   }

   public byte[] getBytes(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject5172, this, arg0);
         return (byte[])this.postForAll(methodObject5172, (Object)this.delegate.getBytes(arg0));
      } catch (SQLException var3) {
         return (byte[])this.postForAll(methodObject5172, this.onErrorForAll(methodObject5172, var3));
      }
   }

   public void setDATE(String arg0, DATE arg1) throws SQLException {
      try {
         super.preForAll(methodObject5129, this, arg0, arg1);
         Method var10001 = methodObject5129;
         this.delegate.setDATE(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject5129, var4);
      }
   }

   public void setObject(int arg0, Object arg1, int arg2) throws SQLException {
      try {
         super.preForSetObjects(methodObject5282, this, arg0, arg1, arg2);
         Method var10001 = methodObject5282;
         this.delegate.setObject(arg0, arg1 instanceof _Proxy_ ? (Object)((_Proxy_)arg1)._getDelegate_() : arg1, arg2);
         this.postForAll(var10001);
      } catch (SQLException var5) {
         this.onErrorVoidForAll(methodObject5282, var5);
      }
   }

   public void setBinaryFloatAtName(String arg0, BINARY_FLOAT arg1) throws SQLException {
      try {
         super.preForAll(methodObject5395, this, arg0, arg1);
         Method var10001 = methodObject5395;
         this.delegate.setBinaryFloatAtName(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject5395, var4);
      }
   }

   public void setTIMESTAMPTZ(String arg0, TIMESTAMPTZ arg1) throws SQLException {
      try {
         super.preForAll(methodObject5138, this, arg0, arg1);
         Method var10001 = methodObject5138;
         this.delegate.setTIMESTAMPTZ(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject5138, var4);
      }
   }

   public void setBFILE(String arg0, BFILE arg1) throws SQLException {
      try {
         super.preForAll(methodObject5133, this, arg0, arg1);
         Method var10001 = methodObject5133;
         this.delegate.setBFILE(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject5133, var4);
      }
   }

   public int[] executeBatch() throws SQLException {
      try {
         super.preForBatches(methodObject5310, this, zeroLengthObjectArray);
         return (int[])this.postForAll(methodObject5310, (Object)this.delegate.executeBatch());
      } catch (SQLException var2) {
         return (int[])this.postForAll(methodObject5310, this.onErrorForAll(methodObject5310, var2));
      }
   }

   public void setTimeAtName(String arg0, Time arg1, Calendar arg2) throws SQLException {
      try {
         super.preForAll(methodObject5428, this, arg0, arg1, arg2);
         Method var10001 = methodObject5428;
         this.delegate.setTimeAtName(arg0, arg1, arg2);
         this.postForAll(var10001);
      } catch (SQLException var5) {
         this.onErrorVoidForAll(methodObject5428, var5);
      }
   }

   public long getLong(String arg0) throws SQLException {
      try {
         super.preForAll(methodObject5167, this, arg0);
         return (Long)this.postForAll(methodObject5167, this.delegate.getLong(arg0));
      } catch (SQLException var3) {
         return (Long)this.postForAll(methodObject5167, this.onErrorForAll(methodObject5167, var3));
      }
   }

   public void defineParameterType(int arg0, int arg1, int arg2) throws SQLException {
      try {
         super.preForAll(methodObject5383, this, arg0, arg1, arg2);
         Method var10001 = methodObject5383;
         this.delegate.defineParameterType(arg0, arg1, arg2);
         this.postForAll(var10001);
      } catch (SQLException var5) {
         this.onErrorVoidForAll(methodObject5383, var5);
      }
   }

   public Reader getNCharacterStream(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject5191, this, arg0);
         return (Reader)this.postForAll(methodObject5191, (Object)this.delegate.getNCharacterStream(arg0));
      } catch (SQLException var3) {
         return (Reader)this.postForAll(methodObject5191, this.onErrorForAll(methodObject5191, var3));
      }
   }

   public void setBigDecimal(int arg0, BigDecimal arg1) throws SQLException {
      try {
         super.preForAll(methodObject5265, this, arg0, arg1);
         Method var10001 = methodObject5265;
         this.delegate.setBigDecimal(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject5265, var4);
      }
   }

   public void setCHAR(int arg0, CHAR arg1) throws SQLException {
      try {
         super.preForAll(methodObject5360, this, arg0, arg1);
         Method var10001 = methodObject5360;
         this.delegate.setCHAR(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject5360, var4);
      }
   }

   public void setACProxy(Object arg0) {
      super.preForAll(methodObject5496, this, arg0);
      Method var10001 = methodObject5496;
      this.delegate.setACProxy(arg0 instanceof _Proxy_ ? (Object)((_Proxy_)arg0)._getDelegate_() : arg0);
      this.postForAll(var10001);
   }

   public void setCursor(int arg0, ResultSet arg1) throws SQLException {
      try {
         super.preForAll(methodObject5357, this, arg0, arg1);
         Method var10001 = methodObject5357;
         this.delegate.setCursor(arg0, arg1 instanceof _Proxy_ ? (ResultSet)((_Proxy_)arg1)._getDelegate_() : arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject5357, var4);
      }
   }

   public InputStream getAsciiStream(String arg0) throws SQLException {
      try {
         super.preForAll(methodObject5044, this, arg0);
         return (InputStream)this.postForAll(methodObject5044, (Object)this.delegate.getAsciiStream(arg0));
      } catch (SQLException var3) {
         return (InputStream)this.postForAll(methodObject5044, this.onErrorForAll(methodObject5044, var3));
      }
   }

   public boolean getBoolean(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject5158, this, arg0);
         return (Boolean)this.postForAll(methodObject5158, this.delegate.getBoolean(arg0));
      } catch (SQLException var3) {
         return (Boolean)this.postForAll(methodObject5158, this.onErrorForAll(methodObject5158, var3));
      }
   }

   public OracleParameterMetaData OracleGetParameterMetaData() throws SQLException {
      try {
         super.preForAll(methodObject5447, this, zeroLengthObjectArray);
         return (OracleParameterMetaData)this.postForAll(methodObject5447, this.proxyFactory.proxyForCache((Object)this.delegate.OracleGetParameterMetaData(), this, this.proxyCache, methodObject5447));
      } catch (SQLException var2) {
         return (OracleParameterMetaData)this.postForAll(methodObject5447, this.onErrorForAll(methodObject5447, var2));
      }
   }

   public void setBinaryDouble(String arg0, double arg1) throws SQLException {
      try {
         super.preForAll(methodObject5121, this, arg0, arg1);
         Method var10001 = methodObject5121;
         this.delegate.setBinaryDouble(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var5) {
         this.onErrorVoidForAll(methodObject5121, var5);
      }
   }

   public void setORADataAtName(String arg0, ORAData arg1) throws SQLException {
      try {
         super.preForAll(methodObject5437, this, arg0, arg1);
         Method var10001 = methodObject5437;
         this.delegate.setORADataAtName(arg0, arg1 instanceof _Proxy_ ? (ORAData)((_Proxy_)arg1)._getDelegate_() : arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject5437, var4);
      }
   }

   public void setBinaryStream(String arg0, InputStream arg1, int arg2) throws SQLException {
      try {
         super.preForSetStreams(methodObject5075, this, arg0, arg1, arg2);
         Method var10001 = methodObject5075;
         this.delegate.setBinaryStream(arg0, arg1, arg2);
         this.postForAll(var10001);
      } catch (SQLException var5) {
         this.onErrorVoidForAll(methodObject5075, var5);
      }
   }

   public boolean isClosed() throws SQLException {
      try {
         super.preForAll(methodObject5304, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject5304, this.delegate.isClosed());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject5304, this.onErrorForAll(methodObject5304, var2));
      }
   }

   public void setBinaryFloat(String arg0, BINARY_FLOAT arg1) throws SQLException {
      try {
         super.preForAll(methodObject5118, this, arg0, arg1);
         Method var10001 = methodObject5118;
         this.delegate.setBinaryFloat(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject5118, var4);
      }
   }

   public void registerOutParameter(int arg0, int arg1, int arg2) throws SQLException {
      try {
         super.preForAll(methodObject5212, this, arg0, arg1, arg2);
         Method var10001 = methodObject5212;
         this.delegate.registerOutParameter(arg0, arg1, arg2);
         this.postForAll(var10001);
      } catch (SQLException var5) {
         this.onErrorVoidForAll(methodObject5212, var5);
      }
   }

   public int sendBatch() throws SQLException {
      try {
         super.preForBatches(methodObject5488, this, zeroLengthObjectArray);
         return (Integer)this.postForAll(methodObject5488, this.delegate.sendBatch());
      } catch (SQLException var2) {
         return (Integer)this.postForAll(methodObject5488, this.onErrorForAll(methodObject5488, var2));
      }
   }

   public void setDisableStmtCaching(boolean arg0) {
      super.preForAll(methodObject5446, this, arg0);
      Method var10001 = methodObject5446;
      this.delegate.setDisableStmtCaching(arg0);
      this.postForAll(var10001);
   }

   public Ref getRef(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject5178, this, arg0);
         return (Ref)this.postForAll(methodObject5178, this.proxyFactory.proxyForCache((Object)this.delegate.getRef(arg0), this, this.proxyCache, methodObject5178));
      } catch (SQLException var3) {
         return (Ref)this.postForAll(methodObject5178, this.onErrorForAll(methodObject5178, var3));
      }
   }

   public void registerBindChecksumListener(OracleStatement.BindChecksumListener arg0) throws SQLException {
      try {
         super.preForAll(methodObject5494, this, arg0);
         Method var10001 = methodObject5494;
         this.delegate.registerBindChecksumListener(arg0);
         this.postForAll(var10001);
      } catch (SQLException var3) {
         this.onErrorVoidForAll(methodObject5494, var3);
      }
   }

   public int getRowPrefetch() {
      super.preForAll(methodObject5465, this, zeroLengthObjectArray);
      return (Integer)this.postForAll(methodObject5465, this.delegate.getRowPrefetch());
   }

   public void setCharacterStreamAtName(String arg0, Reader arg1, int arg2) throws SQLException {
      try {
         super.preForSetStreams(methodObject5474, this, arg0, arg1, arg2);
         Method var10001 = methodObject5474;
         this.delegate.setCharacterStreamAtName(arg0, arg1, arg2);
         this.postForAll(var10001);
      } catch (SQLException var5) {
         this.onErrorVoidForAll(methodObject5474, var5);
      }
   }

   public void setROWID(String arg0, ROWID arg1) throws SQLException {
      try {
         super.preForAll(methodObject5126, this, arg0, arg1);
         Method var10001 = methodObject5126;
         this.delegate.setROWID(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject5126, var4);
      }
   }

   public void closeOnCompletion() throws SQLException {
      try {
         super.preForAll(methodObject5309, this, zeroLengthObjectArray);
         Method var10001 = methodObject5309;
         this.delegate.closeOnCompletion();
         this.postForAll(var10001);
      } catch (SQLException var2) {
         this.onErrorVoidForAll(methodObject5309, var2);
      }
   }

   public Time getTime(String arg0) throws SQLException {
      try {
         super.preForAll(methodObject5203, this, arg0);
         return (Time)this.postForAll(methodObject5203, (Object)this.delegate.getTime(arg0));
      } catch (SQLException var3) {
         return (Time)this.postForAll(methodObject5203, this.onErrorForAll(methodObject5203, var3));
      }
   }

   public void setCharacterStreamAtName(String arg0, Reader arg1) throws SQLException {
      try {
         super.preForSetStreams(methodObject5342, this, arg0, arg1);
         Method var10001 = methodObject5342;
         this.delegate.setCharacterStreamAtName(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject5342, var4);
      }
   }

   public Object getObject(int arg0, Map arg1) throws SQLException {
      try {
         super.preForAll(methodObject5153, this, arg0, arg1);
         return this.postForAll(methodObject5153, this.proxyFactory.proxyForCache(this.delegate.getObject(arg0, arg1), this, this.proxyCache, methodObject5153));
      } catch (SQLException var4) {
         return this.postForAll(methodObject5153, this.onErrorForAll(methodObject5153, var4));
      }
   }

   public void setORAData(String arg0, ORAData arg1) throws SQLException {
      try {
         super.preForAll(methodObject5145, this, arg0, arg1);
         Method var10001 = methodObject5145;
         this.delegate.setORAData(arg0, arg1 instanceof _Proxy_ ? (ORAData)((_Proxy_)arg1)._getDelegate_() : arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject5145, var4);
      }
   }

   public void setAsciiStreamAtName(String arg0, InputStream arg1, int arg2) throws SQLException {
      try {
         super.preForSetStreams(methodObject5335, this, arg0, arg1, arg2);
         Method var10001 = methodObject5335;
         this.delegate.setAsciiStreamAtName(arg0, arg1, arg2);
         this.postForAll(var10001);
      } catch (SQLException var5) {
         this.onErrorVoidForAll(methodObject5335, var5);
      }
   }

   public boolean getMoreResults(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject5319, this, arg0);
         return (Boolean)this.postForAll(methodObject5319, this.delegate.getMoreResults(arg0));
      } catch (SQLException var3) {
         return (Boolean)this.postForAll(methodObject5319, this.onErrorForAll(methodObject5319, var3));
      }
   }

   public void registerReturnParameter(int arg0, int arg1, int arg2) throws SQLException {
      try {
         super.preForAll(methodObject5449, this, arg0, arg1, arg2);
         Method var10001 = methodObject5449;
         this.delegate.registerReturnParameter(arg0, arg1, arg2);
         this.postForAll(var10001);
      } catch (SQLException var5) {
         this.onErrorVoidForAll(methodObject5449, var5);
      }
   }

   public void setClobAtName(String arg0, Reader arg1, long arg2) throws SQLException {
      try {
         super.preForAll(methodObject5419, this, arg0, arg1, arg2);
         Method var10001 = methodObject5419;
         this.delegate.setClobAtName(arg0, arg1, arg2);
         this.postForAll(var10001);
      } catch (SQLException var6) {
         this.onErrorVoidForAll(methodObject5419, var6);
      }
   }

   public boolean execute(String arg0, String[] arg1) throws SQLException {
      try {
         super.preForExecute(methodObject5295, this, arg0, arg1);
         return (Boolean)this.postForAll(methodObject5295, this.delegate.execute(arg0, arg1));
      } catch (SQLException var4) {
         return (Boolean)this.postForAll(methodObject5295, this.onErrorForAll(methodObject5295, var4));
      }
   }

   public Object getORAData(int arg0, ORADataFactory arg1) throws SQLException {
      try {
         super.preForAll(methodObject5097, this, arg0, arg1);
         return this.postForAll(methodObject5097, this.proxyFactory.proxyForCache(this.delegate.getORAData(arg0, arg1), this, this.proxyCache, methodObject5097));
      } catch (SQLException var4) {
         return this.postForAll(methodObject5097, this.onErrorForAll(methodObject5097, var4));
      }
   }

   public void setQueryTimeout(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject5332, this, arg0);
         Method var10001 = methodObject5332;
         this.delegate.setQueryTimeout(arg0);
         this.postForAll(var10001);
      } catch (SQLException var3) {
         this.onErrorVoidForAll(methodObject5332, var3);
      }
   }

   public void setShortAtName(String arg0, short arg1) throws SQLException {
      try {
         super.preForAll(methodObject5389, this, arg0, arg1);
         Method var10001 = methodObject5389;
         this.delegate.setShortAtName(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject5389, var4);
      }
   }

   public String getNString(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject5195, this, arg0);
         return (String)this.postForAll(methodObject5195, (Object)this.delegate.getNString(arg0));
      } catch (SQLException var3) {
         return (String)this.postForAll(methodObject5195, this.onErrorForAll(methodObject5195, var3));
      }
   }

   public void setINTERVALDSAtName(String arg0, INTERVALDS arg1) throws SQLException {
      try {
         super.preForAll(methodObject5432, this, arg0, arg1);
         Method var10001 = methodObject5432;
         this.delegate.setINTERVALDSAtName(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject5432, var4);
      }
   }

   public ROWID getROWID(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject5104, this, arg0);
         return (ROWID)this.postForAll(methodObject5104, (Object)this.delegate.getROWID(arg0));
      } catch (SQLException var3) {
         return (ROWID)this.postForAll(methodObject5104, this.onErrorForAll(methodObject5104, var3));
      }
   }

   public void setFixedCHARAtName(String arg0, String arg1) throws SQLException {
      try {
         super.preForAll(methodObject5401, this, arg0, arg1);
         Method var10001 = methodObject5401;
         this.delegate.setFixedCHARAtName(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject5401, var4);
      }
   }

   public Date getDate(String arg0) throws SQLException {
      try {
         super.preForAll(methodObject5184, this, arg0);
         return (Date)this.postForAll(methodObject5184, (Object)this.delegate.getDate(arg0));
      } catch (SQLException var3) {
         return (Date)this.postForAll(methodObject5184, this.onErrorForAll(methodObject5184, var3));
      }
   }

   public OPAQUE getOPAQUE(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject5101, this, arg0);
         return (OPAQUE)this.postForAll(methodObject5101, (Object)this.delegate.getOPAQUE(arg0));
      } catch (SQLException var3) {
         return (OPAQUE)this.postForAll(methodObject5101, this.onErrorForAll(methodObject5101, var3));
      }
   }

   public void setREF(String arg0, REF arg1) throws SQLException {
      try {
         super.preForAll(methodObject5147, this, arg0, arg1);
         Method var10001 = methodObject5147;
         this.delegate.setREF(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject5147, var4);
      }
   }

   public void setREFAtName(String arg0, REF arg1) throws SQLException {
      try {
         super.preForAll(methodObject5440, this, arg0, arg1);
         Method var10001 = methodObject5440;
         this.delegate.setREFAtName(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject5440, var4);
      }
   }

   public void setClob(int arg0, Reader arg1, long arg2) throws SQLException {
      try {
         super.preForAll(methodObject5270, this, arg0, arg1, arg2);
         Method var10001 = methodObject5270;
         this.delegate.setClob(arg0, arg1, arg2);
         this.postForAll(var10001);
      } catch (SQLException var6) {
         this.onErrorVoidForAll(methodObject5270, var6);
      }
   }

   public ResultSet getReturnResultSet() throws SQLException {
      try {
         super.preForAll(methodObject5349, this, zeroLengthObjectArray);
         return (ResultSet)this.postForAll(methodObject5349, this.proxyFactory.proxyForCache((Object)this.delegate.getReturnResultSet(), this, this.proxyCache, methodObject5349));
      } catch (SQLException var2) {
         return (ResultSet)this.postForAll(methodObject5349, this.onErrorForAll(methodObject5349, var2));
      }
   }

   public void setDATE(int arg0, DATE arg1) throws SQLException {
      try {
         super.preForAll(methodObject5361, this, arg0, arg1);
         Method var10001 = methodObject5361;
         this.delegate.setDATE(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject5361, var4);
      }
   }

   public void setNCharacterStream(String arg0, Reader arg1) throws SQLException {
      try {
         super.preForSetStreams(methodObject5229, this, arg0, arg1);
         Method var10001 = methodObject5229;
         this.delegate.setNCharacterStream(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject5229, var4);
      }
   }

   public void setCharacterStreamAtName(String arg0, Reader arg1, long arg2) throws SQLException {
      try {
         super.preForSetStreams(methodObject5341, this, arg0, arg1, arg2);
         Method var10001 = methodObject5341;
         this.delegate.setCharacterStreamAtName(arg0, arg1, arg2);
         this.postForAll(var10001);
      } catch (SQLException var6) {
         this.onErrorVoidForAll(methodObject5341, var6);
      }
   }

   public void setObject(String arg0, Object arg1, int arg2) throws SQLException {
      try {
         super.preForSetObjects(methodObject5084, this, arg0, arg1, arg2);
         Method var10001 = methodObject5084;
         this.delegate.setObject(arg0, arg1 instanceof _Proxy_ ? (Object)((_Proxy_)arg1)._getDelegate_() : arg1, arg2);
         this.postForAll(var10001);
      } catch (SQLException var5) {
         this.onErrorVoidForAll(methodObject5084, var5);
      }
   }

   public INTERVALDS getINTERVALDS(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject5107, this, arg0);
         return (INTERVALDS)this.postForAll(methodObject5107, (Object)this.delegate.getINTERVALDS(arg0));
      } catch (SQLException var3) {
         return (INTERVALDS)this.postForAll(methodObject5107, this.onErrorForAll(methodObject5107, var3));
      }
   }

   public void setDatabaseChangeRegistration(DatabaseChangeRegistration arg0) throws SQLException {
      try {
         super.preForAll(methodObject5471, this, arg0);
         Method var10001 = methodObject5471;
         this.delegate.setDatabaseChangeRegistration(arg0);
         this.postForAll(var10001);
      } catch (SQLException var3) {
         this.onErrorVoidForAll(methodObject5471, var3);
      }
   }

   public int getResultSetConcurrency() throws SQLException {
      try {
         super.preForAll(methodObject5321, this, zeroLengthObjectArray);
         return (Integer)this.postForAll(methodObject5321, this.delegate.getResultSetConcurrency());
      } catch (SQLException var2) {
         return (Integer)this.postForAll(methodObject5321, this.onErrorForAll(methodObject5321, var2));
      }
   }

   public void setTIMESTAMPLTZAtName(String arg0, TIMESTAMPLTZ arg1) throws SQLException {
      try {
         super.preForAll(methodObject5435, this, arg0, arg1);
         Method var10001 = methodObject5435;
         this.delegate.setTIMESTAMPLTZAtName(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject5435, var4);
      }
   }

   public boolean execute(String arg0, int arg1) throws SQLException {
      try {
         super.preForExecute(methodObject5293, this, arg0, arg1);
         return (Boolean)this.postForAll(methodObject5293, this.delegate.execute(arg0, arg1));
      } catch (SQLException var4) {
         return (Boolean)this.postForAll(methodObject5293, this.onErrorForAll(methodObject5293, var4));
      }
   }

   public void setBFILE(int arg0, BFILE arg1) throws SQLException {
      try {
         super.preForAll(methodObject5365, this, arg0, arg1);
         Method var10001 = methodObject5365;
         this.delegate.setBFILE(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject5365, var4);
      }
   }

   public void setStringForClobAtName(String arg0, String arg1) throws SQLException {
      try {
         super.preForAll(methodObject5400, this, arg0, arg1);
         Method var10001 = methodObject5400;
         this.delegate.setStringForClobAtName(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject5400, var4);
      }
   }

   public void setStructDescriptor(String arg0, StructDescriptor arg1) throws SQLException {
      try {
         super.preForAll(methodObject5142, this, arg0, arg1);
         Method var10001 = methodObject5142;
         this.delegate.setStructDescriptor(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject5142, var4);
      }
   }

   public void setBfile(int arg0, BFILE arg1) throws SQLException {
      try {
         super.preForAll(methodObject5366, this, arg0, arg1);
         Method var10001 = methodObject5366;
         this.delegate.setBfile(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject5366, var4);
      }
   }

   public void exitExplicitCacheToActive() throws SQLException {
      try {
         super.preForAll(methodObject5479, this, zeroLengthObjectArray);
         Method var10001 = methodObject5479;
         this.delegate.exitExplicitCacheToActive();
         this.postForAll(var10001);
      } catch (SQLException var2) {
         this.onErrorVoidForAll(methodObject5479, var2);
      }
   }

   public void enterExplicitCache() throws SQLException {
      try {
         super.preForAll(methodObject5477, this, zeroLengthObjectArray);
         Method var10001 = methodObject5477;
         this.delegate.enterExplicitCache();
         this.postForAll(var10001);
      } catch (SQLException var2) {
         this.onErrorVoidForAll(methodObject5477, var2);
      }
   }

   public void setBLOB(int arg0, BLOB arg1) throws SQLException {
      try {
         super.preForAll(methodObject5363, this, arg0, arg1);
         Method var10001 = methodObject5363;
         this.delegate.setBLOB(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject5363, var4);
      }
   }

   public void setNCharacterStream(int arg0, Reader arg1, long arg2) throws SQLException {
      try {
         super.preForSetStreams(methodObject5274, this, arg0, arg1, arg2);
         Method var10001 = methodObject5274;
         this.delegate.setNCharacterStream(arg0, arg1, arg2);
         this.postForAll(var10001);
      } catch (SQLException var6) {
         this.onErrorVoidForAll(methodObject5274, var6);
      }
   }

   public BigDecimal getBigDecimal(int arg0, int arg1) throws SQLException {
      try {
         super.preForAll(methodObject5186, this, arg0, arg1);
         return (BigDecimal)this.postForAll(methodObject5186, (Object)this.delegate.getBigDecimal(arg0, arg1));
      } catch (SQLException var4) {
         return (BigDecimal)this.postForAll(methodObject5186, this.onErrorForAll(methodObject5186, var4));
      }
   }

   public void setARRAY(int arg0, ARRAY arg1) throws SQLException {
      try {
         super.preForAll(methodObject5372, this, arg0, arg1);
         Method var10001 = methodObject5372;
         this.delegate.setARRAY(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject5372, var4);
      }
   }

   public Object getObject(int arg0, OracleDataFactory arg1) throws SQLException {
      try {
         super.preForAll(methodObject5048, this, arg0, arg1);
         return this.postForAll(methodObject5048, this.proxyFactory.proxyForCache(this.delegate.getObject(arg0, arg1), this, this.proxyCache, methodObject5048));
      } catch (SQLException var4) {
         return this.postForAll(methodObject5048, this.onErrorForAll(methodObject5048, var4));
      }
   }

   public void setNCharacterStreamAtName(String arg0, Reader arg1, long arg2) throws SQLException {
      try {
         super.preForSetStreams(methodObject5343, this, arg0, arg1, arg2);
         Method var10001 = methodObject5343;
         this.delegate.setNCharacterStreamAtName(arg0, arg1, arg2);
         this.postForAll(var10001);
      } catch (SQLException var6) {
         this.onErrorVoidForAll(methodObject5343, var6);
      }
   }

   public void setBigDecimalAtName(String arg0, BigDecimal arg1) throws SQLException {
      try {
         super.preForAll(methodObject5398, this, arg0, arg1);
         Method var10001 = methodObject5398;
         this.delegate.setBigDecimalAtName(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject5398, var4);
      }
   }

   public void setNull(String arg0, int arg1) throws SQLException {
      try {
         super.preForAll(methodObject5082, this, arg0, arg1);
         Method var10001 = methodObject5082;
         this.delegate.setNull(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject5082, var4);
      }
   }

   public CHAR getCHAR(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject5094, this, arg0);
         return (CHAR)this.postForAll(methodObject5094, (Object)this.delegate.getCHAR(arg0));
      } catch (SQLException var3) {
         return (CHAR)this.postForAll(methodObject5094, this.onErrorForAll(methodObject5094, var3));
      }
   }

   public ResultSet getResultSet() throws SQLException {
      try {
         super.preForAll(methodObject5297, this, zeroLengthObjectArray);
         return this.postForGetResultSet(methodObject5297, (ResultSet)this.proxyFactory.proxyForCache((Object)this.delegate.getResultSet(), this, this.proxyCache, methodObject5297));
      } catch (SQLException var2) {
         return this.postForGetResultSet(methodObject5297, (ResultSet)this.onErrorForAll(methodObject5297, var2));
      }
   }

   public int executeUpdate(String arg0, String[] arg1) throws SQLException {
      try {
         super.preForExecuteUpdate(methodObject5314, this, arg0, arg1);
         return (Integer)this.postForAll(methodObject5314, this.delegate.executeUpdate(arg0, arg1));
      } catch (SQLException var4) {
         return (Integer)this.postForAll(methodObject5314, this.onErrorForAll(methodObject5314, var4));
      }
   }

   public void setRowId(String arg0, RowId arg1) throws SQLException {
      try {
         super.preForAll(methodObject5234, this, arg0, arg1);
         Method var10001 = methodObject5234;
         this.delegate.setRowId(arg0, arg1 instanceof _Proxy_ ? (RowId)((_Proxy_)arg1)._getDelegate_() : arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject5234, var4);
      }
   }

   public SQLXML getSQLXML(String arg0) throws SQLException {
      try {
         super.preForAll(methodObject5200, this, arg0);
         return (SQLXML)this.postForAll(methodObject5200, this.proxyFactory.proxyForCache((Object)this.delegate.getSQLXML(arg0), this, this.proxyCache, methodObject5200));
      } catch (SQLException var3) {
         return (SQLXML)this.postForAll(methodObject5200, this.onErrorForAll(methodObject5200, var3));
      }
   }

   public void setCHAR(String arg0, CHAR arg1) throws SQLException {
      try {
         super.preForAll(methodObject5128, this, arg0, arg1);
         Method var10001 = methodObject5128;
         this.delegate.setCHAR(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject5128, var4);
      }
   }

   public Reader getCharacterStream(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject5065, this, arg0);
         return (Reader)this.postForAll(methodObject5065, (Object)this.delegate.getCharacterStream(arg0));
      } catch (SQLException var3) {
         return (Reader)this.postForAll(methodObject5065, this.onErrorForAll(methodObject5065, var3));
      }
   }

   public Date getDate(String arg0, Calendar arg1) throws SQLException {
      try {
         super.preForAll(methodObject5185, this, arg0, arg1);
         return (Date)this.postForAll(methodObject5185, (Object)this.delegate.getDate(arg0, arg1));
      } catch (SQLException var4) {
         return (Date)this.postForAll(methodObject5185, this.onErrorForAll(methodObject5185, var4));
      }
   }

   public TIMESTAMP getTIMESTAMP(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject5108, this, arg0);
         return (TIMESTAMP)this.postForAll(methodObject5108, (Object)this.delegate.getTIMESTAMP(arg0));
      } catch (SQLException var3) {
         return (TIMESTAMP)this.postForAll(methodObject5108, this.onErrorForAll(methodObject5108, var3));
      }
   }

   public BLOB getBLOB(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject5093, this, arg0);
         return (BLOB)this.postForAll(methodObject5093, (Object)this.delegate.getBLOB(arg0));
      } catch (SQLException var3) {
         return (BLOB)this.postForAll(methodObject5093, this.onErrorForAll(methodObject5093, var3));
      }
   }

   public void setFloat(int arg0, float arg1) throws SQLException {
      try {
         super.preForAll(methodObject5239, this, arg0, arg1);
         Method var10001 = methodObject5239;
         this.delegate.setFloat(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject5239, var4);
      }
   }

   public long getRegisteredQueryId() throws SQLException {
      try {
         super.preForAll(methodObject5473, this, zeroLengthObjectArray);
         return (Long)this.postForAll(methodObject5473, this.delegate.getRegisteredQueryId());
      } catch (SQLException var2) {
         return (Long)this.postForAll(methodObject5473, this.onErrorForAll(methodObject5473, var2));
      }
   }

   public void setNStringAtName(String arg0, String arg1) throws SQLException {
      try {
         super.preForAll(methodObject5454, this, arg0, arg1);
         Method var10001 = methodObject5454;
         this.delegate.setNStringAtName(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject5454, var4);
      }
   }

   public void setString(String arg0, String arg1) throws SQLException {
      try {
         super.preForAll(methodObject5070, this, arg0, arg1);
         Method var10001 = methodObject5070;
         this.delegate.setString(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject5070, var4);
      }
   }

   public void setAsciiStreamAtName(String arg0, InputStream arg1, long arg2) throws SQLException {
      try {
         super.preForSetStreams(methodObject5336, this, arg0, arg1, arg2);
         Method var10001 = methodObject5336;
         this.delegate.setAsciiStreamAtName(arg0, arg1, arg2);
         this.postForAll(var10001);
      } catch (SQLException var6) {
         this.onErrorVoidForAll(methodObject5336, var6);
      }
   }

   public void setBinaryStreamAtName(String arg0, InputStream arg1, int arg2) throws SQLException {
      try {
         super.preForSetStreams(methodObject5338, this, arg0, arg1, arg2);
         Method var10001 = methodObject5338;
         this.delegate.setBinaryStreamAtName(arg0, arg1, arg2);
         this.postForAll(var10001);
      } catch (SQLException var5) {
         this.onErrorVoidForAll(methodObject5338, var5);
      }
   }

   public NUMBER getNUMBER(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject5100, this, arg0);
         return (NUMBER)this.postForAll(methodObject5100, (Object)this.delegate.getNUMBER(arg0));
      } catch (SQLException var3) {
         return (NUMBER)this.postForAll(methodObject5100, this.onErrorForAll(methodObject5100, var3));
      }
   }

   public void setCursor(String arg0, ResultSet arg1) throws SQLException {
      try {
         super.preForAll(methodObject5125, this, arg0, arg1);
         Method var10001 = methodObject5125;
         this.delegate.setCursor(arg0, arg1 instanceof _Proxy_ ? (ResultSet)((_Proxy_)arg1)._getDelegate_() : arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject5125, var4);
      }
   }

   public RowId getRowId(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject5197, this, arg0);
         return (RowId)this.postForAll(methodObject5197, this.proxyFactory.proxyForCache((Object)this.delegate.getRowId(arg0), this, this.proxyCache, methodObject5197));
      } catch (SQLException var3) {
         return (RowId)this.postForAll(methodObject5197, this.onErrorForAll(methodObject5197, var3));
      }
   }

   public Datum getOracleObject(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject5066, this, arg0);
         return (Datum)this.postForAll(methodObject5066, (Object)this.delegate.getOracleObject(arg0));
      } catch (SQLException var3) {
         return (Datum)this.postForAll(methodObject5066, this.onErrorForAll(methodObject5066, var3));
      }
   }

   public void setTime(String arg0, Time arg1, Calendar arg2) throws SQLException {
      try {
         super.preForAll(methodObject5089, this, arg0, arg1, arg2);
         Method var10001 = methodObject5089;
         this.delegate.setTime(arg0, arg1, arg2);
         this.postForAll(var10001);
      } catch (SQLException var5) {
         this.onErrorVoidForAll(methodObject5089, var5);
      }
   }

   public boolean getMoreResults() throws SQLException {
      try {
         super.preForAll(methodObject5318, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject5318, this.delegate.getMoreResults());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject5318, this.onErrorForAll(methodObject5318, var2));
      }
   }

   public void setBinaryDoubleAtName(String arg0, double arg1) throws SQLException {
      try {
         super.preForAll(methodObject5396, this, arg0, arg1);
         Method var10001 = methodObject5396;
         this.delegate.setBinaryDoubleAtName(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var5) {
         this.onErrorVoidForAll(methodObject5396, var5);
      }
   }

   public void setBlobAtName(String arg0, InputStream arg1) throws SQLException {
      try {
         super.preForAll(methodObject5416, this, arg0, arg1);
         Method var10001 = methodObject5416;
         this.delegate.setBlobAtName(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject5416, var4);
      }
   }

   public void setTime(String arg0, Time arg1) throws SQLException {
      try {
         super.preForAll(methodObject5088, this, arg0, arg1);
         Method var10001 = methodObject5088;
         this.delegate.setTime(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject5088, var4);
      }
   }

   public void setBinaryStream(String arg0, InputStream arg1) throws SQLException {
      try {
         super.preForSetStreams(methodObject5223, this, arg0, arg1);
         Method var10001 = methodObject5223;
         this.delegate.setBinaryStream(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject5223, var4);
      }
   }

   public void setClob(int arg0, Clob arg1) throws SQLException {
      try {
         super.preForAll(methodObject5269, this, arg0, arg1);
         Method var10001 = methodObject5269;
         this.delegate.setClob(arg0, arg1 instanceof _Proxy_ ? (Clob)((_Proxy_)arg1)._getDelegate_() : arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject5269, var4);
      }
   }

   public void setTIMESTAMPLTZ(int arg0, TIMESTAMPLTZ arg1) throws SQLException {
      try {
         super.preForAll(methodObject5371, this, arg0, arg1);
         Method var10001 = methodObject5371;
         this.delegate.setTIMESTAMPLTZ(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject5371, var4);
      }
   }

   public void setBinaryStream(int arg0, InputStream arg1, long arg2) throws SQLException {
      try {
         super.preForSetStreams(methodObject5260, this, arg0, arg1, arg2);
         Method var10001 = methodObject5260;
         this.delegate.setBinaryStream(arg0, arg1, arg2);
         this.postForAll(var10001);
      } catch (SQLException var6) {
         this.onErrorVoidForAll(methodObject5260, var6);
      }
   }

   public void setTimestamp(String arg0, Timestamp arg1, Calendar arg2) throws SQLException {
      try {
         super.preForAll(methodObject5057, this, arg0, arg1, arg2);
         Method var10001 = methodObject5057;
         this.delegate.setTimestamp(arg0, arg1, arg2);
         this.postForAll(var10001);
      } catch (SQLException var5) {
         this.onErrorVoidForAll(methodObject5057, var5);
      }
   }

   public void setBoolean(int arg0, boolean arg1) throws SQLException {
      try {
         super.preForAll(methodObject5236, this, arg0, arg1);
         Method var10001 = methodObject5236;
         this.delegate.setBoolean(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject5236, var4);
      }
   }

   public void setNull(String arg0, int arg1, String arg2) throws SQLException {
      try {
         super.preForAll(methodObject5081, this, arg0, arg1, arg2);
         Method var10001 = methodObject5081;
         this.delegate.setNull(arg0, arg1, arg2);
         this.postForAll(var10001);
      } catch (SQLException var5) {
         this.onErrorVoidForAll(methodObject5081, var5);
      }
   }

   public void setBinaryStreamAtName(String arg0, InputStream arg1) throws SQLException {
      try {
         super.preForSetStreams(methodObject5340, this, arg0, arg1);
         Method var10001 = methodObject5340;
         this.delegate.setBinaryStreamAtName(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject5340, var4);
      }
   }

   public void setObjectAtName(String arg0, Object arg1, int arg2) throws SQLException {
      try {
         super.preForSetObjects(methodObject5347, this, arg0, arg1, arg2);
         Method var10001 = methodObject5347;
         this.delegate.setObjectAtName(arg0, arg1 instanceof _Proxy_ ? (Object)((_Proxy_)arg1)._getDelegate_() : arg1, arg2);
         this.postForAll(var10001);
      } catch (SQLException var5) {
         this.onErrorVoidForAll(methodObject5347, var5);
      }
   }

   public void setCharacterStream(String arg0, Reader arg1, long arg2) throws SQLException {
      try {
         super.preForSetStreams(methodObject5220, this, arg0, arg1, arg2);
         Method var10001 = methodObject5220;
         this.delegate.setCharacterStream(arg0, arg1, arg2);
         this.postForAll(var10001);
      } catch (SQLException var6) {
         this.onErrorVoidForAll(methodObject5220, var6);
      }
   }

   public void setUnicodeStream(String arg0, InputStream arg1, int arg2) throws SQLException {
      try {
         super.preForAll(methodObject5087, this, arg0, arg1, arg2);
         Method var10001 = methodObject5087;
         this.delegate.setUnicodeStream(arg0, arg1, arg2);
         this.postForAll(var10001);
      } catch (SQLException var5) {
         this.onErrorVoidForAll(methodObject5087, var5);
      }
   }

   public Object getObject(String arg0, Map arg1) throws SQLException {
      try {
         super.preForAll(methodObject5155, this, arg0, arg1);
         return this.postForAll(methodObject5155, this.proxyFactory.proxyForCache(this.delegate.getObject(arg0, arg1), this, this.proxyCache, methodObject5155));
      } catch (SQLException var4) {
         return this.postForAll(methodObject5155, this.onErrorForAll(methodObject5155, var4));
      }
   }

   public InputStream getUnicodeStream(String arg0) throws SQLException {
      try {
         super.preForAll(methodObject5064, this, arg0);
         return (InputStream)this.postForAll(methodObject5064, (Object)this.delegate.getUnicodeStream(arg0));
      } catch (SQLException var3) {
         return (InputStream)this.postForAll(methodObject5064, this.onErrorForAll(methodObject5064, var3));
      }
   }

   public Object getAnyDataEmbeddedObject(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject5098, this, arg0);
         return this.postForAll(methodObject5098, this.proxyFactory.proxyForCache(this.delegate.getAnyDataEmbeddedObject(arg0), this, this.proxyCache, methodObject5098));
      } catch (SQLException var3) {
         return this.postForAll(methodObject5098, this.onErrorForAll(methodObject5098, var3));
      }
   }

   public void exitImplicitCacheToActive() throws SQLException {
      try {
         super.preForAll(methodObject5478, this, zeroLengthObjectArray);
         Method var10001 = methodObject5478;
         this.delegate.exitImplicitCacheToActive();
         this.postForAll(var10001);
      } catch (SQLException var2) {
         this.onErrorVoidForAll(methodObject5478, var2);
      }
   }

   public void setDate(String arg0, Date arg1) throws SQLException {
      try {
         super.preForAll(methodObject5079, this, arg0, arg1);
         Method var10001 = methodObject5079;
         this.delegate.setDate(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject5079, var4);
      }
   }

   public void registerReturnParameter(int arg0, int arg1) throws SQLException {
      try {
         super.preForAll(methodObject5448, this, arg0, arg1);
         Method var10001 = methodObject5448;
         this.delegate.registerReturnParameter(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject5448, var4);
      }
   }

   public Ref getRef(String arg0) throws SQLException {
      try {
         super.preForAll(methodObject5179, this, arg0);
         return (Ref)this.postForAll(methodObject5179, this.proxyFactory.proxyForCache((Object)this.delegate.getRef(arg0), this, this.proxyCache, methodObject5179));
      } catch (SQLException var3) {
         return (Ref)this.postForAll(methodObject5179, this.onErrorForAll(methodObject5179, var3));
      }
   }

   public void setNClob(int arg0, Reader arg1) throws SQLException {
      try {
         super.preForAll(methodObject5278, this, arg0, arg1);
         Method var10001 = methodObject5278;
         this.delegate.setNClob(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject5278, var4);
      }
   }

   public ResultSet executeQuery() throws SQLException {
      try {
         super.preForExecuteQuery(methodObject5250, this, zeroLengthObjectArray);
         return this.postForExecuteQuery(methodObject5250, (ResultSet)this.proxyFactory.proxyForCache((Object)this.delegate.executeQuery(), this, this.proxyCache, methodObject5250));
      } catch (SQLException var2) {
         return this.postForExecuteQuery(methodObject5250, (ResultSet)this.onErrorForAll(methodObject5250, var2));
      }
   }

   public void setPoolable(boolean arg0) throws SQLException {
      try {
         super.preForAll(methodObject5331, this, arg0);
         Method var10001 = methodObject5331;
         this.delegate.setPoolable(arg0);
         this.postForAll(var10001);
      } catch (SQLException var3) {
         this.onErrorVoidForAll(methodObject5331, var3);
      }
   }

   public Timestamp getTimestamp(int arg0, Calendar arg1) throws SQLException {
      try {
         super.preForAll(methodObject5206, this, arg0, arg1);
         return (Timestamp)this.postForAll(methodObject5206, (Object)this.delegate.getTimestamp(arg0, arg1));
      } catch (SQLException var4) {
         return (Timestamp)this.postForAll(methodObject5206, this.onErrorForAll(methodObject5206, var4));
      }
   }

   public void setDouble(String arg0, double arg1) throws SQLException {
      try {
         super.preForAll(methodObject5051, this, arg0, arg1);
         Method var10001 = methodObject5051;
         this.delegate.setDouble(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var5) {
         this.onErrorVoidForAll(methodObject5051, var5);
      }
   }

   public void setCustomDatum(String arg0, CustomDatum arg1) throws SQLException {
      try {
         super.preForAll(methodObject5144, this, arg0, arg1);
         Method var10001 = methodObject5144;
         this.delegate.setCustomDatum(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject5144, var4);
      }
   }

   public void setRAW(int arg0, RAW arg1) throws SQLException {
      try {
         super.preForAll(methodObject5359, this, arg0, arg1);
         Method var10001 = methodObject5359;
         this.delegate.setRAW(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject5359, var4);
      }
   }

   public void setBoolean(String arg0, boolean arg1) throws SQLException {
      try {
         super.preForAll(methodObject5049, this, arg0, arg1);
         Method var10001 = methodObject5049;
         this.delegate.setBoolean(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject5049, var4);
      }
   }

   public void setCustomDatum(int arg0, CustomDatum arg1) throws SQLException {
      try {
         super.preForAll(methodObject5376, this, arg0, arg1);
         Method var10001 = methodObject5376;
         this.delegate.setCustomDatum(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject5376, var4);
      }
   }

   public BigDecimal getBigDecimal(String arg0) throws SQLException {
      try {
         super.preForAll(methodObject5188, this, arg0);
         return (BigDecimal)this.postForAll(methodObject5188, (Object)this.delegate.getBigDecimal(arg0));
      } catch (SQLException var3) {
         return (BigDecimal)this.postForAll(methodObject5188, this.onErrorForAll(methodObject5188, var3));
      }
   }

   public void setBytes(int arg0, byte[] arg1) throws SQLException {
      try {
         super.preForAll(methodObject5247, this, arg0, arg1);
         Method var10001 = methodObject5247;
         this.delegate.setBytes(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject5247, var4);
      }
   }

   public void setObjectAtName(String arg0, Object arg1) throws SQLException {
      try {
         super.preForSetObjects(methodObject5348, this, arg0, arg1);
         Method var10001 = methodObject5348;
         this.delegate.setObjectAtName(arg0, arg1 instanceof _Proxy_ ? (Object)((_Proxy_)arg1)._getDelegate_() : arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject5348, var4);
      }
   }

   public void setBytesForBlob(String arg0, byte[] arg1) throws SQLException {
      try {
         super.preForAll(methodObject5123, this, arg0, arg1);
         Method var10001 = methodObject5123;
         this.delegate.setBytesForBlob(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject5123, var4);
      }
   }

   public STRUCT getSTRUCT(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject5105, this, arg0);
         return (STRUCT)this.postForAll(methodObject5105, (Object)this.delegate.getSTRUCT(arg0));
      } catch (SQLException var3) {
         return (STRUCT)this.postForAll(methodObject5105, this.onErrorForAll(methodObject5105, var3));
      }
   }

   public SQLWarning getWarnings() throws SQLException {
      try {
         super.preForAll(methodObject5303, this, zeroLengthObjectArray);
         return (SQLWarning)this.postForAll(methodObject5303, (Object)this.delegate.getWarnings());
      } catch (SQLException var2) {
         return (SQLWarning)this.postForAll(methodObject5303, this.onErrorForAll(methodObject5303, var2));
      }
   }

   public Connection getConnection() throws SQLException {
      try {
         super.preForAll(methodObject5306, this, zeroLengthObjectArray);
         return (Connection)this.postForAll(methodObject5306, this.proxyFactory.proxyForCache((Object)this.delegate.getConnection(), this, this.proxyCache, methodObject5306));
      } catch (SQLException var2) {
         return (Connection)this.postForAll(methodObject5306, this.onErrorForAll(methodObject5306, var2));
      }
   }

   public void setCLOBAtName(String arg0, CLOB arg1) throws SQLException {
      try {
         super.preForAll(methodObject5417, this, arg0, arg1);
         Method var10001 = methodObject5417;
         this.delegate.setCLOBAtName(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject5417, var4);
      }
   }

   public void setOPAQUE(String arg0, OPAQUE arg1) throws SQLException {
      try {
         super.preForAll(methodObject5141, this, arg0, arg1);
         Method var10001 = methodObject5141;
         this.delegate.setOPAQUE(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject5141, var4);
      }
   }

   public void setBinaryStream(int arg0, InputStream arg1, int arg2) throws SQLException {
      try {
         super.preForSetStreams(methodObject5259, this, arg0, arg1, arg2);
         Method var10001 = methodObject5259;
         this.delegate.setBinaryStream(arg0, arg1, arg2);
         this.postForAll(var10001);
      } catch (SQLException var5) {
         this.onErrorVoidForAll(methodObject5259, var5);
      }
   }

   public Date getDate(int arg0, Calendar arg1) throws SQLException {
      try {
         super.preForAll(methodObject5183, this, arg0, arg1);
         return (Date)this.postForAll(methodObject5183, (Object)this.delegate.getDate(arg0, arg1));
      } catch (SQLException var4) {
         return (Date)this.postForAll(methodObject5183, this.onErrorForAll(methodObject5183, var4));
      }
   }

   public void setStringForClob(int arg0, String arg1) throws SQLException {
      try {
         super.preForAll(methodObject5354, this, arg0, arg1);
         Method var10001 = methodObject5354;
         this.delegate.setStringForClob(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject5354, var4);
      }
   }

   public void setStructDescriptorAtName(String arg0, StructDescriptor arg1) throws SQLException {
      try {
         super.preForAll(methodObject5407, this, arg0, arg1);
         Method var10001 = methodObject5407;
         this.delegate.setStructDescriptorAtName(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject5407, var4);
      }
   }

   public void registerIndexTableOutParameter(int arg0, int arg1, int arg2, int arg3) throws SQLException {
      try {
         super.preForAll(methodObject5117, this, arg0, arg1, arg2, arg3);
         Method var10001 = methodObject5117;
         this.delegate.registerIndexTableOutParameter(arg0, arg1, arg2, arg3);
         this.postForAll(var10001);
      } catch (SQLException var6) {
         this.onErrorVoidForAll(methodObject5117, var6);
      }
   }

   public void setClob(int arg0, Reader arg1) throws SQLException {
      try {
         super.preForAll(methodObject5271, this, arg0, arg1);
         Method var10001 = methodObject5271;
         this.delegate.setClob(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject5271, var4);
      }
   }

   public void close() throws SQLException {
      try {
         super.preForAll(methodObject5291, this, zeroLengthObjectArray);
         Method var10001 = methodObject5291;
         this.delegate.close();
         this.postForAll(var10001);
      } catch (SQLException var2) {
         this.onErrorVoidForClose(methodObject5291, var2);
      }
   }

   public int getInt(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject5164, this, arg0);
         return (Integer)this.postForAll(methodObject5164, this.delegate.getInt(arg0));
      } catch (SQLException var3) {
         return (Integer)this.postForAll(methodObject5164, this.onErrorForAll(methodObject5164, var3));
      }
   }

   public void setRef(String arg0, Ref arg1) throws SQLException {
      try {
         super.preForAll(methodObject5086, this, arg0, arg1);
         Method var10001 = methodObject5086;
         this.delegate.setRef(arg0, arg1 instanceof _Proxy_ ? (Ref)((_Proxy_)arg1)._getDelegate_() : arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject5086, var4);
      }
   }

   public void setOracleObject(String arg0, Datum arg1) throws SQLException {
      try {
         super.preForAll(methodObject5148, this, arg0, arg1);
         Method var10001 = methodObject5148;
         this.delegate.setOracleObject(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject5148, var4);
      }
   }

   public ResultSet getCursor(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject5071, this, arg0);
         return (ResultSet)this.postForAll(methodObject5071, this.proxyFactory.proxyForCache((Object)this.delegate.getCursor(arg0), this, this.proxyCache, methodObject5071));
      } catch (SQLException var3) {
         return (ResultSet)this.postForAll(methodObject5071, this.onErrorForAll(methodObject5071, var3));
      }
   }

   public InputStream getUnicodeStream(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject5063, this, arg0);
         return (InputStream)this.postForAll(methodObject5063, (Object)this.delegate.getUnicodeStream(arg0));
      } catch (SQLException var3) {
         return (InputStream)this.postForAll(methodObject5063, this.onErrorForAll(methodObject5063, var3));
      }
   }

   public void setStringForClob(String arg0, String arg1) throws SQLException {
      try {
         super.preForAll(methodObject5122, this, arg0, arg1);
         Method var10001 = methodObject5122;
         this.delegate.setStringForClob(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject5122, var4);
      }
   }

   public int executeUpdate() throws SQLException {
      try {
         super.preForExecuteUpdate(methodObject5262, this, zeroLengthObjectArray);
         return (Integer)this.postForAll(methodObject5262, this.delegate.executeUpdate());
      } catch (SQLException var2) {
         return (Integer)this.postForAll(methodObject5262, this.onErrorForAll(methodObject5262, var2));
      }
   }

   public NClob getNClob(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject5193, this, arg0);
         return (NClob)this.postForAll(methodObject5193, this.proxyFactory.proxyForCache((Object)this.delegate.getNClob(arg0), this, this.proxyCache, methodObject5193));
      } catch (SQLException var3) {
         return (NClob)this.postForAll(methodObject5193, this.onErrorForAll(methodObject5193, var3));
      }
   }

   public void setNClob(int arg0, NClob arg1) throws SQLException {
      try {
         super.preForAll(methodObject5276, this, arg0, arg1);
         Method var10001 = methodObject5276;
         this.delegate.setNClob(arg0, arg1 instanceof _Proxy_ ? (NClob)((_Proxy_)arg1)._getDelegate_() : arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject5276, var4);
      }
   }

   public void setINTERVALDS(int arg0, INTERVALDS arg1) throws SQLException {
      try {
         super.preForAll(methodObject5368, this, arg0, arg1);
         Method var10001 = methodObject5368;
         this.delegate.setINTERVALDS(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject5368, var4);
      }
   }

   public boolean getBoolean(String arg0) throws SQLException {
      try {
         super.preForAll(methodObject5159, this, arg0);
         return (Boolean)this.postForAll(methodObject5159, this.delegate.getBoolean(arg0));
      } catch (SQLException var3) {
         return (Boolean)this.postForAll(methodObject5159, this.onErrorForAll(methodObject5159, var3));
      }
   }

   public boolean isNCHAR(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject5457, this, arg0);
         return (Boolean)this.postForAll(methodObject5457, this.delegate.isNCHAR(arg0));
      } catch (SQLException var3) {
         return (Boolean)this.postForAll(methodObject5457, this.onErrorForAll(methodObject5457, var3));
      }
   }

   public void setTimestamp(int arg0, Timestamp arg1, Calendar arg2) throws SQLException {
      try {
         super.preForAll(methodObject5244, this, arg0, arg1, arg2);
         Method var10001 = methodObject5244;
         this.delegate.setTimestamp(arg0, arg1, arg2);
         this.postForAll(var10001);
      } catch (SQLException var5) {
         this.onErrorVoidForAll(methodObject5244, var5);
      }
   }

   public String getString(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject5180, this, arg0);
         return (String)this.postForAll(methodObject5180, (Object)this.delegate.getString(arg0));
      } catch (SQLException var3) {
         return (String)this.postForAll(methodObject5180, this.onErrorForAll(methodObject5180, var3));
      }
   }

   public void setDATEAtName(String arg0, DATE arg1) throws SQLException {
      try {
         super.preForAll(methodObject5411, this, arg0, arg1);
         Method var10001 = methodObject5411;
         this.delegate.setDATEAtName(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject5411, var4);
      }
   }

   public void setNString(int arg0, String arg1) throws SQLException {
      try {
         super.preForAll(methodObject5279, this, arg0, arg1);
         Method var10001 = methodObject5279;
         this.delegate.setNString(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject5279, var4);
      }
   }

   public Object getACProxy() {
      super.preForAll(methodObject5497, this, zeroLengthObjectArray);
      return this.postForAll(methodObject5497, this.proxyFactory.proxyForCache(this.delegate.getACProxy(), this, this.proxyCache, methodObject5497));
   }

   public void setBFILEAtName(String arg0, BFILE arg1) throws SQLException {
      try {
         super.preForAll(methodObject5421, this, arg0, arg1);
         Method var10001 = methodObject5421;
         this.delegate.setBFILEAtName(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject5421, var4);
      }
   }

   public int getLobPrefetchSize() throws SQLException {
      try {
         super.preForAll(methodObject5467, this, zeroLengthObjectArray);
         return (Integer)this.postForAll(methodObject5467, this.delegate.getLobPrefetchSize());
      } catch (SQLException var2) {
         return (Integer)this.postForAll(methodObject5467, this.onErrorForAll(methodObject5467, var2));
      }
   }

   public ParameterMetaData getParameterMetaData() throws SQLException {
      try {
         super.preForAll(methodObject5264, this, zeroLengthObjectArray);
         return (ParameterMetaData)this.postForAll(methodObject5264, this.proxyFactory.proxyForCache((Object)this.delegate.getParameterMetaData(), this, this.proxyCache, methodObject5264));
      } catch (SQLException var2) {
         return (ParameterMetaData)this.postForAll(methodObject5264, this.onErrorForAll(methodObject5264, var2));
      }
   }

   public void setBinaryDoubleAtName(String arg0, BINARY_DOUBLE arg1) throws SQLException {
      try {
         super.preForAll(methodObject5397, this, arg0, arg1);
         Method var10001 = methodObject5397;
         this.delegate.setBinaryDoubleAtName(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject5397, var4);
      }
   }

   public void setAsciiStream(String arg0, InputStream arg1, long arg2) throws SQLException {
      try {
         super.preForSetStreams(methodObject5218, this, arg0, arg1, arg2);
         Method var10001 = methodObject5218;
         this.delegate.setAsciiStream(arg0, arg1, arg2);
         this.postForAll(var10001);
      } catch (SQLException var6) {
         this.onErrorVoidForAll(methodObject5218, var6);
      }
   }

   public SQLXML getSQLXML(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject5199, this, arg0);
         return (SQLXML)this.postForAll(methodObject5199, this.proxyFactory.proxyForCache((Object)this.delegate.getSQLXML(arg0), this, this.proxyCache, methodObject5199));
      } catch (SQLException var3) {
         return (SQLXML)this.postForAll(methodObject5199, this.onErrorForAll(methodObject5199, var3));
      }
   }

   public BFILE getBfile(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject5092, this, arg0);
         return (BFILE)this.postForAll(methodObject5092, (Object)this.delegate.getBfile(arg0));
      } catch (SQLException var3) {
         return (BFILE)this.postForAll(methodObject5092, this.onErrorForAll(methodObject5092, var3));
      }
   }

   public void setAsciiStream(int arg0, InputStream arg1, long arg2) throws SQLException {
      try {
         super.preForSetStreams(methodObject5253, this, arg0, arg1, arg2);
         Method var10001 = methodObject5253;
         this.delegate.setAsciiStream(arg0, arg1, arg2);
         this.postForAll(var10001);
      } catch (SQLException var6) {
         this.onErrorVoidForAll(methodObject5253, var6);
      }
   }

   public void closeWithKey(String arg0) throws SQLException {
      try {
         super.preForAll(methodObject5469, this, arg0);
         Method var10001 = methodObject5469;
         this.delegate.closeWithKey(arg0);
         this.postForAll(var10001);
      } catch (SQLException var3) {
         this.onErrorVoidForAll(methodObject5469, var3);
      }
   }

   public void setUnicodeStream(int arg0, InputStream arg1, int arg2) throws SQLException {
      try {
         super.preForSetStreams(methodObject5288, this, arg0, arg1, arg2);
         Method var10001 = methodObject5288;
         this.delegate.setUnicodeStream(arg0, arg1, arg2);
         this.postForAll(var10001);
      } catch (SQLException var5) {
         this.onErrorVoidForAll(methodObject5288, var5);
      }
   }

   public void setDateAtName(String arg0, Date arg1, Calendar arg2) throws SQLException {
      try {
         super.preForAll(methodObject5426, this, arg0, arg1, arg2);
         Method var10001 = methodObject5426;
         this.delegate.setDateAtName(arg0, arg1, arg2);
         this.postForAll(var10001);
      } catch (SQLException var5) {
         this.onErrorVoidForAll(methodObject5426, var5);
      }
   }

   public void setPlsqlIndexTable(int arg0, Object arg1, int arg2, int arg3, int arg4, int arg5) throws SQLException {
      try {
         super.preForAll(methodObject5444, this, arg0, arg1, arg2, arg3, arg4, arg5);
         Method var10001 = methodObject5444;
         this.delegate.setPlsqlIndexTable(arg0, arg1 instanceof _Proxy_ ? (Object)((_Proxy_)arg1)._getDelegate_() : arg1, arg2, arg3, arg4, arg5);
         this.postForAll(var10001);
      } catch (SQLException var8) {
         this.onErrorVoidForAll(methodObject5444, var8);
      }
   }

   public byte[] getBytes(String arg0) throws SQLException {
      try {
         super.preForAll(methodObject5173, this, arg0);
         return (byte[])this.postForAll(methodObject5173, (Object)this.delegate.getBytes(arg0));
      } catch (SQLException var3) {
         return (byte[])this.postForAll(methodObject5173, this.onErrorForAll(methodObject5173, var3));
      }
   }

   public int getMaxFieldSize() throws SQLException {
      try {
         super.preForAll(methodObject5316, this, zeroLengthObjectArray);
         return (Integer)this.postForAll(methodObject5316, this.delegate.getMaxFieldSize());
      } catch (SQLException var2) {
         return (Integer)this.postForAll(methodObject5316, this.onErrorForAll(methodObject5316, var2));
      }
   }

   public void setMaxRows(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject5330, this, arg0);
         Method var10001 = methodObject5330;
         this.delegate.setMaxRows(arg0);
         this.postForAll(var10001);
      } catch (SQLException var3) {
         this.onErrorVoidForAll(methodObject5330, var3);
      }
   }

   public Timestamp getTimestamp(String arg0) throws SQLException {
      try {
         super.preForAll(methodObject5207, this, arg0);
         return (Timestamp)this.postForAll(methodObject5207, (Object)this.delegate.getTimestamp(arg0));
      } catch (SQLException var3) {
         return (Timestamp)this.postForAll(methodObject5207, this.onErrorForAll(methodObject5207, var3));
      }
   }

   public Object getCustomDatum(int arg0, CustomDatumFactory arg1) throws SQLException {
      try {
         super.preForAll(methodObject5096, this, arg0, arg1);
         return this.postForAll(methodObject5096, this.proxyFactory.proxyForCache(this.delegate.getCustomDatum(arg0, arg1), this, this.proxyCache, methodObject5096));
      } catch (SQLException var4) {
         return this.postForAll(methodObject5096, this.onErrorForAll(methodObject5096, var4));
      }
   }

   public double getDouble(String arg0) throws SQLException {
      try {
         super.preForAll(methodObject5171, this, arg0);
         return (Double)this.postForAll(methodObject5171, this.delegate.getDouble(arg0));
      } catch (SQLException var3) {
         return (Double)this.postForAll(methodObject5171, this.onErrorForAll(methodObject5171, var3));
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
         methodObject5430 = OraclePreparedStatement.class.getDeclaredMethod("setTimestampAtName", String.class, Timestamp.class, Calendar.class);
         methodObject5289 = PreparedStatement.class.getDeclaredMethod("setTime", Integer.TYPE, Time.class);
         methodObject5463 = oracle.jdbc.OracleStatement.class.getDeclaredMethod("defineColumnTypeBytes", Integer.TYPE, Integer.TYPE, Integer.TYPE);
         methodObject5233 = CallableStatement.class.getDeclaredMethod("setNString", String.class, String.class);
         methodObject5120 = oracle.jdbc.OracleCallableStatement.class.getDeclaredMethod("setBinaryDouble", String.class, BINARY_DOUBLE.class);
         methodObject5273 = PreparedStatement.class.getDeclaredMethod("setDate", Integer.TYPE, Date.class, Calendar.class);
         methodObject5461 = oracle.jdbc.OracleStatement.class.getDeclaredMethod("defineColumnType", Integer.TYPE, Integer.TYPE, Integer.TYPE, Short.TYPE);
         methodObject5391 = OraclePreparedStatement.class.getDeclaredMethod("setLongAtName", String.class, Long.TYPE);
         methodObject5091 = oracle.jdbc.OracleCallableStatement.class.getDeclaredMethod("getBFILE", Integer.TYPE);
         methodObject5377 = OraclePreparedStatement.class.getDeclaredMethod("setORAData", Integer.TYPE, ORAData.class);
         methodObject5224 = CallableStatement.class.getDeclaredMethod("setBlob", String.class, InputStream.class, Long.TYPE);
         methodObject5476 = oracle.jdbc.internal.OraclePreparedStatement.class.getDeclaredMethod("enterImplicitCache");
         methodObject5392 = OraclePreparedStatement.class.getDeclaredMethod("setFloatAtName", String.class, Float.TYPE);
         methodObject5080 = oracle.jdbc.OracleCallableStatement.class.getDeclaredMethod("setDate", String.class, Date.class, Calendar.class);
         methodObject5283 = PreparedStatement.class.getDeclaredMethod("setObject", Integer.TYPE, Object.class);
         methodObject5078 = oracle.jdbc.OracleCallableStatement.class.getDeclaredMethod("setClob", String.class, Clob.class);
         methodObject5139 = oracle.jdbc.OracleCallableStatement.class.getDeclaredMethod("setTIMESTAMPLTZ", String.class, TIMESTAMPLTZ.class);
         methodObject5410 = OraclePreparedStatement.class.getDeclaredMethod("setCHARAtName", String.class, CHAR.class);
         methodObject5460 = oracle.jdbc.OracleStatement.class.getDeclaredMethod("defineColumnType", Integer.TYPE, Integer.TYPE, Integer.TYPE);
         methodObject5381 = OraclePreparedStatement.class.getDeclaredMethod("defineParameterTypeBytes", Integer.TYPE, Integer.TYPE, Integer.TYPE);
         methodObject5102 = oracle.jdbc.OracleCallableStatement.class.getDeclaredMethod("getRAW", Integer.TYPE);
         methodObject5085 = oracle.jdbc.OracleCallableStatement.class.getDeclaredMethod("setObject", String.class, Object.class);
         methodObject5325 = Statement.class.getDeclaredMethod("isCloseOnCompletion");
         methodObject5076 = oracle.jdbc.OracleCallableStatement.class.getDeclaredMethod("setBigDecimal", String.class, BigDecimal.class);
         methodObject5369 = OraclePreparedStatement.class.getDeclaredMethod("setTIMESTAMP", Integer.TYPE, TIMESTAMP.class);
         methodObject5456 = OraclePreparedStatement.class.getDeclaredMethod("setSQLXMLAtName", String.class, SQLXML.class);
         methodObject5137 = oracle.jdbc.OracleCallableStatement.class.getDeclaredMethod("setTIMESTAMP", String.class, TIMESTAMP.class);
         methodObject5333 = Wrapper.class.getDeclaredMethod("unwrap", Class.class);
         methodObject5337 = OraclePreparedStatement.class.getDeclaredMethod("setAsciiStreamAtName", String.class, InputStream.class);
         methodObject5388 = OraclePreparedStatement.class.getDeclaredMethod("setByteAtName", String.class, Byte.TYPE);
         methodObject5182 = CallableStatement.class.getDeclaredMethod("getDate", Integer.TYPE);
         methodObject5217 = CallableStatement.class.getDeclaredMethod("wasNull");
         methodObject5131 = oracle.jdbc.OracleCallableStatement.class.getDeclaredMethod("setBLOB", String.class, BLOB.class);
         methodObject5323 = Statement.class.getDeclaredMethod("getResultSetType");
         methodObject5405 = OraclePreparedStatement.class.getDeclaredMethod("setARRAYAtName", String.class, ARRAY.class);
         methodObject5445 = OraclePreparedStatement.class.getDeclaredMethod("setFormOfUse", Integer.TYPE, Short.TYPE);
         methodObject5334 = Wrapper.class.getDeclaredMethod("isWrapperFor", Class.class);
         methodObject5322 = Statement.class.getDeclaredMethod("getResultSetHoldability");
         methodObject5261 = PreparedStatement.class.getDeclaredMethod("setBinaryStream", Integer.TYPE, InputStream.class);
         methodObject5228 = CallableStatement.class.getDeclaredMethod("setNCharacterStream", String.class, Reader.class, Long.TYPE);
         methodObject5302 = Statement.class.getDeclaredMethod("clearWarnings");
         methodObject5378 = OraclePreparedStatement.class.getDeclaredMethod("setRefType", Integer.TYPE, REF.class);
         methodObject5257 = PreparedStatement.class.getDeclaredMethod("setCharacterStream", Integer.TYPE, Reader.class);
         methodObject5058 = oracle.jdbc.OracleCallableStatement.class.getDeclaredMethod("setURL", String.class, URL.class);
         methodObject5170 = CallableStatement.class.getDeclaredMethod("getDouble", Integer.TYPE);
         methodObject5114 = oracle.jdbc.OracleCallableStatement.class.getDeclaredMethod("registerOutParameterBytes", Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE);
         methodObject5339 = OraclePreparedStatement.class.getDeclaredMethod("setBinaryStreamAtName", String.class, InputStream.class, Long.TYPE);
         methodObject5146 = oracle.jdbc.OracleCallableStatement.class.getDeclaredMethod("setRefType", String.class, REF.class);
         methodObject5248 = PreparedStatement.class.getDeclaredMethod("getMetaData");
         methodObject5420 = OraclePreparedStatement.class.getDeclaredMethod("setClobAtName", String.class, Reader.class);
         methodObject5266 = PreparedStatement.class.getDeclaredMethod("setBlob", Integer.TYPE, Blob.class);
         methodObject5307 = Statement.class.getDeclaredMethod("addBatch", String.class);
         methodObject5277 = PreparedStatement.class.getDeclaredMethod("setNClob", Integer.TYPE, Reader.class, Long.TYPE);
         methodObject5329 = Statement.class.getDeclaredMethod("setMaxFieldSize", Integer.TYPE);
         methodObject5252 = PreparedStatement.class.getDeclaredMethod("setAsciiStream", Integer.TYPE, InputStream.class, Integer.TYPE);
         methodObject5053 = oracle.jdbc.OracleCallableStatement.class.getDeclaredMethod("setInt", String.class, Integer.TYPE);
         methodObject5254 = PreparedStatement.class.getDeclaredMethod("setAsciiStream", Integer.TYPE, InputStream.class);
         methodObject5275 = PreparedStatement.class.getDeclaredMethod("setNCharacterStream", Integer.TYPE, Reader.class);
         methodObject5315 = Statement.class.getDeclaredMethod("getGeneratedKeys");
         methodObject5313 = Statement.class.getDeclaredMethod("executeUpdate", String.class, int[].class);
         methodObject5242 = PreparedStatement.class.getDeclaredMethod("setShort", Integer.TYPE, Short.TYPE);
         methodObject5382 = OraclePreparedStatement.class.getDeclaredMethod("defineParameterTypeChars", Integer.TYPE, Integer.TYPE, Integer.TYPE);
         methodObject5214 = CallableStatement.class.getDeclaredMethod("registerOutParameter", String.class, Integer.TYPE);
         methodObject5202 = CallableStatement.class.getDeclaredMethod("getTime", Integer.TYPE, Calendar.class);
         methodObject5189 = CallableStatement.class.getDeclaredMethod("getClob", Integer.TYPE);
         methodObject5176 = CallableStatement.class.getDeclaredMethod("getURL", Integer.TYPE);
         methodObject5073 = oracle.jdbc.OracleCallableStatement.class.getDeclaredMethod("setCharacterStream", String.class, Reader.class, Integer.TYPE);
         methodObject5054 = oracle.jdbc.OracleCallableStatement.class.getDeclaredMethod("setLong", String.class, Long.TYPE);
         methodObject5298 = Statement.class.getDeclaredMethod("getFetchDirection");
         methodObject5487 = OracleStatement.class.getDeclaredMethod("getFixedString");
         methodObject5493 = OracleStatement.class.getDeclaredMethod("getChecksum");
         methodObject5267 = PreparedStatement.class.getDeclaredMethod("setBlob", Integer.TYPE, InputStream.class, Long.TYPE);
         methodObject5161 = CallableStatement.class.getDeclaredMethod("getByte", String.class);
         methodObject5251 = PreparedStatement.class.getDeclaredMethod("setString", Integer.TYPE, String.class);
         methodObject5232 = CallableStatement.class.getDeclaredMethod("setNClob", String.class, Reader.class);
         methodObject5221 = CallableStatement.class.getDeclaredMethod("setCharacterStream", String.class, Reader.class);
         methodObject5422 = OraclePreparedStatement.class.getDeclaredMethod("setBfileAtName", String.class, BFILE.class);
         methodObject5464 = oracle.jdbc.OracleStatement.class.getDeclaredMethod("defineColumnTypeChars", Integer.TYPE, Integer.TYPE, Integer.TYPE);
         methodObject5166 = CallableStatement.class.getDeclaredMethod("getLong", Integer.TYPE);
         methodObject5414 = OraclePreparedStatement.class.getDeclaredMethod("setBlobAtName", String.class, Blob.class);
         methodObject5423 = OraclePreparedStatement.class.getDeclaredMethod("setBytesAtName", String.class, byte[].class);
         methodObject5194 = CallableStatement.class.getDeclaredMethod("getNClob", String.class);
         methodObject5157 = CallableStatement.class.getDeclaredMethod("getObject", String.class, Class.class);
         methodObject5453 = OraclePreparedStatement.class.getDeclaredMethod("setNClobAtName", String.class, Reader.class);
         methodObject5458 = oracle.jdbc.OracleStatement.class.getDeclaredMethod("clearDefines");
         methodObject5190 = CallableStatement.class.getDeclaredMethod("getClob", String.class);
         methodObject5451 = OraclePreparedStatement.class.getDeclaredMethod("setNClobAtName", String.class, NClob.class);
         methodObject5165 = CallableStatement.class.getDeclaredMethod("getInt", String.class);
         methodObject5143 = oracle.jdbc.OracleCallableStatement.class.getDeclaredMethod("setSTRUCT", String.class, STRUCT.class);
         methodObject5294 = Statement.class.getDeclaredMethod("execute", String.class, int[].class);
         methodObject5455 = OraclePreparedStatement.class.getDeclaredMethod("setRowIdAtName", String.class, RowId.class);
         methodObject5047 = OracleCallableStatement.class.getDeclaredMethod("privateGetBytes", Integer.TYPE);
         methodObject5413 = OraclePreparedStatement.class.getDeclaredMethod("setBLOBAtName", String.class, BLOB.class);
         methodObject5485 = OraclePreparedStatement.class.getDeclaredMethod("setExecuteBatch", Integer.TYPE);
         methodObject5204 = CallableStatement.class.getDeclaredMethod("getTime", String.class, Calendar.class);
         methodObject5050 = oracle.jdbc.OracleCallableStatement.class.getDeclaredMethod("setByte", String.class, Byte.TYPE);
         methodObject5281 = PreparedStatement.class.getDeclaredMethod("setNull", Integer.TYPE, Integer.TYPE, String.class);
         methodObject5115 = oracle.jdbc.OracleCallableStatement.class.getDeclaredMethod("registerOutParameterChars", Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE);
         methodObject5056 = oracle.jdbc.OracleCallableStatement.class.getDeclaredMethod("setTimestamp", String.class, Timestamp.class);
         methodObject5226 = CallableStatement.class.getDeclaredMethod("setClob", String.class, Reader.class, Long.TYPE);
         methodObject5402 = OraclePreparedStatement.class.getDeclaredMethod("setCursorAtName", String.class, ResultSet.class);
         methodObject5061 = oracle.jdbc.OracleCallableStatement.class.getDeclaredMethod("getBinaryStream", Integer.TYPE);
         methodObject5113 = oracle.jdbc.OracleCallableStatement.class.getDeclaredMethod("getOraclePlsqlIndexTable", Integer.TYPE);
         methodObject5462 = oracle.jdbc.OracleStatement.class.getDeclaredMethod("defineColumnType", Integer.TYPE, Integer.TYPE, String.class);
         methodObject5459 = oracle.jdbc.OracleStatement.class.getDeclaredMethod("defineColumnType", Integer.TYPE, Integer.TYPE);
         methodObject5241 = PreparedStatement.class.getDeclaredMethod("setLong", Integer.TYPE, Long.TYPE);
         methodObject5367 = OraclePreparedStatement.class.getDeclaredMethod("setINTERVALYM", Integer.TYPE, INTERVALYM.class);
         methodObject5374 = OraclePreparedStatement.class.getDeclaredMethod("setStructDescriptor", Integer.TYPE, StructDescriptor.class);
         methodObject5424 = OraclePreparedStatement.class.getDeclaredMethod("setBytesForBlobAtName", String.class, byte[].class);
         methodObject5296 = Statement.class.getDeclaredMethod("cancel");
         methodObject5181 = CallableStatement.class.getDeclaredMethod("getString", String.class);
         methodObject5215 = CallableStatement.class.getDeclaredMethod("registerOutParameter", String.class, Integer.TYPE, Integer.TYPE);
         methodObject5140 = oracle.jdbc.OracleCallableStatement.class.getDeclaredMethod("setARRAY", String.class, ARRAY.class);
         methodObject5466 = oracle.jdbc.OracleStatement.class.getDeclaredMethod("setRowPrefetch", Integer.TYPE);
         methodObject5099 = oracle.jdbc.OracleCallableStatement.class.getDeclaredMethod("getDATE", Integer.TYPE);
         methodObject5219 = CallableStatement.class.getDeclaredMethod("setAsciiStream", String.class, InputStream.class);
         methodObject5160 = CallableStatement.class.getDeclaredMethod("getByte", Integer.TYPE);
         methodObject5230 = CallableStatement.class.getDeclaredMethod("setNClob", String.class, NClob.class);
         methodObject5351 = OraclePreparedStatement.class.getDeclaredMethod("setBinaryFloat", Integer.TYPE, BINARY_FLOAT.class);
         methodObject5059 = oracle.jdbc.OracleCallableStatement.class.getDeclaredMethod("setBytes", String.class, byte[].class);
         methodObject5136 = oracle.jdbc.OracleCallableStatement.class.getDeclaredMethod("setINTERVALDS", String.class, INTERVALDS.class);
         methodObject5468 = oracle.jdbc.OracleStatement.class.getDeclaredMethod("setLobPrefetchSize", Integer.TYPE);
         methodObject5174 = CallableStatement.class.getDeclaredMethod("getArray", Integer.TYPE);
         methodObject5409 = OraclePreparedStatement.class.getDeclaredMethod("setRAWAtName", String.class, RAW.class);
         methodObject5356 = OraclePreparedStatement.class.getDeclaredMethod("setFixedCHAR", Integer.TYPE, String.class);
         methodObject5328 = Statement.class.getDeclaredMethod("setEscapeProcessing", Boolean.TYPE);
         methodObject5149 = oracle.jdbc.OracleCallableStatement.class.getDeclaredMethod("registerOutParameterAtName", String.class, Integer.TYPE);
         methodObject5301 = Statement.class.getDeclaredMethod("setFetchSize", Integer.TYPE);
         methodObject5399 = OraclePreparedStatement.class.getDeclaredMethod("setStringAtName", String.class, String.class);
         methodObject5163 = CallableStatement.class.getDeclaredMethod("getShort", String.class);
         methodObject5429 = OraclePreparedStatement.class.getDeclaredMethod("setTimestampAtName", String.class, Timestamp.class);
         methodObject5216 = CallableStatement.class.getDeclaredMethod("registerOutParameter", String.class, Integer.TYPE, String.class);
         methodObject5370 = OraclePreparedStatement.class.getDeclaredMethod("setTIMESTAMPTZ", Integer.TYPE, TIMESTAMPTZ.class);
         methodObject5225 = CallableStatement.class.getDeclaredMethod("setBlob", String.class, InputStream.class);
         methodObject5403 = OraclePreparedStatement.class.getDeclaredMethod("setROWIDAtName", String.class, ROWID.class);
         methodObject5327 = Statement.class.getDeclaredMethod("setCursorName", String.class);
         methodObject5290 = PreparedStatement.class.getDeclaredMethod("setTime", Integer.TYPE, Time.class, Calendar.class);
         methodObject5196 = CallableStatement.class.getDeclaredMethod("getNString", String.class);
         methodObject5415 = OraclePreparedStatement.class.getDeclaredMethod("setBlobAtName", String.class, InputStream.class, Long.TYPE);
         methodObject5237 = PreparedStatement.class.getDeclaredMethod("setByte", Integer.TYPE, Byte.TYPE);
         methodObject5355 = OraclePreparedStatement.class.getDeclaredMethod("setBytesForBlob", Integer.TYPE, byte[].class);
         methodObject5222 = CallableStatement.class.getDeclaredMethod("setBinaryStream", String.class, InputStream.class, Long.TYPE);
         methodObject5151 = oracle.jdbc.OracleCallableStatement.class.getDeclaredMethod("registerOutParameterAtName", String.class, Integer.TYPE, String.class);
         methodObject5439 = OraclePreparedStatement.class.getDeclaredMethod("setRefAtName", String.class, Ref.class);
         methodObject5352 = OraclePreparedStatement.class.getDeclaredMethod("setBinaryDouble", Integer.TYPE, Double.TYPE);
         methodObject5375 = OraclePreparedStatement.class.getDeclaredMethod("setSTRUCT", Integer.TYPE, STRUCT.class);
         methodObject5067 = oracle.jdbc.OracleCallableStatement.class.getDeclaredMethod("setArray", String.class, Array.class);
         methodObject5135 = oracle.jdbc.OracleCallableStatement.class.getDeclaredMethod("setINTERVALYM", String.class, INTERVALYM.class);
         methodObject5286 = PreparedStatement.class.getDeclaredMethod("setRowId", Integer.TYPE, RowId.class);
         methodObject5209 = CallableStatement.class.getDeclaredMethod("getBlob", Integer.TYPE);
         methodObject5412 = OraclePreparedStatement.class.getDeclaredMethod("setNUMBERAtName", String.class, NUMBER.class);
         methodObject5154 = CallableStatement.class.getDeclaredMethod("getObject", String.class);
         methodObject5317 = Statement.class.getDeclaredMethod("getMaxRows");
         methodObject5258 = PreparedStatement.class.getDeclaredMethod("addBatch");
         methodObject5442 = OraclePreparedStatement.class.getDeclaredMethod("setURLAtName", String.class, URL.class);
         methodObject5344 = OraclePreparedStatement.class.getDeclaredMethod("setNCharacterStreamAtName", String.class, Reader.class);
         methodObject5198 = CallableStatement.class.getDeclaredMethod("getRowId", String.class);
         methodObject5052 = oracle.jdbc.OracleCallableStatement.class.getDeclaredMethod("setFloat", String.class, Float.TYPE);
         methodObject5436 = OraclePreparedStatement.class.getDeclaredMethod("setCustomDatumAtName", String.class, CustomDatum.class);
         methodObject5441 = OraclePreparedStatement.class.getDeclaredMethod("setOracleObjectAtName", String.class, Datum.class);
         methodObject5431 = OraclePreparedStatement.class.getDeclaredMethod("setINTERVALYMAtName", String.class, INTERVALYM.class);
         methodObject5213 = CallableStatement.class.getDeclaredMethod("registerOutParameter", Integer.TYPE, Integer.TYPE, String.class);
         methodObject5211 = CallableStatement.class.getDeclaredMethod("registerOutParameter", Integer.TYPE, Integer.TYPE);
         methodObject5320 = Statement.class.getDeclaredMethod("getQueryTimeout");
         methodObject5491 = OracleStatement.class.getDeclaredMethod("getstatementType");
         methodObject5287 = PreparedStatement.class.getDeclaredMethod("setSQLXML", Integer.TYPE, SQLXML.class);
         methodObject5134 = oracle.jdbc.OracleCallableStatement.class.getDeclaredMethod("setBfile", String.class, BFILE.class);
         methodObject5393 = OraclePreparedStatement.class.getDeclaredMethod("setDoubleAtName", String.class, Double.TYPE);
         methodObject5311 = Statement.class.getDeclaredMethod("executeUpdate", String.class);
         methodObject5404 = OraclePreparedStatement.class.getDeclaredMethod("setArrayAtName", String.class, Array.class);
         methodObject5175 = CallableStatement.class.getDeclaredMethod("getArray", String.class);
         methodObject5083 = oracle.jdbc.OracleCallableStatement.class.getDeclaredMethod("setObject", String.class, Object.class, Integer.TYPE, Integer.TYPE);
         methodObject5156 = CallableStatement.class.getDeclaredMethod("getObject", Integer.TYPE, Class.class);
         methodObject5152 = CallableStatement.class.getDeclaredMethod("getObject", Integer.TYPE);
         methodObject5345 = OraclePreparedStatement.class.getDeclaredMethod("setUnicodeStreamAtName", String.class, InputStream.class, Integer.TYPE);
         methodObject5406 = OraclePreparedStatement.class.getDeclaredMethod("setOPAQUEAtName", String.class, OPAQUE.class);
         methodObject5210 = CallableStatement.class.getDeclaredMethod("getBlob", String.class);
         methodObject5358 = OraclePreparedStatement.class.getDeclaredMethod("setROWID", Integer.TYPE, ROWID.class);
         methodObject5110 = oracle.jdbc.OracleCallableStatement.class.getDeclaredMethod("getTIMESTAMPLTZ", Integer.TYPE);
         methodObject5350 = OraclePreparedStatement.class.getDeclaredMethod("setBinaryFloat", Integer.TYPE, Float.TYPE);
         methodObject5483 = oracle.jdbc.internal.OraclePreparedStatement.class.getDeclaredMethod("setCheckBindTypes", Boolean.TYPE);
         methodObject5481 = oracle.jdbc.internal.OraclePreparedStatement.class.getDeclaredMethod("exitExplicitCacheToClose");
         methodObject5045 = OracleCallableStatement.class.getDeclaredMethod("getBigDecimal", String.class, Integer.TYPE);
         methodObject5438 = OraclePreparedStatement.class.getDeclaredMethod("setRefTypeAtName", String.class, REF.class);
         methodObject5292 = Statement.class.getDeclaredMethod("execute", String.class);
         methodObject5072 = oracle.jdbc.OracleCallableStatement.class.getDeclaredMethod("setAsciiStream", String.class, InputStream.class, Integer.TYPE);
         methodObject5272 = PreparedStatement.class.getDeclaredMethod("setDate", Integer.TYPE, Date.class);
         methodObject5130 = oracle.jdbc.OracleCallableStatement.class.getDeclaredMethod("setNUMBER", String.class, NUMBER.class);
         methodObject5470 = oracle.jdbc.OracleStatement.class.getDeclaredMethod("creationState");
         methodObject5127 = oracle.jdbc.OracleCallableStatement.class.getDeclaredMethod("setRAW", String.class, RAW.class);
         methodObject5090 = oracle.jdbc.OracleCallableStatement.class.getDeclaredMethod("getARRAY", Integer.TYPE);
         methodObject5284 = PreparedStatement.class.getDeclaredMethod("setObject", Integer.TYPE, Object.class, Integer.TYPE, Integer.TYPE);
         methodObject5055 = oracle.jdbc.OracleCallableStatement.class.getDeclaredMethod("setShort", String.class, Short.TYPE);
         methodObject5373 = OraclePreparedStatement.class.getDeclaredMethod("setOPAQUE", Integer.TYPE, OPAQUE.class);
         methodObject5103 = oracle.jdbc.OracleCallableStatement.class.getDeclaredMethod("getREF", Integer.TYPE);
         methodObject5238 = PreparedStatement.class.getDeclaredMethod("setDouble", Integer.TYPE, Double.TYPE);
         methodObject5227 = CallableStatement.class.getDeclaredMethod("setClob", String.class, Reader.class);
         methodObject5068 = oracle.jdbc.OracleCallableStatement.class.getDeclaredMethod("registerOutParameter", Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE);
         methodObject5106 = oracle.jdbc.OracleCallableStatement.class.getDeclaredMethod("getINTERVALYM", Integer.TYPE);
         methodObject5268 = PreparedStatement.class.getDeclaredMethod("setBlob", Integer.TYPE, InputStream.class);
         methodObject5235 = CallableStatement.class.getDeclaredMethod("setSQLXML", String.class, SQLXML.class);
         methodObject5394 = OraclePreparedStatement.class.getDeclaredMethod("setBinaryFloatAtName", String.class, Float.TYPE);
         methodObject5480 = oracle.jdbc.internal.OraclePreparedStatement.class.getDeclaredMethod("exitImplicitCacheToClose");
         methodObject5150 = oracle.jdbc.OracleCallableStatement.class.getDeclaredMethod("registerOutParameterAtName", String.class, Integer.TYPE, Integer.TYPE);
         methodObject5492 = OracleStatement.class.getDeclaredMethod("getSqlKind");
         methodObject5475 = oracle.jdbc.internal.OraclePreparedStatement.class.getDeclaredMethod("setInternalBytes", Integer.TYPE, byte[].class, Integer.TYPE);
         methodObject5486 = OracleStatement.class.getDeclaredMethod("setFixedString", Boolean.TYPE);
         methodObject5308 = Statement.class.getDeclaredMethod("clearBatch");
         methodObject5069 = oracle.jdbc.OracleCallableStatement.class.getDeclaredMethod("registerOutParameter", String.class, Integer.TYPE, Integer.TYPE, Integer.TYPE);
         methodObject5385 = OraclePreparedStatement.class.getDeclaredMethod("setNullAtName", String.class, Integer.TYPE, String.class);
         methodObject5109 = oracle.jdbc.OracleCallableStatement.class.getDeclaredMethod("getTIMESTAMPTZ", Integer.TYPE);
         methodObject5364 = OraclePreparedStatement.class.getDeclaredMethod("setCLOB", Integer.TYPE, CLOB.class);
         methodObject5124 = oracle.jdbc.OracleCallableStatement.class.getDeclaredMethod("setFixedCHAR", String.class, String.class);
         methodObject5256 = PreparedStatement.class.getDeclaredMethod("setCharacterStream", Integer.TYPE, Reader.class, Long.TYPE);
         methodObject5490 = OracleStatement.class.getDeclaredMethod("getcacheState");
         methodObject5299 = Statement.class.getDeclaredMethod("getFetchSize");
         methodObject5187 = CallableStatement.class.getDeclaredMethod("getBigDecimal", Integer.TYPE);
         methodObject5132 = oracle.jdbc.OracleCallableStatement.class.getDeclaredMethod("setCLOB", String.class, CLOB.class);
         methodObject5482 = oracle.jdbc.internal.OraclePreparedStatement.class.getDeclaredMethod("getOriginalSql");
         methodObject5240 = PreparedStatement.class.getDeclaredMethod("setInt", Integer.TYPE, Integer.TYPE);
         methodObject5231 = CallableStatement.class.getDeclaredMethod("setNClob", String.class, Reader.class, Long.TYPE);
         methodObject5205 = CallableStatement.class.getDeclaredMethod("getTimestamp", Integer.TYPE);
         methodObject5495 = OracleStatement.class.getDeclaredMethod("setSnapshotSCN", Long.TYPE);
         methodObject5285 = PreparedStatement.class.getDeclaredMethod("setRef", Integer.TYPE, Ref.class);
         methodObject5472 = oracle.jdbc.OracleStatement.class.getDeclaredMethod("getRegisteredTableNames");
         methodObject5434 = OraclePreparedStatement.class.getDeclaredMethod("setTIMESTAMPTZAtName", String.class, TIMESTAMPTZ.class);
         methodObject5263 = PreparedStatement.class.getDeclaredMethod("clearParameters");
         methodObject5425 = OraclePreparedStatement.class.getDeclaredMethod("setDateAtName", String.class, Date.class);
         methodObject5312 = Statement.class.getDeclaredMethod("executeUpdate", String.class, Integer.TYPE);
         methodObject5246 = PreparedStatement.class.getDeclaredMethod("execute");
         methodObject5362 = OraclePreparedStatement.class.getDeclaredMethod("setNUMBER", Integer.TYPE, NUMBER.class);
         methodObject5353 = OraclePreparedStatement.class.getDeclaredMethod("setBinaryDouble", Integer.TYPE, BINARY_DOUBLE.class);
         methodObject5243 = PreparedStatement.class.getDeclaredMethod("setTimestamp", Integer.TYPE, Timestamp.class);
         methodObject5095 = oracle.jdbc.OracleCallableStatement.class.getDeclaredMethod("getCLOB", Integer.TYPE);
         methodObject5380 = OraclePreparedStatement.class.getDeclaredMethod("setOracleObject", Integer.TYPE, Datum.class);
         methodObject5450 = OraclePreparedStatement.class.getDeclaredMethod("registerReturnParameter", Integer.TYPE, Integer.TYPE, String.class);
         methodObject5408 = OraclePreparedStatement.class.getDeclaredMethod("setSTRUCTAtName", String.class, STRUCT.class);
         methodObject5177 = CallableStatement.class.getDeclaredMethod("getURL", String.class);
         methodObject5168 = CallableStatement.class.getDeclaredMethod("getFloat", Integer.TYPE);
         methodObject5305 = Statement.class.getDeclaredMethod("executeQuery", String.class);
         methodObject5452 = OraclePreparedStatement.class.getDeclaredMethod("setNClobAtName", String.class, Reader.class, Long.TYPE);
         methodObject5162 = CallableStatement.class.getDeclaredMethod("getShort", Integer.TYPE);
         methodObject5387 = OraclePreparedStatement.class.getDeclaredMethod("setBooleanAtName", String.class, Boolean.TYPE);
         methodObject5390 = OraclePreparedStatement.class.getDeclaredMethod("setIntAtName", String.class, Integer.TYPE);
         methodObject5384 = OraclePreparedStatement.class.getDeclaredMethod("getExecuteBatch");
         methodObject5386 = OraclePreparedStatement.class.getDeclaredMethod("setNullAtName", String.class, Integer.TYPE);
         methodObject5119 = oracle.jdbc.OracleCallableStatement.class.getDeclaredMethod("setBinaryFloat", String.class, Float.TYPE);
         methodObject5300 = Statement.class.getDeclaredMethod("setFetchDirection", Integer.TYPE);
         methodObject5418 = OraclePreparedStatement.class.getDeclaredMethod("setClobAtName", String.class, Clob.class);
         methodObject5280 = PreparedStatement.class.getDeclaredMethod("setNull", Integer.TYPE, Integer.TYPE);
         methodObject5379 = OraclePreparedStatement.class.getDeclaredMethod("setREF", Integer.TYPE, REF.class);
         methodObject5489 = OracleStatement.class.getDeclaredMethod("getserverCursor");
         methodObject5201 = CallableStatement.class.getDeclaredMethod("getTime", Integer.TYPE);
         methodObject5077 = oracle.jdbc.OracleCallableStatement.class.getDeclaredMethod("setBlob", String.class, Blob.class);
         methodObject5245 = PreparedStatement.class.getDeclaredMethod("setURL", Integer.TYPE, URL.class);
         methodObject5169 = CallableStatement.class.getDeclaredMethod("getFloat", String.class);
         methodObject5062 = oracle.jdbc.OracleCallableStatement.class.getDeclaredMethod("getBinaryStream", String.class);
         methodObject5433 = OraclePreparedStatement.class.getDeclaredMethod("setTIMESTAMPAtName", String.class, TIMESTAMP.class);
         methodObject5046 = OracleCallableStatement.class.getDeclaredMethod("getCharacterStream", String.class);
         methodObject5112 = oracle.jdbc.OracleCallableStatement.class.getDeclaredMethod("getPlsqlIndexTable", Integer.TYPE, Class.class);
         methodObject5060 = oracle.jdbc.OracleCallableStatement.class.getDeclaredMethod("getAsciiStream", Integer.TYPE);
         methodObject5326 = Statement.class.getDeclaredMethod("isPoolable");
         methodObject5208 = CallableStatement.class.getDeclaredMethod("getTimestamp", String.class, Calendar.class);
         methodObject5427 = OraclePreparedStatement.class.getDeclaredMethod("setTimeAtName", String.class, Time.class);
         methodObject5324 = Statement.class.getDeclaredMethod("getUpdateCount");
         methodObject5255 = PreparedStatement.class.getDeclaredMethod("setCharacterStream", Integer.TYPE, Reader.class, Integer.TYPE);
         methodObject5346 = OraclePreparedStatement.class.getDeclaredMethod("setObjectAtName", String.class, Object.class, Integer.TYPE, Integer.TYPE);
         methodObject5192 = CallableStatement.class.getDeclaredMethod("getNCharacterStream", String.class);
         methodObject5111 = oracle.jdbc.OracleCallableStatement.class.getDeclaredMethod("getPlsqlIndexTable", Integer.TYPE);
         methodObject5249 = PreparedStatement.class.getDeclaredMethod("setArray", Integer.TYPE, Array.class);
         methodObject5172 = CallableStatement.class.getDeclaredMethod("getBytes", Integer.TYPE);
         methodObject5129 = oracle.jdbc.OracleCallableStatement.class.getDeclaredMethod("setDATE", String.class, DATE.class);
         methodObject5282 = PreparedStatement.class.getDeclaredMethod("setObject", Integer.TYPE, Object.class, Integer.TYPE);
         methodObject5395 = OraclePreparedStatement.class.getDeclaredMethod("setBinaryFloatAtName", String.class, BINARY_FLOAT.class);
         methodObject5138 = oracle.jdbc.OracleCallableStatement.class.getDeclaredMethod("setTIMESTAMPTZ", String.class, TIMESTAMPTZ.class);
         methodObject5133 = oracle.jdbc.OracleCallableStatement.class.getDeclaredMethod("setBFILE", String.class, BFILE.class);
         methodObject5310 = Statement.class.getDeclaredMethod("executeBatch");
         methodObject5428 = OraclePreparedStatement.class.getDeclaredMethod("setTimeAtName", String.class, Time.class, Calendar.class);
         methodObject5167 = CallableStatement.class.getDeclaredMethod("getLong", String.class);
         methodObject5383 = OraclePreparedStatement.class.getDeclaredMethod("defineParameterType", Integer.TYPE, Integer.TYPE, Integer.TYPE);
         methodObject5191 = CallableStatement.class.getDeclaredMethod("getNCharacterStream", Integer.TYPE);
         methodObject5265 = PreparedStatement.class.getDeclaredMethod("setBigDecimal", Integer.TYPE, BigDecimal.class);
         methodObject5360 = OraclePreparedStatement.class.getDeclaredMethod("setCHAR", Integer.TYPE, CHAR.class);
         methodObject5496 = ACProxyable.class.getDeclaredMethod("setACProxy", Object.class);
         methodObject5357 = OraclePreparedStatement.class.getDeclaredMethod("setCursor", Integer.TYPE, ResultSet.class);
         methodObject5044 = OracleCallableStatement.class.getDeclaredMethod("getAsciiStream", String.class);
         methodObject5158 = CallableStatement.class.getDeclaredMethod("getBoolean", Integer.TYPE);
         methodObject5447 = OraclePreparedStatement.class.getDeclaredMethod("OracleGetParameterMetaData");
         methodObject5121 = oracle.jdbc.OracleCallableStatement.class.getDeclaredMethod("setBinaryDouble", String.class, Double.TYPE);
         methodObject5437 = OraclePreparedStatement.class.getDeclaredMethod("setORADataAtName", String.class, ORAData.class);
         methodObject5075 = oracle.jdbc.OracleCallableStatement.class.getDeclaredMethod("setBinaryStream", String.class, InputStream.class, Integer.TYPE);
         methodObject5304 = Statement.class.getDeclaredMethod("isClosed");
         methodObject5118 = oracle.jdbc.OracleCallableStatement.class.getDeclaredMethod("setBinaryFloat", String.class, BINARY_FLOAT.class);
         methodObject5212 = CallableStatement.class.getDeclaredMethod("registerOutParameter", Integer.TYPE, Integer.TYPE, Integer.TYPE);
         methodObject5488 = OracleStatement.class.getDeclaredMethod("sendBatch");
         methodObject5446 = OraclePreparedStatement.class.getDeclaredMethod("setDisableStmtCaching", Boolean.TYPE);
         methodObject5178 = CallableStatement.class.getDeclaredMethod("getRef", Integer.TYPE);
         methodObject5494 = OracleStatement.class.getDeclaredMethod("registerBindChecksumListener", OracleStatement.BindChecksumListener.class);
         methodObject5465 = oracle.jdbc.OracleStatement.class.getDeclaredMethod("getRowPrefetch");
         methodObject5474 = oracle.jdbc.internal.OraclePreparedStatement.class.getDeclaredMethod("setCharacterStreamAtName", String.class, Reader.class, Integer.TYPE);
         methodObject5126 = oracle.jdbc.OracleCallableStatement.class.getDeclaredMethod("setROWID", String.class, ROWID.class);
         methodObject5309 = Statement.class.getDeclaredMethod("closeOnCompletion");
         methodObject5203 = CallableStatement.class.getDeclaredMethod("getTime", String.class);
         methodObject5342 = OraclePreparedStatement.class.getDeclaredMethod("setCharacterStreamAtName", String.class, Reader.class);
         methodObject5153 = CallableStatement.class.getDeclaredMethod("getObject", Integer.TYPE, Map.class);
         methodObject5145 = oracle.jdbc.OracleCallableStatement.class.getDeclaredMethod("setORAData", String.class, ORAData.class);
         methodObject5335 = OraclePreparedStatement.class.getDeclaredMethod("setAsciiStreamAtName", String.class, InputStream.class, Integer.TYPE);
         methodObject5319 = Statement.class.getDeclaredMethod("getMoreResults", Integer.TYPE);
         methodObject5449 = OraclePreparedStatement.class.getDeclaredMethod("registerReturnParameter", Integer.TYPE, Integer.TYPE, Integer.TYPE);
         methodObject5419 = OraclePreparedStatement.class.getDeclaredMethod("setClobAtName", String.class, Reader.class, Long.TYPE);
         methodObject5295 = Statement.class.getDeclaredMethod("execute", String.class, String[].class);
         methodObject5097 = oracle.jdbc.OracleCallableStatement.class.getDeclaredMethod("getORAData", Integer.TYPE, ORADataFactory.class);
         methodObject5332 = Statement.class.getDeclaredMethod("setQueryTimeout", Integer.TYPE);
         methodObject5389 = OraclePreparedStatement.class.getDeclaredMethod("setShortAtName", String.class, Short.TYPE);
         methodObject5195 = CallableStatement.class.getDeclaredMethod("getNString", Integer.TYPE);
         methodObject5432 = OraclePreparedStatement.class.getDeclaredMethod("setINTERVALDSAtName", String.class, INTERVALDS.class);
         methodObject5104 = oracle.jdbc.OracleCallableStatement.class.getDeclaredMethod("getROWID", Integer.TYPE);
         methodObject5401 = OraclePreparedStatement.class.getDeclaredMethod("setFixedCHARAtName", String.class, String.class);
         methodObject5184 = CallableStatement.class.getDeclaredMethod("getDate", String.class);
         methodObject5101 = oracle.jdbc.OracleCallableStatement.class.getDeclaredMethod("getOPAQUE", Integer.TYPE);
         methodObject5147 = oracle.jdbc.OracleCallableStatement.class.getDeclaredMethod("setREF", String.class, REF.class);
         methodObject5440 = OraclePreparedStatement.class.getDeclaredMethod("setREFAtName", String.class, REF.class);
         methodObject5270 = PreparedStatement.class.getDeclaredMethod("setClob", Integer.TYPE, Reader.class, Long.TYPE);
         methodObject5349 = OraclePreparedStatement.class.getDeclaredMethod("getReturnResultSet");
         methodObject5361 = OraclePreparedStatement.class.getDeclaredMethod("setDATE", Integer.TYPE, DATE.class);
         methodObject5229 = CallableStatement.class.getDeclaredMethod("setNCharacterStream", String.class, Reader.class);
         methodObject5341 = OraclePreparedStatement.class.getDeclaredMethod("setCharacterStreamAtName", String.class, Reader.class, Long.TYPE);
         methodObject5084 = oracle.jdbc.OracleCallableStatement.class.getDeclaredMethod("setObject", String.class, Object.class, Integer.TYPE);
         methodObject5107 = oracle.jdbc.OracleCallableStatement.class.getDeclaredMethod("getINTERVALDS", Integer.TYPE);
         methodObject5471 = oracle.jdbc.OracleStatement.class.getDeclaredMethod("setDatabaseChangeRegistration", DatabaseChangeRegistration.class);
         methodObject5321 = Statement.class.getDeclaredMethod("getResultSetConcurrency");
         methodObject5435 = OraclePreparedStatement.class.getDeclaredMethod("setTIMESTAMPLTZAtName", String.class, TIMESTAMPLTZ.class);
         methodObject5293 = Statement.class.getDeclaredMethod("execute", String.class, Integer.TYPE);
         methodObject5365 = OraclePreparedStatement.class.getDeclaredMethod("setBFILE", Integer.TYPE, BFILE.class);
         methodObject5400 = OraclePreparedStatement.class.getDeclaredMethod("setStringForClobAtName", String.class, String.class);
         methodObject5142 = oracle.jdbc.OracleCallableStatement.class.getDeclaredMethod("setStructDescriptor", String.class, StructDescriptor.class);
         methodObject5366 = OraclePreparedStatement.class.getDeclaredMethod("setBfile", Integer.TYPE, BFILE.class);
         methodObject5479 = oracle.jdbc.internal.OraclePreparedStatement.class.getDeclaredMethod("exitExplicitCacheToActive");
         methodObject5477 = oracle.jdbc.internal.OraclePreparedStatement.class.getDeclaredMethod("enterExplicitCache");
         methodObject5363 = OraclePreparedStatement.class.getDeclaredMethod("setBLOB", Integer.TYPE, BLOB.class);
         methodObject5274 = PreparedStatement.class.getDeclaredMethod("setNCharacterStream", Integer.TYPE, Reader.class, Long.TYPE);
         methodObject5186 = CallableStatement.class.getDeclaredMethod("getBigDecimal", Integer.TYPE, Integer.TYPE);
         methodObject5372 = OraclePreparedStatement.class.getDeclaredMethod("setARRAY", Integer.TYPE, ARRAY.class);
         methodObject5048 = oracle.jdbc.OracleCallableStatement.class.getDeclaredMethod("getObject", Integer.TYPE, OracleDataFactory.class);
         methodObject5343 = OraclePreparedStatement.class.getDeclaredMethod("setNCharacterStreamAtName", String.class, Reader.class, Long.TYPE);
         methodObject5398 = OraclePreparedStatement.class.getDeclaredMethod("setBigDecimalAtName", String.class, BigDecimal.class);
         methodObject5082 = oracle.jdbc.OracleCallableStatement.class.getDeclaredMethod("setNull", String.class, Integer.TYPE);
         methodObject5094 = oracle.jdbc.OracleCallableStatement.class.getDeclaredMethod("getCHAR", Integer.TYPE);
         methodObject5297 = Statement.class.getDeclaredMethod("getResultSet");
         methodObject5314 = Statement.class.getDeclaredMethod("executeUpdate", String.class, String[].class);
         methodObject5234 = CallableStatement.class.getDeclaredMethod("setRowId", String.class, RowId.class);
         methodObject5200 = CallableStatement.class.getDeclaredMethod("getSQLXML", String.class);
         methodObject5128 = oracle.jdbc.OracleCallableStatement.class.getDeclaredMethod("setCHAR", String.class, CHAR.class);
         methodObject5065 = oracle.jdbc.OracleCallableStatement.class.getDeclaredMethod("getCharacterStream", Integer.TYPE);
         methodObject5185 = CallableStatement.class.getDeclaredMethod("getDate", String.class, Calendar.class);
         methodObject5108 = oracle.jdbc.OracleCallableStatement.class.getDeclaredMethod("getTIMESTAMP", Integer.TYPE);
         methodObject5093 = oracle.jdbc.OracleCallableStatement.class.getDeclaredMethod("getBLOB", Integer.TYPE);
         methodObject5239 = PreparedStatement.class.getDeclaredMethod("setFloat", Integer.TYPE, Float.TYPE);
         methodObject5473 = oracle.jdbc.OracleStatement.class.getDeclaredMethod("getRegisteredQueryId");
         methodObject5454 = OraclePreparedStatement.class.getDeclaredMethod("setNStringAtName", String.class, String.class);
         methodObject5070 = oracle.jdbc.OracleCallableStatement.class.getDeclaredMethod("setString", String.class, String.class);
         methodObject5336 = OraclePreparedStatement.class.getDeclaredMethod("setAsciiStreamAtName", String.class, InputStream.class, Long.TYPE);
         methodObject5338 = OraclePreparedStatement.class.getDeclaredMethod("setBinaryStreamAtName", String.class, InputStream.class, Integer.TYPE);
         methodObject5100 = oracle.jdbc.OracleCallableStatement.class.getDeclaredMethod("getNUMBER", Integer.TYPE);
         methodObject5125 = oracle.jdbc.OracleCallableStatement.class.getDeclaredMethod("setCursor", String.class, ResultSet.class);
         methodObject5197 = CallableStatement.class.getDeclaredMethod("getRowId", Integer.TYPE);
         methodObject5066 = oracle.jdbc.OracleCallableStatement.class.getDeclaredMethod("getOracleObject", Integer.TYPE);
         methodObject5089 = oracle.jdbc.OracleCallableStatement.class.getDeclaredMethod("setTime", String.class, Time.class, Calendar.class);
         methodObject5318 = Statement.class.getDeclaredMethod("getMoreResults");
         methodObject5396 = OraclePreparedStatement.class.getDeclaredMethod("setBinaryDoubleAtName", String.class, Double.TYPE);
         methodObject5416 = OraclePreparedStatement.class.getDeclaredMethod("setBlobAtName", String.class, InputStream.class);
         methodObject5088 = oracle.jdbc.OracleCallableStatement.class.getDeclaredMethod("setTime", String.class, Time.class);
         methodObject5223 = CallableStatement.class.getDeclaredMethod("setBinaryStream", String.class, InputStream.class);
         methodObject5269 = PreparedStatement.class.getDeclaredMethod("setClob", Integer.TYPE, Clob.class);
         methodObject5371 = OraclePreparedStatement.class.getDeclaredMethod("setTIMESTAMPLTZ", Integer.TYPE, TIMESTAMPLTZ.class);
         methodObject5260 = PreparedStatement.class.getDeclaredMethod("setBinaryStream", Integer.TYPE, InputStream.class, Long.TYPE);
         methodObject5057 = oracle.jdbc.OracleCallableStatement.class.getDeclaredMethod("setTimestamp", String.class, Timestamp.class, Calendar.class);
         methodObject5236 = PreparedStatement.class.getDeclaredMethod("setBoolean", Integer.TYPE, Boolean.TYPE);
         methodObject5081 = oracle.jdbc.OracleCallableStatement.class.getDeclaredMethod("setNull", String.class, Integer.TYPE, String.class);
         methodObject5340 = OraclePreparedStatement.class.getDeclaredMethod("setBinaryStreamAtName", String.class, InputStream.class);
         methodObject5347 = OraclePreparedStatement.class.getDeclaredMethod("setObjectAtName", String.class, Object.class, Integer.TYPE);
         methodObject5220 = CallableStatement.class.getDeclaredMethod("setCharacterStream", String.class, Reader.class, Long.TYPE);
         methodObject5087 = oracle.jdbc.OracleCallableStatement.class.getDeclaredMethod("setUnicodeStream", String.class, InputStream.class, Integer.TYPE);
         methodObject5155 = CallableStatement.class.getDeclaredMethod("getObject", String.class, Map.class);
         methodObject5064 = oracle.jdbc.OracleCallableStatement.class.getDeclaredMethod("getUnicodeStream", String.class);
         methodObject5098 = oracle.jdbc.OracleCallableStatement.class.getDeclaredMethod("getAnyDataEmbeddedObject", Integer.TYPE);
         methodObject5478 = oracle.jdbc.internal.OraclePreparedStatement.class.getDeclaredMethod("exitImplicitCacheToActive");
         methodObject5079 = oracle.jdbc.OracleCallableStatement.class.getDeclaredMethod("setDate", String.class, Date.class);
         methodObject5448 = OraclePreparedStatement.class.getDeclaredMethod("registerReturnParameter", Integer.TYPE, Integer.TYPE);
         methodObject5179 = CallableStatement.class.getDeclaredMethod("getRef", String.class);
         methodObject5278 = PreparedStatement.class.getDeclaredMethod("setNClob", Integer.TYPE, Reader.class);
         methodObject5250 = PreparedStatement.class.getDeclaredMethod("executeQuery");
         methodObject5331 = Statement.class.getDeclaredMethod("setPoolable", Boolean.TYPE);
         methodObject5206 = CallableStatement.class.getDeclaredMethod("getTimestamp", Integer.TYPE, Calendar.class);
         methodObject5051 = oracle.jdbc.OracleCallableStatement.class.getDeclaredMethod("setDouble", String.class, Double.TYPE);
         methodObject5144 = oracle.jdbc.OracleCallableStatement.class.getDeclaredMethod("setCustomDatum", String.class, CustomDatum.class);
         methodObject5359 = OraclePreparedStatement.class.getDeclaredMethod("setRAW", Integer.TYPE, RAW.class);
         methodObject5049 = oracle.jdbc.OracleCallableStatement.class.getDeclaredMethod("setBoolean", String.class, Boolean.TYPE);
         methodObject5376 = OraclePreparedStatement.class.getDeclaredMethod("setCustomDatum", Integer.TYPE, CustomDatum.class);
         methodObject5188 = CallableStatement.class.getDeclaredMethod("getBigDecimal", String.class);
         methodObject5247 = PreparedStatement.class.getDeclaredMethod("setBytes", Integer.TYPE, byte[].class);
         methodObject5348 = OraclePreparedStatement.class.getDeclaredMethod("setObjectAtName", String.class, Object.class);
         methodObject5123 = oracle.jdbc.OracleCallableStatement.class.getDeclaredMethod("setBytesForBlob", String.class, byte[].class);
         methodObject5105 = oracle.jdbc.OracleCallableStatement.class.getDeclaredMethod("getSTRUCT", Integer.TYPE);
         methodObject5303 = Statement.class.getDeclaredMethod("getWarnings");
         methodObject5306 = Statement.class.getDeclaredMethod("getConnection");
         methodObject5417 = OraclePreparedStatement.class.getDeclaredMethod("setCLOBAtName", String.class, CLOB.class);
         methodObject5141 = oracle.jdbc.OracleCallableStatement.class.getDeclaredMethod("setOPAQUE", String.class, OPAQUE.class);
         methodObject5259 = PreparedStatement.class.getDeclaredMethod("setBinaryStream", Integer.TYPE, InputStream.class, Integer.TYPE);
         methodObject5183 = CallableStatement.class.getDeclaredMethod("getDate", Integer.TYPE, Calendar.class);
         methodObject5354 = OraclePreparedStatement.class.getDeclaredMethod("setStringForClob", Integer.TYPE, String.class);
         methodObject5407 = OraclePreparedStatement.class.getDeclaredMethod("setStructDescriptorAtName", String.class, StructDescriptor.class);
         methodObject5117 = oracle.jdbc.OracleCallableStatement.class.getDeclaredMethod("registerIndexTableOutParameter", Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE);
         methodObject5271 = PreparedStatement.class.getDeclaredMethod("setClob", Integer.TYPE, Reader.class);
         methodObject5291 = Statement.class.getDeclaredMethod("close");
         methodObject5164 = CallableStatement.class.getDeclaredMethod("getInt", Integer.TYPE);
         methodObject5086 = oracle.jdbc.OracleCallableStatement.class.getDeclaredMethod("setRef", String.class, Ref.class);
         methodObject5148 = oracle.jdbc.OracleCallableStatement.class.getDeclaredMethod("setOracleObject", String.class, Datum.class);
         methodObject5071 = oracle.jdbc.OracleCallableStatement.class.getDeclaredMethod("getCursor", Integer.TYPE);
         methodObject5063 = oracle.jdbc.OracleCallableStatement.class.getDeclaredMethod("getUnicodeStream", Integer.TYPE);
         methodObject5122 = oracle.jdbc.OracleCallableStatement.class.getDeclaredMethod("setStringForClob", String.class, String.class);
         methodObject5262 = PreparedStatement.class.getDeclaredMethod("executeUpdate");
         methodObject5193 = CallableStatement.class.getDeclaredMethod("getNClob", Integer.TYPE);
         methodObject5276 = PreparedStatement.class.getDeclaredMethod("setNClob", Integer.TYPE, NClob.class);
         methodObject5368 = OraclePreparedStatement.class.getDeclaredMethod("setINTERVALDS", Integer.TYPE, INTERVALDS.class);
         methodObject5159 = CallableStatement.class.getDeclaredMethod("getBoolean", String.class);
         methodObject5457 = oracle.jdbc.OracleStatement.class.getDeclaredMethod("isNCHAR", Integer.TYPE);
         methodObject5244 = PreparedStatement.class.getDeclaredMethod("setTimestamp", Integer.TYPE, Timestamp.class, Calendar.class);
         methodObject5180 = CallableStatement.class.getDeclaredMethod("getString", Integer.TYPE);
         methodObject5411 = OraclePreparedStatement.class.getDeclaredMethod("setDATEAtName", String.class, DATE.class);
         methodObject5279 = PreparedStatement.class.getDeclaredMethod("setNString", Integer.TYPE, String.class);
         methodObject5497 = ACProxyable.class.getDeclaredMethod("getACProxy");
         methodObject5421 = OraclePreparedStatement.class.getDeclaredMethod("setBFILEAtName", String.class, BFILE.class);
         methodObject5467 = oracle.jdbc.OracleStatement.class.getDeclaredMethod("getLobPrefetchSize");
         methodObject5264 = PreparedStatement.class.getDeclaredMethod("getParameterMetaData");
         methodObject5397 = OraclePreparedStatement.class.getDeclaredMethod("setBinaryDoubleAtName", String.class, BINARY_DOUBLE.class);
         methodObject5218 = CallableStatement.class.getDeclaredMethod("setAsciiStream", String.class, InputStream.class, Long.TYPE);
         methodObject5199 = CallableStatement.class.getDeclaredMethod("getSQLXML", Integer.TYPE);
         methodObject5092 = oracle.jdbc.OracleCallableStatement.class.getDeclaredMethod("getBfile", Integer.TYPE);
         methodObject5253 = PreparedStatement.class.getDeclaredMethod("setAsciiStream", Integer.TYPE, InputStream.class, Long.TYPE);
         methodObject5469 = oracle.jdbc.OracleStatement.class.getDeclaredMethod("closeWithKey", String.class);
         methodObject5288 = PreparedStatement.class.getDeclaredMethod("setUnicodeStream", Integer.TYPE, InputStream.class, Integer.TYPE);
         methodObject5426 = OraclePreparedStatement.class.getDeclaredMethod("setDateAtName", String.class, Date.class, Calendar.class);
         methodObject5444 = OraclePreparedStatement.class.getDeclaredMethod("setPlsqlIndexTable", Integer.TYPE, Object.class, Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE);
         methodObject5173 = CallableStatement.class.getDeclaredMethod("getBytes", String.class);
         methodObject5316 = Statement.class.getDeclaredMethod("getMaxFieldSize");
         methodObject5330 = Statement.class.getDeclaredMethod("setMaxRows", Integer.TYPE);
         methodObject5207 = CallableStatement.class.getDeclaredMethod("getTimestamp", String.class);
         methodObject5096 = oracle.jdbc.OracleCallableStatement.class.getDeclaredMethod("getCustomDatum", Integer.TYPE, CustomDatumFactory.class);
         methodObject5171 = CallableStatement.class.getDeclaredMethod("getDouble", String.class);
      } catch (Throwable var1) {
         throw new RuntimeException(var1);
      }
   }

   public oracle$1jdbc$1replay$1driver$1TxnReplayableStatement$2oracle$1jdbc$1internal$1OracleCallableStatement$$$Proxy(OracleCallableStatement var1, Object var2, ProxyFactory var3, Map var4) {
      this.delegate = var1;
      this.creator = var2;
      this.proxyFactory = var3;
      this.proxyCache = var4;
   }
}
