package oracle.jdbc.driver;

import java.io.IOException;
import java.sql.SQLException;

class T4CLongRawAccessor extends LongRawAccessor implements T4CAccessor {
   T4CMAREngine mare;
   byte[][] data = (byte[][])null;
   int[] nbBytesRead = null;
   int[] bytesReadSoFar = null;
   private T4CMarshaller marshaller = null;
   private static final String _Copyright_2007_Oracle_All_Rights_Reserved_ = null;
   public static final String BUILD_DATE = "Thu_Apr_04_15:09:24_PDT_2013";
   public static final boolean TRACE = false;

   T4CLongRawAccessor(OracleStatement var1, int var2, int var3, short var4, int var5, T4CMAREngine var6) throws SQLException {
      super(var1, var2, var3, var4, var5);
      this.mare = var6;
      if (var1.isFetchStreams) {
         this.data = new byte[var1.rowPrefetch][];

         for(int var7 = 0; var7 < var1.rowPrefetch; ++var7) {
            this.data[var7] = new byte[4080];
         }

         this.nbBytesRead = new int[var1.rowPrefetch];
         this.bytesReadSoFar = new int[var1.rowPrefetch];
      }

   }

   T4CLongRawAccessor(OracleStatement var1, int var2, int var3, boolean var4, int var5, int var6, int var7, int var8, int var9, short var10, int var11, int var12, T4CMAREngine var13) throws SQLException {
      super(var1, var2, var3, var4, var5, var6, var7, var8, var9, var10);
      this.mare = var13;
      if (var1 != null && var1.implicitDefineForLobPrefetchDone) {
         this.definedColumnType = 0;
         this.definedColumnSize = 0;
      } else {
         this.definedColumnType = var11;
         this.definedColumnSize = var12;
      }

      if (var1.isFetchStreams) {
         this.data = new byte[var1.rowPrefetch][];

         for(int var14 = 0; var14 < var1.rowPrefetch; ++var14) {
            this.data[var14] = new byte[4080];
         }

         this.nbBytesRead = new int[var1.rowPrefetch];
         this.bytesReadSoFar = new int[var1.rowPrefetch];
      }

   }

   public T4CMAREngine getMAREngine() {
      return this.mare;
   }

   public void unmarshalColumnMetadata() throws SQLException, IOException {
      if (this.statement.statementType != 2 && !this.statement.sqlKind.isPlsqlOrCall() && this.securityAttribute == oracle.jdbc.OracleResultSetMetaData.SecurityAttribute.ENABLED) {
         this.setRowMetadata(this.lastRowProcessed, (byte)this.mare.unmarshalUB1());
      }

   }

   public void processIndicator(int var1) throws IOException, SQLException {
      if ((this.internalType != 1 || this.describeType != 112) && (this.internalType != 23 || this.describeType != 113)) {
         if (this.statement.connection.versionNumber < 9200) {
            this.mare.unmarshalSB2();
            if (!this.statement.sqlKind.isPlsqlOrCall()) {
               this.mare.unmarshalSB2();
            }
         } else if (this.statement.sqlKind.isPlsqlOrCall() || this.isDMLReturnedParam) {
            this.mare.processIndicator(var1 <= 0, var1);
         }
      } else {
         this.mare.unmarshalUB2();
         this.mare.unmarshalUB2();
      }

   }

   int getPreviousRowProcessed() {
      if (this.previousRowProcessed == -1) {
         this.previousRowProcessed = this.statement.rowPrefetchInLastFetch - 1;
      }

      return this.previousRowProcessed;
   }

   boolean unmarshalOneRow() throws SQLException, IOException {
      return this.getMarshaller().unmarshalOneRow(this);
   }

   int readStreamFromWire(byte[] var1, int var2, int var3, int[] var4, boolean[] var5, boolean[] var6, T4CMAREngine var7, T4CTTIoer var8) throws SQLException, IOException {
      return this.getMarshaller().readStreamFromWire(var1, var2, var3, var4, var5, var6, var7, var8);
   }

