package oracle.net.aso;

import java.util.Random;

public final class b {
   private int[][] b;
   private int[][] c;
   private byte d;
   protected byte[] a;
   // $FF: synthetic field
   private a e;

   protected b(a var1) {
      super();
      this.e = var1;
   }

   public final byte[] a(byte[] var1) throws c {
      if (var1 == null) {
         return null;
      } else if (var1.length == 0) {
         return new byte[0];
      } else {
         int var2 = var1.length;
         byte var4 = 0;
         byte[] var3;
         if (!oracle.net.aso.a.a(this.e)) {
            if ((var2 - 1) % 16 != 0) {
               throw new c(106);
            }

            byte var5;
            if ((var5 = var1[var2 - 1]) < 0 || var5 > 16) {
               throw new c(106);
            }

            if (this.e.a == 1) {
               this.a = new byte[16];
            }

            var3 = new byte[var2 - var5];
            var4 = 1;
         } else {
            var3 = new byte[var2];
         }

         byte[] var13 = new byte[16];
         byte[] var6 = new byte[16];

         for(int var7 = 0; var7 < var2 - var4; var7 += 16) {
            System.arraycopy(var1, var7, var13, 0, 16);
            byte[] var9 = var13;
            b var8 = this;
            int[] var11 = new int[4];

            for(int var12 = 0; var12 < var11.length; ++var12) {
               var11[var12] = oracle.net.aso.a.b(var9, var12);
            }

            int[] var16 = new int[var11.length];

            for(byte var15 = this.d; var15 > 2; var15 = (byte)(var15 - 2)) {
               var16[0] = var11[0] ^ var8.c[var15][0];
               var16[1] = var11[1] ^ var8.c[var15][1];
               var16[2] = var11[2] ^ var8.c[var15][2];
               var16[3] = var11[3] ^ var8.c[var15][3];
               var11[0] = oracle.net.aso.a.n()[oracle.net.aso.a.a(var16[0], 0)] ^ oracle.net.aso.a.o()[oracle.net.aso.a.a(var16[3], 1)] ^ oracle.net.aso.a.p()[oracle.net.aso.a.a(var16[2], 2)] ^ oracle.net.aso.a.q()[oracle.net.aso.a.a(var16[1], 3)];
               var11[1] = oracle.net.aso.a.n()[oracle.net.aso.a.a(var16[1], 0)] ^ oracle.net.aso.a.o()[oracle.net.aso.a.a(var16[0], 1)] ^ oracle.net.aso.a.p()[oracle.net.aso.a.a(var16[3], 2)] ^ oracle.net.aso.a.q()[oracle.net.aso.a.a(var16[2], 3)];
               var11[2] = oracle.net.aso.a.n()[oracle.net.aso.a.a(var16[2], 0)] ^ oracle.net.aso.a.o()[oracle.net.aso.a.a(var16[1], 1)] ^ oracle.net.aso.a.p()[oracle.net.aso.a.a(var16[0], 2)] ^ oracle.net.aso.a.q()[oracle.net.aso.a.a(var16[3], 3)];
               var11[3] = oracle.net.aso.a.n()[oracle.net.aso.a.a(var16[3], 0)] ^ oracle.net.aso.a.o()[oracle.net.aso.a.a(var16[2], 1)] ^ oracle.net.aso.a.p()[oracle.net.aso.a.a(var16[1], 2)] ^ oracle.net.aso.a.q()[oracle.net.aso.a.a(var16[0], 3)];
               var16[0] = var11[0] ^ var8.c[var15 - 1][0];
               var16[1] = var11[1] ^ var8.c[var15 - 1][1];
               var16[2] = var11[2] ^ var8.c[var15 - 1][2];
               var16[3] = var11[3] ^ var8.c[var15 - 1][3];
               var11[0] = oracle.net.aso.a.n()[oracle.net.aso.a.a(var16[0], 0)] ^ oracle.net.aso.a.o()[oracle.net.aso.a.a(var16[3], 1)] ^ oracle.net.aso.a.p()[oracle.net.aso.a.a(var16[2], 2)] ^ oracle.net.aso.a.q()[oracle.net.aso.a.a(var16[1], 3)];
               var11[1] = oracle.net.aso.a.n()[oracle.net.aso.a.a(var16[1], 0)] ^ oracle.net.aso.a.o()[oracle.net.aso.a.a(var16[0], 1)] ^ oracle.net.aso.a.p()[oracle.net.aso.a.a(var16[3], 2)] ^ oracle.net.aso.a.q()[oracle.net.aso.a.a(var16[2], 3)];
               var11[2] = oracle.net.aso.a.n()[oracle.net.aso.a.a(var16[2], 0)] ^ oracle.net.aso.a.o()[oracle.net.aso.a.a(var16[1], 1)] ^ oracle.net.aso.a.p()[oracle.net.aso.a.a(var16[0], 2)] ^ oracle.net.aso.a.q()[oracle.net.aso.a.a(var16[3], 3)];
               var11[3] = oracle.net.aso.a.n()[oracle.net.aso.a.a(var16[3], 0)] ^ oracle.net.aso.a.o()[oracle.net.aso.a.a(var16[2], 1)] ^ oracle.net.aso.a.p()[oracle.net.aso.a.a(var16[1], 2)] ^ oracle.net.aso.a.q()[oracle.net.aso.a.a(var16[0], 3)];
            }

            var16[0] = var11[0] ^ var8.c[2][0];
            var16[1] = var11[1] ^ var8.c[2][1];
            var16[2] = var11[2] ^ var8.c[2][2];
            var16[3] = var11[3] ^ var8.c[2][3];
            var11[0] = oracle.net.aso.a.n()[oracle.net.aso.a.a(var16[0], 0)] ^ oracle.net.aso.a.o()[oracle.net.aso.a.a(var16[3], 1)] ^ oracle.net.aso.a.p()[oracle.net.aso.a.a(var16[2], 2)] ^ oracle.net.aso.a.q()[oracle.net.aso.a.a(var16[1], 3)];
            var11[1] = oracle.net.aso.a.n()[oracle.net.aso.a.a(var16[1], 0)] ^ oracle.net.aso.a.o()[oracle.net.aso.a.a(var16[0], 1)] ^ oracle.net.aso.a.p()[oracle.net.aso.a.a(var16[3], 2)] ^ oracle.net.aso.a.q()[oracle.net.aso.a.a(var16[2], 3)];
            var11[2] = oracle.net.aso.a.n()[oracle.net.aso.a.a(var16[2], 0)] ^ oracle.net.aso.a.o()[oracle.net.aso.a.a(var16[1], 1)] ^ oracle.net.aso.a.p()[oracle.net.aso.a.a(var16[0], 2)] ^ oracle.net.aso.a.q()[oracle.net.aso.a.a(var16[3], 3)];
            var11[3] = oracle.net.aso.a.n()[oracle.net.aso.a.a(var16[3], 0)] ^ oracle.net.aso.a.o()[oracle.net.aso.a.a(var16[2], 1)] ^ oracle.net.aso.a.p()[oracle.net.aso.a.a(var16[1], 2)] ^ oracle.net.aso.a.q()[oracle.net.aso.a.a(var16[0], 3)];
            var16[0] = var11[0] ^ var8.c[1][0];
            var16[1] = var11[1] ^ var8.c[1][1];
            var16[2] = var11[2] ^ var8.c[1][2];
            var16[3] = var11[3] ^ var8.c[1][3];
            var6[0] = (byte)(oracle.net.aso.a.r()[oracle.net.aso.a.a(var16[0], 0)] ^ oracle.net.aso.a.a(var8.c[0][0], 0));
            var6[1] = (byte)(oracle.net.aso.a.r()[oracle.net.aso.a.a(var16[3], 1)] ^ oracle.net.aso.a.a(var8.c[0][0], 1));
            var6[2] = (byte)(oracle.net.aso.a.r()[oracle.net.aso.a.a(var16[2], 2)] ^ oracle.net.aso.a.a(var8.c[0][0], 2));
            var6[3] = (byte)(oracle.net.aso.a.r()[oracle.net.aso.a.a(var16[1], 3)] ^ oracle.net.aso.a.a(var8.c[0][0], 3));
            var6[4] = (byte)(oracle.net.aso.a.r()[oracle.net.aso.a.a(var16[1], 0)] ^ oracle.net.aso.a.a(var8.c[0][1], 0));
            var6[5] = (byte)(oracle.net.aso.a.r()[oracle.net.aso.a.a(var16[0], 1)] ^ oracle.net.aso.a.a(var8.c[0][1], 1));
            var6[6] = (byte)(oracle.net.aso.a.r()[oracle.net.aso.a.a(var16[3], 2)] ^ oracle.net.aso.a.a(var8.c[0][1], 2));
            var6[7] = (byte)(oracle.net.aso.a.r()[oracle.net.aso.a.a(var16[2], 3)] ^ oracle.net.aso.a.a(var8.c[0][1], 3));
            var6[8] = (byte)(oracle.net.aso.a.r()[oracle.net.aso.a.a(var16[2], 0)] ^ oracle.net.aso.a.a(var8.c[0][2], 0));
            var6[9] = (byte)(oracle.net.aso.a.r()[oracle.net.aso.a.a(var16[1], 1)] ^ oracle.net.aso.a.a(var8.c[0][2], 1));
            var6[10] = (byte)(oracle.net.aso.a.r()[oracle.net.aso.a.a(var16[0], 2)] ^ oracle.net.aso.a.a(var8.c[0][2], 2));
            var6[11] = (byte)(oracle.net.aso.a.r()[oracle.net.aso.a.a(var16[3], 3)] ^ oracle.net.aso.a.a(var8.c[0][2], 3));
            var6[12] = (byte)(oracle.net.aso.a.r()[oracle.net.aso.a.a(var16[3], 0)] ^ oracle.net.aso.a.a(var8.c[0][3], 0));
            var6[13] = (byte)(oracle.net.aso.a.r()[oracle.net.aso.a.a(var16[2], 1)] ^ oracle.net.aso.a.a(var8.c[0][3], 1));
            var6[14] = (byte)(oracle.net.aso.a.r()[oracle.net.aso.a.a(var16[1], 2)] ^ oracle.net.aso.a.a(var8.c[0][3], 2));
            var6[15] = (byte)(oracle.net.aso.a.r()[oracle.net.aso.a.a(var16[0], 3)] ^ oracle.net.aso.a.a(var8.c[0][3], 3));
            if (this.e.a == 1) {
               for(int var14 = 0; var14 < 16; ++var14) {
                  var6[var14] ^= this.a[var14];
               }

               System.arraycopy(var13, 0, this.a, 0, 16);
            }

            if (var7 == var2 - var4 - 16) {
               System.arraycopy(var6, 0, var3, var7, var3.length - var7);
            } else {
               System.arraycopy(var6, 0, var3, var7, 16);
            }
         }

         return var3;
      }
   }

