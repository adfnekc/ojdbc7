//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package oracle.jdbc.driver;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.sql.SQLException;

class LongRawAccessor extends RawCommonAccessor {
    static final int MAXLENGTH = 2147483647;
    OracleInputStream stream;
    int columnPosition = 0;
    private static final String _Copyright_2007_Oracle_All_Rights_Reserved_ = null;
    public static final String BUILD_DATE = "Thu_Apr_04_15:09:24_PDT_2013";
    public static final boolean TRACE = false;

    LongRawAccessor(OracleStatement var1, int var2, int var3, short var4, int var5) throws SQLException {
        super(var1, 2147483647, false);
        this.init(var1, 24, 24, var4, false);
        this.columnPosition = var2;
        this.initForDataAccess(var5, var3, (String)null);
    }

    LongRawAccessor(OracleStatement var1, int var2, int var3, boolean var4, int var5, int var6, int var7, int var8, int var9, short var10) throws SQLException {
        super(var1, 2147483647, false);
        this.init(var1, 24, 24, var10, false);
        this.columnPosition = var2;
        this.initForDescribe(24, var3, var4, var5, var6, var7, var8, var9, var10, (String)null);
        int var11 = var1.maxFieldSize;
        if (var11 > 0 && (var3 == 0 || var11 < var3)) {
            var3 = var11;
        }

        this.initForDataAccess(0, var3, (String)null);
    }

    void initForDataAccess(int var1, int var2, String var3) throws SQLException {
        if (var1 != 0) {
            this.externalType = var1;
        }

        this.isStream = true;
        this.isColumnNumberAware = true;
        this.byteLength = 0;
        this.stream = this.statement.connection.driverExtension.createInputStream(this.statement, this.columnPosition, this);
    }

    OracleInputStream initForNewRow() throws SQLException {
        this.stream = this.statement.connection.driverExtension.createInputStream(this.statement, this.columnPosition, this);
        return this.stream;
    }

    void updateColumnNumber(int var1) {
        ++var1;
        this.columnPosition = var1;
        if (this.stream != null) {
            this.stream.columnIndex = var1;
        }

    }

    byte[] getBytesInternal(int var1) throws SQLException {
        if (this.isNull(var1)) {
            return null;
        } else if (this.statement.isFetchStreams) {
            return super.getBytesInternal(var1);
        } else if (this.stream == null) {
            return null;
        } else if (!this.isStream) {
            return super.getBytesInternal(var1);
        } else if (this.stream.closed) {
            SQLException var8 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 27);
            var8.fillInStackTrace();
            throw var8;
        } else {
            ByteArrayOutputStream var2 = new ByteArrayOutputStream(1024);
            byte[] var3 = new byte[1024];

            int var4;
            try {
                while((var4 = this.stream.read(var3)) != -1) {
                    var2.write(var3, 0, var4);
                }
            } catch (IOException var7) {
                SQLException var6 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), var7);
                var6.fillInStackTrace();
                throw var6;
            }

            return var2.toByteArray();
        }
    }

    protected InputStream convertBytesToStream(int var1, int var2) throws SQLException {
        ByteArrayInputStream var3 = new ByteArrayInputStream(this.getBytesInternal(var1));

        InputStream var5;
        try {
            InputStream var4 = this.statement.connection.conversion.ConvertStream(var3, var2);
            var5 = var4;
        } finally {
            try {
                if (var3 != null) {
                    var3.close();
                }
            } catch (IOException var12) {
            }

        }

        return var5;
    }

    InputStream getAsciiStream(int var1) throws SQLException {
        PhysicalConnection var2 = this.statement.connection;
        if (this.isNull(var1)) {
            return null;
        } else if (this.statement.isFetchStreams) {
            return this.convertBytesToStream(var1, 2);
        } else if (this.stream.closed) {
            SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 27);
            var3.fillInStackTrace();
            throw var3;
        } else {
            return var2.conversion.ConvertStream(this.stream, 2);
        }
    }

    InputStream getUnicodeStream(int var1) throws SQLException {
        PhysicalConnection var2 = this.statement.connection;
        if (this.isNull(var1)) {
            return null;
        } else if (this.statement.isFetchStreams) {
            return this.convertBytesToStream(var1, 3);
        } else if (this.stream.closed) {
            SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 27);
            var3.fillInStackTrace();
            throw var3;
        } else {
            return var2.conversion.ConvertStream(this.stream, 3);
        }
    }

    Reader getCharacterStream(int var1) throws SQLException {
        if (this.isNull(var1)) {
            return null;
        } else if (this.statement.isFetchStreams) {
            ByteArrayInputStream var15 = new ByteArrayInputStream(this.getBytesInternal(var1));

            Reader var5;
            try {
                PhysicalConnection var3 = this.statement.connection;
                Reader var4 = this.statement.connection.conversion.ConvertCharacterStream(var15, 8, this.formOfUse);
                var5 = var4;
            } finally {
                try {
                    if (var15 != null) {
                        var15.close();
                    }
                } catch (IOException var12) {
                }

            }

            return var5;
        } else if (this.stream.closed) {
            SQLException var14 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 27);
            var14.fillInStackTrace();
            throw var14;
        } else {
            PhysicalConnection var2 = this.statement.connection;
            return var2.conversion.ConvertCharacterStream(this.stream, 8, this.formOfUse);
        }
    }

    InputStream getBinaryStream(int var1) throws SQLException {
        PhysicalConnection var2 = this.statement.connection;
        if (this.isNull(var1)) {
            return null;
        } else if (this.statement.isFetchStreams) {
            return this.convertBytesToStream(var1, 6);
        } else if (this.stream.closed) {
            SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 27);
            var3.fillInStackTrace();
            throw var3;
        } else {
            return var2.conversion.ConvertStream(this.stream, 6);
        }
    }

    public String toString() {
        return "LongRawAccessor@" + Integer.toHexString(this.hashCode()) + "{columnPosition = " + this.columnPosition + "}";
    }
}
