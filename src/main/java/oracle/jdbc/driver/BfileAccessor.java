//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package oracle.jdbc.driver;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.sql.SQLException;
import java.util.Map;
import oracle.sql.BFILE;
import oracle.sql.Datum;

class BfileAccessor extends LobCommonAccessor {
    static final int MAXLENGTH = 530;
    private static final String _Copyright_2007_Oracle_All_Rights_Reserved_ = null;
    public static final String BUILD_DATE = "Thu_Apr_04_15:09:24_PDT_2013";
    public static final boolean TRACE = false;

    BfileAccessor(OracleStatement var1, int var2, short var3, int var4, boolean var5) throws SQLException {
        super(Representation.BFILE, var1, 530, var5);
        this.init(var1, 114, 114, var3, var5);
        this.initForDataAccess(var4, var2, (String)null);
    }

    BfileAccessor(OracleStatement var1, int var2, boolean var3, int var4, int var5, int var6, int var7, int var8, short var9) throws SQLException {
        super(Representation.BFILE, var1, 530, false);
        this.init(var1, 114, 114, var9, false);
        this.initForDescribe(114, var2, var3, var4, var5, var6, var7, var8, var9, (String)null);
        this.initForDataAccess(0, var2, (String)null);
    }

    Object getObject(int var1) throws SQLException {
        return this.getBFILE(var1);
    }

    Object getObject(int var1, Map var2) throws SQLException {
        return this.getBFILE(var1);
    }

    Datum getOracleObject(int var1) throws SQLException {
        return this.getBFILE(var1);
    }

    BFILE getBFILE(int var1) throws SQLException {
        if (this.isNull(var1)) {
            return null;
        } else {
            BFILE var2 = new BFILE(this.statement.connection, this.getBytesInternal(var1));
            if (this.isPrefetched()) {
                var2.setLength(this.getPrefetchedLength(var1));
            }

            return var2;
        }
    }

    InputStream getAsciiStream(int var1) throws SQLException {
        BFILE var2 = this.getBFILE(var1);
        return var2 == null ? null : var2.asciiStreamValue();
    }

    Reader getCharacterStream(int var1) throws SQLException {
        BFILE var2 = this.getBFILE(var1);
        return var2 == null ? null : var2.characterStreamValue();
    }

    InputStream getBinaryStream(int var1) throws SQLException {
        BFILE var2 = this.getBFILE(var1);
        return var2 == null ? null : var2.getBinaryStream();
    }

    byte[] getBytes(int var1) throws SQLException {
        BFILE var2 = this.getBFILE(var1);
        if (var2 == null) {
            return null;
        } else {
            InputStream var3 = var2.getBinaryStream();
            short var4 = 4096;
            boolean var5 = false;
            ByteArrayOutputStream var6 = new ByteArrayOutputStream(var4);
            byte[] var7 = new byte[var4];

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

            return var6.toByteArray();
        }
    }
}