   void fetchNextColumns() throws SQLException {
      this.statement.continueReadRow(this.columnPosition);
   }

   int readStream(byte[] var1, int var2) throws SQLException, IOException {
      int var3 = this.lastRowProcessed;
      int var4;
      if (this.statement.isFetchStreams) {
         var4 = this.getLength(var3);
         int var7 = this.bytesReadSoFar[var3];
         if (var7 == var4) {
            return -1;
         } else {
            boolean var6 = false;
            int var9;
            if (var2 <= var4 - var7) {
               var9 = var2;
            } else {
               var9 = var4 - var7;
            }

            this.rowData.setPosition(this.getOffset(var3) + (long)var7);
            this.rowData.getBytes(var1, 0, var9);
            int[] var8 = this.bytesReadSoFar;
            var8[var3] += var9;
            return var9;
         }
      } else {
         var4 = this.readStreamFromWire(var1, 0, var2, this.escapeSequenceArr, this.readHeaderArr, this.readAsNonStreamArr, this.mare, ((T4CConnection)this.statement.connection).oer);
         if (this.statement.connection.checksumMode.needToCalculateFetchChecksum() && var4 != -1) {
            CRC64 var10000 = PhysicalConnection.CHECKSUM;
            long var5 = CRC64.updateChecksum(this.statement.checkSum, (byte[])var1, 0, var4);
            this.statement.checkSum = var5;
         }

         return var4;
      }
   }

   void copyRow() throws SQLException, IOException {
      if (this.isNullByDescribe) {
         this.setNull(this.lastRowProcessed, true);
      } else if (this.lastRowProcessed == 0) {
         if (this.previousRowProcessed == -1) {
            this.previousRowProcessed = this.statement.rowPrefetchInLastFetch - 1;
         }

         long var1 = this.getOffset(this.previousRowProcessed);
         this.setNull(this.lastRowProcessed, this.isNull(this.previousRowProcessed));
         this.rowMetadata[this.lastRowProcessed] = this.rowMetadata[this.previousRowProcessed];
         if (!this.isNull(this.previousRowProcessed)) {
            this.setOffset(this.lastRowProcessed);
            ((DynamicByteArray)this.rowData).copyLeft(var1, this.getLength(this.previousRowProcessed));
            this.setLength(this.lastRowProcessed, this.getLength(this.previousRowProcessed));
         }
      } else {
         this.setNull(this.lastRowProcessed, this.isNull(this.previousRowProcessed));
         this.rowMetadata[this.lastRowProcessed] = this.rowMetadata[this.previousRowProcessed];
         this.setOffset(this.lastRowProcessed, this.getOffset(this.previousRowProcessed));
         this.setLength(this.lastRowProcessed, this.getLength(this.previousRowProcessed));
      }

      this.previousRowProcessed = this.lastRowProcessed++;
   }

   private final T4CMarshaller getMarshaller() {
      if (this.marshaller == null) {
         this.marshaller = this.describeType == 23 ? T4CMarshaller.RAW : T4CMarshaller.LONG_RAW;
      }

      return this.marshaller;
   }

   boolean isNullByDescribe() {
      return false;
   }

   String getString(int var1) throws SQLException {
      String var2 = super.getString(var1);
      if (var2 != null && this.definedColumnSize > 0 && var2.length() > this.definedColumnSize * 2) {
         var2 = var2.substring(0, this.definedColumnSize * 2);
      }

      return var2;
   }

   long updateChecksum(long var1, int var3) throws SQLException {
      if (this.isNull(var3)) {
         CRC64 var10000 = PhysicalConnection.CHECKSUM;
         var1 = CRC64.updateChecksum(var1, (byte[])NULL_DATA_BYTES, 0, NULL_DATA_BYTES.length);
      }

      return var1;
   }
}
