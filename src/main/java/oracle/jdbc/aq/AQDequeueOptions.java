//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package oracle.jdbc.aq;

import java.sql.SQLException;

public class AQDequeueOptions {
    public static final int DEQUEUE_WAIT_FOREVER = -1;
    public static final int DEQUEUE_NO_WAIT = 0;
    private String attrConsumerName = null;
    private String attrCorrelation = null;
    private AQDequeueOptions.DequeueMode attrDeqMode;
    private byte[] attrDeqMsgId;
    private AQDequeueOptions.NavigationOption attrNavigation;
    private AQDequeueOptions.VisibilityOption attrVisibility;
    private int attrWait;
    private int maxBufferLength;
    private AQDequeueOptions.DeliveryFilter attrDeliveryMode;
    private boolean retrieveMsgId;
    private String transformation;
    private String condition;
    public static final int MAX_RAW_PAYLOAD = 67108787;
    private static final String _Copyright_2007_Oracle_All_Rights_Reserved_ = null;
    public static final String BUILD_DATE = "Thu_Apr_04_15:09:24_PDT_2013";
    public static final boolean TRACE = false;

    public AQDequeueOptions() {
        this.attrDeqMode = AQDequeueOptions.DequeueMode.REMOVE;
        this.attrDeqMsgId = null;
        this.attrNavigation = AQDequeueOptions.NavigationOption.NEXT_MESSAGE;
        this.attrVisibility = AQDequeueOptions.VisibilityOption.ON_COMMIT;
        this.attrWait = -1;
        this.maxBufferLength = 67108787;
        this.attrDeliveryMode = AQDequeueOptions.DeliveryFilter.PERSISTENT;
        this.retrieveMsgId = false;
    }

    public void setConsumerName(String var1) throws SQLException {
        this.attrConsumerName = var1;
    }

    public String getConsumerName() {
        return this.attrConsumerName;
    }

    public void setCorrelation(String var1) throws SQLException {
        this.attrCorrelation = var1;
    }

    public String getCorrelation() {
        return this.attrCorrelation;
    }

    public void setDequeueMode(AQDequeueOptions.DequeueMode var1) throws SQLException {
        this.attrDeqMode = var1;
    }

    public AQDequeueOptions.DequeueMode getDequeueMode() {
        return this.attrDeqMode;
    }

    public void setDequeueMessageId(byte[] var1) throws SQLException {
        this.attrDeqMsgId = var1;
    }

    public byte[] getDequeueMessageId() {
        return this.attrDeqMsgId;
    }

    public void setNavigation(AQDequeueOptions.NavigationOption var1) throws SQLException {
        this.attrNavigation = var1;
    }

    public AQDequeueOptions.NavigationOption getNavigation() {
        return this.attrNavigation;
    }

    public void setVisibility(AQDequeueOptions.VisibilityOption var1) throws SQLException {
        this.attrVisibility = var1;
    }

    public AQDequeueOptions.VisibilityOption getVisibility() {
        return this.attrVisibility;
    }

    public void setWait(int var1) throws SQLException {
        this.attrWait = var1;
    }

    public int getWait() {
        return this.attrWait;
    }

    public void setMaximumBufferLength(int var1) throws SQLException {
        if (var1 > 0) {
            this.maxBufferLength = var1;
        }

    }

    public int getMaximumBufferLength() {
        return this.maxBufferLength;
    }

    public void setDeliveryFilter(AQDequeueOptions.DeliveryFilter var1) throws SQLException {
        this.attrDeliveryMode = var1;
    }

    public AQDequeueOptions.DeliveryFilter getDeliveryFilter() {
        return this.attrDeliveryMode;
    }

    public void setRetrieveMessageId(boolean var1) {
        this.retrieveMsgId = var1;
    }

    public boolean getRetrieveMessageId() {
        return this.retrieveMsgId;
    }

    public void setTransformation(String var1) {
        this.transformation = var1;
    }

    public String getTransformation() {
        return this.transformation;
    }

    public void setCondition(String var1) {
        this.condition = var1;
    }

    public String getCondition() {
        return this.condition;
    }

    public static enum DeliveryFilter {
        PERSISTENT(1),
        BUFFERED(2),
        PERSISTENT_OR_BUFFERED(3);

        private final int mode;

        private DeliveryFilter(int var3) {
            this.mode = var3;
        }

        public final int getCode() {
            return this.mode;
        }
    }

    public static enum VisibilityOption {
        ON_COMMIT(2),
        IMMEDIATE(1);

        private final int mode;

        private VisibilityOption(int var3) {
            this.mode = var3;
        }

        public final int getCode() {
            return this.mode;
        }
    }

    public static enum NavigationOption {
        FIRST_MESSAGE(1),
        NEXT_MESSAGE(3),
        NEXT_TRANSACTION(2);

        private final int mode;

        private NavigationOption(int var3) {
            this.mode = var3;
        }

        public final int getCode() {
            return this.mode;
        }
    }

    public static enum DequeueMode {
        BROWSE(1),
        LOCKED(2),
        REMOVE(3),
        REMOVE_NODATA(4);

        private final int mode;

        private DequeueMode(int var3) {
            this.mode = var3;
        }

        public final int getCode() {
            return this.mode;
        }
    }
}
