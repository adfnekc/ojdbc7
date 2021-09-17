package oracle.jdbc.rowset;

import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Collection;
import java.util.Vector;
import javax.sql.RowSet;
import javax.sql.RowSetMetaData;
import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.JoinRowSet;
import javax.sql.rowset.Joinable;
import oracle.jdbc.driver.DatabaseError;

public class OracleJoinRowSet extends OracleWebRowSet implements JoinRowSet {
   private static final String MATCH_COLUMN_SUFFIX = "#MATCH_COLUMN";
   private static boolean[] supportedJoins = new boolean[]{false, true, false, false, false};
   private int joinType = 1;
   private Vector addedRowSets = new Vector();
   private Vector addedRowSetNames = new Vector();
   private Object lockForJoinActions;
   private static final String _Copyright_2007_Oracle_All_Rights_Reserved_ = null;
   public static final String BUILD_DATE = "Thu_Apr_04_15:09:24_PDT_2013";
   public static final boolean TRACE = false;

   public OracleJoinRowSet() throws SQLException {
   }

   public synchronized void addRowSet(Joinable var1) throws SQLException {
      SQLException var5;
      if (var1 == null) {
         var5 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 350);
         var5.fillInStackTrace();
         throw var5;
      } else if (!(var1 instanceof RowSet)) {
         var5 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 351);
         var5.fillInStackTrace();
         throw var5;
      } else {
         OracleCachedRowSet var2 = this.checkAndWrapRowSet((RowSet)var1);
         String var3 = this.getMatchColumnTableName((RowSet)var1);
         switch(this.joinType) {
         case 0:
         case 2:
         case 3:
         case 4:
         default:
            SQLException var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 352);
            var4.fillInStackTrace();
            throw var4;
         case 1:
            this.doInnerJoin(var2);
            this.addedRowSets.add(var1);
            this.addedRowSetNames.add(var3);
         }
      }
   }

   public synchronized void addRowSet(RowSet var1, int var2) throws SQLException {
      ((OracleRowSet)var1).setMatchColumn(var2);
      this.addRowSet((Joinable)var1);
   }

   public synchronized void addRowSet(RowSet var1, String var2) throws SQLException {
      ((OracleRowSet)var1).setMatchColumn(var2);
      this.addRowSet((Joinable)var1);
   }

   public synchronized void addRowSet(RowSet[] var1, int[] var2) throws SQLException {
      if (var1.length != var2.length) {
         SQLException var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 353);
         var4.fillInStackTrace();
         throw var4;
      } else {
         for(int var3 = 0; var3 < var1.length; ++var3) {
            ((OracleRowSet)var1[var3]).setMatchColumn(var2[var3]);
            this.addRowSet((Joinable)var1[var3]);
         }

      }
   }

   public synchronized void addRowSet(RowSet[] var1, String[] var2) throws SQLException {
      if (var1.length != var2.length) {
         SQLException var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 353);
         var4.fillInStackTrace();
         throw var4;
      } else {
         for(int var3 = 0; var3 < var1.length; ++var3) {
            ((OracleRowSet)var1[var3]).setMatchColumn(var2[var3]);
            this.addRowSet((Joinable)var1[var3]);
         }

      }
   }

   public Collection getRowSets() throws SQLException {
      return this.addedRowSets;
   }

   public String[] getRowSetNames() throws SQLException {
      Object[] var1 = this.addedRowSetNames.toArray();
      String[] var2 = new String[var1.length];

      for(int var3 = 0; var3 < var1.length; ++var3) {
         var2[var3] = (String)var1[var3];
      }

      return var2;
   }

   public CachedRowSet toCachedRowSet() throws SQLException {
      OracleCachedRowSet var1 = (OracleCachedRowSet)this.createCopy();
      var1.setCommand("");
      return var1;
   }

   public int getJoinType() {
      return this.joinType;
   }

   public boolean supportsCrossJoin() {
      return supportedJoins[0];
   }

   public boolean supportsInnerJoin() {
      return supportedJoins[1];
   }

   public boolean supportsLeftOuterJoin() {
      return supportedJoins[2];
   }

   public boolean supportsRightOuterJoin() {
      return supportedJoins[3];
   }

   public boolean supportsFullJoin() {
      return supportedJoins[4];
   }

   public void setJoinType(int var1) throws SQLException {
      if (var1 != 1) {
         SQLException var2 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 352);
         var2.fillInStackTrace();
         throw var2;
      } else {
         this.joinType = var1;
      }
   }

   public synchronized String getWhereClause() throws SQLException {
      if (this.addedRowSets.size() < 2) {
         return "WHERE";
      } else {
         StringBuffer var1 = new StringBuffer();
         var1.append("WHERE\n");
         OracleRowSet var2 = (OracleRowSet)this.addedRowSets.get(0);
         int[] var3 = var2.getMatchColumnIndexes();
         ResultSetMetaData var4 = var2.getMetaData();
         String var5 = var2.getTableName();

         for(int var10 = 1; var10 < this.addedRowSets.size(); ++var10) {
            if (var10 > 1) {
               var1.append("\nAND\n");
            }

            OracleRowSet var6 = (OracleRowSet)this.addedRowSets.get(var10);
            int[] var7 = var6.getMatchColumnIndexes();
            ResultSetMetaData var8 = var6.getMetaData();
            String var9 = var6.getTableName();

            for(int var11 = 0; var11 < var3.length; ++var11) {
               if (var11 > 0) {
                  var1.append("\nAND\n");
               }

               var1.append("(" + var5 + "." + var4.getColumnName(var3[var11]) + " = " + var9 + "." + var8.getColumnName(var7[var11]) + ")");
            }

            var3 = var7;
            var4 = var8;
            var5 = var9;
         }

         var1.append(";");
         return var1.toString();
      }
   }

   private void doInnerJoin(OracleCachedRowSet var1) throws SQLException {
      if (this.addedRowSets.isEmpty()) {
         this.setMetaData((RowSetMetaData)var1.getMetaData());
         this.populate(var1);
         this.setMatchColumn(var1.getMatchColumnIndexes());
      } else {
         Vector var2 = new Vector(100);
         OracleRowSetMetaData var3 = new OracleRowSetMetaData(10);
         int[] var4 = this.getMatchColumnIndexes();
         int[] var5 = var1.getMatchColumnIndexes();
         int var6 = this.getMetaData().getColumnCount() + var1.getMetaData().getColumnCount() - var5.length;
         var3.setColumnCount(var6);
         String var8 = this.getTableName() + "#" + var1.getTableName();

         boolean var7;
         int var10;
         for(int var9 = 1; var9 <= this.colCount; ++var9) {
            var7 = false;

            for(var10 = 0; var10 < var4.length; ++var10) {
               if (var9 == var4[var10]) {
                  var7 = true;
                  break;
               }
            }

            this.setNewColumnMetaData(var9, var3, var9, (RowSetMetaData)this.rowsetMetaData, var7, var8);
         }

         RowSetMetaData var20 = (RowSetMetaData)var1.getMetaData();
         var10 = var20.getColumnCount();
         int var11 = this.colCount + 1;
         int[] var12 = new int[var10];

         int var13;
         for(var13 = 1; var13 <= var10; ++var13) {
            var7 = false;

            for(int var14 = 0; var14 < var5.length; ++var14) {
               if (var13 == var4[var14]) {
                  var7 = true;
                  break;
               }
            }

            if (!var7) {
               this.setNewColumnMetaData(var11, var3, var13, var20, var7, var8);
               var12[var13 - 1] = var11++;
            } else {
               var12[var13 - 1] = -1;
            }
         }

         this.beforeFirst();
         var13 = var1.size();
         boolean var21 = false;

         for(int var15 = 1; var15 <= this.rowCount; ++var15) {
            this.next();
            var1.beforeFirst();

            for(int var16 = 1; var16 <= var13; ++var16) {
               var1.next();
               var21 = true;

               for(int var17 = 0; var17 < var4.length; ++var17) {
                  Object var18 = this.getObject(var4[var17]);
                  Object var19 = var1.getObject(var5[var17]);
                  if (!var18.equals(var19)) {
                     var21 = false;
                     break;
                  }
               }

               if (var21) {
                  OracleRow var22 = new OracleRow(var6, true);

                  int var23;
                  for(var23 = 1; var23 <= this.colCount; ++var23) {
                     var22.updateObject(var23, this.getObject(var23));
                  }

                  for(var23 = 1; var23 <= var10; ++var23) {
                     if (var12[var23 - 1] != -1) {
                        var22.updateObject(var12[var23 - 1], var1.getObject(var23));
                     }
                  }

                  var2.add(var22);
               }
            }
         }

         this.rows = var2;
         this.presentRow = 0;
         this.rowCount = this.rows.size();
         this.setMetaData(var3);
      }

   }

   private void setNewColumnMetaData(int var1, RowSetMetaData var2, int var3, RowSetMetaData var4, boolean var5, String var6) throws SQLException {
      var2.setAutoIncrement(var1, var4.isAutoIncrement(var3));
      var2.setCaseSensitive(var1, var4.isCaseSensitive(var3));
      var2.setCatalogName(var1, var4.getCatalogName(var3));
      var2.setColumnDisplaySize(var1, var4.getColumnDisplaySize(var3));
      if (var5) {
         var2.setColumnName(var1, var4.getColumnName(var1) + "#MATCH_COLUMN");
      } else {
         var2.setColumnName(var1, var4.getColumnName(var3));
      }

      var2.setColumnLabel(var1, var2.getColumnName(var3));
      var2.setColumnType(var1, var4.getColumnType(var3));
      var2.setColumnTypeName(var1, var4.getColumnTypeName(var3));
      var2.setCurrency(var1, var4.isCurrency(var3));
      var2.setNullable(var1, var4.isNullable(var3));
      var2.setPrecision(var1, var4.getPrecision(var3));
      var2.setScale(var1, var4.getScale(var3));
      var2.setSchemaName(var1, var4.getSchemaName(var3));
      var2.setSearchable(var1, var4.isSearchable(var3));
      var2.setSigned(var1, var4.isSigned(var3));
      if (var5) {
         var2.setTableName(var1, var6);
      } else {
         var2.setTableName(var1, var4.getTableName(var3));
      }

   }

   private OracleCachedRowSet checkAndWrapRowSet(RowSet var1) throws SQLException {
      OracleCachedRowSet var2 = null;
      if (var1 instanceof OracleCachedRowSet) {
         var2 = (OracleCachedRowSet)var1;
      } else {
         if (!(var1 instanceof OracleJDBCRowSet)) {
            SQLException var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 354);
            var4.fillInStackTrace();
            throw var4;
         }

         var2 = new OracleCachedRowSet();
         var2.populate(var1);
         int[] var3 = ((OracleJDBCRowSet)var1).getMatchColumnIndexes();
         var2.setMatchColumn(var3);
      }

      return var2;
   }

   private String getMatchColumnTableName(RowSet var1) throws SQLException {
      String var2 = null;
      if (var1 instanceof OracleRowSet) {
         var2 = ((OracleRowSet)var1).getTableName();
      }

      return var2;
   }
}
