package oracle.jdbc.driver;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import oracle.sql.CLOB;

class T4CClobAccessor extends ClobAccessor {
   T4CMAREngine mare;
   short[] prefetchedClobCharset = null;
   boolean[] prefetchedClobDBVary = null;
   final int[] meta = new int[1];
   ArrayList registeredCLOBs = new ArrayList(10);
   private static final String _Copyright_2007_Oracle_All_Rights_Reserved_ = null;
   public static final String BUILD_DATE = "Thu_Apr_04_15:09:24_PDT_2013";
   public static final boolean TRACE = false;

   T4CClobAccessor(OracleStatement var1, int var2, short var3, int var4, boolean var5, T4CMAREngine var6) throws SQLException {
      super(var1, 4000, var3, var4, var5);
      this.mare = var6;
   }

   T4CClobAccessor(OracleStatement var1, int var2, boolean var3, int var4, int var5, int var6, int var7, int var8, short var9, int var10, int var11, T4CMAREngine var12) throws SQLException {
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
      if (this.lobPrefetchSizeForThisColumn > 0) {
         boolean var1 = (byte)this.mare.unmarshalUB1() == 1;
         if (var1) {
            this.setPrefetchedDataCharset(this.lastRowProcessed, this.mare.unmarshalUB2());
         } else {
            this.setPrefetchedDataCharset(this.lastRowProcessed, 0);
         }

         this.setPrefetchedDataFormOfUse(this.lastRowProcessed, this.mare.unmarshalUB1());
         this.setPrefetchedDataOffset(this.lastRowProcessed);
         this.setPrefetchedDataLength(this.lastRowProcessed, ((DynamicByteArray)this.rowData).unmarshalCLR(this.mare));
      }

   }

   private void saveCLOBReference(int var1, CLOB var2) {
      LinkedList var3 = null;
      if (this.registeredCLOBs.size() > var1) {
         var3 = (LinkedList)this.registeredCLOBs.get(var1);
      } else {
         var3 = new LinkedList();

         while(this.registeredCLOBs.size() < var1) {
            this.registeredCLOBs.add(new LinkedList());
         }

         this.registeredCLOBs.add(var1, var3);
      }

      if (var3 == null) {
         var3 = new LinkedList();
      }

      var3.add(var2);
   }

   Object getObject(int var1) throws SQLException {
      if (this.definedColumnType == 0) {
         return super.getObject(var1);
      } else if (this.isNull(var1)) {
         return null;
      } else {
         switch(this.definedColumnType) {
         case -4:
         case -3:
         case -2:
            return this.getBytes(var1);
         case -1:
         case 1:
         case 12:
            return this.getString(var1);
         case 2005:
            return this.getCLOB(var1);
         case 2011:
            return this.getNCLOB(var1);
         default:
            SQLException var2 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 4);
            var2.fillInStackTrace();
            throw var2;
         }
      }
   }
}
