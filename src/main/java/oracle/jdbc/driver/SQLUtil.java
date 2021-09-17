//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package oracle.jdbc.driver;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.sql.Date;
import java.sql.SQLData;
import java.sql.SQLException;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Hashtable;
import java.util.Map;
import oracle.jdbc.OracleData;
import oracle.jdbc.OracleDataFactory;
import oracle.jdbc.internal.OracleConnection;
import oracle.jdbc.oracore.OracleNamedType;
import oracle.jdbc.oracore.OracleTypeADT;
import oracle.jdbc.oracore.OracleTypeCOLLECTION;
import oracle.jdbc.oracore.OracleTypeOPAQUE;
import oracle.sql.ARRAY;
import oracle.sql.ArrayDescriptor;
import oracle.sql.BFILE;
import oracle.sql.BINARY_DOUBLE;
import oracle.sql.BINARY_FLOAT;
import oracle.sql.BLOB;
import oracle.sql.CHAR;
import oracle.sql.CLOB;
import oracle.sql.CharacterSet;
import oracle.sql.CustomDatum;
import oracle.sql.CustomDatumFactory;
import oracle.sql.DATE;
import oracle.sql.Datum;
import oracle.sql.INTERVALDS;
import oracle.sql.INTERVALYM;
import oracle.sql.JAVA_STRUCT;
import oracle.sql.NUMBER;
import oracle.sql.OPAQUE;
import oracle.sql.ORAData;
import oracle.sql.ORADataFactory;
import oracle.sql.OpaqueDescriptor;
import oracle.sql.RAW;
import oracle.sql.REF;
import oracle.sql.ROWID;
import oracle.sql.SQLName;
import oracle.sql.STRUCT;
import oracle.sql.StructDescriptor;
import oracle.sql.TIMESTAMP;
import oracle.sql.TIMESTAMPLTZ;
import oracle.sql.TIMESTAMPTZ;
import oracle.sql.TypeDescriptor;
import oracle.sql.converter.CharacterSetMetaData;
import oracle.xdb.XMLType;

public class SQLUtil {
    private static final String _Copyright_2007_Oracle_All_Rights_Reserved_ = null;
    public static final String BUILD_DATE = "Thu_Apr_04_15:09:24_PDT_2013";
    public static final boolean TRACE = false;
    private static final int CLASS_NOT_FOUND = -1;
    private static final int CLASS_STRING = 0;
    private static final int CLASS_BOOLEAN = 1;
    private static final int CLASS_INTEGER = 2;
    private static final int CLASS_LONG = 3;
    private static final int CLASS_FLOAT = 4;
    private static final int CLASS_DOUBLE = 5;
    private static final int CLASS_BIGDECIMAL = 6;
    private static final int CLASS_DATE = 7;
    private static final int CLASS_TIME = 8;
    private static final int CLASS_TIMESTAMP = 9;
    private static final int CLASS_SHORT = 10;
    private static final int CLASS_BYTE = 11;
    private static final int TOTAL_CLASSES = 12;
    private static Hashtable classTable = new Hashtable(12);

    public SQLUtil() {
    }

    public static Object SQLToJava(OracleConnection var0, byte[] var1, int var2, String var3, Class var4, Map var5) throws SQLException {
        Datum var6 = makeDatum(var0, var1, var2, var3, 0);
        Object var7 = SQLToJava(var0, var6, var4, var5);
        return var7;
    }

    public static CustomDatum SQLToJava(OracleConnection var0, byte[] var1, int var2, String var3, CustomDatumFactory var4) throws SQLException {
        Datum var5 = makeDatum(var0, var1, var2, var3, 0);
        CustomDatum var6 = var4.create(var5, var2);
        return var6;
    }

    public static ORAData SQLToJava(OracleConnection var0, byte[] var1, int var2, String var3, ORADataFactory var4) throws SQLException {
        Datum var5 = makeDatum(var0, var1, var2, var3, 0);
        ORAData var6 = var4.create(var5, var2);
        return var6;
    }

    public static OracleData SQLToJava(OracleConnection var0, byte[] var1, int var2, String var3, OracleDataFactory var4) throws SQLException {
        Datum var5 = makeDatum(var0, var1, var2, var3, 0);
        OracleData var6 = var4.create(var5.toJdbc(), var2);
        return var6;
    }

