//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package oracle.jdbc.driver;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.security.AccessController;
import java.security.NoSuchAlgorithmException;
import java.security.PrivilegedAction;
import java.security.spec.InvalidKeySpecException;
import java.sql.Array;
import java.sql.Blob;
import java.sql.CallableStatement;
import java.sql.ClientInfoStatus;
import java.sql.Clob;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.NClob;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLClientInfoException;
import java.sql.SQLException;
import java.sql.SQLPermission;
import java.sql.SQLWarning;
import java.sql.SQLXML;
import java.sql.Savepoint;
import java.sql.Statement;
import java.sql.Struct;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.EnumSet;
import java.util.Enumeration;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.TimeZone;
import java.util.Vector;
import java.util.concurrent.Executor;
import java.util.regex.Pattern;
import javax.transaction.xa.XAResource;
import oracle.jdbc.LogicalTransactionIdEventListener;
import oracle.jdbc.OracleDatabaseMetaData;
import oracle.jdbc.OracleOCIFailover;
import oracle.jdbc.OracleSQLPermission;
import oracle.jdbc.OracleSavepoint;
import oracle.jdbc.OracleConnection.CommitOption;
import oracle.jdbc.OracleConnection.DatabaseShutdownMode;
import oracle.jdbc.OracleConnection.DatabaseStartupMode;
import oracle.jdbc.aq.AQDequeueOptions;
import oracle.jdbc.aq.AQEnqueueOptions;
import oracle.jdbc.aq.AQMessage;
import oracle.jdbc.aq.AQMessageProperties;
import oracle.jdbc.aq.AQNotificationRegistration;
import oracle.jdbc.dcn.DatabaseChangeRegistration;
import oracle.jdbc.driver.BlockSource.Implementation;
import oracle.jdbc.driver.OracleResultSet.ResultSetType;
import oracle.jdbc.internal.JMSDequeueOptions;
import oracle.jdbc.internal.JMSEnqueueOptions;
import oracle.jdbc.internal.JMSFactory;
import oracle.jdbc.internal.JMSMessage;
import oracle.jdbc.internal.JMSMessageProperties;
import oracle.jdbc.internal.JMSNotificationRegistration;
import oracle.jdbc.internal.KeywordValueLong;
import oracle.jdbc.internal.PDBChangeEventListener;
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
import oracle.jdbc.internal.OracleStatement.SqlKind;
import oracle.jdbc.oracore.OracleTypeADT;
import oracle.jdbc.oracore.OracleTypeCLOB;
import oracle.jdbc.oracore.Util;
import oracle.jdbc.pool.OracleConnectionCacheCallback;
import oracle.jdbc.pool.OraclePooledConnection;
import oracle.net.nt.CustomSSLSocketFactory;
import oracle.security.pki.OracleSecretStore;
import oracle.security.pki.OracleWallet;
import oracle.sql.ARRAY;
import oracle.sql.ArrayDescriptor;
import oracle.sql.BFILE;
import oracle.sql.BINARY_DOUBLE;
import oracle.sql.BINARY_FLOAT;
import oracle.sql.BLOB;
import oracle.sql.BfileDBAccess;
import oracle.sql.BlobDBAccess;
import oracle.sql.CLOB;
import oracle.sql.CharacterSet;
import oracle.sql.ClobDBAccess;
import oracle.sql.CustomDatum;
import oracle.sql.DATE;
import oracle.sql.Datum;
import oracle.sql.INTERVALDS;
import oracle.sql.INTERVALYM;
import oracle.sql.NCLOB;
import oracle.sql.NUMBER;
import oracle.sql.SQLName;
import oracle.sql.STRUCT;
import oracle.sql.StructDescriptor;
import oracle.sql.TIMESTAMP;
import oracle.sql.TIMESTAMPLTZ;
import oracle.sql.TIMESTAMPTZ;
import oracle.sql.TIMEZONETAB;
import oracle.sql.TypeDescriptor;
import oracle.xdb.XMLType;

abstract class PhysicalConnection extends OracleConnection {
    public static final String SECRET_STORE_CONNECT = "oracle.security.client.connect_string";
    public static final String SECRET_STORE_USERNAME = "oracle.security.client.username";
    public static final String SECRET_STORE_PASSWORD = "oracle.security.client.password";
    public static final String SECRET_STORE_DEFAULT_USERNAME = "oracle.security.client.default_username";
    public static final String SECRET_STORE_DEFAULT_PASSWORD = "oracle.security.client.default_password";
    static final CRC64 CHECKSUM = new CRC64();
    public static final char slash_character = '/';
    public static final char at_sign_character = '@';
    public static final char left_square_bracket_character = '[';
    public static final char right_square_bracket_character = ']';
    static final byte[] EMPTY_BYTE_ARRAY = new byte[0];
    static final char[] EMPTY_CHAR_ARRAY = new char[0];
    static final int STREAM_CHUNK_SIZE = 32768;
    long outScn = 0L;
    char[][] charOutput = new char[1][];
    byte[][] byteOutput = new byte[1][];
    short[][] shortOutput = new short[1][];
    Properties sessionProperties = null;
    private static final String[] END_TO_END_CLIENTINFO_KEYS = new String[]{"OCSID.ACTION", "OCSID.CLIENTID", "OCSID.ECID", "OCSID.MODULE", "OCSID.DBOP"};
    private static final String END_TO_END_CLIENTINFO_KEY_SEQ_NO = "OCSID.SEQUENCE_NUMBER";
    boolean retainV9BindBehavior;
    String userName;
    String database;
    boolean defaultautocommit;
    String protocol;
    int streamChunkSize;
    boolean setFloatAndDoubleUseBinary;
    String ocidll;
    String thinVsessionTerminal;
    String thinVsessionMachine;
    String thinVsessionOsuser;
    String thinVsessionProgram;
    String thinVsessionProcess;
    String thinVsessionIname;
    String thinVsessionEname;
    String thinNetProfile;
    String thinNetAuthenticationServices;
    String thinNetAuthenticationKrb5Mutual;
    String thinNetAuthenticationKrb5CcName;
    String thinNetEncryptionLevel;
    String thinNetEncryptionTypes;
    String thinNetChecksumLevel;
    String thinNetChecksumTypes;
    String thinNetCryptoSeed;
    boolean thinTcpNoDelay;
    String thinReadTimeout;
    String thinNetConnectTimeout;
    boolean thinNetDisableOutOfBandBreak;
    boolean thinNetUseZeroCopyIO;
    boolean use1900AsYearForTime;
    boolean timestamptzInGmt;
    boolean timezoneAsRegion;
    String thinSslServerDnMatch;
    String thinSslVersion;
    String thinSslCipherSuites;
    String thinJavaxNetSslKeystore;
    String thinJavaxNetSslKeystoretype;
    String thinJavaxNetSslKeystorepassword;
    String thinJavaxNetSslTruststore;
    String thinJavaxNetSslTruststoretype;
    String thinJavaxNetSslTruststorepassword;
    String thinSslKeymanagerfactoryAlgorithm;
    String thinSslTrustmanagerfactoryAlgorithm;
    String thinNetOldsyntax;
    String thinNamingContextInitial;
    String thinNamingProviderUrl;
    String thinNamingSecurityAuthentication;
    String thinNamingSecurityPrincipal;
    String thinNamingSecurityCredentials;
    String thinJndiLdapConnectTimeout;
    String thinJndiLdapReadTimeout;
    String walletLocation;
    String walletPassword;
    String proxyClientName;
    boolean useNio;
    String ociDriverCharset;
    String editionName;
    String logonCap;
    boolean useOCIDefaultDefines;
    String internalLogon;
    boolean createDescriptorUseCurrentSchemaForSchemaName;
    long ociSvcCtxHandle;
    long ociEnvHandle;
    long ociErrHandle;
    boolean prelimAuth;
    boolean jmsNotificationConnection;
    boolean nlsLangBackdoor;
    String setNewPassword;
    boolean spawnNewThreadToCancel;
    int defaultExecuteBatch;
    int defaultRowPrefetch;
    int defaultLobPrefetchSize;
    boolean enableDataInLocator;
    boolean enableReadDataInLocator;
    boolean overrideEnableReadDataInLocator;
    boolean reportRemarks;
    boolean includeSynonyms;
    boolean restrictGettables;
    boolean accumulateBatchResult;
    boolean useFetchSizeWithLongColumn;
    boolean processEscapes;
    boolean fixedString;
    boolean defaultnchar;
    boolean permitTimestampDateMismatch;
    String resourceManagerId;
    boolean disableDefinecolumntype;
    boolean convertNcharLiterals;
    boolean autoCommitSpecCompliant;
    boolean j2ee13Compliant;
    boolean mapDateToTimestamp;
    boolean useThreadLocalBufferCache;
    String driverNameAttribute;
    int maxCachedBufferSize;
    int implicitStatementCacheSize;
    boolean lobStreamPosStandardCompliant;
    boolean isStrictAsciiConversion;
    String drcpConnectionClass;
    String drcpTagName;
    String blockSourceImpl;
    boolean thinForceDnsLoadBalancing;
    boolean enableTempLobRefCnt;
    boolean keepAlive;
    String sqlTranslationProfile;
    String sqlErrorTranslationFile;
    boolean ignoreReplayContextFromAuthentication;
    boolean javaNetNio;
    boolean nsDirectBuffer;
    boolean plsqlVarcharParameter4KOnly;
    String targetInstanceName;
    boolean enableOCIFAN;
    public ChecksumMode checksumMode;
    boolean isPDBChanged;
    boolean autocommit;
    String url;
    String savedUser;
    int commitOption;
    int ociConnectionPoolMinLimit = 0;
    int ociConnectionPoolMaxLimit = 0;
    int ociConnectionPoolIncrement = 0;
    int ociConnectionPoolTimeout = 0;
    boolean ociConnectionPoolNoWait = false;
    boolean ociConnectionPoolTransactionDistributed = false;
    String ociConnectionPoolLogonMode = null;
    boolean ociConnectionPoolIsPooling = false;
    Object ociConnectionPoolObject = null;
    Object ociConnectionPoolConnID = null;
    String ociConnectionPoolProxyType = null;
    Integer ociConnectionPoolProxyNumRoles = 0;
    Object ociConnectionPoolProxyRoles = null;
    String ociConnectionPoolProxyUserName = null;
    String ociConnectionPoolProxyPassword = null;
    String ociConnectionPoolProxyDistinguishedName = null;
    Object ociConnectionPoolProxyCertificate = null;
    static NTFManager ntfManager = new NTFManager();
    public int protocolId = -3;
    OracleTimeout timeout;
    DBConversion conversion;
    boolean xaWantsError;
    boolean usingXA;
    int txnMode = 0;
    byte[] fdo;
    Boolean bigEndian;
    OracleStatement statements;
    int lifecycle;
    static final int OPEN = 1;
    static final int CLOSING = 2;
    static final int CLOSED = 4;
    static final int ABORTED = 8;
    static final int BLOCKED = 16;
    boolean clientIdSet = false;
    String clientId = null;
    int txnLevel;
    Map map;
    Map javaObjectMap;
    final Hashtable[] descriptorCacheStack = new Hashtable[2];
    int dci = 0;
    OracleStatement statementHoldingLine;
    OracleDatabaseMetaData databaseMetaData = null;
    LogicalConnection logicalConnectionAttached;
    boolean isProxy = false;
    OracleSql sqlObj = null;
    SQLWarning sqlWarning = null;
    boolean readOnly = false;
    LRUStatementCache statementCache = null;
    boolean clearStatementMetaData = false;
    OracleCloseCallback closeCallback = null;
    Object privateData = null;
    Statement savepointStatement = null;
    boolean isUsable = true;
    TimeZone defaultTimeZone = null;
    static final int END_TO_END_DBOP_INDEX = 4;
    static final int END_TO_END_STATE_INDEX_MAX_POST_1200 = 5;
    final int[] endToEndMaxLength = new int[5];
    boolean endToEndAnyChanged = false;
    final boolean[] endToEndHasChanged = new boolean[5];
    short endToEndECIDSequenceNumber = -32768;
    static final int DMS_NONE = 0;
    static final int DMS_10G = 1;
    static final int DMS_11 = 2;
    String[] endToEndValues = new String[5];
    final int whichDMS = 0;
    oracle.jdbc.OracleConnection wrapper = null;
    int minVcsBindSize;
    int maxRawBytesSql;
    int maxRawBytesPlsql;
    int maxVcsCharsSql;
    int maxVcsNCharsSql;
    int maxVcsBytesPlsql;
    int maxVcsBytesPlsqlOut;
    int maxIbtVarcharElementLength;
    int maxVarcharLength;
    int maxNVarcharLength;
    int maxRawLength;
    String instanceName = null;
    String dbName = null;
    OracleDriverExtension driverExtension;
    static final String uninitializedMarker = "";
    String databaseProductVersion = "";
    short versionNumber = -1;
    int namedTypeAccessorByteLen;
    int refTypeAccessorByteLen;
    CharacterSet setCHARCharSetObj;
    CharacterSet setCHARNCharSetObj;
    protected final Object cancelInProgressLockForThin;
    boolean plsqlCompilerWarnings = false;
    private boolean savedAutoCommitFlag;
    private int savedTxnMode;
    private BlockSource blockSource;
    int thinACLastLtxidHash = 0;
    LogicalTransactionId thinACCurrentLTXID;
    ReplayContext[] thinACReplayContextReceived = new ReplayContext[10];
    int thinACReplayContextReceivedCurrent = 0;
    ReplayContext thinACLastReplayContextReceived = null;
    PhysicalConnection.DrcpState drcpState;
    boolean currentlyInTransaction;
    boolean drcpEnabled;
    private static final Pattern driverNameAttributePattern = Pattern.compile("[\\x20-\\x7e]{0,8}");
    static final String CONNECT_DATA_KEYWORD = "CONNECT_DATA";
    private static final OracleSQLPermission CALL_ORACLE_ABORT_PERMISSION = new OracleSQLPermission("callAbort");
    static final String DATABASE_NAME = "DATABASE_NAME";
    static final String SERVER_HOST = "SERVER_HOST";
    static final String INSTANCE_NAME = "INSTANCE_NAME";
    static final String SERVICE_NAME = "SERVICE_NAME";
    Hashtable clientData;
    private PhysicalConnection.BufferCacheStore connectionBufferCacheStore;
    private static ThreadLocal<PhysicalConnection.BufferCacheStore> threadLocalBufferCacheStore;
    private int pingResult;
    String sessionTimeZone;
    String databaseTimeZone;
    Calendar dbTzCalendar;
    static final String SETCLIENTINFO_PERMISSION_NAME = "clientInfo.";
    static final List<String> RESERVED_NAMESPACES = Arrays.asList("SYS");
    static final Pattern SUPPORTED_NAME_PATTERN = Pattern.compile("\\w+\\.\\w+");
    protected final Properties clientInfo;
    private short lastEndToEndSequenceNumber;
    static final String RAW_STR = "RAW";
    static final String SYS_RAW_STR = "SYS.RAW";
    static final String SYS_ANYDATA_STR = "SYS.ANYDATA";
    static final String SYS_XMLTYPE_STR = "SYS.XMLTYPE";
    int timeZoneVersionNumber;
    TIMEZONETAB timeZoneTab;
    private static final SQLPermission CALL_ABORT_PERMISSION = new SQLPermission("callAbort");
    private static final SQLPermission CALL_SETNETWORKTIMEOUT_PERMISSION = new SQLPermission("setNetworkTimeout");
    private Executor closeExecutor;
    int varTypeMaxLenCompat;
    private static final String _Copyright_2007_Oracle_All_Rights_Reserved_ = null;
    public static final String BUILD_DATE = "Thu_Apr_04_15:09:24_PDT_2013";
    public static final boolean TRACE = false;

    protected BlockSource setBlockSource() {
        return BlockSource.createBlockSource(this.useThreadLocalBufferCache, Implementation.THREADED);
    }

    protected PhysicalConnection() {
        this.drcpState = PhysicalConnection.DrcpState.STATELESS;
        this.currentlyInTransaction = false;
        this.drcpEnabled = false;
        this.sessionTimeZone = null;
        this.databaseTimeZone = null;
        this.dbTzCalendar = null;
        this.clientInfo = new Properties();
        this.lastEndToEndSequenceNumber = -1;
        this.timeZoneVersionNumber = -1;
        this.timeZoneTab = null;
        this.closeExecutor = null;
        this.varTypeMaxLenCompat = 0;
        this.cancelInProgressLockForThin = new Object();
    }

    PhysicalConnection(String var1, Properties var2, OracleDriverExtension var3) throws SQLException {
        this.drcpState = PhysicalConnection.DrcpState.STATELESS;
        this.currentlyInTransaction = false;
        this.drcpEnabled = false;
        this.sessionTimeZone = null;
        this.databaseTimeZone = null;
        this.dbTzCalendar = null;
        this.clientInfo = new Properties();
        this.lastEndToEndSequenceNumber = -1;
        this.timeZoneVersionNumber = -1;
        this.timeZoneTab = null;
        this.closeExecutor = null;
        this.varTypeMaxLenCompat = 0;
        this.cancelInProgressLockForThin = new Object();
        this.readConnectionProperties(var1, var2);
        this.driverExtension = var3;
        this.blockSource = this.setBlockSource();
        this.initialize((Hashtable)null, (Map)null, (Map)null);
        this.additionalInitialization();
        this.logicalConnectionAttached = null;

        try {
            this.needLine();
            if (this.drcpConnectionClass != null && this.url.matches("(?i)(.*\\(SERVER=POOLED\\).*)|(.*:POOLED)")) {
                this.drcpConnectionClass = this.drcpConnectionClass.trim();
                this.drcpEnabled = this.drcpConnectionClass.length() > 0;
            }

            this.logon();
            if (this.drcpEnabled) {
                this.drcpState = PhysicalConnection.DrcpState.STATEFUL;
            }

            this.setAutoCommit(this.autocommit);
            short var4 = this.getVersionNumber();
            if (var4 >= 12100) {
                this.endToEndMaxLength[4] = 64;
            }

            if (var4 >= 11202) {
                this.endToEndMaxLength[0] = 64;
                this.endToEndMaxLength[1] = 64;
                this.endToEndMaxLength[2] = 64;
                this.endToEndMaxLength[3] = 64;
            } else if (var4 >= 11000) {
                this.endToEndMaxLength[0] = 32;
                this.endToEndMaxLength[1] = 64;
                this.endToEndMaxLength[2] = 64;
                this.endToEndMaxLength[3] = 48;
            } else if (var4 >= 10000) {
                this.endToEndMaxLength[0] = 32;
                this.endToEndMaxLength[1] = 64;
                this.endToEndMaxLength[2] = 64;
                this.endToEndMaxLength[3] = 48;
            } else {
                this.endToEndMaxLength[0] = 32;
                this.endToEndMaxLength[1] = 64;
                this.endToEndMaxLength[2] = 64;
                this.endToEndMaxLength[3] = 48;
            }

            if (var4 >= 12000 & this.varTypeMaxLenCompat == 2) {
                this.minVcsBindSize = 32766;
                this.maxRawBytesSql = 32766;
                this.maxRawBytesPlsql = 32766;
                this.maxVcsCharsSql = 32766;
                this.maxVcsNCharsSql = 32766;
                this.maxVcsBytesPlsql = 32766;
                this.maxVcsBytesPlsqlOut = 32767;
                this.maxIbtVarcharElementLength = 32766;
                this.maxVarcharLength = 32767;
                this.maxNVarcharLength = 32766;
                this.maxRawLength = 32767;
            } else if (var4 >= 11202) {
                this.minVcsBindSize = 4001;
                this.maxRawBytesSql = 4000;
                this.maxRawBytesPlsql = 32766;
                this.maxVcsCharsSql = 32766;
                this.maxVcsNCharsSql = 32766;
                this.maxVcsBytesPlsql = 32766;
                this.maxVcsBytesPlsqlOut = 32767;
                this.maxIbtVarcharElementLength = 32766;
                this.maxVarcharLength = 4000;
                this.maxNVarcharLength = 4000;
                this.maxRawLength = 2000;
            } else if (var4 >= 11000) {
                this.minVcsBindSize = 4001;
                this.maxRawBytesSql = 4000;
                this.maxRawBytesPlsql = 32766;
                this.maxVcsCharsSql = 32766;
                this.maxVcsNCharsSql = 32766;
                this.maxVcsBytesPlsql = 32766;
                this.maxVcsBytesPlsqlOut = 32767;
                this.maxIbtVarcharElementLength = 32766;
                this.maxVarcharLength = 4000;
                this.maxNVarcharLength = 4000;
                this.maxRawLength = 2000;
            } else if (var4 >= 10000) {
                this.minVcsBindSize = 4001;
                this.maxRawBytesSql = 4000;
                this.maxRawBytesPlsql = 32512;
                this.maxVcsCharsSql = 32766;
                this.maxVcsNCharsSql = 32766;
                this.maxVcsBytesPlsql = 32512;
                this.maxVcsBytesPlsqlOut = 32512;
                this.maxIbtVarcharElementLength = 32766;
                this.maxVarcharLength = 4000;
                this.maxNVarcharLength = 4000;
                this.maxRawLength = 2000;
            }

            this.initializeSetCHARCharSetObjs();
            if (this.implicitStatementCacheSize > 0) {
                this.setStatementCacheSize(this.implicitStatementCacheSize);
                this.setImplicitCachingEnabled(true);
            }
        } catch (SQLException var7) {
            this.lifecycle = 2;

            try {
                this.logoff();
            } catch (SQLException var6) {
            }

            this.lifecycle = 4;
            throw var7;
        }

        this.txnMode = 0;
    }

    int getMaxSizeForVarchar(SqlKind var1, int var2, boolean var3) throws SQLException {
        boolean var4 = false;
        int var5;
        if (var1 == SqlKind.PLSQL_BLOCK) {
            if (var2 > 0) {
                var5 = Math.max(this.maxVcsBytesPlsql, var2);
            } else if (var3) {
                var5 = 4000;
            } else {
                var5 = this.maxVcsBytesPlsqlOut;
            }
        } else {
            var5 = this.maxVarcharLength;
        }

        return var5;
    }

    void additionalInitialization() throws SQLException {
    }

    private static final String propertyVariableName(String var0) {
        char[] var1 = new char[var0.length()];
        var0.getChars(0, var0.length(), var1, 0);
        String var2 = "";

        for(int var3 = 0; var3 < var1.length; ++var3) {
            if (Character.isUpperCase(var1[var3])) {
                var2 = var2 + "_";
            }

            var2 = var2 + Character.toUpperCase(var1[var3]);
        }

        return var2;
    }

    private void initializeUserDefaults(Properties var1) {
        Iterator var2 = OracleDriver.DEFAULT_CONNECTION_PROPERTIES.stringPropertyNames().iterator();

        while(var2.hasNext()) {
            String var3 = (String)var2.next();
            if (!var1.containsKey(var3)) {
                var1.setProperty(var3, OracleDriver.DEFAULT_CONNECTION_PROPERTIES.getProperty(var3));
            }
        }

    }

    private void readConnectionProperties(String var1, Properties var2) throws SQLException {
        this.initializeUserDefaults(var2);
        String var3 = null;
        var3 = null;
        if (var2 != null) {
            var3 = var2.getProperty("oracle.jdbc.RetainV9LongBindBehavior");
        }

        if (var3 == null) {
            var3 = getSystemProperty("oracle.jdbc.RetainV9LongBindBehavior", (String)null);
        }

        if (var3 == null) {
            var3 = "false";
        }

        this.retainV9BindBehavior = var3 != null && var3.equalsIgnoreCase("true");
        var3 = null;
        if (var2 != null) {
            var3 = var2.getProperty("user");
            if (var3 == null) {
                var3 = var2.getProperty("oracle.jdbc.user");
            }
        }

        if (var3 == null) {
            var3 = getSystemProperty("oracle.jdbc.user", (String)null);
        }

        if (var3 == null) {
            var3 = null;
        }

        this.userName = var3;
        var3 = null;
        if (var2 != null) {
            var3 = var2.getProperty("database");
            if (var3 == null) {
                var3 = var2.getProperty("oracle.jdbc.database");
            }
        }

        if (var3 == null) {
            var3 = getSystemProperty("oracle.jdbc.database", (String)null);
        }

        if (var3 == null) {
            var3 = null;
        }

        this.database = var3;
        var3 = null;
        if (var2 != null) {
            var3 = var2.getProperty("autoCommit");
            if (var3 == null) {
                var3 = var2.getProperty("oracle.jdbc.autoCommit");
            }
        }

        if (var3 == null) {
            var3 = getSystemProperty("oracle.jdbc.autoCommit", (String)null);
        }

        if (var3 == null) {
            var3 = "true";
        }

        this.defaultautocommit = var3 != null && var3.equalsIgnoreCase("true");
        var3 = null;
        if (var2 != null) {
            var3 = var2.getProperty("protocol");
            if (var3 == null) {
                var3 = var2.getProperty("oracle.jdbc.protocol");
            }
        }

        if (var3 == null) {
            var3 = getSystemProperty("oracle.jdbc.protocol", (String)null);
        }

        if (var3 == null) {
            var3 = null;
        }

        this.protocol = var3;
        var3 = null;
        if (var2 != null) {
            var3 = var2.getProperty("oracle.jdbc.StreamChunkSize");
        }

        if (var3 == null) {
            var3 = getSystemProperty("oracle.jdbc.StreamChunkSize", (String)null);
        }

        if (var3 == null) {
            var3 = "32767";
        }

        SQLException var5;
        try {
            this.streamChunkSize = Integer.parseInt(var3);
        } catch (NumberFormatException var18) {
            var5 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 190, "Property is 'streamChunkSize'");
            var5.fillInStackTrace();
            throw var5;
        }

        var3 = null;
        if (var2 != null) {
            var3 = var2.getProperty("SetFloatAndDoubleUseBinary");
            if (var3 == null) {
                var3 = var2.getProperty("oracle.jdbc.SetFloatAndDoubleUseBinary");
            }
        }

        if (var3 == null) {
            var3 = getSystemProperty("oracle.jdbc.SetFloatAndDoubleUseBinary", (String)null);
        }

        if (var3 == null) {
            var3 = "false";
        }

        this.setFloatAndDoubleUseBinary = var3 != null && var3.equalsIgnoreCase("true");
        var3 = null;
        if (var2 != null) {
            var3 = var2.getProperty("oracle.jdbc.ocinativelibrary");
        }

