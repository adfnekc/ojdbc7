package oracle.jdbc.driver;

import java.sql.SQLException;

class T4CKvaldfList {
   static final int INTIAL_CAPACITY = 30;
   private int capacity;
   private int offset;
   private byte[][] keys;
   private byte[][] values;
   private byte[] flags;
   DBConversion conv;
   private static final String _Copyright_2007_Oracle_All_Rights_Reserved_ = null;
   public static final String BUILD_DATE = "Thu_Apr_04_15:09:24_PDT_2013";
   public static final boolean TRACE = false;

   T4CKvaldfList(DBConversion var1) {
      this.conv = var1;
      this.initializeList();
   }

   void initializeList() {
      this.capacity = 30;
      this.offset = 0;
      this.keys = new byte[this.capacity][];
      this.values = new byte[this.capacity][];
      this.flags = new byte[this.capacity];
   }

   void add(byte[] var1, byte[] var2, byte var3) {
      if (this.offset == this.capacity) {
         byte[][] var4 = new byte[this.capacity * 2][];
         byte[][] var5 = new byte[this.capacity * 2][];
         byte[] var6 = new byte[this.capacity * 2];
         System.arraycopy(this.keys, 0, var4, 0, this.capacity);
         System.arraycopy(this.values, 0, var5, 0, this.capacity);
         System.arraycopy(this.flags, 0, var6, 0, this.capacity);
         this.keys = var4;
         this.values = var5;
         this.flags = var6;
         this.capacity *= 2;
      }

      this.keys[this.offset] = var1;
      this.values[this.offset] = var2;
      this.flags[this.offset++] = var3;
   }

   void add(byte[] var1, byte[] var2) {
      this.add((byte[])var1, var2, (byte)0);
   }

   void add(String var1, byte[] var2) throws SQLException {
      this.add((byte[])this.conv.StringToCharBytes(var1), var2, (byte)0);
   }

   void add(String var1, byte[] var2, byte var3) throws SQLException {
      this.add(this.conv.StringToCharBytes(var1), var2, var3);
   }

   int size() {
      return this.offset;
   }

   byte[][] getKeys() {
      return this.keys;
   }

   byte[][] getValues() {
      return this.values;
   }

   byte[] getFlags() {
      return this.flags;
   }
}
