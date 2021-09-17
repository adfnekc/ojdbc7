//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package oracle.jdbc;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
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
import java.util.Calendar;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.TimeZone;
import java.util.concurrent.Executor;
import oracle.jdbc.OracleConnection.CommitOption;
import oracle.jdbc.OracleConnection.DatabaseShutdownMode;
import oracle.jdbc.OracleConnection.DatabaseStartupMode;
import oracle.jdbc.aq.AQDequeueOptions;
import oracle.jdbc.aq.AQEnqueueOptions;
import oracle.jdbc.aq.AQMessage;
import oracle.jdbc.aq.AQNotificationRegistration;
import oracle.jdbc.dcn.DatabaseChangeRegistration;
import oracle.jdbc.driver.DatabaseError;
import oracle.jdbc.pool.OracleConnectionCacheCallback;
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

public class OracleConnectionWrapper implements OracleConnection {
    protected OracleConnection connection;
    private Map<Class, Object> proxies = new HashMap(3);
    private static Map<Class, Class> proxyClasses = new HashMap();
    private static final String _Copyright_2007_Oracle_All_Rights_Reserved_ = null;
    public static final String BUILD_DATE = "Thu_Apr_04_15:09:24_PDT_2013";
    public static final boolean TRACE = false;

    public OracleConnectionWrapper() {
    }

    public OracleConnectionWrapper(OracleConnection var1) {
        this.connection = var1;
        var1.setWrapper(this);
    }

    public OracleConnection unwrap() {
        return this.connection;
    }

    public oracle.jdbc.internal.OracleConnection physicalConnectionWithin() {
        return this.connection.physicalConnectionWithin();
    }

    public String getDatabaseTimeZone() throws SQLException {
        return this.physicalConnectionWithin().getDatabaseTimeZone();
    }

    public void setWrapper(OracleConnection var1) {
        this.connection.setWrapper(var1);
    }

    public Statement createStatement() throws SQLException {
        return this.connection.createStatement();
    }

    public PreparedStatement prepareStatement(String var1) throws SQLException {
        return this.connection.prepareStatement(var1);
    }

    public CallableStatement prepareCall(String var1) throws SQLException {
        return this.connection.prepareCall(var1);
    }

    public String nativeSQL(String var1) throws SQLException {
        return this.connection.nativeSQL(var1);
    }

    public void setAutoCommit(boolean var1) throws SQLException {
        this.connection.setAutoCommit(var1);
    }

    public boolean getAutoCommit() throws SQLException {
        return this.connection.getAutoCommit();
    }

    public void commit() throws SQLException {
        this.connection.commit();
    }

    public void rollback() throws SQLException {
        this.connection.rollback();
    }

    public void close() throws SQLException {
        this.connection.close();
    }

    public boolean isClosed() throws SQLException {
        return this.connection.isClosed();
    }

    public DatabaseMetaData getMetaData() throws SQLException {
        return this.connection.getMetaData();
    }

    public void setReadOnly(boolean var1) throws SQLException {
        this.connection.setReadOnly(var1);
    }

    public boolean isReadOnly() throws SQLException {
        return this.connection.isReadOnly();
    }

    public void setCatalog(String var1) throws SQLException {
        this.connection.setCatalog(var1);
    }

    public String getCatalog() throws SQLException {
        return this.connection.getCatalog();
    }

    public void setTransactionIsolation(int var1) throws SQLException {
        this.connection.setTransactionIsolation(var1);
    }

    public int getTransactionIsolation() throws SQLException {
        return this.connection.getTransactionIsolation();
    }

    public SQLWarning getWarnings() throws SQLException {
        return this.connection.getWarnings();
    }

    public void clearWarnings() throws SQLException {
        this.connection.clearWarnings();
    }

    public Statement createStatement(int var1, int var2) throws SQLException {
        return this.connection.createStatement(var1, var2);
    }

    public PreparedStatement prepareStatement(String var1, int var2, int var3) throws SQLException {
        return this.connection.prepareStatement(var1, var2, var3);
    }

    public CallableStatement prepareCall(String var1, int var2, int var3) throws SQLException {
        return this.connection.prepareCall(var1, var2, var3);
    }

