package oracle.jdbc.driver;

import java.io.IOException;
import java.sql.SQLException;

class T4CRawAccessor extends RawAccessor implements T4CAccessor {
   T4CMAREngine mare;
   boolean underlyingLongRaw = false;
   private T4CMarshaller marshaller = null;
   private static final String _Copyright_2007_Oracle_All_Rights_Reserved_ = null;
   public static final String BUILD_DATE = "Thu_Apr_04_15:09:24_PDT_2013";
   public static final boolean TRACE = false;

   T4CRawAccessor(OracleStatement var1, int var2, short var3, int var4, boolean var5, T4CMAREngine var6) throws SQLException {
      super(var1, var2, var3, var4, var5);
      this.mare = var6;
   }

   T4CRawAccessor(OracleStatement var1, int var2, boolean var3, int var4, int var5, int var6, int var7, int var8, short var9, int var10, int var11, T4CMAREngine var12) throws SQLException {
      super(var1, var2 == -1 ? var11 : var2, var3, var4, var5, var6, var7, var8, var9);
      this.mare = var12;
      if (var1 != null && var1.implicitDefineForLobPrefetchDone) {
         this.definedColumnType = 0;
         this.definedColumnSize = 0;
      } else {
         this.definedColumnType = var10;
         this.definedColumnSize = var11;
      }

      if (var2 == -1) {
         this.underlyingLongRaw = true;
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

   boolean unmarshalOneRow() throws SQLException, IOException {
      return this.getMarshaller().unmarshalOneRow(this);
   }

   int readStreamFromWire(byte[] var1, int var2, int var3, int[] var4, boolean[] var5, boolean[] var6, T4CMAREngine var7, T4CTTIoer var8) throws SQLException, IOException {
      return this.getMarshaller().readStreamFromWire(var1, var2, var3, var4, var5, var6, var7, var8);
   }

   private final T4CMarshaller getMarshaller() {
      if (this.marshaller == null) {
         this.marshaller = this.describeType == 24 ? T4CMarshaller.LONG_RAW : T4CMarshaller.RAW;
      }

      return this.marshaller;
   }

   String getString(int var1) throws SQLException {
      String var2 = super.getString(var1);
      if (var2 != null && this.definedColumnSize > 0 && var2.length() > this.definedColumnSize * 2) {
         var2 = var2.substring(0, this.definedColumnSize * 2);
      }

      return var2;
   }

   Object getObject(int var1) throws SQLException {
      if (this.definedColumnType == 0) {
         return super.getObject(var1);
      } else if (this.isNull(var1)) {
         return null;
      } else {
         switch(this.definedColumnType) {
         case -16:
         case -15:
         case -9:
         case -1:
         case 1:
         case 12:
            return this.getString(var1);
         case -14:
         case -13:
         case -12:
         case -11:
         case -10:
         case -8:
         case -7:
         case -6:
         case -5:
         case -3:
         case 0:
         case 2:
         case 3:
         case 4:
         case 5:
         case 6:
         case 7:
         case 8:
         case 9:
         case 10:
         case 11:
         default:
            SQLException var2 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 4);
            var2.fillInStackTrace();
            throw var2;
         case -4:
         case -2:
            return this.getRAW(var1);
         }
      }
   }
}