        if (var3 == null) {
            var3 = getSystemProperty("oracle.jdbc.ocinativelibrary", (String)null);
        }

        if (var3 == null) {
            var3 = null;
        }

        this.ocidll = var3;
        var3 = null;
        if (var2 != null) {
            var3 = var2.getProperty("v$session.terminal");
            if (var3 == null) {
                var3 = var2.getProperty("oracle.jdbc.v$session.terminal");
            }
        }

        if (var3 == null) {
            var3 = getSystemProperty("oracle.jdbc.v$session.terminal", (String)null);
        }

        if (var3 == null) {
            var3 = "unknown";
        }

        this.thinVsessionTerminal = var3;
        var3 = null;
        if (var2 != null) {
            var3 = var2.getProperty("v$session.machine");
            if (var3 == null) {
                var3 = var2.getProperty("oracle.jdbc.v$session.machine");
            }
        }

        if (var3 == null) {
            var3 = getSystemProperty("oracle.jdbc.v$session.machine", (String)null);
        }

        if (var3 == null) {
            var3 = null;
        }

        this.thinVsessionMachine = var3;
        var3 = null;
        if (var2 != null) {
            var3 = var2.getProperty("v$session.osuser");
            if (var3 == null) {
                var3 = var2.getProperty("oracle.jdbc.v$session.osuser");
            }
        }

        if (var3 == null) {
            var3 = getSystemProperty("oracle.jdbc.v$session.osuser", (String)null);
        }

        if (var3 == null) {
            var3 = null;
        }

        this.thinVsessionOsuser = var3;
        var3 = null;
        if (var2 != null) {
            var3 = var2.getProperty("v$session.program");
            if (var3 == null) {
                var3 = var2.getProperty("oracle.jdbc.v$session.program");
            }
        }

        if (var3 == null) {
            var3 = getSystemProperty("oracle.jdbc.v$session.program", (String)null);
        }

        if (var3 == null) {
            var3 = "JDBC Thin Client";
        }

        this.thinVsessionProgram = var3;
        var3 = null;
        if (var2 != null) {
            var3 = var2.getProperty("v$session.process");
            if (var3 == null) {
                var3 = var2.getProperty("oracle.jdbc.v$session.process");
            }
        }

        if (var3 == null) {
            var3 = getSystemProperty("oracle.jdbc.v$session.process", (String)null);
        }

        if (var3 == null) {
            var3 = "1234";
        }

        this.thinVsessionProcess = var3;
        var3 = null;
        if (var2 != null) {
            var3 = var2.getProperty("v$session.iname");
            if (var3 == null) {
                var3 = var2.getProperty("oracle.jdbc.v$session.iname");
            }
        }

        if (var3 == null) {
            var3 = getSystemProperty("oracle.jdbc.v$session.iname", (String)null);
        }

        if (var3 == null) {
            var3 = "jdbc_ttc_impl";
        }

        this.thinVsessionIname = var3;
        var3 = null;
        if (var2 != null) {
            var3 = var2.getProperty("v$session.ename");
            if (var3 == null) {
                var3 = var2.getProperty("oracle.jdbc.v$session.ename");
            }
        }

        if (var3 == null) {
            var3 = getSystemProperty("oracle.jdbc.v$session.ename", (String)null);
        }

        if (var3 == null) {
            var3 = null;
        }

        this.thinVsessionEname = var3;
        var3 = null;
        if (var2 != null) {
            var3 = var2.getProperty("oracle.net.profile");
        }

        if (var3 == null) {
            var3 = getSystemProperty("oracle.net.profile", (String)null);
        }

        if (var3 == null) {
            var3 = null;
        }

        this.thinNetProfile = var3;
        var3 = null;
        if (var2 != null) {
            var3 = var2.getProperty("oracle.net.authentication_services");
        }

        if (var3 == null) {
            var3 = getSystemProperty("oracle.net.authentication_services", (String)null);
        }

        if (var3 == null) {
            var3 = null;
        }

        this.thinNetAuthenticationServices = var3;
        var3 = null;
        if (var2 != null) {
            var3 = var2.getProperty("oracle.net.kerberos5_mutual_authentication");
        }

        if (var3 == null) {
            var3 = getSystemProperty("oracle.net.kerberos5_mutual_authentication", (String)null);
        }

        if (var3 == null) {
            var3 = null;
        }

        this.thinNetAuthenticationKrb5Mutual = var3;
        var3 = null;
        if (var2 != null) {
            var3 = var2.getProperty("oracle.net.kerberos5_cc_name");
        }

        if (var3 == null) {
            var3 = getSystemProperty("oracle.net.kerberos5_cc_name", (String)null);
        }

        if (var3 == null) {
            var3 = null;
        }

        this.thinNetAuthenticationKrb5CcName = var3;
        var3 = null;
        if (var2 != null) {
            var3 = var2.getProperty("oracle.net.encryption_client");
        }

        if (var3 == null) {
            var3 = getSystemProperty("oracle.net.encryption_client", (String)null);
        }

        if (var3 == null) {
            var3 = null;
        }

        this.thinNetEncryptionLevel = var3;
        var3 = null;
        if (var2 != null) {
            var3 = var2.getProperty("oracle.net.encryption_types_client");
        }

        if (var3 == null) {
            var3 = getSystemProperty("oracle.net.encryption_types_client", (String)null);
        }

        if (var3 == null) {
            var3 = null;
        }

        this.thinNetEncryptionTypes = var3;
        var3 = null;
        if (var2 != null) {
            var3 = var2.getProperty("oracle.net.crypto_checksum_client");
        }

        if (var3 == null) {
            var3 = getSystemProperty("oracle.net.crypto_checksum_client", (String)null);
        }

        if (var3 == null) {
            var3 = null;
        }

        this.thinNetChecksumLevel = var3;
        var3 = null;
        if (var2 != null) {
            var3 = var2.getProperty("oracle.net.crypto_checksum_types_client");
        }

        if (var3 == null) {
            var3 = getSystemProperty("oracle.net.crypto_checksum_types_client", (String)null);
        }

        if (var3 == null) {
            var3 = null;
        }

        this.thinNetChecksumTypes = var3;
        var3 = null;
        if (var2 != null) {
            var3 = var2.getProperty("oracle.net.crypto_seed");
        }

        if (var3 == null) {
            var3 = getSystemProperty("oracle.net.crypto_seed", (String)null);
        }

        if (var3 == null) {
            var3 = null;
        }

        this.thinNetCryptoSeed = var3;
        var3 = null;
        if (var2 != null) {
            var3 = var2.getProperty("oracle.jdbc.TcpNoDelay");
        }

        if (var3 == null) {
            var3 = getSystemProperty("oracle.jdbc.TcpNoDelay", (String)null);
        }

        if (var3 == null) {
            var3 = "false";
        }

        this.thinTcpNoDelay = var3 != null && var3.equalsIgnoreCase("true");
        var3 = null;
        if (var2 != null) {
            var3 = var2.getProperty("oracle.jdbc.ReadTimeout");
        }

        if (var3 == null) {
            var3 = getSystemProperty("oracle.jdbc.ReadTimeout", (String)null);
        }

        if (var3 == null) {
            var3 = null;
        }

        this.thinReadTimeout = var3;
        var3 = null;
        if (var2 != null) {
            var3 = var2.getProperty("oracle.net.CONNECT_TIMEOUT");
        }

        if (var3 == null) {
            var3 = getSystemProperty("oracle.net.CONNECT_TIMEOUT", (String)null);
        }

        if (var3 == null) {
            var3 = null;
        }

        this.thinNetConnectTimeout = var3;
        var3 = null;
        if (var2 != null) {
            var3 = var2.getProperty("oracle.net.disableOob");
        }

        if (var3 == null) {
            var3 = getSystemProperty("oracle.net.disableOob", (String)null);
        }

        if (var3 == null) {
            var3 = "false";
        }

        this.thinNetDisableOutOfBandBreak = var3 != null && var3.equalsIgnoreCase("true");
        var3 = null;
        if (var2 != null) {
            var3 = var2.getProperty("oracle.net.useZeroCopyIO");
        }

        if (var3 == null) {
            var3 = getSystemProperty("oracle.net.useZeroCopyIO", (String)null);
        }

        if (var3 == null) {
            var3 = "true";
        }

        this.thinNetUseZeroCopyIO = var3 != null && var3.equalsIgnoreCase("true");
        var3 = null;
        if (var2 != null) {
            var3 = var2.getProperty("oracle.jdbc.use1900AsYearForTime");
        }

        if (var3 == null) {
            var3 = getSystemProperty("oracle.jdbc.use1900AsYearForTime", (String)null);
        }

        if (var3 == null) {
            var3 = "false";
        }

        this.use1900AsYearForTime = var3 != null && var3.equalsIgnoreCase("true");
        var3 = null;
        if (var2 != null) {
            var3 = var2.getProperty("oracle.jdbc.timestampTzInGmt");
        }

        if (var3 == null) {
            var3 = getSystemProperty("oracle.jdbc.timestampTzInGmt", (String)null);
        }

        if (var3 == null) {
            var3 = "true";
        }

        this.timestamptzInGmt = var3 != null && var3.equalsIgnoreCase("true");
        var3 = null;
        if (var2 != null) {
            var3 = var2.getProperty("oracle.jdbc.timezoneAsRegion");
        }

        if (var3 == null) {
            var3 = getSystemProperty("oracle.jdbc.timezoneAsRegion", (String)null);
        }

        if (var3 == null) {
            var3 = "true";
        }

        this.timezoneAsRegion = var3 != null && var3.equalsIgnoreCase("true");
        var3 = null;
        if (var2 != null) {
            var3 = var2.getProperty("oracle.net.ssl_server_dn_match");
        }

        if (var3 == null) {
            var3 = getSystemProperty("oracle.net.ssl_server_dn_match", (String)null);
        }

        if (var3 == null) {
            var3 = null;
        }

        this.thinSslServerDnMatch = var3;
        var3 = null;
        if (var2 != null) {
            var3 = var2.getProperty("oracle.net.ssl_version");
        }

        if (var3 == null) {
            var3 = getSystemProperty("oracle.net.ssl_version", (String)null);
        }

        if (var3 == null) {
            var3 = null;
        }

        this.thinSslVersion = var3;
        var3 = null;
        if (var2 != null) {
            var3 = var2.getProperty("oracle.net.ssl_cipher_suites");
        }

        if (var3 == null) {
            var3 = getSystemProperty("oracle.net.ssl_cipher_suites", (String)null);
        }

        if (var3 == null) {
            var3 = null;
        }

        this.thinSslCipherSuites = var3;
        var3 = null;
        if (var2 != null) {
            var3 = var2.getProperty("javax.net.ssl.keyStore");
        }

        if (var3 == null) {
            var3 = getSystemProperty("javax.net.ssl.keyStore", (String)null);
        }

        if (var3 == null) {
            var3 = null;
        }

        this.thinJavaxNetSslKeystore = var3;
        var3 = null;
        if (var2 != null) {
            var3 = var2.getProperty("javax.net.ssl.keyStoreType");
        }

        if (var3 == null) {
            var3 = getSystemProperty("javax.net.ssl.keyStoreType", (String)null);
        }

        if (var3 == null) {
            var3 = null;
        }

        this.thinJavaxNetSslKeystoretype = var3;
        var3 = null;
        if (var2 != null) {
            var3 = var2.getProperty("javax.net.ssl.keyStorePassword");
        }

        if (var3 == null) {
            var3 = getSystemProperty("javax.net.ssl.keyStorePassword", (String)null);
        }

        if (var3 == null) {
            var3 = null;
        }

        this.thinJavaxNetSslKeystorepassword = var3;
        var3 = null;
        if (var2 != null) {
            var3 = var2.getProperty("javax.net.ssl.trustStore");
        }

        if (var3 == null) {
            var3 = getSystemProperty("javax.net.ssl.trustStore", (String)null);
        }

        if (var3 == null) {
            var3 = null;
        }

        this.thinJavaxNetSslTruststore = var3;
        var3 = null;
        if (var2 != null) {
            var3 = var2.getProperty("javax.net.ssl.trustStoreType");
        }

        if (var3 == null) {
            var3 = getSystemProperty("javax.net.ssl.trustStoreType", (String)null);
        }

        if (var3 == null) {
            var3 = null;
        }

        this.thinJavaxNetSslTruststoretype = var3;
        var3 = null;
        if (var2 != null) {
            var3 = var2.getProperty("javax.net.ssl.trustStorePassword");
        }

        if (var3 == null) {
            var3 = getSystemProperty("javax.net.ssl.trustStorePassword", (String)null);
        }

        if (var3 == null) {
            var3 = null;
        }

        this.thinJavaxNetSslTruststorepassword = var3;
        var3 = null;
        if (var2 != null) {
            var3 = var2.getProperty("ssl.keyManagerFactory.algorithm");
            if (var3 == null) {
                var3 = var2.getProperty("oracle.jdbc.ssl.keyManagerFactory.algorithm");
            }
        }

        if (var3 == null) {
            var3 = getSystemProperty("oracle.jdbc.ssl.keyManagerFactory.algorithm", (String)null);
        }

        if (var3 == null) {
            var3 = null;
        }

        this.thinSslKeymanagerfactoryAlgorithm = var3;
        var3 = null;
        if (var2 != null) {
            var3 = var2.getProperty("ssl.trustManagerFactory.algorithm");
            if (var3 == null) {
                var3 = var2.getProperty("oracle.jdbc.ssl.trustManagerFactory.algorithm");
            }
        }

        if (var3 == null) {
            var3 = getSystemProperty("oracle.jdbc.ssl.trustManagerFactory.algorithm", (String)null);
        }

        if (var3 == null) {
            var3 = null;
        }

        this.thinSslTrustmanagerfactoryAlgorithm = var3;
        var3 = null;
        if (var2 != null) {
            var3 = var2.getProperty("oracle.net.oldSyntax");
        }

        if (var3 == null) {
            var3 = getSystemProperty("oracle.net.oldSyntax", (String)null);
        }

        if (var3 == null) {
            var3 = null;
        }

        this.thinNetOldsyntax = var3;
        var3 = null;
        if (var2 != null) {
            var3 = var2.getProperty("java.naming.factory.initial");
        }

        if (var3 == null) {
            var3 = null;
        }

        this.thinNamingContextInitial = var3;
        var3 = null;
        if (var2 != null) {
            var3 = var2.getProperty("java.naming.provider.url");
        }

        if (var3 == null) {
            var3 = null;
        }

        this.thinNamingProviderUrl = var3;
        var3 = null;
        if (var2 != null) {
            var3 = var2.getProperty("java.naming.security.authentication");
        }

        if (var3 == null) {
            var3 = null;
        }

        this.thinNamingSecurityAuthentication = var3;
        var3 = null;
        if (var2 != null) {
            var3 = var2.getProperty("java.naming.security.principal");
        }

        if (var3 == null) {
            var3 = null;
        }

        this.thinNamingSecurityPrincipal = var3;
        var3 = null;
        if (var2 != null) {
            var3 = var2.getProperty("java.naming.security.credentials");
        }

        if (var3 == null) {
            var3 = null;
        }

        this.thinNamingSecurityCredentials = var3;
        var3 = null;
        if (var2 != null) {
            var3 = var2.getProperty("com.sun.jndi.ldap.connect.timeout");
            if (var3 == null) {
                var3 = var2.getProperty("oracle.jdbc.com.sun.jndi.ldap.connect.timeout");
            }
        }

        if (var3 == null) {
            var3 = getSystemProperty("oracle.jdbc.com.sun.jndi.ldap.connect.timeout", (String)null);
        }

        if (var3 == null) {
            var3 = null;
        }

        this.thinJndiLdapConnectTimeout = var3;
        var3 = null;
        if (var2 != null) {
            var3 = var2.getProperty("com.sun.jndi.ldap.read.timeout");
            if (var3 == null) {
                var3 = var2.getProperty("oracle.jdbc.com.sun.jndi.ldap.read.timeout");
            }
        }

        if (var3 == null) {
            var3 = getSystemProperty("oracle.jdbc.com.sun.jndi.ldap.read.timeout", (String)null);
        }

        if (var3 == null) {
            var3 = null;
        }

        this.thinJndiLdapReadTimeout = var3;
        var3 = null;
        if (var2 != null) {
            var3 = var2.getProperty("oracle.net.wallet_location");
        }

        if (var3 == null) {
            var3 = getSystemProperty("oracle.net.wallet_location", (String)null);
        }

        if (var3 == null) {
            var3 = null;
        }

        this.walletLocation = var3;
        var3 = null;
        if (var2 != null) {
            var3 = var2.getProperty("oracle.net.wallet_password");
        }

        if (var3 == null) {
            var3 = getSystemProperty("oracle.net.wallet_password", (String)null);
        }

        if (var3 == null) {
            var3 = null;
        }

        this.walletPassword = var3;
        var3 = null;
        if (var2 != null) {
            var3 = var2.getProperty("oracle.jdbc.proxyClientName");
        }

        if (var3 == null) {
            var3 = getSystemProperty("oracle.jdbc.proxyClientName", (String)null);
        }

        if (var3 == null) {
            var3 = null;
        }

        this.proxyClientName = var3;
        var3 = null;
        if (var2 != null) {
            var3 = var2.getProperty("oracle.jdbc.useNio");
        }

        if (var3 == null) {
            var3 = getSystemProperty("oracle.jdbc.useNio", (String)null);
        }

        if (var3 == null) {
            var3 = "false";
        }

        this.useNio = var3 != null && var3.equalsIgnoreCase("true");
        var3 = null;
        if (var2 != null) {
            var3 = var2.getProperty("JDBCDriverCharSetId");
            if (var3 == null) {
                var3 = var2.getProperty("oracle.jdbc.JDBCDriverCharSetId");
            }
        }

        if (var3 == null) {
            var3 = getSystemProperty("oracle.jdbc.JDBCDriverCharSetId", (String)null);
        }

        if (var3 == null) {
            var3 = null;
        }

        this.ociDriverCharset = var3;
        var3 = null;
        if (var2 != null) {
            var3 = var2.getProperty("oracle.jdbc.editionName");
        }

        if (var3 == null) {
            var3 = getSystemProperty("oracle.jdbc.editionName", (String)null);
        }

        if (var3 == null) {
            var3 = null;
        }

        this.editionName = var3;
        var3 = null;
        if (var2 != null) {
            var3 = var2.getProperty("oracle.jdbc.thinLogonCapability");
        }

        if (var3 == null) {
            var3 = getSystemProperty("oracle.jdbc.thinLogonCapability", (String)null);
        }

        if (var3 == null) {
            var3 = "o5";
        }

        this.logonCap = var3;
        var3 = null;
        if (var2 != null) {
            var3 = var2.getProperty("oracle.jdbc.useOCIDefaultDefines");
        }

        if (var3 == null) {
            var3 = getSystemProperty("oracle.jdbc.useOCIDefaultDefines", (String)null);
        }

        if (var3 == null) {
            var3 = "false";
        }

        this.useOCIDefaultDefines = var3 != null && var3.equalsIgnoreCase("true");
        var3 = null;
        if (var2 != null) {
            var3 = var2.getProperty("internal_logon");
            if (var3 == null) {
                var3 = var2.getProperty("oracle.jdbc.internal_logon");
            }
        }

        if (var3 == null) {
            var3 = getSystemProperty("oracle.jdbc.internal_logon", (String)null);
        }

        if (var3 == null) {
            var3 = null;
        }

        this.internalLogon = var3;
        var3 = null;
        if (var2 != null) {
            var3 = var2.getProperty("oracle.jdbc.createDescriptorUseCurrentSchemaForSchemaName");
        }

        if (var3 == null) {
            var3 = getSystemProperty("oracle.jdbc.createDescriptorUseCurrentSchemaForSchemaName", (String)null);
        }

        if (var3 == null) {
            var3 = "false";
        }

        this.createDescriptorUseCurrentSchemaForSchemaName = var3 != null && var3.equalsIgnoreCase("true");
        var3 = null;
        if (var2 != null) {
            var3 = var2.getProperty("OCISvcCtxHandle");
            if (var3 == null) {
                var3 = var2.getProperty("oracle.jdbc.OCISvcCtxHandle");
            }
        }

        if (var3 == null) {
            var3 = getSystemProperty("oracle.jdbc.OCISvcCtxHandle", (String)null);
        }

        if (var3 == null) {
            var3 = "0";
        }

