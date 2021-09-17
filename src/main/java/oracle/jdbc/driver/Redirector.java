//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package oracle.jdbc.driver;

import java.io.InputStream;
import java.io.Reader;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.URL;
import java.sql.Array;
import java.sql.Blob;
import java.sql.Clob;
import java.sql.Date;
import java.sql.NClob;
import java.sql.Ref;
import java.sql.ResultSet;
import java.sql.RowId;
import java.sql.SQLException;
import java.sql.SQLXML;
import java.sql.Struct;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import oracle.jdbc.OracleArray;
import oracle.jdbc.OracleBfile;
import oracle.jdbc.OracleBlob;
import oracle.jdbc.OracleClob;
import oracle.jdbc.OracleData;
import oracle.jdbc.OracleOpaque;
import oracle.jdbc.OracleRef;
import oracle.jdbc.internal.OracleConnection;
import oracle.sql.ARRAY;
import oracle.sql.BFILE;
import oracle.sql.BINARY_DOUBLE;
import oracle.sql.BINARY_FLOAT;
import oracle.sql.BLOB;
import oracle.sql.CHAR;
import oracle.sql.CLOB;
import oracle.sql.DATE;
import oracle.sql.INTERVALDS;
import oracle.sql.INTERVALYM;
import oracle.sql.NUMBER;
import oracle.sql.OPAQUE;
import oracle.sql.ORAData;
import oracle.sql.RAW;
import oracle.sql.REF;
import oracle.sql.ROWID;
import oracle.sql.STRUCT;
import oracle.sql.TIMESTAMP;
import oracle.sql.TIMESTAMPLTZ;
import oracle.sql.TIMESTAMPTZ;

abstract class Redirector<T> {
    private final Class<T> type;
    private static final HashMap<Class, Redirector> CLASS_TO_REDIRECTOR = new HashMap();
    private static final HashMap<Class, Redirector> CLASS_TO_ERROR;
    private static final String _Copyright_2007_Oracle_All_Rights_Reserved_;
    public static final String BUILD_DATE = "Thu_Apr_04_15:09:24_PDT_2013";
    public static final boolean TRACE = false;

    private Redirector(Class<T> var1) {
        this.type = var1;
    }

    abstract T redirect(Accessor var1, int var2) throws SQLException;

    final Class<T> getTarget() {
        return this.type;
    }

    public String toString() {
        return super.toString() + "[" + this.type.getName() + "]";
    }

    static <V> Redirector<V> createObjectRedirector(Class<V> var0) {
        return new Redirector<V>(var0) {
            final V redirect(Accessor var1, int var2) throws SQLException {
                try {
                    Object var3 = var1.getObject(var2);
                    Class var7 = this.getTarget();
                    if (var3 != null && !var7.isInstance(var3)) {
                        SQLException var5 = DatabaseError.createSqlException((OracleConnection)null, 49, var7.getName());
                        var5.fillInStackTrace();
                        throw var5;
                    } else {
                        return (V) var3;
                    }
                } catch (ClassCastException var6) {
                    SQLException var4 = DatabaseError.createSqlException((OracleConnection)null, 4);
                    var4.fillInStackTrace();
                    throw var4;
                }
            }
        };
    }

    static <V> Redirector<V> createValueOfRedirector(Class<V> var0, List<Class> var1) {
        if (Modifier.isPublic(var0.getModifiers())) {
            Method[] var2 = var0.getDeclaredMethods();
            int var3 = 2147483647;
            Method var4 = null;
            Class var5 = null;
            Method[] var6 = var2;
            int var7 = var2.length;

            for(int var8 = 0; var8 < var7; ++var8) {
                Method var9 = var6[var8];
                if (Modifier.isStatic(var9.getModifiers()) && Modifier.isPublic(var9.getModifiers()) && var9.getName().equals("valueOf") && var9.getParameterTypes().length == 1 && var0.isAssignableFrom(var9.getReturnType())) {
                    int var10 = 0;

                    for(Iterator var11 = var1.iterator(); var11.hasNext(); ++var10) {
                        Class var12 = (Class)var11.next();
                        if (var9.getParameterTypes()[0].isAssignableFrom(var12)) {
                            if (var10 < var3) {
                                var3 = var10;
                                var4 = var9;
                                var5 = var12;
                            }
                            break;
                        }
                    }
                }

                if (var3 == 0) {
                    break;
                }
            }

            if (var4 != null) {
                return createValueOfRedirector(var4, var5);
            }
        }

        return new Redirector<V>(var0) {
            final V redirect(Accessor var1, int var2) throws SQLException {
                SQLException var3 = DatabaseError.createSqlException((OracleConnection)null, 4);
                var3.fillInStackTrace();
                throw var3;
            }
        };
    }

