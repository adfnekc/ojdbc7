//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package oracle.jdbc.driver;

import java.io.IOException;
import java.sql.SQLException;
import oracle.jdbc.internal.XSAttribute;

class XSAttributeI extends XSAttribute {
    String attributeName = null;
    byte[] attributeNameBytes;
    String attributeValue = null;
    byte[] attributeValueBytes;
    String attributeDefaultValue = null;
    byte[] attributeDefaultValueBytes;
    long flag = 0L;

    XSAttributeI() {
    }

    public void setAttributeName(String var1) throws SQLException {
        this.attributeName = var1;
    }

    void doCharConversion(DBConversion var1) throws SQLException {
        if (this.attributeName != null) {
            this.attributeNameBytes = var1.StringToCharBytes(this.attributeName);
        } else {
            this.attributeNameBytes = null;
        }

        if (this.attributeValue != null) {
            this.attributeValueBytes = var1.StringToCharBytes(this.attributeValue);
        } else {
            this.attributeValueBytes = null;
        }

        if (this.attributeDefaultValue != null) {
            this.attributeDefaultValueBytes = var1.StringToCharBytes(this.attributeDefaultValue);
        } else {
            this.attributeDefaultValueBytes = null;
        }

    }

    public void setAttributeValue(String var1) throws SQLException {
        this.attributeValue = var1;
    }

    public void setAttributeDefaultValue(String var1) throws SQLException {
        this.attributeDefaultValue = var1;
    }

    public void setFlag(long var1) throws SQLException {
        this.flag = var1;
    }

    public String getAttributeName() {
        return this.attributeName;
    }

    public String getAttributeValue() {
        return this.attributeValue;
    }

    public String getAttributeDefaultValue() {
        return this.attributeDefaultValue;
    }

    public long getFlag() {
        return this.flag;
    }

    void marshal(T4CMAREngine var1) throws IOException {
        if (this.attributeNameBytes != null) {
            var1.marshalUB4((long)this.attributeNameBytes.length);
            var1.marshalCLR(this.attributeNameBytes, this.attributeNameBytes.length);
        } else {
            var1.marshalUB4(0L);
        }

        if (this.attributeValueBytes != null) {
            var1.marshalUB4((long)this.attributeValueBytes.length);
            var1.marshalCLR(this.attributeValueBytes, this.attributeValueBytes.length);
        } else {
            var1.marshalUB4(0L);
        }

        if (this.attributeDefaultValueBytes != null) {
            var1.marshalUB4((long)this.attributeDefaultValueBytes.length);
            var1.marshalCLR(this.attributeDefaultValueBytes, this.attributeDefaultValueBytes.length);
        } else {
            var1.marshalUB4(0L);
        }

        var1.marshalUB4(this.flag);
    }

    static XSAttributeI unmarshal(T4CMAREngine var0) throws SQLException, IOException {
        int[] var1 = new int[1];
        String var2 = null;
        String var3 = null;
        String var4 = null;
        int var7 = (int)var0.unmarshalUB4();
        if (var7 > 0) {
            byte[] var8 = new byte[var7];
            var0.unmarshalCLR(var8, 0, var1);
            var2 = var0.conv.CharBytesToString(var8, var1[0]);
        }

        int var12 = (int)var0.unmarshalUB4();
        if (var12 > 0) {
            byte[] var9 = new byte[var12];
            var0.unmarshalCLR(var9, 0, var1);
            var3 = var0.conv.CharBytesToString(var9, var1[0]);
        }

        int var13 = (int)var0.unmarshalUB4();
        if (var13 > 0) {
            byte[] var10 = new byte[var13];
            var0.unmarshalCLR(var10, 0, var1);
            var4 = var0.conv.CharBytesToString(var10, var1[0]);
        }

        long var5 = var0.unmarshalUB4();
        XSAttributeI var11 = new XSAttributeI();
        var11.setAttributeName(var2);
        var11.setAttributeValue(var3);
        var11.setAttributeDefaultValue(var4);
        var11.setFlag(var5);
        return var11;
    }
}
