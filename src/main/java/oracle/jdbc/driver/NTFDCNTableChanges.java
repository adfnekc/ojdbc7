//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package oracle.jdbc.driver;

import java.nio.ByteBuffer;
import java.util.EnumSet;
import oracle.jdbc.dcn.RowChangeDescription;
import oracle.jdbc.dcn.TableChangeDescription;
import oracle.jdbc.dcn.RowChangeDescription.RowOperation;
import oracle.jdbc.dcn.TableChangeDescription.TableOperation;
import oracle.sql.CharacterSet;

class NTFDCNTableChanges implements TableChangeDescription {
    final EnumSet<TableOperation> opcode;
    String tableName;
    final int objectNumber;
    final int numberOfRows;
    final RowOperation[] rowOpcode;
    final int[] rowIdLength;
    final byte[][] rowid;
    final CharacterSet charset;
    NTFDCNRowChanges[] rowsDescription = null;
    private static final byte OPERATION_ANY = 0;
    private static final byte OPERATION_UNKNOWN = 64;
    private static final String _Copyright_2007_Oracle_All_Rights_Reserved_ = null;
    public static final String BUILD_DATE = "Thu_Apr_04_15:09:24_PDT_2013";
    public static final boolean TRACE = false;

    NTFDCNTableChanges(ByteBuffer var1, int var2) {
        this.charset = CharacterSet.make(var2);
        this.opcode = TableOperation.getTableOperations(var1.getInt());
        short var3 = var1.getShort();
        byte[] var4 = new byte[var3];
        var1.get(var4, 0, var3);
        this.tableName = this.charset.toStringWithReplacement(var4, 0, var3);
        this.objectNumber = var1.getInt();
        if (!this.opcode.contains(TableOperation.ALL_ROWS)) {
            this.numberOfRows = var1.getShort();
            this.rowOpcode = new RowOperation[this.numberOfRows];
            this.rowIdLength = new int[this.numberOfRows];
            this.rowid = new byte[this.numberOfRows][];

            for(int var5 = 0; var5 < this.numberOfRows; ++var5) {
                this.rowOpcode[var5] = RowOperation.getRowOperation(var1.getInt());
                this.rowIdLength[var5] = var1.getShort();
                this.rowid[var5] = new byte[this.rowIdLength[var5]];
                var1.get(this.rowid[var5], 0, this.rowIdLength[var5]);
            }
        } else {
            this.numberOfRows = 0;
            this.rowid = (byte[][])null;
            this.rowOpcode = null;
            this.rowIdLength = null;
        }

    }

    public String getTableName() {
        return this.tableName;
    }

    public int getObjectNumber() {
        return this.objectNumber;
    }

    public RowChangeDescription[] getRowChangeDescription() {
        if (this.rowsDescription == null) {
            synchronized(this) {
                if (this.rowsDescription == null) {
                    this.rowsDescription = new NTFDCNRowChanges[this.numberOfRows];

                    for(int var2 = 0; var2 < this.rowsDescription.length; ++var2) {
                        this.rowsDescription[var2] = new NTFDCNRowChanges(this.rowOpcode[var2], this.rowIdLength[var2], this.rowid[var2]);
                    }
                }
            }
        }

        return this.rowsDescription;
    }

    public EnumSet<TableOperation> getTableOperations() {
        return this.opcode;
    }

    public String toString() {
        StringBuffer var1 = new StringBuffer();
        var1.append("    operation=" + this.getTableOperations() + ", tableName=" + this.tableName + ", objectNumber=" + this.objectNumber + "\n");
        RowChangeDescription[] var2 = this.getRowChangeDescription();
        if (var2 != null && var2.length > 0) {
            var1.append("    Row Change Description (length=" + var2.length + "):\n");

            for(int var3 = 0; var3 < var2.length; ++var3) {
                var1.append(var2[var3].toString());
            }
        }

        return var1.toString();
    }
}
