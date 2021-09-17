//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package oracle.sql;

import java.sql.Connection;
import java.sql.SQLException;
import oracle.jdbc.driver.DatabaseError;
import oracle.jdbc.driver.OracleDriver;
import oracle.jdbc.internal.OracleConnection;
import oracle.jdbc.internal.OracleDatumWithConnection;

public abstract class DatumWithConnection extends Datum implements OracleDatumWithConnection {
    private OracleConnection physicalConnection = null;
    private static final String _Copyright_2007_Oracle_All_Rights_Reserved_ = null;
    public static final String BUILD_DATE = "Thu_Apr_04_15:09:24_PDT_2013";
    public static final boolean TRACE = false;

    OracleConnection getPhysicalConnection() {
        if (this.physicalConnection == null) {
            try {
                this.physicalConnection = (OracleConnection)(new OracleDriver()).defaultConnection();
            } catch (SQLException var2) {
            }
        }

        return this.physicalConnection;
    }

    public DatumWithConnection(byte[] var1) throws SQLException {
        super(var1);
    }

    public DatumWithConnection() {
    }

    public static void assertNotNull(Connection var0) throws SQLException {
        if (var0 == null) {
            SQLException var1 = DatabaseError.createSqlException((OracleConnection)null, 68, "Connection is null");
            var1.fillInStackTrace();
            throw var1;
        }
    }

    public static void assertNotNull(TypeDescriptor var0) throws SQLException {
        if (var0 == null) {
            SQLException var1 = DatabaseError.createSqlException((OracleConnection)null, 61);
            var1.fillInStackTrace();
            throw var1;
        }
    }

    public void setPhysicalConnectionOf(Connection var1) {
        this.physicalConnection = ((oracle.jdbc.OracleConnection)var1).physicalConnectionWithin();
    }

    public Connection getJavaSqlConnection() throws SQLException {
        return this.getPhysicalConnection().getWrapper();
    }

    public oracle.jdbc.OracleConnection getOracleConnection() throws SQLException {
        return this.getPhysicalConnection().getWrapper();
    }

    public OracleConnection getInternalConnection() throws SQLException {
        return this.getPhysicalConnection();
    }

    /** @deprecated */
    public oracle.jdbc.driver.OracleConnection getConnection() throws SQLException {
        oracle.jdbc.driver.OracleConnection var1 = null;

        try {
            var1 = (oracle.jdbc.driver.OracleConnection)((oracle.jdbc.driver.OracleConnection)this.physicalConnection).getWrapper();
            return var1;
        } catch (ClassCastException var4) {
            SQLException var3 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 103);
            var3.fillInStackTrace();
            throw var3;
        }
    }

    protected OracleConnection getConnectionDuringExceptionHandling() {
        return this.physicalConnection;
    }
}
