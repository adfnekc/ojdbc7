//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package oracle.jdbc.internal;

import java.net.SocketException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.EnumSet;
import java.util.Enumeration;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.Executor;
import javax.transaction.xa.XAResource;
import oracle.jdbc.aq.AQMessageProperties;
import oracle.jdbc.internal.JMSNotificationRegistration.Directive;
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

public interface OracleConnection extends oracle.jdbc.OracleConnection, ACProxyable {
    String CONNECTION_PROPERTY_LOGON_CAP = "oracle.jdbc.thinLogonCapability";
    String CONNECTION_PROPERTY_LOGON_CAP_DEFAULT = "o5";
    byte CONNECTION_PROPERTY_LOGON_CAP_ACCESSMODE = 3;
    String CONNECTION_PROPERTY_OCI_DEFAULT_DEFINES = "oracle.jdbc.useOCIDefaultDefines";
    String CONNECTION_PROPERTY_OCI_DEFAULT_DEFINES_DEFAULT = "false";
    byte CONNECTION_PROPERTY_OCI_DEFAULT_DEFINES_ACCESSMODE = 3;
    String CONNECTION_PROPERTY_JMSNOTIFICATION = "oracle.jdbc.jmsNotification";
    String CONNECTION_PROPERTY_JMSNOTIFICATION_DEFAULT = "false";
    byte CONNECTION_PROPERTY_JMSNOTIFICATION_ACCESSMODE = 3;
    String CONNECTION_PROPERTY_NLS_LANG_BACKDOOR = "oracle.jdbc.ociNlsLangBackwardCompatible";
    String CONNECTION_PROPERTY_NLS_LANG_BACKDOOR_DEFAULT = "false";
    byte CONNECTION_PROPERTY_NLS_LANG_BACKDOOR_ACCESSMODE = 3;
    String CONNECTION_PROPERTY_SPAWN_NEW_THREAD_TO_CANCEL = "oracle.jdbc.spawnNewThreadToCancel";
    String CONNECTION_PROPERTY_SPAWN_NEW_THREAD_TO_CANCEL_DEFAULT = "false";
    byte CONNECTION_PROPERTY_SPAWN_NEW_THREAD_TO_CANCEL_ACCESSMODE = 3;
    String CONNECTION_PROPERTY_OVERRIDE_ENABLE_READ_DATA_IN_LOCATOR = "oracle.jdbc.overrideEnableReadDataInLocator";
    String CONNECTION_PROPERTY_OVERRIDE_ENABLE_READ_DATA_IN_LOCATOR_DEFAULT = "false";
    byte CONNECTION_PROPERTY_OVERRIDE_ENABLE_READ_DATA_IN_LOCATOR_ACCESSMODE = 3;
    String CONNECTION_PROPERTY_PERMIT_TIMESTAMP_DATE_MISMATCH = "oracle.jdbc.internal.permitBindDateDefineTimestampMismatch";
    String CONNECTION_PROPERTY_PERMIT_TIMESTAMP_DATE_MISMATCH_DEFAULT = "false";
    byte CONNECTION_PROPERTY_PERMIT_TIMESTAMP_DATE_MISMATCH_ACCESSMODE = 3;
    String CONNECTION_PROPERTY_IGNORE_REPLAY_CTX_FROM_AUTH = "oracle.jdbc.ignoreReplayContextFromAuthentication";
    String CONNECTION_PROPERTY_IGNORE_REPLAY_CTX_FROM_AUTH_DEFAULT = "false";
    byte CONNECTION_PROPERTY_IGNORE_REPLAY_CTX_FROM_AUTH_ACCESSMODE = 1;
    String CONNECTION_PROPERTY_DEFAULT_USE_JAVANETNIO = "oracle.jdbc.javaNetNio";
    String CONNECTION_PROPERTY_DEFAULT_USE_JAVANETNIO_DEFAULT = "false";
    byte CONNECTION_PROPERTY_DEFAULT_USE_JAVANETNIO_ACCESSMODE = 3;
    String CONNECTION_PROPERTY_NS_DIRECT_BUFFER = "oracle.jdbc.nsDirectBuffer";
    String CONNECTION_PROPERTY_NS_DIRECT_BUFFER_DEFAULT = "false";
    byte CONNECTION_PROPERTY_NS_DIRECT_BUFFER_ACCESSMODE = 3;
    String CONNECTION_PROPERTY_PLSQL_VARCHAR_PARAMETER_4K_ONLY = "oracle.jdbc.plsqlVarcharParameter4KOnly";
    String CONNECTION_PROPERTY_PLSQL_VARCHAR_PARAMETER_4K_ONLY_DEFAULT = "false";
    byte CONNECTION_PROPERTY_PLSQL_VARCHAR_PARAMETER_4K_ONLY_ACCESSMODE = 3;
    String CONNECTION_PROPERTY_INSTANCE_NAME = "oracle.jdbc.targetInstanceName";
    String CONNECTION_PROPERTY_INSTANCE_NAME_DEFAULT = null;
    byte CONNECTION_PROPERTY_INSTANCE_NAME_ACCESSMODE = 3;
    String CONNECTION_PROPERTY_ENABLE_OCI_FAST_APPLICATION_NOTIFICATION = "oracle.jdbc.enableOCIFastApplicationNotification";
    String CONNECTION_PROPERTY_ENABLE_OCI_FAST_APPLICATION_NOTIFICATION_DEFAULT = "false";
    byte CONNECTION_PROPERTY_ENABLE_OCI_FAST_APPLICATION_NOTIFICATION_ACCESSMODE = 3;
    int CHAR_TO_ASCII = 0;
    int CHAR_TO_UNICODE = 1;
    int RAW_TO_ASCII = 2;
    int RAW_TO_UNICODE = 3;
    int UNICODE_TO_CHAR = 4;
    int ASCII_TO_CHAR = 5;
    int NONE = 6;
    int JAVACHAR_TO_CHAR = 7;
    int RAW_TO_JAVACHAR = 8;
    int CHAR_TO_JAVACHAR = 9;
    int GLOBAL_TXN = 1;
    int NO_GLOBAL_TXN = 0;
    int VARTYPE_MAXLEN_COMPAT_STANDARD = 1;
    int VARTYPE_MAXLEN_COMPAT_EXTENDED = 2;
    int VARTYPE_MAXLEN_STANDARD_METADATA = 4000;
    int VARTYPE_MAXLEN_STANDARD_BIND = 32766;
    int VARTYPE_MAXLEN_STANDARD_BIND_OUT = 32767;
    int VARTYPE_MAXLEN_STANDARD_BIND_PLSQL_BUG3936526 = 32512;
    int NVARTYPE_MAXLEN_STANDARD_METADATA = 4000;
    int NVARTYPE_MAXLEN_STANDARD_BIND = 32766;
    int RAWTYPE_MAXLEN_STANDARD_METADATA = 2000;
    int RAWTYPE_MAXLEN_STANDARD_BIND_SQL = 4000;
    int RAWTYPE_MAXLEN_STANDARD_BIND_PLSQL = 32766;
    int VARTYPE_MAXLEN_EXTENDED_METADATA = 32767;
    int VARTYPE_MAXLEN_EXTENDED_BIND = 32766;
    int VARTYPE_MAXLEN_EXTENDED_BIND_OUT = 32767;
    int VARTYPE_MAXLEN_STANDARD = 4000;
    int RAWTYPE_MAXLEN_STANDARD = 2000;
    int NVARTYPE_MAXLEN_STANDARD = 4000;
    int VARTYPE_MAXLEN_EXTENDED = 32767;
    int RAWTYPE_MAXLEN_EXTENDED = 32767;
    int NVARTYPE_MAXLEN_EXTENDED = 32766;

