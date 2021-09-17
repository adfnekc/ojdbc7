package oracle.net.aso;

public class g implements j {
   private int[] c = null;
   private int[] d = null;
   private byte[] e = new byte[8];
   protected byte[] a = new byte[8];
   protected boolean b = false;
   private boolean f = true;
   private static final byte[] g = new byte[]{1, 35, 69, 103, -119, -85, -51, -17};
   private static final short[] h = new short[]{128, 64, 32, 16, 8, 4, 2, 1};
   private static final int[] i = new int[]{8388608, 4194304, 2097152, 1048576, 524288, 262144, 131072, 65536, 32768, 16384, 8192, 4096, 2048, 1024, 512, 256, 128, 64, 32, 16, 8, 4, 2, 1};
   private static final byte[] j = new byte[]{56, 48, 40, 32, 24, 16, 8, 0, 57, 49, 41, 33, 25, 17, 9, 1, 58, 50, 42, 34, 26, 18, 10, 2, 59, 51, 43, 35, 62, 54, 46, 38, 30, 22, 14, 6, 61, 53, 45, 37, 29, 21, 13, 5, 60, 52, 44, 36, 28, 20, 12, 4, 27, 19, 11, 3};
   private static final byte[] k = new byte[]{1, 2, 4, 6, 8, 10, 12, 14, 15, 17, 19, 21, 23, 25, 27, 28};
   private static final byte[] l = new byte[]{13, 16, 10, 23, 0, 4, 2, 27, 14, 5, 20, 9, 22, 18, 11, 3, 25, 7, 15, 6, 26, 19, 12, 1, 40, 51, 30, 36, 46, 54, 29, 39, 50, 44, 32, 47, 43, 48, 38, 55, 33, 52, 45, 41, 49, 35, 28, 31};
   private static final int[] m = new int[]{16843776, 0, 65536, 16843780, 16842756, 66564, 4, 65536, 1024, 16843776, 16843780, 1024, 16778244, 16842756, 16777216, 4, 1028, 16778240, 16778240, 66560, 66560, 16842752, 16842752, 16778244, 65540, 16777220, 16777220, 65540, 0, 1028, 66564, 16777216, 65536, 16843780, 4, 16842752, 16843776, 16777216, 16777216, 1024, 16842756, 65536, 66560, 16777220, 1024, 4, 16778244, 66564, 16843780, 65540, 16842752, 16778244, 16777220, 1028, 66564, 16843776, 1028, 16778240, 16778240, 0, 65540, 66560, 0, 16842756};
   private static final int[] n = new int[]{-2146402272, -2147450880, 32768, 1081376, 1048576, 32, -2146435040, -2147450848, -2147483616, -2146402272, -2146402304, Integer.MIN_VALUE, -2147450880, 1048576, 32, -2146435040, 1081344, 1048608, -2147450848, 0, Integer.MIN_VALUE, 32768, 1081376, -2146435072, 1048608, -2147483616, 0, 1081344, 32800, -2146402304, -2146435072, 32800, 0, 1081376, -2146435040, 1048576, -2147450848, -2146435072, -2146402304, 32768, -2146435072, -2147450880, 32, -2146402272, 1081376, 32, 32768, Integer.MIN_VALUE, 32800, -2146402304, 1048576, -2147483616, 1048608, -2147450848, -2147483616, 1048608, 1081344, 0, -2147450880, 32800, Integer.MIN_VALUE, -2146435040, -2146402272, 1081344};
   private static final int[] o = new int[]{520, 134349312, 0, 134348808, 134218240, 0, 131592, 134218240, 131080, 134217736, 134217736, 131072, 134349320, 131080, 134348800, 520, 134217728, 8, 134349312, 512, 131584, 134348800, 134348808, 131592, 134218248, 131584, 131072, 134218248, 8, 134349320, 512, 134217728, 134349312, 134217728, 131080, 520, 131072, 134349312, 134218240, 0, 512, 131080, 134349320, 134218240, 134217736, 512, 0, 134348808, 134218248, 131072, 134217728, 134349320, 8, 131592, 131584, 134217736, 134348800, 134218248, 520, 134348800, 131592, 8, 134348808, 131584};
   private static final int[] p = new int[]{8396801, 8321, 8321, 128, 8396928, 8388737, 8388609, 8193, 0, 8396800, 8396800, 8396929, 129, 0, 8388736, 8388609, 1, 8192, 8388608, 8396801, 128, 8388608, 8193, 8320, 8388737, 1, 8320, 8388736, 8192, 8396928, 8396929, 129, 8388736, 8388609, 8396800, 8396929, 129, 0, 0, 8396800, 8320, 8388736, 8388737, 1, 8396801, 8321, 8321, 128, 8396929, 129, 1, 8192, 8388609, 8193, 8396928, 8388737, 8193, 8320, 8388608, 8396801, 128, 8388608, 8192, 8396928};
   private static final int[] q = new int[]{256, 34078976, 34078720, 1107296512, 524288, 256, 1073741824, 34078720, 1074266368, 524288, 33554688, 1074266368, 1107296512, 1107820544, 524544, 1073741824, 33554432, 1074266112, 1074266112, 0, 1073742080, 1107820800, 1107820800, 33554688, 1107820544, 1073742080, 0, 1107296256, 34078976, 33554432, 1107296256, 524544, 524288, 1107296512, 256, 33554432, 1073741824, 34078720, 1107296512, 1074266368, 33554688, 1073741824, 1107820544, 34078976, 1074266368, 256, 33554432, 1107820544, 1107820800, 524544, 1107296256, 1107820800, 34078720, 0, 1074266112, 1107296256, 524544, 33554688, 1073742080, 524288, 0, 1074266112, 34078976, 1073742080};
   private static final int[] r = new int[]{536870928, 541065216, 16384, 541081616, 541065216, 16, 541081616, 4194304, 536887296, 4210704, 4194304, 536870928, 4194320, 536887296, 536870912, 16400, 0, 4194320, 536887312, 16384, 4210688, 536887312, 16, 541065232, 541065232, 0, 4210704, 541081600, 16400, 4210688, 541081600, 536870912, 536887296, 16, 541065232, 4210688, 541081616, 4194304, 16400, 536870928, 4194304, 536887296, 536870912, 16400, 536870928, 541081616, 4210688, 541065216, 4210704, 541081600, 0, 541065232, 16, 16384, 541065216, 4210704, 16384, 4194320, 536887312, 0, 541081600, 536870912, 4194320, 536887312};
   private static final int[] s = new int[]{2097152, 69206018, 67110914, 0, 2048, 67110914, 2099202, 69208064, 69208066, 2097152, 0, 67108866, 2, 67108864, 69206018, 2050, 67110912, 2099202, 2097154, 67110912, 67108866, 69206016, 69208064, 2097154, 69206016, 2048, 2050, 69208066, 2099200, 2, 67108864, 2099200, 67108864, 2099200, 2097152, 67110914, 67110914, 69206018, 69206018, 2, 2097154, 67108864, 67110912, 2097152, 69208064, 2050, 2099202, 69208064, 2050, 67108866, 69208066, 69206016, 2099200, 0, 2, 69208066, 0, 2099202, 69206016, 2048, 67108866, 67110912, 2048, 2097154};
   private static final int[] t = new int[]{268439616, 4096, 262144, 268701760, 268435456, 268439616, 64, 268435456, 262208, 268697600, 268701760, 266240, 268701696, 266304, 4096, 64, 268697600, 268435520, 268439552, 4160, 266240, 262208, 268697664, 268701696, 4160, 0, 0, 268697664, 268435520, 268439552, 266304, 262144, 266304, 262144, 268701696, 4096, 64, 268697664, 4096, 266304, 268439552, 64, 268435520, 268697600, 268697664, 268435456, 262144, 268439616, 0, 268701760, 262208, 268435520, 268697600, 268439552, 268439616, 0, 268701760, 266240, 266240, 4160, 4160, 262208, 268435456, 268701696};

