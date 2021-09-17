//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package oracle.jdbc.driver;

abstract class VarcharBinder extends Binder {
    Binder theVarcharCopyingBinder;
    private static final String _Copyright_2007_Oracle_All_Rights_Reserved_ = null;
    public static final String BUILD_DATE = "Thu_Apr_04_15:09:24_PDT_2013";
    public static final boolean TRACE = false;

    static void init(Binder var0) {
        var0.type = 9;
        var0.bytelen = 0;
    }

    VarcharBinder() {
        this.theVarcharCopyingBinder = OraclePreparedStatementReadOnly.theStaticVarcharCopyingBinder;
        init(this);
    }

    Binder copyingBinder() {
        return this.theVarcharCopyingBinder;
    }
}
