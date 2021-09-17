//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package oracle.jdbc.driver;

import java.io.IOException;
import java.io.Reader;
import java.lang.reflect.Array;
import java.sql.NClob;
import java.sql.SQLException;
import java.util.Map;
import oracle.jdbc.OracleDataFactory;
import oracle.jdbc.OracleResultSet.AuthorizationIndicator;
import oracle.jdbc.OracleResultSetMetaData.SecurityAttribute;
import oracle.jdbc.internal.OracleConnection;
import oracle.jdbc.oracore.OracleType;
import oracle.sql.Datum;
import oracle.sql.ORAData;
import oracle.sql.ORADataFactory;

abstract class Accessor extends GeneratedAccessor implements Cloneable {
    static final int FIXED_CHAR = 999;
    static final int CHAR = 96;
    static final int VARCHAR = 1;
    static final int VCS = 9;
    static final int LONG = 8;
    static final int NUMBER = 2;
    static final int VARNUM = 6;
    static final int BINARY_FLOAT = 100;
    static final int BINARY_DOUBLE = 101;
    static final int RAW = 23;
    static final int VBI = 15;
    static final int LONG_RAW = 24;
    static final int ROWID = 104;
    static final int RESULT_SET = 102;
    static final int RSET = 116;
    static final int DATE = 12;
    static final int BLOB = 113;
    static final int CLOB = 112;
    static final int BFILE = 114;
    static final int NAMED_TYPE = 109;
    static final int REF_TYPE = 111;
    static final int TIMESTAMP = 180;
    static final int TIMESTAMPTZ = 181;
    static final int TIMESTAMPLTZ = 231;
    static final int INTERVALYM = 182;
    static final int INTERVALDS = 183;
    static final int UROWID = 208;
    static final int PLSQL_INDEX_TABLE = 998;
    static final int T2S_OVERLONG_RAW = 997;
    static final int SET_CHAR_BYTES = 996;
    static final int NULL_TYPE = 995;
    static final int DML_RETURN_PARAM = 994;
    static final int XMLTYPE = 257;
    static final int ONLY_FORM_USABLE = 0;
    static final int NOT_USABLE = 1;
    static final int NO_NEED_TO_PREPARE = 2;
    static final int NEED_TO_PREPARE = 3;
    static final byte DATA_UNAUTHORIZED = 1;
    static final int NO_LOB_PREFETCH = -1;
    OracleStatement statement;
    boolean outBind;
    int internalType;
    boolean isStream = false;
    boolean isColumnNumberAware = false;
    short formOfUse = 2;
    OracleType internalOtype;
    int externalType;
    String internalTypeName;
    String columnName;
    int describeType;
    int describeMaxLength;
    int describeMaxLengthChars;
    boolean nullable;
    int precision;
    int scale;
    int flags;
    int contflag;
    int total_elems;
    OracleType describeOtype;
    String describeTypeName;
    int definedColumnType = 0;
    int definedColumnSize = 0;
    int oacmxl = 0;
    short udskpos = -1;
    int lobPrefetchSizeForThisColumn = -1;
    SecurityAttribute securityAttribute;
    protected boolean columnInvisible = false;
    short[] rowSpaceIndicator = null;
    int columnDataOffset = 0;
    int lengthIndex = 0;
    int indicatorIndex = 0;
    int byteLength = 0;
    int charLength = 0;
    int defineType;
    boolean isDMLReturnedParam = false;
    int lastRowProcessed = 0;
    boolean isUseLess = false;
    int physicalColumnIndex = -2;
    boolean isNullByDescribe = false;
    static final byte[] NULL_DATA_BYTES = new byte[]{2, 3, 5, 7, 11, 13, 17, 19};
    static final int ROW_METADATA_LENGTH = 1;
    final Representation representation;
    final int representationMaxLength;
    ByteArray rowData;
    long[] rowOffset = null;
    int[] rowLength = null;
    boolean[] rowNull = null;
    byte[] rowMetadata = null;
    Object driverSpecificData;
    int previousRowProcessed = -1;
    final int[] escapeSequenceArr = new int[1];
    final boolean[] readHeaderArr = new boolean[1];
    final boolean[] readAsNonStreamArr = new boolean[1];
    private static final String _Copyright_2007_Oracle_All_Rights_Reserved_ = null;
    public static final String BUILD_DATE = "Thu_Apr_04_15:09:24_PDT_2013";
    public static final boolean TRACE = false;

    void setNoPrefetch() {
    }

    void setPrefetchLength(int var1) {
    }

    PlsqlIbtBindInfo plsqlIndexTableBindInfo() throws SQLException {
        return null;
    }