   public void a(byte[] var1, byte[] var2) throws c {
      if (var1.length < 8) {
         throw new c(102);
      } else {
         System.arraycopy(var1, 0, this.a, 0, 8);
         this.b = true;
      }
   }

   protected void a(byte[] var1, byte var2) {
      System.arraycopy(var1, 0, this.a, 0, 8);
      this.c = b(this.a, var2);
      this.d = b(this.a, var2);
      if (this.f) {
         a(this.e, g, (byte[])null, 3);
      }

      this.b = false;
   }

   public final byte[] b(byte[] var1) {
      return this.f ? this.b(var1, var1.length) : this.a(this.a, var1, var1.length);
   }

   public byte[] a(byte[] var1, int var2) {
      return this.f ? this.b(var1, var2) : this.a(this.a, var1, var2);
   }

   public byte[] a(byte[] var1) {
      byte[] var2;
      byte[] var7;
      g var9;
      byte[] var16;
      if (this.f) {
         int var11 = var1.length;
         var2 = var1;
         var9 = this;
         byte var12;
         if ((var12 = var1[var11 - 1]) >= 0 && var12 <= 8) {
            int var13 = var11 - var12;
            byte[] var14 = new byte[var11 - 1];
            --var11;
            if (this.b) {
               this.a(this.a, (byte)1);
            }

            for(int var15 = 0; var15 < var11; var15 += 8) {
               var16 = new byte[8];
               System.arraycopy(var2, var15, var16, 0, 8);
               System.arraycopy(var9.c(var16, (byte)1), 0, var14, var15, 8);
            }

            var7 = new byte[var13];
            System.arraycopy(var14, 0, var7, 0, var13);
            return var7;
         } else {
            return null;
         }
      } else {
         int var4 = var1.length;
         byte[] var3 = var1;
         var2 = this.a;
         var9 = this;
         if (this.b) {
            this.a(var2, (byte)1);
         }

         byte[] var5 = new byte[8];
         byte var6 = var1[var4 - 1];
         var7 = new byte[var4];

         for(int var8 = 0; var8 < var4 / 8; ++var8) {
            for(int var10 = 0; var10 < 8; ++var10) {
               var5[var10] = var3[(var8 << 3) + var10];
            }

            var9.d(var5);
            System.arraycopy(var5, 0, var7, var8 << 3, 8);
         }

         var16 = new byte[var7.length - var6];
         System.arraycopy(var7, 0, var16, 0, var16.length);
         return var16;
      }
   }

