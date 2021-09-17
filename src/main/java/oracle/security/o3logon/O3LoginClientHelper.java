package oracle.security.o3logon;

public final class O3LoginClientHelper {
   private b a;
   private boolean b;

   public O3LoginClientHelper() {
      this.b = true;
      this.a = new b();
   }

   public O3LoginClientHelper(boolean var1) {
      this.b = var1;
      this.a = new b();
   }

   public final byte[] getSessionKey(String var1, String var2, byte[] var3) {
      byte[] var4 = this.a.a(var1, var2, this.b);
      b var10000 = this.a;
      return oracle.security.o3logon.b.a(var4, var3);
   }

   public final byte[] getEPasswd(byte[] var1, byte[] var2) {
      b var10000 = this.a;
      return oracle.security.o3logon.b.b(var1, var2);
   }
}
