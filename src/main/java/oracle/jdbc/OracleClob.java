//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package oracle.jdbc;

import java.sql.Clob;
import java.sql.SQLException;

public interface OracleClob extends Clob {
    void open(LargeObjectAccessMode var1) throws SQLException;

    void close() throws SQLException;

    boolean isOpen() throws SQLException;

    boolean isTemporary() throws SQLException;

    boolean isEmptyLob() throws SQLException;

    boolean isSecureFile() throws SQLException;
}
