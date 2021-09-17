//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package oracle.sql;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.sql.Connection;
import java.sql.SQLException;
import oracle.jdbc.internal.OracleBlob;

public interface BlobDBAccess {
    long length(BLOB var1) throws SQLException;

    long position(BLOB var1, byte[] var2, long var3) throws SQLException;

    long position(BLOB var1, BLOB var2, long var3) throws SQLException;

    int getBytes(BLOB var1, long var2, int var4, byte[] var5) throws SQLException;

    int putBytes(BLOB var1, long var2, byte[] var4, int var5, int var6) throws SQLException;

    int getChunkSize(BLOB var1) throws SQLException;

    void trim(BLOB var1, long var2) throws SQLException;

    BLOB createTemporaryBlob(Connection var1, boolean var2, int var3) throws SQLException;

    void freeTemporary(BLOB var1, boolean var2) throws SQLException;

    boolean isTemporary(BLOB var1) throws SQLException;

    void open(BLOB var1, int var2) throws SQLException;

    void close(BLOB var1) throws SQLException;

    boolean isOpen(BLOB var1) throws SQLException;

    InputStream newInputStream(BLOB var1, int var2, long var3) throws SQLException;

    InputStream newInputStream(OracleBlob var1, int var2, long var3) throws SQLException;

    InputStream newInputStream(BLOB var1, int var2, long var3, long var5) throws SQLException;

    InputStream newInputStream(OracleBlob var1, int var2, long var3, long var5) throws SQLException;

    OutputStream newOutputStream(BLOB var1, int var2, long var3, boolean var5) throws SQLException;

    OutputStream newOutputStream(OracleBlob var1, int var2, long var3, boolean var5) throws SQLException;

    InputStream newConversionInputStream(BLOB var1, int var2) throws SQLException;

    InputStream newConversionInputStream(OracleBlob var1, int var2) throws SQLException;

    Reader newConversionReader(BLOB var1, int var2) throws SQLException;

    Reader newConversionReader(OracleBlob var1, int var2) throws SQLException;

    void incrementTempLobReferenceCount(byte[] var1) throws SQLException;

    int decrementTempLobReferenceCount(byte[] var1) throws SQLException;
}
