package oracle.jdbc.driver;

import java.io.IOException;
import java.sql.SQLException;
import java.text.DateFormatSymbols;
import java.util.TimeZone;

class T4CTimestampAccessor extends TimestampAccessor {
   T4CMAREngine mare;
   boolean underlyingLongRaw = false;
   private static final String _Copyright_2007_Oracle_All_Rights_Reserved_ = null;
   public static final String BUILD_DATE = "Thu_Apr_04_15:09:24_PDT_2013";
   public static final boolean TRACE = false;

   T4CTimestampAccessor(OracleStatement var1, int var2, short var3, int var4, boolean var5, T4CMAREngine var6) throws SQLException {
      super(var1, var2, var3, var4, var5);
      this.mare = var6;
   }

   T4CTimestampAccessor(OracleStatement var1, int var2, boolean var3, int var4, int var5, int var6, int var7, int var8, short var9, int var10, int var11, T4CMAREngine var12) throws SQLException {
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

   String toText(int var1, int var2, int var3, int var4, int var5, int var6, int var7, boolean var8, String var9) throws SQLException {
      if (this.definedColumnType != 0 && this.definedColumnType != 93) {
         String var10 = (String)this.statement.connection.sessionProperties.get("AUTH_NLS_LXCSTMPFM");
         return nlsFormatToText(var1, var2, var3, var4, var5, var6, var7, var8, var9, var10);
      } else {
         return super.toText(var1, var2, var3, var4, var5, var6, var7, var8, var9);
      }
   }

   private static final String nlsFormatToText(int var0, int var1, int var2, int var3, int var4, int var5, int var6, boolean var7, String var8, String var9) throws SQLException {
      char[] var10 = (var9 + "      ").toCharArray();
      int var11 = var9.length();
      StringBuffer var12 = new StringBuffer(var11 + 25);
      String[] var13 = null;
      String[] var14 = null;
      TimeZone var15 = null;

      for(int var16 = 0; var16 < var11; ++var16) {
         switch(var10[var16]) {
         case 'A':
         case 'P':
         case 'a':
         case 'p':
            if (var10[var16 + 1] == 'M' || var10[var16 + 1] == 'm') {
               var12.append(var7 ? "AM" : "PM");
               ++var16;
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
         case 'q':
         case 'u':
         case 'v':
         case 'w':
         case 'x':
         default:
            var12.append(var10[var16]);
            break;
         case 'D':
         case 'd':
            if (var10[var16 + 1] == 'D' || var10[var16 + 1] == 'd') {
               var12.append((var2 < 10 ? "0" : "") + var2);
               ++var16;
            }
            break;
         case 'F':
         case 'f':
            if (var10[var16 + 1] != 'F' && var10[var16 + 1] != 'f') {
               break;
            }

            if (var6 >= 0) {
               var12.append(var6);
            } else {
               var12.append(0);
            }

            ++var16;
            break;
         case 'H':
         case 'h':
            if (var10[var16 + 1] != 'H' && var10[var16 + 1] != 'h') {
               break;
            }

            if (var10[var16 + 2] != '2' && var10[var16 + 3] != '4') {
               if (var3 > 12) {
                  var3 -= 12;
               }

               var12.append((var3 < 10 ? "0" : "") + var3);
               ++var16;
               break;
            }

            var12.append((var3 < 10 ? "0" : "") + var3);
            var16 += 3;
            break;
         case 'M':
         case 'm':
            if (var10[var16 + 1] != 'M' && var10[var16 + 1] != 'm') {
               if (var10[var16 + 1] != 'I' && var10[var16 + 1] != 'i') {
                  if ((var10[var16 + 1] == 'O' || var10[var16 + 1] == 'o') && (var10[var16 + 2] == 'N' || var10[var16 + 2] == 'n')) {
                     if (var10[var16 + 3] != 'T' && var10[var16 + 3] != 't' || var10[var16 + 4] != 'H' && var10[var16 + 4] != 'h') {
                        if (var13 == null) {
                           var13 = (new DateFormatSymbols()).getShortMonths();
                        }

                        if (var10[var16] == 'm') {
                           var12.append(var13[var1 - 1].toLowerCase());
                        } else if (var10[var16 + 1] == 'O') {
                           var12.append(var13[var1 - 1].toUpperCase());
                        } else {
                           var12.append(var13[var1 - 1]);
                        }

                        var16 += 2;
                     } else {
                        if (var14 == null) {
                           var14 = (new DateFormatSymbols()).getMonths();
                        }

                        if (var10[var16] == 'm') {
                           var12.append(var14[var1 - 1].toLowerCase());
                        } else if (var10[var16 + 1] == 'O') {
                           var12.append(var14[var1 - 1].toUpperCase());
                        } else {
                           var12.append(var14[var1 - 1]);
                        }

                        var16 += 4;
                     }
                  }
               } else {
                  var12.append((var4 < 10 ? "0" : "") + var4);
                  ++var16;
               }
            } else {
               var12.append((var1 < 10 ? "0" : "") + var1);
               ++var16;
            }
            break;
         case 'R':
         case 'r':
            if (var10[var16 + 1] != 'R' && var10[var16 + 1] != 'r') {
               break;
            }

            if ((var10[var16 + 2] == 'R' || var10[var16 + 2] == 'r') && (var10[var16 + 3] == 'R' || var10[var16 + 3] == 'r')) {
               if (var0 < 1000) {
                  var12.append("0" + var0);
               } else if (var0 < 100) {
                  var12.append("00" + var0);
               } else if (var0 < 10) {
                  var12.append("000" + var0);
               } else {
                  var12.append(var0);
               }

               var16 += 3;
               break;
            }

            if (var0 >= 100) {
               var0 %= 100;
            }

            if (var0 < 10) {
               var12.append("0" + var0);
            } else {
               var12.append(var0);
            }

            ++var16;
            break;
         case 'S':
         case 's':
            if (var10[var16 + 1] != 'S' && var10[var16 + 1] != 's') {
               break;
            }

            var12.append((var5 < 10 ? "0" : "") + var5);
            ++var16;
            if ((var10[var16 + 1] == 'X' || var10[var16 + 1] == 'x') && (var10[var16 + 2] == 'F' || var10[var16 + 2] == 'f') && (var10[var16 + 3] == 'F' || var10[var16 + 3] == 'f')) {
               var12.append(".");
               ++var16;
            }
            break;
         case 'T':
         case 't':
            if (var10[var16 + 1] != 'Z' && var10[var16 + 1] != 'z') {
               break;
            }

            if (var10[var16 + 2] != 'R' && var10[var16 + 2] != 'r') {
               long var17;
               if (var10[var16 + 2] != 'H' && var10[var16 + 2] != 'h') {
                  if (var10[var16 + 2] != 'M' && var10[var16 + 2] != 'm') {
                     break;
                  }

                  if (var15 == null) {
                     var15 = TimeZone.getTimeZone(var8);
                  }

                  var17 = (long)(Math.abs(var15.getRawOffset()) % 3600000 / '\uea60');
                  var12.append((var17 < 10L ? "0" : "") + var17);
                  var16 += 2;
                  break;
               }

               if (var15 == null) {
                  var15 = TimeZone.getTimeZone(var8);
               }

               var17 = (long)(var15.getRawOffset() / 3600000);
               var12.append(var17);
               var16 += 2;
               break;
            }

            if (var8.length() > 3 && var8.startsWith("GMT")) {
               var12.append(var8.substring(3));
            } else {
               var12.append(var8.toUpperCase());
            }

            var16 += 2;
            break;
         case 'Y':
         case 'y':
            if (var10[var16 + 1] == 'Y' || var10[var16 + 1] == 'y') {
               if (var10[var16 + 2] != 'Y' && var10[var16 + 2] != 'y' || var10[var16 + 3] != 'Y' && var10[var16 + 3] != 'y') {
                  if (var0 >= 100) {
                     var0 %= 100;
                  }

                  if (var0 < 10) {
                     var12.append("0" + var0);
                  } else {
                     var12.append(var0);
                  }

                  ++var16;
               } else {
                  if (var0 < 1000) {
                     var12.append("0" + var0);
                  } else if (var0 < 100) {
                     var12.append("00" + var0);
                  } else if (var0 < 10) {
                     var12.append("000" + var0);
                  } else {
                     var12.append(var0);
                  }

                  var16 += 3;
               }
            }
         }
      }

      return var12.substring(0, var12.length());
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
            case -4:
            case -3:
            case -2:
               return this.getBytes(var1);
            case -1:
            case 1:
            case 12:
               return this.getString(var1);
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
}
