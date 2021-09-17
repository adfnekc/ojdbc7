//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package oracle.sql;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;
import java.sql.Connection;
import java.sql.SQLException;
import oracle.jdbc.internal.OracleClob;

public interface ClobDBAccess {
    long length(CLOB var1) throws SQLException;

    long position(CLOB var1, String var2, long var3) throws SQLException;

    long position(CLOB var1, CLOB var2, long var3) throws SQLException;

    int getChars(CLOB var1, long var2, int var4, char[] var5) throws SQLException;

    int putChars(CLOB var1, long var2, char[] var4, int var5, int var6) throws SQLException;

    int getChunkSize(CLOB var1) throws SQLException;

    void trim(CLOB var1, long var2) throws SQLException;

    CLOB createTemporaryClob(Connection var1, boolean var2, int var3, short var4) throws SQLException;

    void freeTemporary(CLOB var1, boolean var2) throws SQLException;

    boolean isTemporary(CLOB var1) throws SQLException;

    void open(CLOB var1, int var2) throws SQLException;

    void close(CLOB var1) throws SQLException;

    boolean isOpen(CLOB var1) throws SQLException;

    InputStream newInputStream(CLOB var1, int var2, long var3) throws SQLException;

    InputStream newInputStream(OracleClob var1, int var2, long var3) throws SQLException;

    OutputStream newOutputStream(CLOB var1, int var2, long var3, boolean var5) throws SQLException;

    OutputStream newOutputStream(OracleClob var1, int var2, long var3, boolean var5) throws SQLException;

    Reader newReader(CLOB var1, int var2, long var3) throws SQLException;

    Reader newReader(OracleClob var1, int var2, long var3) throws SQLException;

    Reader newReader(CLOB var1, int var2, long var3, long var5) throws SQLException;

    Reader newReader(OracleClob var1, int var2, long var3, long var5) throws SQLException;

    Writer newWriter(CLOB var1, int var2, long var3, boolean var5) throws SQLException;

    Writer newWriter(OracleClob var1, int var2, long var3, boolean var5) throws SQLException;

    char[] getCharBufferSync(int var1);

    void cacheBufferSync(char[] var1);

    void incrementTempLobReferenceCount(byte[] var1) throws SQLException;

    int decrementTempLobReferenceCount(byte[] var1) throws SQLException;
}