   public final byte[] b(byte[] var1) {
      if (var1 == null) {
         return null;
      } else if (var1.length == 0) {
         return new byte[0];
      } else {
         int var2 = var1.length;
         int var3 = 0;
         int var4 = 0;
         byte[] var5;
         if (!oracle.net.aso.a.a(this.e)) {
            var3 = var2 % 16 == 0 ? 0 : 16 - var2 % 16;
            var5 = new byte[(var4 = var2 + var3) + 1];
            if (this.e.a == 1) {
               this.a = new byte[16];
            }
         } else {
            var5 = new byte[var2];
         }

         byte[] var6 = new byte[16];
         byte[] var7 = new byte[16];

         for(int var8 = 0; var8 < var2; var8 += 16) {
            int var9;
            for(var9 = 0; var9 < 16; ++var9) {
               var7[var9] = 0;
            }

            if (var8 + 16 <= var2) {
               System.arraycopy(var1, var8, var7, 0, 16);
            } else {
               System.arraycopy(var1, var8, var7, 0, var2 - var8);
            }

            if (this.e.a == 1) {
               for(var9 = 0; var9 < 16; ++var9) {
                  var7[var9] ^= this.a[var9];
               }
            }

            byte[] var10 = var7;
            b var14 = this;
            int[] var12 = new int[4];

            for(int var13 = 0; var13 < var12.length; ++var13) {
               var12[var13] = oracle.net.aso.a.b(var10, var13);
            }

            int[] var16 = new int[var12.length];

            for(int var15 = 0; var15 < var14.d - 2; var15 += 2) {
               var16[0] = var12[0] ^ var14.b[var15][0];
               var16[1] = var12[1] ^ var14.b[var15][1];
               var16[2] = var12[2] ^ var14.b[var15][2];
               var16[3] = var12[3] ^ var14.b[var15][3];
               var12[0] = oracle.net.aso.a.i()[oracle.net.aso.a.a(var16[0], 0)] ^ oracle.net.aso.a.j()[oracle.net.aso.a.a(var16[1], 1)] ^ oracle.net.aso.a.k()[oracle.net.aso.a.a(var16[2], 2)] ^ oracle.net.aso.a.l()[oracle.net.aso.a.a(var16[3], 3)];
               var12[1] = oracle.net.aso.a.i()[oracle.net.aso.a.a(var16[1], 0)] ^ oracle.net.aso.a.j()[oracle.net.aso.a.a(var16[2], 1)] ^ oracle.net.aso.a.k()[oracle.net.aso.a.a(var16[3], 2)] ^ oracle.net.aso.a.l()[oracle.net.aso.a.a(var16[0], 3)];
               var12[2] = oracle.net.aso.a.i()[oracle.net.aso.a.a(var16[2], 0)] ^ oracle.net.aso.a.j()[oracle.net.aso.a.a(var16[3], 1)] ^ oracle.net.aso.a.k()[oracle.net.aso.a.a(var16[0], 2)] ^ oracle.net.aso.a.l()[oracle.net.aso.a.a(var16[1], 3)];
               var12[3] = oracle.net.aso.a.i()[oracle.net.aso.a.a(var16[3], 0)] ^ oracle.net.aso.a.j()[oracle.net.aso.a.a(var16[0], 1)] ^ oracle.net.aso.a.k()[oracle.net.aso.a.a(var16[1], 2)] ^ oracle.net.aso.a.l()[oracle.net.aso.a.a(var16[2], 3)];
               var16[0] = var12[0] ^ var14.b[var15 + 1][0];
               var16[1] = var12[1] ^ var14.b[var15 + 1][1];
               var16[2] = var12[2] ^ var14.b[var15 + 1][2];
               var16[3] = var12[3] ^ var14.b[var15 + 1][3];
               var12[0] = oracle.net.aso.a.i()[oracle.net.aso.a.a(var16[0], 0)] ^ oracle.net.aso.a.j()[oracle.net.aso.a.a(var16[1], 1)] ^ oracle.net.aso.a.k()[oracle.net.aso.a.a(var16[2], 2)] ^ oracle.net.aso.a.l()[oracle.net.aso.a.a(var16[3], 3)];
               var12[1] = oracle.net.aso.a.i()[oracle.net.aso.a.a(var16[1], 0)] ^ oracle.net.aso.a.j()[oracle.net.aso.a.a(var16[2], 1)] ^ oracle.net.aso.a.k()[oracle.net.aso.a.a(var16[3], 2)] ^ oracle.net.aso.a.l()[oracle.net.aso.a.a(var16[0], 3)];
               var12[2] = oracle.net.aso.a.i()[oracle.net.aso.a.a(var16[2], 0)] ^ oracle.net.aso.a.j()[oracle.net.aso.a.a(var16[3], 1)] ^ oracle.net.aso.a.k()[oracle.net.aso.a.a(var16[0], 2)] ^ oracle.net.aso.a.l()[oracle.net.aso.a.a(var16[1], 3)];
               var12[3] = oracle.net.aso.a.i()[oracle.net.aso.a.a(var16[3], 0)] ^ oracle.net.aso.a.j()[oracle.net.aso.a.a(var16[0], 1)] ^ oracle.net.aso.a.k()[oracle.net.aso.a.a(var16[1], 2)] ^ oracle.net.aso.a.l()[oracle.net.aso.a.a(var16[2], 3)];
            }

            var16[0] = var12[0] ^ var14.b[var14.d - 2][0];
            var16[1] = var12[1] ^ var14.b[var14.d - 2][1];
            var16[2] = var12[2] ^ var14.b[var14.d - 2][2];
            var16[3] = var12[3] ^ var14.b[var14.d - 2][3];
            var12[0] = oracle.net.aso.a.i()[oracle.net.aso.a.a(var16[0], 0)] ^ oracle.net.aso.a.j()[oracle.net.aso.a.a(var16[1], 1)] ^ oracle.net.aso.a.k()[oracle.net.aso.a.a(var16[2], 2)] ^ oracle.net.aso.a.l()[oracle.net.aso.a.a(var16[3], 3)];
            var12[1] = oracle.net.aso.a.i()[oracle.net.aso.a.a(var16[1], 0)] ^ oracle.net.aso.a.j()[oracle.net.aso.a.a(var16[2], 1)] ^ oracle.net.aso.a.k()[oracle.net.aso.a.a(var16[3], 2)] ^ oracle.net.aso.a.l()[oracle.net.aso.a.a(var16[0], 3)];
            var12[2] = oracle.net.aso.a.i()[oracle.net.aso.a.a(var16[2], 0)] ^ oracle.net.aso.a.j()[oracle.net.aso.a.a(var16[3], 1)] ^ oracle.net.aso.a.k()[oracle.net.aso.a.a(var16[0], 2)] ^ oracle.net.aso.a.l()[oracle.net.aso.a.a(var16[1], 3)];
            var12[3] = oracle.net.aso.a.i()[oracle.net.aso.a.a(var16[3], 0)] ^ oracle.net.aso.a.j()[oracle.net.aso.a.a(var16[0], 1)] ^ oracle.net.aso.a.k()[oracle.net.aso.a.a(var16[1], 2)] ^ oracle.net.aso.a.l()[oracle.net.aso.a.a(var16[2], 3)];
            var16[0] = var12[0] ^ var14.b[var14.d - 1][0];
            var16[1] = var12[1] ^ var14.b[var14.d - 1][1];
            var16[2] = var12[2] ^ var14.b[var14.d - 1][2];
            var16[3] = var12[3] ^ var14.b[var14.d - 1][3];
            var6[0] = (byte)(oracle.net.aso.a.m()[oracle.net.aso.a.a(var16[0], 0)] ^ oracle.net.aso.a.a(var14.b[var14.d][0], 0));
            var6[1] = (byte)(oracle.net.aso.a.m()[oracle.net.aso.a.a(var16[1], 1)] ^ oracle.net.aso.a.a(var14.b[var14.d][0], 1));
            var6[2] = (byte)(oracle.net.aso.a.m()[oracle.net.aso.a.a(var16[2], 2)] ^ oracle.net.aso.a.a(var14.b[var14.d][0], 2));
            var6[3] = (byte)(oracle.net.aso.a.m()[oracle.net.aso.a.a(var16[3], 3)] ^ oracle.net.aso.a.a(var14.b[var14.d][0], 3));
            var6[4] = (byte)(oracle.net.aso.a.m()[oracle.net.aso.a.a(var16[1], 0)] ^ oracle.net.aso.a.a(var14.b[var14.d][1], 0));
            var6[5] = (byte)(oracle.net.aso.a.m()[oracle.net.aso.a.a(var16[2], 1)] ^ oracle.net.aso.a.a(var14.b[var14.d][1], 1));
            var6[6] = (byte)(oracle.net.aso.a.m()[oracle.net.aso.a.a(var16[3], 2)] ^ oracle.net.aso.a.a(var14.b[var14.d][1], 2));
            var6[7] = (byte)(oracle.net.aso.a.m()[oracle.net.aso.a.a(var16[0], 3)] ^ oracle.net.aso.a.a(var14.b[var14.d][1], 3));
            var6[8] = (byte)(oracle.net.aso.a.m()[oracle.net.aso.a.a(var16[2], 0)] ^ oracle.net.aso.a.a(var14.b[var14.d][2], 0));
            var6[9] = (byte)(oracle.net.aso.a.m()[oracle.net.aso.a.a(var16[3], 1)] ^ oracle.net.aso.a.a(var14.b[var14.d][2], 1));
            var6[10] = (byte)(oracle.net.aso.a.m()[oracle.net.aso.a.a(var16[0], 2)] ^ oracle.net.aso.a.a(var14.b[var14.d][2], 2));
            var6[11] = (byte)(oracle.net.aso.a.m()[oracle.net.aso.a.a(var16[1], 3)] ^ oracle.net.aso.a.a(var14.b[var14.d][2], 3));
            var6[12] = (byte)(oracle.net.aso.a.m()[oracle.net.aso.a.a(var16[3], 0)] ^ oracle.net.aso.a.a(var14.b[var14.d][3], 0));
            var6[13] = (byte)(oracle.net.aso.a.m()[oracle.net.aso.a.a(var16[0], 1)] ^ oracle.net.aso.a.a(var14.b[var14.d][3], 1));
            var6[14] = (byte)(oracle.net.aso.a.m()[oracle.net.aso.a.a(var16[1], 2)] ^ oracle.net.aso.a.a(var14.b[var14.d][3], 2));
            var6[15] = (byte)(oracle.net.aso.a.m()[oracle.net.aso.a.a(var16[2], 3)] ^ oracle.net.aso.a.a(var14.b[var14.d][3], 3));
            if (this.e.a == 1) {
               System.arraycopy(var6, 0, this.a, 0, 16);
            }

            System.arraycopy(var6, 0, var5, var8, 16);
         }

         if (!oracle.net.aso.a.a(this.e)) {
            var5[var4] = (byte)(var3 + 1);
         }

         return var5;
      }
   }

