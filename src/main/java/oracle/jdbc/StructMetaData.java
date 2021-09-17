//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package oracle.jdbc;

import java.sql.SQLException;

public interface StructMetaData extends OracleResultSetMetaData {
    String getAttributeJavaName(int var1) throws SQLException;

    String getOracleColumnClassName(int var1) throws SQLException;

    boolean isInherited(int var1) throws SQLException;

    int getLocalColumnCount() throws SQLException;
}
