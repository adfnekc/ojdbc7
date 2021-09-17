//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package oracle.jdbc;

import java.sql.SQLException;

public interface OracleOpaque {
    OracleTypeMetaData getOracleMetaData() throws SQLException;

    String getSQLTypeName() throws SQLException;

    Object getValue() throws SQLException;
}