   // $FF: synthetic method
   static void a(b var0, byte[] var1) throws c {
      var0 = var0;
      byte[][] var4 = new byte[var1.length / 4][4];
      byte var2 = 0;

      byte var3;
      for(var3 = 0; var2 < var1.length; ++var3) {
         var4[var3][0] = var1[var2];
         var4[var3][1] = var1[var2 + 1];
         var4[var3][2] = var1[var2 + 2];
         var4[var3][3] = var1[var2 + 3];
         var2 = (byte)(var2 + 4);
      }

      byte var7 = var3;
      var0.d = (byte)(var3 + 6);
      var3 = 0;
      byte var5 = 0;
      var0.b = new int[var0.d + 1][4];
      var0.c = new int[var0.d + 1][4];
      var2 = 0;

      while(var2 < var7 && var5 < var0.d + 1) {
         while(var2 < var7 && var3 < 4) {
            var0.c[var5][var3] = var0.b[var5][var3] = oracle.net.aso.a.a((byte[][])var4, var2);
            ++var2;
            ++var3;
         }

         if (var3 == 4) {
            ++var5;
            var3 = 0;
         }
      }

      byte var6 = 0;

      while(var5 < var0.d + 1) {
         var4[0][0] ^= (byte)oracle.net.aso.a.c()[255 & var4[var7 - 1][1]];
         var4[0][1] ^= (byte)oracle.net.aso.a.c()[255 & var4[var7 - 1][2]];
         var4[0][2] ^= (byte)oracle.net.aso.a.c()[255 & var4[var7 - 1][3]];
         var4[0][3] ^= (byte)oracle.net.aso.a.c()[255 & var4[var7 - 1][0]];
         var4[0][0] ^= (byte)oracle.net.aso.a.d()[var6++];
         oracle.net.aso.a.a(var4, 1, oracle.net.aso.a.a((byte[][])var4, 1) ^ oracle.net.aso.a.a((byte[][])var4, 0));
         oracle.net.aso.a.a(var4, 2, oracle.net.aso.a.a((byte[][])var4, 2) ^ oracle.net.aso.a.a((byte[][])var4, 1));
         oracle.net.aso.a.a(var4, 3, oracle.net.aso.a.a((byte[][])var4, 3) ^ oracle.net.aso.a.a((byte[][])var4, 2));
         switch(var7) {
         case 4:
            break;
         case 5:
         case 7:
         default:
            throw new c(102);
         case 6:
            oracle.net.aso.a.a(var4, 4, oracle.net.aso.a.a((byte[][])var4, 4) ^ oracle.net.aso.a.a((byte[][])var4, 3));
            oracle.net.aso.a.a(var4, 5, oracle.net.aso.a.a((byte[][])var4, 5) ^ oracle.net.aso.a.a((byte[][])var4, 4));
            break;
         case 8:
            var4[4][0] ^= (byte)oracle.net.aso.a.c()[255 & var4[3][0]];
            var4[4][1] ^= (byte)oracle.net.aso.a.c()[255 & var4[3][1]];
            var4[4][2] ^= (byte)oracle.net.aso.a.c()[255 & var4[3][2]];
            var4[4][3] ^= (byte)oracle.net.aso.a.c()[255 & var4[3][3]];
            oracle.net.aso.a.a(var4, 5, oracle.net.aso.a.a((byte[][])var4, 5) ^ oracle.net.aso.a.a((byte[][])var4, 4));
            oracle.net.aso.a.a(var4, 6, oracle.net.aso.a.a((byte[][])var4, 6) ^ oracle.net.aso.a.a((byte[][])var4, 5));
            oracle.net.aso.a.a(var4, 7, oracle.net.aso.a.a((byte[][])var4, 7) ^ oracle.net.aso.a.a((byte[][])var4, 6));
         }

         var2 = 0;

         while(var2 < var7 && var5 < var0.d + 1) {
            while(var2 < var7 && var3 < 4) {
               var0.c[var5][var3] = var0.b[var5][var3] = oracle.net.aso.a.a((byte[][])var4, var2);
               ++var2;
               ++var3;
            }

            if (var3 == 4) {
               ++var5;
               var3 = 0;
            }
         }
      }

      for(var5 = 1; var5 < var0.d; ++var5) {
         for(var2 = 0; var2 < 4; ++var2) {
            int var8 = var0.c[var5][var2];
            var0.c[var5][var2] = oracle.net.aso.a.e()[oracle.net.aso.a.a(var8, 0)] ^ oracle.net.aso.a.f()[oracle.net.aso.a.a(var8, 1)] ^ oracle.net.aso.a.g()[oracle.net.aso.a.a(var8, 2)] ^ oracle.net.aso.a.h()[oracle.net.aso.a.a(var8, 3)];
         }
      }

   }

