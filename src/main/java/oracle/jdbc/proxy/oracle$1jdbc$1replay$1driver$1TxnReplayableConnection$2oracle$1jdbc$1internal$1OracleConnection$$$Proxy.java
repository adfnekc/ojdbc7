package oracle.jdbc.proxy;

import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.SocketException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.sql.Array;
import java.sql.Blob;
import java.sql.CallableStatement;
import java.sql.Clob;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.Date;
import java.sql.NClob;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLClientInfoException;
import java.sql.SQLException;
import java.sql.SQLWarning;
import java.sql.SQLXML;
import java.sql.Savepoint;
import java.sql.Statement;
import java.sql.Struct;
import java.sql.Time;
import java.sql.Timestamp;
import java.sql.Wrapper;
import java.util.Calendar;
import java.util.EnumSet;
import java.util.Enumeration;
import java.util.Map;
import java.util.Properties;
import java.util.TimeZone;
import java.util.concurrent.Executor;
import javax.transaction.xa.XAResource;
import oracle.jdbc.LogicalTransactionId;
import oracle.jdbc.LogicalTransactionIdEventListener;
import oracle.jdbc.OracleOCIFailover;
import oracle.jdbc.OracleSavepoint;
import oracle.jdbc.aq.AQDequeueOptions;
import oracle.jdbc.aq.AQEnqueueOptions;
import oracle.jdbc.aq.AQMessage;
import oracle.jdbc.aq.AQMessageProperties;
import oracle.jdbc.aq.AQNotificationRegistration;
import oracle.jdbc.dcn.DatabaseChangeRegistration;
import oracle.jdbc.internal.ACProxyable;
import oracle.jdbc.internal.JMSDequeueOptions;
import oracle.jdbc.internal.JMSEnqueueOptions;
import oracle.jdbc.internal.JMSMessage;
import oracle.jdbc.internal.JMSNotificationRegistration;
import oracle.jdbc.internal.KeywordValueLong;
import oracle.jdbc.internal.OracleConnection;
import oracle.jdbc.internal.OracleStatement;
import oracle.jdbc.internal.PDBChangeEventListener;
import oracle.jdbc.internal.ReplayContext;
import oracle.jdbc.internal.XSEventListener;
import oracle.jdbc.internal.XSKeyval;
import oracle.jdbc.internal.XSNamespace;
import oracle.jdbc.internal.XSPrincipal;
import oracle.jdbc.internal.XSSecureId;
import oracle.jdbc.internal.XSSessionParameters;
import oracle.jdbc.oracore.OracleTypeADT;
import oracle.jdbc.oracore.OracleTypeCLOB;
import oracle.jdbc.pool.OracleConnectionCacheCallback;
import oracle.jdbc.pool.OraclePooledConnection;
import oracle.jdbc.replay.driver.TxnReplayableConnection;
import oracle.sql.ARRAY;
import oracle.sql.ArrayDescriptor;
import oracle.sql.BFILE;
import oracle.sql.BINARY_DOUBLE;
import oracle.sql.BINARY_FLOAT;
import oracle.sql.BLOB;
import oracle.sql.BfileDBAccess;
import oracle.sql.BlobDBAccess;
import oracle.sql.CLOB;
import oracle.sql.ClobDBAccess;
import oracle.sql.CustomDatum;
import oracle.sql.DATE;
import oracle.sql.Datum;
import oracle.sql.INTERVALDS;
import oracle.sql.INTERVALYM;
import oracle.sql.NUMBER;
import oracle.sql.StructDescriptor;
import oracle.sql.TIMESTAMP;
import oracle.sql.TIMESTAMPLTZ;
import oracle.sql.TIMESTAMPTZ;
import oracle.sql.TIMEZONETAB;
import oracle.sql.TypeDescriptor;

public class oracle$1jdbc$1replay$1driver$1TxnReplayableConnection$2oracle$1jdbc$1internal$1OracleConnection$$$Proxy extends TxnReplayableConnection implements OracleConnection, _Proxy_ {
   private OracleConnection delegate;
   private final Object creator;
   private final ProxyFactory proxyFactory;
   private final Map proxyCache;
   private static Object[] zeroLengthObjectArray = new Object[0];
   private static Method methodObject403;
   private static Method methodObject348;
   private static Method methodObject466;
   private static Method methodObject470;
   private static Method methodObject549;
   private static Method methodObject458;
   private static Method methodObject606;
   private static Method methodObject373;
   private static Method methodObject434;
   private static Method methodObject394;
   private static Method methodObject464;
   private static Method methodObject402;
   private static Method methodObject607;
   private static Method methodObject444;
   private static Method methodObject425;
   private static Method methodObject561;
   private static Method methodObject416;
   private static Method methodObject399;
   private static Method methodObject539;
   private static Method methodObject520;
   private static Method methodObject594;
   private static Method methodObject476;
   private static Method methodObject340;
   private static Method methodObject432;
   private static Method methodObject609;
   private static Method methodObject320;
   private static Method methodObject317;
   private static Method methodObject582;
   private static Method methodObject400;
   private static Method methodObject563;
   private static Method methodObject447;
   private static Method methodObject611;
   private static Method methodObject299;
   private static Method methodObject445;
   private static Method methodObject546;
   private static Method methodObject316;
   private static Method methodObject542;
   private static Method methodObject489;
   private static Method methodObject378;
   private static Method methodObject452;
   private static Method methodObject512;
   private static Method methodObject478;
   private static Method methodObject501;
   private static Method methodObject300;
   private static Method methodObject302;
   private static Method methodObject474;
   private static Method methodObject589;
   private static Method methodObject612;
   private static Method methodObject283;
   private static Method methodObject305;
   private static Method methodObject439;
   private static Method methodObject511;
   private static Method methodObject479;
   private static Method methodObject495;
   private static Method methodObject304;
   private static Method methodObject297;
   private static Method methodObject613;
   private static Method methodObject352;
   private static Method methodObject581;
   private static Method methodObject541;
   private static Method methodObject560;
   private static Method methodObject446;
   private static Method methodObject585;
   private static Method methodObject329;
   private static Method methodObject307;
   private static Method methodObject583;
   private static Method methodObject604;
   private static Method methodObject468;
   private static Method methodObject534;
   private static Method methodObject591;
   private static Method methodObject361;
   private static Method methodObject596;
   private static Method methodObject485;
   private static Method methodObject281;
   private static Method methodObject397;
   private static Method methodObject380;
   private static Method methodObject342;
   private static Method methodObject456;
   private static Method methodObject398;
   private static Method methodObject371;
   private static Method methodObject536;
   private static Method methodObject593;
   private static Method methodObject454;
   private static Method methodObject610;
   private static Method methodObject502;
   private static Method methodObject436;
   private static Method methodObject431;
   private static Method methodObject487;
   private static Method methodObject493;
   private static Method methodObject366;
   private static Method methodObject442;
   private static Method methodObject401;
   private static Method methodObject415;
   private static Method methodObject374;
   private static Method methodObject525;
   private static Method methodObject457;
   private static Method methodObject461;
   private static Method methodObject448;
   private static Method methodObject460;
   private static Method methodObject418;
   private static Method methodObject294;
   private static Method methodObject363;
   private static Method methodObject518;
   private static Method methodObject377;
   private static Method methodObject379;
   private static Method methodObject337;
   private static Method methodObject602;
   private static Method methodObject523;
   private static Method methodObject450;
   private static Method methodObject503;
   private static Method methodObject412;
   private static Method methodObject513;
   private static Method methodObject396;
   private static Method methodObject453;
   private static Method methodObject296;
   private static Method methodObject443;
   private static Method methodObject393;
   private static Method methodObject551;
   private static Method methodObject592;
   private static Method methodObject558;
   private static Method methodObject572;
   private static Method methodObject500;
   private static Method methodObject526;
   private static Method methodObject369;
   private static Method methodObject303;
   private static Method methodObject576;
   private static Method methodObject605;
   private static Method methodObject477;
   private static Method methodObject306;
   private static Method methodObject482;
   private static Method methodObject471;
   private static Method methodObject566;
   private static Method methodObject282;
   private static Method methodObject517;
   private static Method methodObject496;
   private static Method methodObject515;
   private static Method methodObject334;
   private static Method methodObject514;
   private static Method methodObject492;
   private static Method methodObject385;
   private static Method methodObject360;
   private static Method methodObject406;
   private static Method methodObject529;
   private static Method methodObject553;
   private static Method methodObject358;
   private static Method methodObject455;
   private static Method methodObject510;
   private static Method methodObject284;
   private static Method methodObject524;
   private static Method methodObject346;
   private static Method methodObject408;
   private static Method methodObject285;
   private static Method methodObject419;
   private static Method methodObject428;
   private static Method methodObject519;
   private static Method methodObject367;
   private static Method methodObject543;
   private static Method methodObject494;
   private static Method methodObject327;
   private static Method methodObject550;
   private static Method methodObject315;
   private static Method methodObject325;
   private static Method methodObject382;
   private static Method methodObject388;
   private static Method methodObject497;
   private static Method methodObject321;
   private static Method methodObject574;
   private static Method methodObject557;
   private static Method methodObject410;
   private static Method methodObject368;
   private static Method methodObject407;
   private static Method methodObject433;
   private static Method methodObject441;
   private static Method methodObject490;
   private static Method methodObject339;
   private static Method methodObject598;
   private static Method methodObject440;
   private static Method methodObject309;
   private static Method methodObject584;
   private static Method methodObject333;
   private static Method methodObject372;
   private static Method methodObject341;
   private static Method methodObject437;
   private static Method methodObject356;
   private static Method methodObject540;
   private static Method methodObject469;
   private static Method methodObject491;
   private static Method methodObject577;
   private static Method methodObject484;
   private static Method methodObject483;
   private static Method methodObject323;
   private static Method methodObject586;
   private static Method methodObject376;
   private static Method methodObject404;
   private static Method methodObject336;
   private static Method methodObject554;
   private static Method methodObject314;
   private static Method methodObject590;
   private static Method methodObject509;
   private static Method methodObject535;
   private static Method methodObject311;
   private static Method methodObject599;
   private static Method methodObject521;
   private static Method methodObject391;
   private static Method methodObject530;
   private static Method methodObject411;
   private static Method methodObject537;
   private static Method methodObject531;
   private static Method methodObject384;
   private static Method methodObject330;
   private static Method methodObject430;
   private static Method methodObject481;
   private static Method methodObject343;
   private static Method methodObject507;
   private static Method methodObject499;
   private static Method methodObject506;
   private static Method methodObject426;
   private static Method methodObject293;
   private static Method methodObject601;
   private static Method methodObject556;
   private static Method methodObject351;
   private static Method methodObject295;
   private static Method methodObject355;
   private static Method methodObject345;
   private static Method methodObject347;
   private static Method methodObject424;
   private static Method methodObject423;
   private static Method methodObject564;
   private static Method methodObject375;
   private static Method methodObject427;
   private static Method methodObject395;
   private static Method methodObject389;
   private static Method methodObject318;
   private static Method methodObject545;
   private static Method methodObject504;
   private static Method methodObject603;
   private static Method methodObject326;
   private static Method methodObject280;
   private static Method methodObject414;
   private static Method methodObject516;
   private static Method methodObject429;
   private static Method methodObject420;
   private static Method methodObject292;
   private static Method methodObject435;
   private static Method methodObject538;
   private static Method methodObject357;
   private static Method methodObject580;
   private static Method methodObject595;
   private static Method methodObject353;
   private static Method methodObject364;
   private static Method methodObject608;
   private static Method methodObject289;
   private static Method methodObject383;
   private static Method methodObject505;
   private static Method methodObject354;
   private static Method methodObject291;
   private static Method methodObject565;
   private static Method methodObject475;
   private static Method methodObject559;
   private static Method methodObject562;
   private static Method methodObject308;
   private static Method methodObject467;
   private static Method methodObject290;
   private static Method methodObject381;
   private static Method methodObject449;
   private static Method methodObject527;
   private static Method methodObject578;
   private static Method methodObject597;
   private static Method methodObject508;
   private static Method methodObject417;
   private static Method methodObject349;
   private static Method methodObject463;
   private static Method methodObject547;
   private static Method methodObject312;
   private static Method methodObject533;
   private static Method methodObject365;
   private static Method methodObject301;
   private static Method methodObject392;
   private static Method methodObject588;
   private static Method methodObject486;
   private static Method methodObject319;
   private static Method methodObject421;
   private static Method methodObject528;
   private static Method methodObject409;
   private static Method methodObject413;
   private static Method methodObject344;
   private static Method methodObject587;
   private static Method methodObject387;
   private static Method methodObject570;
   private static Method methodObject287;
   private static Method methodObject522;
   private static Method methodObject544;
   private static Method methodObject459;
   private static Method methodObject569;
   private static Method methodObject451;
   private static Method methodObject438;
   private static Method methodObject552;
   private static Method methodObject488;
   private static Method methodObject480;
   private static Method methodObject313;
   private static Method methodObject405;
   private static Method methodObject359;
   private static Method methodObject600;
   private static Method methodObject555;
   private static Method methodObject422;
   private static Method methodObject335;
   private static Method methodObject331;
   private static Method methodObject362;
   private static Method methodObject575;
   private static Method methodObject579;
   private static Method methodObject571;
   private static Method methodObject328;
   private static Method methodObject288;
   private static Method methodObject322;
   private static Method methodObject462;
   private static Method methodObject310;
   private static Method methodObject286;
   private static Method methodObject614;
   private static Method methodObject573;
   private static Method methodObject532;
   private static Method methodObject332;
   private static Method methodObject324;
   private static Method methodObject390;
   private static Method methodObject338;
   private static Method methodObject298;
   private static Method methodObject472;
   private static Method methodObject473;
   private static Method methodObject568;
   private static Method methodObject548;
   private static Method methodObject370;
   private static Method methodObject498;
   private static Method methodObject465;
   private static Method methodObject567;
   private static Method methodObject386;
   private static Method methodObject350;

   public Map registerJMSNotification(String[] arg0, Map arg1) throws SQLException {
      try {
         super.preForAll(methodObject403, this, arg0, arg1);
         return (Map)this.postForAll(methodObject403, (Object)this.delegate.registerJMSNotification(arg0, arg1));
      } catch (SQLException var4) {
         return (Map)this.postForAll(methodObject403, this.onErrorForAll(methodObject403, var4));
      }
   }

   public OracleConnectionCacheCallback getConnectionCacheCallbackObj() throws SQLException {
      try {
         super.preForAll(methodObject348, this, zeroLengthObjectArray);
         return (OracleConnectionCacheCallback)this.postForAll(methodObject348, (Object)this.delegate.getConnectionCacheCallbackObj());
      } catch (SQLException var2) {
         return (OracleConnectionCacheCallback)this.postForAll(methodObject348, this.onErrorForAll(methodObject348, var2));
      }
   }

   public void startup(String arg0, int arg1) throws SQLException {
      try {
         super.preForAll(methodObject466, this, arg0, arg1);
         Method var10001 = methodObject466;
         this.delegate.startup(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject466, var4);
      }
   }

   public void setCreateStatementAsRefCursor(boolean arg0) {
      super.preForAll(methodObject470, this, arg0);
      Method var10001 = methodObject470;
      this.delegate.setCreateStatementAsRefCursor(arg0);
      this.postForAll(var10001);
   }

   public void setDefaultTimeZone(TimeZone arg0) throws SQLException {
      try {
         super.preForAll(methodObject549, this, arg0);
         Method var10001 = methodObject549;
         this.delegate.setDefaultTimeZone(arg0);
         this.postForAll(var10001);
      } catch (SQLException var3) {
         this.onErrorVoidForAll(methodObject549, var3);
      }
   }

   public void setExplicitCachingEnabled(boolean arg0) throws SQLException {
      try {
         super.preForAll(methodObject458, this, arg0);
         Method var10001 = methodObject458;
         this.delegate.setExplicitCachingEnabled(arg0);
         this.postForAll(var10001);
      } catch (SQLException var3) {
         this.onErrorVoidForAll(methodObject458, var3);
      }
   }

   public void setNetworkTimeout(Executor arg0, int arg1) throws SQLException {
      try {
         super.preForAll(methodObject606, this, arg0, arg1);
         Method var10001 = methodObject606;
         this.delegate.setNetworkTimeout(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject606, var4);
      }
   }

   public void setUsable(boolean arg0) {
      super.preForAll(methodObject373, this, arg0);
      Method var10001 = methodObject373;
      this.delegate.setUsable(arg0);
      this.postForAll(var10001);
   }

   public String getSQLType(Object arg0) throws SQLException {
      try {
         super.preForAll(methodObject434, this, arg0);
         return (String)this.postForAll(methodObject434, (Object)this.delegate.getSQLType(arg0 instanceof _Proxy_ ? (Object)((_Proxy_)arg0)._getDelegate_() : arg0));
      } catch (SQLException var3) {
         return (String)this.postForAll(methodObject434, this.onErrorForAll(methodObject434, var3));
      }
   }

   public ReplayContext getLastReplayContext() throws SQLException {
      try {
         super.preForAll(methodObject394, this, zeroLengthObjectArray);
         return (ReplayContext)this.postForAll(methodObject394, (Object)this.delegate.getLastReplayContext());
      } catch (SQLException var2) {
         return (ReplayContext)this.postForAll(methodObject394, this.onErrorForAll(methodObject394, var2));
      }
   }

   public void setUsingXAFlag(boolean arg0) {
      super.preForAll(methodObject464, this, arg0);
      Method var10001 = methodObject464;
      this.delegate.setUsingXAFlag(arg0);
      this.postForAll(var10001);
   }

   public JMSMessage jmsDequeue(String arg0, JMSDequeueOptions arg1, String arg2) throws SQLException {
      try {
         super.preForAll(methodObject402, this, arg0, arg1, arg2);
         return (JMSMessage)this.postForAll(methodObject402, (Object)this.delegate.jmsDequeue(arg0, arg1, arg2));
      } catch (SQLException var5) {
         return (JMSMessage)this.postForAll(methodObject402, this.onErrorForAll(methodObject402, var5));
      }
   }

   public Savepoint setSavepoint() throws SQLException {
      try {
         super.preForAll(methodObject607, this, zeroLengthObjectArray);
         return (Savepoint)this.postForAll(methodObject607, this.proxyFactory.proxyForCache((Object)this.delegate.setSavepoint(), this, this.proxyCache, methodObject607));
      } catch (SQLException var2) {
         return (Savepoint)this.postForAll(methodObject607, this.onErrorForAll(methodObject607, var2));
      }
   }

   public void registerSQLType(String arg0, String arg1) throws SQLException {
      try {
         super.preForAll(methodObject444, this, arg0, arg1);
         Method var10001 = methodObject444;
         this.delegate.registerSQLType(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject444, var4);
      }
   }

