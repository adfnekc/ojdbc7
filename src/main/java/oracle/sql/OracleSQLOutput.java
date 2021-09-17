//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package oracle.sql;

import java.io.IOException;
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
import java.sql.SQLData;
import java.sql.SQLException;
import java.sql.SQLOutput;
import java.sql.SQLXML;
import java.sql.Struct;
import java.sql.Time;
import java.sql.Timestamp;
import oracle.jdbc.OracleConnection;
import oracle.jdbc.driver.DatabaseError;

public class OracleSQLOutput implements SQLOutput {
    private StructDescriptor descriptor;
    private Object[] attributes;
    private int index;
    private OracleConnection conn;
    private static final String _Copyright_2007_Oracle_All_Rights_Reserved_ = null;
    public static final String BUILD_DATE = "Thu_Apr_04_15:09:24_PDT_2013";
    public static final boolean TRACE = false;

    public OracleSQLOutput(StructDescriptor var1, OracleConnection var2) throws SQLException {
        this.descriptor = var1;
        this.attributes = new Object[var1.getLength()];
        this.conn = var2;
        this.index = 0;
    }

    public STRUCT getSTRUCT() throws SQLException {
        return new STRUCT(this.descriptor, this.conn, this.attributes);
    }

    public void writeString(String var1) throws SQLException {
        this.attributes[this.index++] = var1;
    }

    public void writeBoolean(boolean var1) throws SQLException {
        this.attributes[this.index++] = var1;
    }

    public void writeByte(byte var1) throws SQLException {
        this.attributes[this.index++] = Integer.valueOf(var1);
    }

    public void writeShort(short var1) throws SQLException {
        this.attributes[this.index++] = Integer.valueOf(var1);
    }

    public void writeInt(int var1) throws SQLException {
        this.attributes[this.index++] = var1;
    }

    public void writeLong(long var1) throws SQLException {
        this.attributes[this.index++] = new Long(var1);
    }

    public void writeFloat(float var1) throws SQLException {
        this.attributes[this.index++] = new Float(var1);
    }

    public void writeDouble(double var1) throws SQLException {
        this.attributes[this.index++] = new Double(var1);
    }

    public void writeBigDecimal(BigDecimal var1) throws SQLException {
        this.attributes[this.index++] = var1;
    }

    public void writeBytes(byte[] var1) throws SQLException {
        this.attributes[this.index++] = var1;
    }

    public void writeDate(Date var1) throws SQLException {
        this.attributes[this.index++] = var1;
    }

    public void writeTime(Time var1) throws SQLException {
        this.attributes[this.index++] = var1;
    }

    public void writeTimestamp(Timestamp var1) throws SQLException {
        this.attributes[this.index++] = var1;
    }

    public void writeCharacterStream(Reader var1) throws SQLException {
        StringBuffer var2 = new StringBuffer();
        char[] var3 = new char[100];
        boolean var4 = false;

        int var8;
        try {
            while((var8 = var1.read(var3)) != -1) {
                var2.append(var3, 0, var8);
            }
        } catch (IOException var7) {
            SQLException var6 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), var7);
            var6.fillInStackTrace();
            throw var6;
        }

        String var5 = var2.substring(0, var2.length());
        this.attributes[this.index++] = var5;
    }

    public void writeAsciiStream(InputStream var1) throws SQLException {
        StringBuffer var2 = new StringBuffer();
        byte[] var3 = new byte[100];
        char[] var4 = new char[100];
        boolean var5 = false;

        int var9;
        try {
            while((var9 = var1.read(var3)) != -1) {
                for(int var6 = 0; var6 < var9; ++var6) {
                    var4[var6] = (char)var3[var6];
                }

                var2.append(var4, 0, var9);
            }
        } catch (IOException var8) {
            SQLException var7 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), var8);
            var7.fillInStackTrace();
            throw var7;
        }

        String var10 = var2.substring(0, var2.length());
        this.attributes[this.index++] = var10;
    }

    public void writeBinaryStream(InputStream var1) throws SQLException {
        this.writeAsciiStream(var1);
    }

    public void writeObject(SQLData var1) throws SQLException {
        STRUCT var2 = null;
        if (var1 != null) {
            StructDescriptor var3 = StructDescriptor.createDescriptor(var1.getSQLTypeName(), this.conn);
            SQLOutput var4 = var3.toJdbc2SQLOutput();
            var1.writeSQL(var4);
            var2 = ((OracleSQLOutput)var4).getSTRUCT();
        }

        this.writeStruct(var2);
    }

    public void writeObject(Object var1) throws SQLException {
        if (var1 != null && var1 instanceof SQLData) {
            this.writeObject((SQLData)var1);
        } else {
            this.attributes[this.index++] = var1;
        }

    }

    public void writeRef(Ref var1) throws SQLException {
        this.attributes[this.index++] = var1;
    }

    public void writeBlob(Blob var1) throws SQLException {
        this.attributes[this.index++] = var1;
    }

    public void writeClob(Clob var1) throws SQLException {
        this.attributes[this.index++] = var1;
    }

    public void writeStruct(Struct var1) throws SQLException {
        this.attributes[this.index++] = var1;
    }

    public void writeArray(Array var1) throws SQLException {
        this.attributes[this.index++] = var1;
    }

    public void writeOracleObject(Datum var1) throws SQLException {
        this.attributes[this.index++] = var1;
    }

    public void writeRef(REF var1) throws SQLException {
        this.attributes[this.index++] = var1;
    }

    public void writeBlob(BLOB var1) throws SQLException {
        this.attributes[this.index++] = var1;
    }

    public void writeBfile(BFILE var1) throws SQLException {
        this.attributes[this.index++] = var1;
    }

    public void writeClob(CLOB var1) throws SQLException {
        this.attributes[this.index++] = var1;
    }

    public void writeStruct(STRUCT var1) throws SQLException {
        this.attributes[this.index++] = var1;
    }

    public void writeArray(ARRAY var1) throws SQLException {
        this.attributes[this.index++] = var1;
    }

    public void writeNUMBER(NUMBER var1) throws SQLException {
        this.attributes[this.index++] = var1;
    }

    public void writeCHAR(CHAR var1) throws SQLException {
        this.attributes[this.index++] = var1;
    }

    public void writeDATE(DATE var1) throws SQLException {
        this.attributes[this.index++] = var1;
    }

    public void writeRAW(RAW var1) throws SQLException {
        this.attributes[this.index++] = var1;
    }

    public void writeROWID(ROWID var1) throws SQLException {
        this.attributes[this.index++] = var1;
    }

    public void writeURL(URL var1) throws SQLException {
        SQLException var2 = DatabaseError.createUnsupportedFeatureSqlException();
        var2.fillInStackTrace();
        throw var2;
    }

    public void writeNClob(NClob var1) throws SQLException {
        this.writeClob((Clob)var1);
    }

    public void writeNString(String var1) throws SQLException {
        this.writeString(var1);
    }

    public void writeSQLXML(SQLXML var1) throws SQLException {
        this.writeObject((Object)var1);
    }

    public void writeRowId(RowId var1) throws SQLException {
        this.writeROWID((ROWID)var1);
    }

    protected oracle.jdbc.internal.OracleConnection getConnectionDuringExceptionHandling() {
        return null;
    }
}
