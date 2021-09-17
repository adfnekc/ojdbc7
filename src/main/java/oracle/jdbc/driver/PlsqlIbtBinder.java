package oracle.jdbc.driver;

import java.sql.SQLException;
import oracle.sql.Datum;

class PlsqlIbtBinder extends Binder {
   Binder thePlsqlIbtCopyingBinder;
   private static final String _Copyright_2007_Oracle_All_Rights_Reserved_ = null;
   public static final String BUILD_DATE = "Thu_Apr_04_15:09:24_PDT_2013";
   public static final boolean TRACE = false;

   PlsqlIbtBinder() {
      this.thePlsqlIbtCopyingBinder = OraclePreparedStatementReadOnly.theStaticPlsqlIbtCopyingBinder;
      init(this);
   }

   static void init(Binder var0) {
      var0.type = 998;
   }

   long bind(OraclePreparedStatement var1, int var2, int var3, int var4, byte[] var5, char[] var6, short[] var7, int var8, int var9, int var10, int var11, int var12, int var13, boolean var14, long var15) throws SQLException {
      PlsqlIbtBindInfo var17 = var1.parameterPlsqlIbt[var4][var2];
      if (var14) {
         var1.parameterPlsqlIbt[var4][var2] = null;
      }

      int var18 = var17.ibtValueIndex;
      int var19;
      switch(var17.element_internal_type) {
      case 6:
         for(var19 = 0; var19 < var17.curLen; ++var19) {
            byte[] var24 = null;
            if (var17.arrayData[var19] != null) {
               var24 = ((Datum)((Datum)var17.arrayData[var19])).getBytes();
            }

            if (var24 == null) {
               var1.ibtBindIndicators[var17.ibtIndicatorIndex + var19] = -1;
            } else {
               var1.ibtBindIndicators[var17.ibtIndicatorIndex + var19] = 0;
               var1.ibtBindIndicators[var17.ibtLengthIndex + var19] = (short)(var24.length + 1);
               var1.ibtBindBytes[var18] = (byte)var24.length;
               System.arraycopy(var24, 0, var1.ibtBindBytes, var18 + 1, var24.length);
            }

            var18 += var17.elemMaxLen;
            if (var1.connection.checksumMode.needToCalculateBindChecksum()) {
               CRC64 var10000;
               if (var24 == null) {
                  var10000 = PhysicalConnection.CHECKSUM;
                  var15 = CRC64.updateChecksum(var15, (byte[])Accessor.NULL_DATA_BYTES, 0, Accessor.NULL_DATA_BYTES.length);
               } else {
                  var10000 = PhysicalConnection.CHECKSUM;
                  var15 = CRC64.updateChecksum(var15, (byte[])var24, 0, var24.length);
               }
            }
         }

         return var15;
      case 9:
         for(var19 = 0; var19 < var17.curLen; ++var19) {
            boolean var20 = false;
            String var21 = (String)((String)var17.arrayData[var19]);
            if (var21 != null) {
               int var23 = var21.length();
               if (var23 > var17.elemMaxLen - 1) {
                  var23 = var17.elemMaxLen - 1;
               }

               var21.getChars(0, var23, var1.ibtBindChars, var18 + 1);
               var1.ibtBindIndicators[var17.ibtIndicatorIndex + var19] = 0;
               var23 <<= 1;
               var1.ibtBindChars[var18] = (char)var23;
               var1.ibtBindIndicators[var17.ibtLengthIndex + var19] = var23 == 0 ? 3 : (short)(var23 + 2);
            } else {
               var1.ibtBindIndicators[var17.ibtIndicatorIndex + var19] = -1;
            }

            var18 += var17.elemMaxLen;
         }

         return var15;
      default:
         SQLException var22 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 97);
         var22.fillInStackTrace();
         throw var22;
      }
   }

   Binder copyingBinder() {
      return this.thePlsqlIbtCopyingBinder;
   }
}