   public int b() {
      return 8;
   }

   public void b(byte[] var1, byte[] var2) throws c {
      this.b = true;
      if (var1 == null && var2 == null) {
         if (this.a == null) {
            throw new c(102);
         }
      } else if (var1.length < 8) {
         throw new c(102);
      } else {
         System.arraycopy(var1, 0, this.a, 0, 8);
      }
   }

   private byte[] a(byte[] var1, byte[] var2, int var3) {
      if (this.b) {
         this.a(var1, (byte)0);
      }

      var1 = new byte[8];
      byte var4 = (byte)(var3 % 8 == 0 ? 0 : 8 - var3 % 8);
      byte[] var5 = new byte[var3 + var4 + 1];
      System.arraycopy(var2, 0, var5, 0, var3);

      int var6;
      for(var6 = var3; var6 < var5.length; ++var6) {
         var5[var6] = 0;
      }

      var5[var6 - 1] = (byte)(var4 + 1);

      for(var6 = 0; var6 < var5.length / 8; ++var6) {
         for(var3 = 0; var3 < 8; ++var3) {
            var1[var3] = var5[(var6 << 3) + var3];
         }

         this.c(var1);
         System.arraycopy(var1, 0, var5, var6 << 3, 8);
      }

      return var5;
   }

   private byte[] b(byte[] var1, int var2) {
      byte var3 = (byte)(var2 % 8 == 0 ? 0 : 8 - var2 % 8);
      int var4;
      byte[] var5 = new byte[(var4 = var2 + var3) + 1];
      if (this.b) {
         this.a(this.a, (byte)0);
      }

      for(int var6 = 0; var6 < var2; var6 += 8) {
         byte[] var7 = new byte[8];
         if (var6 <= var2 - 8) {
            System.arraycopy(var1, var6, var7, 0, 8);
         } else {
            System.arraycopy(var1, var6, var7, 0, var2 & 7);
         }

         System.arraycopy(this.c(var7, (byte)0), 0, var5, var6, 8);
      }

      var5[var4] = (byte)(var3 + 1);
      return var5;
   }

