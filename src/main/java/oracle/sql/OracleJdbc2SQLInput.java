//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package oracle.sql;

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
import java.sql.RowId;
import java.sql.SQLException;
import java.sql.SQLInput;
import java.sql.SQLXML;
import java.sql.Struct;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Map;
import oracle.jdbc.OracleConnection;
import oracle.jdbc.driver.DatabaseError;

public class OracleJdbc2SQLInput implements SQLInput {
    private int index;
    private Datum[] attributes;
    private Map map;
    private OracleConnection conn;
    private static final String _Copyright_2007_Oracle_All_Rights_Reserved_ = null;
    public static final String BUILD_DATE = "Thu_Apr_04_15:09:24_PDT_2013";
    public static final boolean TRACE = false;

    public OracleJdbc2SQLInput(Datum[] var1, Map var2, OracleConnection var3) {
        this.attributes = var1;
        this.map = var2;
        this.conn = var3;
        this.index = 0;
    }

    public String readString() throws SQLException {
        String var1 = null;

        try {
            if (this.attributes[this.index] != null) {
                var1 = this.attributes[this.index].stringValue();
            }
        } finally {
            ++this.index;
        }

        return var1;
    }

    public boolean readBoolean() throws SQLException {
        boolean var1 = false;

        try {
            if (this.attributes[this.index] != null) {
                var1 = this.attributes[this.index].booleanValue();
            }
        } finally {
            ++this.index;
        }

        return var1;
    }

    public byte readByte() throws SQLException {
        byte var1 = 0;

        try {
            if (this.attributes[this.index] != null) {
                var1 = this.attributes[this.index].byteValue();
            }
        } finally {
            ++this.index;
        }

        return var1;
    }

