//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package oracle.jdbc.internal;

import java.sql.SQLException;

public interface OracleResultSet extends oracle.jdbc.OracleResultSet, ACProxyable {
    void closeStatementOnClose() throws SQLException;
}
