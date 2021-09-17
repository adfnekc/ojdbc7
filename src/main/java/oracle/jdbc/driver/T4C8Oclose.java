package oracle.jdbc.driver;

import java.io.IOException;

final class T4C8Oclose extends T4CTTIfun {
   private int[] cursorId = null;
   private int offset = 0;
   private static final String _Copyright_2007_Oracle_All_Rights_Reserved_ = null;
   public static final String BUILD_DATE = "Thu_Apr_04_15:09:24_PDT_2013";
   public static final boolean TRACE = false;

   T4C8Oclose(T4CConnection var1) {
      super(var1, (byte)17);
   }

   void doOCANA(int[] var1, int var2) throws IOException {
      this.setFunCode((short)120);
      this.cursorId = var1;
      this.offset = var2;
      this.doPigRPC();
   }

   void doOCCA(int[] var1, int var2) throws IOException {
      this.setFunCode((short)105);
      this.cursorId = var1;
      this.offset = var2;
      this.doPigRPC();
   }

   void marshal() throws IOException {
      this.meg.marshalPTR();
      this.meg.marshalUB4((long)this.offset);

      for(int var1 = 0; var1 < this.offset; ++var1) {
         this.meg.marshalUB4((long)this.cursorId[var1]);
      }

   }
}
