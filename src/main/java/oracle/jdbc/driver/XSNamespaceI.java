//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package oracle.jdbc.driver;

import java.io.IOException;
import java.sql.SQLException;
import oracle.jdbc.internal.XSAttribute;
import oracle.jdbc.internal.XSNamespace;
import oracle.sql.TIMESTAMPTZ;

class XSNamespaceI extends XSNamespace {
    String namespaceName = null;
    byte[] namespaceNameBytes = null;
    String kpxsnshandler = null;
    byte[] kpxsnshandlerBytes = null;
    XSAttributeI[] attributes = null;
    byte[] timestampBytes = null;
    long flag = 0L;
    long[] aclList = null;
    private static final String _Copyright_2007_Oracle_All_Rights_Reserved_ = null;
    public static final String BUILD_DATE = "Thu_Apr_04_15:09:24_PDT_2013";
    public static final boolean TRACE = false;

    XSNamespaceI() {
    }

    public void setNamespaceName(String var1) throws SQLException {
        this.namespaceName = var1;
    }

    public void setNamespaceHandler(String var1) throws SQLException {
        this.kpxsnshandler = var1;
    }

    public void setTimestamp(TIMESTAMPTZ var1) throws SQLException {
        this.timestampBytes = var1.toBytes();
    }

    private void setTimestamp(byte[] var1) throws SQLException {
        this.timestampBytes = var1;
    }

    public void setACLIdList(long[] var1) throws SQLException {
        this.aclList = var1;
    }

    public void setFlag(long var1) throws SQLException {
        this.flag = var1;
    }

    public void setAttributes(XSAttribute[] var1) throws SQLException {
        if (var1 != null) {
            XSAttributeI[] var2 = new XSAttributeI[var1.length];

            for(int var3 = 0; var3 < var1.length; ++var3) {
                var2[var3] = (XSAttributeI)var1[var3];
            }

            this.attributes = var2;
        }

    }

    void doCharConversion(DBConversion var1) throws SQLException {
        if (this.namespaceName != null) {
            this.namespaceNameBytes = var1.StringToCharBytes(this.namespaceName);
        } else {
            this.namespaceNameBytes = null;
        }

        if (this.kpxsnshandler != null) {
            this.kpxsnshandlerBytes = var1.StringToCharBytes(this.kpxsnshandler);
        } else {
            this.kpxsnshandlerBytes = null;
        }

        if (this.attributes != null) {
            for(int var2 = 0; var2 < this.attributes.length; ++var2) {
                this.attributes[var2].doCharConversion(var1);
            }
        }

    }

    public String getNamespaceName() {
        return this.namespaceName;
    }

    public String getNamespaceHandler() {
        return this.kpxsnshandler;
    }

    public TIMESTAMPTZ getTimestamp() {
        return new TIMESTAMPTZ(this.timestampBytes);
    }

    public long getFlag() {
        return this.flag;
    }

    public XSAttribute[] getAttributes() {
        return this.attributes;
    }

    public long[] getACLIdList() {
        return this.aclList;
    }

    void marshal(T4CMAREngine var1) throws IOException {
        if (this.namespaceNameBytes != null) {
            var1.marshalUB4((long)this.namespaceNameBytes.length);
            var1.marshalCLR(this.namespaceNameBytes, this.namespaceNameBytes.length);
        } else {
            var1.marshalUB4(0L);
        }

        if (this.kpxsnshandlerBytes != null) {
            var1.marshalUB4((long)this.kpxsnshandlerBytes.length);
            var1.marshalCLR(this.kpxsnshandlerBytes, this.kpxsnshandlerBytes.length);
        } else {
            var1.marshalUB4(0L);
        }

        if (this.timestampBytes != null) {
            var1.marshalUB4((long)this.timestampBytes.length);
            var1.marshalCLR(this.timestampBytes, this.timestampBytes.length);
        } else {
            var1.marshalUB4(0L);
        }

        var1.marshalUB4(this.flag);
        int var2;
        if (this.attributes != null) {
            var1.marshalUB4((long)this.attributes.length);
            var1.marshalUB1((short)28);

            for(var2 = 0; var2 < this.attributes.length; ++var2) {
                this.attributes[var2].marshal(var1);
            }
        } else {
            var1.marshalUB4(0L);
        }

        if (this.aclList != null) {
            var1.marshalUB4((long)this.aclList.length);
            var1.marshalUB1((short)8);

            for(var2 = 0; var2 < this.aclList.length; ++var2) {
                var1.marshalSB8(this.aclList[var2]);
            }
        } else {
            var1.marshalUB4(0L);
        }

    }

    static XSNamespaceI unmarshal(T4CMAREngine var0) throws SQLException, IOException {
        int[] var1 = new int[1];
        String var2 = null;
        int var5 = (int)var0.unmarshalUB4();
        if (var5 > 0) {
            byte[] var6 = new byte[var5];
            var0.unmarshalCLR(var6, 0, var1);
            var2 = var0.conv.CharBytesToString(var6, var1[0]);
        }

        int var14 = (int)var0.unmarshalUB4();
        String var7 = null;
        byte[] var8;
        if (var14 > 0) {
            var8 = new byte[var5];
            var0.unmarshalCLR(var8, 0, var1);
            var7 = var0.conv.CharBytesToString(var8, var1[0]);
        }

        var8 = null;
        if (var0.unmarshalUB1() == 1) {
            int var9 = (int)var0.unmarshalUB4();
            var8 = var0.unmarshalNBytes(var9);
        }

        long var3 = var0.unmarshalUB4();
        XSAttribute[] var15 = null;
        int var10 = (int)var0.unmarshalUB4();
        var15 = new XSAttribute[var10];
        if (var10 > 0) {
            var0.unmarshalUB1();
        }

        int var11;
        for(var11 = 0; var11 < var10; ++var11) {
            var15[var11] = XSAttributeI.unmarshal(var0);
        }

        var11 = (int)var0.unmarshalUB4();
        long[] var12 = null;
        if (var11 > 0) {
            var12 = new long[var11];

            for(int var13 = 0; var13 < var11; ++var13) {
                var12[var13] = var0.unmarshalSB8();
            }
        }

        XSNamespaceI var16 = new XSNamespaceI();
        var16.setNamespaceName(var2);
        var16.setNamespaceHandler(var7);
        var16.setTimestamp(var8);
        var16.setFlag(var3);
        var16.setAttributes(var15);
        var16.setACLIdList(var12);
        return var16;
    }
}
