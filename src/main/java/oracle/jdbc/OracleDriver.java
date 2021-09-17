//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package oracle.jdbc;

import java.io.ByteArrayOutputStream;

public class OracleDriver extends oracle.jdbc.driver.OracleDriver {
    private static final String _Copyright_2007_Oracle_All_Rights_Reserved_ = null;
    public static final String BUILD_DATE = "Thu_Apr_04_15:09:24_PDT_2013";
    public static final boolean TRACE = false;

    public OracleDriver() {
    }

    public static final boolean isDMS() {
        return false;
    }

    public static final boolean isInServer() {
        return false;
    }

    /** @deprecated */
    public static final boolean isJDK14() {
        return true;
    }

    public static final boolean isDebug() {
        return false;
    }

    public static final boolean isPrivateDebug() {
        return false;
    }

    public static final String getJDBCVersion() {
        return "JDBC 4.1";
    }

    public static final String getDriverVersion() {
        return "12.1.0.1.0";
    }

    public static final String getBuildDate() {
        return "Thu_Apr_04_15:09:24_PDT_2013";
    }

    public static void main(String[] var0) throws Exception {
        String var1 = "JDK7";
        System.out.println("Oracle " + getDriverVersion() + " " + getJDBCVersion() + (isDMS() ? " DMS" : "") + (isPrivateDebug() ? " private" : "") + (isDebug() ? " debug" : "") + (isInServer() ? " for JAVAVM" : "") + " compiled with " + var1 + " on " + getBuildDate());
        ByteArrayOutputStream var2 = new ByteArrayOutputStream(128);
        DEFAULT_CONNECTION_PROPERTIES.store(var2, "Default Connection Properties Resource");
        System.out.println(var2.toString("ISO-8859-1"));
    }
}