    int getVarTypeMaxLenCompat() throws SQLException;

    short getStructAttrNCsId() throws SQLException;

    Map getTypeMap() throws SQLException;

    Properties getDBAccessProperties() throws SQLException;

    Properties getOCIHandles() throws SQLException;

    String getDatabaseProductVersion() throws SQLException;

    String getURL() throws SQLException;

    short getVersionNumber() throws SQLException;

    Map getJavaObjectTypeMap();

    void setJavaObjectTypeMap(Map var1);

    byte getInstanceProperty(OracleConnection.InstanceProperty var1) throws SQLException;

    BfileDBAccess createBfileDBAccess() throws SQLException;

    BlobDBAccess createBlobDBAccess() throws SQLException;

    ClobDBAccess createClobDBAccess() throws SQLException;

    void setDefaultFixedString(boolean var1);

    boolean getDefaultFixedString();

    oracle.jdbc.OracleConnection getWrapper();

    Class classForNameAndSchema(String var1, String var2) throws ClassNotFoundException;

    void setFDO(byte[] var1) throws SQLException;

    byte[] getFDO(boolean var1) throws SQLException;

    boolean getBigEndian() throws SQLException;

    Object getDescriptor(byte[] var1);

    void putDescriptor(byte[] var1, Object var2) throws SQLException;

