//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package oracle.jdbc.internal;

import java.io.InputStream;
import java.io.Reader;
import java.math.BigDecimal;
import java.sql.SQLException;

public interface OracleCallableStatement extends oracle.jdbc.OracleCallableStatement, OraclePreparedStatement, ACProxyable {
    byte[] privateGetBytes(int var1) throws SQLException;

    /** @deprecated */
    BigDecimal getBigDecimal(String var1, int var2) throws SQLException;

    /** @deprecated */
    InputStream getAsciiStream(String var1) throws SQLException;

    /** @deprecated */
    Reader getCharacterStream(String var1) throws SQLException;
}
