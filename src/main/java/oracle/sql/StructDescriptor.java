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
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.SQLInput;
import java.sql.SQLOutput;
import java.util.Map;
import oracle.jdbc.OracleConnection;
import oracle.jdbc.OracleTypeMetaData.Kind;
import oracle.jdbc.driver.DatabaseError;
import oracle.jdbc.internal.OracleTypeMetaData.Struct;
import oracle.jdbc.oracore.OracleType;
import oracle.jdbc.oracore.OracleTypeADT;

/** @deprecated */
public class StructDescriptor extends TypeDescriptor implements Struct, Serializable {
    static final boolean DEBUG = false;
    static final long serialVersionUID = 1013921343538311063L;
    private static final String _Copyright_2007_Oracle_All_Rights_Reserved_ = null;
    public static final String BUILD_DATE = "Thu_Apr_04_15:09:24_PDT_2013";
    public static final boolean TRACE = false;

    public static StructDescriptor createDescriptor(String var0, Connection var1) throws SQLException {
        return createDescriptor(var0, var1, false, false);
    }

    public static StructDescriptor createDescriptor(String var0, Connection var1, boolean var2, boolean var3) throws SQLException {
        if (var0 != null && var0.length() != 0 && var1 != null) {
            SQLName var8 = new SQLName(var0, (OracleConnection)var1);
            String var5 = var8.getName();
            StructDescriptor var6 = null;
            if (!var3) {
                var6 = (StructDescriptor)((OracleConnection)var1).getDescriptor(var5);
                if (var6 == null) {
                    short var7 = ((OracleConnection)var1).physicalConnectionWithin().getVersionNumber();
                    if (var7 >= 12000) {
                        var6 = new StructDescriptor(var0, var1);
                    } else {
                        var6 = new StructDescriptor(var8, var1);
                    }

                    if (var2) {
                        var6.initNamesRecursively();
                    }

                    ((OracleConnection)var1).putDescriptor(var5, var6);
                }
            }

            return var6;
        } else {
            SQLException var4 = DatabaseError.createSqlException((oracle.jdbc.internal.OracleConnection)null, 60, "Invalid arguments");
            var4.fillInStackTrace();
            throw var4;
        }
    }

    /** @deprecated */
    public static StructDescriptor createDescriptor(SQLName var0, Connection var1, boolean var2, boolean var3) throws SQLException {
        String var4 = var0.getName();
        StructDescriptor var5 = null;
        if (!var3) {
            var5 = (StructDescriptor)((OracleConnection)var1).getDescriptor(var4);
            if (var5 == null) {
                var5 = new StructDescriptor(var0, var1);
                if (var2) {
                    var5.initNamesRecursively();
                }

                ((OracleConnection)var1).putDescriptor(var4, var5);
            }
        }

        return var5;
    }

    /** @deprecated */
    public static StructDescriptor createDescriptor(SQLName var0, Connection var1) throws SQLException {
        return createDescriptor(var0, var1, false, false);
    }

    public static StructDescriptor createDescriptor(OracleTypeADT var0) throws SQLException {
        String var1 = var0.getFullName();
        oracle.jdbc.internal.OracleConnection var2 = var0.getConnection();
        StructDescriptor var3 = (StructDescriptor)var2.getDescriptor(var1);
        if (var3 == null) {
            SQLName var4 = new SQLName(var0.getSchemaName(), var0.getSimpleName(), var0.getConnection());
            var3 = new StructDescriptor(var4, var0, var2);
            var2.putDescriptor(var1, var3);
        }

        return var3;
    }

    /** @deprecated */
    public static StructDescriptor createDescriptor(SQLName var0, byte[] var1, int var2, byte[] var3, oracle.jdbc.internal.OracleConnection var4) throws SQLException {
        OracleTypeADT var5 = new OracleTypeADT(var0, var1, var2, var3, var4);
        return new StructDescriptor(var0, var5, var4);
    }

    public StructDescriptor(OracleTypeADT var1, Connection var2) throws SQLException {
        super((short)108, var1, var2);
    }

