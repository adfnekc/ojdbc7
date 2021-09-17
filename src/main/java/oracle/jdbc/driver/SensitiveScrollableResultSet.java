//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package oracle.jdbc.driver;

import java.sql.SQLException;

class SensitiveScrollableResultSet extends InsensitiveScrollableResultSet {
    protected int beginLastFetchedIndex;
    protected int endLastFetchedIndex;
    private static final String _Copyright_2007_Oracle_All_Rights_Reserved_ = null;
    public static final String BUILD_DATE = "Thu_Apr_04_15:09:24_PDT_2013";
    public static final boolean TRACE = false;

    SensitiveScrollableResultSet(PhysicalConnection var1, OracleStatement var2) throws SQLException {
        super(var1, var2);
        if (this.fetchedRowCount > 0) {
            this.beginLastFetchedIndex = 1;
            this.endLastFetchedIndex = this.fetchedRowCount;
        } else {
            this.beginLastFetchedIndex = 0;
            this.endLastFetchedIndex = 0;
        }

    }

    public int getType() {
        return 1005;
    }

    public boolean next() throws SQLException {
        synchronized(this.connection) {
            if (super.next()) {
                this.handleRefetch();
                return true;
            } else {
                return false;
            }
        }
    }

    public boolean first() throws SQLException {
        synchronized(this.connection) {
            if (super.first()) {
                this.handleRefetch();
                return true;
            } else {
                return false;
            }
        }
    }

    public boolean last() throws SQLException {
        synchronized(this.connection) {
            if (super.last()) {
                this.handleRefetch();
                return true;
            } else {
                return false;
            }
        }
    }

    public boolean absolute(int var1) throws SQLException {
        synchronized(this.connection) {
            if (super.absolute(var1)) {
                this.handleRefetch();
                return true;
            } else {
                return false;
            }
        }
    }

    public boolean relative(int var1) throws SQLException {
        synchronized(this.connection) {
            if (super.relative(var1)) {
                this.handleRefetch();
                return true;
            } else {
                return false;
            }
        }
    }

    public boolean previous() throws SQLException {
        synchronized(this.connection) {
            if (super.previous()) {
                this.handleRefetch();
                return true;
            } else {
                return false;
            }
        }
    }

    int refreshRows(int var1, int var2) throws SQLException {
        int var3 = super.refreshRows(var1, var2);
        if (var3 != 0) {
            this.beginLastFetchedIndex = var1;
            this.endLastFetchedIndex = var1 + var3 - 1;
        }

        return var3;
    }

    void removeCurrentRowFromCache() throws SQLException {
        synchronized(this.connection) {
            int var2 = this.currentRow + 1;
            super.removeCurrentRowFromCache();
            if (!this.isEmptyResultSet()) {
                if (var2 < this.beginLastFetchedIndex) {
                    --this.beginLastFetchedIndex;
                }

                if (var2 <= this.endLastFetchedIndex) {
                    --this.endLastFetchedIndex;
                }

                if (!this.isAfterLast()) {
                    this.handleRefetch();
                }
            }

        }
    }

    protected boolean handleRefetch() throws SQLException {
        synchronized(this.connection) {
            int var2 = this.currentRow + 1;
            if (this.beginLastFetchedIndex <= var2 && var2 <= this.endLastFetchedIndex) {
                return false;
            } else {
                this.refreshRow();
                return true;
            }
        }
    }
}