   protected static void a(byte[] var0, int[] var1) {
      var1[0] = (var0[0] & 255) << 24;
      var1[0] |= (var0[1] & 255) << 16;
      var1[0] |= (var0[2] & 255) << 8;
      var1[0] |= var0[3] & 255;
      var1[1] = (var0[4] & 255) << 24;
      var1[1] |= (var0[5] & 255) << 16;
      var1[1] |= (var0[6] & 255) << 8;
      var1[1] |= var0[7] & 255;
   }

   protected static void a(int[] var0, byte[] var1) {
      var1[0] = (byte)(var0[0] >> 24);
      var1[1] = (byte)(var0[0] >> 16);
      var1[2] = (byte)(var0[0] >> 8);
      var1[3] = (byte)var0[0];
      var1[4] = (byte)(var0[1] >> 24);
      var1[5] = (byte)(var0[1] >> 16);
      var1[6] = (byte)(var0[1] >> 8);
      var1[7] = (byte)var0[1];
   }

   protected static int[] b(byte[] var0, byte var1) {
      byte[] var6 = new byte[56];
      byte[] var7 = new byte[56];
      int[] var8 = new int[32];

      int var2;
      int var4;
      for(var2 = 0; var2 < 56; ++var2) {
         byte var3;
         var4 = (var3 = j[var2]) & 7;
         var6[var2] = (byte)((var0[var3 >> 3] & h[var4]) != 0 ? 1 : 0);
      }

      int var5;
      int var12;
      for(int var9 = 0; var9 < 16; ++var9) {
         if (var1 == 1) {
            var4 = 15 - var9 << 1;
         } else {
            var4 = var9 << 1;
         }

         var5 = var4 + 1;
         var8[var4] = var8[var5] = 0;

         for(var2 = 0; var2 < 28; ++var2) {
            if ((var12 = var2 + k[var9]) < 28) {
               var7[var2] = var6[var12];
            } else {
               var7[var2] = var6[var12 - 28];
            }
         }

         for(var2 = 28; var2 < 56; ++var2) {
            if ((var12 = var2 + k[var9]) < 56) {
               var7[var2] = var6[var12];
            } else {
               var7[var2] = var6[var12 - 28];
            }
         }

         for(var2 = 0; var2 < 24; ++var2) {
            if (var7[l[var2]] != 0) {
               var8[var4] |= i[var2];
            }

            if (var7[l[var2 + 24]] != 0) {
               var8[var5] |= i[var2];
            }
         }
      }

      int[] var10 = var8;
      int[] var11 = new int[32];
      int[] var13 = var8;
      var12 = 0;
      boolean var14 = false;
      var5 = 0;

      for(int var15 = 0; var12 < 16; ++var5) {
         var4 = var5++;
         var11[var15] = (var13[var4] & 16515072) << 6;
         var11[var15] |= (var13[var4] & 4032) << 10;
         var11[var15] |= (var10[var5] & 16515072) >> 10;
         var11[var15] |= (var10[var5] & 4032) >> 6;
         ++var15;
         var11[var15] = (var13[var4] & 258048) << 12;
         var11[var15] |= (var13[var4] & 63) << 16;
         var11[var15] |= (var10[var5] & 258048) >> 4;
         var11[var15] |= var10[var5] & 63;
         ++var15;
         ++var12;
      }

      return var11;
   }

