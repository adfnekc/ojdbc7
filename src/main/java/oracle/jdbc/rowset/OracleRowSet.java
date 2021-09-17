package oracle.jdbc.rowset;

import java.io.Serializable;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;
import javax.sql.RowSet;
import javax.sql.RowSetEvent;
import javax.sql.RowSetListener;
import javax.sql.rowset.Joinable;
import oracle.jdbc.driver.DatabaseError;
import oracle.jdbc.internal.OracleConnection;

abstract class OracleRowSet implements Serializable, Cloneable, Joinable {
   protected String dataSource;
   protected String dataSourceName;
   protected String url;
   protected String username;
   protected String password;
   protected Map typeMap;
   protected int maxFieldSize;
   protected int maxRows;
   protected int queryTimeout;
   protected int fetchSize;
   protected int transactionIsolation;
   protected boolean escapeProcessing;
   protected String command;
   protected int concurrency;
   protected boolean readOnly;
   protected int fetchDirection;
   protected int rowsetType;
   protected boolean showDeleted;
   protected Vector listener;
   protected RowSetEvent rowsetEvent;
   protected Vector matchColumnIndexes;
   protected Vector matchColumnNames;
   protected boolean isClosed;
   private static final String _Copyright_2007_Oracle_All_Rights_Reserved_ = null;
   public static final String BUILD_DATE = "Thu_Apr_04_15:09:24_PDT_2013";
   public static final boolean TRACE = false;

   protected OracleRowSet() throws SQLException {
      this.initializeProperties();
      this.matchColumnIndexes = new Vector(10);
      this.matchColumnNames = new Vector(10);
      this.listener = new Vector();
      this.rowsetEvent = new RowSetEvent((RowSet)this);
      this.isClosed = false;
   }

   protected void initializeProperties() {
      this.command = null;
      this.concurrency = 1007;
      this.dataSource = null;
      this.dataSourceName = null;
      this.escapeProcessing = true;
      this.fetchDirection = 1002;
      this.fetchSize = 0;
      this.maxFieldSize = 0;
      this.maxRows = 0;
      this.queryTimeout = 0;
      this.readOnly = false;
      this.showDeleted = false;
      this.transactionIsolation = 2;
      this.rowsetType = 1005;
      this.typeMap = new HashMap();
      this.username = null;
      this.password = null;
      this.url = null;
   }

   public String getCommand() {
      return this.command;
   }

   public int getConcurrency() throws SQLException {
      return this.concurrency;
   }

   /** @deprecated */
   public String getDataSource() {
      return this.dataSource;
   }

   public String getDataSourceName() {
      return this.dataSourceName;
   }

   public boolean getEscapeProcessing() throws SQLException {
      return this.escapeProcessing;
   }

   public int getFetchDirection() throws SQLException {
      return this.fetchDirection;
   }

   public int getFetchSize() throws SQLException {
      return this.fetchSize;
   }

   public int getMaxFieldSize() throws SQLException {
      return this.maxFieldSize;
   }

   public int getMaxRows() throws SQLException {
      return this.maxRows;
   }

   public String getPassword() {
      return this.password;
   }

   public int getQueryTimeout() throws SQLException {
      return this.queryTimeout;
   }

   public boolean getReadOnly() {
      return this.isReadOnly();
   }

   public boolean isReadOnly() {
      return this.readOnly;
   }

   public boolean getShowDeleted() {
      return this.showDeleted;
   }

   public int getTransactionIsolation() {
      return this.transactionIsolation;
   }

   public int getType() throws SQLException {
      return this.rowsetType;
   }

   public Map getTypeMap() throws SQLException {
      return this.typeMap;
   }

   public String getUrl() {
      return this.url;
   }

   public String getUsername() {
      return this.username;
   }

   public void setCommand(String var1) throws SQLException {
      this.command = var1;
   }

