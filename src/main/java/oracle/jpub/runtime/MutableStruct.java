package oracle.jpub.runtime;

import java.sql.Connection;
import java.sql.SQLException;
import oracle.jdbc.OracleConnection;
import oracle.sql.CustomDatumFactory;
import oracle.sql.Datum;
import oracle.sql.ORADataFactory;
import oracle.sql.STRUCT;
import oracle.sql.StructDescriptor;

public class MutableStruct {
   int length;
   STRUCT pickled;
   Datum[] datums;
   Object[] attributes;
   CustomDatumFactory[] old_factories;
   ORADataFactory[] factories;
   int[] sqlTypes;
   boolean pickledCorrect;
   boolean[] isNChar;
   private static final String _Copyright_2007_Oracle_All_Rights_Reserved_ = null;
   public static final String BUILD_DATE = "Thu_Apr_04_15:09:24_PDT_2013";
   public static final boolean TRACE = false;

   public MutableStruct(STRUCT var1, int[] var2, ORADataFactory[] var3) {
      this.length = var3.length;
      this.pickled = var1;
      this.factories = var3;
      this.sqlTypes = var2;
      this.initNChar(var2.length);
      this.pickledCorrect = true;
   }

   public MutableStruct(Object[] var1, int[] var2, ORADataFactory[] var3) {
      this.length = var3.length;
      this.attributes = var1;
      this.factories = var3;
      this.sqlTypes = var2;
      this.initNChar(var2.length);
      this.pickledCorrect = false;
   }

   public MutableStruct(STRUCT var1, int[] var2, CustomDatumFactory[] var3) {
      this.length = var3.length;
      this.pickled = var1;
      this.old_factories = var3;
      this.sqlTypes = var2;
      this.initNChar(var2.length);
      this.pickledCorrect = true;
   }

   public MutableStruct(Object[] var1, int[] var2, CustomDatumFactory[] var3) {
      this.length = var3.length;
      this.attributes = var1;
      this.old_factories = var3;
      this.sqlTypes = var2;
      this.initNChar(var2.length);
      this.pickledCorrect = false;
   }

   public Datum toDatum(Connection var1, String var2) throws SQLException {
      if (!this.pickledCorrect) {
         this.pickled = new STRUCT(StructDescriptor.createDescriptor(var2, var1), var1, this.getDatumAttributes(var1));
         this.pickledCorrect = true;
      }

      return this.pickled;
   }

   public Datum toDatum(OracleConnection var1, String var2) throws SQLException {
      return this.toDatum((Connection)var1, var2);
   }

   /** @deprecated */
   public Datum toDatum(oracle.jdbc.driver.OracleConnection var1, String var2) throws SQLException {
      return this.toDatum((Connection)var1, var2);
   }

   public Object getAttribute(int var1) throws SQLException {
      Object var2 = this.getLazyAttributes()[var1];
      if (var2 == null) {
         Datum var3 = this.getLazyDatums()[var1];
         if (this.old_factories == null) {
            var2 = Util.convertToObject(var3, this.sqlTypes[var1], this.factories[var1]);
            this.attributes[var1] = var2;
            if (Util.isMutable(var3, this.factories[var1])) {
               this.resetDatum(var1);
            }
         } else {
            var2 = Util.convertToObject(var3, this.sqlTypes[var1], this.old_factories[var1]);
            this.attributes[var1] = var2;
            if (Util.isMutable(var3, this.old_factories[var1])) {
               this.resetDatum(var1);
            }
         }
      }

      return var2;
   }

   public Object getOracleAttribute(int var1) throws SQLException {
      Object var2;
      Datum var3;
      if (this.old_factories == null) {
         if (this.factories[var1] == null) {
            var2 = this.getDatumAttribute(var1, (Connection)null);
            var3 = this.getLazyDatums()[var1];
            if (Util.isMutable(var3, this.factories[var1])) {
               this.pickledCorrect = false;
            }
         } else {
            var2 = this.getAttribute(var1);
         }
      } else if (this.old_factories[var1] == null) {
         var2 = this.getDatumAttribute(var1, (Connection)null);
         var3 = this.getLazyDatums()[var1];
         if (Util.isMutable(var3, this.old_factories[var1])) {
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
         this.getLazyDatums();
      }

      this.resetDatum(var1);
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
      if (this.old_factories == null) {
         if (this.factories[var1] == null) {
            this.setDatumAttribute(var1, (Datum)var2);
         } else {
            this.setAttribute(var1, var2);
         }
      } else if (this.old_factories[var1] == null) {
         this.setDatumAttribute(var1, (Datum)var2);
      } else {
         this.setAttribute(var1, var2);
      }

   }

   Datum getDatumAttribute(int var1, Connection var2) throws SQLException {
      Datum var3 = this.getLazyDatums()[var1];
      if (var3 == null) {
         Object var4 = this.getLazyAttributes()[var1];
         var3 = Util.convertToOracle(var4, var2, this.isNChar(var1));
         this.datums[var1] = var3;
      }

      return var3;
   }

   void setDatumAttribute(int var1, Datum var2) throws SQLException {
      this.resetAttribute(var1);
      this.getLazyDatums()[var1] = var2;
      this.pickledCorrect = false;
   }

   Datum[] getDatumAttributes(Connection var1) throws SQLException {
      for(int var2 = 0; var2 < this.length; ++var2) {
         this.getDatumAttribute(var2, var1);
      }

      return (Datum[])((Datum[])this.datums.clone());
   }

   void resetAttribute(int var1) throws SQLException {
      if (this.attributes != null) {
         this.attributes[var1] = null;
      }

   }

   void resetDatum(int var1) throws SQLException {
      if (this.datums != null) {
         this.datums[var1] = null;
      }

      this.pickledCorrect = false;
   }

   Object[] getLazyAttributes() {
      if (this.attributes == null) {
         this.attributes = new Object[this.length];
      }

      return this.attributes;
   }

   Datum[] getLazyDatums() throws SQLException {
      if (this.datums == null) {
         if (this.pickled != null) {
            this.datums = this.pickled.getOracleAttributes();
            this.pickledCorrect = true;
            if (this.attributes != null) {
               for(int var1 = 0; var1 < this.length; ++var1) {
                  if (this.attributes[var1] != null) {
                     this.datums[var1] = null;
                     this.pickledCorrect = false;
                  }
               }
            }
         } else {
            this.datums = new Datum[this.length];
         }
      }

      return this.datums;
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
