//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package oracle.jdbc.driver;

import java.io.IOException;
import java.sql.SQLException;
import oracle.jdbc.internal.KeywordValue;

class T4CTTIkvarr extends T4CTTIMsg {
    KeywordValue[] kpdkvarrptr = null;
    long kpdkvarrflg;

    T4CTTIkvarr(T4CConnection var1) {
        super(var1, (byte)0);
    }

    void unmarshal() throws SQLException, IOException {
        int var1 = (int)this.meg.unmarshalUB4();
        byte var2 = (byte)this.meg.unmarshalUB1();
        if (var1 > 0) {
            this.kpdkvarrptr = new KeywordValueI[var1];

            for(int var3 = 0; var3 < var1; ++var3) {
                this.kpdkvarrptr[var3] = KeywordValueI.unmarshal(this.meg);
            }

            this.connection.updateSessionProperties(this.kpdkvarrptr);
        } else {
            this.kpdkvarrptr = null;
        }

        this.kpdkvarrflg = this.meg.unmarshalUB4();
    }
}
