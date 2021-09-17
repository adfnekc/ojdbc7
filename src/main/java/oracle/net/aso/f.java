package oracle.net.aso;

public final class f extends g {
   private static final byte[] c = new byte[]{-2, -2, -2, -2, -2, -2, -2, -2};
   private static final byte[] d = new byte[]{88, -46, 26, -119, 7, 0, -59, -68};
   private static final byte[] e = new byte[]{103, 98, -82, -38, 116, -21, -92, -87};
   private static final byte[] f = new byte[]{14, -2, 14, -2, 14, -2, 14, -2};

   public final void a(byte[] var1, byte[] var2) throws c {
      super.a(var1, var2);
   }

   public final byte[] a(byte[] var1, int var2) {
      if (this.b) {
         this.a(this.a, (byte)0);
      }

      return super.a(var1, var2);
   }

   public final byte[] a(byte[] var1) {
      if (this.b) {
         this.a(this.a, (byte)1);
      }

      return super.a(var1);
   }

   public final int b() {
      return 8;
   }

   public final void b(byte[] var1, byte[] var2) throws c {
      super.b(var1, var2);
   }

   public final void a(byte[] var1, byte var2) {
      System.arraycopy(var1, 0, this.a, 0, 8);
      var1 = this.a;
      byte[] var3 = new byte[8];
      byte[] var4 = new byte[8];
      byte[] var5 = new byte[8];
      a(var3, var1, c, 1);
      a(b(e, (byte)0), var3, var5);
      a(b(d, (byte)0), var3, var4);
      a(var3, var5, var4, 2);
      a(var1, var3, f, 1);
      super.a(this.a, var2);
   }

   private static void a(int[] var0, byte[] var1, byte[] var2) {
      int[] var3 = new int[2];
      a(var1, var3);
      a(var3, var0);
      a(var3, var2);
   }
}
