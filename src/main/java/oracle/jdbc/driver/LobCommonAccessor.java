//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package oracle.jdbc.driver;

import java.sql.SQLException;
import java.util.Map;

abstract class LobCommonAccessor extends Accessor {
    long[] prefetchedDataOffset;
    int[] prefetchedDataLength;
    long[] prefetchedLength;
    int[] prefetchedChunkSize;
    private static final String _Copyright_2007_Oracle_All_Rights_Reserved_ = null;
    public static final String BUILD_DATE = "Thu_Apr_04_15:09:24_PDT_2013";
    public static final boolean TRACE = false;

    LobCommonAccessor(Representation var1, OracleStatement var2, int var3, boolean var4) {
        super(var1, var2, var3, var4);
    }

    void setCapacity(int var1) {
        super.setCapacity(var1);
        if (this.isPrefetched() && this.prefetchedDataOffset == null) {
            this.prefetchedDataOffset = new long[var1];
            this.prefetchedDataLength = new int[var1];
            this.prefetchedLength = new long[var1];
            this.prefetchedChunkSize = new int[var1];
        } else if (this.isPrefetched() && var1 > this.prefetchedDataOffset.length) {
            long[] var2 = new long[var1];
            System.arraycopy(this.prefetchedDataOffset, 0, var2, 0, this.prefetchedDataOffset.length);
            this.prefetchedDataOffset = (long[])((long[])var2);
            int[] var3 = new int[var1];
            System.arraycopy(this.prefetchedDataLength, 0, var3, 0, this.prefetchedDataLength.length);
            this.prefetchedDataLength = (int[])((int[])var3);
            var2 = new long[var1];
            System.arraycopy(this.prefetchedLength, 0, var2, 0, this.prefetchedLength.length);
            this.prefetchedLength = (long[])((long[])var2);
            var3 = new int[var1];
            System.arraycopy(this.prefetchedChunkSize, 0, var3, 0, this.prefetchedChunkSize.length);
            this.prefetchedChunkSize = (int[])((int[])var3);
        }

    }

    Accessor copyForDefine(OracleStatement var1) {
        LobCommonAccessor var2 = (LobCommonAccessor)super.copyForDefine(var1);
        var2.prefetchedDataOffset = null;
        var2.prefetchedDataLength = null;
        var2.prefetchedLength = null;
        var2.prefetchedChunkSize = null;
        return var2;
    }

    protected void copyFromInternal(Accessor var1, int var2, int var3) throws SQLException {
        super.copyFromInternal(var1, var2, var3);
        if (this.isPrefetched()) {
            LobCommonAccessor var4 = (LobCommonAccessor)var1;

            assert var4.isPrefetched() : "srcLobAcc is not prefetched";

            long var5 = this.rowData.length();
            if (var4.getPrefetchedDataLength(var2) <= this.getPrefetchedDataLength(var3)) {
                var5 = this.getPrefetchedDataOffset(var3);
            }

            this.rowData.put(var5, var4.rowData, var4.getPrefetchedDataOffset(var2), var4.getPrefetchedDataLength(var2));
            this.setPrefetchedDataOffset(var3, var5);
            this.setPrefetchedDataLength(var3, var4.getPrefetchedDataLength(var2));
            this.setPrefetchedLength(var3, var4.getPrefetchedLength(var2));
            this.setPrefetchedChunkSize(var3, var4.getPrefetchedChunkSize(var2));
        }

    }

    void deleteRow(int var1) throws SQLException {
        super.deleteRow(var1);
        if (this.isPrefetched()) {
            this.rowData.freeSpace(this.getPrefetchedDataOffset(var1), this.getPrefetchedDataLength(var1));
            this.delete(this.prefetchedDataOffset, var1);
            this.delete(this.prefetchedDataLength, var1);
            this.delete(this.prefetchedLength, var1);
            this.delete(this.prefetchedChunkSize, var1);
        }

    }

    final boolean isPrefetched() {
        return !this.isDMLReturnedParam && this.lobPrefetchSizeForThisColumn > -1;
    }

    void setNoPrefetch() {
        this.lobPrefetchSizeForThisColumn = -1;
        this.prefetchedDataOffset = null;
        this.prefetchedDataLength = null;
        this.prefetchedLength = null;
        this.prefetchedChunkSize = null;
    }

    final int getPrefetchLength() {
        return this.lobPrefetchSizeForThisColumn;
    }

    void setPrefetchLength(int var1) {
        if (var1 == -1) {
            this.setNoPrefetch();
        } else {
            this.lobPrefetchSizeForThisColumn = var1;
            if (this.rowNull != null) {
                this.setCapacity(this.rowNull.length);
            }
        }

    }

    final void setPrefetchedDataOffset(int var1) {
        assert this.prefetchedDataOffset.length > var1 : "prefetchedDataOffset.length: " + this.prefetchedDataOffset.length + " currentRow: " + var1;

        this.prefetchedDataOffset[var1] = this.rowData.getPosition();
    }

    final void setPrefetchedDataOffset(int var1, long var2) {
        assert this.prefetchedDataOffset.length > var1 : "prefetchedDataOffset.length: " + this.prefetchedDataOffset.length + " currentRow: " + var1;

        this.prefetchedDataOffset[var1] = var2;
    }

    final void setPrefetchedDataLength(int var1, int var2) {
        assert this.prefetchedDataLength.length > var1 : "prefetchedDataLength.length: " + this.prefetchedDataLength.length + " currentRow: " + var1;

        this.prefetchedDataLength[var1] = var2;
    }

    final void setPrefetchedLength(int var1, long var2) {
        assert this.prefetchedLength.length > var1 : "prefetchedLength.length: " + this.prefetchedLength.length + " currentRow: " + var1;

        this.prefetchedLength[var1] = var2;
    }

    final void setPrefetchedChunkSize(int var1, int var2) {
        assert this.prefetchedChunkSize.length > var1 : "prefetchedChunkSize.length: " + this.prefetchedChunkSize.length + " currentRow: " + var1;

        this.prefetchedChunkSize[var1] = var2;
    }

    final long getPrefetchedDataOffset(int var1) {
        return this.prefetchedDataOffset[var1];
    }

    final int getPrefetchedDataLength(int var1) {
        return this.prefetchedDataLength[var1];
    }

    final long getPrefetchedLength(int var1) {
        return this.prefetchedLength[var1];
    }

    final int getPrefetchedChunkSize(int var1) {
        return this.prefetchedChunkSize[var1];
    }

    final byte[] getPrefetchedData(int var1) {
        return this.getPrefetchLength() > -1 ? this.rowData.get(this.getPrefetchedDataOffset(var1), this.getPrefetchedDataLength(var1)) : null;
    }

    Object getObject(int var1) throws SQLException {
        return this.getOracleObject(var1);
    }

    Object getObject(int var1, Map var2) throws SQLException {
        return this.getOracleObject(var1);
    }
}
