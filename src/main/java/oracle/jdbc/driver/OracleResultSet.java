//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package oracle.jdbc.driver;

import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.SQLWarning;
import java.sql.Statement;
import oracle.jdbc.OracleResultSet.AuthorizationIndicator;
import oracle.jdbc.internal.OracleConnection;

abstract class OracleResultSet extends GeneratedResultSet {
    static final boolean DEBUG = false;
    boolean closed = false;
    SQLWarning sqlWarning = null;
    protected boolean closeStatementOnClose = false;
    private static final String _Copyright_2007_Oracle_All_Rights_Reserved_ = null;
    public static final String BUILD_DATE = "Thu_Apr_04_15:09:24_PDT_2013";
    public static final boolean TRACE = false;

    static OracleResultSet createResultSet(OracleStatement var0) throws SQLException {
        if (!var0.sqlKind.isSELECT()) {
            var0.realRsetType = OracleResultSet.ResultSetType.FORWARD_READ_ONLY;
            var0.described = true;
        }

        return var0.realRsetType == OracleResultSet.ResultSetType.UNKNOWN ? var0.userRsetType.createResultSet(var0) : var0.realRsetType.createResultSet(var0);
    }

    protected OracleResultSet(PhysicalConnection var1) {
        super(var1);
    }

    protected abstract void doneFetchingRows(boolean var1) throws SQLException;

    public void closeStatementOnClose() {
        this.closeStatementOnClose = true;
    }

    public abstract AuthorizationIndicator getAuthorizationIndicator(int var1) throws SQLException;

    public AuthorizationIndicator getAuthorizationIndicator(String var1) throws SQLException {
        return this.getAuthorizationIndicator(this.findColumn(var1));
    }

