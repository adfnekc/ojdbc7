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

abstract class GeneratedStatement {
    PhysicalConnection connection;
    Accessor[] accessors = null;
    int lastIndex = -1;
    OracleInputStream streamList;
    protected int indexOfFirstRow = 0;
    protected int offsetOfFirstUserColumn = -1;
    private static final String _Copyright_2007_Oracle_All_Rights_Reserved_ = null;
    public static final String BUILD_DATE = "Thu_Apr_04_15:09:24_PDT_2013";
    public static final boolean TRACE = false;

    protected GeneratedStatement(PhysicalConnection var1) {
        this.connection = var1;
    }

    abstract void closeUsedStreams(int var1) throws SQLException;

    Array getArray(int var1, int var2) throws SQLException {
        synchronized(this.connection) {
            this.lastIndex = var2;
            if (this.streamList != null) {
                this.closeUsedStreams(var2);
            }

            return this.accessors[var2 + this.offsetOfFirstUserColumn].getArray(var1 - this.indexOfFirstRow);
        }
    }

    BigDecimal getBigDecimal(int var1, int var2) throws SQLException {
        synchronized(this.connection) {
            this.lastIndex = var2;
            if (this.streamList != null) {
                this.closeUsedStreams(var2);
            }

            return this.accessors[var2 + this.offsetOfFirstUserColumn].getBigDecimal(var1 - this.indexOfFirstRow);
        }
    }

    BigDecimal getBigDecimal(int var1, int var2, int var3) throws SQLException {
        synchronized(this.connection) {
            this.lastIndex = var2;
            if (this.streamList != null) {
                this.closeUsedStreams(var2);
            }

            return this.accessors[var2 + this.offsetOfFirstUserColumn].getBigDecimal(var1 - this.indexOfFirstRow, var3);
        }
    }

    Blob getBlob(int var1, int var2) throws SQLException {
        synchronized(this.connection) {
            this.lastIndex = var2;
            if (this.streamList != null) {
                this.closeUsedStreams(var2);
            }

            return this.accessors[var2 + this.offsetOfFirstUserColumn].getBlob(var1 - this.indexOfFirstRow);
        }
    }

    boolean getBoolean(int var1, int var2) throws SQLException {
        synchronized(this.connection) {
            this.lastIndex = var2;
            if (this.streamList != null) {
                this.closeUsedStreams(var2);
            }

            return this.accessors[var2 + this.offsetOfFirstUserColumn].getBoolean(var1 - this.indexOfFirstRow);
        }
    }

    byte getByte(int var1, int var2) throws SQLException {
        synchronized(this.connection) {
            this.lastIndex = var2;
            if (this.streamList != null) {
                this.closeUsedStreams(var2);
            }

            return this.accessors[var2 + this.offsetOfFirstUserColumn].getByte(var1 - this.indexOfFirstRow);
        }
    }

    byte[] getBytes(int var1, int var2) throws SQLException {
        synchronized(this.connection) {
            this.lastIndex = var2;
            if (this.streamList != null) {
                this.closeUsedStreams(var2);
            }

            return this.accessors[var2 + this.offsetOfFirstUserColumn].getBytes(var1 - this.indexOfFirstRow);
        }
    }

    Clob getClob(int var1, int var2) throws SQLException {
        synchronized(this.connection) {
            this.lastIndex = var2;
            if (this.streamList != null) {
                this.closeUsedStreams(var2);
            }

            return this.accessors[var2 + this.offsetOfFirstUserColumn].getClob(var1 - this.indexOfFirstRow);
        }
    }

    Date getDate(int var1, int var2) throws SQLException {
        synchronized(this.connection) {
            this.lastIndex = var2;
            if (this.streamList != null) {
                this.closeUsedStreams(var2);
            }

            return this.accessors[var2 + this.offsetOfFirstUserColumn].getDate(var1 - this.indexOfFirstRow);
        }
    }

    Date getDate(int var1, int var2, Calendar var3) throws SQLException {
        synchronized(this.connection) {
            this.lastIndex = var2;
            if (this.streamList != null) {
                this.closeUsedStreams(var2);
            }

            return this.accessors[var2 + this.offsetOfFirstUserColumn].getDate(var1 - this.indexOfFirstRow, var3);
        }
    }