   protected static void a(int[] var0, int[] var1) {
      int var7 = 0;
      int var5 = var0[0];
      int var4 = var0[1];
      int var3 = (var5 >>> 4 ^ var4) & 252645135;
      var4 ^= var3;
      var3 = ((var5 ^= var3 << 4) >>> 16 ^ var4) & '\uffff';
      var4 ^= var3;
      var5 ^= var3 << 16;
      var3 = (var4 >>> 2 ^ var5) & 858993459;
      var5 ^= var3;
      var3 = ((var4 ^= var3 << 2) >>> 8 ^ var5) & 16711935;
      var5 ^= var3;
      var4 = (var4 ^= var3 << 8) << 1 | var4 >>> 31 & 1;
      var3 = (var5 ^ var4) & -1431655766;
      var5 ^= var3;
      var4 ^= var3;
      var5 = var5 << 1 | var5 >>> 31 & 1;

      for(int var6 = 0; var6 < 8; ++var6) {
         var3 = (var4 << 28 | var4 >>> 4) ^ var1[var7];
         ++var7;
         int var2 = s[var3 & 63] | q[var3 >>> 8 & 63] | o[var3 >>> 16 & 63] | m[var3 >>> 24 & 63];
         var3 = var4 ^ var1[var7];
         ++var7;
         var2 = var2 | t[var3 & 63] | r[var3 >>> 8 & 63] | p[var3 >>> 16 & 63] | n[var3 >>> 24 & 63];
         var3 = ((var5 ^= var2) << 28 | var5 >>> 4) ^ var1[var7];
         ++var7;
         var2 = s[var3 & 63] | q[var3 >>> 8 & 63] | o[var3 >>> 16 & 63] | m[var3 >>> 24 & 63];
         var3 = var5 ^ var1[var7];
         ++var7;
         var2 = var2 | t[var3 & 63] | r[var3 >>> 8 & 63] | p[var3 >>> 16 & 63] | n[var3 >>> 24 & 63];
         var4 ^= var2;
      }

      var4 = var4 << 31 | var4 >>> 1;
      var3 = (var5 ^ var4) & -1431655766;
      var5 ^= var3;
      var4 ^= var3;
      var3 = ((var5 = var5 << 31 | var5 >>> 1) >>> 8 ^ var4) & 16711935;
      var4 ^= var3;
      var3 = ((var5 ^= var3 << 8) >>> 2 ^ var4) & 858993459;
      var4 ^= var3;
      var5 ^= var3 << 2;
      var3 = (var4 >>> 16 ^ var5) & '\uffff';
      var5 ^= var3;
      var3 = ((var4 ^= var3 << 16) >>> 4 ^ var5) & 252645135;
      var5 ^= var3;
      var4 ^= var3 << 4;
      var0[0] = var4;
      var0[1] = var5;
   }

   protected static void a(byte[] var0, byte[] var1, byte[] var2, int var3) {
      int var4;
      if (var3 == 1) {
         var3 = 8;

         for(var4 = 0; var3-- > 0; ++var4) {
            var0[var4] = (byte)(var1[var4] & var2[var4]);
         }
      } else if (var3 == 2) {
         var3 = 8;

         for(var4 = 0; var3-- > 0; ++var4) {
            var0[var4] = (byte)(var1[var4] ^ var2[var4]);
         }
      } else if (var3 == 3) {
         var3 = 8;

         for(var4 = 0; var3-- > 0; ++var4) {
            var0[var4] = var1[var4];
         }
      }

   }

   private byte[] c(byte[] var1, byte var2) {
      byte[] var3 = new byte[8];
      if (var2 == 0) {
         a(var3, this.e, var1, 2);
         this.c(var3);
         a(this.e, var3, (byte[])null, 3);
      } else {
         byte[] var4;
         a(var4 = new byte[8], var1, (byte[])null, 3);
         this.d(var1);
         a(var3, this.e, var1, 2);
         a(this.e, var4, (byte[])null, 3);
      }

      return var3;
   }

   private void c(byte[] var1) {
      int[] var2 = new int[2];
      a(var1, var2);
      a(var2, this.c);
      a(var2, var1);
   }

   private void d(byte[] var1) {
      int[] var2 = new int[2];
      a(var1, var2);
      a(var2, this.d);
      a(var2, var1);
   }
}
