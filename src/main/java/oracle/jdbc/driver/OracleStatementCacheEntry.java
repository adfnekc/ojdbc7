//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package oracle.jdbc.driver;

import java.sql.SQLException;

class OracleStatementCacheEntry {
    protected OracleStatementCacheEntry applicationNext = null;
    protected OracleStatementCacheEntry applicationPrev = null;
    protected OracleStatementCacheEntry explicitNext = null;
    protected OracleStatementCacheEntry explicitPrev = null;
    protected OracleStatementCacheEntry implicitNext = null;
    protected OracleStatementCacheEntry implicitPrev = null;
    boolean onImplicit;
    String sql;
    int statementType;
    int scrollType;
    OraclePreparedStatement statement;
    private static final String _Copyright_2007_Oracle_All_Rights_Reserved_ = null;
    public static final String BUILD_DATE = "Thu_Apr_04_15:09:24_PDT_2013";
    public static final boolean TRACE = false;

    OracleStatementCacheEntry() {
    }

    public void print() throws SQLException {
        System.out.println("Cache entry " + this);
        System.out.println("  Key: " + this.sql + "$$" + this.statementType + "$$" + this.scrollType);
        System.out.println("  Statement: " + this.statement);
        System.out.println("  onImplicit: " + this.onImplicit);
        System.out.println("  applicationNext: " + this.applicationNext + "  applicationPrev: " + this.applicationPrev);
        System.out.println("  implicitNext: " + this.implicitNext + "  implicitPrev: " + this.implicitPrev);
        System.out.println("  explicitNext: " + this.explicitNext + "  explicitPrev: " + this.explicitPrev);
    }
}