    public short readShort() throws SQLException {
        long var1 = this.readLong();
        if (var1 <= 65537L && var1 >= -65538L) {
            return (short)((int)var1);
        } else {
            SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 26, "readShort");
            var3.fillInStackTrace();
            throw var3;
        }
    }

    public int readInt() throws SQLException {
        int var1 = 0;

        try {
            if (this.attributes[this.index] != null) {
                var1 = this.attributes[this.index].intValue();
            }
        } finally {
            ++this.index;
        }

        return var1;
    }

    public long readLong() throws SQLException {
        long var1 = 0L;

        try {
            if (this.attributes[this.index] != null) {
                var1 = this.attributes[this.index].longValue();
            }
        } finally {
            ++this.index;
        }

        return var1;
    }

    public float readFloat() throws SQLException {
        float var1 = 0.0F;

        try {
            if (this.attributes[this.index] != null) {
                var1 = this.attributes[this.index].floatValue();
            }
        } finally {
            ++this.index;
        }

        return var1;
    }

    public double readDouble() throws SQLException {
        double var1 = 0.0D;

        try {
            if (this.attributes[this.index] != null) {
                var1 = this.attributes[this.index].doubleValue();
            }
        } finally {
            ++this.index;
        }

        return var1;
    }

    public BigDecimal readBigDecimal() throws SQLException {
        BigDecimal var1 = null;

        try {
            if (this.attributes[this.index] != null) {
                var1 = this.attributes[this.index].bigDecimalValue();
            }
        } finally {
            ++this.index;
        }

        return var1;
    }

    public byte[] readBytes() throws SQLException {
        byte[] var1 = null;

        try {
            if (this.attributes[this.index] != null) {
                if (!(this.attributes[this.index] instanceof RAW)) {
                    SQLException var2 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 4, (Object)null);
                    var2.fillInStackTrace();
                    throw var2;
                }

                var1 = ((RAW)this.attributes[this.index]).shareBytes();
            }
        } finally {
            ++this.index;
        }

        return var1;
    }

    public Date readDate() throws SQLException {
        Date var1 = null;

        try {
            if (this.attributes[this.index] != null) {
                var1 = this.attributes[this.index].dateValue();
            }
        } finally {
            ++this.index;
        }

        return var1;
    }

    public Time readTime() throws SQLException {
        Time var1 = null;

        try {
            if (this.attributes[this.index] != null) {
                var1 = this.attributes[this.index].timeValue();
            }
        } finally {
            ++this.index;
        }

        return var1;
    }

    public Timestamp readTimestamp() throws SQLException {
        Timestamp var1 = null;

        try {
            if (this.attributes[this.index] != null) {
                var1 = this.attributes[this.index].timestampValue();
            }
        } finally {
            ++this.index;
        }

        return var1;
    }

    public Reader readCharacterStream() throws SQLException {
        Reader var1 = null;

        try {
            Datum var2 = this.attributes[this.index];
            if (var2 != null) {
                var1 = var2.characterStreamValue();
            }
        } finally {
            ++this.index;
        }

        return var1;
    }

    public InputStream readAsciiStream() throws SQLException {
        InputStream var1 = null;

        try {
            Datum var2 = this.attributes[this.index];
            if (var2 != null) {
                var1 = var2.asciiStreamValue();
            }
        } finally {
            ++this.index;
        }

        return var1;
    }

    public InputStream readBinaryStream() throws SQLException {
        InputStream var1 = null;

        try {
            Datum var2 = this.attributes[this.index];
            if (var2 != null) {
                var1 = var2.binaryStreamValue();
            }
        } finally {
            ++this.index;
        }

        return var1;
    }

    public Object readObject() throws SQLException {
        Datum var1 = (Datum)this.readOracleObject();
        Object var2 = null;
        if (var1 != null) {
            if (var1 instanceof STRUCT) {
                var2 = ((STRUCT)var1).toJdbc(this.map);
            } else {
                var2 = var1.toJdbc();
            }
        }

        return var2;
    }

    public Ref readRef() throws SQLException {
        return this.readREF();
    }

    public Blob readBlob() throws SQLException {
        return this.readBLOB();
    }

    public Clob readClob() throws SQLException {
        return this.readCLOB();
    }

    public Array readArray() throws SQLException {
        return (Array) this.readARRAY();
    }

    public Struct readStruct() throws SQLException {
        return (Struct) this.readSTRUCT();
    }

    public boolean wasNull() throws SQLException {
        if (this.index == 0) {
            SQLException var2 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 24);
            var2.fillInStackTrace();
            throw var2;
        } else {
            boolean var1 = this.attributes[this.index - 1] == null;
            return var1;
        }
    }

    public Object readOracleObject() throws SQLException {
        return this.attributes[this.index++];
    }

    public NUMBER readNUMBER() throws SQLException {
        NUMBER var1 = null;

        try {
            if (this.attributes[this.index] != null) {
                if (!(this.attributes[this.index] instanceof NUMBER)) {
                    SQLException var2 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 4, (Object)null);
                    var2.fillInStackTrace();
                    throw var2;
                }

                var1 = (NUMBER)this.attributes[this.index];
            }
        } finally {
            ++this.index;
        }

        return var1;
    }

    public CHAR readCHAR() throws SQLException {
        CHAR var1 = null;

        try {
            if (this.attributes[this.index] != null) {
                if (!(this.attributes[this.index] instanceof CHAR)) {
                    SQLException var2 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 4, (Object)null);
                    var2.fillInStackTrace();
                    throw var2;
                }

                var1 = (CHAR)this.attributes[this.index];
            }
        } finally {
            ++this.index;
        }

        return var1;
    }

    public DATE readDATE() throws SQLException {
        DATE var1 = null;

        try {
            if (this.attributes[this.index] != null) {
                if (!(this.attributes[this.index] instanceof DATE)) {
                    SQLException var2 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 4, (Object)null);
                    var2.fillInStackTrace();
                    throw var2;
                }

                var1 = (DATE)this.attributes[this.index];
            }
        } finally {
            ++this.index;
        }

        return var1;
    }

    public BFILE readBFILE() throws SQLException {
        BFILE var1 = null;

        try {
            if (this.attributes[this.index] != null) {
                if (!(this.attributes[this.index] instanceof BFILE)) {
                    SQLException var2 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 4, (Object)null);
                    var2.fillInStackTrace();
                    throw var2;
                }

                var1 = (BFILE)this.attributes[this.index];
            }
        } finally {
            ++this.index;
        }

        return var1;
    }

    public BLOB readBLOB() throws SQLException {
        BLOB var1 = null;

        try {
            if (this.attributes[this.index] != null) {
                if (!(this.attributes[this.index] instanceof BLOB)) {
                    SQLException var2 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 4, (Object)null);
                    var2.fillInStackTrace();
                    throw var2;
                }

                var1 = (BLOB)this.attributes[this.index];
            }
        } finally {
            ++this.index;
        }

        return var1;
    }

    public CLOB readCLOB() throws SQLException {
        CLOB var1 = null;

        try {
            if (this.attributes[this.index] != null) {
                if (!(this.attributes[this.index] instanceof CLOB)) {
                    SQLException var2 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 4, (Object)null);
                    var2.fillInStackTrace();
                    throw var2;
                }

                var1 = (CLOB)this.attributes[this.index];
            }
        } finally {
            ++this.index;
        }

        return var1;
    }

    public RAW readRAW() throws SQLException {
        RAW var1 = null;

        try {
            if (this.attributes[this.index] != null) {
                if (!(this.attributes[this.index] instanceof RAW)) {
                    SQLException var2 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 4, (Object)null);
                    var2.fillInStackTrace();
                    throw var2;
                }

                var1 = (RAW)this.attributes[this.index];
            }
        } finally {
            ++this.index;
        }

        return var1;
    }

    public REF readREF() throws SQLException {
        REF var1 = null;

        try {
            if (this.attributes[this.index] != null) {
                if (!(this.attributes[this.index] instanceof REF)) {
                    SQLException var2 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 4, (Object)null);
                    var2.fillInStackTrace();
                    throw var2;
                }

                var1 = (REF)this.attributes[this.index];
            }
        } finally {
            ++this.index;
        }

        return var1;
    }

    public ROWID readROWID() throws SQLException {
        ROWID var1 = null;

        try {
            if (this.attributes[this.index] != null) {
                if (!(this.attributes[this.index] instanceof ROWID)) {
                    SQLException var2 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 4, (Object)null);
                    var2.fillInStackTrace();
                    throw var2;
                }

                var1 = (ROWID)this.attributes[this.index];
            }
        } finally {
            ++this.index;
        }

        return var1;
    }

    public ARRAY readARRAY() throws SQLException {
        ARRAY var1 = null;

        try {
            if (this.attributes[this.index] != null) {
                if (!(this.attributes[this.index] instanceof ARRAY)) {
                    SQLException var2 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 4, (Object)null);
                    var2.fillInStackTrace();
                    throw var2;
                }

                var1 = (ARRAY)this.attributes[this.index];
            }
        } finally {
            ++this.index;
        }

        return var1;
    }

    public STRUCT readSTRUCT() throws SQLException {
        STRUCT var1 = null;

        try {
            if (this.attributes[this.index] != null) {
                if (!(this.attributes[this.index] instanceof STRUCT)) {
                    SQLException var2 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 4, (Object)null);
                    var2.fillInStackTrace();
                    throw var2;
                }

                var1 = (STRUCT)this.attributes[this.index];
            }
        } finally {
            ++this.index;
        }

        return var1;
    }

    public URL readURL() throws SQLException {
        SQLException var1 = DatabaseError.createUnsupportedFeatureSqlException();
        var1.fillInStackTrace();
        throw var1;
    }

    public NClob readNClob() throws SQLException {
        NCLOB var1 = null;

        try {
            if (this.attributes[this.index] != null) {
                if (!(this.attributes[this.index] instanceof NCLOB)) {
                    SQLException var2 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 4, (Object)null);
                    var2.fillInStackTrace();
                    throw var2;
                }

                var1 = (NCLOB)this.attributes[this.index];
            }
        } finally {
            ++this.index;
        }

        return var1;
    }

    public String readNString() throws SQLException {
        return this.readString();
    }

    public SQLXML readSQLXML() throws SQLException {
        SQLXML var1 = null;

        try {
            if (this.attributes[this.index] != null) {
                if (!(this.attributes[this.index] instanceof SQLXML)) {
                    SQLException var2 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 4, (Object)null);
                    var2.fillInStackTrace();
                    throw var2;
                }

                var1 = (SQLXML)this.attributes[this.index];
            }
        } finally {
            ++this.index;
        }

        return var1;
    }

    public RowId readRowId() throws SQLException {
        return this.readROWID();
    }

    protected oracle.jdbc.internal.OracleConnection getConnectionDuringExceptionHandling() {
        return null;
    }
}
