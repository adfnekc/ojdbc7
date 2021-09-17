//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package oracle.jdbc.driver;

import java.io.InputStream;
import java.io.Reader;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Array;
import java.sql.Blob;
import java.sql.Clob;
import java.sql.NClob;
import java.sql.Ref;
import java.sql.ResultSet;
import java.sql.RowId;
import java.sql.SQLData;
import java.sql.SQLException;
import java.sql.SQLXML;
import java.sql.Struct;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import oracle.jdbc.OracleArray;
import oracle.jdbc.OracleBfile;
import oracle.jdbc.OracleBlob;
import oracle.jdbc.OracleClob;
import oracle.jdbc.OracleData;
import oracle.jdbc.OracleOpaque;
import oracle.jdbc.OracleRef;
import oracle.sql.ARRAY;
import oracle.sql.BFILE;
import oracle.sql.BINARY_DOUBLE;
import oracle.sql.BINARY_FLOAT;
import oracle.sql.BLOB;
import oracle.sql.CHAR;
import oracle.sql.CLOB;
import oracle.sql.DATE;
import oracle.sql.INTERVALDS;
import oracle.sql.INTERVALYM;
import oracle.sql.NUMBER;
import oracle.sql.OPAQUE;
import oracle.sql.ORAData;
import oracle.sql.RAW;
import oracle.sql.REF;
import oracle.sql.ROWID;
import oracle.sql.STRUCT;
import oracle.sql.TIMESTAMP;
import oracle.sql.TIMESTAMPLTZ;
import oracle.sql.TIMESTAMPTZ;

public class Representation {
    public static final Representation VARCHAR = new Representation("VARCHAR", new Class[]{String.class, Reader.class, CHAR.class, InputStream.class, BigDecimal.class, Double.class, Float.class, Long.class, Integer.class, Short.class, Byte.class, Timestamp.class, Date.class, Calendar.class, java.sql.Date.class, Time.class, Boolean.class});
    public static final Representation FIXED_CHAR;
    public static final Representation CHAR;
    public static final Representation VCS;
    public static final Representation LONG;
    public static final Representation NUMBER;
    public static final Representation VARNUM;
    public static final Representation BINARY_FLOAT;
    public static final Representation BINARY_DOUBLE;
    public static final Representation RAW;
    public static final Representation VBI;
    public static final Representation LONG_RAW;
    public static final Representation ROWID;
    public static final Representation RESULT_SET;
    public static final Representation RSET;
    public static final Representation DATE;
    public static final Representation BLOB;
    public static final Representation CLOB;
    public static final Representation BFILE;
    public static final Representation NAMED_TYPE;
    public static final Representation REF_TYPE;
    public static final Representation TIMESTAMP;
    public static final Representation TIMESTAMPTZ;
    public static final Representation OLD_TIMESTAMPTZ;
    public static final Representation TIMESTAMPLTZ;
    public static final Representation INTERVALYM;
    public static final Representation INTERVALDS;
    public static final Representation UROWID;
    public static final Representation PLSQL_INDEX_TABLE;
    public static final Representation T2S_OVERLONG_RAW;
    public static final Representation SET_CHAR_BYTES;
    public static final Representation NULL_TYPE;
    public static final Representation DML_RETURN_PARAM;
    public static final Representation NVARCHAR;
    public static final Representation FIXED_NCHAR;
    public static final Representation NCHAR;
    public static final Representation NVCS;
    public static final Representation NCLOB;
    protected final List<Class> tableB3Classes;
    protected final Map<Class, Redirector> redirectorCache = new ConcurrentHashMap(1024);
    protected final String identifier;
    private static final String _Copyright_2007_Oracle_All_Rights_Reserved_;
    public static final String BUILD_DATE = "Thu_Apr_04_15:09:24_PDT_2013";
    public static final boolean TRACE = false;

    protected Representation(String var1, Class... var2) {
        this.identifier = var1;

        assert var2.length > 0 : var2.length;

        this.tableB3Classes = Collections.unmodifiableList(Arrays.asList(var2));

        assert this.tableB3Classes.size() > 0 : this.tableB3Classes.size();

        this.redirectorCache.putAll(Redirector.createRedirectorMap(this.tableB3Classes));
    }

    public String toString() {
        return "oracle.jdbc.driver.Representation[" + this.identifier + "]";
    }

    <T> T getObject(Accessor var1, int var2, Class<T> var3) throws SQLException {
        if (var3 == null) {
            SQLException var6 = DatabaseError.createSqlException(getConnectionDuringExceptionHandling(), 282);
            var6.fillInStackTrace();
            throw var6;
        } else {
            Redirector var4 = this.getRedirector(var3);
            if (var4 == null) {
                SQLException var5 = DatabaseError.createSqlException(getConnectionDuringExceptionHandling(), 4, var3);
                var5.fillInStackTrace();
                throw var5;
            } else {
                return (T) var4.redirect(var1, var2);
            }
        }
    }

    final <T> Redirector<T> getRedirector(Class<T> var1) {
        Redirector var2 = (Redirector)this.redirectorCache.get(var1);
        if (var2 == null) {
            var2 = this.createRedirector(var1);
            this.redirectorCache.put(var1, var2);
        }

        return var2;
    }

