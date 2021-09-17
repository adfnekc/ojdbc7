package oracle.jdbc.replay;

public class OracleDataSourceFactory {
   public static OracleDataSource getOracleDataSource() {
      return new OracleDataSourceImpl();
   }
}
