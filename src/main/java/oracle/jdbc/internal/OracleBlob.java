//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package oracle.jdbc.internal;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.sql.Connection;
import java.sql.SQLException;
import oracle.sql.BlobDBAccess;

public interface OracleBlob extends OracleDatumWithConnection, oracle.jdbc.OracleBlob, ACProxyable {
    Object toJdbc() throws SQLException;

    boolean isConvertibleTo(Class var1);

    /** @deprecated */
    int putBytes(long var1, byte[] var3) throws SQLException;

    /** @deprecated */
    int putBytes(long var1, byte[] var3, int var4) throws SQLException;

    /** @deprecated */
    OutputStream getBinaryOutputStream() throws SQLException;

    /** @deprecated */
    OutputStream getBinaryOutputStream(long var1) throws SQLException;

    Reader characterStreamValue() throws SQLException;

    InputStream asciiStreamValue() throws SQLException;

    InputStream binaryStreamValue() throws SQLException;

    byte[] getLocator();

    void setLocator(byte[] var1);

    int getChunkSize() throws SQLException;

    int getBufferSize() throws SQLException;

    /** @deprecated */
    void trim(long var1) throws SQLException;

    Object makeJdbcArray(int var1);

    BlobDBAccess getDBAccess() throws SQLException;

    Connection getJavaSqlConnection() throws SQLException;

    void setLength(long var1);

    void setChunkSize(int var1);

    void setPrefetchedData(byte[] var1);

    void setPrefetchedData(byte[] var1, int var2);

    byte[] getPrefetchedData();

    int getPrefetchedDataSize();

    void setActivePrefetch(boolean var1);

    void clearCachedData();

    boolean isActivePrefetch();

    boolean canReadBasicLobDataInLocator() throws SQLException;
}
