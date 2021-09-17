package oracle.jdbc.rowset;

import java.io.InputStream;
import java.io.Reader;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.StringTokenizer;
import javax.sql.RowSet;
import javax.sql.RowSetInternal;
import javax.sql.RowSetWriter;
import oracle.jdbc.OraclePreparedStatement;
import oracle.jdbc.driver.DatabaseError;
import oracle.jdbc.internal.OracleConnection;

public class OracleCachedRowSetWriter implements RowSetWriter, Serializable {
   static final long serialVersionUID = 8932894189919931169L;
   private StringBuffer updateClause = new StringBuffer("");
   private StringBuffer deleteClause = new StringBuffer("");
   private StringBuffer insertClause = new StringBuffer("");
   private PreparedStatement insertStmt;
   private PreparedStatement updateStmt;
   private PreparedStatement deleteStmt;
   private ResultSetMetaData rsmd;
   private transient Connection connection;
   private int columnCount;
   static final int ASCII_STREAM = 1;
   static final int BINARY_STREAM = 2;
   static final int CHARACTER_STREAM = 3;
   static final int NCHARACTER_STREAM = 4;
   static final int ASCII_STREAM_LENGTH_UNSPECIFIED = 5;
   static final int BINARY_STREAM_LENGTH_UNSPECIFIED = 6;
   static final int CHARACTER_STREAM_LENGTH_UNSPECIFIED = 7;
   static final int NCHARACTER_STREAM_LENGTH_UNSPECIFIED = 8;
   private static final String _Copyright_2007_Oracle_All_Rights_Reserved_ = null;
   public static final String BUILD_DATE = "Thu_Apr_04_15:09:24_PDT_2013";
   public static final boolean TRACE = false;

   private String getSchemaName(RowSet var1) throws SQLException {
      return var1.getUsername();
   }

