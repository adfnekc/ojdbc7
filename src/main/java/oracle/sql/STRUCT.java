//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package oracle.sql;

import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.sql.Connection;
import java.sql.ResultSetMetaData;
import java.sql.SQLData;
import java.sql.SQLException;
import java.sql.SQLOutput;
import java.sql.Struct;
import java.util.Hashtable;
import java.util.Map;
import oracle.jdbc.OracleConnection;
import oracle.jdbc.OracleData;
import oracle.jdbc.OracleDataFactory;
import oracle.jdbc.OracleTypeMetaData;
import oracle.jdbc.driver.DatabaseError;
import oracle.jdbc.internal.OracleStruct;
import oracle.jdbc.proxy.ProxyFactory;
import oracle.jdbc.proxy._Proxy_;

/** @deprecated */
public class STRUCT extends DatumWithConnection implements OracleStruct {
    StructDescriptor descriptor;
    Datum[] datumArray;
    Object[] objectArray;
    boolean enableLocalCache = false;
    long imageOffset;
    long imageLength;
    Object acProxy;
    private static final String _Copyright_2007_Oracle_All_Rights_Reserved_ = null;
    public static final String BUILD_DATE = "Thu_Apr_04_15:09:24_PDT_2013";
    public static final boolean TRACE = false;

