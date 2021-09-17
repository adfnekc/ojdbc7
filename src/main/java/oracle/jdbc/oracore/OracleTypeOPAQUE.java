//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package oracle.jdbc.oracore;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.Map;
import oracle.jdbc.driver.DatabaseError;
import oracle.jdbc.internal.OracleConnection;
import oracle.sql.Datum;
import oracle.sql.OPAQUE;
import oracle.sql.OpaqueDescriptor;
import oracle.sql.StructDescriptor;
import oracle.xdb.XMLType;

public class OracleTypeOPAQUE extends OracleTypeADT implements Serializable {
    static final long KOLOFLLB = 1L;
    static final long KOLOFLCL = 2L;
    static final long KOLOFLUB = 4L;
    static final long KOLOFLFX = 8L;
    static final long serialVersionUID = -7279638692691669378L;
    long flagBits;
    long maxLen;
    private static final String _Copyright_2007_Oracle_All_Rights_Reserved_ = null;
    public static final String BUILD_DATE = "Thu_Apr_04_15:09:24_PDT_2013";
    public static final boolean TRACE = false;

    public OracleTypeOPAQUE(byte[] var1, int var2, int var3, short var4, String var5, long var6) throws SQLException {
        super(var1, var2, var3, var4, var5);
        this.flagBits = var6;
        this.flattenedAttrNum = 1;
    }

    public OracleTypeOPAQUE(String var1, OracleConnection var2) throws SQLException {
        super(var1, var2);
    }

    public OracleTypeOPAQUE(OracleTypeADT var1, int var2, OracleConnection var3) throws SQLException {
        super(var1, var2, var3);
    }

    public Datum toDatum(Object var1, OracleConnection var2) throws SQLException {
        if (var1 != null) {
            if (var1 instanceof OPAQUE) {
                return (OPAQUE)var1;
            } else {
                OpaqueDescriptor var3 = this.createOpaqueDescriptor();
                return new OPAQUE(var3, this.connection, var1);
            }
        } else {
            return null;
        }
    }

    public int getTypeCode() {
        return 2007;
    }

    public boolean isInHierarchyOf(OracleType var1) throws SQLException {
        if (var1 == null) {
            return false;
        } else if (!(var1 instanceof OracleTypeOPAQUE)) {
            return false;
        } else {
            OpaqueDescriptor var2 = (OpaqueDescriptor)var1.getTypeDescriptor();
            return this.descriptor.isInHierarchyOf(var2.getName());
        }
    }

    public boolean isInHierarchyOf(StructDescriptor var1) throws SQLException {
        return false;
    }

    public boolean isObjectType() {
        return false;
    }

    public void parseTDSrec(TDSReader var1) throws SQLException {
        var1.skipBytes(5);
        this.flagBits = var1.readLong();
        this.maxLen = var1.readLong();
    }

    public Datum unlinearize(byte[] var1, long var2, Datum var4, int var5, Map var6) throws SQLException {
        if (var1 == null) {
            return null;
        } else if ((var1[0] & 128) > 0) {
            PickleContext var7 = new PickleContext(var1, var2);
            return this.unpickle81(var7, (OPAQUE)var4, var5, var6);
        } else {
            return null;
        }
    }

    public byte[] linearize(Datum var1) throws SQLException {
        return this.pickle81(var1);
    }

    protected int pickle81(PickleContext var1, Datum var2) throws SQLException {
        OPAQUE var3 = (OPAQUE)var2;
        byte[] var4 = var3.getBytesValue();
        byte var5 = 0;
        int var6 = var5 + var1.writeOpaqueImageHeader(var4.length);
        var6 += var1.writeData(var4);
        return var6;
    }

    OPAQUE unpickle81(PickleContext var1, OPAQUE var2, int var3, Map var4) throws SQLException {
        return this.unpickle81datum(var1, var2, var3);
    }

    protected Object unpickle81rec(PickleContext var1, int var2, Map var3) throws SQLException {
        byte var4 = var1.readByte();
        Object var5 = null;
        if (PickleContext.isElementNull(var4)) {
            return null;
        } else {
            var1.skipRestOfLength(var4);
            switch(var2) {
                case 1:
                    var5 = this.unpickle81datum(var1, (OPAQUE)null);
                    break;
                case 2:
                    var5 = this.unpickle81datum(var1, (OPAQUE)null).toJdbc();
                    break;
                case 3:
                    var5 = new OPAQUE(this.createOpaqueDescriptor(), var1.readDataValue(), this.connection);
                    break;
                case 4:
                case 5:
                case 6:
                case 7:
                case 8:
                default:
                    SQLException var6 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 1);
                    var6.fillInStackTrace();
                    throw var6;
                case 9:
                    var1.skipDataValue();
            }

            return var5;
        }
    }

    private OPAQUE unpickle81datum(PickleContext var1, OPAQUE var2) throws SQLException {
        return this.unpickle81datum(var1, var2, 1);
    }

    private OPAQUE unpickle81datum(PickleContext var1, OPAQUE var2, int var3) throws SQLException {
        var1.skipBytes(2);
        long var4 = (long)(var1.readLength(true) - 2);
        if (var2 != null) {
            var2.setValue(var1.readBytes((int)var4));
            return var2;
        } else {
            OPAQUE var6 = new OPAQUE(this.createOpaqueDescriptor(), this.connection, var1.readBytes((int)var4));
            if (this.typeNameByUser != null) {
                if (this.typeNameByUser.equals("SYS.XMLTYPE")) {
                    return XMLType.createXML(var6);
                }
            } else if (this.sqlName != null && this.sqlName.getName().equals("SYS.XMLTYPE")) {
                return XMLType.createXML(var6);
            }

            return var6;
        }
    }

    OpaqueDescriptor createOpaqueDescriptor() throws SQLException {
        return this.sqlName == null ? new OpaqueDescriptor(this, this.connection) : OpaqueDescriptor.createDescriptor(this.sqlName, this.connection);
    }

    public long getMaxLength() throws SQLException {
        return this.maxLen;
    }

    public boolean isTrustedLibrary() throws SQLException {
        return (this.flagBits & 1L) != 0L;
    }

    public boolean isModeledInC() throws SQLException {
        return (this.flagBits & 2L) != 0L;
    }

    public boolean isUnboundedSized() throws SQLException {
        return (this.flagBits & 4L) != 0L;
    }

    public boolean isFixedSized() throws SQLException {
        return (this.flagBits & 8L) != 0L;
    }

    private void writeObject(ObjectOutputStream var1) throws IOException {
    }

    private void readObject(ObjectInputStream var1) throws IOException, ClassNotFoundException {
    }

    public void setConnection(OracleConnection var1) throws SQLException {
        this.connection = var1;
    }
}
