package oracle.jdbc.driver;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.CharBuffer;
import java.nio.ShortBuffer;
import java.sql.SQLException;
import java.util.ArrayDeque;
import oracle.jdbc.oracore.OracleTypeADT;

class T2CCallableStatement extends OracleCallableStatement {
   T2CConnection t2cConnection = null;
   int userResultSetType = -1;
   int userResultSetConcur = -1;
   static int T2C_EXTEND_BUFFER = -3;
   long[] t2cOutput = new long[10];
   static final int T2C_OUTPUT_USE_NIO = 5;
   static final int T2C_OUTPUT_STMT_LOB_PREFETCH_SIZE = 6;
   static final int T2C_OUTPUT_USE_OCI_DEFAULT_DEFINE_OFFSET = 7;
   static final boolean T2CDEBUG = false;
   int extractedCharOffset;
   int extractedByteOffset;
   int savedRowPrefetch = 0;
   static final byte T2C_LOB_PREFETCH_SIZE_THIS_COLUMN_OFFSET = 0;
   static final byte T2C_LOB_PREFETCH_LOB_LENGTH_OFFSET = 1;
   static final byte T2C_LOB_PREFETCH_FORM_OFFSET = 2;
   static final byte T2C_LOB_PREFETCH_CHUNK_OFFSET = 3;
   static final byte T2C_LOB_PREFETCH_DATA_OFFSET = 4;
   byte[] lobPrefetchTempBytes;
   boolean needToRetainRows = false;
   byte[] returnParamBytes;
   char[] returnParamChars;
   short[] returnParamIndicators;
   int returnParamRowBytes;
   int returnParamRowChars;
   static int PREAMBLE_PER_POSITION = 5;
   SQLException updateDataException = null;
   int lastProcessedCell = 0;
   static final int PROCESS_DEFINE_DYNAMIC_COLUMNS = 16;
   static final int PROCESS_DEFINE_DEFAULT_COLUMNS = 32;
   static final int PROCESS_ADT_OUT_BINDS = 64;
   int lastProcessedAccessorIndex = 0;
   int accessorsProcessed = 0;
   int previousMode = 0;
   private static final String _Copyright_2007_Oracle_All_Rights_Reserved_ = null;
   public static final String BUILD_DATE = "Thu_Apr_04_15:09:24_PDT_2013";
   public static final boolean TRACE = false;

   T2CCallableStatement(T2CConnection var1, String var2, int var3, int var4, int var5, int var6) throws SQLException {
      super(var1, var2, var3, var4, var5, var6);
      this.userResultSetType = var5;
      this.userResultSetConcur = var6;
      this.t2cConnection = var1;
      if (this.t2cConnection.useOCIDefaultDefines) {
         this.savedRowPrefetch = this.rowPrefetch;
         this.rowPrefetch = 1;
      }

   }

   int getPrefetchInternal(boolean var1) {
      if (!this.t2cConnection.useOCIDefaultDefines) {
         return super.getPrefetchInternal(var1);
      } else {
         int var2 = var1 ? this.defaultRowPrefetch : this.savedRowPrefetch;
         return var2;
      }
   }

   void setPrefetchInternal(int var1, boolean var2, boolean var3) throws SQLException {
      int var4 = this.rowPrefetch;
      super.setPrefetchInternal(var1, var2, var3);
      if (this.t2cConnection.useOCIDefaultDefines && var4 != this.rowPrefetch) {
         this.savedRowPrefetch = this.rowPrefetch;
         this.rowPrefetch = 1;
      }

   }

   void prepareForNewResults(boolean var1, boolean var2, boolean var3) throws SQLException {
      super.prepareForNewResults(var1, var2, var3);
      if (this.t2cConnection.useOCIDefaultDefines && this.rowPrefetchChanged) {
         this.savedRowPrefetch = this.rowPrefetch;
         this.rowPrefetch = 1;
      }

   }

   void prepareAccessors() throws SQLException {
      super.prepareAccessors();
      if (this.t2cConnection.useOCIDefaultDefines && this.hasStream) {
         this.savedRowPrefetch = 1;
      }

   }

   String bytes2String(byte[] var1, int var2, int var3) throws SQLException {
      byte[] var4 = new byte[var3];
      System.arraycopy(var1, var2, var4, 0, var3);
      return this.connection.conversion.CharBytesToString(var4, var3);
   }

   void processDescribeData() throws SQLException {
      this.described = true;
      this.describedWithNames = true;
      if (this.numberOfDefinePositions >= 1) {
         if (this.accessors == null || this.numberOfDefinePositions > this.accessors.length) {
            this.accessors = new Accessor[this.numberOfDefinePositions];
         }

         int var1 = this.t2cConnection.queryMetaData1Offset;
         int var2 = this.t2cConnection.queryMetaData2Offset;
         short[] var3 = this.t2cConnection.queryMetaData1;
         byte[] var4 = this.t2cConnection.queryMetaData2;

         for(int var5 = 0; var5 < this.numberOfDefinePositions; var1 += 14) {
            T2CConnection var10002 = this.t2cConnection;
            short var6 = var3[var1 + 0];
            var10002 = this.t2cConnection;
            short var7 = var3[var1 + 1];
            var10002 = this.t2cConnection;
            short var8 = var3[var1 + 11];
            var10002 = this.t2cConnection;
            boolean var9 = var3[var1 + 2] != 0;
            var10002 = this.t2cConnection;
            short var10 = var3[var1 + 3];
            var10002 = this.t2cConnection;
            short var11 = var3[var1 + 4];
            byte var12 = 0;
            byte var13 = 0;
            byte var14 = 0;
            var10002 = this.t2cConnection;
            short var15 = var3[var1 + 5];
            var10002 = this.t2cConnection;
            short var16 = var3[var1 + 6];
            String var17 = this.bytes2String(var4, var2, var16);
            var10002 = this.t2cConnection;
            short var18 = var3[var1 + 12];
            var10002 = this.t2cConnection;
            boolean var19 = var3[var1 + 13] != 0;
            String var20 = null;
            OracleTypeADT var21 = null;
            var2 += var16;
            if (var18 > 0) {
               var20 = this.bytes2String(var4, var2, var18);
               var2 += var18;
               var21 = new OracleTypeADT(var20, this.connection);
               T2CConnection var10003 = this.t2cConnection;
               long var10001 = ((long)var3[var1 + 7] & 65535L) << 48;
               T2CConnection var10004 = this.t2cConnection;
               var10001 |= ((long)var3[var1 + 8] & 65535L) << 32;
               var10004 = this.t2cConnection;
               var10001 |= ((long)var3[var1 + 9] & 65535L) << 16;
               var10004 = this.t2cConnection;
               var21.tdoCState = var10001 | (long)var3[var1 + 10] & 65535L;
            }

            Accessor var22 = this.accessors[var5];
            if (var22 != null && var22.defineType != 0 && (var22.describeType == 0 || var22.describeType == var6)) {
               var22.initForDescribe(var6, var7, var9, var12, var10, var11, var13, var14, var15, var20);
            } else {
               var22 = this.allocateAccessorForDefines(var5, var6, var7, var9, var12, var10, var11, var13, var14, var15, var8, var21, var20);
               if (this.accessors[var5] != null) {
                  var22.rowLength = this.accessors[var5].rowLength;
                  var22.rowOffset = this.accessors[var5].rowOffset;
                  var22.rowNull = this.accessors[var5].rowNull;
                  var22.rowMetadata = this.accessors[var5].rowMetadata;
               }
            }

            var22.describeOtype = var21;
            var22.columnName = var17;
            var22.columnInvisible = var19;
            this.accessors[var5] = var22;
            ++var5;
         }

      }
   }

