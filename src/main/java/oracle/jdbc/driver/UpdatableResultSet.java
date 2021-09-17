//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package oracle.jdbc.driver;

import java.io.InputStream;
import java.io.Reader;
import java.sql.Blob;
import java.sql.Clob;
import java.sql.PreparedStatement;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.SQLWarning;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import oracle.jdbc.OracleResultSet.AuthorizationIndicator;
import oracle.sql.BLOB;
import oracle.sql.CLOB;
import oracle.sql.Datum;

class UpdatableResultSet extends GeneratedUpdatableResultSet {
    static final int concurrencyType = 1008;
    static final int BEGIN_COLUMN_INDEX = 0;
    private int wasNull;
    private static int _MIN_STREAM_SIZE = 4000;
    OracleResultSet resultSet;
    boolean isCachedRset;
    OracleStatement scrollStmt;
    ResultSetMetaData rsetMetaData;
    private int columnCount;
    private OraclePreparedStatement deleteStmt;
    private OraclePreparedStatement insertStmt;
    private OraclePreparedStatement updateStmt;
    private int[] indexColsChanged;
    private Object[] rowBuffer;
    private boolean[] m_nullIndicator;
    private int[][] typeInfo;
    private boolean isInserting;
    private boolean isUpdating;
    ArrayList tempClobsToFree = null;
    ArrayList tempBlobsToFree = null;
    private static final String _Copyright_2007_Oracle_All_Rights_Reserved_ = null;
    public static final String BUILD_DATE = "Thu_Apr_04_15:09:24_PDT_2013";
    public static final boolean TRACE = false;

    UpdatableResultSet(OracleStatement var1, OracleResultSet var2) throws SQLException {
        super(var1, var2);
        this.resultSet = var2;
        this.scrollStmt = var1;
        this.deleteStmt = null;
        this.insertStmt = null;
        this.updateStmt = null;
        this.indexColsChanged = null;
        this.rowBuffer = null;
        this.m_nullIndicator = null;
        this.typeInfo = (int[][])null;
        this.isInserting = false;
        this.isUpdating = false;
        this.wasNull = -1;
        this.rsetMetaData = null;
        this.columnCount = 0;
        this.getInternalMetadata();
        this.isCachedRset = true;
    }

