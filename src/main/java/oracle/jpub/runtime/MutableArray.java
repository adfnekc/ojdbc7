package oracle.jpub.runtime;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Timestamp;
import oracle.jdbc.OracleConnection;
import oracle.jdbc.driver.DatabaseError;
import oracle.sql.ARRAY;
import oracle.sql.ArrayDescriptor;
import oracle.sql.BFILE;
import oracle.sql.BINARY_DOUBLE;
import oracle.sql.BINARY_FLOAT;
import oracle.sql.BLOB;
import oracle.sql.CHAR;
import oracle.sql.CLOB;
import oracle.sql.CustomDatum;
import oracle.sql.CustomDatumFactory;
import oracle.sql.DATE;
import oracle.sql.Datum;
import oracle.sql.INTERVALDS;
import oracle.sql.INTERVALYM;
import oracle.sql.NCLOB;
import oracle.sql.NUMBER;
import oracle.sql.ORAData;
import oracle.sql.ORADataFactory;
import oracle.sql.RAW;
import oracle.sql.TIMESTAMP;
import oracle.sql.TIMESTAMPLTZ;
import oracle.sql.TIMESTAMPTZ;

public class MutableArray {
   int length;
   Object[] elements;
   Datum[] datums;
   ARRAY pickled;
   boolean pickledCorrect;
   int sqlType;
   ORADataFactory factory;
   CustomDatumFactory old_factory;
   boolean isNChar;
   private static final String _Copyright_2007_Oracle_All_Rights_Reserved_ = null;
   public static final String BUILD_DATE = "Thu_Apr_04_15:09:24_PDT_2013";
   public static final boolean TRACE = false;

   public MutableArray(int var1, ARRAY var2, ORADataFactory var3) {
      this.length = -1;
      this.elements = null;
      this.datums = null;
      this.pickled = var2;
      this.pickledCorrect = true;
      this.isNChar = false;
      this.sqlType = var1;
      this.factory = var3;
   }

   public MutableArray(int var1, Datum[] var2, ORADataFactory var3) {
      this.sqlType = var1;
      this.factory = var3;
      this.isNChar = false;
      this.setDatumArray(var2);
   }

   public MutableArray(int var1, Object[] var2, ORADataFactory var3) {
      this.sqlType = var1;
      this.factory = var3;
      this.isNChar = false;
      this.setObjectArray(var2);
   }

   public MutableArray(int var1, double[] var2, ORADataFactory var3) {
      this.sqlType = var1;
      this.factory = var3;
      this.isNChar = false;
      this.setArray(var2);
   }

   public MutableArray(int var1, int[] var2, ORADataFactory var3) {
      this.sqlType = var1;
      this.factory = var3;
      this.isNChar = false;
      this.setArray(var2);
   }

   public MutableArray(int var1, float[] var2, ORADataFactory var3) {
      this.sqlType = var1;
      this.factory = var3;
      this.isNChar = false;
      this.setArray(var2);
   }

   public MutableArray(int var1, short[] var2, ORADataFactory var3) {
      this.sqlType = var1;
      this.factory = var3;
      this.isNChar = false;
      this.setArray(var2);
   }

   public MutableArray(ARRAY var1, int var2, CustomDatumFactory var3) {
      this.length = -1;
      this.elements = null;
      this.datums = null;
      this.pickled = var1;
      this.pickledCorrect = true;
      this.sqlType = var2;
      this.old_factory = var3;
      this.isNChar = false;
   }

   public MutableArray(Datum[] var1, int var2, CustomDatumFactory var3) {
      this.sqlType = var2;
      this.old_factory = var3;
      this.isNChar = false;
      this.setDatumArray(var1);
   }

   public MutableArray(Object[] var1, int var2, CustomDatumFactory var3) {
      this.sqlType = var2;
      this.old_factory = var3;
      this.isNChar = false;
      this.setObjectArray(var1);
   }

   public MutableArray(double[] var1, int var2, CustomDatumFactory var3) {
      this.sqlType = var2;
      this.old_factory = var3;
      this.isNChar = false;
      this.setArray(var1);
   }

   public MutableArray(int[] var1, int var2, CustomDatumFactory var3) {
      this.sqlType = var2;
      this.old_factory = var3;
      this.isNChar = false;
      this.setArray(var1);
   }

