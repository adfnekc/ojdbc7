package oracle.jdbc.driver;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import oracle.sql.Datum;

abstract class T4C8TTILob extends T4CTTIfun {
   static final int KPLOB_READ = 2;
   static final int KPLOB_WRITE = 64;
   static final int KPLOB_WRITE_APPEND = 8192;
   static final int KPLOB_PAGE_SIZE = 16384;
   static final int KPLOB_FILE_OPEN = 256;
   static final int KPLOB_FILE_ISOPEN = 1024;
   static final int KPLOB_FILE_EXISTS = 2048;
   static final int KPLOB_FILE_CLOSE = 512;
   static final int KPLOB_OPEN = 32768;
   static final int KPLOB_CLOSE = 65536;
   static final int KPLOB_ISOPEN = 69632;
   static final int KPLOB_TMP_CREATE = 272;
   static final int KPLOB_TMP_FREE = 273;
   static final int KPLOB_GET_LEN = 1;
   static final int KPLOB_TRIM = 32;
   static final int KOKL_ORDONLY = 1;
   static final int KOKL_ORDWR = 2;
   static final int KOLF_ORDONLY = 11;
   static final int DTYCLOB = 112;
   static final int DTYBLOB = 113;
   byte[] sourceLobLocator = null;
   byte[] destinationLobLocator = null;
   long sourceOffset = 0L;
   long destinationOffset = 0L;
   int destinationLength = 0;
   short characterSet = 0;
   long lobamt = 0L;
   boolean lobnull = false;
   long lobops = 0L;
   int[] lobscn = null;
   int lobscnl = 0;
   boolean nullO2U = false;
   boolean sendLobamt = false;
   byte[] inBuffer = null;
   long inBufferOffset;
   long inBufferNumBytes;
   byte[] outBuffer = null;
   int offsetInOutBuffer = 0;
   int rowsProcessed = 0;
   long lobBytesRead = 0L;
   boolean littleEndianClob = false;
   T4C8TTILobd lobd = null;
   private static final String _Copyright_2007_Oracle_All_Rights_Reserved_ = null;
   public static final String BUILD_DATE = "Thu_Apr_04_15:09:24_PDT_2013";
   public static final boolean TRACE = false;

   T4C8TTILob(T4CConnection var1) {
      super(var1, (byte)3);
      this.setFunCode((short)96);
      this.lobd = new T4C8TTILobd(var1);
   }

   long read(byte[] var1, long var2, long var4, byte[] var6, int var7) throws SQLException, IOException {
      this.initializeLobdef();
      this.lobops = 2L;
      this.sourceLobLocator = var1;
      this.sourceOffset = var2;
      this.lobamt = var4;
      this.sendLobamt = true;
      this.outBuffer = var6;
      this.offsetInOutBuffer = var7;
      this.doRPC();
      return this.lobBytesRead;
   }

   long write(byte[] var1, long var2, byte[] var4, long var5, long var7) throws SQLException, IOException {
      long var9 = 0L;
      this.initializeLobdef();
      this.lobops = 64L;
      this.sourceLobLocator = var1;
      this.sourceOffset = var2;
      this.lobamt = var7;
      this.sendLobamt = true;
      this.inBuffer = var4;
      this.inBufferOffset = var5;
      this.inBufferNumBytes = var7;
      this.doRPC();
      var9 = this.lobamt;
      return var9;
   }

   long getLength(byte[] var1) throws SQLException, IOException {
      long var2 = 0L;
      this.initializeLobdef();
      this.lobops = 1L;
      this.sourceLobLocator = var1;
      this.sendLobamt = true;
      this.doRPC();
      var2 = this.lobamt;
      return var2;
   }

   long getChunkSize(byte[] var1) throws SQLException, IOException {
      long var2 = 0L;
      this.initializeLobdef();
      this.lobops = 16384L;
      this.sourceLobLocator = var1;
      this.sendLobamt = true;
      this.doRPC();
      var2 = this.lobamt;
      return var2;
   }

   long trim(byte[] var1, long var2) throws SQLException, IOException {
      long var4 = 0L;
      this.initializeLobdef();
      this.lobops = 32L;
      this.sourceLobLocator = var1;
      this.lobamt = var2;
      this.sendLobamt = true;
      this.doRPC();
      var4 = this.lobamt;
      return var4;
   }

