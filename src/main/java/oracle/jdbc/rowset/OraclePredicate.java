package oracle.jdbc.rowset;

import java.sql.SQLException;
import javax.sql.RowSet;
import javax.sql.rowset.Predicate;

public interface OraclePredicate extends Predicate {
   boolean evaluate(RowSet var1);

   boolean evaluate(Object var1, int var2) throws SQLException;

   boolean evaluate(Object var1, String var2) throws SQLException;
}
