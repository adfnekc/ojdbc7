//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package oracle.jdbc.driver;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.io.StringReader;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.URL;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.sql.Array;
import java.sql.BatchUpdateException;
import java.sql.Blob;
import java.sql.Clob;
import java.sql.Date;
import java.sql.NClob;
import java.sql.ParameterMetaData;
import java.sql.Ref;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.RowId;
import java.sql.SQLData;
import java.sql.SQLException;
import java.sql.SQLXML;
import java.sql.Statement;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Locale;
import java.util.TimeZone;
import oracle.jdbc.OracleData;
import oracle.jdbc.driver.OracleResultSet.ResultSetType;
import oracle.jdbc.internal.ObjectData;
import oracle.jdbc.internal.OracleStatement.SqlKind;
import oracle.jdbc.oracore.OracleTypeADT;
import oracle.jdbc.oracore.OracleTypeCOLLECTION;
import oracle.jdbc.oracore.OracleTypeNUMBER;
import oracle.jdbc.proxy.ProxyFactory;
import oracle.jdbc.proxy._Proxy_;
import oracle.sql.ARRAY;
import oracle.sql.ArrayDescriptor;
import oracle.sql.BFILE;
import oracle.sql.BINARY_DOUBLE;
import oracle.sql.BINARY_FLOAT;
import oracle.sql.BLOB;
import oracle.sql.CHAR;
import oracle.sql.CLOB;
import oracle.sql.CharacterSet;
import oracle.sql.CustomDatum;
import oracle.sql.DATE;
import oracle.sql.Datum;
import oracle.sql.INTERVALDS;
import oracle.sql.INTERVALYM;
import oracle.sql.NUMBER;
import oracle.sql.OPAQUE;
import oracle.sql.ORAData;
import oracle.sql.OpaqueDescriptor;
import oracle.sql.RAW;
import oracle.sql.REF;
import oracle.sql.ROWID;
import oracle.sql.STRUCT;
import oracle.sql.StructDescriptor;
import oracle.sql.TIMESTAMP;
import oracle.sql.TIMESTAMPLTZ;
import oracle.sql.TIMESTAMPTZ;

abstract class OraclePreparedStatement extends OracleStatement implements oracle.jdbc.internal.OraclePreparedStatement {
    int numberOfBindRowsAllocated;
    static Binder theStaticVarnumCopyingBinder;
    static Binder theStaticVarnumNullBinder;
    Binder theVarnumNullBinder;
    static Binder theStaticBooleanBinder;
    Binder theBooleanBinder;
    static Binder theStaticByteBinder;
    Binder theByteBinder;
    static Binder theStaticShortBinder;
    Binder theShortBinder;
    static Binder theStaticIntBinder;
    Binder theIntBinder;
    static Binder theStaticLongBinder;
    Binder theLongBinder;
    static Binder theStaticFloatBinder;
    Binder theFloatBinder;
    static Binder theStaticDoubleBinder;
    Binder theDoubleBinder;
    static Binder theStaticBigDecimalBinder;
    Binder theBigDecimalBinder;
    static Binder theStaticVarcharCopyingBinder;
    static Binder theStaticVarcharNullBinder;
    Binder theVarcharNullBinder;
    static Binder theStaticStringBinder;
    Binder theStringBinder;
    static Binder theStaticSetCHARCopyingBinder;
    static Binder theStaticSetCHARBinder;
    static Binder theStaticLittleEndianSetCHARBinder;
    static Binder theStaticSetCHARNullBinder;
    Binder theSetCHARBinder;
    Binder theSetCHARNullBinder;
    static Binder theStaticFixedCHARCopyingBinder;
    static Binder theStaticFixedCHARBinder;
    static Binder theStaticFixedCHARNullBinder;
    Binder theFixedCHARBinder;
    Binder theFixedCHARNullBinder;
    static Binder theStaticDateCopyingBinder;
    static Binder theStaticDateBinder;
    static Binder theStaticDateNullBinder;
    Binder theDateBinder;
    Binder theDateNullBinder;
    static Binder theStaticTimeCopyingBinder;
    static Binder theStaticTimeBinder;
    Binder theTimeBinder;
    static Binder theStaticTimestampCopyingBinder;
    static Binder theStaticTimestampBinder;
    static Binder theStaticTimestampNullBinder;
    Binder theTimestampBinder;
    Binder theTimestampNullBinder;
    static Binder theStaticOracleNumberBinder;
    Binder theOracleNumberBinder;
    static Binder theStaticOracleDateBinder;
    Binder theOracleDateBinder;
    static Binder theStaticOracleTimestampBinder;
    Binder theOracleTimestampBinder;
    static Binder theStaticTSTZCopyingBinder;
    static Binder theStaticTSTZBinder;
    static Binder theStaticTSTZNullBinder;
    Binder theTSTZBinder;
    Binder theTSTZNullBinder;
    static Binder theStaticTSLTZCopyingBinder;
    static Binder theStaticTSLTZBinder;
    static Binder theStaticTSLTZNullBinder;
    Binder theTSLTZBinder;
    Binder theTSLTZNullBinder;
    static Binder theStaticRowidCopyingBinder;
    static Binder theStaticRowidBinder;
    static Binder theStaticLittleEndianRowidBinder;
    static Binder theStaticRowidNullBinder;
    static Binder theStaticURowidNullBinder;
    Binder theRowidBinder;
    Binder theRowidNullBinder;
    Binder theURowidBinder;
    Binder theURowidNullBinder;
    static Binder theStaticIntervalDSCopyingBinder;
    static Binder theStaticIntervalDSBinder;
    static Binder theStaticIntervalDSNullBinder;
    Binder theIntervalDSBinder;
    Binder theIntervalDSNullBinder;
    static Binder theStaticIntervalYMCopyingBinder;
    static Binder theStaticIntervalYMBinder;
    static Binder theStaticIntervalYMNullBinder;
    Binder theIntervalYMBinder;
    Binder theIntervalYMNullBinder;
    static Binder theStaticBfileCopyingBinder;
    static Binder theStaticBfileBinder;
    static Binder theStaticBfileNullBinder;
    Binder theBfileBinder;
    Binder theBfileNullBinder;
    static Binder theStaticBlobCopyingBinder;
    static Binder theStaticBlobBinder;
    static Binder theStaticBlobNullBinder;
    Binder theBlobBinder;
    Binder theBlobNullBinder;
    static Binder theStaticClobCopyingBinder;
    static Binder theStaticClobBinder;
    static Binder theStaticClobNullBinder;
    Binder theClobBinder;
    Binder theClobNullBinder;
    static Binder theStaticRawCopyingBinder;
    static Binder theStaticRawBinder;
    static Binder theStaticRawNullBinder;
    Binder theRawBinder;
    Binder theRawNullBinder;
    static Binder theStaticPlsqlRawCopyingBinder;
    static Binder theStaticPlsqlRawBinder;
    Binder thePlsqlRawBinder;
    static Binder theStaticBinaryFloatCopyingBinder;
    static Binder theStaticBinaryFloatBinder;
    static Binder theStaticBinaryFloatNullBinder;
    Binder theBinaryFloatBinder;
    Binder theBinaryFloatNullBinder;
    static Binder theStaticBINARY_FLOATCopyingBinder;
    static Binder theStaticBINARY_FLOATBinder;
    static Binder theStaticBINARY_FLOATNullBinder;
    Binder theBINARY_FLOATBinder;
    Binder theBINARY_FLOATNullBinder;
    static Binder theStaticBinaryDoubleCopyingBinder;
    static Binder theStaticBinaryDoubleBinder;
    static Binder theStaticBinaryDoubleNullBinder;
    Binder theBinaryDoubleBinder;
    Binder theBinaryDoubleNullBinder;
    static Binder theStaticBINARY_DOUBLECopyingBinder;
    static Binder theStaticBINARY_DOUBLEBinder;
    static Binder theStaticBINARY_DOUBLENullBinder;
    Binder theBINARY_DOUBLEBinder;
    Binder theBINARY_DOUBLENullBinder;
    static Binder theStaticLongStreamBinder;
    Binder theLongStreamBinder;
    static Binder theStaticLongStreamForStringBinder;
    Binder theLongStreamForStringBinder;
    static Binder theStaticLongStreamForStringCopyingBinder;
    static Binder theStaticLongRawStreamBinder;
    Binder theLongRawStreamBinder;
    static Binder theStaticLongRawStreamForBytesBinder;
    Binder theLongRawStreamForBytesBinder;
    static Binder theStaticLongRawStreamForBytesCopyingBinder;
    static Binder theStaticNamedTypeCopyingBinder;
    static Binder theStaticNamedTypeBinder;
    static Binder theStaticNamedTypeNullBinder;
    Binder theNamedTypeBinder;
    Binder theNamedTypeNullBinder;
    static Binder theStaticRefTypeCopyingBinder;
    static Binder theStaticRefTypeBinder;
    static Binder theStaticRefTypeNullBinder;
    Binder theRefTypeBinder;
    Binder theRefTypeNullBinder;
    static Binder theStaticPlsqlIbtCopyingBinder;
    static Binder theStaticPlsqlIbtBinder;
    static Binder theStaticPlsqlIbtNullBinder;
    Binder thePlsqlIbtBinder;
    Binder thePlsqlNullBinder;
    static Binder theStaticOutBinder;
    Binder theOutBinder;
    static Binder theStaticReturnParamBinder;
    Binder theReturnParamBinder;
    static Binder theStaticT4CRowidBinder;
    static Binder theStaticT4CURowidBinder;
    static Binder theStaticT4CRowidNullBinder;
    static Binder theStaticT4CURowidNullBinder;
    private static final TimeZone UTC_TIME_ZONE;
    private static final Calendar UTC_US_CALENDAR;
    protected Calendar cachedUTCUSCalendar;
    public static final int TypeBinder_BYTELEN = 24;
    char[] digits;
    Binder[][] binders;
    int[][] parameterInt;
    long[][] parameterLong;
    float[][] parameterFloat;
    double[][] parameterDouble;
    BigDecimal[][] parameterBigDecimal;
    String[][] parameterString;
    Date[][] parameterDate;
    Time[][] parameterTime;
    Timestamp[][] parameterTimestamp;
    byte[][][] parameterDatum;
    OracleTypeADT[][] parameterOtype;
    CLOB[] lastBoundClobs;
    BLOB[] lastBoundBlobs;
    PlsqlIbtBindInfo[][] parameterPlsqlIbt;
    Binder[] currentRowBinders;
    int[] currentRowByteLens;
    int[] currentRowCharLens;
    Accessor[] currentRowBindAccessors;
    short[] currentRowFormOfUse;
    boolean currentRowNeedToPrepareBinds;
    int[] currentBatchByteLens;
    int[] currentBatchCharLens;
    Accessor[] currentBatchBindAccessors;
    short[] currentBatchFormOfUse;
    boolean currentBatchNeedToPrepareBinds;
    int currentBatchAccumulatedBindsSize;
    static final int BATCH_SIZE_THRESHOLD = 2097152;
    OraclePreparedStatement.PushedBatch pushedBatches;
    OraclePreparedStatement.PushedBatch pushedBatchesTail;
    int cachedBindByteSize;
    int cachedBindCharSize;
    int cachedBindIndicatorSize;
    int totalBindByteLength;
    int totalBindCharLength;
    int totalBindIndicatorLength;
    static final int BIND_METADATA_NUMBER_OF_BIND_POSITIONS_OFFSET = 0;
    static final int BIND_METADATA_BIND_BUFFER_CAPACITY_OFFSET_HI = 1;
    static final int BIND_METADATA_BIND_BUFFER_CAPACITY_OFFSET_LO = 2;
    static final int BIND_METADATA_NUMBER_OF_BOUND_ROWS_OFFSET_HI = 3;
    static final int BIND_METADATA_NUMBER_OF_BOUND_ROWS_OFFSET_LO = 4;
    static final int BIND_METADATA_PER_POSITION_DATA_OFFSET = 5;
    static final int BIND_METADATA_TYPE_OFFSET = 0;
    static final int BIND_METADATA_BYTE_PITCH_OFFSET = 1;
    static final int BIND_METADATA_CHAR_PITCH_OFFSET = 2;
    static final int BIND_METADATA_VALUE_DATA_OFFSET_HI = 3;
    static final int BIND_METADATA_VALUE_DATA_OFFSET_LO = 4;
    static final int BIND_METADATA_NULL_INDICATORS_OFFSET_HI = 5;
    static final int BIND_METADATA_NULL_INDICATORS_OFFSET_LO = 6;
    static final int BIND_METADATA_VALUE_LENGTHS_OFFSET_HI = 7;
    static final int BIND_METADATA_VALUE_LENGTHS_OFFSET_LO = 8;
    static final int BIND_METADATA_FORM_OF_USE_OFFSET = 9;
    static final int BIND_METADATA_PER_POSITION_SIZE = 10;
    static final int SETLOB_NO_LENGTH = -1;
    int bindBufferCapacity;
    int numberOfBoundRows;
    int indicatorsOffset;
    int valueLengthsOffset;
    boolean preparedAllBinds;
    boolean preparedByteBinds;
    boolean preparedCharBinds;
    Binder[] lastBinders;
    byte[] lastBoundBytes;
    int lastBoundByteOffset;
    char[] lastBoundChars;
    int lastBoundCharOffset;
    int[] lastBoundByteOffsets;
    int[] lastBoundCharOffsets;
    int[] lastBoundByteLens;
    int[] lastBoundCharLens;
    short[] lastBoundInds;
    short[] lastBoundLens;
    boolean lastBoundNeeded;
    byte[][] lastBoundTypeBytes;
    OracleTypeADT[] lastBoundTypeOtypes;
    InputStream[] lastBoundStream;
    private static final int STREAM_MAX_BYTES_SQL = 2147483647;
    int maxRawBytesSql;
    int maxRawBytesPlsql;
    int maxVcsCharsSql;
    int maxVcsNCharsSql;
    int maxVcsBytesPlsql;
    private int maxCharSize;
    private int maxNCharSize;
    private int charMaxCharsSql;
    private int charMaxNCharsSql;
    protected int maxVcsCharsPlsql;
    private int maxVcsNCharsPlsql;
    int maxIbtVarcharElementLength;
    private int maxStreamCharsSql;
    private int maxStreamNCharsSql;
    protected boolean isServerCharSetFixedWidth;
    private boolean isServerNCharSetFixedWidth;
    int minVcsBindSize;
    int prematureBatchCount;
    boolean checkBindTypes;
    boolean scrollRsetTypeSolved;
    private static final double MIN_NUMBER = 1.0E-130D;
    private static final double MAX_NUMBER = 1.0E126D;
    int SetBigStringTryClob;
    static final int BSTYLE_UNKNOWN = 0;
    static final int BSTYLE_ORACLE = 1;
    static final int BSTYLE_JDBC = 2;
    int m_batchStyle;
    private static final String _Copyright_2007_Oracle_All_Rights_Reserved_;
    public static final String BUILD_DATE = "Thu_Apr_04_15:09:24_PDT_2013";
    public static final boolean TRACE = false;

    OraclePreparedStatement(PhysicalConnection var1, String var2, int var3, int var4) throws SQLException {
        this(var1, var2, var3, var4, 1003, 1007);
        this.cacheState = 1;
    }

    OraclePreparedStatement(PhysicalConnection var1, String var2, int var3, int var4, int var5, int var6) throws SQLException {
        super(var1, var3, var4, var5, var6);
        this.theVarnumNullBinder = theStaticVarnumNullBinder;
        this.theBooleanBinder = theStaticBooleanBinder;
        this.theByteBinder = theStaticByteBinder;
        this.theShortBinder = theStaticShortBinder;
        this.theIntBinder = theStaticIntBinder;
        this.theLongBinder = theStaticLongBinder;
        this.theFloatBinder = null;
        this.theDoubleBinder = null;
        this.theBigDecimalBinder = theStaticBigDecimalBinder;
        this.theVarcharNullBinder = theStaticVarcharNullBinder;
        this.theStringBinder = theStaticStringBinder;
        this.theSetCHARNullBinder = theStaticSetCHARNullBinder;
        this.theFixedCHARBinder = theStaticFixedCHARBinder;
        this.theFixedCHARNullBinder = theStaticFixedCHARNullBinder;
        this.theDateBinder = theStaticDateBinder;
        this.theDateNullBinder = theStaticDateNullBinder;
        this.theTimeBinder = theStaticTimeBinder;
        this.theTimestampBinder = theStaticTimestampBinder;
        this.theTimestampNullBinder = theStaticTimestampNullBinder;
        this.theOracleNumberBinder = theStaticOracleNumberBinder;
        this.theOracleDateBinder = theStaticOracleDateBinder;
        this.theOracleTimestampBinder = theStaticOracleTimestampBinder;
        this.theTSTZBinder = theStaticTSTZBinder;
        this.theTSTZNullBinder = theStaticTSTZNullBinder;
        this.theTSLTZBinder = theStaticTSLTZBinder;
        this.theTSLTZNullBinder = theStaticTSLTZNullBinder;
        this.theRowidNullBinder = theStaticRowidNullBinder;
        this.theURowidNullBinder = theStaticURowidNullBinder;
        this.theIntervalDSBinder = theStaticIntervalDSBinder;
        this.theIntervalDSNullBinder = theStaticIntervalDSNullBinder;
        this.theIntervalYMBinder = theStaticIntervalYMBinder;
        this.theIntervalYMNullBinder = theStaticIntervalYMNullBinder;
        this.theBfileBinder = theStaticBfileBinder;
        this.theBfileNullBinder = theStaticBfileNullBinder;
        this.theBlobBinder = theStaticBlobBinder;
        this.theBlobNullBinder = theStaticBlobNullBinder;
        this.theClobBinder = theStaticClobBinder;
        this.theClobNullBinder = theStaticClobNullBinder;
        this.theRawBinder = theStaticRawBinder;
        this.theRawNullBinder = theStaticRawNullBinder;
        this.thePlsqlRawBinder = theStaticPlsqlRawBinder;
        this.theBinaryFloatBinder = theStaticBinaryFloatBinder;
        this.theBinaryFloatNullBinder = theStaticBinaryFloatNullBinder;
        this.theBINARY_FLOATBinder = theStaticBINARY_FLOATBinder;
        this.theBINARY_FLOATNullBinder = theStaticBINARY_FLOATNullBinder;
        this.theBinaryDoubleBinder = theStaticBinaryDoubleBinder;
        this.theBinaryDoubleNullBinder = theStaticBinaryDoubleNullBinder;
        this.theBINARY_DOUBLEBinder = theStaticBINARY_DOUBLEBinder;
        this.theBINARY_DOUBLENullBinder = theStaticBINARY_DOUBLENullBinder;
        this.theLongStreamBinder = theStaticLongStreamBinder;
        this.theLongStreamForStringBinder = theStaticLongStreamForStringBinder;
        this.theLongRawStreamBinder = theStaticLongRawStreamBinder;
        this.theLongRawStreamForBytesBinder = theStaticLongRawStreamForBytesBinder;
        this.theNamedTypeBinder = theStaticNamedTypeBinder;
        this.theNamedTypeNullBinder = theStaticNamedTypeNullBinder;
        this.theRefTypeBinder = theStaticRefTypeBinder;
        this.theRefTypeNullBinder = theStaticRefTypeNullBinder;
        this.thePlsqlIbtBinder = theStaticPlsqlIbtBinder;
        this.thePlsqlNullBinder = theStaticPlsqlIbtNullBinder;
        this.theOutBinder = theStaticOutBinder;
        this.theReturnParamBinder = theStaticReturnParamBinder;
        this.cachedUTCUSCalendar = (Calendar)UTC_US_CALENDAR.clone();
        this.digits = new char[20];
        this.currentRowNeedToPrepareBinds = true;
        this.cachedBindByteSize = 0;
        this.cachedBindCharSize = 0;
        this.cachedBindIndicatorSize = 0;
        this.lastBoundNeeded = false;
        this.maxCharSize = 0;
        this.maxNCharSize = 0;
        this.charMaxCharsSql = 0;
        this.charMaxNCharsSql = 0;
        this.maxVcsCharsPlsql = 0;
        this.maxVcsNCharsPlsql = 0;
        this.maxIbtVarcharElementLength = 0;
        this.maxStreamCharsSql = 0;
        this.maxStreamNCharsSql = 0;
        this.isServerCharSetFixedWidth = false;
        this.isServerNCharSetFixedWidth = false;
        this.checkBindTypes = true;
        this.SetBigStringTryClob = 0;
        this.m_batchStyle = 0;
        this.cacheState = 1;
        if (var3 > 1) {
            this.setOracleBatchStyle();
        }

        this.theSetCHARBinder = var1.useLittleEndianSetCHARBinder() ? theStaticLittleEndianSetCHARBinder : theStaticSetCHARBinder;
        this.theURowidBinder = this.theRowidBinder = var1.useLittleEndianSetCHARBinder() ? theStaticLittleEndianRowidBinder : theStaticRowidBinder;
        this.statementType = 1;
        this.needToParse = true;
        this.processEscapes = var1.processEscapes;
        this.sqlObject.initialize(var2);
        this.sqlKind = this.sqlObject.getSqlKind();
        this.clearParameters = true;
        this.scrollRsetTypeSolved = false;
        this.prematureBatchCount = 0;
        this.initializeBinds();
        this.minVcsBindSize = var1.minVcsBindSize;
        this.maxRawBytesSql = var1.maxRawBytesSql;
        this.maxRawBytesPlsql = var1.maxRawBytesPlsql;
        this.maxVcsCharsSql = var1.maxVcsCharsSql;
        this.maxVcsNCharsSql = var1.maxVcsNCharsSql;
        this.maxVcsBytesPlsql = var1.maxVcsBytesPlsql;
        this.maxIbtVarcharElementLength = var1.maxIbtVarcharElementLength;
        this.maxCharSize = this.connection.conversion.sMaxCharSize;
        this.maxNCharSize = this.connection.conversion.maxNCharSize;
        this.maxVcsCharsPlsql = this.maxVcsBytesPlsql / this.maxCharSize;
        this.maxVcsNCharsPlsql = this.maxVcsBytesPlsql / this.maxNCharSize;
        this.maxStreamCharsSql = 2147483647 / this.maxCharSize;
        this.maxStreamNCharsSql = this.maxRawBytesSql / this.maxNCharSize;
        this.isServerCharSetFixedWidth = this.connection.conversion.isServerCharSetFixedWidth;
        this.isServerNCharSetFixedWidth = this.connection.conversion.isServerNCharSetFixedWidth;
    }

    void allocBinds(int var1) throws SQLException {
        boolean var2 = var1 > this.numberOfBindRowsAllocated;
        this.initializeIndicatorSubRange();
        int var3 = this.bindIndicatorSubRange + 5 + this.numberOfBindPositions * 10;
        int var4 = var1 * this.numberOfBindPositions;
        int var5 = var3 + 2 * var4;
        int var7;
        if (var5 > this.totalBindIndicatorLength) {
            short[] var6 = this.bindIndicators;
            var7 = this.bindIndicatorOffset;
            this.bindIndicatorOffset = 0;
            this.bindIndicators = new short[var5];
            this.totalBindIndicatorLength = var5;
            if (var6 != null && var2) {
                System.arraycopy(var6, var7, this.bindIndicators, this.bindIndicatorOffset, var3);
            }
        }

        this.bindIndicatorSubRange += this.bindIndicatorOffset;
        this.bindIndicators[this.bindIndicatorSubRange + 0] = (short)this.numberOfBindPositions;
        this.indicatorsOffset = this.bindIndicatorOffset + var3;
        this.valueLengthsOffset = this.indicatorsOffset + var4;
        int var10 = this.indicatorsOffset;
        var7 = this.valueLengthsOffset;
        int var8 = this.bindIndicatorSubRange + 5;

        for(int var9 = 0; var9 < this.numberOfBindPositions; ++var9) {
            this.bindIndicators[var8 + 5] = (short)(var10 >> 16);
            this.bindIndicators[var8 + 6] = (short)(var10 & '\uffff');
            this.bindIndicators[var8 + 7] = (short)(var7 >> 16);
            this.bindIndicators[var8 + 8] = (short)(var7 & '\uffff');
            var10 += var1;
            var7 += var1;
            var8 += 10;
        }

    }

    void initializeBinds() throws SQLException {
        this.numberOfBindPositions = this.sqlObject.getParameterCount();
        this.numReturnParams = this.sqlObject.getReturnParameterCount();
        if (this.numberOfBindPositions == 0) {
            this.currentRowNeedToPrepareBinds = false;
        } else {
            this.numberOfBindRowsAllocated = this.batch;
            this.binders = new Binder[this.numberOfBindRowsAllocated][this.numberOfBindPositions];
            this.currentRowBinders = this.binders[0];
            this.currentRowByteLens = new int[this.numberOfBindPositions];
            this.currentBatchByteLens = new int[this.numberOfBindPositions];
            this.currentRowCharLens = new int[this.numberOfBindPositions];
            this.currentBatchCharLens = new int[this.numberOfBindPositions];
            this.currentRowFormOfUse = new short[this.numberOfBindPositions];
            this.currentBatchFormOfUse = new short[this.numberOfBindPositions];
            this.lastBoundClobs = new CLOB[this.numberOfBindPositions];
            this.lastBoundBlobs = new BLOB[this.numberOfBindPositions];
            byte var1 = 1;
            if (this.connection.defaultnchar) {
                var1 = 2;
            }

            for(int var2 = 0; var2 < this.numberOfBindPositions; ++var2) {
                this.currentRowFormOfUse[var2] = var1;
                this.currentBatchFormOfUse[var2] = var1;
            }

            this.lastBinders = new Binder[this.numberOfBindPositions];
            this.lastBoundCharLens = new int[this.numberOfBindPositions];
            this.lastBoundByteOffsets = new int[this.numberOfBindPositions];
            this.lastBoundCharOffsets = new int[this.numberOfBindPositions];
            this.lastBoundByteLens = new int[this.numberOfBindPositions];
            this.lastBoundInds = new short[this.numberOfBindPositions];
            this.lastBoundLens = new short[this.numberOfBindPositions];
            this.lastBoundTypeBytes = new byte[this.numberOfBindPositions][];
            this.lastBoundTypeOtypes = new OracleTypeADT[this.numberOfBindPositions];
            this.allocBinds(this.numberOfBindRowsAllocated);
        }
    }

    void growBinds(int var1) throws SQLException {
        Binder[][] var3 = this.binders;
        this.binders = new Binder[var1][];
        if (var3 != null) {
            System.arraycopy(var3, 0, this.binders, 0, this.numberOfBindRowsAllocated);
        }

        int var2;
        for(var2 = this.numberOfBindRowsAllocated; var2 < var1; ++var2) {
            this.binders[var2] = new Binder[this.numberOfBindPositions];
        }

        this.allocBinds(var1);
        if (this.parameterInt != null) {
            int[][] var4 = this.parameterInt;
            this.parameterInt = new int[var1][];
            System.arraycopy(var4, 0, this.parameterInt, 0, this.numberOfBindRowsAllocated);

            for(var2 = this.numberOfBindRowsAllocated; var2 < var1; ++var2) {
                this.parameterInt[var2] = new int[this.numberOfBindPositions];
            }
        }

        if (this.parameterLong != null) {
            long[][] var5 = this.parameterLong;
            this.parameterLong = new long[var1][];
            System.arraycopy(var5, 0, this.parameterLong, 0, this.numberOfBindRowsAllocated);

            for(var2 = this.numberOfBindRowsAllocated; var2 < var1; ++var2) {
                this.parameterLong[var2] = new long[this.numberOfBindPositions];
            }
        }

        if (this.parameterFloat != null) {
            float[][] var6 = this.parameterFloat;
            this.parameterFloat = new float[var1][];
            System.arraycopy(var6, 0, this.parameterFloat, 0, this.numberOfBindRowsAllocated);

            for(var2 = this.numberOfBindRowsAllocated; var2 < var1; ++var2) {
                this.parameterFloat[var2] = new float[this.numberOfBindPositions];
            }
        }

        if (this.parameterDouble != null) {
            double[][] var7 = this.parameterDouble;
            this.parameterDouble = new double[var1][];
            System.arraycopy(var7, 0, this.parameterDouble, 0, this.numberOfBindRowsAllocated);

            for(var2 = this.numberOfBindRowsAllocated; var2 < var1; ++var2) {
                this.parameterDouble[var2] = new double[this.numberOfBindPositions];
            }
        }

        if (this.parameterBigDecimal != null) {
            BigDecimal[][] var8 = this.parameterBigDecimal;
            this.parameterBigDecimal = new BigDecimal[var1][];
            System.arraycopy(var8, 0, this.parameterBigDecimal, 0, this.numberOfBindRowsAllocated);

            for(var2 = this.numberOfBindRowsAllocated; var2 < var1; ++var2) {
                this.parameterBigDecimal[var2] = new BigDecimal[this.numberOfBindPositions];
            }
        }

        if (this.parameterString != null) {
            String[][] var9 = this.parameterString;
            this.parameterString = new String[var1][];
            System.arraycopy(var9, 0, this.parameterString, 0, this.numberOfBindRowsAllocated);

            for(var2 = this.numberOfBindRowsAllocated; var2 < var1; ++var2) {
                this.parameterString[var2] = new String[this.numberOfBindPositions];
            }
        }

        if (this.parameterDate != null) {
            Date[][] var10 = this.parameterDate;
            this.parameterDate = new Date[var1][];
            System.arraycopy(var10, 0, this.parameterDate, 0, this.numberOfBindRowsAllocated);

            for(var2 = this.numberOfBindRowsAllocated; var2 < var1; ++var2) {
                this.parameterDate[var2] = new Date[this.numberOfBindPositions];
            }
        }

        if (this.parameterTime != null) {
            Time[][] var11 = this.parameterTime;
            this.parameterTime = new Time[var1][];
            System.arraycopy(var11, 0, this.parameterTime, 0, this.numberOfBindRowsAllocated);

            for(var2 = this.numberOfBindRowsAllocated; var2 < var1; ++var2) {
                this.parameterTime[var2] = new Time[this.numberOfBindPositions];
            }
        }

        if (this.parameterTimestamp != null) {
            Timestamp[][] var12 = this.parameterTimestamp;
            this.parameterTimestamp = new Timestamp[var1][];
            System.arraycopy(var12, 0, this.parameterTimestamp, 0, this.numberOfBindRowsAllocated);

            for(var2 = this.numberOfBindRowsAllocated; var2 < var1; ++var2) {
                this.parameterTimestamp[var2] = new Timestamp[this.numberOfBindPositions];
            }
        }

        if (this.parameterDatum != null) {
            byte[][][] var13 = this.parameterDatum;
            this.parameterDatum = new byte[var1][][];
            System.arraycopy(var13, 0, this.parameterDatum, 0, this.numberOfBindRowsAllocated);

            for(var2 = this.numberOfBindRowsAllocated; var2 < var1; ++var2) {
                this.parameterDatum[var2] = new byte[this.numberOfBindPositions][];
            }
        }

        if (this.parameterOtype != null) {
            OracleTypeADT[][] var14 = this.parameterOtype;
            this.parameterOtype = new OracleTypeADT[var1][];
            System.arraycopy(var14, 0, this.parameterOtype, 0, this.numberOfBindRowsAllocated);

            for(var2 = this.numberOfBindRowsAllocated; var2 < var1; ++var2) {
                this.parameterOtype[var2] = new OracleTypeADT[this.numberOfBindPositions];
            }
        }

        if (this.parameterStream != null) {
            InputStream[][] var15 = this.parameterStream;
            this.parameterStream = new InputStream[var1][];
            System.arraycopy(var15, 0, this.parameterStream, 0, this.numberOfBindRowsAllocated);

            for(var2 = this.numberOfBindRowsAllocated; var2 < var1; ++var2) {
                this.parameterStream[var2] = new InputStream[this.numberOfBindPositions];
            }
        }

        if (this.userStream != null) {
            Object[][] var16 = this.userStream;
            this.userStream = new Object[var1][];
            System.arraycopy(var16, 0, this.userStream, 0, this.numberOfBindRowsAllocated);

            for(var2 = this.numberOfBindRowsAllocated; var2 < var1; ++var2) {
                this.userStream[var2] = new Object[this.numberOfBindPositions];
            }
        }

        if (this.parameterPlsqlIbt != null) {
            PlsqlIbtBindInfo[][] var17 = this.parameterPlsqlIbt;
            this.parameterPlsqlIbt = new PlsqlIbtBindInfo[var1][];
            System.arraycopy(var17, 0, this.parameterPlsqlIbt, 0, this.numberOfBindRowsAllocated);

            for(var2 = this.numberOfBindRowsAllocated; var2 < var1; ++var2) {
                this.parameterPlsqlIbt[var2] = new PlsqlIbtBindInfo[this.numberOfBindPositions];
            }
        }

        this.numberOfBindRowsAllocated = var1;
        this.currentRowNeedToPrepareBinds = true;
    }

    void processCompletedBindRow(int var1, boolean var2) throws SQLException {
        if (this.numberOfBindPositions != 0) {
            boolean var4 = false;
            boolean var5 = false;
            boolean var6 = false;
            boolean var7 = this.currentRank == this.firstRowInBatch;
            Binder[] var8 = this.currentRank == 0 ? (this.lastBinders[0] == null ? null : this.lastBinders) : this.binders[this.currentRank - 1];
            int var3;
            short var12;
            Binder var15;
            SQLException var16;
            SQLException var17;
            SQLException var21;
            if (this.currentRowBindAccessors == null) {
                boolean var9 = this.isAutoGeneratedKey && this.clearParameters;
                if (var8 == null) {
                    for(var3 = 0; var3 < this.numberOfBindPositions; ++var3) {
                        if (this.currentRowBinders[var3] == null) {
                            if (!var9) {
                                var16 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 41, var3 + 1);
                                var16.fillInStackTrace();
                                throw var16;
                            }

                            this.registerReturnParamsForAutoKey();
                            var9 = false;
                        }
                    }
                } else if (!this.checkBindTypes) {
                    for(var3 = 0; var3 < this.numberOfBindPositions; ++var3) {
                        var15 = this.currentRowBinders[var3];
                        if (var15 == null) {
                            if (this.clearParameters) {
                                var17 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 41, var3 + 1);
                                var17.fillInStackTrace();
                                throw var17;
                            }

                            this.currentRowBinders[var3] = var8[var3].copyingBinder();
                            if (this.currentRank == 0) {
                                this.currentRowBinders[var3].lastBoundValueCleanup(this, var3);
                            }

                            this.currentRowByteLens[var3] = -1;
                            this.currentRowCharLens[var3] = -1;
                            var5 = true;
                        }
                    }
                } else {
                    OracleTypeADT[] var10 = this.currentRank == 0 ? this.lastBoundTypeOtypes : (this.parameterOtype == null ? null : this.parameterOtype[this.currentRank - 1]);

                    for(var3 = 0; var3 < this.numberOfBindPositions; ++var3) {
                        if (this.currentRowBinders[var3] == null && var9) {
                            this.registerReturnParamsForAutoKey();
                            var9 = false;
                        }

                        Binder var11 = this.currentRowBinders[var3];
                        if (var11 == null) {
                            if (this.clearParameters) {
                                var21 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 41, var3 + 1);
                                var21.fillInStackTrace();
                                throw var21;
                            }

                            this.currentRowBinders[var3] = var8[var3].copyingBinder();
                            if (this.currentRank == 0) {
                                this.currentRowBinders[var3].lastBoundValueCleanup(this, var3);
                            }

                            this.currentRowByteLens[var3] = -1;
                            this.currentRowCharLens[var3] = -1;
                            var5 = true;
                        } else {
                            var12 = var11.type;
                            if (var12 != var8[var3].type || (var12 == 109 || var12 == 111) && !this.parameterOtype[this.currentRank][var3].isInHierarchyOf(var10[var3]) || var12 == 9 && var11.bytelen == 0 != (var8[var3].bytelen == 0)) {
                                var4 = true;
                            }
                        }

                        if (this.currentBatchFormOfUse[var3] != this.currentRowFormOfUse[var3]) {
                            var4 = true;
                        }
                    }
                }

