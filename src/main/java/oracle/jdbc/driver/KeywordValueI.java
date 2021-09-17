//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package oracle.jdbc.driver;

import java.io.IOException;
import java.sql.SQLException;
import oracle.jdbc.internal.KeywordValue;

class KeywordValueI extends KeywordValue {
    private int keyword;
    private byte[] binaryValue;
    private String textValue;
    private byte[] textValueArr;
    private static final String _Copyright_2007_Oracle_All_Rights_Reserved_ = null;
    public static final String BUILD_DATE = "Thu_Apr_04_15:09:24_PDT_2013";
    public static final boolean TRACE = false;

    KeywordValueI(int var1, String var2, byte[] var3) {
        this.keyword = var1;
        this.textValue = var2;
        this.binaryValue = var3;
        this.textValueArr = null;
    }

    void doCharConversion(DBConversion var1) throws SQLException {
        if (this.textValue != null) {
            this.textValueArr = var1.StringToCharBytes(this.textValue);
        } else {
            this.textValueArr = null;
        }

    }

    public byte[] getBinaryValue() throws SQLException {
        return this.binaryValue;
    }

    public String getTextValue() throws SQLException {
        return this.textValue;
    }

    public int getKeyword() throws SQLException {
        return this.keyword;
    }

    void marshal(T4CMAREngine var1) throws IOException {
        if (this.textValueArr != null) {
            var1.marshalUB2(this.textValueArr.length);
            var1.marshalCLR(this.textValueArr, this.textValueArr.length);
            var1.marshalUB2(0);
        } else {
            var1.marshalUB2(0);
            if (this.binaryValue != null) {
                var1.marshalUB2(this.binaryValue.length);
                var1.marshalCLR(this.binaryValue, this.binaryValue.length);
            } else {
                var1.marshalUB2(0);
            }
        }

        var1.marshalUB2(this.keyword);
    }

    static KeywordValueI unmarshal(T4CMAREngine var0) throws SQLException, IOException {
        int[] var1 = new int[1];
        String var2 = null;
        byte[] var3 = null;
        int var4 = var0.unmarshalUB2();
        if (var4 != 0) {
            byte[] var5 = new byte[var4];
            var0.unmarshalCLR(var5, 0, var1);
            var2 = var0.conv.CharBytesToString(var5, var5.length);
        }

        int var7 = var0.unmarshalUB2();
        if (var7 != 0) {
            var3 = new byte[var7];
            var0.unmarshalCLR(var3, 0, var1);
        }

        int var6 = var0.unmarshalUB2();
        return new KeywordValueI(var6, var2, var3);
    }
}
