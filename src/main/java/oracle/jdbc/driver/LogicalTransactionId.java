//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package oracle.jdbc.driver;

import java.sql.SQLException;

class LogicalTransactionId implements oracle.jdbc.LogicalTransactionId {
    byte[] ltxid;

    LogicalTransactionId(byte[] var1) {
        this.ltxid = var1;
    }

    public byte[] getBytes() throws SQLException {
        return this.ltxid;
    }
}
