//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package oracle.jdbc.driver;

import java.sql.SQLException;
import oracle.jdbc.internal.OracleConnection;

class OracleSavepoint implements oracle.jdbc.internal.OracleSavepoint {
    private static final int MAX_ID_VALUE = 65535;
    private static final int INVALID_ID_VALUE = -1;
    static final int NAMED_SAVEPOINT_TYPE = 2;
    static final int UNNAMED_SAVEPOINT_TYPE = 1;
    static final int UNKNOWN_SAVEPOINT_TYPE = 0;
    private static int s_seedId = 0;
    private int m_id = -1;
    private String m_name = null;
    private int m_type = 0;
    Object acProxy;
    private static final String _Copyright_2007_Oracle_All_Rights_Reserved_ = null;
    public static final String BUILD_DATE = "Thu_Apr_04_15:09:24_PDT_2013";
    public static final boolean TRACE = false;

    OracleSavepoint() {
        this.m_type = 1;
        this.m_id = this.getNextId();
        this.m_name = null;
    }

    OracleSavepoint(String var1) throws SQLException {
        if (var1 != null && var1.length() != 0 && !OracleSql.isValidObjectName(var1)) {
            SQLException var2 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 68);
            var2.fillInStackTrace();
            throw var2;
        } else {
            if (var1 != null && var1.trim().compareTo("") != 0) {
                this.m_type = 2;
                this.m_name = var1;
                this.m_id = -1;
            } else {
                this.m_type = 1;
                this.m_id = this.getNextId();
                this.m_name = null;
            }

        }
    }

    public int getSavepointId() throws SQLException {
        if (this.m_type == 2) {
            SQLException var1 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 118);
            var1.fillInStackTrace();
            throw var1;
        } else {
            return this.m_id;
        }
    }

    public String getSavepointName() throws SQLException {
        if (this.m_type == 1) {
            SQLException var1 = DatabaseError.createSqlException(this.getConnectionDuringExceptionHandling(), 119);
            var1.fillInStackTrace();
            throw var1;
        } else {
            return this.m_name;
        }
    }

    int getType() {
        return this.m_type;
    }

    private synchronized int getNextId() {
        s_seedId = (s_seedId + 1) % '\uffff';
        return s_seedId;
    }

    protected OracleConnection getConnectionDuringExceptionHandling() {
        return null;
    }

    public void setACProxy(Object var1) {
        this.acProxy = var1;
    }

    public Object getACProxy() {
        return this.acProxy;
    }
}