                if (var5 && (var7 || this.m_batchStyle == 2)) {
                    this.lastBoundNeeded = true;
                }
            } else {
                Binder var14;
                if (var8 == null) {
                    for(var3 = 0; var3 < this.numberOfBindPositions; ++var3) {
                        var14 = this.currentRowBinders[var3];
                        Accessor var20 = this.currentRowBindAccessors[var3];
                        if (var14 == null) {
                            if (var20 == null) {
                                var17 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 41, var3 + 1);
                                var17.fillInStackTrace();
                                throw var17;
                            }

                            this.currentRowBinders[var3] = this.theOutBinder;
                        } else if (var20 != null && !this.isDefineTypeCompatibleWithBindType(var20.defineType, var14.type)) {
                            var6 = true;
                        }
                    }
                } else if (!this.checkBindTypes) {
                    for(var3 = 0; var3 < this.numberOfBindPositions; ++var3) {
                        var14 = this.currentRowBinders[var3];
                        if (var14 == null) {
                            if (this.clearParameters && var8[var3] != this.theOutBinder) {
                                var16 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 41, var3 + 1);
                                var16.fillInStackTrace();
                                throw var16;
                            }

                            var14 = var8[var3];
                            this.currentRowBinders[var3] = var14;
                            this.currentRowByteLens[var3] = -1;
                            this.currentRowCharLens[var3] = -1;
                            if (var14 != this.theOutBinder) {
                                var5 = true;
                            }
                        }

                        if (this.currentRowBindAccessors[var3] == null) {
                            this.currentRowBindAccessors[var3] = this.currentBatchBindAccessors[var3];
                        }
                    }
                } else {
                    OracleTypeADT[] var13 = this.currentRank == 0 ? this.lastBoundTypeOtypes : (this.parameterOtype == null ? null : this.parameterOtype[this.currentRank - 1]);

                    for(var3 = 0; var3 < this.numberOfBindPositions; ++var3) {
                        var15 = this.currentRowBinders[var3];
                        Accessor var19 = this.currentRowBindAccessors[var3];
                        if (var15 == null) {
                            if (this.clearParameters && var8[var3] != this.theOutBinder) {
                                var21 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 41, var3 + 1);
                                var21.fillInStackTrace();
                                throw var21;
                            }

                            var15 = var8[var3];
                            this.currentRowBinders[var3] = var15;
                            this.currentRowByteLens[var3] = -1;
                            this.currentRowCharLens[var3] = -1;
                            if (var15 != this.theOutBinder) {
                                var5 = true;
                            }
                        } else {
                            var12 = var15.type;
                            if (var12 != var8[var3].type || (var12 == 109 || var12 == 111) && !this.parameterOtype[this.currentRank][var3].isInHierarchyOf(var13[var3]) || var12 == 9 && var15.bytelen == 0 != (var8[var3].bytelen == 0)) {
                                var4 = true;
                            }
                        }

                        if (this.currentBatchFormOfUse[var3] != this.currentRowFormOfUse[var3]) {
                            var4 = true;
                        }

                        Accessor var23 = this.currentBatchBindAccessors[var3];
                        if (var19 == null) {
                            var19 = var23;
                            this.currentRowBindAccessors[var3] = var23;
                        } else if (var23 != null && var19.defineType != var23.defineType) {
                            var4 = true;
                        }

                        if (var19 != null && var15 != this.theOutBinder && var19.defineType != var15.type && (!this.connection.permitTimestampDateMismatch || var15.type != 180 || var19.defineType != 12)) {
                            var6 = true;
                        }
                    }
                }

                if (var5 && var7) {
                    this.lastBoundNeeded = true;
                }
            }

            int var18;
            if (var4) {
                if (!var7) {
                    if (this.m_batchStyle == 2) {
                        this.pushBatch(false);
                    } else {
                        var18 = this.validRows;
                        this.prematureBatchCount = this.sendBatch();
                        this.validRows = var18;

                        for(var3 = 0; var3 < this.numberOfBindPositions; ++var3) {
                            this.currentRowBinders[var3].lastBoundValueCleanup(this, var3);
                        }

                        if (var5) {
                            this.lastBoundNeeded = true;
                        }
                    }
                }

                this.needToParse = true;
                this.currentRowNeedToPrepareBinds = true;
                this.needToPrepareDefineBuffer = true;
            } else if (var2) {
                this.pushBatch(false);
                this.needToParse = false;
                this.currentBatchNeedToPrepareBinds = false;
            }

            if (this.currentBatchAccumulatedBindsSize > 2097152 && this.m_batchStyle == 2) {
                this.pushBatch(false);
                this.needToParse = false;
            }

            int var22;
            for(var3 = 0; var3 < this.numberOfBindPositions; ++var3) {
                var18 = this.currentRowCharLens[var3];
                if (var18 == -1 && this.currentRank == this.firstRowInBatch) {
                    var18 = this.lastBoundCharLens[var3];
                }

                var22 = this.currentRowByteLens[var3];
                if (var22 == -1 && this.currentRank == this.firstRowInBatch) {
                    var22 = this.lastBoundByteLens[var3];
                }

                this.currentBatchAccumulatedBindsSize += var18 + var22;
            }

            if (var6) {
                SQLException var25 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 12);
                var25.fillInStackTrace();
                throw var25;
            } else {
                for(var3 = 0; var3 < this.numberOfBindPositions; ++var3) {
                    var18 = this.currentRowByteLens[var3];
                    if (var18 == -1 && this.currentRank == this.firstRowInBatch) {
                        var18 = this.lastBoundByteLens[var3];
                    }

                    if (this.currentBatchByteLens[var3] < var18) {
                        this.currentBatchByteLens[var3] = var18;
                    }

                    var22 = this.currentRowCharLens[var3];
                    if (var22 == -1 && this.currentRank == this.firstRowInBatch) {
                        var22 = this.lastBoundCharLens[var3];
                    }

                    if (this.currentBatchCharLens[var3] < var22) {
                        this.currentBatchCharLens[var3] = var22;
                    }

                    this.currentRowByteLens[var3] = 0;
                    this.currentRowCharLens[var3] = 0;
                    this.currentBatchFormOfUse[var3] = this.currentRowFormOfUse[var3];
                }

                if (this.currentRowNeedToPrepareBinds) {
                    this.currentBatchNeedToPrepareBinds = true;
                }

                if (this.currentRowBindAccessors != null) {
                    Accessor[] var24 = this.currentBatchBindAccessors;
                    this.currentBatchBindAccessors = this.currentRowBindAccessors;
                    if (var24 == null) {
                        var24 = new Accessor[this.numberOfBindPositions];
                    } else {
                        for(var3 = 0; var3 < this.numberOfBindPositions; ++var3) {
                            var24[var3] = null;
                        }
                    }

                    this.currentRowBindAccessors = var24;
                }

                var18 = this.currentRank + 1;
                if (var18 < var1) {
                    if (var18 >= this.numberOfBindRowsAllocated) {
                        var22 = this.numberOfBindRowsAllocated << 1;
                        if (var22 <= var18) {
                            var22 = var18 + 1;
                        }

                        this.growBinds(var22);
                        this.currentBatchNeedToPrepareBinds = true;
                        if (this.pushedBatches != null) {
                            this.pushedBatches.current_batch_need_to_prepare_binds = true;
                        }
                    }

                    this.currentRowBinders = this.binders[var18];
                } else {
                    this.setupBindBuffers(0, var1);
                    this.currentRowBinders = this.binders[0];
                }

                this.currentRowNeedToPrepareBinds = false;
                this.clearParameters = false;
            }
        }
    }

    private boolean isDefineTypeCompatibleWithBindType(int var1, int var2) {
        boolean var3 = false;
        if (var1 == var2) {
            var3 = true;
        } else if (this.connection.permitTimestampDateMismatch && var2 == 180 && var1 == 12) {
            var3 = true;
        }

        return var3;
    }

    void processPlsqlIndexTabBinds(int var1) throws SQLException {
        int var2 = 0;
        int var3 = 0;
        int var4 = 0;
        int var5 = 0;
        Binder[] var6 = this.binders[var1];
        PlsqlIbtBindInfo[] var7 = this.parameterPlsqlIbt == null ? null : this.parameterPlsqlIbt[var1];

        int var8;
        for(var8 = 0; var8 < this.numberOfBindPositions; ++var8) {
            Binder var9 = var6[var8];
            Accessor var10 = this.currentBatchBindAccessors == null ? null : this.currentBatchBindAccessors[var8];
            PlsqlIbtBindInfo var11 = var10 == null ? null : var10.plsqlIndexTableBindInfo();
            PlsqlIbtBindInfo var12 = var11;
            if (var9.type == 998) {
                var12 = var7[var8];
                if (var11 != null) {
                    if (var12.element_internal_type != var11.element_internal_type) {
                        SQLException var13 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 12);
                        var13.fillInStackTrace();
                        throw var13;
                    }

                    if (var12.maxLen < var11.maxLen) {
                        var12.maxLen = var11.maxLen;
                    }

                    if (var12.elemMaxLen < var11.elemMaxLen) {
                        var12.elemMaxLen = var11.elemMaxLen;
                    }

                    if (var12.ibtByteLength > 0) {
                        var12.ibtByteLength = var12.elemMaxLen * var12.maxLen;
                    } else {
                        var12.ibtCharLength = var12.elemMaxLen * var12.maxLen;
                    }
                }
            }

            if (var12 != null) {
                ++var2;
                var4 += var12.ibtByteLength;
                var5 += var12.ibtCharLength;
                var3 += var12.maxLen;
            }
        }

        if (var2 != 0) {
            this.ibtBindIndicatorSize = 6 + var2 * 8 + var3 * 2;
            this.ibtBindIndicators = new short[this.ibtBindIndicatorSize];
            this.ibtBindIndicatorOffset = 0;
            if (var4 > 0) {
                this.ibtBindBytes = new byte[var4];
            }

            this.ibtBindByteOffset = 0;
            if (var5 > 0) {
                this.ibtBindChars = new char[var5];
            }

            this.ibtBindCharOffset = 0;
            var8 = this.ibtBindByteOffset;
            int var19 = this.ibtBindCharOffset;
            int var21 = this.ibtBindIndicatorOffset;
            int var22 = var21 + 6 + var2 * 8;
            this.ibtBindIndicators[var21++] = (short)(var2 >> 16);
            this.ibtBindIndicators[var21++] = (short)(var2 & '\uffff');
            this.ibtBindIndicators[var21++] = (short)(var4 >> 16);
            this.ibtBindIndicators[var21++] = (short)(var4 & '\uffff');
            this.ibtBindIndicators[var21++] = (short)(var5 >> 16);
            this.ibtBindIndicators[var21++] = (short)(var5 & '\uffff');

            for(int var23 = 0; var23 < this.numberOfBindPositions; ++var23) {
                Binder var14 = var6[var23];
                Accessor var15 = this.currentBatchBindAccessors == null ? null : this.currentBatchBindAccessors[var23];
                PlsqlIbtBindInfo var16 = var15 == null ? null : var15.plsqlIndexTableBindInfo();
                PlsqlIbtBindInfo var17 = var16;
                if (var14.type == 998) {
                    var17 = var7[var23];
                }

                if (var17 != null) {
                    int var18 = var17.maxLen;
                    this.ibtBindIndicators[var21++] = (short)var17.element_internal_type;
                    this.ibtBindIndicators[var21++] = (short)var17.elemMaxLen;
                    this.ibtBindIndicators[var21++] = (short)(var18 >> 16);
                    this.ibtBindIndicators[var21++] = (short)(var18 & '\uffff');
                    this.ibtBindIndicators[var21++] = (short)(var17.curLen >> 16);
                    this.ibtBindIndicators[var21++] = (short)(var17.curLen & '\uffff');
                    int var20;
                    if (var17.ibtByteLength > 0) {
                        var20 = var8;
                        var8 += var17.ibtByteLength;
                    } else {
                        var20 = var19;
                        var19 += var17.ibtCharLength;
                    }

                    this.ibtBindIndicators[var21++] = (short)(var20 >> 16);
                    this.ibtBindIndicators[var21++] = (short)(var20 & '\uffff');
                    var17.ibtValueIndex = var20;
                    var17.ibtIndicatorIndex = var22;
                    var17.ibtLengthIndex = var22 + var18;
                    if (var16 != null) {
                        if (var16 != var17) {
                            var16.ibtIndicatorIndex = var17.ibtIndicatorIndex;
                            var16.ibtLengthIndex = var17.ibtLengthIndex;
                            var16.ibtValueIndex = var20;
                        }

                        this.initializePlsqlIndexByTableAccessor(var15, var21);
                    }

                    var22 += 2 * var18;
                }
            }

        }
    }

    void initializePlsqlIndexByTableAccessor(Accessor var1, int var2) {
    }

    void initializeBindSubRanges(int var1, int var2) {
        this.bindByteSubRange = 0;
        this.bindCharSubRange = 0;
    }

    int calculateIndicatorSubRangeSize() {
        return 0;
    }

    short getInoutIndicator(int var1) {
        return 0;
    }

    void initializeIndicatorSubRange() {
        this.bindIndicatorSubRange = this.calculateIndicatorSubRangeSize();
    }

    void prepareBindPreambles(int var1, int var2) {
    }

    protected void configureBindData() throws SQLException {
    }

    void setupBindBuffers(int var1, int var2) throws SQLException {
        if (this.bindIndicators == null) {
            this.allocBinds(var2);
        }

        try {
            if (this.numberOfBindPositions == 0) {
                if (var2 != 0) {
                    this.numberOfBoundRows = var2;
                    this.bindIndicators[this.bindIndicatorSubRange + 3] = (short)((this.numberOfBoundRows & -65536) >> 16);
                    this.bindIndicators[this.bindIndicatorSubRange + 4] = (short)(this.numberOfBoundRows & '\uffff');
                }

            } else {
                this.preparedAllBinds = this.currentBatchNeedToPrepareBinds;
                this.preparedByteBinds = false;
                this.preparedCharBinds = false;
                this.currentBatchNeedToPrepareBinds = false;
                this.numberOfBoundRows = var2;
                this.bindIndicators[this.bindIndicatorSubRange + 3] = (short)((this.numberOfBoundRows & -65536) >> 16);
                this.bindIndicators[this.bindIndicatorSubRange + 4] = (short)(this.numberOfBoundRows & '\uffff');
                int var23 = this.bindBufferCapacity;
                if (this.numberOfBoundRows > this.bindBufferCapacity) {
                    var23 = this.numberOfBoundRows;
                    this.preparedAllBinds = true;
                }

                int var3;
                int var6;
                int var7;
                if (this.currentBatchBindAccessors != null) {
                    if (this.outBindAccessors == null) {
                        this.outBindAccessors = new Accessor[this.numberOfBindPositions];
                    }

                    for(var3 = 0; var3 < this.numberOfBindPositions; ++var3) {
                        Accessor var5 = this.currentBatchBindAccessors[var3];
                        this.outBindAccessors[var3] = var5;
                        if (var5 != null) {
                            var6 = var5.byteLength;
                            var7 = var5.charLength;
                            if (this.currentBatchByteLens[var3] < var6) {
                                this.currentBatchByteLens[var3] = var6;
                            }

                            if (var7 == 0 || this.currentBatchCharLens[var3] < var7) {
                                this.currentBatchCharLens[var3] = var7;
                            }
                        }
                    }
                }

                int var24 = 0;
                var6 = 0;
                var7 = this.bindIndicatorSubRange + 5;
                int var8 = var7;
                int var12;
                int var13;
                int var15;
                int var25;
                int var26;
                int var27;
                if (this.preparedAllBinds) {
                    this.preparedByteBinds = true;
                    this.preparedCharBinds = true;
                    Binder[] var9 = this.binders[var1];

                    for(var3 = 0; var3 < this.numberOfBindPositions; ++var3) {
                        Binder var10 = var9[var3];
                        var12 = this.currentBatchByteLens[var3];
                        var13 = this.currentBatchCharLens[var3];
                        short var11;
                        if (var10 == this.theOutBinder) {
                            Accessor var14 = this.currentBatchBindAccessors[var3];
                            var11 = (short)var14.defineType;
                        } else {
                            var11 = var10.type;
                        }

                        var6 += var12;
                        var24 += var13;
                        this.bindIndicators[var8 + 0] = var11;
                        this.bindIndicators[var8 + 1] = (short)var12;
                        this.bindIndicators[var8 + 2] = (short)var13;
                        this.bindIndicators[var8 + 9] = this.currentBatchFormOfUse[var3];
                        var8 += 10;
                    }
                } else if (this.preparedByteBinds | this.preparedCharBinds) {
                    for(var3 = 0; var3 < this.numberOfBindPositions; ++var3) {
                        var25 = this.currentBatchByteLens[var3];
                        var26 = this.currentBatchCharLens[var3];
                        var6 += var25;
                        var24 += var26;
                        this.bindIndicators[var8 + 1] = (short)var25;
                        this.bindIndicators[var8 + 2] = (short)var26;
                        var8 += 10;
                    }
                } else {
                    for(var3 = 0; var3 < this.numberOfBindPositions; ++var3) {
                        var25 = var8 + 1;
                        var26 = var8 + 2;
                        var27 = this.currentBatchByteLens[var3];
                        var12 = this.currentBatchCharLens[var3];
                        short var28 = this.bindIndicators[var25];
                        short var29 = this.bindIndicators[var26];
                        var15 = (this.bindIndicators[var8 + 5] << 16) + (this.bindIndicators[var8 + 6] & '\uffff');
                        boolean var16 = this.bindIndicators[var15] == -1;
                        if (var16 && var27 > 1) {
                            this.preparedByteBinds = true;
                        }

                        if (var28 >= var27 && !this.preparedByteBinds) {
                            this.currentBatchByteLens[var3] = var28;
                            var6 += var28;
                        } else {
                            this.bindIndicators[var25] = (short)var27;
                            var6 += var27;
                            this.preparedByteBinds = true;
                        }

                        if (var16 && var12 > 1) {
                            this.preparedCharBinds = true;
                        }

                        if (var29 >= var12 && !this.preparedCharBinds) {
                            this.currentBatchCharLens[var3] = var29;
                            var24 += var29;
                        } else {
                            this.bindIndicators[var26] = (short)var12;
                            var24 += var12;
                            this.preparedCharBinds = true;
                        }

                        var8 += 10;
                    }
                }

                if (this.preparedByteBinds | this.preparedCharBinds) {
                    this.initializeBindSubRanges(this.numberOfBoundRows, var23);
                }

                if (this.preparedByteBinds) {
                    var25 = this.bindByteSubRange + var6 * var23;
                    if (this.lastBoundNeeded || var25 > this.totalBindByteLength) {
                        this.bindByteOffset = 0;
                        this.bindBytes = this.connection.getByteBuffer(var25);
                        this.totalBindByteLength = var25;
                    }

                    this.bindBufferCapacity = var23;
                    this.bindIndicators[this.bindIndicatorSubRange + 1] = (short)((this.bindBufferCapacity & -65536) >> 16);
                    this.bindIndicators[this.bindIndicatorSubRange + 2] = (short)(this.bindBufferCapacity & '\uffff');
                }

                if (this.preparedCharBinds) {
                    var25 = this.bindCharSubRange + var24 * this.bindBufferCapacity;
                    if (this.lastBoundNeeded || var25 > this.totalBindCharLength) {
                        this.bindCharOffset = 0;
                        this.bindChars = this.connection.getCharBuffer(var25);
                        this.totalBindCharLength = var25;
                    }

                    this.bindByteSubRange += this.bindByteOffset;
                    this.bindCharSubRange += this.bindCharOffset;
                }

                var25 = this.bindByteSubRange;
                var26 = this.bindCharSubRange;
                var27 = this.indicatorsOffset;
                var12 = this.valueLengthsOffset;
                var8 = var7;
                int var30;
                if (this.preparedByteBinds | this.preparedCharBinds) {
                    if (this.currentBatchBindAccessors == null) {
                        for(var3 = 0; var3 < this.numberOfBindPositions; ++var3) {
                            var13 = this.currentBatchByteLens[var3];
                            var30 = this.currentBatchCharLens[var3];
                            var15 = var30 == 0 ? var25 : var26;
                            this.bindIndicators[var8 + 3] = (short)(var15 >> 16);
                            this.bindIndicators[var8 + 4] = (short)(var15 & '\uffff');
                            var25 += var13 * this.bindBufferCapacity;
                            var26 += var30 * this.bindBufferCapacity;
                            var8 += 10;
                        }
                    } else {
                        for(var3 = 0; var3 < this.numberOfBindPositions; ++var3) {
                            var13 = this.currentBatchByteLens[var3];
                            var30 = this.currentBatchCharLens[var3];
                            var15 = var30 == 0 ? var25 : var26;
                            this.bindIndicators[var8 + 3] = (short)(var15 >> 16);
                            this.bindIndicators[var8 + 4] = (short)(var15 & '\uffff');
                            Accessor var31 = this.currentBatchBindAccessors[var3];
                            if (var31 != null) {
                                if (var30 > 0) {
                                    var31.columnDataOffset = var26;
                                    var31.charLength = var30;
                                } else {
                                    var31.columnDataOffset = var25;
                                    var31.byteLength = var13;
                                }

                                var31.lengthIndex = var12;
                                var31.indicatorIndex = var27;
                                var31.rowSpaceIndicator = this.bindIndicators;
                                var31.setCapacity(this.bindBufferCapacity);
                            }

                            var25 += var13 * this.bindBufferCapacity;
                            var26 += var30 * this.bindBufferCapacity;
                            var27 += this.numberOfBindRowsAllocated;
                            var12 += this.numberOfBindRowsAllocated;
                            var8 += 10;
                        }
                    }

                    var25 = this.bindByteSubRange;
                    var26 = this.bindCharSubRange;
                    var27 = this.indicatorsOffset;
                    var12 = this.valueLengthsOffset;
                    var8 = var7;
                }

                var13 = this.bindBufferCapacity - this.numberOfBoundRows;
                var30 = this.numberOfBoundRows - 1;
                var15 = var30 + var1;
                Binder[] var32 = this.binders[var15];
                if (this.parameterOtype != null) {
                    System.arraycopy(this.parameterDatum[var15], 0, this.lastBoundTypeBytes, 0, this.numberOfBindPositions);
                    System.arraycopy(this.parameterOtype[var15], 0, this.lastBoundTypeOtypes, 0, this.numberOfBindPositions);
                }

                if (this.hasIbtBind) {
                    this.processPlsqlIndexTabBinds(var1);
                }

                if (this.numReturnParams > 0 && (this.accessors == null || this.accessors.length < this.numReturnParams)) {
                    SQLException var33 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 173);
                    var33.fillInStackTrace();
                    throw var33;
                } else {
                    if (this.numReturnParams > 0) {
                        this.processDmlReturningBind();
                    }

                    boolean var17 = !this.sqlKind.isPlsqlOrCall() || this.currentRowBindAccessors == null;
                    this.localCheckSum = this.checkSum;

                    for(var3 = 0; var3 < this.numberOfBindPositions; ++var3) {
                        int var18 = this.currentBatchByteLens[var3];
                        int var19 = this.currentBatchCharLens[var3];
                        this.lastBinders[var3] = var32[var3];
                        this.lastBoundByteLens[var3] = var18;

                        for(int var20 = 0; var20 < this.numberOfBoundRows; ++var20) {
                            int var21 = var1 + var20;
                            this.localCheckSum = this.binders[var21][var3].bind(this, var3, var20, var21, this.bindBytes, this.bindChars, this.bindIndicators, var18, var19, var25, var26, var12 + var20, var27 + var20, var17, this.localCheckSum);
                            this.binders[var21][var3] = null;
                            if (this.userStream != null) {
                                this.userStream[var20][var3] = null;
                            }

                            var25 += var18;
                            var26 += var19;
                        }

                        if (this.bindChecksumListener != null) {
                            boolean var36 = this.bindChecksumListener.shouldContinue(this.checkSum);
                            this.bindChecksumListener = null;
                            if (!var36) {
                                SQLException var37 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 290);
                                var37.fillInStackTrace();
                                throw var37;
                            }
                        }

                        this.lastBoundByteOffsets[var3] = var25 - var18;
                        this.lastBoundCharOffsets[var3] = var26 - var19;
                        this.lastBoundInds[var3] = this.bindIndicators[var27 + var30];
                        this.lastBoundLens[var3] = this.bindIndicators[var12 + var30];
                        this.lastBoundByteLens[var3] = 0;
                        this.lastBoundCharLens[var3] = 0;
                        var25 += var13 * var18;
                        var26 += var13 * var19;
                        var27 += this.numberOfBindRowsAllocated;
                        var12 += this.numberOfBindRowsAllocated;
                        var8 += 10;
                    }

                    this.checkSum = this.localCheckSum;
                    this.lastBoundBytes = this.bindBytes;
                    this.lastBoundByteOffset = this.bindByteOffset;
                    this.lastBoundChars = this.bindChars;
                    this.lastBoundCharOffset = this.bindCharOffset;
                    if (this.parameterStream != null) {
                        this.lastBoundStream = this.parameterStream[var1 + this.numberOfBoundRows - 1];
                    }

                    int[] var34 = this.currentBatchByteLens;
                    this.currentBatchByteLens = this.lastBoundByteLens;
                    this.lastBoundByteLens = var34;
                    int[] var35 = this.currentBatchCharLens;
                    this.currentBatchCharLens = this.lastBoundCharLens;
                    this.lastBoundCharLens = var35;
                    this.lastBoundNeeded = false;
                    this.prepareBindPreambles(this.numberOfBoundRows, this.bindBufferCapacity);
                    this.configureBindData();
                    this.checkSum = this.localCheckSum;
                    this.localCheckSum = 0L;
                }
            }
        } catch (NullPointerException var22) {
            SQLException var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 89, (Object)null, var22);
            var4.fillInStackTrace();
            throw var4;
        }
    }

    void releaseBuffers() {
        super.releaseBuffers();
        this.parameterStream = (InputStream[][])null;
        this.parameterInt = (int[][])null;
        this.parameterLong = (long[][])null;
        this.parameterFloat = (float[][])null;
        this.parameterDouble = (double[][])null;
        this.parameterBigDecimal = (BigDecimal[][])null;
        this.parameterString = (String[][])null;
        this.parameterDate = (Date[][])null;
        this.parameterTime = (Time[][])null;
        this.parameterTimestamp = (Timestamp[][])null;
        this.parameterDatum = (byte[][][])null;
        this.parameterOtype = (OracleTypeADT[][])null;
        this.connection.cacheBuffer(this.bindBytes);
        this.bindBytes = null;
        this.totalBindByteLength = 0;
        this.connection.cacheBuffer(this.bindChars);
        this.bindChars = null;
        this.totalBindCharLength = 0;
        this.bindIndicators = null;
        this.totalBindIndicatorLength = 0;
        this.bindBufferCapacity = 0;
        this.numberOfBindRowsAllocated = 1;
        this.lastBoundStream = null;
        this.userStream = (Object[][])null;

        try {
            this.clearParameters();
        } catch (SQLException var2) {
        }

    }

    public void enterImplicitCache() throws SQLException {
        this.alwaysOnClose();
        if (!this.connection.isClosed()) {
            this.cleanAllTempLobs();
        }

        if (this.connection.clearStatementMetaData) {
            this.lastBoundBytes = null;
            this.lastBoundChars = null;
        }

        this.cacheState = 2;
        this.creationState = 1;
        this.currentResultSet = null;
        this.lastIndex = 0;
        this.queryTimeout = 0;
        this.rowPrefetchChanged = false;
        this.currentRank = 0;
        this.currentBatchAccumulatedBindsSize = 0;
        this.validRows = 0;
        this.maxRows = 0;
        this.maxFieldSize = 0;
        this.gotLastBatch = false;
        this.clearParameters = true;
        this.defaultTimeZone = null;
        this.defaultCalendar = null;
        this.checkSum = 0L;
        this.checkSumComputationFailure = false;
        if (this.sqlKind.isOTHER()) {
            this.needToParse = true;
            this.needToPrepareDefineBuffer = true;
            this.columnsDefinedByUser = false;
        }

        this.releaseBuffers();
        this.definedColumnType = null;
        this.definedColumnSize = null;
        this.definedColumnFormOfUse = null;
        if (this.accessors != null) {
            int var1 = this.accessors.length;

            for(int var2 = 0; var2 < var1; ++var2) {
                if (this.accessors[var2] != null) {
                    this.accessors[var2].rowSpaceIndicator = null;
                    if (this.columnsDefinedByUser) {
                        this.accessors[var2].externalType = 0;
                    }
                }
            }
        }

        this.fixedString = this.connection.getDefaultFixedString();
        this.defaultRowPrefetch = this.rowPrefetch;
        this.rowPrefetchInLastFetch = -1;
        if (this.connection.clearStatementMetaData) {
            this.needToParse = true;
            this.needToPrepareDefineBuffer = true;
            this.columnsDefinedByUser = false;
            if (this.userRsetType == ResultSetType.UNKNOWN) {
                this.userRsetType = DEFAULT_RESULT_SET_TYPE;
                this.realRsetType = ResultSetType.FORWARD_READ_ONLY;
            }

            this.currentRowNeedToPrepareBinds = true;
        }

    }

    public void enterExplicitCache() throws SQLException {
        this.cacheState = 2;
        this.creationState = 2;
        this.defaultTimeZone = null;
        this.alwaysOnClose();
    }

    public void exitImplicitCacheToActive() throws SQLException {
        this.cacheState = 1;
        this.closed = false;
        if (this.rowPrefetch != this.connection.getDefaultRowPrefetch() && this.streamList == null) {
            this.rowPrefetch = this.connection.getDefaultRowPrefetch();
            this.defaultRowPrefetch = this.rowPrefetch;
            this.rowPrefetchChanged = true;
        }

        if (this.batch != this.connection.getDefaultExecuteBatch()) {
            this.resetBatch();
        }

        this.processEscapes = this.connection.processEscapes;
        if (this.accessors != null) {
            this.doInitializationAfterDefineBufferRestore();
        }

        if (this.cachedBindCharSize != 0 || this.cachedBindByteSize != 0) {
            if (this.cachedBindByteSize > 0) {
                this.bindBytes = this.connection.getByteBuffer(this.cachedBindByteSize);
            }

            if (this.cachedBindCharSize > 0) {
                this.bindChars = this.connection.getCharBuffer(this.cachedBindCharSize);
            }

            this.doLocalInitialization();
        }

    }

    void doLocalInitialization() {
    }

    void doInitializationAfterDefineBufferRestore() {
    }

    public void exitExplicitCacheToActive() throws SQLException {
        this.cacheState = 1;
        this.closed = false;
    }

    public void exitImplicitCacheToClose() throws SQLException {
        this.cacheState = 0;
        this.closed = false;
        synchronized(this.connection) {
            this.hardClose();
        }
    }

    public void exitExplicitCacheToClose() throws SQLException {
        this.cacheState = 0;
        this.closed = false;
        synchronized(this.connection) {
            this.hardClose();
        }
    }

    public void closeWithKey(String var1) throws SQLException {
        synchronized(this.connection) {
            this.closeOrCache(var1);
        }
    }

    int executeInternal() throws SQLException {
        this.noMoreUpdateCounts = false;
        this.checkSum = 0L;
        this.checkSumComputationFailure = false;
        this.ensureOpen();
        if (this.currentRank > 0 && this.m_batchStyle == 2) {
            SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 81, "batch must be either executed or cleared");
            var3.fillInStackTrace();
            throw var3;
        } else {
            boolean var1 = this.userRsetType == DEFAULT_RESULT_SET_TYPE;
            this.prepareForNewResults(true, false, true);
            this.processCompletedBindRow(this.sqlKind.isSELECT() ? 1 : this.batch, false);
            if (!var1 && !this.scrollRsetTypeSolved) {
                return this.doScrollPstmtExecuteUpdate() + this.prematureBatchCount;
            } else {
                this.doExecuteWithTimeout();
                boolean var2 = this.prematureBatchCount != 0 && this.validRows > 0;
                if (!var1) {
                    this.computeOffsetOfFirstUserColumn();
                    this.currentResultSet = OracleResultSet.createResultSet(this);
                    if (!this.connection.accumulateBatchResult) {
                        var2 = false;
                    }
                }

                if (var2) {
                    this.validRows += this.prematureBatchCount;
                    this.prematureBatchCount = 0;
                }

                if (this.sqlKind.isOTHER()) {
                    this.needToParse = true;
                }

                return this.validRows;
            }
        }
    }

    public ResultSet executeQuery() throws SQLException {
        synchronized(this.connection) {
            this.executeDoneForDefines = true;
            this.executionType = 1;
            this.executeInternal();
            this.computeOffsetOfFirstUserColumn();
            this.currentResultSet = OracleResultSet.createResultSet(this);
            return this.currentResultSet;
        }
    }

    public int executeUpdate() throws SQLException {
        synchronized(this.connection) {
            this.executionType = 2;
            return this.executeInternal();
        }
    }

    public boolean execute() throws SQLException {
        synchronized(this.connection) {
            this.executeDoneForDefines = true;
            this.executionType = 3;
            this.executeInternal();
            return this.sqlKind.isSELECT();
        }
    }

    void slideDownCurrentRow(int var1) {
        if (this.binders != null) {
            this.binders[var1] = this.binders[0];
            this.binders[0] = this.currentRowBinders;
        }

        if (this.parameterInt != null) {
            int[] var2 = this.parameterInt[0];
            this.parameterInt[0] = this.parameterInt[var1];
            this.parameterInt[var1] = var2;
        }

        if (this.parameterLong != null) {
            long[] var3 = this.parameterLong[0];
            this.parameterLong[0] = this.parameterLong[var1];
            this.parameterLong[var1] = var3;
        }

        if (this.parameterFloat != null) {
            float[] var4 = this.parameterFloat[0];
            this.parameterFloat[0] = this.parameterFloat[var1];
            this.parameterFloat[var1] = var4;
        }

        if (this.parameterDouble != null) {
            double[] var5 = this.parameterDouble[0];
            this.parameterDouble[0] = this.parameterDouble[var1];
            this.parameterDouble[var1] = var5;
        }

        if (this.parameterBigDecimal != null) {
            BigDecimal[] var6 = this.parameterBigDecimal[0];
            this.parameterBigDecimal[0] = this.parameterBigDecimal[var1];
            this.parameterBigDecimal[var1] = var6;
        }

        if (this.parameterString != null) {
            String[] var7 = this.parameterString[0];
            this.parameterString[0] = this.parameterString[var1];
            this.parameterString[var1] = var7;
        }

        if (this.parameterDate != null) {
            Date[] var8 = this.parameterDate[0];
            this.parameterDate[0] = this.parameterDate[var1];
            this.parameterDate[var1] = var8;
        }

        if (this.parameterTime != null) {
            Time[] var9 = this.parameterTime[0];
            this.parameterTime[0] = this.parameterTime[var1];
            this.parameterTime[var1] = var9;
        }

        if (this.parameterTimestamp != null) {
            Timestamp[] var10 = this.parameterTimestamp[0];
            this.parameterTimestamp[0] = this.parameterTimestamp[var1];
            this.parameterTimestamp[var1] = var10;
        }

        if (this.parameterDatum != null) {
            byte[][] var11 = this.parameterDatum[0];
            this.parameterDatum[0] = this.parameterDatum[var1];
            this.parameterDatum[var1] = var11;
        }

        if (this.parameterOtype != null) {
            OracleTypeADT[] var12 = this.parameterOtype[0];
            this.parameterOtype[0] = this.parameterOtype[var1];
            this.parameterOtype[var1] = var12;
        }

        if (this.parameterStream != null) {
            InputStream[] var13 = this.parameterStream[0];
            this.parameterStream[0] = this.parameterStream[var1];
            this.parameterStream[var1] = var13;
        }

        if (this.userStream != null) {
            Object[] var14 = this.userStream[0];
            this.userStream[0] = this.userStream[var1];
            this.userStream[var1] = var14;
        }

    }

    void resetBatch() {
        this.batch = this.connection.getDefaultExecuteBatch();
    }

    public int sendBatch() throws SQLException {
        if (this.isJdbcBatchStyle()) {
            return 0;
        } else {
            synchronized(this.connection) {
                if (this.connection.isUsable() && !this.bsendBatchInProgress) {
                    int var2;
                    try {
                        this.ensureOpen();
                        if (this.currentRank > 0) {
                            var2 = this.batch;
                            this.bsendBatchInProgress = true;

                            int var3;
                            try {
                                var3 = this.currentRank;
                                if (this.batch != this.currentRank) {
                                    this.batch = this.currentRank;
                                }

                                this.setupBindBuffers(0, this.currentRank);
                                --this.currentRank;
                                this.doExecuteWithTimeout();
                                this.slideDownCurrentRow(var3);
                            } finally {
                                if (this.batch != var2) {
                                    this.batch = var2;
                                }

                            }

                            if (this.connection.accumulateBatchResult) {
                                this.validRows += this.prematureBatchCount;
                                this.prematureBatchCount = 0;
                            }

                            var3 = this.validRows;
                            return var3;
                        }

                        var2 = this.connection.accumulateBatchResult ? 0 : this.validRows;
                    } finally {
                        this.currentRank = 0;
                        this.bsendBatchInProgress = false;
                    }

                    return var2;
                } else {
                    this.clearBatch();
                    this.bsendBatchInProgress = false;
                    return 0;
                }
            }
        }
    }

    public void setExecuteBatch(int var1) throws SQLException {
        synchronized(this.connection) {
            if (var1 <= 0) {
                SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 42);
                var3.fillInStackTrace();
                throw var3;
            } else {
                this.setOracleBatchStyle();
                this.set_execute_batch(var1);
            }
        }
    }

    void set_execute_batch(int var1) throws SQLException {
        synchronized(this.connection) {
            if (var1 <= 0) {
                SQLException var6 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 42);
                var6.fillInStackTrace();
                throw var6;
            } else if (var1 != this.batch) {
                int var3;
                if (this.currentRank > 0) {
                    var3 = this.validRows;
                    this.prematureBatchCount = this.sendBatch();
                    this.validRows = var3;
                }

                var3 = this.batch;
                this.batch = var1;
                if (this.numberOfBindRowsAllocated < this.batch) {
                    this.growBinds(this.batch);
                }

            }
        }
    }

    public final int getExecuteBatch() {
        return this.batch;
    }

    public void defineParameterTypeBytes(int var1, int var2, int var3) throws SQLException {
        synchronized(this.connection) {
            SQLException var5;
            if (var3 < 0) {
                var5 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 53);
                var5.fillInStackTrace();
                throw var5;
            } else if (var1 < 1) {
                var5 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 3);
                var5.fillInStackTrace();
                throw var5;
            } else {
                boolean var8;
                switch(var2) {
                    case -104:
                        var8 = true;
                        break;
                    case -103:
                        var8 = true;
                        break;
                    case -102:
                        var8 = true;
                        break;
                    case -101:
                        var8 = true;
                        break;
                    case -100:
                    case 93:
                        var8 = true;
                        break;
                    case -13:
                        var8 = true;
                        break;
                    case -10:
                        var8 = true;
                        break;
                    case -8:
                        var8 = true;
                        break;
                    case -7:
                    case -6:
                    case -5:
                    case 2:
                    case 3:
                    case 4:
                    case 5:
                    case 6:
                    case 7:
                    case 8:
                        var8 = true;
                        break;
                    case -3:
                    case -2:
                        var8 = true;
                        break;
                    case 0:
                        var5 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 4);
                        var5.fillInStackTrace();
                        throw var5;
                    case 1:
                        var8 = true;
                        break;
                    case 12:
                        var8 = true;
                        break;
                    case 91:
                    case 92:
                        var8 = true;
                        break;
                    case 100:
                        var8 = true;
                        break;
                    case 101:
                        var8 = true;
                        break;
                    case 2004:
                        var8 = true;
                        break;
                    case 2005:
                        var8 = true;
                        break;
                    default:
                        var5 = DatabaseError.createUnsupportedFeatureSqlException();
                        var5.fillInStackTrace();
                        throw var5;
                }

            }
        }
    }

    public void defineParameterTypeChars(int var1, int var2, int var3) throws SQLException {
        synchronized(this.connection) {
            int var5 = this.connection.getNlsRatio();
            if (var2 != 1 && var2 != 12) {
                this.defineParameterTypeBytes(var1, var2, var3);
            } else {
                this.defineParameterTypeBytes(var1, var2, var3 * var5);
            }

        }
    }

    public void defineParameterType(int var1, int var2, int var3) throws SQLException {
        synchronized(this.connection) {
            this.defineParameterTypeBytes(var1, var2, var3);
        }
    }

    public ResultSetMetaData getMetaData() throws SQLException {
        this.ensureOpen();
        return this.sqlKind.isSELECT() ? this.getResultSetMetaData() : null;
    }

    public void setNull(int var1, int var2, String var3) throws SQLException {
        this.setNullInternal(var1, var2, var3);
    }

    void setNullInternal(int var1, int var2, String var3) throws SQLException {
        int var4 = var1 - 1;
        if (var4 >= 0 && var1 <= this.numberOfBindPositions) {
            if (var2 != 2002 && var2 != 2008 && var2 != 2003 && var2 != 2007 && var2 != 2009 && var2 != 2006) {
                this.setNullInternal(var1, var2);
            } else {
                synchronized(this.connection) {
                    this.setNullCritical(var4, var2, var3);
                }
            }
        } else {
            SQLException var5 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 3);
            var5.fillInStackTrace();
            throw var5;
        }
    }

    void setNullInternal(int var1, int var2) throws SQLException {
        synchronized(this.connection) {
            this.setNullCritical(var1, var2);
        }
    }

    void setNullCritical(int var1, int var2, String var3) throws SQLException {
        Object var4 = null;
        Binder var5 = this.theNamedTypeNullBinder;
        switch(var2) {
            case 2003:
                ArrayDescriptor var7 = ArrayDescriptor.createDescriptor(var3, this.connection);
                var4 = var7.getOracleTypeCOLLECTION();
            case 2004:
            case 2005:
            default:
                break;
            case 2006:
                var5 = this.theRefTypeNullBinder;
            case 2002:
            case 2008:
                StructDescriptor var8 = StructDescriptor.createDescriptor(var3, this.connection);
                var4 = var8.getOracleTypeADT();
                break;
            case 2007:
            case 2009:
                OpaqueDescriptor var6 = OpaqueDescriptor.createDescriptor(var3, this.connection);
                var4 = (OracleTypeADT)var6.getPickler();
        }

        this.currentRowBinders[var1] = var5;
        if (this.parameterDatum == null) {
            this.parameterDatum = new byte[this.numberOfBindRowsAllocated][this.numberOfBindPositions][];
        }

        this.parameterDatum[this.currentRank][var1] = null;
        if (var4 != null) {
            ((OracleTypeADT)var4).getTOID();
        }

        if (this.parameterOtype == null) {
            this.parameterOtype = new OracleTypeADT[this.numberOfBindRowsAllocated][this.numberOfBindPositions];
        }

        this.parameterOtype[this.currentRank][var1] = (OracleTypeADT)var4;
        this.currentRowByteLens[var1] = var5.bytelen;
        this.currentRowCharLens[var1] = 0;
    }

    public void setNullAtName(String var1, int var2, String var3) throws SQLException {
        if (var1 == null) {
            SQLException var9 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 68);
            var9.fillInStackTrace();
            throw var9;
        } else {
            String var4 = var1.intern();
            String[] var5 = this.sqlObject.getParameterList();
            boolean var6 = false;
            int var7 = Math.min(this.sqlObject.getParameterCount(), var5.length);

            for(int var8 = 0; var8 < var7; ++var8) {
                if (var5[var8] == var4) {
                    this.setNullInternal(var8 + 1, var2, var3);
                    var6 = true;
                }
            }

            if (!var6) {
                SQLException var10 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 147, var1);
                var10.fillInStackTrace();
                throw var10;
            }
        }
    }

    public void setNull(int var1, int var2) throws SQLException {
        synchronized(this.connection) {
            this.setNullCritical(var1, var2);
        }
    }

    void setNullCritical(int var1, int var2) throws SQLException {
        int var3 = var1 - 1;
        SQLException var4;
        if (var3 >= 0 && var1 <= this.numberOfBindPositions) {
            var4 = null;
            int var5 = this.getInternalType(var2);
            boolean var6 = true;
            SQLException var7;
            Binder var8;
            switch(var5) {
                case 1:
                case 8:
                case 96:
                case 995:
                    var8 = this.theVarcharNullBinder;
                    var6 = false;
                    break;
                case 6:
                    var8 = this.theVarnumNullBinder;
                    break;
                case 12:
                    var8 = this.theDateNullBinder;
                    break;
                case 23:
                case 24:
                    var8 = this.theRawNullBinder;
                    break;
                case 100:
                    var8 = this.theBinaryFloatNullBinder;
                    break;
                case 101:
                    var8 = this.theBinaryDoubleNullBinder;
                    break;
                case 102:
                case 998:
                default:
                    var7 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 23, "sqlType=" + var2);
                    var7.fillInStackTrace();
                    throw var7;
                case 104:
                    var8 = this.getRowidNullBinder(var3);
                    break;
                case 109:
                case 111:
                    var7 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 4, "sqlType=" + var2);
                    var7.fillInStackTrace();
                    throw var7;
                case 112:
                    var8 = this.theClobNullBinder;
                    break;
                case 113:
                    var8 = this.theBlobNullBinder;
                    break;
                case 114:
                    var8 = this.theBfileNullBinder;
                    break;
                case 180:
                    var8 = this.theTimestampNullBinder;
                    break;
                case 181:
                    var8 = this.theTSTZNullBinder;
                    break;
                case 182:
                    var8 = this.theIntervalYMNullBinder;
                    break;
                case 183:
                    var8 = this.theIntervalDSNullBinder;
                    break;
                case 231:
                    var8 = this.theTSLTZNullBinder;
                    break;
                case 999:
                    var8 = this.theFixedCHARNullBinder;
                    var6 = false;
            }

            this.currentRowBinders[var3] = var8;
            if (var6) {
                this.currentRowByteLens[var3] = var8.bytelen;
                this.currentRowCharLens[var3] = 0;
            } else {
                this.currentRowByteLens[var3] = 0;
                this.currentRowCharLens[var3] = 1;
            }

        } else {
            var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 3);
            var4.fillInStackTrace();
            throw var4;
        }
    }

    Binder getRowidNullBinder(int var1) {
        return this.theRowidNullBinder;
    }

    public void setNullAtName(String var1, int var2) throws SQLException {
        if (var1 == null) {
            SQLException var8 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 68);
            var8.fillInStackTrace();
            throw var8;
        } else {
            String var3 = var1.intern();
            String[] var4 = this.sqlObject.getParameterList();
            boolean var5 = false;
            int var6 = Math.min(this.sqlObject.getParameterCount(), var4.length);

            for(int var7 = 0; var7 < var6; ++var7) {
                if (var4[var7] == var3) {
                    this.setNull(var7 + 1, var2);
                    var5 = true;
                }
            }

            if (!var5) {
                SQLException var9 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 147, var1);
                var9.fillInStackTrace();
                throw var9;
            }
        }
    }

    public void setBoolean(int var1, boolean var2) throws SQLException {
        synchronized(this.connection) {
            this.setBooleanInternal(var1, var2);
        }
    }

    void setBooleanInternal(int var1, boolean var2) throws SQLException {
        int var3 = var1 - 1;
        if (var3 >= 0 && var1 <= this.numberOfBindPositions) {
            this.currentRowBinders[var3] = this.theBooleanBinder;
            this.currentRowByteLens[var3] = this.currentRowBinders[var3].bytelen;
            this.currentRowCharLens[var3] = 0;
            if (this.parameterInt == null) {
                this.parameterInt = new int[this.numberOfBindRowsAllocated][this.numberOfBindPositions];
            }

            this.parameterInt[this.currentRank][var3] = var2 ? 1 : 0;
        } else {
            SQLException var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 3);
            var4.fillInStackTrace();
            throw var4;
        }
    }

    public void setByte(int var1, byte var2) throws SQLException {
        synchronized(this.connection) {
            this.setByteInternal(var1, var2);
        }
    }

    void setByteInternal(int var1, byte var2) throws SQLException {
        int var3 = var1 - 1;
        if (var3 >= 0 && var1 <= this.numberOfBindPositions) {
            this.currentRowBinders[var3] = this.theByteBinder;
            this.currentRowByteLens[var3] = this.currentRowBinders[var3].bytelen;
            this.currentRowCharLens[var3] = 0;
            if (this.parameterInt == null) {
                this.parameterInt = new int[this.numberOfBindRowsAllocated][this.numberOfBindPositions];
            }

            this.parameterInt[this.currentRank][var3] = var2;
        } else {
            SQLException var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 3);
            var4.fillInStackTrace();
            throw var4;
        }
    }

    public void setShort(int var1, short var2) throws SQLException {
        synchronized(this.connection) {
            this.setShortInternal(var1, var2);
        }
    }

    void setShortInternal(int var1, short var2) throws SQLException {
        int var3 = var1 - 1;
        if (var3 >= 0 && var1 <= this.numberOfBindPositions) {
            this.currentRowBinders[var3] = this.theShortBinder;
            this.currentRowByteLens[var3] = this.currentRowBinders[var3].bytelen;
            this.currentRowCharLens[var3] = 0;
            if (this.parameterInt == null) {
                this.parameterInt = new int[this.numberOfBindRowsAllocated][this.numberOfBindPositions];
            }

            this.parameterInt[this.currentRank][var3] = var2;
        } else {
            SQLException var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 3);
            var4.fillInStackTrace();
            throw var4;
        }
    }

    public void setInt(int var1, int var2) throws SQLException {
        synchronized(this.connection) {
            this.setIntInternal(var1, var2);
        }
    }

    void setIntInternal(int var1, int var2) throws SQLException {
        int var3 = var1 - 1;
        if (var3 >= 0 && var1 <= this.numberOfBindPositions) {
            this.currentRowBinders[var3] = this.theIntBinder;
            this.currentRowByteLens[var3] = this.currentRowBinders[var3].bytelen;
            this.currentRowCharLens[var3] = 0;
            if (this.parameterInt == null) {
                this.parameterInt = new int[this.numberOfBindRowsAllocated][this.numberOfBindPositions];
            }

            this.parameterInt[this.currentRank][var3] = var2;
        } else {
            SQLException var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 3);
            var4.fillInStackTrace();
            throw var4;
        }
    }

    public void setLong(int var1, long var2) throws SQLException {
        synchronized(this.connection) {
            this.setLongInternal(var1, var2);
        }
    }

    void setLongInternal(int var1, long var2) throws SQLException {
        int var4 = var1 - 1;
        if (var4 >= 0 && var1 <= this.numberOfBindPositions) {
            this.currentRowBinders[var4] = this.theLongBinder;
            this.currentRowByteLens[var4] = this.currentRowBinders[var4].bytelen;
            this.currentRowCharLens[var4] = 0;
            if (this.parameterLong == null) {
                this.parameterLong = new long[this.numberOfBindRowsAllocated][this.numberOfBindPositions];
            }

            this.parameterLong[this.currentRank][var4] = var2;
        } else {
            SQLException var5 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 3);
            var5.fillInStackTrace();
            throw var5;
        }
    }

    public void setFloat(int var1, float var2) throws SQLException {
        synchronized(this.connection) {
            this.setFloatInternal(var1, var2);
        }
    }

    void setFloatInternal(int var1, float var2) throws SQLException {
        int var3 = var1 - 1;
        if (var3 >= 0 && var1 <= this.numberOfBindPositions) {
            if (!this.connection.setFloatAndDoubleUseBinary && Float.isNaN(var2)) {
                throw new IllegalArgumentException("NaN");
            } else {
                if (this.theFloatBinder == null) {
                    this.theFloatBinder = theStaticFloatBinder;
                    if (this.connection.setFloatAndDoubleUseBinary) {
                        this.theFloatBinder = theStaticBinaryFloatBinder;
                    }
                }

                this.currentRowBinders[var3] = this.theFloatBinder;
                this.currentRowByteLens[var3] = this.currentRowBinders[var3].bytelen;
                this.currentRowCharLens[var3] = 0;
                if (this.theFloatBinder == theStaticFloatBinder) {
                    if (this.parameterDouble == null) {
                        this.parameterDouble = new double[this.numberOfBindRowsAllocated][this.numberOfBindPositions];
                    }

                    this.parameterDouble[this.currentRank][var3] = (double)var2;
                } else {
                    if (this.parameterFloat == null) {
                        this.parameterFloat = new float[this.numberOfBindRowsAllocated][this.numberOfBindPositions];
                    }

                    this.parameterFloat[this.currentRank][var3] = var2;
                }

            }
        } else {
            SQLException var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 3);
            var4.fillInStackTrace();
            throw var4;
        }
    }

    public void setBinaryFloat(int var1, float var2) throws SQLException {
        synchronized(this.connection) {
            this.setBinaryFloatInternal(var1, var2);
        }
    }

    void setBinaryFloatInternal(int var1, float var2) throws SQLException {
        int var3 = var1 - 1;
        if (var3 >= 0 && var1 <= this.numberOfBindPositions) {
            this.currentRowBinders[var3] = this.theBinaryFloatBinder;
            this.currentRowByteLens[var3] = this.currentRowBinders[var3].bytelen;
            this.currentRowCharLens[var3] = 0;
            if (this.parameterFloat == null) {
                this.parameterFloat = new float[this.numberOfBindRowsAllocated][this.numberOfBindPositions];
            }

            this.parameterFloat[this.currentRank][var3] = var2;
        } else {
            SQLException var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 3);
            var4.fillInStackTrace();
            throw var4;
        }
    }

    public void setBinaryFloat(int var1, BINARY_FLOAT var2) throws SQLException {
        synchronized(this.connection) {
            this.setBinaryFloatInternal(var1, var2);
        }
    }

    void setBinaryFloatInternal(int var1, BINARY_FLOAT var2) throws SQLException {
        int var3 = var1 - 1;
        if (var3 >= 0 && var1 <= this.numberOfBindPositions) {
            if (var2 == null) {
                this.currentRowBinders[var3] = this.theBINARY_FLOATNullBinder;
            } else {
                this.currentRowBinders[var3] = this.theBINARY_FLOATBinder;
                if (this.parameterDatum == null) {
                    this.parameterDatum = new byte[this.numberOfBindRowsAllocated][this.numberOfBindPositions][];
                }

                this.parameterDatum[this.currentRank][var3] = var2.getBytes();
            }

            this.currentRowByteLens[var3] = this.currentRowBinders[var3].bytelen;
            this.currentRowCharLens[var3] = 0;
        } else {
            SQLException var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 3);
            var4.fillInStackTrace();
            throw var4;
        }
    }

    public void setBinaryDouble(int var1, double var2) throws SQLException {
        synchronized(this.connection) {
            this.setBinaryDoubleInternal(var1, var2);
        }
    }

    void setBinaryDoubleInternal(int var1, double var2) throws SQLException {
        int var4 = var1 - 1;
        if (var4 >= 0 && var1 <= this.numberOfBindPositions) {
            this.currentRowBinders[var4] = this.theBinaryDoubleBinder;
            if (this.parameterDouble == null) {
                this.parameterDouble = new double[this.numberOfBindRowsAllocated][this.numberOfBindPositions];
            }

            this.currentRowByteLens[var4] = this.currentRowBinders[var4].bytelen;
            this.currentRowCharLens[var4] = 0;
            this.parameterDouble[this.currentRank][var4] = var2;
        } else {
            SQLException var5 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 3);
            var5.fillInStackTrace();
            throw var5;
        }
    }

    public void setBinaryDouble(int var1, BINARY_DOUBLE var2) throws SQLException {
        synchronized(this.connection) {
            this.setBinaryDoubleInternal(var1, var2);
        }
    }

    void setBinaryDoubleInternal(int var1, BINARY_DOUBLE var2) throws SQLException {
        int var3 = var1 - 1;
        if (var3 >= 0 && var1 <= this.numberOfBindPositions) {
            if (var2 == null) {
                this.currentRowBinders[var3] = this.theBINARY_DOUBLENullBinder;
            } else {
                this.currentRowBinders[var3] = this.theBINARY_DOUBLEBinder;
                if (this.parameterDatum == null) {
                    this.parameterDatum = new byte[this.numberOfBindRowsAllocated][this.numberOfBindPositions][];
                }

                this.parameterDatum[this.currentRank][var3] = var2.getBytes();
            }

            this.currentRowByteLens[var3] = this.currentRowBinders[var3].bytelen;
            this.currentRowCharLens[var3] = 0;
        } else {
            SQLException var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 3);
            var4.fillInStackTrace();
            throw var4;
        }
    }

    public void setDouble(int var1, double var2) throws SQLException {
        synchronized(this.connection) {
            this.setDoubleInternal(var1, var2);
        }
    }

    void setDoubleInternal(int var1, double var2) throws SQLException {
        int var4 = var1 - 1;
        if (var4 >= 0 && var1 <= this.numberOfBindPositions) {
            if (!this.connection.setFloatAndDoubleUseBinary) {
                if (Double.isNaN(var2)) {
                    throw new IllegalArgumentException("NaN");
                }

                double var7 = Math.abs(var2);
                if (var7 != 0.0D && var7 < 1.0E-130D) {
                    throw new IllegalArgumentException("Underflow");
                }

                if (var7 >= 1.0E126D) {
                    throw new IllegalArgumentException("Overflow");
                }
            }

            if (this.theDoubleBinder == null) {
                this.theDoubleBinder = theStaticDoubleBinder;
                if (this.connection.setFloatAndDoubleUseBinary) {
                    this.theDoubleBinder = theStaticBinaryDoubleBinder;
                }
            }

            this.currentRowBinders[var4] = this.theDoubleBinder;
            this.currentRowByteLens[var4] = this.currentRowBinders[var4].bytelen;
            this.currentRowCharLens[var4] = 0;
            if (this.parameterDouble == null) {
                this.parameterDouble = new double[this.numberOfBindRowsAllocated][this.numberOfBindPositions];
            }

            this.parameterDouble[this.currentRank][var4] = var2;
        } else {
            SQLException var5 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 3);
            var5.fillInStackTrace();
            throw var5;
        }
    }

    public void setBigDecimal(int var1, BigDecimal var2) throws SQLException {
        synchronized(this.connection) {
            this.setBigDecimalInternal(var1, var2);
        }
    }

    void setBigDecimalInternal(int var1, BigDecimal var2) throws SQLException {
        int var3 = var1 - 1;
        if (var3 >= 0 && var1 <= this.numberOfBindPositions) {
            if (var2 == null) {
                this.currentRowBinders[var3] = this.theVarnumNullBinder;
            } else {
                this.currentRowBinders[var3] = this.theBigDecimalBinder;
                if (this.parameterBigDecimal == null) {
                    this.parameterBigDecimal = new BigDecimal[this.numberOfBindRowsAllocated][this.numberOfBindPositions];
                }

                this.parameterBigDecimal[this.currentRank][var3] = var2;
            }

            this.currentRowByteLens[var3] = this.currentRowBinders[var3].bytelen;
            this.currentRowCharLens[var3] = 0;
        } else {
            SQLException var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 3);
            var4.fillInStackTrace();
            throw var4;
        }
    }

    public void setString(int var1, String var2) throws SQLException {
        this.setStringInternal(var1, var2);
    }

    void setStringInternal(int var1, String var2) throws SQLException {
        int var3 = var1 - 1;
        if (var3 >= 0 && var1 <= this.numberOfBindPositions) {
            int var6 = var2 != null ? var2.length() : 0;
            if (var6 == 0) {
                this.setNull(var1, 12);
            } else {
                int var5;
                if (this.currentRowFormOfUse[var1 - 1] == 1) {
                    if (this.sqlKind.isPlsqlOrCall()) {
                        if (var6 > this.maxVcsBytesPlsql || var6 > this.maxVcsCharsPlsql && this.isServerCharSetFixedWidth) {
                            this.setStringForClobCritical(var1, var2);
                        } else if (var6 > this.maxVcsCharsPlsql) {
                            var5 = this.connection.conversion.encodedByteLength(var2, false);
                            if (var5 > this.maxVcsBytesPlsql) {
                                this.setStringForClobCritical(var1, var2);
                            } else {
                                this.basicBindString(var1, var2);
                            }
                        } else {
                            this.basicBindString(var1, var2);
                        }
                    } else if (var6 <= this.maxVcsCharsSql) {
                        this.basicBindString(var1, var2);
                    } else if (var6 <= this.maxStreamCharsSql) {
                        this.basicBindCharacterStream(var1, new StringReader(var2), var6, true);
                    } else {
                        this.setStringForClobCritical(var1, var2);
                    }
                } else if (this.sqlKind.isPlsqlOrCall()) {
                    if (var6 > this.maxVcsBytesPlsql || var6 > this.maxVcsNCharsPlsql && this.isServerNCharSetFixedWidth) {
                        this.setStringForClobCritical(var1, var2);
                    } else if (var6 > this.maxVcsNCharsPlsql) {
                        var5 = this.connection.conversion.encodedByteLength(var2, true);
                        if (var5 > this.maxVcsBytesPlsql) {
                            this.setStringForClobCritical(var1, var2);
                        } else {
                            this.basicBindString(var1, var2);
                        }
                    } else {
                        this.basicBindString(var1, var2);
                    }
                } else if (var6 <= this.maxVcsCharsSql) {
                    this.basicBindString(var1, var2);
                } else {
                    this.setStringForClobCritical(var1, var2);
                }
            }

        } else {
            SQLException var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 3);
            var4.fillInStackTrace();
            throw var4;
        }
    }

    void basicBindNullString(int var1) throws SQLException {
        synchronized(this.connection) {
            int var3 = var1 - 1;
            this.currentRowBinders[var3] = this.theVarcharNullBinder;
            if (this.sqlKind.isPlsqlOrCall()) {
                this.currentRowCharLens[var3] = this.minVcsBindSize;
            } else {
                this.currentRowCharLens[var3] = 1;
            }

            this.currentRowByteLens[var3] = 0;
        }
    }

    void basicBindString(int var1, String var2) throws SQLException {
        synchronized(this.connection) {
            int var4 = var1 - 1;
            this.currentRowBinders[var4] = this.theStringBinder;
            int var5 = var2.length();
            if (this.sqlKind.isPlsqlOrCall()) {
                int var6 = this.connection.minVcsBindSize;
                int var7 = var5 + 1;
                this.currentRowCharLens[var4] = var7 < var6 ? var6 : var7;
            } else {
                this.currentRowCharLens[var4] = var5 + 1;
            }

            if (this.parameterString == null) {
                this.parameterString = new String[this.numberOfBindRowsAllocated][this.numberOfBindPositions];
            }

            this.parameterString[this.currentRank][var4] = var2;
            this.currentRowByteLens[var4] = 0;
        }
    }

    public void setStringForClob(int var1, String var2) throws SQLException {
        if (var2 == null) {
            this.setNull(var1, 1);
        } else {
            int var3 = var2.length();
            if (var3 == 0) {
                this.setNull(var1, 1);
            } else {
                if (this.sqlKind.isPlsqlOrCall()) {
                    if (var3 <= this.maxVcsCharsPlsql) {
                        this.setStringInternal(var1, var2);
                    } else {
                        this.setStringForClobCritical(var1, var2);
                    }
                } else if (var3 <= this.maxVcsCharsSql) {
                    this.setStringInternal(var1, var2);
                } else {
                    this.setStringForClobCritical(var1, var2);
                }

            }
        }
    }

    void setStringForClobCritical(int var1, String var2) throws SQLException {
        synchronized(this.connection) {
            CLOB var4 = CLOB.createTemporary(this.connection, true, 10, this.currentRowFormOfUse[var1 - 1]);
            var4.setString(1L, var2);
            this.addToTempLobsToFree(var4);
            this.lastBoundClobs[var1 - 1] = var4;
            this.setCLOBInternal(var1, var4);
        }
    }

    void setReaderContentsForClobCritical(int var1, Reader var2, long var3, boolean var5) throws SQLException {
        synchronized(this.connection) {
            label61: {
                try {
                    if ((var2 = this.isReaderEmpty(var2)) != null) {
                        break label61;
                    }

                    if (var5) {
                        throw new IOException(var3 + " char of CLOB data cannot be read");
                    }

                    this.setCLOBInternal(var1, (CLOB)null);
                } catch (IOException var18) {
                    SQLException var8 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), var18);
                    var8.fillInStackTrace();
                    throw var8;
                }

                return;
            }

            CLOB var7 = CLOB.createTemporary(this.connection, true, 10, this.currentRowFormOfUse[var1 - 1]);
            OracleClobWriter var20 = (OracleClobWriter)((OracleClobWriter)var7.setCharacterStream(1L));
            int var9 = var7.getBufferSize();
            char[] var10 = new char[var9];
            long var11 = 0L;
            boolean var13 = false;
            var11 = var5 ? var3 : 9223372036854775807L;

            try {
                while(var11 > 0L) {
                    int var21;
                    if (var11 >= (long)var9) {
                        var21 = var2.read(var10);
                    } else {
                        var21 = var2.read(var10, 0, (int)var11);
                    }

                    if (var21 == -1) {
                        if (var5) {
                            throw new IOException(var11 + " char of CLOB data cannot be read");
                        }
                        break;
                    }

                    var20.write(var10, 0, var21);
                    var11 -= (long)var21;
                }

                var20.flush();
            } catch (IOException var17) {
                SQLException var15 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), var17);
                var15.fillInStackTrace();
                throw var15;
            }

            this.addToTempLobsToFree(var7);
            this.lastBoundClobs[var1 - 1] = var7;
            this.setCLOBInternal(var1, var7);
        }
    }

    void setAsciiStreamContentsForClobCritical(int var1, InputStream var2, long var3, boolean var5) throws SQLException {
        synchronized(this.connection) {
            label61: {
                try {
                    if ((var2 = this.isInputStreamEmpty(var2)) != null) {
                        break label61;
                    }

                    if (var5) {
                        throw new IOException(var3 + " byte of CLOB data cannot be read");
                    }

                    this.setCLOBInternal(var1, (CLOB)null);
                } catch (IOException var19) {
                    SQLException var8 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), var19);
                    var8.fillInStackTrace();
                    throw var8;
                }

                return;
            }

            CLOB var7 = CLOB.createTemporary(this.connection, true, 10, this.currentRowFormOfUse[var1 - 1]);
            OracleClobWriter var21 = (OracleClobWriter)((OracleClobWriter)var7.setCharacterStream(1L));
            int var9 = var7.getBufferSize();
            byte[] var10 = new byte[var9];
            char[] var11 = new char[var9];
            boolean var12 = false;
            long var13 = var5 ? var3 : 9223372036854775807L;

            try {
                while(var13 > 0L) {
                    int var22;
                    if (var13 >= (long)var9) {
                        var22 = var2.read(var10);
                    } else {
                        var22 = var2.read(var10, 0, (int)var13);
                    }

                    if (var22 == -1) {
                        if (var5) {
                            throw new IOException(var13 + " byte of CLOB data cannot be read");
                        }
                        break;
                    }

                    DBConversion var10000 = this.connection.conversion;
                    DBConversion.asciiBytesToJavaChars(var10, var22, var11);
                    var21.write(var11, 0, var22);
                    var13 -= (long)var22;
                }

                var21.flush();
            } catch (IOException var18) {
                SQLException var16 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), var18);
                var16.fillInStackTrace();
                throw var16;
            }

            this.addToTempLobsToFree(var7);
            this.lastBoundClobs[var1 - 1] = var7;
            this.setCLOBInternal(var1, var7);
        }
    }

    public void setStringForClobAtName(String var1, String var2) throws SQLException {
        if (var1 == null) {
            SQLException var8 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 68);
            var8.fillInStackTrace();
            throw var8;
        } else {
            String var3 = var1.intern();
            String[] var4 = this.sqlObject.getParameterList();
            boolean var5 = false;
            int var6 = Math.min(this.sqlObject.getParameterCount(), var4.length);

            for(int var7 = 0; var7 < var6; ++var7) {
                if (var4[var7] == var3) {
                    this.setStringForClob(var7 + 1, var2);
                    var5 = true;
                }
            }

            if (!var5) {
                SQLException var9 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 147, var1);
                var9.fillInStackTrace();
                throw var9;
            }
        }
    }

    public void setFixedCHAR(int var1, String var2) throws SQLException {
        synchronized(this.connection) {
            this.setFixedCHARInternal(var1, var2);
        }
    }

    void setFixedCHARInternal(int var1, String var2) throws SQLException {
        int var3 = var1 - 1;
        if (var3 >= 0 && var1 <= this.numberOfBindPositions) {
            int var6 = 0;
            if (var2 != null) {
                var6 = var2.length();
            }

            if (var6 > 32766) {
                SQLException var5 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 157);
                var5.fillInStackTrace();
                throw var5;
            } else {
                if (var2 == null) {
                    this.currentRowBinders[var3] = this.theFixedCHARNullBinder;
                    this.currentRowCharLens[var3] = 1;
                } else {
                    this.currentRowBinders[var3] = this.theFixedCHARBinder;
                    this.currentRowCharLens[var3] = var6 + 1;
                    if (this.parameterString == null) {
                        this.parameterString = new String[this.numberOfBindRowsAllocated][this.numberOfBindPositions];
                    }

                    this.parameterString[this.currentRank][var3] = var2;
                }

                this.currentRowByteLens[var3] = 0;
            }
        } else {
            SQLException var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 3);
            var4.fillInStackTrace();
            throw var4;
        }
    }

    /** @deprecated */
    public void setCursor(int var1, ResultSet var2) throws SQLException {
        synchronized(this.connection) {
            this.setCursorInternal(var1, var2);
        }
    }

    void setCursorInternal(int var1, ResultSet var2) throws SQLException {
        SQLException var3 = DatabaseError.createUnsupportedFeatureSqlException();
        var3.fillInStackTrace();
        throw var3;
    }

    public void setROWID(int var1, ROWID var2) throws SQLException {
        synchronized(this.connection) {
            this.setROWIDInternal(var1, var2);
        }
    }

    void setROWIDInternal(int var1, ROWID var2) throws SQLException {
        if (this.sqlKind == SqlKind.CALL_BLOCK) {
            if (var2 == null) {
                this.setNull(var1, 12);
            } else {
                this.setStringInternal(var1, var2.stringValue());
            }

        } else {
            int var3 = var1 - 1;
            if (var3 >= 0 && var1 <= this.numberOfBindPositions) {
                if (var2 != null && var2.shareBytes() != null) {
                    this.currentRowBinders[var3] = T4CRowidAccessor.isUROWID(var2.shareBytes(), 0) ? this.theURowidBinder : this.theRowidBinder;
                    if (this.parameterDatum == null) {
                        this.parameterDatum = new byte[this.numberOfBindRowsAllocated][this.numberOfBindPositions][];
                    }

                    byte[] var5 = var2.getBytes();
                    this.parameterDatum[this.currentRank][var3] = var5;
                    this.currentRowByteLens[var3] = var5.length + 2;
                } else {
                    this.currentRowBinders[var3] = this.theRowidNullBinder;
                    this.currentRowByteLens[var3] = this.currentRowBinders[var3].bytelen;
                }

                this.currentRowCharLens[var3] = 0;
            } else {
                SQLException var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 3);
                var4.fillInStackTrace();
                throw var4;
            }
        }
    }

    public void setArray(int var1, Array var2) throws SQLException {
        this.setARRAYInternal(var1, (ARRAY)var2);
    }

    void setArrayInternal(int var1, Array var2) throws SQLException {
        this.setARRAYInternal(var1, (ARRAY)var2);
    }

    public void setARRAY(int var1, ARRAY var2) throws SQLException {
        this.setARRAYInternal(var1, var2);
    }

    void setARRAYInternal(int var1, ARRAY var2) throws SQLException {
        int var3 = var1 - 1;
        SQLException var4;
        if (var3 >= 0 && var1 <= this.numberOfBindPositions) {
            if (var2 == null) {
                var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 68);
                var4.fillInStackTrace();
                throw var4;
            } else {
                synchronized(this.connection) {
                    this.setArrayCritical(var3, var2);
                    this.currentRowCharLens[var3] = 0;
                }
            }
        } else {
            var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 3);
            var4.fillInStackTrace();
            throw var4;
        }
    }

    void setArrayCritical(int var1, ARRAY var2) throws SQLException {
        ArrayDescriptor var3 = var2.getDescriptor();
        if (var3 == null) {
            SQLException var5 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 61);
            var5.fillInStackTrace();
            throw var5;
        } else {
            this.currentRowBinders[var1] = this.theNamedTypeBinder;
            this.currentRowByteLens[var1] = this.currentRowBinders[var1].bytelen;
            this.currentRowCharLens[var1] = 0;
            if (this.parameterDatum == null) {
                this.parameterDatum = new byte[this.numberOfBindRowsAllocated][this.numberOfBindPositions][];
            }

            this.parameterDatum[this.currentRank][var1] = var2.toBytes();
            OracleTypeCOLLECTION var4 = var3.getOracleTypeCOLLECTION();
            var4.getTOID();
            if (this.parameterOtype == null) {
                this.parameterOtype = new OracleTypeADT[this.numberOfBindRowsAllocated][this.numberOfBindPositions];
            }

            this.parameterOtype[this.currentRank][var1] = var4;
        }
    }

    public void setOPAQUE(int var1, OPAQUE var2) throws SQLException {
        this.setOPAQUEInternal(var1, var2);
    }

    void setOPAQUEInternal(int var1, OPAQUE var2) throws SQLException {
        int var3 = var1 - 1;
        SQLException var4;
        if (var3 >= 0 && var1 <= this.numberOfBindPositions) {
            if (var2 == null) {
                var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 68);
                var4.fillInStackTrace();
                throw var4;
            } else {
                synchronized(this.connection) {
                    this.setOPAQUECritical(var3, var2);
                    this.currentRowCharLens[var3] = 0;
                }
            }
        } else {
            var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 3);
            var4.fillInStackTrace();
            throw var4;
        }
    }

    void setOPAQUECritical(int var1, OPAQUE var2) throws SQLException {
        OpaqueDescriptor var3 = var2.getDescriptor();
        if (var3 == null) {
            SQLException var5 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 61);
            var5.fillInStackTrace();
            throw var5;
        } else {
            this.currentRowBinders[var1] = this.theNamedTypeBinder;
            this.currentRowByteLens[var1] = this.currentRowBinders[var1].bytelen;
            this.currentRowCharLens[var1] = 0;
            if (this.parameterDatum == null) {
                this.parameterDatum = new byte[this.numberOfBindRowsAllocated][this.numberOfBindPositions][];
            }

            this.parameterDatum[this.currentRank][var1] = var2.toBytes();
            OracleTypeADT var4 = (OracleTypeADT)var3.getPickler();
            var4.getTOID();
            if (this.parameterOtype == null) {
                this.parameterOtype = new OracleTypeADT[this.numberOfBindRowsAllocated][this.numberOfBindPositions];
            }

            this.parameterOtype[this.currentRank][var1] = var4;
        }
    }

    void setSQLXMLInternal(int var1, SQLXML var2) throws SQLException {
        if (var2 == null) {
            SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 68);
            var3.fillInStackTrace();
            throw var3;
        } else {
            this.setOPAQUEInternal(var1, (OPAQUE)var2);
        }
    }

    public void setStructDescriptor(int var1, StructDescriptor var2) throws SQLException {
        this.setStructDescriptorInternal(var1, var2);
    }

    void setStructDescriptorInternal(int var1, StructDescriptor var2) throws SQLException {
        int var3 = var1 - 1;
        SQLException var4;
        if (var3 >= 0 && var1 <= this.numberOfBindPositions) {
            if (var2 == null) {
                var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 68);
                var4.fillInStackTrace();
                throw var4;
            } else {
                synchronized(this.connection) {
                    this.setStructDescriptorCritical(var3, var2);
                    this.currentRowCharLens[var3] = 0;
                }
            }
        } else {
            var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 3);
            var4.fillInStackTrace();
            throw var4;
        }
    }

    void setStructDescriptorCritical(int var1, StructDescriptor var2) throws SQLException {
        this.currentRowBinders[var1] = this.theNamedTypeBinder;
        this.currentRowByteLens[var1] = this.currentRowBinders[var1].bytelen;
        this.currentRowCharLens[var1] = 0;
        if (this.parameterDatum == null) {
            this.parameterDatum = new byte[this.numberOfBindRowsAllocated][this.numberOfBindPositions][];
        }

        OracleTypeADT var3 = var2.getOracleTypeADT();
        var3.getTOID();
        if (this.parameterOtype == null) {
            this.parameterOtype = new OracleTypeADT[this.numberOfBindRowsAllocated][this.numberOfBindPositions];
        }

        this.parameterOtype[this.currentRank][var1] = var3;
    }

    public void setStructDescriptorAtName(String var1, StructDescriptor var2) throws SQLException {
        if (var1 == null) {
            SQLException var8 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 68);
            var8.fillInStackTrace();
            throw var8;
        } else {
            String var3 = var1.intern();
            String[] var4 = this.sqlObject.getParameterList();
            boolean var5 = false;
            int var6 = Math.min(this.sqlObject.getParameterCount(), var4.length);

            for(int var7 = 0; var7 < var6; ++var7) {
                if (var4[var7] == var3) {
                    this.setStructDescriptorInternal(var7 + 1, var2);
                    var5 = true;
                }
            }

            if (!var5) {
                SQLException var9 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 147, var1);
                var9.fillInStackTrace();
                throw var9;
            }
        }
    }

    void setPreBindsCompelete() throws SQLException {
    }

    public void setSTRUCT(int var1, STRUCT var2) throws SQLException {
        this.setSTRUCTInternal(var1, var2);
    }

    void setSTRUCTInternal(int var1, STRUCT var2) throws SQLException {
        int var3 = var1 - 1;
        SQLException var4;
        if (var3 >= 0 && var1 <= this.numberOfBindPositions) {
            if (var2 == null) {
                var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 68);
                var4.fillInStackTrace();
                throw var4;
            } else {
                synchronized(this.connection) {
                    this.setSTRUCTCritical(var3, var2);
                    this.currentRowCharLens[var3] = 0;
                }
            }
        } else {
            var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 3);
            var4.fillInStackTrace();
            throw var4;
        }
    }

    void setSTRUCTCritical(int var1, STRUCT var2) throws SQLException {
        StructDescriptor var3 = var2.getDescriptor();
        if (var3 == null) {
            SQLException var5 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 61);
            var5.fillInStackTrace();
            throw var5;
        } else {
            this.currentRowBinders[var1] = this.theNamedTypeBinder;
            this.currentRowByteLens[var1] = this.currentRowBinders[var1].bytelen;
            this.currentRowCharLens[var1] = 0;
            if (this.parameterDatum == null) {
                this.parameterDatum = new byte[this.numberOfBindRowsAllocated][this.numberOfBindPositions][];
            }

            this.parameterDatum[this.currentRank][var1] = var2.toBytes();
            OracleTypeADT var4 = var3.getOracleTypeADT();
            var4.getTOID();
            if (this.parameterOtype == null) {
                this.parameterOtype = new OracleTypeADT[this.numberOfBindRowsAllocated][this.numberOfBindPositions];
            }

            this.parameterOtype[this.currentRank][var1] = var4;
        }
    }

    public void setRAW(int var1, RAW var2) throws SQLException {
        this.setRAWInternal(var1, var2);
    }

    void setRAWInternal(int var1, RAW var2) throws SQLException {
        boolean var3 = false;
        synchronized(this.connection) {
            int var5 = var1 - 1;
            if (var5 < 0 || var1 > this.numberOfBindPositions) {
                SQLException var6 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 3);
                var6.fillInStackTrace();
                throw var6;
            }

            if (var2 == null) {
                this.currentRowBinders[var5] = this.theRawNullBinder;
                this.currentRowByteLens[var5] = this.currentRowBinders[var5].bytelen;
                this.currentRowCharLens[var5] = 0;
            } else {
                var3 = true;
            }
        }

        if (var3) {
            this.setBytesInternal(var1, var2.getBytes());
        }

    }

    public void setCHAR(int var1, CHAR var2) throws SQLException {
        synchronized(this.connection) {
            this.setCHARInternal(var1, var2);
        }
    }

    void setCHARInternal(int var1, CHAR var2) throws SQLException {
        int var3 = var1 - 1;
        if (var3 >= 0 && var1 <= this.numberOfBindPositions) {
            if (var2 != null && var2.getLength() != 0L) {
                short var8 = (short)var2.oracleId();
                this.currentRowBinders[var3] = this.theSetCHARBinder;
                if (this.parameterDatum == null) {
                    this.parameterDatum = new byte[this.numberOfBindRowsAllocated][this.numberOfBindPositions][];
                }

                CharacterSet var5 = this.currentRowFormOfUse[var3] == 2 ? this.connection.setCHARNCharSetObj : this.connection.setCHARCharSetObj;
                byte[] var6;
                if (var5 != null && var5.getOracleId() != var8) {
                    byte[] var7 = var2.shareBytes();
                    var6 = var5.convert(var2.getCharacterSet(), var7, 0, var7.length);
                } else {
                    var6 = var2.getBytes();
                }

                this.parameterDatum[this.currentRank][var3] = var6;
                this.currentRowCharLens[var3] = (var6.length + 1 >> 1) + 1;
            } else {
                this.currentRowBinders[var3] = this.theSetCHARNullBinder;
                this.currentRowCharLens[var3] = 1;
            }

            if (this.sqlKind.isPlsqlOrCall() && this.currentRowCharLens[var3] < this.minVcsBindSize) {
                this.currentRowCharLens[var3] = this.minVcsBindSize;
            }

            this.currentRowByteLens[var3] = 0;
        } else {
            SQLException var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 3);
            var4.fillInStackTrace();
            throw var4;
        }
    }

    public void setDATE(int var1, DATE var2) throws SQLException {
        synchronized(this.connection) {
            this.setDATEInternal(var1, var2);
        }
    }

    void setDATEInternal(int var1, DATE var2) throws SQLException {
        int var3 = var1 - 1;
        if (var3 >= 0 && var1 <= this.numberOfBindPositions) {
            if (var2 == null) {
                this.currentRowBinders[var3] = this.theDateNullBinder;
            } else {
                this.currentRowBinders[var3] = this.theOracleDateBinder;
                if (this.parameterDatum == null) {
                    this.parameterDatum = new byte[this.numberOfBindRowsAllocated][this.numberOfBindPositions][];
                }

                this.parameterDatum[this.currentRank][var3] = var2.getBytes();
            }

            this.currentRowByteLens[var3] = this.currentRowBinders[var3].bytelen;
            this.currentRowCharLens[var3] = 0;
        } else {
            SQLException var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 3);
            var4.fillInStackTrace();
            throw var4;
        }
    }

    public void setNUMBER(int var1, NUMBER var2) throws SQLException {
        synchronized(this.connection) {
            this.setNUMBERInternal(var1, var2);
        }
    }

    void setNUMBERInternal(int var1, NUMBER var2) throws SQLException {
        int var3 = var1 - 1;
        if (var3 >= 0 && var1 <= this.numberOfBindPositions) {
            if (var2 == null) {
                this.currentRowBinders[var3] = this.theVarnumNullBinder;
            } else {
                this.currentRowBinders[var3] = this.theOracleNumberBinder;
                if (this.parameterDatum == null) {
                    this.parameterDatum = new byte[this.numberOfBindRowsAllocated][this.numberOfBindPositions][];
                }

                this.parameterDatum[this.currentRank][var3] = var2.getBytes();
            }

            this.currentRowByteLens[var3] = this.currentRowBinders[var3].bytelen;
            this.currentRowCharLens[var3] = 0;
        } else {
            SQLException var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 3);
            var4.fillInStackTrace();
            throw var4;
        }
    }

    public void setBLOB(int var1, BLOB var2) throws SQLException {
        synchronized(this.connection) {
            this.setBLOBInternal(var1, var2);
        }
    }

    void setBLOBInternal(int var1, BLOB var2) throws SQLException {
        int var3 = var1 - 1;
        if (var3 >= 0 && var1 <= this.numberOfBindPositions) {
            if (var2 == null) {
                this.currentRowBinders[var3] = this.theBlobNullBinder;
            } else {
                this.currentRowBinders[var3] = this.theBlobBinder;
                if (this.parameterDatum == null) {
                    this.parameterDatum = new byte[this.numberOfBindRowsAllocated][this.numberOfBindPositions][];
                }

                this.parameterDatum[this.currentRank][var3] = var2.getBytes();
            }

            this.currentRowByteLens[var3] = this.currentRowBinders[var3].bytelen;
            this.currentRowCharLens[var3] = 0;
        } else {
            SQLException var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 3);
            var4.fillInStackTrace();
            throw var4;
        }
    }

    public void setBlob(int var1, Blob var2) throws SQLException {
        synchronized(this.connection) {
            this.setBLOBInternal(var1, (BLOB)var2);
        }
    }

    void setBlobInternal(int var1, Blob var2) throws SQLException {
        this.setBLOBInternal(var1, (BLOB)var2);
    }

    public void setCLOB(int var1, CLOB var2) throws SQLException {
        synchronized(this.connection) {
            this.setCLOBInternal(var1, var2);
        }
    }

    void setCLOBInternal(int var1, CLOB var2) throws SQLException {
        int var3 = var1 - 1;
        if (var3 >= 0 && var1 <= this.numberOfBindPositions) {
            if (var2 == null) {
                this.currentRowBinders[var3] = this.theClobNullBinder;
            } else {
                this.currentRowBinders[var3] = this.theClobBinder;
                if (this.parameterDatum == null) {
                    this.parameterDatum = new byte[this.numberOfBindRowsAllocated][this.numberOfBindPositions][];
                }

                this.parameterDatum[this.currentRank][var3] = var2.getBytes();
            }

            this.currentRowByteLens[var3] = this.currentRowBinders[var3].bytelen;
            this.currentRowCharLens[var3] = 0;
        } else {
            SQLException var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 3);
            var4.fillInStackTrace();
            throw var4;
        }
    }

    public void setClob(int var1, Clob var2) throws SQLException {
        synchronized(this.connection) {
            this.setCLOBInternal(var1, (CLOB)var2);
        }
    }

    void setClobInternal(int var1, Clob var2) throws SQLException {
        this.setCLOBInternal(var1, (CLOB)var2);
    }

    public void setBFILE(int var1, BFILE var2) throws SQLException {
        synchronized(this.connection) {
            this.setBFILEInternal(var1, var2);
        }
    }

    void setBFILEInternal(int var1, BFILE var2) throws SQLException {
        int var3 = var1 - 1;
        if (var3 >= 0 && var1 <= this.numberOfBindPositions) {
            if (var2 == null) {
                this.currentRowBinders[var3] = this.theBfileNullBinder;
            } else {
                this.currentRowBinders[var3] = this.theBfileBinder;
                if (this.parameterDatum == null) {
                    this.parameterDatum = new byte[this.numberOfBindRowsAllocated][this.numberOfBindPositions][];
                }

                this.parameterDatum[this.currentRank][var3] = var2.getBytes();
            }

            this.currentRowByteLens[var3] = this.currentRowBinders[var3].bytelen;
            this.currentRowCharLens[var3] = 0;
        } else {
            SQLException var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 3);
            var4.fillInStackTrace();
            throw var4;
        }
    }

    public void setBfile(int var1, BFILE var2) throws SQLException {
        synchronized(this.connection) {
            this.setBFILEInternal(var1, var2);
        }
    }

    void setBfileInternal(int var1, BFILE var2) throws SQLException {
        this.setBFILEInternal(var1, var2);
    }

    public void setBytes(int var1, byte[] var2) throws SQLException {
        this.setBytesInternal(var1, var2);
    }

    void setBytesInternal(int var1, byte[] var2) throws SQLException {
        int var3 = var1 - 1;
        if (var3 >= 0 && var1 <= this.numberOfBindPositions) {
            int var5 = var2 != null ? var2.length : 0;
            if (var5 == 0) {
                this.setNullInternal(var1, -2);
            } else if (this.sqlKind == SqlKind.PLSQL_BLOCK) {
                if (var5 > this.maxRawBytesPlsql) {
                    this.setBytesForBlobCritical(var1, var2);
                } else {
                    this.basicBindBytes(var1, var2);
                }
            } else if (this.sqlKind == SqlKind.CALL_BLOCK) {
                if (var5 > this.maxRawBytesPlsql) {
                    this.setBytesForBlobCritical(var1, var2);
                } else {
                    this.basicBindBytes(var1, var2);
                }
            } else if (var5 > this.maxRawBytesSql) {
                this.bindBytesAsStream(var1, var2);
            } else {
                this.basicBindBytes(var1, var2);
            }

        } else {
            SQLException var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 3);
            var4.fillInStackTrace();
            throw var4;
        }
    }

    void bindBytesAsStream(int var1, byte[] var2) throws SQLException {
        int var3 = var2.length;
        byte[] var4 = new byte[var3];
        System.arraycopy(var2, 0, var4, 0, var3);
        this.set_execute_batch(1);
        this.basicBindBinaryStream(var1, new ByteArrayInputStream(var4), var3, true);
    }

    void basicBindBytes(int var1, byte[] var2) throws SQLException {
        synchronized(this.connection) {
            int var4 = var1 - 1;
            Binder var5 = this.sqlKind.isPlsqlOrCall() ? this.thePlsqlRawBinder : this.theRawBinder;
            this.currentRowBinders[var4] = var5;
            if (this.parameterDatum == null) {
                this.parameterDatum = new byte[this.numberOfBindRowsAllocated][this.numberOfBindPositions][];
            }

            this.parameterDatum[this.currentRank][var4] = var2;
            this.currentRowByteLens[var4] = var2.length;
            this.currentRowCharLens[var4] = 0;
        }
    }

    void basicBindBinaryStream(int var1, InputStream var2, int var3) throws SQLException {
        this.basicBindBinaryStream(var1, var2, var3, false);
    }

    void basicBindBinaryStream(int var1, InputStream var2, int var3, boolean var4) throws SQLException {
        synchronized(this.connection) {
            int var6 = var1 - 1;
            if (var4) {
                this.currentRowBinders[var6] = this.theLongRawStreamForBytesBinder;
            } else {
                this.currentRowBinders[var6] = this.theLongRawStreamBinder;
            }

            if (this.parameterStream == null) {
                this.parameterStream = new InputStream[this.numberOfBindRowsAllocated][this.numberOfBindPositions];
            }

            InputStream[] var10000 = this.parameterStream[this.currentRank];
            InputStream var10002;
            PhysicalConnection var10004;
            if (var4) {
                var10004 = this.connection;
                var10002 = this.connection.conversion.ConvertStreamInternal(var2, 6, var3);
            } else {
                var10004 = this.connection;
                var10002 = this.connection.conversion.ConvertStream(var2, 6, var3);
            }

            var10000[var6] = var10002;
            this.currentRowByteLens[var6] = 0;
            this.currentRowCharLens[var6] = 0;
        }
    }

    public void setBytesForBlob(int var1, byte[] var2) throws SQLException {
        if (var2 == null) {
            this.setNull(var1, -2);
        } else {
            int var3 = var2.length;
            if (var3 == 0) {
                this.setNull(var1, -2);
            } else {
                if (this.sqlKind.isPlsqlOrCall()) {
                    if (var3 <= this.maxRawBytesPlsql) {
                        this.setBytes(var1, var2);
                    } else {
                        this.setBytesForBlobCritical(var1, var2);
                    }
                } else if (var3 <= this.maxRawBytesSql) {
                    this.setBytes(var1, var2);
                } else {
                    this.setBytesForBlobCritical(var1, var2);
                }

            }
        }
    }

    void setBytesForBlobCritical(int var1, byte[] var2) throws SQLException {
        BLOB var3 = BLOB.createTemporary(this.connection, true, 10);
        var3.putBytes(1L, var2);
        this.addToTempLobsToFree(var3);
        this.lastBoundBlobs[var1 - 1] = var3;
        this.setBLOBInternal(var1, var3);
    }

    void setBinaryStreamContentsForBlobCritical(int var1, InputStream var2, long var3, boolean var5) throws SQLException {
        synchronized(this.connection) {
            label61: {
                try {
                    if ((var2 = this.isInputStreamEmpty(var2)) != null) {
                        break label61;
                    }

                    if (var5) {
                        throw new IOException(var3 + " byte of BLOB data cannot be read");
                    }

                    this.setBLOBInternal(var1, (BLOB)null);
                } catch (IOException var18) {
                    SQLException var8 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), var18);
                    var8.fillInStackTrace();
                    throw var8;
                }

                return;
            }

            BLOB var7 = BLOB.createTemporary(this.connection, true, 10);
            OracleBlobOutputStream var20 = (OracleBlobOutputStream)((OracleBlobOutputStream)var7.setBinaryStream(1L));
            int var9 = var7.getBufferSize();
            byte[] var10 = new byte[var9];
            long var11 = 0L;
            boolean var13 = false;
            var11 = var5 ? var3 : 9223372036854775807L;

            try {
                while(var11 > 0L) {
                    int var21;
                    if (var11 >= (long)var9) {
                        var21 = var2.read(var10);
                    } else {
                        var21 = var2.read(var10, 0, (int)var11);
                    }

                    if (var21 == -1) {
                        if (var5) {
                            throw new IOException(var11 + " byte of BLOB data cannot be read");
                        }
                        break;
                    }

                    var20.write(var10, 0, var21);
                    var11 -= (long)var21;
                }

                var20.flush();
            } catch (IOException var17) {
                SQLException var15 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), var17);
                var15.fillInStackTrace();
                throw var15;
            }

            this.addToTempLobsToFree(var7);
            this.lastBoundBlobs[var1 - 1] = var7;
            this.setBLOBInternal(var1, var7);
        }
    }

    public void setBytesForBlobAtName(String var1, byte[] var2) throws SQLException {
        if (var1 == null) {
            SQLException var8 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 68);
            var8.fillInStackTrace();
            throw var8;
        } else {
            String var3 = var1.intern();
            String[] var4 = this.sqlObject.getParameterList();
            boolean var5 = false;
            int var6 = Math.min(this.sqlObject.getParameterCount(), var4.length);

            for(int var7 = 0; var7 < var6; ++var7) {
                if (var4[var7] == var3) {
                    this.setBytesForBlob(var7 + 1, var2);
                    var5 = true;
                }
            }

            if (!var5) {
                SQLException var9 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 147, var1);
                var9.fillInStackTrace();
                throw var9;
            }
        }
    }

    public void setInternalBytes(int var1, byte[] var2, int var3) throws SQLException {
        synchronized(this.connection) {
            this.setInternalBytesInternal(var1, var2, var3);
        }
    }

    void setInternalBytesInternal(int var1, byte[] var2, int var3) throws SQLException {
        SQLException var4 = DatabaseError.createUnsupportedFeatureSqlException();
        var4.fillInStackTrace();
        throw var4;
    }

    public void setDate(int var1, Date var2) throws SQLException {
        synchronized(this.connection) {
            this.setDATEInternal(var1, var2 == null ? null : new DATE(var2, this.getDefaultCalendar()));
        }
    }

    void setDateInternal(int var1, Date var2) throws SQLException {
        this.setDATEInternal(var1, var2 == null ? null : new DATE(var2, this.getDefaultCalendar()));
    }

    public void setTime(int var1, Time var2) throws SQLException {
        synchronized(this.connection) {
            this.setTimeInternal(var1, var2);
        }
    }

    void setTimeInternal(int var1, Time var2) throws SQLException {
        int var3 = var1 - 1;
        if (var3 >= 0 && var1 <= this.numberOfBindPositions) {
            if (var2 == null) {
                this.currentRowBinders[var3] = this.theDateNullBinder;
            } else {
                this.currentRowBinders[var3] = this.theTimeBinder;
                if (this.parameterTime == null) {
                    this.parameterTime = new Time[this.numberOfBindRowsAllocated][this.numberOfBindPositions];
                }

                this.parameterTime[this.currentRank][var3] = var2;
            }

            this.currentRowByteLens[var3] = this.currentRowBinders[var3].bytelen;
            this.currentRowCharLens[var3] = 0;
        } else {
            SQLException var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 3);
            var4.fillInStackTrace();
            throw var4;
        }
    }

    public void setTimestamp(int var1, Timestamp var2) throws SQLException {
        synchronized(this.connection) {
            this.setTimestampInternal(var1, var2);
        }
    }

    void setTimestampInternal(int var1, Timestamp var2) throws SQLException {
        int var3 = var1 - 1;
        if (var3 >= 0 && var1 <= this.numberOfBindPositions) {
            if (var2 == null) {
                this.currentRowBinders[var3] = this.theTimestampNullBinder;
            } else {
                this.currentRowBinders[var3] = this.theTimestampBinder;
                if (this.parameterTimestamp == null) {
                    this.parameterTimestamp = new Timestamp[this.numberOfBindRowsAllocated][this.numberOfBindPositions];
                }

                this.parameterTimestamp[this.currentRank][var3] = var2;
            }

            this.currentRowByteLens[var3] = this.currentRowBinders[var3].bytelen;
            this.currentRowCharLens[var3] = 0;
        } else {
            SQLException var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 3);
            var4.fillInStackTrace();
            throw var4;
        }
    }

    public void setINTERVALYM(int var1, INTERVALYM var2) throws SQLException {
        synchronized(this.connection) {
            this.setINTERVALYMInternal(var1, var2);
        }
    }

    void setINTERVALYMInternal(int var1, INTERVALYM var2) throws SQLException {
        int var3 = var1 - 1;
        if (var3 >= 0 && var1 <= this.numberOfBindPositions) {
            if (var2 == null) {
                this.currentRowBinders[var3] = this.theIntervalYMNullBinder;
            } else {
                this.currentRowBinders[var3] = this.theIntervalYMBinder;
                if (this.parameterDatum == null) {
                    this.parameterDatum = new byte[this.numberOfBindRowsAllocated][this.numberOfBindPositions][];
                }

                this.parameterDatum[this.currentRank][var3] = var2.getBytes();
            }

            this.currentRowByteLens[var3] = this.currentRowBinders[var3].bytelen;
            this.currentRowCharLens[var3] = 0;
        } else {
            SQLException var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 3);
            var4.fillInStackTrace();
            throw var4;
        }
    }

    public void setINTERVALDS(int var1, INTERVALDS var2) throws SQLException {
        synchronized(this.connection) {
            this.setINTERVALDSInternal(var1, var2);
        }
    }

    void setINTERVALDSInternal(int var1, INTERVALDS var2) throws SQLException {
        int var3 = var1 - 1;
        if (var3 >= 0 && var1 <= this.numberOfBindPositions) {
            if (var2 == null) {
                this.currentRowBinders[var3] = this.theIntervalDSNullBinder;
            } else {
                this.currentRowBinders[var3] = this.theIntervalDSBinder;
                if (this.parameterDatum == null) {
                    this.parameterDatum = new byte[this.numberOfBindRowsAllocated][this.numberOfBindPositions][];
                }

                this.parameterDatum[this.currentRank][var3] = var2.getBytes();
            }

            this.currentRowByteLens[var3] = this.currentRowBinders[var3].bytelen;
            this.currentRowCharLens[var3] = 0;
        } else {
            SQLException var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 3);
            var4.fillInStackTrace();
            throw var4;
        }
    }

    public void setTIMESTAMP(int var1, TIMESTAMP var2) throws SQLException {
        synchronized(this.connection) {
            this.setTIMESTAMPInternal(var1, var2);
        }
    }

    void setTIMESTAMPInternal(int var1, TIMESTAMP var2) throws SQLException {
        int var3 = var1 - 1;
        if (var3 >= 0 && var1 <= this.numberOfBindPositions) {
            if (var2 == null) {
                this.currentRowBinders[var3] = this.theTimestampNullBinder;
            } else {
                this.currentRowBinders[var3] = this.theOracleTimestampBinder;
                if (this.parameterDatum == null) {
                    this.parameterDatum = new byte[this.numberOfBindRowsAllocated][this.numberOfBindPositions][];
                }

                this.parameterDatum[this.currentRank][var3] = var2.getBytes();
            }

            this.currentRowByteLens[var3] = this.currentRowBinders[var3].bytelen;
            this.currentRowCharLens[var3] = 0;
        } else {
            SQLException var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 3);
            var4.fillInStackTrace();
            throw var4;
        }
    }

    public void setTIMESTAMPTZ(int var1, TIMESTAMPTZ var2) throws SQLException {
        synchronized(this.connection) {
            this.setTIMESTAMPTZInternal(var1, var2);
        }
    }

    void setTIMESTAMPTZInternal(int var1, TIMESTAMPTZ var2) throws SQLException {
        int var3 = var1 - 1;
        if (var3 >= 0 && var1 <= this.numberOfBindPositions) {
            if (var2 == null) {
                this.currentRowBinders[var3] = this.theTSTZNullBinder;
            } else {
                this.currentRowBinders[var3] = this.theTSTZBinder;
                if (this.parameterDatum == null) {
                    this.parameterDatum = new byte[this.numberOfBindRowsAllocated][this.numberOfBindPositions][];
                }

                this.parameterDatum[this.currentRank][var3] = var2.getBytes();
            }

            this.currentRowByteLens[var3] = this.currentRowBinders[var3].bytelen;
            this.currentRowCharLens[var3] = 0;
        } else {
            SQLException var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 3);
            var4.fillInStackTrace();
            throw var4;
        }
    }

    public void setTIMESTAMPLTZ(int var1, TIMESTAMPLTZ var2) throws SQLException {
        synchronized(this.connection) {
            this.setTIMESTAMPLTZInternal(var1, var2);
        }
    }

    void setTIMESTAMPLTZInternal(int var1, TIMESTAMPLTZ var2) throws SQLException {
        if (this.connection.getSessionTimeZone() == null) {
            SQLException var5 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 105);
            var5.fillInStackTrace();
            throw var5;
        } else {
            int var3 = var1 - 1;
            if (var3 >= 0 && var1 <= this.numberOfBindPositions) {
                if (var2 == null) {
                    this.currentRowBinders[var3] = this.theTSLTZNullBinder;
                } else {
                    this.currentRowBinders[var3] = this.theTSLTZBinder;
                    if (this.parameterDatum == null) {
                        this.parameterDatum = new byte[this.numberOfBindRowsAllocated][this.numberOfBindPositions][];
                    }

                    this.parameterDatum[this.currentRank][var3] = var2.getBytes();
                }

                this.currentRowByteLens[var3] = this.currentRowBinders[var3].bytelen;
                this.currentRowCharLens[var3] = 0;
            } else {
                SQLException var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 3);
                var4.fillInStackTrace();
                throw var4;
            }
        }
    }

    private Reader isReaderEmpty(Reader var1) throws IOException {
        if (!((Reader)var1).markSupported()) {
            var1 = new BufferedReader((Reader)var1, 4096);
        }

        ((Reader)var1).mark(10);
        if (((Reader)var1).read() == -1) {
            return null;
        } else {
            ((Reader)var1).reset();
            return (Reader)var1;
        }
    }

    private InputStream isInputStreamEmpty(InputStream var1) throws IOException {
        if (!((InputStream)var1).markSupported()) {
            var1 = new BufferedInputStream((InputStream)var1, 4096);
        }

        ((InputStream)var1).mark(10);
        if (((InputStream)var1).read() == -1) {
            return null;
        } else {
            ((InputStream)var1).reset();
            return (InputStream)var1;
        }
    }

    public void setAsciiStream(int var1, InputStream var2, int var3) throws SQLException {
        synchronized(this.connection) {
            this.setAsciiStreamInternal(var1, var2, var3);
        }
    }

    void setAsciiStreamInternal(int var1, InputStream var2, int var3) throws SQLException {
        this.setAsciiStreamInternal(var1, var2, (long)var3, true);
    }

    void setAsciiStreamInternal(int var1, InputStream var2, long var3, boolean var5) throws SQLException {
        int var6 = var1 - 1;
        SQLException var7;
        if (var6 >= 0 && var1 <= this.numberOfBindPositions) {
            this.set_execute_batch(1);
            this.checkUserStreamForDuplicates(var2, var6);
            if (var2 == null) {
                this.basicBindNullString(var1);
            } else {
                if (this.userRsetType != DEFAULT_RESULT_SET_TYPE && (var3 > (long)this.maxVcsCharsSql || !var5)) {
                    var7 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 169);
                    var7.fillInStackTrace();
                    throw var7;
                }

                if (!var5) {
                    this.setAsciiStreamContentsForClobCritical(var1, var2, var3, var5);
                } else if (this.currentRowFormOfUse[var6] == 1) {
                    if (this.sqlKind.isPlsqlOrCall()) {
                        if (var3 <= (long)this.maxVcsCharsPlsql) {
                            this.setAsciiStreamContentsForStringInternal(var1, var2, (int)var3);
                        } else {
                            this.setAsciiStreamContentsForClobCritical(var1, var2, var3, var5);
                        }
                    } else if (var3 <= (long)this.maxVcsCharsSql) {
                        this.setAsciiStreamContentsForStringInternal(var1, var2, (int)var3);
                    } else if (var3 > 2147483647L) {
                        this.setAsciiStreamContentsForClobCritical(var1, var2, var3, var5);
                    } else {
                        this.basicBindAsciiStream(var1, var2, (int)var3);
                    }
                } else if (this.sqlKind.isPlsqlOrCall()) {
                    if (var3 <= (long)this.maxVcsNCharsPlsql) {
                        this.setAsciiStreamContentsForStringInternal(var1, var2, (int)var3);
                    } else {
                        this.setAsciiStreamContentsForClobCritical(var1, var2, var3, var5);
                    }
                } else if (var3 <= (long)this.maxVcsNCharsSql) {
                    this.setAsciiStreamContentsForStringInternal(var1, var2, (int)var3);
                } else {
                    this.setAsciiStreamContentsForClobCritical(var1, var2, var3, var5);
                }
            }

        } else {
            var7 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 3);
            var7.fillInStackTrace();
            throw var7;
        }
    }

    void basicBindAsciiStream(int var1, InputStream var2, int var3) throws SQLException {
        synchronized(this.connection) {
            if (this.userRsetType != DEFAULT_RESULT_SET_TYPE) {
                SQLException var8 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 169);
                var8.fillInStackTrace();
                throw var8;
            } else {
                int var5 = var1 - 1;
                this.currentRowBinders[var5] = this.theLongStreamBinder;
                if (this.parameterStream == null) {
                    this.parameterStream = new InputStream[this.numberOfBindRowsAllocated][this.numberOfBindPositions];
                }

                InputStream[] var10000 = this.parameterStream[this.currentRank];
                PhysicalConnection var10004 = this.connection;
                var10000[var5] = this.connection.conversion.ConvertStream(var2, 5, var3);
                this.currentRowByteLens[var5] = this.currentRowBinders[var5].bytelen;
                this.currentRowCharLens[var5] = 0;
            }
        }
    }

    void setAsciiStreamContentsForStringInternal(int var1, InputStream var2, int var3) throws SQLException {
        byte[] var4 = new byte[var3];
        int var5 = 0;
        int var6 = var3;

        int var7;
        try {
            while(var6 > 0 && (var7 = var2.read(var4, var5, var6)) != -1) {
                var5 += var7;
                var6 -= var7;
            }
        } catch (IOException var10) {
            SQLException var9 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), var10);
            var9.fillInStackTrace();
            throw var9;
        }

        char[] var8 = new char[var3];
        DBConversion var10000 = this.connection.conversion;
        DBConversion.asciiBytesToJavaChars(var4, var5, var8);
        this.basicBindString(var1, new String(var8));
    }

    public void setBinaryStream(int var1, InputStream var2, int var3) throws SQLException {
        this.setBinaryStreamInternal(var1, var2, var3);
    }

    void setBinaryStreamInternal(int var1, InputStream var2, int var3) throws SQLException {
        this.setBinaryStreamInternal(var1, var2, (long)var3, true);
    }

    void checkUserStreamForDuplicates(Object var1, int var2) throws SQLException {
        if (var1 != null) {
            if (this.userStream != null) {
                Object[][] var3 = this.userStream;
                int var4 = var3.length;

                for(int var5 = 0; var5 < var4; ++var5) {
                    Object[] var6 = var3[var5];
                    Object[] var7 = var6;
                    int var8 = var6.length;

                    for(int var9 = 0; var9 < var8; ++var9) {
                        Object var10 = var7[var9];
                        if (var10 == var1) {
                            SQLException var11 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 270, var2 + 1);
                            var11.fillInStackTrace();
                            throw var11;
                        }
                    }
                }
            } else {
                this.userStream = new Object[this.numberOfBindRowsAllocated][this.numberOfBindPositions];
            }

            this.userStream[this.currentRank][var2] = var1;
        }
    }

    void setBinaryStreamInternal(int var1, InputStream var2, long var3, boolean var5) throws SQLException {
        synchronized(this.connection) {
            int var7 = var1 - 1;
            SQLException var8;
            if (var7 >= 0 && var1 <= this.numberOfBindPositions) {
                this.set_execute_batch(1);
                this.checkUserStreamForDuplicates(var2, var7);
                if (var2 == null) {
                    this.setRAWInternal(var1, (RAW)null);
                } else {
                    if (this.userRsetType != DEFAULT_RESULT_SET_TYPE && (var3 > (long)this.maxRawBytesSql || !var5)) {
                        var8 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 169);
                        var8.fillInStackTrace();
                        throw var8;
                    }

                    if (!var5) {
                        this.setBinaryStreamContentsForBlobCritical(var1, var2, var3, var5);
                    } else if (this.sqlKind.isPlsqlOrCall()) {
                        if (var3 > (long)this.maxRawBytesPlsql) {
                            this.setBinaryStreamContentsForBlobCritical(var1, var2, var3, var5);
                        } else {
                            this.setBinaryStreamContentsForByteArrayInternal(var1, var2, (int)var3);
                        }
                    } else if (var3 > 2147483647L) {
                        this.setBinaryStreamContentsForBlobCritical(var1, var2, var3, var5);
                    } else if (var3 > (long)this.maxRawBytesSql) {
                        this.basicBindBinaryStream(var1, var2, (int)var3);
                    } else {
                        this.setBinaryStreamContentsForByteArrayInternal(var1, var2, (int)var3);
                    }
                }

            } else {
                var8 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 3);
                var8.fillInStackTrace();
                throw var8;
            }
        }
    }

    void setBinaryStreamContentsForByteArrayInternal(int var1, InputStream var2, int var3) throws SQLException {
        byte[] var4 = new byte[var3];
        int var5 = 0;
        int var6 = var3;

        int var7;
        try {
            while(var6 > 0 && (var7 = var2.read(var4, var5, var6)) != -1) {
                var5 += var7;
                var6 -= var7;
            }
        } catch (IOException var10) {
            SQLException var9 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), var10);
            var9.fillInStackTrace();
            throw var9;
        }

        if (var5 != var3) {
            byte[] var8 = new byte[var5];
            System.arraycopy(var4, 0, var8, 0, var5);
            var4 = var8;
        }

        this.setBytesInternal(var1, var4);
    }

    /** @deprecated */
    public void setUnicodeStream(int var1, InputStream var2, int var3) throws SQLException {
        this.setUnicodeStreamInternal(var1, var2, var3);
    }

    void setUnicodeStreamInternal(int var1, InputStream var2, int var3) throws SQLException {
        synchronized(this.connection) {
            int var5 = var1 - 1;
            SQLException var6;
            if (var5 >= 0 && var1 <= this.numberOfBindPositions) {
                this.set_execute_batch(1);
                this.checkUserStreamForDuplicates(var2, var5);
                if (var2 == null) {
                    this.setStringInternal(var1, (String)null);
                } else {
                    if (this.userRsetType != DEFAULT_RESULT_SET_TYPE && var3 > this.maxVcsCharsSql) {
                        var6 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 169);
                        var6.fillInStackTrace();
                        throw var6;
                    }

                    if (!this.sqlKind.isPlsqlOrCall() && var3 > this.maxVcsCharsSql) {
                        this.currentRowBinders[var5] = this.theLongStreamBinder;
                        if (this.parameterStream == null) {
                            this.parameterStream = new InputStream[this.numberOfBindRowsAllocated][this.numberOfBindPositions];
                        }

                        InputStream[] var16 = this.parameterStream[this.currentRank];
                        PhysicalConnection var10004 = this.connection;
                        var16[var5] = this.connection.conversion.ConvertStream(var2, 4, var3);
                        this.currentRowByteLens[var5] = 0;
                        this.currentRowCharLens[var5] = 0;
                    } else {
                        byte[] var15 = new byte[var3];
                        int var7 = 0;
                        int var8 = var3;

                        int var9;
                        try {
                            while(var8 > 0 && (var9 = var2.read(var15, var7, var8)) != -1) {
                                var7 += var9;
                                var8 -= var9;
                            }
                        } catch (IOException var13) {
                            SQLException var11 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), var13);
                            var11.fillInStackTrace();
                            throw var11;
                        }

                        char[] var10 = new char[var7 >> 1];
                        DBConversion var10000 = this.connection.conversion;
                        DBConversion.ucs2BytesToJavaChars(var15, var7, var10);
                        this.setStringInternal(var1, new String(var10));
                    }
                }

            } else {
                var6 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 3);
                var6.fillInStackTrace();
                throw var6;
            }
        }
    }

    /** @deprecated */
    public void setCustomDatum(int var1, CustomDatum var2) throws SQLException {
        synchronized(this.connection) {
            this.setObjectInternal(var1, this.connection.toDatum(var2));
        }
    }

    void setCustomDatumInternal(int var1, CustomDatum var2) throws SQLException {
        synchronized(this.connection) {
            Datum var4 = this.connection.toDatum(var2);
            int var5 = this.sqlTypeForObject(var4);
            this.setObjectCritical(var1, var4, var5, 0);
        }
    }

    public void setORAData(int var1, ORAData var2) throws SQLException {
        this.setORADataInternal(var1, var2);
    }

    void setORADataInternal(int var1, ORAData var2) throws SQLException {
        synchronized(this.connection) {
            Datum var4 = var2.toDatum(this.connection);
            int var5 = this.sqlTypeForObject(var4);
            this.setObjectCritical(var1, var4, var5, 0);
            if (var5 == 2002 || var5 == 2008 || var5 == 2003) {
                this.currentRowCharLens[var1 - 1] = 0;
            }

        }
    }

    void setOracleDataInternal(int var1, OracleData var2) throws SQLException {
        synchronized(this.connection) {
            Object var4 = var2.toJDBCObject(this.connection);
            if (var4 instanceof _Proxy_) {
                final _Proxy_ var5 = (_Proxy_)var4;
                var4 = AccessController.doPrivileged(new PrivilegedAction<Object>() {
                    public Object run() {
                        return ProxyFactory.extractDelegate(var5);
                    }
                });
            }

            int var8 = this.sqlTypeForObject(var4);
            this.setObjectCritical(var1, var4, var8, 0);
            if (var8 == 2002 || var8 == 2008 || var8 == 2003) {
                this.currentRowCharLens[var1 - 1] = 0;
            }

        }
    }

    public void setObject(int var1, Object var2, int var3, int var4) throws SQLException {
        synchronized(this.connection) {
            this.setObjectInternal(var1, var2, var3, var4);
        }
    }

    void setObjectInternal(int var1, Object var2, int var3, int var4) throws SQLException {
        if (var2 == null && var3 != 2002 && var3 != 2008 && var3 != 2003 && var3 != 2007 && var3 != 2006 && var3 != 2009) {
            this.setNullInternal(var1, var3);
        } else if (var3 != 2002 && var3 != 2008 && var3 != 2003 && var3 != 2009) {
            this.setObjectCritical(var1, var2, var3, var4);
        } else {
            this.setObjectCritical(var1, var2, var3, var4);
            this.currentRowCharLens[var1 - 1] = 0;
        }

    }

    void setObjectCritical(int var1, Object var2, int var3, int var4) throws SQLException {
        SQLException var5;
        switch(var3) {
            case -104:
                this.setINTERVALDSInternal(var1, (INTERVALDS)var2);
                break;
            case -103:
                this.setINTERVALYMInternal(var1, (INTERVALYM)var2);
                break;
            case -102:
                this.setTIMESTAMPLTZInternal(var1, (TIMESTAMPLTZ)var2);
                break;
            case -101:
                this.setTIMESTAMPTZInternal(var1, (TIMESTAMPTZ)var2);
                break;
            case -100:
                this.setTIMESTAMPInternal(var1, (TIMESTAMP)var2);
                break;
            case -16:
                this.setFormOfUse(var1, (short)2);
            case -1:
                if (var2 instanceof String) {
                    this.setStringInternal(var1, (String)var2);
                } else if (var2 instanceof Boolean) {
                    this.setStringInternal(var1, "" + ((Boolean)var2 ? 1 : 0));
                } else if (var2 instanceof Integer) {
                    this.setStringInternal(var1, "" + (Integer)var2);
                } else if (var2 instanceof Long) {
                    this.setStringInternal(var1, "" + (Long)var2);
                } else if (var2 instanceof Float) {
                    this.setStringInternal(var1, "" + (Float)var2);
                } else if (var2 instanceof Double) {
                    this.setStringInternal(var1, "" + (Double)var2);
                } else if (var2 instanceof BigDecimal) {
                    this.setStringInternal(var1, ((BigDecimal)var2).toString());
                } else if (var2 instanceof Date) {
                    this.setStringInternal(var1, "" + ((Date)var2).toString());
                } else if (var2 instanceof Time) {
                    this.setStringInternal(var1, "" + ((Time)var2).toString());
                } else if (var2 instanceof Timestamp) {
                    this.setStringInternal(var1, "" + ((Timestamp)var2).toString());
                } else {
                    if (!(var2 instanceof URL)) {
                        var5 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 132);
                        var5.fillInStackTrace();
                        throw var5;
                    }

                    this.setStringInternal(var1, "" + ((URL)var2).toString());
                }
                break;
            case -15:
                this.setFormOfUse(var1, (short)2);
            case 1:
                if (var2 instanceof CHAR) {
                    this.setCHARInternal(var1, (CHAR)var2);
                } else if (var2 instanceof String) {
                    this.setStringInternal(var1, (String)var2);
                } else if (var2 instanceof Boolean) {
                    this.setStringInternal(var1, "" + ((Boolean)var2 ? 1 : 0));
                } else if (var2 instanceof Integer) {
                    this.setStringInternal(var1, "" + (Integer)var2);
                } else if (var2 instanceof Long) {
                    this.setStringInternal(var1, "" + (Long)var2);
                } else if (var2 instanceof Float) {
                    this.setStringInternal(var1, "" + (Float)var2);
                } else if (var2 instanceof Double) {
                    this.setStringInternal(var1, "" + (Double)var2);
                } else if (var2 instanceof BigDecimal) {
                    this.setStringInternal(var1, ((BigDecimal)var2).toString());
                } else if (var2 instanceof Date) {
                    this.setStringInternal(var1, "" + ((Date)var2).toString());
                } else if (var2 instanceof Time) {
                    this.setStringInternal(var1, "" + ((Time)var2).toString());
                } else if (var2 instanceof Timestamp) {
                    this.setStringInternal(var1, "" + ((Timestamp)var2).toString());
                } else {
                    if (!(var2 instanceof URL)) {
                        var5 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 132);
                        var5.fillInStackTrace();
                        throw var5;
                    }

                    this.setStringInternal(var1, "" + ((URL)var2).toString());
                }
                break;
            case -13:
                this.setBFILEInternal(var1, (BFILE)var2);
                break;
            case -9:
                this.setFormOfUse(var1, (short)2);
            case 12:
                if (var2 instanceof String) {
                    this.setStringInternal(var1, (String)var2);
                } else if (var2 instanceof Boolean) {
                    this.setStringInternal(var1, "" + ((Boolean)var2 ? 1 : 0));
                } else if (var2 instanceof Integer) {
                    this.setStringInternal(var1, "" + (Integer)var2);
                } else if (var2 instanceof Long) {
                    this.setStringInternal(var1, "" + (Long)var2);
                } else if (var2 instanceof Float) {
                    this.setStringInternal(var1, "" + (Float)var2);
                } else if (var2 instanceof Double) {
                    this.setStringInternal(var1, "" + (Double)var2);
                } else if (var2 instanceof BigDecimal) {
                    this.setStringInternal(var1, ((BigDecimal)var2).toString());
                } else if (var2 instanceof Date) {
                    this.setStringInternal(var1, "" + ((Date)var2).toString());
                } else if (var2 instanceof Time) {
                    this.setStringInternal(var1, "" + ((Time)var2).toString());
                } else if (var2 instanceof Timestamp) {
                    this.setStringInternal(var1, "" + ((Timestamp)var2).toString());
                } else {
                    if (!(var2 instanceof URL)) {
                        var5 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 132);
                        var5.fillInStackTrace();
                        throw var5;
                    }

                    this.setStringInternal(var1, "" + ((URL)var2).toString());
                }
                break;
            case -8:
                this.setROWIDInternal(var1, (ROWID)var2);
                break;
            case -7:
                if (var2 instanceof Boolean) {
                    this.setByteInternal(var1, (byte)((Boolean)var2 ? 1 : 0));
                } else if (var2 instanceof String) {
                    this.setByteInternal(var1, (byte)(!"true".equalsIgnoreCase((String)var2) && !"1".equals(var2) ? 0 : 1));
                } else {
                    if (!(var2 instanceof Number)) {
                        var5 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 132);
                        var5.fillInStackTrace();
                        throw var5;
                    }

                    this.setIntInternal(var1, ((Number)var2).byteValue() != 0 ? 1 : 0);
                }
                break;
            case -6:
                if (var2 instanceof Number) {
                    this.setByteInternal(var1, ((Number)var2).byteValue());
                } else if (var2 instanceof String) {
                    this.setByteInternal(var1, Byte.parseByte((String)var2));
                } else {
                    if (!(var2 instanceof Boolean)) {
                        var5 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 132);
                        var5.fillInStackTrace();
                        throw var5;
                    }

                    this.setByteInternal(var1, (byte)((Boolean)var2 ? 1 : 0));
                }
                break;
            case -5:
                if (var2 instanceof Number) {
                    this.setLongInternal(var1, ((Number)var2).longValue());
                } else if (var2 instanceof String) {
                    this.setLongInternal(var1, Long.parseLong((String)var2));
                } else {
                    if (!(var2 instanceof Boolean)) {
                        var5 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 132);
                        var5.fillInStackTrace();
                        throw var5;
                    }

                    this.setLongInternal(var1, (Boolean)var2 ? 1L : 0L);
                }
                break;
            case -4:
                this.setBytesInternal(var1, (byte[])((byte[])var2));
                break;
            case -3:
                this.setBytesInternal(var1, (byte[])((byte[])var2));
                break;
            case -2:
                if (var2 instanceof RAW) {
                    this.setRAWInternal(var1, (RAW)var2);
                } else {
                    this.setBytesInternal(var1, (byte[])((byte[])var2));
                }
                break;
            case 2:
                if (var2 instanceof NUMBER) {
                    this.setNUMBERInternal(var1, (NUMBER)var2);
                } else if (var2 instanceof Integer) {
                    this.setIntInternal(var1, (Integer)var2);
                } else if (var2 instanceof Long) {
                    this.setLongInternal(var1, (Long)var2);
                } else if (var2 instanceof Float) {
                    this.setFloatInternal(var1, (Float)var2);
                } else if (var2 instanceof Double) {
                    this.setDoubleInternal(var1, (Double)var2);
                } else if (var2 instanceof BigDecimal) {
                    this.setBigDecimalInternal(var1, (BigDecimal)var2);
                } else if (var2 instanceof BigInteger) {
                    this.setBigDecimalInternal(var1, new BigDecimal((BigInteger)var2));
                } else if (var2 instanceof String) {
                    this.setNUMBERInternal(var1, new NUMBER((String)var2, var4));
                } else if (var2 instanceof Boolean) {
                    this.setIntInternal(var1, (Boolean)var2 ? 1 : 0);
                } else if (var2 instanceof Short) {
                    this.setShortInternal(var1, (Short)var2);
                } else {
                    if (!(var2 instanceof Byte)) {
                        var5 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 132);
                        var5.fillInStackTrace();
                        throw var5;
                    }

                    this.setByteInternal(var1, (Byte)var2);
                }
                break;
            case 3:
                if (var2 instanceof BigDecimal) {
                    this.setBigDecimalInternal(var1, (BigDecimal)var2);
                } else if (var2 instanceof Number) {
                    this.setBigDecimalInternal(var1, new BigDecimal(((Number)var2).doubleValue()));
                } else if (var2 instanceof NUMBER) {
                    this.setBigDecimalInternal(var1, ((NUMBER)var2).bigDecimalValue());
                } else if (var2 instanceof String) {
                    this.setBigDecimalInternal(var1, new BigDecimal((String)var2));
                } else {
                    if (!(var2 instanceof Boolean)) {
                        var5 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 132);
                        var5.fillInStackTrace();
                        throw var5;
                    }

                    this.setBigDecimalInternal(var1, new BigDecimal((Boolean)var2 ? 1.0D : 0.0D));
                }
                break;
            case 4:
                if (var2 instanceof Number) {
                    this.setIntInternal(var1, ((Number)var2).intValue());
                } else if (var2 instanceof String) {
                    this.setIntInternal(var1, Integer.parseInt((String)var2));
                } else {
                    if (!(var2 instanceof Boolean)) {
                        var5 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 132);
                        var5.fillInStackTrace();
                        throw var5;
                    }

                    this.setIntInternal(var1, (Boolean)var2 ? 1 : 0);
                }
                break;
            case 5:
                if (var2 instanceof Number) {
                    this.setShortInternal(var1, ((Number)var2).shortValue());
                } else if (var2 instanceof String) {
                    this.setShortInternal(var1, Short.parseShort((String)var2));
                } else {
                    if (!(var2 instanceof Boolean)) {
                        var5 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 132);
                        var5.fillInStackTrace();
                        throw var5;
                    }

                    this.setShortInternal(var1, (short)((Boolean)var2 ? 1 : 0));
                }
                break;
            case 6:
            case 8:
                if (var2 instanceof Number) {
                    this.setDoubleInternal(var1, ((Number)var2).doubleValue());
                } else if (var2 instanceof String) {
                    this.setDoubleInternal(var1, Double.valueOf((String)var2));
                } else {
                    if (!(var2 instanceof Boolean)) {
                        var5 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 132);
                        var5.fillInStackTrace();
                        throw var5;
                    }

                    this.setDoubleInternal(var1, (Boolean)var2 ? 1.0D : 0.0D);
                }
                break;
            case 7:
                if (var2 instanceof Number) {
                    this.setFloatInternal(var1, ((Number)var2).floatValue());
                } else if (var2 instanceof String) {
                    this.setFloatInternal(var1, Float.valueOf((String)var2));
                } else {
                    if (!(var2 instanceof Boolean)) {
                        var5 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 132);
                        var5.fillInStackTrace();
                        throw var5;
                    }

                    this.setFloatInternal(var1, (Boolean)var2 ? 1.0F : 0.0F);
                }
                break;
            case 91:
                if (var2 instanceof DATE) {
                    this.setDATEInternal(var1, (DATE)var2);
                } else if (var2 instanceof Date) {
                    this.setDATEInternal(var1, new DATE(var2, this.getDefaultCalendar()));
                } else if (var2 instanceof Timestamp) {
                    this.setDATEInternal(var1, new DATE((Timestamp)var2));
                } else {
                    if (!(var2 instanceof String)) {
                        var5 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 132);
                        var5.fillInStackTrace();
                        throw var5;
                    }

                    this.setDateInternal(var1, Date.valueOf((String)var2));
                }
                break;
            case 92:
                if (var2 instanceof Time) {
                    this.setTimeInternal(var1, (Time)var2);
                } else if (var2 instanceof Timestamp) {
                    this.setTimeInternal(var1, new Time(((Timestamp)var2).getTime()));
                } else if (var2 instanceof Date) {
                    this.setTimeInternal(var1, new Time(((Date)var2).getTime()));
                } else {
                    if (!(var2 instanceof String)) {
                        var5 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 132);
                        var5.fillInStackTrace();
                        throw var5;
                    }

                    this.setTimeInternal(var1, Time.valueOf((String)var2));
                }
                break;
            case 93:
                if (var2 instanceof TIMESTAMP) {
                    this.setTIMESTAMPInternal(var1, (TIMESTAMP)var2);
                } else if (var2 instanceof Timestamp) {
                    this.setTimestampInternal(var1, (Timestamp)var2);
                } else if (var2 instanceof Date) {
                    this.setTIMESTAMPInternal(var1, new TIMESTAMP((Date)var2));
                } else if (var2 instanceof DATE) {
                    this.setTIMESTAMPInternal(var1, new TIMESTAMP(((DATE)var2).timestampValue()));
                } else {
                    if (!(var2 instanceof String)) {
                        var5 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 132);
                        var5.fillInStackTrace();
                        throw var5;
                    }

                    this.setTimestampInternal(var1, Timestamp.valueOf((String)var2));
                }
                break;
            case 100:
                this.setBinaryFloatInternal(var1, (BINARY_FLOAT)var2);
                break;
            case 101:
                this.setBinaryDoubleInternal(var1, (BINARY_DOUBLE)var2);
                break;
            case 999:
                this.setFixedCHARInternal(var1, (String)var2);
                break;
            case 2002:
            case 2008:
                this.setSTRUCTInternal(var1, STRUCT.toSTRUCT(var2, this.connection));
                break;
            case 2003:
                this.setARRAYInternal(var1, ARRAY.toARRAY(var2, this.connection));
                break;
            case 2004:
                this.setBLOBInternal(var1, (BLOB)var2);
                break;
            case 2005:
            case 2011:
                this.setCLOBInternal(var1, (CLOB)var2);
                if (((CLOB)var2).isNCLOB()) {
                    this.setFormOfUse(var1, (short)2);
                }
                break;
            case 2006:
                this.setREFInternal(var1, (REF)var2);
                break;
            case 2007:
                this.setOPAQUEInternal(var1, (OPAQUE)var2);
                break;
            case 2009:
                this.setSQLXMLInternal(var1, (SQLXML)var2);
                break;
            default:
                var5 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 4);
                var5.fillInStackTrace();
                throw var5;
        }

    }

    public void setObjectAtName(String var1, Object var2, int var3, int var4) throws SQLException {
        if (var1 == null) {
            SQLException var10 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 68);
            var10.fillInStackTrace();
            throw var10;
        } else {
            String var5 = var1.intern();
            String[] var6 = this.sqlObject.getParameterList();
            boolean var7 = false;
            int var8 = Math.min(this.sqlObject.getParameterCount(), var6.length);

            for(int var9 = 0; var9 < var8; ++var9) {
                if (var6[var9] == var5) {
                    this.setObjectInternal(var9 + 1, var2);
                    var7 = true;
                }
            }

            if (!var7) {
                SQLException var11 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 147, var1);
                var11.fillInStackTrace();
                throw var11;
            }
        }
    }

    public void setObject(int var1, Object var2, int var3) throws SQLException {
        this.setObjectInternal(var1, var2, var3, 0);
    }

    void setObjectInternal(int var1, Object var2, int var3) throws SQLException {
        this.setObjectInternal(var1, var2, var3, 0);
    }

    public void setRefType(int var1, REF var2) throws SQLException {
        this.setREFInternal(var1, var2);
    }

    void setRefTypeInternal(int var1, REF var2) throws SQLException {
        this.setREFInternal(var1, var2);
    }

    public void setRef(int var1, Ref var2) throws SQLException {
        this.setREFInternal(var1, (REF)var2);
    }

    void setRefInternal(int var1, Ref var2) throws SQLException {
        this.setREFInternal(var1, (REF)var2);
    }

    public void setREF(int var1, REF var2) throws SQLException {
        this.setREFInternal(var1, var2);
    }

    void setREFInternal(int var1, REF var2) throws SQLException {
        int var3 = var1 - 1;
        SQLException var4;
        if (var3 >= 0 && var1 <= this.numberOfBindPositions) {
            if (var2 == null) {
                var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 68);
                var4.fillInStackTrace();
                throw var4;
            } else {
                this.setREFCritical(var3, var2);
                this.currentRowCharLens[var3] = 0;
            }
        } else {
            var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 3);
            var4.fillInStackTrace();
            throw var4;
        }
    }

    void setREFCritical(int var1, REF var2) throws SQLException {
        StructDescriptor var3 = var2.getDescriptor();
        if (var3 == null) {
            SQLException var5 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 52);
            var5.fillInStackTrace();
            throw var5;
        } else {
            this.currentRowBinders[var1] = this.theRefTypeBinder;
            if (this.parameterDatum == null) {
                this.parameterDatum = new byte[this.numberOfBindRowsAllocated][this.numberOfBindPositions][];
            }

            this.parameterDatum[this.currentRank][var1] = var2.getBytes();
            OracleTypeADT var4 = var3.getOracleTypeADT();
            var4.getTOID();
            if (this.parameterOtype == null) {
                this.parameterOtype = new OracleTypeADT[this.numberOfBindRowsAllocated][this.numberOfBindPositions];
            }

            this.parameterOtype[this.currentRank][var1] = var4;
            this.currentRowByteLens[var1] = this.currentRowBinders[var1].bytelen;
            this.currentRowCharLens[var1] = 0;
        }
    }

    public void setObject(int var1, Object var2) throws SQLException {
        this.setObjectInternal(var1, var2);
    }

    void setObjectInternal(int var1, Object var2) throws SQLException {
        if (var2 instanceof ORAData) {
            this.setORADataInternal(var1, (ORAData)var2);
        } else if (var2 instanceof CustomDatum) {
            this.setCustomDatumInternal(var1, (CustomDatum)var2);
        } else if (var2 instanceof OracleData) {
            this.setOracleDataInternal(var1, (OracleData)var2);
        } else {
            int var3 = this.sqlTypeForObject(var2);
            this.setObjectInternal(var1, var2, var3, 0);
        }

    }

    public void setOracleObject(int var1, Datum var2) throws SQLException {
        this.setObjectInternal(var1, var2);
    }

    void setOracleObjectInternal(int var1, Datum var2) throws SQLException {
        this.setObjectInternal(var1, var2);
    }

    public void setPlsqlIndexTable(int var1, Object var2, int var3, int var4, int var5, int var6) throws SQLException {
        synchronized(this.connection) {
            this.setPlsqlIndexTableInternal(var1, var2, var3, var4, var5, var6);
        }
    }

    void setPlsqlIndexTableInternal(int var1, Object var2, int var3, int var4, int var5, int var6) throws SQLException {
        int var7 = var1 - 1;
        SQLException var8;
        if (var7 >= 0 && var1 <= this.numberOfBindPositions) {
            if (var2 == null) {
                var8 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 271);
                var8.fillInStackTrace();
                throw var8;
            } else {
                int var15 = this.getInternalType(var5);
                Object var9 = null;
                SQLException var17;
                switch(var15) {
                    case 1:
                    case 96:
                        String[] var10 = null;
                        boolean var11 = false;
                        int var16;
                        if (var2 instanceof CHAR[]) {
                            CHAR[] var18 = (CHAR[])((CHAR[])var2);
                            var16 = var18.length;
                            var10 = new String[var16];

                            for(int var13 = 0; var13 < var16; ++var13) {
                                CHAR var14 = var18[var13];
                                if (var14 != null) {
                                    var10[var13] = var14.getString();
                                }
                            }
                        } else {
                            if (!(var2 instanceof String[])) {
                                SQLException var12 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 97);
                                var12.fillInStackTrace();
                                throw var12;
                            }

                            var10 = (String[])((String[])var2);
                            var16 = var10.length;
                        }

                        if (var6 == 0 && var10 != null) {
                            for(int var19 = 0; var19 < var16; ++var19) {
                                String var20 = var10[var19];
                                if (var20 != null && var6 < var20.length()) {
                                    var6 = var20.length();
                                }
                            }
                        }

                        var9 = var10;
                        break;
                    case 2:
                    case 6:
                        var9 = OracleTypeNUMBER.toNUMBERArray(var2, this.connection, 1L, var4);
                        if (var6 == 0 && var9 != null) {
                            var6 = 22;
                        }

                        this.currentRowCharLens[var7] = 0;
                        break;
                    default:
                        var17 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 97);
                        var17.fillInStackTrace();
                        throw var17;
                }

                if (((Object[])var9).length == 0 && var3 == 0) {
                    var17 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 272);
                    var17.fillInStackTrace();
                    throw var17;
                } else {
                    this.currentRowBinders[var7] = this.thePlsqlIbtBinder;
                    this.currentRowByteLens[var7] = this.currentRowBinders[var7].bytelen;
                    this.currentRowCharLens[var7] = 0;
                    if (this.parameterPlsqlIbt == null) {
                        this.parameterPlsqlIbt = new PlsqlIbtBindInfo[this.numberOfBindRowsAllocated][this.numberOfBindPositions];
                    }

                    this.parameterPlsqlIbt[this.currentRank][var7] = new PlsqlIbtBindInfo(this, (Object[])var9, var3, var4, var15, var6);
                    this.hasIbtBind = true;
                }
            }
        } else {
            var8 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 3);
            var8.fillInStackTrace();
            throw var8;
        }
    }

    public void setPlsqlIndexTableAtName(String var1, Object var2, int var3, int var4, int var5, int var6) throws SQLException {
        synchronized(this.connection) {
            if (var1 == null) {
                SQLException var16 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 68);
                var16.fillInStackTrace();
                throw var16;
            } else {
                String var8 = var1.intern();
                String[] var9 = this.sqlObject.getParameterList();
                boolean var10 = false;
                int var11 = Math.min(this.sqlObject.getParameterCount(), var9.length);

                for(int var12 = 0; var12 < var11; ++var12) {
                    if (var9[var12] == var8) {
                        this.setPlsqlIndexTableInternal(var12 + 1, var2, var3, var4, var5, var6);
                        var10 = true;
                    }
                }

                if (!var10) {
                    SQLException var15 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 147, var1);
                    var15.fillInStackTrace();
                    throw var15;
                }
            }
        }
    }

    void endOfResultSet(boolean var1) throws SQLException {
        if (!var1) {
            this.prepareForNewResults(false, false, false);
        }

        this.rowPrefetchInLastFetch = -1;
    }

    int sqlTypeForObject(Object var1) {
        if (var1 == null) {
            return 0;
        } else {
            if (!(var1 instanceof Datum)) {
                if (var1 instanceof String) {
                    return this.fixedString ? 999 : 12;
                }

                if (var1 instanceof BigDecimal) {
                    return 2;
                }

                if (var1 instanceof BigInteger) {
                    return 2;
                }

                if (var1 instanceof Boolean) {
                    return -7;
                }

                if (var1 instanceof Integer) {
                    return 4;
                }

                if (var1 instanceof Long) {
                    return -5;
                }

                if (var1 instanceof Float) {
                    return 7;
                }

                if (var1 instanceof Double) {
                    return 8;
                }

                if (var1 instanceof byte[]) {
                    return -3;
                }

                if (var1 instanceof Short) {
                    return 5;
                }

                if (var1 instanceof Byte) {
                    return -6;
                }

                if (var1 instanceof Date) {
                    return 91;
                }

                if (var1 instanceof Time) {
                    return 92;
                }

                if (var1 instanceof Timestamp) {
                    return 93;
                }

                if (var1 instanceof SQLData) {
                    return 2002;
                }

                if (var1 instanceof ObjectData) {
                    return 2002;
                }

                if (var1 instanceof URL) {
                    return this.fixedString ? 999 : 12;
                }
            } else {
                if (var1 instanceof BINARY_FLOAT) {
                    return 100;
                }

                if (var1 instanceof BINARY_DOUBLE) {
                    return 101;
                }

                if (var1 instanceof BLOB) {
                    return 2004;
                }

                if (var1 instanceof CLOB) {
                    return 2005;
                }

                if (var1 instanceof BFILE) {
                    return -13;
                }

                if (var1 instanceof ROWID) {
                    return -8;
                }

                if (var1 instanceof NUMBER) {
                    return 2;
                }

                if (var1 instanceof DATE) {
                    return 91;
                }

                if (var1 instanceof TIMESTAMP) {
                    return 93;
                }

                if (var1 instanceof TIMESTAMPTZ) {
                    return -101;
                }

                if (var1 instanceof TIMESTAMPLTZ) {
                    return -102;
                }

                if (var1 instanceof REF) {
                    return 2006;
                }

                if (var1 instanceof CHAR) {
                    return 1;
                }

                if (var1 instanceof RAW) {
                    return -2;
                }

                if (var1 instanceof ARRAY) {
                    return 2003;
                }

                if (var1 instanceof STRUCT) {
                    return 2002;
                }

                if (var1 instanceof OPAQUE) {
                    return 2007;
                }

                if (var1 instanceof INTERVALYM) {
                    return -103;
                }

                if (var1 instanceof INTERVALDS) {
                    return -104;
                }

                if (var1 instanceof SQLXML) {
                    return 2009;
                }
            }

            return 1111;
        }
    }

    public void clearParameters() throws SQLException {
        synchronized(this.connection) {
            this.clearParameters = true;

            for(int var2 = 0; var2 < this.numberOfBindPositions; ++var2) {
                this.currentRowBinders[var2] = null;
            }

        }
    }

    void printByteArray(byte[] var1) {
        if (var1 != null) {
            int var3 = var1.length;

            for(int var2 = 0; var2 < var3; ++var2) {
                int var4 = var1[var2] & 255;
                if (var4 < 16) {
                }
            }
        }

    }

    public void setCharacterStream(int var1, Reader var2, int var3) throws SQLException {
        this.setCharacterStreamInternal(var1, var2, var3);
    }

    void setCharacterStreamInternal(int var1, Reader var2, int var3) throws SQLException {
        this.setCharacterStreamInternal(var1, var2, (long)var3, true);
    }

    void setCharacterStreamInternal(int var1, Reader var2, long var3, boolean var5) throws SQLException {
        int var6 = var1 - 1;
        SQLException var7;
        if (var6 >= 0 && var1 <= this.numberOfBindPositions) {
            this.set_execute_batch(1);
            this.checkUserStreamForDuplicates(var2, var6);
            if (var2 == null) {
                this.basicBindNullString(var1);
            } else {
                if (this.userRsetType != DEFAULT_RESULT_SET_TYPE && (var3 > (long)this.maxVcsCharsSql || !var5)) {
                    var7 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 169);
                    var7.fillInStackTrace();
                    throw var7;
                }

                if (!var5) {
                    this.setReaderContentsForClobCritical(var1, var2, var3, var5);
                } else if (this.currentRowFormOfUse[var6] == 1) {
                    if (this.sqlKind.isPlsqlOrCall()) {
                        if (var3 <= (long)this.maxVcsBytesPlsql && (var3 <= (long)this.maxVcsCharsPlsql || !this.isServerCharSetFixedWidth)) {
                            if (var3 <= (long)this.maxVcsCharsPlsql) {
                                this.setReaderContentsForStringInternal(var1, var2, (int)var3);
                            } else {
                                this.setReaderContentsForStringOrClobInVariableWidthCase(var1, var2, (int)var3, false);
                            }
                        } else {
                            this.setReaderContentsForClobCritical(var1, var2, var3, var5);
                        }
                    } else if (var3 <= (long)this.maxVcsCharsSql) {
                        this.setReaderContentsForStringInternal(var1, var2, (int)var3);
                    } else if (var3 > 2147483647L) {
                        this.setReaderContentsForClobCritical(var1, var2, var3, var5);
                    } else {
                        this.basicBindCharacterStream(var1, var2, (int)var3, false);
                    }
                } else if (this.sqlKind.isPlsqlOrCall()) {
                    if (var3 > (long)this.maxVcsBytesPlsql || var3 > (long)this.maxVcsNCharsPlsql && this.isServerCharSetFixedWidth) {
                        this.setReaderContentsForClobCritical(var1, var2, var3, var5);
                    } else if (var3 <= (long)this.maxVcsNCharsPlsql) {
                        this.setReaderContentsForStringInternal(var1, var2, (int)var3);
                    } else {
                        this.setReaderContentsForStringOrClobInVariableWidthCase(var1, var2, (int)var3, true);
                    }
                } else if (var3 <= (long)this.maxVcsNCharsSql) {
                    this.setReaderContentsForStringInternal(var1, var2, (int)var3);
                } else {
                    this.setReaderContentsForClobCritical(var1, var2, var3, var5);
                }
            }

        } else {
            var7 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 3);
            var7.fillInStackTrace();
            throw var7;
        }
    }

    void basicBindCharacterStream(int var1, Reader var2, int var3, boolean var4) throws SQLException {
        synchronized(this.connection) {
            int var6 = var1 - 1;
            if (var4) {
                this.currentRowBinders[var6] = this.theLongStreamForStringBinder;
            } else {
                this.currentRowBinders[var6] = this.theLongStreamBinder;
            }

            if (this.parameterStream == null) {
                this.parameterStream = new InputStream[this.numberOfBindRowsAllocated][this.numberOfBindPositions];
            }

            InputStream[] var10000 = this.parameterStream[this.currentRank];
            InputStream var10002;
            PhysicalConnection var10004;
            if (var4) {
                var10004 = this.connection;
                var10002 = this.connection.conversion.ConvertStreamInternal(var2, 7, var3, this.currentRowFormOfUse[var6]);
            } else {
                var10004 = this.connection;
                var10002 = this.connection.conversion.ConvertStream(var2, 7, var3, this.currentRowFormOfUse[var6]);
            }

            var10000[var6] = var10002;
            this.currentRowByteLens[var6] = 0;
            this.currentRowCharLens[var6] = 0;
        }
    }

    void setReaderContentsForStringOrClobInVariableWidthCase(int var1, Reader var2, int var3, boolean var4) throws SQLException {
        char[] var5 = new char[var3];
        int var6 = 0;
        int var7 = var3;

        int var8;
        try {
            while(var7 > 0 && (var8 = var2.read(var5, var6, var7)) != -1) {
                var6 += var8;
                var7 -= var8;
            }
        } catch (IOException var11) {
            SQLException var10 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), var11);
            var10.fillInStackTrace();
            throw var10;
        }

        if (var6 != var3) {
            char[] var9 = new char[var6];
            System.arraycopy(var5, 0, var9, 0, var6);
            var5 = var9;
        }

        int var12 = this.connection.conversion.encodedByteLength(var5, var4);
        if (var12 < this.maxVcsBytesPlsql) {
            this.setStringInternal(var1, new String(var5));
        } else {
            this.setStringForClobCritical(var1, new String(var5));
        }

    }

    void setReaderContentsForStringInternal(int var1, Reader var2, int var3) throws SQLException {
        char[] var4 = new char[var3];
        int var5 = 0;
        int var6 = var3;

        int var7;
        try {
            while(var6 > 0 && (var7 = var2.read(var4, var5, var6)) != -1) {
                var5 += var7;
                var6 -= var7;
            }
        } catch (IOException var10) {
            SQLException var9 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), var10);
            var9.fillInStackTrace();
            throw var9;
        }

        if (var5 != var3) {
            char[] var8 = new char[var5];
            System.arraycopy(var4, 0, var8, 0, var5);
            var4 = var8;
        }

        this.setStringInternal(var1, new String(var4));
    }

    public void setDate(int var1, Date var2, Calendar var3) throws SQLException {
        this.setDATEInternal(var1, var2 == null ? null : new DATE(var2, var3));
    }

    void setDateInternal(int var1, Date var2, Calendar var3) throws SQLException {
        this.setDATEInternal(var1, var2 == null ? null : new DATE(var2, var3));
    }

    public void setTime(int var1, Time var2, Calendar var3) throws SQLException {
        this.setDATEInternal(var1, var2 == null ? null : new DATE(var2, var3));
    }

    void setTimeInternal(int var1, Time var2, Calendar var3) throws SQLException {
        this.setDATEInternal(var1, var2 == null ? null : new DATE(var2, var3));
    }

    public void setTimestamp(int var1, Timestamp var2, Calendar var3) throws SQLException {
        this.setTimestampInternal(var1, var2, var3);
    }

    void setTimestampInternal(int var1, Timestamp var2, Calendar var3) throws SQLException {
        this.setTIMESTAMPInternal(var1, var2 == null ? null : new TIMESTAMP(var2, var3));
    }

    public void setCheckBindTypes(boolean var1) {
        this.checkBindTypes = var1;
    }

    final void setOracleBatchStyle() throws SQLException {
        if (this.m_batchStyle == 2) {
            SQLException var1 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 90, "operation cannot be mixed with JDBC-2.0-style batching");
            var1.fillInStackTrace();
            throw var1;
        } else {
            if (this.m_batchStyle == 0) {
            }

            this.m_batchStyle = 1;
        }
    }

    boolean isOracleBatchStyle() {
        return this.m_batchStyle == 1;
    }

    final void setJdbcBatchStyle() throws SQLException {
        if (this.m_batchStyle == 1) {
            SQLException var1 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 90, "operation cannot be mixed with Oracle-style batching");
            var1.fillInStackTrace();
            throw var1;
        } else {
            this.m_batchStyle = 2;
        }
    }

    final void checkIfJdbcBatchExists() throws SQLException {
        if (this.doesJdbcBatchExist()) {
            SQLException var1 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 81, "batch must be either executed or cleared");
            var1.fillInStackTrace();
            throw var1;
        }
    }

    boolean doesJdbcBatchExist() {
        return this.currentRank > 0 && this.m_batchStyle == 2;
    }

    boolean isJdbcBatchStyle() {
        return this.m_batchStyle == 2;
    }

    boolean isBatchStyleSet() {
        return this.m_batchStyle != 0;
    }

    public void addBatch() throws SQLException {
        synchronized(this.connection) {
            this.setJdbcBatchStyle();
            this.processCompletedBindRow(this.currentRank + 2, this.currentRank > 0 && this.sqlKind.isPlsqlOrCall());
            ++this.currentRank;
        }
    }

    public void addBatch(String var1) throws SQLException {
        synchronized(this.connection){}

        try {
            SQLException var3 = DatabaseError.createUnsupportedFeatureSqlException();
            var3.fillInStackTrace();
            throw var3;
        } finally {
            ;
        }
    }

    public void clearBatch() throws SQLException {
        synchronized(this.connection) {
            for(int var2 = this.currentRank - 1; var2 >= 0; --var2) {
                for(int var3 = 0; var3 < this.numberOfBindPositions; ++var3) {
                    this.binders[var2][var3] = null;
                }
            }

            this.currentRank = 0;
            this.pushedBatches = null;
            this.pushedBatchesTail = null;
            this.firstRowInBatch = 0;
            this.currentBatchAccumulatedBindsSize = 0;
            this.releaseBuffers();
            if (this.binders != null) {
                this.currentRowBinders = this.binders[0];
            }

        }
    }

    void executeForRowsWithTimeout(boolean var1) throws SQLException {
        if (this.queryTimeout > 0) {
            try {
                this.connection.getTimeout().setTimeout((long)(this.queryTimeout * 1000), this);
                this.cancelLock.enterExecuting();
                this.executeForRows(var1);
            } finally {
                this.connection.getTimeout().cancelTimeout();
                this.cancelLock.exitExecuting();
            }
        } else {
            try {
                this.cancelLock.enterExecuting();
                this.executeForRows(var1);
            } finally {
                this.cancelLock.exitExecuting();
            }
        }

    }

    public int[] executeBatch() throws SQLException {
        synchronized(this.connection) {
            int[] var2 = new int[this.currentRank];
            this.checkSum = 0L;
            this.checkSumComputationFailure = false;
            int var3 = 0;
            this.cleanOldTempLobs();
            this.setJdbcBatchStyle();
            if (this.currentRank > 0) {
                this.ensureOpen();
                this.prepareForNewResults(true, true, true);
                if (this.sqlKind.isSELECT()) {
                    BatchUpdateException var17 = DatabaseError.createBatchUpdateException(80, 0, (int[])null);
                    var17.fillInStackTrace();
                    throw var17;
                }

                this.noMoreUpdateCounts = false;
                int var4 = 0;

                try {
                    this.connection.registerHeartbeat();
                    this.connection.needLine();
                    if (!this.isOpen) {
                        this.connection.open(this);
                        this.isOpen = true;
                    }

                    int var5 = this.currentRank;
                    if (this.pushedBatches == null) {
                        this.setupBindBuffers(0, this.currentRank);
                        this.executeForRowsWithTimeout(false);
                        var4 = this.validRows;
                        if (this.batchRowsUpdatedArray != null) {
                            assert var2.length == this.batchRowsUpdatedArray.length;

                            var2 = this.batchRowsUpdatedArray;
                        } else {
                            for(var3 = 0; var3 < var2.length; ++var3) {
                                var2[var3] = -2;
                            }
                        }
                    } else {
                        if (this.currentRank > this.firstRowInBatch) {
                            this.pushBatch(true);
                        }

                        boolean var20 = this.needToParse;

                        while(true) {
                            OraclePreparedStatement.PushedBatch var7 = this.pushedBatches;
                            this.currentBatchByteLens = var7.currentBatchByteLens;
                            this.lastBoundByteLens = var7.lastBoundByteLens;
                            this.currentBatchCharLens = var7.currentBatchCharLens;
                            this.lastBoundCharLens = var7.lastBoundCharLens;
                            this.lastBoundNeeded = var7.lastBoundNeeded;
                            this.currentBatchBindAccessors = var7.currentBatchBindAccessors;
                            this.needToParse = var7.need_to_parse;
                            this.currentBatchNeedToPrepareBinds = var7.current_batch_need_to_prepare_binds;
                            this.firstRowInBatch = var7.first_row_in_batch;
                            this.setupBindBuffers(var7.first_row_in_batch, var7.number_of_rows_to_be_bound);
                            this.currentRank = var7.number_of_rows_to_be_bound;
                            this.executeForRowsWithTimeout(false);
                            var4 += this.validRows;
                            if (this.batchRowsUpdatedArray != null) {
                                assert this.batchRowsUpdatedArray.length == this.currentRank;

                                System.arraycopy(this.batchRowsUpdatedArray, 0, var2, this.firstRowInBatch, this.currentRank);
                            } else if (this.sqlKind.isPlsqlOrCall()) {
                                var2[var3++] = this.validRows;
                            } else {
                                for(int var8 = 0; var8 < this.currentRank; ++var8) {
                                    var2[this.firstRowInBatch + var8] = -2;
                                }
                            }

                            this.pushedBatches = var7.next;
                            if (this.pushedBatches == null) {
                                this.pushedBatchesTail = null;
                                this.firstRowInBatch = 0;
                                this.needToParse = var20;
                                break;
                            }
                        }
                    }

                    this.slideDownCurrentRow(var5);
                } catch (SQLException var14) {
                    this.needToParse = true;
                    if (!this.sqlKind.isPlsqlOrCall()) {
                        if (this.batchRowsUpdatedArray != null) {
                            if (this.firstRowInBatch == 0) {
                                var2 = this.batchRowsUpdatedArray;
                            } else {
                                int[] var6 = new int[this.firstRowInBatch + this.batchRowsUpdatedArray.length];
                                System.arraycopy(var2, 0, var6, 0, this.firstRowInBatch);
                                System.arraycopy(this.batchRowsUpdatedArray, 0, var6, this.firstRowInBatch, this.batchRowsUpdatedArray.length);
                                var2 = var6;
                            }
                        } else if (this.numberOfExecutedElementsInBatch != -1 && this.numberOfExecutedElementsInBatch != this.currentRank) {
                            var2 = new int[this.numberOfExecutedElementsInBatch];

                            for(var3 = 0; var3 < this.numberOfExecutedElementsInBatch; ++var3) {
                                var2[var3] = -2;
                            }
                        } else {
                            for(var3 = 0; var3 < var2.length; ++var3) {
                                var2[var3] = -3;
                            }
                        }
                    }

                    this.clearBatch();
                    this.resetCurrentRowBinders();
                    BatchUpdateException var19 = DatabaseError.createBatchUpdateException(var14, this.sqlKind.isPlsqlOrCall() ? var3 : var2.length, var2);
                    var19.fillInStackTrace();
                    throw var19;
                } finally {
                    if (this.sqlKind.isPlsqlOrCall() || var4 > this.validRows) {
                        this.validRows = var4;
                    }

                    this.checkValidRowsStatus();
                    this.currentBatchAccumulatedBindsSize = 0;
                    this.currentRank = 0;
                }

                if (this.validRows < 0) {
                    for(var3 = 0; var3 < var2.length; ++var3) {
                        var2[var3] = -3;
                    }

                    BatchUpdateException var18 = DatabaseError.createBatchUpdateException(81, 0, var2);
                    var18.fillInStackTrace();
                    throw var18;
                }
            }

            this.connection.registerHeartbeat();
            return var2;
        }
    }

    void pushBatch(boolean var1) {
        OraclePreparedStatement.PushedBatch var2 = new OraclePreparedStatement.PushedBatch();
        var2.currentBatchByteLens = new int[this.numberOfBindPositions];
        System.arraycopy(this.currentBatchByteLens, 0, var2.currentBatchByteLens, 0, this.numberOfBindPositions);
        var2.currentBatchCharLens = new int[this.numberOfBindPositions];
        System.arraycopy(this.currentBatchCharLens, 0, var2.currentBatchCharLens, 0, this.numberOfBindPositions);
        var2.lastBoundByteLens = new int[this.numberOfBindPositions];
        System.arraycopy(this.lastBoundByteLens, 0, var2.lastBoundByteLens, 0, this.numberOfBindPositions);
        var2.lastBoundCharLens = new int[this.numberOfBindPositions];
        System.arraycopy(this.lastBoundCharLens, 0, var2.lastBoundCharLens, 0, this.numberOfBindPositions);
        if (this.currentBatchBindAccessors != null) {
            var2.currentBatchBindAccessors = new Accessor[this.numberOfBindPositions];
            System.arraycopy(this.currentBatchBindAccessors, 0, var2.currentBatchBindAccessors, 0, this.numberOfBindPositions);
        }

        var2.lastBoundNeeded = this.lastBoundNeeded;
        var2.need_to_parse = this.needToParse;
        var2.current_batch_need_to_prepare_binds = this.currentBatchNeedToPrepareBinds;
        var2.first_row_in_batch = this.firstRowInBatch;
        var2.number_of_rows_to_be_bound = this.currentRank - this.firstRowInBatch;
        if (this.pushedBatches == null) {
            this.pushedBatches = var2;
        } else {
            this.pushedBatchesTail.next = var2;
        }

        this.pushedBatchesTail = var2;
        this.currentBatchAccumulatedBindsSize = 0;
        if (!var1) {
            int[] var3 = this.currentBatchByteLens;
            this.currentBatchByteLens = this.lastBoundByteLens;
            this.lastBoundByteLens = var3;

            int var4;
            for(var4 = 0; var4 < this.numberOfBindPositions; ++var4) {
                this.currentBatchByteLens[var4] = 0;
            }

            var3 = this.currentBatchCharLens;
            this.currentBatchCharLens = this.lastBoundCharLens;
            this.lastBoundCharLens = var3;

            for(var4 = 0; var4 < this.numberOfBindPositions; ++var4) {
                this.currentBatchCharLens[var4] = 0;
            }

            this.lastBoundNeeded = false;
            this.firstRowInBatch = this.currentRank;
        }

    }

    int doScrollPstmtExecuteUpdate() throws SQLException {
        this.doScrollExecuteCommon();
        if (this.sqlKind.isSELECT()) {
            this.scrollRsetTypeSolved = true;
        }

        return this.validRows;
    }

    public int copyBinds(Statement var1, int var2) throws SQLException {
        if (this.numberOfBindPositions > 0) {
            OraclePreparedStatement var3 = (OraclePreparedStatement)var1;
            int var4 = this.bindIndicatorSubRange + 5;
            int var5 = this.bindByteSubRange;
            int var6 = this.bindCharSubRange;
            int var7 = this.indicatorsOffset;
            int var8 = this.valueLengthsOffset;

            for(int var9 = 0; var9 < this.numberOfBindPositions; ++var9) {
                short var10 = this.bindIndicators[var4 + 0];
                short var11 = this.bindIndicators[var4 + 1];
                short var12 = this.bindIndicators[var4 + 2];
                int var13 = var9 + var2;
                if (var3.parameterDatum == null) {
                    var3.parameterDatum = new byte[var3.numberOfBindRowsAllocated][var3.numberOfBindPositions][];
                }

                if (var3.parameterOtype == null) {
                    var3.parameterOtype = new OracleTypeADT[var3.numberOfBindRowsAllocated][var3.numberOfBindPositions];
                }

                if (this.bindIndicators[var7] == -1) {
                    var3.currentRowBinders[var13] = this.copiedNullBinder(var10, var11);
                    if (var12 > 0) {
                        var3.currentRowCharLens[var13] = 1;
                    }
                } else if (var10 != 109 && var10 != 111) {
                    if (var11 > 0) {
                        var3.currentRowBinders[var13] = this.copiedByteBinder(var10, this.bindBytes, var5, var11, this.bindIndicators[var8]);
                        var3.currentRowByteLens[var13] = var11;
                    } else {
                        if (var12 <= 0) {
                            SQLException var17 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 89, "copyBinds doesn't understand type " + var10);
                            var17.fillInStackTrace();
                            throw var17;
                        }

                        var3.currentRowBinders[var13] = this.copiedCharBinder(var10, this.bindChars, var6, var12, this.bindIndicators[var8], this.getInoutIndicator(var9));
                        var3.currentRowCharLens[var13] = var12;
                    }
                } else {
                    var3.currentRowBinders[var13] = var10 == 109 ? this.theNamedTypeBinder : this.theRefTypeBinder;
                    byte[] var14 = this.parameterDatum[0][var9];
                    int var15 = var14.length;
                    byte[] var16 = new byte[var15];
                    var3.parameterDatum[0][var13] = var16;
                    System.arraycopy(var14, 0, var16, 0, var15);
                    var3.parameterOtype[0][var13] = this.parameterOtype[0][var9];
                    var3.currentRowByteLens[var13] = var11;
                }

                var5 += this.bindBufferCapacity * var11;
                var6 += this.bindBufferCapacity * var12;
                var7 += this.numberOfBindRowsAllocated;
                var8 += this.numberOfBindRowsAllocated;
                var4 += 10;
            }
        }

        return this.numberOfBindPositions;
    }

    Binder copiedNullBinder(short var1, int var2) throws SQLException {
        return new CopiedNullBinder(var1, var2);
    }

    Binder copiedByteBinder(short var1, byte[] var2, int var3, int var4, short var5) throws SQLException {
        byte[] var6 = new byte[var4];
        System.arraycopy(var2, var3, var6, 0, var4);
        return new CopiedByteBinder(var1, var4, var6, var5);
    }

    Binder copiedCharBinder(short var1, char[] var2, int var3, int var4, short var5, short var6) throws SQLException {
        char[] var7 = new char[var4];
        System.arraycopy(var2, var3, var7, 0, var4);
        return new CopiedCharBinder(var1, var7, var5, var6);
    }

    protected void hardClose() throws SQLException {
        super.hardClose();
        this.releaseBuffers();
        if (!this.connection.isClosed()) {
            this.cleanAllTempLobs();
        }

        this.lastBoundBytes = null;
        this.lastBoundChars = null;
    }

    protected void alwaysOnClose() throws SQLException {
        if (this.currentRank > 0) {
            if (this.m_batchStyle == 2) {
                this.clearBatch();
            } else {
                int var1 = this.validRows;
                this.prematureBatchCount = this.sendBatch();
                this.validRows = var1;
            }
        }

        OracleStatement var2;
        if (this.sqlKind.isSELECT()) {
            for(OracleStatement var3 = this.children; var3 != null; var3 = var2) {
                var2 = var3.nextChild;
                if (var3.serverCursor) {
                    var3.cursorId = 0;
                }
            }
        }

        super.alwaysOnClose();
    }

    public void setDisableStmtCaching(boolean var1) {
        synchronized(this.connection) {
            if (var1) {
                this.cacheState = 3;
            }

        }
    }

    public void setFormOfUse(int var1, short var2) {
        synchronized(this.connection) {
            int var4 = var1 - 1;
            if (this.currentRowFormOfUse[var4] != var2) {
                this.currentRowFormOfUse[var4] = var2;
                Accessor var5;
                if (this.currentRowBindAccessors != null) {
                    var5 = this.currentRowBindAccessors[var4];
                    if (var5 != null) {
                        var5.setFormOfUse(var2);
                    }
                }

                if (this.accessors != null) {
                    var5 = this.accessors[var4];
                    if (var5 != null) {
                        var5.setFormOfUse(var2);
                    }
                }
            }

        }
    }

    public void setURL(int var1, URL var2) throws SQLException {
        this.setURLInternal(var1, var2);
    }

    void setURLInternal(int var1, URL var2) throws SQLException {
        if (var2 == null) {
            this.setNull(var1, 1);
        } else {
            this.setStringInternal(var1, var2.toString());
        }

    }

    public ParameterMetaData getParameterMetaData() throws SQLException {
        this.ensureOpen();
        return OracleParameterMetaData.getParameterMetaData(this.sqlObject, this.connection);
    }

    public oracle.jdbc.OracleParameterMetaData OracleGetParameterMetaData() throws SQLException {
        SQLException var1 = DatabaseError.createUnsupportedFeatureSqlException();
        var1.fillInStackTrace();
        throw var1;
    }

    public void registerReturnParameter(int var1, int var2) throws SQLException {
        SQLException var6;
        if (this.numberOfBindPositions <= 0) {
            var6 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 90);
            var6.fillInStackTrace();
            throw var6;
        } else {
            if (this.numReturnParams <= 0) {
                this.numReturnParams = this.sqlObject.getReturnParameterCount();
                if (this.numReturnParams <= 0) {
                    var6 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 90);
                    var6.fillInStackTrace();
                    throw var6;
                }
            }

            int var3 = var1 - 1;
            if (var3 >= this.numberOfBindPositions - this.numReturnParams && var1 <= this.numberOfBindPositions) {
                int var7 = this.getInternalTypeForDmlReturning(var2);
                short var5 = 0;
                if (this.currentRowFormOfUse != null && this.currentRowFormOfUse[var3] != 0) {
                    var5 = this.currentRowFormOfUse[var3];
                }

                this.registerReturnParameterInternal(var3, var7, var2, -1, var5, (String)null);
                this.currentRowBinders[var3] = this.theReturnParamBinder;
            } else {
                SQLException var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 3);
                var4.fillInStackTrace();
                throw var4;
            }
        }
    }

    public void registerReturnParameter(int var1, int var2, int var3) throws SQLException {
        if (this.numberOfBindPositions <= 0) {
            SQLException var7 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 90);
            var7.fillInStackTrace();
            throw var7;
        } else {
            int var4 = var1 - 1;
            SQLException var5;
            if (var4 >= 0 && var1 <= this.numberOfBindPositions) {
                if (var2 != 1 && var2 != 12 && var2 != -1 && var2 != -2 && var2 != -3 && var2 != -4 && var2 != 12) {
                    var5 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 68);
                    var5.fillInStackTrace();
                    throw var5;
                } else if (var3 <= 0) {
                    var5 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 68);
                    var5.fillInStackTrace();
                    throw var5;
                } else {
                    int var8 = this.getInternalTypeForDmlReturning(var2);
                    short var6 = 0;
                    if (this.currentRowFormOfUse != null && this.currentRowFormOfUse[var4] != 0) {
                        var6 = this.currentRowFormOfUse[var4];
                    }

                    this.registerReturnParameterInternal(var4, var8, var2, var3, var6, (String)null);
                    this.currentRowBinders[var4] = this.theReturnParamBinder;
                }
            } else {
                var5 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 3);
                var5.fillInStackTrace();
                throw var5;
            }
        }
    }

    public void registerReturnParameter(int var1, int var2, String var3) throws SQLException {
        if (this.numberOfBindPositions <= 0) {
            SQLException var7 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 90);
            var7.fillInStackTrace();
            throw var7;
        } else {
            int var4 = var1 - 1;
            if (var4 >= 0 && var1 <= this.numberOfBindPositions) {
                int var8 = this.getInternalTypeForDmlReturning(var2);
                if (var8 != 111 && var8 != 109) {
                    SQLException var6 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 68);
                    var6.fillInStackTrace();
                    throw var6;
                } else {
                    this.registerReturnParameterInternal(var4, var8, var2, -1, (short)0, var3);
                    this.currentRowBinders[var4] = this.theReturnParamBinder;
                }
            } else {
                SQLException var5 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 3);
                var5.fillInStackTrace();
                throw var5;
            }
        }
    }

    public ResultSet getReturnResultSet() throws SQLException {
        SQLException var1;
        if (this.closed) {
            var1 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
            var1.fillInStackTrace();
            throw var1;
        } else if (this.accessors != null && this.numReturnParams != 0) {
            if (this.currentResultSet == null || this.numReturnParams == 0 || !this.isOpen) {
                this.isComplete = true;
                this.computeOffsetOfFirstUserColumn();
                this.currentResultSet = OracleResultSet.createResultSet(this);
            }

            return this.currentResultSet;
        } else {
            var1 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 144);
            var1.fillInStackTrace();
            throw var1;
        }
    }

    int getInternalTypeForDmlReturning(int var1) throws SQLException {
        boolean var2 = false;
        short var4;
        switch(var1) {
            case -104:
                var4 = 183;
                break;
            case -103:
                var4 = 182;
                break;
            case -102:
                var4 = 231;
                break;
            case -101:
                var4 = 181;
                break;
            case -16:
            case -1:
                var4 = 8;
                break;
            case -15:
            case 1:
                var4 = 96;
                break;
            case -13:
                var4 = 114;
                break;
            case -9:
            case 12:
                var4 = 1;
                break;
            case -8:
                var4 = 104;
                break;
            case -7:
            case -6:
            case -5:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
                var4 = 6;
                break;
            case -4:
                var4 = 24;
                break;
            case -3:
            case -2:
                var4 = 23;
                break;
            case 70:
                var4 = 1;
                break;
            case 91:
            case 92:
                var4 = 12;
                break;
            case 93:
                var4 = 180;
                break;
            case 100:
                var4 = 100;
                break;
            case 101:
                var4 = 101;
                break;
            case 2002:
            case 2003:
            case 2007:
            case 2008:
            case 2009:
                var4 = 109;
                break;
            case 2004:
                var4 = 113;
                break;
            case 2005:
            case 2011:
                var4 = 112;
                break;
            case 2006:
                var4 = 111;
                break;
            default:
                SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 4);
                var3.fillInStackTrace();
                throw var3;
        }

        return var4;
    }

    void registerReturnParamsForAutoKey() throws SQLException {
        int[] var1 = this.autoKeyInfo.returnTypes;
        short[] var2 = this.autoKeyInfo.tableFormOfUses;
        int[] var3 = this.autoKeyInfo.columnIndexes;
        int var4 = var1.length;
        int var5 = this.numberOfBindPositions - var4;
        this.offsetOfFirstUserColumn = var5 - 1;

        for(int var6 = 0; var6 < var4; ++var6) {
            int var7 = var5 + var6;
            this.currentRowBinders[var7] = this.theReturnParamBinder;
            int var8 = this.connection.defaultnchar ? 2 : 1;
            if (var2 != null && var3 != null && var2[var3[var6] - 1] == 2) {
                var8 = 2;
                this.setFormOfUse(var7 + 1, (short)var8);
            }

            this.checkTypeForAutoKey(var1[var6]);
            String var9 = null;
            if (var1[var6] == 111) {
                var9 = this.autoKeyInfo.tableTypeNames[var3[var6] - 1];
            }

            this.registerReturnParameterInternal(var7, var1[var6], var1[var6], -1, (short)var8, var9);
        }

    }

    void cleanOldTempLobs() {
        if (this.m_batchStyle != 1 || this.currentRank == this.batch - 1) {
            super.cleanOldTempLobs();
        }

    }

    void resetOnExceptionDuringExecute() {
        super.resetOnExceptionDuringExecute();
        this.currentRank = 0;
        this.currentBatchNeedToPrepareBinds = true;
    }

    void resetCurrentRowBinders() {
        Binder[] var1 = this.currentRowBinders;
        if (this.binders != null && this.currentRowBinders != null && var1 != this.binders[0]) {
            this.currentRowBinders = this.binders[0];
            this.binders[this.numberOfBoundRows] = var1;
        }

    }

    public void setAsciiStream(int var1, InputStream var2) throws SQLException {
        this.setAsciiStreamInternal(var1, var2);
    }

    public void setAsciiStream(int var1, InputStream var2, long var3) throws SQLException {
        this.setAsciiStreamInternal(var1, var2, var3);
    }

    public void setBinaryStream(int var1, InputStream var2) throws SQLException {
        this.setBinaryStreamInternal(var1, var2);
    }

    public void setBinaryStream(int var1, InputStream var2, long var3) throws SQLException {
        this.setBinaryStreamInternal(var1, var2, var3);
    }

    public void setBlob(int var1, InputStream var2) throws SQLException {
        this.setBlobInternal(var1, var2);
    }

    public void setBlob(int var1, InputStream var2, long var3) throws SQLException {
        if (var3 < 0L) {
            SQLException var5 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 68, "length for setBlob() cannot be negative");
            var5.fillInStackTrace();
            throw var5;
        } else {
            this.setBlobInternal(var1, var2, var3);
        }
    }

    public void setCharacterStream(int var1, Reader var2) throws SQLException {
        this.setCharacterStreamInternal(var1, var2);
    }

    public void setCharacterStream(int var1, Reader var2, long var3) throws SQLException {
        this.setCharacterStreamInternal(var1, var2, var3);
    }

    public void setClob(int var1, Reader var2, long var3) throws SQLException {
        if (var3 < 0L) {
            SQLException var5 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 68, "length for setClob() cannot be negative");
            var5.fillInStackTrace();
            throw var5;
        } else {
            this.setClobInternal(var1, var2, var3);
        }
    }

    public void setClob(int var1, Reader var2) throws SQLException {
        this.setClobInternal(var1, var2);
    }

    public void setRowId(int var1, RowId var2) throws SQLException {
        this.setRowIdInternal(var1, var2);
    }

    public void setNCharacterStream(int var1, Reader var2) throws SQLException {
        this.setNCharacterStreamInternal(var1, var2);
    }

    public void setNCharacterStream(int var1, Reader var2, long var3) throws SQLException {
        this.setNCharacterStreamInternal(var1, var2, var3);
    }

    public void setNClob(int var1, NClob var2) throws SQLException {
        this.setNClobInternal(var1, var2);
    }

    public void setNClob(int var1, Reader var2, long var3) throws SQLException {
        this.setNClobInternal(var1, var2, var3);
    }

    public void setNClob(int var1, Reader var2) throws SQLException {
        this.setNClobInternal(var1, var2);
    }

    public void setSQLXML(int var1, SQLXML var2) throws SQLException {
        this.setSQLXMLInternal(var1, var2);
    }

    public void setNString(int var1, String var2) throws SQLException {
        this.setNStringInternal(var1, var2);
    }

    void setAsciiStreamInternal(int var1, InputStream var2) throws SQLException {
        this.setAsciiStreamInternal(var1, var2, 0L, false);
    }

    void setAsciiStreamInternal(int var1, InputStream var2, long var3) throws SQLException {
        this.setAsciiStreamInternal(var1, var2, var3, true);
    }

    void setBinaryStreamInternal(int var1, InputStream var2) throws SQLException {
        this.setBinaryStreamInternal(var1, var2, 0L, false);
    }

    void setBinaryStreamInternal(int var1, InputStream var2, long var3) throws SQLException {
        this.setBinaryStreamInternal(var1, var2, var3, true);
    }

    void setBlobInternal(int var1, InputStream var2, long var3) throws SQLException {
        int var5 = var1 - 1;
        if (var5 >= 0 && var1 <= this.numberOfBindPositions) {
            if (var2 == null) {
                this.setNullInternal(var1, 2004);
            } else {
                this.setBinaryStreamContentsForBlobCritical(var1, var2, var3, var3 != -1L);
            }

        } else {
            SQLException var6 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 3);
            var6.fillInStackTrace();
            throw var6;
        }
    }

    void setBlobInternal(int var1, InputStream var2) throws SQLException {
        this.setBlobInternal(var1, var2, -1L);
    }

    void setCharacterStreamInternal(int var1, Reader var2) throws SQLException {
        this.setCharacterStreamInternal(var1, var2, 0L, false);
    }

    void setCharacterStreamInternal(int var1, Reader var2, long var3) throws SQLException {
        this.setCharacterStreamInternal(var1, var2, var3, true);
    }

    void setClobInternal(int var1, Reader var2) throws SQLException {
        this.setClobInternal(var1, var2, -1L);
    }

    void setClobInternal(int var1, Reader var2, long var3) throws SQLException {
        int var5 = var1 - 1;
        if (var5 >= 0 && var1 <= this.numberOfBindPositions) {
            if (var2 == null) {
                this.setNullInternal(var1, 2005);
            } else {
                this.setReaderContentsForClobCritical(var1, var2, var3, var3 != -1L);
            }

        } else {
            SQLException var6 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 3);
            var6.fillInStackTrace();
            throw var6;
        }
    }

    void setNCharacterStreamInternal(int var1, Reader var2) throws SQLException {
        this.setFormOfUse(var1, (short)2);
        this.setCharacterStreamInternal(var1, var2, 0L, false);
    }

    void setNCharacterStreamInternal(int var1, Reader var2, long var3) throws SQLException {
        this.setFormOfUse(var1, (short)2);
        this.setCharacterStreamInternal(var1, var2, var3);
    }

    void setNClobInternal(int var1, NClob var2) throws SQLException {
        this.setFormOfUse(var1, (short)2);
        this.setClobInternal(var1, (Clob)var2);
    }

    void setNClobInternal(int var1, Reader var2) throws SQLException {
        this.setFormOfUse(var1, (short)2);
        this.setClobInternal(var1, var2);
    }

    void setNClobInternal(int var1, Reader var2, long var3) throws SQLException {
        this.setFormOfUse(var1, (short)2);
        this.setClobInternal(var1, var2, var3);
    }

    void setNStringInternal(int var1, String var2) throws SQLException {
        this.setFormOfUse(var1, (short)2);
        this.setStringInternal(var1, var2);
    }

    void setRowIdInternal(int var1, RowId var2) throws SQLException {
        this.setROWIDInternal(var1, (ROWID)var2);
    }

    public void setArrayAtName(String var1, Array var2) throws SQLException {
        if (var1 == null) {
            SQLException var8 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 68);
            var8.fillInStackTrace();
            throw var8;
        } else {
            String var3 = var1.intern();
            String[] var4 = this.sqlObject.getParameterList();
            boolean var5 = false;
            int var6 = Math.min(this.sqlObject.getParameterCount(), var4.length);

            for(int var7 = 0; var7 < var6; ++var7) {
                if (var4[var7] == var3) {
                    this.setArray(var7 + 1, var2);
                    var5 = true;
                }
            }

            if (!var5) {
                SQLException var9 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 147, var1);
                var9.fillInStackTrace();
                throw var9;
            }
        }
    }

    public void setBigDecimalAtName(String var1, BigDecimal var2) throws SQLException {
        if (var1 == null) {
            SQLException var8 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 68);
            var8.fillInStackTrace();
            throw var8;
        } else {
            String var3 = var1.intern();
            String[] var4 = this.sqlObject.getParameterList();
            boolean var5 = false;
            int var6 = Math.min(this.sqlObject.getParameterCount(), var4.length);

            for(int var7 = 0; var7 < var6; ++var7) {
                if (var4[var7] == var3) {
                    this.setBigDecimal(var7 + 1, var2);
                    var5 = true;
                }
            }

            if (!var5) {
                SQLException var9 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 147, var1);
                var9.fillInStackTrace();
                throw var9;
            }
        }
    }

    public void setBlobAtName(String var1, Blob var2) throws SQLException {
        if (var1 == null) {
            SQLException var8 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 68);
            var8.fillInStackTrace();
            throw var8;
        } else {
            String var3 = var1.intern();
            String[] var4 = this.sqlObject.getParameterList();
            boolean var5 = false;
            int var6 = Math.min(this.sqlObject.getParameterCount(), var4.length);

            for(int var7 = 0; var7 < var6; ++var7) {
                if (var4[var7] == var3) {
                    this.setBlob(var7 + 1, var2);
                    var5 = true;
                }
            }

            if (!var5) {
                SQLException var9 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 147, var1);
                var9.fillInStackTrace();
                throw var9;
            }
        }
    }

    public void setBooleanAtName(String var1, boolean var2) throws SQLException {
        if (var1 == null) {
            SQLException var8 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 68);
            var8.fillInStackTrace();
            throw var8;
        } else {
            String var3 = var1.intern();
            String[] var4 = this.sqlObject.getParameterList();
            boolean var5 = false;
            int var6 = Math.min(this.sqlObject.getParameterCount(), var4.length);

            for(int var7 = 0; var7 < var6; ++var7) {
                if (var4[var7] == var3) {
                    this.setBoolean(var7 + 1, var2);
                    var5 = true;
                }
            }

            if (!var5) {
                SQLException var9 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 147, var1);
                var9.fillInStackTrace();
                throw var9;
            }
        }
    }

    public void setByteAtName(String var1, byte var2) throws SQLException {
        if (var1 == null) {
            SQLException var8 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 68);
            var8.fillInStackTrace();
            throw var8;
        } else {
            String var3 = var1.intern();
            String[] var4 = this.sqlObject.getParameterList();
            boolean var5 = false;
            int var6 = Math.min(this.sqlObject.getParameterCount(), var4.length);

            for(int var7 = 0; var7 < var6; ++var7) {
                if (var4[var7] == var3) {
                    this.setByte(var7 + 1, var2);
                    var5 = true;
                }
            }

            if (!var5) {
                SQLException var9 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 147, var1);
                var9.fillInStackTrace();
                throw var9;
            }
        }
    }

    public void setBytesAtName(String var1, byte[] var2) throws SQLException {
        if (var1 == null) {
            SQLException var8 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 68);
            var8.fillInStackTrace();
            throw var8;
        } else {
            String var3 = var1.intern();
            String[] var4 = this.sqlObject.getParameterList();
            boolean var5 = false;
            int var6 = Math.min(this.sqlObject.getParameterCount(), var4.length);

            for(int var7 = 0; var7 < var6; ++var7) {
                if (var4[var7] == var3) {
                    this.setBytes(var7 + 1, var2);
                    var5 = true;
                }
            }

            if (!var5) {
                SQLException var9 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 147, var1);
                var9.fillInStackTrace();
                throw var9;
            }
        }
    }

    public void setClobAtName(String var1, Clob var2) throws SQLException {
        if (var1 == null) {
            SQLException var8 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 68);
            var8.fillInStackTrace();
            throw var8;
        } else {
            String var3 = var1.intern();
            String[] var4 = this.sqlObject.getParameterList();
            boolean var5 = false;
            int var6 = Math.min(this.sqlObject.getParameterCount(), var4.length);

            for(int var7 = 0; var7 < var6; ++var7) {
                if (var4[var7] == var3) {
                    this.setClob(var7 + 1, var2);
                    var5 = true;
                }
            }

            if (!var5) {
                SQLException var9 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 147, var1);
                var9.fillInStackTrace();
                throw var9;
            }
        }
    }

    public void setDateAtName(String var1, Date var2) throws SQLException {
        if (var1 == null) {
            SQLException var8 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 68);
            var8.fillInStackTrace();
            throw var8;
        } else {
            String var3 = var1.intern();
            String[] var4 = this.sqlObject.getParameterList();
            boolean var5 = false;
            int var6 = Math.min(this.sqlObject.getParameterCount(), var4.length);

            for(int var7 = 0; var7 < var6; ++var7) {
                if (var4[var7] == var3) {
                    this.setDate(var7 + 1, var2);
                    var5 = true;
                }
            }

            if (!var5) {
                SQLException var9 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 147, var1);
                var9.fillInStackTrace();
                throw var9;
            }
        }
    }

    public void setDateAtName(String var1, Date var2, Calendar var3) throws SQLException {
        if (var1 == null) {
            SQLException var9 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 68);
            var9.fillInStackTrace();
            throw var9;
        } else {
            String var4 = var1.intern();
            String[] var5 = this.sqlObject.getParameterList();
            boolean var6 = false;
            int var7 = Math.min(this.sqlObject.getParameterCount(), var5.length);

            for(int var8 = 0; var8 < var7; ++var8) {
                if (var5[var8] == var4) {
                    this.setDate(var8 + 1, var2, var3);
                    var6 = true;
                }
            }

            if (!var6) {
                SQLException var10 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 147, var1);
                var10.fillInStackTrace();
                throw var10;
            }
        }
    }

    public void setDoubleAtName(String var1, double var2) throws SQLException {
        if (var1 == null) {
            SQLException var9 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 68);
            var9.fillInStackTrace();
            throw var9;
        } else {
            String var4 = var1.intern();
            String[] var5 = this.sqlObject.getParameterList();
            boolean var6 = false;
            int var7 = Math.min(this.sqlObject.getParameterCount(), var5.length);

            for(int var8 = 0; var8 < var7; ++var8) {
                if (var5[var8] == var4) {
                    this.setDouble(var8 + 1, var2);
                    var6 = true;
                }
            }

            if (!var6) {
                SQLException var10 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 147, var1);
                var10.fillInStackTrace();
                throw var10;
            }
        }
    }

    public void setFloatAtName(String var1, float var2) throws SQLException {
        if (var1 == null) {
            SQLException var8 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 68);
            var8.fillInStackTrace();
            throw var8;
        } else {
            String var3 = var1.intern();
            String[] var4 = this.sqlObject.getParameterList();
            boolean var5 = false;
            int var6 = Math.min(this.sqlObject.getParameterCount(), var4.length);

            for(int var7 = 0; var7 < var6; ++var7) {
                if (var4[var7] == var3) {
                    this.setFloat(var7 + 1, var2);
                    var5 = true;
                }
            }

            if (!var5) {
                SQLException var9 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 147, var1);
                var9.fillInStackTrace();
                throw var9;
            }
        }
    }

    public void setIntAtName(String var1, int var2) throws SQLException {
        if (var1 == null) {
            SQLException var8 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 68);
            var8.fillInStackTrace();
            throw var8;
        } else {
            String var3 = var1.intern();
            String[] var4 = this.sqlObject.getParameterList();
            boolean var5 = false;
            int var6 = Math.min(this.sqlObject.getParameterCount(), var4.length);

            for(int var7 = 0; var7 < var6; ++var7) {
                if (var4[var7] == var3) {
                    this.setInt(var7 + 1, var2);
                    var5 = true;
                }
            }

            if (!var5) {
                SQLException var9 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 147, var1);
                var9.fillInStackTrace();
                throw var9;
            }
        }
    }

    public void setLongAtName(String var1, long var2) throws SQLException {
        if (var1 == null) {
            SQLException var9 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 68);
            var9.fillInStackTrace();
            throw var9;
        } else {
            String var4 = var1.intern();
            String[] var5 = this.sqlObject.getParameterList();
            boolean var6 = false;
            int var7 = Math.min(this.sqlObject.getParameterCount(), var5.length);

            for(int var8 = 0; var8 < var7; ++var8) {
                if (var5[var8] == var4) {
                    this.setLong(var8 + 1, var2);
                    var6 = true;
                }
            }

            if (!var6) {
                SQLException var10 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 147, var1);
                var10.fillInStackTrace();
                throw var10;
            }
        }
    }

    public void setNClobAtName(String var1, NClob var2) throws SQLException {
        if (var1 == null) {
            SQLException var8 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 68);
            var8.fillInStackTrace();
            throw var8;
        } else {
            String var3 = var1.intern();
            String[] var4 = this.sqlObject.getParameterList();
            boolean var5 = false;
            int var6 = Math.min(this.sqlObject.getParameterCount(), var4.length);

            for(int var7 = 0; var7 < var6; ++var7) {
                if (var4[var7] == var3) {
                    this.setNClob(var7 + 1, var2);
                    var5 = true;
                }
            }

            if (!var5) {
                SQLException var9 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 147, var1);
                var9.fillInStackTrace();
                throw var9;
            }
        }
    }

    public void setNStringAtName(String var1, String var2) throws SQLException {
        if (var1 == null) {
            SQLException var8 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 68);
            var8.fillInStackTrace();
            throw var8;
        } else {
            String var3 = var1.intern();
            String[] var4 = this.sqlObject.getParameterList();
            boolean var5 = false;
            int var6 = Math.min(this.sqlObject.getParameterCount(), var4.length);

            for(int var7 = 0; var7 < var6; ++var7) {
                if (var4[var7] == var3) {
                    this.setNString(var7 + 1, var2);
                    var5 = true;
                }
            }

            if (!var5) {
                SQLException var9 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 147, var1);
                var9.fillInStackTrace();
                throw var9;
            }
        }
    }

    public void setObjectAtName(String var1, Object var2) throws SQLException {
        if (var1 == null) {
            SQLException var8 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 68);
            var8.fillInStackTrace();
            throw var8;
        } else {
            String var3 = var1.intern();
            String[] var4 = this.sqlObject.getParameterList();
            boolean var5 = false;
            int var6 = Math.min(this.sqlObject.getParameterCount(), var4.length);

            for(int var7 = 0; var7 < var6; ++var7) {
                if (var4[var7] == var3) {
                    this.setObject(var7 + 1, var2);
                    var5 = true;
                }
            }

            if (!var5) {
                SQLException var9 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 147, var1);
                var9.fillInStackTrace();
                throw var9;
            }
        }
    }

    public void setObjectAtName(String var1, Object var2, int var3) throws SQLException {
        if (var1 == null) {
            SQLException var9 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 68);
            var9.fillInStackTrace();
            throw var9;
        } else {
            String var4 = var1.intern();
            String[] var5 = this.sqlObject.getParameterList();
            boolean var6 = false;
            int var7 = Math.min(this.sqlObject.getParameterCount(), var5.length);

            for(int var8 = 0; var8 < var7; ++var8) {
                if (var5[var8] == var4) {
                    this.setObject(var8 + 1, var2, var3);
                    var6 = true;
                }
            }

            if (!var6) {
                SQLException var10 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 147, var1);
                var10.fillInStackTrace();
                throw var10;
            }
        }
    }

    public void setRefAtName(String var1, Ref var2) throws SQLException {
        if (var1 == null) {
            SQLException var8 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 68);
            var8.fillInStackTrace();
            throw var8;
        } else {
            String var3 = var1.intern();
            String[] var4 = this.sqlObject.getParameterList();
            boolean var5 = false;
            int var6 = Math.min(this.sqlObject.getParameterCount(), var4.length);

            for(int var7 = 0; var7 < var6; ++var7) {
                if (var4[var7] == var3) {
                    this.setRef(var7 + 1, var2);
                    var5 = true;
                }
            }

            if (!var5) {
                SQLException var9 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 147, var1);
                var9.fillInStackTrace();
                throw var9;
            }
        }
    }

    public void setRowIdAtName(String var1, RowId var2) throws SQLException {
        if (var1 == null) {
            SQLException var8 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 68);
            var8.fillInStackTrace();
            throw var8;
        } else {
            String var3 = var1.intern();
            String[] var4 = this.sqlObject.getParameterList();
            boolean var5 = false;
            int var6 = Math.min(this.sqlObject.getParameterCount(), var4.length);

            for(int var7 = 0; var7 < var6; ++var7) {
                if (var4[var7] == var3) {
                    this.setRowId(var7 + 1, var2);
                    var5 = true;
                }
            }

            if (!var5) {
                SQLException var9 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 147, var1);
                var9.fillInStackTrace();
                throw var9;
            }
        }
    }

    public void setShortAtName(String var1, short var2) throws SQLException {
        if (var1 == null) {
            SQLException var8 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 68);
            var8.fillInStackTrace();
            throw var8;
        } else {
            String var3 = var1.intern();
            String[] var4 = this.sqlObject.getParameterList();
            boolean var5 = false;
            int var6 = Math.min(this.sqlObject.getParameterCount(), var4.length);

            for(int var7 = 0; var7 < var6; ++var7) {
                if (var4[var7] == var3) {
                    this.setShort(var7 + 1, var2);
                    var5 = true;
                }
            }

            if (!var5) {
                SQLException var9 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 147, var1);
                var9.fillInStackTrace();
                throw var9;
            }
        }
    }

    public void setSQLXMLAtName(String var1, SQLXML var2) throws SQLException {
        if (var1 == null) {
            SQLException var8 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 68);
            var8.fillInStackTrace();
            throw var8;
        } else {
            String var3 = var1.intern();
            String[] var4 = this.sqlObject.getParameterList();
            boolean var5 = false;
            int var6 = Math.min(this.sqlObject.getParameterCount(), var4.length);

            for(int var7 = 0; var7 < var6; ++var7) {
                if (var4[var7] == var3) {
                    this.setSQLXML(var7 + 1, var2);
                    var5 = true;
                }
            }

            if (!var5) {
                SQLException var9 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 147, var1);
                var9.fillInStackTrace();
                throw var9;
            }
        }
    }

    public void setStringAtName(String var1, String var2) throws SQLException {
        if (var1 == null) {
            SQLException var8 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 68);
            var8.fillInStackTrace();
            throw var8;
        } else {
            String var3 = var1.intern();
            String[] var4 = this.sqlObject.getParameterList();
            boolean var5 = false;
            int var6 = Math.min(this.sqlObject.getParameterCount(), var4.length);

            for(int var7 = 0; var7 < var6; ++var7) {
                if (var4[var7] == var3) {
                    this.setString(var7 + 1, var2);
                    var5 = true;
                }
            }

            if (!var5) {
                SQLException var9 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 147, var1);
                var9.fillInStackTrace();
                throw var9;
            }
        }
    }

    public void setTimeAtName(String var1, Time var2) throws SQLException {
        if (var1 == null) {
            SQLException var8 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 68);
            var8.fillInStackTrace();
            throw var8;
        } else {
            String var3 = var1.intern();
            String[] var4 = this.sqlObject.getParameterList();
            boolean var5 = false;
            int var6 = Math.min(this.sqlObject.getParameterCount(), var4.length);

            for(int var7 = 0; var7 < var6; ++var7) {
                if (var4[var7] == var3) {
                    this.setTime(var7 + 1, var2);
                    var5 = true;
                }
            }

            if (!var5) {
                SQLException var9 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 147, var1);
                var9.fillInStackTrace();
                throw var9;
            }
        }
    }

    public void setTimeAtName(String var1, Time var2, Calendar var3) throws SQLException {
        if (var1 == null) {
            SQLException var9 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 68);
            var9.fillInStackTrace();
            throw var9;
        } else {
            String var4 = var1.intern();
            String[] var5 = this.sqlObject.getParameterList();
            boolean var6 = false;
            int var7 = Math.min(this.sqlObject.getParameterCount(), var5.length);

            for(int var8 = 0; var8 < var7; ++var8) {
                if (var5[var8] == var4) {
                    this.setTime(var8 + 1, var2, var3);
                    var6 = true;
                }
            }

            if (!var6) {
                SQLException var10 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 147, var1);
                var10.fillInStackTrace();
                throw var10;
            }
        }
    }

    public void setTimestampAtName(String var1, Timestamp var2) throws SQLException {
        if (var1 == null) {
            SQLException var8 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 68);
            var8.fillInStackTrace();
            throw var8;
        } else {
            String var3 = var1.intern();
            String[] var4 = this.sqlObject.getParameterList();
            boolean var5 = false;
            int var6 = Math.min(this.sqlObject.getParameterCount(), var4.length);

            for(int var7 = 0; var7 < var6; ++var7) {
                if (var4[var7] == var3) {
                    this.setTimestamp(var7 + 1, var2);
                    var5 = true;
                }
            }

            if (!var5) {
                SQLException var9 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 147, var1);
                var9.fillInStackTrace();
                throw var9;
            }
        }
    }

    public void setTimestampAtName(String var1, Timestamp var2, Calendar var3) throws SQLException {
        if (var1 == null) {
            SQLException var9 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 68);
            var9.fillInStackTrace();
            throw var9;
        } else {
            String var4 = var1.intern();
            String[] var5 = this.sqlObject.getParameterList();
            boolean var6 = false;
            int var7 = Math.min(this.sqlObject.getParameterCount(), var5.length);

            for(int var8 = 0; var8 < var7; ++var8) {
                if (var5[var8] == var4) {
                    this.setTimestamp(var8 + 1, var2, var3);
                    var6 = true;
                }
            }

            if (!var6) {
                SQLException var10 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 147, var1);
                var10.fillInStackTrace();
                throw var10;
            }
        }
    }

    public void setURLAtName(String var1, URL var2) throws SQLException {
        if (var1 == null) {
            SQLException var8 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 68);
            var8.fillInStackTrace();
            throw var8;
        } else {
            String var3 = var1.intern();
            String[] var4 = this.sqlObject.getParameterList();
            boolean var5 = false;
            int var6 = Math.min(this.sqlObject.getParameterCount(), var4.length);

            for(int var7 = 0; var7 < var6; ++var7) {
                if (var4[var7] == var3) {
                    this.setURL(var7 + 1, var2);
                    var5 = true;
                }
            }

            if (!var5) {
                SQLException var9 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 147, var1);
                var9.fillInStackTrace();
                throw var9;
            }
        }
    }

    public void setARRAYAtName(String var1, ARRAY var2) throws SQLException {
        if (var1 == null) {
            SQLException var8 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 68);
            var8.fillInStackTrace();
            throw var8;
        } else {
            String var3 = var1.intern();
            String[] var4 = this.sqlObject.getParameterList();
            boolean var5 = false;
            int var6 = Math.min(this.sqlObject.getParameterCount(), var4.length);

            for(int var7 = 0; var7 < var6; ++var7) {
                if (var4[var7] == var3) {
                    this.setARRAY(var7 + 1, var2);
                    var5 = true;
                }
            }

            if (!var5) {
                SQLException var9 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 147, var1);
                var9.fillInStackTrace();
                throw var9;
            }
        }
    }

    public void setBFILEAtName(String var1, BFILE var2) throws SQLException {
        if (var1 == null) {
            SQLException var8 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 68);
            var8.fillInStackTrace();
            throw var8;
        } else {
            String var3 = var1.intern();
            String[] var4 = this.sqlObject.getParameterList();
            boolean var5 = false;
            int var6 = Math.min(this.sqlObject.getParameterCount(), var4.length);

            for(int var7 = 0; var7 < var6; ++var7) {
                if (var4[var7] == var3) {
                    this.setBFILE(var7 + 1, var2);
                    var5 = true;
                }
            }

            if (!var5) {
                SQLException var9 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 147, var1);
                var9.fillInStackTrace();
                throw var9;
            }
        }
    }

    public void setBfileAtName(String var1, BFILE var2) throws SQLException {
        if (var1 == null) {
            SQLException var8 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 68);
            var8.fillInStackTrace();
            throw var8;
        } else {
            String var3 = var1.intern();
            String[] var4 = this.sqlObject.getParameterList();
            boolean var5 = false;
            int var6 = Math.min(this.sqlObject.getParameterCount(), var4.length);

            for(int var7 = 0; var7 < var6; ++var7) {
                if (var4[var7] == var3) {
                    this.setBfile(var7 + 1, var2);
                    var5 = true;
                }
            }

            if (!var5) {
                SQLException var9 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 147, var1);
                var9.fillInStackTrace();
                throw var9;
            }
        }
    }

    public void setBinaryFloatAtName(String var1, float var2) throws SQLException {
        if (var1 == null) {
            SQLException var8 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 68);
            var8.fillInStackTrace();
            throw var8;
        } else {
            String var3 = var1.intern();
            String[] var4 = this.sqlObject.getParameterList();
            boolean var5 = false;
            int var6 = Math.min(this.sqlObject.getParameterCount(), var4.length);

            for(int var7 = 0; var7 < var6; ++var7) {
                if (var4[var7] == var3) {
                    this.setBinaryFloat(var7 + 1, var2);
                    var5 = true;
                }
            }

            if (!var5) {
                SQLException var9 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 147, var1);
                var9.fillInStackTrace();
                throw var9;
            }
        }
    }

    public void setBinaryFloatAtName(String var1, BINARY_FLOAT var2) throws SQLException {
        if (var1 == null) {
            SQLException var8 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 68);
            var8.fillInStackTrace();
            throw var8;
        } else {
            String var3 = var1.intern();
            String[] var4 = this.sqlObject.getParameterList();
            boolean var5 = false;
            int var6 = Math.min(this.sqlObject.getParameterCount(), var4.length);

            for(int var7 = 0; var7 < var6; ++var7) {
                if (var4[var7] == var3) {
                    this.setBinaryFloat(var7 + 1, var2);
                    var5 = true;
                }
            }

            if (!var5) {
                SQLException var9 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 147, var1);
                var9.fillInStackTrace();
                throw var9;
            }
        }
    }

    public void setBinaryDoubleAtName(String var1, double var2) throws SQLException {
        if (var1 == null) {
            SQLException var9 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 68);
            var9.fillInStackTrace();
            throw var9;
        } else {
            String var4 = var1.intern();
            String[] var5 = this.sqlObject.getParameterList();
            boolean var6 = false;
            int var7 = Math.min(this.sqlObject.getParameterCount(), var5.length);

            for(int var8 = 0; var8 < var7; ++var8) {
                if (var5[var8] == var4) {
                    this.setBinaryDouble(var8 + 1, var2);
                    var6 = true;
                }
            }

            if (!var6) {
                SQLException var10 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 147, var1);
                var10.fillInStackTrace();
                throw var10;
            }
        }
    }

    public void setBinaryDoubleAtName(String var1, BINARY_DOUBLE var2) throws SQLException {
        if (var1 == null) {
            SQLException var8 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 68);
            var8.fillInStackTrace();
            throw var8;
        } else {
            String var3 = var1.intern();
            String[] var4 = this.sqlObject.getParameterList();
            boolean var5 = false;
            int var6 = Math.min(this.sqlObject.getParameterCount(), var4.length);

            for(int var7 = 0; var7 < var6; ++var7) {
                if (var4[var7] == var3) {
                    this.setBinaryDouble(var7 + 1, var2);
                    var5 = true;
                }
            }

            if (!var5) {
                SQLException var9 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 147, var1);
                var9.fillInStackTrace();
                throw var9;
            }
        }
    }

    public void setBLOBAtName(String var1, BLOB var2) throws SQLException {
        if (var1 == null) {
            SQLException var8 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 68);
            var8.fillInStackTrace();
            throw var8;
        } else {
            String var3 = var1.intern();
            String[] var4 = this.sqlObject.getParameterList();
            boolean var5 = false;
            int var6 = Math.min(this.sqlObject.getParameterCount(), var4.length);

            for(int var7 = 0; var7 < var6; ++var7) {
                if (var4[var7] == var3) {
                    this.setBLOB(var7 + 1, var2);
                    var5 = true;
                }
            }

            if (!var5) {
                SQLException var9 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 147, var1);
                var9.fillInStackTrace();
                throw var9;
            }
        }
    }

    public void setCHARAtName(String var1, CHAR var2) throws SQLException {
        if (var1 == null) {
            SQLException var8 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 68);
            var8.fillInStackTrace();
            throw var8;
        } else {
            String var3 = var1.intern();
            String[] var4 = this.sqlObject.getParameterList();
            boolean var5 = false;
            int var6 = Math.min(this.sqlObject.getParameterCount(), var4.length);

            for(int var7 = 0; var7 < var6; ++var7) {
                if (var4[var7] == var3) {
                    this.setCHAR(var7 + 1, var2);
                    var5 = true;
                }
            }

            if (!var5) {
                SQLException var9 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 147, var1);
                var9.fillInStackTrace();
                throw var9;
            }
        }
    }

    public void setCLOBAtName(String var1, CLOB var2) throws SQLException {
        if (var1 == null) {
            SQLException var8 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 68);
            var8.fillInStackTrace();
            throw var8;
        } else {
            String var3 = var1.intern();
            String[] var4 = this.sqlObject.getParameterList();
            boolean var5 = false;
            int var6 = Math.min(this.sqlObject.getParameterCount(), var4.length);

            for(int var7 = 0; var7 < var6; ++var7) {
                if (var4[var7] == var3) {
                    this.setCLOB(var7 + 1, var2);
                    var5 = true;
                }
            }

            if (!var5) {
                SQLException var9 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 147, var1);
                var9.fillInStackTrace();
                throw var9;
            }
        }
    }

    public void setCursorAtName(String var1, ResultSet var2) throws SQLException {
        if (var1 == null) {
            SQLException var8 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 68);
            var8.fillInStackTrace();
            throw var8;
        } else {
            String var3 = var1.intern();
            String[] var4 = this.sqlObject.getParameterList();
            boolean var5 = false;
            int var6 = Math.min(this.sqlObject.getParameterCount(), var4.length);

            for(int var7 = 0; var7 < var6; ++var7) {
                if (var4[var7] == var3) {
                    this.setCursor(var7 + 1, var2);
                    var5 = true;
                }
            }

            if (!var5) {
                SQLException var9 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 147, var1);
                var9.fillInStackTrace();
                throw var9;
            }
        }
    }

    public void setDATEAtName(String var1, DATE var2) throws SQLException {
        if (var1 == null) {
            SQLException var8 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 68);
            var8.fillInStackTrace();
            throw var8;
        } else {
            String var3 = var1.intern();
            String[] var4 = this.sqlObject.getParameterList();
            boolean var5 = false;
            int var6 = Math.min(this.sqlObject.getParameterCount(), var4.length);

            for(int var7 = 0; var7 < var6; ++var7) {
                if (var4[var7] == var3) {
                    this.setDATE(var7 + 1, var2);
                    var5 = true;
                }
            }

            if (!var5) {
                SQLException var9 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 147, var1);
                var9.fillInStackTrace();
                throw var9;
            }
        }
    }

    public void setFixedCHARAtName(String var1, String var2) throws SQLException {
        if (var1 == null) {
            SQLException var8 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 68);
            var8.fillInStackTrace();
            throw var8;
        } else {
            String var3 = var1.intern();
            String[] var4 = this.sqlObject.getParameterList();
            boolean var5 = false;
            int var6 = Math.min(this.sqlObject.getParameterCount(), var4.length);

            for(int var7 = 0; var7 < var6; ++var7) {
                if (var4[var7] == var3) {
                    this.setFixedCHAR(var7 + 1, var2);
                    var5 = true;
                }
            }

            if (!var5) {
                SQLException var9 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 147, var1);
                var9.fillInStackTrace();
                throw var9;
            }
        }
    }

    public void setINTERVALDSAtName(String var1, INTERVALDS var2) throws SQLException {
        if (var1 == null) {
            SQLException var8 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 68);
            var8.fillInStackTrace();
            throw var8;
        } else {
            String var3 = var1.intern();
            String[] var4 = this.sqlObject.getParameterList();
            boolean var5 = false;
            int var6 = Math.min(this.sqlObject.getParameterCount(), var4.length);

            for(int var7 = 0; var7 < var6; ++var7) {
                if (var4[var7] == var3) {
                    this.setINTERVALDS(var7 + 1, var2);
                    var5 = true;
                }
            }

            if (!var5) {
                SQLException var9 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 147, var1);
                var9.fillInStackTrace();
                throw var9;
            }
        }
    }

    public void setINTERVALYMAtName(String var1, INTERVALYM var2) throws SQLException {
        if (var1 == null) {
            SQLException var8 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 68);
            var8.fillInStackTrace();
            throw var8;
        } else {
            String var3 = var1.intern();
            String[] var4 = this.sqlObject.getParameterList();
            boolean var5 = false;
            int var6 = Math.min(this.sqlObject.getParameterCount(), var4.length);

            for(int var7 = 0; var7 < var6; ++var7) {
                if (var4[var7] == var3) {
                    this.setINTERVALYM(var7 + 1, var2);
                    var5 = true;
                }
            }

            if (!var5) {
                SQLException var9 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 147, var1);
                var9.fillInStackTrace();
                throw var9;
            }
        }
    }

    public void setNUMBERAtName(String var1, NUMBER var2) throws SQLException {
        if (var1 == null) {
            SQLException var8 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 68);
            var8.fillInStackTrace();
            throw var8;
        } else {
            String var3 = var1.intern();
            String[] var4 = this.sqlObject.getParameterList();
            boolean var5 = false;
            int var6 = Math.min(this.sqlObject.getParameterCount(), var4.length);

            for(int var7 = 0; var7 < var6; ++var7) {
                if (var4[var7] == var3) {
                    this.setNUMBER(var7 + 1, var2);
                    var5 = true;
                }
            }

            if (!var5) {
                SQLException var9 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 147, var1);
                var9.fillInStackTrace();
                throw var9;
            }
        }
    }

    public void setOPAQUEAtName(String var1, OPAQUE var2) throws SQLException {
        if (var1 == null) {
            SQLException var8 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 68);
            var8.fillInStackTrace();
            throw var8;
        } else {
            String var3 = var1.intern();
            String[] var4 = this.sqlObject.getParameterList();
            boolean var5 = false;
            int var6 = Math.min(this.sqlObject.getParameterCount(), var4.length);

            for(int var7 = 0; var7 < var6; ++var7) {
                if (var4[var7] == var3) {
                    this.setOPAQUE(var7 + 1, var2);
                    var5 = true;
                }
            }

            if (!var5) {
                SQLException var9 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 147, var1);
                var9.fillInStackTrace();
                throw var9;
            }
        }
    }

    public void setOracleObjectAtName(String var1, Datum var2) throws SQLException {
        if (var1 == null) {
            SQLException var8 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 68);
            var8.fillInStackTrace();
            throw var8;
        } else {
            String var3 = var1.intern();
            String[] var4 = this.sqlObject.getParameterList();
            boolean var5 = false;
            int var6 = Math.min(this.sqlObject.getParameterCount(), var4.length);

            for(int var7 = 0; var7 < var6; ++var7) {
                if (var4[var7] == var3) {
                    this.setOracleObject(var7 + 1, var2);
                    var5 = true;
                }
            }

            if (!var5) {
                SQLException var9 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 147, var1);
                var9.fillInStackTrace();
                throw var9;
            }
        }
    }

    public void setORADataAtName(String var1, ORAData var2) throws SQLException {
        if (var1 == null) {
            SQLException var8 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 68);
            var8.fillInStackTrace();
            throw var8;
        } else {
            String var3 = var1.intern();
            String[] var4 = this.sqlObject.getParameterList();
            boolean var5 = false;
            int var6 = Math.min(this.sqlObject.getParameterCount(), var4.length);

            for(int var7 = 0; var7 < var6; ++var7) {
                if (var4[var7] == var3) {
                    this.setORAData(var7 + 1, var2);
                    var5 = true;
                }
            }

            if (!var5) {
                SQLException var9 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 147, var1);
                var9.fillInStackTrace();
                throw var9;
            }
        }
    }

    public void setRAWAtName(String var1, RAW var2) throws SQLException {
        if (var1 == null) {
            SQLException var8 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 68);
            var8.fillInStackTrace();
            throw var8;
        } else {
            String var3 = var1.intern();
            String[] var4 = this.sqlObject.getParameterList();
            boolean var5 = false;
            int var6 = Math.min(this.sqlObject.getParameterCount(), var4.length);

            for(int var7 = 0; var7 < var6; ++var7) {
                if (var4[var7] == var3) {
                    this.setRAW(var7 + 1, var2);
                    var5 = true;
                }
            }

            if (!var5) {
                SQLException var9 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 147, var1);
                var9.fillInStackTrace();
                throw var9;
            }
        }
    }

    public void setREFAtName(String var1, REF var2) throws SQLException {
        if (var1 == null) {
            SQLException var8 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 68);
            var8.fillInStackTrace();
            throw var8;
        } else {
            String var3 = var1.intern();
            String[] var4 = this.sqlObject.getParameterList();
            boolean var5 = false;
            int var6 = Math.min(this.sqlObject.getParameterCount(), var4.length);

            for(int var7 = 0; var7 < var6; ++var7) {
                if (var4[var7] == var3) {
                    this.setREF(var7 + 1, var2);
                    var5 = true;
                }
            }

            if (!var5) {
                SQLException var9 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 147, var1);
                var9.fillInStackTrace();
                throw var9;
            }
        }
    }

    public void setRefTypeAtName(String var1, REF var2) throws SQLException {
        if (var1 == null) {
            SQLException var8 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 68);
            var8.fillInStackTrace();
            throw var8;
        } else {
            String var3 = var1.intern();
            String[] var4 = this.sqlObject.getParameterList();
            boolean var5 = false;
            int var6 = Math.min(this.sqlObject.getParameterCount(), var4.length);

            for(int var7 = 0; var7 < var6; ++var7) {
                if (var4[var7] == var3) {
                    this.setRefType(var7 + 1, var2);
                    var5 = true;
                }
            }

            if (!var5) {
                SQLException var9 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 147, var1);
                var9.fillInStackTrace();
                throw var9;
            }
        }
    }

    public void setROWIDAtName(String var1, ROWID var2) throws SQLException {
        if (var1 == null) {
            SQLException var8 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 68);
            var8.fillInStackTrace();
            throw var8;
        } else {
            String var3 = var1.intern();
            String[] var4 = this.sqlObject.getParameterList();
            boolean var5 = false;
            int var6 = Math.min(this.sqlObject.getParameterCount(), var4.length);

            for(int var7 = 0; var7 < var6; ++var7) {
                if (var4[var7] == var3) {
                    this.setROWID(var7 + 1, var2);
                    var5 = true;
                }
            }

            if (!var5) {
                SQLException var9 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 147, var1);
                var9.fillInStackTrace();
                throw var9;
            }
        }
    }

    public void setSTRUCTAtName(String var1, STRUCT var2) throws SQLException {
        if (var1 == null) {
            SQLException var8 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 68);
            var8.fillInStackTrace();
            throw var8;
        } else {
            String var3 = var1.intern();
            String[] var4 = this.sqlObject.getParameterList();
            boolean var5 = false;
            int var6 = Math.min(this.sqlObject.getParameterCount(), var4.length);

            for(int var7 = 0; var7 < var6; ++var7) {
                if (var4[var7] == var3) {
                    this.setSTRUCT(var7 + 1, var2);
                    var5 = true;
                }
            }

            if (!var5) {
                SQLException var9 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 147, var1);
                var9.fillInStackTrace();
                throw var9;
            }
        }
    }

    public void setTIMESTAMPLTZAtName(String var1, TIMESTAMPLTZ var2) throws SQLException {
        if (var1 == null) {
            SQLException var8 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 68);
            var8.fillInStackTrace();
            throw var8;
        } else {
            String var3 = var1.intern();
            String[] var4 = this.sqlObject.getParameterList();
            boolean var5 = false;
            int var6 = Math.min(this.sqlObject.getParameterCount(), var4.length);

            for(int var7 = 0; var7 < var6; ++var7) {
                if (var4[var7] == var3) {
                    this.setTIMESTAMPLTZ(var7 + 1, var2);
                    var5 = true;
                }
            }

            if (!var5) {
                SQLException var9 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 147, var1);
                var9.fillInStackTrace();
                throw var9;
            }
        }
    }

    public void setTIMESTAMPTZAtName(String var1, TIMESTAMPTZ var2) throws SQLException {
        if (var1 == null) {
            SQLException var8 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 68);
            var8.fillInStackTrace();
            throw var8;
        } else {
            String var3 = var1.intern();
            String[] var4 = this.sqlObject.getParameterList();
            boolean var5 = false;
            int var6 = Math.min(this.sqlObject.getParameterCount(), var4.length);

            for(int var7 = 0; var7 < var6; ++var7) {
                if (var4[var7] == var3) {
                    this.setTIMESTAMPTZ(var7 + 1, var2);
                    var5 = true;
                }
            }

            if (!var5) {
                SQLException var9 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 147, var1);
                var9.fillInStackTrace();
                throw var9;
            }
        }
    }

    public void setTIMESTAMPAtName(String var1, TIMESTAMP var2) throws SQLException {
        if (var1 == null) {
            SQLException var8 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 68);
            var8.fillInStackTrace();
            throw var8;
        } else {
            String var3 = var1.intern();
            String[] var4 = this.sqlObject.getParameterList();
            boolean var5 = false;
            int var6 = Math.min(this.sqlObject.getParameterCount(), var4.length);

            for(int var7 = 0; var7 < var6; ++var7) {
                if (var4[var7] == var3) {
                    this.setTIMESTAMP(var7 + 1, var2);
                    var5 = true;
                }
            }

            if (!var5) {
                SQLException var9 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 147, var1);
                var9.fillInStackTrace();
                throw var9;
            }
        }
    }

    public void setCustomDatumAtName(String var1, CustomDatum var2) throws SQLException {
        if (var1 == null) {
            SQLException var8 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 68);
            var8.fillInStackTrace();
            throw var8;
        } else {
            String var3 = var1.intern();
            String[] var4 = this.sqlObject.getParameterList();
            boolean var5 = false;
            int var6 = Math.min(this.sqlObject.getParameterCount(), var4.length);

            for(int var7 = 0; var7 < var6; ++var7) {
                if (var4[var7] == var3) {
                    this.setCustomDatum(var7 + 1, var2);
                    var5 = true;
                }
            }

            if (!var5) {
                SQLException var9 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 147, var1);
                var9.fillInStackTrace();
                throw var9;
            }
        }
    }

    public void setBlobAtName(String var1, InputStream var2) throws SQLException {
        if (var1 == null) {
            SQLException var9 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 68);
            var9.fillInStackTrace();
            throw var9;
        } else {
            String var3 = var1.intern();
            String[] var4 = this.sqlObject.getParameterList();
            int var5 = Math.min(this.sqlObject.getParameterCount(), var4.length);
            boolean var6 = true;

            for(int var7 = 0; var7 < var5; ++var7) {
                if (var4[var7] == var3) {
                    if (!var6) {
                        SQLException var8 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 135);
                        var8.fillInStackTrace();
                        throw var8;
                    }

                    this.setBlob(var7 + 1, var2);
                    var6 = false;
                }
            }

            if (var6) {
                SQLException var10 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 147, var1);
                var10.fillInStackTrace();
                throw var10;
            }
        }
    }

    public void setBlobAtName(String var1, InputStream var2, long var3) throws SQLException {
        if (var1 == null) {
            SQLException var11 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 68);
            var11.fillInStackTrace();
            throw var11;
        } else {
            String var5 = var1.intern();
            String[] var6 = this.sqlObject.getParameterList();
            int var7 = Math.min(this.sqlObject.getParameterCount(), var6.length);
            boolean var8 = true;

            for(int var9 = 0; var9 < var7; ++var9) {
                if (var6[var9] == var5) {
                    if (!var8) {
                        SQLException var10 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 135);
                        var10.fillInStackTrace();
                        throw var10;
                    }

                    this.setBlob(var9 + 1, var2, var3);
                    var8 = false;
                }
            }

            if (var8) {
                SQLException var12 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 147, var1);
                var12.fillInStackTrace();
                throw var12;
            }
        }
    }

    public void setClobAtName(String var1, Reader var2) throws SQLException {
        if (var1 == null) {
            SQLException var9 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 68);
            var9.fillInStackTrace();
            throw var9;
        } else {
            String var3 = var1.intern();
            String[] var4 = this.sqlObject.getParameterList();
            int var5 = Math.min(this.sqlObject.getParameterCount(), var4.length);
            boolean var6 = true;

            for(int var7 = 0; var7 < var5; ++var7) {
                if (var4[var7] == var3) {
                    if (!var6) {
                        SQLException var8 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 135);
                        var8.fillInStackTrace();
                        throw var8;
                    }

                    this.setClob(var7 + 1, var2);
                    var6 = false;
                }
            }

            if (var6) {
                SQLException var10 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 147, var1);
                var10.fillInStackTrace();
                throw var10;
            }
        }
    }

    public void setClobAtName(String var1, Reader var2, long var3) throws SQLException {
        if (var1 == null) {
            SQLException var11 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 68);
            var11.fillInStackTrace();
            throw var11;
        } else {
            String var5 = var1.intern();
            String[] var6 = this.sqlObject.getParameterList();
            int var7 = Math.min(this.sqlObject.getParameterCount(), var6.length);
            boolean var8 = true;

            for(int var9 = 0; var9 < var7; ++var9) {
                if (var6[var9] == var5) {
                    if (!var8) {
                        SQLException var10 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 135);
                        var10.fillInStackTrace();
                        throw var10;
                    }

                    this.setClob(var9 + 1, var2, var3);
                    var8 = false;
                }
            }

            if (var8) {
                SQLException var12 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 147, var1);
                var12.fillInStackTrace();
                throw var12;
            }
        }
    }

    public void setNClobAtName(String var1, Reader var2) throws SQLException {
        if (var1 == null) {
            SQLException var9 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 68);
            var9.fillInStackTrace();
            throw var9;
        } else {
            String var3 = var1.intern();
            String[] var4 = this.sqlObject.getParameterList();
            int var5 = Math.min(this.sqlObject.getParameterCount(), var4.length);
            boolean var6 = true;

            for(int var7 = 0; var7 < var5; ++var7) {
                if (var4[var7] == var3) {
                    if (!var6) {
                        SQLException var8 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 135);
                        var8.fillInStackTrace();
                        throw var8;
                    }

                    this.setNClob(var7 + 1, var2);
                    var6 = false;
                }
            }

            if (var6) {
                SQLException var10 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 147, var1);
                var10.fillInStackTrace();
                throw var10;
            }
        }
    }

    public void setNClobAtName(String var1, Reader var2, long var3) throws SQLException {
        if (var1 == null) {
            SQLException var11 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 68);
            var11.fillInStackTrace();
            throw var11;
        } else {
            String var5 = var1.intern();
            String[] var6 = this.sqlObject.getParameterList();
            int var7 = Math.min(this.sqlObject.getParameterCount(), var6.length);
            boolean var8 = true;

            for(int var9 = 0; var9 < var7; ++var9) {
                if (var6[var9] == var5) {
                    if (!var8) {
                        SQLException var10 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 135);
                        var10.fillInStackTrace();
                        throw var10;
                    }

                    this.setNClob(var9 + 1, var2, var3);
                    var8 = false;
                }
            }

            if (var8) {
                SQLException var12 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 147, var1);
                var12.fillInStackTrace();
                throw var12;
            }
        }
    }

    public void setAsciiStreamAtName(String var1, InputStream var2) throws SQLException {
        if (var1 == null) {
            SQLException var9 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 68);
            var9.fillInStackTrace();
            throw var9;
        } else {
            String var3 = var1.intern();
            String[] var4 = this.sqlObject.getParameterList();
            int var5 = Math.min(this.sqlObject.getParameterCount(), var4.length);
            boolean var6 = true;

            for(int var7 = 0; var7 < var5; ++var7) {
                if (var4[var7] == var3) {
                    if (!var6) {
                        SQLException var8 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 135);
                        var8.fillInStackTrace();
                        throw var8;
                    }

                    this.setAsciiStream(var7 + 1, var2);
                    var6 = false;
                }
            }

            if (var6) {
                SQLException var10 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 147, var1);
                var10.fillInStackTrace();
                throw var10;
            }
        }
    }

    public void setAsciiStreamAtName(String var1, InputStream var2, int var3) throws SQLException {
        if (var1 == null) {
            SQLException var10 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 68);
            var10.fillInStackTrace();
            throw var10;
        } else {
            String var4 = var1.intern();
            String[] var5 = this.sqlObject.getParameterList();
            int var6 = Math.min(this.sqlObject.getParameterCount(), var5.length);
            boolean var7 = true;

            for(int var8 = 0; var8 < var6; ++var8) {
                if (var5[var8] == var4) {
                    if (!var7) {
                        SQLException var9 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 135);
                        var9.fillInStackTrace();
                        throw var9;
                    }

                    this.setAsciiStream(var8 + 1, var2, var3);
                    var7 = false;
                }
            }

            if (var7) {
                SQLException var11 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 147, var1);
                var11.fillInStackTrace();
                throw var11;
            }
        }
    }

    public void setAsciiStreamAtName(String var1, InputStream var2, long var3) throws SQLException {
        if (var1 == null) {
            SQLException var11 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 68);
            var11.fillInStackTrace();
            throw var11;
        } else {
            String var5 = var1.intern();
            String[] var6 = this.sqlObject.getParameterList();
            int var7 = Math.min(this.sqlObject.getParameterCount(), var6.length);
            boolean var8 = true;

            for(int var9 = 0; var9 < var7; ++var9) {
                if (var6[var9] == var5) {
                    if (!var8) {
                        SQLException var10 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 135);
                        var10.fillInStackTrace();
                        throw var10;
                    }

                    this.setAsciiStream(var9 + 1, var2, var3);
                    var8 = false;
                }
            }

            if (var8) {
                SQLException var12 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 147, var1);
                var12.fillInStackTrace();
                throw var12;
            }
        }
    }

    public void setBinaryStreamAtName(String var1, InputStream var2) throws SQLException {
        if (var1 == null) {
            SQLException var9 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 68);
            var9.fillInStackTrace();
            throw var9;
        } else {
            String var3 = var1.intern();
            String[] var4 = this.sqlObject.getParameterList();
            int var5 = Math.min(this.sqlObject.getParameterCount(), var4.length);
            boolean var6 = true;

            for(int var7 = 0; var7 < var5; ++var7) {
                if (var4[var7] == var3) {
                    if (!var6) {
                        SQLException var8 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 135);
                        var8.fillInStackTrace();
                        throw var8;
                    }

                    this.setBinaryStream(var7 + 1, var2);
                    var6 = false;
                }
            }

            if (var6) {
                SQLException var10 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 147, var1);
                var10.fillInStackTrace();
                throw var10;
            }
        }
    }

    public void setBinaryStreamAtName(String var1, InputStream var2, int var3) throws SQLException {
        if (var1 == null) {
            SQLException var10 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 68);
            var10.fillInStackTrace();
            throw var10;
        } else {
            String var4 = var1.intern();
            String[] var5 = this.sqlObject.getParameterList();
            int var6 = Math.min(this.sqlObject.getParameterCount(), var5.length);
            boolean var7 = true;

            for(int var8 = 0; var8 < var6; ++var8) {
                if (var5[var8] == var4) {
                    if (!var7) {
                        SQLException var9 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 135);
                        var9.fillInStackTrace();
                        throw var9;
                    }

                    this.setBinaryStream(var8 + 1, var2, var3);
                    var7 = false;
                }
            }

            if (var7) {
                SQLException var11 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 147, var1);
                var11.fillInStackTrace();
                throw var11;
            }
        }
    }

    public void setBinaryStreamAtName(String var1, InputStream var2, long var3) throws SQLException {
        if (var1 == null) {
            SQLException var11 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 68);
            var11.fillInStackTrace();
            throw var11;
        } else {
            String var5 = var1.intern();
            String[] var6 = this.sqlObject.getParameterList();
            int var7 = Math.min(this.sqlObject.getParameterCount(), var6.length);
            boolean var8 = true;

            for(int var9 = 0; var9 < var7; ++var9) {
                if (var6[var9] == var5) {
                    if (!var8) {
                        SQLException var10 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 135);
                        var10.fillInStackTrace();
                        throw var10;
                    }

                    this.setBinaryStream(var9 + 1, var2, var3);
                    var8 = false;
                }
            }

            if (var8) {
                SQLException var12 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 147, var1);
                var12.fillInStackTrace();
                throw var12;
            }
        }
    }

    public void setCharacterStreamAtName(String var1, Reader var2) throws SQLException {
        if (var1 == null) {
            SQLException var9 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 68);
            var9.fillInStackTrace();
            throw var9;
        } else {
            String var3 = var1.intern();
            String[] var4 = this.sqlObject.getParameterList();
            int var5 = Math.min(this.sqlObject.getParameterCount(), var4.length);
            boolean var6 = true;

            for(int var7 = 0; var7 < var5; ++var7) {
                if (var4[var7] == var3) {
                    if (!var6) {
                        SQLException var8 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 135);
                        var8.fillInStackTrace();
                        throw var8;
                    }

                    this.setCharacterStream(var7 + 1, var2);
                    var6 = false;
                }
            }

            if (var6) {
                SQLException var10 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 147, var1);
                var10.fillInStackTrace();
                throw var10;
            }
        }
    }

    public void setCharacterStreamAtName(String var1, Reader var2, int var3) throws SQLException {
        if (var1 == null) {
            SQLException var10 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 68);
            var10.fillInStackTrace();
            throw var10;
        } else {
            String var4 = var1.intern();
            String[] var5 = this.sqlObject.getParameterList();
            int var6 = Math.min(this.sqlObject.getParameterCount(), var5.length);
            boolean var7 = true;

            for(int var8 = 0; var8 < var6; ++var8) {
                if (var5[var8] == var4) {
                    if (!var7) {
                        SQLException var9 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 135);
                        var9.fillInStackTrace();
                        throw var9;
                    }

                    this.setCharacterStream(var8 + 1, var2, var3);
                    var7 = false;
                }
            }

            if (var7) {
                SQLException var11 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 147, var1);
                var11.fillInStackTrace();
                throw var11;
            }
        }
    }

    public void setCharacterStreamAtName(String var1, Reader var2, long var3) throws SQLException {
        if (var1 == null) {
            SQLException var11 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 68);
            var11.fillInStackTrace();
            throw var11;
        } else {
            String var5 = var1.intern();
            String[] var6 = this.sqlObject.getParameterList();
            int var7 = Math.min(this.sqlObject.getParameterCount(), var6.length);
            boolean var8 = true;

            for(int var9 = 0; var9 < var7; ++var9) {
                if (var6[var9] == var5) {
                    if (!var8) {
                        SQLException var10 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 135);
                        var10.fillInStackTrace();
                        throw var10;
                    }

                    this.setCharacterStream(var9 + 1, var2, var3);
                    var8 = false;
                }
            }

            if (var8) {
                SQLException var12 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 147, var1);
                var12.fillInStackTrace();
                throw var12;
            }
        }
    }

    public void setNCharacterStreamAtName(String var1, Reader var2) throws SQLException {
        if (var1 == null) {
            SQLException var9 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 68);
            var9.fillInStackTrace();
            throw var9;
        } else {
            String var3 = var1.intern();
            String[] var4 = this.sqlObject.getParameterList();
            int var5 = Math.min(this.sqlObject.getParameterCount(), var4.length);
            boolean var6 = true;

            for(int var7 = 0; var7 < var5; ++var7) {
                if (var4[var7] == var3) {
                    if (!var6) {
                        SQLException var8 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 135);
                        var8.fillInStackTrace();
                        throw var8;
                    }

                    this.setNCharacterStream(var7 + 1, var2);
                    var6 = false;
                }
            }

            if (var6) {
                SQLException var10 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 147, var1);
                var10.fillInStackTrace();
                throw var10;
            }
        }
    }

    public void setNCharacterStreamAtName(String var1, Reader var2, long var3) throws SQLException {
        if (var1 == null) {
            SQLException var11 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 68);
            var11.fillInStackTrace();
            throw var11;
        } else {
            String var5 = var1.intern();
            String[] var6 = this.sqlObject.getParameterList();
            int var7 = Math.min(this.sqlObject.getParameterCount(), var6.length);
            boolean var8 = true;

            for(int var9 = 0; var9 < var7; ++var9) {
                if (var6[var9] == var5) {
                    if (!var8) {
                        SQLException var10 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 135);
                        var10.fillInStackTrace();
                        throw var10;
                    }

                    this.setNCharacterStream(var9 + 1, var2, var3);
                    var8 = false;
                }
            }

            if (var8) {
                SQLException var12 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 147, var1);
                var12.fillInStackTrace();
                throw var12;
            }
        }
    }

    public void setUnicodeStreamAtName(String var1, InputStream var2, int var3) throws SQLException {
        if (var1 == null) {
            SQLException var10 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 68);
            var10.fillInStackTrace();
            throw var10;
        } else {
            String var4 = var1.intern();
            String[] var5 = this.sqlObject.getParameterList();
            int var6 = Math.min(this.sqlObject.getParameterCount(), var5.length);
            boolean var7 = true;

            for(int var8 = 0; var8 < var6; ++var8) {
                if (var5[var8] == var4) {
                    if (!var7) {
                        SQLException var9 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 135);
                        var9.fillInStackTrace();
                        throw var9;
                    }

                    this.setUnicodeStream(var8 + 1, var2, var3);
                    var7 = false;
                }
            }

            if (var7) {
                SQLException var11 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 147, var1);
                var11.fillInStackTrace();
                throw var11;
            }
        }
    }

    static {
        theStaticVarnumCopyingBinder = OraclePreparedStatementReadOnly.theStaticVarnumCopyingBinder;
        theStaticVarnumNullBinder = OraclePreparedStatementReadOnly.theStaticVarnumNullBinder;
        theStaticBooleanBinder = OraclePreparedStatementReadOnly.theStaticBooleanBinder;
        theStaticByteBinder = OraclePreparedStatementReadOnly.theStaticByteBinder;
        theStaticShortBinder = OraclePreparedStatementReadOnly.theStaticShortBinder;
        theStaticIntBinder = OraclePreparedStatementReadOnly.theStaticIntBinder;
        theStaticLongBinder = OraclePreparedStatementReadOnly.theStaticLongBinder;
        theStaticFloatBinder = OraclePreparedStatementReadOnly.theStaticFloatBinder;
        theStaticDoubleBinder = OraclePreparedStatementReadOnly.theStaticDoubleBinder;
        theStaticBigDecimalBinder = OraclePreparedStatementReadOnly.theStaticBigDecimalBinder;
        theStaticVarcharCopyingBinder = OraclePreparedStatementReadOnly.theStaticVarcharCopyingBinder;
        theStaticVarcharNullBinder = OraclePreparedStatementReadOnly.theStaticVarcharNullBinder;
        theStaticStringBinder = OraclePreparedStatementReadOnly.theStaticStringBinder;
        theStaticSetCHARCopyingBinder = OraclePreparedStatementReadOnly.theStaticSetCHARCopyingBinder;
        theStaticSetCHARBinder = OraclePreparedStatementReadOnly.theStaticSetCHARBinder;
        theStaticLittleEndianSetCHARBinder = OraclePreparedStatementReadOnly.theStaticLittleEndianSetCHARBinder;
        theStaticSetCHARNullBinder = OraclePreparedStatementReadOnly.theStaticSetCHARNullBinder;
        theStaticFixedCHARCopyingBinder = OraclePreparedStatementReadOnly.theStaticFixedCHARCopyingBinder;
        theStaticFixedCHARBinder = OraclePreparedStatementReadOnly.theStaticFixedCHARBinder;
        theStaticFixedCHARNullBinder = OraclePreparedStatementReadOnly.theStaticFixedCHARNullBinder;
        theStaticDateCopyingBinder = OraclePreparedStatementReadOnly.theStaticDateCopyingBinder;
        theStaticDateBinder = OraclePreparedStatementReadOnly.theStaticDateBinder;
        theStaticDateNullBinder = OraclePreparedStatementReadOnly.theStaticDateNullBinder;
        theStaticTimeCopyingBinder = OraclePreparedStatementReadOnly.theStaticTimeCopyingBinder;
        theStaticTimeBinder = OraclePreparedStatementReadOnly.theStaticTimeBinder;
        theStaticTimestampCopyingBinder = OraclePreparedStatementReadOnly.theStaticTimestampCopyingBinder;
        theStaticTimestampBinder = OraclePreparedStatementReadOnly.theStaticTimestampBinder;
        theStaticTimestampNullBinder = OraclePreparedStatementReadOnly.theStaticTimestampNullBinder;
        theStaticOracleNumberBinder = OraclePreparedStatementReadOnly.theStaticOracleNumberBinder;
        theStaticOracleDateBinder = OraclePreparedStatementReadOnly.theStaticOracleDateBinder;
        theStaticOracleTimestampBinder = OraclePreparedStatementReadOnly.theStaticOracleTimestampBinder;
        theStaticTSTZCopyingBinder = OraclePreparedStatementReadOnly.theStaticTSTZCopyingBinder;
        theStaticTSTZBinder = OraclePreparedStatementReadOnly.theStaticTSTZBinder;
        theStaticTSTZNullBinder = OraclePreparedStatementReadOnly.theStaticTSTZNullBinder;
        theStaticTSLTZCopyingBinder = OraclePreparedStatementReadOnly.theStaticTSLTZCopyingBinder;
        theStaticTSLTZBinder = OraclePreparedStatementReadOnly.theStaticTSLTZBinder;
        theStaticTSLTZNullBinder = OraclePreparedStatementReadOnly.theStaticTSLTZNullBinder;
        theStaticRowidCopyingBinder = OraclePreparedStatementReadOnly.theStaticRowidCopyingBinder;
        theStaticRowidBinder = OraclePreparedStatementReadOnly.theStaticRowidBinder;
        theStaticLittleEndianRowidBinder = OraclePreparedStatementReadOnly.theStaticLittleEndianRowidBinder;
        theStaticRowidNullBinder = OraclePreparedStatementReadOnly.theStaticRowidNullBinder;
        theStaticURowidNullBinder = OraclePreparedStatementReadOnly.theStaticURowidNullBinder;
        theStaticIntervalDSCopyingBinder = OraclePreparedStatementReadOnly.theStaticIntervalDSCopyingBinder;
        theStaticIntervalDSBinder = OraclePreparedStatementReadOnly.theStaticIntervalDSBinder;
        theStaticIntervalDSNullBinder = OraclePreparedStatementReadOnly.theStaticIntervalDSNullBinder;
        theStaticIntervalYMCopyingBinder = OraclePreparedStatementReadOnly.theStaticIntervalYMCopyingBinder;
        theStaticIntervalYMBinder = OraclePreparedStatementReadOnly.theStaticIntervalYMBinder;
        theStaticIntervalYMNullBinder = OraclePreparedStatementReadOnly.theStaticIntervalYMNullBinder;
        theStaticBfileCopyingBinder = OraclePreparedStatementReadOnly.theStaticBfileCopyingBinder;
        theStaticBfileBinder = OraclePreparedStatementReadOnly.theStaticBfileBinder;
        theStaticBfileNullBinder = OraclePreparedStatementReadOnly.theStaticBfileNullBinder;
        theStaticBlobCopyingBinder = OraclePreparedStatementReadOnly.theStaticBlobCopyingBinder;
        theStaticBlobBinder = OraclePreparedStatementReadOnly.theStaticBlobBinder;
        theStaticBlobNullBinder = OraclePreparedStatementReadOnly.theStaticBlobNullBinder;
        theStaticClobCopyingBinder = OraclePreparedStatementReadOnly.theStaticClobCopyingBinder;
        theStaticClobBinder = OraclePreparedStatementReadOnly.theStaticClobBinder;
        theStaticClobNullBinder = OraclePreparedStatementReadOnly.theStaticClobNullBinder;
        theStaticRawCopyingBinder = OraclePreparedStatementReadOnly.theStaticRawCopyingBinder;
        theStaticRawBinder = OraclePreparedStatementReadOnly.theStaticRawBinder;
        theStaticRawNullBinder = OraclePreparedStatementReadOnly.theStaticRawNullBinder;
        theStaticPlsqlRawCopyingBinder = OraclePreparedStatementReadOnly.theStaticPlsqlRawCopyingBinder;
        theStaticPlsqlRawBinder = OraclePreparedStatementReadOnly.theStaticPlsqlRawBinder;
        theStaticBinaryFloatCopyingBinder = OraclePreparedStatementReadOnly.theStaticBinaryFloatCopyingBinder;
        theStaticBinaryFloatBinder = OraclePreparedStatementReadOnly.theStaticBinaryFloatBinder;
        theStaticBinaryFloatNullBinder = OraclePreparedStatementReadOnly.theStaticBinaryFloatNullBinder;
        theStaticBINARY_FLOATCopyingBinder = OraclePreparedStatementReadOnly.theStaticBINARY_FLOATCopyingBinder;
        theStaticBINARY_FLOATBinder = OraclePreparedStatementReadOnly.theStaticBINARY_FLOATBinder;
        theStaticBINARY_FLOATNullBinder = OraclePreparedStatementReadOnly.theStaticBINARY_FLOATNullBinder;
        theStaticBinaryDoubleCopyingBinder = OraclePreparedStatementReadOnly.theStaticBinaryDoubleCopyingBinder;
        theStaticBinaryDoubleBinder = OraclePreparedStatementReadOnly.theStaticBinaryDoubleBinder;
        theStaticBinaryDoubleNullBinder = OraclePreparedStatementReadOnly.theStaticBinaryDoubleNullBinder;
        theStaticBINARY_DOUBLECopyingBinder = OraclePreparedStatementReadOnly.theStaticBINARY_DOUBLECopyingBinder;
        theStaticBINARY_DOUBLEBinder = OraclePreparedStatementReadOnly.theStaticBINARY_DOUBLEBinder;
        theStaticBINARY_DOUBLENullBinder = OraclePreparedStatementReadOnly.theStaticBINARY_DOUBLENullBinder;
        theStaticLongStreamBinder = OraclePreparedStatementReadOnly.theStaticLongStreamBinder;
        theStaticLongStreamForStringBinder = OraclePreparedStatementReadOnly.theStaticLongStreamForStringBinder;
        theStaticLongStreamForStringCopyingBinder = OraclePreparedStatementReadOnly.theStaticLongStreamForStringCopyingBinder;
        theStaticLongRawStreamBinder = OraclePreparedStatementReadOnly.theStaticLongRawStreamBinder;
        theStaticLongRawStreamForBytesBinder = OraclePreparedStatementReadOnly.theStaticLongRawStreamForBytesBinder;
        theStaticLongRawStreamForBytesCopyingBinder = OraclePreparedStatementReadOnly.theStaticLongRawStreamForBytesCopyingBinder;
        theStaticNamedTypeCopyingBinder = OraclePreparedStatementReadOnly.theStaticNamedTypeCopyingBinder;
        theStaticNamedTypeBinder = OraclePreparedStatementReadOnly.theStaticNamedTypeBinder;
        theStaticNamedTypeNullBinder = OraclePreparedStatementReadOnly.theStaticNamedTypeNullBinder;
        theStaticRefTypeCopyingBinder = OraclePreparedStatementReadOnly.theStaticRefTypeCopyingBinder;
        theStaticRefTypeBinder = OraclePreparedStatementReadOnly.theStaticRefTypeBinder;
        theStaticRefTypeNullBinder = OraclePreparedStatementReadOnly.theStaticRefTypeNullBinder;
        theStaticPlsqlIbtCopyingBinder = OraclePreparedStatementReadOnly.theStaticPlsqlIbtCopyingBinder;
        theStaticPlsqlIbtBinder = OraclePreparedStatementReadOnly.theStaticPlsqlIbtBinder;
        theStaticPlsqlIbtNullBinder = OraclePreparedStatementReadOnly.theStaticPlsqlIbtNullBinder;
        theStaticOutBinder = OraclePreparedStatementReadOnly.theStaticOutBinder;
        theStaticReturnParamBinder = OraclePreparedStatementReadOnly.theStaticReturnParamBinder;
        theStaticT4CRowidBinder = OraclePreparedStatementReadOnly.theStaticT4CRowidBinder;
        theStaticT4CURowidBinder = OraclePreparedStatementReadOnly.theStaticT4CURowidBinder;
        theStaticT4CRowidNullBinder = OraclePreparedStatementReadOnly.theStaticT4CRowidNullBinder;
        theStaticT4CURowidNullBinder = OraclePreparedStatementReadOnly.theStaticT4CURowidNullBinder;
        UTC_TIME_ZONE = TimeZone.getTimeZone("UTC");
        UTC_US_CALENDAR = Calendar.getInstance(UTC_TIME_ZONE, Locale.US);
        _Copyright_2007_Oracle_All_Rights_Reserved_ = null;
    }

    class PushedBatch {
        int[] currentBatchByteLens;
        int[] currentBatchCharLens;
        int[] lastBoundByteLens;
        int[] lastBoundCharLens;
        Accessor[] currentBatchBindAccessors;
        boolean lastBoundNeeded;
        boolean need_to_parse;
        boolean current_batch_need_to_prepare_binds;
        int first_row_in_batch;
        int number_of_rows_to_be_bound;
        OraclePreparedStatement.PushedBatch next;

        PushedBatch() {
        }
    }
}
