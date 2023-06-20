package oracle.security.o5logon;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.util.Arrays;

import javax.crypto.SecretKeyFactory;
import javax.crypto.interfaces.PBEKey;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;
import oracle.security.o3logon.O3LoginProtocolHelper;

public final class O5Logon {
   public static final int AUTH_FLAG_O5LOGON = 0;
   public static final int AUTH_FLAG_NONO5LOGON = 1;
   private static final char[] a = new char[] { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D',
         'E', 'F' };
   private static final SecureRandom b = a();
   private final MessageDigest f_MD5 = b();
   private final MessageDigest f_SHA1 = c();
   private final MessageDigest f_SHA256 = d();
   public byte[] f = null;
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
      switch (var1) {
         case 2361:
         case 40674:
         case 59694:
            var6 = new byte[16];

            for (var1 = 0; var1 < 16; ++var1) {
               var6[var1] = (byte) (var2[var1 + 16] ^ var3[var1 + 16]);
            }

            this.f_MD5.reset();
            var5 = this.f_MD5.digest(var6);
            break;
         case 6949:
         case 45394:
            var6 = new byte[24];

            for (var1 = 0; var1 < 24; ++var1) {
               var6[var1] = (byte) (var2[var1 + 16] ^ var3[var1 + 16]);
            }

            var5 = new byte[24];
            this.f_MD5.reset();
            this.f_MD5.update(var6, 0, 16);
            System.arraycopy(this.f_MD5.digest(), 0, var5, 0, 16);
            this.f_MD5.reset();
            this.f_MD5.update(var6, 16, 8);
            System.arraycopy(this.f_MD5.digest(), 0, var5, 16, 8);
            break;
         case 18453:
            var6 = new byte[32];

            for (var1 = 0; var1 < 32; ++var1) {
               var6[var1] = (byte) (var2[var1 + 16] ^ var3[var1 + 16]);
            }

            var5 = new byte[32];
            this.f_MD5.reset();
            this.f_MD5.update(var6, 0, 16);
            System.arraycopy(this.f_MD5.digest(), 0, var5, 0, 16);
            this.f_MD5.reset();
            this.f_MD5.update(var6, 16, 16);
            System.arraycopy(this.f_MD5.digest(), 0, var5, 16, 16);
            break;
         default:
            var5 = new byte[0];
      }