    double getDouble(int var1, int var2) throws SQLException {
        synchronized(this.connection) {
            this.lastIndex = var2;
            if (this.streamList != null) {
                this.closeUsedStreams(var2);
            }

            return this.accessors[var2 + this.offsetOfFirstUserColumn].getDouble(var1 - this.indexOfFirstRow);
        }
    }

    float getFloat(int var1, int var2) throws SQLException {
        synchronized(this.connection) {
            this.lastIndex = var2;
            if (this.streamList != null) {
                this.closeUsedStreams(var2);
            }

            return this.accessors[var2 + this.offsetOfFirstUserColumn].getFloat(var1 - this.indexOfFirstRow);
        }
    }

    int getInt(int var1, int var2) throws SQLException {
        synchronized(this.connection) {
            this.lastIndex = var2;
            if (this.streamList != null) {
                this.closeUsedStreams(var2);
            }

            return this.accessors[var2 + this.offsetOfFirstUserColumn].getInt(var1 - this.indexOfFirstRow);
        }
    }

    long getLong(int var1, int var2) throws SQLException {
        synchronized(this.connection) {
            this.lastIndex = var2;
            if (this.streamList != null) {
                this.closeUsedStreams(var2);
            }

            return this.accessors[var2 + this.offsetOfFirstUserColumn].getLong(var1 - this.indexOfFirstRow);
        }
    }

    NClob getNClob(int var1, int var2) throws SQLException {
        synchronized(this.connection) {
            this.lastIndex = var2;
            if (this.streamList != null) {
                this.closeUsedStreams(var2);
            }

            return this.accessors[var2 + this.offsetOfFirstUserColumn].getNClob(var1 - this.indexOfFirstRow);
        }
    }

    String getNString(int var1, int var2) throws SQLException {
        synchronized(this.connection) {
            this.lastIndex = var2;
            if (this.streamList != null) {
                this.closeUsedStreams(var2);
            }

            return this.accessors[var2 + this.offsetOfFirstUserColumn].getNString(var1 - this.indexOfFirstRow);
        }
    }

    Object getObject(int var1, int var2) throws SQLException {
        synchronized(this.connection) {
            this.lastIndex = var2;
            if (this.streamList != null) {
                this.closeUsedStreams(var2);
            }

            return this.accessors[var2 + this.offsetOfFirstUserColumn].getObject(var1 - this.indexOfFirstRow);
        }
    }

    Object getObject(int var1, int var2, Map var3) throws SQLException {
        synchronized(this.connection) {
            this.lastIndex = var2;
            if (this.streamList != null) {
                this.closeUsedStreams(var2);
            }

            return this.accessors[var2 + this.offsetOfFirstUserColumn].getObject(var1 - this.indexOfFirstRow, var3);
        }
    }

    Ref getRef(int var1, int var2) throws SQLException {
        synchronized(this.connection) {
            this.lastIndex = var2;
            if (this.streamList != null) {
                this.closeUsedStreams(var2);
            }

            return this.accessors[var2 + this.offsetOfFirstUserColumn].getRef(var1 - this.indexOfFirstRow);
        }
    }

    RowId getRowId(int var1, int var2) throws SQLException {
        synchronized(this.connection) {
            this.lastIndex = var2;
            if (this.streamList != null) {
                this.closeUsedStreams(var2);
            }

            return this.accessors[var2 + this.offsetOfFirstUserColumn].getRowId(var1 - this.indexOfFirstRow);
        }
    }

    short getShort(int var1, int var2) throws SQLException {
        synchronized(this.connection) {
            this.lastIndex = var2;
            if (this.streamList != null) {
                this.closeUsedStreams(var2);
            }

            return this.accessors[var2 + this.offsetOfFirstUserColumn].getShort(var1 - this.indexOfFirstRow);
        }
    }

    SQLXML getSQLXML(int var1, int var2) throws SQLException {
        synchronized(this.connection) {
            this.lastIndex = var2;
            if (this.streamList != null) {
                this.closeUsedStreams(var2);
            }

            return this.accessors[var2 + this.offsetOfFirstUserColumn].getSQLXML(var1 - this.indexOfFirstRow);
        }
    }