    OracleConnection getPhysicalConnection();

    void removeDescriptor(String var1);

    void removeAllDescriptor();

    int numberOfDescriptorCacheEntries();

    Enumeration descriptorCacheKeys();

    long getTdoCState(String var1, String var2) throws SQLException;

    long getTdoCState(String var1) throws SQLException;

    OracleConnection.BufferCacheStatistics getByteBufferCacheStatistics();

    OracleConnection.BufferCacheStatistics getCharBufferCacheStatistics();

    Datum toDatum(CustomDatum var1) throws SQLException;

    short getDbCsId() throws SQLException;

    short getJdbcCsId() throws SQLException;

    short getNCharSet();

    ResultSet newArrayDataResultSet(Datum[] var1, long var2, int var4, Map var5) throws SQLException;

    ResultSet newArrayDataResultSet(ARRAY var1, long var2, int var4, Map var5) throws SQLException;

    ResultSet newArrayLocatorResultSet(ArrayDescriptor var1, byte[] var2, long var3, int var5, Map var6) throws SQLException;

    ResultSetMetaData newStructMetaData(StructDescriptor var1) throws SQLException;

    void getForm(OracleTypeADT var1, OracleTypeCLOB var2, int var3) throws SQLException;

    int CHARBytesToJavaChars(byte[] var1, int var2, char[] var3) throws SQLException;

    int NCHARBytesToJavaChars(byte[] var1, int var2, char[] var3) throws SQLException;

    boolean IsNCharFixedWith();

    short getDriverCharSet();

    int getC2SNlsRatio();

    int getMaxCharSize() throws SQLException;

    int getMaxCharbyteSize();

    int getMaxNCharbyteSize();

    boolean isCharSetMultibyte(short var1);

    int javaCharsToCHARBytes(char[] var1, int var2, byte[] var3) throws SQLException;

    int javaCharsToNCHARBytes(char[] var1, int var2, byte[] var3) throws SQLException;

    void setStartTime(long var1) throws SQLException;

    long getStartTime() throws SQLException;

    boolean isStatementCacheInitialized();

    void getPropertyForPooledConnection(OraclePooledConnection var1) throws SQLException;

    void setTypeMap(Map var1) throws SQLException;

    String getProtocolType();

    Connection getLogicalConnection(OraclePooledConnection var1, boolean var2) throws SQLException;

    void setTxnMode(int var1);

    int getTxnMode();

    int getHeapAllocSize() throws SQLException;

    int getOCIEnvHeapAllocSize() throws SQLException;

    void setAbandonedTimeoutEnabled(boolean var1) throws SQLException;

    int getHeartbeatNoChangeCount() throws SQLException;

    void closeInternal(boolean var1) throws SQLException;

    void cleanupAndClose(boolean var1) throws SQLException;

    OracleConnectionCacheCallback getConnectionCacheCallbackObj() throws SQLException;

    Object getConnectionCacheCallbackPrivObj() throws SQLException;

    int getConnectionCacheCallbackFlag() throws SQLException;

    Properties getServerSessionInfo() throws SQLException;

    CLOB createClob(byte[] var1) throws SQLException;

    CLOB createClobWithUnpickledBytes(byte[] var1) throws SQLException;

    CLOB createClob(byte[] var1, short var2) throws SQLException;

    BLOB createBlob(byte[] var1) throws SQLException;

    BLOB createBlobWithUnpickledBytes(byte[] var1) throws SQLException;

    BFILE createBfile(byte[] var1) throws SQLException;

    boolean isDescriptorSharable(OracleConnection var1) throws SQLException;

