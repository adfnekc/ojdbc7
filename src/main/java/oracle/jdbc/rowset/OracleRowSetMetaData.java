package oracle.jdbc.rowset;

import java.io.Serializable;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import javax.sql.RowSetMetaData;
import oracle.jdbc.driver.DatabaseError;
import oracle.jdbc.internal.OracleConnection;

public class OracleRowSetMetaData implements RowSetMetaData, Serializable {
   private int columnCount;
   private int[] nullable;
   private int[] columnDisplaySize;
   private int[] precision;
   private int[] scale;
   private int[] columnType;
   private boolean[] searchable;
   private boolean[] caseSensitive;
   private boolean[] readOnly;
   private boolean[] writable;
   private boolean[] definatelyWritable;
   private boolean[] currency;
   private boolean[] autoIncrement;
   private boolean[] signed;
   private String[] columnLabel;
   private String[] schemaName;
   private String[] columnName;
   private String[] tableName;
   private String[] columnTypeName;
   private String[] catalogName;
   private String[] columnClassName;
   private static final String _Copyright_2007_Oracle_All_Rights_Reserved_ = null;
   public static final String BUILD_DATE = "Thu_Apr_04_15:09:24_PDT_2013";
   public static final boolean TRACE = false;

   OracleRowSetMetaData(int var1) throws SQLException {
      this.columnCount = var1;
      this.searchable = new boolean[this.columnCount];
      this.caseSensitive = new boolean[this.columnCount];
      this.readOnly = new boolean[this.columnCount];
      this.nullable = new int[this.columnCount];
      this.signed = new boolean[this.columnCount];
      this.columnDisplaySize = new int[this.columnCount];
      this.columnType = new int[this.columnCount];
      this.columnLabel = new String[this.columnCount];
      this.columnName = new String[this.columnCount];
      this.schemaName = new String[this.columnCount];
      this.precision = new int[this.columnCount];
      this.scale = new int[this.columnCount];
      this.tableName = new String[this.columnCount];
      this.columnTypeName = new String[this.columnCount];
      this.writable = new boolean[this.columnCount];
      this.definatelyWritable = new boolean[this.columnCount];
      this.currency = new boolean[this.columnCount];
      this.autoIncrement = new boolean[this.columnCount];
      this.catalogName = new String[this.columnCount];
      this.columnClassName = new String[this.columnCount];

      for(int var2 = 0; var2 < this.columnCount; ++var2) {
         this.searchable[var2] = false;
         this.caseSensitive[var2] = false;
         this.readOnly[var2] = false;
         this.nullable[var2] = 1;
         this.signed[var2] = false;
         this.columnDisplaySize[var2] = 0;
         this.columnType[var2] = 0;
         this.columnLabel[var2] = "";
         this.columnName[var2] = "";
         this.schemaName[var2] = "";
         this.precision[var2] = 0;
         this.scale[var2] = 0;
         this.tableName[var2] = "";
         this.columnTypeName[var2] = "";
         this.writable[var2] = false;
         this.definatelyWritable[var2] = false;
         this.currency[var2] = false;
         this.autoIncrement[var2] = true;
         this.catalogName[var2] = "";
         this.columnClassName[var2] = "";
      }

   }