    String getString(int var1, int var2) throws SQLException {
        synchronized(this.connection) {
            this.lastIndex = var2;
            if (this.streamList != null) {
                this.closeUsedStreams(var2);
            }

            return this.accessors[var2 + this.offsetOfFirstUserColumn].getString(var1 - this.indexOfFirstRow);
        }
    }

    Time getTime(int var1, int var2) throws SQLException {
        synchronized(this.connection) {
            this.lastIndex = var2;
            if (this.streamList != null) {
                this.closeUsedStreams(var2);
            }

            return this.accessors[var2 + this.offsetOfFirstUserColumn].getTime(var1 - this.indexOfFirstRow);
        }
    }

    Time getTime(int var1, int var2, Calendar var3) throws SQLException {
        synchronized(this.connection) {
            this.lastIndex = var2;
            if (this.streamList != null) {
                this.closeUsedStreams(var2);
            }

            return this.accessors[var2 + this.offsetOfFirstUserColumn].getTime(var1 - this.indexOfFirstRow, var3);
        }
    }

    Timestamp getTimestamp(int var1, int var2) throws SQLException {
        synchronized(this.connection) {
            this.lastIndex = var2;
            if (this.streamList != null) {
                this.closeUsedStreams(var2);
            }

            return this.accessors[var2 + this.offsetOfFirstUserColumn].getTimestamp(var1 - this.indexOfFirstRow);
        }
    }

    Timestamp getTimestamp(int var1, int var2, Calendar var3) throws SQLException {
        synchronized(this.connection) {
            this.lastIndex = var2;
            if (this.streamList != null) {
                this.closeUsedStreams(var2);
            }

            return this.accessors[var2 + this.offsetOfFirstUserColumn].getTimestamp(var1 - this.indexOfFirstRow, var3);
        }
    }

    URL getURL(int var1, int var2) throws SQLException {
        synchronized(this.connection) {
            this.lastIndex = var2;
            if (this.streamList != null) {
                this.closeUsedStreams(var2);
            }

            return this.accessors[var2 + this.offsetOfFirstUserColumn].getURL(var1 - this.indexOfFirstRow);
        }
    }

    ARRAY getARRAY(int var1, int var2) throws SQLException {
        synchronized(this.connection) {
            this.lastIndex = var2;
            if (this.streamList != null) {
                this.closeUsedStreams(var2);
            }

            return this.accessors[var2 + this.offsetOfFirstUserColumn].getARRAY(var1 - this.indexOfFirstRow);
        }
    }

    BFILE getBFILE(int var1, int var2) throws SQLException {
        synchronized(this.connection) {
            this.lastIndex = var2;
            if (this.streamList != null) {
                this.closeUsedStreams(var2);
            }

            return this.accessors[var2 + this.offsetOfFirstUserColumn].getBFILE(var1 - this.indexOfFirstRow);
        }
    }

    BFILE getBfile(int var1, int var2) throws SQLException {
        synchronized(this.connection) {
            this.lastIndex = var2;
            if (this.streamList != null) {
                this.closeUsedStreams(var2);
            }

            return this.accessors[var2 + this.offsetOfFirstUserColumn].getBfile(var1 - this.indexOfFirstRow);
        }
    }

    BLOB getBLOB(int var1, int var2) throws SQLException {
        synchronized(this.connection) {
            this.lastIndex = var2;
            if (this.streamList != null) {
                this.closeUsedStreams(var2);
            }

            return this.accessors[var2 + this.offsetOfFirstUserColumn].getBLOB(var1 - this.indexOfFirstRow);
        }
    }

    CHAR getCHAR(int var1, int var2) throws SQLException {
        synchronized(this.connection) {
            this.lastIndex = var2;
            if (this.streamList != null) {
                this.closeUsedStreams(var2);
            }

            return this.accessors[var2 + this.offsetOfFirstUserColumn].getCHAR(var1 - this.indexOfFirstRow);
        }
    }

    CLOB getCLOB(int var1, int var2) throws SQLException {
        synchronized(this.connection) {
            this.lastIndex = var2;
            if (this.streamList != null) {
                this.closeUsedStreams(var2);
            }

            return this.accessors[var2 + this.offsetOfFirstUserColumn].getCLOB(var1 - this.indexOfFirstRow);
        }
    }