   public MutableArray(float[] var1, int var2, CustomDatumFactory var3) {
      this.sqlType = var2;
      this.old_factory = var3;
      this.isNChar = false;
      this.setArray(var1);
   }

   public MutableArray(short[] var1, int var2, CustomDatumFactory var3) {
      this.sqlType = var2;
      this.old_factory = var3;
      this.isNChar = false;
      this.setArray(var1);
   }

   public Datum toDatum(Connection var1, String var2) throws SQLException {
      if (!this.pickledCorrect) {
         this.pickled = new ARRAY(ArrayDescriptor.createDescriptor(var2, var1), var1, this.getDatumArray(var1));
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

   public Object[] getOracleArray() throws SQLException {
      return this.getOracleArray(0L, Integer.MAX_VALUE);
   }

   public Object[] getOracleArray(long var1, int var3) throws SQLException {
      int var4 = this.sliceLength(var1, var3);
      if (var4 < 0) {
         return null;
      } else {
         Object var5 = null;
         switch(this.sqlType) {
         case -104:
            var5 = new INTERVALDS[var4];
            break;
         case -103:
            var5 = new INTERVALYM[var4];
            break;
         case -102:
            var5 = new TIMESTAMPLTZ[var4];
            break;
         case -101:
            var5 = new TIMESTAMPTZ[var4];
            break;
         case -15:
         case -9:
            this.setNChar();
            var5 = new CHAR[var4];
            break;
         case -13:
            var5 = new BFILE[var4];
            break;
         case -2:
            var5 = new RAW[var4];
            break;
         case 0:
         case 2002:
         case 2003:
         case 2006:
         case 2007:
            if (this.old_factory == null) {
               var5 = new ORAData[var4];
            } else {
               var5 = new CustomDatum[var4];
            }
            break;
         case 1:
         case 12:
            var5 = new CHAR[var4];
            break;
         case 2:
         case 3:
         case 4:
         case 5:
         case 6:
         case 7:
         case 8:
            var5 = new NUMBER[var4];
            break;
         case 91:
            var5 = new DATE[var4];
            break;
         case 93:
            var5 = new TIMESTAMP[var4];
            break;
         case 100:
            var5 = new BINARY_FLOAT[var4];
            break;
         case 101:
            var5 = new BINARY_DOUBLE[var4];
            break;
         case 2004:
            var5 = new BLOB[var4];
            break;
         case 2005:
            var5 = new CLOB[var4];
            break;
         case 2011:
            var5 = new NCLOB[var4];
            break;
         default:
            SQLException var6 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 48);
            var6.fillInStackTrace();
            throw var6;
         }

         return this.getOracleArray(var1, (Object[])var5);
      }
   }

   public Object[] getOracleArray(long var1, Object[] var3) throws SQLException {
      if (var3 == null) {
         return null;
      } else {
         int var4 = this.sliceLength(var1, var3.length);
         int var5 = (int)var1;
         if (var4 != var3.length) {
            return null;
         } else {
            int var6;
            if (this.sqlType != 2002 && this.sqlType != 2007 && this.sqlType != 2003 && this.sqlType != 2006 && this.sqlType != 0) {
               for(var6 = 0; var6 < var4; ++var6) {
                  var3[var6] = this.getDatumElement((long)(var5++), (Connection)null);
               }
            } else if (this.old_factory == null) {
               for(var6 = 0; var6 < var4; ++var6) {
                  var3[var6] = this.factory.create(this.getDatumElement((long)(var5++), (Connection)null), this.sqlType);
               }
            } else {
               for(var6 = 0; var6 < var4; ++var6) {
                  var3[var6] = this.old_factory.create(this.getDatumElement((long)(var5++), (Connection)null), this.sqlType);
               }
            }

            return var3;
         }
      }
   }

   public Object[] getOracleArray(Object[] var1) throws SQLException {
      return this.getOracleArray(0L, var1);
   }

   public Object[] getObjectArray() throws SQLException {
      return this.getObjectArray(0L, Integer.MAX_VALUE);
   }

   public Object[] getObjectArray(long var1, int var3) throws SQLException {
      int var4 = this.sliceLength(var1, var3);
      if (var4 < 0) {
         return null;
      } else {
         Object var5;
         switch(this.sqlType) {
         case -15:
         case -9:
         case 1:
         case 12:
            var5 = new String[var4];
            break;
         case -2:
            var5 = new byte[var4][];
            break;
         case 2:
         case 3:
            var5 = new BigDecimal[var4];
            break;
         case 4:
         case 5:
            var5 = new Integer[var4];
            break;
         case 6:
         case 8:
            var5 = new Double[var4];
            break;
         case 7:
            var5 = new Float[var4];
            break;
         case 91:
            var5 = new Date[var4];
            break;
         case 93:
            var5 = new Timestamp[var4];
            break;
         default:
            return this.getOracleArray(var1, var3);
         }

         return this.getObjectArray(var1, (Object[])var5);
      }
   }

   public Object[] getObjectArray(long var1, Object[] var3) throws SQLException {
      if (var3 == null) {
         return null;
      } else {
         int var4 = this.sliceLength(var1, var3.length);
         int var5 = (int)var1;
         if (var4 != var3.length) {
            return null;
         } else {
            switch(this.sqlType) {
            case -15:
            case -9:
            case -2:
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 12:
            case 91:
            case 93:
               for(int var6 = 0; var6 < var4; ++var6) {
                  var3[var6] = this.getObjectElement((long)(var5++));
               }

               return var3;
            default:
               return this.getOracleArray(var1, var3);
            }
         }
      }
   }

   public Object[] getObjectArray(Object[] var1) throws SQLException {
      return this.getObjectArray(0L, var1);
   }

   public Object getArray() throws SQLException {
      return this.getArray(0L, Integer.MAX_VALUE);
   }

   public Object getArray(long var1, int var3) throws SQLException {
      int var4 = this.sliceLength(var1, var3);
      int var5 = (int)var1;
      if (var4 < 0) {
         return null;
      } else {
         float[] var6;
         int var7;
         switch(this.sqlType) {
         case 4:
            int[] var10 = new int[var4];

            for(var7 = 0; var7 < var4; ++var7) {
               var10[var7] = (Integer)this.getObjectElement((long)(var5++));
            }

            return var10;
         case 5:
            short[] var9 = new short[var4];

            for(var7 = 0; var7 < var4; ++var7) {
               var9[var7] = (short) this.getObjectElement((long)(var5++));
            }

            return var9;
         case 6:
         case 8:
         case 101:
            double[] var8 = new double[var4];

            for(var7 = 0; var7 < var4; ++var7) {
               var8[var7] = (Double)this.getObjectElement((long)(var5++));
            }

            return var8;
         case 7:
            var6 = new float[var4];

            for(var7 = 0; var7 < var4; ++var7) {
               var6[var7] = (Float)this.getObjectElement((long)(var5++));
            }

            return var6;
         case 100:
            var6 = new float[var4];

            for(var7 = 0; var7 < var4; ++var7) {
               var6[var7] = (Float)this.getObjectElement((long)(var5++));
            }

            return var6;
         default:
            return this.getObjectArray(var1, var3);
         }
      }
   }

   public void setOracleArray(Object[] var1) {
      if (this.factory == null && this.old_factory == null) {
         this.setDatumArray((Datum[])((Datum[])var1));
      } else {
         this.setObjectArray(var1);
      }

   }

   public void setOracleArray(Object[] var1, long var2) throws SQLException {
      if (this.factory == null && this.old_factory == null) {
         this.setDatumArray((Datum[])((Datum[])var1), var2);
      } else {
         this.setObjectArray(var1, var2);
      }

   }

   public void setObjectArray(Object[] var1) {
      if (var1 == null) {
         this.setNullArray();
      } else {
         this.setArrayGeneric(var1.length);
         this.elements = new Object[this.length];

         for(int var2 = 0; var2 < this.length; ++var2) {
            this.elements[var2] = var1[var2];
         }
      }

   }

   public void setObjectArray(Object[] var1, long var2) throws SQLException {
      if (var1 != null) {
         int var4 = this.sliceLength(var2, var1.length);
         int var5 = (int)var2;

         for(int var6 = 0; var6 < var4; ++var6) {
            this.setObjectElement(var1[var6], (long)(var5++));
         }

      }
   }

   public void setArray(double[] var1) {
      if (var1 == null) {
         this.setNullArray();
      } else {
         this.setArrayGeneric(var1.length);
         this.elements = new Object[this.length];

         for(int var2 = 0; var2 < this.length; ++var2) {
            this.elements[var2] = var1[var2];
         }
      }

   }

   public void setArray(double[] var1, long var2) throws SQLException {
      if (var1 != null) {
         int var4 = this.sliceLength(var2, var1.length);
         int var5 = (int)var2;

         for(int var6 = 0; var6 < var4; ++var6) {
            this.setObjectElement(var1[var6], (long)(var5++));
         }

      }
   }

   public void setArray(int[] var1) {
      if (var1 == null) {
         this.setNullArray();
      } else {
         this.setArrayGeneric(var1.length);
         this.elements = new Object[this.length];

         for(int var2 = 0; var2 < this.length; ++var2) {
            this.elements[var2] = var1[var2];
         }
      }

   }

   public void setArray(int[] var1, long var2) throws SQLException {
      if (var1 != null) {
         int var4 = this.sliceLength(var2, var1.length);
         int var5 = (int)var2;

         for(int var6 = 0; var6 < var4; ++var6) {
            this.setObjectElement(var1[var6], (long)(var5++));
         }

      }
   }

   public void setArray(float[] var1) {
      if (var1 == null) {
         this.setNullArray();
      } else {
         this.setArrayGeneric(var1.length);
         this.elements = new Object[this.length];

         for(int var2 = 0; var2 < this.length; ++var2) {
            this.elements[var2] = var1[var2];
         }
      }

   }

   public void setArray(float[] var1, long var2) throws SQLException {
      if (var1 != null) {
         int var4 = this.sliceLength(var2, var1.length);
         int var5 = (int)var2;

         for(int var6 = 0; var6 < var4; ++var6) {
            this.setObjectElement(var1[var6], (long)(var5++));
         }

      }
   }

   public void setArray(short[] var1) {
      if (var1 == null) {
         this.setNullArray();
      } else {
         this.setArrayGeneric(var1.length);
         this.elements = new Object[this.length];

         for(int var2 = 0; var2 < this.length; ++var2) {
            this.elements[var2] = Integer.valueOf(var1[var2]);
         }
      }

   }

   public void setArray(short[] var1, long var2) throws SQLException {
      if (var1 != null) {
         int var4 = this.sliceLength(var2, var1.length);
         int var5 = (int)var2;

         for(int var6 = 0; var6 < var4; ++var6) {
            this.setObjectElement(Integer.valueOf(var1[var6]), (long)(var5++));
         }

      }
   }

   public Object getObjectElement(long var1) throws SQLException {
      Object var3 = this.getLazyArray()[(int)var1];
      if (var3 == null) {
         Datum var4;
         if (this.old_factory == null) {
            var4 = this.getLazyOracleArray()[(int)var1];
            var3 = Util.convertToObject(var4, this.sqlType, this.factory);
            this.elements[(int)var1] = var3;
            if (Util.isMutable(var4, this.factory)) {
               this.resetOracleElement(var1);
            }
         } else {
            var4 = this.getLazyOracleArray()[(int)var1];
            var3 = Util.convertToObject(var4, this.sqlType, this.old_factory);
            this.elements[(int)var1] = var3;
            if (Util.isMutable(var4, this.old_factory)) {
               this.resetOracleElement(var1);
            }
         }
      }

      return var3;
   }

   public Object getOracleElement(long var1) throws SQLException {
      if (this.factory == null && this.old_factory == null) {
         Datum var3 = this.getDatumElement(var1, (Connection)null);
         if (Util.isMutable(var3, this.factory)) {
            this.pickledCorrect = false;
         }

         return var3;
      } else {
         return this.getObjectElement(var1);
      }
   }

   public void setObjectElement(Object var1, long var2) throws SQLException {
      if (var1 == null) {
         this.getLazyOracleArray();
      }

      this.resetOracleElement(var2);
      this.getLazyArray()[(int)var2] = var1;
   }

   public void setOracleElement(Object var1, long var2) throws SQLException {
      if (this.factory == null && this.old_factory == null) {
         this.setDatumElement((Datum)var1, var2);
      } else {
         this.setObjectElement(var1, var2);
      }

   }

   public String getBaseTypeName() throws SQLException {
      return this.pickled.getBaseTypeName();
   }

   public int getBaseType() throws SQLException {
      return this.pickled.getBaseType();
   }

   public ArrayDescriptor getDescriptor() throws SQLException {
      return this.pickled.getDescriptor();
   }

   Datum[] getDatumArray(Connection var1) throws SQLException {
      if (this.length < 0) {
         this.getLazyOracleArray();
      }

      if (this.datums == null) {
         return null;
      } else {
         Datum[] var2 = new Datum[this.length];

         for(int var3 = 0; var3 < this.length; ++var3) {
            var2[var3] = this.getDatumElement((long)var3, var1);
         }

         return var2;
      }
   }

   void setDatumArray(Datum[] var1) {
      if (var1 == null) {
         this.setNullArray();
      } else {
         this.length = var1.length;
         this.elements = null;
         this.datums = (Datum[])((Datum[])var1.clone());
         this.pickled = null;
         this.pickledCorrect = false;
      }

   }

   void setDatumArray(Datum[] var1, long var2) throws SQLException {
      if (var1 != null) {
         int var4 = this.sliceLength(var2, var1.length);
         int var5 = (int)var2;

         for(int var6 = 0; var6 < var4; ++var6) {
            this.setDatumElement(var1[var6], (long)(var5++));
         }

      }
   }

   Datum getDatumElement(long var1, Connection var3) throws SQLException {
      Datum var4 = this.getLazyOracleArray()[(int)var1];
      if (var4 == null) {
         Object var5 = this.getLazyArray()[(int)var1];
         var4 = Util.convertToOracle(var5, var3, this.isNChar);
         this.datums[(int)var1] = var4;
      }

      return var4;
   }

   void setDatumElement(Datum var1, long var2) throws SQLException {
      this.resetElement(var2);
      this.getLazyOracleArray()[(int)var2] = var1;
      this.pickledCorrect = false;
   }

   void resetElement(long var1) throws SQLException {
      if (this.elements != null) {
         this.elements[(int)var1] = null;
      }

   }

   void setNullArray() {
      this.length = -1;
      this.elements = null;
      this.datums = null;
      this.pickled = null;
      this.pickledCorrect = false;
   }

   void setArrayGeneric(int var1) {
      this.length = var1;
      this.datums = new Datum[var1];
      this.pickled = null;
      this.pickledCorrect = false;
   }

   public int length() throws SQLException {
      if (this.length < 0) {
         this.getLazyOracleArray();
      }

      return this.length;
   }

   public int sliceLength(long var1, int var3) throws SQLException {
      if (this.length < 0) {
         this.getLazyOracleArray();
      }

      return var1 < 0L ? (int)var1 : Math.min(this.length - (int)var1, var3);
   }

   void resetOracleElement(long var1) throws SQLException {
      if (this.datums != null) {
         this.datums[(int)var1] = null;
      }

      this.pickledCorrect = false;
   }

   Object[] getLazyArray() throws SQLException {
      if (this.length == -1) {
         this.getLazyOracleArray();
      }

      if (this.elements == null) {
         this.elements = new Object[this.length];
      }

      return this.elements;
   }

   Datum[] getLazyOracleArray() throws SQLException {
      if (this.datums == null) {
         if (this.pickled != null) {
            this.datums = (Datum[])this.pickled.getOracleArray();
            this.length = this.datums.length;
            this.pickledCorrect = true;
            if (this.elements != null) {
               for(int var1 = 0; var1 < this.length; ++var1) {
                  if (this.elements[var1] != null) {
                     this.datums[var1] = null;
                     this.pickledCorrect = false;
                  }
               }
            }
         } else if (this.length >= 0) {
            this.datums = new Datum[this.length];
         }
      }

      return this.datums;
   }

   public void setNChar() {
      this.isNChar = true;
   }

   protected oracle.jdbc.internal.OracleConnection getConnectionDuringExceptionHandling() {
      return null;
   }
}
