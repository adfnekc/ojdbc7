//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package oracle.jdbc;

import java.io.InputStream;
import java.sql.SQLException;

public interface OracleBfile {
    long length() throws SQLException;

    byte[] getBytes(long var1, int var3) throws SQLException;

    int getBytes(long var1, int var3, byte[] var4) throws SQLException;

    InputStream getBinaryStream() throws SQLException;

    InputStream getBinaryStream(long var1) throws SQLException;

    long position(byte[] var1, long var2) throws SQLException;

    long position(OracleBfile var1, long var2) throws SQLException;

    String getName() throws SQLException;

    String getDirAlias() throws SQLException;

    void openFile() throws SQLException;

    boolean isFileOpen() throws SQLException;

    boolean fileExists() throws SQLException;

    void closeFile() throws SQLException;

    void open(LargeObjectAccessMode var1) throws SQLException;

    void close() throws SQLException;

    boolean isOpen() throws SQLException;
}
