//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package oracle.jdbc.driver;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.lang.reflect.Field;
import java.net.SocketException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.Executor;
import java.util.zip.CRC32;
import oracle.jdbc.LogicalTransactionId;
import oracle.jdbc.LogicalTransactionIdEventListener;
import oracle.jdbc.NotificationRegistration.RegistrationState;
import oracle.jdbc.OracleConnection.CommitOption;
import oracle.jdbc.OracleConnection.DatabaseShutdownMode;
import oracle.jdbc.OracleConnection.DatabaseStartupMode;
import oracle.jdbc.aq.AQDequeueOptions;
import oracle.jdbc.aq.AQEnqueueOptions;
import oracle.jdbc.driver.PhysicalConnection.DrcpState;
import oracle.jdbc.internal.JMSDequeueOptions;
import oracle.jdbc.internal.JMSEnqueueOptions;
import oracle.jdbc.internal.JMSMessageProperties;
import oracle.jdbc.internal.JMSNotificationRegistration;
import oracle.jdbc.internal.KeywordValue;
import oracle.jdbc.internal.KeywordValueLong;
import oracle.jdbc.internal.OracleBfile;
import oracle.jdbc.internal.OracleBlob;
import oracle.jdbc.internal.OracleClob;
import oracle.jdbc.internal.OracleConnection;
import oracle.jdbc.internal.PDBChangeEventListener;
import oracle.jdbc.internal.ReplayContext;
import oracle.jdbc.internal.XSEventListener;
import oracle.jdbc.internal.XSKeyval;
import oracle.jdbc.internal.XSNamespace;
import oracle.jdbc.internal.XSPrincipal;
import oracle.jdbc.internal.XSSecureId;
import oracle.jdbc.internal.XSSessionParameters;
import oracle.jdbc.internal.OracleConnection.EndReplayCallback;
import oracle.jdbc.internal.OracleConnection.InstanceProperty;
import oracle.jdbc.internal.OracleConnection.ReplayOperation;
import oracle.jdbc.internal.OracleConnection.TransactionState;
import oracle.jdbc.internal.OracleConnection.XSOperationCode;
import oracle.jdbc.internal.OracleConnection.XSSessionModeFlag;
import oracle.jdbc.internal.OracleConnection.XSSessionOperationCode;
import oracle.jdbc.internal.OracleConnection.XSSessionSetOperationCode;
import oracle.jdbc.internal.OracleStatement.SqlKind;
import oracle.jdbc.pool.OraclePooledConnection;
import oracle.net.ns.Communication;
import oracle.net.ns.NSProtocolNIO;
import oracle.net.ns.NSProtocolStream;
import oracle.net.ns.NetException;
import oracle.sql.BFILE;
import oracle.sql.BLOB;
import oracle.sql.BfileDBAccess;
import oracle.sql.BlobDBAccess;
import oracle.sql.CLOB;
import oracle.sql.ClobDBAccess;
import oracle.sql.LobPlsqlUtil;
import oracle.sql.TIMESTAMPTZ;

class T4CConnection extends PhysicalConnection implements BfileDBAccess, BlobDBAccess, ClobDBAccess {
    static final short MIN_TTCVER_SUPPORTED = 4;
    static final short V8_TTCVER_SUPPORTED = 5;
    static final short MAX_TTCVER_SUPPORTED = 6;
    static final int DEFAULT_LONG_PREFETCH_SIZE = 4080;
    static final String DEFAULT_CONNECT_STRING = "localhost:1521:orcl";
    static final int REFCURSOR_SIZE = 5;
    long LOGON_MODE = 0L;
    boolean isLoggedOn;
    private boolean useZeroCopyIO;
    boolean useLobPrefetch;
    private String password;
    Communication net;
    int eocs;
    private NTFEventListener[] ltxidListeners = new NTFEventListener[0];
    private NTFEventListener[] xsListeners = new NTFEventListener[0];
    NTFEventListener pdbChangeListener = null;
    boolean readAsNonStream;
    T4CTTIoer oer;
    T4CMAREngine mare;
    T4C8TTIpro pro;
    T4CTTIrxd rxd;
    T4CTTIsto sto;
    T4CTTIspfp spfp;
    T4CTTIoauthenticate auth;
    T4C8Odscrarr describe;
    T4C8Oall all8;
    T4C8Oclose close8;
    T4C7Ocommoncall commoncall;
    T4Caqe aqe;
    T4Caqdq aqdq;
    T4CTTIoaqenq oaqenq;
    T4CTTIoaqdeq oaqdeq;
    T4CTTIkpdnrdeq kpdnrdeq;
    T4C8TTIBfile bfileMsg;
    T4C8TTIBlob blobMsg;
    T4C8TTIClob clobMsg;
    T4CTTIoses oses;
    T4CTTIoping oping;
    T4CTTIokpn okpn;
    byte[] EMPTY_BYTE = new byte[0];
    T4CTTIOtxen otxen;
    T4CTTIOtxse otxse;
    T4CTTIk2rpc k2rpc;
    T4CTTIoscid oscid;
    T4CTTIokeyval okeyval;
    T4CTTIoxsscs oxsscs;
    T4CTTIoxssro oxssro;
    T4CTTIoxsspo oxsspo;
    T4CTTIxsnsop xsnsop;
    T4CTTIosesstate osesstate;
    T4CTTIoappcontreplay oappcontreplay;
    T4CTTIoxsns xsnsop2;
    T4CTTIoxscre oxscre;
    T4CTTIoxsdes oxsdes;
    T4CTTIoxsdet oxsdet;
    T4CTTIoxsatt oxsatt;
    T4CTTIoxsset oxsset;
    T4CTTIosessrls osessrls;
    T4CTTIosessget osessget;
    T4CTTIocsessret ocsessret;
    int[] cursorToClose;
    int cursorToCloseOffset;
    int[] queryToClose;
    int queryToCloseOffset;
    int[] lusFunctionId2;
    byte[][] lusSessionId2;
    KeywordValueLong[][] lusInKeyVal2;
    int[] lusInFlags2;
    int lusOffset2;
    long ossestateOperations;
    static final int DIRECTIVE_REPLAY_ENABLED = 4;
    EnumSet<T4CConnection.ReplayMode> replayModes;
    EndReplayCallback endReplayCallback;
    ReplayContext[] oappcontreplayContextsArr;
    int oappcontreplayOffset;
    int sessionId;
    int serialNumber;
    byte negotiatedTTCversion;
    byte[] serverRuntimeCapabilities;
    byte[] serverCompileTimeCapabilities;
    Hashtable namespaces;
    byte[] internalName;
    byte[] externalName;
    static final int FREE = -1;
    static final int SEND = 1;
    static final int RECEIVE = 2;
    int pipeState = -1;
    boolean sentCancel = false;
    String currentSchema;
    int maxNonStreamBindByteSize;
    boolean cancelInProgressFlag = false;
    boolean statementCancel = true;
    String databaseUniqueIdentifier;
    static final Map<String, String[]> cachedVersionTable = new Hashtable();
    byte currentTTCSeqNumber = 0;
    short[] ttiList;
    short executingRPCFunctionCode = 0;
    String executingRPCSQL;
    private final CRC32 checksumEngine = new CRC32();
    private final Hashtable<Long, Integer> tempLobRefCount = new Hashtable();
    static final int MAX_SIZE_VSESSION_OSUSER = 30;
    static final int MAX_SIZE_VSESSION_PROCESS = 24;
    static final int MAX_SIZE_VSESSION_MACHINE = 64;
    static final int MAX_SIZE_VSESSION_TERMINAL = 30;
    static final int MAX_SIZE_VSESSION_PROGRAM = 48;
    private static final String _Copyright_2007_Oracle_All_Rights_Reserved_ = null;
    public static final String BUILD_DATE = "Thu_Apr_04_15:09:24_PDT_2013";
    public static final boolean TRACE = false;

    public short getExecutingRPCFunctionCode() {
        return this.executingRPCFunctionCode;
    }

    void setExecutingRPCFunctionCode(short var1) {
        this.executingRPCFunctionCode = var1;
    }

    void setExecutingRPCSQL(String var1) {
        this.executingRPCSQL = var1;
    }

    public String getExecutingRPCSQL() {
        return this.executingRPCSQL;
    }

    T4CConnection(String var1, Properties var2, OracleDriverExtension var3) throws SQLException {
        super(var1, var2, var3);
    }

    void additionalInitialization() throws SQLException {
        this.cursorToClose = new int[4];
        this.cursorToCloseOffset = 0;
        this.queryToClose = new int[10];
        this.queryToCloseOffset = 0;
        this.lusFunctionId2 = new int[10];
        this.lusSessionId2 = new byte[10][];
        this.lusInKeyVal2 = new KeywordValueLong[10][];
        this.lusInFlags2 = new int[10];
        this.lusOffset2 = 0;
        this.replayModes = EnumSet.noneOf(T4CConnection.ReplayMode.class);
        this.ossestateOperations = -1L;
        this.endReplayCallback = null;
        this.oappcontreplayOffset = 0;
        this.oappcontreplayContextsArr = null;
        this.minVcsBindSize = 0;
        this.namespaces = new Hashtable(5);
        this.currentSchema = null;
        this.ttiList = new short[128];
    }

    final void initializePassword(String var1) throws SQLException {
        this.password = var1;
    }

    void logon() throws SQLException {
        Object var1 = null;

        SQLException var3;
        try {
            if (this.isLoggedOn) {
                SQLException var14 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 428);
                var14.fillInStackTrace();
                throw var14;
            } else {
                if (this.database == null) {
                    this.database = "localhost:1521:orcl";
                }

                this.connect(this.database);
                this.all8 = new T4C8Oall(this);
                this.okpn = new T4CTTIokpn(this);
                this.close8 = new T4C8Oclose(this);
                this.sto = new T4CTTIsto(this);
                this.spfp = new T4CTTIspfp(this);
                this.commoncall = new T4C7Ocommoncall(this);
                this.describe = new T4C8Odscrarr(this);
                this.bfileMsg = new T4C8TTIBfile(this);
                this.blobMsg = new T4C8TTIBlob(this);
                this.clobMsg = new T4C8TTIClob(this);
                this.otxen = new T4CTTIOtxen(this);
                this.otxse = new T4CTTIOtxse(this);
                this.oping = new T4CTTIoping(this);
                this.k2rpc = new T4CTTIk2rpc(this);
                this.oses = new T4CTTIoses(this);
                this.okeyval = new T4CTTIokeyval(this);
                this.oxssro = new T4CTTIoxssro(this);
                this.oxsspo = new T4CTTIoxsspo(this);
                this.oxsscs = new T4CTTIoxsscs(this);
                this.oxscre = new T4CTTIoxscre(this);
                this.oxsdes = new T4CTTIoxsdes(this);
                this.oxsatt = new T4CTTIoxsatt(this);
                this.xsnsop = new T4CTTIxsnsop(this);
                this.xsnsop2 = new T4CTTIoxsns(this);
                this.oxsdet = new T4CTTIoxsdet(this);
                this.oxsset = new T4CTTIoxsset(this);
                this.aqe = new T4Caqe(this);
                this.aqdq = new T4Caqdq(this);
                this.oscid = new T4CTTIoscid(this);
                this.osessrls = new T4CTTIosessrls(this);
                this.ocsessret = new T4CTTIocsessret(this);
                this.osessget = new T4CTTIosessget(this);
                this.oaqenq = new T4CTTIoaqenq(this);
                this.oaqdeq = new T4CTTIoaqdeq(this);
                this.kpdnrdeq = new T4CTTIkpdnrdeq(this);
                this.osesstate = new T4CTTIosesstate(this);
                this.oappcontreplay = new T4CTTIoappcontreplay(this);
                this.LOGON_MODE = 0L;
                if (this.internalLogon != null) {
                    if (this.internalLogon.equalsIgnoreCase("sysoper")) {
                        this.LOGON_MODE = 64L;
                    } else if (this.internalLogon.equalsIgnoreCase("sysdba")) {
                        this.LOGON_MODE = 32L;
                    } else if (this.internalLogon.equalsIgnoreCase("sysasm")) {
                        this.LOGON_MODE = 4194304L;
                    } else if (this.internalLogon.equalsIgnoreCase("sysbackup")) {
                        this.LOGON_MODE = 16777216L;
                    } else if (this.internalLogon.equalsIgnoreCase("sysdg")) {
                        this.LOGON_MODE = 33554432L;
                    } else if (this.internalLogon.equalsIgnoreCase("syskm")) {
                        this.LOGON_MODE = 67108864L;
                    }
                }

                if (this.prelimAuth) {
                    this.LOGON_MODE |= 128L;
                }

                this.auth = new T4CTTIoauthenticate(this, this.resourceManagerId, this.serverCompileTimeCapabilities);
                if (this.userName != null && this.userName.length() != 0) {
                    try {
                        this.auth.doOSESSKEY(this.userName, this.LOGON_MODE);
                    } catch (SQLException var10) {
                        if (var10.getErrorCode() != 1017) {
                            throw var10;
                        }

                        this.userName = null;
                    }
                }

                this.auth.doOAUTH(this.userName, this.password, this.LOGON_MODE);
                this.sessionId = this.getSessionId();
                this.serialNumber = this.getSerialNumber();
                this.internalName = this.auth.internalName;
                this.externalName = this.auth.externalName;
                this.instanceName = this.sessionProperties.getProperty("AUTH_INSTANCENAME");
                this.dbName = this.sessionProperties.getProperty("AUTH_DBNAME");
                this.databaseUniqueIdentifier = this.sessionProperties.getProperty("AUTH_DB_ID");
                String var2 = (String)this.sessionProperties.get("AUTH_SC_INSTANCE_START_TIME");
                String[] var15 = null;
                if (this.drcpEnabled && this.databaseUniqueIdentifier != null) {
                    var15 = (String[])cachedVersionTable.get(this.databaseUniqueIdentifier + var2);
                }

                if (!this.prelimAuth && !this.jmsNotificationConnection && var15 == null) {
                    T4C7Oversion var4 = new T4C7Oversion(this);
                    var4.doOVERSION();
                    byte[] var5 = var4.getVersion();

                    try {
                        this.databaseProductVersion = new String(var5, "UTF8");
                    } catch (UnsupportedEncodingException var9) {
                        SQLException var7 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), var9);
                        var7.fillInStackTrace();
                        throw var7;
                    }

                    this.versionNumber = var4.getVersionNumber();
                    if (this.drcpEnabled && this.databaseUniqueIdentifier != null) {
                        var15 = new String[]{this.databaseProductVersion, String.valueOf(this.versionNumber)};
                        cachedVersionTable.put(this.databaseUniqueIdentifier + var2, var15);
                        this.detachServerConnection((String)null);
                    }
                } else if (var15 == null) {
                    this.versionNumber = 0;
                } else {
                    this.databaseProductVersion = var15[0];
                    this.versionNumber = Short.parseShort(var15[1]);
                }

