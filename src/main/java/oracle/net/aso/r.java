package oracle.net.aso;

final class r implements m {
   private int[] a = new int[80];
   private long b;
   private int[] c = new int[5];

   r() {
      this.a();
   }

   public final int b() {
      return 20;
   }

   private void a(byte var1) {
      int var2 = ((int)this.b & 63) >>> 2;
      int var3 = (~((int)this.b) & 3) << 3;
      this.a[var2] = this.a[var2] & ~(255 << var3) | (var1 & 255) << var3;
      if (((int)this.b & 63) == 63) {
         this.c();
      }

      ++this.b;
   }

   public final void a(byte[] var1, int var2, int var3) {
      while(var3 > 0) {
         if (((int)this.b & 3) == 0 && var3 >= 4) {
            int var4 = ((int)this.b & 63) >> 2;
            this.a[var4] = (var1[var2] & 255) << 24 | (var1[var2 + 1] & 255) << 16 | (var1[var2 + 2] & 255) << 8 | var1[var2 + 3] & 255;
            this.b += 4L;
            if (((int)this.b & 63) == 0) {
               this.c();
            }

            var2 += 4;
            var3 -= 4;
         } else {
            this.a(var1[var2]);
            ++var2;
            --var3;
         }
      }

   }

   public final void a() {
      this.c[0] = 1732584193;
      this.c[1] = -271733879;
      this.c[2] = -1732584194;
      this.c[3] = 271733878;
      this.c[4] = -1009589776;

      for(int var1 = 0; var1 < 80; ++var1) {
         this.a[var1] = 0;
      }

      this.b = 0L;
   }

   public final int a(byte[] var1) {
      if (var1.length < 20) {
         return 0;
      } else {
         long var3 = this.b << 3;
         this.a((byte)-128);

         while((int)(this.b & 63L) != 56) {
            this.a((byte)0);
         }

         this.a[14] = (int)(var3 >>> 32);
         this.a[15] = (int)var3;
         this.b += 8L;
         this.c();
         int var2 = 0;

         for(int var5 = 0; var2 < this.c.length; var5 += 4) {
            var1[var5] = (byte)(this.c[var2] >> 24);
            var1[var5 + 1] = (byte)(this.c[var2] >>> 16);
            var1[var5 + 2] = (byte)(this.c[var2] >>> 8);
            var1[var5 + 3] = (byte)this.c[var2];
            ++var2;
         }

         this.a();
         return 20;
      }
   }

   private void c() {
      int[] var7 = this.a;

      int var9;
      int var10;
      for(var9 = 16; var9 < 80; ++var9) {
         var10 = var7[var9 - 16] ^ var7[var9 - 14] ^ var7[var9 - 8] ^ var7[var9 - 3];
         var7[var9] = var10 << 1 | var10 >>> 31;
      }

      int var1 = this.c[0];
      int var2 = this.c[1];
      int var3 = this.c[2];
      int var4 = this.c[3];
      int var5 = this.c[4];

      int var6;
      int[] var8;
      int var11;
      int var12;
      int var13;
      int var15;
      int var10002;
      int var10003;
      int var10004;
      int var10005;
      for(var6 = 0; var6 < 20; ++var6) {
         var10002 = this.c[0];
         var10003 = this.c[1];
         var10004 = this.c[2];
         var10005 = this.c[3];
         var13 = this.c[4];
         var12 = var10005;
         var11 = var10004;
         var10 = var10003;
         var9 = var10002;
         var8 = this.a;
         var7 = this.c;
         var15 = (var9 << 5 | var9 >>> 27) + (var10 & var11 | ~var10 & var12) + var13 + var8[var6] + 1518500249;
         var7[4] = var7[3];
         var7[3] = var7[2];
         var7[2] = var7[1] << 30 | var7[1] >>> 2;
         var7[1] = var7[0];
         var7[0] = var15;
      }

      for(var6 = 20; var6 < 40; ++var6) {
         var10002 = this.c[0];
         var10003 = this.c[1];
         var10004 = this.c[2];
         var10005 = this.c[3];
         var13 = this.c[4];
         var12 = var10005;
         var11 = var10004;
         var10 = var10003;
         var9 = var10002;
         var8 = this.a;
         var7 = this.c;
         var15 = (var9 << 5 | var9 >>> 27) + (var10 ^ var11 ^ var12) + var13 + var8[var6] + 1859775393;
         var7[4] = var7[3];
         var7[3] = var7[2];
         var7[2] = var7[1] << 30 | var7[1] >>> 2;
         var7[1] = var7[0];
         var7[0] = var15;
      }

      for(var6 = 40; var6 < 60; ++var6) {
         var10002 = this.c[0];
         var10003 = this.c[1];
         var10004 = this.c[2];
         var10005 = this.c[3];
         var13 = this.c[4];
         var12 = var10005;
         var11 = var10004;
         var10 = var10003;
         var9 = var10002;
         var8 = this.a;
         var7 = this.c;
         var15 = (var9 << 5 | var9 >>> 27) + (var10 & var11 | var10 & var12 | var11 & var12) + var13 + var8[var6] + -1894007588;
         var7[4] = var7[3];
         var7[3] = var7[2];
         var7[2] = var7[1] << 30 | var7[1] >>> 2;
         var7[1] = var7[0];
         var7[0] = var15;
      }

      for(var6 = 60; var6 < 80; ++var6) {
         var10002 = this.c[0];
         var10003 = this.c[1];
         var10004 = this.c[2];
         var10005 = this.c[3];
         var13 = this.c[4];
         var12 = var10005;
         var11 = var10004;
         var10 = var10003;
         var9 = var10002;
         var8 = this.a;
         var7 = this.c;
         var15 = (var9 << 5 | var9 >>> 27) + (var10 ^ var11 ^ var12) + var13 + var8[var6] + -899497514;
         var7[4] = var7[3];
         var7[3] = var7[2];
         var7[2] = var7[1] << 30 | var7[1] >>> 2;
         var7[1] = var7[0];
         var7[0] = var15;
      }

      int[] var10000 = this.c;
      var10000[0] += var1;
      var10000 = this.c;
      var10000[1] += var2;
      var10000 = this.c;
      var10000[2] += var3;
      var10000 = this.c;
      var10000[3] += var4;
      var10000 = this.c;
      var10000[4] += var5;
   }
}
