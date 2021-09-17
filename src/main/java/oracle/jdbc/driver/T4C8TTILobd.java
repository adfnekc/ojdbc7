package oracle.jdbc.driver;

import java.io.IOException;
import java.net.SocketTimeoutException;
import java.sql.SQLException;

class T4C8TTILobd extends T4CTTIMsg {
   static final int LOBD_STATE0 = 0;
   static final int LOBD_STATE1 = 1;
   static final int LOBD_STATE2 = 2;
   static final int LOBD_STATE3 = 3;
   static final int LOBD_STATE_EXIT = 4;
   static final short TTCG_LNG = 254;
   static final short LOBDATALENGTH = 252;
   static byte[] ucs2Char = new byte[2];
   private static final String _Copyright_2007_Oracle_All_Rights_Reserved_ = null;
   public static final String BUILD_DATE = "Thu_Apr_04_15:09:24_PDT_2013";
   public static final boolean TRACE = false;

   T4C8TTILobd(T4CConnection var1) {
      super(var1, (byte)14);
   }

   void marshalLobData(byte[] var1, long var2, long var4, boolean var6) throws IOException {
      this.marshalTTCcode();
      if (var6) {
         this.meg.writeZeroCopyIO(var1, (int)var2, (int)var4);
      } else {
         this.meg.marshalCLR(var1, (int)var2, (int)var4);
      }

   }

   void marshalClobUB2_For9iDB(byte[] var1, long var2, long var4) throws IOException {
      long var6 = var4;
      boolean var8 = false;
      this.marshalTTCcode();
      if (var4 > 84L) {
         var8 = true;
         this.meg.marshalUB1((short)254);
      }

      long var9;
      for(var9 = 0L; var6 > 84L; var6 -= 84L) {
         this.meg.marshalUB1((short)252);

         for(int var11 = 0; var11 < 84; ++var11) {
            this.meg.marshalUB1((short)2);
            this.meg.marshalB1Array(var1, (int)(var2 + var9 * 168L + (long)(var11 * 2)), 2);
         }

         ++var9;
      }

      if (var6 > 0L) {
         long var14 = var6 * 3L;
         this.meg.marshalUB1((short)((int)var14));

         for(int var13 = 0; (long)var13 < var6; ++var13) {
            this.meg.marshalUB1((short)2);
            this.meg.marshalB1Array(var1, (int)(var2 + var9 * 168L + (long)(var13 * 2)), 2);
         }
      }

      if (var8) {
         this.meg.marshalUB1((short)0);
      }

   }

   long unmarshalLobData(byte[] var1, int var2, boolean var3) throws SQLException, IOException {
      boolean var4 = false;
      int var10;
      if (var3) {
         int var5 = 0;
         int[] var6 = new int[1];

         for(boolean var7 = false; !var7; var5 += var6[0]) {
            try {
               var7 = this.meg.readZeroCopyIO(var1, var2 + var5, var6);
            } catch (SocketTimeoutException var9) {
               this.connection.doAsynchronousClose();
               throw var9;
            }
         }

         var10 = var5;
      } else {
         boolean var11 = false;
         int[] var12 = new int[1];
         this.meg.unmarshalCLR(var1, var2, var12);
         var10 = var12[0];
      }

      return (long)var10;
   }

   long unmarshalClobUB2_For9iDB(byte[] var1, int var2) throws SQLException, IOException {
      long var3 = 0L;
      long var5 = (long)var2;
      short var7 = 0;
      boolean var8 = false;
      boolean var9 = false;
      byte var10 = 0;

      while(true) {
         while(var10 != 4) {
            int var11;
            int var12;
            switch(var10) {
            case 0:
               var7 = this.meg.unmarshalUB1();
               if (var7 == 254) {
                  var10 = 2;
               } else {
                  var10 = 1;
               }
               break;
            case 1:
               for(var11 = 0; var11 < var7; var3 += 2L) {
                  var12 = this.meg.unmarshalUCS2(var1, var5);
                  var11 += var12;
                  var5 += 2L;
               }

               var10 = 4;
               break;
            case 2:
               var7 = this.meg.unmarshalUB1();
               if (var7 > 0) {
                  var10 = 3;
               } else {
                  var10 = 4;
               }
               break;
            case 3:
               for(var11 = 0; var11 < var7; var3 += 2L) {
                  var12 = this.meg.unmarshalUCS2(var1, var5);
                  var11 += var12;
                  var5 += 2L;
               }

               var10 = 2;
            }
         }

         return var3;
      }
   }
}