    public Map getTypeMap() throws SQLException {
        return this.connection.getTypeMap();
    }

    public void setTypeMap(Map var1) throws SQLException {
        this.connection.setTypeMap(var1);
    }

    public boolean isProxySession() {
        return this.connection.isProxySession();
    }

    public void openProxySession(int var1, Properties var2) throws SQLException {
        this.connection.openProxySession(var1, var2);
    }

    public void archive(int var1, int var2, String var3) throws SQLException {
        this.connection.archive(var1, var2, var3);
    }

    public boolean getAutoClose() throws SQLException {
        return this.connection.getAutoClose();
    }

    public CallableStatement getCallWithKey(String var1) throws SQLException {
        return this.connection.getCallWithKey(var1);
    }

    public int getDefaultExecuteBatch() {
        return this.connection.getDefaultExecuteBatch();
    }

    public int getDefaultRowPrefetch() {
        return this.connection.getDefaultRowPrefetch();
    }

    public Object getDescriptor(String var1) {
        return this.connection.getDescriptor(var1);
    }

    public String[] getEndToEndMetrics() throws SQLException {
        return this.connection.getEndToEndMetrics();
    }

    public short getEndToEndECIDSequenceNumber() throws SQLException {
        return this.connection.getEndToEndECIDSequenceNumber();
    }

    public boolean getIncludeSynonyms() {
        return this.connection.getIncludeSynonyms();
    }

    public boolean getRestrictGetTables() {
        return this.connection.getRestrictGetTables();
    }

    public boolean getImplicitCachingEnabled() throws SQLException {
        return this.connection.getImplicitCachingEnabled();
    }

    public boolean getExplicitCachingEnabled() throws SQLException {
        return this.connection.getExplicitCachingEnabled();
    }

    public Object getJavaObject(String var1) throws SQLException {
        return this.connection.getJavaObject(var1);
    }

    public boolean getRemarksReporting() {
        return this.connection.getRemarksReporting();
    }

    public String getSQLType(Object var1) throws SQLException {
        return this.connection.getSQLType(var1);
    }

    public int getStmtCacheSize() {
        return this.connection.getStmtCacheSize();
    }

    public int getStatementCacheSize() throws SQLException {
        return this.connection.getStatementCacheSize();
    }

    public PreparedStatement getStatementWithKey(String var1) throws SQLException {
        return this.connection.getStatementWithKey(var1);
    }

    public short getStructAttrCsId() throws SQLException {
        return this.connection.getStructAttrCsId();
    }

    public String getUserName() throws SQLException {
        return this.connection.getUserName();
    }

    public String getCurrentSchema() throws SQLException {
        return this.connection.getCurrentSchema();
    }

    public boolean getUsingXAFlag() {
        return this.connection.getUsingXAFlag();
    }

    public boolean getXAErrorFlag() {
        return this.connection.getXAErrorFlag();
    }

    public OracleSavepoint oracleSetSavepoint() throws SQLException {
        return this.connection.oracleSetSavepoint();
    }

    public OracleSavepoint oracleSetSavepoint(String var1) throws SQLException {
        return this.connection.oracleSetSavepoint(var1);
    }

    public void oracleRollback(OracleSavepoint var1) throws SQLException {
        this.connection.oracleRollback(var1);
    }

    public void oracleReleaseSavepoint(OracleSavepoint var1) throws SQLException {
        this.connection.oracleReleaseSavepoint(var1);
    }

    public int pingDatabase() throws SQLException {
        return this.connection.pingDatabase();
    }

    public int pingDatabase(int var1) throws SQLException {
        return this.connection.pingDatabase(var1);
    }

    public void purgeExplicitCache() throws SQLException {
        this.connection.purgeExplicitCache();
    }

    public void purgeImplicitCache() throws SQLException {
        this.connection.purgeImplicitCache();
    }

    public void putDescriptor(String var1, Object var2) throws SQLException {
        this.connection.putDescriptor(var1, var2);
    }

    public void registerSQLType(String var1, Class var2) throws SQLException {
        this.connection.registerSQLType(var1, var2);
    }

    public void registerSQLType(String var1, String var2) throws SQLException {
        this.connection.registerSQLType(var1, var2);
    }

