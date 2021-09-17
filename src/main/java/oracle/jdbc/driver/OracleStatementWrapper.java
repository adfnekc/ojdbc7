//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package oracle.jdbc.driver;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLWarning;
import oracle.jdbc.dcn.DatabaseChangeRegistration;
import oracle.jdbc.internal.OracleCallableStatement;
import oracle.jdbc.internal.OracleConnection;
import oracle.jdbc.internal.OracleStatement;
import oracle.jdbc.internal.OracleStatement.BindChecksumListener;
import oracle.jdbc.internal.OracleStatement.SqlKind;

class OracleStatementWrapper implements OracleStatement {
    private Object forEquals;
    protected OracleStatement statement;
    static final OracleCallableStatement closedStatement = new OracleClosedStatement();
    SqlKind sqlKind;
    long checkSum;
    boolean checkSumComputationFailure;
    Object acProxy;
    private static final String _Copyright_2007_Oracle_All_Rights_Reserved_ = null;
    public static final String BUILD_DATE = "Thu_Apr_04_15:09:24_PDT_2013";
    public static final boolean TRACE = false;

    OracleStatementWrapper(oracle.jdbc.OracleStatement var1) throws SQLException {
        this.sqlKind = SqlKind.UNINITIALIZED;
        this.checkSum = 0L;
        this.checkSumComputationFailure = false;
        this.forEquals = var1;
        this.statement = (OracleStatement)var1;
        ((Wrappable)var1).setWrapper(this);
    }

    public void close() throws SQLException {
        if (this.statement != closedStatement) {
            this.checkSum = ((oracle.jdbc.driver.OracleStatement)this.statement).checkSum = this.checkSum;
            this.checkSumComputationFailure = ((oracle.jdbc.driver.OracleStatement)this.statement).checkSumComputationFailure;
            this.sqlKind = ((oracle.jdbc.driver.OracleStatement)this.statement).sqlKind;
            this.statement.close();
            ((Wrappable)this.statement).setWrapper((Object)null);
            this.statement = closedStatement;
        }
    }

    void beClosed() throws SQLException {
        this.statement = closedStatement;
    }

    public void closeWithKey(String var1) throws SQLException {
        this.statement.closeWithKey(var1);
        this.statement = closedStatement;
    }

    public boolean equals(Object var1) {
        return var1 != null && this.getClass() == var1.getClass() && this.forEquals == ((OracleStatementWrapper)var1).forEquals;
    }

    public int hashCode() {
        return this.forEquals.hashCode();
    }

    public int getFetchDirection() throws SQLException {
        return this.statement.getFetchDirection();
    }

    public int getFetchSize() throws SQLException {
        return this.statement.getFetchSize();
    }

    public int getMaxFieldSize() throws SQLException {
        return this.statement.getMaxFieldSize();
    }

    public int getMaxRows() throws SQLException {
        return this.statement.getMaxRows();
    }

    public int getQueryTimeout() throws SQLException {
        return this.statement.getQueryTimeout();
    }

    public int getResultSetConcurrency() throws SQLException {
        return this.statement.getResultSetConcurrency();
    }

    public int getResultSetHoldability() throws SQLException {
        return this.statement.getResultSetHoldability();
    }

    public int getResultSetType() throws SQLException {
        return this.statement.getResultSetType();
    }

    public int getUpdateCount() throws SQLException {
        return this.statement.getUpdateCount();
    }

    public void cancel() throws SQLException {
        this.statement.cancel();
    }

    public void clearBatch() throws SQLException {
        this.statement.clearBatch();
    }

    public void clearWarnings() throws SQLException {
        this.statement.clearWarnings();
    }

    public boolean getMoreResults() throws SQLException {
        return this.statement.getMoreResults();
    }

    public int[] executeBatch() throws SQLException {
        return this.statement.executeBatch();
    }

    public void setFetchDirection(int var1) throws SQLException {
        this.statement.setFetchDirection(var1);
    }

    public void setFetchSize(int var1) throws SQLException {
        this.statement.setFetchSize(var1);
    }

    public void setMaxFieldSize(int var1) throws SQLException {
        this.statement.setMaxFieldSize(var1);
    }

    public void setMaxRows(int var1) throws SQLException {
        this.statement.setMaxRows(var1);
    }

    public void setQueryTimeout(int var1) throws SQLException {
        this.statement.setQueryTimeout(var1);
    }

    public boolean getMoreResults(int var1) throws SQLException {
        return this.statement.getMoreResults(var1);
    }

    public void setEscapeProcessing(boolean var1) throws SQLException {
        this.statement.setEscapeProcessing(var1);
    }

    public int executeUpdate(String var1) throws SQLException {
        return this.statement.executeUpdate(var1);
    }

    public void addBatch(String var1) throws SQLException {
        this.statement.addBatch(var1);
    }

    public void setCursorName(String var1) throws SQLException {
        this.statement.setCursorName(var1);
    }

    public boolean execute(String var1) throws SQLException {
        return this.statement.execute(var1);
    }

    public int executeUpdate(String var1, int var2) throws SQLException {
        return this.statement.executeUpdate(var1, var2);
    }

    public boolean execute(String var1, int var2) throws SQLException {
        return this.statement.execute(var1, var2);
    }

    public int executeUpdate(String var1, int[] var2) throws SQLException {
        return this.statement.executeUpdate(var1, var2);
    }

