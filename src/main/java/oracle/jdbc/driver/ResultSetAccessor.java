//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package oracle.jdbc.driver;

import java.sql.ResultSet;
import java.sql.SQLException;

class ResultSetAccessor extends Accessor {
    static final int MAXLENGTH = 16;
    OracleStatement currentStmt;
    private static final String _Copyright_2007_Oracle_All_Rights_Reserved_ = null;
    public static final String BUILD_DATE = "Thu_Apr_04_15:09:24_PDT_2013";
    public static final boolean TRACE = false;

    ResultSetAccessor(OracleStatement var1, int var2, short var3, int var4, boolean var5) throws SQLException {
        super(Representation.RESULT_SET, var1, 16, var5);
        this.init(var1, 102, 116, var3, var5);
        this.initForDataAccess(var4, var2, (String)null);
    }

    ResultSetAccessor(OracleStatement var1, int var2, boolean var3, int var4, int var5, int var6, int var7, int var8, short var9) throws SQLException {
        super(Representation.RESULT_SET, var1, 16, false);
        this.init(var1, 102, 116, var9, false);
        this.initForDescribe(102, var2, var3, var4, var5, var6, var7, var8, var9, (String)null);
        this.initForDataAccess(0, var2, (String)null);
    }

    ResultSet getCursor(int var1) throws SQLException {
        if (this.currentStmt != null && this.currentStmt.refCursorRowNumber == var1 && this.currentStmt.currentResultSet != null) {
            return this.currentStmt.currentResultSet;
        } else {
            byte[] var2 = this.getBytes(var1);
            OracleStatement var3 = this.statement.connection.RefCursorBytesToStatement(var2, this.statement);
            var3.refCursorRowNumber = var1;
            var3.doDescribe(false);
            if (var3.numberOfDefinePositions > 0) {
                var3.prepareAccessors();
            }

            var3.setPrefetchInternal(this.statement.getFetchSize(), false, false);
            var3.closeOnCompletion();
            OracleResultSet var4 = OracleResultSet.createResultSet(var3);
            var3.currentResultSet = var4;
            this.currentStmt = var3;
            return var4;
        }
    }

    Object getObject(int var1) throws SQLException {
        return this.getCursor(var1);
    }
}
