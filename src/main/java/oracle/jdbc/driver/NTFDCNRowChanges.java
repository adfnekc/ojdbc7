//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package oracle.jdbc.driver;

import oracle.jdbc.dcn.RowChangeDescription;
import oracle.jdbc.dcn.RowChangeDescription.RowOperation;
import oracle.sql.ROWID;

class NTFDCNRowChanges implements RowChangeDescription {
    RowOperation opcode;
    int rowidLength;
    byte[] rowid;
    ROWID rowidObj;
    private static final String _Copyright_2007_Oracle_All_Rights_Reserved_ = null;
    public static final String BUILD_DATE = "Thu_Apr_04_15:09:24_PDT_2013";
    public static final boolean TRACE = false;

    NTFDCNRowChanges(RowOperation var1, int var2, byte[] var3) {
        this.opcode = var1;
        this.rowidLength = var2;
        this.rowid = var3;
        this.rowidObj = null;
    }

    public ROWID getRowid() {
        if (this.rowidObj == null) {
            this.rowidObj = new ROWID(this.rowid);
        }

        return this.rowidObj;
    }

    public RowOperation getRowOperation() {
        return this.opcode;
    }

    public String toString() {
        StringBuffer var1 = new StringBuffer();
        var1.append("      ROW:  operation=" + this.getRowOperation() + ", ROWID=" + new String(this.rowid) + "\n");
        return var1.toString();
    }
}