                this.isLoggedOn = true;
                if (this.getVersionNumber() < 11000) {
                    this.enableTempLobRefCnt = false;
                }

            }
        } catch (NetException var11) {
            var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), var11);
            var3.fillInStackTrace();
            throw var3;
        } catch (IOException var12) {
            this.handleIOException(var12);
            var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), var12);
            var3.fillInStackTrace();
            throw var3;
        } catch (SQLException var13) {
            if (var1 != null) {
                var13.initCause((Throwable)var1);
            }

            try {
                this.net.disconnect();
            } catch (Exception var8) {
            }

            this.isLoggedOn = false;
            throw var13;
        }
    }

    void handleIOException(IOException var1) throws SQLException {
        try {
            this.pipeState = -1;
            this.net.disconnect();
            this.net = null;
        } catch (Exception var3) {
        }

        this.isLoggedOn = false;
        this.lifecycle = 4;
    }

    synchronized void logoff() throws SQLException {
        try {
            this.assertLoggedOn("T4CConnection.logoff");
            if (this.lifecycle == 8) {
                return;
            }

            this.commoncall.doOLOGOFF();
            this.net.disconnect();
            this.net = null;
        } catch (IOException var12) {
            this.handleIOException(var12);
            if (this.lifecycle != 8) {
                SQLException var2 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), var12);
                var2.fillInStackTrace();
                throw var2;
            }
        } finally {
            try {
                if (this.net != null) {
                    this.net.disconnect();
                }
            } catch (Exception var11) {
            }

            this.isLoggedOn = false;
        }

    }

    T4CMAREngine getMarshalEngine() {
        return this.mare;
    }

    synchronized void doCommit(int var1) throws SQLException {
        this.assertLoggedOn("T4CConnection.do_commit");

        try {
            if (var1 == 0) {
                this.commoncall.doOCOMMIT();
            } else {
                int var2 = 0;
                if ((var1 & CommitOption.WRITEBATCH.getCode()) != 0) {
                    var2 = var2 | 2 | 1;
                } else if ((var1 & CommitOption.WRITEIMMED.getCode()) != 0) {
                    var2 |= 2;
                }

                if ((var1 & CommitOption.NOWAIT.getCode()) != 0) {
                    var2 = var2 | 8 | 4;
                } else if ((var1 & CommitOption.WAIT.getCode()) != 0) {
                    var2 |= 8;
                }

                this.otxen.doOTXEN(1, (byte[])null, (byte[])null, 0, 0, 0, 0, 4, var2);
                int var5 = this.otxen.getOutStateFromServer();
                if (var5 != 2 && var5 != 4) {
                }
            }

        } catch (IOException var4) {
            this.handleIOException(var4);
            SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), var4);
            var3.fillInStackTrace();
            throw var3;
        }
    }

    synchronized void doRollback() throws SQLException {
        try {
            this.assertLoggedOn("T4CConnection.do_rollback");
            this.commoncall.doOROLLBACK();
        } catch (IOException var3) {
            this.handleIOException(var3);
            SQLException var2 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), var3);
            var2.fillInStackTrace();
            throw var2;
        }
    }

    synchronized void doSetAutoCommit(boolean var1) throws SQLException {
        if (this.autoCommitSpecCompliant && var1 && this.getTransactionState().contains(TransactionState.TRANSACTION_STARTED)) {
            this.commit();
        }

        this.autocommit = var1;
    }

    synchronized void open(OracleStatement var1) throws SQLException {
        this.assertLoggedOn("T4CConnection.open");
        var1.setCursorId(0);
    }

    synchronized String doGetDatabaseProductVersion() throws SQLException {
        this.assertLoggedOn("T4CConnection.do_getDatabaseProductVersion");
        T4C7Oversion var1 = new T4C7Oversion(this);

        try {
            var1.doOVERSION();
        } catch (IOException var7) {
            this.handleIOException(var7);
            SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), var7);
            var3.fillInStackTrace();
            throw var3;
        }

        String var2 = null;
        byte[] var8 = var1.getVersion();

        try {
            var2 = new String(var8, "UTF8");
            return var2;
        } catch (UnsupportedEncodingException var6) {
            SQLException var5 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), var6);
            var5.fillInStackTrace();
            throw var5;
        }
    }

    synchronized short doGetVersionNumber() throws SQLException {
        this.assertLoggedOn("T4CConnection.do_getVersionNumber");
        T4C7Oversion var1 = new T4C7Oversion(this);

        try {
            var1.doOVERSION();
        } catch (IOException var4) {
            this.handleIOException(var4);
            SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), var4);
            var3.fillInStackTrace();
            throw var3;
        }

        return var1.getVersionNumber();
    }

    OracleStatement RefCursorBytesToStatement(byte[] var1, OracleStatement var2) throws SQLException {
        T4CStatement var3 = new T4CStatement(this, -1, -1);

        try {
            int var4 = this.mare.unmarshalRefCursor(var1);
            var3.setCursorId(var4);
            var3.isOpen = true;
            var3.sqlObject = var2.sqlObject;
            var3.serverCursor = true;
            var2.addChild(var3);
            var3.prepareForNewResults(true, false, true);
        } catch (IOException var6) {
            this.handleIOException(var6);
            SQLException var5 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), var6);
            var5.fillInStackTrace();
            throw var5;
        }

        var3.needToParse = false;
        return var3;
    }

    OracleStatement createImplicitResultSetStatement(OracleStatement var1) throws SQLException {
        T4CStatement var2 = new T4CStatement(this, -1, -1);
        var2.sqlObject = var1.sqlObject;
        var2.sqlKind = SqlKind.SELECT;
        var2.numberOfDefinePositions = var1.numberOfDefinePositions;
        var2.isOpen = var1.isOpen;
        var2.prepareForNewResults(true, false, true);
        var1.addImplicitResultSetStmt(var2);
        return var2;
    }

    void cancelOperationOnServer(boolean var1) throws SQLException {
        synchronized(this.cancelInProgressLockForThin) {
            if (!this.cancelInProgressFlag) {
                SQLException var4;
                try {
                    switch(this.pipeState) {
                        case -1:
                            return;
                        case 0:
                        default:
                            break;
                        case 1:
                            this.net.sendBreak();
                            break;
                        case 2:
                            this.net.sendInterrupt();
                    }

                    this.sentCancel = true;
                } catch (NetException var6) {
                    var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), var6);
                    var4.fillInStackTrace();
                    throw var4;
                } catch (IOException var7) {
                    this.handleIOException(var7);
                    var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), var7);
                    var4.fillInStackTrace();
                    throw var4;
                }

                this.cancelInProgressFlag = true;
                this.statementCancel = var1;
            }

        }
    }

    void connect(String var1) throws IOException, SQLException {
        if (var1 == null) {
            SQLException var7 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 433);
            var7.fillInStackTrace();
            throw var7;
        } else {
            Properties var2 = new Properties();
            if (this.thinNetProfile != null) {
                var2.setProperty("oracle.net.profile", this.thinNetProfile);
            }

            if (this.thinNetAuthenticationServices != null) {
                var2.setProperty("oracle.net.authentication_services", this.thinNetAuthenticationServices);
            }

            if (this.thinNetAuthenticationKrb5Mutual != null) {
                var2.setProperty("oracle.net.kerberos5_mutual_authentication", this.thinNetAuthenticationKrb5Mutual);
            }

            if (this.thinNetAuthenticationKrb5CcName != null) {
                var2.setProperty("oracle.net.kerberos5_cc_name", this.thinNetAuthenticationKrb5CcName);
            }

            if (this.thinNetEncryptionLevel != null) {
                var2.setProperty("oracle.net.encryption_client", this.thinNetEncryptionLevel);
            }

            if (this.thinNetEncryptionTypes != null) {
                var2.setProperty("oracle.net.encryption_types_client", this.thinNetEncryptionTypes);
            }

            if (this.thinNetChecksumLevel != null) {
                var2.setProperty("oracle.net.crypto_checksum_client", this.thinNetChecksumLevel);
            }

            if (this.thinNetChecksumTypes != null) {
                var2.setProperty("oracle.net.crypto_checksum_types_client", this.thinNetChecksumTypes);
            }

            if (this.thinNetCryptoSeed != null) {
                var2.setProperty("oracle.net.crypto_seed", this.thinNetCryptoSeed);
            }

            if (this.thinTcpNoDelay) {
                var2.setProperty("TCP.NODELAY", "YES");
            }

            if (this.thinReadTimeout != null) {
                var2.setProperty("oracle.net.READ_TIMEOUT", this.thinReadTimeout);
            }

            if (this.thinNetConnectTimeout != null) {
                var2.setProperty("oracle.net.CONNECT_TIMEOUT", this.thinNetConnectTimeout);
            }

            if (this.thinSslServerDnMatch != null) {
                var2.setProperty("oracle.net.ssl_server_dn_match", this.thinSslServerDnMatch);
            }

            if (this.walletLocation != null) {
                var2.setProperty("oracle.net.wallet_location", this.walletLocation);
            }

            if (this.walletPassword != null) {
                var2.setProperty("oracle.net.wallet_password", this.walletPassword);
            }

            if (this.thinSslVersion != null) {
                var2.setProperty("oracle.net.ssl_version", this.thinSslVersion);
            }

            if (this.thinSslCipherSuites != null) {
                var2.setProperty("oracle.net.ssl_cipher_suites", this.thinSslCipherSuites);
            }

            if (this.thinJavaxNetSslKeystore != null) {
                var2.setProperty("javax.net.ssl.keyStore", this.thinJavaxNetSslKeystore);
            }

            if (this.thinJavaxNetSslKeystoretype != null) {
                var2.setProperty("javax.net.ssl.keyStoreType", this.thinJavaxNetSslKeystoretype);
            }

            if (this.thinJavaxNetSslKeystorepassword != null) {
                var2.setProperty("javax.net.ssl.keyStorePassword", this.thinJavaxNetSslKeystorepassword);
            }

            if (this.thinJavaxNetSslTruststore != null) {
                var2.setProperty("javax.net.ssl.trustStore", this.thinJavaxNetSslTruststore);
            }

            if (this.thinJavaxNetSslTruststoretype != null) {
                var2.setProperty("javax.net.ssl.trustStoreType", this.thinJavaxNetSslTruststoretype);
            }

            if (this.thinJavaxNetSslTruststorepassword != null) {
                var2.setProperty("javax.net.ssl.trustStorePassword", this.thinJavaxNetSslTruststorepassword);
            }

            if (this.thinSslKeymanagerfactoryAlgorithm != null) {
                var2.setProperty("ssl.keyManagerFactory.algorithm", this.thinSslKeymanagerfactoryAlgorithm);
            }

            if (this.thinSslTrustmanagerfactoryAlgorithm != null) {
                var2.setProperty("ssl.trustManagerFactory.algorithm", this.thinSslTrustmanagerfactoryAlgorithm);
            }

            if (this.thinNetOldsyntax != null) {
                var2.setProperty("oracle.net.oldSyntax", this.thinNetOldsyntax);
            }

            if (this.thinNamingContextInitial != null) {
                var2.setProperty("java.naming.factory.initial", this.thinNamingContextInitial);
            }

            if (this.thinNamingProviderUrl != null) {
                var2.setProperty("java.naming.provider.url", this.thinNamingProviderUrl);
            }

            if (this.thinNamingSecurityAuthentication != null) {
                var2.setProperty("java.naming.security.authentication", this.thinNamingSecurityAuthentication);
            }

            if (this.thinNamingSecurityPrincipal != null) {
                var2.setProperty("java.naming.security.principal", this.thinNamingSecurityPrincipal);
            }

            if (this.thinNamingSecurityCredentials != null) {
                var2.setProperty("java.naming.security.credentials", this.thinNamingSecurityCredentials);
            }

            if (this.thinJndiLdapConnectTimeout != null) {
                var2.setProperty("com.sun.jndi.ldap.connect.timeout", this.thinJndiLdapConnectTimeout);
            }

            if (this.thinJndiLdapReadTimeout != null) {
                var2.setProperty("com.sun.jndi.ldap.read.timeout", this.thinJndiLdapReadTimeout);
            }

            if (this.thinNetDisableOutOfBandBreak) {
                var2.setProperty("DISABLE_OOB", "" + this.thinNetDisableOutOfBandBreak);
            }

            var2.setProperty("USE_ZERO_COPY_IO", "" + this.thinNetUseZeroCopyIO);
            var2.setProperty("FORCE_DNS_LOAD_BALANCING", "" + this.thinForceDnsLoadBalancing);
            var2.setProperty("oracle.jdbc.v$session.osuser", this.thinVsessionOsuser);
            var2.setProperty("oracle.jdbc.v$session.program", this.thinVsessionProgram);
            var2.setProperty("T4CConnection.hashCode", Integer.toHexString(this.hashCode()).toUpperCase());
            var2.setProperty("oracle.net.keepAlive", Boolean.toString(this.keepAlive));
            var2.setProperty("oracle.jdbc.useNio", Boolean.toString(this.javaNetNio));
            if (this.targetInstanceName != null) {
                var2.setProperty("oracle.jdbc.targetInstanceName", this.targetInstanceName);
            }

            if (this.javaNetNio) {
                this.net = new NSProtocolNIO(this.nsDirectBuffer);
            } else {
                this.net = new NSProtocolStream();
            }

            this.net.connect(var1, var2);
            if (this.javaNetNio) {
                this.mare = new T4CMAREngineNIO(this.net);
            } else {
                this.mare = new T4CMAREngineStream(this.net);
            }

            this.oer = new T4CTTIoer(this);
            this.mare.setConnectionDuringExceptionHandling(this);
            this.pro = new T4C8TTIpro(this);
            this.pro.marshal();
            this.serverCompileTimeCapabilities = this.pro.receive();
            this.serverRuntimeCapabilities = this.pro.getServerRuntimeCapabilities();
            short var3 = this.pro.getOracleVersion();
            short var4 = this.pro.getCharacterSet();
            short var5 = DBConversion.findDriverCharSet(var4, var3);
            this.conversion = new DBConversion(var4, var5, this.pro.getncharCHARSET(), this.isStrictAsciiConversion);
            this.mare.types.setServerConversion(var5 != var4);
            DBConversion var10000 = this.conversion;
            if (DBConversion.isCharSetMultibyte(var5)) {
                var10000 = this.conversion;
                if (DBConversion.isCharSetMultibyte(this.pro.getCharacterSet())) {
                    this.mare.types.setFlags((byte)1);
                } else {
                    this.mare.types.setFlags((byte)2);
                }
            } else {
                this.mare.types.setFlags(this.pro.getFlags());
            }

            this.mare.conv = this.conversion;
            if (this.serverCompileTimeCapabilities.length > 37 && bit(this.serverCompileTimeCapabilities[37], 32)) {
                this.mare.setUseCLRBigChunks(true);
            }

            T4C8TTIdty var6 = new T4C8TTIdty(this, this.serverCompileTimeCapabilities, this.serverRuntimeCapabilities, this.logonCap != null && this.logonCap.trim().equals("o3"), this.thinNetUseZeroCopyIO);
            var6.doRPC();
            this.negotiatedTTCversion = this.serverCompileTimeCapabilities[7];
            if (var6.jdbcThinCompileTimeCapabilities[7] < this.serverCompileTimeCapabilities[7]) {
                this.negotiatedTTCversion = var6.jdbcThinCompileTimeCapabilities[7];
            }

            if (this.serverRuntimeCapabilities != null && this.serverRuntimeCapabilities.length > 6 && (this.serverRuntimeCapabilities[6] & T4C8TTIdty.KPCCAP_RTB_TTC_ZCPY) != 0 && this.thinNetUseZeroCopyIO && (this.net.getSessionAttributes().getNegotiatedOptions() & 64) != 0 && this.getDataIntegrityAlgorithmName().equals("") && this.getEncryptionAlgorithmName().equals("")) {
                this.useZeroCopyIO = true;
            } else {
                this.useZeroCopyIO = false;
            }

            if (this.serverCompileTimeCapabilities.length > 23 && bit(this.serverCompileTimeCapabilities[23], 64) && bit(var6.jdbcThinCompileTimeCapabilities[23], 64)) {
                this.useLobPrefetch = true;
            } else {
                this.useLobPrefetch = false;
            }

            if (this.serverRuntimeCapabilities != null && this.serverRuntimeCapabilities.length > T4C8TTIdty.KPCCAP_RTB_TTC && bit(this.serverRuntimeCapabilities[T4C8TTIdty.KPCCAP_RTB_TTC], T4C8TTIdty.KPCCAP_RTB_TTC_32K)) {
                this.maxNonStreamBindByteSize = 32767;
                this.varTypeMaxLenCompat = 2;
            } else {
                this.maxNonStreamBindByteSize = 4000;
                this.varTypeMaxLenCompat = 1;
            }

        }
    }

    boolean isZeroCopyIOEnabled() {
        return this.useZeroCopyIO;
    }

    final T4CTTIoer getT4CTTIoer() {
        return this.oer;
    }

    final byte getTTCVersion() {
        return this.negotiatedTTCversion;
    }

    void doStartup(int var1) throws SQLException {
        try {
            byte var2 = 0;
            if (var1 == DatabaseStartupMode.FORCE.getMode()) {
                var2 = 16;
            } else if (var1 == DatabaseStartupMode.RESTRICT.getMode()) {
                var2 = 1;
            }

            this.spfp.doOSPFPPUT();
            this.sto.doOV6STRT(var2);
        } catch (IOException var4) {
            this.handleIOException(var4);
            SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), var4);
            var3.fillInStackTrace();
            throw var3;
        }
    }

    void doShutdown(int var1) throws SQLException {
        try {
            short var2 = 4;
            if (var1 == DatabaseShutdownMode.TRANSACTIONAL.getMode()) {
                var2 = 128;
            } else if (var1 == DatabaseShutdownMode.TRANSACTIONAL_LOCAL.getMode()) {
                var2 = 256;
            } else if (var1 == DatabaseShutdownMode.IMMEDIATE.getMode()) {
                var2 = 2;
            } else if (var1 == DatabaseShutdownMode.FINAL.getMode()) {
                var2 = 8;
            } else if (var1 == DatabaseShutdownMode.ABORT.getMode()) {
                var2 = 64;
            }

            this.sto.doOV6STOP(var2);
        } catch (IOException var4) {
            this.handleIOException(var4);
            SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), var4);
            var3.fillInStackTrace();
            throw var3;
        }
    }

    void checkEndReplayCallback() throws SQLException {
        if (this.endReplayCallback != null && this.oappcontreplayContextsArr == null) {
            EndReplayCallback var1 = this.endReplayCallback;
            this.endReplayCallback = null;
            T4C8Oall var2 = new T4C8Oall(this);
            T4C8Oall var3 = this.all8;
            this.all8 = var2;

            try {
                var1.executeCallback();
            } finally {
                this.all8 = var3;
            }
        }

    }

    void sendPiggyBackedMessages() throws SQLException, IOException {
        this.checkEndReplayCallback();
        if (this.queryToCloseOffset > 0) {
            this.close8.doOCANA(this.queryToClose, this.queryToCloseOffset);
            this.queryToCloseOffset = 0;
        }

        if (this.cursorToCloseOffset > 0) {
            this.close8.doOCCA(this.cursorToClose, this.cursorToCloseOffset);
            this.cursorToCloseOffset = 0;
        }

        int var1;
        if (this.endToEndAnyChanged && this.getTTCVersion() >= 3) {
            this.oscid.doOSCID(this.endToEndHasChanged, this.endToEndValues, this.endToEndECIDSequenceNumber);

            for(var1 = 0; var1 < 5; ++var1) {
                if (this.endToEndHasChanged[var1]) {
                    this.endToEndHasChanged[var1] = false;
                }
            }
        }

        this.endToEndAnyChanged = false;
        if (!this.namespaces.isEmpty()) {
            if (this.getTTCVersion() >= 4) {
                Object[] var3 = this.namespaces.values().toArray();

                for(int var2 = 0; var2 < var3.length; ++var2) {
                    this.okeyval.doOKEYVAL((Namespace)var3[var2]);
                }
            }

            this.namespaces.clear();
        }

        if (this.lusOffset2 > 0) {
            for(var1 = 0; var1 < this.lusOffset2; ++var1) {
                this.oxsspo.doOXSSPO(this.lusFunctionId2[var1], this.lusSessionId2[var1], this.lusInKeyVal2[var1], this.lusInFlags2[var1]);
            }

            this.lusOffset2 = 0;
        }

        assert !this.replayModes.contains(T4CConnection.ReplayMode.RUNTIME_REPLAY_ENABLED) || !this.replayModes.contains(T4CConnection.ReplayMode.REPLAYING) : "RUNTIME_REPLAY_ENABLED and REPLAYING modes cannot bet set at the same time";

        if (this.replayModes.contains(T4CConnection.ReplayMode.NONREQUEST)) {
            if (this.replayModes.contains(T4CConnection.ReplayMode.RUNTIME_REPLAY_ENABLED)) {
                if (this.ossestateOperations == -1L) {
                    this.ossestateOperations = 0L;
                }

                this.ossestateOperations |= ReplayOperation.KPDSS_SESSSTATE_NONREQUEST_CALL.getCode() | ReplayOperation.KPDSS_SESSSTATE_APPCONT_ENABLED.getCode();
            } else if (this.replayModes.contains(T4CConnection.ReplayMode.REPLAYING)) {
                this.ossestateOperations = ReplayOperation.KPDSS_SESSSTATE_NONREQUEST_CALL.getCode();
            }

            if (this.replayModes.contains(T4CConnection.ReplayMode.RUNTIME_OR_REPLAYING_STATIC)) {
                this.ossestateOperations |= ReplayOperation.KPDSS_SESSSTATE_STATIC.getCode();
            }
        }

        if (this.ossestateOperations >= 0L) {
            this.osesstate.doOSESSSTATE(this.ossestateOperations);
        }

        this.ossestateOperations = -1L;
        if (!this.replayModes.contains(T4CConnection.ReplayMode.NONREQUEST) && this.oappcontreplayContextsArr != null) {
            while(this.oappcontreplayOffset < this.oappcontreplayContextsArr.length - 1 && this.oappcontreplayContextsArr[this.oappcontreplayOffset] == null) {
                ++this.oappcontreplayOffset;
            }

            if (this.oappcontreplayContextsArr[this.oappcontreplayOffset] != null && this.oappcontreplayContextsArr[this.oappcontreplayOffset].getContext() != null) {
                this.oappcontreplay.doOAPPCONTREPLAY(this.oappcontreplayContextsArr[this.oappcontreplayOffset]);
            }

            if (this.oappcontreplayOffset == this.oappcontreplayContextsArr.length - 1) {
                this.oappcontreplayContextsArr = null;
            } else {
                ++this.oappcontreplayOffset;
            }
        }

    }

    synchronized void closeCursor(int var1) throws SQLException {
        if (this.cursorToCloseOffset == this.cursorToClose.length) {
            int[] var2 = new int[this.cursorToClose.length * 2];
            System.arraycopy(this.cursorToClose, 0, var2, 0, this.cursorToClose.length);
            this.cursorToClose = var2;
        }

        this.cursorToClose[this.cursorToCloseOffset++] = var1;
    }

    void doProxySession(int var1, Properties var2) throws SQLException {
        try {
            this.auth.doOAUTH(var1, var2, this.sessionId, this.serialNumber);
            int var3 = this.getSessionId();
            int var6 = this.getSerialNumber();
            this.oses.doO80SES(var3, var6, 1);
            this.savedUser = this.userName;
            if (var1 == 1) {
                this.userName = var2.getProperty("PROXY_USER_NAME");
            } else {
                this.userName = null;
            }

            this.isProxy = true;
        } catch (IOException var5) {
            SQLException var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), var5);
            var4.fillInStackTrace();
            throw var4;
        }
    }

    void closeProxySession() throws SQLException {
        try {
            this.commoncall.doOLOGOFF();
            this.oses.doO80SES(this.sessionId, this.serialNumber, 1);
            this.userName = this.savedUser;
        } catch (IOException var3) {
            SQLException var2 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), var3);
            var2.fillInStackTrace();
            throw var2;
        }
    }

    void updateSessionProperties(KeywordValue[] var1) throws SQLException {
        for(int var2 = 0; var2 < var1.length; ++var2) {
            int var3 = var1[var2].getKeyword();
            byte[] var4 = var1[var2].getBinaryValue();
            String var8;
            if (var3 < T4C8Oall.NLS_KEYS.length) {
                var8 = T4C8Oall.NLS_KEYS[var3];
                if (var8 != null) {
                    if (var4 != null) {
                        this.sessionProperties.setProperty(var8, this.mare.conv.CharBytesToString(var4, var4.length));
                    } else if (var1[var2].getTextValue() != null) {
                        this.sessionProperties.setProperty(var8, var1[var2].getTextValue().trim());
                    }
                }
            } else if (var3 == 163) {
                if (var4 != null) {
                    byte var9 = var4[4];
                    byte var6 = var4[5];
                    int var10;
                    int var11;
                    if ((var4[4] & 255) > 120) {
                        var10 = (var4[4] & 255) - 181;
                        var11 = (var4[5] & 255) - 60;
                    } else {
                        var10 = (var4[4] & 255) - 60;
                        var11 = (var4[5] & 255) - 60;
                    }

                    String var12 = (var10 > 0 ? "+" : "") + var10 + (var11 <= 9 ? ":0" : ":") + var11;
                    this.sessionProperties.setProperty("SESSION_TIME_ZONE", var12);
                }
            } else if (var3 != 165 && var3 != 166 && var3 != 167) {
                if (var3 == 168) {
                    var8 = var1[var2].getTextValue();
                    if (var8 != null) {
                        this.currentSchema = var8.trim();
                    }
                } else if (var3 != 169 && var3 != 170 && var3 != 171 && var3 != 175 && var3 != 176) {
                    if (var3 != 177) {
                        if (var3 != 178 && var3 == 179 && var1[var2].getTextValue() != null) {
                            this.dbName = var1[var2].getTextValue();
                            this.sessionProperties.setProperty("AUTH_DBNAME", this.dbName);
                        }
                    } else {
                        this.isPDBChanged = true;
                        long var5 = 0L;

                        for(int var7 = 3; var7 >= 0; --var7) {
                            var5 |= ((long)var4[3 - var7] & 255L) << 8 * var7;
                        }

                        this.sessionProperties.setProperty("AUTH_DB_ID", String.valueOf(var5));
                        this.onPDBChange();
                    }
                }
            }
        }

    }

    void onPDBChange() throws SQLException {
        super.onPDBChange();
        this.databaseUniqueIdentifier = this.sessionProperties.getProperty("AUTH_DB_ID");
    }

    public void setPDBChangeEventListener(PDBChangeEventListener var1, Executor var2) throws SQLException {
        if (this.lifecycle != 1) {
            SQLException var5 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 8);
            var5.fillInStackTrace();
            throw var5;
        } else {
            NTFEventListener var3 = new NTFEventListener(var1);
            var3.setExecutor(var2);
            if (this.pdbChangeListener == null) {
                this.pdbChangeListener = var3;
            } else {
                SQLException var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 248);
                var4.fillInStackTrace();
                throw var4;
            }
        }
    }

    public void setPDBChangeEventListener(PDBChangeEventListener var1) throws SQLException {
        this.setPDBChangeEventListener(var1, (Executor)null);
    }

    void notify(final NTFPDBChangeEvent var1) {
        if (this.pdbChangeListener != null) {
            Executor var2 = this.pdbChangeListener.getExecutor();
            if (var2 != null) {
                final PDBChangeEventListener var3 = this.pdbChangeListener.getPDBChangeEventListener();
                var2.execute(new Runnable() {
                    public void run() {
                        var3.pdbChanged(var1);
                    }
                });
            } else {
                this.pdbChangeListener.getPDBChangeEventListener().pdbChanged(var1);
            }
        }

    }

    public String getCurrentSchema() throws SQLException {
        if (this.lifecycle != 1) {
            SQLException var1 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 8);
            var1.fillInStackTrace();
            throw var1;
        } else {
            if (this.currentSchema == null || this.getVersionNumber() < 11100) {
                this.currentSchema = super.getCurrentSchema();
            }

            return this.currentSchema;
        }
    }

    public Properties getServerSessionInfo() throws SQLException {
        if (this.getVersionNumber() >= 10000 && this.getVersionNumber() < 10200) {
            this.queryFCFProperties(this.sessionProperties);
        }

        return this.sessionProperties;
    }

    public String getSessionTimeZoneOffset() throws SQLException {
        String var1 = this.getServerSessionInfo().getProperty("SESSION_TIME_ZONE");
        if (var1 == null) {
            var1 = super.getSessionTimeZoneOffset();
        } else {
            var1 = this.tzToOffset(var1);
        }

        return var1;
    }

    int getSessionId() {
        int var1 = -1;
        String var2 = this.sessionProperties.getProperty("AUTH_SESSION_ID");

        try {
            var1 = Integer.parseInt(var2);
        } catch (NumberFormatException var4) {
        }

        return var1;
    }

    int getSerialNumber() {
        int var1 = -1;
        String var2 = this.sessionProperties.getProperty("AUTH_SERIAL_NUM");

        try {
            var1 = Integer.parseInt(var2);
        } catch (NumberFormatException var4) {
        }

        return var1;
    }

    public byte getInstanceProperty(InstanceProperty var1) throws SQLException {
        byte var2 = 0;
        SQLException var3;
        if (var1 == InstanceProperty.ASM_VOLUME_SUPPORTED) {
            if (this.serverRuntimeCapabilities == null || this.serverRuntimeCapabilities.length < 6) {
                var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 256);
                var3.fillInStackTrace();
                throw var3;
            }

            var2 = this.serverRuntimeCapabilities[5];
        } else if (var1 == InstanceProperty.INSTANCE_TYPE) {
            if (this.serverRuntimeCapabilities == null || this.serverRuntimeCapabilities.length < 4) {
                var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 256);
                var3.fillInStackTrace();
                throw var3;
            }

            var2 = this.serverRuntimeCapabilities[3];
        }

        return var2;
    }

    public synchronized BlobDBAccess createBlobDBAccess() throws SQLException {
        return this;
    }

    public synchronized ClobDBAccess createClobDBAccess() throws SQLException {
        return this;
    }

    public synchronized BfileDBAccess createBfileDBAccess() throws SQLException {
        return this;
    }

    public synchronized long length(BFILE var1) throws SQLException {
        this.assertLoggedOn("length");
        this.assertNotNull(var1.shareBytes(), "length");
        this.needLine();
        long var2 = 0L;

        try {
            var2 = this.bfileMsg.getLength(var1.shareBytes());
            return var2;
        } catch (IOException var6) {
            this.handleIOException(var6);
            SQLException var5 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), var6);
            var5.fillInStackTrace();
            throw var5;
        }
    }

    public synchronized long position(BFILE var1, byte[] var2, long var3) throws SQLException {
        this.assertNotNull(var1.shareBytes(), "position");
        if (var3 < 1L) {
            SQLException var7 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 68, "position()");
            var7.fillInStackTrace();
            throw var7;
        } else {
            long var5 = LobPlsqlUtil.hasPattern(var1, var2, var3);
            var5 = var5 == 0L ? -1L : var5;
            return var5;
        }
    }

    public long position(BFILE var1, BFILE var2, long var3) throws SQLException {
        this.assertNotNull(var1.shareBytes(), "position");
        if (var3 < 1L) {
            SQLException var7 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 68, "position()");
            var7.fillInStackTrace();
            throw var7;
        } else {
            long var5 = LobPlsqlUtil.isSubLob(var1, var2, var3);
            var5 = var5 == 0L ? -1L : var5;
            return var5;
        }
    }

    public synchronized int getBytes(BFILE var1, long var2, int var4, byte[] var5) throws SQLException {
        this.assertLoggedOn("getBytes");
        this.assertNotNull(var1.shareBytes(), "getBytes");
        SQLException var11;
        if (var2 < 1L) {
            var11 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 68, "getBytes()");
            var11.fillInStackTrace();
            throw var11;
        } else if (var4 > 0 && var5 != null) {
            if (this.pipeState != -1) {
                var11 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 453, "getBytes()");
                var11.fillInStackTrace();
                throw var11;
            } else {
                this.needLine();
                long var6 = 0L;
                if (var4 != 0) {
                    try {
                        var6 = this.bfileMsg.read(var1.shareBytes(), var2, (long)var4, var5, 0);
                    } catch (IOException var10) {
                        this.handleIOException(var10);
                        SQLException var9 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), var10);
                        var9.fillInStackTrace();
                        throw var9;
                    }
                }

                return (int)var6;
            }
        } else {
            return 0;
        }
    }

    public String getName(BFILE var1) throws SQLException {
        this.assertLoggedOn("getName");
        this.assertNotNull(var1.shareBytes(), "getName");
        String var2 = LobPlsqlUtil.fileGetName(var1);
        return var2;
    }

    public String getDirAlias(BFILE var1) throws SQLException {
        this.assertLoggedOn("getDirAlias");
        this.assertNotNull(var1.shareBytes(), "getDirAlias");
        String var2 = LobPlsqlUtil.fileGetDirAlias(var1);
        return var2;
    }

    public synchronized void openFile(BFILE var1) throws SQLException {
        this.assertLoggedOn("openFile");
        this.assertNotNull(var1.shareBytes(), "openFile");
        this.needLine();

        try {
            this.bfileMsg.open(var1.shareBytes(), 11);
        } catch (IOException var4) {
            this.handleIOException(var4);
            SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), var4);
            var3.fillInStackTrace();
            throw var3;
        }
    }

    public synchronized boolean isFileOpen(BFILE var1) throws SQLException {
        this.assertLoggedOn("openFile");
        this.assertNotNull(var1.shareBytes(), "openFile");
        this.needLine();
        boolean var2 = false;

        try {
            var2 = this.bfileMsg.isOpen(var1.shareBytes());
            return var2;
        } catch (IOException var5) {
            this.handleIOException(var5);
            SQLException var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), var5);
            var4.fillInStackTrace();
            throw var4;
        }
    }

    public synchronized boolean fileExists(BFILE var1) throws SQLException {
        this.assertLoggedOn("fileExists");
        this.assertNotNull(var1.shareBytes(), "fileExists");
        this.needLine();
        boolean var2 = false;

        try {
            var2 = this.bfileMsg.doesExist(var1.shareBytes());
            return var2;
        } catch (IOException var5) {
            this.handleIOException(var5);
            SQLException var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), var5);
            var4.fillInStackTrace();
            throw var4;
        }
    }

    public synchronized void closeFile(BFILE var1) throws SQLException {
        this.assertLoggedOn("closeFile");
        this.assertNotNull(var1.shareBytes(), "closeFile");
        this.needLine();

        try {
            this.bfileMsg.close(var1.shareBytes());
        } catch (IOException var4) {
            this.handleIOException(var4);
            SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), var4);
            var3.fillInStackTrace();
            throw var3;
        }
    }

    public synchronized void open(BFILE var1, int var2) throws SQLException {
        this.assertLoggedOn("open");
        this.assertNotNull(var1.shareBytes(), "open");
        this.needLine();

        try {
            this.bfileMsg.open(var1.shareBytes(), var2);
        } catch (IOException var5) {
            this.handleIOException(var5);
            SQLException var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), var5);
            var4.fillInStackTrace();
            throw var4;
        }
    }

    public synchronized void close(BFILE var1) throws SQLException {
        this.assertLoggedOn("close");
        this.assertNotNull(var1.shareBytes(), "close");
        this.needLine();

        try {
            this.bfileMsg.close(var1.shareBytes());
        } catch (IOException var4) {
            this.handleIOException(var4);
            SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), var4);
            var3.fillInStackTrace();
            throw var3;
        }
    }

    public synchronized boolean isOpen(BFILE var1) throws SQLException {
        this.assertLoggedOn("isOpen");
        this.assertNotNull(var1.shareBytes(), "isOpen");
        this.needLine();
        boolean var2 = false;

        try {
            var2 = this.bfileMsg.isOpen(var1.shareBytes());
            return var2;
        } catch (IOException var5) {
            this.handleIOException(var5);
            SQLException var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), var5);
            var4.fillInStackTrace();
            throw var4;
        }
    }

    public InputStream newInputStream(BFILE var1, int var2, long var3) throws SQLException {
        return this.newInputStream((OracleBfile)var1, var2, var3);
    }

    public InputStream newInputStream(OracleBfile var1, int var2, long var3) throws SQLException {
        return var3 == 0L ? new OracleBlobInputStream(var1, var2) : new OracleBlobInputStream(var1, var2, var3);
    }

    public InputStream newConversionInputStream(BFILE var1, int var2) throws SQLException {
        return this.newConversionInputStream((OracleBfile)var1, var2);
    }

    public InputStream newConversionInputStream(OracleBfile var1, int var2) throws SQLException {
        this.assertNotNull(var1.shareBytes(), "newConversionInputStream");
        OracleConversionInputStream var3 = new OracleConversionInputStream(this.conversion, var1.getBinaryStream(), var2);
        return var3;
    }

    public Reader newConversionReader(BFILE var1, int var2) throws SQLException {
        return this.newConversionReader((OracleBfile)var1, var2);
    }

    public Reader newConversionReader(OracleBfile var1, int var2) throws SQLException {
        this.assertNotNull(var1.shareBytes(), "newConversionReader");
        OracleConversionReader var3 = new OracleConversionReader(this.conversion, var1.getBinaryStream(), var2);
        return var3;
    }

    public synchronized long length(BLOB var1) throws SQLException {
        this.assertLoggedOn("length");
        this.assertNotNull(var1.shareBytes(), "length");
        this.needLine();
        long var2 = 0L;

        try {
            var2 = this.blobMsg.getLength(var1.shareBytes());
            return var2;
        } catch (IOException var6) {
            this.handleIOException(var6);
            SQLException var5 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), var6);
            var5.fillInStackTrace();
            throw var5;
        }
    }

    public long position(BLOB var1, byte[] var2, long var3) throws SQLException {
        this.assertLoggedOn("position");
        this.assertNotNull(var1.shareBytes(), "position");
        if (var3 < 1L) {
            SQLException var7 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 68, "position()");
            var7.fillInStackTrace();
            throw var7;
        } else {
            long var5 = LobPlsqlUtil.hasPattern(var1, var2, var3);
            var5 = var5 == 0L ? -1L : var5;
            return var5;
        }
    }

    public long position(BLOB var1, BLOB var2, long var3) throws SQLException {
        this.assertLoggedOn("position");
        this.assertNotNull(var1.shareBytes(), "position");
        this.assertNotNull(var2.shareBytes(), "position");
        if (var3 < 1L) {
            SQLException var7 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 68, "position()");
            var7.fillInStackTrace();
            throw var7;
        } else {
            long var5 = LobPlsqlUtil.isSubLob(var1, var2, var3);
            var5 = var5 == 0L ? -1L : var5;
            return var5;
        }
    }

    public synchronized int getBytes(BLOB var1, long var2, int var4, byte[] var5) throws SQLException {
        this.assertLoggedOn("getBytes");
        this.assertNotNull(var1.shareBytes(), "getBytes");
        SQLException var15;
        if (var2 < 1L) {
            var15 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 68, "getBytes()");
            var15.fillInStackTrace();
            throw var15;
        } else if (this.pipeState != -1) {
            var15 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 453, "getBytes()");
            var15.fillInStackTrace();
            throw var15;
        } else if (var4 > 0 && var5 != null) {
            long var6 = 0L;
            long var8 = -1L;
            if (var1.isActivePrefetch()) {
                byte[] var10 = var1.getPrefetchedData();
                int var11 = var1.getPrefetchedDataSize();
                var8 = var1.length();
                int var12 = 0;
                if (var10 != null) {
                    var12 = Math.min(var11, var10.length);
                }

                if (var12 > 0 && var2 <= (long)var12) {
                    int var13 = Math.min(var12 - (int)var2 + 1, var4);
                    System.arraycopy(var10, (int)var2 - 1, var5, 0, var13);
                    var6 += (long)var13;
                }
            }

            if (var6 < (long)var4 && (var8 == -1L || var2 - 1L + var6 < var8)) {
                this.needLine();

                try {
                    var6 += this.blobMsg.read(var1.shareBytes(), var2 + var6, (long)var4 - var6, var5, (int)var6);
                } catch (IOException var14) {
                    this.handleIOException(var14);
                    SQLException var16 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), var14);
                    var16.fillInStackTrace();
                    throw var16;
                }
            }

            return (int)var6;
        } else {
            return 0;
        }
    }

    public synchronized int putBytes(BLOB var1, long var2, byte[] var4, int var5, int var6) throws SQLException {
        this.assertLoggedOn("putBytes");
        this.assertNotNull(var1.shareBytes(), "putBytes");
        if (var2 < 1L) {
            SQLException var12 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 68, "putBytes()");
            var12.fillInStackTrace();
            throw var12;
        } else if (var4 != null && var6 > 0) {
            this.needLine();
            long var7 = 0L;
            if (var6 != 0) {
                try {
                    var1.setActivePrefetch(false);
                    var1.clearCachedData();
                    var7 = this.blobMsg.write(var1.shareBytes(), var2, var4, (long)var5, (long)var6);
                } catch (IOException var11) {
                    this.handleIOException(var11);
                    SQLException var10 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), var11);
                    var10.fillInStackTrace();
                    throw var10;
                }
            }

            return (int)var7;
        } else {
            return 0;
        }
    }

    public synchronized int getChunkSize(BLOB var1) throws SQLException {
        this.assertLoggedOn("getChunkSize");
        this.assertNotNull(var1.shareBytes(), "getChunkSize");
        this.needLine();
        long var2 = 0L;

        try {
            var2 = this.blobMsg.getChunkSize(var1.shareBytes());
        } catch (IOException var6) {
            this.handleIOException(var6);
            SQLException var5 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), var6);
            var5.fillInStackTrace();
            throw var5;
        }

        return (int)var2;
    }

    public synchronized void trim(BLOB var1, long var2) throws SQLException {
        this.assertLoggedOn("trim");
        this.assertNotNull(var1.shareBytes(), "trim");
        if (var2 < 0L) {
            SQLException var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 68, "trim()");
            var4.fillInStackTrace();
            throw var4;
        } else {
            this.needLine();

            try {
                var1.setActivePrefetch(false);
                var1.clearCachedData();
                this.blobMsg.trim(var1.shareBytes(), var2);
            } catch (IOException var6) {
                this.handleIOException(var6);
                SQLException var5 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), var6);
                var5.fillInStackTrace();
                throw var5;
            }
        }
    }

    public synchronized BLOB createTemporaryBlob(Connection var1, boolean var2, int var3) throws SQLException {
        this.assertLoggedOn("createTemporaryBlob");
        this.needLine();
        BLOB var4 = null;

        try {
            var4 = (BLOB)this.blobMsg.createTemporaryLob(this, var2, var3);
            return var4;
        } catch (IOException var7) {
            this.handleIOException(var7);
            SQLException var6 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), var7);
            var6.fillInStackTrace();
            throw var6;
        }
    }

    private final synchronized Long getLocatorHash(byte[] var1) {
        this.checksumEngine.reset();
        this.checksumEngine.update(var1, 10, 10);
        long var2 = this.checksumEngine.getValue();
        Long var4 = var2;
        return var4;
    }

    public final synchronized int decrementTempLobReferenceCount(byte[] var1) {
        int var2 = 0;
        if (this.enableTempLobRefCnt && var1 != null && var1.length == 40 && ((var1[7] & 1) > 0 || (var1[4] & 64) > 0)) {
            Long var3 = this.getLocatorHash(var1);
            Integer var4 = (Integer)this.tempLobRefCount.get(var3);
            if (var4 != null) {
                var2 = var4 - 1;
                if (var2 == 0) {
                    this.tempLobRefCount.remove(var3);
                } else {
                    this.tempLobRefCount.put(var3, var2);
                }
            }
        }

        return var2;
    }

    public final synchronized void incrementTempLobReferenceCount(byte[] var1) {
        if (this.enableTempLobRefCnt && var1 != null && var1.length == 40 && ((var1[7] & 1) > 0 || (var1[4] & 64) > 0)) {
            Long var2 = this.getLocatorHash(var1);
            Integer var3 = (Integer)this.tempLobRefCount.get(var2);
            if (var3 != null) {
                int var4 = var3;
                this.tempLobRefCount.put(var2, var4 + 1);
            } else {
                this.tempLobRefCount.put(var2, 1);
            }
        }

    }

    public synchronized void freeTemporary(BLOB var1, boolean var2) throws SQLException {
        this.assertLoggedOn("freeTemporary");
        this.assertNotNull(var1.shareBytes(), "freeTemporary");
        this.needLine();

        try {
            this.blobMsg.freeTemporaryLob(var1.shareBytes());
        } catch (IOException var5) {
            this.handleIOException(var5);
            SQLException var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), var5);
            var4.fillInStackTrace();
            throw var4;
        }
    }

    public boolean isTemporary(BLOB var1) throws SQLException {
        this.assertNotNull(var1.shareBytes(), "isTemporary");
        boolean var2 = false;
        byte[] var3 = var1.shareBytes();
        if ((var3[7] & 1) > 0 || (var3[4] & 64) > 0) {
            var2 = true;
        }

        return var2;
    }

    public synchronized void open(BLOB var1, int var2) throws SQLException {
        this.assertLoggedOn("open");
        this.assertNotNull(var1.shareBytes(), "open");
        this.needLine();

        try {
            this.blobMsg.open(var1.shareBytes(), var2);
        } catch (IOException var5) {
            this.handleIOException(var5);
            SQLException var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), var5);
            var4.fillInStackTrace();
            throw var4;
        }
    }

    public synchronized void close(BLOB var1) throws SQLException {
        this.assertLoggedOn("close");
        this.assertNotNull(var1.shareBytes(), "close");
        this.needLine();

        try {
            this.blobMsg.close(var1.shareBytes());
        } catch (IOException var4) {
            this.handleIOException(var4);
            SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), var4);
            var3.fillInStackTrace();
            throw var3;
        }
    }

    public synchronized boolean isOpen(BLOB var1) throws SQLException {
        this.assertLoggedOn("isOpen");
        this.assertNotNull(var1.shareBytes(), "isOpen");
        this.needLine();
        boolean var2 = false;

        try {
            var2 = this.blobMsg.isOpen(var1.shareBytes());
            return var2;
        } catch (IOException var5) {
            this.handleIOException(var5);
            SQLException var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), var5);
            var4.fillInStackTrace();
            throw var4;
        }
    }

    public InputStream newInputStream(BLOB var1, int var2, long var3) throws SQLException {
        return this.newInputStream((OracleBlob)var1, var2, var3);
    }

    public InputStream newInputStream(OracleBlob var1, int var2, long var3) throws SQLException {
        return var3 == 0L ? new OracleBlobInputStream(var1, var2) : new OracleBlobInputStream(var1, var2, var3);
    }

    public InputStream newInputStream(BLOB var1, int var2, long var3, long var5) throws SQLException {
        return this.newInputStream((OracleBlob)var1, var2, var3, var5);
    }

    public InputStream newInputStream(OracleBlob var1, int var2, long var3, long var5) throws SQLException {
        return new OracleBlobInputStream(var1, var2, var3, var5);
    }

    public OutputStream newOutputStream(BLOB var1, int var2, long var3, boolean var5) throws SQLException {
        return this.newOutputStream((OracleBlob)var1, var2, var3, var5);
    }

    public OutputStream newOutputStream(OracleBlob var1, int var2, long var3, boolean var5) throws SQLException {
        if (var3 == 0L) {
            if (var5 & this.lobStreamPosStandardCompliant) {
                SQLException var6 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 68);
                var6.fillInStackTrace();
                throw var6;
            } else {
                return new OracleBlobOutputStream(var1, var2);
            }
        } else {
            return new OracleBlobOutputStream(var1, var2, var3);
        }
    }

    public InputStream newConversionInputStream(BLOB var1, int var2) throws SQLException {
        return this.newConversionInputStream((OracleBlob)var1, var2);
    }

    public InputStream newConversionInputStream(OracleBlob var1, int var2) throws SQLException {
        this.assertNotNull(var1.shareBytes(), "newConversionInputStream");
        OracleConversionInputStream var3 = new OracleConversionInputStream(this.conversion, var1.getBinaryStream(), var2);
        return var3;
    }

    public Reader newConversionReader(BLOB var1, int var2) throws SQLException {
        return this.newConversionReader((OracleBlob)var1, var2);
    }

    public Reader newConversionReader(OracleBlob var1, int var2) throws SQLException {
        this.assertNotNull(var1.shareBytes(), "newConversionReader");
        OracleConversionReader var3 = new OracleConversionReader(this.conversion, var1.getBinaryStream(), var2);
        return var3;
    }

    public synchronized long length(CLOB var1) throws SQLException {
        this.assertLoggedOn("length");
        this.assertNotNull(var1.shareBytes(), "length");
        this.needLine();
        long var2 = 0L;

        try {
            var2 = this.clobMsg.getLength(var1.shareBytes());
            return var2;
        } catch (IOException var6) {
            this.handleIOException(var6);
            SQLException var5 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), var6);
            var5.fillInStackTrace();
            throw var5;
        }
    }

    public long position(CLOB var1, String var2, long var3) throws SQLException {
        SQLException var8;
        if (var2 == null) {
            var8 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 68, "position()");
            var8.fillInStackTrace();
            throw var8;
        } else {
            this.assertLoggedOn("position");
            this.assertNotNull(var1.shareBytes(), "position");
            if (var3 < 1L) {
                var8 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 68, "position()");
                var8.fillInStackTrace();
                throw var8;
            } else {
                char[] var5 = new char[var2.length()];
                var2.getChars(0, var5.length, var5, 0);
                long var6 = LobPlsqlUtil.hasPattern(var1, var5, var3);
                var6 = var6 == 0L ? -1L : var6;
                return var6;
            }
        }
    }

    public long position(CLOB var1, CLOB var2, long var3) throws SQLException {
        SQLException var7;
        if (var2 == null) {
            var7 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 68, "position()");
            var7.fillInStackTrace();
            throw var7;
        } else {
            this.assertLoggedOn("position");
            this.assertNotNull(var1.shareBytes(), "position");
            this.assertNotNull(var2.shareBytes(), "position");
            if (var3 < 1L) {
                var7 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 68, "position()");
                var7.fillInStackTrace();
                throw var7;
            } else {
                long var5 = LobPlsqlUtil.isSubLob(var1, var2, var3);
                var5 = var5 == 0L ? -1L : var5;
                return var5;
            }
        }
    }

    public synchronized int getChars(CLOB var1, long var2, int var4, char[] var5) throws SQLException {
        this.assertLoggedOn("getChars");
        this.assertNotNull(var1.shareBytes(), "getChars");
        SQLException var15;
        if (var2 < 1L) {
            var15 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 68, "getChars()");
            var15.fillInStackTrace();
            throw var15;
        } else if (this.pipeState != -1) {
            var15 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 453, "getChars()");
            var15.fillInStackTrace();
            throw var15;
        } else if (var4 > 0 && var5 != null) {
            long var6 = 0L;
            long var8 = -1L;
            if (var1.isActivePrefetch()) {
                var8 = var1.length();
                char[] var10 = var1.getPrefetchedData();
                int var11 = var1.getPrefetchedDataSize();
                int var12 = 0;
                if (var10 != null) {
                    var12 = Math.min(var11, var10.length);
                }

                if (var12 > 0 && var2 <= (long)var12) {
                    int var13 = Math.min(var12 - (int)var2 + 1, var4);
                    System.arraycopy(var10, (int)var2 - 1, var5, 0, var13);
                    var6 += (long)var13;
                }
            }

            if (var6 < (long)var4 && (var8 == -1L || var2 - 1L + var6 < var8)) {
                this.needLine();

                try {
                    boolean var16 = var1.isNCLOB();
                    var6 += this.clobMsg.read(var1.shareBytes(), var2 + var6, (long)var4 - var6, var16, var5, (int)var6);
                } catch (IOException var14) {
                    this.handleIOException(var14);
                    SQLException var17 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), var14);
                    var17.fillInStackTrace();
                    throw var17;
                }
            }

            return (int)var6;
        } else {
            return 0;
        }
    }

    public synchronized int putChars(CLOB var1, long var2, char[] var4, int var5, int var6) throws SQLException {
        this.assertLoggedOn("putChars");
        this.assertNotNull(var1.shareBytes(), "putChars");
        if (var2 < 1L) {
            SQLException var12 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 68, "putChars()");
            var12.fillInStackTrace();
            throw var12;
        } else if (var4 != null && var6 > 0) {
            this.needLine();
            long var7 = 0L;
            if (var6 != 0) {
                try {
                    boolean var9 = var1.isNCLOB();
                    var1.setActivePrefetch(false);
                    var1.clearCachedData();
                    var7 = this.clobMsg.write(var1.shareBytes(), var2, var9, var4, (long)var5, (long)var6);
                } catch (IOException var11) {
                    this.handleIOException(var11);
                    SQLException var10 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), var11);
                    var10.fillInStackTrace();
                    throw var10;
                }
            }

            return (int)var7;
        } else {
            return 0;
        }
    }

    public synchronized int getChunkSize(CLOB var1) throws SQLException {
        this.assertLoggedOn("getChunkSize");
        this.assertNotNull(var1.shareBytes(), "getChunkSize");
        this.needLine();
        long var2 = 0L;

        try {
            var2 = this.clobMsg.getChunkSize(var1.shareBytes());
        } catch (IOException var6) {
            this.handleIOException(var6);
            SQLException var5 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), var6);
            var5.fillInStackTrace();
            throw var5;
        }

        return (int)var2;
    }

    public synchronized void trim(CLOB var1, long var2) throws SQLException {
        this.assertLoggedOn("trim");
        this.assertNotNull(var1.shareBytes(), "trim");
        if (var2 < 0L) {
            SQLException var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 68, "trim()");
            var4.fillInStackTrace();
            throw var4;
        } else {
            this.needLine();

            try {
                var1.setActivePrefetch(false);
                var1.clearCachedData();
                this.clobMsg.trim(var1.shareBytes(), var2);
            } catch (IOException var6) {
                this.handleIOException(var6);
                SQLException var5 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), var6);
                var5.fillInStackTrace();
                throw var5;
            }
        }
    }

    public synchronized CLOB createTemporaryClob(Connection var1, boolean var2, int var3, short var4) throws SQLException {
        this.assertLoggedOn("createTemporaryClob");
        if (var4 != 2 && var4 != 1) {
            SQLException var9 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 184);
            var9.fillInStackTrace();
            throw var9;
        } else {
            this.needLine();
            CLOB var5 = null;

            try {
                var5 = (CLOB)this.clobMsg.createTemporaryLob(this, var2, var3, var4);
                return var5;
            } catch (IOException var8) {
                this.handleIOException(var8);
                SQLException var7 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), var8);
                var7.fillInStackTrace();
                throw var7;
            }
        }
    }

    public synchronized void freeTemporary(CLOB var1, boolean var2) throws SQLException {
        this.assertLoggedOn("freeTemporary");
        this.assertNotNull(var1.shareBytes(), "freeTemporary");
        this.needLine();

        try {
            this.clobMsg.freeTemporaryLob(var1.shareBytes());
        } catch (IOException var5) {
            this.handleIOException(var5);
            SQLException var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), var5);
            var4.fillInStackTrace();
            throw var4;
        }
    }

    public boolean isTemporary(CLOB var1) throws SQLException {
        boolean var2 = false;
        byte[] var3 = var1.shareBytes();
        if ((var3[7] & 1) > 0 || (var3[4] & 64) > 0) {
            var2 = true;
        }

        return var2;
    }

    public synchronized void open(CLOB var1, int var2) throws SQLException {
        this.assertLoggedOn("open");
        this.assertNotNull(var1.shareBytes(), "open");
        this.needLine();

        try {
            this.clobMsg.open(var1.shareBytes(), var2);
        } catch (IOException var5) {
            this.handleIOException(var5);
            SQLException var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), var5);
            var4.fillInStackTrace();
            throw var4;
        }
    }

    public synchronized void close(CLOB var1) throws SQLException {
        this.assertLoggedOn("close");
        this.assertNotNull(var1.shareBytes(), "close");
        this.needLine();

        try {
            this.clobMsg.close(var1.shareBytes());
        } catch (IOException var4) {
            this.handleIOException(var4);
            SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), var4);
            var3.fillInStackTrace();
            throw var3;
        }
    }

    public synchronized boolean isOpen(CLOB var1) throws SQLException {
        this.assertLoggedOn("isOpen");
        this.assertNotNull(var1.shareBytes(), "isOpen");
        boolean var2 = false;
        this.needLine();

        try {
            var2 = this.clobMsg.isOpen(var1.shareBytes());
            return var2;
        } catch (IOException var5) {
            this.handleIOException(var5);
            SQLException var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), var5);
            var4.fillInStackTrace();
            throw var4;
        }
    }

    public InputStream newInputStream(CLOB var1, int var2, long var3) throws SQLException {
        return this.newInputStream((OracleClob)var1, var2, var3);
    }

    public InputStream newInputStream(OracleClob var1, int var2, long var3) throws SQLException {
        return var3 == 0L ? new OracleClobInputStream(var1, var2) : new OracleClobInputStream(var1, var2, var3);
    }

    public OutputStream newOutputStream(CLOB var1, int var2, long var3, boolean var5) throws SQLException {
        return this.newOutputStream((OracleClob)var1, var2, var3, var5);
    }

    public OutputStream newOutputStream(OracleClob var1, int var2, long var3, boolean var5) throws SQLException {
        if (var3 == 0L) {
            if (var5 & this.lobStreamPosStandardCompliant) {
                SQLException var6 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 68);
                var6.fillInStackTrace();
                throw var6;
            } else {
                return new OracleClobOutputStream(var1, var2);
            }
        } else {
            return new OracleClobOutputStream(var1, var2, var3);
        }
    }

    public Reader newReader(CLOB var1, int var2, long var3) throws SQLException {
        return this.newReader((OracleClob)var1, var2, var3);
    }

    public Reader newReader(OracleClob var1, int var2, long var3) throws SQLException {
        return var3 == 0L ? new OracleClobReader(var1, var2) : new OracleClobReader(var1, var2, var3);
    }

    public Reader newReader(CLOB var1, int var2, long var3, long var5) throws SQLException {
        return this.newReader((OracleClob)var1, var2, var3, var5);
    }

    public Reader newReader(OracleClob var1, int var2, long var3, long var5) throws SQLException {
        return new OracleClobReader(var1, var2, var3, var5);
    }

    public Writer newWriter(CLOB var1, int var2, long var3, boolean var5) throws SQLException {
        return this.newWriter((OracleClob)var1, var2, var3, var5);
    }

    public Writer newWriter(OracleClob var1, int var2, long var3, boolean var5) throws SQLException {
        if (var3 == 0L) {
            if (var5 & this.lobStreamPosStandardCompliant) {
                SQLException var6 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 68);
                var6.fillInStackTrace();
                throw var6;
            } else {
                return new OracleClobWriter(var1, var2);
            }
        } else {
            return new OracleClobWriter(var1, var2, var3);
        }
    }

    void assertLoggedOn(String var1) throws SQLException {
        if (!this.isLoggedOn) {
            SQLException var2 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 430);
            var2.fillInStackTrace();
            throw var2;
        }
    }

    boolean isLoggedOn() {
        return this.isLoggedOn;
    }

    void assertNotNull(byte[] var1, String var2) throws NullPointerException {
        if (var1 == null) {
            throw new NullPointerException("bytes are null");
        }
    }

    void internalClose() throws SQLException {
        super.internalClose();
        if (this.all8 != null) {
            this.all8.definesAccessors = null;
        }

        this.isLoggedOn = false;

        try {
            if (this.net != null) {
                this.net.disconnect();
            }
        } catch (Exception var2) {
        }

    }

    void doAbort() throws SQLException {
        SQLException var2;
        try {
            this.net.abort();
        } catch (NetException var3) {
            var2 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), var3);
            var2.fillInStackTrace();
            throw var2;
        } catch (IOException var4) {
            this.handleIOException(var4);
            var2 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), var4);
            var2.fillInStackTrace();
            throw var2;
        }
    }

    protected void doDescribeTable(AutoKeyInfo var1) throws SQLException {
        T4CStatement var2 = new T4CStatement(this, -1, -1);
        var2.open();
        String var3 = var1.getTableName();
        String var4 = "SELECT * FROM " + var3;
        var2.sqlObject.initialize(var4);
        Accessor[] var5 = null;

        try {
            this.describe.doODNY(var2, 0, var5, var2.sqlObject.getSqlBytes(false, false));
            var5 = this.describe.getAccessors();
        } catch (IOException var17) {
            this.handleIOException(var17);
            SQLException var7 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), var17);
            var7.fillInStackTrace();
            throw var7;
        }

        int var6 = this.describe.numuds;
        var1.allocateSpaceForDescribedData(var6);

        for(int var15 = 0; var15 < var6; ++var15) {
            Accessor var16 = var5[var15];
            String var18 = var16.columnName;
            int var8 = var16.describeType;
            int var9 = var16.describeMaxLength;
            boolean var10 = var16.nullable;
            short var11 = var16.formOfUse;
            int var12 = var16.precision;
            int var13 = var16.scale;
            String var14 = var16.describeTypeName;
            var1.fillDescribedData(var15, var18, var8, var9, var10, var11, var12, var13, var14);
        }

        var2.close();
    }

    void doSetApplicationContext(String var1, String var2, String var3) throws SQLException {
        Namespace var4 = (Namespace)this.namespaces.get(var1);
        if (var4 == null) {
            var4 = new Namespace(var1);
            this.namespaces.put(var1, var4);
        }

        var4.setAttribute(var2, var3);
    }

    void doClearAllApplicationContext(String var1) throws SQLException {
        Namespace var2 = new Namespace(var1);
        var2.clear();
        this.namespaces.put(var1, var2);
    }

    public void getPropertyForPooledConnection(OraclePooledConnection var1) throws SQLException {
        super.getPropertyForPooledConnection(var1, this.password);
    }

    final void getPasswordInternal(T4CXAResource var1) throws SQLException {
        var1.setPasswordInternal(this.password);
    }

    synchronized void doEnqueue(String var1, AQEnqueueOptions var2, AQMessagePropertiesI var3, byte[] var4, byte[] var5, byte[][] var6, boolean var7) throws SQLException {
        try {
            this.needLine();
            this.aqe.doOAQEQ(var1, var2, var3, var5, var4, var7);
            if (var2.getRetrieveMessageId()) {
                var6[0] = this.aqe.getMessageId();
            }

        } catch (IOException var10) {
            this.handleIOException(var10);
            SQLException var9 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), var10);
            var9.fillInStackTrace();
            throw var9;
        }
    }

    synchronized boolean doDequeue(String var1, AQDequeueOptions var2, AQMessagePropertiesI var3, byte[] var4, byte[][] var5, byte[][] var6, boolean var7) throws SQLException {
        boolean var8 = false;

        try {
            this.needLine();
            this.aqdq.doOAQDQ(var1, var2, var4, var7, var3);
            var5[0] = this.aqdq.getPayload();
            var6[0] = this.aqdq.getDequeuedMessageId();
            var8 = this.aqdq.hasAMessageBeenDequeued();
            return var8;
        } catch (IOException var11) {
            this.handleIOException(var11);
            SQLException var10 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), var11);
            var10.fillInStackTrace();
            throw var10;
        }
    }

    synchronized void doJMSEnqueue(String var1, JMSEnqueueOptions var2, AQMessagePropertiesI var3, JMSMessageProperties var4, byte[] var5, byte[] var6, byte[][] var7) throws SQLException {
        try {
            this.needLine();
            this.oaqenq.doJMSEnq(var1, var2, var3, var4, var5, var6);
            if (var2.isRetrieveMessageId()) {
                var7[0] = this.oaqenq.getMsgId();
            }

        } catch (IOException var10) {
            this.handleIOException(var10);
            SQLException var9 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), var10);
            var9.fillInStackTrace();
            throw var9;
        }
    }

    synchronized boolean doJmsDequeue(String var1, JMSDequeueOptions var2, AQMessagePropertiesI var3, JMSMessagePropertiesI var4, byte[] var5, byte[][] var6, byte[][] var7) throws SQLException {
        boolean var8 = false;

        try {
            this.needLine();
            this.oaqdeq.doJMSDeq(var1, var2, var5, var3, var4);
            var6[0] = this.oaqdeq.getPayload();
            var7[0] = this.oaqdeq.getDequeuedMessageId();
            var8 = this.oaqdeq.isHasAMessageBeenDequeued();
            return var8;
        } catch (IOException var11) {
            this.handleIOException(var11);
            SQLException var10 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), var11);
            var10.fillInStackTrace();
            throw var10;
        }
    }

    synchronized int doPingDatabase() throws SQLException {
        if (this.versionNumber >= 10102) {
            try {
                this.needLine();
                this.oping.doOPING();
                return 0;
            } catch (IOException var2) {
                return -1;
            } catch (SQLException var3) {
                return -1;
            }
        } else {
            return super.doPingDatabase();
        }
    }

    synchronized Map<String, JMSNotificationRegistration> doRegisterJMSNotification(String[] var1, Map<String, Properties> var2) throws SQLException {
        assert this.databaseUniqueIdentifier != null : "databaseUniqueIdentifier is null";

        String var3 = null;
        int var4 = var1.length;
        int[] var5 = new int[var4];
        int[] var6 = new int[var4];
        int[] var7 = new int[var4];
        int[] var8 = new int[var4];
        int[] var9 = new int[var4];
        byte[][] var11 = new byte[var4][];
        NTFJMSPerDatabaseManager var12 = PhysicalConnection.ntfManager.getJMSPerDatabaseManager(this.databaseUniqueIdentifier);
        HashMap var13 = new HashMap();

        for(int var14 = 0; var14 < var4; ++var14) {
            var6[var14] = 1;
            var7[var14] = 0;
            var5[var14] = PhysicalConnection.ntfManager.getNextJdbcRegId();
            var11[var14] = new byte[4];
            var11[var14][0] = (byte)((var5[var14] & -16777216) >> 24);
            var11[var14][1] = (byte)((var5[var14] & 16711680) >> 16);
            var11[var14][2] = (byte)((var5[var14] & '\uff00') >> 8);
            var11[var14][3] = (byte)(var5[var14] & 255);
            Properties var15 = (Properties)var2.get(var1[var14]);
            if (var15 != null) {
                if (var15.getProperty("NTF_QOS_RELIABLE", "false").equalsIgnoreCase("true")) {
                    var8[var14] |= 1;
                }

                if (var15.getProperty("NTF_QOS_PURGE_ON_NTFN", "false").equalsIgnoreCase("true")) {
                    var8[var14] |= 16;
                }

                if (var15.getProperty("NTF_AQ_PAYLOAD", "false").equalsIgnoreCase("true")) {
                    var8[var14] |= 2;
                }

                if (var15.getProperty("NTF_ASYNC_DEQ", "false").equalsIgnoreCase("true")) {
                    var8[var14] |= 512;
                }

                if (var15.getProperty("NTF_QOS_SECURE", "false").equalsIgnoreCase("true")) {
                    var8[var14] |= 8;
                }

                if (var15.getProperty("NTF_QOS_TX_ACK", "false").equalsIgnoreCase("true")) {
                    var8[var14] |= 2048;
                }

                if (var15.getProperty("NTF_QOS_AUTO_ACK", "false").equalsIgnoreCase("true")) {
                    var8[var14] |= 1024;
                }

                var9[var14] = this.readNTFtimeout(var15);
            }
        }

        synchronized(var12) {
            if (var12.isInitialized) {
                var3 = var12.getJMSClientId();
            }

            SQLException var16;
            try {
                this.okpn.doOKPN(1, 4, this.userName, var3, var4, var6, var1, var11, var7, var8, var9, (int[])null, (int[])null, (long[])null, (byte[])null, (int[])null, (byte[])null, (TIMESTAMPTZ[])null, (int[])null, (long[])null);
            } catch (IOException var20) {
                this.handleIOException(var20);
                var16 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), var20);
                var16.fillInStackTrace();
                throw var16;
            }

            if (!var12.isInitialized) {
                var3 = this.okpn.getJMSClientId();
                if (var3 == null) {
                    SQLException var25 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 287, "clientID returned by server is null");
                    var25.fillInStackTrace();
                    throw var25;
                }

                String[] var22 = this.okpn.getDatabaseInstances();
                if (var22 == null || var22.length == 0) {
                    var22 = new String[]{this.instanceName};
                }

                ArrayList var24 = this.okpn.getListenerAddresses();
                if (var24 == null) {
                    SQLException var27 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 287, "listenerAddress returned by server is null");
                    var27.fillInStackTrace();
                    throw var27;
                }

                var12.init(var3, var22, var24);
            }

            String var23 = this.net.getSessionAttributes().getcOption().service_name;
            if (var23 == null) {
                var16 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 287, "No service name found,please use a service name format URL to create a connection");
                var16.fillInStackTrace();
                throw var16;
            } else {
                var12.startJMSListenerConnection(var23, this.userName, this.password);
                long[] var10 = this.okpn.getRegistrationIdArray();

                assert var10.length == var5.length : "jmsRegIdArr.length = " + var10.length + ", jdbcRegIdArr.length = " + var5.length;

                for(int var26 = 0; var26 < var4; ++var26) {
                    Properties var17 = (Properties)var2.get(var1[var26]);
                    if (var17 == null) {
                        var17 = new Properties();
                    }

                    NTFJMSRegistration var18 = new NTFJMSRegistration((long)var5[var26], true, this.instanceName, this.userName, var17, var1[var26], this.versionNumber, var3);
                    var18.setJMSRegistrationId(var10[var26]);
                    var18.setQOSFlag(var8[var26]);
                    var13.put(var1[var26], var18);
                    PhysicalConnection.ntfManager.addRegistration(var18);
                    var12.mapJMSRegIdToJDBCRegId(var10[var26], var5[var26]);
                    var12.incrementNumberOfRegistrations();
                }

                return var13;
            }
        }
    }

    synchronized void doUnregisterJMSNotification(NTFJMSRegistration var1) throws SQLException {
        assert this.databaseUniqueIdentifier != null : "databaseUniqueIdentifier is null";

        PhysicalConnection.ntfManager.removeRegistration(var1);
        PhysicalConnection.ntfManager.freeJdbcRegId(var1.getJdbcRegId());
        Long var2 = var1.getJMSRegistrationId();
        var1.setState(RegistrationState.CLOSED);
        NTFJMSPerDatabaseManager var3 = PhysicalConnection.ntfManager.getJMSPerDatabaseManager(this.databaseUniqueIdentifier);

        assert var3 != null : "jmsPerDatabaseManager is null";

        assert var3.isInitialized : "jmsPerDatabaseManager is not initialized";

        var3.decrementNumberOfRegistrations();
        var3.closeJMSListenerConnection();
        var3.removeRegistrationId(var2);
        String var4 = var3.getJMSClientId();
        int[] var5 = new int[]{1};
        String[] var6 = new String[]{var1.getQueueName()};
        int[] var7 = new int[]{0};
        int var8 = var1.getQOSFlag();
        int[] var9 = new int[]{var8};
        int[] var10 = new int[]{0};
        long[] var11 = new long[]{var2};

        try {
            this.okpn.doOKPN(2, 4, this.userName, var4, 1, var5, var6, (byte[][])null, var7, var9, var10, (int[])null, (int[])null, (long[])null, (byte[])null, (int[])null, (byte[])null, (TIMESTAMPTZ[])null, (int[])null, var11);
        } catch (IOException var14) {
            this.handleIOException(var14);
            SQLException var13 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), var14);
            var13.fillInStackTrace();
            throw var13;
        }
    }

    void doAckJMSNtfn(NTFJMSRegistration var1, byte[] var2, short var3) throws SQLException {
        try {
            assert this.databaseUniqueIdentifier != null : "databaseUniqueIdentifier is null";

            NTFJMSPerDatabaseManager var4 = PhysicalConnection.ntfManager.getJMSPerDatabaseManager(this.databaseUniqueIdentifier);

            assert var4 != null : "jmsPerDatabaseManager is null";

            String var7 = var4.getJMSClientId();
            this.kpdnrdeq.doOAQEMNDEQ(var7, var3, var2, var1.getJMSRegistrationId(), var1.getQueueName());
        } catch (IOException var6) {
            this.handleIOException(var6);
            SQLException var5 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), var6);
            var5.fillInStackTrace();
            throw var5;
        }
    }

    synchronized NTFAQRegistration[] doRegisterAQNotification(String[] var1, String var2, int var3, Properties[] var4) throws SQLException {
        int var5 = var1.length;
        int[] var6 = new int[var5];
        byte[][] var7 = new byte[var5][];
        int[] var8 = new int[var5];
        int[] var9 = new int[var5];
        int[] var10 = new int[var5];
        int[] var11 = new int[var5];
        int[] var12 = new int[var5];
        int[] var13 = new int[var5];
        long[] var14 = new long[var5];
        byte[] var15 = new byte[var5];
        int[] var16 = new int[var5];
        byte[] var17 = new byte[var5];
        TIMESTAMPTZ[] var18 = new TIMESTAMPTZ[var5];
        int[] var19 = new int[var5];
        boolean var20 = false;
        if (var3 == 0) {
            var20 = true;
            var3 = 47632;
        }

        for(int var21 = 0; var21 < var5; ++var21) {
            var6[var21] = PhysicalConnection.ntfManager.getNextJdbcRegId();
            var7[var21] = new byte[4];
            var7[var21][0] = (byte)((var6[var21] & -16777216) >> 24);
            var7[var21][1] = (byte)((var6[var21] & 16711680) >> 16);
            var7[var21][2] = (byte)((var6[var21] & '\uff00') >> 8);
            var7[var21][3] = (byte)(var6[var21] & 255);
            var8[var21] = 1;
            var9[var21] = 23;
            if (var4.length > var21 && var4[var21] != null) {
                if (var4[var21].getProperty("NTF_QOS_RELIABLE", "false").compareToIgnoreCase("true") == 0) {
                    var10[var21] |= 1;
                }

                if (var4[var21].getProperty("NTF_QOS_PURGE_ON_NTFN", "false").compareToIgnoreCase("true") == 0) {
                    var10[var21] |= 16;
                }

                if (var4[var21].getProperty("NTF_AQ_PAYLOAD", "false").compareToIgnoreCase("true") == 0) {
                    var10[var21] |= 2;
                }

                var11[var21] = this.readNTFtimeout(var4[var21]);
            }
        }

        this.setNtfGroupingOptions(var15, var16, var17, var18, var19, var4);
        int[] var28 = new int[]{var3};
        boolean var22 = PhysicalConnection.ntfManager.listenOnPortT4C(var28, var20);
        var3 = var28[0];
        String var23 = "(ADDRESS=(PROTOCOL=tcp)(HOST=" + var2 + ")(PORT=" + var3 + "))?PR=0";

        try {
            try {
                int var24 = var22 ? 1 : 0;
                this.okpn.doOKPN(1, var24, this.userName, var23, var5, var8, var1, var7, var9, var10, var11, var12, var13, var14, var15, var16, var17, var18, var19, var14);
            } catch (IOException var26) {
                this.handleIOException(var26);
                SQLException var25 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), var26);
                var25.fillInStackTrace();
                throw var25;
            }
        } catch (SQLException var27) {
            if (var22) {
                PhysicalConnection.ntfManager.cleanListenersT4C(var3);
            }

            throw var27;
        }

        NTFAQRegistration[] var29 = new NTFAQRegistration[var5];

        int var30;
        for(var30 = 0; var30 < var5; ++var30) {
            var29[var30] = new NTFAQRegistration(var6[var30], true, this.instanceName, this.userName, var2, var3, var4[var30], var1[var30], this.versionNumber);
        }

        for(var30 = 0; var30 < var29.length; ++var30) {
            PhysicalConnection.ntfManager.addRegistration(var29[var30]);
        }

        return var29;
    }

    private void setNtfGroupingOptions(byte[] var1, int[] var2, byte[] var3, TIMESTAMPTZ[] var4, int[] var5, Properties[] var6) throws SQLException {
        for(int var12 = 0; var12 < var6.length; ++var12) {
            String var7 = var6[var12].getProperty("NTF_GROUPING_CLASS", "NTF_GROUPING_CLASS_NONE");
            String var8 = var6[var12].getProperty("NTF_GROUPING_VALUE");
            String var9 = var6[var12].getProperty("NTF_GROUPING_TYPE");
            TIMESTAMPTZ var11 = null;
            if (var6[var12].get("NTF_GROUPING_START_TIME") != null) {
                var11 = (TIMESTAMPTZ)var6[var12].get("NTF_GROUPING_START_TIME");
            }

            String var10 = var6[var12].getProperty("NTF_GROUPING_REPEAT_TIME", "NTF_GROUPING_REPEAT_FOREVER");
            SQLException var13;
            if (var7.compareTo("NTF_GROUPING_CLASS_TIME") != 0 && var7.compareTo("NTF_GROUPING_CLASS_NONE") != 0) {
                var13 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 68);
                var13.fillInStackTrace();
                throw var13;
            }

            if (var7.compareTo("NTF_GROUPING_CLASS_NONE") != 0 && this.getTTCVersion() < 5) {
                var13 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 23);
                var13.fillInStackTrace();
                throw var13;
            }

            if (var7.compareTo("NTF_GROUPING_CLASS_TIME") == 0) {
                var1[var12] = 1;
                var2[var12] = 600;
                if (var8 != null) {
                    var2[var12] = Integer.parseInt(var8);
                }

                var3[var12] = 1;
                if (var9 != null) {
                    if (var9.compareTo("NTF_GROUPING_TYPE_SUMMARY") == 0) {
                        var3[var12] = 1;
                    } else {
                        if (var9.compareTo("NTF_GROUPING_TYPE_LAST") != 0) {
                            var13 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 68);
                            var13.fillInStackTrace();
                            throw var13;
                        }

                        var3[var12] = 2;
                    }
                }

                var4[var12] = var11;
                if (var10.compareTo("NTF_GROUPING_REPEAT_FOREVER") == 0) {
                    var5[var12] = 0;
                } else {
                    var5[var12] = Integer.parseInt(var10);
                }
            }
        }

    }

    synchronized void doUnregisterAQNotification(NTFAQRegistration var1) throws SQLException {
        String var2 = var1.getClientHost();
        int var3 = var1.getClientTCPPort();
        if (var2 != null) {
            PhysicalConnection.ntfManager.removeRegistration(var1);
            PhysicalConnection.ntfManager.freeJdbcRegId(var1.getJdbcRegId());
            PhysicalConnection.ntfManager.cleanListenersT4C(var1.getClientTCPPort());
            var1.setState(RegistrationState.CLOSED);
            String var4 = "(ADDRESS=(PROTOCOL=tcp)(HOST=" + var2 + ")(PORT=" + var3 + "))?PR=0";
            int[] var5 = new int[]{1};
            String[] var6 = new String[]{var1.getQueueName()};
            int[] var7 = new int[]{0};
            int[] var8 = new int[]{0};
            int[] var9 = new int[]{0};
            int[] var10 = new int[]{0};
            int[] var11 = new int[]{0};
            long[] var12 = new long[]{0L};
            byte[] var13 = new byte[]{0};
            int[] var14 = new int[]{0};
            byte[] var15 = new byte[]{0};
            TIMESTAMPTZ[] var16 = new TIMESTAMPTZ[]{null};
            int[] var17 = new int[]{0};
            byte[][] var18 = new byte[1][];
            int var19 = var1.getJdbcRegId();
            var18[0] = new byte[4];
            var18[0][0] = (byte)((var19 & -16777216) >> 24);
            var18[0][1] = (byte)((var19 & 16711680) >> 16);
            var18[0][2] = (byte)((var19 & '\uff00') >> 8);
            var18[0][3] = (byte)(var19 & 255);

            try {
                this.okpn.doOKPN(2, 0, this.userName, var4, 1, var5, var6, var18, var7, var8, var9, var10, var11, var12, var13, var14, var15, var16, var17, var12);
            } catch (IOException var22) {
                this.handleIOException(var22);
                SQLException var21 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), var22);
                var21.fillInStackTrace();
                throw var21;
            }
        }
    }

    synchronized NTFDCNRegistration doRegisterDatabaseChangeNotification(String var1, int var2, Properties var3, int var4, int var5) throws SQLException {
        int var6 = 0;
        int var7 = 0;
        boolean var8 = false;
        boolean var9 = false;
        boolean var10 = false;
        Object var11 = null;
        boolean var12 = false;
        boolean var13 = false;
        if (var2 == 0) {
            var13 = true;
            var2 = 47632;
        }

        if (var3.getProperty("NTF_QOS_RELIABLE", "false").compareToIgnoreCase("true") == 0) {
            var7 |= 1;
        }

        if (var3.getProperty("NTF_QOS_PURGE_ON_NTFN", "false").compareToIgnoreCase("true") == 0) {
            var7 |= 16;
        }

        if (var3.getProperty("DCN_NOTIFY_ROWIDS", "false").compareToIgnoreCase("true") == 0) {
            var6 |= 16;
        }

        if (var3.getProperty("DCN_QUERY_CHANGE_NOTIFICATION", "false").compareToIgnoreCase("true") == 0) {
            var6 |= 32;
        }

        if (var3.getProperty("DCN_BEST_EFFORT", "false").compareToIgnoreCase("true") == 0) {
            var6 |= 64;
        }

        boolean var14 = false;
        boolean var15 = false;
        boolean var16 = false;
        if (var3.getProperty("DCN_IGNORE_INSERTOP", "false").compareToIgnoreCase("true") == 0) {
            var14 = true;
        }

        if (var3.getProperty("DCN_IGNORE_UPDATEOP", "false").compareToIgnoreCase("true") == 0) {
            var15 = true;
        }

        if (var3.getProperty("DCN_IGNORE_DELETEOP", "false").compareToIgnoreCase("true") == 0) {
            var16 = true;
        }

        if (var14 || var15 || var16) {
            var6 |= 15;
            if (var14) {
                var6 -= 2;
            }

            if (var15) {
                var6 -= 4;
            }

            if (var16) {
                var6 -= 8;
            }
        }

        byte[] var17 = new byte[1];
        int[] var18 = new int[1];
        byte[] var19 = new byte[1];
        TIMESTAMPTZ[] var20 = new TIMESTAMPTZ[1];
        int[] var21 = new int[1];
        Properties[] var22 = new Properties[]{var3};
        this.setNtfGroupingOptions(var17, var18, var19, var20, var21, var22);
        int[] var23 = new int[]{var2};
        boolean var24 = PhysicalConnection.ntfManager.listenOnPortT4C(var23, var13);
        var2 = var23[0];
        String var25 = "(ADDRESS=(PROTOCOL=tcp)(HOST=" + var1 + ")(PORT=" + var2 + "))?PR=0";
        int[] var26 = new int[]{2};
        String[] var27 = new String[1];
        int[] var28 = new int[]{23};
        int[] var29 = new int[]{var7};
        int[] var30 = new int[]{var4};
        int[] var31 = new int[]{var6};
        int[] var32 = new int[]{var5};
        long[] var33 = new long[]{0L};
        int var34 = PhysicalConnection.ntfManager.getNextJdbcRegId();
        byte[][] var35 = new byte[][]{new byte[4]};
        var35[0][0] = (byte)((var34 & -16777216) >> 24);
        var35[0][1] = (byte)((var34 & 16711680) >> 16);
        var35[0][2] = (byte)((var34 & '\uff00') >> 8);
        var35[0][3] = (byte)(var34 & 255);
        long var36 = 0L;

        try {
            try {
                int var38 = var24 ? 1 : 0;
                this.okpn.doOKPN(1, var38, this.userName, var25, 1, var26, var27, var35, var28, var29, var30, var31, var32, var33, var17, var18, var19, var20, var21, var33);
                var36 = this.okpn.getRegistrationId();
            } catch (IOException var40) {
                this.handleIOException(var40);
                SQLException var39 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), var40);
                var39.fillInStackTrace();
                throw var39;
            }
        } catch (SQLException var41) {
            if (var24) {
                PhysicalConnection.ntfManager.cleanListenersT4C(var2);
            }

            throw var41;
        }

        NTFDCNRegistration var42 = new NTFDCNRegistration(var34, true, this.dbName, var36, this.userName, var1, var2, var3, this.versionNumber);
        return var42;
    }

    synchronized void doUnregisterDatabaseChangeNotification(long var1, String var3) throws SQLException {
        int[] var4 = new int[]{2};
        String[] var5 = new String[1];
        int[] var6 = new int[]{0};
        int[] var7 = new int[]{0};
        int[] var8 = new int[]{0};
        int[] var9 = new int[]{0};
        int[] var10 = new int[]{0};
        byte[] var11 = new byte[]{0};
        int[] var12 = new int[]{0};
        byte[] var13 = new byte[]{0};
        TIMESTAMPTZ[] var14 = new TIMESTAMPTZ[]{null};
        int[] var15 = new int[]{0};
        long[] var16 = new long[]{var1};
        byte[][] var17 = new byte[1][];

        try {
            this.okpn.doOKPN(2, 0, (String)null, var3, 1, var4, var5, var17, var6, var7, var8, var9, var10, var16, var11, var12, var13, var14, var15, var16);
        } catch (IOException var20) {
            this.handleIOException(var20);
            SQLException var19 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), var20);
            var19.fillInStackTrace();
            throw var19;
        }
    }

    synchronized void doUnregisterDatabaseChangeNotification(NTFDCNRegistration var1) throws SQLException {
        PhysicalConnection.ntfManager.removeRegistration(var1);
        PhysicalConnection.ntfManager.freeJdbcRegId(var1.getJdbcRegId());
        PhysicalConnection.ntfManager.cleanListenersT4C(var1.getClientTCPPort());
        var1.setState(RegistrationState.CLOSED);
        this.doUnregisterDatabaseChangeNotification(var1.getRegId(), "(ADDRESS=(PROTOCOL=tcp)(HOST=" + var1.getClientHost() + ")(PORT=" + var1.getClientTCPPort() + "))?PR=0");
    }

    public String getDataIntegrityAlgorithmName() throws SQLException {
        return this.net.getDataIntegrityName();
    }

    public String getEncryptionAlgorithmName() throws SQLException {
        return this.net.getEncryptionName();
    }

    public String getAuthenticationAdaptorName() throws SQLException {
        return this.net.getAuthenticationAdaptorName();
    }

    void validateConnectionProperties() throws SQLException {
        super.validateConnectionProperties();
        String var1 = ".*[\\00\\(\\)].*";
        SQLException var2;
        if (this.thinVsessionOsuser == null || !this.thinVsessionOsuser.matches(var1) && this.thinVsessionOsuser.length() <= 30) {
            if (this.thinVsessionTerminal == null || !this.thinVsessionTerminal.matches(var1) && this.thinVsessionTerminal.length() <= 30) {
                if (this.thinVsessionMachine != null && (this.thinVsessionMachine.matches(var1) || this.thinVsessionMachine.length() > 64)) {
                    var2 = DatabaseError.createSqlException((OracleConnection)null, 190, "Property is 'v$session.machine' and value is '" + this.thinVsessionMachine + "'");
                    var2.fillInStackTrace();
                    throw var2;
                } else if (this.thinVsessionProgram == null || !this.thinVsessionProgram.matches(var1) && this.thinVsessionProgram.length() <= 48) {
                    if (this.thinVsessionProcess != null && (this.thinVsessionProcess.matches(var1) || this.thinVsessionProcess.length() > 24)) {
                        var2 = DatabaseError.createSqlException((OracleConnection)null, 190, "Property is 'v$session.process' and value is '" + this.thinVsessionProcess + "'");
                        var2.fillInStackTrace();
                        throw var2;
                    } else if (this.thinVsessionIname != null && this.thinVsessionIname.matches(var1)) {
                        var2 = DatabaseError.createSqlException((OracleConnection)null, 190, "Property is 'v$session.iname' and value is '" + this.thinVsessionIname + "'");
                        var2.fillInStackTrace();
                        throw var2;
                    } else if (this.thinVsessionEname != null && this.thinVsessionEname.matches(var1)) {
                        var2 = DatabaseError.createSqlException((OracleConnection)null, 190, "Property is 'v$session.ename' and value is '" + this.thinVsessionEname + "'");
                        var2.fillInStackTrace();
                        throw var2;
                    }
                } else {
                    var2 = DatabaseError.createSqlException((OracleConnection)null, 190, "Property is 'v$session.program' and value is '" + this.thinVsessionProgram + "'");
                    var2.fillInStackTrace();
                    throw var2;
                }
            } else {
                var2 = DatabaseError.createSqlException((OracleConnection)null, 190, "Property is 'v$session.terminal' and value is '" + this.thinVsessionTerminal + "'");
                var2.fillInStackTrace();
                throw var2;
            }
        } else {
            var2 = DatabaseError.createSqlException((OracleConnection)null, 190, "Property is 'v$session.osuser' and value is '" + this.thinVsessionOsuser + "'");
            var2.fillInStackTrace();
            throw var2;
        }
    }

    public synchronized byte[] createLightweightSession(String var1, KeywordValueLong[] var2, int var3, KeywordValueLong[][] var4, int[] var5) throws SQLException {
        SQLException var6;
        if (var4.length == 1 && var5.length == 1) {
            var6 = null;

            try {
                this.oxsscs.doOXSSCS(var1, var2, var3);
                byte[] var10 = this.oxsscs.getSessionId();
                var4[0] = this.oxsscs.getOutKV();
                var5[0] = this.oxsscs.getOutFlags();
                return var10;
            } catch (IOException var9) {
                this.handleIOException(var9);
                SQLException var8 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), var9);
                var8.fillInStackTrace();
                throw var8;
            }
        } else {
            var6 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 68);
            var6.fillInStackTrace();
            throw var6;
        }
    }

    private synchronized void doXSNamespaceOp(XSOperationCode var1, byte[] var2, XSNamespace[] var3, XSNamespace[][] var4, XSSecureId var5, boolean var6) throws SQLException {
        XSNamespace[] var7 = null;

        try {
            this.xsnsop2.doOXSNS(var1, var2, var3, var5, var6);
            if (var6) {
                var7 = this.xsnsop2.getNamespaces();
            }
        } catch (IOException var10) {
            this.handleIOException(var10);
            SQLException var9 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), var10);
            var9.fillInStackTrace();
            throw var9;
        }

        if (var4 != null && var4.length > 0) {
            var4[0] = var7;
        }

    }

    public void doXSSessionDetachOp(int var1, byte[] var2, XSSecureId var3, boolean var4) throws SQLException {
        try {
            this.oxsdet.doOXSDET(var1, var2, var3, var4);
        } catch (IOException var7) {
            this.handleIOException(var7);
            SQLException var6 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), var7);
            var6.fillInStackTrace();
            throw var6;
        }
    }

    public void doXSNamespaceOp(XSOperationCode var1, byte[] var2, XSNamespace[] var3, XSNamespace[][] var4, XSSecureId var5) throws SQLException {
        this.doXSNamespaceOp(var1, var2, var3, var4, var5, true);
    }

    public void doXSNamespaceOp(XSOperationCode var1, byte[] var2, XSNamespace[] var3, XSSecureId var4) throws SQLException {
        this.doXSNamespaceOp(var1, var2, var3, (XSNamespace[][])null, var4, false);
    }

    public byte[] doXSSessionCreateOp(XSSessionOperationCode var1, XSSecureId var2, byte[] var3, XSPrincipal var4, String var5, XSNamespace[] var6, XSSessionModeFlag var7, XSKeyval var8) throws SQLException {
        Object var9 = null;

        try {
            this.oxscre.doOXSCRE(var1, var2, var3, var4, var5, var6, var7, var8);
            byte[] var13 = this.oxscre.getSessionId();
            return var13;
        } catch (IOException var12) {
            this.handleIOException(var12);
            SQLException var11 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), var12);
            var11.fillInStackTrace();
            throw var11;
        }
    }

    public void doXSSessionDestroyOp(byte[] var1, XSSecureId var2, byte[] var3) throws SQLException {
        try {
            this.oxsdes.doOXSDES(var1, var2, var3);
        } catch (IOException var6) {
            this.handleIOException(var6);
            SQLException var5 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), var6);
            var5.fillInStackTrace();
            throw var5;
        }
    }

    public void doXSSessionAttachOp(int var1, byte[] var2, XSSecureId var3, byte[] var4, XSPrincipal var5, String[] var6, String[] var7, String[] var8, XSNamespace[] var9, XSNamespace[] var10, XSNamespace[] var11, TIMESTAMPTZ var12, TIMESTAMPTZ var13, int var14, long var15, XSKeyval var17, int[] var18) throws SQLException {
        try {
            this.oxsatt.doOXSATT(var1, var2, var3, var4, var5, var6, var7, var8, var9, var10, var11, var12, var13, var14, var15, var17, var18);
        } catch (IOException var21) {
            this.handleIOException(var21);
            SQLException var20 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), var21);
            var20.fillInStackTrace();
            throw var20;
        }
    }

    public void doXSSessionChangeOp(XSSessionSetOperationCode var1, byte[] var2, XSSecureId var3, XSSessionParameters var4) throws SQLException {
        try {
            this.oxsset.doOXSSET(var1, var2, var3, (XSSessionParametersI)var4);
        } catch (IOException var7) {
            this.handleIOException(var7);
            SQLException var6 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), var7);
            var6.fillInStackTrace();
            throw var6;
        }
    }

    public void addLogicalTransactionIdEventListener(LogicalTransactionIdEventListener var1, Executor var2) throws SQLException {
        if (this.lifecycle != 1) {
            SQLException var10 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 8);
            var10.fillInStackTrace();
            throw var10;
        } else {
            NTFEventListener var3 = new NTFEventListener(var1);
            var3.setExecutor(var2);
            synchronized(this.ltxidListeners) {
                int var5 = this.ltxidListeners.length;

                for(int var6 = 0; var6 < var5; ++var6) {
                    if (this.ltxidListeners[var6].getLogicalTransactionIdEventListener() == var1) {
                        SQLException var7 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 248);
                        var7.fillInStackTrace();
                        throw var7;
                    }
                }

                NTFEventListener[] var11 = new NTFEventListener[var5 + 1];
                System.arraycopy(this.ltxidListeners, 0, var11, 0, var5);
                var11[var5] = var3;
                this.ltxidListeners = var11;
            }
        }
    }

    public void addLogicalTransactionIdEventListener(LogicalTransactionIdEventListener var1) throws SQLException {
        this.addLogicalTransactionIdEventListener(var1, (Executor)null);
    }

    public void removeLogicalTransactionIdEventListener(LogicalTransactionIdEventListener var1) throws SQLException {
        synchronized(this.ltxidListeners) {
            boolean var3 = false;
            int var4 = this.ltxidListeners.length;

            int var9;
            for(var9 = 0; var9 < var4 && this.ltxidListeners[var9].getLogicalTransactionIdEventListener() != var1; ++var9) {
            }

            if (var9 == var4) {
                SQLException var10 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 249);
                var10.fillInStackTrace();
                throw var10;
            } else {
                NTFEventListener[] var5 = new NTFEventListener[var4 - 1];
                int var6 = 0;

                for(var9 = 0; var9 < var4; ++var9) {
                    if (this.ltxidListeners[var9].getLogicalTransactionIdEventListener() != var1) {
                        var5[var6++] = this.ltxidListeners[var9];
                    }
                }

                this.ltxidListeners = var5;
            }
        }
    }

    public LogicalTransactionId getLogicalTransactionId() throws SQLException {
        return this.thinACCurrentLTXID;
    }

    boolean notify(final NTFLTXIDEvent var1) {
        boolean var2 = false;
        if (this.ltxidListeners != null) {
            NTFEventListener[] var3 = this.ltxidListeners;
            int var4 = var3.length;
            if (var4 > 0) {
                var2 = true;
            }

            for(int var5 = 0; var5 < var4; ++var5) {
                Executor var6 = var3[var5].getExecutor();
                if (var6 != null) {
                    final LogicalTransactionIdEventListener var7 = var3[var5].getLogicalTransactionIdEventListener();
                    var6.execute(new Runnable() {
                        public void run() {
                            var7.onLogicalTransactionIdEvent(var1);
                        }
                    });
                } else {
                    var3[var5].getLogicalTransactionIdEventListener().onLogicalTransactionIdEvent(var1);
                }
            }
        }

        return var2;
    }

    public void addXSEventListener(XSEventListener var1, Executor var2) throws SQLException {
        if (this.lifecycle != 1) {
            SQLException var10 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 8);
            var10.fillInStackTrace();
            throw var10;
        } else {
            NTFEventListener var3 = new NTFEventListener(var1);
            var3.setExecutor(var2);
            synchronized(this.xsListeners) {
                int var5 = this.xsListeners.length;

                for(int var6 = 0; var6 < var5; ++var6) {
                    if (this.xsListeners[var6].getXSEventListener() == var1) {
                        SQLException var7 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 248);
                        var7.fillInStackTrace();
                        throw var7;
                    }
                }

                NTFEventListener[] var11 = new NTFEventListener[var5 + 1];
                System.arraycopy(this.xsListeners, 0, var11, 0, var5);
                var11[var5] = var3;
                this.xsListeners = var11;
            }
        }
    }

    public void addXSEventListener(XSEventListener var1) throws SQLException {
        this.addXSEventListener(var1, (Executor)null);
    }

    public void removeXSEventListener(XSEventListener var1) throws SQLException {
        synchronized(this.xsListeners) {
            boolean var3 = false;
            int var4 = this.xsListeners.length;

            int var9;
            for(var9 = 0; var9 < var4 && this.xsListeners[var9].getXSEventListener() != var1; ++var9) {
            }

            if (var9 == var4) {
                SQLException var10 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 249);
                var10.fillInStackTrace();
                throw var10;
            } else {
                NTFEventListener[] var5 = new NTFEventListener[var4 - 1];
                int var6 = 0;

                for(var9 = 0; var9 < var4; ++var9) {
                    if (this.xsListeners[var9].getXSEventListener() != var1) {
                        var5[var6++] = this.xsListeners[var9];
                    }
                }

                this.xsListeners = var5;
            }
        }
    }

    public void removeAllXSEventListener() throws SQLException {
        synchronized(this.xsListeners) {
            NTFEventListener[] var2 = new NTFEventListener[0];
            this.xsListeners = var2;
        }
    }

    void notify(final NTFXSEvent var1) {
        NTFEventListener[] var2 = this.xsListeners;
        int var3 = var2.length;

        for(int var4 = 0; var4 < var3; ++var4) {
            Executor var5 = var2[var4].getExecutor();
            if (var5 != null) {
                final XSEventListener var6 = var2[var4].getXSEventListener();
                var5.execute(new Runnable() {
                    public void run() {
                        var6.onXSEvent(var1);
                    }
                });
            } else {
                var2[var4].getXSEventListener().onXSEvent(var1);
            }
        }

    }

    final boolean hasServerCompileTimeCapability(int var1, int var2) {
        boolean var3 = false;
        if (this.serverCompileTimeCapabilities != null && this.serverCompileTimeCapabilities.length > var1 && (this.serverCompileTimeCapabilities[var1] & var2) != 0) {
            var3 = true;
        }

        return var3;
    }

    long doGetCurrentSCN() throws SQLException {
        return this.outScn;
    }

    EnumSet<TransactionState> doGetTransactionState() throws SQLException {
        EnumSet var1 = EnumSet.noneOf(TransactionState.class);
        if ((this.eocs & 1) != 0) {
            var1.add(TransactionState.TRANSACTION_READONLY);
        }

        if ((this.eocs & 2) != 0) {
            var1.add(TransactionState.TRANSACTION_STARTED);
        }

        if ((this.eocs & 4) != 0) {
            var1.add(TransactionState.TRANSACTION_ENDED);
        }

        if ((this.eocs & 1024) != 0) {
            var1.add(TransactionState.TRANSACTION_INTENTION);
        }

        return var1;
    }

    public boolean isConnectionSocketKeepAlive() throws SocketException {
        return this.net.isConnectionSocketKeepAlive();
    }

    public int getEOC() throws SQLException {
        return this.eocs;
    }

    public synchronized void setReplayOperations(EnumSet<ReplayOperation> var1) throws SQLException {
        if (this.ossestateOperations != ReplayOperation.KPDSS_SESSSTATE_REQUEST_END.getCode() || var1.size() != 0) {
            this.ossestateOperations = 0L;

            for(Iterator var2 = var1.iterator(); var2.hasNext(); this.ossestateOperations |= ((ReplayOperation)var2.next()).getCode()) {
            }

            if ((this.ossestateOperations & ReplayOperation.KPDSS_SESSSTATE_APPCONT_ENABLED.getCode()) != 0L) {
                this.replayModes.add(T4CConnection.ReplayMode.RUNTIME_REPLAY_ENABLED);
            } else {
                this.replayModes.remove(T4CConnection.ReplayMode.RUNTIME_REPLAY_ENABLED);
            }

            if ((this.ossestateOperations & ReplayOperation.KPDSS_SESSSTATE_STATIC.getCode()) != 0L) {
                this.replayModes.add(T4CConnection.ReplayMode.RUNTIME_OR_REPLAYING_STATIC);
            } else {
                this.replayModes.remove(T4CConnection.ReplayMode.RUNTIME_OR_REPLAYING_STATIC);
            }

        }
    }

    public synchronized void setReplayingMode(boolean var1) throws SQLException {
        if (var1) {
            this.replayModes.remove(T4CConnection.ReplayMode.RUNTIME_REPLAY_ENABLED);
            this.replayModes.add(T4CConnection.ReplayMode.REPLAYING);
        } else {
            this.replayModes.remove(T4CConnection.ReplayMode.REPLAYING);
        }

    }

    public synchronized void beginNonRequestCalls() throws SQLException {
        this.replayModes.add(T4CConnection.ReplayMode.NONREQUEST);
    }

    public synchronized void endNonRequestCalls() throws SQLException {
        this.replayModes.remove(T4CConnection.ReplayMode.NONREQUEST);
    }

    public synchronized void setReplayContext(ReplayContext[] var1) throws SQLException {
        if (var1 != null) {
            this.oappcontreplayContextsArr = var1;
            this.oappcontreplayOffset = 0;
        }

    }

    public synchronized ReplayContext[] getReplayContext() throws SQLException {
        if (this.thinACReplayContextReceivedCurrent == 0) {
            return null;
        } else {
            ReplayContext[] var1 = new ReplayContext[this.thinACReplayContextReceivedCurrent];
            System.arraycopy(this.thinACReplayContextReceived, 0, var1, 0, this.thinACReplayContextReceivedCurrent);
            this.thinACReplayContextReceivedCurrent = 0;
            return var1;
        }
    }

    public ReplayContext getLastReplayContext() throws SQLException {
        return this.thinACLastReplayContextReceived;
    }

    public void registerEndReplayCallback(EndReplayCallback var1) throws SQLException {
        this.endReplayCallback = var1;
    }

    public byte[] getDerivedKeyInternal(byte[] var1, int var2) throws NoSuchAlgorithmException, InvalidKeySpecException, SQLException {
        return this.auth.getDerivedKeyJdbc(var1, var2);
    }

    void releaseConnectionToPool() throws SQLException {
        try {
            if (this.drcpState != DrcpState.STATEFUL) {
                return;
            }

            this.drcpState = DrcpState.STATELESS;
            if (this.currentlyInTransaction) {
                this.osessrls.setTTCCode((byte)3);
                this.osessrls.doRPC();
            } else {
                this.osessrls.setTTCCode((byte)26);
                this.osessrls.doOneWayRPC();
            }
        } catch (IOException var2) {
            this.handleIOException(var2);
        } catch (SQLException var3) {
            if (this.currentlyInTransaction) {
                throw var3;
            }
        }

    }

    boolean reusePooledConnection() throws SQLException {
        if (this.drcpState != DrcpState.STATEFUL) {
            this.drcpState = DrcpState.STATEFUL;

            try {
                if (this.drcpTagName != null) {
                    this.osessget.doRPC();
                    this.resetAfterReusePooledConnection();
                }
            } catch (IOException var2) {
                this.handleIOException(var2);
            }
        }

        return !bit(this.ocsessret.sessretflags, 1L);
    }

    public boolean needToPurgeStatementCache() throws SQLException {
        if (this.lifecycle != 1) {
            SQLException var1 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 8);
            var1.fillInStackTrace();
            throw var1;
        } else if (!this.drcpEnabled) {
            return false;
        } else {
            return bit(this.ocsessret.sessretflags, 4L) || bit(this.ocsessret.sessretflags, 8L);
        }
    }

    public int getNetworkTimeout() throws SQLException {
        SQLException var2;
        try {
            return this.net.getSocketReadTimeout();
        } catch (NetException var3) {
            var2 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), var3);
            var2.fillInStackTrace();
            throw var2;
        } catch (IOException var4) {
            var2 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), var4);
            var2.fillInStackTrace();
            throw var2;
        }
    }

    protected void doSetNetworkTimeout(int var1) throws SQLException {
        SQLException var3;
        try {
            this.net.setSocketReadTimeout(var1);
        } catch (NetException var4) {
            var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), var4);
            var3.fillInStackTrace();
            throw var3;
        } catch (IOException var5) {
            var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), var5);
            var3.fillInStackTrace();
            throw var3;
        }
    }

    static final String dumpObject(Object var0, String var1) {
        return dumpObject(var0, var1, new StringBuilder());
    }

    static final String dumpObject(Object var0, String var1, StringBuilder var2) {
        Class var3 = var0.getClass();
        Field[] var4 = var3.getDeclaredFields();
        var2.append(var1 + var3.getName() + " { \n");
        Field[] var5 = var4;
        int var6 = var4.length;

        for(int var7 = 0; var7 < var6; ++var7) {
            Field var8 = var5[var7];
            if ((var8.getModifiers() & 8) == 0) {
                var8.setAccessible(true);

                try {
                    var2.append(var1 + "  " + var8.getName() + " = ");
                    Object var9 = var8.get(var0);
                    if (var9 == null) {
                        var2.append("null");
                    } else {
                        var2.append(var9);
                    }

                    var2.append("\n");
                } catch (IllegalAccessException var10) {
                }
            }
        }

        var2.append(var1 + "}\n");
        return var2.toString();
    }

    byte getNextSeqNumber() {
        if (this.currentTTCSeqNumber == 127) {
            this.currentTTCSeqNumber = 1;
            return this.currentTTCSeqNumber;
        } else {
            return ++this.currentTTCSeqNumber;
        }
    }

    public int getNegotiatedSDU() throws SQLException {
        try {
            return this.net.getNegotiatedSDU();
        } catch (NetException var3) {
            SQLException var2 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), var3);
            var2.fillInStackTrace();
            throw var2;
        }
    }

    static enum ReplayMode {
        RUNTIME_REPLAY_ENABLED,
        RUNTIME_OR_REPLAYING_STATIC,
        NONREQUEST,
        REPLAYING;

        private ReplayMode() {
        }
    }
}
