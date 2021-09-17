package oracle.net.ano;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

import oracle.net.aso.*;
import oracle.net.ns.NetException;
import oracle.net.ns.SQLnetDef;
import oracle.net.ns.SessionAtts;

public class DataIntegrityService extends Service implements SQLnetDef {
   static final String[] a = new String[]{"", "MD5", "SHA1", "SHA512", "SHA256", "SHA384"};
   private static final byte[] k = new byte[]{0, 1, 3, 4, 5, 6};
   private boolean l = false;
   private byte[] m;

   final int a(SessionAtts var1) throws NetException {
      super.a(var1);
      this.i = 3;
      this.f = var1.profile.getDataIntegrityLevelNum();
      String[] var3 = a(var1.profile.getDataIntegrityServices(), a);
      this.g = new int[var3.length];

      int var2;
      for(var2 = 0; var2 < this.g.length; ++var2) {
         this.g[var2] = a(a, var3[var2]);
      }

      this.g = a(this.g, this.f);
      this.h = new byte[this.g.length];

      for(var2 = 0; var2 < this.h.length; ++var2) {
         this.h[var2] = k[this.g[var2]];
      }

      byte var4 = 1;
      if (this.g.length == 0) {
         if (this.f == 3) {
            throw new NetException(315);
         }

         var4 = 9;
      } else if (this.f == 3) {
         var4 = 17;
      }

      return var4;
   }

   final void a(int var1) throws IOException {
      this.d.i();
      short var2 = this.d.d();
      this.j = -1;

      for(int var3 = 0; var3 < a.length; ++var3) {
         if (k[var3] == var2) {
            this.j = (short)var3;
         }
      }

      if (var1 != 2 && var1 == 8) {
         label49: {
            short var11 = (short)this.d.e();
            short var8 = (short)this.d.e();
            byte[] var10 = this.d.k();
            byte[] var4 = this.d.k();
            byte[] var5 = this.d.k();
            byte[] var6 = this.d.k();
            if (var11 > 0 && var8 > 0) {
               int var7 = (var8 + 7) / 8;
               if (var5.length == var7 && var4.length == var7) {
                  i var9 = new i(var10, var4, var11, var8);
                  this.m = var9.a();
                  this.e.ano.a(this.m);
                  this.e.ano.b(var6);
                  this.e.ano.c(var9.a(var5, var5.length));
                  break label49;
               }

               throw new IOException("DiffieHellman negotiation out of synch");
            }

            throw new IOException("Bad parameters from server");
         }
      }

      this.l = this.j > 0;
   }

   final void f() throws NetException {
      if (this.j < 0) {
         throw new NetException(319);
      } else {
         int var1;
         for(var1 = 0; var1 < this.g.length && this.g[var1] != this.j; ++var1) {
         }

         if (var1 == this.g.length) {
            throw new NetException(319);
         }
      }
   }

   public boolean isActive() {
      return this.l;
   }

   final void a_() throws NetException, oracle.net.aso.c {
      if (this.l) {
         if (a[this.j].equals("MD5")) {
            this.c.c = new k();
         } else if (a[this.j].equals("SHA1")) {
            this.c.c = new q();
         } else if (a[this.j].equals("SHA256")) {
            try {
               this.c.c = new s();
            } catch (NoSuchAlgorithmException var3) {
               throw new NetException(318);
            }
         } else if (a[this.j].equals("SHA384")) {
            try {
               this.c.c = new u();
            } catch (NoSuchAlgorithmException var2) {
               throw new NetException(318);
            }
         } else {
            if (!a[this.j].equals("SHA512")) {
               throw new NetException(318);
            }

            try {
               this.c.c = new w();
            } catch (NoSuchAlgorithmException var1) {
               throw new NetException(318);
            }
         }

         this.c.c.a(this.c.b(), this.c.a(), this.c.getDataIntegrityName());
      }

   }

   public static void printInHex(int var0) {
      byte[] var1 = toHex(var0);
      System.out.print(new String(var1));
   }

   public static byte[] toHex(int var0) {
      byte[] var1 = new byte[8];

      for(int var2 = 7; var2 >= 0; --var2) {
         var1[var2] = nibbleToHex((byte)(var0 & 15));
         var0 >>= 4;
      }

      return var1;
   }

   public static byte nibbleToHex(byte var0) {
      return (byte)((var0 = (byte)(var0 & 15)) < 10 ? var0 + 48 : var0 - 10 + 65);
   }

   public static String bArray2String(byte[] var0) {
      StringBuffer var1 = new StringBuffer(var0.length << 1);

      for(int var2 = 0; var2 < var0.length; ++var2) {
         var1.append((char)nibbleToHex((byte)((var0[var2] & 240) >> 4)));
         var1.append((char)nibbleToHex((byte)(var0[var2] & 15)));
      }

      return var1.toString();
   }
}