    public boolean execute(String var1, int[] var2) throws SQLException {
        return this.statement.execute(var1, var2);
    }

    public Connection getConnection() throws SQLException {
        return this.statement.getConnection();
    }

    public ResultSet getGeneratedKeys() throws SQLException {
        return this.statement.getGeneratedKeys();
    }

    public ResultSet getResultSet() throws SQLException {
        return this.statement.getResultSet();
    }

    public SQLWarning getWarnings() throws SQLException {
        return this.statement.getWarnings();
    }

    public int executeUpdate(String var1, String[] var2) throws SQLException {
        return this.statement.executeUpdate(var1, var2);
    }

    public boolean execute(String var1, String[] var2) throws SQLException {
        return this.statement.execute(var1, var2);
    }

    public ResultSet executeQuery(String var1) throws SQLException {
        return this.statement.executeQuery(var1);
    }

    public void clearDefines() throws SQLException {
        this.statement.clearDefines();
    }

    public void defineColumnType(int var1, int var2) throws SQLException {
        this.statement.defineColumnType(var1, var2);
    }

    public void defineColumnType(int var1, int var2, int var3) throws SQLException {
        this.statement.defineColumnType(var1, var2, var3);
    }

    public void defineColumnType(int var1, int var2, int var3, short var4) throws SQLException {
        this.statement.defineColumnType(var1, var2, var3, var4);
    }

    public void defineColumnTypeBytes(int var1, int var2, int var3) throws SQLException {
        this.statement.defineColumnTypeBytes(var1, var2, var3);
    }

    public void defineColumnTypeChars(int var1, int var2, int var3) throws SQLException {
        this.statement.defineColumnTypeChars(var1, var2, var3);
    }

    public void defineColumnType(int var1, int var2, String var3) throws SQLException {
        this.statement.defineColumnType(var1, var2, var3);
    }

    public int getRowPrefetch() {
        return this.statement.getRowPrefetch();
    }

    public void setRowPrefetch(int var1) throws SQLException {
        this.statement.setRowPrefetch(var1);
    }

    public int getLobPrefetchSize() throws SQLException {
        return this.statement.getLobPrefetchSize();
    }

    public void setLobPrefetchSize(int var1) throws SQLException {
        this.statement.setLobPrefetchSize(var1);
    }

    public int creationState() {
        return this.statement.creationState();
    }

    public boolean isNCHAR(int var1) throws SQLException {
        return this.statement.isNCHAR(var1);
    }

    public void setDatabaseChangeRegistration(DatabaseChangeRegistration var1) throws SQLException {
        this.statement.setDatabaseChangeRegistration(var1);
    }

    public boolean isClosed() throws SQLException {
        return this.statement.isClosed();
    }

    public boolean isPoolable() throws SQLException {
        return this.statement.isPoolable();
    }

    public void setPoolable(boolean var1) throws SQLException {
        this.statement.setPoolable(var1);
    }

    public boolean isWrapperFor(Class<?> var1) throws SQLException {
        if (var1.isInterface()) {
            return var1.isInstance(this);
        } else {
            SQLException var2 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 177);
            var2.fillInStackTrace();
            throw var2;
        }
    }

    public <T> T unwrap(Class<T> var1) throws SQLException {
        if (var1.isInterface() && var1.isInstance(this)) {
            return (T) this;
        } else {
            SQLException var2 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 177);
            var2.fillInStackTrace();
            throw var2;
        }
    }

    public boolean isCloseOnCompletion() throws SQLException {
        return this.statement.isCloseOnCompletion();
    }

    public void closeOnCompletion() throws SQLException {
        this.statement.closeOnCompletion();
    }

    public void setFixedString(boolean var1) {
        this.statement.setFixedString(var1);
    }

    public boolean getFixedString() {
        return this.statement.getFixedString();
    }

    public int sendBatch() throws SQLException {
        return this.statement.sendBatch();
    }

    public boolean getserverCursor() {
        return this.statement.getserverCursor();
    }

    public int getcacheState() {
        return this.statement.getcacheState();
    }

    public int getstatementType() {
        return this.statement.getstatementType();
    }

    public String[] getRegisteredTableNames() throws SQLException {
        return this.statement.getRegisteredTableNames();
    }

    public long getRegisteredQueryId() throws SQLException {
        return this.statement.getRegisteredQueryId();
    }

    protected OracleConnection getConnectionDuringExceptionHandling() {
        return null;
    }

    public void setSnapshotSCN(long var1) throws SQLException {
        this.statement.setSnapshotSCN(var1);
    }

    public SqlKind getSqlKind() throws SQLException {
        return this.statement == closedStatement ? this.sqlKind : this.statement.getSqlKind();
    }

    public long getChecksum() throws SQLException {
        if (this.statement != closedStatement) {
            return this.statement.getChecksum();
        } else if (this.checkSumComputationFailure) {
            SQLException var1 = DatabaseError.createUnsupportedFeatureSqlException();
            var1.fillInStackTrace();
            throw var1;
        } else {
            return this.checkSum;
        }
    }

    public void registerBindChecksumListener(BindChecksumListener var1) throws SQLException {
        this.statement.registerBindChecksumListener(var1);
    }

    public void setACProxy(Object var1) {
        this.acProxy = var1;
    }

    public Object getACProxy() {
        return this.acProxy;
    }
}
