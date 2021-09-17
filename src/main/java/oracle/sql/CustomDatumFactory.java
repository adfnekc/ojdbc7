//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package oracle.sql;

import java.sql.SQLException;
import oracle.jdbc.internal.ObjectDataFactory;

public interface CustomDatumFactory extends ObjectDataFactory {
    CustomDatum create(Datum var1, int var2) throws SQLException;
}
