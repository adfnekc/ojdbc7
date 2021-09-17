package oracle.net.ano;

import com.sun.security.auth.module.Krb5LoginModule;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.security.AccessControlContext;
import java.security.AccessController;
import java.security.Principal;
import java.security.PrivilegedActionException;
import java.security.PrivilegedExceptionAction;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import javax.security.auth.Subject;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.kerberos.KerberosPrincipal;
import javax.security.auth.kerberos.KerberosTicket;
import oracle.net.aso.b;
import oracle.net.ns.NetException;
import oracle.net.ns.SQLnetDef;
import oracle.net.ns.SessionAtts;
import org.ietf.jgss.GSSContext;
import org.ietf.jgss.GSSCredential;
import org.ietf.jgss.GSSException;
import org.ietf.jgss.GSSManager;
import org.ietf.jgss.GSSName;
import org.ietf.jgss.Oid;
import sun.security.krb5.*;
import sun.security.krb5.internal.*;
import sun.security.util.DerValue;

public class AuthenticationService extends Service implements PrivilegedExceptionAction, SQLnetDef {
   static final String[] a = new String[]{"", "RADIUS", "KERBEROS5", "TCPS"};
   private static final String[] k = new String[]{"", "RADIUS", "KERBEROS5", "tcps"};
   private static final byte[] l = new byte[]{0, 1, 1, 2};
   private static Method m = i();
   private static Method n = null;
   private boolean o = false;
   private Subject p = null;
   private String q = null;
   private String r = null;
   private int s;

   final int a(SessionAtts var1) throws NetException {
      super.a(var1);
      this.i = 1;
      this.s = 64767;
      String[] var3;
      a((String[])(var3 = var1.profile.getAuthenticationServices()), (String[])a);
      this.g = new int[var3.length];

      for(int var2 = 0; var2 < this.g.length; ++var2) {
         this.g[var2] = a((String[])a, (String)var3[var2]);
      }

      return 1;
   }

   final void a() throws IOException {
      int var1 = 3 + (this.g.length << 1);
      this.b(var1);
      this.d.b();
      this.d.a((int)57569);
      this.d.b(this.s);

      for(var1 = 0; var1 < this.g.length; ++var1) {
         this.d.a((short)l[this.g[var1]]);
         this.d.a(k[this.g[var1]]);
      }

   }

   final int b() {
      int var1 = 20;

      for(int var2 = 0; var2 < this.g.length; ++var2) {
         var1 += 5;
         var1 += 4 + k[this.g[var2]].length();
      }

      return var1;
   }

   final void a(int var1) throws IOException {
      this.d.i();
      int var2;
      if ((var2 = this.d.h()) == 64255 && var1 > 2) {
         this.d.d();
         String var3 = this.d.j();
         this.j = (short)a((String[])k, (String)var3);
         if (var1 > 4) {
            this.d.i();
            this.d.f();
            this.d.f();
         }

         this.o = true;
      } else if (var2 == 64511) {
         this.o = false;
      } else {
         throw new NetException(323, "Authentication service received status failure");
      }
   }

   public boolean isActive() {
      return this.o;
   }

   final int c() {
      if (this.isActive()) {
         if (this.j == 1) {
            return 32;
         } else {
            return this.j == 2 ? 37 : 0;
         }
      } else {
         return 0;
      }
   }

   final void d() throws IOException {
      if (this.o) {
         if (this.j == 1) {
            this.b(3);
            this.d.b();
            this.d.a(2L);
            this.d.a(2L);
            return;
         }

         if (this.j == 2) {
            this.b(4);
            this.d.b();
            this.d.a(2L);
            this.d.a(2L);
            this.d.a((short)0);
         }
      }

   }

   final void e() throws IOException {
      if (this.o) {
         this.e.ano.c();
         Service.a(this.d);
         if (this.j == 1) {
            this.d.m();
            this.d.m();
            return;
         }

         if (this.j == 2) {
            String var1 = this.d.j();
            String var2 = this.d.j();
            this.q = var1 + "/" + var2;

            try {
               if ((var1 = InetAddress.getByName(var2).getCanonicalHostName()).toLowerCase().startsWith(var2.toLowerCase() + ".")) {
                  var2 = var1;
               }
            } catch (UnknownHostException var3) {
               var2 = var2.toLowerCase();
            }

            this.r = a(var2);
            AccessControlContext var5;
            if ((var5 = AccessController.getContext()) != null) {
               this.p = Subject.getSubject(var5);
            }

            if (this.p == null) {
               this.p = this.h();
            }

            try {
               Subject.doAs(this.p, this);
               return;
            } catch (PrivilegedActionException var4) {
               Exception var6;
               NetException var7;
               if ((var6 = var4.getException()) instanceof NetException) {
                  var7 = (NetException)var6;
               } else {
                  (var7 = new NetException(323, var4.getMessage())).initCause(var4);
               }

               throw var7;
            }
         }
      }

   }

