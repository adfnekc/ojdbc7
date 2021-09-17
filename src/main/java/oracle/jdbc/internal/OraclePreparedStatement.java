//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package oracle.jdbc.internal;

import java.io.Reader;
import java.sql.SQLException;

public interface OraclePreparedStatement extends oracle.jdbc.OraclePreparedStatement, OracleStatement, ACProxyable {
    void setCheckBindTypes(boolean var1);

    void setInternalBytes(int var1, byte[] var2, int var3) throws SQLException;

    void enterImplicitCache() throws SQLException;

    void enterExplicitCache() throws SQLException;

    void exitImplicitCacheToActive() throws SQLException;

    void exitExplicitCacheToActive() throws SQLException;

    void exitImplicitCacheToClose() throws SQLException;

    void exitExplicitCacheToClose() throws SQLException;

    /** @deprecated */
    void setCharacterStreamAtName(String var1, Reader var2, int var3) throws SQLException;

    String getOriginalSql() throws SQLException;
}
