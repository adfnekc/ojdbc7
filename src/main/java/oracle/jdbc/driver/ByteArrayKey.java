//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package oracle.jdbc.driver;

class ByteArrayKey {
    private byte[] theBytes;
    private int cachedHashCode = -1;
    private static final String _Copyright_2007_Oracle_All_Rights_Reserved_ = null;
    public static final String BUILD_DATE = "Thu_Apr_04_15:09:24_PDT_2013";
    public static final boolean TRACE = false;

    public ByteArrayKey(byte[] var1) {
        this.theBytes = var1;
        byte[] var2 = this.theBytes;
        int var3 = var2.length;

        for(int var4 = 0; var4 < var3; ++var4) {
            byte var5 = var2[var4];
            this.cachedHashCode = this.cachedHashCode << 1 & (this.cachedHashCode < 0 ? 1 : 0) ^ var5;
        }

    }

    public boolean equals(Object var1) {
        if (var1 == this) {
            return true;
        } else if (!(var1 instanceof ByteArrayKey)) {
            return false;
        } else {
            byte[] var2 = ((ByteArrayKey)var1).theBytes;
            if (this.theBytes.length != var2.length) {
                return false;
            } else {
                for(int var3 = 0; var3 < this.theBytes.length; ++var3) {
                    if (this.theBytes[var3] != var2[var3]) {
                        return false;
                    }
                }

                return true;
            }
        }
    }

    public int hashCode() {
        return this.cachedHashCode;
    }
}
