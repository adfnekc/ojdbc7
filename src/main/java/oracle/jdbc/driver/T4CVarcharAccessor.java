package oracle.jdbc.driver;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Time;
import java.sql.Timestamp;
import java.text.DateFormatSymbols;
import java.util.Calendar;
import java.util.GregorianCalendar;
import oracle.sql.DATE;
import oracle.sql.Datum;
import oracle.sql.NUMBER;
import oracle.sql.RAW;
import oracle.sql.TIMESTAMP;
import oracle.sql.TIMESTAMPLTZ;
import oracle.sql.TIMESTAMPTZ;

class T4CVarcharAccessor extends VarcharAccessor implements T4CAccessor {
   T4CMAREngine mare;
   static final int MAX_CALL_LENGTH_PRE102 = 4001;
   static final int MIN_SQL_LENGTH = 32;
   boolean underlyingLong = false;
   private T4CMarshaller marshaller = null;
   static final int NONE = -1;
   static final int DAY = 1;
   static final int MM_MONTH = 2;
   static final int FULL_MONTH = 3;
   static final int MON_MONTH = 4;
   static final int YY_YEAR = 5;
   static final int RR_YEAR = 6;
   static final int HH_HOUR = 7;
   static final int HH24_HOUR = 8;
   static final int MINUTE = 9;
   static final int SECOND = 10;
   static final int NSECOND = 11;
   static final int AM = 12;
   static final int TZR = 13;
   static final int TZH = 14;
   static final int TZM = 15;
   private static final String _Copyright_2007_Oracle_All_Rights_Reserved_ = null;
   public static final String BUILD_DATE = "Thu_Apr_04_15:09:24_PDT_2013";
   public static final boolean TRACE = false;

   T4CVarcharAccessor(OracleStatement var1, int var2, short var3, int var4, boolean var5, T4CMAREngine var6) throws SQLException {
      super(var1, var2, var3, var4, var5);
      this.mare = var6;
      this.calculateSizeTmpByteArray();
   }

