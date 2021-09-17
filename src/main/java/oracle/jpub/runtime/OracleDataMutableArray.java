package oracle.jpub.runtime;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Timestamp;
import oracle.jdbc.OracleArray;
import oracle.jdbc.OracleConnection;
import oracle.jdbc.OracleData;
import oracle.jdbc.OracleDataFactory;
import oracle.jdbc.driver.DatabaseError;
import oracle.sql.BFILE;
import oracle.sql.BINARY_DOUBLE;
import oracle.sql.BINARY_FLOAT;
import oracle.sql.BLOB;
import oracle.sql.CHAR;
import oracle.sql.CLOB;
import oracle.sql.DATE;
import oracle.sql.INTERVALDS;
import oracle.sql.INTERVALYM;
import oracle.sql.NUMBER;
import oracle.sql.RAW;
import oracle.sql.TIMESTAMP;
import oracle.sql.TIMESTAMPLTZ;
import oracle.sql.TIMESTAMPTZ;

public class OracleDataMutableArray {
   int length;
   Object[] elements;
   Object[] jdbcObjects;
   OracleArray pickled;
   boolean pickledCorrect;
   int sqlType;
   OracleDataFactory oracleDataFactory;
   boolean isNChar;
   private static final String _Copyright_2007_Oracle_All_Rights_Reserved_ = null;
   public static final String BUILD_DATE = "Thu_Apr_04_15:09:24_PDT_2013";
   public static final boolean TRACE = false;

   public OracleDataMutableArray(int var1, OracleArray var2, OracleDataFactory var3) {
      this.length = -1;
      this.elements = null;
      this.jdbcObjects = null;
      this.pickled = var2;
      this.pickledCorrect = true;
      this.isNChar = false;
      this.sqlType = var1;
      this.oracleDataFactory = var3;
   }

   public OracleDataMutableArray(int var1, Object[] var2, OracleDataFactory var3) {
      this.sqlType = var1;
      this.oracleDataFactory = var3;
      this.isNChar = false;
      this.setJDBCObjectArray(var2);
   }

   public OracleDataMutableArray(int var1, double[] var2, OracleDataFactory var3) {
      this.sqlType = var1;
      this.oracleDataFactory = var3;
      this.isNChar = false;
      this.setArray(var2);
   }

   public OracleDataMutableArray(int var1, int[] var2, OracleDataFactory var3) {
      this.sqlType = var1;
      this.oracleDataFactory = var3;
      this.isNChar = false;
      this.setArray(var2);
   }

   public OracleDataMutableArray(int var1, float[] var2, OracleDataFactory var3) {
      this.sqlType = var1;
      this.oracleDataFactory = var3;
      this.isNChar = false;
      this.setArray(var2);
   }

   public OracleDataMutableArray(int var1, short[] var2, OracleDataFactory var3) {
      this.sqlType = var1;
      this.oracleDataFactory = var3;
      this.isNChar = false;
      this.setArray(var2);
   }