    private final <T> Redirector<T> createRedirector(Class<T> var1) {
        return !SQLData.class.isAssignableFrom(var1) && !OracleData.class.isAssignableFrom(var1) && !ORAData.class.isAssignableFrom(var1) ? Redirector.createValueOfRedirector(var1, this.tableB3Classes) : Redirector.createObjectRedirector(var1);
    }

    static OracleConnection getConnectionDuringExceptionHandling() {
        return null;
    }

    static {
        FIXED_CHAR = VARCHAR;
        CHAR = VARCHAR;
        VCS = VARCHAR;
        LONG = new Representation("LONG", new Class[]{String.class, Reader.class, InputStream.class});
        NUMBER = new Representation("NUMBER", new Class[]{BigDecimal.class, NUMBER.class, Double.class, Float.class, Long.class, Integer.class, Short.class, Byte.class, Boolean.class});
        VARNUM = NUMBER;
        BINARY_FLOAT = new Representation("BINARY_FLOAT", new Class[]{Float.class, Double.class, BigDecimal.class, BINARY_FLOAT.class, NUMBER.class, BigInteger.class, Long.class, Integer.class, Short.class, Byte.class});
        BINARY_DOUBLE = new Representation("BINARY_DOUBLE", new Class[]{Double.class, BigDecimal.class, BINARY_DOUBLE.class, NUMBER.class, Float.class, BigInteger.class, Long.class, Integer.class, Short.class, Byte.class});
        RAW = new Representation("RAW", new Class[]{byte[].class, RAW.class});
        VBI = null;
        LONG_RAW = RAW;
        ROWID = new Representation("ROWID", new Class[]{RowId.class, ROWID.class, String.class});
        RESULT_SET = new Representation("RESULT_SET", new Class[]{ResultSet.class});
        RSET = RESULT_SET;
        DATE = new Representation("DATE", new Class[]{Timestamp.class, Date.class, Calendar.class, DATE.class, TIMESTAMP.class, String.class, java.sql.Date.class, Time.class});
        BLOB = new Representation("BLOB", new Class[]{Blob.class, BLOB.class, OracleBlob.class, InputStream.class, byte[].class});
        CLOB = new Representation("CLOB", new Class[]{Clob.class, CLOB.class, OracleClob.class, Reader.class, String.class, InputStream.class});
        BFILE = new Representation("BFILE", new Class[]{BFILE.class, OracleBfile.class, InputStream.class, byte[].class});
        NAMED_TYPE = new Representation("NAMED_TYPE", new Class[]{SQLXML.class, OracleData.class, ORAData.class, OPAQUE.class, OracleOpaque.class, Struct.class, STRUCT.class, Array.class, ARRAY.class, OracleArray.class});
        REF_TYPE = new Representation("REF_TYPE", new Class[]{Ref.class, REF.class, OracleRef.class});
        TIMESTAMP = new Representation("TIMESTAMP", new Class[]{Timestamp.class, TIMESTAMP.class, Calendar.class, Date.class, DATE.class, String.class, java.sql.Date.class, Time.class, byte[].class});
        TIMESTAMPTZ = new Representation("TIMESTAMPTZ", new Class[]{TIMESTAMPTZ.class, Timestamp.class, TIMESTAMP.class, Calendar.class, Date.class, DATE.class, String.class, java.sql.Date.class, Time.class, byte[].class});
        OLD_TIMESTAMPTZ = new Representation("OLD_TIMESTAMPTZ", new Class[]{TIMESTAMPTZ.class, Timestamp.class, TIMESTAMP.class, Calendar.class, Date.class, String.class, java.sql.Date.class, Time.class});
        TIMESTAMPLTZ = new Representation("TIMESTAMPLTZ", new Class[]{TIMESTAMPLTZ.class, Timestamp.class, TIMESTAMP.class, Calendar.class, Date.class, DATE.class, String.class, java.sql.Date.class, Time.class, byte[].class});
        INTERVALYM = new Representation("INTERVALYM", new Class[]{INTERVALYM.class});
        INTERVALDS = new Representation("INTERVALDS", new Class[]{INTERVALDS.class});
        UROWID = null;
        PLSQL_INDEX_TABLE = null;
        T2S_OVERLONG_RAW = null;
        SET_CHAR_BYTES = null;
        NULL_TYPE = null;
        DML_RETURN_PARAM = null;
        NVARCHAR = new Representation("NVARCHAR", new Class[]{String.class, Reader.class, CHAR.class, InputStream.class, BigDecimal.class, Double.class, Float.class, Long.class, Integer.class, Short.class, Byte.class, Timestamp.class, Date.class, Calendar.class, java.sql.Date.class, Time.class, Boolean.class});
        FIXED_NCHAR = NVARCHAR;
        NCHAR = NVARCHAR;
        NVCS = NVARCHAR;
        NCLOB = new Representation("NCLOB", new Class[]{NClob.class, Clob.class, CLOB.class, Reader.class, String.class, InputStream.class});
        _Copyright_2007_Oracle_All_Rights_Reserved_ = null;
    }
}