        try {
            this.ociSvcCtxHandle = Long.parseLong(var3);
        } catch (NumberFormatException var17) {
            var5 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 190, "Property is 'ociSvcCtxHandle'");
            var5.fillInStackTrace();
            throw var5;
        }

        var3 = null;
        if (var2 != null) {
            var3 = var2.getProperty("OCIEnvHandle");
            if (var3 == null) {
                var3 = var2.getProperty("oracle.jdbc.OCIEnvHandle");
            }
        }

        if (var3 == null) {
            var3 = getSystemProperty("oracle.jdbc.OCIEnvHandle", (String)null);
        }

        if (var3 == null) {
            var3 = "0";
        }

        try {
            this.ociEnvHandle = Long.parseLong(var3);
        } catch (NumberFormatException var16) {
            var5 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 190, "Property is 'ociEnvHandle'");
            var5.fillInStackTrace();
            throw var5;
        }

        var3 = null;
        if (var2 != null) {
            var3 = var2.getProperty("OCIErrHandle");
            if (var3 == null) {
                var3 = var2.getProperty("oracle.jdbc.OCIErrHandle");
            }
        }

        if (var3 == null) {
            var3 = getSystemProperty("oracle.jdbc.OCIErrHandle", (String)null);
        }

        if (var3 == null) {
            var3 = "0";
        }

        try {
            this.ociErrHandle = Long.parseLong(var3);
        } catch (NumberFormatException var15) {
            var5 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 190, "Property is 'ociErrHandle'");
            var5.fillInStackTrace();
            throw var5;
        }

        var3 = null;
        if (var2 != null) {
            var3 = var2.getProperty("prelim_auth");
            if (var3 == null) {
                var3 = var2.getProperty("oracle.jdbc.prelim_auth");
            }
        }

        if (var3 == null) {
            var3 = getSystemProperty("oracle.jdbc.prelim_auth", (String)null);
        }

        if (var3 == null) {
            var3 = "false";
        }

        this.prelimAuth = var3 != null && var3.equalsIgnoreCase("true");
        var3 = null;
        if (var2 != null) {
            var3 = var2.getProperty("oracle.jdbc.jmsNotification");
        }

        if (var3 == null) {
            var3 = getSystemProperty("oracle.jdbc.jmsNotification", (String)null);
        }

        if (var3 == null) {
            var3 = "false";
        }

        this.jmsNotificationConnection = var3 != null && var3.equalsIgnoreCase("true");
        var3 = null;
        if (var2 != null) {
            var3 = var2.getProperty("oracle.jdbc.ociNlsLangBackwardCompatible");
        }

        if (var3 == null) {
            var3 = getSystemProperty("oracle.jdbc.ociNlsLangBackwardCompatible", (String)null);
        }

        if (var3 == null) {
            var3 = "false";
        }

        this.nlsLangBackdoor = var3 != null && var3.equalsIgnoreCase("true");
        var3 = null;
        if (var2 != null) {
            var3 = var2.getProperty("OCINewPassword");
            if (var3 == null) {
                var3 = var2.getProperty("oracle.jdbc.OCINewPassword");
            }
        }

        if (var3 == null) {
            var3 = getSystemProperty("oracle.jdbc.OCINewPassword", (String)null);
        }

        if (var3 == null) {
            var3 = null;
        }

        this.setNewPassword = var3;
        var3 = null;
        if (var2 != null) {
            var3 = var2.getProperty("oracle.jdbc.spawnNewThreadToCancel");
        }

        if (var3 == null) {
            var3 = getSystemProperty("oracle.jdbc.spawnNewThreadToCancel", (String)null);
        }

        if (var3 == null) {
            var3 = "false";
        }

        this.spawnNewThreadToCancel = var3 != null && var3.equalsIgnoreCase("true");
        var3 = null;
        if (var2 != null) {
            var3 = var2.getProperty("defaultExecuteBatch");
            if (var3 == null) {
                var3 = var2.getProperty("oracle.jdbc.defaultExecuteBatch");
            }
        }

        if (var3 == null) {
            var3 = getSystemProperty("oracle.jdbc.defaultExecuteBatch", (String)null);
        }

        if (var3 == null) {
            var3 = "1";
        }

        try {
            this.defaultExecuteBatch = Integer.parseInt(var3);
        } catch (NumberFormatException var14) {
            var5 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 190, "Property is 'defaultExecuteBatch'");
            var5.fillInStackTrace();
            throw var5;
        }

        var3 = null;
        if (var2 != null) {
            var3 = var2.getProperty("defaultRowPrefetch");
            if (var3 == null) {
                var3 = var2.getProperty("oracle.jdbc.defaultRowPrefetch");
            }
        }

        if (var3 == null) {
            var3 = getSystemProperty("oracle.jdbc.defaultRowPrefetch", (String)null);
        }

        if (var3 == null) {
            var3 = "10";
        }

        try {
            this.defaultRowPrefetch = Integer.parseInt(var3);
        } catch (NumberFormatException var13) {
            var5 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 190, "Property is 'defaultRowPrefetch'");
            var5.fillInStackTrace();
            throw var5;
        }

        var3 = null;
        if (var2 != null) {
            var3 = var2.getProperty("oracle.jdbc.defaultLobPrefetchSize");
        }

        if (var3 == null) {
            var3 = getSystemProperty("oracle.jdbc.defaultLobPrefetchSize", (String)null);
        }

        if (var3 == null) {
            var3 = "4000";
        }

        try {
            this.defaultLobPrefetchSize = Integer.parseInt(var3);
        } catch (NumberFormatException var12) {
            var5 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 190, "Property is 'defaultLobPrefetchSize'");
            var5.fillInStackTrace();
            throw var5;
        }

        var3 = null;
        if (var2 != null) {
            var3 = var2.getProperty("oracle.jdbc.enableDataInLocator");
        }

        if (var3 == null) {
            var3 = getSystemProperty("oracle.jdbc.enableDataInLocator", (String)null);
        }

        if (var3 == null) {
            var3 = "true";
        }

        this.enableDataInLocator = var3 != null && var3.equalsIgnoreCase("true");
        var3 = null;
        if (var2 != null) {
            var3 = var2.getProperty("oracle.jdbc.enableReadDataInLocator");
        }

        if (var3 == null) {
            var3 = getSystemProperty("oracle.jdbc.enableReadDataInLocator", (String)null);
        }

        if (var3 == null) {
            var3 = "true";
        }

        this.enableReadDataInLocator = var3 != null && var3.equalsIgnoreCase("true");
        var3 = null;
        if (var2 != null) {
            var3 = var2.getProperty("oracle.jdbc.overrideEnableReadDataInLocator");
        }

        if (var3 == null) {
            var3 = getSystemProperty("oracle.jdbc.overrideEnableReadDataInLocator", (String)null);
        }

        if (var3 == null) {
            var3 = "false";
        }

        this.overrideEnableReadDataInLocator = var3 != null && var3.equalsIgnoreCase("true");
        var3 = null;
        if (var2 != null) {
            var3 = var2.getProperty("remarksReporting");
            if (var3 == null) {
                var3 = var2.getProperty("oracle.jdbc.remarksReporting");
            }
        }

        if (var3 == null) {
            var3 = getSystemProperty("oracle.jdbc.remarksReporting", (String)null);
        }

        if (var3 == null) {
            var3 = "false";
        }

        this.reportRemarks = var3 != null && var3.equalsIgnoreCase("true");
        var3 = null;
        if (var2 != null) {
            var3 = var2.getProperty("includeSynonyms");
            if (var3 == null) {
                var3 = var2.getProperty("oracle.jdbc.includeSynonyms");
            }
        }

        if (var3 == null) {
            var3 = getSystemProperty("oracle.jdbc.includeSynonyms", (String)null);
        }

        if (var3 == null) {
            var3 = "false";
        }

        this.includeSynonyms = var3 != null && var3.equalsIgnoreCase("true");
        var3 = null;
        if (var2 != null) {
            var3 = var2.getProperty("restrictGetTables");
            if (var3 == null) {
                var3 = var2.getProperty("oracle.jdbc.restrictGetTables");
            }
        }

        if (var3 == null) {
            var3 = getSystemProperty("oracle.jdbc.restrictGetTables", (String)null);
        }

        if (var3 == null) {
            var3 = "false";
        }

        this.restrictGettables = var3 != null && var3.equalsIgnoreCase("true");
        var3 = null;
        if (var2 != null) {
            var3 = var2.getProperty("AccumulateBatchResult");
            if (var3 == null) {
                var3 = var2.getProperty("oracle.jdbc.AccumulateBatchResult");
            }
        }

        if (var3 == null) {
            var3 = getSystemProperty("oracle.jdbc.AccumulateBatchResult", (String)null);
        }

        if (var3 == null) {
            var3 = "true";
        }

        this.accumulateBatchResult = var3 != null && var3.equalsIgnoreCase("true");
        var3 = null;
        if (var2 != null) {
            var3 = var2.getProperty("useFetchSizeWithLongColumn");
            if (var3 == null) {
                var3 = var2.getProperty("oracle.jdbc.useFetchSizeWithLongColumn");
            }
        }

        if (var3 == null) {
            var3 = getSystemProperty("oracle.jdbc.useFetchSizeWithLongColumn", (String)null);
        }

        if (var3 == null) {
            var3 = "false";
        }

        this.useFetchSizeWithLongColumn = var3 != null && var3.equalsIgnoreCase("true");
        var3 = null;
        if (var2 != null) {
            var3 = var2.getProperty("processEscapes");
            if (var3 == null) {
                var3 = var2.getProperty("oracle.jdbc.processEscapes");
            }
        }

        if (var3 == null) {
            var3 = getSystemProperty("oracle.jdbc.processEscapes", (String)null);
        }

        if (var3 == null) {
            var3 = "true";
        }

        this.processEscapes = var3 != null && var3.equalsIgnoreCase("true");
        var3 = null;
        if (var2 != null) {
            var3 = var2.getProperty("fixedString");
            if (var3 == null) {
                var3 = var2.getProperty("oracle.jdbc.fixedString");
            }
        }

        if (var3 == null) {
            var3 = getSystemProperty("oracle.jdbc.fixedString", (String)null);
        }

        if (var3 == null) {
            var3 = "false";
        }

        this.fixedString = var3 != null && var3.equalsIgnoreCase("true");
        var3 = null;
        if (var2 != null) {
            var3 = var2.getProperty("defaultNChar");
            if (var3 == null) {
                var3 = var2.getProperty("oracle.jdbc.defaultNChar");
            }
        }

        if (var3 == null) {
            var3 = getSystemProperty("oracle.jdbc.defaultNChar", (String)null);
        }

        if (var3 == null) {
            var3 = "false";
        }

        this.defaultnchar = var3 != null && var3.equalsIgnoreCase("true");
        var3 = null;
        if (var2 != null) {
            var3 = var2.getProperty("oracle.jdbc.internal.permitBindDateDefineTimestampMismatch");
        }

        if (var3 == null) {
            var3 = getSystemProperty("oracle.jdbc.internal.permitBindDateDefineTimestampMismatch", (String)null);
        }

        if (var3 == null) {
            var3 = "false";
        }

        this.permitTimestampDateMismatch = var3 != null && var3.equalsIgnoreCase("true");
        var3 = null;
        if (var2 != null) {
            var3 = var2.getProperty("RessourceManagerId");
            if (var3 == null) {
                var3 = var2.getProperty("oracle.jdbc.RessourceManagerId");
            }
        }

        if (var3 == null) {
            var3 = getSystemProperty("oracle.jdbc.RessourceManagerId", (String)null);
        }

        if (var3 == null) {
            var3 = "0000";
        }

        this.resourceManagerId = var3;
        var3 = null;
        if (var2 != null) {
            var3 = var2.getProperty("disableDefineColumnType");
            if (var3 == null) {
                var3 = var2.getProperty("oracle.jdbc.disableDefineColumnType");
            }
        }

        if (var3 == null) {
            var3 = getSystemProperty("oracle.jdbc.disableDefineColumnType", (String)null);
        }

        if (var3 == null) {
            var3 = "false";
        }

        this.disableDefinecolumntype = var3 != null && var3.equalsIgnoreCase("true");
        var3 = null;
        if (var2 != null) {
            var3 = var2.getProperty("oracle.jdbc.convertNcharLiterals");
        }

        if (var3 == null) {
            var3 = getSystemProperty("oracle.jdbc.convertNcharLiterals", (String)null);
        }

        if (var3 == null) {
            var3 = "true";
        }

        this.convertNcharLiterals = var3 != null && var3.equalsIgnoreCase("true");
        var3 = null;
        if (var2 != null) {
            var3 = var2.getProperty("oracle.jdbc.autoCommitSpecCompliant");
        }

        if (var3 == null) {
            var3 = getSystemProperty("oracle.jdbc.autoCommitSpecCompliant", (String)null);
        }

        if (var3 == null) {
            var3 = "true";
        }

        this.autoCommitSpecCompliant = var3 != null && var3.equalsIgnoreCase("true");
        var3 = null;
        if (var2 != null) {
            var3 = var2.getProperty("oracle.jdbc.J2EE13Compliant");
        }

        if (var3 == null) {
            var3 = getSystemProperty("oracle.jdbc.J2EE13Compliant", (String)null);
        }

        if (var3 == null) {
            var3 = "false";
        }

        this.j2ee13Compliant = var3 != null && var3.equalsIgnoreCase("true");
        var3 = null;
        if (var2 != null) {
            var3 = var2.getProperty("oracle.jdbc.mapDateToTimestamp");
        }

        if (var3 == null) {
            var3 = getSystemProperty("oracle.jdbc.mapDateToTimestamp", (String)null);
        }

        if (var3 == null) {
            var3 = "true";
        }

        this.mapDateToTimestamp = var3 != null && var3.equalsIgnoreCase("true");
        var3 = null;
        if (var2 != null) {
            var3 = var2.getProperty("oracle.jdbc.useThreadLocalBufferCache");
        }

        if (var3 == null) {
            var3 = getSystemProperty("oracle.jdbc.useThreadLocalBufferCache", (String)null);
        }

        if (var3 == null) {
            var3 = "false";
        }

        this.useThreadLocalBufferCache = var3 != null && var3.equalsIgnoreCase("true");
        var3 = null;
        if (var2 != null) {
            var3 = var2.getProperty("oracle.jdbc.driverNameAttribute");
        }

        if (var3 == null) {
            var3 = getSystemProperty("oracle.jdbc.driverNameAttribute", (String)null);
        }

        if (var3 == null) {
            var3 = null;
        }

        this.driverNameAttribute = var3;
        var3 = null;
        if (var2 != null) {
            var3 = var2.getProperty("oracle.jdbc.maxCachedBufferSize");
        }

        if (var3 == null) {
            var3 = getSystemProperty("oracle.jdbc.maxCachedBufferSize", (String)null);
        }

        if (var3 == null) {
            var3 = "30";
        }

        try {
            this.maxCachedBufferSize = Integer.parseInt(var3);
        } catch (NumberFormatException var11) {
            var5 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 190, "Property is 'maxCachedBufferSize'");
            var5.fillInStackTrace();
            throw var5;
        }

        var3 = null;
        if (var2 != null) {
            var3 = var2.getProperty("oracle.jdbc.implicitStatementCacheSize");
        }

        if (var3 == null) {
            var3 = getSystemProperty("oracle.jdbc.implicitStatementCacheSize", (String)null);
        }

        if (var3 == null) {
            var3 = "0";
        }

        try {
            this.implicitStatementCacheSize = Integer.parseInt(var3);
        } catch (NumberFormatException var10) {
            var5 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 190, "Property is 'implicitStatementCacheSize'");
            var5.fillInStackTrace();
            throw var5;
        }

        var3 = null;
        if (var2 != null) {
            var3 = var2.getProperty("oracle.jdbc.LobStreamPosStandardCompliant");
        }

        if (var3 == null) {
            var3 = getSystemProperty("oracle.jdbc.LobStreamPosStandardCompliant", (String)null);
        }

        if (var3 == null) {
            var3 = "false";
        }

        this.lobStreamPosStandardCompliant = var3 != null && var3.equalsIgnoreCase("true");
        var3 = null;
        if (var2 != null) {
            var3 = var2.getProperty("oracle.jdbc.strictASCIIConversion");
        }

        if (var3 == null) {
            var3 = getSystemProperty("oracle.jdbc.strictASCIIConversion", (String)null);
        }

        if (var3 == null) {
            var3 = "false";
        }

        this.isStrictAsciiConversion = var3 != null && var3.equalsIgnoreCase("true");
        var3 = null;
        if (var2 != null) {
            var3 = var2.getProperty("oracle.jdbc.DRCPConnectionClass");
        }

        if (var3 == null) {
            var3 = getSystemProperty("oracle.jdbc.DRCPConnectionClass", (String)null);
        }

        if (var3 == null) {
            var3 = null;
        }

        this.drcpConnectionClass = var3;
        var3 = null;
        if (var2 != null) {
            var3 = var2.getProperty("oracle.jdbc.DRCPTagName");
        }

        if (var3 == null) {
            var3 = null;
        }

        this.drcpTagName = var3;
        var3 = null;
        if (var3 == null) {
            var3 = getSystemProperty("oracle.jdbc.blockSourceImplementation", (String)null);
        }

        if (var3 == null) {
            var3 = "THREADED";
        }

        this.blockSourceImpl = var3;
        var3 = null;
        if (var2 != null) {
            var3 = var2.getProperty("oracle.jdbc.thinForceDNSLoadBalancing");
        }

        if (var3 == null) {
            var3 = getSystemProperty("oracle.jdbc.thinForceDNSLoadBalancing", (String)null);
        }

        if (var3 == null) {
            var3 = "false";
        }

        this.thinForceDnsLoadBalancing = var3 != null && var3.equalsIgnoreCase("true");
        var3 = null;
        if (var2 != null) {
            var3 = var2.getProperty("oracle.jdbc.enableTempLobRefCnt");
        }

        if (var3 == null) {
            var3 = getSystemProperty("oracle.jdbc.enableTempLobRefCnt", (String)null);
        }

        if (var3 == null) {
            var3 = "true";
        }

        this.enableTempLobRefCnt = var3 != null && var3.equalsIgnoreCase("true");
        var3 = null;
        if (var2 != null) {
            var3 = var2.getProperty("oracle.net.keepAlive");
        }

        if (var3 == null) {
            var3 = getSystemProperty("oracle.net.keepAlive", (String)null);
        }

        if (var3 == null) {
            var3 = "false";
        }

        this.keepAlive = var3 != null && var3.equalsIgnoreCase("true");
        var3 = null;
        if (var2 != null) {
            var3 = var2.getProperty("oracle.jdbc.sqlTranslationProfile");
        }

        if (var3 == null) {
            var3 = getSystemProperty("oracle.jdbc.sqlTranslationProfile", (String)null);
        }

        if (var3 == null) {
            var3 = null;
        }

        this.sqlTranslationProfile = var3;
        var3 = null;
        if (var2 != null) {
            var3 = var2.getProperty("oracle.jdbc.sqlErrorTranslationFile");
        }

        if (var3 == null) {
            var3 = getSystemProperty("oracle.jdbc.sqlErrorTranslationFile", (String)null);
        }

        if (var3 == null) {
            var3 = null;
        }

        this.sqlErrorTranslationFile = var3;
        var3 = null;
        if (var2 != null) {
            var3 = var2.getProperty("oracle.jdbc.ignoreReplayContextFromAuthentication");
        }

        if (var3 == null) {
            var3 = "false";
        }

        this.ignoreReplayContextFromAuthentication = var3 != null && var3.equalsIgnoreCase("true");
        var3 = null;
        if (var2 != null) {
            var3 = var2.getProperty("oracle.jdbc.javaNetNio");
        }

        if (var3 == null) {
            var3 = getSystemProperty("oracle.jdbc.javaNetNio", (String)null);
        }

        if (var3 == null) {
            var3 = "false";
        }

        this.javaNetNio = var3 != null && var3.equalsIgnoreCase("true");
        var3 = null;
        if (var2 != null) {
            var3 = var2.getProperty("oracle.jdbc.nsDirectBuffer");
        }

        if (var3 == null) {
            var3 = getSystemProperty("oracle.jdbc.nsDirectBuffer", (String)null);
        }

        if (var3 == null) {
            var3 = "false";
        }

        this.nsDirectBuffer = var3 != null && var3.equalsIgnoreCase("true");
        var3 = null;
        if (var2 != null) {
            var3 = var2.getProperty("oracle.jdbc.plsqlVarcharParameter4KOnly");
        }

        if (var3 == null) {
            var3 = getSystemProperty("oracle.jdbc.plsqlVarcharParameter4KOnly", (String)null);
        }

        if (var3 == null) {
            var3 = "false";
        }

        this.plsqlVarcharParameter4KOnly = var3 != null && var3.equalsIgnoreCase("true");
        var3 = null;
        if (var2 != null) {
            var3 = var2.getProperty("oracle.jdbc.targetInstanceName");
        }

        if (var3 == null) {
            var3 = getSystemProperty("oracle.jdbc.targetInstanceName", (String)null);
        }

        if (var3 == null) {
            var3 = null;
        }

        this.targetInstanceName = var3;
        var3 = null;
        if (var2 != null) {
            var3 = var2.getProperty("oracle.jdbc.enableOCIFastApplicationNotification");
        }

        if (var3 == null) {
            var3 = getSystemProperty("oracle.jdbc.enableOCIFastApplicationNotification", (String)null);
        }

        if (var3 == null) {
            var3 = "false";
        }

        this.enableOCIFAN = var3 != null && var3.equalsIgnoreCase("true");
        var3 = null;
        if (var2 != null) {
            var3 = var2.getProperty("oracle.jdbc.commitOption");
        }

        if (var3 == null) {
            var3 = getSystemProperty("oracle.jdbc.commitOption", (String)null);
        }

        String[] var24;
        if (var3 != null) {
            this.commitOption = 0;
            String[] var4 = var3.split(",");
            if (var4 != null && var4.length > 0) {
                var24 = var4;
                int var6 = var4.length;

                for(int var7 = 0; var7 < var6; ++var7) {
                    String var8 = var24[var7];
                    if (var8.trim() != "") {
                        this.commitOption |= CommitOption.valueOf(var8.trim()).getCode();
                    }
                }
            }
        }

        var3 = null;
        if (var2 != null) {
            var3 = var2.getProperty("oracle.jdbc.calculateChecksum");
        }

        if (var3 == null) {
            var3 = getSystemProperty("oracle.jdbc.calculateChecksum", (String)null);
        }

        if (var3 == null) {
            this.checksumMode = ChecksumMode.NO_CHECKSUM;
        } else {
            this.checksumMode = ChecksumMode.valueOf(var3);
        }

        this.includeSynonyms = parseConnectionProperty_boolean(var2, "synonyms", (byte)3, this.includeSynonyms);
        this.reportRemarks = parseConnectionProperty_boolean(var2, "remarks", (byte)3, this.reportRemarks);
        this.defaultRowPrefetch = parseConnectionProperty_int(var2, "prefetch", (byte)3, this.defaultRowPrefetch);
        this.defaultRowPrefetch = parseConnectionProperty_int(var2, "rowPrefetch", (byte)3, this.defaultRowPrefetch);
        this.defaultExecuteBatch = parseConnectionProperty_int(var2, "batch", (byte)3, this.defaultExecuteBatch);
        this.defaultExecuteBatch = parseConnectionProperty_int(var2, "executeBatch", (byte)3, this.defaultExecuteBatch);
        this.proxyClientName = parseConnectionProperty_String(var2, "PROXY_CLIENT_NAME", (byte)1, this.proxyClientName);
        if (this.defaultRowPrefetch <= 0) {
            this.defaultRowPrefetch = Integer.parseInt("10");
        }

        if (this.defaultExecuteBatch <= 0) {
            this.defaultExecuteBatch = Integer.parseInt("1");
        }

        if (this.defaultLobPrefetchSize < -1) {
            SQLException var21 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 267);
            var21.fillInStackTrace();
            throw var21;
        } else {
            if (this.thinVsessionOsuser == null) {
                this.thinVsessionOsuser = getSystemProperty("user.name", (String)null);
                if (this.thinVsessionOsuser == null) {
                    this.thinVsessionOsuser = "jdbcuser";
                }
            }

            if (this.thinNetConnectTimeout == CONNECTION_PROPERTY_THIN_NET_CONNECT_TIMEOUT_DEFAULT) {
                int var19 = DriverManager.getLoginTimeout();
                if (var19 != 0) {
                    this.thinNetConnectTimeout = "" + var19 * 1000;
                }
            }

            this.autocommit = this.defaultautocommit;
            this.url = var1;
            Hashtable var20 = parseUrl(this.url, this.walletLocation, this.walletPassword);
            if (this.userName == CONNECTION_PROPERTY_USER_NAME_DEFAULT) {
                this.userName = (String)var20.get("user");
            }

            var24 = new String[1];
            String[] var22 = new String[1];
            this.userName = parseLoginOption(this.userName, var2, var24, var22);
            if (var24[0] != null) {
                this.internalLogon = var24[0];
            }

            if (var22[0] != null) {
                this.proxyClientName = var22[0];
            }

            String var23 = var2.getProperty("password", CONNECTION_PROPERTY_PASSWORD_DEFAULT);
            if (var23 == CONNECTION_PROPERTY_PASSWORD_DEFAULT) {
                var23 = (String)var20.get("password");
            }

            this.initializePassword(var23);
            if (this.database == CONNECTION_PROPERTY_DATABASE_DEFAULT) {
                this.database = var2.getProperty("server", CONNECTION_PROPERTY_DATABASE_DEFAULT);
            }

            if (this.database == CONNECTION_PROPERTY_DATABASE_DEFAULT) {
                this.database = (String)var20.get("database");
            }

            this.protocol = (String)var20.get("protocol");
            if (this.protocol == null) {
                SQLException var26 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 40, "Protocol is not specified in URL");
                var26.fillInStackTrace();
                throw var26;
            } else {
                if (this.protocol.equals("oci8") || this.protocol.equals("oci")) {
                    this.database = this.translateConnStr(this.database);
                    if (null != this.targetInstanceName && !"".equals(this.targetInstanceName)) {
                        this.database = this.createNamedInstanceUrl(this.database, this.targetInstanceName);
                    }
                }

                if (var2.getProperty("is_connection_pooling") == "true" && this.database == null) {
                    this.database = "";
                }

                if (this.userName != null && !this.userName.startsWith("\"")) {
                    char[] var25 = this.userName.toCharArray();

                    for(int var9 = 0; var9 < var25.length; ++var9) {
                        var25[var9] = Character.toUpperCase(var25[var9]);
                    }

                    this.userName = String.copyValueOf(var25);
                }

                this.xaWantsError = false;
                this.usingXA = false;
                this.readOCIConnectionPoolProperties(var2);
                this.validateConnectionProperties();
            }
        }
    }

    private void readOCIConnectionPoolProperties(Properties var1) throws SQLException {
        this.ociConnectionPoolMinLimit = parseConnectionProperty_int(var1, "connpool_min_limit", (byte)1, 0);
        this.ociConnectionPoolMaxLimit = parseConnectionProperty_int(var1, "connpool_max_limit", (byte)1, 0);
        this.ociConnectionPoolIncrement = parseConnectionProperty_int(var1, "connpool_increment", (byte)1, 0);
        this.ociConnectionPoolTimeout = parseConnectionProperty_int(var1, "connpool_timeout", (byte)1, 0);
        this.ociConnectionPoolNoWait = parseConnectionProperty_boolean(var1, "connpool_nowait", (byte)1, false);
        this.ociConnectionPoolTransactionDistributed = parseConnectionProperty_boolean(var1, "transactions_distributed", (byte)1, false);
        this.ociConnectionPoolLogonMode = parseConnectionProperty_String(var1, "connection_pool", (byte)1, (String)null);
        this.ociConnectionPoolIsPooling = parseConnectionProperty_boolean(var1, "is_connection_pooling", (byte)1, false);
        this.ociConnectionPoolObject = parseConnectionProperty_Object(var1, "connpool_object", (Object)null);
        this.ociConnectionPoolConnID = parseConnectionProperty_Object(var1, "connection_id", (Object)null);
        this.ociConnectionPoolProxyType = parseConnectionProperty_String(var1, "proxytype", (byte)1, (String)null);
        this.ociConnectionPoolProxyNumRoles = (Integer)parseConnectionProperty_Object(var1, "proxy_num_roles", 0);
        this.ociConnectionPoolProxyRoles = parseConnectionProperty_Object(var1, "proxy_roles", (Object)null);
        this.ociConnectionPoolProxyUserName = parseConnectionProperty_String(var1, "proxy_user_name", (byte)1, (String)null);
        this.ociConnectionPoolProxyPassword = parseConnectionProperty_String(var1, "proxy_password", (byte)1, (String)null);
        this.ociConnectionPoolProxyDistinguishedName = parseConnectionProperty_String(var1, "proxy_distinguished_name", (byte)1, (String)null);
        this.ociConnectionPoolProxyCertificate = parseConnectionProperty_Object(var1, "proxy_certificate", (Object)null);
    }

    void validateConnectionProperties() throws SQLException {
        if (this.driverNameAttribute != null && !driverNameAttributePattern.matcher(this.driverNameAttribute).matches()) {
            SQLException var1 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 257);
            var1.fillInStackTrace();
            throw var1;
        }
    }

    private static final Object parseConnectionProperty_Object(Properties var0, String var1, Object var2) throws SQLException {
        Object var3 = var2;
        if (var0 != null) {
            Object var4 = var0.get(var1);
            if (var4 != null) {
                var3 = var4;
            }
        }

        return var3;
    }

    private static final String parseConnectionProperty_String(Properties var0, String var1, byte var2, String var3) throws SQLException {
        String var4 = null;
        if ((var2 == 1 || var2 == 3) && var0 != null) {
            var4 = var0.getProperty(var1);
            if (var4 == null && !var1.startsWith("oracle.") && !var1.startsWith("java.") && !var1.startsWith("javax.")) {
                var4 = var0.getProperty("oracle.jdbc." + var1);
            }
        }

        if (var4 == null && (var2 == 2 || var2 == 3)) {
            if (!var1.startsWith("oracle.") && !var1.startsWith("java.") && !var1.startsWith("javax.")) {
                var4 = getSystemProperty("oracle.jdbc." + var1, (String)null);
            } else {
                var4 = getSystemProperty(var1, (String)null);
            }
        }

        if (var4 == null) {
            var4 = var3;
        }

        return var4;
    }

    private static final int parseConnectionProperty_int(Properties var0, String var1, byte var2, int var3) throws SQLException {
        int var4 = var3;
        String var5 = parseConnectionProperty_String(var0, var1, var2, (String)null);
        if (var5 != null) {
            try {
                var4 = Integer.parseInt(var5);
            } catch (NumberFormatException var8) {
                SQLException var7 = DatabaseError.createSqlException((oracle.jdbc.internal.OracleConnection)null, 190, "Property is '" + var1 + "' and value is '" + var5 + "'");
                var7.fillInStackTrace();
                throw var7;
            }
        }

        return var4;
    }

    private static final long parseConnectionProperty_long(Properties var0, String var1, byte var2, long var3) throws SQLException {
        long var5 = var3;
        String var7 = parseConnectionProperty_String(var0, var1, var2, (String)null);
        if (var7 != null) {
            try {
                var5 = Long.parseLong(var7);
            } catch (NumberFormatException var10) {
                SQLException var9 = DatabaseError.createSqlException((oracle.jdbc.internal.OracleConnection)null, 190, "Property is '" + var1 + "' and value is '" + var7 + "'");
                var9.fillInStackTrace();
                throw var9;
            }
        }

        return var5;
    }

    private static final boolean parseConnectionProperty_boolean(Properties var0, String var1, byte var2, boolean var3) throws SQLException {
        boolean var4 = var3;
        String var5 = parseConnectionProperty_String(var0, var1, var2, (String)null);
        if (var5 != null) {
            if (var5.equalsIgnoreCase("false")) {
                var4 = false;
            } else if (var5.equalsIgnoreCase("true")) {
                var4 = true;
            }
        }

        return var4;
    }

    private static String parseLoginOption(String var0, Properties var1, String[] var2, String[] var3) {
        boolean var5 = false;
        String var6 = null;
        String var7 = null;
        if (var0 == null) {
            return null;
        } else {
            int var8 = var0.length();
            if (var8 == 0) {
                return null;
            } else {
                int var4 = var0.indexOf(91);
                if (var4 > 0) {
                    int var11 = var0.indexOf(93);
                    var7 = var0.substring(var4 + 1, var11);
                    var7 = var7.trim();
                    if (var7.length() > 0) {
                        var3[0] = var7;
                    }

                    var0 = var0.substring(0, var4) + var0.substring(var11 + 1, var8);
                }

                String var9 = var0.toLowerCase();
                var4 = var9.lastIndexOf(" as ");
                if (var4 != -1 && var4 >= var9.lastIndexOf("\"")) {
                    var6 = var0.substring(0, var4);

                    for(var4 += 4; var4 < var8 && var9.charAt(var4) == ' '; ++var4) {
                    }

                    if (var4 == var8) {
                        return var0;
                    } else {
                        String var10 = var9.substring(var4).trim();
                        if (var10.length() > 0) {
                            var2[0] = var10;
                        }

                        return var6;
                    }
                } else {
                    return var0;
                }
            }
        }
    }

    static final Hashtable parseUrl(String var0, String var1, String var2) throws SQLException {
        Hashtable var3 = new Hashtable(5);
        int var4 = var0.indexOf(58, var0.indexOf(58) + 1) + 1;
        int var5 = var0.length();
        if (var4 == var5) {
            return var3;
        } else {
            int var6 = var0.indexOf(58, var4);
            if (var6 == -1) {
                return var3;
            } else {
                var3.put("protocol", var0.substring(var4, var6));
                int var7 = var6 + 1;
                int var8 = var0.indexOf(47, var7);
                int var9 = var0.indexOf(64, var7);
                if (var9 > var7 && var7 > var4 && var8 == -1) {
                    SQLException var12 = DatabaseError.createSqlException((oracle.jdbc.internal.OracleConnection)null, 67);
                    var12.fillInStackTrace();
                    throw var12;
                } else {
                    if (var9 == -1) {
                        var9 = var5;
                    }

                    if (var8 == -1) {
                        var8 = var9;
                    }

                    if (var8 < var9 && var8 != var7 && var9 != var7) {
                        var3.put("user", var0.substring(var7, var8));
                        var3.put("password", var0.substring(var8 + 1, var9));
                    }

                    if (var8 <= var9 && (var8 == var7 || var9 == var7) && var9 < var5) {
                        String var10 = var0.substring(var9 + 1);
                        String[] var11 = getSecretStoreCredentials(var10, var1, var2);
                        if (var11[0] != null || var11[1] != null) {
                            var3.put("user", var11[0]);
                            var3.put("password", var11[1]);
                        }
                    }

                    if (var9 < var5) {
                        var3.put("database", var0.substring(var9 + 1));
                    }

                    return var3;
                }
            }
        }
    }

    private static final synchronized String[] getSecretStoreCredentials(String var0, String var1, String var2) throws SQLException {
        String[] var3 = new String[]{null, null};
        if (var1 != null) {
            SQLException var5;
            try {
                if (var1.startsWith("(")) {
                    var1 = "file:" + CustomSSLSocketFactory.processWalletLocation(var1);
                }

                OracleWallet var4 = new OracleWallet();
                if (var4.exists(var1)) {
                    char[] var12 = null;
                    if (var2 != null) {
                        var12 = var2.toCharArray();
                    }

                    var4.open(var1, var12);
                    OracleSecretStore var6 = var4.getSecretStore();
                    if (var6.containsAlias("oracle.security.client.default_username")) {
                        var3[0] = new String(var6.getSecret("oracle.security.client.default_username"));
                    }

                    if (var6.containsAlias("oracle.security.client.default_password")) {
                        var3[1] = new String(var6.getSecret("oracle.security.client.default_password"));
                    }

                    Enumeration var7 = var4.getSecretStore().internalAliases();
                    String var8 = null;

                    while(var7.hasMoreElements()) {
                        var8 = (String)var7.nextElement();
                        if (var8.startsWith("oracle.security.client.connect_string") && var0.equalsIgnoreCase(new String(var6.getSecret(var8)))) {
                            String var9 = var8.substring("oracle.security.client.connect_string".length());
                            var3[0] = new String(var6.getSecret("oracle.security.client.username" + var9));
                            var3[1] = new String(var6.getSecret("oracle.security.client.password" + var9));
                            break;
                        }
                    }
                }
            } catch (NoClassDefFoundError var10) {
                var5 = DatabaseError.createSqlException((oracle.jdbc.internal.OracleConnection)null, 167, var10);
                var5.fillInStackTrace();
                throw var5;
            } catch (Exception var11) {
                if (var11 instanceof RuntimeException) {
                    throw (RuntimeException)var11;
                }

                var5 = DatabaseError.createSqlException((oracle.jdbc.internal.OracleConnection)null, 168, var11);
                var5.fillInStackTrace();
                throw var5;
            }
        }

        return var3;
    }

    private String translateConnStr(String var1) throws SQLException {
        int var3 = 0;
        boolean var4 = false;
        if (var1 != null && !var1.equals("")) {
            if (var1.indexOf(41) != -1) {
                return var1;
            } else {
                boolean var5 = false;
                SQLException var10;
                if (var1.indexOf(91) != -1) {
                    var3 = var1.indexOf(93);
                    if (var3 == -1) {
                        var10 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 67, var1);
                        var10.fillInStackTrace();
                        throw var10;
                    }

                    var5 = true;
                }

                var3 = var1.indexOf(58, var3);
                if (var3 == -1) {
                    return var1;
                } else {
                    int var9 = var1.indexOf(58, var3 + 1);
                    if (var9 == -1) {
                        return var1;
                    } else if (var1.indexOf(58, var9 + 1) != -1) {
                        var10 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 67, var1);
                        var10.fillInStackTrace();
                        throw var10;
                    } else {
                        String var6 = null;
                        if (var5) {
                            var6 = var1.substring(1, var3 - 1);
                        } else {
                            var6 = var1.substring(0, var3);
                        }

                        String var7 = var1.substring(var3 + 1, var9);
                        String var8 = var1.substring(var9 + 1, var1.length());
                        String var2 = "(DESCRIPTION=(ADDRESS=(PROTOCOL=tcp)(HOST=" + var6 + ")(PORT=" + var7 + "))(CONNECT_DATA=(SID=" + var8 + ")))";
                        return var2;
                    }
                }
            }
        } else {
            return var1;
        }
    }

    private String createNamedInstanceUrl(String var1, String var2) {
        StringBuffer var3 = new StringBuffer(var1);
        int var4 = var3.indexOf("CONNECT_DATA");
        if (var4 != -1) {
            int var5 = var3.indexOf("=", var4 + "CONNECT_DATA".length());
            if (var5 != -1) {
                var3.insert(var5 + 1, "(INSTANCE_NAME=" + var2 + ")");
            }
        }

        String var6 = var3.toString();
        return var6;
    }

    protected static String getSystemPropertyPollInterval() {
        return getSystemProperty("oracle.jdbc.TimeoutPollInterval", "1000");
    }

    static String getSqlTranslationProfile() {
        return getSystemProperty("oracle.jdbc.sqlTranslationProfile", (String)null);
    }

    static String getSystemPropertyFastConnectionFailover(String var0) {
        return getSystemProperty("oracle.jdbc.FastConnectionFailover", var0);
    }

    static String getSystemPropertyJserverVersion() {
        return getSystemProperty("oracle.jserver.version", (String)null);
    }

    private static String getSystemProperty(final String var0, final String var1) {
        if (var0 != null) {
            final String[] var4 = new String[]{var1};
            AccessController.doPrivileged(new PrivilegedAction() {
                public Object run() {
                    var4[0] = System.getProperty(var0, var1);
                    return null;
                }
            });
            return var4[0];
        } else {
            return var1;
        }
    }

    abstract void initializePassword(String var1) throws SQLException;

    public Properties getProperties() {
        Properties var1 = new Properties();

        try {
            Class var2 = null;
            Class var3 = null;

            try {
                var2 = Class.forName("oracle.jdbc.OracleConnection");
                var3 = Class.forName("oracle.jdbc.driver.PhysicalConnection");
            } catch (ClassNotFoundException var14) {
            }

            Field[] var4 = var3.getDeclaredFields();

            for(int var5 = 0; var5 < var4.length; ++var5) {
                int var6 = var4[var5].getModifiers();
                if (!Modifier.isStatic(var6)) {
                    String var7 = var4[var5].getName();
                    String var8 = "CONNECTION_PROPERTY_" + propertyVariableName(var7);
                    Field var9 = null;

                    try {
                        var9 = var2.getField(var8);
                    } catch (NoSuchFieldException var15) {
                        continue;
                    }

                    if (!var8.matches(".*PASSWORD.*")) {
                        String var10 = (String)var9.get((Object)null);
                        String var11 = var4[var5].getType().getName();
                        if (var11.equals("boolean")) {
                            boolean var12 = var4[var5].getBoolean(this);
                            if (var12) {
                                var1.setProperty(var10, "true");
                            } else {
                                var1.setProperty(var10, "false");
                            }
                        } else if (var11.equals("int")) {
                            int var17 = var4[var5].getInt(this);
                            var1.setProperty(var10, Integer.toString(var17));
                        } else if (var11.equals("long")) {
                            long var18 = var4[var5].getLong(this);
                            var1.setProperty(var10, Long.toString(var18));
                        } else if (var11.equals("java.lang.String")) {
                            String var19 = (String)var4[var5].get(this);
                            if (var19 != null) {
                                var1.setProperty(var10, var19);
                            }
                        }
                    }
                }
            }
        } catch (IllegalAccessException var16) {
        }

        return var1;
    }

    /** @deprecated */
    public synchronized Connection _getPC() {
        return null;
    }

    public synchronized oracle.jdbc.internal.OracleConnection getPhysicalConnection() {
        return this;
    }

    public synchronized boolean isLogicalConnection() {
        return false;
    }

    void initialize(Hashtable var1, Map var2, Map var3) throws SQLException {
        this.clearStatementMetaData = false;
        if (var1 != null) {
            this.descriptorCacheStack[this.dci] = var1;
        } else {
            this.descriptorCacheStack[this.dci] = new Hashtable(10);
        }

        this.map = var2;
        if (var3 != null) {
            this.javaObjectMap = var3;
        } else {
            this.javaObjectMap = new Hashtable(10);
        }

        this.lifecycle = 1;
        this.txnLevel = 2;
        this.clientIdSet = false;
    }

    void initializeSetCHARCharSetObjs() {
        this.setCHARNCharSetObj = this.conversion.getDriverNCharSetObj();
        this.setCHARCharSetObj = this.conversion.getDriverCharSetObj();
    }

    OracleTimeout getTimeout() throws SQLException {
        if (this.timeout == null) {
            this.timeout = OracleTimeout.newTimeout(this.url);
        }

        return this.timeout;
    }

    public synchronized Statement createStatement() throws SQLException {
        return this.createStatement(-1, -1);
    }

    public synchronized Statement createStatement(int var1, int var2) throws SQLException {
        if (this.lifecycle != 1) {
            SQLException var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 8);
            var4.fillInStackTrace();
            throw var4;
        } else {
            OracleStatement var3 = null;
            var3 = this.driverExtension.allocateStatement(this, var1, var2);
            return new OracleStatementWrapper(var3);
        }
    }

    public synchronized PreparedStatement prepareStatement(String var1) throws SQLException {
        return this.prepareStatement(var1, -1, -1);
    }

    /** @deprecated */
    public synchronized PreparedStatement prepareStatementWithKey(String var1) throws SQLException {
        SQLException var3;
        if (this.lifecycle != 1) {
            var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 8);
            var3.fillInStackTrace();
            throw var3;
        } else if (var1 == null) {
            return null;
        } else if (!this.isStatementCacheInitialized()) {
            var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 95);
            var3.fillInStackTrace();
            throw var3;
        } else {
            Object var2 = null;
            var2 = (OraclePreparedStatement)this.statementCache.searchExplicitCache(var1);
            if (var2 != null) {
                var2 = new OraclePreparedStatementWrapper((oracle.jdbc.OraclePreparedStatement)var2);
            }

            return (PreparedStatement)var2;
        }
    }

    public synchronized PreparedStatement prepareStatement(String var1, int var2, int var3) throws SQLException {
        OraclePreparedStatement var4 = this.prepareStatementInternal(var1, var2, var3);
        return new OraclePreparedStatementWrapper(var4);
    }

    OraclePreparedStatement prepareStatementInternal(String var1, int var2, int var3) throws SQLException {
        SQLException var4;
        if (var1 != null && var1.length() != 0) {
            if (this.lifecycle != 1) {
                var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 8);
                var4.fillInStackTrace();
                throw var4;
            } else {
                OraclePreparedStatement var6 = null;
                if (this.statementCache != null) {
                    ResultSetType var5 = ResultSetType.typeFor(var2, var3);
                    if (var5 == ResultSetType.UNKNOWN) {
                        var5 = OracleStatement.DEFAULT_RESULT_SET_TYPE;
                    }

                    var6 = (OraclePreparedStatement)this.statementCache.searchImplicitCache(var1, 1, var5.ordinal(), this);
                }

                if (var6 == null) {
                    var6 = this.driverExtension.allocatePreparedStatement(this, var1, var2, var3);
                }

                return var6;
            }
        } else {
            var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 104);
            var4.fillInStackTrace();
            throw var4;
        }
    }

    public synchronized CallableStatement prepareCall(String var1) throws SQLException {
        return this.prepareCall(var1, -1, -1);
    }

    public synchronized CallableStatement prepareCall(String var1, int var2, int var3) throws SQLException {
        SQLException var4;
        if (var1 != null && var1.length() != 0) {
            if (this.lifecycle != 1) {
                var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 8);
                var4.fillInStackTrace();
                throw var4;
            } else {
                OracleCallableStatement var6 = null;
                if (this.statementCache != null) {
                    ResultSetType var5 = ResultSetType.typeFor(var2, var3);
                    if (var5 == ResultSetType.UNKNOWN) {
                        var5 = OracleStatement.DEFAULT_RESULT_SET_TYPE;
                    }

                    var6 = (OracleCallableStatement)this.statementCache.searchImplicitCache(var1, 2, var5.ordinal(), this);
                }

                if (var6 == null) {
                    var6 = this.driverExtension.allocateCallableStatement(this, var1, var2, var3);
                }

                return new OracleCallableStatementWrapper((oracle.jdbc.OracleCallableStatement)var6);
            }
        } else {
            var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 104);
            var4.fillInStackTrace();
            throw var4;
        }
    }

    public synchronized CallableStatement prepareCallWithKey(String var1) throws SQLException {
        SQLException var3;
        if (this.lifecycle != 1) {
            var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 8);
            var3.fillInStackTrace();
            throw var3;
        } else if (var1 == null) {
            return null;
        } else if (!this.isStatementCacheInitialized()) {
            var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 95);
            var3.fillInStackTrace();
            throw var3;
        } else {
            Object var2 = null;
            var2 = (OracleCallableStatement)this.statementCache.searchExplicitCache(var1);
            if (var2 != null) {
                var2 = new OracleCallableStatementWrapper((oracle.jdbc.OracleCallableStatement)var2);
            }

            return (CallableStatement)var2;
        }
    }

    public String nativeSQL(String var1) throws SQLException {
        if (this.sqlObj == null) {
            this.sqlObj = new OracleSql(this.conversion);
        }

        this.sqlObj.initialize(var1);
        String var2 = this.sqlObj.getSql(this.processEscapes, this.convertNcharLiterals);
        return var2;
    }

    public synchronized void setAutoCommit(boolean var1) throws SQLException {
        if (var1) {
            this.disallowGlobalTxnMode(116);
        }

        if (this.lifecycle != 1) {
            SQLException var2 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 8);
            var2.fillInStackTrace();
            throw var2;
        } else {
            this.needLine();
            this.doSetAutoCommit(var1);
        }
    }

    public boolean getAutoCommit() throws SQLException {
        if (this.lifecycle != 1) {
            SQLException var1 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 8);
            var1.fillInStackTrace();
            throw var1;
        } else {
            return this.autocommit;
        }
    }

    public void cancel() throws SQLException {
        OracleStatement var1 = this.statements;
        if (this.lifecycle != 1 && this.lifecycle != 16) {
            SQLException var5 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 8);
            var5.fillInStackTrace();
            throw var5;
        } else {
            boolean var2;
            for(var2 = false; var1 != null; var1 = var1.next) {
                try {
                    if (var1.doCancel()) {
                        var2 = true;
                    }
                } catch (SQLException var4) {
                }
            }

            if (!var2) {
                this.cancelOperationOnServer(false);
            }

        }
    }

    public void commit(EnumSet<CommitOption> var1) throws SQLException {
        int var2 = 0;
        if (var1 != null) {
            if (var1.contains(CommitOption.WRITEBATCH) && var1.contains(CommitOption.WRITEIMMED) || var1.contains(CommitOption.WAIT) && var1.contains(CommitOption.NOWAIT)) {
                SQLException var5 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 191);
                var5.fillInStackTrace();
                throw var5;
            }

            CommitOption var4;
            for(Iterator var3 = var1.iterator(); var3.hasNext(); var2 |= var4.getCode()) {
                var4 = (CommitOption)var3.next();
            }
        }

        this.commit(var2);
    }

    synchronized void commit(int var1) throws SQLException {
        this.disallowGlobalTxnMode(114);
        SQLException var4;
        if (this.autoCommitSpecCompliant && this.getAutoCommit()) {
            var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 273);
            var4.fillInStackTrace();
            throw var4;
        } else if (this.lifecycle != 1) {
            var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 8);
            var4.fillInStackTrace();
            throw var4;
        } else {
            for(OracleStatement var2 = this.statements; var2 != null; var2 = var2.next) {
                if (!var2.closed) {
                    var2.sendBatch();
                }
            }

            if ((var1 & CommitOption.WRITEBATCH.getCode()) != 0 && (var1 & CommitOption.WRITEIMMED.getCode()) != 0 || (var1 & CommitOption.WAIT.getCode()) != 0 && (var1 & CommitOption.NOWAIT.getCode()) != 0) {
                SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 191);
                var3.fillInStackTrace();
                throw var3;
            } else {
                this.registerHeartbeat();
                this.needLine();
                this.doCommit(var1);
            }
        }
    }

    public void commit() throws SQLException {
        this.commit(this.commitOption);
    }

    public synchronized void rollback() throws SQLException {
        this.disallowGlobalTxnMode(115);
        SQLException var2;
        if (this.autoCommitSpecCompliant && this.getAutoCommit()) {
            var2 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 274);
            var2.fillInStackTrace();
            throw var2;
        } else if (this.lifecycle != 1) {
            var2 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 8);
            var2.fillInStackTrace();
            throw var2;
        } else {
            for(OracleStatement var1 = this.statements; var1 != null; var1 = var1.next) {
                if (var1.isOracleBatchStyle()) {
                    var1.clearBatch();
                }
            }

            this.registerHeartbeat();
            this.needLine();
            this.doRollback();
        }
    }

    public synchronized void close() throws SQLException {
        if (this.lifecycle != 2 && this.lifecycle != 4) {
            this.needLineUnchecked();

            try {
                if (this.closeCallback != null) {
                    this.closeCallback.beforeClose(this, this.privateData);
                }

                this.closeStatementCache();
                this.closeStatements(false);
                if (this.lifecycle == 1) {
                    this.lifecycle = 2;
                }

                if (this.isProxy) {
                    this.close(1);
                }

                if (this.timeZoneTab != null) {
                    this.timeZoneTab.freeInstance();
                }

                this.logoff();
                this.cleanup();
                if (this.timeout != null) {
                    this.timeout.close();
                }

                if (this.closeCallback != null) {
                    this.closeCallback.afterClose(this.privateData);
                }
            } finally {
                this.lifecycle = 4;
                this.isUsable = false;
            }

        }
    }

    public String getDataIntegrityAlgorithmName() throws SQLException {
        SQLException var1 = DatabaseError.createUnsupportedFeatureSqlException();
        var1.fillInStackTrace();
        throw var1;
    }

    public String getEncryptionAlgorithmName() throws SQLException {
        SQLException var1 = DatabaseError.createUnsupportedFeatureSqlException();
        var1.fillInStackTrace();
        throw var1;
    }

    public String getAuthenticationAdaptorName() throws SQLException {
        SQLException var1 = DatabaseError.createUnsupportedFeatureSqlException();
        var1.fillInStackTrace();
        throw var1;
    }

    public void closeInternal(boolean var1) throws SQLException {
        SQLException var2 = DatabaseError.createUnsupportedFeatureSqlException();
        var2.fillInStackTrace();
        throw var2;
    }

    public void cleanupAndClose(boolean var1) throws SQLException {
        SQLException var2 = DatabaseError.createUnsupportedFeatureSqlException();
        var2.fillInStackTrace();
        throw var2;
    }

    void cleanupAndClose() throws SQLException {
        if (this.lifecycle == 1) {
            this.lifecycle = 16;
            this.cancel();
        }
    }

    synchronized void closeLogicalConnection() throws SQLException {
        if (this.lifecycle == 1 || this.lifecycle == 16 || this.lifecycle == 2) {
            this.savepointStatement = null;
            this.closeStatements(true);
            if (this.clientIdSet) {
                this.clearClientIdentifier(this.clientId);
            }

            this.logicalConnectionAttached = null;
            this.lifecycle = 1;
        }

    }

    public synchronized void close(Properties var1) throws SQLException {
        SQLException var2 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 152);
        var2.fillInStackTrace();
        throw var2;
    }

    public synchronized void close(int var1) throws SQLException {
        if ((var1 & 4096) != 0) {
            this.close();
        } else {
            if ((var1 & 1) != 0 && this.isProxy) {
                this.purgeStatementCache();
                this.closeStatements(false);
                this.descriptorCacheStack[this.dci--] = null;
                this.closeProxySession();
                this.isProxy = false;
                this.autocommit = this.savedAutoCommitFlag;
                this.txnMode = this.savedTxnMode;
            }

        }
    }

    public void abort() throws SQLException {
        SecurityManager var1 = System.getSecurityManager();
        if (var1 != null) {
            var1.checkPermission(CALL_ORACLE_ABORT_PERMISSION);
        }

        if (this.lifecycle != 4 && this.lifecycle != 8) {
            this.lifecycle = 8;
            this.doAbort();
        }
    }

    abstract void doAbort() throws SQLException;

    void closeProxySession() throws SQLException {
        SQLException var1 = DatabaseError.createUnsupportedFeatureSqlException();
        var1.fillInStackTrace();
        throw var1;
    }

    public Properties getServerSessionInfo() throws SQLException {
        SQLException var1 = DatabaseError.createUnsupportedFeatureSqlException();
        var1.fillInStackTrace();
        throw var1;
    }

    public synchronized void applyConnectionAttributes(Properties var1) throws SQLException {
        SQLException var2 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 152);
        var2.fillInStackTrace();
        throw var2;
    }

    public synchronized Properties getConnectionAttributes() throws SQLException {
        SQLException var1 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 152);
        var1.fillInStackTrace();
        throw var1;
    }

    public synchronized Properties getUnMatchedConnectionAttributes() throws SQLException {
        SQLException var1 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 152);
        var1.fillInStackTrace();
        throw var1;
    }

    public synchronized void setAbandonedTimeoutEnabled(boolean var1) throws SQLException {
        SQLException var2 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 152);
        var2.fillInStackTrace();
        throw var2;
    }

    public synchronized void registerConnectionCacheCallback(OracleConnectionCacheCallback var1, Object var2, int var3) throws SQLException {
        SQLException var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 152);
        var4.fillInStackTrace();
        throw var4;
    }

    public OracleConnectionCacheCallback getConnectionCacheCallbackObj() throws SQLException {
        SQLException var1 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 152);
        var1.fillInStackTrace();
        throw var1;
    }

    public Object getConnectionCacheCallbackPrivObj() throws SQLException {
        SQLException var1 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 152);
        var1.fillInStackTrace();
        throw var1;
    }

    public int getConnectionCacheCallbackFlag() throws SQLException {
        SQLException var1 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 152);
        var1.fillInStackTrace();
        throw var1;
    }

    public synchronized void setConnectionReleasePriority(int var1) throws SQLException {
        SQLException var2 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 152);
        var2.fillInStackTrace();
        throw var2;
    }

    public int getConnectionReleasePriority() throws SQLException {
        SQLException var1 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 152);
        var1.fillInStackTrace();
        throw var1;
    }

    public synchronized boolean isClosed() throws SQLException {
        return this.lifecycle != 1;
    }

    public synchronized boolean isProxySession() {
        return this.isProxy;
    }

    public synchronized void openProxySession(int var1, Properties var2) throws SQLException {
        boolean var3 = true;
        if (this.isProxy) {
            SQLException var15 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 149);
            var15.fillInStackTrace();
            throw var15;
        } else {
            String var4 = var2.getProperty("PROXY_USER_NAME");
            String var5 = var2.getProperty("PROXY_USER_PASSWORD");
            String var6 = var2.getProperty("PROXY_DISTINGUISHED_NAME");
            Object var7 = var2.get("PROXY_CERTIFICATE");
            SQLException var8;
            if (var1 == 1) {
                if (var4 == null && var5 == null) {
                    var8 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 150);
                    var8.fillInStackTrace();
                    throw var8;
                }
            } else if (var1 == 2) {
                if (var6 == null) {
                    var8 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 150);
                    var8.fillInStackTrace();
                    throw var8;
                }
            } else {
                if (var1 != 3) {
                    var8 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 150);
                    var8.fillInStackTrace();
                    throw var8;
                }

                if (var7 == null) {
                    var8 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 150);
                    var8.fillInStackTrace();
                    throw var8;
                }

                try {
                    byte[] var16 = (byte[])((byte[])var7);
                } catch (ClassCastException var13) {
                    SQLException var9 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 150);
                    var9.fillInStackTrace();
                    throw var9;
                }
            }

            this.purgeStatementCache();
            this.closeStatements(false);

            try {
                this.doProxySession(var1, var2);
                ++this.dci;
                this.savedAutoCommitFlag = this.autocommit;
                this.autocommit = this.defaultautocommit;
                this.savedTxnMode = this.txnMode;
                this.txnMode = 0;
                var3 = false;
            } finally {
                if (var3) {
                    this.closeProxySession();
                }

            }

        }
    }

    void doProxySession(int var1, Properties var2) throws SQLException {
        SQLException var3 = DatabaseError.createUnsupportedFeatureSqlException();
        var3.fillInStackTrace();
        throw var3;
    }

    void cleanup() {
        this.fdo = null;
        this.conversion = null;
        this.statements = null;
        this.descriptorCacheStack[this.dci] = null;
        this.map = null;
        this.javaObjectMap = null;
        this.statementHoldingLine = null;
        this.sqlObj = null;
        this.isProxy = false;
        this.blockSource = null;
        this.connectionBufferCacheStore = null;
        threadLocalBufferCacheStore = null;
    }

    public synchronized DatabaseMetaData getMetaData() throws SQLException {
        if (this.lifecycle != 1) {
            SQLException var1 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 8);
            var1.fillInStackTrace();
            throw var1;
        } else {
            if (this.databaseMetaData == null) {
                this.databaseMetaData = new oracle.jdbc.driver.OracleDatabaseMetaData(this);
            }

            return this.databaseMetaData;
        }
    }

    public void setReadOnly(boolean var1) throws SQLException {
        if (this.lifecycle != 1) {
            SQLException var2 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 8);
            var2.fillInStackTrace();
            throw var2;
        } else {
            this.readOnly = var1;
        }
    }

    public boolean isReadOnly() throws SQLException {
        if (this.lifecycle != 1) {
            SQLException var1 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 8);
            var1.fillInStackTrace();
            throw var1;
        } else {
            return this.readOnly;
        }
    }

    public void setCatalog(String var1) throws SQLException {
        if (this.lifecycle != 1) {
            SQLException var2 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 8);
            var2.fillInStackTrace();
            throw var2;
        }
    }

    public String getCatalog() throws SQLException {
        if (this.lifecycle != 1) {
            SQLException var1 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 8);
            var1.fillInStackTrace();
            throw var1;
        } else {
            return null;
        }
    }

    public synchronized void setTransactionIsolation(int var1) throws SQLException {
        if (this.lifecycle != 1) {
            SQLException var7 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 8);
            var7.fillInStackTrace();
            throw var7;
        } else if (this.txnLevel != var1) {
            Statement var2 = this.createStatement();

            try {
                switch(var1) {
                    case 2:
                        var2.execute("ALTER SESSION SET ISOLATION_LEVEL = READ COMMITTED");
                        this.txnLevel = 2;
                        break;
                    case 8:
                        var2.execute("ALTER SESSION SET ISOLATION_LEVEL = SERIALIZABLE");
                        this.txnLevel = 8;
                        break;
                    default:
                        SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 30);
                        var3.fillInStackTrace();
                        throw var3;
                }
            } finally {
                var2.close();
            }

        }
    }

    public int getTransactionIsolation() throws SQLException {
        if (this.lifecycle != 1) {
            SQLException var1 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 8);
            var1.fillInStackTrace();
            throw var1;
        } else {
            return this.txnLevel;
        }
    }

    public synchronized void setAutoClose(boolean var1) throws SQLException {
        if (!var1) {
            SQLException var2 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 31);
            var2.fillInStackTrace();
            throw var2;
        }
    }

    public boolean getAutoClose() throws SQLException {
        return true;
    }

    public SQLWarning getWarnings() throws SQLException {
        if (this.lifecycle != 1) {
            SQLException var1 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 8);
            var1.fillInStackTrace();
            throw var1;
        } else {
            return this.sqlWarning;
        }
    }

    public void clearWarnings() throws SQLException {
        if (this.lifecycle != 1) {
            SQLException var1 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 8);
            var1.fillInStackTrace();
            throw var1;
        } else {
            this.sqlWarning = null;
        }
    }

    void setWarnings(SQLWarning var1) {
        this.sqlWarning = var1;
    }

    public void setDefaultRowPrefetch(int var1) throws SQLException {
        if (var1 <= 0) {
            SQLException var2 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 20);
            var2.fillInStackTrace();
            throw var2;
        } else {
            this.defaultRowPrefetch = var1;
        }
    }

    public int getDefaultRowPrefetch() {
        return this.defaultRowPrefetch;
    }

    public boolean getTimestamptzInGmt() {
        return this.timestamptzInGmt;
    }

    public boolean getUse1900AsYearForTime() {
        return this.use1900AsYearForTime;
    }

    public synchronized void setDefaultExecuteBatch(int var1) throws SQLException {
        if (var1 <= 0) {
            SQLException var2 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 42);
            var2.fillInStackTrace();
            throw var2;
        } else {
            this.defaultExecuteBatch = var1;
        }
    }

    public synchronized int getDefaultExecuteBatch() {
        return this.defaultExecuteBatch;
    }

    public synchronized void setRemarksReporting(boolean var1) {
        this.reportRemarks = var1;
    }

    public synchronized boolean getRemarksReporting() {
        return this.reportRemarks;
    }

    public void setIncludeSynonyms(boolean var1) {
        this.includeSynonyms = var1;
    }

    public synchronized String[] getEndToEndMetrics() throws SQLException {
        String[] var1;
        if (this.endToEndValues == null) {
            var1 = null;
        } else {
            var1 = new String[4];
            System.arraycopy(this.endToEndValues, 0, var1, 0, 4);
        }

        return var1;
    }

    public short getEndToEndECIDSequenceNumber() throws SQLException {
        return this.endToEndECIDSequenceNumber;
    }

    public synchronized void setEndToEndMetrics(String[] var1, short var2) throws SQLException {
        String[] var3 = new String[var1.length];
        System.arraycopy(var1, 0, var3, 0, var1.length);
        this.setEndToEndMetricsInternal(var3, var2);
    }

    void setEndToEndMetricsInternal(String[] var1, short var2) throws SQLException {
        if (var1 != this.endToEndValues) {
            if (var1.length != 4) {
                SQLException var6 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 156);
                var6.fillInStackTrace();
                throw var6;
            }

            int var3;
            String var4;
            for(var3 = 0; var3 < 4; ++var3) {
                var4 = var1[var3];
                if (var4 != null && var4.length() > this.endToEndMaxLength[var3]) {
                    SQLException var5 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 159, var4);
                    var5.fillInStackTrace();
                    throw var5;
                }
            }

            if (this.endToEndValues != null) {
                var3 = 0;

                while(true) {
                    if (var3 >= 4) {
                        boolean[] var10000 = this.endToEndHasChanged;
                        var10000[0] |= this.endToEndHasChanged[3];
                        break;
                    }

                    var4 = var1[var3];
                    if (var4 == null && this.endToEndValues[var3] != null || var4 != null && !var4.equals(this.endToEndValues[var3])) {
                        this.endToEndHasChanged[var3] = true;
                        this.endToEndAnyChanged = true;
                    }

                    ++var3;
                }
            } else {
                for(var3 = 0; var3 < 4; ++var3) {
                    this.endToEndHasChanged[var3] = true;
                }

                this.endToEndAnyChanged = true;
            }

            System.arraycopy(var1, 0, this.endToEndValues, 0, 4);

            for(var3 = 0; var3 < 4; ++var3) {
                if (var1[var3] == null) {
                    this.clientInfo.remove(END_TO_END_CLIENTINFO_KEYS[var3]);
                } else {
                    this.clientInfo.put(END_TO_END_CLIENTINFO_KEYS[var3], var1[var3]);
                }
            }
        }

        this.endToEndECIDSequenceNumber = var2;
        this.clientInfo.put("OCSID.SEQUENCE_NUMBER", Short.toString(var2));
    }

    void updateSystemContext() throws SQLException {
    }

    void resetSystemContext() {
    }

    void updateSystemContext11() throws SQLException {
    }

    public boolean getIncludeSynonyms() {
        return this.includeSynonyms;
    }

    public void setRestrictGetTables(boolean var1) {
        this.restrictGettables = var1;
    }

    public boolean getRestrictGetTables() {
        return this.restrictGettables;
    }

    public void setDefaultFixedString(boolean var1) {
        this.fixedString = var1;
    }

    void setDefaultNChar(boolean var1) {
        this.defaultnchar = var1;
    }

    public boolean getDefaultFixedString() {
        return this.fixedString;
    }

    int getNlsRatio() {
        return 1;
    }

    public int getC2SNlsRatio() {
        return 1;
    }

    synchronized void addStatement(OracleStatement var1) {
        if (var1.next != null) {
            throw new Error("add_statement called twice on " + var1);
        } else {
            var1.next = this.statements;
            if (this.statements != null) {
                this.statements.prev = var1;
            }

            this.statements = var1;
        }
    }

    synchronized void removeStatement(OracleStatement var1) {
        OracleStatement var2 = var1.prev;
        OracleStatement var3 = var1.next;
        if (var2 == null) {
            if (this.statements != var1) {
                return;
            }

            this.statements = var3;
        } else {
            var2.next = var3;
        }

        if (var3 != null) {
            var3.prev = var2;
        }

        var1.next = null;
        var1.prev = null;
    }

    synchronized void closeStatements(boolean var1) throws SQLException {
        OracleStatement var2;
        OracleStatement var3;
        for(var2 = this.statements; var2 != null; var2 = var3) {
            var3 = var2.nextChild;
            if (var2.serverCursor) {
                var2.close();
                this.removeStatement(var2);
            }
        }

        for(var2 = this.statements; var2 != null; var2 = var3) {
            var3 = var2.next;
            if (var1) {
                var2.close();
            } else {
                var2.hardClose();
                var2.closeWrapper();
            }

            this.removeStatement(var2);
        }

    }

    final void purgeStatementCache() throws SQLException {
        if (this.isStatementCacheInitialized()) {
            this.statementCache.purgeImplicitCache();
            this.statementCache.purgeExplicitCache();
        }

    }

    final void closeStatementCache() throws SQLException {
        if (this.isStatementCacheInitialized()) {
            this.statementCache.close();
            this.statementCache = null;
            this.clearStatementMetaData = true;
        }

    }

    void needLine() throws SQLException {
        if (this.lifecycle != 1) {
            SQLException var1 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 8);
            var1.fillInStackTrace();
            throw var1;
        } else {
            this.needLineUnchecked();
        }
    }

    synchronized void needLineUnchecked() throws SQLException {
        if (this.statementHoldingLine != null) {
            this.statementHoldingLine.freeLine();
        }

    }

    synchronized void holdLine(oracle.jdbc.internal.OracleStatement var1) {
        this.holdLine((OracleStatement)var1);
    }

    synchronized void holdLine(OracleStatement var1) {
        this.statementHoldingLine = var1;
    }

    synchronized void releaseLine() {
        this.releaseLineForCancel();
    }

    void releaseLineForCancel() {
        this.statementHoldingLine = null;
    }

    public synchronized void startup(String var1, int var2) throws SQLException {
        SQLException var3;
        if (this.lifecycle != 1) {
            var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 8);
            var3.fillInStackTrace();
            throw var3;
        } else {
            var3 = DatabaseError.createUnsupportedFeatureSqlException();
            var3.fillInStackTrace();
            throw var3;
        }
    }

    public synchronized void startup(DatabaseStartupMode var1) throws SQLException {
        SQLException var2;
        if (this.lifecycle != 1) {
            var2 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 8);
            var2.fillInStackTrace();
            throw var2;
        } else if (var1 == null) {
            var2 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 68);
            var2.fillInStackTrace();
            throw var2;
        } else {
            this.needLine();
            this.doStartup(var1.getMode());
        }
    }

    void doStartup(int var1) throws SQLException {
        SQLException var2 = DatabaseError.createUnsupportedFeatureSqlException();
        var2.fillInStackTrace();
        throw var2;
    }

    public synchronized void shutdown(DatabaseShutdownMode var1) throws SQLException {
        SQLException var2;
        if (this.lifecycle != 1) {
            var2 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 8);
            var2.fillInStackTrace();
            throw var2;
        } else if (var1 == null) {
            var2 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 68);
            var2.fillInStackTrace();
            throw var2;
        } else {
            this.needLine();
            this.doShutdown(var1.getMode());
        }
    }

    void doShutdown(int var1) throws SQLException {
        SQLException var2 = DatabaseError.createUnsupportedFeatureSqlException();
        var2.fillInStackTrace();
        throw var2;
    }

    public synchronized void archive(int var1, int var2, String var3) throws SQLException {
        SQLException var4;
        if (this.lifecycle != 1) {
            var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 8);
            var4.fillInStackTrace();
            throw var4;
        } else {
            var4 = DatabaseError.createUnsupportedFeatureSqlException();
            var4.fillInStackTrace();
            throw var4;
        }
    }

    public synchronized void registerSQLType(String var1, String var2) throws SQLException {
        if (var1 != null && var2 != null) {
            try {
                this.registerSQLType(var1, Class.forName(var2));
            } catch (ClassNotFoundException var5) {
                SQLException var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 1, "Class not found: " + var2);
                var4.fillInStackTrace();
                throw var4;
            }
        } else {
            SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 68);
            var3.fillInStackTrace();
            throw var3;
        }
    }

    public synchronized void registerSQLType(String var1, Class var2) throws SQLException {
        if (var1 != null && var2 != null) {
            if (this.map == null) {
                this.map = new Hashtable(10);
            }

            this.map.put(var1, var2);
            this.map.put(var2.getName(), var1);
        } else {
            SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 68);
            var3.fillInStackTrace();
            throw var3;
        }
    }

    public synchronized String getSQLType(Object var1) throws SQLException {
        if (var1 != null && this.map != null) {
            String var2 = var1.getClass().getName();
            return (String)this.map.get(var2);
        } else {
            return null;
        }
    }

    public synchronized Object getJavaObject(String var1) throws SQLException {
        Object var2 = null;

        try {
            if (var1 != null && this.map != null) {
                Class var3 = (Class)this.map.get(var1);
                var2 = var3.newInstance();
            }
        } catch (IllegalAccessException var4) {
            var4.printStackTrace();
        } catch (InstantiationException var5) {
            var5.printStackTrace();
        }

        return var2;
    }

    public synchronized void putDescriptor(String var1, Object var2) throws SQLException {
        if (var1 != null && var2 != null) {
            if (this.descriptorCacheStack[this.dci] == null) {
                this.descriptorCacheStack[this.dci] = new Hashtable(10);
            }

            ((TypeDescriptor)var2).fixupConnection(this);
            this.descriptorCacheStack[this.dci].put(var1, var2);
        } else {
            SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 68);
            var3.fillInStackTrace();
            throw var3;
        }
    }

    public synchronized Object getDescriptor(String var1) {
        Object var2 = null;
        if (var1 != null) {
            if (this.descriptorCacheStack[this.dci] != null) {
                var2 = this.descriptorCacheStack[this.dci].get(var1);
            }

            if (var2 == null && this.dci == 1 && this.descriptorCacheStack[0] != null) {
                var2 = this.descriptorCacheStack[0].get(var1);
            }
        }

        return var2;
    }

    public synchronized void removeDescriptor(String var1) {
        if (var1 != null && this.descriptorCacheStack[this.dci] != null) {
            this.descriptorCacheStack[this.dci].remove(var1);
        }

        if (var1 != null && this.dci == 1 && this.descriptorCacheStack[0] != null) {
            this.descriptorCacheStack[0].remove(var1);
        }

    }

    public synchronized void removeAllDescriptor() {
        for(int var1 = 0; var1 <= this.dci; ++var1) {
            if (this.descriptorCacheStack[var1] != null) {
                this.descriptorCacheStack[var1].clear();
            }
        }

    }

    public int numberOfDescriptorCacheEntries() {
        int var1 = 0;

        for(int var2 = 0; var2 <= this.dci; ++var2) {
            if (this.descriptorCacheStack[var2] != null) {
                var1 += this.descriptorCacheStack[var2].size();
            }
        }

        return var1;
    }

    public Enumeration descriptorCacheKeys() {
        if (this.dci == 0) {
            return this.descriptorCacheStack[this.dci] != null ? this.descriptorCacheStack[this.dci].keys() : null;
        } else if (this.descriptorCacheStack[0] == null && this.descriptorCacheStack[1] != null) {
            return this.descriptorCacheStack[1].keys();
        } else if (this.descriptorCacheStack[1] == null && this.descriptorCacheStack[0] != null) {
            return this.descriptorCacheStack[0].keys();
        } else if (this.descriptorCacheStack[0] == null && this.descriptorCacheStack[1] == null) {
            return null;
        } else {
            Vector var1 = new Vector(this.descriptorCacheStack[1].keySet());
            var1.addAll(this.descriptorCacheStack[0].keySet());
            return var1.elements();
        }
    }

    public synchronized void putDescriptor(byte[] var1, Object var2) throws SQLException {
        if (var1 != null && var2 != null) {
            if (this.descriptorCacheStack[this.dci] == null) {
                this.descriptorCacheStack[this.dci] = new Hashtable(10);
            }

            this.descriptorCacheStack[this.dci].put(new ByteArrayKey(var1), var2);
        } else {
            SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 68);
            var3.fillInStackTrace();
            throw var3;
        }
    }

    public synchronized Object getDescriptor(byte[] var1) {
        Object var2 = null;
        if (var1 != null) {
            ByteArrayKey var3 = new ByteArrayKey(var1);
            if (this.descriptorCacheStack[this.dci] != null) {
                var2 = this.descriptorCacheStack[this.dci].get(var3);
            }

            if (var2 == null && this.dci == 1 && this.descriptorCacheStack[0] != null) {
                var2 = this.descriptorCacheStack[0].get(var3);
            }
        }

        return var2;
    }

    public short getJdbcCsId() throws SQLException {
        if (this.conversion == null) {
            SQLException var1 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 65);
            var1.fillInStackTrace();
            throw var1;
        } else {
            return this.conversion.getClientCharSet();
        }
    }

    public short getDbCsId() throws SQLException {
        if (this.conversion == null) {
            SQLException var1 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 65);
            var1.fillInStackTrace();
            throw var1;
        } else {
            return this.conversion.getServerCharSetId();
        }
    }

    short getNCsId() throws SQLException {
        if (this.conversion == null) {
            SQLException var1 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 65);
            var1.fillInStackTrace();
            throw var1;
        } else {
            return this.conversion.getNCharSetId();
        }
    }

    public short getStructAttrCsId() throws SQLException {
        return this.getDbCsId();
    }

    public short getStructAttrNCsId() throws SQLException {
        return this.getNCsId();
    }

    public synchronized Map getTypeMap() throws SQLException {
        if (this.map == null) {
            this.map = new Hashtable(10);
        }

        return this.map;
    }

    public synchronized void setTypeMap(Map var1) throws SQLException {
        if (this.lifecycle != 1) {
            SQLException var2 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 8);
            var2.fillInStackTrace();
            throw var2;
        } else {
            this.map = var1;
        }
    }

    public synchronized void setUsingXAFlag(boolean var1) {
        this.usingXA = var1;
    }

    public synchronized boolean getUsingXAFlag() {
        return this.usingXA;
    }

    public synchronized void setXAErrorFlag(boolean var1) {
        this.xaWantsError = var1;
    }

    public synchronized boolean getXAErrorFlag() {
        return this.xaWantsError;
    }

    String getPropertyFromDatabase(String var1) throws SQLException {
        String var2 = null;
        Statement var3 = null;
        ResultSet var4 = null;
        this.beginNonRequestCalls();

        try {
            var3 = this.createStatement();
            var3.setFetchSize(1);
            var4 = var3.executeQuery(var1);
            if (var4.next()) {
                var2 = var4.getString(1);
            }
        } finally {
            if (var4 != null) {
                var4.close();
            }

            if (var3 != null) {
                var3.close();
            }

            this.endNonRequestCalls();
        }

        return var2;
    }

    public synchronized String getUserName() throws SQLException {
        if (this.userName == null) {
            this.userName = this.getPropertyFromDatabase("SELECT USER FROM DUAL");
        }

        return this.userName;
    }

    public String getCurrentSchema() throws SQLException {
        return this.getPropertyFromDatabase("SELECT SYS_CONTEXT('USERENV', 'CURRENT_SCHEMA') FROM DUAL");
    }

    public String getDefaultSchemaNameForNamedTypes() throws SQLException {
        String var1 = null;
        if (this.createDescriptorUseCurrentSchemaForSchemaName) {
            var1 = this.getCurrentSchema();
        } else {
            var1 = this.getUserName();
        }

        return var1;
    }

    public synchronized void setStartTime(long var1) throws SQLException {
        SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 152);
        var3.fillInStackTrace();
        throw var3;
    }

    public synchronized long getStartTime() throws SQLException {
        SQLException var1 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 152);
        var1.fillInStackTrace();
        throw var1;
    }

    void registerHeartbeat() throws SQLException {
        if (this.logicalConnectionAttached != null) {
            this.logicalConnectionAttached.registerHeartbeat();
        }

    }

    public int getHeartbeatNoChangeCount() throws SQLException {
        SQLException var1 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 152);
        var1.fillInStackTrace();
        throw var1;
    }

    public synchronized byte[] getFDO(boolean var1) throws SQLException {
        if (this.fdo == null && var1) {
            CallableStatement var2 = null;
            this.beginNonRequestCalls();

            try {
                var2 = this.prepareCall("begin :1 := dbms_pickler.get_format (:2); end;");
                var2.registerOutParameter(1, 2);
                var2.registerOutParameter(2, -4);
                var2.execute();
                this.fdo = var2.getBytes(2);
            } finally {
                if (var2 != null) {
                    var2.close();
                }

                var2 = null;
                this.endNonRequestCalls();
            }
        }

        return this.fdo;
    }

    public synchronized void setFDO(byte[] var1) throws SQLException {
        this.fdo = var1;
    }

    public synchronized boolean getBigEndian() throws SQLException {
        if (this.bigEndian == null) {
            int[] var1 = Util.toJavaUnsignedBytes(this.getFDO(true));
            int var2 = var1[6 + var1[5] + var1[6] + 5];
            int var3 = (byte)(var2 & 16);
            if (var3 < 0) {
                var3 += 256;
            }

            if (var3 > 0) {
                this.bigEndian = Boolean.TRUE;
            } else {
                this.bigEndian = Boolean.FALSE;
            }
        }

        return this.bigEndian;
    }

    public void setHoldability(int var1) throws SQLException {
        SQLException var2;
        if (this.lifecycle != 1) {
            var2 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 8);
            var2.fillInStackTrace();
            throw var2;
        } else if (!this.getMetaData().supportsResultSetHoldability(var1)) {
            var2 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 162);
            var2.fillInStackTrace();
            throw var2;
        }
    }

    public int getHoldability() throws SQLException {
        if (this.lifecycle != 1) {
            SQLException var1 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 8);
            var1.fillInStackTrace();
            throw var1;
        } else {
            return 1;
        }
    }

    public synchronized Savepoint setSavepoint() throws SQLException {
        return this.oracleSetSavepoint();
    }

    public synchronized Savepoint setSavepoint(String var1) throws SQLException {
        return this.oracleSetSavepoint(var1);
    }

    public synchronized void rollback(Savepoint var1) throws SQLException {
        this.disallowGlobalTxnMode(115);
        if (this.autocommit) {
            SQLException var5 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 121);
            var5.fillInStackTrace();
            throw var5;
        } else {
            if (this.savepointStatement == null) {
                this.savepointStatement = this.createStatement();
            }

            String var2 = null;
            if (var1 != null) {
                try {
                    var2 = var1.getSavepointName();
                } catch (SQLException var4) {
                    var2 = "ORACLE_SVPT_" + var1.getSavepointId();
                }
            }

            this.savepointStatement.executeUpdate("ROLLBACK TO " + var2);
        }
    }

    public synchronized void releaseSavepoint(Savepoint var1) throws SQLException {
        SQLException var2 = DatabaseError.createUnsupportedFeatureSqlException();
        var2.fillInStackTrace();
        throw var2;
    }

    public Statement createStatement(int var1, int var2, int var3) throws SQLException {
        if (!this.getMetaData().supportsResultSetHoldability(var3)) {
            SQLException var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 162);
            var4.fillInStackTrace();
            throw var4;
        } else {
            return this.createStatement(var1, var2);
        }
    }

    public PreparedStatement prepareStatement(String var1, int var2, int var3, int var4) throws SQLException {
        if (!this.getMetaData().supportsResultSetHoldability(var4)) {
            SQLException var5 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 162);
            var5.fillInStackTrace();
            throw var5;
        } else {
            return this.prepareStatement(var1, var2, var3);
        }
    }

    public CallableStatement prepareCall(String var1, int var2, int var3, int var4) throws SQLException {
        if (!this.getMetaData().supportsResultSetHoldability(var4)) {
            SQLException var5 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 162);
            var5.fillInStackTrace();
            throw var5;
        } else {
            return this.prepareCall(var1, var2, var3);
        }
    }

    public PreparedStatement prepareStatement(String var1, int var2) throws SQLException {
        AutoKeyInfo var3 = new AutoKeyInfo(var1);
        if (var2 != 2 && var3.isInsertSqlStmt()) {
            if (var2 != 1) {
                SQLException var7 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 68);
                var7.fillInStackTrace();
                throw var7;
            } else {
                String var4 = var3.getNewSql();
                oracle.jdbc.OraclePreparedStatement var5 = (oracle.jdbc.OraclePreparedStatement)this.prepareStatement(var4);
                OraclePreparedStatement var6 = (OraclePreparedStatement)((OraclePreparedStatementWrapper)var5).preparedStatement;
                var6.isAutoGeneratedKey = true;
                var6.autoKeyInfo = var3;
                var6.registerReturnParamsForAutoKey();
                return var5;
            }
        } else {
            return this.prepareStatement(var1);
        }
    }

    public PreparedStatement prepareStatement(String var1, int[] var2) throws SQLException {
        AutoKeyInfo var3 = new AutoKeyInfo(var1, var2);
        if (!var3.isInsertSqlStmt()) {
            return this.prepareStatement(var1);
        } else if (var2 != null && var2.length != 0) {
            this.doDescribeTable(var3);
            String var7 = var3.getNewSql();
            oracle.jdbc.OraclePreparedStatement var5 = (oracle.jdbc.OraclePreparedStatement)this.prepareStatement(var7);
            OraclePreparedStatement var6 = (OraclePreparedStatement)((OraclePreparedStatementWrapper)var5).preparedStatement;
            var6.isAutoGeneratedKey = true;
            var6.autoKeyInfo = var3;
            var6.registerReturnParamsForAutoKey();
            return var5;
        } else {
            SQLException var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 68);
            var4.fillInStackTrace();
            throw var4;
        }
    }

    public PreparedStatement prepareStatement(String var1, String[] var2) throws SQLException {
        AutoKeyInfo var3 = new AutoKeyInfo(var1, var2);
        if (!var3.isInsertSqlStmt()) {
            return this.prepareStatement(var1);
        } else if (var2 != null && var2.length != 0) {
            this.doDescribeTable(var3);
            String var7 = var3.getNewSql();
            oracle.jdbc.OraclePreparedStatement var5 = (oracle.jdbc.OraclePreparedStatement)this.prepareStatement(var7);
            OraclePreparedStatement var6 = (OraclePreparedStatement)((OraclePreparedStatementWrapper)var5).preparedStatement;
            var6.isAutoGeneratedKey = true;
            var6.autoKeyInfo = var3;
            var6.registerReturnParamsForAutoKey();
            return var5;
        } else {
            SQLException var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 68);
            var4.fillInStackTrace();
            throw var4;
        }
    }

    public synchronized OracleSavepoint oracleSetSavepoint() throws SQLException {
        this.disallowGlobalTxnMode(117);
        if (this.autocommit) {
            SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 120);
            var3.fillInStackTrace();
            throw var3;
        } else {
            if (this.savepointStatement == null) {
                this.savepointStatement = this.createStatement();
            }

            oracle.jdbc.driver.OracleSavepoint var1 = new oracle.jdbc.driver.OracleSavepoint();
            String var2 = "SAVEPOINT ORACLE_SVPT_" + var1.getSavepointId();
            this.savepointStatement.executeUpdate(var2);
            return var1;
        }
    }

    public synchronized OracleSavepoint oracleSetSavepoint(String var1) throws SQLException {
        this.disallowGlobalTxnMode(117);
        if (this.autocommit) {
            SQLException var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 120);
            var4.fillInStackTrace();
            throw var4;
        } else {
            if (this.savepointStatement == null) {
                this.savepointStatement = this.createStatement();
            }

            oracle.jdbc.driver.OracleSavepoint var2 = new oracle.jdbc.driver.OracleSavepoint(var1);
            String var3;
            if (var2.getType() == 1) {
                var3 = "SAVEPOINT ORACLE_SVPT_" + var2.getSavepointId();
            } else {
                var3 = "SAVEPOINT " + var2.getSavepointName();
            }

            this.savepointStatement.executeUpdate(var3);
            return var2;
        }
    }

    public synchronized void oracleRollback(OracleSavepoint var1) throws SQLException {
        this.disallowGlobalTxnMode(115);
        if (this.autocommit) {
            SQLException var5 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 121);
            var5.fillInStackTrace();
            throw var5;
        } else {
            if (this.savepointStatement == null) {
                this.savepointStatement = this.createStatement();
            }

            String var2 = null;
            if (var1 != null) {
                try {
                    var2 = var1.getSavepointName();
                } catch (SQLException var4) {
                    var2 = "ORACLE_SVPT_" + var1.getSavepointId();
                }
            }

            this.savepointStatement.executeUpdate("ROLLBACK TO " + var2);
        }
    }

    public synchronized void oracleReleaseSavepoint(OracleSavepoint var1) throws SQLException {
        SQLException var2 = DatabaseError.createUnsupportedFeatureSqlException();
        var2.fillInStackTrace();
        throw var2;
    }

    void disallowGlobalTxnMode(int var1) throws SQLException {
        if (this.txnMode == 1) {
            SQLException var2 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), var1);
            var2.fillInStackTrace();
            throw var2;
        }
    }

    public void setTxnMode(int var1) {
        this.txnMode = var1;
    }

    public int getTxnMode() {
        return this.txnMode;
    }

    public synchronized Object getClientData(Object var1) {
        return this.clientData == null ? null : this.clientData.get(var1);
    }

    public synchronized Object setClientData(Object var1, Object var2) {
        if (this.clientData == null) {
            this.clientData = new Hashtable();
        }

        return this.clientData.put(var1, var2);
    }

    public synchronized Object removeClientData(Object var1) {
        return this.clientData == null ? null : this.clientData.remove(var1);
    }

    public BlobDBAccess createBlobDBAccess() throws SQLException {
        SQLException var1 = DatabaseError.createUnsupportedFeatureSqlException();
        var1.fillInStackTrace();
        throw var1;
    }

    public ClobDBAccess createClobDBAccess() throws SQLException {
        SQLException var1 = DatabaseError.createUnsupportedFeatureSqlException();
        var1.fillInStackTrace();
        throw var1;
    }

    public BfileDBAccess createBfileDBAccess() throws SQLException {
        SQLException var1 = DatabaseError.createUnsupportedFeatureSqlException();
        var1.fillInStackTrace();
        throw var1;
    }

    void printState() {
        try {
            short var1 = this.getJdbcCsId();
            short var2 = this.getDbCsId();
            short var3 = this.getStructAttrCsId();
        } catch (SQLException var5) {
            var5.printStackTrace();
        }

    }

    public String getProtocolType() {
        return this.protocol;
    }

    public String getURL() {
        return this.url;
    }

    /** @deprecated */
    public synchronized void setStmtCacheSize(int var1) throws SQLException {
        this.setStatementCacheSize(var1);
        this.setImplicitCachingEnabled(true);
        this.setExplicitCachingEnabled(true);
    }

    /** @deprecated */
    public synchronized void setStmtCacheSize(int var1, boolean var2) throws SQLException {
        this.setStatementCacheSize(var1);
        this.setImplicitCachingEnabled(true);
        this.setExplicitCachingEnabled(true);
        this.clearStatementMetaData = var2;
    }

    /** @deprecated */
    public synchronized int getStmtCacheSize() {
        int var1 = 0;

        try {
            var1 = this.getStatementCacheSize();
        } catch (SQLException var3) {
        }

        if (var1 == -1) {
            var1 = 0;
        }

        return var1;
    }

    public synchronized void setStatementCacheSize(int var1) throws SQLException {
        if (this.statementCache == null) {
            this.statementCache = new LRUStatementCache(var1);
        } else {
            this.statementCache.resize(var1);
        }

    }

    public synchronized int getStatementCacheSize() throws SQLException {
        return this.statementCache == null ? -1 : this.statementCache.getCacheSize();
    }

    public synchronized void setImplicitCachingEnabled(boolean var1) throws SQLException {
        if (this.statementCache == null) {
            this.statementCache = new LRUStatementCache(0);
        }

        this.statementCache.setImplicitCachingEnabled(var1);
    }

    public synchronized boolean getImplicitCachingEnabled() throws SQLException {
        return this.statementCache == null ? false : this.statementCache.getImplicitCachingEnabled();
    }

    public synchronized void setExplicitCachingEnabled(boolean var1) throws SQLException {
        if (this.statementCache == null) {
            this.statementCache = new LRUStatementCache(0);
        }

        this.statementCache.setExplicitCachingEnabled(var1);
    }

    public synchronized boolean getExplicitCachingEnabled() throws SQLException {
        return this.statementCache == null ? false : this.statementCache.getExplicitCachingEnabled();
    }

    public synchronized void purgeImplicitCache() throws SQLException {
        if (this.statementCache != null) {
            this.statementCache.purgeImplicitCache();
        }

    }

    public synchronized void purgeExplicitCache() throws SQLException {
        if (this.statementCache != null) {
            this.statementCache.purgeExplicitCache();
        }

    }

    public synchronized PreparedStatement getStatementWithKey(String var1) throws SQLException {
        if (this.statementCache != null) {
            OracleStatement var2 = this.statementCache.searchExplicitCache(var1);
            if (var2 != null && var2.statementType != 1) {
                SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 125);
                var3.fillInStackTrace();
                throw var3;
            } else {
                return (PreparedStatement)var2;
            }
        } else {
            return null;
        }
    }

    public synchronized CallableStatement getCallWithKey(String var1) throws SQLException {
        if (this.statementCache != null) {
            OracleStatement var2 = this.statementCache.searchExplicitCache(var1);
            if (var2 != null && var2.statementType != 2) {
                SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 125);
                var3.fillInStackTrace();
                throw var3;
            } else {
                return (CallableStatement)var2;
            }
        } else {
            return null;
        }
    }

    synchronized void cacheImplicitStatement(OraclePreparedStatement var1, String var2, int var3, ResultSetType var4) throws SQLException {
        if (this.statementCache == null) {
            SQLException var5 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 95);
            var5.fillInStackTrace();
            throw var5;
        } else {
            this.statementCache.addToImplicitCache(var1, var2, var3, var4.ordinal());
        }
    }

    synchronized void cacheExplicitStatement(OraclePreparedStatement var1, String var2) throws SQLException {
        if (this.statementCache == null) {
            SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 95);
            var3.fillInStackTrace();
            throw var3;
        } else {
            this.statementCache.addToExplicitCache(var1, var2);
        }
    }

    public synchronized boolean isStatementCacheInitialized() {
        if (this.statementCache == null) {
            return false;
        } else {
            return this.statementCache.getCacheSize() != 0;
        }
    }

    BlockSource getBlockSource() {
        return this.blockSource;
    }

    private PhysicalConnection.BufferCacheStore getBufferCacheStore() {
        if (this.useThreadLocalBufferCache) {
            if (threadLocalBufferCacheStore == null) {
                PhysicalConnection.BufferCacheStore.MAX_CACHED_BUFFER_SIZE = this.maxCachedBufferSize;
                threadLocalBufferCacheStore = new ThreadLocal<PhysicalConnection.BufferCacheStore>() {
                    protected PhysicalConnection.BufferCacheStore initialValue() {
                        return new PhysicalConnection.BufferCacheStore();
                    }
                };
            }

            return (PhysicalConnection.BufferCacheStore)threadLocalBufferCacheStore.get();
        } else {
            if (this.connectionBufferCacheStore == null) {
                this.connectionBufferCacheStore = new PhysicalConnection.BufferCacheStore(this.maxCachedBufferSize);
            }

            return this.connectionBufferCacheStore;
        }
    }

    void cacheBuffer(byte[] var1) {
        if (var1 != null) {
            PhysicalConnection.BufferCacheStore var2 = this.getBufferCacheStore();
            var2.byteBufferCache.put(var1);
        }

    }

    void cacheBuffer(char[] var1) {
        if (var1 != null) {
            PhysicalConnection.BufferCacheStore var2 = this.getBufferCacheStore();
            var2.charBufferCache.put(var1);
        }

    }

    public void cacheBufferSync(char[] var1) {
        synchronized(this) {
            this.cacheBuffer(var1);
        }
    }

    byte[] getByteBuffer(int var1) {
        PhysicalConnection.BufferCacheStore var2 = this.getBufferCacheStore();
        return (byte[])var2.byteBufferCache.get(Byte.TYPE, var1);
    }

    char[] getCharBuffer(int var1) {
        PhysicalConnection.BufferCacheStore var2 = this.getBufferCacheStore();
        return (char[])var2.charBufferCache.get(Character.TYPE, var1);
    }

    public char[] getCharBufferSync(int var1) {
        synchronized(this) {
            return this.getCharBuffer(var1);
        }
    }

    public BufferCacheStatistics getByteBufferCacheStatistics() {
        PhysicalConnection.BufferCacheStore var1 = this.getBufferCacheStore();
        return var1.byteBufferCache.getStatistics();
    }

    public BufferCacheStatistics getCharBufferCacheStatistics() {
        PhysicalConnection.BufferCacheStore var1 = this.getBufferCacheStore();
        return var1.charBufferCache.getStatistics();
    }

    public synchronized void registerTAFCallback(OracleOCIFailover var1, Object var2) throws SQLException {
        SQLException var3 = DatabaseError.createUnsupportedFeatureSqlException();
        var3.fillInStackTrace();
        throw var3;
    }

    public String getDatabaseProductVersion() throws SQLException {
        if (this.databaseProductVersion == "") {
            this.needLine();
            this.databaseProductVersion = this.doGetDatabaseProductVersion();
        }

        return this.databaseProductVersion;
    }

    synchronized boolean getReportRemarks() {
        return this.reportRemarks;
    }

    public short getVersionNumber() throws SQLException {
        if (this.versionNumber == -1) {
            synchronized(this) {
                if (this.versionNumber == -1) {
                    this.needLine();
                    this.versionNumber = this.doGetVersionNumber();
                }
            }
        }

        return this.versionNumber;
    }

    synchronized void registerCloseCallback(OracleCloseCallback var1, Object var2) {
        this.closeCallback = var1;
        this.privateData = var2;
    }

    public void setCreateStatementAsRefCursor(boolean var1) {
    }

    public boolean getCreateStatementAsRefCursor() {
        return false;
    }

    public int pingDatabase() throws SQLException {
        return this.lifecycle != 1 ? -1 : this.doPingDatabase();
    }

    /** @deprecated */
    public int pingDatabase(int var1) throws SQLException {
        if (this.lifecycle != 1) {
            return -1;
        } else if (var1 == 0) {
            return this.pingDatabase();
        } else {
            try {
                this.pingResult = -2;
                Thread var2 = new Thread(new Runnable() {
                    public void run() {
                        try {
                            PhysicalConnection.this.pingResult = PhysicalConnection.this.doPingDatabase();
                        } catch (Throwable var2) {
                        }

                    }
                });
                var2.start();
                var2.join((long)(var1 * 1000));
                return this.pingResult;
            } catch (InterruptedException var3) {
                return -3;
            }
        }
    }

    int doPingDatabase() throws SQLException {
        Statement var1 = null;

        byte var3;
        try {
            var1 = this.createStatement();
            ((oracle.jdbc.OracleStatement)var1).defineColumnType(1, 12, 1);
            var1.executeQuery("SELECT 'x' FROM DUAL");
            return 0;
        } catch (SQLException var7) {
            var3 = -1;
        } finally {
            if (var1 != null) {
                var1.close();
            }

        }

        return var3;
    }

    public synchronized Map getJavaObjectTypeMap() {
        return this.javaObjectMap;
    }

    public synchronized void setJavaObjectTypeMap(Map var1) {
        this.javaObjectMap = var1;
    }

    /** @deprecated */
    public void clearClientIdentifier(String var1) throws SQLException {
        if (var1 != null && var1.length() != 0) {
            String[] var2 = this.getEndToEndMetrics();
            if (var2 != null && var1.equals(var2[1])) {
                var2[1] = null;
                this.setEndToEndMetrics(var2, this.getEndToEndECIDSequenceNumber());
            }
        }

    }

    /** @deprecated */
    public void setClientIdentifier(String var1) throws SQLException {
        String[] var2 = this.getEndToEndMetrics();
        if (var2 == null) {
            var2 = new String[4];
        }

        var2[1] = var1;
        this.setEndToEndMetrics(var2, this.getEndToEndECIDSequenceNumber());
    }

    public void setSessionTimeZone(String var1) throws SQLException {
        Statement var2 = null;
        Object var3 = null;

        try {
            var2 = this.createStatement();
            var2.executeUpdate("ALTER SESSION SET TIME_ZONE = '" + var1 + "'");
            if (this.dbTzCalendar == null) {
                this.setDbTzCalendar(this.getDatabaseTimeZone());
            }
        } catch (SQLException var8) {
            throw var8;
        } finally {
            if (var2 != null) {
                var2.close();
            }

        }

        this.sessionTimeZone = var1;
    }

    public String getDatabaseTimeZone() throws SQLException {
        if (this.databaseTimeZone == null) {
            this.databaseTimeZone = this.getPropertyFromDatabase("SELECT DBTIMEZONE FROM DUAL");
        }

        return this.databaseTimeZone;
    }

    public String getSessionTimeZone() {
        return this.sessionTimeZone;
    }

    private static String to2DigitString(int var0) {
        String var1;
        if (var0 < 10) {
            var1 = "0" + var0;
        } else {
            var1 = "" + var0;
        }

        return var1;
    }

    String tzToOffset(String var1) {
        if (var1 == null) {
            return var1;
        } else {
            char var2 = var1.charAt(0);
            if (var2 != '-' && var2 != '+') {
                TimeZone var3 = TimeZone.getTimeZone(var1);
                int var4 = var3.getOffset(System.currentTimeMillis());
                if (var4 != 0) {
                    int var5 = var4 / '\uea60';
                    int var6 = var5 / 60;
                    var5 -= var6 * 60;
                    if (var4 > 0) {
                        var1 = "+" + to2DigitString(var6) + ":" + to2DigitString(var5);
                    } else {
                        var1 = "-" + to2DigitString(-var6) + ":" + to2DigitString(-var5);
                    }
                } else {
                    var1 = "+00:00";
                }
            }

            return var1;
        }
    }

    public String getSessionTimeZoneOffset() throws SQLException {
        String var1 = this.getPropertyFromDatabase("SELECT SESSIONTIMEZONE FROM DUAL");
        if (var1 != null) {
            var1 = this.tzToOffset(var1.trim());
        }

        return var1;
    }

    private void setDbTzCalendar(String var1) {
        char var2 = var1.charAt(0);
        if (var2 == '-' || var2 == '+') {
            var1 = "GMT" + var1;
        }

        TimeZone var3 = TimeZone.getTimeZone(var1);
        this.dbTzCalendar = new GregorianCalendar(var3);
    }

    Calendar getDbTzCalendar() throws SQLException {
        if (this.dbTzCalendar == null) {
            this.setDbTzCalendar(this.getDatabaseTimeZone());
        }

        Calendar var1 = null;
        if (this.dbTzCalendar != null) {
            var1 = (Calendar)((Calendar)this.dbTzCalendar.clone());
        }

        return var1;
    }

    void setAccumulateBatchResult(boolean var1) {
        this.accumulateBatchResult = var1;
    }

    boolean isAccumulateBatchResult() {
        return this.accumulateBatchResult;
    }

    void setJ2EE13Compliant(boolean var1) {
        this.j2ee13Compliant = var1;
    }

    boolean getJ2EE13Compliant() {
        return this.j2ee13Compliant;
    }

    public Class classForNameAndSchema(String var1, String var2) throws ClassNotFoundException {
        return Class.forName(var1);
    }

    Class safelyGetClassForName(String var1) throws ClassNotFoundException {
        return Class.forName(var1);
    }

    public int getHeapAllocSize() throws SQLException {
        SQLException var1;
        if (this.lifecycle != 1) {
            var1 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 8);
            var1.fillInStackTrace();
            throw var1;
        } else {
            var1 = DatabaseError.createUnsupportedFeatureSqlException();
            var1.fillInStackTrace();
            throw var1;
        }
    }

    public int getOCIEnvHeapAllocSize() throws SQLException {
        SQLException var1;
        if (this.lifecycle != 1) {
            var1 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 8);
            var1.fillInStackTrace();
            throw var1;
        } else {
            var1 = DatabaseError.createUnsupportedFeatureSqlException();
            var1.fillInStackTrace();
            throw var1;
        }
    }

    static OracleConnection unwrapCompletely(oracle.jdbc.OracleConnection var0) {
        oracle.jdbc.OracleConnection var1 = var0;

        for(oracle.jdbc.OracleConnection var2 = var0; var2 != null; var2 = var2.unwrap()) {
            var1 = var2;
        }

        return (OracleConnection)var1;
    }

    public void setWrapper(oracle.jdbc.OracleConnection var1) {
        this.wrapper = var1;
    }

    public oracle.jdbc.OracleConnection unwrap() {
        return null;
    }

    public oracle.jdbc.OracleConnection getWrapper() {
        return (oracle.jdbc.OracleConnection)(this.wrapper != null ? this.wrapper : this);
    }

    static oracle.jdbc.internal.OracleConnection _physicalConnectionWithin(Connection var0) {
        OracleConnection var1 = null;
        if (var0 != null) {
            var1 = unwrapCompletely((oracle.jdbc.OracleConnection)var0);
        }

        return var1;
    }

    public oracle.jdbc.internal.OracleConnection physicalConnectionWithin() {
        return this;
    }

    public long getTdoCState(String var1, String var2) throws SQLException {
        return 0L;
    }

    public long getTdoCState(String var1) throws SQLException {
        return 0L;
    }

    void getOracleTypeADT(OracleTypeADT var1) throws SQLException {
    }

    public Datum toDatum(CustomDatum var1) throws SQLException {
        return var1.toDatum(this);
    }

    public short getNCharSet() {
        return this.conversion.getNCharSetId();
    }

    public ResultSet newArrayDataResultSet(Datum[] var1, long var2, int var4, Map var5) throws SQLException {
        return new ArrayDataResultSet(this, var1, var2, var4, var5);
    }

    public ResultSet newArrayDataResultSet(ARRAY var1, long var2, int var4, Map var5) throws SQLException {
        return new ArrayDataResultSet(this, var1, var2, var4, var5);
    }

    public ResultSet newArrayLocatorResultSet(ArrayDescriptor var1, byte[] var2, long var3, int var5, Map var6) throws SQLException {
        return ArrayLocatorResultSet.create(this, var1, var2, var3, var5, var6);
    }

    public ResultSetMetaData newStructMetaData(StructDescriptor var1) throws SQLException {
        return new StructMetaData(var1);
    }

    public int CHARBytesToJavaChars(byte[] var1, int var2, char[] var3) throws SQLException {
        int[] var4 = new int[]{var2};
        return this.conversion.CHARBytesToJavaChars(var1, 0, var3, 0, var4, var3.length);
    }

    public int NCHARBytesToJavaChars(byte[] var1, int var2, char[] var3) throws SQLException {
        int[] var4 = new int[1];
        return this.conversion.NCHARBytesToJavaChars(var1, 0, var3, 0, var4, var3.length);
    }

    public boolean IsNCharFixedWith() {
        return this.conversion.IsNCharFixedWith();
    }

    public short getDriverCharSet() {
        return this.conversion.getClientCharSet();
    }

    public int getMaxCharSize() throws SQLException {
        SQLException var1 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 58);
        var1.fillInStackTrace();
        throw var1;
    }

    public int getMaxCharbyteSize() {
        return this.conversion.getMaxCharbyteSize();
    }

    public int getMaxNCharbyteSize() {
        return this.conversion.getMaxNCharbyteSize();
    }

    public boolean isCharSetMultibyte(short var1) {
        DBConversion var10000 = this.conversion;
        return DBConversion.isCharSetMultibyte(var1);
    }

    public int javaCharsToCHARBytes(char[] var1, int var2, byte[] var3) throws SQLException {
        return this.conversion.javaCharsToCHARBytes(var1, var2, var3);
    }

    public int javaCharsToNCHARBytes(char[] var1, int var2, byte[] var3) throws SQLException {
        return this.conversion.javaCharsToNCHARBytes(var1, var2, var3);
    }

    public abstract void getPropertyForPooledConnection(OraclePooledConnection var1) throws SQLException;

    final void getPropertyForPooledConnection(OraclePooledConnection var1, String var2) throws SQLException {
        Hashtable var3 = new Hashtable();
        var3.put("obj_type_map", this.javaObjectMap);
        Properties var4 = new Properties();
        var4.put("user", this.userName);
        var4.put("password", var2);
        var4.put("connection_url", this.url);
        var4.put("connect_auto_commit", "" + this.autocommit);
        var4.put("trans_isolation", "" + this.txnLevel);
        if (this.getStatementCacheSize() != -1) {
            var4.put("stmt_cache_size", "" + this.getStatementCacheSize());
            var4.put("implicit_cache_enabled", "" + this.getImplicitCachingEnabled());
            var4.put("explict_cache_enabled", "" + this.getExplicitCachingEnabled());
        }

        var4.put("defaultExecuteBatch", "" + this.defaultExecuteBatch);
        var4.put("defaultRowPrefetch", "" + this.defaultRowPrefetch);
        var4.put("remarksReporting", "" + this.reportRemarks);
        var4.put("AccumulateBatchResult", "" + this.accumulateBatchResult);
        var4.put("oracle.jdbc.J2EE13Compliant", "" + this.j2ee13Compliant);
        var4.put("processEscapes", "" + this.processEscapes);
        var4.put("restrictGetTables", "" + this.restrictGettables);
        var4.put("includeSynonyms", "" + this.includeSynonyms);
        var4.put("fixedString", "" + this.fixedString);
        var3.put("connection_properties", var4);
        var1.setProperties(var3);
    }

    public Properties getDBAccessProperties() throws SQLException {
        SQLException var1 = DatabaseError.createUnsupportedFeatureSqlException();
        var1.fillInStackTrace();
        throw var1;
    }

    public Properties getOCIHandles() throws SQLException {
        SQLException var1 = DatabaseError.createUnsupportedFeatureSqlException();
        var1.fillInStackTrace();
        throw var1;
    }

    abstract void logon() throws SQLException;

    void logoff() throws SQLException {
    }

    abstract void open(OracleStatement var1) throws SQLException;

    abstract void cancelOperationOnServer(boolean var1) throws SQLException;

    abstract void doSetAutoCommit(boolean var1) throws SQLException;

    abstract void doCommit(int var1) throws SQLException;

    abstract void doRollback() throws SQLException;

    abstract String doGetDatabaseProductVersion() throws SQLException;

    abstract short doGetVersionNumber() throws SQLException;

    int getDefaultStreamChunkSize() {
        return 32768;
    }

    abstract OracleStatement RefCursorBytesToStatement(byte[] var1, OracleStatement var2) throws SQLException;

    abstract OracleStatement createImplicitResultSetStatement(OracleStatement var1) throws SQLException;

    public oracle.jdbc.internal.OracleStatement refCursorCursorToStatement(int var1) throws SQLException {
        SQLException var2 = DatabaseError.createUnsupportedFeatureSqlException();
        var2.fillInStackTrace();
        throw var2;
    }

    public Connection getLogicalConnection(OraclePooledConnection var1, boolean var2) throws SQLException {
        if (this.logicalConnectionAttached != null) {
            SQLException var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 143);
            var4.fillInStackTrace();
            throw var4;
        } else {
            LogicalConnection var3 = new LogicalConnection(var1, this, var2);
            this.logicalConnectionAttached = var3;
            return var3;
        }
    }

    public void getForm(OracleTypeADT var1, OracleTypeCLOB var2, int var3) throws SQLException {
    }

    public CLOB createClob(byte[] var1) throws SQLException {
        Object var2 = new CLOB(this, var1);
        if (((CLOB)var2).isNCLOB()) {
            var2 = new NCLOB((CLOB)var2);
        }

        return (CLOB)var2;
    }

    public CLOB createClobWithUnpickledBytes(byte[] var1) throws SQLException {
        Object var2 = new CLOB(this, var1, true);
        if (((CLOB)var2).isNCLOB()) {
            var2 = new NCLOB((CLOB)var2);
        }

        return (CLOB)var2;
    }

    public CLOB createClob(byte[] var1, short var2) throws SQLException {
        return (CLOB)(var2 == 2 ? new NCLOB(this, var1) : new CLOB(this, var1, var2));
    }

    public BLOB createBlob(byte[] var1) throws SQLException {
        return new BLOB(this, var1);
    }

    public BLOB createBlobWithUnpickledBytes(byte[] var1) throws SQLException {
        return new BLOB(this, var1, true);
    }

    public BFILE createBfile(byte[] var1) throws SQLException {
        return new BFILE(this, var1);
    }

    public ARRAY createARRAY(String var1, Object var2) throws SQLException {
        ArrayDescriptor var3 = ArrayDescriptor.createDescriptor(var1, this);
        return new ARRAY(var3, this, var2);
    }

    public Array createOracleArray(String var1, Object var2) throws SQLException {
        return this.createARRAY(var1, var2);
    }

    public BINARY_DOUBLE createBINARY_DOUBLE(double var1) throws SQLException {
        return new BINARY_DOUBLE(var1);
    }

    public BINARY_FLOAT createBINARY_FLOAT(float var1) throws SQLException {
        return new BINARY_FLOAT(var1);
    }

    public DATE createDATE(Date var1) throws SQLException {
        return new DATE(var1);
    }

    public DATE createDATE(Time var1) throws SQLException {
        return new DATE(var1);
    }

    public DATE createDATE(Timestamp var1) throws SQLException {
        return new DATE(var1);
    }

    public DATE createDATE(Date var1, Calendar var2) throws SQLException {
        return new DATE(var1);
    }

    public DATE createDATE(Time var1, Calendar var2) throws SQLException {
        return new DATE(var1);
    }

    public DATE createDATE(Timestamp var1, Calendar var2) throws SQLException {
        return new DATE(var1);
    }

    public DATE createDATE(String var1) throws SQLException {
        return new DATE(var1);
    }

    public INTERVALDS createINTERVALDS(String var1) throws SQLException {
        return new INTERVALDS(var1);
    }

    public INTERVALYM createINTERVALYM(String var1) throws SQLException {
        return new INTERVALYM(var1);
    }

    public NUMBER createNUMBER(boolean var1) throws SQLException {
        return new NUMBER(var1);
    }

    public NUMBER createNUMBER(byte var1) throws SQLException {
        return new NUMBER(var1);
    }

    public NUMBER createNUMBER(short var1) throws SQLException {
        return new NUMBER(var1);
    }

    public NUMBER createNUMBER(int var1) throws SQLException {
        return new NUMBER(var1);
    }

    public NUMBER createNUMBER(long var1) throws SQLException {
        return new NUMBER(var1);
    }

    public NUMBER createNUMBER(float var1) throws SQLException {
        return new NUMBER(var1);
    }

    public NUMBER createNUMBER(double var1) throws SQLException {
        return new NUMBER(var1);
    }

    public NUMBER createNUMBER(BigDecimal var1) throws SQLException {
        return new NUMBER(var1);
    }

    public NUMBER createNUMBER(BigInteger var1) throws SQLException {
        return new NUMBER(var1);
    }

    public NUMBER createNUMBER(String var1, int var2) throws SQLException {
        return new NUMBER(var1, var2);
    }

    public Array createArrayOf(String var1, Object[] var2) throws SQLException {
        SQLException var3 = DatabaseError.createUnsupportedFeatureSqlException();
        var3.fillInStackTrace();
        throw var3;
    }

    public Struct createStruct(String var1, Object[] var2) throws SQLException {
        try {
            StructDescriptor var3 = StructDescriptor.createDescriptor(var1, this);
            return new STRUCT(var3, this, var2);
        } catch (SQLException var4) {
            if (var4.getErrorCode() == 17049) {
                this.removeAllDescriptor();
            }

            throw var4;
        }
    }

    public TIMESTAMP createTIMESTAMP(Date var1) throws SQLException {
        return new TIMESTAMP(var1);
    }

    public TIMESTAMP createTIMESTAMP(DATE var1) throws SQLException {
        return new TIMESTAMP(var1);
    }

    public TIMESTAMP createTIMESTAMP(Time var1) throws SQLException {
        return new TIMESTAMP(var1);
    }

    public TIMESTAMP createTIMESTAMP(Timestamp var1) throws SQLException {
        return new TIMESTAMP(var1);
    }

    public TIMESTAMP createTIMESTAMP(String var1) throws SQLException {
        return new TIMESTAMP(var1);
    }

    public TIMESTAMPTZ createTIMESTAMPTZ(Date var1) throws SQLException {
        return new TIMESTAMPTZ(this, var1);
    }

    public TIMESTAMPTZ createTIMESTAMPTZ(Date var1, Calendar var2) throws SQLException {
        return new TIMESTAMPTZ(this, var1, var2);
    }

    public TIMESTAMPTZ createTIMESTAMPTZ(Time var1) throws SQLException {
        return new TIMESTAMPTZ(this, var1);
    }

    public TIMESTAMPTZ createTIMESTAMPTZ(Time var1, Calendar var2) throws SQLException {
        return new TIMESTAMPTZ(this, var1, var2);
    }

    public TIMESTAMPTZ createTIMESTAMPTZ(Timestamp var1) throws SQLException {
        return new TIMESTAMPTZ(this, var1);
    }

    public TIMESTAMPTZ createTIMESTAMPTZ(Timestamp var1, Calendar var2) throws SQLException {
        return new TIMESTAMPTZ(this, var1, var2);
    }

    public TIMESTAMPTZ createTIMESTAMPTZ(String var1) throws SQLException {
        return new TIMESTAMPTZ(this, var1);
    }

    public TIMESTAMPTZ createTIMESTAMPTZ(String var1, Calendar var2) throws SQLException {
        return new TIMESTAMPTZ(this, var1, var2);
    }

    public TIMESTAMPTZ createTIMESTAMPTZ(DATE var1) throws SQLException {
        return new TIMESTAMPTZ(this, var1);
    }

    public TIMESTAMPLTZ createTIMESTAMPLTZ(Date var1, Calendar var2) throws SQLException {
        return new TIMESTAMPLTZ(this, var2, var1);
    }

    public TIMESTAMPLTZ createTIMESTAMPLTZ(Time var1, Calendar var2) throws SQLException {
        return new TIMESTAMPLTZ(this, var2, var1);
    }

    public TIMESTAMPLTZ createTIMESTAMPLTZ(Timestamp var1, Calendar var2) throws SQLException {
        return new TIMESTAMPLTZ(this, var2, var1);
    }

    public TIMESTAMPLTZ createTIMESTAMPLTZ(String var1, Calendar var2) throws SQLException {
        return new TIMESTAMPLTZ(this, var2, var1);
    }

    public TIMESTAMPLTZ createTIMESTAMPLTZ(DATE var1, Calendar var2) throws SQLException {
        return new TIMESTAMPLTZ(this, var2, var1);
    }

    public abstract BLOB createTemporaryBlob(Connection var1, boolean var2, int var3) throws SQLException;

    public abstract CLOB createTemporaryClob(Connection var1, boolean var2, int var3, short var4) throws SQLException;

    public Blob createBlob() throws SQLException {
        if (this.lifecycle != 1) {
            SQLException var1 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 8);
            var1.fillInStackTrace();
            throw var1;
        } else {
            return this.createTemporaryBlob(this, true, 10);
        }
    }

    public Clob createClob() throws SQLException {
        if (this.lifecycle != 1) {
            SQLException var1 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 8);
            var1.fillInStackTrace();
            throw var1;
        } else {
            return this.createTemporaryClob(this, true, 10, (short)1);
        }
    }

    public NClob createNClob() throws SQLException {
        if (this.lifecycle != 1) {
            SQLException var1 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 8);
            var1.fillInStackTrace();
            throw var1;
        } else {
            return (NClob)this.createTemporaryClob(this, true, 10, (short)2);
        }
    }

    public SQLXML createSQLXML() throws SQLException {
        if (this.lifecycle != 1) {
            SQLException var1 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 8);
            var1.fillInStackTrace();
            throw var1;
        } else {
            return new XMLType(this, (String)null);
        }
    }

    public boolean isDescriptorSharable(oracle.jdbc.internal.OracleConnection var1) throws SQLException {
        PhysicalConnection var3 = (PhysicalConnection)var1.getPhysicalConnection();
        return this == var3 || this.url.equals(var3.url) || var3.protocol != null && var3.protocol.equals("kprb");
    }

    boolean useLittleEndianSetCHARBinder() throws SQLException {
        return false;
    }

    public void setPlsqlWarnings(String var1) throws SQLException {
        SQLException var8;
        if (var1 == null) {
            var8 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 68);
            var8.fillInStackTrace();
            throw var8;
        } else if (var1 != null && (var1 = var1.trim()).length() > 0 && !OracleSql.isValidPlsqlWarning(var1)) {
            var8 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 68);
            var8.fillInStackTrace();
            throw var8;
        } else {
            String var2 = "ALTER SESSION SET PLSQL_WARNINGS=" + var1;
            String var3 = "ALTER SESSION SET EVENTS='10933 TRACE NAME CONTEXT LEVEL 32768'";
            Statement var4 = null;

            try {
                var4 = this.createStatement(-1, -1);
                var4.execute(var2);
                if (var1.equals("'DISABLE:ALL'")) {
                    this.plsqlCompilerWarnings = false;
                } else {
                    var4.execute(var3);
                    this.plsqlCompilerWarnings = true;
                }
            } finally {
                if (var4 != null) {
                    var4.close();
                }

            }

        }
    }

    void internalClose() throws SQLException {
        this.lifecycle = 4;

        OracleStatement var1;
        OracleStatement var2;
        for(var1 = this.statements; var1 != null; var1 = var2) {
            var2 = var1.nextChild;
            if (var1.serverCursor) {
                var1.internalClose();
                this.removeStatement(var1);
            }
        }

        for(var1 = this.statements; var1 != null; var1 = var2) {
            var2 = var1.next;
            var1.internalClose();
        }

        this.statements = null;
    }

    public XAResource getXAResource() throws SQLException {
        SQLException var1 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 164);
        var1.fillInStackTrace();
        throw var1;
    }

    protected void doDescribeTable(AutoKeyInfo var1) throws SQLException {
        SQLException var2 = DatabaseError.createUnsupportedFeatureSqlException();
        var2.fillInStackTrace();
        throw var2;
    }

    public void setClientInfo(String var1, String var2) throws SQLClientInfoException {
        SecurityManager var3 = System.getSecurityManager();
        if (var3 != null) {
            OracleSQLPermission var4 = new OracleSQLPermission("clientInfo." + var1);
            var3.checkPermission(var4);
        }

        this.setClientInfoInternal(var1, var2);
    }

    public void setClientInfo(Properties var1) throws SQLClientInfoException {
        SecurityManager var2 = System.getSecurityManager();
        if (var2 != null) {
            OracleSQLPermission var3 = new OracleSQLPermission("clientInfo.*");
            var2.checkPermission(var3);
        }

        this.clientInfo.clear();
        HashMap var9 = new HashMap();
        Iterator var4 = var1.stringPropertyNames().iterator();

        while(var4.hasNext()) {
            String var5 = (String)var4.next();
            String var6 = var1.getProperty(var5);

            try {
                this.setClientInfoInternal(var5, var6);
            } catch (SQLClientInfoException var8) {
                var9.put(var5, ClientInfoStatus.REASON_UNKNOWN_PROPERTY);
            }
        }

        if (!var9.isEmpty()) {
            SQLClientInfoException var10 = DatabaseError.createSQLClientInfoException(253, var9, (Throwable)null);
            var10.fillInStackTrace();
            throw var10;
        }
    }

    void setClientInfoInternal(String var1, String var2) throws SQLClientInfoException {
        if (!SUPPORTED_NAME_PATTERN.matcher(var1).matches()) {
            SQLClientInfoException var11 = DatabaseError.createSQLClientInfoException(253, (Map)null, (Throwable)null);
            var11.fillInStackTrace();
            throw var11;
        } else {
            String[] var3 = var1.split("\\.", 2);
            if (RESERVED_NAMESPACES.contains(var3[0])) {
                SQLClientInfoException var12 = DatabaseError.createSQLClientInfoException(276, (Map)null, (Throwable)null);
                var12.fillInStackTrace();
                throw var12;
            } else {
                String var4 = var3[0];
                String var5 = var3[1];

                try {
                    SQLException var6;
                    if (var4.equals("OCSID")) {
                        if (var5.equals("ACTION")) {
                            if (var2 != null && var2.length() > this.endToEndMaxLength[0]) {
                                var6 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 159, var2);
                                var6.fillInStackTrace();
                                throw var6;
                            }

                            if (var2 == null && this.endToEndValues[0] != null || var2 != null && !var2.equals(this.endToEndValues[0])) {
                                this.endToEndValues[0] = var2;
                                this.endToEndHasChanged[0] = true;
                                this.endToEndAnyChanged = true;
                            }
                        } else if (var5.equals("CLIENTID")) {
                            if (var2 != null && var2.length() > this.endToEndMaxLength[1]) {
                                var6 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 159, var2);
                                var6.fillInStackTrace();
                                throw var6;
                            }

                            if (var2 == null && this.endToEndValues[1] != null || var2 != null && !var2.equals(this.endToEndValues[1])) {
                                this.endToEndValues[1] = var2;
                                this.endToEndHasChanged[1] = true;
                                this.endToEndAnyChanged = true;
                            }
                        } else if (var5.equals("ECID")) {
                            if (var2 != null && var2.length() > this.endToEndMaxLength[2]) {
                                var6 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 159, var2);
                                var6.fillInStackTrace();
                                throw var6;
                            }

                            if (var2 == null && this.endToEndValues[2] != null || var2 != null && !var2.equals(this.endToEndValues[2])) {
                                this.endToEndValues[2] = var2;
                                this.endToEndHasChanged[2] = true;
                                this.endToEndAnyChanged = true;
                            }
                        } else if (var5.equals("MODULE")) {
                            if (var2 != null && var2.length() > this.endToEndMaxLength[3]) {
                                var6 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 159, var2);
                                var6.fillInStackTrace();
                                throw var6;
                            }

                            if (var2 == null && this.endToEndValues[3] != null || var2 != null && !var2.equals(this.endToEndValues[3])) {
                                this.endToEndValues[3] = var2;
                                this.endToEndHasChanged[3] = true;
                                this.endToEndHasChanged[0] = true;
                                this.endToEndAnyChanged = true;
                            }
                        } else if (var5.equals("SEQUENCE_NUMBER")) {
                            short var13 = 0;
                            if (var2 != null) {
                                try {
                                    var13 = Short.valueOf(var2);
                                } catch (NumberFormatException var9) {
                                    SQLException var8 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 160, var2);
                                    var8.fillInStackTrace();
                                    throw var8;
                                }
                            }

                            this.endToEndECIDSequenceNumber = var13;
                            this.endToEndAnyChanged = true;
                        } else {
                            if (!var5.equals("DBOP")) {
                                var6 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 253, "OCSID." + var5);
                                var6.fillInStackTrace();
                                throw var6;
                            }

                            if (var2 != null && var2.length() > this.endToEndMaxLength[4]) {
                                var6 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 159, var2);
                                var6.fillInStackTrace();
                                throw var6;
                            }

                            if (var2 == null && this.endToEndValues[4] != null || var2 != null && !var2.equals(this.endToEndValues[4])) {
                                this.endToEndValues[4] = var2;
                                this.endToEndHasChanged[4] = true;
                                this.endToEndAnyChanged = true;
                            }
                        }
                    } else {
                        if (var5.length() > 30) {
                            var6 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 171);
                            var6.fillInStackTrace();
                            throw var6;
                        }

                        if (var2 != null && var2.length() > 4000) {
                            var6 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 172);
                            var6.fillInStackTrace();
                            throw var6;
                        }

                        this.doSetApplicationContext(var4, var5, var2 == null ? "" : var2);
                    }

                    if (var2 == null) {
                        this.clientInfo.remove(var1);
                    } else {
                        this.clientInfo.put(var1, var2);
                    }

                } catch (SQLException var10) {
                    SQLClientInfoException var7 = DatabaseError.createSQLClientInfoException(1, (Map)null, var10);
                    var7.fillInStackTrace();
                    throw var7;
                }
            }
        }
    }

    public String getClientInfo(String var1) throws SQLException {
        if (this.isClosed()) {
            SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 8);
            var3.fillInStackTrace();
            throw var3;
        } else if (var1 == null) {
            return null;
        } else if (!SUPPORTED_NAME_PATTERN.matcher(var1).matches()) {
            SQLClientInfoException var2 = DatabaseError.createSQLClientInfoException(253, (Map)null, (Throwable)null);
            var2.fillInStackTrace();
            throw var2;
        } else {
            return this.clientInfo.getProperty(var1);
        }
    }

    public Properties getClientInfo() throws SQLException {
        if (this.isClosed()) {
            SQLException var1 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 8);
            var1.fillInStackTrace();
            throw var1;
        } else {
            return (Properties)this.clientInfo.clone();
        }
    }

    public void setApplicationContext(String var1, String var2, String var3) throws SQLException {
        if (var2 == null) {
            throw new NullPointerException();
        } else if (var1 != null && !var1.equals("")) {
            this.setClientInfoInternal(var1 + "." + var2, var3);
        } else {
            SQLException var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 170);
            var4.fillInStackTrace();
            throw var4;
        }
    }

    void doSetApplicationContext(String var1, String var2, String var3) throws SQLException {
        SQLException var4 = DatabaseError.createUnsupportedFeatureSqlException();
        var4.fillInStackTrace();
        throw var4;
    }

    public void clearAllApplicationContext(String var1) throws SQLException {
        if (var1 == null) {
            throw new NullPointerException();
        } else if (var1.equals("")) {
            SQLException var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 170);
            var4.fillInStackTrace();
            throw var4;
        } else {
            this.doClearAllApplicationContext(var1);
            if (!var1.equals("OCSID")) {
                Iterator var2 = this.clientInfo.stringPropertyNames().iterator();

                while(var2.hasNext()) {
                    String var3 = (String)var2.next();
                    if (var3.startsWith(var1 + ".")) {
                        this.clientInfo.remove(var3);
                    }
                }
            }

        }
    }

    void doClearAllApplicationContext(String var1) throws SQLException {
        SQLException var2 = DatabaseError.createUnsupportedFeatureSqlException();
        var2.fillInStackTrace();
        throw var2;
    }

    public byte[] createLightweightSession(String var1, KeywordValueLong[] var2, int var3, KeywordValueLong[][] var4, int[] var5) throws SQLException {
        SQLException var6 = DatabaseError.createUnsupportedFeatureSqlException();
        var6.fillInStackTrace();
        throw var6;
    }

    void executeLightweightSessionRoundtrip(int var1, byte[] var2, KeywordValueLong[] var3, int var4, KeywordValueLong[][] var5, int[] var6) throws SQLException {
        SQLException var7 = DatabaseError.createUnsupportedFeatureSqlException();
        var7.fillInStackTrace();
        throw var7;
    }

    public void executeLightweightSessionPiggyback(int var1, byte[] var2, KeywordValueLong[] var3, int var4) throws SQLException {
        SQLException var5 = DatabaseError.createUnsupportedFeatureSqlException();
        var5.fillInStackTrace();
        throw var5;
    }

    public void doXSNamespaceOp(XSOperationCode var1, byte[] var2, XSNamespace[] var3, XSNamespace[][] var4, XSSecureId var5) throws SQLException {
        SQLException var6 = DatabaseError.createUnsupportedFeatureSqlException();
        var6.fillInStackTrace();
        throw var6;
    }

    public void doXSNamespaceOp(XSOperationCode var1, byte[] var2, XSNamespace[] var3, XSSecureId var4) throws SQLException {
        SQLException var5 = DatabaseError.createUnsupportedFeatureSqlException();
        var5.fillInStackTrace();
        throw var5;
    }

    public byte[] doXSSessionCreateOp(XSSessionOperationCode var1, XSSecureId var2, byte[] var3, XSPrincipal var4, String var5, XSNamespace[] var6, XSSessionModeFlag var7, XSKeyval var8) throws SQLException {
        SQLException var9 = DatabaseError.createUnsupportedFeatureSqlException();
        var9.fillInStackTrace();
        throw var9;
    }

    public void doXSSessionDestroyOp(byte[] var1, XSSecureId var2, byte[] var3) throws SQLException {
        SQLException var4 = DatabaseError.createUnsupportedFeatureSqlException();
        var4.fillInStackTrace();
        throw var4;
    }

    public void doXSSessionDetachOp(int var1, byte[] var2, XSSecureId var3, boolean var4) throws SQLException {
        SQLException var5 = DatabaseError.createUnsupportedFeatureSqlException();
        var5.fillInStackTrace();
        throw var5;
    }

    public void doXSSessionChangeOp(XSSessionSetOperationCode var1, byte[] var2, XSSecureId var3, XSSessionParameters var4) throws SQLException {
        SQLException var5 = DatabaseError.createUnsupportedFeatureSqlException();
        var5.fillInStackTrace();
        throw var5;
    }

    public void doXSSessionAttachOp(int var1, byte[] var2, XSSecureId var3, byte[] var4, XSPrincipal var5, String[] var6, String[] var7, String[] var8, XSNamespace[] var9, XSNamespace[] var10, XSNamespace[] var11, TIMESTAMPTZ var12, TIMESTAMPTZ var13, int var14, long var15, XSKeyval var17, int[] var18) throws SQLException {
        SQLException var19 = DatabaseError.createUnsupportedFeatureSqlException();
        var19.fillInStackTrace();
        throw var19;
    }

    public void enqueue(String var1, AQEnqueueOptions var2, AQMessage var3) throws SQLException {
        AQMessageI var4 = (AQMessageI)var3;
        byte[][] var5 = new byte[1][];
        this.doEnqueue(var1, var2, var4.getMessagePropertiesI(), var4.getPayloadTOID(), var4.getPayload(), var5, var4.isRAWPayload());
        if (var5[0] != null) {
            var4.setMessageId(var5[0]);
        }

    }

    public AQMessage dequeue(String var1, AQDequeueOptions var2, byte[] var3) throws SQLException {
        byte[][] var4 = new byte[1][];
        AQMessagePropertiesI var5 = new AQMessagePropertiesI();
        byte[][] var6 = new byte[1][];
        boolean var7 = false;
        var7 = this.doDequeue(var1, var2, var5, var3, var6, var4, AQMessageI.compareToid(var3, TypeDescriptor.RAWTOID));
        AQMessageI var8 = null;
        if (var7) {
            var8 = new AQMessageI(var5, this);
            var8.setPayload(var6[0], var3);
            var8.setMessageId(var4[0]);
        }

        return var8;
    }

    public AQMessage dequeue(String var1, AQDequeueOptions var2, String var3) throws SQLException {
        Object var4 = null;
        TypeDescriptor var5 = null;
        byte[] var7;
        if (!"RAW".equals(var3) && !"SYS.RAW".equals(var3)) {
            if ("SYS.ANYDATA".equals(var3)) {
                var7 = TypeDescriptor.ANYDATATOID;
            } else if ("SYS.XMLTYPE".equals(var3)) {
                var7 = TypeDescriptor.XMLTYPETOID;
            } else {
                var5 = TypeDescriptor.getTypeDescriptor(var3, this);
                var7 = ((OracleTypeADT)var5.getPickler()).getTOID();
            }
        } else {
            var7 = TypeDescriptor.RAWTOID;
        }

        AQMessageI var6 = (AQMessageI)this.dequeue(var1, var2, var7);
        if (var6 != null) {
            var6.setTypeName(var3);
            var6.setTypeDescriptor(var5);
        }

        return var6;
    }

    synchronized void doEnqueue(String var1, AQEnqueueOptions var2, AQMessagePropertiesI var3, byte[] var4, byte[] var5, byte[][] var6, boolean var7) throws SQLException {
        SQLException var8 = DatabaseError.createUnsupportedFeatureSqlException();
        var8.fillInStackTrace();
        throw var8;
    }

    synchronized boolean doDequeue(String var1, AQDequeueOptions var2, AQMessagePropertiesI var3, byte[] var4, byte[][] var5, byte[][] var6, boolean var7) throws SQLException {
        SQLException var8 = DatabaseError.createUnsupportedFeatureSqlException();
        var8.fillInStackTrace();
        throw var8;
    }

    public void jmsEnqueue(String var1, JMSEnqueueOptions var2, JMSMessage var3, AQMessageProperties var4) throws SQLException {
        byte[][] var5 = new byte[1][];
        AQMessagePropertiesI var6 = (AQMessagePropertiesI)var4;
        this.doJMSEnqueue(var1, var2, var6, var3.getJMSMessageProperties(), var3.getToid(), var3.getPayload(), var5);
        if (var5[0] != null) {
            var3.setMessageId(var5[0]);
        }

    }

    synchronized void doJMSEnqueue(String var1, JMSEnqueueOptions var2, AQMessagePropertiesI var3, JMSMessageProperties var4, byte[] var5, byte[] var6, byte[][] var7) throws SQLException {
    }

    public JMSMessage jmsDequeue(String var1, JMSDequeueOptions var2, String var3) throws SQLException {
        JMSMessage var4 = this.jmsDequeue(var1, var2);
        return var4;
    }

    public JMSMessage jmsDequeue(String var1, JMSDequeueOptions var2) throws SQLException {
        byte[] var3 = TypeDescriptor.RAWTOID;
        byte[][] var4 = new byte[1][];
        AQMessagePropertiesI var5 = new AQMessagePropertiesI();
        JMSMessagePropertiesI var6 = new JMSMessagePropertiesI();
        byte[][] var7 = new byte[1][];
        boolean var8 = false;
        var8 = this.doJmsDequeue(var1, var2, var5, var6, var3, var7, var4);
        JMSMessage var9 = null;
        if (var8) {
            var9 = JMSFactory.createJMSMessage(var6);
            var9.setPayload(var7[0]);
            var9.setMessageId(var4[0]);
            var9.setJMSMessageProperties(var6);
            var9.setAQMessageProperties(var5);
        }

        return var9;
    }

    synchronized boolean doJmsDequeue(String var1, JMSDequeueOptions var2, AQMessagePropertiesI var3, JMSMessagePropertiesI var4, byte[] var5, byte[][] var6, byte[][] var7) throws SQLException {
        return true;
    }

    /** @deprecated */
    public boolean isV8Compatible() throws SQLException {
        return this.mapDateToTimestamp;
    }

    public boolean getMapDateToTimestamp() {
        return this.mapDateToTimestamp;
    }

    public byte getInstanceProperty(InstanceProperty var1) throws SQLException {
        SQLException var2 = DatabaseError.createUnsupportedFeatureSqlException();
        var2.fillInStackTrace();
        throw var2;
    }

    public Map<String, JMSNotificationRegistration> registerJMSNotification(String[] var1, Map<String, Properties> var2) throws SQLException {
        if (var1 != null && var2 != null) {
            Map var4 = this.doRegisterJMSNotification(var1, var2);
            return var4;
        } else {
            SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 68, "name and options cannot be null");
            var3.fillInStackTrace();
            throw var3;
        }
    }

    Map<String, JMSNotificationRegistration> doRegisterJMSNotification(String[] var1, Map<String, Properties> var2) throws SQLException {
        SQLException var3 = DatabaseError.createUnsupportedFeatureSqlException();
        var3.fillInStackTrace();
        throw var3;
    }

    public void unregisterJMSNotification(JMSNotificationRegistration var1) throws SQLException {
        if (var1 == null) {
            SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 68, "registration cannot be null");
            var3.fillInStackTrace();
            throw var3;
        } else {
            NTFJMSRegistration var2 = (NTFJMSRegistration)var1;
            this.doUnregisterJMSNotification(var2);
        }
    }

    void doUnregisterJMSNotification(NTFJMSRegistration var1) throws SQLException {
        SQLException var2 = DatabaseError.createUnsupportedFeatureSqlException();
        var2.fillInStackTrace();
        throw var2;
    }

    public void ackJMSNotification(JMSNotificationRegistration var1, byte[] var2, Directive var3) throws SQLException {
        if (var3 != null && var1 != null && var2 != null) {
            short var5 = var3.getCode();
            this.doAckJMSNtfn((NTFJMSRegistration)var1, var2, var5);
        } else {
            SQLException var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 68, "directive,registration or lastMessageID cannot be null");
            var4.fillInStackTrace();
            throw var4;
        }
    }

    void doAckJMSNtfn(NTFJMSRegistration var1, byte[] var2, short var3) throws SQLException {
        SQLException var4 = DatabaseError.createUnsupportedFeatureSqlException();
        var4.fillInStackTrace();
        throw var4;
    }

    public AQNotificationRegistration[] registerAQNotification(String[] var1, Properties[] var2, Properties var3) throws SQLException {
        String var4 = this.readNTFlocalhost(var3);
        int var5 = this.readNTFtcpport(var3);
        NTFAQRegistration[] var6 = this.doRegisterAQNotification(var1, var4, var5, var2);
        return (AQNotificationRegistration[])var6;
    }

    NTFAQRegistration[] doRegisterAQNotification(String[] var1, String var2, int var3, Properties[] var4) throws SQLException {
        SQLException var5 = DatabaseError.createUnsupportedFeatureSqlException();
        var5.fillInStackTrace();
        throw var5;
    }

    public void unregisterAQNotification(AQNotificationRegistration var1) throws SQLException {
        NTFAQRegistration var2 = (NTFAQRegistration)var1;
        this.doUnregisterAQNotification(var2);
    }

    void doUnregisterAQNotification(NTFAQRegistration var1) throws SQLException {
        SQLException var2 = DatabaseError.createUnsupportedFeatureSqlException();
        var2.fillInStackTrace();
        throw var2;
    }

    private String readNTFlocalhost(Properties var1) throws SQLException {
        String var2 = null;

        SQLException var4;
        try {
            var2 = var1.getProperty("NTF_LOCAL_HOST", InetAddress.getLocalHost().getHostAddress());
            return var2;
        } catch (UnknownHostException var5) {
            var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 240);
            var4.fillInStackTrace();
            throw var4;
        } catch (SecurityException var6) {
            var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 241);
            var4.fillInStackTrace();
            throw var4;
        }
    }

    private int readNTFtcpport(Properties var1) throws SQLException {
        boolean var2 = false;

        try {
            int var6 = Integer.parseInt(var1.getProperty("NTF_LOCAL_TCP_PORT", "0"));
            if (var6 < 0) {
                SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 242);
                var3.fillInStackTrace();
                throw var3;
            } else {
                return var6;
            }
        } catch (NumberFormatException var5) {
            SQLException var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 242);
            var4.fillInStackTrace();
            throw var4;
        }
    }

    int readNTFtimeout(Properties var1) throws SQLException {
        boolean var2 = false;

        try {
            int var6 = Integer.parseInt(var1.getProperty("NTF_TIMEOUT", "0"));
            return var6;
        } catch (NumberFormatException var5) {
            SQLException var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 243);
            var4.fillInStackTrace();
            throw var4;
        }
    }

    public DatabaseChangeRegistration registerDatabaseChangeNotification(Properties var1) throws SQLException {
        String var2 = this.readNTFlocalhost(var1);
        int var3 = this.readNTFtcpport(var1);
        int var4 = this.readNTFtimeout(var1);
        boolean var5 = false;

        int var9;
        try {
            var9 = Integer.parseInt(var1.getProperty("DCN_NOTIFY_CHANGELAG", "0"));
        } catch (NumberFormatException var8) {
            SQLException var7 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 244);
            var7.fillInStackTrace();
            throw var7;
        }

        NTFDCNRegistration var6 = this.doRegisterDatabaseChangeNotification(var2, var3, var1, var4, var9);
        ntfManager.addRegistration(var6);
        return var6;
    }

    NTFDCNRegistration doRegisterDatabaseChangeNotification(String var1, int var2, Properties var3, int var4, int var5) throws SQLException {
        SQLException var6 = DatabaseError.createUnsupportedFeatureSqlException();
        var6.fillInStackTrace();
        throw var6;
    }

    public DatabaseChangeRegistration getDatabaseChangeRegistration(int var1) throws SQLException {
        NTFDCNRegistration var2 = new NTFDCNRegistration(this.dbName, (long)var1, this.userName, this.versionNumber);
        return var2;
    }

    public void unregisterDatabaseChangeNotification(DatabaseChangeRegistration var1) throws SQLException {
        NTFDCNRegistration var2 = (NTFDCNRegistration)var1;
        if (var2.getDatabaseName().compareToIgnoreCase(this.dbName) != 0) {
            SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 245);
            var3.fillInStackTrace();
            throw var3;
        } else {
            this.doUnregisterDatabaseChangeNotification(var2);
        }
    }

    void doUnregisterDatabaseChangeNotification(NTFDCNRegistration var1) throws SQLException {
        SQLException var2 = DatabaseError.createUnsupportedFeatureSqlException();
        var2.fillInStackTrace();
        throw var2;
    }

    public void unregisterDatabaseChangeNotification(int var1) throws SQLException {
        String var2 = null;

        try {
            var2 = InetAddress.getLocalHost().getHostAddress();
        } catch (Exception var4) {
        }

        this.unregisterDatabaseChangeNotification(var1, var2, 47632);
    }

    public void unregisterDatabaseChangeNotification(int var1, String var2, int var3) throws SQLException {
        String var4 = "(ADDRESS=(PROTOCOL=tcp)(HOST=" + var2 + ")(PORT=" + var3 + "))?PR=0";
        this.unregisterDatabaseChangeNotification((long)var1, var4);
    }

    public void unregisterDatabaseChangeNotification(long var1, String var3) throws SQLException {
        this.doUnregisterDatabaseChangeNotification(var1, var3);
    }

    void doUnregisterDatabaseChangeNotification(long var1, String var3) throws SQLException {
        SQLException var4 = DatabaseError.createUnsupportedFeatureSqlException();
        var4.fillInStackTrace();
        throw var4;
    }

    public void addXSEventListener(XSEventListener var1) throws SQLException {
        SQLException var2 = DatabaseError.createUnsupportedFeatureSqlException();
        var2.fillInStackTrace();
        throw var2;
    }

    public void addXSEventListener(XSEventListener var1, Executor var2) throws SQLException {
        SQLException var3 = DatabaseError.createUnsupportedFeatureSqlException();
        var3.fillInStackTrace();
        throw var3;
    }

    public void removeXSEventListener(XSEventListener var1) throws SQLException {
        SQLException var2 = DatabaseError.createUnsupportedFeatureSqlException();
        var2.fillInStackTrace();
        throw var2;
    }

    public void removeAllXSEventListener() throws SQLException {
        SQLException var1 = DatabaseError.createUnsupportedFeatureSqlException();
        var1.fillInStackTrace();
        throw var1;
    }

    public void setPDBChangeEventListener(PDBChangeEventListener var1) throws SQLException {
        SQLException var2 = DatabaseError.createUnsupportedFeatureSqlException();
        var2.fillInStackTrace();
        throw var2;
    }

    public void setPDBChangeEventListener(PDBChangeEventListener var1, Executor var2) throws SQLException {
        SQLException var3 = DatabaseError.createUnsupportedFeatureSqlException();
        var3.fillInStackTrace();
        throw var3;
    }

    public void addLogicalTransactionIdEventListener(LogicalTransactionIdEventListener var1) throws SQLException {
        SQLException var2 = DatabaseError.createUnsupportedFeatureSqlException();
        var2.fillInStackTrace();
        throw var2;
    }

    public void addLogicalTransactionIdEventListener(LogicalTransactionIdEventListener var1, Executor var2) throws SQLException {
        SQLException var3 = DatabaseError.createUnsupportedFeatureSqlException();
        var3.fillInStackTrace();
        throw var3;
    }

    public void removeLogicalTransactionIdEventListener(LogicalTransactionIdEventListener var1) throws SQLException {
        SQLException var2 = DatabaseError.createUnsupportedFeatureSqlException();
        var2.fillInStackTrace();
        throw var2;
    }

    public oracle.jdbc.LogicalTransactionId getLogicalTransactionId() throws SQLException {
        SQLException var1 = DatabaseError.createUnsupportedFeatureSqlException();
        var1.fillInStackTrace();
        throw var1;
    }

    public TypeDescriptor[] getAllTypeDescriptorsInCurrentSchema() throws SQLException {
        TypeDescriptor[] var1 = null;
        Statement var2 = null;
        this.beginNonRequestCalls();

        try {
            var2 = this.createStatement();
            ResultSet var3 = var2.executeQuery("SELECT schema_name, typename, typoid, typecode, version, tds  FROM TABLE(private_jdbc.Get_Type_Shape_Info())");
            var1 = this.getTypeDescriptorsFromResultSet(var3);
            var3.close();
        } catch (SQLException var8) {
            if (var8.getErrorCode() == 904) {
                SQLException var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 165);
                var4.fillInStackTrace();
                throw var4;
            }

            throw var8;
        } finally {
            if (var2 != null) {
                var2.close();
            }

            this.endNonRequestCalls();
        }

        return var1;
    }

    public TypeDescriptor[] getTypeDescriptorsFromListInCurrentSchema(String[] var1) throws SQLException {
        String var2 = "SELECT schema_name, typename, typoid, typecode, version, tds  FROM TABLE(private_jdbc.Get_Type_Shape_Info(?))";
        TypeDescriptor[] var3 = null;
        PreparedStatement var4 = null;
        this.beginNonRequestCalls();

        try {
            var4 = this.prepareStatement(var2);
            int var5 = var1.length;
            StringBuffer var13 = new StringBuffer(var5 * 8);

            for(int var7 = 0; var7 < var5; ++var7) {
                var13.append(var1[var7]);
                if (var7 < var5 - 1) {
                    var13.append(',');
                }
            }

            var4.setString(1, var13.toString());
            ResultSet var14 = var4.executeQuery();
            var3 = this.getTypeDescriptorsFromResultSet(var14);
            var14.close();
            return var3;
        } catch (SQLException var11) {
            if (var11.getErrorCode() == 904) {
                SQLException var6 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 165);
                var6.fillInStackTrace();
                throw var6;
            } else {
                throw var11;
            }
        } finally {
            if (var4 != null) {
                var4.close();
            }

            this.endNonRequestCalls();
        }
    }

    public TypeDescriptor[] getTypeDescriptorsFromList(String[][] var1) throws SQLException {
        TypeDescriptor[] var2 = null;
        PreparedStatement var3 = null;
        int var4 = var1.length;
        StringBuffer var5 = new StringBuffer(var4 * 8);
        StringBuffer var6 = new StringBuffer(var4 * 8);

        for(int var7 = 0; var7 < var4; ++var7) {
            var5.append(var1[var7][0]);
            var6.append(var1[var7][1]);
            if (var7 < var4 - 1) {
                var5.append(',');
                var6.append(',');
            }
        }

        this.beginNonRequestCalls();

        try {
            String var14 = "SELECT schema_name, typename, typoid, typecode, version, tds FROM TABLE(private_jdbc.Get_All_Type_Shape_Info(?,?))";
            var3 = this.prepareStatement(var14);
            var3.setString(1, var5.toString());
            var3.setString(2, var6.toString());
            ResultSet var15 = var3.executeQuery();
            var2 = this.getTypeDescriptorsFromResultSet(var15);
            var15.close();
        } catch (SQLException var12) {
            if (var12.getErrorCode() == 904) {
                SQLException var8 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 165);
                var8.fillInStackTrace();
                throw var8;
            }

            throw var12;
        } finally {
            if (var3 != null) {
                var3.close();
            }

            this.endNonRequestCalls();
        }

        return var2;
    }

    TypeDescriptor[] getTypeDescriptorsFromResultSet(ResultSet var1) throws SQLException {
        ArrayList var2 = new ArrayList();

        while(var1.next()) {
            String var3 = var1.getString(1);
            String var4 = var1.getString(2);
            byte[] var5 = var1.getBytes(3);
            String var6 = var1.getString(4);
            int var7 = var1.getInt(5);
            byte[] var8 = var1.getBytes(6);
            SQLName var9 = new SQLName(var3, var4, this);
            if (var6.equals("OBJECT")) {
                StructDescriptor var10 = StructDescriptor.createDescriptor(var9, var5, var7, var8, this);
                this.putDescriptor((byte[])var5, var10);
                this.putDescriptor((String)var10.getName(), var10);
                var2.add(var10);
            } else if (var6.equals("COLLECTION")) {
                ArrayDescriptor var14 = ArrayDescriptor.createDescriptor(var9, var5, var7, var8, this);
                this.putDescriptor((byte[])var5, var14);
                this.putDescriptor((String)var14.getName(), var14);
                var2.add(var14);
            }
        }

        TypeDescriptor[] var11 = new TypeDescriptor[var2.size()];

        for(int var12 = 0; var12 < var2.size(); ++var12) {
            TypeDescriptor var13 = (TypeDescriptor)((TypeDescriptor)var2.get(var12));
            var11[var12] = var13;
        }

        return var11;
    }

    public synchronized boolean isUsable() {
        return this.isUsable;
    }

    public void setUsable(boolean var1) {
        this.isUsable = var1;
    }

    void queryFCFProperties(Properties var1) throws SQLException {
        Statement var2 = null;
        ResultSet var3 = null;
        String var4 = "select sys_context('userenv', 'instance_name'),sys_context('userenv', 'server_host'),sys_context('userenv', 'service_name'),sys_context('userenv', 'db_unique_name') from dual";

        try {
            var2 = this.createStatement();
            var2.setFetchSize(1);
            var3 = var2.executeQuery(var4);

            while(var3.next()) {
                String var5 = null;
                var5 = var3.getString(1);
                if (var5 != null) {
                    var1.put("INSTANCE_NAME", var5.trim());
                }

                var5 = var3.getString(2);
                if (var5 != null) {
                    var1.put("SERVER_HOST", var5.trim());
                }

                var5 = var3.getString(3);
                if (var5 != null) {
                    var1.put("SERVICE_NAME", var5.trim());
                }

                var5 = var3.getString(4);
                if (var5 != null) {
                    var1.put("DATABASE_NAME", var5.trim());
                }
            }
        } finally {
            if (var3 != null) {
                var3.close();
            }

            if (var2 != null) {
                var2.close();
            }

        }

    }

    public void setDefaultTimeZone(TimeZone var1) throws SQLException {
        this.defaultTimeZone = var1;
    }

    public TimeZone getDefaultTimeZone() throws SQLException {
        return this.defaultTimeZone;
    }

    public int getTimezoneVersionNumber() throws SQLException {
        return this.timeZoneVersionNumber;
    }

    public TIMEZONETAB getTIMEZONETAB() throws SQLException {
        if (this.timeZoneTab == null) {
            this.timeZoneTab = TIMEZONETAB.getInstance(this.getTimezoneVersionNumber());
        }

        return this.timeZoneTab;
    }

    public boolean isDataInLocatorEnabled() throws SQLException {
        return this.getVersionNumber() >= 10200 & this.getVersionNumber() < 11000 & this.enableReadDataInLocator | this.overrideEnableReadDataInLocator;
    }

    public boolean isLobStreamPosStandardCompliant() throws SQLException {
        return this.lobStreamPosStandardCompliant;
    }

    public long getCurrentSCN() throws SQLException {
        return this.doGetCurrentSCN();
    }

    long doGetCurrentSCN() throws SQLException {
        SQLException var1 = DatabaseError.createUnsupportedFeatureSqlException();
        var1.fillInStackTrace();
        throw var1;
    }

    void doSetSnapshotSCN(long var1) throws SQLException {
        SQLException var3 = DatabaseError.createUnsupportedFeatureSqlException();
        var3.fillInStackTrace();
        throw var3;
    }

    public EnumSet<TransactionState> getTransactionState() throws SQLException {
        return this.doGetTransactionState();
    }

    EnumSet<TransactionState> doGetTransactionState() throws SQLException {
        SQLException var1 = DatabaseError.createUnsupportedFeatureSqlException();
        var1.fillInStackTrace();
        throw var1;
    }

    public boolean isConnectionSocketKeepAlive() throws SocketException, SQLException {
        SQLException var1 = DatabaseError.createUnsupportedFeatureSqlException();
        var1.fillInStackTrace();
        throw var1;
    }

    public void setReplayOperations(EnumSet<ReplayOperation> var1) throws SQLException {
        SQLException var2 = DatabaseError.createUnsupportedFeatureSqlException();
        var2.fillInStackTrace();
        throw var2;
    }

    public void beginNonRequestCalls() throws SQLException {
    }

    public void endNonRequestCalls() throws SQLException {
    }

    public void setReplayContext(oracle.jdbc.internal.ReplayContext[] var1) throws SQLException {
        SQLException var2 = DatabaseError.createUnsupportedFeatureSqlException();
        var2.fillInStackTrace();
        throw var2;
    }

    public void setReplayingMode(boolean var1) throws SQLException {
        SQLException var2 = DatabaseError.createUnsupportedFeatureSqlException();
        var2.fillInStackTrace();
        throw var2;
    }

    public void registerEndReplayCallback(EndReplayCallback var1) throws SQLException {
        SQLException var2 = DatabaseError.createUnsupportedFeatureSqlException();
        var2.fillInStackTrace();
        throw var2;
    }

    public int getEOC() throws SQLException {
        SQLException var1 = DatabaseError.createUnsupportedFeatureSqlException();
        var1.fillInStackTrace();
        throw var1;
    }

    public oracle.jdbc.internal.ReplayContext[] getReplayContext() throws SQLException {
        SQLException var1 = DatabaseError.createUnsupportedFeatureSqlException();
        var1.fillInStackTrace();
        throw var1;
    }

    public oracle.jdbc.internal.ReplayContext getLastReplayContext() throws SQLException {
        SQLException var1 = DatabaseError.createUnsupportedFeatureSqlException();
        var1.fillInStackTrace();
        throw var1;
    }

    public byte[] getDerivedKeyInternal(byte[] var1, int var2) throws NoSuchAlgorithmException, InvalidKeySpecException, SQLException {
        SQLException var3 = DatabaseError.createUnsupportedFeatureSqlException();
        var3.fillInStackTrace();
        throw var3;
    }

    public void abort(Executor var1) throws SQLException {
        SecurityManager var2 = System.getSecurityManager();
        if (var2 != null) {
            var2.checkPermission(CALL_ABORT_PERMISSION);
        }

        var1.execute(new Runnable() {
            public void run() {
                try {
                    if (PhysicalConnection.this.lifecycle == 4 || PhysicalConnection.this.lifecycle == 8) {
                        return;
                    }

                    PhysicalConnection.this.lifecycle = 8;
                    PhysicalConnection.this.doAbort();
                    PhysicalConnection.this.close();
                } catch (Exception var5) {
                } finally {
                    PhysicalConnection.this.lifecycle = 4;
                }

            }
        });
    }

    public String getSchema() throws SQLException {
        return this.getCurrentSchema();
    }

    public final void setNetworkTimeout(Executor var1, int var2) throws SQLException {
        SecurityManager var3 = System.getSecurityManager();
        if (var3 != null) {
            var3.checkPermission(CALL_SETNETWORKTIMEOUT_PERMISSION);
        }

        SQLException var4;
        if (var2 < 0) {
            var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 285);
            var4.fillInStackTrace();
            throw var4;
        } else if (var2 > 0 && var1 == null) {
            var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 284);
            var4.fillInStackTrace();
            throw var4;
        } else {
            this.closeExecutor = var2 == 0 ? null : var1;
            this.doSetNetworkTimeout(var2);
        }
    }

    public int getNetworkTimeout() throws SQLException {
        SQLException var1 = DatabaseError.createUnsupportedFeatureSqlException();
        var1.fillInStackTrace();
        throw var1;
    }

    protected void doSetNetworkTimeout(int var1) throws SQLException {
        SQLException var2 = DatabaseError.createUnsupportedFeatureSqlException();
        var2.fillInStackTrace();
        throw var2;
    }

    void doAsynchronousClose() {
        if (this.closeExecutor != null) {
            this.closeExecutor.execute(new Runnable() {
                public void run() {
                    try {
                        PhysicalConnection.this.close();
                    } catch (Throwable var2) {
                    }

                }
            });
        }

    }

    public void setSchema(String var1) throws SQLException {
        String var2 = "\"[^\u0000\"]{0,28}\"";
        String var3 = "(\\p{javaLowerCase}|\\p{javaUpperCase})(\\p{javaLowerCase}|\\p{javaUpperCase}|\\d|_|$|#){0,29}";
        String var4 = "(" + var2 + ")|(" + var3 + ")";
        SQLException var10;
        if (var1 == null) {
            var10 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 68);
            var10.fillInStackTrace();
            throw var10;
        } else if (!var1.matches(var4)) {
            var10 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 68);
            var10.fillInStackTrace();
            throw var10;
        } else {
            String var5 = "alter session set current_schema = " + var1;
            Statement var6 = null;

            try {
                var6 = this.createStatement();
                var6.execute(var5);
            } finally {
                if (var6 != null) {
                    var6.close();
                }

            }

        }
    }

    void releaseConnectionToPool() throws SQLException {
        SQLException var1 = DatabaseError.createUnsupportedFeatureSqlException();
        var1.fillInStackTrace();
        throw var1;
    }

    boolean reusePooledConnection() throws SQLException {
        SQLException var1 = DatabaseError.createUnsupportedFeatureSqlException();
        var1.fillInStackTrace();
        throw var1;
    }

    void resetAfterReusePooledConnection() throws SQLException {
        if (this.needToPurgeStatementCache()) {
            this.purgeStatementCache();
        }

    }

    public boolean attachServerConnection() throws SQLException {
        if (this.lifecycle != 1) {
            SQLException var1 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 8);
            var1.fillInStackTrace();
            throw var1;
        } else {
            return !this.drcpEnabled ? true : this.reusePooledConnection();
        }
    }

    public boolean isDRCPEnabled() throws SQLException {
        return this.drcpEnabled;
    }

    public void detachServerConnection(String var1) throws SQLException {
        if (this.lifecycle != 1) {
            SQLException var2 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 8);
            var2.fillInStackTrace();
            throw var2;
        } else if (this.drcpEnabled) {
            this.drcpTagName = var1;
            this.purgeStatementCache();
            this.closeStatements(false);
            this.releaseConnectionToPool();
        }
    }

    public boolean needToPurgeStatementCache() throws SQLException {
        SQLException var1 = DatabaseError.createUnsupportedFeatureSqlException();
        var1.fillInStackTrace();
        throw var1;
    }

    public short getExecutingRPCFunctionCode() {
        return 0;
    }

    public String getExecutingRPCSQL() {
        return "";
    }

    public int getNegotiatedSDU() throws SQLException {
        SQLException var1 = DatabaseError.createUnsupportedFeatureSqlException();
        var1.fillInStackTrace();
        throw var1;
    }

    public void setChecksumMode(ChecksumMode var1) throws SQLException {
        this.checksumMode = var1;
    }

    public int getVarTypeMaxLenCompat() throws SQLException {
        return this.varTypeMaxLenCompat;
    }

    static final boolean bit(long var0, long var2) {
        return (var0 & var2) == var2;
    }

    static final boolean bit(int var0, int var1) {
        return (var0 & var1) == var1;
    }

    void onPDBChange() throws SQLException {
        this.removeAllDescriptor();
        if (this.isStatementCacheInitialized()) {
            this.statementCache.purgeExplicitCache();
            this.statementCache.purgeImplicitCache();
        }

    }

    private static final class BufferCacheStore {
        static int MAX_CACHED_BUFFER_SIZE = 2147483647;
        final BufferCache<byte[]> byteBufferCache;
        final BufferCache<char[]> charBufferCache;

        BufferCacheStore() {
            this(MAX_CACHED_BUFFER_SIZE);
        }

        BufferCacheStore(int var1) {
            this.byteBufferCache = new BufferCache(var1);
            this.charBufferCache = new BufferCache(var1);
        }
    }

    static enum DrcpState {
        STATEFUL,
        STATELESS;

        private DrcpState() {
        }
    }
}