   Accessor allocateAccessorForDefines(int var1, int var2, int var3, boolean var4, int var5, int var6, int var7, int var8, int var9, short var10, int var11, OracleTypeADT var12, String var13) throws SQLException {
      Object var14;
      switch(var2) {
      case 1:
         var14 = new VarcharAccessor(this, var3, var4, var5, var6, var7, var8, var9, var10);
         if (var11 > 0) {
            ((Accessor)var14).setDisplaySize(var11);
         }
         break;
      case 2:
         var14 = new NumberAccessor(this, var3, var4, var5, var6, var7, var8, var9, var10);
         break;
      case 8:
         var14 = new T2CLongAccessor(this, var1 + 1, var3, var4, var5, var6, var7, var8, var9, var10);
         this.rowPrefetch = 1;
         this.savedRowPrefetch = 1;
         break;
      case 12:
         var14 = new DateAccessor(this, var3, var4, var5, var6, var7, var8, var9, var10);
         break;
      case 23:
         var14 = new RawAccessor(this, var3, var4, var5, var6, var7, var8, var9, var10);
         break;
      case 24:
         var14 = new T2CLongRawAccessor(this, var1 + 1, var3, var4, var5, var6, var7, var8, var9, var10);
         this.rowPrefetch = 1;
         this.savedRowPrefetch = 1;
         break;
      case 96:
         var14 = new CharAccessor(this, var3, var4, var5, var6, var7, var8, var9, var10);
         if (var11 > 0) {
            ((Accessor)var14).setDisplaySize(var11);
         }
         break;
      case 100:
         var14 = new BinaryFloatAccessor(this, var3, var4, var5, var6, var7, var8, var9, var10);
         break;
      case 101:
         var14 = new BinaryDoubleAccessor(this, var3, var4, var5, var6, var7, var8, var9, var10);
         break;
      case 102:
      case 116:
         if (this.sqlKind.isPlsqlOrCall()) {
            var14 = new T2CResultSetAccessor(this, var3, var4, var5, var6, var7, var8, var9, var10);
         } else {
            var14 = new ResultSetAccessor(this, var3, var4, var5, var6, var7, var8, var9, var10);
         }
         break;
      case 104:
         var14 = new RowidAccessor(this, var3, var4, var5, var6, var7, var8, var9, (short)1);
         break;
      case 109:
         var14 = new NamedTypeAccessor(this, var3, var4, var5, var6, var7, var8, var9, var10, var13, var12);
         break;
      case 111:
         var14 = new RefTypeAccessor(this, var3, var4, var5, var6, var7, var8, var9, var10, var13, var12);
         break;
      case 112:
         var14 = new ClobAccessor(this, var3, var4, var5, var6, var7, var8, var9, var10);
         break;
      case 113:
         var14 = new BlobAccessor(this, var3, var4, var5, var6, var7, var8, var9, var10);
         break;
      case 114:
         var14 = new BfileAccessor(this, var3, var4, var5, var6, var7, var8, var9, var10);
         break;
      case 180:
         var14 = new TimestampAccessor(this, var3, var4, var5, var6, var7, var8, var9, var10);
         break;
      case 181:
         var14 = new TimestamptzAccessor(this, var3, var4, var5, var6, var7, var8, var9, var10);
         break;
      case 182:
         var14 = new IntervalymAccessor(this, var3, var4, var5, var6, var7, var8, var9, var10);
         break;
      case 183:
         var14 = new IntervaldsAccessor(this, var3, var4, var5, var6, var7, var8, var9, var10);
         break;
      case 231:
         var14 = new TimestampltzAccessor(this, var3, var4, var5, var6, var7, var8, var9, var10);
         break;
      default:
         SQLException var15 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 1, "Unknown or unimplemented accessor type: " + var2);
         var15.fillInStackTrace();
         throw var15;
      }

