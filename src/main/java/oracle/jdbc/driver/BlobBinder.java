//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package oracle.jdbc.driver;

class BlobBinder extends DatumBinder {
    Binder theBlobCopyingBinder;
    private static final String _Copyright_2007_Oracle_All_Rights_Reserved_ = null;
    public static final String BUILD_DATE = "Thu_Apr_04_15:09:24_PDT_2013";
    public static final boolean TRACE = false;

    static void init(Binder var0) {
        var0.type = 113;
        var0.bytelen = 4000;
    }

    BlobBinder() {
        this.theBlobCopyingBinder = OraclePreparedStatementReadOnly.theStaticBlobCopyingBinder;
        init(this);
        this.skipBindChecksumForLobs = true;
    }

    Binder copyingBinder() {
        return this.theBlobCopyingBinder;
    }

    void lastBoundValueCleanup(OraclePreparedStatement var1, int var2) {
        if (var1.lastBoundBlobs != null) {
            var1.moveTempLobsToFree(var1.lastBoundBlobs[var2]);
        }

    }
}