    public static Object SQLToJava(OracleConnection var0, Datum var1, Class var2, Map var3) throws SQLException {
        Object var4 = null;
        if (var1 instanceof STRUCT) {
            if (var2 == null) {
                var4 = var3 != null ? ((STRUCT)var1).toJdbc(var3) : var1.toJdbc();
            } else {
                var4 = var3 != null ? ((STRUCT)var1).toClass(var2, var3) : ((STRUCT)var1).toClass(var2);
            }
        } else if (var2 == null) {
            var4 = var1.toJdbc();
        } else {
            int var5 = classNumber(var2);
            switch(var5) {
                case -1:
                default:
                    var4 = var1.toJdbc();
                    if (!var2.isInstance(var4)) {
                        SQLException var6 = DatabaseError.createSqlException((OracleConnection)null, 59, "invalid data conversion");
                        var6.fillInStackTrace();
                        throw var6;
                    }
                    break;
                case 0:
                    var4 = var1.stringValue();
                    break;
                case 1:
                    var4 = var1.longValue() != 0L;
                    break;
                case 2:
                    var4 = (int)var1.longValue();
                    break;
                case 3:
                    var4 = var1.longValue();
                    break;
                case 4:
                    var4 = var1.bigDecimalValue().floatValue();
                    break;
                case 5:
                    var4 = var1.bigDecimalValue().doubleValue();
                    break;
                case 6:
                    var4 = var1.bigDecimalValue();
                    break;
                case 7:
                    var4 = var1.dateValue();
                    break;
                case 8:
                    var4 = var1.timeValue();
                    break;
                case 9:
                    var4 = var1.timestampValue();
                    break;
                case 10:
                    var4 = (short)((int)var1.longValue());
                    break;
                case 11:
                    var4 = (byte)((int)var1.longValue());
            }
        }

        return var4;
    }

    public static byte[] JavaToSQL(OracleConnection var0, Object var1, int var2, String var3) throws SQLException {
        if (var1 == null) {
            return null;
        } else {
            Object var4 = null;
            if (var1 instanceof Datum) {
                var4 = (Datum)var1;
            } else if (var1 instanceof ORAData) {
                var4 = ((ORAData)var1).toDatum(var0);
            } else if (var1 instanceof CustomDatum) {
                var4 = var0.toDatum((CustomDatum)var1);
            } else if (var1 instanceof SQLData) {
                var4 = STRUCT.toSTRUCT(var1, var0);
            }

            if (var4 != null) {
                if (!checkDatumType((Datum)var4, var2, var3)) {
                    var4 = null;
                }
            } else {
                var4 = makeDatum(var0, var1, var2, var3);
            }

            Object var5 = null;
            if (var4 != null) {
                byte[] var7;
                if (var4 instanceof STRUCT) {
                    var7 = ((STRUCT)var4).toBytes();
                } else if (var4 instanceof ARRAY) {
                    var7 = ((ARRAY)var4).toBytes();
                } else if (var4 instanceof OPAQUE) {
                    var7 = ((OPAQUE)var4).toBytes();
                } else {
                    var7 = ((Datum)var4).shareBytes();
                }

                return var7;
            } else {
                SQLException var6 = DatabaseError.createSqlException((OracleConnection)null, 1, "attempt to convert a Datum to incompatible SQL type");
                var6.fillInStackTrace();
                throw var6;
            }
        }
    }