    ResultSet getCursor(int var1, int var2) throws SQLException {
        synchronized(this.connection) {
            this.lastIndex = var2;
            if (this.streamList != null) {
                this.closeUsedStreams(var2);
            }

            return this.accessors[var2 + this.offsetOfFirstUserColumn].getCursor(var1 - this.indexOfFirstRow);
        }
    }

    DATE getDATE(int var1, int var2) throws SQLException {
        synchronized(this.connection) {
            this.lastIndex = var2;
            if (this.streamList != null) {
                this.closeUsedStreams(var2);
            }

            return this.accessors[var2 + this.offsetOfFirstUserColumn].getDATE(var1 - this.indexOfFirstRow);
        }
    }

    INTERVALDS getINTERVALDS(int var1, int var2) throws SQLException {
        synchronized(this.connection) {
            this.lastIndex = var2;
            if (this.streamList != null) {
                this.closeUsedStreams(var2);
            }

            return this.accessors[var2 + this.offsetOfFirstUserColumn].getINTERVALDS(var1 - this.indexOfFirstRow);
        }
    }

    INTERVALYM getINTERVALYM(int var1, int var2) throws SQLException {
        synchronized(this.connection) {
            this.lastIndex = var2;
            if (this.streamList != null) {
                this.closeUsedStreams(var2);
            }

            return this.accessors[var2 + this.offsetOfFirstUserColumn].getINTERVALYM(var1 - this.indexOfFirstRow);
        }
    }

    NUMBER getNUMBER(int var1, int var2) throws SQLException {
        synchronized(this.connection) {
            this.lastIndex = var2;
            if (this.streamList != null) {
                this.closeUsedStreams(var2);
            }

            return this.accessors[var2 + this.offsetOfFirstUserColumn].getNUMBER(var1 - this.indexOfFirstRow);
        }
    }

    OPAQUE getOPAQUE(int var1, int var2) throws SQLException {
        synchronized(this.connection) {
            this.lastIndex = var2;
            if (this.streamList != null) {
                this.closeUsedStreams(var2);
            }

            return this.accessors[var2 + this.offsetOfFirstUserColumn].getOPAQUE(var1 - this.indexOfFirstRow);
        }
    }

    Datum getOracleObject(int var1, int var2) throws SQLException {
        synchronized(this.connection) {
            this.lastIndex = var2;
            if (this.streamList != null) {
                this.closeUsedStreams(var2);
            }

            return this.accessors[var2 + this.offsetOfFirstUserColumn].getOracleObject(var1 - this.indexOfFirstRow);
        }
    }

    ORAData getORAData(int var1, int var2, ORADataFactory var3) throws SQLException {
        synchronized(this.connection) {
            this.lastIndex = var2;
            if (this.streamList != null) {
                this.closeUsedStreams(var2);
            }

            return this.accessors[var2 + this.offsetOfFirstUserColumn].getORAData(var1 - this.indexOfFirstRow, var3);
        }
    }

    Object getObject(int var1, int var2, OracleDataFactory var3) throws SQLException {
        synchronized(this.connection) {
            this.lastIndex = var2;
            if (this.streamList != null) {
                this.closeUsedStreams(var2);
            }

            return this.accessors[var2 + this.offsetOfFirstUserColumn].getObject(var1 - this.indexOfFirstRow, var3);
        }
    }

    RAW getRAW(int var1, int var2) throws SQLException {
        synchronized(this.connection) {
            this.lastIndex = var2;
            if (this.streamList != null) {
                this.closeUsedStreams(var2);
            }

            return this.accessors[var2 + this.offsetOfFirstUserColumn].getRAW(var1 - this.indexOfFirstRow);
        }
    }

    REF getREF(int var1, int var2) throws SQLException {
        synchronized(this.connection) {
            this.lastIndex = var2;
            if (this.streamList != null) {
                this.closeUsedStreams(var2);
            }

            return this.accessors[var2 + this.offsetOfFirstUserColumn].getREF(var1 - this.indexOfFirstRow);
        }
    }

