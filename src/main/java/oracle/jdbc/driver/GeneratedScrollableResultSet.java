//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package oracle.jdbc.driver;

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
import java.sql.RowId;
import java.sql.SQLException;
import java.sql.SQLXML;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Map;
import oracle.jdbc.OracleDataFactory;
import oracle.jdbc.internal.OracleConnection;
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

abstract class GeneratedScrollableResultSet extends OracleResultSet {
    protected OracleStatement statement;
    protected int currentRow;
    protected int fetchedRowCount;
    private static final String _Copyright_2007_Oracle_All_Rights_Reserved_ = null;
    public static final String BUILD_DATE = "Thu_Apr_04_15:09:24_PDT_2013";
    public static final boolean TRACE = false;

    GeneratedScrollableResultSet(PhysicalConnection var1, OracleStatement var2) throws SQLException {
        super(var1);
        this.statement = var2;
        this.currentRow = -1;
        this.fetchedRowCount = 0;
    }

    public Array getArray(int var1) throws SQLException {
        return this.getARRAY(var1);
    }

    public BigDecimal getBigDecimal(int var1) throws SQLException {
        synchronized(this.connection) {
            SQLException var3;
            if (this.closed) {
                var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 10, "getBigDecimal");
                var3.fillInStackTrace();
                throw var3;
            } else if (this.statement.closed) {
                var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9, "getBigDecimal");
                var3.fillInStackTrace();
                throw var3;
            } else if (var1 >= 1 && var1 <= this.statement.getNumberOfColumns()) {
                if (this.currentRow < 0) {
                    var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 14);
                    var3.fillInStackTrace();
                    throw var3;
                } else if (this.currentRow == this.fetchedRowCount) {
                    var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 289);
                    var3.fillInStackTrace();
                    throw var3;
                } else {
                    return this.statement.getBigDecimal(this.currentRow, var1);
                }
            } else {
                var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 3);
                var3.fillInStackTrace();
                throw var3;
            }
        }
    }

    public BigDecimal getBigDecimal(int var1, int var2) throws SQLException {
        synchronized(this.connection) {
            SQLException var4;
            if (this.closed) {
                var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 10, "getBigDecimal");
                var4.fillInStackTrace();
                throw var4;
            } else if (this.statement.closed) {
                var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9, "getBigDecimal");
                var4.fillInStackTrace();
                throw var4;
            } else if (var1 >= 1 && var1 <= this.statement.getNumberOfColumns()) {
                if (this.currentRow < 0) {
                    var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 14);
                    var4.fillInStackTrace();
                    throw var4;
                } else if (this.currentRow == this.fetchedRowCount) {
                    var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 289);
                    var4.fillInStackTrace();
                    throw var4;
                } else {
                    return this.statement.getBigDecimal(this.currentRow, var1, var2);
                }
            } else {
                var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 3);
                var4.fillInStackTrace();
                throw var4;
            }
        }
    }

    public Blob getBlob(int var1) throws SQLException {
        return this.getBLOB(var1);
    }

    public boolean getBoolean(int var1) throws SQLException {
        synchronized(this.connection) {
            SQLException var3;
            if (this.closed) {
                var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 10, "getBoolean");
                var3.fillInStackTrace();
                throw var3;
            } else if (this.statement.closed) {
                var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9, "getBoolean");
                var3.fillInStackTrace();
                throw var3;
            } else if (var1 >= 1 && var1 <= this.statement.getNumberOfColumns()) {
                if (this.currentRow < 0) {
                    var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 14);
                    var3.fillInStackTrace();
                    throw var3;
                } else if (this.currentRow == this.fetchedRowCount) {
                    var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 289);
                    var3.fillInStackTrace();
                    throw var3;
                } else {
                    return this.statement.getBoolean(this.currentRow, var1);
                }
            } else {
                var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 3);
                var3.fillInStackTrace();
                throw var3;
            }
        }
    }

    public byte getByte(int var1) throws SQLException {
        synchronized(this.connection) {
            SQLException var3;
            if (this.closed) {
                var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 10, "getByte");
                var3.fillInStackTrace();
                throw var3;
            } else if (this.statement.closed) {
                var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9, "getByte");
                var3.fillInStackTrace();
                throw var3;
            } else if (var1 >= 1 && var1 <= this.statement.getNumberOfColumns()) {
                if (this.currentRow < 0) {
                    var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 14);
                    var3.fillInStackTrace();
                    throw var3;
                } else if (this.currentRow == this.fetchedRowCount) {
                    var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 289);
                    var3.fillInStackTrace();
                    throw var3;
                } else {
                    return this.statement.getByte(this.currentRow, var1);
                }
            } else {
                var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 3);
                var3.fillInStackTrace();
                throw var3;
            }
        }
    }

    public byte[] getBytes(int var1) throws SQLException {
        synchronized(this.connection) {
            SQLException var3;
            if (this.closed) {
                var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 10, "getBytes");
                var3.fillInStackTrace();
                throw var3;
            } else if (this.statement.closed) {
                var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9, "getBytes");
                var3.fillInStackTrace();
                throw var3;
            } else if (var1 >= 1 && var1 <= this.statement.getNumberOfColumns()) {
                if (this.currentRow < 0) {
                    var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 14);
                    var3.fillInStackTrace();
                    throw var3;
                } else if (this.currentRow == this.fetchedRowCount) {
                    var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 289);
                    var3.fillInStackTrace();
                    throw var3;
                } else {
                    return this.statement.getBytes(this.currentRow, var1);
                }
            } else {
                var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 3);
                var3.fillInStackTrace();
                throw var3;
            }
        }
    }

    public Clob getClob(int var1) throws SQLException {
        return this.getCLOB(var1);
    }

    public Date getDate(int var1) throws SQLException {
        synchronized(this.connection) {
            SQLException var3;
            if (this.closed) {
                var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 10, "getDate");
                var3.fillInStackTrace();
                throw var3;
            } else if (this.statement.closed) {
                var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9, "getDate");
                var3.fillInStackTrace();
                throw var3;
            } else if (var1 >= 1 && var1 <= this.statement.getNumberOfColumns()) {
                if (this.currentRow < 0) {
                    var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 14);
                    var3.fillInStackTrace();
                    throw var3;
                } else if (this.currentRow == this.fetchedRowCount) {
                    var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 289);
                    var3.fillInStackTrace();
                    throw var3;
                } else {
                    return this.statement.getDate(this.currentRow, var1);
                }
            } else {
                var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 3);
                var3.fillInStackTrace();
                throw var3;
            }
        }
    }

    public Date getDate(int var1, Calendar var2) throws SQLException {
        synchronized(this.connection) {
            SQLException var4;
            if (this.closed) {
                var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 10, "getDate");
                var4.fillInStackTrace();
                throw var4;
            } else if (this.statement.closed) {
                var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9, "getDate");
                var4.fillInStackTrace();
                throw var4;
            } else if (var1 >= 1 && var1 <= this.statement.getNumberOfColumns()) {
                if (this.currentRow < 0) {
                    var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 14);
                    var4.fillInStackTrace();
                    throw var4;
                } else if (this.currentRow == this.fetchedRowCount) {
                    var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 289);
                    var4.fillInStackTrace();
                    throw var4;
                } else {
                    return this.statement.getDate(this.currentRow, var1, var2);
                }
            } else {
                var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 3);
                var4.fillInStackTrace();
                throw var4;
            }
        }
    }

    public double getDouble(int var1) throws SQLException {
        synchronized(this.connection) {
            SQLException var3;
            if (this.closed) {
                var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 10, "getDouble");
                var3.fillInStackTrace();
                throw var3;
            } else if (this.statement.closed) {
                var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9, "getDouble");
                var3.fillInStackTrace();
                throw var3;
            } else if (var1 >= 1 && var1 <= this.statement.getNumberOfColumns()) {
                if (this.currentRow < 0) {
                    var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 14);
                    var3.fillInStackTrace();
                    throw var3;
                } else if (this.currentRow == this.fetchedRowCount) {
                    var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 289);
                    var3.fillInStackTrace();
                    throw var3;
                } else {
                    return this.statement.getDouble(this.currentRow, var1);
                }
            } else {
                var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 3);
                var3.fillInStackTrace();
                throw var3;
            }
        }
    }

    public float getFloat(int var1) throws SQLException {
        synchronized(this.connection) {
            SQLException var3;
            if (this.closed) {
                var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 10, "getFloat");
                var3.fillInStackTrace();
                throw var3;
            } else if (this.statement.closed) {
                var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9, "getFloat");
                var3.fillInStackTrace();
                throw var3;
            } else if (var1 >= 1 && var1 <= this.statement.getNumberOfColumns()) {
                if (this.currentRow < 0) {
                    var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 14);
                    var3.fillInStackTrace();
                    throw var3;
                } else if (this.currentRow == this.fetchedRowCount) {
                    var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 289);
                    var3.fillInStackTrace();
                    throw var3;
                } else {
                    return this.statement.getFloat(this.currentRow, var1);
                }
            } else {
                var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 3);
                var3.fillInStackTrace();
                throw var3;
            }
        }
    }

    public int getInt(int var1) throws SQLException {
        synchronized(this.connection) {
            SQLException var3;
            if (this.closed) {
                var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 10, "getInt");
                var3.fillInStackTrace();
                throw var3;
            } else if (this.statement.closed) {
                var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9, "getInt");
                var3.fillInStackTrace();
                throw var3;
            } else if (var1 >= 1 && var1 <= this.statement.getNumberOfColumns()) {
                if (this.currentRow < 0) {
                    var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 14);
                    var3.fillInStackTrace();
                    throw var3;
                } else if (this.currentRow == this.fetchedRowCount) {
                    var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 289);
                    var3.fillInStackTrace();
                    throw var3;
                } else {
                    return this.statement.getInt(this.currentRow, var1);
                }
            } else {
                var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 3);
                var3.fillInStackTrace();
                throw var3;
            }
        }
    }

    public long getLong(int var1) throws SQLException {
        synchronized(this.connection) {
            SQLException var3;
            if (this.closed) {
                var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 10, "getLong");
                var3.fillInStackTrace();
                throw var3;
            } else if (this.statement.closed) {
                var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9, "getLong");
                var3.fillInStackTrace();
                throw var3;
            } else if (var1 >= 1 && var1 <= this.statement.getNumberOfColumns()) {
                if (this.currentRow < 0) {
                    var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 14);
                    var3.fillInStackTrace();
                    throw var3;
                } else if (this.currentRow == this.fetchedRowCount) {
                    var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 289);
                    var3.fillInStackTrace();
                    throw var3;
                } else {
                    return this.statement.getLong(this.currentRow, var1);
                }
            } else {
                var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 3);
                var3.fillInStackTrace();
                throw var3;
            }
        }
    }

    public NClob getNClob(int var1) throws SQLException {
        synchronized(this.connection) {
            SQLException var3;
            if (this.closed) {
                var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 10, "getNClob");
                var3.fillInStackTrace();
                throw var3;
            } else if (this.statement.closed) {
                var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9, "getNClob");
                var3.fillInStackTrace();
                throw var3;
            } else if (var1 >= 1 && var1 <= this.statement.getNumberOfColumns()) {
                if (this.currentRow < 0) {
                    var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 14);
                    var3.fillInStackTrace();
                    throw var3;
                } else if (this.currentRow == this.fetchedRowCount) {
                    var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 289);
                    var3.fillInStackTrace();
                    throw var3;
                } else {
                    return this.statement.getNClob(this.currentRow, var1);
                }
            } else {
                var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 3);
                var3.fillInStackTrace();
                throw var3;
            }
        }
    }

    public String getNString(int var1) throws SQLException {
        synchronized(this.connection) {
            SQLException var3;
            if (this.closed) {
                var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 10, "getNString");
                var3.fillInStackTrace();
                throw var3;
            } else if (this.statement.closed) {
                var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9, "getNString");
                var3.fillInStackTrace();
                throw var3;
            } else if (var1 >= 1 && var1 <= this.statement.getNumberOfColumns()) {
                if (this.currentRow < 0) {
                    var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 14);
                    var3.fillInStackTrace();
                    throw var3;
                } else if (this.currentRow == this.fetchedRowCount) {
                    var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 289);
                    var3.fillInStackTrace();
                    throw var3;
                } else {
                    return this.statement.getNString(this.currentRow, var1);
                }
            } else {
                var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 3);
                var3.fillInStackTrace();
                throw var3;
            }
        }
    }

    public Object getObject(int var1) throws SQLException {
        synchronized(this.connection) {
            SQLException var3;
            if (this.closed) {
                var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 10, "getObject");
                var3.fillInStackTrace();
                throw var3;
            } else if (this.statement.closed) {
                var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9, "getObject");
                var3.fillInStackTrace();
                throw var3;
            } else if (var1 >= 1 && var1 <= this.statement.getNumberOfColumns()) {
                if (this.currentRow < 0) {
                    var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 14);
                    var3.fillInStackTrace();
                    throw var3;
                } else if (this.currentRow == this.fetchedRowCount) {
                    var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 289);
                    var3.fillInStackTrace();
                    throw var3;
                } else {
                    return this.statement.getObject(this.currentRow, var1);
                }
            } else {
                var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 3);
                var3.fillInStackTrace();
                throw var3;
            }
        }
    }

    public Object getObject(int var1, Map var2) throws SQLException {
        synchronized(this.connection) {
            SQLException var4;
            if (this.closed) {
                var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 10, "getObject");
                var4.fillInStackTrace();
                throw var4;
            } else if (this.statement.closed) {
                var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9, "getObject");
                var4.fillInStackTrace();
                throw var4;
            } else if (var1 >= 1 && var1 <= this.statement.getNumberOfColumns()) {
                if (this.currentRow < 0) {
                    var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 14);
                    var4.fillInStackTrace();
                    throw var4;
                } else if (this.currentRow == this.fetchedRowCount) {
                    var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 289);
                    var4.fillInStackTrace();
                    throw var4;
                } else {
                    return this.statement.getObject(this.currentRow, var1, var2);
                }
            } else {
                var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 3);
                var4.fillInStackTrace();
                throw var4;
            }
        }
    }

    public Ref getRef(int var1) throws SQLException {
        return this.getREF(var1);
    }

    public RowId getRowId(int var1) throws SQLException {
        return this.getROWID(var1);
    }

    public short getShort(int var1) throws SQLException {
        synchronized(this.connection) {
            SQLException var3;
            if (this.closed) {
                var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 10, "getShort");
                var3.fillInStackTrace();
                throw var3;
            } else if (this.statement.closed) {
                var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9, "getShort");
                var3.fillInStackTrace();
                throw var3;
            } else if (var1 >= 1 && var1 <= this.statement.getNumberOfColumns()) {
                if (this.currentRow < 0) {
                    var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 14);
                    var3.fillInStackTrace();
                    throw var3;
                } else if (this.currentRow == this.fetchedRowCount) {
                    var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 289);
                    var3.fillInStackTrace();
                    throw var3;
                } else {
                    return this.statement.getShort(this.currentRow, var1);
                }
            } else {
                var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 3);
                var3.fillInStackTrace();
                throw var3;
            }
        }
    }

    public SQLXML getSQLXML(int var1) throws SQLException {
        synchronized(this.connection) {
            SQLException var3;
            if (this.closed) {
                var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 10, "getSQLXML");
                var3.fillInStackTrace();
                throw var3;
            } else if (this.statement.closed) {
                var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9, "getSQLXML");
                var3.fillInStackTrace();
                throw var3;
            } else if (var1 >= 1 && var1 <= this.statement.getNumberOfColumns()) {
                if (this.currentRow < 0) {
                    var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 14);
                    var3.fillInStackTrace();
                    throw var3;
                } else if (this.currentRow == this.fetchedRowCount) {
                    var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 289);
                    var3.fillInStackTrace();
                    throw var3;
                } else {
                    return this.statement.getSQLXML(this.currentRow, var1);
                }
            } else {
                var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 3);
                var3.fillInStackTrace();
                throw var3;
            }
        }
    }

    public String getString(int var1) throws SQLException {
        synchronized(this.connection) {
            SQLException var3;
            if (this.closed) {
                var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 10, "getString");
                var3.fillInStackTrace();
                throw var3;
            } else if (this.statement.closed) {
                var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9, "getString");
                var3.fillInStackTrace();
                throw var3;
            } else if (var1 >= 1 && var1 <= this.statement.getNumberOfColumns()) {
                if (this.currentRow < 0) {
                    var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 14);
                    var3.fillInStackTrace();
                    throw var3;
                } else if (this.currentRow == this.fetchedRowCount) {
                    var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 289);
                    var3.fillInStackTrace();
                    throw var3;
                } else {
                    return this.statement.getString(this.currentRow, var1);
                }
            } else {
                var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 3);
                var3.fillInStackTrace();
                throw var3;
            }
        }
    }

    public Time getTime(int var1) throws SQLException {
        synchronized(this.connection) {
            SQLException var3;
            if (this.closed) {
                var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 10, "getTime");
                var3.fillInStackTrace();
                throw var3;
            } else if (this.statement.closed) {
                var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9, "getTime");
                var3.fillInStackTrace();
                throw var3;
            } else if (var1 >= 1 && var1 <= this.statement.getNumberOfColumns()) {
                if (this.currentRow < 0) {
                    var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 14);
                    var3.fillInStackTrace();
                    throw var3;
                } else if (this.currentRow == this.fetchedRowCount) {
                    var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 289);
                    var3.fillInStackTrace();
                    throw var3;
                } else {
                    return this.statement.getTime(this.currentRow, var1);
                }
            } else {
                var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 3);
                var3.fillInStackTrace();
                throw var3;
            }
        }
    }

    public Time getTime(int var1, Calendar var2) throws SQLException {
        synchronized(this.connection) {
            SQLException var4;
            if (this.closed) {
                var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 10, "getTime");
                var4.fillInStackTrace();
                throw var4;
            } else if (this.statement.closed) {
                var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9, "getTime");
                var4.fillInStackTrace();
                throw var4;
            } else if (var1 >= 1 && var1 <= this.statement.getNumberOfColumns()) {
                if (this.currentRow < 0) {
                    var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 14);
                    var4.fillInStackTrace();
                    throw var4;
                } else if (this.currentRow == this.fetchedRowCount) {
                    var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 289);
                    var4.fillInStackTrace();
                    throw var4;
                } else {
                    return this.statement.getTime(this.currentRow, var1, var2);
                }
            } else {
                var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 3);
                var4.fillInStackTrace();
                throw var4;
            }
        }
    }

    public Timestamp getTimestamp(int var1) throws SQLException {
        synchronized(this.connection) {
            SQLException var3;
            if (this.closed) {
                var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 10, "getTimestamp");
                var3.fillInStackTrace();
                throw var3;
            } else if (this.statement.closed) {
                var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9, "getTimestamp");
                var3.fillInStackTrace();
                throw var3;
            } else if (var1 >= 1 && var1 <= this.statement.getNumberOfColumns()) {
                if (this.currentRow < 0) {
                    var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 14);
                    var3.fillInStackTrace();
                    throw var3;
                } else if (this.currentRow == this.fetchedRowCount) {
                    var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 289);
                    var3.fillInStackTrace();
                    throw var3;
                } else {
                    return this.statement.getTimestamp(this.currentRow, var1);
                }
            } else {
                var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 3);
                var3.fillInStackTrace();
                throw var3;
            }
        }
    }

    public Timestamp getTimestamp(int var1, Calendar var2) throws SQLException {
        synchronized(this.connection) {
            SQLException var4;
            if (this.closed) {
                var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 10, "getTimestamp");
                var4.fillInStackTrace();
                throw var4;
            } else if (this.statement.closed) {
                var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9, "getTimestamp");
                var4.fillInStackTrace();
                throw var4;
            } else if (var1 >= 1 && var1 <= this.statement.getNumberOfColumns()) {
                if (this.currentRow < 0) {
                    var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 14);
                    var4.fillInStackTrace();
                    throw var4;
                } else if (this.currentRow == this.fetchedRowCount) {
                    var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 289);
                    var4.fillInStackTrace();
                    throw var4;
                } else {
                    return this.statement.getTimestamp(this.currentRow, var1, var2);
                }
            } else {
                var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 3);
                var4.fillInStackTrace();
                throw var4;
            }
        }
    }

    public URL getURL(int var1) throws SQLException {
        synchronized(this.connection) {
            SQLException var3;
            if (this.closed) {
                var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 10, "getURL");
                var3.fillInStackTrace();
                throw var3;
            } else if (this.statement.closed) {
                var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9, "getURL");
                var3.fillInStackTrace();
                throw var3;
            } else if (var1 >= 1 && var1 <= this.statement.getNumberOfColumns()) {
                if (this.currentRow < 0) {
                    var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 14);
                    var3.fillInStackTrace();
                    throw var3;
                } else if (this.currentRow == this.fetchedRowCount) {
                    var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 289);
                    var3.fillInStackTrace();
                    throw var3;
                } else {
                    return this.statement.getURL(this.currentRow, var1);
                }
            } else {
                var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 3);
                var3.fillInStackTrace();
                throw var3;
            }
        }
    }

    public ARRAY getARRAY(int var1) throws SQLException {
        synchronized(this.connection) {
            SQLException var3;
            if (this.closed) {
                var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 10, "getARRAY");
                var3.fillInStackTrace();
                throw var3;
            } else if (this.statement.closed) {
                var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9, "getARRAY");
                var3.fillInStackTrace();
                throw var3;
            } else if (var1 >= 1 && var1 <= this.statement.getNumberOfColumns()) {
                if (this.currentRow < 0) {
                    var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 14);
                    var3.fillInStackTrace();
                    throw var3;
                } else if (this.currentRow == this.fetchedRowCount) {
                    var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 289);
                    var3.fillInStackTrace();
                    throw var3;
                } else {
                    return this.statement.getARRAY(this.currentRow, var1);
                }
            } else {
                var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 3);
                var3.fillInStackTrace();
                throw var3;
            }
        }
    }

    public BFILE getBFILE(int var1) throws SQLException {
        synchronized(this.connection) {
            SQLException var3;
            if (this.closed) {
                var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 10, "getBFILE");
                var3.fillInStackTrace();
                throw var3;
            } else if (this.statement.closed) {
                var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9, "getBFILE");
                var3.fillInStackTrace();
                throw var3;
            } else if (var1 >= 1 && var1 <= this.statement.getNumberOfColumns()) {
                if (this.currentRow < 0) {
                    var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 14);
                    var3.fillInStackTrace();
                    throw var3;
                } else if (this.currentRow == this.fetchedRowCount) {
                    var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 289);
                    var3.fillInStackTrace();
                    throw var3;
                } else {
                    return this.statement.getBFILE(this.currentRow, var1);
                }
            } else {
                var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 3);
                var3.fillInStackTrace();
                throw var3;
            }
        }
    }

    public BFILE getBfile(int var1) throws SQLException {
        return this.getBFILE(var1);
    }

    public BLOB getBLOB(int var1) throws SQLException {
        synchronized(this.connection) {
            SQLException var3;
            if (this.closed) {
                var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 10, "getBLOB");
                var3.fillInStackTrace();
                throw var3;
            } else if (this.statement.closed) {
                var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9, "getBLOB");
                var3.fillInStackTrace();
                throw var3;
            } else if (var1 >= 1 && var1 <= this.statement.getNumberOfColumns()) {
                if (this.currentRow < 0) {
                    var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 14);
                    var3.fillInStackTrace();
                    throw var3;
                } else if (this.currentRow == this.fetchedRowCount) {
                    var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 289);
                    var3.fillInStackTrace();
                    throw var3;
                } else {
                    return this.statement.getBLOB(this.currentRow, var1);
                }
            } else {
                var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 3);
                var3.fillInStackTrace();
                throw var3;
            }
        }
    }

    public CHAR getCHAR(int var1) throws SQLException {
        synchronized(this.connection) {
            SQLException var3;
            if (this.closed) {
                var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 10, "getCHAR");
                var3.fillInStackTrace();
                throw var3;
            } else if (this.statement.closed) {
                var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9, "getCHAR");
                var3.fillInStackTrace();
                throw var3;
            } else if (var1 >= 1 && var1 <= this.statement.getNumberOfColumns()) {
                if (this.currentRow < 0) {
                    var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 14);
                    var3.fillInStackTrace();
                    throw var3;
                } else if (this.currentRow == this.fetchedRowCount) {
                    var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 289);
                    var3.fillInStackTrace();
                    throw var3;
                } else {
                    return this.statement.getCHAR(this.currentRow, var1);
                }
            } else {
                var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 3);
                var3.fillInStackTrace();
                throw var3;
            }
        }
    }

    public CLOB getCLOB(int var1) throws SQLException {
        synchronized(this.connection) {
            SQLException var3;
            if (this.closed) {
                var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 10, "getCLOB");
                var3.fillInStackTrace();
                throw var3;
            } else if (this.statement.closed) {
                var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9, "getCLOB");
                var3.fillInStackTrace();
                throw var3;
            } else if (var1 >= 1 && var1 <= this.statement.getNumberOfColumns()) {
                if (this.currentRow < 0) {
                    var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 14);
                    var3.fillInStackTrace();
                    throw var3;
                } else if (this.currentRow == this.fetchedRowCount) {
                    var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 289);
                    var3.fillInStackTrace();
                    throw var3;
                } else {
                    return this.statement.getCLOB(this.currentRow, var1);
                }
            } else {
                var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 3);
                var3.fillInStackTrace();
                throw var3;
            }
        }
    }

    public ResultSet getCursor(int var1) throws SQLException {
        synchronized(this.connection) {
            SQLException var3;
            if (this.closed) {
                var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 10, "getCursor");
                var3.fillInStackTrace();
                throw var3;
            } else if (this.statement.closed) {
                var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9, "getCursor");
                var3.fillInStackTrace();
                throw var3;
            } else if (var1 >= 1 && var1 <= this.statement.getNumberOfColumns()) {
                if (this.currentRow < 0) {
                    var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 14);
                    var3.fillInStackTrace();
                    throw var3;
                } else if (this.currentRow == this.fetchedRowCount) {
                    var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 289);
                    var3.fillInStackTrace();
                    throw var3;
                } else {
                    return this.statement.getCursor(this.currentRow, var1);
                }
            } else {
                var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 3);
                var3.fillInStackTrace();
                throw var3;
            }
        }
    }

    public DATE getDATE(int var1) throws SQLException {
        synchronized(this.connection) {
            SQLException var3;
            if (this.closed) {
                var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 10, "getDATE");
                var3.fillInStackTrace();
                throw var3;
            } else if (this.statement.closed) {
                var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9, "getDATE");
                var3.fillInStackTrace();
                throw var3;
            } else if (var1 >= 1 && var1 <= this.statement.getNumberOfColumns()) {
                if (this.currentRow < 0) {
                    var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 14);
                    var3.fillInStackTrace();
                    throw var3;
                } else if (this.currentRow == this.fetchedRowCount) {
                    var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 289);
                    var3.fillInStackTrace();
                    throw var3;
                } else {
                    return this.statement.getDATE(this.currentRow, var1);
                }
            } else {
                var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 3);
                var3.fillInStackTrace();
                throw var3;
            }
        }
    }

    public INTERVALDS getINTERVALDS(int var1) throws SQLException {
        synchronized(this.connection) {
            SQLException var3;
            if (this.closed) {
                var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 10, "getINTERVALDS");
                var3.fillInStackTrace();
                throw var3;
            } else if (this.statement.closed) {
                var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9, "getINTERVALDS");
                var3.fillInStackTrace();
                throw var3;
            } else if (var1 >= 1 && var1 <= this.statement.getNumberOfColumns()) {
                if (this.currentRow < 0) {
                    var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 14);
                    var3.fillInStackTrace();
                    throw var3;
                } else if (this.currentRow == this.fetchedRowCount) {
                    var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 289);
                    var3.fillInStackTrace();
                    throw var3;
                } else {
                    return this.statement.getINTERVALDS(this.currentRow, var1);
                }
            } else {
                var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 3);
                var3.fillInStackTrace();
                throw var3;
            }
        }
    }

    public INTERVALYM getINTERVALYM(int var1) throws SQLException {
        synchronized(this.connection) {
            SQLException var3;
            if (this.closed) {
                var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 10, "getINTERVALYM");
                var3.fillInStackTrace();
                throw var3;
            } else if (this.statement.closed) {
                var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9, "getINTERVALYM");
                var3.fillInStackTrace();
                throw var3;
            } else if (var1 >= 1 && var1 <= this.statement.getNumberOfColumns()) {
                if (this.currentRow < 0) {
                    var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 14);
                    var3.fillInStackTrace();
                    throw var3;
                } else if (this.currentRow == this.fetchedRowCount) {
                    var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 289);
                    var3.fillInStackTrace();
                    throw var3;
                } else {
                    return this.statement.getINTERVALYM(this.currentRow, var1);
                }
            } else {
                var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 3);
                var3.fillInStackTrace();
                throw var3;
            }
        }
    }

    public NUMBER getNUMBER(int var1) throws SQLException {
        synchronized(this.connection) {
            SQLException var3;
            if (this.closed) {
                var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 10, "getNUMBER");
                var3.fillInStackTrace();
                throw var3;
            } else if (this.statement.closed) {
                var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9, "getNUMBER");
                var3.fillInStackTrace();
                throw var3;
            } else if (var1 >= 1 && var1 <= this.statement.getNumberOfColumns()) {
                if (this.currentRow < 0) {
                    var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 14);
                    var3.fillInStackTrace();
                    throw var3;
                } else if (this.currentRow == this.fetchedRowCount) {
                    var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 289);
                    var3.fillInStackTrace();
                    throw var3;
                } else {
                    return this.statement.getNUMBER(this.currentRow, var1);
                }
            } else {
                var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 3);
                var3.fillInStackTrace();
                throw var3;
            }
        }
    }

    public OPAQUE getOPAQUE(int var1) throws SQLException {
        synchronized(this.connection) {
            SQLException var3;
            if (this.closed) {
                var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 10, "getOPAQUE");
                var3.fillInStackTrace();
                throw var3;
            } else if (this.statement.closed) {
                var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9, "getOPAQUE");
                var3.fillInStackTrace();
                throw var3;
            } else if (var1 >= 1 && var1 <= this.statement.getNumberOfColumns()) {
                if (this.currentRow < 0) {
                    var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 14);
                    var3.fillInStackTrace();
                    throw var3;
                } else if (this.currentRow == this.fetchedRowCount) {
                    var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 289);
                    var3.fillInStackTrace();
                    throw var3;
                } else {
                    return this.statement.getOPAQUE(this.currentRow, var1);
                }
            } else {
                var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 3);
                var3.fillInStackTrace();
                throw var3;
            }
        }
    }

    public Datum getOracleObject(int var1) throws SQLException {
        synchronized(this.connection) {
            SQLException var3;
            if (this.closed) {
                var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 10, "getOracleObject");
                var3.fillInStackTrace();
                throw var3;
            } else if (this.statement.closed) {
                var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9, "getOracleObject");
                var3.fillInStackTrace();
                throw var3;
            } else if (var1 >= 1 && var1 <= this.statement.getNumberOfColumns()) {
                if (this.currentRow < 0) {
                    var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 14);
                    var3.fillInStackTrace();
                    throw var3;
                } else if (this.currentRow == this.fetchedRowCount) {
                    var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 289);
                    var3.fillInStackTrace();
                    throw var3;
                } else {
                    return this.statement.getOracleObject(this.currentRow, var1);
                }
            } else {
                var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 3);
                var3.fillInStackTrace();
                throw var3;
            }
        }
    }

    public ORAData getORAData(int var1, ORADataFactory var2) throws SQLException {
        synchronized(this.connection) {
            SQLException var4;
            if (this.closed) {
                var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 10, "getORAData");
                var4.fillInStackTrace();
                throw var4;
            } else if (this.statement.closed) {
                var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9, "getORAData");
                var4.fillInStackTrace();
                throw var4;
            } else if (var1 >= 1 && var1 <= this.statement.getNumberOfColumns()) {
                if (this.currentRow < 0) {
                    var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 14);
                    var4.fillInStackTrace();
                    throw var4;
                } else if (this.currentRow == this.fetchedRowCount) {
                    var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 289);
                    var4.fillInStackTrace();
                    throw var4;
                } else {
                    return this.statement.getORAData(this.currentRow, var1, var2);
                }
            } else {
                var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 3);
                var4.fillInStackTrace();
                throw var4;
            }
        }
    }

    public Object getObject(int var1, OracleDataFactory var2) throws SQLException {
        synchronized(this.connection) {
            SQLException var4;
            if (this.closed) {
                var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 10, "getObject");
                var4.fillInStackTrace();
                throw var4;
            } else if (this.statement.closed) {
                var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9, "getObject");
                var4.fillInStackTrace();
                throw var4;
            } else if (var1 >= 1 && var1 <= this.statement.getNumberOfColumns()) {
                if (this.currentRow < 0) {
                    var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 14);
                    var4.fillInStackTrace();
                    throw var4;
                } else if (this.currentRow == this.fetchedRowCount) {
                    var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 289);
                    var4.fillInStackTrace();
                    throw var4;
                } else {
                    return this.statement.getObject(this.currentRow, var1, var2);
                }
            } else {
                var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 3);
                var4.fillInStackTrace();
                throw var4;
            }
        }
    }

    public RAW getRAW(int var1) throws SQLException {
        synchronized(this.connection) {
            SQLException var3;
            if (this.closed) {
                var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 10, "getRAW");
                var3.fillInStackTrace();
                throw var3;
            } else if (this.statement.closed) {
                var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9, "getRAW");
                var3.fillInStackTrace();
                throw var3;
            } else if (var1 >= 1 && var1 <= this.statement.getNumberOfColumns()) {
                if (this.currentRow < 0) {
                    var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 14);
                    var3.fillInStackTrace();
                    throw var3;
                } else if (this.currentRow == this.fetchedRowCount) {
                    var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 289);
                    var3.fillInStackTrace();
                    throw var3;
                } else {
                    return this.statement.getRAW(this.currentRow, var1);
                }
            } else {
                var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 3);
                var3.fillInStackTrace();
                throw var3;
            }
        }
    }

    public REF getREF(int var1) throws SQLException {
        synchronized(this.connection) {
            SQLException var3;
            if (this.closed) {
                var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 10, "getREF");
                var3.fillInStackTrace();
                throw var3;
            } else if (this.statement.closed) {
                var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9, "getREF");
                var3.fillInStackTrace();
                throw var3;
            } else if (var1 >= 1 && var1 <= this.statement.getNumberOfColumns()) {
                if (this.currentRow < 0) {
                    var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 14);
                    var3.fillInStackTrace();
                    throw var3;
                } else if (this.currentRow == this.fetchedRowCount) {
                    var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 289);
                    var3.fillInStackTrace();
                    throw var3;
                } else {
                    return this.statement.getREF(this.currentRow, var1);
                }
            } else {
                var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 3);
                var3.fillInStackTrace();
                throw var3;
            }
        }
    }

    public ROWID getROWID(int var1) throws SQLException {
        synchronized(this.connection) {
            SQLException var3;
            if (this.closed) {
                var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 10, "getROWID");
                var3.fillInStackTrace();
                throw var3;
            } else if (this.statement.closed) {
                var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9, "getROWID");
                var3.fillInStackTrace();
                throw var3;
            } else if (var1 >= 1 && var1 <= this.statement.getNumberOfColumns()) {
                if (this.currentRow < 0) {
                    var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 14);
                    var3.fillInStackTrace();
                    throw var3;
                } else if (this.currentRow == this.fetchedRowCount) {
                    var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 289);
                    var3.fillInStackTrace();
                    throw var3;
                } else {
                    return this.statement.getROWID(this.currentRow, var1);
                }
            } else {
                var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 3);
                var3.fillInStackTrace();
                throw var3;
            }
        }
    }

    public STRUCT getSTRUCT(int var1) throws SQLException {
        synchronized(this.connection) {
            SQLException var3;
            if (this.closed) {
                var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 10, "getSTRUCT");
                var3.fillInStackTrace();
                throw var3;
            } else if (this.statement.closed) {
                var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9, "getSTRUCT");
                var3.fillInStackTrace();
                throw var3;
            } else if (var1 >= 1 && var1 <= this.statement.getNumberOfColumns()) {
                if (this.currentRow < 0) {
                    var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 14);
                    var3.fillInStackTrace();
                    throw var3;
                } else if (this.currentRow == this.fetchedRowCount) {
                    var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 289);
                    var3.fillInStackTrace();
                    throw var3;
                } else {
                    return this.statement.getSTRUCT(this.currentRow, var1);
                }
            } else {
                var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 3);
                var3.fillInStackTrace();
                throw var3;
            }
        }
    }

    public TIMESTAMPLTZ getTIMESTAMPLTZ(int var1) throws SQLException {
        synchronized(this.connection) {
            SQLException var3;
            if (this.closed) {
                var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 10, "getTIMESTAMPLTZ");
                var3.fillInStackTrace();
                throw var3;
            } else if (this.statement.closed) {
                var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9, "getTIMESTAMPLTZ");
                var3.fillInStackTrace();
                throw var3;
            } else if (var1 >= 1 && var1 <= this.statement.getNumberOfColumns()) {
                if (this.currentRow < 0) {
                    var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 14);
                    var3.fillInStackTrace();
                    throw var3;
                } else if (this.currentRow == this.fetchedRowCount) {
                    var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 289);
                    var3.fillInStackTrace();
                    throw var3;
                } else {
                    return this.statement.getTIMESTAMPLTZ(this.currentRow, var1);
                }
            } else {
                var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 3);
                var3.fillInStackTrace();
                throw var3;
            }
        }
    }

    public TIMESTAMPTZ getTIMESTAMPTZ(int var1) throws SQLException {
        synchronized(this.connection) {
            SQLException var3;
            if (this.closed) {
                var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 10, "getTIMESTAMPTZ");
                var3.fillInStackTrace();
                throw var3;
            } else if (this.statement.closed) {
                var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9, "getTIMESTAMPTZ");
                var3.fillInStackTrace();
                throw var3;
            } else if (var1 >= 1 && var1 <= this.statement.getNumberOfColumns()) {
                if (this.currentRow < 0) {
                    var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 14);
                    var3.fillInStackTrace();
                    throw var3;
                } else if (this.currentRow == this.fetchedRowCount) {
                    var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 289);
                    var3.fillInStackTrace();
                    throw var3;
                } else {
                    return this.statement.getTIMESTAMPTZ(this.currentRow, var1);
                }
            } else {
                var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 3);
                var3.fillInStackTrace();
                throw var3;
            }
        }
    }

    public TIMESTAMP getTIMESTAMP(int var1) throws SQLException {
        synchronized(this.connection) {
            SQLException var3;
            if (this.closed) {
                var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 10, "getTIMESTAMP");
                var3.fillInStackTrace();
                throw var3;
            } else if (this.statement.closed) {
                var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9, "getTIMESTAMP");
                var3.fillInStackTrace();
                throw var3;
            } else if (var1 >= 1 && var1 <= this.statement.getNumberOfColumns()) {
                if (this.currentRow < 0) {
                    var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 14);
                    var3.fillInStackTrace();
                    throw var3;
                } else if (this.currentRow == this.fetchedRowCount) {
                    var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 289);
                    var3.fillInStackTrace();
                    throw var3;
                } else {
                    return this.statement.getTIMESTAMP(this.currentRow, var1);
                }
            } else {
                var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 3);
                var3.fillInStackTrace();
                throw var3;
            }
        }
    }

    public CustomDatum getCustomDatum(int var1, CustomDatumFactory var2) throws SQLException {
        synchronized(this.connection) {
            SQLException var4;
            if (this.closed) {
                var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 10, "getCustomDatum");
                var4.fillInStackTrace();
                throw var4;
            } else if (this.statement.closed) {
                var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9, "getCustomDatum");
                var4.fillInStackTrace();
                throw var4;
            } else if (var1 >= 1 && var1 <= this.statement.getNumberOfColumns()) {
                if (this.currentRow < 0) {
                    var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 14);
                    var4.fillInStackTrace();
                    throw var4;
                } else if (this.currentRow == this.fetchedRowCount) {
                    var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 289);
                    var4.fillInStackTrace();
                    throw var4;
                } else {
                    return this.statement.getCustomDatum(this.currentRow, var1, var2);
                }
            } else {
                var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 3);
                var4.fillInStackTrace();
                throw var4;
            }
        }
    }

    public InputStream getAsciiStream(int var1) throws SQLException {
        synchronized(this.connection) {
            SQLException var3;
            if (this.closed) {
                var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 10, "getAsciiStream");
                var3.fillInStackTrace();
                throw var3;
            } else if (this.statement.closed) {
                var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9, "getAsciiStream");
                var3.fillInStackTrace();
                throw var3;
            } else if (var1 >= 1 && var1 <= this.statement.getNumberOfColumns()) {
                if (this.currentRow < 0) {
                    var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 14);
                    var3.fillInStackTrace();
                    throw var3;
                } else if (this.currentRow == this.fetchedRowCount) {
                    var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 289);
                    var3.fillInStackTrace();
                    throw var3;
                } else {
                    return this.statement.getAsciiStream(this.currentRow, var1);
                }
            } else {
                var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 3);
                var3.fillInStackTrace();
                throw var3;
            }
        }
    }

    public InputStream getBinaryStream(int var1) throws SQLException {
        synchronized(this.connection) {
            SQLException var3;
            if (this.closed) {
                var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 10, "getBinaryStream");
                var3.fillInStackTrace();
                throw var3;
            } else if (this.statement.closed) {
                var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9, "getBinaryStream");
                var3.fillInStackTrace();
                throw var3;
            } else if (var1 >= 1 && var1 <= this.statement.getNumberOfColumns()) {
                if (this.currentRow < 0) {
                    var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 14);
                    var3.fillInStackTrace();
                    throw var3;
                } else if (this.currentRow == this.fetchedRowCount) {
                    var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 289);
                    var3.fillInStackTrace();
                    throw var3;
                } else {
                    return this.statement.getBinaryStream(this.currentRow, var1);
                }
            } else {
                var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 3);
                var3.fillInStackTrace();
                throw var3;
            }
        }
    }

    public Reader getCharacterStream(int var1) throws SQLException {
        synchronized(this.connection) {
            SQLException var3;
            if (this.closed) {
                var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 10, "getCharacterStream");
                var3.fillInStackTrace();
                throw var3;
            } else if (this.statement.closed) {
                var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9, "getCharacterStream");
                var3.fillInStackTrace();
                throw var3;
            } else if (var1 >= 1 && var1 <= this.statement.getNumberOfColumns()) {
                if (this.currentRow < 0) {
                    var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 14);
                    var3.fillInStackTrace();
                    throw var3;
                } else if (this.currentRow == this.fetchedRowCount) {
                    var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 289);
                    var3.fillInStackTrace();
                    throw var3;
                } else {
                    return this.statement.getCharacterStream(this.currentRow, var1);
                }
            } else {
                var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 3);
                var3.fillInStackTrace();
                throw var3;
            }
        }
    }

    public Reader getNCharacterStream(int var1) throws SQLException {
        synchronized(this.connection) {
            SQLException var3;
            if (this.closed) {
                var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 10, "getNCharacterStream");
                var3.fillInStackTrace();
                throw var3;
            } else if (this.statement.closed) {
                var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9, "getNCharacterStream");
                var3.fillInStackTrace();
                throw var3;
            } else if (var1 >= 1 && var1 <= this.statement.getNumberOfColumns()) {
                if (this.currentRow < 0) {
                    var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 14);
                    var3.fillInStackTrace();
                    throw var3;
                } else if (this.currentRow == this.fetchedRowCount) {
                    var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 289);
                    var3.fillInStackTrace();
                    throw var3;
                } else {
                    return this.statement.getNCharacterStream(this.currentRow, var1);
                }
            } else {
                var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 3);
                var3.fillInStackTrace();
                throw var3;
            }
        }
    }

    public InputStream getUnicodeStream(int var1) throws SQLException {
        synchronized(this.connection) {
            SQLException var3;
            if (this.closed) {
                var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 10, "getUnicodeStream");
                var3.fillInStackTrace();
                throw var3;
            } else if (this.statement.closed) {
                var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 9, "getUnicodeStream");
                var3.fillInStackTrace();
                throw var3;
            } else if (var1 >= 1 && var1 <= this.statement.getNumberOfColumns()) {
                if (this.currentRow < 0) {
                    var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 14);
                    var3.fillInStackTrace();
                    throw var3;
                } else if (this.currentRow == this.fetchedRowCount) {
                    var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 289);
                    var3.fillInStackTrace();
                    throw var3;
                } else {
                    return this.statement.getUnicodeStream(this.currentRow, var1);
                }
            } else {
                var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 3);
                var3.fillInStackTrace();
                throw var3;
            }
        }
    }

    protected OracleConnection getConnectionDuringExceptionHandling() {
        return this.connection;
    }
}
