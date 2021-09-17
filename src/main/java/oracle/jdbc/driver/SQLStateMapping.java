package oracle.jdbc.driver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.sql.SQLClientInfoException;
import java.sql.SQLDataException;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.SQLInvalidAuthorizationSpecException;
import java.sql.SQLNonTransientConnectionException;
import java.sql.SQLNonTransientException;
import java.sql.SQLRecoverableException;
import java.sql.SQLSyntaxErrorException;
import java.sql.SQLTimeoutException;
import java.sql.SQLTransactionRollbackException;
import java.sql.SQLTransientConnectionException;
import java.sql.SQLTransientException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

class SQLStateMapping {
   public static final int SQLEXCEPTION = 0;
   public static final int SQLNONTRANSIENTEXCEPTION = 1;
   public static final int SQLTRANSIENTEXCEPTION = 2;
   public static final int SQLDATAEXCEPTION = 3;
   public static final int SQLFEATURENOTSUPPORTEDEXCEPTION = 4;
   public static final int SQLINTEGRITYCONSTRAINTVIOLATIONEXCEPTION = 5;
   public static final int SQLINVALIDAUTHORIZATIONSPECEXCEPTION = 6;
   public static final int SQLNONTRANSIENTCONNECTIONEXCEPTION = 7;
   public static final int SQLSYNTAXERROREXCEPTION = 8;
   public static final int SQLTIMEOUTEXCEPTION = 9;
   public static final int SQLTRANSACTIONROLLBACKEXCEPTION = 10;
   public static final int SQLTRANSIENTCONNECTIONEXCEPTION = 11;
   public static final int SQLCLIENTINFOEXCEPTION = 12;
   public static final int SQLRECOVERABLEEXCEPTION = 13;
   int low;
   int high;
   public String sqlState;
   public int exception;
   static final String mappingResource = "errorMap.xml";
   static SQLStateMapping[] all;
   private static final int NUMEBER_OF_MAPPINGS_IN_ERRORMAP_XML = 128;
   private static final String _Copyright_2007_Oracle_All_Rights_Reserved_ = null;
   public static final String BUILD_DATE = "Thu_Apr_04_15:09:24_PDT_2013";
   public static final boolean TRACE = false;

   public SQLStateMapping(int var1, int var2, String var3, int var4) {
      this.low = var1;
      this.sqlState = var3;
      this.exception = var4;
      this.high = var2;
   }

   public boolean isIncluded(int var1) {
      return this.low <= var1 && var1 <= this.high;
   }

   public SQLException newSQLException(String var1, int var2) {
      switch(this.exception) {
      case 0:
         return new SQLException(var1, this.sqlState, var2);
      case 1:
         return new SQLNonTransientException(var1, this.sqlState, var2);
      case 2:
         return new SQLTransientException(var1, this.sqlState, var2);
      case 3:
         return new SQLDataException(var1, this.sqlState, var2);
      case 4:
         return new SQLFeatureNotSupportedException(var1, this.sqlState, var2);
      case 5:
         return new SQLIntegrityConstraintViolationException(var1, this.sqlState, var2);
      case 6:
         return new SQLInvalidAuthorizationSpecException(var1, this.sqlState, var2);
      case 7:
         return new SQLNonTransientConnectionException(var1, this.sqlState, var2);
      case 8:
         return new SQLSyntaxErrorException(var1, this.sqlState, var2);
      case 9:
         return new SQLTimeoutException(var1, this.sqlState, var2);
      case 10:
         return new SQLTransactionRollbackException(var1, this.sqlState, var2);
      case 11:
         return new SQLTransientConnectionException(var1, this.sqlState, var2);
      case 12:
         return new SQLClientInfoException(var1, this.sqlState, var2, (Map)null);
      case 13:
         return new SQLRecoverableException(var1, this.sqlState, var2);
      default:
         return new SQLException(var1, this.sqlState, var2);
      }
   }

   boolean lessThan(SQLStateMapping var1) {
      if (this.low < var1.low) {
         return this.high < var1.high;
      } else {
         return this.high <= var1.high;
      }
   }

   public String toString() {
      return super.toString() + "(" + this.low + ", " + this.high + ", " + this.sqlState + ", " + this.exception + ")";
   }