    public void setAutoClose(boolean var1) throws SQLException {
        this.connection.setAutoClose(var1);
    }

    public void setDefaultExecuteBatch(int var1) throws SQLException {
        this.connection.setDefaultExecuteBatch(var1);
    }

    public void setDefaultRowPrefetch(int var1) throws SQLException {
        this.connection.setDefaultRowPrefetch(var1);
    }

    public void setEndToEndMetrics(String[] var1, short var2) throws SQLException {
        this.connection.setEndToEndMetrics(var1, var2);
    }

    public void setExplicitCachingEnabled(boolean var1) throws SQLException {
        this.connection.setExplicitCachingEnabled(var1);
    }

    public void setImplicitCachingEnabled(boolean var1) throws SQLException {
        this.connection.setImplicitCachingEnabled(var1);
    }

    public void setIncludeSynonyms(boolean var1) {
        this.connection.setIncludeSynonyms(var1);
    }

    public void setRemarksReporting(boolean var1) {
        this.connection.setRemarksReporting(var1);
    }

    public void setRestrictGetTables(boolean var1) {
        this.connection.setRestrictGetTables(var1);
    }

    public void setStmtCacheSize(int var1) throws SQLException {
        this.connection.setStmtCacheSize(var1);
    }

    public void setStatementCacheSize(int var1) throws SQLException {
        this.connection.setStatementCacheSize(var1);
    }

    public void setStmtCacheSize(int var1, boolean var2) throws SQLException {
        this.connection.setStmtCacheSize(var1, var2);
    }

    public void setUsingXAFlag(boolean var1) {
        this.connection.setUsingXAFlag(var1);
    }

    public void setXAErrorFlag(boolean var1) {
        this.connection.setXAErrorFlag(var1);
    }

    public void shutdown(DatabaseShutdownMode var1) throws SQLException {
        this.connection.shutdown(var1);
    }

    public void startup(String var1, int var2) throws SQLException {
        this.connection.startup(var1, var2);
    }

    public void startup(DatabaseStartupMode var1) throws SQLException {
        this.connection.startup(var1);
    }

    public PreparedStatement prepareStatementWithKey(String var1) throws SQLException {
        return this.connection.prepareStatementWithKey(var1);
    }

    public CallableStatement prepareCallWithKey(String var1) throws SQLException {
        return this.connection.prepareCallWithKey(var1);
    }

    public void setCreateStatementAsRefCursor(boolean var1) {
        this.connection.setCreateStatementAsRefCursor(var1);
    }

    public boolean getCreateStatementAsRefCursor() {
        return this.connection.getCreateStatementAsRefCursor();
    }

    public void setSessionTimeZone(String var1) throws SQLException {
        this.connection.setSessionTimeZone(var1);
    }

    public String getSessionTimeZone() {
        return this.connection.getSessionTimeZone();
    }

    public String getSessionTimeZoneOffset() throws SQLException {
        return this.connection.getSessionTimeZoneOffset();
    }

    public Connection _getPC() {
        return this.connection._getPC();
    }

    public boolean isLogicalConnection() {
        return this.connection.isLogicalConnection();
    }

    public void registerTAFCallback(OracleOCIFailover var1, Object var2) throws SQLException {
        this.connection.registerTAFCallback(var1, var2);
    }

    public Properties getProperties() {
        return this.connection.getProperties();
    }

    public void close(Properties var1) throws SQLException {
        this.connection.close(var1);
    }

    public void close(int var1) throws SQLException {
        this.connection.close(var1);
    }

    public void applyConnectionAttributes(Properties var1) throws SQLException {
        this.connection.applyConnectionAttributes(var1);
    }

    public Properties getConnectionAttributes() throws SQLException {
        return this.connection.getConnectionAttributes();
    }

    public Properties getUnMatchedConnectionAttributes() throws SQLException {
        return this.connection.getUnMatchedConnectionAttributes();
    }

    public void registerConnectionCacheCallback(OracleConnectionCacheCallback var1, Object var2, int var3) throws SQLException {
        this.connection.registerConnectionCacheCallback(var1, var2, var3);
    }

