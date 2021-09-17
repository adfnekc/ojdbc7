//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package oracle.jdbc.driver;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;
import java.math.BigDecimal;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.sql.Array;
import java.sql.Blob;
import java.sql.Clob;
import java.sql.Date;
import java.sql.NClob;
import java.sql.Ref;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.RowId;
import java.sql.SQLException;
import java.sql.SQLXML;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Map;
import oracle.jdbc.OracleData;
import oracle.jdbc.OracleDataFactory;
import oracle.jdbc.proxy.ProxyFactory;
import oracle.jdbc.proxy._Proxy_;
import oracle.sql.ARRAY;
import oracle.sql.BFILE;
import oracle.sql.BLOB;
import oracle.sql.CHAR;
import oracle.sql.CLOB;
import oracle.sql.CustomDatum;
import oracle.sql.CustomDatumFactory;
import oracle.sql.DATE;
import oracle.sql.Datum;
import oracle.sql.INTERVALDS;
import oracle.sql.INTERVALYM;
import oracle.sql.NCLOB;
import oracle.sql.NUMBER;
import oracle.sql.OPAQUE;
import oracle.sql.ORAData;
import oracle.sql.ORADataFactory;
import oracle.sql.RAW;
import oracle.sql.REF;
import oracle.sql.ROWID;
import oracle.sql.STRUCT;
import oracle.sql.TIMESTAMP;
import oracle.sql.TIMESTAMPLTZ;
import oracle.sql.TIMESTAMPTZ;

abstract class GeneratedUpdatableResultSet extends OracleResultSet {
    protected static final int MAX_CHAR_BUFFER_SIZE = 1024;
    protected static final int MAX_BYTE_BUFFER_SIZE = 1024;
    protected static final int ASCII_STREAM = 1;
    protected static final int BINARY_STREAM = 2;
    protected static final int UNICODE_STREAM = 3;
    protected static final int VALUE_NULL = 1;
    protected static final int VALUE_NOT_NULL = 2;
    protected static final int VALUE_UNKNOWN = 3;
    protected static final int VALUE_IN_RSET = 4;
    OracleResultSet resultSet;
    boolean isRowDeleted = false;
    private static final String _Copyright_2007_Oracle_All_Rights_Reserved_ = null;
    public static final String BUILD_DATE = "Thu_Apr_04_15:09:24_PDT_2013";
    public static final boolean TRACE = false;

    GeneratedUpdatableResultSet(OracleStatement var1, OracleResultSet var2) throws SQLException {
        super(var1.connection);
        this.resultSet = var2;
    }

    abstract void ensureOpen() throws SQLException;

    abstract void setIsNull(int var1);

    abstract void setIsNull(boolean var1);

    abstract boolean isOnInsertRow();

    abstract boolean isUpdatingRow() throws SQLException;

    abstract boolean isRowBufferUpdatedAt(int var1) throws SQLException;

    abstract Object getRowBufferAt(int var1) throws SQLException;

    abstract Datum getRowBufferDatumAt(int var1) throws SQLException;

    abstract void setRowBufferAt(int var1, Datum var2) throws SQLException;

    abstract void setRowBufferAt(int var1, Object var2, int[] var3) throws SQLException;

    abstract ResultSetMetaData getInternalMetadata() throws SQLException;

    abstract void addToTempLobsToFree(Clob var1);

    abstract void addToTempLobsToFree(Blob var1);

    abstract void cleanTempLobs();

    abstract void cleanTempBlobs(ArrayList var1);

    abstract void cleanTempClobs(ArrayList var1);

