//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package oracle.sql;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Map;
import oracle.jdbc.OracleConnection;
import oracle.jdbc.OracleTypeMetaData.Kind;
import oracle.jdbc.driver.DatabaseError;
import oracle.jdbc.internal.OracleTypeMetaData.Opaque;
import oracle.jdbc.oracore.OracleTypeADT;
import oracle.jdbc.oracore.OracleTypeOPAQUE;

/** @deprecated */
public class OpaqueDescriptor extends TypeDescriptor implements Opaque, Serializable {
    static final boolean DEBUG = false;
    static final long serialVersionUID = 1013921343538311063L;
    private static final String _Copyright_2007_Oracle_All_Rights_Reserved_ = null;
    public static final String BUILD_DATE = "Thu_Apr_04_15:09:24_PDT_2013";
    public static final boolean TRACE = false;

    public OpaqueDescriptor(String var1, Connection var2) throws SQLException {
        super((short)58, var1, var2);
        this.initPickler();
    }

    public OpaqueDescriptor(SQLName var1, Connection var2) throws SQLException {
        super((short)58, var1, var2);
        this.initPickler();
    }

    public OpaqueDescriptor(SQLName var1, OracleTypeOPAQUE var2, Connection var3) throws SQLException {
        super((short)58, var1, var2, var3);
    }

    public OpaqueDescriptor(OracleTypeADT var1, Connection var2) throws SQLException {
        super((short)58, var1, var2);
    }

    OpaqueDescriptor(byte[] var1, int var2, Connection var3) throws SQLException {
        super((short)108);
        this.toid = var1;
        this.toidVersion = var2;
        this.setPhysicalConnectionOf(var3);
        this.initPickler();
    }

    public static OpaqueDescriptor createDescriptor(String var0, Connection var1) throws SQLException {
        if (var0 != null && var0.length() != 0) {
            SQLName var6 = new SQLName(var0, (OracleConnection)var1);
            String var3 = var6.getName();
            OpaqueDescriptor var4 = null;
            if (var1 != null) {
                var4 = (OpaqueDescriptor)((OracleConnection)var1).getDescriptor(var3);
            }

            if (var4 == null) {
                OracleTypeOPAQUE var5;
                if (var3.equals("SYS.ANYTYPE")) {
                    var5 = new OracleTypeOPAQUE(TypeDescriptor.ANYTYPETOID, 1, 0, (short)0, var3, 7L);
                    var4 = new OpaqueDescriptor(var6, var5, var1);
                } else if (var3.equals("SYS.ANYDATA")) {
                    var5 = new OracleTypeOPAQUE(TypeDescriptor.ANYDATATOID, 1, 0, (short)0, var3, 7L);
                    var4 = new OpaqueDescriptor(var6, var5, var1);
                } else {
                    short var7 = ((OracleConnection)var1).physicalConnectionWithin().getVersionNumber();
                    if (var7 >= 12000) {
                        var4 = new OpaqueDescriptor(var0, var1);
                    } else {
                        var4 = new OpaqueDescriptor(var6, var1);
                    }
                }

                if (var1 != null) {
                    ((OracleConnection)var1).putDescriptor(var3, var4);
                }
            }

            return var4;
        } else {
            SQLException var2 = DatabaseError.createSqlException((oracle.jdbc.internal.OracleConnection)null, 60, "Invalid argument,'name' shouldn't be null nor an empty string and 'conn' should not be null");
            var2.fillInStackTrace();
            throw var2;
        }
    }

    public static OpaqueDescriptor createDescriptor(SQLName var0, Connection var1) throws SQLException {
        String var2 = var0.getName();
        OpaqueDescriptor var3 = null;
        if (var1 != null) {
            var3 = (OpaqueDescriptor)((OracleConnection)var1).getDescriptor(var2);
        }

        if (var3 == null) {
            OracleTypeOPAQUE var4;
            if (var2.equals("SYS.ANYTYPE")) {
                var4 = new OracleTypeOPAQUE(TypeDescriptor.ANYTYPETOID, 1, 0, (short)0, var2, 7L);
                var3 = new OpaqueDescriptor(var0, var4, var1);
            } else if (var2.equals("SYS.ANYDATA")) {
                var4 = new OracleTypeOPAQUE(TypeDescriptor.ANYDATATOID, 1, 0, (short)0, var2, 7L);
                var3 = new OpaqueDescriptor(var0, var4, var1);
            } else {
                var3 = new OpaqueDescriptor(var0, var1);
            }

            if (var1 != null) {
                ((OracleConnection)var1).putDescriptor(var2, var3);
            }
        }

        return var3;
    }