    OracleStatement refCursorCursorToStatement(int var1) throws SQLException;

    XAResource getXAResource() throws SQLException;

    /** @deprecated */
    boolean isV8Compatible() throws SQLException;

    boolean getMapDateToTimestamp();

    byte[] createLightweightSession(String var1, KeywordValueLong[] var2, int var3, KeywordValueLong[][] var4, int[] var5) throws SQLException;

    void executeLightweightSessionPiggyback(int var1, byte[] var2, KeywordValueLong[] var3, int var4) throws SQLException;

    void doXSNamespaceOp(OracleConnection.XSOperationCode var1, byte[] var2, XSNamespace[] var3, XSNamespace[][] var4, XSSecureId var5) throws SQLException;

    void doXSNamespaceOp(OracleConnection.XSOperationCode var1, byte[] var2, XSNamespace[] var3, XSSecureId var4) throws SQLException;

    byte[] doXSSessionCreateOp(OracleConnection.XSSessionOperationCode var1, XSSecureId var2, byte[] var3, XSPrincipal var4, String var5, XSNamespace[] var6, OracleConnection.XSSessionModeFlag var7, XSKeyval var8) throws SQLException;

    void doXSSessionDestroyOp(byte[] var1, XSSecureId var2, byte[] var3) throws SQLException;

    void doXSSessionAttachOp(int var1, byte[] var2, XSSecureId var3, byte[] var4, XSPrincipal var5, String[] var6, String[] var7, String[] var8, XSNamespace[] var9, XSNamespace[] var10, XSNamespace[] var11, TIMESTAMPTZ var12, TIMESTAMPTZ var13, int var14, long var15, XSKeyval var17, int[] var18) throws SQLException;

    void doXSSessionDetachOp(int var1, byte[] var2, XSSecureId var3, boolean var4) throws SQLException;

    void doXSSessionChangeOp(OracleConnection.XSSessionSetOperationCode var1, byte[] var2, XSSecureId var3, XSSessionParameters var4) throws SQLException;

    String getDefaultSchemaNameForNamedTypes() throws SQLException;

    void setUsable(boolean var1);

    Class getClassForType(String var1, Map<String, Class> var2);

    void addXSEventListener(XSEventListener var1) throws SQLException;

    void addXSEventListener(XSEventListener var1, Executor var2) throws SQLException;

    void removeXSEventListener(XSEventListener var1) throws SQLException;

    int getTimezoneVersionNumber() throws SQLException;

    void removeAllXSEventListener() throws SQLException;

    TIMEZONETAB getTIMEZONETAB() throws SQLException;

    String getDatabaseTimeZone() throws SQLException;

    boolean getTimestamptzInGmt();

    boolean getUse1900AsYearForTime();

    boolean isDataInLocatorEnabled() throws SQLException;

    boolean isLobStreamPosStandardCompliant() throws SQLException;

    long getCurrentSCN() throws SQLException;

    EnumSet<OracleConnection.TransactionState> getTransactionState() throws SQLException;

    boolean isConnectionSocketKeepAlive() throws SocketException, SQLException;

    void setReplayOperations(EnumSet<OracleConnection.ReplayOperation> var1) throws SQLException;

    void setReplayingMode(boolean var1) throws SQLException;

    void beginNonRequestCalls() throws SQLException;

    void endNonRequestCalls() throws SQLException;

    void setReplayContext(ReplayContext[] var1) throws SQLException;

    ReplayContext[] getReplayContext() throws SQLException;

    ReplayContext getLastReplayContext() throws SQLException;

    void registerEndReplayCallback(OracleConnection.EndReplayCallback var1) throws SQLException;

    int getEOC() throws SQLException;

    byte[] getDerivedKeyInternal(byte[] var1, int var2) throws NoSuchAlgorithmException, InvalidKeySpecException, SQLException;

    short getExecutingRPCFunctionCode();

    String getExecutingRPCSQL();

    void jmsEnqueue(String var1, JMSEnqueueOptions var2, JMSMessage var3, AQMessageProperties var4) throws SQLException;

    JMSMessage jmsDequeue(String var1, JMSDequeueOptions var2) throws SQLException;

