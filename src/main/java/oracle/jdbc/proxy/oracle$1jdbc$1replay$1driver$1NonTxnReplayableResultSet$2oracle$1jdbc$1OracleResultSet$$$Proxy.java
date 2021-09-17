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
import oracle.jdbc.OracleResultSet;
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

public abstract class oracle$1jdbc$1replay$1driver$1NonTxnReplayableResultSet$2oracle$1jdbc$1OracleResultSet$$$Proxy extends NonTxnReplayableResultSet implements OracleResultSet, _Proxy_ {
   private OracleResultSet delegate;
   private final Object creator;
   private final ProxyFactory proxyFactory;
   private final Map proxyCache;
   private static Object[] zeroLengthObjectArray = new Object[0];
   private static Method methodObject17510;
   private static Method methodObject17376;
   private static Method methodObject17446;
   private static Method methodObject17479;
   private static Method methodObject17299;
   private static Method methodObject17483;
   private static Method methodObject17503;
   private static Method methodObject17342;
   private static Method methodObject17296;
   private static Method methodObject17312;
   private static Method methodObject17462;
   private static Method methodObject17496;
   private static Method methodObject17382;
   private static Method methodObject17358;
   private static Method methodObject17294;
   private static Method methodObject17285;
   private static Method methodObject17514;
   private static Method methodObject17276;
   private static Method methodObject17421;
   private static Method methodObject17527;
   private static Method methodObject17397;
   private static Method methodObject17521;
   private static Method methodObject17378;
   private static Method methodObject17309;
   private static Method methodObject17399;
   private static Method methodObject17415;
   private static Method methodObject17486;
   private static Method methodObject17385;
   private static Method methodObject17407;
   private static Method methodObject17316;
   private static Method methodObject17321;
   private static Method methodObject17396;
   private static Method methodObject17307;
   private static Method methodObject17311;
   private static Method methodObject17363;
   private static Method methodObject17282;
   private static Method methodObject17341;
   private static Method methodObject17509;
   private static Method methodObject17331;
   private static Method methodObject17456;
   private static Method methodObject17450;
   private static Method methodObject17395;
   private static Method methodObject17306;
   private static Method methodObject17404;
   private static Method methodObject17550;
   private static Method methodObject17480;
   private static Method methodObject17540;
   private static Method methodObject17445;
   private static Method methodObject17544;
   private static Method methodObject17507;
   private static Method methodObject17308;
   private static Method methodObject17448;
   private static Method methodObject17413;
   private static Method methodObject17417;
   private static Method methodObject17347;
   private static Method methodObject17355;
   private static Method methodObject17519;
   private static Method methodObject17334;
   private static Method methodObject17380;
   private static Method methodObject17451;
   private static Method methodObject17364;
   private static Method methodObject17424;
   private static Method methodObject17356;
   private static Method methodObject17432;
   private static Method methodObject17354;
   private static Method methodObject17431;
   private static Method methodObject17441;
   private static Method methodObject17531;
   private static Method methodObject17406;
   private static Method methodObject17513;
   private static Method methodObject17469;
   private static Method methodObject17375;
   private static Method methodObject17541;
   private static Method methodObject17516;
   private static Method methodObject17302;
   private static Method methodObject17427;
   private static Method methodObject17433;
   private static Method methodObject17530;
   private static Method methodObject17490;
   private static Method methodObject17453;
   private static Method methodObject17369;
   private static Method methodObject17319;
   private static Method methodObject17426;
   private static Method methodObject17471;
   private static Method methodObject17467;
   private static Method methodObject17439;
   private static Method methodObject17390;
   private static Method methodObject17536;
   private static Method methodObject17482;
   private static Method methodObject17470;
   private static Method methodObject17393;
   private static Method methodObject17290;
   private static Method methodObject17293;
   private static Method methodObject17459;
   private static Method methodObject17305;
   private static Method methodObject17464;
   private static Method methodObject17371;
   private static Method methodObject17388;
   private static Method methodObject17523;
   private static Method methodObject17392;
   private static Method methodObject17444;
   private static Method methodObject17506;
   private static Method methodObject17343;
   private static Method methodObject17298;
   private static Method methodObject17474;
   private static Method methodObject17384;
   private static Method methodObject17401;
   private static Method methodObject17277;
   private static Method methodObject17526;
   private static Method methodObject17323;
   private static Method methodObject17280;
   private static Method methodObject17499;
   private static Method methodObject17545;
   private static Method methodObject17333;
   private static Method methodObject17352;
   private static Method methodObject17324;
   private static Method methodObject17487;
   private static Method methodObject17553;
   private static Method methodObject17511;
   private static Method methodObject17336;
   private static Method methodObject17543;
   private static Method methodObject17478;
   private static Method methodObject17472;
   private static Method methodObject17284;
   private static Method methodObject17522;
   private static Method methodObject17520;
   private static Method methodObject17457;
   private static Method methodObject17552;
   private static Method methodObject17353;
   private static Method methodObject17377;
   private static Method methodObject17340;
   private static Method methodObject17422;
   private static Method methodObject17402;
   private static Method methodObject17534;
   private static Method methodObject17304;
   private static Method methodObject17281;
   private static Method methodObject17429;
   private static Method methodObject17532;
   private static Method methodObject17320;
   private static Method methodObject17425;
   private static Method methodObject17361;
   private static Method methodObject17460;
   private static Method methodObject17329;
   private static Method methodObject17328;
   private static Method methodObject17508;
   private static Method methodObject17339;
   private static Method methodObject17419;
   private static Method methodObject17345;
   private static Method methodObject17330;
   private static Method methodObject17283;
   private static Method methodObject17287;
   private static Method methodObject17504;
   private static Method methodObject17533;
   private static Method methodObject17537;
   private static Method methodObject17297;
   private static Method methodObject17412;
   private static Method methodObject17443;
   private static Method methodObject17485;
   private static Method methodObject17529;
   private static Method methodObject17518;
   private static Method methodObject17300;
   private static Method methodObject17423;
   private static Method methodObject17458;
   private static Method methodObject17365;
   private static Method methodObject17449;
   private static Method methodObject17349;
   private static Method methodObject17525;
   private static Method methodObject17337;
   private static Method methodObject17416;
   private static Method methodObject17370;
   private static Method methodObject17461;
   private static Method methodObject17463;
   private static Method methodObject17408;
   private static Method methodObject17295;
   private static Method methodObject17357;
   private static Method methodObject17547;
   private static Method methodObject17374;
   private static Method methodObject17394;
   private static Method methodObject17325;
   private static Method methodObject17310;
   private static Method methodObject17398;
   private static Method methodObject17434;
   private static Method methodObject17548;
   private static Method methodObject17528;
   private static Method methodObject17366;
   private static Method methodObject17500;
   private static Method methodObject17400;
   private static Method methodObject17346;
   private static Method methodObject17488;
   private static Method methodObject17359;
   private static Method methodObject17549;
   private static Method methodObject17494;
   private static Method methodObject17278;
   private static Method methodObject17515;
   private static Method methodObject17495;
   private static Method methodObject17313;
   private static Method methodObject17389;
   private static Method methodObject17387;
   private static Method methodObject17428;
   private static Method methodObject17447;
   private static Method methodObject17286;
   private static Method methodObject17455;
   private static Method methodObject17372;
   private static Method methodObject17314;
   private static Method methodObject17338;
   private static Method methodObject17332;
   private static Method methodObject17362;
   private static Method methodObject17326;
   private static Method methodObject17477;
   private static Method methodObject17379;
   private static Method methodObject17435;
   private static Method methodObject17497;
   private static Method methodObject17348;
   private static Method methodObject17502;
   private static Method methodObject17466;
   private static Method methodObject17391;
   private static Method methodObject17414;
   private static Method methodObject17322;
   private static Method methodObject17383;
   private static Method methodObject17368;
   private static Method methodObject17542;
   private static Method methodObject17493;
   private static Method methodObject17476;
   private static Method methodObject17452;
   private static Method methodObject17344;
   private static Method methodObject17505;
   private static Method methodObject17437;
   private static Method methodObject17411;
   private static Method methodObject17373;
   private static Method methodObject17410;
   private static Method methodObject17546;
   private static Method methodObject17291;
   private static Method methodObject17386;
   private static Method methodObject17418;
   private static Method methodObject17475;
   private static Method methodObject17409;
   private static Method methodObject17350;
   private static Method methodObject17436;
   private static Method methodObject17512;
   private static Method methodObject17360;
   private static Method methodObject17405;
   private static Method methodObject17538;
   private static Method methodObject17473;
   private static Method methodObject17335;
   private static Method methodObject17317;
   private static Method methodObject17381;
   private static Method methodObject17438;
   private static Method methodObject17327;
   private static Method methodObject17403;
   private static Method methodObject17492;
   private static Method methodObject17491;
   private static Method methodObject17539;
   private static Method methodObject17468;
   private static Method methodObject17315;
   private static Method methodObject17484;
   private static Method methodObject17430;
   private static Method methodObject17524;
   private static Method methodObject17279;
   private static Method methodObject17292;
   private static Method methodObject17535;
   private static Method methodObject17554;
   private static Method methodObject17367;
   private static Method methodObject17351;
   private static Method methodObject17318;
   private static Method methodObject17442;
   private static Method methodObject17420;
   private static Method methodObject17454;
   private static Method methodObject17289;
   private static Method methodObject17303;
   private static Method methodObject17517;
   private static Method methodObject17481;
   private static Method methodObject17440;
   private static Method methodObject17465;
   private static Method methodObject17501;
   private static Method methodObject17551;
   private static Method methodObject17301;
   private static Method methodObject17288;
   private static Method methodObject17498;
   private static Method methodObject17489;

   public void updateBytes(String arg0, byte[] arg1) throws SQLException {
      try {
         super.preForAll(methodObject17510, this, arg0, arg1);
         Method var10001 = methodObject17510;
         this.delegate.updateBytes(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject17510, var4);
      }
   }

