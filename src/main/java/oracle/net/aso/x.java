package oracle.net.aso;

import java.security.DigestException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

final class x implements m {
   private MessageDigest a = null;

   x() throws NoSuchAlgorithmException {
      this.a = MessageDigest.getInstance("SHA-512");
      this.a();
   }

   public final int b() {
      return this.a.getDigestLength();
   }

   public final void a(byte[] var1, int var2, int var3) {
      this.a.update(var1, 0, var3);
   }

   public final void a() {
      this.a.reset();
   }

   public final int a(byte[] var1) {
      int var2 = 0;

      try {
         var2 = this.a.digest(var1, 0, this.a.getDigestLength());
      } catch (DigestException var3) {
      }

      return var2;
   }
}