    public void setConnectionReleasePriority(int var1) throws SQLException {
        this.connection.setConnectionReleasePriority(var1);
    }

    public int getConnectionReleasePriority() throws SQLException {
        return this.connection.getConnectionReleasePriority();
    }

    public void setPlsqlWarnings(String var1) throws SQLException {
        this.connection.setPlsqlWarnings(var1);
    }

    public void setHoldability(int var1) throws SQLException {
        this.connection.setHoldability(var1);
    }

    public int getHoldability() throws SQLException {
        return this.connection.getHoldability();
    }

    public Statement createStatement(int var1, int var2, int var3) throws SQLException {
        return this.connection.createStatement(var1, var2, var3);
    }

    public PreparedStatement prepareStatement(String var1, int var2, int var3, int var4) throws SQLException {
        return this.connection.prepareStatement(var1, var2, var3, var4);
    }

    public CallableStatement prepareCall(String var1, int var2, int var3, int var4) throws SQLException {
        return this.connection.prepareCall(var1, var2, var3, var4);
    }

    public synchronized Savepoint setSavepoint() throws SQLException {
        return this.connection.setSavepoint();
    }

    public synchronized Savepoint setSavepoint(String var1) throws SQLException {
        return this.connection.setSavepoint(var1);
    }

    public synchronized void rollback(Savepoint var1) throws SQLException {
        this.connection.rollback(var1);
    }

    public synchronized void releaseSavepoint(Savepoint var1) throws SQLException {
        this.connection.releaseSavepoint(var1);
    }

    public PreparedStatement prepareStatement(String var1, int var2) throws SQLException {
        return this.connection.prepareStatement(var1, var2);
    }

    public PreparedStatement prepareStatement(String var1, int[] var2) throws SQLException {
        return this.connection.prepareStatement(var1, var2);
    }

    public PreparedStatement prepareStatement(String var1, String[] var2) throws SQLException {
        return this.connection.prepareStatement(var1, var2);
    }

    public ARRAY createARRAY(String var1, Object var2) throws SQLException {
        return this.connection.createARRAY(var1, var2);
    }

    public Array createOracleArray(String var1, Object var2) throws SQLException {
        return this.connection.createOracleArray(var1, var2);
    }

    public BINARY_DOUBLE createBINARY_DOUBLE(double var1) throws SQLException {
        return this.connection.createBINARY_DOUBLE(var1);
    }

    public BINARY_FLOAT createBINARY_FLOAT(float var1) throws SQLException {
        return this.connection.createBINARY_FLOAT(var1);
    }

    public DATE createDATE(Date var1) throws SQLException {
        return this.connection.createDATE(var1);
    }

    public DATE createDATE(Time var1) throws SQLException {
        return this.connection.createDATE(var1);
    }

    public DATE createDATE(Timestamp var1) throws SQLException {
        return this.connection.createDATE(var1);
    }

    public DATE createDATE(Date var1, Calendar var2) throws SQLException {
        return this.connection.createDATE(var1, var2);
    }

    public DATE createDATE(Time var1, Calendar var2) throws SQLException {
        return this.connection.createDATE(var1, var2);
    }

    public DATE createDATE(Timestamp var1, Calendar var2) throws SQLException {
        return this.connection.createDATE(var1, var2);
    }

    public DATE createDATE(String var1) throws SQLException {
        return this.connection.createDATE(var1);
    }

    public INTERVALDS createINTERVALDS(String var1) throws SQLException {
        return this.connection.createINTERVALDS(var1);
    }

    public INTERVALYM createINTERVALYM(String var1) throws SQLException {
        return this.connection.createINTERVALYM(var1);
    }

    public NUMBER createNUMBER(boolean var1) throws SQLException {
        return this.connection.createNUMBER(var1);
    }

    public NUMBER createNUMBER(byte var1) throws SQLException {
        return this.connection.createNUMBER(var1);
    }

    public NUMBER createNUMBER(short var1) throws SQLException {
        return this.connection.createNUMBER(var1);
    }

    public NUMBER createNUMBER(int var1) throws SQLException {
        return this.connection.createNUMBER(var1);
    }

    public NUMBER createNUMBER(long var1) throws SQLException {
        return this.connection.createNUMBER(var1);
    }

