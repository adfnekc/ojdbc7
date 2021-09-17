//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package oracle.jdbc;

import java.sql.DatabaseMetaData;
import java.sql.SQLException;

public interface AdditionalDatabaseMetaData extends DatabaseMetaData {
    OracleTypeMetaData getOracleTypeMetaData(String var1) throws SQLException;

    long getLobMaxLength() throws SQLException;
}