    ROWID getROWID(int var1, int var2) throws SQLException {
        synchronized(this.connection) {
            this.lastIndex = var2;
            if (this.streamList != null) {
                this.closeUsedStreams(var2);
            }

            return this.accessors[var2 + this.offsetOfFirstUserColumn].getROWID(var1 - this.indexOfFirstRow);
        }
    }

    STRUCT getSTRUCT(int var1, int var2) throws SQLException {
        synchronized(this.connection) {
            this.lastIndex = var2;
            if (this.streamList != null) {
                this.closeUsedStreams(var2);
            }

            return this.accessors[var2 + this.offsetOfFirstUserColumn].getSTRUCT(var1 - this.indexOfFirstRow);
        }
    }

    TIMESTAMPLTZ getTIMESTAMPLTZ(int var1, int var2) throws SQLException {
        synchronized(this.connection) {
            this.lastIndex = var2;
            if (this.streamList != null) {
                this.closeUsedStreams(var2);
            }

            return this.accessors[var2 + this.offsetOfFirstUserColumn].getTIMESTAMPLTZ(var1 - this.indexOfFirstRow);
        }
    }

    TIMESTAMPTZ getTIMESTAMPTZ(int var1, int var2) throws SQLException {
        synchronized(this.connection) {
            this.lastIndex = var2;
            if (this.streamList != null) {
                this.closeUsedStreams(var2);
            }

            return this.accessors[var2 + this.offsetOfFirstUserColumn].getTIMESTAMPTZ(var1 - this.indexOfFirstRow);
        }
    }

    TIMESTAMP getTIMESTAMP(int var1, int var2) throws SQLException {
        synchronized(this.connection) {
            this.lastIndex = var2;
            if (this.streamList != null) {
                this.closeUsedStreams(var2);
            }

            return this.accessors[var2 + this.offsetOfFirstUserColumn].getTIMESTAMP(var1 - this.indexOfFirstRow);
        }
    }

    CustomDatum getCustomDatum(int var1, int var2, CustomDatumFactory var3) throws SQLException {
        synchronized(this.connection) {
            this.lastIndex = var2;
            if (this.streamList != null) {
                this.closeUsedStreams(var2);
            }

            return this.accessors[var2 + this.offsetOfFirstUserColumn].getCustomDatum(var1 - this.indexOfFirstRow, var3);
        }
    }

    InputStream getAsciiStream(int var1, int var2) throws SQLException {
        synchronized(this.connection) {
            this.lastIndex = var2;
            if (this.streamList != null) {
                this.closeUsedStreams(var2);
            }

            return this.accessors[var2 + this.offsetOfFirstUserColumn].getAsciiStream(var1 - this.indexOfFirstRow);
        }
    }

    InputStream getBinaryStream(int var1, int var2) throws SQLException {
        synchronized(this.connection) {
            this.lastIndex = var2;
            if (this.streamList != null) {
                this.closeUsedStreams(var2);
            }

            return this.accessors[var2 + this.offsetOfFirstUserColumn].getBinaryStream(var1 - this.indexOfFirstRow);
        }
    }

    Reader getCharacterStream(int var1, int var2) throws SQLException {
        synchronized(this.connection) {
            this.lastIndex = var2;
            if (this.streamList != null) {
                this.closeUsedStreams(var2);
            }

            return this.accessors[var2 + this.offsetOfFirstUserColumn].getCharacterStream(var1 - this.indexOfFirstRow);
        }
    }

    Reader getNCharacterStream(int var1, int var2) throws SQLException {
        synchronized(this.connection) {
            this.lastIndex = var2;
            if (this.streamList != null) {
                this.closeUsedStreams(var2);
            }

            return this.accessors[var2 + this.offsetOfFirstUserColumn].getNCharacterStream(var1 - this.indexOfFirstRow);
        }
    }

    InputStream getUnicodeStream(int var1, int var2) throws SQLException {
        synchronized(this.connection) {
            this.lastIndex = var2;
            if (this.streamList != null) {
                this.closeUsedStreams(var2);
            }

            return this.accessors[var2 + this.offsetOfFirstUserColumn].getUnicodeStream(var1 - this.indexOfFirstRow);
        }
    }

    protected OracleConnection getConnectionDuringExceptionHandling() {
        return this.connection;
    }
}
