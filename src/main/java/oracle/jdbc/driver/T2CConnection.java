//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package oracle.jdbc.driver;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.CharBuffer;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.SQLWarning;
import java.util.Hashtable;
import java.util.Locale;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Properties;
import java.util.StringTokenizer;
import java.util.TimeZone;
import java.util.Locale.Category;
import oracle.jdbc.OracleOCIFailover;
import oracle.jdbc.driver.PhysicalConnection.DrcpState;
import oracle.jdbc.internal.OracleBfile;
import oracle.jdbc.internal.OracleBlob;
import oracle.jdbc.internal.OracleClob;
import oracle.jdbc.internal.OracleConnection;
import oracle.jdbc.internal.OracleConnection.InstanceProperty;
import oracle.jdbc.internal.OracleStatement.SqlKind;
import oracle.jdbc.oracore.OracleTypeADT;
import oracle.jdbc.oracore.OracleTypeCLOB;
import oracle.jdbc.pool.OracleOCIConnectionPool;
import oracle.jdbc.pool.OraclePooledConnection;
import oracle.sql.BFILE;
import oracle.sql.BLOB;
import oracle.sql.BfileDBAccess;
import oracle.sql.BlobDBAccess;
import oracle.sql.CLOB;
import oracle.sql.ClobDBAccess;
import oracle.sql.LobPlsqlUtil;
import oracle.sql.NCLOB;
import oracle.sql.SQLName;
import oracle.sql.ZONEIDMAP;
import oracle.sql.converter.CharacterSetMetaData;

public class T2CConnection extends PhysicalConnection implements BfileDBAccess, BlobDBAccess, ClobDBAccess {
    static final long JDBC_OCI_LIBRARY_VERSION = Long.parseLong("12.1.0.1.0".replaceAll("\\.", ""));
    short[] queryMetaData1 = null;
    byte[] queryMetaData2 = null;
    int queryMetaData1Offset = 0;
    int queryMetaData2Offset = 0;
    private String password;
    int fatalErrorNumber = 0;
    String fatalErrorMessage = null;
    static final int QMD_dbtype = 0;
    static final int QMD_dbsize = 1;
    static final int QMD_nullok = 2;
    static final int QMD_precision = 3;
    static final int QMD_scale = 4;
    static final int QMD_formOfUse = 5;
    static final int QMD_columnNameLength = 6;
    static final int QMD_tdo0 = 7;
    static final int QMD_tdo1 = 8;
    static final int QMD_tdo2 = 9;
    static final int QMD_tdo3 = 10;
    static final int QMD_charLength = 11;
    static final int QMD_typeNameLength = 12;
    static final int QMD_columnInvisible = 13;
    static final int T2C_LOCATOR_MAX_LEN = 16;
    static final int T2C_LINEARIZED_LOCATOR_MAX_LEN = 4000;
    static final int T2C_LINEARIZED_BFILE_LOCATOR_MAX_LEN = 530;
    static final int METADATA1_INDICES_PER_COLUMN = 14;
    protected static final int SIZEOF_QUERYMETADATA2 = 8;
    static final String defaultDriverNameAttribute = "jdbcoci";
    int queryMetaData1Size = 100;
    int queryMetaData2Size = 800;
    long m_nativeState;
    short m_clientCharacterSet;
    byte byteAlign;
    static final byte[] EMPTY_BYTES = new byte[0];
    private static final int EOJ_SUCCESS = 0;
    private static final int EOJ_ERROR = -1;
    private static final int EOJ_WARNING = 1;
    private static final int EOJ_GET_STORAGE_ERROR = -4;
    private static final int EOJ_ORA3113_SERVER_NORMAL = -6;
    private static final String OCILIBRARY = "ocijdbc12";
    private int logon_mode = 0;
    static final int LOGON_MODE_DEFAULT = 0;
    static final int LOGON_MODE_SYSDBA = 2;
    static final int LOGON_MODE_SYSOPER = 4;
    static final int LOGON_MODE_SYSASM = 32768;
    static final int LOGON_MODE_SYSBKP = 131072;
    static final int LOGON_MODE_SYSDGD = 262144;
    static final int LOGON_MODE_SYSKMT = 524288;
    static final int LOGON_MODE_CONNECTION_POOL = 5;
    static final int LOGON_MODE_CONNPOOL_CONNECTION = 6;
    static final int LOGON_MODE_CONNPOOL_PROXY_CONNECTION = 7;
    static final int LOGON_MODE_CONNPOOL_ALIASED_CONNECTION = 8;
    static final int T2C_PROXYTYPE_NONE = 0;
    static final int T2C_PROXYTYPE_USER_NAME = 1;
    static final int T2C_PROXYTYPE_DISTINGUISHED_NAME = 2;
    static final int T2C_PROXYTYPE_CERTIFICATE = 3;
    static final int T2C_CONNECTION_FLAG_DEFAULT_LOB_PREFETCH = 0;
    static final int T2C_CONNECTION_FLAG_PRELIM_AUTH = 1;
    static final int T2C_CONNECTION_FLAG_CHARSET = 2;
    static final int T2C_CONNECTION_FLAG_NCHARSET = 3;
    static final int T2C_CONNECTION_FLAG_BYTE_ALIGN = 4;
    static final int T2C_CONNECTION_FLAG_SERVER_TZ_VERSION = 5;
    static final int T2C_CONNECTION_FLAG_TAF_ENABLED = 6;
    static final int T2C_CONNECTION_TAG_MATCHED = 7;
    static final int T2C_CONNECTION_FLAG_MAXLEN_COMPAT = 8;
    static final int T2C_MAX_SCHEMA_NAME_LENGTH = 258;
    private static boolean isLibraryLoaded;
    static final Map<String, String> cachedVersionTable = new Hashtable();
    static final int T2C_LOGON_OUT_BUFFER_LENGTH = 256;
    static final int EOO_LOGIN_OUT_TYPE_DBID = 1;
    static final int EOO_LOGIN_OUT_INST_START_TIME = 2;
    String databaseUniqueIdentifier;
    OracleOCIFailover appCallback = null;
    Object appCallbackObject = null;
    private Properties nativeInfo;
    ByteBuffer nioBufferForLob;
    boolean[] tagMatched;
    static final int OCI_SESSRLS_DROPSESS = 1;
    static final int OCI_SESSRLS_RETAG = 2;
    private static final String _Copyright_2007_Oracle_All_Rights_Reserved_ = null;
    public static final String BUILD_DATE = "Thu_Apr_04_15:09:24_PDT_2013";
    public static final boolean TRACE = false;

    protected T2CConnection(String var1, Properties var2, OracleDriverExtension var3) throws SQLException {
        super(var1, var2, var3);
        this.initialize();
    }

    final void initializePassword(String var1) throws SQLException {
        this.password = var1;
    }

    protected void initialize() {
        this.allocQueryMetaDataBuffers();
    }

    private void allocQueryMetaDataBuffers() {
        this.queryMetaData1Offset = 0;
        this.queryMetaData1 = new short[this.queryMetaData1Size * 14];
        this.queryMetaData2Offset = 0;
        this.queryMetaData2 = new byte[this.queryMetaData2Size];
        this.namedTypeAccessorByteLen = 0;
        this.refTypeAccessorByteLen = 0;
    }

    void reallocateQueryMetaData(int var1, int var2) {
        this.queryMetaData1 = null;
        this.queryMetaData2 = null;
        this.queryMetaData1Size = Math.max(var1, this.queryMetaData1Size);
        this.queryMetaData2Size = Math.max(var2, this.queryMetaData2Size);
        this.allocQueryMetaDataBuffers();
    }

