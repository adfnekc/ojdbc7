//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package oracle.sql;

import java.io.ByteArrayInputStream;
import java.io.CharArrayReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.StringWriter;
import java.io.Writer;
import java.sql.Clob;
import java.sql.Connection;
import java.sql.SQLException;
import oracle.jdbc.LargeObjectAccessMode;
import oracle.jdbc.OracleConnection;
import oracle.jdbc.driver.DatabaseError;
import oracle.jdbc.internal.OracleClob;

/** @deprecated */
public class CLOB extends DatumWithConnection implements OracleClob {
    public static final int MAX_CHUNK_SIZE = 32768;
    public static final int DURATION_SESSION = 10;
    public static final int DURATION_CALL = 12;
    static final int OLD_WRONG_DURATION_SESSION = 1;
    static final int OLD_WRONG_DURATION_CALL = 2;
    public static final int MODE_READONLY = 0;
    public static final int MODE_READWRITE = 1;
    ClobDBAccess dbaccess;
    private int dbChunkSize;
    private short csform;
    boolean isFree;
    boolean fromObject;
    long cachedLengthOfClobInChars;
    char[] prefetchData;
    int prefetchDataSize;
    boolean activePrefetch;
    static final int KDLCTLSIZE = 16;
    static final int KDF_FLAG = 88;
    static final int KDLIDDAT = 8;
    transient CharacterSet dilCharacterSet;
    protected Object acProxy;
    private static final String _Copyright_2007_Oracle_All_Rights_Reserved_ = null;
    public static final String BUILD_DATE = "Thu_Apr_04_15:09:24_PDT_2013";
    public static final boolean TRACE = false;

    protected CLOB() {
        this.dbChunkSize = -1;
        this.isFree = false;
        this.fromObject = false;
        this.cachedLengthOfClobInChars = -1L;
        this.prefetchData = null;
        this.prefetchDataSize = 0;
        this.activePrefetch = false;
        this.dilCharacterSet = null;
    }

    public CLOB(OracleConnection var1) throws SQLException {
        this(var1, (byte[])null);
    }

    public CLOB(OracleConnection var1, byte[] var2, boolean var3) throws SQLException {
        this(var1, var2);
        this.fromObject = var3;
    }

    public static final short getFormOfUseFromLocator(byte[] var0) {
        byte var1 = -1;
        if (var0 != null && var0.length > 5) {
            if ((var0[5] & 64) != 0 && (var0[5] & -128) == 0) {
                var1 = 2;
            } else {
                var1 = 1;
            }
        }

        return var1;
    }

    public CLOB(OracleConnection var1, byte[] var2) throws SQLException {
        super(var2);
        this.dbChunkSize = -1;
        this.isFree = false;
        this.fromObject = false;
        this.cachedLengthOfClobInChars = -1L;
        this.prefetchData = null;
        this.prefetchDataSize = 0;
        this.activePrefetch = false;
        this.dilCharacterSet = null;
        if (var2 != null) {
            this.csform = getFormOfUseFromLocator(var2);
        }

        assertNotNull(var1);
        this.setPhysicalConnectionOf(var1);
        this.dbaccess = ((oracle.jdbc.internal.OracleConnection)var1).createClobDBAccess();
        this.dbaccess.incrementTempLobReferenceCount(var2);
    }

