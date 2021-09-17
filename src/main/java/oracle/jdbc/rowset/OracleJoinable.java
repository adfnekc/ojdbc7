package oracle.jdbc.rowset;

import java.sql.SQLException;
import javax.sql.rowset.Joinable;

public interface OracleJoinable extends Joinable {
   int[] getMatchColumnIndexes() throws SQLException;

   String[] getMatchColumnNames() throws SQLException;

   void setMatchColumn(int var1) throws SQLException;

   void setMatchColumn(int[] var1) throws SQLException;

   void setMatchColumn(String var1) throws SQLException;

   void setMatchColumn(String[] var1) throws SQLException;

   void unsetMatchColumn(int var1) throws SQLException;

   void unsetMatchColumn(int[] var1) throws SQLException;

   void unsetMatchColumn(String var1) throws SQLException;

   void unsetMatchColumn(String[] var1) throws SQLException;
}
