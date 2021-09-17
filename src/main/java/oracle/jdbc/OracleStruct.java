//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package oracle.jdbc;

import java.sql.SQLException;
import java.sql.Struct;

public interface OracleStruct extends Struct {
    OracleTypeMetaData getOracleMetaData() throws SQLException;
}
