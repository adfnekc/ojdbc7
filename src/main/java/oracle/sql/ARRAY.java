//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package oracle.sql;

import java.io.PrintWriter;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.sql.Array;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;
import oracle.jdbc.OracleConnection;
import oracle.jdbc.OracleData;
import oracle.jdbc.OracleDataFactory;
import oracle.jdbc.OracleTypeMetaData;
import oracle.jdbc.driver.DatabaseError;
import oracle.jdbc.internal.OracleArray;
import oracle.jdbc.proxy.ProxyFactory;
import oracle.jdbc.proxy._Proxy_;

/** @deprecated */
public class ARRAY extends DatumWithConnection implements OracleArray {
    static final byte KOPUP_INLINE_COLL = 1;
    ArrayDescriptor descriptor;
    Object objArray;
    Datum[] datumArray;
    byte[] locator;
    byte prefixFlag;
    byte[] prefixSegment;
    int numElems = -1;
    boolean enableBuffering = false;
    boolean enableIndexing = false;
    public static final int ACCESS_FORWARD = 1;
    public static final int ACCESS_REVERSE = 2;
    public static final int ACCESS_UNKNOWN = 3;
    int accessDirection = 3;
    long lastIndex;
    long lastOffset;
    long[] indexArray;
    long imageOffset;
    long imageLength;
    private static final String _Copyright_2007_Oracle_All_Rights_Reserved_ = null;
    public static final String BUILD_DATE = "Thu_Apr_04_15:09:24_PDT_2013";
    public static final boolean TRACE = false;
    Object acProxy;

