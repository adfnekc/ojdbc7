package oracle.net.aso;

import java.util.Random;

public final class n {
   private int a = 971;
   private int b = 11113;
   private int c = 104322;
   private int d = 4181;
   private boolean e = false;

   public final short a() {
      if (!this.e) {
         Random var2 = new Random();
         this.d = var2.nextInt();
         this.e = true;
      } else {
         this.d += 7;
         this.b += 1907;
         this.c += 73939;
         if (this.d >= 9973) {
            this.d -= 9871;
         }

         if (this.b >= 99991) {
            this.b -= 89989;
         }

         if (this.c >= 224729) {
            this.c -= 96233;
         }

         this.d = this.d * this.a + this.b + this.c;
      }

      return (short)(this.d >> 16 ^ this.d & '\uffff');
   }
}
