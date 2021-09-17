package oracle.jdbc.driver;

import java.io.IOException;
import java.sql.SQLException;

class T4CInputStream extends OracleInputStream {
   private static final String _Copyright_2007_Oracle_All_Rights_Reserved_ = null;
   public static final String BUILD_DATE = "Thu_Apr_04_15:09:24_PDT_2013";
   public static final boolean TRACE = false;

   T4CInputStream(OracleStatement var1, int var2, Accessor var3) {
      super(var1, var2, var3);
   }

   public boolean isNull() throws IOException {
      if (!this.statement.isFetchStreams) {
         return super.isNull();
      } else {
         boolean var1 = false;

         try {
            int var2 = this.statement.currentResultSet.getRow();
            if (var2 < 0) {
               var2 = 0;
            }

            if (var2 >= this.statement.validRows) {
               return true;
            } else {
               var1 = this.statement.isNull(var2, this.columnIndex);
               return var1;
            }
         } catch (SQLException var4) {
            IOException var3 = DatabaseError.createIOException(var4);
            var3.fillInStackTrace();
            throw var3;
         }
      }
   }

   public int getBytes(int var1) throws IOException {
      synchronized(this.statement.connection) {
         int var3 = -1;

         try {
            if (this.statement.connection.lifecycle == 1 || this.statement.connection.lifecycle == 2) {
               var3 = this.accessor.readStream(this.resizableBuffer, this.initialBufferSize);
            }
         } catch (SQLException var8) {
            throw new IOException(var8.getMessage());
         } catch (IOException var9) {
            IOException var4 = var9;

            try {
               ((T4CConnection)this.statement.connection).handleIOException(var4);
            } catch (SQLException var7) {
            }

            throw var9;
         }

         return var3;
      }
   }
}