   public static void main(String[] var0) throws IOException {
      SQLStateMapping[] var1 = doGetMappings();
      System.out.println("a\t" + var1);

      for(int var2 = 0; var2 < var1.length; ++var2) {
         System.out.println("low:\t" + var1[var2].low + "\thigh:\t" + var1[var2].high + "\tsqlState:\t" + var1[var2].sqlState + "\tsqlException:\t" + var1[var2].exception);
      }

   }

   static SQLStateMapping[] getMappings() {
      if (all == null) {
         try {
            all = doGetMappings();
         } catch (Throwable var1) {
            all = new SQLStateMapping[0];
         }
      }

      return all;
   }

   static SQLStateMapping[] doGetMappings() throws IOException {
      InputStream var0 = SQLStateMapping.class.getResourceAsStream("errorMap.xml");
      ArrayList var1 = new ArrayList(128);
      load(var0, var1);
      return (SQLStateMapping[])((SQLStateMapping[])var1.toArray(new SQLStateMapping[0]));
   }

   static void load(InputStream var0, List var1) throws IOException {
      BufferedReader var2 = new BufferedReader(new InputStreamReader(var0));
      SQLStateMapping.Tokenizer var3 = new SQLStateMapping.Tokenizer(var2);
      int var4 = -1;
      int var5 = -1;
      String var6 = null;
      int var7 = -1;
      String var8 = null;
      byte var9 = 0;

      String var10;
      while((var10 = var3.next()) != null) {
         switch(var9) {
         case 0:
            if (var10.equals("<")) {
               var9 = 1;
            }
            break;
         case 1:
            if (var10.equals("!")) {
               var9 = 2;
            } else {
               if (!var10.equals("oraErrorSqlStateSqlExceptionMapping")) {
                  throw new IOException("Unexpected token \"" + var10 + "\" at line " + var3.lineno + " of errorMap.xml. Expected \"oraErrorSqlStateSqlExceptionMapping\".");
               }

               var9 = 6;
            }
            break;
         case 2:
            if (!var10.equals("-")) {
               throw new IOException("Unexpected token \"" + var10 + "\" at line " + var3.lineno + " of errorMap.xml. Expected \"-\".");
            }

            var9 = 3;
            break;
         case 3:
            if (var10.equals("-")) {
               var9 = 4;
            }
            break;
         case 4:
            if (var10.equals("-")) {
               var9 = 5;
            } else {
               var9 = 3;
            }
            break;
         case 5:
            if (!var10.equals(">")) {
               throw new IOException("Unexpected token \"" + var10 + "\" at line " + var3.lineno + " of errorMap.xml. Expected \">\".");
            }

            var9 = 0;
            break;
         case 6:
            if (!var10.equals(">")) {
               throw new IOException("Unexpected token \"" + var10 + "\" at line " + var3.lineno + " of errorMap.xml. Expected \">\".");
            }

            var9 = 7;
            break;
         case 7:
            if (!var10.equals("<")) {
               throw new IOException("Unexpected token \"" + var10 + "\" at line " + var3.lineno + " of errorMap.xml. Expected \"<\".");
            }

            var9 = 8;
            break;
         case 8:
            if (var10.equals("!")) {
               var9 = 9;
            } else if (var10.equals("error")) {
               var9 = 14;
            } else {
               if (!var10.equals("/")) {
                  throw new IOException("Unexpected token \"" + var10 + "\" at line " + var3.lineno + " of errorMap.xml. Expected one of \"!--\", \"error\", \"/\".");
               }

               var9 = 16;
            }
            break;
         case 9:
            if (!var10.equals("-")) {
               throw new IOException("Unexpected token \"" + var10 + "\" at line " + var3.lineno + " of errorMap.xml. Expected \"-\".");
            }

            var9 = 10;
            break;
         case 10:
            if (!var10.equals("-")) {
               throw new IOException("Unexpected token \"" + var10 + "\" at line " + var3.lineno + " of errorMap.xml. Expected \"-\".");
            }

            var9 = 11;
            break;
         case 11:
            if (var10.equals("-")) {
               var9 = 12;
            }
            break;
         case 12:
            if (var10.equals("-")) {
               var9 = 13;
            } else {
               var9 = 11;
            }
            break;
         case 13:
            if (!var10.equals(">")) {
               throw new IOException("Unexpected token \"" + var10 + "\" at line " + var3.lineno + " of errorMap.xml. Expected \">\".");
            }

            var9 = 7;
            break;
         case 14:
            if (var10.equals("/")) {
               var9 = 15;
            } else if (var10.equals("oraErrorFrom")) {
               var9 = 19;
            } else if (var10.equals("oraErrorTo")) {
               var9 = 21;
            } else if (var10.equals("sqlState")) {
               var9 = 23;
            } else if (var10.equals("sqlException")) {
               var9 = 25;
            } else {
               if (!var10.equals("comment")) {
                  throw new IOException("Unexpected token \"" + var10 + "\" at line " + var3.lineno + " of errorMap.xml. Expected one of " + "\"oraErrorFrom\", \"oraErrorTo\", \"sqlState\", " + "\"sqlException\", \"comment\", \"/\".");
               }

               var9 = 27;
            }
            break;
         case 15:
            if (!var10.equals(">")) {
               throw new IOException("Unexpected token \"" + var10 + "\" at line " + var3.lineno + " of errorMap.xml. Expected \">\".");
            }

            try {
               createOne(var1, var4, var5, var6, var7, var8);
            } catch (IOException var15) {
               throw new IOException("Invalid error element at line " + var3.lineno + " of errorMap.xml. " + var15.getMessage());
            }

            var4 = -1;
            var5 = -1;
            var6 = null;
            var7 = -1;
            var8 = null;
            var9 = 7;
            break;
         case 16:
            if (!var10.equals("oraErrorSqlStateSqlExceptionMapping")) {
               throw new IOException("Unexpected token \"" + var10 + "\" at line " + var3.lineno + " of errorMap.xml. Expected \"oraErrorSqlStateSqlExceptionMapping\".");
            }

            var9 = 17;
            break;
         case 17:
            if (!var10.equals(">")) {
               throw new IOException("Unexpected token \"" + var10 + "\" at line " + var3.lineno + " of errorMap.xml. Expected \">\".");
            }

            var9 = 18;
         case 18:
            break;
         case 19:
            if (!var10.equals("=")) {
               throw new IOException("Unexpected token \"" + var10 + "\" at line " + var3.lineno + " of errorMap.xml. Expected \"=\".");
            }

            var9 = 20;
            break;
         case 20:
            try {
               var4 = Integer.parseInt(var10);
            } catch (NumberFormatException var14) {
               throw new IOException("Unexpected value \"" + var10 + "\" at line " + var3.lineno + " of errorMap.xml. Expected an integer.");
            }

            var9 = 14;
            break;
         case 21:
            if (!var10.equals("=")) {
               throw new IOException("Unexpected token \"" + var10 + "\" at line " + var3.lineno + " of errorMap.xml. Expected \"=\".");
            }

            var9 = 22;
            break;
         case 22:
            try {
               var5 = Integer.parseInt(var10);
            } catch (NumberFormatException var13) {
               throw new IOException("Unexpected value \"" + var10 + "\" at line " + var3.lineno + " of errorMap.xml. Expected an integer.");
            }

            var9 = 14;
            break;
         case 23:
            if (!var10.equals("=")) {
               throw new IOException("Unexpected token \"" + var10 + "\" at line " + var3.lineno + " of errorMap.xml. Expected \"=\".");
            }

            var9 = 24;
            break;
         case 24:
            var6 = var10;
            var9 = 14;
            break;
         case 25:
            if (!var10.equals("=")) {
               throw new IOException("Unexpected token \"" + var10 + "\" at line " + var3.lineno + " of errorMap.xml. Expected \"=\".");
            }

            var9 = 26;
            break;
         case 26:
            try {
               var7 = valueOf(var10);
            } catch (Exception var12) {
               throw new IOException("Unexpected token \"" + var10 + "\" at line " + var3.lineno + " of errorMap.xml. Expected SQLException" + " subclass name.");
            }

            var9 = 14;
            break;
         case 27:
            if (!var10.equals("=")) {
               throw new IOException("Unexpected token \"" + var10 + "\" at line " + var3.lineno + " of errorMap.xml. Expected \"=\".");
            }

            var9 = 28;
            break;
         case 28:
            var8 = var10;
            var9 = 14;
            break;
         default:
            throw new IOException("Unknown parser state " + var9 + " at line " + var3.lineno + " of errorMap.xml.");
         }
      }

   }

