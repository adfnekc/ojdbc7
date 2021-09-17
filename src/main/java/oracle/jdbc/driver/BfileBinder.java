//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package oracle.jdbc.driver;

class BfileBinder extends DatumBinder {
    Binder theBfileCopyingBinder;
    private static final String _Copyright_2007_Oracle_All_Rights_Reserved_ = null;
    public static final String BUILD_DATE = "Thu_Apr_04_15:09:24_PDT_2013";
    public static final boolean TRACE = false;

    static void init(Binder var0) {
        var0.type = 114;
        var0.bytelen = 530;
    }

    BfileBinder() {
        this.theBfileCopyingBinder = OraclePreparedStatementReadOnly.theStaticBfileCopyingBinder;
        init(this);
        this.skipBindChecksumForLobs = true;
    }

    Binder copyingBinder() {
        return this.theBfileCopyingBinder;
    }
}
