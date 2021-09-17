//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package oracle.sql;

import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Map;
import oracle.jdbc.OracleDataFactory;
import oracle.jdbc.OracleTypeMetaData;
import oracle.jdbc.driver.DatabaseError;
import oracle.jdbc.internal.OracleOpaque;
import oracle.xdb.XMLType;

/** @deprecated */
public class OPAQUE extends DatumWithConnection implements OracleOpaque {
    OpaqueDescriptor descriptor;
    byte[] value;
    long imageOffset;
    long imageLength;
    protected Object acProxy;
    private static final String _Copyright_2007_Oracle_All_Rights_Reserved_ = null;
    public static final String BUILD_DATE = "Thu_Apr_04_15:09:24_PDT_2013";
    public static final boolean TRACE = false;

    public OPAQUE(OpaqueDescriptor var1, Connection var2, Object var3) throws SQLException {
        SQLException var4;
        if (var1 != null) {
            this.descriptor = var1;
            if (var2 != null) {
                this.setPhysicalConnectionOf(var2);
            }

            if (var3 instanceof ANYDATA) {
                ANYDATA var6 = (ANYDATA)var3;
                byte[] var5 = new byte[var6.getImageSize()];
                var6.pickle(var5, 0);
                this.value = var5;
            } else {
                if (!(var3 instanceof byte[])) {
                    var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 59);
                    var4.fillInStackTrace();
                    throw var4;
                }

                this.value = (byte[])((byte[])var3);
            }

        } else {
            var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 61, "OPAQUE");
            var4.fillInStackTrace();
            throw var4;
        }
    }

    public OPAQUE(OpaqueDescriptor var1, byte[] var2, Connection var3) throws SQLException {
        super(var2);
        this.setPhysicalConnectionOf(var3);
        this.descriptor = var1;
        this.value = null;
    }

    public String getSQLTypeName() throws SQLException {
        return this.descriptor.getName();
    }

    public String stringValue() throws SQLException {
        String var1 = "OPAQUE";

        try {
            String var2 = null;
            Object var3 = this.toJdbc();
            Class var4 = var3.getClass();
            if (!var4.equals(this.getClass())) {
                Method var5;
                try {
                    var5 = var4.getMethod("getStringVal");
                    if (var5.getDeclaringClass().isAssignableFrom(var4)) {
                        var2 = (String)var5.invoke(var3);
                    }
                } catch (Exception var7) {
                }

                if (var2 == null) {
                    try {
                        var5 = var4.getMethod("stringValue");
                        if (var5.getDeclaringClass().isAssignableFrom(var4)) {
                            var2 = (String)var5.invoke(var3);
                        }
                    } catch (Exception var6) {
                    }
                }

                if (var2 != null) {
                    var1 = var1 + "(" + var2 + ")";
                }
            }
        } catch (Exception var8) {
        }

        return var1;
    }

    public OracleTypeMetaData getOracleMetaData() throws SQLException {
        return this.getDescriptor();
    }

    public OpaqueDescriptor getDescriptor() throws SQLException {
        return this.descriptor;
    }

    public void setDescriptor(OpaqueDescriptor var1) {
        this.descriptor = var1;
    }

    public byte[] toBytes() throws SQLException {
        return this.descriptor.toBytes(this, false);
    }

    public Object getValue() throws SQLException {
        return this.descriptor.toValue(this, false);
    }

    public byte[] getBytesValue() throws SQLException {
        return this.descriptor.toValue(this, false);
    }

    public void setValue(byte[] var1) throws SQLException {
        this.value = var1;
    }

    public boolean isConvertibleTo(Class var1) {
        return false;
    }

    public Object makeJdbcArray(int var1) {
        return new Object[var1];
    }

    public Map getMap() {
        try {
            return this.getInternalConnection().getTypeMap();
        } catch (SQLException var2) {
            return null;
        }
    }

    public Object toJdbc() throws SQLException {
        Map var1 = this.getMap();
        return this.toJdbc(var1);
    }

    public Object toJdbc(Map var1) throws SQLException {
        Object var2 = this;
        if (var1 != null) {
            Class var3 = this.descriptor.getClass(var1);
            if (var3 != null) {
                var2 = this.toClass(var3, var1);
            } else if (this.getSQLTypeName().compareTo("SYS.XMLTYPE") == 0) {
                return XMLType.createXML((OPAQUE)this);
            }
        }

        return var2;
    }

    public Object toClass(Class var1) throws SQLException {
        return this.toClass(var1, this.getMap());
    }

    public Object toClass(Class var1, Map var2) throws SQLException {
        Object var3 = null;

        SQLException var5;
        try {
            if (var1 != null && var1 != OPAQUE.class) {
                Object var4 = null;
                Object var9 = var1.newInstance();
                if (var9 instanceof ORADataFactory) {
                    ORADataFactory var6 = (ORADataFactory)var9;
                    var4 = var6.create(this, 2007);
                } else {
                    if (!(var9 instanceof OracleDataFactory)) {
                        SQLException var11 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 49, this.descriptor.getName());
                        var11.fillInStackTrace();
                        throw var11;
                    }

                    OracleDataFactory var10 = (OracleDataFactory)var9;
                    var4 = var10.create(this, 2007);
                }

                var3 = var4;
            } else {
                var3 = this;
            }

            return var3;
        } catch (InstantiationException var7) {
            var5 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 49, "InstantiationException: " + var7.getMessage());
            var5.fillInStackTrace();
            throw var5;
        } catch (IllegalAccessException var8) {
            var5 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 49, "IllegalAccessException: " + var8.getMessage());
            var5.fillInStackTrace();
            throw var5;
        }
    }

    public void setImage(byte[] var1, long var2, long var4) throws SQLException {
        this.setShareBytes(var1);
        this.imageOffset = var2;
        this.imageLength = var4;
    }

    public void setImageLength(long var1) throws SQLException {
        this.imageLength = var1;
    }

    public long getImageOffset() {
        return this.imageOffset;
    }

    public long getImageLength() {
        return this.imageLength;
    }

    public Connection getJavaSqlConnection() throws SQLException {
        return super.getJavaSqlConnection();
    }

    public void setACProxy(Object var1) {
        this.acProxy = var1;
    }

    public Object getACProxy() {
        return this.acProxy;
    }
}
