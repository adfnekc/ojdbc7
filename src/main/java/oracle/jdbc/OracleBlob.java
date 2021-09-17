//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package oracle.jdbc;

import java.io.InputStream;
import java.sql.Blob;
import java.sql.SQLException;

public interface OracleBlob extends Blob {
    void open(LargeObjectAccessMode var1) throws SQLException;

    void close() throws SQLException;

    boolean isOpen() throws SQLException;

    int getBytes(long var1, int var3, byte[] var4) throws SQLException;

    boolean isEmptyLob() throws SQLException;

    boolean isSecureFile() throws SQLException;

    InputStream getBinaryStream(long var1) throws SQLException;

    boolean isTemporary() throws SQLException;
}
