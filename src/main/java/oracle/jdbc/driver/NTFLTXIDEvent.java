//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package oracle.jdbc.driver;

import oracle.jdbc.LogicalTransactionIdEvent;

class NTFLTXIDEvent extends LogicalTransactionIdEvent {
    LogicalTransactionId ltxid;
    private static final String _Copyright_2007_Oracle_All_Rights_Reserved_ = null;
    public static final String BUILD_DATE = "Thu_Apr_04_15:09:24_PDT_2013";
    public static final boolean TRACE = false;

    NTFLTXIDEvent(T4CConnection var1, LogicalTransactionId var2) {
        super(var1);
        this.ltxid = var2;
    }

    public oracle.jdbc.LogicalTransactionId getLogicalTransactionId() {
        return this.ltxid;
    }
}
