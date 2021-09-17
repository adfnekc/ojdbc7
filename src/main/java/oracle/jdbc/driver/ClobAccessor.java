//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package oracle.jdbc.driver;

import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.io.StringWriter;
import java.sql.SQLException;
import java.util.Map;
import oracle.sql.CLOB;
import oracle.sql.CharacterSet;
import oracle.sql.Datum;
import oracle.sql.NCLOB;

class ClobAccessor extends LobCommonAccessor {
    static final int MAXLENGTH = 4000;
    int[] prefetchedDataCharset;
    int[] prefetchedDataFormOfUse;
    private CharacterSet cachedCharSet = null;
    private static final String _Copyright_2007_Oracle_All_Rights_Reserved_ = null;
    public static final String BUILD_DATE = "Thu_Apr_04_15:09:24_PDT_2013";
    public static final boolean TRACE = false;

    ClobAccessor(OracleStatement var1, int var2, short var3, int var4, boolean var5) throws SQLException {
        super(var3 == 2 ? Representation.NCLOB : Representation.CLOB, var1, 4000, var5);
        this.init(var1, 112, 112, var3, var5);
        this.initForDataAccess(var4, var2, (String)null);
    }

    ClobAccessor(OracleStatement var1, int var2, boolean var3, int var4, int var5, int var6, int var7, int var8, short var9) throws SQLException {
        super(var9 == 2 ? Representation.NCLOB : Representation.CLOB, var1, 4000, false);
        this.init(var1, 112, 112, var9, false);
        this.initForDescribe(112, var2, var3, var4, var5, var6, var7, var8, var9, (String)null);
        this.initForDataAccess(0, var2, (String)null);
    }

    void setCapacity(int var1) {
        super.setCapacity(var1);
        if (this.prefetchedDataCharset == null) {
            this.prefetchedDataCharset = new int[var1];
            this.prefetchedDataFormOfUse = new int[var1];
        } else if (var1 > this.prefetchedDataCharset.length) {
            int[] var2 = new int[var1];
            System.arraycopy(this.prefetchedDataCharset, 0, var2, 0, this.prefetchedDataCharset.length);
            this.prefetchedDataCharset = var2;
            var2 = new int[var1];
            System.arraycopy(this.prefetchedDataFormOfUse, 0, var2, 0, this.prefetchedDataFormOfUse.length);
            this.prefetchedDataFormOfUse = var2;
        }

    }

    Accessor copyForDefine(OracleStatement var1) {
        ClobAccessor var2 = (ClobAccessor)super.copyForDefine(var1);
        var2.prefetchedDataCharset = null;
        var2.prefetchedDataFormOfUse = null;
        return var2;
    }

    protected void copyFromInternal(Accessor var1, int var2, int var3) throws SQLException {
        super.copyFromInternal(var1, var2, var3);
        if (this.isPrefetched()) {
            ClobAccessor var4 = (ClobAccessor)var1;
            this.setPrefetchedDataCharset(var3, var4.getPrefetchedDataCharset(var2));
            this.setPrefetchedDataFormOfUse(var3, var4.getPrefetchedDataFormOfUse(var2));
        }

    }

    void deleteRow(int var1) throws SQLException {
        super.deleteRow(var1);
        if (this.isPrefetched()) {
            this.delete(this.prefetchedDataCharset, var1);
            this.delete(this.prefetchedDataFormOfUse, var1);
        }

    }

    final int getPrefetchedDataCharset(int var1) {
        return this.prefetchedDataCharset[var1];
    }

    final void setPrefetchedDataCharset(int var1, int var2) {
        this.prefetchedDataCharset[var1] = var2;
    }

    final int getPrefetchedDataFormOfUse(int var1) {
        return this.prefetchedDataFormOfUse[var1];
    }

    final void setPrefetchedDataFormOfUse(int var1, int var2) {
        this.prefetchedDataFormOfUse[var1] = var2;
    }

    Object getObject(int var1) throws SQLException {
        return this.getCLOB(var1);
    }

    Object getObject(int var1, Map var2) throws SQLException {
        return this.getCLOB(var1);
    }

    Datum getOracleObject(int var1) throws SQLException {
        return this.getCLOB(var1);
    }

    protected void normalizeFormOfUse(byte[] var1) {
        short var2 = oracle.sql.CLOB.getFormOfUseFromLocator(var1);
        if (var2 != -1) {
            this.formOfUse = var2;
        }

    }

    private CLOB getCLOB_(int var1, byte[] var2) throws SQLException {
        Object var3;
        if (this.formOfUse == 1) {
            var3 = new CLOB(this.statement.connection, var2, this.formOfUse);
        } else {
            var3 = new NCLOB(this.statement.connection, var2);
        }

        if (this.isPrefetched()) {
            ((CLOB)var3).setActivePrefetch(true);
            ((CLOB)var3).setLength(this.getPrefetchedLength(var1));
            ((CLOB)var3).setChunkSize(this.getPrefetchedChunkSize(var1));
            int[] var4 = new int[1];
            ((CLOB)var3).setPrefetchedData(this.getPrefetchedCharData(var1, var4), var4[0]);
        }

        return (CLOB)var3;
    }

    CLOB getCLOB(int var1) throws SQLException {
        if (this.isNull(var1)) {
            return null;
        } else {
            byte[] var3 = this.getBytesInternal(var1);
            this.normalizeFormOfUse(var3);
            CLOB var2 = this.getCLOB_(var1, var3);
            return var2;
        }
    }

