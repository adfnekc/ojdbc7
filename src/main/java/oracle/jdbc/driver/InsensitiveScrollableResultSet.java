//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package oracle.jdbc.driver;

import java.sql.ResultSetMetaData;
import java.sql.RowId;
import java.sql.SQLException;
import java.sql.SQLRecoverableException;
import java.sql.Statement;
import oracle.jdbc.OracleResultSet.AuthorizationIndicator;

class InsensitiveScrollableResultSet extends GeneratedScrollableResultSet {
    protected boolean isComplete;
    protected boolean isDoneFetchingRows;
    protected final int maxRows;
    private static final String _Copyright_2007_Oracle_All_Rights_Reserved_ = null;
    public static final String BUILD_DATE = "Thu_Apr_04_15:09:24_PDT_2013";
    public static final boolean TRACE = false;

    InsensitiveScrollableResultSet(PhysicalConnection var1, OracleStatement var2) throws SQLException {
        super(var1, var2);
        this.closeStatementOnClose = var2 == null ? false : var2.isCloseOnCompletion();
        this.isDoneFetchingRows = false;
        this.fetchedRowCount = var2.validRows;
        this.isComplete = var2.isComplete;
        this.maxRows = var2.getMaxRows();
        if (this.maxRows > 0 && this.maxRows < this.fetchedRowCount) {
            this.fetchedRowCount = this.maxRows;
            this.doneFetchingRows(false);
        }

    }

    protected boolean isForwardOnly() {
        return false;
    }

    public int getType() {
        return 1004;
    }

    public int getConcurrency() {
        return 1007;
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

    public void close() throws SQLException {
        synchronized(this.connection) {
            if (!this.closed) {
                super.close();
                if (this.statement.numReturnParams <= 0) {
                    this.doneFetchingRows(false);
                    this.statement.endOfResultSet(false);
                    this.statement.closeCursorOnPlainStatement();
                    if (this.closeStatementOnClose) {
                        try {
                            this.statement.close();
                        } catch (SQLException var4) {
                        }
                    }

                }
            }
        }
    }

    public boolean wasNull() throws SQLException {
        synchronized(this.connection) {
            if (this.closed) {
                SQLException var2 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 10, "wasNull");
                var2.fillInStackTrace();
                throw var2;
            } else {
                return this.statement.wasNullValue(this.currentRow);
            }
        }
    }

    public boolean rowDeleted() throws SQLException {
        return false;
    }

