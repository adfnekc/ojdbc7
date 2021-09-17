//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package oracle.sql;

import java.io.InputStream;
import java.io.Reader;
import java.sql.SQLException;
import oracle.jdbc.internal.OracleBfile;

public interface BfileDBAccess {
    long length(BFILE var1) throws SQLException;

    long position(BFILE var1, byte[] var2, long var3) throws SQLException;

    long position(BFILE var1, BFILE var2, long var3) throws SQLException;

    int getBytes(BFILE var1, long var2, int var4, byte[] var5) throws SQLException;

    String getName(BFILE var1) throws SQLException;

    String getDirAlias(BFILE var1) throws SQLException;

    void openFile(BFILE var1) throws SQLException;

    boolean isFileOpen(BFILE var1) throws SQLException;

    boolean fileExists(BFILE var1) throws SQLException;

    void closeFile(BFILE var1) throws SQLException;

    void open(BFILE var1, int var2) throws SQLException;

    void close(BFILE var1) throws SQLException;

    boolean isOpen(BFILE var1) throws SQLException;

    InputStream newInputStream(BFILE var1, int var2, long var3) throws SQLException;

    InputStream newInputStream(OracleBfile var1, int var2, long var3) throws SQLException;

    InputStream newConversionInputStream(BFILE var1, int var2) throws SQLException;

    InputStream newConversionInputStream(OracleBfile var1, int var2) throws SQLException;

    Reader newConversionReader(BFILE var1, int var2) throws SQLException;

    Reader newConversionReader(OracleBfile var1, int var2) throws SQLException;
}