   private static void createOne(List var0, int var1, int var2, String var3, int var4, String var5) throws IOException {
      if (var1 == -1) {
         throw new IOException("oraErrorFrom is a required attribute");
      } else {
         if (var2 == -1) {
            var2 = var1;
         }

         if (var3 != null && var3.length() != 0) {
            if (var4 == -1) {
               throw new IOException("sqlException is a required attribute");
            } else if (var5 != null && var5.length() >= 8) {
               SQLStateMapping var6 = new SQLStateMapping(var1, var2, var3, var4);
               add(var0, var6);
            } else {
               throw new IOException("a lengthy comment in required");
            }
         } else {
            throw new IOException("sqlState is a required attribute");
         }
      }
   }

   static void add(List var0, SQLStateMapping var1) {
      int var2;
      for(var2 = var0.size(); var2 > 0 && !((SQLStateMapping)var0.get(var2 - 1)).lessThan(var1); --var2) {
      }

      var0.add(var2, var1);
   }

   static int valueOf(String var0) throws Exception {
      if (var0.equalsIgnoreCase("SQLEXCEPTION")) {
         return 0;
      } else if (var0.equalsIgnoreCase("SQLNONTRANSIENTEXCEPTION")) {
         return 1;
      } else if (var0.equalsIgnoreCase("SQLTRANSIENTEXCEPTION")) {
         return 2;
      } else if (var0.equalsIgnoreCase("SQLDATAEXCEPTION")) {
         return 3;
      } else if (var0.equalsIgnoreCase("SQLFEATURENOTSUPPORTEDEXCEPTION")) {
         return 4;
      } else if (var0.equalsIgnoreCase("SQLINTEGRITYCONSTRAINTVIOLATIONEXCEPTION")) {
         return 5;
      } else if (var0.equalsIgnoreCase("SQLINVALIDAUTHORIZATIONSPECEXCEPTION")) {
         return 6;
      } else if (var0.equalsIgnoreCase("SQLNONTRANSIENTCONNECTIONEXCEPTION")) {
         return 7;
      } else if (var0.equalsIgnoreCase("SQLSYNTAXERROREXCEPTION")) {
         return 8;
      } else if (var0.equalsIgnoreCase("SQLTIMEOUTEXCEPTION")) {
         return 9;
      } else if (var0.equalsIgnoreCase("SQLTRANSACTIONROLLBACKEXCEPTION")) {
         return 10;
      } else if (var0.equalsIgnoreCase("SQLTRANSIENTCONNECTIONEXCEPTION")) {
         return 11;
      } else if (var0.equalsIgnoreCase("SQLCLIENTINFOEXCEPTION")) {
         return 12;
      } else if (var0.equalsIgnoreCase("SQLRECOVERABLEEXCEPTION")) {
         return 13;
      } else {
         throw new Exception("unexpected exception name: " + var0);
      }
   }

