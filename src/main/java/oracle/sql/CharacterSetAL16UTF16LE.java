//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package oracle.sql;

import java.sql.SQLException;

class CharacterSetAL16UTF16LE extends CharacterSet implements CharacterRepConstants {
    private static final String _Copyright_2007_Oracle_All_Rights_Reserved_ = null;
    public static final String BUILD_DATE = "Thu_Apr_04_15:09:24_PDT_2013";
    public static final boolean TRACE = false;

    CharacterSetAL16UTF16LE(int var1) {
        super(var1);
        this.rep = 5;
    }

    public boolean isLossyFrom(CharacterSet var1) {
        return !var1.isUnicode();
    }

    public boolean isConvertibleFrom(CharacterSet var1) {
        boolean var2 = var1.rep <= 1024;
        return var2;
    }

    public boolean isUnicode() {
        return true;
    }

    public String toStringWithReplacement(byte[] var1, int var2, int var3) {
        try {
            char[] var4 = new char[Math.min(var1.length - var2 >>> 1, var3 >>> 1)];
            int var5 = CharacterSet.convertAL16UTF16LEBytesToJavaChars(var1, var2, var4, 0, var3, true);
            return new String(var4, 0, var5);
        } catch (SQLException var6) {
            return "";
        }
    }

    public String toString(byte[] var1, int var2, int var3) throws SQLException {
        try {
            char[] var4 = new char[Math.min(var1.length - var2 >>> 1, var3 >>> 1)];
            int var5 = CharacterSet.convertAL16UTF16LEBytesToJavaChars(var1, var2, var4, 0, var3, false);
            return new String(var4, 0, var5);
        } catch (SQLException var6) {
            failUTFConversion();
            return "";
        }
    }

    public byte[] convert(String var1) throws SQLException {
        return stringToAL16UTF16LEBytes(var1);
    }

    public byte[] convertWithReplacement(String var1) {
        return stringToAL16UTF16LEBytes(var1);
    }

    public byte[] convert(CharacterSet var1, byte[] var2, int var3, int var4) throws SQLException {
        byte[] var5;
        if (var1.rep == 5) {
            var5 = useOrCopy(var2, var3, var4);
        } else {
            String var6 = var1.toString(var2, var3, var4);
            var5 = stringToAL16UTF16LEBytes(var6);
        }

        return var5;
    }

    int decode(CharacterWalker var1) throws SQLException {
        byte[] var4 = var1.bytes;
        int var5 = var1.next;
        int var6 = var1.end;
        if (var5 + 2 >= var6) {
            failUTFConversion();
        }

        byte var2 = var4[var5++];
        byte var3 = var4[var5++];
        int var7 = var2 << 8 & '\uff00' | var3;
        var1.next = var5;
        return var7;
    }

    void encode(CharacterBuffer var1, int var2) throws SQLException {
        if (var2 > 65535) {
            failUTFConversion();
        } else {
            need(var1, 2);
            var1.bytes[var1.next++] = (byte)(var2 >> 8 & 255);
            var1.bytes[var1.next++] = (byte)(var2 & 255);
        }

    }
}
