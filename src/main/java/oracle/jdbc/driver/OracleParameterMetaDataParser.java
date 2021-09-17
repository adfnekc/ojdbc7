package oracle.jdbc.driver;

import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;

public class OracleParameterMetaDataParser {
   static final int UNINITIALIZED = -1;
   static final String[] EMPTY_LIST = new String[0];
   String parameterSql;
   oracle.jdbc.internal.OracleStatement.SqlKind sqlKind;
   int parameterCount;
   boolean needToParseSql;
   private static final int cMax = 127;
   private static final int[][] TRANSITION;
   private static final int[][] ACTION;
   private static final int NO_ACTION = 0;
   private static final int WHERE_ACTION = 2;
   private static final int PARAMETER_ACTION = 3;
   private static final int END_PARAMETER_ACTION = 4;
   private static final int COUNT_BIND_ACTION = 5;
   private static final int START_NCHAR_LITERAL_ACTION = 6;
   private static final int END_NCHAR_LITERAL_ACTION = 7;
   private static final int SAVE_DELIMITER_ACTION = 8;
   private static final int LOOK_FOR_DELIMITER_ACTION = 9;
   private static final int RECORD_TABLE_NAME_ACTION = 10;
   private static final int END_RECORD_TABLE_NAME_ACTION = 11;
   private static final int DONE_RECORD_TABLE_NAME_ACTION = 12;
   private static final int START_RECORD_COLUMN_NAME_ACTION = 13;
   private static final int RECORD_COLUMN_NAME_ACTION = 14;
   private static final int END_RECORD_COLUMN_NAME_ACTION = 15;
   private static final int DONE_RECORD_COLUMN_NAME_ACTION = 16;
   private static final int NO_PARAMETER_METADATA_ACTION = 17;
   private static final int BEGIN_COMMENT_ACTION = 18;
   private static final int END_COMMENT_ACTION = 19;
   private static final int RESET_RECORDING_ACTION = 20;
   private static final int INITIAL_STATE = 0;
   private static final int RESTART_STATE = 22;
   private static final boolean DEBUG_CBI = false;
   ArrayList tableName;
   ArrayList columnName;
   byte[] bindStatusForInsert;
   char[] currentParameter;
   private static final String _Copyright_2007_Oracle_All_Rights_Reserved_;
   public static final String BUILD_DATE = "Thu_Apr_04_15:09:24_PDT_2013";
   public static final boolean TRACE = false;

   protected OracleParameterMetaDataParser() {
      this.sqlKind = oracle.jdbc.internal.OracleStatement.SqlKind.UNINITIALIZED;
      this.parameterCount = -1;
      this.tableName = new ArrayList();
      this.columnName = new ArrayList();
      this.bindStatusForInsert = null;
      this.currentParameter = null;
   }