    public NUMBER createNUMBER(float var1) throws SQLException {
        return this.connection.createNUMBER(var1);
    }

    public NUMBER createNUMBER(double var1) throws SQLException {
        return this.connection.createNUMBER(var1);
    }

    public NUMBER createNUMBER(BigDecimal var1) throws SQLException {
        return this.connection.createNUMBER(var1);
    }

    public NUMBER createNUMBER(BigInteger var1) throws SQLException {
        return this.connection.createNUMBER(var1);
    }

    public NUMBER createNUMBER(String var1, int var2) throws SQLException {
        return this.connection.createNUMBER(var1, var2);
    }

    public TIMESTAMP createTIMESTAMP(Date var1) throws SQLException {
        return this.connection.createTIMESTAMP(var1);
    }

    public TIMESTAMP createTIMESTAMP(DATE var1) throws SQLException {
        return this.connection.createTIMESTAMP(var1);
    }

    public TIMESTAMP createTIMESTAMP(Time var1) throws SQLException {
        return this.connection.createTIMESTAMP(var1);
    }

    public TIMESTAMP createTIMESTAMP(Timestamp var1) throws SQLException {
        return this.connection.createTIMESTAMP(var1);
    }

    public TIMESTAMP createTIMESTAMP(String var1) throws SQLException {
        return this.connection.createTIMESTAMP(var1);
    }

    public TIMESTAMPTZ createTIMESTAMPTZ(Date var1) throws SQLException {
        return this.connection.createTIMESTAMPTZ(var1);
    }

    public TIMESTAMPTZ createTIMESTAMPTZ(Date var1, Calendar var2) throws SQLException {
        return this.connection.createTIMESTAMPTZ(var1, var2);
    }

    public TIMESTAMPTZ createTIMESTAMPTZ(Time var1) throws SQLException {
        return this.connection.createTIMESTAMPTZ(var1);
    }

    public TIMESTAMPTZ createTIMESTAMPTZ(Time var1, Calendar var2) throws SQLException {
        return this.connection.createTIMESTAMPTZ(var1, var2);
    }

    public TIMESTAMPTZ createTIMESTAMPTZ(Timestamp var1) throws SQLException {
        return this.connection.createTIMESTAMPTZ(var1);
    }

    public TIMESTAMPTZ createTIMESTAMPTZ(Timestamp var1, Calendar var2) throws SQLException {
        return this.connection.createTIMESTAMPTZ(var1, var2);
    }

    public TIMESTAMPTZ createTIMESTAMPTZ(String var1) throws SQLException {
        return this.connection.createTIMESTAMPTZ(var1);
    }

    public TIMESTAMPTZ createTIMESTAMPTZ(String var1, Calendar var2) throws SQLException {
        return this.connection.createTIMESTAMPTZ(var1, var2);
    }

    public TIMESTAMPTZ createTIMESTAMPTZ(DATE var1) throws SQLException {
        return this.connection.createTIMESTAMPTZ(var1);
    }

    public TIMESTAMPLTZ createTIMESTAMPLTZ(Date var1, Calendar var2) throws SQLException {
        return this.connection.createTIMESTAMPLTZ(var1, var2);
    }

    public TIMESTAMPLTZ createTIMESTAMPLTZ(Time var1, Calendar var2) throws SQLException {
        return this.connection.createTIMESTAMPLTZ(var1, var2);
    }

    public TIMESTAMPLTZ createTIMESTAMPLTZ(Timestamp var1, Calendar var2) throws SQLException {
        return this.connection.createTIMESTAMPLTZ(var1, var2);
    }

    public TIMESTAMPLTZ createTIMESTAMPLTZ(String var1, Calendar var2) throws SQLException {
        return this.connection.createTIMESTAMPLTZ(var1, var2);
    }

    public TIMESTAMPLTZ createTIMESTAMPLTZ(DATE var1, Calendar var2) throws SQLException {
        return this.connection.createTIMESTAMPLTZ(var1, var2);
    }

    public Array createArrayOf(String var1, Object[] var2) throws SQLException {
        return this.connection.createArrayOf(var1, var2);
    }

    public Blob createBlob() throws SQLException {
        return this.connection.createBlob();
    }