    /** @deprecated */
    JMSMessage jmsDequeue(String var1, JMSDequeueOptions var2, String var3) throws SQLException;

    Map<String, JMSNotificationRegistration> registerJMSNotification(String[] var1, Map<String, Properties> var2) throws SQLException;

    void unregisterJMSNotification(JMSNotificationRegistration var1) throws SQLException;

    void ackJMSNotification(JMSNotificationRegistration var1, byte[] var2, Directive var3) throws SQLException;

    int getNegotiatedSDU() throws SQLException;

    void setPDBChangeEventListener(PDBChangeEventListener var1) throws SQLException;

    void setPDBChangeEventListener(PDBChangeEventListener var1, Executor var2) throws SQLException;

    void setChecksumMode(OracleConnection.ChecksumMode var1) throws SQLException;

    public static enum ChecksumMode {
        NO_CHECKSUM(false, false),
        CALCULATE_CHECKSUM_FETCH(true, false),
        CALCULATE_CHECKSUM_BINDS(false, true),
        CALCULATE_CHECKSUM_ALL(true, true);

        private boolean fetchChecksum;
        private boolean bindChecksum;

        private ChecksumMode(boolean var3, boolean var4) {
            this.fetchChecksum = var3;
            this.bindChecksum = var4;
        }

        public boolean needToCalculateFetchChecksum() {
            return this.fetchChecksum;
        }

        public boolean needToCalculateBindChecksum() {
            return this.bindChecksum;
        }
    }

    public interface EndReplayCallback {
        void executeCallback() throws SQLException;
    }

    public static enum ReplayOperation {
        KPDSS_SESSSTATE_APPCONT_ENABLED(1L),
        KPDSS_SESSSTATE_STATIC(2L),
        KPDSS_SESSSTATE_REQUEST_BEGIN(4L),
        KPDSS_SESSSTATE_REQUEST_END(8L),
        KPDSS_SESSSTATE_NONREQUEST_CALL(16L);

        private final long code;

        private ReplayOperation(long var3) {
            this.code = var3;
        }

        public final long getCode() {
            return this.code;
        }
    }

    public interface BufferCacheStatistics {
        int getId();

        int[] getBufferSizes();

        int getCacheHits(int var1);

        int getCacheMisses(int var1);

        int getBuffersCached(int var1);

        int getBucketsFull(int var1);

        int getReferencesCleared(int var1);

        int getTooBigToCache();
    }

    public static enum XSSessionSetOperationCode {
        SESSION_SET_COOKIE(1),
        SESSION_SET_TIMEOUT(2),
        SESSION_REAUTH(3),
        SESSION_ENABLE_ROLE(4),
        SESSION_DISABLE_ROLE(5);

        private final int code;

        private XSSessionSetOperationCode(int var3) {
            this.code = var3;
        }

        public final int getCode() {
            return this.code;
        }
    }

    public static enum XSSessionModeFlag {
        SECURE(0),
        TRUSTED(1);

        private final int code;

        private XSSessionModeFlag(int var3) {
            this.code = var3;
        }

        public final int getCode() {
            return this.code;
        }
    }

    public static enum XSSessionOperationCode {
        SESSION_CREATE(1);

        private final int code;

        private XSSessionOperationCode(int var3) {
            this.code = var3;
        }

        public final int getCode() {
            return this.code;
        }
    }

    public static enum XSOperationCode {
        NAMESPACE_CREATE(1),
        NAMESPACE_DELETE(2),
        ATTRIBUTE_CREATE(3),
        ATTRIBUTE_SET(4),
        ATTRIBUTE_DELETE(5),
        ATTRIBUTE_RESET(6),
        NAMESPACE_GET(7),
        ATTRIBUTE_GET(8);

        private final int code;

        private XSOperationCode(int var3) {
            this.code = var3;
        }

        public final int getCode() {
            return this.code;
        }
    }

    public static enum TransactionState {
        TRANSACTION_STARTED,
        TRANSACTION_ENDED,
        TRANSACTION_READONLY,
        TRANSACTION_INTENTION;

        private TransactionState() {
        }
    }

    public static enum InstanceProperty {
        ASM_VOLUME_SUPPORTED,
        INSTANCE_TYPE;

        private InstanceProperty() {
        }
    }
}