   private String getTableName(RowSet var1) throws SQLException {
      String var2 = ((OracleCachedRowSet)var1).getTableName();
      if (var2 != null) {
         return var2;
      } else {
         String var3 = var1.getCommand();
         if (var3 == null) {
            SQLException var7 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 343, "Please use RowSet.setCommand (String) to set the SQL query string.");
            var7.fillInStackTrace();
            throw var7;
         } else {
            var3 = var3.toUpperCase();
            int var4 = var3.indexOf(" FROM ");
            if (var4 == -1) {
               SQLException var8 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 343, var3.length() != 0 ? var3 : "Please use RowSet.setCommand (String) to set the SQL query string.");
               var8.fillInStackTrace();
               throw var8;
            } else {
               String var5 = var3.substring(var4 + 6).trim();
               StringTokenizer var6 = new StringTokenizer(var5);
               if (var6.hasMoreTokens()) {
                  var5 = var6.nextToken();
               }

               return var5;
            }
         }
      }
   }

   private void initSQLStatement(RowSet var1) throws SQLException {
      this.insertClause = new StringBuffer("INSERT INTO " + this.getTableName(var1) + "(");
      this.updateClause = new StringBuffer("UPDATE " + this.getTableName(var1) + " SET ");
      this.deleteClause = new StringBuffer("DELETE FROM " + this.getTableName(var1) + " WHERE ");
      this.rsmd = var1.getMetaData();
      this.columnCount = this.rsmd.getColumnCount();

      int var2;
      for(var2 = 0; var2 < this.columnCount; ++var2) {
         if (var2 != 0) {
            this.insertClause.append(", ");
         }

         this.insertClause.append(this.rsmd.getColumnName(var2 + 1));
         if (var2 != 0) {
            this.updateClause.append(", ");
         }

         this.updateClause.append(this.rsmd.getColumnName(var2 + 1) + " = :" + var2);
         if (var2 != 0) {
            this.deleteClause.append(" AND ");
         }

         this.deleteClause.append(this.rsmd.getColumnName(var2 + 1) + " = :" + var2);
      }

      this.insertClause.append(") VALUES (");
      this.updateClause.append(" WHERE ");

      for(var2 = 0; var2 < this.columnCount; ++var2) {
         if (var2 != 0) {
            this.insertClause.append(", ");
         }

         this.insertClause.append(":" + var2);
         if (var2 != 0) {
            this.updateClause.append(" AND ");
         }

         this.updateClause.append(this.rsmd.getColumnName(var2 + 1) + " = :" + var2);
      }

      this.insertClause.append(")");
      this.insertStmt = this.connection.prepareStatement(this.insertClause.substring(0, this.insertClause.length()));
      this.updateStmt = this.connection.prepareStatement(this.updateClause.substring(0, this.updateClause.length()));
      this.deleteStmt = this.connection.prepareStatement(this.deleteClause.substring(0, this.deleteClause.length()));
   }

   private boolean insertRow(OracleRow var1) throws SQLException {
      this.insertStmt.clearParameters();

      for(int var2 = 1; var2 <= this.columnCount; ++var2) {
         Object var3 = null;
         var3 = var1.isColumnChanged(var2) ? var1.getModifiedColumn(var2) : var1.getColumn(var2);
         if (var3 == null) {
            this.insertStmt.setNull(var2, this.rsmd.getColumnType(var2));
            var1.markOriginalNull(var2, true);
         } else {
            this.insertStmt.setObject(var2, var3);
         }
      }

      return this.insertStmt.executeUpdate() == 1;
   }

   private boolean updateRow(RowSet var1, OracleRow var2) throws SQLException {
      for(int var3 = 1; var3 <= this.columnCount; ++var3) {
         if (var2.isOriginalNull(var3)) {
            return this.updateRowWithNull(var1, var2);
         }
      }

      return this.updateRowNoNulls(var1, var2);
   }

   private boolean updateRowNoNulls(RowSet var1, OracleRow var2) throws SQLException {
      this.updateStmt.clearParameters();

      int var3;
      for(var3 = 1; var3 <= this.columnCount; ++var3) {
         Object var4 = null;
         var4 = var2.isColumnChanged(var3) ? var2.getModifiedColumn(var3) : var2.getColumn(var3);
         if (var4 == null) {
            this.updateStmt.setNull(var3, this.rsmd.getColumnType(var3));
         } else if (var4 instanceof Reader) {
            boolean var5 = false;
            OraclePreparedStatement var6 = (OraclePreparedStatement)this.updateStmt;
            if (var2.columnTypeInfo[var3 - 1][1] == 4L) {
               var6.setFormOfUse(var3, (short)2);
            } else if (var2.columnTypeInfo[var3 - 1][1] == 3L) {
               var6.setFormOfUse(var3, (short)1);
            } else if (var2.columnTypeInfo[var3 - 1][1] == 8L) {
               var5 = true;
               var6.setFormOfUse(var3, (short)2);
            } else if (var2.columnTypeInfo[var3 - 1][1] == 7L) {
               var5 = true;
               var6.setFormOfUse(var3, (short)1);
            }

            if (var5) {
               this.updateStmt.setCharacterStream(var3, (Reader)var4);
            } else {
               this.updateStmt.setCharacterStream(var3, (Reader)var4, var2.columnTypeInfo[var3 - 1][0]);
            }
         } else if (var4 instanceof InputStream) {
            if (var2.columnTypeInfo[var3 - 1][1] == 2L) {
               this.updateStmt.setBinaryStream(var3, (InputStream)var4, var2.columnTypeInfo[var3 - 1][0]);
            } else if (var2.columnTypeInfo[var3 - 1][1] == 6L) {
               this.updateStmt.setBinaryStream(var3, (InputStream)var4);
            } else if (var2.columnTypeInfo[var3 - 1][1] == 1L) {
               this.updateStmt.setAsciiStream(var3, (InputStream)var4, var2.columnTypeInfo[var3 - 1][0]);
            } else if (var2.columnTypeInfo[var3 - 1][1] == 5L) {
               this.updateStmt.setAsciiStream(var3, (InputStream)var4);
            }
         } else {
            this.updateStmt.setObject(var3, var4);
         }
      }

      for(var3 = 1; var3 <= this.columnCount; ++var3) {
         this.updateStmt.setObject(var3 + this.columnCount, var2.getColumn(var3));
      }

      return this.updateStmt.executeUpdate() == 1;
   }

   private boolean updateRowWithNull(RowSet var1, OracleRow var2) throws SQLException {
      boolean var3 = false;
      StringBuffer var4 = new StringBuffer("UPDATE " + this.getTableName(var1) + " SET ");

      int var5;
      for(var5 = 1; var5 <= this.columnCount; ++var5) {
         if (var5 != 1) {
            var4.append(", ");
         }

         var4.append(this.rsmd.getColumnName(var5) + " = :" + var5);
      }

      var4.append(" WHERE ");

      for(var5 = 1; var5 <= this.columnCount; ++var5) {
         if (var5 != 1) {
            var4.append(" AND ");
         }

         if (var2.isOriginalNull(var5)) {
            var4.append(this.rsmd.getColumnName(var5) + " IS NULL ");
         } else {
            var4.append(this.rsmd.getColumnName(var5) + " = :" + var5);
         }
      }

      PreparedStatement var13 = null;

      try {
         var13 = this.connection.prepareStatement(var4.substring(0, var4.length()));

         int var6;
         for(var6 = 1; var6 <= this.columnCount; ++var6) {
            Object var7 = null;
            var7 = var2.isColumnChanged(var6) ? var2.getModifiedColumn(var6) : var2.getColumn(var6);
            if (var7 == null) {
               var13.setNull(var6, this.rsmd.getColumnType(var6));
            } else if (var7 instanceof Reader) {
               boolean var8 = false;
               OraclePreparedStatement var9 = (OraclePreparedStatement)var13;
               if (var2.columnTypeInfo[var6 - 1][1] == 4L) {
                  var9.setFormOfUse(var6, (short)2);
               } else if (var2.columnTypeInfo[var6 - 1][1] == 3L) {
                  var9.setFormOfUse(var6, (short)1);
               } else if (var2.columnTypeInfo[var6 - 1][1] == 8L) {
                  var8 = true;
                  var9.setFormOfUse(var6, (short)2);
               } else if (var2.columnTypeInfo[var6 - 1][1] == 7L) {
                  var8 = true;
                  var9.setFormOfUse(var6, (short)1);
               }

               if (var8) {
                  var13.setCharacterStream(var6, (Reader)var7);
               } else {
                  var13.setCharacterStream(var6, (Reader)var7, var2.columnTypeInfo[var6 - 1][0]);
               }
            } else if (var7 instanceof InputStream) {
               if (var2.columnTypeInfo[var6 - 1][1] == 2L) {
                  var13.setBinaryStream(var6, (InputStream)var7, var2.columnTypeInfo[var6 - 1][0]);
               } else if (var2.columnTypeInfo[var6 - 1][1] == 6L) {
                  var13.setBinaryStream(var6, (InputStream)var7);
               } else if (var2.columnTypeInfo[var6 - 1][1] == 1L) {
                  var13.setAsciiStream(var6, (InputStream)var7, var2.columnTypeInfo[var6 - 1][0]);
               } else if (var2.columnTypeInfo[var6 - 1][1] == 5L) {
                  var13.setAsciiStream(var6, (InputStream)var7);
               }
            } else {
               var13.setObject(var6, var7);
            }
         }

         var6 = 1;

         for(int var14 = 1; var6 <= this.columnCount; ++var6) {
            if (!var2.isOriginalNull(var6)) {
               var13.setObject(var14 + this.columnCount, var2.getColumn(var6));
               ++var14;
            }
         }

         var3 = var13.executeUpdate() == 1;
      } finally {
         if (var13 != null) {
            var13.close();
         }

      }

      return var3;
   }

   private boolean deleteRow(RowSet var1, OracleRow var2) throws SQLException {
      this.deleteStmt.clearParameters();

      for(int var3 = 1; var3 <= this.columnCount; ++var3) {
         if (var2.isOriginalNull(var3)) {
            return this.deleteRowWithNull(var1, var2);
         }

         Object var4 = var2.getColumn(var3);
         if (var4 == null) {
            this.deleteStmt.setNull(var3, this.rsmd.getColumnType(var3));
         } else {
            this.deleteStmt.setObject(var3, var4);
         }
      }

      return this.deleteStmt.executeUpdate() == 1;
   }

   private boolean deleteRowWithNull(RowSet var1, OracleRow var2) throws SQLException {
      boolean var3 = false;
      StringBuffer var4 = new StringBuffer("DELETE FROM " + this.getTableName(var1) + " WHERE ");

      for(int var5 = 1; var5 <= this.columnCount; ++var5) {
         if (var5 != 1) {
            var4.append(" AND ");
         }

         if (var2.isOriginalNull(var5)) {
            var4.append(this.rsmd.getColumnName(var5) + " IS NULL ");
         } else {
            var4.append(this.rsmd.getColumnName(var5) + " = :" + var5);
         }
      }

      PreparedStatement var11 = null;

      try {
         var11 = this.connection.prepareStatement(var4.substring(0, var4.length()));
         int var6 = 1;

         for(int var7 = 1; var6 <= this.columnCount; ++var6) {
            if (!var2.isOriginalNull(var6)) {
               var11.setObject(var7++, var2.getColumn(var6));
            }
         }

         var3 = var11.executeUpdate() == 1;
      } finally {
         if (var11 != null) {
            var11.close();
         }

      }

      return var3;
   }

   public synchronized boolean writeData(RowSetInternal var1) throws SQLException {
      OracleCachedRowSet var2 = (OracleCachedRowSet)var1;
      this.connection = ((OracleCachedRowSetReader)var2.getReader()).getConnection(var1);
      if (this.connection == null) {
         SQLException var9 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 342);
         var9.fillInStackTrace();
         throw var9;
      } else {
         if (this.connection.getAutoCommit()) {
            this.connection.setAutoCommit(false);
         }

         try {
            this.connection.setTransactionIsolation(var2.getTransactionIsolation());
         } catch (Exception var8) {
         }

         this.initSQLStatement(var2);
         if (this.columnCount < 1) {
            this.connection.close();
            return true;
         } else {
            boolean var3 = var2.getShowDeleted();
            var2.setShowDeleted(true);
            var2.beforeFirst();
            boolean var4 = true;
            boolean var5 = true;
            boolean var6 = true;
            OracleRow var7 = null;

            while(true) {
               label84:
               do {
                  while(var2.next()) {
                     if (var2.rowInserted()) {
                        continue label84;
                     }

                     if (var2.rowUpdated()) {
                        var7 = var2.getCurrentRow();
                        var4 = this.updateRow(var2, var7) || var4;
                     } else if (var2.rowDeleted()) {
                        var7 = var2.getCurrentRow();
                        var6 = this.deleteRow(var2, var7) || var6;
                     }
                  }

                  if (var4 && var5 && var6) {
                     this.connection.commit();
                     var2.setOriginal();
                  } else {
                     this.connection.rollback();
                  }

                  this.insertStmt.close();
                  this.updateStmt.close();
                  this.deleteStmt.close();
                  if (!var2.isConnectionStayingOpen()) {
                     this.connection.close();
                  }

                  var2.setShowDeleted(var3);
                  return true;
               } while(var2.rowDeleted());

               var7 = var2.getCurrentRow();
               var5 = this.insertRow(var7) || var5;
            }
         }
      }
   }

   protected OracleConnection getConnectionDuringExceptionHandling() {
      return null;
   }
}
