//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package oracle.sql;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.SQLException;
import oracle.jdbc.LargeObjectAccessMode;
import oracle.jdbc.OracleConnection;
import oracle.jdbc.driver.DatabaseError;
import oracle.jdbc.internal.OracleBlob;

/** @deprecated */
public class BLOB extends DatumWithConnection implements OracleBlob {
    public static final int MAX_CHUNK_SIZE = 32768;
    public static final int DURATION_SESSION = 10;
    public static final int DURATION_CALL = 12;
    static final int OLD_WRONG_DURATION_SESSION = 1;
    static final int OLD_WRONG_DURATION_CALL = 2;
    public static final int MODE_READONLY = 0;
    public static final int MODE_READWRITE = 1;
    BlobDBAccess dbaccess;
    int dbChunkSize;
    boolean isFree;
    boolean fromObject;
    private long cachedLobLength;
    private byte[] prefetchData;
    private int prefetchDataSize;
    private boolean activePrefetch;
    static final int KDLCTLSIZE = 16;
    static final int KDF_FLAG = 88;
    static final int KDLIDDAT = 8;
    Object acProxy;
    private static final String _Copyright_2007_Oracle_All_Rights_Reserved_ = null;
    public static final String BUILD_DATE = "Thu_Apr_04_15:09:24_PDT_2013";
    public static final boolean TRACE = false;

    protected BLOB() {
        this.dbChunkSize = -1;
        this.isFree = false;
        this.fromObject = false;
        this.cachedLobLength = -1L;
        this.prefetchDataSize = 0;
        this.activePrefetch = false;
    }

    public BLOB(OracleConnection var1) throws SQLException {
        this(var1, (byte[])null);
    }

    public BLOB(OracleConnection var1, byte[] var2, boolean var3) throws SQLException {
        this(var1, var2);
        this.fromObject = var3;
    }

    public BLOB(OracleConnection var1, byte[] var2) throws SQLException {
        super(var2);
        this.dbChunkSize = -1;
        this.isFree = false;
        this.fromObject = false;
        this.cachedLobLength = -1L;
        this.prefetchDataSize = 0;
        this.activePrefetch = false;
        assertNotNull(var1);
        this.setPhysicalConnectionOf(var1);
        this.dbaccess = this.getPhysicalConnection().createBlobDBAccess();
        this.dbaccess.incrementTempLobReferenceCount(var2);
    }