   protected void initialize(String var1, oracle.jdbc.internal.OracleStatement.SqlKind var2, int var3) throws SQLException {
      if (var1 != null && var1.length() != 0) {
         this.sqlKind = var2;
         this.parameterSql = var1;
         this.parameterCount = var3;
         this.needToParseSql = true;
      } else {
         SQLException var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 104);
         var4.fillInStackTrace();
         throw var4;
      }
   }

   void computeBasicInfo(String var1) throws SQLException {
      int var2 = 0;
      boolean var3 = false;
      int var4 = 0;
      int var5 = 0;
      int var6 = var1.length();
      int var7 = var6 + 1;
      char[] var8 = new char[128];
      int var9 = 0;
      int var10 = 0;
      this.columnName.clear();
      this.tableName.clear();
      boolean var11 = false;
      boolean var12 = false;
      boolean var13 = false;
      int var14 = 0;
      int var15 = 0;
      boolean var16 = true;
      int var17 = -1;
      this.bindStatusForInsert = null;

      for(int var18 = 0; var18 < var7; ++var18) {
         char var19 = var18 < var6 ? var1.charAt(var18) : 32;
         char var20 = var19;
         if (var19 > 127) {
            if (Character.isLetterOrDigit(var19)) {
               var20 = 'X';
            } else {
               var20 = ' ';
            }
         }

         String var21;
         switch(ACTION[var5][var20]) {
         case 0:
         case 1:
         case 6:
         case 7:
         case 8:
         case 9:
         default:
            break;
         case 2:
            var9 -= 5;
            break;
         case 3:
            if (var10 > 0) {
               var21 = new String(var8, 0, var10);
               if (var21.trim().length() > 0) {
                  this.columnName.add(var21);
               }
            }

            var10 = 0;
            if (var4 == 0) {
               var14 = var18;
            }

            ++var4;
            var11 = true;
            break;
         case 5:
            if (var11) {
               if (this.bindStatusForInsert == null) {
                  int var26 = Math.max(50, var2 >> 1);
                  this.bindStatusForInsert = new byte[var26];
               } else if (var2 >= this.bindStatusForInsert.length) {
                  byte[] var27 = new byte[this.bindStatusForInsert.length << 1];
                  System.arraycopy(this.bindStatusForInsert, 0, var27, 0, this.bindStatusForInsert.length);
                  this.bindStatusForInsert = var27;
               }

               this.bindStatusForInsert[var2] = 1;
            }

            var15 = var18;
            ++var2;
            var11 = false;
         case 4:
            var11 = false;
            var4 = 0;
            break;
         case 10:
            var8[var9++] = var20;
            break;
         case 11:
            if (var9 > 0) {
               var21 = (new String(var8, 0, var9)).trim();
               if (var21.length() > 0) {
                  this.tableName.add(var21);
               }
            }

            var9 = 0;
            break;
         case 12:
            if (var9 > 0) {
               var21 = (new String(var8, 0, var9)).trim();
               if (var21.length() > 0) {
                  this.tableName.add(var21);
               }

               var9 = 0;
            }
            break;
         case 13:
            if (var9 > 0) {
               var21 = (new String(var8, 0, var9)).trim();
               if (var21.length() > 0) {
                  this.tableName.add(var21);
               }

               var9 = 0;
            }

            if (this.tableName.isEmpty()) {
               var16 = false;
            } else if (this.sqlKind != oracle.jdbc.internal.OracleStatement.SqlKind.INSERT) {
               byte var23 = 0;
               var10 = var23 + 1;
               var8[var23] = var20;
            }
            break;
         case 14:
            var8[var10++] = var20;
            break;
         case 15:
            if (var16) {
               if (var10 > 0) {
                  var21 = new String(var8, 0, var10);
                  if (var21.trim().length() > 0) {
                     this.columnName.add(var21);
                  }
               }

               var10 = 0;
            }
            break;
         case 16:
            if (var16) {
               if (var10 > 0) {
                  var21 = new String(var8, 0, var10);
                  if (var21.trim().length() > 0) {
                     this.columnName.add(var21);
                  }
               }

               var10 = 0;
            }
            break;
         case 17:
            var16 = false;
            break;
         case 18:
            var17 = var5;
            var5 = var20 == '/' ? 18 : 20;
            break;
         case 19:
            var5 = var17;
            var17 = -1;
            continue;
         case 20:
            var10 = 0;
            var9 = 0;
            var17 = 68;
         }

         var5 = TRANSITION[var5][var20];
      }

      if (var16) {
         if (this.sqlKind == oracle.jdbc.internal.OracleStatement.SqlKind.INSERT && var15 < var14) {
            if (this.bindStatusForInsert == null) {
               this.bindStatusForInsert = new byte[50];
            } else if (var2 >= this.bindStatusForInsert.length) {
               byte[] var25 = new byte[this.bindStatusForInsert.length << 1];
               System.arraycopy(this.bindStatusForInsert, 0, var25, 0, this.bindStatusForInsert.length);
               this.bindStatusForInsert = var25;
            }

            this.bindStatusForInsert[var2++] = 1;
         }
      } else {
         if (!this.tableName.isEmpty()) {
            this.tableName.clear();
         }

         if (!this.columnName.isEmpty()) {
            this.columnName.clear();
         }

         this.bindStatusForInsert = null;
         boolean var22 = true;
      }

      this.needToParseSql = false;
   }

   String[] getColumnNames() {
      String[] var1 = new String[this.columnName.size()];
      return (String[])this.columnName.toArray(var1);
   }

   String[] getTableNames() {
      String[] var1 = new String[this.tableName.size()];
      return (String[])this.tableName.toArray(var1);
   }

   public String getParameterMetaDataSql() throws SQLException {
      if (this.needToParseSql) {
         this.computeBasicInfo(this.parameterSql);
      }

      if (!this.sqlKind.isPlsqlOrCall() && this.parameterCount != 0) {
         String[] var1 = this.getTableNames();
         if (var1 != null && var1.length != 0) {
            String[] var2 = this.getColumnNames();
            StringBuilder var3 = new StringBuilder(100);
            var3.append("SELECT ");
            if (var2.length == 0) {
               if (this.sqlKind != oracle.jdbc.internal.OracleStatement.SqlKind.INSERT) {
                  return null;
               }

               var3.append("* ");
            } else {
               boolean var4 = this.bindStatusForInsert != null;
               int var5 = 0;

               for(int var6 = 0; var6 < var2.length; ++var6) {
                  if (!var4 || this.bindStatusForInsert[var6] == 1) {
                     if (var5++ != 0) {
                        var3.append(", ");
                     }

                     var3.append(var2[var6]);
                  }
               }
            }

            var3.append(" FROM ");

            for(int var7 = 0; var7 < var1.length; ++var7) {
               if (var7 != 0) {
                  var3.append(", ");
               }

               var3.append(var1[var7]);
            }

            return var3.substring(0, var3.length());
         } else {
            return null;
         }
      } else {
         return null;
      }
   }

   boolean needBindStatusForParameterMetaData() throws SQLException {
      return this.columnName.size() > 0 && this.parameterCount > 0 && this.bindStatusForInsert != null;
   }

   byte[] getBindStatusForInsert() {
      return this.bindStatusForInsert;
   }

   public static void main(String[] var0) {
      String[] var1 = null;
      if (var0.length < 1) {
         System.err.println("ERROR: incorrect usage. OracleParameterMetaDataParser <-test| sql >");
      } else {
         if ("-test".equals(var0[0])) {
            var1 = new String[]{"insert into JAVA_KEYWORDS (\"ABSTRACT\",\"ASSERT\",\"BOOLEAN\",\"BREAK\",\"BYTE\",\"CASE\",\"CATCH\",\"CHAR\",\"CLASS\",\"CONST \",\"CONTINUE\",\"DEFAULT\",\"DO\",\"DOUBLE\",\"ELSE\",\"ENUM \",\"EXTENDS\",\"FINAL\",\"FINALLY\",\"FLOAT\",\"FOR\",\"GOTO \",\"IF\",\"IMPLEMENTS\",\"IMPORT\",\"INSTANCEOF\",\"INT\",\"INTERFACE\",\"LONG\",\"NATIVE\",\"NEW\",\"PACKAGE\",\"PRIVATE\",\"PROTECTED\",\"PUBLIC\",\"RETU RN\",\"SHORT\",\"STATIC\",\"STRICTFP \",\"SUPER\",\"SWITCH\",\"SYNCHRONIZED\",\"THIS\",\"THROW\",\"THROWS\",\"TRANS IENT\",\"TRY\",\"VOID\",\"VOLATILE\",\"WHILE\", \"ID\") values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?  ,?,?,?,?,?,?,?,?,?,?,?,?)", "INSERT INTO emp(empno,ename,sal) VALUES(:B1, :b2, :b3)", "INSERT INTO T1 VALUES(:BIND1, :bind2)", "begin INSERT INTO T1 VALUES(:BIND1, :bind2); end;", "UPDATE T1 SET  C1 = :B1 and c2 = :b2 and c3 = 'abc'", "UPDATE T1 SET C1 = :B1 and  c2 = :b2 and c3 = 'abc'", "UPDATE T1 SET    C1 = :B1 and    c2 = :b2 and    c3 = 'abc' and c4 = :b4", "SELECT ename from emp where empno = :a1 and sal = :a2", "DELETE FROM EMP WHERE EMPNO>:x", "DELETE FROM EMP WHERE EMPNO   >   :1", "DELETE FROM EMP WHERE EMPNO\n>\n:2", "DELETE FROM EMP WHERE EMPNO\n<>\n:3", "DELETE FROM EMP WHERE EMPNO\n<>\n'abc'", "SELECT ename, d.deptno from emp e, dept d where empno = ?  and sal = ? and e.deptno = d.deptno", "SELECT ename, d.deptno from emp e, dept d where empno = :a1 and sal = :a2 and e.deptno = d.deptno", "SELECT ename, deptno   from    emp   , dept    where    empno =    :a1 and   sal = :a2", "SELECT * FROM TKPJST58_TAB WHERE C1 = :2", "SELECT * FROM TKPJST58_TAB WHERE C1 is null and c2 = :1 and c3 = :4", "SELECT * FROM TKPJST58_TAB WHERE C1 is NULL  AND C2 = :1   AND C3 = :2   AND C4 = :3   AND C5 = :4   AND C6 = :5   AND C7 = :6   AND C8 = :7   AND C9 = :8   AND C10 = :9   AND C11 = :10   AND C12 = :11   AND C13 = :12   AND C14 = :13   AND C15 = :14   AND C16 is not null  AND C17 <> :15", "SELECT * FROM TKPJST58_TAB WHERE C1 = ?  AND C2 = ?  AND C3 = ?  AND C4 = ?  AND C5 = ?  AND C6 = ?  AND C7 = ?  AND C8 = ?  AND C9 = ?  AND C10 = ?  AND C11 = ?  AND C12 = ?  AND C13 = ?  AND C14 = ?  AND C15 = ?  AND C16 = ?  AND C17 = ?", "INSERT INTO TKPJST58_TAB(c1, c2, c3, c4, c5, c9, c14, c10) values (?,?,?,?,?,?,?,?)", "INSERT INTO TKPJST58_TAB values (12,'abc',?,?,?,?,?,?)", "INSERT INTO TKPJST58_TAB values (12,'abc',:1,:2,:3,:4,:5)", "INSERT INTO TKPJST58_TAB(c1,c2,c3,c4,c5,c6,c7) values (12,'abc',:1,:2,:3,:4,:5)", "INSERT INTO TKPJST58_TAB(c1,c2,c3,c4,c5,c6,c7) values (12,'abc',:1,:2,55,:4,:5)", "insert into rawtab values ('010203040506', '0708090a0b0c0d')", "begin insert into asciitab values (200,'21-sep-71',?,?,?); end;", "select col from dummy_tab where rowid=?", "SELECT * FROM test2 WHERE key >= ? ORDER BY key", "SELECT * FROM test2 WHERE key>=? ORDER BY key", "INSERT INTO tkpjb2354325_tab VALUES (111, {ts '1999-12-31 12:59:59'})", "SELECT user FROM dual WHERE  ? < { fn LOCATE('TEST123TEST', 1) }", "INSERT INTO tkpjb2354325_tab VALUES (111, {ts '1999-12-31 12:59:59'}, :3)", "delete from tkpjdg02_view where id >? returning id, name into ?, ?", "SELECT * FROM TABLE( CAST(? AS TYPE_VARCHAR_NT) )", "insert into (select t.col1 as column1, t.col2 as column2 from tkpjsc37 t  where t.col1 in (?,?,?,?)) values ( ?, ?)", "delete from tkpjdg02_view where id >? returning_id = ?", "insert into tkpjir93_tab values (?,q'!name LIKE '%DBMS_%%'!')", "insert into tkpjir93_tab values (?,q'{SELECT * FROM employees WHERE last_name = 'Smith';}'", "insert into xml_test values ('adf', '<?xml version=\"1.0\" encoding=\"UTF-8\"?><a></a>')", "SELECT * FROM test2 WHERE key>=? and ORDER_id=?  order BY key", "insert into emp(empno, ename, sal) values (?, N'abc', ?)", "UPDATE tkpjb5752856_tab SET c2=N'????C Mother''s Maiden Name????'", "INSERT INTO TKPJST58_TAB(c1, c2, c3, c4, c5, c9, c14, c10) values (12,'abc',?,?,?,?,?,?)", "UPDATE /*abc*/T1 SET/*xyz*/ C1 = :B1 /*nyl*/and/*bac*/ c2 = :b2 and c3 = 'abc'", "SELECT * FROM TKPJST58_TAB WHERE C1 is/*abc*/ null and c2 = :1 and c3 = :4", "SELECT * FROM TKPJST58_TAB WHERE C1 is/*abc*/not--xyz\n null and c2 = :1 and c3 = :4", "UPDATE TKPJST58_TAB/*comment1*/set/*comment2*/ C1 = ?  WHERE  C4 = /*abc*/? ", "UPDATE TKPJST58_TAB set C1 = ?  and c2 = ? WHERE  C4 = /*abc*/? and c5 = ?"};
         } else {
            var1 = var0;
         }

         String[] var2 = var1;
         int var3 = var1.length;

         for(int var4 = 0; var4 < var3; ++var4) {
            String var5 = var2[var4];

            try {
               OracleSql var6 = new OracleSql((DBConversion)null);
               var6.initialize(var5);
               String var7 = var6.getSql(true, true);
               System.err.println("SQL:" + var7);
               System.err.println("  SqlKind:" + var6.sqlKind + ", Parameter Count=" + var6.parameterCount);
               if (!var6.sqlKind.isPlsqlOrCall() && var6.parameterCount > 0) {
                  OracleParameterMetaDataParser var8 = new OracleParameterMetaDataParser();
                  var8.initialize(var7, var6.sqlKind, var6.parameterCount);
                  System.err.println("  Parameter SQL: " + var8.getParameterMetaDataSql());
               } else {
                  System.err.println("  Cannot get Parameter MetaData");
               }

               System.err.println("\n");
            } catch (Exception var9) {
               System.out.println(var9);
               var9.printStackTrace();
            }
         }

      }
   }

   private static final void dumpTransitionMatrix(String var0) {
      try {
         PrintWriter var1 = new PrintWriter(var0);
         var1.print(",");

         for(int var2 = 0; var2 < 128; ++var2) {
            var1.print("'" + (var2 < 32 ? "0x" + Integer.toHexString(var2) : Character.toString((char)var2)) + (var2 < 127 ? "'," : "'"));
         }

         var1.println();
         int[][] var7 = OracleParameterMetaDataParserStates.TRANSITION;
         String[] var3 = OracleParameterMetaDataParserStates.PARSER_STATE_NAME;

         for(int var4 = 0; var4 < TRANSITION.length; ++var4) {
            var1.print(var3[var4] + ",");

            for(int var5 = 0; var5 < var7[var4].length; ++var5) {
               var1.print(var3[var7[var4][var5]] + (var5 < 127 ? "," : ""));
            }

            var1.println();
         }

         var1.close();
      } catch (Throwable var6) {
         System.err.println(var6);
      }

   }

   protected oracle.jdbc.internal.OracleConnection getConnectionDuringExceptionHandling() {
      return null;
   }

   static {
      TRANSITION = OracleParameterMetaDataParserStates.TRANSITION;
      ACTION = OracleParameterMetaDataParserStates.ACTION;
      _Copyright_2007_Oracle_All_Rights_Reserved_ = null;
   }
}