    public Kind getKind() {
        return Kind.OPAQUE;
    }

    private void initPickler() throws SQLException {
        try {
            this.pickler = new OracleTypeADT(this.getName(), this.connection);
            ((OracleTypeADT)this.pickler).init(this.connection);
            this.pickler = (OracleTypeOPAQUE)((OracleTypeADT)this.pickler).cleanup();
            this.pickler.setDescriptor(this);
        } catch (Exception var3) {
            if (var3 instanceof SQLException) {
                throw (SQLException)var3;
            } else {
                SQLException var2 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 60, "Unable to resolve type \"" + this.getName() + "\"");
                var2.fillInStackTrace();
                throw var2;
            }
        }
    }

    byte[] toBytes(OPAQUE var1, boolean var2) throws SQLException {
        Object var3 = null;
        byte[] var7;
        if (var1.shareBytes() != null) {
            var7 = var1.shareBytes();
        } else {
            try {
                var7 = this.pickler.linearize(var1);
            } finally {
                if (!var2) {
                    var1.setShareBytes((byte[])null);
                }

            }
        }

        return var7;
    }

    byte[] toValue(OPAQUE var1, boolean var2) throws SQLException {
        Object var3 = null;
        byte[] var7;
        if (var1.value != null) {
            var7 = var1.value;
        } else {
            try {
                this.pickler.unlinearize(var1.shareBytes(), 0L, var1, 1, (Map)null);
                var7 = var1.value;
            } finally {
                if (!var2) {
                    var1.value = null;
                }

            }
        }

        return var7;
    }

    public int getTypeCode() throws SQLException {
        return (this.sqlName == null || !"SYS.XMLTYPE".equalsIgnoreCase(this.sqlName.getName())) && (this.typeNameByUser == null || !"SYS.XMLTYPE".equals(this.typeNameByUser)) ? 2007 : 2009;
    }

    public boolean isInHierarchyOf(String var1) throws SQLException {
        String var3 = this.getName();
        return var1.equals(var3);
    }

    public long getMaxLength() throws SQLException {
        long var1 = this.hasUnboundedSize() ? 0L : ((OracleTypeOPAQUE)this.pickler).getMaxLength();
        return var1;
    }

    public boolean isTrustedLibrary() throws SQLException {
        return ((OracleTypeOPAQUE)this.pickler).isTrustedLibrary();
    }

    public boolean isModeledInC() throws SQLException {
        return ((OracleTypeOPAQUE)this.pickler).isModeledInC();
    }

    public boolean hasUnboundedSize() throws SQLException {
        return ((OracleTypeOPAQUE)this.pickler).isUnboundedSized();
    }

    public boolean hasFixedSize() throws SQLException {
        return ((OracleTypeOPAQUE)this.pickler).isFixedSized();
    }

    public String descType() throws SQLException {
        StringBuffer var1 = new StringBuffer();
        return this.descType(var1, 0);
    }

    String descType(StringBuffer var1, int var2) throws SQLException {
        String var3 = "";

        for(int var4 = 0; var4 < var2; ++var4) {
            var3 = var3 + "  ";
        }

        String var5 = var3 + "  ";
        var1.append(var3);
        var1.append(this.getTypeName());
        var1.append(" maxLen=" + this.getMaxLength() + " isTrusted=" + this.isTrustedLibrary() + " hasUnboundedSize=" + this.hasUnboundedSize() + " hasFixedSize=" + this.hasFixedSize());
        var1.append("\n");
        return var1.toString();
    }

    private void writeObject(ObjectOutputStream var1) throws IOException {
    }

    private void readObject(ObjectInputStream var1) throws IOException, ClassNotFoundException {
    }
}
