//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package oracle.jdbc.driver;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.Reader;
import java.math.BigDecimal;
import java.net.URL;
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
import java.sql.Statement;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Map;
import oracle.jdbc.OracleDataFactory;
import oracle.jdbc.OracleResultSet.AuthorizationIndicator;
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

class ArrayDataResultSet extends OracleResultSet {
    Datum[] data;
    Map map;
    private int currentIndex;
    private int lastIndex;
    private Boolean wasNull;
    private int fetchSize;
    ARRAY array;
    private static final String _Copyright_2007_Oracle_All_Rights_Reserved_ = null;
    public static final String BUILD_DATE = "Thu_Apr_04_15:09:24_PDT_2013";
    public static final boolean TRACE = false;

    ArrayDataResultSet(PhysicalConnection var1, Datum[] var2, Map var3) throws SQLException {
        super(var1);
        this.connection = var1;
        this.data = var2;
        this.map = var3;
        this.currentIndex = 0;
        this.lastIndex = this.data == null ? 0 : this.data.length;
        this.fetchSize = OracleConnection.DEFAULT_ROW_PREFETCH;
    }

    ArrayDataResultSet(PhysicalConnection var1, Datum[] var2, long var3, int var5, Map var6) throws SQLException {
        super(var1);
        this.connection = var1;
        this.data = var2;
        this.map = var6;
        this.currentIndex = (int)var3 - 1;
        int var7 = this.data == null ? 0 : this.data.length;
        this.lastIndex = this.currentIndex + Math.min(var7 - this.currentIndex, var5);
        this.fetchSize = OracleConnection.DEFAULT_ROW_PREFETCH;
    }

    ArrayDataResultSet(PhysicalConnection var1, ARRAY var2, long var3, int var5, Map var6) throws SQLException {
        super(var1);
        this.connection = var1;
        this.array = var2;
        this.map = var6;
        this.currentIndex = (int)var3 - 1;
        int var7 = this.array == null ? 0 : var2.length();
        this.lastIndex = this.currentIndex + (var5 == -1 ? var7 - this.currentIndex : Math.min(var7 - this.currentIndex, var5));
        this.fetchSize = OracleConnection.DEFAULT_ROW_PREFETCH;
    }

    OracleStatement getOracleStatement() throws SQLException {
        return null;
    }