    protected void logon() throws SQLException {
        this.tagMatched = new boolean[]{false};
        if (this.database == null) {
            SQLException var28 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 64);
            var28.fillInStackTrace();
            throw var28;
        } else {
            if (!isLibraryLoaded) {
                loadNativeLibrary(this.ocidll);
            }

            byte[] var1 = new byte[256];
            if (this.ociConnectionPoolIsPooling) {
                this.processOCIConnectionPooling();
            } else {
                long var2 = this.ociSvcCtxHandle;
                long var4 = this.ociEnvHandle;
                long var6 = this.ociErrHandle;
                SQLException var8;
                if (var2 != 0L && var4 != 0L) {
                    if (this.ociDriverCharset != null) {
                        this.m_clientCharacterSet = (new Integer(this.ociDriverCharset)).shortValue();
                        this.conversion = new DBConversion(this.m_clientCharacterSet, this.m_clientCharacterSet, this.m_clientCharacterSet);
                        long[] var30 = new long[]{(long)this.defaultLobPrefetchSize, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, (long)(this.enableOCIFAN ? 1 : 0)};
                        this.sqlWarning = this.checkError(this.t2cUseConnection(this.m_nativeState, var4, var2, var6, var1, var30), this.sqlWarning);
                        this.conversion = new DBConversion((short)((int)(var30[2] & 65535L)), this.m_clientCharacterSet, (short)((int)(var30[3] & 65535L)));
                        this.byteAlign = (byte)((int)(var30[4] & 255L));
                        this.timeZoneVersionNumber = (int)var30[5];
                        if (var30[6] != 0L) {
                            this.useOCIDefaultDefines = true;
                        }

                        this.tagMatched[0] = var30[7] != 0L;
                        this.varTypeMaxLenCompat = (int)var30[8];
                        return;
                    }

                    var8 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 89);
                    var8.fillInStackTrace();
                    throw var8;
                }

                if (this.internalLogon == null) {
                    this.logon_mode = 0;
                } else if (this.internalLogon.equalsIgnoreCase("SYSDBA")) {
                    this.logon_mode = 2;
                } else if (this.internalLogon.equalsIgnoreCase("SYSOPER")) {
                    this.logon_mode = 4;
                } else if (this.internalLogon.equalsIgnoreCase("SYSASM")) {
                    this.logon_mode = 32768;
                } else if (this.internalLogon.equalsIgnoreCase("SYSBACKUP")) {
                    this.logon_mode = 131072;
                } else if (this.internalLogon.equalsIgnoreCase("SYSDG")) {
                    this.logon_mode = 262144;
                } else if (this.internalLogon.equalsIgnoreCase("SYSKM")) {
                    this.logon_mode = 524288;
                }

                var8 = null;
                Object var9 = null;
                Object var10 = null;
                byte[] var11 = EMPTY_BYTES;
                byte[] var12 = EMPTY_BYTES;
                String var13 = this.setNewPassword;
                byte[] var14 = EMPTY_BYTES;
                byte[] var15 = EMPTY_BYTES;
                byte[] var16 = EMPTY_BYTES;
                if (this.nlsLangBackdoor) {
                    this.m_clientCharacterSet = getDriverCharSetIdFromNLS_LANG(this.ocidll);
                } else {
                    this.m_clientCharacterSet = getClientCharSetId();
                }

                if (var13 != null) {
                    var14 = DBConversion.stringToDriverCharBytes(var13, this.m_clientCharacterSet);
                }

                if (this.editionName != null) {
                    var15 = DBConversion.stringToDriverCharBytes(this.editionName, this.m_clientCharacterSet);
                }

                if (this.driverNameAttribute == null) {
                    var16 = DBConversion.stringToDriverCharBytes("jdbcoci", this.m_clientCharacterSet);
                } else {
                    var16 = DBConversion.stringToDriverCharBytes(this.driverNameAttribute, this.m_clientCharacterSet);
                }

                byte[] var29 = this.userName == null ? EMPTY_BYTES : DBConversion.stringToDriverCharBytes(this.userName, this.m_clientCharacterSet);
                byte[] var31 = this.proxyClientName == null ? EMPTY_BYTES : DBConversion.stringToDriverCharBytes(this.proxyClientName, this.m_clientCharacterSet);
                byte[] var32 = this.password == null ? EMPTY_BYTES : DBConversion.stringToDriverCharBytes(this.password, this.m_clientCharacterSet);
                if (this.drcpEnabled) {
                    var11 = DBConversion.stringToDriverCharBytes(this.drcpConnectionClass, this.m_clientCharacterSet);
                }

                if (this.drcpTagName != null) {
                    var12 = DBConversion.stringToDriverCharBytes(this.drcpTagName, this.m_clientCharacterSet);
                }

                byte[] var17 = DBConversion.stringToDriverCharBytes(this.database, this.m_clientCharacterSet);
                String var18 = null;
                byte[] var19 = (var18 = CharacterSetMetaData.getNLSLanguage(Locale.getDefault(Category.FORMAT))) != null ? var18.getBytes() : null;
                byte[] var20 = (var18 = CharacterSetMetaData.getNLSTerritory(Locale.getDefault(Category.FORMAT))) != null ? var18.getBytes() : null;
                if (var19 == null || var20 == null) {
                    SQLException var33 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 176);
                    var33.fillInStackTrace();
                    throw var33;
                }

                TimeZone var21 = TimeZone.getDefault();
                String var22 = var21.getID();
                int var24;
                if (!ZONEIDMAP.isValidRegion(var22) || !this.timezoneAsRegion) {
                    int var23 = var21.getOffset(System.currentTimeMillis());
                    var24 = var23 / 3600000;
                    int var25 = var23 / '\uea60' % 60;
                    var22 = (var24 < 0 ? "" + var24 : "+" + var24) + (var25 < 10 ? ":0" + var25 : ":" + var25);
                }

                doSetSessionTimeZone(var22);
                this.sessionTimeZone = var22;
                this.conversion = new DBConversion(this.m_clientCharacterSet, this.m_clientCharacterSet, this.m_clientCharacterSet);
                long[] var34 = new long[]{(long)this.defaultLobPrefetchSize, (long)(this.prelimAuth ? 1 : 0), 0L, 0L, 0L, 0L, 0L, 0L, 0L, (long)(this.enableOCIFAN ? 1 : 0)};
                if (this.m_nativeState == 0L) {
                    this.sqlWarning = this.checkError(this.t2cCreateState(var29, var29.length, var31, var31.length, var32, var32.length, var14, var14.length, var15, var15.length, var16, var16.length, var17, var17.length, var11, var11.length, var12, var12.length, this.m_clientCharacterSet, this.logon_mode, var19, var20, var1, var34), this.sqlWarning);
                } else {
                    this.sqlWarning = this.checkError(this.t2cLogon(this.m_nativeState, var29, var29.length, var31, var31.length, var32, var32.length, var14, var14.length, var15, var15.length, var16, var16.length, var17, var17.length, var11, var11.length, var12, var12.length, this.logon_mode, var19, var20, var1, var34), this.sqlWarning);
                }

                this.conversion = new DBConversion((short)((int)(var34[2] & 65535L)), this.m_clientCharacterSet, (short)((int)(var34[3] & 65535L)));
                this.byteAlign = (byte)((int)(var34[4] & 255L));
                this.timeZoneVersionNumber = (int)var34[5];
                if (var34[6] != 0L) {
                    this.useOCIDefaultDefines = true;
                }

                this.tagMatched[0] = var34[7] != 0L;
                this.varTypeMaxLenCompat = (int)var34[8];
                var24 = 0;
                String var35 = null;