      return (Accessor)var14;
   }

   void executeForDescribe() throws SQLException {
      this.t2cOutput[0] = 0L;
      this.t2cOutput[2] = 0L;
      this.t2cOutput[7] = (long)(this.t2cConnection.useOCIDefaultDefines ? 1 : 0);
      this.lobPrefetchMetaData = null;
      boolean var1 = !this.described;
      boolean var2 = false;
      int var4 = this.t2cConnection.useOCIDefaultDefines ? this.savedRowPrefetch : this.rowPrefetch;

      assert var4 > 0 : "rowsToFetch < 1 (rowsToFetch=" + var4 + ", maxRows=" + this.maxRows + ", rowPrefetch=" + this.rowPrefetch + ", savedRowPrefetch=" + this.savedRowPrefetch + ")";

      this.validRows = 0;

      boolean var3;
      do {
         var3 = false;
         if (this.connection.endToEndAnyChanged) {
            this.pushEndToEndValues();
            this.connection.endToEndAnyChanged = false;
         }

         byte[] var5 = this.sqlObject.getSqlBytes(this.processEscapes, this.convertNcharLiterals);
         boolean var6 = false;

         int var10;
         try {
            this.resetStateBeforeFetch();
            var10 = T2CStatement.t2cParseExecuteDescribe(this, this.c_state, this.numberOfBindPositions, this.numberOfBindRowsAllocated, this.firstRowInBatch, this.currentRowBindAccessors != null, this.needToParse, var1, var2, var5, var5.length, T2CStatement.convertSqlKindEnumToByte(this.sqlKind), var4, this.batch, this.bindIndicators, this.bindIndicatorOffset, this.bindBytes, this.bindChars, this.bindByteOffset, this.bindCharOffset, this.ibtBindIndicators, this.ibtBindIndicatorOffset, this.ibtBindIndicatorSize, this.ibtBindBytes, this.ibtBindChars, this.ibtBindByteOffset, this.ibtBindCharOffset, this.returnParamMeta, this.t2cConnection.queryMetaData1, this.t2cConnection.queryMetaData2, this.t2cConnection.queryMetaData1Offset, this.t2cConnection.queryMetaData2Offset, this.t2cConnection.queryMetaData1Size, this.t2cConnection.queryMetaData2Size, this.preparedByteBinds, this.preparedCharBinds, this.outBindAccessors, this.parameterDatum, this.t2cOutput, this.t2cConnection.plsqlCompilerWarnings);
         } catch (IOException var9) {
            SQLException var8 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 266);
            var8.fillInStackTrace();
            throw var8;
         }

         if (this.bindIndicators != null) {
            this.setLengthForOutAccessors();
         }

         this.validRows = (int)this.t2cOutput[1];
         if (var10 != -1 && var10 != -4) {
            if (var10 == T2C_EXTEND_BUFFER) {
               var10 = this.t2cConnection.queryMetaData1Size * 2;
            }
         } else {
            this.t2cConnection.checkError(var10);
         }

         if (this.t2cOutput[3] != 0L) {
            this.foundPlsqlCompilerWarning();
         } else if (this.t2cOutput[2] != 0L) {
            this.sqlWarning = this.t2cConnection.checkError(1, this.sqlWarning);
         }

         this.connection.endToEndECIDSequenceNumber = (short)((int)this.t2cOutput[4]);
         this.needToParse = false;
         var2 = true;
         if (this.sqlKind.isSELECT()) {
            this.numberOfDefinePositions = var10;
            if (this.numberOfDefinePositions > this.t2cConnection.queryMetaData1Size) {
               var3 = true;
               var2 = true;
               this.t2cConnection.reallocateQueryMetaData(this.numberOfDefinePositions, this.numberOfDefinePositions * 8);
            }
         } else {
            this.numberOfDefinePositions = 0;
            this.validRows = var10;
         }

         if (this.sqlKind.isPlsqlOrCall()) {
            this.checkForImplicitResultSets();
         }
      } while(var3);

      this.isComplete = false;
      this.processDescribeData();
   }

   void checkForImplicitResultSets() throws SQLException {
      boolean var1 = false;
      int var4 = T2CStatement.t2cGetImplicitResultSetCount(this, this.c_state);
      if (var4 > 0) {
         int var2 = var4;

         for(this.implicitResultSetStatements = new ArrayDeque(var4); var2 != 0; --var2) {
            OracleStatement var3 = this.connection.createImplicitResultSetStatement(this);
            ((T2CStatement)var3).doDescribe(true);
            ((T2CStatement)var3).prepareAccessors();
         }

         this.implicitResultSetIterator = this.implicitResultSetStatements.iterator();
      } else if (var4 != 0) {
         this.t2cConnection.checkError(var4);
      }

   }

   void pushEndToEndValues() throws SQLException {
      T2CConnection var1 = this.t2cConnection;
      byte[] var2 = null;
      byte[] var3 = null;
      byte[] var4 = null;
      byte[] var5 = null;
      Object var6 = null;
      if (var1.endToEndValues != null) {
         String var7;
         if (var1.endToEndHasChanged[0]) {
            var7 = var1.endToEndValues[0];
            if (var7 != null) {
               var2 = DBConversion.stringToDriverCharBytes(var7, var1.m_clientCharacterSet);
            } else {
               var2 = PhysicalConnection.EMPTY_BYTE_ARRAY;
            }

            var1.endToEndHasChanged[0] = false;
         }

         if (var1.endToEndHasChanged[1]) {
            var7 = var1.endToEndValues[1];
            if (var7 != null) {
               var3 = DBConversion.stringToDriverCharBytes(var7, var1.m_clientCharacterSet);
            } else {
               var3 = PhysicalConnection.EMPTY_BYTE_ARRAY;
            }

            var1.endToEndHasChanged[1] = false;
         }

         if (var1.endToEndHasChanged[2]) {
            var7 = var1.endToEndValues[2];
            if (var7 != null) {
               var4 = DBConversion.stringToDriverCharBytes(var7, var1.m_clientCharacterSet);
            } else {
               var4 = PhysicalConnection.EMPTY_BYTE_ARRAY;
            }

            var1.endToEndHasChanged[2] = false;
         }

         if (var1.endToEndHasChanged[3]) {
            var7 = var1.endToEndValues[3];
            if (var7 != null) {
               var5 = DBConversion.stringToDriverCharBytes(var7, var1.m_clientCharacterSet);
            } else {
               var5 = PhysicalConnection.EMPTY_BYTE_ARRAY;
            }

            var1.endToEndHasChanged[3] = false;
         }

         if (var1.endToEndHasChanged[4]) {
            var7 = var1.endToEndValues[4];
            if (var7 != null) {
               var5 = DBConversion.stringToDriverCharBytes(var7, var1.m_clientCharacterSet);
            } else {
               var5 = PhysicalConnection.EMPTY_BYTE_ARRAY;
            }

            var1.endToEndHasChanged[4] = false;
         }

         T2CStatement.t2cEndToEndUpdate(this.c_state, var2, var2 == null ? -1 : var2.length, var3, var3 == null ? -1 : var3.length, var4, var4 == null ? -1 : var4.length, var5, var5 == null ? -1 : var5.length, (byte[])var6, var6 == null ? -1 : ((Object[])var6).length, var1.endToEndECIDSequenceNumber);
      }

   }

   void executeForRows(boolean var1) throws SQLException {
      if (this.connection.endToEndAnyChanged) {
         this.pushEndToEndValues();
         this.connection.endToEndAnyChanged = false;
      }

      if (!var1) {
         if (this.numberOfDefinePositions > 0) {
            this.doDefineExecuteFetch();
         } else {
            this.executeForDescribe();
         }
      } else if (this.numberOfDefinePositions > 0) {
         this.doDefineFetch();
      }

      if (this.returnParamMeta != null) {
         this.fetchDmlReturnParams();
      }

      this.needToPrepareDefineBuffer = false;
   }

   void setupForDefine() throws SQLException {
      if (this.numberOfDefinePositions > this.t2cConnection.queryMetaData1Size) {
         int var1 = this.numberOfDefinePositions / 100 + 1;
         this.t2cConnection.reallocateQueryMetaData(this.t2cConnection.queryMetaData1Size * var1, this.t2cConnection.queryMetaData2Size * var1 * 8);
      }

      short[] var7 = this.t2cConnection.queryMetaData1;
      int var2 = this.t2cConnection.queryMetaData1Offset;
      int var3 = 0;

      while(var3 < this.numberOfDefinePositions) {
         Accessor var4 = this.accessors[var3];
         if (var4 == null) {
            SQLException var9 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 21);
            var9.fillInStackTrace();
            throw var9;
         }

         T2CConnection var10002 = this.t2cConnection;
         var7[var2 + 0] = (short)var4.defineType;
         if (!this.described && var4.charLength > 0 && var4.formOfUse == 1) {
            int var5 = var4.charLength;
            int var6 = var5 + 1;
            var10002 = this.t2cConnection;
            var7[var2 + 11] = 0;
            var10002 = this.t2cConnection;
            var7[var2 + 1] = (short)var6;
         } else {
            var10002 = this.t2cConnection;
            var7[var2 + 11] = (short)var4.charLength;
            var10002 = this.t2cConnection;
            var7[var2 + 1] = (short)var4.byteLength;
         }

         var10002 = this.t2cConnection;
         var7[var2 + 5] = var4.formOfUse;
         if (var4.internalOtype != null) {
            long var8 = ((OracleTypeADT)var4.internalOtype).getTdoCState();
            var10002 = this.t2cConnection;
            var7[var2 + 7] = (short)((int)((var8 & -281474976710656L) >> 48));
            var10002 = this.t2cConnection;
            var7[var2 + 8] = (short)((int)((var8 & 281470681743360L) >> 32));
            var10002 = this.t2cConnection;
            var7[var2 + 9] = (short)((int)((var8 & 4294901760L) >> 16));
            var10002 = this.t2cConnection;
            var7[var2 + 10] = (short)((int)(var8 & 65535L));
         }

         switch(var4.internalType) {
         case 112:
         case 113:
            if (var4.lobPrefetchSizeForThisColumn == -1) {
               var4.lobPrefetchSizeForThisColumn = this.defaultLobPrefetchSize;
            }

            var7[var2 + 7] = (short)var4.lobPrefetchSizeForThisColumn;
         default:
            ++var3;
            var2 += 14;
         }
      }

   }

   protected void configureBindData() throws SQLException {
      if (this.outBindAccessors != null) {
         AggregateByteArray var1 = (AggregateByteArray)this.bindData;
         T2CCharByteArray var2 = (T2CCharByteArray)var1.extension;
         AggregateByteArray var3 = (AggregateByteArray)var2.extension;
         T2CCharByteArray var4 = (T2CCharByteArray)var3.extension;
         if (this.bindBytes != null) {
            var1.setBytes(this.bindBytes);
         } else {
            var1.setBytes(PhysicalConnection.EMPTY_BYTE_ARRAY);
         }

         if (this.bindChars != null) {
            var2.setChars(this.bindChars);
         } else {
            var2.setChars(PhysicalConnection.EMPTY_CHAR_ARRAY);
         }

         if (this.ibtBindBytes != null) {
            var3.setBytes(this.ibtBindBytes);
         } else {
            var3.setBytes(PhysicalConnection.EMPTY_BYTE_ARRAY);
         }

         if (this.ibtBindChars != null) {
            var4.setChars(this.ibtBindChars);
         } else {
            var4.setChars(PhysicalConnection.EMPTY_CHAR_ARRAY);
         }

         var2.setDBConversion(this.connection.conversion);
         var4.setDBConversion(this.connection.conversion);
         int var5 = this.bindBytes == null ? 0 : this.bindBytes.length;
         int var6 = this.bindChars == null ? 0 : this.bindChars.length;
         int var7 = this.ibtBindBytes == null ? 0 : this.ibtBindBytes.length;
         if (this.ibtBindChars == null) {
            boolean var10000 = false;
         } else {
            int var19 = this.ibtBindChars.length;
         }

         Accessor var9 = null;
         boolean var10 = false;

         for(int var11 = 0; var11 < this.numberOfBindPositions; ++var11) {
            var9 = this.outBindAccessors[var11];
            if (var9 != null) {
               byte var12 = 0;
               int var13 = var9.byteLength;
               int var17;
               if (var9.defineType == 998) {
                  PlsqlIndexTableAccessor var18 = (PlsqlIndexTableAccessor)var9;
                  var17 = var12 + var5 + var6;
                  var17 += var18.ibtBindInfo.ibtValueIndex;
                  switch(var18.ibtBindInfo.element_internal_type) {
                  case 9:
                     var17 += var7;
                  case 6:
                  default:
                     var9.setOffset(0, (long)var17);
                  }
               } else {
                  var17 = var9.columnDataOffset;
                  if (var9.charLength > 0) {
                     var17 += var5;
                     var13 = var9.charLength;
                  }

                  int var16;
                  if (var9.defineType == 15) {
                     var16 = 2;
                  } else if (var9.externalType == -8) {
                     var16 = this.sqlKind == oracle.jdbc.internal.OracleStatement.SqlKind.CALL_BLOCK ? 1 : 2;
                  } else if (var9.defineType != 6 && var9.defineType != 9) {
                     var16 = 0;
                  } else {
                     var16 = 1;
                  }

                  for(int var14 = 0; var14 < this.binders.length; ++var14) {
                     var17 += var13 * var14 + var16;
                     int var15 = this.bindIndicators[var9.lengthIndex] - var16 & 32767;
                     var9.setOffset(var14, (long)var17);
                  }
               }
            }
         }

      }
   }

   void initializePlsqlIndexByTableAccessor(Accessor var1, int var2) {
      ((T2CPlsqlIndexTableAccessor)var1).ibtMetaIndex = var2 - 8;
   }

   Object[] getLobPrefetchMetaData() {
      Object[] var1 = null;
      Object var2 = null;
      int[] var3 = null;
      int var4 = 0;
      int var5 = 0;
      int var6;
      if (this.accessors != null) {
         for(var6 = 0; var6 < this.numberOfDefinePositions; ++var6) {
            switch(this.accessors[var6].internalType) {
            case 8:
            case 24:
               var5 = var6;
               break;
            case 112:
            case 113:
               if (var3 == null) {
                  var3 = new int[this.accessors.length];
               }

               if (this.accessors[var6].lobPrefetchSizeForThisColumn != -1) {
                  ++var4;
                  var3[var6] = this.accessors[var6].lobPrefetchSizeForThisColumn;
               } else {
                  var3[var6] = -1;
               }
            }
         }
      }

      if (var4 > 0) {
         if (var1 == null) {
            var1 = new Object[]{null, new long[this.rowPrefetch * var4], new byte[this.accessors.length], new int[this.accessors.length], new Object[this.rowPrefetch * var4]};
         }

         var6 = 0;

         while(var6 < var5) {
            switch(this.accessors[var6].internalType) {
            case 112:
            case 113:
               this.accessors[var6].lobPrefetchSizeForThisColumn = -1;
               var3[var6] = -1;
            default:
               ++var6;
            }
         }

         var1[0] = var3;
      }

      return var1;
   }

   void processLobPrefetchMetaData(Object[] var1) {
      int var2 = 0;
      int var3 = this.validRows == -2 ? 1 : this.validRows;
      byte[] var4 = (byte[])((byte[])var1[2]);
      int[] var5 = (int[])((int[])var1[3]);
      long[] var6 = (long[])((long[])var1[1]);
      Object[] var7 = (Object[])((Object[])var1[4]);
      int[] var8 = (int[])((int[])var1[0]);
      if (this.accessors != null) {
         for(int var9 = 0; var9 < this.numberOfDefinePositions; ++var9) {
            switch(this.accessors[var9].internalType) {
            case 112:
            case 113:
               if (this.accessors[var9].lobPrefetchSizeForThisColumn >= 0) {
                  LobCommonAccessor var10 = (LobCommonAccessor)this.accessors[var9];
                  if (var10.prefetchedDataLength == null || var10.prefetchedDataLength.length < this.rowPrefetch) {
                     if (var10.internalType == 112) {
                        ((ClobAccessor)var10).prefetchedDataFormOfUse = new int[this.rowPrefetch];
                     }

                     var10.prefetchedChunkSize = new int[this.rowPrefetch];
                     var10.prefetchedDataLength = new int[this.rowPrefetch];
                     var10.prefetchedLength = new long[this.rowPrefetch];
                     var10.prefetchedDataOffset = new long[this.rowPrefetch];
                  }

                  int var11 = var3 * var2;
                  int var12 = this.needToRetainRows ? this.storedRowCount : 0;

                  for(int var13 = 0; var13 < var3; ++var13) {
                     var10.prefetchedChunkSize[var12 + var13] = var5[var9];
                     var10.prefetchedLength[var12 + var13] = var6[var11 + var13];
                     if (var10.internalType == 112) {
                        ((ClobAccessor)var10).prefetchedDataFormOfUse[var12 + var13] = var4[var9];
                     }

                     var10.prefetchedDataLength[var13] = 0;
                     if (var8[var9] > 0 && var6[var11 + var13] > 0L) {
                        byte[] var14 = (byte[])((byte[])var7[var11 + var13]);
                        int var15 = var14 == null ? 0 : var14.length;
                        if (var15 > 0) {
                           var10.setPrefetchedDataOffset(var12 + var13);
                           var10.rowData.put(var14, 0, var15);
                        }

                        var10.prefetchedDataLength[var12 + var13] = var15;
                     }
                  }

                  ++var2;
               }
            }
         }
      }

   }

   int getRowsToFetch() {
      boolean var1 = true;
      int var2;
      if (this.hasStream) {
         var2 = 1;
         if (this.t2cConnection.useOCIDefaultDefines) {
            this.savedRowPrefetch = 1;
         } else {
            this.rowPrefetch = 1;
         }
      } else if (this.t2cConnection.useOCIDefaultDefines) {
         if (this.maxRows > 0 && this.maxRows == this.storedRowCount) {
            var2 = 0;
         } else {
            var2 = this.rowPrefetch;
         }
      } else if (this.maxRows > 0 && this.maxRows < this.rowPrefetch + this.storedRowCount) {
         if (this.storedRowCount < 1 && this.maxRows < this.rowPrefetch) {
            var2 = this.maxRows;
         } else {
            var2 = Math.min(this.rowPrefetch, this.maxRows - (this.rowPrefetch + this.storedRowCount));
         }
      } else {
         var2 = this.rowPrefetch;
      }

      return var2;
   }

   void doDefineFetch() throws SQLException {
      int var1 = this.getRowsToFetch();
      this.validRows = 0;
      if (!this.needToPrepareDefineBuffer) {
         throw new Error("doDefineFetch called when needToPrepareDefineBuffer=false " + this.sqlObject.getSql(this.processEscapes, this.convertNcharLiterals));
      } else {
         assert var1 > 0 : "rowsToFetch < 1 (rowsToFetch=" + var1 + ", maxRows=" + this.maxRows + ", rowPrefetch=" + this.rowPrefetch + ", savedRowPrefetch=" + this.savedRowPrefetch + ")";

         if (var1 > 0) {
            this.setupForDefine();
            this.t2cOutput[2] = 0L;
            this.t2cOutput[5] = (long)(this.connection.useNio ? 1 : 0);
            this.t2cOutput[6] = (long)this.defaultLobPrefetchSize;
            if (this.connection.useNio) {
               this.resetNioAttributesBeforeFetch();
               this.allocateNioBuffersIfRequired(this.defineChars == null ? 0 : this.defineChars.length, this.defineBytes == null ? 0 : this.defineBytes.length, this.defineIndicators == null ? 0 : this.defineIndicators.length);
            }

            if (this.lobPrefetchMetaData == null) {
               this.lobPrefetchMetaData = this.getLobPrefetchMetaData();
            }

            this.resetStateBeforeFetch();
            this.validRows = T2CStatement.t2cDefineFetch(this, this.c_state, var1, this.t2cConnection.queryMetaData1, this.t2cConnection.queryMetaData2, this.t2cConnection.queryMetaData1Offset, this.t2cConnection.queryMetaData2Offset, this.accessors, this.t2cOutput, this.nioBuffers, this.lobPrefetchMetaData);
            if (this.validRows == -1 || this.validRows == -4) {
               this.t2cConnection.checkError(this.validRows);
            }

            if (this.t2cOutput[2] != 0L) {
               this.sqlWarning = this.t2cConnection.checkError(1, this.sqlWarning);
            }

            if (this.connection.useNio && (this.validRows > 0 || this.validRows == -2)) {
               this.extractNioDefineBuffers(0);
            }

            if (this.isFetchStreams && this.validRows == -2) {
               this.copyStreamDataIntoDBA(0);
            }

            if (this.lobPrefetchMetaData != null) {
               this.processLobPrefetchMetaData(this.lobPrefetchMetaData);
            }
         }

         this.isComplete = var1 < 1 || this.validRows >= 0 && this.validRows < var1;
      }
   }

   void copyStreamDataIntoDBA(int var1) throws SQLException {
      assert this.isFetchStreams && this.validRows == -2 : "isFetchStreams: " + this.isFetchStreams + "isScrollable(): " + this.realRsetType.isScrollable() + ", isUpdatable(): " + this.realRsetType.isUpdatable() + ", validRows=" + this.validRows;

      this.checkValidRowsStatus();
      if (this.accessors != null) {
         Accessor[] var2 = this.accessors;
         int var3 = var2.length;

         for(int var4 = 0; var4 < var3; ++var4) {
            Accessor var5 = var2[var4];
            if (var5 != null) {
               switch(var5.internalType) {
               case 8:
                  ((T2CLongAccessor)var5).copyStreamDataIntoDBA(var1);
                  break;
               case 24:
                  ((T2CLongRawAccessor)var5).copyStreamDataIntoDBA(var1);
               }
            }
         }
      }

   }

   void allocateNioBuffersIfRequired(int var1, int var2, int var3) throws SQLException {
      if (this.nioBuffers == null) {
         this.nioBuffers = new ByteBuffer[4];
      }

      if (var2 > 0) {
         if (this.nioBuffers[0] != null && this.nioBuffers[0].capacity() >= var2) {
            if (this.nioBuffers[0] != null) {
               this.nioBuffers[0].rewind();
            }
         } else {
            this.nioBuffers[0] = ByteBuffer.allocateDirect(var2);
         }
      }

      var1 *= 2;
      if (var1 > 0) {
         if (this.nioBuffers[1] != null && this.nioBuffers[1].capacity() >= var1) {
            if (this.nioBuffers[1] != null) {
               this.nioBuffers[1].rewind();
            }
         } else {
            this.nioBuffers[1] = ByteBuffer.allocateDirect(var1);
         }
      }

      var3 *= 2;
      if (var3 > 0) {
         if (this.nioBuffers[2] != null && this.nioBuffers[2].capacity() >= var3) {
            if (this.nioBuffers[2] != null) {
               this.nioBuffers[2].rewind();
            }
         } else {
            this.nioBuffers[2] = ByteBuffer.allocateDirect(var3);
         }
      }

   }

   void doDefineExecuteFetch() throws SQLException {
      short[] var1 = null;
      if (this.needToPrepareDefineBuffer || this.needToParse) {
         this.setupForDefine();
         var1 = this.t2cConnection.queryMetaData1;
      }

      this.t2cOutput[0] = 0L;
      this.t2cOutput[2] = 0L;
      byte[] var2 = this.sqlObject.getSqlBytes(this.processEscapes, this.convertNcharLiterals);
      this.t2cOutput[5] = (long)(this.connection.useNio ? 1 : 0);
      this.t2cOutput[6] = (long)this.defaultLobPrefetchSize;
      this.t2cOutput[7] = (long)(this.t2cConnection.useOCIDefaultDefines ? 1 : 0);
      if (this.connection.useNio) {
         this.resetNioAttributesBeforeFetch();
         this.allocateNioBuffersIfRequired(this.defineChars == null ? 0 : this.defineChars.length, this.defineBytes == null ? 0 : this.defineBytes.length, this.defineIndicators == null ? 0 : this.defineIndicators.length);
      }

      if (this.lobPrefetchMetaData == null) {
         this.lobPrefetchMetaData = this.getLobPrefetchMetaData();
      }

      int var3 = this.getRowsToFetch();

      assert var3 > 0 : "rowsToFetch < 1 (rowsToFetch=" + var3 + ", maxRows=" + this.maxRows + ", rowPrefetch=" + this.rowPrefetch + ", savedRowPrefetch=" + this.savedRowPrefetch + ")";

      this.validRows = 0;

      try {
         this.resetStateBeforeFetch();
         this.validRows = T2CStatement.t2cDefineExecuteFetch(this, this.c_state, this.numberOfDefinePositions, this.numberOfBindPositions, this.numberOfBindRowsAllocated, this.firstRowInBatch, this.currentRowBindAccessors != null, this.needToParse, var2, var2.length, T2CStatement.convertSqlKindEnumToByte(this.sqlKind), var3, this.batch, this.bindIndicators, this.bindIndicatorOffset, this.bindBytes, this.bindChars, this.bindByteOffset, this.bindCharOffset, var1, this.t2cConnection.queryMetaData2, this.t2cConnection.queryMetaData1Offset, this.t2cConnection.queryMetaData2Offset, this.preparedByteBinds, this.preparedCharBinds, this.outBindAccessors, this.parameterDatum, this.t2cOutput, this.nioBuffers, this.lobPrefetchMetaData);
         if (this.bindIndicators != null) {
            this.setLengthForOutAccessors();
         }
      } catch (IOException var6) {
         this.validRows = 0;
         SQLException var5 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), var6);
         var5.fillInStackTrace();
         throw var5;
      }

      if (this.validRows == -1) {
         this.t2cConnection.checkError(this.validRows);
      }

      if (this.t2cOutput[2] != 0L) {
         this.sqlWarning = this.t2cConnection.checkError(1, this.sqlWarning);
      }

      this.connection.endToEndECIDSequenceNumber = (short)((int)this.t2cOutput[4]);
      if (this.connection.useNio && (this.validRows > 0 || this.validRows == -2)) {
         this.extractNioDefineBuffers(0);
      }

      if (this.isFetchStreams && this.validRows == -2) {
         this.copyStreamDataIntoDBA(0);
      }

      if (this.lobPrefetchMetaData != null) {
         this.processLobPrefetchMetaData(this.lobPrefetchMetaData);
      }

      this.isComplete = var3 < 1 || this.validRows >= 0 && this.validRows < var3;
      this.needToParse = false;
   }

   protected void fetch(int var1, boolean var2) throws SQLException {
      this.needToRetainRows = var2;
      int var3 = this.getRowsToFetch();

      assert var3 > 0 : "rowsToFetch < 1 (rowsToFetch=" + var3 + ", maxRows=" + this.maxRows + ", rowPrefetch=" + this.rowPrefetch + ", savedRowPrefetch=" + this.savedRowPrefetch + ")";

      this.validRows = 0;
      if (var3 > 0 && this.numberOfDefinePositions > 0) {
         if (this.needToPrepareDefineBuffer) {
            this.doDefineFetch();
            this.needToPrepareDefineBuffer = false;
         } else {
            this.t2cOutput[2] = 0L;
            this.t2cOutput[5] = (long)(this.connection.useNio ? 1 : 0);
            this.t2cOutput[6] = (long)this.defaultLobPrefetchSize;
            if (this.connection.useNio) {
               this.resetNioAttributesBeforeFetch();
               this.allocateNioBuffersIfRequired(this.defineChars == null ? 0 : this.defineChars.length, this.defineBytes == null ? 0 : this.defineBytes.length, this.defineIndicators == null ? 0 : this.defineIndicators.length);
            }

            if (this.lobPrefetchMetaData == null) {
               this.lobPrefetchMetaData = this.getLobPrefetchMetaData();
            }

            this.resetStateBeforeFetch();
            this.validRows = T2CStatement.t2cFetch(this, this.c_state, this.needToPrepareDefineBuffer, var3, this.accessors, this.t2cOutput, this.nioBuffers, this.lobPrefetchMetaData);
            if (this.validRows == -1 || this.validRows == -4) {
               this.t2cConnection.checkError(this.validRows);
            }

            if (this.t2cOutput[2] != 0L) {
               this.sqlWarning = this.t2cConnection.checkError(1, this.sqlWarning);
            }

            if (this.lobPrefetchMetaData != null) {
               this.processLobPrefetchMetaData(this.lobPrefetchMetaData);
            }

            if (this.connection.useNio && (this.validRows > 0 || this.validRows == -2)) {
               this.extractNioDefineBuffers(0);
            }

            if (this.isFetchStreams && this.validRows == -2) {
               this.copyStreamDataIntoDBA(var1);
            }
         }
      }

      this.isComplete = var3 < 1 || this.validRows >= 0 && this.validRows < var3;
      this.needToRetainRows = false;
   }

   void resetNioAttributesBeforeFetch() {
      this.extractedCharOffset = 0;
      this.extractedByteOffset = 0;
   }

   void extractNioDefineBuffers(int var1) throws SQLException {
      if (this.accessors != null && this.defineIndicators != null && var1 != this.numberOfDefinePositions) {
         int var2 = 0;
         int var3 = 0;
         int var4 = 0;
         int var5 = 0;
         int var6 = 0;
         if (!this.hasStream) {
            var2 = this.defineBytes != null ? this.defineBytes.length : 0;
            var3 = this.defineChars != null ? this.defineChars.length : 0;
            var4 = this.defineIndicators.length;
         } else {
            if (this.numberOfDefinePositions > var1) {
               var6 = this.accessors[var1].indicatorIndex;
               var5 = this.accessors[var1].lengthIndex;
            }

            int var7 = var1;

            label61:
            while(var7 < this.numberOfDefinePositions) {
               switch(this.accessors[var7].internalType) {
               case 8:
               case 24:
                  break label61;
               default:
                  var2 += this.accessors[var7].byteLength;
                  var3 += this.accessors[var7].charLength;
                  ++var4;
                  ++var7;
               }
            }
         }

         ByteBuffer var9 = this.nioBuffers[0];
         if (var9 != null && this.defineBytes != null && var2 > 0) {
            var9.position(this.extractedByteOffset);
            var9.get(this.defineBytes, this.extractedByteOffset, var2);
            this.extractedByteOffset += var2;
         }

         if (this.nioBuffers[1] != null && this.defineChars != null) {
            var9 = this.nioBuffers[1].order(ByteOrder.LITTLE_ENDIAN);
            CharBuffer var8 = var9.asCharBuffer();
            if (var3 > 0) {
               var8.position(this.extractedCharOffset);
               var8.get(this.defineChars, this.extractedCharOffset, var3);
               this.extractedCharOffset += var3;
            }
         }

         if (this.nioBuffers[2] != null) {
            var9 = this.nioBuffers[2].order(ByteOrder.LITTLE_ENDIAN);
            ShortBuffer var10 = var9.asShortBuffer();
            if (this.hasStream) {
               if (var4 > 0) {
                  var10.position(var6);
                  var10.get(this.defineIndicators, var6, var4);
                  var10.position(var5);
                  var10.get(this.defineIndicators, var5, var4);
               }
            } else {
               var10.get(this.defineIndicators);
            }
         }

      }
   }

   void doClose() throws SQLException {
      if (this.defineBytes != null) {
         this.defineBytes = null;
      }

      if (this.defineChars != null) {
         this.defineChars = null;
      }

      if (this.defineIndicators != null) {
         this.defineIndicators = null;
      }

      int var1 = T2CStatement.t2cCloseStatement(this.c_state);
      this.nioBuffers = null;
      if (var1 != 0) {
         this.t2cConnection.checkError(var1);
      }

      this.t2cOutput = null;
   }

   void closeQuery() throws SQLException {
      this.connection.registerHeartbeat();
      this.connection.needLine();
      if (this.streamList != null) {
         for(; this.nextStream != null; this.nextStream = this.nextStream.nextStream) {
            try {
               this.nextStream.close();
            } catch (IOException var3) {
               SQLException var2 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), var3);
               var2.fillInStackTrace();
               throw var2;
            }
         }
      }

   }

   void closeUsedStreams(int var1) throws SQLException {
      SQLException var3;
      for(; this.nextStream != null && this.nextStream.columnIndex < 1 + this.offsetOfFirstUserColumn + var1; this.nextStream = this.nextStream.nextStream) {
         try {
            this.nextStream.close();
         } catch (IOException var4) {
            var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), var4);
            var3.fillInStackTrace();
            throw var3;
         }
      }

      if (this.nextStream != null) {
         try {
            this.nextStream.needBytes();
         } catch (IOException var5) {
            this.interalCloseOnIOException(var5);
            var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), var5);
            var3.fillInStackTrace();
            throw var3;
         }
      }

   }

   void interalCloseOnIOException(IOException var1) throws SQLException {
      this.closed = true;
      if (this.currentResultSet != null) {
         this.currentResultSet.closed = true;
      }

      this.doClose();
   }

   void fetchDmlReturnParams() throws SQLException {
      this.rowsDmlReturned = T2CStatement.t2cGetRowsDmlReturned(this.c_state);
      if (this.rowsDmlReturned != 0) {
         this.allocateDmlReturnStorage();
         this.resetStateBeforeFetch();
         int var1 = T2CStatement.t2cFetchDmlReturnParams(this.c_state, this, this.accessors, this.returnParamBytes, this.returnParamChars, this.returnParamIndicators);
         if (var1 == -1 || var1 == -4) {
            this.t2cConnection.checkError(var1);
         }

         if (this.t2cOutput[2] != 0L) {
            this.sqlWarning = this.t2cConnection.checkError(1, this.sqlWarning);
         }

         if (this.connection.useNio && (var1 > 0 || var1 == -2)) {
            this.extractNioDefineBuffers(0);
         }
      }

      AggregateByteArray var14 = (AggregateByteArray)this.bindData;
      if (this.returnParamBytes != null) {
         var14.setBytes(this.returnParamBytes);
      }

      ((T2CCharByteArray)var14.extension).setChars(this.returnParamChars);
      ((T2CCharByteArray)var14.extension).setDBConversion(this.connection.conversion);
      int var2 = this.returnParamBytes == null ? 0 : this.returnParamBytes.length;
      int var3 = 0;
      int var4 = this.numReturnParams * this.rowsDmlReturned;
      int var5 = 0;
      int var6 = var2;
      int var7 = 0;

      for(int var8 = 0; var8 < this.numberOfBindPositions; ++var8) {
         Accessor var9 = this.accessors[var8];
         if (var9 != null) {
            var9.setCapacity(this.rowsDmlReturned);

            for(int var10 = 0; var10 < this.rowsDmlReturned; ++var10) {
               if (var9.internalType != 109 && var9.internalType != 111) {
                  int var11 = this.returnParamIndicators[var4++];
                  boolean var12 = this.returnParamIndicators[var3++] == -1;
                  byte var13 = 0;
                  if (var9.internalType == 104) {
                     var13 = 2;
                  } else if (var9.defineType == 6 || var9.defineType == 9 || var9.defineType == 1) {
                     var13 = 1;
                  }

                  if (var9.charLength > 0) {
                     var9.setOffset(var10, (long)(var6 + var13));
                     var6 += var9.charLength;
                  } else {
                     var9.setOffset(var10, (long)(var5 + var13));
                     var5 += var9.byteLength;
                  }

                  if (!var12 && var11 != 0) {
                     if (var9.internalType == 1) {
                        var11 /= 2;
                     }

                     var9.setLengthAndNull(var10, var11);
                  } else {
                     var9.setLengthAndNull(var10, 0);
                  }
               } else {
                  ++var7;
               }
            }
         }
      }

      this.returnParamsFetched = true;
   }

   void processDmlReturningBind() throws SQLException {
      super.processDmlReturningBind();
      this.returnParamRowBytes = 0;
      this.returnParamRowChars = 0;

      for(int var1 = 0; var1 < this.numberOfBindPositions; ++var1) {
         Accessor var2 = this.accessors[var1];
         if (var2 != null) {
            if (var2.charLength > 0) {
               this.returnParamRowChars += var2.charLength;
            } else {
               this.returnParamRowBytes += var2.byteLength;
            }
         }
      }

      this.returnParamMeta[1] = this.returnParamRowBytes;
      this.returnParamMeta[2] = this.returnParamRowChars;
   }

   void allocateDmlReturnStorage() {
      if (this.rowsDmlReturned != 0) {
         int var1 = this.returnParamRowBytes * this.rowsDmlReturned;
         int var2 = this.returnParamRowChars * this.rowsDmlReturned;
         int var3 = 2 * this.numReturnParams * this.rowsDmlReturned;
         this.returnParamBytes = new byte[var1];
         this.returnParamChars = new char[var2];
         this.returnParamIndicators = new short[var3];

         for(int var4 = 0; var4 < this.numberOfBindPositions; ++var4) {
            Accessor var5 = this.accessors[var4];
            if (var5 != null) {
               var5.setCapacity(this.rowsDmlReturned);
            }
         }

      }
   }

   void cleanupReturnParameterBuffers() {
      this.returnParamBytes = null;
      this.returnParamChars = null;
      this.returnParamIndicators = null;
   }

   void initializeIndicatorSubRange() {
      this.bindIndicatorSubRange = this.numberOfBindPositions * PREAMBLE_PER_POSITION;
   }

   int calculateIndicatorSubRangeSize() {
      return this.numberOfBindPositions * PREAMBLE_PER_POSITION;
   }

   short getInoutIndicator(int var1) {
      return this.bindIndicators[var1 * PREAMBLE_PER_POSITION];
   }

   void resetStateBeforeFetch() {
      this.lastProcessedCell = 0;
      this.lastProcessedAccessorIndex = 0;
      this.accessorsProcessed = 0;
      this.previousMode = 0;
      if (this.rowData != null) {
         if (this.needToRetainRows) {
            this.rowData.setPosition(this.rowData.length());
         } else {
            this.rowData.reset();
         }
      }

   }

   public int updateData(int var1, int var2, int var3, int[] var4, byte[] var5) {
      try {
         if (this.previousMode != var1) {
            this.accessorsProcessed = 0;
         }

         this.previousMode = var1;
         int var6 = 0;
         boolean var7 = false;
         boolean var8 = false;
         boolean var9 = false;
         boolean var10 = false;
         int var18;
         int var19;
         int var20;
         int var21;
         switch(var1) {
         case 16:
         case 32:
            for(var21 = 0; var21 < var2; ++var21) {
               var18 = var4[var21 * 4 + 0];
               var19 = var4[var21 * 4 + 1];
               var20 = var4[var21 * 4 + 2];
               var10 = var4[var21 * 4 + 3] == -1;
               Accessor var22 = this.accessors[var19];
               var22.setOffset((this.needToRetainRows ? this.storedRowCount : 0) + var18);
               if (var20 > 0) {
                  switch(var22.defineType) {
                  case 1:
                  case 23:
                  case 96:
                  case 104:
                     var6 += 2;
                     var20 -= 2;
                     break;
                  case 6:
                     ++var6;
                     --var20;
                  }

                  this.rowData.put(var5, var6, var20);
                  var6 += var20;
               }

               var22.setLengthAndNull((this.needToRetainRows ? this.storedRowCount : 0) + var18, var20);
               ++this.accessorsProcessed;
               ++this.lastProcessedCell;
            }

            return 0;
         case 64:
            boolean var11 = false;
            Accessor[] var12 = null;
            if (this.outBindAccessors != null) {
               var21 = (this.bindBytes == null ? 0 : this.bindBytes.length) + (this.bindChars == null ? 0 : this.bindChars.length) + (this.ibtBindBytes == null ? 0 : this.ibtBindBytes.length) + (this.ibtBindChars == null ? 0 : this.ibtBindChars.length);
               var12 = this.outBindAccessors;
            } else {
               var21 = (this.returnParamBytes == null ? 0 : this.returnParamBytes.length) + (this.returnParamChars == null ? 0 : this.returnParamChars.length) + (this.ibtBindBytes == null ? 0 : this.ibtBindBytes.length) + (this.ibtBindChars == null ? 0 : this.ibtBindChars.length);
               var12 = this.accessors;
            }

            assert var12 != null : "No OUT binds or Return Parameters";

            ByteArray var13 = this.bindData;

            while(var13 instanceof AggregateByteArray) {
               var13 = ((AggregateByteArray)var13).extension;
               if (var13 == null) {
                  break;
               }
            }

            var21 = (int)((long)var21 + var13.getPosition());
            int var14 = this.accessorsProcessed;

            for(int var15 = 0; var15 < var2; ++var15) {
               var18 = var4[var15 * 4 + 0];
               var19 = var4[var15 * 4 + 1];
               var20 = var4[var15 * 4 + 2];
               var10 = var4[var15 * 4 + 3] == -1;
               Accessor var16 = var12[var19];
               var16.setOffset((this.needToRetainRows ? this.storedRowCount : 0) + var18, (long)var21);
               var13.put(var5, var6, var20);
               var16.setLengthAndNull((this.needToRetainRows ? this.storedRowCount : 0) + var18, var20);
               var6 += var20;
               var21 += var20;
               ++this.lastProcessedCell;
            }
         }

         return 0;
      } catch (SQLException var17) {
         this.updateDataException = var17;
         return -3;
      }
   }

   final boolean bit(long var1, long var3) {
      return (var1 & var3) == var1;
   }

   public static String toHex(byte[] var0, int var1) {
      if (var0 == null) {
         return "null";
      } else if (var1 > var0.length) {
         return "byte array not long enough";
      } else {
         String var2 = "0:";
         int var3 = var1;

         for(int var4 = 0; var4 < var3; ++var4) {
            if (var4 != 0 && var4 % 10 == 0) {
               var2 = var2 + "\n" + var4 + ": ";
            }

            var2 = var2 + OracleLog.toHex(var0[var4]) + " ";
         }

         return var2;
      }
   }

   Accessor allocateAccessor(int var1, int var2, int var3, int var4, short var5, String var6, boolean var7) throws SQLException {
      T2CResultSetAccessor var8 = null;
      SQLException var9;
      switch(var1) {
      case 1:
         if (var7) {
            if (var6 != null) {
               var9 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 12, "sqlType=" + var2);
               var9.fillInStackTrace();
               throw var9;
            }

            T2CVarcharAccessor var10 = new T2CVarcharAccessor(this, var4, var5, var2, var7);
            return var10;
         }
      default:
         return super.allocateAccessor(var1, var2, var3, var4, var5, var6, var7);
      case 8:
         if (var7 && var6 != null) {
            var9 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 12, "sqlType=" + var2);
            var9.fillInStackTrace();
            throw var9;
         } else {
            if (var7) {
               return new VarcharAccessor(this, var4, var5, var2, var7);
            }

            return new T2CLongAccessor(this, var3, var4, var5, var2);
         }
      case 24:
         if (var7 && var6 != null) {
            var9 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 12, "sqlType=" + var2);
            var9.fillInStackTrace();
            throw var9;
         } else {
            if (var7) {
               return new OutRawAccessor(this, var4, var5, var2);
            }

            return new T2CLongRawAccessor(this, var3, var4, var5, var2);
         }
      case 102:
      case 116:
         if (var7 && var6 != null) {
            var9 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 12, "sqlType=" + var2);
            var9.fillInStackTrace();
            throw var9;
         } else {
            var8 = new T2CResultSetAccessor(this, var4, var5, var2, var7);
            return var8;
         }
      }
   }

   void prepareBindPreambles(int var1, int var2) {
      int var3 = this.calculateIndicatorSubRangeSize();
      int var4 = this.bindIndicatorSubRange - var3;
      OracleTypeADT[] var5 = this.parameterOtype == null ? null : this.parameterOtype[this.firstRowInBatch];

      for(int var6 = 0; var6 < this.numberOfBindPositions; ++var6) {
         Binder var8 = this.lastBinders[var6];
         short var7;
         OracleTypeADT var9;
         if (var8 == this.theReturnParamBinder) {
            var9 = (OracleTypeADT)this.accessors[var6].internalOtype;
            var7 = 0;
         } else {
            var9 = var5 == null ? null : var5[var6];
            byte var12;
            if (this.outBindAccessors == null) {
               var12 = 0;
            } else {
               Accessor var10 = this.outBindAccessors[var6];
               if (var10 == null) {
                  var12 = 0;
               } else if (var8 == this.theOutBinder) {
                  var12 = 1;
                  if (var9 == null) {
                     var9 = (OracleTypeADT)var10.internalOtype;
                  }
               } else {
                  var12 = 2;
               }
            }

            var7 = var8.updateInoutIndicatorValue(var12);
         }

         this.bindIndicators[var4++] = var7;
         if (var9 != null) {
            long var13 = var9.getTdoCState();
            this.bindIndicators[var4 + 0] = (short)((int)(var13 >> 48 & 65535L));
            this.bindIndicators[var4 + 1] = (short)((int)(var13 >> 32 & 65535L));
            this.bindIndicators[var4 + 2] = (short)((int)(var13 >> 16 & 65535L));
            this.bindIndicators[var4 + 3] = (short)((int)(var13 & 65535L));
         }

         var4 += 4;
      }

   }

   void releaseBuffers() {
      super.releaseBuffers();
   }

   void setLengthForOutAccessors() throws SQLException {
      if (this.outBindAccessors != null) {
         Accessor var1 = null;

         for(int var2 = 0; var2 < this.numberOfBindPositions; ++var2) {
            var1 = this.outBindAccessors[var2];
            if (var1 != null && var1.defineType != 998 && var1.defineType != 111 && var1.defineType != 109) {
               for(int var3 = 0; var3 < this.binders.length; ++var3) {
                  boolean var4 = var1.rowSpaceIndicator[var1.indicatorIndex + var3] == -1;
                  int var5 = var4 ? 0 : var1.rowSpaceIndicator[var1.lengthIndex + var3] & '\uffff';
                  if (this.sqlKind != oracle.jdbc.internal.OracleStatement.SqlKind.CALL_BLOCK && var1.externalType == -8) {
                     var1.setLengthAndNull(var3, var5);
                  } else if (var1.defineType != 9 && var1.defineType != 1) {
                     if (var1.defineType != 109 && var1.defineType != 111) {
                        var1.setLengthAndNull(var3, var5);
                     }
                  } else {
                     var1.setLengthAndNull(var3, var5 / 2);
                  }
               }
            }
         }

      }
   }

   void doDescribe(boolean var1) throws SQLException {
      if (this.closed) {
         SQLException var5 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9);
         var5.fillInStackTrace();
         throw var5;
      } else if (!this.described) {
         if (!this.isOpen) {
            this.connection.open(this);
            this.isOpen = true;
         }

         boolean var2;
         do {
            var2 = false;
            boolean var3 = this.sqlKind.isSELECT() && this.needToParse && (!this.described || !this.serverCursor);
            byte[] var4 = var3 ? this.sqlObject.getSqlBytes(this.processEscapes, this.convertNcharLiterals) : PhysicalConnection.EMPTY_BYTE_ARRAY;
            this.numberOfDefinePositions = T2CStatement.t2cDescribe(this.c_state, this.t2cConnection.queryMetaData1, this.t2cConnection.queryMetaData2, this.t2cConnection.queryMetaData1Offset, this.t2cConnection.queryMetaData2Offset, this.t2cConnection.queryMetaData1Size, this.t2cConnection.queryMetaData2Size, var4, var4.length, var3);
            if (!this.described) {
               this.described = true;
            }

            if (this.numberOfDefinePositions == -1) {
               this.t2cConnection.checkError(this.numberOfDefinePositions);
            }

            if (this.numberOfDefinePositions == T2C_EXTEND_BUFFER) {
               var2 = true;
               this.t2cConnection.reallocateQueryMetaData(this.t2cConnection.queryMetaData1Size * 2, this.t2cConnection.queryMetaData2Size * 2);
            }
         } while(var2);

         this.processDescribeData();
      }
   }

   protected void configureRowData() {
      super.configureRowData();
      DynamicByteArray var1 = DynamicByteArray.createDynamicByteArray(super.connection.getBlockSource());
      T2CCharByteArray var2 = new T2CCharByteArray(PhysicalConnection.EMPTY_CHAR_ARRAY, var1);
      AggregateByteArray var3 = new AggregateByteArray(PhysicalConnection.EMPTY_BYTE_ARRAY, var2);
      T2CCharByteArray var4 = new T2CCharByteArray(PhysicalConnection.EMPTY_CHAR_ARRAY, var3);
      this.bindData = new AggregateByteArray(PhysicalConnection.EMPTY_BYTE_ARRAY, var4);
   }

   void registerOutParameterInternal(int var1, int var2, int var3, int var4, String var5) throws SQLException {
      int var6 = var1 - 1;
      if (var6 >= 0 && var1 <= this.numberOfBindPositions) {
         int var9 = this.getInternalType(var2);
         if (var9 == 995) {
            SQLException var8 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 4);
            var8.fillInStackTrace();
            throw var8;
         } else {
            this.resetBatch();
            this.currentRowNeedToPrepareBinds = true;
            if (this.currentRowBindAccessors == null) {
               this.currentRowBindAccessors = new Accessor[this.numberOfBindPositions];
            }

            switch(var2) {
            case -16:
            case -15:
            case -9:
               this.currentRowFormOfUse[var6] = 2;
            case -4:
            case -3:
            case -1:
            case 1:
            case 12:
            case 70:
               break;
            case 2009:
               var4 = 0;
               var5 = "SYS.XMLTYPE";
               break;
            case 2011:
               var4 = 0;
               this.currentRowFormOfUse[var6] = 2;
               break;
            default:
               var4 = 0;
            }

            this.currentRowBindAccessors[var6] = this.allocateAccessor(var9, var2, var1, var4, this.currentRowFormOfUse[var6], var5, true);
            this.currentRowBindAccessors[var6].setCapacity(1);
         }
      } else {
         SQLException var7 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 3);
         var7.fillInStackTrace();
         throw var7;
      }
   }

   Accessor allocateIndexTableAccessor(PlsqlIbtBindInfo var1, short var2) throws SQLException {
      return new T2CPlsqlIndexTableAccessor(this, var1, var2);
   }
}
