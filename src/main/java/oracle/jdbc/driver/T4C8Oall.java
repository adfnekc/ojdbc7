package oracle.jdbc.driver;

import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.ArrayDeque;
import java.util.Properties;
import java.util.Vector;
import oracle.jdbc.internal.KeywordValue;
import oracle.jdbc.oracore.OracleTypeADT;

final class T4C8Oall extends T4CTTIfun {
   Vector nonFatalIOExceptions = null;
   static final byte[] EMPTY_BYTES = new byte[0];
   static final int UOPF_PRS = 1;
   static final int UOPF_BND = 8;
   static final int UOPF_EXE = 32;
   static final int UOPF_FEX = 512;
   static final int UOPF_FCH = 64;
   static final int UOPF_CAN = 128;
   static final int UOPF_COM = 256;
   static final int UOPF_DSY = 8192;
   static final int UOPF_SIO = 1024;
   static final int UOPF_NPL = 32768;
   static final int UOPF_DFN = 16;
   static final int UOPF_NCF = 262144;
   static final int EXE_COMMIT_ON_SUCCESS = 1;
   static final int EXE_LEAVE_CUR_MAPPED = 2;
   static final int EXE_BATCH_DML_ERRORS = 4;
   static final int EXE_SCROL_READ_ONLY = 8;
   static final int AL8EX_GET_PIDMLRC = 16384;
   static final int AL8KW_MAXLANG = 63;
   static final int AL8KW_TIMEZONE = 163;
   static final int AL8KW_ERR_OVLAP = 164;
   static final int AL8KW_SESSION_ID = 165;
   static final int AL8KW_SERIAL_NUM = 166;
   static final int AL8KW_TAG_FOUND = 167;
   static final int AL8KW_SCHEMA_NAME = 168;
   static final int AL8KW_SCHEMA_ID = 169;
   static final int AL8KW_ENABLED_ROLES = 170;
   static final int AL8KW_AUX_SESSSTATE = 171;
   static final int AL8KW_OPENCURSORS = 175;
   static final int AL8KW_PDBUID = 176;
   static final int AL8KW_DBID = 177;
   static final int AL8KW_GUDBID = 178;
   static final int AL8KW_DBNAME = 179;
   static final String[] NLS_KEYS = new String[]{"AUTH_NLS_LXCCURRENCY", "AUTH_NLS_LXCISOCURR", "AUTH_NLS_LXCNUMERICS", null, null, null, null, "AUTH_NLS_LXCDATEFM", "AUTH_NLS_LXCDATELANG", "AUTH_NLS_LXCTERRITORY", "SESSION_NLS_LXCCHARSET", "AUTH_NLS_LXCSORT", "AUTH_NLS_LXCCALENDAR", null, null, null, "AUTH_NLS_LXLAN", null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, "AUTH_NLS_LXCSORT", null, "AUTH_NLS_LXCUNIONCUR", null, null, null, null, "AUTH_NLS_LXCTIMEFM", "AUTH_NLS_LXCSTMPFM", "AUTH_NLS_LXCTTZNFM", "AUTH_NLS_LXCSTZNFM", "SESSION_NLS_LXCNLSLENSEM", "SESSION_NLS_LXCNCHAREXCP", "SESSION_NLS_LXCNCHARIMP"};
   static final int LDIREGIDFLAG = 120;
   static final int LDIREGIDSET = 181;
   static final int LDIMAXTIMEFIELD = 60;
   static final int AL8EX_IMPL_RESULTS_CLIENT = 32768;
   int rowsProcessed;
   int numberOfDefinePositions;
   long options;
   int cursor;
   byte[] sqlStmt = new byte[0];
   final long[] al8i4 = new long[13];
   boolean plsql = false;
   Accessor[] definesAccessors;
   int definesLength;
   Accessor[] outBindAccessors;
   int numberOfBindPositions;
   InputStream[][] parameterStream;
   byte[][][] parameterDatum;
   OracleTypeADT[][] parameterOtype;
   short[] bindIndicators;
   byte[] bindBytes;
   char[] bindChars;
   int bindIndicatorSubRange;
   byte[] tmpBindsByteArray;
   DBConversion conversion;
   byte[] ibtBindBytes;
   char[] ibtBindChars;
   short[] ibtBindIndicators;
   boolean sendBindsDefinition = false;
   OracleStatement oracleStatement;
   short dbCharSet;
   short NCharSet;
   T4CTTIrxd rxd;
   T4C8TTIrxh rxh;
   T4CTTIdcb dcb;
   T4CTTIimplres implres;
   oracle.jdbc.internal.OracleStatement.SqlKind typeOfStatement;
   int defCols = 0;
   int rowsToFetch;
   boolean aFetchWasDone = false;
   T4CTTIoac[] oacdefBindsSent;
   T4CTTIoac[] oacdefDefines;
   int[] definedColumnSize;
   int[] definedColumnType;
   int[] definedColumnFormOfUse;
   NTFDCNRegistration registration = null;
   static final int AL8TXCUR = 1;
   static final int AL8TXDON = 2;
   static final int AL8TXRON = 4;
   private static final String _Copyright_2007_Oracle_All_Rights_Reserved_ = null;
   public static final String BUILD_DATE = "Thu_Apr_04_15:09:24_PDT_2013";
   public static final boolean TRACE = false;

