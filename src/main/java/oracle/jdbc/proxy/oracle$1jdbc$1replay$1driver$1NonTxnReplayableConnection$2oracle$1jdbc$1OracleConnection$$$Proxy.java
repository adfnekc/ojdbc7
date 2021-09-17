package oracle.jdbc.proxy;

import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Array;
import java.sql.Blob;
import java.sql.CallableStatement;
import java.sql.Clob;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.Date;
import java.sql.NClob;
import java.sql.PreparedStatement;
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
import java.util.Map;
import java.util.Properties;
import java.util.TimeZone;
import java.util.concurrent.Executor;
import oracle.jdbc.LogicalTransactionId;
import oracle.jdbc.LogicalTransactionIdEventListener;
import oracle.jdbc.OracleConnection;
import oracle.jdbc.OracleOCIFailover;
import oracle.jdbc.OracleSavepoint;
import oracle.jdbc.aq.AQDequeueOptions;
import oracle.jdbc.aq.AQEnqueueOptions;
import oracle.jdbc.aq.AQMessage;
import oracle.jdbc.aq.AQNotificationRegistration;
import oracle.jdbc.dcn.DatabaseChangeRegistration;
import oracle.jdbc.pool.OracleConnectionCacheCallback;
import oracle.jdbc.replay.driver.NonTxnReplayableConnection;
import oracle.sql.ARRAY;
import oracle.sql.BINARY_DOUBLE;
import oracle.sql.BINARY_FLOAT;
import oracle.sql.DATE;
import oracle.sql.INTERVALDS;
import oracle.sql.INTERVALYM;
import oracle.sql.NUMBER;
import oracle.sql.TIMESTAMP;
import oracle.sql.TIMESTAMPLTZ;
import oracle.sql.TIMESTAMPTZ;
import oracle.sql.TypeDescriptor;

public abstract class oracle$1jdbc$1replay$1driver$1NonTxnReplayableConnection$2oracle$1jdbc$1OracleConnection$$$Proxy extends NonTxnReplayableConnection implements OracleConnection, _Proxy_ {
   private OracleConnection delegate;
   private final Object creator;
   private final ProxyFactory proxyFactory;
   private final Map proxyCache;
   private static Object[] zeroLengthObjectArray = new Object[0];
   private static Method methodObject30483;
   private static Method methodObject30440;
   private static Method methodObject30487;
   private static Method methodObject30627;
   private static Method methodObject30531;
   private static Method methodObject30542;
   private static Method methodObject30628;
   private static Method methodObject30598;
   private static Method methodObject30460;
   private static Method methodObject30445;
   private static Method methodObject30641;
   private static Method methodObject30510;
   private static Method methodObject30530;
   private static Method methodObject30504;
   private static Method methodObject30448;
   private static Method methodObject30482;
   private static Method methodObject30447;
   private static Method methodObject30556;
   private static Method methodObject30503;
   private static Method methodObject30606;
   private static Method methodObject30543;
   private static Method methodObject30575;
   private static Method methodObject30571;
   private static Method methodObject30478;
   private static Method methodObject30599;
   private static Method methodObject30634;
   private static Method methodObject30555;
   private static Method methodObject30509;
   private static Method methodObject30639;
   private static Method methodObject30474;
   private static Method methodObject30610;
   private static Method methodObject30626;
   private static Method methodObject30457;
   private static Method methodObject30636;
   private static Method methodObject30589;
   private static Method methodObject30547;
   private static Method methodObject30580;
   private static Method methodObject30522;
   private static Method methodObject30607;
   private static Method methodObject30488;
   private static Method methodObject30622;
   private static Method methodObject30535;
   private static Method methodObject30550;
   private static Method methodObject30552;
   private static Method methodObject30498;
   private static Method methodObject30620;
   private static Method methodObject30608;
   private static Method methodObject30621;
   private static Method methodObject30545;
   private static Method methodObject30471;
   private static Method methodObject30466;
   private static Method methodObject30516;
   private static Method methodObject30528;
   private static Method methodObject30546;
   private static Method methodObject30527;
   private static Method methodObject30514;
   private static Method methodObject30611;
   private static Method methodObject30496;
   private static Method methodObject30492;
   private static Method methodObject30489;
   private static Method methodObject30439;
   private static Method methodObject30578;
   private static Method methodObject30495;
   private static Method methodObject30558;
   private static Method methodObject30557;
   private static Method methodObject30563;
   private static Method methodObject30568;
   private static Method methodObject30561;
   private static Method methodObject30614;
   private static Method methodObject30501;
   private static Method methodObject30497;
   private static Method methodObject30441;
   private static Method methodObject30533;
   private static Method methodObject30553;
   private static Method methodObject30559;
   private static Method methodObject30635;
   private static Method methodObject30587;
   private static Method methodObject30615;
   private static Method methodObject30565;
   private static Method methodObject30582;
   private static Method methodObject30493;
   private static Method methodObject30506;
   private static Method methodObject30592;
   private static Method methodObject30581;
   private static Method methodObject30625;
   private static Method methodObject30612;
   private static Method methodObject30538;
   private static Method methodObject30642;
   private static Method methodObject30526;
   private static Method methodObject30630;
   private static Method methodObject30480;
   private static Method methodObject30638;
   private static Method methodObject30479;
   private static Method methodObject30459;
   private static Method methodObject30554;
   private static Method methodObject30490;
   private static Method methodObject30623;
   private static Method methodObject30451;
   private static Method methodObject30524;
   private static Method methodObject30452;
   private static Method methodObject30463;
   private static Method methodObject30443;
   private static Method methodObject30590;
   private static Method methodObject30613;
   private static Method methodObject30616;
   private static Method methodObject30540;
   private static Method methodObject30579;
   private static Method methodObject30586;
   private static Method methodObject30468;
   private static Method methodObject30485;
   private static Method methodObject30476;
   private static Method methodObject30569;
   private static Method methodObject30519;
   private static Method methodObject30475;
   private static Method methodObject30602;
   private static Method methodObject30472;
   private static Method methodObject30481;
   private static Method methodObject30567;
   private static Method methodObject30467;
   private static Method methodObject30513;
   private static Method methodObject30605;
   private static Method methodObject30637;
   private static Method methodObject30597;
   private static Method methodObject30502;
   private static Method methodObject30640;
   private static Method methodObject30562;
   private static Method methodObject30511;
   private static Method methodObject30442;
   private static Method methodObject30596;
   private static Method methodObject30454;
   private static Method methodObject30499;
   private static Method methodObject30453;
   private static Method methodObject30465;
   private static Method methodObject30601;
   private static Method methodObject30500;
   private static Method methodObject30450;
   private static Method methodObject30461;
   private static Method methodObject30566;
   private static Method methodObject30458;
   private static Method methodObject30585;
   private static Method methodObject30594;
   private static Method methodObject30520;
   private static Method methodObject30517;
   private static Method methodObject30505;
   private static Method methodObject30477;
   private static Method methodObject30593;
   private static Method methodObject30462;
   private static Method methodObject30512;
   private static Method methodObject30560;
   private static Method methodObject30507;
   private static Method methodObject30548;
   private static Method methodObject30574;
   private static Method methodObject30521;
   private static Method methodObject30444;
   private static Method methodObject30464;
   private static Method methodObject30486;
   private static Method methodObject30470;
   private static Method methodObject30632;
   private static Method methodObject30549;
   private static Method methodObject30595;
   private static Method methodObject30624;
   private static Method methodObject30629;
   private static Method methodObject30469;
   private static Method methodObject30537;
   private static Method methodObject30455;
   private static Method methodObject30583;
   private static Method methodObject30534;
   private static Method methodObject30618;
   private static Method methodObject30591;
   private static Method methodObject30529;
   private static Method methodObject30544;
   private static Method methodObject30572;
   private static Method methodObject30525;
   private static Method methodObject30539;
   private static Method methodObject30604;
   private static Method methodObject30491;
   private static Method methodObject30570;
   private static Method methodObject30523;
   private static Method methodObject30446;
   private static Method methodObject30576;
   private static Method methodObject30515;
   private static Method methodObject30551;
   private static Method methodObject30609;
   private static Method methodObject30617;
   private static Method methodObject30619;
   private static Method methodObject30532;
   private static Method methodObject30494;
   private static Method methodObject30473;
   private static Method methodObject30584;
   private static Method methodObject30456;
   private static Method methodObject30449;
   private static Method methodObject30541;
   private static Method methodObject30588;
   private static Method methodObject30603;
   private static Method methodObject30643;
   private static Method methodObject30600;
   private static Method methodObject30484;
   private static Method methodObject30508;
   private static Method methodObject30577;
   private static Method methodObject30536;
   private static Method methodObject30564;
   private static Method methodObject30573;
   private static Method methodObject30633;
   private static Method methodObject30518;
   private static Method methodObject30631;

   public void setEndToEndMetrics(String[] arg0, short arg1) throws SQLException {
      try {
         super.preForAll(methodObject30483, this, arg0, arg1);
         Method var10001 = methodObject30483;
         this.delegate.setEndToEndMetrics(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject30483, var4);
      }
   }

   public Object getDescriptor(String arg0) {
      super.preForAll(methodObject30440, this, arg0);
      return this.postForAll(methodObject30440, this.proxyFactory.proxyForCache(this.delegate.getDescriptor(arg0), this, this.proxyCache, methodObject30440));
   }

