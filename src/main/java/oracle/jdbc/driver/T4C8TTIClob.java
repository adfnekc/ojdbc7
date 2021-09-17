package oracle.jdbc.driver;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import oracle.sql.CLOB;
import oracle.sql.CharacterSet;
import oracle.sql.Datum;
import oracle.sql.NCLOB;

final class T4C8TTIClob extends T4C8TTILob {
   int[] nBytes = new int[1];
   private static final String _Copyright_2007_Oracle_All_Rights_Reserved_ = null;
   public static final String BUILD_DATE = "Thu_Apr_04_15:09:24_PDT_2013";
   public static final boolean TRACE = false;

   T4C8TTIClob(T4CConnection var1) {
      super(var1);
   }

   long read(byte[] var1, long var2, long var4, boolean var6, char[] var7, int var8) throws SQLException, IOException {
      long var9 = 0L;
      boolean var13 = false;
      byte[] var14 = null;

      long var11;
      try {
         this.initializeLobdef();
         if ((var1[6] & 128) == 128) {
            var13 = true;
         }

         boolean var15 = false;
         int var21;
         if (var13) {
            var21 = (int)var4 * 2;
         } else {
            var21 = (int)var4 * 3;
         }

         var14 = this.connection.getByteBuffer(var21);
         if ((var1[7] & 64) > 0) {
            this.littleEndianClob = true;
         }

         this.lobops = 2L;
         this.sourceLobLocator = var1;
         this.sourceOffset = var2;
         this.lobamt = var4;
         this.sendLobamt = true;
         this.outBuffer = var14;
         this.doRPC();
         var11 = this.lobamt;
         long var16 = 0L;
         if (var13) {
            if (this.connection.versionNumber < 10101) {
               DBConversion var10000 = this.meg.conv;
               DBConversion.ucs2BytesToJavaChars(this.outBuffer, (int)this.lobBytesRead, var7);
            } else if (this.littleEndianClob) {
               CharacterSet.convertAL16UTF16LEBytesToJavaChars(this.outBuffer, 0, var7, var8, (int)this.lobBytesRead, true);
            } else {
               CharacterSet.convertAL16UTF16BytesToJavaChars(this.outBuffer, 0, var7, var8, (int)this.lobBytesRead, true);
            }
         } else if (!var6) {
            this.nBytes[0] = (int)this.lobBytesRead;
            this.meg.conv.CHARBytesToJavaChars(this.outBuffer, 0, var7, var8, this.nBytes, var7.length);
         } else {
            this.nBytes[0] = (int)this.lobBytesRead;
            this.meg.conv.NCHARBytesToJavaChars(this.outBuffer, 0, var7, var8, this.nBytes, var7.length);
         }
      } finally {
         this.outBuffer = null;
         this.connection.cacheBuffer(var14);
      }

      return var11;
   }

   long write(byte[] var1, long var2, boolean var4, char[] var5, long var6, long var8) throws SQLException, IOException {
      boolean var10 = false;
      if ((var1[6] & 128) == 128) {
         var10 = true;
      }

      if ((var1[7] & 64) == 64) {
         this.littleEndianClob = true;
      }

      long var11 = 0L;
      Object var13 = null;
      byte[] var16;
      if (var10) {
         var16 = new byte[(int)var8 * 2];
         if (this.connection.versionNumber < 10101) {
            DBConversion var10000 = this.meg.conv;
            DBConversion.javaCharsToUcs2Bytes(var5, (int)var6, var16, 0, (int)var8);
         } else if (this.littleEndianClob) {
            CharacterSet.convertJavaCharsToAL16UTF16LEBytes(var5, (int)var6, var16, 0, (int)var8);
         } else {
            CharacterSet.convertJavaCharsToAL16UTF16Bytes(var5, (int)var6, var16, 0, (int)var8);
         }
      } else {
         var16 = new byte[(int)var8 * 3];
         if (!var4) {
            var11 = (long)this.meg.conv.javaCharsToCHARBytes(var5, (int)var6, var16, 0, (int)var8);
         } else {
            var11 = (long)this.meg.conv.javaCharsToNCHARBytes(var5, (int)var6, var16, 0, (int)var8);
         }
      }

      this.initializeLobdef();
      this.lobops = 64L;
      this.sourceLobLocator = var1;
      this.sourceOffset = var2;
      this.lobamt = var8;
      this.sendLobamt = true;
      this.inBuffer = var16;
      this.inBufferOffset = 0L;
      if (var10) {
         if (this.connection.versionNumber < 10101) {
            this.inBufferNumBytes = var8;
         } else {
            this.inBufferNumBytes = var8 * 2L;
         }
      } else {
         this.inBufferNumBytes = var11;
      }

      this.doRPC();
      long var14 = this.lobamt;
      return var14;
   }

   Datum createTemporaryLob(Connection var1, boolean var2, int var3) throws SQLException, IOException {
      return this.createTemporaryLob(var1, var2, var3, (short)1);
   }

   Datum createTemporaryLob(Connection var1, boolean var2, int var3, short var4) throws SQLException, IOException {
      if (var3 == 12) {
         SQLException var6 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 158);
         var6.fillInStackTrace();
         throw var6;
      } else {
         Object var5 = null;
         this.initializeLobdef();
         this.lobops = 272L;
         this.sourceLobLocator = new byte[40];
         this.sourceLobLocator[1] = 84;
         if (var4 == 1) {
            this.sourceOffset = 1L;
         } else {
            this.sourceOffset = 2L;
         }

         this.destinationOffset = 112L;
         this.destinationLength = var3;
         this.lobamt = (long)var3;
         this.sendLobamt = true;
         this.nullO2U = true;
         this.characterSet = var4 == 2 ? this.meg.conv.getNCharSetId() : this.meg.conv.getServerCharSetId();
         if (this.connection.versionNumber >= 9000) {
            this.lobscn = new int[1];
            this.lobscn[0] = var2 ? 1 : 0;
            this.lobscnl = 1;
         }

         this.doRPC();
         if (this.sourceLobLocator != null) {
            if (var4 == 1) {
               var5 = new CLOB((oracle.jdbc.OracleConnection)var1, this.sourceLobLocator);
            } else {
               var5 = new NCLOB((oracle.jdbc.OracleConnection)var1, this.sourceLobLocator);
            }
         }

         return (Datum)var5;
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
