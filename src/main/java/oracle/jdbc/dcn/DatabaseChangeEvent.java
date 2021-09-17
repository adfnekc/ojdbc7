//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package oracle.jdbc.dcn;

import java.util.EventObject;

public abstract class DatabaseChangeEvent extends EventObject {
    private static final String _Copyright_2007_Oracle_All_Rights_Reserved_ = null;
    public static final String BUILD_DATE = "Thu_Apr_04_15:09:24_PDT_2013";
    public static final boolean TRACE = false;

    protected DatabaseChangeEvent(Object var1) {
        super(var1);
    }

    public abstract DatabaseChangeEvent.EventType getEventType();

    public abstract DatabaseChangeEvent.AdditionalEventType getAdditionalEventType();

    public abstract TableChangeDescription[] getTableChangeDescription();

    public abstract QueryChangeDescription[] getQueryChangeDescription();

    public abstract String getConnectionInformation();

    public abstract String getDatabaseName();

    /** @deprecated */
    public abstract int getRegistrationId();

    public abstract long getRegId();

    public abstract byte[] getTransactionId();

    public abstract String getTransactionId(boolean var1);

    public abstract String toString();

    public static enum AdditionalEventType {
        NONE(0),
        TIMEOUT(1),
        GROUPING(2);

        private final int code;

        private AdditionalEventType(int var3) {
            this.code = var3;
        }

        public final int getCode() {
            return this.code;
        }

        public static final DatabaseChangeEvent.AdditionalEventType getEventType(int var0) {
            if (var0 == TIMEOUT.getCode()) {
                return TIMEOUT;
            } else {
                return var0 == GROUPING.getCode() ? GROUPING : NONE;
            }
        }
    }

    public static enum EventType {
        NONE(0),
        STARTUP(1),
        SHUTDOWN(2),
        SHUTDOWN_ANY(3),
        DEREG(5),
        OBJCHANGE(6),
        QUERYCHANGE(7);

        private final int code;

        private EventType(int var3) {
            this.code = var3;
        }

        public final int getCode() {
            return this.code;
        }

        public static final DatabaseChangeEvent.EventType getEventType(int var0) {
            if (var0 == STARTUP.getCode()) {
                return STARTUP;
            } else if (var0 == SHUTDOWN.getCode()) {
                return SHUTDOWN;
            } else if (var0 == SHUTDOWN_ANY.getCode()) {
                return SHUTDOWN_ANY;
            } else if (var0 == DEREG.getCode()) {
                return DEREG;
            } else if (var0 == OBJCHANGE.getCode()) {
                return OBJCHANGE;
            } else {
                return var0 == QUERYCHANGE.getCode() ? QUERYCHANGE : NONE;
            }
        }
    }
}
