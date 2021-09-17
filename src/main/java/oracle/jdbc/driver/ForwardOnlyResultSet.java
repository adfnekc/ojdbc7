//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package oracle.jdbc.driver;

import java.sql.SQLException;

class ForwardOnlyResultSet extends InsensitiveScrollableResultSet {
    private static final String _Copyright_2007_Oracle_All_Rights_Reserved_ = null;
    public static final String BUILD_DATE = "Thu_Apr_04_15:09:24_PDT_2013";
    public static final boolean TRACE = false;

    ForwardOnlyResultSet(PhysicalConnection var1, OracleStatement var2) throws SQLException {
        super(var1, var2);
    }

    protected boolean isForwardOnly() {
        return true;
    }

    public int getType() {
        return 1003;
    }
}
