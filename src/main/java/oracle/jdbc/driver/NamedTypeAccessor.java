//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package oracle.jdbc.driver;

import java.sql.SQLException;
import java.sql.SQLXML;
import java.sql.Struct;
import java.util.Map;
import oracle.jdbc.OracleData;
import oracle.jdbc.oracore.OracleType;
import oracle.jdbc.oracore.OracleTypeADT;
import oracle.sql.ARRAY;
import oracle.sql.ArrayDescriptor;
import oracle.sql.Datum;
import oracle.sql.JAVA_STRUCT;
import oracle.sql.OPAQUE;
import oracle.sql.ORAData;
import oracle.sql.OpaqueDescriptor;
import oracle.sql.STRUCT;
import oracle.sql.StructDescriptor;
import oracle.sql.TypeDescriptor;
import oracle.xdb.XMLType;

class NamedTypeAccessor extends TypeAccessor {
    static final int MAXLENGTH = -1;
    private static final String _Copyright_2007_Oracle_All_Rights_Reserved_ = null;
    public static final String BUILD_DATE = "Thu_Apr_04_15:09:24_PDT_2013";
    public static final boolean TRACE = false;

    NamedTypeAccessor(OracleStatement var1, String var2, short var3, int var4, boolean var5) throws SQLException {
        super(Representation.NAMED_TYPE, var1, -1, var5);
        this.init(var1, 109, 109, var3, var5);
        this.initForDataAccess(var4, 0, var2);
    }

    NamedTypeAccessor(OracleStatement var1, int var2, boolean var3, int var4, int var5, int var6, int var7, int var8, short var9, String var10) throws SQLException {
        super(Representation.NAMED_TYPE, var1, -1, false);
        this.init(var1, 109, 109, var9, false);
        this.initForDescribe(109, var2, var3, var4, var5, var6, var7, var8, var9, var10);
        this.initForDataAccess(0, var2, var10);
    }

    NamedTypeAccessor(OracleStatement var1, int var2, boolean var3, int var4, int var5, int var6, int var7, int var8, short var9, String var10, OracleType var11) throws SQLException {
        super(Representation.NAMED_TYPE, var1, -1, false);
        this.init(var1, 109, 109, var9, false);
        this.describeOtype = var11;
        this.initForDescribe(109, var2, var3, var4, var5, var6, var7, var8, var9, var10);
        this.internalOtype = var11;
        this.initForDataAccess(0, var2, var10);
    }

    OracleType otypeFromName(String var1) throws SQLException {
        if (!this.outBind) {
            return TypeDescriptor.getTypeDescriptor(var1, this.statement.connection).getPickler();
        } else if (this.externalType == 2003) {
            return ArrayDescriptor.createDescriptor(var1, this.statement.connection).getOracleTypeCOLLECTION();
        } else {
            return (OracleType)(this.externalType != 2007 && this.externalType != 2009 ? StructDescriptor.createDescriptor(var1, this.statement.connection).getOracleTypeADT() : OpaqueDescriptor.createDescriptor(var1, this.statement.connection).getPickler());
        }
    }

    void initForDataAccess(int var1, int var2, String var3) throws SQLException {
        super.initForDataAccess(var1, var2, var3);
        this.byteLength = this.statement.connection.namedTypeAccessorByteLen;
    }

    Object getObject(int var1) throws SQLException {
        return this.getObject(var1, this.statement.connection.getTypeMap());
    }