    int refreshRows(int var1, int var2) throws SQLException {
        SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 75, "beforeFirst");
        var3.fillInStackTrace();
        throw var3;
    }

    void removeCurrentRowFromCache() throws SQLException {
    }

    int getColumnCount() throws SQLException {
        return 2;
    }

    protected void doneFetchingRows(boolean var1) throws SQLException {
    }

    public boolean next() throws SQLException {
        if (this.closed) {
            SQLException var1 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 10, "next");
            var1.fillInStackTrace();
            throw var1;
        } else {
            ++this.currentIndex;
            return this.currentIndex <= this.lastIndex;
        }
    }

    public void close() throws SQLException {
        synchronized(this.connection) {
            super.close();
        }
    }

    public boolean wasNull() throws SQLException {
        synchronized(this.connection) {
            if (this.wasNull == null) {
                SQLException var2 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 24, (Object)null);
                var2.fillInStackTrace();
                throw var2;
            } else {
                return this.wasNull;
            }
        }
    }

    public void beforeFirst() throws SQLException {
        SQLException var1 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 75, "beforeFirst");
        var1.fillInStackTrace();
        throw var1;
    }

    public void afterLast() throws SQLException {
        SQLException var1 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 75, "afterLast");
        var1.fillInStackTrace();
        throw var1;
    }

    public boolean first() throws SQLException {
        SQLException var1 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 75, "first");
        var1.fillInStackTrace();
        throw var1;
    }

    public boolean last() throws SQLException {
        SQLException var1 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 75, "last");
        var1.fillInStackTrace();
        throw var1;
    }

    public boolean absolute(int var1) throws SQLException {
        SQLException var2 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 75, "absolute");
        var2.fillInStackTrace();
        throw var2;
    }

    public boolean relative(int var1) throws SQLException {
        SQLException var2 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 75, "relative");
        var2.fillInStackTrace();
        throw var2;
    }

    public boolean previous() throws SQLException {
        SQLException var1 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 75, "previous");
        var1.fillInStackTrace();
        throw var1;
    }

    public String getString(int var1) throws SQLException {
        synchronized(this.connection) {
            Datum var3 = this.getOracleObject(var1);
            if (var3 != null) {
                return !(var3 instanceof TIMESTAMPTZ) && !(var3 instanceof TIMESTAMPLTZ) ? var3.stringValue() : var3.stringValue(this.connection);
            } else {
                return null;
            }
        }
    }

    public ResultSet getCursor(int var1) throws SQLException {
        synchronized(this.connection){}

        try {
            SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 4, "getCursor");
            var3.fillInStackTrace();
            throw var3;
        } finally {
            ;
        }
    }

    public Datum getOracleObject(int var1) throws SQLException {
        SQLException var2;
        if (this.currentIndex <= 0) {
            var2 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 14, (Object)null);
            var2.fillInStackTrace();
            throw var2;
        } else if (var1 == 1) {
            this.wasNull = Boolean.FALSE;
            return new NUMBER(this.currentIndex);
        } else if (var1 == 2) {
            if (this.data != null) {
                this.wasNull = this.data[this.currentIndex - 1] == null ? Boolean.TRUE : Boolean.FALSE;
                return this.data[this.currentIndex - 1];
            } else {
                if (this.array != null) {
                    Datum[] var3 = this.array.getOracleArray((long)this.currentIndex, 1);
                    if (var3 != null && var3.length >= 1) {
                        this.wasNull = var3[0] == null ? Boolean.TRUE : Boolean.FALSE;
                        return var3[0];
                    }
                }

                var2 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 1, "Out of sync");
                var2.fillInStackTrace();
                throw var2;
            }
        } else {
            var2 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 3, (Object)null);
            var2.fillInStackTrace();
            throw var2;
        }
    }

    public ROWID getROWID(int var1) throws SQLException {
        synchronized(this.connection) {
            Datum var3 = this.getOracleObject(var1);
            if (var3 != null) {
                if (var3 instanceof ROWID) {
                    return (ROWID)var3;
                } else {
                    SQLException var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 4, "getROWID");
                    var4.fillInStackTrace();
                    throw var4;
                }
            } else {
                return null;
            }
        }
    }

    public NUMBER getNUMBER(int var1) throws SQLException {
        synchronized(this.connection) {
            Datum var3 = this.getOracleObject(var1);
            if (var3 != null) {
                if (var3 instanceof NUMBER) {
                    return (NUMBER)var3;
                } else {
                    SQLException var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 4, "getNUMBER");
                    var4.fillInStackTrace();
                    throw var4;
                }
            } else {
                return null;
            }
        }
    }

    public DATE getDATE(int var1) throws SQLException {
        synchronized(this.connection) {
            Datum var3 = this.getOracleObject(var1);
            if (var3 != null) {
                if (var3 instanceof DATE) {
                    return (DATE)var3;
                } else {
                    SQLException var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 4, "getDATE");
                    var4.fillInStackTrace();
                    throw var4;
                }
            } else {
                return null;
            }
        }
    }

    public ARRAY getARRAY(int var1) throws SQLException {
        synchronized(this.connection) {
            Datum var3 = this.getOracleObject(var1);
            if (var3 != null) {
                if (var3 instanceof ARRAY) {
                    return (ARRAY)var3;
                } else {
                    SQLException var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 4, "getARRAY");
                    var4.fillInStackTrace();
                    throw var4;
                }
            } else {
                return null;
            }
        }
    }

    public STRUCT getSTRUCT(int var1) throws SQLException {
        synchronized(this.connection) {
            Datum var3 = this.getOracleObject(var1);
            if (var3 != null) {
                if (var3 instanceof STRUCT) {
                    return (STRUCT)var3;
                } else {
                    SQLException var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 4, "getSTRUCT");
                    var4.fillInStackTrace();
                    throw var4;
                }
            } else {
                return null;
            }
        }
    }

    public OPAQUE getOPAQUE(int var1) throws SQLException {
        synchronized(this.connection) {
            Datum var3 = this.getOracleObject(var1);
            if (var3 != null) {
                if (var3 instanceof OPAQUE) {
                    return (OPAQUE)var3;
                } else {
                    SQLException var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 4, "getOPAQUE");
                    var4.fillInStackTrace();
                    throw var4;
                }
            } else {
                return null;
            }
        }
    }

    public REF getREF(int var1) throws SQLException {
        synchronized(this.connection) {
            Datum var3 = this.getOracleObject(var1);
            if (var3 != null) {
                if (var3 instanceof REF) {
                    return (REF)var3;
                } else {
                    SQLException var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 4, "getREF");
                    var4.fillInStackTrace();
                    throw var4;
                }
            } else {
                return null;
            }
        }
    }

    public CHAR getCHAR(int var1) throws SQLException {
        synchronized(this.connection) {
            Datum var3 = this.getOracleObject(var1);
            if (var3 != null) {
                if (var3 instanceof CHAR) {
                    return (CHAR)var3;
                } else {
                    SQLException var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 4, "getCHAR");
                    var4.fillInStackTrace();
                    throw var4;
                }
            } else {
                return null;
            }
        }
    }

    public RAW getRAW(int var1) throws SQLException {
        synchronized(this.connection) {
            Datum var3 = this.getOracleObject(var1);
            if (var3 != null) {
                if (var3 instanceof RAW) {
                    return (RAW)var3;
                } else {
                    SQLException var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 4, "getRAW");
                    var4.fillInStackTrace();
                    throw var4;
                }
            } else {
                return null;
            }
        }
    }

    public BLOB getBLOB(int var1) throws SQLException {
        synchronized(this.connection) {
            Datum var3 = this.getOracleObject(var1);
            if (var3 != null) {
                if (var3 instanceof BLOB) {
                    return (BLOB)var3;
                } else {
                    SQLException var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 4, "getBLOB");
                    var4.fillInStackTrace();
                    throw var4;
                }
            } else {
                return null;
            }
        }
    }

    public CLOB getCLOB(int var1) throws SQLException {
        synchronized(this.connection) {
            Datum var3 = this.getOracleObject(var1);
            if (var3 != null) {
                if (var3 instanceof CLOB) {
                    return (CLOB)var3;
                } else {
                    SQLException var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 4, "getCLOB");
                    var4.fillInStackTrace();
                    throw var4;
                }
            } else {
                return null;
            }
        }
    }

    public BFILE getBFILE(int var1) throws SQLException {
        synchronized(this.connection) {
            Datum var3 = this.getOracleObject(var1);
            if (var3 != null) {
                if (var3 instanceof BFILE) {
                    return (BFILE)var3;
                } else {
                    SQLException var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 4, "getBFILE");
                    var4.fillInStackTrace();
                    throw var4;
                }
            } else {
                return null;
            }
        }
    }

    public INTERVALDS getINTERVALDS(int var1) throws SQLException {
        synchronized(this.connection) {
            Datum var3 = this.getOracleObject(var1);
            if (var3 != null) {
                if (var3 instanceof INTERVALDS) {
                    return (INTERVALDS)var3;
                } else {
                    SQLException var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 4);
                    var4.fillInStackTrace();
                    throw var4;
                }
            } else {
                return null;
            }
        }
    }

    public INTERVALYM getINTERVALYM(int var1) throws SQLException {
        synchronized(this.connection) {
            Datum var3 = this.getOracleObject(var1);
            if (var3 != null) {
                if (var3 instanceof INTERVALYM) {
                    return (INTERVALYM)var3;
                } else {
                    SQLException var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 4);
                    var4.fillInStackTrace();
                    throw var4;
                }
            } else {
                return null;
            }
        }
    }

    public BFILE getBfile(int var1) throws SQLException {
        synchronized(this.connection) {
            return this.getBFILE(var1);
        }
    }

    public TIMESTAMP getTIMESTAMP(int var1) throws SQLException {
        synchronized(this.connection) {
            Datum var3 = this.getOracleObject(var1);
            if (var3 != null) {
                if (var3 instanceof TIMESTAMP) {
                    return (TIMESTAMP)var3;
                } else {
                    SQLException var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 4, "getTIMESTAMP");
                    var4.fillInStackTrace();
                    throw var4;
                }
            } else {
                return null;
            }
        }
    }

    public TIMESTAMPTZ getTIMESTAMPTZ(int var1) throws SQLException {
        synchronized(this.connection) {
            Datum var3 = this.getOracleObject(var1);
            if (var3 != null) {
                if (var3 instanceof TIMESTAMPTZ) {
                    return (TIMESTAMPTZ)var3;
                } else {
                    SQLException var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 4, "getTIMESTAMPTZ");
                    var4.fillInStackTrace();
                    throw var4;
                }
            } else {
                return null;
            }
        }
    }

    public TIMESTAMPLTZ getTIMESTAMPLTZ(int var1) throws SQLException {
        synchronized(this.connection) {
            Datum var3 = this.getOracleObject(var1);
            if (var3 != null) {
                if (var3 instanceof TIMESTAMPLTZ) {
                    return (TIMESTAMPLTZ)var3;
                } else {
                    SQLException var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 4, "getTIMESTAMPLTZ");
                    var4.fillInStackTrace();
                    throw var4;
                }
            } else {
                return null;
            }
        }
    }

    public boolean getBoolean(int var1) throws SQLException {
        synchronized(this.connection) {
            Datum var3 = this.getOracleObject(var1);
            return var3 != null ? var3.booleanValue() : false;
        }
    }

    public AuthorizationIndicator getAuthorizationIndicator(int var1) throws SQLException {
        return null;
    }

    public byte getByte(int var1) throws SQLException {
        synchronized(this.connection) {
            Datum var3 = this.getOracleObject(var1);
            return var3 != null ? var3.byteValue() : 0;
        }
    }

    public short getShort(int var1) throws SQLException {
        synchronized(this.connection) {
            long var3 = this.getLong(var1);
            if (var3 <= 65537L && var3 >= -65538L) {
                return (short)((int)var3);
            } else {
                SQLException var5 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 26, "getShort");
                var5.fillInStackTrace();
                throw var5;
            }
        }
    }

    public int getInt(int var1) throws SQLException {
        synchronized(this.connection) {
            Datum var3 = this.getOracleObject(var1);
            return var3 != null ? var3.intValue() : 0;
        }
    }

    public long getLong(int var1) throws SQLException {
        synchronized(this.connection) {
            Datum var3 = this.getOracleObject(var1);
            return var3 != null ? var3.longValue() : 0L;
        }
    }

    public float getFloat(int var1) throws SQLException {
        synchronized(this.connection) {
            Datum var3 = this.getOracleObject(var1);
            return var3 != null ? var3.floatValue() : 0.0F;
        }
    }

    public double getDouble(int var1) throws SQLException {
        synchronized(this.connection) {
            Datum var3 = this.getOracleObject(var1);
            return var3 != null ? var3.doubleValue() : 0.0D;
        }
    }

    public BigDecimal getBigDecimal(int var1, int var2) throws SQLException {
        synchronized(this.connection) {
            Datum var4 = this.getOracleObject(var1);
            return var4 != null ? var4.bigDecimalValue() : null;
        }
    }

    public byte[] getBytes(int var1) throws SQLException {
        synchronized(this.connection) {
            Datum var3 = this.getOracleObject(var1);
            if (var3 != null) {
                if (var3 instanceof RAW) {
                    return ((RAW)var3).shareBytes();
                } else {
                    SQLException var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 4, "getBytes");
                    var4.fillInStackTrace();
                    throw var4;
                }
            } else {
                return null;
            }
        }
    }

    public Date getDate(int var1) throws SQLException {
        synchronized(this.connection) {
            Datum var3 = this.getOracleObject(var1);
            return var3 != null ? var3.dateValue() : null;
        }
    }

    public Time getTime(int var1) throws SQLException {
        synchronized(this.connection) {
            Datum var3 = this.getOracleObject(var1);
            return var3 != null ? var3.timeValue() : null;
        }
    }

    public Timestamp getTimestamp(int var1) throws SQLException {
        synchronized(this.connection) {
            Datum var3 = this.getOracleObject(var1);
            return var3 != null ? var3.timestampValue() : null;
        }
    }

    public InputStream getAsciiStream(int var1) throws SQLException {
        synchronized(this.connection) {
            Datum var3 = this.getOracleObject(var1);
            if (var3 != null) {
                var3.asciiStreamValue();
            }

            return null;
        }
    }

    public InputStream getUnicodeStream(int var1) throws SQLException {
        synchronized(this.connection) {
            Datum var3 = this.getOracleObject(var1);
            if (var3 != null) {
                DBConversion var4 = this.connection.conversion;
                byte[] var5 = var3.shareBytes();
                ByteArrayInputStream var10001;
                PhysicalConnection var10002;
                if (var3 instanceof RAW) {
                    var10001 = new ByteArrayInputStream(var5);
                    var10002 = this.connection;
                    return var4.ConvertStream(var10001, 3);
                } else if (var3 instanceof CHAR) {
                    var10001 = new ByteArrayInputStream(var5);
                    var10002 = this.connection;
                    return var4.ConvertStream(var10001, 1);
                } else {
                    SQLException var6 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 4, "getUnicodeStream");
                    var6.fillInStackTrace();
                    throw var6;
                }
            } else {
                return null;
            }
        }
    }

    public InputStream getBinaryStream(int var1) throws SQLException {
        synchronized(this.connection) {
            Datum var3 = this.getOracleObject(var1);
            return var3 != null ? var3.binaryStreamValue() : null;
        }
    }

    public Object getObject(int var1, OracleDataFactory var2) throws SQLException {
        synchronized(this.connection) {
            Object var4 = this.getObject(var1);
            return var2.create(var4, 0);
        }
    }

    public Object getObject(int var1) throws SQLException {
        synchronized(this.connection) {
            return this.getObject(var1, this.map);
        }
    }

    /** @deprecated */
    public CustomDatum getCustomDatum(int var1, CustomDatumFactory var2) throws SQLException {
        synchronized(this.connection) {
            Datum var4 = this.getOracleObject(var1);
            return var2.create(var4, 0);
        }
    }

    public ORAData getORAData(int var1, ORADataFactory var2) throws SQLException {
        synchronized(this.connection) {
            Datum var4 = this.getOracleObject(var1);
            return var2.create(var4, 0);
        }
    }

    public ResultSetMetaData getMetaData() throws SQLException {
        synchronized(this.connection){}

        try {
            SQLException var2;
            if (this.closed) {
                var2 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 10, "getMetaData");
                var2.fillInStackTrace();
                throw var2;
            } else {
                var2 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 23, "getMetaData");
                var2.fillInStackTrace();
                throw var2;
            }
        } finally {
            ;
        }
    }

    public int findColumn(String var1) throws SQLException {
        synchronized(this.connection) {
            if (var1.equalsIgnoreCase("index")) {
                return 1;
            } else if (var1.equalsIgnoreCase("value")) {
                return 2;
            } else {
                SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 6, "get_column_index");
                var3.fillInStackTrace();
                throw var3;
            }
        }
    }

    public Statement getStatement() throws SQLException {
        return null;
    }

    public Object getObject(int var1, Map var2) throws SQLException {
        synchronized(this.connection) {
            Datum var4 = this.getOracleObject(var1);
            if (var4 != null) {
                return var4 instanceof STRUCT ? ((STRUCT)var4).toJdbc(var2) : var4.toJdbc();
            } else {
                return null;
            }
        }
    }

    public Ref getRef(int var1) throws SQLException {
        synchronized(this.connection) {
            return this.getREF(var1);
        }
    }

    public Blob getBlob(int var1) throws SQLException {
        synchronized(this.connection) {
            return this.getBLOB(var1);
        }
    }

    public Clob getClob(int var1) throws SQLException {
        synchronized(this.connection) {
            return this.getCLOB(var1);
        }
    }

    public Array getArray(int var1) throws SQLException {
        synchronized(this.connection) {
            return this.getARRAY(var1);
        }
    }

    public Reader getCharacterStream(int var1) throws SQLException {
        synchronized(this.connection) {
            Datum var3 = this.getOracleObject(var1);
            return var3 != null ? var3.characterStreamValue() : null;
        }
    }

    public BigDecimal getBigDecimal(int var1) throws SQLException {
        synchronized(this.connection) {
            Datum var3 = this.getOracleObject(var1);
            return var3 != null ? var3.bigDecimalValue() : null;
        }
    }

    public Date getDate(int var1, Calendar var2) throws SQLException {
        synchronized(this.connection) {
            Datum var4 = this.getOracleObject(var1);
            if (var4 != null) {
                DATE var5 = null;
                if (var4 instanceof DATE) {
                    var5 = (DATE)var4;
                } else {
                    var5 = new DATE(var4.stringValue());
                }

                if (var5 != null) {
                    return var5.dateValue(var2);
                }
            }

            return null;
        }
    }

    public Time getTime(int var1, Calendar var2) throws SQLException {
        synchronized(this.connection) {
            Datum var4 = this.getOracleObject(var1);
            if (var4 != null) {
                DATE var5 = null;
                if (var4 instanceof DATE) {
                    var5 = (DATE)var4;
                } else {
                    var5 = new DATE(var4.stringValue());
                }

                if (var5 != null) {
                    return var5.timeValue(var2);
                }
            }

            return null;
        }
    }

    public Timestamp getTimestamp(int var1, Calendar var2) throws SQLException {
        synchronized(this.connection) {
            Datum var4 = this.getOracleObject(var1);
            if (var4 != null) {
                DATE var5 = null;
                if (var4 instanceof DATE) {
                    var5 = (DATE)var4;
                } else {
                    var5 = new DATE(var4.stringValue());
                }

                if (var5 != null) {
                    return var5.timestampValue(var2);
                }
            }

            return null;
        }
    }

    public URL getURL(int var1) throws SQLException {
        synchronized(this.connection){}

        try {
            SQLException var3 = DatabaseError.createUnsupportedFeatureSqlException();
            var3.fillInStackTrace();
            throw var3;
        } finally {
            ;
        }
    }

    public String getCursorName() throws SQLException {
        synchronized(this.connection){}

        try {
            SQLException var2 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 23, "getCursorName");
            var2.fillInStackTrace();
            throw var2;
        } finally {
            ;
        }
    }

    public NClob getNClob(int var1) throws SQLException {
        Datum var2 = this.getOracleObject(var1);
        if (var2 != null) {
            if (var2 instanceof NCLOB) {
                return (NCLOB)var2;
            } else {
                SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 4);
                var3.fillInStackTrace();
                throw var3;
            }
        } else {
            return null;
        }
    }

    public String getNString(int var1) throws SQLException {
        Datum var2 = this.getOracleObject(var1);
        return var2 != null ? var2.stringValue() : null;
    }

    public Reader getNCharacterStream(int var1) throws SQLException {
        Datum var2 = this.getOracleObject(var1);
        return var2 != null ? var2.characterStreamValue() : null;
    }

    public RowId getRowId(int var1) throws SQLException {
        return this.getROWID(var1);
    }

    public SQLXML getSQLXML(int var1) throws SQLException {
        Datum var2 = this.getOracleObject(var1);
        if (var2 != null) {
            if (var2 instanceof SQLXML) {
                return (SQLXML)var2;
            } else {
                SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 4);
                var3.fillInStackTrace();
                throw var3;
            }
        } else {
            return null;
        }
    }

    public <T> T getObject(int var1, Class<T> var2) throws SQLException {
        synchronized(this.connection) {
            Object var4 = this.getObject(var1);
            if (var2.isInstance(var4)) {
                return (T) var4;
            } else {
                SQLException var5 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 4);
                var5.fillInStackTrace();
                throw var5;
            }
        }
    }

    public boolean isBeforeFirst() throws SQLException {
        if (this.closed) {
            SQLException var1 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 10);
            var1.fillInStackTrace();
            throw var1;
        } else {
            return this.currentIndex < 1;
        }
    }

    public boolean isAfterLast() throws SQLException {
        if (this.closed) {
            SQLException var1 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 10);
            var1.fillInStackTrace();
            throw var1;
        } else {
            return this.currentIndex > this.lastIndex;
        }
    }

    public boolean isFirst() throws SQLException {
        if (this.closed) {
            SQLException var1 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 10);
            var1.fillInStackTrace();
            throw var1;
        } else {
            return this.currentIndex == 1;
        }
    }

    public boolean isLast() throws SQLException {
        if (this.closed) {
            SQLException var1 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 10);
            var1.fillInStackTrace();
            throw var1;
        } else {
            return this.currentIndex == this.lastIndex;
        }
    }

    public int getRow() throws SQLException {
        if (this.closed) {
            SQLException var1 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 10);
            var1.fillInStackTrace();
            throw var1;
        } else {
            return this.currentIndex;
        }
    }

    public void setFetchSize(int var1) throws SQLException {
        if (var1 < 0) {
            SQLException var2 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 68);
            var2.fillInStackTrace();
            throw var2;
        } else {
            if (var1 == 0) {
                this.fetchSize = OracleConnection.DEFAULT_ROW_PREFETCH;
            } else {
                this.fetchSize = var1;
            }

        }
    }

    public int getFetchSize() throws SQLException {
        return this.fetchSize;
    }

    public int getType() {
        return 1003;
    }

    public int getConcurrency() {
        return 1007;
    }

    protected oracle.jdbc.internal.OracleConnection getConnectionDuringExceptionHandling() {
        return this.connection;
    }
}
