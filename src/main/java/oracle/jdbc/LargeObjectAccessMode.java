//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package oracle.jdbc;

public enum LargeObjectAccessMode {
    MODE_READONLY(0),
    MODE_READWRITE(1);

    private final int code;

    private LargeObjectAccessMode(int var3) {
        this.code = var3;
    }

    public int getCode() {
        return this.code;
    }
}