   public int getInt(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject17376, this, arg0);
         return (Integer)this.postForAll(methodObject17376, this.delegate.getInt(arg0));
      } catch (SQLException var3) {
         return (Integer)this.postForAll(methodObject17376, this.onErrorForAll(methodObject17376, var3));
      }
   }

   public Time getTime(String arg0, Calendar arg1) throws SQLException {
      try {
         super.preForAll(methodObject17446, this, arg0, arg1);
         return (Time)this.postForAll(methodObject17446, (Object)this.delegate.getTime(arg0, arg1));
      } catch (SQLException var4) {
         return (Time)this.postForAll(methodObject17446, this.onErrorForAll(methodObject17446, var4));
      }
   }

   public InputStream getUnicodeStream(String arg0) throws SQLException {
      try {
         super.preForAll(methodObject17479, this, arg0);
         return (InputStream)this.postForAll(methodObject17479, (Object)this.delegate.getUnicodeStream(arg0));
      } catch (SQLException var3) {
         return (InputStream)this.postForAll(methodObject17479, this.onErrorForAll(methodObject17479, var3));
      }
   }

   public void updateINTERVALDS(String arg0, INTERVALDS arg1) throws SQLException {
      try {
         super.preForAll(methodObject17299, this, arg0, arg1);
         Method var10001 = methodObject17299;
         this.delegate.updateINTERVALDS(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject17299, var4);
      }
   }

   public boolean isLast() throws SQLException {
      try {
         super.preForAll(methodObject17483, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject17483, this.delegate.isLast());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject17483, this.onErrorForAll(methodObject17483, var2));
      }
   }

   public void updateBlob(int arg0, InputStream arg1) throws SQLException {
      try {
         super.preForAll(methodObject17503, this, arg0, arg1);
         Method var10001 = methodObject17503;
         this.delegate.updateBlob(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject17503, var4);
      }
   }

   public OPAQUE getOPAQUE(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject17342, this, arg0);
         return (OPAQUE)this.postForAll(methodObject17342, (Object)this.delegate.getOPAQUE(arg0));
      } catch (SQLException var3) {
         return (OPAQUE)this.postForAll(methodObject17342, this.onErrorForAll(methodObject17342, var3));
      }
   }

   public void updateINTERVALYM(int arg0, INTERVALYM arg1) throws SQLException {
      try {
         super.preForAll(methodObject17296, this, arg0, arg1);
         Method var10001 = methodObject17296;
         this.delegate.updateINTERVALYM(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject17296, var4);
      }
   }

   public void updateREF(int arg0, REF arg1) throws SQLException {
      try {
         super.preForAll(methodObject17312, this, arg0, arg1);
         Method var10001 = methodObject17312;
         this.delegate.updateREF(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject17312, var4);
      }
   }

   public BigDecimal getBigDecimal(String arg0, int arg1) throws SQLException {
      try {
         super.preForAll(methodObject17462, this, arg0, arg1);
         return (BigDecimal)this.postForAll(methodObject17462, (Object)this.delegate.getBigDecimal(arg0, arg1));
      } catch (SQLException var4) {
         return (BigDecimal)this.postForAll(methodObject17462, this.onErrorForAll(methodObject17462, var4));
      }
   }

   public void updateArray(String arg0, Array arg1) throws SQLException {
      try {
         super.preForAll(methodObject17496, this, arg0, arg1);
         Method var10001 = methodObject17496;
         this.delegate.updateArray(arg0, arg1 instanceof _Proxy_ ? (Array)((_Proxy_)arg1)._getDelegate_() : arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject17496, var4);
      }
   }

   public double getDouble(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject17382, this, arg0);
         return (Double)this.postForAll(methodObject17382, this.delegate.getDouble(arg0));
      } catch (SQLException var3) {
         return (Double)this.postForAll(methodObject17382, this.onErrorForAll(methodObject17382, var3));
      }
   }

   public TIMESTAMPTZ getTIMESTAMPTZ(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject17358, this, arg0);
         return (TIMESTAMPTZ)this.postForAll(methodObject17358, (Object)this.delegate.getTIMESTAMPTZ(arg0));
      } catch (SQLException var3) {
         return (TIMESTAMPTZ)this.postForAll(methodObject17358, this.onErrorForAll(methodObject17358, var3));
      }
   }

   public void updateDATE(int arg0, DATE arg1) throws SQLException {
      try {
         super.preForAll(methodObject17294, this, arg0, arg1);
         Method var10001 = methodObject17294;
         this.delegate.updateDATE(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject17294, var4);
      }
   }

   public void updateBFILE(String arg0, BFILE arg1) throws SQLException {
      try {
         super.preForAll(methodObject17285, this, arg0, arg1);
         Method var10001 = methodObject17285;
         this.delegate.updateBFILE(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject17285, var4);
      }
   }

   public void updateClob(String arg0, Reader arg1, long arg2) throws SQLException {
      try {
         super.preForAll(methodObject17514, this, arg0, arg1, arg2);
         Method var10001 = methodObject17514;
         this.delegate.updateClob(arg0, arg1, arg2);
         this.postForAll(var10001);
      } catch (SQLException var6) {
         this.onErrorVoidForAll(methodObject17514, var6);
      }
   }

   public Object getObject(int arg0, OracleDataFactory arg1) throws SQLException {
      try {
         super.preForAll(methodObject17276, this, arg0, arg1);
         return this.postForAll(methodObject17276, this.proxyFactory.proxyForCreate(this.delegate.getObject(arg0, arg1), this, this.proxyCache, methodObject17276));
      } catch (SQLException var4) {
         return this.postForAll(methodObject17276, this.onErrorForAll(methodObject17276, var4));
      }
   }

   public void updateCharacterStream(int arg0, Reader arg1) throws SQLException {
      try {
         super.preForUpdateStreams(methodObject17421, this, arg0, arg1);
         Method var10001 = methodObject17421;
         this.delegate.updateCharacterStream(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject17421, var4);
      }
   }

   public void updateNClob(int arg0, NClob arg1) throws SQLException {
      try {
         super.preForAll(methodObject17527, this, arg0, arg1);
         Method var10001 = methodObject17527;
         this.delegate.updateNClob(arg0, arg1 instanceof _Proxy_ ? (NClob)((_Proxy_)arg1)._getDelegate_() : arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject17527, var4);
      }
   }

   public String getString(String arg0) throws SQLException {
      try {
         super.preForAll(methodObject17397, this, arg0);
         return (String)this.postForAll(methodObject17397, (Object)this.delegate.getString(arg0));
      } catch (SQLException var3) {
         return (String)this.postForAll(methodObject17397, this.onErrorForAll(methodObject17397, var3));
      }
   }

   public void updateFloat(int arg0, float arg1) throws SQLException {
      try {
         super.preForAll(methodObject17521, this, arg0, arg1);
         Method var10001 = methodObject17521;
         this.delegate.updateFloat(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject17521, var4);
      }
   }

   public long getLong(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject17378, this, arg0);
         return (Long)this.postForAll(methodObject17378, this.delegate.getLong(arg0));
      } catch (SQLException var3) {
         return (Long)this.postForAll(methodObject17378, this.onErrorForAll(methodObject17378, var3));
      }
   }

   public void updateOracleObject(String arg0, Datum arg1) throws SQLException {
      try {
         super.preForAll(methodObject17309, this, arg0, arg1);
         Method var10001 = methodObject17309;
         this.delegate.updateOracleObject(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject17309, var4);
      }
   }

   public Date getDate(String arg0) throws SQLException {
      try {
         super.preForAll(methodObject17399, this, arg0);
         return (Date)this.postForAll(methodObject17399, (Object)this.delegate.getDate(arg0));
      } catch (SQLException var3) {
         return (Date)this.postForAll(methodObject17399, this.onErrorForAll(methodObject17399, var3));
      }
   }

   public void updateBinaryStream(int arg0, InputStream arg1) throws SQLException {
      try {
         super.preForUpdateStreams(methodObject17415, this, arg0, arg1);
         Method var10001 = methodObject17415;
         this.delegate.updateBinaryStream(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject17415, var4);
      }
   }

   public void refreshRow() throws SQLException {
      try {
         super.preForAll(methodObject17486, this, zeroLengthObjectArray);
         Method var10001 = methodObject17486;
         this.delegate.refreshRow();
         this.postForAll(var10001);
      } catch (SQLException var2) {
         this.onErrorVoidForAll(methodObject17486, var2);
      }
   }

   public byte[] getBytes(String arg0) throws SQLException {
      try {
         super.preForAll(methodObject17385, this, arg0);
         return (byte[])this.postForAll(methodObject17385, (Object)this.delegate.getBytes(arg0));
      } catch (SQLException var3) {
         return (byte[])this.postForAll(methodObject17385, this.onErrorForAll(methodObject17385, var3));
      }
   }

   public void updateAsciiStream(int arg0, InputStream arg1, long arg2) throws SQLException {
      try {
         super.preForUpdateStreams(methodObject17407, this, arg0, arg1, arg2);
         Method var10001 = methodObject17407;
         this.delegate.updateAsciiStream(arg0, arg1, arg2);
         this.postForAll(var10001);
      } catch (SQLException var6) {
         this.onErrorVoidForAll(methodObject17407, var6);
      }
   }

   public void updateSTRUCT(int arg0, STRUCT arg1) throws SQLException {
      try {
         super.preForAll(methodObject17316, this, arg0, arg1);
         Method var10001 = methodObject17316;
         this.delegate.updateSTRUCT(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject17316, var4);
      }
   }

   public Datum getOracleObject(String arg0) throws SQLException {
      try {
         super.preForAll(methodObject17321, this, arg0);
         return (Datum)this.postForAll(methodObject17321, (Object)this.delegate.getOracleObject(arg0));
      } catch (SQLException var3) {
         return (Datum)this.postForAll(methodObject17321, this.onErrorForAll(methodObject17321, var3));
      }
   }

   public String getString(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject17396, this, arg0);
         return (String)this.postForAll(methodObject17396, (Object)this.delegate.getString(arg0));
      } catch (SQLException var3) {
         return (String)this.postForAll(methodObject17396, this.onErrorForAll(methodObject17396, var3));
      }
   }

   public void updateNUMBER(String arg0, NUMBER arg1) throws SQLException {
      try {
         super.preForAll(methodObject17307, this, arg0, arg1);
         Method var10001 = methodObject17307;
         this.delegate.updateNUMBER(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject17307, var4);
      }
   }

   public void updateRAW(String arg0, RAW arg1) throws SQLException {
      try {
         super.preForAll(methodObject17311, this, arg0, arg1);
         Method var10001 = methodObject17311;
         this.delegate.updateRAW(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject17311, var4);
      }
   }

   public ARRAY getARRAY(String arg0) throws SQLException {
      try {
         super.preForAll(methodObject17363, this, arg0);
         return (ARRAY)this.postForAll(methodObject17363, (Object)this.delegate.getARRAY(arg0));
      } catch (SQLException var3) {
         return (ARRAY)this.postForAll(methodObject17363, this.onErrorForAll(methodObject17363, var3));
      }
   }

   public void updateBfile(int arg0, BFILE arg1) throws SQLException {
      try {
         super.preForAll(methodObject17282, this, arg0, arg1);
         Method var10001 = methodObject17282;
         this.delegate.updateBfile(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject17282, var4);
      }
   }

   public NUMBER getNUMBER(String arg0) throws SQLException {
      try {
         super.preForAll(methodObject17341, this, arg0);
         return (NUMBER)this.postForAll(methodObject17341, (Object)this.delegate.getNUMBER(arg0));
      } catch (SQLException var3) {
         return (NUMBER)this.postForAll(methodObject17341, this.onErrorForAll(methodObject17341, var3));
      }
   }

   public void updateBytes(int arg0, byte[] arg1) throws SQLException {
      try {
         super.preForAll(methodObject17509, this, arg0, arg1);
         Method var10001 = methodObject17509;
         this.delegate.updateBytes(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject17509, var4);
      }
   }

   public CHAR getCHAR(String arg0) throws SQLException {
      try {
         super.preForAll(methodObject17331, this, arg0);
         return (CHAR)this.postForAll(methodObject17331, (Object)this.delegate.getCHAR(arg0));
      } catch (SQLException var3) {
         return (CHAR)this.postForAll(methodObject17331, this.onErrorForAll(methodObject17331, var3));
      }
   }

   public boolean wasNull() throws SQLException {
      try {
         super.preForAll(methodObject17456, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject17456, this.delegate.wasNull());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject17456, this.onErrorForAll(methodObject17456, var2));
      }
   }

   public void updateTime(int arg0, Time arg1) throws SQLException {
      try {
         super.preForAll(methodObject17450, this, arg0, arg1);
         Method var10001 = methodObject17450;
         this.delegate.updateTime(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject17450, var4);
      }
   }

   public Ref getRef(String arg0) throws SQLException {
      try {
         super.preForAll(methodObject17395, this, arg0);
         return (Ref)this.postForAll(methodObject17395, this.proxyFactory.proxyForCreate((Object)this.delegate.getRef(arg0), this, this.proxyCache, methodObject17395));
      } catch (SQLException var3) {
         return (Ref)this.postForAll(methodObject17395, this.onErrorForAll(methodObject17395, var3));
      }
   }

   public void updateNUMBER(int arg0, NUMBER arg1) throws SQLException {
      try {
         super.preForAll(methodObject17306, this, arg0, arg1);
         Method var10001 = methodObject17306;
         this.delegate.updateNUMBER(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject17306, var4);
      }
   }

   public void updateRow() throws SQLException {
      try {
         super.preForRowUpdates(methodObject17404, this, zeroLengthObjectArray);
         Method var10001 = methodObject17404;
         this.delegate.updateRow();
         this.postForAll(var10001);
      } catch (SQLException var2) {
         this.onErrorVoidForAll(methodObject17404, var2);
      }
   }

   public void updateString(String arg0, String arg1) throws SQLException {
      try {
         super.preForAll(methodObject17550, this, arg0, arg1);
         Method var10001 = methodObject17550;
         this.delegate.updateString(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject17550, var4);
      }
   }

   public boolean isAfterLast() throws SQLException {
      try {
         super.preForAll(methodObject17480, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject17480, this.delegate.isAfterLast());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject17480, this.onErrorForAll(methodObject17480, var2));
      }
   }

   public void updateObject(String arg0, Object arg1) throws SQLException {
      try {
         super.preForAll(methodObject17540, this, arg0, arg1);
         Method var10001 = methodObject17540;
         this.delegate.updateObject(arg0, arg1 instanceof _Proxy_ ? (Object)((_Proxy_)arg1)._getDelegate_() : arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject17540, var4);
      }
   }

   public Time getTime(int arg0, Calendar arg1) throws SQLException {
      try {
         super.preForAll(methodObject17445, this, arg0, arg1);
         return (Time)this.postForAll(methodObject17445, (Object)this.delegate.getTime(arg0, arg1));
      } catch (SQLException var4) {
         return (Time)this.postForAll(methodObject17445, this.onErrorForAll(methodObject17445, var4));
      }
   }

   public void updateRowId(String arg0, RowId arg1) throws SQLException {
      try {
         super.preForAll(methodObject17544, this, arg0, arg1);
         Method var10001 = methodObject17544;
         this.delegate.updateRowId(arg0, arg1 instanceof _Proxy_ ? (RowId)((_Proxy_)arg1)._getDelegate_() : arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject17544, var4);
      }
   }

   public void updateByte(int arg0, byte arg1) throws SQLException {
      try {
         super.preForAll(methodObject17507, this, arg0, arg1);
         Method var10001 = methodObject17507;
         this.delegate.updateByte(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject17507, var4);
      }
   }

   public void updateOracleObject(int arg0, Datum arg1) throws SQLException {
      try {
         super.preForAll(methodObject17308, this, arg0, arg1);
         Method var10001 = methodObject17308;
         this.delegate.updateOracleObject(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject17308, var4);
      }
   }

   public void clearWarnings() throws SQLException {
      try {
         super.preForAll(methodObject17448, this, zeroLengthObjectArray);
         Method var10001 = methodObject17448;
         this.delegate.clearWarnings();
         this.postForAll(var10001);
      } catch (SQLException var2) {
         this.onErrorVoidForAll(methodObject17448, var2);
      }
   }

   public void updateBinaryStream(int arg0, InputStream arg1, long arg2) throws SQLException {
      try {
         super.preForUpdateStreams(methodObject17413, this, arg0, arg1, arg2);
         Method var10001 = methodObject17413;
         this.delegate.updateBinaryStream(arg0, arg1, arg2);
         this.postForAll(var10001);
      } catch (SQLException var6) {
         this.onErrorVoidForAll(methodObject17413, var6);
      }
   }

   public void updateCharacterStream(int arg0, Reader arg1, int arg2) throws SQLException {
      try {
         super.preForUpdateStreams(methodObject17417, this, arg0, arg1, arg2);
         Method var10001 = methodObject17417;
         this.delegate.updateCharacterStream(arg0, arg1, arg2);
         this.postForAll(var10001);
      } catch (SQLException var5) {
         this.onErrorVoidForAll(methodObject17417, var5);
      }
   }

   public REF getREF(String arg0) throws SQLException {
      try {
         super.preForAll(methodObject17347, this, arg0);
         return (REF)this.postForAll(methodObject17347, (Object)this.delegate.getREF(arg0));
      } catch (SQLException var3) {
         return (REF)this.postForAll(methodObject17347, this.onErrorForAll(methodObject17347, var3));
      }
   }

   public INTERVALDS getINTERVALDS(String arg0) throws SQLException {
      try {
         super.preForAll(methodObject17355, this, arg0);
         return (INTERVALDS)this.postForAll(methodObject17355, (Object)this.delegate.getINTERVALDS(arg0));
      } catch (SQLException var3) {
         return (INTERVALDS)this.postForAll(methodObject17355, this.onErrorForAll(methodObject17355, var3));
      }
   }

   public void updateDouble(int arg0, double arg1) throws SQLException {
      try {
         super.preForAll(methodObject17519, this, arg0, arg1);
         Method var10001 = methodObject17519;
         this.delegate.updateDouble(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var5) {
         this.onErrorVoidForAll(methodObject17519, var5);
      }
   }

   public CustomDatum getCustomDatum(int arg0, CustomDatumFactory arg1) throws SQLException {
      try {
         super.preForAll(methodObject17334, this, arg0, arg1);
         return (CustomDatum)this.postForAll(methodObject17334, (Object)this.delegate.getCustomDatum(arg0, arg1));
      } catch (SQLException var4) {
         return (CustomDatum)this.postForAll(methodObject17334, this.onErrorForAll(methodObject17334, var4));
      }
   }

   public float getFloat(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject17380, this, arg0);
         return (Float)this.postForAll(methodObject17380, this.delegate.getFloat(arg0));
      } catch (SQLException var3) {
         return (Float)this.postForAll(methodObject17380, this.onErrorForAll(methodObject17380, var3));
      }
   }

   public void updateTime(String arg0, Time arg1) throws SQLException {
      try {
         super.preForAll(methodObject17451, this, arg0, arg1);
         Method var10001 = methodObject17451;
         this.delegate.updateTime(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject17451, var4);
      }
   }

   public Object getObject(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject17364, this, arg0);
         return this.postForAll(methodObject17364, this.proxyFactory.proxyForCreate(this.delegate.getObject(arg0), this, this.proxyCache, methodObject17364));
      } catch (SQLException var3) {
         return this.postForAll(methodObject17364, this.onErrorForAll(methodObject17364, var3));
      }
   }

   public void updateNCharacterStream(String arg0, Reader arg1, long arg2) throws SQLException {
      try {
         super.preForUpdateStreams(methodObject17424, this, arg0, arg1, arg2);
         Method var10001 = methodObject17424;
         this.delegate.updateNCharacterStream(arg0, arg1, arg2);
         this.postForAll(var10001);
      } catch (SQLException var6) {
         this.onErrorVoidForAll(methodObject17424, var6);
      }
   }

   public TIMESTAMP getTIMESTAMP(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject17356, this, arg0);
         return (TIMESTAMP)this.postForAll(methodObject17356, (Object)this.delegate.getTIMESTAMP(arg0));
      } catch (SQLException var3) {
         return (TIMESTAMP)this.postForAll(methodObject17356, this.onErrorForAll(methodObject17356, var3));
      }
   }

   public ResultSetMetaData getMetaData() throws SQLException {
      try {
         super.preForAll(methodObject17432, this, zeroLengthObjectArray);
         return (ResultSetMetaData)this.postForAll(methodObject17432, this.proxyFactory.proxyForCreate((Object)this.delegate.getMetaData(), this, this.proxyCache, methodObject17432));
      } catch (SQLException var2) {
         return (ResultSetMetaData)this.postForAll(methodObject17432, this.onErrorForAll(methodObject17432, var2));
      }
   }

   public INTERVALDS getINTERVALDS(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject17354, this, arg0);
         return (INTERVALDS)this.postForAll(methodObject17354, (Object)this.delegate.getINTERVALDS(arg0));
      } catch (SQLException var3) {
         return (INTERVALDS)this.postForAll(methodObject17354, this.onErrorForAll(methodObject17354, var3));
      }
   }

   public boolean isClosed() throws SQLException {
      try {
         super.preForAll(methodObject17431, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject17431, this.delegate.isClosed());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject17431, this.onErrorForAll(methodObject17431, var2));
      }
   }

   public SQLXML getSQLXML(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject17441, this, arg0);
         return (SQLXML)this.postForAll(methodObject17441, this.proxyFactory.proxyForCreate((Object)this.delegate.getSQLXML(arg0), this, this.proxyCache, methodObject17441));
      } catch (SQLException var3) {
         return (SQLXML)this.postForAll(methodObject17441, this.onErrorForAll(methodObject17441, var3));
      }
   }

   public void updateNClob(int arg0, Reader arg1) throws SQLException {
      try {
         super.preForAll(methodObject17531, this, arg0, arg1);
         Method var10001 = methodObject17531;
         this.delegate.updateNClob(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject17531, var4);
      }
   }

   public void updateAsciiStream(String arg0, InputStream arg1, int arg2) throws SQLException {
      try {
         super.preForUpdateStreams(methodObject17406, this, arg0, arg1, arg2);
         Method var10001 = methodObject17406;
         this.delegate.updateAsciiStream(arg0, arg1, arg2);
         this.postForAll(var10001);
      } catch (SQLException var5) {
         this.onErrorVoidForAll(methodObject17406, var5);
      }
   }

   public void updateClob(int arg0, Reader arg1, long arg2) throws SQLException {
      try {
         super.preForAll(methodObject17513, this, arg0, arg1, arg2);
         Method var10001 = methodObject17513;
         this.delegate.updateClob(arg0, arg1, arg2);
         this.postForAll(var10001);
      } catch (SQLException var6) {
         this.onErrorVoidForAll(methodObject17513, var6);
      }
   }

   public Reader getNCharacterStream(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject17469, this, arg0);
         return (Reader)this.postForAll(methodObject17469, (Object)this.delegate.getNCharacterStream(arg0));
      } catch (SQLException var3) {
         return (Reader)this.postForAll(methodObject17469, this.onErrorForAll(methodObject17469, var3));
      }
   }

   public short getShort(String arg0) throws SQLException {
      try {
         super.preForAll(methodObject17375, this, arg0);
         return (Short)this.postForAll(methodObject17375, this.delegate.getShort(arg0));
      } catch (SQLException var3) {
         return (Short)this.postForAll(methodObject17375, this.onErrorForAll(methodObject17375, var3));
      }
   }

   public void updateRef(int arg0, Ref arg1) throws SQLException {
      try {
         super.preForAll(methodObject17541, this, arg0, arg1);
         Method var10001 = methodObject17541;
         this.delegate.updateRef(arg0, arg1 instanceof _Proxy_ ? (Ref)((_Proxy_)arg1)._getDelegate_() : arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject17541, var4);
      }
   }

   public void updateClob(String arg0, Reader arg1) throws SQLException {
      try {
         super.preForAll(methodObject17516, this, arg0, arg1);
         Method var10001 = methodObject17516;
         this.delegate.updateClob(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject17516, var4);
      }
   }

   public void updateTIMESTAMPTZ(int arg0, TIMESTAMPTZ arg1) throws SQLException {
      try {
         super.preForAll(methodObject17302, this, arg0, arg1);
         Method var10001 = methodObject17302;
         this.delegate.updateTIMESTAMPTZ(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject17302, var4);
      }
   }

   public boolean last() throws SQLException {
      try {
         super.preForAll(methodObject17427, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject17427, this.delegate.last());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject17427, this.onErrorForLast(methodObject17427, var2));
      }
   }

   public Blob getBlob(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject17433, this, arg0);
         return (Blob)this.postForAll(methodObject17433, this.proxyFactory.proxyForCreate((Object)this.delegate.getBlob(arg0), this, this.proxyCache, methodObject17433));
      } catch (SQLException var3) {
         return (Blob)this.postForAll(methodObject17433, this.onErrorForAll(methodObject17433, var3));
      }
   }

   public void updateNClob(String arg0, Reader arg1, long arg2) throws SQLException {
      try {
         super.preForAll(methodObject17530, this, arg0, arg1, arg2);
         Method var10001 = methodObject17530;
         this.delegate.updateNClob(arg0, arg1, arg2);
         this.postForAll(var10001);
      } catch (SQLException var6) {
         this.onErrorVoidForAll(methodObject17530, var6);
      }
   }

   public boolean rowUpdated() throws SQLException {
      try {
         super.preForAll(methodObject17490, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject17490, this.delegate.rowUpdated());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject17490, this.onErrorForAll(methodObject17490, var2));
      }
   }

   public InputStream getAsciiStream(String arg0) throws SQLException {
      try {
         super.preForAll(methodObject17453, this, arg0);
         return (InputStream)this.postForAll(methodObject17453, (Object)this.delegate.getAsciiStream(arg0));
      } catch (SQLException var3) {
         return (InputStream)this.postForAll(methodObject17453, this.onErrorForAll(methodObject17453, var3));
      }
   }

   public Object getObject(String arg0, Class arg1) throws SQLException {
      try {
         super.preForAll(methodObject17369, this, arg0, arg1);
         return this.postForAll(methodObject17369, this.proxyFactory.proxyForCreate(this.delegate.getObject(arg0, arg1), this, this.proxyCache, methodObject17369));
      } catch (SQLException var4) {
         return this.postForAll(methodObject17369, this.onErrorForAll(methodObject17369, var4));
      }
   }

   public OracleResultSet.AuthorizationIndicator getAuthorizationIndicator(String arg0) throws SQLException {
      try {
         super.preForAll(methodObject17319, this, arg0);
         return (OracleResultSet.AuthorizationIndicator)this.postForAll(methodObject17319, (Object)this.delegate.getAuthorizationIndicator(arg0));
      } catch (SQLException var3) {
         return (OracleResultSet.AuthorizationIndicator)this.postForAll(methodObject17319, this.onErrorForAll(methodObject17319, var3));
      }
   }

   public void updateNCharacterStream(String arg0, Reader arg1) throws SQLException {
      try {
         super.preForUpdateStreams(methodObject17426, this, arg0, arg1);
         Method var10001 = methodObject17426;
         this.delegate.updateNCharacterStream(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject17426, var4);
      }
   }

   public String getNString(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject17471, this, arg0);
         return (String)this.postForAll(methodObject17471, (Object)this.delegate.getNString(arg0));
      } catch (SQLException var3) {
         return (String)this.postForAll(methodObject17471, this.onErrorForAll(methodObject17471, var3));
      }
   }

   public int getFetchDirection() throws SQLException {
      try {
         super.preForAll(methodObject17467, this, zeroLengthObjectArray);
         return (Integer)this.postForAll(methodObject17467, this.delegate.getFetchDirection());
      } catch (SQLException var2) {
         return (Integer)this.postForAll(methodObject17467, this.onErrorForAll(methodObject17467, var2));
      }
   }

   public RowId getRowId(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject17439, this, arg0);
         return (RowId)this.postForAll(methodObject17439, this.proxyFactory.proxyForCreate((Object)this.delegate.getRowId(arg0), this, this.proxyCache, methodObject17439));
      } catch (SQLException var3) {
         return (RowId)this.postForAll(methodObject17439, this.onErrorForAll(methodObject17439, var3));
      }
   }

   public URL getURL(String arg0) throws SQLException {
      try {
         super.preForAll(methodObject17390, this, arg0);
         return (URL)this.postForAll(methodObject17390, (Object)this.delegate.getURL(arg0));
      } catch (SQLException var3) {
         return (URL)this.postForAll(methodObject17390, this.onErrorForAll(methodObject17390, var3));
      }
   }

   public void updateNull(String arg0) throws SQLException {
      try {
         super.preForAll(methodObject17536, this, arg0);
         Method var10001 = methodObject17536;
         this.delegate.updateNull(arg0);
         this.postForAll(var10001);
      } catch (SQLException var3) {
         this.onErrorVoidForAll(methodObject17536, var3);
      }
   }

   public boolean isFirst() throws SQLException {
      try {
         super.preForAll(methodObject17482, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject17482, this.delegate.isFirst());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject17482, this.onErrorForAll(methodObject17482, var2));
      }
   }

   public Reader getNCharacterStream(String arg0) throws SQLException {
      try {
         super.preForAll(methodObject17470, this, arg0);
         return (Reader)this.postForAll(methodObject17470, (Object)this.delegate.getNCharacterStream(arg0));
      } catch (SQLException var3) {
         return (Reader)this.postForAll(methodObject17470, this.onErrorForAll(methodObject17470, var3));
      }
   }

   public boolean previous() throws SQLException {
      try {
         super.preForAll(methodObject17393, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject17393, this.delegate.previous());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject17393, this.onErrorForAll(methodObject17393, var2));
      }
   }

   public void updateCLOB(int arg0, CLOB arg1) throws SQLException {
      try {
         super.preForAll(methodObject17290, this, arg0, arg1);
         Method var10001 = methodObject17290;
         this.delegate.updateCLOB(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject17290, var4);
      }
   }

   public void updateORAData(String arg0, ORAData arg1) throws SQLException {
      try {
         super.preForAll(methodObject17293, this, arg0, arg1);
         Method var10001 = methodObject17293;
         this.delegate.updateORAData(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject17293, var4);
      }
   }

   public int findColumn(String arg0) throws SQLException {
      try {
         super.preForAll(methodObject17459, this, arg0);
         return (Integer)this.postForAll(methodObject17459, this.delegate.findColumn(arg0));
      } catch (SQLException var3) {
         return (Integer)this.postForAll(methodObject17459, this.onErrorForAll(methodObject17459, var3));
      }
   }

   public void updateTIMESTAMPLTZ(String arg0, TIMESTAMPLTZ arg1) throws SQLException {
      try {
         super.preForAll(methodObject17305, this, arg0, arg1);
         Method var10001 = methodObject17305;
         this.delegate.updateTIMESTAMPLTZ(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject17305, var4);
      }
   }

   public BigDecimal getBigDecimal(String arg0) throws SQLException {
      try {
         super.preForAll(methodObject17464, this, arg0);
         return (BigDecimal)this.postForAll(methodObject17464, (Object)this.delegate.getBigDecimal(arg0));
      } catch (SQLException var3) {
         return (BigDecimal)this.postForAll(methodObject17464, this.onErrorForAll(methodObject17464, var3));
      }
   }

   public boolean getBoolean(String arg0) throws SQLException {
      try {
         super.preForAll(methodObject17371, this, arg0);
         return (Boolean)this.postForAll(methodObject17371, this.delegate.getBoolean(arg0));
      } catch (SQLException var3) {
         return (Boolean)this.postForAll(methodObject17371, this.onErrorForAll(methodObject17371, var3));
      }
   }

   public boolean next() throws SQLException {
      try {
         super.preForAll(methodObject17388, this, zeroLengthObjectArray);
         return this.postForNext(methodObject17388, this.delegate.next());
      } catch (SQLException var2) {
         return this.postForNext(methodObject17388, (Boolean)this.onErrorForAll(methodObject17388, var2));
      }
   }

   public void updateInt(int arg0, int arg1) throws SQLException {
      try {
         super.preForAll(methodObject17523, this, arg0, arg1);
         Method var10001 = methodObject17523;
         this.delegate.updateInt(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject17523, var4);
      }
   }

   public int getType() throws SQLException {
      try {
         super.preForAll(methodObject17392, this, zeroLengthObjectArray);
         return (Integer)this.postForAll(methodObject17392, this.delegate.getType());
      } catch (SQLException var2) {
         return (Integer)this.postForAll(methodObject17392, this.onErrorForAll(methodObject17392, var2));
      }
   }

   public Time getTime(String arg0) throws SQLException {
      try {
         super.preForAll(methodObject17444, this, arg0);
         return (Time)this.postForAll(methodObject17444, (Object)this.delegate.getTime(arg0));
      } catch (SQLException var3) {
         return (Time)this.postForAll(methodObject17444, this.onErrorForAll(methodObject17444, var3));
      }
   }

   public void updateBoolean(String arg0, boolean arg1) throws SQLException {
      try {
         super.preForAll(methodObject17506, this, arg0, arg1);
         Method var10001 = methodObject17506;
         this.delegate.updateBoolean(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject17506, var4);
      }
   }

   public OPAQUE getOPAQUE(String arg0) throws SQLException {
      try {
         super.preForAll(methodObject17343, this, arg0);
         return (OPAQUE)this.postForAll(methodObject17343, (Object)this.delegate.getOPAQUE(arg0));
      } catch (SQLException var3) {
         return (OPAQUE)this.postForAll(methodObject17343, this.onErrorForAll(methodObject17343, var3));
      }
   }

   public void updateINTERVALDS(int arg0, INTERVALDS arg1) throws SQLException {
      try {
         super.preForAll(methodObject17298, this, arg0, arg1);
         Method var10001 = methodObject17298;
         this.delegate.updateINTERVALDS(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject17298, var4);
      }
   }

   public Timestamp getTimestamp(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject17474, this, arg0);
         return (Timestamp)this.postForAll(methodObject17474, (Object)this.delegate.getTimestamp(arg0));
      } catch (SQLException var3) {
         return (Timestamp)this.postForAll(methodObject17474, this.onErrorForAll(methodObject17474, var3));
      }
   }

   public byte[] getBytes(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject17384, this, arg0);
         return (byte[])this.postForAll(methodObject17384, (Object)this.delegate.getBytes(arg0));
      } catch (SQLException var3) {
         return (byte[])this.postForAll(methodObject17384, this.onErrorForAll(methodObject17384, var3));
      }
   }

   public Date getDate(String arg0, Calendar arg1) throws SQLException {
      try {
         super.preForAll(methodObject17401, this, arg0, arg1);
         return (Date)this.postForAll(methodObject17401, (Object)this.delegate.getDate(arg0, arg1));
      } catch (SQLException var4) {
         return (Date)this.postForAll(methodObject17401, this.onErrorForAll(methodObject17401, var4));
      }
   }

   public Object getObject(String arg0, OracleDataFactory arg1) throws SQLException {
      try {
         super.preForAll(methodObject17277, this, arg0, arg1);
         return this.postForAll(methodObject17277, this.proxyFactory.proxyForCreate(this.delegate.getObject(arg0, arg1), this, this.proxyCache, methodObject17277));
      } catch (SQLException var4) {
         return this.postForAll(methodObject17277, this.onErrorForAll(methodObject17277, var4));
      }
   }

   public void updateLong(String arg0, long arg1) throws SQLException {
      try {
         super.preForAll(methodObject17526, this, arg0, arg1);
         Method var10001 = methodObject17526;
         this.delegate.updateLong(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var5) {
         this.onErrorVoidForAll(methodObject17526, var5);
      }
   }

   public ResultSet getCursor(String arg0) throws SQLException {
      try {
         super.preForAll(methodObject17323, this, arg0);
         return (ResultSet)this.postForAll(methodObject17323, this.proxyFactory.proxyForCreate((Object)this.delegate.getCursor(arg0), this, this.proxyCache, methodObject17323));
      } catch (SQLException var3) {
         return (ResultSet)this.postForAll(methodObject17323, this.onErrorForAll(methodObject17323, var3));
      }
   }

   public void updateARRAY(int arg0, ARRAY arg1) throws SQLException {
      try {
         super.preForAll(methodObject17280, this, arg0, arg1);
         Method var10001 = methodObject17280;
         this.delegate.updateARRAY(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject17280, var4);
      }
   }

   public void updateBlob(int arg0, Blob arg1) throws SQLException {
      try {
         super.preForAll(methodObject17499, this, arg0, arg1);
         Method var10001 = methodObject17499;
         this.delegate.updateBlob(arg0, arg1 instanceof _Proxy_ ? (Blob)((_Proxy_)arg1)._getDelegate_() : arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject17499, var4);
      }
   }

   public void updateSQLXML(int arg0, SQLXML arg1) throws SQLException {
      try {
         super.preForAll(methodObject17545, this, arg0, arg1);
         Method var10001 = methodObject17545;
         this.delegate.updateSQLXML(arg0, arg1 instanceof _Proxy_ ? (SQLXML)((_Proxy_)arg1)._getDelegate_() : arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject17545, var4);
      }
   }

   public CLOB getCLOB(String arg0) throws SQLException {
      try {
         super.preForAll(methodObject17333, this, arg0);
         return (CLOB)this.postForAll(methodObject17333, (Object)this.delegate.getCLOB(arg0));
      } catch (SQLException var3) {
         return (CLOB)this.postForAll(methodObject17333, this.onErrorForAll(methodObject17333, var3));
      }
   }

   public INTERVALYM getINTERVALYM(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject17352, this, arg0);
         return (INTERVALYM)this.postForAll(methodObject17352, (Object)this.delegate.getINTERVALYM(arg0));
      } catch (SQLException var3) {
         return (INTERVALYM)this.postForAll(methodObject17352, this.onErrorForAll(methodObject17352, var3));
      }
   }

   public BFILE getBFILE(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject17324, this, arg0);
         return (BFILE)this.postForAll(methodObject17324, (Object)this.delegate.getBFILE(arg0));
      } catch (SQLException var3) {
         return (BFILE)this.postForAll(methodObject17324, this.onErrorForAll(methodObject17324, var3));
      }
   }

   public boolean relative(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject17487, this, arg0);
         return (Boolean)this.postForAll(methodObject17487, this.delegate.relative(arg0));
      } catch (SQLException var3) {
         return (Boolean)this.postForAll(methodObject17487, this.onErrorForAll(methodObject17487, var3));
      }
   }

   public Object unwrap(Class arg0) throws SQLException {
      try {
         super.preForAll(methodObject17553, this, arg0);
         return this.postForAll(methodObject17553, super.unwrap(arg0));
      } catch (SQLException var3) {
         return this.postForAll(methodObject17553, this.onErrorForAll(methodObject17553, var3));
      }
   }

   public void updateClob(int arg0, Clob arg1) throws SQLException {
      try {
         super.preForAll(methodObject17511, this, arg0, arg1);
         Method var10001 = methodObject17511;
         this.delegate.updateClob(arg0, arg1 instanceof _Proxy_ ? (Clob)((_Proxy_)arg1)._getDelegate_() : arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject17511, var4);
      }
   }

   public ORAData getORAData(int arg0, ORADataFactory arg1) throws SQLException {
      try {
         super.preForAll(methodObject17336, this, arg0, arg1);
         return (ORAData)this.postForAll(methodObject17336, (Object)this.delegate.getORAData(arg0, arg1));
      } catch (SQLException var4) {
         return (ORAData)this.postForAll(methodObject17336, this.onErrorForAll(methodObject17336, var4));
      }
   }

   public void updateRowId(int arg0, RowId arg1) throws SQLException {
      try {
         super.preForAll(methodObject17543, this, arg0, arg1);
         Method var10001 = methodObject17543;
         this.delegate.updateRowId(arg0, arg1 instanceof _Proxy_ ? (RowId)((_Proxy_)arg1)._getDelegate_() : arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject17543, var4);
      }
   }

   public InputStream getUnicodeStream(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject17478, this, arg0);
         return (InputStream)this.postForAll(methodObject17478, (Object)this.delegate.getUnicodeStream(arg0));
      } catch (SQLException var3) {
         return (InputStream)this.postForAll(methodObject17478, this.onErrorForAll(methodObject17478, var3));
      }
   }

   public String getNString(String arg0) throws SQLException {
      try {
         super.preForAll(methodObject17472, this, arg0);
         return (String)this.postForAll(methodObject17472, (Object)this.delegate.getNString(arg0));
      } catch (SQLException var3) {
         return (String)this.postForAll(methodObject17472, this.onErrorForAll(methodObject17472, var3));
      }
   }

   public void updateBFILE(int arg0, BFILE arg1) throws SQLException {
      try {
         super.preForAll(methodObject17284, this, arg0, arg1);
         Method var10001 = methodObject17284;
         this.delegate.updateBFILE(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject17284, var4);
      }
   }

   public void updateFloat(String arg0, float arg1) throws SQLException {
      try {
         super.preForAll(methodObject17522, this, arg0, arg1);
         Method var10001 = methodObject17522;
         this.delegate.updateFloat(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject17522, var4);
      }
   }

   public void updateDouble(String arg0, double arg1) throws SQLException {
      try {
         super.preForAll(methodObject17520, this, arg0, arg1);
         Method var10001 = methodObject17520;
         this.delegate.updateDouble(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var5) {
         this.onErrorVoidForAll(methodObject17520, var5);
      }
   }

   public void beforeFirst() throws SQLException {
      try {
         super.preForAll(methodObject17457, this, zeroLengthObjectArray);
         Method var10001 = methodObject17457;
         this.delegate.beforeFirst();
         this.postForAll(var10001);
      } catch (SQLException var2) {
         this.onErrorVoidForAll(methodObject17457, var2);
      }
   }

   public void updateTimestamp(String arg0, Timestamp arg1) throws SQLException {
      try {
         super.preForAll(methodObject17552, this, arg0, arg1);
         Method var10001 = methodObject17552;
         this.delegate.updateTimestamp(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject17552, var4);
      }
   }

   public INTERVALYM getINTERVALYM(String arg0) throws SQLException {
      try {
         super.preForAll(methodObject17353, this, arg0);
         return (INTERVALYM)this.postForAll(methodObject17353, (Object)this.delegate.getINTERVALYM(arg0));
      } catch (SQLException var3) {
         return (INTERVALYM)this.postForAll(methodObject17353, this.onErrorForAll(methodObject17353, var3));
      }
   }

   public int getInt(String arg0) throws SQLException {
      try {
         super.preForAll(methodObject17377, this, arg0);
         return (Integer)this.postForAll(methodObject17377, this.delegate.getInt(arg0));
      } catch (SQLException var3) {
         return (Integer)this.postForAll(methodObject17377, this.onErrorForAll(methodObject17377, var3));
      }
   }

   public NUMBER getNUMBER(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject17340, this, arg0);
         return (NUMBER)this.postForAll(methodObject17340, (Object)this.delegate.getNUMBER(arg0));
      } catch (SQLException var3) {
         return (NUMBER)this.postForAll(methodObject17340, this.onErrorForAll(methodObject17340, var3));
      }
   }

   public void updateCharacterStream(String arg0, Reader arg1) throws SQLException {
      try {
         super.preForUpdateStreams(methodObject17422, this, arg0, arg1);
         Method var10001 = methodObject17422;
         this.delegate.updateCharacterStream(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject17422, var4);
      }
   }

   public void deleteRow() throws SQLException {
      try {
         super.preForRowUpdates(methodObject17402, this, zeroLengthObjectArray);
         Method var10001 = methodObject17402;
         this.delegate.deleteRow();
         this.postForAll(var10001);
      } catch (SQLException var2) {
         this.onErrorVoidForAll(methodObject17402, var2);
      }
   }

   public void updateNString(String arg0, String arg1) throws SQLException {
      try {
         super.preForAll(methodObject17534, this, arg0, arg1);
         Method var10001 = methodObject17534;
         this.delegate.updateNString(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject17534, var4);
      }
   }

   public void updateTIMESTAMPLTZ(int arg0, TIMESTAMPLTZ arg1) throws SQLException {
      try {
         super.preForAll(methodObject17304, this, arg0, arg1);
         Method var10001 = methodObject17304;
         this.delegate.updateTIMESTAMPLTZ(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject17304, var4);
      }
   }

   public void updateARRAY(String arg0, ARRAY arg1) throws SQLException {
      try {
         super.preForAll(methodObject17281, this, arg0, arg1);
         Method var10001 = methodObject17281;
         this.delegate.updateARRAY(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject17281, var4);
      }
   }

   public InputStream getBinaryStream(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject17429, this, arg0);
         return (InputStream)this.postForAll(methodObject17429, (Object)this.delegate.getBinaryStream(arg0));
      } catch (SQLException var3) {
         return (InputStream)this.postForAll(methodObject17429, this.onErrorForAll(methodObject17429, var3));
      }
   }

   public void updateNClob(String arg0, Reader arg1) throws SQLException {
      try {
         super.preForAll(methodObject17532, this, arg0, arg1);
         Method var10001 = methodObject17532;
         this.delegate.updateNClob(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject17532, var4);
      }
   }

   public Datum getOracleObject(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject17320, this, arg0);
         return (Datum)this.postForAll(methodObject17320, (Object)this.delegate.getOracleObject(arg0));
      } catch (SQLException var3) {
         return (Datum)this.postForAll(methodObject17320, this.onErrorForAll(methodObject17320, var3));
      }
   }

   public void updateNCharacterStream(int arg0, Reader arg1) throws SQLException {
      try {
         super.preForUpdateStreams(methodObject17425, this, arg0, arg1);
         Method var10001 = methodObject17425;
         this.delegate.updateNCharacterStream(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject17425, var4);
      }
   }

   public TIMESTAMPLTZ getTIMESTAMPLTZ(String arg0) throws SQLException {
      try {
         super.preForAll(methodObject17361, this, arg0);
         return (TIMESTAMPLTZ)this.postForAll(methodObject17361, (Object)this.delegate.getTIMESTAMPLTZ(arg0));
      } catch (SQLException var3) {
         return (TIMESTAMPLTZ)this.postForAll(methodObject17361, this.onErrorForAll(methodObject17361, var3));
      }
   }

   public boolean first() throws SQLException {
      try {
         super.preForAll(methodObject17460, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject17460, this.delegate.first());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject17460, this.onErrorForAll(methodObject17460, var2));
      }
   }

   public BLOB getBLOB(String arg0) throws SQLException {
      try {
         super.preForAll(methodObject17329, this, arg0);
         return (BLOB)this.postForAll(methodObject17329, (Object)this.delegate.getBLOB(arg0));
      } catch (SQLException var3) {
         return (BLOB)this.postForAll(methodObject17329, this.onErrorForAll(methodObject17329, var3));
      }
   }

   public BLOB getBLOB(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject17328, this, arg0);
         return (BLOB)this.postForAll(methodObject17328, (Object)this.delegate.getBLOB(arg0));
      } catch (SQLException var3) {
         return (BLOB)this.postForAll(methodObject17328, this.onErrorForAll(methodObject17328, var3));
      }
   }

   public void updateByte(String arg0, byte arg1) throws SQLException {
      try {
         super.preForAll(methodObject17508, this, arg0, arg1);
         Method var10001 = methodObject17508;
         this.delegate.updateByte(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject17508, var4);
      }
   }

   public DATE getDATE(String arg0) throws SQLException {
      try {
         super.preForAll(methodObject17339, this, arg0);
         return (DATE)this.postForAll(methodObject17339, (Object)this.delegate.getDATE(arg0));
      } catch (SQLException var3) {
         return (DATE)this.postForAll(methodObject17339, this.onErrorForAll(methodObject17339, var3));
      }
   }

   public void updateCharacterStream(int arg0, Reader arg1, long arg2) throws SQLException {
      try {
         super.preForUpdateStreams(methodObject17419, this, arg0, arg1, arg2);
         Method var10001 = methodObject17419;
         this.delegate.updateCharacterStream(arg0, arg1, arg2);
         this.postForAll(var10001);
      } catch (SQLException var6) {
         this.onErrorVoidForAll(methodObject17419, var6);
      }
   }

   public RAW getRAW(String arg0) throws SQLException {
      try {
         super.preForAll(methodObject17345, this, arg0);
         return (RAW)this.postForAll(methodObject17345, (Object)this.delegate.getRAW(arg0));
      } catch (SQLException var3) {
         return (RAW)this.postForAll(methodObject17345, this.onErrorForAll(methodObject17345, var3));
      }
   }

   public CHAR getCHAR(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject17330, this, arg0);
         return (CHAR)this.postForAll(methodObject17330, (Object)this.delegate.getCHAR(arg0));
      } catch (SQLException var3) {
         return (CHAR)this.postForAll(methodObject17330, this.onErrorForAll(methodObject17330, var3));
      }
   }

   public void updateBfile(String arg0, BFILE arg1) throws SQLException {
      try {
         super.preForAll(methodObject17283, this, arg0, arg1);
         Method var10001 = methodObject17283;
         this.delegate.updateBfile(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject17283, var4);
      }
   }

   public void updateBLOB(String arg0, BLOB arg1) throws SQLException {
      try {
         super.preForAll(methodObject17287, this, arg0, arg1);
         Method var10001 = methodObject17287;
         this.delegate.updateBLOB(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject17287, var4);
      }
   }

   public void updateBlob(String arg0, InputStream arg1) throws SQLException {
      try {
         super.preForAll(methodObject17504, this, arg0, arg1);
         Method var10001 = methodObject17504;
         this.delegate.updateBlob(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject17504, var4);
      }
   }

   public void updateNString(int arg0, String arg1) throws SQLException {
      try {
         super.preForAll(methodObject17533, this, arg0, arg1);
         Method var10001 = methodObject17533;
         this.delegate.updateNString(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject17533, var4);
      }
   }

   public void updateObject(int arg0, Object arg1, int arg2) throws SQLException {
      try {
         super.preForAll(methodObject17537, this, arg0, arg1, arg2);
         Method var10001 = methodObject17537;
         this.delegate.updateObject(arg0, arg1 instanceof _Proxy_ ? (Object)((_Proxy_)arg1)._getDelegate_() : arg1, arg2);
         this.postForAll(var10001);
      } catch (SQLException var5) {
         this.onErrorVoidForAll(methodObject17537, var5);
      }
   }

   public void updateINTERVALYM(String arg0, INTERVALYM arg1) throws SQLException {
      try {
         super.preForAll(methodObject17297, this, arg0, arg1);
         Method var10001 = methodObject17297;
         this.delegate.updateINTERVALYM(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject17297, var4);
      }
   }

   public void updateBinaryStream(String arg0, InputStream arg1, int arg2) throws SQLException {
      try {
         super.preForUpdateStreams(methodObject17412, this, arg0, arg1, arg2);
         Method var10001 = methodObject17412;
         this.delegate.updateBinaryStream(arg0, arg1, arg2);
         this.postForAll(var10001);
      } catch (SQLException var5) {
         this.onErrorVoidForAll(methodObject17412, var5);
      }
   }

   public Time getTime(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject17443, this, arg0);
         return (Time)this.postForAll(methodObject17443, (Object)this.delegate.getTime(arg0));
      } catch (SQLException var3) {
         return (Time)this.postForAll(methodObject17443, this.onErrorForAll(methodObject17443, var3));
      }
   }

   public void moveToInsertRow() throws SQLException {
      try {
         super.preForAll(methodObject17485, this, zeroLengthObjectArray);
         Method var10001 = methodObject17485;
         this.delegate.moveToInsertRow();
         this.postForAll(var10001);
      } catch (SQLException var2) {
         this.onErrorVoidForAll(methodObject17485, var2);
      }
   }

   public void updateNClob(int arg0, Reader arg1, long arg2) throws SQLException {
      try {
         super.preForAll(methodObject17529, this, arg0, arg1, arg2);
         Method var10001 = methodObject17529;
         this.delegate.updateNClob(arg0, arg1, arg2);
         this.postForAll(var10001);
      } catch (SQLException var6) {
         this.onErrorVoidForAll(methodObject17529, var6);
      }
   }

   public void updateDate(String arg0, Date arg1) throws SQLException {
      try {
         super.preForAll(methodObject17518, this, arg0, arg1);
         Method var10001 = methodObject17518;
         this.delegate.updateDate(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject17518, var4);
      }
   }

   public void updateTIMESTAMP(int arg0, TIMESTAMP arg1) throws SQLException {
      try {
         super.preForAll(methodObject17300, this, arg0, arg1);
         Method var10001 = methodObject17300;
         this.delegate.updateTIMESTAMP(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject17300, var4);
      }
   }

   public void updateNCharacterStream(int arg0, Reader arg1, long arg2) throws SQLException {
      try {
         super.preForUpdateStreams(methodObject17423, this, arg0, arg1, arg2);
         Method var10001 = methodObject17423;
         this.delegate.updateNCharacterStream(arg0, arg1, arg2);
         this.postForAll(var10001);
      } catch (SQLException var6) {
         this.onErrorVoidForAll(methodObject17423, var6);
      }
   }

   public void cancelRowUpdates() throws SQLException {
      try {
         super.preForAll(methodObject17458, this, zeroLengthObjectArray);
         Method var10001 = methodObject17458;
         this.delegate.cancelRowUpdates();
         this.postForAll(var10001);
      } catch (SQLException var2) {
         this.onErrorVoidForAll(methodObject17458, var2);
      }
   }

   public Object getObject(String arg0) throws SQLException {
      try {
         super.preForAll(methodObject17365, this, arg0);
         return this.postForAll(methodObject17365, this.proxyFactory.proxyForCreate(this.delegate.getObject(arg0), this, this.proxyCache, methodObject17365));
      } catch (SQLException var3) {
         return this.postForAll(methodObject17365, this.onErrorForAll(methodObject17365, var3));
      }
   }

   public int getHoldability() throws SQLException {
      try {
         super.preForAll(methodObject17449, this, zeroLengthObjectArray);
         return (Integer)this.postForAll(methodObject17449, this.delegate.getHoldability());
      } catch (SQLException var2) {
         return (Integer)this.postForAll(methodObject17449, this.onErrorForAll(methodObject17449, var2));
      }
   }

   public ROWID getROWID(String arg0) throws SQLException {
      try {
         super.preForAll(methodObject17349, this, arg0);
         return (ROWID)this.postForAll(methodObject17349, (Object)this.delegate.getROWID(arg0));
      } catch (SQLException var3) {
         return (ROWID)this.postForAll(methodObject17349, this.onErrorForAll(methodObject17349, var3));
      }
   }

   public void updateLong(int arg0, long arg1) throws SQLException {
      try {
         super.preForAll(methodObject17525, this, arg0, arg1);
         Method var10001 = methodObject17525;
         this.delegate.updateLong(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var5) {
         this.onErrorVoidForAll(methodObject17525, var5);
      }
   }

   public ORAData getORAData(String arg0, ORADataFactory arg1) throws SQLException {
      try {
         super.preForAll(methodObject17337, this, arg0, arg1);
         return (ORAData)this.postForAll(methodObject17337, (Object)this.delegate.getORAData(arg0, arg1));
      } catch (SQLException var4) {
         return (ORAData)this.postForAll(methodObject17337, this.onErrorForAll(methodObject17337, var4));
      }
   }

   public void updateBinaryStream(String arg0, InputStream arg1) throws SQLException {
      try {
         super.preForUpdateStreams(methodObject17416, this, arg0, arg1);
         Method var10001 = methodObject17416;
         this.delegate.updateBinaryStream(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject17416, var4);
      }
   }

   public boolean getBoolean(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject17370, this, arg0);
         return (Boolean)this.postForAll(methodObject17370, this.delegate.getBoolean(arg0));
      } catch (SQLException var3) {
         return (Boolean)this.postForAll(methodObject17370, this.onErrorForAll(methodObject17370, var3));
      }
   }

   public BigDecimal getBigDecimal(int arg0, int arg1) throws SQLException {
      try {
         super.preForAll(methodObject17461, this, arg0, arg1);
         return (BigDecimal)this.postForAll(methodObject17461, (Object)this.delegate.getBigDecimal(arg0, arg1));
      } catch (SQLException var4) {
         return (BigDecimal)this.postForAll(methodObject17461, this.onErrorForAll(methodObject17461, var4));
      }
   }

   public BigDecimal getBigDecimal(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject17463, this, arg0);
         return (BigDecimal)this.postForAll(methodObject17463, (Object)this.delegate.getBigDecimal(arg0));
      } catch (SQLException var3) {
         return (BigDecimal)this.postForAll(methodObject17463, this.onErrorForAll(methodObject17463, var3));
      }
   }

   public void updateAsciiStream(String arg0, InputStream arg1, long arg2) throws SQLException {
      try {
         super.preForUpdateStreams(methodObject17408, this, arg0, arg1, arg2);
         Method var10001 = methodObject17408;
         this.delegate.updateAsciiStream(arg0, arg1, arg2);
         this.postForAll(var10001);
      } catch (SQLException var6) {
         this.onErrorVoidForAll(methodObject17408, var6);
      }
   }

   public void updateDATE(String arg0, DATE arg1) throws SQLException {
      try {
         super.preForAll(methodObject17295, this, arg0, arg1);
         Method var10001 = methodObject17295;
         this.delegate.updateDATE(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject17295, var4);
      }
   }

   public TIMESTAMP getTIMESTAMP(String arg0) throws SQLException {
      try {
         super.preForAll(methodObject17357, this, arg0);
         return (TIMESTAMP)this.postForAll(methodObject17357, (Object)this.delegate.getTIMESTAMP(arg0));
      } catch (SQLException var3) {
         return (TIMESTAMP)this.postForAll(methodObject17357, this.onErrorForAll(methodObject17357, var3));
      }
   }

   public void updateShort(int arg0, short arg1) throws SQLException {
      try {
         super.preForAll(methodObject17547, this, arg0, arg1);
         Method var10001 = methodObject17547;
         this.delegate.updateShort(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject17547, var4);
      }
   }

   public short getShort(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject17374, this, arg0);
         return (Short)this.postForAll(methodObject17374, this.delegate.getShort(arg0));
      } catch (SQLException var3) {
         return (Short)this.postForAll(methodObject17374, this.onErrorForAll(methodObject17374, var3));
      }
   }

   public Ref getRef(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject17394, this, arg0);
         return (Ref)this.postForAll(methodObject17394, this.proxyFactory.proxyForCreate((Object)this.delegate.getRef(arg0), this, this.proxyCache, methodObject17394));
      } catch (SQLException var3) {
         return (Ref)this.postForAll(methodObject17394, this.onErrorForAll(methodObject17394, var3));
      }
   }

   public BFILE getBFILE(String arg0) throws SQLException {
      try {
         super.preForAll(methodObject17325, this, arg0);
         return (BFILE)this.postForAll(methodObject17325, (Object)this.delegate.getBFILE(arg0));
      } catch (SQLException var3) {
         return (BFILE)this.postForAll(methodObject17325, this.onErrorForAll(methodObject17325, var3));
      }
   }

   public void updateRAW(int arg0, RAW arg1) throws SQLException {
      try {
         super.preForAll(methodObject17310, this, arg0, arg1);
         Method var10001 = methodObject17310;
         this.delegate.updateRAW(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject17310, var4);
      }
   }

   public Date getDate(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject17398, this, arg0);
         return (Date)this.postForAll(methodObject17398, (Object)this.delegate.getDate(arg0));
      } catch (SQLException var3) {
         return (Date)this.postForAll(methodObject17398, this.onErrorForAll(methodObject17398, var3));
      }
   }

   public Blob getBlob(String arg0) throws SQLException {
      try {
         super.preForAll(methodObject17434, this, arg0);
         return (Blob)this.postForAll(methodObject17434, this.proxyFactory.proxyForCreate((Object)this.delegate.getBlob(arg0), this, this.proxyCache, methodObject17434));
      } catch (SQLException var3) {
         return (Blob)this.postForAll(methodObject17434, this.onErrorForAll(methodObject17434, var3));
      }
   }

   public void updateShort(String arg0, short arg1) throws SQLException {
      try {
         super.preForAll(methodObject17548, this, arg0, arg1);
         Method var10001 = methodObject17548;
         this.delegate.updateShort(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject17548, var4);
      }
   }

   public void updateNClob(String arg0, NClob arg1) throws SQLException {
      try {
         super.preForAll(methodObject17528, this, arg0, arg1);
         Method var10001 = methodObject17528;
         this.delegate.updateNClob(arg0, arg1 instanceof _Proxy_ ? (NClob)((_Proxy_)arg1)._getDelegate_() : arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject17528, var4);
      }
   }

   public Object getObject(int arg0, Map arg1) throws SQLException {
      try {
         super.preForAll(methodObject17366, this, arg0, arg1);
         return this.postForAll(methodObject17366, this.proxyFactory.proxyForCreate(this.delegate.getObject(arg0, arg1), this, this.proxyCache, methodObject17366));
      } catch (SQLException var4) {
         return this.postForAll(methodObject17366, this.onErrorForAll(methodObject17366, var4));
      }
   }

   public void updateBlob(String arg0, Blob arg1) throws SQLException {
      try {
         super.preForAll(methodObject17500, this, arg0, arg1);
         Method var10001 = methodObject17500;
         this.delegate.updateBlob(arg0, arg1 instanceof _Proxy_ ? (Blob)((_Proxy_)arg1)._getDelegate_() : arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject17500, var4);
      }
   }

   public Date getDate(int arg0, Calendar arg1) throws SQLException {
      try {
         super.preForAll(methodObject17400, this, arg0, arg1);
         return (Date)this.postForAll(methodObject17400, (Object)this.delegate.getDate(arg0, arg1));
      } catch (SQLException var4) {
         return (Date)this.postForAll(methodObject17400, this.onErrorForAll(methodObject17400, var4));
      }
   }

   public REF getREF(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject17346, this, arg0);
         return (REF)this.postForAll(methodObject17346, (Object)this.delegate.getREF(arg0));
      } catch (SQLException var3) {
         return (REF)this.postForAll(methodObject17346, this.onErrorForAll(methodObject17346, var3));
      }
   }

   public boolean rowDeleted() throws SQLException {
      try {
         super.preForAll(methodObject17488, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject17488, this.delegate.rowDeleted());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject17488, this.onErrorForAll(methodObject17488, var2));
      }
   }

   public TIMESTAMPTZ getTIMESTAMPTZ(String arg0) throws SQLException {
      try {
         super.preForAll(methodObject17359, this, arg0);
         return (TIMESTAMPTZ)this.postForAll(methodObject17359, (Object)this.delegate.getTIMESTAMPTZ(arg0));
      } catch (SQLException var3) {
         return (TIMESTAMPTZ)this.postForAll(methodObject17359, this.onErrorForAll(methodObject17359, var3));
      }
   }

   public void updateString(int arg0, String arg1) throws SQLException {
      try {
         super.preForAll(methodObject17549, this, arg0, arg1);
         Method var10001 = methodObject17549;
         this.delegate.updateString(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject17549, var4);
      }
   }

   public void afterLast() throws SQLException {
      try {
         super.preForAll(methodObject17494, this, zeroLengthObjectArray);
         Method var10001 = methodObject17494;
         this.delegate.afterLast();
         this.postForAll(var10001);
      } catch (SQLException var2) {
         this.onErrorVoidForAll(methodObject17494, var2);
      }
   }

   public void updateCustomDatum(int arg0, CustomDatum arg1) throws SQLException {
      try {
         super.preForAll(methodObject17278, this, arg0, arg1);
         Method var10001 = methodObject17278;
         this.delegate.updateCustomDatum(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject17278, var4);
      }
   }

   public void updateClob(int arg0, Reader arg1) throws SQLException {
      try {
         super.preForAll(methodObject17515, this, arg0, arg1);
         Method var10001 = methodObject17515;
         this.delegate.updateClob(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject17515, var4);
      }
   }

   public void updateArray(int arg0, Array arg1) throws SQLException {
      try {
         super.preForAll(methodObject17495, this, arg0, arg1);
         Method var10001 = methodObject17495;
         this.delegate.updateArray(arg0, arg1 instanceof _Proxy_ ? (Array)((_Proxy_)arg1)._getDelegate_() : arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject17495, var4);
      }
   }

   public void updateREF(String arg0, REF arg1) throws SQLException {
      try {
         super.preForAll(methodObject17313, this, arg0, arg1);
         Method var10001 = methodObject17313;
         this.delegate.updateREF(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject17313, var4);
      }
   }

   public URL getURL(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject17389, this, arg0);
         return (URL)this.postForAll(methodObject17389, (Object)this.delegate.getURL(arg0));
      } catch (SQLException var3) {
         return (URL)this.postForAll(methodObject17389, this.onErrorForAll(methodObject17389, var3));
      }
   }

   public Array getArray(String arg0) throws SQLException {
      try {
         super.preForAll(methodObject17387, this, arg0);
         return (Array)this.postForAll(methodObject17387, this.proxyFactory.proxyForCreate((Object)this.delegate.getArray(arg0), this, this.proxyCache, methodObject17387));
      } catch (SQLException var3) {
         return (Array)this.postForAll(methodObject17387, this.onErrorForAll(methodObject17387, var3));
      }
   }

   public Statement getStatement() throws SQLException {
      try {
         super.preForAll(methodObject17428, this, zeroLengthObjectArray);
         return (Statement)this.postForAll(methodObject17428, (Object)super.getStatement());
      } catch (SQLException var2) {
         return (Statement)this.postForAll(methodObject17428, this.onErrorForAll(methodObject17428, var2));
      }
   }

   public SQLWarning getWarnings() throws SQLException {
      try {
         super.preForAll(methodObject17447, this, zeroLengthObjectArray);
         return (SQLWarning)this.postForAll(methodObject17447, (Object)this.delegate.getWarnings());
      } catch (SQLException var2) {
         return (SQLWarning)this.postForAll(methodObject17447, this.onErrorForAll(methodObject17447, var2));
      }
   }

   public void updateBLOB(int arg0, BLOB arg1) throws SQLException {
      try {
         super.preForAll(methodObject17286, this, arg0, arg1);
         Method var10001 = methodObject17286;
         this.delegate.updateBLOB(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject17286, var4);
      }
   }

   public Reader getCharacterStream(String arg0) throws SQLException {
      try {
         super.preForAll(methodObject17455, this, arg0);
         return (Reader)this.postForAll(methodObject17455, (Object)this.delegate.getCharacterStream(arg0));
      } catch (SQLException var3) {
         return (Reader)this.postForAll(methodObject17455, this.onErrorForAll(methodObject17455, var3));
      }
   }

   public byte getByte(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject17372, this, arg0);
         return (Byte)this.postForAll(methodObject17372, this.delegate.getByte(arg0));
      } catch (SQLException var3) {
         return (Byte)this.postForAll(methodObject17372, this.onErrorForAll(methodObject17372, var3));
      }
   }

   public void updateROWID(int arg0, ROWID arg1) throws SQLException {
      try {
         super.preForAll(methodObject17314, this, arg0, arg1);
         Method var10001 = methodObject17314;
         this.delegate.updateROWID(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject17314, var4);
      }
   }

   public DATE getDATE(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject17338, this, arg0);
         return (DATE)this.postForAll(methodObject17338, (Object)this.delegate.getDATE(arg0));
      } catch (SQLException var3) {
         return (DATE)this.postForAll(methodObject17338, this.onErrorForAll(methodObject17338, var3));
      }
   }

   public CLOB getCLOB(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject17332, this, arg0);
         return (CLOB)this.postForAll(methodObject17332, (Object)this.delegate.getCLOB(arg0));
      } catch (SQLException var3) {
         return (CLOB)this.postForAll(methodObject17332, this.onErrorForAll(methodObject17332, var3));
      }
   }

   public ARRAY getARRAY(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject17362, this, arg0);
         return (ARRAY)this.postForAll(methodObject17362, (Object)this.delegate.getARRAY(arg0));
      } catch (SQLException var3) {
         return (ARRAY)this.postForAll(methodObject17362, this.onErrorForAll(methodObject17362, var3));
      }
   }

   public BFILE getBfile(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject17326, this, arg0);
         return (BFILE)this.postForAll(methodObject17326, (Object)this.delegate.getBfile(arg0));
      } catch (SQLException var3) {
         return (BFILE)this.postForAll(methodObject17326, this.onErrorForAll(methodObject17326, var3));
      }
   }

   public Timestamp getTimestamp(String arg0, Calendar arg1) throws SQLException {
      try {
         super.preForAll(methodObject17477, this, arg0, arg1);
         return (Timestamp)this.postForAll(methodObject17477, (Object)this.delegate.getTimestamp(arg0, arg1));
      } catch (SQLException var4) {
         return (Timestamp)this.postForAll(methodObject17477, this.onErrorForAll(methodObject17477, var4));
      }
   }

   public long getLong(String arg0) throws SQLException {
      try {
         super.preForAll(methodObject17379, this, arg0);
         return (Long)this.postForAll(methodObject17379, this.delegate.getLong(arg0));
      } catch (SQLException var3) {
         return (Long)this.postForAll(methodObject17379, this.onErrorForAll(methodObject17379, var3));
      }
   }

   public Clob getClob(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject17435, this, arg0);
         return (Clob)this.postForAll(methodObject17435, this.proxyFactory.proxyForCreate((Object)this.delegate.getClob(arg0), this, this.proxyCache, methodObject17435));
      } catch (SQLException var3) {
         return (Clob)this.postForAll(methodObject17435, this.onErrorForAll(methodObject17435, var3));
      }
   }

   public void updateBigDecimal(int arg0, BigDecimal arg1) throws SQLException {
      try {
         super.preForAll(methodObject17497, this, arg0, arg1);
         Method var10001 = methodObject17497;
         this.delegate.updateBigDecimal(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject17497, var4);
      }
   }

   public ROWID getROWID(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject17348, this, arg0);
         return (ROWID)this.postForAll(methodObject17348, (Object)this.delegate.getROWID(arg0));
      } catch (SQLException var3) {
         return (ROWID)this.postForAll(methodObject17348, this.onErrorForAll(methodObject17348, var3));
      }
   }

   public void updateBlob(String arg0, InputStream arg1, long arg2) throws SQLException {
      try {
         super.preForAll(methodObject17502, this, arg0, arg1, arg2);
         Method var10001 = methodObject17502;
         this.delegate.updateBlob(arg0, arg1, arg2);
         this.postForAll(var10001);
      } catch (SQLException var6) {
         this.onErrorVoidForAll(methodObject17502, var6);
      }
   }

   public String getCursorName() throws SQLException {
      try {
         super.preForAll(methodObject17466, this, zeroLengthObjectArray);
         return (String)this.postForAll(methodObject17466, (Object)this.delegate.getCursorName());
      } catch (SQLException var2) {
         return (String)this.postForAll(methodObject17466, this.onErrorForAll(methodObject17466, var2));
      }
   }

   public void close() throws SQLException {
      try {
         super.preForAll(methodObject17391, this, zeroLengthObjectArray);
         Method var10001 = methodObject17391;
         this.delegate.close();
         this.postForClose(var10001);
      } catch (SQLException var2) {
         this.onErrorVoidForAll(methodObject17391, var2);
      }
   }

   public void updateBinaryStream(String arg0, InputStream arg1, long arg2) throws SQLException {
      try {
         super.preForUpdateStreams(methodObject17414, this, arg0, arg1, arg2);
         Method var10001 = methodObject17414;
         this.delegate.updateBinaryStream(arg0, arg1, arg2);
         this.postForAll(var10001);
      } catch (SQLException var6) {
         this.onErrorVoidForAll(methodObject17414, var6);
      }
   }

   public ResultSet getCursor(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject17322, this, arg0);
         return (ResultSet)this.postForAll(methodObject17322, this.proxyFactory.proxyForCreate((Object)this.delegate.getCursor(arg0), this, this.proxyCache, methodObject17322));
      } catch (SQLException var3) {
         return (ResultSet)this.postForAll(methodObject17322, this.onErrorForAll(methodObject17322, var3));
      }
   }

   public double getDouble(String arg0) throws SQLException {
      try {
         super.preForAll(methodObject17383, this, arg0);
         return (Double)this.postForAll(methodObject17383, this.delegate.getDouble(arg0));
      } catch (SQLException var3) {
         return (Double)this.postForAll(methodObject17383, this.onErrorForAll(methodObject17383, var3));
      }
   }

   public Object getObject(int arg0, Class arg1) throws SQLException {
      try {
         super.preForAll(methodObject17368, this, arg0, arg1);
         return this.postForAll(methodObject17368, this.proxyFactory.proxyForCreate(this.delegate.getObject(arg0, arg1), this, this.proxyCache, methodObject17368));
      } catch (SQLException var4) {
         return this.postForAll(methodObject17368, this.onErrorForAll(methodObject17368, var4));
      }
   }

   public void updateRef(String arg0, Ref arg1) throws SQLException {
      try {
         super.preForAll(methodObject17542, this, arg0, arg1);
         Method var10001 = methodObject17542;
         this.delegate.updateRef(arg0, arg1 instanceof _Proxy_ ? (Ref)((_Proxy_)arg1)._getDelegate_() : arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject17542, var4);
      }
   }

   public boolean absolute(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject17493, this, arg0);
         return (Boolean)this.postForAll(methodObject17493, this.delegate.absolute(arg0));
      } catch (SQLException var3) {
         return (Boolean)this.postForAll(methodObject17493, this.onErrorForAll(methodObject17493, var3));
      }
   }

   public Timestamp getTimestamp(int arg0, Calendar arg1) throws SQLException {
      try {
         super.preForAll(methodObject17476, this, arg0, arg1);
         return (Timestamp)this.postForAll(methodObject17476, (Object)this.delegate.getTimestamp(arg0, arg1));
      } catch (SQLException var4) {
         return (Timestamp)this.postForAll(methodObject17476, this.onErrorForAll(methodObject17476, var4));
      }
   }

   public InputStream getAsciiStream(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject17452, this, arg0);
         return (InputStream)this.postForAll(methodObject17452, (Object)this.delegate.getAsciiStream(arg0));
      } catch (SQLException var3) {
         return (InputStream)this.postForAll(methodObject17452, this.onErrorForAll(methodObject17452, var3));
      }
   }

   public RAW getRAW(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject17344, this, arg0);
         return (RAW)this.postForAll(methodObject17344, (Object)this.delegate.getRAW(arg0));
      } catch (SQLException var3) {
         return (RAW)this.postForAll(methodObject17344, this.onErrorForAll(methodObject17344, var3));
      }
   }

   public void updateBoolean(int arg0, boolean arg1) throws SQLException {
      try {
         super.preForAll(methodObject17505, this, arg0, arg1);
         Method var10001 = methodObject17505;
         this.delegate.updateBoolean(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject17505, var4);
      }
   }

   public NClob getNClob(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject17437, this, arg0);
         return (NClob)this.postForAll(methodObject17437, this.proxyFactory.proxyForCreate((Object)this.delegate.getNClob(arg0), this, this.proxyCache, methodObject17437));
      } catch (SQLException var3) {
         return (NClob)this.postForAll(methodObject17437, this.onErrorForAll(methodObject17437, var3));
      }
   }

   public void updateBinaryStream(int arg0, InputStream arg1, int arg2) throws SQLException {
      try {
         super.preForUpdateStreams(methodObject17411, this, arg0, arg1, arg2);
         Method var10001 = methodObject17411;
         this.delegate.updateBinaryStream(arg0, arg1, arg2);
         this.postForAll(var10001);
      } catch (SQLException var5) {
         this.onErrorVoidForAll(methodObject17411, var5);
      }
   }

   public byte getByte(String arg0) throws SQLException {
      try {
         super.preForAll(methodObject17373, this, arg0);
         return (Byte)this.postForAll(methodObject17373, this.delegate.getByte(arg0));
      } catch (SQLException var3) {
         return (Byte)this.postForAll(methodObject17373, this.onErrorForAll(methodObject17373, var3));
      }
   }

   public void updateAsciiStream(String arg0, InputStream arg1) throws SQLException {
      try {
         super.preForUpdateStreams(methodObject17410, this, arg0, arg1);
         Method var10001 = methodObject17410;
         this.delegate.updateAsciiStream(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject17410, var4);
      }
   }

   public void updateSQLXML(String arg0, SQLXML arg1) throws SQLException {
      try {
         super.preForAll(methodObject17546, this, arg0, arg1);
         Method var10001 = methodObject17546;
         this.delegate.updateSQLXML(arg0, arg1 instanceof _Proxy_ ? (SQLXML)((_Proxy_)arg1)._getDelegate_() : arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject17546, var4);
      }
   }

   public void updateCLOB(String arg0, CLOB arg1) throws SQLException {
      try {
         super.preForAll(methodObject17291, this, arg0, arg1);
         Method var10001 = methodObject17291;
         this.delegate.updateCLOB(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject17291, var4);
      }
   }

   public Array getArray(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject17386, this, arg0);
         return (Array)this.postForAll(methodObject17386, this.proxyFactory.proxyForCreate((Object)this.delegate.getArray(arg0), this, this.proxyCache, methodObject17386));
      } catch (SQLException var3) {
         return (Array)this.postForAll(methodObject17386, this.onErrorForAll(methodObject17386, var3));
      }
   }

   public void updateCharacterStream(String arg0, Reader arg1, int arg2) throws SQLException {
      try {
         super.preForUpdateStreams(methodObject17418, this, arg0, arg1, arg2);
         Method var10001 = methodObject17418;
         this.delegate.updateCharacterStream(arg0, arg1, arg2);
         this.postForAll(var10001);
      } catch (SQLException var5) {
         this.onErrorVoidForAll(methodObject17418, var5);
      }
   }

   public Timestamp getTimestamp(String arg0) throws SQLException {
      try {
         super.preForAll(methodObject17475, this, arg0);
         return (Timestamp)this.postForAll(methodObject17475, (Object)this.delegate.getTimestamp(arg0));
      } catch (SQLException var3) {
         return (Timestamp)this.postForAll(methodObject17475, this.onErrorForAll(methodObject17475, var3));
      }
   }

   public void updateAsciiStream(int arg0, InputStream arg1) throws SQLException {
      try {
         super.preForUpdateStreams(methodObject17409, this, arg0, arg1);
         Method var10001 = methodObject17409;
         this.delegate.updateAsciiStream(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject17409, var4);
      }
   }

   public STRUCT getSTRUCT(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject17350, this, arg0);
         return (STRUCT)this.postForAll(methodObject17350, (Object)this.delegate.getSTRUCT(arg0));
      } catch (SQLException var3) {
         return (STRUCT)this.postForAll(methodObject17350, this.onErrorForAll(methodObject17350, var3));
      }
   }

   public Clob getClob(String arg0) throws SQLException {
      try {
         super.preForAll(methodObject17436, this, arg0);
         return (Clob)this.postForAll(methodObject17436, this.proxyFactory.proxyForCreate((Object)this.delegate.getClob(arg0), this, this.proxyCache, methodObject17436));
      } catch (SQLException var3) {
         return (Clob)this.postForAll(methodObject17436, this.onErrorForAll(methodObject17436, var3));
      }
   }

   public void updateClob(String arg0, Clob arg1) throws SQLException {
      try {
         super.preForAll(methodObject17512, this, arg0, arg1);
         Method var10001 = methodObject17512;
         this.delegate.updateClob(arg0, arg1 instanceof _Proxy_ ? (Clob)((_Proxy_)arg1)._getDelegate_() : arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject17512, var4);
      }
   }

   public TIMESTAMPLTZ getTIMESTAMPLTZ(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject17360, this, arg0);
         return (TIMESTAMPLTZ)this.postForAll(methodObject17360, (Object)this.delegate.getTIMESTAMPLTZ(arg0));
      } catch (SQLException var3) {
         return (TIMESTAMPLTZ)this.postForAll(methodObject17360, this.onErrorForAll(methodObject17360, var3));
      }
   }

   public void updateAsciiStream(int arg0, InputStream arg1, int arg2) throws SQLException {
      try {
         super.preForUpdateStreams(methodObject17405, this, arg0, arg1, arg2);
         Method var10001 = methodObject17405;
         this.delegate.updateAsciiStream(arg0, arg1, arg2);
         this.postForAll(var10001);
      } catch (SQLException var5) {
         this.onErrorVoidForAll(methodObject17405, var5);
      }
   }

   public void updateObject(int arg0, Object arg1) throws SQLException {
      try {
         super.preForAll(methodObject17538, this, arg0, arg1);
         Method var10001 = methodObject17538;
         this.delegate.updateObject(arg0, arg1 instanceof _Proxy_ ? (Object)((_Proxy_)arg1)._getDelegate_() : arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject17538, var4);
      }
   }

   public int getRow() throws SQLException {
      try {
         super.preForAll(methodObject17473, this, zeroLengthObjectArray);
         return (Integer)this.postForAll(methodObject17473, this.delegate.getRow());
      } catch (SQLException var2) {
         return (Integer)this.postForAll(methodObject17473, this.onErrorForAll(methodObject17473, var2));
      }
   }

   public CustomDatum getCustomDatum(String arg0, CustomDatumFactory arg1) throws SQLException {
      try {
         super.preForAll(methodObject17335, this, arg0, arg1);
         return (CustomDatum)this.postForAll(methodObject17335, (Object)this.delegate.getCustomDatum(arg0, arg1));
      } catch (SQLException var4) {
         return (CustomDatum)this.postForAll(methodObject17335, this.onErrorForAll(methodObject17335, var4));
      }
   }

   public void updateSTRUCT(String arg0, STRUCT arg1) throws SQLException {
      try {
         super.preForAll(methodObject17317, this, arg0, arg1);
         Method var10001 = methodObject17317;
         this.delegate.updateSTRUCT(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject17317, var4);
      }
   }

   public float getFloat(String arg0) throws SQLException {
      try {
         super.preForAll(methodObject17381, this, arg0);
         return (Float)this.postForAll(methodObject17381, this.delegate.getFloat(arg0));
      } catch (SQLException var3) {
         return (Float)this.postForAll(methodObject17381, this.onErrorForAll(methodObject17381, var3));
      }
   }

   public NClob getNClob(String arg0) throws SQLException {
      try {
         super.preForAll(methodObject17438, this, arg0);
         return (NClob)this.postForAll(methodObject17438, this.proxyFactory.proxyForCreate((Object)this.delegate.getNClob(arg0), this, this.proxyCache, methodObject17438));
      } catch (SQLException var3) {
         return (NClob)this.postForAll(methodObject17438, this.onErrorForAll(methodObject17438, var3));
      }
   }

   public BFILE getBfile(String arg0) throws SQLException {
      try {
         super.preForAll(methodObject17327, this, arg0);
         return (BFILE)this.postForAll(methodObject17327, (Object)this.delegate.getBfile(arg0));
      } catch (SQLException var3) {
         return (BFILE)this.postForAll(methodObject17327, this.onErrorForAll(methodObject17327, var3));
      }
   }

   public void insertRow() throws SQLException {
      try {
         super.preForRowUpdates(methodObject17403, this, zeroLengthObjectArray);
         Method var10001 = methodObject17403;
         this.delegate.insertRow();
         this.postForAll(var10001);
      } catch (SQLException var2) {
         this.onErrorVoidForAll(methodObject17403, var2);
      }
   }

   public void setFetchSize(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject17492, this, arg0);
         Method var10001 = methodObject17492;
         this.delegate.setFetchSize(arg0);
         this.postForAll(var10001);
      } catch (SQLException var3) {
         this.onErrorVoidForAll(methodObject17492, var3);
      }
   }

   public void setFetchDirection(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject17491, this, arg0);
         Method var10001 = methodObject17491;
         this.delegate.setFetchDirection(arg0);
         this.postForAll(var10001);
      } catch (SQLException var3) {
         this.onErrorVoidForAll(methodObject17491, var3);
      }
   }

   public void updateObject(String arg0, Object arg1, int arg2) throws SQLException {
      try {
         super.preForAll(methodObject17539, this, arg0, arg1, arg2);
         Method var10001 = methodObject17539;
         this.delegate.updateObject(arg0, arg1 instanceof _Proxy_ ? (Object)((_Proxy_)arg1)._getDelegate_() : arg1, arg2);
         this.postForAll(var10001);
      } catch (SQLException var5) {
         this.onErrorVoidForAll(methodObject17539, var5);
      }
   }

   public int getFetchSize() throws SQLException {
      try {
         super.preForAll(methodObject17468, this, zeroLengthObjectArray);
         return (Integer)this.postForAll(methodObject17468, this.delegate.getFetchSize());
      } catch (SQLException var2) {
         return (Integer)this.postForAll(methodObject17468, this.onErrorForAll(methodObject17468, var2));
      }
   }

   public void updateROWID(String arg0, ROWID arg1) throws SQLException {
      try {
         super.preForAll(methodObject17315, this, arg0, arg1);
         Method var10001 = methodObject17315;
         this.delegate.updateROWID(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject17315, var4);
      }
   }

   public void moveToCurrentRow() throws SQLException {
      try {
         super.preForAll(methodObject17484, this, zeroLengthObjectArray);
         Method var10001 = methodObject17484;
         this.delegate.moveToCurrentRow();
         this.postForAll(var10001);
      } catch (SQLException var2) {
         this.onErrorVoidForAll(methodObject17484, var2);
      }
   }

   public InputStream getBinaryStream(String arg0) throws SQLException {
      try {
         super.preForAll(methodObject17430, this, arg0);
         return (InputStream)this.postForAll(methodObject17430, (Object)this.delegate.getBinaryStream(arg0));
      } catch (SQLException var3) {
         return (InputStream)this.postForAll(methodObject17430, this.onErrorForAll(methodObject17430, var3));
      }
   }

   public void updateInt(String arg0, int arg1) throws SQLException {
      try {
         super.preForAll(methodObject17524, this, arg0, arg1);
         Method var10001 = methodObject17524;
         this.delegate.updateInt(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject17524, var4);
      }
   }

   public void updateCustomDatum(String arg0, CustomDatum arg1) throws SQLException {
      try {
         super.preForAll(methodObject17279, this, arg0, arg1);
         Method var10001 = methodObject17279;
         this.delegate.updateCustomDatum(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject17279, var4);
      }
   }

   public void updateORAData(int arg0, ORAData arg1) throws SQLException {
      try {
         super.preForAll(methodObject17292, this, arg0, arg1);
         Method var10001 = methodObject17292;
         this.delegate.updateORAData(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject17292, var4);
      }
   }

   public void updateNull(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject17535, this, arg0);
         Method var10001 = methodObject17535;
         this.delegate.updateNull(arg0);
         this.postForAll(var10001);
      } catch (SQLException var3) {
         this.onErrorVoidForAll(methodObject17535, var3);
      }
   }

   public boolean isWrapperFor(Class arg0) throws SQLException {
      try {
         super.preForAll(methodObject17554, this, arg0);
         return (Boolean)this.postForAll(methodObject17554, this.delegate.isWrapperFor(arg0));
      } catch (SQLException var3) {
         return (Boolean)this.postForAll(methodObject17554, this.onErrorForAll(methodObject17554, var3));
      }
   }

   public Object getObject(String arg0, Map arg1) throws SQLException {
      try {
         super.preForAll(methodObject17367, this, arg0, arg1);
         return this.postForAll(methodObject17367, this.proxyFactory.proxyForCreate(this.delegate.getObject(arg0, arg1), this, this.proxyCache, methodObject17367));
      } catch (SQLException var4) {
         return this.postForAll(methodObject17367, this.onErrorForAll(methodObject17367, var4));
      }
   }

   public STRUCT getSTRUCT(String arg0) throws SQLException {
      try {
         super.preForAll(methodObject17351, this, arg0);
         return (STRUCT)this.postForAll(methodObject17351, (Object)this.delegate.getSTRUCT(arg0));
      } catch (SQLException var3) {
         return (STRUCT)this.postForAll(methodObject17351, this.onErrorForAll(methodObject17351, var3));
      }
   }

   public OracleResultSet.AuthorizationIndicator getAuthorizationIndicator(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject17318, this, arg0);
         return (OracleResultSet.AuthorizationIndicator)this.postForAll(methodObject17318, (Object)this.delegate.getAuthorizationIndicator(arg0));
      } catch (SQLException var3) {
         return (OracleResultSet.AuthorizationIndicator)this.postForAll(methodObject17318, this.onErrorForAll(methodObject17318, var3));
      }
   }

   public SQLXML getSQLXML(String arg0) throws SQLException {
      try {
         super.preForAll(methodObject17442, this, arg0);
         return (SQLXML)this.postForAll(methodObject17442, this.proxyFactory.proxyForCreate((Object)this.delegate.getSQLXML(arg0), this, this.proxyCache, methodObject17442));
      } catch (SQLException var3) {
         return (SQLXML)this.postForAll(methodObject17442, this.onErrorForAll(methodObject17442, var3));
      }
   }

   public void updateCharacterStream(String arg0, Reader arg1, long arg2) throws SQLException {
      try {
         super.preForUpdateStreams(methodObject17420, this, arg0, arg1, arg2);
         Method var10001 = methodObject17420;
         this.delegate.updateCharacterStream(arg0, arg1, arg2);
         this.postForAll(var10001);
      } catch (SQLException var6) {
         this.onErrorVoidForAll(methodObject17420, var6);
      }
   }

   public Reader getCharacterStream(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject17454, this, arg0);
         return (Reader)this.postForAll(methodObject17454, (Object)this.delegate.getCharacterStream(arg0));
      } catch (SQLException var3) {
         return (Reader)this.postForAll(methodObject17454, this.onErrorForAll(methodObject17454, var3));
      }
   }

   public void updateCHAR(String arg0, CHAR arg1) throws SQLException {
      try {
         super.preForAll(methodObject17289, this, arg0, arg1);
         Method var10001 = methodObject17289;
         this.delegate.updateCHAR(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject17289, var4);
      }
   }

   public void updateTIMESTAMPTZ(String arg0, TIMESTAMPTZ arg1) throws SQLException {
      try {
         super.preForAll(methodObject17303, this, arg0, arg1);
         Method var10001 = methodObject17303;
         this.delegate.updateTIMESTAMPTZ(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject17303, var4);
      }
   }

   public void updateDate(int arg0, Date arg1) throws SQLException {
      try {
         super.preForAll(methodObject17517, this, arg0, arg1);
         Method var10001 = methodObject17517;
         this.delegate.updateDate(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject17517, var4);
      }
   }

   public boolean isBeforeFirst() throws SQLException {
      try {
         super.preForAll(methodObject17481, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject17481, this.delegate.isBeforeFirst());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject17481, this.onErrorForAll(methodObject17481, var2));
      }
   }

   public RowId getRowId(String arg0) throws SQLException {
      try {
         super.preForAll(methodObject17440, this, arg0);
         return (RowId)this.postForAll(methodObject17440, this.proxyFactory.proxyForCreate((Object)this.delegate.getRowId(arg0), this, this.proxyCache, methodObject17440));
      } catch (SQLException var3) {
         return (RowId)this.postForAll(methodObject17440, this.onErrorForAll(methodObject17440, var3));
      }
   }

   public int getConcurrency() throws SQLException {
      try {
         super.preForAll(methodObject17465, this, zeroLengthObjectArray);
         return (Integer)this.postForAll(methodObject17465, this.delegate.getConcurrency());
      } catch (SQLException var2) {
         return (Integer)this.postForAll(methodObject17465, this.onErrorForAll(methodObject17465, var2));
      }
   }

   public void updateBlob(int arg0, InputStream arg1, long arg2) throws SQLException {
      try {
         super.preForAll(methodObject17501, this, arg0, arg1, arg2);
         Method var10001 = methodObject17501;
         this.delegate.updateBlob(arg0, arg1, arg2);
         this.postForAll(var10001);
      } catch (SQLException var6) {
         this.onErrorVoidForAll(methodObject17501, var6);
      }
   }

   public void updateTimestamp(int arg0, Timestamp arg1) throws SQLException {
      try {
         super.preForAll(methodObject17551, this, arg0, arg1);
         Method var10001 = methodObject17551;
         this.delegate.updateTimestamp(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject17551, var4);
      }
   }

   public void updateTIMESTAMP(String arg0, TIMESTAMP arg1) throws SQLException {
      try {
         super.preForAll(methodObject17301, this, arg0, arg1);
         Method var10001 = methodObject17301;
         this.delegate.updateTIMESTAMP(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject17301, var4);
      }
   }

   public void updateCHAR(int arg0, CHAR arg1) throws SQLException {
      try {
         super.preForAll(methodObject17288, this, arg0, arg1);
         Method var10001 = methodObject17288;
         this.delegate.updateCHAR(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject17288, var4);
      }
   }

   public void updateBigDecimal(String arg0, BigDecimal arg1) throws SQLException {
      try {
         super.preForAll(methodObject17498, this, arg0, arg1);
         Method var10001 = methodObject17498;
         this.delegate.updateBigDecimal(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject17498, var4);
      }
   }

   public boolean rowInserted() throws SQLException {
      try {
         super.preForAll(methodObject17489, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject17489, this.delegate.rowInserted());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject17489, this.onErrorForAll(methodObject17489, var2));
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
         methodObject17510 = ResultSet.class.getDeclaredMethod("updateBytes", String.class, byte[].class);
         methodObject17376 = ResultSet.class.getDeclaredMethod("getInt", Integer.TYPE);
         methodObject17446 = ResultSet.class.getDeclaredMethod("getTime", String.class, Calendar.class);
         methodObject17479 = ResultSet.class.getDeclaredMethod("getUnicodeStream", String.class);
         methodObject17299 = OracleResultSet.class.getDeclaredMethod("updateINTERVALDS", String.class, INTERVALDS.class);
         methodObject17483 = ResultSet.class.getDeclaredMethod("isLast");
         methodObject17503 = ResultSet.class.getDeclaredMethod("updateBlob", Integer.TYPE, InputStream.class);
         methodObject17342 = OracleResultSet.class.getDeclaredMethod("getOPAQUE", Integer.TYPE);
         methodObject17296 = OracleResultSet.class.getDeclaredMethod("updateINTERVALYM", Integer.TYPE, INTERVALYM.class);
         methodObject17312 = OracleResultSet.class.getDeclaredMethod("updateREF", Integer.TYPE, REF.class);
         methodObject17462 = ResultSet.class.getDeclaredMethod("getBigDecimal", String.class, Integer.TYPE);
         methodObject17496 = ResultSet.class.getDeclaredMethod("updateArray", String.class, Array.class);
         methodObject17382 = ResultSet.class.getDeclaredMethod("getDouble", Integer.TYPE);
         methodObject17358 = OracleResultSet.class.getDeclaredMethod("getTIMESTAMPTZ", Integer.TYPE);
         methodObject17294 = OracleResultSet.class.getDeclaredMethod("updateDATE", Integer.TYPE, DATE.class);
         methodObject17285 = OracleResultSet.class.getDeclaredMethod("updateBFILE", String.class, BFILE.class);
         methodObject17514 = ResultSet.class.getDeclaredMethod("updateClob", String.class, Reader.class, Long.TYPE);
         methodObject17276 = OracleResultSet.class.getDeclaredMethod("getObject", Integer.TYPE, OracleDataFactory.class);
         methodObject17421 = ResultSet.class.getDeclaredMethod("updateCharacterStream", Integer.TYPE, Reader.class);
         methodObject17527 = ResultSet.class.getDeclaredMethod("updateNClob", Integer.TYPE, NClob.class);
         methodObject17397 = ResultSet.class.getDeclaredMethod("getString", String.class);
         methodObject17521 = ResultSet.class.getDeclaredMethod("updateFloat", Integer.TYPE, Float.TYPE);
         methodObject17378 = ResultSet.class.getDeclaredMethod("getLong", Integer.TYPE);
         methodObject17309 = OracleResultSet.class.getDeclaredMethod("updateOracleObject", String.class, Datum.class);
         methodObject17399 = ResultSet.class.getDeclaredMethod("getDate", String.class);
         methodObject17415 = ResultSet.class.getDeclaredMethod("updateBinaryStream", Integer.TYPE, InputStream.class);
         methodObject17486 = ResultSet.class.getDeclaredMethod("refreshRow");
         methodObject17385 = ResultSet.class.getDeclaredMethod("getBytes", String.class);
         methodObject17407 = ResultSet.class.getDeclaredMethod("updateAsciiStream", Integer.TYPE, InputStream.class, Long.TYPE);
         methodObject17316 = OracleResultSet.class.getDeclaredMethod("updateSTRUCT", Integer.TYPE, STRUCT.class);
         methodObject17321 = OracleResultSet.class.getDeclaredMethod("getOracleObject", String.class);
         methodObject17396 = ResultSet.class.getDeclaredMethod("getString", Integer.TYPE);
         methodObject17307 = OracleResultSet.class.getDeclaredMethod("updateNUMBER", String.class, NUMBER.class);
         methodObject17311 = OracleResultSet.class.getDeclaredMethod("updateRAW", String.class, RAW.class);
         methodObject17363 = OracleResultSet.class.getDeclaredMethod("getARRAY", String.class);
         methodObject17282 = OracleResultSet.class.getDeclaredMethod("updateBfile", Integer.TYPE, BFILE.class);
         methodObject17341 = OracleResultSet.class.getDeclaredMethod("getNUMBER", String.class);
         methodObject17509 = ResultSet.class.getDeclaredMethod("updateBytes", Integer.TYPE, byte[].class);
         methodObject17331 = OracleResultSet.class.getDeclaredMethod("getCHAR", String.class);
         methodObject17456 = ResultSet.class.getDeclaredMethod("wasNull");
         methodObject17450 = ResultSet.class.getDeclaredMethod("updateTime", Integer.TYPE, Time.class);
         methodObject17395 = ResultSet.class.getDeclaredMethod("getRef", String.class);
         methodObject17306 = OracleResultSet.class.getDeclaredMethod("updateNUMBER", Integer.TYPE, NUMBER.class);
         methodObject17404 = ResultSet.class.getDeclaredMethod("updateRow");
         methodObject17550 = ResultSet.class.getDeclaredMethod("updateString", String.class, String.class);
         methodObject17480 = ResultSet.class.getDeclaredMethod("isAfterLast");
         methodObject17540 = ResultSet.class.getDeclaredMethod("updateObject", String.class, Object.class);
         methodObject17445 = ResultSet.class.getDeclaredMethod("getTime", Integer.TYPE, Calendar.class);
         methodObject17544 = ResultSet.class.getDeclaredMethod("updateRowId", String.class, RowId.class);
         methodObject17507 = ResultSet.class.getDeclaredMethod("updateByte", Integer.TYPE, Byte.TYPE);
         methodObject17308 = OracleResultSet.class.getDeclaredMethod("updateOracleObject", Integer.TYPE, Datum.class);
         methodObject17448 = ResultSet.class.getDeclaredMethod("clearWarnings");
         methodObject17413 = ResultSet.class.getDeclaredMethod("updateBinaryStream", Integer.TYPE, InputStream.class, Long.TYPE);
         methodObject17417 = ResultSet.class.getDeclaredMethod("updateCharacterStream", Integer.TYPE, Reader.class, Integer.TYPE);
         methodObject17347 = OracleResultSet.class.getDeclaredMethod("getREF", String.class);
         methodObject17355 = OracleResultSet.class.getDeclaredMethod("getINTERVALDS", String.class);
         methodObject17519 = ResultSet.class.getDeclaredMethod("updateDouble", Integer.TYPE, Double.TYPE);
         methodObject17334 = OracleResultSet.class.getDeclaredMethod("getCustomDatum", Integer.TYPE, CustomDatumFactory.class);
         methodObject17380 = ResultSet.class.getDeclaredMethod("getFloat", Integer.TYPE);
         methodObject17451 = ResultSet.class.getDeclaredMethod("updateTime", String.class, Time.class);
         methodObject17364 = ResultSet.class.getDeclaredMethod("getObject", Integer.TYPE);
         methodObject17424 = ResultSet.class.getDeclaredMethod("updateNCharacterStream", String.class, Reader.class, Long.TYPE);
         methodObject17356 = OracleResultSet.class.getDeclaredMethod("getTIMESTAMP", Integer.TYPE);
         methodObject17432 = ResultSet.class.getDeclaredMethod("getMetaData");
         methodObject17354 = OracleResultSet.class.getDeclaredMethod("getINTERVALDS", Integer.TYPE);
         methodObject17431 = ResultSet.class.getDeclaredMethod("isClosed");
         methodObject17441 = ResultSet.class.getDeclaredMethod("getSQLXML", Integer.TYPE);
         methodObject17531 = ResultSet.class.getDeclaredMethod("updateNClob", Integer.TYPE, Reader.class);
         methodObject17406 = ResultSet.class.getDeclaredMethod("updateAsciiStream", String.class, InputStream.class, Integer.TYPE);
         methodObject17513 = ResultSet.class.getDeclaredMethod("updateClob", Integer.TYPE, Reader.class, Long.TYPE);
         methodObject17469 = ResultSet.class.getDeclaredMethod("getNCharacterStream", Integer.TYPE);
         methodObject17375 = ResultSet.class.getDeclaredMethod("getShort", String.class);
         methodObject17541 = ResultSet.class.getDeclaredMethod("updateRef", Integer.TYPE, Ref.class);
         methodObject17516 = ResultSet.class.getDeclaredMethod("updateClob", String.class, Reader.class);
         methodObject17302 = OracleResultSet.class.getDeclaredMethod("updateTIMESTAMPTZ", Integer.TYPE, TIMESTAMPTZ.class);
         methodObject17427 = ResultSet.class.getDeclaredMethod("last");
         methodObject17433 = ResultSet.class.getDeclaredMethod("getBlob", Integer.TYPE);
         methodObject17530 = ResultSet.class.getDeclaredMethod("updateNClob", String.class, Reader.class, Long.TYPE);
         methodObject17490 = ResultSet.class.getDeclaredMethod("rowUpdated");
         methodObject17453 = ResultSet.class.getDeclaredMethod("getAsciiStream", String.class);
         methodObject17369 = ResultSet.class.getDeclaredMethod("getObject", String.class, Class.class);
         methodObject17319 = OracleResultSet.class.getDeclaredMethod("getAuthorizationIndicator", String.class);
         methodObject17426 = ResultSet.class.getDeclaredMethod("updateNCharacterStream", String.class, Reader.class);
         methodObject17471 = ResultSet.class.getDeclaredMethod("getNString", Integer.TYPE);
         methodObject17467 = ResultSet.class.getDeclaredMethod("getFetchDirection");
         methodObject17439 = ResultSet.class.getDeclaredMethod("getRowId", Integer.TYPE);
         methodObject17390 = ResultSet.class.getDeclaredMethod("getURL", String.class);
         methodObject17536 = ResultSet.class.getDeclaredMethod("updateNull", String.class);
         methodObject17482 = ResultSet.class.getDeclaredMethod("isFirst");
         methodObject17470 = ResultSet.class.getDeclaredMethod("getNCharacterStream", String.class);
         methodObject17393 = ResultSet.class.getDeclaredMethod("previous");
         methodObject17290 = OracleResultSet.class.getDeclaredMethod("updateCLOB", Integer.TYPE, CLOB.class);
         methodObject17293 = OracleResultSet.class.getDeclaredMethod("updateORAData", String.class, ORAData.class);
         methodObject17459 = ResultSet.class.getDeclaredMethod("findColumn", String.class);
         methodObject17305 = OracleResultSet.class.getDeclaredMethod("updateTIMESTAMPLTZ", String.class, TIMESTAMPLTZ.class);
         methodObject17464 = ResultSet.class.getDeclaredMethod("getBigDecimal", String.class);
         methodObject17371 = ResultSet.class.getDeclaredMethod("getBoolean", String.class);
         methodObject17388 = ResultSet.class.getDeclaredMethod("next");
         methodObject17523 = ResultSet.class.getDeclaredMethod("updateInt", Integer.TYPE, Integer.TYPE);
         methodObject17392 = ResultSet.class.getDeclaredMethod("getType");
         methodObject17444 = ResultSet.class.getDeclaredMethod("getTime", String.class);
         methodObject17506 = ResultSet.class.getDeclaredMethod("updateBoolean", String.class, Boolean.TYPE);
         methodObject17343 = OracleResultSet.class.getDeclaredMethod("getOPAQUE", String.class);
         methodObject17298 = OracleResultSet.class.getDeclaredMethod("updateINTERVALDS", Integer.TYPE, INTERVALDS.class);
         methodObject17474 = ResultSet.class.getDeclaredMethod("getTimestamp", Integer.TYPE);
         methodObject17384 = ResultSet.class.getDeclaredMethod("getBytes", Integer.TYPE);
         methodObject17401 = ResultSet.class.getDeclaredMethod("getDate", String.class, Calendar.class);
         methodObject17277 = OracleResultSet.class.getDeclaredMethod("getObject", String.class, OracleDataFactory.class);
         methodObject17526 = ResultSet.class.getDeclaredMethod("updateLong", String.class, Long.TYPE);
         methodObject17323 = OracleResultSet.class.getDeclaredMethod("getCursor", String.class);
         methodObject17280 = OracleResultSet.class.getDeclaredMethod("updateARRAY", Integer.TYPE, ARRAY.class);
         methodObject17499 = ResultSet.class.getDeclaredMethod("updateBlob", Integer.TYPE, Blob.class);
         methodObject17545 = ResultSet.class.getDeclaredMethod("updateSQLXML", Integer.TYPE, SQLXML.class);
         methodObject17333 = OracleResultSet.class.getDeclaredMethod("getCLOB", String.class);
         methodObject17352 = OracleResultSet.class.getDeclaredMethod("getINTERVALYM", Integer.TYPE);
         methodObject17324 = OracleResultSet.class.getDeclaredMethod("getBFILE", Integer.TYPE);
         methodObject17487 = ResultSet.class.getDeclaredMethod("relative", Integer.TYPE);
         methodObject17553 = Wrapper.class.getDeclaredMethod("unwrap", Class.class);
         methodObject17511 = ResultSet.class.getDeclaredMethod("updateClob", Integer.TYPE, Clob.class);
         methodObject17336 = OracleResultSet.class.getDeclaredMethod("getORAData", Integer.TYPE, ORADataFactory.class);
         methodObject17543 = ResultSet.class.getDeclaredMethod("updateRowId", Integer.TYPE, RowId.class);
         methodObject17478 = ResultSet.class.getDeclaredMethod("getUnicodeStream", Integer.TYPE);
         methodObject17472 = ResultSet.class.getDeclaredMethod("getNString", String.class);
         methodObject17284 = OracleResultSet.class.getDeclaredMethod("updateBFILE", Integer.TYPE, BFILE.class);
         methodObject17522 = ResultSet.class.getDeclaredMethod("updateFloat", String.class, Float.TYPE);
         methodObject17520 = ResultSet.class.getDeclaredMethod("updateDouble", String.class, Double.TYPE);
         methodObject17457 = ResultSet.class.getDeclaredMethod("beforeFirst");
         methodObject17552 = ResultSet.class.getDeclaredMethod("updateTimestamp", String.class, Timestamp.class);
         methodObject17353 = OracleResultSet.class.getDeclaredMethod("getINTERVALYM", String.class);
         methodObject17377 = ResultSet.class.getDeclaredMethod("getInt", String.class);
         methodObject17340 = OracleResultSet.class.getDeclaredMethod("getNUMBER", Integer.TYPE);
         methodObject17422 = ResultSet.class.getDeclaredMethod("updateCharacterStream", String.class, Reader.class);
         methodObject17402 = ResultSet.class.getDeclaredMethod("deleteRow");
         methodObject17534 = ResultSet.class.getDeclaredMethod("updateNString", String.class, String.class);
         methodObject17304 = OracleResultSet.class.getDeclaredMethod("updateTIMESTAMPLTZ", Integer.TYPE, TIMESTAMPLTZ.class);
         methodObject17281 = OracleResultSet.class.getDeclaredMethod("updateARRAY", String.class, ARRAY.class);
         methodObject17429 = ResultSet.class.getDeclaredMethod("getBinaryStream", Integer.TYPE);
         methodObject17532 = ResultSet.class.getDeclaredMethod("updateNClob", String.class, Reader.class);
         methodObject17320 = OracleResultSet.class.getDeclaredMethod("getOracleObject", Integer.TYPE);
         methodObject17425 = ResultSet.class.getDeclaredMethod("updateNCharacterStream", Integer.TYPE, Reader.class);
         methodObject17361 = OracleResultSet.class.getDeclaredMethod("getTIMESTAMPLTZ", String.class);
         methodObject17460 = ResultSet.class.getDeclaredMethod("first");
         methodObject17329 = OracleResultSet.class.getDeclaredMethod("getBLOB", String.class);
         methodObject17328 = OracleResultSet.class.getDeclaredMethod("getBLOB", Integer.TYPE);
         methodObject17508 = ResultSet.class.getDeclaredMethod("updateByte", String.class, Byte.TYPE);
         methodObject17339 = OracleResultSet.class.getDeclaredMethod("getDATE", String.class);
         methodObject17419 = ResultSet.class.getDeclaredMethod("updateCharacterStream", Integer.TYPE, Reader.class, Long.TYPE);
         methodObject17345 = OracleResultSet.class.getDeclaredMethod("getRAW", String.class);
         methodObject17330 = OracleResultSet.class.getDeclaredMethod("getCHAR", Integer.TYPE);
         methodObject17283 = OracleResultSet.class.getDeclaredMethod("updateBfile", String.class, BFILE.class);
         methodObject17287 = OracleResultSet.class.getDeclaredMethod("updateBLOB", String.class, BLOB.class);
         methodObject17504 = ResultSet.class.getDeclaredMethod("updateBlob", String.class, InputStream.class);
         methodObject17533 = ResultSet.class.getDeclaredMethod("updateNString", Integer.TYPE, String.class);
         methodObject17537 = ResultSet.class.getDeclaredMethod("updateObject", Integer.TYPE, Object.class, Integer.TYPE);
         methodObject17297 = OracleResultSet.class.getDeclaredMethod("updateINTERVALYM", String.class, INTERVALYM.class);
         methodObject17412 = ResultSet.class.getDeclaredMethod("updateBinaryStream", String.class, InputStream.class, Integer.TYPE);
         methodObject17443 = ResultSet.class.getDeclaredMethod("getTime", Integer.TYPE);
         methodObject17485 = ResultSet.class.getDeclaredMethod("moveToInsertRow");
         methodObject17529 = ResultSet.class.getDeclaredMethod("updateNClob", Integer.TYPE, Reader.class, Long.TYPE);
         methodObject17518 = ResultSet.class.getDeclaredMethod("updateDate", String.class, Date.class);
         methodObject17300 = OracleResultSet.class.getDeclaredMethod("updateTIMESTAMP", Integer.TYPE, TIMESTAMP.class);
         methodObject17423 = ResultSet.class.getDeclaredMethod("updateNCharacterStream", Integer.TYPE, Reader.class, Long.TYPE);
         methodObject17458 = ResultSet.class.getDeclaredMethod("cancelRowUpdates");
         methodObject17365 = ResultSet.class.getDeclaredMethod("getObject", String.class);
         methodObject17449 = ResultSet.class.getDeclaredMethod("getHoldability");
         methodObject17349 = OracleResultSet.class.getDeclaredMethod("getROWID", String.class);
         methodObject17525 = ResultSet.class.getDeclaredMethod("updateLong", Integer.TYPE, Long.TYPE);
         methodObject17337 = OracleResultSet.class.getDeclaredMethod("getORAData", String.class, ORADataFactory.class);
         methodObject17416 = ResultSet.class.getDeclaredMethod("updateBinaryStream", String.class, InputStream.class);
         methodObject17370 = ResultSet.class.getDeclaredMethod("getBoolean", Integer.TYPE);
         methodObject17461 = ResultSet.class.getDeclaredMethod("getBigDecimal", Integer.TYPE, Integer.TYPE);
         methodObject17463 = ResultSet.class.getDeclaredMethod("getBigDecimal", Integer.TYPE);
         methodObject17408 = ResultSet.class.getDeclaredMethod("updateAsciiStream", String.class, InputStream.class, Long.TYPE);
         methodObject17295 = OracleResultSet.class.getDeclaredMethod("updateDATE", String.class, DATE.class);
         methodObject17357 = OracleResultSet.class.getDeclaredMethod("getTIMESTAMP", String.class);
         methodObject17547 = ResultSet.class.getDeclaredMethod("updateShort", Integer.TYPE, Short.TYPE);
         methodObject17374 = ResultSet.class.getDeclaredMethod("getShort", Integer.TYPE);
         methodObject17394 = ResultSet.class.getDeclaredMethod("getRef", Integer.TYPE);
         methodObject17325 = OracleResultSet.class.getDeclaredMethod("getBFILE", String.class);
         methodObject17310 = OracleResultSet.class.getDeclaredMethod("updateRAW", Integer.TYPE, RAW.class);
         methodObject17398 = ResultSet.class.getDeclaredMethod("getDate", Integer.TYPE);
         methodObject17434 = ResultSet.class.getDeclaredMethod("getBlob", String.class);
         methodObject17548 = ResultSet.class.getDeclaredMethod("updateShort", String.class, Short.TYPE);
         methodObject17528 = ResultSet.class.getDeclaredMethod("updateNClob", String.class, NClob.class);
         methodObject17366 = ResultSet.class.getDeclaredMethod("getObject", Integer.TYPE, Map.class);
         methodObject17500 = ResultSet.class.getDeclaredMethod("updateBlob", String.class, Blob.class);
         methodObject17400 = ResultSet.class.getDeclaredMethod("getDate", Integer.TYPE, Calendar.class);
         methodObject17346 = OracleResultSet.class.getDeclaredMethod("getREF", Integer.TYPE);
         methodObject17488 = ResultSet.class.getDeclaredMethod("rowDeleted");
         methodObject17359 = OracleResultSet.class.getDeclaredMethod("getTIMESTAMPTZ", String.class);
         methodObject17549 = ResultSet.class.getDeclaredMethod("updateString", Integer.TYPE, String.class);
         methodObject17494 = ResultSet.class.getDeclaredMethod("afterLast");
         methodObject17278 = OracleResultSet.class.getDeclaredMethod("updateCustomDatum", Integer.TYPE, CustomDatum.class);
         methodObject17515 = ResultSet.class.getDeclaredMethod("updateClob", Integer.TYPE, Reader.class);
         methodObject17495 = ResultSet.class.getDeclaredMethod("updateArray", Integer.TYPE, Array.class);
         methodObject17313 = OracleResultSet.class.getDeclaredMethod("updateREF", String.class, REF.class);
         methodObject17389 = ResultSet.class.getDeclaredMethod("getURL", Integer.TYPE);
         methodObject17387 = ResultSet.class.getDeclaredMethod("getArray", String.class);
         methodObject17428 = ResultSet.class.getDeclaredMethod("getStatement");
         methodObject17447 = ResultSet.class.getDeclaredMethod("getWarnings");
         methodObject17286 = OracleResultSet.class.getDeclaredMethod("updateBLOB", Integer.TYPE, BLOB.class);
         methodObject17455 = ResultSet.class.getDeclaredMethod("getCharacterStream", String.class);
         methodObject17372 = ResultSet.class.getDeclaredMethod("getByte", Integer.TYPE);
         methodObject17314 = OracleResultSet.class.getDeclaredMethod("updateROWID", Integer.TYPE, ROWID.class);
         methodObject17338 = OracleResultSet.class.getDeclaredMethod("getDATE", Integer.TYPE);
         methodObject17332 = OracleResultSet.class.getDeclaredMethod("getCLOB", Integer.TYPE);
         methodObject17362 = OracleResultSet.class.getDeclaredMethod("getARRAY", Integer.TYPE);
         methodObject17326 = OracleResultSet.class.getDeclaredMethod("getBfile", Integer.TYPE);
         methodObject17477 = ResultSet.class.getDeclaredMethod("getTimestamp", String.class, Calendar.class);
         methodObject17379 = ResultSet.class.getDeclaredMethod("getLong", String.class);
         methodObject17435 = ResultSet.class.getDeclaredMethod("getClob", Integer.TYPE);
         methodObject17497 = ResultSet.class.getDeclaredMethod("updateBigDecimal", Integer.TYPE, BigDecimal.class);
         methodObject17348 = OracleResultSet.class.getDeclaredMethod("getROWID", Integer.TYPE);
         methodObject17502 = ResultSet.class.getDeclaredMethod("updateBlob", String.class, InputStream.class, Long.TYPE);
         methodObject17466 = ResultSet.class.getDeclaredMethod("getCursorName");
         methodObject17391 = ResultSet.class.getDeclaredMethod("close");
         methodObject17414 = ResultSet.class.getDeclaredMethod("updateBinaryStream", String.class, InputStream.class, Long.TYPE);
         methodObject17322 = OracleResultSet.class.getDeclaredMethod("getCursor", Integer.TYPE);
         methodObject17383 = ResultSet.class.getDeclaredMethod("getDouble", String.class);
         methodObject17368 = ResultSet.class.getDeclaredMethod("getObject", Integer.TYPE, Class.class);
         methodObject17542 = ResultSet.class.getDeclaredMethod("updateRef", String.class, Ref.class);
         methodObject17493 = ResultSet.class.getDeclaredMethod("absolute", Integer.TYPE);
         methodObject17476 = ResultSet.class.getDeclaredMethod("getTimestamp", Integer.TYPE, Calendar.class);
         methodObject17452 = ResultSet.class.getDeclaredMethod("getAsciiStream", Integer.TYPE);
         methodObject17344 = OracleResultSet.class.getDeclaredMethod("getRAW", Integer.TYPE);
         methodObject17505 = ResultSet.class.getDeclaredMethod("updateBoolean", Integer.TYPE, Boolean.TYPE);
         methodObject17437 = ResultSet.class.getDeclaredMethod("getNClob", Integer.TYPE);
         methodObject17411 = ResultSet.class.getDeclaredMethod("updateBinaryStream", Integer.TYPE, InputStream.class, Integer.TYPE);
         methodObject17373 = ResultSet.class.getDeclaredMethod("getByte", String.class);
         methodObject17410 = ResultSet.class.getDeclaredMethod("updateAsciiStream", String.class, InputStream.class);
         methodObject17546 = ResultSet.class.getDeclaredMethod("updateSQLXML", String.class, SQLXML.class);
         methodObject17291 = OracleResultSet.class.getDeclaredMethod("updateCLOB", String.class, CLOB.class);
         methodObject17386 = ResultSet.class.getDeclaredMethod("getArray", Integer.TYPE);
         methodObject17418 = ResultSet.class.getDeclaredMethod("updateCharacterStream", String.class, Reader.class, Integer.TYPE);
         methodObject17475 = ResultSet.class.getDeclaredMethod("getTimestamp", String.class);
         methodObject17409 = ResultSet.class.getDeclaredMethod("updateAsciiStream", Integer.TYPE, InputStream.class);
         methodObject17350 = OracleResultSet.class.getDeclaredMethod("getSTRUCT", Integer.TYPE);
         methodObject17436 = ResultSet.class.getDeclaredMethod("getClob", String.class);
         methodObject17512 = ResultSet.class.getDeclaredMethod("updateClob", String.class, Clob.class);
         methodObject17360 = OracleResultSet.class.getDeclaredMethod("getTIMESTAMPLTZ", Integer.TYPE);
         methodObject17405 = ResultSet.class.getDeclaredMethod("updateAsciiStream", Integer.TYPE, InputStream.class, Integer.TYPE);
         methodObject17538 = ResultSet.class.getDeclaredMethod("updateObject", Integer.TYPE, Object.class);
         methodObject17473 = ResultSet.class.getDeclaredMethod("getRow");
         methodObject17335 = OracleResultSet.class.getDeclaredMethod("getCustomDatum", String.class, CustomDatumFactory.class);
         methodObject17317 = OracleResultSet.class.getDeclaredMethod("updateSTRUCT", String.class, STRUCT.class);
         methodObject17381 = ResultSet.class.getDeclaredMethod("getFloat", String.class);
         methodObject17438 = ResultSet.class.getDeclaredMethod("getNClob", String.class);
         methodObject17327 = OracleResultSet.class.getDeclaredMethod("getBfile", String.class);
         methodObject17403 = ResultSet.class.getDeclaredMethod("insertRow");
         methodObject17492 = ResultSet.class.getDeclaredMethod("setFetchSize", Integer.TYPE);
         methodObject17491 = ResultSet.class.getDeclaredMethod("setFetchDirection", Integer.TYPE);
         methodObject17539 = ResultSet.class.getDeclaredMethod("updateObject", String.class, Object.class, Integer.TYPE);
         methodObject17468 = ResultSet.class.getDeclaredMethod("getFetchSize");
         methodObject17315 = OracleResultSet.class.getDeclaredMethod("updateROWID", String.class, ROWID.class);
         methodObject17484 = ResultSet.class.getDeclaredMethod("moveToCurrentRow");
         methodObject17430 = ResultSet.class.getDeclaredMethod("getBinaryStream", String.class);
         methodObject17524 = ResultSet.class.getDeclaredMethod("updateInt", String.class, Integer.TYPE);
         methodObject17279 = OracleResultSet.class.getDeclaredMethod("updateCustomDatum", String.class, CustomDatum.class);
         methodObject17292 = OracleResultSet.class.getDeclaredMethod("updateORAData", Integer.TYPE, ORAData.class);
         methodObject17535 = ResultSet.class.getDeclaredMethod("updateNull", Integer.TYPE);
         methodObject17554 = Wrapper.class.getDeclaredMethod("isWrapperFor", Class.class);
         methodObject17367 = ResultSet.class.getDeclaredMethod("getObject", String.class, Map.class);
         methodObject17351 = OracleResultSet.class.getDeclaredMethod("getSTRUCT", String.class);
         methodObject17318 = OracleResultSet.class.getDeclaredMethod("getAuthorizationIndicator", Integer.TYPE);
         methodObject17442 = ResultSet.class.getDeclaredMethod("getSQLXML", String.class);
         methodObject17420 = ResultSet.class.getDeclaredMethod("updateCharacterStream", String.class, Reader.class, Long.TYPE);
         methodObject17454 = ResultSet.class.getDeclaredMethod("getCharacterStream", Integer.TYPE);
         methodObject17289 = OracleResultSet.class.getDeclaredMethod("updateCHAR", String.class, CHAR.class);
         methodObject17303 = OracleResultSet.class.getDeclaredMethod("updateTIMESTAMPTZ", String.class, TIMESTAMPTZ.class);
         methodObject17517 = ResultSet.class.getDeclaredMethod("updateDate", Integer.TYPE, Date.class);
         methodObject17481 = ResultSet.class.getDeclaredMethod("isBeforeFirst");
         methodObject17440 = ResultSet.class.getDeclaredMethod("getRowId", String.class);
         methodObject17465 = ResultSet.class.getDeclaredMethod("getConcurrency");
         methodObject17501 = ResultSet.class.getDeclaredMethod("updateBlob", Integer.TYPE, InputStream.class, Long.TYPE);
         methodObject17551 = ResultSet.class.getDeclaredMethod("updateTimestamp", Integer.TYPE, Timestamp.class);
         methodObject17301 = OracleResultSet.class.getDeclaredMethod("updateTIMESTAMP", String.class, TIMESTAMP.class);
         methodObject17288 = OracleResultSet.class.getDeclaredMethod("updateCHAR", Integer.TYPE, CHAR.class);
         methodObject17498 = ResultSet.class.getDeclaredMethod("updateBigDecimal", String.class, BigDecimal.class);
         methodObject17489 = ResultSet.class.getDeclaredMethod("rowInserted");
      } catch (Throwable var1) {
         throw new RuntimeException(var1);
      }
   }

   public oracle$1jdbc$1replay$1driver$1NonTxnReplayableResultSet$2oracle$1jdbc$1OracleResultSet$$$Proxy(OracleResultSet var1, Object var2, ProxyFactory var3, Map var4) {
      this.delegate = var1;
      this.creator = var2;
      this.proxyFactory = var3;
      this.proxyCache = var4;
   }
}
