//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package oracle.jdbc.driver;

import java.net.SocketException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.EnumSet;
import java.util.Enumeration;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.Executor;
import javax.transaction.xa.XAResource;
import oracle.jdbc.LogicalTransactionIdEventListener;
import oracle.jdbc.aq.AQMessageProperties;
import oracle.jdbc.internal.JMSDequeueOptions;
import oracle.jdbc.internal.JMSEnqueueOptions;
import oracle.jdbc.internal.JMSMessage;
import oracle.jdbc.internal.JMSNotificationRegistration;
import oracle.jdbc.internal.KeywordValueLong;
import oracle.jdbc.internal.OracleStatement;
import oracle.jdbc.internal.PDBChangeEventListener;
import oracle.jdbc.internal.ReplayContext;
import oracle.jdbc.internal.XSEventListener;
import oracle.jdbc.internal.XSKeyval;
import oracle.jdbc.internal.XSNamespace;
import oracle.jdbc.internal.XSPrincipal;
import oracle.jdbc.internal.XSSecureId;
import oracle.jdbc.internal.XSSessionParameters;
import oracle.jdbc.internal.JMSNotificationRegistration.Directive;
import oracle.jdbc.internal.OracleConnection.BufferCacheStatistics;
import oracle.jdbc.internal.OracleConnection.ChecksumMode;
import oracle.jdbc.internal.OracleConnection.EndReplayCallback;
import oracle.jdbc.internal.OracleConnection.InstanceProperty;
import oracle.jdbc.internal.OracleConnection.ReplayOperation;
import oracle.jdbc.internal.OracleConnection.TransactionState;
import oracle.jdbc.internal.OracleConnection.XSOperationCode;
import oracle.jdbc.internal.OracleConnection.XSSessionModeFlag;
import oracle.jdbc.internal.OracleConnection.XSSessionOperationCode;
import oracle.jdbc.internal.OracleConnection.XSSessionSetOperationCode;
import oracle.jdbc.oracore.OracleTypeADT;
import oracle.jdbc.oracore.OracleTypeCLOB;
import oracle.jdbc.pool.OracleConnectionCacheCallback;
import oracle.jdbc.pool.OraclePooledConnection;
import oracle.sql.ARRAY;
import oracle.sql.ArrayDescriptor;
import oracle.sql.BFILE;
import oracle.sql.BLOB;
import oracle.sql.BfileDBAccess;
import oracle.sql.BlobDBAccess;
import oracle.sql.CLOB;
import oracle.sql.ClobDBAccess;
import oracle.sql.CustomDatum;
import oracle.sql.Datum;
import oracle.sql.StructDescriptor;
import oracle.sql.TIMESTAMPTZ;
import oracle.sql.TIMEZONETAB;

class LogicalConnection extends OracleConnection {
    static final ClosedConnection closedConnection = new ClosedConnection();
    PhysicalConnection internalConnection;
    OraclePooledConnection pooledConnection;
    boolean closed;
    OracleCloseCallback closeCallback = null;
    Object privateData = null;
    long startTime = 0L;
    OracleConnectionCacheCallback connectionCacheCallback = null;
    Object connectionCacheCallbackUserObj = null;
    int callbackFlag = 0;
    int releasePriority = 0;
    int heartbeatCount = 0;
    int heartbeatLastCount = 0;
    int heartbeatNoChangeCount = 0;
    boolean isAbandonedTimeoutEnabled = false;
    private static final String _Copyright_2007_Oracle_All_Rights_Reserved_ = null;
    public static final String BUILD_DATE = "Thu_Apr_04_15:09:24_PDT_2013";
    public static final boolean TRACE = false;

    LogicalConnection(OraclePooledConnection var1, PhysicalConnection var2, boolean var3) throws SQLException {
        this.internalConnection = var2;
        this.pooledConnection = var1;
        this.connection = this.internalConnection;
        this.connection.setWrapper(this);
        this.closed = false;
        this.internalConnection.setAutoCommit(var3);
        this.internalConnection.attachServerConnection();
    }

