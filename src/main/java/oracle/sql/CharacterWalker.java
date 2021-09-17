//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package oracle.sql;

import java.sql.SQLException;
import java.util.NoSuchElementException;

public final class CharacterWalker {
    CharacterSet charSet;
    byte[] bytes;
    int next;
    int end;
    int shiftstate;
    private static final String _Copyright_2007_Oracle_All_Rights_Reserved_ = null;
    public static final String BUILD_DATE = "Thu_Apr_04_15:09:24_PDT_2013";
    public static final boolean TRACE = false;

    public CharacterWalker(CharacterSet var1, byte[] var2, int var3, int var4) {
        this.charSet = var1;
        this.bytes = var2;
        this.next = var3;
        this.end = var3 + var4;
        if (this.next < 0) {
            this.next = 0;
        }

        if (this.end > var2.length) {
            this.end = var2.length;
        }

    }

    public int nextCharacter() throws NoSuchElementException {
        try {
            return this.charSet.decode(this);
        } catch (SQLException var2) {
            throw new NoSuchElementException(var2.getMessage());
        }
    }

    public boolean hasMoreCharacters() {
        return this.next < this.end;
    }
}