   private static final class Tokenizer {
      int lineno = 1;
      Reader r;
      int c;

      Tokenizer(Reader var1) throws IOException {
         this.r = var1;
         this.c = var1.read();
      }

      String next() throws IOException {
         StringBuffer var1 = new StringBuffer(16);

         for(boolean var2 = true; this.c != -1; this.c = this.r.read()) {
            if (this.c == 10) {
               ++this.lineno;
            }

            if (this.c > 32 || !var2) {
               if (this.c <= 32 && !var2) {
                  this.c = this.r.read();
                  break;
               }

               if (this.c != 34) {
                  if (48 <= this.c && this.c <= 57 || 65 <= this.c && this.c <= 90 || 97 <= this.c && this.c <= 122 || this.c == 95) {
                     do {
                        do {
                           do {
                              do {
                                 var1.append((char)this.c);
                              } while(48 <= (this.c = this.r.read()) && this.c <= 57);
                           } while(65 <= this.c && this.c <= 90);
                        } while(97 <= this.c && this.c <= 122);
                     } while(this.c == 95);

                     return var1.length() > 0 ? var1.toString() : null;
                  }

                  var1.append((char)this.c);
                  this.c = this.r.read();
                  break;
               }

               while((this.c = this.r.read()) != 34) {
                  var1.append((char)this.c);
               }

               this.c = this.r.read();
               break;
            }
         }

         return var1.length() > 0 ? var1.toString() : null;
      }
   }
}
