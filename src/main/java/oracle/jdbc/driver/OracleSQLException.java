package oracle.jdbc.driver;

import java.sql.SQLException;

public class OracleSQLException extends SQLException {
   private Object[] m_parameters;
   private static final String _Copyright_2007_Oracle_All_Rights_Reserved_ = null;
   public static final String BUILD_DATE = "Thu_Apr_04_15:09:24_PDT_2013";
   public static final boolean TRACE = false;

   public OracleSQLException() {
      this((String)null, (String)null, 0);
   }

   public OracleSQLException(String var1) {
      this(var1, (String)null, 0);
   }

   public OracleSQLException(String var1, String var2) {
      this(var1, var2, 0);
   }

   public OracleSQLException(String var1, String var2, int var3) {
      this(var1, var2, var3, (Object[])null);
   }

   public OracleSQLException(String var1, String var2, int var3, Object[] var4) {
      super(var1, var2, var3);
      this.m_parameters = var4;
   }

   public Object[] getParameters() {
      if (this.m_parameters == null) {
         this.m_parameters = new Object[0];
      }

      return this.m_parameters;
   }

   public int getNumParameters() {
      if (this.m_parameters == null) {
         this.m_parameters = new Object[0];
      }

      return this.m_parameters.length;
   }

   public void setParameters(Object[] var1) {
      this.m_parameters = var1;
   }
}
