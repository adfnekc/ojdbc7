//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package oracle.jdbc.internal;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Map;
import oracle.sql.OpaqueDescriptor;

public interface OracleOpaque extends OracleDatumWithConnection, oracle.jdbc.OracleOpaque, ACProxyable {
    OpaqueDescriptor getDescriptor() throws SQLException;

    void setDescriptor(OpaqueDescriptor var1);

    byte[] toBytes() throws SQLException;

    byte[] getBytesValue() throws SQLException;

    void setValue(byte[] var1) throws SQLException;

    boolean isConvertibleTo(Class var1);

    Object makeJdbcArray(int var1);

    Map getMap();

    Object toJdbc() throws SQLException;

    Object toJdbc(Map var1) throws SQLException;

    Object toClass(Class var1) throws SQLException;

    Object toClass(Class var1, Map var2) throws SQLException;

    void setImage(byte[] var1, long var2, long var4) throws SQLException;

    void setImageLength(long var1) throws SQLException;

    long getImageOffset();

    long getImageLength();

    Connection getJavaSqlConnection() throws SQLException;
}
