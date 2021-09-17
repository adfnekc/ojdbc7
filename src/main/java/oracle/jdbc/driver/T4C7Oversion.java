package oracle.jdbc.driver;

import java.io.IOException;
import java.sql.SQLException;

final class T4C7Oversion extends T4CTTIfun {
   byte[] rdbmsVersion = new byte[]{78, 111, 116, 32, 100, 101, 116, 101, 114, 109, 105, 110, 101, 100, 32, 121, 101, 116};
   private final boolean rdbmsVersionO2U = true;
   private final int bufLen = 256;
   private final boolean retVerLenO2U = true;
   int retVerLen = 0;
   private final boolean retVerNumO2U = true;
   long retVerNum = 0L;
   private static final String _Copyright_2007_Oracle_All_Rights_Reserved_ = null;
   public static final String BUILD_DATE = "Thu_Apr_04_15:09:24_PDT_2013";
   public static final boolean TRACE = false;

   T4C7Oversion(T4CConnection var1) {
      super(var1, (byte)3);
      this.setFunCode((short)59);
   }

   void doOVERSION() throws SQLException, IOException {
      this.doRPC();
   }

   void readRPA() throws IOException, SQLException {
      this.retVerLen = this.meg.unmarshalUB2();
      this.rdbmsVersion = this.meg.unmarshalCHR(this.retVerLen);
      this.retVerNum = this.meg.unmarshalUB4();
   }

   void processRPA() throws SQLException {
      if (this.rdbmsVersion == null) {
         SQLException var1 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 438);
         var1.fillInStackTrace();
         throw var1;
      }
   }

   byte[] getVersion() {
      return this.rdbmsVersion;
   }

   short getVersionNumber() {
      byte var1 = 0;
      int var2 = (int)((long)var1 + (this.retVerNum >>> 24 & 255L) * 1000L);
      var2 = (int)((long)var2 + (this.retVerNum >>> 20 & 15L) * 100L);
      var2 = (int)((long)var2 + (this.retVerNum >>> 12 & 15L) * 10L);
      var2 = (int)((long)var2 + (this.retVerNum >>> 8 & 15L));
      return (short)var2;
   }

   long getVersionNumberasIs() {
      return this.retVerNum;
   }

   void marshal() throws IOException {
      this.meg.marshalO2U(true);
      this.meg.marshalSWORD(256);
      this.meg.marshalO2U(true);
      this.meg.marshalO2U(true);
   }

   protected oracle.jdbc.internal.OracleConnection getConnectionDuringExceptionHandling() {
      return this.connection;
   }
}
