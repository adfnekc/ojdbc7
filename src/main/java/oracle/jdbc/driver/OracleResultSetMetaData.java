//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package oracle.jdbc.driver;

import java.sql.SQLException;
import java.util.Map;
import oracle.jdbc.OracleArray;
import oracle.jdbc.OracleBfile;
import oracle.jdbc.OracleBlob;
import oracle.jdbc.OracleClob;
import oracle.jdbc.OracleNClob;
import oracle.jdbc.OracleOpaque;
import oracle.jdbc.OracleRef;
import oracle.jdbc.OracleStruct;
import oracle.jdbc.OracleResultSetMetaData.SecurityAttribute;
import oracle.jdbc.internal.OracleConnection;
import oracle.jdbc.oracore.OracleNamedType;
import oracle.jdbc.oracore.OracleTypeADT;
import oracle.sql.StructDescriptor;
import oracle.sql.TypeDescriptor;

class OracleResultSetMetaData implements oracle.jdbc.internal.OracleResultSetMetaData {
    PhysicalConnection connection;
    OracleStatement statement;
    int offsetOfFirstUserColumn;
    Object acProxy;
    private static final String _Copyright_2007_Oracle_All_Rights_Reserved_ = null;
    public static final String BUILD_DATE = "Thu_Apr_04_15:09:24_PDT_2013";
    public static final boolean TRACE = false;

    public OracleResultSetMetaData() {
    }

    OracleResultSetMetaData(PhysicalConnection var1, OracleStatement var2, int var3) throws SQLException {
        this.connection = var1;
        this.statement = var2;
        var2.describe();
        this.offsetOfFirstUserColumn = var3;
    }

    public int getColumnCount() throws SQLException {
        return this.statement.getNumberOfColumns();
    }

    public boolean isAutoIncrement(int var1) throws SQLException {
        return false;
    }

