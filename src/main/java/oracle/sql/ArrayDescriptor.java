//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package oracle.sql;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLInput;
import java.sql.Timestamp;
import java.util.Map;
import oracle.jdbc.OracleConnection;
import oracle.jdbc.OraclePreparedStatement;
import oracle.jdbc.OracleResultSet;
import oracle.jdbc.OracleTypeMetaData.ArrayStorage;
import oracle.jdbc.OracleTypeMetaData.Kind;
import oracle.jdbc.driver.DatabaseError;
import oracle.jdbc.internal.OracleTypeMetaData.Array;
import oracle.jdbc.oracore.OracleNamedType;
import oracle.jdbc.oracore.OracleType;
import oracle.jdbc.oracore.OracleTypeADT;
import oracle.jdbc.oracore.OracleTypeCOLLECTION;
import oracle.jdbc.oracore.OracleTypeFLOAT;
import oracle.jdbc.oracore.OracleTypeNUMBER;
import oracle.jdbc.oracore.OracleTypeREF;

/** @deprecated */
public class ArrayDescriptor extends TypeDescriptor implements Array, Serializable {
    public static final int TYPE_VARRAY = 3;
    public static final int TYPE_NESTED_TABLE = 2;
    public static final int CACHE_NONE = 0;
    public static final int CACHE_ALL = 1;
    public static final int CACHE_LAST = 2;
    static final long serialVersionUID = 3838105394346513809L;
    private static final String _Copyright_2007_Oracle_All_Rights_Reserved_ = null;
    public static final String BUILD_DATE = "Thu_Apr_04_15:09:24_PDT_2013";
    public static final boolean TRACE = false;

    public static ArrayDescriptor createDescriptor(String var0, Connection var1) throws SQLException {
        return createDescriptor(var0, var1, false, false);
    }

    public static ArrayDescriptor createDescriptor(String var0, Connection var1, boolean var2, boolean var3) throws SQLException {
        if (var0 != null && var0.length() != 0 && var1 != null) {
            SQLName var8 = new SQLName(var0, (OracleConnection)var1);
            String var5 = var8.getName();
            ArrayDescriptor var6 = null;
            if (!var3) {
                var6 = (ArrayDescriptor)((OracleConnection)var1).getDescriptor(var5);
            }

            if (var6 == null) {
                short var7 = ((OracleConnection)var1).physicalConnectionWithin().getVersionNumber();
                if (var7 >= 12000) {
                    var6 = new ArrayDescriptor(var0, var1);
                } else {
                    var6 = new ArrayDescriptor(var8, var1);
                }

                if (var2) {
                    var6.initNamesRecursively();
                }

                ((OracleConnection)var1).putDescriptor(var5, var6);
            }

            return var6;
        } else {
            SQLException var4 = DatabaseError.createSqlException((oracle.jdbc.internal.OracleConnection)null, 60, "ArrayDescriptor.createDescriptor: Invalid argument,'name' should not be an empty string and 'conn' should not be null.");
            var4.fillInStackTrace();
            throw var4;
        }
    }

    public static ArrayDescriptor createDescriptor(SQLName var0, Connection var1) throws SQLException {
        return createDescriptor(var0, var1, false, false);
    }

    public static ArrayDescriptor createDescriptor(SQLName var0, Connection var1, boolean var2, boolean var3) throws SQLException {
        String var4 = var0.getName();
        ArrayDescriptor var5 = null;
        if (!var3) {
            var5 = (ArrayDescriptor)((OracleConnection)var1).getDescriptor(var4);
        }

        if (var5 == null) {
            var5 = new ArrayDescriptor(var0, var1);
            if (var2) {
                var5.initNamesRecursively();
            }

            ((OracleConnection)var1).putDescriptor(var4, var5);
        }

        return var5;
    }

    public static ArrayDescriptor createDescriptor(OracleTypeCOLLECTION var0) throws SQLException {
        String var1 = var0.getFullName();
        oracle.jdbc.internal.OracleConnection var2 = var0.getConnection();
        ArrayDescriptor var3 = (ArrayDescriptor)var2.getDescriptor(var1);
        if (var3 == null) {
            SQLName var4 = new SQLName(var0.getSchemaName(), var0.getSimpleName(), var0.getConnection());
            var3 = new ArrayDescriptor(var4, var0, var2);
            var2.putDescriptor(var1, var3);
        }

        return var3;
    }