    Object getObject(int var1, Map var2) throws SQLException {
        if (this.isNull(var1)) {
            return null;
        } else {
            Datum var3;
            if (this.externalType == 0) {
                var3 = this.getOracleObject(var1);
                if (var3 == null) {
                    return null;
                } else if (var3 instanceof STRUCT) {
                    return ((STRUCT)var3).toJdbc(var2);
                } else if (var3 instanceof OPAQUE) {
                    Object var6 = ((OPAQUE)var3).toJdbc(var2);
                    return var6;
                } else {
                    return var3 instanceof ARRAY ? ((ARRAY)var3).toJdbc(var2) : var3.toJdbc();
                }
            } else {
                SQLException var4;
                switch(this.externalType) {
                    case 2001:
                    case 2004:
                    case 2005:
                    case 2006:
                    default:
                        var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 4);
                        var4.fillInStackTrace();
                        throw var4;
                    case 2008:
                        var2 = null;
                    case 2000:
                    case 2002:
                    case 2003:
                    case 2007:
                        var3 = this.getOracleObject(var1);
                        if (var3 == null) {
                            return null;
                        } else if (var3 instanceof STRUCT) {
                            return ((STRUCT)var3).toJdbc(var2);
                        } else {
                            if (var3 instanceof ARRAY) {
                                return ((ARRAY)var3).toJdbc(var2);
                            }

                            return var3.toJdbc();
                        }
                    case 2009:
                        var3 = this.getOracleObject(var1);
                        if (var3 == null) {
                            return null;
                        } else {
                            try {
                                return (SQLXML)var3;
                            } catch (ClassCastException var5) {
                                var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 4);
                                var4.fillInStackTrace();
                                throw var4;
                            }
                        }
                }
            }
        }
    }

    Datum getOracleObject(int var1) throws SQLException {
        if (this.isNull(var1)) {
            return null;
        } else {
            byte[] var2 = this.pickledBytes(var1);
            if (var2 != null && var2.length != 0) {
                PhysicalConnection var3 = this.statement.connection;
                OracleTypeADT var4 = (OracleTypeADT)this.internalOtype;
                TypeDescriptor var5 = TypeDescriptor.getTypeDescriptor(var4.getFullName(), var3, var2, 0L);
                switch(var5.getTypeCode()) {
                    case 2002:
                        return new STRUCT((StructDescriptor)var5, var2, var3);
                    case 2003:
                        return new ARRAY((ArrayDescriptor)var5, var2, var3);
                    case 2004:
                    case 2005:
                    case 2006:
                    default:
                        SQLException var6 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 1);
                        var6.fillInStackTrace();
                        throw var6;
                    case 2007:
                        return new OPAQUE((OpaqueDescriptor)var5, var2, var3);
                    case 2008:
                        return new JAVA_STRUCT((StructDescriptor)var5, var2, var3);
                    case 2009:
                        return NamedTypeAccessor.XMLFactory.createXML(new OPAQUE((OpaqueDescriptor)var5, var2, var3));
                }
            } else {
                return null;
            }
        }
    }

    OracleData getOracleData(int var1) throws SQLException {
        return (OracleData)this.getObject(var1);
    }

    ORAData getORAData(int var1) throws SQLException {
        return (ORAData)this.getObject(var1);
    }

    ARRAY getARRAY(int var1) throws SQLException {
        return (ARRAY)((ARRAY)this.getOracleObject(var1));
    }

    STRUCT getSTRUCT(int var1) throws SQLException {
        return (STRUCT)((STRUCT)this.getOracleObject(var1));
    }

    Struct getStruct(int var1) throws SQLException {
        return (Struct)((Struct)this.getOracleObject(var1));
    }

    OPAQUE getOPAQUE(int var1) throws SQLException {
        return (OPAQUE)((OPAQUE)this.getOracleObject(var1));
    }

    SQLXML getSQLXML(int var1) throws SQLException {
        try {
            OPAQUE var2 = (OPAQUE)this.getOracleObject(var1);
            return var2 == null ? null : (SQLXML)var2;
        } catch (ClassCastException var4) {
            SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 4);
            var3.fillInStackTrace();
            throw var3;
        }
    }

    String getString(int var1) throws SQLException {
        Datum var2 = this.getOracleObject(var1);
        return var2 instanceof XMLType ? ((XMLType)var2).getString() : null;
    }

    private static class XMLFactory {
        private XMLFactory() {
        }

        static Datum createXML(OPAQUE var0) throws SQLException {
            return XMLType.createXML(var0);
        }
    }
}
