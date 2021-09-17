//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package oracle.jdbc.internal;

import java.sql.SQLException;
import java.util.Map;
import oracle.sql.STRUCT;
import oracle.sql.StructDescriptor;

public interface OracleRef extends OracleDatumWithConnection, oracle.jdbc.OracleRef, ACProxyable {
    Object getValue(Map var1) throws SQLException;

    Object getValue() throws SQLException;

    STRUCT getSTRUCT() throws SQLException;

    void setValue(Object var1) throws SQLException;

    StructDescriptor getDescriptor() throws SQLException;

    String getSQLTypeName() throws SQLException;

    Object toJdbc() throws SQLException;

    boolean isConvertibleTo(Class var1);

    Object makeJdbcArray(int var1);

    Object clone() throws CloneNotSupportedException;

    boolean equals(Object var1);

    int hashCode();
}