    public static ArrayDescriptor createDescriptor(SQLName var0, byte[] var1, int var2, byte[] var3, oracle.jdbc.internal.OracleConnection var4) throws SQLException {
        OracleTypeADT var5 = new OracleTypeADT(var0, var1, var2, var3, var4);
        var5.init(var3, var4);
        OracleTypeCOLLECTION var6 = (OracleTypeCOLLECTION)((OracleTypeCOLLECTION)var5.cleanup());
        return new ArrayDescriptor(var0, var6, var4);
    }

    public ArrayDescriptor(String var1, Connection var2) throws SQLException {
        super((short)122, var1, var2);
        this.initPickler();
    }

    public ArrayDescriptor(SQLName var1, Connection var2) throws SQLException {
        super((short)122, var1, var2);
        this.initPickler();
    }

    public ArrayDescriptor(SQLName var1, OracleTypeCOLLECTION var2, Connection var3) throws SQLException {
        super((short)122, var1, var2, var3);
    }

    public ArrayDescriptor(OracleTypeCOLLECTION var1, Connection var2) throws SQLException {
        super((short)122, var1, var2);
    }

    ArrayDescriptor(byte[] var1, int var2, Connection var3) throws SQLException {
        super((short)122);
        this.toid = var1;
        this.toidVersion = var2;
        this.setPhysicalConnectionOf(var3);
        this.initPickler();
    }

    public Kind getKind() {
        return Kind.ARRAY;
    }

    public int getBaseType() throws SQLException {
        return ((OracleTypeCOLLECTION)this.pickler).getElementType().getTypeCode();
    }

    public String getBaseName() throws SQLException {
        String var1 = null;
        OracleNamedType var2;
        switch(this.getBaseType()) {
            case -104:
                var1 = "INTERVALDS";
                break;
            case -103:
                var1 = "INTERVALYM";
                break;
            case -102:
                var1 = "TIMESTAMP WITH LOCAL TIME ZONE";
                break;
            case -101:
                var1 = "TIMESTAMP WITH TIME ZONE";
                break;
            case -15:
                var1 = "NCHAR";
                break;
            case -13:
                var1 = "BFILE";
                break;
            case -9:
                var1 = "NVARCHAR";
                break;
            case -2:
                var1 = "RAW";
                break;
            case 1:
                var1 = "CHAR";
                break;
            case 2:
                var1 = "NUMBER";
                break;
            case 3:
                var1 = "DECIMAL";
                break;
            case 6:
                var1 = "FLOAT";
                break;
            case 8:
                var1 = "DOUBLE";
                break;
            case 12:
                var1 = "VARCHAR";
                break;
            case 91:
                var1 = "DATE";
                break;
            case 93:
                var1 = "TIMESTAMP";
                break;
            case 100:
                var1 = "BINARY_FLOAT";
                break;
            case 101:
                var1 = "BINARY_DOUBLE";
                break;
            case 1111:
            default:
                var1 = null;
                break;
            case 2002:
            case 2003:
            case 2007:
            case 2008:
                var2 = (OracleNamedType)((OracleTypeCOLLECTION)this.pickler).getElementType();
                var1 = var2.getFullName();
                break;
            case 2004:
                var1 = "BLOB";
                break;
            case 2005:
                var1 = "CLOB";
                break;
            case 2006:
                var2 = (OracleNamedType)((OracleTypeCOLLECTION)this.pickler).getElementType();
                var1 = "REF " + ((OracleTypeREF)var2).getFullName();
                break;
            case 2011:
                var1 = "NCLOB";
        }

        return var1;
    }

    public OracleTypeCOLLECTION getOracleTypeCOLLECTION() {
        return (OracleTypeCOLLECTION)this.pickler;
    }

    public ArrayStorage getArrayStorage() throws SQLException {
        return ArrayStorage.withCode(this.getArrayType());
    }

    public int getArrayType() throws SQLException {
        return ((OracleTypeCOLLECTION)this.pickler).getUserCode();
    }

    public long getMaxLength() throws SQLException {
        return this.getArrayType() == 3 ? ((OracleTypeCOLLECTION)this.pickler).getMaxLength() : 0L;
    }

    public String descType() throws SQLException {
        StringBuffer var1 = new StringBuffer();
        return this.descType(var1, 0);
    }

