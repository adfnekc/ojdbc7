//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package oracle.jdbc;

import java.util.EventObject;

public abstract class LogicalTransactionIdEvent extends EventObject {
    protected LogicalTransactionIdEvent(Object var1) {
        super(var1);
    }

    public abstract LogicalTransactionId getLogicalTransactionId();
}