    private static <V> Redirector<V> createValueOfRedirector(final Method var0, Class var1) {
        final Redirector var2 = (Redirector)CLASS_TO_REDIRECTOR.get(var1);
        return new Redirector<V>(var1) {
            public final V redirect(Accessor var1, int var2x) throws SQLException {
                SQLException var4;
                try {
                    return var1.isNull(var2x) ? null : (V) var0.invoke((Object) null, var2.redirect(var1, var2x));
                } catch (IllegalAccessException var5) {
                    var4 = DatabaseError.createSqlException((OracleConnection)null, 1, var5.getMessage());
                    var4.fillInStackTrace();
                    throw var4;
                } catch (IllegalArgumentException var6) {
                    var4 = DatabaseError.createSqlException((OracleConnection)null, 1, var6.getMessage());
                    var4.fillInStackTrace();
                    throw var4;
                } catch (InvocationTargetException var7) {
                    if (var7.getTargetException() instanceof SQLException) {
                        throw (SQLException)var7.getTargetException();
                    } else {
                        var4 = DatabaseError.createSqlException((OracleConnection)null, 1, "Got something other than a SQLException: " + var7.getTargetException());
                        var4.fillInStackTrace();
                        throw var4;
                    }
                }
            }
        };
    }

    static Map<Class, Redirector> createRedirectorMap(Collection<Class> var0) {
        Map var1 = (Map)CLASS_TO_ERROR.clone();
        Iterator var2 = var0.iterator();

        while(var2.hasNext()) {
            Class var3 = (Class)var2.next();

            assert CLASS_TO_REDIRECTOR.get(var3) != null : var3;

            var1.put(var3, CLASS_TO_REDIRECTOR.get(var3));
        }

        return var1;
    }

    static oracle.jdbc.driver.OracleConnection getConnectionDuringExceptionHandling() {
        return null;
    }