    public static Datum makeDatum(OracleConnection var0, byte[] var1, int var2, String var3, int var4) throws SQLException {
        Object var5 = null;
        short var6 = var0.getDbCsId();
        short var7 = var0.getJdbcCsId();
        int var8 = CharacterSetMetaData.getRatio(var7, var6);
        SQLException var12;
        switch(var2) {
            case 1:
            case 8:
                var5 = new CHAR(var1, CharacterSet.make(var0.getJdbcCsId()));
                break;
            case 2:
            case 6:
                var5 = new NUMBER(var1);
                break;
            case 12:
                var5 = new DATE(var1);
                break;
            case 23:
            case 24:
                var5 = new RAW(var1);
                break;
            case 96:
                if (var4 != 0 && var4 < var1.length && var8 == 1) {
                    var5 = new CHAR(var1, 0, var4, CharacterSet.make(var0.getJdbcCsId()));
                } else {
                    var5 = new CHAR(var1, CharacterSet.make(var0.getJdbcCsId()));
                }
                break;
            case 100:
                var5 = new BINARY_FLOAT(var1);
                break;
            case 101:
                var5 = new BINARY_DOUBLE(var1);
                break;
            case 102:
                var12 = DatabaseError.createSqlException((OracleConnection)null, 1, "need resolution: do we want to handle ResultSet?");
                var12.fillInStackTrace();
                throw var12;
            case 104:
                var5 = new ROWID(var1);
                break;
            case 109:
                TypeDescriptor var11 = TypeDescriptor.getTypeDescriptor(var3, var0, var1, 0L);
                switch(var11.getTypeCode()) {
                    case 2002:
                        var5 = new STRUCT((StructDescriptor)var11, var1, var0);
                        return (Datum)var5;
                    case 2003:
                        var5 = new ARRAY((ArrayDescriptor)var11, var1, var0);
                        return (Datum)var5;
                    case 2004:
                    case 2005:
                    case 2006:
                    default:
                        return (Datum)var5;
                    case 2007:
                        var5 = new OPAQUE((OpaqueDescriptor)var11, var1, var0);
                        return (Datum)var5;
                    case 2008:
                        var5 = new JAVA_STRUCT((StructDescriptor)var11, var1, var0);
                        return (Datum)var5;
                    case 2009:
                        var5 = SQLUtil.XMLFactory.createXML(new OPAQUE((OpaqueDescriptor)var11, var1, var0));
                        return (Datum)var5;
                }
            case 111:
                Object var9 = getTypeDescriptor(var3, var0);
                if (!(var9 instanceof StructDescriptor)) {
                    SQLException var10 = DatabaseError.createSqlException((OracleConnection)null, 1, "program error: REF points to a non-STRUCT");
                    var10.fillInStackTrace();
                    throw var10;
                }

                var5 = new REF((StructDescriptor)var9, var0, var1);
                break;
            case 112:
                var5 = var0.createClob(var1);
                break;
            case 113:
                var5 = var0.createBlob(var1);
                break;
            case 114:
                var5 = var0.createBfile(var1);
                break;
            case 180:
                var5 = new TIMESTAMP(var1);
                break;
            case 181:
                var5 = new TIMESTAMPTZ(var1);
                break;
            case 182:
                var5 = new INTERVALYM(var1);
                break;
            case 183:
                var5 = new INTERVALDS(var1);
                break;
            case 231:
                var5 = new TIMESTAMPLTZ(var1);
                break;
            case 257:
                var5 = SQLUtil.XMLFactory.createXML(var0, (InputStream)(new ByteArrayInputStream(var1)));
                break;
            default:
                var12 = DatabaseError.createSqlException((OracleConnection)null, 1, "program error: invalid SQL type code");
                var12.fillInStackTrace();
                throw var12;
        }

        return (Datum)var5;
    }

    public static Datum makeNDatum(OracleConnection var0, byte[] var1, int var2, String var3, short var4, int var5) throws SQLException {
        Object var6 = null;
        switch(var2) {
            case 1:
            case 8:
                var6 = new CHAR(var1, CharacterSet.make(var0.getNCharSet()));
                break;
            case 96:
                int var7 = var5 * CharacterSetMetaData.getRatio(var0.getNCharSet(), 1);
                if (var5 != 0 && var7 < var1.length) {
                    var6 = new CHAR(var1, 0, var5, CharacterSet.make(var0.getNCharSet()));
                } else {
                    var6 = new CHAR(var1, CharacterSet.make(var0.getNCharSet()));
                }
                break;
            case 112:
                var6 = var0.createClob(var1, var4);
                break;
            default:
                SQLException var8 = DatabaseError.createSqlException((OracleConnection)null, 1, "program error: invalid SQL type code");
                var8.fillInStackTrace();
                throw var8;
        }

        return (Datum)var6;
    }

    public static Datum makeDatum(OracleConnection var0, Object var1, int var2, String var3) throws SQLException {
        return makeDatum(var0, var1, var2, var3, false);
    }

