package oracle.jdbc.driver;

import java.io.IOException;
import java.sql.SQLException;

final class T4CTTIokeyval extends T4CTTIfun {
   static final byte KVASET_KPDUSR = 1;
   static final byte KVACLA_KPDUSR = 2;
   private byte[] namespaceByteArr;
   private char[] charArr;
   private byte[][] attrArr;
   private int[] attrArrSize;
   private byte[][] valueArr;
   private int[] valueArrSize;
   private byte[] kvalflg;
   private int nbNamespaceBytes;
   private int nbKeyVal;
   private boolean clear;
   private static final String _Copyright_2007_Oracle_All_Rights_Reserved_ = null;
   public static final String BUILD_DATE = "Thu_Apr_04_15:09:24_PDT_2013";
   public static final boolean TRACE = false;

   T4CTTIokeyval(T4CConnection var1) {
      super(var1, (byte)17);
      this.setFunCode((short)154);
      this.namespaceByteArr = new byte[100];
      this.charArr = new char[100];
      this.attrArr = new byte[10][];
      this.attrArrSize = new int[10];
      this.valueArr = new byte[10][];
      this.valueArrSize = new int[10];
      this.kvalflg = new byte[10];
   }

   void doOKEYVAL(Namespace var1) throws IOException, SQLException {
      String var2 = var1.name;
      String[] var3 = var1.keys;
      String[] var4 = var1.values;
      this.clear = var1.clear;
      this.nbKeyVal = var1.nbPairs;
      int var5 = var2.length() * this.meg.conv.cMaxCharSize;
      if (var5 > this.namespaceByteArr.length) {
         this.namespaceByteArr = new byte[var5];
      }

      if (var2.length() > this.charArr.length) {
         this.charArr = new char[var2.length()];
      }

      var2.getChars(0, var2.length(), this.charArr, 0);
      this.nbNamespaceBytes = this.meg.conv.javaCharsToCHARBytes(this.charArr, 0, this.namespaceByteArr, 0, var2.length());
      if (this.nbKeyVal > 0) {
         if (this.nbKeyVal > this.attrArr.length) {
            this.attrArr = new byte[this.nbKeyVal][];
            this.attrArrSize = new int[this.nbKeyVal];
            this.valueArr = new byte[this.nbKeyVal][];
            this.valueArrSize = new int[this.nbKeyVal];
            this.kvalflg = new byte[this.nbKeyVal];
         }

         for(int var6 = 0; var6 < this.nbKeyVal; ++var6) {
            String var7 = var3[var6];
            String var8 = var4[var6];
            int var9 = var7.length() * this.meg.conv.cMaxCharSize;
            if (this.attrArr[var6] == null || this.attrArr[var6].length < var9) {
               this.attrArr[var6] = new byte[var9];
            }

            int var10 = var8.length() * this.meg.conv.cMaxCharSize;
            if (this.valueArr[var6] == null || this.valueArr[var6].length < var10) {
               this.valueArr[var6] = new byte[var10];
            }

            if (var7.length() > this.charArr.length) {
               this.charArr = new char[var7.length()];
            }

            var7.getChars(0, var7.length(), this.charArr, 0);
            this.attrArrSize[var6] = this.meg.conv.javaCharsToCHARBytes(this.charArr, 0, this.attrArr[var6], 0, var7.length());
            if (var8.length() > this.charArr.length) {
               this.charArr = new char[var8.length()];
            }

            var8.getChars(0, var8.length(), this.charArr, 0);
            this.valueArrSize[var6] = this.meg.conv.javaCharsToCHARBytes(this.charArr, 0, this.valueArr[var6], 0, var8.length());
         }
      }

      this.doPigRPC();
   }

   void marshal() throws IOException {
      this.meg.marshalPTR();
      this.meg.marshalUB4((long)this.nbNamespaceBytes);
      if (this.nbKeyVal > 0) {
         this.meg.marshalPTR();
      } else {
         this.meg.marshalNULLPTR();
      }

      this.meg.marshalUB4((long)this.nbKeyVal);
      int var1 = 0;
      if (this.nbKeyVal > 0) {
         var1 = 1;
      }

      if (this.clear) {
         var1 |= 2;
      }

      this.meg.marshalUB2(var1);
      this.meg.marshalNULLPTR();
      this.meg.marshalCHR(this.namespaceByteArr, 0, this.nbNamespaceBytes);
      if (this.nbKeyVal > 0) {
         this.meg.marshalKEYVAL(this.attrArr, this.attrArrSize, this.valueArr, this.valueArrSize, this.kvalflg, this.nbKeyVal);
      }

   }
}
