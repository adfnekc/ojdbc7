package oracle.jdbc.driver;

import java.sql.Connection;
import java.sql.ParameterMetaData;
import java.sql.PreparedStatement;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

class OracleParameterMetaData implements oracle.jdbc.internal.OracleParameterMetaData {
   int parameterCount = 0;
   int[] isNullable;
   boolean[] isSigned;
   int[] precision;
   int[] scale;
   int[] parameterType;
   String[] parameterTypeName;
   String[] parameterClassName;
   int[] parameterMode;
   boolean throwUnsupportedFeature = false;
   int parameterNoNulls = 0;
   int parameterNullable = 1;
   int parameterNullableUnknown = 2;
   int parameterModeUnknown = 0;
   int parameterModeIn = 1;
   int parameterModeInOut = 2;
   int parameterModeOut = 4;
   Object acProxy;
   private static final String _Copyright_2007_Oracle_All_Rights_Reserved_ = null;
   public static final String BUILD_DATE = "Thu_Apr_04_15:09:24_PDT_2013";
   public static final boolean TRACE = false;

   static final ParameterMetaData getParameterMetaData(OracleSql var0, Connection var1) throws SQLException {
      OracleParameterMetaData var2 = null;
      String var3 = var0.getSql(true, true);
      int var4 = var0.getParameterCount();
      OracleParameterMetaDataParser var5 = null;
      String var6 = null;
      if (!var0.sqlKind.isPlsqlOrCall() && var0.getReturnParameterCount() < 1 && var4 > 0) {
         var5 = new OracleParameterMetaDataParser();
         var5.initialize(var3, var0.sqlKind, var4);
         var6 = var5.getParameterMetaDataSql();
      }

      if (var6 == null) {
         var2 = new OracleParameterMetaData(var4);
      } else {
         PreparedStatement var7 = null;

         try {
            var7 = var1.prepareStatement(var6);
            ResultSetMetaData var8 = var7.getMetaData();
            if (var5.needBindStatusForParameterMetaData()) {
               var2 = new OracleParameterMetaData(var8, var0.getParameterCount(), var5.getBindStatusForInsert());
            } else {
               var2 = new OracleParameterMetaData(var8);
            }
         } finally {
            if (var7 != null) {
               var7.close();
            }

         }
      }

      return var2;
   }

   private OracleParameterMetaData(ResultSetMetaData var1) throws SQLException {
      this.parameterCount = var1.getColumnCount();
      this.isNullable = new int[this.parameterCount];
      this.isSigned = new boolean[this.parameterCount];
      this.precision = new int[this.parameterCount];
      this.scale = new int[this.parameterCount];
      this.parameterType = new int[this.parameterCount];
      this.parameterTypeName = new String[this.parameterCount];
      this.parameterClassName = new String[this.parameterCount];
      this.parameterMode = new int[this.parameterCount];
      int var2 = 1;

      for(int var3 = 0; var2 <= this.parameterCount; ++var3) {
         this.isNullable[var3] = var1.isNullable(var2);
         this.isSigned[var3] = var1.isSigned(var2);
         this.precision[var3] = var1.getPrecision(var2);
         this.scale[var3] = var1.getScale(var2);
         this.parameterType[var3] = var1.getColumnType(var2);
         this.parameterTypeName[var3] = var1.getColumnTypeName(var2);
         this.parameterClassName[var3] = var1.getColumnClassName(var2);
         this.parameterMode[var3] = this.parameterModeIn;
         ++var2;
      }

   }

   private OracleParameterMetaData(ResultSetMetaData var1, int var2, byte[] var3) throws SQLException {
      this.parameterCount = var2;
      this.isNullable = new int[this.parameterCount];
      this.isSigned = new boolean[this.parameterCount];
      this.precision = new int[this.parameterCount];
      this.scale = new int[this.parameterCount];
      this.parameterType = new int[this.parameterCount];
      this.parameterTypeName = new String[this.parameterCount];
      this.parameterClassName = new String[this.parameterCount];
      this.parameterMode = new int[this.parameterCount];
      int var4 = 1;

      for(int var5 = 0; var4 <= this.parameterCount; ++var4) {
         if (var3[var4 - 1] == 1) {
            this.isNullable[var5] = var1.isNullable(var4);
            this.isSigned[var5] = var1.isSigned(var4);
            this.precision[var5] = var1.getPrecision(var4);
            this.scale[var5] = var1.getScale(var4);
            this.parameterType[var5] = var1.getColumnType(var4);
            this.parameterTypeName[var5] = var1.getColumnTypeName(var4);
            this.parameterClassName[var5] = var1.getColumnClassName(var4);
            this.parameterMode[var5] = this.parameterModeIn;
            ++var5;
         }
      }

   }

   OracleParameterMetaData(int var1) throws SQLException {
      this.parameterCount = var1;
      this.throwUnsupportedFeature = true;
   }

   public int getParameterCount() throws SQLException {
      return this.parameterCount;
   }

   void checkValidIndex(int var1) throws SQLException {
      SQLException var2;
      if (this.throwUnsupportedFeature) {
         var2 = DatabaseError.createUnsupportedFeatureSqlException();
         var2.fillInStackTrace();
         throw var2;
      } else if (var1 < 1 || var1 > this.parameterCount) {
         var2 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 3);
         var2.fillInStackTrace();
         throw var2;
      }
   }

   public int isNullable(int var1) throws SQLException {
      this.checkValidIndex(var1);
      return this.isNullable[var1 - 1];
   }

   public boolean isSigned(int var1) throws SQLException {
      this.checkValidIndex(var1);
      return this.isSigned[var1 - 1];
   }

   public int getPrecision(int var1) throws SQLException {
      this.checkValidIndex(var1);
      return this.precision[var1 - 1];
   }

   public int getScale(int var1) throws SQLException {
      this.checkValidIndex(var1);
      return this.scale[var1 - 1];
   }

   public int getParameterType(int var1) throws SQLException {
      this.checkValidIndex(var1);
      return this.parameterType[var1 - 1];
   }

   public String getParameterTypeName(int var1) throws SQLException {
      this.checkValidIndex(var1);
      return this.parameterTypeName[var1 - 1];
   }

   public String getParameterClassName(int var1) throws SQLException {
      this.checkValidIndex(var1);
      return this.parameterClassName[var1 - 1];
   }

   public int getParameterMode(int var1) throws SQLException {
      this.checkValidIndex(var1);
      return this.parameterMode[var1 - 1];
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

   protected oracle.jdbc.internal.OracleConnection getConnectionDuringExceptionHandling() {
      return null;
   }

   public void setACProxy(Object var1) {
      this.acProxy = var1;
   }

   public Object getACProxy() {
      return this.acProxy;
   }
}