   public void setStmtCacheSize(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject30487, this, arg0);
         Method var10001 = methodObject30487;
         this.delegate.setStmtCacheSize(arg0);
         this.postForAll(var10001);
      } catch (SQLException var3) {
         this.onErrorVoidForAll(methodObject30487, var3);
      }
   }

   public void setCatalog(String arg0) throws SQLException {
      try {
         super.preForAll(methodObject30627, this, arg0);
         Method var10001 = methodObject30627;
         this.delegate.setCatalog(arg0);
         this.postForAll(var10001);
      } catch (SQLException var3) {
         this.onErrorVoidForAll(methodObject30627, var3);
      }
   }

   public BINARY_DOUBLE createBINARY_DOUBLE(double arg0) throws SQLException {
      try {
         super.preForAll(methodObject30531, this, arg0);
         return (BINARY_DOUBLE)this.postForAll(methodObject30531, (Object)this.delegate.createBINARY_DOUBLE(arg0));
      } catch (SQLException var4) {
         return (BINARY_DOUBLE)this.postForAll(methodObject30531, this.onErrorForAll(methodObject30531, var4));
      }
   }

   public NUMBER createNUMBER(boolean arg0) throws SQLException {
      try {
         super.preForAll(methodObject30542, this, arg0);
         return (NUMBER)this.postForAll(methodObject30542, (Object)this.delegate.createNUMBER(arg0));
      } catch (SQLException var3) {
         return (NUMBER)this.postForAll(methodObject30542, this.onErrorForAll(methodObject30542, var3));
      }
   }

   public void setClientInfo(String arg0, String arg1) throws SQLClientInfoException {
      super.preForAll(methodObject30628, this, arg0, arg1);
      Method var10001 = methodObject30628;
      this.delegate.setClientInfo(arg0, arg1);
      this.postForAll(var10001);
   }

   public Savepoint setSavepoint() throws SQLException {
      try {
         super.preForTxnControl(methodObject30598, this, zeroLengthObjectArray);
         return (Savepoint)this.postForAll(methodObject30598, this.proxyFactory.proxyForCreate((Object)this.delegate.setSavepoint(), this, this.proxyCache, methodObject30598));
      } catch (SQLException var2) {
         return (Savepoint)this.postForAll(methodObject30598, this.onErrorForAll(methodObject30598, var2));
      }
   }

   public boolean getAutoClose() throws SQLException {
      try {
         super.preForAll(methodObject30460, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject30460, this.delegate.getAutoClose());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject30460, this.onErrorForAll(methodObject30460, var2));
      }
   }

   public OracleConnection unwrap() {
      super.preForAll(methodObject30445, this, zeroLengthObjectArray);
      return (OracleConnection)this.postForAll(methodObject30445, (Object)super.unwrap());
   }

   public int getTransactionIsolation() throws SQLException {
      try {
         super.preForAll(methodObject30641, this, zeroLengthObjectArray);
         return (Integer)this.postForAll(methodObject30641, this.delegate.getTransactionIsolation());
      } catch (SQLException var2) {
         return (Integer)this.postForAll(methodObject30641, this.onErrorForAll(methodObject30641, var2));
      }
   }

   public boolean isLogicalConnection() {
      super.preForAll(methodObject30510, this, zeroLengthObjectArray);
      return (Boolean)this.postForAll(methodObject30510, this.delegate.isLogicalConnection());
   }

   public void unregisterDatabaseChangeNotification(long arg0, String arg1) throws SQLException {
      try {
         super.preForAll(methodObject30530, this, arg0, arg1);
         Method var10001 = methodObject30530;
         this.delegate.unregisterDatabaseChangeNotification(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var5) {
         this.onErrorVoidForAll(methodObject30530, var5);
      }
   }

   public CallableStatement prepareCallWithKey(String arg0) throws SQLException {
      try {
         super.preForAll(methodObject30504, this, arg0);
         return (CallableStatement)this.postForAll(methodObject30504, this.proxyFactory.proxyForCache((Object)this.delegate.prepareCallWithKey(arg0), this, this.proxyCache, methodObject30504));
      } catch (SQLException var3) {
         return (CallableStatement)this.postForAll(methodObject30504, this.onErrorForAll(methodObject30504, var3));
      }
   }

   public void oracleRollback(OracleSavepoint arg0) throws SQLException {
      try {
         super.preForTxnControl(methodObject30448, this, arg0);
         Method var10001 = methodObject30448;
         this.delegate.oracleRollback(arg0 instanceof _Proxy_ ? (OracleSavepoint)((_Proxy_)arg0)._getDelegate_() : arg0);
         this.postForAll(var10001);
      } catch (SQLException var3) {
         this.onErrorVoidForAll(methodObject30448, var3);
      }
   }

   public void setDefaultRowPrefetch(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject30482, this, arg0);
         Method var10001 = methodObject30482;
         this.delegate.setDefaultRowPrefetch(arg0);
         this.postForAll(var10001);
      } catch (SQLException var3) {
         this.onErrorVoidForAll(methodObject30482, var3);
      }
   }

   public void commit(EnumSet arg0) throws SQLException {
      try {
         super.preForTxnControl(methodObject30447, this, arg0);
         Method var10001 = methodObject30447;
         this.delegate.commit(arg0);
         this.postForAll(var10001);
      } catch (SQLException var3) {
         this.onErrorVoidForAll(methodObject30447, var3);
      }
   }

   public TIMESTAMP createTIMESTAMP(String arg0) throws SQLException {
      try {
         super.preForAll(methodObject30556, this, arg0);
         return (TIMESTAMP)this.postForAll(methodObject30556, (Object)this.delegate.createTIMESTAMP(arg0));
      } catch (SQLException var3) {
         return (TIMESTAMP)this.postForAll(methodObject30556, this.onErrorForAll(methodObject30556, var3));
      }
   }

   public PreparedStatement prepareStatementWithKey(String arg0) throws SQLException {
      try {
         super.preForAll(methodObject30503, this, arg0);
         return (PreparedStatement)this.postForAll(methodObject30503, this.proxyFactory.proxyForCache((Object)this.delegate.prepareStatementWithKey(arg0), this, this.proxyCache, methodObject30503));
      } catch (SQLException var3) {
         return (PreparedStatement)this.postForAll(methodObject30503, this.onErrorForAll(methodObject30503, var3));
      }
   }

   public SQLXML createSQLXML() throws SQLException {
      try {
         super.preForAll(methodObject30606, this, zeroLengthObjectArray);
         return (SQLXML)this.postForAll(methodObject30606, this.proxyFactory.proxyForCreateCache((Object)this.delegate.createSQLXML(), this, this.proxyCache, methodObject30606));
      } catch (SQLException var2) {
         return (SQLXML)this.postForAll(methodObject30606, this.onErrorForAll(methodObject30606, var2));
      }
   }

   public NUMBER createNUMBER(byte arg0) throws SQLException {
      try {
         super.preForAll(methodObject30543, this, arg0);
         return (NUMBER)this.postForAll(methodObject30543, (Object)this.delegate.createNUMBER(arg0));
      } catch (SQLException var3) {
         return (NUMBER)this.postForAll(methodObject30543, this.onErrorForAll(methodObject30543, var3));
      }
   }

   public String getEncryptionAlgorithmName() throws SQLException {
      try {
         super.preForAll(methodObject30575, this, zeroLengthObjectArray);
         return (String)this.postForAll(methodObject30575, (Object)this.delegate.getEncryptionAlgorithmName());
      } catch (SQLException var2) {
         return (String)this.postForAll(methodObject30575, this.onErrorForAll(methodObject30575, var2));
      }
   }

   public TypeDescriptor[] getAllTypeDescriptorsInCurrentSchema() throws SQLException {
      try {
         super.preForAll(methodObject30571, this, zeroLengthObjectArray);
         return (TypeDescriptor[])this.postForAll(methodObject30571, (Object)this.delegate.getAllTypeDescriptorsInCurrentSchema());
      } catch (SQLException var2) {
         return (TypeDescriptor[])this.postForAll(methodObject30571, this.onErrorForAll(methodObject30571, var2));
      }
   }

   public void registerSQLType(String arg0, Class arg1) throws SQLException {
      try {
         super.preForAll(methodObject30478, this, arg0, arg1);
         Method var10001 = methodObject30478;
         this.delegate.registerSQLType(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject30478, var4);
      }
   }

   public Savepoint setSavepoint(String arg0) throws SQLException {
      try {
         super.preForTxnControl(methodObject30599, this, arg0);
         return (Savepoint)this.postForAll(methodObject30599, this.proxyFactory.proxyForCreate((Object)this.delegate.setSavepoint(arg0), this, this.proxyCache, methodObject30599));
      } catch (SQLException var3) {
         return (Savepoint)this.postForAll(methodObject30599, this.onErrorForAll(methodObject30599, var3));
      }
   }

   public void setTypeMap(Map arg0) throws SQLException {
      try {
         super.preForAll(methodObject30634, this, arg0);
         Method var10001 = methodObject30634;
         this.delegate.setTypeMap(arg0);
         this.postForAll(var10001);
      } catch (SQLException var3) {
         this.onErrorVoidForAll(methodObject30634, var3);
      }
   }

   public TIMESTAMP createTIMESTAMP(Timestamp arg0) throws SQLException {
      try {
         super.preForAll(methodObject30555, this, arg0);
         return (TIMESTAMP)this.postForAll(methodObject30555, (Object)this.delegate.createTIMESTAMP(arg0));
      } catch (SQLException var3) {
         return (TIMESTAMP)this.postForAll(methodObject30555, this.onErrorForAll(methodObject30555, var3));
      }
   }

   public String getSessionTimeZoneOffset() throws SQLException {
      try {
         super.preForAll(methodObject30509, this, zeroLengthObjectArray);
         return (String)this.postForAll(methodObject30509, (Object)this.delegate.getSessionTimeZoneOffset());
      } catch (SQLException var2) {
         return (String)this.postForAll(methodObject30509, this.onErrorForAll(methodObject30509, var2));
      }
   }

   public Properties getClientInfo() throws SQLException {
      try {
         super.preForAll(methodObject30639, this, zeroLengthObjectArray);
         return (Properties)this.postForAll(methodObject30639, (Object)this.delegate.getClientInfo());
      } catch (SQLException var2) {
         return (Properties)this.postForAll(methodObject30639, this.onErrorForAll(methodObject30639, var2));
      }
   }

   public boolean getUsingXAFlag() {
      super.preForAll(methodObject30474, this, zeroLengthObjectArray);
      return (Boolean)this.postForAll(methodObject30474, this.delegate.getUsingXAFlag());
   }

   public CallableStatement prepareCall(String arg0) throws SQLException {
      try {
         super.preForAll(methodObject30610, this, arg0);
         return (CallableStatement)this.postForAll(methodObject30610, this.proxyFactory.proxyForCreateCache((Object)this.delegate.prepareCall(arg0), this, this.proxyCache, methodObject30610));
      } catch (SQLException var3) {
         return (CallableStatement)this.postForAll(methodObject30610, this.onErrorForAll(methodObject30610, var3));
      }
   }

   public void setAutoCommit(boolean arg0) throws SQLException {
      try {
         super.preForAll(methodObject30626, this, arg0);
         Method var10001 = methodObject30626;
         this.delegate.setAutoCommit(arg0);
         this.postForAll(var10001);
      } catch (SQLException var3) {
         this.onErrorVoidForAll(methodObject30626, var3);
      }
   }

   public oracle.jdbc.internal.OracleConnection physicalConnectionWithin() {
      super.preForAll(methodObject30457, this, zeroLengthObjectArray);
      return (oracle.jdbc.internal.OracleConnection)this.postForAll(methodObject30457, this.proxyFactory.proxyForCache((Object)this.delegate.physicalConnectionWithin(), this, this.proxyCache, methodObject30457));
   }

   public void clearWarnings() throws SQLException {
      try {
         super.preForAll(methodObject30636, this, zeroLengthObjectArray);
         Method var10001 = methodObject30636;
         this.delegate.clearWarnings();
         this.postForAll(var10001);
      } catch (SQLException var2) {
         this.onErrorVoidForAll(methodObject30636, var2);
      }
   }

   public boolean needToPurgeStatementCache() throws SQLException {
      try {
         super.preForAll(methodObject30589, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject30589, this.delegate.needToPurgeStatementCache());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject30589, this.onErrorForAll(methodObject30589, var2));
      }
   }

   public NUMBER createNUMBER(float arg0) throws SQLException {
      try {
         super.preForAll(methodObject30547, this, arg0);
         return (NUMBER)this.postForAll(methodObject30547, (Object)this.delegate.createNUMBER(arg0));
      } catch (SQLException var3) {
         return (NUMBER)this.postForAll(methodObject30547, this.onErrorForAll(methodObject30547, var3));
      }
   }

   public void setApplicationContext(String arg0, String arg1, String arg2) throws SQLException {
      try {
         super.preForAll(methodObject30580, this, arg0, arg1, arg2);
         Method var10001 = methodObject30580;
         this.delegate.setApplicationContext(arg0, arg1, arg2);
         this.postForAll(var10001);
      } catch (SQLException var5) {
         this.onErrorVoidForAll(methodObject30580, var5);
      }
   }

   public void unregisterAQNotification(AQNotificationRegistration arg0) throws SQLException {
      try {
         super.preForAll(methodObject30522, this, arg0);
         Method var10001 = methodObject30522;
         this.delegate.unregisterAQNotification(arg0);
         this.postForAll(var10001);
      } catch (SQLException var3) {
         this.onErrorVoidForAll(methodObject30522, var3);
      }
   }

   public Statement createStatement() throws SQLException {
      try {
         super.preForAll(methodObject30607, this, zeroLengthObjectArray);
         return (Statement)this.postForAll(methodObject30607, this.proxyFactory.proxyForCreateCache((Object)this.delegate.createStatement(), this, this.proxyCache, methodObject30607));
      } catch (SQLException var2) {
         return (Statement)this.postForAll(methodObject30607, this.onErrorForAll(methodObject30607, var2));
      }
   }

   public void setStmtCacheSize(int arg0, boolean arg1) throws SQLException {
      try {
         super.preForAll(methodObject30488, this, arg0, arg1);
         Method var10001 = methodObject30488;
         this.delegate.setStmtCacheSize(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject30488, var4);
      }
   }

   public DatabaseMetaData getMetaData() throws SQLException {
      try {
         super.preForAll(methodObject30622, this, zeroLengthObjectArray);
         return (DatabaseMetaData)this.postForAll(methodObject30622, this.proxyFactory.proxyForCache((Object)this.delegate.getMetaData(), this, this.proxyCache, methodObject30622));
      } catch (SQLException var2) {
         return (DatabaseMetaData)this.postForAll(methodObject30622, this.onErrorForAll(methodObject30622, var2));
      }
   }

   public DATE createDATE(Timestamp arg0) throws SQLException {
      try {
         super.preForAll(methodObject30535, this, arg0);
         return (DATE)this.postForAll(methodObject30535, (Object)this.delegate.createDATE(arg0));
      } catch (SQLException var3) {
         return (DATE)this.postForAll(methodObject30535, this.onErrorForAll(methodObject30535, var3));
      }
   }

   public NUMBER createNUMBER(BigInteger arg0) throws SQLException {
      try {
         super.preForAll(methodObject30550, this, arg0);
         return (NUMBER)this.postForAll(methodObject30550, (Object)this.delegate.createNUMBER(arg0));
      } catch (SQLException var3) {
         return (NUMBER)this.postForAll(methodObject30550, this.onErrorForAll(methodObject30550, var3));
      }
   }

   public TIMESTAMP createTIMESTAMP(Date arg0) throws SQLException {
      try {
         super.preForAll(methodObject30552, this, arg0);
         return (TIMESTAMP)this.postForAll(methodObject30552, (Object)this.delegate.createTIMESTAMP(arg0));
      } catch (SQLException var3) {
         return (TIMESTAMP)this.postForAll(methodObject30552, this.onErrorForAll(methodObject30552, var3));
      }
   }

   public CallableStatement getCallWithKey(String arg0) throws SQLException {
      try {
         super.preForAll(methodObject30498, this, arg0);
         return (CallableStatement)this.postForAll(methodObject30498, this.proxyFactory.proxyForCache((Object)this.delegate.getCallWithKey(arg0), this, this.proxyCache, methodObject30498));
      } catch (SQLException var3) {
         return (CallableStatement)this.postForAll(methodObject30498, this.onErrorForAll(methodObject30498, var3));
      }
   }

   public boolean isClosed() throws SQLException {
      try {
         super.preForAll(methodObject30620, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject30620, this.delegate.isClosed());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject30620, this.onErrorForAll(methodObject30620, var2));
      }
   }

   public Statement createStatement(int arg0, int arg1) throws SQLException {
      try {
         super.preForAll(methodObject30608, this, arg0, arg1);
         return (Statement)this.postForAll(methodObject30608, this.proxyFactory.proxyForCreateCache((Object)this.delegate.createStatement(arg0, arg1), this, this.proxyCache, methodObject30608));
      } catch (SQLException var4) {
         return (Statement)this.postForAll(methodObject30608, this.onErrorForAll(methodObject30608, var4));
      }
   }

   public String getSchema() throws SQLException {
      try {
         super.preForAll(methodObject30621, this, zeroLengthObjectArray);
         return (String)this.postForAll(methodObject30621, (Object)this.delegate.getSchema());
      } catch (SQLException var2) {
         return (String)this.postForAll(methodObject30621, this.onErrorForAll(methodObject30621, var2));
      }
   }

   public NUMBER createNUMBER(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject30545, this, arg0);
         return (NUMBER)this.postForAll(methodObject30545, (Object)this.delegate.createNUMBER(arg0));
      } catch (SQLException var3) {
         return (NUMBER)this.postForAll(methodObject30545, this.onErrorForAll(methodObject30545, var3));
      }
   }

   public short getStructAttrCsId() throws SQLException {
      try {
         super.preForAll(methodObject30471, this, zeroLengthObjectArray);
         return (Short)this.postForAll(methodObject30471, this.delegate.getStructAttrCsId());
      } catch (SQLException var2) {
         return (Short)this.postForAll(methodObject30471, this.onErrorForAll(methodObject30471, var2));
      }
   }

   public boolean getRestrictGetTables() {
      super.preForAll(methodObject30466, this, zeroLengthObjectArray);
      return (Boolean)this.postForAll(methodObject30466, this.delegate.getRestrictGetTables());
   }

   public Properties getUnMatchedConnectionAttributes() throws SQLException {
      try {
         super.preForAll(methodObject30516, this, zeroLengthObjectArray);
         return (Properties)this.postForAll(methodObject30516, (Object)this.delegate.getUnMatchedConnectionAttributes());
      } catch (SQLException var2) {
         return (Properties)this.postForAll(methodObject30516, this.onErrorForAll(methodObject30516, var2));
      }
   }

   public void unregisterDatabaseChangeNotification(int arg0, String arg1, int arg2) throws SQLException {
      try {
         super.preForAll(methodObject30528, this, arg0, arg1, arg2);
         Method var10001 = methodObject30528;
         this.delegate.unregisterDatabaseChangeNotification(arg0, arg1, arg2);
         this.postForAll(var10001);
      } catch (SQLException var5) {
         this.onErrorVoidForAll(methodObject30528, var5);
      }
   }

   public NUMBER createNUMBER(long arg0) throws SQLException {
      try {
         super.preForAll(methodObject30546, this, arg0);
         return (NUMBER)this.postForAll(methodObject30546, (Object)this.delegate.createNUMBER(arg0));
      } catch (SQLException var4) {
         return (NUMBER)this.postForAll(methodObject30546, this.onErrorForAll(methodObject30546, var4));
      }
   }

   public void unregisterDatabaseChangeNotification(DatabaseChangeRegistration arg0) throws SQLException {
      try {
         super.preForAll(methodObject30527, this, arg0);
         Method var10001 = methodObject30527;
         this.delegate.unregisterDatabaseChangeNotification(arg0);
         this.postForAll(var10001);
      } catch (SQLException var3) {
         this.onErrorVoidForAll(methodObject30527, var3);
      }
   }

   public void applyConnectionAttributes(Properties arg0) throws SQLException {
      try {
         super.preForAll(methodObject30514, this, arg0);
         Method var10001 = methodObject30514;
         this.delegate.applyConnectionAttributes(arg0);
         this.postForAll(var10001);
      } catch (SQLException var3) {
         this.onErrorVoidForAll(methodObject30514, var3);
      }
   }

   public CallableStatement prepareCall(String arg0, int arg1, int arg2) throws SQLException {
      try {
         super.preForAll(methodObject30611, this, arg0, arg1, arg2);
         return (CallableStatement)this.postForAll(methodObject30611, this.proxyFactory.proxyForCreateCache((Object)this.delegate.prepareCall(arg0, arg1, arg2), this, this.proxyCache, methodObject30611));
      } catch (SQLException var5) {
         return (CallableStatement)this.postForAll(methodObject30611, this.onErrorForAll(methodObject30611, var5));
      }
   }

   public void purgeExplicitCache() throws SQLException {
      try {
         super.preForAll(methodObject30496, this, zeroLengthObjectArray);
         Method var10001 = methodObject30496;
         this.delegate.purgeExplicitCache();
         this.postForAll(var10001);
      } catch (SQLException var2) {
         this.onErrorVoidForAll(methodObject30496, var2);
      }
   }

   public boolean getImplicitCachingEnabled() throws SQLException {
      try {
         super.preForAll(methodObject30492, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject30492, this.delegate.getImplicitCachingEnabled());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject30492, this.onErrorForAll(methodObject30492, var2));
      }
   }

   public void setStatementCacheSize(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject30489, this, arg0);
         Method var10001 = methodObject30489;
         this.delegate.setStatementCacheSize(arg0);
         this.postForAll(var10001);
      } catch (SQLException var3) {
         this.onErrorVoidForAll(methodObject30489, var3);
      }
   }

   public void shutdown(OracleConnection.DatabaseShutdownMode arg0) throws SQLException {
      try {
         super.preForAll(methodObject30439, this, arg0);
         Method var10001 = methodObject30439;
         this.delegate.shutdown(arg0);
         this.postForAll(var10001);
      } catch (SQLException var3) {
         this.onErrorVoidForAll(methodObject30439, var3);
      }
   }

   public void setDefaultTimeZone(TimeZone arg0) throws SQLException {
      try {
         super.preForAll(methodObject30578, this, arg0);
         Method var10001 = methodObject30578;
         this.delegate.setDefaultTimeZone(arg0);
         this.postForAll(var10001);
      } catch (SQLException var3) {
         this.onErrorVoidForAll(methodObject30578, var3);
      }
   }

   public void purgeImplicitCache() throws SQLException {
      try {
         super.preForAll(methodObject30495, this, zeroLengthObjectArray);
         Method var10001 = methodObject30495;
         this.delegate.purgeImplicitCache();
         this.postForAll(var10001);
      } catch (SQLException var2) {
         this.onErrorVoidForAll(methodObject30495, var2);
      }
   }

   public TIMESTAMPTZ createTIMESTAMPTZ(Date arg0, Calendar arg1) throws SQLException {
      try {
         super.preForAll(methodObject30558, this, arg0, arg1);
         return (TIMESTAMPTZ)this.postForAll(methodObject30558, (Object)this.delegate.createTIMESTAMPTZ(arg0, arg1));
      } catch (SQLException var4) {
         return (TIMESTAMPTZ)this.postForAll(methodObject30558, this.onErrorForAll(methodObject30558, var4));
      }
   }

   public TIMESTAMPTZ createTIMESTAMPTZ(Date arg0) throws SQLException {
      try {
         super.preForAll(methodObject30557, this, arg0);
         return (TIMESTAMPTZ)this.postForAll(methodObject30557, (Object)this.delegate.createTIMESTAMPTZ(arg0));
      } catch (SQLException var3) {
         return (TIMESTAMPTZ)this.postForAll(methodObject30557, this.onErrorForAll(methodObject30557, var3));
      }
   }

   public TIMESTAMPTZ createTIMESTAMPTZ(String arg0) throws SQLException {
      try {
         super.preForAll(methodObject30563, this, arg0);
         return (TIMESTAMPTZ)this.postForAll(methodObject30563, (Object)this.delegate.createTIMESTAMPTZ(arg0));
      } catch (SQLException var3) {
         return (TIMESTAMPTZ)this.postForAll(methodObject30563, this.onErrorForAll(methodObject30563, var3));
      }
   }

   public TIMESTAMPLTZ createTIMESTAMPLTZ(Timestamp arg0, Calendar arg1) throws SQLException {
      try {
         super.preForAll(methodObject30568, this, arg0, arg1);
         return (TIMESTAMPLTZ)this.postForAll(methodObject30568, (Object)this.delegate.createTIMESTAMPLTZ(arg0, arg1));
      } catch (SQLException var4) {
         return (TIMESTAMPLTZ)this.postForAll(methodObject30568, this.onErrorForAll(methodObject30568, var4));
      }
   }

   public TIMESTAMPTZ createTIMESTAMPTZ(Timestamp arg0) throws SQLException {
      try {
         super.preForAll(methodObject30561, this, arg0);
         return (TIMESTAMPTZ)this.postForAll(methodObject30561, (Object)this.delegate.createTIMESTAMPTZ(arg0));
      } catch (SQLException var3) {
         return (TIMESTAMPTZ)this.postForAll(methodObject30561, this.onErrorForAll(methodObject30561, var3));
      }
   }

   public PreparedStatement prepareStatement(String arg0, int arg1, int arg2) throws SQLException {
      try {
         super.preForAll(methodObject30614, this, arg0, arg1, arg2);
         return (PreparedStatement)this.postForAll(methodObject30614, this.proxyFactory.proxyForCreateCache((Object)this.delegate.prepareStatement(arg0, arg1, arg2), this, this.proxyCache, methodObject30614));
      } catch (SQLException var5) {
         return (PreparedStatement)this.postForAll(methodObject30614, this.onErrorForAll(methodObject30614, var5));
      }
   }

   public void startup(String arg0, int arg1) throws SQLException {
      try {
         super.preForAll(methodObject30501, this, arg0, arg1);
         Method var10001 = methodObject30501;
         this.delegate.startup(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject30501, var4);
      }
   }

   public PreparedStatement getStatementWithKey(String arg0) throws SQLException {
      try {
         super.preForAll(methodObject30497, this, arg0);
         return (PreparedStatement)this.postForAll(methodObject30497, this.proxyFactory.proxyForCache((Object)this.delegate.getStatementWithKey(arg0), this, this.proxyCache, methodObject30497));
      } catch (SQLException var3) {
         return (PreparedStatement)this.postForAll(methodObject30497, this.onErrorForAll(methodObject30497, var3));
      }
   }

   public Properties getProperties() {
      super.preForAll(methodObject30441, this, zeroLengthObjectArray);
      return (Properties)this.postForAll(methodObject30441, (Object)this.delegate.getProperties());
   }

   public DATE createDATE(Date arg0) throws SQLException {
      try {
         super.preForAll(methodObject30533, this, arg0);
         return (DATE)this.postForAll(methodObject30533, (Object)this.delegate.createDATE(arg0));
      } catch (SQLException var3) {
         return (DATE)this.postForAll(methodObject30533, this.onErrorForAll(methodObject30533, var3));
      }
   }

   public TIMESTAMP createTIMESTAMP(DATE arg0) throws SQLException {
      try {
         super.preForAll(methodObject30553, this, arg0);
         return (TIMESTAMP)this.postForAll(methodObject30553, (Object)this.delegate.createTIMESTAMP(arg0));
      } catch (SQLException var3) {
         return (TIMESTAMP)this.postForAll(methodObject30553, this.onErrorForAll(methodObject30553, var3));
      }
   }

   public TIMESTAMPTZ createTIMESTAMPTZ(Time arg0) throws SQLException {
      try {
         super.preForAll(methodObject30559, this, arg0);
         return (TIMESTAMPTZ)this.postForAll(methodObject30559, (Object)this.delegate.createTIMESTAMPTZ(arg0));
      } catch (SQLException var3) {
         return (TIMESTAMPTZ)this.postForAll(methodObject30559, this.onErrorForAll(methodObject30559, var3));
      }
   }

   public int getNetworkTimeout() throws SQLException {
      try {
         super.preForAll(methodObject30635, this, zeroLengthObjectArray);
         return (Integer)this.postForAll(methodObject30635, this.delegate.getNetworkTimeout());
      } catch (SQLException var2) {
         return (Integer)this.postForAll(methodObject30635, this.onErrorForAll(methodObject30635, var2));
      }
   }

   public boolean attachServerConnection() throws SQLException {
      try {
         super.preForAll(methodObject30587, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject30587, this.delegate.attachServerConnection());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject30587, this.onErrorForAll(methodObject30587, var2));
      }
   }

   public PreparedStatement prepareStatement(String arg0, int arg1, int arg2, int arg3) throws SQLException {
      try {
         super.preForAll(methodObject30615, this, arg0, arg1, arg2, arg3);
         return (PreparedStatement)this.postForAll(methodObject30615, this.proxyFactory.proxyForCreateCache((Object)this.delegate.prepareStatement(arg0, arg1, arg2, arg3), this, this.proxyCache, methodObject30615));
      } catch (SQLException var6) {
         return (PreparedStatement)this.postForAll(methodObject30615, this.onErrorForAll(methodObject30615, var6));
      }
   }

   public TIMESTAMPTZ createTIMESTAMPTZ(DATE arg0) throws SQLException {
      try {
         super.preForAll(methodObject30565, this, arg0);
         return (TIMESTAMPTZ)this.postForAll(methodObject30565, (Object)this.delegate.createTIMESTAMPTZ(arg0));
      } catch (SQLException var3) {
         return (TIMESTAMPTZ)this.postForAll(methodObject30565, this.onErrorForAll(methodObject30565, var3));
      }
   }

   public void addLogicalTransactionIdEventListener(LogicalTransactionIdEventListener arg0) throws SQLException {
      try {
         super.preForAll(methodObject30582, this, arg0);
         Method var10001 = methodObject30582;
         this.delegate.addLogicalTransactionIdEventListener(arg0);
         this.postForAll(var10001);
      } catch (SQLException var3) {
         this.onErrorVoidForAll(methodObject30582, var3);
      }
   }

   public void setExplicitCachingEnabled(boolean arg0) throws SQLException {
      try {
         super.preForAll(methodObject30493, this, arg0);
         Method var10001 = methodObject30493;
         this.delegate.setExplicitCachingEnabled(arg0);
         this.postForAll(var10001);
      } catch (SQLException var3) {
         this.onErrorVoidForAll(methodObject30493, var3);
      }
   }

   public boolean getCreateStatementAsRefCursor() {
      super.preForAll(methodObject30506, this, zeroLengthObjectArray);
      return (Boolean)this.postForAll(methodObject30506, this.delegate.getCreateStatementAsRefCursor());
   }

   public boolean isValid(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject30592, this, arg0);
         return (Boolean)this.postForAll(methodObject30592, this.delegate.isValid(arg0));
      } catch (SQLException var3) {
         return (Boolean)this.postForAll(methodObject30592, this.onErrorForAll(methodObject30592, var3));
      }
   }

   public void clearAllApplicationContext(String arg0) throws SQLException {
      try {
         super.preForAll(methodObject30581, this, arg0);
         Method var10001 = methodObject30581;
         this.delegate.clearAllApplicationContext(arg0);
         this.postForAll(var10001);
      } catch (SQLException var3) {
         this.onErrorVoidForAll(methodObject30581, var3);
      }
   }

   public String nativeSQL(String arg0) throws SQLException {
      try {
         super.preForAll(methodObject30625, this, arg0);
         return (String)this.postForAll(methodObject30625, (Object)this.delegate.nativeSQL(arg0));
      } catch (SQLException var3) {
         return (String)this.postForAll(methodObject30625, this.onErrorForAll(methodObject30625, var3));
      }
   }

   public CallableStatement prepareCall(String arg0, int arg1, int arg2, int arg3) throws SQLException {
      try {
         super.preForAll(methodObject30612, this, arg0, arg1, arg2, arg3);
         return (CallableStatement)this.postForAll(methodObject30612, this.proxyFactory.proxyForCreateCache((Object)this.delegate.prepareCall(arg0, arg1, arg2, arg3), this, this.proxyCache, methodObject30612));
      } catch (SQLException var6) {
         return (CallableStatement)this.postForAll(methodObject30612, this.onErrorForAll(methodObject30612, var6));
      }
   }

   public DATE createDATE(Timestamp arg0, Calendar arg1) throws SQLException {
      try {
         super.preForAll(methodObject30538, this, arg0, arg1);
         return (DATE)this.postForAll(methodObject30538, (Object)this.delegate.createDATE(arg0, arg1));
      } catch (SQLException var4) {
         return (DATE)this.postForAll(methodObject30538, this.onErrorForAll(methodObject30538, var4));
      }
   }

   public Object unwrap(Class arg0) throws SQLException {
      try {
         super.preForAll(methodObject30642, this, arg0);
         return this.postForAll(methodObject30642, super.unwrap(arg0));
      } catch (SQLException var3) {
         return this.postForAll(methodObject30642, this.onErrorForAll(methodObject30642, var3));
      }
   }

   public DatabaseChangeRegistration getDatabaseChangeRegistration(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject30526, this, arg0);
         return (DatabaseChangeRegistration)this.postForAll(methodObject30526, (Object)this.delegate.getDatabaseChangeRegistration(arg0));
      } catch (SQLException var3) {
         return (DatabaseChangeRegistration)this.postForAll(methodObject30526, this.onErrorForAll(methodObject30526, var3));
      }
   }

   public void setHoldability(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject30630, this, arg0);
         Method var10001 = methodObject30630;
         this.delegate.setHoldability(arg0);
         this.postForAll(var10001);
      } catch (SQLException var3) {
         this.onErrorVoidForAll(methodObject30630, var3);
      }
   }

   public void setAutoClose(boolean arg0) throws SQLException {
      try {
         super.preForAll(methodObject30480, this, arg0);
         Method var10001 = methodObject30480;
         this.delegate.setAutoClose(arg0);
         this.postForAll(var10001);
      } catch (SQLException var3) {
         this.onErrorVoidForAll(methodObject30480, var3);
      }
   }

   public String getClientInfo(String arg0) throws SQLException {
      try {
         super.preForAll(methodObject30638, this, arg0);
         return (String)this.postForAll(methodObject30638, (Object)this.delegate.getClientInfo(arg0));
      } catch (SQLException var3) {
         return (String)this.postForAll(methodObject30638, this.onErrorForAll(methodObject30638, var3));
      }
   }

   public void registerSQLType(String arg0, String arg1) throws SQLException {
      try {
         super.preForAll(methodObject30479, this, arg0, arg1);
         Method var10001 = methodObject30479;
         this.delegate.registerSQLType(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject30479, var4);
      }
   }

   public void openProxySession(int arg0, Properties arg1) throws SQLException {
      try {
         super.preForAll(methodObject30459, this, arg0, arg1);
         Method var10001 = methodObject30459;
         this.delegate.openProxySession(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject30459, var4);
      }
   }

   public TIMESTAMP createTIMESTAMP(Time arg0) throws SQLException {
      try {
         super.preForAll(methodObject30554, this, arg0);
         return (TIMESTAMP)this.postForAll(methodObject30554, (Object)this.delegate.createTIMESTAMP(arg0));
      } catch (SQLException var3) {
         return (TIMESTAMP)this.postForAll(methodObject30554, this.onErrorForAll(methodObject30554, var3));
      }
   }

   public int getStatementCacheSize() throws SQLException {
      try {
         super.preForAll(methodObject30490, this, zeroLengthObjectArray);
         return (Integer)this.postForAll(methodObject30490, this.delegate.getStatementCacheSize());
      } catch (SQLException var2) {
         return (Integer)this.postForAll(methodObject30490, this.onErrorForAll(methodObject30490, var2));
      }
   }

   public Map getTypeMap() throws SQLException {
      try {
         super.preForAll(methodObject30623, this, zeroLengthObjectArray);
         return (Map)this.postForAll(methodObject30623, (Object)this.delegate.getTypeMap());
      } catch (SQLException var2) {
         return (Map)this.postForAll(methodObject30623, this.onErrorForAll(methodObject30623, var2));
      }
   }

   public void oracleReleaseSavepoint(OracleSavepoint arg0) throws SQLException {
      try {
         super.preForTxnControl(methodObject30451, this, arg0);
         Method var10001 = methodObject30451;
         this.delegate.oracleReleaseSavepoint(arg0 instanceof _Proxy_ ? (OracleSavepoint)((_Proxy_)arg0)._getDelegate_() : arg0);
         this.postForAll(var10001);
      } catch (SQLException var3) {
         this.onErrorVoidForAll(methodObject30451, var3);
      }
   }

   public AQMessage dequeue(String arg0, AQDequeueOptions arg1, String arg2) throws SQLException {
      try {
         super.preForAll(methodObject30524, this, arg0, arg1, arg2);
         return (AQMessage)this.postForAll(methodObject30524, (Object)this.delegate.dequeue(arg0, arg1, arg2));
      } catch (SQLException var5) {
         return (AQMessage)this.postForAll(methodObject30524, this.onErrorForAll(methodObject30524, var5));
      }
   }

   public void cancel() throws SQLException {
      try {
         super.preForCancel(methodObject30452, this, zeroLengthObjectArray);
         Method var10001 = methodObject30452;
         this.delegate.cancel();
         this.postForCancel(var10001);
      } catch (SQLException var2) {
         this.onErrorVoidForAll(methodObject30452, var2);
      }
   }

   public String[] getEndToEndMetrics() throws SQLException {
      try {
         super.preForAll(methodObject30463, this, zeroLengthObjectArray);
         return (String[])this.postForAll(methodObject30463, (Object)this.delegate.getEndToEndMetrics());
      } catch (SQLException var2) {
         return (String[])this.postForAll(methodObject30463, this.onErrorForAll(methodObject30463, var2));
      }
   }

   public void close(Properties arg0) throws SQLException {
      try {
         super.preForClosure(methodObject30443, this, arg0);
         Method var10001 = methodObject30443;
         this.delegate.close(arg0);
         this.postForClosure(var10001);
      } catch (SQLException var3) {
         this.onErrorVoidForAll(methodObject30443, var3);
      }
   }

   public void setReadOnly(boolean arg0) throws SQLException {
      try {
         super.preForAll(methodObject30590, this, arg0);
         Method var10001 = methodObject30590;
         this.delegate.setReadOnly(arg0);
         this.postForAll(var10001);
      } catch (SQLException var3) {
         this.onErrorVoidForAll(methodObject30590, var3);
      }
   }

   public PreparedStatement prepareStatement(String arg0) throws SQLException {
      try {
         super.preForAll(methodObject30613, this, arg0);
         return (PreparedStatement)this.postForAll(methodObject30613, this.proxyFactory.proxyForCreateCache((Object)this.delegate.prepareStatement(arg0), this, this.proxyCache, methodObject30613));
      } catch (SQLException var3) {
         return (PreparedStatement)this.postForAll(methodObject30613, this.onErrorForAll(methodObject30613, var3));
      }
   }

   public PreparedStatement prepareStatement(String arg0, int arg1) throws SQLException {
      try {
         super.preForAll(methodObject30616, this, arg0, arg1);
         return (PreparedStatement)this.postForAll(methodObject30616, this.proxyFactory.proxyForCreateCache((Object)this.delegate.prepareStatement(arg0, arg1), this, this.proxyCache, methodObject30616));
      } catch (SQLException var4) {
         return (PreparedStatement)this.postForAll(methodObject30616, this.onErrorForAll(methodObject30616, var4));
      }
   }

   public INTERVALDS createINTERVALDS(String arg0) throws SQLException {
      try {
         super.preForAll(methodObject30540, this, arg0);
         return (INTERVALDS)this.postForAll(methodObject30540, (Object)this.delegate.createINTERVALDS(arg0));
      } catch (SQLException var3) {
         return (INTERVALDS)this.postForAll(methodObject30540, this.onErrorForAll(methodObject30540, var3));
      }
   }

   public TimeZone getDefaultTimeZone() throws SQLException {
      try {
         super.preForAll(methodObject30579, this, zeroLengthObjectArray);
         return (TimeZone)this.postForAll(methodObject30579, (Object)this.delegate.getDefaultTimeZone());
      } catch (SQLException var2) {
         return (TimeZone)this.postForAll(methodObject30579, this.onErrorForAll(methodObject30579, var2));
      }
   }

   public boolean isDRCPEnabled() throws SQLException {
      try {
         super.preForAll(methodObject30586, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject30586, this.delegate.isDRCPEnabled());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject30586, this.onErrorForAll(methodObject30586, var2));
      }
   }

   public boolean getRemarksReporting() {
      super.preForAll(methodObject30468, this, zeroLengthObjectArray);
      return (Boolean)this.postForAll(methodObject30468, this.delegate.getRemarksReporting());
   }

   public void setRemarksReporting(boolean arg0) {
      super.preForAll(methodObject30485, this, arg0);
      Method var10001 = methodObject30485;
      this.delegate.setRemarksReporting(arg0);
      this.postForAll(var10001);
   }

   public int pingDatabase() throws SQLException {
      try {
         super.preForAll(methodObject30476, this, zeroLengthObjectArray);
         return (Integer)this.postForAll(methodObject30476, this.delegate.pingDatabase());
      } catch (SQLException var2) {
         return (Integer)this.postForAll(methodObject30476, this.onErrorForAll(methodObject30476, var2));
      }
   }

   public TIMESTAMPLTZ createTIMESTAMPLTZ(String arg0, Calendar arg1) throws SQLException {
      try {
         super.preForAll(methodObject30569, this, arg0, arg1);
         return (TIMESTAMPLTZ)this.postForAll(methodObject30569, (Object)this.delegate.createTIMESTAMPLTZ(arg0, arg1));
      } catch (SQLException var4) {
         return (TIMESTAMPLTZ)this.postForAll(methodObject30569, this.onErrorForAll(methodObject30569, var4));
      }
   }

   public int getConnectionReleasePriority() throws SQLException {
      try {
         super.preForAll(methodObject30519, this, zeroLengthObjectArray);
         return (Integer)this.postForAll(methodObject30519, this.delegate.getConnectionReleasePriority());
      } catch (SQLException var2) {
         return (Integer)this.postForAll(methodObject30519, this.onErrorForAll(methodObject30519, var2));
      }
   }

   public boolean getXAErrorFlag() {
      super.preForAll(methodObject30475, this, zeroLengthObjectArray);
      return (Boolean)this.postForAll(methodObject30475, this.delegate.getXAErrorFlag());
   }

   public Struct createStruct(String arg0, Object[] arg1) throws SQLException {
      try {
         super.preForAll(methodObject30602, this, arg0, arg1);
         return (Struct)this.postForAll(methodObject30602, this.proxyFactory.proxyForCreateCache((Object)super.createStruct(arg0, arg1), this, this.proxyCache, methodObject30602));
      } catch (SQLException var4) {
         return (Struct)this.postForAll(methodObject30602, this.onErrorForAll(methodObject30602, var4));
      }
   }

   public String getUserName() throws SQLException {
      try {
         super.preForAll(methodObject30472, this, zeroLengthObjectArray);
         return (String)this.postForAll(methodObject30472, (Object)this.delegate.getUserName());
      } catch (SQLException var2) {
         return (String)this.postForAll(methodObject30472, this.onErrorForAll(methodObject30472, var2));
      }
   }

   public void setDefaultExecuteBatch(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject30481, this, arg0);
         Method var10001 = methodObject30481;
         this.delegate.setDefaultExecuteBatch(arg0);
         this.postForAll(var10001);
      } catch (SQLException var3) {
         this.onErrorVoidForAll(methodObject30481, var3);
      }
   }

   public TIMESTAMPLTZ createTIMESTAMPLTZ(Time arg0, Calendar arg1) throws SQLException {
      try {
         super.preForAll(methodObject30567, this, arg0, arg1);
         return (TIMESTAMPLTZ)this.postForAll(methodObject30567, (Object)this.delegate.createTIMESTAMPLTZ(arg0, arg1));
      } catch (SQLException var4) {
         return (TIMESTAMPLTZ)this.postForAll(methodObject30567, this.onErrorForAll(methodObject30567, var4));
      }
   }

   public Object getJavaObject(String arg0) throws SQLException {
      try {
         super.preForAll(methodObject30467, this, arg0);
         return this.postForAll(methodObject30467, this.proxyFactory.proxyForCache(this.delegate.getJavaObject(arg0), this, this.proxyCache, methodObject30467));
      } catch (SQLException var3) {
         return this.postForAll(methodObject30467, this.onErrorForAll(methodObject30467, var3));
      }
   }

   public boolean isProxySession() {
      super.preForAll(methodObject30513, this, zeroLengthObjectArray);
      return (Boolean)this.postForAll(methodObject30513, this.delegate.isProxySession());
   }

   public NClob createNClob() throws SQLException {
      try {
         super.preForAll(methodObject30605, this, zeroLengthObjectArray);
         return (NClob)this.postForAll(methodObject30605, this.proxyFactory.proxyForCreateCache((Object)this.delegate.createNClob(), this, this.proxyCache, methodObject30605));
      } catch (SQLException var2) {
         return (NClob)this.postForAll(methodObject30605, this.onErrorForAll(methodObject30605, var2));
      }
   }

   public boolean getAutoCommit() throws SQLException {
      try {
         super.preForAll(methodObject30637, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject30637, this.delegate.getAutoCommit());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject30637, this.onErrorForAll(methodObject30637, var2));
      }
   }

   public void rollback(Savepoint arg0) throws SQLException {
      try {
         super.preForTxnControl(methodObject30597, this, arg0);
         Method var10001 = methodObject30597;
         this.delegate.rollback(arg0 instanceof _Proxy_ ? (Savepoint)((_Proxy_)arg0)._getDelegate_() : arg0);
         this.postForAll(var10001);
      } catch (SQLException var3) {
         this.onErrorVoidForAll(methodObject30597, var3);
      }
   }

   public void startup(OracleConnection.DatabaseStartupMode arg0) throws SQLException {
      try {
         super.preForAll(methodObject30502, this, arg0);
         Method var10001 = methodObject30502;
         this.delegate.startup(arg0);
         this.postForAll(var10001);
      } catch (SQLException var3) {
         this.onErrorVoidForAll(methodObject30502, var3);
      }
   }

   public int getHoldability() throws SQLException {
      try {
         super.preForAll(methodObject30640, this, zeroLengthObjectArray);
         return (Integer)this.postForAll(methodObject30640, this.delegate.getHoldability());
      } catch (SQLException var2) {
         return (Integer)this.postForAll(methodObject30640, this.onErrorForAll(methodObject30640, var2));
      }
   }

   public TIMESTAMPTZ createTIMESTAMPTZ(Timestamp arg0, Calendar arg1) throws SQLException {
      try {
         super.preForAll(methodObject30562, this, arg0, arg1);
         return (TIMESTAMPTZ)this.postForAll(methodObject30562, (Object)this.delegate.createTIMESTAMPTZ(arg0, arg1));
      } catch (SQLException var4) {
         return (TIMESTAMPTZ)this.postForAll(methodObject30562, this.onErrorForAll(methodObject30562, var4));
      }
   }

   public void registerTAFCallback(OracleOCIFailover arg0, Object arg1) throws SQLException {
      try {
         super.preForAll(methodObject30511, this, arg0, arg1);
         Method var10001 = methodObject30511;
         this.delegate.registerTAFCallback(arg0, arg1 instanceof _Proxy_ ? (Object)((_Proxy_)arg1)._getDelegate_() : arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject30511, var4);
      }
   }

   public void enqueue(String arg0, AQEnqueueOptions arg1, AQMessage arg2) throws SQLException {
      try {
         super.preForAll(methodObject30442, this, arg0, arg1, arg2);
         Method var10001 = methodObject30442;
         this.delegate.enqueue(arg0, arg1, arg2);
         this.postForAll(var10001);
      } catch (SQLException var5) {
         this.onErrorVoidForAll(methodObject30442, var5);
      }
   }

   public void rollback() throws SQLException {
      try {
         super.preForTxnControl(methodObject30596, this, zeroLengthObjectArray);
         Method var10001 = methodObject30596;
         this.delegate.rollback();
         this.postForAll(var10001);
      } catch (SQLException var2) {
         this.onErrorVoidForAll(methodObject30596, var2);
      }
   }

   public Array createOracleArray(String arg0, Object arg1) throws SQLException {
      try {
         super.preForAll(methodObject30454, this, arg0, arg1);
         return (Array)this.postForAll(methodObject30454, this.proxyFactory.proxyForCreateCache((Object)super.createOracleArray(arg0, arg1 instanceof _Proxy_ ? (Object)((_Proxy_)arg1)._getDelegate_() : arg1), this, this.proxyCache, methodObject30454));
      } catch (SQLException var4) {
         return (Array)this.postForAll(methodObject30454, this.onErrorForAll(methodObject30454, var4));
      }
   }

   public void setUsingXAFlag(boolean arg0) {
      super.preForAll(methodObject30499, this, arg0);
      Method var10001 = methodObject30499;
      this.delegate.setUsingXAFlag(arg0);
      this.postForAll(var10001);
   }

   public ARRAY createARRAY(String arg0, Object arg1) throws SQLException {
      try {
         super.preForAll(methodObject30453, this, arg0, arg1);
         return (ARRAY)this.postForAll(methodObject30453, (Object)super.createARRAY(arg0, arg1 instanceof _Proxy_ ? (Object)((_Proxy_)arg1)._getDelegate_() : arg1));
      } catch (SQLException var4) {
         return (ARRAY)this.postForAll(methodObject30453, this.onErrorForAll(methodObject30453, var4));
      }
   }

   public boolean getIncludeSynonyms() {
      super.preForAll(methodObject30465, this, zeroLengthObjectArray);
      return (Boolean)this.postForAll(methodObject30465, this.delegate.getIncludeSynonyms());
   }

   public Array createArrayOf(String arg0, Object[] arg1) throws SQLException {
      try {
         super.preForAll(methodObject30601, this, arg0, arg1);
         return (Array)this.postForAll(methodObject30601, this.proxyFactory.proxyForCreateCache((Object)super.createArrayOf(arg0, arg1), this, this.proxyCache, methodObject30601));
      } catch (SQLException var4) {
         return (Array)this.postForAll(methodObject30601, this.onErrorForAll(methodObject30601, var4));
      }
   }

   public void setXAErrorFlag(boolean arg0) {
      super.preForAll(methodObject30500, this, arg0);
      Method var10001 = methodObject30500;
      this.delegate.setXAErrorFlag(arg0);
      this.postForAll(var10001);
   }

   public OracleSavepoint oracleSetSavepoint(String arg0) throws SQLException {
      try {
         super.preForTxnControl(methodObject30450, this, arg0);
         return (OracleSavepoint)this.postForAll(methodObject30450, this.proxyFactory.proxyForCreate((Object)this.delegate.oracleSetSavepoint(arg0), this, this.proxyCache, methodObject30450));
      } catch (SQLException var3) {
         return (OracleSavepoint)this.postForAll(methodObject30450, this.onErrorForAll(methodObject30450, var3));
      }
   }

   public int getDefaultExecuteBatch() {
      super.preForAll(methodObject30461, this, zeroLengthObjectArray);
      return (Integer)this.postForAll(methodObject30461, this.delegate.getDefaultExecuteBatch());
   }

   public TIMESTAMPLTZ createTIMESTAMPLTZ(Date arg0, Calendar arg1) throws SQLException {
      try {
         super.preForAll(methodObject30566, this, arg0, arg1);
         return (TIMESTAMPLTZ)this.postForAll(methodObject30566, (Object)this.delegate.createTIMESTAMPLTZ(arg0, arg1));
      } catch (SQLException var4) {
         return (TIMESTAMPLTZ)this.postForAll(methodObject30566, this.onErrorForAll(methodObject30566, var4));
      }
   }

   public void archive(int arg0, int arg1, String arg2) throws SQLException {
      try {
         super.preForAll(methodObject30458, this, arg0, arg1, arg2);
         Method var10001 = methodObject30458;
         this.delegate.archive(arg0, arg1, arg2);
         this.postForAll(var10001);
      } catch (SQLException var5) {
         this.onErrorVoidForAll(methodObject30458, var5);
      }
   }

   public LogicalTransactionId getLogicalTransactionId() throws SQLException {
      try {
         super.preForAll(methodObject30585, this, zeroLengthObjectArray);
         return (LogicalTransactionId)this.postForAll(methodObject30585, (Object)this.delegate.getLogicalTransactionId());
      } catch (SQLException var2) {
         return (LogicalTransactionId)this.postForAll(methodObject30585, this.onErrorForAll(methodObject30585, var2));
      }
   }

   public void abort(Executor arg0) throws SQLException {
      try {
         super.preForAll(methodObject30594, this, arg0);
         Method var10001 = methodObject30594;
         this.delegate.abort(arg0);
         this.postForAll(var10001);
      } catch (SQLException var3) {
         this.onErrorVoidForAll(methodObject30594, var3);
      }
   }

   public void setPlsqlWarnings(String arg0) throws SQLException {
      try {
         super.preForAll(methodObject30520, this, arg0);
         Method var10001 = methodObject30520;
         this.delegate.setPlsqlWarnings(arg0);
         this.postForAll(var10001);
      } catch (SQLException var3) {
         this.onErrorVoidForAll(methodObject30520, var3);
      }
   }

   public void registerConnectionCacheCallback(OracleConnectionCacheCallback arg0, Object arg1, int arg2) throws SQLException {
      try {
         super.preForAll(methodObject30517, this, arg0, arg1, arg2);
         Method var10001 = methodObject30517;
         this.delegate.registerConnectionCacheCallback(arg0, arg1 instanceof _Proxy_ ? (Object)((_Proxy_)arg1)._getDelegate_() : arg1, arg2);
         this.postForAll(var10001);
      } catch (SQLException var5) {
         this.onErrorVoidForAll(methodObject30517, var5);
      }
   }

   public void setCreateStatementAsRefCursor(boolean arg0) {
      super.preForAll(methodObject30505, this, arg0);
      Method var10001 = methodObject30505;
      this.delegate.setCreateStatementAsRefCursor(arg0);
      this.postForAll(var10001);
   }

   public int pingDatabase(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject30477, this, arg0);
         return (Integer)this.postForAll(methodObject30477, this.delegate.pingDatabase(arg0));
      } catch (SQLException var3) {
         return (Integer)this.postForAll(methodObject30477, this.onErrorForAll(methodObject30477, var3));
      }
   }

   public boolean isReadOnly() throws SQLException {
      try {
         super.preForAll(methodObject30593, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject30593, this.delegate.isReadOnly());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject30593, this.onErrorForAll(methodObject30593, var2));
      }
   }

   public int getDefaultRowPrefetch() {
      super.preForAll(methodObject30462, this, zeroLengthObjectArray);
      return (Integer)this.postForAll(methodObject30462, this.delegate.getDefaultRowPrefetch());
   }

   public void setWrapper(OracleConnection arg0) {
      super.preForAll(methodObject30512, this, arg0);
      Method var10001 = methodObject30512;
      this.delegate.setWrapper(arg0 instanceof _Proxy_ ? (OracleConnection)((_Proxy_)arg0)._getDelegate_() : arg0);
      this.postForAll(var10001);
   }

   public TIMESTAMPTZ createTIMESTAMPTZ(Time arg0, Calendar arg1) throws SQLException {
      try {
         super.preForAll(methodObject30560, this, arg0, arg1);
         return (TIMESTAMPTZ)this.postForAll(methodObject30560, (Object)this.delegate.createTIMESTAMPTZ(arg0, arg1));
      } catch (SQLException var4) {
         return (TIMESTAMPTZ)this.postForAll(methodObject30560, this.onErrorForAll(methodObject30560, var4));
      }
   }

   public void setSessionTimeZone(String arg0) throws SQLException {
      try {
         super.preForAll(methodObject30507, this, arg0);
         Method var10001 = methodObject30507;
         this.delegate.setSessionTimeZone(arg0);
         this.postForAll(var10001);
      } catch (SQLException var3) {
         this.onErrorVoidForAll(methodObject30507, var3);
      }
   }

   public NUMBER createNUMBER(double arg0) throws SQLException {
      try {
         super.preForAll(methodObject30548, this, arg0);
         return (NUMBER)this.postForAll(methodObject30548, (Object)this.delegate.createNUMBER(arg0));
      } catch (SQLException var4) {
         return (NUMBER)this.postForAll(methodObject30548, this.onErrorForAll(methodObject30548, var4));
      }
   }

   public String getDataIntegrityAlgorithmName() throws SQLException {
      try {
         super.preForAll(methodObject30574, this, zeroLengthObjectArray);
         return (String)this.postForAll(methodObject30574, (Object)this.delegate.getDataIntegrityAlgorithmName());
      } catch (SQLException var2) {
         return (String)this.postForAll(methodObject30574, this.onErrorForAll(methodObject30574, var2));
      }
   }

   public AQNotificationRegistration[] registerAQNotification(String[] arg0, Properties[] arg1, Properties arg2) throws SQLException {
      try {
         super.preForAll(methodObject30521, this, arg0, arg1, arg2);
         return (AQNotificationRegistration[])this.postForAll(methodObject30521, (Object)this.delegate.registerAQNotification(arg0, arg1, arg2));
      } catch (SQLException var5) {
         return (AQNotificationRegistration[])this.postForAll(methodObject30521, this.onErrorForAll(methodObject30521, var5));
      }
   }

   public void close(int arg0) throws SQLException {
      try {
         super.preForClosure(methodObject30444, this, arg0);
         Method var10001 = methodObject30444;
         this.delegate.close(arg0);
         this.postForClosure(var10001);
      } catch (SQLException var3) {
         this.onErrorVoidForAll(methodObject30444, var3);
      }
   }

   public short getEndToEndECIDSequenceNumber() throws SQLException {
      try {
         super.preForAll(methodObject30464, this, zeroLengthObjectArray);
         return (Short)this.postForAll(methodObject30464, this.delegate.getEndToEndECIDSequenceNumber());
      } catch (SQLException var2) {
         return (Short)this.postForAll(methodObject30464, this.onErrorForAll(methodObject30464, var2));
      }
   }

   public void setRestrictGetTables(boolean arg0) {
      super.preForAll(methodObject30486, this, arg0);
      Method var10001 = methodObject30486;
      this.delegate.setRestrictGetTables(arg0);
      this.postForAll(var10001);
   }

   public int getStmtCacheSize() {
      super.preForAll(methodObject30470, this, zeroLengthObjectArray);
      return (Integer)this.postForAll(methodObject30470, this.delegate.getStmtCacheSize());
   }

   public void setSchema(String arg0) throws SQLException {
      try {
         super.preForAll(methodObject30632, this, arg0);
         Method var10001 = methodObject30632;
         this.delegate.setSchema(arg0);
         this.postForAll(var10001);
      } catch (SQLException var3) {
         this.onErrorVoidForAll(methodObject30632, var3);
      }
   }

   public NUMBER createNUMBER(BigDecimal arg0) throws SQLException {
      try {
         super.preForAll(methodObject30549, this, arg0);
         return (NUMBER)this.postForAll(methodObject30549, (Object)this.delegate.createNUMBER(arg0));
      } catch (SQLException var3) {
         return (NUMBER)this.postForAll(methodObject30549, this.onErrorForAll(methodObject30549, var3));
      }
   }

   public void commit() throws SQLException {
      try {
         super.preForTxnControl(methodObject30595, this, zeroLengthObjectArray);
         Method var10001 = methodObject30595;
         this.delegate.commit();
         this.postForAll(var10001);
      } catch (SQLException var2) {
         this.onErrorVoidForAll(methodObject30595, var2);
      }
   }

   public SQLWarning getWarnings() throws SQLException {
      try {
         super.preForAll(methodObject30624, this, zeroLengthObjectArray);
         return (SQLWarning)this.postForAll(methodObject30624, (Object)this.delegate.getWarnings());
      } catch (SQLException var2) {
         return (SQLWarning)this.postForAll(methodObject30624, this.onErrorForAll(methodObject30624, var2));
      }
   }

   public void setClientInfo(Properties arg0) throws SQLClientInfoException {
      super.preForAll(methodObject30629, this, arg0);
      Method var10001 = methodObject30629;
      this.delegate.setClientInfo(arg0);
      this.postForAll(var10001);
   }

   public String getSQLType(Object arg0) throws SQLException {
      try {
         super.preForAll(methodObject30469, this, arg0);
         return (String)this.postForAll(methodObject30469, (Object)this.delegate.getSQLType(arg0 instanceof _Proxy_ ? (Object)((_Proxy_)arg0)._getDelegate_() : arg0));
      } catch (SQLException var3) {
         return (String)this.postForAll(methodObject30469, this.onErrorForAll(methodObject30469, var3));
      }
   }

   public DATE createDATE(Time arg0, Calendar arg1) throws SQLException {
      try {
         super.preForAll(methodObject30537, this, arg0, arg1);
         return (DATE)this.postForAll(methodObject30537, (Object)this.delegate.createDATE(arg0, arg1));
      } catch (SQLException var4) {
         return (DATE)this.postForAll(methodObject30537, this.onErrorForAll(methodObject30537, var4));
      }
   }

   public Connection _getPC() {
      super.preForAll(methodObject30455, this, zeroLengthObjectArray);
      return (Connection)this.postForAll(methodObject30455, (Object)this.delegate._getPC());
   }

   public void addLogicalTransactionIdEventListener(LogicalTransactionIdEventListener arg0, Executor arg1) throws SQLException {
      try {
         super.preForAll(methodObject30583, this, arg0, arg1);
         Method var10001 = methodObject30583;
         this.delegate.addLogicalTransactionIdEventListener(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject30583, var4);
      }
   }

   public DATE createDATE(Time arg0) throws SQLException {
      try {
         super.preForAll(methodObject30534, this, arg0);
         return (DATE)this.postForAll(methodObject30534, (Object)this.delegate.createDATE(arg0));
      } catch (SQLException var3) {
         return (DATE)this.postForAll(methodObject30534, this.onErrorForAll(methodObject30534, var3));
      }
   }

   public PreparedStatement prepareStatement(String arg0, String[] arg1) throws SQLException {
      try {
         super.preForAll(methodObject30618, this, arg0, arg1);
         return (PreparedStatement)this.postForAll(methodObject30618, this.proxyFactory.proxyForCreateCache((Object)this.delegate.prepareStatement(arg0, arg1), this, this.proxyCache, methodObject30618));
      } catch (SQLException var4) {
         return (PreparedStatement)this.postForAll(methodObject30618, this.onErrorForAll(methodObject30618, var4));
      }
   }

   public void close() throws SQLException {
      try {
         super.preForClosure(methodObject30591, this, zeroLengthObjectArray);
         Method var10001 = methodObject30591;
         this.delegate.close();
         this.postForClosure(var10001);
      } catch (SQLException var2) {
         this.onErrorVoidForAll(methodObject30591, var2);
      }
   }

   public void unregisterDatabaseChangeNotification(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject30529, this, arg0);
         Method var10001 = methodObject30529;
         this.delegate.unregisterDatabaseChangeNotification(arg0);
         this.postForAll(var10001);
      } catch (SQLException var3) {
         this.onErrorVoidForAll(methodObject30529, var3);
      }
   }

   public NUMBER createNUMBER(short arg0) throws SQLException {
      try {
         super.preForAll(methodObject30544, this, arg0);
         return (NUMBER)this.postForAll(methodObject30544, (Object)this.delegate.createNUMBER(arg0));
      } catch (SQLException var3) {
         return (NUMBER)this.postForAll(methodObject30544, this.onErrorForAll(methodObject30544, var3));
      }
   }

   public TypeDescriptor[] getTypeDescriptorsFromListInCurrentSchema(String[] arg0) throws SQLException {
      try {
         super.preForAll(methodObject30572, this, arg0);
         return (TypeDescriptor[])this.postForAll(methodObject30572, (Object)this.delegate.getTypeDescriptorsFromListInCurrentSchema(arg0));
      } catch (SQLException var3) {
         return (TypeDescriptor[])this.postForAll(methodObject30572, this.onErrorForAll(methodObject30572, var3));
      }
   }

   public DatabaseChangeRegistration registerDatabaseChangeNotification(Properties arg0) throws SQLException {
      try {
         super.preForAll(methodObject30525, this, arg0);
         return (DatabaseChangeRegistration)this.postForAll(methodObject30525, (Object)this.delegate.registerDatabaseChangeNotification(arg0));
      } catch (SQLException var3) {
         return (DatabaseChangeRegistration)this.postForAll(methodObject30525, this.onErrorForAll(methodObject30525, var3));
      }
   }

   public DATE createDATE(String arg0) throws SQLException {
      try {
         super.preForAll(methodObject30539, this, arg0);
         return (DATE)this.postForAll(methodObject30539, (Object)this.delegate.createDATE(arg0));
      } catch (SQLException var3) {
         return (DATE)this.postForAll(methodObject30539, this.onErrorForAll(methodObject30539, var3));
      }
   }

   public Clob createClob() throws SQLException {
      try {
         super.preForAll(methodObject30604, this, zeroLengthObjectArray);
         return (Clob)this.postForAll(methodObject30604, this.proxyFactory.proxyForCreateCache((Object)this.delegate.createClob(), this, this.proxyCache, methodObject30604));
      } catch (SQLException var2) {
         return (Clob)this.postForAll(methodObject30604, this.onErrorForAll(methodObject30604, var2));
      }
   }

   public void setImplicitCachingEnabled(boolean arg0) throws SQLException {
      try {
         super.preForAll(methodObject30491, this, arg0);
         Method var10001 = methodObject30491;
         this.delegate.setImplicitCachingEnabled(arg0);
         this.postForAll(var10001);
      } catch (SQLException var3) {
         this.onErrorVoidForAll(methodObject30491, var3);
      }
   }

   public TIMESTAMPLTZ createTIMESTAMPLTZ(DATE arg0, Calendar arg1) throws SQLException {
      try {
         super.preForAll(methodObject30570, this, arg0, arg1);
         return (TIMESTAMPLTZ)this.postForAll(methodObject30570, (Object)this.delegate.createTIMESTAMPLTZ(arg0, arg1));
      } catch (SQLException var4) {
         return (TIMESTAMPLTZ)this.postForAll(methodObject30570, this.onErrorForAll(methodObject30570, var4));
      }
   }

   public AQMessage dequeue(String arg0, AQDequeueOptions arg1, byte[] arg2) throws SQLException {
      try {
         super.preForAll(methodObject30523, this, arg0, arg1, arg2);
         return (AQMessage)this.postForAll(methodObject30523, (Object)this.delegate.dequeue(arg0, arg1, arg2));
      } catch (SQLException var5) {
         return (AQMessage)this.postForAll(methodObject30523, this.onErrorForAll(methodObject30523, var5));
      }
   }

   public void abort() throws SQLException {
      try {
         super.preForClosure(methodObject30446, this, zeroLengthObjectArray);
         Method var10001 = methodObject30446;
         this.delegate.abort();
         this.postForClosure(var10001);
      } catch (SQLException var2) {
         this.onErrorVoidForAll(methodObject30446, var2);
      }
   }

   public String getAuthenticationAdaptorName() throws SQLException {
      try {
         super.preForAll(methodObject30576, this, zeroLengthObjectArray);
         return (String)this.postForAll(methodObject30576, (Object)this.delegate.getAuthenticationAdaptorName());
      } catch (SQLException var2) {
         return (String)this.postForAll(methodObject30576, this.onErrorForAll(methodObject30576, var2));
      }
   }

   public Properties getConnectionAttributes() throws SQLException {
      try {
         super.preForAll(methodObject30515, this, zeroLengthObjectArray);
         return (Properties)this.postForAll(methodObject30515, (Object)this.delegate.getConnectionAttributes());
      } catch (SQLException var2) {
         return (Properties)this.postForAll(methodObject30515, this.onErrorForAll(methodObject30515, var2));
      }
   }

   public NUMBER createNUMBER(String arg0, int arg1) throws SQLException {
      try {
         super.preForAll(methodObject30551, this, arg0, arg1);
         return (NUMBER)this.postForAll(methodObject30551, (Object)this.delegate.createNUMBER(arg0, arg1));
      } catch (SQLException var4) {
         return (NUMBER)this.postForAll(methodObject30551, this.onErrorForAll(methodObject30551, var4));
      }
   }

   public Statement createStatement(int arg0, int arg1, int arg2) throws SQLException {
      try {
         super.preForAll(methodObject30609, this, arg0, arg1, arg2);
         return (Statement)this.postForAll(methodObject30609, this.proxyFactory.proxyForCreateCache((Object)this.delegate.createStatement(arg0, arg1, arg2), this, this.proxyCache, methodObject30609));
      } catch (SQLException var5) {
         return (Statement)this.postForAll(methodObject30609, this.onErrorForAll(methodObject30609, var5));
      }
   }

   public PreparedStatement prepareStatement(String arg0, int[] arg1) throws SQLException {
      try {
         super.preForAll(methodObject30617, this, arg0, arg1);
         return (PreparedStatement)this.postForAll(methodObject30617, this.proxyFactory.proxyForCreateCache((Object)this.delegate.prepareStatement(arg0, arg1), this, this.proxyCache, methodObject30617));
      } catch (SQLException var4) {
         return (PreparedStatement)this.postForAll(methodObject30617, this.onErrorForAll(methodObject30617, var4));
      }
   }

   public String getCatalog() throws SQLException {
      try {
         super.preForAll(methodObject30619, this, zeroLengthObjectArray);
         return (String)this.postForAll(methodObject30619, (Object)this.delegate.getCatalog());
      } catch (SQLException var2) {
         return (String)this.postForAll(methodObject30619, this.onErrorForAll(methodObject30619, var2));
      }
   }

   public BINARY_FLOAT createBINARY_FLOAT(float arg0) throws SQLException {
      try {
         super.preForAll(methodObject30532, this, arg0);
         return (BINARY_FLOAT)this.postForAll(methodObject30532, (Object)this.delegate.createBINARY_FLOAT(arg0));
      } catch (SQLException var3) {
         return (BINARY_FLOAT)this.postForAll(methodObject30532, this.onErrorForAll(methodObject30532, var3));
      }
   }

   public boolean getExplicitCachingEnabled() throws SQLException {
      try {
         super.preForAll(methodObject30494, this, zeroLengthObjectArray);
         return (Boolean)this.postForAll(methodObject30494, this.delegate.getExplicitCachingEnabled());
      } catch (SQLException var2) {
         return (Boolean)this.postForAll(methodObject30494, this.onErrorForAll(methodObject30494, var2));
      }
   }

   public String getCurrentSchema() throws SQLException {
      try {
         super.preForAll(methodObject30473, this, zeroLengthObjectArray);
         return (String)this.postForAll(methodObject30473, (Object)this.delegate.getCurrentSchema());
      } catch (SQLException var2) {
         return (String)this.postForAll(methodObject30473, this.onErrorForAll(methodObject30473, var2));
      }
   }

   public void removeLogicalTransactionIdEventListener(LogicalTransactionIdEventListener arg0) throws SQLException {
      try {
         super.preForAll(methodObject30584, this, arg0);
         Method var10001 = methodObject30584;
         this.delegate.removeLogicalTransactionIdEventListener(arg0);
         this.postForAll(var10001);
      } catch (SQLException var3) {
         this.onErrorVoidForAll(methodObject30584, var3);
      }
   }

   public void putDescriptor(String arg0, Object arg1) throws SQLException {
      try {
         super.preForAll(methodObject30456, this, arg0, arg1);
         Method var10001 = methodObject30456;
         this.delegate.putDescriptor(arg0, arg1 instanceof _Proxy_ ? (Object)((_Proxy_)arg1)._getDelegate_() : arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject30456, var4);
      }
   }

   public OracleSavepoint oracleSetSavepoint() throws SQLException {
      try {
         super.preForTxnControl(methodObject30449, this, zeroLengthObjectArray);
         return (OracleSavepoint)this.postForAll(methodObject30449, this.proxyFactory.proxyForCreate((Object)this.delegate.oracleSetSavepoint(), this, this.proxyCache, methodObject30449));
      } catch (SQLException var2) {
         return (OracleSavepoint)this.postForAll(methodObject30449, this.onErrorForAll(methodObject30449, var2));
      }
   }

   public INTERVALYM createINTERVALYM(String arg0) throws SQLException {
      try {
         super.preForAll(methodObject30541, this, arg0);
         return (INTERVALYM)this.postForAll(methodObject30541, (Object)this.delegate.createINTERVALYM(arg0));
      } catch (SQLException var3) {
         return (INTERVALYM)this.postForAll(methodObject30541, this.onErrorForAll(methodObject30541, var3));
      }
   }

   public void detachServerConnection(String arg0) throws SQLException {
      try {
         super.preForAll(methodObject30588, this, arg0);
         Method var10001 = methodObject30588;
         this.delegate.detachServerConnection(arg0);
         this.postForAll(var10001);
      } catch (SQLException var3) {
         this.onErrorVoidForAll(methodObject30588, var3);
      }
   }

   public Blob createBlob() throws SQLException {
      try {
         super.preForAll(methodObject30603, this, zeroLengthObjectArray);
         return (Blob)this.postForAll(methodObject30603, this.proxyFactory.proxyForCreateCache((Object)this.delegate.createBlob(), this, this.proxyCache, methodObject30603));
      } catch (SQLException var2) {
         return (Blob)this.postForAll(methodObject30603, this.onErrorForAll(methodObject30603, var2));
      }
   }

   public boolean isWrapperFor(Class arg0) throws SQLException {
      try {
         super.preForAll(methodObject30643, this, arg0);
         return (Boolean)this.postForAll(methodObject30643, this.delegate.isWrapperFor(arg0));
      } catch (SQLException var3) {
         return (Boolean)this.postForAll(methodObject30643, this.onErrorForAll(methodObject30643, var3));
      }
   }

   public void releaseSavepoint(Savepoint arg0) throws SQLException {
      try {
         super.preForTxnControl(methodObject30600, this, arg0);
         Method var10001 = methodObject30600;
         this.delegate.releaseSavepoint(arg0 instanceof _Proxy_ ? (Savepoint)((_Proxy_)arg0)._getDelegate_() : arg0);
         this.postForAll(var10001);
      } catch (SQLException var3) {
         this.onErrorVoidForAll(methodObject30600, var3);
      }
   }

   public void setIncludeSynonyms(boolean arg0) {
      super.preForAll(methodObject30484, this, arg0);
      Method var10001 = methodObject30484;
      this.delegate.setIncludeSynonyms(arg0);
      this.postForAll(var10001);
   }

   public String getSessionTimeZone() {
      super.preForAll(methodObject30508, this, zeroLengthObjectArray);
      return (String)this.postForAll(methodObject30508, (Object)this.delegate.getSessionTimeZone());
   }

   public boolean isUsable() {
      super.preForAll(methodObject30577, this, zeroLengthObjectArray);
      return (Boolean)this.postForAll(methodObject30577, this.delegate.isUsable());
   }

   public DATE createDATE(Date arg0, Calendar arg1) throws SQLException {
      try {
         super.preForAll(methodObject30536, this, arg0, arg1);
         return (DATE)this.postForAll(methodObject30536, (Object)this.delegate.createDATE(arg0, arg1));
      } catch (SQLException var4) {
         return (DATE)this.postForAll(methodObject30536, this.onErrorForAll(methodObject30536, var4));
      }
   }

   public TIMESTAMPTZ createTIMESTAMPTZ(String arg0, Calendar arg1) throws SQLException {
      try {
         super.preForAll(methodObject30564, this, arg0, arg1);
         return (TIMESTAMPTZ)this.postForAll(methodObject30564, (Object)this.delegate.createTIMESTAMPTZ(arg0, arg1));
      } catch (SQLException var4) {
         return (TIMESTAMPTZ)this.postForAll(methodObject30564, this.onErrorForAll(methodObject30564, var4));
      }
   }

   public TypeDescriptor[] getTypeDescriptorsFromList(String[][] arg0) throws SQLException {
      try {
         super.preForAll(methodObject30573, this, arg0);
         return (TypeDescriptor[])this.postForAll(methodObject30573, (Object)this.delegate.getTypeDescriptorsFromList(arg0));
      } catch (SQLException var3) {
         return (TypeDescriptor[])this.postForAll(methodObject30573, this.onErrorForAll(methodObject30573, var3));
      }
   }

   public void setTransactionIsolation(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject30633, this, arg0);
         Method var10001 = methodObject30633;
         this.delegate.setTransactionIsolation(arg0);
         this.postForAll(var10001);
      } catch (SQLException var3) {
         this.onErrorVoidForAll(methodObject30633, var3);
      }
   }

   public void setConnectionReleasePriority(int arg0) throws SQLException {
      try {
         super.preForAll(methodObject30518, this, arg0);
         Method var10001 = methodObject30518;
         this.delegate.setConnectionReleasePriority(arg0);
         this.postForAll(var10001);
      } catch (SQLException var3) {
         this.onErrorVoidForAll(methodObject30518, var3);
      }
   }

   public void setNetworkTimeout(Executor arg0, int arg1) throws SQLException {
      try {
         super.preForAll(methodObject30631, this, arg0, arg1);
         Method var10001 = methodObject30631;
         this.delegate.setNetworkTimeout(arg0, arg1);
         this.postForAll(var10001);
      } catch (SQLException var4) {
         this.onErrorVoidForAll(methodObject30631, var4);
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
         methodObject30483 = OracleConnection.class.getDeclaredMethod("setEndToEndMetrics", String[].class, Short.TYPE);
         methodObject30440 = OracleConnection.class.getDeclaredMethod("getDescriptor", String.class);
         methodObject30487 = OracleConnection.class.getDeclaredMethod("setStmtCacheSize", Integer.TYPE);
         methodObject30627 = Connection.class.getDeclaredMethod("setCatalog", String.class);
         methodObject30531 = OracleConnection.class.getDeclaredMethod("createBINARY_DOUBLE", Double.TYPE);
         methodObject30542 = OracleConnection.class.getDeclaredMethod("createNUMBER", Boolean.TYPE);
         methodObject30628 = Connection.class.getDeclaredMethod("setClientInfo", String.class, String.class);
         methodObject30598 = Connection.class.getDeclaredMethod("setSavepoint");
         methodObject30460 = OracleConnection.class.getDeclaredMethod("getAutoClose");
         methodObject30445 = OracleConnection.class.getDeclaredMethod("unwrap");
         methodObject30641 = Connection.class.getDeclaredMethod("getTransactionIsolation");
         methodObject30510 = OracleConnection.class.getDeclaredMethod("isLogicalConnection");
         methodObject30530 = OracleConnection.class.getDeclaredMethod("unregisterDatabaseChangeNotification", Long.TYPE, String.class);
         methodObject30504 = OracleConnection.class.getDeclaredMethod("prepareCallWithKey", String.class);
         methodObject30448 = OracleConnection.class.getDeclaredMethod("oracleRollback", OracleSavepoint.class);
         methodObject30482 = OracleConnection.class.getDeclaredMethod("setDefaultRowPrefetch", Integer.TYPE);
         methodObject30447 = OracleConnection.class.getDeclaredMethod("commit", EnumSet.class);
         methodObject30556 = OracleConnection.class.getDeclaredMethod("createTIMESTAMP", String.class);
         methodObject30503 = OracleConnection.class.getDeclaredMethod("prepareStatementWithKey", String.class);
         methodObject30606 = Connection.class.getDeclaredMethod("createSQLXML");
         methodObject30543 = OracleConnection.class.getDeclaredMethod("createNUMBER", Byte.TYPE);
         methodObject30575 = OracleConnection.class.getDeclaredMethod("getEncryptionAlgorithmName");
         methodObject30571 = OracleConnection.class.getDeclaredMethod("getAllTypeDescriptorsInCurrentSchema");
         methodObject30478 = OracleConnection.class.getDeclaredMethod("registerSQLType", String.class, Class.class);
         methodObject30599 = Connection.class.getDeclaredMethod("setSavepoint", String.class);
         methodObject30634 = Connection.class.getDeclaredMethod("setTypeMap", Map.class);
         methodObject30555 = OracleConnection.class.getDeclaredMethod("createTIMESTAMP", Timestamp.class);
         methodObject30509 = OracleConnection.class.getDeclaredMethod("getSessionTimeZoneOffset");
         methodObject30639 = Connection.class.getDeclaredMethod("getClientInfo");
         methodObject30474 = OracleConnection.class.getDeclaredMethod("getUsingXAFlag");
         methodObject30610 = Connection.class.getDeclaredMethod("prepareCall", String.class);
         methodObject30626 = Connection.class.getDeclaredMethod("setAutoCommit", Boolean.TYPE);
         methodObject30457 = OracleConnection.class.getDeclaredMethod("physicalConnectionWithin");
         methodObject30636 = Connection.class.getDeclaredMethod("clearWarnings");
         methodObject30589 = OracleConnection.class.getDeclaredMethod("needToPurgeStatementCache");
         methodObject30547 = OracleConnection.class.getDeclaredMethod("createNUMBER", Float.TYPE);
         methodObject30580 = OracleConnection.class.getDeclaredMethod("setApplicationContext", String.class, String.class, String.class);
         methodObject30522 = OracleConnection.class.getDeclaredMethod("unregisterAQNotification", AQNotificationRegistration.class);
         methodObject30607 = Connection.class.getDeclaredMethod("createStatement");
         methodObject30488 = OracleConnection.class.getDeclaredMethod("setStmtCacheSize", Integer.TYPE, Boolean.TYPE);
         methodObject30622 = Connection.class.getDeclaredMethod("getMetaData");
         methodObject30535 = OracleConnection.class.getDeclaredMethod("createDATE", Timestamp.class);
         methodObject30550 = OracleConnection.class.getDeclaredMethod("createNUMBER", BigInteger.class);
         methodObject30552 = OracleConnection.class.getDeclaredMethod("createTIMESTAMP", Date.class);
         methodObject30498 = OracleConnection.class.getDeclaredMethod("getCallWithKey", String.class);
         methodObject30620 = Connection.class.getDeclaredMethod("isClosed");
         methodObject30608 = Connection.class.getDeclaredMethod("createStatement", Integer.TYPE, Integer.TYPE);
         methodObject30621 = Connection.class.getDeclaredMethod("getSchema");
         methodObject30545 = OracleConnection.class.getDeclaredMethod("createNUMBER", Integer.TYPE);
         methodObject30471 = OracleConnection.class.getDeclaredMethod("getStructAttrCsId");
         methodObject30466 = OracleConnection.class.getDeclaredMethod("getRestrictGetTables");
         methodObject30516 = OracleConnection.class.getDeclaredMethod("getUnMatchedConnectionAttributes");
         methodObject30528 = OracleConnection.class.getDeclaredMethod("unregisterDatabaseChangeNotification", Integer.TYPE, String.class, Integer.TYPE);
         methodObject30546 = OracleConnection.class.getDeclaredMethod("createNUMBER", Long.TYPE);
         methodObject30527 = OracleConnection.class.getDeclaredMethod("unregisterDatabaseChangeNotification", DatabaseChangeRegistration.class);
         methodObject30514 = OracleConnection.class.getDeclaredMethod("applyConnectionAttributes", Properties.class);
         methodObject30611 = Connection.class.getDeclaredMethod("prepareCall", String.class, Integer.TYPE, Integer.TYPE);
         methodObject30496 = OracleConnection.class.getDeclaredMethod("purgeExplicitCache");
         methodObject30492 = OracleConnection.class.getDeclaredMethod("getImplicitCachingEnabled");
         methodObject30489 = OracleConnection.class.getDeclaredMethod("setStatementCacheSize", Integer.TYPE);
         methodObject30439 = OracleConnection.class.getDeclaredMethod("shutdown", OracleConnection.DatabaseShutdownMode.class);
         methodObject30578 = OracleConnection.class.getDeclaredMethod("setDefaultTimeZone", TimeZone.class);
         methodObject30495 = OracleConnection.class.getDeclaredMethod("purgeImplicitCache");
         methodObject30558 = OracleConnection.class.getDeclaredMethod("createTIMESTAMPTZ", Date.class, Calendar.class);
         methodObject30557 = OracleConnection.class.getDeclaredMethod("createTIMESTAMPTZ", Date.class);
         methodObject30563 = OracleConnection.class.getDeclaredMethod("createTIMESTAMPTZ", String.class);
         methodObject30568 = OracleConnection.class.getDeclaredMethod("createTIMESTAMPLTZ", Timestamp.class, Calendar.class);
         methodObject30561 = OracleConnection.class.getDeclaredMethod("createTIMESTAMPTZ", Timestamp.class);
         methodObject30614 = Connection.class.getDeclaredMethod("prepareStatement", String.class, Integer.TYPE, Integer.TYPE);
         methodObject30501 = OracleConnection.class.getDeclaredMethod("startup", String.class, Integer.TYPE);
         methodObject30497 = OracleConnection.class.getDeclaredMethod("getStatementWithKey", String.class);
         methodObject30441 = OracleConnection.class.getDeclaredMethod("getProperties");
         methodObject30533 = OracleConnection.class.getDeclaredMethod("createDATE", Date.class);
         methodObject30553 = OracleConnection.class.getDeclaredMethod("createTIMESTAMP", DATE.class);
         methodObject30559 = OracleConnection.class.getDeclaredMethod("createTIMESTAMPTZ", Time.class);
         methodObject30635 = Connection.class.getDeclaredMethod("getNetworkTimeout");
         methodObject30587 = OracleConnection.class.getDeclaredMethod("attachServerConnection");
         methodObject30615 = Connection.class.getDeclaredMethod("prepareStatement", String.class, Integer.TYPE, Integer.TYPE, Integer.TYPE);
         methodObject30565 = OracleConnection.class.getDeclaredMethod("createTIMESTAMPTZ", DATE.class);
         methodObject30582 = OracleConnection.class.getDeclaredMethod("addLogicalTransactionIdEventListener", LogicalTransactionIdEventListener.class);
         methodObject30493 = OracleConnection.class.getDeclaredMethod("setExplicitCachingEnabled", Boolean.TYPE);
         methodObject30506 = OracleConnection.class.getDeclaredMethod("getCreateStatementAsRefCursor");
         methodObject30592 = Connection.class.getDeclaredMethod("isValid", Integer.TYPE);
         methodObject30581 = OracleConnection.class.getDeclaredMethod("clearAllApplicationContext", String.class);
         methodObject30625 = Connection.class.getDeclaredMethod("nativeSQL", String.class);
         methodObject30612 = Connection.class.getDeclaredMethod("prepareCall", String.class, Integer.TYPE, Integer.TYPE, Integer.TYPE);
         methodObject30538 = OracleConnection.class.getDeclaredMethod("createDATE", Timestamp.class, Calendar.class);
         methodObject30642 = Wrapper.class.getDeclaredMethod("unwrap", Class.class);
         methodObject30526 = OracleConnection.class.getDeclaredMethod("getDatabaseChangeRegistration", Integer.TYPE);
         methodObject30630 = Connection.class.getDeclaredMethod("setHoldability", Integer.TYPE);
         methodObject30480 = OracleConnection.class.getDeclaredMethod("setAutoClose", Boolean.TYPE);
         methodObject30638 = Connection.class.getDeclaredMethod("getClientInfo", String.class);
         methodObject30479 = OracleConnection.class.getDeclaredMethod("registerSQLType", String.class, String.class);
         methodObject30459 = OracleConnection.class.getDeclaredMethod("openProxySession", Integer.TYPE, Properties.class);
         methodObject30554 = OracleConnection.class.getDeclaredMethod("createTIMESTAMP", Time.class);
         methodObject30490 = OracleConnection.class.getDeclaredMethod("getStatementCacheSize");
         methodObject30623 = Connection.class.getDeclaredMethod("getTypeMap");
         methodObject30451 = OracleConnection.class.getDeclaredMethod("oracleReleaseSavepoint", OracleSavepoint.class);
         methodObject30524 = OracleConnection.class.getDeclaredMethod("dequeue", String.class, AQDequeueOptions.class, String.class);
         methodObject30452 = OracleConnection.class.getDeclaredMethod("cancel");
         methodObject30463 = OracleConnection.class.getDeclaredMethod("getEndToEndMetrics");
         methodObject30443 = OracleConnection.class.getDeclaredMethod("close", Properties.class);
         methodObject30590 = Connection.class.getDeclaredMethod("setReadOnly", Boolean.TYPE);
         methodObject30613 = Connection.class.getDeclaredMethod("prepareStatement", String.class);
         methodObject30616 = Connection.class.getDeclaredMethod("prepareStatement", String.class, Integer.TYPE);
         methodObject30540 = OracleConnection.class.getDeclaredMethod("createINTERVALDS", String.class);
         methodObject30579 = OracleConnection.class.getDeclaredMethod("getDefaultTimeZone");
         methodObject30586 = OracleConnection.class.getDeclaredMethod("isDRCPEnabled");
         methodObject30468 = OracleConnection.class.getDeclaredMethod("getRemarksReporting");
         methodObject30485 = OracleConnection.class.getDeclaredMethod("setRemarksReporting", Boolean.TYPE);
         methodObject30476 = OracleConnection.class.getDeclaredMethod("pingDatabase");
         methodObject30569 = OracleConnection.class.getDeclaredMethod("createTIMESTAMPLTZ", String.class, Calendar.class);
         methodObject30519 = OracleConnection.class.getDeclaredMethod("getConnectionReleasePriority");
         methodObject30475 = OracleConnection.class.getDeclaredMethod("getXAErrorFlag");
         methodObject30602 = Connection.class.getDeclaredMethod("createStruct", String.class, Object[].class);
         methodObject30472 = OracleConnection.class.getDeclaredMethod("getUserName");
         methodObject30481 = OracleConnection.class.getDeclaredMethod("setDefaultExecuteBatch", Integer.TYPE);
         methodObject30567 = OracleConnection.class.getDeclaredMethod("createTIMESTAMPLTZ", Time.class, Calendar.class);
         methodObject30467 = OracleConnection.class.getDeclaredMethod("getJavaObject", String.class);
         methodObject30513 = OracleConnection.class.getDeclaredMethod("isProxySession");
         methodObject30605 = Connection.class.getDeclaredMethod("createNClob");
         methodObject30637 = Connection.class.getDeclaredMethod("getAutoCommit");
         methodObject30597 = Connection.class.getDeclaredMethod("rollback", Savepoint.class);
         methodObject30502 = OracleConnection.class.getDeclaredMethod("startup", OracleConnection.DatabaseStartupMode.class);
         methodObject30640 = Connection.class.getDeclaredMethod("getHoldability");
         methodObject30562 = OracleConnection.class.getDeclaredMethod("createTIMESTAMPTZ", Timestamp.class, Calendar.class);
         methodObject30511 = OracleConnection.class.getDeclaredMethod("registerTAFCallback", OracleOCIFailover.class, Object.class);
         methodObject30442 = OracleConnection.class.getDeclaredMethod("enqueue", String.class, AQEnqueueOptions.class, AQMessage.class);
         methodObject30596 = Connection.class.getDeclaredMethod("rollback");
         methodObject30454 = OracleConnection.class.getDeclaredMethod("createOracleArray", String.class, Object.class);
         methodObject30499 = OracleConnection.class.getDeclaredMethod("setUsingXAFlag", Boolean.TYPE);
         methodObject30453 = OracleConnection.class.getDeclaredMethod("createARRAY", String.class, Object.class);
         methodObject30465 = OracleConnection.class.getDeclaredMethod("getIncludeSynonyms");
         methodObject30601 = Connection.class.getDeclaredMethod("createArrayOf", String.class, Object[].class);
         methodObject30500 = OracleConnection.class.getDeclaredMethod("setXAErrorFlag", Boolean.TYPE);
         methodObject30450 = OracleConnection.class.getDeclaredMethod("oracleSetSavepoint", String.class);
         methodObject30461 = OracleConnection.class.getDeclaredMethod("getDefaultExecuteBatch");
         methodObject30566 = OracleConnection.class.getDeclaredMethod("createTIMESTAMPLTZ", Date.class, Calendar.class);
         methodObject30458 = OracleConnection.class.getDeclaredMethod("archive", Integer.TYPE, Integer.TYPE, String.class);
         methodObject30585 = OracleConnection.class.getDeclaredMethod("getLogicalTransactionId");
         methodObject30594 = Connection.class.getDeclaredMethod("abort", Executor.class);
         methodObject30520 = OracleConnection.class.getDeclaredMethod("setPlsqlWarnings", String.class);
         methodObject30517 = OracleConnection.class.getDeclaredMethod("registerConnectionCacheCallback", OracleConnectionCacheCallback.class, Object.class, Integer.TYPE);
         methodObject30505 = OracleConnection.class.getDeclaredMethod("setCreateStatementAsRefCursor", Boolean.TYPE);
         methodObject30477 = OracleConnection.class.getDeclaredMethod("pingDatabase", Integer.TYPE);
         methodObject30593 = Connection.class.getDeclaredMethod("isReadOnly");
         methodObject30462 = OracleConnection.class.getDeclaredMethod("getDefaultRowPrefetch");
         methodObject30512 = OracleConnection.class.getDeclaredMethod("setWrapper", OracleConnection.class);
         methodObject30560 = OracleConnection.class.getDeclaredMethod("createTIMESTAMPTZ", Time.class, Calendar.class);
         methodObject30507 = OracleConnection.class.getDeclaredMethod("setSessionTimeZone", String.class);
         methodObject30548 = OracleConnection.class.getDeclaredMethod("createNUMBER", Double.TYPE);
         methodObject30574 = OracleConnection.class.getDeclaredMethod("getDataIntegrityAlgorithmName");
         methodObject30521 = OracleConnection.class.getDeclaredMethod("registerAQNotification", String[].class, Properties[].class, Properties.class);
         methodObject30444 = OracleConnection.class.getDeclaredMethod("close", Integer.TYPE);
         methodObject30464 = OracleConnection.class.getDeclaredMethod("getEndToEndECIDSequenceNumber");
         methodObject30486 = OracleConnection.class.getDeclaredMethod("setRestrictGetTables", Boolean.TYPE);
         methodObject30470 = OracleConnection.class.getDeclaredMethod("getStmtCacheSize");
         methodObject30632 = Connection.class.getDeclaredMethod("setSchema", String.class);
         methodObject30549 = OracleConnection.class.getDeclaredMethod("createNUMBER", BigDecimal.class);
         methodObject30595 = Connection.class.getDeclaredMethod("commit");
         methodObject30624 = Connection.class.getDeclaredMethod("getWarnings");
         methodObject30629 = Connection.class.getDeclaredMethod("setClientInfo", Properties.class);
         methodObject30469 = OracleConnection.class.getDeclaredMethod("getSQLType", Object.class);
         methodObject30537 = OracleConnection.class.getDeclaredMethod("createDATE", Time.class, Calendar.class);
         methodObject30455 = OracleConnection.class.getDeclaredMethod("_getPC");
         methodObject30583 = OracleConnection.class.getDeclaredMethod("addLogicalTransactionIdEventListener", LogicalTransactionIdEventListener.class, Executor.class);
         methodObject30534 = OracleConnection.class.getDeclaredMethod("createDATE", Time.class);
         methodObject30618 = Connection.class.getDeclaredMethod("prepareStatement", String.class, String[].class);
         methodObject30591 = Connection.class.getDeclaredMethod("close");
         methodObject30529 = OracleConnection.class.getDeclaredMethod("unregisterDatabaseChangeNotification", Integer.TYPE);
         methodObject30544 = OracleConnection.class.getDeclaredMethod("createNUMBER", Short.TYPE);
         methodObject30572 = OracleConnection.class.getDeclaredMethod("getTypeDescriptorsFromListInCurrentSchema", String[].class);
         methodObject30525 = OracleConnection.class.getDeclaredMethod("registerDatabaseChangeNotification", Properties.class);
         methodObject30539 = OracleConnection.class.getDeclaredMethod("createDATE", String.class);
         methodObject30604 = Connection.class.getDeclaredMethod("createClob");
         methodObject30491 = OracleConnection.class.getDeclaredMethod("setImplicitCachingEnabled", Boolean.TYPE);
         methodObject30570 = OracleConnection.class.getDeclaredMethod("createTIMESTAMPLTZ", DATE.class, Calendar.class);
         methodObject30523 = OracleConnection.class.getDeclaredMethod("dequeue", String.class, AQDequeueOptions.class, byte[].class);
         methodObject30446 = OracleConnection.class.getDeclaredMethod("abort");
         methodObject30576 = OracleConnection.class.getDeclaredMethod("getAuthenticationAdaptorName");
         methodObject30515 = OracleConnection.class.getDeclaredMethod("getConnectionAttributes");
         methodObject30551 = OracleConnection.class.getDeclaredMethod("createNUMBER", String.class, Integer.TYPE);
         methodObject30609 = Connection.class.getDeclaredMethod("createStatement", Integer.TYPE, Integer.TYPE, Integer.TYPE);
         methodObject30617 = Connection.class.getDeclaredMethod("prepareStatement", String.class, int[].class);
         methodObject30619 = Connection.class.getDeclaredMethod("getCatalog");
         methodObject30532 = OracleConnection.class.getDeclaredMethod("createBINARY_FLOAT", Float.TYPE);
         methodObject30494 = OracleConnection.class.getDeclaredMethod("getExplicitCachingEnabled");
         methodObject30473 = OracleConnection.class.getDeclaredMethod("getCurrentSchema");
         methodObject30584 = OracleConnection.class.getDeclaredMethod("removeLogicalTransactionIdEventListener", LogicalTransactionIdEventListener.class);
         methodObject30456 = OracleConnection.class.getDeclaredMethod("putDescriptor", String.class, Object.class);
         methodObject30449 = OracleConnection.class.getDeclaredMethod("oracleSetSavepoint");
         methodObject30541 = OracleConnection.class.getDeclaredMethod("createINTERVALYM", String.class);
         methodObject30588 = OracleConnection.class.getDeclaredMethod("detachServerConnection", String.class);
         methodObject30603 = Connection.class.getDeclaredMethod("createBlob");
         methodObject30643 = Wrapper.class.getDeclaredMethod("isWrapperFor", Class.class);
         methodObject30600 = Connection.class.getDeclaredMethod("releaseSavepoint", Savepoint.class);
         methodObject30484 = OracleConnection.class.getDeclaredMethod("setIncludeSynonyms", Boolean.TYPE);
         methodObject30508 = OracleConnection.class.getDeclaredMethod("getSessionTimeZone");
         methodObject30577 = OracleConnection.class.getDeclaredMethod("isUsable");
         methodObject30536 = OracleConnection.class.getDeclaredMethod("createDATE", Date.class, Calendar.class);
         methodObject30564 = OracleConnection.class.getDeclaredMethod("createTIMESTAMPTZ", String.class, Calendar.class);
         methodObject30573 = OracleConnection.class.getDeclaredMethod("getTypeDescriptorsFromList", String[][].class);
         methodObject30633 = Connection.class.getDeclaredMethod("setTransactionIsolation", Integer.TYPE);
         methodObject30518 = OracleConnection.class.getDeclaredMethod("setConnectionReleasePriority", Integer.TYPE);
         methodObject30631 = Connection.class.getDeclaredMethod("setNetworkTimeout", Executor.class, Integer.TYPE);
      } catch (Throwable var1) {
         throw new RuntimeException(var1);
      }
   }

   public oracle$1jdbc$1replay$1driver$1NonTxnReplayableConnection$2oracle$1jdbc$1OracleConnection$$$Proxy(OracleConnection var1, Object var2, ProxyFactory var3, Map var4) {
      this.delegate = var1;
      this.creator = var2;
      this.proxyFactory = var3;
      this.proxyCache = var4;
   }
}
