//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package oracle.jdbc.oracore;

import java.io.ByteArrayOutputStream;

public class PickleOutputStream extends ByteArrayOutputStream {
    private static final String _Copyright_2007_Oracle_All_Rights_Reserved_ = null;
    public static final String BUILD_DATE = "Thu_Apr_04_15:09:24_PDT_2013";
    public static final boolean TRACE = false;

    public PickleOutputStream() {
    }

    public PickleOutputStream(int var1) {
        super(var1);
    }

    public synchronized int offset() {
        return this.count;
    }

    public synchronized void overwrite(int var1, byte[] var2, int var3, int var4) {
        if (var3 >= 0 && var3 <= var2.length && var4 >= 0 && var3 + var4 <= var2.length && var3 + var4 >= 0 && var1 + var4 <= this.buf.length) {
            if (var4 != 0) {
                for(int var5 = 0; var5 < var4; ++var5) {
                    this.buf[var1 + var5] = var2[var3 + var5];
                }

            }
        } else {
            throw new IndexOutOfBoundsException();
        }
    }
}