   public static void a(char[] var0, int var1, byte[] var2, int var3) {
      int var4 = var3 - 1;
      int var5 = 0;
      int var6 = var1 < var3 / 2 ? var1 : var3 / 2;
      var1 -= var6;

      for(var3 -= 2 * var6; var6-- > 0; var4 -= 2) {
         var0[var5] = (char)((255 & (char)var2[var4]) + ((255 & (char)var2[var4 - 1]) << 8));
         ++var5;
      }

      if (var1 > 0 && var3 % 2 == 1) {
         var0[var5] = (char)(255 & (char)var2[var4]);
         ++var5;
         --var1;
      }

      while(var1-- > 0) {
         var0[var5++] = 0;
      }

   }

   public static void a(byte[] var0, int var1, char[] var2, int var3) {
      int var4 = var1 - 1;
      int var5 = 0;
      int var6 = var3 < var1 / 2 ? var3 : var1 / 2;
      var3 -= var6;

      for(var1 -= 2 * var6; var6-- > 0; ++var5) {
         var0[var4--] = (byte)(255 & (byte)var2[var5]);
         var0[var4--] = (byte)(var2[var5] >>> 8);
      }

      if (var3 > 0 && var1 % 2 == 1) {
         var0[var4--] = (byte)(255 & (byte)var2[var5]);
      }

      while(var4-- > 0) {
         var0[var4--] = 0;
      }

   }