    int getValidColumnIndex(int var1) throws SQLException {
        if (var1 > 0 && var1 <= this.statement.getNumberOfColumns()) {
            int var3 = var1 + this.offsetOfFirstUserColumn;
            return var3;
        } else {
            SQLException var2 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 3, "getValidColumnIndex");
            var2.fillInStackTrace();
            throw var2;
        }
    }

    public boolean isCaseSensitive(int var1) throws SQLException {
        int var2 = this.getColumnType(var1);
        return var2 == 1 || var2 == 12 || var2 == -1 || var2 == -15 || var2 == -9;
    }

    public boolean isSearchable(int var1) throws SQLException {
        int var2 = this.getColumnType(var1);
        return var2 != -4 && var2 != -1 && var2 != 2004 && var2 != 2005 && var2 != -13 && var2 != 2011 && var2 != 2002 && var2 != 2008 && var2 != 2007 && var2 != 2003 && var2 != 2006 && var2 != -10;
    }

    public boolean isCurrency(int var1) throws SQLException {
        int var2 = this.getColumnType(var1);
        return var2 == 2 || var2 == 6;
    }

    public int isNullable(int var1) throws SQLException {
        int var2 = this.getValidColumnIndex(var1);
        return this.getDescription()[var2].nullable ? 1 : 0;
    }

    public boolean isSigned(int var1) throws SQLException {
        return true;
    }

    public int getColumnDisplaySize(int var1) throws SQLException {
        int var2 = this.getValidColumnIndex(var1);
        int var3 = this.getDescription()[var2].describeType;
        switch(var3) {
            case 2:
                int var4 = this.getPrecision(var1);
                int var5 = this.getDescription()[var2].scale;
                if (var4 != 0 && var5 == -127) {
                    var4 = (int)((double)var4 / 3.32193D);
                    var5 = 1;
                } else {
                    if (var4 == 0) {
                        var4 = 38;
                    }

                    if (var5 == -127) {
                        var5 = 0;
                    }
                }

                int var6 = var4 + (var5 != 0 ? 1 : 0) + 1;
                return var6;
            default:
                return this.getDescription()[var2].describeMaxLength;
        }
    }

    public String getColumnLabel(int var1) throws SQLException {
        return this.getColumnName(var1);
    }

    public String getColumnName(int var1) throws SQLException {
        int var2 = this.getValidColumnIndex(var1);
        return this.statement.getDescriptionWithNames()[var2].columnName;
    }

    public String getSchemaName(int var1) throws SQLException {
        return "";
    }

    public int getPrecision(int var1) throws SQLException {
        int var2 = this.getValidColumnIndex(var1);
        int var3 = this.getDescription()[var2].describeType;
        switch(var3) {
            case 1:
            case 96:
                return this.getDescription()[var2].describeMaxLengthChars;
            case 8:
            case 24:
                return 2147483647;
            case 112:
            case 113:
                return -1;
            default:
                return this.getDescription()[var2].precision;
        }
    }

    public SecurityAttribute getSecurityAttribute(int var1) throws SQLException {
        int var2 = this.getValidColumnIndex(var1);
        return this.getDescription()[var2].securityAttribute;
    }

    public int getScale(int var1) throws SQLException {
        int var2 = this.getValidColumnIndex(var1);
        int var3 = this.getDescription()[var2].scale;
        return var3 == -127 && this.statement.connection.j2ee13Compliant ? 0 : var3;
    }

    public boolean isVariableScale(int var1) throws SQLException {
        int var2 = this.getValidColumnIndex(var1);
        int var3 = this.getDescription()[var2].scale;
        return var3 == -127;
    }

    public String getTableName(int var1) throws SQLException {
        return "";
    }

    public String getCatalogName(int var1) throws SQLException {
        return "";
    }

    public int getColumnType(int var1) throws SQLException {
        int var2 = this.getValidColumnIndex(var1);
        int var3 = this.getDescription()[var2].describeType;
        switch(var3) {
            case 1:
                if (this.getDescription()[var2].formOfUse == 2) {
                    return -9;
                }

                return 12;
            case 2:
            case 6:
                if (this.statement.connection.j2ee13Compliant && this.getDescription()[var2].precision != 0 && this.getDescription()[var2].scale == -127) {
                    return 6;
                }

                return 2;
            case 8:
                return -1;
            case 12:
                return this.connection.mapDateToTimestamp ? 93 : 91;
            case 23:
                return -3;
            case 24:
                return -4;
            case 96:
                if (this.getDescription()[var2].formOfUse == 2) {
                    return -15;
                }

                return 1;
            case 100:
                return 100;
            case 101:
                return 101;
            case 102:
                return -10;
            case 104:
            case 208:
                return -8;
            case 109:
                OracleNamedType var4 = (OracleNamedType)((OracleNamedType)this.getDescription()[var2].describeOtype);
                TypeDescriptor var5 = TypeDescriptor.getTypeDescriptor(var4.getFullName(), this.connection);
                if (var5 != null) {
                    return var5.getTypeCode();
                }

                SQLException var6 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 60);
                var6.fillInStackTrace();
                throw var6;
            case 111:
                return 2006;
            case 112:
                if (this.getDescription()[var2].formOfUse == 2) {
                    return 2011;
                }

                return 2005;
            case 113:
                return 2004;
            case 114:
                return -13;
            case 180:
                return 93;
            case 181:
                return -101;
            case 182:
                return -103;
            case 183:
                return -104;
            case 231:
                return -102;
            default:
                return 1111;
        }
    }

    public String getColumnTypeName(int var1) throws SQLException {
        int var2 = this.getValidColumnIndex(var1);
        int var3 = this.getDescription()[var2].describeType;
        OracleTypeADT var4;
        switch(var3) {
            case 1:
                if (this.getDescription()[var2].formOfUse == 2) {
                    return "NVARCHAR2";
                }

                return "VARCHAR2";
            case 2:
            case 6:
                if (this.statement.connection.j2ee13Compliant && this.getDescription()[var2].precision != 0 && this.getDescription()[var2].scale == -127) {
                    return "FLOAT";
                }

                return "NUMBER";
            case 8:
                return "LONG";
            case 12:
                return "DATE";
            case 23:
                return "RAW";
            case 24:
                return "LONG RAW";
            case 96:
                if (this.getDescription()[var2].formOfUse == 2) {
                    return "NCHAR";
                }

                return "CHAR";
            case 100:
                return "BINARY_FLOAT";
            case 101:
                return "BINARY_DOUBLE";
            case 102:
                return "REFCURSOR";
            case 104:
            case 208:
                return "ROWID";
            case 109:
                var4 = (OracleTypeADT)this.getDescription()[var2].describeOtype;
                return var4.getFullName();
            case 111:
                var4 = (OracleTypeADT)this.getDescription()[var2].describeOtype;
                return var4.getFullName();
            case 112:
                if (this.getDescription()[var2].formOfUse == 2) {
                    return "NCLOB";
                }

                return "CLOB";
            case 113:
                return "BLOB";
            case 114:
                return "BFILE";
            case 180:
                return "TIMESTAMP";
            case 181:
                return "TIMESTAMP WITH TIME ZONE";
            case 182:
                return "INTERVALYM";
            case 183:
                return "INTERVALDS";
            case 231:
                return "TIMESTAMP WITH LOCAL TIME ZONE";
            default:
                return null;
        }
    }

    public boolean isReadOnly(int var1) throws SQLException {
        return false;
    }

    public boolean isWritable(int var1) throws SQLException {
        return true;
    }

    public boolean isDefinitelyWritable(int var1) throws SQLException {
        return false;
    }

    public String getColumnClassName(int var1) throws SQLException {
        int var2 = this.getValidColumnIndex(var1);
        int var3 = this.getDescription()[var2].describeType;
        switch(var3) {
            case 1:
            case 8:
            case 96:
            case 999:
                return "java.lang.String";
            case 2:
            case 6:
                if (this.getDescription()[var2].precision != 0 && this.getDescription()[var2].scale == -127) {
                    return "java.lang.Double";
                }

                return "java.math.BigDecimal";
            case 12:
                return "java.sql.Timestamp";
            case 23:
            case 24:
                return "byte[]";
            case 100:
                return "oracle.sql.BINARY_FLOAT";
            case 101:
                return "oracle.sql.BINARY_DOUBLE";
            case 102:
                return "OracleResultSet";
            case 104:
            case 208:
                return "oracle.sql.ROWID";
            case 109:
                switch(this.getColumnType(var1)) {
                    case 2002:
                        Map var7 = this.connection.getTypeMap();
                        if (var7 != null) {
                            Class var9 = (Class)var7.get(((OracleNamedType)this.getDescription()[var2].describeOtype).getFullName());
                            if (var9 != null) {
                                return var9.getName();
                            }
                        }

                        return OracleStruct.class.getName();
                    case 2003:
                        return OracleArray.class.getName();
                    case 2004:
                    case 2005:
                    case 2006:
                    default:
                        SQLException var8 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 1);
                        var8.fillInStackTrace();
                        throw var8;
                    case 2007:
                        return OracleOpaque.class.getName();
                    case 2008:
                        OracleNamedType var4 = (OracleNamedType)this.getDescription()[var2].describeOtype;
                        Map var5 = this.connection.getJavaObjectTypeMap();
                        if (var5 != null) {
                            Class var6 = (Class)var5.get(var4.getFullName());
                            if (var6 != null) {
                                return var6.getName();
                            }
                        }

                        return StructDescriptor.getJavaObjectClassName(this.connection, var4.getSchemaName(), var4.getSimpleName());
                    case 2009:
                        return "java.sql.SQLXML";
                }
            case 111:
                return OracleRef.class.getName();
            case 112:
                if (this.getDescription()[var2].formOfUse == 2) {
                    return OracleNClob.class.getName();
                }

                return OracleClob.class.getName();
            case 113:
                return OracleBlob.class.getName();
            case 114:
                return OracleBfile.class.getName();
            case 180:
                if (this.statement.connection.j2ee13Compliant) {
                    return "java.sql.Timestamp";
                }

                return "oracle.sql.TIMESTAMP";
            case 181:
                return "oracle.sql.TIMESTAMPTZ";
            case 182:
                return "oracle.sql.INTERVALYM";
            case 183:
                return "oracle.sql.INTERVALDS";
            case 231:
                return "oracle.sql.TIMESTAMPLTZ";
            default:
                return null;
        }
    }

    public boolean isNCHAR(int var1) throws SQLException {
        int var2 = this.getValidColumnIndex(var1);
        return this.getDescription()[var2].formOfUse == 2;
    }

    public boolean isColumnInvisible(int var1) throws SQLException {
        int var2 = this.getValidColumnIndex(var1);
        return this.getDescription()[var2].isColumnInvisible();
    }

    Accessor[] getDescription() throws SQLException {
        return this.statement.getDescription();
    }

    public boolean isWrapperFor(Class<?> var1) throws SQLException {
        if (var1.isInterface()) {
            return var1.isInstance(this);
        } else {
            SQLException var2 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 177);
            var2.fillInStackTrace();
            throw var2;
        }
    }

    public <T> T unwrap(Class<T> var1) throws SQLException {
        if (var1.isInterface() && var1.isInstance(this)) {
            return (T) this;
        } else {
            SQLException var2 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 177);
            var2.fillInStackTrace();
            throw var2;
        }
    }

    protected OracleConnection getConnectionDuringExceptionHandling() {
        return this.connection;
    }

    public void setACProxy(Object var1) {
        this.acProxy = var1;
    }

    public Object getACProxy() {
        return this.acProxy;
    }
}
