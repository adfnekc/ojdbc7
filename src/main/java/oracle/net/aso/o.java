package oracle.net.aso;

public final class o implements j {
   private p a;
   private p b;
   private p c;
   private boolean d = true;
   private boolean e = false;
   private int f = 40;

   public o() {
   }

   public o(int var1) throws c {
      switch(var1) {
      case 40:
      case 56:
      case 128:
      case 256:
         this.f = var1;
         this.d = true;
         return;
      default:
         throw new c(100);
      }
   }

   protected o(byte[] var1, byte[] var2) {
      this.f = 40;
      this.e = true;
      this.d = false;

      try {
         this.a(var1, var2);
      } catch (c var3) {
      }
   }

   public final void a(byte[] var1, byte[] var2) throws c {
      this.a = new p();
      this.b = new p();
      this.c = new p();
      this.b(var1, var2);
   }

   public final byte[] a(byte[] var1) {
      if (this.d) {
         byte[] var2 = this.c.b(var1, var1.length - 1);
         byte[] var3 = new byte[var1.length - 1];
         System.arraycopy(var2, 0, var3, 0, var1.length - 1);
         return var3;
      } else {
         return this.c.b(var1, var1.length);
      }
   }

   public final byte[] b(byte[] var1) {
      byte[] var2 = this.b.b(var1, var1.length);
      if (this.d) {
         byte[] var3 = new byte[var1.length + 1];
         System.arraycopy(var2, 0, var3, 0, var1.length);
         var3[var1.length] = 0;
         return var3;
      } else {
         return var2;
      }
   }

   public final int b() {
      return 1;
   }

   public final void b(byte[] var1, byte[] var2) throws c {
      if (var1 == null && var2 == null) {
         this.a();
      } else {
         int var3 = this.f / 8;
         if (var1.length < var3) {
            throw new c(102);
         } else {
            int var4 = 0;
            if (var2 != null) {
               var4 = var2.length;
            }

            byte[] var5 = new byte[var3 + 1 + var4];
            System.arraycopy(var1, var1.length - var3, var5, 0, var3);
            if (!this.e) {
               var5[var3] = 123;
            } else {
               var5[var3] = -1;
            }

            if (var2 != null) {
               System.arraycopy(var2, 0, var5, var3 + 1, var2.length);
            }

            this.a.a(var5, var5.length);
            this.a();
         }
      }
   }

   protected final void a() {
      byte[] var1 = new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32};
      int var2 = this.f / 8;
      byte[] var3;
      if (!this.e) {
         var3 = this.a.b(var1, var2);
         if (this.d) {
            var3[var2 - 1] = (byte)(var3[var2 - 1] ^ 170);
         }

         this.c.a(var3, var2);
         var3[var2 - 1] = (byte)(var3[var2 - 1] ^ 170);
         this.b.a(var3, var2);
      } else {
         var3 = new byte[var2 + 1];
         this.a.a(var3, var1, var2);
         var3[var2] = -76;
         this.c.a(var3, var2 + 1);
         var3[var2] = 90;
         this.b.a(var3, var2 + 1);
      }
   }
}
