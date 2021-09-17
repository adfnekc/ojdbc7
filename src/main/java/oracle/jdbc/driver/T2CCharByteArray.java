//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package oracle.jdbc.driver;

import java.sql.SQLException;
import oracle.sql.CharacterSet;

class T2CCharByteArray extends AggregateByteArray {
    char[] charArray;
    DBConversion conversion;
    private static final String _Copyright_2007_Oracle_All_Rights_Reserved_ = null;
    public static final String BUILD_DATE = "Thu_Apr_04_15:09:24_PDT_2013";
    public static final boolean TRACE = false;

    T2CCharByteArray(char[] var1, ByteArray var2) {
        super(PhysicalConnection.EMPTY_BYTE_ARRAY, var2);
        this.charArray = var1;
    }

    long length() {
        return (long)this.charArray.length + this.extension.length();
    }

    void setChars(char[] var1) {
        this.charArray = var1;
    }

    void setDBConversion(DBConversion var1) {
        this.conversion = var1;
    }

    char[] getChars(long var1, int var3, CharacterSet var4, int[] var5) throws SQLException {
        if (var1 < (long)this.charArray.length) {
            char[] var6 = new char[var3];
            System.arraycopy(this.charArray, (int)var1, var6, 0, var3);
            var5[0] = var3;
            return var6;
        } else {
            return this.extension.getChars(var1 - (long)this.charArray.length, var3, var4, var5);
        }
    }

    void get(long var1, byte[] var3, int var4, int var5) {
        if (var1 < (long)this.charArray.length) {
            try {
                this.conversion.javaCharsToCHARBytes(this.charArray, (int)var1, var3, var4, var5);
            } catch (SQLException var7) {
            }
        } else {
            this.extension.get(var1 - (long)this.charArray.length, var3, var4, var5);
        }

    }

    byte get(long var1) {
        return var1 < (long)this.charArray.length ? (byte)(this.charArray[(int)var1] & 255) : this.extension.get(var1 - (long)this.charArray.length);
    }
}