    public static Datum makeDatum(OracleConnection var0, Object var1, int var2, String var3, boolean var4) throws SQLException {
        Object var5 = null;
        SQLException var7;
        switch(var2) {
            case 1:
            case 8:
            case 96:
                var5 = new CHAR(var1, CharacterSet.make(var4 ? var0.getNCharSet() : var0.getJdbcCsId()));
                break;
            case 2:
            case 6:
                var5 = new NUMBER(var1);
                break;
            case 12:
                var5 = new DATE(var1);
                break;
            case 23:
            case 24:
                var5 = new RAW(var1);
                break;
            case 100:
                if (var1 instanceof String) {
                    var5 = new BINARY_FLOAT((String)var1);
                } else if (var1 instanceof Boolean) {
                    var5 = new BINARY_FLOAT((Boolean)var1);
                } else {
                    var5 = new BINARY_FLOAT((Float)var1);
                }
                break;
            case 101:
                if (var1 instanceof String) {
                    var5 = new BINARY_DOUBLE((String)var1);
                } else if (var1 instanceof Boolean) {
                    var5 = new BINARY_DOUBLE((Boolean)var1);
                } else {
                    var5 = new BINARY_DOUBLE((Double)var1);
                }
                break;
            case 102:
                var7 = DatabaseError.createSqlException((OracleConnection)null, 1, "need resolution: do we want to handle ResultSet");
                var7.fillInStackTrace();
                throw var7;
            case 104:
                if (var1 instanceof String) {
                    var5 = new ROWID((String)var1);
                } else if (var1 instanceof byte[]) {
                    var5 = new ROWID((byte[])((byte[])var1));
                }
                break;
            case 109:
                if (var1 instanceof STRUCT || var1 instanceof ARRAY || var1 instanceof OPAQUE) {
                    var5 = (Datum)var1;
                }
                break;
            case 111:
                if (var1 instanceof REF) {
                    var5 = (Datum)var1;
                }
                break;
            case 112:
                if (var1 instanceof CLOB) {
                    var5 = (Datum)var1;
                }

                if (var1 instanceof String) {
                    CharacterSet var6 = CharacterSet.make(var4 ? var0.getNCharSet() : var0.getJdbcCsId());
                    var5 = new CHAR((String)var1, var6);
                }
                break;
            case 113:
                if (var1 instanceof BLOB) {
                    var5 = (Datum)var1;
                }

                if (var1 instanceof byte[]) {
                    var5 = new RAW((byte[])((byte[])var1));
                }
                break;
            case 114:
                if (var1 instanceof BFILE) {
                    var5 = (Datum)var1;
                }
                break;
            case 180:
                if (var1 instanceof TIMESTAMP) {
                    var5 = (Datum)var1;
                } else if (var1 instanceof Timestamp) {
                    var5 = new TIMESTAMP((Timestamp)var1);
                } else if (var1 instanceof Date) {
                    var5 = new TIMESTAMP((Date)var1);
                } else if (var1 instanceof Time) {
                    var5 = new TIMESTAMP((Time)var1);
                } else if (var1 instanceof DATE) {
                    var5 = new TIMESTAMP((DATE)var1);
                } else if (var1 instanceof String) {
                    var5 = new TIMESTAMP((String)var1);
                } else if (var1 instanceof byte[]) {
                    var5 = new TIMESTAMP((byte[])((byte[])var1));
                }
                break;
            case 181:
                if (var1 instanceof TIMESTAMPTZ) {
                    var5 = (Datum)var1;
                } else if (var1 instanceof Timestamp) {
                    var5 = new TIMESTAMPTZ(var0, (Timestamp)var1);
                } else if (var1 instanceof Date) {
                    var5 = new TIMESTAMPTZ(var0, (Date)var1);
                } else if (var1 instanceof Time) {
                    var5 = new TIMESTAMPTZ(var0, (Time)var1);
                } else if (var1 instanceof DATE) {
                    var5 = new TIMESTAMPTZ(var0, (DATE)var1);
                } else if (var1 instanceof String) {
                    var5 = new TIMESTAMPTZ(var0, (String)var1);
                } else if (var1 instanceof byte[]) {
                    var5 = new TIMESTAMPTZ((byte[])((byte[])var1));
                }
                break;
            case 231:
                if (var1 instanceof TIMESTAMPLTZ) {
                    var5 = (Datum)var1;
                } else if (var1 instanceof Timestamp) {
                    var5 = new TIMESTAMPLTZ(var0, (Timestamp)var1);
                } else if (var1 instanceof Date) {
                    var5 = new TIMESTAMPLTZ(var0, (Date)var1);
                } else if (var1 instanceof Time) {
                    var5 = new TIMESTAMPLTZ(var0, (Time)var1);
                } else if (var1 instanceof DATE) {
                    var5 = new TIMESTAMPLTZ(var0, (DATE)var1);
                } else if (var1 instanceof String) {
                    var5 = new TIMESTAMPLTZ(var0, (String)var1);
                } else if (var1 instanceof byte[]) {
                    var5 = new TIMESTAMPLTZ((byte[])((byte[])var1));
                }
                break;
            case 257:
                if (var1 instanceof String) {
                    var5 = SQLUtil.XMLFactory.createXML(var0, (String)var1);
                }
        }

        if (var5 == null) {
            var7 = DatabaseError.createSqlException((OracleConnection)null, 1, "Unable to construct a Datum from the specified input");
            var7.fillInStackTrace();
            throw var7;
        } else {
            return (Datum)var5;
        }
    }

