package oracle.jdbc.rowset;

import java.io.BufferedReader;
import java.io.CharArrayReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Serializable;
import java.io.StringBufferInputStream;
import java.io.Writer;
import java.sql.Clob;
import java.sql.NClob;
import java.sql.SQLException;
import oracle.jdbc.driver.DatabaseError;
import oracle.jdbc.internal.OracleConnection;

public class OracleSerialClob implements Clob, NClob, Serializable, Cloneable {
   private static final int MAX_CHAR_BUFFER_SIZE = 1024;
   private char[] buffer;
   private long length;
   private boolean isFreed = false;
   private static final String _Copyright_2007_Oracle_All_Rights_Reserved_ = null;
   public static final String BUILD_DATE = "Thu_Apr_04_15:09:24_PDT_2013";
   public static final boolean TRACE = false;

   public OracleSerialClob(char[] var1) throws SQLException {
      if (var1 == null) {
         SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 68);
         var3.fillInStackTrace();
         throw var3;
      } else {
         this.length = (long)var1.length;
         this.buffer = new char[(int)this.length];

         for(int var2 = 0; (long)var2 < this.length; ++var2) {
            this.buffer[var2] = var1[var2];
         }

      }
   }

   public OracleSerialClob(Clob var1) throws SQLException {
      if (var1 == null) {
         SQLException var17 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 68);
         var17.fillInStackTrace();
         throw var17;
      } else {
         this.length = var1.length();
         this.buffer = new char[(int)this.length];
         BufferedReader var2 = new BufferedReader(var1.getCharacterStream());
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
            var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 347, var15.getMessage());
            var4.fillInStackTrace();
            throw var4;
         } finally {
            if (var12) {
               try {
                  if (var2 != null) {
                     var2.close();
                  }
               } catch (IOException var14) {
                  SQLException var7 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 347, var14.getMessage());
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
            var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 347, var13.getMessage());
            var4.fillInStackTrace();
            throw var4;
         }
      }
   }

   public OracleSerialClob(Reader var1) throws SQLException {
      if (var1 == null) {
         SQLException var7 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 68);
         var7.fillInStackTrace();
         throw var7;
      } else {
         try {
            boolean var2 = false;
            char[] var8 = new char[1024];
            StringBuilder var4 = new StringBuilder(1024);

            while(true) {
               int var6 = var1.read(var8);
               if (var6 == -1) {
                  var1.close();
                  this.buffer = var4.toString().toCharArray();
                  this.length = (long)this.buffer.length;
                  return;
               }

               var4.append(var8, 0, var6);
            }
         } catch (Exception var5) {
            SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 347, var5.getMessage());
            var3.fillInStackTrace();
            throw var3;
         }
      }
   }

   public OracleSerialClob(Reader var1, long var2) throws SQLException {
      if (var1 == null) {
         SQLException var11 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 68);
         var11.fillInStackTrace();
         throw var11;
      } else {
         try {
            boolean var4 = false;
            long var12 = var2;
            char[] var7 = new char[1024];

            StringBuilder var8;
            int var10;
            for(var8 = new StringBuilder(1024); var12 > 0L; var12 -= (long)var10) {
               var10 = var1.read(var7, 0, Math.min(1024, (int)var12));
               if (var10 == -1) {
                  break;
               }

               var8.append(var7, 0, var10);
            }

            var1.close();
            this.buffer = var8.toString().toCharArray();
            this.length = (long)this.buffer.length;
         } catch (Exception var9) {
            SQLException var5 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 347, var9.getMessage());
            var5.fillInStackTrace();
            throw var5;
         }
      }
   }

   public InputStream getAsciiStream() throws SQLException {
      if (this.isFreed) {
         SQLException var1 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 192);
         var1.fillInStackTrace();
         throw var1;
      } else {
         return new StringBufferInputStream(new String(this.buffer));
      }
   }

   public Reader getCharacterStream() throws SQLException {
      if (this.isFreed) {
         SQLException var1 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 192);
         var1.fillInStackTrace();
         throw var1;
      } else {
         return new CharArrayReader(this.buffer);
      }
   }

   public String getSubString(long var1, int var3) throws SQLException {
      SQLException var4;
      if (this.isFreed) {
         var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 192);
         var4.fillInStackTrace();
         throw var4;
      } else if (var1 >= 1L && var3 >= 0 && (long)var3 <= this.length && var1 + (long)var3 - 1L <= this.length) {
         return var3 == 0 ? new String() : new String(this.buffer, (int)var1 - 1, var3);
      } else {
         var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 68);
         var4.fillInStackTrace();
         throw var4;
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

   public long position(String var1, long var2) throws SQLException {
      SQLException var13;
      if (this.isFreed) {
         var13 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 192);
         var13.fillInStackTrace();
         throw var13;
      } else if (var2 < 1L) {
         var13 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 68, "position()");
         var13.fillInStackTrace();
         throw var13;
      } else if (var2 <= this.length && var2 + (long)var1.length() - 1L <= this.length) {
         char[] var4 = var1.toCharArray();
         int var5 = (int)(var2 - 1L);
         boolean var6 = false;

         for(long var7 = (long)var4.length; (long)var5 < this.length; ++var5) {
            int var9 = 0;
            long var10 = (long)(var5 + 1);
            int var12 = var5;

            while((long)var9 < var7 && (long)var12 < this.length && var4[var9] == this.buffer[var12]) {
               ++var9;
               ++var12;
               if ((long)var9 == var7) {
                  return var10;
               }
            }
         }

         return -1L;
      } else {
         return -1L;
      }
   }

   public long position(Clob var1, long var2) throws SQLException {
      if (this.isFreed) {
         SQLException var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 192);
         var4.fillInStackTrace();
         throw var4;
      } else {
         return this.position(var1.getSubString(1L, (int)var1.length()), var2);
      }
   }

   public int setString(long var1, String var3) throws SQLException {
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

   public int setString(long var1, String var3, int var4, int var5) throws SQLException {
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

   public OutputStream setAsciiStream(long var1) throws SQLException {
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

   public Writer setCharacterStream(long var1) throws SQLException {
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

   public Reader getCharacterStream(long var1, long var3) throws SQLException {
      SQLException var5;
      if (this.isFreed) {
         var5 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 192);
         var5.fillInStackTrace();
         throw var5;
      } else {
         --var1;
         if (var1 >= 0L && var1 + 1L <= this.length && var3 >= 0L && var3 <= this.length && var1 + var3 <= this.length) {
            return new CharArrayReader(this.buffer, (int)var1, (int)var3);
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