    public Clob createClob() throws SQLException {
        return this.connection.createClob();
    }

    public NClob createNClob() throws SQLException {
        return this.connection.createNClob();
    }

    public SQLXML createSQLXML() throws SQLException {
        return this.connection.createSQLXML();
    }

    public Struct createStruct(String var1, Object[] var2) throws SQLException {
        return this.connection.createStruct(var1, var2);
    }

    public boolean isValid(int var1) throws SQLException {
        return this.connection.isValid(var1);
    }

    public void setClientInfo(String var1, String var2) throws SQLClientInfoException {
        this.connection.setClientInfo(var1, var2);
    }

    public void setClientInfo(Properties var1) throws SQLClientInfoException {
        this.connection.setClientInfo(var1);
    }

    public String getClientInfo(String var1) throws SQLException {
        return this.connection.getClientInfo(var1);
    }

    public Properties getClientInfo() throws SQLException {
        return this.connection.getClientInfo();
    }

    public boolean isWrapperFor(Class<?> var1) throws SQLException {
        if (!var1.isInterface()) {
            SQLException var2 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 177);
            var2.fillInStackTrace();
            throw var2;
        } else {
            return var1.isInstance(this) || this.connection.isWrapperFor(var1);
        }
    }

    protected <T> T proxyFor(Object var1, Class<T> var2) throws SQLException {
        try {
            Object var3 = this.proxies.get(var2);
            if (var3 == null) {
                Class var6 = (Class)proxyClasses.get(var2);
                if (var6 == null) {
                    var6 = Proxy.getProxyClass(var2.getClassLoader(), var2);
                    proxyClasses.put(var2, var6);
                }

                var3 = var6.getConstructor(InvocationHandler.class).newInstance(new OracleConnectionWrapper.CloseInvocationHandler(this));
                this.proxies.put(var2, var3);
            }

            return (T) var3;
        } catch (Exception var5) {
            SQLException var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 1, "Cannot construct proxy");
            var4.fillInStackTrace();
            throw var4;
        }
    }

    public <T> T unwrap(Class<T> var1) throws SQLException {
        if (var1.isInterface()) {
            return var1.isInstance(this) ? (T) this : this.proxyFor(this.connection.unwrap(var1), var1);
        } else {
            SQLException var2 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 177);
            var2.fillInStackTrace();
            throw var2;
        }
    }

    public void abort(Executor var1) throws SQLException {
        this.connection.abort(var1);
    }

    public int getNetworkTimeout() throws SQLException {
        return this.connection.getNetworkTimeout();
    }

    public String getSchema() throws SQLException {
        return this.connection.getSchema();
    }

    public void setNetworkTimeout(Executor var1, int var2) throws SQLException {
        this.connection.setNetworkTimeout(var1, var2);
    }

    public void setSchema(String var1) throws SQLException {
        this.connection.setSchema(var1);
    }

    public DatabaseChangeRegistration registerDatabaseChangeNotification(Properties var1) throws SQLException {
        return this.connection.registerDatabaseChangeNotification(var1);
    }

    public DatabaseChangeRegistration getDatabaseChangeRegistration(int var1) throws SQLException {
        return this.connection.getDatabaseChangeRegistration(var1);
    }

    public void unregisterDatabaseChangeNotification(DatabaseChangeRegistration var1) throws SQLException {
        this.connection.unregisterDatabaseChangeNotification(var1);
    }

    public void unregisterDatabaseChangeNotification(int var1, String var2, int var3) throws SQLException {
        this.connection.unregisterDatabaseChangeNotification(var1, var2, var3);
    }

    public void unregisterDatabaseChangeNotification(int var1) throws SQLException {
        this.connection.unregisterDatabaseChangeNotification(var1);
    }

    public void unregisterDatabaseChangeNotification(long var1, String var3) throws SQLException {
        this.connection.unregisterDatabaseChangeNotification(var1, var3);
    }

    public AQNotificationRegistration[] registerAQNotification(String[] var1, Properties[] var2, Properties var3) throws SQLException {
        return this.connection.registerAQNotification(var1, var2, var3);
    }

    public void unregisterAQNotification(AQNotificationRegistration var1) throws SQLException {
        this.connection.unregisterAQNotification(var1);
    }

    public AQMessage dequeue(String var1, AQDequeueOptions var2, byte[] var3) throws SQLException {
        return this.connection.dequeue(var1, var2, var3);
    }

    public AQMessage dequeue(String var1, AQDequeueOptions var2, String var3) throws SQLException {
        return this.connection.dequeue(var1, var2, var3);
    }

    public void enqueue(String var1, AQEnqueueOptions var2, AQMessage var3) throws SQLException {
        this.connection.enqueue(var1, var2, var3);
    }

    public void commit(EnumSet<CommitOption> var1) throws SQLException {
        this.connection.commit(var1);
    }

    public void cancel() throws SQLException {
        this.connection.cancel();
    }

    public void abort() throws SQLException {
        this.connection.abort();
    }

    public TypeDescriptor[] getAllTypeDescriptorsInCurrentSchema() throws SQLException {
        return this.connection.getAllTypeDescriptorsInCurrentSchema();
    }

    public TypeDescriptor[] getTypeDescriptorsFromListInCurrentSchema(String[] var1) throws SQLException {
        return this.connection.getTypeDescriptorsFromListInCurrentSchema(var1);
    }

    public TypeDescriptor[] getTypeDescriptorsFromList(String[][] var1) throws SQLException {
        return this.connection.getTypeDescriptorsFromList(var1);
    }

    public String getDataIntegrityAlgorithmName() throws SQLException {
        return this.connection.getDataIntegrityAlgorithmName();
    }

    public String getEncryptionAlgorithmName() throws SQLException {
        return this.connection.getEncryptionAlgorithmName();
    }

    public String getAuthenticationAdaptorName() throws SQLException {
        return this.connection.getAuthenticationAdaptorName();
    }

    public boolean isUsable() {
        return this.connection.isUsable();
    }

    protected oracle.jdbc.internal.OracleConnection getConnectionDuringExceptionHandling() {
        return null;
    }

    public void setDefaultTimeZone(TimeZone var1) throws SQLException {
        this.connection.setDefaultTimeZone(var1);
    }

    public TimeZone getDefaultTimeZone() throws SQLException {
        return this.connection.getDefaultTimeZone();
    }

    public void setApplicationContext(String var1, String var2, String var3) throws SQLException {
        this.connection.setApplicationContext(var1, var2, var3);
    }

    public void clearAllApplicationContext(String var1) throws SQLException {
        this.connection.clearAllApplicationContext(var1);
    }

    public void addLogicalTransactionIdEventListener(LogicalTransactionIdEventListener var1) throws SQLException {
        this.connection.addLogicalTransactionIdEventListener(var1);
    }

    public void addLogicalTransactionIdEventListener(LogicalTransactionIdEventListener var1, Executor var2) throws SQLException {
        this.connection.addLogicalTransactionIdEventListener(var1, var2);
    }

    public void removeLogicalTransactionIdEventListener(LogicalTransactionIdEventListener var1) throws SQLException {
        this.connection.removeLogicalTransactionIdEventListener(var1);
    }

    public LogicalTransactionId getLogicalTransactionId() throws SQLException {
        return this.connection.getLogicalTransactionId();
    }

    public boolean needToPurgeStatementCache() throws SQLException {
        return this.connection.needToPurgeStatementCache();
    }

    public boolean attachServerConnection() throws SQLException {
        return this.connection.attachServerConnection();
    }

    public void detachServerConnection(String var1) throws SQLException {
        this.connection.detachServerConnection(var1);
    }

    public boolean isDRCPEnabled() throws SQLException {
        return this.connection.isDRCPEnabled();
    }

    protected class CloseInvocationHandler implements InvocationHandler {
        private OracleConnectionWrapper wrapper;

        protected CloseInvocationHandler(OracleConnectionWrapper var2) {
            this.wrapper = var2;
        }

        public Object invoke(Object var1, Method var2, Object[] var3) throws Throwable {
            try {
                return var2.invoke(this.wrapper, var3);
            } catch (IllegalArgumentException var5) {
                return var2.invoke(this.wrapper.connection, var3);
            }
        }
    }
}
