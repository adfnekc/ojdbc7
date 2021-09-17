package oracle.jdbc.driver;

import java.io.IOException;
import java.sql.SQLException;
import oracle.sql.BLOB;

class T4CBlobAccessor extends BlobAccessor {
   T4CMAREngine mare;
   final int[] meta = new int[1];
   private static final String _Copyright_2007_Oracle_All_Rights_Reserved_ = null;
   public static final String BUILD_DATE = "Thu_Apr_04_15:09:24_PDT_2013";
   public static final boolean TRACE = false;

   T4CBlobAccessor(OracleStatement var1, int var2, short var3, int var4, boolean var5, T4CMAREngine var6) throws SQLException {
      super(var1, 4000, var3, var4, var5);
      this.mare = var6;
   }

   T4CBlobAccessor(OracleStatement var1, int var2, boolean var3, int var4, int var5, int var6, int var7, int var8, short var9, int var10, int var11, T4CMAREngine var12) throws SQLException {
      super(var1, 4000, var3, var4, var5, var6, var7, var8, var9);
      this.mare = var12;
      this.definedColumnType = var10;
      this.definedColumnSize = var11;
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
      boolean var1 = false;
      if (!this.isUseless()) {
         if (this.isUnexpected()) {
            long var2 = this.rowData.getPosition();
            this.unmarshalColumnMetadata();
            this.unmarshalBytes();
            this.rowData.setPosition(var2);
            this.setNull(this.lastRowProcessed, true);
         } else if (this.isNullByDescribe()) {
            this.setNull(this.lastRowProcessed, true);
            this.unmarshalColumnMetadata();
            if (this.statement.connection.versionNumber < 9200) {
               this.processIndicator(0);
            }
         } else {
            this.unmarshalColumnMetadata();
            var1 = this.unmarshalBytes();
         }
      }

      this.previousRowProcessed = this.lastRowProcessed++;
      return var1;
   }

   void copyRow() throws SQLException, IOException {
      throw new NoSuchMethodError("oracle.jdbc.driver.T4C_lobAccessor.copyRow");
   }

   byte[] getBytes(int var1) throws SQLException {
      if (this.isNull(var1)) {
         return null;
      } else if (this.isPrefetched()) {
         if (this.getPrefetchedLength(var1) > 2147483647L) {
            SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 151);
            var3.fillInStackTrace();
            throw var3;
         } else if ((long)this.getPrefetchedDataLength(var1) == this.getPrefetchedLength(var1)) {
            return this.getPrefetchedData(var1);
         } else {
            assert (long)this.getPrefetchedDataLength(var1) <= this.getPrefetchedLength(var1) : " prefetchDataLength=" + this.getPrefetchedDataLength(var1) + " > length=" + this.getPrefetchedLength(var1);

            BLOB var2 = this.getBLOB(var1);
            return var2 == null ? null : var2.getBytes(1L, (int)this.getPrefetchedLength(var1));
         }
      } else {
         return super.getBytes(var1);
      }
   }

   boolean unmarshalBytes() throws IOException, SQLException {
      int var1 = (int)this.mare.unmarshalUB4();
      if (var1 == 0) {
         this.setNull(this.lastRowProcessed, true);
         this.processIndicator(0);
      } else {
         if (this.isPrefetched()) {
            this.unmarshalPrefetchData();
         }

         this.setOffset(this.lastRowProcessed);
         int var2 = ((DynamicByteArray)this.rowData).unmarshalCLR(this.mare);
         this.setNull(this.lastRowProcessed, var2 == 0);
         this.setLength(this.lastRowProcessed, var2);
         this.processIndicator(var2);
      }

      return false;
   }

   void unmarshalPrefetchData() throws SQLException, IOException {
      this.setPrefetchedLength(this.lastRowProcessed, this.mare.unmarshalSB8());
      this.setPrefetchedChunkSize(this.lastRowProcessed, (int)this.mare.unmarshalUB4());
      this.setPrefetchedDataOffset(this.lastRowProcessed);
      if (this.getPrefetchLength() > 0) {
         this.setPrefetchedDataLength(this.lastRowProcessed, ((DynamicByteArray)this.rowData).unmarshalCLR(this.mare));
      } else {
         this.setPrefetchedDataLength(this.lastRowProcessed, 0);
      }

   }

   Object getObject(int var1) throws SQLException {
      if (this.definedColumnType == 0) {
         return super.getObject(var1);
      } else if (this.isNull(var1)) {
         return null;
      } else if (this.definedColumnType == 2004) {
         return this.getBLOB(var1);
      } else {
         SQLException var2 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 4);
         var2.fillInStackTrace();
         throw var2;
      }
   }
}