    boolean isValidRow() throws SQLException {
        SQLException var1 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 23, "isValidRow");
        var1.fillInStackTrace();
        throw var1;
    }

    public void close() throws SQLException {
        this.closed = true;
    }

    public boolean isClosed() throws SQLException {
        return this.closed;
    }

    public SQLWarning getWarnings() throws SQLException {
        return this.sqlWarning;
    }

    public void clearWarnings() throws SQLException {
        this.sqlWarning = null;
    }

    public abstract String getCursorName() throws SQLException;

    public abstract ResultSetMetaData getMetaData() throws SQLException;

    public abstract boolean next() throws SQLException;

    public abstract boolean wasNull() throws SQLException;

    public abstract boolean isBeforeFirst() throws SQLException;

    public abstract boolean isAfterLast() throws SQLException;

    public abstract boolean isFirst() throws SQLException;

    public abstract boolean isLast() throws SQLException;

    public abstract void beforeFirst() throws SQLException;

    public abstract void afterLast() throws SQLException;

    public abstract boolean first() throws SQLException;

    public abstract boolean last() throws SQLException;

    public abstract int getRow() throws SQLException;

    public abstract boolean absolute(int var1) throws SQLException;

    public abstract boolean relative(int var1) throws SQLException;

    public abstract boolean previous() throws SQLException;

    public void setFetchDirection(int var1) throws SQLException {
    }

    public int getFetchDirection() throws SQLException {
        return 1000;
    }

    public abstract void setFetchSize(int var1) throws SQLException;

    public abstract int getFetchSize() throws SQLException;

    public abstract int getType() throws SQLException;

    public abstract int getConcurrency() throws SQLException;

    public int getHoldability() throws SQLException {
        if (this.isClosed()) {
            SQLException var1 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 10, (Object)null);
            var1.fillInStackTrace();
            throw var1;
        } else {
            return 1;
        }
    }

    public void insertRow() throws SQLException {
        SQLException var1 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 76, "insertRow");
        var1.fillInStackTrace();
        throw var1;
    }

    public void updateRow() throws SQLException {
        SQLException var1 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 76, "updateRow");
        var1.fillInStackTrace();
        throw var1;
    }

    public void deleteRow() throws SQLException {
        SQLException var1 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 76, "deleteRow");
        var1.fillInStackTrace();
        throw var1;
    }

    public void refreshRow() throws SQLException {
        SQLException var1 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 23, (Object)null);
        var1.fillInStackTrace();
        throw var1;
    }

    public void moveToInsertRow() throws SQLException {
        SQLException var1 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 76, "moveToInsertRow");
        var1.fillInStackTrace();
        throw var1;
    }

    public void cancelRowUpdates() throws SQLException {
        SQLException var1 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 76, "cancelRowUpdates");
        var1.fillInStackTrace();
        throw var1;
    }

    public void moveToCurrentRow() throws SQLException {
        SQLException var1 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 76, "moveToCurrentRow");
        var1.fillInStackTrace();
        throw var1;
    }

    public abstract Statement getStatement() throws SQLException;

    public void updateNull(int var1) throws SQLException {
        SQLException var2 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 76, "updateNull");
        var2.fillInStackTrace();
        throw var2;
    }

    public void updateNull(String var1) throws SQLException {
        this.updateNull(this.findColumn(var1));
    }

    public boolean rowUpdated() throws SQLException {
        return false;
    }

    public boolean rowInserted() throws SQLException {
        return false;
    }

    public boolean rowDeleted() throws SQLException {
        return false;
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

    public abstract <T> T getObject(int var1, Class<T> var2) throws SQLException;

    public <T> T getObject(String var1, Class<T> var2) throws SQLException {
        return this.getObject(this.findColumn(var1), var2);
    }

    protected OracleConnection getConnectionDuringExceptionHandling() {
        return null;
    }

    abstract OracleStatement getOracleStatement() throws SQLException;

    abstract int refreshRows(int var1, int var2) throws SQLException;

    abstract void removeCurrentRowFromCache() throws SQLException;

    abstract int getColumnCount() throws SQLException;

    static enum ResultSetType {
        UNKNOWN(-1, -1, false) {
            OracleResultSet createResultSet(OracleStatement var1) throws SQLException {
                SQLException var2 = DatabaseError.createSqlException((OracleConnection)null, 23, (Object)null);
                var2.fillInStackTrace();
                throw var2;
            }

            OracleResultSet.ResultSetType downgrade() {
                return UNKNOWN;
            }
        },
        FORWARD_READ_ONLY(1003, 1007, false) {
            OracleResultSet createResultSet(OracleStatement var1) throws SQLException {
                return new ForwardOnlyResultSet(var1.connection, var1);
            }

            OracleResultSet.ResultSetType downgrade() {
                return FORWARD_READ_ONLY;
            }
        },
        FORWARD_UPDATABLE(1003, 1008, true) {
            OracleResultSet createResultSet(OracleStatement var1) throws SQLException {
                ForwardOnlyResultSet var2 = new ForwardOnlyResultSet(var1.connection, var1);
                return new UpdatableResultSet(var1, var2);
            }

            OracleResultSet.ResultSetType downgrade() {
                return FORWARD_READ_ONLY;
            }
        },
        INSENSITIVE_READ_ONLY(1004, 1007, false) {
            OracleResultSet createResultSet(OracleStatement var1) throws SQLException {
                return new InsensitiveScrollableResultSet(var1.connection, var1);
            }

            OracleResultSet.ResultSetType downgrade() {
                return FORWARD_READ_ONLY;
            }
        },
        INSENSITIVE_UPDATABLE(1004, 1008, true) {
            OracleResultSet createResultSet(OracleStatement var1) throws SQLException {
                InsensitiveScrollableResultSet var2 = new InsensitiveScrollableResultSet(var1.connection, var1);
                return new UpdatableResultSet(var1, var2);
            }

            OracleResultSet.ResultSetType downgrade() {
                return INSENSITIVE_READ_ONLY;
            }
        },
        SENSITIVE_READ_ONLY(1005, 1007, true) {
            OracleResultSet createResultSet(OracleStatement var1) throws SQLException {
                return new SensitiveScrollableResultSet(var1.connection, var1);
            }

            OracleResultSet.ResultSetType downgrade() {
                return INSENSITIVE_READ_ONLY;
            }
        },
        SENSITIVE_UPDATABLE(1005, 1008, true) {
            OracleResultSet createResultSet(OracleStatement var1) throws SQLException {
                SensitiveScrollableResultSet var2 = new SensitiveScrollableResultSet(var1.connection, var1);
                return new UpdatableResultSet(var1, var2);
            }

            OracleResultSet.ResultSetType downgrade() {
                return INSENSITIVE_READ_ONLY;
            }
        };

        private final int type;
        private final int concur;
        private final boolean isIdentifierRequired;

        static OracleResultSet.ResultSetType typeFor(int var0, int var1) throws SQLException {
            OracleResultSet.ResultSetType[] var2 = (OracleResultSet.ResultSetType[])OracleResultSet.ResultSetType.class.getEnumConstants();
            int var3 = var2.length;

            for(int var4 = 0; var4 < var3; ++var4) {
                OracleResultSet.ResultSetType var5 = var2[var4];
                if (var5.getType() == var0 && var5.getConcur() == var1) {
                    return var5;
                }
            }

            SQLException var6 = DatabaseError.createSqlException((OracleConnection)null, 68, "type: " + var0 + " concurency: " + var1);
            var6.fillInStackTrace();
            throw var6;
        }

        private ResultSetType(int var3, int var4, boolean var5) {
            this.type = var3;
            this.concur = var4;
            this.isIdentifierRequired = var5;
        }

        int getType() {
            return this.type;
        }

        int getConcur() {
            return this.concur;
        }

        boolean isIdentifierRequired() {
            return this.isIdentifierRequired;
        }

        boolean isForwardOnly() {
            return this.type == 1003;
        }

        boolean isScrollable() {
            return this.type != 1003;
        }

        boolean isUpdatable() {
            return this.concur == 1008;
        }

        abstract OracleResultSet createResultSet(OracleStatement var1) throws SQLException;

        abstract OracleResultSet.ResultSetType downgrade();
    }
}
