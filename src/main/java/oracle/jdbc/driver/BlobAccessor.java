//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package oracle.jdbc.driver;

import java.io.InputStream;
import java.io.Reader;
import java.sql.SQLException;
import java.util.Map;
import oracle.sql.BLOB;
import oracle.sql.Datum;

class BlobAccessor extends LobCommonAccessor {
    static final int MAXLENGTH = 4000;
    private static final String _Copyright_2007_Oracle_All_Rights_Reserved_ = null;
    public static final String BUILD_DATE = "Thu_Apr_04_15:09:24_PDT_2013";
    public static final boolean TRACE = false;

    BlobAccessor(OracleStatement var1, int var2, short var3, int var4, boolean var5) throws SQLException {
        super(Representation.BLOB, var1, 4000, var5);
        this.init(var1, 113, 113, var3, var5);
        this.initForDataAccess(var4, var2, (String)null);
    }

    BlobAccessor(OracleStatement var1, int var2, boolean var3, int var4, int var5, int var6, int var7, int var8, short var9) throws SQLException {
        super(Representation.BLOB, var1, 4000, false);
        this.init(var1, 113, 113, var9, false);
        this.initForDescribe(113, var2, var3, var4, var5, var6, var7, var8, var9, (String)null);
        this.initForDataAccess(0, var2, (String)null);
    }

    Object getObject(int var1) throws SQLException {
        return this.getBLOB(var1);
    }

    Object getObject(int var1, Map var2) throws SQLException {
        return this.getBLOB(var1);
    }

    Datum getOracleObject(int var1) throws SQLException {
        return this.getBLOB(var1);
    }

    BLOB getBLOB(int var1) throws SQLException {
        if (this.isNull(var1)) {
            return null;
        } else {
            BLOB var2 = new BLOB(this.statement.connection, this.getBytesInternal(var1));
            if (this.isPrefetched()) {
                var2.setActivePrefetch(true);
                var2.setLength(this.getPrefetchedLength(var1));
                var2.setChunkSize(this.getPrefetchedChunkSize(var1));
                var2.setPrefetchedData(this.getPrefetchedData(var1));
            }

            return var2;
        }
    }

    InputStream getAsciiStream(int var1) throws SQLException {
        BLOB var2 = this.getBLOB(var1);
        return var2 == null ? null : var2.asciiStreamValue();
    }

    Reader getCharacterStream(int var1) throws SQLException {
        BLOB var2 = this.getBLOB(var1);
        return var2 == null ? null : var2.characterStreamValue();
    }

    InputStream getBinaryStream(int var1) throws SQLException {
        BLOB var2 = this.getBLOB(var1);
        return var2 == null ? null : var2.getBinaryStream();
    }

    byte[] getBytes(int var1) throws SQLException {
        if (this.isNull(var1)) {
            return null;
        } else if (this.isPrefetched() && this.getPrefetchedLength(var1) > 2147483647L) {
            SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 151);
            var3.fillInStackTrace();
            throw var3;
        } else if (this.isPrefetched() && (long)this.getPrefetchedDataLength(var1) == this.getPrefetchedLength(var1)) {
            return this.getPrefetchedData(var1);
        } else {
            BLOB var2 = this.getBLOB(var1);
            return var2 == null ? null : var2.getBytes(1L, (int)var2.length());
        }
    }

    String getString(int var1) throws SQLException {
        this.unimpl("getString/getNString");
        return null;
    }

    String getNString(int var1) throws SQLException {
        this.unimpl("getNString");
        return null;
    }

    long updateChecksum(long var1, int var3) throws SQLException {
        this.unimpl("updateChecksum");
        return -1L;
    }
}
