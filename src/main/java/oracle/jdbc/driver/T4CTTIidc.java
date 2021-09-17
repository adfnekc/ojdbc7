//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package oracle.jdbc.driver;

import java.io.IOException;
import java.sql.SQLException;

class T4CTTIidc extends T4CTTIMsg {
    T4CTTIkscn kpdqidcscn;
    T4CTTIqcinv[] kpdqidccinv;
    T4CTTIqcinv[] kpdqidcusr;
    long kpdqidcflg;

    T4CTTIidc(T4CConnection var1) {
        super(var1, (byte)0);
    }

    void unmarshal() throws SQLException, IOException {
        this.kpdqidcscn = new T4CTTIkscn(this.connection);
        this.kpdqidcscn.unmarshal();
        int var1 = this.meg.unmarshalSWORD();
        byte var2 = (byte)this.meg.unmarshalUB1();
        int var3;
        if (var1 > 0) {
            this.kpdqidccinv = new T4CTTIqcinv[var1];

            for(var3 = 0; var3 < var1; ++var3) {
                this.kpdqidccinv[var3] = new T4CTTIqcinv(this.connection);
                this.kpdqidccinv[var3].unmarshal();
            }
        } else {
            this.kpdqidccinv = null;
        }

        var3 = this.meg.unmarshalSWORD();
        if (var3 > 0) {
            this.kpdqidcusr = new T4CTTIqcinv[var3];

            for(int var4 = 0; var4 < var3; ++var4) {
                this.kpdqidcusr[var4] = new T4CTTIqcinv(this.connection);
                this.kpdqidcusr[var4].unmarshal();
            }
        } else {
            this.kpdqidcusr = null;
        }

        this.kpdqidcflg = this.meg.unmarshalUB4();
    }
}