    String descType(StringBuffer var1, int var2) throws SQLException {
        String var3 = "";

        for(int var4 = 0; var4 < var2; ++var4) {
            var3 = var3 + "  ";
        }

        String var7 = var3 + "  ";
        var1.append(var3);
        var1.append(this.getTypeName());
        var1.append("\n");
        int var5 = this.getBaseType();
        if (var5 != 2002 && var5 != 2008) {
            if (var5 == 2003) {
                ArrayDescriptor var8 = createDescriptor((String)this.getBaseName(), this.connection);
                var8.descType(var1, var2 + 1);
            } else if (var5 == 2007) {
                OpaqueDescriptor var9 = OpaqueDescriptor.createDescriptor(this.getBaseName(), this.connection);
                var9.descType(var1, var2 + 1);
            } else {
                var1.append(var7);
                var1.append(this.getBaseName());
                var1.append("\n");
            }
        } else {
            StructDescriptor var6 = StructDescriptor.createDescriptor(this.getBaseName(), this.connection);
            var6.descType(var1, var2 + 1);
        }

        return var1.substring(0, var1.length());
    }

    int toLength(ARRAY var1) throws SQLException {
        if (var1.numElems == -1) {
            if (var1.datumArray != null) {
                var1.numElems = var1.datumArray.length;
            } else if (var1.objArray != null) {
                if (var1.objArray instanceof Object[]) {
                    var1.numElems = ((Object[])((Object[])var1.objArray)).length;
                } else if (var1.objArray instanceof int[]) {
                    var1.numElems = ((long[])((long[])var1.objArray)).length;
                } else if (var1.objArray instanceof long[]) {
                    var1.numElems = ((float[])((float[])var1.objArray)).length;
                } else if (var1.objArray instanceof float[]) {
                    var1.numElems = ((double[])((double[])var1.objArray)).length;
                } else if (var1.objArray instanceof double[]) {
                    var1.numElems = ((boolean[])((boolean[])var1.objArray)).length;
                } else if (var1.objArray instanceof boolean[]) {
                    var1.numElems = ((int[])((int[])var1.objArray)).length;
                } else if (var1.objArray instanceof byte[]) {
                    var1.numElems = ((byte[])((byte[])var1.objArray)).length;
                } else if (var1.objArray instanceof short[]) {
                    var1.numElems = ((short[])((short[])var1.objArray)).length;
                } else if (var1.objArray instanceof char[]) {
                    var1.numElems = ((char[])((char[])var1.objArray)).length;
                }
            } else if (var1.locator != null) {
                var1.numElems = this.toLengthFromLocator(var1.locator);
            } else {
                SQLException var2;
                if (var1.shareBytes() == null) {
                    var2 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 1, "Array is in inconsistent status");
                    var2.fillInStackTrace();
                    throw var2;
                }

                this.pickler.unlinearize(var1.shareBytes(), var1.imageOffset, var1, 0, (Map)null);
                if (var1.numElems == -1) {
                    if (var1.locator == null) {
                        var2 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 1, "Unable to get array length");
                        var2.fillInStackTrace();
                        throw var2;
                    }

                    var1.numElems = this.toLengthFromLocator(var1.locator);
                }
            }
        }

        return var1.numElems;
    }

    byte[] toBytes(ARRAY var1, boolean var2) throws SQLException {
        byte[] var3 = var1.shareBytes();
        if (var3 == null) {
            if (var1.datumArray == null && var1.locator == null) {
                if (var1.objArray == null) {
                    SQLException var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 1, "Array is in inconsistent status");
                    var4.fillInStackTrace();
                    throw var4;
                }

                var1.datumArray = this.toOracleArray(var1.objArray, 1L, -1);
                var3 = this.pickler.linearize(var1);
                if (!var2) {
                    var1.datumArray = null;
                    var1.setShareBytes((byte[])null);
                }
            } else {
                var3 = this.pickler.linearize(var1);
                if (!var2) {
                    var1.setShareBytes((byte[])null);
                }
            }
        } else if (var1.imageLength != 0L && (var1.imageOffset != 0L || var1.imageLength != (long)var3.length)) {
            byte[] var5 = new byte[(int)var1.imageLength];
            System.arraycopy(var3, (int)var1.imageOffset, var5, 0, (int)var1.imageLength);
            var1.setImage(var5, 0L, 0L);
            return var5;
        }

        return var3;
    }

    Datum[] toOracleArray(ARRAY var1, long var2, int var4, boolean var5) throws SQLException {
        Datum[] var6 = var1.datumArray;
        SQLException var7;
        if (var6 == null) {
            if (var1.objArray != null) {
                var6 = this.toOracleArray(var1.objArray, var2, var4);
            } else if (var1.locator != null) {
                var6 = this.toOracleArrayFromLocator(var1.locator, var2, var4, (Map)null);
            } else {
                if (var1.shareBytes() == null) {
                    var7 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 1, "Array is in inconsistent status.");
                    var7.fillInStackTrace();
                    throw var7;
                }

                this.pickler.unlinearize(var1.shareBytes(), var1.imageOffset, var1, var2, var4, 1, (Map)null);
                if (var1.locator != null) {
                    var6 = this.toOracleArrayFromLocator(var1.locator, var2, var4, (Map)null);
                } else {
                    var6 = var1.datumArray;
                }

                if (!var5) {
                    var1.datumArray = null;
                }
            }
        } else {
            if (var2 > (long)var6.length) {
                return new Datum[0];
            }

            int var8 = (int)(var4 == -1 ? (long)var6.length - var2 + 1L : Math.min((long)var6.length - var2 + 1L, (long)var4));
            var6 = new Datum[var8];
            System.arraycopy(var1.datumArray, (int)var2 - 1, var6, 0, var8);
        }

        var7 = null;
        Datum[] var9;
        if (var5) {
            var1.datumArray = var6;
            var9 = (Datum[])((Datum[])var6.clone());
        } else {
            var9 = var6;
        }

        return var9;
    }

    Object[] toJavaArray(ARRAY var1, long var2, int var4, Map var5, boolean var6) throws SQLException {
        Object[] var7 = null;
        if (var1.objArray != null) {
            var7 = (Object[])((Object[])((Object[])((Object[])var1.objArray)).clone());
            int var8 = var7.length;
            int var9 = (int)(var4 == -1 ? (long)var8 - var2 + 1L : Math.min((long)var8 - var2 + 1L, (long)var4));
            if (var9 <= 0) {
                Object[] var10 = (Object[])makeJavaArray(var9, this.getBaseType());
                return var10;
            }

            var7 = (Object[])makeJavaArray(var9, this.getBaseType());
            System.arraycopy(var1.objArray, (int)var2 - 1, var7, 0, var9);
        } else {
            if (var1.datumArray != null) {
                var7 = (Object[])((Object[])this.toJavaArray(var1.datumArray, var2, var4, var5));
            } else if (var1.locator != null) {
                var7 = this.toArrayFromLocator(var1.locator, var2, var4, var5);
            } else {
                if (var1.shareBytes() == null) {
                    SQLException var11 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 1, "Array is in inconsistent status");
                    var11.fillInStackTrace();
                    throw var11;
                }

                this.pickler.unlinearize(var1.shareBytes(), var1.imageOffset, var1, var2, var4, 2, var5);
                if (var1.locator != null) {
                    var7 = this.toArrayFromLocator(var1.locator, var2, var4, var5);
                } else {
                    var7 = (Object[])((Object[])var1.objArray);
                }
            }

            if (var6 && this.getBaseType() != 2002 && this.getBaseType() != 2008 && var7 != null) {
                var1.objArray = var7.clone();
            } else {
                var1.objArray = null;
            }
        }

        return var7;
    }

    private Datum[] toOracleArrayFromLocator(byte[] var1, long var2, int var4, Map var5) throws SQLException {
        int var6 = this.toLengthFromLocator(var1);
        int var7 = (int)(var4 == -1 ? (long)var6 - var2 + 1L : Math.min((long)var6 - var2 + 1L, (long)var4));
        Datum[] var8 = null;
        if (var7 <= 0) {
            var8 = new Datum[0];
        } else {
            var8 = new Datum[var7];
            ResultSet var9 = this.toResultSetFromLocator(var1, var2, var4, var5);

            for(int var10 = 0; var9.next(); ++var10) {
                var8[var10] = ((OracleResultSet)var9).getOracleObject(2);
            }

            var9.close();
        }

        return var8;
    }

    private Object[] toArrayFromLocator(byte[] var1, long var2, int var4, Map var5) throws SQLException {
        int var6 = this.toLengthFromLocator(var1);
        int var7 = (int)(var4 == -1 ? (long)var6 - var2 + 1L : Math.min((long)var6 - var2 + 1L, (long)var4));
        Object[] var8 = null;
        if (var7 <= 0) {
            var8 = (Object[])makeJavaArray(0, this.getBaseType());
        } else {
            var8 = (Object[])makeJavaArray(var7, this.getBaseType());
            ResultSet var9 = this.toResultSetFromLocator(var1, var2, var4, var5);

            for(int var10 = 0; var9.next(); ++var10) {
                var8[var10] = ((OracleResultSet)var9).getObject(2, var5);
            }

            var9.close();
        }

        return var8;
    }

    public ResultSet toResultSet(ARRAY var1, long var2, int var4, Map var5, boolean var6) throws SQLException {
        ResultSet var7 = null;
        SQLException var8;
        if (var1.datumArray != null) {
            var7 = this.toResultSet(var1.datumArray, var2, var4, var5);
        } else if (var1.locator != null) {
            var7 = this.toResultSetFromLocator(var1.locator, var2, var4, var5);
        } else if (var1.objArray != null) {
            var7 = this.toResultSet((Datum[])this.toOracleArray(var1.objArray, var2, var4), 1L, -1, var5);
        } else if (var1.shareBytes() != null) {
            if (((OracleTypeCOLLECTION)this.pickler).isInlineImage(var1.shareBytes(), (int)var1.imageOffset)) {
                var7 = this.toResultSetFromImage(var1, var2, var4, var5);
            } else {
                this.pickler.unlinearize(var1.shareBytes(), var1.imageOffset, var1, 1, (Map)null);
                if (var1.locator == null) {
                    var8 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 1, "Array is in inconsistent status");
                    var8.fillInStackTrace();
                    throw var8;
                }

                var7 = this.toResultSetFromLocator(var1.locator, var2, var4, var5);
            }
        }

        if (var7 == null) {
            var8 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 1, "Unable to create array ResultSet");
            var8.fillInStackTrace();
            throw var8;
        } else {
            return var7;
        }
    }

    public ResultSet toResultSet(Datum[] var1, long var2, int var4, Map var5) throws SQLException {
        ResultSet var6 = null;
        if (var4 == -1) {
            var6 = this.connection.newArrayDataResultSet(var1, var2, var1.length, var5);
        } else {
            var6 = this.connection.newArrayDataResultSet(var1, var2, var4, var5);
        }

        return var6;
    }

    public ResultSet toResultSetFromLocator(byte[] var1, long var2, int var4, Map var5) throws SQLException {
        ResultSet var6 = this.connection.newArrayLocatorResultSet(this, var1, var2, var4, var5);
        return var6;
    }

    public ResultSet toResultSetFromImage(ARRAY var1, long var2, int var4, Map var5) throws SQLException {
        ResultSet var6 = this.connection.newArrayDataResultSet(var1, var2, var4, var5);
        return var6;
    }

    public static Object[] makeJavaArray(int var0, int var1) throws SQLException {
        Object var2 = null;
        switch(var1) {
            case -104:
                var2 = new INTERVALDS[var0];
                break;
            case -103:
                var2 = new INTERVALYM[var0];
                break;
            case -102:
            case -101:
            case 91:
            case 92:
            case 93:
                var2 = new Timestamp[var0];
                break;
            case -15:
            case -9:
            case 1:
            case 12:
                var2 = new String[var0];
                break;
            case -13:
                var2 = new BFILE[var0];
                break;
            case -7:
            case -6:
            case -5:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
                var2 = new BigDecimal[var0];
                break;
            case -3:
            case -2:
                var2 = new byte[var0][];
                break;
            case 100:
                var2 = new Float[var0];
                break;
            case 101:
                var2 = new Double[var0];
                break;
            case 2002:
            case 2008:
                var2 = new Object[var0];
                break;
            case 2003:
                var2 = new Object[var0];
                break;
            case 2004:
                var2 = new BLOB[var0];
                break;
            case 2005:
            case 2011:
                var2 = new CLOB[var0];
                break;
            case 2006:
                var2 = new REF[var0];
                break;
            default:
                SQLException var3 = DatabaseError.createSqlException((oracle.jdbc.internal.OracleConnection)null, 1, "makeJavaArray doesn't support type " + var1);
                var3.fillInStackTrace();
                throw var3;
        }

        return (Object[])var2;
    }

    private int toLengthFromLocator(byte[] var1) throws SQLException {
        ARRAY var2 = new ARRAY(this, this.connection, (byte[])null);
        var2.setLocator(var1);
        boolean var3 = false;
        OraclePreparedStatement var4 = null;
        OracleResultSet var5 = null;
        var4 = (OraclePreparedStatement)this.connection.prepareStatement("SELECT count(*) FROM TABLE( CAST(:1 AS " + this.getName() + ") )");
        var4.setArray(1, (java.sql.Array) var2);
        var5 = (OracleResultSet)var4.executeQuery();
        if (var5.next()) {
            int var7 = var5.getInt(1);
            var5.close();
            var4.close();
            return var7;
        } else {
            SQLException var6 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 1, "Fail to access array storage table");
            var6.fillInStackTrace();
            throw var6;
        }
    }

    Datum[] toOracleArray(Object var1, long var2, int var4) throws SQLException {
        Datum[] var5 = null;
        if (var1 != null) {
            OracleType var6 = this.getElementType();
            var5 = var6.toDatumArray(var1, this.connection, var2, var4);
        }

        return var5;
    }

    private Object toJavaArray(Datum[] var1, long var2, int var4, Map var5) throws SQLException {
        int var6 = (int)(var4 == -1 ? (long)var1.length - var2 + 1L : Math.min((long)var1.length - var2 + 1L, (long)var4));
        if (var6 < 0) {
            var6 = 0;
        }

        Object[] var7 = (Object[])makeJavaArray(var6, this.getBaseType());
        STRUCT var8;
        int var9;
        if (this.getBaseType() == 2002) {
            var8 = null;

            for(var9 = 0; var9 < var6; ++var9) {
                var8 = (STRUCT)var1[(int)var2 + var9 - 1];
                var7[var9] = var8 != null ? var8.toJdbc(var5) : null;
            }
        } else {
            var8 = null;

            for(var9 = 0; var9 < var6; ++var9) {
                Datum var10 = var1[(int)var2 + var9 - 1];
                var7[var9] = var10 != null ? var10.toJdbc() : null;
            }
        }

        return var7;
    }

    private Object toNumericArray(Datum[] var1, long var2, int var4, int var5) throws SQLException {
        Object var6 = null;
        int var7 = (int)(var4 == -1 ? (long)var1.length - var2 + 1L : Math.min((long)var1.length - var2 + 1L, (long)var4));
        if (var7 < 0) {
            var7 = 0;
        }

        int var9;
        Datum var10;
        switch(var5) {
            case 4:
                int[] var14 = new int[var7];

                for(var9 = 0; var9 < var7; ++var9) {
                    var10 = var1[(int)var2 + var9 - 1];
                    if (var10 != null) {
                        var14[var9] = var10.intValue();
                    }
                }

                var6 = var14;
                break;
            case 5:
                double[] var13 = new double[var7];

                for(var9 = 0; var9 < var7; ++var9) {
                    var10 = var1[(int)var2 + var9 - 1];
                    if (var10 != null) {
                        var13[var9] = var10.doubleValue();
                    }
                }

                var6 = var13;
                break;
            case 6:
                float[] var12 = new float[var7];

                for(var9 = 0; var9 < var7; ++var9) {
                    var10 = var1[(int)var2 + var9 - 1];
                    if (var10 != null) {
                        var12[var9] = var10.floatValue();
                    }
                }

                var6 = var12;
                break;
            case 7:
                long[] var11 = new long[var7];

                for(var9 = 0; var9 < var7; ++var9) {
                    var10 = var1[(int)var2 + var9 - 1];
                    if (var10 != null) {
                        var11[var9] = var10.longValue();
                    }
                }

                var6 = var11;
                break;
            case 8:
                short[] var8 = new short[var7];

                for(var9 = 0; var9 < var7; ++var9) {
                    var10 = var1[(int)var2 + var9 - 1];
                    if (var10 != null) {
                        var8[var9] = ((NUMBER)var10).shortValue();
                    }
                }

                var6 = var8;
                break;
            default:
                SQLException var15 = DatabaseError.createUnsupportedFeatureSqlException();
                var15.fillInStackTrace();
                throw var15;
        }

        return var6;
    }

    private Object toNumericArrayFromLocator(byte[] var1, long var2, int var4, int var5) throws SQLException {
        Object var6 = null;
        int var7 = this.toLengthFromLocator(var1);
        ResultSet var8 = this.toResultSetFromLocator(var1, var2, var4, (Map)null);
        int var9 = 0;
        switch(var5) {
            case 4:
                int[] var14;
                for(var14 = new int[var7]; var8.next() && var9 < var7; var14[var9++] = ((OracleResultSet)var8).getInt(2)) {
                }

                var8.close();
                var6 = var14;
                break;
            case 5:
                double[] var13;
                for(var13 = new double[var7]; var8.next() && var9 < var7; var13[var9++] = ((OracleResultSet)var8).getDouble(2)) {
                }

                var8.close();
                var6 = var13;
                break;
            case 6:
                float[] var12;
                for(var12 = new float[var7]; var8.next() && var9 < var7; var12[var9++] = ((OracleResultSet)var8).getFloat(2)) {
                }

                var8.close();
                var6 = var12;
                break;
            case 7:
                long[] var11;
                for(var11 = new long[var7]; var8.next() && var9 < var7; var11[var9++] = ((OracleResultSet)var8).getLong(2)) {
                }

                var8.close();
                var6 = var11;
                break;
            case 8:
                short[] var10;
                for(var10 = new short[var7]; var8.next() && var9 < var7; var10[var9++] = ((OracleResultSet)var8).getShort(2)) {
                }

                var8.close();
                var6 = var10;
                break;
            default:
                SQLException var15 = DatabaseError.createUnsupportedFeatureSqlException();
                var15.fillInStackTrace();
                throw var15;
        }

        return var6;
    }

    Object toNumericArray(ARRAY var1, long var2, int var4, int var5, boolean var6) throws SQLException {
        OracleType var7 = this.getElementType();
        if (!(var7 instanceof OracleTypeNUMBER) && !(var7 instanceof OracleTypeFLOAT)) {
            SQLException var15 = DatabaseError.createUnsupportedFeatureSqlException();
            var15.fillInStackTrace();
            throw var15;
        } else {
            Object var8 = null;
            if (var1.objArray != null) {
                int var9;
                if (var5 == 4 && var1.objArray instanceof int[]) {
                    var9 = ((int[])((int[])var1.objArray)).length;
                    if (var2 > (long)var9) {
                        return new int[0];
                    }

                    var9 = (int)(var4 == -1 ? (long)var9 - var2 + 1L : Math.min((long)var9 - var2 + 1L, (long)var4));
                    int[] var14 = new int[var9];
                    System.arraycopy(var1.objArray, (int)var2 - 1, var14, 0, var9);
                    var8 = var14;
                } else if (var5 == 5 && var1.objArray instanceof double[]) {
                    var9 = ((double[])((double[])var1.objArray)).length;
                    if (var2 > (long)var9) {
                        return new double[0];
                    }

                    var9 = (int)(var4 == -1 ? (long)var9 - var2 + 1L : Math.min((long)var9 - var2 + 1L, (long)var4));
                    double[] var13 = new double[var9];
                    System.arraycopy(var1.objArray, (int)var2 - 1, var13, 0, var9);
                    var8 = var13;
                } else if (var5 == 6 && var1.objArray instanceof float[]) {
                    var9 = ((float[])((float[])var1.objArray)).length;
                    if (var2 > (long)var9) {
                        return new float[0];
                    }

                    var9 = (int)(var4 == -1 ? (long)var9 - var2 + 1L : Math.min((long)var9 - var2 + 1L, (long)var4));
                    float[] var12 = new float[var9];
                    System.arraycopy(var1.objArray, (int)var2 - 1, var12, 0, var9);
                    var8 = var12;
                } else if (var5 == 7 && var1.objArray instanceof long[]) {
                    var9 = ((long[])((long[])var1.objArray)).length;
                    if (var2 > (long)var9) {
                        return new long[0];
                    }

                    var9 = (int)(var4 == -1 ? (long)var9 - var2 + 1L : Math.min((long)var9 - var2 + 1L, (long)var4));
                    long[] var11 = new long[var9];
                    System.arraycopy(var1.objArray, (int)var2 - 1, var11, 0, var9);
                    var8 = var11;
                } else if (var5 == 8 && var1.objArray instanceof short[]) {
                    var9 = ((short[])((short[])var1.objArray)).length;
                    if (var2 > (long)var9) {
                        return new short[0];
                    }

                    var9 = (int)(var4 == -1 ? (long)var9 - var2 + 1L : Math.min((long)var9 - var2 + 1L, (long)var4));
                    short[] var10 = new short[var9];
                    System.arraycopy(var1.objArray, (int)var2 - 1, var10, 0, var9);
                    var8 = var10;
                }
            } else {
                if (var1.datumArray != null) {
                    var8 = this.toNumericArray(var1.datumArray, var2, var4, var5);
                } else if (var1.locator != null) {
                    var8 = this.toNumericArrayFromLocator(var1.locator, var2, var4, var5);
                } else {
                    if (var1.shareBytes() == null) {
                        SQLException var16 = DatabaseError.createUnsupportedFeatureSqlException();
                        var16.fillInStackTrace();
                        throw var16;
                    }

                    this.pickler.unlinearize(var1.shareBytes(), var1.imageOffset, var1, var2, var4, var5, (Map)null);
                    if (var1.locator != null) {
                        var8 = this.toNumericArrayFromLocator(var1.locator, var2, var4, var5);
                    } else {
                        var8 = var1.objArray;
                    }
                }

                if (!var6) {
                    var1.objArray = null;
                }
            }

            return var8;
        }
    }

    private void initPickler() throws SQLException {
        try {
            OracleTypeADT var1 = new OracleTypeADT(this.getName(), this.connection);
            var1.init(this.connection);
            this.pickler = (OracleTypeCOLLECTION)var1.cleanup();
            this.toid = ((OracleTypeADT)this.pickler).getTOID();
            this.pickler.setDescriptor(this);
        } catch (Exception var3) {
            if (var3 instanceof SQLException) {
                throw (SQLException)var3;
            } else {
                SQLException var2 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 60, "Unable to resolve type: \"" + this.getName() + "\"");
                var2.fillInStackTrace();
                throw var2;
            }
        }
    }

    private OracleType getElementType() throws SQLException {
        OracleType var1 = ((OracleTypeCOLLECTION)this.pickler).getElementType();
        return var1;
    }

    public int getTypeCode() throws SQLException {
        short var1 = 2003;
        return var1;
    }

    public SQLInput toJdbcToSQLInput(ARRAY var1, Map var2) throws SQLException {
        return new OracleJdbc2SQLInput(this.toOracleArray(var1, 0L, var1.length(), false), var2, this.connection);
    }

    public byte[] toBytes(Datum[] var1) throws SQLException {
        ARRAY var2 = new ARRAY(this, this.connection, var1);
        return this.pickler.linearize(var2);
    }

    public byte[] toBytes(Object[] var1) throws SQLException {
        Datum[] var2 = this.toArray((Object)var1);
        byte[] var3 = this.toBytes(var2);
        return var3;
    }

    public int length(byte[] var1) throws SQLException {
        ARRAY var2 = new ARRAY(this, this.connection, var1);
        int var3 = this.toLength(var2);
        return var3;
    }

    public Datum[] toArray(byte[] var1) throws SQLException {
        Datum[] var2 = null;
        if (var1 != null) {
            ARRAY var3 = new ARRAY(this, this.connection, var1);
            var2 = this.toOracleArray(var3, 1L, -1, false);
        }

        return var2;
    }

    public Datum[] toArray(Object var1) throws SQLException {
        Datum[] var2 = this.toOracleArray(var1, 1L, -1);
        return var2;
    }

    public ResultSet toResultSet(byte[] var1, Map var2) throws SQLException {
        ResultSet var3 = null;
        if (var1 != null) {
            ARRAY var4 = (ARRAY)this.pickler.unlinearize(var1, 0L, (Datum)null, 1, (Map)null);
            var3 = this.toResultSet(var4, 1L, -1, var2, false);
        }

        return var3;
    }

    public ResultSet toResultSet(byte[] var1, long var2, int var4, Map var5) throws SQLException {
        ResultSet var6 = null;
        if (var1 != null) {
            ARRAY var7 = (ARRAY)this.pickler.unlinearize(var1, 0L, (ARRAY)null, 1, (Map)null);
            var6 = this.toResultSet(var7, var2, var4, var5, false);
        }

        return var6;
    }

    String tagName() {
        return "ArrayDescriptor";
    }

    public static int getCacheStyle(ARRAY var0) throws SQLException {
        byte var1 = 2;
        if (var0.getAutoIndexing() && (var0.getAccessDirection() == 2 || var0.getAccessDirection() == 3)) {
            var1 = 1;
        }

        return var1;
    }

    private void writeObject(ObjectOutputStream var1) throws IOException {
    }

    private void readObject(ObjectInputStream var1) throws IOException, ClassNotFoundException {
    }
}
