package oracle.net.aso;

final class p {
   private byte[] a = new byte[256];
   private int b;
   private int c;

   protected p() {
   }

   public final void a(byte[] var1, int var2) {
      int var3;
      for(var3 = 0; var3 < 256; ++var3) {
         this.a[var3] = (byte)var3;
      }

      this.b = this.c = 0;
      var3 = 0;
      int var4 = 0;

      for(int var5 = 0; var3 < 256; ++var5) {
         byte var6 = this.a[var3];
         if (var5 == var2) {
            var5 = 0;
         }

         var4 = var4 + var6 + var1[var5] & 255;
         this.a[var3] = this.a[var4];
         this.a[var4] = var6;
         ++var3;
      }

   }

   public final byte[] b(byte[] var1, int var2) {
      byte[] var3 = new byte[var2];
      this.a(var3, var1, var2);
      return var3;
   }

   public final void a(byte[] var1, byte[] var2, int var3) {
      int var4 = this.b;
      int var5 = this.c;

      for(int var6 = 0; var6 < var3; ++var6) {
         var4 = var4 + 1 & 255;
         byte var7 = this.a[var4];
         var5 = var5 + var7 & 255;
         byte var8 = this.a[var5];
         this.a[var4] = (byte)var8;
         this.a[var5] = (byte)var7;
         int var9 = var7 + var8 & 255;
         var1[var6] = (byte)(var2[var6] ^ this.a[var9]);
      }

      this.b = var4;
      this.c = var5;
   }
}
