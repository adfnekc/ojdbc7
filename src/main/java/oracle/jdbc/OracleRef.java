//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package oracle.jdbc;

import java.sql.Ref;
import java.sql.SQLException;

public interface OracleRef extends Ref {
    OracleTypeMetaData getOracleMetaData() throws SQLException;
}