   private static String a(String var0) {
      String var1 = null;
      if (n == null) {
         try {
            Class var2 = Class.forName("sun.security.krb5.PrincipalName");
            Class var3 = String.class;
            Method var9 = var2.getDeclaredMethod("mapHostToRealm", var3);
            AccessController.doPrivileged(new a(var9));
         } catch (ClassNotFoundException var6) {
         } catch (NoSuchMethodException var7) {
         } catch (PrivilegedActionException var8) {
         }
      }

      try {
         var1 = (String)n.invoke((Object)null, var0);
      } catch (InvocationTargetException var4) {
      } catch (IllegalAccessException var5) {
      }

      return var1;
   }

   private final Subject h() throws NetException {
      Subject var1 = new Subject();
      Krb5LoginModule var2 = new Krb5LoginModule();
      HashMap var3 = new HashMap();
      HashMap var4;
      (var4 = new HashMap()).put("useTicketCache", "true");
      var4.put("doNotPrompt", "true");
      String var5;
      if ((var5 = (String)this.e.profile.get("oracle.net.kerberos5_cc_name")) != null && !var5.equals("")) {
         var4.put("ticketCache", var5);
      }

      var2.initialize(var1, (CallbackHandler)null, var3, var4);
      boolean var8 = false;

      try {
         var8 = var2.login();
         var2.commit();
      } catch (Exception var6) {
         NetException var7;
         (var7 = new NetException(323, var6.getMessage())).initCause(var6);
         throw var7;
      }

      if (!var8) {
         throw new NetException(323, "Kerberos5 adaptor couldn't retrieve credentials (TGT) from the cache");
      } else {
         return var1;
      }
   }

   public Object run() throws RealmException, IOException, KrbApErrException, KrbCryptoException, KdcErrException, Asn1Exception {
      NetException var2;
      try {
         GSSManager var1 = GSSManager.getInstance();
         Oid var11 = new Oid("1.2.840.113554.1.2.2");
         Oid var3 = new Oid("1.2.840.113554.1.2.2.1");
         byte[] var4 = var11.getDER();
         KerberosPrincipal var5 = null;
         Iterator var6;
         Principal var18;
         if ((var6 = this.p.getPrincipals().iterator()).hasNext() && (var18 = (Principal)var6.next()) instanceof KerberosPrincipal) {
            var5 = (KerberosPrincipal)var18;
         }

         String var7;
         Realm var20;
         if (this.r != null) {
            var20 = new Realm(this.r);
         } else {
            var7 = Realm.parseRealmAtSeparator(this.q + "@" + var5.getRealm());
            var20 = new Realm(var7);
         }

         String var22 = this.q + "@" + var20.toString();
         var7 = var5.getName();
         GSSName var19 = var1.createName(var22, var3);
         GSSName var13 = var1.createName(var7, var3);
         GSSCredential var14 = var1.createCredential(var13, 0, var11, 1);
         GSSContext var10 = var1.createContext(var19, var11, var14, 0);
         boolean var12 = true;
         if ((String)this.e.profile.get("oracle.net.kerberos5_mutual_authentication") != "true") {
            var12 = false;
         }

         var10.requestMutualAuth(var12);
         var10.requestConf(false);
         var10.requestInteg(false);
         var10.requestCredDeleg(true);
         byte[] var16 = new byte[0];
         byte[] var21 = new byte[(var16 = var10.initSecContext(var16, 0, 0)).length - 17];
         System.arraycopy(var16, 17, var21, 0, var21.length);
         var16 = InetAddress.getLocalHost().getAddress();
         int var23 = 39 + var16.length + 4 + var21.length;
         this.e.ano.a(var23, this.i);
         this.b(4);
         this.d.a((int)2);
         this.d.a(4L);
         this.d.a(var16);
         this.d.a(var21);
         this.d.a();
         this.e.ano.c();
         int[] var17 = Service.a(this.d);
         this.d.d();
         byte[] var15;
         if (var12) {
            if (var17[1] < 2) {
               throw new NetException(323, "Mutual authentication failed during Kerberos5 authentication");
            }

            var16 = this.d.k();
            var15 = new byte[var4.length + 2 + var16.length];
            System.arraycopy(var4, 0, var15, 0, var4.length);
            var15[var4.length] = 2;
            var15[var4.length + 1] = 0;
            System.arraycopy(var16, 0, var15, var4.length + 2, var16.length);
            var15 = (new DerValue(DerValue.createTag((byte)64, true, (byte)0), var15)).toByteArray();

            try {
               var10.initSecContext(var15, 0, var15.length);
            } catch (GSSException var8) {
               (var2 = new NetException(323, var8.getMessage())).initCause(var8);
               throw var2;
            }

            if (!var10.getMutualAuthState()) {
               throw new NetException(323, "Mutual authentication failed during Kerberos5 authentication");
            }
         }

         if (!var10.isEstablished()) {
            throw new NetException(323, "Kerberos5 adaptor couldn't create context");
         } else {
            if ((var15 = this.a(var10, var21)) == null) {
               var15 = new byte[0];
            }

            var23 = 25 + var15.length;
            this.e.ano.a(var23, this.i);
            this.b(1);
            this.d.a(var15);
            this.d.a();
            return null;
         }
      } catch (GSSException var9) {
         (var2 = new NetException(323, var9.getMessage())).initCause(var9);
         throw var2;
      }
   }

