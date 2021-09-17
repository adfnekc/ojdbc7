//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package oracle.sql;

import java.sql.SQLException;
import oracle.jdbc.internal.ObjectDataFactory;

public interface ORADataFactory extends ObjectDataFactory {
    ORAData create(Datum var1, int var2) throws SQLException;
}
