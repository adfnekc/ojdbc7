//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package oracle.sql;

import java.io.InputStream;
import java.io.Reader;
import java.sql.Connection;
import java.sql.SQLException;
import oracle.jdbc.LargeObjectAccessMode;
import oracle.jdbc.OracleConnection;
import oracle.jdbc.driver.DatabaseError;
import oracle.jdbc.internal.OracleBfile;

/** @deprecated */
public class BFILE extends DatumWithConnection implements OracleBfile {
    public static final int MAX_CHUNK_SIZE = 32512;
    public static final int MODE_READONLY = 0;
    public static final int MODE_READWRITE = 1;
    BfileDBAccess dbaccess;
    private long bfileLength;
    Object acProxy;
    private static final String _Copyright_2007_Oracle_All_Rights_Reserved_ = null;
    public static final String BUILD_DATE = "Thu_Apr_04_15:09:24_PDT_2013";
    public static final boolean TRACE = false;

    protected BFILE() {
        this.bfileLength = -1L;
    }

    public BFILE(OracleConnection var1) throws SQLException {
        this(var1, (byte[])null);
    }

    public BFILE(OracleConnection var1, byte[] var2) throws SQLException {
        super(var2);
        this.bfileLength = -1L;
        this.setPhysicalConnectionOf(var1);
        this.dbaccess = this.getInternalConnection().createBfileDBAccess();
    }

    public long length() throws SQLException {
        this.bfileLength = this.getDBAccess().length(this);
        return this.bfileLength;
    }

    public byte[] getBytes(long var1, int var3) throws SQLException {
        SQLException var4;
        if (var1 >= 1L && var3 >= 0) {
            var4 = null;
            byte[] var8;
            if (var3 == 0) {
                var8 = new byte[0];
            } else {
                long var5 = 0L;
                byte[] var7 = new byte[var3];
                var5 = (long)this.getBytes(var1, var3, var7);
                if (var5 > 0L) {
                    if (var5 == (long)var3) {
                        var8 = var7;
                    } else {
                        var8 = new byte[(int)var5];
                        System.arraycopy(var7, 0, var8, 0, (int)var5);
                    }
                } else {
                    var8 = new byte[0];
                }
            }

            return var8;
        } else {
            var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 68, (Object)null);
            var4.fillInStackTrace();
            throw var4;
        }
    }

    public int getBytes(long var1, int var3, byte[] var4) throws SQLException {
        int var5 = this.getDBAccess().getBytes(this, var1, var3, var4);
        return var5;
    }

    public InputStream getBinaryStream() throws SQLException {
        InputStream var1 = this.getDBAccess().newInputStream(this, 32512, 0L);
        return var1;
    }

    public long position(byte[] var1, long var2) throws SQLException {
        long var4 = this.getDBAccess().position(this, var1, var2);
        return var4;
    }

    public long position(BFILE var1, long var2) throws SQLException {
        long var4 = this.getDBAccess().position(this, var1, var2);
        return var4;
    }

    public long position(oracle.jdbc.OracleBfile var1, long var2) throws SQLException {
        return this.position((BFILE)var1, var2);
    }

    public String getName() throws SQLException {
        String var1 = this.getDBAccess().getName(this);
        return var1;
    }

    public String getDirAlias() throws SQLException {
        String var1 = this.getDBAccess().getDirAlias(this);
        return var1;
    }

    public void openFile() throws SQLException {
        this.getDBAccess().openFile(this);
    }

    public boolean isFileOpen() throws SQLException {
        boolean var1 = this.getDBAccess().isFileOpen(this);
        return var1;
    }

    public boolean fileExists() throws SQLException {
        boolean var1 = this.getDBAccess().fileExists(this);
        return var1;
    }

    public void closeFile() throws SQLException {
        this.getDBAccess().closeFile(this);
    }

    public byte[] getLocator() {
        return this.getBytes();
    }

    public void setLocator(byte[] var1) {
        super.setBytes(var1);
    }

    public InputStream getBinaryStream(long var1) throws SQLException {
        return this.getDBAccess().newInputStream(this, 32512, var1);
    }

    public void open() throws SQLException {
        this.getDBAccess().open(this, 0);
    }

    public void open(LargeObjectAccessMode var1) throws SQLException {
        this.open(var1.getCode());
    }

    public void open(int var1) throws SQLException {
        if (var1 != 0) {
            SQLException var2 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 102);
            var2.fillInStackTrace();
            throw var2;
        } else {
            this.getDBAccess().open(this, var1);
        }
    }

    public void close() throws SQLException {
        this.getDBAccess().close(this);
    }

    public boolean isOpen() throws SQLException {
        return this.getDBAccess().isOpen(this);
    }

    public Object toJdbc() throws SQLException {
        return this;
    }

    public boolean isConvertibleTo(Class var1) {
        String var2 = var1.getName();
        boolean var3 = var2.compareTo("java.io.InputStream") == 0 || var2.compareTo("java.io.Reader") == 0;
        return var3;
    }

    public Reader characterStreamValue() throws SQLException {
        BfileDBAccess var10000 = this.getDBAccess();
        this.getInternalConnection();
        return var10000.newConversionReader(this, 8);
    }

    public InputStream asciiStreamValue() throws SQLException {
        BfileDBAccess var10000 = this.getDBAccess();
        this.getInternalConnection();
        return var10000.newConversionInputStream(this, 2);
    }

    public InputStream binaryStreamValue() throws SQLException {
        return this.getBinaryStream();
    }

    public Object makeJdbcArray(int var1) {
        return new BFILE[var1];
    }

    public BfileDBAccess getDBAccess() throws SQLException {
        if (this.dbaccess == null) {
            this.dbaccess = this.getInternalConnection().createBfileDBAccess();
        }

        if (this.getPhysicalConnection().isClosed()) {
            SQLException var1 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 8);
            var1.fillInStackTrace();
            throw var1;
        } else {
            return this.dbaccess;
        }
    }

    public final void setLength(long var1) {
        this.bfileLength = var1;
    }

    public Connection getJavaSqlConnection() throws SQLException {
        return super.getJavaSqlConnection();
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