    static {
        CLASS_TO_REDIRECTOR.put(Array.class, new Redirector<Array>(Array.class) {
            final Array redirect(Accessor var1, int var2) throws SQLException {
                return var1.getARRAY(var2);
            }
        });
        CLASS_TO_REDIRECTOR.put(BigDecimal.class, new Redirector<BigDecimal>(BigDecimal.class) {
            final BigDecimal redirect(Accessor var1, int var2) throws SQLException {
                return var1.getBigDecimal(var2);
            }
        });
        CLASS_TO_REDIRECTOR.put(Blob.class, new Redirector<Blob>(Blob.class) {
            final Blob redirect(Accessor var1, int var2) throws SQLException {
                return var1.getBLOB(var2);
            }
        });
        CLASS_TO_REDIRECTOR.put(Boolean.class, new Redirector<Boolean>(Boolean.class) {
            final Boolean redirect(Accessor var1, int var2) throws SQLException {
                return var1.getBoolean(var2);
            }
        });
        CLASS_TO_REDIRECTOR.put(Byte.class, new Redirector<Byte>(Byte.class) {
            final Byte redirect(Accessor var1, int var2) throws SQLException {
                return var1.getByte(var2);
            }
        });
        CLASS_TO_REDIRECTOR.put(byte[].class, new Redirector<byte[]>(byte[].class) {
            final byte[] redirect(Accessor var1, int var2) throws SQLException {
                return var1.getBytes(var2);
            }
        });
        CLASS_TO_REDIRECTOR.put(Clob.class, new Redirector<Clob>(Clob.class) {
            final Clob redirect(Accessor var1, int var2) throws SQLException {
                return var1.getCLOB(var2);
            }
        });
        CLASS_TO_REDIRECTOR.put(Date.class, new Redirector<Date>(Date.class) {
            final Date redirect(Accessor var1, int var2) throws SQLException {
                return var1.getDate(var2);
            }
        });
        CLASS_TO_REDIRECTOR.put(Double.class, new Redirector<Double>(Double.class) {
            final Double redirect(Accessor var1, int var2) throws SQLException {
                return var1.getDouble(var2);
            }
        });
        CLASS_TO_REDIRECTOR.put(Float.class, new Redirector<Float>(Float.class) {
            final Float redirect(Accessor var1, int var2) throws SQLException {
                return var1.getFloat(var2);
            }
        });
        CLASS_TO_REDIRECTOR.put(Integer.class, new Redirector<Integer>(Integer.class) {
            final Integer redirect(Accessor var1, int var2) throws SQLException {
                return var1.getInt(var2);
            }
        });
        CLASS_TO_REDIRECTOR.put(Long.class, new Redirector<Long>(Long.class) {
            final Long redirect(Accessor var1, int var2) throws SQLException {
                return var1.getLong(var2);
            }
        });
        CLASS_TO_REDIRECTOR.put(NClob.class, new Redirector<NClob>(NClob.class) {
            final NClob redirect(Accessor var1, int var2) throws SQLException {
                return var1.getNClob(var2);
            }
        });
        CLASS_TO_REDIRECTOR.put(Ref.class, new Redirector<Ref>(Ref.class) {
            final Ref redirect(Accessor var1, int var2) throws SQLException {
                return var1.getREF(var2);
            }
        });
        CLASS_TO_REDIRECTOR.put(RowId.class, new Redirector<RowId>(RowId.class) {
            final RowId redirect(Accessor var1, int var2) throws SQLException {
                return var1.getROWID(var2);
            }
        });
        CLASS_TO_REDIRECTOR.put(Short.class, new Redirector<Short>(Short.class) {
            final Short redirect(Accessor var1, int var2) throws SQLException {
                return var1.getShort(var2);
            }
        });
        CLASS_TO_REDIRECTOR.put(SQLXML.class, new Redirector<SQLXML>(SQLXML.class) {
            final SQLXML redirect(Accessor var1, int var2) throws SQLException {
                return var1.getSQLXML(var2);
            }
        });
        CLASS_TO_REDIRECTOR.put(String.class, new Redirector<String>(String.class) {
            final String redirect(Accessor var1, int var2) throws SQLException {
                return var1.getString(var2);
            }
        });
        CLASS_TO_REDIRECTOR.put(Struct.class, new Redirector<Struct>(Struct.class) {
            final Struct redirect(Accessor var1, int var2) throws SQLException {
                return var1.getStruct(var2);
            }
        });
        CLASS_TO_REDIRECTOR.put(Time.class, new Redirector<Time>(Time.class) {
            final Time redirect(Accessor var1, int var2) throws SQLException {
                return var1.getTime(var2);
            }
        });
        CLASS_TO_REDIRECTOR.put(Timestamp.class, new Redirector<Timestamp>(Timestamp.class) {
            final Timestamp redirect(Accessor var1, int var2) throws SQLException {
                return var1.getTimestamp(var2);
            }
        });
        CLASS_TO_REDIRECTOR.put(URL.class, new Redirector<URL>(URL.class) {
            final URL redirect(Accessor var1, int var2) throws SQLException {
                return var1.getURL(var2);
            }
        });
        CLASS_TO_REDIRECTOR.put(BigInteger.class, new Redirector<BigInteger>(BigInteger.class) {
            final BigInteger redirect(Accessor var1, int var2) throws SQLException {
                return var1.getBigInteger(var2);
            }
        });
        CLASS_TO_REDIRECTOR.put(java.util.Date.class, new Redirector<java.util.Date>(java.util.Date.class) {
            final java.util.Date redirect(Accessor var1, int var2) throws SQLException {
                return var1.getJavaUtilDate(var2);
            }
        });
        CLASS_TO_REDIRECTOR.put(Calendar.class, new Redirector<Calendar>(Calendar.class) {
            final Calendar redirect(Accessor var1, int var2) throws SQLException {
                return var1.getCalendar(var2);
            }
        });
        CLASS_TO_REDIRECTOR.put(ARRAY.class, new Redirector<ARRAY>(ARRAY.class) {
            final ARRAY redirect(Accessor var1, int var2) throws SQLException {
                return var1.getARRAY(var2);
            }
        });
        CLASS_TO_REDIRECTOR.put(BFILE.class, new Redirector<BFILE>(BFILE.class) {
            final BFILE redirect(Accessor var1, int var2) throws SQLException {
                return var1.getBFILE(var2);
            }
        });
        CLASS_TO_REDIRECTOR.put(BINARY_FLOAT.class, new Redirector<BINARY_FLOAT>(BINARY_FLOAT.class) {
            final BINARY_FLOAT redirect(Accessor var1, int var2) throws SQLException {
                return var1.getBINARY_FLOAT(var2);
            }
        });
        CLASS_TO_REDIRECTOR.put(BINARY_DOUBLE.class, new Redirector<BINARY_DOUBLE>(BINARY_DOUBLE.class) {
            final BINARY_DOUBLE redirect(Accessor var1, int var2) throws SQLException {
                return var1.getBINARY_DOUBLE(var2);
            }
        });
        CLASS_TO_REDIRECTOR.put(BLOB.class, new Redirector<BLOB>(BLOB.class) {
            final BLOB redirect(Accessor var1, int var2) throws SQLException {
                return var1.getBLOB(var2);
            }
        });
        CLASS_TO_REDIRECTOR.put(CHAR.class, new Redirector<CHAR>(CHAR.class) {
            final CHAR redirect(Accessor var1, int var2) throws SQLException {
                return var1.getCHAR(var2);
            }
        });
        CLASS_TO_REDIRECTOR.put(CLOB.class, new Redirector<CLOB>(CLOB.class) {
            final CLOB redirect(Accessor var1, int var2) throws SQLException {
                return var1.getCLOB(var2);
            }
        });
        CLASS_TO_REDIRECTOR.put(ResultSet.class, new Redirector<ResultSet>(ResultSet.class) {
            final ResultSet redirect(Accessor var1, int var2) throws SQLException {
                return var1.getCursor(var2);
            }
        });
        CLASS_TO_REDIRECTOR.put(DATE.class, new Redirector<DATE>(DATE.class) {
            final DATE redirect(Accessor var1, int var2) throws SQLException {
                return var1.getDATE(var2);
            }
        });
        CLASS_TO_REDIRECTOR.put(INTERVALDS.class, new Redirector<INTERVALDS>(INTERVALDS.class) {
            final INTERVALDS redirect(Accessor var1, int var2) throws SQLException {
                return var1.getINTERVALDS(var2);
            }
        });
        CLASS_TO_REDIRECTOR.put(INTERVALYM.class, new Redirector<INTERVALYM>(INTERVALYM.class) {
            final INTERVALYM redirect(Accessor var1, int var2) throws SQLException {
                return var1.getINTERVALYM(var2);
            }
        });
        CLASS_TO_REDIRECTOR.put(NUMBER.class, new Redirector<NUMBER>(NUMBER.class) {
            final NUMBER redirect(Accessor var1, int var2) throws SQLException {
                return var1.getNUMBER(var2);
            }
        });
        CLASS_TO_REDIRECTOR.put(OPAQUE.class, new Redirector<OPAQUE>(OPAQUE.class) {
            final OPAQUE redirect(Accessor var1, int var2) throws SQLException {
                return var1.getOPAQUE(var2);
            }
        });
        CLASS_TO_REDIRECTOR.put(ORAData.class, new Redirector<ORAData>(ORAData.class) {
            final ORAData redirect(Accessor var1, int var2) throws SQLException {
                return var1.getORAData(var2);
            }
        });
        CLASS_TO_REDIRECTOR.put(OracleData.class, new Redirector<OracleData>(OracleData.class) {
            final OracleData redirect(Accessor var1, int var2) throws SQLException {
                return var1.getOracleData(var2);
            }
        });
        CLASS_TO_REDIRECTOR.put(RAW.class, new Redirector<RAW>(RAW.class) {
            final RAW redirect(Accessor var1, int var2) throws SQLException {
                return var1.getRAW(var2);
            }
        });
        CLASS_TO_REDIRECTOR.put(REF.class, new Redirector<REF>(REF.class) {
            final REF redirect(Accessor var1, int var2) throws SQLException {
                return var1.getREF(var2);
            }
        });
        CLASS_TO_REDIRECTOR.put(ROWID.class, new Redirector<ROWID>(ROWID.class) {
            final ROWID redirect(Accessor var1, int var2) throws SQLException {
                return var1.getROWID(var2);
            }
        });
        CLASS_TO_REDIRECTOR.put(STRUCT.class, new Redirector<STRUCT>(STRUCT.class) {
            final STRUCT redirect(Accessor var1, int var2) throws SQLException {
                return var1.getSTRUCT(var2);
            }
        });
        CLASS_TO_REDIRECTOR.put(TIMESTAMPLTZ.class, new Redirector<TIMESTAMPLTZ>(TIMESTAMPLTZ.class) {
            final TIMESTAMPLTZ redirect(Accessor var1, int var2) throws SQLException {
                return var1.getTIMESTAMPLTZ(var2);
            }
        });
        CLASS_TO_REDIRECTOR.put(TIMESTAMPTZ.class, new Redirector<TIMESTAMPTZ>(TIMESTAMPTZ.class) {
            final TIMESTAMPTZ redirect(Accessor var1, int var2) throws SQLException {
                return var1.getTIMESTAMPTZ(var2);
            }
        });
        CLASS_TO_REDIRECTOR.put(TIMESTAMP.class, new Redirector<TIMESTAMP>(TIMESTAMP.class) {
            final TIMESTAMP redirect(Accessor var1, int var2) throws SQLException {
                return var1.getTIMESTAMP(var2);
            }
        });
        CLASS_TO_REDIRECTOR.put(OracleArray.class, new Redirector<OracleArray>(OracleArray.class) {
            final OracleArray redirect(Accessor var1, int var2) throws SQLException {
                return var1.getARRAY(var2);
            }
        });
        CLASS_TO_REDIRECTOR.put(OracleBlob.class, new Redirector<OracleBlob>(OracleBlob.class) {
            final OracleBlob redirect(Accessor var1, int var2) throws SQLException {
                return var1.getBLOB(var2);
            }
        });
        CLASS_TO_REDIRECTOR.put(OracleClob.class, new Redirector<OracleClob>(OracleClob.class) {
            final OracleClob redirect(Accessor var1, int var2) throws SQLException {
                return var1.getCLOB(var2);
            }
        });
        CLASS_TO_REDIRECTOR.put(OracleBfile.class, new Redirector<OracleBfile>(OracleBfile.class) {
            final OracleBfile redirect(Accessor var1, int var2) throws SQLException {
                return var1.getBFILE(var2);
            }
        });
        CLASS_TO_REDIRECTOR.put(OracleRef.class, new Redirector<OracleRef>(OracleRef.class) {
            final OracleRef redirect(Accessor var1, int var2) throws SQLException {
                return var1.getREF(var2);
            }
        });
        CLASS_TO_REDIRECTOR.put(OracleOpaque.class, new Redirector<OracleOpaque>(OracleOpaque.class) {
            final OracleOpaque redirect(Accessor var1, int var2) throws SQLException {
                return var1.getOPAQUE(var2);
            }
        });
        CLASS_TO_REDIRECTOR.put(InputStream.class, new Redirector<InputStream>(InputStream.class) {
            final InputStream redirect(Accessor var1, int var2) throws SQLException {
                return var1.getBinaryStream(var2);
            }
        });
        CLASS_TO_REDIRECTOR.put(Reader.class, new Redirector<Reader>(Reader.class) {
            final Reader redirect(Accessor var1, int var2) throws SQLException {
                return var1.getCharacterStream(var2);
            }
        });
        CLASS_TO_ERROR = new HashMap();
        CLASS_TO_ERROR.put(Array.class, new Redirector<Array>(Array.class) {
            final Array redirect(Accessor var1, int var2) throws SQLException {
                SQLException var3 = DatabaseError.createSqlException((OracleConnection)null, 4);
                var3.fillInStackTrace();
                throw var3;
            }
        });
        CLASS_TO_ERROR.put(BigDecimal.class, new Redirector<BigDecimal>(BigDecimal.class) {
            final BigDecimal redirect(Accessor var1, int var2) throws SQLException {
                SQLException var3 = DatabaseError.createSqlException((OracleConnection)null, 4);
                var3.fillInStackTrace();
                throw var3;
            }
        });
        CLASS_TO_ERROR.put(Blob.class, new Redirector<Blob>(Blob.class) {
            final Blob redirect(Accessor var1, int var2) throws SQLException {
                SQLException var3 = DatabaseError.createSqlException((OracleConnection)null, 4);
                var3.fillInStackTrace();
                throw var3;
            }
        });
        CLASS_TO_ERROR.put(Boolean.class, new Redirector<Boolean>(Boolean.class) {
            final Boolean redirect(Accessor var1, int var2) throws SQLException {
                SQLException var3 = DatabaseError.createSqlException((OracleConnection)null, 4);
                var3.fillInStackTrace();
                throw var3;
            }
        });
        CLASS_TO_ERROR.put(Byte.class, new Redirector<Byte>(Byte.class) {
            final Byte redirect(Accessor var1, int var2) throws SQLException {
                SQLException var3 = DatabaseError.createSqlException((OracleConnection)null, 4);
                var3.fillInStackTrace();
                throw var3;
            }
        });
        CLASS_TO_ERROR.put(byte[].class, new Redirector<byte[]>(byte[].class) {
            final byte[] redirect(Accessor var1, int var2) throws SQLException {
                SQLException var3 = DatabaseError.createSqlException((OracleConnection)null, 4);
                var3.fillInStackTrace();
                throw var3;
            }
        });
        CLASS_TO_ERROR.put(Clob.class, new Redirector<Clob>(Clob.class) {
            final Clob redirect(Accessor var1, int var2) throws SQLException {
                SQLException var3 = DatabaseError.createSqlException((OracleConnection)null, 4);
                var3.fillInStackTrace();
                throw var3;
            }
        });
        CLASS_TO_ERROR.put(Date.class, new Redirector<Date>(Date.class) {
            final Date redirect(Accessor var1, int var2) throws SQLException {
                SQLException var3 = DatabaseError.createSqlException((OracleConnection)null, 4);
                var3.fillInStackTrace();
                throw var3;
            }
        });
        CLASS_TO_ERROR.put(Double.class, new Redirector<Double>(Double.class) {
            final Double redirect(Accessor var1, int var2) throws SQLException {
                SQLException var3 = DatabaseError.createSqlException((OracleConnection)null, 4);
                var3.fillInStackTrace();
                throw var3;
            }
        });
        CLASS_TO_ERROR.put(Float.class, new Redirector<Float>(Float.class) {
            final Float redirect(Accessor var1, int var2) throws SQLException {
                SQLException var3 = DatabaseError.createSqlException((OracleConnection)null, 4);
                var3.fillInStackTrace();
                throw var3;
            }
        });
        CLASS_TO_ERROR.put(Integer.class, new Redirector<Integer>(Integer.class) {
            final Integer redirect(Accessor var1, int var2) throws SQLException {
                SQLException var3 = DatabaseError.createSqlException((OracleConnection)null, 4);
                var3.fillInStackTrace();
                throw var3;
            }
        });
        CLASS_TO_ERROR.put(Long.class, new Redirector<Long>(Long.class) {
            final Long redirect(Accessor var1, int var2) throws SQLException {
                SQLException var3 = DatabaseError.createSqlException((OracleConnection)null, 4);
                var3.fillInStackTrace();
                throw var3;
            }
        });
        CLASS_TO_ERROR.put(NClob.class, new Redirector<NClob>(NClob.class) {
            final NClob redirect(Accessor var1, int var2) throws SQLException {
                SQLException var3 = DatabaseError.createSqlException((OracleConnection)null, 4);
                var3.fillInStackTrace();
                throw var3;
            }
        });
        CLASS_TO_ERROR.put(Ref.class, new Redirector<Ref>(Ref.class) {
            final Ref redirect(Accessor var1, int var2) throws SQLException {
                SQLException var3 = DatabaseError.createSqlException((OracleConnection)null, 4);
                var3.fillInStackTrace();
                throw var3;
            }
        });
        CLASS_TO_ERROR.put(RowId.class, new Redirector<RowId>(RowId.class) {
            final RowId redirect(Accessor var1, int var2) throws SQLException {
                SQLException var3 = DatabaseError.createSqlException((OracleConnection)null, 4);
                var3.fillInStackTrace();
                throw var3;
            }
        });
        CLASS_TO_ERROR.put(Short.class, new Redirector<Short>(Short.class) {
            final Short redirect(Accessor var1, int var2) throws SQLException {
                SQLException var3 = DatabaseError.createSqlException((OracleConnection)null, 4);
                var3.fillInStackTrace();
                throw var3;
            }
        });
        CLASS_TO_ERROR.put(SQLXML.class, new Redirector<SQLXML>(SQLXML.class) {
            final SQLXML redirect(Accessor var1, int var2) throws SQLException {
                SQLException var3 = DatabaseError.createSqlException((OracleConnection)null, 4);
                var3.fillInStackTrace();
                throw var3;
            }
        });
        CLASS_TO_ERROR.put(String.class, new Redirector<String>(String.class) {
            final String redirect(Accessor var1, int var2) throws SQLException {
                SQLException var3 = DatabaseError.createSqlException((OracleConnection)null, 4);
                var3.fillInStackTrace();
                throw var3;
            }
        });
        CLASS_TO_ERROR.put(Struct.class, new Redirector<Struct>(Struct.class) {
            final Struct redirect(Accessor var1, int var2) throws SQLException {
                SQLException var3 = DatabaseError.createSqlException((OracleConnection)null, 4);
                var3.fillInStackTrace();
                throw var3;
            }
        });
        CLASS_TO_ERROR.put(Time.class, new Redirector<Time>(Time.class) {
            final Time redirect(Accessor var1, int var2) throws SQLException {
                SQLException var3 = DatabaseError.createSqlException((OracleConnection)null, 4);
                var3.fillInStackTrace();
                throw var3;
            }
        });
        CLASS_TO_ERROR.put(Timestamp.class, new Redirector<Timestamp>(Timestamp.class) {
            final Timestamp redirect(Accessor var1, int var2) throws SQLException {
                SQLException var3 = DatabaseError.createSqlException((OracleConnection)null, 4);
                var3.fillInStackTrace();
                throw var3;
            }
        });
        CLASS_TO_ERROR.put(URL.class, new Redirector<URL>(URL.class) {
            final URL redirect(Accessor var1, int var2) throws SQLException {
                SQLException var3 = DatabaseError.createSqlException((OracleConnection)null, 4);
                var3.fillInStackTrace();
                throw var3;
            }
        });
        CLASS_TO_ERROR.put(BigInteger.class, new Redirector<BigInteger>(BigInteger.class) {
            final BigInteger redirect(Accessor var1, int var2) throws SQLException {
                SQLException var3 = DatabaseError.createSqlException((OracleConnection)null, 4);
                var3.fillInStackTrace();
                throw var3;
            }
        });
        CLASS_TO_ERROR.put(java.util.Date.class, new Redirector<java.util.Date>(java.util.Date.class) {
            final java.util.Date redirect(Accessor var1, int var2) throws SQLException {
                SQLException var3 = DatabaseError.createSqlException((OracleConnection)null, 4);
                var3.fillInStackTrace();
                throw var3;
            }
        });
        CLASS_TO_ERROR.put(Calendar.class, new Redirector<Calendar>(Calendar.class) {
            final Calendar redirect(Accessor var1, int var2) throws SQLException {
                SQLException var3 = DatabaseError.createSqlException((OracleConnection)null, 4);
                var3.fillInStackTrace();
                throw var3;
            }
        });
        CLASS_TO_ERROR.put(ARRAY.class, new Redirector<ARRAY>(ARRAY.class) {
            final ARRAY redirect(Accessor var1, int var2) throws SQLException {
                SQLException var3 = DatabaseError.createSqlException((OracleConnection)null, 4);
                var3.fillInStackTrace();
                throw var3;
            }
        });
        CLASS_TO_ERROR.put(BFILE.class, new Redirector<BFILE>(BFILE.class) {
            final BFILE redirect(Accessor var1, int var2) throws SQLException {
                SQLException var3 = DatabaseError.createSqlException((OracleConnection)null, 4);
                var3.fillInStackTrace();
                throw var3;
            }
        });
        CLASS_TO_ERROR.put(BINARY_FLOAT.class, new Redirector<BINARY_FLOAT>(BINARY_FLOAT.class) {
            final BINARY_FLOAT redirect(Accessor var1, int var2) throws SQLException {
                SQLException var3 = DatabaseError.createSqlException((OracleConnection)null, 4);
                var3.fillInStackTrace();
                throw var3;
            }
        });
        CLASS_TO_ERROR.put(BINARY_DOUBLE.class, new Redirector<BINARY_DOUBLE>(BINARY_DOUBLE.class) {
            final BINARY_DOUBLE redirect(Accessor var1, int var2) throws SQLException {
                SQLException var3 = DatabaseError.createSqlException((OracleConnection)null, 4);
                var3.fillInStackTrace();
                throw var3;
            }
        });
        CLASS_TO_ERROR.put(BLOB.class, new Redirector<BLOB>(BLOB.class) {
            final BLOB redirect(Accessor var1, int var2) throws SQLException {
                SQLException var3 = DatabaseError.createSqlException((OracleConnection)null, 4);
                var3.fillInStackTrace();
                throw var3;
            }
        });
        CLASS_TO_ERROR.put(CHAR.class, new Redirector<CHAR>(CHAR.class) {
            final CHAR redirect(Accessor var1, int var2) throws SQLException {
                SQLException var3 = DatabaseError.createSqlException((OracleConnection)null, 4);
                var3.fillInStackTrace();
                throw var3;
            }
        });
        CLASS_TO_ERROR.put(CLOB.class, new Redirector<CLOB>(CLOB.class) {
            final CLOB redirect(Accessor var1, int var2) throws SQLException {
                SQLException var3 = DatabaseError.createSqlException((OracleConnection)null, 4);
                var3.fillInStackTrace();
                throw var3;
            }
        });
        CLASS_TO_ERROR.put(ResultSet.class, new Redirector<ResultSet>(ResultSet.class) {
            final ResultSet redirect(Accessor var1, int var2) throws SQLException {
                SQLException var3 = DatabaseError.createSqlException((OracleConnection)null, 4);
                var3.fillInStackTrace();
                throw var3;
            }
        });
        CLASS_TO_ERROR.put(DATE.class, new Redirector<DATE>(DATE.class) {
            final DATE redirect(Accessor var1, int var2) throws SQLException {
                SQLException var3 = DatabaseError.createSqlException((OracleConnection)null, 4);
                var3.fillInStackTrace();
                throw var3;
            }
        });
        CLASS_TO_ERROR.put(INTERVALDS.class, new Redirector<INTERVALDS>(INTERVALDS.class) {
            final INTERVALDS redirect(Accessor var1, int var2) throws SQLException {
                SQLException var3 = DatabaseError.createSqlException((OracleConnection)null, 4);
                var3.fillInStackTrace();
                throw var3;
            }
        });
        CLASS_TO_ERROR.put(INTERVALYM.class, new Redirector<INTERVALYM>(INTERVALYM.class) {
            final INTERVALYM redirect(Accessor var1, int var2) throws SQLException {
                SQLException var3 = DatabaseError.createSqlException((OracleConnection)null, 4);
                var3.fillInStackTrace();
                throw var3;
            }
        });
        CLASS_TO_ERROR.put(NUMBER.class, new Redirector<NUMBER>(NUMBER.class) {
            final NUMBER redirect(Accessor var1, int var2) throws SQLException {
                SQLException var3 = DatabaseError.createSqlException((OracleConnection)null, 4);
                var3.fillInStackTrace();
                throw var3;
            }
        });
        CLASS_TO_ERROR.put(OPAQUE.class, new Redirector<OPAQUE>(OPAQUE.class) {
            final OPAQUE redirect(Accessor var1, int var2) throws SQLException {
                SQLException var3 = DatabaseError.createSqlException((OracleConnection)null, 4);
                var3.fillInStackTrace();
                throw var3;
            }
        });
        CLASS_TO_ERROR.put(ORAData.class, new Redirector<ORAData>(ORAData.class) {
            final ORAData redirect(Accessor var1, int var2) throws SQLException {
                SQLException var3 = DatabaseError.createSqlException((OracleConnection)null, 4);
                var3.fillInStackTrace();
                throw var3;
            }
        });
        CLASS_TO_ERROR.put(OracleData.class, new Redirector<OracleData>(OracleData.class) {
            final OracleData redirect(Accessor var1, int var2) throws SQLException {
                SQLException var3 = DatabaseError.createSqlException((OracleConnection)null, 4);
                var3.fillInStackTrace();
                throw var3;
            }
        });
        CLASS_TO_ERROR.put(RAW.class, new Redirector<RAW>(RAW.class) {
            final RAW redirect(Accessor var1, int var2) throws SQLException {
                SQLException var3 = DatabaseError.createSqlException((OracleConnection)null, 4);
                var3.fillInStackTrace();
                throw var3;
            }
        });
        CLASS_TO_ERROR.put(REF.class, new Redirector<REF>(REF.class) {
            final REF redirect(Accessor var1, int var2) throws SQLException {
                SQLException var3 = DatabaseError.createSqlException((OracleConnection)null, 4);
                var3.fillInStackTrace();
                throw var3;
            }
        });
        CLASS_TO_ERROR.put(ROWID.class, new Redirector<ROWID>(ROWID.class) {
            final ROWID redirect(Accessor var1, int var2) throws SQLException {
                SQLException var3 = DatabaseError.createSqlException((OracleConnection)null, 4);
                var3.fillInStackTrace();
                throw var3;
            }
        });
        CLASS_TO_ERROR.put(STRUCT.class, new Redirector<STRUCT>(STRUCT.class) {
            final STRUCT redirect(Accessor var1, int var2) throws SQLException {
                SQLException var3 = DatabaseError.createSqlException((OracleConnection)null, 4);
                var3.fillInStackTrace();
                throw var3;
            }
        });
        CLASS_TO_ERROR.put(TIMESTAMPLTZ.class, new Redirector<TIMESTAMPLTZ>(TIMESTAMPLTZ.class) {
            final TIMESTAMPLTZ redirect(Accessor var1, int var2) throws SQLException {
                SQLException var3 = DatabaseError.createSqlException((OracleConnection)null, 4);
                var3.fillInStackTrace();
                throw var3;
            }
        });
        CLASS_TO_ERROR.put(TIMESTAMPTZ.class, new Redirector<TIMESTAMPTZ>(TIMESTAMPTZ.class) {
            final TIMESTAMPTZ redirect(Accessor var1, int var2) throws SQLException {
                SQLException var3 = DatabaseError.createSqlException((OracleConnection)null, 4);
                var3.fillInStackTrace();
                throw var3;
            }
        });
        CLASS_TO_ERROR.put(TIMESTAMP.class, new Redirector<TIMESTAMP>(TIMESTAMP.class) {
            final TIMESTAMP redirect(Accessor var1, int var2) throws SQLException {
                SQLException var3 = DatabaseError.createSqlException((OracleConnection)null, 4);
                var3.fillInStackTrace();
                throw var3;
            }
        });
        CLASS_TO_ERROR.put(OracleArray.class, new Redirector<OracleArray>(OracleArray.class) {
            final OracleArray redirect(Accessor var1, int var2) throws SQLException {
                SQLException var3 = DatabaseError.createSqlException((OracleConnection)null, 4);
                var3.fillInStackTrace();
                throw var3;
            }
        });
        CLASS_TO_ERROR.put(OracleBlob.class, new Redirector<OracleBlob>(OracleBlob.class) {
            final OracleBlob redirect(Accessor var1, int var2) throws SQLException {
                SQLException var3 = DatabaseError.createSqlException((OracleConnection)null, 4);
                var3.fillInStackTrace();
                throw var3;
            }
        });
        CLASS_TO_ERROR.put(OracleClob.class, new Redirector<OracleClob>(OracleClob.class) {
            final OracleClob redirect(Accessor var1, int var2) throws SQLException {
                SQLException var3 = DatabaseError.createSqlException((OracleConnection)null, 4);
                var3.fillInStackTrace();
                throw var3;
            }
        });
        CLASS_TO_ERROR.put(OracleBfile.class, new Redirector<OracleBfile>(OracleBfile.class) {
            final OracleBfile redirect(Accessor var1, int var2) throws SQLException {
                SQLException var3 = DatabaseError.createSqlException((OracleConnection)null, 4);
                var3.fillInStackTrace();
                throw var3;
            }
        });
        CLASS_TO_ERROR.put(OracleRef.class, new Redirector<OracleRef>(OracleRef.class) {
            final OracleRef redirect(Accessor var1, int var2) throws SQLException {
                SQLException var3 = DatabaseError.createSqlException((OracleConnection)null, 4);
                var3.fillInStackTrace();
                throw var3;
            }
        });
        CLASS_TO_ERROR.put(OracleOpaque.class, new Redirector<OracleOpaque>(OracleOpaque.class) {
            final OracleOpaque redirect(Accessor var1, int var2) throws SQLException {
                SQLException var3 = DatabaseError.createSqlException((OracleConnection)null, 4);
                var3.fillInStackTrace();
                throw var3;
            }
        });
        CLASS_TO_ERROR.put(InputStream.class, new Redirector<InputStream>(InputStream.class) {
            final InputStream redirect(Accessor var1, int var2) throws SQLException {
                SQLException var3 = DatabaseError.createSqlException((OracleConnection)null, 4);
                var3.fillInStackTrace();
                throw var3;
            }
        });
        CLASS_TO_ERROR.put(Reader.class, new Redirector<Reader>(Reader.class) {
            final Reader redirect(Accessor var1, int var2) throws SQLException {
                SQLException var3 = DatabaseError.createSqlException((OracleConnection)null, 4);
                var3.fillInStackTrace();
                throw var3;
            }
        });
        _Copyright_2007_Oracle_All_Rights_Reserved_ = null;
    }
}
