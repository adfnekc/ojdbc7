package oracle.sql;

import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import oracle.jdbc.driver.DatabaseError;

class CharacterSetByte extends CharacterSet implements CharacterRepConstants {
   private static final String _Copyright_2007_Oracle_All_Rights_Reserved_ = null;
   public static final String BUILD_DATE = "Thu_Apr_04_15:09:24_PDT_2013";
   public static final boolean TRACE = false;

   CharacterSetByte(int var1) {
      super(var1);
      this.rep = 1;
   }

   public boolean isLossyFrom(CharacterSet var1) {
      return var1.rep != 1;
   }

   public boolean isConvertibleFrom(CharacterSet var1) {
      return var1.rep <= 1024;
   }

   private String toString(byte[] var1, int var2, int var3, char var4) throws SQLException {
      try {
         return new String(var1, var2, var3, "ASCII");
      } catch (UnsupportedEncodingException var7) {
         SQLException var6 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 183);
         var6.fillInStackTrace();
         throw var6;
      }
   }

   public String toStringWithReplacement(byte[] var1, int var2, int var3) {
      try {
         return this.toString(var1, var2, var3, '?');
      } catch (SQLException var5) {
         throw new Error("CharacterSetByte.toString");
      }
   }

   public String toString(byte[] var1, int var2, int var3) throws SQLException {
      return this.toString(var1, var2, var3, '\u0000');
   }

   public byte[] convert(String var1) throws SQLException {
      int var2 = var1.length();
      char[] var3 = new char[var1.length()];
      var1.getChars(0, var2, var3, 0);
      return charsToBytes(var3, (byte)0);
   }

   public byte[] convertWithReplacement(String var1) {
      int var2 = var1.length();
      char[] var3 = new char[var1.length()];
      var1.getChars(0, var2, var3, 0);

      try {
         return charsToBytes(var3, (byte)63);
      } catch (SQLException var5) {
         return new byte[0];
      }
   }

   public byte[] convert(CharacterSet var1, byte[] var2, int var3, int var4) throws SQLException {
      byte[] var5;
      if (var1.rep == 1) {
         var5 = useOrCopy(var2, var3, var4);
      } else if (var1.rep == 2) {
         char[] var6 = CharacterSetUTF.UTFToJavaChar(var2, var3, var4);
         var5 = charsToBytes(var6, (byte)0);
      } else {
         String var8 = var1.toString(var2, var3, var4);
         char[] var7 = var8.toCharArray();
         var5 = charsToBytes(var7, (byte)0);
      }

      return var5;
   }

   int decode(CharacterWalker var1) {
      int var2 = var1.bytes[var1.next] & 255;
      ++var1.next;
      return var2;
   }

   void encode(CharacterBuffer var1, int var2) throws SQLException {
      need(var1, 1);
      if (var2 < 256) {
         var1.bytes[var1.next] = (byte)var2;
         ++var1.next;
      }

   }

   static byte[] charsToBytes(char[] var0, byte var1) throws SQLException {
      byte[] var2 = new byte[var0.length];

      for(int var3 = 0; var3 < var0.length; ++var3) {
         if (var0[var3] > 255) {
            var2[var3] = var1;
            if (var1 == 0) {
               failCharacterConversion(CharacterSet.make(31));
            }
         } else {
            var2[var3] = (byte)var0[var3];
         }
      }

      return var2;
   }
}
