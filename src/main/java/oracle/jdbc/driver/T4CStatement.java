package oracle.jdbc.driver;

import java.io.IOException;
import java.sql.SQLException;
import oracle.jdbc.oracore.OracleTypeADT;

class T4CStatement extends OracleStatement {
   static final byte[][][] parameterDatum = (byte[][][])null;
   static final OracleTypeADT[][] parameterOtype = (OracleTypeADT[][])null;
   static final byte[] EMPTY_BYTE = new byte[0];
   T4CConnection t4Connection;
   private static final String _Copyright_2007_Oracle_All_Rights_Reserved_ = null;
   public static final String BUILD_DATE = "Thu_Apr_04_15:09:24_PDT_2013";
   public static final boolean TRACE = false;

   void doOall8(boolean var1, boolean var2, boolean var3, boolean var4, boolean var5) throws SQLException, IOException {
      this.doOall8(var1, var2, var3, var4, var5, 0);
   }

   void doOall8(boolean var1, boolean var2, boolean var3, boolean var4, boolean var5, int var6) throws SQLException, IOException {
      if (var1 || var4 || !var2) {
         this.oacdefSent = null;
      }

      this.t4Connection.assertLoggedOn("oracle.jdbc.driver.T4CStatement.doOall8");
      if (this.sqlKind == oracle.jdbc.internal.OracleStatement.SqlKind.UNINITIALIZED) {
         SQLException var16 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 439, "sqlKind = " + this.sqlKind);
         var16.fillInStackTrace();
         throw var16;
      } else {
         int var7 = this.rowPrefetch;
         if (var3) {
            if (this.maxRows > 0 && this.maxRows <= this.indexOfFirstRow + this.storedRowCount + this.rowPrefetch) {
               var7 = this.maxRows - (this.indexOfFirstRow + this.storedRowCount);
               this.isComplete = true;
            }

            this.rowPrefetchInLastFetch = var7;
            if (var7 == 0 && this.isComplete) {
               return;
            }
         }

         int var8 = this.numberOfDefinePositions;
         if (this.sqlKind.isDML()) {
            var8 = 0;
         }

         int var9;
         if (this.accessors != null) {
            for(var9 = 0; var9 < this.accessors.length; ++var9) {
               if (this.accessors[var9] != null) {
                  this.accessors[var9].lastRowProcessed = var6;
               }
            }
         }

         if (this.outBindAccessors != null) {
            for(var9 = 0; var9 < this.outBindAccessors.length; ++var9) {
               if (this.outBindAccessors[var9] != null) {
                  this.outBindAccessors[var9].lastRowProcessed = 0;
               }
            }
         }

         int var13;
         int var14;
         if (this.bindIndicators != null) {
            var9 = ((this.bindIndicators[this.bindIndicatorSubRange + 3] & '\uffff') << 16) + (this.bindIndicators[this.bindIndicatorSubRange + 4] & '\uffff');
            int var10 = 0;
            if (this.ibtBindChars != null) {
               var10 = this.ibtBindChars.length * this.connection.conversion.cMaxCharSize;
            }

            for(int var11 = 0; var11 < this.numberOfBindPositions; ++var11) {
               int var12 = this.bindIndicatorSubRange + 5 + 10 * var11;
               var13 = this.bindIndicators[var12 + 2] & '\uffff';
               if (var13 != 0) {
                  var14 = this.bindIndicators[var12 + 9] & '\uffff';
                  if (var14 == 2) {
                     var10 = Math.max(var13 * this.connection.conversion.maxNCharSize, var10);
                  } else {
                     var10 = Math.max(var13 * this.connection.conversion.cMaxCharSize, var10);
                  }
               }
            }

            if (this.tmpBindsByteArray == null) {
               this.tmpBindsByteArray = new byte[var10];
            } else if (this.tmpBindsByteArray.length < var10) {
               this.tmpBindsByteArray = null;
               this.tmpBindsByteArray = new byte[var10];
            }
         } else {
            this.tmpBindsByteArray = null;
         }

         int[] var17 = this.definedColumnType;
         int[] var20 = this.definedColumnSize;
         int[] var18 = this.definedColumnFormOfUse;
         if (var5 && var4 && this.isRowidPrepended) {
            var17 = new int[this.definedColumnType.length + 1];
            System.arraycopy(this.definedColumnType, 0, var17, 1, this.definedColumnType.length);
            var17[0] = -8;
            var20 = new int[this.definedColumnSize.length + 1];
            System.arraycopy(this.definedColumnSize, 0, var20, 1, this.definedColumnSize.length);
            var18 = new int[this.definedColumnFormOfUse.length + 1];
            System.arraycopy(this.definedColumnFormOfUse, 0, var18, 1, this.definedColumnFormOfUse.length);
         }

         this.allocateTmpByteArray();
         T4C8Oall var19 = this.t4Connection.all8;

         try {
            var19.doOALL(var1, var2, var3, var4, var5, this.sqlKind, this.cursorId, this.sqlObject.getSqlBytes(this.processEscapes, this.convertNcharLiterals), var7, this.outBindAccessors, this.numberOfBindPositions, this.accessors, var8, this.bindBytes, this.bindChars, this.bindIndicators, this.bindIndicatorSubRange, this.connection.conversion, this.tmpBindsByteArray, this.parameterStream, parameterDatum, parameterOtype, this, this.ibtBindBytes, this.ibtBindChars, this.ibtBindIndicators, this.oacdefSent, var17, var20, var18, this.registration);
            var13 = var19.getCursorId();
            if (var13 != 0 && this.implicitResultSetStatements == null) {
               this.cursorId = var13;
            }

            this.oacdefSent = var19.oacdefBindsSent;
            if (this.connection.isPDBChanged) {
               NTFPDBChangeEvent var21 = new NTFPDBChangeEvent(this.connection);
               ((T4CConnection)this.connection).notify(var21);
               this.connection.isPDBChanged = false;
            }
         } catch (SQLException var15) {
            var14 = var19.getCursorId();
            if (var14 != 0) {
               this.cursorId = var14;
            }

            if (var15.getErrorCode() != DatabaseError.getVendorCode(110)) {
               throw var15;
            }

            this.sqlWarning = DatabaseError.addSqlWarning(this.sqlWarning, 110);
         }

      }
   }

   void allocateTmpByteArray() {
      if (this.tmpByteArray == null) {
         this.tmpByteArray = new byte[this.sizeTmpByteArray];
      } else if (this.sizeTmpByteArray > this.tmpByteArray.length) {
         this.tmpByteArray = new byte[this.sizeTmpByteArray];
      }

   }

   void releaseBuffers() {
      super.releaseBuffers();
      this.tmpByteArray = null;
      this.tmpBindsByteArray = null;
      if (this.t4Connection != null) {
         this.t4Connection.all8.bindChars = null;
         this.t4Connection.all8.bindBytes = null;
         this.t4Connection.all8.tmpBindsByteArray = null;
      }

   }

   void allocateRowidAccessor() throws SQLException {
      this.accessors[0] = new T4CRowidAccessor(this, 128, (short)1, -8, false, this.t4Connection.mare);
   }

   void reparseOnRedefineIfNeeded() throws SQLException {
      this.needToParse = true;
   }

   protected void defineColumnTypeInternal(int var1, int var2, int var3, short var4, boolean var5, String var6) throws SQLException {
      if (!this.connection.disableDefinecolumntype) {
         if (var2 == -15 || var2 == -9 || var2 == -16) {
            var4 = 2;
         }

         SQLException var9;
         if (var1 < 1) {
            var9 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 3);
            var9.fillInStackTrace();
            throw var9;
         } else if (this.currentResultSet != null && !this.currentResultSet.closed) {
            var9 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 28);
            var9.fillInStackTrace();
            throw var9;
         } else {
            int var7 = var1 - 1;
            int[] var8;
            if (this.definedColumnType == null || this.definedColumnType.length <= var7) {
               if (this.definedColumnType == null) {
                  this.definedColumnType = new int[(var7 + 1) * 4];
               } else {
                  var8 = new int[(var7 + 1) * 4];
                  System.arraycopy(this.definedColumnType, 0, var8, 0, this.definedColumnType.length);
                  this.definedColumnType = var8;
               }
            }

            this.definedColumnType[var7] = var2;
            if (this.definedColumnSize == null || this.definedColumnSize.length <= var7) {
               if (this.definedColumnSize == null) {
                  this.definedColumnSize = new int[(var7 + 1) * 4];
               } else {
                  var8 = new int[(var7 + 1) * 4];
                  System.arraycopy(this.definedColumnSize, 0, var8, 0, this.definedColumnSize.length);
                  this.definedColumnSize = var8;
               }
            }

            this.definedColumnSize[var7] = var2 != 2005 && var2 != 2004 ? -1 : var3;
            if (this.definedColumnFormOfUse == null || this.definedColumnFormOfUse.length <= var7) {
               if (this.definedColumnFormOfUse == null) {
                  this.definedColumnFormOfUse = new int[(var7 + 1) * 4];
               } else {
                  var8 = new int[(var7 + 1) * 4];
                  System.arraycopy(this.definedColumnFormOfUse, 0, var8, 0, this.definedColumnFormOfUse.length);
                  this.definedColumnFormOfUse = var8;
               }
            }

            this.definedColumnFormOfUse[var7] = var4;
            if (this.accessors != null && var7 < this.accessors.length && this.accessors[var7] != null) {
               this.accessors[var7].definedColumnSize = var3;
               if ((this.accessors[var7].internalType == 96 || this.accessors[var7].internalType == 1) && (var2 == 1 || var2 == 12) && var3 <= this.accessors[var7].oacmxl) {
                  this.needToPrepareDefineBuffer = true;
                  this.columnsDefinedByUser = true;
                  this.accessors[var7].initForDataAccess(var2, var3, (String)null);
                  this.accessors[var7].calculateSizeTmpByteArray();
               }
            }

            this.executeDoneForDefines = false;
         }
      }
   }

   public void clearDefines() throws SQLException {
      synchronized(this.connection) {
         super.clearDefines();
         this.definedColumnType = null;
         this.definedColumnSize = null;
         this.definedColumnFormOfUse = null;
         if (this.t4Connection != null && this.t4Connection.all8 != null) {
            this.t4Connection.all8.definesAccessors = null;
         }

      }
   }

   void doSetSnapshotSCN(long var1) throws SQLException {
      this.inScn = var1;
   }

   Accessor allocateAccessor(int var1, int var2, int var3, int var4, short var5, String var6, boolean var7) throws SQLException {
      Object var8 = null;
      SQLException var9;
      switch(var1) {
      case 2:
         var8 = new T4CNumberAccessor(this, var4, var5, var2, var7, this.t4Connection.mare);
         break;
      case 6:
         var8 = new T4CVarnumAccessor(this, var4, var5, var2, var7, this.t4Connection.mare);
         break;
      case 8:
         if (!var7) {
            var8 = new T4CLongAccessor(this, var3, var4, var5, var2, this.t4Connection.mare);
            break;
         }
      case 1:
         var8 = new T4CVarcharAccessor(this, var4, var5, var2, var7, this.t4Connection.mare);
         break;
      case 12:
         var8 = new T4CDateAccessor(this, var4, var5, var2, var7, this.t4Connection.mare);
         break;
      case 24:
         if (!var7) {
            var8 = new T4CLongRawAccessor(this, var3, var4, var5, var2, this.t4Connection.mare);
            break;
         }
      case 23:
         if (var7 && var6 != null) {
            var9 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 12, "sqlType=" + var2);
            var9.fillInStackTrace();
            throw var9;
         }

         if (var7) {
            var8 = new T4COutRawAccessor(this, var4, var5, var2, this.t4Connection.mare);
         } else {
            var8 = new T4CRawAccessor(this, var4, var5, var2, var7, this.t4Connection.mare);
         }
         break;
      case 96:
         var8 = new T4CCharAccessor(this, var4, var5, var2, var7, this.t4Connection.mare);
         break;
      case 100:
         var8 = new T4CBinaryFloatAccessor(this, var4, var5, var2, var7, this.t4Connection.mare);
         break;
      case 101:
         var8 = new T4CBinaryDoubleAccessor(this, var4, var5, var2, var7, this.t4Connection.mare);
         break;
      case 102:
         var8 = new T4CResultSetAccessor(this, var4, var5, var2, var7, this.t4Connection.mare);
         break;
      case 104:
         if (this.sqlKind == oracle.jdbc.internal.OracleStatement.SqlKind.CALL_BLOCK) {
            var8 = new T4CVarcharAccessor(this, 18, var5, var2, var7, this.t4Connection.mare);
            ((Accessor)var8).definedColumnType = -8;
         } else {
            var8 = new T4CRowidAccessor(this, var4, var5, var2, var7, this.t4Connection.mare);
         }
         break;
      case 109:
         var8 = new T4CNamedTypeAccessor(this, var6, var5, var2, var7, this.t4Connection.mare);
         ((Accessor)var8).initMetadata();
         break;
      case 111:
         var8 = new T4CRefTypeAccessor(this, var6, var5, var2, var7, this.t4Connection.mare);
         ((Accessor)var8).initMetadata();
         break;
      case 112:
         var8 = new T4CClobAccessor(this, var4, var5, var2, var7, this.t4Connection.mare);
         break;
      case 113:
         var8 = new T4CBlobAccessor(this, var4, var5, var2, var7, this.t4Connection.mare);
         break;
      case 114:
         var8 = new T4CBfileAccessor(this, var4, var5, var2, var7, this.t4Connection.mare);
         break;
      case 180:
         var8 = new T4CTimestampAccessor(this, var4, var5, var2, var7, this.t4Connection.mare);
         break;
      case 181:
         var8 = new T4CTimestamptzAccessor(this, var4, var5, var2, var7, this.t4Connection.mare);
         break;
      case 182:
         var8 = new T4CIntervalymAccessor(this, var4, var5, var2, var7, this.t4Connection.mare);
         break;
      case 183:
         var8 = new T4CIntervaldsAccessor(this, var4, var5, var2, var7, this.t4Connection.mare);
         break;
      case 231:
         var8 = new T4CTimestampltzAccessor(this, var4, var5, var2, var7, this.t4Connection.mare);
         break;
      case 995:
         var9 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 89);
         var9.fillInStackTrace();
         throw var9;
      }

      return (Accessor)var8;
   }

   void doDescribe(boolean var1) throws SQLException {
      if (!this.isOpen) {
         SQLException var5 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 144);
         var5.fillInStackTrace();
         throw var5;
      } else {
         try {
            this.t4Connection.needLine();
            this.t4Connection.describe.doODNY(this, 0, this.accessors, this.sqlObject.getSqlBytes(this.processEscapes, this.convertNcharLiterals));
            this.accessors = this.t4Connection.describe.getAccessors();
            this.numberOfDefinePositions = this.t4Connection.describe.numuds;

            for(int var2 = 0; var2 < this.numberOfDefinePositions; ++var2) {
               this.accessors[var2].initMetadata();
            }
         } catch (IOException var4) {
            ((T4CConnection)this.connection).handleIOException(var4);
            SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), var4);
            var3.fillInStackTrace();
            throw var3;
         }

         this.describedWithNames = true;
         this.described = true;
      }
   }

   void executeForDescribe() throws SQLException {
      this.t4Connection.assertLoggedOn("oracle.jdbc.driver.T4CStatement.execute_for_describe");
      boolean var9 = false;

      CRC64 var10000;
      try {
         var9 = true;
         this.doOall8(true, true, this.definedColumnType != null, true, this.definedColumnType != null);
         var9 = false;
      } catch (SQLException var10) {
         throw var10;
      } catch (IOException var11) {
         ((T4CConnection)this.connection).handleIOException(var11);
         SQLException var2 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), var11);
         var2.fillInStackTrace();
         throw var2;
      } finally {
         if (var9) {
            this.rowsProcessed = this.t4Connection.all8.rowsProcessed;
            this.validRows = this.t4Connection.all8.getNumRows();
            if (this.connection.checksumMode.needToCalculateFetchChecksum()) {
               if (this.validRows > 0) {
                  this.calculateCheckSum();
               } else if (this.rowsProcessed > 0) {
                  var10000 = PhysicalConnection.CHECKSUM;
                  long var4 = CRC64.updateChecksum(this.checkSum, (long)this.rowsProcessed);
                  this.checkSum = var4;
               }
            }

         }
      }

      this.rowsProcessed = this.t4Connection.all8.rowsProcessed;
      this.validRows = this.t4Connection.all8.getNumRows();
      if (this.connection.checksumMode.needToCalculateFetchChecksum()) {
         if (this.validRows > 0) {
            this.calculateCheckSum();
         } else if (this.rowsProcessed > 0) {
            var10000 = PhysicalConnection.CHECKSUM;
            long var1 = CRC64.updateChecksum(this.checkSum, (long)this.rowsProcessed);
            this.checkSum = var1;
         }
      }

      this.needToParse = false;
      if (this.definedColumnType == null) {
         this.implicitDefineForLobPrefetchDone = false;
      }

      this.aFetchWasDoneDuringDescribe = false;
      if (this.t4Connection.all8.aFetchWasDone) {
         this.aFetchWasDoneDuringDescribe = true;
         this.rowPrefetchInLastFetch = this.rowPrefetch;
      }

      for(int var13 = 0; var13 < this.numberOfDefinePositions; ++var13) {
         this.accessors[var13].initMetadata();
      }

      this.needToPrepareDefineBuffer = false;
   }

   void executeForRows(boolean var1) throws SQLException {
      try {
         try {
            boolean var2 = false;
            if (this.columnsDefinedByUser) {
               this.needToPrepareDefineBuffer = false;
            } else if (this.t4Connection.useLobPrefetch && this.accessors != null && this.defaultLobPrefetchSize != -1 && !this.implicitDefineForLobPrefetchDone && !this.aFetchWasDoneDuringDescribe && this.definedColumnType == null) {
               boolean var15 = false;
               int[] var4 = new int[this.accessors.length];
               int[] var5 = new int[this.accessors.length];
               int[] var6 = new int[this.accessors.length];
               int var7 = 0;

               while(true) {
                  if (var7 >= this.accessors.length) {
                     if (var15) {
                        this.definedColumnType = var4;
                        this.definedColumnSize = var5;
                        this.definedColumnFormOfUse = var6;
                        var2 = true;
                     }
                     break;
                  }

                  if (this.accessors[var7] != null) {
                     var4[var7] = this.getJDBCType(this.accessors[var7].internalType);
                     var6[var7] = this.accessors[var7].formOfUse;
                     if (this.accessors[var7].internalType == 113 || this.accessors[var7].internalType == 112 || this.accessors[var7].internalType == 114) {
                        var15 = true;
                        this.accessors[var7].setPrefetchLength(this.defaultLobPrefetchSize);
                        var5[var7] = this.defaultLobPrefetchSize;
                     }
                  }

                  ++var7;
               }
            }

            this.doOall8(this.needToParse, !var1, true, false, var2);
            this.needToParse = false;
            if (var2) {
               this.implicitDefineForLobPrefetchDone = true;
            }
         } finally {
            if (this.implicitResultSetStatements == null) {
               this.validRows = this.t4Connection.all8.getNumRows();
            } else {
               this.validRows = 0;
            }

            this.calculateCheckSum();
         }

      } catch (SQLException var13) {
         throw var13;
      } catch (IOException var14) {
         ((T4CConnection)this.connection).handleIOException(var14);
         SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), var14);
         var3.fillInStackTrace();
         throw var3;
      }
   }

   protected void fetch(int var1, boolean var2) throws SQLException {
      if (this.rowData != null) {
         if (var2) {
            this.rowData.setPosition(this.rowData.length());
         } else {
            this.rowData.reset();
         }
      }

      SQLException var4;
      if (this.streamList != null) {
         for(; this.nextStream != null; this.nextStream = this.nextStream.nextStream) {
            try {
               this.nextStream.close();
            } catch (IOException var6) {
               ((T4CConnection)this.connection).handleIOException(var6);
               var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), var6);
               var4.fillInStackTrace();
               throw var4;
            }
         }
      }

      try {
         this.doOall8(false, false, true, false, false, var1);
         this.validRows = this.t4Connection.all8.getNumRows();
         if (this.validRows != -2) {
            this.validRows -= var1;
         }

         this.calculateCheckSum();
      } catch (IOException var5) {
         ((T4CConnection)this.connection).handleIOException(var5);
         var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), var5);
         var4.fillInStackTrace();
         throw var4;
      }
   }

   void continueReadRow(int var1) throws SQLException {
      try {
         if (!this.isFetchStreams) {
            T4C8Oall var2 = this.t4Connection.all8;
            var2.continueReadRow(var1, this);
         }
      } catch (IOException var4) {
         ((T4CConnection)this.connection).handleIOException(var4);
         SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), var4);
         var3.fillInStackTrace();
         throw var3;
      } catch (SQLException var5) {
         if (var5.getErrorCode() != DatabaseError.getVendorCode(110)) {
            throw var5;
         }

         this.sqlWarning = DatabaseError.addSqlWarning(this.sqlWarning, 110);
      }

   }

   void doClose() throws SQLException {
      this.t4Connection.assertLoggedOn("oracle.jdbc.driver.T4CStatement.do_close");
      if (this.cursorId != 0) {
         this.t4Connection.closeCursor(this.cursorId);
      }

      this.tmpByteArray = null;
      this.tmpBindsByteArray = null;
      this.definedColumnType = null;
      this.definedColumnSize = null;
      this.definedColumnFormOfUse = null;
      this.oacdefSent = null;
   }

   void closeQuery() throws SQLException {
      this.connection.registerHeartbeat();
      this.connection.needLine();
      this.t4Connection.assertLoggedOn("oracle.jdbc.driver.T4CStatement.closeQuery");
      if (this.streamList != null) {
         for(; this.nextStream != null; this.nextStream = this.nextStream.nextStream) {
            try {
               this.nextStream.close();
            } catch (IOException var3) {
               ((T4CConnection)this.connection).handleIOException(var3);
               SQLException var2 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), var3);
               var2.fillInStackTrace();
               throw var2;
            }
         }
      }

   }

   T4CStatement(PhysicalConnection var1, int var2, int var3) throws SQLException {
      super(var1, 1, var1.defaultRowPrefetch, var2, var3);
      this.nbPostPonedColumns = new int[1];
      this.nbPostPonedColumns[0] = 0;
      this.indexOfPostPonedColumn = new int[1][3];
      this.t4Connection = (T4CConnection)var1;
   }

   void closeCursorOnPlainStatement() throws SQLException {
      if (this.cursorId != 0 && this.t4Connection.isLoggedOn()) {
         this.t4Connection.closeCursor(this.cursorId);
         this.setCursorId(0);
      }

   }
}
