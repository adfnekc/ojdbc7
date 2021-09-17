package oracle.net.ano;

import java.lang.reflect.Method;
import java.security.PrivilegedExceptionAction;

final class a implements PrivilegedExceptionAction {
   // $FF: synthetic field
   private Method a;

   a(Method var1) {
      super();
      this.a = var1;
   }

   public final Object run() {
      if (!this.a.isAccessible()) {
         this.a.setAccessible(true);
      }

      AuthenticationService.a(this.a);
      return null;
   }
}
