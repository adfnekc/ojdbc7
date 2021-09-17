package oracle.net.aso;

import java.io.IOException;

public final class c extends IOException {
   private int a;

   public c(int var1) {
      this.a = var1;
   }

   public final String getMessage() {
      return Integer.toString(this.a);
   }
}
