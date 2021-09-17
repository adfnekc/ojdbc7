//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package oracle.jdbc.dcn;

import oracle.jdbc.dcn.DatabaseChangeEvent.EventType;

public interface QueryChangeDescription {
    long getQueryId();

    QueryChangeDescription.QueryChangeEventType getQueryChangeEventType();

    TableChangeDescription[] getTableChangeDescription();

    public static enum QueryChangeEventType {
        DEREG(EventType.DEREG.getCode()),
        QUERYCHANGE(EventType.QUERYCHANGE.getCode());

        private final int code;

        private QueryChangeEventType(int var3) {
            this.code = var3;
        }

        public final int getCode() {
            return this.code;
        }

        public static final QueryChangeDescription.QueryChangeEventType getQueryChangeEventType(int var0) {
            return var0 == DEREG.getCode() ? DEREG : QUERYCHANGE;
        }
    }
}