   private final byte[] a(GSSContext var1, byte[] var2) throws KrbApErrException, IOException, RealmException, Asn1Exception, KrbCryptoException, KdcErrException {
      byte[] var3 = null;
      if (var1.getCredDelegState()) {
         Set var10000 = this.p.getPrivateCredentials();
         var1 = null;
         Object[] var11 = var10000.toArray();
         byte[] var4 = null;
         int var5 = -1;

         for(int var6 = 0; var6 < var11.length; ++var6) {
            KerberosTicket var7;
            String var8 = (var7 = (KerberosTicket)var11[var6]).getServer().getName();
            byte[] var9 = var7.getSessionKey().getEncoded();
            int var17 = var7.getSessionKeyType();
            if (!var8.startsWith("krbtgt")) {
               var4 = var9;
               var5 = var17;
            }
         }

         APReq var16 = new APReq(var2);
         EncryptionKey var18 = new EncryptionKey(var5, var4);
         byte[] var19 = var16.authenticator.decrypt(var18, 11);
         var19 = a(var16.authenticator, var19, true);
         byte[] var12;
         if ((var12 = (new Authenticator(var19)).getChecksum().getBytes()).length >= 26) {
            int var13;
            var3 = new byte[var13 = ((var12[27] & 255) << 8) + (var12[26] & 255)];
            System.arraycopy(var12, 28, var3, 0, var13);
            KRBCred var14 = new KRBCred(var3);

            try {
               var2 = var14.encPart.decrypt(EncryptionKey.NULL_KEY, 14);
            } catch (Exception var10) {
               var2 = var14.encPart.decrypt(var18, 14);
            }

            var2 = a(var14.encPart, var2, true);
            EncryptedData var15 = new EncryptedData(var18, var2, 14);
            var3 = (new KRBCred(var14.tickets, var15)).asn1Encode();
         }
      }

      return var3;
   }

   private static byte[] a(EncryptedData var0, Object... var1) {
      byte[] var2 = null;

      try {
         if (m.getParameterTypes().length == 1) {
            var2 = (byte[])m.invoke(var0, var1[0]);
         } else {
            var2 = (byte[])m.invoke(var0, var1);
         }
      } catch (InvocationTargetException var3) {
      } catch (IllegalAccessException var4) {
      }

      return var2;
   }

   private static Method i() {
      Method var0 = null;

      try {
         Class var1 = Class.forName("sun.security.krb5.EncryptedData");
         Class[] var2 = new Class[]{byte[].class, Boolean.TYPE};

         try {
            var0 = var1.getDeclaredMethod("reset", var2);
         } catch (NoSuchMethodException var3) {
            var0 = var1.getDeclaredMethod("reset", var2[0]);
         }
      } catch (ClassNotFoundException var4) {
      } catch (NoSuchMethodException var5) {
      }

      return var0;
   }

   final void f() {
      boolean var10000 = this.o;
   }

   public static final byte[] obfuscatePasswordForRadius(byte[] var0) {
      return oracle.net.aso.b.c(var0);
   }

   // $FF: synthetic method
   static Method a(Method var0) {
      n = var0;
      return var0;
   }
}
