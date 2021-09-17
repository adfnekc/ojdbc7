package oracle.net.aso;

public abstract class h {
   private a b = null;
   private o c = null;
   private byte[] d = null;
   private byte[] e = null;
   private String f = null;
   protected m a;

   public final void a(byte[] var1, byte[] var2, String var3) throws c {
      this.a.a();
      this.f = var3;
      if (this.f != "SHA256" && this.f != "SHA384" && this.f != "SHA512") {
         this.c = new o(var1, var2);
      } else {
         this.b = new a(var1, var2);
      }

      this.e = new byte[this.b()];
   }

   public final boolean a(byte[] var1, byte[] var2) {
      byte[] var3 = new byte[this.b()];
      if (this.f != "SHA256" && this.f != "SHA512" && this.f != "SHA384") {
         this.d = this.c.a(var3);
      } else {
         if (this.d != null) {
            System.arraycopy(this.d, 0, var3, 0, this.d.length);
            this.d = null;
         }

         this.d = this.b.a((byte[])var3, 1);
      }

      this.a.a();
      this.a.a(var1, 0, var1.length);
      this.a.a(this.d, 0, this.d.length);
      this.a.a(var3);
      boolean var5 = false;

      for(int var4 = 0; var4 < this.b(); ++var4) {
         if (var3[var4] != var2[var4]) {
            var5 = true;
            break;
         }
      }

      return var5;
   }

   public final byte[] a(byte[] var1, int var2) {
      if (var1.length < var2) {
         return null;
      } else {
         byte[] var3;
         if (this.f != "SHA256" && this.f != "SHA384" && this.f != "SHA512") {
            var3 = this.c.b(this.e);
         } else {
            System.arraycopy(var3 = this.b.a((byte[])this.e, 2), 0, this.e, 0, var3.length);
         }

         this.a.a();
         this.a.a(var1, 0, var2);
         this.a.a(var3, 0, var3.length);
         this.a.a(var3);
         return var3;
      }
   }

   public final int b(byte[] var1, byte[] var2) {
      try {
         if (this.f != "SHA256" && this.f != "SHA384" && this.f != "SHA512") {
            this.c.b(var1, var2);
         } else {
            this.b.b(var1, var2);
         }
      } catch (c var3) {
      }

      return 0;
   }

   public final void a() throws c {
      if (this.f != "SHA256" && this.f != "SHA384" && this.f != "SHA512") {
         this.c.a();
      } else {
         this.b.a();
      }
   }

   public final int b() {
      return this.a.b();
   }
}
