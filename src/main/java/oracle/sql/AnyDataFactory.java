//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package oracle.sql;

import java.sql.SQLException;
import oracle.jdbc.OracleData;
import oracle.jdbc.OracleDataFactory;
import oracle.jdbc.driver.DatabaseError;
import oracle.jdbc.internal.OracleConnection;

class AnyDataFactory implements ORADataFactory, OracleDataFactory {
    private static final String _Copyright_2007_Oracle_All_Rights_Reserved_ = null;
    public static final String BUILD_DATE = "Thu_Apr_04_15:09:24_PDT_2013";
    public static final boolean TRACE = false;

    AnyDataFactory() {
    }

    public ORAData create(Datum var1, int var2) throws SQLException {
        if (var1 == null) {
            return null;
        } else if (var1 instanceof OPAQUE) {
            return new ANYDATA((OPAQUE)var1);
        } else {
            String var3 = "expected oracle.sql.OPAQUE got: " + var1.getClass().getName();
            SQLException var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 1, var3);
            var4.fillInStackTrace();
            throw var4;
        }
    }

    public OracleData create(Object var1, int var2) throws SQLException {
        if (var1 == null) {
            return null;
        } else if (var1 instanceof OPAQUE) {
            return new ANYDATA((OPAQUE)var1);
        } else {
            String var3 = "expected oracle.sql.OPAQUE got: " + var1.getClass().getName();
            SQLException var4 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 1, var3);
            var4.fillInStackTrace();
            throw var4;
        }
    }

    protected OracleConnection getConnectionDuringExceptionHandling() {
        return null;
    }
}
