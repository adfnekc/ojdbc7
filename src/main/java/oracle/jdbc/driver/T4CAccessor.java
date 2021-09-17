package oracle.jdbc.driver;

import java.io.IOException;
import java.sql.SQLException;

interface T4CAccessor {
   void processIndicator(int var1) throws SQLException, IOException;

   void unmarshalColumnMetadata() throws SQLException, IOException;

   T4CMAREngine getMAREngine();
}