   public static void a(char[] var0, char[] var1, char[] var2, char[] var3, int var4) {
      char[] var5 = new char[259];
      boolean[] var6 = new boolean[64];
      char[][] var8 = new char[16][257];
      char[] var9 = new char[257];
      char[] var7 = var5;
      char[] var10 = new char[518];
      char[] var13 = new char[520];
      char[] var11 = new char[260];
      int var14 = b(var3, var4);
      int var15;
      int var16 = (var15 = a(2 * var14)) / 16;
      int var17 = (var14 - 2) / 16;
      int var10001 = var15 - var14;
      int var20 = var4 + 2;
      int var19 = var10001;
      char[] var18 = var5;

      for(var14 = 0; var14 < var20; ++var14) {
         var18[var14] = 0;
      }

      var18[var19 / 16] = (char)(1 << var19 % 16);
      c(var5, var20);
      d(var11, var4 + 3);
      a(var11, var3, var4);
      int var28 = var19 + 1 - 1;

      for(var19 = 0; var28 > 0; var28 >>>= 1) {
         ++var19;
      }

      int var12;
      for(var12 = 1 + var19; var12 > 0; --var12) {
         b(var10, var7, var4 + 2);
         var14 = var4 + 3;
         char[] var30 = var10;
         char[] var29 = var11;
         var18 = var13;
         d(var13, 2 * var14);
         int var21 = a(var10, var17, var14);

         for(int var22 = 0; var22 < var14; ++var22) {
            var18[var21 + var22] = a(var18, var22, var29[var22], var30, var17, var21);
         }

         a(var7, var7, var7, var4 + 2);
         a(var7, var7, var13, var16 - var17, var4 + 2);
      }

      c(var7, var4 + 2);

      while(true) {
         b(var10, var7, var11, var4 + 2);
         e(var10, 2 * (var4 + 2));
         if (b(var10, 2 * (var4 + 2)) <= var15) {
            int var24;
            byte var25;
            if ((var24 = b(var2, var4)) < 4) {
               var25 = 1;
            } else if (var24 < 16) {
               var25 = 2;
            } else if (var24 < 64) {
               var25 = 3;
            } else {
               var25 = 4;
            }

            (var7 = var8[0])[0] = 1;

            for(int var26 = 1; var26 < var4; ++var26) {
               var7[var26] = 0;
            }

            a(var8[1], var1, var4);
            var6[0] = true;
            var6[1] = true;

            for(var12 = 2; var12 < 64; ++var12) {
               var6[var12] = false;
            }

            var12 = 0;
            boolean var23 = false;

            for(char var27 = (char)(1 << var24 % 16); var24 >= 0; --var24) {
               if (var23) {
                  b(var9, var9, var3, var5, var4);
               }

               var12 <<= 1;
               if (!var6[var12]) {
                  b(var8[var12], var8[var12 / 2], var3, var5, var4);
                  var6[var12] = true;
               }

               if ((var2[var24 / 16] & var27) > 0) {
                  ++var12;
               }

               if (var27 == 1) {
                  var27 = '耀';
               } else {
                  var27 = (char)(var27 >>> 1 & 32767);
               }

               if (!var6[var12]) {
                  a(var8[var12], var8[var12 - 1], var1, var3, var5, var4);
                  var6[var12] = true;
               }

               if (var24 == 0 || var12 >= 1 << var25 - 1) {
                  if (var23) {
                     a(var9, var9, var8[var12], var3, var5, var4);
                  } else {
                     a(var9, var8[var12], var4);
                  }

                  var12 = 0;
                  var23 = true;
               }
            }

            a(var0, var9, var4);
            return;
         }

         e(var7, var4 + 2);
      }
   }