    private static int classNumber(Class var0) {
        int var1 = -1;
        Integer var2 = (Integer)classTable.get(var0);
        if (var2 != null) {
            var1 = var2;
        }

        return var1;
    }

    public static Object getTypeDescriptor(String var0, OracleConnection var1) throws SQLException {
        Object var2 = null;
        SQLName var3 = new SQLName(var0, var1);
        String var4 = var3.getName();
        var2 = var1.getDescriptor(var4);
        if (var2 != null) {
            return var2;
        } else {
            OracleTypeADT var5 = new OracleTypeADT(var4, var1);
            var5.init(var1);
            OracleNamedType var6 = var5.cleanup();
            switch(var6.getTypeCode()) {
                case 2002:
                case 2008:
                    var2 = new StructDescriptor(var3, (OracleTypeADT)var6, var1);
                    break;
                case 2003:
                    var2 = new ArrayDescriptor(var3, (OracleTypeCOLLECTION)var6, var1);
                    break;
                case 2004:
                case 2005:
                case 2006:
                default:
                    SQLException var7 = DatabaseError.createSqlException((OracleConnection)null, 1, "Unrecognized type code");
                    var7.fillInStackTrace();
                    throw var7;
                case 2007:
                    var2 = new OpaqueDescriptor(var3, (OracleTypeOPAQUE)var6, var1);
            }

            var1.putDescriptor(var4, var2);
            return var2;
        }
    }

    public static boolean checkDatumType(Datum var0, int var1, String var2) throws SQLException {
        boolean var3 = false;
        switch(var1) {
            case 1:
            case 8:
            case 96:
                var3 = var0 instanceof CHAR;
                break;
            case 2:
            case 6:
                var3 = var0 instanceof NUMBER;
                break;
            case 12:
                var3 = var0 instanceof DATE;
                break;
            case 23:
            case 24:
                var3 = var0 instanceof RAW;
                break;
            case 100:
                var3 = var0 instanceof BINARY_FLOAT;
                break;
            case 101:
                var3 = var0 instanceof BINARY_DOUBLE;
                break;
            case 102:
            default:
                var3 = false;
                break;
            case 104:
                var3 = var0 instanceof ROWID;
                break;
            case 109:
                if (var0 instanceof STRUCT) {
                    var3 = ((STRUCT)var0).isInHierarchyOf(var2);
                } else if (var0 instanceof ARRAY) {
                    var3 = ((ARRAY)var0).getSQLTypeName().equals(var2);
                } else if (var0 instanceof OPAQUE) {
                    var3 = ((OPAQUE)var0).getSQLTypeName().equals(var2);
                }
                break;
            case 111:
                var3 = var0 instanceof REF && ((REF)var0).getBaseTypeName().equals(var2);
                break;
            case 112:
                var3 = var0 instanceof CLOB;
                break;
            case 113:
                var3 = var0 instanceof BLOB;
                break;
            case 114:
                var3 = var0 instanceof BFILE;
                break;
            case 180:
                var3 = var0 instanceof TIMESTAMP;
                break;
            case 181:
                var3 = var0 instanceof TIMESTAMPTZ;
                break;
            case 231:
                var3 = var0 instanceof TIMESTAMPLTZ;
        }

        return var3;
    }