    public Datum getOracleObject(int var1) throws SQLException {
        synchronized(this.connection) {
            this.ensureOpen();
            if (this.isRowDeleted) {
                SQLException var6 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 82);
                var6.fillInStackTrace();
                throw var6;
            } else {
                Datum var3 = null;
                this.setIsNull(3);
                if (!this.isOnInsertRow() && (!this.isUpdatingRow() || !this.isRowBufferUpdatedAt(var1))) {
                    var3 = this.resultSet.getOracleObject(var1);
                    this.setIsNull(4);
                } else {
                    var3 = this.getRowBufferDatumAt(var1);
                    this.setIsNull(var3 == null);
                }

                return var3;
            }
        }
    }

    public String getString(int var1) throws SQLException {
        synchronized(this.connection) {
            this.ensureOpen();
            if (this.isRowDeleted) {
                SQLException var7 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 82);
                var7.fillInStackTrace();
                throw var7;
            } else {
                String var3 = null;
                this.setIsNull(3);
                if (!this.isOnInsertRow() && (!this.isUpdatingRow() || !this.isRowBufferUpdatedAt(var1))) {
                    this.setIsNull(4);
                    var3 = this.resultSet.getString(var1);
                } else {
                    Datum var4 = this.getRowBufferDatumAt(var1);
                    this.setIsNull(var4 == null);
                    if (var4 != null) {
                        var3 = var4.stringValue(this.connection);
                    }
                }

                return var3;
            }
        }
    }

    public boolean getBoolean(int var1) throws SQLException {
        synchronized(this.connection) {
            this.ensureOpen();
            if (this.isRowDeleted) {
                SQLException var7 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 82);
                var7.fillInStackTrace();
                throw var7;
            } else {
                boolean var3 = false;
                this.setIsNull(3);
                if (!this.isOnInsertRow() && (!this.isUpdatingRow() || !this.isRowBufferUpdatedAt(var1))) {
                    this.setIsNull(4);
                    var3 = this.resultSet.getBoolean(var1);
                } else {
                    Datum var4 = this.getRowBufferDatumAt(var1);
                    this.setIsNull(var4 == null);
                    if (var4 != null) {
                        var3 = var4.booleanValue();
                    }
                }

                return var3;
            }
        }
    }

    public byte getByte(int var1) throws SQLException {
        synchronized(this.connection) {
            this.ensureOpen();
            if (this.isRowDeleted) {
                SQLException var7 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 82);
                var7.fillInStackTrace();
                throw var7;
            } else {
                byte var3 = 0;
                this.setIsNull(3);
                if (!this.isOnInsertRow() && (!this.isUpdatingRow() || !this.isRowBufferUpdatedAt(var1))) {
                    this.setIsNull(4);
                    var3 = this.resultSet.getByte(var1);
                } else {
                    Datum var4 = this.getRowBufferDatumAt(var1);
                    this.setIsNull(var4 == null);
                    if (var4 != null) {
                        var3 = var4.byteValue();
                    }
                }

                return var3;
            }
        }
    }

    public short getShort(int var1) throws SQLException {
        synchronized(this.connection) {
            this.ensureOpen();
            if (this.isRowDeleted) {
                SQLException var10 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 82);
                var10.fillInStackTrace();
                throw var10;
            } else {
                boolean var3 = false;
                this.setIsNull(3);
                short var9;
                if (!this.isOnInsertRow() && (!this.isUpdatingRow() || !this.isRowBufferUpdatedAt(var1))) {
                    this.setIsNull(4);
                    var9 = this.resultSet.getShort(var1);
                } else {
                    long var4 = this.getLong(var1);
                    if (var4 > 65537L || var4 < -65538L) {
                        SQLException var6 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 26, "getShort");
                        var6.fillInStackTrace();
                        throw var6;
                    }

                    var9 = (short)((int)var4);
                }

                return var9;
            }
        }
    }

    public int getInt(int var1) throws SQLException {
        synchronized(this.connection) {
            this.ensureOpen();
            if (this.isRowDeleted) {
                SQLException var7 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 82);
                var7.fillInStackTrace();
                throw var7;
            } else {
                int var3 = 0;
                this.setIsNull(3);
                if (!this.isOnInsertRow() && (!this.isUpdatingRow() || !this.isRowBufferUpdatedAt(var1))) {
                    this.setIsNull(4);
                    var3 = this.resultSet.getInt(var1);
                } else {
                    Datum var4 = this.getRowBufferDatumAt(var1);
                    this.setIsNull(var4 == null);
                    if (var4 != null) {
                        var3 = var4.intValue();
                    }
                }

                return var3;
            }
        }
    }

    public long getLong(int var1) throws SQLException {
        synchronized(this.connection) {
            this.ensureOpen();
            if (this.isRowDeleted) {
                SQLException var8 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 82);
                var8.fillInStackTrace();
                throw var8;
            } else {
                long var3 = 0L;
                this.setIsNull(3);
                if (!this.isOnInsertRow() && (!this.isUpdatingRow() || !this.isRowBufferUpdatedAt(var1))) {
                    this.setIsNull(4);
                    var3 = this.resultSet.getLong(var1);
                } else {
                    Datum var5 = this.getRowBufferDatumAt(var1);
                    this.setIsNull(var5 == null);
                    if (var5 != null) {
                        var3 = var5.longValue();
                    }
                }

                return var3;
            }
        }
    }

    public float getFloat(int var1) throws SQLException {
        synchronized(this.connection) {
            this.ensureOpen();
            if (this.isRowDeleted) {
                SQLException var7 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 82);
                var7.fillInStackTrace();
                throw var7;
            } else {
                float var3 = 0.0F;
                this.setIsNull(3);
                if (!this.isOnInsertRow() && (!this.isUpdatingRow() || !this.isRowBufferUpdatedAt(var1))) {
                    this.setIsNull(4);
                    var3 = this.resultSet.getFloat(var1);
                } else {
                    Datum var4 = this.getRowBufferDatumAt(var1);
                    this.setIsNull(var4 == null);
                    if (var4 != null) {
                        var3 = var4.floatValue();
                    }
                }

                return var3;
            }
        }
    }

    public double getDouble(int var1) throws SQLException {
        synchronized(this.connection) {
            this.ensureOpen();
            if (this.isRowDeleted) {
                SQLException var8 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 82);
                var8.fillInStackTrace();
                throw var8;
            } else {
                double var3 = 0.0D;
                this.setIsNull(3);
                if (!this.isOnInsertRow() && (!this.isUpdatingRow() || !this.isRowBufferUpdatedAt(var1))) {
                    this.setIsNull(4);
                    var3 = this.resultSet.getDouble(var1);
                } else {
                    Datum var5 = this.getRowBufferDatumAt(var1);
                    this.setIsNull(var5 == null);
                    if (var5 != null) {
                        var3 = var5.doubleValue();
                    }
                }

                return var3;
            }
        }
    }

    public BigDecimal getBigDecimal(int var1, int var2) throws SQLException {
        synchronized(this.connection) {
            this.ensureOpen();
            if (this.isRowDeleted) {
                SQLException var8 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 82);
                var8.fillInStackTrace();
                throw var8;
            } else {
                BigDecimal var4 = null;
                this.setIsNull(3);
                if (!this.isOnInsertRow() && (!this.isUpdatingRow() || !this.isRowBufferUpdatedAt(var1))) {
                    this.setIsNull(4);
                    var4 = this.resultSet.getBigDecimal(var1);
                } else {
                    Datum var5 = this.getRowBufferDatumAt(var1);
                    this.setIsNull(var5 == null);
                    if (var5 != null) {
                        var4 = var5.bigDecimalValue();
                    }
                }

                return var4;
            }
        }
    }

    public byte[] getBytes(int var1) throws SQLException {
        synchronized(this.connection) {
            this.ensureOpen();
            if (this.isRowDeleted) {
                SQLException var7 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 82);
                var7.fillInStackTrace();
                throw var7;
            } else {
                byte[] var3 = null;
                this.setIsNull(3);
                if (!this.isOnInsertRow() && (!this.isUpdatingRow() || !this.isRowBufferUpdatedAt(var1))) {
                    this.setIsNull(4);
                    var3 = this.resultSet.getBytes(var1);
                } else {
                    Datum var4 = this.getRowBufferDatumAt(var1);
                    this.setIsNull(var4 == null);
                    if (var4 != null) {
                        var3 = var4.getBytes();
                    }
                }

                return var3;
            }
        }
    }

    public Date getDate(int var1) throws SQLException {
        synchronized(this.connection) {
            this.ensureOpen();
            if (this.isRowDeleted) {
                SQLException var7 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 82);
                var7.fillInStackTrace();
                throw var7;
            } else {
                Date var3 = null;
                this.setIsNull(3);
                if (!this.isOnInsertRow() && (!this.isUpdatingRow() || !this.isRowBufferUpdatedAt(var1))) {
                    this.setIsNull(4);
                    var3 = this.resultSet.getDate(var1);
                } else {
                    Datum var4 = this.getRowBufferDatumAt(var1);
                    this.setIsNull(var4 == null);
                    if (var4 != null) {
                        var3 = var4.dateValue();
                    }
                }

                return var3;
            }
        }
    }

    public Time getTime(int var1) throws SQLException {
        synchronized(this.connection) {
            this.ensureOpen();
            if (this.isRowDeleted) {
                SQLException var7 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 82);
                var7.fillInStackTrace();
                throw var7;
            } else {
                Time var3 = null;
                this.setIsNull(3);
                if (!this.isOnInsertRow() && (!this.isUpdatingRow() || !this.isRowBufferUpdatedAt(var1))) {
                    this.setIsNull(4);
                    var3 = this.resultSet.getTime(var1);
                } else {
                    Datum var4 = this.getRowBufferDatumAt(var1);
                    this.setIsNull(var4 == null);
                    if (var4 != null) {
                        var3 = var4.timeValue();
                    }
                }

                return var3;
            }
        }
    }

    public Timestamp getTimestamp(int var1) throws SQLException {
        synchronized(this.connection) {
            this.ensureOpen();
            if (this.isRowDeleted) {
                SQLException var7 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 82);
                var7.fillInStackTrace();
                throw var7;
            } else {
                Timestamp var3 = null;
                this.setIsNull(3);
                if (!this.isOnInsertRow() && (!this.isUpdatingRow() || !this.isRowBufferUpdatedAt(var1))) {
                    this.setIsNull(4);
                    var3 = this.resultSet.getTimestamp(var1);
                } else {
                    Datum var4 = this.getRowBufferDatumAt(var1);
                    this.setIsNull(var4 == null);
                    if (var4 != null) {
                        var3 = var4.timestampValue();
                    }
                }

                return var3;
            }
        }
    }

    public InputStream getAsciiStream(int var1) throws SQLException {
        synchronized(this.connection) {
            this.ensureOpen();
            if (this.isRowDeleted) {
                SQLException var8 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 82);
                var8.fillInStackTrace();
                throw var8;
            } else {
                InputStream var3 = null;
                this.setIsNull(3);
                if (!this.isOnInsertRow() && (!this.isUpdatingRow() || !this.isRowBufferUpdatedAt(var1))) {
                    this.setIsNull(4);
                    var3 = this.resultSet.getAsciiStream(var1);
                } else {
                    Object var4 = this.getRowBufferAt(var1);
                    this.setIsNull(var4 == null);
                    if (var4 != null) {
                        if (var4 instanceof InputStream) {
                            var3 = (InputStream)var4;
                        } else {
                            Datum var5 = this.getRowBufferDatumAt(var1);
                            var3 = var5.asciiStreamValue();
                        }
                    }
                }

                return var3;
            }
        }
    }

    public InputStream getUnicodeStream(int var1) throws SQLException {
        synchronized(this.connection) {
            this.ensureOpen();
            if (this.isRowDeleted) {
                SQLException var11 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 82);
                var11.fillInStackTrace();
                throw var11;
            } else {
                InputStream var3 = null;
                this.setIsNull(3);
                if (this.isOnInsertRow() || this.isUpdatingRow() && this.isRowBufferUpdatedAt(var1)) {
                    Object var4 = this.getRowBufferAt(var1);
                    this.setIsNull(var4 == null);
                    if (var4 != null) {
                        if (var4 instanceof InputStream) {
                            var3 = (InputStream)var4;
                        } else {
                            Datum var5 = this.getRowBufferDatumAt(var1);
                            DBConversion var6 = this.connection.conversion;
                            byte[] var7 = var5.shareBytes();
                            ByteArrayInputStream var10001;
                            PhysicalConnection var10002;
                            if (var5 instanceof RAW) {
                                var10001 = new ByteArrayInputStream(var7);
                                var10002 = this.connection;
                                var3 = var6.ConvertStream(var10001, 3);
                            } else {
                                if (!(var5 instanceof CHAR)) {
                                    SQLException var8 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 4, "getUnicodeStream");
                                    var8.fillInStackTrace();
                                    throw var8;
                                }

                                var10001 = new ByteArrayInputStream(var7);
                                var10002 = this.connection;
                                var3 = var6.ConvertStream(var10001, 1);
                            }
                        }
                    }
                } else {
                    this.setIsNull(4);
                    var3 = this.resultSet.getUnicodeStream(var1);
                }

                return var3;
            }
        }
    }

    public InputStream getBinaryStream(int var1) throws SQLException {
        synchronized(this.connection) {
            this.ensureOpen();
            if (this.isRowDeleted) {
                SQLException var8 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 82);
                var8.fillInStackTrace();
                throw var8;
            } else {
                InputStream var3 = null;
                this.setIsNull(3);
                if (!this.isOnInsertRow() && (!this.isUpdatingRow() || !this.isRowBufferUpdatedAt(var1))) {
                    this.setIsNull(4);
                    var3 = this.resultSet.getBinaryStream(var1);
                } else {
                    Object var4 = this.getRowBufferAt(var1);
                    this.setIsNull(var4 == null);
                    if (var4 != null) {
                        if (var4 instanceof InputStream) {
                            var3 = (InputStream)var4;
                        } else {
                            Datum var5 = this.getRowBufferDatumAt(var1);
                            var3 = var5.binaryStreamValue();
                        }
                    }
                }

                return var3;
            }
        }
    }

    public Object getObject(int var1) throws SQLException {
        synchronized(this.connection) {
            this.ensureOpen();
            if (this.isRowDeleted) {
                SQLException var7 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 82);
                var7.fillInStackTrace();
                throw var7;
            } else {
                Object var3 = null;
                this.setIsNull(3);
                if (!this.isOnInsertRow() && (!this.isUpdatingRow() || !this.isRowBufferUpdatedAt(var1))) {
                    this.setIsNull(4);
                    var3 = this.resultSet.getObject(var1);
                } else {
                    Datum var4 = this.getOracleObject(var1);
                    this.setIsNull(var4 == null);
                    if (var4 != null) {
                        var3 = var4.toJdbc();
                    }
                }

                return var3;
            }
        }
    }

    public Object getObject(int var1, OracleDataFactory var2) throws SQLException {
        synchronized(this.connection) {
            this.ensureOpen();
            SQLException var8;
            if (this.isRowDeleted) {
                var8 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 82);
                var8.fillInStackTrace();
                throw var8;
            } else if (var2 == null) {
                var8 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 68);
                var8.fillInStackTrace();
                throw var8;
            } else {
                Object var4 = null;
                this.setIsNull(3);
                if (!this.isOnInsertRow() && (!this.isUpdatingRow() || !this.isRowBufferUpdatedAt(var1))) {
                    this.setIsNull(4);
                    var4 = this.resultSet.getObject(var1, var2);
                } else {
                    Object var5 = this.getObject(var1);
                    this.setIsNull(var5 == null);
                    var4 = var2.create(var5, 0);
                }

                return var4;
            }
        }
    }

    public Reader getCharacterStream(int var1) throws SQLException {
        synchronized(this.connection) {
            this.ensureOpen();
            if (this.isRowDeleted) {
                SQLException var8 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 82);
                var8.fillInStackTrace();
                throw var8;
            } else {
                Reader var3 = null;
                this.setIsNull(3);
                if (!this.isOnInsertRow() && (!this.isUpdatingRow() || !this.isRowBufferUpdatedAt(var1))) {
                    this.setIsNull(4);
                    var3 = this.resultSet.getCharacterStream(var1);
                } else {
                    Object var4 = this.getRowBufferAt(var1);
                    this.setIsNull(var4 == null);
                    if (var4 != null) {
                        if (var4 instanceof Reader) {
                            var3 = (Reader)var4;
                        } else {
                            Datum var5 = this.getRowBufferDatumAt(var1);
                            var3 = var5.characterStreamValue();
                        }
                    }
                }

                return var3;
            }
        }
    }

    public BigDecimal getBigDecimal(int var1) throws SQLException {
        synchronized(this.connection) {
            this.ensureOpen();
            if (this.isRowDeleted) {
                SQLException var7 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 82);
                var7.fillInStackTrace();
                throw var7;
            } else {
                BigDecimal var3 = null;
                this.setIsNull(3);
                if (!this.isOnInsertRow() && (!this.isUpdatingRow() || !this.isRowBufferUpdatedAt(var1))) {
                    this.setIsNull(4);
                    var3 = this.resultSet.getBigDecimal(var1);
                } else {
                    Datum var4 = this.getRowBufferDatumAt(var1);
                    this.setIsNull(var4 == null);
                    if (var4 != null) {
                        var3 = var4.bigDecimalValue();
                    }
                }

                return var3;
            }
        }
    }

    public Object getObject(int var1, Map var2) throws SQLException {
        synchronized(this.connection) {
            this.ensureOpen();
            if (this.isRowDeleted) {
                SQLException var8 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 82);
                var8.fillInStackTrace();
                throw var8;
            } else {
                Object var4 = null;
                this.setIsNull(3);
                if (!this.isOnInsertRow() && (!this.isUpdatingRow() || !this.isRowBufferUpdatedAt(var1))) {
                    this.setIsNull(4);
                    var4 = this.resultSet.getObject(var1, var2);
                } else {
                    Datum var5 = this.getOracleObject(var1);
                    this.setIsNull(var5 == null);
                    if (var5 != null) {
                        if (var5 instanceof STRUCT) {
                            var4 = ((STRUCT)var5).toJdbc(var2);
                        } else {
                            var4 = var5.toJdbc();
                        }
                    }
                }

                return var4;
            }
        }
    }

    public Ref getRef(int var1) throws SQLException {
        synchronized(this.connection) {
            this.ensureOpen();
            if (this.isRowDeleted) {
                SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 82);
                var3.fillInStackTrace();
                throw var3;
            } else {
                return this.getREF(var1);
            }
        }
    }

    public Blob getBlob(int var1) throws SQLException {
        synchronized(this.connection) {
            this.ensureOpen();
            if (this.isRowDeleted) {
                SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 82);
                var3.fillInStackTrace();
                throw var3;
            } else {
                return this.getBLOB(var1);
            }
        }
    }

    public Clob getClob(int var1) throws SQLException {
        synchronized(this.connection) {
            this.ensureOpen();
            if (this.isRowDeleted) {
                SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 82);
                var3.fillInStackTrace();
                throw var3;
            } else {
                return this.getCLOB(var1);
            }
        }
    }

    public Array getArray(int var1) throws SQLException {
        synchronized(this.connection) {
            this.ensureOpen();
            if (this.isRowDeleted) {
                SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 82);
                var3.fillInStackTrace();
                throw var3;
            } else {
                return this.getARRAY(var1);
            }
        }
    }

    public Date getDate(int var1, Calendar var2) throws SQLException {
        synchronized(this.connection) {
            this.ensureOpen();
            if (this.isRowDeleted) {
                SQLException var11 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 82);
                var11.fillInStackTrace();
                throw var11;
            } else {
                Date var4 = null;
                this.setIsNull(3);
                if (!this.isOnInsertRow() && (!this.isUpdatingRow() || !this.isRowBufferUpdatedAt(var1))) {
                    this.setIsNull(4);
                    var4 = this.resultSet.getDate(var1, var2);
                } else {
                    Datum var5 = this.getOracleObject(var1);
                    this.setIsNull(var5 == null);
                    if (var5 != null) {
                        if (var5 instanceof DATE) {
                            var4 = ((DATE)var5).dateValue(var2);
                        } else if (var5 instanceof TIMESTAMP) {
                            Timestamp var6 = ((TIMESTAMP)var5).timestampValue(var2);
                            long var7 = var6.getTime();
                            var4 = new Date(var7);
                        } else {
                            DATE var12 = new DATE(var5.stringValue(this.connection));
                            if (var12 != null) {
                                var4 = var12.dateValue(var2);
                            }
                        }
                    }
                }

                return var4;
            }
        }
    }

    public Time getTime(int var1, Calendar var2) throws SQLException {
        synchronized(this.connection) {
            this.ensureOpen();
            if (this.isRowDeleted) {
                SQLException var11 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 82);
                var11.fillInStackTrace();
                throw var11;
            } else {
                Time var4 = null;
                this.setIsNull(3);
                if (!this.isOnInsertRow() && (!this.isUpdatingRow() || !this.isRowBufferUpdatedAt(var1))) {
                    this.setIsNull(4);
                    var4 = this.resultSet.getTime(var1, var2);
                } else {
                    Datum var5 = this.getOracleObject(var1);
                    this.setIsNull(var5 == null);
                    if (var5 != null) {
                        if (var5 instanceof DATE) {
                            var4 = ((DATE)var5).timeValue(var2);
                        } else if (var5 instanceof TIMESTAMP) {
                            Timestamp var6 = ((TIMESTAMP)var5).timestampValue(var2);
                            long var7 = var6.getTime();
                            var4 = new Time(var7);
                        } else {
                            DATE var12 = new DATE(var5.stringValue(this.connection));
                            if (var12 != null) {
                                var4 = var12.timeValue(var2);
                            }
                        }
                    }
                }

                return var4;
            }
        }
    }

    public Timestamp getTimestamp(int var1, Calendar var2) throws SQLException {
        synchronized(this.connection) {
            this.ensureOpen();
            if (this.isRowDeleted) {
                SQLException var9 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 82);
                var9.fillInStackTrace();
                throw var9;
            } else {
                Timestamp var4 = null;
                this.setIsNull(3);
                if (!this.isOnInsertRow() && (!this.isUpdatingRow() || !this.isRowBufferUpdatedAt(var1))) {
                    this.setIsNull(4);
                    var4 = this.resultSet.getTimestamp(var1, var2);
                } else {
                    Datum var5 = this.getOracleObject(var1);
                    this.setIsNull(var5 == null);
                    if (var5 != null) {
                        if (var5 instanceof DATE) {
                            var4 = ((DATE)var5).timestampValue(var2);
                        } else if (var5 instanceof TIMESTAMP) {
                            var4 = ((TIMESTAMP)var5).timestampValue(var2);
                        } else {
                            DATE var6 = new DATE(var5.stringValue(this.connection));
                            if (var6 != null) {
                                var4 = var6.timestampValue(var2);
                            }
                        }
                    }
                }

                return var4;
            }
        }
    }

    public URL getURL(int var1) throws SQLException {
        synchronized(this.connection) {
            this.ensureOpen();
            if (this.isRowDeleted) {
                SQLException var11 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 82);
                var11.fillInStackTrace();
                throw var11;
            } else {
                URL var3 = null;
                int var4 = this.getInternalMetadata().getColumnType(var1);
                int var5 = SQLUtil.getInternalType(var4);
                if (var5 != 96 && var5 != 1 && var5 != 8) {
                    SQLException var12 = DatabaseError.createUnsupportedFeatureSqlException();
                    var12.fillInStackTrace();
                    throw var12;
                } else {
                    try {
                        String var6 = this.getString(var1);
                        if (var6 == null) {
                            var3 = null;
                        } else {
                            var3 = new URL(var6);
                        }
                    } catch (MalformedURLException var9) {
                        SQLException var7 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 136);
                        var7.fillInStackTrace();
                        throw var7;
                    }

                    return var3;
                }
            }
        }
    }

    public ResultSet getCursor(int var1) throws SQLException {
        synchronized(this.connection) {
            this.ensureOpen();
            if (this.isRowDeleted) {
                SQLException var8 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 82);
                var8.fillInStackTrace();
                throw var8;
            } else {
                ResultSet var3 = null;
                this.setIsNull(3);
                if (!this.isOnInsertRow() && (!this.isUpdatingRow() || !this.isRowBufferUpdatedAt(var1))) {
                    this.setIsNull(4);
                    var3 = this.resultSet.getCursor(var1);
                    return var3;
                } else {
                    Datum var4 = this.getOracleObject(var1);
                    this.setIsNull(var4 == null);
                    SQLException var5 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 4, "getCursor");
                    var5.fillInStackTrace();
                    throw var5;
                }
            }
        }
    }

    public ROWID getROWID(int var1) throws SQLException {
        synchronized(this.connection) {
            this.ensureOpen();
            if (this.isRowDeleted) {
                SQLException var8 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 82);
                var8.fillInStackTrace();
                throw var8;
            } else {
                ROWID var3 = null;
                this.setIsNull(3);
                if (!this.isOnInsertRow() && (!this.isUpdatingRow() || !this.isRowBufferUpdatedAt(var1))) {
                    this.setIsNull(4);
                    var3 = this.resultSet.getROWID(var1);
                } else {
                    Datum var4 = this.getRowBufferDatumAt(var1);
                    this.setIsNull(var4 == null);
                    if (var4 != null && !(var4 instanceof ROWID)) {
                        SQLException var5 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 4, "getROWID");
                        var5.fillInStackTrace();
                        throw var5;
                    }

                    var3 = (ROWID)var4;
                }

                return var3;
            }
        }
    }

    public NUMBER getNUMBER(int var1) throws SQLException {
        synchronized(this.connection) {
            this.ensureOpen();
            if (this.isRowDeleted) {
                SQLException var8 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 82);
                var8.fillInStackTrace();
                throw var8;
            } else {
                NUMBER var3 = null;
                this.setIsNull(3);
                if (!this.isOnInsertRow() && (!this.isUpdatingRow() || !this.isRowBufferUpdatedAt(var1))) {
                    this.setIsNull(4);
                    var3 = this.resultSet.getNUMBER(var1);
                } else {
                    Datum var4 = this.getRowBufferDatumAt(var1);
                    this.setIsNull(var4 == null);
                    if (var4 != null && !(var4 instanceof NUMBER)) {
                        SQLException var5 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 4, "getNUMBER");
                        var5.fillInStackTrace();
                        throw var5;
                    }

                    var3 = (NUMBER)var4;
                }

                return var3;
            }
        }
    }

    public DATE getDATE(int var1) throws SQLException {
        synchronized(this.connection) {
            this.ensureOpen();
            if (this.isRowDeleted) {
                SQLException var8 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 82);
                var8.fillInStackTrace();
                throw var8;
            } else {
                DATE var3 = null;
                this.setIsNull(3);
                if (!this.isOnInsertRow() && (!this.isUpdatingRow() || !this.isRowBufferUpdatedAt(var1))) {
                    this.setIsNull(4);
                    var3 = this.resultSet.getDATE(var1);
                } else {
                    Datum var4 = this.getRowBufferDatumAt(var1);
                    if (var4 != null) {
                        if (var4 instanceof DATE) {
                            var3 = (DATE)var4;
                        } else {
                            if (!(var4 instanceof TIMESTAMP)) {
                                SQLException var9 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 4, "getDATE");
                                var9.fillInStackTrace();
                                throw var9;
                            }

                            Timestamp var5 = ((TIMESTAMP)var4).timestampValue();
                            var3 = new DATE(var5);
                        }
                    } else {
                        this.setIsNull(var4 == null);
                    }
                }

                return var3;
            }
        }
    }

    public TIMESTAMP getTIMESTAMP(int var1) throws SQLException {
        synchronized(this.connection) {
            this.ensureOpen();
            if (this.isRowDeleted) {
                SQLException var8 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 82);
                var8.fillInStackTrace();
                throw var8;
            } else {
                TIMESTAMP var3 = null;
                this.setIsNull(3);
                if (!this.isOnInsertRow() && (!this.isUpdatingRow() || !this.isRowBufferUpdatedAt(var1))) {
                    this.setIsNull(4);
                    var3 = this.resultSet.getTIMESTAMP(var1);
                } else {
                    Datum var4 = this.getRowBufferDatumAt(var1);
                    this.setIsNull(var4 == null);
                    if (var4 != null && !(var4 instanceof TIMESTAMP)) {
                        SQLException var5 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 4, "getTIMESTAMP");
                        var5.fillInStackTrace();
                        throw var5;
                    }

                    var3 = (TIMESTAMP)var4;
                }

                return var3;
            }
        }
    }

    public TIMESTAMPTZ getTIMESTAMPTZ(int var1) throws SQLException {
        synchronized(this.connection) {
            this.ensureOpen();
            if (this.isRowDeleted) {
                SQLException var8 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 82);
                var8.fillInStackTrace();
                throw var8;
            } else {
                TIMESTAMPTZ var3 = null;
                this.setIsNull(3);
                if (!this.isOnInsertRow() && (!this.isUpdatingRow() || !this.isRowBufferUpdatedAt(var1))) {
                    this.setIsNull(4);
                    var3 = this.resultSet.getTIMESTAMPTZ(var1);
                } else {
                    Datum var4 = this.getRowBufferDatumAt(var1);
                    this.setIsNull(var4 == null);
                    if (var4 != null && !(var4 instanceof TIMESTAMPTZ)) {
                        SQLException var5 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 4, "getTIMESTAMPTZ");
                        var5.fillInStackTrace();
                        throw var5;
                    }

                    var3 = (TIMESTAMPTZ)var4;
                }

                return var3;
            }
        }
    }

    public TIMESTAMPLTZ getTIMESTAMPLTZ(int var1) throws SQLException {
        synchronized(this.connection) {
            this.ensureOpen();
            if (this.isRowDeleted) {
                SQLException var8 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 82);
                var8.fillInStackTrace();
                throw var8;
            } else {
                TIMESTAMPLTZ var3 = null;
                this.setIsNull(3);
                if (!this.isOnInsertRow() && (!this.isUpdatingRow() || !this.isRowBufferUpdatedAt(var1))) {
                    this.setIsNull(4);
                    var3 = this.resultSet.getTIMESTAMPLTZ(var1);
                } else {
                    Datum var4 = this.getRowBufferDatumAt(var1);
                    this.setIsNull(var4 == null);
                    if (var4 != null && !(var4 instanceof TIMESTAMPLTZ)) {
                        SQLException var5 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 4, "getTIMESTAMPLTZ");
                        var5.fillInStackTrace();
                        throw var5;
                    }

                    var3 = (TIMESTAMPLTZ)var4;
                }

                return var3;
            }
        }
    }

    public INTERVALDS getINTERVALDS(int var1) throws SQLException {
        synchronized(this.connection) {
            this.ensureOpen();
            if (this.isRowDeleted) {
                SQLException var8 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 82);
                var8.fillInStackTrace();
                throw var8;
            } else {
                INTERVALDS var3 = null;
                this.setIsNull(3);
                if (!this.isOnInsertRow() && (!this.isUpdatingRow() || !this.isRowBufferUpdatedAt(var1))) {
                    this.setIsNull(4);
                    var3 = this.resultSet.getINTERVALDS(var1);
                } else {
                    Datum var4 = this.getRowBufferDatumAt(var1);
                    this.setIsNull(var4 == null);
                    if (var4 != null && !(var4 instanceof INTERVALDS)) {
                        SQLException var5 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 4, "getINTERVALDS");
                        var5.fillInStackTrace();
                        throw var5;
                    }

                    var3 = (INTERVALDS)var4;
                }

                return var3;
            }
        }
    }

    public INTERVALYM getINTERVALYM(int var1) throws SQLException {
        synchronized(this.connection) {
            this.ensureOpen();
            if (this.isRowDeleted) {
                SQLException var8 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 82);
                var8.fillInStackTrace();
                throw var8;
            } else {
                INTERVALYM var3 = null;
                this.setIsNull(3);
                if (!this.isOnInsertRow() && (!this.isUpdatingRow() || !this.isRowBufferUpdatedAt(var1))) {
                    this.setIsNull(4);
                    var3 = this.resultSet.getINTERVALYM(var1);
                } else {
                    Datum var4 = this.getRowBufferDatumAt(var1);
                    this.setIsNull(var4 == null);
                    if (var4 != null && !(var4 instanceof INTERVALYM)) {
                        SQLException var5 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 4, "getINTERVALYM");
                        var5.fillInStackTrace();
                        throw var5;
                    }

                    var3 = (INTERVALYM)var4;
                }

                return var3;
            }
        }
    }

    public ARRAY getARRAY(int var1) throws SQLException {
        synchronized(this.connection) {
            this.ensureOpen();
            if (this.isRowDeleted) {
                SQLException var8 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 82);
                var8.fillInStackTrace();
                throw var8;
            } else {
                ARRAY var3 = null;
                this.setIsNull(3);
                if (!this.isOnInsertRow() && (!this.isUpdatingRow() || !this.isRowBufferUpdatedAt(var1))) {
                    this.setIsNull(4);
                    var3 = this.resultSet.getARRAY(var1);
                } else {
                    Datum var4 = this.getRowBufferDatumAt(var1);
                    this.setIsNull(var4 == null);
                    if (var4 != null && !(var4 instanceof ARRAY)) {
                        SQLException var5 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 4, "getARRAY");
                        var5.fillInStackTrace();
                        throw var5;
                    }

                    var3 = (ARRAY)var4;
                }

                return var3;
            }
        }
    }

    public STRUCT getSTRUCT(int var1) throws SQLException {
        synchronized(this.connection) {
            this.ensureOpen();
            if (this.isRowDeleted) {
                SQLException var8 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 82);
                var8.fillInStackTrace();
                throw var8;
            } else {
                STRUCT var3 = null;
                this.setIsNull(3);
                if (!this.isOnInsertRow() && (!this.isUpdatingRow() || !this.isRowBufferUpdatedAt(var1))) {
                    this.setIsNull(4);
                    var3 = this.resultSet.getSTRUCT(var1);
                } else {
                    Datum var4 = this.getRowBufferDatumAt(var1);
                    this.setIsNull(var4 == null);
                    if (var4 != null && !(var4 instanceof STRUCT)) {
                        SQLException var5 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 4, "getSTRUCT");
                        var5.fillInStackTrace();
                        throw var5;
                    }

                    var3 = (STRUCT)var4;
                }

                return var3;
            }
        }
    }

    public OPAQUE getOPAQUE(int var1) throws SQLException {
        synchronized(this.connection) {
            this.ensureOpen();
            if (this.isRowDeleted) {
                SQLException var8 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 82);
                var8.fillInStackTrace();
                throw var8;
            } else {
                OPAQUE var3 = null;
                this.setIsNull(3);
                if (!this.isOnInsertRow() && (!this.isUpdatingRow() || !this.isRowBufferUpdatedAt(var1))) {
                    this.setIsNull(4);
                    var3 = this.resultSet.getOPAQUE(var1);
                } else {
                    Datum var4 = this.getRowBufferDatumAt(var1);
                    this.setIsNull(var4 == null);
                    if (var4 != null && !(var4 instanceof OPAQUE)) {
                        SQLException var5 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 4, "getOPAQUE");
                        var5.fillInStackTrace();
                        throw var5;
                    }

                    var3 = (OPAQUE)var4;
                }

                return var3;
            }
        }
    }

    public REF getREF(int var1) throws SQLException {
        synchronized(this.connection) {
            this.ensureOpen();
            if (this.isRowDeleted) {
                SQLException var8 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 82);
                var8.fillInStackTrace();
                throw var8;
            } else {
                REF var3 = null;
                this.setIsNull(3);
                if (!this.isOnInsertRow() && (!this.isUpdatingRow() || !this.isRowBufferUpdatedAt(var1))) {
                    this.setIsNull(4);
                    var3 = this.resultSet.getREF(var1);
                } else {
                    Datum var4 = this.getRowBufferDatumAt(var1);
                    this.setIsNull(var4 == null);
                    if (var4 != null && !(var4 instanceof REF)) {
                        SQLException var5 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 4, "getREF");
                        var5.fillInStackTrace();
                        throw var5;
                    }

                    var3 = (REF)var4;
                }

                return var3;
            }
        }
    }

    public CHAR getCHAR(int var1) throws SQLException {
        synchronized(this.connection) {
            this.ensureOpen();
            if (this.isRowDeleted) {
                SQLException var8 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 82);
                var8.fillInStackTrace();
                throw var8;
            } else {
                CHAR var3 = null;
                this.setIsNull(3);
                if (!this.isOnInsertRow() && (!this.isUpdatingRow() || !this.isRowBufferUpdatedAt(var1))) {
                    this.setIsNull(4);
                    var3 = this.resultSet.getCHAR(var1);
                } else {
                    Datum var4 = this.getRowBufferDatumAt(var1);
                    this.setIsNull(var4 == null);
                    if (var4 != null && !(var4 instanceof CHAR)) {
                        SQLException var5 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 4, "getCHAR");
                        var5.fillInStackTrace();
                        throw var5;
                    }

                    var3 = (CHAR)var4;
                }

                return var3;
            }
        }
    }

    public RAW getRAW(int var1) throws SQLException {
        synchronized(this.connection) {
            this.ensureOpen();
            if (this.isRowDeleted) {
                SQLException var8 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 82);
                var8.fillInStackTrace();
                throw var8;
            } else {
                RAW var3 = null;
                this.setIsNull(3);
                if (!this.isOnInsertRow() && (!this.isUpdatingRow() || !this.isRowBufferUpdatedAt(var1))) {
                    this.setIsNull(4);
                    var3 = this.resultSet.getRAW(var1);
                } else {
                    Datum var4 = this.getRowBufferDatumAt(var1);
                    this.setIsNull(var4 == null);
                    if (var4 != null && !(var4 instanceof RAW)) {
                        SQLException var5 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 4, "getRAW");
                        var5.fillInStackTrace();
                        throw var5;
                    }

                    var3 = (RAW)var4;
                }

                return var3;
            }
        }
    }

    public BLOB getBLOB(int var1) throws SQLException {
        synchronized(this.connection) {
            this.ensureOpen();
            if (this.isRowDeleted) {
                SQLException var8 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 82);
                var8.fillInStackTrace();
                throw var8;
            } else {
                BLOB var3 = null;
                this.setIsNull(3);
                if (!this.isOnInsertRow() && (!this.isUpdatingRow() || !this.isRowBufferUpdatedAt(var1))) {
                    this.setIsNull(4);
                    var3 = this.resultSet.getBLOB(var1);
                } else {
                    Datum var4 = this.getRowBufferDatumAt(var1);
                    this.setIsNull(var4 == null);
                    if (var4 != null && !(var4 instanceof BLOB)) {
                        SQLException var5 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 4, "getBLOB");
                        var5.fillInStackTrace();
                        throw var5;
                    }

                    var3 = (BLOB)var4;
                }

                return var3;
            }
        }
    }

    public NCLOB getNCLOB(int var1) throws SQLException {
        synchronized(this.connection) {
            this.ensureOpen();
            if (this.isRowDeleted) {
                SQLException var8 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 82);
                var8.fillInStackTrace();
                throw var8;
            } else {
                NCLOB var3 = null;
                this.setIsNull(3);
                if (!this.isOnInsertRow() && (!this.isUpdatingRow() || !this.isRowBufferUpdatedAt(var1))) {
                    this.setIsNull(4);
                    var3 = (NCLOB)((NCLOB)this.resultSet.getNClob(var1));
                } else {
                    Datum var4 = this.getRowBufferDatumAt(var1);
                    this.setIsNull(var4 == null);
                    if (var4 != null && !(var4 instanceof NCLOB)) {
                        SQLException var5 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 4, "getCLOB");
                        var5.fillInStackTrace();
                        throw var5;
                    }

                    var3 = (NCLOB)var4;
                }

                return var3;
            }
        }
    }

    public CLOB getCLOB(int var1) throws SQLException {
        synchronized(this.connection) {
            this.ensureOpen();
            if (this.isRowDeleted) {
                SQLException var8 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 82);
                var8.fillInStackTrace();
                throw var8;
            } else {
                CLOB var3 = null;
                this.setIsNull(3);
                if (!this.isOnInsertRow() && (!this.isUpdatingRow() || !this.isRowBufferUpdatedAt(var1))) {
                    this.setIsNull(4);
                    var3 = this.resultSet.getCLOB(var1);
                } else {
                    Datum var4 = this.getRowBufferDatumAt(var1);
                    this.setIsNull(var4 == null);
                    if (var4 != null && !(var4 instanceof CLOB)) {
                        SQLException var5 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 4, "getCLOB");
                        var5.fillInStackTrace();
                        throw var5;
                    }

                    var3 = (CLOB)var4;
                }

                return var3;
            }
        }
    }

    public BFILE getBFILE(int var1) throws SQLException {
        synchronized(this.connection) {
            this.ensureOpen();
            if (this.isRowDeleted) {
                SQLException var8 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 82);
                var8.fillInStackTrace();
                throw var8;
            } else {
                BFILE var3 = null;
                this.setIsNull(3);
                if (!this.isOnInsertRow() && (!this.isUpdatingRow() || !this.isRowBufferUpdatedAt(var1))) {
                    this.setIsNull(4);
                    var3 = this.resultSet.getBFILE(var1);
                } else {
                    Datum var4 = this.getRowBufferDatumAt(var1);
                    this.setIsNull(var4 == null);
                    if (var4 != null && !(var4 instanceof BFILE)) {
                        SQLException var5 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 4, "getBFILE");
                        var5.fillInStackTrace();
                        throw var5;
                    }

                    var3 = (BFILE)var4;
                }

                return var3;
            }
        }
    }

    public BFILE getBfile(int var1) throws SQLException {
        synchronized(this.connection) {
            this.ensureOpen();
            if (this.isRowDeleted) {
                SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 82);
                var3.fillInStackTrace();
                throw var3;
            } else {
                return this.getBFILE(var1);
            }
        }
    }

    public CustomDatum getCustomDatum(int var1, CustomDatumFactory var2) throws SQLException {
        synchronized(this.connection) {
            this.ensureOpen();
            SQLException var8;
            if (this.isRowDeleted) {
                var8 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 82);
                var8.fillInStackTrace();
                throw var8;
            } else if (var2 == null) {
                var8 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 68);
                var8.fillInStackTrace();
                throw var8;
            } else {
                CustomDatum var4 = null;
                this.setIsNull(3);
                if (!this.isOnInsertRow() && (!this.isUpdatingRow() || !this.isRowBufferUpdatedAt(var1))) {
                    this.setIsNull(4);
                    var4 = this.resultSet.getCustomDatum(var1, var2);
                } else {
                    Datum var5 = this.getRowBufferDatumAt(var1);
                    this.setIsNull(var5 == null);
                    var4 = var2.create(var5, 0);
                }

                return var4;
            }
        }
    }

    public ORAData getORAData(int var1, ORADataFactory var2) throws SQLException {
        synchronized(this.connection) {
            this.ensureOpen();
            SQLException var8;
            if (this.isRowDeleted) {
                var8 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 82);
                var8.fillInStackTrace();
                throw var8;
            } else if (var2 == null) {
                var8 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 68);
                var8.fillInStackTrace();
                throw var8;
            } else {
                ORAData var4 = null;
                this.setIsNull(3);
                if (!this.isOnInsertRow() && (!this.isUpdatingRow() || !this.isRowBufferUpdatedAt(var1))) {
                    this.setIsNull(4);
                    var4 = this.resultSet.getORAData(var1, var2);
                } else {
                    Datum var5 = this.getRowBufferDatumAt(var1);
                    this.setIsNull(var5 == null);
                    var4 = var2.create(var5, 0);
                }

                return var4;
            }
        }
    }

    public NClob getNClob(int var1) throws SQLException {
        this.ensureOpen();
        if (this.isRowDeleted) {
            SQLException var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 82);
            var4.fillInStackTrace();
            throw var4;
        } else {
            NCLOB var2 = this.getNCLOB(var1);
            if (var2 == null) {
                return null;
            } else if (!(var2 instanceof NClob)) {
                SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 184);
                var3.fillInStackTrace();
                throw var3;
            } else {
                return var2;
            }
        }
    }

    public String getNString(int var1) throws SQLException {
        this.ensureOpen();
        if (this.isRowDeleted) {
            SQLException var2 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 82);
            var2.fillInStackTrace();
            throw var2;
        } else {
            return this.getString(var1);
        }
    }

    public Reader getNCharacterStream(int var1) throws SQLException {
        this.ensureOpen();
        if (this.isRowDeleted) {
            SQLException var2 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 82);
            var2.fillInStackTrace();
            throw var2;
        } else {
            return this.getCharacterStream(var1);
        }
    }

    public RowId getRowId(int var1) throws SQLException {
        this.ensureOpen();
        if (this.isRowDeleted) {
            SQLException var2 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 82);
            var2.fillInStackTrace();
            throw var2;
        } else {
            return this.getROWID(var1);
        }
    }

    public SQLXML getSQLXML(int var1) throws SQLException {
        synchronized(this.connection) {
            this.ensureOpen();
            if (this.isRowDeleted) {
                SQLException var8 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 82);
                var8.fillInStackTrace();
                throw var8;
            } else {
                SQLXML var3 = null;
                this.setIsNull(3);
                if (!this.isOnInsertRow() && (!this.isUpdatingRow() || !this.isRowBufferUpdatedAt(var1))) {
                    this.setIsNull(4);
                    var3 = this.resultSet.getSQLXML(var1);
                } else {
                    Datum var4 = this.getRowBufferDatumAt(var1);
                    this.setIsNull(var4 == null);
                    if (var4 != null && !(var4 instanceof SQLXML)) {
                        SQLException var5 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 4, "getSQLXML");
                        var5.fillInStackTrace();
                        throw var5;
                    }

                    var3 = (SQLXML)var4;
                }

                return var3;
            }
        }
    }

    public void updateRowId(int var1, RowId var2) throws SQLException {
        this.updateROWID(var1, (ROWID)var2);
    }

    public void updateNCharacterStream(int var1, Reader var2, long var3) throws SQLException {
        this.updateCharacterStream(var1, var2, var3);
    }

    public void updateNCharacterStream(int var1, Reader var2) throws SQLException {
        this.updateCharacterStream(var1, var2);
    }

    public void updateSQLXML(int var1, SQLXML var2) throws SQLException {
        this.updateOracleObject(var1, (Datum)var2);
    }

    public void updateNString(int var1, String var2) throws SQLException {
        this.updateString(var1, var2);
    }

    public void updateNClob(int var1, NClob var2) throws SQLException {
        this.updateClob(var1, (Clob)var2);
    }

    public void updateAsciiStream(int var1, InputStream var2, long var3) throws SQLException {
        this.updateAsciiStream(var1, var2, (int)var3);
    }

    public void updateAsciiStream(int var1, InputStream var2) throws SQLException {
        this.updateAsciiStream(var1, var2, 2147483647);
    }

    public void updateBinaryStream(int var1, InputStream var2, long var3) throws SQLException {
        this.updateBinaryStream(var1, var2, (int)var3);
    }

    public void updateBinaryStream(int var1, InputStream var2) throws SQLException {
        this.updateBinaryStream(var1, var2, 2147483647);
    }

    public void updateCharacterStream(int var1, Reader var2, long var3) throws SQLException {
        this.updateCharacterStream(var1, var2, (int)var3);
    }

    public void updateCharacterStream(int var1, Reader var2) throws SQLException {
        this.updateCharacterStream(var1, var2, 2147483647);
    }

    public void updateBlob(int var1, InputStream var2) throws SQLException {
        Blob var3 = this.connection.createBlob();
        this.addToTempLobsToFree(var3);
        int var4 = ((BLOB)var3).getBufferSize();
        OutputStream var5 = var3.setBinaryStream(1L);
        byte[] var6 = new byte[var4];

        try {
            while(true) {
                int var7 = var2.read(var6);
                if (var7 == -1) {
                    var5.close();
                    this.updateBlob(var1, var3);
                    return;
                }

                var5.write(var6, 0, var7);
            }
        } catch (IOException var9) {
            SQLException var8 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), var9);
            var8.fillInStackTrace();
            throw var8;
        }
    }

    public void updateBlob(int var1, InputStream var2, long var3) throws SQLException {
        Blob var5 = this.connection.createBlob();
        this.addToTempLobsToFree(var5);
        int var6 = ((BLOB)var5).getBufferSize();
        OutputStream var7 = var5.setBinaryStream(1L);
        byte[] var8 = new byte[var6];
        long var9 = var3;

        try {
            while(var9 > 0L) {
                int var11 = var2.read(var8, 0, Math.min(var6, (int)var9));
                if (var11 == -1) {
                    break;
                }

                var7.write(var8, 0, var11);
                var9 -= (long)var11;
            }

            var7.close();
            this.updateBlob(var1, var5);
        } catch (IOException var13) {
            SQLException var12 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), var13);
            var12.fillInStackTrace();
            throw var12;
        }
    }

    public void updateClob(int var1, Reader var2, long var3) throws SQLException {
        this.updateClob(var1, var2, var3, (short)1);
    }

    void updateClob(int var1, Reader var2, long var3, short var5) throws SQLException {
        Object var6 = var5 == 1 ? this.connection.createClob() : this.connection.createNClob();
        this.addToTempLobsToFree((Clob)var6);
        int var7 = ((CLOB)var6).getBufferSize();
        Writer var8 = ((Clob)var6).setCharacterStream(1L);
        char[] var9 = new char[var7];
        long var10 = var3;

        try {
            while(var10 > 0L) {
                int var12 = var2.read(var9, 0, Math.min(var7, (int)var10));
                if (var12 == -1) {
                    break;
                }

                var8.write(var9, 0, var12);
                var10 -= (long)var12;
            }

            var8.close();
            this.updateClob(var1, (Clob)var6);
        } catch (IOException var14) {
            SQLException var13 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), var14);
            var13.fillInStackTrace();
            throw var13;
        }
    }

    public void updateClob(int var1, Reader var2) throws SQLException {
        Clob var3 = this.connection.createClob();
        this.addToTempLobsToFree(var3);
        int var4 = ((CLOB)var3).getBufferSize();
        Writer var5 = var3.setCharacterStream(1L);
        char[] var6 = new char[var4];

        try {
            while(true) {
                int var7 = var2.read(var6);
                if (var7 == -1) {
                    var5.close();
                    this.updateClob(var1, var3);
                    return;
                }

                var5.write(var6, 0, var7);
            }
        } catch (IOException var9) {
            SQLException var8 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), var9);
            var8.fillInStackTrace();
            throw var8;
        }
    }

    void updateClob(int var1, InputStream var2, int var3) throws SQLException {
        this.updateClob(var1, var2, var3, (short)1);
    }

    void updateClob(int var1, InputStream var2, int var3, short var4) throws SQLException {
        Object var5 = var4 == 1 ? this.connection.createClob() : this.connection.createNClob();
        this.addToTempLobsToFree((Clob)var5);
        int var6 = ((CLOB)var5).getBufferSize();
        OutputStream var7 = ((Clob)var5).setAsciiStream(1L);
        byte[] var8 = new byte[var6];
        long var9 = (long)var3;

        try {
            while(var9 > 0L) {
                int var11 = var2.read(var8, 0, Math.min(var6, (int)var9));
                if (var11 == -1) {
                    break;
                }

                var7.write(var8, 0, var11);
                var9 -= (long)var11;
            }

            var7.close();
            this.updateClob(var1, (Clob)var5);
        } catch (IOException var13) {
            SQLException var12 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), var13);
            var12.fillInStackTrace();
            throw var12;
        }
    }

    void updateNClob(int var1, InputStream var2, int var3) throws SQLException {
        NClob var4 = this.connection.createNClob();
        this.addToTempLobsToFree((Clob)var4);
        int var5 = ((NCLOB)var4).getBufferSize();
        OutputStream var6 = var4.setAsciiStream(1L);
        byte[] var7 = new byte[var5];
        long var8 = (long)var3;

        try {
            while(var8 > 0L) {
                int var10 = var2.read(var7, 0, Math.min(var5, (int)var8));
                if (var10 == -1) {
                    break;
                }

                var6.write(var7, 0, var10);
                var8 -= (long)var10;
            }

            var6.close();
            this.updateNClob(var1, var4);
        } catch (IOException var12) {
            SQLException var11 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), var12);
            var11.fillInStackTrace();
            throw var11;
        }
    }

    public void updateNClob(int var1, Reader var2, long var3) throws SQLException {
        if (var2 == null) {
            SQLException var14 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 68, "updateNClob");
            var14.fillInStackTrace();
            throw var14;
        } else {
            NClob var5 = this.connection.createNClob();
            this.addToTempLobsToFree((Clob)var5);
            int var6 = ((CLOB)var5).getBufferSize();
            Writer var7 = var5.setCharacterStream(1L);
            char[] var8 = new char[var6];
            long var9 = var3;

            try {
                while(var9 > 0L) {
                    int var11 = var2.read(var8, 0, Math.min(var6, (int)var9));
                    if (var11 == -1) {
                        break;
                    }

                    var7.write(var8, 0, var11);
                    var9 -= (long)var11;
                }

                var7.close();
                this.updateNClob(var1, var5);
            } catch (IOException var13) {
                SQLException var12 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), var13);
                var12.fillInStackTrace();
                throw var12;
            }
        }
    }

    public void updateNClob(int var1, Reader var2) throws SQLException {
        if (var2 == null) {
            SQLException var10 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 68, "updateNClob");
            var10.fillInStackTrace();
            throw var10;
        } else {
            NClob var3 = this.connection.createNClob();
            this.addToTempLobsToFree((Clob)var3);
            int var4 = ((CLOB)var3).getBufferSize();
            Writer var5 = var3.setCharacterStream(1L);
            char[] var6 = new char[var4];

            try {
                while(true) {
                    int var7 = var2.read(var6);
                    if (var7 == -1) {
                        var5.close();
                        this.updateNClob(var1, var3);
                        return;
                    }

                    var5.write(var6, 0, var7);
                }
            } catch (IOException var9) {
                SQLException var8 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), var9);
                var8.fillInStackTrace();
                throw var8;
            }
        }
    }

    public void updateString(int var1, String var2) throws SQLException {
        synchronized(this.connection) {
            if (var2 != null && var2.length() != 0) {
                this.updateObject(var1, var2);
            } else {
                this.updateNull(var1);
            }

        }
    }

    public void updateBoolean(int var1, boolean var2) throws SQLException {
        this.updateObject(var1, var2);
    }

    public void updateByte(int var1, byte var2) throws SQLException {
        this.updateObject(var1, Integer.valueOf(var2));
    }

    public void updateShort(int var1, short var2) throws SQLException {
        this.updateObject(var1, Integer.valueOf(var2));
    }

    public void updateInt(int var1, int var2) throws SQLException {
        this.updateObject(var1, var2);
    }

    public void updateLong(int var1, long var2) throws SQLException {
        this.updateObject(var1, var2);
    }

    public void updateFloat(int var1, float var2) throws SQLException {
        this.updateObject(var1, var2);
    }

    public void updateDouble(int var1, double var2) throws SQLException {
        this.updateObject(var1, var2);
    }

    public void updateBigDecimal(int var1, BigDecimal var2) throws SQLException {
        this.updateObject(var1, var2);
    }

    public void updateBytes(int var1, byte[] var2) throws SQLException {
        this.updateObject(var1, var2);
    }

    public void updateDate(int var1, Date var2) throws SQLException {
        this.updateObject(var1, var2);
    }

    public void updateTime(int var1, Time var2) throws SQLException {
        this.updateObject(var1, var2);
    }

    public void updateTimestamp(int var1, Timestamp var2) throws SQLException {
        this.updateObject(var1, var2);
    }

    public void updateAsciiStream(int var1, InputStream var2, int var3) throws SQLException {
        this.ensureOpen();
        if (this.isRowDeleted) {
            SQLException var13 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 82);
            var13.fillInStackTrace();
            throw var13;
        } else {
            OracleResultSetMetaData var4 = (OracleResultSetMetaData)this.getInternalMetadata();
            int var5 = var4.getColumnType(var1);
            if (var2 != null && var3 > 0) {
                switch(var5) {
                    case -1:
                        int[] var6 = new int[]{var3, 1};
                        this.setRowBufferAt(var1, var2, var6);
                        break;
                    case 2004:
                        this.updateBlob(var1, var2, (long)var3);
                        break;
                    case 2005:
                        this.updateClob(var1, var2, var3);
                        break;
                    case 2011:
                        this.updateNClob(var1, var2, var3);
                        break;
                    default:
                        try {
                            boolean var7 = false;
                            int var15 = var3;
                            byte[] var9 = new byte[1024];
                            char[] var10 = new char[1024];

                            StringBuilder var11;
                            int var14;
                            for(var11 = new StringBuilder(1024); var15 > 0; var15 -= var14) {
                                if (var15 >= 1024) {
                                    var14 = var2.read(var9);
                                } else {
                                    var14 = var2.read(var9, 0, var15);
                                }

                                if (var14 == -1) {
                                    break;
                                }

                                DBConversion var10000 = this.connection.conversion;
                                DBConversion.asciiBytesToJavaChars(var9, var14, var10);
                                var11.append(var10, 0, var14);
                            }

                            var2.close();
                            if (var15 == var3) {
                                this.updateNull(var1);
                                return;
                            }

                            this.updateString(var1, var11.toString());
                        } catch (IOException var12) {
                            SQLException var8 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), var12);
                            var8.fillInStackTrace();
                            throw var8;
                        }
                }
            } else {
                this.setRowBufferAt(var1, (Datum)null);
            }

        }
    }

    public void updateBinaryStream(int var1, InputStream var2, int var3) throws SQLException {
        this.ensureOpen();
        if (this.isRowDeleted) {
            SQLException var11 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 82);
            var11.fillInStackTrace();
            throw var11;
        } else {
            int var4 = this.getInternalMetadata().getColumnType(var1);
            if (var2 != null && var3 > 0) {
                switch(var4) {
                    case -4:
                        int[] var5 = new int[]{var3, 2};
                        this.setRowBufferAt(var1, var2, var5);
                        break;
                    case 2004:
                        this.updateBlob(var1, var2, (long)var3);
                        break;
                    default:
                        try {
                            boolean var6 = false;
                            int var13 = var3;
                            byte[] var8 = new byte[1024];

                            ByteArrayOutputStream var9;
                            int var12;
                            for(var9 = new ByteArrayOutputStream(1024); var13 > 0; var13 -= var12) {
                                if (var13 >= 1024) {
                                    var12 = var2.read(var8);
                                } else {
                                    var12 = var2.read(var8, 0, var13);
                                }

                                if (var12 == -1) {
                                    break;
                                }

                                var9.write(var8, 0, var12);
                            }

                            var2.close();
                            if (var13 == var3) {
                                this.updateNull(var1);
                                return;
                            }

                            this.updateBytes(var1, var9.toByteArray());
                        } catch (IOException var10) {
                            SQLException var7 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), var10);
                            var7.fillInStackTrace();
                            throw var7;
                        }
                }
            } else {
                this.setRowBufferAt(var1, (Datum)null);
            }

        }
    }

    public void updateCharacterStream(int var1, Reader var2, int var3) throws SQLException {
        boolean var4 = false;
        int var5 = var3;
        this.ensureOpen();
        if (this.isRowDeleted) {
            SQLException var13 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 82);
            var13.fillInStackTrace();
            throw var13;
        } else {
            OracleResultSetMetaData var6 = (OracleResultSetMetaData)this.getInternalMetadata();
            int var7 = var6.getColumnType(var1);
            if (var2 != null && var3 > 0) {
                switch(var7) {
                    case -1:
                        int[] var8 = new int[]{var3};
                        this.setRowBufferAt(var1, var2, var8);
                        break;
                    case 2005:
                        this.updateClob(var1, var2, (long)var3);
                        break;
                    case 2011:
                        this.updateNClob(var1, var2, (long)var3);
                        break;
                    default:
                        try {
                            char[] var9 = new char[1024];

                            int var12;
                            StringBuilder var14;
                            for(var14 = new StringBuilder(1024); var5 > 0; var5 -= var12) {
                                if (var5 >= 1024) {
                                    var12 = var2.read(var9);
                                } else {
                                    var12 = var2.read(var9, 0, var5);
                                }

                                if (var12 == -1) {
                                    break;
                                }

                                var14.append(var9, 0, var12);
                            }

                            var2.close();
                            if (var5 == var3) {
                                this.updateNull(var1);
                                return;
                            }

                            this.updateString(var1, var14.toString());
                        } catch (IOException var11) {
                            SQLException var10 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), var11);
                            var10.fillInStackTrace();
                            throw var10;
                        }
                }
            } else {
                this.setRowBufferAt(var1, (Datum)null);
            }

        }
    }

    public void updateObject(int var1, Object var2, int var3) throws SQLException {
        this.updateObject(var1, var2);
    }

    public void updateObject(int var1, Object var2) throws SQLException {
        synchronized(this.connection) {
            this.ensureOpen();
            if (this.isRowDeleted) {
                SQLException var13 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 82);
                var13.fillInStackTrace();
                throw var13;
            } else {
                Datum var4 = null;
                if (var2 != null) {
                    if (var2 instanceof OracleData) {
                        Object var5 = ((OracleData)var2).toJDBCObject(this.connection);
                        if (var5 instanceof _Proxy_) {
                            final _Proxy_ var6 = (_Proxy_)var5;
                            var5 = AccessController.doPrivileged(new PrivilegedAction<Object>() {
                                public Object run() {
                                    return ProxyFactory.extractDelegate(var6);
                                }
                            });
                        }

                        var2 = var5;
                    }

                    if (var2 instanceof Datum) {
                        var4 = (Datum)var2;
                    } else {
                        OracleResultSetMetaData var14 = (OracleResultSetMetaData)this.getInternalMetadata();
                        int var7 = var14.getColumnType(var1);
                        switch(var7) {
                            case -15:
                            case -9:
                            case -1:
                            case 1:
                            case 12:
                                if (var2 instanceof byte[]) {
                                    byte[] var8 = (byte[])((byte[])var2);
                                    char[] var9 = new char[var8.length * 3];
                                    int var10 = DBConversion.RAWBytesToHexChars(var8, var8.length, var9);
                                    var2 = new String(var9, 0, var10);
                                }
                            default:
                                var4 = SQLUtil.makeOracleDatum(this.connection, var2, var14.getColumnType(var1), (String)null, var14.isNCHAR(var1));
                        }
                    }
                }

                this.setRowBufferAt(var1, var4);
            }
        }
    }

    public void updateOracleObject(int var1, Datum var2) throws SQLException {
        synchronized(this.connection) {
            this.setRowBufferAt(var1, var2);
        }
    }

    public void updateROWID(int var1, ROWID var2) throws SQLException {
        this.updateOracleObject(var1, var2);
    }

    public void updateNUMBER(int var1, NUMBER var2) throws SQLException {
        this.updateOracleObject(var1, var2);
    }

    public void updateDATE(int var1, DATE var2) throws SQLException {
        this.updateOracleObject(var1, var2);
    }

    public void updateINTERVALYM(int var1, INTERVALYM var2) throws SQLException {
        this.updateOracleObject(var1, var2);
    }

    public void updateINTERVALDS(int var1, INTERVALDS var2) throws SQLException {
        this.updateOracleObject(var1, var2);
    }

    public void updateTIMESTAMP(int var1, TIMESTAMP var2) throws SQLException {
        this.updateOracleObject(var1, var2);
    }

    public void updateTIMESTAMPTZ(int var1, TIMESTAMPTZ var2) throws SQLException {
        this.updateOracleObject(var1, var2);
    }

    public void updateTIMESTAMPLTZ(int var1, TIMESTAMPLTZ var2) throws SQLException {
        this.updateOracleObject(var1, var2);
    }

    public void updateARRAY(int var1, ARRAY var2) throws SQLException {
        this.updateOracleObject(var1, var2);
    }

    public void updateSTRUCT(int var1, STRUCT var2) throws SQLException {
        this.updateOracleObject(var1, var2);
    }

    public void updateOPAQUE(int var1, OPAQUE var2) throws SQLException {
        this.updateOracleObject(var1, var2);
    }

    public void updateREF(int var1, REF var2) throws SQLException {
        this.updateOracleObject(var1, var2);
    }

    public void updateCHAR(int var1, CHAR var2) throws SQLException {
        this.updateOracleObject(var1, var2);
    }

    public void updateRAW(int var1, RAW var2) throws SQLException {
        this.updateOracleObject(var1, var2);
    }

    public void updateBLOB(int var1, BLOB var2) throws SQLException {
        this.updateOracleObject(var1, var2);
    }

    public void updateCLOB(int var1, CLOB var2) throws SQLException {
        this.updateOracleObject(var1, var2);
    }

    public void updateBFILE(int var1, BFILE var2) throws SQLException {
        this.updateOracleObject(var1, var2);
    }

    public void updateBfile(int var1, BFILE var2) throws SQLException {
        this.updateOracleObject(var1, var2);
    }

    public void updateCustomDatum(int var1, CustomDatum var2) throws SQLException {
        throw new Error("wanna do datum = ((CustomDatum) x).toDatum(m_comm)");
    }

    public void updateORAData(int var1, ORAData var2) throws SQLException {
        Datum var3 = var2.toDatum(this.connection);
        this.updateOracleObject(var1, var3);
    }

    public void updateRef(int var1, Ref var2) throws SQLException {
        this.updateREF(var1, (REF)var2);
    }

    public void updateBlob(int var1, Blob var2) throws SQLException {
        this.updateBLOB(var1, (BLOB)var2);
    }

    public void updateClob(int var1, Clob var2) throws SQLException {
        this.updateCLOB(var1, (CLOB)var2);
    }

    public void updateArray(int var1, Array var2) throws SQLException {
        this.updateARRAY(var1, (ARRAY)var2);
    }
}
