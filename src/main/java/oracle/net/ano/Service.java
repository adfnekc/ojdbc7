package oracle.net.ano;

import java.io.IOException;
import java.util.Vector;
import oracle.net.ns.NetException;
import oracle.net.ns.SQLnetDef;
import oracle.net.ns.SessionAtts;

public abstract class Service implements SQLnetDef {
   static final String[] b = new String[]{"", "SupervisorService", "AuthenticationService", "EncryptionService", "DataIntegrityService"};
   protected Ano c;
   protected AnoComm d;
   protected SessionAtts e;
   protected int f;
   protected int[] g;
   protected byte[] h;
   protected int i;
   protected short j;

   int a(SessionAtts var1) throws NetException {
      this.e = var1;
      this.c = var1.ano;
      this.d = var1.ano.a;
      this.f = 0;
      this.h = new byte[0];
      return 1;
   }

   final void b(int var1) throws IOException {
      this.d.c(this.i);
      this.d.c(var1);
      this.d.b(0L);
   }

   void a() throws IOException {
      this.b(2);
      this.d.b();
      this.d.a(this.h);
   }

   int b() {
      return 12 + this.h.length;
   }

   abstract void a(int var1) throws IOException;

   abstract void f() throws NetException;

   void a_() throws NetException, oracle.net.aso.c {
   }

   final int g() {
      return 8 + this.b();
   }

   static int[] a(AnoComm var0) throws IOException {
      int var1 = var0.m();
      int var2 = var0.m();
      int var4 = (int)var0.n();
      int[] var3;
      (var3 = new int[3])[0] = var1;
      var3[1] = var2;
      var3[2] = var4;
      return var3;
   }

   final void c(int var1) throws IOException {
      this.a(var1);
      this.f();
   }

   static int[] a(int[] var0, int var1) throws NetException {
      int var2;
      int[] var3;
      switch(var1) {
      case 0:
         (var3 = new int[var0.length + 1])[0] = 0;

         for(var2 = 0; var2 < var0.length; ++var2) {
            var3[var2 + 1] = var0[var2];
         }

         return var3;
      case 1:
         (var3 = new int[1])[0] = 0;
         break;
      case 2:
         var3 = new int[var0.length + 1];

         for(var2 = 0; var2 < var0.length; ++var2) {
            var3[var2] = var0[var2];
         }

         var3[var2] = 0;
         break;
      case 3:
         var3 = var0;
         break;
      default:
         throw new NetException(304);
      }

      return var3;
   }

   static String[] a(String[] var0, String[] var1) throws NetException {
      if (var0 == null || var0.length == 0) {
         if (var1[0] == "") {
            var0 = new String[var1.length - 1];

            for(int var2 = 0; var2 < var0.length; ++var2) {
               var0[var2] = var1[var2 + 1];
            }
         } else {
            var0 = var1;
         }
      }

      Vector var5 = new Vector(10);

      int var3;
      int var4;
      for(var3 = 0; var3 < var0.length; ++var3) {
         if (var0[var3].equals("")) {
            throw new NetException(303);
         }

         for(var4 = 0; var4 < var1.length; ++var4) {
            if (var1[var4].equals(var0[var3])) {
               var5.addElement(var1[var4]);
               break;
            }
         }

         if (var4 == var1.length) {
            throw new NetException(303);
         }
      }

      var0 = new String[var3 = var5.size()];

      for(var4 = 0; var4 < var3; ++var4) {
         var0[var4] = (String)var5.elementAt(var4);
      }

      return var0;
   }

   static byte a(String[] var0, String var1) throws NetException {
      for(byte var2 = 0; var2 < var0.length; ++var2) {
         if (var1.equals(var0[var2])) {
            return var2;
         }
      }

      throw new NetException(309);
   }

   public static String getLevelString(int var0) throws NetException {
      String var1;
      switch(var0) {
      case 0:
         var1 = "ACCEPTED";
         break;
      case 1:
         var1 = "REJECTED";
         break;
      case 2:
         var1 = "REQUESTED";
         break;
      case 3:
         var1 = "REQUIRED";
         break;
      default:
         throw new NetException(322);
      }

      return var1;
   }

   public static String getServiceName(int var0) throws NetException {
      String var1;
      switch(var0) {
      case 1:
         var1 = "AUTHENTICATION";
         break;
      case 2:
         var1 = "ENCRYPTION";
         break;
      case 3:
         var1 = "DATAINTEGRITY";
         break;
      case 4:
         var1 = "SUPERVISOR";
         break;
      default:
         throw new NetException(323);
      }

      return var1;
   }

   public boolean isActive() {
      return false;
   }
}
