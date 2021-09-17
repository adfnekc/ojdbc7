package oracle.jdbc.driver;

class Namespace {
   static final int ATTRIBUTE_MAX_LENGTH = 30;
   static final int VALUE_MAX_LENGTH = 4000;
   String name;
   boolean clear;
   String[] keys;
   String[] values;
   int nbPairs;

   Namespace(String var1) {
      if (var1 == null) {
         throw new NullPointerException();
      } else {
         this.name = var1;
         this.clear = false;
         this.nbPairs = 0;
         this.keys = new String[5];
         this.values = new String[5];
      }
   }

   void clear() {
      this.clear = true;

      for(int var1 = 0; var1 < this.nbPairs; ++var1) {
         this.keys[var1] = null;
         this.values[var1] = null;
      }

      this.nbPairs = 0;
   }

   void setAttribute(String var1, String var2) {
      if (var1 != null && var2 != null && !var1.equals("")) {
         if (this.nbPairs == this.keys.length) {
            String[] var3 = new String[this.keys.length * 2];
            String[] var4 = new String[this.keys.length * 2];
            System.arraycopy(this.keys, 0, var3, 0, this.keys.length);
            System.arraycopy(this.values, 0, var4, 0, this.values.length);
            this.keys = var3;
            this.values = var4;
         }

         this.keys[this.nbPairs] = var1;
         this.values[this.nbPairs] = var2;
         ++this.nbPairs;
      } else {
         throw new NullPointerException();
      }
   }
}
