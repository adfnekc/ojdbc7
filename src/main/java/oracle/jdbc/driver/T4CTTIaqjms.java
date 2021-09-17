//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package oracle.jdbc.driver;

import java.io.IOException;
import java.sql.SQLException;

class T4CTTIaqjms {
    int aqjmshdrpcnt;
    byte[] aqjmshdrprop;
    int aqjmsusrprpcnt;
    byte[] aqjmsuserprop;
    int aqjmsflags = 1;
    T4CMAREngine mar;

    T4CTTIaqjms(T4CConnection var1) {
        this.mar = var1.mare;
    }

    void marshal() throws IOException {
        this.mar.marshalUB4((long)this.aqjmshdrpcnt);
        if (this.aqjmshdrprop != null && this.aqjmshdrprop.length != 0) {
            this.mar.marshalSWORD(this.aqjmshdrprop.length);
            this.mar.marshalCLR(this.aqjmshdrprop, 0, this.aqjmshdrprop.length);
        } else {
            this.mar.marshalSWORD(0);
        }

        this.mar.marshalUB4((long)this.aqjmsusrprpcnt);
        if (this.aqjmsuserprop != null && this.aqjmsuserprop.length != 0) {
            this.mar.marshalSWORD(this.aqjmsuserprop.length);
            this.mar.marshalCLR(this.aqjmsuserprop, 0, this.aqjmsuserprop.length);
        } else {
            this.mar.marshalSWORD(0);
        }

        this.mar.marshalUB4((long)this.aqjmsflags);
    }

    void receive() throws SQLException, IOException {
        this.aqjmshdrpcnt = (int)this.mar.unmarshalUB4();
        int var1 = this.mar.unmarshalSWORD();
        if (var1 > 0) {
            this.aqjmshdrprop = new byte[var1];
            int[] var2 = new int[1];
            this.mar.unmarshalCLR(this.aqjmshdrprop, 0, var2, var1);
        } else {
            this.aqjmshdrprop = null;
        }

        this.aqjmsusrprpcnt = (int)this.mar.unmarshalUB4();
        int var4 = this.mar.unmarshalSWORD();
        if (var4 > 0) {
            this.aqjmsuserprop = new byte[var4];
            int[] var3 = new int[1];
            this.mar.unmarshalCLR(this.aqjmsuserprop, 0, var3, var4);
        } else {
            this.aqjmsuserprop = null;
        }

        this.aqjmsflags = (int)this.mar.unmarshalUB4();
    }
}