   T4C8Oall(T4CConnection var1) {
      super(var1, (byte)3);
      this.setFunCode((short)94);
      this.rxh = new T4C8TTIrxh(var1);
      this.rxd = new T4CTTIrxd(var1);
      this.dcb = new T4CTTIdcb(var1);
      this.implres = new T4CTTIimplres(var1);
   }

   void doOALL(boolean var1, boolean var2, boolean var3, boolean var4, boolean var5, oracle.jdbc.internal.OracleStatement.SqlKind var6, int var7, byte[] var8, int var9, Accessor[] var10, int var11, Accessor[] var12, int var13, byte[] var14, char[] var15, short[] var16, int var17, DBConversion var18, byte[] var19, InputStream[][] var20, byte[][][] var21, OracleTypeADT[][] var22, OracleStatement var23, byte[] var24, char[] var25, short[] var26, T4CTTIoac[] var27, int[] var28, int[] var29, int[] var30, NTFDCNRegistration var31) throws SQLException, IOException {
      this.typeOfStatement = var6;
      this.cursor = var7;
      this.sqlStmt = var1 ? var8 : EMPTY_BYTES;
      this.rowsToFetch = var9;
      this.outBindAccessors = var10;
      this.numberOfBindPositions = var11;
      this.definesAccessors = var12;
      this.definesLength = var13;
      this.bindBytes = var14;
      this.bindChars = var15;
      this.bindIndicators = var16;
      this.bindIndicatorSubRange = var17;
      this.conversion = var18;
      this.tmpBindsByteArray = var19;
      this.parameterStream = var20;
      this.parameterDatum = var21;
      this.parameterOtype = var22;
      this.oracleStatement = var23;
      this.ibtBindBytes = var24;
      this.ibtBindChars = var25;
      this.ibtBindIndicators = var26;
      this.oacdefBindsSent = var27;
      this.definedColumnType = var28;
      this.definedColumnSize = var29;
      this.definedColumnFormOfUse = var30;
      this.registration = var31;
      this.dbCharSet = var18.getServerCharSetId();
      this.NCharSet = var18.getNCharSetId();
      int var32 = 0;
      if (this.bindIndicators != null) {
         var32 = ((this.bindIndicators[this.bindIndicatorSubRange + 3] & '\uffff') << 16) + (this.bindIndicators[this.bindIndicatorSubRange + 4] & '\uffff');
      }

      SQLException var40;
      if (var8 == null) {
         var40 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 431);
         var40.fillInStackTrace();
         throw var40;
      } else if (!this.typeOfStatement.isDML() && var32 > 1) {
         var40 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 433);
         var40.fillInStackTrace();
         throw var40;
      } else {
         this.rowsProcessed = 0;
         this.options = 0L;
         this.plsql = this.typeOfStatement.isPlsqlOrCall();
         this.sendBindsDefinition = false;
         if (this.receiveState != 0) {
            this.receiveState = 0;
         }

         this.rxh.init();
         this.rxd.init();
         this.oer.init();
         if (var5) {
            this.initDefinesDefinition();
         }

         if (this.numberOfBindPositions > 0 && this.bindIndicators != null) {
            if (this.oacdefBindsSent == null) {
               this.oacdefBindsSent = new T4CTTIoac[this.numberOfBindPositions];
            }

            this.sendBindsDefinition = this.initBindsDefinition(this.oacdefBindsSent);
         }

         this.options = this.setOptions(var1, var2, var3, var5);
         if ((this.options & 1L) > 0L) {
            this.al8i4[0] = 1L;
         } else {
            this.al8i4[0] = 0L;
         }

         if (!this.plsql && !this.typeOfStatement.isOTHER()) {
            if (var4) {
               if (var3 && this.oracleStatement.isFetchStreams) {
                  this.al8i4[1] = (long)this.rowsToFetch;
               } else {
                  this.al8i4[1] = 0L;
               }
            } else if (this.typeOfStatement.isDML()) {
               this.al8i4[1] = var32 == 0 ? (long)this.oracleStatement.batch : (long)var32;
            } else if (var3 && !var4) {
               this.al8i4[1] = (long)this.rowsToFetch;
            } else {
               this.al8i4[1] = 0L;
            }
         } else {
            this.al8i4[1] = 1L;
         }

         if (this.typeOfStatement.isSELECT()) {
            this.al8i4[7] = 1L;
         } else {
            this.al8i4[7] = 0L;
         }

         long var33 = this.oracleStatement.inScn;
         int var35 = (int)var33;
         int var36 = (int)(var33 >> 32);
         this.al8i4[5] = (long)var35;
         this.al8i4[6] = (long)var36;
         long[] var10000;
         if (this.typeOfStatement.isDML()) {
            var10000 = this.al8i4;
            var10000[9] |= 16384L;
         } else {
            var10000 = this.al8i4;
            var10000[9] &= -16385L;
         }

         this.rowsProcessed = 0;
         this.aFetchWasDone = false;
         this.rxd.setNumberOfColumns(this.definesLength);
         if ((this.options & 64L) != 0L && (this.options & 32L) == 0L && (this.options & 1L) == 0L && (this.options & 8L) == 0L && (this.options & 16L) == 0L && !this.oracleStatement.needToSendOalToFetch) {
            this.setFunCode((short)5);
         } else {
            this.setFunCode((short)94);
         }

         if ((this.options & 32L) != 0L) {
            var10000 = this.al8i4;
            var10000[9] |= 32768L;
         } else {
            var10000 = this.al8i4;
            var10000[9] &= -32769L;
         }

         if (this.getFunCode() == 94) {
            ((T4CConnection)this.oracleStatement.connection).setExecutingRPCSQL(this.oracleStatement.sqlObject.actualSql);
         }

         this.nonFatalIOExceptions = null;
         this.doRPC();
         if ((this.options & 32L) != 0L) {
            this.oracleStatement.inScn = 0L;
         }

         this.ibtBindIndicators = null;
         this.ibtBindChars = null;
         this.ibtBindBytes = null;
         this.tmpBindsByteArray = null;
         this.outBindAccessors = null;
         this.bindBytes = null;
         this.bindChars = null;
         this.bindIndicators = null;
         this.oracleStatement = null;
         this.parameterStream = (InputStream[][])null;
         if (this.nonFatalIOExceptions != null) {
            IOException var37 = (IOException)this.nonFatalIOExceptions.get(0);

            try {
               SQLException var38 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 266);
               var38.fillInStackTrace();
               throw var38;
            } catch (SQLException var39) {
               var39.initCause(var37);
               throw var39;
            }
         }
      }
   }

   void readBVC() throws IOException, SQLException {
      int var1 = this.meg.unmarshalUB2();
      this.rxd.unmarshalBVC(var1);
   }

   void readIOV() throws IOException, SQLException {
      T4CTTIiov var1 = new T4CTTIiov(this.connection, this.rxh, this.rxd);
      var1.init();
      var1.unmarshalV10();
      if (!this.oracleStatement.isDmlReturning && !var1.isIOVectorEmpty()) {
         byte[] var2 = var1.getIOVector();
         this.outBindAccessors = var1.processRXD(this.outBindAccessors, this.numberOfBindPositions, this.bindBytes, this.bindChars, this.bindIndicators, this.bindIndicatorSubRange, this.conversion, this.tmpBindsByteArray, var2, this.parameterStream, this.parameterDatum, this.parameterOtype, this.oracleStatement, (byte[])null, (char[])null, (short[])null);
      }

   }

   void readRXH() throws IOException, SQLException {
      this.rxh.init();
      this.rxh.unmarshalV10(this.rxd);
      SQLException var3;
      if (this.rxh.uacBufLength > 0) {
         var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 405);
         var3.fillInStackTrace();
         throw var3;
      } else if ((this.rxh.rxhflg & 8) == 8) {
         var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 449);
         var3.fillInStackTrace();
         throw var3;
      } else {
         if ((this.rxh.rxhflg & 16) == 16) {
            for(int var1 = 0; var1 < this.definesAccessors.length; ++var1) {
               if (this.definesAccessors[var1].udskpos >= 0 && this.definesAccessors[var1].udskpos != var1) {
                  SQLException var2 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 450);
                  var2.fillInStackTrace();
                  throw var2;
               }
            }
         }

      }
   }

   void processSLG() throws IOException, SQLException {
      this.readRXH();
      int[] var1 = new int[this.numberOfBindPositions];

      for(int var2 = 0; var2 < this.numberOfBindPositions; ++var2) {
         var1[var2] = this.oacdefBindsSent[var2].oacmxl;
      }

      this.nonFatalIOExceptions = this.marshalBinds(var1, true);
   }

   boolean readRXD() throws IOException, SQLException {
      this.aFetchWasDone = true;
      if (this.oracleStatement.isDmlReturning && this.numberOfBindPositions > 0) {
         boolean var1 = false;

         for(int var2 = 0; var2 < this.oracleStatement.numberOfBindPositions; ++var2) {
            Accessor var3 = this.oracleStatement.accessors[var2];
            if (var3 != null) {
               int var4 = (int)this.meg.unmarshalUB4();
               this.oracleStatement.increaseCapacity(var4);
               this.oracleStatement.rowsDmlReturned = var4;

               for(int var5 = 0; var5 < var4; ++var5) {
                  var3.unmarshalOneRow();
               }
            }
         }

         this.oracleStatement.returnParamsFetched = true;
      } else if (this.iovProcessed || this.outBindAccessors != null && this.definesAccessors == null) {
         if (this.rxd.unmarshal(this.outBindAccessors, this.numberOfBindPositions)) {
            return true;
         }
      } else if (this.rxd.unmarshal(this.definesAccessors, this.definesLength)) {
         return true;
      }

      return false;
   }

   void readRPA() throws IOException, SQLException {
      int var1 = this.meg.unmarshalUB2();
      int[] var2 = new int[var1];

      int var3;
      for(var3 = 0; var3 < var1; ++var3) {
         var2[var3] = (int)this.meg.unmarshalUB4();
      }

      var3 = var2[0];
      int var4 = var2[1];
      long var5 = (long)var3 & 4294967295L | ((long)var4 & 4294967295L) << 32;
      if (var5 != 0L) {
         this.oracleStatement.connection.outScn = var5;
      }

      this.cursor = var2[2];
      int var7 = this.meg.unmarshalUB2();
      Object var8 = null;
      if (var7 > 0) {
         this.meg.unmarshalNBytes(var7);
      }

      int var9 = this.meg.unmarshalUB2();
      KeywordValue[] var10 = new KeywordValue[var9];

      int var11;
      for(var11 = 0; var11 < var9; ++var11) {
         var10[var11] = KeywordValueI.unmarshal(this.meg);
      }

      this.connection.updateSessionProperties(var10);
      this.oracleStatement.dcnQueryId = -1L;
      this.oracleStatement.dcnTableName = null;
      if (this.connection.getTTCVersion() >= 4) {
         var11 = (int)this.meg.unmarshalUB4();
         byte[] var12 = this.meg.unmarshalNBytes(var11);
         if (var11 > 0 && this.registration != null) {
            boolean var13 = false;
            Properties var14 = this.registration.getRegistrationOptions();
            if (var14 != null) {
               String var15 = var14.getProperty("DCN_QUERY_CHANGE_NOTIFICATION");
               if (var15 != null && var15.compareToIgnoreCase("true") == 0) {
                  var13 = true;
               }
            }

            int var25 = var11;
            if (var13) {
               var25 = var11 - 8;
            }

            String var16 = new String(var12, 0, var25);
            char[] var17 = new char[]{'\u0000'};
            String[] var18 = var16.split(new String(var17));
            this.registration.addTablesName(var18, var18.length);
            this.oracleStatement.dcnTableName = var18;
            if (var13) {
               int var19 = var12[var11 - 1] & 255 | (var12[var11 - 2] & 255) << 8 | (var12[var11 - 3] & 255) << 16 | (var12[var11 - 4] & 255) << 24;
               int var20 = var12[var11 - 5] & 255 | (var12[var11 - 6] & 255) << 8 | (var12[var11 - 7] & 255) << 16 | (var12[var11 - 8] & 255) << 24;
               long var21 = (long)var20 & 4294967295L | ((long)var19 & 4294967295L) << 32;
               this.oracleStatement.dcnQueryId = var21;
            }
         }
      }

      if (this.connection.getTTCVersion() >= 7 && this.typeOfStatement.isDML()) {
         var11 = (int)this.meg.unmarshalUB4();
         int[] var23 = new int[var11];

         for(int var24 = 0; var24 < var11; ++var24) {
            var23[var24] = (int)this.meg.unmarshalSB8();
         }

         this.oracleStatement.batchRowsUpdatedArray = var23;
      }

   }

   void readDCB() throws IOException, SQLException {
      this.dcb.init(this.oracleStatement, 0);
      this.definesAccessors = this.dcb.receive(this.definesAccessors);
      this.numberOfDefinePositions = this.dcb.numuds;
      this.definesLength = this.numberOfDefinePositions;
      this.rxd.setNumberOfColumns(this.numberOfDefinePositions);
   }

   void readIMPLRES() throws IOException, SQLException {
      this.implres.init(this.oracleStatement);
      int var1 = (int)this.meg.unmarshalUB4();

      for(this.oracleStatement.implicitResultSetStatements = new ArrayDeque(var1); var1 != 0; --var1) {
         this.implres.readImplicitResultSet();
      }

      this.oracleStatement.implicitResultSetIterator = this.oracleStatement.implicitResultSetStatements.iterator();
   }

   void processError() throws SQLException {
      this.cursor = this.oer.currCursorID;
      this.rowsProcessed = this.oer.getCurRowNumber();
      OracleStatement var10000 = this.oracleStatement;
      var10000.isComplete |= this.oer.retCode == 1403;
      if (this.typeOfStatement.isSELECT() && this.oer.retCode == 1403) {
         this.aFetchWasDone = true;
      }

      if (!this.typeOfStatement.isSELECT() || this.typeOfStatement.isSELECT() && this.oer.retCode != 1403) {
         if (this.oracleStatement.connection.checksumMode.needToCalculateFetchChecksum() && this.oer.retCode != 0) {
            long var1 = this.oer.updateChecksum(this.oracleStatement.checkSum);
            this.oracleStatement.checkSum = var1;
         }

         this.oer.processError(this.oracleStatement);
      }

   }

   int getCursorId() {
      return this.cursor;
   }

   void continueReadRow(int var1, OracleStatement var2) throws SQLException, IOException {
      try {
         this.oracleStatement = var2;
         this.receiveState = 2;
         if (!this.rxd.unmarshal(this.definesAccessors, var1, this.definesLength)) {
            this.resumeReceive();
            return;
         }

         this.receiveState = 3;
      } finally {
         this.oracleStatement = null;
      }

   }

   int getNumRows() {
      int var1 = 0;
      if (this.typeOfStatement == null) {
         return var1;
      } else {
         if (this.receiveState == 3) {
            var1 = -2;
         } else {
            switch(this.typeOfStatement) {
            case DELETE:
            case INSERT:
            case MERGE:
            case UPDATE:
            case ALTER_SESSION:
            case OTHER:
            case PLSQL_BLOCK:
            case CALL_BLOCK:
               var1 = this.rowsProcessed;
               break;
            case SELECT_FOR_UPDATE:
            case SELECT:
               assert this.definesAccessors == null || this.definesAccessors[0] != null : "definesAccessors is not null but definesAccessors[0] is null";

               var1 = this.definesAccessors != null && this.definesLength > 0 && this.definesAccessors[0] != null ? this.definesAccessors[0].lastRowProcessed : 0;
            }
         }

         return var1;
      }
   }

   void marshal() throws IOException {
      if (this.getFunCode() == 5) {
         this.meg.marshalSWORD(this.cursor);
         this.meg.marshalSWORD((int)this.al8i4[1]);
      } else {
         if (this.oracleStatement.needToSendOalToFetch) {
            this.oracleStatement.needToSendOalToFetch = false;
         }

         this.marshalPisdef();
         this.meg.marshalCHR(this.sqlStmt);
         this.meg.marshalUB4Array(this.al8i4);
         int[] var1 = new int[this.numberOfBindPositions];

         int var2;
         for(var2 = 0; var2 < this.numberOfBindPositions; ++var2) {
            var1[var2] = this.oacdefBindsSent[var2].oacmxl;
         }

         if ((this.options & 8L) != 0L && this.numberOfBindPositions > 0 && this.bindIndicators != null && this.sendBindsDefinition) {
            this.marshalBindsTypes(this.oacdefBindsSent);
         }

         if (this.connection.getTTCVersion() >= 2 && (this.options & 16L) != 0L) {
            for(var2 = 0; var2 < this.defCols; ++var2) {
               this.oacdefDefines[var2].marshal();
            }
         }

         if ((this.options & 32L) != 0L && this.numberOfBindPositions > 0 && this.bindIndicators != null) {
            this.nonFatalIOExceptions = this.marshalBinds(var1, false);
         }
      }

   }

   void marshalPisdef() throws IOException {
      this.meg.marshalUB4(this.options);
      this.meg.marshalSWORD(this.cursor);
      if (this.sqlStmt.length == 0) {
         this.meg.marshalNULLPTR();
      } else {
         this.meg.marshalPTR();
      }

      this.meg.marshalSWORD(this.sqlStmt.length);
      if (this.al8i4.length == 0) {
         this.meg.marshalNULLPTR();
      } else {
         this.meg.marshalPTR();
      }

      this.meg.marshalSWORD(this.al8i4.length);
      this.meg.marshalNULLPTR();
      this.meg.marshalNULLPTR();
      if ((this.options & 64L) == 0L && (this.options & 32L) != 0L && (this.options & 1L) != 0L && this.typeOfStatement.isSELECT()) {
         this.meg.marshalUB4(Long.MAX_VALUE);
         this.meg.marshalUB4((long)this.rowsToFetch);
      } else {
         this.meg.marshalUB4(0L);
         this.meg.marshalUB4(0L);
      }

      if (!this.typeOfStatement.isPlsqlOrCall()) {
         this.meg.marshalUB4(2147483647L);
      } else {
         this.meg.marshalUB4(32760L);
      }

      if ((this.options & 8L) != 0L && this.numberOfBindPositions > 0 && this.sendBindsDefinition) {
         this.meg.marshalPTR();
         this.meg.marshalSWORD(this.numberOfBindPositions);
      } else {
         this.meg.marshalNULLPTR();
         this.meg.marshalSWORD(0);
      }

      this.meg.marshalNULLPTR();
      this.meg.marshalNULLPTR();
      this.meg.marshalNULLPTR();
      this.meg.marshalNULLPTR();
      this.meg.marshalNULLPTR();
      if (this.connection.getTTCVersion() >= 2) {
         if (this.defCols > 0 && (this.options & 16L) != 0L) {
            this.meg.marshalPTR();
            this.meg.marshalSWORD(this.defCols);
         } else {
            this.meg.marshalNULLPTR();
            this.meg.marshalSWORD(0);
         }
      }

      if (this.connection.getTTCVersion() >= 4) {
         int var1 = 0;
         int var2 = 0;
         if (this.registration != null) {
            long var3 = this.registration.getRegId();
            var1 = (int)(var3 & -1L);
            var2 = (int)((var3 & -4294967296L) >> 32);
         }

         this.meg.marshalUB4((long)var1);
         this.meg.marshalNULLPTR();
         this.meg.marshalPTR();
         if (this.connection.getTTCVersion() >= 5) {
            this.meg.marshalNULLPTR();
            this.meg.marshalUB4(0L);
            this.meg.marshalNULLPTR();
            this.meg.marshalUB4(0L);
            this.meg.marshalUB4((long)var2);
            if (this.connection.getTTCVersion() >= 7) {
               if (this.typeOfStatement.isDML()) {
                  this.meg.marshalPTR();
                  this.meg.marshalUB4((long)this.oracleStatement.currentRank);
                  this.meg.marshalPTR();
               } else {
                  this.meg.marshalNULLPTR();
                  this.meg.marshalUB4(0L);
                  this.meg.marshalNULLPTR();
               }
            }
         }
      }

   }

   boolean initBindsDefinition(T4CTTIoac[] var1) throws SQLException, IOException {
      boolean var2 = false;
      if (var1.length != this.numberOfBindPositions) {
         var2 = true;
         var1 = new T4CTTIoac[this.numberOfBindPositions];
      }

      short[] var3 = this.bindIndicators;
      boolean var5 = false;
      int var8 = 0;

      for(int var9 = 0; var9 < this.numberOfBindPositions; ++var9) {
         T4CTTIoac var10 = new T4CTTIoac(this.connection);
         int var4 = this.bindIndicatorSubRange + 5 + 10 * var9;
         short var7 = var3[var4 + 9];
         int var6 = var3[var4 + 0] & '\uffff';
         int var12;
         int var14;
         SQLException var15;
         int var18;
         switch(var6) {
         case 8:
         case 24:
            if (this.plsql) {
               var14 = 32760;
            } else {
               var14 = Integer.MAX_VALUE;
            }

            var10.init((short)var6, var14);
            var10.setFormOfUse(var7);
            var10.setCharset(var7 == 2 ? this.NCharSet : this.dbCharSet);
            break;
         case 109:
         case 111:
            if (this.outBindAccessors != null && this.outBindAccessors[var9] != null) {
               if (this.outBindAccessors[var9].internalOtype != null) {
                  var10.init((short)var6, var6 == 109 ? 11 : 4000);
                  var10.setADT((OracleTypeADT)((TypeAccessor)this.outBindAccessors[var9]).internalOtype);
               }
            } else {
               if (this.parameterOtype == null || this.parameterOtype[this.oracleStatement.firstRowInBatch] == null) {
                  var15 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), "INTERNAL ERROR: Binding NAMED_TYPE but no type defined", -1);
                  var15.fillInStackTrace();
                  throw var15;
               }

               var10.init((short)var6, var6 == 109 ? 11 : 4000);
               var10.setADT(this.parameterOtype[this.oracleStatement.firstRowInBatch][var9]);
            }
            break;
         case 180:
            var14 = var3[var4 + 1] & '\uffff';
            var10.init((short)var6, var14);
            var10.addFlg2(134217728);
            var10.setTimestampFractionalSecondsPrecision((short)9);
            var18 = ((this.bindIndicators[this.bindIndicatorSubRange + 3] & '\uffff') << 16) + (this.bindIndicators[this.bindIndicatorSubRange + 4] & '\uffff');
            if (var18 == 1) {
               var12 = ((var3[var4 + 7] & '\uffff') << 16) + (var3[var4 + 8] & '\uffff');
               short var13 = var3[var12];
               if (var13 == 7) {
                  var10.setTimestampFractionalSecondsPrecision((short)0);
               }
            }
            break;
         case 182:
         case 183:
            var14 = var3[var4 + 1] & '\uffff';
            var10.init((short)var6, var14);
            var10.setFormOfUse(var7);
            var10.setCharset(var7 == 2 ? this.NCharSet : this.dbCharSet);
            var10.setPrecision((short)9);
            break;
         case 994:
            int[] var17 = this.oracleStatement.returnParamMeta;
            var6 = var17[3 + var9 * 4 + 0];
            var14 = var17[3 + var9 * 4 + 2];
            var7 = (short)var17[3 + var9 * 4 + 3];
            if (var6 != 109 && var6 != 111) {
               var10.init((short)var6, var14);
               var10.setFormOfUse(var7);
               var10.setCharset(var7 == 2 ? this.NCharSet : this.dbCharSet);
            } else {
               TypeAccessor var19 = (TypeAccessor)this.oracleStatement.accessors[var9];
               var10.init((short)var6, var6 == 109 ? 11 : 4000);
               var10.setADT((OracleTypeADT)var19.internalOtype);
            }
            break;
         case 998:
            if (this.outBindAccessors != null && this.outBindAccessors[var9] != null) {
               PlsqlIbtBindInfo var16 = this.outBindAccessors[var9].plsqlIndexTableBindInfo();
               var10.init((short)var16.element_internal_type, var16.elemMaxLen);
               var10.setMal(var16.maxLen);
               var10.addFlg((short)64);
               ++var8;
            } else {
               if (this.ibtBindIndicators[6 + var8 * 8] == 0) {
                  var15 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), "INTERNAL ERROR: Binding PLSQL index-by table but no type defined", -1);
                  var15.fillInStackTrace();
                  throw var15;
               }

               short var11 = this.ibtBindIndicators[6 + var8 * 8];
               var12 = (this.ibtBindIndicators[6 + var8 * 8 + 2] & '\uffff') << 16 | this.ibtBindIndicators[6 + var8 * 8 + 3] & '\uffff';
               var14 = this.ibtBindIndicators[6 + var8 * 8 + 1] * this.conversion.sMaxCharSize;
               var10.init((short)var11, var14);
               var10.setMal(var12);
               var10.addFlg((short)64);
               ++var8;
            }
            break;
         default:
            var14 = var3[var4 + 1] & '\uffff';
            if (var14 == 0) {
               var14 = var3[var4 + 2] & '\uffff';
               if (var6 == 996) {
                  var14 *= 2;
               } else if (var14 > 1) {
                  --var14;
               }

               if (var7 == 2) {
                  var14 *= this.conversion.maxNCharSize;
               }

               if (this.typeOfStatement != oracle.jdbc.internal.OracleStatement.SqlKind.PLSQL_BLOCK && (this.connection.versionNumber < 10200 || this.typeOfStatement != oracle.jdbc.internal.OracleStatement.SqlKind.CALL_BLOCK)) {
                  if (this.typeOfStatement == oracle.jdbc.internal.OracleStatement.SqlKind.CALL_BLOCK) {
                     if (var14 < 4001) {
                        var14 = 4001;
                     }
                  } else if (var7 != 2) {
                     var18 = this.connection.maxVarcharLength;
                     if (((T4CConnection)this.oracleStatement.connection).retainV9BindBehavior && var14 <= var18) {
                        var14 = Math.min(var14 * this.conversion.sMaxCharSize, var18);
                     } else {
                        var14 *= this.conversion.sMaxCharSize;
                     }
                  }
               } else if (var14 == 0) {
                  var14 = this.connection.maxVcsBytesPlsql;
               } else {
                  var14 *= this.conversion.sMaxCharSize;
               }

               if (var14 == 0) {
                  var14 = 32;
               }
            }

            var10.init((short)var6, var14);
            var10.setFormOfUse(var7);
            var10.setCharset(var7 == 2 ? this.NCharSet : this.dbCharSet);
         }

         if (var1[var9] == null || !var10.isOldSufficient(var1[var9])) {
            var1[var9] = var10;
            var2 = true;
         }
      }

      if (var2) {
         this.oracleStatement.nbPostPonedColumns[0] = 0;
      }

      return var2;
   }

   void initDefinesDefinition() throws SQLException, IOException {
      this.defCols = 0;

      int var1;
      for(var1 = 0; var1 < this.definedColumnType.length && this.definedColumnType[var1] != 0; ++var1) {
         ++this.defCols;
      }

      this.oacdefDefines = new T4CTTIoac[this.defCols];
      boolean var7 = false;
      boolean var2 = false;
      boolean var3 = false;
      boolean var4 = false;

      for(int var5 = 0; var5 < this.oacdefDefines.length; ++var5) {
         this.oacdefDefines[var5] = new T4CTTIoac(this.connection);
         short var10 = (short)this.oracleStatement.getInternalType(this.definedColumnType[var5]);
         int var8 = Integer.MAX_VALUE;
         var1 = 0;
         int var9 = 0;
         byte var6 = 1;
         if (this.definedColumnFormOfUse != null && this.definedColumnFormOfUse.length > var5 && this.definedColumnFormOfUse[var5] == 2) {
            var6 = 2;
         }

         if (var10 == 8) {
            var10 = 1;
         } else if (var10 == 24) {
            var10 = 23;
         } else if (var10 != 1 && var10 != 96) {
            if (!this.connection.useLobPrefetch || var10 != 113 && var10 != 112 && var10 != 114) {
               if (var10 == 23) {
                  var8 = this.connection.maxRawLength;
               }
            } else {
               var8 = 0;
               var1 = 33554432;
               if (this.definedColumnSize != null && this.definedColumnSize.length > var5 && this.definedColumnSize[var5] > 0) {
                  var9 = this.definedColumnSize[var5];
               }
            }
         } else {
            var10 = 1;
            var8 = this.connection.maxVarcharLength * this.conversion.sMaxCharSize;
            if (this.definedColumnSize != null && this.definedColumnSize.length > var5 && this.definedColumnSize[var5] > 0) {
               var8 = this.definedColumnSize[var5] * this.conversion.sMaxCharSize;
            }
         }

         this.oacdefDefines[var5].init(var10, var8);
         this.oacdefDefines[var5].addFlg2(var1);
         this.oacdefDefines[var5].setMxlc(var9);
         this.oacdefDefines[var5].setFormOfUse(var6);
         this.oacdefDefines[var5].setCharset(var6 == 2 ? this.NCharSet : this.dbCharSet);
      }

   }

   void marshalBindsTypes(T4CTTIoac[] var1) throws IOException {
      if (var1 != null) {
         for(int var2 = 0; var2 < var1.length; ++var2) {
            var1[var2].marshal();
         }

      }
   }

   Vector marshalBinds(int[] var1, boolean var2) throws IOException {
      Vector var3 = null;
      int var4 = ((this.bindIndicators[this.bindIndicatorSubRange + 3] & '\uffff') << 16) + (this.bindIndicators[this.bindIndicatorSubRange + 4] & '\uffff');
      int var5;
      boolean var7;
      if (var2) {
         var5 = this.rxh.iterNum;
         var7 = true;
      } else {
         var5 = 0;
         var7 = false;
      }

      for(; var5 < var4; ++var5) {
         int var6 = this.oracleStatement.firstRowInBatch + var5;
         InputStream[] var8 = null;
         if (this.parameterStream != null) {
            var8 = this.parameterStream[var6];
         }

         byte[][] var9 = (byte[][])null;
         if (this.parameterDatum != null) {
            var9 = this.parameterDatum[var6];
         }

         OracleTypeADT[] var10 = null;
         if (this.parameterOtype != null) {
            var10 = this.parameterOtype[var6];
         }

         Vector var11 = this.rxd.marshal(this.bindBytes, this.bindChars, this.bindIndicators, this.bindIndicatorSubRange, this.tmpBindsByteArray, this.conversion, var8, var9, var10, this.ibtBindBytes, this.ibtBindChars, this.ibtBindIndicators, (byte[])null, var5, var1, this.plsql, this.oracleStatement.returnParamMeta, this.oracleStatement.nbPostPonedColumns, this.oracleStatement.indexOfPostPonedColumn, var7);
         var7 = false;
         if (var11 != null) {
            if (var3 == null) {
               var3 = new Vector();
            }

            var3.addAll(var11);
         }
      }

      return var3;
   }

   long setOptions(boolean var1, boolean var2, boolean var3, boolean var4) throws SQLException {
      long var5 = 0L;
      if (var1 && !var2 && !var3) {
         var5 |= 1L;
      } else if (var1 && var2 && !var3) {
         var5 = 32801L;
      } else {
         SQLException var7;
         if (var2 && var3) {
            if (var1) {
               var5 |= 1L;
            }

            switch(this.typeOfStatement) {
            case DELETE:
            case INSERT:
            case MERGE:
            case UPDATE:
            case ALTER_SESSION:
            case OTHER:
               if (this.oracleStatement.isDmlReturning) {
                  var5 |= 1056L | (long)(this.oracleStatement.connection.autocommit ? 256 : 0);
               } else {
                  var5 |= 32800L | (long)(this.oracleStatement.connection.autocommit ? 256 : 0);
               }
               break;
            case PLSQL_BLOCK:
            case CALL_BLOCK:
               if (this.numberOfBindPositions > 0) {
                  var5 |= 1056L | (long)(this.oracleStatement.connection.autocommit ? 256 : 0);
                  if (this.sendBindsDefinition) {
                     var5 |= 8L;
                  }
               } else {
                  var5 |= 32L | (long)(this.oracleStatement.connection.autocommit ? 256 : 0);
               }
               break;
            case SELECT_FOR_UPDATE:
            case SELECT:
               var5 |= 32864L;
               break;
            default:
               var7 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 432);
               var7.fillInStackTrace();
               throw var7;
            }
         } else {
            if (var1 || var2 || !var3) {
               var7 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 432);
               var7.fillInStackTrace();
               throw var7;
            }

            var5 = 32832L;
         }
      }

      if (!this.typeOfStatement.isPlsqlOrCall()) {
         if ((var1 || var2 || !var3) && this.numberOfBindPositions > 0 && this.sendBindsDefinition) {
            var5 |= 8L;
         }

         if (this.connection.versionNumber >= 9000 && var4) {
            var5 |= 16L;
         }
      }

      var5 &= -1L;
      return var5;
   }

   protected oracle.jdbc.internal.OracleConnection getConnectionDuringExceptionHandling() {
      return this.connection;
   }
}