      return var5;
   }

   public void setF(byte[] f) {
      this.f = f;
   }

   public final byte[] getDerivedKey(byte[] var1, int var2) throws NoSuchAlgorithmException, InvalidKeySpecException {
      byte[] var7 = this.f;
      StringBuffer var3 = new StringBuffer(var7.length << 1);

      for (int var4 = 0; var4 < var7.length; ++var4) {
         for (int var5 = 1; var5 >= 0; --var5) {
            var3.append(a[var7[var4] >> (var5 << 2) & 15]);
         }
      }

      String var8 = var3.toString();
      PBEKeySpec var9 = new PBEKeySpec(var8.toCharArray(), var1, 1000, 160);
      PBEKey var6 = (PBEKey) SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1").generateSecret(var9);
      return (new SecretKeySpec(var6.getEncoded(), "AES")).getEncoded();
   }

   public final boolean validateServerIdentity(String AUTH_SVR_RESPONSE) {
      boolean isValidate = false;

      try {
         String cryptoMethod = this.h;
         byte[] key = this.f;

         byte[] s = decrypto_AUTH_SVR_RESPONSE(key, AUTH_SVR_RESPONSE, cryptoMethod);
         System.out.printf("cryptoMethod %s,key %s SERVER_TO_CLIENT %s %s\n", cryptoMethod, Arrays.toString(key),
               new String(s, 16, s.length - 16, "US-ASCII"), Arrays.toString(s));
         isValidate = (new String(s, 16, s.length - 16, "US-ASCII")).compareTo("SERVER_TO_CLIENT") == 0;
      } catch (Exception e) {
         e.printStackTrace();
         System.out.printf("validateServerIdentity err %s\n", e);
      }

      return isValidate;
   }

   private static byte[] decrypto_AUTH_SVR_RESPONSE(byte[] var0, String var1, String var2) throws b {
      if (var0 == null) {
         return new byte[0];
      } else {
         byte[] var3 = new byte[16];

         for (int var4 = 0; var4 < var3.length; ++var4) {
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

         someCrypto var8;
         (var8 = new someCrypto(var7, var6)).sum_a(var0);
         return var8.sum_b(var5);
      }
   }

   private final byte[] f2(byte[] var1, String var2) throws b {
      return a(this.f, var1, var2);
   }

   private static byte[] a(byte[] var0, byte[] var1, String var2) throws b {
      if (var0 == null) {
         return new byte[0];
      } else {
         byte[] var3 = new byte[16];

         for (int var4 = 0; var4 < var3.length; ++var4) {
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

         someCrypto var7;
         (var7 = new someCrypto(var6, var5)).sum_a(var0);
         return var7.c(var1);
      }
   }

   public final void generateOAuthResponse(int verifierType, byte[] salt, String username_fixed, String password_fixed,
         byte[] password_byte, byte[] encryptedSK,
         byte[] encryptedKB, byte[] empty_256_bytes, int[] len_64, boolean isServerCSMultiByte,
         byte serverCompileTimeCapabilities) throws Exception {
      if (b != null && this.f_SHA1 != null && this.f_MD5 != null && this.f_SHA256 != null) {
         if (len_64.length != 1) {
            throw new Exception("Resource B missing.");
         } else {
            byte[] random_48;
            byte[] sha1_password;
            if (verifierType == 2361) {
               this.g = "AES/CBC/NoPadding";
               this.h = "AES/CBC/PKCS5Padding";
               random_48 = (new O3LoginProtocolHelper()).getVerifier(username_fixed, password_fixed,
                     isServerCSMultiByte);
               salt = new byte[16];
               System.arraycopy(random_48, 0, salt, 0, 8);

               for (int var17 = 8; var17 < 16; ++var17) {
                  salt[var17] = 0;
               }
            } else {
               int var16;
               if (verifierType != 6949 && verifierType != 45394) {
                  if (verifierType != 40674 && verifierType != 59694) {
                     if (verifierType != 18453) {
                        throw new Exception("Resource C missing.");
                     }

                     this.g = "AES/CBC/NoPadding";
                     this.h = "AES/CBC/PKCS5Padding";
                     this.f_SHA256.reset();
                     this.f_SHA256.update(password_fixed.getBytes("UTF-8"));
                     if (salt != null) {
                        this.f_SHA256.update(a(new String(salt, "US-ASCII")));
                     }

                     sha1_password = this.f_SHA256.digest();
                     salt = new byte[32];

                     for (var16 = 0; var16 < salt.length; ++var16) {
                        salt[var16] = 0;
                     }

                     System.arraycopy(sha1_password, 0, salt, 0, salt.length);
                  } else {
                     this.g = "AES/CBC/NoPadding";
                     this.h = "AES/CBC/PKCS5Padding";
                     this.f_MD5.reset();
                     this.f_MD5.update(password_fixed.getBytes("UTF-8"));
                     if (verifierType == 59694) {
                        this.f_MD5.update(a(new String(salt, "US-ASCII")));
                     }

                     salt = this.f_MD5.digest();
                  }
               } else {
                  if ((serverCompileTimeCapabilities & 2) != 0) {
                     this.g = "AES/CBC/NoPadding";
                  } else {
                     this.g = "AES/CBC/PKCS5Padding";
                  }

                  this.h = "AES/CBC/PKCS5Padding";
                  this.f_SHA1.reset();
                  this.f_SHA1.update(password_fixed.getBytes("UTF-8"));
                  if (verifierType == 6949 && salt != null) {
                     this.f_SHA1.update(a(new String(salt, "US-ASCII")));
                  }

                  sha1_password = this.f_SHA1.digest();
                  salt = new byte[24];

                  for (var16 = 0; var16 < salt.length; ++var16) {
                     salt[var16] = 0;
                  }

                  System.arraycopy(sha1_password, 0, salt, 0, sha1_password.length);
               }
            }

            random_48 = new byte[(sha1_password = decrypto_AUTH_SVR_RESPONSE(salt,
                  new String(encryptedSK, "US-ASCII"),
                  this.g)).length];
            synchronized (b) {
               b.nextBytes(random_48);
            }

            byte[] var18 = a(salt, random_48, this.g);
            if (encryptedKB != null && encryptedKB.length == encryptedSK.length) {
               a(var18, encryptedKB);
               System.out.printf("verifierType %s, sha256_password %s, random_48 %s\n",
               verifierType, Arrays.toString(sha1_password), Arrays.toString(random_48));
               this.f = this.a(verifierType, sha1_password, random_48);
               // System.out.printf("gen key %s\n", Arrays.toString(this.f));
               byte[] var14 = new byte[16];
               synchronized (b) {
                  b.nextBytes(var14);
               }

               if (empty_256_bytes == null) {
                  throw new Exception("Resource E missing.");
               } else {
                  salt = new byte[16 + password_byte.length];
                  System.arraycopy(var14, 0, salt, 0, 16);
                  System.arraycopy(password_byte, 0, salt, 16, password_byte.length);
                  var14 = this.f2(salt, this.h);
                  len_64[0] = a_withlog(var14, empty_256_bytes);
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
      return (byte) ((var0 = (byte) (var0 & 15)) < 10 ? var0 + 48 : var0 - 10 + 65);
   }

   private static int a(byte[] var0, byte[] var1) {
      int var2;
      for (var2 = 0; var2 < var0.length; ++var2) {
         var1[var2 << 1] = a((byte) ((var0[var2] & 240) >> 4));
         var1[(var2 << 1) + 1] = a((byte) (var0[var2] & 15));
      }

      return var2 << 1;
   }

   // equals to a(byte[] var0, byte[] var1)
   private static int a_withlog(byte[] var0, byte[] var1) {
      int var2;
      for (var2 = 0; var2 < var0.length; ++var2) {
         byte c = a((byte) ((var0[var2] & 240) >> 4));
         var1[var2 << 1] = c;
         // System.out.printf("i %s,var[%s]=%s\n", var2, var2 << 1, c);
         c = a((byte) (var0[var2] & 15));
         var1[(var2 << 1) + 1] = c;
         // System.out.printf("var[%s]=%s\n", (var2 << 1) + 1, c);
      }

      return var2 << 1;
   }

   private static byte[] a(String var0) {
      byte[] var1 = new byte[var0.length() / 2];

      for (int var2 = 0; var2 < var0.length() / 2; ++var2) {
         byte var3 = Byte.parseByte(var0.substring(2 * var2, 2 * var2 + 1), 16);
         int var4 = Byte.parseByte(var0.substring(2 * var2 + 1, 2 * var2 + 2), 16) | var3 << 4;
         var1[var2] = (byte) var4;
      }

      return var1;
   }
}
