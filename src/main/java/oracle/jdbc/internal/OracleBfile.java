//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package oracle.jdbc.internal;

import java.io.InputStream;
import java.io.Reader;
import java.sql.Connection;
import java.sql.SQLException;
import oracle.sql.BFILE;
import oracle.sql.BfileDBAccess;

public interface OracleBfile extends OracleDatumWithConnection, oracle.jdbc.OracleBfile, ACProxyable {
    long position(BFILE var1, long var2) throws SQLException;

    byte[] getLocator();

    void setLocator(byte[] var1);

    Object toJdbc() throws SQLException;

    boolean isConvertibleTo(Class var1);

    Reader characterStreamValue() throws SQLException;

    InputStream asciiStreamValue() throws SQLException;

    InputStream binaryStreamValue() throws SQLException;

    Object makeJdbcArray(int var1);

    BfileDBAccess getDBAccess() throws SQLException;

    void setLength(long var1);

    Connection getJavaSqlConnection() throws SQLException;
}
