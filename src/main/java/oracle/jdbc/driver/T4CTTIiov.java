package oracle.jdbc.driver;

import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import oracle.jdbc.oracore.OracleTypeADT;

class T4CTTIiov extends T4CTTIMsg {
   T4C8TTIrxh rxh;
   T4CTTIrxd rxd;
   short bindtype = 0;
   byte[] iovector;
   int bindcnt = 0;
   int inbinds = 0;
   int outbinds = 0;
   static final byte BV_IN_V = 32;
   static final byte BV_OUT_V = 16;
   private static final String _Copyright_2007_Oracle_All_Rights_Reserved_ = null;
   public static final String BUILD_DATE = "Thu_Apr_04_15:09:24_PDT_2013";
   public static final boolean TRACE = false;

   T4CTTIiov(T4CConnection var1, T4C8TTIrxh var2, T4CTTIrxd var3) throws SQLException, IOException {
      super(var1, (byte)0);
      this.rxh = var2;
      this.rxd = var3;
   }

   void init() throws SQLException, IOException {
   }

   Accessor[] processRXD(Accessor[] var1, int var2, byte[] var3, char[] var4, short[] var5, int var6, DBConversion var7, byte[] var8, byte[] var9, InputStream[][] var10, byte[][][] var11, OracleTypeADT[][] var12, OracleStatement var13, byte[] var14, char[] var15, short[] var16) throws SQLException, IOException {
      if (var9 != null) {
         for(int var17 = 0; var17 < var9.length; ++var17) {
            if ((var9[var17] & 16) != 0 && (var1 == null || var1.length <= var17 || var1[var17] == null)) {
               int var18 = var6 + 5 + 10 * var17;
               int var19 = var5[var18 + 0] & '\uffff';
               if (var19 == 9) {
                  var19 = 1;
               }

               Accessor var21 = var13.allocateAccessor(var19, var19, var17, 0, (short)0, (String)null, false);
               var21.rowSpaceIndicator = null;
               if (var1 == null) {
                  var1 = new Accessor[var17 + 1];
                  var1[var17] = var21;
               } else if (var1.length > var17) {
                  var1[var17] = var21;
               } else {
                  Accessor[] var22 = new Accessor[var17 + 1];
                  var22[var17] = var21;

                  for(int var23 = 0; var23 < var1.length; ++var23) {
                     if (var1[var23] != null) {
                        var22[var23] = var1[var23];
                     }
                  }

                  var1 = var22;
               }
            } else if ((var9[var17] & 16) == 0 && var1 != null && var17 < var1.length && var1[var17] != null) {
               var1[var17].isUseLess = true;
            }
         }
      }

      return var1;
   }

   void unmarshalV10() throws IOException, SQLException {
      this.rxh.unmarshalV10(this.rxd);
      this.bindcnt = this.rxh.numRqsts;
      this.iovector = new byte[this.connection.all8.numberOfBindPositions];

      for(int var1 = 0; var1 < this.iovector.length; ++var1) {
         if ((this.bindtype = this.meg.unmarshalUB1()) == 0) {
            SQLException var2 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 401);
            var2.fillInStackTrace();
            throw var2;
         }

         byte[] var10000;
         if ((this.bindtype & 32) > 0) {
            var10000 = this.iovector;
            var10000[var1] = (byte)(var10000[var1] | 32);
            ++this.inbinds;
         }

         if ((this.bindtype & 16) > 0) {
            var10000 = this.iovector;
            var10000[var1] = (byte)(var10000[var1] | 16);
            ++this.outbinds;
         }
      }

   }

   byte[] getIOVector() {
      return this.iovector;
   }

   boolean isIOVectorEmpty() {
      return this.iovector.length == 0;
   }
}
