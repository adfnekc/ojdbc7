package oracle.jdbc.driver;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import oracle.sql.Datum;

final class T4C8TTIBfile extends T4C8TTILob {
   private static final String _Copyright_2007_Oracle_All_Rights_Reserved_ = null;
   public static final String BUILD_DATE = "Thu_Apr_04_15:09:24_PDT_2013";
   public static final boolean TRACE = false;

   T4C8TTIBfile(T4CConnection var1) {
      super(var1);
   }

   Datum createTemporaryLob(Connection var1, boolean var2, int var3) throws SQLException, IOException {
      Object var4 = null;
      SQLException var5 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), "cannot create a temporary BFILE", -1);
      var5.fillInStackTrace();
      throw var5;
   }

   boolean open(byte[] var1, int var2) throws SQLException, IOException {
      boolean var3 = false;
      var3 = this._open(var1, 11, 256);
      return var3;
   }

   boolean close(byte[] var1) throws SQLException, IOException {
      boolean var2 = false;
      var2 = this._close(var1, 512);
      return var2;
   }

   boolean isOpen(byte[] var1) throws SQLException, IOException {
      boolean var2 = this._isOpen(var1, 1024);
      return var2;
   }

   boolean doesExist(byte[] var1) throws SQLException, IOException {
      boolean var2 = false;
      this.initializeLobdef();
      this.sourceLobLocator = var1;
      this.lobops = 2048L;
      this.nullO2U = true;
      this.doRPC();
      var2 = this.lobnull;
      return var2;
   }
}
