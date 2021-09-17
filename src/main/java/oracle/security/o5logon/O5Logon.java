package oracle.security.o5logon;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import javax.crypto.SecretKeyFactory;
import javax.crypto.interfaces.PBEKey;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;
import oracle.security.o3logon.O3LoginProtocolHelper;

public final class O5Logon {
   public static final int AUTH_FLAG_O5LOGON = 0;
   public static final int AUTH_FLAG_NONO5LOGON = 1;
   private static final char[] a = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
   private static final SecureRandom b = a();
   private final MessageDigest c = b();
   private final MessageDigest d = c();
   private final MessageDigest e = d();
   private byte[] f = null;
   private String g = null;
   private String h = null;

   private static final SecureRandom a() {
      SecureRandom var0 = null;

      try {
         var0 = SecureRandom.getInstance("SHA1PRNG");
         byte[] var1 = new byte[32];
         var0.nextBytes(var1);
      } catch (Exception var2) {
      }

      return var0;
   }

   private static MessageDigest b() {
      MessageDigest var0 = null;

      try {
         var0 = MessageDigest.getInstance("MD5");
      } catch (Exception var1) {
      }

      return var0;
   }

   private static MessageDigest c() {
      MessageDigest var0 = null;

      try {
         var0 = MessageDigest.getInstance("SHA1");
      } catch (Exception var1) {
      }

      return var0;
   }

   private static MessageDigest d() {
      MessageDigest var0 = null;

      try {
         var0 = MessageDigest.getInstance("SHA-512");
      } catch (Exception var1) {
      }

      return var0;
   }

   private final byte[] a(int var1, byte[] var2, byte[] var3) {
      Object var4 = null;
      byte[] var5;
      byte[] var6;
      switch(var1) {
      case 2361:
      case 40674:
      case 59694:
         var6 = new byte[16];

         for(var1 = 0; var1 < 16; ++var1) {
            var6[var1] = (byte)(var2[var1 + 16] ^ var3[var1 + 16]);
         }

         this.c.reset();
         var5 = this.c.digest(var6);
         break;
      case 6949:
      case 45394:
         var6 = new byte[24];

         for(var1 = 0; var1 < 24; ++var1) {
            var6[var1] = (byte)(var2[var1 + 16] ^ var3[var1 + 16]);
         }

         var5 = new byte[24];
         this.c.reset();
         this.c.update(var6, 0, 16);
         System.arraycopy(this.c.digest(), 0, var5, 0, 16);
         this.c.reset();
         this.c.update(var6, 16, 8);
         System.arraycopy(this.c.digest(), 0, var5, 16, 8);
         break;
      case 18453:
         var6 = new byte[32];

         for(var1 = 0; var1 < 32; ++var1) {
            var6[var1] = (byte)(var2[var1 + 16] ^ var3[var1 + 16]);
         }

         var5 = new byte[32];
         this.c.reset();
         this.c.update(var6, 0, 16);
         System.arraycopy(this.c.digest(), 0, var5, 0, 16);
         this.c.reset();
         this.c.update(var6, 16, 16);
         System.arraycopy(this.c.digest(), 0, var5, 16, 16);
         break;
      default:
         var5 = new byte[0];
      }

      return var5;
   }

   public final byte[] getDerivedKey(byte[] var1, int var2) throws NoSuchAlgorithmException, InvalidKeySpecException {
      byte[] var7 = this.f;
      StringBuffer var3 = new StringBuffer(var7.length << 1);

      for(int var4 = 0; var4 < var7.length; ++var4) {
         for(int var5 = 1; var5 >= 0; --var5) {
            var3.append(a[var7[var4] >> (var5 << 2) & 15]);
         }
      }

      String var8 = var3.toString();
      PBEKeySpec var9 = new PBEKeySpec(var8.toCharArray(), var1, 1000, 160);
      PBEKey var6 = (PBEKey)SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1").generateSecret(var9);
      return (new SecretKeySpec(var6.getEncoded(), "AES")).getEncoded();
   }

   public final boolean validateServerIdentity(String var1) {
      boolean var2 = false;

      try {
         String var4 = this.h;
         byte[] var6 = a(this.f, var1, var4);
         var2 = (new String(var6, 16, var6.length - 16, "US-ASCII")).compareTo("SERVER_TO_CLIENT") == 0;
      } catch (Exception var5) {
      }

      return var2;
   }

   private static byte[] a(byte[] var0, String var1, String var2) throws b {
      if (var0 == null) {
         return new byte[0];
      } else {
         byte[] var3 = new byte[16];

         for(int var4 = 0; var4 < var3.length; ++var4) {
            var3[0] = 0;
         }

         byte[] var5 = a(var1);
         byte var7;
         if (var0.length == 16) {
            var7 = 1;
         } else if (var0.length == 24) {
            var7 = 2;
         } else {
            var7 = 3;
         }

         byte var6;
         if (var2.endsWith("PKCS5Padding")) {
            var6 = 2;
         } else {
            var6 = 0;
         }

         a var8;
         (var8 = new a(var7, var6)).a(var0);
         return var8.b(var5);
      }
   }

   private final byte[] a(byte[] var1, String var2) throws b {
      return a(this.f, var1, var2);
   }

