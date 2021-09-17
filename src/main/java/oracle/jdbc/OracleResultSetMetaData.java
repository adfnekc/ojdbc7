//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package oracle.jdbc;

import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public interface OracleResultSetMetaData extends ResultSetMetaData {
    boolean isNCHAR(int var1) throws SQLException;

    OracleResultSetMetaData.SecurityAttribute getSecurityAttribute(int var1) throws SQLException;

    boolean isColumnInvisible(int var1) throws SQLException;

    boolean isVariableScale(int var1) throws SQLException;

    public static enum SecurityAttribute {
        NONE,
        ENABLED,
        UNKNOWN;

        private SecurityAttribute() {
        }
    }
}