   T4CVarcharAccessor(OracleStatement var1, int var2, boolean var3, int var4, int var5, int var6, int var7, int var8, short var9, int var10, int var11, int var12, T4CMAREngine var13) throws SQLException {
      super(var1, var2, var3, var4, var5, var6, var7, var8, var9);
      this.mare = var13;
      this.definedColumnType = var11;
      this.definedColumnSize = var12;
      this.calculateSizeTmpByteArray();
      this.oacmxl = var10;
      if (this.oacmxl == -1) {
         this.underlyingLong = true;
         this.oacmxl = 4000;
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

   NUMBER getNUMBER(int var1) throws SQLException {
      NUMBER var2 = null;
      if (this.definedColumnType == 0) {
         var2 = super.getNUMBER(var1);
      } else {
         String var3 = this.getString(var1);
         if (var3 != null) {
            return StringToNUMBER(var3.trim());
         }
      }

      return var2;
   }

   DATE getDATE(int var1) throws SQLException {
      DATE var2 = null;
      if (this.definedColumnType == 0) {
         var2 = super.getDATE(var1);
      } else {
         Date var3 = this.getDate(var1);
         if (var3 != null) {
            var2 = new DATE(var3);
         }
      }

      return var2;
   }

   TIMESTAMP getTIMESTAMP(int var1) throws SQLException {
      TIMESTAMP var2 = null;
      if (this.definedColumnType == 0) {
         var2 = super.getTIMESTAMP(var1);
      } else {
         String var3 = this.getString(var1);
         if (var3 != null) {
            int[] var4 = new int[1];
            Calendar var5 = DATEStringToCalendar(var3, (String)this.statement.connection.sessionProperties.get("AUTH_NLS_LXCSTMPFM"), var4);
            Timestamp var6 = new Timestamp(var5.getTimeInMillis());
            var6.setNanos(var4[0]);
            var2 = new TIMESTAMP(var6);
         }
      }

      return var2;
   }

   TIMESTAMPTZ getTIMESTAMPTZ(int var1) throws SQLException {
      TIMESTAMPTZ var2 = null;
      if (this.definedColumnType == 0) {
         var2 = super.getTIMESTAMPTZ(var1);
      } else {
         String var3 = this.getString(var1);
         if (var3 != null) {
            int[] var4 = new int[1];
            Calendar var5 = DATEStringToCalendar(var3, (String)this.statement.connection.sessionProperties.get("AUTH_NLS_LXCSTZNFM"), var4);
            Timestamp var6 = new Timestamp(var5.getTimeInMillis());
            var6.setNanos(var4[0]);
            var2 = new TIMESTAMPTZ(this.statement.connection, var6, var5);
         }
      }

      return var2;
   }

   TIMESTAMPLTZ getTIMESTAMPLTZ(int var1) throws SQLException {
      TIMESTAMPLTZ var2 = null;
      if (this.definedColumnType == 0) {
         var2 = super.getTIMESTAMPLTZ(var1);
      } else {
         String var3 = this.getString(var1);
         if (var3 != null) {
            int[] var4 = new int[1];
            Calendar var5 = DATEStringToCalendar(var3, (String)this.statement.connection.sessionProperties.get("AUTH_NLS_LXCSTZNFM"), var4);
            Timestamp var6 = new Timestamp(var5.getTimeInMillis());
            var6.setNanos(var4[0]);
            var2 = new TIMESTAMPLTZ(this.statement.connection, var6, var5);
         }
      }

      return var2;
   }

   RAW getRAW(int var1) throws SQLException {
      RAW var2 = null;
      if (this.definedColumnType == 0) {
         var2 = super.getRAW(var1);
      } else if (!this.rowNull[var1]) {
         if (this.definedColumnType != -2 && this.definedColumnType != -3 && this.definedColumnType != -4) {
            var2 = new RAW(super.getBytes(var1));
         } else {
            var2 = new RAW(this.getBytesFromHexChars(var1));
         }
      }

      return var2;
   }

   Datum getOracleObject(int var1) throws SQLException {
      if (this.definedColumnType == 0) {
         return super.getOracleObject(var1);
      } else {
         Object var2 = null;
         SQLException var3;
         if (this.rowNull == null) {
            var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 21);
            var3.fillInStackTrace();
            throw var3;
         } else if (!this.rowNull[var1]) {
            switch(this.definedColumnType) {
            case -102:
               return this.getTIMESTAMPLTZ(var1);
            case -101:
               return this.getTIMESTAMPTZ(var1);
            case -16:
            case -15:
            case -9:
            case -1:
            case 1:
            case 12:
               return super.getOracleObject(var1);
            case -8:
               return this.getROWID(var1);
            case -7:
            case -6:
            case -5:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 16:
               return this.getNUMBER(var1);
            case -4:
            case -3:
            case -2:
               return this.getRAW(var1);
            case 91:
               return this.getDATE(var1);
            case 92:
               return this.getDATE(var1);
            case 93:
               return this.getTIMESTAMP(var1);
            default:
               var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 4);
               var3.fillInStackTrace();
               throw var3;
            }
         } else {
            return (Datum)var2;
         }
      }
   }

   byte getByte(int var1) throws SQLException {
      byte var2 = 0;
      if (this.definedColumnType == 0) {
         var2 = super.getByte(var1);
      } else {
         NUMBER var3 = this.getNUMBER(var1);
         if (var3 != null) {
            var2 = var3.byteValue();
         }
      }

      return var2;
   }

   int getInt(int var1) throws SQLException {
      int var2 = 0;
      if (this.definedColumnType == 0) {
         var2 = super.getInt(var1);
      } else {
         NUMBER var3 = this.getNUMBER(var1);
         if (var3 != null) {
            var2 = var3.intValue();
         }
      }

      return var2;
   }

   short getShort(int var1) throws SQLException {
      short var2 = 0;
      if (this.definedColumnType == 0) {
         var2 = super.getShort(var1);
      } else {
         NUMBER var3 = this.getNUMBER(var1);
         if (var3 != null) {
            var2 = var3.shortValue();
         }
      }

      return var2;
   }

   long getLong(int var1) throws SQLException {
      long var2 = 0L;
      if (this.definedColumnType == 0) {
         var2 = super.getLong(var1);
      } else {
         NUMBER var4 = this.getNUMBER(var1);
         if (var4 != null) {
            var2 = var4.longValue();
         }
      }

      return var2;
   }