   public Object toJDBCObject(Connection var1, String var2) throws SQLException {
      if (!this.pickledCorrect) {
         this.pickled = (OracleArray)((OracleConnection)var1).createOracleArray(var2, this.getJDBCObjectArray(var1));
         this.pickledCorrect = true;
      }

      return this.pickled;
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
            var5 = new OracleData[var4];
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
                  var3[var6] = this.getJDBCObjectElement((long)(var5++), (Connection)null);
               }
            } else if (this.oracleDataFactory != null) {
               for(var6 = 0; var6 < var4; ++var6) {
                  var3[var6] = this.oracleDataFactory.create(this.getJDBCObjectElement((long)(var5++), (Connection)null), this.sqlType);
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
         case -2:
            var5 = new byte[var4][];
            break;
         case 1:
         case 12:
            var5 = new String[var4];
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
      if (this.oracleDataFactory == null) {
         this.setJDBCObjectArray((Object[])var1);
      } else {
         this.setObjectArray(var1);
      }

   }

   public void setOracleArray(Object[] var1, long var2) throws SQLException {
      if (this.oracleDataFactory == null) {
         this.setJDBCObjectArray((Object[])var1, var2);
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
      if (var3 == null && this.oracleDataFactory != null) {
         Object var4 = this.getLazyOracleArray()[(int)var1];
         var3 = OracleDataUtil.convertToObject(var4, this.sqlType, this.oracleDataFactory);
         this.elements[(int)var1] = var3;
         if (OracleDataUtil.isMutable(var4, this.oracleDataFactory)) {
            this.resetOracleElement(var1);
         }
      }

      return var3;
   }

   public Object getOracleElement(long var1) throws SQLException {
      if (this.oracleDataFactory == null) {
         Object var3 = this.getJDBCObjectElement(var1, (Connection)null);
         if (OracleDataUtil.isMutable(var3, this.oracleDataFactory)) {
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
      if (this.oracleDataFactory == null) {
         this.setJDBCObjectElement(var1, var2);
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

   Object[] getJDBCObjectArray(Connection var1) throws SQLException {
      if (this.length < 0) {
         this.getLazyOracleArray();
      }

      if (this.jdbcObjects == null) {
         return null;
      } else {
         Object[] var2 = new Object[this.length];

         for(int var3 = 0; var3 < this.length; ++var3) {
            var2[var3] = this.getJDBCObjectElement((long)var3, var1);
         }

         return var2;
      }
   }

   void setJDBCObjectArray(Object[] var1) {
      if (var1 == null) {
         this.setNullArray();
      } else {
         this.length = var1.length;
         this.elements = null;
         this.jdbcObjects = (Object[])((Object[])var1.clone());
         this.pickled = null;
         this.pickledCorrect = false;
      }

   }

   void setJDBCObjectArray(Object[] var1, long var2) throws SQLException {
      if (var1 != null) {
         int var4 = this.sliceLength(var2, var1.length);
         int var5 = (int)var2;

         for(int var6 = 0; var6 < var4; ++var6) {
            this.setJDBCObjectElement(var1[var6], (long)(var5++));
         }

      }
   }

   Object getJDBCObjectElement(long var1, Connection var3) throws SQLException {
      Object var4 = this.getLazyOracleArray()[(int)var1];
      if (var4 == null) {
         Object var5 = this.getLazyArray()[(int)var1];
         var4 = OracleDataUtil.convertToOracle(var5, var3, this.isNChar);
         this.jdbcObjects[(int)var1] = var4;
      }

      return var4;
   }

   void setJDBCObjectElement(Object var1, long var2) throws SQLException {
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
      this.jdbcObjects = null;
      this.pickled = null;
      this.pickledCorrect = false;
   }

   void setArrayGeneric(int var1) {
      this.length = var1;
      this.jdbcObjects = new Object[var1];
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
      if (this.jdbcObjects != null) {
         this.jdbcObjects[(int)var1] = null;
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

   Object[] getLazyOracleArray() throws SQLException {
      if (this.jdbcObjects == null) {
         if (this.pickled != null) {
            this.jdbcObjects = (Object[])((Object[])this.pickled.getArray());
            this.length = this.jdbcObjects.length;
            this.pickledCorrect = true;
            if (this.elements != null) {
               for(int var1 = 0; var1 < this.length; ++var1) {
                  if (this.elements[var1] != null) {
                     this.jdbcObjects[var1] = null;
                     this.pickledCorrect = false;
                  }
               }
            }
         } else if (this.length >= 0) {
            this.jdbcObjects = new Object[this.length];
         }
      }

      return this.jdbcObjects;
   }

   public void setNChar() {
      this.isNChar = true;
   }

   protected oracle.jdbc.internal.OracleConnection getConnectionDuringExceptionHandling() {
      return null;
   }
}
