//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package oracle.jdbc.driver;

import java.io.IOException;
import java.sql.SQLException;

class T4CTTIkscn extends T4CTTIMsg {
    long kscnbas;
    int kscnwrp;

    T4CTTIkscn(T4CConnection var1) {
        super(var1, (byte)0);
    }

    void unmarshal() throws SQLException, IOException {
        this.kscnbas = this.meg.unmarshalUB4();
        this.kscnwrp = this.meg.unmarshalUB2();
    }
}