   public boolean getAutoClose() throws SQLException {
      try {
         super.preForAll(methodObject425, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject425, this.delegate.getAutoClose());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject425, this.onErrorForAll(methodObject425, var2));
      }
   }

   public void setReadOnly(boolean arg0) throws SQLException {
      try {
         super.preForAll(methodObject561, this, arg0);
         Method var10001 = methodObject561;
         this.delegate.setReadOnly(arg0);
         this.postForAll(var10001);
      } catch (SQLException var3) {
         this.onErrorVoidForAll(methodObject561, var3);
      }
   }

   public oracle.jdbc.OracleConnection unwrap() {
      super.preForAll(methodObject416, this, zeroLengthObjectArray);
      return (oracle.jdbc.OracleConnection)this.postForAll(methodObject416, this.proxyFactory.proxyForCache((Object)this.delegate.unwrap(), this, this.proxyCache, methodObject416));
   }

   public String getExecutingRPCSQL() {
      super.preForAll(methodObject399, this, zeroLengthObjectArray);
      return (String)this.postForAll(methodObject399, (Object)this.delegate.getExecutingRPCSQL());
   }

   public TIMESTAMPLTZ createTIMESTAMPLTZ(Timestamp arg0, Calendar arg1) throws SQLException {
      try {
         super.preForAll(methodObject539, this, arg0, arg1);
         return (TIMESTAMPLTZ)this.postForAll(methodObject539, (Object)this.delegate.createTIMESTAMPLTZ(arg0, arg1));
      } catch (SQLException var4) {
         return (TIMESTAMPLTZ)this.postForAll(methodObject539, this.onErrorForAll(methodObject539, var4));
      }
   }

   public NUMBER createNUMBER(BigDecimal arg0) throws SQLException {
      try {
         super.preForAll(methodObject520, this, arg0);
         return (NUMBER)this.postForAll(methodObject520, (Object)this.delegate.createNUMBER(arg0));
      } catch (SQLException var3) {
         return (NUMBER)this.postForAll(methodObject520, this.onErrorForAll(methodObject520, var3));
      }
   }

   public int getTransactionIsolation() throws SQLException {
      try {
         super.preForAll(methodObject594, this, zeroLengthObjectArray);
         return (Integer)this.postForAll(methodObject594, this.delegate.getTransactionIsolation());
      } catch (SQLException var2) {
         return (Integer)this.postForAll(methodObject594, this.onErrorForAll(methodObject594, var2));
      }
   }

   public boolean isLogicalConnection() {
      super.preForAll(methodObject476, this, zeroLengthObjectArray);
      return (Boolean)this.postForAll(methodObject476, this.delegate.isLogicalConnection());
   }

   public void setTxnMode(int arg0) {
      super.preForAll(methodObject340, this, arg0);
      Method var10001 = methodObject340;
      this.delegate.setTxnMode(arg0);
      this.postForAll(var10001);
   }

   public Object getJavaObject(String arg0) throws SQLException {
      try {
         super.preForAll(methodObject432, this, arg0);
         return this.postForAll(methodObject432, this.proxyFactory.proxyForCache(this.delegate.getJavaObject(arg0), this, this.proxyCache, methodObject432));
      } catch (SQLException var3) {
         return this.postForAll(methodObject432, this.onErrorForAll(methodObject432, var3));
      }
   }

   public void setSchema(String arg0) throws SQLException {
      try {
         super.preForAll(methodObject609, this, arg0);
         Method var10001 = methodObject609;
         this.delegate.setSchema(arg0);
         this.postForAll(var10001);
      } catch (SQLException var3) {
         this.onErrorVoidForAll(methodObject609, var3);
      }
   }

   public void getForm(OracleTypeADT arg0, OracleTypeCLOB arg1, int arg2) throws SQLException {
      try {
         super.preForAll(methodObject320, this, arg0, arg1, arg2);
         Method var10001 = methodObject320;
         this.delegate.getForm(arg0, arg1, arg2);
         this.postForAll(var10001);
      } catch (SQLException var5) {
         this.onErrorVoidForAll(methodObject320, var5);
      }
   }

   public ResultSet newArrayDataResultSet(ARRAY arg0, long arg1, int arg2, Map arg3) throws SQLException {
      try {
         super.preForAll(methodObject317, this, arg0, arg1, arg2, arg3);
         return (ResultSet)this.postForAll(methodObject317, this.proxyFactory.proxyForCache((Object)this.delegate.newArrayDataResultSet(arg0, arg1, arg2, arg3), this, this.proxyCache, methodObject317));
      } catch (SQLException var7) {
         return (ResultSet)this.postForAll(methodObject317, this.onErrorForAll(methodObject317, var7));
      }
   }

   public SQLXML createSQLXML() throws SQLException {
      try {
         super.preForAll(methodObject582, this, zeroLengthObjectArray);
         return (SQLXML)this.postForAll(methodObject582, this.proxyFactory.proxyForCache((Object)this.delegate.createSQLXML(), this, this.proxyCache, methodObject582));
      } catch (SQLException var2) {
         return (SQLXML)this.postForAll(methodObject582, this.onErrorForAll(methodObject582, var2));
      }
   }

   public void jmsEnqueue(String arg0, JMSEnqueueOptions arg1, JMSMessage arg2, AQMessageProperties arg3) throws SQLException {
      try {
         super.preForAll(methodObject400, this, arg0, arg1, arg2, arg3);
         Method var10001 = methodObject400;
         this.delegate.jmsEnqueue(arg0, arg1, arg2, arg3);
         this.postForAll(var10001);
      } catch (SQLException var6) {
         this.onErrorVoidForAll(methodObject400, var6);
      }
   }

   public boolean isValid(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject563, this, arg0);
         return (Boolean)this.postForAll(methodObject563, this.delegate.isValid(arg0));
      } catch (SQLException var3) {
         return (Boolean)this.postForAll(methodObject563, this.onErrorForAll(methodObject563, var3));
      }
   }

   public void setDefaultRowPrefetch(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject447, this, arg0);
         Method var10001 = methodObject447;
         this.delegate.setDefaultRowPrefetch(arg0);
         this.postForAll(var10001);
      } catch (SQLException var3) {
         this.onErrorVoidForAll(methodObject447, var3);
      }
   }

   public Object unwrap(Class arg0) throws SQLException {
      try {
         super.preForAll(methodObject611, this, arg0);
         return this.postForAll(methodObject611, this.proxyFactory.proxyForCache(this.delegate.unwrap(arg0), this, this.proxyCache, methodObject611));
      } catch (SQLException var3) {
         return this.postForAll(methodObject611, this.onErrorForAll(methodObject611, var3));
      }
   }

   public void setFDO(byte[] arg0) throws SQLException {
      try {
         super.preForAll(methodObject299, this, arg0);
         Method var10001 = methodObject299;
         this.delegate.setFDO(arg0);
         this.postForAll(var10001);
      } catch (SQLException var3) {
         this.onErrorVoidForAll(methodObject299, var3);
      }
   }

   public void setAutoClose(boolean arg0) throws SQLException {
      try {
         super.preForAll(methodObject445, this, arg0);
         Method var10001 = methodObject445;
         this.delegate.setAutoClose(arg0);
         this.postForAll(var10001);
      } catch (SQLException var3) {
         this.onErrorVoidForAll(methodObject445, var3);
      }
   }

   public String getEncryptionAlgorithmName() throws SQLException {
      try {
         super.preForAll(methodObject546, this, zeroLengthObjectArray);
         return (String)this.postForAll(methodObject546, (Object)this.delegate.getEncryptionAlgorithmName());
      } catch (SQLException var2) {
         return (String)this.postForAll(methodObject546, this.onErrorForAll(methodObject546, var2));
      }
   }

   public ResultSet newArrayDataResultSet(Datum[] arg0, long arg1, int arg2, Map arg3) throws SQLException {
      try {
         super.preForAll(methodObject316, this, arg0, arg1, arg2, arg3);
         return (ResultSet)this.postForAll(methodObject316, this.proxyFactory.proxyForCache((Object)this.delegate.newArrayDataResultSet(arg0, arg1, arg2, arg3), this, this.proxyCache, methodObject316));
      } catch (SQLException var7) {
         return (ResultSet)this.postForAll(methodObject316, this.onErrorForAll(methodObject316, var7));
      }
   }

   public TypeDescriptor[] getAllTypeDescriptorsInCurrentSchema() throws SQLException {
      try {
         super.preForAll(methodObject542, this, zeroLengthObjectArray);
         return (TypeDescriptor[])this.postForAll(methodObject542, (Object)this.delegate.getAllTypeDescriptorsInCurrentSchema());
      } catch (SQLException var2) {
         return (TypeDescriptor[])this.postForAll(methodObject542, this.onErrorForAll(methodObject542, var2));
      }
   }

   public void setConnectionReleasePriority(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject489, this, arg0);
         Method var10001 = methodObject489;
         this.delegate.setConnectionReleasePriority(arg0);
         this.postForAll(var10001);
      } catch (SQLException var3) {
         this.onErrorVoidForAll(methodObject489, var3);
      }
   }

   public int getTimezoneVersionNumber() throws SQLException {
      try {
         super.preForAll(methodObject378, this, zeroLengthObjectArray);
         return (Integer)this.postForAll(methodObject378, this.delegate.getTimezoneVersionNumber());
      } catch (SQLException var2) {
         return (Integer)this.postForAll(methodObject378, this.onErrorForAll(methodObject378, var2));
      }
   }

   public void setStmtCacheSize(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject452, this, arg0);
         Method var10001 = methodObject452;
         this.delegate.setStmtCacheSize(arg0);
         this.postForAll(var10001);
      } catch (SQLException var3) {
         this.onErrorVoidForAll(methodObject452, var3);
      }
   }

   public INTERVALYM createINTERVALYM(String arg0) throws SQLException {
      try {
         super.preForAll(methodObject512, this, arg0);
         return (INTERVALYM)this.postForAll(methodObject512, (Object)this.delegate.createINTERVALYM(arg0));
      } catch (SQLException var3) {
         return (INTERVALYM)this.postForAll(methodObject512, this.onErrorForAll(methodObject512, var3));
      }
   }

   public void setWrapper(oracle.jdbc.OracleConnection arg0) {
      super.preForAll(methodObject478, this, arg0);
      Method var10001 = methodObject478;
      this.delegate.setWrapper(arg0 instanceof _Proxy_ ? (oracle.jdbc.OracleConnection)((_Proxy_)arg0)._getDelegate_() : arg0);
      this.postForAll(var10001);
   }

   public void unregisterDatabaseChangeNotification(long arg0, String arg1) throws SQLException {
      try {
         super.preForAll(methodObject501, this, arg0, arg1);
         Method var10001 = methodObject501;
         this.delegate.unregisterDatabaseChangeNotification(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var5) {
         this.onErrorVoidForAll(methodObject501, var5);
      }
   }

   public byte[] getFDO(boolean arg0) throws SQLException {
      try {
         super.preForAll(methodObject300, this, arg0);
         return (byte[])this.postForAll(methodObject300, (Object)this.delegate.getFDO(arg0));
      } catch (SQLException var3) {
         return (byte[])this.postForAll(methodObject300, this.onErrorForAll(methodObject300, var3));
      }
   }

   public void putDescriptor(byte[] arg0, Object arg1) throws SQLException {
      try {
         super.preForAll(methodObject302, this, arg0, arg1);
         Method var10001 = methodObject302;
         this.delegate.putDescriptor(arg0, arg1 instanceof _Proxy_ ? (Object)((_Proxy_)arg1)._getDelegate_() : arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject302, var4);
      }
   }

   public String getSessionTimeZoneOffset() throws SQLException {
      try {
         super.preForAll(methodObject474, this, zeroLengthObjectArray);
         return (String)this.postForAll(methodObject474, (Object)this.delegate.getSessionTimeZoneOffset());
      } catch (SQLException var2) {
         return (String)this.postForAll(methodObject474, this.onErrorForAll(methodObject474, var2));
      }
   }

   public Properties getClientInfo() throws SQLException {
      try {
         super.preForAll(methodObject589, this, zeroLengthObjectArray);
         return (Properties)this.postForAll(methodObject589, (Object)this.delegate.getClientInfo());
      } catch (SQLException var2) {
         return (Properties)this.postForAll(methodObject589, this.onErrorForAll(methodObject589, var2));
      }
   }

   public boolean isWrapperFor(Class arg0) throws SQLException {
      try {
         super.preForAll(methodObject612, this, arg0);
         return (Boolean)this.postForAll(methodObject612, this.delegate.isWrapperFor(arg0));
      } catch (SQLException var3) {
         return (Boolean)this.postForAll(methodObject612, this.onErrorForAll(methodObject612, var3));
      }
   }

   public short getStructAttrNCsId() throws SQLException {
      try {
         super.preForAll(methodObject283, this, zeroLengthObjectArray);
         return (Short)this.postForAll(methodObject283, this.delegate.getStructAttrNCsId());
      } catch (SQLException var2) {
         return (Short)this.postForAll(methodObject283, this.onErrorForAll(methodObject283, var2));
      }
   }

   public void removeAllDescriptor() {
      super.preForAll(methodObject305, this, zeroLengthObjectArray);
      Method var10001 = methodObject305;
      this.delegate.removeAllDescriptor();
      this.postForAll(var10001);
   }

   public boolean getUsingXAFlag() {
      super.preForAll(methodObject439, this, zeroLengthObjectArray);
      return (Boolean)this.postForAll(methodObject439, this.delegate.getUsingXAFlag());
   }

   public INTERVALDS createINTERVALDS(String arg0) throws SQLException {
      try {
         super.preForAll(methodObject511, this, arg0);
         return (INTERVALDS)this.postForAll(methodObject511, (Object)this.delegate.createINTERVALDS(arg0));
      } catch (SQLException var3) {
         return (INTERVALDS)this.postForAll(methodObject511, this.onErrorForAll(methodObject511, var3));
      }
   }

   public OracleConnection physicalConnectionWithin() {
      super.preForAll(methodObject479, this, zeroLengthObjectArray);
      return (OracleConnection)this.postForAll(methodObject479, this.proxyFactory.proxyForCache((Object)this.delegate.physicalConnectionWithin(), this, this.proxyCache, methodObject479));
   }

   public AQMessage dequeue(String arg0, AQDequeueOptions arg1, String arg2) throws SQLException {
      try {
         super.preForAll(methodObject495, this, arg0, arg1, arg2);
         return (AQMessage)this.postForAll(methodObject495, (Object)this.delegate.dequeue(arg0, arg1, arg2));
      } catch (SQLException var5) {
         return (AQMessage)this.postForAll(methodObject495, this.onErrorForAll(methodObject495, var5));
      }
   }

   public void removeDescriptor(String arg0) {
      super.preForAll(methodObject304, this, arg0);
      Method var10001 = methodObject304;
      this.delegate.removeDescriptor(arg0);
      this.postForAll(var10001);
   }

   public oracle.jdbc.OracleConnection getWrapper() {
      super.preForAll(methodObject297, this, zeroLengthObjectArray);
      return (oracle.jdbc.OracleConnection)this.postForAll(methodObject297, this.proxyFactory.proxyForCache((Object)this.delegate.getWrapper(), this, this.proxyCache, methodObject297));
   }

   public void setACProxy(Object arg0) {
      super.preForAll(methodObject613, this, arg0);
      Method var10001 = methodObject613;
      this.delegate.setACProxy(arg0 instanceof _Proxy_ ? (Object)((_Proxy_)arg0)._getDelegate_() : arg0);
      this.postForAll(var10001);
   }

   public CLOB createClob(byte[] arg0) throws SQLException {
      try {
         super.preForAll(methodObject352, this, arg0);
         return (CLOB)this.postForAll(methodObject352, (Object)this.delegate.createClob(arg0));
      } catch (SQLException var3) {
         return (CLOB)this.postForAll(methodObject352, this.onErrorForAll(methodObject352, var3));
      }
   }

   public void clearWarnings() throws SQLException {
      try {
         super.preForAll(methodObject581, this, zeroLengthObjectArray);
         Method var10001 = methodObject581;
         this.delegate.clearWarnings();
         this.postForAll(var10001);
      } catch (SQLException var2) {
         this.onErrorVoidForAll(methodObject581, var2);
      }
   }

   public TIMESTAMPLTZ createTIMESTAMPLTZ(DATE arg0, Calendar arg1) throws SQLException {
      try {
         super.preForAll(methodObject541, this, arg0, arg1);
         return (TIMESTAMPLTZ)this.postForAll(methodObject541, (Object)this.delegate.createTIMESTAMPLTZ(arg0, arg1));
      } catch (SQLException var4) {
         return (TIMESTAMPLTZ)this.postForAll(methodObject541, this.onErrorForAll(methodObject541, var4));
      }
   }

   public boolean needToPurgeStatementCache() throws SQLException {
      try {
         super.preForAll(methodObject560, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject560, this.delegate.needToPurgeStatementCache());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject560, this.onErrorForAll(methodObject560, var2));
      }
   }

   public void setDefaultExecuteBatch(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject446, this, arg0);
         Method var10001 = methodObject446;
         this.delegate.setDefaultExecuteBatch(arg0);
         this.postForAll(var10001);
      } catch (SQLException var3) {
         this.onErrorVoidForAll(methodObject446, var3);
      }
   }

   public Statement createStatement(int arg0, int arg1, int arg2) throws SQLException {
      try {
         super.preForAll(methodObject585, this, arg0, arg1, arg2);
         return (Statement)this.postForAll(methodObject585, this.proxyFactory.proxyForCache((Object)this.delegate.createStatement(arg0, arg1, arg2), this, this.proxyCache, methodObject585));
      } catch (SQLException var5) {
         return (Statement)this.postForAll(methodObject585, this.onErrorForAll(methodObject585, var5));
      }
   }

   public int getMaxNCharbyteSize() {
      super.preForAll(methodObject329, this, zeroLengthObjectArray);
      return (Integer)this.postForAll(methodObject329, this.delegate.getMaxNCharbyteSize());
   }

   public Enumeration descriptorCacheKeys() {
      super.preForAll(methodObject307, this, zeroLengthObjectArray);
      return (Enumeration)this.postForAll(methodObject307, (Object)this.delegate.descriptorCacheKeys());
   }

   public Statement createStatement() throws SQLException {
      try {
         super.preForAll(methodObject583, this, zeroLengthObjectArray);
         return (Statement)this.postForAll(methodObject583, this.proxyFactory.proxyForCache((Object)this.delegate.createStatement(), this, this.proxyCache, methodObject583));
      } catch (SQLException var2) {
         return (Statement)this.postForAll(methodObject583, this.onErrorForAll(methodObject583, var2));
      }
   }

   public void setClientInfo(Properties arg0) throws SQLClientInfoException {
      super.preForAll(methodObject604, this, arg0);
      Method var10001 = methodObject604;
      this.delegate.setClientInfo(arg0);
      this.postForAll(var10001);
   }

   public PreparedStatement prepareStatementWithKey(String arg0) throws SQLException {
      try {
         super.preForAll(methodObject468, this, arg0);
         return (PreparedStatement)this.postForAll(methodObject468, this.proxyFactory.proxyForCache((Object)this.delegate.prepareStatementWithKey(arg0), this, this.proxyCache, methodObject468));
      } catch (SQLException var3) {
         return (PreparedStatement)this.postForAll(methodObject468, this.onErrorForAll(methodObject468, var3));
      }
   }

   public TIMESTAMPTZ createTIMESTAMPTZ(String arg0) throws SQLException {
      try {
         super.preForAll(methodObject534, this, arg0);
         return (TIMESTAMPTZ)this.postForAll(methodObject534, (Object)this.delegate.createTIMESTAMPTZ(arg0));
      } catch (SQLException var3) {
         return (TIMESTAMPTZ)this.postForAll(methodObject534, this.onErrorForAll(methodObject534, var3));
      }
   }

   public DatabaseMetaData getMetaData() throws SQLException {
      try {
         super.preForAll(methodObject591, this, zeroLengthObjectArray);
         return (DatabaseMetaData)this.postForAll(methodObject591, this.proxyFactory.proxyForCache((Object)this.delegate.getMetaData(), this, this.proxyCache, methodObject591));
      } catch (SQLException var2) {
         return (DatabaseMetaData)this.postForAll(methodObject591, this.onErrorForAll(methodObject591, var2));
      }
   }

   public boolean isV8Compatible() throws SQLException {
      try {
         super.preForAll(methodObject361, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject361, this.delegate.isV8Compatible());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject361, this.onErrorForAll(methodObject361, var2));
      }
   }

   public boolean isClosed() throws SQLException {
      try {
         super.preForAll(methodObject596, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject596, this.delegate.isClosed());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject596, this.onErrorForAll(methodObject596, var2));
      }
   }

   public void applyConnectionAttributes(Properties arg0) throws SQLException {
      try {
         super.preForAll(methodObject485, this, arg0);
         Method var10001 = methodObject485;
         this.delegate.applyConnectionAttributes(arg0);
         this.postForAll(var10001);
      } catch (SQLException var3) {
         this.onErrorVoidForAll(methodObject485, var3);
      }
   }

   public String getURL() throws SQLException {
      try {
         super.preForAll(methodObject281, this, zeroLengthObjectArray);
         return (String)this.postForAll(methodObject281, (Object)this.delegate.getURL());
      } catch (SQLException var2) {
         return (String)this.postForAll(methodObject281, this.onErrorForAll(methodObject281, var2));
      }
   }

   public byte[] getDerivedKeyInternal(byte[] arg0, int arg1) throws NoSuchAlgorithmException, InvalidKeySpecException, SQLException {
      try {
         super.preForAll(methodObject397, this, arg0, arg1);
         return (byte[])this.postForAll(methodObject397, (Object)this.delegate.getDerivedKeyInternal(arg0, arg1));
      } catch (SQLException var4) {
         return (byte[])this.postForAll(methodObject397, this.onErrorForAll(methodObject397, var4));
      }
   }

   public TIMEZONETAB getTIMEZONETAB() throws SQLException {
      try {
         super.preForAll(methodObject380, this, zeroLengthObjectArray);
         return (TIMEZONETAB)this.postForAll(methodObject380, (Object)this.delegate.getTIMEZONETAB());
      } catch (SQLException var2) {
         return (TIMEZONETAB)this.postForAll(methodObject380, this.onErrorForAll(methodObject380, var2));
      }
   }

   public int getHeapAllocSize() throws SQLException {
      try {
         super.preForAll(methodObject342, this, zeroLengthObjectArray);
         return (Integer)this.postForAll(methodObject342, this.delegate.getHeapAllocSize());
      } catch (SQLException var2) {
         return (Integer)this.postForAll(methodObject342, this.onErrorForAll(methodObject342, var2));
      }
   }

   public void setImplicitCachingEnabled(boolean arg0) throws SQLException {
      try {
         super.preForAll(methodObject456, this, arg0);
         Method var10001 = methodObject456;
         this.delegate.setImplicitCachingEnabled(arg0);
         this.postForAll(var10001);
      } catch (SQLException var3) {
         this.onErrorVoidForAll(methodObject456, var3);
      }
   }

   public short getExecutingRPCFunctionCode() {
      super.preForAll(methodObject398, this, zeroLengthObjectArray);
      return (Short)this.postForAll(methodObject398, this.delegate.getExecutingRPCFunctionCode());
   }

   public void doXSSessionChangeOp(OracleConnection.XSSessionSetOperationCode arg0, byte[] arg1, XSSecureId arg2, XSSessionParameters arg3) throws SQLException {
      try {
         super.preForAll(methodObject371, this, arg0, arg1, arg2, arg3);
         Method var10001 = methodObject371;
         this.delegate.doXSSessionChangeOp(arg0, arg1, arg2, arg3);
         this.postForAll(var10001);
      } catch (SQLException var6) {
         this.onErrorVoidForAll(methodObject371, var6);
      }
   }

   public TIMESTAMPTZ createTIMESTAMPTZ(DATE arg0) throws SQLException {
      try {
         super.preForAll(methodObject536, this, arg0);
         return (TIMESTAMPTZ)this.postForAll(methodObject536, (Object)this.delegate.createTIMESTAMPTZ(arg0));
      } catch (SQLException var3) {
         return (TIMESTAMPTZ)this.postForAll(methodObject536, this.onErrorForAll(methodObject536, var3));
      }
   }

   public String getSchema() throws SQLException {
      try {
         super.preForAll(methodObject593, this, zeroLengthObjectArray);
         return (String)this.postForAll(methodObject593, (Object)this.delegate.getSchema());
      } catch (SQLException var2) {
         return (String)this.postForAll(methodObject593, this.onErrorForAll(methodObject593, var2));
      }
   }

   public void setStatementCacheSize(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject454, this, arg0);
         Method var10001 = methodObject454;
         this.delegate.setStatementCacheSize(arg0);
         this.postForAll(var10001);
      } catch (SQLException var3) {
         this.onErrorVoidForAll(methodObject454, var3);
      }
   }

   public void setTransactionIsolation(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject610, this, arg0);
         Method var10001 = methodObject610;
         this.delegate.setTransactionIsolation(arg0);
         this.postForAll(var10001);
      } catch (SQLException var3) {
         this.onErrorVoidForAll(methodObject610, var3);
      }
   }

   public BINARY_DOUBLE createBINARY_DOUBLE(double arg0) throws SQLException {
      try {
         super.preForAll(methodObject502, this, arg0);
         return (BINARY_DOUBLE)this.postForAll(methodObject502, (Object)this.delegate.createBINARY_DOUBLE(arg0));
      } catch (SQLException var4) {
         return (BINARY_DOUBLE)this.postForAll(methodObject502, this.onErrorForAll(methodObject502, var4));
      }
   }

   public short getStructAttrCsId() throws SQLException {
      try {
         super.preForAll(methodObject436, this, zeroLengthObjectArray);
         return (Short)this.postForAll(methodObject436, this.delegate.getStructAttrCsId());
      } catch (SQLException var2) {
         return (Short)this.postForAll(methodObject436, this.onErrorForAll(methodObject436, var2));
      }
   }

   public boolean getRestrictGetTables() {
      super.preForAll(methodObject431, this, zeroLengthObjectArray);
      return (Boolean)this.postForAll(methodObject431, this.delegate.getRestrictGetTables());
   }

   public Properties getUnMatchedConnectionAttributes() throws SQLException {
      try {
         super.preForAll(methodObject487, this, zeroLengthObjectArray);
         return (Properties)this.postForAll(methodObject487, (Object)this.delegate.getUnMatchedConnectionAttributes());
      } catch (SQLException var2) {
         return (Properties)this.postForAll(methodObject487, this.onErrorForAll(methodObject487, var2));
      }
   }

   public void unregisterAQNotification(AQNotificationRegistration arg0) throws SQLException {
      try {
         super.preForAll(methodObject493, this, arg0);
         Method var10001 = methodObject493;
         this.delegate.unregisterAQNotification(arg0);
         this.postForAll(var10001);
      } catch (SQLException var3) {
         this.onErrorVoidForAll(methodObject493, var3);
      }
   }

   public void doXSNamespaceOp(OracleConnection.XSOperationCode arg0, byte[] arg1, XSNamespace[] arg2, XSSecureId arg3) throws SQLException {
      try {
         super.preForAll(methodObject366, this, arg0, arg1, arg2, arg3);
         Method var10001 = methodObject366;
         this.delegate.doXSNamespaceOp(arg0, arg1, arg2, arg3);
         this.postForAll(var10001);
      } catch (SQLException var6) {
         this.onErrorVoidForAll(methodObject366, var6);
      }
   }

   public int pingDatabase(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject442, this, arg0);
         return (Integer)this.postForAll(methodObject442, this.delegate.pingDatabase(arg0));
      } catch (SQLException var3) {
         return (Integer)this.postForAll(methodObject442, this.onErrorForAll(methodObject442, var3));
      }
   }

   public JMSMessage jmsDequeue(String arg0, JMSDequeueOptions arg1) throws SQLException {
      try {
         super.preForAll(methodObject401, this, arg0, arg1);
         return (JMSMessage)this.postForAll(methodObject401, (Object)this.delegate.jmsDequeue(arg0, arg1));
      } catch (SQLException var4) {
         return (JMSMessage)this.postForAll(methodObject401, this.onErrorForAll(methodObject401, var4));
      }
   }

   public void close(int arg0) throws SQLException {
      try {
         super.preForClosure(methodObject415, this, arg0);
         Method var10001 = methodObject415;
         this.delegate.close(arg0);
         this.postForClosure(var10001);
      } catch (SQLException var3) {
         this.onErrorVoidForAll(methodObject415, var3);
      }
   }

   public Class getClassForType(String arg0, Map arg1) {
      super.preForAll(methodObject374, this, arg0, arg1);
      return (Class)this.postForAll(methodObject374, (Object)this.delegate.getClassForType(arg0, arg1));
   }

   public TIMESTAMP createTIMESTAMP(Time arg0) throws SQLException {
      try {
         super.preForAll(methodObject525, this, arg0);
         return (TIMESTAMP)this.postForAll(methodObject525, (Object)this.delegate.createTIMESTAMP(arg0));
      } catch (SQLException var3) {
         return (TIMESTAMP)this.postForAll(methodObject525, this.onErrorForAll(methodObject525, var3));
      }
   }

   public boolean getImplicitCachingEnabled() throws SQLException {
      try {
         super.preForAll(methodObject457, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject457, this.delegate.getImplicitCachingEnabled());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject457, this.onErrorForAll(methodObject457, var2));
      }
   }

   public void purgeExplicitCache() throws SQLException {
      try {
         super.preForAll(methodObject461, this, zeroLengthObjectArray);
         Method var10001 = methodObject461;
         this.delegate.purgeExplicitCache();
         this.postForAll(var10001);
      } catch (SQLException var2) {
         this.onErrorVoidForAll(methodObject461, var2);
      }
   }

   public void setEndToEndMetrics(String[] arg0, short arg1) throws SQLException {
      try {
         super.preForAll(methodObject448, this, arg0, arg1);
         Method var10001 = methodObject448;
         this.delegate.setEndToEndMetrics(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject448, var4);
      }
   }

   public void purgeImplicitCache() throws SQLException {
      try {
         super.preForAll(methodObject460, this, zeroLengthObjectArray);
         Method var10001 = methodObject460;
         this.delegate.purgeImplicitCache();
         this.postForAll(var10001);
      } catch (SQLException var2) {
         this.onErrorVoidForAll(methodObject460, var2);
      }
   }

   public void putDescriptor(String arg0, Object arg1) throws SQLException {
      try {
         super.preForAll(methodObject418, this, arg0, arg1);
         Method var10001 = methodObject418;
         this.delegate.putDescriptor(arg0, arg1 instanceof _Proxy_ ? (Object)((_Proxy_)arg1)._getDelegate_() : arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject418, var4);
      }
   }

   public ClobDBAccess createClobDBAccess() throws SQLException {
      try {
         super.preForAll(methodObject294, this, zeroLengthObjectArray);
         return (ClobDBAccess)this.postForAll(methodObject294, (Object)this.delegate.createClobDBAccess());
      } catch (SQLException var2) {
         return (ClobDBAccess)this.postForAll(methodObject294, this.onErrorForAll(methodObject294, var2));
      }
   }

   public byte[] createLightweightSession(String arg0, KeywordValueLong[] arg1, int arg2, KeywordValueLong[][] arg3, int[] arg4) throws SQLException {
      try {
         super.preForAll(methodObject363, this, arg0, arg1, arg2, arg3, arg4);
         return (byte[])this.postForAll(methodObject363, (Object)this.delegate.createLightweightSession(arg0, arg1, arg2, arg3, arg4));
      } catch (SQLException var7) {
         return (byte[])this.postForAll(methodObject363, this.onErrorForAll(methodObject363, var7));
      }
   }

   public NUMBER createNUMBER(float arg0) throws SQLException {
      try {
         super.preForAll(methodObject518, this, arg0);
         return (NUMBER)this.postForAll(methodObject518, (Object)this.delegate.createNUMBER(arg0));
      } catch (SQLException var3) {
         return (NUMBER)this.postForAll(methodObject518, this.onErrorForAll(methodObject518, var3));
      }
   }

   public void removeXSEventListener(XSEventListener arg0) throws SQLException {
      try {
         super.preForAll(methodObject377, this, arg0);
         Method var10001 = methodObject377;
         this.delegate.removeXSEventListener(arg0);
         this.postForAll(var10001);
      } catch (SQLException var3) {
         this.onErrorVoidForAll(methodObject377, var3);
      }
   }

   public void removeAllXSEventListener() throws SQLException {
      try {
         super.preForAll(methodObject379, this, zeroLengthObjectArray);
         Method var10001 = methodObject379;
         this.delegate.removeAllXSEventListener();
         this.postForAll(var10001);
      } catch (SQLException var2) {
         this.onErrorVoidForAll(methodObject379, var2);
      }
   }

   public void setTypeMap(Map arg0) throws SQLException {
      try {
         super.preForAll(methodObject337, this, arg0);
         Method var10001 = methodObject337;
         this.delegate.setTypeMap(arg0);
         this.postForAll(var10001);
      } catch (SQLException var3) {
         this.onErrorVoidForAll(methodObject337, var3);
      }
   }

   public void setCatalog(String arg0) throws SQLException {
      try {
         super.preForAll(methodObject602, this, arg0);
         Method var10001 = methodObject602;
         this.delegate.setCatalog(arg0);
         this.postForAll(var10001);
      } catch (SQLException var3) {
         this.onErrorVoidForAll(methodObject602, var3);
      }
   }

   public TIMESTAMP createTIMESTAMP(Date arg0) throws SQLException {
      try {
         super.preForAll(methodObject523, this, arg0);
         return (TIMESTAMP)this.postForAll(methodObject523, (Object)this.delegate.createTIMESTAMP(arg0));
      } catch (SQLException var3) {
         return (TIMESTAMP)this.postForAll(methodObject523, this.onErrorForAll(methodObject523, var3));
      }
   }

   public void setRemarksReporting(boolean arg0) {
      super.preForAll(methodObject450, this, arg0);
      Method var10001 = methodObject450;
      this.delegate.setRemarksReporting(arg0);
      this.postForAll(var10001);
   }

   public BINARY_FLOAT createBINARY_FLOAT(float arg0) throws SQLException {
      try {
         super.preForAll(methodObject503, this, arg0);
         return (BINARY_FLOAT)this.postForAll(methodObject503, (Object)this.delegate.createBINARY_FLOAT(arg0));
      } catch (SQLException var3) {
         return (BINARY_FLOAT)this.postForAll(methodObject503, this.onErrorForAll(methodObject503, var3));
      }
   }

   public Properties getProperties() {
      super.preForAll(methodObject412, this, zeroLengthObjectArray);
      return (Properties)this.postForAll(methodObject412, (Object)this.delegate.getProperties());
   }

   public NUMBER createNUMBER(boolean arg0) throws SQLException {
      try {
         super.preForAll(methodObject513, this, arg0);
         return (NUMBER)this.postForAll(methodObject513, (Object)this.delegate.createNUMBER(arg0));
      } catch (SQLException var3) {
         return (NUMBER)this.postForAll(methodObject513, this.onErrorForAll(methodObject513, var3));
      }
   }

   public int getEOC() throws SQLException {
      try {
         super.preForAll(methodObject396, this, zeroLengthObjectArray);
         return (Integer)this.postForAll(methodObject396, this.delegate.getEOC());
      } catch (SQLException var2) {
         return (Integer)this.postForAll(methodObject396, this.onErrorForAll(methodObject396, var2));
      }
   }

   public void setStmtCacheSize(int arg0, boolean arg1) throws SQLException {
      try {
         super.preForAll(methodObject453, this, arg0, arg1);
         Method var10001 = methodObject453;
         this.delegate.setStmtCacheSize(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject453, var4);
      }
   }

   public boolean getDefaultFixedString() {
      super.preForAll(methodObject296, this, zeroLengthObjectArray);
      return (Boolean)this.postForAll(methodObject296, this.delegate.getDefaultFixedString());
   }

   public void registerSQLType(String arg0, Class arg1) throws SQLException {
      try {
         super.preForAll(methodObject443, this, arg0, arg1);
         Method var10001 = methodObject443;
         this.delegate.registerSQLType(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject443, var4);
      }
   }

   public ReplayContext[] getReplayContext() throws SQLException {
      try {
         super.preForAll(methodObject393, this, zeroLengthObjectArray);
         return (ReplayContext[])this.postForAll(methodObject393, (Object)this.delegate.getReplayContext());
      } catch (SQLException var2) {
         return (ReplayContext[])this.postForAll(methodObject393, this.onErrorForAll(methodObject393, var2));
      }
   }

   public void setApplicationContext(String arg0, String arg1, String arg2) throws SQLException {
      try {
         super.preForAll(methodObject551, this, arg0, arg1, arg2);
         Method var10001 = methodObject551;
         this.delegate.setApplicationContext(arg0, arg1, arg2);
         this.postForAll(var10001);
      } catch (SQLException var5) {
         this.onErrorVoidForAll(methodObject551, var5);
      }
   }

   public int getNetworkTimeout() throws SQLException {
      try {
         super.preForAll(methodObject592, this, zeroLengthObjectArray);
         return (Integer)this.postForAll(methodObject592, this.delegate.getNetworkTimeout());
      } catch (SQLException var2) {
         return (Integer)this.postForAll(methodObject592, this.onErrorForAll(methodObject592, var2));
      }
   }

   public boolean attachServerConnection() throws SQLException {
      try {
         super.preForAll(methodObject558, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject558, this.delegate.attachServerConnection());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject558, this.onErrorForAll(methodObject558, var2));
      }
   }

   public CallableStatement prepareCall(String arg0) throws SQLException {
      try {
         super.preForStatementCreation(methodObject572, this, arg0);
         return (CallableStatement)this.postForAll(methodObject572, this.proxyFactory.proxyForCache((Object)this.delegate.prepareCall(arg0), this, this.proxyCache, methodObject572));
      } catch (SQLException var3) {
         return (CallableStatement)this.postForAll(methodObject572, this.onErrorForAll(methodObject572, var3));
      }
   }

   public void unregisterDatabaseChangeNotification(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject500, this, arg0);
         Method var10001 = methodObject500;
         this.delegate.unregisterDatabaseChangeNotification(arg0);
         this.postForAll(var10001);
      } catch (SQLException var3) {
         this.onErrorVoidForAll(methodObject500, var3);
      }
   }

   public TIMESTAMP createTIMESTAMP(Timestamp arg0) throws SQLException {
      try {
         super.preForAll(methodObject526, this, arg0);
         return (TIMESTAMP)this.postForAll(methodObject526, (Object)this.delegate.createTIMESTAMP(arg0));
      } catch (SQLException var3) {
         return (TIMESTAMP)this.postForAll(methodObject526, this.onErrorForAll(methodObject526, var3));
      }
   }

   public void doXSSessionAttachOp(int arg0, byte[] arg1, XSSecureId arg2, byte[] arg3, XSPrincipal arg4, String[] arg5, String[] arg6, String[] arg7, XSNamespace[] arg8, XSNamespace[] arg9, XSNamespace[] arg10, TIMESTAMPTZ arg11, TIMESTAMPTZ arg12, int arg13, long arg14, XSKeyval arg15, int[] arg16) throws SQLException {
      try {
         super.preForAll(methodObject369, this, arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10, arg11, arg12, arg13, arg14, arg15, arg16);
         Method var10001 = methodObject369;
         this.delegate.doXSSessionAttachOp(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10, arg11, arg12, arg13, arg14, arg15, arg16);
         this.postForAll(var10001);
      } catch (SQLException var20) {
         this.onErrorVoidForAll(methodObject369, var20);
      }
   }

   public OracleConnection getPhysicalConnection() {
      super.preForAll(methodObject303, this, zeroLengthObjectArray);
      return (OracleConnection)this.postForAll(methodObject303, this.proxyFactory.proxyForCache((Object)this.delegate.getPhysicalConnection(), this, this.proxyCache, methodObject303));
   }

   public Struct createStruct(String arg0, Object[] arg1) throws SQLException {
      try {
         super.preForAll(methodObject576, this, arg0, arg1);
         return (Struct)this.postForAll(methodObject576, this.proxyFactory.proxyForCache((Object)super.createStruct(arg0, arg1), this, this.proxyCache, methodObject576));
      } catch (SQLException var4) {
         return (Struct)this.postForAll(methodObject576, this.onErrorForAll(methodObject576, var4));
      }
   }

   public void setHoldability(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject605, this, arg0);
         Method var10001 = methodObject605;
         this.delegate.setHoldability(arg0);
         this.postForAll(var10001);
      } catch (SQLException var3) {
         this.onErrorVoidForAll(methodObject605, var3);
      }
   }

   public void registerTAFCallback(OracleOCIFailover arg0, Object arg1) throws SQLException {
      try {
         super.preForAll(methodObject477, this, arg0, arg1);
         Method var10001 = methodObject477;
         this.delegate.registerTAFCallback(arg0, arg1 instanceof _Proxy_ ? (Object)((_Proxy_)arg1)._getDelegate_() : arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject477, var4);
      }
   }

   public int numberOfDescriptorCacheEntries() {
      super.preForAll(methodObject306, this, zeroLengthObjectArray);
      return (Integer)this.postForAll(methodObject306, this.delegate.numberOfDescriptorCacheEntries());
   }

   public void oracleRollback(OracleSavepoint arg0) throws SQLException {
      try {
         super.preForAll(methodObject482, this, arg0);
         Method var10001 = methodObject482;
         this.delegate.oracleRollback(arg0 instanceof _Proxy_ ? (OracleSavepoint)((_Proxy_)arg0)._getDelegate_() : arg0);
         this.postForAll(var10001);
      } catch (SQLException var3) {
         this.onErrorVoidForAll(methodObject482, var3);
      }
   }

   public boolean getCreateStatementAsRefCursor() {
      super.preForAll(methodObject471, this, zeroLengthObjectArray);
      return (Boolean)this.postForAll(methodObject471, this.delegate.getCreateStatementAsRefCursor());
   }

   public PreparedStatement prepareStatement(String arg0) throws SQLException {
      try {
         super.preForStatementCreation(methodObject566, this, arg0);
         return (PreparedStatement)this.postForAll(methodObject566, this.proxyFactory.proxyForCache((Object)this.delegate.prepareStatement(arg0), this, this.proxyCache, methodObject566));
      } catch (SQLException var3) {
         return (PreparedStatement)this.postForAll(methodObject566, this.onErrorForAll(methodObject566, var3));
      }
   }

   public int getVarTypeMaxLenCompat() throws SQLException {
      try {
         super.preForAll(methodObject282, this, zeroLengthObjectArray);
         return (Integer)this.postForAll(methodObject282, this.delegate.getVarTypeMaxLenCompat());
      } catch (SQLException var2) {
         return (Integer)this.postForAll(methodObject282, this.onErrorForAll(methodObject282, var2));
      }
   }

   public NUMBER createNUMBER(long arg0) throws SQLException {
      try {
         super.preForAll(methodObject517, this, arg0);
         return (NUMBER)this.postForAll(methodObject517, (Object)this.delegate.createNUMBER(arg0));
      } catch (SQLException var4) {
         return (NUMBER)this.postForAll(methodObject517, this.onErrorForAll(methodObject517, var4));
      }
   }

   public DatabaseChangeRegistration registerDatabaseChangeNotification(Properties arg0) throws SQLException {
      try {
         super.preForAll(methodObject496, this, arg0);
         return (DatabaseChangeRegistration)this.postForAll(methodObject496, (Object)this.delegate.registerDatabaseChangeNotification(arg0));
      } catch (SQLException var3) {
         return (DatabaseChangeRegistration)this.postForAll(methodObject496, this.onErrorForAll(methodObject496, var3));
      }
   }

   public NUMBER createNUMBER(short arg0) throws SQLException {
      try {
         super.preForAll(methodObject515, this, arg0);
         return (NUMBER)this.postForAll(methodObject515, (Object)this.delegate.createNUMBER(arg0));
      } catch (SQLException var3) {
         return (NUMBER)this.postForAll(methodObject515, this.onErrorForAll(methodObject515, var3));
      }
   }

   public long getStartTime() throws SQLException {
      try {
         super.preForAll(methodObject334, this, zeroLengthObjectArray);
         return (Long)this.postForAll(methodObject334, this.delegate.getStartTime());
      } catch (SQLException var2) {
         return (Long)this.postForAll(methodObject334, this.onErrorForAll(methodObject334, var2));
      }
   }

   public NUMBER createNUMBER(byte arg0) throws SQLException {
      try {
         super.preForAll(methodObject514, this, arg0);
         return (NUMBER)this.postForAll(methodObject514, (Object)this.delegate.createNUMBER(arg0));
      } catch (SQLException var3) {
         return (NUMBER)this.postForAll(methodObject514, this.onErrorForAll(methodObject514, var3));
      }
   }

   public AQNotificationRegistration[] registerAQNotification(String[] arg0, Properties[] arg1, Properties arg2) throws SQLException {
      try {
         super.preForAll(methodObject492, this, arg0, arg1, arg2);
         return (AQNotificationRegistration[])this.postForAll(methodObject492, (Object)this.delegate.registerAQNotification(arg0, arg1, arg2));
      } catch (SQLException var5) {
         return (AQNotificationRegistration[])this.postForAll(methodObject492, this.onErrorForAll(methodObject492, var5));
      }
   }

   public boolean isLobStreamPosStandardCompliant() throws SQLException {
      try {
         super.preForAll(methodObject385, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject385, this.delegate.isLobStreamPosStandardCompliant());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject385, this.onErrorForAll(methodObject385, var2));
      }
   }

   public XAResource getXAResource() throws SQLException {
      try {
         super.preForAll(methodObject360, this, zeroLengthObjectArray);
         return (XAResource)this.postForAll(methodObject360, (Object)this.delegate.getXAResource());
      } catch (SQLException var2) {
         return (XAResource)this.postForAll(methodObject360, this.onErrorForAll(methodObject360, var2));
      }
   }

   public int getNegotiatedSDU() throws SQLException {
      try {
         super.preForAll(methodObject406, this, zeroLengthObjectArray);
         return (Integer)this.postForAll(methodObject406, this.delegate.getNegotiatedSDU());
      } catch (SQLException var2) {
         return (Integer)this.postForAll(methodObject406, this.onErrorForAll(methodObject406, var2));
      }
   }

   public TIMESTAMPTZ createTIMESTAMPTZ(Date arg0, Calendar arg1) throws SQLException {
      try {
         super.preForAll(methodObject529, this, arg0, arg1);
         return (TIMESTAMPTZ)this.postForAll(methodObject529, (Object)this.delegate.createTIMESTAMPTZ(arg0, arg1));
      } catch (SQLException var4) {
         return (TIMESTAMPTZ)this.postForAll(methodObject529, this.onErrorForAll(methodObject529, var4));
      }
   }

   public void addLogicalTransactionIdEventListener(LogicalTransactionIdEventListener arg0) throws SQLException {
      try {
         super.preForAll(methodObject553, this, arg0);
         Method var10001 = methodObject553;
         this.delegate.addLogicalTransactionIdEventListener(arg0);
         this.postForAll(var10001);
      } catch (SQLException var3) {
         this.onErrorVoidForAll(methodObject553, var3);
      }
   }

   public boolean isDescriptorSharable(OracleConnection arg0) throws SQLException {
      try {
         super.preForAll(methodObject358, this, arg0);
         return (Boolean)this.postForAll(methodObject358, this.delegate.isDescriptorSharable(arg0 instanceof _Proxy_ ? (OracleConnection)((_Proxy_)arg0)._getDelegate_() : arg0));
      } catch (SQLException var3) {
         return (Boolean)this.postForAll(methodObject358, this.onErrorForAll(methodObject358, var3));
      }
   }

   public int getStatementCacheSize() throws SQLException {
      try {
         super.preForAll(methodObject455, this, zeroLengthObjectArray);
         return (Integer)this.postForAll(methodObject455, this.delegate.getStatementCacheSize());
      } catch (SQLException var2) {
         return (Integer)this.postForAll(methodObject455, this.onErrorForAll(methodObject455, var2));
      }
   }

   public DATE createDATE(String arg0) throws SQLException {
      try {
         super.preForAll(methodObject510, this, arg0);
         return (DATE)this.postForAll(methodObject510, (Object)this.delegate.createDATE(arg0));
      } catch (SQLException var3) {
         return (DATE)this.postForAll(methodObject510, this.onErrorForAll(methodObject510, var3));
      }
   }

   public Map getTypeMap() throws SQLException {
      try {
         super.preForAll(methodObject284, this, zeroLengthObjectArray);
         return (Map)this.postForAll(methodObject284, (Object)this.delegate.getTypeMap());
      } catch (SQLException var2) {
         return (Map)this.postForAll(methodObject284, this.onErrorForAll(methodObject284, var2));
      }
   }

   public TIMESTAMP createTIMESTAMP(DATE arg0) throws SQLException {
      try {
         super.preForAll(methodObject524, this, arg0);
         return (TIMESTAMP)this.postForAll(methodObject524, (Object)this.delegate.createTIMESTAMP(arg0));
      } catch (SQLException var3) {
         return (TIMESTAMP)this.postForAll(methodObject524, this.onErrorForAll(methodObject524, var3));
      }
   }

   public void closeInternal(boolean arg0) throws SQLException {
      try {
         super.preForAll(methodObject346, this, arg0);
         Method var10001 = methodObject346;
         this.delegate.closeInternal(arg0);
         this.postForAll(var10001);
      } catch (SQLException var3) {
         this.onErrorVoidForAll(methodObject346, var3);
      }
   }

   public void setPDBChangeEventListener(PDBChangeEventListener arg0, Executor arg1) throws SQLException {
      try {
         super.preForAll(methodObject408, this, arg0, arg1);
         Method var10001 = methodObject408;
         this.delegate.setPDBChangeEventListener(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject408, var4);
      }
   }

   public Properties getDBAccessProperties() throws SQLException {
      try {
         super.preForAll(methodObject285, this, zeroLengthObjectArray);
         return (Properties)this.postForAll(methodObject285, (Object)this.delegate.getDBAccessProperties());
      } catch (SQLException var2) {
         return (Properties)this.postForAll(methodObject285, this.onErrorForAll(methodObject285, var2));
      }
   }

   public void cancel() throws SQLException {
      try {
         super.preForCancel(methodObject419, this, zeroLengthObjectArray);
         Method var10001 = methodObject419;
         this.delegate.cancel();
         this.postForCancel(var10001);
      } catch (SQLException var2) {
         this.onErrorVoidForAll(methodObject419, var2);
      }
   }

   public String[] getEndToEndMetrics() throws SQLException {
      try {
         super.preForAll(methodObject428, this, zeroLengthObjectArray);
         return (String[])this.postForAll(methodObject428, (Object)this.delegate.getEndToEndMetrics());
      } catch (SQLException var2) {
         return (String[])this.postForAll(methodObject428, this.onErrorForAll(methodObject428, var2));
      }
   }

   public NUMBER createNUMBER(double arg0) throws SQLException {
      try {
         super.preForAll(methodObject519, this, arg0);
         return (NUMBER)this.postForAll(methodObject519, (Object)this.delegate.createNUMBER(arg0));
      } catch (SQLException var4) {
         return (NUMBER)this.postForAll(methodObject519, this.onErrorForAll(methodObject519, var4));
      }
   }

   public byte[] doXSSessionCreateOp(OracleConnection.XSSessionOperationCode arg0, XSSecureId arg1, byte[] arg2, XSPrincipal arg3, String arg4, XSNamespace[] arg5, OracleConnection.XSSessionModeFlag arg6, XSKeyval arg7) throws SQLException {
      try {
         super.preForAll(methodObject367, this, arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7);
         return (byte[])this.postForAll(methodObject367, (Object)this.delegate.doXSSessionCreateOp(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7));
      } catch (SQLException var10) {
         return (byte[])this.postForAll(methodObject367, this.onErrorForAll(methodObject367, var10));
      }
   }

   public TypeDescriptor[] getTypeDescriptorsFromListInCurrentSchema(String[] arg0) throws SQLException {
      try {
         super.preForAll(methodObject543, this, arg0);
         return (TypeDescriptor[])this.postForAll(methodObject543, (Object)this.delegate.getTypeDescriptorsFromListInCurrentSchema(arg0));
      } catch (SQLException var3) {
         return (TypeDescriptor[])this.postForAll(methodObject543, this.onErrorForAll(methodObject543, var3));
      }
   }

   public AQMessage dequeue(String arg0, AQDequeueOptions arg1, byte[] arg2) throws SQLException {
      try {
         super.preForAll(methodObject494, this, arg0, arg1, arg2);
         return (AQMessage)this.postForAll(methodObject494, (Object)this.delegate.dequeue(arg0, arg1, arg2));
      } catch (SQLException var5) {
         return (AQMessage)this.postForAll(methodObject494, this.onErrorForAll(methodObject494, var5));
      }
   }

   public int getMaxCharSize() throws SQLException {
      try {
         super.preForAll(methodObject327, this, zeroLengthObjectArray);
         return (Integer)this.postForAll(methodObject327, this.delegate.getMaxCharSize());
      } catch (SQLException var2) {
         return (Integer)this.postForAll(methodObject327, this.onErrorForAll(methodObject327, var2));
      }
   }

   public TimeZone getDefaultTimeZone() throws SQLException {
      try {
         super.preForAll(methodObject550, this, zeroLengthObjectArray);
         return (TimeZone)this.postForAll(methodObject550, (Object)this.delegate.getDefaultTimeZone());
      } catch (SQLException var2) {
         return (TimeZone)this.postForAll(methodObject550, this.onErrorForAll(methodObject550, var2));
      }
   }

   public short getNCharSet() {
      super.preForAll(methodObject315, this, zeroLengthObjectArray);
      return (Short)this.postForAll(methodObject315, this.delegate.getNCharSet());
   }

   public short getDriverCharSet() {
      super.preForAll(methodObject325, this, zeroLengthObjectArray);
      return (Short)this.postForAll(methodObject325, this.delegate.getDriverCharSet());
   }

   public boolean getTimestamptzInGmt() {
      super.preForAll(methodObject382, this, zeroLengthObjectArray);
      return (Boolean)this.postForAll(methodObject382, this.delegate.getTimestamptzInGmt());
   }

   public boolean isConnectionSocketKeepAlive() throws SocketException, SQLException {
      try {
         super.preForAll(methodObject388, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject388, this.delegate.isConnectionSocketKeepAlive());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject388, this.onErrorForAll(methodObject388, var2));
      }
   }

   public DatabaseChangeRegistration getDatabaseChangeRegistration(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject497, this, arg0);
         return (DatabaseChangeRegistration)this.postForAll(methodObject497, (Object)this.delegate.getDatabaseChangeRegistration(arg0));
      } catch (SQLException var3) {
         return (DatabaseChangeRegistration)this.postForAll(methodObject497, this.onErrorForAll(methodObject497, var3));
      }
   }

   public int CHARBytesToJavaChars(byte[] arg0, int arg1, char[] arg2) throws SQLException {
      try {
         super.preForAll(methodObject321, this, arg0, arg1, arg2);
         return (Integer)this.postForAll(methodObject321, this.delegate.CHARBytesToJavaChars(arg0, arg1, arg2));
      } catch (SQLException var5) {
         return (Integer)this.postForAll(methodObject321, this.onErrorForAll(methodObject321, var5));
      }
   }

   public CallableStatement prepareCall(String arg0, int arg1, int arg2, int arg3) throws SQLException {
      try {
         super.preForStatementCreation(methodObject574, this, arg0, arg1, arg2, arg3);
         return (CallableStatement)this.postForAll(methodObject574, this.proxyFactory.proxyForCache((Object)this.delegate.prepareCall(arg0, arg1, arg2, arg3), this, this.proxyCache, methodObject574));
      } catch (SQLException var6) {
         return (CallableStatement)this.postForAll(methodObject574, this.onErrorForAll(methodObject574, var6));
      }
   }

   public boolean isDRCPEnabled() throws SQLException {
      try {
         super.preForAll(methodObject557, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject557, this.delegate.isDRCPEnabled());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject557, this.onErrorForAll(methodObject557, var2));
      }
   }

   public void shutdown(oracle.jdbc.OracleConnection.DatabaseShutdownMode arg0) throws SQLException {
      try {
         super.preForAll(methodObject410, this, arg0);
         Method var10001 = methodObject410;
         this.delegate.shutdown(arg0);
         this.postForAll(var10001);
      } catch (SQLException var3) {
         this.onErrorVoidForAll(methodObject410, var3);
      }
   }

   public void doXSSessionDestroyOp(byte[] arg0, XSSecureId arg1, byte[] arg2) throws SQLException {
      try {
         super.preForAll(methodObject368, this, arg0, arg1, arg2);
         Method var10001 = methodObject368;
         this.delegate.doXSSessionDestroyOp(arg0, arg1, arg2);
         this.postForAll(var10001);
      } catch (SQLException var5) {
         this.onErrorVoidForAll(methodObject368, var5);
      }
   }

   public void setPDBChangeEventListener(PDBChangeEventListener arg0) throws SQLException {
      try {
         super.preForAll(methodObject407, this, arg0);
         Method var10001 = methodObject407;
         this.delegate.setPDBChangeEventListener(arg0);
         this.postForAll(var10001);
      } catch (SQLException var3) {
         this.onErrorVoidForAll(methodObject407, var3);
      }
   }

   public boolean getRemarksReporting() {
      super.preForAll(methodObject433, this, zeroLengthObjectArray);
      return (Boolean)this.postForAll(methodObject433, this.delegate.getRemarksReporting());
   }

   public int pingDatabase() throws SQLException {
      try {
         super.preForAll(methodObject441, this, zeroLengthObjectArray);
         return (Integer)this.postForAll(methodObject441, this.delegate.pingDatabase());
      } catch (SQLException var2) {
         return (Integer)this.postForAll(methodObject441, this.onErrorForAll(methodObject441, var2));
      }
   }

   public int getConnectionReleasePriority() throws SQLException {
      try {
         super.preForAll(methodObject490, this, zeroLengthObjectArray);
         return (Integer)this.postForAll(methodObject490, this.delegate.getConnectionReleasePriority());
      } catch (SQLException var2) {
         return (Integer)this.postForAll(methodObject490, this.onErrorForAll(methodObject490, var2));
      }
   }

   public Connection getLogicalConnection(OraclePooledConnection arg0, boolean arg1) throws SQLException {
      try {
         super.preForAll(methodObject339, this, arg0, arg1);
         return (Connection)this.postForAll(methodObject339, this.proxyFactory.proxyForCache((Object)this.delegate.getLogicalConnection(arg0, arg1), this, this.proxyCache, methodObject339));
      } catch (SQLException var4) {
         return (Connection)this.postForAll(methodObject339, this.onErrorForAll(methodObject339, var4));
      }
   }

   public void releaseSavepoint(Savepoint arg0) throws SQLException {
      try {
         super.preForAll(methodObject598, this, arg0);
         Method var10001 = methodObject598;
         this.delegate.releaseSavepoint(arg0 instanceof _Proxy_ ? (Savepoint)((_Proxy_)arg0)._getDelegate_() : arg0);
         this.postForAll(var10001);
      } catch (SQLException var3) {
         this.onErrorVoidForAll(methodObject598, var3);
      }
   }

   public boolean getXAErrorFlag() {
      super.preForAll(methodObject440, this, zeroLengthObjectArray);
      return (Boolean)this.postForAll(methodObject440, this.delegate.getXAErrorFlag());
   }

   public long getTdoCState(String arg0) throws SQLException {
      try {
         super.preForAll(methodObject309, this, arg0);
         return (Long)this.postForAll(methodObject309, this.delegate.getTdoCState(arg0));
      } catch (SQLException var3) {
         return (Long)this.postForAll(methodObject309, this.onErrorForAll(methodObject309, var3));
      }
   }

   public Statement createStatement(int arg0, int arg1) throws SQLException {
      try {
         super.preForAll(methodObject584, this, arg0, arg1);
         return (Statement)this.postForAll(methodObject584, this.proxyFactory.proxyForCache((Object)this.delegate.createStatement(arg0, arg1), this, this.proxyCache, methodObject584));
      } catch (SQLException var4) {
         return (Statement)this.postForAll(methodObject584, this.onErrorForAll(methodObject584, var4));
      }
   }

   public void setStartTime(long arg0) throws SQLException {
      try {
         super.preForAll(methodObject333, this, arg0);
         Method var10001 = methodObject333;
         this.delegate.setStartTime(arg0);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject333, var4);
      }
   }

   public String getDefaultSchemaNameForNamedTypes() throws SQLException {
      try {
         super.preForAll(methodObject372, this, zeroLengthObjectArray);
         return (String)this.postForAll(methodObject372, (Object)this.delegate.getDefaultSchemaNameForNamedTypes());
      } catch (SQLException var2) {
         return (String)this.postForAll(methodObject372, this.onErrorForAll(methodObject372, var2));
      }
   }

   public int getTxnMode() {
      super.preForAll(methodObject341, this, zeroLengthObjectArray);
      return (Integer)this.postForAll(methodObject341, this.delegate.getTxnMode());
   }

   public String getUserName() throws SQLException {
      try {
         super.preForAll(methodObject437, this, zeroLengthObjectArray);
         return (String)this.postForAll(methodObject437, (Object)this.delegate.getUserName());
      } catch (SQLException var2) {
         return (String)this.postForAll(methodObject437, this.onErrorForAll(methodObject437, var2));
      }
   }

   public BLOB createBlobWithUnpickledBytes(byte[] arg0) throws SQLException {
      try {
         super.preForAll(methodObject356, this, arg0);
         return (BLOB)this.postForAll(methodObject356, (Object)this.delegate.createBlobWithUnpickledBytes(arg0));
      } catch (SQLException var3) {
         return (BLOB)this.postForAll(methodObject356, this.onErrorForAll(methodObject356, var3));
      }
   }

   public TIMESTAMPLTZ createTIMESTAMPLTZ(String arg0, Calendar arg1) throws SQLException {
      try {
         super.preForAll(methodObject540, this, arg0, arg1);
         return (TIMESTAMPLTZ)this.postForAll(methodObject540, (Object)this.delegate.createTIMESTAMPLTZ(arg0, arg1));
      } catch (SQLException var4) {
         return (TIMESTAMPLTZ)this.postForAll(methodObject540, this.onErrorForAll(methodObject540, var4));
      }
   }

   public CallableStatement prepareCallWithKey(String arg0) throws SQLException {
      try {
         super.preForAll(methodObject469, this, arg0);
         return (CallableStatement)this.postForAll(methodObject469, this.proxyFactory.proxyForCache((Object)this.delegate.prepareCallWithKey(arg0), this, this.proxyCache, methodObject469));
      } catch (SQLException var3) {
         return (CallableStatement)this.postForAll(methodObject469, this.onErrorForAll(methodObject469, var3));
      }
   }

   public void setPlsqlWarnings(String arg0) throws SQLException {
      try {
         super.preForAll(methodObject491, this, arg0);
         Method var10001 = methodObject491;
         this.delegate.setPlsqlWarnings(arg0);
         this.postForAll(var10001);
      } catch (SQLException var3) {
         this.onErrorVoidForAll(methodObject491, var3);
      }
   }

   public NClob createNClob() throws SQLException {
      try {
         super.preForAll(methodObject577, this, zeroLengthObjectArray);
         return (NClob)this.postForAll(methodObject577, this.proxyFactory.proxyForCache((Object)this.delegate.createNClob(), this, this.proxyCache, methodObject577));
      } catch (SQLException var2) {
         return (NClob)this.postForAll(methodObject577, this.onErrorForAll(methodObject577, var2));
      }
   }

   public boolean isProxySession() {
      super.preForAll(methodObject484, this, zeroLengthObjectArray);
      return (Boolean)this.postForAll(methodObject484, this.delegate.isProxySession());
   }

   public void oracleReleaseSavepoint(OracleSavepoint arg0) throws SQLException {
      try {
         super.preForAll(methodObject483, this, arg0);
         Method var10001 = methodObject483;
         this.delegate.oracleReleaseSavepoint(arg0 instanceof _Proxy_ ? (OracleSavepoint)((_Proxy_)arg0)._getDelegate_() : arg0);
         this.postForAll(var10001);
      } catch (SQLException var3) {
         this.onErrorVoidForAll(methodObject483, var3);
      }
   }

   public void setReplayContext(ReplayContext[] arg0) throws SQLException {
      try {
         super.preForAll(methodObject323, this, arg0);
         Method var10001 = methodObject323;
         this.delegate.setReplayContext(arg0);
         this.postForAll(var10001);
      } catch (SQLException var3) {
         this.onErrorVoidForAll(methodObject323, var3);
      }
   }

   public boolean getAutoCommit() throws SQLException {
      try {
         super.preForAll(methodObject586, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject586, this.delegate.getAutoCommit());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject586, this.onErrorForAll(methodObject586, var2));
      }
   }

   public void addXSEventListener(XSEventListener arg0, Executor arg1) throws SQLException {
      try {
         super.preForAll(methodObject376, this, arg0, arg1);
         Method var10001 = methodObject376;
         this.delegate.addXSEventListener(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject376, var4);
      }
   }

   public void unregisterJMSNotification(JMSNotificationRegistration arg0) throws SQLException {
      try {
         super.preForAll(methodObject404, this, arg0);
         Method var10001 = methodObject404;
         this.delegate.unregisterJMSNotification(arg0);
         this.postForAll(var10001);
      } catch (SQLException var3) {
         this.onErrorVoidForAll(methodObject404, var3);
      }
   }

   public void getPropertyForPooledConnection(OraclePooledConnection arg0) throws SQLException {
      try {
         super.preForAll(methodObject336, this, arg0);
         Method var10001 = methodObject336;
         this.delegate.getPropertyForPooledConnection(arg0);
         this.postForAll(var10001);
      } catch (SQLException var3) {
         this.onErrorVoidForAll(methodObject336, var3);
      }
   }

   public void addLogicalTransactionIdEventListener(LogicalTransactionIdEventListener arg0, Executor arg1) throws SQLException {
      try {
         super.preForAll(methodObject554, this, arg0, arg1);
         Method var10001 = methodObject554;
         this.delegate.addLogicalTransactionIdEventListener(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject554, var4);
      }
   }

   public short getJdbcCsId() throws SQLException {
      try {
         super.preForAll(methodObject314, this, zeroLengthObjectArray);
         return (Short)this.postForAll(methodObject314, this.delegate.getJdbcCsId());
      } catch (SQLException var2) {
         return (Short)this.postForAll(methodObject314, this.onErrorForAll(methodObject314, var2));
      }
   }

   public int getHoldability() throws SQLException {
      try {
         super.preForAll(methodObject590, this, zeroLengthObjectArray);
         return (Integer)this.postForAll(methodObject590, this.delegate.getHoldability());
      } catch (SQLException var2) {
         return (Integer)this.postForAll(methodObject590, this.onErrorForAll(methodObject590, var2));
      }
   }

   public DATE createDATE(Timestamp arg0, Calendar arg1) throws SQLException {
      try {
         super.preForAll(methodObject509, this, arg0, arg1);
         return (DATE)this.postForAll(methodObject509, (Object)this.delegate.createDATE(arg0, arg1));
      } catch (SQLException var4) {
         return (DATE)this.postForAll(methodObject509, this.onErrorForAll(methodObject509, var4));
      }
   }

   public TIMESTAMPTZ createTIMESTAMPTZ(String arg0, Calendar arg1) throws SQLException {
      try {
         super.preForAll(methodObject535, this, arg0, arg1);
         return (TIMESTAMPTZ)this.postForAll(methodObject535, (Object)this.delegate.createTIMESTAMPTZ(arg0, arg1));
      } catch (SQLException var4) {
         return (TIMESTAMPTZ)this.postForAll(methodObject535, this.onErrorForAll(methodObject535, var4));
      }
   }

   public OracleConnection.BufferCacheStatistics getCharBufferCacheStatistics() {
      super.preForAll(methodObject311, this, zeroLengthObjectArray);
      return (OracleConnection.BufferCacheStatistics)this.postForAll(methodObject311, (Object)this.delegate.getCharBufferCacheStatistics());
   }

   public void rollback() throws SQLException {
      try {
         super.preForAll(methodObject599, this, zeroLengthObjectArray);
         Method var10001 = methodObject599;
         this.delegate.rollback();
         this.postForAll(var10001);
      } catch (SQLException var2) {
         this.onErrorVoidForAll(methodObject599, var2);
      }
   }

   public NUMBER createNUMBER(BigInteger arg0) throws SQLException {
      try {
         super.preForAll(methodObject521, this, arg0);
         return (NUMBER)this.postForAll(methodObject521, (Object)this.delegate.createNUMBER(arg0));
      } catch (SQLException var3) {
         return (NUMBER)this.postForAll(methodObject521, this.onErrorForAll(methodObject521, var3));
      }
   }

   public void beginNonRequestCalls() throws SQLException {
      try {
         super.preForAll(methodObject391, this, zeroLengthObjectArray);
         Method var10001 = methodObject391;
         this.delegate.beginNonRequestCalls();
         this.postForAll(var10001);
      } catch (SQLException var2) {
         this.onErrorVoidForAll(methodObject391, var2);
      }
   }

   public TIMESTAMPTZ createTIMESTAMPTZ(Time arg0) throws SQLException {
      try {
         super.preForAll(methodObject530, this, arg0);
         return (TIMESTAMPTZ)this.postForAll(methodObject530, (Object)this.delegate.createTIMESTAMPTZ(arg0));
      } catch (SQLException var3) {
         return (TIMESTAMPTZ)this.postForAll(methodObject530, this.onErrorForAll(methodObject530, var3));
      }
   }

   public Object getDescriptor(String arg0) {
      super.preForAll(methodObject411, this, arg0);
      return this.postForAll(methodObject411, this.proxyFactory.proxyForCache(this.delegate.getDescriptor(arg0), this, this.proxyCache, methodObject411));
   }

   public TIMESTAMPLTZ createTIMESTAMPLTZ(Date arg0, Calendar arg1) throws SQLException {
      try {
         super.preForAll(methodObject537, this, arg0, arg1);
         return (TIMESTAMPLTZ)this.postForAll(methodObject537, (Object)this.delegate.createTIMESTAMPLTZ(arg0, arg1));
      } catch (SQLException var4) {
         return (TIMESTAMPLTZ)this.postForAll(methodObject537, this.onErrorForAll(methodObject537, var4));
      }
   }

   public TIMESTAMPTZ createTIMESTAMPTZ(Time arg0, Calendar arg1) throws SQLException {
      try {
         super.preForAll(methodObject531, this, arg0, arg1);
         return (TIMESTAMPTZ)this.postForAll(methodObject531, (Object)this.delegate.createTIMESTAMPTZ(arg0, arg1));
      } catch (SQLException var4) {
         return (TIMESTAMPTZ)this.postForAll(methodObject531, this.onErrorForAll(methodObject531, var4));
      }
   }

   public boolean isDataInLocatorEnabled() throws SQLException {
      try {
         super.preForAll(methodObject384, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject384, this.delegate.isDataInLocatorEnabled());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject384, this.onErrorForAll(methodObject384, var2));
      }
   }

   public boolean isCharSetMultibyte(short arg0) {
      super.preForAll(methodObject330, this, arg0);
      return (Boolean)this.postForAll(methodObject330, this.delegate.isCharSetMultibyte(arg0));
   }

   public boolean getIncludeSynonyms() {
      super.preForAll(methodObject430, this, zeroLengthObjectArray);
      return (Boolean)this.postForAll(methodObject430, this.delegate.getIncludeSynonyms());
   }

   public OracleSavepoint oracleSetSavepoint(String arg0) throws SQLException {
      try {
         super.preForAll(methodObject481, this, arg0);
         return (OracleSavepoint)this.postForAll(methodObject481, this.proxyFactory.proxyForCache((Object)this.delegate.oracleSetSavepoint(arg0), this, this.proxyCache, methodObject481));
      } catch (SQLException var3) {
         return (OracleSavepoint)this.postForAll(methodObject481, this.onErrorForAll(methodObject481, var3));
      }
   }

   public int getOCIEnvHeapAllocSize() throws SQLException {
      try {
         super.preForAll(methodObject343, this, zeroLengthObjectArray);
         return (Integer)this.postForAll(methodObject343, this.delegate.getOCIEnvHeapAllocSize());
      } catch (SQLException var2) {
         return (Integer)this.postForAll(methodObject343, this.onErrorForAll(methodObject343, var2));
      }
   }

   public DATE createDATE(Date arg0, Calendar arg1) throws SQLException {
      try {
         super.preForAll(methodObject507, this, arg0, arg1);
         return (DATE)this.postForAll(methodObject507, (Object)this.delegate.createDATE(arg0, arg1));
      } catch (SQLException var4) {
         return (DATE)this.postForAll(methodObject507, this.onErrorForAll(methodObject507, var4));
      }
   }

   public void unregisterDatabaseChangeNotification(int arg0, String arg1, int arg2) throws SQLException {
      try {
         super.preForAll(methodObject499, this, arg0, arg1, arg2);
         Method var10001 = methodObject499;
         this.delegate.unregisterDatabaseChangeNotification(arg0, arg1, arg2);
         this.postForAll(var10001);
      } catch (SQLException var5) {
         this.onErrorVoidForAll(methodObject499, var5);
      }
   }

   public DATE createDATE(Timestamp arg0) throws SQLException {
      try {
         super.preForAll(methodObject506, this, arg0);
         return (DATE)this.postForAll(methodObject506, (Object)this.delegate.createDATE(arg0));
      } catch (SQLException var3) {
         return (DATE)this.postForAll(methodObject506, this.onErrorForAll(methodObject506, var3));
      }
   }

   public int getDefaultExecuteBatch() {
      super.preForAll(methodObject426, this, zeroLengthObjectArray);
      return (Integer)this.postForAll(methodObject426, this.delegate.getDefaultExecuteBatch());
   }

   public BlobDBAccess createBlobDBAccess() throws SQLException {
      try {
         super.preForAll(methodObject293, this, zeroLengthObjectArray);
         return (BlobDBAccess)this.postForAll(methodObject293, (Object)this.delegate.createBlobDBAccess());
      } catch (SQLException var2) {
         return (BlobDBAccess)this.postForAll(methodObject293, this.onErrorForAll(methodObject293, var2));
      }
   }

   public void setAutoCommit(boolean arg0) throws SQLException {
      try {
         super.preForAll(methodObject601, this, arg0);
         Method var10001 = methodObject601;
         this.delegate.setAutoCommit(arg0);
         this.postForAll(var10001);
      } catch (SQLException var3) {
         this.onErrorVoidForAll(methodObject601, var3);
      }
   }

   public LogicalTransactionId getLogicalTransactionId() throws SQLException {
      try {
         super.preForAll(methodObject556, this, zeroLengthObjectArray);
         return (LogicalTransactionId)this.postForAll(methodObject556, (Object)this.delegate.getLogicalTransactionId());
      } catch (SQLException var2) {
         return (LogicalTransactionId)this.postForAll(methodObject556, this.onErrorForAll(methodObject556, var2));
      }
   }

   public Properties getServerSessionInfo() throws SQLException {
      try {
         super.preForAll(methodObject351, this, zeroLengthObjectArray);
         return (Properties)this.postForAll(methodObject351, (Object)this.delegate.getServerSessionInfo());
      } catch (SQLException var2) {
         return (Properties)this.postForAll(methodObject351, this.onErrorForAll(methodObject351, var2));
      }
   }

   public void setDefaultFixedString(boolean arg0) {
      super.preForAll(methodObject295, this, arg0);
      Method var10001 = methodObject295;
      this.delegate.setDefaultFixedString(arg0);
      this.postForAll(var10001);
   }

   public BLOB createBlob(byte[] arg0) throws SQLException {
      try {
         super.preForAll(methodObject355, this, arg0);
         return (BLOB)this.postForAll(methodObject355, (Object)this.delegate.createBlob(arg0));
      } catch (SQLException var3) {
         return (BLOB)this.postForAll(methodObject355, this.onErrorForAll(methodObject355, var3));
      }
   }

   public int getHeartbeatNoChangeCount() throws SQLException {
      try {
         super.preForAll(methodObject345, this, zeroLengthObjectArray);
         return (Integer)this.postForAll(methodObject345, this.delegate.getHeartbeatNoChangeCount());
      } catch (SQLException var2) {
         return (Integer)this.postForAll(methodObject345, this.onErrorForAll(methodObject345, var2));
      }
   }

   public void cleanupAndClose(boolean arg0) throws SQLException {
      try {
         super.preForAll(methodObject347, this, arg0);
         Method var10001 = methodObject347;
         this.delegate.cleanupAndClose(arg0);
         this.postForAll(var10001);
      } catch (SQLException var3) {
         this.onErrorVoidForAll(methodObject347, var3);
      }
   }

   public void archive(int arg0, int arg1, String arg2) throws SQLException {
      try {
         super.preForAll(methodObject424, this, arg0, arg1, arg2);
         Method var10001 = methodObject424;
         this.delegate.archive(arg0, arg1, arg2);
         this.postForAll(var10001);
      } catch (SQLException var5) {
         this.onErrorVoidForAll(methodObject424, var5);
      }
   }

   public void commit(EnumSet arg0) throws SQLException {
      try {
         super.preForAll(methodObject423, this, arg0);
         Method var10001 = methodObject423;
         this.delegate.commit(arg0);
         this.postForAll(var10001);
      } catch (SQLException var3) {
         this.onErrorVoidForAll(methodObject423, var3);
      }
   }

   public boolean isReadOnly() throws SQLException {
      try {
         super.preForAll(methodObject564, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject564, this.delegate.isReadOnly());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject564, this.onErrorForAll(methodObject564, var2));
      }
   }

   public void addXSEventListener(XSEventListener arg0) throws SQLException {
      try {
         super.preForAll(methodObject375, this, arg0);
         Method var10001 = methodObject375;
         this.delegate.addXSEventListener(arg0);
         this.postForAll(var10001);
      } catch (SQLException var3) {
         this.onErrorVoidForAll(methodObject375, var3);
      }
   }

   public int getDefaultRowPrefetch() {
      super.preForAll(methodObject427, this, zeroLengthObjectArray);
      return (Integer)this.postForAll(methodObject427, this.delegate.getDefaultRowPrefetch());
   }

   public void registerEndReplayCallback(OracleConnection.EndReplayCallback arg0) throws SQLException {
      try {
         super.preForAll(methodObject395, this, arg0);
         Method var10001 = methodObject395;
         this.delegate.registerEndReplayCallback(arg0);
         this.postForAll(var10001);
      } catch (SQLException var3) {
         this.onErrorVoidForAll(methodObject395, var3);
      }
   }

   public void setReplayOperations(EnumSet arg0) throws SQLException {
      try {
         super.preForAll(methodObject389, this, arg0);
         Method var10001 = methodObject389;
         this.delegate.setReplayOperations(arg0);
         this.postForAll(var10001);
      } catch (SQLException var3) {
         this.onErrorVoidForAll(methodObject389, var3);
      }
   }

   public ResultSet newArrayLocatorResultSet(ArrayDescriptor arg0, byte[] arg1, long arg2, int arg3, Map arg4) throws SQLException {
      try {
         super.preForAll(methodObject318, this, arg0, arg1, arg2, arg3, arg4);
         return (ResultSet)this.postForAll(methodObject318, this.proxyFactory.proxyForCache((Object)this.delegate.newArrayLocatorResultSet(arg0, arg1, arg2, arg3, arg4), this, this.proxyCache, methodObject318));
      } catch (SQLException var8) {
         return (ResultSet)this.postForAll(methodObject318, this.onErrorForAll(methodObject318, var8));
      }
   }

   public String getDataIntegrityAlgorithmName() throws SQLException {
      try {
         super.preForAll(methodObject545, this, zeroLengthObjectArray);
         return (String)this.postForAll(methodObject545, (Object)this.delegate.getDataIntegrityAlgorithmName());
      } catch (SQLException var2) {
         return (String)this.postForAll(methodObject545, this.onErrorForAll(methodObject545, var2));
      }
   }

   public DATE createDATE(Date arg0) throws SQLException {
      try {
         super.preForAll(methodObject504, this, arg0);
         return (DATE)this.postForAll(methodObject504, (Object)this.delegate.createDATE(arg0));
      } catch (SQLException var3) {
         return (DATE)this.postForAll(methodObject504, this.onErrorForAll(methodObject504, var3));
      }
   }

   public void setClientInfo(String arg0, String arg1) throws SQLClientInfoException {
      super.preForAll(methodObject603, this, arg0, arg1);
      Method var10001 = methodObject603;
      this.delegate.setClientInfo(arg0, arg1);
      this.postForAll(var10001);
   }

   public int getC2SNlsRatio() {
      super.preForAll(methodObject326, this, zeroLengthObjectArray);
      return (Integer)this.postForAll(methodObject326, this.delegate.getC2SNlsRatio());
   }

   public Object getDescriptor(byte[] arg0) {
      super.preForAll(methodObject280, this, arg0);
      return this.postForAll(methodObject280, this.proxyFactory.proxyForCache(this.delegate.getDescriptor(arg0), this, this.proxyCache, methodObject280));
   }

   public void close(Properties arg0) throws SQLException {
      try {
         super.preForClosure(methodObject414, this, arg0);
         Method var10001 = methodObject414;
         this.delegate.close(arg0);
         this.postForClosure(var10001);
      } catch (SQLException var3) {
         this.onErrorVoidForAll(methodObject414, var3);
      }
   }

   public NUMBER createNUMBER(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject516, this, arg0);
         return (NUMBER)this.postForAll(methodObject516, (Object)this.delegate.createNUMBER(arg0));
      } catch (SQLException var3) {
         return (NUMBER)this.postForAll(methodObject516, this.onErrorForAll(methodObject516, var3));
      }
   }

   public short getEndToEndECIDSequenceNumber() throws SQLException {
      try {
         super.preForAll(methodObject429, this, zeroLengthObjectArray);
         return (Short)this.postForAll(methodObject429, this.delegate.getEndToEndECIDSequenceNumber());
      } catch (SQLException var2) {
         return (Short)this.postForAll(methodObject429, this.onErrorForAll(methodObject429, var2));
      }
   }

   public void openProxySession(int arg0, Properties arg1) throws SQLException {
      try {
         super.preForOpenProxySession(methodObject420, this, arg0, arg1);
         Method var10001 = methodObject420;
         this.delegate.openProxySession(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject420, var4);
      }
   }

   public BfileDBAccess createBfileDBAccess() throws SQLException {
      try {
         super.preForAll(methodObject292, this, zeroLengthObjectArray);
         return (BfileDBAccess)this.postForAll(methodObject292, (Object)this.delegate.createBfileDBAccess());
      } catch (SQLException var2) {
         return (BfileDBAccess)this.postForAll(methodObject292, this.onErrorForAll(methodObject292, var2));
      }
   }

   public int getStmtCacheSize() {
      super.preForAll(methodObject435, this, zeroLengthObjectArray);
      return (Integer)this.postForAll(methodObject435, this.delegate.getStmtCacheSize());
   }

   public TIMESTAMPLTZ createTIMESTAMPLTZ(Time arg0, Calendar arg1) throws SQLException {
      try {
         super.preForAll(methodObject538, this, arg0, arg1);
         return (TIMESTAMPLTZ)this.postForAll(methodObject538, (Object)this.delegate.createTIMESTAMPLTZ(arg0, arg1));
      } catch (SQLException var4) {
         return (TIMESTAMPLTZ)this.postForAll(methodObject538, this.onErrorForAll(methodObject538, var4));
      }
   }

   public BFILE createBfile(byte[] arg0) throws SQLException {
      try {
         super.preForAll(methodObject357, this, arg0);
         return (BFILE)this.postForAll(methodObject357, (Object)this.delegate.createBfile(arg0));
      } catch (SQLException var3) {
         return (BFILE)this.postForAll(methodObject357, this.onErrorForAll(methodObject357, var3));
      }
   }

   public void commit() throws SQLException {
      try {
         super.preForAll(methodObject580, this, zeroLengthObjectArray);
         Method var10001 = methodObject580;
         this.delegate.commit();
         this.postForAll(var10001);
      } catch (SQLException var2) {
         this.onErrorVoidForAll(methodObject580, var2);
      }
   }

   public SQLWarning getWarnings() throws SQLException {
      try {
         super.preForAll(methodObject595, this, zeroLengthObjectArray);
         return (SQLWarning)this.postForAll(methodObject595, (Object)this.delegate.getWarnings());
      } catch (SQLException var2) {
         return (SQLWarning)this.postForAll(methodObject595, this.onErrorForAll(methodObject595, var2));
      }
   }

   public CLOB createClob(byte[] arg0, short arg1) throws SQLException {
      try {
         super.preForAll(methodObject353, this, arg0, arg1);
         return (CLOB)this.postForAll(methodObject353, (Object)this.delegate.createClob(arg0, arg1));
      } catch (SQLException var4) {
         return (CLOB)this.postForAll(methodObject353, this.onErrorForAll(methodObject353, var4));
      }
   }

   public void executeLightweightSessionPiggyback(int arg0, byte[] arg1, KeywordValueLong[] arg2, int arg3) throws SQLException {
      try {
         super.preForAll(methodObject364, this, arg0, arg1, arg2, arg3);
         Method var10001 = methodObject364;
         this.delegate.executeLightweightSessionPiggyback(arg0, arg1, arg2, arg3);
         this.postForAll(var10001);
      } catch (SQLException var6) {
         this.onErrorVoidForAll(methodObject364, var6);
      }
   }

   public Savepoint setSavepoint(String arg0) throws SQLException {
      try {
         super.preForAll(methodObject608, this, arg0);
         return (Savepoint)this.postForAll(methodObject608, this.proxyFactory.proxyForCache((Object)this.delegate.setSavepoint(arg0), this, this.proxyCache, methodObject608));
      } catch (SQLException var3) {
         return (Savepoint)this.postForAll(methodObject608, this.onErrorForAll(methodObject608, var3));
      }
   }

   public Map getJavaObjectTypeMap() {
      super.preForAll(methodObject289, this, zeroLengthObjectArray);
      return (Map)this.postForAll(methodObject289, (Object)this.delegate.getJavaObjectTypeMap());
   }

   public boolean getUse1900AsYearForTime() {
      super.preForAll(methodObject383, this, zeroLengthObjectArray);
      return (Boolean)this.postForAll(methodObject383, this.delegate.getUse1900AsYearForTime());
   }

   public DATE createDATE(Time arg0) throws SQLException {
      try {
         super.preForAll(methodObject505, this, arg0);
         return (DATE)this.postForAll(methodObject505, (Object)this.delegate.createDATE(arg0));
      } catch (SQLException var3) {
         return (DATE)this.postForAll(methodObject505, this.onErrorForAll(methodObject505, var3));
      }
   }

   public CLOB createClobWithUnpickledBytes(byte[] arg0) throws SQLException {
      try {
         super.preForAll(methodObject354, this, arg0);
         return (CLOB)this.postForAll(methodObject354, (Object)this.delegate.createClobWithUnpickledBytes(arg0));
      } catch (SQLException var3) {
         return (CLOB)this.postForAll(methodObject354, this.onErrorForAll(methodObject354, var3));
      }
   }

   public byte getInstanceProperty(OracleConnection.InstanceProperty arg0) throws SQLException {
      try {
         super.preForAll(methodObject291, this, arg0);
         return (Byte)this.postForAll(methodObject291, this.delegate.getInstanceProperty(arg0));
      } catch (SQLException var3) {
         return (Byte)this.postForAll(methodObject291, this.onErrorForAll(methodObject291, var3));
      }
   }

   public void abort(Executor arg0) throws SQLException {
      try {
         super.preForAll(methodObject565, this, arg0);
         Method var10001 = methodObject565;
         this.delegate.abort(arg0);
         this.postForAll(var10001);
      } catch (SQLException var3) {
         this.onErrorVoidForAll(methodObject565, var3);
      }
   }

   public Connection _getPC() {
      super.preForAll(methodObject475, this, zeroLengthObjectArray);
      return (Connection)this.postForAll(methodObject475, this.proxyFactory.proxyForCache((Object)this.delegate._getPC(), this, this.proxyCache, methodObject475));
   }

   public void detachServerConnection(String arg0) throws SQLException {
      try {
         super.preForAll(methodObject559, this, arg0);
         Method var10001 = methodObject559;
         this.delegate.detachServerConnection(arg0);
         this.postForAll(var10001);
      } catch (SQLException var3) {
         this.onErrorVoidForAll(methodObject559, var3);
      }
   }

   public void close() throws SQLException {
      try {
         super.preForClosure(methodObject562, this, zeroLengthObjectArray);
         Method var10001 = methodObject562;
         this.delegate.close();
         this.postForClosure(var10001);
      } catch (SQLException var2) {
         this.onErrorVoidForAll(methodObject562, var2);
      }
   }

   public long getTdoCState(String arg0, String arg1) throws SQLException {
      try {
         super.preForAll(methodObject308, this, arg0, arg1);
         return (Long)this.postForAll(methodObject308, this.delegate.getTdoCState(arg0, arg1));
      } catch (SQLException var4) {
         return (Long)this.postForAll(methodObject308, this.onErrorForAll(methodObject308, var4));
      }
   }

   public void startup(oracle.jdbc.OracleConnection.DatabaseStartupMode arg0) throws SQLException {
      try {
         super.preForAll(methodObject467, this, arg0);
         Method var10001 = methodObject467;
         this.delegate.startup(arg0);
         this.postForAll(var10001);
      } catch (SQLException var3) {
         this.onErrorVoidForAll(methodObject467, var3);
      }
   }

   public void setJavaObjectTypeMap(Map arg0) {
      super.preForAll(methodObject290, this, arg0);
      Method var10001 = methodObject290;
      this.delegate.setJavaObjectTypeMap(arg0);
      this.postForAll(var10001);
   }

   public String getDatabaseTimeZone() throws SQLException {
      try {
         super.preForAll(methodObject381, this, zeroLengthObjectArray);
         return (String)this.postForAll(methodObject381, (Object)this.delegate.getDatabaseTimeZone());
      } catch (SQLException var2) {
         return (String)this.postForAll(methodObject381, this.onErrorForAll(methodObject381, var2));
      }
   }

   public void setIncludeSynonyms(boolean arg0) {
      super.preForAll(methodObject449, this, arg0);
      Method var10001 = methodObject449;
      this.delegate.setIncludeSynonyms(arg0);
      this.postForAll(var10001);
   }

   public TIMESTAMP createTIMESTAMP(String arg0) throws SQLException {
      try {
         super.preForAll(methodObject527, this, arg0);
         return (TIMESTAMP)this.postForAll(methodObject527, (Object)this.delegate.createTIMESTAMP(arg0));
      } catch (SQLException var3) {
         return (TIMESTAMP)this.postForAll(methodObject527, this.onErrorForAll(methodObject527, var3));
      }
   }

   public Clob createClob() throws SQLException {
      try {
         super.preForAll(methodObject578, this, zeroLengthObjectArray);
         return (Clob)this.postForAll(methodObject578, this.proxyFactory.proxyForCache((Object)this.delegate.createClob(), this, this.proxyCache, methodObject578));
      } catch (SQLException var2) {
         return (Clob)this.postForAll(methodObject578, this.onErrorForAll(methodObject578, var2));
      }
   }

   public String nativeSQL(String arg0) throws SQLException {
      try {
         super.preForAll(methodObject597, this, arg0);
         return (String)this.postForAll(methodObject597, (Object)this.delegate.nativeSQL(arg0));
      } catch (SQLException var3) {
         return (String)this.postForAll(methodObject597, this.onErrorForAll(methodObject597, var3));
      }
   }

   public DATE createDATE(Time arg0, Calendar arg1) throws SQLException {
      try {
         super.preForAll(methodObject508, this, arg0, arg1);
         return (DATE)this.postForAll(methodObject508, (Object)this.delegate.createDATE(arg0, arg1));
      } catch (SQLException var4) {
         return (DATE)this.postForAll(methodObject508, this.onErrorForAll(methodObject508, var4));
      }
   }

   public void abort() throws SQLException {
      try {
         super.preForAbort(methodObject417, this, zeroLengthObjectArray);
         Method var10001 = methodObject417;
         this.delegate.abort();
         this.postForAbort(var10001);
      } catch (SQLException var2) {
         this.onErrorVoidForAll(methodObject417, var2);
      }
   }

   public Object getConnectionCacheCallbackPrivObj() throws SQLException {
      try {
         super.preForAll(methodObject349, this, zeroLengthObjectArray);
         return this.postForAll(methodObject349, this.proxyFactory.proxyForCache(this.delegate.getConnectionCacheCallbackPrivObj(), this, this.proxyCache, methodObject349));
      } catch (SQLException var2) {
         return this.postForAll(methodObject349, this.onErrorForAll(methodObject349, var2));
      }
   }

   public CallableStatement getCallWithKey(String arg0) throws SQLException {
      try {
         super.preForAll(methodObject463, this, arg0);
         return (CallableStatement)this.postForAll(methodObject463, this.proxyFactory.proxyForCache((Object)this.delegate.getCallWithKey(arg0), this, this.proxyCache, methodObject463));
      } catch (SQLException var3) {
         return (CallableStatement)this.postForAll(methodObject463, this.onErrorForAll(methodObject463, var3));
      }
   }

   public String getAuthenticationAdaptorName() throws SQLException {
      try {
         super.preForAll(methodObject547, this, zeroLengthObjectArray);
         return (String)this.postForAll(methodObject547, (Object)this.delegate.getAuthenticationAdaptorName());
      } catch (SQLException var2) {
         return (String)this.postForAll(methodObject547, this.onErrorForAll(methodObject547, var2));
      }
   }

   public Datum toDatum(CustomDatum arg0) throws SQLException {
      try {
         super.preForAll(methodObject312, this, arg0);
         return (Datum)this.postForAll(methodObject312, (Object)this.delegate.toDatum(arg0));
      } catch (SQLException var3) {
         return (Datum)this.postForAll(methodObject312, this.onErrorForAll(methodObject312, var3));
      }
   }

   public TIMESTAMPTZ createTIMESTAMPTZ(Timestamp arg0, Calendar arg1) throws SQLException {
      try {
         super.preForAll(methodObject533, this, arg0, arg1);
         return (TIMESTAMPTZ)this.postForAll(methodObject533, (Object)this.delegate.createTIMESTAMPTZ(arg0, arg1));
      } catch (SQLException var4) {
         return (TIMESTAMPTZ)this.postForAll(methodObject533, this.onErrorForAll(methodObject533, var4));
      }
   }

   public void doXSNamespaceOp(OracleConnection.XSOperationCode arg0, byte[] arg1, XSNamespace[] arg2, XSNamespace[][] arg3, XSSecureId arg4) throws SQLException {
      try {
         super.preForAll(methodObject365, this, arg0, arg1, arg2, arg3, arg4);
         Method var10001 = methodObject365;
         this.delegate.doXSNamespaceOp(arg0, arg1, arg2, arg3, arg4);
         this.postForAll(var10001);
      } catch (SQLException var7) {
         this.onErrorVoidForAll(methodObject365, var7);
      }
   }

   public boolean getBigEndian() throws SQLException {
      try {
         super.preForAll(methodObject301, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject301, this.delegate.getBigEndian());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject301, this.onErrorForAll(methodObject301, var2));
      }
   }

   public void endNonRequestCalls() throws SQLException {
      try {
         super.preForAll(methodObject392, this, zeroLengthObjectArray);
         Method var10001 = methodObject392;
         this.delegate.endNonRequestCalls();
         this.postForAll(var10001);
      } catch (SQLException var2) {
         this.onErrorVoidForAll(methodObject392, var2);
      }
   }

   public String getClientInfo(String arg0) throws SQLException {
      try {
         super.preForAll(methodObject588, this, arg0);
         return (String)this.postForAll(methodObject588, (Object)this.delegate.getClientInfo(arg0));
      } catch (SQLException var3) {
         return (String)this.postForAll(methodObject588, this.onErrorForAll(methodObject588, var3));
      }
   }

   public Properties getConnectionAttributes() throws SQLException {
      try {
         super.preForAll(methodObject486, this, zeroLengthObjectArray);
         return (Properties)this.postForAll(methodObject486, (Object)this.delegate.getConnectionAttributes());
      } catch (SQLException var2) {
         return (Properties)this.postForAll(methodObject486, this.onErrorForAll(methodObject486, var2));
      }
   }

   public ResultSetMetaData newStructMetaData(StructDescriptor arg0) throws SQLException {
      try {
         super.preForAll(methodObject319, this, arg0);
         return (ResultSetMetaData)this.postForAll(methodObject319, this.proxyFactory.proxyForCache((Object)this.delegate.newStructMetaData(arg0), this, this.proxyCache, methodObject319));
      } catch (SQLException var3) {
         return (ResultSetMetaData)this.postForAll(methodObject319, this.onErrorForAll(methodObject319, var3));
      }
   }

   public ARRAY createARRAY(String arg0, Object arg1) throws SQLException {
      try {
         super.preForAll(methodObject421, this, arg0, arg1);
         return (ARRAY)this.postForAll(methodObject421, (Object)super.createARRAY(arg0, arg1 instanceof _Proxy_ ? (Object)((_Proxy_)arg1)._getDelegate_() : arg1));
      } catch (SQLException var4) {
         return (ARRAY)this.postForAll(methodObject421, this.onErrorForAll(methodObject421, var4));
      }
   }

   public TIMESTAMPTZ createTIMESTAMPTZ(Date arg0) throws SQLException {
      try {
         super.preForAll(methodObject528, this, arg0);
         return (TIMESTAMPTZ)this.postForAll(methodObject528, (Object)this.delegate.createTIMESTAMPTZ(arg0));
      } catch (SQLException var3) {
         return (TIMESTAMPTZ)this.postForAll(methodObject528, this.onErrorForAll(methodObject528, var3));
      }
   }

   public void setChecksumMode(OracleConnection.ChecksumMode arg0) throws SQLException {
      try {
         super.preForAll(methodObject409, this, arg0);
         Method var10001 = methodObject409;
         this.delegate.setChecksumMode(arg0);
         this.postForAll(var10001);
      } catch (SQLException var3) {
         this.onErrorVoidForAll(methodObject409, var3);
      }
   }

   public void enqueue(String arg0, AQEnqueueOptions arg1, AQMessage arg2) throws SQLException {
      try {
         super.preForAll(methodObject413, this, arg0, arg1, arg2);
         Method var10001 = methodObject413;
         this.delegate.enqueue(arg0, arg1, arg2);
         this.postForAll(var10001);
      } catch (SQLException var5) {
         this.onErrorVoidForAll(methodObject413, var5);
      }
   }

   public void setAbandonedTimeoutEnabled(boolean arg0) throws SQLException {
      try {
         super.preForAll(methodObject344, this, arg0);
         Method var10001 = methodObject344;
         this.delegate.setAbandonedTimeoutEnabled(arg0);
         this.postForAll(var10001);
      } catch (SQLException var3) {
         this.onErrorVoidForAll(methodObject344, var3);
      }
   }

   public String getCatalog() throws SQLException {
      try {
         super.preForAll(methodObject587, this, zeroLengthObjectArray);
         return (String)this.postForAll(methodObject587, (Object)this.delegate.getCatalog());
      } catch (SQLException var2) {
         return (String)this.postForAll(methodObject587, this.onErrorForAll(methodObject587, var2));
      }
   }

   public EnumSet getTransactionState() throws SQLException {
      try {
         super.preForAll(methodObject387, this, zeroLengthObjectArray);
         return (EnumSet)this.postForAll(methodObject387, (Object)this.delegate.getTransactionState());
      } catch (SQLException var2) {
         return (EnumSet)this.postForAll(methodObject387, this.onErrorForAll(methodObject387, var2));
      }
   }

   public PreparedStatement prepareStatement(String arg0, int[] arg1) throws SQLException {
      try {
         super.preForStatementCreation(methodObject570, this, arg0, arg1);
         return (PreparedStatement)this.postForAll(methodObject570, this.proxyFactory.proxyForCache((Object)this.delegate.prepareStatement(arg0, arg1), this, this.proxyCache, methodObject570));
      } catch (SQLException var4) {
         return (PreparedStatement)this.postForAll(methodObject570, this.onErrorForAll(methodObject570, var4));
      }
   }

   public String getDatabaseProductVersion() throws SQLException {
      try {
         super.preForAll(methodObject287, this, zeroLengthObjectArray);
         return (String)this.postForAll(methodObject287, (Object)this.delegate.getDatabaseProductVersion());
      } catch (SQLException var2) {
         return (String)this.postForAll(methodObject287, this.onErrorForAll(methodObject287, var2));
      }
   }

   public NUMBER createNUMBER(String arg0, int arg1) throws SQLException {
      try {
         super.preForAll(methodObject522, this, arg0, arg1);
         return (NUMBER)this.postForAll(methodObject522, (Object)this.delegate.createNUMBER(arg0, arg1));
      } catch (SQLException var4) {
         return (NUMBER)this.postForAll(methodObject522, this.onErrorForAll(methodObject522, var4));
      }
   }

   public TypeDescriptor[] getTypeDescriptorsFromList(String[][] arg0) throws SQLException {
      try {
         super.preForAll(methodObject544, this, arg0);
         return (TypeDescriptor[])this.postForAll(methodObject544, (Object)this.delegate.getTypeDescriptorsFromList(arg0));
      } catch (SQLException var3) {
         return (TypeDescriptor[])this.postForAll(methodObject544, this.onErrorForAll(methodObject544, var3));
      }
   }

   public boolean getExplicitCachingEnabled() throws SQLException {
      try {
         super.preForAll(methodObject459, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject459, this.delegate.getExplicitCachingEnabled());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject459, this.onErrorForAll(methodObject459, var2));
      }
   }

   public PreparedStatement prepareStatement(String arg0, int arg1) throws SQLException {
      try {
         super.preForStatementCreation(methodObject569, this, arg0, arg1);
         return (PreparedStatement)this.postForAll(methodObject569, this.proxyFactory.proxyForCache((Object)this.delegate.prepareStatement(arg0, arg1), this, this.proxyCache, methodObject569));
      } catch (SQLException var4) {
         return (PreparedStatement)this.postForAll(methodObject569, this.onErrorForAll(methodObject569, var4));
      }
   }

   public void setRestrictGetTables(boolean arg0) {
      super.preForAll(methodObject451, this, arg0);
      Method var10001 = methodObject451;
      this.delegate.setRestrictGetTables(arg0);
      this.postForAll(var10001);
   }

   public String getCurrentSchema() throws SQLException {
      try {
         super.preForAll(methodObject438, this, zeroLengthObjectArray);
         return (String)this.postForAll(methodObject438, (Object)this.delegate.getCurrentSchema());
      } catch (SQLException var2) {
         return (String)this.postForAll(methodObject438, this.onErrorForAll(methodObject438, var2));
      }
   }

   public void clearAllApplicationContext(String arg0) throws SQLException {
      try {
         super.preForAll(methodObject552, this, arg0);
         Method var10001 = methodObject552;
         this.delegate.clearAllApplicationContext(arg0);
         this.postForAll(var10001);
      } catch (SQLException var3) {
         this.onErrorVoidForAll(methodObject552, var3);
      }
   }

   public void registerConnectionCacheCallback(OracleConnectionCacheCallback arg0, Object arg1, int arg2) throws SQLException {
      try {
         super.preForAll(methodObject488, this, arg0, arg1, arg2);
         Method var10001 = methodObject488;
         this.delegate.registerConnectionCacheCallback(arg0, arg1 instanceof _Proxy_ ? (Object)((_Proxy_)arg1)._getDelegate_() : arg1, arg2);
         this.postForAll(var10001);
      } catch (SQLException var5) {
         this.onErrorVoidForAll(methodObject488, var5);
      }
   }

   public OracleSavepoint oracleSetSavepoint() throws SQLException {
      try {
         super.preForAll(methodObject480, this, zeroLengthObjectArray);
         return (OracleSavepoint)this.postForAll(methodObject480, this.proxyFactory.proxyForCache((Object)this.delegate.oracleSetSavepoint(), this, this.proxyCache, methodObject480));
      } catch (SQLException var2) {
         return (OracleSavepoint)this.postForAll(methodObject480, this.onErrorForAll(methodObject480, var2));
      }
   }

   public short getDbCsId() throws SQLException {
      try {
         super.preForAll(methodObject313, this, zeroLengthObjectArray);
         return (Short)this.postForAll(methodObject313, this.delegate.getDbCsId());
      } catch (SQLException var2) {
         return (Short)this.postForAll(methodObject313, this.onErrorForAll(methodObject313, var2));
      }
   }

   public void ackJMSNotification(JMSNotificationRegistration arg0, byte[] arg1, JMSNotificationRegistration.Directive arg2) throws SQLException {
      try {
         super.preForAll(methodObject405, this, arg0, arg1, arg2);
         Method var10001 = methodObject405;
         this.delegate.ackJMSNotification(arg0, arg1, arg2);
         this.postForAll(var10001);
      } catch (SQLException var5) {
         this.onErrorVoidForAll(methodObject405, var5);
      }
   }

   public OracleStatement refCursorCursorToStatement(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject359, this, arg0);
         return (OracleStatement)this.postForAll(methodObject359, this.proxyFactory.proxyForCache((Object)this.delegate.refCursorCursorToStatement(arg0), this, this.proxyCache, methodObject359));
      } catch (SQLException var3) {
         return (OracleStatement)this.postForAll(methodObject359, this.onErrorForAll(methodObject359, var3));
      }
   }

   public void rollback(Savepoint arg0) throws SQLException {
      try {
         super.preForAll(methodObject600, this, arg0);
         Method var10001 = methodObject600;
         this.delegate.rollback(arg0 instanceof _Proxy_ ? (Savepoint)((_Proxy_)arg0)._getDelegate_() : arg0);
         this.postForAll(var10001);
      } catch (SQLException var3) {
         this.onErrorVoidForAll(methodObject600, var3);
      }
   }

   public void removeLogicalTransactionIdEventListener(LogicalTransactionIdEventListener arg0) throws SQLException {
      try {
         super.preForAll(methodObject555, this, arg0);
         Method var10001 = methodObject555;
         this.delegate.removeLogicalTransactionIdEventListener(arg0);
         this.postForAll(var10001);
      } catch (SQLException var3) {
         this.onErrorVoidForAll(methodObject555, var3);
      }
   }

   public Array createOracleArray(String arg0, Object arg1) throws SQLException {
      try {
         super.preForAll(methodObject422, this, arg0, arg1);
         return (Array)this.postForAll(methodObject422, this.proxyFactory.proxyForCache((Object)super.createOracleArray(arg0, arg1 instanceof _Proxy_ ? (Object)((_Proxy_)arg1)._getDelegate_() : arg1), this, this.proxyCache, methodObject422));
      } catch (SQLException var4) {
         return (Array)this.postForAll(methodObject422, this.onErrorForAll(methodObject422, var4));
      }
   }

   public boolean isStatementCacheInitialized() {
      super.preForAll(methodObject335, this, zeroLengthObjectArray);
      return (Boolean)this.postForAll(methodObject335, this.delegate.isStatementCacheInitialized());
   }

   public int javaCharsToCHARBytes(char[] arg0, int arg1, byte[] arg2) throws SQLException {
      try {
         super.preForAll(methodObject331, this, arg0, arg1, arg2);
         return (Integer)this.postForAll(methodObject331, this.delegate.javaCharsToCHARBytes(arg0, arg1, arg2));
      } catch (SQLException var5) {
         return (Integer)this.postForAll(methodObject331, this.onErrorForAll(methodObject331, var5));
      }
   }

   public boolean getMapDateToTimestamp() {
      super.preForAll(methodObject362, this, zeroLengthObjectArray);
      return (Boolean)this.postForAll(methodObject362, this.delegate.getMapDateToTimestamp());
   }

   public Array createArrayOf(String arg0, Object[] arg1) throws SQLException {
      try {
         super.preForAll(methodObject575, this, arg0, arg1);
         return (Array)this.postForAll(methodObject575, this.proxyFactory.proxyForCache((Object)super.createArrayOf(arg0, arg1), this, this.proxyCache, methodObject575));
      } catch (SQLException var4) {
         return (Array)this.postForAll(methodObject575, this.onErrorForAll(methodObject575, var4));
      }
   }

   public Blob createBlob() throws SQLException {
      try {
         super.preForAll(methodObject579, this, zeroLengthObjectArray);
         return (Blob)this.postForAll(methodObject579, this.proxyFactory.proxyForCache((Object)this.delegate.createBlob(), this, this.proxyCache, methodObject579));
      } catch (SQLException var2) {
         return (Blob)this.postForAll(methodObject579, this.onErrorForAll(methodObject579, var2));
      }
   }

   public PreparedStatement prepareStatement(String arg0, String[] arg1) throws SQLException {
      try {
         super.preForStatementCreation(methodObject571, this, arg0, arg1);
         return (PreparedStatement)this.postForAll(methodObject571, this.proxyFactory.proxyForCache((Object)this.delegate.prepareStatement(arg0, arg1), this, this.proxyCache, methodObject571));
      } catch (SQLException var4) {
         return (PreparedStatement)this.postForAll(methodObject571, this.onErrorForAll(methodObject571, var4));
      }
   }

   public int getMaxCharbyteSize() {
      super.preForAll(methodObject328, this, zeroLengthObjectArray);
      return (Integer)this.postForAll(methodObject328, this.delegate.getMaxCharbyteSize());
   }

   public short getVersionNumber() throws SQLException {
      try {
         super.preForAll(methodObject288, this, zeroLengthObjectArray);
         return (Short)this.postForAll(methodObject288, this.delegate.getVersionNumber());
      } catch (SQLException var2) {
         return (Short)this.postForAll(methodObject288, this.onErrorForAll(methodObject288, var2));
      }
   }

   public int NCHARBytesToJavaChars(byte[] arg0, int arg1, char[] arg2) throws SQLException {
      try {
         super.preForAll(methodObject322, this, arg0, arg1, arg2);
         return (Integer)this.postForAll(methodObject322, this.delegate.NCHARBytesToJavaChars(arg0, arg1, arg2));
      } catch (SQLException var5) {
         return (Integer)this.postForAll(methodObject322, this.onErrorForAll(methodObject322, var5));
      }
   }

   public PreparedStatement getStatementWithKey(String arg0) throws SQLException {
      try {
         super.preForAll(methodObject462, this, arg0);
         return (PreparedStatement)this.postForAll(methodObject462, this.proxyFactory.proxyForCache((Object)this.delegate.getStatementWithKey(arg0), this, this.proxyCache, methodObject462));
      } catch (SQLException var3) {
         return (PreparedStatement)this.postForAll(methodObject462, this.onErrorForAll(methodObject462, var3));
      }
   }

   public OracleConnection.BufferCacheStatistics getByteBufferCacheStatistics() {
      super.preForAll(methodObject310, this, zeroLengthObjectArray);
      return (OracleConnection.BufferCacheStatistics)this.postForAll(methodObject310, (Object)this.delegate.getByteBufferCacheStatistics());
   }

   public Properties getOCIHandles() throws SQLException {
      try {
         super.preForAll(methodObject286, this, zeroLengthObjectArray);
         return (Properties)this.postForAll(methodObject286, (Object)this.delegate.getOCIHandles());
      } catch (SQLException var2) {
         return (Properties)this.postForAll(methodObject286, this.onErrorForAll(methodObject286, var2));
      }
   }

   public Object getACProxy() {
      super.preForAll(methodObject614, this, zeroLengthObjectArray);
      return this.postForAll(methodObject614, this.proxyFactory.proxyForCache(this.delegate.getACProxy(), this, this.proxyCache, methodObject614));
   }

   public CallableStatement prepareCall(String arg0, int arg1, int arg2) throws SQLException {
      try {
         super.preForStatementCreation(methodObject573, this, arg0, arg1, arg2);
         return (CallableStatement)this.postForAll(methodObject573, this.proxyFactory.proxyForCache((Object)this.delegate.prepareCall(arg0, arg1, arg2), this, this.proxyCache, methodObject573));
      } catch (SQLException var5) {
         return (CallableStatement)this.postForAll(methodObject573, this.onErrorForAll(methodObject573, var5));
      }
   }

   public TIMESTAMPTZ createTIMESTAMPTZ(Timestamp arg0) throws SQLException {
      try {
         super.preForAll(methodObject532, this, arg0);
         return (TIMESTAMPTZ)this.postForAll(methodObject532, (Object)this.delegate.createTIMESTAMPTZ(arg0));
      } catch (SQLException var3) {
         return (TIMESTAMPTZ)this.postForAll(methodObject532, this.onErrorForAll(methodObject532, var3));
      }
   }

   public int javaCharsToNCHARBytes(char[] arg0, int arg1, byte[] arg2) throws SQLException {
      try {
         super.preForAll(methodObject332, this, arg0, arg1, arg2);
         return (Integer)this.postForAll(methodObject332, this.delegate.javaCharsToNCHARBytes(arg0, arg1, arg2));
      } catch (SQLException var5) {
         return (Integer)this.postForAll(methodObject332, this.onErrorForAll(methodObject332, var5));
      }
   }

   public boolean IsNCharFixedWith() {
      super.preForAll(methodObject324, this, zeroLengthObjectArray);
      return (Boolean)this.postForAll(methodObject324, this.delegate.IsNCharFixedWith());
   }

   public void setReplayingMode(boolean arg0) throws SQLException {
      try {
         super.preForAll(methodObject390, this, arg0);
         Method var10001 = methodObject390;
         this.delegate.setReplayingMode(arg0);
         this.postForAll(var10001);
      } catch (SQLException var3) {
         this.onErrorVoidForAll(methodObject390, var3);
      }
   }

   public String getProtocolType() {
      super.preForAll(methodObject338, this, zeroLengthObjectArray);
      return (String)this.postForAll(methodObject338, (Object)this.delegate.getProtocolType());
   }

   public Class classForNameAndSchema(String arg0, String arg1) throws ClassNotFoundException {
      super.preForAll(methodObject298, this, arg0, arg1);
      return (Class)this.postForAll(methodObject298, (Object)this.delegate.classForNameAndSchema(arg0, arg1));
   }

   public void setSessionTimeZone(String arg0) throws SQLException {
      try {
         super.preForAll(methodObject472, this, arg0);
         Method var10001 = methodObject472;
         this.delegate.setSessionTimeZone(arg0);
         this.postForAll(var10001);
      } catch (SQLException var3) {
         this.onErrorVoidForAll(methodObject472, var3);
      }
   }

   public String getSessionTimeZone() {
      super.preForAll(methodObject473, this, zeroLengthObjectArray);
      return (String)this.postForAll(methodObject473, (Object)this.delegate.getSessionTimeZone());
   }

   public PreparedStatement prepareStatement(String arg0, int arg1, int arg2, int arg3) throws SQLException {
      try {
         super.preForStatementCreation(methodObject568, this, arg0, arg1, arg2, arg3);
         return (PreparedStatement)this.postForAll(methodObject568, this.proxyFactory.proxyForCache((Object)this.delegate.prepareStatement(arg0, arg1, arg2, arg3), this, this.proxyCache, methodObject568));
      } catch (SQLException var6) {
         return (PreparedStatement)this.postForAll(methodObject568, this.onErrorForAll(methodObject568, var6));
      }
   }

   public boolean isUsable() {
      super.preForAll(methodObject548, this, zeroLengthObjectArray);
      return (Boolean)this.postForAll(methodObject548, this.delegate.isUsable());
   }

   public void doXSSessionDetachOp(int arg0, byte[] arg1, XSSecureId arg2, boolean arg3) throws SQLException {
      try {
         super.preForAll(methodObject370, this, arg0, arg1, arg2, arg3);
         Method var10001 = methodObject370;
         this.delegate.doXSSessionDetachOp(arg0, arg1, arg2, arg3);
         this.postForAll(var10001);
      } catch (SQLException var6) {
         this.onErrorVoidForAll(methodObject370, var6);
      }
   }

   public void unregisterDatabaseChangeNotification(DatabaseChangeRegistration arg0) throws SQLException {
      try {
         super.preForAll(methodObject498, this, arg0);
         Method var10001 = methodObject498;
         this.delegate.unregisterDatabaseChangeNotification(arg0);
         this.postForAll(var10001);
      } catch (SQLException var3) {
         this.onErrorVoidForAll(methodObject498, var3);
      }
   }

   public void setXAErrorFlag(boolean arg0) {
      super.preForAll(methodObject465, this, arg0);
      Method var10001 = methodObject465;
      this.delegate.setXAErrorFlag(arg0);
      this.postForAll(var10001);
   }

   public PreparedStatement prepareStatement(String arg0, int arg1, int arg2) throws SQLException {
      try {
         super.preForStatementCreation(methodObject567, this, arg0, arg1, arg2);
         return (PreparedStatement)this.postForAll(methodObject567, this.proxyFactory.proxyForCache((Object)this.delegate.prepareStatement(arg0, arg1, arg2), this, this.proxyCache, methodObject567));
      } catch (SQLException var5) {
         return (PreparedStatement)this.postForAll(methodObject567, this.onErrorForAll(methodObject567, var5));
      }
   }

   public long getCurrentSCN() throws SQLException {
      try {
         super.preForAll(methodObject386, this, zeroLengthObjectArray);
         return (Long)this.postForAll(methodObject386, this.delegate.getCurrentSCN());
      } catch (SQLException var2) {
         return (Long)this.postForAll(methodObject386, this.onErrorForAll(methodObject386, var2));
      }
   }

   public int getConnectionCacheCallbackFlag() throws SQLException {
      try {
         super.preForAll(methodObject350, this, zeroLengthObjectArray);
         return (Integer)this.postForAll(methodObject350, this.delegate.getConnectionCacheCallbackFlag());
      } catch (SQLException var2) {
         return (Integer)this.postForAll(methodObject350, this.onErrorForAll(methodObject350, var2));
      }
   }

   public OracleConnection _getDelegate_() {
      return this.delegate;
   }

   public Object getDelegate() {
      return this.delegate;
   }

   public void setDelegate(Object delegate) {
      this.proxyFactory.updateDelegate(this, this.delegate, delegate);
      this.delegate = (OracleConnection)delegate;
   }

   public Object getCreator() {
      return this.creator;
   }

   static {
      try {
         methodObject403 = OracleConnection.class.getDeclaredMethod("registerJMSNotification", String[].class, Map.class);
         methodObject348 = OracleConnection.class.getDeclaredMethod("getConnectionCacheCallbackObj");
         methodObject466 = oracle.jdbc.OracleConnection.class.getDeclaredMethod("startup", String.class, Integer.TYPE);
         methodObject470 = oracle.jdbc.OracleConnection.class.getDeclaredMethod("setCreateStatementAsRefCursor", Boolean.TYPE);
         methodObject549 = oracle.jdbc.OracleConnection.class.getDeclaredMethod("setDefaultTimeZone", TimeZone.class);
         methodObject458 = oracle.jdbc.OracleConnection.class.getDeclaredMethod("setExplicitCachingEnabled", Boolean.TYPE);
         methodObject606 = Connection.class.getDeclaredMethod("setNetworkTimeout", Executor.class, Integer.TYPE);
         methodObject373 = OracleConnection.class.getDeclaredMethod("setUsable", Boolean.TYPE);
         methodObject434 = oracle.jdbc.OracleConnection.class.getDeclaredMethod("getSQLType", Object.class);
         methodObject394 = OracleConnection.class.getDeclaredMethod("getLastReplayContext");
         methodObject464 = oracle.jdbc.OracleConnection.class.getDeclaredMethod("setUsingXAFlag", Boolean.TYPE);
         methodObject402 = OracleConnection.class.getDeclaredMethod("jmsDequeue", String.class, JMSDequeueOptions.class, String.class);
         methodObject607 = Connection.class.getDeclaredMethod("setSavepoint");
         methodObject444 = oracle.jdbc.OracleConnection.class.getDeclaredMethod("registerSQLType", String.class, String.class);
         methodObject425 = oracle.jdbc.OracleConnection.class.getDeclaredMethod("getAutoClose");
         methodObject561 = Connection.class.getDeclaredMethod("setReadOnly", Boolean.TYPE);
         methodObject416 = oracle.jdbc.OracleConnection.class.getDeclaredMethod("unwrap");
         methodObject399 = OracleConnection.class.getDeclaredMethod("getExecutingRPCSQL");
         methodObject539 = oracle.jdbc.OracleConnection.class.getDeclaredMethod("createTIMESTAMPLTZ", Timestamp.class, Calendar.class);
         methodObject520 = oracle.jdbc.OracleConnection.class.getDeclaredMethod("createNUMBER", BigDecimal.class);
         methodObject594 = Connection.class.getDeclaredMethod("getTransactionIsolation");
         methodObject476 = oracle.jdbc.OracleConnection.class.getDeclaredMethod("isLogicalConnection");
         methodObject340 = OracleConnection.class.getDeclaredMethod("setTxnMode", Integer.TYPE);
         methodObject432 = oracle.jdbc.OracleConnection.class.getDeclaredMethod("getJavaObject", String.class);
         methodObject609 = Connection.class.getDeclaredMethod("setSchema", String.class);
         methodObject320 = OracleConnection.class.getDeclaredMethod("getForm", OracleTypeADT.class, OracleTypeCLOB.class, Integer.TYPE);
         methodObject317 = OracleConnection.class.getDeclaredMethod("newArrayDataResultSet", ARRAY.class, Long.TYPE, Integer.TYPE, Map.class);
         methodObject582 = Connection.class.getDeclaredMethod("createSQLXML");
         methodObject400 = OracleConnection.class.getDeclaredMethod("jmsEnqueue", String.class, JMSEnqueueOptions.class, JMSMessage.class, AQMessageProperties.class);
         methodObject563 = Connection.class.getDeclaredMethod("isValid", Integer.TYPE);
         methodObject447 = oracle.jdbc.OracleConnection.class.getDeclaredMethod("setDefaultRowPrefetch", Integer.TYPE);
         methodObject611 = Wrapper.class.getDeclaredMethod("unwrap", Class.class);
         methodObject299 = OracleConnection.class.getDeclaredMethod("setFDO", byte[].class);
         methodObject445 = oracle.jdbc.OracleConnection.class.getDeclaredMethod("setAutoClose", Boolean.TYPE);
         methodObject546 = oracle.jdbc.OracleConnection.class.getDeclaredMethod("getEncryptionAlgorithmName");
         methodObject316 = OracleConnection.class.getDeclaredMethod("newArrayDataResultSet", Datum[].class, Long.TYPE, Integer.TYPE, Map.class);
         methodObject542 = oracle.jdbc.OracleConnection.class.getDeclaredMethod("getAllTypeDescriptorsInCurrentSchema");
         methodObject489 = oracle.jdbc.OracleConnection.class.getDeclaredMethod("setConnectionReleasePriority", Integer.TYPE);
         methodObject378 = OracleConnection.class.getDeclaredMethod("getTimezoneVersionNumber");
         methodObject452 = oracle.jdbc.OracleConnection.class.getDeclaredMethod("setStmtCacheSize", Integer.TYPE);
         methodObject512 = oracle.jdbc.OracleConnection.class.getDeclaredMethod("createINTERVALYM", String.class);
         methodObject478 = oracle.jdbc.OracleConnection.class.getDeclaredMethod("setWrapper", oracle.jdbc.OracleConnection.class);
         methodObject501 = oracle.jdbc.OracleConnection.class.getDeclaredMethod("unregisterDatabaseChangeNotification", Long.TYPE, String.class);
         methodObject300 = OracleConnection.class.getDeclaredMethod("getFDO", Boolean.TYPE);
         methodObject302 = OracleConnection.class.getDeclaredMethod("putDescriptor", byte[].class, Object.class);
         methodObject474 = oracle.jdbc.OracleConnection.class.getDeclaredMethod("getSessionTimeZoneOffset");
         methodObject589 = Connection.class.getDeclaredMethod("getClientInfo");
         methodObject612 = Wrapper.class.getDeclaredMethod("isWrapperFor", Class.class);
         methodObject283 = OracleConnection.class.getDeclaredMethod("getStructAttrNCsId");
         methodObject305 = OracleConnection.class.getDeclaredMethod("removeAllDescriptor");
         methodObject439 = oracle.jdbc.OracleConnection.class.getDeclaredMethod("getUsingXAFlag");
         methodObject511 = oracle.jdbc.OracleConnection.class.getDeclaredMethod("createINTERVALDS", String.class);
         methodObject479 = oracle.jdbc.OracleConnection.class.getDeclaredMethod("physicalConnectionWithin");
         methodObject495 = oracle.jdbc.OracleConnection.class.getDeclaredMethod("dequeue", String.class, AQDequeueOptions.class, String.class);
         methodObject304 = OracleConnection.class.getDeclaredMethod("removeDescriptor", String.class);
         methodObject297 = OracleConnection.class.getDeclaredMethod("getWrapper");
         methodObject613 = ACProxyable.class.getDeclaredMethod("setACProxy", Object.class);
         methodObject352 = OracleConnection.class.getDeclaredMethod("createClob", byte[].class);
         methodObject581 = Connection.class.getDeclaredMethod("clearWarnings");
         methodObject541 = oracle.jdbc.OracleConnection.class.getDeclaredMethod("createTIMESTAMPLTZ", DATE.class, Calendar.class);
         methodObject560 = oracle.jdbc.OracleConnection.class.getDeclaredMethod("needToPurgeStatementCache");
         methodObject446 = oracle.jdbc.OracleConnection.class.getDeclaredMethod("setDefaultExecuteBatch", Integer.TYPE);
         methodObject585 = Connection.class.getDeclaredMethod("createStatement", Integer.TYPE, Integer.TYPE, Integer.TYPE);
         methodObject329 = OracleConnection.class.getDeclaredMethod("getMaxNCharbyteSize");
         methodObject307 = OracleConnection.class.getDeclaredMethod("descriptorCacheKeys");
         methodObject583 = Connection.class.getDeclaredMethod("createStatement");
         methodObject604 = Connection.class.getDeclaredMethod("setClientInfo", Properties.class);
         methodObject468 = oracle.jdbc.OracleConnection.class.getDeclaredMethod("prepareStatementWithKey", String.class);
         methodObject534 = oracle.jdbc.OracleConnection.class.getDeclaredMethod("createTIMESTAMPTZ", String.class);
         methodObject591 = Connection.class.getDeclaredMethod("getMetaData");
         methodObject361 = OracleConnection.class.getDeclaredMethod("isV8Compatible");
         methodObject596 = Connection.class.getDeclaredMethod("isClosed");
         methodObject485 = oracle.jdbc.OracleConnection.class.getDeclaredMethod("applyConnectionAttributes", Properties.class);
         methodObject281 = OracleConnection.class.getDeclaredMethod("getURL");
         methodObject397 = OracleConnection.class.getDeclaredMethod("getDerivedKeyInternal", byte[].class, Integer.TYPE);
         methodObject380 = OracleConnection.class.getDeclaredMethod("getTIMEZONETAB");
         methodObject342 = OracleConnection.class.getDeclaredMethod("getHeapAllocSize");
         methodObject456 = oracle.jdbc.OracleConnection.class.getDeclaredMethod("setImplicitCachingEnabled", Boolean.TYPE);
         methodObject398 = OracleConnection.class.getDeclaredMethod("getExecutingRPCFunctionCode");
         methodObject371 = OracleConnection.class.getDeclaredMethod("doXSSessionChangeOp", OracleConnection.XSSessionSetOperationCode.class, byte[].class, XSSecureId.class, XSSessionParameters.class);
         methodObject536 = oracle.jdbc.OracleConnection.class.getDeclaredMethod("createTIMESTAMPTZ", DATE.class);
         methodObject593 = Connection.class.getDeclaredMethod("getSchema");
         methodObject454 = oracle.jdbc.OracleConnection.class.getDeclaredMethod("setStatementCacheSize", Integer.TYPE);
         methodObject610 = Connection.class.getDeclaredMethod("setTransactionIsolation", Integer.TYPE);
         methodObject502 = oracle.jdbc.OracleConnection.class.getDeclaredMethod("createBINARY_DOUBLE", Double.TYPE);
         methodObject436 = oracle.jdbc.OracleConnection.class.getDeclaredMethod("getStructAttrCsId");
         methodObject431 = oracle.jdbc.OracleConnection.class.getDeclaredMethod("getRestrictGetTables");
         methodObject487 = oracle.jdbc.OracleConnection.class.getDeclaredMethod("getUnMatchedConnectionAttributes");
         methodObject493 = oracle.jdbc.OracleConnection.class.getDeclaredMethod("unregisterAQNotification", AQNotificationRegistration.class);
         methodObject366 = OracleConnection.class.getDeclaredMethod("doXSNamespaceOp", OracleConnection.XSOperationCode.class, byte[].class, XSNamespace[].class, XSSecureId.class);
         methodObject442 = oracle.jdbc.OracleConnection.class.getDeclaredMethod("pingDatabase", Integer.TYPE);
         methodObject401 = OracleConnection.class.getDeclaredMethod("jmsDequeue", String.class, JMSDequeueOptions.class);
         methodObject415 = oracle.jdbc.OracleConnection.class.getDeclaredMethod("close", Integer.TYPE);
         methodObject374 = OracleConnection.class.getDeclaredMethod("getClassForType", String.class, Map.class);
         methodObject525 = oracle.jdbc.OracleConnection.class.getDeclaredMethod("createTIMESTAMP", Time.class);
         methodObject457 = oracle.jdbc.OracleConnection.class.getDeclaredMethod("getImplicitCachingEnabled");
         methodObject461 = oracle.jdbc.OracleConnection.class.getDeclaredMethod("purgeExplicitCache");
         methodObject448 = oracle.jdbc.OracleConnection.class.getDeclaredMethod("setEndToEndMetrics", String[].class, Short.TYPE);
         methodObject460 = oracle.jdbc.OracleConnection.class.getDeclaredMethod("purgeImplicitCache");
         methodObject418 = oracle.jdbc.OracleConnection.class.getDeclaredMethod("putDescriptor", String.class, Object.class);
         methodObject294 = OracleConnection.class.getDeclaredMethod("createClobDBAccess");
         methodObject363 = OracleConnection.class.getDeclaredMethod("createLightweightSession", String.class, KeywordValueLong[].class, Integer.TYPE, KeywordValueLong[][].class, int[].class);
         methodObject518 = oracle.jdbc.OracleConnection.class.getDeclaredMethod("createNUMBER", Float.TYPE);
         methodObject377 = OracleConnection.class.getDeclaredMethod("removeXSEventListener", XSEventListener.class);
         methodObject379 = OracleConnection.class.getDeclaredMethod("removeAllXSEventListener");
         methodObject337 = OracleConnection.class.getDeclaredMethod("setTypeMap", Map.class);
         methodObject602 = Connection.class.getDeclaredMethod("setCatalog", String.class);
         methodObject523 = oracle.jdbc.OracleConnection.class.getDeclaredMethod("createTIMESTAMP", Date.class);
         methodObject450 = oracle.jdbc.OracleConnection.class.getDeclaredMethod("setRemarksReporting", Boolean.TYPE);
         methodObject503 = oracle.jdbc.OracleConnection.class.getDeclaredMethod("createBINARY_FLOAT", Float.TYPE);
         methodObject412 = oracle.jdbc.OracleConnection.class.getDeclaredMethod("getProperties");
         methodObject513 = oracle.jdbc.OracleConnection.class.getDeclaredMethod("createNUMBER", Boolean.TYPE);
         methodObject396 = OracleConnection.class.getDeclaredMethod("getEOC");
         methodObject453 = oracle.jdbc.OracleConnection.class.getDeclaredMethod("setStmtCacheSize", Integer.TYPE, Boolean.TYPE);
         methodObject296 = OracleConnection.class.getDeclaredMethod("getDefaultFixedString");
         methodObject443 = oracle.jdbc.OracleConnection.class.getDeclaredMethod("registerSQLType", String.class, Class.class);
         methodObject393 = OracleConnection.class.getDeclaredMethod("getReplayContext");
         methodObject551 = oracle.jdbc.OracleConnection.class.getDeclaredMethod("setApplicationContext", String.class, String.class, String.class);
         methodObject592 = Connection.class.getDeclaredMethod("getNetworkTimeout");
         methodObject558 = oracle.jdbc.OracleConnection.class.getDeclaredMethod("attachServerConnection");
         methodObject572 = Connection.class.getDeclaredMethod("prepareCall", String.class);
         methodObject500 = oracle.jdbc.OracleConnection.class.getDeclaredMethod("unregisterDatabaseChangeNotification", Integer.TYPE);
         methodObject526 = oracle.jdbc.OracleConnection.class.getDeclaredMethod("createTIMESTAMP", Timestamp.class);
         methodObject369 = OracleConnection.class.getDeclaredMethod("doXSSessionAttachOp", Integer.TYPE, byte[].class, XSSecureId.class, byte[].class, XSPrincipal.class, String[].class, String[].class, String[].class, XSNamespace[].class, XSNamespace[].class, XSNamespace[].class, TIMESTAMPTZ.class, TIMESTAMPTZ.class, Integer.TYPE, Long.TYPE, XSKeyval.class, int[].class);
         methodObject303 = OracleConnection.class.getDeclaredMethod("getPhysicalConnection");
         methodObject576 = Connection.class.getDeclaredMethod("createStruct", String.class, Object[].class);
         methodObject605 = Connection.class.getDeclaredMethod("setHoldability", Integer.TYPE);
         methodObject477 = oracle.jdbc.OracleConnection.class.getDeclaredMethod("registerTAFCallback", OracleOCIFailover.class, Object.class);
         methodObject306 = OracleConnection.class.getDeclaredMethod("numberOfDescriptorCacheEntries");
         methodObject482 = oracle.jdbc.OracleConnection.class.getDeclaredMethod("oracleRollback", OracleSavepoint.class);
         methodObject471 = oracle.jdbc.OracleConnection.class.getDeclaredMethod("getCreateStatementAsRefCursor");
         methodObject566 = Connection.class.getDeclaredMethod("prepareStatement", String.class);
         methodObject282 = OracleConnection.class.getDeclaredMethod("getVarTypeMaxLenCompat");
         methodObject517 = oracle.jdbc.OracleConnection.class.getDeclaredMethod("createNUMBER", Long.TYPE);
         methodObject496 = oracle.jdbc.OracleConnection.class.getDeclaredMethod("registerDatabaseChangeNotification", Properties.class);
         methodObject515 = oracle.jdbc.OracleConnection.class.getDeclaredMethod("createNUMBER", Short.TYPE);
         methodObject334 = OracleConnection.class.getDeclaredMethod("getStartTime");
         methodObject514 = oracle.jdbc.OracleConnection.class.getDeclaredMethod("createNUMBER", Byte.TYPE);
         methodObject492 = oracle.jdbc.OracleConnection.class.getDeclaredMethod("registerAQNotification", String[].class, Properties[].class, Properties.class);
         methodObject385 = OracleConnection.class.getDeclaredMethod("isLobStreamPosStandardCompliant");
         methodObject360 = OracleConnection.class.getDeclaredMethod("getXAResource");
         methodObject406 = OracleConnection.class.getDeclaredMethod("getNegotiatedSDU");
         methodObject529 = oracle.jdbc.OracleConnection.class.getDeclaredMethod("createTIMESTAMPTZ", Date.class, Calendar.class);
         methodObject553 = oracle.jdbc.OracleConnection.class.getDeclaredMethod("addLogicalTransactionIdEventListener", LogicalTransactionIdEventListener.class);
         methodObject358 = OracleConnection.class.getDeclaredMethod("isDescriptorSharable", OracleConnection.class);
         methodObject455 = oracle.jdbc.OracleConnection.class.getDeclaredMethod("getStatementCacheSize");
         methodObject510 = oracle.jdbc.OracleConnection.class.getDeclaredMethod("createDATE", String.class);
         methodObject284 = OracleConnection.class.getDeclaredMethod("getTypeMap");
         methodObject524 = oracle.jdbc.OracleConnection.class.getDeclaredMethod("createTIMESTAMP", DATE.class);
         methodObject346 = OracleConnection.class.getDeclaredMethod("closeInternal", Boolean.TYPE);
         methodObject408 = OracleConnection.class.getDeclaredMethod("setPDBChangeEventListener", PDBChangeEventListener.class, Executor.class);
         methodObject285 = OracleConnection.class.getDeclaredMethod("getDBAccessProperties");
         methodObject419 = oracle.jdbc.OracleConnection.class.getDeclaredMethod("cancel");
         methodObject428 = oracle.jdbc.OracleConnection.class.getDeclaredMethod("getEndToEndMetrics");
         methodObject519 = oracle.jdbc.OracleConnection.class.getDeclaredMethod("createNUMBER", Double.TYPE);
         methodObject367 = OracleConnection.class.getDeclaredMethod("doXSSessionCreateOp", OracleConnection.XSSessionOperationCode.class, XSSecureId.class, byte[].class, XSPrincipal.class, String.class, XSNamespace[].class, OracleConnection.XSSessionModeFlag.class, XSKeyval.class);
         methodObject543 = oracle.jdbc.OracleConnection.class.getDeclaredMethod("getTypeDescriptorsFromListInCurrentSchema", String[].class);
         methodObject494 = oracle.jdbc.OracleConnection.class.getDeclaredMethod("dequeue", String.class, AQDequeueOptions.class, byte[].class);
         methodObject327 = OracleConnection.class.getDeclaredMethod("getMaxCharSize");
         methodObject550 = oracle.jdbc.OracleConnection.class.getDeclaredMethod("getDefaultTimeZone");
         methodObject315 = OracleConnection.class.getDeclaredMethod("getNCharSet");
         methodObject325 = OracleConnection.class.getDeclaredMethod("getDriverCharSet");
         methodObject382 = OracleConnection.class.getDeclaredMethod("getTimestamptzInGmt");
         methodObject388 = OracleConnection.class.getDeclaredMethod("isConnectionSocketKeepAlive");
         methodObject497 = oracle.jdbc.OracleConnection.class.getDeclaredMethod("getDatabaseChangeRegistration", Integer.TYPE);
         methodObject321 = OracleConnection.class.getDeclaredMethod("CHARBytesToJavaChars", byte[].class, Integer.TYPE, char[].class);
         methodObject574 = Connection.class.getDeclaredMethod("prepareCall", String.class, Integer.TYPE, Integer.TYPE, Integer.TYPE);
         methodObject557 = oracle.jdbc.OracleConnection.class.getDeclaredMethod("isDRCPEnabled");
         methodObject410 = oracle.jdbc.OracleConnection.class.getDeclaredMethod("shutdown", oracle.jdbc.OracleConnection.DatabaseShutdownMode.class);
         methodObject368 = OracleConnection.class.getDeclaredMethod("doXSSessionDestroyOp", byte[].class, XSSecureId.class, byte[].class);
         methodObject407 = OracleConnection.class.getDeclaredMethod("setPDBChangeEventListener", PDBChangeEventListener.class);
         methodObject433 = oracle.jdbc.OracleConnection.class.getDeclaredMethod("getRemarksReporting");
         methodObject441 = oracle.jdbc.OracleConnection.class.getDeclaredMethod("pingDatabase");
         methodObject490 = oracle.jdbc.OracleConnection.class.getDeclaredMethod("getConnectionReleasePriority");
         methodObject339 = OracleConnection.class.getDeclaredMethod("getLogicalConnection", OraclePooledConnection.class, Boolean.TYPE);
         methodObject598 = Connection.class.getDeclaredMethod("releaseSavepoint", Savepoint.class);
         methodObject440 = oracle.jdbc.OracleConnection.class.getDeclaredMethod("getXAErrorFlag");
         methodObject309 = OracleConnection.class.getDeclaredMethod("getTdoCState", String.class);
         methodObject584 = Connection.class.getDeclaredMethod("createStatement", Integer.TYPE, Integer.TYPE);
         methodObject333 = OracleConnection.class.getDeclaredMethod("setStartTime", Long.TYPE);
         methodObject372 = OracleConnection.class.getDeclaredMethod("getDefaultSchemaNameForNamedTypes");
         methodObject341 = OracleConnection.class.getDeclaredMethod("getTxnMode");
         methodObject437 = oracle.jdbc.OracleConnection.class.getDeclaredMethod("getUserName");
         methodObject356 = OracleConnection.class.getDeclaredMethod("createBlobWithUnpickledBytes", byte[].class);
         methodObject540 = oracle.jdbc.OracleConnection.class.getDeclaredMethod("createTIMESTAMPLTZ", String.class, Calendar.class);
         methodObject469 = oracle.jdbc.OracleConnection.class.getDeclaredMethod("prepareCallWithKey", String.class);
         methodObject491 = oracle.jdbc.OracleConnection.class.getDeclaredMethod("setPlsqlWarnings", String.class);
         methodObject577 = Connection.class.getDeclaredMethod("createNClob");
         methodObject484 = oracle.jdbc.OracleConnection.class.getDeclaredMethod("isProxySession");
         methodObject483 = oracle.jdbc.OracleConnection.class.getDeclaredMethod("oracleReleaseSavepoint", OracleSavepoint.class);
         methodObject323 = OracleConnection.class.getDeclaredMethod("setReplayContext", ReplayContext[].class);
         methodObject586 = Connection.class.getDeclaredMethod("getAutoCommit");
         methodObject376 = OracleConnection.class.getDeclaredMethod("addXSEventListener", XSEventListener.class, Executor.class);
         methodObject404 = OracleConnection.class.getDeclaredMethod("unregisterJMSNotification", JMSNotificationRegistration.class);
         methodObject336 = OracleConnection.class.getDeclaredMethod("getPropertyForPooledConnection", OraclePooledConnection.class);
         methodObject554 = oracle.jdbc.OracleConnection.class.getDeclaredMethod("addLogicalTransactionIdEventListener", LogicalTransactionIdEventListener.class, Executor.class);
         methodObject314 = OracleConnection.class.getDeclaredMethod("getJdbcCsId");
         methodObject590 = Connection.class.getDeclaredMethod("getHoldability");
         methodObject509 = oracle.jdbc.OracleConnection.class.getDeclaredMethod("createDATE", Timestamp.class, Calendar.class);
         methodObject535 = oracle.jdbc.OracleConnection.class.getDeclaredMethod("createTIMESTAMPTZ", String.class, Calendar.class);
         methodObject311 = OracleConnection.class.getDeclaredMethod("getCharBufferCacheStatistics");
         methodObject599 = Connection.class.getDeclaredMethod("rollback");
         methodObject521 = oracle.jdbc.OracleConnection.class.getDeclaredMethod("createNUMBER", BigInteger.class);
         methodObject391 = OracleConnection.class.getDeclaredMethod("beginNonRequestCalls");
         methodObject530 = oracle.jdbc.OracleConnection.class.getDeclaredMethod("createTIMESTAMPTZ", Time.class);
         methodObject411 = oracle.jdbc.OracleConnection.class.getDeclaredMethod("getDescriptor", String.class);
         methodObject537 = oracle.jdbc.OracleConnection.class.getDeclaredMethod("createTIMESTAMPLTZ", Date.class, Calendar.class);
         methodObject531 = oracle.jdbc.OracleConnection.class.getDeclaredMethod("createTIMESTAMPTZ", Time.class, Calendar.class);
         methodObject384 = OracleConnection.class.getDeclaredMethod("isDataInLocatorEnabled");
         methodObject330 = OracleConnection.class.getDeclaredMethod("isCharSetMultibyte", Short.TYPE);
         methodObject430 = oracle.jdbc.OracleConnection.class.getDeclaredMethod("getIncludeSynonyms");
         methodObject481 = oracle.jdbc.OracleConnection.class.getDeclaredMethod("oracleSetSavepoint", String.class);
         methodObject343 = OracleConnection.class.getDeclaredMethod("getOCIEnvHeapAllocSize");
         methodObject507 = oracle.jdbc.OracleConnection.class.getDeclaredMethod("createDATE", Date.class, Calendar.class);
         methodObject499 = oracle.jdbc.OracleConnection.class.getDeclaredMethod("unregisterDatabaseChangeNotification", Integer.TYPE, String.class, Integer.TYPE);
         methodObject506 = oracle.jdbc.OracleConnection.class.getDeclaredMethod("createDATE", Timestamp.class);
         methodObject426 = oracle.jdbc.OracleConnection.class.getDeclaredMethod("getDefaultExecuteBatch");
         methodObject293 = OracleConnection.class.getDeclaredMethod("createBlobDBAccess");
         methodObject601 = Connection.class.getDeclaredMethod("setAutoCommit", Boolean.TYPE);
         methodObject556 = oracle.jdbc.OracleConnection.class.getDeclaredMethod("getLogicalTransactionId");
         methodObject351 = OracleConnection.class.getDeclaredMethod("getServerSessionInfo");
         methodObject295 = OracleConnection.class.getDeclaredMethod("setDefaultFixedString", Boolean.TYPE);
         methodObject355 = OracleConnection.class.getDeclaredMethod("createBlob", byte[].class);
         methodObject345 = OracleConnection.class.getDeclaredMethod("getHeartbeatNoChangeCount");
         methodObject347 = OracleConnection.class.getDeclaredMethod("cleanupAndClose", Boolean.TYPE);
         methodObject424 = oracle.jdbc.OracleConnection.class.getDeclaredMethod("archive", Integer.TYPE, Integer.TYPE, String.class);
         methodObject423 = oracle.jdbc.OracleConnection.class.getDeclaredMethod("commit", EnumSet.class);
         methodObject564 = Connection.class.getDeclaredMethod("isReadOnly");
         methodObject375 = OracleConnection.class.getDeclaredMethod("addXSEventListener", XSEventListener.class);
         methodObject427 = oracle.jdbc.OracleConnection.class.getDeclaredMethod("getDefaultRowPrefetch");
         methodObject395 = OracleConnection.class.getDeclaredMethod("registerEndReplayCallback", OracleConnection.EndReplayCallback.class);
         methodObject389 = OracleConnection.class.getDeclaredMethod("setReplayOperations", EnumSet.class);
         methodObject318 = OracleConnection.class.getDeclaredMethod("newArrayLocatorResultSet", ArrayDescriptor.class, byte[].class, Long.TYPE, Integer.TYPE, Map.class);
         methodObject545 = oracle.jdbc.OracleConnection.class.getDeclaredMethod("getDataIntegrityAlgorithmName");
         methodObject504 = oracle.jdbc.OracleConnection.class.getDeclaredMethod("createDATE", Date.class);
         methodObject603 = Connection.class.getDeclaredMethod("setClientInfo", String.class, String.class);
         methodObject326 = OracleConnection.class.getDeclaredMethod("getC2SNlsRatio");
         methodObject280 = OracleConnection.class.getDeclaredMethod("getDescriptor", byte[].class);
         methodObject414 = oracle.jdbc.OracleConnection.class.getDeclaredMethod("close", Properties.class);
         methodObject516 = oracle.jdbc.OracleConnection.class.getDeclaredMethod("createNUMBER", Integer.TYPE);
         methodObject429 = oracle.jdbc.OracleConnection.class.getDeclaredMethod("getEndToEndECIDSequenceNumber");
         methodObject420 = oracle.jdbc.OracleConnection.class.getDeclaredMethod("openProxySession", Integer.TYPE, Properties.class);
         methodObject292 = OracleConnection.class.getDeclaredMethod("createBfileDBAccess");
         methodObject435 = oracle.jdbc.OracleConnection.class.getDeclaredMethod("getStmtCacheSize");
         methodObject538 = oracle.jdbc.OracleConnection.class.getDeclaredMethod("createTIMESTAMPLTZ", Time.class, Calendar.class);
         methodObject357 = OracleConnection.class.getDeclaredMethod("createBfile", byte[].class);
         methodObject580 = Connection.class.getDeclaredMethod("commit");
         methodObject595 = Connection.class.getDeclaredMethod("getWarnings");
         methodObject353 = OracleConnection.class.getDeclaredMethod("createClob", byte[].class, Short.TYPE);
         methodObject364 = OracleConnection.class.getDeclaredMethod("executeLightweightSessionPiggyback", Integer.TYPE, byte[].class, KeywordValueLong[].class, Integer.TYPE);
         methodObject608 = Connection.class.getDeclaredMethod("setSavepoint", String.class);
         methodObject289 = OracleConnection.class.getDeclaredMethod("getJavaObjectTypeMap");
         methodObject383 = OracleConnection.class.getDeclaredMethod("getUse1900AsYearForTime");
         methodObject505 = oracle.jdbc.OracleConnection.class.getDeclaredMethod("createDATE", Time.class);
         methodObject354 = OracleConnection.class.getDeclaredMethod("createClobWithUnpickledBytes", byte[].class);
         methodObject291 = OracleConnection.class.getDeclaredMethod("getInstanceProperty", OracleConnection.InstanceProperty.class);
         methodObject565 = Connection.class.getDeclaredMethod("abort", Executor.class);
         methodObject475 = oracle.jdbc.OracleConnection.class.getDeclaredMethod("_getPC");
         methodObject559 = oracle.jdbc.OracleConnection.class.getDeclaredMethod("detachServerConnection", String.class);
         methodObject562 = Connection.class.getDeclaredMethod("close");
         methodObject308 = OracleConnection.class.getDeclaredMethod("getTdoCState", String.class, String.class);
         methodObject467 = oracle.jdbc.OracleConnection.class.getDeclaredMethod("startup", oracle.jdbc.OracleConnection.DatabaseStartupMode.class);
         methodObject290 = OracleConnection.class.getDeclaredMethod("setJavaObjectTypeMap", Map.class);
         methodObject381 = OracleConnection.class.getDeclaredMethod("getDatabaseTimeZone");
         methodObject449 = oracle.jdbc.OracleConnection.class.getDeclaredMethod("setIncludeSynonyms", Boolean.TYPE);
         methodObject527 = oracle.jdbc.OracleConnection.class.getDeclaredMethod("createTIMESTAMP", String.class);
         methodObject578 = Connection.class.getDeclaredMethod("createClob");
         methodObject597 = Connection.class.getDeclaredMethod("nativeSQL", String.class);
         methodObject508 = oracle.jdbc.OracleConnection.class.getDeclaredMethod("createDATE", Time.class, Calendar.class);
         methodObject417 = oracle.jdbc.OracleConnection.class.getDeclaredMethod("abort");
         methodObject349 = OracleConnection.class.getDeclaredMethod("getConnectionCacheCallbackPrivObj");
         methodObject463 = oracle.jdbc.OracleConnection.class.getDeclaredMethod("getCallWithKey", String.class);
         methodObject547 = oracle.jdbc.OracleConnection.class.getDeclaredMethod("getAuthenticationAdaptorName");
         methodObject312 = OracleConnection.class.getDeclaredMethod("toDatum", CustomDatum.class);
         methodObject533 = oracle.jdbc.OracleConnection.class.getDeclaredMethod("createTIMESTAMPTZ", Timestamp.class, Calendar.class);
         methodObject365 = OracleConnection.class.getDeclaredMethod("doXSNamespaceOp", OracleConnection.XSOperationCode.class, byte[].class, XSNamespace[].class, XSNamespace[][].class, XSSecureId.class);
         methodObject301 = OracleConnection.class.getDeclaredMethod("getBigEndian");
         methodObject392 = OracleConnection.class.getDeclaredMethod("endNonRequestCalls");
         methodObject588 = Connection.class.getDeclaredMethod("getClientInfo", String.class);
         methodObject486 = oracle.jdbc.OracleConnection.class.getDeclaredMethod("getConnectionAttributes");
         methodObject319 = OracleConnection.class.getDeclaredMethod("newStructMetaData", StructDescriptor.class);
         methodObject421 = oracle.jdbc.OracleConnection.class.getDeclaredMethod("createARRAY", String.class, Object.class);
         methodObject528 = oracle.jdbc.OracleConnection.class.getDeclaredMethod("createTIMESTAMPTZ", Date.class);
         methodObject409 = OracleConnection.class.getDeclaredMethod("setChecksumMode", OracleConnection.ChecksumMode.class);
         methodObject413 = oracle.jdbc.OracleConnection.class.getDeclaredMethod("enqueue", String.class, AQEnqueueOptions.class, AQMessage.class);
         methodObject344 = OracleConnection.class.getDeclaredMethod("setAbandonedTimeoutEnabled", Boolean.TYPE);
         methodObject587 = Connection.class.getDeclaredMethod("getCatalog");
         methodObject387 = OracleConnection.class.getDeclaredMethod("getTransactionState");
         methodObject570 = Connection.class.getDeclaredMethod("prepareStatement", String.class, int[].class);
         methodObject287 = OracleConnection.class.getDeclaredMethod("getDatabaseProductVersion");
         methodObject522 = oracle.jdbc.OracleConnection.class.getDeclaredMethod("createNUMBER", String.class, Integer.TYPE);
         methodObject544 = oracle.jdbc.OracleConnection.class.getDeclaredMethod("getTypeDescriptorsFromList", String[][].class);
         methodObject459 = oracle.jdbc.OracleConnection.class.getDeclaredMethod("getExplicitCachingEnabled");
         methodObject569 = Connection.class.getDeclaredMethod("prepareStatement", String.class, Integer.TYPE);
         methodObject451 = oracle.jdbc.OracleConnection.class.getDeclaredMethod("setRestrictGetTables", Boolean.TYPE);
         methodObject438 = oracle.jdbc.OracleConnection.class.getDeclaredMethod("getCurrentSchema");
         methodObject552 = oracle.jdbc.OracleConnection.class.getDeclaredMethod("clearAllApplicationContext", String.class);
         methodObject488 = oracle.jdbc.OracleConnection.class.getDeclaredMethod("registerConnectionCacheCallback", OracleConnectionCacheCallback.class, Object.class, Integer.TYPE);
         methodObject480 = oracle.jdbc.OracleConnection.class.getDeclaredMethod("oracleSetSavepoint");
         methodObject313 = OracleConnection.class.getDeclaredMethod("getDbCsId");
         methodObject405 = OracleConnection.class.getDeclaredMethod("ackJMSNotification", JMSNotificationRegistration.class, byte[].class, JMSNotificationRegistration.Directive.class);
         methodObject359 = OracleConnection.class.getDeclaredMethod("refCursorCursorToStatement", Integer.TYPE);
         methodObject600 = Connection.class.getDeclaredMethod("rollback", Savepoint.class);
         methodObject555 = oracle.jdbc.OracleConnection.class.getDeclaredMethod("removeLogicalTransactionIdEventListener", LogicalTransactionIdEventListener.class);
         methodObject422 = oracle.jdbc.OracleConnection.class.getDeclaredMethod("createOracleArray", String.class, Object.class);
         methodObject335 = OracleConnection.class.getDeclaredMethod("isStatementCacheInitialized");
         methodObject331 = OracleConnection.class.getDeclaredMethod("javaCharsToCHARBytes", char[].class, Integer.TYPE, byte[].class);
         methodObject362 = OracleConnection.class.getDeclaredMethod("getMapDateToTimestamp");
         methodObject575 = Connection.class.getDeclaredMethod("createArrayOf", String.class, Object[].class);
         methodObject579 = Connection.class.getDeclaredMethod("createBlob");
         methodObject571 = Connection.class.getDeclaredMethod("prepareStatement", String.class, String[].class);
         methodObject328 = OracleConnection.class.getDeclaredMethod("getMaxCharbyteSize");
         methodObject288 = OracleConnection.class.getDeclaredMethod("getVersionNumber");
         methodObject322 = OracleConnection.class.getDeclaredMethod("NCHARBytesToJavaChars", byte[].class, Integer.TYPE, char[].class);
         methodObject462 = oracle.jdbc.OracleConnection.class.getDeclaredMethod("getStatementWithKey", String.class);
         methodObject310 = OracleConnection.class.getDeclaredMethod("getByteBufferCacheStatistics");
         methodObject286 = OracleConnection.class.getDeclaredMethod("getOCIHandles");
         methodObject614 = ACProxyable.class.getDeclaredMethod("getACProxy");
         methodObject573 = Connection.class.getDeclaredMethod("prepareCall", String.class, Integer.TYPE, Integer.TYPE);
         methodObject532 = oracle.jdbc.OracleConnection.class.getDeclaredMethod("createTIMESTAMPTZ", Timestamp.class);
         methodObject332 = OracleConnection.class.getDeclaredMethod("javaCharsToNCHARBytes", char[].class, Integer.TYPE, byte[].class);
         methodObject324 = OracleConnection.class.getDeclaredMethod("IsNCharFixedWith");
         methodObject390 = OracleConnection.class.getDeclaredMethod("setReplayingMode", Boolean.TYPE);
         methodObject338 = OracleConnection.class.getDeclaredMethod("getProtocolType");
         methodObject298 = OracleConnection.class.getDeclaredMethod("classForNameAndSchema", String.class, String.class);
         methodObject472 = oracle.jdbc.OracleConnection.class.getDeclaredMethod("setSessionTimeZone", String.class);
         methodObject473 = oracle.jdbc.OracleConnection.class.getDeclaredMethod("getSessionTimeZone");
         methodObject568 = Connection.class.getDeclaredMethod("prepareStatement", String.class, Integer.TYPE, Integer.TYPE, Integer.TYPE);
         methodObject548 = oracle.jdbc.OracleConnection.class.getDeclaredMethod("isUsable");
         methodObject370 = OracleConnection.class.getDeclaredMethod("doXSSessionDetachOp", Integer.TYPE, byte[].class, XSSecureId.class, Boolean.TYPE);
         methodObject498 = oracle.jdbc.OracleConnection.class.getDeclaredMethod("unregisterDatabaseChangeNotification", DatabaseChangeRegistration.class);
         methodObject465 = oracle.jdbc.OracleConnection.class.getDeclaredMethod("setXAErrorFlag", Boolean.TYPE);
         methodObject567 = Connection.class.getDeclaredMethod("prepareStatement", String.class, Integer.TYPE, Integer.TYPE);
         methodObject386 = OracleConnection.class.getDeclaredMethod("getCurrentSCN");
         methodObject350 = OracleConnection.class.getDeclaredMethod("getConnectionCacheCallbackFlag");
      } catch (Throwable var1) {
         throw new RuntimeException(var1);
      }
   }

   public oracle$1jdbc$1replay$1driver$1TxnReplayableConnection$2oracle$1jdbc$1internal$1OracleConnection$$$Proxy(OracleConnection var1, Object var2, ProxyFactory var3, Map var4) {
      this.delegate = var1;
      this.creator = var2;
      this.proxyFactory = var3;
      this.proxyCache = var4;
   }
}
