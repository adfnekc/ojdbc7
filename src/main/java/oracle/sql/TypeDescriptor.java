//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package oracle.sql;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.Serializable;
import java.io.StringWriter;
import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Map;
import oracle.jdbc.OracleConnectionWrapper;
import oracle.jdbc.OracleData;
import oracle.jdbc.OracleTypeMetaData.Kind;
import oracle.jdbc.driver.DatabaseError;
import oracle.jdbc.internal.OracleConnection;
import oracle.jdbc.internal.OracleTypeMetaData;
import oracle.jdbc.oracore.OracleNamedType;
import oracle.jdbc.oracore.OracleTypeADT;
import oracle.jdbc.oracore.OracleTypeCOLLECTION;
import oracle.jdbc.oracore.OracleTypeOPAQUE;
import oracle.jdbc.oracore.PickleContext;

public class TypeDescriptor implements OracleTypeMetaData, Serializable, ORAData, OracleData {
    public static boolean DEBUG_SERIALIZATION = false;
    static final long serialVersionUID = 2022598722047823723L;
    static final int KOIDFLEN = 16;
    static final short KOTA_TRN = 1;
    static final short KOTA_PDF = 2;
    static final short KOTA_ITOID = 4;
    static final short KOTA_LOB = 8;
    static final short KOTA_AD = 16;
    static final short KOTA_NMHSH = 32;
    static final short KOTA_TEV = 64;
    static final short KOTA_INH = 128;
    static final short KOTA_10I = 256;
    static final short KOTA_RBF = 512;
    static final short KOTA_HBF = 1024;
    static final int ANYTYPE_IMAGE_SIZE_TOID = 23;
    static final int ANYTYPE_IMAGE_SIZE_NO_TOID = 5;
    static final byte KOTTDOID = 1;
    static final byte KOTTBOID = 2;
    static final byte KOTADOID = 3;
    static final byte KOTREFOID = 4;
    static final byte KOTMDOID = 5;
    static final byte KOTMIOID = 6;
    static final byte KOTEXOID = 7;
    static final byte KOTDATOID = 8;
    static final byte KOTBYTOID = 9;
    static final byte KOTSHOOID = 10;
    static final byte KOTLONOID = 11;
    static final byte KOTREAOID = 12;
    static final byte KOTDOUOID = 13;
    static final byte KOTFLOOID = 14;
    static final byte KOTNUMOID = 15;
    static final byte KOTDECOID = 16;
    static final byte KOTUBYOID = 17;
    static final byte KOTUSHOID = 18;
    static final byte KOTULOOID = 19;
    static final byte KOTOCTOID = 20;
    static final byte KOTSMLOID = 21;
    static final byte KOTINTOID = 22;
    static final byte KOTRAWOID = 23;
    static final byte KOTPTROID = 24;
    static final byte KOTVSIOID = 25;
    static final byte KOTFSIOID = 26;
    static final byte KOTVSOOID = 27;
    static final byte KOTMLSOID = 28;
    static final byte KOTVAROID = 29;
    static final byte KOTMSTOID = 30;
    static final byte KOTNATOID = 31;
    static final byte KOTDOMOID = 32;
    static final byte KOTUND1OID = 33;
    static final byte KOTCLBOID = 34;
    static final byte KOTBLBOID = 35;
    static final byte KOTCFLOID = 36;
    static final byte KOTBFLOID = 37;
    static final byte KOTOIDOID = 38;
    static final byte KOTCAROID = 39;
    static final byte KOTCANOID = 40;
    static final byte KOTLPTOID = 41;
    static final byte KOTBRIOID = 42;
    static final byte KOTUCOOID = 43;
    static final byte KOTRECOID = 44;
    static final byte KOTRCUOID = 45;
    static final byte KOTBOOOID = 46;
    static final byte KOTRIDOID = 47;
    static final byte KOTPLOOID = 48;
    static final byte KOTPLROID = 49;
    static final byte KOTPBIOID = 50;
    static final byte KOTPINOID = 51;
    static final byte KOTPNAOID = 52;
    static final byte KOTPNNOID = 53;
    static final byte KOTPPOOID = 54;
    static final byte KOTPPNOID = 55;
    static final byte KOTPSTOID = 56;
    static final byte KOTEX1OID = 57;
    static final byte KOTOPQOID = 58;
    static final byte KOTTMOID = 59;
    static final byte KOTTMTZOID = 60;
    static final byte KOTTSOID = 61;
    static final byte KOTTSTZOID = 62;
    static final byte KOTIYMOID = 63;
    static final byte KOTIDSOID = 64;
    static final byte KOTTSIMPTZOID = 65;
    static final byte KOTTBXOID = 66;
    static final byte KOTADXOID = 67;
    static final byte KOTOIDBFLT = 68;
    static final byte KOTOIDBDBL = 69;
    static final byte KOTURDOID = 70;
    static final byte KOTLASTOID = 71;
    static final byte[] KOTTDEXTOID = new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1};
    static final byte[] KOTTBEXTOID = new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 2};
    static final byte[] KOTADEXTOID = new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 3};
    static final byte[] KOTMDEXTOID = new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 4};
    static final byte[] KOTTBXEXTOID = new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 66};
    static final byte[] KOTADXEXTOID = new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 67};
    static final byte[] KOTTDTOID = new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1};
    static final byte[] KOTTBTOID = new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2};
    static final byte[] KOTADTOID = new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3};
    static final byte[] KOTMDTOID = new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 5};
    static final byte[] KOTMITOID = new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 6};
    static final byte[] KOTEXTOID = new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 7};
    static final byte[] KOTEX1TOID = new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 57};
    static final byte[] KOTTBXTOID = new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 66};
    static final byte[] KOTADXTOID = new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 67};
    public static final byte[] RAWTOID = new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 23};
    public static final byte[] ANYTYPETOID = new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0, 16};
    public static final byte[] ANYDATATOID = new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0, 17};
    public static final byte[] ANYDATASETTOID = new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0, 18};
    public static final byte[] XMLTYPETOID = new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 1, 0};
    static final short SQLT_NONE = 0;
    static final short SQLT_CHR = 1;
    static final short SQLT_NUM = 2;
    static final short SQLT_INT = 3;
    static final short SQLT_FLT = 4;
    static final short SQLT_STR = 5;
    static final short SQLT_VNU = 6;
    static final short SQLT_PDN = 7;
    static final short SQLT_LNG = 8;
    static final short SQLT_VCS = 9;
    static final short SQLT_NON = 10;
    static final short SQLT_RID = 11;
    static final short SQLT_DAT = 12;
    static final short SQLT_VBI = 15;
    static final short SQLT_BFLOAT = 21;
    static final short SQLT_BDOUBLE = 22;
    static final short SQLT_BIN = 23;
    static final short SQLT_LBI = 24;
    static final short SQLT_UIN = 68;
    static final short SQLT_SLS = 91;
    static final short SQLT_LVC = 94;
    static final short SQLT_LVB = 95;
    static final short SQLT_AFC = 96;
    static final short SQLT_AVC = 97;
    static final short SQLT_IBFLOAT = 100;
    static final short SQLT_IBDOUBLE = 101;
    static final short SQLT_CUR = 102;
    static final short SQLT_RDD = 104;
    static final short SQLT_LAB = 105;
    static final short SQLT_OSL = 106;
    static final short SQLT_NTY = 108;
    static final short SQLT_REF = 110;
    static final short SQLT_CLOB = 112;
    static final short SQLT_BLOB = 113;
    static final short SQLT_BFILEE = 114;
    static final short SQLT_FILE = 114;
    static final short SQLT_CFILEE = 115;
    static final short SQLT_RSET = 116;
    static final short SQLT_SVT = 118;
    static final short SQLT_NCO = 122;
    static final short SQLT_DTR = 152;
    static final short SQLT_DUN = 153;
    static final short SQLT_DOP = 154;
    static final short SQLT_VST = 155;
    static final short SQLT_ODT = 156;
    static final short SQLT_DOL = 172;
    static final short SQLT_DATE = 184;
    static final short SQLT_TIME = 185;
    static final short SQLT_TIME_TZ = 186;
    static final short SQLT_TIMESTAMP = 187;
    static final short SQLT_TIMESTAMP_TZ = 188;
    static final short SQLT_INTERVAL_YM = 189;
    static final short SQLT_INTERVAL_DS = 190;
    static final short SQLT_TIMESTAMP_LTZ = 232;
    static final short SQLT_PNTY = 241;
    static final short SQLT_CFILE = 115;
    static final short SQLT_BFILE = 114;
    static final short SQLT_REC = 250;
    static final short SQLT_TAB = 251;
    static final short SQLT_BOL = 252;
    static final short SQLCS_IMPLICIT = 1;
    static final short SQLCS_NCHAR = 2;
    static final short SQLCS_EXPLICIT = 3;
    static final short SQLCS_FLEXIBLE = 4;
    static final short SQLCS_LIT_NULL = 5;
    static final short SQLT_XDP = 103;
    static final short SQLT_OKO = 107;
    static final short SQLT_INTY = 109;
    static final short SQLT_IREF = 111;
    static final short SQLT_DCLOB = 195;
    public static final short TYPECODE_REF = 110;
    public static final short TYPECODE_DATE = 12;
    public static final short TYPECODE_SIGNED8 = 27;
    public static final short TYPECODE_SIGNED16 = 28;
    public static final short TYPECODE_SIGNED32 = 29;
    public static final short TYPECODE_REAL = 21;
    public static final short TYPECODE_DOUBLE = 22;
    public static final short TYPECODE_BFLOAT = 100;
    public static final short TYPECODE_BDOUBLE = 101;
    public static final short TYPECODE_FLOAT = 4;
    public static final short TYPECODE_NUMBER = 2;
    public static final short TYPECODE_DECIMAL = 7;
    public static final short TYPECODE_UNSIGNED8 = 23;
    public static final short TYPECODE_UNSIGNED16 = 25;
    public static final short TYPECODE_UNSIGNED32 = 26;
    public static final short TYPECODE_OCTET = 245;
    public static final short TYPECODE_SMALLINT = 246;
    public static final short TYPECODE_INTEGER = 3;
    public static final short TYPECODE_RAW = 95;
    public static final short TYPECODE_PTR = 32;
    public static final short TYPECODE_VARCHAR2 = 9;
    public static final short TYPECODE_CHAR = 96;
    public static final short TYPECODE_VARCHAR = 1;
    public static final short TYPECODE_MLSLABEL = 105;
    public static final short TYPECODE_VARRAY = 247;
    public static final short TYPECODE_TABLE = 248;
    public static final short TYPECODE_OBJECT = 108;
    public static final short TYPECODE_OPAQUE = 58;
    public static final short TYPECODE_NAMEDCOLLECTION = 122;
    public static final short TYPECODE_BLOB = 113;
    public static final short TYPECODE_BFILE = 114;
    public static final short TYPECODE_CLOB = 112;
    public static final short TYPECODE_CFILE = 115;
    public static final short TYPECODE_TIME = 185;
    public static final short TYPECODE_TIME_TZ = 186;
    public static final short TYPECODE_TIMESTAMP = 187;
    public static final short TYPECODE_TIMESTAMP_TZ = 188;
    public static final short TYPECODE_TIMESTAMP_LTZ = 232;
    public static final short TYPECODE_INTERVAL_YM = 189;
    public static final short TYPECODE_INTERVAL_DS = 190;
    public static final short TYPECODE_UROWID = 104;
    public static final short TYPECODE_OTMFIRST = 228;
    public static final short TYPECODE_OTMLAST = 320;
    public static final short TYPECODE_SYSFIRST = 228;
    public static final short TYPECODE_SYSLAST = 235;
    public static final short TYPECODE_PLS_INTEGER = 266;
    public static final short TYPECODE_ITABLE = 251;
    public static final short TYPECODE_RECORD = 250;
    public static final short TYPECODE_BOOLEAN = 252;
    public static final short TYPECODE_NCHAR = 286;
    public static final short TYPECODE_NVARCHAR2 = 287;
    public static final short TYPECODE_NCLOB = 288;
    public static final short TYPECODE_NONE = 0;
    public static final short TYPECODE_ERRHP = 283;
    public static final short TYPECODE_JDBC_JOBJECT = 2000;
    public static final short TYPECODE_JDBC_STRUCT = 2002;
    public static final short TYPECODE_JDBC_ARRAY = 2003;
    public static final short TYPECODE_JDBC_JOPAQUE = 2000;
    public static final short TYPECODE_JDBC_REF = 2006;
    public static final short TYPECODE_JDBC_JSTRUCT = 2008;
    public static final short TYPECODE_SQLXML = 2009;
    private static final short TYPECODE_MAXVALUE = 2009;
    static final short[] OID_TO_TYPECODE = new short[71];
    SQLName sqlName;
    OracleNamedType pickler;
    transient OracleConnection connection;
    short internalTypeCode;
    boolean isTransient = false;
    byte[] toid = null;
    int toidVersion = 1;
    long precision;
    byte scale;
    byte[] transientImage = null;
    AttributeDescriptor[] attributesDescriptor = null;
    transient Boolean isInstanciable = null;
    transient String supertype = null;
    transient int numLocalAttrs = -1;
    transient String[] subtypes = null;
    transient String[] attrJavaNames = null;
    String typeNameByUser;
    private static String[] typeCodeTypeNameMap;
    protected Object acProxy;
    private static final String _Copyright_2007_Oracle_All_Rights_Reserved_;
    public static final String BUILD_DATE = "Thu_Apr_04_15:09:24_PDT_2013";
    public static final boolean TRACE = false;

    void copyDescriptor(TypeDescriptor var1) {
        if (var1.sqlName != null) {
            this.sqlName = var1.sqlName;
        }

        this.pickler = var1.pickler;
        this.connection = var1.connection;
        this.internalTypeCode = var1.internalTypeCode;
        this.isTransient = var1.isTransient;
        this.toid = var1.toid;
        this.toidVersion = var1.toidVersion;
        this.precision = var1.precision;
        this.scale = var1.scale;
        this.transientImage = var1.transientImage;
        this.attributesDescriptor = var1.attributesDescriptor;
        this.isInstanciable = var1.isInstanciable;
        this.supertype = var1.supertype;
        this.numLocalAttrs = var1.numLocalAttrs;
        this.subtypes = var1.subtypes;
        this.attrJavaNames = var1.attrJavaNames;
        if (var1.typeNameByUser != null) {
            this.typeNameByUser = var1.typeNameByUser;
        }

    }

    protected TypeDescriptor(short var1) {
        this.internalTypeCode = var1;
    }

    protected TypeDescriptor(short var1, String var2, Connection var3) throws SQLException {
        this.internalTypeCode = var1;
        if (var2 != null && var3 != null) {
            this.setPhysicalConnectionOf(var3);
            this.typeNameByUser = var2;
        } else {
            SQLException var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 60, "Invalid arguments");
            var4.fillInStackTrace();
            throw var4;
        }
    }

    protected TypeDescriptor(short var1, SQLName var2, Connection var3) throws SQLException {
        this.internalTypeCode = var1;
        if (var2 != null && var3 != null) {
            this.sqlName = var2;
            this.typeNameByUser = this.sqlName.getName();
            this.setPhysicalConnectionOf(var3);
        } else {
            SQLException var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 60, "Invalid arguments");
            var4.fillInStackTrace();
            throw var4;
        }
    }

    protected TypeDescriptor(short var1, SQLName var2, OracleTypeADT var3, Connection var4) throws SQLException {
        this.internalTypeCode = var1;
        if (var2 != null && var3 != null) {
            this.sqlName = var2;
            this.typeNameByUser = this.sqlName.getName();
            if (var4 != null) {
                this.setPhysicalConnectionOf(var4);
            }

            this.pickler = var3;
            this.pickler.setDescriptor(this);
            this.toid = var3.getTOID();
        } else {
            SQLException var5 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 60, "Invalid arguments");
            var5.fillInStackTrace();
            throw var5;
        }
    }

    protected TypeDescriptor(short var1, OracleTypeADT var2, Connection var3) throws SQLException {
        this.internalTypeCode = var1;
        if (var2 != null && var3 != null) {
            this.setPhysicalConnectionOf(var3);
            this.sqlName = null;
            this.pickler = var2;
            this.pickler.setDescriptor(this);
            this.toid = var2.getTOID();
        } else {
            SQLException var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 60, "Invalid arguments");
            var4.fillInStackTrace();
            throw var4;
        }
    }

    public Kind getKind() {
        return Kind.TYPE;
    }

    public String getName() throws SQLException {
        if (this.sqlName == null) {
            synchronized(this.connection) {
                this.initSQLName();
            }
        }

        String var1 = null;
        if (this.sqlName != null) {
            var1 = this.sqlName.getName();
        }

        return var1;
    }

    public SQLName getSQLName() throws SQLException {
        synchronized(this.connection) {
            if (this.sqlName == null) {
                this.initSQLName();
            }

            return this.sqlName;
        }
    }

    void initSQLName() throws SQLException {
        if (!this.isTransient) {
            SQLException var4;
            if (this.connection == null) {
                var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 1);
                var4.fillInStackTrace();
                throw var4;
            }

            if (this.pickler != null) {
                this.sqlName = new SQLName(this.pickler.getFullName(), this.connection);
            } else if (this.typeNameByUser != null) {
                this.sqlName = new SQLName(this.typeNameByUser, this.connection);
            } else if (this.toid != null) {
                String var1 = OracleTypeADT.toid2typename(this.connection, this.toid);
                this.typeNameByUser = var1;
                this.sqlName = new SQLName(var1, this.connection);
                TypeDescriptor var2 = null;
                String var3 = this.sqlName.getName();
                var2 = (TypeDescriptor)this.connection.getDescriptor(var3);
                if (var2 != null) {
                    this.copyDescriptor(var2);
                }
            } else if (this.internalTypeCode == 108 || this.internalTypeCode == 122) {
                var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 1);
                var4.fillInStackTrace();
                throw var4;
            }
        }

    }

    public String getSchemaName() throws SQLException {
        String var1 = null;
        if (this.sqlName == null) {
            this.initSQLName();
        }

        if (this.sqlName != null) {
            var1 = this.sqlName.getSchema();
        }

        return var1;
    }

    public String getTypeName() throws SQLException {
        String var1 = null;
        if (this.sqlName == null) {
            this.initSQLName();
        }

        if (this.sqlName != null) {
            var1 = this.sqlName.getSimpleName();
        }

        return var1;
    }

    public OracleNamedType getPickler() {
        return this.pickler;
    }

    public OracleConnection getInternalConnection() {
        return this.connection;
    }

    public void setPhysicalConnectionOf(Connection var1) {
        this.connection = ((oracle.jdbc.OracleConnection)var1).physicalConnectionWithin();
    }

    public int getTypeCode() throws SQLException {
        return this.internalTypeCode;
    }

    public String getTypeCodeName() throws SQLException {
        return getTypeCodeTypeNameMap()[this.getTypeCode()];
    }

    private static String[] getTypeCodeTypeNameMap() throws SQLException {
        if (typeCodeTypeNameMap == null) {
            String[] var0 = new String[2010];
            Class var1 = null;

            try {
                var1 = Class.forName("oracle.sql.TypeDescriptor");
            } catch (ClassNotFoundException var7) {
                SQLException var3 = DatabaseError.createSqlException((OracleConnection)null, 1, "TypeDescriptor.getTypeCodeName: got a ClassNotFoundException: " + var7.getMessage());
                var3.fillInStackTrace();
                throw var3;
            }

            Field[] var2 = var1.getFields();

            for(int var8 = 0; var8 < var2.length; ++var8) {
                if (var2[var8].getName().startsWith("TYPECODE_")) {
                    try {
                        var0[var2[var8].getInt((Object)null)] = var2[var8].getName();
                    } catch (Exception var6) {
                        SQLException var5 = DatabaseError.createSqlException((OracleConnection)null, 1, "TypeDescriptor.getTypeCodeName: " + var6.getMessage());
                        var5.fillInStackTrace();
                        throw var5;
                    }
                }
            }

            typeCodeTypeNameMap = var0;
        }

        return typeCodeTypeNameMap;
    }

    public short getInternalTypeCode() throws SQLException {
        return this.internalTypeCode;
    }

    public static TypeDescriptor getTypeDescriptor(String var0, oracle.jdbc.OracleConnection var1) throws SQLException {
        Object var2 = null;

        try {
            SQLName var3 = new SQLName(var0, var1);
            String var10 = var3.getName();
            var2 = (TypeDescriptor)var1.getDescriptor(var10);
            if (var2 == null) {
                OracleTypeADT var5 = new OracleTypeADT(var0, var1);
                OracleConnection var6 = (OracleConnection)var1;
                var5.init(var6);
                OracleNamedType var7 = var5.cleanup();
                switch(var7.getTypeCode()) {
                    case 2002:
                    case 2008:
                        var2 = new StructDescriptor(var3, (OracleTypeADT)var7, var1);
                        break;
                    case 2003:
                        var2 = new ArrayDescriptor(var3, (OracleTypeCOLLECTION)var7, var1);
                        break;
                    case 2004:
                    case 2005:
                    case 2006:
                    default:
                        SQLException var8 = DatabaseError.createSqlException((OracleConnection)null, 1);
                        var8.fillInStackTrace();
                        throw var8;
                    case 2007:
                        var2 = new OpaqueDescriptor(var3, (OracleTypeOPAQUE)var7, var1);
                }

                var1.putDescriptor(var10, var2);
                var7.setDescriptor((TypeDescriptor)var2);
            }

            return (TypeDescriptor)var2;
        } catch (Exception var9) {
            SQLException var4;
            if (var9 instanceof SQLException) {
                var4 = DatabaseError.createSqlException((OracleConnection)null, (SQLException)var9, 60, "Unable to resolve type \"" + var0 + "\"");
                var4.fillInStackTrace();
                throw var4;
            } else {
                var4 = DatabaseError.createSqlException((OracleConnection)null, 60, "Unable to resolve type \"" + var0 + "\"");
                var4.fillInStackTrace();
                throw var4;
            }
        }
    }

    public static TypeDescriptor getTypeDescriptor(String var0, oracle.jdbc.OracleConnection var1, byte[] var2, long var3) throws SQLException {
        Object var5 = null;
        String var6 = getSubtypeName(var1, var2, var3);
        if (var6 == null) {
            var6 = var0;
        }

        var5 = (TypeDescriptor)var1.getDescriptor(var6);
        if (var5 == null) {
            SQLName var7 = new SQLName(var6, var1);
            OracleTypeADT var8 = new OracleTypeADT(var6, var1);
            OracleConnection var9 = (OracleConnection)var1;
            var8.init(var9);
            OracleNamedType var10 = var8.cleanup();
            switch(var10.getTypeCode()) {
                case 2002:
                case 2008:
                    var5 = new StructDescriptor(var7, (OracleTypeADT)var10, var1);
                    break;
                case 2003:
                    var5 = new ArrayDescriptor(var7, (OracleTypeCOLLECTION)var10, var1);
                    break;
                case 2004:
                case 2005:
                case 2006:
                default:
                    SQLException var11 = DatabaseError.createSqlException((OracleConnection)null, 1);
                    var11.fillInStackTrace();
                    throw var11;
                case 2007:
                    var5 = new OpaqueDescriptor(var7, (OracleTypeOPAQUE)var10, var1);
            }

            var1.putDescriptor(var6, var5);
        }

        return (TypeDescriptor)var5;
    }

    public Datum toDatum(Connection var1) throws SQLException {
        if (var1 instanceof OracleConnectionWrapper && !(var1 instanceof oracle.jdbc.driver.OracleConnection)) {
            this.connection = (OracleConnection)((OracleConnectionWrapper)var1).unwrap();
        } else {
            this.connection = (OracleConnection)var1;
        }

        OpaqueDescriptor var2 = OpaqueDescriptor.createDescriptor("SYS.ANYTYPE", var1);
        byte[] var3 = new byte[this.getOpaqueImageTypeSize()];
        this.pickleOpaqueTypeImage(var3, 0, false);
        OPAQUE var4 = new OPAQUE(var2, this.connection, var3);
        var4.setShareBytes(var4.toBytes());
        return var4;
    }

    public Object toJDBCObject(Connection var1) throws SQLException {
        return this.toDatum(var1);
    }

    static TypeDescriptor unpickleOpaqueTypeImage(PickleContext var0, Connection var1, short[] var2) throws SQLException {
        Object var4 = null;
        Object var6 = null;
        int var7 = var0.offset();
        byte[] var8 = var0.image();
        var0.skipBytes(1);
        short var3 = (short)var0.readUB2();
        var2[0] = (short)var0.readUB2();
        if ((var3 & 32) != 0) {
            SQLException var16 = DatabaseError.createSqlException((OracleConnection)null, 178);
            var16.fillInStackTrace();
            throw var16;
        } else {
            SQLException var10;
            int var15;
            if ((var3 & 1) == 0) {
                if ((var3 & 2) != 0 && var2[0] != 110 && var2[0] != 58) {
                    var6 = new TypeDescriptor(var2[0]);
                } else {
                    byte[] var14 = var0.readDataValue(16);
                    int var5 = var0.readUB2();
                    String var9 = (String)((String)((OracleConnection)var1).getDescriptor(var14));
                    var6 = (TypeDescriptor)((TypeDescriptor)((OracleConnection)var1).getDescriptor(var9));
                    if (var6 == null) {
                        if (var2[0] == 122) {
                            var6 = new ArrayDescriptor(var14, var5, var1);
                        } else if (var2[0] != 108 && var2[0] != 110) {
                            if (var2[0] != 58) {
                                var10 = DatabaseError.createSqlException((OracleConnection)null, 178);
                                var10.fillInStackTrace();
                                throw var10;
                            }

                            var6 = new OpaqueDescriptor(var14, var5, var1);
                        } else {
                            var6 = new StructDescriptor(var14, var5, var1);
                        }
                    }
                }

                ((TypeDescriptor)var6).setTransient(false);
            } else {
                var15 = (int)var0.readUB4();
                if (var2[0] != 108) {
                    if (var15 != 1) {
                        var10 = DatabaseError.createSqlException((OracleConnection)null, 178);
                        var10.fillInStackTrace();
                        throw var10;
                    }

                    byte var18 = var0.readByte();
                    var6 = Kotad.unpickleTypeDescriptorImage(var0);
                } else {
                    AttributeDescriptor[] var17 = null;
                    if (var15 > 0) {
                        var17 = new AttributeDescriptor[var15];

                        for(int var11 = 0; var11 < var15; ++var11) {
                            byte var12 = var0.readByte();
                            var17[var11] = Kotad.unpickleAttributeImage(var12 == 2, var0);
                            if (var12 != 2) {
                                short[] var13 = new short[1];
                                var17[var11].setTypeDescriptor(unpickleOpaqueTypeImage(var0, var1, var13));
                            }
                        }
                    }

                    var6 = new StructDescriptor(var17, var1);
                }

                ((TypeDescriptor)var6).setTransient(true);
            }

            if (((TypeDescriptor)var6).isTransient()) {
                var15 = var0.offset();
                byte[] var19 = new byte[var15 - var7];
                System.arraycopy(var8, var7, var19, 0, var19.length);
                ((TypeDescriptor)var6).setTransientImage(var19);
            }

            return (TypeDescriptor)var6;
        }
    }

    void setTransientImage(byte[] var1) {
        this.transientImage = var1;
    }

    void setTransient(boolean var1) {
        this.isTransient = var1;
    }

    public boolean isTransient() {
        return this.isTransient;
    }

    int getOpaqueImageTypeSize() {
        boolean var1 = false;
        int var2;
        if (this.isTransient) {
            var2 = this.transientImage.length;
        } else {
            var2 = 5;
            if (this.toid != null && this.toid.length == 16) {
                var2 = 23;
            }
        }

        return var2;
    }

    int pickleOpaqueTypeImage(byte[] var1, int var2, boolean var3) {
        if (this.isTransient) {
            System.arraycopy(this.transientImage, 0, var1, var2, this.transientImage.length);
            var2 += this.transientImage.length;
        } else {
            boolean var4 = false;
            if (this.toid != null && this.toid.length == 16) {
                var4 = true;
            }

            var1[var2++] = 1;
            short var5 = this.internalTypeCode;
            if (var3) {
                var5 = 110;
            }

            int var6 = 512;
            if (var5 != 108 && var5 != 122) {
                var6 |= 2;
            }

            if (var4 && var5 != 110) {
                var6 |= 4;
            }

            var1[var2++] = (byte)((var6 & '\uff00') >> 8 & 255);
            var1[var2++] = (byte)(var6 & 255);
            var1[var2++] = (byte)((var5 & '\uff00') >> 8 & 255);
            var1[var2++] = (byte)(var5 & 255);
            if (var4) {
                System.arraycopy(this.toid, 0, var1, var2, this.toid.length);
                var2 += this.toid.length;
                var1[var2++] = (byte)((this.toidVersion & '\uff00') >> 8 & 255);
                var1[var2++] = (byte)(this.toidVersion & 255);
            }
        }

        return var2;
    }

    public void setPrecision(long var1) {
        this.precision = var1;
    }

    public long getPrecision() {
        return this.precision;
    }

    public void setScale(byte var1) {
        this.scale = var1;
    }

    public byte getScale() {
        return this.scale;
    }

    public boolean isInHierarchyOf(String var1) throws SQLException {
        return false;
    }

    private void writeObject(ObjectOutputStream var1) throws IOException {
        try {
            if (this.sqlName == null) {
                this.initSQLName();
            }
        } catch (SQLException var3) {
            throw new IOException(var3.getMessage());
        }

        var1.writeObject(this.sqlName);
        var1.writeObject(this.pickler);
    }

    private void readObject(ObjectInputStream var1) throws IOException, ClassNotFoundException {
        this.sqlName = (SQLName)var1.readObject();
        this.pickler = (OracleNamedType)var1.readObject();
    }

    public void setConnection(Connection var1) throws SQLException {
        this.setPhysicalConnectionOf(var1);
        this.pickler.setConnection(this.getInternalConnection());
    }

    public static String getSubtypeName(oracle.jdbc.OracleConnection var0, byte[] var1, long var2) throws SQLException {
        if (var1 != null && var1.length != 0 && var0 != null) {
            String var5 = OracleTypeADT.getSubtypeName(var0, var1, var2);
            return var5;
        } else {
            SQLException var4 = DatabaseError.createSqlException((OracleConnection)null, 68, " 'image' should not be empty and 'conn' should not be null. ");
            var4.fillInStackTrace();
            throw var4;
        }
    }

    public void initMetadataRecursively() throws SQLException {
        if (this.pickler != null) {
            this.pickler.initMetadataRecursively();
        }

    }

    public void initNamesRecursively() throws SQLException {
        if (this.pickler != null) {
            this.pickler.initNamesRecursively();
        }

    }

    public void fixupConnection(OracleConnection var1) throws SQLException {
        if (this.connection == null) {
            this.connection = var1;
        }

        if (this.pickler != null) {
            this.pickler.fixupConnection(var1);
        }

    }

    public String toXMLString() throws SQLException {
        return this.toXMLString(false);
    }

    public String toXMLString(boolean var1) throws SQLException {
        StringWriter var2 = new StringWriter();
        PrintWriter var3 = new PrintWriter(var2);
        this.printXMLHeader(var3);
        this.printXML(var3, 0, var1);
        return var2.getBuffer().substring(0);
    }

    public void printXML(PrintStream var1) throws SQLException {
        this.printXML(var1, false);
    }

    public void printXML(PrintStream var1, boolean var2) throws SQLException {
        PrintWriter var3 = new PrintWriter(var1, true);
        this.printXMLHeader(var3);
        this.printXML(var3, 0, var2);
    }

    void printXML(PrintWriter var1, int var2, boolean var3) throws SQLException {
        String var4 = this.tagName();
        var1.println("<" + var4 + " sqlName=\"" + this.getName() + "\" >");
        if (this.pickler != null) {
            this.pickler.printXML(var1, var2 + 1, var3);
        }

        var1.println("</" + var4 + ">");
    }

    String tagName() {
        return "TypeDescriptor";
    }

    void printXMLHeader(PrintWriter var1) throws SQLException {
        var1.println("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>");
    }

    protected OracleConnection getConnectionDuringExceptionHandling() {
        return this.connection;
    }

    public Class getClass(Map var1) throws SQLException {
        String var2 = this.getName();
        Class var3 = this.connection.getClassForType(var2, var1);
        String var4 = this.getSchemaName();
        String var5 = this.getTypeName();
        if (var3 == null) {
            var3 = (Class)var1.get(var5);
        }

        if (SQLName.s_parseAllFormat) {
            if (var3 == null && this.connection.getDefaultSchemaNameForNamedTypes().equals(var4)) {
                var3 = (Class)var1.get("\"" + var5 + "\"");
            }

            if (var3 == null) {
                var3 = (Class)var1.get("\"" + var4 + "\"" + "." + "\"" + var5 + "\"");
            }

            if (var3 == null) {
                var3 = (Class)var1.get("\"" + var4 + "\"" + "." + var5);
            }

            if (var3 == null) {
                var3 = (Class)var1.get(var4 + "." + "\"" + var5 + "\"");
            }
        }

        return var3;
    }

    public void setACProxy(Object var1) {
        this.acProxy = var1;
    }

    public Object getACProxy() {
        return this.acProxy;
    }

    static {
        OID_TO_TYPECODE[8] = 12;
        OID_TO_TYPECODE[9] = 27;
        OID_TO_TYPECODE[10] = 28;
        OID_TO_TYPECODE[11] = 29;
        OID_TO_TYPECODE[12] = 21;
        OID_TO_TYPECODE[13] = 22;
        OID_TO_TYPECODE[14] = 4;
        OID_TO_TYPECODE[15] = 2;
        OID_TO_TYPECODE[16] = 7;
        OID_TO_TYPECODE[17] = 23;
        OID_TO_TYPECODE[18] = 25;
        OID_TO_TYPECODE[19] = 26;
        OID_TO_TYPECODE[20] = 245;
        OID_TO_TYPECODE[21] = 246;
        OID_TO_TYPECODE[22] = 3;
        OID_TO_TYPECODE[23] = 95;
        OID_TO_TYPECODE[24] = 32;
        OID_TO_TYPECODE[25] = 9;
        OID_TO_TYPECODE[26] = 96;
        OID_TO_TYPECODE[27] = 1;
        OID_TO_TYPECODE[28] = 105;
        OID_TO_TYPECODE[29] = 247;
        OID_TO_TYPECODE[30] = 248;
        OID_TO_TYPECODE[31] = 108;
        OID_TO_TYPECODE[32] = 0;
        OID_TO_TYPECODE[33] = 0;
        OID_TO_TYPECODE[34] = 112;
        OID_TO_TYPECODE[35] = 113;
        OID_TO_TYPECODE[36] = 115;
        OID_TO_TYPECODE[37] = 114;
        OID_TO_TYPECODE[38] = 0;
        OID_TO_TYPECODE[39] = 0;
        OID_TO_TYPECODE[40] = 0;
        OID_TO_TYPECODE[41] = 0;
        OID_TO_TYPECODE[42] = 0;
        OID_TO_TYPECODE[43] = 0;
        OID_TO_TYPECODE[44] = 0;
        OID_TO_TYPECODE[45] = 0;
        OID_TO_TYPECODE[46] = 0;
        OID_TO_TYPECODE[47] = 0;
        OID_TO_TYPECODE[48] = 0;
        OID_TO_TYPECODE[49] = 0;
        OID_TO_TYPECODE[50] = 0;
        OID_TO_TYPECODE[51] = 0;
        OID_TO_TYPECODE[52] = 0;
        OID_TO_TYPECODE[53] = 0;
        OID_TO_TYPECODE[54] = 0;
        OID_TO_TYPECODE[55] = 0;
        OID_TO_TYPECODE[56] = 0;
        OID_TO_TYPECODE[57] = 0;
        OID_TO_TYPECODE[58] = 58;
        OID_TO_TYPECODE[59] = 185;
        OID_TO_TYPECODE[60] = 186;
        OID_TO_TYPECODE[61] = 187;
        OID_TO_TYPECODE[62] = 188;
        OID_TO_TYPECODE[63] = 189;
        OID_TO_TYPECODE[64] = 190;
        OID_TO_TYPECODE[65] = 232;
        OID_TO_TYPECODE[66] = 0;
        OID_TO_TYPECODE[67] = 0;
        OID_TO_TYPECODE[68] = 100;
        OID_TO_TYPECODE[69] = 101;
        OID_TO_TYPECODE[70] = 104;
        typeCodeTypeNameMap = null;

        try {
            getTypeCodeTypeNameMap();
        } catch (Exception var1) {
        }

        _Copyright_2007_Oracle_All_Rights_Reserved_ = null;
    }
}
