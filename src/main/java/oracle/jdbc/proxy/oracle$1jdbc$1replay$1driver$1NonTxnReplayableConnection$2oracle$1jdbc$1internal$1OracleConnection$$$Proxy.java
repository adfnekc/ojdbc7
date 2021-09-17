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
import oracle.jdbc.replay.driver.NonTxnReplayableConnection;
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

public abstract class oracle$1jdbc$1replay$1driver$1NonTxnReplayableConnection$2oracle$1jdbc$1internal$1OracleConnection$$$Proxy extends NonTxnReplayableConnection implements OracleConnection, _Proxy_ {
   private OracleConnection delegate;
   private final Object creator;
   private final ProxyFactory proxyFactory;
   private final Map proxyCache;
   private static Object[] zeroLengthObjectArray = new Object[0];
   private static Method methodObject30818;
   private static Method methodObject30758;
   private static Method methodObject30735;
   private static Method methodObject30775;
   private static Method methodObject30822;
   private static Method methodObject30961;
   private static Method methodObject30703;
   private static Method methodObject30866;
   private static Method methodObject30719;
   private static Method methodObject30700;
   private static Method methodObject30877;
   private static Method methodObject30682;
   private static Method methodObject30962;
   private static Method methodObject30692;
   private static Method methodObject30663;
   private static Method methodObject30933;
   private static Method methodObject30795;
   private static Method methodObject30780;
   private static Method methodObject30721;
   private static Method methodObject30697;
   private static Method methodObject30974;
   private static Method methodObject30681;
   private static Method methodObject30845;
   private static Method methodObject30734;
   private static Method methodObject30865;
   private static Method methodObject30749;
   private static Method methodObject30742;
   private static Method methodObject30839;
   private static Method methodObject30783;
   private static Method methodObject30817;
   private static Method methodObject30891;
   private static Method methodObject30673;
   private static Method methodObject30782;
   private static Method methodObject30838;
   private static Method methodObject30941;
   private static Method methodObject30878;
   private static Method methodObject30910;
   private static Method methodObject30743;
   private static Method methodObject30906;
   private static Method methodObject30762;
   private static Method methodObject30934;
   private static Method methodObject30813;
   private static Method methodObject30890;
   private static Method methodObject30727;
   private static Method methodObject30709;
   private static Method methodObject30844;
   private static Method methodObject30972;
   private static Method methodObject30651;
   private static Method methodObject30669;
   private static Method methodObject30680;
   private static Method methodObject30809;
   private static Method methodObject30960;
   private static Method methodObject30945;
   private static Method methodObject30705;
   private static Method methodObject30792;
   private static Method methodObject30657;
   private static Method methodObject30686;
   private static Method methodObject30710;
   private static Method methodObject30969;
   private static Method methodObject30658;
   private static Method methodObject30924;
   private static Method methodObject30718;
   private static Method methodObject30882;
   private static Method methodObject30752;
   private static Method methodObject30915;
   private static Method methodObject30671;
   private static Method methodObject30857;
   private static Method methodObject30693;
   private static Method methodObject30942;
   private static Method methodObject30701;
   private static Method methodObject30957;
   private static Method methodObject30745;
   private static Method methodObject30823;
   private static Method methodObject30887;
   private static Method methodObject30885;
   private static Method methodObject30870;
   private static Method methodObject30833;
   private static Method methodObject30955;
   private static Method methodObject30695;
   private static Method methodObject30661;
   private static Method methodObject30645;
   private static Method methodObject30764;
   private static Method methodObject30729;
   private static Method methodObject30696;
   private static Method methodObject30747;
   private static Method methodObject30707;
   private static Method methodObject30956;
   private static Method methodObject30943;
   private static Method methodObject30712;
   private static Method methodObject30880;
   private static Method methodObject30806;
   private static Method methodObject30801;
   private static Method methodObject30851;
   private static Method methodObject30863;
   private static Method methodObject30881;
   private static Method methodObject30977;
   private static Method methodObject30946;
   private static Method methodObject30862;
   private static Method methodObject30849;
   private static Method methodObject30913;
   private static Method methodObject30774;
   private static Method methodObject30824;
   private static Method methodObject30827;
   private static Method methodObject30831;
   private static Method methodObject30893;
   private static Method methodObject30830;
   private static Method methodObject30660;
   private static Method methodObject30741;
   private static Method methodObject30892;
   private static Method methodObject30763;
   private static Method methodObject30898;
   private static Method methodObject30731;
   private static Method methodObject30903;
   private static Method methodObject30949;
   private static Method methodObject30896;
   private static Method methodObject30836;
   private static Method methodObject30832;
   private static Method methodObject30776;
   private static Method methodObject30868;
   private static Method methodObject30754;
   private static Method methodObject30694;
   private static Method methodObject30648;
   private static Method methodObject30894;
   private static Method methodObject30888;
   private static Method methodObject30662;
   private static Method methodObject30691;
   private static Method methodObject30968;
   private static Method methodObject30922;
   private static Method methodObject30950;
   private static Method methodObject30900;
   private static Method methodObject30917;
   private static Method methodObject30685;
   private static Method methodObject30828;
   private static Method methodObject30670;
   private static Method methodObject30841;
   private static Method methodObject30927;
   private static Method methodObject30650;
   private static Method methodObject30916;
   private static Method methodObject30959;
   private static Method methodObject30947;
   private static Method methodObject30690;
   private static Method methodObject30873;
   private static Method methodObject30755;
   private static Method methodObject30723;
   private static Method methodObject30975;
   private static Method methodObject30676;
   private static Method methodObject30769;
   private static Method methodObject30861;
   private static Method methodObject30704;
   private static Method methodObject30744;
   private static Method methodObject30964;
   private static Method methodObject30815;
   private static Method methodObject30971;
   private static Method methodObject30814;
   private static Method methodObject30794;
   private static Method methodObject30889;
   private static Method methodObject30825;
   private static Method methodObject30757;
   private static Method methodObject30708;
   private static Method methodObject30786;
   private static Method methodObject30859;
   private static Method methodObject30652;
   private static Method methodObject30787;
   private static Method methodObject30798;
   private static Method methodObject30778;
   private static Method methodObject30761;
   private static Method methodObject30925;
   private static Method methodObject30948;
   private static Method methodObject30716;
   private static Method methodObject30951;
   private static Method methodObject30914;
   private static Method methodObject30875;
   private static Method methodObject30714;
   private static Method methodObject30679;
   private static Method methodObject30766;
   private static Method methodObject30770;
   private static Method methodObject30664;
   private static Method methodObject30921;
   private static Method methodObject30803;
   private static Method methodObject30820;
   private static Method methodObject30904;
   private static Method methodObject30811;
   private static Method methodObject30854;
   private static Method methodObject30810;
   private static Method methodObject30937;
   private static Method methodObject30756;
   private static Method methodObject30728;
   private static Method methodObject30699;
   private static Method methodObject30807;
   private static Method methodObject30902;
   private static Method methodObject30759;
   private static Method methodObject30816;
   private static Method methodObject30802;
   private static Method methodObject30940;
   private static Method methodObject30848;
   private static Method methodObject30970;
   private static Method methodObject30932;
   private static Method methodObject30837;
   private static Method methodObject30678;
   private static Method methodObject30973;
   private static Method methodObject30897;
   private static Method methodObject30846;
   private static Method methodObject30668;
   private static Method methodObject30675;
   private static Method methodObject30777;
   private static Method methodObject30931;
   private static Method methodObject30773;
   private static Method methodObject30789;
   private static Method methodObject30834;
   private static Method methodObject30788;
   private static Method methodObject30768;
   private static Method methodObject30800;
   private static Method methodObject30936;
   private static Method methodObject30751;
   private static Method methodObject30730;
   private static Method methodObject30646;
   private static Method methodObject30835;
   private static Method methodObject30785;
   private static Method methodObject30796;
   private static Method methodObject30706;
   private static Method methodObject30901;
   private static Method methodObject30659;
   private static Method methodObject30929;
   private static Method methodObject30920;
   private static Method methodObject30793;
   private static Method methodObject30855;
   private static Method methodObject30852;
   private static Method methodObject30840;
   private static Method methodObject30738;
   private static Method methodObject30732;
   private static Method methodObject30812;
   private static Method methodObject30928;
   private static Method methodObject30733;
   private static Method methodObject30797;
   private static Method methodObject30847;
   private static Method methodObject30750;
   private static Method methodObject30895;
   private static Method methodObject30842;
   private static Method methodObject30883;
   private static Method methodObject30740;
   private static Method methodObject30909;
   private static Method methodObject30715;
   private static Method methodObject30856;
   private static Method methodObject30779;
   private static Method methodObject30799;
   private static Method methodObject30821;
   private static Method methodObject30687;
   private static Method methodObject30805;
   private static Method methodObject30966;
   private static Method methodObject30930;
   private static Method methodObject30884;
   private static Method methodObject30958;
   private static Method methodObject30963;
   private static Method methodObject30722;
   private static Method methodObject30656;
   private static Method methodObject30767;
   private static Method methodObject30683;
   private static Method methodObject30804;
   private static Method methodObject30872;
   private static Method methodObject30702;
   private static Method methodObject30790;
   private static Method methodObject30918;
   private static Method methodObject30726;
   private static Method methodObject30953;
   private static Method methodObject30869;
   private static Method methodObject30926;
   private static Method methodObject30879;
   private static Method methodObject30864;
   private static Method methodObject30907;
   private static Method methodObject30765;
   private static Method methodObject30860;
   private static Method methodObject30739;
   private static Method methodObject30874;
   private static Method methodObject30939;
   private static Method methodObject30772;
   private static Method methodObject30905;
   private static Method methodObject30826;
   private static Method methodObject30858;
   private static Method methodObject30781;
   private static Method methodObject30736;
   private static Method methodObject30911;
   private static Method methodObject30666;
   private static Method methodObject30689;
   private static Method methodObject30760;
   private static Method methodObject30850;
   private static Method methodObject30944;
   private static Method methodObject30886;
   private static Method methodObject30952;
   private static Method methodObject30644;
   private static Method methodObject30665;
   private static Method methodObject30954;
   private static Method methodObject30649;
   private static Method methodObject30667;
   private static Method methodObject30771;
   private static Method methodObject30867;
   private static Method methodObject30654;
   private static Method methodObject30698;
   private static Method methodObject30684;
   private static Method methodObject30753;
   private static Method methodObject30829;
   private static Method methodObject30919;
   private static Method methodObject30808;
   private static Method methodObject30784;
   private static Method methodObject30791;
   private static Method methodObject30677;
   private static Method methodObject30748;
   private static Method methodObject30876;
   private static Method methodObject30672;
   private static Method methodObject30720;
   private static Method methodObject30724;
   private static Method methodObject30746;
   private static Method methodObject30923;
   private static Method methodObject30938;
   private static Method methodObject30717;
   private static Method methodObject30976;
   private static Method methodObject30655;
   private static Method methodObject30935;
   private static Method methodObject30674;
   private static Method methodObject30653;
   private static Method methodObject30978;
   private static Method methodObject30819;
   private static Method methodObject30713;
   private static Method methodObject30725;
   private static Method methodObject30843;
   private static Method methodObject30912;
   private static Method methodObject30871;
   private static Method methodObject30899;
   private static Method methodObject30908;
   private static Method methodObject30711;
   private static Method methodObject30967;
   private static Method methodObject30688;
   private static Method methodObject30853;
   private static Method methodObject30737;
   private static Method methodObject30965;
   private static Method methodObject30647;

   public void setEndToEndMetrics(String[] arg0, short arg1) throws SQLException {
      try {
         super.preForAll(methodObject30818, this, arg0, arg1);
         Method var10001 = methodObject30818;
         this.delegate.setEndToEndMetrics(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject30818, var4);
      }
   }

   public Class getClassForType(String arg0, Map arg1) {
      super.preForAll(methodObject30758, this, arg0, arg1);
      return (Class)this.postForAll(methodObject30758, (Object)this.delegate.getClassForType(arg0, arg1));
   }

   public OracleConnectionCacheCallback getConnectionCacheCallbackObj() throws SQLException {
      try {
         super.preForAll(methodObject30735, this, zeroLengthObjectArray);
         return (OracleConnectionCacheCallback)this.postForAll(methodObject30735, (Object)this.delegate.getConnectionCacheCallbackObj());
      } catch (SQLException var2) {
         return (OracleConnectionCacheCallback)this.postForAll(methodObject30735, this.onErrorForAll(methodObject30735, var2));
      }
   }

   public Object getDescriptor(String arg0) {
      super.preForAll(methodObject30775, this, arg0);
      return this.postForAll(methodObject30775, this.proxyFactory.proxyForCache(this.delegate.getDescriptor(arg0), this, this.proxyCache, methodObject30775));
   }

