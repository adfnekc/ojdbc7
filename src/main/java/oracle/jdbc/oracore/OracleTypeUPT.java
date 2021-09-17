//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package oracle.jdbc.oracore;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.Map;
import oracle.jdbc.driver.DatabaseError;
import oracle.jdbc.internal.OracleConnection;
import oracle.sql.ARRAY;
import oracle.sql.ArrayDescriptor;
import oracle.sql.Datum;
import oracle.sql.OPAQUE;
import oracle.sql.STRUCT;
import oracle.sql.StructDescriptor;

public class OracleTypeUPT extends OracleTypeADT implements Serializable {
    static final long serialVersionUID = -1994358478872378695L;
    static final byte KOPU_UPT_ADT = -6;
    static final byte KOPU_UPT_COLL = -5;
    static final byte KOPU_UPT_REFCUR = 102;
    static final byte KOTTCOPQ = 58;
    byte uptCode = 0;
    OracleNamedType realType = null;
    private static final String _Copyright_2007_Oracle_All_Rights_Reserved_ = null;
    public static final String BUILD_DATE = "Thu_Apr_04_15:09:24_PDT_2013";
    public static final boolean TRACE = false;

    protected OracleTypeUPT() {
    }

    public OracleTypeUPT(String var1, OracleConnection var2) throws SQLException {
        super(var1, var2);
    }

    public OracleTypeUPT(OracleTypeADT var1, int var2, OracleConnection var3) throws SQLException {
        super(var1, var2, var3);
    }

    public Datum toDatum(Object var1, OracleConnection var2) throws SQLException {
        return var1 != null ? this.realType.toDatum(var1, var2) : null;
    }

    public Datum[] toDatumArray(Object var1, OracleConnection var2, long var3, int var5) throws SQLException {
        return var1 != null ? this.realType.toDatumArray(var1, var2, var3, var5) : null;
    }

    public int getTypeCode() throws SQLException {
        switch(this.uptCode) {
            case -6:
                return this.realType.getTypeCode();
            case -5:
                return 2003;
            case 58:
                return 2007;
            default:
                SQLException var1 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 1, "Invalid type code");
                var1.fillInStackTrace();
                throw var1;
        }
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

    public void parseTDSrec(TDSReader var1) throws SQLException {
        long var2 = var1.readLong();
        this.uptCode = var1.readByte();
        var1.addNormalPatch(var2, this.uptCode, this);
    }

    protected int pickle81(PickleContext var1, Datum var2) throws SQLException {
        byte var3 = 0;
        int var7;
        if (var2 == null) {
            var7 = var3 + var1.writeElementNull();
        } else {
            int var4 = var1.offset();
            var7 = var3 + var1.writeLength(PickleContext.KOPI20_LN_MAXV + 1);
            boolean var5 = false;
            int var8;
            if (this.uptCode == -6 && !((OracleTypeADT)this.realType).isFinalType()) {
                if (!(var2 instanceof STRUCT)) {
                    SQLException var6 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 1, "invalid upt state");
                    var6.fillInStackTrace();
                    throw var6;
                }

                var8 = ((STRUCT)var2).getDescriptor().getOracleTypeADT().pickle81(var1, var2);
            } else {
                var8 = this.realType.pickle81(var1, var2);
            }

            var7 += var8;
            var1.patchImageLen(var4, var8);
        }

