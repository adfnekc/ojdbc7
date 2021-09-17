//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package oracle.jdbc.driver;

import java.sql.Connection;
import java.sql.SQLException;
import oracle.jdbc.pool.OraclePooledConnection;
import oracle.sql.BLOB;
import oracle.sql.CLOB;

class ClosedConnection extends PhysicalConnection {
    private static final String _Copyright_2007_Oracle_All_Rights_Reserved_ = null;
    public static final String BUILD_DATE = "Thu_Apr_04_15:09:24_PDT_2013";
    public static final boolean TRACE = false;

    ClosedConnection() {
        this.lifecycle = 4;
    }

    void initializePassword(String var1) throws SQLException {
    }

    OracleStatement RefCursorBytesToStatement(byte[] var1, OracleStatement var2) throws SQLException {
        SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 8);
        var3.fillInStackTrace();
        throw var3;
    }

    OracleStatement createImplicitResultSetStatement(OracleStatement var1) throws SQLException {
        SQLException var2 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 8);
        var2.fillInStackTrace();
        throw var2;
    }

    int getDefaultStreamChunkSize() {
        return -1;
    }

    short doGetVersionNumber() throws SQLException {
        SQLException var1 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 8);
        var1.fillInStackTrace();
        throw var1;
    }

    String doGetDatabaseProductVersion() throws SQLException {
        SQLException var1 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 8);
        var1.fillInStackTrace();
        throw var1;
    }

    void doRollback() throws SQLException {
        SQLException var1 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 8);
        var1.fillInStackTrace();
        throw var1;
    }

    void doCommit(int var1) throws SQLException {
        SQLException var2 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 8);
        var2.fillInStackTrace();
        throw var2;
    }

    void doSetAutoCommit(boolean var1) throws SQLException {
        SQLException var2 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 8);
        var2.fillInStackTrace();
        throw var2;
    }

    void cancelOperationOnServer(boolean var1) throws SQLException {
        SQLException var2 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 8);
        var2.fillInStackTrace();
        throw var2;
    }

    void doAbort() throws SQLException {
    }

    void open(OracleStatement var1) throws SQLException {
        SQLException var2 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 8);
        var2.fillInStackTrace();
        throw var2;
    }

    void logon() throws SQLException {
        SQLException var1 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 8);
        var1.fillInStackTrace();
        throw var1;
    }

    public void getPropertyForPooledConnection(OraclePooledConnection var1) throws SQLException {
        SQLException var2 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 8);
        var2.fillInStackTrace();
        throw var2;
    }

    public BLOB createTemporaryBlob(Connection var1, boolean var2, int var3) throws SQLException {
        SQLException var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 8);
        var4.fillInStackTrace();
        throw var4;
    }

    public CLOB createTemporaryClob(Connection var1, boolean var2, int var3, short var4) throws SQLException {
        SQLException var5 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 8);
        var5.fillInStackTrace();
        throw var5;
    }

    public boolean attachServerConnection() throws SQLException {
        SQLException var1 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 8);
        var1.fillInStackTrace();
        throw var1;
    }

    public void detachServerConnection(String var1) throws SQLException {
        SQLException var2 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 8);
        var2.fillInStackTrace();
        throw var2;
    }

    public boolean needToPurgeStatementCache() throws SQLException {
        SQLException var1 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 8);
        var1.fillInStackTrace();
        throw var1;
    }

    public boolean isDRCPEnabled() throws SQLException {
        SQLException var1 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 8);
        var1.fillInStackTrace();
        throw var1;
    }

    public int getVarTypeMaxLenCompat() throws SQLException {
        SQLException var1 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 8);
        var1.fillInStackTrace();
        throw var1;
    }
}