   public void setConcurrency(int var1) throws SQLException {
      if (var1 != 1007 && var1 != 1008) {
         SQLException var2 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 68);
         var2.fillInStackTrace();
         throw var2;
      } else {
         this.concurrency = var1;
      }
   }

   /** @deprecated */
   public void setDataSource(String var1) {
      this.dataSource = var1;
   }

   public void setDataSourceName(String var1) throws SQLException {
      this.dataSourceName = var1;
   }

   public void setEscapeProcessing(boolean var1) throws SQLException {
      this.escapeProcessing = var1;
   }

   public void setFetchDirection(int var1) throws SQLException {
      this.fetchDirection = var1;
   }

   public void setFetchSize(int var1) throws SQLException {
      this.fetchSize = var1;
   }

   public void setMaxFieldSize(int var1) throws SQLException {
      this.maxFieldSize = var1;
   }

   public void setMaxRows(int var1) throws SQLException {
      this.maxRows = var1;
   }

   public void setPassword(String var1) throws SQLException {
      this.password = var1;
   }

   public void setQueryTimeout(int var1) throws SQLException {
      this.queryTimeout = var1;
   }

   public void setReadOnly(boolean var1) throws SQLException {
      this.readOnly = var1;
   }

   public void setShowDeleted(boolean var1) throws SQLException {
      this.showDeleted = var1;
   }

   public void setTransactionIsolation(int var1) throws SQLException {
      this.transactionIsolation = var1;
   }

   public void setType(int var1) throws SQLException {
      if (var1 != 1003 && var1 != 1004 && var1 != 1005) {
         SQLException var2 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 68);
         var2.fillInStackTrace();
         throw var2;
      } else {
         this.rowsetType = var1;
      }
   }

   public void setTypeMap(Map var1) throws SQLException {
      this.typeMap = var1;
   }

   public void setUrl(String var1) {
      this.url = var1;
   }

   public void setUsername(String var1) throws SQLException {
      this.username = var1;
   }

   public void addRowSetListener(RowSetListener var1) {
      for(int var2 = 0; var2 < this.listener.size(); ++var2) {
         if (this.listener.elementAt(var2).equals(var1)) {
            return;
         }
      }

      this.listener.add(var1);
   }

   public void removeRowSetListener(RowSetListener var1) {
      for(int var2 = 0; var2 < this.listener.size(); ++var2) {
         if (this.listener.elementAt(var2).equals(var1)) {
            this.listener.remove(var2);
         }
      }

   }

   protected synchronized void notifyCursorMoved() {
      int var1 = this.listener.size();
      if (var1 > 0) {
         for(int var2 = 0; var2 < var1; ++var2) {
            ((RowSetListener)this.listener.elementAt(var2)).cursorMoved(this.rowsetEvent);
         }
      }

   }

   protected void notifyRowChanged() {
      int var1 = this.listener.size();
      if (var1 > 0) {
         for(int var2 = 0; var2 < var1; ++var2) {
            ((RowSetListener)this.listener.elementAt(var2)).rowChanged(this.rowsetEvent);
         }
      }

   }

   protected void notifyRowSetChanged() {
      int var1 = this.listener.size();
      if (var1 > 0) {
         for(int var2 = 0; var2 < var1; ++var2) {
            ((RowSetListener)this.listener.elementAt(var2)).rowSetChanged(this.rowsetEvent);
         }
      }

   }

   public int[] getMatchColumnIndexes() throws SQLException {
      if (this.matchColumnIndexes.size() == 0 && this.matchColumnNames.size() == 0) {
         SQLException var8 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 334);
         var8.fillInStackTrace();
         throw var8;
      } else {
         int var1;
         int[] var2;
         int var4;
         if (this.matchColumnNames.size() > 0) {
            String[] var3 = this.getMatchColumnNames();
            var1 = var3.length;
            var2 = new int[var1];

            for(var4 = 0; var4 < var1; ++var4) {
               var2[var4] = this.findColumn(var3[var4]);
            }
         } else {
            var1 = this.matchColumnIndexes.size();
            var2 = new int[var1];
            boolean var9 = true;

            for(var4 = 0; var4 < var1; ++var4) {
               int var10;
               try {
                  var10 = (Integer)this.matchColumnIndexes.get(var4);
               } catch (Exception var7) {
                  SQLException var6 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 336);
                  var6.fillInStackTrace();
                  throw var6;
               }

               if (var10 <= 0) {
                  SQLException var5 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 336);
                  var5.fillInStackTrace();
                  throw var5;
               }

               var2[var4] = var10;
            }
         }

         return var2;
      }
   }

   public String[] getMatchColumnNames() throws SQLException {
      this.checkIfMatchColumnNamesSet();
      int var1 = this.matchColumnNames.size();
      String[] var2 = new String[var1];
      String var3 = null;
      int var4 = 0;

      while(true) {
         if (var4 < var1) {
            try {
               var3 = (String)this.matchColumnNames.get(var4);
            } catch (Exception var7) {
               SQLException var6 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 337);
               var6.fillInStackTrace();
               throw var6;
            }

            if (var3 != null && !var3.equals("")) {
               var2[var4] = var3;
               ++var4;
               continue;
            }

            SQLException var5 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 337);
            var5.fillInStackTrace();
            throw var5;
         }

         return var2;
      }
   }

   public void setMatchColumn(int var1) throws SQLException {
      if (var1 <= 0) {
         SQLException var2 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 336);
         var2.fillInStackTrace();
         throw var2;
      } else {
         try {
            this.matchColumnIndexes.clear();
            this.matchColumnNames.clear();
            this.matchColumnIndexes.add(0, var1);
         } catch (Exception var4) {
            SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 338);
            var3.fillInStackTrace();
            throw var3;
         }
      }
   }

   public void setMatchColumn(int[] var1) throws SQLException {
      this.matchColumnIndexes.clear();
      this.matchColumnNames.clear();
      if (var1 == null) {
         SQLException var6 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 68);
         var6.fillInStackTrace();
         throw var6;
      } else {
         for(int var2 = 0; var2 < var1.length; ++var2) {
            if (var1[var2] <= 0) {
               SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 336);
               var3.fillInStackTrace();
               throw var3;
            }

            try {
               this.matchColumnIndexes.add(var2, var1[var2]);
            } catch (Exception var5) {
               SQLException var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 338);
               var4.fillInStackTrace();
               throw var4;
            }
         }

      }
   }

   public void setMatchColumn(String var1) throws SQLException {
      if (var1 != null && !var1.equals("")) {
         try {
            this.matchColumnIndexes.clear();
            this.matchColumnNames.clear();
            this.matchColumnNames.add(0, var1.trim());
         } catch (Exception var4) {
            SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 339);
            var3.fillInStackTrace();
            throw var3;
         }
      } else {
         SQLException var2 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 68);
         var2.fillInStackTrace();
         throw var2;
      }
   }

   public void setMatchColumn(String[] var1) throws SQLException {
      this.matchColumnIndexes.clear();
      this.matchColumnNames.clear();

      for(int var2 = 0; var2 < var1.length; ++var2) {
         if (var1[var2] == null || var1[var2].equals("")) {
            SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 68);
            var3.fillInStackTrace();
            throw var3;
         }

         try {
            this.matchColumnNames.add(var2, var1[var2].trim());
         } catch (Exception var5) {
            SQLException var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 339);
            var4.fillInStackTrace();
            throw var4;
         }
      }

   }

   public void unsetMatchColumn(int var1) throws SQLException {
      this.checkIfMatchColumnIndexesSet();
      if (var1 <= 0) {
         SQLException var7 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 336);
         var7.fillInStackTrace();
         throw var7;
      } else {
         boolean var2 = true;

         int var6;
         try {
            var6 = (Integer)this.matchColumnIndexes.get(0);
         } catch (Exception var5) {
            SQLException var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 334);
            var4.fillInStackTrace();
            throw var4;
         }

         if (var6 != var1) {
            SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 340);
            var3.fillInStackTrace();
            throw var3;
         } else {
            this.matchColumnIndexes.clear();
            this.matchColumnNames.clear();
         }
      }
   }

   public void unsetMatchColumn(int[] var1) throws SQLException {
      this.checkIfMatchColumnIndexesSet();
      if (var1 == null) {
         SQLException var8 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 68);
         var8.fillInStackTrace();
         throw var8;
      } else {
         boolean var2 = true;

         for(int var3 = 0; var3 < var1.length; ++var3) {
            SQLException var4;
            if (var1[var3] <= 0) {
               var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 336);
               var4.fillInStackTrace();
               throw var4;
            }

            int var7;
            try {
               var7 = (Integer)this.matchColumnIndexes.get(var3);
            } catch (Exception var6) {
               SQLException var5 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 334);
               var5.fillInStackTrace();
               throw var5;
            }

            if (var7 != var1[var3]) {
               var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 340);
               var4.fillInStackTrace();
               throw var4;
            }
         }

         this.matchColumnIndexes.clear();
         this.matchColumnNames.clear();
      }
   }

   public void unsetMatchColumn(String var1) throws SQLException {
      this.checkIfMatchColumnNamesSet();
      SQLException var2;
      if (var1 != null && !var1.equals("")) {
         var2 = null;

         String var6;
         try {
            var6 = (String)this.matchColumnNames.get(0);
         } catch (Exception var5) {
            SQLException var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 335);
            var4.fillInStackTrace();
            throw var4;
         }

         if (!var6.equals(var1.trim())) {
            SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 341);
            var3.fillInStackTrace();
            throw var3;
         } else {
            this.matchColumnIndexes.clear();
            this.matchColumnNames.clear();
         }
      } else {
         var2 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 68);
         var2.fillInStackTrace();
         throw var2;
      }
   }

   public void unsetMatchColumn(String[] var1) throws SQLException {
      this.checkIfMatchColumnNamesSet();
      if (var1 == null) {
         SQLException var7 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 68);
         var7.fillInStackTrace();
         throw var7;
      } else {
         String var2 = null;

         for(int var3 = 0; var3 < var1.length; ++var3) {
            SQLException var4;
            if (var1[var3] == null || var1[var3].equals("")) {
               var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 68);
               var4.fillInStackTrace();
               throw var4;
            }

            try {
               var2 = (String)this.matchColumnNames.get(var3);
            } catch (Exception var6) {
               SQLException var5 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 335);
               var5.fillInStackTrace();
               throw var5;
            }

            if (!var2.equals(var1[var3])) {
               var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 341);
               var4.fillInStackTrace();
               throw var4;
            }
         }

         this.matchColumnIndexes.clear();
         this.matchColumnNames.clear();
      }
   }

   protected void checkIfMatchColumnIndexesSet() throws SQLException {
      if (this.matchColumnIndexes.size() == 0) {
         SQLException var1 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 334);
         var1.fillInStackTrace();
         throw var1;
      }
   }

   protected void checkIfMatchColumnNamesSet() throws SQLException {
      if (this.matchColumnNames.size() == 0) {
         SQLException var1 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 335);
         var1.fillInStackTrace();
         throw var1;
      }
   }

   public abstract int findColumn(String var1) throws SQLException;

   public abstract ResultSetMetaData getMetaData() throws SQLException;

   abstract String getTableName() throws SQLException;

   public boolean isClosed() throws SQLException {
      return this.isClosed;
   }

   public int getHoldability() throws SQLException {
      return 1;
   }

   public boolean isWrapperFor(Class var1) throws SQLException {
      if (var1.isInterface()) {
         return var1.isInstance(this);
      } else {
         SQLException var2 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 177);
         var2.fillInStackTrace();
         throw var2;
      }
   }

   public Object unwrap(Class var1) throws SQLException {
      if (var1.isInterface() && var1.isInstance(this)) {
         return this;
      } else {
         SQLException var2 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 177);
         var2.fillInStackTrace();
         throw var2;
      }
   }

   public Object getObject(int var1, Class var2) throws SQLException {
      SQLException var3 = DatabaseError.createUnsupportedFeatureSqlException("<T> T getObject");
      var3.fillInStackTrace();
      throw var3;
   }

   public Object getObject(String var1, Class var2) throws SQLException {
      SQLException var3 = DatabaseError.createUnsupportedFeatureSqlException("<T> T getObject");
      var3.fillInStackTrace();
      throw var3;
   }

   protected OracleConnection getConnectionDuringExceptionHandling() {
      return null;
   }
}
