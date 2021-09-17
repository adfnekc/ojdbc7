//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package oracle.jdbc.aq;

import java.sql.SQLException;

public interface AQAgent {
    void setAddress(String var1) throws SQLException;

    String getAddress();

    void setName(String var1) throws SQLException;

    String getName();

    void setProtocol(int var1) throws SQLException;

    int getProtocol();

    String toString();
}