    public STRUCT(StructDescriptor var1, Connection var2, Object[] var3) throws SQLException {
        assertNotNull(var1);
        this.descriptor = var1;
        assertNotNull(var2);
        SQLException var4;
        if (!var1.getInternalConnection().isDescriptorSharable(((OracleConnection)var2).physicalConnectionWithin())) {
            var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 1, "Cannot construct STRUCT instance,invalid connection");
            var4.fillInStackTrace();
            throw var4;
        } else {
            var1.setConnection(var2);
            if (!this.descriptor.isInstantiable()) {
                var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 1, "Cannot construct STRUCT instance for a non-instantiable object type");
                var4.fillInStackTrace();
                throw var4;
            } else {
                this.setPhysicalConnectionOf(var2);
                if (var3 != null) {
                    this.datumArray = this.descriptor.toArray(var3);
                } else {
                    this.datumArray = new Datum[this.descriptor.getLength()];
                }

            }
        }
    }

    public STRUCT(StructDescriptor var1, Connection var2, Map var3) throws SQLException {
        assertNotNull(var1);
        this.descriptor = var1;
        assertNotNull(var2);
        SQLException var4;
        if (!var1.getInternalConnection().isDescriptorSharable(((OracleConnection)var2).physicalConnectionWithin())) {
            var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 1, "Cannot construct STRUCT instance,invalid connection");
            var4.fillInStackTrace();
            throw var4;
        } else {
            var1.setConnection(var2);
            if (!this.descriptor.isInstantiable()) {
                var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 1, "Cannot construct STRUCT instance for a non-instantiable object type");
                var4.fillInStackTrace();
                throw var4;
            } else {
                this.setPhysicalConnectionOf(var2);
                this.datumArray = this.descriptor.toOracleArray(var3);
            }
        }
    }

    public STRUCT(StructDescriptor var1, byte[] var2, Connection var3) throws SQLException {
        super(var2);
        assertNotNull(var1);
        this.descriptor = var1;
        assertNotNull(var3);
        if (!var1.getInternalConnection().isDescriptorSharable(((OracleConnection)var3).physicalConnectionWithin())) {
            SQLException var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 1, "Cannot construct STRUCT instance,invalid connection");
            var4.fillInStackTrace();
            throw var4;
        } else {
            var1.setConnection(var3);
            this.setPhysicalConnectionOf(var3);
            this.datumArray = null;
        }
    }

    public String getSQLTypeName() throws SQLException {
        synchronized(this.getInternalConnection()) {
            return this.descriptor.getName();
        }
    }

    public Object[] getAttributes() throws SQLException {
        synchronized(this.getInternalConnection()) {
            Object[] var2 = this.getAttributes(this.getMap());
            return var2;
        }
    }

    public Object[] getAttributes(Map var1) throws SQLException {
        synchronized(this.getInternalConnection()) {
            return this.descriptor.toArray(this, var1, this.enableLocalCache);
        }
    }

    public OracleTypeMetaData getOracleMetaData() throws SQLException {
        return this.getDescriptor();
    }

    public StructDescriptor getDescriptor() throws SQLException {
        return this.descriptor;
    }

    public void setDescriptor(StructDescriptor var1) {
        this.descriptor = var1;
    }

    public Datum[] getOracleAttributes() throws SQLException {
        synchronized(this.getInternalConnection()) {
            return this.descriptor.toOracleArray(this, this.enableLocalCache);
        }
    }

    public Map getMap() {
        Map var1 = null;

        try {
            var1 = this.getInternalConnection().getTypeMap();
        } catch (SQLException var3) {
        }

        return var1;
    }

    public byte[] toBytes() throws SQLException {
        synchronized(this.getInternalConnection()) {
            return this.descriptor.toBytes(this, this.enableLocalCache);
        }
    }

    public void setDatumArray(Datum[] var1) {
        try {
            this.datumArray = var1 == null ? new Datum[this.descriptor.getLength()] : var1;
        } catch (SQLException var3) {
        }

    }

    public void setObjArray(Object[] var1) throws SQLException {
        synchronized(this.getInternalConnection()) {
            this.objectArray = var1 == null ? new Object[0] : var1;
        }
    }

    public static STRUCT toSTRUCT(Object var0, OracleConnection var1) throws SQLException {
        STRUCT var2 = null;
        if (var0 != null) {
            if (var0 instanceof STRUCT) {
                var2 = (STRUCT)var0;
            } else if (var0 instanceof ORAData) {
                var2 = (STRUCT)((ORAData)var0).toDatum(var1);
            } else if (var0 instanceof OracleData) {
                Object var3 = ((OracleData)var0).toJDBCObject(var1);
                if (var3 instanceof _Proxy_) {
                    final _Proxy_ var4 = (_Proxy_)var3;
                    var3 = AccessController.doPrivileged(new PrivilegedAction<Object>() {
                        public Object run() {
                            return ProxyFactory.extractDelegate(var4);
                        }
                    });
                }

                var2 = (STRUCT)((STRUCT)var3);
            } else if (var0 instanceof CustomDatum) {
                var2 = (STRUCT)((oracle.jdbc.internal.OracleConnection)var1).toDatum((CustomDatum)var0);
            } else {
                if (!(var0 instanceof SQLData)) {
                    SQLException var7 = DatabaseError.createSqlException((oracle.jdbc.internal.OracleConnection)null, 59, var0);
                    var7.fillInStackTrace();
                    throw var7;
                }

                SQLData var6 = (SQLData)var0;
                StructDescriptor var8 = StructDescriptor.createDescriptor(var6.getSQLTypeName(), var1);
                SQLOutput var5 = var8.toJdbc2SQLOutput();
                var6.writeSQL(var5);
                var2 = ((OracleSQLOutput)var5).getSTRUCT();
            }
        }

        return var2;
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
            if (var1 != null && var1 != STRUCT.class && var1 != Struct.class) {
                Object var4 = var1.newInstance();
                if (var4 instanceof SQLData) {
                    ((SQLData)var4).readSQL(this.descriptor.toJdbc2SQLInput(this, var2), this.descriptor.getName());
                    var3 = var4;
                } else if (var4 instanceof ORADataFactory) {
                    ORADataFactory var8 = (ORADataFactory)var4;
                    var3 = var8.create(this, 2002);
                } else if (var4 instanceof OracleDataFactory) {
                    OracleDataFactory var9 = (OracleDataFactory)var4;
                    var3 = var9.create(this, 2002);
                } else {
                    if (!(var4 instanceof CustomDatumFactory)) {
                        var5 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 49, this.descriptor.getName());
                        var5.fillInStackTrace();
                        throw var5;
                    }

                    CustomDatumFactory var10 = (CustomDatumFactory)var4;
                    var3 = var10.create(this, 2002);
                }
            } else {
                var3 = this;
            }

            return var3;
        } catch (InstantiationException var6) {
            var5 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 49, "InstantiationException: " + var6.getMessage());
            var5.fillInStackTrace();
            throw var5;
        } catch (IllegalAccessException var7) {
            var5 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 49, "IllegalAccessException: " + var7.getMessage());
            var5.fillInStackTrace();
            throw var5;
        }
    }

    public boolean isConvertibleTo(Class var1) {
        return false;
    }

    public Object makeJdbcArray(int var1) {
        return new Object[var1];
    }

    public void setAutoBuffering(boolean var1) throws SQLException {
        synchronized(this.getInternalConnection()) {
            this.enableLocalCache = var1;
        }
    }

    public boolean getAutoBuffering() throws SQLException {
        synchronized(this.getInternalConnection()) {
            return this.enableLocalCache;
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

    public CustomDatumFactory getFactory(Hashtable var1, String var2) throws SQLException {
        String var3 = this.getSQLTypeName();
        Object var4 = var1.get(var3);
        if (var4 == null) {
            SQLException var5 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 1, "Unable to convert a \"" + var3 + "\" to a \"" + var2 + "\" or a subclass of \"" + var2 + "\"");
            var5.fillInStackTrace();
            throw var5;
        } else {
            return (CustomDatumFactory)var4;
        }
    }

    public ORADataFactory getORADataFactory(Hashtable var1, String var2) throws SQLException {
        String var3 = this.getSQLTypeName();
        Object var4 = var1.get(var3);
        if (var4 == null) {
            SQLException var5 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 1, "Unable to convert a \"" + var3 + "\" to a \"" + var2 + "\" or a subclass of \"" + var2 + "\"");
            var5.fillInStackTrace();
            throw var5;
        } else {
            return (ORADataFactory)var4;
        }
    }

    public OracleDataFactory getOracleDataFactory(Hashtable var1, String var2) throws SQLException {
        String var3 = this.getSQLTypeName();
        Object var4 = var1.get(var3);
        if (var4 == null) {
            SQLException var5 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 1, "Unable to convert a \"" + var3 + "\" to a \"" + var2 + "\" or a subclass of \"" + var2 + "\"");
            var5.fillInStackTrace();
            throw var5;
        } else {
            return (OracleDataFactory)var4;
        }
    }

    public String debugString() {
        StringWriter var2 = new StringWriter();
        String var3 = null;

        try {
            StructDescriptor var4 = this.getDescriptor();
            var2.write("name = " + var4.getName());
            int var1;
            var2.write(" length = " + (var1 = var4.getLength()));
            Object[] var5 = this.getAttributes();

            for(int var6 = 0; var6 < var1; ++var6) {
                var2.write(" attribute[" + var6 + "] = " + var5[var6]);
            }

            var3 = var2.toString();
        } catch (SQLException var7) {
            var3 = "StructDescriptor missing or bad";
        }

        return var3;
    }

    public boolean isInHierarchyOf(String var1) throws SQLException {
        return this.descriptor.isInHierarchyOf(var1);
    }

    public Connection getJavaSqlConnection() throws SQLException {
        return super.getJavaSqlConnection();
    }

    public String dump() throws SQLException {
        return dump(this);
    }

    public static String dump(Object var0) throws SQLException {
        StringWriter var1 = new StringWriter();
        PrintWriter var2 = new PrintWriter(var1);
        dump(var0, var2);
        return var1.getBuffer().substring(0);
    }

    public static void dump(Object var0, PrintStream var1) throws SQLException {
        dump(var0, new PrintWriter(var1, true));
    }

    public static void dump(Object var0, PrintWriter var1) throws SQLException {
        dump((Object)var0, var1, 0);
    }

    static void dump(Object var0, PrintWriter var1, int var2) throws SQLException {
        if (var0 instanceof STRUCT) {
            dump((STRUCT)var0, var1, var2);
        } else if (var0 instanceof ARRAY) {
            ARRAY.dump((ARRAY)var0, var1, var2);
        } else {
            if (var0 == null) {
                var1.println("null");
            } else {
                var1.println(var0.toString());
            }

        }
    }

    static void dump(STRUCT var0, PrintWriter var1, int var2) throws SQLException {
        StructDescriptor var5 = var0.getDescriptor();
        ResultSetMetaData var6 = var5.getMetaData();

        int var4;
        for(var4 = 0; var4 < var2; ++var4) {
            var1.print(' ');
        }

        var1.println("name = " + var5.getName());

        for(var4 = 0; var4 < var2; ++var4) {
            var1.print(' ');
        }

        int var3;
        var1.println("length = " + (var3 = var5.getLength()));
        Object[] var7 = var0.getAttributes();

        for(var4 = 0; var4 < var3; ++var4) {
            for(int var8 = 0; var8 < var2; ++var8) {
                var1.print(' ');
            }

            var1.print(var6.getColumnName(var4 + 1) + " = ");
            dump(var7[var4], var1, var2 + 1);
        }

    }

    public void setACProxy(Object var1) {
        this.acProxy = var1;
    }

    public Object getACProxy() {
        return this.acProxy;
    }
}
