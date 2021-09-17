//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package oracle.jdbc.driver;

import java.sql.SQLException;
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
import oracle.jdbc.oracore.OracleType;
import oracle.jdbc.oracore.OracleTypeADT;
import oracle.jdbc.oracore.OracleTypeCHAR;
import oracle.jdbc.oracore.OracleTypeFLOAT;
import oracle.jdbc.oracore.OracleTypeNUMBER;
import oracle.jdbc.oracore.OracleTypeRAW;
import oracle.jdbc.oracore.OracleTypeREF;
import oracle.sql.StructDescriptor;

class StructMetaData implements oracle.jdbc.internal.StructMetaData {
    StructDescriptor descriptor;
    OracleTypeADT otype;
    OracleType[] types;
    private static final String _Copyright_2007_Oracle_All_Rights_Reserved_ = null;
    public static final String BUILD_DATE = "Thu_Apr_04_15:09:24_PDT_2013";
    public static final boolean TRACE = false;

    public StructMetaData(StructDescriptor var1) throws SQLException {
        if (var1 == null) {
            SQLException var2 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 1, "illegal operation: descriptor is null");
            var2.fillInStackTrace();
            throw var2;
        } else {
            this.descriptor = var1;
            this.otype = var1.getOracleTypeADT();
            this.types = this.otype.getAttrTypes();
        }
    }

    public int getColumnCount() throws SQLException {
        return this.types.length;
    }

    public boolean isAutoIncrement(int var1) throws SQLException {
        return false;
    }

    public boolean isSearchable(int var1) throws SQLException {
        return false;
    }

    public SecurityAttribute getSecurityAttribute(int var1) throws SQLException {
        return SecurityAttribute.NONE;
    }

    public boolean isCurrency(int var1) throws SQLException {
        int var2 = this.getValidColumnIndex(var1);
        return this.types[var2] instanceof OracleTypeNUMBER || this.types[var2] instanceof OracleTypeFLOAT;
    }

    public boolean isCaseSensitive(int var1) throws SQLException {
        int var2 = this.getValidColumnIndex(var1);
        return this.types[var2] instanceof OracleTypeCHAR;
    }

    public int isNullable(int var1) throws SQLException {
        return 1;
    }

    public boolean isSigned(int var1) throws SQLException {
        return true;
    }

    public int getColumnDisplaySize(int var1) throws SQLException {
        int var2 = this.getValidColumnIndex(var1);
        if (this.types[var2] instanceof OracleTypeCHAR) {
            return ((OracleTypeCHAR)this.types[var2]).getLength();
        } else {
            return this.types[var2] instanceof OracleTypeRAW ? ((OracleTypeRAW)this.types[var2]).getLength() : 0;
        }
    }

    public String getColumnLabel(int var1) throws SQLException {
        return this.getColumnName(var1);
    }

    public String getColumnName(int var1) throws SQLException {
        return this.otype.getAttributeName(var1);
    }

    public String getSchemaName(int var1) throws SQLException {
        int var2 = this.getValidColumnIndex(var1);
        return this.types[var2] instanceof OracleTypeADT ? ((OracleTypeADT)this.types[var2]).getSchemaName() : "";
    }

    public int getPrecision(int var1) throws SQLException {
        int var2 = this.getValidColumnIndex(var1);
        return this.types[var2].getPrecision();
    }

    public int getScale(int var1) throws SQLException {
        int var2 = this.getValidColumnIndex(var1);
        return this.types[var2].getScale();
    }

    public boolean isVariableScale(int var1) throws SQLException {
        int var2 = this.getValidColumnIndex(var1);
        return this.types[var2].getScale() == -127;
    }

    public String getTableName(int var1) throws SQLException {
        return null;
    }

    public String getCatalogName(int var1) throws SQLException {
        return null;
    }

    public int getColumnType(int var1) throws SQLException {
        int var2 = this.getValidColumnIndex(var1);
        return this.types[var2].getTypeCode();
    }

    public String getColumnTypeName(int var1) throws SQLException {
        int var2 = this.getColumnType(var1);
        int var3 = this.getValidColumnIndex(var1);
        switch(var2) {
            case -104:
                return "INTERVALDS";
            case -103:
                return "INTERVALYM";
            case -102:
                return "TIMESTAMP WITH LOCAL TIME ZONE";
            case -101:
                return "TIMESTAMP WITH TIME ZONE";
            case -15:
                return "NCHAR";
            case -13:
                return "BFILE";
            case -9:
                return "NVARCHAR";
            case -2:
                return "RAW";
            case 1:
                return "CHAR";
            case 2:
                return "NUMBER";
            case 3:
                return "DECIMAL";
            case 6:
                return "FLOAT";
            case 8:
                return "DOUBLE";
            case 12:
                return "VARCHAR";
            case 91:
                return "DATE";
            case 93:
                return "TIMESTAMP";
            case 100:
                return "BINARY_FLOAT";
            case 101:
                return "BINARY_DOUBLE";
            case 1111:
            default:
                return null;
            case 2002:
            case 2003:
            case 2007:
            case 2008:
                return ((OracleTypeADT)this.types[var3]).getFullName();
            case 2004:
                return "BLOB";
            case 2005:
                return "CLOB";
            case 2006:
                return "REF " + ((OracleTypeREF)this.types[var3]).getFullName();
            case 2011:
                return "NCLOB";
        }
    }

    public boolean isReadOnly(int var1) throws SQLException {
        return false;
    }

    public boolean isWritable(int var1) throws SQLException {
        return false;
    }

    public boolean isDefinitelyWritable(int var1) throws SQLException {
        return false;
    }

    public String getColumnClassName(int var1) throws SQLException {
        int var2 = this.getColumnType(var1);
        switch(var2) {
            case -104:
                return "oracle.sql.INTERVALDS";
            case -103:
                return "oracle.sql.INTERVALYM";
            case -102:
                return "oracle.sql.TIMESTAMPLTZ";
            case -101:
                return "oracle.sql.TIMESTAMPTZ";
            case -15:
            case -9:
            case 12:
                return "java.lang.String";
            case -13:
                return OracleBfile.class.getName();
            case -2:
                return "byte[]";
            case 2:
            case 3:
            case 6:
            case 8:
                return "java.math.BigDecimal";
            case 91:
                return "java.sql.Timestamp";
            case 93:
                return "oracle.sql.TIMESTAMP";
            case 1111:
            default:
                return null;
            case 2002:
            case 2008:
                return OracleStruct.class.getName();
            case 2003:
                return OracleArray.class.getName();
            case 2004:
                return OracleBlob.class.getName();
            case 2005:
                return OracleClob.class.getName();
            case 2006:
                return OracleRef.class.getName();
            case 2007:
                return OracleOpaque.class.getName();
            case 2011:
                return OracleNClob.class.getName();
        }
    }

    public String getOracleColumnClassName(int var1) throws SQLException {
        int var2 = this.getColumnType(var1);
        switch(var2) {
            case -104:
                return "INTERVALDS";
            case -103:
                return "INTERVALYM";
            case -102:
                return "TIMESTAMPLTZ";
            case -101:
                return "TIMESTAMPTZ";
            case -15:
            case -9:
            case 1:
            case 12:
                return "CHAR";
            case -13:
                return "BFILE";
            case -2:
                return "RAW";
            case 2:
            case 3:
            case 6:
            case 8:
                return "NUMBER";
            case 91:
                return "DATE";
            case 93:
                return "TIMESTAMP";
            case 1111:
            default:
                return null;
            case 2002:
                return "STRUCT";
            case 2003:
                return "ARRAY";
            case 2004:
                return "BLOB";
            case 2005:
                return "CLOB";
            case 2006:
                return "REF";
            case 2007:
                return "OPAQUE";
            case 2008:
                return "JAVA_STRUCT";
            case 2011:
                return "NCLOB";
        }
    }

    public int getLocalColumnCount() throws SQLException {
        return this.descriptor.getLocalAttributeCount();
    }

    public boolean isColumnInvisible(int var1) throws SQLException {
        return false;
    }

    public boolean isInherited(int var1) throws SQLException {
        return var1 <= this.getColumnCount() - this.getLocalColumnCount();
    }

    public String getAttributeJavaName(int var1) throws SQLException {
        int var2 = this.getValidColumnIndex(var1);
        return this.descriptor.getAttributeJavaName(var2);
    }

    private int getValidColumnIndex(int var1) throws SQLException {
        int var2 = var1 - 1;
        if (var2 >= 0 && var2 < this.types.length) {
            return var2;
        } else {
            SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 3, "getValidColumnIndex");
            var3.fillInStackTrace();
            throw var3;
        }
    }

    public boolean isNCHAR(int var1) throws SQLException {
        int var2 = this.getValidColumnIndex(var1);
        return this.types[var2].isNCHAR();
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
        return null;
    }
}
