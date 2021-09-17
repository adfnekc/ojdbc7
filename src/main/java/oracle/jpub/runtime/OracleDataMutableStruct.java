package oracle.jpub.runtime;

import java.sql.Connection;
import java.sql.SQLException;
import oracle.jdbc.OracleDataFactory;
import oracle.jdbc.OracleStruct;

public class OracleDataMutableStruct {
   int length;
   OracleStruct pickled;
   Object[] jdbcObjects;
   Object[] attributes;
   OracleDataFactory[] oracleDataFactories;
   int[] sqlTypes;
   boolean pickledCorrect;
   boolean[] isNChar;
   private static final String _Copyright_2007_Oracle_All_Rights_Reserved_ = null;
   public static final String BUILD_DATE = "Thu_Apr_04_15:09:24_PDT_2013";
   public static final boolean TRACE = false;

   public OracleDataMutableStruct(OracleStruct var1, int[] var2, OracleDataFactory[] var3) {
      this.length = var3.length;
      this.pickled = var1;
      this.oracleDataFactories = var3;
      this.sqlTypes = var2;
      this.initNChar(var2.length);
      this.pickledCorrect = true;
   }

   public OracleDataMutableStruct(Object[] var1, int[] var2, OracleDataFactory[] var3) {
      this.length = var3.length;
      this.attributes = var1;
      this.oracleDataFactories = var3;
      this.sqlTypes = var2;
      this.initNChar(var2.length);
      this.pickledCorrect = false;
   }

   public OracleDataMutableStruct(OracleDataMutableStruct var1, int[] var2, OracleDataFactory[] var3) {
      this.length = var3.length;
      this.oracleDataFactories = var3;
      this.sqlTypes = var2;
      this.initNChar(var2.length);
      this.pickled = var1.pickled;
      this.pickledCorrect = var1.pickledCorrect;
      this.jdbcObjects = var1.jdbcObjects;
      this.attributes = var1.attributes;
   }

   public Object toJDBCObject(Connection var1, String var2) throws SQLException {
      if (!this.pickledCorrect) {
         this.pickled = (OracleStruct)var1.createStruct(var2, this.getJDBCObjectAttributes(var1));
         this.pickledCorrect = true;
      }

      return this.pickled;
   }

   public Object getAttribute(int var1) throws SQLException {
      Object var2 = this.getLazyAttributes()[var1];
      if (var2 == null) {
         Object var3 = this.getLazyJDBCObjects()[var1];
         if (this.oracleDataFactories != null) {
            var2 = OracleDataUtil.convertToObject(var3, this.sqlTypes[var1], this.oracleDataFactories[var1]);
            this.attributes[var1] = var2;
            if (OracleDataUtil.isMutable(var3, this.oracleDataFactories[var1])) {
               this.resetJDBCObject(var1);
            }
         }
      }

      return var2;
   }

   public Object getOracleAttribute(int var1) throws SQLException {
      Object var2;
      if (this.oracleDataFactories[var1] == null) {
         var2 = this.getJDBCObjectAttribute(var1, (Connection)null);
         Object var3 = this.getLazyJDBCObjects()[var1];
         if (OracleDataUtil.isMutable(var3, this.oracleDataFactories[var1])) {
            this.pickledCorrect = false;
         }
      } else {
         var2 = this.getAttribute(var1);
      }

      return var2;
   }

   public Object[] getAttributes() throws SQLException {
      for(int var1 = 0; var1 < this.length; ++var1) {
         this.getAttribute(var1);
      }

      return this.attributes;
   }

   public Object[] getOracleAttributes() throws SQLException {
      Object[] var1 = new Object[this.length];

      for(int var2 = 0; var2 < this.length; ++var2) {
         var1[var2] = this.getOracleAttribute(var2);
      }

      return var1;
   }

   public void setAttribute(int var1, Object var2) throws SQLException {
      if (var2 == null) {
         this.getLazyJDBCObjects();
      }

      this.resetJDBCObject(var1);
      this.getLazyAttributes()[var1] = var2;
   }

   public void setDoubleAttribute(int var1, double var2) throws SQLException {
      this.setAttribute(var1, var2);
   }

   public void setFloatAttribute(int var1, float var2) throws SQLException {
      this.setAttribute(var1, var2);
   }

   public void setIntAttribute(int var1, int var2) throws SQLException {
      this.setAttribute(var1, var2);
   }

   public void setOracleAttribute(int var1, Object var2) throws SQLException {
      if (this.oracleDataFactories != null) {
         if (this.oracleDataFactories[var1] == null) {
            this.setJDBCObjectAttribute(var1, var2);
         } else {
            this.setAttribute(var1, var2);
         }
      }

   }

   Object getJDBCObjectAttribute(int var1, Connection var2) throws SQLException {
      Object var3 = this.getLazyJDBCObjects()[var1];
      if (var3 == null) {
         Object var4 = this.getLazyAttributes()[var1];
         var3 = OracleDataUtil.convertToOracle(var4, var2, this.isNChar(var1));
         this.jdbcObjects[var1] = var3;
      }

      return var3;
   }

   void setJDBCObjectAttribute(int var1, Object var2) throws SQLException {
      this.resetAttribute(var1);
      this.getLazyJDBCObjects()[var1] = var2;
      this.pickledCorrect = false;
   }

   Object[] getJDBCObjectAttributes(Connection var1) throws SQLException {
      for(int var2 = 0; var2 < this.length; ++var2) {
         this.getJDBCObjectAttribute(var2, var1);
      }

      return (Object[])this.jdbcObjects.clone();
   }

   void resetAttribute(int var1) throws SQLException {
      if (this.attributes != null) {
         this.attributes[var1] = null;
      }

   }

   void resetJDBCObject(int var1) throws SQLException {
      if (this.jdbcObjects != null) {
         this.jdbcObjects[var1] = null;
      }

      this.pickledCorrect = false;
   }

   Object[] getLazyAttributes() {
      if (this.attributes == null) {
         this.attributes = new Object[this.length];
      }

      return this.attributes;
   }

   Object[] getLazyJDBCObjects() throws SQLException {
      if (this.jdbcObjects == null) {
         if (this.pickled != null) {
            this.jdbcObjects = this.pickled.getAttributes();
            this.pickledCorrect = true;
            if (this.attributes != null) {
               for(int var1 = 0; var1 < this.length; ++var1) {
                  if (this.attributes[var1] != null) {
                     this.jdbcObjects[var1] = null;
                     this.pickledCorrect = false;
                  }
               }
            }
         } else {
            this.jdbcObjects = new Object[this.length];
         }
      }

      return this.jdbcObjects;
   }

   private void initNChar(int var1) {
      this.isNChar = new boolean[var1];

      for(int var2 = 0; var2 < var1; ++var2) {
         this.isNChar[var2] = false;
      }

   }

   public void setNChar(int var1) throws SQLException {
      this.isNChar[var1] = true;
   }

   public boolean isNChar(int var1) throws SQLException {
      boolean var2 = this.isNChar[var1];
      return var2;
   }
}