        return var7;
    }

    protected Object unpickle81rec(PickleContext var1, int var2, Map var3) throws SQLException {
        byte var4 = var1.readByte();
        if (PickleContext.isElementNull(var4)) {
            return null;
        } else if (var2 == 9) {
            var1.skipBytes(var1.readRestOfLength(var4));
            return null;
        } else {
            var1.skipRestOfLength(var4);
            return this.unpickle81UPT(var1, var2, var3);
        }
    }

    protected Object unpickle81rec(PickleContext var1, byte var2, int var3, Map var4) throws SQLException {
        long var5 = (long)var1.readRestOfLength(var2);
        if (var3 == 9) {
            var1.skipBytes((int)var5);
            return null;
        } else {
            return this.unpickle81UPT(var1, var3, var4);
        }
    }

    private Object unpickle81UPT(PickleContext var1, int var2, Map var3) throws SQLException {
        SQLException var5;
        switch(this.uptCode) {
            case -6:
                switch(var2) {
                    case 1:
                        return ((OracleTypeADT)this.realType).unpickle81(var1, (STRUCT)null, 3, var2, var3);
                    case 2:
                        STRUCT var6 = ((OracleTypeADT)this.realType).unpickle81(var1, (STRUCT)null, 1, var2, var3);
                        return var6 == null ? var6 : var6.toJdbc(var3);
                    case 9:
                        return ((OracleTypeADT)this.realType).unpickle81(var1, (STRUCT)null, 9, 1, var3);
                    default:
                        var5 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 1);
                        var5.fillInStackTrace();
                        throw var5;
                }
            case -5:
                return ((OracleTypeCOLLECTION)this.realType).unpickle81(var1, (ARRAY)null, var2 == 9 ? var2 : 3, var2, var3);
            case 58:
                switch(var2) {
                    case 1:
                    case 9:
                        return ((OracleTypeOPAQUE)this.realType).unpickle81(var1, (OPAQUE)null, var2, var3);
                    case 2:
                        OPAQUE var4 = ((OracleTypeOPAQUE)this.realType).unpickle81(var1, (OPAQUE)null, var2, var3);
                        return var4 == null ? var4 : var4.toJdbc(var3);
                    default:
                        var5 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 1);
                        var5.fillInStackTrace();
                        throw var5;
                }
            default:
                SQLException var7 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 1, "Unrecognized UPT code");
                var7.fillInStackTrace();
                throw var7;
        }
    }

    protected Datum unpickle81datumAsNull(PickleContext var1, byte var2, byte var3) throws SQLException {
        return null;
    }

    StructDescriptor createStructDescriptor() throws SQLException {
        StructDescriptor var1 = null;
        if (this.sqlName == null) {
            var1 = new StructDescriptor((OracleTypeADT)this.realType, this.connection);
        } else {
            var1 = StructDescriptor.createDescriptor(this.sqlName, this.connection);
        }

        return var1;
    }

    ArrayDescriptor createArrayDescriptor() throws SQLException {
        ArrayDescriptor var1 = null;
        if (this.sqlName == null) {
            var1 = new ArrayDescriptor((OracleTypeCOLLECTION)this.realType, this.connection);
        } else {
            var1 = ArrayDescriptor.createDescriptor(this.sqlName, this.connection);
        }

        return var1;
    }

    public OracleType getRealType() throws SQLException {
        return this.realType;
    }

    public int getNumAttrs() throws SQLException {
        return ((OracleTypeADT)this.realType).getNumAttrs();
    }

    public OracleType getAttrTypeAt(int var1) throws SQLException {
        return ((OracleTypeADT)this.realType).getAttrTypeAt(var1);
    }

    private void writeObject(ObjectOutputStream var1) throws IOException {
        var1.writeByte(this.uptCode);
        var1.writeObject(this.realType);
    }

    private void readObject(ObjectInputStream var1) throws IOException, ClassNotFoundException {
        this.uptCode = var1.readByte();
        this.realType = (OracleNamedType)var1.readObject();
    }

    public void setConnection(OracleConnection var1) throws SQLException {
        this.connection = var1;
        this.realType.setConnection(var1);
    }

    public void initChildNamesRecursively(Map var1) throws SQLException {
        if (this.realType != null) {
            this.realType.setSqlName(this.sqlName);
            this.realType.initChildNamesRecursively(var1);
        }

    }

    public void initMetadataRecursively() throws SQLException {
        this.initMetadata(this.connection);
        if (this.realType != null) {
            this.realType.initMetadataRecursively();
        }

    }

    public void cacheDescriptor() throws SQLException {
    }

    public void printXML(PrintWriter var1, int var2, boolean var3) throws SQLException {
        int var4;
        for(var4 = 0; var4 < var2; ++var4) {
            var1.print("  ");
        }

        var1.println("<OracleTypeUPT sqlName=\"" + this.sqlName + "\" " + " toid=\"" + this.toid + "\" " + ">");
        if (this.realType != null) {
            this.realType.printXML(var1, var2 + 1, var3);
        }

        for(var4 = 0; var4 < var2; ++var4) {
            var1.print("  ");
        }

        var1.println("</OracleTypeUPT>");
    }

    public void printXML(PrintWriter var1, int var2) throws SQLException {
        this.printXML(var1, var2, false);
    }
}
