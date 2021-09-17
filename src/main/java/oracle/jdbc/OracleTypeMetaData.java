//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package oracle.jdbc;

import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import oracle.sql.SQLName;

public interface OracleTypeMetaData {
    OracleTypeMetaData.Kind getKind();

    String getName() throws SQLException;

    SQLName getSQLName() throws SQLException;

    String getSchemaName() throws SQLException;

    int getTypeCode() throws SQLException;

    String getTypeCodeName() throws SQLException;

    public interface Struct extends OracleTypeMetaData {
        int getTypeVersion() throws SQLException;

        int getLength() throws SQLException;

        ResultSetMetaData getMetaData() throws SQLException;

        boolean isFinalType() throws SQLException;

        boolean isSubtype() throws SQLException;

        boolean isInstantiable() throws SQLException;

        String getSupertypeName() throws SQLException;

        int getLocalAttributeCount() throws SQLException;

        String[] getSubtypeNames() throws SQLException;
    }

    public interface Opaque extends OracleTypeMetaData {
        long getMaxLength() throws SQLException;

        boolean isTrustedLibrary() throws SQLException;

        boolean isModeledInC() throws SQLException;

        boolean hasUnboundedSize() throws SQLException;

        boolean hasFixedSize() throws SQLException;
    }

    public interface Array extends OracleTypeMetaData {
        int getBaseType() throws SQLException;

        String getBaseName() throws SQLException;

        OracleTypeMetaData.ArrayStorage getArrayStorage() throws SQLException;

        long getMaxLength() throws SQLException;
    }

    public static enum ArrayStorage {
        VARRAY(3),
        NESTED_TABLE(2);

        private static final Map<Integer, OracleTypeMetaData.ArrayStorage> lookup = new HashMap(2);
        private final int code;

        public static OracleTypeMetaData.ArrayStorage withCode(int var0) {
            return (OracleTypeMetaData.ArrayStorage)lookup.get(var0);
        }

        private ArrayStorage(int var3) {
            this.code = var3;
        }

        public int getCode() {
            return this.code;
        }

        static {
            OracleTypeMetaData.ArrayStorage[] var0 = values();
            int var1 = var0.length;

            for(int var2 = 0; var2 < var1; ++var2) {
                OracleTypeMetaData.ArrayStorage var3 = var0[var2];
                lookup.put(var3.getCode(), var3);
            }

        }
    }

    public static enum Kind {
        ARRAY,
        OPAQUE,
        STRUCT,
        TYPE;

        private Kind() {
        }
    }
}
