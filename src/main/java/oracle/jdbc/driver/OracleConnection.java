//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package oracle.jdbc.driver;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import oracle.jdbc.OracleConnectionWrapper;
import oracle.jdbc.internal.ClientDataSupport;

public abstract class OracleConnection extends OracleConnectionWrapper implements oracle.jdbc.internal.OracleConnection, ClientDataSupport {
    static int DEFAULT_ROW_PREFETCH = 10;
    static final String svptPrefix = "ORACLE_SVPT_";
    static final int BINARYSTREAM = 0;
    static final int ASCIISTREAM = 1;
    static final int UNICODESTREAM = 2;
    static final int EOJ_NON = 0;
    static final int EOJ_B_TO_A = 1;
    static final int EOJ_B_TO_U = 2;
    static final int EOJ_A_TO_U = 3;
    static final int EOJ_8_TO_A = 4;
    static final int EOJ_8_TO_U = 5;
    static final int EOJ_U_TO_A = 6;
    static final int ASCII_CHARSET = 0;
    static final int NLS_CHARSET = 1;
    static final int CHAR_TO_ASCII = 0;
    static final int CHAR_TO_UNICODE = 1;
    static final int RAW_TO_ASCII = 2;
    static final int RAW_TO_UNICODE = 3;
    static final int UNICODE_TO_CHAR = 4;
    static final int ASCII_TO_CHAR = 5;
    static final int NONE = 6;
    static final int JAVACHAR_TO_CHAR = 7;
    static final int RAW_TO_JAVACHAR = 8;
    static final int CHAR_TO_JAVACHAR = 9;
    static final int JAVACHAR_TO_ASCII = 10;
    static final int JAVACHAR_TO_UNICODE = 11;
    static final int UNICODE_TO_ASCII = 12;
    public static final int KOLBLLENB = 0;
    public static final int KOLBLVSNB = 2;
    public static final byte KOLL1FLG = 4;
    public static final byte KOLL2FLG = 5;
    public static final byte KOLL3FLG = 6;
    public static final byte KOLL4FLG = 7;
    public static final int KOLBLCIDB = 32;
    static final byte ALLFLAGS = -1;
    public static final int KOLBLIMRLL = 86;
    public static final byte KOLBLBLOB = 1;
    public static final byte KOLBLCLOB = 2;
    public static final byte KOLBLNLOB = 4;
    public static final byte KOLBLBFIL = 8;
    public static final byte KOLBLCFIL = 16;
    public static final byte KOLBLNFIL = 32;
    public static final byte KOLBLABS = 64;
    public static final byte KOLBLPXY = -128;
    public static final byte KOLBLPKEY = 1;
    public static final byte KOLBLIMP = 2;
    public static final byte KOLBLIDX = 4;
    public static final byte KOLBLINI = 8;
    public static final byte KOLBLEMP = 16;
    public static final byte KOLBLVIEW = 32;
    public static final byte KOLBL0FRM = 64;
    public static final byte KOLBL1FRM = -128;
    public static final byte KOLBLRDO = 1;
    public static final byte KOLBLPART = 2;
    public static final byte KOLBLCPD = 4;
    public static final byte KOLBLDIL = 8;
    public static final byte KOLBLBUF = 16;
    public static final byte KOLBLBPS = 32;
    public static final byte KOLBLMOD = 64;
    public static final byte KOLBLVAR = -128;
    public static final byte KOLBLTMP = 1;
    public static final byte KOLBLCACHE = 2;
    public static final byte KOLBLOPEN = 8;
    public static final byte KOLBLRDWR = 16;
    public static final byte KOLBLCLI = 32;
    public static final byte KOLBLVLE = 64;
    public static final byte KOLBLLCL = -128;
    static final int KOLBLLIDB = 10;
    static final int KOLBLPREL = 2;
    static final int KOLBLLIDL = 10;
    static final int KOLBLTLMXL = 40;
    static final List<String> RESERVED_NAMESPACES = Arrays.asList("SYS");
    static final Pattern SUPPORTED_NAMESPACE_PATTERN = Pattern.compile("CLIENTCONTEXT");
    protected Object acProxy;
    private static final String _Copyright_2007_Oracle_All_Rights_Reserved_ = null;
    public static final String BUILD_DATE = "Thu_Apr_04_15:09:24_PDT_2013";
    public static final boolean TRACE = false;

    public OracleConnection() {
    }

    static boolean containsKey(Map var0, Object var1) {
        return var0.get(var1) != null;
    }

    public abstract Object getClientData(Object var1);

    public abstract Object setClientData(Object var1, Object var2);

    public abstract Object removeClientData(Object var1);

    /** @deprecated */
    public abstract void setClientIdentifier(String var1) throws SQLException;

    /** @deprecated */
    public abstract void clearClientIdentifier(String var1) throws SQLException;

    public boolean isValid(int var1) throws SQLException {
        return this.pingDatabase(var1) == 0;
    }

    public boolean isWrapperFor(Class<?> var1) throws SQLException {
        if (var1.isInterface()) {
            return var1.isInstance(this);
        } else {
            SQLException var2 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 177);
            var2.fillInStackTrace();
            throw var2;
        }
    }

    public <T> T unwrap(Class<T> var1) throws SQLException {
        if (var1.isInterface() && var1.isInstance(this)) {
            return (T) this;
        } else {
            SQLException var2 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 177);
            var2.fillInStackTrace();
            throw var2;
        }
    }

    protected oracle.jdbc.internal.OracleConnection getConnectionDuringExceptionHandling() {
        return this;
    }

    public Class getClassForType(String var1, Map<String, Class> var2) {
        Class var3 = (Class)var2.get(var1);
        if (var3 == null) {
            Class var4 = (Class)OracleDriver.systemTypeMap.get(var1);
            if (var4 != null) {
                var3 = var4;
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
}
