package oracle.jdbc.driver;

import java.io.IOException;
import java.sql.SQLException;

class T4CNumberAccessor extends NumberAccessor {
   T4CMAREngine mare;
   boolean underlyingLongRaw = false;
   private static final String _Copyright_2007_Oracle_All_Rights_Reserved_ = null;
   public static final String BUILD_DATE = "Thu_Apr_04_15:09:24_PDT_2013";
   public static final boolean TRACE = false;

   T4CNumberAccessor(OracleStatement var1, int var2, short var3, int var4, boolean var5, T4CMAREngine var6) throws SQLException {
      super(var1, var2, var3, var4, var5);
      this.mare = var6;
   }

   T4CNumberAccessor(OracleStatement var1, int var2, boolean var3, int var4, int var5, int var6, int var7, int var8, short var9, int var10, int var11, T4CMAREngine var12) throws SQLException {
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

   boolean unmarshalBytes() throws SQLException, IOException {
      this.setOffset(this.lastRowProcessed);
      int var1;
      if (this.statement.maxFieldSize > 0) {
         var1 = ((DynamicByteArray)this.rowData).unmarshalCLR(this.mare, this.statement.maxFieldSize);
      } else {
         var1 = ((DynamicByteArray)this.rowData).unmarshalCLR(this.mare);
      }

      this.processIndicator(var1);
      this.setLength(this.lastRowProcessed, var1);
      this.setNull(this.lastRowProcessed, var1 == 0);
      return false;
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

   Object getObject(int var1) throws SQLException {
      if (this.definedColumnType == 0) {
         return super.getObject(var1);
      } else if (this.isNull(var1)) {
         return null;
      } else {
         switch(this.definedColumnType) {
         case -15:
         case -9:
         case -1:
         case 1:
         case 12:
            return this.getString(var1);
         case -7:
         case 16:
            return this.getBoolean(var1);
         case -6:
            return this.getByte(var1);
         case -5:
            return this.getLong(var1);
         case -4:
         case -3:
         case -2:
            return this.getBytes(var1);
         case 2:
         case 3:
            return this.getBigDecimal(var1);
         case 4:
            return this.getInt(var1);
         case 5:
            return this.getShort(var1);
         case 6:
         case 8:
            return this.getDouble(var1);
         case 7:
            return this.getFloat(var1);
         case 91:
            return this.getDate(var1);
         case 92:
            return this.getTime(var1);
         case 93:
            return this.getTimestamp(var1);
         default:
            SQLException var2 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 4);
            var2.fillInStackTrace();
            throw var2;
         }
      }
   }
}
