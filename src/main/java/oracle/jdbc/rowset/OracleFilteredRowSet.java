package oracle.jdbc.rowset;

import java.sql.SQLException;
import javax.sql.rowset.FilteredRowSet;
import javax.sql.rowset.Predicate;
import oracle.jdbc.driver.DatabaseError;

public class OracleFilteredRowSet extends OracleWebRowSet implements FilteredRowSet {
   private Predicate predicate;
   private static final String _Copyright_2007_Oracle_All_Rights_Reserved_ = null;
   public static final String BUILD_DATE = "Thu_Apr_04_15:09:24_PDT_2013";
   public static final boolean TRACE = false;

   public OracleFilteredRowSet() throws SQLException {
   }

   public void setFilter(Predicate var1) throws SQLException {
      this.predicate = var1;
   }

   public Predicate getFilter() {
      return this.predicate;
   }

   public boolean next() throws SQLException {
      if (this.rowCount <= 0) {
         return false;
      } else if (this.presentRow >= this.rowCount) {
         return false;
      } else {
         boolean var1 = false;

         do {
            ++this.presentRow;
            if (this.predicate == null || this.predicate != null && this.predicate.evaluate(this)) {
               var1 = true;
               break;
            }
         } while(this.presentRow <= this.rowCount);

         if (var1) {
            this.notifyCursorMoved();
            return true;
         } else {
            return false;
         }
      }
   }

   public boolean previous() throws SQLException {
      if (this.rowsetType == 1003) {
         SQLException var2 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 344);
         var2.fillInStackTrace();
         throw var2;
      } else if (this.rowCount <= 0) {
         return false;
      } else if (this.presentRow <= 1) {
         return false;
      } else {
         boolean var1 = false;

         do {
            --this.presentRow;
            if (this.predicate == null || this.predicate != null && this.predicate.evaluate(this)) {
               var1 = true;
               break;
            }
         } while(this.presentRow >= 1);

         if (var1) {
            this.notifyCursorMoved();
            return true;
         } else {
            return false;
         }
      }
   }

   public boolean absolute(int var1) throws SQLException {
      if (this.rowsetType == 1003) {
         SQLException var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 344);
         var4.fillInStackTrace();
         throw var4;
      } else if (var1 != 0 && Math.abs(var1) <= this.rowCount) {
         int var2 = var1 < 0 ? this.rowCount + var1 + 1 : var1;
         int var3 = 0;

         for(this.presentRow = 0; var3 < var2 && this.presentRow <= this.rowCount; ++var3) {
            if (!this.next()) {
               return false;
            }
         }

         if (var3 == var2) {
            this.notifyCursorMoved();
            return true;
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected void checkAndFilterObject(int var1, Object var2) throws SQLException {
      if (this.predicate != null && !this.predicate.evaluate(var2, var1)) {
         SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 345);
         var3.fillInStackTrace();
         throw var3;
      }
   }
}
