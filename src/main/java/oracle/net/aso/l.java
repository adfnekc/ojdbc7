package oracle.net.aso;

final class l implements m {
   private long[] a = new long[2];
   private long[] b = new long[4];
   private char[] c = new char[64];
   private char[] d = new char[16];
   private static final byte[] e = new byte[]{-128, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};

   private static long a(long var0, int var2) {
      long var3 = var0 << var2;
      long var5 = ~(-1L << var2);
      return var0 >>> 32 - var2 & var5 | var3;
   }

   private static long a(long var0, long var2, long var4, long var6, long var8, int var10, long var11) {
      return a(var0 + (var2 & var4 | ~var2 & var6) + var8 + var11, var10) + var2;
   }

   private static long b(long var0, long var2, long var4, long var6, long var8, int var10, long var11) {
      return a(var0 + (var2 & var6 | var4 & ~var6) + var8 + var11, var10) + var2;
   }

   private static long c(long var0, long var2, long var4, long var6, long var8, int var10, long var11) {
      return a(var0 + (var2 ^ var4 ^ var6) + var8 + var11, var10) + var2;
   }

   private static long d(long var0, long var2, long var4, long var6, long var8, int var10, long var11) {
      return a(var0 + (var4 ^ (var2 | ~var6)) + var8 + var11, var10) + var2;
   }

   public final void a() {
      this.a[0] = 0L;
      this.a[1] = 0L;
      this.b[0] = 1732584193L;
      this.b[1] = -271733879L;
      this.b[2] = -1732584194L;
      this.b[3] = 271733878L;
   }

   private static void a(long[] var0, char[] var1, int var2) {
      int var3 = 0;

      for(int var4 = 0; var4 < var2; var4 += 4) {
         var0[var3] = (long)var1[var4] & 255L | (long)var1[var4 + 1] << 8 & 65280L | (long)var1[var4 + 2] << 16 & 16711680L | (long)var1[var4 + 3] << 24 & -16777216L;
         ++var3;
      }

   }

   private void a(long[] var1, long[] var2) {
      long var3 = var1[0];
      long var5 = var1[1];
      long var7 = var1[2];
      long var9 = var1[3];
      var3 = a(var3, var5, var7, var9, var2[0], 7, -680876936L);
      var9 = a(var9, var3, var5, var7, var2[1], 12, -389564586L);
      var7 = a(var7, var9, var3, var5, var2[2], 17, 606105819L);
      var5 = a(var5, var7, var9, var3, var2[3], 22, -1044525330L);
      var3 = a(var3, var5, var7, var9, var2[4], 7, -176418897L);
      var9 = a(var9, var3, var5, var7, var2[5], 12, 1200080426L);
      var7 = a(var7, var9, var3, var5, var2[6], 17, -1473231341L);
      var5 = a(var5, var7, var9, var3, var2[7], 22, -45705983L);
      var3 = a(var3, var5, var7, var9, var2[8], 7, 1770035416L);
      var9 = a(var9, var3, var5, var7, var2[9], 12, -1958414417L);
      var7 = a(var7, var9, var3, var5, var2[10], 17, -42063L);
      var5 = a(var5, var7, var9, var3, var2[11], 22, -1990404162L);
      var3 = a(var3, var5, var7, var9, var2[12], 7, 1804603682L);
      var9 = a(var9, var3, var5, var7, var2[13], 12, -40341101L);
      var7 = a(var7, var9, var3, var5, var2[14], 17, -1502002290L);
      var5 = a(var5, var7, var9, var3, var2[15], 22, 1236535329L);
      var3 = b(var3, var5, var7, var9, var2[1], 5, -165796510L);
      var9 = b(var9, var3, var5, var7, var2[6], 9, -1069501632L);
      var7 = b(var7, var9, var3, var5, var2[11], 14, 643717713L);
      var5 = b(var5, var7, var9, var3, var2[0], 20, -373897302L);
      var3 = b(var3, var5, var7, var9, var2[5], 5, -701558691L);
      var9 = b(var9, var3, var5, var7, var2[10], 9, 38016083L);
      var7 = b(var7, var9, var3, var5, var2[15], 14, -660478335L);
      var5 = b(var5, var7, var9, var3, var2[4], 20, -405537848L);
      var3 = b(var3, var5, var7, var9, var2[9], 5, 568446438L);
      var9 = b(var9, var3, var5, var7, var2[14], 9, -1019803690L);
      var7 = b(var7, var9, var3, var5, var2[3], 14, -187363961L);
      var5 = b(var5, var7, var9, var3, var2[8], 20, 1163531501L);
      var3 = b(var3, var5, var7, var9, var2[13], 5, -1444681467L);
      var9 = b(var9, var3, var5, var7, var2[2], 9, -51403784L);
      var7 = b(var7, var9, var3, var5, var2[7], 14, 1735328473L);
      var5 = b(var5, var7, var9, var3, var2[12], 20, -1926607734L);
      var3 = c(var3, var5, var7, var9, var2[5], 4, -378558L);
      var9 = c(var9, var3, var5, var7, var2[8], 11, -2022574463L);
      var7 = c(var7, var9, var3, var5, var2[11], 16, 1839030562L);
      var5 = c(var5, var7, var9, var3, var2[14], 23, -35309556L);
      var3 = c(var3, var5, var7, var9, var2[1], 4, -1530992060L);
      var9 = c(var9, var3, var5, var7, var2[4], 11, 1272893353L);
      var7 = c(var7, var9, var3, var5, var2[7], 16, -155497632L);
      var5 = c(var5, var7, var9, var3, var2[10], 23, -1094730640L);
      var3 = c(var3, var5, var7, var9, var2[13], 4, 681279174L);
      var9 = c(var9, var3, var5, var7, var2[0], 11, -358537222L);
      var7 = c(var7, var9, var3, var5, var2[3], 16, -722521979L);
      var5 = c(var5, var7, var9, var3, var2[6], 23, 76029189L);
      var3 = c(var3, var5, var7, var9, var2[9], 4, -640364487L);
      var9 = c(var9, var3, var5, var7, var2[12], 11, -421815835L);
      var7 = c(var7, var9, var3, var5, var2[15], 16, 530742520L);
      var5 = c(var5, var7, var9, var3, var2[2], 23, -995338651L);
      var3 = d(var3, var5, var7, var9, var2[0], 6, -198630844L);
      var9 = d(var9, var3, var5, var7, var2[7], 10, 1126891415L);
      var7 = d(var7, var9, var3, var5, var2[14], 15, -1416354905L);
      var5 = d(var5, var7, var9, var3, var2[5], 21, -57434055L);
      var3 = d(var3, var5, var7, var9, var2[12], 6, 1700485571L);
      var9 = d(var9, var3, var5, var7, var2[3], 10, -1894986606L);
      var7 = d(var7, var9, var3, var5, var2[10], 15, -1051523L);
      var5 = d(var5, var7, var9, var3, var2[1], 21, -2054922799L);
      var3 = d(var3, var5, var7, var9, var2[8], 6, 1873313359L);
      var9 = d(var9, var3, var5, var7, var2[15], 10, -30611744L);
      var7 = d(var7, var9, var3, var5, var2[6], 15, -1560198380L);
      var5 = d(var5, var7, var9, var3, var2[13], 21, 1309151649L);
      var3 = d(var3, var5, var7, var9, var2[4], 6, -145523070L);
      var9 = d(var9, var3, var5, var7, var2[11], 10, -1120210379L);
      var7 = d(var7, var9, var3, var5, var2[2], 15, 718787259L);
      var5 = d(var5, var7, var9, var3, var2[9], 21, -343485551L);
      var1[0] += var3;
      var1[1] += var5;
      var1[2] += var7;
      var1[3] += var9;
   }