   private static int a(char[] var0, int var1) {
      if ((var0[var1 - 1] & '耀') > 0) {
         return -1;
      } else {
         --var1;

         while(var1 >= 0) {
            if (var0[var1] > 0) {
               return 1;
            }

            --var1;
         }

         return 0;
      }
   }

   private static int b(char[] var0, int var1) {
      char var2 = (char)((var0[var1 - 1] & '耀') > 0 ? -1 : 0);
      --var1;

      while(var1 >= 0 && var0[var1] == var2) {
         --var1;
      }

      if (var1 == -1) {
         return 1;
      } else {
         int var4 = 16;

         for(int var3 = 32768; var4 >= 0 && 0 == (var3 & (var2 ^ var0[var1])); var3 >>>= 1) {
            --var4;
         }

         return (var1 << 4) + var4;
      }
   }

   private static int a(int var0) {
      return 16 * ((var0 + 1 + 15) / 16);
   }

   private static void c(char[] var0, int var1) {
      boolean var2 = true;

      int var3;
      for(var3 = 0; var3 < var1 - 1 && var2; ++var3) {
         ++var0[var3];
         if (var0[var3] > 0) {
            var2 = false;
         }
      }

      if (var2) {
         ++var0[var3];
      }

   }

   private static void d(char[] var0, int var1) {
      for(int var2 = 0; var2 < var1; var0[var2++] = 0) {
      }

   }