    void registerHeartbeat() throws SQLException {
        if (this.isAbandonedTimeoutEnabled) {
            try {
                ++this.heartbeatCount;
            } catch (ArithmeticException var2) {
                this.heartbeatCount = 0;
            }
        }

    }

    public int getHeartbeatNoChangeCount() throws SQLException {
        if (this.heartbeatCount == this.heartbeatLastCount) {
            ++this.heartbeatNoChangeCount;
        } else {
            this.heartbeatLastCount = this.heartbeatCount;
            this.heartbeatNoChangeCount = 0;
        }

        return this.heartbeatNoChangeCount;
    }

    public oracle.jdbc.internal.OracleConnection physicalConnectionWithin() {
        return this.internalConnection;
    }

    public synchronized void registerCloseCallback(OracleCloseCallback var1, Object var2) {
        this.closeCallback = var1;
        this.privateData = var2;
    }

    public Connection _getPC() {
        return this.internalConnection;
    }

    public synchronized boolean isLogicalConnection() {
        return true;
    }

    public oracle.jdbc.internal.OracleConnection getPhysicalConnection() {
        return this.internalConnection;
    }

    public Connection getLogicalConnection(OraclePooledConnection var1, boolean var2) throws SQLException {
        SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 153);
        var3.fillInStackTrace();
        throw var3;
    }

    public void getPropertyForPooledConnection(OraclePooledConnection var1) throws SQLException {
        SQLException var2 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 153);
        var2.fillInStackTrace();
        throw var2;
    }

    public synchronized void close() throws SQLException {
        this.closeInternal(this.internalConnection.isUsable);
    }

    public void closeInternal(boolean var1) throws SQLException {
        if (!this.closed) {
            if (this.closeCallback != null) {
                this.closeCallback.beforeClose(this, this.privateData);
            }

            if (this.internalConnection.lifecycle == 1) {
                this.internalConnection.detachServerConnection((String)null);
            }

            this.internalConnection.closeLogicalConnection();
            this.startTime = 0L;
            this.closed = true;
            if (this.pooledConnection != null && var1) {
                this.pooledConnection.logicalClose();
            }

            this.internalConnection = closedConnection;
            this.connection = closedConnection;
            if (this.closeCallback != null) {
                this.closeCallback.afterClose(this.privateData);
            }

        }
    }

    public void cleanupAndClose(boolean var1) throws SQLException {
        if (!this.closed) {
            this.closed = true;
            PhysicalConnection var2 = this.internalConnection;
            OraclePooledConnection var3 = this.pooledConnection;
            this.internalConnection = closedConnection;
            this.connection = closedConnection;
            this.startTime = 0L;
            if (this.closeCallback != null) {
                this.closeCallback.beforeClose(this, this.privateData);
            }

            var2.cleanupAndClose();
            var2.closeLogicalConnection();
            if (var3 != null && var1) {
                var3.logicalClose();
            }

            if (this.closeCallback != null) {
                this.closeCallback.afterClose(this.privateData);
            }

        }
    }

    public void abort() throws SQLException {
        if (!this.closed) {
            this.internalConnection.abort();
            this.closed = true;
            this.internalConnection = closedConnection;
            this.connection = closedConnection;
        }
    }

    public synchronized void close(Properties var1) throws SQLException {
        if (this.pooledConnection != null) {
            if (this.pooledConnection.cachedConnectionAttributes != null) {
                if (var1 != null) {
                    this.pooledConnection.cachedConnectionAttributes.clear();
                    this.pooledConnection.cachedConnectionAttributes.putAll(var1);
                    this.internalConnection.detachServerConnection((String)null);
                } else {
                    this.internalConnection.drcpTagName = null;
                }
            } else if (var1 != null) {
                this.internalConnection.detachServerConnection((String)null);
                this.pooledConnection.cachedConnectionAttributes = var1;
            }
        }

        this.close();
    }

    public synchronized void close(int var1) throws SQLException {
        if ((var1 & 4096) != 0) {
            if (this.pooledConnection != null) {
                this.pooledConnection.closeOption = var1;
            }

            this.close();
        } else {
            if ((var1 & 1) != 0) {
                this.internalConnection.close(1);
            }

        }
    }

    public synchronized void applyConnectionAttributes(Properties var1) throws SQLException {
        if (this.pooledConnection != null) {
            this.pooledConnection.cachedConnectionAttributes.putAll(var1);
        }

    }

    public synchronized Properties getConnectionAttributes() throws SQLException {
        return this.pooledConnection != null ? this.pooledConnection.cachedConnectionAttributes : null;
    }

    public synchronized Properties getUnMatchedConnectionAttributes() throws SQLException {
        return this.pooledConnection != null ? this.pooledConnection.unMatchedCachedConnAttr : null;
    }

    public synchronized void setAbandonedTimeoutEnabled(boolean var1) throws SQLException {
        this.isAbandonedTimeoutEnabled = true;
    }

    public synchronized void registerConnectionCacheCallback(OracleConnectionCacheCallback var1, Object var2, int var3) throws SQLException {
        this.connectionCacheCallback = var1;
        this.connectionCacheCallbackUserObj = var2;
        this.callbackFlag = var3;
    }

    public OracleConnectionCacheCallback getConnectionCacheCallbackObj() throws SQLException {
        return this.connectionCacheCallback;
    }

    public Object getConnectionCacheCallbackPrivObj() throws SQLException {
        return this.connectionCacheCallbackUserObj;
    }

    public int getConnectionCacheCallbackFlag() throws SQLException {
        return this.callbackFlag;
    }

    public synchronized void setConnectionReleasePriority(int var1) throws SQLException {
        this.releasePriority = var1;
    }

    public int getConnectionReleasePriority() throws SQLException {
        return this.releasePriority;
    }

    public synchronized boolean isClosed() throws SQLException {
        return this.closed;
    }

    public void setStartTime(long var1) throws SQLException {
        if (var1 <= 0L) {
            SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 68);
            var3.fillInStackTrace();
            throw var3;
        } else {
            this.startTime = var1;
        }
    }

    public long getStartTime() throws SQLException {
        return this.startTime;
    }

    public String getDatabaseTimeZone() throws SQLException {
        return this.internalConnection.getDatabaseTimeZone();
    }

    public Properties getServerSessionInfo() throws SQLException {
        return this.internalConnection.getServerSessionInfo();
    }

    public Object getClientData(Object var1) {
        return this.internalConnection.getClientData(var1);
    }

    public Object setClientData(Object var1, Object var2) {
        return this.internalConnection.setClientData(var1, var2);
    }

    public Object removeClientData(Object var1) {
        return this.internalConnection.removeClientData(var1);
    }

    public void setClientIdentifier(String var1) throws SQLException {
        this.internalConnection.setClientIdentifier(var1);
    }

    public void clearClientIdentifier(String var1) throws SQLException {
        this.internalConnection.clearClientIdentifier(var1);
    }

    public short getStructAttrNCsId() throws SQLException {
        return this.internalConnection.getStructAttrNCsId();
    }

    public Map getTypeMap() throws SQLException {
        return this.internalConnection.getTypeMap();
    }

    public Properties getDBAccessProperties() throws SQLException {
        return this.internalConnection.getDBAccessProperties();
    }

    public Properties getOCIHandles() throws SQLException {
        return this.internalConnection.getOCIHandles();
    }

    public String getDatabaseProductVersion() throws SQLException {
        return this.internalConnection.getDatabaseProductVersion();
    }

    public void cancel() throws SQLException {
        this.registerHeartbeat();
        this.internalConnection.cancel();
    }

    public String getURL() throws SQLException {
        return this.internalConnection.getURL();
    }

    public boolean getIncludeSynonyms() {
        return this.internalConnection.getIncludeSynonyms();
    }

    public boolean getRemarksReporting() {
        return this.internalConnection.getRemarksReporting();
    }

    public boolean getRestrictGetTables() {
        return this.internalConnection.getRestrictGetTables();
    }

    public short getVersionNumber() throws SQLException {
        return this.internalConnection.getVersionNumber();
    }

    public Map getJavaObjectTypeMap() {
        return this.internalConnection.getJavaObjectTypeMap();
    }

    public void setJavaObjectTypeMap(Map var1) {
        this.internalConnection.setJavaObjectTypeMap(var1);
    }

    public BfileDBAccess createBfileDBAccess() throws SQLException {
        return this.internalConnection.createBfileDBAccess();
    }

    public BlobDBAccess createBlobDBAccess() throws SQLException {
        return this.internalConnection.createBlobDBAccess();
    }

    public ClobDBAccess createClobDBAccess() throws SQLException {
        return this.internalConnection.createClobDBAccess();
    }

    public void setDefaultFixedString(boolean var1) {
        this.internalConnection.setDefaultFixedString(var1);
    }

    public boolean getTimestamptzInGmt() {
        return this.internalConnection.getTimestamptzInGmt();
    }

    public boolean getUse1900AsYearForTime() {
        return this.internalConnection.getUse1900AsYearForTime();
    }

    public boolean getDefaultFixedString() {
        return this.internalConnection.getDefaultFixedString();
    }

    public oracle.jdbc.OracleConnection getWrapper() {
        return this;
    }

    public Class classForNameAndSchema(String var1, String var2) throws ClassNotFoundException {
        return this.internalConnection.classForNameAndSchema(var1, var2);
    }

    public void setFDO(byte[] var1) throws SQLException {
        this.internalConnection.setFDO(var1);
    }

    public byte[] getFDO(boolean var1) throws SQLException {
        return this.internalConnection.getFDO(var1);
    }

    public boolean getBigEndian() throws SQLException {
        return this.internalConnection.getBigEndian();
    }

    public Object getDescriptor(byte[] var1) {
        return this.internalConnection.getDescriptor(var1);
    }

    public void putDescriptor(byte[] var1, Object var2) throws SQLException {
        this.internalConnection.putDescriptor(var1, var2);
    }

    public void removeDescriptor(String var1) {
        this.internalConnection.removeDescriptor(var1);
    }

    public void removeAllDescriptor() {
        this.internalConnection.removeAllDescriptor();
    }

    public int numberOfDescriptorCacheEntries() {
        return this.internalConnection.numberOfDescriptorCacheEntries();
    }

    public Enumeration descriptorCacheKeys() {
        return this.internalConnection.descriptorCacheKeys();
    }

    public void getOracleTypeADT(OracleTypeADT var1) throws SQLException {
        this.internalConnection.getOracleTypeADT(var1);
    }

    public short getDbCsId() throws SQLException {
        return this.internalConnection.getDbCsId();
    }

    public short getJdbcCsId() throws SQLException {
        return this.internalConnection.getJdbcCsId();
    }

    public short getNCharSet() {
        return this.internalConnection.getNCharSet();
    }

    public ResultSet newArrayDataResultSet(Datum[] var1, long var2, int var4, Map var5) throws SQLException {
        return this.internalConnection.newArrayDataResultSet(var1, var2, var4, var5);
    }

    public ResultSet newArrayDataResultSet(ARRAY var1, long var2, int var4, Map var5) throws SQLException {
        return this.internalConnection.newArrayDataResultSet(var1, var2, var4, var5);
    }

    public ResultSet newArrayLocatorResultSet(ArrayDescriptor var1, byte[] var2, long var3, int var5, Map var6) throws SQLException {
        return this.internalConnection.newArrayLocatorResultSet(var1, var2, var3, var5, var6);
    }

    public ResultSetMetaData newStructMetaData(StructDescriptor var1) throws SQLException {
        return this.internalConnection.newStructMetaData(var1);
    }

    public void getForm(OracleTypeADT var1, OracleTypeCLOB var2, int var3) throws SQLException {
        this.internalConnection.getForm(var1, var2, var3);
    }

    public int CHARBytesToJavaChars(byte[] var1, int var2, char[] var3) throws SQLException {
        return this.internalConnection.CHARBytesToJavaChars(var1, var2, var3);
    }

    public int NCHARBytesToJavaChars(byte[] var1, int var2, char[] var3) throws SQLException {
        return this.internalConnection.NCHARBytesToJavaChars(var1, var2, var3);
    }

    public boolean IsNCharFixedWith() {
        return this.internalConnection.IsNCharFixedWith();
    }

    public short getDriverCharSet() {
        return this.internalConnection.getDriverCharSet();
    }

    public int getC2SNlsRatio() {
        return this.internalConnection.getC2SNlsRatio();
    }

    public int getMaxCharSize() throws SQLException {
        return this.internalConnection.getMaxCharSize();
    }

    public int getMaxCharbyteSize() {
        return this.internalConnection.getMaxCharbyteSize();
    }

    public int getMaxNCharbyteSize() {
        return this.internalConnection.getMaxNCharbyteSize();
    }

    public boolean isCharSetMultibyte(short var1) {
        return this.internalConnection.isCharSetMultibyte(var1);
    }

    public int javaCharsToCHARBytes(char[] var1, int var2, byte[] var3) throws SQLException {
        return this.internalConnection.javaCharsToCHARBytes(var1, var2, var3);
    }

    public int javaCharsToNCHARBytes(char[] var1, int var2, byte[] var3) throws SQLException {
        return this.internalConnection.javaCharsToNCHARBytes(var1, var2, var3);
    }

    public int getStmtCacheSize() {
        return this.internalConnection.getStmtCacheSize();
    }

    public int getStatementCacheSize() throws SQLException {
        return this.internalConnection.getStatementCacheSize();
    }

    public boolean getImplicitCachingEnabled() throws SQLException {
        return this.internalConnection.getImplicitCachingEnabled();
    }

    public boolean getExplicitCachingEnabled() throws SQLException {
        return this.internalConnection.getExplicitCachingEnabled();
    }

    public void purgeImplicitCache() throws SQLException {
        this.internalConnection.purgeImplicitCache();
    }

    public void purgeExplicitCache() throws SQLException {
        this.internalConnection.purgeExplicitCache();
    }

    public PreparedStatement getStatementWithKey(String var1) throws SQLException {
        return this.internalConnection.getStatementWithKey(var1);
    }

    public CallableStatement getCallWithKey(String var1) throws SQLException {
        return this.internalConnection.getCallWithKey(var1);
    }

    public boolean isStatementCacheInitialized() {
        return this.internalConnection.isStatementCacheInitialized();
    }

    public void setTypeMap(Map var1) throws SQLException {
        this.internalConnection.setTypeMap(var1);
    }

    public String getProtocolType() {
        return this.internalConnection.getProtocolType();
    }

    public void setTxnMode(int var1) {
        this.internalConnection.setTxnMode(var1);
    }

    public int getTxnMode() {
        return this.internalConnection.getTxnMode();
    }

    public int getHeapAllocSize() throws SQLException {
        return this.internalConnection.getHeapAllocSize();
    }

    public int getOCIEnvHeapAllocSize() throws SQLException {
        return this.internalConnection.getOCIEnvHeapAllocSize();
    }

    public CLOB createClob(byte[] var1) throws SQLException {
        this.registerHeartbeat();
        return this.internalConnection.createClob(var1);
    }

    public CLOB createClobWithUnpickledBytes(byte[] var1) throws SQLException {
        this.registerHeartbeat();
        return this.internalConnection.createClobWithUnpickledBytes(var1);
    }

    public CLOB createClob(byte[] var1, short var2) throws SQLException {
        this.registerHeartbeat();
        return this.internalConnection.createClob(var1, var2);
    }

    public BLOB createBlob(byte[] var1) throws SQLException {
        this.registerHeartbeat();
        return this.internalConnection.createBlob(var1);
    }

    public BLOB createBlobWithUnpickledBytes(byte[] var1) throws SQLException {
        this.registerHeartbeat();
        return this.internalConnection.createBlobWithUnpickledBytes(var1);
    }

    public BFILE createBfile(byte[] var1) throws SQLException {
        this.registerHeartbeat();
        return this.internalConnection.createBfile(var1);
    }

    public boolean isDescriptorSharable(oracle.jdbc.internal.OracleConnection var1) throws SQLException {
        return this.internalConnection.isDescriptorSharable(var1);
    }

    public OracleStatement refCursorCursorToStatement(int var1) throws SQLException {
        return this.internalConnection.refCursorCursorToStatement(var1);
    }

    public long getTdoCState(String var1, String var2) throws SQLException {
        return this.internalConnection.getTdoCState(var1, var2);
    }

    public long getTdoCState(String var1) throws SQLException {
        return this.internalConnection.getTdoCState(var1);
    }

    public Datum toDatum(CustomDatum var1) throws SQLException {
        return this.internalConnection.toDatum(var1);
    }

    public XAResource getXAResource() throws SQLException {
        return this.pooledConnection.getXAResource();
    }

    public void setApplicationContext(String var1, String var2, String var3) throws SQLException {
        this.internalConnection.setApplicationContext(var1, var2, var3);
    }

    public void clearAllApplicationContext(String var1) throws SQLException {
        this.internalConnection.clearAllApplicationContext(var1);
    }

    /** @deprecated */
    public boolean isV8Compatible() throws SQLException {
        return this.getMapDateToTimestamp();
    }

    public boolean getMapDateToTimestamp() {
        return this.internalConnection.getMapDateToTimestamp();
    }

    public void abort(Executor var1) throws SQLException {
        this.internalConnection.abort(var1);
    }

    public int getNetworkTimeout() throws SQLException {
        return this.internalConnection.getNetworkTimeout();
    }

    public String getSchema() throws SQLException {
        return this.internalConnection.getSchema();
    }

    public void setNetworkTimeout(Executor var1, int var2) throws SQLException {
        this.internalConnection.setNetworkTimeout(var1, var2);
    }

    public void setSchema(String var1) throws SQLException {
        this.internalConnection.setSchema(var1);
    }

    public byte[] createLightweightSession(String var1, KeywordValueLong[] var2, int var3, KeywordValueLong[][] var4, int[] var5) throws SQLException {
        return this.internalConnection.createLightweightSession(var1, var2, var3, var4, var5);
    }

    public void executeLightweightSessionRoundtrip(int var1, byte[] var2, KeywordValueLong[] var3, int var4, KeywordValueLong[][] var5, int[] var6) throws SQLException {
        this.internalConnection.executeLightweightSessionRoundtrip(var1, var2, var3, var4, var5, var6);
    }

    public void executeLightweightSessionPiggyback(int var1, byte[] var2, KeywordValueLong[] var3, int var4) throws SQLException {
        this.internalConnection.executeLightweightSessionPiggyback(var1, var2, var3, var4);
    }

    public void doXSNamespaceOp(XSOperationCode var1, byte[] var2, XSNamespace[] var3, XSNamespace[][] var4, XSSecureId var5) throws SQLException {
        this.internalConnection.doXSNamespaceOp(var1, var2, var3, var4, var5);
    }

    public void doXSNamespaceOp(XSOperationCode var1, byte[] var2, XSNamespace[] var3, XSSecureId var4) throws SQLException {
        this.internalConnection.doXSNamespaceOp(var1, var2, var3, var4);
    }

    public void doXSSessionAttachOp(int var1, byte[] var2, XSSecureId var3, byte[] var4, XSPrincipal var5, String[] var6, String[] var7, String[] var8, XSNamespace[] var9, XSNamespace[] var10, XSNamespace[] var11, TIMESTAMPTZ var12, TIMESTAMPTZ var13, int var14, long var15, XSKeyval var17, int[] var18) throws SQLException {
        this.internalConnection.doXSSessionAttachOp(var1, var2, var3, var4, var5, var6, var7, var8, var9, var10, var11, var12, var13, var14, var15, var17, var18);
    }

    public void doXSSessionChangeOp(XSSessionSetOperationCode var1, byte[] var2, XSSecureId var3, XSSessionParameters var4) throws SQLException {
        this.internalConnection.doXSSessionChangeOp(var1, var2, var3, var4);
    }

    public byte[] doXSSessionCreateOp(XSSessionOperationCode var1, XSSecureId var2, byte[] var3, XSPrincipal var4, String var5, XSNamespace[] var6, XSSessionModeFlag var7, XSKeyval var8) throws SQLException {
        return this.internalConnection.doXSSessionCreateOp(var1, var2, var3, var4, var5, var6, var7, var8);
    }

    public void doXSSessionDestroyOp(byte[] var1, XSSecureId var2, byte[] var3) throws SQLException {
        this.internalConnection.doXSSessionDestroyOp(var1, var2, var3);
    }

    public void doXSSessionDetachOp(int var1, byte[] var2, XSSecureId var3, boolean var4) throws SQLException {
        this.internalConnection.doXSSessionDetachOp(var1, var2, var3, var4);
    }

    public BLOB createTemporaryBlob(Connection var1, boolean var2, int var3) throws SQLException {
        this.registerHeartbeat();
        return this.internalConnection.createTemporaryBlob(var1, var2, var3);
    }

    public CLOB createTemporaryClob(Connection var1, boolean var2, int var3, short var4) throws SQLException {
        this.registerHeartbeat();
        return this.internalConnection.createTemporaryClob(var1, var2, var3, var4);
    }

    public String getDefaultSchemaNameForNamedTypes() throws SQLException {
        return this.internalConnection.getDefaultSchemaNameForNamedTypes();
    }

    public boolean isUsable() {
        return !this.closed && this.internalConnection.isUsable();
    }

    public byte getInstanceProperty(InstanceProperty var1) throws SQLException {
        return this.internalConnection.getInstanceProperty(var1);
    }

    public void setUsable(boolean var1) {
        this.internalConnection.setUsable(var1);
    }

    public int getTimezoneVersionNumber() throws SQLException {
        return this.internalConnection.getTimezoneVersionNumber();
    }

    public TIMEZONETAB getTIMEZONETAB() throws SQLException {
        return this.internalConnection.getTIMEZONETAB();
    }

    public void setPDBChangeEventListener(PDBChangeEventListener var1) throws SQLException {
        this.internalConnection.setPDBChangeEventListener(var1);
    }

    public void setPDBChangeEventListener(PDBChangeEventListener var1, Executor var2) throws SQLException {
        this.internalConnection.setPDBChangeEventListener(var1, var2);
    }

    public void addXSEventListener(XSEventListener var1) throws SQLException {
        this.internalConnection.addXSEventListener(var1);
    }

    public void addXSEventListener(XSEventListener var1, Executor var2) throws SQLException {
        this.internalConnection.addXSEventListener(var1, var2);
    }

    public void removeXSEventListener(XSEventListener var1) throws SQLException {
        this.internalConnection.removeXSEventListener(var1);
    }

    public void removeAllXSEventListener() throws SQLException {
        this.internalConnection.removeAllXSEventListener();
    }

    public BufferCacheStatistics getByteBufferCacheStatistics() {
        return this.internalConnection.getByteBufferCacheStatistics();
    }

    public BufferCacheStatistics getCharBufferCacheStatistics() {
        return this.internalConnection.getCharBufferCacheStatistics();
    }

    public boolean isDataInLocatorEnabled() throws SQLException {
        return this.internalConnection.isDataInLocatorEnabled();
    }

    public boolean isLobStreamPosStandardCompliant() throws SQLException {
        return this.internalConnection.isLobStreamPosStandardCompliant();
    }

    public long getCurrentSCN() throws SQLException {
        return this.internalConnection.getCurrentSCN();
    }

    public EnumSet<TransactionState> getTransactionState() throws SQLException {
        return this.internalConnection.getTransactionState();
    }

    public boolean isConnectionSocketKeepAlive() throws SocketException, SQLException {
        return this.internalConnection.isConnectionSocketKeepAlive();
    }

    public void removeLogicalTransactionIdEventListener(LogicalTransactionIdEventListener var1) throws SQLException {
        this.connection.removeLogicalTransactionIdEventListener(var1);
    }

    public void setReplayOperations(EnumSet<ReplayOperation> var1) throws SQLException {
        this.internalConnection.setReplayOperations(var1);
    }

    public void beginNonRequestCalls() throws SQLException {
        this.internalConnection.beginNonRequestCalls();
    }

    public void endNonRequestCalls() throws SQLException {
        this.internalConnection.endNonRequestCalls();
    }

    public void setReplayContext(ReplayContext[] var1) throws SQLException {
        this.internalConnection.setReplayContext(var1);
    }

    public void registerEndReplayCallback(EndReplayCallback var1) throws SQLException {
        this.internalConnection.registerEndReplayCallback(var1);
    }

    public int getEOC() throws SQLException {
        return this.internalConnection.getEOC();
    }

    public ReplayContext[] getReplayContext() throws SQLException {
        return this.internalConnection.getReplayContext();
    }

    public ReplayContext getLastReplayContext() throws SQLException {
        return this.internalConnection.getLastReplayContext();
    }

    public byte[] getDerivedKeyInternal(byte[] var1, int var2) throws NoSuchAlgorithmException, InvalidKeySpecException, SQLException {
        return this.internalConnection.getDerivedKeyInternal(var1, var2);
    }

    public short getExecutingRPCFunctionCode() {
        return this.internalConnection.getExecutingRPCFunctionCode();
    }

    public String getExecutingRPCSQL() {
        return this.internalConnection.getExecutingRPCSQL();
    }

    public void setReplayingMode(boolean var1) throws SQLException {
        this.internalConnection.setReplayingMode(var1);
    }

    public void jmsEnqueue(String var1, JMSEnqueueOptions var2, JMSMessage var3, AQMessageProperties var4) throws SQLException {
        this.internalConnection.jmsEnqueue(var1, var2, var3, var4);
    }

    public JMSMessage jmsDequeue(String var1, JMSDequeueOptions var2) throws SQLException {
        JMSMessage var3 = this.internalConnection.jmsDequeue(var1, var2);
        return var3;
    }

    public JMSMessage jmsDequeue(String var1, JMSDequeueOptions var2, String var3) throws SQLException {
        JMSMessage var4 = this.internalConnection.jmsDequeue(var1, var2, var3);
        return var4;
    }

    public Map<String, JMSNotificationRegistration> registerJMSNotification(String[] var1, Map<String, Properties> var2) throws SQLException {
        Map var3 = this.internalConnection.registerJMSNotification(var1, var2);
        return var3;
    }

    public void unregisterJMSNotification(JMSNotificationRegistration var1) throws SQLException {
        this.internalConnection.unregisterJMSNotification(var1);
    }

    public void ackJMSNotification(JMSNotificationRegistration var1, byte[] var2, Directive var3) throws SQLException {
        this.internalConnection.ackJMSNotification(var1, var2, var3);
    }

    public boolean isDRCPEnabled() throws SQLException {
        return this.internalConnection.isDRCPEnabled();
    }

    public boolean attachServerConnection() throws SQLException {
        SQLException var1 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 153);
        var1.fillInStackTrace();
        throw var1;
    }

    public void detachServerConnection(String var1) throws SQLException {
        SQLException var2 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 153);
        var2.fillInStackTrace();
        throw var2;
    }

    public boolean needToPurgeStatementCache() throws SQLException {
        SQLException var1 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 153);
        var1.fillInStackTrace();
        throw var1;
    }

    public int getNegotiatedSDU() throws SQLException {
        return this.internalConnection.getNegotiatedSDU();
    }

    public int getVarTypeMaxLenCompat() throws SQLException {
        return this.internalConnection.getVarTypeMaxLenCompat();
    }

    public void setChecksumMode(ChecksumMode var1) throws SQLException {
        this.internalConnection.setChecksumMode(var1);
    }
}
