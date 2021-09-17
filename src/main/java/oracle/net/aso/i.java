package oracle.net.aso;

public final class i {
   private byte[] a = null;
   private int b = 0;
   private byte[] c = null;
   private int d = 0;
   private byte[] e = null;
   private byte[] f = null;
   private short g;
   private short h;
   private char[] i = new char[257];
   private char[] j = new char[257];
   private byte[] k;
   private int l;
   private int m;
   private int n;
   private byte[] o;
   private static final short[] p = new short[]{40, 41, 56, 128, 256};
   private static final short[] q = new short[]{40, 64, 56, 128, 256};
   private static final short[] r = new short[]{80, 112, 112, 512, 512};
   private static final short[] s = new short[]{300, 512, 512, 512, 512};
   private static final byte[] t = new byte[]{2, 83, -77, -14, -90, -115, 61, -69, 106, -61, -103, 9, -64, -41, 4, 5, -14, 91, -126, 97, 107, 122, -24, -36, 29, 123, 3, -106, 53, -30, -37, -17, 67, 102, -6, -48, 76, -63};
   private static final byte[] u = new byte[]{12, 54, -127, -73, 4, 71, 3, -96, 120, 96, 81, 38, -116, -22, -101, -68, -93, 62, 124, 1, -85, 54, -117, 34, 117, -104, 119, 102, 53, -59, -128, -43, 36, -46, 80, 99, -72, -13};
   private static final byte[] v = new byte[]{-126, -104, -34, 73, -34, -9, 9, -27, -32, 13, -80, -96, -91, -100, -87, -14, 61, -10, -58, -89, -23, 74, 68, -93, -31, -121, 46, -11, 76, 31, -95, 122, -33, 92, -14, 117, -127, -19, 81, -61, 38, -18, -117, -31, 4, 3, 30, 103, 80, 83, -75, 124, 75, 69, 111, 21, 74, 23, 86, 11, 90, 21, -107, -91};
   private static final byte[] w = new byte[]{-36, -114, -93, 27, 8, 96, 105, -118, -52, -10, -47, -98, -121, 14, 52, -4, 103, -59, 89, 11, 78, -90, -79, 60, -43, -3, -17, 21, -84, -99, 95, 63, 33, 76, -36, 7, -52, -121, 74, -77, 1, -41, 127, 44, 67, 51, 81, 60, -34, 11, 30, -50, 100, 71, 118, 87, 92, 81, -52, -104, -77, -2, -25, -17};
   private static final byte[][] x;
   private static final byte[][] y;

   public i(byte[] var1, byte[] var2, short var3, short var4) {
      if (var1 != null && var2 != null) {
         this.e = var1;
         this.f = var2;
         this.h = var4;
         this.g = var3;
      } else {
         this.a = var1;
         if (var1 != null) {
            this.b = var1.length;
         } else {
            this.b = 0;
         }

         this.c = var2;
         if (var2 != null) {
            this.d = var2.length;
         } else {
            this.d = 0;
         }

         this.a(40);
      }
   }

   public final byte[] a() {
      char[] var4 = new char[257];
      char[] var5 = new char[257];
      byte[] var6 = new byte[512];
      int var2 = (short)(this.g + 7) / 8;
      int var3 = (short)(this.h + 7) / 8;
      this.l = (short)var3;
      this.m = this.h / 16 + 1;
      this.k = new byte[this.l];
      n var10000 = new n();
      byte[] var8 = var6;
      n var7 = var10000;

      for(int var9 = 0; var9 < var2; ++var9) {
         var8[var9] = (byte)var7.a();
      }

      var6[0] = (byte)(var6[0] & 255 >>> var2 - 8 * this.g);
      oracle.net.aso.b.a(var4, this.m, this.e, var3);
      oracle.net.aso.b.a(this.j, this.m, var6, var2);
      oracle.net.aso.b.a(this.i, this.m, this.f, var3);
      oracle.net.aso.b.a(var5, var4, this.j, this.i, this.m);
      oracle.net.aso.b.a(this.k, this.l, var5, this.m);
      return this.k;
   }

   public final byte[] a(byte[] var1, int var2) {
      char[] var4 = new char[257];
      char[] var5 = new char[257];
      this.n = this.l;
      this.o = new byte[this.n];
      oracle.net.aso.b.a(var4, this.m, var1, var2);
      oracle.net.aso.b.a(var5, var4, this.j, this.i, this.m);
      oracle.net.aso.b.a(this.o, this.n, var5, this.m);
      return this.o;
   }

   private void a(int var1) {
      for(var1 = 0; var1 < p.length; ++var1) {
         if (40 >= p[var1] && 40 <= q[var1]) {
            this.g = r[var1];
            this.h = s[var1];
            this.e = new byte[(this.h + 7) / 8];
            this.f = new byte[(this.h + 7) / 8];
            if (this.b << 3 >= this.h && this.d << 3 >= this.h) {
               System.arraycopy(this.a, 0, this.e, 0, this.e.length);
               System.arraycopy(this.c, 0, this.f, 0, this.f.length);
            } else {
               System.arraycopy(x[var1], 0, this.e, 0, this.e.length);
               System.arraycopy(y[var1], 0, this.f, 0, this.f.length);
            }
            break;
         }
      }

      if (this.e != null) {
         byte[] var10000 = this.f;
      }

   }

   static {
      x = new byte[][]{t, v, v, v, v};
      y = new byte[][]{u, w, w, w, w};
   }
}