    public static boolean implementsInterface(Class var0, Class var1) {
        if (var0 == null) {
            return false;
        } else if (var0 == var1) {
            return true;
        } else {
            Class[] var2 = var0.getInterfaces();

            for(int var3 = 0; var3 < var2.length; ++var3) {
                if (implementsInterface(var2[var3], var1)) {
                    return true;
                }
            }

            return implementsInterface(var0.getSuperclass(), var1);
        }
    }

    public static Datum makeOracleDatum(OracleConnection var0, Object var1, int var2, String var3) throws SQLException {
        return makeOracleDatum(var0, var1, var2, var3, false);
    }

    public static Datum makeOracleDatum(OracleConnection var0, Object var1, int var2, String var3, boolean var4) throws SQLException {
        Datum var5 = makeDatum(var0, var1, getInternalType(var2), var3, var4);
        return var5;
    }

    public static int getInternalType(int var0) throws SQLException {
        boolean var1 = false;
        short var3;
        switch(var0) {
            case -104:
                var3 = 183;
                break;
            case -103:
                var3 = 182;
                break;
            case -102:
                var3 = 231;
                break;
            case -101:
                var3 = 181;
                break;
            case -100:
            case 93:
                var3 = 180;
                break;
            case -15:
                var3 = 96;
                break;
            case -13:
                var3 = 114;
                break;
            case -10:
                var3 = 102;
                break;
            case -9:
                var3 = 1;
                break;
            case -8:
                var3 = 104;
                break;
            case -7:
            case -6:
            case -5:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
                var3 = 6;
                break;
            case -4:
                var3 = 24;
                break;
            case -3:
            case -2:
                var3 = 23;
                break;
            case -1:
                var3 = 8;
                break;
            case 1:
                var3 = 96;
                break;
            case 12:
                var3 = 1;
                break;
            case 91:
            case 92:
                var3 = 12;
                break;
            case 100:
                var3 = 100;
                break;
            case 101:
                var3 = 101;
                break;
            case 999:
                var3 = 999;
                break;
            case 2002:
            case 2003:
            case 2007:
            case 2008:
                var3 = 109;
                break;
            case 2004:
                var3 = 113;
                break;
            case 2005:
                var3 = 112;
                break;
            case 2006:
                var3 = 111;
                break;
            case 2009:
                var3 = 257;
                break;
            case 2011:
                var3 = 112;
                break;
            default:
                SQLException var2 = DatabaseError.createSqlException((OracleConnection)null, 4, "get_internal_type");
                var2.fillInStackTrace();
                throw var2;
        }

        return var3;
    }

    protected OracleConnection getConnectionDuringExceptionHandling() {
        return null;
    }

    static {
        try {
            classTable.put(Class.forName("java.lang.String"), 0);
            classTable.put(Class.forName("java.lang.Boolean"), 1);
            classTable.put(Class.forName("java.lang.Integer"), 2);
            classTable.put(Class.forName("java.lang.Long"), 3);
            classTable.put(Class.forName("java.lang.Float"), 4);
            classTable.put(Class.forName("java.lang.Double"), 5);
            classTable.put(Class.forName("java.math.BigDecimal"), 6);
            classTable.put(Class.forName("java.sql.Date"), 7);
            classTable.put(Class.forName("java.sql.Time"), 8);
            classTable.put(Class.forName("java.sql.Timestamp"), 9);
            classTable.put(Class.forName("java.lang.Short"), 10);
            classTable.put(Class.forName("java.lang.Byte"), 11);
        } catch (ClassNotFoundException var1) {
        }

    }

    private static class XMLFactory {
        private XMLFactory() {
        }

        static Datum createXML(OPAQUE var0) throws SQLException {
            return XMLType.createXML(var0);
        }

        static Datum createXML(OracleConnection var0, String var1) throws SQLException {
            return XMLType.createXML(var0, var1);
        }

        static Datum createXML(OracleConnection var0, InputStream var1) throws SQLException {
            return XMLType.createXML(var0, var1);
        }
    }
}