   private static byte[] a(byte[] var0, byte[] var1, String var2) throws b {
      if (var0 == null) {
         return new byte[0];
      } else {
         byte[] var3 = new byte[16];

         for(int var4 = 0; var4 < var3.length; ++var4) {
            var3[0] = 0;
         }

         byte var6;
         if (var0.length == 16) {
            var6 = 1;
         } else if (var0.length == 24) {
            var6 = 2;
         } else {
            var6 = 3;
         }

         byte var5;
         if (var2.endsWith("PKCS5Padding")) {
            var5 = 2;
         } else {
            var5 = 0;
         }

         a var7;
         (var7 = new a(var6, var5)).a(var0);
         return var7.c(var1);
      }
   }

   public final void generateOAuthResponse(int var1, byte[] var2, String var3, String var4, byte[] var5, byte[] var6, byte[] var7, byte[] var8, int[] var9, boolean var10, byte var11) throws Exception {
      if (b != null && this.d != null && this.c != null && this.e != null) {
         if (var9.length != 1) {
            throw new Exception("Resource B missing.");
         } else {
            byte[] var15;
            byte[] var19;
            if (var1 == 2361) {
               this.g = "AES/CBC/NoPadding";
               this.h = "AES/CBC/PKCS5Padding";
               var15 = (new O3LoginProtocolHelper()).getVerifier(var3, var4, var10);
               var2 = new byte[16];
               System.arraycopy(var15, 0, var2, 0, 8);

               for(int var17 = 8; var17 < 16; ++var17) {
                  var2[var17] = 0;
               }
            } else {
               int var16;
               if (var1 != 6949 && var1 != 45394) {
                  if (var1 != 40674 && var1 != 59694) {
                     if (var1 != 18453) {
                        throw new Exception("Resource C missing.");
                     }

                     this.g = "AES/CBC/NoPadding";
                     this.h = "AES/CBC/PKCS5Padding";
                     this.e.reset();
                     this.e.update(var4.getBytes("UTF-8"));
                     if (var2 != null) {
                        this.e.update(a(new String(var2, "US-ASCII")));
                     }

                     var19 = this.e.digest();
                     var2 = new byte[32];

                     for(var16 = 0; var16 < var2.length; ++var16) {
                        var2[var16] = 0;
                     }

                     System.arraycopy(var19, 0, var2, 0, var2.length);
                  } else {
                     this.g = "AES/CBC/NoPadding";
                     this.h = "AES/CBC/PKCS5Padding";
                     this.c.reset();
                     this.c.update(var4.getBytes("UTF-8"));
                     if (var1 == 59694) {
                        this.c.update(a(new String(var2, "US-ASCII")));
                     }

                     var2 = this.c.digest();
                  }
               } else {
                  if ((var11 & 2) != 0) {
                     this.g = "AES/CBC/NoPadding";
                  } else {
                     this.g = "AES/CBC/PKCS5Padding";
                  }

                  this.h = "AES/CBC/PKCS5Padding";
                  this.d.reset();
                  this.d.update(var4.getBytes("UTF-8"));
                  if (var1 == 6949 && var2 != null) {
                     this.d.update(a(new String(var2, "US-ASCII")));
                  }

                  var19 = this.d.digest();
                  var2 = new byte[24];

                  for(var16 = 0; var16 < var2.length; ++var16) {
                     var2[var16] = 0;
                  }

                  System.arraycopy(var19, 0, var2, 0, var19.length);
               }
            }

            var15 = new byte[(var19 = a(var2, new String(var6, "US-ASCII"), this.g)).length];
            synchronized(b) {
               b.nextBytes(var15);
            }

            byte[] var18 = a(var2, var15, this.g);
            if (var7 != null && var7.length == var6.length) {
               a(var18, var7);
               this.f = this.a(var1, var19, var15);
               byte[] var14 = new byte[16];
               synchronized(b) {
                  b.nextBytes(var14);
               }

               if (var8 == null) {
                  throw new Exception("Resource E missing.");
               } else {
                  var2 = new byte[16 + var5.length];
                  System.arraycopy(var14, 0, var2, 0, 16);
                  System.arraycopy(var5, 0, var2, 16, var5.length);
                  var14 = this.a(var2, this.h);
                  var9[0] = a(var14, var8);
               }
            } else {
               throw new Exception("Resource D missing.");
            }
         }
      } else {
         throw new Exception("Resource A missing.");
      }
   }

   private static byte a(byte var0) {
      return (byte)((var0 = (byte)(var0 & 15)) < 10 ? var0 + 48 : var0 - 10 + 65);
   }

   private static int a(byte[] var0, byte[] var1) {
      int var2;
      for(var2 = 0; var2 < var0.length; ++var2) {
         var1[var2 << 1] = a((byte)((var0[var2] & 240) >> 4));
         var1[(var2 << 1) + 1] = a((byte)(var0[var2] & 15));
      }

      return var2 << 1;
   }

   private static byte[] a(String var0) {
      byte[] var1 = new byte[var0.length() / 2];

      for(int var2 = 0; var2 < var0.length() / 2; ++var2) {
         byte var3 = Byte.parseByte(var0.substring(2 * var2, 2 * var2 + 1), 16);
         int var4 = Byte.parseByte(var0.substring(2 * var2 + 1, 2 * var2 + 2), 16) | var3 << 4;
         var1[var2] = (byte)var4;
      }

      return var1;
   }
}
