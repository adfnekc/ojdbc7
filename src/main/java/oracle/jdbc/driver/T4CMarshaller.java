package oracle.jdbc.driver;

import java.io.IOException;
import java.sql.SQLException;
import oracle.net.ns.BreakNetException;

abstract class T4CMarshaller {
   private static final T4CMarshaller BASIC = new T4CMarshaller.BasicMarshaller();
   private static final T4CMarshaller STREAM = new T4CMarshaller.StreamMarshaller();
   static final T4CMarshaller CHAR;
   static final T4CMarshaller LONG_RAW;
   static final T4CMarshaller RAW;
   static final T4CMarshaller VARCHAR;
   static final T4CMarshaller LONG;
   private static final String _Copyright_2007_Oracle_All_Rights_Reserved_;
   public static final String BUILD_DATE = "Thu_Apr_04_15:09:24_PDT_2013";
   public static final boolean TRACE = false;

   abstract boolean unmarshalOneRow(Accessor var1) throws SQLException, IOException;

   abstract int readStreamFromWire(byte[] var1, int var2, int var3, int[] var4, boolean[] var5, boolean[] var6, T4CMAREngine var7, T4CTTIoer var8) throws SQLException, IOException;

   private T4CMarshaller() {
   }

   // $FF: synthetic method
   T4CMarshaller(Object var1) {
      this();
   }

   static {
      CHAR = BASIC;
      LONG_RAW = STREAM;
      RAW = BASIC;
      VARCHAR = BASIC;
      LONG = STREAM;
      _Copyright_2007_Oracle_All_Rights_Reserved_ = null;
   }

   private static final class StreamMarshaller extends T4CMarshaller {
      private StreamMarshaller() {
         super(null);
      }

      boolean unmarshalOneRow(Accessor var1) throws SQLException, IOException {
         T4CAccessor var2 = (T4CAccessor)var1;
         T4CMAREngine var3 = var2.getMAREngine();
         if (var1.isUseless()) {
            ++var1.lastRowProcessed;
            return false;
         } else {
            boolean var4 = false;
            var1.escapeSequenceArr[0] = var3.unmarshalUB1();
            int var5;
            if (var3.escapeSequenceNull(var1.escapeSequenceArr[0])) {
               var1.setNull(var1.lastRowProcessed, true);
               var3.processIndicator(false, 0);
               var5 = (int)var3.unmarshalUB4();
               var1.escapeSequenceArr[0] = 0;
               var1.previousRowProcessed = var1.lastRowProcessed++;
            } else {
               var1.setNull(var1.lastRowProcessed, false);
               var1.readHeaderArr[0] = true;
               var1.readAsNonStreamArr[0] = false;
               if (!var1.statement.isFetchStreams && var1.definedColumnType != -2 && var1.definedColumnType != 12 && var1.definedColumnType != 1) {
                  var4 = true;
               } else {
                  var5 = 0;
                  int var6 = 0;
                  byte[] var7 = var1.statement.connection.getByteBuffer(32768);
                  var1.setOffset(var1.lastRowProcessed);

                  while(var5 != -1) {
                     var5 = this.readStreamFromWire(var7, 0, 32768, var1.escapeSequenceArr, var1.readHeaderArr, var1.readAsNonStreamArr, var3, ((T4CConnection)var1.statement.connection).oer);
                     if (var5 != -1) {
                        if (var1.statement.connection.checksumMode.needToCalculateFetchChecksum()) {
                           CRC64 var10000 = PhysicalConnection.CHECKSUM;
                           long var8 = CRC64.updateChecksum(var1.statement.checkSum, (byte[])var7, 0, var5);
                           var1.statement.checkSum = var8;
                        }

                        var1.rowData.put(var7, 0, var5);
                        var6 += var5;
                     }
                  }

                  var1.setLength(var1.lastRowProcessed, var6);
                  var1.previousRowProcessed = var1.lastRowProcessed++;
                  var1.isStream = false;
                  var1.statement.connection.cacheBuffer(var7);
               }
            }

            return var4;
         }
      }

