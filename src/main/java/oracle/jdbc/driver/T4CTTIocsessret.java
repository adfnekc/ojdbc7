//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package oracle.jdbc.driver;

import java.io.IOException;
import java.sql.SQLException;
import oracle.jdbc.internal.KeywordValue;

class T4CTTIocsessret extends T4CTTIfun {
    int sessretokvn;
    KeywordValue[] sessretokv;
    long sessretflags;
    long sessretidx;
    int sessretser;
    private static final String _Copyright_2007_Oracle_All_Rights_Reserved_ = null;
    public static final String BUILD_DATE = "Thu_Apr_04_15:09:24_PDT_2013";
    public static final boolean TRACE = false;

    T4CTTIocsessret(T4CConnection var1) {
        super(var1, (byte)3);
        this.setFunCode((short)4);
    }

    void marshal() throws IOException {
    }

    void receive() throws SQLException, IOException {
        int var1 = this.meg.unmarshalUB2();
        short var3 = this.meg.unmarshalUB1();
        this.sessretokvn = this.meg.unmarshalUB2();
        if (this.sessretokvn > 0) {
            var3 = this.meg.unmarshalUB1();
            this.sessretokv = new KeywordValue[this.sessretokvn];

            for(int var2 = 0; var2 < this.sessretokvn; ++var2) {
                this.sessretokv[var2] = KeywordValueI.unmarshal(this.meg);
            }

            this.connection.updateSessionProperties(this.sessretokv);
        }

        this.sessretflags = this.meg.unmarshalUB4();
        this.sessretidx = this.meg.unmarshalUB4();
        this.sessretser = this.meg.unmarshalUB2();
    }
}