                while(true) {
                    int var26 = this.readShort(var1, var24);
                    if (var26 == 0) {
                        if (this.databaseUniqueIdentifier != null) {
                            String var36 = (String)cachedVersionTable.get(this.databaseUniqueIdentifier + var35);
                            if (var36 == null) {
                                cachedVersionTable.put(this.databaseUniqueIdentifier + var35, String.valueOf(this.getVersionNumber()));
                                if (this.drcpEnabled) {
                                    this.detachServerConnection((String)null);
                                }
                            } else {
                                this.versionNumber = Short.parseShort(var36);
                                this.t2cSetCachedServerVersion(this.m_nativeState, this.versionNumber);
                            }
                        }
                        break;
                    }

                    var24 += 2;
                    int var27 = this.readShort(var1, var24);
                    var24 += 2;
                    switch(var26) {
                        case 1:
                            this.databaseUniqueIdentifier = new String(var1, var24, var27);
                            var24 += var27;
                            break;
                        case 2:
                            var35 = new String(var1, var24, var27);
                            var24 += var27;
                    }
                }
            }

        }
    }

    int readShort(byte[] var1, int var2) {
        return (var1[var2] & 255) << 8 | var1[var2 + 1] & 255;
    }

    protected void logoff() throws SQLException {
        try {
            if (this.lifecycle == 8 || this.lifecycle == 2) {
                this.checkError(this.t2cLogoff(this.m_nativeState));
            }
        } catch (NullPointerException var2) {
        }

        this.m_nativeState = 0L;
    }

    public void open(OracleStatement var1) throws SQLException {
        byte[] var2 = var1.sqlObject.getSql(var1.processEscapes, var1.convertNcharLiterals).getBytes();
        this.checkError(this.t2cCreateStatement(this.m_nativeState, 0L, var2, var2.length, var1, false, var1.rowPrefetch));
    }

    OracleStatement createImplicitResultSetStatement(OracleStatement var1) throws SQLException {
        T2CStatement var2 = new T2CStatement(this, 1, this.defaultRowPrefetch, -1, -1);
        this.checkError(this.t2cGetImplicitResultSetStatement(this.m_nativeState, var1.c_state, var2));
        var2.needToParse = false;
        var2.isOpen = true;
        var2.processEscapes = false;
        var2.sqlKind = SqlKind.SELECT;
        var2.prepareForNewResults(true, false, true);
        var1.addImplicitResultSetStmt(var2);
        return var2;
    }

    void cancelOperationOnServer(boolean var1) throws SQLException {
        this.checkError(this.t2cCancel(this.m_nativeState));
    }

    native int t2cAbort(long var1);

    void doAbort() throws SQLException {
        this.checkError(this.t2cAbort(this.m_nativeState));
    }

    protected void doSetAutoCommit(boolean var1) throws SQLException {
        if (this.autoCommitSpecCompliant && !this.getAutoCommit() && var1) {
            this.commit();
        }

        this.checkError(this.t2cSetAutoCommit(this.m_nativeState, var1));
        this.autocommit = var1;
    }

    protected void doCommit(int var1) throws SQLException {
        this.checkError(this.t2cCommit(this.m_nativeState, var1));
    }

    protected void doRollback() throws SQLException {
        this.checkError(this.t2cRollback(this.m_nativeState));
    }

    synchronized int doPingDatabase() throws SQLException {
        return this.t2cPingDatabase(this.m_nativeState) == 0 ? 0 : -1;
    }

    protected String doGetDatabaseProductVersion() throws SQLException {
        byte[] var1 = this.t2cGetProductionVersion(this.m_nativeState);
        return this.conversion.CharBytesToString(var1, var1.length);
    }

    protected short doGetVersionNumber() throws SQLException {
        short var1 = 0;

        try {
            String var2 = this.doGetDatabaseProductVersion();
            StringTokenizer var3 = new StringTokenizer(var2.trim(), " .", false);
            String var4 = null;
            int var5 = 0;
            boolean var6 = false;

            while(var3.hasMoreTokens()) {
                var4 = var3.nextToken();

                try {
                    short var10 = Integer.decode(var4).shortValue();
                    var1 = (short)(var1 * 10 + var10);
                    ++var5;
                    if (var5 == 4) {
                        break;
                    }
                } catch (NumberFormatException var8) {
                }
            }
        } catch (NoSuchElementException var9) {
        }

        if (var1 == -1) {
            var1 = 0;
        }

        return var1;
    }

    public ClobDBAccess createClobDBAccess() {
        return this;
    }

    public BlobDBAccess createBlobDBAccess() {
        return this;
    }

    public BfileDBAccess createBfileDBAccess() {
        return this;
    }

    protected SQLWarning checkError(int var1) throws SQLException {
        return this.checkError(var1, (SQLWarning)null);
    }

    protected SQLWarning checkError(int var1, SQLWarning var2) throws SQLException {
        switch(var1) {
            case -4:
                SQLException var7 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 254);
                var7.fillInStackTrace();
                throw var7;
            case -1:
            case 1:
                T2CError var3 = new T2CError();
                boolean var4 = true;
                if (this.lifecycle != 1 && this.lifecycle != 16) {
                    SQLException var9;
                    if (this.fatalErrorNumber != 0) {
                        var9 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 269);
                        var9.fillInStackTrace();
                        throw var9;
                    }

                    var9 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 8);
                    var9.fillInStackTrace();
                    throw var9;
                } else {
                    int var8 = this.t2cDescribeError(this.m_nativeState, var3, var3.m_errorMessage);
                    String var5 = null;
                    if (var8 != -1) {
                        int var6;
                        for(var6 = 0; var6 < var3.m_errorMessage.length && var3.m_errorMessage[var6] != 0; ++var6) {
                        }

                        if (this.conversion == null) {
                            throw new Error("conversion == null");
                        }

                        if (var3 == null) {
                            throw new Error("l_error == null");
                        }

                        var5 = this.conversion.CharBytesToString(var3.m_errorMessage, var6, true);
                    }

                    switch(var3.m_errorNumber) {
                        case -6:
                            var3.m_errorNumber = 3113;
                            break;
                        case 28:
                        case 600:
                        case 1012:
                        case 1041:
                            this.internalClose();
                            break;
                        case 902:
                            this.removeAllDescriptor();
                            break;
                        case 3113:
                        case 3114:
                            this.setUsable(false);
                            this.close();
                    }

                    SQLException var10;
                    if (var8 == -1) {
                        var10 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 1, "Fetch error message failed!");
                        var10.fillInStackTrace();
                        throw var10;
                    } else if (var1 == -1) {
                        var10 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), var5, var3.m_errorNumber);
                        var10.fillInStackTrace();
                        throw var10;
                    } else {
                        var2 = DatabaseError.addSqlWarning(var2, var5, var3.m_errorNumber);
                    }
                }
            case -3:
            case -2:
            case 0:
            default:
                return var2;
        }
    }

    OracleStatement RefCursorBytesToStatement(byte[] var1, OracleStatement var2) throws SQLException {
        T2CStatement var3 = new T2CStatement(this, 1, this.defaultRowPrefetch, -1, -1);
        var3.needToParse = false;
        var3.serverCursor = true;
        var3.isOpen = true;
        var3.processEscapes = false;
        var3.prepareForNewResults(true, false, true);
        if (this.useOCIDefaultDefines) {
            var3.savedRowPrefetch = this.defaultRowPrefetch;
            var3.rowPrefetch = 1;
        }

        var3.sqlObject.initialize("select unknown as ref cursor from whatever");
        var3.sqlKind = SqlKind.SELECT;
        this.checkError(this.t2cCreateStatement(this.m_nativeState, var2.c_state, var1, var1.length, var3, true, this.defaultRowPrefetch));
        var2.addChild(var3);
        return var3;
    }

    public void getForm(OracleTypeADT var1, OracleTypeCLOB var2, int var3) throws SQLException {
        boolean var4 = false;
        if (var2 != null) {
            String[] var5 = new String[1];
            String[] var6 = new String[1];
            SQLName.parse(var1.getFullName(), var5, var6, true);
            String var7 = "\"" + var5[0] + "\".\"" + var6[0] + "\"";
            byte[] var8 = this.conversion.StringToCharBytes(var7);
            int var9 = this.t2cGetFormOfUse(this.m_nativeState, var2, var8, var8.length, var3);
            if (var9 < 0) {
                this.checkError(var9);
            }

            var2.setForm(var9);
        }

    }

    public long getTdoCState(String var1, String var2) throws SQLException {
        String var3 = "\"" + var1 + "\".\"" + var2 + "\"";
        byte[] var4 = this.conversion.StringToCharBytes(var3);
        int[] var5 = new int[1];
        long var6 = this.t2cGetTDO(this.m_nativeState, var4, var4.length, var5);
        if (var6 == 0L) {
            this.checkError(var5[0]);
        }

        return var6;
    }

    public long getTdoCState(String var1) throws SQLException {
        byte[] var2 = this.conversion.StringToCharBytes(var1);
        int[] var3 = new int[1];
        long var4 = this.t2cGetTDO(this.m_nativeState, var2, var2.length, var3);
        if (var4 == 0L) {
            this.checkError(var3[0]);
        }

        return var4;
    }

    /** @deprecated */
    public Properties getDBAccessProperties() throws SQLException {
        return this.getOCIHandles();
    }

    public synchronized Properties getOCIHandles() throws SQLException {
        if (this.lifecycle != 1) {
            SQLException var2 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 8);
            var2.fillInStackTrace();
            throw var2;
        } else {
            if (this.nativeInfo == null) {
                long[] var1 = new long[3];
                this.checkError(this.t2cGetHandles(this.m_nativeState, var1));
                this.nativeInfo = new Properties();
                this.nativeInfo.put("OCIEnvHandle", String.valueOf(var1[0]));
                this.nativeInfo.put("OCISvcCtxHandle", String.valueOf(var1[1]));
                this.nativeInfo.put("OCIErrHandle", String.valueOf(var1[2]));
                this.nativeInfo.put("ClientCharSet", String.valueOf(this.m_clientCharacterSet));
            }

            return this.nativeInfo;
        }
    }

    public Properties getServerSessionInfo() throws SQLException {
        if (this.lifecycle != 1) {
            SQLException var1 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 8);
            var1.fillInStackTrace();
            throw var1;
        } else {
            if (this.sessionProperties == null) {
                this.sessionProperties = new Properties();
            }

            if (this.getVersionNumber() < 10200) {
                this.queryFCFProperties(this.sessionProperties);
            } else {
                this.checkError(t2cGetServerSessionInfo(this.m_nativeState, this.sessionProperties));
            }

            return this.sessionProperties;
        }
    }

    public byte getInstanceProperty(InstanceProperty var1) throws SQLException {
        byte var2 = 0;
        if (var1 == InstanceProperty.ASM_VOLUME_SUPPORTED) {
            var2 = this.t2cGetAsmVolProperty(this.m_nativeState);
        } else if (var1 == InstanceProperty.INSTANCE_TYPE) {
            var2 = this.t2cGetInstanceType(this.m_nativeState);
        }

        return var2;
    }

    public Properties getConnectionPoolInfo() throws SQLException {
        if (this.lifecycle != 1) {
            SQLException var2 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 8);
            var2.fillInStackTrace();
            throw var2;
        } else {
            Properties var1 = new Properties();
            this.checkError(this.t2cGetConnPoolInfo(this.m_nativeState, var1));
            return var1;
        }
    }

    public void setConnectionPoolInfo(int var1, int var2, int var3, int var4, int var5, int var6) throws SQLException {
        this.checkError(this.t2cSetConnPoolInfo(this.m_nativeState, var1, var2, var3, var4, var5, var6));
    }

    public void ociPasswordChange(String var1, String var2, String var3) throws SQLException {
        if (this.lifecycle != 1) {
            SQLException var7 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 8);
            var7.fillInStackTrace();
            throw var7;
        } else {
            byte[] var4 = var1 == null ? new byte[0] : DBConversion.stringToDriverCharBytes(var1, this.m_clientCharacterSet);
            byte[] var5 = var2 == null ? new byte[0] : DBConversion.stringToDriverCharBytes(var2, this.m_clientCharacterSet);
            byte[] var6 = var3 == null ? new byte[0] : DBConversion.stringToDriverCharBytes(var3, this.m_clientCharacterSet);
            this.sqlWarning = this.checkError(this.t2cPasswordChange(this.m_nativeState, var4, var4.length, var5, var5.length, var6, var6.length), this.sqlWarning);
        }
    }

    private void processOCIConnectionPooling() throws SQLException {
        if (this.lifecycle != 1) {
            SQLException var21 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 8);
            var21.fillInStackTrace();
            throw var21;
        } else {
            T2CConnection var1 = null;
            if (this.ociConnectionPoolLogonMode == "connection_pool") {
                if (this.nlsLangBackdoor) {
                    this.m_clientCharacterSet = getDriverCharSetIdFromNLS_LANG(this.ocidll);
                } else {
                    this.m_clientCharacterSet = getClientCharSetId();
                }
            } else {
                var1 = (T2CConnection)this.ociConnectionPoolObject;
                this.m_clientCharacterSet = var1.m_clientCharacterSet;
            }

            Object var2 = null;
            byte[] var3 = this.password == null ? new byte[0] : DBConversion.stringToDriverCharBytes(this.password, this.m_clientCharacterSet);
            byte[] var4 = this.editionName == null ? new byte[0] : DBConversion.stringToDriverCharBytes(this.editionName, this.m_clientCharacterSet);
            byte[] var5 = DBConversion.stringToDriverCharBytes(this.driverNameAttribute == null ? "jdbcoci" : this.driverNameAttribute, this.m_clientCharacterSet);
            byte[] var6 = DBConversion.stringToDriverCharBytes(this.database, this.m_clientCharacterSet);
            byte[] var7 = CharacterSetMetaData.getNLSLanguage(Locale.getDefault(Category.FORMAT)).getBytes();
            byte[] var8 = CharacterSetMetaData.getNLSTerritory(Locale.getDefault(Category.FORMAT)).getBytes();
            if (var7 != null && var8 != null) {
                long[] var22 = new long[]{(long)this.defaultLobPrefetchSize, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L};
                byte[] var20;
                SQLException var23;
                if (this.ociConnectionPoolLogonMode == "connection_pool") {
                    var20 = this.userName == null ? new byte[0] : DBConversion.stringToDriverCharBytes(this.userName, this.m_clientCharacterSet);
                    this.conversion = new DBConversion(this.m_clientCharacterSet, this.m_clientCharacterSet, this.m_clientCharacterSet);
                    this.logon_mode = 5;
                    if (this.lifecycle != 1) {
                        var23 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 0, "Internal Error: ");
                        var23.fillInStackTrace();
                        throw var23;
                    }

                    int[] var10 = new int[6];
                    OracleOCIConnectionPool.readPoolConfig(this.ociConnectionPoolMinLimit, this.ociConnectionPoolMaxLimit, this.ociConnectionPoolIncrement, this.ociConnectionPoolTimeout, this.ociConnectionPoolNoWait, this.ociConnectionPoolTransactionDistributed, var10);
                    this.sqlWarning = this.checkError(this.t2cCreateConnPool(var20, var20.length, var3, var3.length, var6, var6.length, this.m_clientCharacterSet, this.logon_mode, var10[0], var10[1], var10[2], var10[3], var10[4], var10[5]), this.sqlWarning);
                    this.versionNumber = 10000;
                } else if (this.ociConnectionPoolLogonMode == "connpool_connection") {
                    this.logon_mode = 6;
                    var20 = this.userName == null ? new byte[0] : DBConversion.stringToDriverCharBytes(this.userName, this.m_clientCharacterSet);
                    this.conversion = new DBConversion(this.m_clientCharacterSet, this.m_clientCharacterSet, this.m_clientCharacterSet);
                    this.sqlWarning = this.checkError(this.t2cConnPoolLogon(var1.m_nativeState, var20, var20.length, var3, var3.length, var4, var4.length, var5, var5.length, var6, var6.length, this.logon_mode, 0, 0, (String[])null, (byte[])null, 0, (byte[])null, 0, (byte[])null, 0, (byte[])null, 0, (byte[])null, 0, var7, var8, var22), this.sqlWarning);
                } else if (this.ociConnectionPoolLogonMode == "connpool_alias_connection") {
                    this.logon_mode = 8;
                    var23 = null;
                    byte[] var24 = (byte[])((byte[])this.ociConnectionPoolConnID);
                    var20 = this.userName == null ? new byte[0] : DBConversion.stringToDriverCharBytes(this.userName, this.m_clientCharacterSet);
                    this.conversion = new DBConversion(this.m_clientCharacterSet, this.m_clientCharacterSet, this.m_clientCharacterSet);
                    this.sqlWarning = this.checkError(this.t2cConnPoolLogon(var1.m_nativeState, var20, var20.length, var3, var3.length, var4, var4.length, var5, var5.length, var6, var6.length, this.logon_mode, 0, 0, (String[])null, (byte[])null, 0, (byte[])null, 0, (byte[])null, 0, (byte[])null, 0, var24, var24 == null ? 0 : var24.length, var7, var8, var22), this.sqlWarning);
                } else {
                    if (this.ociConnectionPoolLogonMode != "connpool_proxy_connection") {
                        var23 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 23, "connection-pool-logon");
                        var23.fillInStackTrace();
                        throw var23;
                    }

                    this.logon_mode = 7;
                    String var25 = this.ociConnectionPoolProxyType;
                    int var11 = this.ociConnectionPoolProxyNumRoles;
                    String[] var12 = null;
                    if (var11 > 0) {
                        var12 = (String[])((String[])this.ociConnectionPoolProxyRoles);
                    }

                    byte[] var13 = null;
                    byte[] var14 = null;
                    byte[] var15 = null;
                    byte[] var16 = null;
                    boolean var17 = false;
                    String var18;
                    byte var26;
                    if (var25 == "proxytype_user_name") {
                        var26 = 1;
                        var18 = this.ociConnectionPoolProxyUserName;
                        if (var18 != null) {
                            var13 = var18.getBytes();
                        }

                        var18 = this.ociConnectionPoolProxyPassword;
                        if (var18 != null) {
                            var14 = var18.getBytes();
                        }
                    } else if (var25 == "proxytype_distinguished_name") {
                        var26 = 2;
                        var18 = this.ociConnectionPoolProxyDistinguishedName;
                        if (var18 != null) {
                            var15 = var18.getBytes();
                        }
                    } else {
                        if (var25 != "proxytype_certificate") {
                            SQLException var19 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 107);
                            var19.fillInStackTrace();
                            throw var19;
                        }

                        var26 = 3;
                        var16 = (byte[])((byte[])this.ociConnectionPoolProxyCertificate);
                    }

                    var20 = this.userName == null ? new byte[0] : DBConversion.stringToDriverCharBytes(this.userName, this.m_clientCharacterSet);
                    this.conversion = new DBConversion(this.m_clientCharacterSet, this.m_clientCharacterSet, this.m_clientCharacterSet);
                    this.sqlWarning = this.checkError(this.t2cConnPoolLogon(var1.m_nativeState, var20, var20.length, var3, var3.length, var4, var4.length, var5, var5.length, var6, var6.length, this.logon_mode, var26, var11, var12, var13, var13 == null ? 0 : var13.length, var14, var14 == null ? 0 : var14.length, var15, var15 == null ? 0 : var15.length, var16, var16 == null ? 0 : var16.length, (byte[])null, 0, var7, var8, var22), this.sqlWarning);
                }

                this.conversion = new DBConversion((short)((int)(var22[2] & 65535L)), this.m_clientCharacterSet, (short)((int)(var22[3] & 65535L)));
                this.byteAlign = (byte)((int)(var22[4] & 255L));
                this.timeZoneVersionNumber = (int)var22[5];
                if (var22[6] != 0L) {
                    this.useOCIDefaultDefines = true;
                }

                this.tagMatched[0] = var22[7] != 0L;
                this.varTypeMaxLenCompat = (int)var22[8];
            } else {
                SQLException var9 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 176);
                var9.fillInStackTrace();
                throw var9;
            }
        }
    }

    public boolean isDescriptorSharable(OracleConnection var1) throws SQLException {
        PhysicalConnection var3 = (PhysicalConnection)((PhysicalConnection)var1.getPhysicalConnection());
        return this == var3;
    }

    native int t2cBlobRead(long var1, byte[] var3, int var4, long var5, int var7, byte[] var8, int var9, boolean var10, ByteBuffer var11);

    native int t2cClobRead(long var1, byte[] var3, int var4, long var5, int var7, char[] var8, int var9, boolean var10, boolean var11, ByteBuffer var12);

    native int t2cBlobWrite(long var1, byte[] var3, int var4, long var5, int var7, byte[] var8, int var9, byte[][] var10);

    native int t2cClobWrite(long var1, byte[] var3, int var4, long var5, int var7, char[] var8, int var9, byte[][] var10, boolean var11);

    native long t2cLobGetLength(long var1, byte[] var3, int var4);

    native int t2cBfileOpen(long var1, byte[] var3, int var4, byte[][] var5);

    native int t2cBfileIsOpen(long var1, byte[] var3, int var4, boolean[] var5);

    native int t2cBfileExists(long var1, byte[] var3, int var4, boolean[] var5);

    native String t2cBfileGetName(long var1, byte[] var3, int var4);

    native String t2cBfileGetDirAlias(long var1, byte[] var3, int var4);

    native int t2cBfileClose(long var1, byte[] var3, int var4, byte[][] var5);

    native int t2cLobGetChunkSize(long var1, byte[] var3, int var4);

    native int t2cLobTrim(long var1, int var3, long var4, byte[] var6, int var7, byte[][] var8);

    native int t2cLobCreateTemporary(long var1, int var3, boolean var4, int var5, short var6, byte[][] var7);

    native int t2cLobFreeTemporary(long var1, int var3, byte[] var4, int var5, byte[][] var6);

    native int t2cLobIsTemporary(long var1, int var3, byte[] var4, int var5, boolean[] var6);

    native int t2cLobOpen(long var1, int var3, byte[] var4, int var5, int var6, byte[][] var7);

    native int t2cLobIsOpen(long var1, int var3, byte[] var4, int var5, boolean[] var6);

    native int t2cLobClose(long var1, int var3, byte[] var4, int var5, byte[][] var6);

    private long lobLength(byte[] var1) throws SQLException {
        long var2 = 0L;
        var2 = this.t2cLobGetLength(this.m_nativeState, var1, var1.length);
        this.checkError((int)var2);
        return var2;
    }

    private int blobRead(byte[] var1, long var2, int var4, byte[] var5, boolean var6, ByteBuffer var7) throws SQLException {
        boolean var8 = false;
        int var9 = this.t2cBlobRead(this.m_nativeState, var1, var1.length, var2, var4, var5, var5.length, var6, var7);
        this.checkError(var9);
        return var9;
    }

    private int blobWrite(byte[] var1, long var2, byte[] var4, byte[][] var5, int var6, int var7) throws SQLException {
        boolean var8 = false;
        int var9 = this.t2cBlobWrite(this.m_nativeState, var1, var1.length, var2, var7, var4, var6, var5);
        this.checkError(var9);
        return var9;
    }

    private int clobWrite(byte[] var1, long var2, char[] var4, byte[][] var5, boolean var6, int var7, int var8) throws SQLException {
        boolean var9 = false;
        int var10 = this.t2cClobWrite(this.m_nativeState, var1, var1.length, var2, var8, var4, var7, var5, var6);
        this.checkError(var10);
        return var10;
    }

    private int lobGetChunkSize(byte[] var1) throws SQLException {
        boolean var2 = false;
        int var3 = this.t2cLobGetChunkSize(this.m_nativeState, var1, var1.length);
        this.checkError(var3);
        return var3;
    }

    public synchronized long length(BFILE var1) throws SQLException {
        byte[] var2 = null;
        this.checkTrue(this.lifecycle == 1, 8);
        this.checkTrue(var1 != null && (var2 = var1.getLocator()) != null, 54);
        return this.lobLength(var2);
    }

    public synchronized long position(BFILE var1, byte[] var2, long var3) throws SQLException {
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

    public synchronized long position(BFILE var1, BFILE var2, long var3) throws SQLException {
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
        byte[] var6 = null;
        this.checkTrue(this.lifecycle == 1, 8);
        this.checkTrue(var1 != null && (var6 = var1.getLocator()) != null, 54);
        if (var4 > 0 && var5 != null) {
            if (var4 > var5.length) {
                var4 = var5.length;
            }

            int var7;
            if (this.useNio) {
                var7 = var5.length;
                if (this.nioBufferForLob != null && this.nioBufferForLob.capacity() >= var7) {
                    this.nioBufferForLob.rewind();
                } else {
                    this.nioBufferForLob = ByteBuffer.allocateDirect(var7);
                }
            }

            var7 = this.blobRead(var6, var2, var4, var5, this.useNio, this.nioBufferForLob);
            if (this.useNio) {
                this.nioBufferForLob.get(var5);
            }

            return var7;
        } else {
            return 0;
        }
    }

    public synchronized String getName(BFILE var1) throws SQLException {
        byte[] var2 = null;
        String var3 = null;
        this.checkTrue(this.lifecycle == 1, 8);
        this.checkTrue(var1 != null && (var2 = var1.getLocator()) != null, 54);
        var3 = this.t2cBfileGetName(this.m_nativeState, var2, var2.length);
        this.checkError(var3.length());
        return var3;
    }

    public synchronized String getDirAlias(BFILE var1) throws SQLException {
        byte[] var2 = null;
        String var3 = null;
        this.checkTrue(this.lifecycle == 1, 8);
        this.checkTrue(var1 != null && (var2 = var1.getLocator()) != null, 54);
        var3 = this.t2cBfileGetDirAlias(this.m_nativeState, var2, var2.length);
        this.checkError(var3.length());
        return var3;
    }

    public synchronized void openFile(BFILE var1) throws SQLException {
        byte[] var2 = null;
        this.checkTrue(this.lifecycle == 1, 8);
        this.checkTrue(var1 != null && (var2 = var1.getLocator()) != null, 54);
        byte[][] var3 = new byte[1][];
        this.checkError(this.t2cBfileOpen(this.m_nativeState, var2, var2.length, var3));
        var1.setLocator(var3[0]);
    }

    public synchronized boolean isFileOpen(BFILE var1) throws SQLException {
        byte[] var2 = null;
        this.checkTrue(this.lifecycle == 1, 8);
        this.checkTrue(var1 != null && (var2 = var1.getLocator()) != null, 54);
        boolean[] var3 = new boolean[1];
        this.checkError(this.t2cBfileIsOpen(this.m_nativeState, var2, var2.length, var3));
        return var3[0];
    }

    public synchronized boolean fileExists(BFILE var1) throws SQLException {
        byte[] var2 = null;
        this.checkTrue(this.lifecycle == 1, 8);
        this.checkTrue(var1 != null && (var2 = var1.getLocator()) != null, 54);
        boolean[] var3 = new boolean[1];
        this.checkError(this.t2cBfileExists(this.m_nativeState, var2, var2.length, var3));
        return var3[0];
    }

    public synchronized void closeFile(BFILE var1) throws SQLException {
        byte[] var2 = null;
        this.checkTrue(this.lifecycle == 1, 8);
        this.checkTrue(var1 != null && (var2 = var1.getLocator()) != null, 54);
        byte[][] var3 = new byte[1][];
        this.checkError(this.t2cBfileClose(this.m_nativeState, var2, var2.length, var3));
        var1.setLocator(var3[0]);
    }

    public synchronized void open(BFILE var1, int var2) throws SQLException {
        byte[] var3 = null;
        this.checkTrue(this.lifecycle == 1, 8);
        this.checkTrue(var1 != null && (var3 = var1.shareBytes()) != null, 54);
        byte[][] var4 = new byte[1][];
        this.checkError(this.t2cLobOpen(this.m_nativeState, 114, var3, var3.length, var2, var4));
        var1.setShareBytes(var4[0]);
    }

    public synchronized void close(BFILE var1) throws SQLException {
        byte[] var2 = null;
        this.checkTrue(this.lifecycle == 1, 8);
        this.checkTrue(var1 != null && (var2 = var1.shareBytes()) != null, 54);
        byte[][] var3 = new byte[1][];
        this.checkError(this.t2cLobClose(this.m_nativeState, 114, var2, var2.length, var3));
        var1.setShareBytes(var3[0]);
    }

    public synchronized boolean isOpen(BFILE var1) throws SQLException {
        byte[] var2 = null;
        this.checkTrue(this.lifecycle == 1, 8);
        this.checkTrue(var1 != null && (var2 = var1.shareBytes()) != null, 54);
        boolean[] var3 = new boolean[1];
        this.checkError(this.t2cLobIsOpen(this.m_nativeState, 114, var2, var2.length, var3));
        return var3[0];
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
        this.checkTrue(var1 != null && var1.shareBytes() != null, 54);
        OracleConversionInputStream var3 = new OracleConversionInputStream(this.conversion, var1.getBinaryStream(), var2);
        return var3;
    }

    public Reader newConversionReader(BFILE var1, int var2) throws SQLException {
        return this.newConversionReader((OracleBfile)var1, var2);
    }

    public Reader newConversionReader(OracleBfile var1, int var2) throws SQLException {
        this.checkTrue(var1 != null && var1.shareBytes() != null, 54);
        OracleConversionReader var3 = new OracleConversionReader(this.conversion, var1.getBinaryStream(), var2);
        return var3;
    }

    public synchronized long length(BLOB var1) throws SQLException {
        byte[] var2 = null;
        this.checkTrue(this.lifecycle == 1, 8);
        this.checkTrue(var1 != null && (var2 = var1.getLocator()) != null, 54);
        return this.lobLength(var2);
    }

    public synchronized long position(BLOB var1, byte[] var2, long var3) throws SQLException {
        this.checkTrue(this.lifecycle == 1, 8);
        this.checkTrue(var1 != null && var1.shareBytes() != null, 54);
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

    public synchronized long position(BLOB var1, BLOB var2, long var3) throws SQLException {
        this.checkTrue(this.lifecycle == 1, 8);
        this.checkTrue(var1 != null && var1.shareBytes() != null, 54);
        this.checkTrue(var2 != null && var2.shareBytes() != null, 54);
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
        byte[] var6 = null;
        int var7 = 0;
        this.checkTrue(this.lifecycle == 1, 8);
        this.checkTrue(var1 != null && (var6 = var1.getLocator()) != null, 54);
        if (var4 > 0 && var5 != null) {
            if (var4 > var5.length) {
                var4 = var5.length;
            }

            long var8 = -1L;
            byte[] var10;
            int var11;
            if (var1.isActivePrefetch()) {
                var10 = var1.getPrefetchedData();
                var8 = var1.length();
                if (var10 != null && var10.length > 0 && var2 > 0L && var2 <= (long)var10.length) {
                    var11 = Math.min(var10.length - (int)var2 + 1, var4);
                    System.arraycopy(var10, (int)var2 - 1, var5, 0, var11);
                    var7 += var11;
                }
            }

            if (var7 < var4 && (var8 == -1L || var2 - 1L + (long)var7 < var8)) {
                var10 = var5;
                var11 = var7;
                int var12 = (var8 > 0L && var8 < (long)var4 ? (int)var8 : var4) - var7;
                if (var7 > 0) {
                    var10 = new byte[var12];
                }

                if (this.useNio) {
                    int var13 = var5.length;
                    if (this.nioBufferForLob != null && this.nioBufferForLob.capacity() >= var13) {
                        this.nioBufferForLob.rewind();
                    } else {
                        this.nioBufferForLob = ByteBuffer.allocateDirect(var13);
                    }
                }

                var7 += this.blobRead(var6, var2 + (long)var7, var12, var10, this.useNio, this.nioBufferForLob);
                if (this.useNio) {
                    this.nioBufferForLob.get(var10);
                }

                if (var11 > 0) {
                    System.arraycopy(var10, 0, var5, var11, var10.length);
                }
            }

            return var7;
        } else {
            return 0;
        }
    }

    public synchronized int putBytes(BLOB var1, long var2, byte[] var4, int var5, int var6) throws SQLException {
        this.checkTrue(var2 != 0L || var6 > 0, 68);
        this.checkTrue(var2 >= 0L, 68);
        if (var4 != null && var6 > 0) {
            boolean var7 = false;
            int var10;
            if (var4 != null && var4.length != 0 && var6 > 0) {
                byte[] var8 = null;
                this.checkTrue(this.lifecycle == 1, 8);
                this.checkTrue(var1 != null && (var8 = var1.getLocator()) != null, 54);
                byte[][] var9 = new byte[1][];
                var1.setActivePrefetch(false);
                var1.clearCachedData();
                var10 = this.blobWrite(var8, var2, var4, var9, var5, var6);
                var1.setLocator(var9[0]);
            } else {
                var10 = 0;
            }

            return var10;
        } else {
            return 0;
        }
    }

    public synchronized int getChunkSize(BLOB var1) throws SQLException {
        byte[] var2 = null;
        this.checkTrue(this.lifecycle == 1, 8);
        this.checkTrue(var1 != null && (var2 = var1.getLocator()) != null, 54);
        return this.lobGetChunkSize(var2);
    }

    public synchronized void trim(BLOB var1, long var2) throws SQLException {
        byte[] var4 = null;
        this.checkTrue(this.lifecycle == 1, 8);
        this.checkTrue(var1 != null && (var4 = var1.shareBytes()) != null, 54);
        byte[][] var5 = new byte[1][];
        var1.setActivePrefetch(false);
        var1.clearCachedData();
        this.checkError(this.t2cLobTrim(this.m_nativeState, 113, var2, var4, var4.length, var5));
        var1.setShareBytes(var5[0]);
    }

    public synchronized BLOB createTemporaryBlob(Connection var1, boolean var2, int var3) throws SQLException {
        BLOB var4 = null;
        this.checkTrue(this.lifecycle == 1, 8);
        var4 = new BLOB((PhysicalConnection)var1);
        byte[][] var5 = new byte[1][];
        this.checkError(this.t2cLobCreateTemporary(this.m_nativeState, 113, var2, var3, (short)0, var5));
        var4.setShareBytes(var5[0]);
        return var4;
    }

    public synchronized void freeTemporary(BLOB var1, boolean var2) throws SQLException {
        try {
            byte[] var3 = null;
            this.checkTrue(this.lifecycle == 1, 8);
            this.checkTrue(var1 != null && (var3 = var1.shareBytes()) != null, 54);
            byte[][] var4 = new byte[1][];
            this.checkError(this.t2cLobFreeTemporary(this.m_nativeState, 113, var3, var3.length, var4));
            var1.setShareBytes(var4[0]);
        } catch (SQLException var5) {
            if (!(var2 & var5.getErrorCode() == 64201)) {
                throw var5;
            }

            LobPlsqlUtil.freeTemporaryLob(this, var1, 2004);
        }

    }

    public synchronized boolean isTemporary(BLOB var1) throws SQLException {
        byte[] var2 = null;
        this.checkTrue(var1 != null && (var2 = var1.shareBytes()) != null, 54);
        boolean[] var3 = new boolean[1];
        this.checkError(this.t2cLobIsTemporary(this.m_nativeState, 113, var2, var2.length, var3));
        return var3[0];
    }

    public synchronized void open(BLOB var1, int var2) throws SQLException {
        byte[] var3 = null;
        this.checkTrue(this.lifecycle == 1, 8);
        this.checkTrue(var1 != null && (var3 = var1.shareBytes()) != null, 54);
        byte[][] var4 = new byte[1][];
        this.checkError(this.t2cLobOpen(this.m_nativeState, 113, var3, var3.length, var2, var4));
        var1.setShareBytes(var4[0]);
    }

    public synchronized void close(BLOB var1) throws SQLException {
        byte[] var2 = null;
        this.checkTrue(this.lifecycle == 1, 8);
        this.checkTrue(var1 != null && (var2 = var1.shareBytes()) != null, 54);
        byte[][] var3 = new byte[1][];
        this.checkError(this.t2cLobClose(this.m_nativeState, 113, var2, var2.length, var3));
        var1.setShareBytes(var3[0]);
    }

    public synchronized boolean isOpen(BLOB var1) throws SQLException {
        byte[] var2 = null;
        this.checkTrue(this.lifecycle == 1, 8);
        this.checkTrue(var1 != null && (var2 = var1.shareBytes()) != null, 54);
        boolean[] var3 = new boolean[1];
        this.checkError(this.t2cLobIsOpen(this.m_nativeState, 113, var2, var2.length, var3));
        return var3[0];
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
        this.checkTrue(var1 != null && var1.shareBytes() != null, 54);
        OracleConversionInputStream var3 = new OracleConversionInputStream(this.conversion, var1.getBinaryStream(), var2);
        return var3;
    }

    public Reader newConversionReader(BLOB var1, int var2) throws SQLException {
        return this.newConversionReader((OracleBlob)var1, var2);
    }

    public Reader newConversionReader(OracleBlob var1, int var2) throws SQLException {
        this.checkTrue(var1 != null && var1.shareBytes() != null, 54);
        OracleConversionReader var3 = new OracleConversionReader(this.conversion, var1.getBinaryStream(), var2);
        return var3;
    }

    public synchronized long length(CLOB var1) throws SQLException {
        byte[] var2 = null;
        this.checkTrue(this.lifecycle == 1, 8);
        this.checkTrue(var1 != null && (var2 = var1.getLocator()) != null, 54);
        return this.lobLength(var2);
    }

    public synchronized long position(CLOB var1, String var2, long var3) throws SQLException {
        SQLException var8;
        if (var2 == null) {
            var8 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 68);
            var8.fillInStackTrace();
            throw var8;
        } else {
            this.checkTrue(this.lifecycle == 1, 8);
            this.checkTrue(var1 != null && var1.shareBytes() != null, 54);
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

    public synchronized long position(CLOB var1, CLOB var2, long var3) throws SQLException {
        this.checkTrue(this.lifecycle == 1, 8);
        this.checkTrue(var1 != null && var1.shareBytes() != null, 54);
        this.checkTrue(var2 != null && var2.shareBytes() != null, 54);
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

    public synchronized int getChars(CLOB var1, long var2, int var4, char[] var5) throws SQLException {
        byte[] var6 = null;
        this.checkTrue(this.lifecycle == 1, 8);
        this.checkTrue(var1 != null && (var6 = var1.getLocator()) != null, 54);
        if (var4 > 0 && var5 != null) {
            if (var4 > var5.length) {
                var4 = var5.length;
            }

            int var7 = 0;
            long var8 = -1L;
            char[] var10;
            int var13;
            if (var1.isActivePrefetch()) {
                var8 = var1.length();
                var10 = var1.getPrefetchedData();
                long var11 = (long)var1.getPrefetchedDataSize();
                if (var10 != null && var2 <= var11) {
                    var13 = Math.min((int)var11 - (int)var2 + 1, var4);
                    System.arraycopy(var10, (int)var2 - 1, var5, 0, var13);
                    var7 += var13;
                }
            }

            if (var7 < var4 && (var8 == -1L || var2 - 1L + (long)var7 < var8)) {
                var10 = var5;
                int var15 = var7;
                int var12 = (var8 > 0L && var8 < (long)var4 ? (int)var8 : var4) - var7;
                if (var7 > 0) {
                    var10 = new char[var12];
                }

                if (this.useNio) {
                    var13 = var5.length * 2;
                    if (this.nioBufferForLob != null && this.nioBufferForLob.capacity() >= var13) {
                        this.nioBufferForLob.rewind();
                    } else {
                        this.nioBufferForLob = ByteBuffer.allocateDirect(var13);
                    }
                }

                var7 += this.t2cClobRead(this.m_nativeState, var6, var6.length, var2 + (long)var7, var12, var10, var10.length, var1.isNCLOB(), this.useNio, this.nioBufferForLob);
                if (this.useNio) {
                    ByteBuffer var16 = this.nioBufferForLob.order(ByteOrder.LITTLE_ENDIAN);
                    CharBuffer var14 = var16.asCharBuffer();
                    var14.get(var10);
                }

                if (var15 > 0) {
                    System.arraycopy(var10, 0, var5, var15, var10.length);
                }

                this.checkError(var7);
            }

            return var7;
        } else {
            return 0;
        }
    }

    public synchronized int putChars(CLOB var1, long var2, char[] var4, int var5, int var6) throws SQLException {
        byte[] var7 = null;
        this.checkTrue(this.lifecycle == 1, 8);
        this.checkTrue(var2 >= 0L, 68);
        this.checkTrue(var1 != null && (var7 = var1.getLocator()) != null, 54);
        if (var4 == null) {
            return 0;
        } else {
            byte[][] var8 = new byte[1][];
            var1.setActivePrefetch(false);
            var1.clearCachedData();
            int var9 = this.clobWrite(var7, var2, var4, var8, var1.isNCLOB(), var5, var6);
            var1.setLocator(var8[0]);
            return var9;
        }
    }

    public synchronized int getChunkSize(CLOB var1) throws SQLException {
        byte[] var2 = null;
        this.checkTrue(this.lifecycle == 1, 8);
        this.checkTrue(var1 != null && (var2 = var1.getLocator()) != null, 54);
        return this.lobGetChunkSize(var2);
    }

    public synchronized void trim(CLOB var1, long var2) throws SQLException {
        byte[] var4 = null;
        this.checkTrue(this.lifecycle == 1, 8);
        this.checkTrue(var1 != null && (var4 = var1.shareBytes()) != null, 54);
        byte[][] var5 = new byte[1][];
        var1.setActivePrefetch(false);
        var1.clearCachedData();
        this.checkError(this.t2cLobTrim(this.m_nativeState, 112, var2, var4, var4.length, var5));
        var1.setShareBytes(var5[0]);
    }

    public synchronized CLOB createTemporaryClob(Connection var1, boolean var2, int var3, short var4) throws SQLException {
        Object var5 = null;
        this.checkTrue(this.lifecycle == 1, 8);
        if (var4 == 1) {
            var5 = new CLOB((PhysicalConnection)var1);
        } else {
            var5 = new NCLOB((PhysicalConnection)var1);
        }

        byte[][] var6 = new byte[1][];
        this.checkError(this.t2cLobCreateTemporary(this.m_nativeState, 112, var2, var3, var4, var6));
        ((CLOB)var5).setShareBytes(var6[0]);
        return (CLOB)var5;
    }

    public synchronized void freeTemporary(CLOB var1, boolean var2) throws SQLException {
        try {
            byte[] var3 = null;
            this.checkTrue(this.lifecycle == 1, 8);
            this.checkTrue(var1 != null && (var3 = var1.shareBytes()) != null, 54);
            byte[][] var4 = new byte[1][];
            this.checkError(this.t2cLobFreeTemporary(this.m_nativeState, 112, var3, var3.length, var4));
            var1.setShareBytes(var4[0]);
        } catch (SQLException var5) {
            if (!(var2 & var5.getErrorCode() == 64201)) {
                throw var5;
            }

            LobPlsqlUtil.freeTemporaryLob(this, var1, 2005);
        }

    }

    public synchronized boolean isTemporary(CLOB var1) throws SQLException {
        byte[] var2 = null;
        this.checkTrue(var1 != null && (var2 = var1.shareBytes()) != null, 54);
        boolean[] var3 = new boolean[1];
        this.checkError(this.t2cLobIsTemporary(this.m_nativeState, 112, var2, var2.length, var3));
        return var3[0];
    }

    public synchronized void open(CLOB var1, int var2) throws SQLException {
        byte[] var3 = null;
        this.checkTrue(this.lifecycle == 1, 8);
        this.checkTrue(var1 != null && (var3 = var1.shareBytes()) != null, 54);
        byte[][] var4 = new byte[1][];
        this.checkError(this.t2cLobOpen(this.m_nativeState, 112, var3, var3.length, var2, var4));
        var1.setShareBytes(var4[0]);
    }

    public synchronized void close(CLOB var1) throws SQLException {
        byte[] var2 = null;
        this.checkTrue(this.lifecycle == 1, 8);
        this.checkTrue(var1 != null && (var2 = var1.shareBytes()) != null, 54);
        byte[][] var3 = new byte[1][];
        this.checkError(this.t2cLobClose(this.m_nativeState, 112, var2, var2.length, var3));
        var1.setShareBytes(var3[0]);
    }

    public synchronized boolean isOpen(CLOB var1) throws SQLException {
        byte[] var2 = null;
        this.checkTrue(this.lifecycle == 1, 8);
        this.checkTrue(var1 != null && (var2 = var1.shareBytes()) != null, 54);
        boolean[] var3 = new boolean[1];
        this.checkError(this.t2cLobIsOpen(this.m_nativeState, 112, var2, var2.length, var3));
        return var3[0];
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

    public synchronized void registerTAFCallback(OracleOCIFailover var1, Object var2) throws SQLException {
        this.appCallback = var1;
        this.appCallbackObject = var2;
        this.checkError(this.t2cRegisterTAFCallback(this.m_nativeState));
    }

    synchronized int callTAFCallbackMethod(int var1, int var2) {
        int var3 = 0;
        if (this.appCallback != null) {
            var3 = this.appCallback.callbackFn(this, this.appCallbackObject, var1, var2);
        }

        return var3;
    }

    public int getHeapAllocSize() throws SQLException {
        if (this.lifecycle != 1) {
            SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 8);
            var3.fillInStackTrace();
            throw var3;
        } else {
            int var1 = this.t2cGetHeapAllocSize(this.m_nativeState);
            if (var1 < 0) {
                SQLException var2;
                if (var1 == -999) {
                    var2 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 23);
                    var2.fillInStackTrace();
                    throw var2;
                } else {
                    var2 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 89);
                    var2.fillInStackTrace();
                    throw var2;
                }
            } else {
                return var1;
            }
        }
    }

    public int getOCIEnvHeapAllocSize() throws SQLException {
        if (this.lifecycle != 1) {
            SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 8);
            var3.fillInStackTrace();
            throw var3;
        } else {
            int var1 = this.t2cGetOciEnvHeapAllocSize(this.m_nativeState);
            if (var1 < 0) {
                SQLException var2;
                if (var1 == -999) {
                    var2 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 23);
                    var2.fillInStackTrace();
                    throw var2;
                } else {
                    this.checkError(var1);
                    var2 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 89);
                    var2.fillInStackTrace();
                    throw var2;
                }
            } else {
                return var1;
            }
        }
    }

    public static final short getClientCharSetId() {
        return 871;
    }

    public static short getDriverCharSetIdFromNLS_LANG(String var0) throws SQLException {
        if (!isLibraryLoaded) {
            loadNativeLibrary(var0);
        }

        short var1 = t2cGetDriverCharSetFromNlsLang();
        if (var1 < 0) {
            SQLException var2 = DatabaseError.createSqlException((OracleConnection)null, 8);
            var2.fillInStackTrace();
            throw var2;
        } else {
            return var1;
        }
    }

    void doProxySession(int var1, Properties var2) throws SQLException {
        byte[][] var7 = (byte[][])null;
        int var12 = 0;
        this.savedUser = this.userName;
        this.userName = null;
        byte[] var4;
        byte[] var5;
        byte[] var6;
        byte[] var3 = var4 = var5 = var6 = new byte[0];
        switch(var1) {
            case 1:
                this.userName = var2.getProperty("PROXY_USER_NAME");
                String var8 = var2.getProperty("PROXY_USER_PASSWORD");
                if (this.userName != null) {
                    var3 = DBConversion.stringToDriverCharBytes(this.userName, this.m_clientCharacterSet);
                }

                if (var8 != null) {
                    var4 = DBConversion.stringToDriverCharBytes(var8, this.m_clientCharacterSet);
                }
                break;
            case 2:
                String var9 = var2.getProperty("PROXY_DISTINGUISHED_NAME");
                if (var9 != null) {
                    var5 = DBConversion.stringToDriverCharBytes(var9, this.m_clientCharacterSet);
                }
                break;
            case 3:
                Object var10 = var2.get("PROXY_CERTIFICATE");
                var6 = (byte[])((byte[])var10);
        }

        String[] var11 = (String[])((String[])var2.get("PROXY_ROLES"));
        if (var11 != null) {
            var12 = var11.length;
            var7 = new byte[var12][];

            for(int var13 = 0; var13 < var12; ++var13) {
                if (var11[var13] == null) {
                    SQLException var14 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 150);
                    var14.fillInStackTrace();
                    throw var14;
                }

                var7[var13] = DBConversion.stringToDriverCharBytes(var11[var13], this.m_clientCharacterSet);
            }
        }

        this.sqlWarning = this.checkError(this.t2cDoProxySession(this.m_nativeState, var1, var3, var3.length, var4, var4.length, var5, var5.length, var6, var6.length, var12, var7), this.sqlWarning);
        this.isProxy = true;
    }

    void closeProxySession() throws SQLException {
        this.checkError(this.t2cCloseProxySession(this.m_nativeState));
        this.userName = this.savedUser;
    }

    protected void doDescribeTable(AutoKeyInfo var1) throws SQLException {
        String var2 = var1.getTableName();
        byte[] var3 = DBConversion.stringToDriverCharBytes(var2, this.m_clientCharacterSet);

        boolean var4;
        int var5;
        do {
            var4 = false;
            var5 = t2cDescribeTable(this.m_nativeState, var3, var3.length, this.queryMetaData1, this.queryMetaData2, this.queryMetaData1Offset, this.queryMetaData2Offset, this.queryMetaData1Size, this.queryMetaData2Size);
            if (var5 == -1) {
                this.checkError(var5);
            }

            if (var5 == T2CStatement.T2C_EXTEND_BUFFER) {
                var4 = true;
                this.reallocateQueryMetaData(this.queryMetaData1Size * 2, this.queryMetaData2Size * 2);
            }
        } while(var4);

        this.processDescribeTableData(var5, var1);
    }

    private void processDescribeTableData(int var1, AutoKeyInfo var2) throws SQLException {
        short[] var3 = this.queryMetaData1;
        byte[] var4 = this.queryMetaData2;
        int var5 = this.queryMetaData1Offset;
        int var6 = this.queryMetaData2Offset;
        var2.allocateSpaceForDescribedData(var1);

        for(int var19 = 0; var19 < var1; ++var19) {
            short var9 = var3[var5 + 0];
            short var8 = var3[var5 + 6];
            String var7 = bytes2String(var4, var6, var8, this.conversion);
            short var10 = var3[var5 + 1];
            short var11 = var3[var5 + 11];
            boolean var12 = var3[var5 + 2] != 0;
            short var13 = var3[var5 + 5];
            short var14 = var3[var5 + 3];
            short var15 = var3[var5 + 4];
            short var17 = var3[var5 + 12];
            boolean var18 = var3[var5 + 13] != 0;
            var6 += var8;
            var5 += 14;
            String var16 = null;
            if (var17 > 0) {
                var16 = bytes2String(var4, var6, var17, this.conversion);
                var6 += var17;
            }

            var2.fillDescribedData(var19, var7, var9, var11 > 0 ? var11 : var10, var12, var13, var14, var15, var16);
        }

    }

    void doSetApplicationContext(String var1, String var2, String var3) throws SQLException {
        this.checkError(this.t2cSetApplicationContext(this.m_nativeState, var1, var2, var3));
    }

    void doClearAllApplicationContext(String var1) throws SQLException {
        this.checkError(this.t2cClearAllApplicationContext(this.m_nativeState, var1));
    }

    void doStartup(int var1) throws SQLException {
        this.checkError(this.t2cStartupDatabase(this.m_nativeState, var1));
    }

    void doShutdown(int var1) throws SQLException {
        this.checkError(this.t2cShutdownDatabase(this.m_nativeState, var1));
    }

    private static final void loadNativeLibrary(String var0) throws SQLException {
        Class var1;
        if (var0 != null && !var0.equals("ocijdbc12")) {
            var1 = T2CConnection.class;
            synchronized(T2CConnection.class) {
                try {
                    System.loadLibrary(var0);
                    isLibraryLoaded = true;
                } catch (SecurityException var5) {
                    if (!isLibraryLoaded) {
                        System.loadLibrary(var0);
                        isLibraryLoaded = true;
                    }
                }
            }
        } else {
            var1 = T2CConnection.class;
            synchronized(T2CConnection.class) {
                if (!isLibraryLoaded) {
                    AccessController.doPrivileged(new PrivilegedAction() {
                        public Object run() {
                            System.loadLibrary("ocijdbc12");
                            int var1 = T2CConnection.getLibraryVersionNumber();
                            if ((long)var1 != T2CConnection.JDBC_OCI_LIBRARY_VERSION) {
                                throw new Error("Incompatible version of libocijdbc[Jdbc:" + T2CConnection.JDBC_OCI_LIBRARY_VERSION + ", Jdbc-OCI:" + var1);
                            } else {
                                return null;
                            }
                        }
                    });
                    isLibraryLoaded = true;
                }
            }
        }

    }

    private final void checkTrue(boolean var1, int var2) throws SQLException {
        if (!var1) {
            SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), var2);
            var3.fillInStackTrace();
            throw var3;
        }
    }

    boolean useLittleEndianSetCHARBinder() throws SQLException {
        return this.t2cPlatformIsLittleEndian(this.m_nativeState);
    }

    public void getPropertyForPooledConnection(OraclePooledConnection var1) throws SQLException {
        super.getPropertyForPooledConnection(var1, this.password);
    }

    static final char[] getCharArray(String var0) {
        Object var1 = null;
        char[] var2;
        if (var0 == null) {
            var2 = new char[0];
        } else {
            var2 = new char[var0.length()];
            var0.getChars(0, var0.length(), var2, 0);
        }

        return var2;
    }

    static String bytes2String(byte[] var0, int var1, int var2, DBConversion var3) throws SQLException {
        byte[] var4 = new byte[var2];
        System.arraycopy(var0, var1, var4, 0, var2);
        return var3.CharBytesToString(var4, var2);
    }

    void disableNio() {
        this.useNio = false;
    }

    private static synchronized void doSetSessionTimeZone(String var0) throws SQLException {
        t2cSetSessionTimeZone(var0);
    }

    public void incrementTempLobReferenceCount(byte[] var1) throws SQLException {
    }

    public int decrementTempLobReferenceCount(byte[] var1) throws SQLException {
        return 0;
    }

    void releaseConnectionToPool() throws SQLException {
        if (this.drcpEnabled && this.drcpState == DrcpState.STATEFUL) {
            this.drcpState = DrcpState.STATELESS;
            byte var1 = 0;
            byte[] var2 = EMPTY_BYTES;
            if (this.drcpTagName != null) {
                this.tagMatched[0] = false;
                var2 = DBConversion.stringToDriverCharBytes(this.drcpTagName, this.m_clientCharacterSet);
                var1 = 2;
            } else {
                this.tagMatched[0] = true;
            }

            this.checkError(this.t2cCloseDrcpConnection(this.m_nativeState, var2, var2.length, var1), this.sqlWarning);
        }
    }

    boolean reusePooledConnection() throws SQLException {
        if (this.drcpState != DrcpState.STATEFUL) {
            this.drcpState = DrcpState.STATEFUL;
            byte[] var1 = EMPTY_BYTES;
            if (this.drcpTagName != null) {
                var1 = DBConversion.stringToDriverCharBytes(this.drcpTagName, this.m_clientCharacterSet);
            }

            this.checkError(this.t2cOpenDrcpConnection(this.m_nativeState, var1, var1.length, this.tagMatched), this.sqlWarning);
        }

        return this.tagMatched[0];
    }

    public boolean needToPurgeStatementCache() throws SQLException {
        if (this.lifecycle != 1) {
            SQLException var1 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 8);
            var1.fillInStackTrace();
            throw var1;
        } else {
            return !this.drcpEnabled ? true : true;
        }
    }

    public String getCurrentSchema() throws SQLException {
        if (this.lifecycle != 1) {
            SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 8);
            var3.fillInStackTrace();
            throw var3;
        } else {
            byte[] var1 = new byte[258];
            int var2;
            this.checkError(var2 = this.t2cGetSchemaName(this.m_nativeState, var1));
            return var2 > 0 ? this.conversion.CharBytesToString(var1, var2) : this.userName;
        }
    }

    static native int getLibraryVersionNumber();

    static native short t2cGetServerSessionInfo(long var0, Properties var2);

    static native short t2cGetDriverCharSetFromNlsLang();

    native int t2cDescribeError(long var1, T2CError var3, byte[] var4);

    native int t2cCreateState(byte[] var1, int var2, byte[] var3, int var4, byte[] var5, int var6, byte[] var7, int var8, byte[] var9, int var10, byte[] var11, int var12, byte[] var13, int var14, byte[] var15, int var16, byte[] var17, int var18, short var19, int var20, byte[] var21, byte[] var22, byte[] var23, long[] var24);

    native int t2cLogon(long var1, byte[] var3, int var4, byte[] var5, int var6, byte[] var7, int var8, byte[] var9, int var10, byte[] var11, int var12, byte[] var13, int var14, byte[] var15, int var16, byte[] var17, int var18, byte[] var19, int var20, int var21, byte[] var22, byte[] var23, byte[] var24, long[] var25);

    private native int t2cLogoff(long var1);

    private native int t2cCancel(long var1);

    private native byte t2cGetAsmVolProperty(long var1);

    private native byte t2cGetInstanceType(long var1);

    private native int t2cCreateStatement(long var1, long var3, byte[] var5, int var6, OracleStatement var7, boolean var8, int var9);

    private native int t2cSetAutoCommit(long var1, boolean var3);

    private native int t2cCommit(long var1, int var3);

    private native int t2cRollback(long var1);

    private native int t2cPingDatabase(long var1);

    private native byte[] t2cGetProductionVersion(long var1);

    private native int t2cGetVersionNumber(long var1);

    private native int t2cGetDefaultStreamChunkSize(long var1);

    native int t2cGetFormOfUse(long var1, OracleTypeCLOB var3, byte[] var4, int var5, int var6);

    native long t2cGetTDO(long var1, byte[] var3, int var4, int[] var5);

    native int t2cCreateConnPool(byte[] var1, int var2, byte[] var3, int var4, byte[] var5, int var6, short var7, int var8, int var9, int var10, int var11, int var12, int var13, int var14);

    native int t2cConnPoolLogon(long var1, byte[] var3, int var4, byte[] var5, int var6, byte[] var7, int var8, byte[] var9, int var10, byte[] var11, int var12, int var13, int var14, int var15, String[] var16, byte[] var17, int var18, byte[] var19, int var20, byte[] var21, int var22, byte[] var23, int var24, byte[] var25, int var26, byte[] var27, byte[] var28, long[] var29);

    native int t2cGetConnPoolInfo(long var1, Properties var3);

    native int t2cSetConnPoolInfo(long var1, int var3, int var4, int var5, int var6, int var7, int var8);

    native int t2cPasswordChange(long var1, byte[] var3, int var4, byte[] var5, int var6, byte[] var7, int var8);

    protected native byte[] t2cGetConnectionId(long var1);

    native int t2cGetHandles(long var1, long[] var3);

    native int t2cUseConnection(long var1, long var3, long var5, long var7, byte[] var9, long[] var10);

    native boolean t2cPlatformIsLittleEndian(long var1);

    native int t2cRegisterTAFCallback(long var1);

    native int t2cGetHeapAllocSize(long var1);

    native int t2cGetOciEnvHeapAllocSize(long var1);

    native int t2cDoProxySession(long var1, int var3, byte[] var4, int var5, byte[] var6, int var7, byte[] var8, int var9, byte[] var10, int var11, int var12, byte[][] var13);

    native int t2cCloseProxySession(long var1);

    static native int t2cDescribeTable(long var0, byte[] var2, int var3, short[] var4, byte[] var5, int var6, int var7, int var8, int var9);

    native int t2cSetApplicationContext(long var1, String var3, String var4, String var5);

    native int t2cClearAllApplicationContext(long var1, String var3);

    native int t2cStartupDatabase(long var1, int var3);

    native int t2cShutdownDatabase(long var1, int var3);

    static native void t2cSetSessionTimeZone(String var0);

    native int t2cCloseDrcpConnection(long var1, byte[] var3, int var4, int var5);

    native int t2cOpenDrcpConnection(long var1, byte[] var3, int var4, boolean[] var5);

    native int t2cSetCachedServerVersion(long var1, short var3);

    native int t2cGetImplicitResultSetStatement(long var1, long var3, OracleStatement var5);

    native int t2cGetSchemaName(long var1, byte[] var3);
}
