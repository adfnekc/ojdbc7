//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package oracle.sql;

import java.sql.SQLException;

class CharacterSetAL32UTF8 extends CharacterSet implements CharacterRepConstants {
    private static int[] m_byteLen = new int[]{1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 2, 2, 3, 4};
    private static final String _Copyright_2007_Oracle_All_Rights_Reserved_ = null;
    public static final String BUILD_DATE = "Thu_Apr_04_15:09:24_PDT_2013";
    public static final boolean TRACE = false;

    CharacterSetAL32UTF8(int var1) {
        super(var1);
        this.rep = 6;
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
            char[] var4 = new char[var1.length];
            int[] var5 = new int[]{var3};
            int var6 = CharacterSet.convertAL32UTF8BytesToJavaChars(var1, var2, var4, 0, var5, true);
            return new String(var4, 0, var6);
        } catch (SQLException var7) {
            return "";
        }
    }

    public String toString(byte[] var1, int var2, int var3) throws SQLException {
        try {
            char[] var4 = new char[var1.length];
            int[] var5 = new int[]{var3};
            int var6 = CharacterSet.convertAL32UTF8BytesToJavaChars(var1, var2, var4, 0, var5, false);
            return new String(var4, 0, var6);
        } catch (SQLException var7) {
            failUTFConversion();
            return "";
        }
    }

    public byte[] convertWithReplacement(String var1) {
        return stringToAL32UTF8(var1);
    }

    public byte[] convert(String var1) throws SQLException {
        return stringToAL32UTF8(var1);
    }

    public byte[] convert(CharacterSet var1, byte[] var2, int var3, int var4) throws SQLException {
        byte[] var5;
        if (var1.rep == 6) {
            var5 = useOrCopy(var2, var3, var4);
        } else {
            String var6 = var1.toString(var2, var3, var4);
            var5 = stringToAL32UTF8(var6);
        }

        return var5;
    }

    int decode(CharacterWalker var1) throws SQLException {
        byte[] var2 = var1.bytes;
        int var3 = var1.next;
        int var4 = var1.end;
        if (var3 >= var4) {
            failUTFConversion();
        }

        byte var5 = var2[var3];
        int var6 = getUTFByteLength((byte)var5);
        if (var6 == 0 || var3 + (var6 - 1) >= var4) {
            failUTFConversion();
        }

        try {
            char[] var7 = new char[2];
            int[] var8 = new int[]{var6};
            int var9 = CharacterSet.convertAL32UTF8BytesToJavaChars(var2, var3, var7, 0, var8, false);
            var1.next += var6;
            return var9 == 1 ? var7[0] : var7[0] << 16 | var7[1];
        } catch (SQLException var10) {
            failUTFConversion();
            return 0;
        }
    }

    void encode(CharacterBuffer var1, int var2) throws SQLException {
        char[] var3;
        int var4;
        if ((var2 & -65536) != 0) {
            need(var1, 4);
            var3 = new char[]{(char)(var2 >>> 16), (char)var2};
            var4 = CharacterSet.convertJavaCharsToAL32UTF8Bytes(var3, 0, var1.bytes, var1.next, 2);
        } else {
            need(var1, 3);
            var3 = new char[]{(char)var2};
            var4 = CharacterSet.convertJavaCharsToAL32UTF8Bytes(var3, 0, var1.bytes, var1.next, 1);
        }

        var1.next += var4;
    }

    private static int getUTFByteLength(byte var0) {
        return m_byteLen[var0 >>> 4 & 15];
    }

    public int encodedByteLength(String var1) {
        return CharacterSet.string32UTF8Length(var1);
    }

    public int encodedByteLength(char[] var1) {
        return CharacterSet.charArray32UTF8Length(var1);
    }
}