   OracleRowSetMetaData(ResultSetMetaData var1) throws SQLException {
      this.columnCount = var1.getColumnCount();
      this.searchable = new boolean[this.columnCount];
      this.caseSensitive = new boolean[this.columnCount];
      this.readOnly = new boolean[this.columnCount];
      this.nullable = new int[this.columnCount];
      this.signed = new boolean[this.columnCount];
      this.columnDisplaySize = new int[this.columnCount];
      this.columnType = new int[this.columnCount];
      this.columnLabel = new String[this.columnCount];
      this.columnName = new String[this.columnCount];
      this.schemaName = new String[this.columnCount];
      this.precision = new int[this.columnCount];
      this.scale = new int[this.columnCount];
      this.tableName = new String[this.columnCount];
      this.columnTypeName = new String[this.columnCount];
      this.writable = new boolean[this.columnCount];
      this.definatelyWritable = new boolean[this.columnCount];
      this.currency = new boolean[this.columnCount];
      this.autoIncrement = new boolean[this.columnCount];
      this.catalogName = new String[this.columnCount];
      this.columnClassName = new String[this.columnCount];

      for(int var2 = 0; var2 < this.columnCount; ++var2) {
         this.searchable[var2] = var1.isSearchable(var2 + 1);
         this.caseSensitive[var2] = var1.isCaseSensitive(var2 + 1);
         this.readOnly[var2] = var1.isReadOnly(var2 + 1);
         this.nullable[var2] = var1.isNullable(var2 + 1);
         this.signed[var2] = var1.isSigned(var2 + 1);
         this.columnDisplaySize[var2] = var1.getColumnDisplaySize(var2 + 1);
         this.columnType[var2] = var1.getColumnType(var2 + 1);
         this.columnLabel[var2] = var1.getColumnLabel(var2 + 1);
         this.columnName[var2] = var1.getColumnName(var2 + 1);
         this.schemaName[var2] = var1.getSchemaName(var2 + 1);
         if (this.columnType[var2] != 2 && this.columnType[var2] != 2 && this.columnType[var2] != -5 && this.columnType[var2] != 3 && this.columnType[var2] != 8 && this.columnType[var2] != 6 && this.columnType[var2] != 4) {
            this.precision[var2] = 0;
            this.scale[var2] = 0;
         } else {
            this.precision[var2] = var1.getPrecision(var2 + 1);
            this.scale[var2] = var1.getScale(var2 + 1);
         }

         this.tableName[var2] = var1.getTableName(var2 + 1);
         this.columnTypeName[var2] = var1.getColumnTypeName(var2 + 1);
         this.writable[var2] = var1.isWritable(var2 + 1);
         this.definatelyWritable[var2] = var1.isDefinitelyWritable(var2 + 1);
         this.currency[var2] = var1.isCurrency(var2 + 1);
         this.autoIncrement[var2] = var1.isAutoIncrement(var2 + 1);
         this.catalogName[var2] = var1.getCatalogName(var2 + 1);
         this.columnClassName[var2] = var1.getColumnClassName(var2 + 1);
      }

   }

