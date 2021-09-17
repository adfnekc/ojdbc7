package oracle.jdbc.rowset;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.sql.Blob;
import java.sql.SQLException;
import oracle.jdbc.driver.DatabaseError;
import oracle.jdbc.internal.OracleConnection;

public class OracleSerialBlob implements Blob, Serializable, Cloneable {
   private byte[] buffer;
   private long length;
   private boolean isFreed = false;
   private static final String _Copyright_2007_Oracle_All_Rights_Reserved_ = null;
   public static final String BUILD_DATE = "Thu_Apr_04_15:09:24_PDT_2013";
   public static final boolean TRACE = false;

   public OracleSerialBlob(byte[] var1) throws SQLException {
      if (var1 == null) {
         SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 68);
         var3.fillInStackTrace();
         throw var3;
      } else {
         this.length = (long)var1.length;
         this.buffer = new byte[(int)this.length];

         for(int var2 = 0; (long)var2 < this.length; ++var2) {
            this.buffer[var2] = var1[var2];
         }

      }
   }

   public OracleSerialBlob(Blob var1) throws SQLException {
      if (var1 == null) {
         SQLException var17 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 68);
         var17.fillInStackTrace();
         throw var17;
      } else {
         this.length = var1.length();
         this.buffer = new byte[(int)this.length];
         BufferedInputStream var2 = new BufferedInputStream(var1.getBinaryStream());
         boolean var12 = false;

         SQLException var4;
         try {
            var12 = true;
            boolean var3 = false;
            int var19 = 0;

            while(true) {
               int var18 = var2.read(this.buffer, var19, (int)(this.length - (long)var19));
               var19 += var18;
               if (var18 <= 0) {
                  var12 = false;
                  break;
               }
            }
         } catch (IOException var15) {
            var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 346, var15.getMessage());
            var4.fillInStackTrace();
            throw var4;
         } finally {
            if (var12) {
               try {
                  if (var2 != null) {
                     var2.close();
                  }
               } catch (IOException var14) {
                  SQLException var7 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 346, var14.getMessage());
                  var7.fillInStackTrace();
                  throw var7;
               }

            }
         }

         try {
            if (var2 != null) {
               var2.close();
            }

         } catch (IOException var13) {
            var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 346, var13.getMessage());
            var4.fillInStackTrace();
            throw var4;
         }
      }
   }

   public InputStream getBinaryStream() throws SQLException {
      if (this.isFreed) {
         SQLException var1 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 192);
         var1.fillInStackTrace();
         throw var1;
      } else {
         return new ByteArrayInputStream(this.buffer);
      }
   }

   public byte[] getBytes(long var1, int var3) throws SQLException {
      SQLException var4;
      if (this.isFreed) {
         var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 192);
         var4.fillInStackTrace();
         throw var4;
      } else {
         var4 = null;
         --var1;
         if (var1 >= 0L && (long)var3 <= this.length && var1 + (long)var3 <= this.length) {
            byte[] var6 = new byte[var3];
            System.arraycopy(this.buffer, (int)var1, var6, 0, var3);
            return var6;
         } else {
            SQLException var5 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 68);
            var5.fillInStackTrace();
            throw var5;
         }
      }
   }

   public long length() throws SQLException {
      if (this.isFreed) {
         SQLException var1 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 192);
         var1.fillInStackTrace();
         throw var1;
      } else {
         return this.length;
      }
   }

   public long position(byte[] var1, long var2) throws SQLException {
      SQLException var12;
      if (this.isFreed) {
         var12 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 192);
         var12.fillInStackTrace();
         throw var12;
      } else if (var2 < 1L) {
         var12 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 68, "position()");
         var12.fillInStackTrace();
         throw var12;
      } else if (var2 <= this.length && var2 + (long)var1.length - 1L <= this.length) {
         int var4 = (int)(var2 - 1L);
         boolean var5 = false;

         for(long var6 = (long)var1.length; (long)var4 < this.length; ++var4) {
            int var8 = 0;
            long var9 = (long)(var4 + 1);
            int var11 = var4;

            while((long)var8 < var6 && (long)var11 < this.length && var1[var8] == this.buffer[var11]) {
               ++var8;
               ++var11;
               if ((long)var8 == var6) {
                  return var9;
               }
            }
         }

         return -1L;
      } else {
         return -1L;
      }
   }

   public long position(Blob var1, long var2) throws SQLException {
      if (this.isFreed) {
         SQLException var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 192);
         var4.fillInStackTrace();
         throw var4;
      } else {
         return this.position(var1.getBytes(1L, (int)var1.length()), var2);
      }
   }

   public int setBytes(long var1, byte[] var3) throws SQLException {
      SQLException var4;
      if (this.isFreed) {
         var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 192);
         var4.fillInStackTrace();
         throw var4;
      } else {
         var4 = DatabaseError.createUnsupportedFeatureSqlException();
         var4.fillInStackTrace();
         throw var4;
      }
   }

   public int setBytes(long var1, byte[] var3, int var4, int var5) throws SQLException {
      SQLException var6;
      if (this.isFreed) {
         var6 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 192);
         var6.fillInStackTrace();
         throw var6;
      } else {
         var6 = DatabaseError.createUnsupportedFeatureSqlException();
         var6.fillInStackTrace();
         throw var6;
      }
   }

   public OutputStream setBinaryStream(long var1) throws SQLException {
      SQLException var3;
      if (this.isFreed) {
         var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 192);
         var3.fillInStackTrace();
         throw var3;
      } else {
         var3 = DatabaseError.createUnsupportedFeatureSqlException();
         var3.fillInStackTrace();
         throw var3;
      }
   }

   public void truncate(long var1) throws SQLException {
      SQLException var3;
      if (this.isFreed) {
         var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 192);
         var3.fillInStackTrace();
         throw var3;
      } else {
         var3 = DatabaseError.createUnsupportedFeatureSqlException();
         var3.fillInStackTrace();
         throw var3;
      }
   }

   public void free() throws SQLException {
      if (!this.isFreed) {
         this.isFreed = true;
         this.buffer = null;
         this.length = 0L;
      }
   }

   public InputStream getBinaryStream(long var1, long var3) throws SQLException {
      SQLException var5;
      if (this.isFreed) {
         var5 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 192);
         var5.fillInStackTrace();
         throw var5;
      } else {
         --var1;
         if (var1 >= 0L && var1 + 1L <= this.length && var3 <= this.length && var1 <= 2147483647L && this.length <= 2147483647L && var1 + var3 <= this.length) {
            return new ByteArrayInputStream(this.buffer, (int)var1, (int)var3);
         } else {
            var5 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 68);
            var5.fillInStackTrace();
            throw var5;
         }
      }
   }

   protected OracleConnection getConnectionDuringExceptionHandling() {
      return null;
   }
}
