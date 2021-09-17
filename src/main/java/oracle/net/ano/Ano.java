package oracle.net.ano;

import oracle.net.aso.h;
import oracle.net.aso.j;
import oracle.net.ns.NetException;
import oracle.net.ns.SQLnetDef;
import oracle.net.ns.SessionAtts;

import java.io.IOException;

public class Ano implements SQLnetDef {
   private SessionAtts d;
   protected AnoComm a;
   private byte[] e;
   private byte[] f;
   private byte[] g;
   private boolean h = false;
   protected j b;
   protected h c;
   private int i = 1;
   private Service[] j;
   private byte[] k;
   private boolean l;

   public void init(SessionAtts var1) throws NetException {
      this.d = var1;
      this.d.ano = this;
      this.j = new Service[Service.b.length];
      this.a = new AnoComm(var1);

      for(int var2 = 1; var2 < Service.b.length; ++var2) {
         Service var3;
         try {
            var3 = (Service)Class.forName("oracle.net.ano." + Service.b[var2]).newInstance();
         } catch (Exception var4) {
            throw new NetException(308);
         }

         this.i |= var3.a(var1);
         this.j[var3.i] = var3;
      }

      if ((this.i & 16) > 0 && (this.i & 8) > 0) {
         this.i &= -17;
      }

   }

   public void negotiation(boolean var1) throws IOException {
      int var2 = 0;

      int var3;
      for(var3 = 1; var3 < 5; ++var3) {
         var2 += this.j[var3].g();
      }

      var3 = var2 + 13;
      if (this.d.poolEnabled && var1) {
         var3 += 16;
      }

      this.a(var3, this.j.length - 1);
      this.j[4].a();
      this.j[1].a();
      this.j[2].a();
      this.j[3].a();
      this.a.a();
      int[] var4 = this.c();

      for(var2 = 0; var2 < var4[2]; ++var2) {
         int[] var6;
         if ((var6 = Service.a(this.a))[2] != 0) {
            throw new NetException(var6[2]);
         }

         this.j[var6[0]].c(var6[1]);
      }

      for(var2 = 1; var2 < 5; ++var2) {
         this.j[var2].a_();
      }

      var2 = 0;
      var3 = 0;
      if (this.e != null) {
         var2 = 0 + 12 + this.e.length;
         ++var3;
      }

      int var5;
      if ((var5 = ((AuthenticationService)this.j[1]).c()) > 0) {
         var2 += var5;
         ++var3;
      }

      if (var2 > 0) {
         var2 += 13;
         this.a(var2, var3);
         if (this.e != null) {
            this.j[3].b(1);
            this.a.a(this.e);
         }

         if (var5 > 0) {
            ((AuthenticationService)this.j[1]).d();
         }

         this.a.a();
         ((AuthenticationService)this.j[1]).e();
      }

      this.h = this.j[2].isActive() || this.j[3].isActive();
      if (this.h) {
         this.d.turnEncryptionOn(new AnoNetInputStream(this.d), new AnoNetOutputStream(this.d));
      }

   }

   public int getNAFlags() {
      return this.i;
   }

   public void setO3logSessionKey(byte[] var1) {
      this.k = var1;
   }

   public byte[] getO3logSessionKey() {
      return this.k;
   }

   public j getEncryptionAlg() {
      return this.b;
   }

   public h getDataIntegrityAlg() {
      return this.c;
   }

   public String getEncryptionName() {
      return this.j != null && this.j.length > 2 ? EncryptionService.a[this.j[2].j] : "";
   }

   public String getDataIntegrityName() {
      return this.j != null && this.j.length > 3 ? DataIntegrityService.a[this.j[3].j] : "";
   }

   public String getAuthenticationAdaptorName() {
      return this.j != null && this.j.length > 1 ? AuthenticationService.a[this.j[1].j] : "";
   }

   public void setRenewKey(boolean var1) {
      this.l = var1;
   }

   public boolean getRenewKey() {
      return this.l;
   }

   protected final void a(byte[] var1) {
      this.e = var1;
   }

   protected final void b(byte[] var1) {
      this.f = var1;
   }

   protected final void c(byte[] var1) {
      this.g = var1;
   }

   protected final byte[] a() {
      return this.f;
   }

   protected final byte[] b() {
      return this.g;
   }

   protected final void a(int var1, int var2) throws IOException {
      this.a.b(-559038737L);
      this.a.c(var1);
      this.a.c();
      this.a.c(var2);
      this.a.b((short)0);
   }

   final int[] c() throws IOException {
      if (this.a.n() != -559038737L) {
         throw new NetException(302);
      } else {
         int var1 = this.a.m();
         int var2 = (int)this.a.n();
         int var3 = this.a.m();
         short var4 = this.a.l();
         int[] var5;
         (var5 = new int[4])[0] = var1;
         var5[1] = var2;
         var5[2] = var3;
         var5[3] = var4;
         return var5;
      }
   }
}
