//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package oracle.jdbc;

import java.sql.SQLException;
import java.sql.Statement;
import oracle.jdbc.dcn.DatabaseChangeRegistration;

public interface OracleStatement extends Statement {
    int NEW = 0;
    int IMPLICIT = 1;
    int EXPLICIT = 2;

    void clearDefines() throws SQLException;

    void defineColumnType(int var1, int var2) throws SQLException;

    void defineColumnType(int var1, int var2, int var3) throws SQLException;

    /** @deprecated */
    void defineColumnType(int var1, int var2, int var3, short var4) throws SQLException;

    /** @deprecated */
    void defineColumnTypeBytes(int var1, int var2, int var3) throws SQLException;

    /** @deprecated */
    void defineColumnTypeChars(int var1, int var2, int var3) throws SQLException;

    void defineColumnType(int var1, int var2, String var3) throws SQLException;

    int getRowPrefetch();

    void setRowPrefetch(int var1) throws SQLException;

    int getLobPrefetchSize() throws SQLException;

    void setLobPrefetchSize(int var1) throws SQLException;

    void closeWithKey(String var1) throws SQLException;

    /** @deprecated */
    int creationState();

    boolean isNCHAR(int var1) throws SQLException;

    void setDatabaseChangeRegistration(DatabaseChangeRegistration var1) throws SQLException;

    String[] getRegisteredTableNames() throws SQLException;

    long getRegisteredQueryId() throws SQLException;
}