   l() {
      this.a();
   }

   public final int b() {
      return 16;
   }

   public final void a(byte[] var1, int var2, int var3) {
      char[] var8;
      char[] var10000 = var8 = new char[var3];
      byte[] var4 = var1;
      char[] var6 = var10000;

      int var5;
      for(var5 = 0; var5 < var3; ++var5) {
         var6[var5] = (char)var4[var5];
      }

      long[] var7 = new long[16];
      int var9 = (int)(this.a[0] >>> 3 & 63L);
      if (this.a[0] + (long)(var3 << 3) < this.a[0]) {
         int var10002 = (int) this.a[1]++;
      }

      long[] var10 = this.a;
      var10[0] += (long)var3 << 3;
      var10 = this.a;
      var10[1] += (long)var3 >>> 29;
      var5 = 0;

      while(var3-- > 0) {
         this.c[var9++] = var8[var5++];
         if (var9 == 64) {
            a(var7, this.c, 64);
            this.a(this.b, var7);
            var9 = 0;
         }
      }

   }

   public final int a(byte[] var1) {
      if (var1.length < 16) {
         return 0;
      } else {
         long[] var2;
         (var2 = new long[16])[14] = this.a[0];
         var2[15] = this.a[1];
         int var3 = (var3 = (int)(this.a[0] >>> 3 & 63L)) < 56 ? 56 - var3 : 120 - var3;
         this.a(e, 0, var3);
         a(var2, this.c, 56);
         this.a(this.b, var2);
         long[] var9 = this.b;
         char[] var7 = this.d;
         int var4 = 0;

         int var5;
         for(var5 = 0; var4 < 4; var5 += 4) {
            var7[var5] = (char)((int)(var9[var4] & 255L));
            var7[var5 + 1] = (char)((int)(var9[var4] >> 8 & 255L));
            var7[var5 + 2] = (char)((int)(var9[var4] >> 16 & 255L));
            var7[var5 + 3] = (char)((int)(var9[var4] >> 24 & 255L));
            ++var4;
         }

         int var6 = this.d.length;
         char[] var10 = this.d;
         byte[] var8 = var1;

         for(var5 = 0; var5 < var6; ++var5) {
            var8[var5] = (byte)var10[var5];
         }

         return 16;
      }
   }
}
