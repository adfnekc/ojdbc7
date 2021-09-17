//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package oracle.jdbc.driver;

import java.nio.ByteBuffer;
import oracle.jdbc.dcn.QueryChangeDescription;
import oracle.jdbc.dcn.TableChangeDescription;
import oracle.jdbc.dcn.QueryChangeDescription.QueryChangeEventType;

class NTFDCNQueryChanges implements QueryChangeDescription {
    private final long queryId;
    private final QueryChangeEventType queryopflags;
    private final int numberOfTables;
    private final NTFDCNTableChanges[] tcdesc;
    private static final String _Copyright_2007_Oracle_All_Rights_Reserved_ = null;
    public static final String BUILD_DATE = "Thu_Apr_04_15:09:24_PDT_2013";
    public static final boolean TRACE = false;

    NTFDCNQueryChanges(ByteBuffer var1, int var2) {
        long var3 = (long)(var1.getInt() & -1);
        long var5 = (long)(var1.getInt() & -1);
        this.queryId = var3 | var5 << 32;
        this.queryopflags = QueryChangeEventType.getQueryChangeEventType(var1.getInt());
        this.numberOfTables = var1.getShort();
        this.tcdesc = new NTFDCNTableChanges[this.numberOfTables];

        for(int var7 = 0; var7 < this.tcdesc.length; ++var7) {
            this.tcdesc[var7] = new NTFDCNTableChanges(var1, var2);
        }

    }

    public long getQueryId() {
        return this.queryId;
    }

    public QueryChangeEventType getQueryChangeEventType() {
        return this.queryopflags;
    }

    public TableChangeDescription[] getTableChangeDescription() {
        return this.tcdesc;
    }

    public String toString() {
        StringBuffer var1 = new StringBuffer();
        var1.append("  query ID=" + this.queryId + ", query change event type=" + this.queryopflags + "\n");
        TableChangeDescription[] var2 = this.getTableChangeDescription();
        if (var2 != null) {
            var1.append("  Table Change Description (length=" + var2.length + "):");

            for(int var3 = 0; var3 < var2.length; ++var3) {
                var1.append(var2[var3].toString());
            }
        }

        return var1.toString();
    }
}