   private void validateColumnIndex(int var1) throws SQLException {
      if (var1 < 1 || var1 > this.columnCount) {
         SQLException var2 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 3, "" + var1);
         var2.fillInStackTrace();
         throw var2;
      }
   }

   public int getColumnCount() throws SQLException {
      return this.columnCount;
   }

   public boolean isAutoIncrement(int var1) throws SQLException {
      this.validateColumnIndex(var1);
      return this.autoIncrement[var1 - 1];
   }

   public boolean isCaseSensitive(int var1) throws SQLException {
      this.validateColumnIndex(var1);
      return this.caseSensitive[var1 - 1];
   }

   public boolean isSearchable(int var1) throws SQLException {
      this.validateColumnIndex(var1);
      return this.searchable[var1 - 1];
   }

   public boolean isCurrency(int var1) throws SQLException {
      this.validateColumnIndex(var1);
      return this.currency[var1 - 1];
   }

   public int isNullable(int var1) throws SQLException {
      this.validateColumnIndex(var1);
      return this.nullable[var1 - 1];
   }

   public boolean isSigned(int var1) throws SQLException {
      this.validateColumnIndex(var1);
      return this.signed[var1 - 1];
   }

   public int getColumnDisplaySize(int var1) throws SQLException {
      this.validateColumnIndex(var1);
      return this.columnDisplaySize[var1 - 1];
   }

   public String getColumnLabel(int var1) throws SQLException {
      this.validateColumnIndex(var1);
      return this.columnLabel[var1 - 1];
   }

   public String getColumnName(int var1) throws SQLException {
      this.validateColumnIndex(var1);
      return this.columnName[var1 - 1];
   }

   public String getSchemaName(int var1) throws SQLException {
      this.validateColumnIndex(var1);
      return this.schemaName[var1 - 1];
   }

   public int getPrecision(int var1) throws SQLException {
      this.validateColumnIndex(var1);
      return this.precision[var1 - 1];
   }

   public int getScale(int var1) throws SQLException {
      this.validateColumnIndex(var1);
      return this.scale[var1 - 1];
   }

   public String getTableName(int var1) throws SQLException {
      this.validateColumnIndex(var1);
      return this.tableName[var1 - 1];
   }

   public String getCatalogName(int var1) throws SQLException {
      this.validateColumnIndex(var1);
      return this.catalogName[var1 - 1];
   }

   public int getColumnType(int var1) throws SQLException {
      this.validateColumnIndex(var1);
      return this.columnType[var1 - 1];
   }

   public String getColumnTypeName(int var1) throws SQLException {
      this.validateColumnIndex(var1);
      return this.columnTypeName[var1 - 1];
   }

   public boolean isReadOnly(int var1) throws SQLException {
      this.validateColumnIndex(var1);
      return this.readOnly[var1 - 1];
   }

   public boolean isWritable(int var1) throws SQLException {
      this.validateColumnIndex(var1);
      return this.writable[var1 - 1];
   }

   public boolean isDefinitelyWritable(int var1) throws SQLException {
      this.validateColumnIndex(var1);
      return this.definatelyWritable[var1 - 1];
   }

   public String getColumnClassName(int var1) throws SQLException {
      this.validateColumnIndex(var1);
      return this.columnClassName[var1 - 1];
   }

   public void setAutoIncrement(int var1, boolean var2) throws SQLException {
      this.validateColumnIndex(var1);
      this.autoIncrement[var1 - 1] = var2;
   }

   public void setCaseSensitive(int var1, boolean var2) throws SQLException {
      this.validateColumnIndex(var1);
      this.caseSensitive[var1 - 1] = var2;
   }

   public void setCatalogName(int var1, String var2) throws SQLException {
      this.validateColumnIndex(var1);
      this.catalogName[var1 - 1] = var2;
   }

   public void setColumnCount(int var1) throws SQLException {
      this.columnCount = var1;
   }

   public void setColumnDisplaySize(int var1, int var2) throws SQLException {
      this.validateColumnIndex(var1);
      this.columnDisplaySize[var1 - 1] = var2;
   }

   public void setColumnLabel(int var1, String var2) throws SQLException {
      this.validateColumnIndex(var1);
      this.columnLabel[var1 - 1] = var2;
   }

   public void setColumnName(int var1, String var2) throws SQLException {
      this.validateColumnIndex(var1);
      this.columnName[var1 - 1] = var2;
   }

   public void setColumnType(int var1, int var2) throws SQLException {
      this.validateColumnIndex(var1);
      this.columnType[var1 - 1] = var2;
   }

   public void setColumnTypeName(int var1, String var2) throws SQLException {
      this.validateColumnIndex(var1);
      this.columnTypeName[var1 - 1] = var2;
   }

   public void setCurrency(int var1, boolean var2) throws SQLException {
      this.validateColumnIndex(var1);
      this.currency[var1 - 1] = var2;
   }

   public void setNullable(int var1, int var2) throws SQLException {
      this.validateColumnIndex(var1);
      this.nullable[var1 - 1] = var2;
   }

   public void setPrecision(int var1, int var2) throws SQLException {
      this.validateColumnIndex(var1);
      this.precision[var1 - 1] = var2;
   }

   public void setScale(int var1, int var2) throws SQLException {
      this.validateColumnIndex(var1);
      this.scale[var1 - 1] = var2;
   }

   public void setSchemaName(int var1, String var2) throws SQLException {
      this.validateColumnIndex(var1);
      this.schemaName[var1 - 1] = var2;
   }

   public void setSearchable(int var1, boolean var2) throws SQLException {
      this.validateColumnIndex(var1);
      this.searchable[var1 - 1] = var2;
   }

   public void setSigned(int var1, boolean var2) throws SQLException {
      this.validateColumnIndex(var1);
      this.signed[var1 - 1] = var2;
   }

   public void setTableName(int var1, String var2) throws SQLException {
      this.validateColumnIndex(var1);
      this.tableName[var1 - 1] = var2;
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

   protected OracleConnection getConnectionDuringExceptionHandling() {
      return null;
   }
}
