package oracle.jdbc.driver;

import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;

class OracleConversionInputStreamInternal extends OracleConversionInputStream {
   boolean needReset = false;
   private static final String _Copyright_2007_Oracle_All_Rights_Reserved_ = null;
   public static final String BUILD_DATE = "Thu_Apr_04_15:09:24_PDT_2013";
   public static final boolean TRACE = false;

   public OracleConversionInputStreamInternal(DBConversion var1, InputStream var2, int var3, int var4) {
      super(var1, var2, var3, var4);
   }

   public OracleConversionInputStreamInternal(DBConversion var1, Reader var2, int var3, int var4, short var5) {
      super(var1, var2, var3, var4, var5);
   }

   public int read(byte[] var1, int var2, int var3) throws IOException {
      if (this.needReset) {
         if (this.istream != null && this.istream.markSupported()) {
            this.istream.reset();
            this.endOfStream = false;
            this.totalSize = 0;
            this.needReset = false;
         } else if (this.reader != null && this.reader.markSupported()) {
            this.reader.reset();
            this.endOfStream = false;
            this.totalSize = 0;
            this.needReset = false;
         }
      }

      int var4 = super.read(var1, var2, var3);
      if (var4 == -1) {
         this.needReset = true;
      }

      return var4;
   }
}