   private static void a(char[] var0, char[] var1, int var2) {
      for(int var3 = 0; var3 < var2; ++var3) {
         var0[var3] = var1[var3];
      }

   }

   private static int a(char[] var0, int var1, int var2) {
      --var2;

      while(var2 >= 0) {
         if (var0[var2 + var1] > 0) {
            return var2 + 1;
         }

         --var2;
      }

      return 0;
   }

   private static char a(char[] var0, int var1, char var2, char[] var3, int var4, int var5) {
      int var6 = 0;
      if (var2 <= 0) {
         return '\u0000';
      } else {
         for(int var7 = 0; var7 < var5; ++var7) {
            var6 = var6 + var2 * var3[var7 + var4] + var0[var7 + var1];
            var0[var7 + var1] = (char)var6;
            var6 >>>= 16;
         }

         return (char)var6;
      }
   }

   private static void a(char[] var0, char[] var1, char[] var2, int var3) {
      int var4 = 0;

      for(int var5 = 0; var5 < var3; ++var5) {
         var4 = var4 + var1[var5] + var2[var5];
         var0[var5] = (char)var4;
         var4 >>>= 16;
      }

   }

   private static void a(char[] var0, char[] var1, char[] var2, int var3, int var4) {
      int var5 = 1;

      for(int var6 = 0; var6 < var4; ++var6) {
         var5 = var5 + var1[var6] + (~var2[var6 + var3] & '\uffff');
         var0[var6] = (char)var5;
         var5 >>>= 16;
      }

   }

   private static void b(char[] var0, char[] var1, int var2) {
      int var3 = 0;
      d(var0, 2 * var2);
      int var4;
      if ((var4 = a(var1, 0, var2)) > 0) {
         int var5;
         for(var5 = 0; var5 < var4 - 1; ++var5) {
            var0[var4 + var5] = a(var0, 2 * var5 + 1, var1[var5], var1, var5 + 1, var4 - var5 - 1);
         }

         a(var0, var0, var0, 2 * var2);

         for(var5 = 0; var5 < var4; ++var5) {
            var3 = var3 + var1[var5] * var1[var5] + var0[2 * var5];
            var0[2 * var5] = (char)var3;
            var3 = (var3 >>> 16) + var0[2 * var5 + 1];
            var0[2 * var5 + 1] = (char)var3;
            var3 >>>= 16;
         }

         var0[2 * var5] = (char)var3;
      }
   }

   private static void e(char[] var0, int var1) {
      boolean var2 = true;

      int var3;
      for(var3 = 0; var3 < var1 - 1 && var2; ++var3) {
         --var0[var3];
         if (var0[var3] != '\uffff') {
            var2 = false;
         }
      }

      if (var2) {
         --var0[var3];
      }

   }

