package oracle.net.aso;

public final class d extends e {
   public final void a(byte[] var1, byte[] var2) throws c {
      if (var1 == null && var2 == null) {
         throw new c(102);
      } else if (var1.length < 16) {
         throw new c(102);
      } else {
         System.arraycopy(var1, 0, this.a, 0, 8);
         System.arraycopy(var1, 8, this.b, 0, 8);
         System.arraycopy(this.a, 0, this.c, 0, 8);
         this.d = true;
      }
   }

   public final void b(byte[] var1, byte[] var2) throws c {
      this.d = true;
      if (var1 == null && var2 == null) {
         if (this.a == null) {
            throw new c(102);
         }
      } else if (var1.length < 16) {
         throw new c(102);
      } else {
         System.arraycopy(var1, 0, this.a, 0, 8);
         System.arraycopy(var1, 8, this.b, 0, 8);
         System.arraycopy(this.a, 0, this.c, 0, 8);
      }
   }
}
