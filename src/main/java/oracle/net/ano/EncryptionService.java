package oracle.net.ano;

import oracle.net.aso.*;
import oracle.net.ns.NetException;
import oracle.net.ns.SQLnetDef;
import oracle.net.ns.SessionAtts;

import java.io.IOException;

public class EncryptionService extends Service implements SQLnetDef {
   static final String[] a = new String[]{"", "RC4_40", "RC4_56", "RC4_128", "RC4_256", "DES40C", "DES56C", "3DES112", "3DES168", "AES128", "AES192", "AES256"};
   private final byte[] k = new byte[]{0, 1, 8, 10, 6, 3, 2, 11, 12, 15, 16, 17};
   private boolean l = false;

   final int a(SessionAtts var1) throws NetException {
      super.a(var1);
      this.i = 2;
      this.f = var1.profile.getEncryptionLevelNum();
      String[] var3 = a(var1.profile.getEncryptionServices(), a);
      this.g = new int[var3.length];

      int var2;
      for(var2 = 0; var2 < this.g.length; ++var2) {
         this.g[var2] = a(a, var3[var2]);
      }

      this.g = a(this.g, this.f);
      this.h = new byte[this.g.length];

      for(var2 = 0; var2 < this.h.length; ++var2) {
         this.h[var2] = this.k[this.g[var2]];
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

   public boolean isActive() {
      return this.l;
   }

   final void a(int var1) throws IOException {
      if (var1 != 2) {
         throw new NetException(305);
      } else {
         this.d.i();
         short var3 = this.d.d();
         this.j = -1;

         for(int var2 = 0; var2 < a.length; ++var2) {
            if (this.k[var2] == var3) {
               this.j = (short)var2;
            }
         }

         this.l = this.j > 0;
      }
   }

   final void f() throws NetException {
      if (this.j < 0) {
         throw new NetException(316);
      } else {
         int var1;
         for(var1 = 0; var1 < this.g.length && this.g[var1] != this.j; ++var1) {
         }

         if (var1 == this.g.length) {
            throw new NetException(316);
         }
      }
   }

   final void a_() throws oracle.net.aso.c, NetException {
      if (this.l) {
         if (a[this.j].equals("RC4_40")) {
            this.c.b = new o(40);
         } else if (a[this.j].equals("RC4_56")) {
            this.c.b = new o(56);
         } else if (a[this.j].equals("RC4_128")) {
            this.c.b = new o(128);
         } else if (a[this.j].equals("RC4_256")) {
            this.c.b = new o(256);
         } else if (a[this.j].equals("DES40C")) {
            this.c.b = new f();
         } else if (a[this.j].equals("DES56C")) {
            this.c.b = new g();
         } else if (a[this.j].equals("3DES112")) {
            this.c.b = new d();
         } else if (a[this.j].equals("3DES168")) {
            this.c.b = new e();
         } else if (a[this.j].equals("AES128")) {
            this.c.b = new oracle.net.aso.a(1);
         } else if (a[this.j].equals("AES192")) {
            this.c.b = new oracle.net.aso.a(2);
         } else {
            if (!a[this.j].equals("AES256")) {
               throw new NetException(317);
            }

            this.c.b = new oracle.net.aso.a(3);
         }

         this.c.b.a(this.c.b(), this.c.a());
      }

   }
}