   public void setStmtCacheSize(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject30822, this, arg0);
         Method var10001 = methodObject30822;
         this.delegate.setStmtCacheSize(arg0);
         this.postForAll(var10001);
      } catch (SQLException var3) {
         this.onErrorVoidForAll(methodObject30822, var3);
      }
   }

   public void setCatalog(String arg0) throws SQLException {
      try {
         super.preForAll(methodObject30961, this, arg0);
         Method var10001 = methodObject30961;
         this.delegate.setCatalog(arg0);
         this.postForAll(var10001);
      } catch (SQLException var3) {
         this.onErrorVoidForAll(methodObject30961, var3);
      }
   }

   public void ackJMSNotification(JMSNotificationRegistration arg0, byte[] arg1, JMSNotificationRegistration.Directive arg2) throws SQLException {
      try {
         super.preForAll(methodObject30703, this, arg0, arg1, arg2);
         Method var10001 = methodObject30703;
         this.delegate.ackJMSNotification(arg0, arg1, arg2);
         this.postForAll(var10001);
      } catch (SQLException var5) {
         this.onErrorVoidForAll(methodObject30703, var5);
      }
   }

   public BINARY_DOUBLE createBINARY_DOUBLE(double arg0) throws SQLException {
      try {
         super.preForAll(methodObject30866, this, arg0);
         return (BINARY_DOUBLE)this.postForAll(methodObject30866, (Object)this.delegate.createBINARY_DOUBLE(arg0));
      } catch (SQLException var4) {
         return (BINARY_DOUBLE)this.postForAll(methodObject30866, this.onErrorForAll(methodObject30866, var4));
      }
   }

   public boolean isCharSetMultibyte(short arg0) {
      super.preForAll(methodObject30719, this, arg0);
      return (Boolean)this.postForAll(methodObject30719, this.delegate.isCharSetMultibyte(arg0));
   }

   public JMSMessage jmsDequeue(String arg0, JMSDequeueOptions arg1, String arg2) throws SQLException {
      try {
         super.preForAll(methodObject30700, this, arg0, arg1, arg2);
         return (JMSMessage)this.postForAll(methodObject30700, (Object)this.delegate.jmsDequeue(arg0, arg1, arg2));
      } catch (SQLException var5) {
         return (JMSMessage)this.postForAll(methodObject30700, this.onErrorForAll(methodObject30700, var5));
      }
   }

   public NUMBER createNUMBER(boolean arg0) throws SQLException {
      try {
         super.preForAll(methodObject30877, this, arg0);
         return (NUMBER)this.postForAll(methodObject30877, (Object)this.delegate.createNUMBER(arg0));
      } catch (SQLException var3) {
         return (NUMBER)this.postForAll(methodObject30877, this.onErrorForAll(methodObject30877, var3));
      }
   }

   public ResultSet newArrayLocatorResultSet(ArrayDescriptor arg0, byte[] arg1, long arg2, int arg3, Map arg4) throws SQLException {
      try {
         super.preForAll(methodObject30682, this, arg0, arg1, arg2, arg3, arg4);
         return (ResultSet)this.postForAll(methodObject30682, this.proxyFactory.proxyForCache((Object)this.delegate.newArrayLocatorResultSet(arg0, arg1, arg2, arg3, arg4), this, this.proxyCache, methodObject30682));
      } catch (SQLException var8) {
         return (ResultSet)this.postForAll(methodObject30682, this.onErrorForAll(methodObject30682, var8));
      }
   }

   public void setClientInfo(String arg0, String arg1) throws SQLClientInfoException {
      super.preForAll(methodObject30962, this, arg0, arg1);
      Method var10001 = methodObject30962;
      this.delegate.setClientInfo(arg0, arg1);
      this.postForAll(var10001);
   }

   public ReplayContext getLastReplayContext() throws SQLException {
      try {
         super.preForAll(methodObject30692, this, zeroLengthObjectArray);
         return (ReplayContext)this.postForAll(methodObject30692, (Object)this.delegate.getLastReplayContext());
      } catch (SQLException var2) {
         return (ReplayContext)this.postForAll(methodObject30692, this.onErrorForAll(methodObject30692, var2));
      }
   }

   public Class classForNameAndSchema(String arg0, String arg1) throws ClassNotFoundException {
      super.preForAll(methodObject30663, this, arg0, arg1);
      return (Class)this.postForAll(methodObject30663, (Object)this.delegate.classForNameAndSchema(arg0, arg1));
   }

   public Savepoint setSavepoint() throws SQLException {
      try {
         super.preForTxnControl(methodObject30933, this, zeroLengthObjectArray);
         return (Savepoint)this.postForAll(methodObject30933, this.proxyFactory.proxyForCreate((Object)this.delegate.setSavepoint(), this, this.proxyCache, methodObject30933));
      } catch (SQLException var2) {
         return (Savepoint)this.postForAll(methodObject30933, this.onErrorForAll(methodObject30933, var2));
      }
   }

   public boolean getAutoClose() throws SQLException {
      try {
         super.preForAll(methodObject30795, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject30795, this.delegate.getAutoClose());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject30795, this.onErrorForAll(methodObject30795, var2));
      }
   }

   public oracle.jdbc.OracleConnection unwrap() {
      super.preForAll(methodObject30780, this, zeroLengthObjectArray);
      return (oracle.jdbc.OracleConnection)this.postForAll(methodObject30780, (Object)super.unwrap());
   }

   public int javaCharsToNCHARBytes(char[] arg0, int arg1, byte[] arg2) throws SQLException {
      try {
         super.preForAll(methodObject30721, this, arg0, arg1, arg2);
         return (Integer)this.postForAll(methodObject30721, this.delegate.javaCharsToNCHARBytes(arg0, arg1, arg2));
      } catch (SQLException var5) {
         return (Integer)this.postForAll(methodObject30721, this.onErrorForAll(methodObject30721, var5));
      }
   }

   public String getExecutingRPCSQL() {
      super.preForAll(methodObject30697, this, zeroLengthObjectArray);
      return (String)this.postForAll(methodObject30697, (Object)this.delegate.getExecutingRPCSQL());
   }

   public int getTransactionIsolation() throws SQLException {
      try {
         super.preForAll(methodObject30974, this, zeroLengthObjectArray);
         return (Integer)this.postForAll(methodObject30974, this.delegate.getTransactionIsolation());
      } catch (SQLException var2) {
         return (Integer)this.postForAll(methodObject30974, this.onErrorForAll(methodObject30974, var2));
      }
   }

   public ResultSet newArrayDataResultSet(ARRAY arg0, long arg1, int arg2, Map arg3) throws SQLException {
      try {
         super.preForAll(methodObject30681, this, arg0, arg1, arg2, arg3);
         return (ResultSet)this.postForAll(methodObject30681, this.proxyFactory.proxyForCache((Object)this.delegate.newArrayDataResultSet(arg0, arg1, arg2, arg3), this, this.proxyCache, methodObject30681));
      } catch (SQLException var7) {
         return (ResultSet)this.postForAll(methodObject30681, this.onErrorForAll(methodObject30681, var7));
      }
   }

   public boolean isLogicalConnection() {
      super.preForAll(methodObject30845, this, zeroLengthObjectArray);
      return (Boolean)this.postForAll(methodObject30845, this.delegate.isLogicalConnection());
   }

   public void cleanupAndClose(boolean arg0) throws SQLException {
      try {
         super.preForAll(methodObject30734, this, arg0);
         Method var10001 = methodObject30734;
         this.delegate.cleanupAndClose(arg0);
         this.postForAll(var10001);
      } catch (SQLException var3) {
         this.onErrorVoidForAll(methodObject30734, var3);
      }
   }

   public void unregisterDatabaseChangeNotification(long arg0, String arg1) throws SQLException {
      try {
         super.preForAll(methodObject30865, this, arg0, arg1);
         Method var10001 = methodObject30865;
         this.delegate.unregisterDatabaseChangeNotification(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var5) {
         this.onErrorVoidForAll(methodObject30865, var5);
      }
   }

   public void doXSNamespaceOp(OracleConnection.XSOperationCode arg0, byte[] arg1, XSNamespace[] arg2, XSNamespace[][] arg3, XSSecureId arg4) throws SQLException {
      try {
         super.preForAll(methodObject30749, this, arg0, arg1, arg2, arg3, arg4);
         Method var10001 = methodObject30749;
         this.delegate.doXSNamespaceOp(arg0, arg1, arg2, arg3, arg4);
         this.postForAll(var10001);
      } catch (SQLException var7) {
         this.onErrorVoidForAll(methodObject30749, var7);
      }
   }

   public boolean isDescriptorSharable(OracleConnection arg0) throws SQLException {
      try {
         super.preForAll(methodObject30742, this, arg0);
         return (Boolean)this.postForAll(methodObject30742, this.delegate.isDescriptorSharable(arg0 instanceof _Proxy_ ? (OracleConnection)((_Proxy_)arg0)._getDelegate_() : arg0));
      } catch (SQLException var3) {
         return (Boolean)this.postForAll(methodObject30742, this.onErrorForAll(methodObject30742, var3));
      }
   }

   public CallableStatement prepareCallWithKey(String arg0) throws SQLException {
      try {
         super.preForAll(methodObject30839, this, arg0);
         return (CallableStatement)this.postForAll(methodObject30839, this.proxyFactory.proxyForCache((Object)this.delegate.prepareCallWithKey(arg0), this, this.proxyCache, methodObject30839));
      } catch (SQLException var3) {
         return (CallableStatement)this.postForAll(methodObject30839, this.onErrorForAll(methodObject30839, var3));
      }
   }

   public void oracleRollback(OracleSavepoint arg0) throws SQLException {
      try {
         super.preForTxnControl(methodObject30783, this, arg0);
         Method var10001 = methodObject30783;
         this.delegate.oracleRollback(arg0 instanceof _Proxy_ ? (OracleSavepoint)((_Proxy_)arg0)._getDelegate_() : arg0);
         this.postForAll(var10001);
      } catch (SQLException var3) {
         this.onErrorVoidForAll(methodObject30783, var3);
      }
   }

   public void setDefaultRowPrefetch(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject30817, this, arg0);
         Method var10001 = methodObject30817;
         this.delegate.setDefaultRowPrefetch(arg0);
         this.postForAll(var10001);
      } catch (SQLException var3) {
         this.onErrorVoidForAll(methodObject30817, var3);
      }
   }

   public TIMESTAMP createTIMESTAMP(String arg0) throws SQLException {
      try {
         super.preForAll(methodObject30891, this, arg0);
         return (TIMESTAMP)this.postForAll(methodObject30891, (Object)this.delegate.createTIMESTAMP(arg0));
      } catch (SQLException var3) {
         return (TIMESTAMP)this.postForAll(methodObject30891, this.onErrorForAll(methodObject30891, var3));
      }
   }

   public long getTdoCState(String arg0) throws SQLException {
      try {
         super.preForAll(methodObject30673, this, arg0);
         return (Long)this.postForAll(methodObject30673, this.delegate.getTdoCState(arg0));
      } catch (SQLException var3) {
         return (Long)this.postForAll(methodObject30673, this.onErrorForAll(methodObject30673, var3));
      }
   }

   public void commit(EnumSet arg0) throws SQLException {
      try {
         super.preForTxnControl(methodObject30782, this, arg0);
         Method var10001 = methodObject30782;
         this.delegate.commit(arg0);
         this.postForAll(var10001);
      } catch (SQLException var3) {
         this.onErrorVoidForAll(methodObject30782, var3);
      }
   }

   public PreparedStatement prepareStatementWithKey(String arg0) throws SQLException {
      try {
         super.preForAll(methodObject30838, this, arg0);
         return (PreparedStatement)this.postForAll(methodObject30838, this.proxyFactory.proxyForCache((Object)this.delegate.prepareStatementWithKey(arg0), this, this.proxyCache, methodObject30838));
      } catch (SQLException var3) {
         return (PreparedStatement)this.postForAll(methodObject30838, this.onErrorForAll(methodObject30838, var3));
      }
   }

   public SQLXML createSQLXML() throws SQLException {
      try {
         super.preForAll(methodObject30941, this, zeroLengthObjectArray);
         return (SQLXML)this.postForAll(methodObject30941, this.proxyFactory.proxyForCreateCache((Object)this.delegate.createSQLXML(), this, this.proxyCache, methodObject30941));
      } catch (SQLException var2) {
         return (SQLXML)this.postForAll(methodObject30941, this.onErrorForAll(methodObject30941, var2));
      }
   }

   public NUMBER createNUMBER(byte arg0) throws SQLException {
      try {
         super.preForAll(methodObject30878, this, arg0);
         return (NUMBER)this.postForAll(methodObject30878, (Object)this.delegate.createNUMBER(arg0));
      } catch (SQLException var3) {
         return (NUMBER)this.postForAll(methodObject30878, this.onErrorForAll(methodObject30878, var3));
      }
   }

   public String getEncryptionAlgorithmName() throws SQLException {
      try {
         super.preForAll(methodObject30910, this, zeroLengthObjectArray);
         return (String)this.postForAll(methodObject30910, (Object)this.delegate.getEncryptionAlgorithmName());
      } catch (SQLException var2) {
         return (String)this.postForAll(methodObject30910, this.onErrorForAll(methodObject30910, var2));
      }
   }

   public OracleStatement refCursorCursorToStatement(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject30743, this, arg0);
         return (OracleStatement)this.postForAll(methodObject30743, this.proxyFactory.proxyForCache((Object)this.delegate.refCursorCursorToStatement(arg0), this, this.proxyCache, methodObject30743));
      } catch (SQLException var3) {
         return (OracleStatement)this.postForAll(methodObject30743, this.onErrorForAll(methodObject30743, var3));
      }
   }

   public TypeDescriptor[] getAllTypeDescriptorsInCurrentSchema() throws SQLException {
      try {
         super.preForAll(methodObject30906, this, zeroLengthObjectArray);
         return (TypeDescriptor[])this.postForAll(methodObject30906, (Object)this.delegate.getAllTypeDescriptorsInCurrentSchema());
      } catch (SQLException var2) {
         return (TypeDescriptor[])this.postForAll(methodObject30906, this.onErrorForAll(methodObject30906, var2));
      }
   }

   public int getTimezoneVersionNumber() throws SQLException {
      try {
         super.preForAll(methodObject30762, this, zeroLengthObjectArray);
         return (Integer)this.postForAll(methodObject30762, this.delegate.getTimezoneVersionNumber());
      } catch (SQLException var2) {
         return (Integer)this.postForAll(methodObject30762, this.onErrorForAll(methodObject30762, var2));
      }
   }

   public Savepoint setSavepoint(String arg0) throws SQLException {
      try {
         super.preForTxnControl(methodObject30934, this, arg0);
         return (Savepoint)this.postForAll(methodObject30934, this.proxyFactory.proxyForCreate((Object)this.delegate.setSavepoint(arg0), this, this.proxyCache, methodObject30934));
      } catch (SQLException var3) {
         return (Savepoint)this.postForAll(methodObject30934, this.onErrorForAll(methodObject30934, var3));
      }
   }

   public void registerSQLType(String arg0, Class arg1) throws SQLException {
      try {
         super.preForAll(methodObject30813, this, arg0, arg1);
         Method var10001 = methodObject30813;
         this.delegate.registerSQLType(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject30813, var4);
      }
   }

   public TIMESTAMP createTIMESTAMP(Timestamp arg0) throws SQLException {
      try {
         super.preForAll(methodObject30890, this, arg0);
         return (TIMESTAMP)this.postForAll(methodObject30890, (Object)this.delegate.createTIMESTAMP(arg0));
      } catch (SQLException var3) {
         return (TIMESTAMP)this.postForAll(methodObject30890, this.onErrorForAll(methodObject30890, var3));
      }
   }

   public void setTxnMode(int arg0) {
      super.preForAll(methodObject30727, this, arg0);
      Method var10001 = methodObject30727;
      this.delegate.setTxnMode(arg0);
      this.postForAll(var10001);
   }

   public void setTypeMap(Map arg0) throws SQLException {
      try {
         super.preForAll(methodObject30709, this, arg0);
         Method var10001 = methodObject30709;
         this.delegate.setTypeMap(arg0);
         this.postForAll(var10001);
      } catch (SQLException var3) {
         this.onErrorVoidForAll(methodObject30709, var3);
      }
   }

   public String getSessionTimeZoneOffset() throws SQLException {
      try {
         super.preForAll(methodObject30844, this, zeroLengthObjectArray);
         return (String)this.postForAll(methodObject30844, (Object)this.delegate.getSessionTimeZoneOffset());
      } catch (SQLException var2) {
         return (String)this.postForAll(methodObject30844, this.onErrorForAll(methodObject30844, var2));
      }
   }

   public Properties getClientInfo() throws SQLException {
      try {
         super.preForAll(methodObject30972, this, zeroLengthObjectArray);
         return (Properties)this.postForAll(methodObject30972, (Object)this.delegate.getClientInfo());
      } catch (SQLException var2) {
         return (Properties)this.postForAll(methodObject30972, this.onErrorForAll(methodObject30972, var2));
      }
   }

   public short getStructAttrNCsId() throws SQLException {
      try {
         super.preForAll(methodObject30651, this, zeroLengthObjectArray);
         return (Short)this.postForAll(methodObject30651, this.delegate.getStructAttrNCsId());
      } catch (SQLException var2) {
         return (Short)this.postForAll(methodObject30651, this.onErrorForAll(methodObject30651, var2));
      }
   }

   public void removeAllDescriptor() {
      super.preForAll(methodObject30669, this, zeroLengthObjectArray);
      Method var10001 = methodObject30669;
      this.delegate.removeAllDescriptor();
      this.postForAll(var10001);
   }

   public ResultSet newArrayDataResultSet(Datum[] arg0, long arg1, int arg2, Map arg3) throws SQLException {
      try {
         super.preForAll(methodObject30680, this, arg0, arg1, arg2, arg3);
         return (ResultSet)this.postForAll(methodObject30680, this.proxyFactory.proxyForCache((Object)this.delegate.newArrayDataResultSet(arg0, arg1, arg2, arg3), this, this.proxyCache, methodObject30680));
      } catch (SQLException var7) {
         return (ResultSet)this.postForAll(methodObject30680, this.onErrorForAll(methodObject30680, var7));
      }
   }

   public boolean getUsingXAFlag() {
      super.preForAll(methodObject30809, this, zeroLengthObjectArray);
      return (Boolean)this.postForAll(methodObject30809, this.delegate.getUsingXAFlag());
   }

   public void setAutoCommit(boolean arg0) throws SQLException {
      try {
         super.preForAll(methodObject30960, this, arg0);
         Method var10001 = methodObject30960;
         this.delegate.setAutoCommit(arg0);
         this.postForAll(var10001);
      } catch (SQLException var3) {
         this.onErrorVoidForAll(methodObject30960, var3);
      }
   }

   public CallableStatement prepareCall(String arg0) throws SQLException {
      try {
         super.preForAll(methodObject30945, this, arg0);
         return (CallableStatement)this.postForAll(methodObject30945, this.proxyFactory.proxyForCreateCache((Object)this.delegate.prepareCall(arg0), this, this.proxyCache, methodObject30945));
      } catch (SQLException var3) {
         return (CallableStatement)this.postForAll(methodObject30945, this.onErrorForAll(methodObject30945, var3));
      }
   }

   public void setPDBChangeEventListener(PDBChangeEventListener arg0) throws SQLException {
      try {
         super.preForAll(methodObject30705, this, arg0);
         Method var10001 = methodObject30705;
         this.delegate.setPDBChangeEventListener(arg0);
         this.postForAll(var10001);
      } catch (SQLException var3) {
         this.onErrorVoidForAll(methodObject30705, var3);
      }
   }

   public OracleConnection physicalConnectionWithin() {
      super.preForAll(methodObject30792, this, zeroLengthObjectArray);
      return (OracleConnection)this.postForAll(methodObject30792, this.proxyFactory.proxyForCache((Object)this.delegate.physicalConnectionWithin(), this, this.proxyCache, methodObject30792));
   }

   public void setJavaObjectTypeMap(Map arg0) {
      super.preForAll(methodObject30657, this, arg0);
      Method var10001 = methodObject30657;
      this.delegate.setJavaObjectTypeMap(arg0);
      this.postForAll(var10001);
   }

   public oracle.jdbc.OracleConnection getWrapper() {
      super.preForAll(methodObject30686, this, zeroLengthObjectArray);
      return (oracle.jdbc.OracleConnection)this.postForAll(methodObject30686, this.proxyFactory.proxyForCache((Object)this.delegate.getWrapper(), this, this.proxyCache, methodObject30686));
   }

   public void getForm(OracleTypeADT arg0, OracleTypeCLOB arg1, int arg2) throws SQLException {
      try {
         super.preForAll(methodObject30710, this, arg0, arg1, arg2);
         Method var10001 = methodObject30710;
         this.delegate.getForm(arg0, arg1, arg2);
         this.postForAll(var10001);
      } catch (SQLException var5) {
         this.onErrorVoidForAll(methodObject30710, var5);
      }
   }

   public void clearWarnings() throws SQLException {
      try {
         super.preForAll(methodObject30969, this, zeroLengthObjectArray);
         Method var10001 = methodObject30969;
         this.delegate.clearWarnings();
         this.postForAll(var10001);
      } catch (SQLException var2) {
         this.onErrorVoidForAll(methodObject30969, var2);
      }
   }

   public byte getInstanceProperty(OracleConnection.InstanceProperty arg0) throws SQLException {
      try {
         super.preForAll(methodObject30658, this, arg0);
         return (Byte)this.postForAll(methodObject30658, this.delegate.getInstanceProperty(arg0));
      } catch (SQLException var3) {
         return (Byte)this.postForAll(methodObject30658, this.onErrorForAll(methodObject30658, var3));
      }
   }

   public boolean needToPurgeStatementCache() throws SQLException {
      try {
         super.preForAll(methodObject30924, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject30924, this.delegate.needToPurgeStatementCache());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject30924, this.onErrorForAll(methodObject30924, var2));
      }
   }

   public int getMaxNCharbyteSize() {
      super.preForAll(methodObject30718, this, zeroLengthObjectArray);
      return (Integer)this.postForAll(methodObject30718, this.delegate.getMaxNCharbyteSize());
   }

   public NUMBER createNUMBER(float arg0) throws SQLException {
      try {
         super.preForAll(methodObject30882, this, arg0);
         return (NUMBER)this.postForAll(methodObject30882, (Object)this.delegate.createNUMBER(arg0));
      } catch (SQLException var3) {
         return (NUMBER)this.postForAll(methodObject30882, this.onErrorForAll(methodObject30882, var3));
      }
   }

   public void doXSSessionDestroyOp(byte[] arg0, XSSecureId arg1, byte[] arg2) throws SQLException {
      try {
         super.preForAll(methodObject30752, this, arg0, arg1, arg2);
         Method var10001 = methodObject30752;
         this.delegate.doXSSessionDestroyOp(arg0, arg1, arg2);
         this.postForAll(var10001);
      } catch (SQLException var5) {
         this.onErrorVoidForAll(methodObject30752, var5);
      }
   }

   public void setApplicationContext(String arg0, String arg1, String arg2) throws SQLException {
      try {
         super.preForAll(methodObject30915, this, arg0, arg1, arg2);
         Method var10001 = methodObject30915;
         this.delegate.setApplicationContext(arg0, arg1, arg2);
         this.postForAll(var10001);
      } catch (SQLException var5) {
         this.onErrorVoidForAll(methodObject30915, var5);
      }
   }

   public Enumeration descriptorCacheKeys() {
      super.preForAll(methodObject30671, this, zeroLengthObjectArray);
      return (Enumeration)this.postForAll(methodObject30671, (Object)this.delegate.descriptorCacheKeys());
   }

   public void unregisterAQNotification(AQNotificationRegistration arg0) throws SQLException {
      try {
         super.preForAll(methodObject30857, this, arg0);
         Method var10001 = methodObject30857;
         this.delegate.unregisterAQNotification(arg0);
         this.postForAll(var10001);
      } catch (SQLException var3) {
         this.onErrorVoidForAll(methodObject30857, var3);
      }
   }

   public void registerEndReplayCallback(OracleConnection.EndReplayCallback arg0) throws SQLException {
      try {
         super.preForAll(methodObject30693, this, arg0);
         Method var10001 = methodObject30693;
         this.delegate.registerEndReplayCallback(arg0);
         this.postForAll(var10001);
      } catch (SQLException var3) {
         this.onErrorVoidForAll(methodObject30693, var3);
      }
   }

   public Statement createStatement() throws SQLException {
      try {
         super.preForAll(methodObject30942, this, zeroLengthObjectArray);
         return (Statement)this.postForAll(methodObject30942, this.proxyFactory.proxyForCreateCache((Object)this.delegate.createStatement(), this, this.proxyCache, methodObject30942));
      } catch (SQLException var2) {
         return (Statement)this.postForAll(methodObject30942, this.onErrorForAll(methodObject30942, var2));
      }
   }

   public Map registerJMSNotification(String[] arg0, Map arg1) throws SQLException {
      try {
         super.preForAll(methodObject30701, this, arg0, arg1);
         return (Map)this.postForAll(methodObject30701, (Object)this.delegate.registerJMSNotification(arg0, arg1));
      } catch (SQLException var4) {
         return (Map)this.postForAll(methodObject30701, this.onErrorForAll(methodObject30701, var4));
      }
   }

   public DatabaseMetaData getMetaData() throws SQLException {
      try {
         super.preForAll(methodObject30957, this, zeroLengthObjectArray);
         return (DatabaseMetaData)this.postForAll(methodObject30957, this.proxyFactory.proxyForCache((Object)this.delegate.getMetaData(), this, this.proxyCache, methodObject30957));
      } catch (SQLException var2) {
         return (DatabaseMetaData)this.postForAll(methodObject30957, this.onErrorForAll(methodObject30957, var2));
      }
   }

   public boolean isV8Compatible() throws SQLException {
      try {
         super.preForAll(methodObject30745, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject30745, this.delegate.isV8Compatible());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject30745, this.onErrorForAll(methodObject30745, var2));
      }
   }

   public void setStmtCacheSize(int arg0, boolean arg1) throws SQLException {
      try {
         super.preForAll(methodObject30823, this, arg0, arg1);
         Method var10001 = methodObject30823;
         this.delegate.setStmtCacheSize(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject30823, var4);
      }
   }

   public TIMESTAMP createTIMESTAMP(Date arg0) throws SQLException {
      try {
         super.preForAll(methodObject30887, this, arg0);
         return (TIMESTAMP)this.postForAll(methodObject30887, (Object)this.delegate.createTIMESTAMP(arg0));
      } catch (SQLException var3) {
         return (TIMESTAMP)this.postForAll(methodObject30887, this.onErrorForAll(methodObject30887, var3));
      }
   }

   public NUMBER createNUMBER(BigInteger arg0) throws SQLException {
      try {
         super.preForAll(methodObject30885, this, arg0);
         return (NUMBER)this.postForAll(methodObject30885, (Object)this.delegate.createNUMBER(arg0));
      } catch (SQLException var3) {
         return (NUMBER)this.postForAll(methodObject30885, this.onErrorForAll(methodObject30885, var3));
      }
   }

   public DATE createDATE(Timestamp arg0) throws SQLException {
      try {
         super.preForAll(methodObject30870, this, arg0);
         return (DATE)this.postForAll(methodObject30870, (Object)this.delegate.createDATE(arg0));
      } catch (SQLException var3) {
         return (DATE)this.postForAll(methodObject30870, this.onErrorForAll(methodObject30870, var3));
      }
   }

   public CallableStatement getCallWithKey(String arg0) throws SQLException {
      try {
         super.preForAll(methodObject30833, this, arg0);
         return (CallableStatement)this.postForAll(methodObject30833, this.proxyFactory.proxyForCache((Object)this.delegate.getCallWithKey(arg0), this, this.proxyCache, methodObject30833));
      } catch (SQLException var3) {
         return (CallableStatement)this.postForAll(methodObject30833, this.onErrorForAll(methodObject30833, var3));
      }
   }

   public boolean isClosed() throws SQLException {
      try {
         super.preForAll(methodObject30955, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject30955, this.delegate.isClosed());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject30955, this.onErrorForAll(methodObject30955, var2));
      }
   }

   public byte[] getDerivedKeyInternal(byte[] arg0, int arg1) throws NoSuchAlgorithmException, InvalidKeySpecException, SQLException {
      try {
         super.preForAll(methodObject30695, this, arg0, arg1);
         return (byte[])this.postForAll(methodObject30695, (Object)this.delegate.getDerivedKeyInternal(arg0, arg1));
      } catch (SQLException var4) {
         return (byte[])this.postForAll(methodObject30695, this.onErrorForAll(methodObject30695, var4));
      }
   }

   public void setDefaultFixedString(boolean arg0) {
      super.preForAll(methodObject30661, this, arg0);
      Method var10001 = methodObject30661;
      this.delegate.setDefaultFixedString(arg0);
      this.postForAll(var10001);
   }

   public String getURL() throws SQLException {
      try {
         super.preForAll(methodObject30645, this, zeroLengthObjectArray);
         return (String)this.postForAll(methodObject30645, (Object)this.delegate.getURL());
      } catch (SQLException var2) {
         return (String)this.postForAll(methodObject30645, this.onErrorForAll(methodObject30645, var2));
      }
   }

   public TIMEZONETAB getTIMEZONETAB() throws SQLException {
      try {
         super.preForAll(methodObject30764, this, zeroLengthObjectArray);
         return (TIMEZONETAB)this.postForAll(methodObject30764, (Object)this.delegate.getTIMEZONETAB());
      } catch (SQLException var2) {
         return (TIMEZONETAB)this.postForAll(methodObject30764, this.onErrorForAll(methodObject30764, var2));
      }
   }

   public int getHeapAllocSize() throws SQLException {
      try {
         super.preForAll(methodObject30729, this, zeroLengthObjectArray);
         return (Integer)this.postForAll(methodObject30729, this.delegate.getHeapAllocSize());
      } catch (SQLException var2) {
         return (Integer)this.postForAll(methodObject30729, this.onErrorForAll(methodObject30729, var2));
      }
   }

   public short getExecutingRPCFunctionCode() {
      super.preForAll(methodObject30696, this, zeroLengthObjectArray);
      return (Short)this.postForAll(methodObject30696, this.delegate.getExecutingRPCFunctionCode());
   }

   public byte[] createLightweightSession(String arg0, KeywordValueLong[] arg1, int arg2, KeywordValueLong[][] arg3, int[] arg4) throws SQLException {
      try {
         super.preForAll(methodObject30747, this, arg0, arg1, arg2, arg3, arg4);
         return (byte[])this.postForAll(methodObject30747, (Object)this.delegate.createLightweightSession(arg0, arg1, arg2, arg3, arg4));
      } catch (SQLException var7) {
         return (byte[])this.postForAll(methodObject30747, this.onErrorForAll(methodObject30747, var7));
      }
   }

   public void setChecksumMode(OracleConnection.ChecksumMode arg0) throws SQLException {
      try {
         super.preForAll(methodObject30707, this, arg0);
         Method var10001 = methodObject30707;
         this.delegate.setChecksumMode(arg0);
         this.postForAll(var10001);
      } catch (SQLException var3) {
         this.onErrorVoidForAll(methodObject30707, var3);
      }
   }

   public String getSchema() throws SQLException {
      try {
         super.preForAll(methodObject30956, this, zeroLengthObjectArray);
         return (String)this.postForAll(methodObject30956, (Object)this.delegate.getSchema());
      } catch (SQLException var2) {
         return (String)this.postForAll(methodObject30956, this.onErrorForAll(methodObject30956, var2));
      }
   }

   public Statement createStatement(int arg0, int arg1) throws SQLException {
      try {
         super.preForAll(methodObject30943, this, arg0, arg1);
         return (Statement)this.postForAll(methodObject30943, this.proxyFactory.proxyForCreateCache((Object)this.delegate.createStatement(arg0, arg1), this, this.proxyCache, methodObject30943));
      } catch (SQLException var4) {
         return (Statement)this.postForAll(methodObject30943, this.onErrorForAll(methodObject30943, var4));
      }
   }

   public int NCHARBytesToJavaChars(byte[] arg0, int arg1, char[] arg2) throws SQLException {
      try {
         super.preForAll(methodObject30712, this, arg0, arg1, arg2);
         return (Integer)this.postForAll(methodObject30712, this.delegate.NCHARBytesToJavaChars(arg0, arg1, arg2));
      } catch (SQLException var5) {
         return (Integer)this.postForAll(methodObject30712, this.onErrorForAll(methodObject30712, var5));
      }
   }

   public NUMBER createNUMBER(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject30880, this, arg0);
         return (NUMBER)this.postForAll(methodObject30880, (Object)this.delegate.createNUMBER(arg0));
      } catch (SQLException var3) {
         return (NUMBER)this.postForAll(methodObject30880, this.onErrorForAll(methodObject30880, var3));
      }
   }

   public short getStructAttrCsId() throws SQLException {
      try {
         super.preForAll(methodObject30806, this, zeroLengthObjectArray);
         return (Short)this.postForAll(methodObject30806, this.delegate.getStructAttrCsId());
      } catch (SQLException var2) {
         return (Short)this.postForAll(methodObject30806, this.onErrorForAll(methodObject30806, var2));
      }
   }

   public boolean getRestrictGetTables() {
      super.preForAll(methodObject30801, this, zeroLengthObjectArray);
      return (Boolean)this.postForAll(methodObject30801, this.delegate.getRestrictGetTables());
   }

   public Properties getUnMatchedConnectionAttributes() throws SQLException {
      try {
         super.preForAll(methodObject30851, this, zeroLengthObjectArray);
         return (Properties)this.postForAll(methodObject30851, (Object)this.delegate.getUnMatchedConnectionAttributes());
      } catch (SQLException var2) {
         return (Properties)this.postForAll(methodObject30851, this.onErrorForAll(methodObject30851, var2));
      }
   }

   public void unregisterDatabaseChangeNotification(int arg0, String arg1, int arg2) throws SQLException {
      try {
         super.preForAll(methodObject30863, this, arg0, arg1, arg2);
         Method var10001 = methodObject30863;
         this.delegate.unregisterDatabaseChangeNotification(arg0, arg1, arg2);
         this.postForAll(var10001);
      } catch (SQLException var5) {
         this.onErrorVoidForAll(methodObject30863, var5);
      }
   }

   public NUMBER createNUMBER(long arg0) throws SQLException {
      try {
         super.preForAll(methodObject30881, this, arg0);
         return (NUMBER)this.postForAll(methodObject30881, (Object)this.delegate.createNUMBER(arg0));
      } catch (SQLException var4) {
         return (NUMBER)this.postForAll(methodObject30881, this.onErrorForAll(methodObject30881, var4));
      }
   }

   public void setACProxy(Object arg0) {
      super.preForAll(methodObject30977, this, arg0);
      Method var10001 = methodObject30977;
      this.delegate.setACProxy(arg0 instanceof _Proxy_ ? (Object)((_Proxy_)arg0)._getDelegate_() : arg0);
      this.postForAll(var10001);
   }

   public CallableStatement prepareCall(String arg0, int arg1, int arg2) throws SQLException {
      try {
         super.preForAll(methodObject30946, this, arg0, arg1, arg2);
         return (CallableStatement)this.postForAll(methodObject30946, this.proxyFactory.proxyForCreateCache((Object)this.delegate.prepareCall(arg0, arg1, arg2), this, this.proxyCache, methodObject30946));
      } catch (SQLException var5) {
         return (CallableStatement)this.postForAll(methodObject30946, this.onErrorForAll(methodObject30946, var5));
      }
   }

   public void unregisterDatabaseChangeNotification(DatabaseChangeRegistration arg0) throws SQLException {
      try {
         super.preForAll(methodObject30862, this, arg0);
         Method var10001 = methodObject30862;
         this.delegate.unregisterDatabaseChangeNotification(arg0);
         this.postForAll(var10001);
      } catch (SQLException var3) {
         this.onErrorVoidForAll(methodObject30862, var3);
      }
   }

   public void applyConnectionAttributes(Properties arg0) throws SQLException {
      try {
         super.preForAll(methodObject30849, this, arg0);
         Method var10001 = methodObject30849;
         this.delegate.applyConnectionAttributes(arg0);
         this.postForAll(var10001);
      } catch (SQLException var3) {
         this.onErrorVoidForAll(methodObject30849, var3);
      }
   }

   public void setDefaultTimeZone(TimeZone arg0) throws SQLException {
      try {
         super.preForAll(methodObject30913, this, arg0);
         Method var10001 = methodObject30913;
         this.delegate.setDefaultTimeZone(arg0);
         this.postForAll(var10001);
      } catch (SQLException var3) {
         this.onErrorVoidForAll(methodObject30913, var3);
      }
   }

   public void shutdown(oracle.jdbc.OracleConnection.DatabaseShutdownMode arg0) throws SQLException {
      try {
         super.preForAll(methodObject30774, this, arg0);
         Method var10001 = methodObject30774;
         this.delegate.shutdown(arg0);
         this.postForAll(var10001);
      } catch (SQLException var3) {
         this.onErrorVoidForAll(methodObject30774, var3);
      }
   }

   public void setStatementCacheSize(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject30824, this, arg0);
         Method var10001 = methodObject30824;
         this.delegate.setStatementCacheSize(arg0);
         this.postForAll(var10001);
      } catch (SQLException var3) {
         this.onErrorVoidForAll(methodObject30824, var3);
      }
   }

   public boolean getImplicitCachingEnabled() throws SQLException {
      try {
         super.preForAll(methodObject30827, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject30827, this.delegate.getImplicitCachingEnabled());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject30827, this.onErrorForAll(methodObject30827, var2));
      }
   }

   public void purgeExplicitCache() throws SQLException {
      try {
         super.preForAll(methodObject30831, this, zeroLengthObjectArray);
         Method var10001 = methodObject30831;
         this.delegate.purgeExplicitCache();
         this.postForAll(var10001);
      } catch (SQLException var2) {
         this.onErrorVoidForAll(methodObject30831, var2);
      }
   }

   public TIMESTAMPTZ createTIMESTAMPTZ(Date arg0, Calendar arg1) throws SQLException {
      try {
         super.preForAll(methodObject30893, this, arg0, arg1);
         return (TIMESTAMPTZ)this.postForAll(methodObject30893, (Object)this.delegate.createTIMESTAMPTZ(arg0, arg1));
      } catch (SQLException var4) {
         return (TIMESTAMPTZ)this.postForAll(methodObject30893, this.onErrorForAll(methodObject30893, var4));
      }
   }

   public void purgeImplicitCache() throws SQLException {
      try {
         super.preForAll(methodObject30830, this, zeroLengthObjectArray);
         Method var10001 = methodObject30830;
         this.delegate.purgeImplicitCache();
         this.postForAll(var10001);
      } catch (SQLException var2) {
         this.onErrorVoidForAll(methodObject30830, var2);
      }
   }

   public ClobDBAccess createClobDBAccess() throws SQLException {
      try {
         super.preForAll(methodObject30660, this, zeroLengthObjectArray);
         return (ClobDBAccess)this.postForAll(methodObject30660, (Object)this.delegate.createClobDBAccess());
      } catch (SQLException var2) {
         return (ClobDBAccess)this.postForAll(methodObject30660, this.onErrorForAll(methodObject30660, var2));
      }
   }

   public BFILE createBfile(byte[] arg0) throws SQLException {
      try {
         super.preForAll(methodObject30741, this, arg0);
         return (BFILE)this.postForAll(methodObject30741, (Object)this.delegate.createBfile(arg0));
      } catch (SQLException var3) {
         return (BFILE)this.postForAll(methodObject30741, this.onErrorForAll(methodObject30741, var3));
      }
   }

   public TIMESTAMPTZ createTIMESTAMPTZ(Date arg0) throws SQLException {
      try {
         super.preForAll(methodObject30892, this, arg0);
         return (TIMESTAMPTZ)this.postForAll(methodObject30892, (Object)this.delegate.createTIMESTAMPTZ(arg0));
      } catch (SQLException var3) {
         return (TIMESTAMPTZ)this.postForAll(methodObject30892, this.onErrorForAll(methodObject30892, var3));
      }
   }

   public void removeAllXSEventListener() throws SQLException {
      try {
         super.preForAll(methodObject30763, this, zeroLengthObjectArray);
         Method var10001 = methodObject30763;
         this.delegate.removeAllXSEventListener();
         this.postForAll(var10001);
      } catch (SQLException var2) {
         this.onErrorVoidForAll(methodObject30763, var2);
      }
   }

   public TIMESTAMPTZ createTIMESTAMPTZ(String arg0) throws SQLException {
      try {
         super.preForAll(methodObject30898, this, arg0);
         return (TIMESTAMPTZ)this.postForAll(methodObject30898, (Object)this.delegate.createTIMESTAMPTZ(arg0));
      } catch (SQLException var3) {
         return (TIMESTAMPTZ)this.postForAll(methodObject30898, this.onErrorForAll(methodObject30898, var3));
      }
   }

   public void setAbandonedTimeoutEnabled(boolean arg0) throws SQLException {
      try {
         super.preForAll(methodObject30731, this, arg0);
         Method var10001 = methodObject30731;
         this.delegate.setAbandonedTimeoutEnabled(arg0);
         this.postForAll(var10001);
      } catch (SQLException var3) {
         this.onErrorVoidForAll(methodObject30731, var3);
      }
   }

   public TIMESTAMPLTZ createTIMESTAMPLTZ(Timestamp arg0, Calendar arg1) throws SQLException {
      try {
         super.preForAll(methodObject30903, this, arg0, arg1);
         return (TIMESTAMPLTZ)this.postForAll(methodObject30903, (Object)this.delegate.createTIMESTAMPLTZ(arg0, arg1));
      } catch (SQLException var4) {
         return (TIMESTAMPLTZ)this.postForAll(methodObject30903, this.onErrorForAll(methodObject30903, var4));
      }
   }

   public PreparedStatement prepareStatement(String arg0, int arg1, int arg2) throws SQLException {
      try {
         super.preForAll(methodObject30949, this, arg0, arg1, arg2);
         return (PreparedStatement)this.postForAll(methodObject30949, this.proxyFactory.proxyForCreateCache((Object)this.delegate.prepareStatement(arg0, arg1, arg2), this, this.proxyCache, methodObject30949));
      } catch (SQLException var5) {
         return (PreparedStatement)this.postForAll(methodObject30949, this.onErrorForAll(methodObject30949, var5));
      }
   }

   public TIMESTAMPTZ createTIMESTAMPTZ(Timestamp arg0) throws SQLException {
      try {
         super.preForAll(methodObject30896, this, arg0);
         return (TIMESTAMPTZ)this.postForAll(methodObject30896, (Object)this.delegate.createTIMESTAMPTZ(arg0));
      } catch (SQLException var3) {
         return (TIMESTAMPTZ)this.postForAll(methodObject30896, this.onErrorForAll(methodObject30896, var3));
      }
   }

   public void startup(String arg0, int arg1) throws SQLException {
      try {
         super.preForAll(methodObject30836, this, arg0, arg1);
         Method var10001 = methodObject30836;
         this.delegate.startup(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject30836, var4);
      }
   }

   public PreparedStatement getStatementWithKey(String arg0) throws SQLException {
      try {
         super.preForAll(methodObject30832, this, arg0);
         return (PreparedStatement)this.postForAll(methodObject30832, this.proxyFactory.proxyForCache((Object)this.delegate.getStatementWithKey(arg0), this, this.proxyCache, methodObject30832));
      } catch (SQLException var3) {
         return (PreparedStatement)this.postForAll(methodObject30832, this.onErrorForAll(methodObject30832, var3));
      }
   }

   public Properties getProperties() {
      super.preForAll(methodObject30776, this, zeroLengthObjectArray);
      return (Properties)this.postForAll(methodObject30776, (Object)this.delegate.getProperties());
   }

   public DATE createDATE(Date arg0) throws SQLException {
      try {
         super.preForAll(methodObject30868, this, arg0);
         return (DATE)this.postForAll(methodObject30868, (Object)this.delegate.createDATE(arg0));
      } catch (SQLException var3) {
         return (DATE)this.postForAll(methodObject30868, this.onErrorForAll(methodObject30868, var3));
      }
   }

   public void doXSSessionDetachOp(int arg0, byte[] arg1, XSSecureId arg2, boolean arg3) throws SQLException {
      try {
         super.preForAll(methodObject30754, this, arg0, arg1, arg2, arg3);
         Method var10001 = methodObject30754;
         this.delegate.doXSSessionDetachOp(arg0, arg1, arg2, arg3);
         this.postForAll(var10001);
      } catch (SQLException var6) {
         this.onErrorVoidForAll(methodObject30754, var6);
      }
   }

   public int getEOC() throws SQLException {
      try {
         super.preForAll(methodObject30694, this, zeroLengthObjectArray);
         return (Integer)this.postForAll(methodObject30694, this.delegate.getEOC());
      } catch (SQLException var2) {
         return (Integer)this.postForAll(methodObject30694, this.onErrorForAll(methodObject30694, var2));
      }
   }

   public CLOB createClob(byte[] arg0, short arg1) throws SQLException {
      try {
         super.preForAll(methodObject30648, this, arg0, arg1);
         return (CLOB)this.postForAll(methodObject30648, (Object)this.delegate.createClob(arg0, arg1));
      } catch (SQLException var4) {
         return (CLOB)this.postForAll(methodObject30648, this.onErrorForAll(methodObject30648, var4));
      }
   }

   public TIMESTAMPTZ createTIMESTAMPTZ(Time arg0) throws SQLException {
      try {
         super.preForAll(methodObject30894, this, arg0);
         return (TIMESTAMPTZ)this.postForAll(methodObject30894, (Object)this.delegate.createTIMESTAMPTZ(arg0));
      } catch (SQLException var3) {
         return (TIMESTAMPTZ)this.postForAll(methodObject30894, this.onErrorForAll(methodObject30894, var3));
      }
   }

   public TIMESTAMP createTIMESTAMP(DATE arg0) throws SQLException {
      try {
         super.preForAll(methodObject30888, this, arg0);
         return (TIMESTAMP)this.postForAll(methodObject30888, (Object)this.delegate.createTIMESTAMP(arg0));
      } catch (SQLException var3) {
         return (TIMESTAMP)this.postForAll(methodObject30888, this.onErrorForAll(methodObject30888, var3));
      }
   }

   public boolean getDefaultFixedString() {
      super.preForAll(methodObject30662, this, zeroLengthObjectArray);
      return (Boolean)this.postForAll(methodObject30662, this.delegate.getDefaultFixedString());
   }

   public ReplayContext[] getReplayContext() throws SQLException {
      try {
         super.preForAll(methodObject30691, this, zeroLengthObjectArray);
         return (ReplayContext[])this.postForAll(methodObject30691, (Object)this.delegate.getReplayContext());
      } catch (SQLException var2) {
         return (ReplayContext[])this.postForAll(methodObject30691, this.onErrorForAll(methodObject30691, var2));
      }
   }

   public int getNetworkTimeout() throws SQLException {
      try {
         super.preForAll(methodObject30968, this, zeroLengthObjectArray);
         return (Integer)this.postForAll(methodObject30968, this.delegate.getNetworkTimeout());
      } catch (SQLException var2) {
         return (Integer)this.postForAll(methodObject30968, this.onErrorForAll(methodObject30968, var2));
      }
   }

   public boolean attachServerConnection() throws SQLException {
      try {
         super.preForAll(methodObject30922, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject30922, this.delegate.attachServerConnection());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject30922, this.onErrorForAll(methodObject30922, var2));
      }
   }

   public PreparedStatement prepareStatement(String arg0, int arg1, int arg2, int arg3) throws SQLException {
      try {
         super.preForAll(methodObject30950, this, arg0, arg1, arg2, arg3);
         return (PreparedStatement)this.postForAll(methodObject30950, this.proxyFactory.proxyForCreateCache((Object)this.delegate.prepareStatement(arg0, arg1, arg2, arg3), this, this.proxyCache, methodObject30950));
      } catch (SQLException var6) {
         return (PreparedStatement)this.postForAll(methodObject30950, this.onErrorForAll(methodObject30950, var6));
      }
   }

   public TIMESTAMPTZ createTIMESTAMPTZ(DATE arg0) throws SQLException {
      try {
         super.preForAll(methodObject30900, this, arg0);
         return (TIMESTAMPTZ)this.postForAll(methodObject30900, (Object)this.delegate.createTIMESTAMPTZ(arg0));
      } catch (SQLException var3) {
         return (TIMESTAMPTZ)this.postForAll(methodObject30900, this.onErrorForAll(methodObject30900, var3));
      }
   }

   public void addLogicalTransactionIdEventListener(LogicalTransactionIdEventListener arg0) throws SQLException {
      try {
         super.preForAll(methodObject30917, this, arg0);
         Method var10001 = methodObject30917;
         this.delegate.addLogicalTransactionIdEventListener(arg0);
         this.postForAll(var10001);
      } catch (SQLException var3) {
         this.onErrorVoidForAll(methodObject30917, var3);
      }
   }

   public OracleConnection getPhysicalConnection() {
      super.preForAll(methodObject30685, this, zeroLengthObjectArray);
      return (OracleConnection)this.postForAll(methodObject30685, this.proxyFactory.proxyForCache((Object)this.delegate.getPhysicalConnection(), this, this.proxyCache, methodObject30685));
   }

   public void setExplicitCachingEnabled(boolean arg0) throws SQLException {
      try {
         super.preForAll(methodObject30828, this, arg0);
         Method var10001 = methodObject30828;
         this.delegate.setExplicitCachingEnabled(arg0);
         this.postForAll(var10001);
      } catch (SQLException var3) {
         this.onErrorVoidForAll(methodObject30828, var3);
      }
   }

   public int numberOfDescriptorCacheEntries() {
      super.preForAll(methodObject30670, this, zeroLengthObjectArray);
      return (Integer)this.postForAll(methodObject30670, this.delegate.numberOfDescriptorCacheEntries());
   }

   public boolean getCreateStatementAsRefCursor() {
      super.preForAll(methodObject30841, this, zeroLengthObjectArray);
      return (Boolean)this.postForAll(methodObject30841, this.delegate.getCreateStatementAsRefCursor());
   }

   public boolean isValid(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject30927, this, arg0);
         return (Boolean)this.postForAll(methodObject30927, this.delegate.isValid(arg0));
      } catch (SQLException var3) {
         return (Boolean)this.postForAll(methodObject30927, this.onErrorForAll(methodObject30927, var3));
      }
   }

   public int getVarTypeMaxLenCompat() throws SQLException {
      try {
         super.preForAll(methodObject30650, this, zeroLengthObjectArray);
         return (Integer)this.postForAll(methodObject30650, this.delegate.getVarTypeMaxLenCompat());
      } catch (SQLException var2) {
         return (Integer)this.postForAll(methodObject30650, this.onErrorForAll(methodObject30650, var2));
      }
   }

   public void clearAllApplicationContext(String arg0) throws SQLException {
      try {
         super.preForAll(methodObject30916, this, arg0);
         Method var10001 = methodObject30916;
         this.delegate.clearAllApplicationContext(arg0);
         this.postForAll(var10001);
      } catch (SQLException var3) {
         this.onErrorVoidForAll(methodObject30916, var3);
      }
   }

   public String nativeSQL(String arg0) throws SQLException {
      try {
         super.preForAll(methodObject30959, this, arg0);
         return (String)this.postForAll(methodObject30959, (Object)this.delegate.nativeSQL(arg0));
      } catch (SQLException var3) {
         return (String)this.postForAll(methodObject30959, this.onErrorForAll(methodObject30959, var3));
      }
   }

   public CallableStatement prepareCall(String arg0, int arg1, int arg2, int arg3) throws SQLException {
      try {
         super.preForAll(methodObject30947, this, arg0, arg1, arg2, arg3);
         return (CallableStatement)this.postForAll(methodObject30947, this.proxyFactory.proxyForCreateCache((Object)this.delegate.prepareCall(arg0, arg1, arg2, arg3), this, this.proxyCache, methodObject30947));
      } catch (SQLException var6) {
         return (CallableStatement)this.postForAll(methodObject30947, this.onErrorForAll(methodObject30947, var6));
      }
   }

   public void setReplayContext(ReplayContext[] arg0) throws SQLException {
      try {
         super.preForAll(methodObject30690, this, arg0);
         Method var10001 = methodObject30690;
         this.delegate.setReplayContext(arg0);
         this.postForAll(var10001);
      } catch (SQLException var3) {
         this.onErrorVoidForAll(methodObject30690, var3);
      }
   }

   public DATE createDATE(Timestamp arg0, Calendar arg1) throws SQLException {
      try {
         super.preForAll(methodObject30873, this, arg0, arg1);
         return (DATE)this.postForAll(methodObject30873, (Object)this.delegate.createDATE(arg0, arg1));
      } catch (SQLException var4) {
         return (DATE)this.postForAll(methodObject30873, this.onErrorForAll(methodObject30873, var4));
      }
   }

   public void doXSSessionChangeOp(OracleConnection.XSSessionSetOperationCode arg0, byte[] arg1, XSSecureId arg2, XSSessionParameters arg3) throws SQLException {
      try {
         super.preForAll(methodObject30755, this, arg0, arg1, arg2, arg3);
         Method var10001 = methodObject30755;
         this.delegate.doXSSessionChangeOp(arg0, arg1, arg2, arg3);
         this.postForAll(var10001);
      } catch (SQLException var6) {
         this.onErrorVoidForAll(methodObject30755, var6);
      }
   }

   public long getStartTime() throws SQLException {
      try {
         super.preForAll(methodObject30723, this, zeroLengthObjectArray);
         return (Long)this.postForAll(methodObject30723, this.delegate.getStartTime());
      } catch (SQLException var2) {
         return (Long)this.postForAll(methodObject30723, this.onErrorForAll(methodObject30723, var2));
      }
   }

   public Object unwrap(Class arg0) throws SQLException {
      try {
         super.preForAll(methodObject30975, this, arg0);
         return this.postForAll(methodObject30975, super.unwrap(arg0));
      } catch (SQLException var3) {
         return this.postForAll(methodObject30975, this.onErrorForAll(methodObject30975, var3));
      }
   }

   public Datum toDatum(CustomDatum arg0) throws SQLException {
      try {
         super.preForAll(methodObject30676, this, arg0);
         return (Datum)this.postForAll(methodObject30676, (Object)this.delegate.toDatum(arg0));
      } catch (SQLException var3) {
         return (Datum)this.postForAll(methodObject30676, this.onErrorForAll(methodObject30676, var3));
      }
   }

   public boolean isLobStreamPosStandardCompliant() throws SQLException {
      try {
         super.preForAll(methodObject30769, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject30769, this.delegate.isLobStreamPosStandardCompliant());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject30769, this.onErrorForAll(methodObject30769, var2));
      }
   }

   public DatabaseChangeRegistration getDatabaseChangeRegistration(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject30861, this, arg0);
         return (DatabaseChangeRegistration)this.postForAll(methodObject30861, (Object)this.delegate.getDatabaseChangeRegistration(arg0));
      } catch (SQLException var3) {
         return (DatabaseChangeRegistration)this.postForAll(methodObject30861, this.onErrorForAll(methodObject30861, var3));
      }
   }

   public int getNegotiatedSDU() throws SQLException {
      try {
         super.preForAll(methodObject30704, this, zeroLengthObjectArray);
         return (Integer)this.postForAll(methodObject30704, this.delegate.getNegotiatedSDU());
      } catch (SQLException var2) {
         return (Integer)this.postForAll(methodObject30704, this.onErrorForAll(methodObject30704, var2));
      }
   }

   public XAResource getXAResource() throws SQLException {
      try {
         super.preForAll(methodObject30744, this, zeroLengthObjectArray);
         return (XAResource)this.postForAll(methodObject30744, (Object)this.delegate.getXAResource());
      } catch (SQLException var2) {
         return (XAResource)this.postForAll(methodObject30744, this.onErrorForAll(methodObject30744, var2));
      }
   }

   public void setHoldability(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject30964, this, arg0);
         Method var10001 = methodObject30964;
         this.delegate.setHoldability(arg0);
         this.postForAll(var10001);
      } catch (SQLException var3) {
         this.onErrorVoidForAll(methodObject30964, var3);
      }
   }

   public void setAutoClose(boolean arg0) throws SQLException {
      try {
         super.preForAll(methodObject30815, this, arg0);
         Method var10001 = methodObject30815;
         this.delegate.setAutoClose(arg0);
         this.postForAll(var10001);
      } catch (SQLException var3) {
         this.onErrorVoidForAll(methodObject30815, var3);
      }
   }

   public String getClientInfo(String arg0) throws SQLException {
      try {
         super.preForAll(methodObject30971, this, arg0);
         return (String)this.postForAll(methodObject30971, (Object)this.delegate.getClientInfo(arg0));
      } catch (SQLException var3) {
         return (String)this.postForAll(methodObject30971, this.onErrorForAll(methodObject30971, var3));
      }
   }

   public void registerSQLType(String arg0, String arg1) throws SQLException {
      try {
         super.preForAll(methodObject30814, this, arg0, arg1);
         Method var10001 = methodObject30814;
         this.delegate.registerSQLType(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject30814, var4);
      }
   }

   public void openProxySession(int arg0, Properties arg1) throws SQLException {
      try {
         super.preForAll(methodObject30794, this, arg0, arg1);
         Method var10001 = methodObject30794;
         this.delegate.openProxySession(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject30794, var4);
      }
   }

   public TIMESTAMP createTIMESTAMP(Time arg0) throws SQLException {
      try {
         super.preForAll(methodObject30889, this, arg0);
         return (TIMESTAMP)this.postForAll(methodObject30889, (Object)this.delegate.createTIMESTAMP(arg0));
      } catch (SQLException var3) {
         return (TIMESTAMP)this.postForAll(methodObject30889, this.onErrorForAll(methodObject30889, var3));
      }
   }

   public int getStatementCacheSize() throws SQLException {
      try {
         super.preForAll(methodObject30825, this, zeroLengthObjectArray);
         return (Integer)this.postForAll(methodObject30825, this.delegate.getStatementCacheSize());
      } catch (SQLException var2) {
         return (Integer)this.postForAll(methodObject30825, this.onErrorForAll(methodObject30825, var2));
      }
   }

   public void setUsable(boolean arg0) {
      super.preForAll(methodObject30757, this, arg0);
      Method var10001 = methodObject30757;
      this.delegate.setUsable(arg0);
      this.postForAll(var10001);
   }

   public Map getTypeMap() throws SQLException {
      try {
         super.preForAll(methodObject30708, this, zeroLengthObjectArray);
         return (Map)this.postForAll(methodObject30708, (Object)this.delegate.getTypeMap());
      } catch (SQLException var2) {
         return (Map)this.postForAll(methodObject30708, this.onErrorForAll(methodObject30708, var2));
      }
   }

   public void oracleReleaseSavepoint(OracleSavepoint arg0) throws SQLException {
      try {
         super.preForTxnControl(methodObject30786, this, arg0);
         Method var10001 = methodObject30786;
         this.delegate.oracleReleaseSavepoint(arg0 instanceof _Proxy_ ? (OracleSavepoint)((_Proxy_)arg0)._getDelegate_() : arg0);
         this.postForAll(var10001);
      } catch (SQLException var3) {
         this.onErrorVoidForAll(methodObject30786, var3);
      }
   }

   public AQMessage dequeue(String arg0, AQDequeueOptions arg1, String arg2) throws SQLException {
      try {
         super.preForAll(methodObject30859, this, arg0, arg1, arg2);
         return (AQMessage)this.postForAll(methodObject30859, (Object)this.delegate.dequeue(arg0, arg1, arg2));
      } catch (SQLException var5) {
         return (AQMessage)this.postForAll(methodObject30859, this.onErrorForAll(methodObject30859, var5));
      }
   }

   public Properties getDBAccessProperties() throws SQLException {
      try {
         super.preForAll(methodObject30652, this, zeroLengthObjectArray);
         return (Properties)this.postForAll(methodObject30652, (Object)this.delegate.getDBAccessProperties());
      } catch (SQLException var2) {
         return (Properties)this.postForAll(methodObject30652, this.onErrorForAll(methodObject30652, var2));
      }
   }

   public void cancel() throws SQLException {
      try {
         super.preForCancel(methodObject30787, this, zeroLengthObjectArray);
         Method var10001 = methodObject30787;
         this.delegate.cancel();
         this.postForCancel(var10001);
      } catch (SQLException var2) {
         this.onErrorVoidForAll(methodObject30787, var2);
      }
   }

   public String[] getEndToEndMetrics() throws SQLException {
      try {
         super.preForAll(methodObject30798, this, zeroLengthObjectArray);
         return (String[])this.postForAll(methodObject30798, (Object)this.delegate.getEndToEndMetrics());
      } catch (SQLException var2) {
         return (String[])this.postForAll(methodObject30798, this.onErrorForAll(methodObject30798, var2));
      }
   }

   public void close(Properties arg0) throws SQLException {
      try {
         super.preForClosure(methodObject30778, this, arg0);
         Method var10001 = methodObject30778;
         this.delegate.close(arg0);
         this.postForClosure(var10001);
      } catch (SQLException var3) {
         this.onErrorVoidForAll(methodObject30778, var3);
      }
   }

   public void removeXSEventListener(XSEventListener arg0) throws SQLException {
      try {
         super.preForAll(methodObject30761, this, arg0);
         Method var10001 = methodObject30761;
         this.delegate.removeXSEventListener(arg0);
         this.postForAll(var10001);
      } catch (SQLException var3) {
         this.onErrorVoidForAll(methodObject30761, var3);
      }
   }

   public void setReadOnly(boolean arg0) throws SQLException {
      try {
         super.preForAll(methodObject30925, this, arg0);
         Method var10001 = methodObject30925;
         this.delegate.setReadOnly(arg0);
         this.postForAll(var10001);
      } catch (SQLException var3) {
         this.onErrorVoidForAll(methodObject30925, var3);
      }
   }

   public PreparedStatement prepareStatement(String arg0) throws SQLException {
      try {
         super.preForAll(methodObject30948, this, arg0);
         return (PreparedStatement)this.postForAll(methodObject30948, this.proxyFactory.proxyForCreateCache((Object)this.delegate.prepareStatement(arg0), this, this.proxyCache, methodObject30948));
      } catch (SQLException var3) {
         return (PreparedStatement)this.postForAll(methodObject30948, this.onErrorForAll(methodObject30948, var3));
      }
   }

   public int getMaxCharSize() throws SQLException {
      try {
         super.preForAll(methodObject30716, this, zeroLengthObjectArray);
         return (Integer)this.postForAll(methodObject30716, this.delegate.getMaxCharSize());
      } catch (SQLException var2) {
         return (Integer)this.postForAll(methodObject30716, this.onErrorForAll(methodObject30716, var2));
      }
   }

   public PreparedStatement prepareStatement(String arg0, int arg1) throws SQLException {
      try {
         super.preForAll(methodObject30951, this, arg0, arg1);
         return (PreparedStatement)this.postForAll(methodObject30951, this.proxyFactory.proxyForCreateCache((Object)this.delegate.prepareStatement(arg0, arg1), this, this.proxyCache, methodObject30951));
      } catch (SQLException var4) {
         return (PreparedStatement)this.postForAll(methodObject30951, this.onErrorForAll(methodObject30951, var4));
      }
   }

   public TimeZone getDefaultTimeZone() throws SQLException {
      try {
         super.preForAll(methodObject30914, this, zeroLengthObjectArray);
         return (TimeZone)this.postForAll(methodObject30914, (Object)this.delegate.getDefaultTimeZone());
      } catch (SQLException var2) {
         return (TimeZone)this.postForAll(methodObject30914, this.onErrorForAll(methodObject30914, var2));
      }
   }

   public INTERVALDS createINTERVALDS(String arg0) throws SQLException {
      try {
         super.preForAll(methodObject30875, this, arg0);
         return (INTERVALDS)this.postForAll(methodObject30875, (Object)this.delegate.createINTERVALDS(arg0));
      } catch (SQLException var3) {
         return (INTERVALDS)this.postForAll(methodObject30875, this.onErrorForAll(methodObject30875, var3));
      }
   }

   public short getDriverCharSet() {
      super.preForAll(methodObject30714, this, zeroLengthObjectArray);
      return (Short)this.postForAll(methodObject30714, this.delegate.getDriverCharSet());
   }

   public short getNCharSet() {
      super.preForAll(methodObject30679, this, zeroLengthObjectArray);
      return (Short)this.postForAll(methodObject30679, this.delegate.getNCharSet());
   }

   public boolean getTimestamptzInGmt() {
      super.preForAll(methodObject30766, this, zeroLengthObjectArray);
      return (Boolean)this.postForAll(methodObject30766, this.delegate.getTimestamptzInGmt());
   }

   public boolean isConnectionSocketKeepAlive() throws SocketException, SQLException {
      try {
         super.preForAll(methodObject30770, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject30770, this.delegate.isConnectionSocketKeepAlive());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject30770, this.onErrorForAll(methodObject30770, var2));
      }
   }

   public void setFDO(byte[] arg0) throws SQLException {
      try {
         super.preForAll(methodObject30664, this, arg0);
         Method var10001 = methodObject30664;
         this.delegate.setFDO(arg0);
         this.postForAll(var10001);
      } catch (SQLException var3) {
         this.onErrorVoidForAll(methodObject30664, var3);
      }
   }

   public boolean isDRCPEnabled() throws SQLException {
      try {
         super.preForAll(methodObject30921, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject30921, this.delegate.isDRCPEnabled());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject30921, this.onErrorForAll(methodObject30921, var2));
      }
   }

   public boolean getRemarksReporting() {
      super.preForAll(methodObject30803, this, zeroLengthObjectArray);
      return (Boolean)this.postForAll(methodObject30803, this.delegate.getRemarksReporting());
   }

   public void setRemarksReporting(boolean arg0) {
      super.preForAll(methodObject30820, this, arg0);
      Method var10001 = methodObject30820;
      this.delegate.setRemarksReporting(arg0);
      this.postForAll(var10001);
   }

   public TIMESTAMPLTZ createTIMESTAMPLTZ(String arg0, Calendar arg1) throws SQLException {
      try {
         super.preForAll(methodObject30904, this, arg0, arg1);
         return (TIMESTAMPLTZ)this.postForAll(methodObject30904, (Object)this.delegate.createTIMESTAMPLTZ(arg0, arg1));
      } catch (SQLException var4) {
         return (TIMESTAMPLTZ)this.postForAll(methodObject30904, this.onErrorForAll(methodObject30904, var4));
      }
   }

   public int pingDatabase() throws SQLException {
      try {
         super.preForAll(methodObject30811, this, zeroLengthObjectArray);
         return (Integer)this.postForAll(methodObject30811, this.delegate.pingDatabase());
      } catch (SQLException var2) {
         return (Integer)this.postForAll(methodObject30811, this.onErrorForAll(methodObject30811, var2));
      }
   }

   public int getConnectionReleasePriority() throws SQLException {
      try {
         super.preForAll(methodObject30854, this, zeroLengthObjectArray);
         return (Integer)this.postForAll(methodObject30854, this.delegate.getConnectionReleasePriority());
      } catch (SQLException var2) {
         return (Integer)this.postForAll(methodObject30854, this.onErrorForAll(methodObject30854, var2));
      }
   }

   public boolean getXAErrorFlag() {
      super.preForAll(methodObject30810, this, zeroLengthObjectArray);
      return (Boolean)this.postForAll(methodObject30810, this.delegate.getXAErrorFlag());
   }

   public Struct createStruct(String arg0, Object[] arg1) throws SQLException {
      try {
         super.preForAll(methodObject30937, this, arg0, arg1);
         return (Struct)this.postForAll(methodObject30937, this.proxyFactory.proxyForCreateCache((Object)super.createStruct(arg0, arg1), this, this.proxyCache, methodObject30937));
      } catch (SQLException var4) {
         return (Struct)this.postForAll(methodObject30937, this.onErrorForAll(methodObject30937, var4));
      }
   }

   public String getDefaultSchemaNameForNamedTypes() throws SQLException {
      try {
         super.preForAll(methodObject30756, this, zeroLengthObjectArray);
         return (String)this.postForAll(methodObject30756, (Object)this.delegate.getDefaultSchemaNameForNamedTypes());
      } catch (SQLException var2) {
         return (String)this.postForAll(methodObject30756, this.onErrorForAll(methodObject30756, var2));
      }
   }

   public int getTxnMode() {
      super.preForAll(methodObject30728, this, zeroLengthObjectArray);
      return (Integer)this.postForAll(methodObject30728, this.delegate.getTxnMode());
   }

   public JMSMessage jmsDequeue(String arg0, JMSDequeueOptions arg1) throws SQLException {
      try {
         super.preForAll(methodObject30699, this, arg0, arg1);
         return (JMSMessage)this.postForAll(methodObject30699, (Object)this.delegate.jmsDequeue(arg0, arg1));
      } catch (SQLException var4) {
         return (JMSMessage)this.postForAll(methodObject30699, this.onErrorForAll(methodObject30699, var4));
      }
   }

   public String getUserName() throws SQLException {
      try {
         super.preForAll(methodObject30807, this, zeroLengthObjectArray);
         return (String)this.postForAll(methodObject30807, (Object)this.delegate.getUserName());
      } catch (SQLException var2) {
         return (String)this.postForAll(methodObject30807, this.onErrorForAll(methodObject30807, var2));
      }
   }

   public TIMESTAMPLTZ createTIMESTAMPLTZ(Time arg0, Calendar arg1) throws SQLException {
      try {
         super.preForAll(methodObject30902, this, arg0, arg1);
         return (TIMESTAMPLTZ)this.postForAll(methodObject30902, (Object)this.delegate.createTIMESTAMPLTZ(arg0, arg1));
      } catch (SQLException var4) {
         return (TIMESTAMPLTZ)this.postForAll(methodObject30902, this.onErrorForAll(methodObject30902, var4));
      }
   }

   public void addXSEventListener(XSEventListener arg0) throws SQLException {
      try {
         super.preForAll(methodObject30759, this, arg0);
         Method var10001 = methodObject30759;
         this.delegate.addXSEventListener(arg0);
         this.postForAll(var10001);
      } catch (SQLException var3) {
         this.onErrorVoidForAll(methodObject30759, var3);
      }
   }

   public void setDefaultExecuteBatch(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject30816, this, arg0);
         Method var10001 = methodObject30816;
         this.delegate.setDefaultExecuteBatch(arg0);
         this.postForAll(var10001);
      } catch (SQLException var3) {
         this.onErrorVoidForAll(methodObject30816, var3);
      }
   }

   public Object getJavaObject(String arg0) throws SQLException {
      try {
         super.preForAll(methodObject30802, this, arg0);
         return this.postForAll(methodObject30802, this.proxyFactory.proxyForCache(this.delegate.getJavaObject(arg0), this, this.proxyCache, methodObject30802));
      } catch (SQLException var3) {
         return this.postForAll(methodObject30802, this.onErrorForAll(methodObject30802, var3));
      }
   }

   public NClob createNClob() throws SQLException {
      try {
         super.preForAll(methodObject30940, this, zeroLengthObjectArray);
         return (NClob)this.postForAll(methodObject30940, this.proxyFactory.proxyForCreateCache((Object)this.delegate.createNClob(), this, this.proxyCache, methodObject30940));
      } catch (SQLException var2) {
         return (NClob)this.postForAll(methodObject30940, this.onErrorForAll(methodObject30940, var2));
      }
   }

   public boolean isProxySession() {
      super.preForAll(methodObject30848, this, zeroLengthObjectArray);
      return (Boolean)this.postForAll(methodObject30848, this.delegate.isProxySession());
   }

   public boolean getAutoCommit() throws SQLException {
      try {
         super.preForAll(methodObject30970, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject30970, this.delegate.getAutoCommit());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject30970, this.onErrorForAll(methodObject30970, var2));
      }
   }

   public void rollback(Savepoint arg0) throws SQLException {
      try {
         super.preForTxnControl(methodObject30932, this, arg0);
         Method var10001 = methodObject30932;
         this.delegate.rollback(arg0 instanceof _Proxy_ ? (Savepoint)((_Proxy_)arg0)._getDelegate_() : arg0);
         this.postForAll(var10001);
      } catch (SQLException var3) {
         this.onErrorVoidForAll(methodObject30932, var3);
      }
   }

   public void startup(oracle.jdbc.OracleConnection.DatabaseStartupMode arg0) throws SQLException {
      try {
         super.preForAll(methodObject30837, this, arg0);
         Method var10001 = methodObject30837;
         this.delegate.startup(arg0);
         this.postForAll(var10001);
      } catch (SQLException var3) {
         this.onErrorVoidForAll(methodObject30837, var3);
      }
   }

   public short getJdbcCsId() throws SQLException {
      try {
         super.preForAll(methodObject30678, this, zeroLengthObjectArray);
         return (Short)this.postForAll(methodObject30678, this.delegate.getJdbcCsId());
      } catch (SQLException var2) {
         return (Short)this.postForAll(methodObject30678, this.onErrorForAll(methodObject30678, var2));
      }
   }

   public int getHoldability() throws SQLException {
      try {
         super.preForAll(methodObject30973, this, zeroLengthObjectArray);
         return (Integer)this.postForAll(methodObject30973, this.delegate.getHoldability());
      } catch (SQLException var2) {
         return (Integer)this.postForAll(methodObject30973, this.onErrorForAll(methodObject30973, var2));
      }
   }

   public TIMESTAMPTZ createTIMESTAMPTZ(Timestamp arg0, Calendar arg1) throws SQLException {
      try {
         super.preForAll(methodObject30897, this, arg0, arg1);
         return (TIMESTAMPTZ)this.postForAll(methodObject30897, (Object)this.delegate.createTIMESTAMPTZ(arg0, arg1));
      } catch (SQLException var4) {
         return (TIMESTAMPTZ)this.postForAll(methodObject30897, this.onErrorForAll(methodObject30897, var4));
      }
   }

   public void registerTAFCallback(OracleOCIFailover arg0, Object arg1) throws SQLException {
      try {
         super.preForAll(methodObject30846, this, arg0, arg1);
         Method var10001 = methodObject30846;
         this.delegate.registerTAFCallback(arg0, arg1 instanceof _Proxy_ ? (Object)((_Proxy_)arg1)._getDelegate_() : arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject30846, var4);
      }
   }

   public void removeDescriptor(String arg0) {
      super.preForAll(methodObject30668, this, arg0);
      Method var10001 = methodObject30668;
      this.delegate.removeDescriptor(arg0);
      this.postForAll(var10001);
   }

   public OracleConnection.BufferCacheStatistics getCharBufferCacheStatistics() {
      super.preForAll(methodObject30675, this, zeroLengthObjectArray);
      return (OracleConnection.BufferCacheStatistics)this.postForAll(methodObject30675, (Object)this.delegate.getCharBufferCacheStatistics());
   }

   public void enqueue(String arg0, AQEnqueueOptions arg1, AQMessage arg2) throws SQLException {
      try {
         super.preForAll(methodObject30777, this, arg0, arg1, arg2);
         Method var10001 = methodObject30777;
         this.delegate.enqueue(arg0, arg1, arg2);
         this.postForAll(var10001);
      } catch (SQLException var5) {
         this.onErrorVoidForAll(methodObject30777, var5);
      }
   }

   public void rollback() throws SQLException {
      try {
         super.preForTxnControl(methodObject30931, this, zeroLengthObjectArray);
         Method var10001 = methodObject30931;
         this.delegate.rollback();
         this.postForAll(var10001);
      } catch (SQLException var2) {
         this.onErrorVoidForAll(methodObject30931, var2);
      }
   }

   public void beginNonRequestCalls() throws SQLException {
      try {
         super.preForAll(methodObject30773, this, zeroLengthObjectArray);
         Method var10001 = methodObject30773;
         this.delegate.beginNonRequestCalls();
         this.postForAll(var10001);
      } catch (SQLException var2) {
         this.onErrorVoidForAll(methodObject30773, var2);
      }
   }

   public Array createOracleArray(String arg0, Object arg1) throws SQLException {
      try {
         super.preForAll(methodObject30789, this, arg0, arg1);
         return (Array)this.postForAll(methodObject30789, this.proxyFactory.proxyForCreateCache((Object)super.createOracleArray(arg0, arg1 instanceof _Proxy_ ? (Object)((_Proxy_)arg1)._getDelegate_() : arg1), this, this.proxyCache, methodObject30789));
      } catch (SQLException var4) {
         return (Array)this.postForAll(methodObject30789, this.onErrorForAll(methodObject30789, var4));
      }
   }

   public void setUsingXAFlag(boolean arg0) {
      super.preForAll(methodObject30834, this, arg0);
      Method var10001 = methodObject30834;
      this.delegate.setUsingXAFlag(arg0);
      this.postForAll(var10001);
   }

   public ARRAY createARRAY(String arg0, Object arg1) throws SQLException {
      try {
         super.preForAll(methodObject30788, this, arg0, arg1);
         return (ARRAY)this.postForAll(methodObject30788, (Object)super.createARRAY(arg0, arg1 instanceof _Proxy_ ? (Object)((_Proxy_)arg1)._getDelegate_() : arg1));
      } catch (SQLException var4) {
         return (ARRAY)this.postForAll(methodObject30788, this.onErrorForAll(methodObject30788, var4));
      }
   }

   public boolean isDataInLocatorEnabled() throws SQLException {
      try {
         super.preForAll(methodObject30768, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject30768, this.delegate.isDataInLocatorEnabled());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject30768, this.onErrorForAll(methodObject30768, var2));
      }
   }

   public boolean getIncludeSynonyms() {
      super.preForAll(methodObject30800, this, zeroLengthObjectArray);
      return (Boolean)this.postForAll(methodObject30800, this.delegate.getIncludeSynonyms());
   }

   public Array createArrayOf(String arg0, Object[] arg1) throws SQLException {
      try {
         super.preForAll(methodObject30936, this, arg0, arg1);
         return (Array)this.postForAll(methodObject30936, this.proxyFactory.proxyForCreateCache((Object)super.createArrayOf(arg0, arg1), this, this.proxyCache, methodObject30936));
      } catch (SQLException var4) {
         return (Array)this.postForAll(methodObject30936, this.onErrorForAll(methodObject30936, var4));
      }
   }

   public byte[] doXSSessionCreateOp(OracleConnection.XSSessionOperationCode arg0, XSSecureId arg1, byte[] arg2, XSPrincipal arg3, String arg4, XSNamespace[] arg5, OracleConnection.XSSessionModeFlag arg6, XSKeyval arg7) throws SQLException {
      try {
         super.preForAll(methodObject30751, this, arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7);
         return (byte[])this.postForAll(methodObject30751, (Object)this.delegate.doXSSessionCreateOp(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7));
      } catch (SQLException var10) {
         return (byte[])this.postForAll(methodObject30751, this.onErrorForAll(methodObject30751, var10));
      }
   }

   public int getOCIEnvHeapAllocSize() throws SQLException {
      try {
         super.preForAll(methodObject30730, this, zeroLengthObjectArray);
         return (Integer)this.postForAll(methodObject30730, this.delegate.getOCIEnvHeapAllocSize());
      } catch (SQLException var2) {
         return (Integer)this.postForAll(methodObject30730, this.onErrorForAll(methodObject30730, var2));
      }
   }

   public BLOB createBlob(byte[] arg0) throws SQLException {
      try {
         super.preForAll(methodObject30646, this, arg0);
         return (BLOB)this.postForAll(methodObject30646, (Object)this.delegate.createBlob(arg0));
      } catch (SQLException var3) {
         return (BLOB)this.postForAll(methodObject30646, this.onErrorForAll(methodObject30646, var3));
      }
   }

   public void setXAErrorFlag(boolean arg0) {
      super.preForAll(methodObject30835, this, arg0);
      Method var10001 = methodObject30835;
      this.delegate.setXAErrorFlag(arg0);
      this.postForAll(var10001);
   }

   public OracleSavepoint oracleSetSavepoint(String arg0) throws SQLException {
      try {
         super.preForTxnControl(methodObject30785, this, arg0);
         return (OracleSavepoint)this.postForAll(methodObject30785, this.proxyFactory.proxyForCreate((Object)this.delegate.oracleSetSavepoint(arg0), this, this.proxyCache, methodObject30785));
      } catch (SQLException var3) {
         return (OracleSavepoint)this.postForAll(methodObject30785, this.onErrorForAll(methodObject30785, var3));
      }
   }

   public int getDefaultExecuteBatch() {
      super.preForAll(methodObject30796, this, zeroLengthObjectArray);
      return (Integer)this.postForAll(methodObject30796, this.delegate.getDefaultExecuteBatch());
   }

   public void setPDBChangeEventListener(PDBChangeEventListener arg0, Executor arg1) throws SQLException {
      try {
         super.preForAll(methodObject30706, this, arg0, arg1);
         Method var10001 = methodObject30706;
         this.delegate.setPDBChangeEventListener(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject30706, var4);
      }
   }

   public TIMESTAMPLTZ createTIMESTAMPLTZ(Date arg0, Calendar arg1) throws SQLException {
      try {
         super.preForAll(methodObject30901, this, arg0, arg1);
         return (TIMESTAMPLTZ)this.postForAll(methodObject30901, (Object)this.delegate.createTIMESTAMPLTZ(arg0, arg1));
      } catch (SQLException var4) {
         return (TIMESTAMPLTZ)this.postForAll(methodObject30901, this.onErrorForAll(methodObject30901, var4));
      }
   }

   public BlobDBAccess createBlobDBAccess() throws SQLException {
      try {
         super.preForAll(methodObject30659, this, zeroLengthObjectArray);
         return (BlobDBAccess)this.postForAll(methodObject30659, (Object)this.delegate.createBlobDBAccess());
      } catch (SQLException var2) {
         return (BlobDBAccess)this.postForAll(methodObject30659, this.onErrorForAll(methodObject30659, var2));
      }
   }

   public void abort(Executor arg0) throws SQLException {
      try {
         super.preForAll(methodObject30929, this, arg0);
         Method var10001 = methodObject30929;
         this.delegate.abort(arg0);
         this.postForAll(var10001);
      } catch (SQLException var3) {
         this.onErrorVoidForAll(methodObject30929, var3);
      }
   }

   public LogicalTransactionId getLogicalTransactionId() throws SQLException {
      try {
         super.preForAll(methodObject30920, this, zeroLengthObjectArray);
         return (LogicalTransactionId)this.postForAll(methodObject30920, (Object)this.delegate.getLogicalTransactionId());
      } catch (SQLException var2) {
         return (LogicalTransactionId)this.postForAll(methodObject30920, this.onErrorForAll(methodObject30920, var2));
      }
   }

   public void archive(int arg0, int arg1, String arg2) throws SQLException {
      try {
         super.preForAll(methodObject30793, this, arg0, arg1, arg2);
         Method var10001 = methodObject30793;
         this.delegate.archive(arg0, arg1, arg2);
         this.postForAll(var10001);
      } catch (SQLException var5) {
         this.onErrorVoidForAll(methodObject30793, var5);
      }
   }

   public void setPlsqlWarnings(String arg0) throws SQLException {
      try {
         super.preForAll(methodObject30855, this, arg0);
         Method var10001 = methodObject30855;
         this.delegate.setPlsqlWarnings(arg0);
         this.postForAll(var10001);
      } catch (SQLException var3) {
         this.onErrorVoidForAll(methodObject30855, var3);
      }
   }

   public void registerConnectionCacheCallback(OracleConnectionCacheCallback arg0, Object arg1, int arg2) throws SQLException {
      try {
         super.preForAll(methodObject30852, this, arg0, arg1, arg2);
         Method var10001 = methodObject30852;
         this.delegate.registerConnectionCacheCallback(arg0, arg1 instanceof _Proxy_ ? (Object)((_Proxy_)arg1)._getDelegate_() : arg1, arg2);
         this.postForAll(var10001);
      } catch (SQLException var5) {
         this.onErrorVoidForAll(methodObject30852, var5);
      }
   }

   public void setCreateStatementAsRefCursor(boolean arg0) {
      super.preForAll(methodObject30840, this, arg0);
      Method var10001 = methodObject30840;
      this.delegate.setCreateStatementAsRefCursor(arg0);
      this.postForAll(var10001);
   }

   public Properties getServerSessionInfo() throws SQLException {
      try {
         super.preForAll(methodObject30738, this, zeroLengthObjectArray);
         return (Properties)this.postForAll(methodObject30738, (Object)this.delegate.getServerSessionInfo());
      } catch (SQLException var2) {
         return (Properties)this.postForAll(methodObject30738, this.onErrorForAll(methodObject30738, var2));
      }
   }

   public int getHeartbeatNoChangeCount() throws SQLException {
      try {
         super.preForAll(methodObject30732, this, zeroLengthObjectArray);
         return (Integer)this.postForAll(methodObject30732, this.delegate.getHeartbeatNoChangeCount());
      } catch (SQLException var2) {
         return (Integer)this.postForAll(methodObject30732, this.onErrorForAll(methodObject30732, var2));
      }
   }

   public int pingDatabase(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject30812, this, arg0);
         return (Integer)this.postForAll(methodObject30812, this.delegate.pingDatabase(arg0));
      } catch (SQLException var3) {
         return (Integer)this.postForAll(methodObject30812, this.onErrorForAll(methodObject30812, var3));
      }
   }

   public boolean isReadOnly() throws SQLException {
      try {
         super.preForAll(methodObject30928, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject30928, this.delegate.isReadOnly());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject30928, this.onErrorForAll(methodObject30928, var2));
      }
   }

   public void closeInternal(boolean arg0) throws SQLException {
      try {
         super.preForAll(methodObject30733, this, arg0);
         Method var10001 = methodObject30733;
         this.delegate.closeInternal(arg0);
         this.postForAll(var10001);
      } catch (SQLException var3) {
         this.onErrorVoidForAll(methodObject30733, var3);
      }
   }

   public int getDefaultRowPrefetch() {
      super.preForAll(methodObject30797, this, zeroLengthObjectArray);
      return (Integer)this.postForAll(methodObject30797, this.delegate.getDefaultRowPrefetch());
   }

   public void setWrapper(oracle.jdbc.OracleConnection arg0) {
      super.preForAll(methodObject30847, this, arg0);
      Method var10001 = methodObject30847;
      this.delegate.setWrapper(arg0 instanceof _Proxy_ ? (oracle.jdbc.OracleConnection)((_Proxy_)arg0)._getDelegate_() : arg0);
      this.postForAll(var10001);
   }

   public void doXSNamespaceOp(OracleConnection.XSOperationCode arg0, byte[] arg1, XSNamespace[] arg2, XSSecureId arg3) throws SQLException {
      try {
         super.preForAll(methodObject30750, this, arg0, arg1, arg2, arg3);
         Method var10001 = methodObject30750;
         this.delegate.doXSNamespaceOp(arg0, arg1, arg2, arg3);
         this.postForAll(var10001);
      } catch (SQLException var6) {
         this.onErrorVoidForAll(methodObject30750, var6);
      }
   }

   public TIMESTAMPTZ createTIMESTAMPTZ(Time arg0, Calendar arg1) throws SQLException {
      try {
         super.preForAll(methodObject30895, this, arg0, arg1);
         return (TIMESTAMPTZ)this.postForAll(methodObject30895, (Object)this.delegate.createTIMESTAMPTZ(arg0, arg1));
      } catch (SQLException var4) {
         return (TIMESTAMPTZ)this.postForAll(methodObject30895, this.onErrorForAll(methodObject30895, var4));
      }
   }

   public void setSessionTimeZone(String arg0) throws SQLException {
      try {
         super.preForAll(methodObject30842, this, arg0);
         Method var10001 = methodObject30842;
         this.delegate.setSessionTimeZone(arg0);
         this.postForAll(var10001);
      } catch (SQLException var3) {
         this.onErrorVoidForAll(methodObject30842, var3);
      }
   }

   public NUMBER createNUMBER(double arg0) throws SQLException {
      try {
         super.preForAll(methodObject30883, this, arg0);
         return (NUMBER)this.postForAll(methodObject30883, (Object)this.delegate.createNUMBER(arg0));
      } catch (SQLException var4) {
         return (NUMBER)this.postForAll(methodObject30883, this.onErrorForAll(methodObject30883, var4));
      }
   }

   public BLOB createBlobWithUnpickledBytes(byte[] arg0) throws SQLException {
      try {
         super.preForAll(methodObject30740, this, arg0);
         return (BLOB)this.postForAll(methodObject30740, (Object)this.delegate.createBlobWithUnpickledBytes(arg0));
      } catch (SQLException var3) {
         return (BLOB)this.postForAll(methodObject30740, this.onErrorForAll(methodObject30740, var3));
      }
   }

   public String getDataIntegrityAlgorithmName() throws SQLException {
      try {
         super.preForAll(methodObject30909, this, zeroLengthObjectArray);
         return (String)this.postForAll(methodObject30909, (Object)this.delegate.getDataIntegrityAlgorithmName());
      } catch (SQLException var2) {
         return (String)this.postForAll(methodObject30909, this.onErrorForAll(methodObject30909, var2));
      }
   }

   public int getC2SNlsRatio() {
      super.preForAll(methodObject30715, this, zeroLengthObjectArray);
      return (Integer)this.postForAll(methodObject30715, this.delegate.getC2SNlsRatio());
   }

   public AQNotificationRegistration[] registerAQNotification(String[] arg0, Properties[] arg1, Properties arg2) throws SQLException {
      try {
         super.preForAll(methodObject30856, this, arg0, arg1, arg2);
         return (AQNotificationRegistration[])this.postForAll(methodObject30856, (Object)this.delegate.registerAQNotification(arg0, arg1, arg2));
      } catch (SQLException var5) {
         return (AQNotificationRegistration[])this.postForAll(methodObject30856, this.onErrorForAll(methodObject30856, var5));
      }
   }

   public void close(int arg0) throws SQLException {
      try {
         super.preForClosure(methodObject30779, this, arg0);
         Method var10001 = methodObject30779;
         this.delegate.close(arg0);
         this.postForClosure(var10001);
      } catch (SQLException var3) {
         this.onErrorVoidForAll(methodObject30779, var3);
      }
   }

   public short getEndToEndECIDSequenceNumber() throws SQLException {
      try {
         super.preForAll(methodObject30799, this, zeroLengthObjectArray);
         return (Short)this.postForAll(methodObject30799, this.delegate.getEndToEndECIDSequenceNumber());
      } catch (SQLException var2) {
         return (Short)this.postForAll(methodObject30799, this.onErrorForAll(methodObject30799, var2));
      }
   }

   public void setRestrictGetTables(boolean arg0) {
      super.preForAll(methodObject30821, this, arg0);
      Method var10001 = methodObject30821;
      this.delegate.setRestrictGetTables(arg0);
      this.postForAll(var10001);
   }

   public BfileDBAccess createBfileDBAccess() throws SQLException {
      try {
         super.preForAll(methodObject30687, this, zeroLengthObjectArray);
         return (BfileDBAccess)this.postForAll(methodObject30687, (Object)this.delegate.createBfileDBAccess());
      } catch (SQLException var2) {
         return (BfileDBAccess)this.postForAll(methodObject30687, this.onErrorForAll(methodObject30687, var2));
      }
   }

   public int getStmtCacheSize() {
      super.preForAll(methodObject30805, this, zeroLengthObjectArray);
      return (Integer)this.postForAll(methodObject30805, this.delegate.getStmtCacheSize());
   }

   public void setSchema(String arg0) throws SQLException {
      try {
         super.preForAll(methodObject30966, this, arg0);
         Method var10001 = methodObject30966;
         this.delegate.setSchema(arg0);
         this.postForAll(var10001);
      } catch (SQLException var3) {
         this.onErrorVoidForAll(methodObject30966, var3);
      }
   }

   public void commit() throws SQLException {
      try {
         super.preForTxnControl(methodObject30930, this, zeroLengthObjectArray);
         Method var10001 = methodObject30930;
         this.delegate.commit();
         this.postForAll(var10001);
      } catch (SQLException var2) {
         this.onErrorVoidForAll(methodObject30930, var2);
      }
   }

   public NUMBER createNUMBER(BigDecimal arg0) throws SQLException {
      try {
         super.preForAll(methodObject30884, this, arg0);
         return (NUMBER)this.postForAll(methodObject30884, (Object)this.delegate.createNUMBER(arg0));
      } catch (SQLException var3) {
         return (NUMBER)this.postForAll(methodObject30884, this.onErrorForAll(methodObject30884, var3));
      }
   }

   public SQLWarning getWarnings() throws SQLException {
      try {
         super.preForAll(methodObject30958, this, zeroLengthObjectArray);
         return (SQLWarning)this.postForAll(methodObject30958, (Object)this.delegate.getWarnings());
      } catch (SQLException var2) {
         return (SQLWarning)this.postForAll(methodObject30958, this.onErrorForAll(methodObject30958, var2));
      }
   }

   public void setClientInfo(Properties arg0) throws SQLClientInfoException {
      super.preForAll(methodObject30963, this, arg0);
      Method var10001 = methodObject30963;
      this.delegate.setClientInfo(arg0);
      this.postForAll(var10001);
   }

   public void setStartTime(long arg0) throws SQLException {
      try {
         super.preForAll(methodObject30722, this, arg0);
         Method var10001 = methodObject30722;
         this.delegate.setStartTime(arg0);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject30722, var4);
      }
   }

   public Map getJavaObjectTypeMap() {
      super.preForAll(methodObject30656, this, zeroLengthObjectArray);
      return (Map)this.postForAll(methodObject30656, (Object)this.delegate.getJavaObjectTypeMap());
   }

   public boolean getUse1900AsYearForTime() {
      super.preForAll(methodObject30767, this, zeroLengthObjectArray);
      return (Boolean)this.postForAll(methodObject30767, this.delegate.getUse1900AsYearForTime());
   }

   public ResultSetMetaData newStructMetaData(StructDescriptor arg0) throws SQLException {
      try {
         super.preForAll(methodObject30683, this, arg0);
         return (ResultSetMetaData)this.postForAll(methodObject30683, this.proxyFactory.proxyForCache((Object)this.delegate.newStructMetaData(arg0), this, this.proxyCache, methodObject30683));
      } catch (SQLException var3) {
         return (ResultSetMetaData)this.postForAll(methodObject30683, this.onErrorForAll(methodObject30683, var3));
      }
   }

   public String getSQLType(Object arg0) throws SQLException {
      try {
         super.preForAll(methodObject30804, this, arg0);
         return (String)this.postForAll(methodObject30804, (Object)this.delegate.getSQLType(arg0 instanceof _Proxy_ ? (Object)((_Proxy_)arg0)._getDelegate_() : arg0));
      } catch (SQLException var3) {
         return (String)this.postForAll(methodObject30804, this.onErrorForAll(methodObject30804, var3));
      }
   }

   public DATE createDATE(Time arg0, Calendar arg1) throws SQLException {
      try {
         super.preForAll(methodObject30872, this, arg0, arg1);
         return (DATE)this.postForAll(methodObject30872, (Object)this.delegate.createDATE(arg0, arg1));
      } catch (SQLException var4) {
         return (DATE)this.postForAll(methodObject30872, this.onErrorForAll(methodObject30872, var4));
      }
   }

   public void unregisterJMSNotification(JMSNotificationRegistration arg0) throws SQLException {
      try {
         super.preForAll(methodObject30702, this, arg0);
         Method var10001 = methodObject30702;
         this.delegate.unregisterJMSNotification(arg0);
         this.postForAll(var10001);
      } catch (SQLException var3) {
         this.onErrorVoidForAll(methodObject30702, var3);
      }
   }

   public Connection _getPC() {
      super.preForAll(methodObject30790, this, zeroLengthObjectArray);
      return (Connection)this.postForAll(methodObject30790, (Object)this.delegate._getPC());
   }

   public void addLogicalTransactionIdEventListener(LogicalTransactionIdEventListener arg0, Executor arg1) throws SQLException {
      try {
         super.preForAll(methodObject30918, this, arg0, arg1);
         Method var10001 = methodObject30918;
         this.delegate.addLogicalTransactionIdEventListener(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject30918, var4);
      }
   }

   public Connection getLogicalConnection(OraclePooledConnection arg0, boolean arg1) throws SQLException {
      try {
         super.preForAll(methodObject30726, this, arg0, arg1);
         return (Connection)this.postForAll(methodObject30726, this.proxyFactory.proxyForCache((Object)this.delegate.getLogicalConnection(arg0, arg1), this, this.proxyCache, methodObject30726));
      } catch (SQLException var4) {
         return (Connection)this.postForAll(methodObject30726, this.onErrorForAll(methodObject30726, var4));
      }
   }

   public PreparedStatement prepareStatement(String arg0, String[] arg1) throws SQLException {
      try {
         super.preForAll(methodObject30953, this, arg0, arg1);
         return (PreparedStatement)this.postForAll(methodObject30953, this.proxyFactory.proxyForCreateCache((Object)this.delegate.prepareStatement(arg0, arg1), this, this.proxyCache, methodObject30953));
      } catch (SQLException var4) {
         return (PreparedStatement)this.postForAll(methodObject30953, this.onErrorForAll(methodObject30953, var4));
      }
   }

   public DATE createDATE(Time arg0) throws SQLException {
      try {
         super.preForAll(methodObject30869, this, arg0);
         return (DATE)this.postForAll(methodObject30869, (Object)this.delegate.createDATE(arg0));
      } catch (SQLException var3) {
         return (DATE)this.postForAll(methodObject30869, this.onErrorForAll(methodObject30869, var3));
      }
   }

   public void close() throws SQLException {
      try {
         super.preForClosure(methodObject30926, this, zeroLengthObjectArray);
         Method var10001 = methodObject30926;
         this.delegate.close();
         this.postForClosure(var10001);
      } catch (SQLException var2) {
         this.onErrorVoidForAll(methodObject30926, var2);
      }
   }

   public NUMBER createNUMBER(short arg0) throws SQLException {
      try {
         super.preForAll(methodObject30879, this, arg0);
         return (NUMBER)this.postForAll(methodObject30879, (Object)this.delegate.createNUMBER(arg0));
      } catch (SQLException var3) {
         return (NUMBER)this.postForAll(methodObject30879, this.onErrorForAll(methodObject30879, var3));
      }
   }

   public void unregisterDatabaseChangeNotification(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject30864, this, arg0);
         Method var10001 = methodObject30864;
         this.delegate.unregisterDatabaseChangeNotification(arg0);
         this.postForAll(var10001);
      } catch (SQLException var3) {
         this.onErrorVoidForAll(methodObject30864, var3);
      }
   }

   public TypeDescriptor[] getTypeDescriptorsFromListInCurrentSchema(String[] arg0) throws SQLException {
      try {
         super.preForAll(methodObject30907, this, arg0);
         return (TypeDescriptor[])this.postForAll(methodObject30907, (Object)this.delegate.getTypeDescriptorsFromListInCurrentSchema(arg0));
      } catch (SQLException var3) {
         return (TypeDescriptor[])this.postForAll(methodObject30907, this.onErrorForAll(methodObject30907, var3));
      }
   }

   public String getDatabaseTimeZone() throws SQLException {
      try {
         super.preForAll(methodObject30765, this, zeroLengthObjectArray);
         return (String)this.postForAll(methodObject30765, (Object)this.delegate.getDatabaseTimeZone());
      } catch (SQLException var2) {
         return (String)this.postForAll(methodObject30765, this.onErrorForAll(methodObject30765, var2));
      }
   }

   public DatabaseChangeRegistration registerDatabaseChangeNotification(Properties arg0) throws SQLException {
      try {
         super.preForAll(methodObject30860, this, arg0);
         return (DatabaseChangeRegistration)this.postForAll(methodObject30860, (Object)this.delegate.registerDatabaseChangeNotification(arg0));
      } catch (SQLException var3) {
         return (DatabaseChangeRegistration)this.postForAll(methodObject30860, this.onErrorForAll(methodObject30860, var3));
      }
   }

   public CLOB createClobWithUnpickledBytes(byte[] arg0) throws SQLException {
      try {
         super.preForAll(methodObject30739, this, arg0);
         return (CLOB)this.postForAll(methodObject30739, (Object)this.delegate.createClobWithUnpickledBytes(arg0));
      } catch (SQLException var3) {
         return (CLOB)this.postForAll(methodObject30739, this.onErrorForAll(methodObject30739, var3));
      }
   }

   public DATE createDATE(String arg0) throws SQLException {
      try {
         super.preForAll(methodObject30874, this, arg0);
         return (DATE)this.postForAll(methodObject30874, (Object)this.delegate.createDATE(arg0));
      } catch (SQLException var3) {
         return (DATE)this.postForAll(methodObject30874, this.onErrorForAll(methodObject30874, var3));
      }
   }

   public Clob createClob() throws SQLException {
      try {
         super.preForAll(methodObject30939, this, zeroLengthObjectArray);
         return (Clob)this.postForAll(methodObject30939, this.proxyFactory.proxyForCreateCache((Object)this.delegate.createClob(), this, this.proxyCache, methodObject30939));
      } catch (SQLException var2) {
         return (Clob)this.postForAll(methodObject30939, this.onErrorForAll(methodObject30939, var2));
      }
   }

   public void setReplayingMode(boolean arg0) throws SQLException {
      try {
         super.preForAll(methodObject30772, this, arg0);
         Method var10001 = methodObject30772;
         this.delegate.setReplayingMode(arg0);
         this.postForAll(var10001);
      } catch (SQLException var3) {
         this.onErrorVoidForAll(methodObject30772, var3);
      }
   }

   public TIMESTAMPLTZ createTIMESTAMPLTZ(DATE arg0, Calendar arg1) throws SQLException {
      try {
         super.preForAll(methodObject30905, this, arg0, arg1);
         return (TIMESTAMPLTZ)this.postForAll(methodObject30905, (Object)this.delegate.createTIMESTAMPLTZ(arg0, arg1));
      } catch (SQLException var4) {
         return (TIMESTAMPLTZ)this.postForAll(methodObject30905, this.onErrorForAll(methodObject30905, var4));
      }
   }

   public void setImplicitCachingEnabled(boolean arg0) throws SQLException {
      try {
         super.preForAll(methodObject30826, this, arg0);
         Method var10001 = methodObject30826;
         this.delegate.setImplicitCachingEnabled(arg0);
         this.postForAll(var10001);
      } catch (SQLException var3) {
         this.onErrorVoidForAll(methodObject30826, var3);
      }
   }

   public AQMessage dequeue(String arg0, AQDequeueOptions arg1, byte[] arg2) throws SQLException {
      try {
         super.preForAll(methodObject30858, this, arg0, arg1, arg2);
         return (AQMessage)this.postForAll(methodObject30858, (Object)this.delegate.dequeue(arg0, arg1, arg2));
      } catch (SQLException var5) {
         return (AQMessage)this.postForAll(methodObject30858, this.onErrorForAll(methodObject30858, var5));
      }
   }

   public void abort() throws SQLException {
      try {
         super.preForClosure(methodObject30781, this, zeroLengthObjectArray);
         Method var10001 = methodObject30781;
         this.delegate.abort();
         this.postForClosure(var10001);
      } catch (SQLException var2) {
         this.onErrorVoidForAll(methodObject30781, var2);
      }
   }

   public Object getConnectionCacheCallbackPrivObj() throws SQLException {
      try {
         super.preForAll(methodObject30736, this, zeroLengthObjectArray);
         return this.postForAll(methodObject30736, this.proxyFactory.proxyForCache(this.delegate.getConnectionCacheCallbackPrivObj(), this, this.proxyCache, methodObject30736));
      } catch (SQLException var2) {
         return this.postForAll(methodObject30736, this.onErrorForAll(methodObject30736, var2));
      }
   }

   public String getAuthenticationAdaptorName() throws SQLException {
      try {
         super.preForAll(methodObject30911, this, zeroLengthObjectArray);
         return (String)this.postForAll(methodObject30911, (Object)this.delegate.getAuthenticationAdaptorName());
      } catch (SQLException var2) {
         return (String)this.postForAll(methodObject30911, this.onErrorForAll(methodObject30911, var2));
      }
   }

   public boolean getBigEndian() throws SQLException {
      try {
         super.preForAll(methodObject30666, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject30666, this.delegate.getBigEndian());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject30666, this.onErrorForAll(methodObject30666, var2));
      }
   }

   public void endNonRequestCalls() throws SQLException {
      try {
         super.preForAll(methodObject30689, this, zeroLengthObjectArray);
         Method var10001 = methodObject30689;
         this.delegate.endNonRequestCalls();
         this.postForAll(var10001);
      } catch (SQLException var2) {
         this.onErrorVoidForAll(methodObject30689, var2);
      }
   }

   public void addXSEventListener(XSEventListener arg0, Executor arg1) throws SQLException {
      try {
         super.preForAll(methodObject30760, this, arg0, arg1);
         Method var10001 = methodObject30760;
         this.delegate.addXSEventListener(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject30760, var4);
      }
   }

   public Properties getConnectionAttributes() throws SQLException {
      try {
         super.preForAll(methodObject30850, this, zeroLengthObjectArray);
         return (Properties)this.postForAll(methodObject30850, (Object)this.delegate.getConnectionAttributes());
      } catch (SQLException var2) {
         return (Properties)this.postForAll(methodObject30850, this.onErrorForAll(methodObject30850, var2));
      }
   }

   public Statement createStatement(int arg0, int arg1, int arg2) throws SQLException {
      try {
         super.preForAll(methodObject30944, this, arg0, arg1, arg2);
         return (Statement)this.postForAll(methodObject30944, this.proxyFactory.proxyForCreateCache((Object)this.delegate.createStatement(arg0, arg1, arg2), this, this.proxyCache, methodObject30944));
      } catch (SQLException var5) {
         return (Statement)this.postForAll(methodObject30944, this.onErrorForAll(methodObject30944, var5));
      }
   }

   public NUMBER createNUMBER(String arg0, int arg1) throws SQLException {
      try {
         super.preForAll(methodObject30886, this, arg0, arg1);
         return (NUMBER)this.postForAll(methodObject30886, (Object)this.delegate.createNUMBER(arg0, arg1));
      } catch (SQLException var4) {
         return (NUMBER)this.postForAll(methodObject30886, this.onErrorForAll(methodObject30886, var4));
      }
   }

   public PreparedStatement prepareStatement(String arg0, int[] arg1) throws SQLException {
      try {
         super.preForAll(methodObject30952, this, arg0, arg1);
         return (PreparedStatement)this.postForAll(methodObject30952, this.proxyFactory.proxyForCreateCache((Object)this.delegate.prepareStatement(arg0, arg1), this, this.proxyCache, methodObject30952));
      } catch (SQLException var4) {
         return (PreparedStatement)this.postForAll(methodObject30952, this.onErrorForAll(methodObject30952, var4));
      }
   }

   public Object getDescriptor(byte[] arg0) {
      super.preForAll(methodObject30644, this, arg0);
      return this.postForAll(methodObject30644, this.proxyFactory.proxyForCache(this.delegate.getDescriptor(arg0), this, this.proxyCache, methodObject30644));
   }

   public byte[] getFDO(boolean arg0) throws SQLException {
      try {
         super.preForAll(methodObject30665, this, arg0);
         return (byte[])this.postForAll(methodObject30665, (Object)this.delegate.getFDO(arg0));
      } catch (SQLException var3) {
         return (byte[])this.postForAll(methodObject30665, this.onErrorForAll(methodObject30665, var3));
      }
   }

   public String getCatalog() throws SQLException {
      try {
         super.preForAll(methodObject30954, this, zeroLengthObjectArray);
         return (String)this.postForAll(methodObject30954, (Object)this.delegate.getCatalog());
      } catch (SQLException var2) {
         return (String)this.postForAll(methodObject30954, this.onErrorForAll(methodObject30954, var2));
      }
   }

   public EnumSet getTransactionState() throws SQLException {
      try {
         super.preForAll(methodObject30649, this, zeroLengthObjectArray);
         return (EnumSet)this.postForAll(methodObject30649, (Object)this.delegate.getTransactionState());
      } catch (SQLException var2) {
         return (EnumSet)this.postForAll(methodObject30649, this.onErrorForAll(methodObject30649, var2));
      }
   }

   public void putDescriptor(byte[] arg0, Object arg1) throws SQLException {
      try {
         super.preForAll(methodObject30667, this, arg0, arg1);
         Method var10001 = methodObject30667;
         this.delegate.putDescriptor(arg0, arg1 instanceof _Proxy_ ? (Object)((_Proxy_)arg1)._getDelegate_() : arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject30667, var4);
      }
   }

   public void setReplayOperations(EnumSet arg0) throws SQLException {
      try {
         super.preForAll(methodObject30771, this, arg0);
         Method var10001 = methodObject30771;
         this.delegate.setReplayOperations(arg0);
         this.postForAll(var10001);
      } catch (SQLException var3) {
         this.onErrorVoidForAll(methodObject30771, var3);
      }
   }

   public BINARY_FLOAT createBINARY_FLOAT(float arg0) throws SQLException {
      try {
         super.preForAll(methodObject30867, this, arg0);
         return (BINARY_FLOAT)this.postForAll(methodObject30867, (Object)this.delegate.createBINARY_FLOAT(arg0));
      } catch (SQLException var3) {
         return (BINARY_FLOAT)this.postForAll(methodObject30867, this.onErrorForAll(methodObject30867, var3));
      }
   }

   public String getDatabaseProductVersion() throws SQLException {
      try {
         super.preForAll(methodObject30654, this, zeroLengthObjectArray);
         return (String)this.postForAll(methodObject30654, (Object)this.delegate.getDatabaseProductVersion());
      } catch (SQLException var2) {
         return (String)this.postForAll(methodObject30654, this.onErrorForAll(methodObject30654, var2));
      }
   }

   public void jmsEnqueue(String arg0, JMSEnqueueOptions arg1, JMSMessage arg2, AQMessageProperties arg3) throws SQLException {
      try {
         super.preForAll(methodObject30698, this, arg0, arg1, arg2, arg3);
         Method var10001 = methodObject30698;
         this.delegate.jmsEnqueue(arg0, arg1, arg2, arg3);
         this.postForAll(var10001);
      } catch (SQLException var6) {
         this.onErrorVoidForAll(methodObject30698, var6);
      }
   }

   public void getPropertyForPooledConnection(OraclePooledConnection arg0) throws SQLException {
      try {
         super.preForAll(methodObject30684, this, arg0);
         Method var10001 = methodObject30684;
         this.delegate.getPropertyForPooledConnection(arg0);
         this.postForAll(var10001);
      } catch (SQLException var3) {
         this.onErrorVoidForAll(methodObject30684, var3);
      }
   }

   public void doXSSessionAttachOp(int arg0, byte[] arg1, XSSecureId arg2, byte[] arg3, XSPrincipal arg4, String[] arg5, String[] arg6, String[] arg7, XSNamespace[] arg8, XSNamespace[] arg9, XSNamespace[] arg10, TIMESTAMPTZ arg11, TIMESTAMPTZ arg12, int arg13, long arg14, XSKeyval arg15, int[] arg16) throws SQLException {
      try {
         super.preForAll(methodObject30753, this, arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10, arg11, arg12, arg13, arg14, arg15, arg16);
         Method var10001 = methodObject30753;
         this.delegate.doXSSessionAttachOp(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10, arg11, arg12, arg13, arg14, arg15, arg16);
         this.postForAll(var10001);
      } catch (SQLException var20) {
         this.onErrorVoidForAll(methodObject30753, var20);
      }
   }

   public boolean getExplicitCachingEnabled() throws SQLException {
      try {
         super.preForAll(methodObject30829, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject30829, this.delegate.getExplicitCachingEnabled());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject30829, this.onErrorForAll(methodObject30829, var2));
      }
   }

   public void removeLogicalTransactionIdEventListener(LogicalTransactionIdEventListener arg0) throws SQLException {
      try {
         super.preForAll(methodObject30919, this, arg0);
         Method var10001 = methodObject30919;
         this.delegate.removeLogicalTransactionIdEventListener(arg0);
         this.postForAll(var10001);
      } catch (SQLException var3) {
         this.onErrorVoidForAll(methodObject30919, var3);
      }
   }

   public String getCurrentSchema() throws SQLException {
      try {
         super.preForAll(methodObject30808, this, zeroLengthObjectArray);
         return (String)this.postForAll(methodObject30808, (Object)this.delegate.getCurrentSchema());
      } catch (SQLException var2) {
         return (String)this.postForAll(methodObject30808, this.onErrorForAll(methodObject30808, var2));
      }
   }

   public OracleSavepoint oracleSetSavepoint() throws SQLException {
      try {
         super.preForTxnControl(methodObject30784, this, zeroLengthObjectArray);
         return (OracleSavepoint)this.postForAll(methodObject30784, this.proxyFactory.proxyForCreate((Object)this.delegate.oracleSetSavepoint(), this, this.proxyCache, methodObject30784));
      } catch (SQLException var2) {
         return (OracleSavepoint)this.postForAll(methodObject30784, this.onErrorForAll(methodObject30784, var2));
      }
   }

   public void putDescriptor(String arg0, Object arg1) throws SQLException {
      try {
         super.preForAll(methodObject30791, this, arg0, arg1);
         Method var10001 = methodObject30791;
         this.delegate.putDescriptor(arg0, arg1 instanceof _Proxy_ ? (Object)((_Proxy_)arg1)._getDelegate_() : arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject30791, var4);
      }
   }

   public short getDbCsId() throws SQLException {
      try {
         super.preForAll(methodObject30677, this, zeroLengthObjectArray);
         return (Short)this.postForAll(methodObject30677, this.delegate.getDbCsId());
      } catch (SQLException var2) {
         return (Short)this.postForAll(methodObject30677, this.onErrorForAll(methodObject30677, var2));
      }
   }

   public void executeLightweightSessionPiggyback(int arg0, byte[] arg1, KeywordValueLong[] arg2, int arg3) throws SQLException {
      try {
         super.preForAll(methodObject30748, this, arg0, arg1, arg2, arg3);
         Method var10001 = methodObject30748;
         this.delegate.executeLightweightSessionPiggyback(arg0, arg1, arg2, arg3);
         this.postForAll(var10001);
      } catch (SQLException var6) {
         this.onErrorVoidForAll(methodObject30748, var6);
      }
   }

   public INTERVALYM createINTERVALYM(String arg0) throws SQLException {
      try {
         super.preForAll(methodObject30876, this, arg0);
         return (INTERVALYM)this.postForAll(methodObject30876, (Object)this.delegate.createINTERVALYM(arg0));
      } catch (SQLException var3) {
         return (INTERVALYM)this.postForAll(methodObject30876, this.onErrorForAll(methodObject30876, var3));
      }
   }

   public long getTdoCState(String arg0, String arg1) throws SQLException {
      try {
         super.preForAll(methodObject30672, this, arg0, arg1);
         return (Long)this.postForAll(methodObject30672, this.delegate.getTdoCState(arg0, arg1));
      } catch (SQLException var4) {
         return (Long)this.postForAll(methodObject30672, this.onErrorForAll(methodObject30672, var4));
      }
   }

   public int javaCharsToCHARBytes(char[] arg0, int arg1, byte[] arg2) throws SQLException {
      try {
         super.preForAll(methodObject30720, this, arg0, arg1, arg2);
         return (Integer)this.postForAll(methodObject30720, this.delegate.javaCharsToCHARBytes(arg0, arg1, arg2));
      } catch (SQLException var5) {
         return (Integer)this.postForAll(methodObject30720, this.onErrorForAll(methodObject30720, var5));
      }
   }

   public boolean isStatementCacheInitialized() {
      super.preForAll(methodObject30724, this, zeroLengthObjectArray);
      return (Boolean)this.postForAll(methodObject30724, this.delegate.isStatementCacheInitialized());
   }

   public boolean getMapDateToTimestamp() {
      super.preForAll(methodObject30746, this, zeroLengthObjectArray);
      return (Boolean)this.postForAll(methodObject30746, this.delegate.getMapDateToTimestamp());
   }

   public void detachServerConnection(String arg0) throws SQLException {
      try {
         super.preForAll(methodObject30923, this, arg0);
         Method var10001 = methodObject30923;
         this.delegate.detachServerConnection(arg0);
         this.postForAll(var10001);
      } catch (SQLException var3) {
         this.onErrorVoidForAll(methodObject30923, var3);
      }
   }

   public Blob createBlob() throws SQLException {
      try {
         super.preForAll(methodObject30938, this, zeroLengthObjectArray);
         return (Blob)this.postForAll(methodObject30938, this.proxyFactory.proxyForCreateCache((Object)this.delegate.createBlob(), this, this.proxyCache, methodObject30938));
      } catch (SQLException var2) {
         return (Blob)this.postForAll(methodObject30938, this.onErrorForAll(methodObject30938, var2));
      }
   }

   public int getMaxCharbyteSize() {
      super.preForAll(methodObject30717, this, zeroLengthObjectArray);
      return (Integer)this.postForAll(methodObject30717, this.delegate.getMaxCharbyteSize());
   }

   public boolean isWrapperFor(Class arg0) throws SQLException {
      try {
         super.preForAll(methodObject30976, this, arg0);
         return (Boolean)this.postForAll(methodObject30976, this.delegate.isWrapperFor(arg0));
      } catch (SQLException var3) {
         return (Boolean)this.postForAll(methodObject30976, this.onErrorForAll(methodObject30976, var3));
      }
   }

   public short getVersionNumber() throws SQLException {
      try {
         super.preForAll(methodObject30655, this, zeroLengthObjectArray);
         return (Short)this.postForAll(methodObject30655, this.delegate.getVersionNumber());
      } catch (SQLException var2) {
         return (Short)this.postForAll(methodObject30655, this.onErrorForAll(methodObject30655, var2));
      }
   }

   public void releaseSavepoint(Savepoint arg0) throws SQLException {
      try {
         super.preForTxnControl(methodObject30935, this, arg0);
         Method var10001 = methodObject30935;
         this.delegate.releaseSavepoint(arg0 instanceof _Proxy_ ? (Savepoint)((_Proxy_)arg0)._getDelegate_() : arg0);
         this.postForAll(var10001);
      } catch (SQLException var3) {
         this.onErrorVoidForAll(methodObject30935, var3);
      }
   }

   public OracleConnection.BufferCacheStatistics getByteBufferCacheStatistics() {
      super.preForAll(methodObject30674, this, zeroLengthObjectArray);
      return (OracleConnection.BufferCacheStatistics)this.postForAll(methodObject30674, (Object)this.delegate.getByteBufferCacheStatistics());
   }

   public Properties getOCIHandles() throws SQLException {
      try {
         super.preForAll(methodObject30653, this, zeroLengthObjectArray);
         return (Properties)this.postForAll(methodObject30653, (Object)this.delegate.getOCIHandles());
      } catch (SQLException var2) {
         return (Properties)this.postForAll(methodObject30653, this.onErrorForAll(methodObject30653, var2));
      }
   }

   public Object getACProxy() {
      super.preForAll(methodObject30978, this, zeroLengthObjectArray);
      return this.postForAll(methodObject30978, this.proxyFactory.proxyForCache(this.delegate.getACProxy(), this, this.proxyCache, methodObject30978));
   }

   public void setIncludeSynonyms(boolean arg0) {
      super.preForAll(methodObject30819, this, arg0);
      Method var10001 = methodObject30819;
      this.delegate.setIncludeSynonyms(arg0);
      this.postForAll(var10001);
   }

   public boolean IsNCharFixedWith() {
      super.preForAll(methodObject30713, this, zeroLengthObjectArray);
      return (Boolean)this.postForAll(methodObject30713, this.delegate.IsNCharFixedWith());
   }

   public String getProtocolType() {
      super.preForAll(methodObject30725, this, zeroLengthObjectArray);
      return (String)this.postForAll(methodObject30725, (Object)this.delegate.getProtocolType());
   }

   public String getSessionTimeZone() {
      super.preForAll(methodObject30843, this, zeroLengthObjectArray);
      return (String)this.postForAll(methodObject30843, (Object)this.delegate.getSessionTimeZone());
   }

   public boolean isUsable() {
      super.preForAll(methodObject30912, this, zeroLengthObjectArray);
      return (Boolean)this.postForAll(methodObject30912, this.delegate.isUsable());
   }

   public DATE createDATE(Date arg0, Calendar arg1) throws SQLException {
      try {
         super.preForAll(methodObject30871, this, arg0, arg1);
         return (DATE)this.postForAll(methodObject30871, (Object)this.delegate.createDATE(arg0, arg1));
      } catch (SQLException var4) {
         return (DATE)this.postForAll(methodObject30871, this.onErrorForAll(methodObject30871, var4));
      }
   }

   public TIMESTAMPTZ createTIMESTAMPTZ(String arg0, Calendar arg1) throws SQLException {
      try {
         super.preForAll(methodObject30899, this, arg0, arg1);
         return (TIMESTAMPTZ)this.postForAll(methodObject30899, (Object)this.delegate.createTIMESTAMPTZ(arg0, arg1));
      } catch (SQLException var4) {
         return (TIMESTAMPTZ)this.postForAll(methodObject30899, this.onErrorForAll(methodObject30899, var4));
      }
   }

   public TypeDescriptor[] getTypeDescriptorsFromList(String[][] arg0) throws SQLException {
      try {
         super.preForAll(methodObject30908, this, arg0);
         return (TypeDescriptor[])this.postForAll(methodObject30908, (Object)this.delegate.getTypeDescriptorsFromList(arg0));
      } catch (SQLException var3) {
         return (TypeDescriptor[])this.postForAll(methodObject30908, this.onErrorForAll(methodObject30908, var3));
      }
   }

   public int CHARBytesToJavaChars(byte[] arg0, int arg1, char[] arg2) throws SQLException {
      try {
         super.preForAll(methodObject30711, this, arg0, arg1, arg2);
         return (Integer)this.postForAll(methodObject30711, this.delegate.CHARBytesToJavaChars(arg0, arg1, arg2));
      } catch (SQLException var5) {
         return (Integer)this.postForAll(methodObject30711, this.onErrorForAll(methodObject30711, var5));
      }
   }

   public void setTransactionIsolation(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject30967, this, arg0);
         Method var10001 = methodObject30967;
         this.delegate.setTransactionIsolation(arg0);
         this.postForAll(var10001);
      } catch (SQLException var3) {
         this.onErrorVoidForAll(methodObject30967, var3);
      }
   }

   public long getCurrentSCN() throws SQLException {
      try {
         super.preForAll(methodObject30688, this, zeroLengthObjectArray);
         return (Long)this.postForAll(methodObject30688, this.delegate.getCurrentSCN());
      } catch (SQLException var2) {
         return (Long)this.postForAll(methodObject30688, this.onErrorForAll(methodObject30688, var2));
      }
   }

   public void setConnectionReleasePriority(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject30853, this, arg0);
         Method var10001 = methodObject30853;
         this.delegate.setConnectionReleasePriority(arg0);
         this.postForAll(var10001);
      } catch (SQLException var3) {
         this.onErrorVoidForAll(methodObject30853, var3);
      }
   }

   public int getConnectionCacheCallbackFlag() throws SQLException {
      try {
         super.preForAll(methodObject30737, this, zeroLengthObjectArray);
         return (Integer)this.postForAll(methodObject30737, this.delegate.getConnectionCacheCallbackFlag());
      } catch (SQLException var2) {
         return (Integer)this.postForAll(methodObject30737, this.onErrorForAll(methodObject30737, var2));
      }
   }

   public void setNetworkTimeout(Executor arg0, int arg1) throws SQLException {
      try {
         super.preForAll(methodObject30965, this, arg0, arg1);
         Method var10001 = methodObject30965;
         this.delegate.setNetworkTimeout(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject30965, var4);
      }
   }

   public CLOB createClob(byte[] arg0) throws SQLException {
      try {
         super.preForAll(methodObject30647, this, arg0);
         return (CLOB)this.postForAll(methodObject30647, (Object)this.delegate.createClob(arg0));
      } catch (SQLException var3) {
         return (CLOB)this.postForAll(methodObject30647, this.onErrorForAll(methodObject30647, var3));
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
         methodObject30818 = oracle.jdbc.OracleConnection.class.getDeclaredMethod("setEndToEndMetrics", String[].class, Short.TYPE);
         methodObject30758 = OracleConnection.class.getDeclaredMethod("getClassForType", String.class, Map.class);
         methodObject30735 = OracleConnection.class.getDeclaredMethod("getConnectionCacheCallbackObj");
         methodObject30775 = oracle.jdbc.OracleConnection.class.getDeclaredMethod("getDescriptor", String.class);
         methodObject30822 = oracle.jdbc.OracleConnection.class.getDeclaredMethod("setStmtCacheSize", Integer.TYPE);
         methodObject30961 = Connection.class.getDeclaredMethod("setCatalog", String.class);
         methodObject30703 = OracleConnection.class.getDeclaredMethod("ackJMSNotification", JMSNotificationRegistration.class, byte[].class, JMSNotificationRegistration.Directive.class);
         methodObject30866 = oracle.jdbc.OracleConnection.class.getDeclaredMethod("createBINARY_DOUBLE", Double.TYPE);
         methodObject30719 = OracleConnection.class.getDeclaredMethod("isCharSetMultibyte", Short.TYPE);
         methodObject30700 = OracleConnection.class.getDeclaredMethod("jmsDequeue", String.class, JMSDequeueOptions.class, String.class);
         methodObject30877 = oracle.jdbc.OracleConnection.class.getDeclaredMethod("createNUMBER", Boolean.TYPE);
         methodObject30682 = OracleConnection.class.getDeclaredMethod("newArrayLocatorResultSet", ArrayDescriptor.class, byte[].class, Long.TYPE, Integer.TYPE, Map.class);
         methodObject30962 = Connection.class.getDeclaredMethod("setClientInfo", String.class, String.class);
         methodObject30692 = OracleConnection.class.getDeclaredMethod("getLastReplayContext");
         methodObject30663 = OracleConnection.class.getDeclaredMethod("classForNameAndSchema", String.class, String.class);
         methodObject30933 = Connection.class.getDeclaredMethod("setSavepoint");
         methodObject30795 = oracle.jdbc.OracleConnection.class.getDeclaredMethod("getAutoClose");
         methodObject30780 = oracle.jdbc.OracleConnection.class.getDeclaredMethod("unwrap");
         methodObject30721 = OracleConnection.class.getDeclaredMethod("javaCharsToNCHARBytes", char[].class, Integer.TYPE, byte[].class);
         methodObject30697 = OracleConnection.class.getDeclaredMethod("getExecutingRPCSQL");
         methodObject30974 = Connection.class.getDeclaredMethod("getTransactionIsolation");
         methodObject30681 = OracleConnection.class.getDeclaredMethod("newArrayDataResultSet", ARRAY.class, Long.TYPE, Integer.TYPE, Map.class);
         methodObject30845 = oracle.jdbc.OracleConnection.class.getDeclaredMethod("isLogicalConnection");
         methodObject30734 = OracleConnection.class.getDeclaredMethod("cleanupAndClose", Boolean.TYPE);
         methodObject30865 = oracle.jdbc.OracleConnection.class.getDeclaredMethod("unregisterDatabaseChangeNotification", Long.TYPE, String.class);
         methodObject30749 = OracleConnection.class.getDeclaredMethod("doXSNamespaceOp", OracleConnection.XSOperationCode.class, byte[].class, XSNamespace[].class, XSNamespace[][].class, XSSecureId.class);
         methodObject30742 = OracleConnection.class.getDeclaredMethod("isDescriptorSharable", OracleConnection.class);
         methodObject30839 = oracle.jdbc.OracleConnection.class.getDeclaredMethod("prepareCallWithKey", String.class);
         methodObject30783 = oracle.jdbc.OracleConnection.class.getDeclaredMethod("oracleRollback", OracleSavepoint.class);
         methodObject30817 = oracle.jdbc.OracleConnection.class.getDeclaredMethod("setDefaultRowPrefetch", Integer.TYPE);
         methodObject30891 = oracle.jdbc.OracleConnection.class.getDeclaredMethod("createTIMESTAMP", String.class);
         methodObject30673 = OracleConnection.class.getDeclaredMethod("getTdoCState", String.class);
         methodObject30782 = oracle.jdbc.OracleConnection.class.getDeclaredMethod("commit", EnumSet.class);
         methodObject30838 = oracle.jdbc.OracleConnection.class.getDeclaredMethod("prepareStatementWithKey", String.class);
         methodObject30941 = Connection.class.getDeclaredMethod("createSQLXML");
         methodObject30878 = oracle.jdbc.OracleConnection.class.getDeclaredMethod("createNUMBER", Byte.TYPE);
         methodObject30910 = oracle.jdbc.OracleConnection.class.getDeclaredMethod("getEncryptionAlgorithmName");
         methodObject30743 = OracleConnection.class.getDeclaredMethod("refCursorCursorToStatement", Integer.TYPE);
         methodObject30906 = oracle.jdbc.OracleConnection.class.getDeclaredMethod("getAllTypeDescriptorsInCurrentSchema");
         methodObject30762 = OracleConnection.class.getDeclaredMethod("getTimezoneVersionNumber");
         methodObject30934 = Connection.class.getDeclaredMethod("setSavepoint", String.class);
         methodObject30813 = oracle.jdbc.OracleConnection.class.getDeclaredMethod("registerSQLType", String.class, Class.class);
         methodObject30890 = oracle.jdbc.OracleConnection.class.getDeclaredMethod("createTIMESTAMP", Timestamp.class);
         methodObject30727 = OracleConnection.class.getDeclaredMethod("setTxnMode", Integer.TYPE);
         methodObject30709 = OracleConnection.class.getDeclaredMethod("setTypeMap", Map.class);
         methodObject30844 = oracle.jdbc.OracleConnection.class.getDeclaredMethod("getSessionTimeZoneOffset");
         methodObject30972 = Connection.class.getDeclaredMethod("getClientInfo");
         methodObject30651 = OracleConnection.class.getDeclaredMethod("getStructAttrNCsId");
         methodObject30669 = OracleConnection.class.getDeclaredMethod("removeAllDescriptor");
         methodObject30680 = OracleConnection.class.getDeclaredMethod("newArrayDataResultSet", Datum[].class, Long.TYPE, Integer.TYPE, Map.class);
         methodObject30809 = oracle.jdbc.OracleConnection.class.getDeclaredMethod("getUsingXAFlag");
         methodObject30960 = Connection.class.getDeclaredMethod("setAutoCommit", Boolean.TYPE);
         methodObject30945 = Connection.class.getDeclaredMethod("prepareCall", String.class);
         methodObject30705 = OracleConnection.class.getDeclaredMethod("setPDBChangeEventListener", PDBChangeEventListener.class);
         methodObject30792 = oracle.jdbc.OracleConnection.class.getDeclaredMethod("physicalConnectionWithin");
         methodObject30657 = OracleConnection.class.getDeclaredMethod("setJavaObjectTypeMap", Map.class);
         methodObject30686 = OracleConnection.class.getDeclaredMethod("getWrapper");
         methodObject30710 = OracleConnection.class.getDeclaredMethod("getForm", OracleTypeADT.class, OracleTypeCLOB.class, Integer.TYPE);
         methodObject30969 = Connection.class.getDeclaredMethod("clearWarnings");
         methodObject30658 = OracleConnection.class.getDeclaredMethod("getInstanceProperty", OracleConnection.InstanceProperty.class);
         methodObject30924 = oracle.jdbc.OracleConnection.class.getDeclaredMethod("needToPurgeStatementCache");
         methodObject30718 = OracleConnection.class.getDeclaredMethod("getMaxNCharbyteSize");
         methodObject30882 = oracle.jdbc.OracleConnection.class.getDeclaredMethod("createNUMBER", Float.TYPE);
         methodObject30752 = OracleConnection.class.getDeclaredMethod("doXSSessionDestroyOp", byte[].class, XSSecureId.class, byte[].class);
         methodObject30915 = oracle.jdbc.OracleConnection.class.getDeclaredMethod("setApplicationContext", String.class, String.class, String.class);
         methodObject30671 = OracleConnection.class.getDeclaredMethod("descriptorCacheKeys");
         methodObject30857 = oracle.jdbc.OracleConnection.class.getDeclaredMethod("unregisterAQNotification", AQNotificationRegistration.class);
         methodObject30693 = OracleConnection.class.getDeclaredMethod("registerEndReplayCallback", OracleConnection.EndReplayCallback.class);
         methodObject30942 = Connection.class.getDeclaredMethod("createStatement");
         methodObject30701 = OracleConnection.class.getDeclaredMethod("registerJMSNotification", String[].class, Map.class);
         methodObject30957 = Connection.class.getDeclaredMethod("getMetaData");
         methodObject30745 = OracleConnection.class.getDeclaredMethod("isV8Compatible");
         methodObject30823 = oracle.jdbc.OracleConnection.class.getDeclaredMethod("setStmtCacheSize", Integer.TYPE, Boolean.TYPE);
         methodObject30887 = oracle.jdbc.OracleConnection.class.getDeclaredMethod("createTIMESTAMP", Date.class);
         methodObject30885 = oracle.jdbc.OracleConnection.class.getDeclaredMethod("createNUMBER", BigInteger.class);
         methodObject30870 = oracle.jdbc.OracleConnection.class.getDeclaredMethod("createDATE", Timestamp.class);
         methodObject30833 = oracle.jdbc.OracleConnection.class.getDeclaredMethod("getCallWithKey", String.class);
         methodObject30955 = Connection.class.getDeclaredMethod("isClosed");
         methodObject30695 = OracleConnection.class.getDeclaredMethod("getDerivedKeyInternal", byte[].class, Integer.TYPE);
         methodObject30661 = OracleConnection.class.getDeclaredMethod("setDefaultFixedString", Boolean.TYPE);
         methodObject30645 = OracleConnection.class.getDeclaredMethod("getURL");
         methodObject30764 = OracleConnection.class.getDeclaredMethod("getTIMEZONETAB");
         methodObject30729 = OracleConnection.class.getDeclaredMethod("getHeapAllocSize");
         methodObject30696 = OracleConnection.class.getDeclaredMethod("getExecutingRPCFunctionCode");
         methodObject30747 = OracleConnection.class.getDeclaredMethod("createLightweightSession", String.class, KeywordValueLong[].class, Integer.TYPE, KeywordValueLong[][].class, int[].class);
         methodObject30707 = OracleConnection.class.getDeclaredMethod("setChecksumMode", OracleConnection.ChecksumMode.class);
         methodObject30956 = Connection.class.getDeclaredMethod("getSchema");
         methodObject30943 = Connection.class.getDeclaredMethod("createStatement", Integer.TYPE, Integer.TYPE);
         methodObject30712 = OracleConnection.class.getDeclaredMethod("NCHARBytesToJavaChars", byte[].class, Integer.TYPE, char[].class);
         methodObject30880 = oracle.jdbc.OracleConnection.class.getDeclaredMethod("createNUMBER", Integer.TYPE);
         methodObject30806 = oracle.jdbc.OracleConnection.class.getDeclaredMethod("getStructAttrCsId");
         methodObject30801 = oracle.jdbc.OracleConnection.class.getDeclaredMethod("getRestrictGetTables");
         methodObject30851 = oracle.jdbc.OracleConnection.class.getDeclaredMethod("getUnMatchedConnectionAttributes");
         methodObject30863 = oracle.jdbc.OracleConnection.class.getDeclaredMethod("unregisterDatabaseChangeNotification", Integer.TYPE, String.class, Integer.TYPE);
         methodObject30881 = oracle.jdbc.OracleConnection.class.getDeclaredMethod("createNUMBER", Long.TYPE);
         methodObject30977 = ACProxyable.class.getDeclaredMethod("setACProxy", Object.class);
         methodObject30946 = Connection.class.getDeclaredMethod("prepareCall", String.class, Integer.TYPE, Integer.TYPE);
         methodObject30862 = oracle.jdbc.OracleConnection.class.getDeclaredMethod("unregisterDatabaseChangeNotification", DatabaseChangeRegistration.class);
         methodObject30849 = oracle.jdbc.OracleConnection.class.getDeclaredMethod("applyConnectionAttributes", Properties.class);
         methodObject30913 = oracle.jdbc.OracleConnection.class.getDeclaredMethod("setDefaultTimeZone", TimeZone.class);
         methodObject30774 = oracle.jdbc.OracleConnection.class.getDeclaredMethod("shutdown", oracle.jdbc.OracleConnection.DatabaseShutdownMode.class);
         methodObject30824 = oracle.jdbc.OracleConnection.class.getDeclaredMethod("setStatementCacheSize", Integer.TYPE);
         methodObject30827 = oracle.jdbc.OracleConnection.class.getDeclaredMethod("getImplicitCachingEnabled");
         methodObject30831 = oracle.jdbc.OracleConnection.class.getDeclaredMethod("purgeExplicitCache");
         methodObject30893 = oracle.jdbc.OracleConnection.class.getDeclaredMethod("createTIMESTAMPTZ", Date.class, Calendar.class);
         methodObject30830 = oracle.jdbc.OracleConnection.class.getDeclaredMethod("purgeImplicitCache");
         methodObject30660 = OracleConnection.class.getDeclaredMethod("createClobDBAccess");
         methodObject30741 = OracleConnection.class.getDeclaredMethod("createBfile", byte[].class);
         methodObject30892 = oracle.jdbc.OracleConnection.class.getDeclaredMethod("createTIMESTAMPTZ", Date.class);
         methodObject30763 = OracleConnection.class.getDeclaredMethod("removeAllXSEventListener");
         methodObject30898 = oracle.jdbc.OracleConnection.class.getDeclaredMethod("createTIMESTAMPTZ", String.class);
         methodObject30731 = OracleConnection.class.getDeclaredMethod("setAbandonedTimeoutEnabled", Boolean.TYPE);
         methodObject30903 = oracle.jdbc.OracleConnection.class.getDeclaredMethod("createTIMESTAMPLTZ", Timestamp.class, Calendar.class);
         methodObject30949 = Connection.class.getDeclaredMethod("prepareStatement", String.class, Integer.TYPE, Integer.TYPE);
         methodObject30896 = oracle.jdbc.OracleConnection.class.getDeclaredMethod("createTIMESTAMPTZ", Timestamp.class);
         methodObject30836 = oracle.jdbc.OracleConnection.class.getDeclaredMethod("startup", String.class, Integer.TYPE);
         methodObject30832 = oracle.jdbc.OracleConnection.class.getDeclaredMethod("getStatementWithKey", String.class);
         methodObject30776 = oracle.jdbc.OracleConnection.class.getDeclaredMethod("getProperties");
         methodObject30868 = oracle.jdbc.OracleConnection.class.getDeclaredMethod("createDATE", Date.class);
         methodObject30754 = OracleConnection.class.getDeclaredMethod("doXSSessionDetachOp", Integer.TYPE, byte[].class, XSSecureId.class, Boolean.TYPE);
         methodObject30694 = OracleConnection.class.getDeclaredMethod("getEOC");
         methodObject30648 = OracleConnection.class.getDeclaredMethod("createClob", byte[].class, Short.TYPE);
         methodObject30894 = oracle.jdbc.OracleConnection.class.getDeclaredMethod("createTIMESTAMPTZ", Time.class);
         methodObject30888 = oracle.jdbc.OracleConnection.class.getDeclaredMethod("createTIMESTAMP", DATE.class);
         methodObject30662 = OracleConnection.class.getDeclaredMethod("getDefaultFixedString");
         methodObject30691 = OracleConnection.class.getDeclaredMethod("getReplayContext");
         methodObject30968 = Connection.class.getDeclaredMethod("getNetworkTimeout");
         methodObject30922 = oracle.jdbc.OracleConnection.class.getDeclaredMethod("attachServerConnection");
         methodObject30950 = Connection.class.getDeclaredMethod("prepareStatement", String.class, Integer.TYPE, Integer.TYPE, Integer.TYPE);
         methodObject30900 = oracle.jdbc.OracleConnection.class.getDeclaredMethod("createTIMESTAMPTZ", DATE.class);
         methodObject30917 = oracle.jdbc.OracleConnection.class.getDeclaredMethod("addLogicalTransactionIdEventListener", LogicalTransactionIdEventListener.class);
         methodObject30685 = OracleConnection.class.getDeclaredMethod("getPhysicalConnection");
         methodObject30828 = oracle.jdbc.OracleConnection.class.getDeclaredMethod("setExplicitCachingEnabled", Boolean.TYPE);
         methodObject30670 = OracleConnection.class.getDeclaredMethod("numberOfDescriptorCacheEntries");
         methodObject30841 = oracle.jdbc.OracleConnection.class.getDeclaredMethod("getCreateStatementAsRefCursor");
         methodObject30927 = Connection.class.getDeclaredMethod("isValid", Integer.TYPE);
         methodObject30650 = OracleConnection.class.getDeclaredMethod("getVarTypeMaxLenCompat");
         methodObject30916 = oracle.jdbc.OracleConnection.class.getDeclaredMethod("clearAllApplicationContext", String.class);
         methodObject30959 = Connection.class.getDeclaredMethod("nativeSQL", String.class);
         methodObject30947 = Connection.class.getDeclaredMethod("prepareCall", String.class, Integer.TYPE, Integer.TYPE, Integer.TYPE);
         methodObject30690 = OracleConnection.class.getDeclaredMethod("setReplayContext", ReplayContext[].class);
         methodObject30873 = oracle.jdbc.OracleConnection.class.getDeclaredMethod("createDATE", Timestamp.class, Calendar.class);
         methodObject30755 = OracleConnection.class.getDeclaredMethod("doXSSessionChangeOp", OracleConnection.XSSessionSetOperationCode.class, byte[].class, XSSecureId.class, XSSessionParameters.class);
         methodObject30723 = OracleConnection.class.getDeclaredMethod("getStartTime");
         methodObject30975 = Wrapper.class.getDeclaredMethod("unwrap", Class.class);
         methodObject30676 = OracleConnection.class.getDeclaredMethod("toDatum", CustomDatum.class);
         methodObject30769 = OracleConnection.class.getDeclaredMethod("isLobStreamPosStandardCompliant");
         methodObject30861 = oracle.jdbc.OracleConnection.class.getDeclaredMethod("getDatabaseChangeRegistration", Integer.TYPE);
         methodObject30704 = OracleConnection.class.getDeclaredMethod("getNegotiatedSDU");
         methodObject30744 = OracleConnection.class.getDeclaredMethod("getXAResource");
         methodObject30964 = Connection.class.getDeclaredMethod("setHoldability", Integer.TYPE);
         methodObject30815 = oracle.jdbc.OracleConnection.class.getDeclaredMethod("setAutoClose", Boolean.TYPE);
         methodObject30971 = Connection.class.getDeclaredMethod("getClientInfo", String.class);
         methodObject30814 = oracle.jdbc.OracleConnection.class.getDeclaredMethod("registerSQLType", String.class, String.class);
         methodObject30794 = oracle.jdbc.OracleConnection.class.getDeclaredMethod("openProxySession", Integer.TYPE, Properties.class);
         methodObject30889 = oracle.jdbc.OracleConnection.class.getDeclaredMethod("createTIMESTAMP", Time.class);
         methodObject30825 = oracle.jdbc.OracleConnection.class.getDeclaredMethod("getStatementCacheSize");
         methodObject30757 = OracleConnection.class.getDeclaredMethod("setUsable", Boolean.TYPE);
         methodObject30708 = OracleConnection.class.getDeclaredMethod("getTypeMap");
         methodObject30786 = oracle.jdbc.OracleConnection.class.getDeclaredMethod("oracleReleaseSavepoint", OracleSavepoint.class);
         methodObject30859 = oracle.jdbc.OracleConnection.class.getDeclaredMethod("dequeue", String.class, AQDequeueOptions.class, String.class);
         methodObject30652 = OracleConnection.class.getDeclaredMethod("getDBAccessProperties");
         methodObject30787 = oracle.jdbc.OracleConnection.class.getDeclaredMethod("cancel");
         methodObject30798 = oracle.jdbc.OracleConnection.class.getDeclaredMethod("getEndToEndMetrics");
         methodObject30778 = oracle.jdbc.OracleConnection.class.getDeclaredMethod("close", Properties.class);
         methodObject30761 = OracleConnection.class.getDeclaredMethod("removeXSEventListener", XSEventListener.class);
         methodObject30925 = Connection.class.getDeclaredMethod("setReadOnly", Boolean.TYPE);
         methodObject30948 = Connection.class.getDeclaredMethod("prepareStatement", String.class);
         methodObject30716 = OracleConnection.class.getDeclaredMethod("getMaxCharSize");
         methodObject30951 = Connection.class.getDeclaredMethod("prepareStatement", String.class, Integer.TYPE);
         methodObject30914 = oracle.jdbc.OracleConnection.class.getDeclaredMethod("getDefaultTimeZone");
         methodObject30875 = oracle.jdbc.OracleConnection.class.getDeclaredMethod("createINTERVALDS", String.class);
         methodObject30714 = OracleConnection.class.getDeclaredMethod("getDriverCharSet");
         methodObject30679 = OracleConnection.class.getDeclaredMethod("getNCharSet");
         methodObject30766 = OracleConnection.class.getDeclaredMethod("getTimestamptzInGmt");
         methodObject30770 = OracleConnection.class.getDeclaredMethod("isConnectionSocketKeepAlive");
         methodObject30664 = OracleConnection.class.getDeclaredMethod("setFDO", byte[].class);
         methodObject30921 = oracle.jdbc.OracleConnection.class.getDeclaredMethod("isDRCPEnabled");
         methodObject30803 = oracle.jdbc.OracleConnection.class.getDeclaredMethod("getRemarksReporting");
         methodObject30820 = oracle.jdbc.OracleConnection.class.getDeclaredMethod("setRemarksReporting", Boolean.TYPE);
         methodObject30904 = oracle.jdbc.OracleConnection.class.getDeclaredMethod("createTIMESTAMPLTZ", String.class, Calendar.class);
         methodObject30811 = oracle.jdbc.OracleConnection.class.getDeclaredMethod("pingDatabase");
         methodObject30854 = oracle.jdbc.OracleConnection.class.getDeclaredMethod("getConnectionReleasePriority");
         methodObject30810 = oracle.jdbc.OracleConnection.class.getDeclaredMethod("getXAErrorFlag");
         methodObject30937 = Connection.class.getDeclaredMethod("createStruct", String.class, Object[].class);
         methodObject30756 = OracleConnection.class.getDeclaredMethod("getDefaultSchemaNameForNamedTypes");
         methodObject30728 = OracleConnection.class.getDeclaredMethod("getTxnMode");
         methodObject30699 = OracleConnection.class.getDeclaredMethod("jmsDequeue", String.class, JMSDequeueOptions.class);
         methodObject30807 = oracle.jdbc.OracleConnection.class.getDeclaredMethod("getUserName");
         methodObject30902 = oracle.jdbc.OracleConnection.class.getDeclaredMethod("createTIMESTAMPLTZ", Time.class, Calendar.class);
         methodObject30759 = OracleConnection.class.getDeclaredMethod("addXSEventListener", XSEventListener.class);
         methodObject30816 = oracle.jdbc.OracleConnection.class.getDeclaredMethod("setDefaultExecuteBatch", Integer.TYPE);
         methodObject30802 = oracle.jdbc.OracleConnection.class.getDeclaredMethod("getJavaObject", String.class);
         methodObject30940 = Connection.class.getDeclaredMethod("createNClob");
         methodObject30848 = oracle.jdbc.OracleConnection.class.getDeclaredMethod("isProxySession");
         methodObject30970 = Connection.class.getDeclaredMethod("getAutoCommit");
         methodObject30932 = Connection.class.getDeclaredMethod("rollback", Savepoint.class);
         methodObject30837 = oracle.jdbc.OracleConnection.class.getDeclaredMethod("startup", oracle.jdbc.OracleConnection.DatabaseStartupMode.class);
         methodObject30678 = OracleConnection.class.getDeclaredMethod("getJdbcCsId");
         methodObject30973 = Connection.class.getDeclaredMethod("getHoldability");
         methodObject30897 = oracle.jdbc.OracleConnection.class.getDeclaredMethod("createTIMESTAMPTZ", Timestamp.class, Calendar.class);
         methodObject30846 = oracle.jdbc.OracleConnection.class.getDeclaredMethod("registerTAFCallback", OracleOCIFailover.class, Object.class);
         methodObject30668 = OracleConnection.class.getDeclaredMethod("removeDescriptor", String.class);
         methodObject30675 = OracleConnection.class.getDeclaredMethod("getCharBufferCacheStatistics");
         methodObject30777 = oracle.jdbc.OracleConnection.class.getDeclaredMethod("enqueue", String.class, AQEnqueueOptions.class, AQMessage.class);
         methodObject30931 = Connection.class.getDeclaredMethod("rollback");
         methodObject30773 = OracleConnection.class.getDeclaredMethod("beginNonRequestCalls");
         methodObject30789 = oracle.jdbc.OracleConnection.class.getDeclaredMethod("createOracleArray", String.class, Object.class);
         methodObject30834 = oracle.jdbc.OracleConnection.class.getDeclaredMethod("setUsingXAFlag", Boolean.TYPE);
         methodObject30788 = oracle.jdbc.OracleConnection.class.getDeclaredMethod("createARRAY", String.class, Object.class);
         methodObject30768 = OracleConnection.class.getDeclaredMethod("isDataInLocatorEnabled");
         methodObject30800 = oracle.jdbc.OracleConnection.class.getDeclaredMethod("getIncludeSynonyms");
         methodObject30936 = Connection.class.getDeclaredMethod("createArrayOf", String.class, Object[].class);
         methodObject30751 = OracleConnection.class.getDeclaredMethod("doXSSessionCreateOp", OracleConnection.XSSessionOperationCode.class, XSSecureId.class, byte[].class, XSPrincipal.class, String.class, XSNamespace[].class, OracleConnection.XSSessionModeFlag.class, XSKeyval.class);
         methodObject30730 = OracleConnection.class.getDeclaredMethod("getOCIEnvHeapAllocSize");
         methodObject30646 = OracleConnection.class.getDeclaredMethod("createBlob", byte[].class);
         methodObject30835 = oracle.jdbc.OracleConnection.class.getDeclaredMethod("setXAErrorFlag", Boolean.TYPE);
         methodObject30785 = oracle.jdbc.OracleConnection.class.getDeclaredMethod("oracleSetSavepoint", String.class);
         methodObject30796 = oracle.jdbc.OracleConnection.class.getDeclaredMethod("getDefaultExecuteBatch");
         methodObject30706 = OracleConnection.class.getDeclaredMethod("setPDBChangeEventListener", PDBChangeEventListener.class, Executor.class);
         methodObject30901 = oracle.jdbc.OracleConnection.class.getDeclaredMethod("createTIMESTAMPLTZ", Date.class, Calendar.class);
         methodObject30659 = OracleConnection.class.getDeclaredMethod("createBlobDBAccess");
         methodObject30929 = Connection.class.getDeclaredMethod("abort", Executor.class);
         methodObject30920 = oracle.jdbc.OracleConnection.class.getDeclaredMethod("getLogicalTransactionId");
         methodObject30793 = oracle.jdbc.OracleConnection.class.getDeclaredMethod("archive", Integer.TYPE, Integer.TYPE, String.class);
         methodObject30855 = oracle.jdbc.OracleConnection.class.getDeclaredMethod("setPlsqlWarnings", String.class);
         methodObject30852 = oracle.jdbc.OracleConnection.class.getDeclaredMethod("registerConnectionCacheCallback", OracleConnectionCacheCallback.class, Object.class, Integer.TYPE);
         methodObject30840 = oracle.jdbc.OracleConnection.class.getDeclaredMethod("setCreateStatementAsRefCursor", Boolean.TYPE);
         methodObject30738 = OracleConnection.class.getDeclaredMethod("getServerSessionInfo");
         methodObject30732 = OracleConnection.class.getDeclaredMethod("getHeartbeatNoChangeCount");
         methodObject30812 = oracle.jdbc.OracleConnection.class.getDeclaredMethod("pingDatabase", Integer.TYPE);
         methodObject30928 = Connection.class.getDeclaredMethod("isReadOnly");
         methodObject30733 = OracleConnection.class.getDeclaredMethod("closeInternal", Boolean.TYPE);
         methodObject30797 = oracle.jdbc.OracleConnection.class.getDeclaredMethod("getDefaultRowPrefetch");
         methodObject30847 = oracle.jdbc.OracleConnection.class.getDeclaredMethod("setWrapper", oracle.jdbc.OracleConnection.class);
         methodObject30750 = OracleConnection.class.getDeclaredMethod("doXSNamespaceOp", OracleConnection.XSOperationCode.class, byte[].class, XSNamespace[].class, XSSecureId.class);
         methodObject30895 = oracle.jdbc.OracleConnection.class.getDeclaredMethod("createTIMESTAMPTZ", Time.class, Calendar.class);
         methodObject30842 = oracle.jdbc.OracleConnection.class.getDeclaredMethod("setSessionTimeZone", String.class);
         methodObject30883 = oracle.jdbc.OracleConnection.class.getDeclaredMethod("createNUMBER", Double.TYPE);
         methodObject30740 = OracleConnection.class.getDeclaredMethod("createBlobWithUnpickledBytes", byte[].class);
         methodObject30909 = oracle.jdbc.OracleConnection.class.getDeclaredMethod("getDataIntegrityAlgorithmName");
         methodObject30715 = OracleConnection.class.getDeclaredMethod("getC2SNlsRatio");
         methodObject30856 = oracle.jdbc.OracleConnection.class.getDeclaredMethod("registerAQNotification", String[].class, Properties[].class, Properties.class);
         methodObject30779 = oracle.jdbc.OracleConnection.class.getDeclaredMethod("close", Integer.TYPE);
         methodObject30799 = oracle.jdbc.OracleConnection.class.getDeclaredMethod("getEndToEndECIDSequenceNumber");
         methodObject30821 = oracle.jdbc.OracleConnection.class.getDeclaredMethod("setRestrictGetTables", Boolean.TYPE);
         methodObject30687 = OracleConnection.class.getDeclaredMethod("createBfileDBAccess");
         methodObject30805 = oracle.jdbc.OracleConnection.class.getDeclaredMethod("getStmtCacheSize");
         methodObject30966 = Connection.class.getDeclaredMethod("setSchema", String.class);
         methodObject30930 = Connection.class.getDeclaredMethod("commit");
         methodObject30884 = oracle.jdbc.OracleConnection.class.getDeclaredMethod("createNUMBER", BigDecimal.class);
         methodObject30958 = Connection.class.getDeclaredMethod("getWarnings");
         methodObject30963 = Connection.class.getDeclaredMethod("setClientInfo", Properties.class);
         methodObject30722 = OracleConnection.class.getDeclaredMethod("setStartTime", Long.TYPE);
         methodObject30656 = OracleConnection.class.getDeclaredMethod("getJavaObjectTypeMap");
         methodObject30767 = OracleConnection.class.getDeclaredMethod("getUse1900AsYearForTime");
         methodObject30683 = OracleConnection.class.getDeclaredMethod("newStructMetaData", StructDescriptor.class);
         methodObject30804 = oracle.jdbc.OracleConnection.class.getDeclaredMethod("getSQLType", Object.class);
         methodObject30872 = oracle.jdbc.OracleConnection.class.getDeclaredMethod("createDATE", Time.class, Calendar.class);
         methodObject30702 = OracleConnection.class.getDeclaredMethod("unregisterJMSNotification", JMSNotificationRegistration.class);
         methodObject30790 = oracle.jdbc.OracleConnection.class.getDeclaredMethod("_getPC");
         methodObject30918 = oracle.jdbc.OracleConnection.class.getDeclaredMethod("addLogicalTransactionIdEventListener", LogicalTransactionIdEventListener.class, Executor.class);
         methodObject30726 = OracleConnection.class.getDeclaredMethod("getLogicalConnection", OraclePooledConnection.class, Boolean.TYPE);
         methodObject30953 = Connection.class.getDeclaredMethod("prepareStatement", String.class, String[].class);
         methodObject30869 = oracle.jdbc.OracleConnection.class.getDeclaredMethod("createDATE", Time.class);
         methodObject30926 = Connection.class.getDeclaredMethod("close");
         methodObject30879 = oracle.jdbc.OracleConnection.class.getDeclaredMethod("createNUMBER", Short.TYPE);
         methodObject30864 = oracle.jdbc.OracleConnection.class.getDeclaredMethod("unregisterDatabaseChangeNotification", Integer.TYPE);
         methodObject30907 = oracle.jdbc.OracleConnection.class.getDeclaredMethod("getTypeDescriptorsFromListInCurrentSchema", String[].class);
         methodObject30765 = OracleConnection.class.getDeclaredMethod("getDatabaseTimeZone");
         methodObject30860 = oracle.jdbc.OracleConnection.class.getDeclaredMethod("registerDatabaseChangeNotification", Properties.class);
         methodObject30739 = OracleConnection.class.getDeclaredMethod("createClobWithUnpickledBytes", byte[].class);
         methodObject30874 = oracle.jdbc.OracleConnection.class.getDeclaredMethod("createDATE", String.class);
         methodObject30939 = Connection.class.getDeclaredMethod("createClob");
         methodObject30772 = OracleConnection.class.getDeclaredMethod("setReplayingMode", Boolean.TYPE);
         methodObject30905 = oracle.jdbc.OracleConnection.class.getDeclaredMethod("createTIMESTAMPLTZ", DATE.class, Calendar.class);
         methodObject30826 = oracle.jdbc.OracleConnection.class.getDeclaredMethod("setImplicitCachingEnabled", Boolean.TYPE);
         methodObject30858 = oracle.jdbc.OracleConnection.class.getDeclaredMethod("dequeue", String.class, AQDequeueOptions.class, byte[].class);
         methodObject30781 = oracle.jdbc.OracleConnection.class.getDeclaredMethod("abort");
         methodObject30736 = OracleConnection.class.getDeclaredMethod("getConnectionCacheCallbackPrivObj");
         methodObject30911 = oracle.jdbc.OracleConnection.class.getDeclaredMethod("getAuthenticationAdaptorName");
         methodObject30666 = OracleConnection.class.getDeclaredMethod("getBigEndian");
         methodObject30689 = OracleConnection.class.getDeclaredMethod("endNonRequestCalls");
         methodObject30760 = OracleConnection.class.getDeclaredMethod("addXSEventListener", XSEventListener.class, Executor.class);
         methodObject30850 = oracle.jdbc.OracleConnection.class.getDeclaredMethod("getConnectionAttributes");
         methodObject30944 = Connection.class.getDeclaredMethod("createStatement", Integer.TYPE, Integer.TYPE, Integer.TYPE);
         methodObject30886 = oracle.jdbc.OracleConnection.class.getDeclaredMethod("createNUMBER", String.class, Integer.TYPE);
         methodObject30952 = Connection.class.getDeclaredMethod("prepareStatement", String.class, int[].class);
         methodObject30644 = OracleConnection.class.getDeclaredMethod("getDescriptor", byte[].class);
         methodObject30665 = OracleConnection.class.getDeclaredMethod("getFDO", Boolean.TYPE);
         methodObject30954 = Connection.class.getDeclaredMethod("getCatalog");
         methodObject30649 = OracleConnection.class.getDeclaredMethod("getTransactionState");
         methodObject30667 = OracleConnection.class.getDeclaredMethod("putDescriptor", byte[].class, Object.class);
         methodObject30771 = OracleConnection.class.getDeclaredMethod("setReplayOperations", EnumSet.class);
         methodObject30867 = oracle.jdbc.OracleConnection.class.getDeclaredMethod("createBINARY_FLOAT", Float.TYPE);
         methodObject30654 = OracleConnection.class.getDeclaredMethod("getDatabaseProductVersion");
         methodObject30698 = OracleConnection.class.getDeclaredMethod("jmsEnqueue", String.class, JMSEnqueueOptions.class, JMSMessage.class, AQMessageProperties.class);
         methodObject30684 = OracleConnection.class.getDeclaredMethod("getPropertyForPooledConnection", OraclePooledConnection.class);
         methodObject30753 = OracleConnection.class.getDeclaredMethod("doXSSessionAttachOp", Integer.TYPE, byte[].class, XSSecureId.class, byte[].class, XSPrincipal.class, String[].class, String[].class, String[].class, XSNamespace[].class, XSNamespace[].class, XSNamespace[].class, TIMESTAMPTZ.class, TIMESTAMPTZ.class, Integer.TYPE, Long.TYPE, XSKeyval.class, int[].class);
         methodObject30829 = oracle.jdbc.OracleConnection.class.getDeclaredMethod("getExplicitCachingEnabled");
         methodObject30919 = oracle.jdbc.OracleConnection.class.getDeclaredMethod("removeLogicalTransactionIdEventListener", LogicalTransactionIdEventListener.class);
         methodObject30808 = oracle.jdbc.OracleConnection.class.getDeclaredMethod("getCurrentSchema");
         methodObject30784 = oracle.jdbc.OracleConnection.class.getDeclaredMethod("oracleSetSavepoint");
         methodObject30791 = oracle.jdbc.OracleConnection.class.getDeclaredMethod("putDescriptor", String.class, Object.class);
         methodObject30677 = OracleConnection.class.getDeclaredMethod("getDbCsId");
         methodObject30748 = OracleConnection.class.getDeclaredMethod("executeLightweightSessionPiggyback", Integer.TYPE, byte[].class, KeywordValueLong[].class, Integer.TYPE);
         methodObject30876 = oracle.jdbc.OracleConnection.class.getDeclaredMethod("createINTERVALYM", String.class);
         methodObject30672 = OracleConnection.class.getDeclaredMethod("getTdoCState", String.class, String.class);
         methodObject30720 = OracleConnection.class.getDeclaredMethod("javaCharsToCHARBytes", char[].class, Integer.TYPE, byte[].class);
         methodObject30724 = OracleConnection.class.getDeclaredMethod("isStatementCacheInitialized");
         methodObject30746 = OracleConnection.class.getDeclaredMethod("getMapDateToTimestamp");
         methodObject30923 = oracle.jdbc.OracleConnection.class.getDeclaredMethod("detachServerConnection", String.class);
         methodObject30938 = Connection.class.getDeclaredMethod("createBlob");
         methodObject30717 = OracleConnection.class.getDeclaredMethod("getMaxCharbyteSize");
         methodObject30976 = Wrapper.class.getDeclaredMethod("isWrapperFor", Class.class);
         methodObject30655 = OracleConnection.class.getDeclaredMethod("getVersionNumber");
         methodObject30935 = Connection.class.getDeclaredMethod("releaseSavepoint", Savepoint.class);
         methodObject30674 = OracleConnection.class.getDeclaredMethod("getByteBufferCacheStatistics");
         methodObject30653 = OracleConnection.class.getDeclaredMethod("getOCIHandles");
         methodObject30978 = ACProxyable.class.getDeclaredMethod("getACProxy");
         methodObject30819 = oracle.jdbc.OracleConnection.class.getDeclaredMethod("setIncludeSynonyms", Boolean.TYPE);
         methodObject30713 = OracleConnection.class.getDeclaredMethod("IsNCharFixedWith");
         methodObject30725 = OracleConnection.class.getDeclaredMethod("getProtocolType");
         methodObject30843 = oracle.jdbc.OracleConnection.class.getDeclaredMethod("getSessionTimeZone");
         methodObject30912 = oracle.jdbc.OracleConnection.class.getDeclaredMethod("isUsable");
         methodObject30871 = oracle.jdbc.OracleConnection.class.getDeclaredMethod("createDATE", Date.class, Calendar.class);
         methodObject30899 = oracle.jdbc.OracleConnection.class.getDeclaredMethod("createTIMESTAMPTZ", String.class, Calendar.class);
         methodObject30908 = oracle.jdbc.OracleConnection.class.getDeclaredMethod("getTypeDescriptorsFromList", String[][].class);
         methodObject30711 = OracleConnection.class.getDeclaredMethod("CHARBytesToJavaChars", byte[].class, Integer.TYPE, char[].class);
         methodObject30967 = Connection.class.getDeclaredMethod("setTransactionIsolation", Integer.TYPE);
         methodObject30688 = OracleConnection.class.getDeclaredMethod("getCurrentSCN");
         methodObject30853 = oracle.jdbc.OracleConnection.class.getDeclaredMethod("setConnectionReleasePriority", Integer.TYPE);
         methodObject30737 = OracleConnection.class.getDeclaredMethod("getConnectionCacheCallbackFlag");
         methodObject30965 = Connection.class.getDeclaredMethod("setNetworkTimeout", Executor.class, Integer.TYPE);
         methodObject30647 = OracleConnection.class.getDeclaredMethod("createClob", byte[].class);
      } catch (Throwable var1) {
         throw new RuntimeException(var1);
      }
   }

   public oracle$1jdbc$1replay$1driver$1NonTxnReplayableConnection$2oracle$1jdbc$1internal$1OracleConnection$$$Proxy(OracleConnection var1, Object var2, ProxyFactory var3, Map var4) {
      this.delegate = var1;
      this.creator = var2;
      this.proxyFactory = var3;
      this.proxyCache = var4;
   }
}