      int readStreamFromWire(byte[] var1, int var2, int var3, int[] var4, boolean[] var5, boolean[] var6, T4CMAREngine var7, T4CTTIoer var8) throws SQLException, IOException {
         int var9 = -1;

         try {
            if (!var6[0]) {
               SQLException var10;
               if (var3 > 32768 || var3 < 0) {
                  var10 = DatabaseError.createSqlException((oracle.jdbc.internal.OracleConnection)null, 433);
                  var10.fillInStackTrace();
                  throw var10;
               }

               if (var5[0]) {
                  if (var4[0] == 254) {
                     if (var7.useCLRBigChunks) {
                        var9 = var7.unmarshalSB4();
                     } else {
                        var9 = var7.unmarshalUB1();
                     }
                  } else {
                     if (var4[0] == 0) {
                        var8.connection.internalClose();
                        var10 = DatabaseError.createSqlException((oracle.jdbc.internal.OracleConnection)null, 401);
                        var10.fillInStackTrace();
                        throw var10;
                     }

                     var6[0] = true;
                     var9 = var4[0];
                  }

                  var5[0] = false;
                  var4[0] = 0;
               } else if (var7.useCLRBigChunks) {
                  var9 = var7.unmarshalSB4();
               } else {
                  var9 = var7.unmarshalUB1();
               }
            } else {
               var6[0] = false;
            }

            if (var9 > 0) {
               var7.unmarshalNBytes(var1, var2, var9);
            } else {
               var9 = -1;
            }
         } catch (BreakNetException var11) {
            var9 = var7.unmarshalSB1();
            if (var9 == 4) {
               var8.init();
               var8.processError();
            }
         }

         if (var9 == -1) {
            var5[0] = true;
            var7.unmarshalUB2();
            var7.unmarshalUB2();
         }

         return var9;
      }

      // $FF: synthetic method
      StreamMarshaller(Object var1) {
         this();
      }
   }

   private static final class BasicMarshaller extends T4CMarshaller {
      private BasicMarshaller() {
         super(null);
      }

      boolean unmarshalOneRow(Accessor var1) throws SQLException, IOException {
         T4CAccessor var2 = (T4CAccessor)var1;
         boolean var3 = false;
         if (!var1.isUseless()) {
            if (var1.isUnexpected()) {
               long var4 = var1.rowData.getPosition();
               var2.unmarshalColumnMetadata();
               this.unmarshalBytes(var1);
               var1.rowData.setPosition(var4);
               var1.setNull(var1.lastRowProcessed, true);
            } else if (var1.isNullByDescribe()) {
               var1.setNull(var1.lastRowProcessed, true);
               var2.unmarshalColumnMetadata();
               if (var1.statement.connection.versionNumber < 9200) {
                  var2.processIndicator(0);
               }
            } else {
               var2.unmarshalColumnMetadata();
               var3 = this.unmarshalBytes(var1);
            }
         }

         var1.previousRowProcessed = var1.lastRowProcessed++;
         return var3;
      }

      private boolean unmarshalBytes(Accessor var1) throws SQLException, IOException {
         T4CAccessor var2 = (T4CAccessor)var1;
         T4CMAREngine var3 = var2.getMAREngine();
         var1.setOffset(var1.lastRowProcessed);
         int var4;
         if (var1.statement.maxFieldSize > 0) {
            var4 = ((DynamicByteArray)var1.rowData).unmarshalCLR(var3, var1.statement.maxFieldSize);
         } else {
            var4 = ((DynamicByteArray)var1.rowData).unmarshalCLR(var3);
         }

         var2.processIndicator(var4);
         var1.setLength(var1.lastRowProcessed, var4);
         var1.setNull(var1.lastRowProcessed, var4 == 0);
         return false;
      }

      int readStreamFromWire(byte[] var1, int var2, int var3, int[] var4, boolean[] var5, boolean[] var6, T4CMAREngine var7, T4CTTIoer var8) throws SQLException, IOException {
         return -1;
      }

      // $FF: synthetic method
      BasicMarshaller(Object var1) {
         this();
      }
   }
}
