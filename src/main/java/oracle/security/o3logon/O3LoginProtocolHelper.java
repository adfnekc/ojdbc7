package oracle.security.o3logon;

import java.security.SecureRandom;

public final class O3LoginProtocolHelper {
   private final byte[] a;
   private final byte[] b = new byte[8];
   private static long c = System.currentTimeMillis();
   private static int d = 0;
   private static b e;

   public O3LoginProtocolHelper() {
      this.a = null;
   }

   public O3LoginProtocolHelper(byte[] var1) {
      this.a = var1;
   }

   public final byte[] getVerifier(String var1, String var2) {
      return this.getVerifier(var1, var2, true);
   }

   public final byte[] getVerifier(String var1, String var2, Boolean var3) {
      if (e == null) {
         e = new b();
      }

      return e.a(var1, var2, var3);
   }

   public final boolean authenticate(String var1, String var2) {
      try {
         Thread.sleep((long)(d * 1000));
      } catch (InterruptedException var3) {
      }

      if (e == null) {
         e = new b();
      }

      byte[] var4 = e.a(var1, var2);
      if (this.a.length != var4.length) {
         ++d;
         return false;
      } else {
         for(int var5 = 0; var5 < var4.length; ++var5) {
            if (var4[var5] != this.a[var5]) {
               ++d;
               return false;
            }
         }

         return true;
      }
   }

   public final byte[] getChallenge(byte[] var1) {
      SecureRandom var2 = new SecureRandom(var1);
      c += System.currentTimeMillis();
      var2.setSeed(c);
      var2.setSeed(this.a);
      var2.nextBytes(this.b);
      a var10000 = new a();
      byte[] var10003 = this.b;
      return var10000.a(this.a, this.b);
   }

   public final String getPassword(byte[] var1) {
      a var2 = new a();
      byte var3 = var1[var1.length - 1];
      byte[] var4 = new byte[var1.length - 1];
      System.arraycopy(var1, 0, var4, 0, var4.length);

      try {
         var1 = var2.b(this.b, var4);
      } catch (Exception var5) {
         return null;
      }

      byte[] var6 = new byte[var1.length - var3];
      System.arraycopy(var1, 0, var6, 0, var6.length);
      return (new String(var6)).toUpperCase();
   }

   public static byte[] getResponse(String var0, String var1, byte[] var2) {
      if (e == null) {
         e = new b();
      }

      byte[] var5 = e.a(var0, var1);
      a var3;
      var2 = (var3 = new a()).b(var5, var2);
      byte[] var4;
      byte var6;
      if ((var4 = var1.getBytes()).length % 8 > 0) {
         var6 = (byte)(8 - var4.length % 8);
      } else {
         var6 = 0;
      }

      var5 = new byte[var4.length + var6];
      System.arraycopy(var4, 0, var5, 0, var4.length);
      var2 = new byte[(var5 = var3.a(var2, var5)).length + 1];
      System.arraycopy(var5, 0, var2, 0, var5.length);
      var2[var2.length - 1] = var6;
      return var2;
   }
}
