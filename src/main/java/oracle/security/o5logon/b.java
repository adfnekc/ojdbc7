package oracle.security.o5logon;

import java.io.IOException;

public final class b extends IOException {
   private int a;

   public b(int var1) {
      this.a = var1;
   }

   public final String getMessage() {
      return Integer.toString(this.a);
   }
}
