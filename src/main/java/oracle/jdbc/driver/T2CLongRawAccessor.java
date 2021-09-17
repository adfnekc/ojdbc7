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

class T2CLongRawAccessor extends LongRawAccessor {
    private static final String _Copyright_2007_Oracle_All_Rights_Reserved_ = null;
    public static final String BUILD_DATE = "Thu_Apr_04_15:09:24_PDT_2013";
    public static final boolean TRACE = false;

    T2CLongRawAccessor(OracleStatement var1, int var2, int var3, short var4, int var5) throws SQLException {
        super(var1, var2, var3, var4, var5);
    }

    T2CLongRawAccessor(OracleStatement var1, int var2, int var3, boolean var4, int var5, int var6, int var7, int var8, int var9, short var10) throws SQLException {
        super(var1, var2, var3, var4, var5, var6, var7, var8, var9, var10);
    }

    byte[] getBytesInternal(int var1) throws SQLException {
        if (this.statement.isFetchStreams) {
            assert !this.isNull(var1);

            int var2 = this.getLength(var1);
            long var3 = this.getOffset(var1);
            return this.rowData.get(var3, var2);
        } else {
            return super.getBytesInternal(var1);
        }
    }

    InputStream getAsciiStream(int var1) throws SQLException {
        if (this.statement.isFetchStreams) {
            if (this.isNull(var1)) {
                return null;
            } else {
                ByteArrayInputStream var2 = new ByteArrayInputStream(this.rowData.get(this.getOffset(var1), this.getLength(var1)));

                InputStream var3;
                try {
                    var3 = this.statement.connection.conversion.ConvertStream(var2, 2);
                } finally {
                    try {
                        if (var2 != null) {
                            var2.close();
                        }
                    } catch (IOException var10) {
                    }

                }

                return var3;
            }
        } else {
            return super.getAsciiStream(var1);
        }
    }

    InputStream getUnicodeStream(int var1) throws SQLException {
        if (this.statement.isFetchStreams) {
            if (this.isNull(var1)) {
                return null;
            } else {
                ByteArrayInputStream var2 = new ByteArrayInputStream(this.rowData.get(this.getOffset(var1), this.getLength(var1)));

                InputStream var3;
                try {
                    var3 = this.statement.connection.conversion.ConvertStream(var2, 3);
                } finally {
                    try {
                        if (var2 != null) {
                            var2.close();
                        }
                    } catch (IOException var10) {
                    }

                }

                return var3;
            }
        } else {
            return super.getUnicodeStream(var1);
        }
    }

    Reader getCharacterStream(int var1) throws SQLException {
        if (this.statement.isFetchStreams) {
            if (this.isNull(var1)) {
                return null;
            } else {
                ByteArrayInputStream var2 = new ByteArrayInputStream(this.rowData.get(this.getOffset(var1), this.getLength(var1)));

                Reader var3;
                try {
                    var3 = this.statement.connection.conversion.ConvertCharacterStream(var2, 8, this.formOfUse);
                } finally {
                    try {
                        if (var2 != null) {
                            var2.close();
                        }
                    } catch (IOException var10) {
                    }

                }

                return var3;
            }
        } else {
            return super.getCharacterStream(var1);
        }
    }

    InputStream getBinaryStream(int var1) throws SQLException {
        if (this.statement.isFetchStreams) {
            if (this.isNull(var1)) {
                return null;
            } else {
                ByteArrayInputStream var2 = new ByteArrayInputStream(this.rowData.get(this.getOffset(var1), this.getLength(var1)));
                return var2;
            }
        } else {
            return super.getBinaryStream(var1);
        }
    }

    void copyStreamDataIntoDBA(int var1) throws SQLException {
        if (this.stream.closed) {
            SQLException var17 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 27);
            var17.fillInStackTrace();
            throw var17;
        } else {
            ByteArrayOutputStream var2 = null;
            Object var3 = null;

            byte[] var18;
            try {
                var2 = new ByteArrayOutputStream(1024);
                byte[] var4 = this.statement.connection.getByteBuffer(32768);

                try {
                    int var5;
                    while((var5 = this.stream.read(var4, 0, 32768)) != -1) {
                        var2.write(var4, 0, var5);
                    }

                    this.statement.connection.cacheBuffer(var4);
                } catch (IOException var15) {
                    SQLException var7 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), var15);
                    var7.fillInStackTrace();
                    throw var7;
                }

                var18 = var2.toByteArray();
            } finally {
                try {
                    if (var2 != null) {
                        var2.close();
                    }
                } catch (IOException var14) {
                }

            }

            if (var18 != null && var18.length != 0) {
                this.setOffset(var1);
                this.setLengthAndNull(var1, var18.length);
                this.rowData.put(var18);
            } else {
                this.setLengthAndNull(var1, 0);
            }

        }
    }

    Accessor copyForDefine(OracleStatement var1) {
        LongRawAccessor var2 = (LongRawAccessor)super.copyForDefine(var1);

        try {
            var2.stream = var1.connection.driverExtension.createInputStream(var1, this.columnPosition, var2);
        } catch (SQLException var4) {
        }

        return var2;
    }
}
