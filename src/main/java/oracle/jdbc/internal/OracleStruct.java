//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package oracle.jdbc.internal;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Hashtable;
import java.util.Map;
import oracle.sql.Datum;
import oracle.sql.ORADataFactory;
import oracle.sql.StructDescriptor;

public interface OracleStruct extends OracleDatumWithConnection, oracle.jdbc.OracleStruct, ACProxyable {
    StructDescriptor getDescriptor() throws SQLException;

    void setDescriptor(StructDescriptor var1);

    Datum[] getOracleAttributes() throws SQLException;

    Map getMap();

    byte[] toBytes() throws SQLException;

    void setDatumArray(Datum[] var1);

    void setObjArray(Object[] var1) throws SQLException;

    Object toJdbc() throws SQLException;

    Object toJdbc(Map var1) throws SQLException;

    Object toClass(Class var1) throws SQLException;

    Object toClass(Class var1, Map var2) throws SQLException;

    boolean isConvertibleTo(Class var1);

    Object makeJdbcArray(int var1);

    void setAutoBuffering(boolean var1) throws SQLException;

    boolean getAutoBuffering() throws SQLException;

    void setImage(byte[] var1, long var2, long var4) throws SQLException;

    void setImageLength(long var1) throws SQLException;

    long getImageOffset();

    long getImageLength();

    ORADataFactory getORADataFactory(Hashtable var1, String var2) throws SQLException;

    boolean isInHierarchyOf(String var1) throws SQLException;

    Connection getJavaSqlConnection() throws SQLException;
}
