package oracle.jdbc.rowset;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.Vector;
import oracle.jdbc.driver.DatabaseError;
import oracle.jdbc.internal.OracleConnection;

public class OracleRow implements Serializable, Cloneable {
   private Object[] column;
   private Object[] changedColumn;
   private boolean[] isOriginalNull;
   private byte[] columnChangeFlag;
   private int noColumn;
   private int noColumnsInserted;
   private boolean rowDeleted;
   private boolean rowInserted;
   private static final byte COLUMN_CHANGED = 17;
   private boolean rowUpdated;
   long[][] columnTypeInfo;
   private static final String _Copyright_2007_Oracle_All_Rights_Reserved_ = null;
   public static final String BUILD_DATE = "Thu_Apr_04_15:09:24_PDT_2013";
   public static final boolean TRACE = false;

   public OracleRow(int var1) {
      this.noColumn = 0;
      this.rowDeleted = false;
      this.rowInserted = false;
      this.rowUpdated = false;
      this.noColumn = var1;
      this.column = new Object[var1];
      this.changedColumn = new Object[var1];
      this.columnChangeFlag = new byte[var1];
      this.isOriginalNull = new boolean[var1];
      this.columnTypeInfo = new long[var1][];

      for(int var2 = 0; var2 < var1; ++var2) {
         this.columnChangeFlag[var2] = 0;
      }

   }

   public OracleRow(int var1, boolean var2) {
      this(var1);
      this.rowInserted = var2;
      this.noColumnsInserted = 0;
   }

   public OracleRow(int var1, Object[] var2) {
      this(var1);
      System.arraycopy(var2, 0, this.column, 0, var1);
   }

   public void setColumnValue(int var1, Object var2) {
      if (this.rowInserted) {
         ++this.noColumnsInserted;
      }

      this.column[var1 - 1] = var2;
   }

   void markOriginalNull(int var1, boolean var2) throws SQLException {
      this.isOriginalNull[var1 - 1] = var2;
   }

   boolean isOriginalNull(int var1) throws SQLException {
      return this.isOriginalNull[var1 - 1];
   }

   public void updateObject(int var1, Object var2) {
      this.updateObject(var1, var2, (long[])null);
   }

   void updateObject(int var1, Object var2, long[] var3) {
      if (this.rowInserted) {
         ++this.noColumnsInserted;
      }

      this.columnChangeFlag[var1 - 1] = 17;
      this.changedColumn[var1 - 1] = var2;
      this.columnTypeInfo[var1 - 1] = var3;
   }

   public void cancelRowUpdates() {
      this.noColumnsInserted = 0;

      for(int var1 = 0; var1 < this.noColumn; ++var1) {
         this.columnChangeFlag[var1] = 0;
      }

      this.changedColumn = null;
      this.changedColumn = new Object[this.noColumn];
   }

   public Object getColumn(int var1) {
      return this.column[var1 - 1];
   }

   public Object getModifiedColumn(int var1) {
      return this.changedColumn[var1 - 1];
   }

   public boolean isColumnChanged(int var1) {
      return this.columnChangeFlag[var1 - 1] == 17;
   }

   public boolean isRowUpdated() {
      if (!this.rowInserted && !this.rowDeleted) {
         for(int var1 = 0; var1 < this.noColumn; ++var1) {
            if (this.columnChangeFlag[var1] == 17) {
               return true;
            }
         }

         return false;
      } else {
         return false;
      }
   }

   public void setRowUpdated(boolean var1) {
      this.rowUpdated = var1;
      if (!var1) {
         this.cancelRowUpdates();
      }

   }

   public boolean isRowInserted() {
      return this.rowInserted;
   }

   public void cancelRowDeletion() {
      this.rowDeleted = false;
   }

   public void setRowDeleted(boolean var1) {
      this.rowDeleted = var1;
   }

   public boolean isRowDeleted() {
      return this.rowDeleted;
   }

   public Object[] getOriginalRow() {
      return this.column;
   }

   public boolean isRowFullyPopulated() {
      if (!this.rowInserted) {
         return false;
      } else {
         return this.noColumnsInserted == this.noColumn;
      }
   }

   public void setInsertedFlag(boolean var1) {
      this.rowInserted = var1;
   }

   void makeUpdatesOriginal() {
      for(int var1 = 0; var1 < this.noColumn; ++var1) {
         if (this.columnChangeFlag[var1] == 17) {
            this.column[var1] = this.changedColumn[var1];
            this.changedColumn[var1] = null;
            this.columnChangeFlag[var1] = 0;
         }
      }

      this.rowUpdated = false;
   }

   public void insertRow() {
      this.columnChangeFlag = null;
      this.columnChangeFlag = new byte[this.noColumn];
      System.arraycopy(this.changedColumn, 0, this.column, 0, this.noColumn);
      this.changedColumn = null;
      this.changedColumn = new Object[this.noColumn];
   }

   public Collection toCollection() {
      Vector var1 = new Vector(this.noColumn);

      for(int var2 = 1; var2 <= this.noColumn; ++var2) {
         var1.add(this.isColumnChanged(var2) ? this.getModifiedColumn(var2) : this.getColumn(var2));
      }

      return var1;
   }

   public OracleRow createCopy() throws SQLException {
      OracleRow var1 = new OracleRow(this.noColumn);

      for(int var2 = 0; var2 < this.noColumn; ++var2) {
         var1.column[var2] = this.getCopy(this.column[var2]);
         var1.changedColumn[var2] = this.getCopy(this.changedColumn[var2]);
      }

      System.arraycopy(this.columnChangeFlag, 0, var1.columnChangeFlag, 0, this.noColumn);
      var1.noColumnsInserted = this.noColumnsInserted;
      var1.rowDeleted = this.rowDeleted;
      var1.rowInserted = this.rowInserted;
      var1.rowUpdated = this.rowUpdated;
      return var1;
   }

   public Object getCopy(Object var1) throws SQLException {
      Object var2 = null;

      try {
         if (var1 == null) {
            return null;
         } else {
            if (var1 instanceof String) {
               var2 = (String)var1;
            } else if (var1 instanceof Number) {
               var2 = new BigDecimal(((Number)var1).toString());
            } else if (var1 instanceof Date) {
               var2 = new Date(((Date)var1).getTime());
            } else if (var1 instanceof Timestamp) {
               var2 = new Timestamp(((Timestamp)var1).getTime());
            } else if (var1 instanceof InputStream) {
               var2 = new DataInputStream((InputStream)var1);
            } else {
               if (!(var1 instanceof OutputStream)) {
                  SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 348, var1.getClass().getName());
                  var3.fillInStackTrace();
                  throw var3;
               }

               var2 = new DataOutputStream((OutputStream)var1);
            }

            return var2;
         }
      } catch (Exception var5) {
         SQLException var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 349, var1.getClass().getName() + var5.getMessage());
         var4.fillInStackTrace();
         throw var4;
      }
   }

   public Object clone() throws CloneNotSupportedException {
      try {
         return this.createCopy();
      } catch (SQLException var2) {
         throw new CloneNotSupportedException("Error while cloning\n" + var2.getMessage());
      }
   }

   protected OracleConnection getConnectionDuringExceptionHandling() {
      return null;
   }
}
