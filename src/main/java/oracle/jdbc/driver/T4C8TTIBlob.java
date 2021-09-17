package oracle.jdbc.driver;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import oracle.sql.BLOB;
import oracle.sql.Datum;

final class T4C8TTIBlob extends T4C8TTILob {
   private static final String _Copyright_2007_Oracle_All_Rights_Reserved_ = null;
   public static final String BUILD_DATE = "Thu_Apr_04_15:09:24_PDT_2013";
   public static final boolean TRACE = false;

   T4C8TTIBlob(T4CConnection var1) {
      super(var1);
   }

   Datum createTemporaryLob(Connection var1, boolean var2, int var3) throws SQLException, IOException {
      if (var3 == 12) {
         SQLException var5 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 158);
         var5.fillInStackTrace();
         throw var5;
      } else {
         BLOB var4 = null;
         this.initializeLobdef();
         this.lobops = 272L;
         this.sourceLobLocator = new byte[40];
         this.sourceLobLocator[1] = 84;
         this.characterSet = 1;
         this.destinationOffset = 113L;
         this.destinationLength = var3;
         this.lobamt = (long)var3;
         this.sendLobamt = true;
         this.nullO2U = true;
         if (this.connection.versionNumber >= 9000) {
            this.lobscn = new int[1];
            this.lobscn[0] = var2 ? 1 : 0;
            this.lobscnl = 1;
         }

         this.doRPC();
         if (this.sourceLobLocator != null) {
            var4 = new BLOB((oracle.jdbc.OracleConnection)var1, this.sourceLobLocator);
         }

         return var4;
      }
   }

   boolean open(byte[] var1, int var2) throws SQLException, IOException {
      boolean var3 = false;
      byte var4 = 2;
      if (var2 == 0) {
         var4 = 1;
      }

      var3 = this._open(var1, var4, 32768);
      return var3;
   }

   boolean close(byte[] var1) throws SQLException, IOException {
      boolean var2 = false;
      var2 = this._close(var1, 65536);
      return var2;
   }

   boolean isOpen(byte[] var1) throws SQLException, IOException {
      boolean var2 = false;
      var2 = this._isOpen(var1, 69632);
      return var2;
   }
}