    public long length() throws SQLException {
        if (this.isFree) {
            SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 192);
            var3.fillInStackTrace();
            throw var3;
        } else {
            long var1 = -1L;
            if (this.activePrefetch && this.cachedLobLength != -1L) {
                var1 = this.cachedLobLength;
            } else if (this.canReadBasicLobDataInLocator()) {
                var1 = (long)this.dilLength();
            } else {
                var1 = this.getDBAccess().length(this);
            }

            return var1;
        }
    }

    public byte[] getBytes(long var1, int var3) throws SQLException {
        SQLException var4;
        if (this.isFree) {
            var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 192);
            var4.fillInStackTrace();
            throw var4;
        } else if (var3 >= 0 && var1 >= 1L) {
            if (this.canReadBasicLobDataInLocator()) {
                return this.dilGetBytes(var1, var3);
            } else {
                byte[] var8 = null;
                if (var3 == 0) {
                    return new byte[0];
                } else {
                    if (this.activePrefetch && (this.cachedLobLength == 0L || this.cachedLobLength > 0L && var1 - 1L >= this.cachedLobLength)) {
                        var8 = null;
                    } else {
                        long var5 = 0L;
                        byte[] var7;
                        if (this.activePrefetch && this.cachedLobLength != -1L) {
                            var7 = new byte[Math.min((int)this.cachedLobLength, var3)];
                        } else {
                            var7 = new byte[var3];
                        }

                        var5 = (long)this.getBytes(var1, var3, var7);
                        if (var5 > 0L) {
                            if (var5 == (long)var3) {
                                var8 = var7;
                            } else {
                                var8 = new byte[(int)var5];
                                System.arraycopy(var7, 0, var8, 0, (int)var5);
                            }
                        }
                    }

                    return var8;
                }
            }
        } else {
            var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 68, "getBytes()");
            var4.fillInStackTrace();
            throw var4;
        }
    }

    public InputStream getBinaryStream() throws SQLException {
        if (this.isFree) {
            SQLException var1 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 192);
            var1.fillInStackTrace();
            throw var1;
        } else {
            return this.canReadBasicLobDataInLocator() ? this.dilGetBinaryStream(1L) : this.getDBAccess().newInputStream(this, this.getBufferSize(), 0L);
        }
    }

    public long position(byte[] var1, long var2) throws SQLException {
        if (this.isFree) {
            SQLException var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 192);
            var4.fillInStackTrace();
            throw var4;
        } else {
            return this.getDBAccess().position(this, var1, var2);
        }
    }

    public long position(Blob var1, long var2) throws SQLException {
        if (this.isFree) {
            SQLException var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 192);
            var4.fillInStackTrace();
            throw var4;
        } else {
            return this.getDBAccess().position(this, (BLOB)var1, var2);
        }
    }

    public int getBytes(long var1, int var3, byte[] var4) throws SQLException {
        SQLException var5;
        if (this.isFree) {
            var5 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 192);
            var5.fillInStackTrace();
            throw var5;
        } else if (var3 >= 0 && var1 >= 0L) {
            if (var4.length < var3) {
                var3 = var4.length;
            }

            return this.getDBAccess().getBytes(this, var1, var3, var4);
        } else {
            var5 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 68, "getBytes()");
            var5.fillInStackTrace();
            throw var5;
        }
    }

    /** @deprecated */
    public int putBytes(long var1, byte[] var3) throws SQLException {
        if (this.isFree) {
            SQLException var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 192);
            var4.fillInStackTrace();
            throw var4;
        } else {
            return this.setBytes(var1, var3);
        }
    }

    /** @deprecated */
    public int putBytes(long var1, byte[] var3, int var4) throws SQLException {
        if (this.isFree) {
            SQLException var5 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 192);
            var5.fillInStackTrace();
            throw var5;
        } else {
            return this.setBytes(var1, var3, 0, var4);
        }
    }

    /** @deprecated */
    public OutputStream getBinaryOutputStream() throws SQLException {
        if (this.isFree) {
            SQLException var1 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 192);
            var1.fillInStackTrace();
            throw var1;
        } else {
            return this.setBinaryStream(1L);
        }
    }

    public byte[] getLocator() {
        return this.getBytes();
    }

    public void setLocator(byte[] var1) {
        super.setBytes(var1);
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
            int var2;
            if (var1 < 32768 && var1 > 0) {
                var2 = '耀' / var1 * var1;
            } else {
                var2 = 32768;
            }

            return var2;
        }
    }

    /** @deprecated */
    public static BLOB empty_lob() throws SQLException {
        return getEmptyBLOB();
    }

    public static BLOB getEmptyBLOB() throws SQLException {
        byte[] var0 = new byte[86];
        var0[1] = 84;
        var0[5] = 24;
        BLOB var1 = new BLOB();
        var1.setShareBytes(var0);
        return var1;
    }

    public boolean isEmptyLob() throws SQLException {
        if (this.isFree) {
            SQLException var2 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 192);
            var2.fillInStackTrace();
            throw var2;
        } else {
            boolean var1 = (this.shareBytes()[5] & 16) != 0;
            return var1;
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
    public OutputStream getBinaryOutputStream(long var1) throws SQLException {
        if (this.isFree) {
            SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 192);
            var3.fillInStackTrace();
            throw var3;
        } else {
            return this.getDBAccess().newOutputStream(this, this.getBufferSize(), var1, false);
        }
    }

    public InputStream getBinaryStream(long var1) throws SQLException {
        if (this.isFree) {
            SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 192);
            var3.fillInStackTrace();
            throw var3;
        } else {
            return this.canReadBasicLobDataInLocator() ? this.dilGetBinaryStream(var1) : this.getDBAccess().newInputStream(this, this.getBufferSize(), var1);
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

    public static BLOB createTemporary(Connection var0, boolean var1, int var2) throws SQLException {
        int var3 = var2;
        if (var2 == 1) {
            var3 = 10;
        }

        if (var2 == 2) {
            var3 = 12;
        }

        if (var0 != null && (var3 == 10 || var3 == 12)) {
            oracle.jdbc.internal.OracleConnection var5 = ((OracleConnection)var0).physicalConnectionWithin();
            return getDBAccess(var5).createTemporaryBlob(var5, var1, var3);
        } else {
            SQLException var4 = DatabaseError.createSqlException((oracle.jdbc.internal.OracleConnection)null, 68, "'conn' should not be null and 'duration' should either be equal to DURATION_SESSION or to DURATION_CALL");
            var4.fillInStackTrace();
            throw var4;
        }
    }

    public static void freeTemporary(BLOB var0) throws SQLException {
        if (var0 != null) {
            var0.freeTemporary();
        }
    }

    public static boolean isTemporary(BLOB var0) throws SQLException {
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

    public int setBytes(long var1, byte[] var3) throws SQLException {
        if (this.isFree) {
            SQLException var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 192);
            var4.fillInStackTrace();
            throw var4;
        } else {
            return this.getDBAccess().putBytes(this, var1, var3, 0, var3 != null ? var3.length : 0);
        }
    }

    public int setBytes(long var1, byte[] var3, int var4, int var5) throws SQLException {
        if (this.isFree) {
            SQLException var6 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 192);
            var6.fillInStackTrace();
            throw var6;
        } else {
            return this.getDBAccess().putBytes(this, var1, var3, var4, var5);
        }
    }

    public OutputStream setBinaryStream(long var1) throws SQLException {
        if (this.isFree) {
            SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 192);
            var3.fillInStackTrace();
            throw var3;
        } else {
            return this.getDBAccess().newOutputStream(this, this.getBufferSize(), var1, true);
        }
    }

    public void truncate(long var1) throws SQLException {
        SQLException var3;
        if (this.isFree) {
            var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 192);
            var3.fillInStackTrace();
            throw var3;
        } else if (var1 < 0L) {
            var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 68, "'len' should be >= 0. ");
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
        BlobDBAccess var10000 = this.getDBAccess();
        this.getInternalConnection();
        return var10000.newConversionReader(this, 8);
    }

    public InputStream asciiStreamValue() throws SQLException {
        BlobDBAccess var10000 = this.getDBAccess();
        this.getInternalConnection();
        return var10000.newConversionInputStream(this, 2);
    }

    public InputStream binaryStreamValue() throws SQLException {
        return this.getBinaryStream();
    }

    public Object makeJdbcArray(int var1) {
        return new BLOB[var1];
    }

    public BlobDBAccess getDBAccess() throws SQLException {
        SQLException var1;
        if (this.dbaccess == null) {
            if (this.isEmptyLob()) {
                var1 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 98);
                var1.fillInStackTrace();
                throw var1;
            }

            this.dbaccess = this.getInternalConnection().createBlobDBAccess();
        }

        if (this.getPhysicalConnection().isClosed()) {
            var1 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 8);
            var1.fillInStackTrace();
            throw var1;
        } else {
            return this.dbaccess;
        }
    }

    public static BlobDBAccess getDBAccess(Connection var0) throws SQLException {
        return ((OracleConnection)var0).physicalConnectionWithin().createBlobDBAccess();
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
        this.cachedLobLength = var1;
    }

    public final void setChunkSize(int var1) {
        this.dbChunkSize = var1;
    }

    public final void setPrefetchedData(byte[] var1) {
        if (var1 == null) {
            this.setPrefetchedData((byte[])null, 0);
        } else {
            this.setPrefetchedData(var1, var1.length);
        }

    }

    public final void setPrefetchedData(byte[] var1, int var2) {
        this.prefetchData = var1;
        this.prefetchDataSize = var2;
    }

    public final byte[] getPrefetchedData() {
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
        this.cachedLobLength = -1L;
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

                boolean var8 = var4 && !var5 && var6;
                return var8;
            }
        } else {
            return false;
        }
    }

    int dilLength() {
        return this.shareBytes().length - 86 - 16;
    }

    byte[] dilGetBytes(long var1, int var3) throws SQLException {
        if (var3 == 0) {
            return new byte[0];
        } else if (this.dilLength() == 0) {
            return null;
        } else {
            int var4 = (int)Math.min((long)var3, (long)this.dilLength() - (var1 - 1L));
            if (var4 <= 0) {
                return null;
            } else {
                byte[] var5 = new byte[var4];
                System.arraycopy(this.shareBytes(), (int)(var1 - 1L) + 86 + 16, var5, 0, var4);
                return var5;
            }
        }
    }

    InputStream dilGetBinaryStream(long var1) throws SQLException {
        if (var1 < 0L) {
            throw new IllegalArgumentException("Illegal Arguments");
        } else {
            byte[] var3 = this.dilGetBytes(var1, this.dilLength());
            if (var3 == null) {
                var3 = new byte[0];
            }

            return new ByteArrayInputStream(var3);
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

    public InputStream getBinaryStream(long var1, long var3) throws SQLException {
        if (this.isFree) {
            SQLException var8 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 192);
            var8.fillInStackTrace();
            throw var8;
        } else if (this.canReadBasicLobDataInLocator()) {
            return this.dilGetBinaryStream(var1, var3);
        } else {
            long var5 = this.length();
            if (var1 >= 1L && var3 >= 0L && var1 <= var5 && var1 - 1L + var3 <= var5) {
                return this.getDBAccess().newInputStream(this, this.getChunkSize(), var1, var3);
            } else {
                SQLException var7 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 68);
                var7.fillInStackTrace();
                throw var7;
            }
        }
    }

    InputStream dilGetBinaryStream(long var1, long var3) throws SQLException {
        int var5 = this.dilLength();
        if (var1 >= 1L && var3 >= 0L && var1 <= (long)var5 && var1 - 1L + var3 <= (long)var5) {
            byte[] var7 = this.dilGetBytes(var1, var5 - (int)(var1 - 1L));
            return new ByteArrayInputStream(var7, 0, (int)var3);
        } else {
            SQLException var6 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 68);
            var6.fillInStackTrace();
            throw var6;
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
