//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package oracle.jdbc.driver;

class BINARY_FLOATBinder extends DatumBinder {
    Binder theBINARY_FLOATCopyingBinder;
    private static final String _Copyright_2007_Oracle_All_Rights_Reserved_ = null;
    public static final String BUILD_DATE = "Thu_Apr_04_15:09:24_PDT_2013";
    public static final boolean TRACE = false;

    static void init(Binder var0) {
        var0.type = 100;
        var0.bytelen = 4;
    }

    BINARY_FLOATBinder() {
        this.theBINARY_FLOATCopyingBinder = OraclePreparedStatementReadOnly.theStaticBINARY_FLOATCopyingBinder;
        init(this);
    }

    Binder copyingBinder() {
        return this.theBINARY_FLOATCopyingBinder;
    }
}