   float getFloat(int var1) throws SQLException {
      float var2 = 0.0F;
      if (this.definedColumnType == 0) {
         var2 = super.getFloat(var1);
      } else {
         NUMBER var3 = this.getNUMBER(var1);
         if (var3 != null) {
            var2 = var3.floatValue();
         }
      }

      return var2;
   }

   double getDouble(int var1) throws SQLException {
      double var2 = 0.0D;
      if (this.definedColumnType == 0) {
         var2 = super.getDouble(var1);
      } else {
         NUMBER var4 = this.getNUMBER(var1);
         if (var4 != null) {
            var2 = var4.doubleValue();
         }
      }

      return var2;
   }

   Date getDate(int var1) throws SQLException {
      Date var2 = null;
      if (this.definedColumnType == 0) {
         var2 = super.getDate(var1);
      } else {
         String var3 = this.getString(var1);
         if (var3 != null) {
            int[] var4 = new int[1];

            try {
               var2 = new Date(DATEStringToCalendar(var3, (String)this.statement.connection.sessionProperties.get("AUTH_NLS_LXCDATEFM"), var4).getTimeInMillis());
            } catch (NumberFormatException var7) {
               SQLException var6 = DatabaseError.createSqlException((oracle.jdbc.internal.OracleConnection)null, 132, (Object)null, var7);
               var6.fillInStackTrace();
               throw var6;
            }
         }
      }

      return var2;
   }

   Timestamp getTimestamp(int var1) throws SQLException {
      Timestamp var2 = null;
      if (this.definedColumnType == 0) {
         var2 = super.getTimestamp(var1);
      } else {
         String var3 = this.getString(var1);
         if (var3 != null) {
            int[] var4 = new int[1];

            try {
               Calendar var5 = DATEStringToCalendar(var3, (String)this.statement.connection.sessionProperties.get("AUTH_NLS_LXCSTMPFM"), var4);
               var2 = new Timestamp(var5.getTimeInMillis());
               var2.setNanos(var4[0]);
            } catch (NumberFormatException var7) {
               SQLException var6 = DatabaseError.createSqlException((oracle.jdbc.internal.OracleConnection)null, 132, (Object)null, var7);
               var6.fillInStackTrace();
               throw var6;
            }
         }
      }

      return var2;
   }

   Time getTime(int var1) throws SQLException {
      Time var2 = null;
      if (this.definedColumnType == 0) {
         var2 = super.getTime(var1);
      } else {
         String var3 = this.getString(var1);
         if (var3 != null) {
            int[] var4 = new int[1];

            try {
               Calendar var5 = DATEStringToCalendar(var3, (String)this.statement.connection.sessionProperties.get("AUTH_NLS_LXCSTZNFM"), var4);
               var2 = new Time(var5.getTimeInMillis());
            } catch (NumberFormatException var7) {
               SQLException var6 = DatabaseError.createSqlException((oracle.jdbc.internal.OracleConnection)null, 132, (Object)null, var7);
               var6.fillInStackTrace();
               throw var6;
            }
         }
      }

      return var2;
   }

   private final T4CMarshaller getMarshaller() {
      if (this.marshaller == null) {
         this.marshaller = this.describeType == 8 ? T4CMarshaller.LONG : T4CMarshaller.VARCHAR;
      }

      return this.marshaller;
   }