    public ARRAY(ArrayDescriptor var1, Connection var2, Object var3) throws SQLException {
        assertNotNull(var1);
        this.descriptor = var1;
        assertNotNull(var2);
        if (!var1.getInternalConnection().isDescriptorSharable(((OracleConnection)var2).physicalConnectionWithin())) {
            SQLException var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 1, "Cannot construct ARRAY instance,invalid connection");
            var4.fillInStackTrace();
            throw var4;
        } else {
            var1.setConnection(var2);
            this.setPhysicalConnectionOf(var2);
            if (var3 == null) {
                this.datumArray = new Datum[0];
            } else {
                this.datumArray = this.descriptor.toOracleArray(var3, 1L, -1);
            }

        }
    }

    public ARRAY(ArrayDescriptor var1, byte[] var2, Connection var3) throws SQLException {
        super(var2);
        assertNotNull(var1);
        this.descriptor = var1;
        assertNotNull(var3);
        if (!var1.getInternalConnection().isDescriptorSharable(((OracleConnection)var3).physicalConnectionWithin())) {
            SQLException var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 1, "Cannot construct ARRAY instance,invalid connection");
            var4.fillInStackTrace();
            throw var4;
        } else {
            var1.setConnection(var3);
            this.setPhysicalConnectionOf(var3);
            this.datumArray = null;
            this.locator = null;
        }
    }

    public static ARRAY toARRAY(Object var0, OracleConnection var1) throws SQLException {
        ARRAY var2 = null;
        if (var0 != null) {
            if (var0 instanceof ARRAY) {
                var2 = (ARRAY)var0;
            } else if (var0 instanceof ORAData) {
                var2 = (ARRAY)((ORAData)var0).toDatum(var1);
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

                var2 = (ARRAY)((ARRAY)var3);
            } else {
                if (!(var0 instanceof CustomDatum)) {
                    SQLException var5 = DatabaseError.createSqlException((oracle.jdbc.internal.OracleConnection)null, 59, var0);
                    var5.fillInStackTrace();
                    throw var5;
                }

                var2 = (ARRAY)var1.physicalConnectionWithin().toDatum((CustomDatum)var0);
            }
        }

        return var2;
    }

    public String getBaseTypeName() throws SQLException {
        synchronized(this.getInternalConnection()) {
            return this.descriptor.getBaseName();
        }
    }

    public int getBaseType() throws SQLException {
        synchronized(this.getInternalConnection()) {
            return this.descriptor.getBaseType();
        }
    }

    public Object getArray() throws SQLException {
        synchronized(this.getInternalConnection()) {
            return this.descriptor.toJavaArray(this, 1L, -1, this.getMap(), this.enableBuffering);
        }
    }

    public Object getArray(Map var1) throws SQLException {
        synchronized(this.getInternalConnection()) {
            return this.descriptor.toJavaArray(this, 1L, -1, var1, this.enableBuffering);
        }
    }

    public Object getArray(long var1, int var3) throws SQLException {
        synchronized(this.getInternalConnection()) {
            if (var1 >= 1L && var3 >= 0) {
                return this.descriptor.toJavaArray(this, var1, var3, this.getMap(), false);
            } else {
                SQLException var5 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 68, "Invalid arguments,'index' should be >= 1 and 'count' >= 0. An exception is thrown.");
                var5.fillInStackTrace();
                throw var5;
            }
        }
    }

    public Object getArray(long var1, int var3, Map var4) throws SQLException {
        synchronized(this.getInternalConnection()) {
            if (var1 >= 1L && var3 >= 0) {
                return this.descriptor.toJavaArray(this, var1, var3, var4, false);
            } else {
                SQLException var6 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 68, "Invalid arguments,'index' should be >= 1 and 'count' >= 0. An exception is thrown.");
                var6.fillInStackTrace();
                throw var6;
            }
        }
    }

    public ResultSet getResultSet() throws SQLException {
        synchronized(this.getInternalConnection()) {
            return this.getResultSet(this.getInternalConnection().getTypeMap());
        }
    }

    public ResultSet getResultSet(Map var1) throws SQLException {
        synchronized(this.getInternalConnection()) {
            return this.descriptor.toResultSet(this, 1L, -1, var1, this.enableBuffering);
        }
    }

    public ResultSet getResultSet(long var1, int var3) throws SQLException {
        synchronized(this.getInternalConnection()) {
            return this.getResultSet(var1, var3, this.getInternalConnection().getTypeMap());
        }
    }

    public ResultSet getResultSet(long var1, int var3, Map var4) throws SQLException {
        synchronized(this.getInternalConnection()) {
            if (var1 >= 1L && var3 >= -1) {
                return this.descriptor.toResultSet(this, var1, var3, var4, false);
            } else {
                SQLException var6 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 68, "getResultSet()");
                var6.fillInStackTrace();
                throw var6;
            }
        }
    }

    public Datum[] getOracleArray() throws SQLException {
        synchronized(this.getInternalConnection()) {
            return this.descriptor.toOracleArray(this, 1L, -1, this.enableBuffering);
        }
    }

    public int length() throws SQLException {
        synchronized(this.getInternalConnection()) {
            return this.descriptor.toLength(this);
        }
    }

    public Datum[] getOracleArray(long var1, int var3) throws SQLException {
        synchronized(this.getInternalConnection()) {
            if (var1 >= 1L && var3 >= 0) {
                return this.descriptor.toOracleArray(this, var1, var3, false);
            } else {
                SQLException var5 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 68, "getOracleArray()");
                var5.fillInStackTrace();
                throw var5;
            }
        }
    }

    public String getSQLTypeName() throws SQLException {
        synchronized(this.getInternalConnection()) {
            String var2 = null;
            if (this.descriptor != null) {
                var2 = this.descriptor.getName();
                return var2;
            } else {
                SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 61, "ARRAY");
                var3.fillInStackTrace();
                throw var3;
            }
        }
    }

    public Map getMap() throws SQLException {
        return this.getInternalConnection().getTypeMap();
    }

    public OracleTypeMetaData getOracleMetaData() throws SQLException {
        return this.getDescriptor();
    }

    public ArrayDescriptor getDescriptor() throws SQLException {
        return this.descriptor;
    }

    public byte[] toBytes() throws SQLException {
        synchronized(this.getInternalConnection()) {
            return this.descriptor.toBytes(this, this.enableBuffering);
        }
    }

    public void setDatumArray(Datum[] var1) {
        this.datumArray = var1;
    }

    public void setObjArray(Object var1) throws SQLException {
        synchronized(this.getInternalConnection()) {
            if (var1 == null) {
                SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 1, "Invalid argument,'oarray' should not be null. An exception is thrown.");
                var3.fillInStackTrace();
                throw var3;
            } else {
                this.objArray = var1;
            }
        }
    }

    public void setLocator(byte[] var1) {
        if (var1 != null && var1.length != 0) {
            this.locator = var1;
        }

    }

    public void setPrefixSegment(byte[] var1) {
        if (var1 != null && var1.length != 0) {
            this.prefixSegment = var1;
        }

    }

    public void setPrefixFlag(byte var1) {
        this.prefixFlag = var1;
    }

    public byte[] getLocator() {
        return this.locator;
    }

    public void setLength(int var1) {
        this.numElems = var1;
    }

    public boolean hasDataSeg() {
        return this.locator == null;
    }

    public boolean isInline() {
        return (this.prefixFlag & 1) == 1;
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

    Object toClass(Class var1, Map var2) throws SQLException {
        Object var3 = null;

        SQLException var5;
        try {
            if (var1 != null && var1 != ARRAY.class && var1 != Array.class) {
                Object var4 = var1.newInstance();
                if (var4 instanceof ORADataFactory) {
                    ORADataFactory var8 = (ORADataFactory)var4;
                    var3 = var8.create(this, 2003);
                } else {
                    if (!(var4 instanceof OracleDataFactory)) {
                        var5 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 49, this.descriptor.getName());
                        var5.fillInStackTrace();
                        throw var5;
                    }

                    OracleDataFactory var9 = (OracleDataFactory)var4;
                    var3 = var9.create(this, 2003);
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
        return new Object[var1][];
    }

    public int[] getIntArray() throws SQLException {
        synchronized(this.getInternalConnection()) {
            return (int[])((int[])this.descriptor.toNumericArray(this, 1L, -1, 4, this.enableBuffering));
        }
    }

    public int[] getIntArray(long var1, int var3) throws SQLException {
        synchronized(this.getInternalConnection()) {
            return (int[])((int[])this.descriptor.toNumericArray(this, var1, var3, 4, false));
        }
    }

    public double[] getDoubleArray() throws SQLException {
        synchronized(this.getInternalConnection()) {
            return (double[])((double[])this.descriptor.toNumericArray(this, 1L, -1, 5, this.enableBuffering));
        }
    }

    public double[] getDoubleArray(long var1, int var3) throws SQLException {
        synchronized(this.getInternalConnection()) {
            return (double[])((double[])this.descriptor.toNumericArray(this, var1, var3, 5, false));
        }
    }

    public short[] getShortArray() throws SQLException {
        synchronized(this.getInternalConnection()) {
            return (short[])((short[])this.descriptor.toNumericArray(this, 1L, -1, 8, this.enableBuffering));
        }
    }

    public short[] getShortArray(long var1, int var3) throws SQLException {
        synchronized(this.getInternalConnection()) {
            return (short[])((short[])this.descriptor.toNumericArray(this, var1, var3, 8, false));
        }
    }

    public long[] getLongArray() throws SQLException {
        synchronized(this.getInternalConnection()) {
            return (long[])((long[])this.descriptor.toNumericArray(this, 1L, -1, 7, this.enableBuffering));
        }
    }

    public long[] getLongArray(long var1, int var3) throws SQLException {
        synchronized(this.getInternalConnection()) {
            return (long[])((long[])this.descriptor.toNumericArray(this, var1, var3, 7, false));
        }
    }

    public float[] getFloatArray() throws SQLException {
        synchronized(this.getInternalConnection()) {
            return (float[])((float[])this.descriptor.toNumericArray(this, 1L, -1, 6, this.enableBuffering));
        }
    }

    public float[] getFloatArray(long var1, int var3) throws SQLException {
        synchronized(this.getInternalConnection()) {
            return (float[])((float[])this.descriptor.toNumericArray(this, var1, var3, 6, false));
        }
    }

    public void setAutoBuffering(boolean var1) throws SQLException {
        synchronized(this.getInternalConnection()) {
            this.enableBuffering = var1;
        }
    }

    public boolean getAutoBuffering() throws SQLException {
        return this.enableBuffering;
    }

    public void setAutoIndexing(boolean var1, int var2) throws SQLException {
        synchronized(this.getInternalConnection()) {
            this.enableIndexing = var1;
            this.accessDirection = var2;
        }
    }

    public void setAutoIndexing(boolean var1) throws SQLException {
        synchronized(this.getInternalConnection()) {
            this.enableIndexing = var1;
            this.accessDirection = 3;
        }
    }

    public boolean getAutoIndexing() throws SQLException {
        return this.enableIndexing;
    }

    public int getAccessDirection() throws SQLException {
        return this.accessDirection;
    }

    public void setLastIndexOffset(long var1, long var3) throws SQLException {
        this.lastIndex = var1;
        this.lastOffset = var3;
    }

    public void setIndexOffset(long var1, long var3) throws SQLException {
        if (this.indexArray == null) {
            this.indexArray = new long[this.numElems];
        }

        this.indexArray[(int)var1 - 1] = var3;
    }

    public long getLastIndex() throws SQLException {
        return this.lastIndex;
    }

    public long getLastOffset() throws SQLException {
        return this.lastOffset;
    }

    public long getOffset(long var1) throws SQLException {
        long var3 = -1L;
        if (this.indexArray != null) {
            var3 = this.indexArray[(int)var1 - 1];
        }

        return var3;
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

    public String dump() throws SQLException {
        return STRUCT.dump(this);
    }

    public String stringValue() throws SQLException {
        Datum[] var1 = this.getOracleArray();
        String var2 = "[";

        for(int var3 = 0; var3 < var1.length; ++var3) {
            if (var3 != 0) {
                var2 = var2 + ", ";
            }

            if (var1[var3] == null) {
                var2 = var2 + "null";
            } else {
                var2 = var2 + var1[var3].stringValue();
            }
        }

        var2 = var2 + "]";
        return var2;
    }

    static void dump(ARRAY var0, PrintWriter var1, int var2) throws SQLException {
        if (var2 > 0) {
            var1.println();
        }

        ArrayDescriptor var5 = var0.getDescriptor();

        int var4;
        for(var4 = 0; var4 < var2; ++var4) {
            var1.print(' ');
        }

        var1.println("name = " + var5.getName());

        for(var4 = 0; var4 < var2; ++var4) {
            var1.print(' ');
        }

        var1.println("max length = " + var5.getMaxLength());
        Object[] var6 = (Object[])((Object[])var0.getArray());

        for(var4 = 0; var4 < var2; ++var4) {
            var1.print(' ');
        }

        int var3;
        var1.println("length = " + (var3 = var6.length));

        for(var4 = 0; var4 < var3; ++var4) {
            for(int var7 = 0; var7 < var2; ++var7) {
                var1.print(' ');
            }

            var1.print("element[" + var4 + "] = ");
            STRUCT.dump(var6[var4], var1, var2 + 4);
        }

    }

    public void free() throws SQLException {
    }

    public void setACProxy(Object var1) {
        this.acProxy = var1;
    }

    public Object getACProxy() {
        return this.acProxy;
    }
}