    void ensureOpen() throws SQLException {
        SQLException var1;
        if (this.closed) {
            var1 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 10);
            var1.fillInStackTrace();
            throw var1;
        } else if (this.resultSet == null || this.scrollStmt == null || this.scrollStmt.closed) {
            var1 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
            var1.fillInStackTrace();
            throw var1;
        }
    }

    public void close() throws SQLException {
        if (!this.closed) {
            synchronized(this.connection) {
                super.close();
                if (this.resultSet != null) {
                    this.resultSet.close();
                }

                if (this.insertStmt != null) {
                    this.insertStmt.close();
                }

                if (this.updateStmt != null) {
                    this.updateStmt.close();
                }

                if (this.deleteStmt != null) {
                    this.deleteStmt.close();
                }

                if (this.scrollStmt != null) {
                    this.scrollStmt.notifyCloseRset();
                }

                this.cancelRowInserts();
                this.connection = LogicalConnection.closedConnection;
                this.resultSet = null;
                this.scrollStmt = null;
                this.rsetMetaData = null;
                this.scrollStmt = null;
                this.deleteStmt = null;
                this.insertStmt = null;
                this.updateStmt = null;
                this.indexColsChanged = null;
                this.rowBuffer = null;
                this.m_nullIndicator = null;
                this.typeInfo = (int[][])null;
            }
        }
    }

    public boolean wasNull() throws SQLException {
        synchronized(this.connection) {
            this.ensureOpen();
            switch(this.wasNull) {
                case 1:
                    return true;
                case 2:
                    return false;
                case 3:
                default:
                    SQLException var2 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 24);
                    var2.fillInStackTrace();
                    throw var2;
                case 4:
                    return this.resultSet.wasNull();
            }
        }
    }

    public Statement getStatement() throws SQLException {
        synchronized(this.connection) {
            this.ensureOpen();
            return this.scrollStmt;
        }
    }

    public SQLWarning getWarnings() throws SQLException {
        synchronized(this.connection) {
            this.ensureOpen();
            SQLWarning var2 = this.resultSet.getWarnings();
            if (this.sqlWarning == null) {
                return var2;
            } else {
                SQLWarning var3;
                for(var3 = this.sqlWarning; var3.getNextWarning() != null; var3 = var3.getNextWarning()) {
                }

                var3.setNextWarning(var2);
                return this.sqlWarning;
            }
        }
    }

    public void clearWarnings() throws SQLException {
        synchronized(this.connection) {
            this.ensureOpen();
            this.sqlWarning = null;
            this.resultSet.clearWarnings();
        }
    }

    public AuthorizationIndicator getAuthorizationIndicator(int var1) throws SQLException {
        synchronized(this.connection) {
            this.ensureOpen();
            if (this.isRowDeleted) {
                SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 82);
                var3.fillInStackTrace();
                throw var3;
            } else {
                return this.resultSet.getAuthorizationIndicator(var1);
            }
        }
    }

    public boolean next() throws SQLException {
        synchronized(this.connection) {
            this.ensureOpen();
            this.cancelRowChanges();
            if (this.isRowDeleted) {
                this.isRowDeleted = false;
                return this.resultSet.isValidRow();
            } else {
                return this.resultSet.next();
            }
        }
    }

    public boolean isBeforeFirst() throws SQLException {
        synchronized(this.connection) {
            this.ensureOpen();
            return this.isRowDeleted ? this.resultSet.isFirst() : this.resultSet.isBeforeFirst();
        }
    }

    public boolean isAfterLast() throws SQLException {
        synchronized(this.connection) {
            this.ensureOpen();
            return this.resultSet.isAfterLast();
        }
    }

    public boolean isFirst() throws SQLException {
        synchronized(this.connection) {
            this.ensureOpen();
            if (this.isRowDeleted) {
                SQLException var2 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 82);
                var2.fillInStackTrace();
                throw var2;
            } else {
                return this.resultSet.isFirst();
            }
        }
    }

    public boolean isLast() throws SQLException {
        synchronized(this.connection) {
            this.ensureOpen();
            if (this.isRowDeleted) {
                SQLException var2 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 82);
                var2.fillInStackTrace();
                throw var2;
            } else {
                return this.resultSet.isLast();
            }
        }
    }

    public void beforeFirst() throws SQLException {
        synchronized(this.connection) {
            this.ensureOpen();
            this.cancelRowChanges();
            this.isRowDeleted = false;
            this.resultSet.beforeFirst();
        }
    }

    public void afterLast() throws SQLException {
        synchronized(this.connection) {
            this.ensureOpen();
            this.cancelRowChanges();
            this.isRowDeleted = false;
            this.resultSet.afterLast();
        }
    }

    public boolean first() throws SQLException {
        synchronized(this.connection) {
            this.ensureOpen();
            this.cancelRowChanges();
            this.isRowDeleted = false;
            return this.resultSet.first();
        }
    }

    public boolean last() throws SQLException {
        synchronized(this.connection) {
            this.ensureOpen();
            this.cancelRowChanges();
            this.isRowDeleted = false;
            return this.resultSet.last();
        }
    }

    public int getRow() throws SQLException {
        synchronized(this.connection) {
            this.ensureOpen();
            if (this.isRowDeleted) {
                SQLException var2 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 82);
                var2.fillInStackTrace();
                throw var2;
            } else {
                return this.resultSet.getRow();
            }
        }
    }

    public boolean absolute(int var1) throws SQLException {
        synchronized(this.connection) {
            this.ensureOpen();
            this.cancelRowChanges();
            this.isRowDeleted = false;
            return this.resultSet.absolute(var1);
        }
    }

    public boolean relative(int var1) throws SQLException {
        synchronized(this.connection) {
            this.ensureOpen();
            this.cancelRowChanges();
            if (this.isRowDeleted) {
                --var1;
                this.isRowDeleted = false;
            }

            return this.resultSet.relative(var1);
        }
    }

    public boolean previous() throws SQLException {
        synchronized(this.connection) {
            this.ensureOpen();
            this.cancelRowChanges();
            this.isRowDeleted = false;
            return this.resultSet.previous();
        }
    }

    void addToTempLobsToFree(Clob var1) {
        if (this.tempClobsToFree == null) {
            this.tempClobsToFree = new ArrayList();
        }

        this.tempClobsToFree.add(var1);
    }

    void addToTempLobsToFree(Blob var1) {
        if (this.tempBlobsToFree == null) {
            this.tempBlobsToFree = new ArrayList();
        }

        this.tempBlobsToFree.add(var1);
    }

    void cleanTempLobs() {
        this.cleanTempClobs(this.tempClobsToFree);
        this.cleanTempBlobs(this.tempBlobsToFree);
        this.tempClobsToFree = null;
        this.tempBlobsToFree = null;
    }

    void cleanTempBlobs(ArrayList var1) {
        if (var1 != null) {
            Iterator var2 = var1.iterator();

            while(var2.hasNext()) {
                try {
                    ((BLOB)((BLOB)var2.next())).freeTemporary();
                } catch (SQLException var4) {
                }
            }
        }

    }

    void cleanTempClobs(ArrayList var1) {
        if (var1 != null) {
            Iterator var2 = var1.iterator();

            while(var2.hasNext()) {
                try {
                    ((CLOB)((CLOB)var2.next())).freeTemporary();
                } catch (SQLException var4) {
                }
            }
        }

    }

    public ResultSetMetaData getMetaData() throws SQLException {
        return this.resultSet.getMetaData();
    }

    public int findColumn(String var1) throws SQLException {
        synchronized(this.connection) {
            this.ensureOpen();
            return this.resultSet.findColumn(var1);
        }
    }

    public void setFetchDirection(int var1) throws SQLException {
        synchronized(this.connection) {
            this.ensureOpen();
            this.resultSet.setFetchDirection(var1);
        }
    }

    public int getFetchDirection() throws SQLException {
        synchronized(this.connection) {
            this.ensureOpen();
            return this.resultSet.getFetchDirection();
        }
    }

    public void setFetchSize(int var1) throws SQLException {
        synchronized(this.connection) {
            this.ensureOpen();
            this.resultSet.setFetchSize(var1);
        }
    }

    public int getFetchSize() throws SQLException {
        synchronized(this.connection) {
            this.ensureOpen();
            return this.resultSet.getFetchSize();
        }
    }

    public int getType() throws SQLException {
        this.ensureOpen();
        return this.scrollStmt.realRsetType.getType();
    }

    public int getConcurrency() throws SQLException {
        this.ensureOpen();
        return 1008;
    }

    public String getCursorName() throws SQLException {
        synchronized(this.connection){}

        try {
            SQLException var2 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 23, "getCursorName");
            var2.fillInStackTrace();
            throw var2;
        } finally {
            ;
        }
    }

    public boolean rowUpdated() throws SQLException {
        return false;
    }

    public boolean rowInserted() throws SQLException {
        return false;
    }

    public boolean rowDeleted() throws SQLException {
        return this.isRowDeleted;
    }

    public void insertRow() throws SQLException {
        synchronized(this.connection) {
            this.ensureOpen();
            SQLException var2;
            if (this.isRowDeleted) {
                var2 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 82);
                var2.fillInStackTrace();
                throw var2;
            } else if (!this.isOnInsertRow()) {
                var2 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 83);
                var2.fillInStackTrace();
                throw var2;
            } else {
                this.prepareInsertRowStatement();
                this.prepareInsertRowBinds();
                this.executeInsertRow();
            }
        }
    }

    public void updateRow() throws SQLException {
        synchronized(this.connection) {
            this.ensureOpen();
            SQLException var5;
            if (this.isRowDeleted) {
                var5 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 82);
                var5.fillInStackTrace();
                throw var5;
            } else if (this.isOnInsertRow()) {
                var5 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 84);
                var5.fillInStackTrace();
                throw var5;
            } else {
                int var2 = this.getNumColumnsChanged();
                if (var2 > 0) {
                    this.prepareUpdateRowStatement(var2);
                    this.prepareUpdateRowBinds(var2);
                    this.executeUpdateRow();
                }

            }
        }
    }

    public void deleteRow() throws SQLException {
        synchronized(this.connection) {
            this.ensureOpen();
            SQLException var2;
            if (this.isRowDeleted) {
                var2 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 82);
                var2.fillInStackTrace();
                throw var2;
            } else if (this.isOnInsertRow()) {
                var2 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 84);
                var2.fillInStackTrace();
                throw var2;
            } else {
                this.prepareDeleteRowStatement();
                this.prepareDeleteRowBinds();
                this.executeDeleteRow();
                this.isRowDeleted = true;
            }
        }
    }

    public void refreshRow() throws SQLException {
        synchronized(this.connection) {
            this.ensureOpen();
            SQLException var2;
            if (this.isRowDeleted) {
                var2 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 82);
                var2.fillInStackTrace();
                throw var2;
            } else if (this.isOnInsertRow()) {
                var2 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 84);
                var2.fillInStackTrace();
                throw var2;
            } else {
                this.resultSet.refreshRow();
            }
        }
    }

    public void cancelRowUpdates() throws SQLException {
        synchronized(this.connection) {
            this.ensureOpen();
            if (this.isUpdating) {
                this.isUpdating = false;
                this.clearRowBuffer();
            }

        }
    }

    public void moveToInsertRow() throws SQLException {
        synchronized(this.connection) {
            this.ensureOpen();
            if (!this.isOnInsertRow()) {
                this.isRowDeleted = false;
                this.isInserting = true;
                if (this.rowBuffer == null) {
                    this.rowBuffer = new Object[this.getColumnCount()];
                }

                if (this.m_nullIndicator == null) {
                    this.m_nullIndicator = new boolean[this.getColumnCount()];
                }

                this.clearRowBuffer();
            }
        }
    }

    public void moveToCurrentRow() throws SQLException {
        synchronized(this.connection) {
            this.ensureOpen();
            if (this.isRowDeleted) {
                SQLException var2 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 82);
                var2.fillInStackTrace();
                throw var2;
            } else {
                this.cancelRowInserts();
            }
        }
    }

    public <T> T getObject(int var1, Class<T> var2) throws SQLException {
        synchronized(this.connection) {
            assert var2 != null : "type: null";

            this.ensureOpen();
            if (this.isRowDeleted) {
                SQLException var8 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 82);
                var8.fillInStackTrace();
                throw var8;
            } else {
                Object var4 = null;
                this.setIsNull(3);
                if (this.isOnInsertRow() || this.isUpdatingRow() && this.isRowBufferUpdatedAt(var1)) {
                    Datum var5 = this.getRowBufferDatumAt(var1);
                    this.setIsNull(var5 == null);
                    if (var5 != null) {
                        var4 = var5.toClass(var2);
                    }
                } else {
                    this.setIsNull(4);
                    var4 = this.resultSet.getObject(var1, var2);
                }

                return (T) var4;
            }
        }
    }

    public void updateNull(int var1) throws SQLException {
        synchronized(this.connection) {
            if (this.isRowDeleted) {
                SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 82);
                var3.fillInStackTrace();
                throw var3;
            } else {
                this.setRowBufferAt(var1, (Datum)null);
            }
        }
    }

    int getColumnCount() throws SQLException {
        if (this.columnCount == 0) {
            this.columnCount = this.resultSet.getColumnCount();
        }

        return this.columnCount;
    }

    ResultSetMetaData getInternalMetadata() throws SQLException {
        if (this.rsetMetaData == null) {
            this.rsetMetaData = this.resultSet.getMetaData();
        }

        return this.rsetMetaData;
    }

    private void cancelRowChanges() throws SQLException {
        synchronized(this.connection) {
            if (this.isInserting) {
                this.cancelRowInserts();
            }

            if (this.isUpdating) {
                this.cancelRowUpdates();
            }

        }
    }

    boolean isOnInsertRow() {
        return this.isInserting;
    }

    private void cancelRowInserts() {
        if (this.isInserting) {
            this.isInserting = false;
            this.clearRowBuffer();
        }

    }

    boolean isUpdatingRow() {
        return this.isUpdating;
    }

    private void clearRowBuffer() {
        int var1;
        if (this.rowBuffer != null) {
            for(var1 = 0; var1 < this.rowBuffer.length; ++var1) {
                this.rowBuffer[var1] = null;
            }
        }

        if (this.m_nullIndicator != null) {
            for(var1 = 0; var1 < this.m_nullIndicator.length; ++var1) {
                this.m_nullIndicator[var1] = false;
            }
        }

        if (this.typeInfo != null) {
            for(var1 = 0; var1 < this.typeInfo.length; ++var1) {
                if (this.typeInfo[var1] != null) {
                    for(int var2 = 0; var2 < this.typeInfo[var1].length; ++var2) {
                        this.typeInfo[var1][var2] = 0;
                    }
                }
            }
        }

        this.cleanTempLobs();
    }

    protected void setRowBufferAt(int var1, Datum var2) throws SQLException {
        this.setRowBufferAt(var1, var2, (int[])null);
    }

    protected void setRowBufferAt(int var1, Object var2, int[] var3) throws SQLException {
        SQLException var4;
        if (!this.isInserting) {
            if (this.isBeforeFirst() || this.isAfterLast() || this.getRow() == 0) {
                var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 82);
                var4.fillInStackTrace();
                throw var4;
            }

            this.isUpdating = true;
        }

        if (var1 >= 1 && var1 <= this.getColumnCount()) {
            if (this.rowBuffer == null) {
                this.rowBuffer = new Object[this.getColumnCount()];
            }

            if (this.m_nullIndicator == null) {
                this.m_nullIndicator = new boolean[this.getColumnCount()];

                for(int var5 = 0; var5 < this.getColumnCount(); ++var5) {
                    this.m_nullIndicator[var5] = false;
                }
            }

            if (var3 != null) {
                if (this.typeInfo == null) {
                    this.typeInfo = new int[this.getColumnCount()][];
                }

                this.typeInfo[var1 - 1] = var3;
            }

            this.rowBuffer[var1 - 1] = var2;
            this.m_nullIndicator[var1 - 1] = var2 == null;
        } else {
            var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 68, "setRowBufferAt");
            var4.fillInStackTrace();
            throw var4;
        }
    }

    protected Datum getRowBufferDatumAt(int var1) throws SQLException {
        if (var1 >= 1 && var1 <= this.getColumnCount()) {
            Datum var5 = null;
            if (this.rowBuffer != null) {
                Object var3 = this.rowBuffer[var1 - 1];
                if (var3 != null) {
                    if (var3 instanceof Datum) {
                        var5 = (Datum)var3;
                    } else {
                        OracleResultSetMetaData var4 = (OracleResultSetMetaData)this.getInternalMetadata();
                        var5 = SQLUtil.makeOracleDatum(this.connection, var3, var4.getColumnType(var1), (String)null, var4.isNCHAR(var1));
                        this.rowBuffer[var1 - 1] = var5;
                    }
                }
            }

            return var5;
        } else {
            SQLException var2 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 68, "getRowBufferDatumAt");
            var2.fillInStackTrace();
            throw var2;
        }
    }

    protected Object getRowBufferAt(int var1) throws SQLException {
        if (var1 >= 1 && var1 <= this.getColumnCount()) {
            return this.rowBuffer != null ? this.rowBuffer[var1 - 1] : null;
        } else {
            SQLException var2 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 68, "getRowBufferDatumAt");
            var2.fillInStackTrace();
            throw var2;
        }
    }

    protected boolean isRowBufferUpdatedAt(int var1) throws SQLException {
        if (var1 >= 1 && var1 <= this.getColumnCount()) {
            if (this.rowBuffer == null) {
                return false;
            } else {
                return this.rowBuffer[var1 - 1] != null || this.m_nullIndicator[var1 - 1];
            }
        } else {
            SQLException var2 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 68, "getRowBufferDatumAt");
            var2.fillInStackTrace();
            throw var2;
        }
    }

    private void prepareInsertRowStatement() throws SQLException {
        if (this.insertStmt == null) {
            String var1 = this.scrollStmt.sqlObject.getInsertSqlForUpdatableResultSet(this);
            PreparedStatement var2 = this.connection.prepareStatement(var1);
            this.insertStmt = (OraclePreparedStatement)((OraclePreparedStatementWrapper)var2).preparedStatement;
            this.insertStmt.setQueryTimeout(this.scrollStmt.getQueryTimeout());
            if (this.scrollStmt.sqlObject.generatedSqlNeedEscapeProcessing()) {
                this.insertStmt.setEscapeProcessing(true);
            }
        }

    }

    private void prepareInsertRowBinds() throws SQLException {
        byte var1 = 1;
        int var6 = this.prepareSubqueryBinds(this.insertStmt, var1);
        OracleResultSetMetaData var2 = (OracleResultSetMetaData)this.getInternalMetadata();

        for(int var3 = 1; var3 <= this.getColumnCount(); ++var3) {
            Object var4 = this.getRowBufferAt(var3);
            if (var4 != null) {
                if (var4 instanceof Reader) {
                    if (var2.isNCHAR(var3)) {
                        this.insertStmt.setFormOfUse(var6 + var3 - 1, (short)2);
                    }

                    this.insertStmt.setCharacterStream(var6 + var3 - 1, (Reader)var4, this.typeInfo[var3 - 1][0]);
                } else if (var4 instanceof InputStream) {
                    if (this.typeInfo[var3 - 1][1] == 2) {
                        this.insertStmt.setBinaryStream(var6 + var3 - 1, (InputStream)var4, this.typeInfo[var3 - 1][0]);
                    } else if (this.typeInfo[var3 - 1][1] == 1) {
                        this.insertStmt.setAsciiStream(var6 + var3 - 1, (InputStream)var4, this.typeInfo[var3 - 1][0]);
                    }
                } else {
                    Datum var7 = this.getRowBufferDatumAt(var3);
                    if (var2.isNCHAR(var3)) {
                        this.insertStmt.setFormOfUse(var6 + var3 - 1, (short)2);
                    }

                    this.insertStmt.setOracleObject(var6 + var3 - 1, var7);
                }
            } else {
                int var5 = this.getInternalMetadata().getColumnType(var3);
                if (var5 != 2006 && var5 != 2002 && var5 != 2008 && var5 != 2007 && var5 != 2003 && var5 != 2009) {
                    this.insertStmt.setNull(var6 + var3 - 1, var5);
                } else {
                    this.insertStmt.setNull(var6 + var3 - 1, var5, this.getInternalMetadata().getColumnTypeName(var3));
                }
            }
        }

    }

    private void executeInsertRow() throws SQLException {
        if (this.insertStmt.executeUpdate() != 1) {
            SQLException var1 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 85);
            var1.fillInStackTrace();
            throw var1;
        }
    }

    private int getNumColumnsChanged() throws SQLException {
        int var1 = 0;
        if (this.indexColsChanged == null) {
            this.indexColsChanged = new int[this.getColumnCount()];
        }

        if (this.rowBuffer != null) {
            for(int var2 = 0; var2 < this.getColumnCount(); ++var2) {
                if (this.rowBuffer[var2] != null || this.rowBuffer[var2] == null && this.m_nullIndicator[var2]) {
                    this.indexColsChanged[var1++] = var2;
                }
            }
        }

        return var1;
    }

    private void prepareUpdateRowStatement(int var1) throws SQLException {
        if (this.updateStmt != null) {
            this.updateStmt.close();
        }

        String var2 = this.scrollStmt.sqlObject.getUpdateSqlForUpdatableResultSet(this, var1, this.rowBuffer, this.indexColsChanged);
        PreparedStatement var3 = this.connection.prepareStatement(var2);
        this.updateStmt = (OraclePreparedStatement)((OraclePreparedStatementWrapper)var3).preparedStatement;
        this.updateStmt.setQueryTimeout(this.scrollStmt.getQueryTimeout());
        if (this.scrollStmt.sqlObject.generatedSqlNeedEscapeProcessing()) {
            this.updateStmt.setEscapeProcessing(true);
        }

    }

    private void prepareUpdateRowBinds(int var1) throws SQLException {
        byte var2 = 1;
        int var8 = this.prepareSubqueryBinds(this.updateStmt, var2);
        OracleResultSetMetaData var3 = (OracleResultSetMetaData)this.getInternalMetadata();

        for(int var4 = 0; var4 < var1; ++var4) {
            int var5 = this.indexColsChanged[var4];
            Object var6 = this.getRowBufferAt(var5 + 1);
            if (var6 != null) {
                if (var6 instanceof Reader) {
                    if (var3.isNCHAR(var5 + 1)) {
                        this.updateStmt.setFormOfUse(var8, (short)2);
                    }

                    this.updateStmt.setCharacterStream(var8++, (Reader)var6, this.typeInfo[var5][0]);
                } else if (var6 instanceof InputStream) {
                    if (this.typeInfo[var5][1] == 2) {
                        this.updateStmt.setBinaryStream(var8++, (InputStream)var6, this.typeInfo[var5][0]);
                    } else if (this.typeInfo[var5][1] == 1) {
                        this.updateStmt.setAsciiStream(var8++, (InputStream)var6, this.typeInfo[var5][0]);
                    }
                } else {
                    Datum var9 = this.getRowBufferDatumAt(var5 + 1);
                    if (var3.isNCHAR(var5 + 1)) {
                        this.updateStmt.setFormOfUse(var8, (short)2);
                    }

                    this.updateStmt.setOracleObject(var8++, var9);
                }
            } else {
                int var7 = this.getInternalMetadata().getColumnType(var5 + 1);
                if (var7 != 2006 && var7 != 2002 && var7 != 2008 && var7 != 2007 && var7 != 2003 && var7 != 2009) {
                    if (var3.isNCHAR(var5 + 1)) {
                        this.updateStmt.setFormOfUse(var8, (short)2);
                    }

                    this.updateStmt.setNull(var8++, var7);
                } else {
                    this.updateStmt.setNull(var8++, var7, this.getInternalMetadata().getColumnTypeName(var5 + 1));
                }
            }
        }

        this.prepareCompareSelfBinds(this.updateStmt, var8);
    }

    private void executeUpdateRow() throws SQLException {
        try {
            if (this.updateStmt.executeUpdate() == 0) {
                SQLException var1 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 85);
                var1.fillInStackTrace();
                throw var1;
            }

            if (this.isCachedRset) {
                this.refreshRows(this.getRow(), 1);
                this.cancelRowUpdates();
            }
        } finally {
            if (this.updateStmt != null) {
                this.updateStmt.close();
                this.updateStmt = null;
            }

        }

    }

    int refreshRows(int var1, int var2) throws SQLException {
        return this.resultSet.refreshRows(var1, var2);
    }

    private void prepareDeleteRowStatement() throws SQLException {
        if (this.deleteStmt == null) {
            String var1 = this.scrollStmt.sqlObject.getDeleteSqlForUpdatableResultSet(this);
            PreparedStatement var2 = this.connection.prepareStatement(var1);
            this.deleteStmt = (OraclePreparedStatement)((OraclePreparedStatementWrapper)var2).preparedStatement;
            this.deleteStmt.setQueryTimeout(this.scrollStmt.getQueryTimeout());
            if (this.scrollStmt.sqlObject.generatedSqlNeedEscapeProcessing()) {
                this.deleteStmt.setEscapeProcessing(true);
            }
        }

    }

    private void prepareDeleteRowBinds() throws SQLException {
        byte var1 = 1;
        int var2 = this.prepareSubqueryBinds(this.deleteStmt, var1);
        this.prepareCompareSelfBinds(this.deleteStmt, var2);
    }

    private void executeDeleteRow() throws SQLException {
        if (this.deleteStmt.executeUpdate() == 0) {
            SQLException var1 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 85);
            var1.fillInStackTrace();
            throw var1;
        } else {
            if (this.isCachedRset) {
                this.removeCurrentRowFromCache();
            }

        }
    }

    void removeCurrentRowFromCache() throws SQLException {
        this.resultSet.removeCurrentRowFromCache();
    }

    private int prepareCompareSelfBinds(OraclePreparedStatement var1, int var2) throws SQLException {
        var1.setRowId(var2, ((InsensitiveScrollableResultSet)this.resultSet).getPrependedRowId());
        return var2 + 1;
    }

    private int prepareSubqueryBinds(OraclePreparedStatement var1, int var2) throws SQLException {
        return var2 + this.scrollStmt.copyBinds(var1, var2 - 1);
    }

    protected void setIsNull(int var1) {
        this.wasNull = var1;
    }

    protected void setIsNull(boolean var1) {
        this.setIsNull(var1 ? 1 : 2);
    }

    protected void doneFetchingRows(boolean var1) throws SQLException {
        this.resultSet.doneFetchingRows(var1);
    }

    OracleStatement getOracleStatement() throws SQLException {
        return this.resultSet == null ? null : this.resultSet.getOracleStatement();
    }
}