    public StructDescriptor(String var1, Connection var2) throws SQLException {
        super((short)108, var1, var2);
        this.initPickler();
    }

    public StructDescriptor(SQLName var1, Connection var2) throws SQLException {
        super((short)108, var1, var2);
        this.initPickler();
    }

    public StructDescriptor(SQLName var1, OracleTypeADT var2, Connection var3) throws SQLException {
        super((short)108, var1, var2, var3);
        this.toid = var2.getTOID();
    }

    StructDescriptor(byte[] var1, int var2, Connection var3) throws SQLException {
        super((short)108);
        this.toid = var1;
        this.toidVersion = var2;
        this.setPhysicalConnectionOf(var3);
        this.initPickler();
    }

    StructDescriptor(AttributeDescriptor[] var1, Connection var2) throws SQLException {
        super((short)108);
        this.attributesDescriptor = var1;
        this.setPhysicalConnectionOf(var2);
        this.isTransient = true;
        this.initPickler();
        this.isInstanciable = Boolean.TRUE;
    }

    private void initPickler() throws SQLException {
        String var1 = null;

        try {
            if (this.isTransient) {
                var1 = this.getName();
                this.pickler = new OracleTypeADT(this.attributesDescriptor, this.connection);
            } else {
                if (this.typeNameByUser == null) {
                    var1 = this.getName();
                } else {
                    var1 = this.typeNameByUser;
                }

                this.pickler = new OracleTypeADT(var1, this.connection);
                ((OracleTypeADT)this.pickler).init(this.connection);
                this.toid = ((OracleTypeADT)this.pickler).getTOID();
            }

            this.pickler.setDescriptor(this);
        } catch (Exception var4) {
            if (var4 instanceof SQLException) {
                throw (SQLException)var4;
            } else {
                SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 60, "Unable to resolve type \"" + var1 + "\"");
                var3.fillInStackTrace();
                throw var3;
            }
        }
    }

    public Kind getKind() {
        return Kind.STRUCT;
    }

    public int getTypeCode() throws SQLException {
        int var1 = this.getOracleTypeADT().getTypeCode();
        return var1;
    }

    public int getTypeVersion() throws SQLException {
        int var1 = this.getOracleTypeADT().getTypeVersion();
        return var1;
    }

    void setAttributesDescriptor(AttributeDescriptor[] var1) {
        this.attributesDescriptor = var1;
    }

    public AttributeDescriptor[] getAttributesDescriptor() {
        return this.attributesDescriptor;
    }

    byte[] toBytes(STRUCT var1, boolean var2) throws SQLException {
        byte[] var3 = var1.shareBytes();
        if (var3 == null) {
            if (var1.datumArray != null) {
                var3 = this.pickler.linearize(var1);
                if (!var2) {
                    var1.setShareBytes((byte[])null);
                }
            } else {
                if (var1.objectArray == null) {
                    SQLException var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 1);
                    var4.fillInStackTrace();
                    throw var4;
                }

                var1.datumArray = this.toOracleArray(var1.objectArray);
                var3 = this.pickler.linearize(var1);
                if (!var2) {
                    var1.datumArray = null;
                    var1.setShareBytes((byte[])null);
                }
            }
        } else if (var1.imageLength != 0L && (var1.imageOffset != 0L || var1.imageLength != (long)var3.length)) {
            byte[] var5 = new byte[(int)var1.imageLength];
            System.arraycopy(var3, (int)var1.imageOffset, var5, 0, (int)var1.imageLength);
            var1.setImage(var5, 0L, 0L);
            var3 = var5;
        }

        return var3;
    }

    Datum[] toOracleArray(STRUCT var1, boolean var2) throws SQLException {
        Datum[] var3 = var1.datumArray;
        Datum[] var4 = null;
        if (var3 == null) {
            if (var1.objectArray != null) {
                var3 = this.toOracleArray(var1.objectArray);
            } else {
                if (var1.shareBytes() == null) {
                    SQLException var5 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 1);
                    var5.fillInStackTrace();
                    throw var5;
                }

                if ((var1.shareBytes()[0] & 128) <= 0 && ((OracleTypeADT)this.pickler).isEmbeddedADT()) {
                    this.pickler = OracleTypeADT.shallowClone((OracleTypeADT)this.pickler);
                }

                this.pickler.unlinearize(var1.shareBytes(), var1.imageOffset, var1, 1, (Map)null);
                var3 = var1.datumArray;
                if (!var2) {
                    var1.datumArray = null;
                }
            }
        }

        if (var2) {
            var1.datumArray = var3;
            var4 = (Datum[])((Datum[])var3.clone());
        } else {
            var4 = var3;
        }

        return var4;
    }

    Object[] toArray(STRUCT var1, Map var2, boolean var3) throws SQLException {
        Object[] var4 = null;
        if (var1.objectArray == null) {
            if (var1.datumArray != null) {
                var4 = new Object[var1.datumArray.length];

                for(int var5 = 0; var5 < var1.datumArray.length; ++var5) {
                    if (var1.datumArray[var5] != null) {
                        if (var1.datumArray[var5] instanceof STRUCT) {
                            var4[var5] = ((STRUCT)var1.datumArray[var5]).toJdbc(var2);
                        } else {
                            var4[var5] = var1.datumArray[var5].toJdbc();
                        }
                    }
                }
            } else {
                if (var1.shareBytes() == null) {
                    SQLException var6 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 1);
                    var6.fillInStackTrace();
                    throw var6;
                }

                if ((var1.shareBytes()[0] & 128) <= 0 && ((OracleTypeADT)this.pickler).isEmbeddedADT()) {
                    this.pickler = OracleTypeADT.shallowClone((OracleTypeADT)this.pickler);
                }

                this.pickler.unlinearize(var1.shareBytes(), var1.imageOffset, var1, 2, var2);
                var4 = var1.objectArray;
                var1.objectArray = null;
            }
        } else {
            var4 = (Object[])((Object[])var1.objectArray.clone());
        }

        return var4;
    }

    public int getLength() throws SQLException {
        return this.getFieldTypes().length;
    }

    public OracleTypeADT getOracleTypeADT() throws SQLException {
        if (this.pickler == null) {
            this.initPickler();
        }

        OracleTypeADT var1 = (OracleTypeADT)this.pickler;
        return var1;
    }

    private OracleType[] getFieldTypes() throws SQLException {
        return ((OracleTypeADT)this.pickler).getAttrTypes();
    }

    public SQLInput toJdbc2SQLInput(STRUCT var1, Map var2) throws SQLException {
        return new OracleJdbc2SQLInput(this.toOracleArray(var1, false), var2, this.connection);
    }

    public SQLOutput toJdbc2SQLOutput() throws SQLException {
        return new OracleSQLOutput(this, this.connection);
    }

    public Datum[] toOracleArray(Object[] var1) throws SQLException {
        Datum[] var2 = null;
        if (var1 != null) {
            OracleType[] var3 = this.getFieldTypes();
            int var4 = var3.length;
            if (var1.length != var4) {
                SQLException var7 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 49, (Object)null);
                var7.fillInStackTrace();
                throw var7;
            }

            var2 = new Datum[var4];
            oracle.jdbc.internal.OracleConnection var5 = this.connection;

            for(int var6 = 0; var6 < var4; ++var6) {
                var2[var6] = var3[var6].toDatumInternal(var1[var6], var5);
            }
        }

        return var2;
    }

    public Datum[] toOracleArray(Map var1) throws SQLException {
        Datum[] var2 = null;
        int var3 = 0;
        if (var1 != null) {
            OracleType[] var4 = this.getFieldTypes();
            int var5 = var4.length;
            int var6 = var1.size();
            var2 = new Datum[var5];
            oracle.jdbc.internal.OracleConnection var7 = this.connection;

            for(int var8 = 0; var8 < var5; ++var8) {
                Object var9 = var1.get(((OracleTypeADT)this.pickler).getAttributeName(var8 + 1));
                var2[var8] = var4[var8].toDatum(var9, var7);
                if (var9 != null || var1.containsKey(((OracleTypeADT)this.pickler).getAttributeName(var8 + 1))) {
                    ++var3;
                }
            }

            if (var3 < var6) {
                SQLException var10 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 68, (Object)null);
                var10.fillInStackTrace();
                throw var10;
            }
        }

        return var2;
    }

    public ResultSetMetaData getMetaData() throws SQLException {
        return this.connection.newStructMetaData(this);
    }

    public boolean isFinalType() throws SQLException {
        return this.getOracleTypeADT().isFinalType();
    }

    public boolean isSubtype() throws SQLException {
        return this.getOracleTypeADT().isSubType();
    }

    public boolean isInHierarchyOf(String var1) throws SQLException {
        StructDescriptor var2 = this;
        String var3 = this.getName();
        boolean var4 = false;
        if (var1.equals(var3)) {
            var4 = true;
        } else {
            while(true) {
                var3 = var2.getSupertypeName();
                if (var3 == null) {
                    var4 = false;
                    break;
                }

                if (var1.equals(var3)) {
                    var4 = true;
                    break;
                }

                var2 = createDescriptor((String)var3, this.connection);
            }
        }

        return var4;
    }

    public boolean isInstantiable() throws SQLException {
        if (this.isInstanciable == null) {
            this.isInstanciable = this.getOracleTypeADT().isInstanciable();
        }

        return this.isInstanciable;
    }

    public boolean isJavaObject() throws SQLException {
        return this.getOracleTypeADT().isJavaObject();
    }

    public String getSupertypeName() throws SQLException {
        String var1 = null;
        if (this.isSubtype()) {
            if (this.supertype == null) {
                this.supertype = this.getOracleTypeADT().getSuperTypeName();
            }

            var1 = this.supertype;
        }

        return var1;
    }

    public int getLocalAttributeCount() throws SQLException {
        int var1;
        if (!this.isSubtype()) {
            var1 = this.getOracleTypeADT().getAttrTypes().length;
        } else {
            if (this.numLocalAttrs == -1) {
                this.numLocalAttrs = this.getOracleTypeADT().getNumberOfLocalAttributes();
            }

            var1 = this.numLocalAttrs;
        }

        return var1;
    }

    public String[] getSubtypeNames() throws SQLException {
        if (this.subtypes == null) {
            this.subtypes = this.getOracleTypeADT().getSubtypeNames();
        }

        return this.subtypes;
    }

    public String getJavaClassName() throws SQLException {
        String var1 = null;
        if (this.isJavaObject()) {
            var1 = getJavaObjectClassName(this.connection, this);
        }

        return var1;
    }

    public String getAttributeJavaName(int var1) throws SQLException {
        String var2 = null;
        if (this.isJavaObject()) {
            if (this.attrJavaNames == null) {
                this.initMetaData3();
            }

            var2 = this.attrJavaNames[var1];
        }

        return var2;
    }

    public String[] getAttributeJavaNames() throws SQLException {
        String[] var1 = null;
        if (this.isJavaObject()) {
            if (this.attrJavaNames == null) {
                this.initMetaData3();
            }

            var1 = this.attrJavaNames;
        } else {
            var1 = new String[0];
        }

        return var1;
    }

    public String getLanguage() throws SQLException {
        String var1 = null;
        if (this.isJavaObject()) {
            var1 = "JAVA";
        } else {
            var1 = "SQL";
        }

        return var1;
    }

    public static String getJavaObjectClassName(Connection var0, StructDescriptor var1) throws SQLException {
        return getJavaObjectClassName(var0, var1.getSchemaName(), var1.getTypeName());
    }

    public static String getJavaObjectClassName(Connection var0, String var1, String var2) throws SQLException {
        PreparedStatement var3 = null;
        ResultSet var4 = null;
        String var5 = null;
        oracle.jdbc.internal.OracleConnection var6 = ((OracleConnection)var0).physicalConnectionWithin();
        ((oracle.jdbc.internal.OracleConnection)var6).beginNonRequestCalls();

        try {
            var3 = var0.prepareStatement("select external_name from all_sqlj_types where owner = :1 and type_name = :2");
            var3.setString(1, var1);
            var3.setString(2, var2);
            var4 = var3.executeQuery();
            if (!var4.next()) {
                SQLException var7 = DatabaseError.createSqlException((oracle.jdbc.internal.OracleConnection)null, 100);
                var7.fillInStackTrace();
                throw var7;
            }

            var5 = var4.getString(1);
        } catch (SQLException var11) {
        } finally {
            if (var4 != null) {
                var4.close();
            }

            if (var3 != null) {
                var3.close();
            }

            ((oracle.jdbc.internal.OracleConnection)var6).endNonRequestCalls();
        }

        return var5;
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

        String var10 = var3 + "  ";
        var1.append(var3);
        var1.append(this.getTypeName());
        var1.append("\n");
        var1.append(var3);
        var1.append("Subtype=" + this.getOracleTypeADT().isSubType());
        var1.append(" JavaObject=" + this.getOracleTypeADT().isJavaObject());
        var1.append(" FinalType=" + this.getOracleTypeADT().isFinalType());
        var1.append("\n");
        ResultSetMetaData var5 = this.getMetaData();
        int var6 = var5.getColumnCount();

        for(int var7 = 0; var7 < var6; ++var7) {
            int var8 = var5.getColumnType(var7 + 1);
            if (var8 != 2002 && var8 != 2008) {
                if (var8 == 2003) {
                    ArrayDescriptor var11 = ArrayDescriptor.createDescriptor(var5.getColumnTypeName(var7 + 1), this.connection);
                    var11.descType(var1, var2 + 1);
                } else if (var8 == 2007) {
                    OpaqueDescriptor var12 = OpaqueDescriptor.createDescriptor(var5.getColumnTypeName(var7 + 1), this.connection);
                    var12.descType(var1, var2 + 1);
                } else {
                    var1.append(var10);
                    var1.append(var5.getColumnTypeName(var7 + 1));
                    var1.append("\n");
                }
            } else {
                StructDescriptor var9 = createDescriptor((String)var5.getColumnTypeName(var7 + 1), this.connection);
                var9.descType(var1, var2 + 1);
            }
        }

        return var1.substring(0, var1.length());
    }

    public byte[] toBytes(Object[] var1) throws SQLException {
        Datum[] var2 = this.toOracleArray(var1);
        return this.toBytes(var2);
    }

    /** @deprecated */
    public byte[] toBytes(Datum[] var1) throws SQLException {
        STRUCT var2 = new STRUCT(this, (byte[])null, this.connection);
        var2.setDatumArray(var1);
        return this.pickler.linearize(var2);
    }

    public Datum[] toArray(Object[] var1) throws SQLException {
        return this.toOracleArray(var1);
    }

    public Datum[] toArray(byte[] var1) throws SQLException {
        STRUCT var2 = new STRUCT(this, var1, this.connection);
        return this.toOracleArray(var2, false);
    }

    private void initMetaData3() throws SQLException {
        synchronized(this.connection) {
            if (this.attrJavaNames == null) {
                this.connection.beginNonRequestCalls();
                String[] var2 = null;
                PreparedStatement var3 = null;
                ResultSet var4 = null;

                try {
                    var3 = this.connection.prepareStatement("select EXTERNAL_ATTR_NAME, ATTR_NO from all_sqlj_type_attrs where owner = :1 and type_name = :2");
                    var3.setString(1, this.getSchemaName());
                    var3.setString(2, this.getTypeName());
                    var4 = var3.executeQuery();
                    var2 = new String[this.getOracleTypeADT().getAttrTypes().length];

                    for(int var5 = 0; var4.next(); ++var5) {
                        var2[var4.getInt(2) - 1] = var4.getString(1);
                    }
                } finally {
                    if (var4 != null) {
                        var4.close();
                    }

                    if (var3 != null) {
                        var3.close();
                    }

                    this.connection.endNonRequestCalls();
                }

                this.attrJavaNames = var2;
            }

        }
    }

    String tagName() {
        return "StructDescriptor";
    }

    private void writeObject(ObjectOutputStream var1) throws IOException {
    }

    private void readObject(ObjectInputStream var1) throws IOException, ClassNotFoundException {
    }
}