   private static void b(char[] var0, char[] var1, char[] var2, char[] var3, int var4) {
      char[] var5;
      b(var5 = new char[514], var1, var4);
      c(var0, var5, var2, var3, var4);
   }

   private static void a(char[] var0, char[] var1, char[] var2, char[] var3, char[] var4, int var5) {
      char[] var6;
      b(var6 = new char[514], var1, var2, var5);
      c(var0, var6, var3, var4, var5);
   }

   private static void b(char[] var0, char[] var1, char[] var2, int var3) {
      d(var0, 2 * var3);
      int var4 = a(var2, 0, var3);

      for(int var5 = 0; var5 < var3; ++var5) {
         var0[var4 + var5] = a(var0, var5, var1[var5], var2, 0, var4);
      }

   }

   private static void c(char[] var0, char[] var1, char[] var2, char[] var3, int var4) {
      char[] var10000 = new char[257];
      int var5 = var4;
      char[] var17 = var3;
      var3 = var2;
      var2 = var1;
      var1 = var0;
      var0 = var10000;
      char[] var6 = new char[518];
      char[] var7 = new char[518];
      char[] var8 = new char[516];
      int var11 = b(var3, var4);
      int var10 = a(2 * var11) / 16;
      var11 = (var11 - 2) / 16;
      int var9;
      if ((var9 = var10 - var11 - 3) < 0) {
         var9 = 0;
      }

      d(var8, 2 * var4 + 2);
      a(var8, var2, 2 * var4);
      int var13 = var4 + 2;
      int var12 = var9;
      boolean var18 = false;
      char[] var19 = var8;
      var8 = var17;
      var17 = var7;
      d(var7, 2 * var13);
      int var15 = a(var19, var11, var13);
      int var21 = var9 >= var13 - 1 ? var9 - (var13 - 1) : 0;
      boolean var14 = false;

      for(int var16 = var21; var16 < var13; ++var16) {
         int var20 = var12 >= var16 ? var12 - var16 : 0;
         var17[var15 + var16] = a(var17, var16 + var20, var8[var16], var19, var20 + var11, var15 >= var20 ? var15 - var20 : 0);
      }

      for(var4 = 0; var4 < var5; ++var4) {
         var0[var4] = var7[var4 + (var10 - var11)];
      }

      var19 = var3;
      var8 = var0;
      var17 = var6;
      d(var6, var5);
      var12 = a(var3, 0, var5);

      for(var13 = 0; var13 < var5; ++var13) {
         if (var12 < var5 - var13) {
            var17[var12 + var13] = a(var17, var13, var8[var13], var19, 0, var12);
         } else {
            a(var17, var13, var8[var13], var19, 0, var5 - var13);
         }
      }

      a(var1, var2, var6, 0, var5);

      while(true) {
         var8 = var3;
         var17 = var1;
         var9 = a(var1, var5);
         var12 = a(var3, var5);
         byte var22;
         if (var9 > var12) {
            var22 = 1;
         } else {
            label99: {
               if (var9 >= var12) {
                  for(var13 = var5 - 1; var13 >= 0 && var17[var13] == var8[var13]; --var13) {
                  }

                  if (var13 == -1) {
                     var22 = 0;
                     break label99;
                  }

                  if (var17[var13] > var8[var13]) {
                     var22 = 1;
                     break label99;
                  }
               }

               var22 = -1;
            }
         }

         if (var22 < 0) {
            return;
         }

         a(var1, var1, var3, 0, var5);
         c(var0, var5);
      }
   }

   public static byte[] c(byte[] var0) {
      byte[] var1 = new byte[8];
      byte[] var2 = new byte[8];
      Random var3;
      (var3 = new Random()).nextBytes(var1);
      var3.nextBytes(var2);
      byte[] var8 = new byte[]{121, 111, 114, -123, -82, -107, -109, 0};
      byte[] var4 = new byte[8];

      for(int var5 = 0; var5 < var1.length; ++var5) {
         var4[var5] = (byte)(var1[var5] ^ var2[var5] ^ var8[var5]);
      }

      f var10 = new f();
      var8 = new byte[8];

      try {
         var10.a(var4, var8);
      } catch (Exception var6) {
      }

      int var9 = (var0 = var10.a(var0, var0.length)).length - 1;
      var4 = new byte[var1.length + var2.length + var9];
      System.arraycopy(var1, 0, var4, 0, var1.length);
      System.arraycopy(var0, 0, var4, var1.length, var9 / 2);
      System.arraycopy(var2, 0, var4, var1.length + var9 / 2, var2.length);
      System.arraycopy(var0, var9 / 2, var4, var1.length + var9 / 2 + var2.length, var9 - var9 / 2);
      l var7;
      (var7 = new l()).a(var4, 0, var4.length);
      var1 = new byte[var7.b()];
      var7.a(var1);
      var0 = new byte[var4.length + var1.length];
      System.arraycopy(var4, 0, var0, 0, var4.length);
      System.arraycopy(var1, 0, var0, var4.length, var1.length);
      return var0;
   }
}
