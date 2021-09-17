//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package oracle.jdbc.internal;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;
import java.sql.Connection;
import java.sql.SQLException;
import oracle.sql.ClobDBAccess;

public interface OracleClob extends OracleDatumWithConnection, oracle.jdbc.OracleClob, ACProxyable {
    InputStream getAsciiStream(long var1) throws SQLException;

    Reader getCharacterStream(long var1) throws SQLException;

    boolean isNCLOB();

    int getChars(long var1, int var3, char[] var4) throws SQLException;

    int putChars(long var1, char[] var3) throws SQLException;

    int putChars(long var1, char[] var3, int var4, int var5) throws SQLException;

    /** @deprecated */
    int putString(long var1, String var3) throws SQLException;

    int getChunkSize() throws SQLException;

    int getBufferSize() throws SQLException;

    Object toJdbc() throws SQLException;

    boolean isConvertibleTo(Class var1);

    Reader characterStreamValue() throws SQLException;

    InputStream asciiStreamValue() throws SQLException;

    InputStream binaryStreamValue() throws SQLException;

    String stringValue() throws SQLException;

    /** @deprecated */
    void trim(long var1) throws SQLException;

    /** @deprecated */
    OutputStream getAsciiOutputStream(long var1) throws SQLException;

    /** @deprecated */
    Writer getCharacterOutputStream(long var1) throws SQLException;

    /** @deprecated */
    Writer getCharacterOutputStream() throws SQLException;

    /** @deprecated */
    OutputStream getAsciiOutputStream() throws SQLException;

    byte[] getLocator();

    void setLocator(byte[] var1);

    Object makeJdbcArray(int var1);

    ClobDBAccess getDBAccess() throws SQLException;

    Connection getJavaSqlConnection() throws SQLException;

    void setLength(long var1);

    void setChunkSize(int var1);

    void setPrefetchedData(char[] var1);

    void setPrefetchedData(char[] var1, int var2);

    char[] getPrefetchedData();

    int getPrefetchedDataSize();

    void setActivePrefetch(boolean var1);

    void clearCachedData();

    boolean isActivePrefetch();

    boolean canReadBasicLobDataInLocator() throws SQLException;
}