    public CLOB(OracleConnection var1, byte[] var2, short var3) throws SQLException {
        this(var1, var2);
        short var4 = getFormOfUseFromLocator(var2);
        if (var4 != -1) {
            if (var3 != var4) {
                SQLException var5 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 184);
                var5.fillInStackTrace();
                throw var5;
            }

            this.csform = var4;
        } else {
            this.csform = var3;
        }

    }

    public boolean isNCLOB() {
        return this.csform == 2;
    }

    public long length() throws SQLException {
        if (this.isFree) {
            SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 192);
            var3.fillInStackTrace();
            throw var3;
        } else {
            long var1 = -1L;
            if (this.activePrefetch && this.cachedLengthOfClobInChars != -1L) {
                var1 = this.cachedLengthOfClobInChars;
            } else if (this.canReadBasicLobDataInLocator()) {
                var1 = (long)this.dilGetChars().length;
            } else {
                var1 = this.getDBAccess().length(this);
            }

            return var1;
        }
    }

    public String getSubString(long var1, int var3) throws SQLException {
        SQLException var4;
        if (this.isFree) {
            var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 192);
            var4.fillInStackTrace();
            throw var4;
        } else if (var3 >= 0 && var1 >= 1L) {
            if (this.canReadBasicLobDataInLocator()) {
                return this.dilGetSubString(var1, var3);
            } else {
                var4 = null;
                String var7;
                if (var3 == 0 || this.activePrefetch && (this.cachedLengthOfClobInChars == 0L || this.cachedLengthOfClobInChars > 0L && var1 - 1L >= this.cachedLengthOfClobInChars)) {
                    var7 = new String();
                } else if (this.prefetchData != null && this.prefetchDataSize > 0 && this.cachedLengthOfClobInChars == (long)this.prefetchDataSize && var1 + (long)var3 - 1L <= this.cachedLengthOfClobInChars) {
                    var7 = new String(this.prefetchData, (int)var1 - 1, var3);
                } else {
                    char[] var5 = this.getDBAccess().getCharBufferSync(var3);
                    int var6 = this.getChars(var1, var3, var5);
                    if (var6 > 0) {
                        var7 = new String(var5, 0, var6);
                    } else {
                        var7 = new String();
                    }

                    this.getDBAccess().cacheBufferSync(var5);
                }

                return var7;
            }
        } else {
            var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 68);
            var4.fillInStackTrace();
            throw var4;
        }
    }

    public Reader getCharacterStream() throws SQLException {
        if (this.isFree) {
            SQLException var1 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 192);
            var1.fillInStackTrace();
            throw var1;
        } else {
            return this.canReadBasicLobDataInLocator() ? this.dilGetCharacterStream(1L) : this.getDBAccess().newReader(this, this.getBufferSize(), 0L);
        }
    }

    public InputStream getAsciiStream() throws SQLException {
        if (this.isFree) {
            SQLException var1 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 192);
            var1.fillInStackTrace();
            throw var1;
        } else {
            return this.canReadBasicLobDataInLocator() ? this.dilGetAsciiStream(1L) : this.getDBAccess().newInputStream(this, this.getBufferSize(), 0L);
        }
    }

    public long position(String var1, long var2) throws SQLException {
        if (this.isFree) {
            SQLException var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 192);
            var4.fillInStackTrace();
            throw var4;
        } else {
            return this.getDBAccess().position(this, var1, var2);
        }
    }

    public long position(Clob var1, long var2) throws SQLException {
        if (this.isFree) {
            SQLException var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 192);
            var4.fillInStackTrace();
            throw var4;
        } else {
            return this.getDBAccess().position(this, (CLOB)var1, var2);
        }
    }

    public int getChars(long var1, int var3, char[] var4) throws SQLException {
        if (this.isFree) {
            SQLException var5 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 192);
            var5.fillInStackTrace();
            throw var5;
        } else {
            return this.getDBAccess().getChars(this, var1, var3, var4);
        }
    }

    /** @deprecated */
    public Writer getCharacterOutputStream() throws SQLException {
        if (this.isFree) {
            SQLException var1 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 192);
            var1.fillInStackTrace();
            throw var1;
        } else {
            return this.setCharacterStream(1L);
        }
    }

    /** @deprecated */
    public OutputStream getAsciiOutputStream() throws SQLException {
        if (this.isFree) {
            SQLException var1 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 192);
            var1.fillInStackTrace();
            throw var1;
        } else {
            return this.setAsciiStream(1L);
        }
    }

    public byte[] getLocator() {
        return this.getBytes();
    }

    public void setLocator(byte[] var1) {
        super.setBytes(var1);
    }

    public int putChars(long var1, char[] var3) throws SQLException {
        if (this.isFree) {
            SQLException var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 192);
            var4.fillInStackTrace();
            throw var4;
        } else {
            return this.getDBAccess().putChars(this, var1, var3, 0, var3 != null ? var3.length : 0);
        }
    }

    public int putChars(long var1, char[] var3, int var4) throws SQLException {
        if (this.isFree) {
            SQLException var5 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 192);
            var5.fillInStackTrace();
            throw var5;
        } else {
            return this.getDBAccess().putChars(this, var1, var3, 0, var4);
        }
    }

    public int putChars(long var1, char[] var3, int var4, int var5) throws SQLException {
        if (this.isFree) {
            SQLException var6 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 192);
            var6.fillInStackTrace();
            throw var6;
        } else {
            return this.getDBAccess().putChars(this, var1, var3, var4, var5);
        }
    }

    /** @deprecated */
    public int putString(long var1, String var3) throws SQLException {
        if (this.isFree) {
            SQLException var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 192);
            var4.fillInStackTrace();
            throw var4;
        } else {
            return this.setString(var1, var3);
        }
    }

    public int getChunkSize() throws SQLException {
        if (this.isFree) {
            SQLException var1 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 192);
            var1.fillInStackTrace();
            throw var1;
        } else {
            if (this.dbChunkSize <= 0) {
                this.dbChunkSize = this.getDBAccess().getChunkSize(this);
            }

            return this.dbChunkSize;
        }
    }

    public int getBufferSize() throws SQLException {
        if (this.isFree) {
            SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 192);
            var3.fillInStackTrace();
            throw var3;
        } else {
            int var1 = this.getChunkSize();
            boolean var2 = false;
            int var4;
            if (var1 < 32768 && var1 > 0) {
                var4 = '耀' / var1 * var1;
            } else {
                var4 = 32768;
            }

            return var4;
        }
    }

    /** @deprecated */
    public static CLOB empty_lob() throws SQLException {
        return getEmptyCLOB();
    }

    public static CLOB getEmptyCLOB() throws SQLException {
        byte[] var0 = new byte[86];
        var0[1] = 84;
        var0[5] = 24;
        CLOB var1 = new CLOB();
        var1.setShareBytes(var0);
        return var1;
    }

    public boolean isEmptyLob() throws SQLException {
        if (this.isFree) {
            SQLException var1 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 192);
            var1.fillInStackTrace();
            throw var1;
        } else {
            return (this.shareBytes()[5] & 16) != 0;
        }
    }

    public boolean isSecureFile() throws SQLException {
        if (this.isFree) {
            SQLException var2 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 192);
            var2.fillInStackTrace();
            throw var2;
        } else {
            boolean var1 = (this.shareBytes()[7] & -128) != 0;
            return var1;
        }
    }

    /** @deprecated */
    public OutputStream getAsciiOutputStream(long var1) throws SQLException {
        if (this.isFree) {
            SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 192);
            var3.fillInStackTrace();
            throw var3;
        } else {
            return this.getDBAccess().newOutputStream(this, this.getBufferSize(), var1, false);
        }
    }

    /** @deprecated */
    public Writer getCharacterOutputStream(long var1) throws SQLException {
        if (this.isFree) {
            SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 192);
            var3.fillInStackTrace();
            throw var3;
        } else {
            return this.getDBAccess().newWriter(this, this.getBufferSize(), var1, false);
        }
    }

    public InputStream getAsciiStream(long var1) throws SQLException {
        SQLException var3;
        if (this.isFree) {
            var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 192);
            var3.fillInStackTrace();
            throw var3;
        } else {
            if (var1 == 0L) {
                if (this.getPhysicalConnection().isLobStreamPosStandardCompliant()) {
                    var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 68);
                    var3.fillInStackTrace();
                    throw var3;
                }

                var1 = 1L;
            }

            return this.canReadBasicLobDataInLocator() ? this.dilGetAsciiStream(var1) : this.getDBAccess().newInputStream(this, this.getBufferSize(), var1);
        }
    }

    public Reader getCharacterStream(long var1) throws SQLException {
        SQLException var3;
        if (this.isFree) {
            var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 192);
            var3.fillInStackTrace();
            throw var3;
        } else {
            if (var1 == 0L) {
                if (this.getPhysicalConnection().isLobStreamPosStandardCompliant()) {
                    var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 68);
                    var3.fillInStackTrace();
                    throw var3;
                }

                var1 = 1L;
            }

            return this.canReadBasicLobDataInLocator() ? this.dilGetCharacterStream(var1) : this.getDBAccess().newReader(this, this.getBufferSize(), var1);
        }
    }

    /** @deprecated */
    public void trim(long var1) throws SQLException {
        if (this.isFree) {
            SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 192);
            var3.fillInStackTrace();
            throw var3;
        } else {
            this.truncate(var1);
        }
    }

    public static CLOB createTemporary(Connection var0, boolean var1, int var2) throws SQLException {
        return createTemporary(var0, var1, var2, (short)1);
    }

    public static CLOB createTemporary(Connection var0, boolean var1, int var2, short var3) throws SQLException {
        int var4 = var2;
        if (var2 == 1) {
            var4 = 10;
        }

        if (var2 == 2) {
            var4 = 12;
        }

        if (var0 != null && (var4 == 10 || var4 == 12)) {
            oracle.jdbc.internal.OracleConnection var7 = ((OracleConnection)var0).physicalConnectionWithin();
            CLOB var6 = getDBAccess(var7).createTemporaryClob(var7, var1, var4, var3);
            var6.csform = getFormOfUseFromLocator(var6.shareBytes());
            return var6;
        } else {
            SQLException var5 = DatabaseError.createSqlException((oracle.jdbc.internal.OracleConnection)null, 68, "'conn' should not be null and 'duration' should either be equal to DURATION_SESSION or DURATION_CALL");
            var5.fillInStackTrace();
            throw var5;
        }
    }

    public static void freeTemporary(CLOB var0) throws SQLException {
        if (var0 != null) {
            var0.freeTemporary();
        }
    }

    public static boolean isTemporary(CLOB var0) throws SQLException {
        return var0 == null ? false : var0.isTemporary();
    }

    public void freeTemporary() throws SQLException {
        if (this.isFree) {
            SQLException var2 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 192);
            var2.fillInStackTrace();
            throw var2;
        } else {
            int var1 = this.getDBAccess().decrementTempLobReferenceCount(this.shareBytes());
            if (var1 == 0) {
                this.getDBAccess().freeTemporary(this, this.fromObject);
            }

        }
    }

    public boolean isTemporary() throws SQLException {
        if (this.isFree) {
            SQLException var1 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 192);
            var1.fillInStackTrace();
            throw var1;
        } else {
            return this.getDBAccess().isTemporary(this);
        }
    }

    public void open(LargeObjectAccessMode var1) throws SQLException {
        this.open(var1.getCode());
    }

    public void open(int var1) throws SQLException {
        if (this.isFree) {
            SQLException var2 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 192);
            var2.fillInStackTrace();
            throw var2;
        } else {
            this.getDBAccess().open(this, var1);
        }
    }

    public void close() throws SQLException {
        if (this.isFree) {
            SQLException var1 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 192);
            var1.fillInStackTrace();
            throw var1;
        } else {
            this.getDBAccess().close(this);
        }
    }

    public boolean isOpen() throws SQLException {
        if (this.isFree) {
            SQLException var1 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 192);
            var1.fillInStackTrace();
            throw var1;
        } else {
            return this.getDBAccess().isOpen(this);
        }
    }

    public int setString(long var1, String var3) throws SQLException {
        SQLException var5;
        if (this.isFree) {
            var5 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 192);
            var5.fillInStackTrace();
            throw var5;
        } else if (var1 < 1L) {
            var5 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 68, "'pos' should not be < 1");
            var5.fillInStackTrace();
            throw var5;
        } else {
            int var4 = 0;
            if (var3 != null && var3.length() != 0) {
                var4 = this.putChars(var1, var3.toCharArray());
            }

            return var4;
        }
    }

    public int setString(long var1, String var3, int var4, int var5) throws SQLException {
        SQLException var7;
        if (this.isFree) {
            var7 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 192);
            var7.fillInStackTrace();
            throw var7;
        } else if (var1 < 1L) {
            var7 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 68, "'pos' should not be < 1");
            var7.fillInStackTrace();
            throw var7;
        } else if (var4 < 0) {
            var7 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 68, "'offset' should not be < 0");
            var7.fillInStackTrace();
            throw var7;
        } else if (var4 + var5 > var3.length()) {
            var7 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 68, " 'offset + len' should not be exceed string length. ");
            var7.fillInStackTrace();
            throw var7;
        } else {
            int var6 = 0;
            if (var3 != null && var3.length() != 0) {
                var6 = this.putChars(var1, var3.toCharArray(), var4, var5);
            }

            return var6;
        }
    }

    public OutputStream setAsciiStream(long var1) throws SQLException {
        if (this.isFree) {
            SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 192);
            var3.fillInStackTrace();
            throw var3;
        } else {
            return this.getDBAccess().newOutputStream(this, this.getBufferSize(), var1, true);
        }
    }

    public Writer setCharacterStream(long var1) throws SQLException {
        if (this.isFree) {
            SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 192);
            var3.fillInStackTrace();
            throw var3;
        } else {
            return this.getDBAccess().newWriter(this, this.getBufferSize(), var1, true);
        }
    }

    public void truncate(long var1) throws SQLException {
        SQLException var3;
        if (this.isFree) {
            var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 192);
            var3.fillInStackTrace();
            throw var3;
        } else if (var1 < 0L) {
            var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 68, " 'len' should not be < 0");
            var3.fillInStackTrace();
            throw var3;
        } else {
            this.getDBAccess().trim(this, var1);
        }
    }

    public Object toJdbc() throws SQLException {
        if (this.isFree) {
            SQLException var1 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 192);
            var1.fillInStackTrace();
            throw var1;
        } else {
            return this;
        }
    }

    public boolean isConvertibleTo(Class var1) {
        String var2 = var1.getName();
        return var2.compareTo("java.io.InputStream") == 0 || var2.compareTo("java.io.Reader") == 0;
    }

    public Reader characterStreamValue() throws SQLException {
        return this.getCharacterStream();
    }

    public InputStream asciiStreamValue() throws SQLException {
        return this.getAsciiStream();
    }

    public InputStream binaryStreamValue() throws SQLException {
        return this.getAsciiStream();
    }

    public String stringValue() throws SQLException {
        Reader var1 = this.getCharacterStream();
        int var2 = this.getBufferSize();
        boolean var3 = false;
        StringWriter var4 = new StringWriter(var2);
        char[] var5 = new char[var2];

        SQLException var7;
        int var10;
        try {
            while((var10 = var1.read(var5)) != -1) {
                var4.write(var5, 0, var10);
            }
        } catch (IOException var8) {
            var7 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), var8);
            var7.fillInStackTrace();
            throw var7;
        } catch (IndexOutOfBoundsException var9) {
            var7 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 151);
            var7.fillInStackTrace();
            throw var7;
        }

        return var4.getBuffer().substring(0);
    }

    public Object makeJdbcArray(int var1) {
        return new CLOB[var1];
    }

    public ClobDBAccess getDBAccess() throws SQLException {
        SQLException var1;
        if (this.dbaccess == null) {
            if (this.isEmptyLob()) {
                var1 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 98);
                var1.fillInStackTrace();
                throw var1;
            }

            this.dbaccess = this.getInternalConnection().createClobDBAccess();
        }

        if (this.getPhysicalConnection().isClosed()) {
            var1 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 8);
            var1.fillInStackTrace();
            throw var1;
        } else {
            return this.dbaccess;
        }
    }

    public static ClobDBAccess getDBAccess(Connection var0) throws SQLException {
        return ((OracleConnection)var0).physicalConnectionWithin().createClobDBAccess();
    }

    public Connection getJavaSqlConnection() throws SQLException {
        if (this.isFree) {
            SQLException var1 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 192);
            var1.fillInStackTrace();
            throw var1;
        } else {
            return super.getJavaSqlConnection();
        }
    }

    public final void setLength(long var1) {
        this.cachedLengthOfClobInChars = var1;
    }

    public final void setChunkSize(int var1) {
        this.dbChunkSize = var1;
    }

    public final void setPrefetchedData(char[] var1) {
        if (var1 == null) {
            this.setPrefetchedData((char[])null, 0);
        } else {
            this.setPrefetchedData(var1, var1.length);
        }

    }

    public final void setPrefetchedData(char[] var1, int var2) {
        this.prefetchData = var1;
        this.prefetchDataSize = var2;
    }

    public final char[] getPrefetchedData() {
        return this.prefetchData;
    }

    public final int getPrefetchedDataSize() {
        return this.prefetchDataSize;
    }

    public final void setActivePrefetch(boolean var1) {
        if (this.activePrefetch && !var1) {
            this.clearCachedData();
        }

        this.activePrefetch = var1;
    }

    public final void clearCachedData() {
        this.cachedLengthOfClobInChars = -1L;
        this.prefetchData = null;
    }

    public final boolean isActivePrefetch() {
        return this.activePrefetch;
    }

    public boolean canReadBasicLobDataInLocator() throws SQLException {
        byte[] var1 = this.shareBytes();
        if (var1 != null && var1.length >= 102) {
            if (!this.getPhysicalConnection().isDataInLocatorEnabled()) {
                return false;
            } else {
                int var2 = var1[6] & 255;
                int var3 = var1[7] & 255;
                boolean var4 = (var2 & 8) == 8;
                boolean var5 = (var3 & -128) == -128;
                boolean var6 = false;
                if (var4 && !var5) {
                    int var7 = var1[88] & 255;
                    var6 = (var7 & 8) == 8;
                }

                boolean var9 = var4 && !var5 && var6;
                boolean var8 = false;
                if (var9) {
                    this.dilGetCharacterSet();
                    var8 = !this.dilCharacterSet.isUnknown();
                }

                return var8;
            }
        } else {
            return false;
        }
    }

    int dilGetCharSetId() throws SQLException {
        byte var1 = this.shareBytes()[32];
        byte var2 = this.shareBytes()[33];
        int var3 = (var1 & 255) << 8 | var2 & 255;
        return var3;
    }

    boolean isMigratedAL16UTF16LE() {
        int var1 = this.shareBytes()[7] & 255;
        return (var1 & 64) == 64;
    }

    boolean isVariableWidth() {
        int var1 = this.shareBytes()[6] & 255;
        short var2 = 128;
        return (var1 & var2) == var2;
    }

    void dilGetCharacterSet() throws SQLException {
        if (this.dilCharacterSet == null) {
            if (this.isMigratedAL16UTF16LE()) {
                this.dilCharacterSet = CharacterSet.make(2002);
            } else if (this.isVariableWidth()) {
                this.dilCharacterSet = CharacterSet.make(2000);
            } else {
                int var1 = this.dilGetCharSetId();
                this.dilCharacterSet = CharacterSet.make(var1);
            }
        }

    }

    int dilLength() {
        return this.shareBytes().length - 86 - 16;
    }

    char[] dilGetChars() throws SQLException {
        int var1 = this.dilLength();
        byte[] var2 = new byte[var1];
        System.arraycopy(this.shareBytes(), 102, var2, 0, var1);
        String var3 = this.dilCharacterSet.toStringWithReplacement(var2, 0, var1);
        char[] var4 = var3.toCharArray();
        return var4;
    }

    InputStream dilGetAsciiStream(long var1) throws SQLException {
        char[] var3 = this.dilGetChars();
        byte[] var4;
        if (var1 - 1L > (long)var3.length) {
            var4 = new byte[0];
            return new ByteArrayInputStream(var4);
        } else {
            if (this.dilGetCharSetId() == 1) {
                var4 = new byte[var3.length];

                for(int var5 = 0; var5 < var3.length; ++var5) {
                    var4[var5] = (byte)var3[var5];
                }
            } else {
                CharacterSet var6 = CharacterSet.make(1);
                var4 = var6.convertWithReplacement(new String(var3));
            }

            return new ByteArrayInputStream(var4);
        }
    }

    Reader dilGetCharacterStream(long var1) throws SQLException {
        char[] var3 = this.dilGetChars();
        int var4 = var3.length;
        if (var1 - 1L > (long)var4) {
            char[] var5 = new char[0];
            return new CharArrayReader(var5);
        } else {
            return new CharArrayReader(var3, (int)(var1 - 1L), 2147483647);
        }
    }

    String dilGetSubString(long var1, int var3) throws SQLException {
        char[] var4 = this.dilGetChars();
        if ((int)var1 > var4.length) {
            return "";
        } else {
            int var5 = (int)Math.min((long)var3, (long)var4.length - (var1 - 1L));
            return var5 == 0 ? "" : new String(var4, (int)(var1 - 1L), var5);
        }
    }

    public void free() throws SQLException {
        if (!this.isFree) {
            if (this.isOpen()) {
                this.close();
            }

            if (this.isTemporary()) {
                this.freeTemporary();
            }

            this.isFree = true;
            this.dbaccess = null;
        }
    }

    public Reader getCharacterStream(long var1, long var3) throws SQLException {
        SQLException var8;
        if (this.isFree) {
            var8 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 192);
            var8.fillInStackTrace();
            throw var8;
        } else {
            if (var1 == 0L) {
                if (this.getPhysicalConnection().isLobStreamPosStandardCompliant()) {
                    var8 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 68);
                    var8.fillInStackTrace();
                    throw var8;
                }

                var1 = 1L;
            }

            if (this.canReadBasicLobDataInLocator()) {
                return this.dilGetCharacterStream(var1, var3);
            } else {
                long var5 = this.length();
                if (var1 >= 1L && var3 >= 0L && var1 <= var5 && var1 - 1L + var3 <= var5) {
                    return this.getDBAccess().newReader(this, this.getChunkSize(), var1, var3);
                } else {
                    SQLException var7 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 68);
                    var7.fillInStackTrace();
                    throw var7;
                }
            }
        }
    }

    Reader dilGetCharacterStream(long var1, long var3) throws SQLException {
        if (var1 >= 1L && var3 >= 0L) {
            char[] var9 = this.dilGetChars();
            long var6 = (long)var9.length;
            if (var1 >= 1L && var3 >= 0L && var1 <= var6 && var1 - 1L + var3 <= var6) {
                return new CharArrayReader(var9, (int)(var1 - 1L), (int)var3);
            } else {
                SQLException var8 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 68);
                var8.fillInStackTrace();
                throw var8;
            }
        } else {
            SQLException var5 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 68);
            var5.fillInStackTrace();
            throw var5;
        }
    }

    public void setBytes(byte[] var1) {
        throw new UnsupportedOperationException();
    }

    public void setACProxy(Object var1) {
        this.acProxy = var1;
    }

    public Object getACProxy() {
        return this.acProxy;
    }
}