   abstract Datum createTemporaryLob(Connection var1, boolean var2, int var3) throws SQLException, IOException;

   void freeTemporaryLob(byte[] var1) throws SQLException, IOException {
      this.initializeLobdef();
      this.lobops = 273L;
      this.sourceLobLocator = var1;
      this.doRPC();
   }

   abstract boolean open(byte[] var1, int var2) throws SQLException, IOException;

   boolean _open(byte[] var1, int var2, int var3) throws SQLException, IOException {
      boolean var4 = false;
      if ((var1[7] & 1) != 1 && (var1[4] & 64) != 64) {
         this.initializeLobdef();
         this.sourceLobLocator = var1;
         this.lobops = (long)var3;
         this.lobamt = (long)var2;
         this.sendLobamt = true;
         this.doRPC();
         if (this.lobamt != 0L) {
            var4 = true;
         }
      } else {
         if ((var1[7] & 8) == 8) {
            SQLException var5 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 445);
            var5.fillInStackTrace();
            throw var5;
         }

         var1[7] = (byte)(var1[7] | 8);
         if (var2 == 2) {
            var1[7] = (byte)(var1[7] | 16);
         }

         var4 = true;
      }

      return var4;
   }

   abstract boolean close(byte[] var1) throws SQLException, IOException;

   boolean _close(byte[] var1, int var2) throws SQLException, IOException {
      boolean var3 = true;
      if ((var1[7] & 1) != 1 && (var1[4] & 64) != 64) {
         this.initializeLobdef();
         this.sourceLobLocator = var1;
         this.lobops = (long)var2;
         this.doRPC();
      } else {
         if ((var1[7] & 8) != 8) {
            SQLException var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 446);
            var4.fillInStackTrace();
            throw var4;
         }

         var1[7] &= -25;
      }

      return var3;
   }

   abstract boolean isOpen(byte[] var1) throws SQLException, IOException;

   boolean _isOpen(byte[] var1, int var2) throws SQLException, IOException {
      boolean var3 = false;
      if ((var1[7] & 1) != 1 && (var1[4] & 64) != 64) {
         this.initializeLobdef();
         this.sourceLobLocator = var1;
         this.lobops = (long)var2;
         this.nullO2U = true;
         this.doRPC();
         var3 = this.lobnull;
      } else if ((var1[7] & 8) == 8) {
         var3 = true;
      }

      return var3;
   }

   void initializeLobdef() {
      this.sourceLobLocator = null;
      this.destinationLobLocator = null;
      this.sourceOffset = 0L;
      this.destinationOffset = 0L;
      this.destinationLength = 0;
      this.characterSet = 0;
      this.lobamt = 0L;
      this.lobnull = false;
      this.lobops = 0L;
      this.lobscn = null;
      this.lobscnl = 0;
      this.inBuffer = null;
      this.outBuffer = null;
      this.nullO2U = false;
      this.sendLobamt = false;
      this.littleEndianClob = false;
      this.lobBytesRead = 0L;
   }

   void marshal() throws IOException {
      int var1 = 0;
      if (this.sourceLobLocator != null) {
         var1 = this.sourceLobLocator.length;
         this.meg.marshalPTR();
      } else {
         this.meg.marshalNULLPTR();
      }

      this.meg.marshalSB4(var1);
      if (this.destinationLobLocator != null) {
         this.destinationLength = this.destinationLobLocator.length;
         this.meg.marshalPTR();
      } else {
         this.meg.marshalNULLPTR();
      }

      this.meg.marshalSB4(this.destinationLength);
      if (this.connection.getTTCVersion() >= 3) {
         this.meg.marshalUB4(0L);
      } else {
         this.meg.marshalUB4(this.sourceOffset);
      }

      if (this.connection.getTTCVersion() >= 3) {
         this.meg.marshalUB4(0L);
      } else {
         this.meg.marshalUB4(this.destinationOffset);
      }

      if (this.characterSet != 0) {
         this.meg.marshalPTR();
      } else {
         this.meg.marshalNULLPTR();
      }

      if (this.sendLobamt && this.connection.getTTCVersion() < 3) {
         this.meg.marshalPTR();
      } else {
         this.meg.marshalNULLPTR();
      }

      if (this.nullO2U) {
         this.meg.marshalPTR();
      } else {
         this.meg.marshalNULLPTR();
      }

      this.meg.marshalUB4(this.lobops);
      if (this.lobscnl != 0) {
         this.meg.marshalPTR();
      } else {
         this.meg.marshalNULLPTR();
      }

      this.meg.marshalSB4(this.lobscnl);
      if (this.connection.getTTCVersion() >= 3) {
         this.meg.marshalSB8(this.sourceOffset);
         this.meg.marshalSB8(this.destinationOffset);
         if (this.sendLobamt) {
            this.meg.marshalPTR();
         } else {
            this.meg.marshalNULLPTR();
         }

         if (this.connection.getTTCVersion() >= 4) {
            this.meg.marshalNULLPTR();
            this.meg.marshalSWORD(0);
            this.meg.marshalNULLPTR();
            this.meg.marshalSWORD(0);
            this.meg.marshalNULLPTR();
            this.meg.marshalSWORD(0);
         }
      }

      if (this.sourceLobLocator != null) {
         this.meg.marshalB1Array(this.sourceLobLocator);
      }

      if (this.destinationLobLocator != null) {
         this.meg.marshalB1Array(this.destinationLobLocator);
      }

      if (this.characterSet != 0) {
         this.meg.marshalUB2(this.characterSet);
      }

      if (this.sendLobamt && this.connection.getTTCVersion() < 3) {
         this.meg.marshalUB4(this.lobamt);
      }

      if (this.lobscnl != 0) {
         for(int var2 = 0; var2 < this.lobscnl; ++var2) {
            this.meg.marshalUB4((long)this.lobscn[var2]);
         }
      }

      if (this.sendLobamt && this.connection.getTTCVersion() >= 3) {
         this.meg.marshalSB8(this.lobamt);
      }

      if (this.lobops == 64L) {
         this.marshalData();
      }

   }

   void marshalData() throws IOException {
      boolean var1 = this.connection.isZeroCopyIOEnabled() & (this.sourceLobLocator[7] & -128) != 0;
      boolean var2 = false;
      if ((this.sourceLobLocator[6] & 128) == 128) {
         var2 = true;
      }

      if (this.connection.versionNumber < 10101 && var2) {
         this.lobd.marshalClobUB2_For9iDB(this.inBuffer, this.inBufferOffset, this.inBufferNumBytes);
      } else {
         this.lobd.marshalLobData(this.inBuffer, this.inBufferOffset, this.inBufferNumBytes, var1);
      }

   }

   void readLOBD() throws IOException, SQLException {
      boolean var1 = this.connection.isZeroCopyIOEnabled() & (this.sourceLobLocator[7] & -128) != 0;
      boolean var2 = false;
      if ((this.sourceLobLocator[6] & 128) == 128) {
         var2 = true;
      }

      if (this.connection.versionNumber < 10101 && var2) {
         this.lobBytesRead = this.lobd.unmarshalClobUB2_For9iDB(this.outBuffer, this.offsetInOutBuffer);
      } else {
         this.lobBytesRead = this.lobd.unmarshalLobData(this.outBuffer, this.offsetInOutBuffer, var1);
      }

   }

   void processError() throws SQLException {
      this.rowsProcessed = this.oer.getCurRowNumber();
      if (this.oer.getRetCode() != 1403) {
         this.oer.processError();
      }

   }

   void readRPA() throws SQLException, IOException {
      if (this.sourceLobLocator != null) {
         int var1 = this.sourceLobLocator.length;
         this.meg.getNBytes(this.sourceLobLocator, 0, var1);
      }

      short var2;
      if (this.destinationLobLocator != null) {
         var2 = this.meg.unmarshalSB2();
         this.destinationLobLocator = this.meg.unmarshalNBytes(var2);
      }

      if (this.characterSet != 0) {
         this.characterSet = this.meg.unmarshalSB2();
      }

      if (this.sendLobamt) {
         if (this.connection.getTTCVersion() >= 3) {
            this.lobamt = this.meg.unmarshalSB8();
         } else {
            this.lobamt = this.meg.unmarshalUB4();
         }
      }

      if (this.nullO2U) {
         var2 = (short)this.meg.unmarshalSB1();
         if (var2 != 0) {
            this.lobnull = true;
         }
      }

   }
}
