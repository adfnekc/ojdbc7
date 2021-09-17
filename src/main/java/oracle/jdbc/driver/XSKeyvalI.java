//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package oracle.jdbc.driver;

import java.io.IOException;
import java.sql.SQLException;
import oracle.jdbc.internal.KeywordValueLong;
import oracle.jdbc.internal.XSKeyval;

class XSKeyvalI extends XSKeyval {
    KeywordValueLongI[] kpxskvlvl = null;
    long kpxskvlflg = 0L;

    XSKeyvalI() {
    }

    private void setKeyval(KeywordValueLongI[] var1) throws SQLException {
        this.kpxskvlvl = var1;
    }

    public void setKeyval(KeywordValueLong[] var1) throws SQLException {
        if (var1 != null) {
            this.kpxskvlvl = new KeywordValueLongI[var1.length];

            for(int var2 = 0; var2 < var1.length; ++var2) {
                this.kpxskvlvl[var2] = (KeywordValueLongI)var1[var2];
            }
        }

    }

    public void setFlag(long var1) throws SQLException {
        this.kpxskvlflg = var1;
    }

    public KeywordValueLong[] getKeyval() {
        return this.kpxskvlvl;
    }

    public long getFlag() {
        return this.kpxskvlflg;
    }

    void marshal(T4CMAREngine var1) throws IOException {
        if (this.kpxskvlvl != null) {
            var1.marshalUB4((long)this.kpxskvlvl.length);

            for(int var2 = 0; var2 < this.kpxskvlvl.length; ++var2) {
                this.kpxskvlvl[var2].marshal(var1);
            }
        } else {
            var1.marshalUB4(0L);
        }

        var1.marshalUB4(this.kpxskvlflg);
    }

    static XSKeyvalI unmarshal(T4CMAREngine var0) throws SQLException, IOException {
        int var1 = (int)var0.unmarshalUB4();
        if (var1 > 0) {
            var0.unmarshalUB1();
        }

        KeywordValueLongI[] var2 = new KeywordValueLongI[var1];

        int var3;
        for(var3 = 0; var3 < var1; ++var3) {
            var2[var3] = KeywordValueLongI.unmarshal(var0);
        }

        var3 = (int)var0.unmarshalUB4();
        XSKeyvalI var4 = new XSKeyvalI();
        var4.setKeyval(var2);
        var4.setFlag((long)var3);
        return var4;
    }
}
