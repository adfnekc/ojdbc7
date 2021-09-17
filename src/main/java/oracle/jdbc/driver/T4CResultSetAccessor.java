package oracle.jdbc.driver;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

class T4CResultSetAccessor extends ResultSetAccessor {
   T4CMAREngine mare;
   OracleStatement[] newstmt = null;
   byte[] empty = new byte[]{0};
   boolean underlyingLongRaw = false;
   private static final String _Copyright_2007_Oracle_All_Rights_Reserved_ = null;
   public static final String BUILD_DATE = "Thu_Apr_04_15:09:24_PDT_2013";
   public static final boolean TRACE = false;

   T4CResultSetAccessor(OracleStatement var1, int var2, short var3, int var4, boolean var5, T4CMAREngine var6) throws SQLException {
      super(var1, var2, var3, var4, var5);
      this.mare = var6;
   }

   T4CResultSetAccessor(OracleStatement var1, int var2, boolean var3, int var4, int var5, int var6, int var7, int var8, short var9, int var10, int var11, T4CMAREngine var12) throws SQLException {
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

   void setCapacity(int var1) {
      super.setCapacity(var1);
      if (this.newstmt == null || this.newstmt.length < var1) {
         OracleStatement[] var2 = new OracleStatement[var1];
         if (this.newstmt != null) {
            System.arraycopy(this.newstmt, 0, var2, 0, this.newstmt.length);
         }

         this.newstmt = var2;
      }

   }

   Accessor copyForDefine(OracleStatement var1) {
      T4CResultSetAccessor var2 = (T4CResultSetAccessor)super.copyForDefine(var1);
      var2.newstmt = null;
      return var2;
   }

   protected void copyFromInternal(Accessor var1, int var2, int var3) throws SQLException {
      super.copyFromInternal(var1, var2, var3);
      this.newstmt[var3] = ((T4CResultSetAccessor)var1).newstmt[var2];
   }

   void deleteRow(int var1) throws SQLException {
      super.deleteRow(var1);
      if (this.newstmt[var1] != null) {
         this.newstmt[var1].close();
      }

      this.delete(this.newstmt, var1);
   }

   boolean unmarshalBytes() throws SQLException, IOException {
      this.newstmt[this.lastRowProcessed] = this.statement.connection.RefCursorBytesToStatement(this.empty, this.statement);
      this.newstmt[this.lastRowProcessed].needToSendOalToFetch = true;
      T4CTTIdcb var1 = new T4CTTIdcb((T4CConnection)this.statement.connection);
      var1.init(this.newstmt[this.lastRowProcessed], 0);
      this.newstmt[this.lastRowProcessed].accessors = var1.receiveFromRefCursor(this.newstmt[this.lastRowProcessed].accessors);
      this.newstmt[this.lastRowProcessed].numberOfDefinePositions = this.newstmt[this.lastRowProcessed].accessors.length;
      this.newstmt[this.lastRowProcessed].describedWithNames = true;
      this.newstmt[this.lastRowProcessed].described = true;
      int var2 = (int)this.mare.unmarshalUB4();
      this.newstmt[this.lastRowProcessed].setCursorId(var2);
      if (var2 > 0) {
         this.rowData.putShort((short)var2);
         this.setLength(this.lastRowProcessed, 2);
         this.processIndicator(2);
      } else {
         this.newstmt[this.lastRowProcessed].close();
         this.newstmt[this.lastRowProcessed] = null;
         this.setNull(this.lastRowProcessed, true);
         this.processIndicator(0);
      }

      return false;
   }

   ResultSet getCursor(int var1) throws SQLException {
      OracleResultSet var2 = null;
      if (this.newstmt[var1] != null) {
         for(int var3 = 0; var3 < this.newstmt[var1].numberOfDefinePositions; ++var3) {
            this.newstmt[var1].accessors[var3].initMetadata();
         }

         this.newstmt[var1].prepareAccessors();
         this.newstmt[var1].setPrefetchInternal(this.statement.getFetchSize(), false, false);
         this.newstmt[var1].closeOnCompletion();
         OracleResultSet var4 = OracleResultSet.createResultSet(this.newstmt[var1]);
         this.newstmt[var1].currentResultSet = var4;
         var2 = var4;
      }

      return var2;
   }
}
