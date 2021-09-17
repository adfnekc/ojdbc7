//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package oracle.jdbc.driver;

import java.io.IOException;
import java.sql.SQLException;

class T4CTTIqcinv extends T4CTTIMsg {
    long kpdqcqid;
    long kpdqcopflg;
    T4CTTIkscn kpdqcscn = null;

    T4CTTIqcinv(T4CConnection var1) {
        super(var1, (byte)0);
    }

    void unmarshal() throws SQLException, IOException {
        this.kpdqcqid = this.meg.unmarshalSB8();
        this.kpdqcopflg = this.meg.unmarshalUB4();
        this.kpdqcscn = new T4CTTIkscn(this.connection);
        this.kpdqcscn.unmarshal();
    }
}
