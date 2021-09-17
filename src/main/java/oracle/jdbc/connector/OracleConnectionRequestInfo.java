package oracle.jdbc.connector;

import javax.resource.spi.ConnectionRequestInfo;

public class OracleConnectionRequestInfo implements ConnectionRequestInfo {
   private String user = null;
   private String password = null;
   private static final String _Copyright_2007_Oracle_All_Rights_Reserved_ = null;
   public static final String BUILD_DATE = "Thu_Apr_04_15:09:24_PDT_2013";
   public static final boolean TRACE = false;

   public OracleConnectionRequestInfo(String var1, String var2) {
      this.user = var1;
      this.password = var2;
   }

   public String getUser() {
      return this.user;
   }

   public void setUser(String var1) {
      this.user = var1;
   }

   public String getPassword() {
      return this.password;
   }

   public void setPassword(String var1) {
      this.password = var1;
   }

   public boolean equals(Object var1) {
      if (!(var1 instanceof OracleConnectionRequestInfo)) {
         return false;
      } else {
         OracleConnectionRequestInfo var2 = (OracleConnectionRequestInfo)var1;
         return this.user.equalsIgnoreCase(var2.getUser()) && this.password.equals(var2.getPassword());
      }
   }
}
