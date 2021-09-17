//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package oracle.sql;

import java.sql.SQLException;
import oracle.jdbc.driver.OracleConnection;
import oracle.jdbc.internal.ObjectData;

public interface CustomDatum extends ObjectData {
    Datum toDatum(OracleConnection var1) throws SQLException;
}