    NCLOB getNCLOB(int var1) throws SQLException {
        if (this.isNull(var1)) {
            return null;
        } else {
            byte[] var2 = this.getBytesInternal(var1);
            this.normalizeFormOfUse(var2);
            if (this.formOfUse != 2) {
                SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 132);
                var3.fillInStackTrace();
                throw var3;
            } else {
                return (NCLOB)this.getCLOB_(var1, var2);
            }
        }
    }

    final char[] XgetPrefetchedCharData(int var1, int[] var2) throws SQLException {
        if (this.getPrefetchLength() == -1) {
            return null;
        } else {
            boolean var3 = true;
            int var4 = this.getPrefetchedDataLength(var1);
            char[] var5 = new char[this.getPrefetchedDataLength(var1)];
            byte[] var6 = this.rowData.get(this.getPrefetchedDataOffset(var1), this.getPrefetchedDataLength(var1));
            int var8;
            if (this.getPrefetchedDataCharset(var1) != 0) {
                if (this.getPrefetchedDataCharset(var1) == 2000) {
                    var8 = CharacterSet.convertAL16UTF16BytesToJavaChars(var6, 0, var5, 0, var4, true);
                } else {
                    var8 = CharacterSet.convertAL16UTF16LEBytesToJavaChars(var6, 0, var5, 0, var4, true);
                }
            } else {
                int[] var7 = new int[]{var4};
                if (this.formOfUse == 1) {
                    var8 = this.statement.connection.conversion.CHARBytesToJavaChars(var6, 0, var5, 0, var7, var5.length);
                } else {
                    var8 = this.statement.connection.conversion.NCHARBytesToJavaChars(var6, 0, var5, 0, var7, var5.length);
                }
            }

            var2[0] = var8;
            return var5;
        }
    }

    final char[] getPrefetchedCharData(int var1, int[] var2) throws SQLException {
        if (this.getPrefetchLength() == -1) {
            return null;
        } else {
            char[] var3;
            if (this.getPrefetchedDataCharset(var1) == 0) {
                var3 = ((DynamicByteArray)this.rowData).getChars(this.getPrefetchedDataOffset(var1), this.getPrefetchedDataLength(var1), this.statement.connection.conversion.getCharacterSet((short)this.getPrefetchedDataFormOfUse(var1)), var2);
                return var3;
            } else {
                if (this.cachedCharSet == null || this.cachedCharSet.getOracleId() != this.getPrefetchedDataCharset(var1)) {
                    this.cachedCharSet = CharacterSet.make(this.getPrefetchedDataCharset(var1));
                }

                var3 = ((DynamicByteArray)this.rowData).getChars(this.getPrefetchedDataOffset(var1), this.getPrefetchedDataLength(var1), this.cachedCharSet, var2);
                return var3;
            }
        }
    }

    InputStream getAsciiStream(int var1) throws SQLException {
        CLOB var2 = this.getCLOB(var1);
        return var2 == null ? null : var2.getAsciiStream();
    }

    Reader getCharacterStream(int var1) throws SQLException {
        CLOB var2 = this.getCLOB(var1);
        return var2 == null ? null : var2.getCharacterStream();
    }

    InputStream getBinaryStream(int var1) throws SQLException {
        CLOB var2 = this.getCLOB(var1);
        return var2 == null ? null : var2.getAsciiStream();
    }

    String getString(int var1) throws SQLException {
        if (this.isNull(var1)) {
            return null;
        } else if (this.isPrefetched() && this.getPrefetchedLength(var1) > 2147483647L) {
            SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 151);
            var3.fillInStackTrace();
            throw var3;
        } else if (this.isPrefetched() && this.getPrefetchedLength(var1) == (long)this.getPrefetchedDataLength(var1)) {
            return this.rowData.getString(this.getPrefetchedDataOffset(var1), this.getPrefetchedDataLength(var1), this.statement.connection.conversion.getCharacterSet((short)this.getPrefetchedDataFormOfUse(var1)));
        } else if (this.isPrefetched()) {
            CLOB var2 = this.getCLOB(var1);
            return var2 == null ? null : var2.getSubString(1L, (int)this.getPrefetchedLength(var1));
        } else {
            return this.getStringNoPrefetch(var1);
        }
    }

    String getStringNoPrefetch(int var1) throws SQLException {
        CLOB var2 = this.getCLOB(var1);
        if (var2 == null) {
            return null;
        } else {
            Reader var3 = var2.getCharacterStream();
            int var4 = var2.getBufferSize();
            boolean var5 = false;
            StringWriter var6 = new StringWriter(var4);
            char[] var7 = new char[var4];

            SQLException var9;
            int var12;
            try {
                while((var12 = var3.read(var7)) != -1) {
                    var6.write(var7, 0, var12);
                }
            } catch (IOException var10) {
                var9 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), var10);
                var9.fillInStackTrace();
                throw var9;
            } catch (IndexOutOfBoundsException var11) {
                var9 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 151);
                var9.fillInStackTrace();
                throw var9;
            }

            if (var2.isTemporary()) {
                this.statement.addToTempLobsToFree(var2);
            }

            return var6.getBuffer().substring(0);
        }
    }

    byte[] getBytes(int var1) throws SQLException {
        SQLException var2 = DatabaseError.createUnsupportedFeatureSqlException();
        var2.fillInStackTrace();
        throw var2;
    }

    long updateChecksum(long var1, int var3) throws SQLException {
        this.unimpl("updateChecksum");
        return -1L;
    }
}
