//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package oracle.sql;

import java.sql.Connection;
import java.sql.SQLException;
import oracle.jdbc.internal.ObjectData;

public interface ORAData extends ObjectData {
    Datum toDatum(Connection var1) throws SQLException;
}
