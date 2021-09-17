//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package oracle.jdbc.driver;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

abstract class OracleDriverExtension {
    OracleDriverExtension() {
    }

    abstract Connection getConnection(String var1, Properties var2) throws SQLException;

    abstract OracleStatement allocateStatement(PhysicalConnection var1, int var2, int var3) throws SQLException;

    abstract OraclePreparedStatement allocatePreparedStatement(PhysicalConnection var1, String var2, int var3, int var4) throws SQLException;

    abstract OracleCallableStatement allocateCallableStatement(PhysicalConnection var1, String var2, int var3, int var4) throws SQLException;

    abstract OracleInputStream createInputStream(OracleStatement var1, int var2, Accessor var3) throws SQLException;
}