   Object getObject(int var1) throws SQLException {
      if (this.definedColumnType == 0) {
         return super.getObject(var1);
      } else {
         SQLException var2;
         if (this.isUnexpected()) {
            var2 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 21);
            var2.fillInStackTrace();
            throw var2;
         } else if (this.isNull(var1)) {
            return null;
         } else {
            switch(this.definedColumnType) {
            case -102:
               return this.getTIMESTAMPLTZ(var1);
            case -101:
               return this.getTIMESTAMPTZ(var1);
            case -16:
            case -15:
            case -9:
            case -1:
            case 1:
            case 12:
               return this.getString(var1);
            case -8:
               return this.getROWID(var1);
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
               return this.getBytesFromHexChars(var1);
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
               var2 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 4);
               var2.fillInStackTrace();
               throw var2;
            }
         }
      }
   }

   static final NUMBER StringToNUMBER(String var0) throws SQLException {
      try {
         return new NUMBER(new BigDecimal(var0));
      } catch (NumberFormatException var3) {
         SQLException var2 = DatabaseError.createSqlException((oracle.jdbc.internal.OracleConnection)null, 132, (Object)null, var3);
         var2.fillInStackTrace();
         throw var2;
      }
   }

   static final Calendar DATEStringToCalendar(String var0, String var1, int[] var2) throws SQLException {
      char[] var3 = (var1 + " ").toCharArray();
      var0 = var0 + " ";
      int var4 = Math.min(var0.length(), var3.length);
      byte var5 = -1;
      boolean var6 = true;
      int var7 = 0;
      int var8 = 0;
      boolean var9 = false;
      int var10 = 0;
      int var11 = 0;
      int var12 = 0;
      int var13 = 0;
      int var14 = 0;
      int var15 = 0;
      int var16 = 0;
      int var17 = 0;
      String var18 = null;
      String var19 = null;
      boolean var20 = false;
      String[] var21 = null;
      String[] var22 = null;

      for(int var23 = 0; var23 < var4; ++var23) {
         switch(var3[var23]) {
         case 'A':
         case 'a':
            if (var23 + 1 < var4 && (var3[var23 + 1] == 'M' || var3[var23 + 1] == 'm')) {
               var5 = 12;
               var7 = var23++;
            }
            break;
         case 'B':
         case 'C':
         case 'E':
         case 'G':
         case 'I':
         case 'J':
         case 'K':
         case 'L':
         case 'N':
         case 'O':
         case 'P':
         case 'Q':
         case 'U':
         case 'V':
         case 'W':
         case 'X':
         case 'Z':
         case '[':
         case '\\':
         case ']':
         case '^':
         case '_':
         case '`':
         case 'b':
         case 'c':
         case 'e':
         case 'g':
         case 'i':
         case 'j':
         case 'k':
         case 'l':
         case 'n':
         case 'o':
         case 'p':
         case 'q':
         case 'u':
         case 'v':
         case 'w':
         case 'x':
         default:
            var20 = true;
            break;
         case 'D':
         case 'd':
            if (var5 != 1) {
               var5 = 1;
               var7 = var23;
            }
            break;
         case 'F':
         case 'f':
            if (var5 != 11) {
               var5 = 11;
               var7 = var23;
            }
            break;
         case 'H':
         case 'h':
            if (var5 != 7) {
               var5 = 7;
               var7 = var23;
            } else if (var23 + 2 < var4 && (var3[var23 + 1] == '2' || var3[var23 + 4] == '4')) {
               var5 = 8;
               var23 += 2;
            }
            break;
         case 'M':
         case 'm':
            if (var5 == 2 && var5 == 4 && var5 == 3 && var5 == 9) {
               break;
            }

            var7 = var23;
            if (var23 + 4 >= var4 || var3[var23 + 1] != 'O' && var3[var23 + 1] != 'o' || var3[var23 + 2] != 'N' && var3[var23 + 2] != 'n' || var3[var23 + 3] != 'T' && var3[var23 + 3] != 't' || var3[var23 + 4] != 'H' && var3[var23 + 4] != 'h') {
               if (var23 + 2 < var4 && (var3[var23 + 1] == 'O' || var3[var23 + 1] == 'o') && (var3[var23 + 2] == 'N' || var3[var23 + 2] == 'n')) {
                  var5 = 4;
                  var23 += 2;
                  break;
               }

               if (var23 + 1 >= var4 || var3[var23 + 1] != 'M' && var3[var23 + 1] != 'm') {
                  if (var23 + 1 < var4 && (var3[var23 + 1] == 'I' || var3[var23 + 1] == 'i')) {
                     var5 = 9;
                     ++var23;
                  }
                  break;
               }

               var5 = 2;
               ++var23;
               break;
            }

            var5 = 3;
            var23 += 4;
            break;
         case 'R':
         case 'r':
            if (var5 != 6) {
               var5 = 6;
               var7 = var23;
            }
            break;
         case 'S':
         case 's':
            if (var23 + 1 < var4 && (var3[var23 + 1] == 'S' || var3[var23 + 1] == 's')) {
               var5 = 10;
               var7 = var23++;
            }
            break;
         case 'T':
         case 't':
            if (var23 + 2 < var4 && (var3[var23 + 1] == 'Z' || var3[var23 + 1] == 'z') && (var3[var23 + 2] == 'R' || var3[var23 + 2] == 'r')) {
               var5 = 13;
               var7 = var23;
               var23 += 2;
            }
            break;
         case 'Y':
         case 'y':
            if (var5 != 5) {
               var5 = 5;
               var7 = var23;
            }
         }

         if (var20 && var5 != -1) {
            int var24 = var23 - var7;
            int var25 = var7 - var8;
            int var30 = var10 + var25;
            var10 = var30 + var24;
            char var26;
            int var27;
            SQLException var28;
            switch(var5) {
            case 1:
               var11 = Integer.parseInt(var0.substring(var30, var10));
               break;
            case 2:
               var12 = Integer.parseInt(var0.substring(var30, var10));
               break;
            case 3:
               for(var27 = var30; var27 < var0.length() && var0.charAt(var27) != var3[var23]; ++var27) {
               }

               var10 = var27;
               var28 = null;
               if (var27 != var30) {
                  String var34 = var0.substring(var30, var27);
                  var34 = var34.trim();
                  if (var22 == null) {
                     var22 = (new DateFormatSymbols()).getMonths();
                  }

                  for(var12 = 0; var12 < var22.length && !var34.equalsIgnoreCase(var22[var12]); ++var12) {
                  }

                  if (var12 >= 12) {
                     SQLException var29 = DatabaseError.createSqlException((oracle.jdbc.internal.OracleConnection)null, 59);
                     var29.fillInStackTrace();
                     throw var29;
                  }
               }
               break;
            case 4:
               int var31;
               for(var31 = var30; var31 < var0.length() && var0.charAt(var31) != var3[var23]; ++var31) {
               }

               var10 = var31;
               String var33 = null;
               if (var31 != var30) {
                  var33 = var0.substring(var30, var31);
                  var33 = var33.trim();
                  if (var21 == null) {
                     var21 = (new DateFormatSymbols()).getShortMonths();
                  }

                  for(var12 = 0; var12 < var21.length && !var33.equalsIgnoreCase(var21[var12]); ++var12) {
                  }

                  if (var12 >= 12) {
                     var28 = DatabaseError.createSqlException((oracle.jdbc.internal.OracleConnection)null, 59);
                     var28.fillInStackTrace();
                     throw var28;
                  }
               }
               break;
            case 5:
               var13 = Integer.parseInt(var0.substring(var30, var10));
               if (var24 == 2) {
                  var13 += 2000;
               }
               break;
            case 6:
               var13 = Integer.parseInt(var0.substring(var30, var10));
               if (var24 == 2 && var13 < 50) {
                  var13 += 2000;
               } else {
                  var13 += 1900;
               }
               break;
            case 7:
            case 8:
               var10 = var30 + 2;
               var14 = Integer.parseInt(var0.substring(var30, var10));
               break;
            case 9:
               var15 = Integer.parseInt(var0.substring(var30, var10));
               break;
            case 10:
               var16 = Integer.parseInt(var0.substring(var30, var10));
               break;
            case 11:
               for(var27 = var30; var27 < var0.length() && (var26 = var0.charAt(var27)) >= '0' && var26 <= '9'; ++var27) {
               }

               var10 = var30 + (var27 - var30);
               if (var10 != var30) {
                  var17 = Integer.parseInt(var0.substring(var30, var10));
               }
               break;
            case 12:
               if (var10 > 0) {
                  var18 = var0.substring(var30, var10);
               }
               break;
            case 13:
               var10 = var30;

               for(var27 = var30; var27 < var0.length() && ((var26 = var0.charAt(var27)) >= '0' && var26 <= '9' || var26 >= 'a' && var26 <= 'z' || var26 >= 'A' && var26 <= 'Z'); var10 = var27++) {
               }

               if (var10 != var30) {
                  var19 = var0.substring(var30, var10);
               }
               break;
            default:
               System.out.println("\n\n\n             ***** ERROR(1) ****\n");
            }

            var8 = var23;
            var5 = -1;
            var20 = false;
         }
      }

      GregorianCalendar var32 = new GregorianCalendar(var13, var12, var11, var14, var15, var16);
      if (var18 != null) {
         var32.set(9, var18.equalsIgnoreCase("AM") ? 0 : 1);
      }

      if (var19 != null) {
      }

      if (var17 != 0) {
         var2[0] = var17;
      }

      return var32;
   }
}