    public ResultSetMetaData getMetaData() throws SQLException {
        synchronized(this.connection) {
            SQLException var2;
            if (this.closed) {
                var2 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 10, "getMetaData");
                var2.fillInStackTrace();
                throw var2;
            } else if (this.statement.closed) {
                var2 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9, "getMetaData");
                var2.fillInStackTrace();
                throw var2;
            } else if (!this.statement.isOpen) {
                var2 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 144, "getMetaData");
                var2.fillInStackTrace();
                throw var2;
            } else {
                return this.statement.getResultSetMetaData();
            }
        }
    }

    public Statement getStatement() throws SQLException {
        synchronized(this.connection) {
            SQLException var2;
            if (this.closed) {
                var2 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 10, "getStatement");
                var2.fillInStackTrace();
                throw var2;
            } else if (this.statement.closed) {
                var2 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9, "getStatement");
                var2.fillInStackTrace();
                throw var2;
            } else {
                return (Statement)(this.statement.wrapper == null ? this.statement : this.statement.wrapper);
            }
        }
    }

    public int findColumn(String var1) throws SQLException {
        synchronized(this.connection) {
            return this.statement.getColumnIndex(var1);
        }
    }

    public void setFetchSize(int var1) throws SQLException {
        synchronized(this.connection) {
            this.statement.setPrefetchInternal(var1, false, false);
        }
    }

    public int getFetchSize() throws SQLException {
        synchronized(this.connection) {
            return this.statement.getPrefetchInternal(false);
        }
    }

    public boolean isBeforeFirst() throws SQLException {
        synchronized(this.connection) {
            SQLException var2;
            if (this.closed) {
                var2 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 10, "isBeforeFirst");
                var2.fillInStackTrace();
                throw var2;
            } else if (this.statement.closed) {
                var2 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9, "isBeforeFirst");
                var2.fillInStackTrace();
                throw var2;
            } else {
                return !this.isEmptyResultSet() && this.currentRow == -1;
            }
        }
    }

    public boolean isAfterLast() throws SQLException {
        synchronized(this.connection) {
            SQLException var2;
            if (this.closed) {
                var2 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 10, "isAfterLast");
                var2.fillInStackTrace();
                throw var2;
            } else if (this.statement.closed) {
                var2 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9, "isAfterLast");
                var2.fillInStackTrace();
                throw var2;
            } else {
                return this.currentRow == this.fetchedRowCount;
            }
        }
    }

    public boolean isFirst() throws SQLException {
        synchronized(this.connection) {
            SQLException var2;
            if (this.closed) {
                var2 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 10, "isFirst");
                var2.fillInStackTrace();
                throw var2;
            } else if (this.statement.closed) {
                var2 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9, "isFirst");
                var2.fillInStackTrace();
                throw var2;
            } else {
                return !this.isEmptyResultSet() && this.currentRow == 0;
            }
        }
    }

    public boolean isLast() throws SQLException {
        synchronized(this.connection) {
            SQLException var2;
            if (this.closed) {
                var2 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 10, "isLast");
                var2.fillInStackTrace();
                throw var2;
            } else if (this.statement.closed) {
                var2 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9, "isLast");
                var2.fillInStackTrace();
                throw var2;
            } else if (this.isForwardOnly()) {
                var2 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 75, "isLast");
                var2.fillInStackTrace();
                throw var2;
            } else {
                if (!this.isComplete && this.currentRow + 1 == this.fetchedRowCount) {
                    this.fetchMoreRows();
                }

                assert this.isComplete || this.fetchedRowCount > this.currentRow + 1 : "isComplete: " + this.isComplete + ", fetchedRowCount: " + this.fetchedRowCount + ", currentRow: " + this.currentRow;

                if (this.fetchedRowCount == 0) {
                    return false;
                } else {
                    return this.isComplete && this.currentRow + 1 == this.fetchedRowCount;
                }
            }
        }
    }

    public int getRow() throws SQLException {
        synchronized(this.connection) {
            SQLException var2;
            if (this.closed) {
                var2 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 10, "getRow");
                var2.fillInStackTrace();
                throw var2;
            } else if (this.statement.closed) {
                var2 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9, "getRow");
                var2.fillInStackTrace();
                throw var2;
            } else if (this.isEmptyResultSet()) {
                return 0;
            } else {
                return this.currentRow == this.fetchedRowCount ? 0 : this.currentRow + 1;
            }
        }
    }

    public boolean absolute(int var1) throws SQLException {
        SQLException var2;
        if (this.closed) {
            var2 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 10, "absolute");
            var2.fillInStackTrace();
            throw var2;
        } else if (this.connection.isClosed()) {
            var2 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 8, "absolute");
            var2.fillInStackTrace();
            throw var2;
        } else if (this.statement.closed) {
            var2 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9, "absolute");
            var2.fillInStackTrace();
            throw var2;
        } else if (this.isForwardOnly()) {
            var2 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 75, "absolute");
            var2.fillInStackTrace();
            throw var2;
        } else {
            return this.absoluteInternal(var1);
        }
    }

    public boolean first() throws SQLException {
        synchronized(this.connection) {
            SQLException var2;
            if (this.closed) {
                var2 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 10, "first");
                var2.fillInStackTrace();
                throw var2;
            } else if (this.connection.isClosed()) {
                var2 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 8, "first");
                var2.fillInStackTrace();
                throw var2;
            } else if (this.statement.closed) {
                var2 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9, "first");
                var2.fillInStackTrace();
                throw var2;
            } else if (this.isForwardOnly()) {
                var2 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 75, "first");
                var2.fillInStackTrace();
                throw var2;
            } else {
                return this.absoluteInternal(1);
            }
        }
    }

    public boolean next() throws SQLException {
        synchronized(this.connection) {
            SQLException var2;
            if (this.statement.sqlKind.isPlsqlOrCall()) {
                var2 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 166, "next");
                var2.fillInStackTrace();
                throw var2;
            } else if (this.closed) {
                var2 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 10, "next");
                var2.fillInStackTrace();
                throw var2;
            } else if (this.connection.isClosed()) {
                var2 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 8, "next");
                var2.fillInStackTrace();
                throw var2;
            } else if (this.statement.closed) {
                var2 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9, "next");
                var2.fillInStackTrace();
                throw var2;
            } else {
                return this.absoluteInternal(this.currentRow + 2);
            }
        }
    }

    public boolean previous() throws SQLException {
        synchronized(this.connection) {
            SQLException var2;
            if (this.closed) {
                var2 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 10, "previous");
                var2.fillInStackTrace();
                throw var2;
            } else if (this.connection.isClosed()) {
                var2 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 8, "previous");
                var2.fillInStackTrace();
                throw var2;
            } else if (this.statement.closed) {
                var2 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9, "previous");
                var2.fillInStackTrace();
                throw var2;
            } else if (this.isForwardOnly()) {
                var2 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 75, "previous");
                var2.fillInStackTrace();
                throw var2;
            } else {
                return this.currentRow > -1 ? this.absoluteInternal(this.currentRow) : false;
            }
        }
    }

    public boolean last() throws SQLException {
        synchronized(this.connection) {
            SQLException var2;
            if (this.closed) {
                var2 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 10, "last");
                var2.fillInStackTrace();
                throw var2;
            } else if (this.connection.isClosed()) {
                var2 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 8, "last");
                var2.fillInStackTrace();
                throw var2;
            } else if (this.statement.closed) {
                var2 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9, "last");
                var2.fillInStackTrace();
                throw var2;
            } else if (this.isForwardOnly()) {
                var2 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 75, "last");
                var2.fillInStackTrace();
                throw var2;
            } else if (this.isEmptyResultSet()) {
                return false;
            } else {
                while(!this.isComplete) {
                    this.fetchMoreRows();
                }

                this.currentRow = this.fetchedRowCount - 1;
                return true;
            }
        }
    }

    public void beforeFirst() throws SQLException {
        synchronized(this.connection) {
            SQLException var2;
            if (this.closed) {
                var2 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 10, "beforeFirst");
                var2.fillInStackTrace();
                throw var2;
            } else if (this.connection.isClosed()) {
                var2 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 8, "beforeFirst");
                var2.fillInStackTrace();
                throw var2;
            } else if (this.statement.closed) {
                var2 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9, "beforeFirst");
                var2.fillInStackTrace();
                throw var2;
            } else if (this.isForwardOnly()) {
                var2 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 75, "beforeFirst");
                var2.fillInStackTrace();
                throw var2;
            } else {
                this.absolute(0);
            }
        }
    }

    public void afterLast() throws SQLException {
        synchronized(this.connection) {
            SQLException var2;
            if (this.closed) {
                var2 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 10, "afterLast");
                var2.fillInStackTrace();
                throw var2;
            } else if (this.connection.isClosed()) {
                var2 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 8, "afterLast");
                var2.fillInStackTrace();
                throw var2;
            } else if (this.statement.closed) {
                var2 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9, "afterLast");
                var2.fillInStackTrace();
                throw var2;
            } else if (this.isForwardOnly()) {
                var2 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 75, "afterLast");
                var2.fillInStackTrace();
                throw var2;
            } else {
                if (!this.isEmptyResultSet()) {
                    while(!this.isComplete) {
                        this.fetchMoreRows();
                    }

                    this.currentRow = this.fetchedRowCount;
                }

            }
        }
    }

    public boolean relative(int var1) throws SQLException {
        synchronized(this.connection) {
            SQLException var3;
            if (this.closed) {
                var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 10, "relative");
                var3.fillInStackTrace();
                throw var3;
            } else if (this.connection.isClosed()) {
                var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 8, "relative");
                var3.fillInStackTrace();
                throw var3;
            } else if (this.statement.closed) {
                var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9, "relative");
                var3.fillInStackTrace();
                throw var3;
            } else if (this.isForwardOnly()) {
                var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 75, "relative");
                var3.fillInStackTrace();
                throw var3;
            } else if (var1 == 0) {
                return this.isValidRow();
            } else if (var1 == 1) {
                return this.next();
            } else if (var1 == -1) {
                return this.previous();
            } else {
                return this.currentRow + var1 < 0 ? this.absoluteInternal(0) : this.absoluteInternal(this.currentRow + var1 + 1);
            }
        }
    }

    public void refreshRow() throws SQLException {
        synchronized(this.connection) {
            SQLException var2;
            if (this.statement.isRowidPrepended && !this.isForwardOnly()) {
                if (this.closed) {
                    var2 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 10, "refreshRow");
                    var2.fillInStackTrace();
                    throw var2;
                } else if (this.statement.closed) {
                    var2 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9, "refreshRow");
                    var2.fillInStackTrace();
                    throw var2;
                } else if (this.currentRow >= 0 && this.currentRow < this.fetchedRowCount) {
                    try {
                        int var8 = this.currentRow + 1;
                        if (this.getFetchDirection() == 1001) {
                            var8 = Math.max(1, this.currentRow - this.getFetchSize() + 1);
                        }

                        this.refreshRows(var8, this.getFetchSize());
                    } catch (SQLRecoverableException var5) {
                        throw var5;
                    } catch (SQLException var6) {
                        SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 90, "Unsupported syntax for refreshRow()", var6);
                        var3.fillInStackTrace();
                        throw var3;
                    }

                } else {
                    var2 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 11);
                    var2.fillInStackTrace();
                    throw var2;
                }
            } else {
                var2 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 23, "refreshRow");
                var2.fillInStackTrace();
                throw var2;
            }
        }
    }

    public <T> T getObject(int var1, Class<T> var2) throws SQLException {
        synchronized(this.connection) {
            SQLException var4;
            if (this.closed) {
                var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 11);
                var4.fillInStackTrace();
                throw var4;
            } else if (this.statement.closed) {
                var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9, "getObject");
                var4.fillInStackTrace();
                throw var4;
            } else if (var1 >= 1 && var1 <= this.statement.getNumberOfColumns()) {
                if (this.currentRow < 0) {
                    var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 14);
                    var4.fillInStackTrace();
                    throw var4;
                } else if (this.currentRow == this.fetchedRowCount) {
                    var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 289);
                    var4.fillInStackTrace();
                    throw var4;
                } else {
                    return this.statement.getObject(this.currentRow, var1, var2);
                }
            } else {
                var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 3);
                var4.fillInStackTrace();
                throw var4;
            }
        }
    }

    public AuthorizationIndicator getAuthorizationIndicator(int var1) throws SQLException {
        synchronized(this.connection) {
            SQLException var3;
            if (this.closed) {
                var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 11);
                var3.fillInStackTrace();
                throw var3;
            } else if (this.currentRow < 0) {
                var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 14);
                var3.fillInStackTrace();
                throw var3;
            } else if (this.currentRow == this.fetchedRowCount) {
                var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 289);
                var3.fillInStackTrace();
                throw var3;
            } else {
                return this.statement.getAuthorizationIndicator(this.currentRow, var1);
            }
        }
    }

    protected boolean absoluteInternal(int var1) throws SQLException {
        int var2 = var1 - 1;
        if (var1 == 0) {
            this.currentRow = var2;
        } else if (var2 >= 0 && var2 < this.fetchedRowCount) {
            this.currentRow = var2;
        } else if (var2 >= 0) {
            while(!this.isComplete && this.fetchedRowCount <= var2) {
                this.fetchMoreRows();
            }

            if (var2 < this.fetchedRowCount) {
                this.currentRow = var2;
            } else {
                assert this.isComplete : "isComplete: " + this.isComplete;

                this.currentRow = this.fetchedRowCount;
                if (this.isForwardOnly()) {
                    this.doneFetchingRows(false);
                }
            }
        } else {
            while(!this.isComplete) {
                this.fetchMoreRows();
            }

            var2 = this.fetchedRowCount + var1;
            if (var2 >= 0 && var2 < this.fetchedRowCount) {
                this.currentRow = var2;
            } else {
                this.currentRow = -1;
            }
        }

        assert this.currentRow < this.fetchedRowCount || this.isComplete : "currentRow: " + this.currentRow + ", fetchedRowCount: " + this.fetchedRowCount + ", isComplete: " + this.isComplete;

        assert -1 <= this.currentRow && this.currentRow <= this.fetchedRowCount : "currentRow: " + this.currentRow + ", fetchedRowCount: " + this.fetchedRowCount;

        return this.currentRow > -1 && this.currentRow < this.fetchedRowCount;
    }

    protected void fetchMoreRows() throws SQLException {
        assert !this.isComplete : "isComplete: " + this.isComplete;

        this.clearWarnings();
        this.fetchedRowCount += this.statement.fetchMoreRows(this.fetchedRowCount);
        this.isComplete = this.statement.isComplete;
        if (this.currentRow == this.fetchedRowCount && this.isForwardOnly()) {
            this.doneFetchingRows(false);
        }

        if (this.maxRows > 0 && this.fetchedRowCount > this.maxRows) {
            this.fetchedRowCount = this.maxRows;
            this.doneFetchingRows(false);
            this.sqlWarning = DatabaseError.addSqlWarning(this.sqlWarning, 275);
        }

    }

    protected void doneFetchingRows(boolean var1) throws SQLException {
        if (!this.isDoneFetchingRows) {
            this.isDoneFetchingRows = true;
            this.isComplete = true;

            try {
                this.statement.closeQuery();
            } catch (SQLException var3) {
            }

        }
    }

    protected boolean isEmptyResultSet() throws SQLException {
        if (this.fetchedRowCount > 0) {
            return false;
        } else if (this.isComplete) {
            return true;
        } else {
            this.fetchMoreRows();

            assert this.fetchedRowCount >= 0 : "fetchedRowCount: " + this.fetchedRowCount;

            return this.fetchedRowCount == 0;
        }
    }

    boolean isValidRow() throws SQLException {
        return this.currentRow > -1 && this.currentRow < this.fetchedRowCount;
    }

    protected int getValidRows() {
        return this.fetchedRowCount;
    }

    OracleStatement getOracleStatement() throws SQLException {
        synchronized(this.connection) {
            return this.statement;
        }
    }

    void removeCurrentRowFromCache() throws SQLException {
        assert this.currentRow < this.fetchedRowCount : "currentRow:" + this.currentRow + " fetchedRowCount:" + this.fetchedRowCount;

        if (!this.isComplete && this.currentRow + 1 == this.fetchedRowCount) {
            this.fetchMoreRows();
        }

        this.statement.removeRowFromCache(this.currentRow);
        --this.fetchedRowCount;
    }

    int refreshRows(int var1, int var2) throws SQLException {
        return this.statement.refreshRows(var1, var2);
    }

    int getColumnCount() throws SQLException {
        return this.statement.accessors != null ? this.statement.numberOfDefinePositions - (1 + this.statement.offsetOfFirstUserColumn) : this.getMetaData().getColumnCount();
    }

    RowId getPrependedRowId() throws SQLException {
        return this.statement.getPrependedRowId(this.currentRow);
    }
}
