package oracle.net.ano;

import oracle.net.ns.NetException;
import oracle.net.ns.SQLnetDef;
import oracle.net.ns.SessionAtts;

import java.io.IOException;

public class SupervisorService extends Service implements SQLnetDef {
   private byte[] a;
   private int[] k;
   private int[] l;
   private int m;
   private int n;

   final int a(SessionAtts var1) throws NetException {
      super.a(var1);
      this.i = 4;
      byte[] var3 = new byte[8];

      for(int var2 = 0; var2 < var3.length; ++var2) {
         var3[var2] = 9;
      }

      this.a = var3;
      this.m = 0;
      this.n = 2;
      this.k = new int[4];
      this.k[0] = 4;
      this.k[1] = 1;
      this.k[2] = 2;
      this.k[3] = 3;
      return 1;
   }

   final void a() throws IOException {
      this.b(3);
      this.d.b();
      this.d.a(this.a);
      this.d.a(this.k);
   }

   final int b() {
      return 12 + this.a.length + 4 + 10 + (this.k.length << 1);
   }

   final void a(int var1) throws IOException {
      this.d.i();
      if (this.d.h() != 31) {
         throw new NetException(306);
      } else {
         this.l = this.d.g();
      }
   }

   final void f() throws NetException {
      for(int var1 = 0; var1 < this.l.length; ++var1) {
         int var2;
         for(var2 = 0; var2 < this.k.length; ++var2) {
            if (this.l[var1] == this.k[var2]) {
               ++this.m;
               break;
            }
         }

         if (var2 == this.k.length) {
            throw new NetException(320);
         }
      }

      if (this.m != this.n) {
         throw new NetException(321);
      }
   }
}
