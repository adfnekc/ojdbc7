//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package oracle.jdbc.oracore;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.Serializable;
import java.io.StringWriter;
import java.sql.SQLException;
import java.util.Map;
import oracle.jdbc.driver.DatabaseError;
import oracle.jdbc.internal.OracleConnection;
import oracle.sql.Datum;
import oracle.sql.StructDescriptor;
import oracle.sql.TypeDescriptor;

public abstract class OracleType implements Serializable {
    static final long serialVersionUID = -4124152314660261528L;
    public static final int STYLE_ARRAY_LENGTH = 0;
    public static final int STYLE_DATUM = 1;
    public static final int STYLE_JAVA = 2;
    public static final int STYLE_RAWBYTE = 3;
    public static final int STYLE_INT = 4;
    public static final int STYLE_DOUBLE = 5;
    public static final int STYLE_FLOAT = 6;
    public static final int STYLE_LONG = 7;
    public static final int STYLE_SHORT = 8;
    public static final int STYLE_SKIP = 9;
    static final int FORMAT_ADT_ATTR = 1;
    static final int FORMAT_COLL_ELEM = 2;
    static final int FORMAT_COLL_ELEM_NO_INDICATOR = 3;
    static final int SQLCS_IMPLICIT = 1;
    static final int SQLCS_NCHAR = 2;
    static final int SQLCS_EXPLICIT = 3;
    static final int SQLCS_FLEXIBLE = 4;
    static final int SQLCS_LIT_NULL = 5;
    int typeCode;
    int dbTypeCode;
    boolean metaDataInitialized;
    private static final String _Copyright_2007_Oracle_All_Rights_Reserved_ = null;
    public static final String BUILD_DATE = "Thu_Apr_04_15:09:24_PDT_2013";
    public static final boolean TRACE = false;

    public OracleType() {
        this.metaDataInitialized = false;
    }

    public OracleType(int var1) {
        this();
        this.typeCode = var1;
    }

    public boolean isInHierarchyOf(OracleType var1) throws SQLException {
        return false;
    }

    public boolean isInHierarchyOf(StructDescriptor var1) throws SQLException {
        return false;
    }

    public boolean isObjectType() {
        return false;
    }

    public TypeDescriptor getTypeDescriptor() {
        return null;
    }

    public abstract Datum toDatum(Object var1, OracleConnection var2) throws SQLException;

    public Datum toDatumInternal(Object var1, OracleConnection var2) throws SQLException {
        return this.toDatum(var1, var2);
    }

    public Datum[] toDatumArrayInternal(Object var1, OracleConnection var2, long var3, int var5) throws SQLException {
        return this.toDatumArray(var1, var2, var3, var5);
    }

    public Datum[] toDatumArray(Object var1, OracleConnection var2, long var3, int var5) throws SQLException {
        Datum[] var6 = null;
        if (var1 != null) {
            if (!(var1 instanceof Object[])) {
                SQLException var10 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 59, var1);
                var10.fillInStackTrace();
                throw var10;
            }

            Object[] var7 = (Object[])((Object[])var1);
            int var8 = (int)(var5 == -1 ? (long)var7.length : Math.min((long)var7.length - var3 + 1L, (long)var5));
            var6 = new Datum[var8];

            for(int var9 = 0; var9 < var8; ++var9) {
                var6[var9] = this.toDatum(var7[(int)var3 + var9 - 1], var2);
            }
        }

        return var6;
    }

    public void setTypeCode(int var1) {
        this.typeCode = var1;
    }

    public int getTypeCode() throws SQLException {
        return this.typeCode;
    }

    public void setDBTypeCode(int var1) {
        this.dbTypeCode = var1;
    }

    public int getDBTypeCode() throws SQLException {
        return this.dbTypeCode;
    }

    public void parseTDSrec(TDSReader var1) throws SQLException {
    }

    protected Object unpickle81rec(PickleContext var1, int var2, Map var3) throws SQLException {
        if (var2 == 9) {
            var1.skipDataValue();
            return null;
        } else {
            byte[] var4 = var1.readDataValue();
            return this.toObject(var4, var2, var3);
        }
    }

    protected Object unpickle81rec(PickleContext var1, byte var2, int var3, Map var4) throws SQLException {
        if (var3 == 9) {
            var1.skipDataValue();
            return null;
        } else {
            byte[] var5 = var1.readDataValue(var2);
            return this.toObject(var5, var3, var4);
        }
    }

    protected Datum unpickle81datumAsNull(PickleContext var1, byte var2, byte var3) throws SQLException {
        SQLException var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 1);
        var4.fillInStackTrace();
        throw var4;
    }

    protected Object toObject(byte[] var1, int var2, Map var3) throws SQLException {
        return null;
    }

    protected int pickle81(PickleContext var1, Datum var2) throws SQLException {
        int var3 = var1.writeLength((int)var2.getLength());
        var3 += var1.writeData(var2.shareBytes());
        return var3;
    }

    void writeSerializedFields(ObjectOutputStream var1) throws IOException {
        this.writeObject(var1);
    }

    void readSerializedFields(ObjectInputStream var1) throws IOException, ClassNotFoundException {
        this.readObject(var1);
    }

    private void writeObject(ObjectOutputStream var1) throws IOException {
        var1.writeInt(0);
        var1.writeInt(0);
        var1.writeInt(0);
        var1.writeInt(0);
        var1.writeInt(this.typeCode);
        var1.writeInt(this.dbTypeCode);
        var1.writeBoolean(this.metaDataInitialized);
    }

    private void readObject(ObjectInputStream var1) throws IOException, ClassNotFoundException {
        int var2 = var1.readInt();
        int var3 = var1.readInt();
        int var4 = var1.readInt();
        int var5 = var1.readInt();
        this.typeCode = var1.readInt();
        this.dbTypeCode = var1.readInt();
        this.metaDataInitialized = var1.readBoolean();
    }

    public void setConnection(OracleConnection var1) throws SQLException {
    }

    public boolean isNCHAR() throws SQLException {
        return false;
    }

    public int getPrecision() throws SQLException {
        return 0;
    }

    public int getScale() throws SQLException {
        return 0;
    }

    public void initMetadataRecursively() throws SQLException {
    }

    public void initNamesRecursively() throws SQLException {
    }

    public void initChildNamesRecursively(Map var1) throws SQLException {
    }

    public void cacheDescriptor() throws SQLException {
    }

    public void setNames(String var1, String var2) throws SQLException {
    }

    public String toXMLString() throws SQLException {
        StringWriter var1 = new StringWriter();
        PrintWriter var2 = new PrintWriter(var1);
        this.printXMLHeader(var2);
        this.printXML(var2, 0);
        return var1.getBuffer().substring(0);
    }

    public void printXML(PrintStream var1) throws SQLException {
        PrintWriter var2 = new PrintWriter(var1, true);
        this.printXMLHeader(var2);
        this.printXML(var2, 0);
    }

    void printXMLHeader(PrintWriter var1) throws SQLException {
        var1.println("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>");
    }

    public void printXML(PrintWriter var1, int var2) throws SQLException {
        this.printXML(var1, var2, false);
    }

    public void printXML(PrintWriter var1, int var2, boolean var3) throws SQLException {
        for(int var4 = 0; var4 < var2; ++var4) {
            var1.print("  ");
        }

        var1.println("<OracleType typecode=\"" + this.typeCode + "\"" + " />");
    }

    protected OracleConnection getConnectionDuringExceptionHandling() {
        return null;
    }
}