    void unimpl(String var1) throws SQLException {
        SQLException var2 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 4, var1 + " not implemented for " + this.getClass());
        var2.fillInStackTrace();
        throw var2;
    }

    long updateChecksum(long var1, int var3) throws SQLException {
        if (this.isNull(var3)) {
            CRC64 var10000 = PhysicalConnection.CHECKSUM;
            return CRC64.updateChecksum(var1, NULL_DATA_BYTES, 0, NULL_DATA_BYTES.length);
        } else {
            return this.rowData.updateChecksum(this.getOffset(var3), this.getLength(var3), PhysicalConnection.CHECKSUM, var1);
        }
    }

    void init(OracleStatement var1, int var2, int var3, short var4, boolean var5) throws SQLException {
        this.statement = var1;
        this.outBind = var5;
        this.internalType = var2;
        this.defineType = var3;
        this.formOfUse = var4;
    }

    void initForDataAccess(int var1, int var2, String var3) throws SQLException {
        if (var1 != 0) {
            this.externalType = var1;
        }

        if (var2 > 0 && var2 < this.representationMaxLength) {
            this.byteLength = var2;
        } else {
            this.byteLength = this.representationMaxLength;
        }

    }

    void initForDescribe(int var1, int var2, boolean var3, int var4, int var5, int var6, int var7, int var8, short var9) throws SQLException {
        this.nullable = var3;
        this.precision = var5;
        this.scale = var6;
        this.flags = var4;
        this.contflag = var7;
        this.total_elems = var8;
        this.describeType = var1;
        this.describeMaxLength = var2;
        this.describeMaxLengthChars = var2;
        if (!this.statement.columnsDefinedByUser) {
            this.formOfUse = var9;
        }

    }

    void initForDescribe(int var1, int var2, boolean var3, int var4, int var5, int var6, int var7, int var8, short var9, String var10) throws SQLException {
        this.describeTypeName = var10;
        this.describeOtype = null;
        this.initForDescribe(var1, var2, var3, var4, var5, var6, var7, var8, var9);
    }

    OracleInputStream initForNewRow() throws SQLException {
        this.unimpl("initForNewRow");
        return null;
    }

    int useForDataAccessIfPossible(int var1, int var2, int var3, String var4) throws SQLException {
        byte var5 = 3;
        int var6 = 0;
        int var7 = 0;
        if (this.internalType != 0) {
            if (this.internalType != var1) {
                var5 = 0;
            } else if (this.rowSpaceIndicator != null) {
                var6 = this.byteLength;
                var7 = this.charLength;
            }
        }

        if (var5 == 3) {
            this.initForDataAccess(var2, var3, var4);
            if (!this.outBind && var6 >= this.byteLength && var7 >= this.charLength) {
                var5 = 2;
            }
        }

        return var5;
    }

    boolean useForDescribeIfPossible(int var1, int var2, boolean var3, int var4, int var5, int var6, int var7, int var8, short var9, String var10) throws SQLException {
        if (!this.statement.columnsDefinedByUser && this.externalType == 0 && this.describeType == 0 && var1 != this.describeType) {
            return false;
        } else {
            this.initForDescribe(var1, var2, var3, var4, var5, var6, var7, var8, var9, var10);
            return true;
        }
    }

    void setFormOfUse(short var1) {
        this.formOfUse = var1;
    }

    void updateColumnNumber(int var1) {
    }

    public String toString() {
        return super.toString() + ", statement=" + this.statement + ", outBind=" + this.outBind + ", internalType=" + this.internalType + ", isStream=" + this.isStream + ", formOfUse=" + this.formOfUse + ", internalOtype=" + this.internalOtype + ", externalType=" + this.externalType + ", internalTypeName=" + this.internalTypeName + ", columnName=" + this.columnName + ", describeType=" + this.describeType + ", describeMaxLength=" + this.describeMaxLength + ", nullable=" + this.nullable + ", precision=" + this.precision + ", scale=" + this.scale + ", flags=" + this.flags + ", contflag=" + this.contflag + ", total_elems=" + this.total_elems + ", describeOtype=" + this.describeOtype + ", describeTypeName=" + this.describeTypeName + ", rowData=" + this.rowData + ", rowOffset=" + this.rowOffset + ", rowLength=" + this.rowLength + ", rowNull=" + this.rowNull + ", rowMetadata=" + this.rowMetadata + ", driverSpecificData=" + this.driverSpecificData;
    }

    void fetchNextColumns() throws SQLException {
    }

    void calculateSizeTmpByteArray() {
    }

    boolean unmarshalOneRow() throws SQLException, IOException {
        SQLException var1 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 148);
        var1.fillInStackTrace();
        throw var1;
    }

    void copyRow() throws SQLException, IOException {
        SQLException var1 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 148);
        var1.fillInStackTrace();
        throw var1;
    }

    int readStream(byte[] var1, int var2) throws SQLException, IOException {
        SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 148);
        var3.fillInStackTrace();
        throw var3;
    }

    int getPreviousRowProcessed() throws SQLException {
        SQLException var1 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 148);
        var1.fillInStackTrace();
        throw var1;
    }

    void initMetadata() throws SQLException {
    }

    void setDisplaySize(int var1) throws SQLException {
        this.describeMaxLength = var1;
        this.describeMaxLengthChars = var1;
    }

    protected OracleConnection getConnectionDuringExceptionHandling() {
        return this.statement.getConnectionDuringExceptionHandling();
    }

    protected Accessor(Representation var1, OracleStatement var2, int var3, boolean var4) {
        this.representation = var1;
        this.statement = var2;
        this.representationMaxLength = var3;
        this.rowData = var4 ? this.statement.bindData : this.statement.rowData;
        this.statement.setDriverSpecificData(this);
    }

    protected final long getOffset(int var1) {
        return this.rowOffset[var1];
    }

    protected final void setOffset(int var1, long var2) {
        this.rowOffset[var1] = var2;
    }

    protected final void setOffset(int var1) {
        long var2 = this.rowData.getPosition();
        this.rowOffset[var1] = var2;
    }

    protected final int getLength(int var1) {
        return this.rowLength[var1];
    }

    protected final void setLength(int var1, int var2) {
        this.rowLength[var1] = var2;
    }

    protected final void setLengthAndNull(int var1, int var2) throws SQLException {
        if (var2 == 0) {
            this.setNull(var1, true);
        } else {
            this.setNull(var1, false);
            this.setLength(var1, var2);
        }

    }

    final byte getRowMetadata(int var1) {
        return this.rowMetadata[var1];
    }

    final void setRowMetadata(int var1, byte var2) {
        this.rowMetadata[var1] = var2;
    }

    boolean isNull(int var1) throws SQLException {
        if (this.rowNull == null) {
            SQLException var2 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 21);
            var2.fillInStackTrace();
            throw var2;
        } else {
            return this.rowNull[var1];
        }
    }

    void setNull(int var1, boolean var2) throws SQLException {
        if (this.rowNull == null) {
            SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 21);
            var3.fillInStackTrace();
            throw var3;
        } else {
            this.rowNull[var1] = var2;
            if (var2 && this.statement.connection.protocolId != 3) {
                this.setOffset(var1, -1L);
                this.setLength(var1, -1);
            }

        }
    }

    boolean isNullByDescribe() {
        return this.isNullByDescribe;
    }

    boolean isUseless() {
        return this.isUseLess;
    }

    boolean isUnexpected() {
        return this.rowNull == null;
    }

    void setColumnInvisible(boolean var1) {
        this.columnInvisible = var1;
    }

    boolean isColumnInvisible() {
        return this.columnInvisible;
    }

    void setCapacity(int var1) {
        if (this.rowNull == null) {
            this.rowLength = new int[var1];
            this.rowOffset = new long[var1];
            this.rowNull = new boolean[var1];
            this.rowMetadata = new byte[var1];
        } else if (this.rowNull.length < var1) {
            int[] var2 = new int[var1];
            System.arraycopy(this.rowLength, 0, var2, 0, this.rowLength.length);
            this.rowLength = (int[])((int[])var2);
            long[] var3 = new long[var1];
            System.arraycopy(this.rowOffset, 0, var3, 0, this.rowOffset.length);
            this.rowOffset = (long[])((long[])var3);
            boolean[] var4 = new boolean[var1];
            System.arraycopy(this.rowNull, 0, var4, 0, this.rowNull.length);
            this.rowNull = (boolean[])((boolean[])var4);
            byte[] var5 = new byte[var1];
            System.arraycopy(this.rowMetadata, 0, var5, 0, this.rowMetadata.length);
            this.rowMetadata = (byte[])((byte[])var5);
        }

    }

    Accessor copyForDefine(OracleStatement var1) {
        Accessor var2 = null;

        try {
            var2 = (Accessor)this.clone();
        } catch (CloneNotSupportedException var4) {
        }

        var2.rowNull = null;
        var2.rowLength = null;
        var2.rowOffset = null;
        var2.rowMetadata = null;
        var2.statement = var1;
        var2.rowData = var1.rowData;
        var1.setDriverSpecificData(var2);
        return var2;
    }

    AuthorizationIndicator getAuthorizationIndicator(int var1) throws SQLException {
        byte var2 = this.getRowMetadata(var1);
        if ((var2 & 1) != 0) {
            return AuthorizationIndicator.UNAUTHORIZED;
        } else {
            return this.securityAttribute != SecurityAttribute.ENABLED && this.securityAttribute != SecurityAttribute.NONE ? AuthorizationIndicator.UNKNOWN : AuthorizationIndicator.NONE;
        }
    }

    byte[] getBytesInternal(int var1) throws SQLException {
        assert !this.isNull(var1);

        int var2 = this.getLength(var1);
        long var3 = this.getOffset(var1);
        return this.rowData.get(var3, var2);
    }

    final void getBytesInternal(int var1, byte[] var2) throws SQLException {
        int var3 = this.getLength(var1);

        assert var2.length >= var3 : "data.length: " + var2.length + " len: " + var3;

        long var4 = this.getOffset(var1);
        this.rowData.get(var4, var2, 0, var3);
    }

    byte[] getBytes(int var1) throws SQLException {
        return this.isNull(var1) ? null : this.getBytesInternal(var1);
    }

    String getString(int var1) throws SQLException {
        return null;
    }

    <T> T getObject(int var1, Class<T> var2) throws SQLException {
        if (var2 == null) {
            SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 282);
            var3.fillInStackTrace();
            throw var3;
        } else {
            return this.representation.getObject(this, var1, var2);
        }
    }

    Object getObject(int var1, OracleDataFactory var2) throws SQLException {
        if (var2 == null) {
            SQLException var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 281);
            var4.fillInStackTrace();
            throw var4;
        } else {
            Object var3 = this.getObject(var1, (Map)((Map)null));
            return var2.create(var3, 0);
        }
    }

    ORAData getORAData(int var1, ORADataFactory var2) throws SQLException {
        if (var2 == null) {
            SQLException var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 281);
            var4.fillInStackTrace();
            throw var4;
        } else {
            Datum var3 = this.getOracleObject(var1);
            return var2.create(var3, 0);
        }
    }

    Datum[] getOraclePlsqlIndexTable(int var1) throws SQLException {
        if (this.isNull(var1)) {
            return null;
        } else {
            SQLException var2 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 4, "getOraclePlsqlIndexTable not implemented for " + this.getClass().getName());
            var2.fillInStackTrace();
            throw var2;
        }
    }

    NClob getNClob(int var1) throws SQLException {
        if (this.formOfUse != 2) {
            SQLException var2 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 4);
            var2.fillInStackTrace();
            throw var2;
        } else {
            return (NClob)this.getCLOB(var1);
        }
    }

    String getNString(int var1) throws SQLException {
        return this.getString(var1);
    }

    Reader getNCharacterStream(int var1) throws SQLException {
        return this.getCharacterStream(var1);
    }

    final void copyFrom(Accessor var1, int var2, int var3) throws SQLException {
        assert this.getClass() == var1.getClass() : "srcAcc.class: " + var1.getClass();

        assert 0 <= var2 && var2 < var1.rowNull.length : "srcRow: " + var2 + " srcAcc.capacity: " + var1.rowNull.length;

        assert 0 <= var3 && var3 < this.rowNull.length : "destRow: " + var3 + " capacity: " + this.rowNull.length;

        if (var1.isNull(var2)) {
            this.setNull(var3, true);
        } else {
            this.copyFromInternal(var1, var2, var3);
        }

    }

    protected void copyFromInternal(Accessor var1, int var2, int var3) throws SQLException {
        this.setNull(var3, false);
        boolean var4 = var3 > 0 && this.getOffset(var3 - 1) == this.getOffset(var3) || var3 + 1 < this.statement.storedRowCount && this.getOffset(var3 + 1) == this.getOffset(var3);
        if (var4 && this.getLength(var3) == var1.getLength(var2) && this.rowData.equalBytes(this.getOffset(var3), this.getLength(var3), var1.rowData, var1.getOffset(var2))) {
            this.setRowMetadata(var3, var1.getRowMetadata(var2));
        } else {
            if (var4 || var1.getLength(var2) > this.getLength(var3)) {
                this.statement.locationToPutBytes(this, var3, var1.getLength(var2));
            }

            this.rowData.put(this.getOffset(var3), var1.rowData, var1.getOffset(var2), var1.getLength(var2));
            this.setLength(var3, var1.getLength(var2));
            this.setRowMetadata(var3, var1.getRowMetadata(var2));
        }

    }

    void deleteRow(int var1) throws SQLException {
        this.rowData.freeSpace(this.getOffset(var1), this.getLength(var1));
        this.delete(this.rowNull, var1);
        this.delete(this.rowOffset, var1);
        this.delete(this.rowLength, var1);
        this.delete(this.rowMetadata, var1);
    }

    protected final void delete(Object var1, int var2) {
        int var3 = Array.getLength(var1);

        assert var2 >= 0 && var2 < var3 : "row: " + var2 + " len: " + var3;

        System.arraycopy(var1, var2 + 1, var1, var2, var3 - var2 - 1);
    }
}
